package com.acilia.ttschool.model;

public enum Role {
	ADMIN("ROLE_ADMIN"),
	TEACHER("ROLE_TEACHER"),
	TUTOR("ROLE_TUTOR"),
	STUDENT("ROLE_STUDENT");
	
	private String name;
    
    private Role(String name){
        this.name=name;
    }

    public String getRole() {
        return name;
    }
}
