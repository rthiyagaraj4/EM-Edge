<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%


Connection conn  = null;
PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rset=null;
ResultSet rs = null;
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
     String from = checkForNull(request.getParameter( "from" ),"1") ;
    String to = checkForNull(request.getParameter( "to" ),"14" ) ;
    String sql = "";

    String age_group_code= request.getParameter("age_group_code")==null?"":request.getParameter( "age_group_code" );
	String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" );
	String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" );
    String enabled = request.getParameter("status")==null?"":request.getParameter( "status");
String status="";
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(age_group_code == null || age_group_code.equals("")) ){					
	        sql = sql + "where  upper(age_group_code ) like upper('"+age_group_code +"%') ";
			cnt++;
        }

	
	
        if ( !(short_desc == null || short_desc.equals("")) ){
			if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(short_desc) like upper('"+short_desc+"%') ";
			  else 
			{
				  sql = " where upper(short_desc) like upper('"+short_desc+"%') ";
				  cnt++;
			}


        }

			

		 if ( !(long_desc == null || long_desc.equals("")) ){
			 if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(long_desc) like upper('"+long_desc+"%')";
			else 
				{
				  sql = " where upper(long_desc) like upper('"+long_desc+"%') ";
				  cnt++;
				}

        }

	if ( !(enabled == null || enabled.equals("")) ){
		
         if( enabled.equals("E") ){
			if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
			   sql = sql+"  nvl(status,'E')='E'";
			else{
				sql=sql+ " where  nvl(status,'E')='E'";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){
			 if (sql.length() > 0)  sql =sql+"  and ";
            if(cnt>0)
			   sql = sql+"  nvl(status,'E')='D'";
			else
				sql=sql+ "where  nvl(status,'E')='D'";
         }


	//if(sql.length() >0 )				 sql = " where  "+sql;

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

	}

	int start = 0 ;
    int end = 0 ;
    int i=1;
	start = Integer.parseInt( from ) ;
	end = Integer.parseInt( to ) ;



 conn  =  ConnectionManager.getConnection(request);


int maxRecord = 0;
	try{

		

			String strsql= "SELECT AGE_GROUP_CODE,LONG_DESC,SHORT_DESC,STATUS FROM BL_INS_AGE_GROUP  "+sql ;
			String strsql1= "SELECT AGE_GROUP_CODE,LONG_DESC,SHORT_DESC,STATUS FROM BL_INS_AGE_GROUP  "+sql ;

		System.out.println("BLINSAgeLimitQueryResult.jsp  sql  "+strsql1);

		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		int total=0;
		while(rs.next())
		{
			total++;
		}
		
		maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
//		stmt1.setString(1,locale);
//		stmt1.setString(2,locale);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		out.println("sdfsadfs "+e);
	}

%>
<P>
<form name="QueryResult" id="QueryResult">
<table cellspacing=0 cellpadding=3  align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eBL/jsp/BLInsAgeLimitQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eBL/jsp/BLInsAgeLimitQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.status.label" bundle="${common_labels}"/>
</th>

<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;


String classValue= " ";
      while ( rset.next() && i<=end  )
{
	if ( i % 2 == 0 )      classValue = "QRYODD" ; 
     else				   classValue = "QRYODD" ; 

    out.println("<tr><td align=='left' class='" + classValue + "'>");

     age_group_code = rset.getString(1);
     long_desc= rset.getString(2);
     short_desc=rset.getString(3);
     status =  rset.getString(4);

	 status=status==null?"E":status;
	String mode="modify";

	out.println("<a href='../../eBL/jsp/BLInsAgeLimitAddModify.jsp?mode="+mode+"&age_group_code="+age_group_code+"' target='f_query_add_mod' >");
	out.println(age_group_code+"</a></td>");
	 out.println("<td class='" + classValue+"'>"+long_desc+"</td>");  
    out.println("<td class='" + classValue+"'>"+short_desc+"</td>");   

	out.println("<td class='" + classValue+"'>");
	  if ( status.equals("E"))
	    out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else 
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
   	out.println("</td>");
  
	
	i++;
} %>

</tr>
</table>
</center>

<br><center>
<%

}
catch(Exception e)
{
	out.println("here "+e);
}
	finally
{
	  if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

