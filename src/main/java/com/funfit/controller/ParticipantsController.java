package com.funfit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funfit.bean.Batch;
import com.funfit.bean.Participants;
import com.funfit.service.ParticipantsService;

/**
 * Servlet implementation class ParticipantsController
 */
@WebServlet("/ParticipantsController")
public class ParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ParticipantsService ps = new ParticipantsService();
    public ParticipantsController() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		String flagValue = request.getParameter("flag");
		if(flagValue.equals("1")) {
			List<Participants> listOfParticipants = ps.viewAllParticipants();
			hs.setAttribute("participants", listOfParticipants);
			response.sendRedirect("viewParticipants.jsp");
		} else {
			String participantid = request.getParameter("participantid");
			System.out.println(participantid);
			ps.deleteParticipant(Integer.parseInt(participantid));

			List<Participants> listOfParticipants2 = ps.viewAllParticipants();
			HttpSession hs2 = request.getSession();
			hs2.setAttribute("participants", listOfParticipants2);
			response.sendRedirect("viewParticipants.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String fname = request.getParameter("firstname");
		int age  = Integer.parseInt(request.getParameter("age"));
		String phonenumber = request.getParameter("phonenumber");
		int bid = Integer.parseInt(request.getParameter("batchid"));
		RequestDispatcher rd = request.getRequestDispatcher("addParticipants.jsp");
		Participants pp = new Participants();
		pp.setFirstName(fname);
		pp.setAge(age);
		pp.setPhoneNumber(phonenumber);
		pp.setBatchId(bid);
		
		String result = ps.addParticipants(pp);
		pw.print(result);
		rd.include(request, response);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}