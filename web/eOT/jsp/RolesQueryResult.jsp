<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>


<HTML>
	<head>
	<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link type='text/css' rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    int start = Integer.parseInt(checkForNull(request.getParameter( "from" ),"1"));
    int end = Integer.parseInt(checkForNull(request.getParameter( "to" ),"14") );
    String sql = " ";
    String role_type =checkForNull(request.getParameter("role_type"));
	String role_id = checkForNull(request.getParameter("role_id"));
	String role_desc =checkForNull(request.getParameter("role_desc"));
	//String role_type_desc =request.getParameter("role_type_desc")==null?"":request.getParameter( "role_type_desc" );
	String role_type_desc ="";
	String appl_to_ot_slate = checkForNull(request.getParameter("appl_to_ot_slate"));
    String enabled = checkForNull(request.getParameter("status"));
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(role_id == null || role_id.equals("")) ){
	        sql = sql + " and upper(role_id ) like upper('"+role_id +"%')";
			cnt++;
        }

        if ( !(role_desc == null || role_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(role_desc) like upper('"+role_desc+"%')";
			else{
				sql=sql+" and upper(role_desc) like upper('"+role_desc+"%')";
				cnt=1;
			}

        }
	   if ( !(role_type == null || role_type.equals("")) ){
			if(cnt>0)
				sql = sql + " and a.role_type like '"+role_type+"%'";
			else{
				sql=sql+" and   a.role_type like '"+role_type+"%'";
				cnt=1;
			}

        }

		/*if ( !(role_type_desc == null || role_type_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and role_type like '"+role_type_desc+"%'";
			else{
				sql=sql+" and role_type_desc like '"+role_type_desc+"%'";
				cnt=1;
			}

        }*/
	if(!(appl_to_ot_slate==null || appl_to_ot_slate.equals("all")) ){
	    if(appl_to_ot_slate.equals("Y")){
		 
		 if(cnt>0)
			 sql = sql+" and nvl(appl_to_ot_slate,'N')='Y' ";
		 else{
			 sql = sql+" and nvl(appl_to_ot_slate,'N')='Y' ";
		     cnt=1;
		 }
		 }


		 if(appl_to_ot_slate.equals("N")){
			 if(cnt>0)
			 sql = sql+" and appl_to_ot_slate = 'N' ";
		 else{
			 sql = sql+" and appl_to_ot_slate = 'N' ";
			 cnt=1;
		 }
		     
	   }
	  
	}

	
	if ( !(enabled == null || enabled.equals("")) ){
		
         if( enabled.equals("E") ){
		    if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E' ";
			else{
				sql=sql+ " and nvl(status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and status='D'";
			else
				sql=sql+ " and status='D'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
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

    } //end of where clause IF
    else
            sql = whereClause;



   /* int start = 0 ;
    int end = 0 ;*/
    int i=1;

   /* if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;*/

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		//String strsql="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate,nvl(A.STATUS,'E') STATUS FROM OT_ROLES A, OT_ROLE_TYPE B WHERE A.ROLE_TYPE = B.ROLE_TYPE(+) "+sql;
		//String strsql1="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate, nvl(A.STATUS,'E') STATUS FROM OT_ROLES A, OT_ROLE_TYPE B WHERE A.ROLE_TYPE = B.ROLE_TYPE(+) "+sql;

		// String strsql="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate,nvl(A.STATUS,'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE B WHERE A.LANGUAGE_ID='"+locale+"' AND A.ROLE_TYPE = B.ROLE_TYPE(+) "+sql;
		// String strsql1="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate, nvl(A.STATUS,'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE B WHERE A.LANGUAGE_ID='"+locale+"' AND A.ROLE_TYPE = B.ROLE_TYPE(+) "+sql;

		//String strsql="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate,nvl(A.STATUS,'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE_LANG_VW B WHERE A.LANGUAGE_ID='"+locale+"' AND  B.LANGUAGE_ID='"+locale+"' AND A.ROLE_TYPE = B.ROLE_TYPE(+) "+sql;

		String strsql="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate,nvl(A.STATUS,'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE_LANG_VW B WHERE A.LANGUAGE_ID='"+locale+"' AND  B.LANGUAGE_ID='"+locale+"' AND A.ROLE_TYPE = B.ROLE_TYPE(+) "+sql;
		String strsql1="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate, nvl(A.STATUS,'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE_LANG_VW B WHERE A.LANGUAGE_ID='"+locale+"' AND  B.LANGUAGE_ID='"+locale+"' AND A.ROLE_TYPE = B.ROLE_TYPE(+) "+sql;
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		int total=0;
		while(rs.next())
		{
			total++;
		}
		maxRecord = total;
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
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
    out.println("<A HREF='../../eOT/jsp/RolesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/RolesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.RoleID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.ApplicableForOTSlate.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th>

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

    role_id = rset.getString(1);
    role_desc=rset.getString(2);
    role_type= rset.getString(3);
	role_type_desc=rset.getString(4);
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/RolesAddModify.jsp?mode="+mode+"&role_id="+ role_id+"&role_type="+role_type+"&role_type_desc="+role_type_desc+"' target='f_query_add_mod' >");
    out.println(role_id+"</a></td>");
  
   out.println("<td class='" + classValue+"' nowrap>"+role_desc+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+role_type_desc+"</td>");
   
  
   out.println("<td class='" + classValue + "' align='center'>");
   if ( rset.getString("appl_to_ot_slate").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
     out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	//out.println("<td class='" + classValue + "' align='center'>");
	
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

