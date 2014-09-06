package jxau.spms.login.service;

import java.util.Map;

import jxau.spms.exception.UnusualParamsException;


public interface LoginService {

	public Map<String, String> identifyUser(int role,Map<String, Object> params) throws UnusualParamsException;
	
}
