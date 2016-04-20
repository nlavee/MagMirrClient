package org.nlavee.skidmore.webapps.web.api.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.nlavee.skidmore.webapps.database.beans.Coords;
import org.nlavee.skidmore.webapps.web.APIKEYS;
import org.nlavee.skidmore.webapps.web.api.LyftInterface;

public class LyftAPIWrapper implements LyftInterface, APIKEYS{

	/**
	 * Logger Instance
	 */
	private static Logger LOGGER = Logger.getLogger(LyftAPIWrapper.class);

	@Override
	public JSONObject authenticate() {
		StringBuilder res = new StringBuilder();

		try {

			String urlLocation = "https://api.lyft.com/oauth/token";

			URL obj = new URL(urlLocation);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);

			conn.setRequestMethod("POST");

			// TODO: CHANGED FROM SANDBOX PRODUCTION IF DEPLOYED
			String userpass = LYFT_CLIENT_ID + ":SANDBOX-" + LYFT_CLIENT_SECRET;
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
			conn.setRequestProperty ("Authorization", basicAuth);

			String data =  "{\"grant_type\":\"client_credentials\",\"scope\":\"public\"}";
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			out.write(data);
			out.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			LOGGER.info("Output from Lyft API .... \n");
			while ((output = br.readLine()) != null) {
				res.append(output);
				LOGGER.info(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		JSONObject jsonObj = new JSONObject(res.toString());

		return jsonObj;
	}


	private String parseForAccessToken(JSONObject accessTokenJSON) {
		return accessTokenJSON.getString("access_token");
	}
	
	@Override
	public JSONObject getRideType(Coords coord, JSONObject accessTokenJSON) {
		String accessToken = parseForAccessToken(accessTokenJSON);

		/*
		 * Make request 
		 */
		StringBuilder res = new StringBuilder();

		try {
			String urlLocation = "https://api.lyft.com/v1/ridetypes?lat="+ coord.getLat() +"&lng=" + coord.getLon();

			URL obj = new URL(urlLocation);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setDoOutput(true);

			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			LOGGER.info("Output from Lyft API for get Ride Type .... \n");
			while ((output = br.readLine()) != null) {
				res.append(output);
				LOGGER.info(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		JSONObject jsonObj = new JSONObject(res.toString());

		return jsonObj;

	}

	@Override
	public JSONObject getETA(Coords coord, JSONObject accessTokenJSON) {
		String accessToken = parseForAccessToken(accessTokenJSON);

		/*
		 * Make request 
		 */
		StringBuilder res = new StringBuilder();

		try {
			String urlLocation = "https://api.lyft.com/v1/eta?lat="+ coord.getLat() +"&lng=" + coord.getLon();

			URL obj = new URL(urlLocation);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setDoOutput(true);

			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			LOGGER.info("Output from Lyft API for get ETA .... \n");
			while ((output = br.readLine()) != null) {
				res.append(output);
				LOGGER.info(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		JSONObject jsonObj = new JSONObject(res.toString());

		return jsonObj;
	}



	@Override
	public JSONObject getCost(Coords coordStart, Coords coordEnd,
			JSONObject accessTokenJSON) {
		return getCost(coordStart, coordEnd, null, accessTokenJSON);
	}



	@Override
	public JSONObject getCost(Coords coordStart, Coords coordEnd,
			String rideType, JSONObject accessTokenJSON) {
		boolean hasRideType = false;
		if(rideType != null) hasRideType = true;
		
		String accessToken = parseForAccessToken(accessTokenJSON);

		/*
		 * Make request 
		 */
		StringBuilder res = new StringBuilder();

		try {
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append("https://api.lyft.com/v1/cost?");
			urlBuilder.append("start_lat=");
			urlBuilder.append(coordStart.getLat());
			urlBuilder.append("&start_lng=");
			urlBuilder.append(coordStart.getLon());
			urlBuilder.append("&end_lat=");
			urlBuilder.append(coordEnd.getLat());
			urlBuilder.append("&end_lng=");
			urlBuilder.append(coordEnd.getLon());
			if(hasRideType)
			{
				urlBuilder.append("&ride_type=");
				urlBuilder.append(rideType);
			}
			

			URL obj = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setDoOutput(true);

			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			LOGGER.info("Output from Lyft API for get Cost .... \n");
			while ((output = br.readLine()) != null) {
				res.append(output);
				LOGGER.info(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		JSONObject jsonObj = new JSONObject(res.toString());

		return jsonObj;
	}

	public static void main(String[] args)
	{
		LyftAPIWrapper test = new LyftAPIWrapper();
		JSONObject accessToken = test.authenticate();
		System.out.println(accessToken.getString("access_token"));
		int timeOut = accessToken.getInt("expires_in");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, timeOut / 60);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String expiredTime = sdf.format(cal.getTime());
		System.out.println(expiredTime);
		
		Calendar cal2 = Calendar.getInstance();
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		String currentTime = sdf2.format(cal2.getTime());
		
		try {
			System.out.println(sdf2.parse(expiredTime).after(sdf2.parse(currentTime)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Coords coord = new Coords(37.7772, -122.4233);
		Coords coordEnd = new Coords(37.7972, -122.4533);
		JSONObject rideType = test.getRideType(coord, accessToken);
		JSONObject ETA = test.getETA(coord, accessToken);
		JSONObject cost = test.getCost(coord, coordEnd, accessToken);
		System.out.println(cost);
	}
}
