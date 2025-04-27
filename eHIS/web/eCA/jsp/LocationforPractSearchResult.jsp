<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @10-12-2008> -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<!--<script src="../../eCA/js/LocationforPract.js" language="javascript"></script> -->
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script>
function closew(Dcode)
{
	while(Dcode.indexOf("+")!=-1)
	Dcode=Dcode.replace('+'," ");
	window.parent.parent.returnValue = escape(Dcode);
	window.parent.parent.close();
}

</script>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String  Dcode="";
	String search_desc =request.getParameter("search_desc");
	String search_code =request.getParameter("search_code");
	String splty_code  =request.getParameter("splty_code");
	if(splty_code == null) splty_code="";
	String code="";
	String desc="";
%>


<%
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	int i=1;
	String dispDescFirst =request.getParameter("dispDescFirst");
	if(dispDescFirst == null) dispDescFirst="";

	try{
		conn=ConnectionManager.getConnection(request);

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String sqlstr="";
	if ( (whereClause == null || whereClause.equals("")) )
	{
	 sqlstr = request.getParameter("SQL");
	sqlstr = sqlstr.replace('`','\'') ;
	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append(sqlstr.toString());
	int j = sqlstr.indexOf("where");
	if(j == -1)
	
	
	sql.append(" where");
	if(j > 0)
	 sql.append(" and");


	String l_where_clause="";
	String searchby=request.getParameter("search_by");
	String searchcriteria=request.getParameter("search_criteria");
	String searchtext=request.getParameter("search_text");
	String scode = searchtext.toUpperCase();


	if(searchby.equals("D"))
	{
		l_where_clause=" upper("+search_desc+") like ";
	}
	else
	{
		l_where_clause=" upper("+search_code+") like ";
		searchtext = scode;
	}

	if(searchcriteria.equals("S"))
		l_where_clause=l_where_clause+"upper('"+searchtext+"%"+"')";
	else if(searchcriteria.equals("E"))
		l_where_clause=l_where_clause+"upper('%"+searchtext+"')";
	else if(searchcriteria.equals("C"))
		l_where_clause=l_where_clause+"upper('%"+searchtext+"%"+"')";

	sql.append(" "+l_where_clause);

	if (!splty_code.equals(""))
	{
	/*		sql+= " and '"+splty_code+"' in (select primary_speciality_code from am_practitioner where practitioner_id = b.practitioner_id union select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where practitioner_id = b.practitioner_id )"; */
		sql.append(" and PRIMARY_SPECIALITY_CODE = '"+splty_code+"'");
	}
	
	//new code
	sql.append(" order by "+search_code);

	} 
	else
		sql.append(whereClause);

	int start = 0 ;
	int end = 0 ;
	int k=0;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt( to ) ;

	try{

	stmt = conn.prepareStatement(sql.toString());
	rs1=stmt.executeQuery();
	while(rs1.next())
	{
		k++;

	}


	rs = stmt.executeQuery(sql.toString());
	int count = 0;
	%>

	<table  align='center' cellpadding='3'width='100%'>
	<tr>
	<td align='right' nowrap>
	<%
	if ( !(start <= 1) )
		out.println("<A class='gridLink'  href ='LocationforPractSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > k ) )
		out.println("<A class='gridLink'  href ='LocationforPractSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
	</td>
	</tr>
	</table>
	
	

	<table  class='grid'  width="100%"  id='tb1'>
	<%if(dispDescFirst.equals("dispDescFirst")) {%>
	<td class='columnheader' width='60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='40%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<%} else {%>
	<td class='columnheader' width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='80%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<%} %>

	<%
	if(rs != null)
	{
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rs.next() ;

		while(rs.next() && i<=end)
		{
			count++;
			String rowclass = "" ;
			String me="";

		if ( i % 2 == 0 )
			rowclass = "gridData" ;
		else
			rowclass = "gridData" ;
			code=rs.getString(1);
			desc=rs.getString(2);
			out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
	
			if(dispDescFirst.equals("dispDescFirst")) {
			me=desc+"::"+code;
	%>
		<a class='gridLink'  href =javascript:closew("<%=java.net.URLEncoder.encode(me)%>")>
	<%	out.println(desc+"</a></td><td  class='"+rowclass+"'>");
		out.println( code+"</td></tr>" );
		}
		else
		{
		me=code;
		out.println("<a    class='gridLink'  href =\"javascript:closew('"+me+"')\">");
		out.println(code+"</a></td><td  class='"+rowclass+"'>");
		out.println( desc+"</td></tr>" );
		}
		i++;	  
	 }
  }
 
	if(count == 0)
	{
		 //out.println("<script language='javascript'>alert(messageArray['NO_RECORD_FOUND_FOR_CRITERIA'])");
		 out.println("<script language='javascript'>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))");	
		 out.println("parent.group_head.document.forms[0].Search.focus();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");

	}
	
}
catch(Exception e) 
{ 
	//out.println("Exception @ #333 "+ e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}

%>
</table>
</BODY>
</html>
<%
	if (rs != null) rs.close();
	if (rs1 != null) rs1.close();
	if (stmt != null) stmt.close();
}
catch(Exception e)
{
	//out.println("Exception @ 3333"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (conn != null) 
	ConnectionManager.returnConnection(conn,request);
}	

%>

