<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,java.util.ArrayList,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String list_id = request.getParameter("list_id")==null?"":request.getParameter( "list_id" );
	String description =request.getParameter("description")==null?"":request.getParameter( "description" );
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(list_id == null || list_id.equals("")) ){
	        sql = sql + " where upper(list_id ) like upper('"+list_id +"%')";
			cnt++;
        }

        if ( !(description == null || description.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(list_desc) like upper('"+description+"%')";
			else{
				sql=sql+" where upper(list_desc) like upper('"+description+"%')";
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
		
		String strsql="select count(*) as total from OT_CHECKLIST_LISTVALS_HDR "+sql;
//        String strsql1="SELECT LIST_ID, LIST_DESC  FROM OT_CHECKLIST_LISTVALS_HDR "+sql;
        String strsql1="SELECT LIST_ID, GET_DESC('"+locale+"','OT_CHKLIST_LISTVAL_HDR_LANG_VW','LIST_DESC','LIST_ID',LIST_ID) LIST_DESC FROM OT_CHECKLIST_LISTVALS_HDR "+sql;		

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
    out.println("<A HREF='../../eOT/jsp/ListItemsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/ListItemsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Next</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
<fmt:message key="Common.List.label" bundle="${common_labels}"/></th>
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

    list_id = rset.getString(1);
    description=rset.getString(2);
	description=description==null?"":description;
	description=description.equals("null")?"":description;
    
	String mode="modify";
	out.println("<a href='../../eOT/jsp/ListItemsFrameForCreate.jsp?update_mode_yn="+mode+"&list_id="+list_id+"' target='f_query_add_mod' >");
    out.println(list_id+"</a></td>");
    out.println("<td class='" + classValue+"'>"+description+"</td>");
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
	//out.println("here "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

