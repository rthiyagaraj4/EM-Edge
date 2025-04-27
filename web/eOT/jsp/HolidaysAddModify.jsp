<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
<script language="Javascript" src="../../eCommon/js/common.js" ></script>
<script language="Javascript" src="../../eOT/js/Holidays.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" >
function callWeekDay(){
	var frm=window.parent.frames[1];

	var formObj=document.forms[0];

//Modified by DhanasekarV against INO25643  on 23/12/2010
    formObj.holiday_date.value = formObj.holiday_date_text.value;
	var holiday_Date=formObj.holiday_date.value;

	var mode=formObj.mode.value;
 
var facility_id=formObj.facility_id.value;

frm.location.href="../../eOT/jsp/HolidaysAddModify.jsp?&holiday_Date="+holiday_Date+"&mode="+mode+"&facility_id="+facility_id;
formObj.reason_for_holiday.focus(); 

}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<!-- ,parent.commontoolbarFrame.document.forms[0].Delete.disabled=false -->
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.commontoolbarFrame.document.forms[0].Delete.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

Connection con=null;
PreparedStatement stmt=null;
PreparedStatement stmt1=null;
ResultSet rs=null;
ResultSet rs1=null;
String requestString=request.getQueryString();
if(requestString==null)
{
	//nothing to be done
}

String mode="";
String holiday_Date = request.getParameter("holiday_Date")==null?"":request.getParameter( "holiday_Date" );
//holiday_Date = com.ehis.util.DateUtils.convertDate(holiday_Date,"DMY","en",locale);
String tmp_holiday_Date = com.ehis.util.DateUtils.convertDate(holiday_Date,"DMY",locale,"en");

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




mode=request.getParameter("mode");

String holiday_date = request.getParameter("holiday_date")==null?"":request.getParameter( "holiday_date" );

//holiday_date = com.ehis.util.DateUtils.convertDate(holiday_date,"DMY","en",locale);


//String item_code_disable="";
int week_day=0;
int week_Day=0;
String reason_for_holiday="";
String sql="";
String sql1="";
String facility_id=(String) session.getAttribute("facility_id");
try{
	con=ConnectionManager.getConnection(request);
if(mode.equals("modify")){
		sql="SELECT to_char(HOLIDAY_DATE,'DD/MM/YYYY') holiday_date, TO_CHAR(HOLIDAY_DATE,'D') WEEK_DAY, REASON_FOR_HOLIDAY FROM OT_HOLIDAY WHERE OPERATING_FACILITY_ID =? and to_char(HOLIDAY_DATE,'dd/MM/yyyy')=?";

	String tmp_holiday_date1 = com.ehis.util.DateUtils.convertDate(holiday_date,"DMY",locale,"en");
		stmt=con.prepareStatement(sql);
		stmt.setString(1,facility_id);
		stmt.setString(2,tmp_holiday_date1);
       
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			//holiday_date=rs.getString("holiday_date");
			//Buddhist date conversion (Thai Locale)
		
			holiday_date=com.ehis.util.DateUtils.convertDate(rs.getString("holiday_date"),"DMY","en",locale);
			//holiday_date=rs.getString("holiday_date");
			
			week_day=Integer.parseInt(rs.getString("WEEK_DAY"));
			
			reason_for_holiday=rs.getString("reason_for_holiday");

		}
		
	//item_code_disable="disabled";	
	if(rs!=null)rs.close();
	if(stmt!=null) stmt.close();
}

%>
<form name="holidays_form" id="holidays_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.HolidaysServlet" method="post" target="messageFrame" > 

<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center >

<br><br>

<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
<% if(mode.equals("insert"))
{ %>
	
<tr>
	<td class="label">
		<fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<input type="text" name="holiday_date_text" id="holiday_date_text" size="20" maxlength=10 value="<%=holiday_Date%>" onBlur='callWeekDay();' readOnly>
		<input type="hidden" name="holiday_date" id="holiday_date" value="<%=holiday_Date%>">

		<input type="hidden" name="holiday_date1" id="holiday_date1" value="<%=holiday_Date%>">
		<img src='../../eCommon/images/CommonCalendar.gif'  id='date' onClick="return showCalendar('holiday_date_text');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	 <% 
	if(!holiday_Date.equals("")){
	   sql1 = "select to_char(to_date(?,'dd/mm/yyyy'),'D') week_day from dual" ;
       stmt1=con.prepareStatement(sql1);
	   stmt1.setString(1,tmp_holiday_Date);
       rs1=stmt1.executeQuery();
	   if(rs1!=null && rs1.next()){
			week_Day=Integer.parseInt(rs1.getString("week_day"));
	   }
	}
    if(rs1!=null)rs1.close();
    if(stmt1!=null) stmt1.close();
%>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.day.label" bundle="${common_labels}"/>
	</td>
  
	<td class='fields'>
		<input type="text" name="week_day" id="week_day" value="<%=weekDays[week_Day]%>"  size=15 maxlength=15  readonly>
	</td>
</tr><%} else if(mode.equals("modify"))
{%>
	

<tr>
	<td class="label">
		<fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<!-- modified by DhanasekarV  on 23/10/2010 against IN025643 -->
		<input type="text" name="holiday_date_text" id="holiday_date_text" size="20" maxlength=10 value="<%=holiday_date%>" readOnly>
		<input type="hidden" name="holiday_date" id="holiday_date" size="20" maxlength=10 value="<%=holiday_date%>">
        <image src='../../eCommon/images/CommonCalendar.gif'  disabled >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.day.label" bundle="${common_labels}"/>
	</td>
  
	<td class='fields'>
		<input type="text" name="week_day" id="week_day" value="<%=weekDays[week_day]%>"  size=15 maxlength=15  readonly>
	</td>
</tr>
<%}%>

<tr>
	<td class=label>
		<fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="reason_for_holiday" id="reason_for_holiday" value="<%=reason_for_holiday%>"  size=30 maxlength=30 >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->

</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='reason_for_holiday1' id='reason_for_holiday1' value="<%=reason_for_holiday%>">
<input type="hidden" name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>
<%
}catch(Exception e){
	e.printStackTrace();
	//out.println("Exception in Holidays Add Modify: =="+e);
}finally{
	try{
		if(rs!=null)		rs.close();
		if(stmt!=null)	stmt.close();

		if(rs1!=null)rs1.close();
		if(stmt1!=null) stmt1.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Exception is "+e);
	}
}
%>

