package org.nlavee.skidmore.webapps.database.dao;

import org.apache.log4j.*;
import org.nlavee.skidmore.webapps.database.backends.DatabaseConnection;
import org.nlavee.skidmore.webapps.database.interfaces.ConfigurationProperty;
import org.nlavee.skidmore.webapps.web.config.MagMirrProperties;


public class DatabaseAccess {
	/**
	 * The LOG.infoger
	 */
	@SuppressWarnings("unused")
	private static Logger LOGGER = Logger.getLogger(DatabaseAccess.class);

	/**
	 * The database driver
	 */
	private String driver;

	/**
	 * The connection URL for this instance
	 */
	private String connectionUrl;

	/**
	 * The database user id for this instance
	 */
	private String userId;

	/**
	 * The database password for this instance
	 */
	private String password;

	/**
	 * Singleton instance
	 */
	private static DatabaseAccess instance;

	/**
	 * Constructor - private since this is a Singleton class
	 */
	private DatabaseAccess()
	{
		driver = MagMirrProperties.getInstance()
				.getValue("driver");
		connectionUrl = MagMirrProperties.getInstance()
				.getValue("url");
		userId = MagMirrProperties.getInstance()
				.getValue("userID");
		password = MagMirrProperties.getInstance()
				.getValue("dbPassword");
	}

	/**
	 * Get the Singleton instance
	 * @return The instance
	 */
	public static synchronized DatabaseAccess getInstance()
	{
		if (instance == null)
		{
			instance = new DatabaseAccess();
		}

		return instance;
	}

	/**
	 * Get a database connection instance. Each call returns a unique
	 * instance representing a separate connection to the database. Callers
	 * should be sure to cleanup these connections in a timely manner.
	 * @return The database connection instance
	 */
	public DatabaseConnection getConnection()
	{
		LOGGER.info(driver);
		LOGGER.info(connectionUrl);
		LOGGER.info(userId);
		LOGGER.info(password);
		return new DatabaseConnection(driver, connectionUrl, userId,
			password);
	}

	
}
