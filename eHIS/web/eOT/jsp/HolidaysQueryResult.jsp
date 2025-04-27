<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

                             
<HTML>
	<head>
	
	<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	
   
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String facility_id=(String) session.getAttribute("facility_id");
    String holiday_date= request.getParameter("holiday_date")==null?"":request.getParameter( "holiday_date" );
	int week_day =Integer.parseInt(request.getParameter("week_day")==null?"0":request.getParameter( "week_day" ));
	String reason_for_holiday = request.getParameter("reason_for_holiday")==null?"":request.getParameter( "reason_for_holiday");
	
//Modified by DhanasekarV against INO25643  on 23/12/2010


	String weekDays[]=new String[8];
	String sunday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
	String monday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
	String tuesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
	String wednesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
	String  thursday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
	String  friday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
	String  saturday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");

	weekDays[0]="";
	weekDays[1]=sunday;
	weekDays[2]=monday;
	weekDays[3]=tuesday;
	weekDays[4]=wednesday;
	weekDays[5]= thursday;
	weekDays[6]=friday;
	weekDays[7]=saturday;


//end


		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(holiday_date == null || holiday_date.equals("")) ){
			//Modified by DhanasekarV against INO25643  on 23/12/2010
			 holiday_date = com.ehis.util.DateUtils.convertDate(holiday_date,"DMY",locale,"en");
	        sql = sql + " and to_char(holiday_date,'dd/MM/yyyy') like '"+holiday_date +"'";
			cnt++;
        }

        if (week_day > 0){
			if(cnt>0)
			//	sql = sql + " and to_char(holiday_date,'D') like upper('"+week_day+"%')";
			sql = sql + " and to_char(holiday_date,'D') = '"+week_day+"'";
			else{
			//	sql=sql+" and to_char(holiday_date,'D') like upper('"+week_day+"%')";
			sql=sql+" and to_char(holiday_date,'D') ='"+week_day+"'";
				cnt=1;
			}

        }

		if ( !(reason_for_holiday == null || reason_for_holiday.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(reason_for_holiday) like upper('"+reason_for_holiday+"%')";
			else{
				sql=sql+" and upper(reason_for_holiday) like upper('"+reason_for_holiday+"%')";
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
String strsql="";
	try{
		
		strsql="SELECT to_char(HOLIDAY_DATE,'dd/MM/yyyy'), TO_CHAR(HOLIDAY_DATE,'D') WEEK_DAY, upper(REASON_FOR_HOLIDAY) REASON_FOR_HOLIDAY FROM OT_HOLIDAY WHERE OPERATING_FACILITY_ID = '"+facility_id+"'" +sql;


		String strsql1="SELECT to_char(HOLIDAY_DATE,'dd/MM/yyyy'), TO_CHAR(HOLIDAY_DATE,'D') WEEK_DAY, REASON_FOR_HOLIDAY FROM OT_HOLIDAY WHERE OPERATING_FACILITY_ID = '"+facility_id+"'" +sql;

		
		stmt = conn.prepareStatement(strsql);
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
		rset = stmt1.executeQuery();
				
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Error in HolidaysQueryResult: "+e);
		//out.println("Error in HolidaysQueryResult: strsql==="+strsql);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/HolidaysQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/HolidaysQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter'> <!-- changed by yadav -->
<fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/></td>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.day.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.ReasonForHoliday.label"bundle="${common_labels}"/>
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

    holiday_date = rset.getString(1);
	holiday_date=com.ehis.util.DateUtils.convertDate(holiday_date,"DMY","en",locale);
	week_day=Integer.parseInt(rset.getString(2));
	reason_for_holiday=rset.getString(3);
	
    
	
	String mode="modify";
	out.println("<a href='../../eOT/jsp/HolidaysAddModify.jsp?mode="+mode+"&holiday_date="+ holiday_date+"' target='f_query_add_mod' >");
    out.println(holiday_date+"</a></td>");
  
   out.println("<td class='" + classValue+"'>"+weekDays[week_day]+"</td>");
   out.println("<td class='" + classValue+"'>"+reason_for_holiday+"</td>");
  
   
	
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
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

