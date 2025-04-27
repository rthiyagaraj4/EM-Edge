<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
 <jsp:useBean id="beanCalendarObj" scope="page" class="eOR.OrderEntryCalendarBean"/>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
 	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
 	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="calendarForm" id="calendarForm" >
	<%      request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	beanCalendarObj.setLanguageId(localeName);


		int row						= 0;
		int rodup					= 1;
		int cols					= 7;
		int act						= 0;
		int total					= 0;
		int month_count				= 0;
		int active_bookings			= 0;
		String month_year_name		= "";
		String month				= "",  year					= "";
		String day					= "",  anchor				= "";
		String color_class			= "",  year_month 			= "";
		String calendar_string		= "",  color_string			= "";
		String current_date			= "",  booking_day			= "0";
		String default_booking		= "";
		String status				= request.getParameter("status");
		String state				= "current";
		if(request.getParameter("total")!=null)
			total					= Integer.parseInt(request.getParameter("total"));
		String patient_id					= request.getParameter("patient_id");
		String cliniccode			= request.getParameter("Clinic_Code");
		if( cliniccode == null ) cliniccode="";
		String performing_facility_id= request.getParameter("performing_facility_id");
		if( performing_facility_id == null ) performing_facility_id="";
		String practitioner_id		= request.getParameter("practitioner_id");
		if( practitioner_id == null ) practitioner_id="";
		if(status!=null && status.equals("NE"))
			state					= "next";
		else if(status!=null && status.equals("PR"))
			state					= "previous";
		if(0 >= total)
			state					= "current";
		StringTokenizer split_days	= null;
		StringTokenizer ColorVals	= null;
		String[] NumOfDays			= null;
		String colors[]				= null;
		String week[]				= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		String Color_Code[]			= {"S","Y","G","R","B"};
		String Color_Val[]			= {"","OAYellow","OAGreen","OARed","OABrown"};
		String months[]				= {"January&nbsp&nbsp&nbsp&nbsp&nbsp","February&nbsp&nbsp&nbsp","March&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","April&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","May&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","June&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","July&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","August&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","September","October&nbsp&nbsp&nbsp&nbsp&nbsp","November&nbsp","December&nbsp"};

String ID="";
 			if(cliniccode==null)
				cliniccode		= ID;

			current_date		= beanCalendarObj.getSysDate();
			if(current_date!=null && !current_date.equals(""))
				current_date	= current_date.substring(0,2);
			else current_date	= "0";
			year_month			= beanCalendarObj.getYearMonth(state,total);
			calendar_string		= (String)beanCalendarObj.getCalendarString(year_month);
			color_string		= beanCalendarObj.getCalendarStatusColor(performing_facility_id, practitioner_id, year_month);
			if( color_string == null) color_string = "";
			year				= year_month.substring(0,4);
			month_count			= Integer.parseInt(year_month.substring(4,year_month.length()));
			month				= months[month_count-1];
			split_days			= new StringTokenizer(calendar_string,"|");
			NumOfDays			= new String[split_days.countTokens()];
			ColorVals			= new StringTokenizer(color_string,"|");
			colors				= new String[ColorVals.countTokens()];

			//active_bookings		= beanCalendarObj.getActiveBookings(patient_id); // will return an Integer

			for(int i=0;i<NumOfDays.length;i++)
				NumOfDays[i]	= split_days.nextToken();

			for(int i=0;i<colors.length;i++)
			{
				colors[i]		= ColorVals.nextToken();
			}

			row					= NumOfDays.length/7;
			month_year_name		= month+","+year;
	%>
	<table border=0 cellspacing=0 cellpadding=3 width=20% align='center'>
	<br>
	<tr>
		<td class="white" >&nbsp;</td>
	</tr>
	<tr>
		<td  class="white" width="10%" ></td>
		<td class="white" >
			<table cellspacing=0 cellpadding=3  width="25%"  style="mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt">
				<tr>
				    <td ><input type="button" class="button" value="<--" name="prev" id="prev"  onClick=moveDirection(this,<%=total%>,"<%=patient_id%>","<%=performing_facility_id%>","<%=practitioner_id%>")></td>
					<td  class="COMMON_TOOLBAR" width="10%"><b><i><%=month_year_name%></i></b></td>
					<td  ><input type="button" class="button" value="-->" name="next" onClick=moveDirection(this,<%=total%>,"<%=patient_id%>","<%=performing_facility_id%>","<%=practitioner_id%>")></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td  class="white" width="5%"></td>
		<td  class="white">
			<table width="20%"  cellpadding=3 align="center" style="mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt">
			<tr>
