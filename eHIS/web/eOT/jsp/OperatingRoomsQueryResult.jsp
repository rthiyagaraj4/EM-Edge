<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	try
	{
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String wd_start_time="";
	String wd_end_time="";
	String hd_start_time="";
	String hd_end_time="";
    String theatre_type = request.getParameter("theatre_type")==null?"":request.getParameter( "theatre_type" );
	String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );
	
	String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" );
	String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" );
	
	String oper_room_seq = request.getParameter("oper_room_seq")==null?"":request.getParameter( "oper_room_seq" );
	
	String restrict_by_splty_yn = request.getParameter("restrict_by_splty_yn")==null?"":request.getParameter( "restrict_by_splty_yn" );
	String over_booking_allowed_yn = request.getParameter("over_booking_allowed_yn")==null?"":request.getParameter( "over_booking_allowed_yn" );

	String service_code = request.getParameter("service_code")==null?"":request.getParameter( "service_code" );
    if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(theatre_type == null || theatre_type.equals("")) ){
	        sql = sql + " and theatre_type='"+theatre_type +"'";
        }

        if ( !(oper_room_code == null || oper_room_code.equals("")) ){
			sql = sql + " and upper(OPER_ROOM_CODE)  like upper('"+oper_room_code+"%')";
		}
	   if ( !(long_desc == null || long_desc.equals("")) ){
			sql = sql + " and upper(long_desc) like upper('"+long_desc+"%')";
        }
		if ( !(short_desc == null || short_desc.equals("")) ){
			sql = sql + " and upper(short_desc) like upper('"+short_desc+"%')";
        }
		if ( !(oper_room_seq == null || oper_room_seq.equals("")) ){
			sql = sql + " and to_char(oper_room_seq) = '"+oper_room_seq+"'";
        }
		if ( !(service_code == null || service_code.equals("")) ){
			sql = sql + " and service_code = '"+service_code+"'";
        }
		if ( !(restrict_by_splty_yn == null || restrict_by_splty_yn.equals("")) ){
			if( restrict_by_splty_yn.equals("Y") ){
			   sql = sql+" and nvl(restrict_by_splty_yn,'N')='Y' ";
			}
			if ( restrict_by_splty_yn.equals("N") ){
			   sql = sql+" and nvl(restrict_by_splty_yn,'N')='N'";
			}

			if ( restrict_by_splty_yn.equals("B") ){
			//               sql = sql; //nothing is added to get both E and D
			}
		}

		if ( !(over_booking_allowed_yn == null || over_booking_allowed_yn.equals("")) ){
			if( over_booking_allowed_yn.equals("Y") ){
			   sql = sql+" and nvl(over_booking_allowed_yn,'N')='Y' ";
			}
			if ( over_booking_allowed_yn.equals("N") ){
			   sql = sql+" and nvl(over_booking_allowed_yn,'N')='N'";
			}

			if ( over_booking_allowed_yn.equals("B") ){
			//               sql = sql; //nothing is added to get both E and D
			}
		}
	//appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" ORDER BY ";
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
String strsql1="";
String facility_id = (String) session.getValue("facility_id");
	try{
		
		//String strsql="select count(*) as total from OT_OPER_ROOM "+sql;
		//String strsql1="select oper_room_code,long_desc, short_desc,theatre_type, wd_start_time,wd_end_time,hd_start_time,hd_end_time,nvl(restrict_by_splty_yn,'N'), oper_room_seq,service_code from  OT_OPER_ROOM "+sql;

		String strsql="SELECT COUNT(*) AS TOTAL FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID=? AND LANGUAGE_ID=? "+sql;

		strsql1="SELECT OPER_ROOM_CODE,LONG_DESC,SHORT_DESC,THEATRE_TYPE,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI'),NVL(RESTRICT_BY_SPLTY_YN,'N'), NVL(OVER_BOOKING_ALLOWED_YN,'N') OVER_BOOKING_ALLOWED_YN, OPER_ROOM_SEQ,SERVICE_CODE FROM  OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID=? AND LANGUAGE_ID=? "+sql;
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,facility_id);
		stmt.setString(2,locale);

		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,facility_id);
		stmt1.setString(2,locale);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println("sdfsadfs "+e);
		//out.println("sql==="+strsql1);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/OperatingRoomsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/OperatingRoomsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
</th>
<!-- <td class='columnheadercenter' nowrap> 
	<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/>
</td> -->
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.TheatreSequenceNo.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.RestrictBySpecialityYN.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.OverBookingAllowedYN.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.service.label" bundle="${common_labels}"/>
</th>
<!-- <td class='columnheadercenter' nowrap> 
	<fmt:message key="eOT.WorkingDayStartTime.Label" bundle="${ot_labels}"/>
</td>
<td class='columnheadercenter' nowrap>
	<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
</td>
<td class='columnheadercenter' nowrap>
	<fmt:message key="eOT.HolidayStartTime.Label" bundle="${ot_labels}"/>
</td>
<td class='columnheadercenter' nowrap> 
	<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
</td> -->


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
                     classValue = "gridData" ; // changed by yadav
                else
             classValue = "gridData" ; // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");
   oper_room_code=rset.getString(1);
   long_desc=rset.getString(2);
   short_desc=rset.getString(3);
   theatre_type=rset.getString(4);
   wd_start_time=rset.getString(5);
   wd_end_time=rset.getString(6);
   hd_start_time=rset.getString(7);
   hd_end_time=rset.getString(8);
   restrict_by_splty_yn=rset.getString(9);
   over_booking_allowed_yn=rset.getString(10);
   oper_room_sequence=rset.getInt(11);
   service_code=rset.getString(12);

	String mode="modify";
	out.println("<a href='../../eOT/jsp/OperatingRoomsAddModify.jsp?mode="+mode+"&oper_room_code="+oper_room_code+"' target='f_query_add_mod' >");
    out.println(oper_room_code+"</a></td>");
  
//   out.println("<td class='" + classValue+"' nowrap>"+theatre_type+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+short_desc+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+oper_room_sequence+"</td>");
   out.println("<td class='" + classValue + "' nowrap>");
    if ( restrict_by_splty_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
   out.println("<td class='" + classValue + "' align='center'>");
    if ( over_booking_allowed_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");	
   out.println("<td class='" + classValue+"' nowrap>"+service_code+"</td>");
/*   out.println("<td class='" + classValue+"' nowrap>"+wd_start_time+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+wd_end_time+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+hd_start_time+"</td>");
   out.println("<td class='" + classValue+"' nowrap>"+hd_end_time+"</td>");
   */
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
}catch(Exception e){
	e.printStackTrace();
	//out.println("Exception in OperRoomQryResult.jsp  "+e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

