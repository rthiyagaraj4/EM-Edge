<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType=" text/html;charset=UTF-8" %>
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

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
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
    String recovery_room_code = request.getParameter("recovery_room_code")==null?"":request.getParameter( "recovery_room_code" );
	String recovery_room_desc =request.getParameter("recovery_room_desc")==null?"":request.getParameter( "recovery_room_desc" );
	String facility_id=(String) session.getAttribute("facility_id");
    String enabled = request.getParameter("status")==null?"":request.getParameter( "status");
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(recovery_room_code == null || recovery_room_code.equals("")) ){
	        sql = sql + " and upper(recovery_room_code ) like upper('"+recovery_room_code +"%')";
			cnt++;
        }

        if ( !(recovery_room_desc == null || recovery_room_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(recovery_room_desc) like upper('"+recovery_room_desc+"%')";
			else{
				sql=sql+" and upper(recovery_room_desc) like upper('"+recovery_room_desc+"%')";
				cnt=1;
			}

        }
	   
		
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			   sql = sql+" and nvl(status,'E')='E' ";
			else{
				sql=sql+ " and nvl(status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			   sql = sql+" and status='D'";
			else
				sql=sql+ "and  status='D'";
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
		
		//String strsql="SELECT HOLDING_AREA_CODE, HOLDING_AREA_DESC, NVL(STATUS,'E') status FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID=? "+sql;
		//String strsql1="SELECT HOLDING_AREA_CODE, HOLDING_AREA_DESC, NVL(STATUS,'E') status FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID=? "+sql;


		String strsql="SELECT RECOVERY_ROOM_CODE,RECOVERY_ROOM_DESC, NVL(STATUS,'E') status FROM OT_RECOVERY_ROOM_LANG_VW WHERE LANGUAGE_ID ='"+locale+"' AND OPERATING_FACILITY_ID=? "+sql;
		String strsql1="SELECT RECOVERY_ROOM_CODE,RECOVERY_ROOM_DESC, NVL(STATUS,'E') status FROM OT_RECOVERY_ROOM_LANG_VW WHERE LANGUAGE_ID ='"+locale+"' AND OPERATING_FACILITY_ID=? "+sql;


		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,facility_id);
		rs = stmt.executeQuery();
        int total=0;
		while(rs.next())
		{
			total++;
		}
		maxRecord = total;
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,facility_id);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Exception in RecoveryRoomQryResult.jsp 152 --> "+e);
	}
%>
	<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/RecoveryRoomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/RecoveryRoomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
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
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    recovery_room_code = rset.getString(1);
    recovery_room_desc=rset.getString(2);
    
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/RecoveryRoomAddModify.jsp?mode="+mode+"&recovery_room_code="+ recovery_room_code+"' target='f_query_add_mod' >");
    out.println(recovery_room_code+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+recovery_room_desc+"</td>");
     
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
	//out.println("Exception in RecRoomQryRslt.jsp line 233 --->  "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

