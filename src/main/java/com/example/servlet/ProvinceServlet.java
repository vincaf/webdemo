package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.dao.DAO;
import com.example.database.dao.ProvinceJpaDAO;
import com.example.database.entity.Provincia;

/**
 * Servlet implementation class GetProvince
 */
@WebServlet(
  description = "Restituisce i dati delle province",
  urlPatterns = {
    "/ProvinceServlet",
    "/ps"
  })
public class ProvinceServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private static Logger log =LogManager.getLogger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlet() {
        super();
        log.trace("Attivazione del costruttore GetProvince da parte del container...");
    }

 /**
  * @see Servlet#init(ServletConfig)
  */
 public void init(ServletConfig config) throws ServletException {
  log.trace("Attivazione del init() da pòarte del container...");
  super.init(config);
 }

 /**
  * @see Servlet#destroy()
  */
 public void destroy() {
  log.trace("Attivazione del destroy() da pòarte del container...");
 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //response.getWriter().append("Served at: ").append(request.getContextPath());
  log.trace("Attivazione del doGet() da parte del container...");

  DAO<Provincia, Integer> dao = new ProvinceJpaDAO();
  List<Provincia> province = dao.findAll();

//  response.getWriter().append("Dati province<br>");
//  province.forEach(provincia -> {
//	  try {
//		response.getWriter()
//			.append(provincia.toString())
//			.append("<br>");
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//  });

  request.setAttribute("lista.province", province); // push dei parametri alla jsp
  RequestDispatcher rd = request.getRequestDispatcher("province.jsp");
  rd.forward(request, response); // il servlet non può più scrivere sul response

 }

}



