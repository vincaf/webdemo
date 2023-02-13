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

import com.example.database.dao.ClientiJpaDAO;
import com.example.database.dao.DAO;
import com.example.database.dao.ProvinceJpaDAO;
import com.example.database.entity.Cliente;
import com.example.database.entity.Provincia;

/**
 * Servlet implementation class GetProvince
 */
@WebServlet(
  description = "Restituisce i dati dei clienti",
  urlPatterns = {
    "/ClientiServlet",
    "/cs"
  })
public class ClientiServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private static Logger log =LogManager.getLogger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientiServlet() {
        super();
        log.trace("Attivazione del costruttore GetClienti da parte del container...");
    }

 /**
  * @see Servlet#init(ServletConfig)
  */
 public void init(ServletConfig config) throws ServletException {
  log.trace("Attivazione del init() da parte del container...");
  super.init(config);
 }

 /**
  * @see Servlet#destroy()
  */
 public void destroy() {
  log.trace("Attivazione del destroy() da parte del container...");
 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  log.trace("Attivazione del doGet() da parte del container...");

  DAO<Cliente, Integer> dao = new ClientiJpaDAO();
  List<Cliente> clienti = dao.findAll();

  request.setAttribute("lista.clienti", clienti);
  RequestDispatcher rd = request.getRequestDispatcher("clienti.jsp");
  rd.forward(request, response);

 }

}



