<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?			100				?           		?			?			created
21/01/2014	IN040045		Vijayakumar K	22/01/2014	Dinesh T		CA Transactions --> Patient Chart --> Record Clinical Notes while
																		associating the ?Performed By?, the application is generating  a script error on load of the ?Performed By? modal window.

---------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.net.*,java.sql.ResultSet,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String loggedUser	= (String) session.getValue("login_user");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<html>
	<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<script>
	function retValue(code,desc)
	{
		desc = escape(desc)
		var retVal  = new Array();
		retVal[0] = code;
		//IN040045 starts
		//retVal[1] = desc;	
		retVal[1] = decodeURIComponent(desc);	
		//IN040045 ends
		window.returnValue = retVal;
		window.close();
	}

	</script>
	<body onKeyDown='lockKey()'>
	<table class="grid" width='100%'  align=center>
	<%
	String search_text = request.getParameter( "search_text" )==null?"":request.getParameter( "search_text" );
	String search_criteria = request.getParameter( "search_criteria" )==null?"":request.getParameter( "search_criteria" );
	String radBtnVal = (request.getParameter( "radBtnVal" )==null?"":request.getParameter( "radBtnVal" ));
	String note_type = (request.getParameter( "note_type" )==null?"":request.getParameter( "note_type" ));
	//String mode = (request.getParameter( "mode" )==null?"":request.getParameter( "mode" ));

	String code = "";
	String desc = "";
	String classvalue = "";
	String WhereClause = "";
	StringBuffer sql = new StringBuffer();

	int rowCount = 0;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try
		{
			
			%>
				<tr>
					<td class='columnheader' width='50%'>
						<fmt:message key="Common.code.label" bundle="${common_labels}"/>
					</td>
					<td class='columnheader' width='50%'>
						<fmt:message key="Common.description.label" bundle="${common_labels}"/>
					</td>
				</tr>
			<%
		/*	if(!search_text.equals(""))
			{
				if(radBtnVal.equals("C"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and upper( phys_prov_id ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause =WhereClause + " and upper( phys_prov_id ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause =WhereClause + " and upper(phys_prov_id) like upper('%" + search_text + "%')";
					}
					
				}
				else if(radBtnVal.equals("D"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and  upper( phys_prov_name ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause = WhereClause + " and upper(phys_prov_name ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause = WhereClause + " and upper(phys_prov_name ) like upper('%" + search_text + "%')";
					}
					
				}

			}
			else
			{
				if(radBtnVal.equals("C"))
				{
					WhereClause =WhereClause + " order by phys_prov_id";
				}
				else if(radBtnVal.equals("D"))
				{
					WhereClause =WhereClause + " order by phys_prov_name";
				}
			}
		

			con = ConnectionManager.getConnection(request);

			sql.append("select practitioner_id phys_prov_id, replace(short_name,'','') phys_prov_name from am_practitioner where EFF_STATUS='E' and practitioner_id in (select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ?  and b.privilege_type in ('2','3','4') and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id) "); */

			if(!search_text.equals(""))
			{
				if(radBtnVal.equals("C"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and upper( practitioner_id ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause =WhereClause + " and upper( practitioner_id ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause =WhereClause + " and upper(practitioner_id) like upper('%" + search_text + "%')";
					}
					
				}
				else if(radBtnVal.equals("D"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and  upper( practitioner_name ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause = WhereClause + " and upper(practitioner_name ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause = WhereClause + " and upper(practitioner_name ) like upper('%" + search_text + "%')";
					}
					
				}

			}
		/*	else
			{*/
				if(radBtnVal.equals("C"))
				{
					WhereClause =WhereClause + " order by phys_prov_id";
				}
				else if(radBtnVal.equals("D"))
				{
					WhereClause =WhereClause + " order by phys_prov_name";
				}
			//}
		

			con = ConnectionManager.getConnection(request);

			//if (mode.equals("PR")){
				sql.append("select oa.practitioner_id phys_prov_id, replace(oa.practitioner_name,'','') phys_prov_name from am_practitioner_lang_vw oa  where oa.EFF_STATUS='E' and oa.language_id = ? and exists (select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ?  and b.privilege_type in ('2','3','4') and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id and a.appl_user_id NOT IN (?) and a.func_role_id=oa.practitioner_id) ");
			//}else{
			//sql.append("select practitioner_id phys_prov_id, replace(short_name,'','') phys_prov_name from am_practitioner_lang_vw  where EFF_STATUS='E' and language_id = ? and practitioner_id in (select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ?  and b.privilege_type in ('2','3','4') and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id) ");
			//}

			sql.append(WhereClause);

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,note_type);
			//if (mode.equals("PR"))
			pstmt.setString(3,loggedUser);

			rs = pstmt.executeQuery();
			/** Modified by kishore kumar N on 19-12-2008 for CRF 0387, applied GRID CSS*/
			classvalue = "gridData";
			while(rs.next())
			{
				/* if ( rowCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
	          else
					classvalue = "QRYODD" ;*/
					/** ends here*/

				code = rs.getString("phys_prov_id");
				desc = rs.getString("phys_prov_name");
				desc = desc.replaceAll("'","");
				desc =  java.net.URLEncoder.encode(desc,"UTF-8");//IN040045
				out.println("<tr>");
				out.println("<td width='50%' class='"+classvalue+"'>");
				out.println("<a class='gridLink' href='javascript():' onclick='retValue(\""+code+"\",\""+desc+"\")'> "+code+" </a> </td>");
				//IN040045 starts
				//out.println("<td width='50%' class='"+classvalue+"'>"+desc+"</td>");
				out.println("<td width='50%' class='"+classvalue+"'>"+java.net.URLDecoder.decode(desc,"UTF-8")+"</td>");
				//IN040045 ends
				out.println("</tr>");

				rowCount++;
			
			}
			rs.close();
			pstmt.close();

			if(rowCount == 0)
			{
			%>
				<script>
					var errorMsg = alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				</script>
			<%
			}
		}
		catch(Exception e)
		{
			//out.println("code = "+code+"--------desc = "+desc);
		//	out.println("Exception in RecClinicalNotesPerformedByResult.jsp at line---"+rowCount+"--"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	%>
</table>
		<script>
			parent.RecClinicalNotesPerformedByCriteriaFrame.document.RecClinicalNotesPerformedByCriteriaForm.Search.disabled = false;
		</script>

</body>
</html>



