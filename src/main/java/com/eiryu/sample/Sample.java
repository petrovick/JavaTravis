package com.eiryu.sample;

import java.net.UnknownHostException;
import java.util.List;

import com.business.User;
import com.service.UsuarioService;

public class Sample {

	public static void main(String... args)
	{
		UsuarioService us = new UsuarioService();
		try
		{
			List<User> users = us.todos();
			User u = new User();
			u.setEmployee(true);
			u.setName("Petrovick Pet Vick Santos");
			u.setRole("normal");
			String erro = us.create(u);
			
			User uu = us.obter(u.get_id());
			uu.setName("Petrovick Gabriel");
			User uuu = us.update(uu);
			//u.main();
		}
		catch (UnknownHostException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public static int sum(int a, int b) {
		return a + b;
	}
	
}
