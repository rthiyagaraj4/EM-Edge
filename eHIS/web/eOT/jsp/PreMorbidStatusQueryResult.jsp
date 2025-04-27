<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%  String locale = (String)session.getAttribute("LOCALE"); %>
<%  request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/PreMorbidStatus.js'></script>
<HTML>
	<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";

    String premorbid_code = request.getParameter("premorbid_code")==null?"":request.getParameter( "premorbid_code" );
	String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" );
	String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" );
	
    String enabled = request.getParameter("status")==null?"":request.getParameter( "status");

		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(premorbid_code == null || premorbid_code.equals("")) ){
	        sql = sql + " where upper(premorbid_code) like upper('"+premorbid_code+"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like upper('"+long_desc+"%')";
			else{
				sql=sql+" where upper(long_desc) like upper('"+long_desc+"%')";
				cnt=1;
			}

        }
	   if ( !(short_desc == null || short_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(short_desc) like upper('"+short_desc+"%')";
			else{
				sql=sql+" where upper(short_desc) like upper('"+short_desc+"%')";
				cnt=1;
			}

        }
	
	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E' ";
			else{
				sql=sql+ " where nvl(status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and nvl(status,'E')='D'";
			else
				sql=sql+ "where  nvl(status,'E')='D'";
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
		
		String strsql="select count(*) as total from AT_PREMORBID_MAST "+sql;
		String strsql1="select premorbid_code,long_desc, short_desc, nvl(status,'E') status from  AT_PREMORBID_MAST "+sql;
		
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
		System.err.println("Err PreMorbidStatusQueryResult" +e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/PreMorbidStatusQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/PreMorbidStatusQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Next</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
<fmt:message key="eOT.PreMorbidCode.Label" bundle="${ot_labels}"/>
</th><!--20%-->
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
</th><!--30%-->
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
</th><!--30%-->

<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th> <!--20%-->

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

    premorbid_code = rset.getString(1);
    long_desc=rset.getString(2);
    short_desc= rset.getString(3);
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/PreMorbidStatusAddModify.jsp?mode="+mode+"&premorbid_code="+ premorbid_code+"' target='f_query_add_mod' >");
    out.println(premorbid_code+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+long_desc+"</td>");
   out.println("<td class='" + classValue+"'>"+short_desc+"</td>");
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
	System.err.println("Err PreMorbidStatusQueryResult:" +e);
}
%>

</center>
</form>
</BODY>
</HTML>

