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

public class AccessRightForResearchStudiesServlet extends javax.servlet.http.HttpServlet
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
		PreparedStatement ins_sturights_pstmt = null;
		PreparedStatement upd_sturights_pstmt = null;
		PreparedStatement del_sturights_pstmt	= null;

		ArrayList insertStuAllHashMap		= null;
		ArrayList updateStuAllHashMap		= null;
		ArrayList deleteStuAllHashMap		= null;	
		ArrayList insertStuRightsHashMap	= null;
		ArrayList updateStuRightsHashMap	= null;
		ArrayList deleteStuRightsHashMap	= null;	

		HashMap	split				= null;
		HashMap	insStuAllMapData			= null;
		HashMap	updStuAllMapData			= null;
		HashMap delStuAllMapData			= null;
		HashMap	insStuRightsMapData			= null;
		HashMap	updStuRightsMapData			= null;
		HashMap delStuRightsMapData			= null;

		HashMap hMapAlter			= new HashMap();
		HashMap htNameVal			= new HashMap();
		int [] insertStuAllCounts			= null;
		int [] updateStuAllCounts			= null;
		int [] deleteStuAllCounts			= null;
		int [] insertStuRightsCounts		= null;
		int [] updateStuRightsCounts		= null;
		int [] deleteStuRightsCounts		= null;
		//int srl_no					= 0;  //COMMON-ICN-0122
				
		boolean insert_stuall_flag			= false ;
		boolean update_stuall_flag			= false ;
		boolean delete_stuall_flag			= false ;
		boolean insert_sturights_flag		= false ;
		boolean update_sturights_flag		= false ;
		boolean delete_sturights_flag		= false ;
		String	optionValStr			=	"";
		String	resePatCategory			=	"";
		String	reseCategoryFact			=	"";

		HttpSession httpsession		= request.getSession(false);
        p							= (Properties)httpsession.getValue("jdbc");  
		//String locale = p.getProperty("LOCALE");//COMMON-ICN-0122

		String login_by_id			= p.getProperty("login_user");						
		String login_at_ws_no		= p.getProperty("client_ip_address");
		String login_facility_id	= (String)httpsession.getValue("facility_id");
		optionValStr				= request.getParameter("optionValStr");
		resePatCategory				= request.getParameter("resePatCategory");
		reseCategoryFact				= request.getParameter("reseCategoryFact");
		recordSet= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("accRightForResStuRecSet","webbeans.eCommon.RecordSet",httpsession);
		
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
					String resFromDate 			= split_value.nextToken();
					String resToDate 			= split_value.nextToken();
					String resRecord 			= split_value.nextToken();
					String resUpdate 			= split_value.nextToken();
					String studyAllowedIU 		= split_value.nextToken();
					String studyRightsIU 		= split_value.nextToken();
					String index_val			= split_value.nextToken();
					int index					= Integer.parseInt(index_val);
					
					hMapAlter = (java.util.HashMap)recordSet.getObject(index);
					
					hMapAlter.put("practitionerId"		, practitionerId);
					hMapAlter.put("practitionerName"	, practitionerName);
					hMapAlter.put("resFromDate"			, resFromDate.trim());
					hMapAlter.put("resToDate"			, resToDate.trim());
					hMapAlter.put("resRecord"			, resRecord);
					hMapAlter.put("resUpdate"			, resUpdate);
					hMapAlter.put("studyAllowedIU"		, studyAllowedIU);
					hMapAlter.put("studyRightsIU"		, studyRightsIU);
					recordSet.setObject(index, hMapAlter);
					
				}
				
			}//end of IF
			con = ConnectionManager.getConnection(request);
			insertStuAllHashMap 	= new ArrayList();
			updateStuAllHashMap 	= new ArrayList();
			deleteStuAllHashMap 	= new ArrayList();
			insertStuRightsHashMap	= new ArrayList();
			updateStuRightsHashMap	= new ArrayList();
			deleteStuRightsHashMap	= new ArrayList();	
			split		  = new HashMap();	
			for(int j=0;j<recordSet.getSize();j++){
				split				= (HashMap)recordSet.getObject(j);
				//String practitionerId 	= (String) split.get("practitionerId");   //COMMON-ICN-0122
				//String practitionerName = (String) split.get("practitionerName");   //COMMON-ICN-0122
				String resFromDate 		= (String) split.get("resFromDate");
				String resToDate 		= (String) split.get("resToDate");
				String resRecord 		= (String) split.get("resRecord");
				String resUpdate 		= (String) split.get("resUpdate");
				String studyAllowedIU 	= (String) split.get("studyAllowedIU");
				String studyRightsIU 	= (String) split.get("studyRightsIU");
				
				if(!"".equals(resFromDate) || !"".equals(resToDate) ){
					if("I".equals(studyAllowedIU)){
						insertStuAllHashMap.add(split);
					}else if("U".equals(studyAllowedIU)){
						updateStuAllHashMap.add(split);
					}
				}else{
					if("U".equals(studyAllowedIU)){
						deleteStuAllHashMap.add(split);
					}
				}
				
				if("Y".equals(resRecord) || "Y".equals(resUpdate) ){
					if("I".equals(studyRightsIU)){
						insertStuRightsHashMap.add(split);
					}else if("U".equals(studyRightsIU)){
						updateStuRightsHashMap.add(split);
					}
				}else{
					if("U".equals(studyRightsIU)){
						deleteStuRightsHashMap.add(split);
					}
				}
				
			}
			//Insert the records in CA_RES_STUDY_ALLOWED Start.
			if(insertStuAllHashMap.size() >0){
				String insertStuAllQuery = "INSERT INTO CA_RES_STUDY_ALLOWED (PRACTITIONER_ID,RES_FROM_DATE,RES_TO_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,FACILITY_ID) VALUES(?,TO_DATE(?,'dd/MM/yyyy'),TO_DATE(?,'dd/MM/yyyy'),?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
				try
				{
					ins_stuall_pstmt	= con.prepareStatement(insertStuAllQuery);
					insStuAllMapData  = new HashMap();					
					for(int k=0 ; k < insertStuAllHashMap.size() ; k++){
						insStuAllMapData  = (HashMap)insertStuAllHashMap.get(k);
						ins_stuall_pstmt.setString(1,(String)insStuAllMapData.get("practitionerId"));
						ins_stuall_pstmt.setString(2,(String)insStuAllMapData.get("resFromDate"));
						ins_stuall_pstmt.setString(3,(String)insStuAllMapData.get("resToDate"));
						ins_stuall_pstmt.setString(4,login_by_id);
						ins_stuall_pstmt.setString(5,login_at_ws_no);
						ins_stuall_pstmt.setString(6,login_facility_id);
						ins_stuall_pstmt.setString(7,login_by_id);
						ins_stuall_pstmt.setString(8,login_at_ws_no);
						ins_stuall_pstmt.setString(9,login_facility_id);
						ins_stuall_pstmt.setString(10,login_facility_id);
						
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
			}else{
				insert_stuall_flag=true;
			}
			//Insert the records in CA_RES_STUDY_ALLOWED End.
			//Update the records in CA_RES_STUDY_ALLOWED Start.
			if(updateStuAllHashMap.size() >0){
				String updateStuAllQuery = "UPDATE CA_RES_STUDY_ALLOWED SET RES_FROM_DATE=TO_DATE(?,'dd/MM/yyyy'),RES_TO_DATE=TO_DATE(?,'dd/MM/yyyy'),MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE PRACTITIONER_ID=? AND FACILITY_ID=?";
				try
				{
					upd_stuall_pstmt	= con.prepareStatement(updateStuAllQuery);
					updStuAllMapData  = new HashMap();					
					for(int k=0 ; k < updateStuAllHashMap.size() ; k++){
						updStuAllMapData  = (HashMap)updateStuAllHashMap.get(k);
						
						upd_stuall_pstmt.setString(1,(String)updStuAllMapData.get("resFromDate"));
						upd_stuall_pstmt.setString(2,(String)updStuAllMapData.get("resToDate"));
						upd_stuall_pstmt.setString(3,login_by_id);
						upd_stuall_pstmt.setString(4,login_at_ws_no);
						upd_stuall_pstmt.setString(5,login_facility_id);
						upd_stuall_pstmt.setString(6,(String)updStuAllMapData.get("practitionerId"));
						upd_stuall_pstmt.setString(7,login_facility_id);
						
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
			}else{
				update_stuall_flag=true;
			}
			//Update the records in CA_RES_STUDY_ALLOWED End.
			//Delete the records in CA_RES_STUDY_ALLOWED Start.
			if(deleteStuAllHashMap.size() >0){
				String deleteStuAllQuery = "DELETE FROM CA_RES_STUDY_ALLOWED WHERE PRACTITIONER_ID=? AND FACILITY_ID=?";
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
			}else{
				delete_stuall_flag=true;
			}
			//Delete the records in CA_RES_STUDY_ALLOWED End.
			//Insert the records in CA_RES_STUDY_RIGHTS Start.
			if(insertStuRightsHashMap.size() >0){
				String insertStuRightsQuery = "INSERT INTO CA_RES_STUDY_RIGHTS (RESEARCH_CATEG_ID,RESEARCH_CATEG_FACT_ID,PRACTITIONER_ID,RES_RECORD,RES_UPDATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,FACILITY_ID) VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
				try
				{
					ins_sturights_pstmt	= con.prepareStatement(insertStuRightsQuery);
					insStuRightsMapData  = new HashMap();					
					for(int k=0 ; k < insertStuRightsHashMap.size() ; k++){
						insStuRightsMapData  = (HashMap)insertStuRightsHashMap.get(k);
						ins_sturights_pstmt.setString(1,resePatCategory);
						ins_sturights_pstmt.setString(2,reseCategoryFact);
						ins_sturights_pstmt.setString(3,(String)insStuRightsMapData.get("practitionerId"));
						ins_sturights_pstmt.setString(4,(String)insStuRightsMapData.get("resRecord"));
						ins_sturights_pstmt.setString(5,(String)insStuRightsMapData.get("resUpdate"));
						ins_sturights_pstmt.setString(6,login_by_id);
						ins_sturights_pstmt.setString(7,login_at_ws_no);
						ins_sturights_pstmt.setString(8,login_facility_id);
						ins_sturights_pstmt.setString(9,login_by_id);
						ins_sturights_pstmt.setString(10,login_at_ws_no);
						ins_sturights_pstmt.setString(11,login_facility_id);
						ins_sturights_pstmt.setString(12,login_facility_id);
						
						ins_sturights_pstmt.addBatch();
					}				
					insertStuRightsCounts =  ins_sturights_pstmt.executeBatch();
					if( ins_sturights_pstmt!=null)  ins_sturights_pstmt.close();
				}catch(Exception eIns){
					con.rollback();
					eIns.printStackTrace();
				}

				for (int i=0;i<insertStuRightsCounts.length ;i++ )
				{
					if(insertStuRightsCounts[i]<0  && insertStuRightsCounts[i] != -2 )
					{
						insert_sturights_flag=false;
						break;
					}
					else
					{
						insert_sturights_flag=true;
					}
				}
			}else{
				insert_sturights_flag=true;
			}
			//Insert the records in CA_RES_STUDY_RIGHTS End.
			//Update the records in CA_RES_STUDY_RIGHTS Start.
			if(updateStuRightsHashMap.size() >0){
				String updateStuRightsQuery = "UPDATE CA_RES_STUDY_RIGHTS SET RES_RECORD=?,RES_UPDATE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE RESEARCH_CATEG_ID=? AND RESEARCH_CATEG_FACT_ID=? AND PRACTITIONER_ID=? AND FACILITY_ID=?";
				try
				{
					upd_sturights_pstmt	= con.prepareStatement(updateStuRightsQuery);
					updStuRightsMapData  = new HashMap();					
					for(int k=0 ; k < updateStuRightsHashMap.size() ; k++){
						updStuRightsMapData  = (HashMap)updateStuRightsHashMap.get(k);
						upd_sturights_pstmt.setString(1,(String)updStuRightsMapData.get("resRecord"));
						upd_sturights_pstmt.setString(2,(String)updStuRightsMapData.get("resUpdate"));						
						upd_sturights_pstmt.setString(3,login_by_id);
						upd_sturights_pstmt.setString(4,login_at_ws_no);
						upd_sturights_pstmt.setString(5,login_facility_id);
						upd_sturights_pstmt.setString(6,resePatCategory);
						upd_sturights_pstmt.setString(7,reseCategoryFact);
						upd_sturights_pstmt.setString(8,(String)updStuRightsMapData.get("practitionerId"));
						upd_sturights_pstmt.setString(9,login_facility_id);
						
						upd_sturights_pstmt.addBatch();
					}				
					updateStuRightsCounts =  upd_sturights_pstmt.executeBatch();
					if( upd_sturights_pstmt!=null)  upd_sturights_pstmt.close();
				}catch(Exception eIns){
					con.rollback();
					eIns.printStackTrace();
				}

				for (int i=0;i<updateStuRightsCounts.length ;i++ )
				{
					if(updateStuRightsCounts[i]<0  && updateStuRightsCounts[i] != -2 )
					{
						update_sturights_flag=false;
						break;
					}
					else
					{
						update_sturights_flag=true;
					}
				}
			}else{
				update_sturights_flag=true;
			}
			//Update the records in CA_RES_STUDY_RIGHTS End.
			//Delete the records in CA_RES_STUDY_RIGHTS Start.
			if(deleteStuRightsHashMap.size() >0){
				String deleteStuRightsQuery = "DELETE FROM CA_RES_STUDY_RIGHTS WHERE RESEARCH_CATEG_ID=? AND RESEARCH_CATEG_FACT_ID=? AND PRACTITIONER_ID=? AND FACILITY_ID=?";
				try
				{
					del_sturights_pstmt	= con.prepareStatement(deleteStuRightsQuery);
					delStuRightsMapData  = new HashMap();					
					for(int k=0 ; k < deleteStuRightsHashMap.size() ; k++){
						delStuRightsMapData  = (HashMap)deleteStuRightsHashMap.get(k);
						del_sturights_pstmt.setString(1,resePatCategory);
						del_sturights_pstmt.setString(2,reseCategoryFact);
						del_sturights_pstmt.setString(3,(String)delStuRightsMapData.get("practitionerId"));
						del_sturights_pstmt.setString(4,login_facility_id);
						
						del_sturights_pstmt.addBatch();
					}				
					deleteStuRightsCounts =  del_sturights_pstmt.executeBatch();
					if( del_sturights_pstmt!=null)  del_sturights_pstmt.close();
				}catch(Exception eIns){
					con.rollback();
					eIns.printStackTrace();
				}

				for (int i=0;i<deleteStuRightsCounts.length ;i++ )
				{
					if(deleteStuRightsCounts[i]<0  && deleteStuRightsCounts[i] != -2 )
					{
						delete_sturights_flag=false;
						break;
					}
					else
					{
						delete_sturights_flag=true;
					}
				}
			}else{
				delete_sturights_flag=true;
			}
			//Delete the records in CA_RES_STUDY_RIGHTS End.
			String error = "" ;
			String error_value = "0" ;
			if(insert_stuall_flag && update_stuall_flag && delete_stuall_flag&& insert_sturights_flag&& update_sturights_flag&& delete_sturights_flag)
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
				if(insertStuRightsHashMap != null) insertStuRightsHashMap.clear();
				if(updateStuRightsHashMap != null) updateStuRightsHashMap.clear();
				if(deleteStuRightsHashMap != null) deleteStuRightsHashMap.clear();
				
				if(insStuAllMapData != null) insStuAllMapData.clear();
				if(updStuAllMapData != null) updStuAllMapData.clear();
				if(delStuAllMapData != null) delStuAllMapData.clear();
				if(insStuRightsMapData != null) insStuRightsMapData.clear();
				if(updStuRightsMapData != null) updStuRightsMapData.clear();
				if(delStuRightsMapData != null) delStuRightsMapData.clear();

				if(ins_stuall_pstmt != null)ins_stuall_pstmt.close();
				if(upd_stuall_pstmt != null)upd_stuall_pstmt.close();
				if(del_stuall_pstmt != null)del_stuall_pstmt.close();
				if(ins_sturights_pstmt != null)ins_sturights_pstmt.close();	
				if(upd_sturights_pstmt != null)upd_sturights_pstmt.close();
				if(del_sturights_pstmt != null)del_sturights_pstmt.close();
			}
			catch(Exception fe)
			{
				//out.println("exception @ finally" + fe);//common-icn-0181
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
