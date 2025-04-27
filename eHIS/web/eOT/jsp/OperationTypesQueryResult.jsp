<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<HTML>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
		<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<%
	try{
   
	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" ),"1") ;
    String to = checkForNull(request.getParameter( "to" ),"14" ) ;
    String sql = " ";
    String oper_type = checkForNull(request.getParameter("oper_type"));
	String long_desc = checkForNull(request.getParameter( "long_desc" ));
	String short_desc =checkForNull(request.getParameter( "short_desc" ));
	String enabled = checkForNull(request.getParameter( "status"));
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(oper_type == null || oper_type.equals("")) ){
	        sql = sql + " and upper(oper_type ) like upper('"+oper_type +"%')";
			cnt++;
        }

        if ( !(long_desc == null || long_desc.equals("")) ){
			sql = sql + " and UPPER(long_desc) like upper('"+long_desc+"%')";
			cnt=1;
        }
	   if ( !(short_desc == null || short_desc.equals("")) ){
			sql = sql + " and UPPER(short_desc) like upper('"+short_desc+"%')";
			cnt=1;
        }
	
	
	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){
			sql = sql+" and nvl(status,'E')='E' ";
			cnt=1;
         }

		 if ( enabled.equals("D") ){
		   sql = sql+" and status='D'";
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
        for ( int i=0;i < ord.length;i++ ){
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
	start = Integer.parseInt( from ) ;
	end = Integer.parseInt( to ) ;
    /*if ( from == null )
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
		
		String strsql="select count(*) as total from OT_OPER_TYPE_LANG_VW WHERE LANGUAGE_ID =? "+sql;
		String strsql1="Select oper_type, long_desc, short_desc, nvl(status,'E') status from OT_OPER_TYPE_LANG_VW Where LANGUAGE_ID = ? "+sql;
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,locale);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,locale);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<P>
<form name='QueryResult' id='QueryResult' >
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/OperationTypesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/OperationTypesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<th class="columnheadercenter" nowrap > <!-- changed by yadav -->
		<fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/>
	</th>
		
	<th class="columnheadercenter" nowrap > <!-- changed by yadav -->
			<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</th> 
	<th class="columnheadercenter" nowrap > <!-- changed by yadav -->
			<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>	
	</th>
	<th class="columnheadercenter" nowrap > <!-- changed by yadav -->
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
    oper_type = rset.getString(1);
    long_desc=rset.getString(2);
    short_desc= rset.getString(3);
	enabled= rset.getString(4);
	String mode="modify";
	out.println("<a href='../../eOT/jsp/OperationTypesAddModify.jsp?mode="+mode+"&oper_type="+ oper_type+"' target='f_query_add_mod' >");
	out.println(oper_type+"</a></td>");
	out.println("<td class='" + classValue+"'>"+long_desc+"</td>");
    out.println("<td class='" + classValue+"'>"+short_desc+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") || rset.getString("status").equals("null"))
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
}
%>

</center>
</form>
</BODY>
</HTML>

