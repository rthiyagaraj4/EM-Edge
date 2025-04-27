/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
26/08/2015	IN0052635		Vijayakumar K	26/08/2015		Ramesh Goli			PMG2014-CRF-0020 [IN:052635]
09/10/2015	IN057446		Vijayakumar K										PMG2014-CRF-0020.1 [IN:057446]
--------------------------------------------------------------------------------------------------------
*/
package eCA ;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class CAMainCustomizeToolbarServlet extends HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request= new XSSRequestWrapper(request); //MOHE-SCF-0153
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		java.io.PrintWriter out = response.getWriter();
		HttpSession session	=	null;
        session		=	request.getSession(true) ;

		try
        {
			insertCustIcons(request,response,session,out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	private void insertCustIcons(HttpServletRequest request, HttpServletResponse response, HttpSession session, PrintWriter out)
	{
		Connection con = null;
		PreparedStatement pstmtCheck = null ;
		PreparedStatement pstmtInsert = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String styleMap = "";
		if(sStyle.equals("IeStyleLime.css"))
		{
			styleMap = "Lime";
		}
		else if(sStyle.equals("IeStyleOrange.css"))
		{
			styleMap = "Orange";
		}
		else if(sStyle.equals("IeStyleVoilet.css"))
		{
			styleMap = "Violet";
		}
		else
		{
			styleMap = "";
		}

		try
		{
			java.util.Properties p;
			//HttpSession session;

			String client_ip_address="";
			String practitioner_id="";
			String option_id = "";
			String items[];
			String facilityId = "";
			String checked = "";
			String patient_id = "";
			String option_id1	= "";
			String short_desc	= "";
			String icon_file_name= "";
			String executable_name= "";
			String menu_id = "";
			String patientclass = "";
			String header_option_id = "";
			String pre_header_option_id = "";
			String resp_id = "";
			String reln_id = "";
			String episode_id = "";
			String errorMsg = "";

			int u = 0;
            int paramsSize =0;
			int count= 0;
			
			session				= request.getSession(false);
			p					= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale		= (String) p.getProperty("LOCALE");
			client_ip_address	= (String) p.getProperty("client_ip_address");
			facilityId			= (String)session.getValue("facility_id");
			resp_id				= (String)session.getValue("responsibility_id");
			reln_id				= (String)session.getValue("relationship_id");
			if(resp_id == null) resp_id = "";
			if(reln_id == null) reln_id = "";
			String addedById	= p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = facilityId;
			String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
			String modifiedDate = addedDate ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			boolean result = false ;
			boolean insertable = false ;
			StringBuffer icons = new StringBuffer("");
			StringBuffer strSql = new StringBuffer("");
			Hashtable htResMesg = new Hashtable();

			RecordSet recordset = null;
			practitioner_id = request.getParameter("practitioner_id");
			patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			checked = (request.getParameter("count")==null)?"0":request.getParameter("count");
			String queryString = request.getQueryString()== null?"":request.getQueryString() ;
			String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
			String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");

			menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
			String totMenuDisplay = request.getParameter("totMenuDisplay")==null?"":request.getParameter("totMenuDisplay");//IN0052635
			int iTotMenuDisplay = Integer.parseInt(totMenuDisplay); //IN0052635

			patientclass = request.getParameter("patientclass");
			count = Integer.parseInt(checked);
			try
			{
				recordset= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("CustomizeIcons","webbeans.eCommon.RecordSet",session);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			for(int j = 0; j <= count; j++)
            {
				if(request.getParameter("chk" + j) != null)
				{
					option_id = request.getParameter("chk" + j);
					
					if(!recordset.containsObject(option_id))
						recordset.putObject(option_id);
                }
			}
			paramsSize =  recordset.getSize();
			items = new String[paramsSize];
			for(int i = 0; i < recordset.getSize(); i++)
			{
                items[u] = (String)recordset.getObject(i);
				u++;
			}

//to refresh the CAMainTitle icons
		
			try
			{
				con = ConnectionManager.getConnection(request);
				StringBuffer check_sql =new StringBuffer();
				if(!patient_id.equals(""))
				{
					check_sql.append("delete from ca_custom_option where practitioner_id = ? and option_id in(SELECT option_id FROM  ca_option WHERE DESKTOP_YN <> 'Y' ) ");
				}
				else
				{
					check_sql.append("delete from ca_custom_option where practitioner_id = ? and option_id in(SELECT option_id FROM  ca_option WHERE DESKTOP_YN = 'Y') ");
				}
				pstmtCheck = con.prepareStatement(check_sql.toString());
				pstmtCheck.setString(1,practitioner_id);
				int detCount = pstmtCheck.executeUpdate();
				if(detCount >= 0)
					insertable = true;
				else
					insertable = false;
							
				if(pstmtCheck != null)pstmtCheck.close();

					
				StringBuffer insert_sql =new StringBuffer();
				insert_sql.append(" Insert into ca_custom_option ( practitioner_id,");
				insert_sql.append(" option_id,");
				insert_sql.append(" added_by_id,");
				insert_sql.append(" added_date,");
				insert_sql.append(" added_at_ws_no,");
				insert_sql.append(" added_facility_id,");
				insert_sql.append(" modified_by_id,");
				insert_sql.append(" modified_date,");
				insert_sql.append(" modified_at_ws_no,");
				insert_sql.append(" modified_facility_id ) ");
				insert_sql.append("  values(?,?,?,?,?,?,?,?,?,?)");
				pstmtInsert = con.prepareStatement(insert_sql.toString());
					
				
				if(insertable)
				{
					if(items.length == 0)
						result = true;

					for(int j = 0;j< items.length;j++)
					{
						if (items[j] != null)
						{	
							pstmtInsert.setString(1,practitioner_id);
							pstmtInsert.setString(2,items[j]);
							pstmtInsert.setString(3,addedById);
							pstmtInsert.setDate(4,added_date);
							pstmtInsert.setString(5,addedAtWorkstation);
							pstmtInsert.setString(6,addedFacilityId);
							pstmtInsert.setString(7,modifiedById);
							pstmtInsert.setDate(8,modified_date);
							pstmtInsert.setString(9,modifiedAtWorkstation);
							pstmtInsert.setString(10,modifiedFacilityId);

							int count1 = pstmtInsert.executeUpdate();
														
							if (count1 > 0 )
							{
								result = true;
							}

						}else{
							result = true;
						}
					}
				}
				if(pstmtInsert !=null) pstmtInsert.close();

				if (result)
				{
					con.commit();
					
					try
					{

						icons.append("<table width='100%' border=0 align=center cellpadding=0 cellspacing=0><tr class='iconBarRow'>");
						int k=0;
						int total_no_of_icons = 0;//IN0052635
						
						StringBuffer strOption = new StringBuffer();
						boolean Self_menu_exists = false;
						strOption.append("SELECT '1' FROM ca_custom_option a WHERE practitioner_id = ? and exists (select '1' from ca_option where option_id = a.option_id ");
						if(!patient_id.equals(""))
						{
							strOption.append(" AND DESKTOP_YN = 'N' )" );
						}
						else
						{
							strOption.append(" AND DESKTOP_YN = 'Y' )");
						}
						pstmt = con.prepareStatement(strOption.toString());
						pstmt.setString(1,practitioner_id);
						rs = pstmt.executeQuery();

						if(rs.next())
						{
							Self_menu_exists = true;
						}
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();

						strSql.append(" SELECT    DISTINCT  B.OPTION_ID||B.OPTION_OCCURANCE OPTION_ID  , B.OPTION_ID ONLY_OPTION_ID, NVL(C.USER_DEF_LONG_DESC,C.LONG_DESC)  SHORT_DESC  , C.EXECUTABLE_NAME  , DECODE(?, a.HEADER_OPTION_ID,'0', a.HEADER_OPTION_ID||B.HEADER_OPTION_OCCURANCE) HEADER_OPTION_ID  , a.ORDER_SEQ_NO  , nvl(C.OPEN_IN_MODAL_WINDOW_YN,'N') OPEN_IN_MODAL_WINDOW_YN   , C.HIST_OR_RECORD ");
	
						if(Self_menu_exists)
							strSql.append(" , NVL((SELECT 'Y' FROM ca_custom_option WHERE PRACTITIONER_ID = ? AND OPTION_ID = B.OPTION_ID ),'N') default_yn ");
						else
							strSql.append("  , C.Dflt_toolbar_option_yn default_yn ");

						strSql.append(" , C.ICON_FILE_NAME FROM  ( SELECT LEVEL LVL,OPTION_ID,ORDER_SEQ_NO,HEADER_OPTION_ID ,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE   FROM CA_MENU_DETAIL   WHERE MENU_ID=?  ");

						if(!patient_id.equals(""))
						{
							strSql.append(" AND DESKTOP_CHART = 'P' " );
						}
						else
						{
							strSql.append(" AND DESKTOP_CHART = 'D' ");
						}
						strSql.append(" START WITH HEADER_OPTION_ID=? and HEADER_OPTION_OCCURANCE=1 " );

						if(!patient_id.equals(""))
						{
							strSql.append(" AND DESKTOP_CHART = 'P' " );
						}
						else
						{
							strSql.append(" AND DESKTOP_CHART = 'D' ");
						}

						strSql.append(" CONNECT BY PRIOR  OPTION_ID=HEADER_OPTION_ID AND  OPTION_OCCURANCE=HEADER_OPTION_OCCURANCE) A  ,(SELECT  DISTINCT OPTION_ID,HEADER_OPTION_ID,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE FROM CA_MENU_DETAIL  WHERE MENU_ID=? "); 
						if(!patient_id.equals(""))
						{
							strSql.append(" AND DESKTOP_CHART = 'P' " ); 
							if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
								strSql.append(" AND OPTION_ID not in ( 'CLINICAL_NOTES' ,'CLINICAL_NOTES_NEW','PATCHIEFCOMPLAINT','REL_PAT_TREAT_PAT','CA_TASK_LIST','CA_TASK_LIST_DT')" );
							
						}
						else
						{
							if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
								strSql.append(" AND OPTION_ID not in ( 'CA_TASK_LIST','REL_PAT_TREAT','CA_TASK_LIST_DT')" );

							strSql.append(" AND DESKTOP_CHART = 'D' ");
						}
						strSql.append(" START WITH MENU_ID=? AND ");
						if(!patient_id.equals(""))
						{
							strSql.append(" DESKTOP_CHART = 'P' " );
						}
						else
						{
							strSql.append("  DESKTOP_CHART = 'D' ");
						}
						strSql.append(" AND OPTION_ID IN (SELECT B.OPTION_ID FROM CA_APPL_TASK a, ca_option b WHERE a.option_id=b.option_id and 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,?,?,?,?,?) and (a.BASE_MODULE_ID='CA' or  exists( select 1 from sm_module where install_yn='Y' and MODULE_ID =a.BASE_MODULE_ID ");
						if(!patient_id.equals(""))
						{
							strSql.append("  and ( MODULE_GROUP_ID!='SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID =a.BASE_MODULE_ID AND  SPECIALITY_CODE =? )) ");
						}

						strSql.append(" )) "); 
						
						if (patient_id.equals("") )
						{
						strSql.append(" and b.DESKTOP_YN='Y' ");
						}
						else
						{
							if (mode.equals("V"))
								strSql.append(" and B.HIST_OR_RECORD='H' ");
							if (patientclass.equals(""))
							{
								patientclass="XT";
							}
							strSql.append(" and b.APPL_"+patientclass+"_YN='Y' ");
						}

						strSql.append(" ) "); 

						if(!patient_id.equals("") )
						{
							strSql.append(" AND DESKTOP_CHART = 'P' " );
						}
						else
						{
							strSql.append(" AND DESKTOP_CHART = 'D' ");
						}

						strSql.append("  CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID and HEADER_OPTION_OCCURANCE=OPTION_OCCURANCE ) B   , CA_OPTION_LANG_VW C   WHERE C.LANGUAGE_ID = ?  AND A.OPTION_ID=B.OPTION_ID AND A.HEADER_OPTION_ID=B.HEADER_OPTION_ID AND A.HEADER_OPTION_OCCURANCE=B.HEADER_OPTION_OCCURANCE AND A.OPTION_OCCURANCE=B.OPTION_OCCURANCE AND C.OPTION_ID(+)=B.OPTION_ID  ");
						
						if(Self_menu_exists)
							strSql.append(" and NVL((SELECT 'Y' FROM ca_custom_option WHERE PRACTITIONER_ID = ? AND OPTION_ID = B.OPTION_ID ),'N') = 'Y' ");
						else
							strSql.append(" and C.Dflt_toolbar_option_yn = 'Y' ");

						strSql.append("ORDER BY A.ORDER_SEQ_NO ");

						pstmt = con.prepareStatement(strSql.toString());
						int indval =1;
						pstmt.setString(indval++,menu_id);
						if(Self_menu_exists)
							pstmt.setString(indval++,practitioner_id);
						pstmt.setString(indval++,menu_id);
						pstmt.setString(indval++,menu_id);
						pstmt.setString(indval++,menu_id);
						pstmt.setString(indval++,menu_id);
						pstmt.setString(indval++,resp_id);
						pstmt.setString(indval++,reln_id);
						pstmt.setString(indval++,facilityId);
						pstmt.setString(indval++,episode_id);
						pstmt.setString(indval++,patient_id);
						if(!patient_id.equals(""))
						{
							pstmt.setString(indval++,speciality_code);
						}
						pstmt.setString(indval++,locale);
						if(Self_menu_exists)
							pstmt.setString(indval++,practitioner_id);
						
						/*pstmt.setString(1,practitioner_id);
						pstmt.setString(2,menu_id);
						pstmt.setString(3,resp_id);
						pstmt.setString(4,reln_id);
						pstmt.setString(5,facilityId);
						pstmt.setString(6,episode_id);
						pstmt.setString(7,patient_id);
						if(!patient_id.equals(""))
							pstmt.setString(8,speciality_code);*/
						
						rs = pstmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{
								option_id1 = rs.getString("OPTION_ID")==null?"":rs.getString("OPTION_ID");
								short_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
								icon_file_name = rs.getString("ICON_FILE_NAME")==null?"":rs.getString("ICON_FILE_NAME");
								executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");

								if(executable_name.indexOf("?") != -1)
								{
									executable_name=executable_name + "&option_id="+option_id1+"&"+queryString;
								}
								else
								{
									executable_name=executable_name+"?"+"option_id="+option_id1+"&"+queryString;
								}
								header_option_id = rs.getString("HEADER_OPTION_ID")==null?"":rs.getString("HEADER_OPTION_ID");
								if(k<iTotMenuDisplay)//IN0052635
								{ 
									if(k > 0)
									{
										if(header_option_id.equals(pre_header_option_id))
										{
											//icons.append("<td class='Iconback'><img id='divider' src='../../eCA/images/MI_Divider.jpg' alt='' height='28' width='3'></img></td>");
										}
										else
										{
											icons.append("<td class='iconBar'><img id='seperator' src='../../eCA/images/MI_GroupSeperator"+styleMap+".jpg' alt=''></img></td>");
										}
									}
									icons.append("<td class='iconBar'><a href='#' class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img src='../../eCA/images/"+icon_file_name+"' id='"+option_id1+"' onclick=~callFunction('"+option_id1+"','"+short_desc+"','"+executable_name+"')~  alt='"+short_desc+"' title='"+short_desc+"'></img></a></td>");
								
									pre_header_option_id = header_option_id;
									k++;
								} //IN0052635
								total_no_of_icons++; //IN0052635
							}
							//IN0052635 starts
							if(k < total_no_of_icons)
							{
								//IN057446 starts
								//icons.append("<td class='iconBar'><a href='#' class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img src='../../eCA/images/eca_more_icon.jpeg' id='extraicons' onclick=~callMenuIcons('"+queryString+"')~  alt='More icons'></img></a><input type='hidden' name='total_icon_records' value='"+total_no_of_icons+"'><input type='hidden' name='no_icons_displayed' value='"+k+"'></td>");
								int iFrom = 1 + iTotMenuDisplay;
								int iTo = k + iTotMenuDisplay;
								icons.append("<td class='iconBar'><a href='#' class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img src='../../eCA/images/eca_icon_next.jpeg' id='next' onclick=~callMenuIcons('"+queryString+"','"+iFrom+"','"+iTo+"','"+total_no_of_icons+"')~  alt='Next' title='Next'></img></a></td>");
								//IN057446 ends
							}
							//IN0052635 ends
							
						}
						else
						{
							icons.append("<td class='iconBar'>&nbsp;</td>");
						}
						icons.append("</tr></table>");
						if(rs != null)rs.close();
						if(pstmt != null)pstmt.close();

						htResMesg = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
						errorMsg = (String)htResMesg.get("message");
					}
					catch (Exception e)
					{
						e.printStackTrace();
						
					}
					out.println("<script>alert('"+errorMsg+"');</script>");
					/*out.println("<script>parent.window.returnValue=\""+icons.toString()+"\";</script>");
					out.println("<script>parent.window.close();</script>");*/
					
					out.println("<script>let dialogBody = parent.parent.document.getElementById('dialog-body');</script>");
					out.println("<script>dialogBody.contentWindow.returnValue = \""+icons.toString()+"\";</script>");
					out.println("<script>const dialogTag = parent.parent.document.getElementById('dialog_tag');  dialogTag.close();  </script>");
				}
				else
				{
					con.rollback();
					htResMesg = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
					errorMsg = (String)htResMesg.get("message");

					out.println("<script>alert('"+errorMsg+"');</script>");
					/*out.println("<script>parent.window.returnValue=\"\";</script>");
					out.println("<script>parent.window.close();</script>");*/
					
					out.println("<script>let dialogBody = parent.parent.document.getElementById('dialog-body');</script>");
					out.println("<script>dialogBody.contentWindow.returnValue = \"\";</script>");
					out.println("<script>const dialogTag = parent.parent.document.getElementById('dialog_tag');  dialogTag.close();  </script>");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			finally
	 		{
				 try{
					 if(con != null) ConnectionManager.returnConnection(con,request);
				 }catch(Exception exc){
				 exc.printStackTrace();
				 }
			}
	//end		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
