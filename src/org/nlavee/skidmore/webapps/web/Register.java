package org.nlavee.skidmore.webapps.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.nlavee.skidmore.webapps.database.dao.ObjMapping;

public class Register extends HttpServlet implements VarNames {
	/**
	 * The internal version id of this class
	 */
	private static final long serialVersionUID = 19620501L;

	/**
	 * Servlet version
	 */
	private static final String VERSION = "01.00.00";

	/**
	 * Logger Instance
	 */
	private static Logger LOGGER = Logger.getLogger(Register.class);

	/**
	 * Called by container when servlet instance is created. This method sets-up
	 * the logger and DB connection properties.
	 *
	 * @param config
	 *            The servlet configuration
	 */
	public void init(ServletConfig config) {
		LOGGER.warn("Servlet init.  Version: " + VERSION);
	}

	/**
	 * The constructor - no operations carried out here
	 */
	public Register() {
	}

	/**
	 * This method just redirect get request back to the
	 * initial form now
	 *
	 * @see #controller
	 *
	 * @param req
	 *            The request
	 * @param resp
	 *            The response
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOGGER.info("GET request sent to servlet");
		controller(req,resp);
	}

	/**
	 * This method calls the controller method
	 *
	 * @see #controller
	 *
	 * @param req
	 *            The request
	 * @param resp
	 *            The response
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		controller(req, resp);
	}

	/**
	 * This method (controller) determines the requested mode and sets-up the
	 * proper beans (model) before forwarding to the appropriate JSP (view).
	 *
	 * @param req
	 *            The request
	 * @param resp
	 *            The response
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	private void controller(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String remoteAdd = req.getRemoteAddr();
		String forwardPath = REGISTER_JSP;
		String associatedUser = checkRemoteAddress(remoteAdd);
		
		if(associatedUser != null)
		{
			req.getSession().setAttribute(USER_PARAM_FIELD_NAME, associatedUser);
			forwardPath = FETCH_DATA_SERVLET;
		}
		else 
		{
			req.getSession().setAttribute(REMOTE_ADDRESS, remoteAdd);
		}
		req.getRequestDispatcher(forwardPath).forward(req, resp);
	}

	private String checkRemoteAddress(String remoteAdd) {
		ObjMapping om = new ObjMapping();
		return om.getUserName(remoteAdd);
	}
}
