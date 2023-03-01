package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet({ "/ThreadDemoServlet", "/tds" })
public class ThreadDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = LogManager.getLogger();


	private int contatore = 0;

	public void init(ServletConfig config) throws ServletException {
		log.trace("init attivata");
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("doGet attivata");
		response.getWriter().append(String.format("Contatore:%s", contatore));
		this.contatore++;
	}

}