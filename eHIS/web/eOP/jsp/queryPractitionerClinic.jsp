<!DOCTYPE html>

<!-- Program used for to fetch the practitioner details for a
        particular Clinic -->




<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML><head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY class='CONTENT'  OnMouseDown='CodeArrest()'  onLoad='ClearMsg()' onKeyDown = 'lockKey();'>
<%
	String whereClause = request.getParameter("whereclause");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    
    StringBuffer sql=new StringBuffer();
    String facilityid=(String)session.getValue("facility_id");
	String function=request.getParameter("function");	
    String practitioner = request.getParameter("practitioner_id");

/*
    The sql query is used  to fetch the No. of records based on the Practitioner
	Name ,facilityID, clinic code etc. 
  */  
	if ( (whereClause == null || whereClause.equals("")) )
    {
		String cd = request.getParameter("clinic_code");
		String longdesc = request.getParameter("clinic_desc");
		String ccd = request.getParameter("practitioner_name");
		String enabled = request.getParameter("eff_status");
		cd=cd.toUpperCase();
		practitioner=practitioner.toUpperCase();

		if ( !(facilityid == null || facilityid.equals("")) )
	   { 
				sql = sql.append(" where facility_id = '"+facilityid+"'");
		}
	
		if ( !(cd == null || cd.equals("")) )
        {
				sql.append(" and upper(clinic_code) like upper('"+cd+"%')");
        }

        if ( !(longdesc == null || longdesc.equals("")) )
        {
		         sql.append(" and upper(clinic_name) like upper('"+longdesc+"%')");
        }

        if ( !(practitioner == null || practitioner.equals("")) )
        {
	             sql.append(" and upper(practitioner_id) like upper('"+practitioner+"%')");

        }

		if ( !(ccd == null || ccd.equals("")) )
		{
			sql.append(" and upper(PRACTITIONER_FULL_NAME) like upper('"+ccd+"%')");
		}

		if ( !(enabled == null || enabled.equals("")) )
		{
			if( enabled.equals("E") )
			{
	           sql.append(" and eff_status='E'");
		    }
		    if ( enabled.equals("D") )
			{
                sql.append(" and eff_status='D'");
	        }
			
		}
		sql.append(" and upper(care_locn_type_ind) ='C' and upper(resource_class)='P'");
		
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]).append(",");
			}
		}
    }
    else
         sql.append(whereClause);

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt( to ) ;

	Connection con=null;
	Statement stmt;
	int maxRecord = 0;
	ResultSet rset;
	try
	{

		con  =  ConnectionManager.getConnection(request);
	    stmt = con.createStatement();
	String strsql="select count(*) as total from op_pract_for_clinic_vw "+sql.toString();
	String strsql1="select clinic_code,clinic_name short_desc,practitioner_id,practitioner_full_name short_name,eff_status FROM  op_pract_for_clinic_vw "+sql.toString();

	ResultSet rs = stmt.executeQuery(strsql);
	rs.next();
	maxRecord = rs.getInt("total");
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

	
	strsql1="select clinic_code,clinic_name short_desc,practitioner_id,practitioner_full_name short_name,eff_status FROM  op_pract_for_clinic_vw"+sql;
	rset = stmt.executeQuery(strsql1);
	
%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    
	out.println("<A HREF='../../eOP/jsp/queryPractitionerClinic.jsp?function="+function+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    
	out.println("<A HREF='../../eOP/jsp/queryPractitionerClinic.jsp?function="+function+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
 %> 
</td>
</tr>
</table>
<br><br>
</p>

<!-- Display all the records in table format -->

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheader'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.ClinicDescription.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<%
    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
    while ( rset.next() && i<=end  )
	{
			if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
				classValue = "QRYODD" ;
		out.println("<tr><td align=='left' class='" + classValue + "'>");

		String code = rset.getString(1);
		String code1=rset.getString(3);
		String Pract_name = rset.getString(4);
		if(Pract_name == null) Pract_name ="&nbsp;";


		out.println("<a href='../../eOP/jsp/InsertPClinic.jsp?clinic_code="+ code + "&practitioner_id="+code1+"&call_func="+function+"' target='f_query_add_mod' >");
			out.println(code+"</a></td><td class='" + classValue + "'>");
		out.println("<a href='../../eOP/jsp/InsertPClinic.jsp?clinic_code="+ code + "&practitioner_id="+code1+"&call_func="+function+"' target='f_query_add_mod' >");
		out.println( rset.getString(2) );
		out.println("</a></td><td class='" + classValue + "'>");
		out.println("<a href='../../eOP/jsp/InsertPClinic.jsp?clinic_code="+ code + "&practitioner_id="+code1+"&call_func="+function+"' target='f_query_add_mod' >");
		out.println(rset.getString(3) );
		out.println("</a></td><td class='" + classValue + "'>");
		out.println("<a href='../../eOP/jsp/InsertPClinic.jsp?clinic_code="+ code + "&practitioner_id="+code1+"&call_func="+function+"' target='f_query_add_mod' >");
       		out.println(Pract_name);
		out.println("</a></td>");
		out.println("<td align='center' class='" + classValue + "'>");
		
    if ( rset.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
// Added by Raj when dealing with unclosed connections and resultsets on 10/17/2003

	if(rs != null) rs.close();
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();

}catch(Exception e) {}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>

</center>
</BODY>
</HTML>

