package org.nlavee.skidmore.webapps.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nlavee.skidmore.webapps.database.beans.Message;
import org.nlavee.skidmore.webapps.database.dao.ObjMapping;
import org.nlavee.skidmore.webapps.database.interfaces.impl.NewsDBInterfaceImpl;
import org.nlavee.skidmore.webapps.database.interfaces.impl.WeatherDBInterfaceImpl;
import org.nlavee.skidmore.webapps.web.api.impl.WeatherAPIWrapper;

public class FetchDataServlet extends HttpServlet implements VarNames {

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
	private static Logger LOGGER = Logger.getLogger(FetchDataServlet.class);

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
	public FetchDataServlet() {
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

	private void controller(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fwdPath = REGISTER_JSP;
		if(req.getSession().getAttribute(USER_PARAM_FIELD_NAME).toString() != null)
		{
			String userName = req.getSession().getAttribute(USER_PARAM_FIELD_NAME).toString();
			int userId = getUserID(userName);
			fetchData(req, userId, userName);
			fwdPath = MAIN_JSP;
		}

		req.getRequestDispatcher(fwdPath).forward(req, resp);

	}

	private int getUserID(String userName) {
		ObjMapping om = new ObjMapping();
		return om.queryForID(userName);
	}

	private void fetchData(HttpServletRequest req, Integer userId, String userName) {
		ObjMapping om = new ObjMapping();
		fetchWeather(req,userId, om);
		fetchNews(req,userName, om);
		fetchMessage(req,userId, om);

	}

	private void fetchMessage(HttpServletRequest req, Integer userId,
			ObjMapping om) {
		Message m = om.getMessage(userId);
		req.setAttribute("message", m);
	}

	private void fetchNews(HttpServletRequest req, String userName, ObjMapping om) {
		NewsDBInterfaceImpl news = new NewsDBInterfaceImpl();
		ArrayList<String> section = news.getNewsTopic(userName);
		
	}

	private void fetchWeather(HttpServletRequest req, Integer userId,
			ObjMapping om) {
		WeatherDBInterfaceImpl weather = new WeatherDBInterfaceImpl();
		Integer zipcode = weather.getWeather(userId);
		
		WeatherAPIWrapper weatherAPI = new WeatherAPIWrapper();
		JSONObject weatherJson = weatherAPI.getWeather(zipcode);
		
		// general description
		JSONArray weatherMain = weatherJson.getJSONArray("weather");
		JSONObject weatherJsonWithMain = weatherMain.getJSONObject(0);
		String desc = weatherJsonWithMain.getString("description");
		
		// temperature 
		JSONObject weatherJSONTemp = weatherJson.getJSONObject("main");
		int temperature = weatherJSONTemp.getInt("temp");
		int humidity = weatherJSONTemp.getInt("humidity");
		
		// wind
		JSONObject windJSON = weatherJson.getJSONObject("wind");
		int wind = windJSON.getInt("speed");
		
		// place
		String place = weatherJson.getString("name");
		
		req.setAttribute(WEATHER, weatherJson);
		req.setAttribute("weather_description", desc);
		req.setAttribute("temp", temperature);
		req.setAttribute("humidity", humidity);
		req.setAttribute("wind", wind);
		req.setAttribute("place", place);
	}
}