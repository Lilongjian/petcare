package qdu.petcare.dao;

import qdu.petcare.pojo.Admin;

public interface AdminMapper {
	
	Admin getAdmin(String adminname, String password);

}
