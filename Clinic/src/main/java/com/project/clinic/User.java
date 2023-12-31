package com.project.clinic;
public abstract class User
{
    private int id;
    private String password;
    private String name;
    private String surname;
    private String email;

    public User(int id, String password, String name, String surname,String email)
    {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }
}