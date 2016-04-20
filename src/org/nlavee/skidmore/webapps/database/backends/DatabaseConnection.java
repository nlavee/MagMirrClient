package org.nlavee.skidmore.webapps.database.backends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DatabaseConnection {
	/**
	 * The logger
	 */
	private static final Logger LOG = Logger
		.getLogger(DatabaseConnection.class);

	/**
	 * The database connection string
	 */
	private String url;

	/**
	 * The user id for accessing the database
	 */
	private String userId;

	/**
	 * The password for accessing the database
	 */
	private String password;

	/**
	 * Constructs a database connection with the supplied connection
	 * information.
	 * @param driver
	 *          The JDBC driver to load
	 * @param url
	 *          The database endpoint URL
	 * @param userId
	 *          The database user id
	 * @param password
	 *          The database password
	 * @see #testConnection()
	 * @see #closeStatement(Statement)
	 */
	public DatabaseConnection(String driver, String url, String userId,
		String password)
	{
		try
		{
			Class.forName(driver);
		}
		catch (ClassNotFoundException cnfe)
		{
			LOG.error("Error loading driver: " + driver, cnfe);
			throw new IllegalStateException(
				"Unable to load the database driver", cnfe);
		}

		setUrl(url);
		setUserId(userId);
		setPassword(password);

		LOG.debug("Database connection configured for URL (" + url
			+ ") and userId (" + userId + ")");

		testConnection();
	}

	/**
	 * Performs a trivial test of connectivity to the database.
	 */
	private void testConnection()
	{
		PreparedStatement stmt = setupPreparedStatement("select now()");
		ResultSet rs = runQuery(stmt);
		closeResultSet(rs);
	}

	/**
	 * Setup a prepared statement. If a database query is to be executed
	 * this method should be called, passing a parameterized SQL statement.
	 * The caller should then set the parameters (if any) before calling the
	 * runQuery or runUpdate method.
	 * Note that it is the callers job to assure the statement
	 * is closed. This normally happens after processing a result set or
	 * when and update is executed. See the runQuery and runUpdate
	 * documentation for details on closing the statement.
	 * @param sql
	 *          The SQL statement with optional parameters
	 * @return A parameterized statement based on the supplied SQL
	 * @see #runQuery(PreparedStatement)
	 * @see #runUpdate(PreparedStatement)
	 */
	public PreparedStatement setupPreparedStatement(String sql)
	{
		Connection conn = null;
		PreparedStatement stmt = null;

		LOG.debug("Setup a prepared statement for: " + sql);

		try
		{
			conn = DriverManager.getConnection(getUrl(),
				getUserId(),
				getPassword());
			stmt = conn.prepareStatement(sql);
		}
		catch (SQLException sqle)
		{
			LOG.error("Error setting up prepared statement: " + sql + " for server "
				+ getUrl(),
				sqle);
			throw new IllegalStateException(
				"Unable to setup the SQL statement", sqle);
		}

		return stmt;
	}

	/**
	 * Run the query defined by the prepared statement. Before calling this
	 * method the caller should have used the setupPreparedStatement method
	 * to create a prepared statement.
	 * After the caller is finished with the resultset it should use the
	 * closeResultSet method to clean up the database resources.
	 * @param stmt
	 *          The prepared statement with any parameters defined
	 * @return The result set from the database
	 * @see #setupPreparedStatement(String)
	 * @see #closeResultSet(ResultSet)
	 */
	public ResultSet runQuery(PreparedStatement stmt)
	{
		ResultSet rs = null;

		LOG.debug("Run a query: " + stmt);

		try
		{
			rs = stmt.executeQuery();
		}
		catch (SQLException sqle)
		{
			LOG.error("Error executing the SQL", sqle);
			throw new IllegalStateException(
				"Unable to execute the statement",
				sqle);
		}

		return rs;
	}

	/**
	 * Run the update statement (e.g. SQL statement that does not return a
	 * result set). Before calling this method the caller should have used
	 * the setupPreparedStatement method to create a prepared statement.
	 * The underlying statement and connection are
	 * automatically closed when this method is called.
	 * @param stmt
	 *          The prepared statement with any parameters defined
	 * return The return code from the backend
	 * @see #setupPreparedStatement(String)
	 */
	public void runUpdate(PreparedStatement stmt)
	{
		try
		{
			stmt.execute();
			closeStatement(stmt);
		}
		catch (SQLException sqle)
		{
			LOG.error("Error executing the SQL", sqle);
			throw new IllegalStateException(
				"Unable to execute the statement",
				sqle);
		}
	}

	/**
	 * Clean up the database resources for a result set. Callers should use
	 * this once they are finished with the result set returned by the
	 * runQuery method.
	 * This method closes the result set as well as the underlying statement
	 * and database connection. There is no need to call closeStatement on
	 * the underlying statement if this method is used to close the result
	 * set.
	 * @param rs
	 *          The result set returned by the runQuery method
	 * @see #runQuery(PreparedStatement)
	 * @see #closeStatement(Statement)
	 */
	public void closeResultSet(ResultSet rs)
	{
		try
		{
			Statement stmt = rs.getStatement();

			rs.close();
			closeStatement(stmt);
		}
		catch (SQLException sqle)
		{
			LOG.error("Error while closing the result set", sqle);
			throw new IllegalStateException(
				"Failed to cleanup the result set",
				sqle);
		}
	}

	/**
	 * Cleans up the resources for a statement. This closes the statement
	 * and database connection.
	 * This method should not be called using statements whose results sets
	 * have already been closed using closeResultSet.
	 * @param stmt
	 *          The statement obtained by calling
	 *          setupPreparedStatement
	 * @see #setupPreparedStatement(String)
	 * @see #closeResultSet(ResultSet)
	 */
	public void closeStatement(Statement stmt)
	{
		try
		{
			Connection conn = stmt.getConnection();

			stmt.close();
			conn.close();
		}
		// TODO Show this (with failed test) to class - example of why Throwable
		// is useful for "can't happen"
		catch (Throwable sqle)
		{
			LOG.error(
				"Error while closing the statement and connection",
				sqle);
			throw new IllegalStateException(
				"Failed to cleanup the database statement and connection",
				sqle);
		}
	}

	/**
	 * Get the database connection URL
	 * @return the URL for the database endpoint
	 */
	private String getUrl()
	{
		return url;
	}

	/**
	 * Set the database connection URL
	 * @param url
	 *          The URL for the database endpoint
	 */
	private void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * Get the user id used for connecting to the database
	 * @return the database userId
	 */
	private String getUserId()
	{
		return userId;
	}

	/**
	 * Set the user id used for connecting to the database
	 * @param userId
	 *          The database user id
	 */
	private void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * Get the password used for connecting to the database
	 * @return the database password
	 */
	private String getPassword()
	{
		return password;
	}

	/**
	 * Set the password used for connecting to the database
	 * @param password
	 *          The database password
	 */
	private void setPassword(String password)
	{
		this.password = password;
	}
}
