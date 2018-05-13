package qdu.petcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import qdu.petcare.dao.AdminMapper;
import qdu.petcare.pojo.Admin;
import qdu.petcare.service.AdminService;

public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin getAdmin(String adminname, String password) {
		return adminMapper.getAdmin(adminname,password);
	}

}
