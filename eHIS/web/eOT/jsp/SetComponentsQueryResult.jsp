<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";

    String instr_code = request.getParameter("instr_code")==null?"":request.getParameter( "instr_code" );
	String description =request.getParameter("description")==null?"":request.getParameter( "description" );
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(instr_code == null || instr_code.equals("")) ){
	        sql = sql + " where upper(instr_code ) like upper('"+instr_code +"%')";
			cnt++;
        }

        if ( !(description == null || description.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like upper('"+description+"%')";
			else{
				sql=sql+" where upper(long_desc) like upper('"+description+"%')";
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
		
		String strsql="select count(*) as total from OT_INSTRUMENT "+sql;
     // Code altered by rajesh fro PHASE 3.
	 //   String strsql1="SELECT INSTR_CODE , SHORT_DESC FROM OT_INSTRUMENT "+sql;
	 String strsql1="SELECT INSTR_CODE , LONG_DESC FROM OT_INSTRUMENT "+sql;
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
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/SetComponentsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/SetComponentsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table  class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
		<fmt:message key="Common.code.label" bundle="${common_labels}"/></th><!--20%-->
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
		<fmt:message key="Common.description.label" bundle="${common_labels}"/></th><!--30%-->


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

    instr_code = rset.getString(1);
    description=rset.getString(2);
    
	String mode="modify";
	out.println("<a href='../../eOT/jsp/SetComponentsFrameForCreate.jsp?update_mode_yn="+mode+"&instr_code="+instr_code+"' target='f_query_add_mod' >");
    out.println(instr_code+"</a></td>");
  
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
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

