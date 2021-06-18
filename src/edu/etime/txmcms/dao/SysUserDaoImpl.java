package edu.etime.txmcms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.etime.txmcms.common.DbHelper;
import edu.etime.txmcms.dto.SysRightDto;
import edu.etime.txmcms.pojo.SysUser;

public class SysUserDaoImpl implements SysUserDao{
	/**
	 * 查询所有用户
	 * @param user
	 * @param keyword
	 * @return
	 */
	public List<SysUser> selectSysUser(SysUser user,int cpage,int count,String keyword){
		String sql = "select userid,roleid,username,userpwd,"
				+ "usertruename,usersex,userstate from sysuser where 0=0";
		List<Object> params = new ArrayList<>();
		/*
		 * if(keyword!=null) {
			sql="select * from sysuser where username "
				+ "like ? order by username desc limit ?,?";
			params.add(1, "%"+keyword+"%");
			params.add(2,(cpage-1)*count);
			params.add(3,count);
		}else {
			sql = "select * from sysuser order by "
					+ "username desc limit ?,?";
			params.add(1, (cpage-1)*count);
			params.add(2,count);
			}
		 */
		if (user.getUserstate() != null && user.getUserstate() != 1) {
			sql += " and userstate=?";
			params.add(user.getUserstate());
		}
		if (user != null && user.getUsername() != null && !user.getUsername().equals("")) {
			sql += " and username like ?";
			params.add("%" + user.getUsername() + "%");
		}
		if (params.size() > 0) {
			return DbHelper.executeQuery(sql, SysUser.class, params.toArray());
		} else {
			return DbHelper.executeQuery(sql, SysUser.class);
		}
	}
	@Override
	public List<SysRightDto> selectRightList(String userid) {
		// TODO Auto-generated method stub
		String sql = "select a.funid,funname,funpid,b.userid from sysfunction a "
				+ " left outer join sysright b on a.funid=b.funid "
				+ " and b.roleid=? "
				+ " where a.funstate=1";
		return DbHelper.executeQuery(sql, SysRightDto.class, userid);
	}
	public int deleteRgihtByUserid(String userid){
		String sql = "delete from sysright where userid=?";
		return DbHelper.executeUpdate(sql, userid);
	}
	public int insertRight(String roleid,String funid){
		String sql = "insert into sysright(rightid,roleid,funid) values(?,?,?)";
		return DbHelper.executeUpdate(sql, UUID.randomUUID().toString(),roleid,funid);
	}
	public SysUser selectSysUserById(String id) {
		String sql = "select userid,roleid,username,userpwd,"
				+ "usertruename,usersex,userstate from sysuser where userid=?";
		List<SysUser> list = DbHelper.executeQuery(sql, SysUser.class,id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	public int updateSysUser(SysUser user) {
		String sql = "update sysuser set usertruename=?,usersex=?,userstate=? where username=?";
		return DbHelper.executeUpdate(sql,user.getUsertruename(),
				user.getUsersex(),user.getUserstate(),user.getUsername());
	}
	public int insert(SysUser user) {
		String sql = "insert into sysuser(userid,roleid,username,userpwd,"
				+ "usertruename,usersex,userstate) values(?,?,?,?,?,?,?);";
		Integer rtn = DbHelper.executeUpdate(sql, user.getUserid(),user.getRoleid(),user.getUsername(),
				user.getUserpwd(),user.getUsertruename(),user.getUsersex(),user.getUserstate());
		return rtn;
	}
	@Override
	public int delete(String id) {
		String sql = "delete from sysuser where userid = ? and userstate=1";
		Object[] param = {id};
		return DbHelper.executeUpdate(sql,param);
	}
	/**
	 * 获取总记录数和总页数
	 * @param count
	 * @param keyword
	 * @return
	 */
	public int[] totalPage(int count, String keyword) {
		//0总记录数,1页数
		int arr[] = {0,1};
		String sql = "";
		List<Object> param = new ArrayList<>();
		if(keyword!=null) {
			sql = "select count(*) from sysuser where username like = ?";
			param.add(1,"%" + keyword + "%");
		}else {
			sql = "select count(*) from sysuser";
		}if(arr[0]%count==0) {
			arr[1] = arr[0]/count;
		}else {
			arr[1] = arr[0]/count+1;
		}
		return arr;
	}
	
}
