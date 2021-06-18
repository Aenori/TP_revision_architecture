package org.formation.servlet;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.formation.bean.FormationBean;
import org.formation.model.Formateur;
import org.formation.model.Formation;
import org.formation.model.Sujet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

@WebServlet("/Formation")
public class FormationServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		List<Formation> formations = Formation.getAll();
		request.setAttribute("formations", formations);

		request.getRequestDispatcher("/formations/Formation.jsp").forward(request, resp);
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		String date = request.getParameter("date");
		String nomSujet = request.getParameter("sujet");
		String nomFormateur = request.getParameter("formateur");
		String paieFormateur = request.getParameter("paieFormateur");
		
		FormationBean.addNewFormation(date, nomSujet, nomFormateur, paieFormateur);	
	}
}
