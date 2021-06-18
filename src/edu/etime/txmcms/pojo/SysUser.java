package edu.etime.txmcms.pojo;

public class SysUser {
	private String userid;
	private String roleid;
	private String username;
	private String userpwd;
	private String usertruename;
	private String usersex;
	private Integer userstate;
	
	public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SysUser(String userid, String roleid, String username, String userpwd, String usertruename, String usersex,
			Integer userstate) {
		super();
		this.userid = userid;
		this.roleid = roleid;
		this.username = username;
		this.userpwd = userpwd;
		this.usertruename = usertruename;
		this.usersex = usersex;
		this.userstate = userstate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsertruename() {
		return usertruename;
	}
	public void setUsertruename(String usertruename) {
		this.usertruename = usertruename;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public Integer getUserstate() {
		return userstate;
	}
	public void setUserstate(Integer userstate) {
		this.userstate = userstate;
	}
	
}
