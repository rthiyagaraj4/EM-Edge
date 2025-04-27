<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
Connection conn = null;
Statement stmt=null;
PreparedStatement pstmt=null;
ResultSet  rs=null;

try
{
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//String day=request.getParameter("clinic_day1");
String appt_date=request.getParameter("Date");

String day_show="";
		String locale = (String)session.getAttribute("LOCALE");

//String sql ="select to_char(to_date('"+appt_date+"','dd/mm/yyyy'),'Day')appt_date from dual";
String sql ="select to_char(to_date(?,'dd/mm/yyyy'),'Day')appt_date from dual";
	    rs=stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,appt_date);
		rs = pstmt.executeQuery();
		rs.next();

String day_val= rs.getString("appt_date");
day_val=day_val.trim();
		if(day_val.equals("Sunday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day_val.equals("Monday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day_val.equals("Tuesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day_val.equals("Wednesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day_val.equals("Thursday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day_val.equals("Friday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day_val.equals("Saturday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}
		String apptdate_display=DateUtils.convertDate(appt_date,"DMY","en",locale);
%>
<html>

<title><fmt:message key="eOA.ListofAppointmentsfor.label" bundle="${oa_labels}"/> <%=apptdate_display%> (<%=day_show%>) </title>
    <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <title></title>
    </head>
    
    <iframe src='../../eOA/jsp/DisplayResults.jsp?<%=request.getQueryString()%>' frameborder=0  marginheight=0 marginwidth=0  name='header' SCROLLING='auto' style='height:93vh;width:100vw'></iframe>
         <iframe src='../../eOA/jsp/BrownCheckBoxDisplay.jsp?<%=request.getQueryString()%>' frameborder=0  marginheight=0 marginwidth=0  name='header' SCROLLING='no' style='height:7vh;width:100vw'></iframe>
    
<html>
<%
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}catch(Exception e){
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>

