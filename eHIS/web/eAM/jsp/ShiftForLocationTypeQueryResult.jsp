<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere="";
	if ((whereClause == null || whereClause.equals("")))
	{
	
			String qry_location_type = request.getParameter("locn_type").equals("") ? "":request.getParameter("locn_type");
			String qry_facility_id = request.getParameter("facility_id").equals("") ? "":request.getParameter("facility_id");
			String qry_shift_code = request.getParameter("shift_code").equals("") ? "":request.getParameter("shift_code");
			if(qry_location_type== null) qry_location_type="";
			if(qry_facility_id== null) qry_facility_id="";
			if(qry_shift_code== null) qry_shift_code="";
			
			if(!qry_location_type.equals(""))
		{
				qryWhere =qryWhere+" and a.locn_type = nvl('"+qry_location_type+"',a.locn_type)";
		}
			if(!qry_facility_id.equals(""))
		{
				qryWhere=qryWhere+" and a.facility_id = nvl('"+qry_facility_id+"',a.facility_id)";
		}
			if(!qry_shift_code.equals(""))
		{
				qryWhere=qryWhere+" and a.shift_code = nvl('"+qry_shift_code+"',a.shift_code)";
		}

			sql=qryWhere;
			
			
			//appending order by clause
			String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
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
		}
	else
	   sql= whereClause;
		
			String locn_desc="";
			String facility_name="";
			String shift_desc="";
				
Connection conn = null;
Statement stmt = null;
ResultSet rs=null;
int maxRecord = 0;
try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();



String strsql = "select a.locn_type,a.facility_id,a.shift_code,b.short_desc locn_desc,c.facility_name, d.short_desc shift_desc from am_shift_for_locn_type a, am_care_locn_type b, sm_facility_param c, am_shift d where b.locn_type = a.locn_type and c.facility_id = a.facility_id and d.shift_code = a.shift_code and a.eff_status='E' "+ sql;

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

		

	stmt = conn.createStatement();
	
	rs = stmt.executeQuery(strsql);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }

	 while ( i<=end && rs.next())
	{
		 if(maxRecord==0)
		{

%>
	
<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='ShiftForLocationTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='ShiftForLocationTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
	<tr>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
	<% }

	String classValue = "" ;


	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

    locn_desc = rs.getString("locn_desc")==null ? "":rs.getString("locn_desc");
	facility_name  = rs.getString("facility_name")==null ? "":rs.getString("facility_name");
	shift_desc = rs.getString("shift_desc")==null ? "":rs.getString("shift_desc");
	
	out.println("<tr><td class='" + classValue + "' align='left'>");
	out.println( locn_desc+"</td><td class='" + classValue + "' align='left'>");
	out.println(facility_name +"</td><td class='" + classValue + "' align='left'>");
	out.println(shift_desc +"</td><td class='" + classValue + "' align='left'>");
	out.println("</td></tr>");
	i++;
	maxRecord++;

  }//end of while

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
  
  if(rs!=null)rs.close();
  if(stmt!=null) stmt.close();
%>
	  </table>
<%
}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();
	  ConnectionManager.returnConnection(conn,request);
	}
%>
</body>
</html>

