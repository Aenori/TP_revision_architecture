package org.formation.servlet;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

@WebServlet("/Remboursement")
public class RemboursementServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		request.getRequestDispatcher("/formations/Remboursement.jsp").forward(request, resp);
	}
}