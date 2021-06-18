package edu.etime.txmcms.services;

import java.util.List;

import edu.etime.txmcms.dao.SysUserDaoImpl;
import edu.etime.txmcms.dto.SysRightDto;
import edu.etime.txmcms.pojo.Pager;
import edu.etime.txmcms.pojo.SysUser;

public class SysUserServiceImpl implements SysUserService {
	private SysUserDaoImpl dao = new SysUserDaoImpl();

	@Override
	public List<SysUser> selectSysUser(SysUser user,int cpage,int count,String keyword) {
		// TODO Auto-generated method stub
		return dao.selectSysUser(user,cpage,count,keyword);
	}

	@Override
	public List<SysRightDto> selectRightList(String userid) {
		// TODO Auto-generated method stub
		return dao.selectRightList(userid);
	}

	@Override
	public void saveUserRight(String userid, String[] roleids) {
		// TODO Auto-generated method stub
		dao.deleteRgihtByUserid(userid);
		for(String roleid:roleids){
			dao.insertRight(roleid, roleid);
		}
		return;
	}

	@Override
	public SysUser selectSysUserById(String name) {
		// TODO Auto-generated method stub
		return dao.selectSysUserById(name);
	}

	@Override
	public int updateSysUser(SysUser user) {
		// TODO Auto-generated method stub
		return dao.updateSysUser(user);
	}

	@Override
	public int insert(SysUser user) {
		// TODO Auto-generated method stub
		return dao.insert(user);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int[] totalPage(int count, String keyword) {
		// TODO Auto-generated method stub
		return dao.totalPage(count,keyword);
	}
}
