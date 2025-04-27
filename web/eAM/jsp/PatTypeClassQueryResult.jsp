<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY   OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >");
request.setCharacterEncoding("UTF-8");	

	String whereClause = request.getParameter("whereclause");

	String sql ;
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;
	

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql="";

		String pat_type    = request.getParameter("patient_type")==null ?"":request.getParameter("patient_type");
		String pattypedesc    = request.getParameter("pat_type_desc")==null ?"":request.getParameter("pat_type_desc");
		String pat_class    = request.getParameter("patient_class")==null ?"":request.getParameter("patient_class");
		String patclassdesc    = request.getParameter("pat_class_desc")==null ?"":request.getParameter("pat_class_desc");
		
		int andCheck 		= 0;
		pat_type		=pat_type.toUpperCase();
		pat_class 		=pat_class.toUpperCase();

		if ( !(pat_type == null || pat_type.equals("")) )
		{
			sql = " where upper(patient_type) like upper('"+pat_type+"%')";
			andCheck = 1;
		}

		if ( !(pat_class == null || pat_class.equals("")) )
		{
			sql = " where upper(patient_class)   like upper('"+pat_class+"%') ";
			andCheck = 1;
		}

		if ( !(pattypedesc == null || pattypedesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql = sql + " and ";
					sql = sql + " upper(patient_type_short_desc)  like  upper('"+pattypedesc+"%') " ;
				}
				else
				{
					sql = " where upper(patient_type_short_desc)  like upper('"+pattypedesc+"%') " ;
					andCheck = 1;
				}
		}

		if ( !(patclassdesc == null || patclassdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql = sql + " and ";
					sql = sql + " upper(patient_class_short_desc)  like  upper('"+patclassdesc+"%') " ;
				}
				else
				{
					sql = " where upper(patient_class_short_desc)  like upper('"+patclassdesc+"%') " ;
					andCheck = 1;
				}
		}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord.equals("")) )
		{
			sql=sql+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";
			}
		}
	} //end of where clause IF

	else{
		sql = whereClause;

	}

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

Connection conn = null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from am_patient_type_class_vw "+sql;
rs = stmt.executeQuery(strsql1);

rs.next();
maxRecord = rs.getInt("total");
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
if(stmt!=null) 	stmt.close();
String strsql2="select * from am_patient_type_class_vw"+sql;
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2);
%>

<p>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/PatTypeClassQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/PatTypeClassQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</p>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheader'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="eAM.PatientClassDesc.label" bundle="${am_labels}"/></td>

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue="";
while ( rs.next() && i<=end )
{
	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");

	String pat_type 	= rs.getString("patient_type");
	String pat_class 	= rs.getString("patient_class");
	String pattypedesc 	= rs.getString("patient_type_short_desc");
	String patclassdesc 	= rs.getString("patient_class_short_desc");
	
	out.println("<a href='../../eAM/jsp/AddModifyPatTypeClass.jsp?mode=QUERY&patient_type="+pat_type+"&patient_class="+pat_class+"' target='f_query_add_mod' >");
	out.println(pat_type+"</td><td class='" + classValue + "'>");
	out.println(pattypedesc+"</td><td class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/AddModifyPatTypeClass.jsp?mode=QUERY&patient_type="+pat_type+"&patient_class="+pat_class+"' target='f_query_add_mod' >");
	out.println(pat_class+"</td><td class='" + classValue + "'>");
	out.println(patclassdesc+"</td>");

	i++;

  }//endwhile
  if(rs!=null) 		rs.close();
  if(stmt!=null) 		stmt.close();
}
catch(Exception e){
		e.toString();
}
finally   {
	if(rs!=null) 		rs.close();
	if(stmt!=null) 		stmt.close();
	ConnectionManager.returnConnection(conn,request);

}
%>

</tr>
</table>
<br>
</BODY>
</HTML>

