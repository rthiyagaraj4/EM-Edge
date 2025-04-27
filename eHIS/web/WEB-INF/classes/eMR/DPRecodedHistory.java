/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.sql.*;
import java.io.*;
//import javax.servlet.*;
import java.net.URLEncoder;
//import javax.servlet.http.*;
import java.util.*;
//import javax.naming.*;
//import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;


public class DPRecodedHistory 
{  
	Connection con				= null;
	PreparedStatement ps	= null;
	ResultSet rs					= null;
	String sql						= null;
	boolean changeInParameters    = false;
	//  public DPRecodedHistory(Connection con) { this.con = con; }
	public void setSql (String sql){
		this.sql = sql;
		try{
			con=ConnectionManager.getConnection();
			this.ps  = con.prepareStatement(this.sql);
			this.changeInParameters = true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	public void setParameters(String[] params){
		try{
			for(int i=1; i <= params.length; i++){
			this.ps.setString(i, params[i-1]);
			}
		}catch(java.sql.SQLException ex){
			ex.printStackTrace();
		}
		this.changeInParameters = true;
	}
	public String getString(String columnName){
		try{
			return this.rs.getString(columnName);
		} catch(SQLException ex){ex.printStackTrace();}
		return null;
	}

	public boolean next(){
		try{
			if(this.changeInParameters){			    
				this.changeInParameters = false;
				this.rs = ps.executeQuery();
			}
			if(this.rs != null){
				boolean b = rs.next();
				if( !b ){
					if(this.rs != null) this.rs.close();
					if(this.ps != null) this.ps.close();
					//if(con != null) con.close();//commented for check style
					if(con !=null) ConnectionManager.returnConnection(con);	//Added for check style for COMMON-ICN-0056
				}
				return b;
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	return false;
	}
}
