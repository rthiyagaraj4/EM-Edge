<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.net.*,java.sql.ResultSet,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<!-- added by Kishore Kumar N on 09/12/2008  -->
	
	<!-- end here -->
<html>
	<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<script language='javascript'>
	function retValue(code,desc)
	{
	
		desc = escape(desc)
		var retVal  = new Array();
		retVal[0] = code;
		retVal[1] = desc;	
		window.returnValue = retVal;
		window.close();
	}

	</script>
	<body onKeyDown='lockKey()'>
		<table width='100%' class='grid'>
	<%

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String search_text = request.getParameter( "search_text" )==null?"":request.getParameter( "search_text" );
	String search_criteria = request.getParameter( "search_criteria" )==null?"":request.getParameter( "search_criteria" );
	String radBtnVal = (request.getParameter( "radBtnVal" )==null?"":request.getParameter( "radBtnVal" ));
	String facility_id = (request.getParameter( "facility_id" )==null?"":request.getParameter( "facility_id" ));
	String ser_spc_yn = (request.getParameter( "ser_spc_yn" )==null?"":request.getParameter( "ser_spc_yn" ));
	String note_type = (request.getParameter( "note_type" )==null?"":request.getParameter( "note_type" ));

	String code = "";
	String desc = "";
	//String classvalue = "";
	String classvalue = "gridData";
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
					<td class='COLUMNHEADERCENTER' width='50%'>
						<fmt:message key="Common.code.label" bundle="${common_labels}"/>
					</td>
					<td class='COLUMNHEADERCENTER' width='50%'>
						<fmt:message key="Common.description.label" bundle="${common_labels}"/>
					</td>
				</tr>
			<%
			if(!search_text.equals(""))
			{
				if(radBtnVal.equals("C"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and upper( service_code ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause =WhereClause + " and upper( service_code ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause =WhereClause + " and upper(service_code) like upper('%" + search_text + "%')";
					}
					
				}
				else if(radBtnVal.equals("D"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and  upper( short_desc ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause = WhereClause + " and upper(short_desc ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause = WhereClause + " and upper(short_desc ) like upper('%" + search_text + "%')";
					}
					
				}

			}
			else
			{
				if(radBtnVal.equals("C"))
				{
					WhereClause =WhereClause + " order by code";
				}
				else if(radBtnVal.equals("D"))
				{
					WhereClause =WhereClause + " order by short_desc";
				}
			}
		

			con = ConnectionManager.getConnection(request);

			//sql.append("select service_code code, replace(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'','')  short_desc from  AM_FACILITY_SERVICE_VW where nvl(eff_status,'E') ='E'  and operating_facility_id = ? ");
			sql.append("select a.service_code code, replace(a.short_desc ,'''','')  short_desc from  am_service_lang_vw a where nvl(a.eff_status,'E') ='E'  and a.LANGUAGE_ID=? and exists (select 1 from AM_FACILITY_SERVICE where  operating_facility_id = ? and SERVICE_CODE=a.SERVICE_CODE ) ");

			if(ser_spc_yn.equals("Y"))
			{
				sql.append(" and exists (select service_code from ca_note_type_by_serv where facility_id=? and note_type = ? and service_code=a.SERVICE_CODE)");
			}

			sql.append(WhereClause);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			
			if(ser_spc_yn.equals("Y"))
			{
				pstmt.setString(3,facility_id);
				pstmt.setString(4,note_type);
			}

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				/* if ( rowCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
	          else
					classvalue = "QRYODD" ;*/

				code = rs.getString("code");
				desc = rs.getString("short_desc");
				desc = desc.replaceAll("'","");
				out.println("<tr>");
				out.println("<td width='50%' class='"+classvalue+"'>");
				out.println("<a class='gridLink' href='javascript():' onclick='retValue(\""+code+"\",\""+desc+"\")'> "+code+" </a> </td>");
				out.println("<td width='50%' class='"+classvalue+"'>"+desc+"</td>");
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
			out.println("code = "+code+"--------desc = "+desc);
			//out.println("Exception in RecClinicalNotesMedServiceResult.jsp at line---"+rowCount+"--"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	%>
</table>
		<script>
			parent.RecClinicalNotesMedServiceCriteriaFrame.document.RecClinicalNotesMedServiceCriteriaForm.Search.disabled = false;
		</script>

</body>
</html>



