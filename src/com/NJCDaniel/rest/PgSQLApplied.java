package com.NJCDaniel.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

import com.NJCDaniel.dao.*;

@Path("/jobs/*")
public class PgSQLApplied {
	private static final String api_version = "00.01.00";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Services</p>";
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version:</p>" + api_version;
	}
	
	public String returnDatabaseStatus() throws Exception {
		
		Statement st = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		
		try {
			conn = PostgreSQLConnect.PostgreSQLConnectConn().getConnection();
			st = conn.createStatement();
//			query = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM public.companies");
			
			while (rs.next()) {
				for (int i=1; i<6; i++) {
				myString = rs.getString(i) + " ";
				}
			}
			
			st.close(); //close connection
			
			returnString = "<p>Database Table: </p>" + myString + "</p>";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) conn.close();
		}
		
		return returnString;
	}
	

}


//public class PgSQLApplied {
//
//}