<%				for( int j=0;j<week.length;j++){	%>
					<th width="3%" align="center"><font size=1><%=week[j]%></th>
<%				} %>
			</tr>
<%			for( int j=0;j<row;j++)
			{
%>
			 <tr>
<%
				for(int k=0;k<cols;k++)
				{
					if(act<NumOfDays.length)
				  	{
				  		if(!NumOfDays[act].equals("0"))
				  		{
				  			day	=	NumOfDays[act];
			  				for(int i=0;i<Color_Code.length;i++)
			  				{
			  					if(Color_Code[i].equals(colors[act]))
			  						color_class = Color_Val[i];
			  				}
							booking_day = day;
			  			} // End of if !NumOfDays[act].equals("0")
			  			else
			  			{
			  				if(rodup==(NumOfDays.length/7) && NumOfDays[act].equals("0"))
			  				{
			  					day = "&nbsp"; booking_day = "0";
			  					break;
			  				}
			  				else
							{
								day = "&nbsp"; booking_day = "0";
							}
				  		} // End of else !NumOfDays[act].equals("0")
				  	}
					else
					{
						day			= "&nbsp";
						booking_day = "0";
					}
		  			act++;
					anchor = " ";
//String DispBk	= "Y";
		  			if(!(color_class==null || color_class.equals("") ) )
					{
						if( default_booking.equals("") && Integer.parseInt(booking_day) >= Integer.parseInt(current_date))
							default_booking = day;
						//active_bookings		= beanCalendarObj.getActiveBookings(performing_facility_id,practitioner_id,(day + "/" + month_count + "/" + year),patient_id); // will return an Integer
						active_bookings		= beanCalendarObj.getActiveBookings(performing_facility_id,practitioner_id,(day + "/" + month_count + "/" + year)); // will return an Integer
                        anchor =" <a class='gridLink' href=javascript:populateDate('"+month_count+"','"+year+"','"+day+"','"+patient_id+"','"+active_bookings+"') >";
					}
			  			//anchor =" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+month_count+"','"+year+"','"+day+"','"+DispBk+"')>";
%>
					<td class = "<%=color_class%>"  width="3%"><font size=1><%=anchor%><%=day%></a></font></td>
<%
				  		color_class = "";
				  	} // End of for k --> cols
%>
				  </tr>
<%				rodup++;
			} // End of for j --> row
%>
		</tr>
		</table>
	</td>
	</tr>
</table>
<br>
	<table border="0" width="100%" >
		<tr>
			<td width="7%" align="left" class="OAGREENSMALL">&nbsp;</td>
			<td width="88%" align="left" class="OALABELSMALLWHITE">&nbsp;<fmt:message key="Common.available.label" bundle="${common_labels}"/>&nbsp;</td>
		</tr>
		<tr>
			<td class="white" colspan="2"></td>
		</tr>
		<tr>
			<td class="white" colspan="2"></td>
		</tr>
		<tr>
			<td align="left" class="OAREDSMALL">&nbsp;</td>
			<td width="10%"  class="OALABELSMALLWHITE"><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td class="white" colspan="2"></td>
		</tr>
		<tr>
			<td class="white" colspan="2"></td>
		</tr>
		<tr>
			<td align="left" class="OALABELSMALL">&nbsp;</td>
			<td width="10%"  class="OALABELSMALLWHITE"><fmt:message key="Common.notavailable.label" bundle="${common_labels}"/></td>
		</tr>
	</table>
	<Input name='month_count' id='month_count' type='hidden' value='<%=month_count%>'>
	<Input name='year' id='year' type='hidden' value='<%=year%>'>
	<Input name='default_booking' id='default_booking' type='hidden' value='<%=default_booking%>'>
	<Input name='patient_id' id='patient_id' type='hidden' value='<%=patient_id%>'>
	<Input name='active_bookings' id='active_bookings' type='hidden' value='<%=active_bookings%>'>
	<Input name='qry_string' id='qry_string' type='hidden' value='<%=request.getQueryString()%>'>

	<script>
		loadDefaultDate("<%=month_count%>","<%=year%>","<%=default_booking%>","<%=patient_id%>","<%=active_bookings%>","<%=request.getQueryString()%>")
	</script>
	</form>
</body>
</html>

