package edu.etime.txmcms.services;

import java.util.List;

import edu.etime.txmcms.dto.SysRightDto;
import edu.etime.txmcms.pojo.Pager;
import edu.etime.txmcms.pojo.SysUser;

public interface SysUserService {
	List<SysUser> selectSysUser(SysUser user, int cpage, int count, String keyword);
	List<SysRightDto> selectRightList(String userid);
	public void saveUserRight(String userid, String[] roleids);
	public SysUser selectSysUserById(String name);
	public int updateSysUser(SysUser user);
	int insert(SysUser userid);
	int delete(String id);
	int[] totalPage(int count, String keyword);
}