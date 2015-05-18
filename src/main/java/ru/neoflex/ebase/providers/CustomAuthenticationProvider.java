package ru.neoflex.ebase.providers;

/**
 * Created by kshahin on 5/18/2015.
 */


        import java.util.ArrayList;
        import java.util.List;

        import org.springframework.security.authentication.AuthenticationProvider;
        import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.AuthenticationException;
        import org.springframework.security.core.GrantedAuthority;
        import org.springframework.security.core.authority.SimpleGrantedAuthority;
        import org.springframework.stereotype.Component;

        import ru.neoflex.ebase.model.Person;
        import ru.neoflex.ebase.dao.PersonDAO;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private PersonDAO personDAO;

    public CustomAuthenticationProvider() {
        super();
    }

    public CustomAuthenticationProvider(PersonDAO personDAO) {
        super();
        this.personDAO = personDAO;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        //String password = String.valueOf(personDAO.getSHA256(authentication.getCredentials().toString()));
        String password = authentication.getCredentials().toString();
        Person person = personDAO.getByLogin(name);

        if (person == null) {
            return null;
        }

        if (name.equals(person.getLogin())
                && password.equals(person.getPassword())) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();

            grantedAuths.add(new SimpleGrantedAuthority(person.getRole()));
            //grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            Authentication auth = new UsernamePasswordAuthenticationToken(name,
                    password, grantedAuths);
            return auth;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}

