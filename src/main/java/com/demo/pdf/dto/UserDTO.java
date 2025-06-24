package com.demo.pdf.dto;

public class UserDTO
{
    private String firstName;
    private String lastName;
    private Long uid;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public Long getUid()
    {
        return uid;
    }

    public void setUid(final Long uid)
    {
        this.uid = uid;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }
}