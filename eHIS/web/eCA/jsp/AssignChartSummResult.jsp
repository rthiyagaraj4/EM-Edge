<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<% 	request.setCharacterEncoding("UTF-8");	%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	Connection con = null;
	ResultSet rset = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	//String sqlQuery = "";
	//String sqlCount = "";
	String mode = "modify";
	//String sql = " ";
	int maxRecord = 0;
	String classValue = "";
	int rowCount = 0;
	int count = 0;
	String summaryId = "";
	String patientClassId = "";
	String practitionerId  = "";
	String practitionerShortName  = "";
	String specialtyId = "";

	StringBuffer sql = new StringBuffer();
	StringBuffer sqlQuery = new StringBuffer();
	StringBuffer sqlCount = new StringBuffer();

	String whereClause = request.getParameter("whereClause");
	
	if(whereClause == null || whereClause.equals(""))
		whereClause = "";
	
	int start = 0;
	int end =  0;
	
	String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String patientClass = request.getParameter("patclass");
	String specialty =  request.getParameter("speciality");
	String practitioner =  request.getParameter("pctr");
	String practitionerName =  request.getParameter("pctrname");
	String summary=  request.getParameter("summary");

	//Modified by Archana @10-12-2008
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	int i = 0;
	if(patientClass == null || patientClass.equals(""))
		patientClass = "";
	if(specialty == null || specialty.equals(""))
		specialty = "";
	if(practitioner == null || practitioner.equals(""))
		practitioner = "";
	if(practitionerName == null || practitionerName.equals(""))
		practitionerName = "";
	if(summary == null || summary.equals(""))
		summary = "";	
	if(whereClause.equals(""))
	{
		if(! patientClass.equals(""))
		{
			sql.append(" where PATIENT_CLASS ='"+patientClass+"' ");
			count++;
		}
		if(! specialty.equals(""))
		{
			if(count > 0)
				sql.append("  AND  Upper(SPECILITY_ID) like '"+specialty.toUpperCase()+"%' ");
			else
				sql.append(" where upper(SPECILITY_ID) like '"+specialty.toUpperCase()+"%' ");
		}
	
		if(!practitioner.equals(""))
		{
			if(count>0)
				sql.append("  AND  upper(PRACTITIONER_ID) like '"+practitioner.toUpperCase()+"%' ");
			else
				sql.append(" where upper(PRACTITIONER_ID) like '"+practitioner.toUpperCase()+"%' ");
		}

		if(!practitionerName.equals(""))
		{
			if(count>0)
				sql.append("  AND  upper(PRACTITIONER_SHORT_NAME) like '"+practitionerName.toUpperCase()+"%' ");
			else
				sql.append(" where upper(PRACTITIONER_SHORT_NAME) like '"+practitionerName.toUpperCase()+"%' ");
		}

		if(!summary.equals(""))
		{
			if(count>0)
				sql.append("  AND  SUMMARY_ID ='"+summary+"' ");
			else
				sql.append(" where SUMMARY_ID ='"+summary+"' ");
		}

		String orderByClause = "";
		String OrderBy [] = request.getParameterValues("orderbycolumns");
		sql.append(" order by ");
		
		if(OrderBy.length != 0)
		{
			if(OrderBy.length > 1 )
			{
				for(i = 0 ; i < OrderBy.length ; i++ )
				{
					if(orderByClause.equals(""))
						orderByClause = OrderBy[i] ;
					else
						orderByClause = orderByClause + "," + OrderBy[i];
				}
			}
			else
				orderByClause = OrderBy[0];
		}

		sql.append(orderByClause);
	}
	else
		sql.append(whereClause);

	 if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;
    
	if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;

	try
	{
		con  = ConnectionManager.getConnection(request);		
		
		sqlQuery.append("select  * from ca_chart_summ_choice_vw ");
		sqlQuery.append(sql.toString());

		sqlCount.append("select count(*) total from ca_chart_summ_choice_vw ");
		sqlCount.append(sql.toString());
		stmt = con.prepareStatement(sqlCount.toString());
		rset = stmt.executeQuery();
		rset.next();
		maxRecord = rset.getInt("total");
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		i=1;
%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td>
<td align=right>
	<%
	if ( !(start <= 1) )
		{
		
		out.println("<td align='right'><A class='gridLink' HREF='../../eCA/jsp/AssignChartSummResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereClause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		out.println("</td>");
		}
	if ( !( (start+pageCnt) > maxRecord ) )
		{
	
		
		out.println("<td align='right'><A class='gridLink' HREF='../../eCA/jsp/AssignChartSummResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereClause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	}
%>
</td>
</tr>
</table>
<table width="100%" class='grid' align='center'>
	<tr>
		<td class='COLUMNHEADERCENTER'>
			<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
		</td>
		<td class='COLUMNHEADERCENTER'>
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class='COLUMNHEADERCENTER'>
			<fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>

		</td>
		<td class='COLUMNHEADERCENTER'>
			<fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>

		</td>
		<td class='COLUMNHEADERCENTER'>
			<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>

		</td>	
	<tr>
<%
	stmt1 = con.prepareStatement(sqlQuery.toString());	
	rs = stmt1.executeQuery();
    for( int j=1; j<start; i++,j++ )
      rs.next() ;
      while ( rs.next() && i<= end  ) 
	{
		classValue ="gridData";//((rowCount & 1) == 0) ? "QRYEVEN" : "QRYODD";
		summaryId = rs.getString("SUMMARY_ID");
		patientClassId = rs.getString("PATIENT_CLASS");
		practitionerId = rs.getString("PRACTITIONER_ID");
		practitionerShortName=rs.getString("PRACTITIONER_SHORT_NAME");
		specialtyId =  rs.getString("SPECILITY_ID");
		out.println("<td class='"+classValue+"'> <a class='gridLink'  href='../../eCA/jsp/AssignChartSumm.jsp?pat_class="+ patientClassId+"&mode="+mode+"&spl="+specialtyId+"&practr="+practitionerId+"&practrName="+practitionerShortName+"&summary="+summaryId+"'>       "+rs.getString("PATIENT_CLASS_SHORT_DESC")+"</a></td>");
		out.println("<td class='"+classValue+"'>"+rs.getString("SPECIALITY_SHORT_DESC")+"</td>");
		out.println("<td class='"+classValue+"'>"+rs.getString("PRACTITIONER_ID")+"</td>");
		out.println("<td class='"+classValue+"'>"+rs.getString("PRACTITIONER_SHORT_NAME")+"</td>");
		out.println("<td class='"+classValue+"'>"+rs.getString("SUMMARY_DESC")+"</td>");
		out.println("</tr>");
		rowCount ++;
		i++;
	}
%>
</table>

<%	if(rset != null) rset.close();
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
	}
catch(Exception e)
{
	//out.println("Exception in AssignChartSummResult.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</BODY>
</HTML>

