package startup_registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import startup_registration.model.IdeationTable;
import startup_registration.service.GetAll_Ideation_service;
@WebServlet("/CheckStartupName_without_own")
public class CheckStartupName_without_own extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("here");
        String startupname = request.getParameter("startupname");
        HttpSession session = request.getSession();
		IdeationTable ideationT = (IdeationTable) session.getAttribute("ideationT");		
        boolean isTaken = GetAll_Ideation_service.isStartupNameTaken_without_own(startupname,ideationT.getIdeanumber());
        System.out.println("isTaken "+isTaken);
        if(isTaken) {
            response.getWriter().write("taken");
        } else {
            response.getWriter().write("available");
        }
    }
}
