<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='JavaScript' src='../../eOT/js/RolesForUser.js'></script>
	<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>	
	<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->	
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String user_id =request.getParameter( "user_id" );
    String roles = request.getParameter( "roles" );
    String user = (String) session.getValue( "login_user" );
	String strsql1 ="";
try
{
    String querymode=request.getParameter("querymode");
    String whereClause = request.getParameter("whereclause");
    if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
   
     StringBuffer sql = new StringBuffer();
     	if ( (whereClause == null || whereClause.equals("")) ){
	 	int cnt=0;
	 	if ( !(user_id == null || user_id.equals("")) ){
	 		   	sql.append( "and  appl_user_name = '"+user_id+"' ");//50488 //IN:050706
	 			cnt++;
	 		}
	 	if ( !(roles == null || roles.equals("")) )
	 		{
	 		if(cnt>0){
	 			sql.append( " and  role_id ='"+roles+"' ");
	 			}else{
	 				sql.append(" and role_id = '"+roles+"' ");//IN:050706
	 				cnt=1;
	 
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
    else
       strsql1 = whereClause;

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
Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;
String role="";
String user_id1="";
String user_name="";
String role_type="";
String role_desc="";
//String isDefaultYN="Y";
String applicability="";
String isdefault="";
		System.err.println("93:sql==================="+sql+"===user_id==="+user_id);
		if ( (whereClause == null || whereClause.equals("")) )
			//strsql1="SELECT  appl_user_id ,appl_user_name username,role_desc role_desc, role_id role_id,applicability applicability,is_default is_default from ot_roles_for_users "+sql;
			strsql1="SELECT a.appl_user_id, a.appl_user_name username, a.role_desc role_desc,a.role_id role_id, a.applicability applicability, a.is_default is_default, a.ROLE_Type, b.ROLE_TYPE_DESC role_type_desc FROM ot_roles_for_users a,ot_role_type b where a.ROLE_TYPE = b.ROLE_TYPE(+)"+sql;//IN:050706
		System.err.println("96:strsql1==================="+strsql1);
		stmt = conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
%>
<form name='RolesForUserQueryResult' id='RolesForUserQueryResult'>
<p>
<table align='right'>
<tr>
<td>
<%
	System.err.println("===start===="+start);
	System.err.println("===maxRecord===="+maxRecord);
	if ( !(start <= 1) )
	{
		//out.println("<A HREF='../jsp/RolesForUserQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(strsql1)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		//out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
		out.println("<A HREF='../jsp/RolesForUserQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(strsql1)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	if ( !( (start+14) > maxRecord ) )
	{
		//	out.println("<A HREF='../jsp/RolesForUserQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(strsql1)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		//out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
		out.println("<A HREF='../jsp/RolesForUserQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(strsql1)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}

%>
</td>
</tr>
</table>
</p><br><br>
<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnheadercenter" nowrap> User ID </th>
<th class="columnheadercenter" nowrap> User Name </th>
<th class="columnheadercenter" nowrap> <fmt:message key="eOT.Roles.Label" bundle="${ot_labels}"/> </th>
<th class="columnheadercenter" nowrap> <fmt:message key="eOT.RoleType.Label" bundle="${ot_labels}"/> </th>
<th class="columnheadercenter" nowrap> <fmt:message key="eOT.IsDefault.Label" bundle="${common_labels}"/> </th>
<%
	if(maxRecord != 0)
	{
		rs.beforeFirst();
		for( int j=1; j<start; i++,j++ )
			rs.next();
		String classValue= " ";
		while (rs.next() && i<=end)
		{
			classValue = "gridData" ;
			user_id1 = rs.getString("appl_user_id");
			user_name=rs.getString("username");
			role=rs.getString("ROLE_id");
			role_desc=rs.getString("role_desc");
			role_type=rs.getString("role_type_desc");//IN:050706
			applicability=rs.getString("applicability");
			isdefault=rs.getString("is_default");
			System.err.println("isdefault======"+isdefault);
			out.println("<tr><td align='left' class='" + classValue + "'nowrap>"+user_id1+"</td>");
			out.println("<td class='" + classValue+"' nowrap>"+user_name+"</td>");
			out.println("<td class='" + classValue+"' nowrap>"+role_desc+"</td>");//050706 
			out.println("<td class='" + classValue+"' nowrap>"+role_type+"</td>");//050706

			if (isdefault !=null && isdefault.equals("Y"))
			   out.println("<td class='" + classValue+"' nowrap><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
			   out.println("<td class='" + classValue+"' nowrap><img src='../../eCommon/images/RRnwd.gif'></img></td>");
			i++;
		}
	}
	else
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");

%>

</td></tr>
</table>
<input type=hidden name=mode value='modify'>
<input type=hidden name=QueryMode value='<%=querymode%>'>

</center>

<br><center>
<%
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		if(conn!=null) conn.close();
ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	//out.println("RolesForUserQueryResult "+e);
	e.printStackTrace();
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='user' id='user' value="<%=user%>">
<input type='hidden' name='user_id' id='user_id' value="<%=user_id%>">
</form>
</BODY>
</HTML>

