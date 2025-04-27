/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       	Rev.Date	  Rev. Name				Description
--------------------------------------------------------------------------------------------------------------

17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
08/06/2018	  IN067886		Kamalakannan	08/06/2018		Ramesh				CA-GHL-CRF-0497/01
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import java.net.URLEncoder;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.RecordSet;
 
public class NoteTypeForResponsibilityServlet extends HttpServlet
	{
		private String getMessage(String locale, String messageId, String moduleId)
		{
			java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
			String mesg = (String) message.get("message");
			message.clear();
			return(mesg) ;
		}
	 public  void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
		{
		PrintWriter out;
	    Properties p;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();

		String group_by = "", grp_by_code = "", associate="", insUpd="", privilege_type="",dflt_transcription_yn="",in_err_access_yn="";//IN066108
		String optionValStr = "", valid_rec="", insUpd_val="";

		RecordSet recordSet ;
		Connection con				= null;

		PreparedStatement ins_pstmt = null;
		PreparedStatement upd_pstmt = null;
		PreparedStatement del_pstmt	= null;

		ArrayList insertHashMap		= null;
		ArrayList updateHashMap		= null;
		ArrayList deleteHashMap		= null;	

		HashMap	 split				= null;
		HashMap	 insMapData			= null;
		HashMap updMapData			= null;
		HashMap delMapData			= null;

		HashMap hMapAlter			= new HashMap();
		HashMap htNameVal			= new HashMap();
		int [] insertCounts			= null;
		int [] updateCounts			= null;
		int [] deleteCounts			= null;
				
		boolean insert_flag			= false ;
		boolean update_flag			= false ;
		boolean delete_flag			= false ;

		HttpSession httpsession		= request.getSession(false);
        p							= (Properties)httpsession.getValue("jdbc");
		String locale		= (String) p.getProperty("LOCALE");
		String login_by_id			= p.getProperty("login_user");						
		String login_at_ws_no		= p.getProperty("client_ip_address");
		String login_facility_id	= (String)httpsession.getValue("facility_id");
		String dflt_name ="";
		String dflt_value ="";
		String inErrorYNName = "";//IN066108
		String inErrorYNValue = "";//IN066108

		recordSet= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("NTRecordSet","webbeans.eCommon.RecordSet",httpsession);

		group_by					= request.getParameter("group_by");
		grp_by_code					= request.getParameter("grp_by_code");
		optionValStr				= request.getParameter("optionValStr");
	
		if(group_by == null || group_by.equals(""))group_by="";
		if(grp_by_code == null || grp_by_code.equals(""))grp_by_code="";
		if(optionValStr == null || optionValStr.equals(""))optionValStr="";

	
		try
		{
			if(!optionValStr.equals(""))
			{
				StringTokenizer stoken_code = new StringTokenizer(optionValStr,"~");
			
				int count_code		=	stoken_code.countTokens();

				for(int i=0;i<count_code;i++)
				{
					String name_value =	stoken_code.nextToken();
					htNameVal.put("name_value"+i,name_value);
				}

				for(int j=0; j<htNameVal.size(); j++)
				{
					String name_value			=	(String)htNameVal.get("name_value"+j);
					
					if(name_value ==null) name_value="";
					
					StringTokenizer split_value	=	new StringTokenizer(name_value,"||");
					String name					=	split_value.nextToken();
					
					if(name ==null) name="";
					
					String value				=	split_value.nextToken();
					
					if(value ==null) value="";
					if(!(group_by.equals("NT")))
					{
					
					  dflt_name					=	split_value.nextToken();					
					  if(dflt_name ==null) dflt_name="";
					
					  dflt_value				=	split_value.nextToken();					
					 if((dflt_value ==null) || dflt_value.equals("")) dflt_value="";
					//IN066108 start
					 if(!(group_by.equals("SP")) && split_value.hasMoreTokens()){
					 inErrorYNName				=	split_value.nextToken();
					 if((inErrorYNName == null)) inErrorYNName="";
					 
					 inErrorYNValue				=	split_value.nextToken();
					 if((inErrorYNValue == null)) inErrorYNValue="";
					 }
					 //IN066108 end
				   }
					
					String index_val			=	name.substring(9);
					
					if(index_val ==null) index_val="";
					
					int index					=	Integer.parseInt(index_val);

					if(value.equals("0")) value = "";

					hMapAlter = (java.util.HashMap)recordSet.getObject(index);
					
					valid_rec = (String)hMapAlter.get("valid");


					if(valid_rec!=null)
					{
						if(valid_rec.equals("Y")) 
						{
							insUpd_val = "U" ;
						}
						else if(valid_rec.equals("N")) 
						{
							if(value.equals("1")||value.equals("2")||value.equals("3")||value.equals("4")||value.equals("5")||value.equals("P")||value.equals("S"))
							{
								insUpd_val = "I";
							}
							else
							{
								insUpd_val="";
							}
						}
						if(valid_rec.equals("Y"))
						{
							hMapAlter.put("privilege_type", value);
							hMapAlter.put("associate"	  , "Y");
							hMapAlter.put("insUpd"		  , insUpd_val);
							if(!(group_by.equals("NT")))
	                       {
							 hMapAlter.put("dflt_transcription_yn"		  , dflt_value);
							//IN066108 start
							 if(!(group_by.equals("SP"))){
							 hMapAlter.put("in_error_yn"		  , inErrorYNValue);
							 }
							 //IN066108 end
						   }
							recordSet.setObject(index, hMapAlter);
						}
						else if(valid_rec.equals("N"))
						{
							if(!value.equals("")) 
							{
								hMapAlter.put("privilege_type", value);
								hMapAlter.put("associate"	  , "Y");
								hMapAlter.put("insUpd"		  , insUpd_val);
								if(!(group_by.equals("NT")))
	                          {
								hMapAlter.put("dflt_transcription_yn"		  , dflt_value);
								//IN066108 start
								if(!(group_by.equals("SP"))){
								hMapAlter.put("in_error_yn"		  , inErrorYNValue);//IN067886
								}
								//IN066108 end
							  }
								recordSet.setObject(index, hMapAlter);
							}
						}
					}
				}
			}

			con = ConnectionManager.getConnection(p);

			insertHashMap = new ArrayList();
			updateHashMap = new ArrayList();
			deleteHashMap = new ArrayList();
			split		  = new HashMap();	
		
			for(int j=0;j<recordSet.getSize();j++)
			{


				split			= (HashMap)recordSet.getObject(j);
				associate		= (String) split.get("associate");
				insUpd			= (String) split.get("insUpd");
				privilege_type	= (String) split.get("privilege_type");
				if(!(group_by.equals("NT")))
	               {
				    dflt_transcription_yn	= (String) split.get("dflt_transcription_yn");
				    //IN066108 start
					if(!(group_by.equals("SP"))){
				    in_err_access_yn	= (String) split.get("in_err_access_yn");
				    System.out.println("in_err_access_yn-->"+in_err_access_yn);
				    }
					//IN066108 end
				   }

				if(associate.equals("Y"))
				{
					if(insUpd.equals("I"))
					{
						insertHashMap.add(split);
					}
					else if(insUpd.equals("U"))
					{
						if(!privilege_type.equals(""))
						{
							updateHashMap.add(split);
						}
						else if(privilege_type.equals(""))
						{
							deleteHashMap.add(split);
						}
					}
				}
			}
			if(insertHashMap.size() >0)
			{
				String insertQuery="";
				if(group_by.equals("RS"))
				{
					insertQuery = "Insert into ca_note_type_for_resp (RESP_ID, NOTE_TYPE, PRIVILEGE_TYPE,DFLT_TRANSCRIPTION_YN, ADDED_BY_ID,  ADDED_DATE , ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,IN_ERR_ACCESS_YN) values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";//IN066108

				}else if(group_by.equals("NT"))
				{
					insertQuery = "Insert into ca_note_type_for_resp (RESP_ID, NOTE_TYPE, PRIVILEGE_TYPE, ADDED_BY_ID,  ADDED_DATE , ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

				//IN066108 start
				}
				else if(group_by.equals("PR"))
				{
					insertQuery = "Insert into ca_note_type_for_resource (resource_code,note_type_id, resource_type,DFLT_TRANSCRIPTION_YN, ADDED_BY_ID,  ADDED_DATE , ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,IN_ERR_ACCESS_YN) values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)"; 
				}//IN066108 stop
				else 
				{
					insertQuery = "Insert into ca_note_type_for_resource (resource_code,note_type_id, resource_type,DFLT_TRANSCRIPTION_YN, ADDED_BY_ID,  ADDED_DATE , ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
				}

				try
				{

					ins_pstmt	= con.prepareStatement(insertQuery);
					insMapData  = new HashMap();
					

					for(int k=0 ; k < insertHashMap.size() ; k++)
					{
						int reccol=0;
						insMapData  = (HashMap)insertHashMap.get(k);
						String dflt_transcription=(String)insMapData.get("dflt_transcription_yn");
						String in_error_yn = (String) insMapData.get("in_error_yn");//IN066108
						if(dflt_transcription ==null) dflt_transcription="";
						dflt_transcription=dflt_transcription.trim();
						if(dflt_transcription.equals("1") || dflt_transcription.equals("Y"))
						{
							dflt_transcription="Y";
						}
						else if(dflt_transcription.equals("N") || dflt_transcription.equals("0"))
						{
							dflt_transcription="N";
						}
						//IN066108 start
						if(in_error_yn ==null || in_error_yn=="" ) in_error_yn="N";//IN066108
						in_error_yn=in_error_yn.trim();
						if(in_error_yn.equals("1") || in_error_yn.equals("Y"))
						{
							in_error_yn="Y";
						}
						else if(in_error_yn.equals("N") || in_error_yn.equals("0"))
						{
							in_error_yn="N";
						}
						//IN066108 end
						if(group_by.equals("NT"))
						{
							ins_pstmt.setString(++reccol,(String)insMapData.get("code"));
						}						
						else if(group_by.equals("RS")||group_by.equals("PR")||group_by.equals("SP"))
						{
							ins_pstmt.setString(++reccol,grp_by_code);
						}
						
						if(group_by.equals("NT"))
						{
							ins_pstmt.setString(++reccol,grp_by_code);
						}
						else if(group_by.equals("RS")||group_by.equals("PR")||group_by.equals("SP"))
						{
							ins_pstmt.setString(++reccol,(String)insMapData.get("code"));
						}
						
						if(group_by.equals("PR")||group_by.equals("SP"))
						{
							String  resource_type="";
							resource_type=insMapData.get("privilege_type").toString();
	
							if(resource_type ==null) resource_type="";
							resource_type=resource_type.trim();
							if(resource_type.equals("1")||resource_type.equals("P")||resource_type.equals("S"))
							{
								if(group_by.equals("PR"))
								{
									ins_pstmt.setString(++reccol,"P");
								}
								else if(group_by.equals("SP"))
								{
									ins_pstmt.setString(++reccol,"S");
								}
							}
						}
						else
						{
							ins_pstmt.setString(++reccol,(String)insMapData.get("privilege_type"));
						}
						if(group_by.equals("PR")||group_by.equals("SP")||group_by.equals("RS"))
						{
						 ins_pstmt.setString(++reccol,dflt_transcription);
						}

						ins_pstmt.setString(++reccol,login_by_id);
						ins_pstmt.setString(++reccol,login_at_ws_no);
						ins_pstmt.setString(++reccol,login_facility_id);
						ins_pstmt.setString(++reccol,login_by_id);
						ins_pstmt.setString(++reccol,login_at_ws_no);
						ins_pstmt.setString(++reccol,login_facility_id);
						//IN066108 start
						if(group_by.equals("PR") || group_by.equals("RS"))
						ins_pstmt.setString(++reccol,in_error_yn);
						//IN066108 stop
						ins_pstmt.addBatch();
					}
					insertCounts = ins_pstmt.executeBatch();
				}
				catch(Exception eIns)
				{
					//out.println("exception @Insert :"+eIns);//common-icn-0181

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
						insert_flag=true;
				}
			}
			else
				insert_flag=true;

			if(insert_flag && updateHashMap.size()>0 )
			{
				String updateQuery="";
				if(group_by.equals("RS"))
				{
					updateQuery = "update ca_note_type_for_resp set PRIVILEGE_TYPE = ? , DFLT_TRANSCRIPTION_YN=?,MODIFIED_BY_ID = ? ,  MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,IN_ERR_ACCESS_YN = ? where RESP_ID = ? and  NOTE_TYPE = ?"; //IN066108
				}
				else if(group_by.equals("NT"))
				{
					updateQuery = "update ca_note_type_for_resp set PRIVILEGE_TYPE = ? , MODIFIED_BY_ID = ? ,  MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  where RESP_ID = ? and  NOTE_TYPE = ?"; 


				}
				//IN066108 start
				else if(group_by.equals("PR"))
				{
					updateQuery = "update ca_note_type_for_resource set resource_type = ? , DFLT_TRANSCRIPTION_YN=?,MODIFIED_BY_ID = ? ,  MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,IN_ERR_ACCESS_YN = ?  where resource_code = ? and  note_type_id = ?"; 
				}
				//IN066108 end
				else
				{
					updateQuery = "update ca_note_type_for_resource set resource_type = ? , DFLT_TRANSCRIPTION_YN=?,MODIFIED_BY_ID = ? ,  MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  where resource_code = ? and  note_type_id = ?"; 
				}
			
				try
				{
					upd_pstmt	= con.prepareStatement(updateQuery);
					updMapData  = new HashMap();
					String dflt_transcription="";
					String in_err_access = "";//IN066108
					updMapData  = new HashMap();
					
					for(int k=0 ; k <  updateHashMap.size() ; k++)
					{
						int reccount=0;
						updMapData  = (HashMap)updateHashMap.get(k);
						dflt_transcription=(String)updMapData.get("dflt_transcription_yn");
						in_err_access =(String)updMapData.get("in_error_yn");//IN066108
						if(dflt_transcription ==null) dflt_transcription="";
						dflt_transcription=dflt_transcription.trim();
						if(dflt_transcription.equals("1") || dflt_transcription.equals("Y"))
						{
							dflt_transcription="Y";
						}
						else if(dflt_transcription.equals("0") || dflt_transcription.equals("N") )
						{
							dflt_transcription="N";
						}
						//IN066108 start
						if(in_err_access ==null) in_err_access="";
						in_err_access=in_err_access.trim();
						if(in_err_access.equals("1") || in_err_access.equals("Y"))
						{
							in_err_access="Y";
						}
						else if(in_err_access.equals("0") || in_err_access.equals("N") )
						{
							in_err_access="N";
						}
						//IN066108 end
						if(group_by.equals("PR")||group_by.equals("SP"))
						{
							String  resource_type="";
							resource_type=updMapData.get("privilege_type").toString();
						
							if(resource_type ==null) resource_type="";
							resource_type=resource_type.trim();
							if(resource_type.equals("1")||resource_type.equals("P")||resource_type.equals("S"))
							{
								if(group_by.equals("PR"))
								{
									upd_pstmt.setString(++reccount,"P");
								}
								else if(group_by.equals("SP"))
								{
									upd_pstmt.setString(++reccount,"S");
								}
							}
						}
						else
						{
							upd_pstmt.setString(++reccount,(String)updMapData.get("privilege_type"));
						}
						if(group_by.equals("PR")||group_by.equals("SP")||group_by.equals("RS"))
						{

							upd_pstmt.setString(++reccount,dflt_transcription);
						}

						
						upd_pstmt.setString(++reccount,login_by_id);
						upd_pstmt.setString(++reccount,login_at_ws_no);
						upd_pstmt.setString(++reccount,login_facility_id);
						if(group_by.equals("PR")||group_by.equals("RS"))
						{

							upd_pstmt.setString(++reccount,in_err_access);
						}
						//IN066108 end
						if(group_by.equals("NT"))
						{
							upd_pstmt.setString(++reccount,(String)updMapData.get("code"));

						}
						else if(group_by.equals("RS")||group_by.equals("PR")||group_by.equals("SP"))
						{
							upd_pstmt.setString(++reccount,grp_by_code);
						}
						
						if(group_by.equals("NT"))
						{
							upd_pstmt.setString(++reccount,grp_by_code);
						}
						else if(group_by.equals("RS")||group_by.equals("PR")||group_by.equals("SP"))
						{
							upd_pstmt.setString(++reccount,(String)updMapData.get("code"));
						}
							
						upd_pstmt.addBatch();
					}
					updateCounts = upd_pstmt.executeBatch();
				}
				catch(Exception eupd)
				{
					//out.println("Exception @ Update :"+eupd);//common-icn-0181
					
					eupd.printStackTrace();
				}
			
				for (int i=0;i<updateCounts.length ;i++ )
				{
					if(updateCounts[i]<0  && updateCounts[i] != -2 )
					{
						update_flag=false;
						break;
					}
					else
						update_flag=true;
				}
			}
			else
				update_flag = true;

			if(insert_flag && update_flag && deleteHashMap.size() >0 )
			{
				String deleteQuery="";

				if(group_by.equals("RS")||group_by.equals("NT"))
				{
					deleteQuery = "Delete from ca_note_type_for_resp where RESP_ID = ? and NOTE_TYPE = ?"; 
				}
				else
				{
					deleteQuery = "Delete from ca_note_type_for_resource where resource_code = ? and note_type_id = ?";
				}


				try
				{
					del_pstmt	= con.prepareStatement(deleteQuery);
					delMapData  = new HashMap();

					for(int k=0 ; k < deleteHashMap.size() ; k++)
					{
					delMapData  = (HashMap)deleteHashMap.get(k);

					if(group_by.equals("NT"))
					{
						del_pstmt.setString(1,(String)delMapData.get("code"));
					}else if(group_by.equals("RS")||group_by.equals("PR")||group_by.equals("SP"))
					{
						del_pstmt.setString(1,grp_by_code);
					}

					if(group_by.equals("NT"))
					{
						del_pstmt.setString(2,grp_by_code);
					}else if(group_by.equals("RS")||group_by.equals("PR")||group_by.equals("SP"))
					{
						del_pstmt.setString(2,(String)delMapData.get("code"));
					}

					del_pstmt.addBatch();
				}

				deleteCounts = del_pstmt.executeBatch();
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
				String msg = getMessage(locale, "RECORD_INSERTED","CA");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(msg,"UTF-8") + "&err_value=1");
			}
			else
			{
				con.rollback();
				String msg = getMessage(locale, "FAILED_TRANSACTION","CA");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(msg,"UTF-8") + "&err_value=0");
			}
	
			if(ins_pstmt != null)ins_pstmt.close();
			if(upd_pstmt != null)upd_pstmt.close();
			if(del_pstmt != null)del_pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception in main try :" +e);//common-icn-0181
			
			e.printStackTrace();
		}
		finally
		{
					if(con!=null)ConnectionManager.returnConnection(con, p);
					if(hMapAlter!=null)
						hMapAlter.clear();
					 if(htNameVal!=null)
						 htNameVal.clear();
					if(split!=null)
						split.clear();
					if(insertHashMap!=null)
						insertHashMap.clear();
					if(insMapData!=null)
						insMapData.clear();
					if(updateHashMap!=null)
						updateHashMap.clear();
					if(updMapData!=null)
						updMapData.clear();
					if(deleteHashMap!=null)
						deleteHashMap.clear();
					if(delMapData!=null)
						delMapData.clear();
		}
	}
}
