/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ErrorUtil {
	public  String Fname = "";
	public  String ErrorLevel = "";
	public  String ErrorId = "";
	public  String ErrorMesg = ""; 
	private static Map<String,String> err_map = new HashMap<String,String>();

	public static String decodeProcedureErrorMsg(String err_level,String sys_mesg_id,String err_text,String fname) {
		String err_msg =("".equals(sys_mesg_id))?"RECORD_INSERTED":getMessage(sys_mesg_id); 
		err_msg = ("".equals(err_text) && "RECORD_INSERTED".equals(err_msg) )?"RECORD_INSERTED":(!"".equals(sys_mesg_id))?err_msg:err_text;
		err_map.put("fname",fname);
		err_map.put("err_level",err_level);
		err_map.put("sys_mesg_id",sys_mesg_id);
		err_map.put("err_text",err_msg);
		ErrorQueue.set(err_map);
		return err_msg;
	}

	public static String getMessage(String mesg_id){
		Connection con = null;
		StringBuilder sbr = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String err_desc = "";
		//String err_mesg = "";	//Commented Against AAKH-ICN-0008
		String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
		try{
			con = ConnectionDispenser.getConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,mesg_id);
			rst = pstmt.executeQuery();
			int count=0;
			 while(rst.next()){
				 ++count;
				err_desc=rst.getString(1);
			}

		}catch(Exception e){
			System.err.println("BOOKING BILLING MANAGER: Err Mesg in getMessage"+e);
		}
		finally{
			try{
				sbr.setLength(0);
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				//con.close();
			}catch(Exception e){}
	}
	  return err_desc;
  }
	 
	
}
