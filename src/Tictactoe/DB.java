/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tictactoe;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 *
 * @author Dushani
 */
public class DB {
    private String JDBC_DRIVER = new String("com.mysql.jdbc.Driver");
    private String DB_URL = new String("jdbc:mysql://localhost/tictactoe");
    private Connection conn = null;
    private static Logger logger = Logger.getLogger(DB.class);
    public boolean connectLocal() {
		// variables for user
                
		final String userName = "root";
		final String password = "@Sujatha1";
              		// trying to connect to database

		try {
			// register jdbc drive(load driver to memory)
			Class.forName("com.mysql.jdbc.Driver");
			// connecting to database
			conn = DriverManager.getConnection(DB_URL, userName, password);
               } catch (SQLException e) {
                        logger.log(Priority.ERROR, "Connection could not established", e);
                        // if exception found return false
			return false;
		} catch (ClassNotFoundException e) {
                        // if exception found return false
                        logger.log(Priority.ERROR,"Could not register JDBC driver",e);
			return false;
		}

		// if everything went perfect return true
		return true;
	}
    
    public boolean disconnectLocal() {
		try {
			conn.close();
		} catch (Exception e) {
                    logger.log(Priority.ERROR,"Could not disconnectlo",e);
			return false;
		}
		return true;
	}
    private ResultSet executeStatement(String sql) {
        // creating objects
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // creating the statement
            statement = conn.createStatement();

            // extract data from resultSet
            resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {
            logger.log(Priority.ERROR,"Sql statement Error",e);
            e.printStackTrace();
        }
        return resultSet;

    }


 public ArrayList selectLocal(String table, String column, String where) {
		// creating the sql statement
		String sql = "select " + column + " from " + table + " where " + where;
                
                if(where == null){
                     sql = "select " + column + " from " + table ;

                }
                
		// creating objects
		ResultSet resultSet = null;

		// list to store the final result
		ArrayList<String> result = new ArrayList<String>();

		// get the resultset
		resultSet = executeStatement(sql);

		// get the data array
		result = extractData(resultSet, column);

		return result;
	}
 
 private ArrayList<String> extractData(ResultSet resultSet, String column) {

		// list to store the final result
		ArrayList<String> result = new ArrayList<String>();

		try {
			while (resultSet.next()) {

				// adding the data in to the array list
				result.add((String) resultSet.getString(column));
			}
		} catch (SQLException e) {
                    logger.log(Priority.ERROR,"Could not extract data",e);
			e.printStackTrace();
		} finally {
			try {
				// closing the resultSet
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

public String getValue(Record record){
		int type = record.getType();
		switch(type){
		case 0:
			return String.valueOf(record.getValInt());
		case 1:
			//String.valueOf(recode.getv);break;
		case 2:
			return String.valueOf(record.getValDouble());
			default:
			return	"'" + String.valueOf(record.getValString()) + "'";
			
		}
}
		
public boolean addLocal(String tableName, TableRecord table){
		StringBuilder columns= new StringBuilder();
		StringBuilder value = new StringBuilder();
                
		ArrayList<Record> tableRecords = table.getTableRecord();
		Iterator<Record> it = tableRecords.iterator();
		boolean first = true;
                
		while(it.hasNext()){
			if(!first)
			{
				columns.append(",");
				value.append(",");
			}else
				first = false;
			Record record = it.next();
			columns.append(record.getColumn());
			value.append(getValue(record));
			
		}
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(tableName + " (");
		sql.append(columns.toString()+ " ) VALUES ( ");
		sql.append(value.toString() + " )");
                return executeLocal(sql.toString());
		
	}

public boolean executeLocal(String sql) {
		// creating objects
		boolean result = false;
		Statement statement = null;
		try {

			statement = conn.createStatement();
			statement.execute(sql);
                        return true;

		} catch (Exception e) {
                    logger.log(Priority.ERROR,"sql statement executing error",e);
                        
			return false;
		}


	}


}