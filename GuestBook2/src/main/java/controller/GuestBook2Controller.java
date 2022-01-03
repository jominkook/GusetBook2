package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestBook2Dao;
import dao.GuestBook2DaoImpl;
import vo.GuestBook2Vo;


@WebServlet("/gb")
public class GuestBook2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GuestBook2Controller() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
	

	   String actionName = request.getParameter("a");
	   
	   if("deleteform".equals(actionName)) {
		   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
           rd.forward(request, response);
	   }
	   
	   else if("add".equals(actionName)) {
		   
	       request.setCharacterEncoding("UTF-8");
	       //int no = Integer.parseInt(request.getParameter("no"));
	       
	       String name = request.getParameter("name");
	       String password = request.getParameter("password");
	       String content = request.getParameter("content");

	       GuestBook2Vo gvo = new GuestBook2Vo();
	       gvo.setName(name);
	       gvo.setPassword(password);
	       gvo.setContent(content);
	       
	       GuestBook2Dao dao = new GuestBook2DaoImpl();
	       if(dao.insert(gvo)) {
	    	   response.sendRedirect("/GuestBook2/gb");
	       }
	       
	   }
	   else if("delete".equals(actionName)) {
		   request.setCharacterEncoding("utf-8");
		   
		   int no = Integer.parseInt(request.getParameter("no"));
		   String password = request.getParameter("password");
		   GuestBook2Vo gvo = new GuestBook2Vo();
		   gvo.setNo(no);
		   gvo.setPassword(password);
		   GuestBook2Dao dao = new GuestBook2DaoImpl();
		   if(dao.delete(gvo)) {
			   response.sendRedirect("/GuestBook2/gb");
		   }
		   
	  }
	  else {
		  GuestBook2Dao dao = new GuestBook2DaoImpl();
	  
		List<GuestBook2Vo> list = dao.getlist();
		
		request.setAttribute("list", list);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(request, response);
		
	  }

	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	 }

}
