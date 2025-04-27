<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	27 Dec 2004
-->

<!-- PositionForMDCPQueryResult.jsp-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script language="javascript" src="../js/CpMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

</html>
<%

	String whereClause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";

	String facility_id = "";
	String facility_name = "";
	String position_code = "";
	String position_desc = "";
	String pract_type_desc = "";

	String classValue = "" ;
	String sqlCount ="";
	String strsql ="";

	String qry_facility_id = request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
	String qry_facility_name = request.getParameter("facility_name")==null ? "":request.getParameter("facility_name");
	String qry_position_code = request.getParameter("position_code")==null ? "":request.getParameter("position_code");
	String qry_position_desc = request.getParameter("position_desc")==null ? "":request.getParameter("position_desc");
	String qry_pract_type = request.getParameter("pract_type")==null ? "":request.getParameter("pract_type");

	Connection conn = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	if (whereClause == null || whereClause.equals(""))
		{
			qryWhere = "and upper(a.facility_id) like upper('"+qry_facility_id+"%') and upper(b.facility_name) like upper('"+qry_facility_name+"%') and upper(a.position_code) like upper('"+qry_position_code+"%') and  upper(c.position_desc) like upper('"+qry_position_desc+"%') and  ('"+qry_pract_type+"'"+" is null or d.pract_type='"+qry_pract_type+"')";


			sql = qryWhere;

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
			sql = whereClause;
		
			
			

try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
sqlCount = "select count(*) from cp_position_for_mdcp a, sm_facility_param b,am_position c, am_pract_type d where upper(a.facility_id) like upper('"+qry_facility_id+"%') and upper(b.facility_name) like upper('"+qry_facility_name+"%') and upper(a.position_code) like upper('"+qry_position_code+"%') and  upper(c.position_desc) like upper('"+qry_position_desc+"%') and  a.facility_id=b.facility_id and a.position_code=c.position_code and ('"+qry_pract_type+"'"+" is null or d.pract_type='"+qry_pract_type+"')and d.pract_type(+) = c.staff_type";
strsql = "SELECT a.facility_id,  b.facility_name,  a.position_code,c.position_desc, d.desc_userdef pract_type_desc FROM  cp_position_for_mdcp a, sm_facility_param b,am_position c, am_pract_type d where a.facility_id=b.facility_id and a.position_code=c.position_code and d.pract_type(+) = c.staff_type "+ sql;

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

rs = stmt.executeQuery(sqlCount);

if(rs.next())
{
	maxRecord = rs.getInt(1);
}
if(stmt!=null) 	stmt.close();

	if(maxRecord == 0)
		
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");


%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='PositionForMDCPQueryResult' id='PositionForMDCPQueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='PositionForMDCPQueryResult.jsp?facility_id="+qry_facility_id+"&facility_name="+qry_facility_name+"&position_code="+qry_position_code+"&position_desc="+qry_position_desc+"&pract_type="+qry_pract_type+"&from="+(start-13)+"&to="+(end-13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='PositionForMDCPQueryResult.jsp?facility_id="+qry_facility_id+"&facility_name="+qry_facility_name+"&position_code="+qry_position_code+"&position_desc="+qry_position_desc+"&pract_type="+qry_pract_type+"&from="+(start+13)+"&to="+(end+13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
	<tr>
		<th rowspan="2"><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th rowspan="2">Position Code</th>
		<th rowspan="2">Position Description</th>
		<th rowspan="2"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
	<%
	stmt = conn.createStatement();
	rs = stmt.executeQuery(strsql);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }
	while ( rs.next() && i<end)
	{

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

    facility_id = rs.getString("facility_id")==null ? "":rs.getString("facility_id");
	facility_name  = rs.getString("facility_name")==null ? "":rs.getString("facility_name");
	position_code = rs.getString("position_code")==null ? "":rs.getString("position_code");
	position_desc = rs.getString("position_desc")==null ? "":rs.getString("position_desc");
	pract_type_desc = rs.getString("pract_type_desc")==null ? "":rs.getString("pract_type_desc");
	if(pract_type_desc.equals("")) pract_type_desc = "&nbsp;";
	%>
		<tr>
			<td align="left" class=<%=classValue%>><%=facility_id%></td>
			<td align="left" class=<%=classValue%>><%=facility_name%></td>
			<td align="left" class=<%=classValue%>><%=position_code%></td>
			<td align="left" class=<%=classValue%>><%=position_desc%></td>
			<td align="left" class=<%=classValue%>><%=pract_type_desc%></td>
					
		</tr>
	
<%
	i++;

  }
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  %>
	  </table>
<%
}catch(Exception e)
{
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
	  ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

