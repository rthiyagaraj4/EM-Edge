<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HTML>
	<head>
	<link type='text/css' rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' />
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

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
    String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" );
	String description =request.getParameter("description")==null?"":request.getParameter( "description" );
	String enabled = request.getParameter("status")==null?"":request.getParameter( "status");

		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(item_code == null || item_code.equals("")) ){
	        sql = sql + " where upper(item_code ) like upper('"+item_code +"%')";
			cnt++;
        }

        if ( !(description == null || description.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(description) like upper('"+description+"%')";
			else{
				sql=sql+" where upper(description) like upper('"+description+"%')";
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
			   sql = sql+" and status='D'";
			else{
				sql=sql+ " where status='D'";
				cnt=1;
			}
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }
	if(cnt>0)
		sql = sql+" AND LANGUAGE_ID='"+locale+"' ";
	else
		sql=sql+ " where  LANGUAGE_ID='"+locale+"' ";

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
		
		/*String strsql="SELECT COUNT(*) AS TOTAL FROM OT_SWAB_INSTR_TMPL_ITEMS"+sql;
		String strsql1="SELECT ITEM_CODE, DESCRIPTION, nvl(STATUS,'E') status FROM OT_SWAB_INSTR_TMPL_ITEMS"+sql;*/

		String strsql="SELECT COUNT(*) AS TOTAL FROM OT_SWAB_INSTR_ITEMS_LANG_VW "+sql;
		String strsql1="SELECT ITEM_CODE, DESCRIPTION, nvl(STATUS,'E') status FROM OT_SWAB_INSTR_ITEMS_LANG_VW "+sql;
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
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/TemplateItemsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/TemplateItemsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
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
                    classValue = "gridData" ;  // changed by yadav
                else 
            classValue = "gridData" ;  // changed by yadav
    out.println("<tr><td align=='left' class='gridData'>"); // changed by yadav

    item_code = rset.getString(1);
    description=rset.getString(2);
    
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/TemplateItemsAddModify.jsp?mode="+mode+"&item_code="+ item_code+"' target='f_query_add_mod' >");
    out.println(item_code+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+description+"</td>");
     
   out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

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
</BODY>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</HTML>

