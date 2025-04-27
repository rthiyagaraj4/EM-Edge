<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>




<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql = new StringBuffer();
	String cd = request.getParameter("APPL_TYPE_CODE");
	String longdesc = request.getParameter("long_desc");
	String enabled = request.getParameter("nature");


	int andCheck = 0;

	cd=cd.toUpperCase();

	if ( !(cd == null || cd.equals("")) )
			{
			sql.append("where upper(APPL_TYPE_CODE)  like  upper('"+cd+"%') ");
			andCheck = 1;
			}

		if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append(" upper(long_desc)  like  upper('"+longdesc+"%') ");
				}
				else
				{
					sql.append("where upper(long_desc)  like  upper('"+longdesc+"%') ") ;
					andCheck = 1;
				}
			}


		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 ){
				sql = new StringBuffer();
				sql.append("where eff_status='E'");
			}
			else
				sql.append(" and eff_status='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 ){
					sql = new StringBuffer();
					sql.append(" where  eff_status='D'");
			}
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
		else{
			sql.append(ord[i]);
			sql.append(",");
		}
		}
	}
	} //end of where clause IF
	else {
		sql = new StringBuffer();
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
	Connection conn =null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
	Boolean isReportTypeAppl = false; 

try{
	conn=ConnectionManager.getConnection(request);
	/*stmt = conn.createStatement();
	StringBuffer strsql1= new StringBuffer();
	strsql1.append("select count(*) as total from mr_appl_type ");
	strsql1.append(sql.toString());
	rs = stmt.executeQuery(strsql1.toString());
	rs.next();
	maxRecord = rs.getInt("total");
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

	//out.println("strsql1.toString() ----------"+strsql1.toString());
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	*/
	isReportTypeAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","REPORT_TYPE_FOR_APPL_TYPE"); //Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292

	StringBuffer strsql2= new StringBuffer();
	strsql2.append("select * from mr_appl_type ");
	strsql2.append(sql.toString());
	stmt = conn.createStatement();
	rs = stmt.executeQuery(strsql2.toString());

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	while ( i<=end && rs.next() )
	{
		if (maxRecord==0)
		{

%>
	<P>
	<table align='right'>
	<tr>
	
	<%
	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/ApplicationTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ApplicationTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	</tr>
	
	</table>
	<br><br>
	</P>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="eMR.ApplicationType.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<!--Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292-->
	<%if(isReportTypeAppl){%>
	<th><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></th>
	<%}%>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
		}
 	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }*/
	  String classValue="";
//while ( rs.next() && i<=end )
//{
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;
	out.println("<tr><td  class='" + classValue + "'>");
	String code = rs.getString("APPL_TYPE_CODE");

	out.println("<a href='../../eMR/jsp/addModifyApplicationType.jsp?APPL_TYPE_CODE="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td  class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td  class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td><td align='center'  class='" + classValue + "'>");
	
	//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
	if(isReportTypeAppl)
	{
		String report_type = checkForNull(rs.getString("report_type"));
		if(report_type.equals(""))
		{
			out.println("&nbsp;");
		}
		else
		{
			if(report_type.equals("N"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels"));
			else
			if(report_type.equals("S"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specialist.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels"));
			else
			if(report_type.equals("P"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Postmortem.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels"));
		}
		out.println("</td><td class='" + classValue + "'>");
	}

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;

	}//endwhile
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>
<%


	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	if ( maxRecord < 14 || (!rs.next()) )
	{
	%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
		</script>
	<% 
	}
	else
	{%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
		</script>
	<%
	}

	if(rs!=null)
		rs.close();
	if(stmt!=null)
		stmt.close();

}
catch(Exception e){
		//out.println("Exception "+e.toString());
		e.printStackTrace();
}
finally{

	if(conn!=null)
			ConnectionManager.returnConnection(conn,request);
}
	
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

