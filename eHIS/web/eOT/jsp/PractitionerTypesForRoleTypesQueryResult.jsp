<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%	try{

    String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String role_type =request.getParameter("role_type")==null?"":request.getParameter( "role_type" );
	String pract_type = request.getParameter("pract_type")==null?"":request.getParameter( "pract_type" );
	String desc_userdef = request.getParameter("desc_userdef")==null?"":request.getParameter( "desc_userdef" );
	String sql="";
     String role_type_desc="";
		
	//out.println(whereClause);
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;
	
	if ( !(role_type == null || role_type.equals("")) )
		{
			sql+= " and  A.role_type = '"+role_type+"' ";
			//andCheck = 1;
			cnt++;
		}


	if ( !(pract_type == null || pract_type.equals("")) )
		{
		if(cnt>0)
			sql+= " and  upper(A.pract_type) like upper('%"+pract_type+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" and  upper(A.pract_type) like upper('%"+pract_type+"%') ";
				cnt=1;

		}
	} 
	 
	
	if ( !(desc_userdef == null || desc_userdef.equals("")) )
		{
			if(cnt>0)
			sql+= " and  upper(C.desc_userdef) like upper('%"+desc_userdef+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" and upper(C.desc_userdef) like upper('%"+desc_userdef+"%')";
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
try{

// String strsql="SELECT A.ROLE_TYPE, B.ROLE_TYPE_DESC, A.PRACT_TYPE, C. DESC_USERDEF FROM OT_PRACT_TYPES_FOR_ROLE_TYPE A, OT_ROLE_TYPE B, AM_PRACT_TYPE C WHERE A.ROLE_TYPE = B.ROLE_TYPE AND A.PRACT_TYPE= C.PRACT_TYPE" +sql;

String strsql="SELECT A.ROLE_TYPE, B.ROLE_TYPE_DESC, A.PRACT_TYPE, C. DESC_USERDEF FROM OT_PRACT_TYPES_FOR_ROLE_TYPE A, OT_ROLE_TYPE_LANG_VW B, AM_PRACT_TYPE_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"'  AND B.LANGUAGE_ID='"+locale+"' AND A.ROLE_TYPE = B.ROLE_TYPE AND A.PRACT_TYPE= C.PRACT_TYPE  " +sql;


// String strsql1="SELECT A.ROLE_TYPE, B.ROLE_TYPE_DESC, A.PRACT_TYPE, C. DESC_USERDEF FROM OT_PRACT_TYPES_FOR_ROLE_TYPE A, OT_ROLE_TYPE B, AM_PRACT_TYPE C WHERE A.ROLE_TYPE = B.ROLE_TYPE AND A.PRACT_TYPE= C.PRACT_TYPE" +sql;

String strsql1="SELECT A.ROLE_TYPE, B.ROLE_TYPE_DESC, A.PRACT_TYPE, C. DESC_USERDEF FROM OT_PRACT_TYPES_FOR_ROLE_TYPE A, OT_ROLE_TYPE_LANG_VW B, AM_PRACT_TYPE_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"'  AND A.ROLE_TYPE = B.ROLE_TYPE AND A.PRACT_TYPE= C.PRACT_TYPE " +sql;

   stmt = conn.prepareStatement(strsql);
   rs = stmt.executeQuery();
   
   int total=0;
		while(rs.next())
	{
		total++;

	}

	 maxRecord=total;
		if(maxRecord == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("139:---- sdfsadfs  "+e);
	}

%>
<form name='QueryResult' id='QueryResult'>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/PractitionerTypesForRoleTypesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/PractitionerTypesForRoleTypesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='3'>

<th class='columnHeaderCenter'>
		<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
<th class='columnHeaderCenter'>
		<fmt:message key="eOT.RoleTypeDescription.Label" bundle="${ot_labels}"/></th>
<th class='columnHeaderCenter'>
		<fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
<th class='columnHeaderCenter'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>


<%
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
	String classValue = "" ;
	
while ( rset.next() && i<=end )
{
        if ( i % 2 == 0 )
			classValue = "gridData" ;
		else
			classValue = "gridData" ;
		

	out.println("<tr><td class='" + classValue + "' nowrap>");

	 role_type = rset.getString(1);
	 role_type_desc = rset.getString(2);
	 pract_type = rset.getString(3);
	 desc_userdef = rset.getString(4);

	//String mode="modify";
	//out.println("<a href='../../eOT/jsp/PractitionerTypesForRoleTypesFrameInCreateMode.jsp?mode="+mode+"&role_type="+role_type+"&role_type_desc="+role_type_desc+"&pract_type="+pract_type+"&desc_userdef="+desc_userdef+"' target='f_query_add_mod' >");
    //out.println(role_type+"</a></td>");
  

	out.println(role_type+"</td><td class='" + classValue + "' nowrap>");
	out.println(role_type_desc+"</td><td class='" + classValue + "' nowrap>");
	out.println(pract_type+"</td><td class='" + classValue + "' nowrap>");
	out.println(desc_userdef+"</td>");
	
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

