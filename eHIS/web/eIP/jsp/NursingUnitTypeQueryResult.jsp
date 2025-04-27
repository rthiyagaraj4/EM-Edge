<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
/* This is a Built for an Result Page Where the FieldsValues are obtained from Criteria Page... */
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%

request.setCharacterEncoding("UTF-8");
Connection conn		= null;
Statement stmt		= null;
//ResultSet rset		= null;
Statement stmt_bl	= null;
ResultSet rs_bl		= null;
Statement stmt_bl_interface = null;
ResultSet rs_bl_interface	= null;

try{
	conn = ConnectionManager.getConnection(request);
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='CONTENT' onLoad='ClearMsg()'; OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");

	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String sql_bl="";
	String facilityid=(String)session.getValue("facility_id");
	String deposit_appl_yn="";
	String addl_dep_yn="";

	stmt = conn.createStatement();
	stmt_bl = conn.createStatement();
	stmt_bl_interface= conn.createStatement();
	String setup_bl_dtls_in_ip_yn="N";

	try
	{
		StringBuffer sql_bl_interface = new StringBuffer();
		sql_bl_interface.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id='"+facilityid+"' ");
		rs_bl_interface = stmt_bl_interface.executeQuery(sql_bl_interface.toString());
		if(rs_bl_interface!=null )
		{
			while(rs_bl_interface.next())
			 {
					setup_bl_dtls_in_ip_yn	=	rs_bl_interface.getString("setup_bl_dtls_in_ip_yn");
			 }
		}
  }catch(Exception e)
  {
	out.print("Exception here1 :"+e);}

	if ( (whereClause == null || whereClause.equals("")) )
	{
	if(sql.length() > 0) sql.delete(0,sql.length());
	String nurs_code = request.getParameter("Type");
	nurs_code=nurs_code.toUpperCase();

	String shortdesc=request.getParameter("long_desc").trim();

	String enabled = request.getParameter("eff_status");
	int andCheck = 0;

	if ( !(nurs_code == null || nurs_code.equals("")) )
		{
		sql.append("where  upper(nursing_unit_type_code) like upper('"+nurs_code+"%')");
		andCheck = 1;
		}

	if ( !(shortdesc == null || shortdesc.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(long_desc) like  upper('"+shortdesc+"%')" );
		}
		else
		{
			sql.append("where upper(long_desc) like upper('"+shortdesc+"%')" );
			andCheck = 1;
		}
	 }

	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	        {
		if ( andCheck == 0 ) {
			sql.append("where eff_status='E'");
			andCheck = 1; }
		else
			sql.append(" and eff_status='E'");
		}
	   if ( enabled.equals("D") )
		{
		if ( andCheck == 0 ) {
			sql.append(" where  eff_status='D'");
			andCheck = 1; }
		else
			sql.append(" and eff_status='D'");
		}
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
		sql.append(whereClause);
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

int maxRecord = 0;

/*StringBuffer strsql1 = new StringBuffer();
strsql1.append(" select count(*) as total from ip_nursing_unit_type "+sql.toString());
ResultSet rs = stmt.executeQuery(strsql1.toString());

rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}*/
StringBuffer strsql2 = new StringBuffer();
strsql2.append("select * from ip_nursing_unit_type "+sql.toString());
ResultSet rs = stmt.executeQuery(strsql2.toString());

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
 }

while ( i<=end && rs.next() )
{
	if (maxRecord==0)
	{

%>

<p>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../jsp/NursingUnitTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
%>


<%
//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/NursingUnitTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>

</tr>
</table>
</p>
<br>
<br>
<%if(setup_bl_dtls_in_ip_yn.equals("Y"))
{%>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eIP.DepositApplicable.label" bundle="${ip_labels}"/></th>
	<th><fmt:message key="eIP.AdditionalDepositRequired.label" bundle="${ip_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%}
else
{%>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
}
}
 	//if ( start != 1 )
	 //for( int j=1; j<start; i++,j++ ){
	  //rs.next() ;

	 // }
	  String classValue = "" ;

//while ( rs.next() && i<=end )
//{
        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String Nurscode = rs.getString("nursing_unit_type_code");
	out.println("<a href='../jsp/addModifyNursingUnitType.jsp?nursing_unit_type_code="+ Nurscode + "' target='f_query_add_mod' >");

	out.println(Nurscode+"</a></td><td class='" + classValue + "'>");


	out.println(rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );

if(setup_bl_dtls_in_ip_yn.equals("Y"))
{
	try
	{
		sql_bl="select * from bl_ip_nursing_unit_type where nursing_unit_type_code='"+Nurscode+"' ";
		rs_bl = stmt_bl.executeQuery(sql_bl);
		if(rs_bl!=null)
		 {
			 while(rs_bl.next())
				{
					 deposit_appl_yn	=	rs_bl.getString("deposit_appl_yn");
					 addl_dep_yn		=	rs_bl.getString("addl_dep_yn");
			    }
		}
	 }catch(Exception e) {out.println(e);}

		out.println(deposit_appl_yn);
		 out.println("</td><td class='" + classValue + "' align='center'>");
	 	 if(deposit_appl_yn.equals("Y"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		 else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		 out.println("</td><td align='center' class='" + classValue + "'>");

		 if(addl_dep_yn.equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		 else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
}

	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
}   %>

</td></tr>
</table>
<br><center>
<%

if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}

boolean flag = false;
if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% flag = true;
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
if(rs != null)	rs.close();

}catch(Exception e) {out.println("main try"+e);}
finally
{
	if(stmt != null)	stmt.close();
	if(stmt_bl != null)	stmt_bl.close();
	//if(rset != null)	rset.close();
	if(rs_bl != null)	rs_bl.close();
	if(stmt_bl_interface != null)	stmt_bl_interface.close();
	if(rs_bl_interface != null)		rs_bl_interface.close();
	//if(rs != null)	rs.close();
	ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

