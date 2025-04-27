<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle = "";
request.setCharacterEncoding("UTF-8");
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

try 
{
	con=ConnectionManager.getConnection(request);
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script Language="JavaScript" src='../js/ProcedureList.js'></script>
</head>
<body   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollTitle()' >
<%
	
	
	String code="";
	String desc="";
StringBuffer l_where_clause= new StringBuffer();
String scheme=(request.getParameter("s_scheme")==null)?"":request.getParameter("s_scheme");
String searchby=request.getParameter("search_by");
String searchcriteria=request.getParameter("search_criteria");
String searchtext=request.getParameter("search_text");
searchtext=searchtext.toUpperCase();
StringBuffer sql= new StringBuffer();
int i=0;

if(scheme.equals("3"))
{
	
	if(searchby.equals("D"))
			l_where_clause.append(" upper(short_desc) like ");
		else
			l_where_clause.append("cpt_code like ");

	if(searchcriteria.equals("S"))
	{
		//l_where_clause.append(l_where_clause);
		l_where_clause.append("'");
		l_where_clause.append(searchtext);
		l_where_clause.append("%");
		l_where_clause.append("'");
	}
		else if(searchcriteria.equals("E"))
	{
			//l_where_clause.append(l_where_clause);
			l_where_clause.append("'");
			l_where_clause.append("%");
			l_where_clause.append(searchtext);
			l_where_clause.append("'");
	}
		else if(searchcriteria.equals("C"))
	{
			//l_where_clause.append(l_where_clause);
			l_where_clause.append("'%");
			l_where_clause.append(searchtext);
			l_where_clause.append("%'");
	}
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("Select cpt_code,short_desc from mr_cpt_code where  ");
					sql.append(l_where_clause);
					//out.println(sql.toString());
}

else if(scheme.equals("4")||scheme.equals("6")||scheme.equals(""))
{
	
	if(searchby.equals("D"))
	{
		l_where_clause.append(" upper(short_desc) like");
	}
	else
	{
		l_where_clause.append(" diag_code like");
	}

	
	if(searchcriteria.equals("S"))
	{	
		//l_where_clause.append(l_where_clause);
		l_where_clause.append("'");
		l_where_clause.append(searchtext);
		l_where_clause.append("%");
		l_where_clause.append("'");
	}
	
	else if(searchcriteria.equals("E"))
	{
		//l_where_clause.append(l_where_clause);
		l_where_clause.append("'");
		l_where_clause.append("%");
		l_where_clause.append(searchtext);
		l_where_clause.append("'");
	}
	
	else if(searchcriteria.equals("C"))
	{
		//l_where_clause.append(l_where_clause);
		l_where_clause.append("'%");
		l_where_clause.append(searchtext);
		l_where_clause.append("%'");
	}
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("Select diag_code,short_desc from mr_icd_code where  record_type='O'  and ");
				sql.append(l_where_clause );
				sql.append(" order by 1 ");
				

}


try
{

//out.println(sql);
stmt = con.prepareStatement(sql.toString());

rs = stmt.executeQuery();
//rs.next();

%>
<div id='divDataTitle' style='postion:relative'>
<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
	<tr>
		<td class= 'columnheader' width='16%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class= 'columnheader' > <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>	
	</tr>
</table>
</div>
<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">

<%
String rowclass = "" ;
String me="";


while ( rs.next()){
//	out.println("joi"+i);
	if (i%2==0) 	rowclass = "QRYEVEN" ;
	else	 	rowclass = "QRYODD" ;
    code=rs.getString(1);
    desc=rs.getString(2);
    out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
	me=code+"/"+desc;
	me=me.replace('>','`');
	me=me.replace(' ','%');
	out.println("<a    href=javascript:closewd('"+me+"')>");
	out.println(code+"</a></td><td  class='"+rowclass+"'>");
	out.println( desc+"</td></tr>" );
i++;
  }
  if(i==0){ %>
		<Script language=javascript>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
  </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

  <%}

}
catch(Exception e)
{
		out.print("Exception iN Result"+e.toString());
}
%>
<tr style='visibility:hidden'>
	<td class= 'columnheader' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class= 'columnheader' > <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>	
</tr>
</table>
</BODY>
</html>
<%
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e)
{
			out.println("Exception1 "+e);
			out.println("<html><head><link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><body CLASS='MESSAGE' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'></body>");
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

