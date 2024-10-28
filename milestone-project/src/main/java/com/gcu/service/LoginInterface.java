package com.gcu.service;

import com.gcu.model.LoginForm;

public interface LoginInterface {
	public boolean authenticate(LoginForm loginForm);
}
