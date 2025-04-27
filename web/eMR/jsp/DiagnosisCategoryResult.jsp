<!DOCTYPE html>
<!--
*	Copyright © 
*	Created By		:	Ajay Hatwate

*	Created On		:	22 Dec 2022
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String locale=(String)session.getAttribute("LOCALE");
	
	
	StringBuffer CTCsql = new StringBuffer();
	StringBuffer LDsql = new StringBuffer();
	StringBuffer ENsql = new StringBuffer();
		
	
	Boolean ctcFlag = false;
	Boolean ldFlag = false;
	Boolean enFlag = false;
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql = new StringBuffer();
	String ctc = request.getParameter("DIAG_CATG_CODE");
	String longdesc = request.getParameter("LONG_DESC");
	String enabled = request.getParameter("nature");
	

	int andCheck = 0;
	if (!(ctc == null || ctc.equals("")))
		{
			CTCsql.append(" a.diag_catg_code like upper ('"+ctc+"%') ");
			andCheck = 1;
			ctcFlag = true;
		}
		longdesc=longdesc.toUpperCase();
	if (!(longdesc == null || longdesc.equals("")))
		{
			LDsql.append(" UPPER(a.long_desc) like upper('"+longdesc+"%') ");	
			ldFlag = true;
		}
			
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		    {
				ENsql.append(" a.eff_status='E' ");
				enFlag = true;
			}
		   if ( enabled.equals("D") )
			{
				ENsql.append(" a.eff_status='D' ");
				enFlag = true;
			}
		}
		
		if(ctcFlag && ldFlag && enFlag){
			sql.append(CTCsql.toString());
			sql.append(" and ");
			sql.append(LDsql.toString());
			sql.append(" and ");
			sql.append(ENsql.toString());
		}else if(ctcFlag && ldFlag){
			sql.append(CTCsql.toString());
			sql.append(" and ");
			sql.append(LDsql.toString());
		}else if(ldFlag && enFlag){
			sql.append(LDsql.toString());
			sql.append(" and ");
			sql.append(ENsql.toString());
		}else if(ctcFlag && enFlag){
			sql.append(CTCsql.toString());
			sql.append(" and ");
			sql.append(ENsql.toString());
		}else if(ctcFlag){
			sql.append(CTCsql.toString());
		}else if(ldFlag){	
			sql.append(LDsql.toString());
		}else if(enFlag){
			sql.append(ENsql.toString());
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

try{
	conn=ConnectionManager.getConnection(request);
	StringBuffer strsql2= new StringBuffer();
	strsql2.append("select distinct a.diag_catg_code ,a.long_desc ,a.short_desc, a.eff_status  from mr_diag_category a ");
	if(ldFlag || enFlag || ctcFlag){
		strsql2.append(" where ");
	}
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
		out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/DiagnosisCategoryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/DiagnosisCategoryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	</tr>
	
	</table>
	<br><br>
	</P>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td>
	<tr>
		 <th nowrap rowspan='2' width="10%"><fmt:message key="Common.diagnosis.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.category1.label" bundle="${common_labels}"/></th> 
	
	<th rowspan='2' nowrap width="30%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th rowspan='2' nowrap width="30%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	
	<th rowspan='2'width="25%" nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
<td>
<%
		}

	  String classValue="";
	  String term_set_id="";
//while ( rs.next() && i<=end )
//{
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;
	out.println("<tr><td  class='" + classValue + "'>");
	String diagCatCode = rs.getString("diag_catg_code");
	String longDec = rs.getString("long_desc");
	//String diagClassType = rs.getString("diag_class_type_desc");
	String diagClassType = "";
	
	String effStat = rs.getString("eff_status");
	String shortDec=rs.getString("short_desc");


	out.println("<a href='../../eMR/jsp/AddModifyDiagnosisCategory.jsp?mode=modify&diag_catg_code="+diagCatCode+"&target='f_query_add_mod' >");

	out.println(diagCatCode+"</a></td><td  class='" + classValue + "'>");
	
	request.setAttribute("longDec",longDec); %>
	<c:out value="${longDec}" escapeXml="true"/><%
	out.println("</td><td  class='" + classValue + "'>");
	
	request.setAttribute("shortDec",shortDec); %>
	<c:out value="${shortDec}" escapeXml="true"/><%
	out.println("</td><td  class='" + classValue + "'>");

	
	if ( effStat.equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;

	}//endwhile
%>

</td>
</tr>
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

