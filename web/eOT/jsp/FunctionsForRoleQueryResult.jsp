<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<BODY class='CONTENT'  OnMouseDown="" onKeyDown="lockKey()">

<%	try{

    String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String role_id =request.getParameter("role_id")==null?"":request.getParameter( "role_id" );
	String function_id = request.getParameter("function_id")==null?"":request.getParameter( "function_id" );
    String srl_no=request.getParameter("srl_no")==null?"":request.getParameter( "srl_no" );
    String function_desc_user = request.getParameter("function_desc_user")==null?"":request.getParameter( "function_desc_user" );
    String sql="";
    String role_desc="";
	if ( (whereClause == null || whereClause.equals("")) ){
	int cnt=1;
	if ( !(role_id == null || role_id.equals("")) ){
		   	sql=sql+ "and  A.role_id = '"+role_id+"' ";
			cnt++;
		}
	if ( !(function_id == null || function_id.equals("")) )
		{
		if(cnt>0){
			sql=sql+ " and  A.function_id like'"+function_id+"%'";
			}else{
				sql=sql+" where A.function_id like '"+function_id+"%' ";
				cnt=1;

		}
	} 

	if ( !(srl_no == null || srl_no.equals("")) )
		{
		if(cnt>0){
			sql=sql+ " and  upper(A.srl_no) like upper('"+srl_no+"%')";
			}else{
				sql=sql+" where upper(A.srl_no) like upper('"+srl_no+"%')";
				cnt=1;

		}
	} 
	 
	
	if ( !(function_desc_user == null || function_desc_user.equals("")) )
		{
			if(cnt>0){
				sql=sql+ " and  upper(C.function_desc_user) like upper('"+function_desc_user+"%')";
			}else{
				sql=sql+" where upper(C.function_desc_user) like upper('"+function_desc_user+"%')";
				cnt=1;
			}
		}


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
	}//end of where clause IF


 else
    {
	sql = whereClause;
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

Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rs=null;
ResultSet rset=null;
int maxRecord = 0;
String strsql="";
String strsql1="";
try{

//String strsql="SELECT A.ROLE_ID, B.ROLE_DESC, A.FUNCTION_ID, C.FUNCTION_DESC_USER FROM OT_ROLES_FUNCTIONS A, OT_FUNCTIONS_LANG_VW C, OT_ROLES B WHERE C.LANGUAGE_ID ='"+locale+"'  AND A.FUNCTION_ID = C.FUNCTION_ID AND A.ROLE_ID = B.ROLE_ID" +sql;
//String strsql1="SELECT A.ROLE_ID, B.ROLE_DESC, A.FUNCTION_ID, C.FUNCTION_DESC_USER FROM OT_ROLES_FUNCTIONS A, OT_FUNCTIONS_LANG_VW C, OT_ROLES B WHERE C.LANGUAGE_ID ='"+locale+"'  AND A.FUNCTION_ID = C.FUNCTION_ID AND A.ROLE_ID = B.ROLE_ID" +sql;

strsql="SELECT A.ROLE_ID, B.ROLE_DESC, A.FUNCTION_ID, GET_DESC('"+locale+"','OT_FUNCTIONS_LANG_VW','FUNCTION_DESC_USER','FUNCTION_ID',A.FUNCTION_ID) FUNCTION_DESC_USER FROM OT_ROLES_FUNCTIONS A, OT_FUNCTIONS C, OT_ROLES_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.FUNCTION_ID = C.FUNCTION_ID AND A.ROLE_ID = B.ROLE_ID " +sql;
strsql1="SELECT A.ROLE_ID, B.ROLE_DESC, A.FUNCTION_ID, GET_DESC('"+locale+"','OT_FUNCTIONS_LANG_VW','FUNCTION_DESC_USER','FUNCTION_ID',A.FUNCTION_ID) FUNCTION_DESC_USER FROM OT_ROLES_FUNCTIONS A, OT_FUNCTIONS C, OT_ROLES_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.FUNCTION_ID = C.FUNCTION_ID AND A.ROLE_ID = B.ROLE_ID " +sql;

   stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		
    int total=0;
		while(rs.next())
	{
			total++;
	}
		maxRecord = total;
		if(maxRecord == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("sdfsadfs "+e);
		//out.println("strsql=="+strsql);
		//out.println("strsql1==="+strsql1);
	}

%>
<form name='QueryResult' id='QueryResult'>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/FunctionsForRoleQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/FunctionsForRoleQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 >
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.RoleID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.RoleDescription.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.FunctionDescription.Label" bundle="${ot_labels}"/>
</th>


<%
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
	String classValue = "gridData" ;
	
while ( rset.next() && i<=end )
{
        if ( i % 2 == 0 )
			  classValue = "gridData" ; // changed by yadav
		else
			  classValue = "gridData" ; // changed by yadav

	 out.println("<tr><td class='" + classValue + "'>");
	 role_id = rset.getString(1);
	 role_desc = rset.getString(2);
	 function_id = rset.getString(3);
	 function_desc_user = rset.getString(4);
	out.println(role_id+"</td><td class='" + classValue + "'>");
	out.println(role_desc+"</td><td class='" + classValue + "'>");
	out.println(function_id+"</td><td class='gridData'>"); // changed by yadav
	out.println(function_desc_user+"</td>");
	
	i++;

}


		
%>

</td></tr>
</table>
<br><center>
<%
	if(stmt!=null)
			stmt.close();
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
		if(rs!=null)
			rs.close();
		ConnectionManager.returnConnection(conn,request);

		}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("here "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

