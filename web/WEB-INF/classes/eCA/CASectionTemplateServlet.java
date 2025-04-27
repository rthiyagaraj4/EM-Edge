/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description							Review		Date
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
05/07/2016		IN059630		Krishna Gowtham		GHL-CRF-0401						 Vijay K	
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2017	IN061907	Krishna Gowtham J	26/02/2017	Ramesh G		ML-MMOH-CRF-0559
------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import java.util.*;
//import oracle.sql.*;
import eCA.SectionTemplate.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;


public class CASectionTemplateServlet extends HttpServlet 
{    
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		java.io.PrintWriter		out			=	null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8 ");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		out	=	response.getWriter() ;
        
		try
        {
            insertSectionTemplate(request,response);
		}
		catch(Exception e)
		{
			//out.println("Exception@Servlet:1 of CASectionTemplateServlet.java --- "+e.toString());
			e.printStackTrace();
		}
    }

	private void insertSectionTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
	{
		HttpSession				session		=	null;
		java.io.PrintWriter		out			=	null;
		java.util.Properties	jdbc_props	=	null;

		out = response.getWriter();
		session						=	request.getSession(false);

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		response.setContentType("text/html; charset=UTF-8 ");
		
		out.println ("<html><meta HTTP-EQUIV='content-type' CONTENT='text/html; charset=UTF-8'><head>");
		out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/" + sStyle + "'></link>");
		out.println ("<title>Result</title></head>");
		out.println ("<body class='MESSAGE'>");
		
		Connection			con				=	null;
		HashMap htSectionTemplate 			=	new java.util.HashMap();

		String		section						=	"",		item_type					=	"";
		String		title_text					=	"",		component					=	"";
		String		component_prompt			=	"",		row_position				=	"";
		String		column_position				=	"",	    column_span					=	"";
		String		disp_position    			=	"",     login_user_id				=   "";
		String		operation					=   "",		srl_no						=	"";
		String		prev_row_pos_no				=	"",		prev_column_pos_no			=	"";
		String		prev_no_of_col_span			=	"",     added_facility_id			=	"";
		String		component_type				=	"",		formula_definition			=	"";
		String		age_group_code				=	"",		hist_rec_type				=	"";
		String		acceptOption				=	"",		selectionSelect				=	"";
		String		presentationSelect			=	"",		prefixRequired				=	"";
		String		hintMessage					=	"",		formulaResultType			=	"";
		String		includeDates				=	"",		formulaResultUnits			=	"";
		String		title_text_code				=	"";

		String includeyn="";
		String strParseStatus = "";
		String client_ip_address = "";
		String old_hist_time_frame_unit = "",old_hist_time_frame_val = "";
		String event_code = "",event_code_type="",dflt_from_hist_appl_yn = "";
		String comp_prompt_desc ="";
		String insertQry = "";
		String sql ="";
		String label_id = "";
		String template_type = "";
		String comp_disp_next_yn=""; //IN059630_GHL-CRF-0401
		String auto_result_yn	="";//IN061907
		int  rowCount = 0;
		int  insert_result						= 99;

		
		PreparedStatement psmt = null;
		ResultSet rsmt = null;
		
		boolean bUpdStatus = false;

		CASectionTemplateFieldsAssociationBean templateBean = null;

		try
        {	
			con							=	ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			
			login_user_id				=	(String)		session.getValue("login_user");
			added_facility_id			=	(String)		session.getValue("facility_id");
			jdbc_props					=	(Properties)	session.getValue("jdbc") ;
			String locale				=	(String)		jdbc_props.getProperty("LOCALE");
			client_ip_address			=	jdbc_props.getProperty("client_ip_address");

			section					=	(request.getParameter("section")==null)	?""	:	request.getParameter("section");
			item_type				=	(request.getParameter("hitem_type")==null)	?""	:	request.getParameter("hitem_type");
			title_text				=	(request.getParameter("title_text")==null)	?""	:	request.getParameter("title_text");
			title_text_code			=	(request.getParameter("title_text_code")==null)	?""	:	request.getParameter("title_text_code");
			srl_no					=	(request.getParameter("srl_no")==null)	?""	:	request.getParameter("srl_no");
			component				=	(request.getParameter("component")==null)?"":	request.getParameter("component");
			component_prompt		=	(request.getParameter("component_prompt"	)==null) ?"":	request.getParameter("component_prompt");
			row_position			=	(request.getParameter("row_position")==null)	?""	:	request.getParameter("row_position");
			column_position			=	(request.getParameter("column_position")==null)	?""	:	request.getParameter("column_position");
			column_span				=	(request.getParameter("column_span")==null)	?"0"	:	request.getParameter("column_span");
			disp_position			=	(request.getParameter("disp_position")==null)	?""	:	request.getParameter("disp_position");
			operation				=	(request.getParameter("operation")==null)	?""	:	request.getParameter("operation");

			prev_row_pos_no			=	(request.getParameter("prev_row_pos_no")==null)		?"0"	:	request.getParameter("prev_row_pos_no");
			prev_column_pos_no		=	(request.getParameter("prev_column_pos_no")==null)	?"0"	:	request.getParameter("prev_column_pos_no");
			prev_no_of_col_span		=	(request.getParameter("prev_no_of_col_span")==null)	?"0"	:	request.getParameter("prev_no_of_col_span");
			component_type			=	(request.getParameter("component_type")==null)	?""	:	request.getParameter("component_type");
			formula_definition		=	(request.getParameter("formula_definition")==null)	?""	:	request.getParameter("formula_definition");
			age_group_code			=	(request.getParameter("age_group_code")==null)	?""	:	request.getParameter("age_group_code");
			template_type			=	(request.getParameter("template_type")==null)	?""	:	request.getParameter("template_type");
			comp_disp_next_yn		=	(request.getParameter("textAllignYN")==null)	?"N"	:	request.getParameter("textAllignYN"); //IN059630_GHL-CRF-0401
			auto_result_yn			=	(request.getParameter("autoResultYN")==null)	?"N"	:	request.getParameter("autoResultYN");//IN061907
			if(component_type.equals("I") || component_type.equals("N") || component_type.equals("H"))
				hist_rec_type			=	(request.getParameter("hist_rec_type_hidden")==null)	?""	:	request.getParameter("hist_rec_type_hidden");
			else
				hist_rec_type			=	(request.getParameter("hist_rec_type")==null)	?""	:	request.getParameter("hist_rec_type");

			acceptOption		=	(request.getParameter("acceptOption")==null)	?""	:	request.getParameter("acceptOption");
			presentationSelect	=	(request.getParameter("presentationSelect")==null)	?""	:	request.getParameter("presentationSelect");
			selectionSelect		=	(request.getParameter("selectionSelect")==null)	?presentationSelect:request.getParameter("selectionSelect");
			prefixRequired		=	(request.getParameter("prefixRequired")==null)	?"N":"Y";
			hintMessage			=	(request.getParameter("hintMessage")==null)	?"":request.getParameter("hintMessage");
			includeyn			=	(request.getParameter("includeyn")==null)	?"":request.getParameter("includeyn");

			old_hist_time_frame_val			=	(request.getParameter("old_hist_time_frame_val")==null)	?"":request.getParameter("old_hist_time_frame_val");
			old_hist_time_frame_unit			=	(request.getParameter("old_hist_time_frame_unit")==null)	?"":request.getParameter("old_hist_time_frame_unit");

			event_code				= request.getParameter("event_code") == null ? "" : request.getParameter("event_code");
			event_code_type			= request.getParameter("event_code_type") == null ? "" : request.getParameter("event_code_type");
			dflt_from_hist_appl_yn	= request.getParameter("dflt_from_hist_appl_yn") == null ? "N" : request.getParameter("dflt_from_hist_appl_yn");
			comp_prompt_desc		=	(request.getParameter("component_promptdiag"	)==null) ?"":	request.getParameter("component_promptdiag");

			if(presentationSelect.equals("M"))
	            acceptOption="O"; 

			if(component_type.equals("A"))
			{
				formulaResultType	=	(request.getParameter("formulaResultType")==null)	?"":request.getParameter("formulaResultType");
				includeDates		=	(request.getParameter("includeDates_hiddenfield")==null)	?"":request.getParameter("includeDates_hiddenfield");
				formulaResultUnits	=	(request.getParameter("formulaResultUnits")==null)	?"":request.getParameter("formulaResultUnits");
			}
			//IN061907 start
			if(!(hist_rec_type).equals("DIAG"))
				auto_result_yn="N";
			//IN061907 end
	
			try
			{
				PreparedStatement pstmt = null;

				if( !(operation.equals("Delete")) )
				{
					if (!(operation.equals("modify")))
					{
						if(item_type.equals("C"))
						{
							sql = "SELECT COUNT(*) total FROM CA_TEMPLATE_LABEL WHERE DISCR_MSR_ID= ? AND LABEL_TYPE = 'P'";
							
							psmt  = con.prepareStatement(sql);
					
							psmt.setString(1,component);
							rsmt = psmt.executeQuery();

							if(rsmt.next())
								rowCount = rsmt.getInt("total");

							if(rsmt!= null)rsmt.close();
							if(psmt != null)psmt.close();
							if (rowCount <= 0)
							{
								label_id = component.trim()+"_P1";
								label_id = label_id.trim();

								insertQry = "insert into CA_TEMPLATE_LABEL (LABEL_ID,LABEL_DESC,LABEL_TYPE,DISCR_MSR_ID,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,'P',?,'E',?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )";

								pstmt = con.prepareStatement(insertQry);
								pstmt.setString	(1,	label_id);	
								pstmt.setString	(2,	comp_prompt_desc);
								pstmt.setString	(3,	component);
								pstmt.setString	(4,	login_user_id);
								pstmt.setString	(5,	client_ip_address);
								pstmt.setString	(6,	added_facility_id);
								pstmt.setString	(7,	login_user_id);
								pstmt.setString	(8,	client_ip_address);
								pstmt.setString	(9,	added_facility_id);

								insert_result = pstmt.executeUpdate();
								component_prompt = label_id;
							}

							if(pstmt != null) pstmt.close();
						}
					}

					if (includeyn.equals("Y") )
					{
						PreparedStatement pstDupl = null;
						ResultSet rsDupl = null;

						StringBuffer strDuplChkQry = new StringBuffer();
						strDuplChkQry.append("SELECT INCLUDE_FOR_ANAL_YN FROM CA_SECTION_TEMPLATE WHERE SEC_HDG_CODE = ? AND INCLUDE_FOR_ANAL_YN = 'Y' and COMP_ID = ?");

						if(!srl_no.equals(""))
							 strDuplChkQry.append(" and srl_no <> ?");

						pstDupl = con.prepareStatement(strDuplChkQry.toString());

						pstDupl.setString(1,section);
						pstDupl.setString(2,component);

						if(!srl_no.equals(""))
							pstDupl.setString(3,srl_no);

						rsDupl = pstDupl.executeQuery();

						if(rsDupl.next())
						{
							String strErrMsg = getMessage(locale,"DUP_COMP_WITH_ANAL","CA");
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(strErrMsg,"UTF-8"));
						}
						
						if(rsDupl != null) rsDupl.close();
						if(pstDupl != null) pstDupl.close();
					}
				}

				htSectionTemplate.put ( "section",section);
				htSectionTemplate.put ( "client_ip_address",client_ip_address);
				htSectionTemplate.put ( "added_facility_id",added_facility_id);
				htSectionTemplate.put ( "includeyn",includeyn);

				if( !(operation.equals("Delete")) )
				{
					htSectionTemplate.put ( "item_type",item_type);
					htSectionTemplate.put ( "title_text_code",title_text_code);
					htSectionTemplate.put ( "component",component);
					htSectionTemplate.put ( "component_prompt",component_prompt);
					htSectionTemplate.put ( "row_position",row_position);
					htSectionTemplate.put ( "column_position",column_position);
					htSectionTemplate.put ( "column_span",column_span);
					htSectionTemplate.put ( "disp_position",disp_position);
					htSectionTemplate.put ( "login_user_id",login_user_id);
					htSectionTemplate.put ( "prev_row_pos_no",prev_row_pos_no);
					htSectionTemplate.put ( "prev_column_pos_no",prev_column_pos_no);
					htSectionTemplate.put ( "prev_no_of_col_span",prev_no_of_col_span);
					htSectionTemplate.put ( "age_group_code",age_group_code);
					htSectionTemplate.put ( "hist_rec_type",hist_rec_type);
					htSectionTemplate.put ( "component_type",component_type);
					htSectionTemplate.put ( "acceptOption",acceptOption);
					htSectionTemplate.put ( "presentationSelect",presentationSelect);
					htSectionTemplate.put ( "selectionSelect",selectionSelect);
					htSectionTemplate.put ( "prefixRequired",prefixRequired);
					htSectionTemplate.put ( "hintMessage",hintMessage);
					htSectionTemplate.put ( "formulaResultType",formulaResultType);
					htSectionTemplate.put ( "includeDates",includeDates);
					htSectionTemplate.put ( "formulaResultUnits",formulaResultUnits);
					htSectionTemplate.put ( "old_hist_time_frame_val",old_hist_time_frame_val);
					htSectionTemplate.put ( "old_hist_time_frame_unit",old_hist_time_frame_unit);
					htSectionTemplate.put ( "event_code",event_code);
					htSectionTemplate.put ( "event_code_type",event_code_type);
					htSectionTemplate.put ( "dflt_from_hist_appl_yn",dflt_from_hist_appl_yn);
					htSectionTemplate.put ( "comp_disp_next_yn",comp_disp_next_yn);//IN059630_GHL-CRF-0401
					htSectionTemplate.put ( "auto_result_yn",auto_result_yn); //IN061907

					if(component_type.equals("A"))
					{
						//here formula definition is just a testual definition of formula defined
						htSectionTemplate.put ( "formula_definition",formula_definition);
					}					
					if(operation.equals("modify") && (component_type.equals("L") || component_type.equals("C")))
					{
						//here formula_definition is used for storing the validation XML for linking this field to other fields 
						//templateBean = (CASectionTemplateFieldsAssociationBean)session.getAttribute("templateBean");

						//String sessionid = session.getId();
						//String userid = (String)session.getValue("login_user");
						//java.sql.Timestamp session_creation_date = new java.sql.Timestamp(session.getCreationTime());
						//java.util.Properties jdbc_props = (java.util.Properties)session.getValue("jdbc");
						//String ws_no = (String)jdbc_props.getProperty("client_ip_address");
					
						templateBean= (eCA.CASectionTemplateFieldsAssociationBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);//sessionid,userid,ws_no,session_creation_date,jdbc_props);

						if(templateBean!=null)
						{
							String fieldAssociationContentXML = templateBean.constructXML(component_type,component+srl_no);

							
							if(fieldAssociationContentXML!=null)
								htSectionTemplate.put ( "formula_definition",fieldAssociationContentXML);
							fieldAssociationContentXML=null;
						}
					}
				}

				if(operation.equals("modify") || operation.equals("Delete") )
					htSectionTemplate.put ( "srl_no",srl_no);

				htSectionTemplate.put ( "LOCALE",locale);
			}														
			catch(Exception e)
			{
				//out.println("Exception@htSectionTemplate: "+e);//common-icn-0181
				
				e.printStackTrace();
				out.flush();
				return;
			}

			try
			{
				java.util.HashMap results = null;
				boolean inserted = false;
				String error_msg = "";
				boolean local_ejbs = false;

				if(insert_result > 0)
				{				
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
						local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SectionTemplate", SectionTemplateHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[]		= new Object[2];
					argArray[0]				= jdbc_props;
					argArray[1]				= htSectionTemplate;
					Class [] paramArray		= new Class[2];
					paramArray[0]			= jdbc_props.getClass();
					paramArray[1]			= htSectionTemplate.getClass();
				
					try
					{
						if(operation.equals("modify"))
						{
							results =	 (HashMap)busObj.getClass().getMethod("updateSectionTemplate", paramArray).invoke(busObj, argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							htSectionTemplate.clear();
						}
						else if(operation.equals("Delete"))
						{
							results = (HashMap)busObj.getClass().getMethod("deleteSectionTemplate", paramArray).invoke(busObj, argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							htSectionTemplate.clear();
						}
						else
						{
							results = (HashMap)busObj.getClass().getMethod("insertSectionTemplate", paramArray).invoke(busObj, argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							htSectionTemplate.clear();
						}

						inserted		=	( ((Boolean) results.get( "status" )).booleanValue() ) ;
						error_msg		=	(String)	results.get("error") ;
						results.clear();
					}
					catch(Exception e)
					{
						//out.println("Exception@recordingEJB : "+e.toString());
						
						e.printStackTrace();
					}
				}

				if(inserted)
				{
					out.println(error_msg);


					String update_agegrp_dep_info = "SELECT COMP_ID||SRL_NO comp_id_sno, AGE_GROUP_CODE FROM CA_SECTION_TEMPLATE WHERE SEC_HDG_CODE=? AND AGE_GROUP_CODE IS NOT NULL	ORDER BY SRL_NO";
					PreparedStatement ptmtInsert = con.prepareStatement(update_agegrp_dep_info);
					ptmtInsert.setString(1,section);
					ResultSet rs1 = ptmtInsert.executeQuery();
					StringBuffer comp_id_sno = new StringBuffer();
					StringBuffer age_grp_code = new StringBuffer();
					while(rs1.next())
					{
						comp_id_sno.append(rs1.getString("comp_id_sno") + "|" );
						age_grp_code.append(rs1.getString("AGE_GROUP_CODE") + "|");
					}
					if(rs1!=null) rs1.close();
					if(ptmtInsert!=null) ptmtInsert.close();

					String insertSQL=" update ca_section_hdg set TEMPLATE_FORMAT = empty_clob(), AGE_GRP_DEP_COMP_INFO = ?, DEP_AGE_GRP_INFO = ? where SEC_HDG_CODE=?";
				
					ptmtInsert=con.prepareStatement(insertSQL);					
					ptmtInsert.setString(1,comp_id_sno.toString());
					ptmtInsert.setString(2,age_grp_code.toString());
					ptmtInsert.setString(3,section);
					ptmtInsert.executeUpdate();
					ptmtInsert.close();

					sql = "Select TEMPLATE_FORMAT from ca_section_hdg  where SEC_HDG_CODE = ? for update "; 
					PreparedStatement ptmtInsert1=con.prepareStatement(sql);
					ptmtInsert1.setString(1, section);
					
					rs1= ptmtInsert1.executeQuery() ;
					Clob clb = null;

					if(rs1!=null && rs1.next())
					{
						  clb = rs1.getClob(1);
					}

					//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
					BufferedWriter w = new BufferedWriter(clb.setCharacterStream(0));
					SectionTemplateXMLDefinitionBean objBean = new SectionTemplateXMLDefinitionBean();

					StringBuffer XMLString=null;
					if((template_type==null) || (template_type.equals("")) ||(template_type.equals("B"))){
						XMLString=objBean.constructXML(con,section);
						
					}else{
						XMLString=objBean.constructTemplateTypeXML(con,section);
						
					}
					objBean = null;
					String removeSplChar=XMLString.toString();
					w.write(removeSplChar,0,removeSplChar.length());
					
					w.flush();
					w.close();
					rs1.close();
					ptmtInsert1.close();
					
					if(templateBean!=null && !templateBean.getAssociationData().isEmpty())
					{
						try
						{
							String deleteDepd = "delete from  CA_COMPONENT_DEPENDENCY_DTL where SEC_HDG_CODE =? and PARENT_COMP_REF = ?";
							PreparedStatement pstmtDepd=con.prepareStatement(deleteDepd);
							
							pstmtDepd.setString(1,section);
							pstmtDepd.setString(2,component+srl_no);
							
							int x=pstmtDepd.executeUpdate();
							x = x;

							if(pstmtDepd!=null) pstmtDepd.close();
							//inserting the fresh records
							String insertDepd = "insert into CA_COMPONENT_DEPENDENCY_DTL(SEC_HDG_CODE,PARENT_COMP_REF,CHILD_COMP_REF)  values(?,?,?)";
							pstmtDepd = con.prepareStatement(insertDepd);
							Vector dependentComps = templateBean.getAssociatedComponents(component+srl_no);
							
							if(dependentComps != null)
							{
							for(int k=0;k<dependentComps.size();k++)
							{
								pstmtDepd.setString(1,section);
								pstmtDepd.setString(2,component+srl_no);
								pstmtDepd.setString(3,(String)dependentComps.elementAt(k));
								pstmtDepd.addBatch();
							}
							int a[] = pstmtDepd.executeBatch();
							for(int k=0;k<a.length;k++)
							{
								if(a[k]==-3)
									con.rollback();
							}
							con.commit();
							bUpdStatus = true;
							}
							if(pstmtDepd !=null) pstmtDepd.close();
						}
						catch(Exception e)
						{
							con.rollback();
							e.printStackTrace();
							//out.println("Exception while Inserting Records into CA_COMPONENT_DEPENDENCY_DTL!"+e);
							
						}
					}					
					else
					{
						con.commit();
						bUpdStatus = true;
					}

					if(bUpdStatus)
					{
						try
						{
							CallableStatement csXMLParse = null;
							csXMLParse = con.prepareCall("{call CA_parse_SectionXMLTemplate(?,?)}");
							csXMLParse.setString(1,section);
							csXMLParse.registerOutParameter(2,Types.VARCHAR);
							csXMLParse.execute();
							strParseStatus = csXMLParse.getString(2);

							if(strParseStatus.equals("N"))
							{
								con.rollback();
								out.println("Exception while parsing SectionTemplate ");
							}
							else 
								con.commit();

							if(csXMLParse != null) csXMLParse.close();

						}
						catch (Exception eeeee)
						{
							con.rollback();
							eeeee.printStackTrace();//COMMON-ICN-0181
							//out.println("Exception while parsing SectionTemplate ! "+eeeee.toString());//Common-icn-0181
						}
						
					}
					out.println("<script>");
					//out.println("alert('from the servlet. reloading all the pages')");
					out.println("parent.f_query_add_mod.CASectionTemplateListFrame.location.href=\"../eCA/jsp/CASectionTemplateList.jsp?section="+section+"\"");					
					out.println("parent.f_query_add_mod.CASectionTemplateDetailFrame.location.href='../eCA/jsp/CASectionTemplateDetail.jsp?section="+section+"'");
					out.println("parent.f_query_add_mod.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.disabled=false");
					//out.println("alert(top.content.messageFrame.name)");
					//out.println("top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='");
					
					out.println("</script>");
				} // end of if
				else
				{
					out.println("<script>alert('"+error_msg+"');");
					//out.println("<script>messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'</script>");	
					out.println("parent.f_query_add_mod.CASectionTemplateListFrame.location.href=\"../eCA/jsp/CASectionTemplateList.jsp?section="+section+"\"");					
					out.println("parent.f_query_add_mod.CASectionTemplateDetailFrame.location.href='../eCA/jsp/CASectionTemplateDetail.jsp?section="+section+"'");
					out.println("</script>");			
				} // end of else
			}
			catch(Exception e)
			{
				con.rollback();
				//out.println("Exception while accessing SectionTemplate EJB for Inserting Records!"+e.toString());
				
				e.printStackTrace();
			}
        } // end of try
		catch(Exception e)
		{
			//out.println("Exception@Insert:1 of CASectionTemplateServlet.java 2---"+e.toString());//common-icn-0181
			
			e.printStackTrace();
		} // end of catch
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con,request);
			//out.println(con);
			out.println("</body></html>");
			templateBean =null;
			session.removeAttribute("templateBean");		
		} // end of finally
    } // end of method insertSectionTemplate

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
} // end of class CASectionTemplateServlet
