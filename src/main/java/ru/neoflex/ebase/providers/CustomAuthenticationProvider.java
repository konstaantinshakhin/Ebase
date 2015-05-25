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

        import ru.neoflex.ebase.dao.CustomerDAO;
        import ru.neoflex.ebase.model.Customer;
        import ru.neoflex.ebase.model.Role;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private CustomerDAO customerDAO;

    public CustomAuthenticationProvider() {
        super();
    }

    public CustomAuthenticationProvider(CustomerDAO customerDAO) {
        super();
        this.customerDAO = customerDAO;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        //String password = String.valueOf(personDAO.getSHA256(authentication.getCredentials().toString()));
        String password = authentication.getCredentials().toString();
        Customer customer = customerDAO.getByLogin(name);
        List<Role> roles = customer.getRoles();

        if (customer == null) {
            return null;
        }

        if (name.equals(customer.getLogin())
                && password.equals(customer.getPassword())) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            for(Role role:roles){
                grantedAuths.add(new SimpleGrantedAuthority(role.getName()));
            }
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

