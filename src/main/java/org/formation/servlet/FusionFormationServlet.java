package org.formation.servlet;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.formation.bean.FormationBean;
import org.formation.bean.FusionBean;
import org.formation.model.Formation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

@WebServlet("/FusionFormation")
public class FusionFormationServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {
		List<Formation> formationsFusionnees = FusionBean.selectFormationsFusionnees();
		request.setAttribute("formationsFusionnees",formationsFusionnees);
		request.getRequestDispatcher("/formations/FusionFormation.jsp").forward(request, resp);
	}
}