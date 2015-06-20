package com.business;

import org.bson.types.ObjectId;

public class User {
	private ObjectId _id;
    private String name; 
    private String role;
    private boolean isEmployee;
     
    public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isEmployee() {
        return isEmployee;
    }
    public void setEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }
}
