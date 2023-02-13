package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(
		description = "Servlet per il test del funzionamento della web application", 
		urlPatterns = { 
				"/HelloServlet", 
				"/hs"
		}, 
		initParams = { 
				@WebInitParam(name = "message.it", value = "Ciao Mondo", description = "Messaggio in italiano"), 
				@WebInitParam(name = "messaggio.en", value = "Hello World", description = "Messaggio in inglese"), 
				@WebInitParam(name = "message.es", value = "Hola mundo", description = "Messaggio in spagnolo")
		})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        log.trace("Attivazione costruttore di HelloServlet da parte del web container...");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
        log.trace("Attivazione init() di HelloServlet da parte del web container!");
        
        // se si ridefinisce init, è obbligatorio completarla con super.init(config)
        super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
        log.trace("Attivazione destroy() di HelloServlet da parte del web container...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("Attivazione doGet(request, response) di HelloServlet da parte del web container...");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
        String msg = getInitParameter("message.it");
        response.getWriter().append(msg);
	}	

}
