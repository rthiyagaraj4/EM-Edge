<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>
  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>
<form name='gen_srch_result' id='gen_srch_result'>

<%
	request.setCharacterEncoding("UTF-8");	
	String search_desc =request.getParameter("search_desc");
	String search_code =request.getParameter("search_code");
	String code="";
	String desc="";
%>
<script>
	function closew(position)
	  {
		
		var Dcode=eval('document.forms[0].desc'+position).value;

		while(Dcode.indexOf("+")!=-1)
		  {
		Dcode=Dcode.replace('+'," ");
		  }
		window.parent.parent.returnValue=Dcode;
		window.parent.parent.close();
	  }
 </script>


<%
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
ResultSet rs1=null;
String searchtext="";
int i=1;
String dispDescFirst =request.getParameter("dispDescFirst");
if(dispDescFirst == null) dispDescFirst="";

try{
	conn=ConnectionManager.getConnection(request);

String whereClause = request.getParameter("whereclause");
String sql="";
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String searchcriteria=request.getParameter("search_criteria");
searchtext = request.getParameter("searchtext");
if(searchtext == null) searchtext="";

if ( (whereClause == null || whereClause.equals("")) )
{
 sql = request.getParameter("SQL");
sql = sql.replace('`','\'') ;
int j = sql.indexOf("where");

if(j == -1)
	{
	 sql= sql +" where";
	}
if(j > 0)
	{
	 sql= sql + " and";
	}


String l_where_clause="";
//String scheme=request.getParameter("s_scheme");
String searchby=request.getParameter("search_by"); 
 searchtext=request.getParameter("search_text");
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
	{
		searchtext=searchtext+"%";
		l_where_clause=l_where_clause+"upper(?)";
	}
else if(searchcriteria.equals("E"))
{
		searchtext="%"+searchtext;
		l_where_clause=l_where_clause+"upper(?)";
}
else if(searchcriteria.equals("C"))
{
		searchtext="%"+searchtext+"%";
		l_where_clause=l_where_clause+"upper(?)";
}

if (searchby.equals("C"))
sql+=" "+l_where_clause+ " order by "+search_code ;
else
sql+=" "+l_where_clause+ " order by "+search_desc ;

} 
else
	{
	sql = whereClause;
	searchtext =searchtext;
	}


//int maxRecord = 0;		
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

stmt = conn.prepareStatement(sql);
stmt.setString(1,searchtext);

rs1=stmt.executeQuery();
while(rs1.next())
{
	k++;

}

if(k == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");

rs = stmt.executeQuery(sql);

%>

<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eCommon/jsp/GeneralSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"&searchtext="+URLEncoder.encode(searchtext)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > k ) )
	out.println("<A HREF='../../eCommon/jsp/GeneralSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"&searchtext="+URLEncoder.encode(searchtext)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<BR><BR>
</P>




	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
	<%if(dispDescFirst.equals("dispDescFirst")) {%>
	<th width='60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th width='40%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<%} else {%>
	<th width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th width='80%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<%} %>

	<%
if(rs != null)
{
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rs.next() ;

	while(rs.next() && i<=end)
	{
%>
<%
	String rowclass = "" ;
	String me="";
//	String d="/";
		if ( i % 2 == 0 )
			rowclass = "QRYEVEN" ;
		else
			rowclass = "QRYODD" ;
	   code=rs.getString(1);
	   desc=rs.getString(2);
	    out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
	
		
	
		//out.print(me);
		if(dispDescFirst.equals("dispDescFirst")) {
		me=desc+"::"+code;
		%><input type='hidden' name="desc<%=i%>" id="desc<%=i%>" value="<%=me%>"><%
	out.println("<a    href=\"javascript:closew('"+i+"')\">");
	out.println(desc+"</a></td><td  class='"+rowclass+"'>");
		out.println( code+"</td></tr>" );
		}
		else
		{
		me=code;
%><input type='hidden' name="desc<%=i%>" id="desc<%=i%>" value="<%=me%>"><%

		out.println("<a    href=\"javascript:closew('"+i+"')\">");
		out.println(code+"</a></td><td  class='"+rowclass+"'>");
		out.println( desc+"</td></tr>" );
		}
		i++;	  
	 }
  } 
}catch(Exception e) { out.println(e.toString());
}
	finally
	{
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
	}
%>
</table>
<input type='hidden' name='searchtext' id='searchtext' value="<%=searchtext%>" > 
</form>
</BODY>
</html>
<%
}catch(Exception e) { out.println(e.toString());
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>

