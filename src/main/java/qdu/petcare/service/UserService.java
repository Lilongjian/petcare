package qdu.petcare.service;

import qdu.petcare.pojo.User;

public interface UserService {
	
	User getUser(String username,String password);

}
