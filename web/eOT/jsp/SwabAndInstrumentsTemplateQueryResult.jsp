<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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
    String template_id = request.getParameter("template_id")==null?"":request.getParameter( "template_id" );
	String description =request.getParameter("description")==null?"":request.getParameter( "description" );
	String enabled =request.getParameter("enabled")==null?"":request.getParameter( "enabled" );
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(template_id == null || template_id.equals("")) ){
	        sql = sql + " and upper(template_id ) like upper('"+template_id +"%')";
			cnt++;
        }

        if ( !(description == null || description.equals("")) ){
			sql = sql + " and upper(description) like upper('"+description+"%')";
			cnt=1;
        }

		if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){
		    sql = sql+" and nvl(status,'E')='E' ";
			cnt=1;
         }

		 if ( enabled.equals("D") ){
		   sql = sql+" and status='D'";
			cnt=1;
         }

         if ( enabled.equals("B") ){
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
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
			int maxRecord = 0;
			ResultSet rset=null;
			ResultSet rs = null;
			Connection conn  =  ConnectionManager.getConnection(request);
			String strsql1="SELECT TEMPLATE_ID, DESCRIPTION, nvl(STATUS,'E') STATUS FROM OT_SWAB_INSTR_TMPL_HDR_LANG_VW WHERE LANGUAGE_ID=? "+sql;
			stmt1=conn.prepareStatement(strsql1);
			stmt1.setString(1,locale);
			rset = stmt1.executeQuery();
		
			// Modified by DhanasekarV against issue IN:028398  on 17/08/2011

			stmt=conn.prepareStatement(strsql1);
			stmt.setString(1,locale);
			rs =stmt.executeQuery();	

		int total=0;
		while(rs.next())
		{
			total++;
		}

		maxRecord = total;
	
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}

		// Modified by DhanasekarV against issue IN:028398  on 17/08/2011
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/SwabAndInstrumentsTemplateQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/SwabAndInstrumentsTemplateQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
	<fmt:message key="Common.TemplateID.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
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
                    classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
   %><tr><td align=='left' class='<%=classValue %>'><%

    template_id = rset.getString(1);
    description=rset.getString(2);
	String mode="modify";
	out.println("<a href='../../eOT/jsp/SwabAndInstrumentsTemplateFrameForCreate.jsp?update_mode_yn="+mode+"&template_id="+template_id+"&status="+rset.getString(3)+"' target='f_query_add_mod' >");
    out.println(template_id+"</a></td>");
  
   %><td class='<%=classValue%>'><%=description%></td>
  <td class='<%=classValue %>' align='center'><%
    if ( rset.getString("STATUS").equals("E") )
        %><img src='../../eCommon/images/enabled.gif'></img><%
    else
%><img src='../../eCommon/images/RRnwd.gif'></img>
</td><%

	i++;
} 
if(i==1)
			{
%><script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script><%
}
%>

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
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

