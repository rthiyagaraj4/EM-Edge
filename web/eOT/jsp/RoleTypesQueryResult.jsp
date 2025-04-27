<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	 <script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	int cnt=0;
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";

    String role_type = request.getParameter("role_type")==null?"":request.getParameter( "role_type" );
	String role_type_desc_sysdef = request.getParameter("role_type_desc_sysdef")==null?"":request.getParameter( "role_type_desc_sysdef" );
	String role_type_desc = request.getParameter("role_type_desc")==null?"":request.getParameter( "role_type_desc" );
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	//int cnt=0;

		if ( !(role_type == null || role_type.equals("")) ){
	        sql = sql + " where upper(role_type ) like upper('"+role_type +"%')";
			cnt++;
        }

        if ( !(role_type_desc_sysdef == null || role_type_desc_sysdef.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(role_type_desc_sysdef) like upper('"+role_type_desc_sysdef+"%')";
			else{
				sql=sql+" where upper(role_type_desc_sysdef) like upper('"+role_type_desc_sysdef+"%')";
				cnt=1;
			}

        }
	   if ( !(role_type_desc == null || role_type_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(role_type_desc) like upper('"+role_type_desc+"%')";
			else{
				sql=sql+" where upper(role_type_desc) like upper('"+role_type_desc+"%')";
				cnt=1;
			}

        }
	
	 }
String sql_count =sql;
	 	if(cnt>0)
		sql = sql+" and LANGUAGE_ID = '"+locale+"' ";
		else
		sql = sql+" where LANGUAGE_ID = '"+locale+"' ";

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

    //end of where clause IF
    else
            sql = whereClause;



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

	try{
		
		String strsql="select count(*) as total from OT_ROLE_TYPE "+sql_count;
		String strsql1="select role_type,role_type_desc_sysdef, role_type_desc from OT_ROLE_TYPE_LANG_VW "+sql;
		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		 maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		/*if(maxRecord==0) 
		{
			out.println("<script>alert('no records found');history.back();</script>");
			return;
		}
*/
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("sdfsadfs "+e);
	}
%>
	<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/RoleTypesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/RoleTypesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
<fmt:message key="eOT.SystemDefinedDescription.Label" bundle="${ot_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>


<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
      String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ; // changed by yadav
                else
            classValue = "gridData" ; // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    role_type = rset.getString(1);
    role_type_desc_sysdef=rset.getString(2);
    role_type_desc= rset.getString(3);	
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/RoleTypesModify.jsp?mode="+mode+"&role_type="+ role_type+"' target='f_query_add_mod' >");

    out.println(role_type+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+role_type_desc_sysdef+"</td>");
   out.println("<td class='" + classValue+"'>"+role_type_desc+"</td>");
  
   

	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
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

