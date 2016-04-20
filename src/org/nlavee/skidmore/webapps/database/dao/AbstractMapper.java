package org.nlavee.skidmore.webapps.database.dao;

import org.apache.log4j.Logger;

import org.nlavee.skidmore.webapps.database.backends.DatabaseConnection;

/**
 * Represents a generalized DAO. Subclasses will implement the doMap method to
 * integrate between objects and tables.
 * @author readda
 */
public abstract class AbstractMapper
{
	/**
	 * The logger
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
		.getLogger(AbstractMapper.class);

	/**
	 * The database access object used for this mapper
	 */
	private DatabaseAccess database;

	/**
	 * Setup the database access.
	 */
	public AbstractMapper()
	{
		database = DatabaseAccess.getInstance();
	}

	/**
	 * Get the database access object for this mapper
	 * @return The database access object
	 */
	protected DatabaseConnection getDatabaseConnection()
	{
		return database.getConnection();
	}
}