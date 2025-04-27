/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;

public class CommonCheckPk {

	 Connection con = null;
	 PreparedStatement pstmt = null;
	 ResultSet rst = null;

	public boolean checkForPk(HttpServletRequest request, HttpServletResponse response, String sql, String column){
		boolean rslt = false;
		try{
			int count = 0;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, column);
			rst = pstmt.executeQuery();
			while(rst.next()){
				count = rst.getInt(1);
			}
			if(count>0){
				rslt = true;
			}
			else{
				rslt = false;
			}
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
		}
		finally{
		//Checkstyle Correction added by Munisekhar
		try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e1){
				System.err.println("Exception is:"+e1);
			}
			}

		return rslt;
	}

	public boolean checkForPk(HttpServletRequest request,
			HttpServletResponse response, String sql,
			String[] args, int length) {
		boolean rslt = false;
		try{
			int count = 0;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			for(int i=1;i<=length;i++){
				pstmt.setString(i, args[i-1]);
			}
			rst = pstmt.executeQuery();
			while(rst.next()){
				count = rst.getInt(1);
			}
			if(count>0){
				rslt = true;
			}
			else{
				rslt = false;
			}
		}
		catch(Exception e){
			System.err.println("Exception is "+e);
		}
		finally{
		//Checkstyle Correction added by Munisekhar
		try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e1){
				System.err.println("Exception is:"+e1);
			}
			}
		return rslt;
	}

}
