<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
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
	<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
	<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try
	{
    String querymode=request.getParameter("querymode");
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String checklist_code = request.getParameter("checklist_code")==null?"":request.getParameter( "checklist_code" );
	String description =request.getParameter("description")==null?"":request.getParameter( "description" );
	String enabled = request.getParameter("status")==null?"":request.getParameter( "status");
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(checklist_code == null || checklist_code.equals("")) ){
	        sql = sql + " where upper(checklist_code ) like upper('"+checklist_code +"%')";
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
				sql=sql+ "where  status='D'";
				cnt=1;
			}
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }
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
String strsql="";
String strsql1="";
	try{
		
		strsql="select count(*) as total from OT_CHECKLIST_HDR_LANG_VW "+sql;
		//String strsql1="select checklist_code,description,nvl(status,'E') status from  OT_CHECKLIST_HDR"+sql;
		strsql1="select checklist_code,description,nvl(status,'E') status from  OT_CHECKLIST_HDR_LANG_VW "+sql;
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("error in ChecklistsQueryResult.jsp "+e);
		//out.println("error in ChecklistsQueryResult.jsp query:"+strsql1);		
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/ChecklistsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ChecklistsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
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

    checklist_code = rset.getString(1);
    description=rset.getString(2);
    
	String mode="modify";
	out.println("<a href='../../eOT/jsp/ChecklistsFrameForCreate.jsp?update_mode_yn="+mode+"&checklist_code="+checklist_code+"' target='f_query_add_mod' >");
    out.println(checklist_code+"</a></td>");
  
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
<input type=hidden name=mode value='modify'>
<input type=hidden name=QueryMode value='<%=querymode%>'>
</form>

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
</BODY>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</HTML>

