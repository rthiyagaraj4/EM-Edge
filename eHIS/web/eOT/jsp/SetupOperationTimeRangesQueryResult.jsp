<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>

	<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
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
   
    String time_range_code = request.getParameter("time_range_code")==null?"":request.getParameter( "time_range_code" );
	String enabled = request.getParameter("status")==null?"":request.getParameter( "status");  

		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(time_range_code == null || time_range_code.equals("")) ){
	        sql = sql + " where time_range_code='"+time_range_code +"'";
			cnt++;
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
		
		String strsql="SELECT TIME_RANGE_CODE, TO_CHAR(TIME_1_SLOT,'HH24:MI') TIME_1_SLOT, TO_CHAR(TIME_2_SLOT,'HH24:MI') TIME_2_SLOT, TO_CHAR(TIME_3_SLOT,'HH24:MI') TIME_3_SLOT, TO_CHAR(TIME_4_SLOT,'HH24:MI') TIME_4_SLOT, TO_CHAR(TIME_5_SLOT,'HH24:MI') TIME_5_SLOT, TO_CHAR(TIME_6_SLOT,'HH24:MI') TIME_6_SLOT, TO_CHAR(TIME_7_SLOT,'HH24:MI') TIME_7_SLOT, TO_CHAR(TIME_8_SLOT,'HH24:MI') TIME_8_SLOT, TO_CHAR(TIME_9_SLOT,'HH24:MI') TIME_9_SLOT, TO_CHAR(TIME_10_SLOT,'HH24:MI') TIME_10_SLOT, NVL(STATUS,'E') STATUS FROM  OT_OPER_TIME_RANGE "+sql;
		String strsql1="SELECT TIME_RANGE_CODE, TO_CHAR(TIME_1_SLOT,'HH24:MI') TIME_1_SLOT, TO_CHAR(TIME_2_SLOT,'HH24:MI') TIME_2_SLOT, TO_CHAR(TIME_3_SLOT,'HH24:MI') TIME_3_SLOT, TO_CHAR(TIME_4_SLOT,'HH24:MI') TIME_4_SLOT, TO_CHAR(TIME_5_SLOT,'HH24:MI') TIME_5_SLOT, TO_CHAR(TIME_6_SLOT,'HH24:MI') TIME_6_SLOT, TO_CHAR(TIME_7_SLOT,'HH24:MI') TIME_7_SLOT, TO_CHAR(TIME_8_SLOT,'HH24:MI') TIME_8_SLOT, TO_CHAR(TIME_9_SLOT,'HH24:MI') TIME_9_SLOT, TO_CHAR(TIME_10_SLOT,'HH24:MI') TIME_10_SLOT, NVL(STATUS,'E') STATUS FROM  OT_OPER_TIME_RANGE "+sql;
		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		while(rs.next())
		{
		maxRecord++;
		}
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		out.println("sdfsadfs "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/SetupOperationTimeRangesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/SetupOperationTimeRangesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="ColumnHeader" nowrap><fmt:message key="eOT.TimeRangeCode.Label" bundle="${ot_labels}"/></th><!--20%-->
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 1</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 2</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 3</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 4</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 5</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 6</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 7</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 8</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 9</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="eOT.TimeSlot.Label" bundle="${ot_labels}"/> 10</th>
<th class="ColumnHeaderCenter" nowrap>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>


<%
	int oper_room_sequence=0;
	 //oper_room_sequence=Integer.parseInt(oper_room_seq);
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ;
                else
            classValue = "gridData" ;
    out.println("<tr><td align=='left' class='" + classValue + "' gridData>");
   
    
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/SetupOperationTimeRangesAddModify.jsp?mode="+mode+"&time_range_code="+rset.getString(1)+"' target='f_query_add_mod' >");
    out.println(rset.getString(1)+"</a></td>");
  
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(2)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(3)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(4)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(5)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(6)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(7)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(8)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(9)+"</td>");
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(10)+"</td>");	
   out.println("<td class='" + classValue+"' gridData>"+rset.getString(11)+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

//	out.println("<td class='" + classValue + "' align='center'>");
	
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
	out.println("here "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

