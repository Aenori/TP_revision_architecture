package org.formation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import org.formation.bean.FormationBean;
import org.formation.model.Formation;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FormationAjax")
public class FormationAjaxServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		String date = request.getParameter("date");
		String nomSujet = request.getParameter("sujet");
		String nomFormateur = request.getParameter("formateur");
		String paieFormateur = request.getParameter("paieFormateur");
		
		Formation newFormation = FormationBean.addNewFormation(date, nomSujet, nomFormateur, paieFormateur); 
	
		String formationJsonString = this.gson.toJson(newFormation);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(formationJsonString);
        out.flush();   
	}
}
