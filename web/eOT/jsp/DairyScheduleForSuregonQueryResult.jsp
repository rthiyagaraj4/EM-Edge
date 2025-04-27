<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>


<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%String restrict_by_splty_yn=request.getParameter("restrict_by_splty_yn");
	try
	{
    String function_id=request.getParameter("function_id");
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
	String facility_id=(String) session.getAttribute("facility_id");
    String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );
	String description=request.getParameter("description")==null?"":request.getParameter( "description" );
	String oper_room_code1 = request.getParameter("oper_room_code1")==null?"":request.getParameter( "oper_room_code1");
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(oper_room_code == null || oper_room_code.equals("")) ){
	        sql = sql + " and upper(oper_room_code) like upper('"+oper_room_code+"%')" ;
			cnt++;
        }
	 if ( !(description == null || description.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(short_desc) like upper('"+description+"%')";
			else{
				sql=sql+" and upper(short_desc) like upper('"+description+"%')";
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
		
//String strsql="SELECT  OPER_ROOM_CODE,SHORT_DESC, TO_CHAR(WD_START_TIME,'HH24:MI'), TO_CHAR(WD_END_TIME,'HH24:MI'), TO_CHAR(HD_START_TIME,'HH24:MI'), TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM WHERE NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' "+sql;
//String strsql1="SELECT  OPER_ROOM_CODE,SHORT_DESC, TO_CHAR(WD_START_TIME,'HH24:MI'), TO_CHAR(WD_END_TIME,'HH24:MI'), TO_CHAR(HD_START_TIME,'HH24:MI'), TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM WHERE NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' "+sql;

		// Commented by Dilip on 05/11/2007
		//String strsql="SELECT  OPER_ROOM_CODE,SHORT_DESC, TO_CHAR(WD_START_TIME,'HH24:MI'), TO_CHAR(WD_END_TIME,'HH24:MI'), TO_CHAR(HD_START_TIME,'HH24:MI'), TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = ? AND LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' "+sql;

		String strsql="SELECT  OPER_ROOM_CODE,SHORT_DESC, TO_CHAR(WD_START_TIME,'HH24:MI'), TO_CHAR(WD_END_TIME,'HH24:MI'), TO_CHAR(HD_START_TIME,'HH24:MI'), TO_CHAR(HD_END_TIME,'HH24:MI'), OPER_ROOM_CODE||'@@'||RESTRICT_BY_SPLTY_YN FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = ? AND LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' "+sql;

		//String strsql1="SELECT  OPER_ROOM_CODE,SHORT_DESC, TO_CHAR(WD_START_TIME,'HH24:MI'), TO_CHAR(WD_END_TIME,'HH24:MI'), TO_CHAR(HD_START_TIME,'HH24:MI'), TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = ? AND LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' "+sql;

		String strsql1="SELECT  OPER_ROOM_CODE,SHORT_DESC, TO_CHAR(WD_START_TIME,'HH24:MI'), TO_CHAR(WD_END_TIME,'HH24:MI'), TO_CHAR(HD_START_TIME,'HH24:MI'), TO_CHAR(HD_END_TIME,'HH24:MI'),OPER_ROOM_CODE||'@@'||RESTRICT_BY_SPLTY_YN FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = ? AND LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' "+sql;

		//out.println("strsql==="+strsql);
		//out.println("strsql1==="+strsql1);
		stmt = conn.prepareStatement(strsql);
        stmt.setString(1,facility_id);
		rs = stmt.executeQuery();
		while(rs.next())
		maxRecord++;
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		

		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,facility_id);
		rset = stmt1.executeQuery();
		
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Caught Exception in DairyScheduleForSuregonQueryResult.jsp "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/DairyScheduleForSuregonQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/DairyScheduleForSuregonQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'  align='center'><tr>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
<fmt:message key="Common.code.label" bundle="${common_labels}"/></th><!--20%-->
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
<fmt:message key="Common.description.label" bundle="${common_labels}"/></th><!--30%-->
</tr>

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

    oper_room_code = rset.getString(7);
    oper_room_code1= rset.getString(1);
    description=rset.getString(2);
	%>
	<%
	String mode="modify";
	out.println("<a href='../../eOT/jsp/DairyScheduleForSuregonForCreate.jsp?update_mode_yn="+mode+"&oper_room_code="+oper_room_code+"&wd_start_time="+rset.getString(3)+"&wd_end_time="+rset.getString(4)+"&hd_start_time="+rset.getString(5)+"&hd_end_time="+rset.getString(6)+"&function_id="+function_id+"' target='f_query_add_mod' >");
	out.println(oper_room_code1+"</a></td>");
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
	//System.err.println("Error Mesg From DairyScheduleForSurgeonQryResult.jsp : "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='restrict_by_splty_yn' id='restrict_by_splty_yn' value="<%=restrict_by_splty_yn%>">

</form>
</BODY>
</HTML>

