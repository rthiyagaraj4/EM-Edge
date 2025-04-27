<!--Created by Ashwini on 06-May-2024 for ML-MMOH-CRF-2125-->
<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>

<HTML>
<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>

<BODY OnMouseDown='CodeArrest()' onLoad='ClearMsg()' onKeyDown ='lockKey()' class='CONTENT'>

<%
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";

	StringBuffer sql=new StringBuffer(" ");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);
		sql.append("");

		String cd = request.getParameter("service_code");
		String prname = request.getParameter("service_name");
		String spltycd = request.getParameter("splty_code");
		String spltynm = request.getParameter("splty_name");
		String facility_id = request.getParameter("facility_id");
		String facility_name = request.getParameter("facility_name");

		if ( !(cd == null || cd.equals("")) )
		{
			sql.setLength(0);
			sql.append("and upper(am_service_for_speciality.service_code) like upper('"+cd+"%')");
		}

		if ( !(prname == null || prname.equals("")) )
		{
			sql.append(" and ");
			sql.append("upper(am_service.short_desc) like  upper('"+prname+"%') " );
		}

		if ( !(spltycd == null || spltycd.equals("")) )
		{
			sql.append(" and ");
			sql.append("am_service_for_speciality.speciality_code like  '"+spltycd.toUpperCase()+"%'" );
		}

		if ( !(spltynm == null || spltynm.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(am_speciality.short_desc)  like  upper('"+spltynm+"%') " );
		}

		if ( !(facility_id == null || facility_id.equals("")) )
		{
			sql.append(" and ");
			sql.append("am_service_for_speciality.facility_id like  '"+facility_id.toUpperCase()+"%'" );

		}
		if ( !(facility_name== null || facility_name.equals("")) )
		{
			sql.append(" and ");
			sql.append("am_service_for_speciality.facility_id = sm_facility_param.facility_id  and  upper(sm_facility_param.facility_name)  like upper('"+facility_name+"%') " );
		}
	}
	else
	{	sql.setLength(0);
		sql.append(whereClause);
	}

	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");
		for ( int i=0; i < ord.length; i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}
	else
	{	
		sql.setLength(0);
		sql.append(whereClause);
	}

	int start = 0 ;
	int end = 0 ;
	int i = 1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

	if(rs!=null)rs.close();
	rs = stmt.executeQuery("SELECT sm_facility_param.facility_name, am_service_for_speciality.facility_id, am_service.short_desc service_name, am_service_for_speciality.service_code, am_service_for_speciality.speciality_code, am_speciality.short_desc FROM sm_facility_param, am_service, am_service_for_speciality, am_speciality WHERE am_service.service_code = am_service_for_speciality.service_code AND am_speciality.speciality_code = am_service_for_speciality.speciality_code AND sm_facility_param.facility_id = am_service_for_speciality.facility_id "+sql);

	if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rs.next() ;

	while ( i<=end && rs.next() )
	{
	
	if(maxRecord==0)
	{

	%>

	<p>
	<table align='right'>
	<tr>

	<%
	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ServiceforSpecialityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ServiceforSpecialityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>

	</tr>
	</table>
	</p>

	<br><br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<td class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></td>

	<%
	
	}

	String classValue = "" ;

	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td nowrap class='"+classValue+"'>"+rs.getString("facility_id")+"</td>");
	
	out.println("<td nowrap class='" + classValue + "'>"+rs.getString("facility_name")+"</td>");
	
	out.println("<td class='" + classValue + "'>");

	String code = rs.getString("service_code");
	String spcode = rs.getString("speciality_code");

	out.println(spcode+"</td><td class='" + classValue + "'>");
	
	out.println( rs.getString("short_desc") );
	
	out.println("</td><td class='" + classValue + "'>");
	
	out.println(code);
	
	out.println("</td> <td class='" + classValue + "'>");
	
	out.println( rs.getString("service_name") );

	i++;
	maxRecord++;
	}

	if(maxRecord == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
	<%}

	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% 
	} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
	<%}

	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally
	{
		try
		{
		if(stmt!=null)	stmt.close();
		if(rs!=null) 	rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(conn,request);

	}%>

	</td></tr>
	</table>
	<br>

</BODY>
</HTML>

<%!
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (("").equals(inputString)) || (("null").equals(inputString)) ) ? "" : inputString );
	}
%>

