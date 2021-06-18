package edu.etime.txmcms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.etime.txmcms.dto.ArtManageDto;
import edu.etime.txmcms.pojo.ArtType;
import edu.etime.txmcms.services.WebArtService;
import edu.etime.txmcms.services.WebArtServiceImpl;
@WebServlet("/web/page")
public class WebArtServlet extends HttpServlet {
	private WebArtService service = new WebArtServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("cmd")!=null) {
			String cmd = request.getParameter("cmd");
			if(cmd.equals("index")) {
				index(request,response);
			}
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ArtType> artTypeList = service.selectArtTypeByUsed();
//		List<ArtManageDto> artManageList = service.selectArtList(art,count);
	}
}
