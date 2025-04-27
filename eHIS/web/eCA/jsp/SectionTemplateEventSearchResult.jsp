<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"contentType="text/html;charset=UTF-8" %>
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
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
<%
	String search_desc =request.getParameter("search_desc");
	String search_code =request.getParameter("search_code");
	//String code_type   =request.getParameter("code_type");
	String code="";
	String desc="";
	String eventtype="";
%>
<script>
	function closew(Dcode)
	  {
		while(Dcode.indexOf("+")!=-1)
		Dcode=Dcode.replace('+'," ");
	
		
		window.parent.parent.returnValue=escape(Dcode);
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
			 sql= sql +" where";
		if(j > 0)
			 sql= sql + " and";		
		
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
		sql = sql + " "+l_where_clause+ " order by "+search_code ;
		else
		sql = sql + " "+l_where_clause+ " order by "+search_desc ;
	} 
	else{
		sql = whereClause;
		searchtext =searchtext;
	}

			
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
		rs=stmt.executeQuery();
		
		if(rs != null)
		{		
		%>
			<table align='right'>
				<tr>
					<td>
						<%
						if ( !(start <= 1) )
							out.println("<A HREF='../../eCA/jsp/SectionTemplateEventSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"&searchtext="+URLEncoder.encode(searchtext)+"'  class='gridLink'>Previous</A>");
						
						if ( !( (start+14) > k ) )
							out.println("<A HREF='../../eCA/jsp/SectionTemplateEventSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"&searchtext="+URLEncoder.encode(searchtext)+"' class='gridLink'>Next</A>");
						%>
					</td>
				</tr>
			</table>
			<BR>
			</P>
			<table class='grid' width="100%" id='tb1' >
			<%if(dispDescFirst.equals("dispDescFirst")) {%>
				<td class='columnheadercenter' width='60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter' width='40%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<%} else {%>
				<td class='columnheadercenter' width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter' width='80%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<%} 
		
			if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				rs.next() ;

				while(rs.next() && i<=end)
				{
					k++;
					String rowclass = "" ;
					String me="";
					rowclass = "gridData" ;		
				   	code=rs.getString(1);
				   	desc=rs.getString(2);
				   	eventtype=rs.getString(3);
				    out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");		
	
					if(dispDescFirst.equals("dispDescFirst")) {
						me=desc+"::"+code+"::"+eventtype;
						%>
							<a class='gridLink' href=javascript:closew("<%=java.net.URLEncoder.encode(me)%>")>
						<%	
							out.println(code+"</a></td><td  class='"+rowclass+"'>");
							out.println( desc+"</td></tr>" );
					}else{
						me=code;
						out.println("<a class='gridLink'  href=\"javascript:closew('"+me+"')\">");
						out.println(desc+"</a></td><td  class='"+rowclass+"'>");
						out.println( code+"</td></tr>" );
					}
					i++;	  
 				}
				if(k == 0)
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");
								
  		}
	}catch(Exception e) { 
		//out.println(e.toString());//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
	}finally{
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
	}
%>
</table>
<input type='hidden' name='searchtext' id='searchtext' value="<%=searchtext%>" > 
</BODY>
</html>
<%
}catch(Exception e) { 
	//out.println(e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
}finally{
	if (conn != null) 
		ConnectionManager.returnConnection(conn,request);
}
%>

