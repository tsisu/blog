package edu.etime.txmcms.dao;

import java.util.List;

import edu.etime.txmcms.dto.SysRightDto;
import edu.etime.txmcms.pojo.SysUser;

public interface SysUserDao {
	public List<SysUser> selectSysUser(SysUser user,int cpage,int count,String keyword);
	public List<SysRightDto> selectRightList(String userid);
	public int deleteRgihtByUserid(String userid);
	public SysUser selectSysUserById(String name);
	public int updateSysUser(SysUser user);
	int delete(String id);
}
