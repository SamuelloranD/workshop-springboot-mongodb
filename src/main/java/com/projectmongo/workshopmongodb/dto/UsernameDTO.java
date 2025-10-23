package com.projectmongo.workshopmongodb.dto;

import com.projectmongo.workshopmongodb.domain.User;

public class UsernameDTO {

    private String name;

    public UsernameDTO() {
    }

    public UsernameDTO (User obj) {
        name = obj.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
