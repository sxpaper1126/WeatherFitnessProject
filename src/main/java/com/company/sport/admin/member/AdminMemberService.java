package com.company.sport.admin.member;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.company.sport.admin.member.AdminMemberVo;

@Service
public class AdminMemberService {

	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0;
	final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
	final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;

	@Autowired
	AdminMemberDao adminMemberDao;

	public int createAccountConfirm(AdminMemberVo adminMemberVo) {

		boolean isMember = adminMemberDao.isAdminMember(adminMemberVo.getA_m_id());

		if (!isMember) {
			int result = adminMemberDao.insertAdminAccount(adminMemberVo);

			if (result > 0) {
				return ADMIN_ACCOUNT_CREATE_SUCCESS;
			} else {
				return ADMIN_ACCOUNT_CREATE_FAIL;
			}
		} else {
			return ADMIN_ACCOUNT_ALREADY_EXIST;
		}
	}

	public AdminMemberVo loginConfirm(AdminMemberVo adminMemberVo) {

		AdminMemberVo loginedAdminMemberVo = adminMemberDao.selectAdmin(adminMemberVo);

		return loginedAdminMemberVo;
	}

	public List<AdminMemberVo> listupAdmin() {

		return adminMemberDao.selectAdmins();
	}

	public void setAdminApproval(int a_m_no) {

		int result = adminMemberDao.updateAdminAccount(a_m_no);
	}

	public int modifyAccountConfirm(AdminMemberVo adminMemberVo) {

		return adminMemberDao.updateAdminAccount(adminMemberVo);

	}

	public AdminMemberVo getLoginedAdminMemberVo(int a_m_no) {

		return adminMemberDao.selectAdmin(a_m_no);

	}

	public List<String> getRecommendedSports(AdminMemberSportVo adminMemberSportVo, Model model) {
		return adminMemberDao.getRecommendedSports(adminMemberSportVo,model);
	}

}
