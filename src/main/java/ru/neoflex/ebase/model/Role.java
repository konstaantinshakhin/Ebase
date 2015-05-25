package ru.neoflex.ebase.model;

/**
 * Created by kshahin on 5/25/2015.
 */
public class Role {
    private Long id;
    private String login;
    private String name;


    public Role(long id, String login,String name) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String toString(){
        return " login: "+login+" name: "+name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
