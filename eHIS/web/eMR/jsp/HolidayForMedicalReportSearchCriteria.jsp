<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,eFM.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facilityId = (String) session.getValue( "facility_id" ) ;
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
<script language="javascript" src="../../eMR/js/HolidayForMedicalReport.js"></script>	
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown = "CodeArrest();"  onKeyDown = 'lockKey();'>
<br>
<form name="mrpHolidaySearch" id="mrpHolidaySearch"  method="post"  action="../../servlet/eMR.MRPHolidayServlet" target="messageFrame">

  <% 
request.setCharacterEncoding("UTF-8");	
  
  String CurrentDate="",operation="",holiday_date="",holiday="";
  String holidayreason="";  
  Connection con=null;
  Connection con1=null;
  ResultSet rs=null;
  Statement stmt=null;
  try{
   con= ConnectionManager.getConnection(request);
   con1= ConnectionManager.getConnection(request);
   operation=request.getParameter("operation")==null?"":request.getParameter("operation");
   CurrentDate=FMCurrentEncounterDetails.getCurrentDate(con);  //In this method Retrune the current date
  
  
 
      
  %>
     <table align="center" width="50%" border="0">	   
              	 <%if(!operation.equals("")&&operation.equals("insert")){
				 
				 %>
				 <tr >
				 <td></td> 
		      <td class="label" width='20%'  colspan="2" ><b><center><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></center></b></td>
			<td></td>  
			            
		    </tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
		   <tr>
		   <td  class="label" width='20%' nowrap  ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td> 
			<td class='fields' width='25%'>
			<input width='15' type='text' name='holiday' id='holidaydate' size='10' maxlength='10' value="" Onblur="validate_date_from(this);compare_from(this,holidaydate);year_check(this,holiday);month_check(this,holidaydate);" tabindex=1><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].holidaydate.select(); return showCalendar('holidaydate');" tabindex=2><img src='../../eCommon/images/mandatory.gif' id='mand_frm_date' align='center'></img></td>			
			<td class='label' width='20%' nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>			
			<td class='fields' width='25%'><input type='text' name='holiday_end' id='holiday_end' value='' size='10' maxlength='10' Onblur='validate_date_to_chk(this);validate_date_to(this,holiday_end);month_check(holiday_end,this);' tabindex=3 ><img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif"  
			id='to_date_val' onClick="document.forms[0].holiday_end.select(); return showCalendar('holiday_end');" tabindex=4><img src='../../eCommon/images/mandatory.gif' id='mand_to_date' align='center'></img></td> 
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
		      <td class="label" width='20%'colspan=2>&nbsp;</td>
			  <td class="label" width='20%'>&nbsp;</td>
			  <td class='fields' width='25%'><input type='button' class='BUTTON' name='Search' id='Search' title= 'Search' align='right' 
			  value='<fmt:message key="Common.Select.label" bundle="${common_labels}"/>' onClick="holidayResultForMrd()"><td>  			          
		    </tr>
			<%}if(!operation.equals("")&&operation.equals("modify")){      
				  	
			       holiday_date=request.getParameter("holiday_date")==null?"":request.getParameter("holiday_date");
				   holiday=request.getParameter("holiday")==null?"":request.getParameter("holiday");
				   
				   holidayreason=request.getParameter("holidayreason")==null?"":request.getParameter("holidayreason");
				
			%>
			<table align="center" width="50%" border="0">
			 <tr >
				 <td></td> 
		      <td class="label" width='20%'  colspan="2" ><b><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></b></td>
			<td></td>  
			            
		    <tr></tr>
           	<tr></tr>
			<tr></tr>
			<tr>
		   <td  class="label" width='20%' nowrap ><fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/></td> 
			<td class='fields' width='25%'><input width='15' type='text' id='holidaydate'
			name='holidaydate' size='10' maxlength='10' value="<%=holiday_date%>" readonly><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].holidaydate.select(); return showCalendar('holidaydate');" tabindex=2 disabled><img src='../../eCommon/images/mandatory.gif' id='mand_frm_date' align='center'></img></td>			
			<td class='label' width='20%' nowrap><font class="label" id='holiday_day1' width = '15%' ></font></td>			
			<td class='fields' width='25%'></td> 
			
			</tr>	
			 <tr>
		   <td class='label' width='20%' nowrap><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/></td>			
			<td class='fields' width='25%'><input type="text" name="reason_for_holiday" id="reason_for_holiday" onBlur="makeValidString(this);chkChar(this);" onKeyPress='return SpeCharRestriction(event)' value="<%=holidayreason%>" size="30" maxlength="30" >&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></td> 
			
			</tr>
			</table>
			
			<%}%>
	  
	 </table>
	 <%}catch(Exception e){
	   e.printStackTrace();
	 }finally{
	  ConnectionManager.returnConnection(con,request);
	  ConnectionManager.returnConnection(con1,request);
	 }%>
	 <input type="hidden" name="sys_date" id="sys_date" value="<%=CurrentDate%>">
	 <input type="hidden" name="operation" id="operation" value="<%=operation%>">
	 
</form>
</body>
<%if(!holiday.equals("")&&(!operation.equals("")&&operation.equals("modify"))){%>

	
   <script>parent.frames[1].document.getElementById("holiday_day1").innerHTML = "<b><%=holiday%></b>";</script>
   
<%}%>
</html>
<%!
public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>	

