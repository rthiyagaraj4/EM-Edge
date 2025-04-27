<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Properties p = (Properties)session.getValue("jdbc");
//String locale	= (String) p.getProperty("LOCALE");
%>
	<!-- Added by Arvind @ 08-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<br>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	Connection con = null;
	ResultSet rset = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	//String sqlQuery = "";
	//String sqlCount = "";
	//String mode = "modify";
	//String sql = " ";
	int maxRecord = 0;
	String classValue = "gridData";
	int rowCount = 0;
	int count = 0;
	//String summaryId = "";
	String lookup="";
	String patientClassId = "";
	String practitionerId  = "";
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
	lookup=  request.getParameter("lookup");
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
	int i = 0;
	if(patientClass == null || patientClass.equals(""))
		patientClass = "";
	if(specialty == null || specialty.equals(""))
		specialty = "";
	if(practitioner == null || practitioner.equals(""))
		practitioner = "";
	if(lookup == null || lookup.equals(""))
		lookup = "";	
	if(whereClause.equals(""))
	{
		if(! patientClass.equals(""))
		{
			//sql = new StringBuffer();
			sql.append(" and A.PRACT_TYPE ='"+patientClass+"' ");
			count++;
		}
			if(! specialty.equals(""))
			{
				if(count > 0)
				{
							sql.append("  AND  Upper(A.SPECIALITY_CODE) like '"+specialty.toUpperCase()+"%' ");
				}
				else
				{
							//sql = new StringBuffer();
							sql.append(" and  upper(A.SPECIALITY_CODE) like '"+specialty.toUpperCase()+"%' ");
				}
			}
			if(!practitioner.equals(""))
			{
				if(count>0)
				{
					sql.append("  AND  upper(A.PRACTITIONER_ID) like '"+practitioner.toUpperCase()+"%' ");
				}
				else
				{
					//sql = new StringBuffer();
					sql.append(" and upper(A.PRACTITIONER_ID) like '"+practitioner.toUpperCase()+"%' ");
				}
			}
			if(!lookup.equals(""))
			{
				if(count>0)
				{
					sql.append("  AND  upper(A.FLOW_SHEET_ID) like '"+lookup.toUpperCase()+"%' ");
				}
				else
				{
					//sql = new StringBuffer();
					sql.append("  AND  upper(A.FLOW_SHEET_ID) like '"+lookup.toUpperCase()+"%' ");
				}
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
		{
				orderByClause = OrderBy[0];
		}
	}

	sql.append(orderByClause);
	}
	else
	{
		//sql = new StringBuffer();
		sql.append(whereClause);
	}

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
		
		sqlQuery.append("SELECT A.PRACT_TYPE,NVL(nvl(B.DESC_USERDEF,B.DESC_SYSDEF),'All') PRACT_TYPE_DESC,A.PRACTITIONER_ID,NVL(C.PRACTITIONER_NAME,'All') PRACTITIONER_NAME,A.SPECIALITY_CODE,NVL(D.SHORT_DESC,'All') SPECIALITY_DESC,A.FLOW_SHEET_ID,NVL(E.SHORT_DESC,'All') FLOWSHEET_DESC FROM CA_FLOW_SHEET_APPLICABLITY A,AM_PRACT_TYPE B,AM_PRACTITIONER C,AM_SPECIALITY  D,CA_FLOW_SHEET E WHERE B.PRACT_TYPE(+)=A.PRACT_TYPE AND C.PRACTITIONER_ID(+)=A.PRACTITIONER_ID AND D.SPECIALITY_CODE(+)=A.SPECIALITY_CODE AND E.FLOW_SHEET_ID (+)=A.FLOW_SHEET_ID ");
//		sqlQuery.append("SELECT A.PRACT_TYPE,NVL(nvl(AM_GET_DESC.AM_PRACT_TYPE(A.PRACT_TYPE,?,'2'),AM_GET_DESC.AM_PRACT_TYPE(A.PRACT_TYPE,?,'1')),'All') PRACT_TYPE_DESC,A.PRACTITIONER_ID,NVL(C.PRACTITIONER_NAME,'All') AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1')PRACTITIONER_NAME,A.SPECIALITY_CODE,NVL(AM_GET_dESC.AM_SPECIALITY(A.SPECIALITY_CODE,?,'2'),'All') SPECIALITY_DESC,A.FLOW_SHEET_ID,NVL(CA_GET_DESC.CA_FLOW_SHEET(A.FLOW_SHEET_ID,?,'2'),'All') FLOWSHEET_DESC FROM CA_FLOW_SHEET_APPLICABLITY A ");
		sqlQuery.append(sql.toString());
