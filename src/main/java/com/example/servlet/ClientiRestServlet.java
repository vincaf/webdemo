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
import org.apache.logging.log4j.core.jackson.Log4jJsonObjectMapper;

import com.example.database.dao.ClientiJpaDAO;
import com.example.database.dao.DAO;
import com.example.database.entity.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;




/**
 * Servlet implementation class ClientiServlet
 */
@WebServlet(description = "Servlet che ritorna l'elenco dei clienti tramite una Jsp dedicata", urlPatterns = { "/ClientiRestServlet" })
public class ClientiRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientiRestServlet() {
    	super();
        log.trace("Attivazione  costruttore di ClientiServlet da parte del web container ...");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		log.trace("Attivazione init() di ClientiServlet ");
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		log.trace("Attivazione destroy() di ClientiServlet ");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("Attivazione doGet() di ClientiServlet");
		DAO<Cliente, Integer> dao = new ClientiJpaDAO();
		List<Cliente> clienti = dao.findAll();

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(clienti); // converte la List in json
		response.getWriter().append(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("Attivazione doPost()  ...");

//		String nome = req.getParameter("nome");
//		String cognome = req.getParameter("cognome");
//		String email = req.getParameter("email");
//		String indirizzo = req.getParameter("indirizzo");
//		String citta = req.getParameter("citta");
//		String cap = req.getParameter("cap");
//		String provincia = req.getParameter("provincia");
//
//		log.debug("{}  {}  {}  {}  {}  {}  {}", nome, cognome, email, indirizzo, citta, cap, provincia);
//
//		ClientiJpaDAO dao = new ClientiJpaDAO();
//		Cliente cliente = Cliente.createCliente(nome, cognome, email, indirizzo, citta, cap, provincia);
//		log.debug(cliente);
//		Cliente clienteAggiunto = dao.create(cliente);
//		log.debug(clienteAggiunto);

		doGet(req, resp);

	}

}