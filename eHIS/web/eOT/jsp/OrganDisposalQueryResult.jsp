<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<HTML>
	<head>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<link type='text/css' rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--OnMouseDown='CodeArrest()' onKeyDown="lockKey()"-->
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String disposal_code = request.getParameter("disposal_code")==null?"":request.getParameter( "disposal_code" );
	String disposal_desc =request.getParameter("disposal_desc")==null?"":request.getParameter( "disposal_desc" );
	String enabled = request.getParameter("status")==null?"":request.getParameter( "status");
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(disposal_code == null || disposal_code.equals("")) ){
	        sql = sql + " where upper(disposal_code ) like upper('"+disposal_code +"%')";
			cnt++;
        }

        if ( !(disposal_desc == null || disposal_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(disposal_desc) like upper('"+disposal_desc+"%')";
			else{
				sql=sql+" where upper(disposal_desc) like upper('"+disposal_desc+"%')";
				cnt=1;
			}

        }
	   
	
		if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E' ";//(status='E' or status is null)
			else{
				sql=sql+ " where nvl(status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and status='D'";
			else
				sql=sql+ " where  status='D'";
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
		
		String strsql="select count(*) as total from OT_ORGAN_DISPOSAL "+sql;
		String strsql1="select disposal_code,GET_DESC('"+locale+"','OT_ORGAN_DISPOSAL_LANG_VW','DISPOSAL_DESC','DISPOSAL_CODE',DISPOSAL_CODE) disposal_desc, nvl(status,'E') status from  OT_ORGAN_DISPOSAL "+sql;
		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
	<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/OrganDisposalQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/OrganDisposalQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.DisposalCode.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
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
    out.println("<tr><td class='" + classValue + "'>");

    disposal_code = rset.getString(1);
    disposal_desc=rset.getString(2);
    
	String mode="modify";
	out.println("<a href='../../eOT/jsp/OrganDisposalAddModify.jsp?mode="+mode+"&disposal_code="+disposal_code+"' target='f_query_add_mod' >");

    out.println(disposal_code+"</a></td>");  
    out.println("<td class='" + classValue+"'>"+disposal_desc+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") )
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
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

</center>
<form>
</BODY>
</HTML>