%>
<%		sqlCount.append("SELECT  count(*) total FROM CA_FLOW_SHEET_APPLICABLITY A,AM_PRACT_TYPE B,AM_PRACTITIONER C,AM_SPECIALITY  D,CA_FLOW_SHEET E WHERE B.PRACT_TYPE(+)=A.PRACT_TYPE AND C.PRACTITIONER_ID(+)=A.PRACTITIONER_ID AND D.SPECIALITY_CODE(+)=A.SPECIALITY_CODE AND E.FLOW_SHEET_ID (+)=A.FLOW_SHEET_ID");
			sqlCount.append(sql.toString());
		stmt = con.prepareStatement(sqlCount.toString());
		rset = stmt.executeQuery();
		rset.next();
		maxRecord = rset.getInt("total");
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		i=1;
%>

<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
	<tr align = 'right'>
	<td class='white' width='95%'></td> 
	<td  align='right' width='5%' nowrap>
	<%
	if ( !(start <= 1) )
		{
		
		out.println("<A class='gridLink' HREF='../../eCA/jsp/FlowSheetApplicabilityQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereClause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
	if ( !( (start+pageCnt) > maxRecord ) )
		{
	
		
		out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/FlowSheetApplicabilityQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereClause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
%>
</td>
</tr>
</table>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
	<tr>
		<th class='columnHeadercenter' align='left' style="color: white;" >
			<fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeadercenter' align='left' style="color: white;">
			<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeadercenter' align='left' style="color: white;" >
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeadercenter' align='left' style="color: white;">
			<fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/>
		</th>	
	</tr>
<%
stmt1 = con.prepareStatement(sqlQuery.toString());
/*
stmt1.setString(1,locale);
stmt1.setString(2,locale);
stmt1.setString(3,locale);
stmt1.setString(4,locale);
stmt1.setString(5,locale);
*/
	rs = stmt1.executeQuery();
	String patientClassidnew="";
	String flow_sheet_id_mode="";
	String practitioner_id_mode="";
	String speciality_code_mode="";

    for( int j=1; j<start; i++,j++ )
      rs.next() ;
      while ( rs.next() && i<= end  ) 
	{
		classValue =((rowCount & 1) == 0) ? "gridData" : "gridData";
		lookup= rs.getString("FLOWSHEET_DESC");
		patientClassidnew=rs.getString("PRACT_TYPE");

		flow_sheet_id_mode=rs.getString("flow_sheet_id");
		practitioner_id_mode=rs.getString("practitioner_id");
		speciality_code_mode=rs.getString("speciality_code");
        
		patientClassId = rs.getString("PRACT_TYPE_DESC");
		
		practitionerId = rs.getString("PRACTITIONER_NAME");
		
		specialtyId =  rs.getString("SPECIALITY_DESC"); %>
		
		<td class='gridData'> 
		<a class='gridLink' href="../../eCA/jsp/FlowSheetApplicabilityIntermediate.jsp?pat_class=<%=patientClassId%>+&mode=modify +&patientClassidnew=<%=patientClassidnew%>+&flow_sheet_id_mode=<%=flow_sheet_id_mode%>+&speciality_code_mode=<%=speciality_code_mode%>+&practitioner_id_mode=<%=practitioner_id_mode%>+&patientClassId=<%=patientClassId%>+&spl=<%=specialtyId%>+&practr=<%=practitionerId%>+&lookup=<%=lookup%>">
			<%=rs.getString(2)%>
			</a>
			</td>
		<%
		out.println("<td class='"+classValue+"'>"+rs.getString(4)+"</td>");
		out.println("<td class='"+classValue+"'>"+rs.getString(6)+"</td>");
		out.println("<td class='"+classValue+"'>"+rs.getString(8)+"</td>");
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
	//out.println("Exception in FlowSheetApplicabilityQueryResult.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</BODY>
</HTML>

