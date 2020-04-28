package com.NJCDaniel.dao;

import javax.naming.*;
import javax.sql.*;

public class PostgreSQLConnect {
	private static DataSource PostgreSQLConnect = null;
	private static Context context = null; 
	
	public static DataSource PostgreSQLConnectConn() throws Exception {
		
		if (PostgreSQLConnect != null) {
			return PostgreSQLConnect;
		}
		
		try {
			if(context == null) {
				context = new InitialContext();
			}
			
			PostgreSQLConnect = (DataSource) context.lookup("appliedJobs");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return PostgreSQLConnect;
	}
}

