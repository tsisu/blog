package edu.etime.txmcms.servlets;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.etime.txmcms.pojo.Constants;
import edu.etime.txmcms.pojo.Pager;
import edu.etime.txmcms.pojo.SysRole;
import edu.etime.txmcms.pojo.SysUser;
import edu.etime.txmcms.services.SysRoleService;
import edu.etime.txmcms.services.SysRoleServiceImpl;
import edu.etime.txmcms.services.SysUserService;
import edu.etime.txmcms.services.SysUserServiceImpl;

@WebServlet("/admin/user")
public class SysUserservlet extends HttpServlet {
	private SysUserService service = new SysUserServiceImpl();
	private SysRoleService sysRoleService = new SysRoleServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("cmd") != null) {
			String cmd = request.getParameter("cmd");
			if (cmd.equals("list")) {
				list(request, response);
			} else if (cmd.equals("init")) {
				init(request, response);
			} else if (cmd.equals("edit")) {
				edit(request, response);
			}else if (cmd.equals("add")) {
				add(request, response);
			}else if (cmd.equals("toadd")) {
				toadd(request, response);
			}else if(cmd.equals("sub")){
				sub(request,response);
			}
		}
	}
	
	
	private void sub(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		// 加入到数据库的用户表中
		int count = service.delete(id);
		if (count > 0) {
			response.sendRedirect("list?cp=" + request.getParameter("cpage"));
		}else {
			request.setAttribute("msg", "初始化页面失败");
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
		}
		String ids[] = request.getParameterValues(("id[]"));
		for(int i = 0;i<ids.length;i++) {
			service.delete(ids[i]);
			}
			response.sendRedirect("/admin/user/list.jsp");
			
		}
	private void toadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1、组织查询条件：typeid=1
		SysRole role = new SysRole();
		role.setRolestate(1);
		// 2、查询
		List<SysRole> sysrolelist = sysRoleService.selectSysRole(role);
		// 3、增加到转发页面
		request.setAttribute("sysrolelist", sysrolelist);
		request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//创建用户实体
		SysUser user = new SysUser();
		user.setUserid(UUID.randomUUID().toString());
		user.setRoleid(request.getParameter("roleid"));
		user.setUsername(request.getParameter("username"));
		user.setUserpwd(request.getParameter("userpwd"));
		user.setUsertruename(request.getParameter("usertruename"));
		user.setUsersex(request.getParameter("usersex"));
		user.setUserstate(1);
		//加入到数据库的用户表中
		int count = service.insert(user);
		if(count>0) {
			response.sendRedirect(request.getContextPath()+"/admin/user?cmd=list");
		}else {
			request.setAttribute("msg", "初始化页面失败");
			request.getRequestDispatcher("/admin/user/add.jsp").forward(request, response);
		}
	}
	

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String roleid = request.getParameter("roleid");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String usertruename = request.getParameter("usertruename");
		String usersex = request.getParameter("usersex");
		Integer userstate = Integer.parseInt(request.getParameter("userstate"));
		//修改文章页面参数
		SysUser user = new SysUser();
		user.setUserid(userid);
		user.setRoleid(roleid);
		user.setUsername(username);
		user.setUserpwd(userpwd);
		user.setUsertruename(usertruename);
		user.setUsersex(usersex);
		user.setUserstate(userstate);
		//调用service方法进行修改
		int rtn = service.updateSysUser(user);
		if (rtn > 0) {
			//直接跳转到list页面(重定向到list页面--list这个servlet)
			response.sendRedirect(request.getContextPath()+"/admin/user?cmd=list");
		}else {
			request.setAttribute("msg", "初始化页面失败");
			request.getRequestDispatcher("/admin/user/edit.jsp").forward(request, response);
		}
	}
	

	private void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SysRole role = new SysRole();
		role.setRolestate(1);
		List<SysRole> list = sysRoleService.selectSysRole(role);
		String id = request.getParameter("id");
		SysUser user = service.selectSysUserById(id);
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));
		request.getRequestDispatcher("/admin/user/edit.jsp").forward(request, response);
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		//获取request参数
//				String username = request.getParameter("username");
//				
//				String usersex = Constants.DEFAULT_GENDER;
//				String genderStr = request.getParameter("usersex");
//				if(genderStr!=null&& !"".equals(genderStr)){
//					 usersex = request.getParameter(genderStr);
//				}
//				int pageSize = Constants.DEFAULT_PAGESIZE;
//				String pageSizeStr = request.getParameter("pageSize");
//				if(pageSizeStr!=null&& !"".equals(pageSizeStr)){
//					pageSize = Integer.parseInt(pageSizeStr);
//				}
//				int pageNum = Constants.DEFAULT_PAGENUM;
//				String pageNumStr = request.getParameter("pageNum");
//				if(pageNumStr!=null&& !"".equals(pageNumStr)){
//					pageNum = Integer.parseInt(pageNumStr);
//				}
//				//组装查询条件
//				SysUser user = new SysUser();
//				user.setUsername(username);
//				user.setUsersex(usersex);
//				//调用service查询
//				Pager<SysUser> result = service.selectSysUser(user, pageNum, pageSize);
//				//返回结果
//				request.setAttribute("result", result);
//				request.getRequestDispatcher("pagination.jsp").forward(request, response);
//			}
//}
		SysUser user = new SysUser();
		if (request.getParameter("username") != null && request.getParameter("userstate") != null) {
			String username = request.getParameter("username");
			Integer userstate = Integer.parseInt(request.getParameter("userstate"));
			user.setUsername(username);
			user.setUserstate(userstate);
		}
		int cpage = 1;//当前页
		int count = 5;//每页显示条数
		//获取用户指定的页面
		String cp = request.getParameter("cp");
		
		//接收用户搜索的关键字
		String keyword = request.getParameter("keywords");
		
		if(cp!=null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = service.totalPage(count,keyword);
		// 调用service中的方法获取查询结果
		List<SysUser> list = service.selectSysUser(user,cpage,count,keyword);
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		if(keyword!=null) {
			request.setAttribute("searchParam", "&keywords="+keyword);
		}
		// 将查询结果通过request对象转发到list页面
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/user/list.jsp").forward(request, response);
	}
	
}