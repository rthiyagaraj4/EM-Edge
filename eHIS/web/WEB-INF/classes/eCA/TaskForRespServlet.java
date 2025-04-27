/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class TaskForRespServlet extends javax.servlet.http.HttpServlet
{
	/** Multi Record Code **/
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

		PrintWriter out;
	    Properties p;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();

		String group_by = "", grp_by_code = "", associate="", insUpd="", privilege_status="";
		String optionValStr = "", valid_rec="", insUpd_val="", dtl_grp_by_code="",access_right="";

		RecordSet recordSet ;
		Connection con				= null;
		PreparedStatement ins_pstmt = null;
		PreparedStatement upd_pstmt = null;
		PreparedStatement del_pstmt	= null;
//		ResultSet rs				= null;

		ArrayList insertHashMap		= null;
		ArrayList updateHashMap		= null;
		ArrayList deleteHashMap		= null;	

		HashMap	split				= null;
		HashMap	insMapData			= null;
		HashMap	updMapData			= null;
		HashMap delMapData			= null;

		HashMap hMapAlter			= new HashMap();
		HashMap htNameVal			= new HashMap();
		int [] insertCounts			= null;
		int [] updateCounts			= null;
		int [] deleteCounts			= null;
		int srl_no					= 0;
				
		boolean insert_flag			= false ;
		boolean update_flag			= false ;
		boolean delete_flag			= false ;

		HttpSession httpsession		= request.getSession(false);
        p							= (Properties)httpsession.getValue("jdbc");
		String locale = p.getProperty("LOCALE");

		String login_by_id			= p.getProperty("login_user");						
		String login_at_ws_no		= p.getProperty("client_ip_address");
		String login_facility_id	= (String)httpsession.getValue("facility_id");

		recordSet= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("respRelnRecSet","webbeans.eCommon.RecordSet",httpsession);

		group_by					= request.getParameter("group_by");
		grp_by_code					= request.getParameter("grp_by_code");
		dtl_grp_by_code				= request.getParameter("dtl_grp_by_code");
		optionValStr				= request.getParameter("optionValStr");
	
		if(group_by == null || group_by.equals(""))group_by="";
		if(grp_by_code == null || grp_by_code.equals(""))grp_by_code="";
		if(optionValStr == null || optionValStr.equals(""))optionValStr="";
		if(dtl_grp_by_code == null || dtl_grp_by_code.equals(""))dtl_grp_by_code="";
						
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
					String name					=	split_value.nextToken();
				    String access_rights		=	split_value.nextToken();
					String value				=	split_value.nextToken();
					String index_val			=	name.substring(9);
					int index					=	Integer.parseInt(index_val);
					
					if(value.equals("0")) value = "";
                    if(access_rights.equals("N")) access_rights = "" ;
					hMapAlter = (java.util.HashMap)recordSet.getObject(index);

					valid_rec = (String)hMapAlter.get("valid");
                     
					if(valid_rec.equals("Y")) insUpd_val = "U" ;
						else if(valid_rec.equals("N")) insUpd_val = "I";

					if(valid_rec.equals("Y")){
						hMapAlter.put("privilege_status", value);
						hMapAlter.put("associate"	  , "Y");
						hMapAlter.put("insUpd"		  , insUpd_val);
						hMapAlter.put("ACCESS_RIGTHS_APPL"		  , access_rights);
						recordSet.setObject(index, hMapAlter);
					}else if(valid_rec.equals("N")){
						if(!value.equals("")) {
							hMapAlter.put("privilege_status", value);
							hMapAlter.put("associate"	  , "Y");
							hMapAlter.put("insUpd"		  , insUpd_val);
							hMapAlter.put("ACCESS_RIGTHS_APPL"		  , access_rights);
							recordSet.setObject(index, hMapAlter);
						}
					}
				}
				//hMapAlter.clear();
				//htNameVal.clear();
			}//end of IF

			con = ConnectionManager.getConnection(request);
			insertHashMap = new ArrayList();
			updateHashMap = new ArrayList();
			deleteHashMap = new ArrayList();
			split		  = new HashMap();	

			for(int j=0;j<recordSet.getSize();j++){

				split				= (HashMap)recordSet.getObject(j);
				associate			= (String) split.get("associate");
				insUpd				= (String) split.get("insUpd");
				privilege_status	= (String) split.get("privilege_status");
				access_right	= (String) split.get("ACCESS_RIGTHS_APPL");
             	if(associate.equals("Y")){
					if(insUpd.equals("I")){
						insertHashMap.add(split);
					}else if(insUpd.equals("U")){
						if(!privilege_status.equals("")){
							updateHashMap.add(split);
						}else if(privilege_status.equals("")){
							deleteHashMap.add(split);
						}
					}
				}
			}
			//split.clear();

			
			if(insertHashMap.size() >0){

				String insertQuery = "Insert into ca_appl_task_for_resp_reln (APPL_TASK_ID, SRL_NO, RESP_ID, PRACT_RELN_ID, FACILITY_ID, PRIVILEGE_STATUS, ADDED_BY_ID,  ADDED_DATE , ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,ACCESS_RIGTHS_APPL) values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";

				try
				{
					ins_pstmt	= con.prepareStatement(insertQuery);
					insMapData  = new HashMap();

					if(group_by.equals("TS")){
						srl_no = getSrlNo(grp_by_code, con);
					}

					for(int k=0 ; k < insertHashMap.size() ; k++){

						insMapData  = (HashMap)insertHashMap.get(k);

						out.println((String)insMapData.get("code")+"<br>");
						out.println((String)insMapData.get("privilege_status")+"<br>");
						out.println(srl_no+"<br>");
//						String sto=insMapData.get("ACCESS_RIGTHS_APPL")==null?"":(String)insMapData.get("ACCESS_RIGTHS_APPL");  //Common-ICN-0092  
						
						if(group_by.equals("TS")){

							if(dtl_grp_by_code.equals("DRS")){

								ins_pstmt.setString (1, grp_by_code);
								ins_pstmt.setInt	(2, srl_no++);
								ins_pstmt.setString (3, (String)insMapData.get("code"));
								ins_pstmt.setNull   (4, Types.NUMERIC);
								ins_pstmt.setString	(13,insMapData.get("ACCESS_RIGTHS_APPL")==null?"":(String)insMapData.get("ACCESS_RIGTHS_APPL"));

							}else if(dtl_grp_by_code.equals("DRL")){

								ins_pstmt.setString	(1, grp_by_code);
								ins_pstmt.setInt	(2, srl_no++);
								ins_pstmt.setNull	(3, Types.NUMERIC);
								ins_pstmt.setString (4, (String)insMapData.get("code"));
								ins_pstmt.setString	(13,insMapData.get("ACCESS_RIGTHS_APPL")==null?"":(String)insMapData.get("ACCESS_RIGTHS_APPL"));
							}

						}else if(group_by.equals("RS")){

							ins_pstmt.setString	(1, (String)insMapData.get("code"));
							ins_pstmt.setInt	(2, getSrlNo((String)insMapData.get("code"), con));
							ins_pstmt.setString	(3, grp_by_code);
							ins_pstmt.setNull	(4, Types.NUMERIC);
							ins_pstmt.setString	(13,insMapData.get("ACCESS_RIGTHS_APPL")==null?"":(String)insMapData.get("ACCESS_RIGTHS_APPL"));

						}else if(group_by.equals("RL")){

							ins_pstmt.setString	(1, (String)insMapData.get("code"));
							ins_pstmt.setInt	(2, getSrlNo((String)insMapData.get("code"), con));
							ins_pstmt.setNull	(3, Types.NUMERIC);
							ins_pstmt.setString	(4, grp_by_code);
							ins_pstmt.setString	(13,insMapData.get("ACCESS_RIGTHS_APPL")==null?"":(String)insMapData.get("ACCESS_RIGTHS_APPL"));
						}

						ins_pstmt.setString	(5, login_facility_id);
						ins_pstmt.setString (6, (String)insMapData.get("privilege_status"));
						ins_pstmt.setString	(7, login_by_id);
						ins_pstmt.setString	(8, login_at_ws_no);
						ins_pstmt.setString	(9, login_facility_id);
						ins_pstmt.setString	(10,login_by_id);
						ins_pstmt.setString	(11,login_at_ws_no);
						ins_pstmt.setString	(12,login_facility_id);

						ins_pstmt.addBatch();
					}
//					insertHashMap.clear();
	//				insMapData.clear();

				insertCounts = ins_pstmt.executeBatch();
				if(ins_pstmt!=null) ins_pstmt.close();
				}
				catch(Exception eIns)
				{
					eIns.printStackTrace();
				}

				for (int i=0;i<insertCounts.length ;i++ )
				{
					if(insertCounts[i]<0  && insertCounts[i] != -2 )
					{
						insert_flag=false;
						break;
					}
					else
					{
						insert_flag=true;
					}
				}

			}
			else
			{
				insert_flag=true;
			}

			if(insert_flag && updateHashMap.size() >0 )
			{

				StringBuffer updateQuery = new StringBuffer();
				if(updateQuery.length() > 0) updateQuery.delete(0,updateQuery.length());
				updateQuery.append("update ca_appl_task_for_resp_reln set");
				updateQuery.append(" PRIVILEGE_STATUS = ?,");
				updateQuery.append("MODIFIED_BY_ID = ? , ");
				updateQuery.append("MODIFIED_DATE = sysdate ,"); updateQuery.append("MODIFIED_AT_WS_NO = ?,"); 
				updateQuery.append("MODIFIED_FACILITY_ID = ? ,  ");
				updateQuery.append("ACCESS_RIGTHS_APPL = ? ");
				updateQuery.append("where SRL_NO = ? and APPL_TASK_ID = ? ");
				
				try
				{

				upd_pstmt	= con.prepareStatement(updateQuery.toString());
				updMapData  = new HashMap();
                // String st1 = (String)updMapData.get("ACCESS_RIGTHS_APPL");//Checkstyle
				for(int k=0 ; k < updateHashMap.size() ; k++){
					
					updMapData  = (HashMap)updateHashMap.get(k);

					upd_pstmt.setString(1,(String)updMapData.get("privilege_status"));

					upd_pstmt.setString(2,login_by_id);
					upd_pstmt.setString(3,login_at_ws_no);
					upd_pstmt.setString(4,login_facility_id);

					upd_pstmt.setInt(6,Integer.parseInt((String)updMapData.get("srl_no")));

					if(group_by.equals("TS")){
						upd_pstmt.setString(5,(String)updMapData.get("ACCESS_RIGTHS_APPL"));
						upd_pstmt.setString(7, grp_by_code);
					}else if( group_by.equals("RS") || group_by.equals("RL") ){
						upd_pstmt.setString(5,(String)updMapData.get("ACCESS_RIGTHS_APPL"));
						upd_pstmt.setString(7, (String)updMapData.get("code"));
					}

					upd_pstmt.addBatch();
				}
			//	updateHashMap.clear();
				//updMapData.clear();

				updateCounts = upd_pstmt.executeBatch();
				if(upd_pstmt!=null) upd_pstmt.close();
				}
				catch(Exception eupd)
				{
					//out.println("Exception @ Update :"+eupd);//common-icn-0181
					eupd.printStackTrace();
				}

				for (int i=0;i<updateCounts.length ;i++ )
				{
					if(updateCounts[i]<0  && updateCounts[i] != -2 ){
						update_flag=false;
						break;
					}else{
						update_flag=true;
					}
				}
			}
			else
			{
				update_flag = true;
			}

			if(insert_flag && update_flag && deleteHashMap.size() >0 )
			{
				StringBuffer deleteQuery = new StringBuffer();
				if(deleteQuery.length() > 0) deleteQuery.delete(0,deleteQuery.length());
				deleteQuery.append("Delete from "); deleteQuery.append("ca_appl_task_for_resp_reln");
				deleteQuery.append(" where SRL_NO = ? and ");
				deleteQuery.append("APPL_TASK_ID = ?"); 
				try
				{
				del_pstmt	= con.prepareStatement(deleteQuery.toString());
				delMapData  = new HashMap();

				for(int k=0 ; k < deleteHashMap.size() ; k++)
				{

					delMapData  = (HashMap)deleteHashMap.get(k);

					del_pstmt.setInt(1,Integer.parseInt((String)delMapData.get("srl_no")));
					
					if(group_by.equals("TS"))
					{
						del_pstmt.setString(2, grp_by_code);
					}
					else if( group_by.equals("RS") || group_by.equals("RL") )
					{
						del_pstmt.setString(2, (String)delMapData.get("code"));
					}

					del_pstmt.addBatch();
				}
//				deleteHashMap.clear();
	//			delMapData.clear();

				deleteCounts = del_pstmt.executeBatch();
				if(del_pstmt!=null) del_pstmt.close();
				}
				catch(Exception edel)
				{
					//out.println("Exception @ delete :"+edel);//common-icn-0181
					edel.printStackTrace();
				}

				for (int i=0;i<deleteCounts.length ;i++ )
				{
					if(deleteCounts[i]<0  && deleteCounts[i] != -2 )
					{
						delete_flag=false;
						break;
					}
					else
						delete_flag=true;
				}
			}
			else
				delete_flag = true;

			if(insert_flag && update_flag && delete_flag)
			{
				con.commit();
				String msg = getMessage(locale,"RECORD_INSERTED","CA");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=1");
			}
			else
			{
				con.rollback();
				String msg = getMessage(locale,"NO_CHANGE_TO_SAVE","Common");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=0");
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in main try :" +e);//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(hMapAlter != null) hMapAlter.clear();
				if(htNameVal != null) htNameVal.clear();
				if(split != null) split.clear();
				if(insertHashMap != null) insertHashMap.clear();
				if(insMapData != null) insMapData.clear();
				if(updateHashMap != null) updateHashMap.clear();
				if(updMapData != null) updMapData.clear();
				if(deleteHashMap != null) deleteHashMap.clear();
				if(delMapData != null) delMapData.clear();

				if(ins_pstmt != null)ins_pstmt.close();
				if(upd_pstmt != null)upd_pstmt.close();
				if(del_pstmt != null)del_pstmt.close();				
			}
			catch(Exception fe)
			{
				//out.println("exception @ finally" + fe);//common-icn-0181
				fe.printStackTrace();
			}
			if(con!=null) ConnectionManager.returnConnection(con, request);
		}
	}//end of do post

	private int getSrlNo(String task_id, Connection con){
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		int srl_no				= 0;
		StringBuffer sql_query	= new StringBuffer();
		if(sql_query.length() > 0) sql_query.delete(0,sql_query.length());
		sql_query.append("select nvl(max(srl_no + 1),1) ");
		sql_query.append("as srl_no from CA_APPL_TASK_FOR_RESP_RELN"); sql_query.append(" where appl_task_id=?");
		try{
			pstmt	= con.prepareStatement(sql_query.toString());
			pstmt.setString(1,task_id);
			rs		= pstmt.executeQuery();

			if(rs.next()){
				srl_no	= rs.getInt("srl_no");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception exp)
		{
			
		}
		return srl_no;
	}

private String getMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }


}
