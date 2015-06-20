package com.Utils;

import com.business.User;
import com.google.gson.Gson;

public class Helper
{
	public static User toObject(String json)
	{
		Gson gson = new Gson();
		return gson.fromJson(json, User.class);
	}

}
