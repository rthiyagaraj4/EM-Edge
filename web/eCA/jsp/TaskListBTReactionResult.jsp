<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,java.net.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown='lockKey()'>
<form name='gen_srch_result' id='gen_srch_result'>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String code="";
	String desc="";
	String flag="";
%>
<script>
	function closew(position)
	 {
		var Dcode=eval('document.forms[0].desc'+position).value;

		while(Dcode.indexOf("+")!=-1)
		{
			Dcode=Dcode.replace('+'," ");
		}
		window.returnValue = Dcode;
		window.close();
	 }
</script>

<%
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	int i=1;

try
{
	conn = ConnectionManager.getConnection(request);

	String from				= request.getParameter( "from" ) ;
	String to				= request.getParameter( "to" ) ;
	String searchcriteria	= request.getParameter("search_criteria") == null ? "" : request.getParameter("search_criteria");
	String searchby			= request.getParameter("search_by") == null ? "" : request.getParameter("search_by"); 
	String searchtext		= request.getParameter("search_text") == null ? "" : request.getParameter("search_text");
	String scode			= searchtext.toUpperCase();
	StringBuffer sql		= new StringBuffer();	

	java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) property.getProperty("LOCALE");

	String facilityId = session.getValue("facility_id")==null ? "" :(String) session.getValue("facility_id") ;
	
	sql.append("select REACTION_CODE REACTION_CODE,SHORT_DESC SHORT_DESC,NVL(ADVERSE_REACTION_YN,'N') ADVERSE_REACTION_YN from BT_REACTION_CODE_MAST_LANG_VW where ADDED_FACILITY_ID='"+facilityId+"' and LANGUAGE_ID='"+locale+"' ");

	if(searchby.equals("D"))
	{
		sql.append(" and upper(SHORT_DESC) like ");
	}
	else
	{
		sql.append(" and upper(REACTION_CODE) like ");
		searchtext = scode;
	}

	if(searchcriteria.equals("S"))
	{
		searchtext=searchtext+"%";
		sql.append("upper(?)");
	}
	else if(searchcriteria.equals("E"))
	{
		searchtext="%"+searchtext;
		sql.append("upper(?)");
	}
	else if(searchcriteria.equals("C"))
	{
		searchtext="%"+searchtext+"%";
		sql.append("upper(?)");
	}

	if (searchby.equals("C"))
		sql.append(" order by REACTION_CODE") ;
	else
		sql.append(" order by SHORT_DESC") ;
	

	int start = 0 ;
	int end = 0 ;
	int k = 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	try
	{

		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,searchtext);
		
		rs1=stmt.executeQuery();
		while(rs1.next())
		{
			k++;
		}

		if(k == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");
		//IN0073663 Start.
		//rs = stmt.executeQuery(sql.toString());
		if (stmt != null) stmt.close();
		if (rs1 != null) rs1.close();		
		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,searchtext);
		rs = stmt.executeQuery();
		//IN0073663 End.
%>

<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A  class='gridLink' HREF='../../eCA/jsp/TaskListBTReactionResult.jsp?from="+(start-14)+"&to="+(end-14)+"&search_text="+URLEncoder.encode(searchtext)+"&search_criteria="+searchcriteria+"&search_by="+searchby+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > k ) )
	out.println("<A class='gridLink'  HREF='../../eCA/jsp/TaskListBTReactionResult.jsp?from="+(start+14)+"&to="+(end+14)+"&search_text="+URLEncoder.encode(searchtext)+"&search_criteria="+searchcriteria+"&search_by="+searchby+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<BR><BR>
</P>

	<table  width="100%" class='grid' id='tb1'>
	
	<th width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th width='80%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

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
	//String rowclass = "" ;
	String rowclass = "gridData" ;
	String me="";
		/*if ( i % 2 == 0 )
			rowclass = "QRYEVEN" ;
		else
			rowclass = "QRYODD" ;*/
	   code=rs.getString(1);
	   desc=rs.getString(2);
	   flag=rs.getString(3);
	    out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
		
		me=code+","+desc+","+flag;
%>
	<input type='hidden' name="desc<%=i%>" id="desc<%=i%>" value="<%=me%>">
<%
		
		out.println(code+"</td><td  class='"+rowclass+"'>");
		out.println("<a class='gridLink' href=\"javascript:closew('"+i+"')\">");
		out.println(desc+"</a></td></tr>" );
		
		i++;	  
	 }
  } 
}catch(Exception e) { 
	//out.println(e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
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
}catch(Exception e) { 
	//out.println(e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>

