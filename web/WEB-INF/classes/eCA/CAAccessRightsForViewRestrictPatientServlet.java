/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------------------------
10/16/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210     									
------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class CAAccessRightsForViewRestrictPatientServlet extends javax.servlet.http.HttpServlet
{
	/** Multi Record Code **/
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out;
	    Properties p;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
		
		RecordSet recordSet ;
		Connection con				= null;
		PreparedStatement ins_stuall_pstmt = null;
		PreparedStatement upd_stuall_pstmt = null;
		PreparedStatement del_stuall_pstmt	= null;
		ArrayList insertStuAllHashMap		= null;
		ArrayList updateStuAllHashMap		= null;
		ArrayList deleteStuAllHashMap		= null;	
	
		HashMap	split				= null;
		HashMap	insStuAllMapData			= null;
		HashMap	updStuAllMapData			= null;
		HashMap    delStuAllMapData			= null;

		HashMap hMapAlter			= new HashMap();
		HashMap htNameVal			= new HashMap();
		int [] insertStuAllCounts			= null;
		int [] updateStuAllCounts			= null;
		int [] deleteStuAllCounts			= null;				
		boolean insert_stuall_flag			= false ;
		boolean update_stuall_flag			= false ;
		boolean delete_stuall_flag			= false ;
		String	optionValStr			=	"";
        String  currentDate="";
		HttpSession httpsession		= request.getSession(false);
        p							= (Properties)httpsession.getValue("jdbc");  
		String locale = p.getProperty("LOCALE");
		currentDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);		
		String login_by_id			= p.getProperty("login_user");						
		String login_at_ws_no		= p.getProperty("client_ip_address");
		String login_facility_id	= (String)httpsession.getValue("facility_id");
		optionValStr				= request.getParameter("optionValStr");
		recordSet= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("accRightForResRecSet","webbeans.eCommon.RecordSet",httpsession);
		try{
			if(!optionValStr.equals("")){
				StringTokenizer stoken_code = new StringTokenizer(optionValStr,"~");
				int count_code		=	stoken_code.countTokens();
				for(int i=0;i<count_code;i++){
					String name_value =	stoken_code.nextToken();
					htNameVal.put("name_value"+i,name_value);
				}
				for(int j=0; j<htNameVal.size(); j++){
					String name_value			=	(String)htNameVal.get("name_value"+j);
					StringTokenizer split_value	=	new StringTokenizer(name_value,"||");		
					String practitionerId 		= split_value.nextToken();
					String practitionerName 	= split_value.nextToken();
					String access_from_date 			= split_value.nextToken();
					String access_to_date 			= split_value.nextToken();
					String accessRightsIU 			= split_value.nextToken();
					String access_res_pat_yn 			= split_value.nextToken();
					String index_val			= split_value.nextToken();
					int index					= Integer.parseInt(index_val);
					hMapAlter = (java.util.HashMap)recordSet.getObject(index);
					if("".equals(access_from_date.trim()) && !"".equals(access_to_date.trim())){
					access_from_date=currentDate;}					
					hMapAlter.put("practitionerId"		, practitionerId);
					hMapAlter.put("practitionerName"	, practitionerName);
					hMapAlter.put("access_from_date"			, access_from_date.trim());
					hMapAlter.put("access_from_date"			, access_from_date.trim());
					hMapAlter.put("access_to_date"			, access_to_date.trim());
					hMapAlter.put("accessRightsIU"			, accessRightsIU);
					hMapAlter.put("access_res_pat_yn"			, access_res_pat_yn);
					recordSet.setObject(index, hMapAlter);	
				}
			}//end of IF
			con = ConnectionManager.getConnection(request);
			insertStuAllHashMap 	= new ArrayList();
			updateStuAllHashMap 	= new ArrayList();
			deleteStuAllHashMap 	= new ArrayList();
			split		  = new HashMap();	
			for(int j=0;j<recordSet.getSize();j++){
				split				= (HashMap)recordSet.getObject(j);
				String access_from_date 		= (String) split.get("access_from_date");
				String access_to_date 		= (String) split.get("access_to_date");
				String accessRightsIU 		= (String) split.get("accessRightsIU");
				String access_res_pat_yn 		= (String) split.get("access_res_pat_yn");
				if("Y".equals(access_res_pat_yn) && "U".equals(accessRightsIU) && (!access_from_date.equals("") || !access_to_date.equals("")))
				{
					updateStuAllHashMap.add(split);
				}
				else if("Y".equals(access_res_pat_yn) && "I".equals(accessRightsIU) && (!access_from_date.equals("") || !access_to_date.equals("")))
				{
					insertStuAllHashMap.add(split);
				}
				else if("N".equals(access_res_pat_yn) && "U".equals(accessRightsIU))
				{
					deleteStuAllHashMap.add(split);
				}			
			}
			if(insertStuAllHashMap.size() >0){
				String insertStuAllQuery = "INSERT INTO CA_ACCESS_VIEW_RESTR_PATIENT (PRACTITIONER_ID,ACCESS_FROM_DATE,ACCESS_TO_DATE,ACCESS_RES_PAT_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,FACILITY_ID) VALUES(?,TO_DATE(?,'dd/MM/yyyy'),TO_DATE(?,'dd/MM/yyyy'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
				try
				{
					ins_stuall_pstmt	= con.prepareStatement(insertStuAllQuery);
					insStuAllMapData  = new HashMap();					
					for(int k=0 ; k < insertStuAllHashMap.size() ; k++){
					insStuAllMapData  = (HashMap)insertStuAllHashMap.get(k);
						
					ins_stuall_pstmt.setString(1,(String)insStuAllMapData.get("practitionerId"));
					if("".equals((String)insStuAllMapData.get("access_from_date")))
					ins_stuall_pstmt.setString(2,currentDate);
					else
						ins_stuall_pstmt.setString(2,(String)insStuAllMapData.get("access_from_date"));
						ins_stuall_pstmt.setString(3,(String)insStuAllMapData.get("access_to_date"));
						ins_stuall_pstmt.setString(4,(String)insStuAllMapData.get("access_res_pat_yn"));
						ins_stuall_pstmt.setString(5, login_by_id);
						ins_stuall_pstmt.setString(6, login_at_ws_no);
						ins_stuall_pstmt.setString(7, login_facility_id);
						ins_stuall_pstmt.setString(8, login_by_id);
						ins_stuall_pstmt.setString(9, login_at_ws_no);
						ins_stuall_pstmt.setString(10,login_facility_id);
						ins_stuall_pstmt.setString(11,login_facility_id);
						ins_stuall_pstmt.addBatch();
					}				
					insertStuAllCounts =  ins_stuall_pstmt.executeBatch();					
					if( ins_stuall_pstmt!=null)  ins_stuall_pstmt.close();
				}catch(Exception eIns){
					con.rollback();
					eIns.printStackTrace();
				}
				for (int i=0;i<insertStuAllCounts.length ;i++ )
				{
					if(insertStuAllCounts[i]<0  && insertStuAllCounts[i] != -2 )
					{
						insert_stuall_flag=false;
						break;
					}
					else
					{
						insert_stuall_flag=true;
					}
				}
			}
			if(updateStuAllHashMap.size() >0){
				String updateStuAllQuery = "UPDATE CA_ACCESS_VIEW_RESTR_PATIENT SET ACCESS_FROM_DATE=TO_DATE(?,'dd/MM/yyyy'),ACCESS_TO_DATE=TO_DATE(?,'dd/MM/yyyy'),MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE PRACTITIONER_ID=?";
				try
				{
					upd_stuall_pstmt	= con.prepareStatement(updateStuAllQuery);
					updStuAllMapData  = new HashMap();					
					for(int k=0 ; k < updateStuAllHashMap.size() ; k++){
						updStuAllMapData  = (HashMap)updateStuAllHashMap.get(k);
						if("".equals((String)updStuAllMapData.get("access_from_date")))
						upd_stuall_pstmt.setString(1,currentDate);
						else
						upd_stuall_pstmt.setString(1,(String)updStuAllMapData.get("access_from_date"));
						upd_stuall_pstmt.setString(2,(String)updStuAllMapData.get("access_to_date"));
						upd_stuall_pstmt.setString(3,login_by_id);
						upd_stuall_pstmt.setString(4,login_at_ws_no);
						upd_stuall_pstmt.setString(5,login_facility_id);
						upd_stuall_pstmt.setString(6,(String)updStuAllMapData.get("practitionerId"));
						upd_stuall_pstmt.addBatch();
						}				
					updateStuAllCounts =  upd_stuall_pstmt.executeBatch();
					if( upd_stuall_pstmt!=null)  upd_stuall_pstmt.close();
				}catch(Exception eIns){
					con.rollback();
					eIns.printStackTrace();
				}
				for (int i=0;i<updateStuAllCounts.length ;i++ )
				{
					if(updateStuAllCounts[i]<0  && updateStuAllCounts[i] != -2 )
					{
						update_stuall_flag=false;
						break;
					}
					else
					{
						update_stuall_flag=true;
					}
				}
			}
			if(deleteStuAllHashMap.size() >0){
				String deleteStuAllQuery = "DELETE FROM CA_ACCESS_VIEW_RESTR_PATIENT WHERE PRACTITIONER_ID=? AND FACILITY_ID=?";
				try
				{
					del_stuall_pstmt	= con.prepareStatement(deleteStuAllQuery);
					delStuAllMapData  = new HashMap();					
					for(int k=0 ; k < deleteStuAllHashMap.size() ; k++){
						delStuAllMapData  = (HashMap)deleteStuAllHashMap.get(k);
						del_stuall_pstmt.setString(1,(String)delStuAllMapData.get("practitionerId"));
						del_stuall_pstmt.setString(2,login_facility_id);
						del_stuall_pstmt.addBatch();
					}				
					deleteStuAllCounts =  del_stuall_pstmt.executeBatch();
					if( del_stuall_pstmt!=null)  del_stuall_pstmt.close();
				}catch(Exception eIns){
					con.rollback();
					eIns.printStackTrace();
				}
				for (int i=0;i<deleteStuAllCounts.length ;i++ )
				{
					if(deleteStuAllCounts[i]<0  && deleteStuAllCounts[i] != -2 )
					{
						delete_stuall_flag=false;
						break;
					}
					else
					{
						delete_stuall_flag=true;
					}
				}
			}
			String error = "" ;
			String error_value = "0" ;
			if(insert_stuall_flag || update_stuall_flag || delete_stuall_flag)
			{
				con.commit();
				error_value = "1" ;
				java.util.Hashtable hashtable4 = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");
				error =(java.lang.String)hashtable4.get("message");		
			}
			else
			{
				con.rollback();
				java.util.Hashtable hashtable4 = MessageManager.getMessage(p.getProperty("LOCALE"),"NO_CHANGE_TO_SAVE","Common");
				error =(java.lang.String)hashtable4.get("message");					
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch(Exception e)
		{
			out.println("Exception in main try :" +e);
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(hMapAlter != null) hMapAlter.clear();
				if(htNameVal != null) htNameVal.clear();
				if(split != null) split.clear();
				if(insertStuAllHashMap != null) insertStuAllHashMap.clear();
				if(updateStuAllHashMap != null) updateStuAllHashMap.clear();
				if(deleteStuAllHashMap != null) deleteStuAllHashMap.clear();
				if(insStuAllMapData != null) insStuAllMapData.clear();
				if(updStuAllMapData != null) updStuAllMapData.clear();
				if(delStuAllMapData != null) delStuAllMapData.clear();
				if(ins_stuall_pstmt != null)ins_stuall_pstmt.close();
				if(upd_stuall_pstmt != null)upd_stuall_pstmt.close();
				if(del_stuall_pstmt != null)del_stuall_pstmt.close();
			}
			catch(Exception fe)
			{
				fe.printStackTrace();
			}
			if(con!=null) ConnectionManager.returnConnection(con, request);
		}
	}//end of do post
	private String getMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
}

