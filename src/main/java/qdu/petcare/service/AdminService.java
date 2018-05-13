package qdu.petcare.service;

import qdu.petcare.pojo.Admin;

public interface AdminService {
	
	Admin getAdmin(String adminname, String password);

}
