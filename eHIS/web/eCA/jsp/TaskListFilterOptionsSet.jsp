<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created

12/24/2015    IN058157      ManojKumar KV      Task list - currently the task list is displaying by one day. Users want to view by a range of dates
---------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------
13/04/2020	IN072674		Ramesh Goli				13/04/2020		Ramesh G		MMS-KH-CRF-0032
02/12/2023    32779               Srinivasa N T                                       RAmesh G                 AAKH-CRF-0165
--------------------------------------------------------------------------------------------------------------- 
*/
%>
<%@page import="java.sql.*,java.util.*,java.text.*,eCA.PatTaskListRepository,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<%
String to_date=patTask.checkForNull(request.getParameter("to_date"));
String from_date=patTask.checkForNull(request.getParameter("from_date"));
String discharge=patTask.checkForNull(request.getParameter("Discharge"));
//modified for IN058157 start
String locationType=patTask.checkForNull(request.getParameter("location_type"));
//modified for IN058157 end		
String selectedSubFunciton = patTask.checkForNull(request.getParameter("selectedSubFunciton"));		//IN072647
/* Edited for INT-CRF-BRU-CIS-023 start */
/* String patientIdExists=patTask.checkForNull(request.getParameter("patientid_exists"));
String patientIdForDesktop=patTask.checkForNull(request.getParameter("patientId"));
 *//* Edited for INT-CRF-BRU-CIS-023 end */
String last_week_date="";
String curr_sys_date="";
java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) property.getProperty("LOCALE");
//IN072674 Start.
String facility_id = (String)session.getValue("facility_id");
//32779 start
String graphMode=session.getAttribute("graphMode")==null?"":session.getAttribute("graphMode").toString();
String flag="display : none; ";//32779
if(graphMode.equalsIgnoreCase("D")){
	flag="display : block;";
}
String interval_val = "";
Connection con=null;
boolean siteUom =false;
//32779 end
/*
if(to_date.equals("") || from_date.equals(""))
{
ArrayList sysdate= patTask.getSysDateTime_L();
for(int i=0;i<sysdate.size();i++){
last_week_date =  (String)sysdate.get(1);
curr_sys_date =  (String)sysdate.get(0);
}
from_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",locale);
to_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",locale);
}
*/
if(to_date.equals("") || from_date.equals("")|| "V".equals(selectedSubFunciton))
{
	ArrayList sysdate= patTask.getTaskListFilterDate(selectedSubFunciton,locale,facility_id);
	from_date	= (String)sysdate.get(0);
	to_date	= (String)sysdate.get(1);
}else{
	java.util.Date ToDate= new java.util.Date();
	java.util.Date FromDate= new java.util.Date();
	
	SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
	
	try{	
		ToDate = df.parse(to_date.toString().trim());			
	}catch(ParseException ex){
		ToDate = df1.parse(to_date.toString().trim());
	}
	to_date=formatter2.format(ToDate);
	try{	
		FromDate = df.parse(from_date.toString().trim());			
	}catch(ParseException ex){
		FromDate = df1.parse(from_date.toString().trim());
	}
	from_date=formatter2.format(FromDate);

}
String dateFormat="dd/mm/yyyy";
String timeFormat="";
if("V".equals(selectedSubFunciton))
{
	timeFormat="hh24:mi";
}
//IN072674 end.
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='TaskListFilterSet' id='TaskListFilterSet'>
<br/>
<table cellpadding=0 cellspacing=0 border=0 width="100%" height='30%' align=center>
<tr>
<td class='label'><fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/></td>
<td class='fields'><input type='checkbox' name='DischargePat' id='DischargePat' <%=discharge.equals("true")?"checked":""%>></td>
</tr>
<tr>
<td class='label'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
<td class='fields'>&nbsp;<input type="text" name="date_from" id="date_from" value="<%=from_date%>" size="12" maxlength="16" onBlur="dateCheckingNew(this,date_to,'<%=locale%>','<%=selectedSubFunciton%>')"><img src="../../eCommon/images/CommonCalendar.gif" align=center onclick="return showCalendar('date_from','<%=dateFormat%>','<%=timeFormat%>');" style='cursor:pointer'>&nbsp;&nbsp;<input type=text name='date_to' id='date_to' value='<%=to_date%>' size="12" maxlength="16" onBlur="dateCheckingNew(date_from,this,'<%=locale%>','<%=selectedSubFunciton%>')"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to','<%=dateFormat%>','<%=timeFormat%>');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center></td></tr> <!-- IN072674 -->
<br></br>
<!-- aakh-crf-0165 start -->
<table>
<tr style="<%=flag%>">
                    <td id=Timeintervals class='LABEL'  width ='5%'><fmt:message key="eCA.TimeInterval.label" bundle="${ca_labels}"/>&nbsp;</td>
                    <td class='fields' width ='11%'><select id="time_interval">
                           <option value="0">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>	
                           <option value="5">5 min</option>
                           <option value="10">10 min</option>
                           <option value="15">15 min</option>
                           <option value="30">30 min</option>
                           <option value="60">1 hr</option>	
                         </select>
      </td>
</tr>
</table>
<!-- aakh-crf-0165 End -->
</table>
<input type='hidden' name='to_date_value' id='to_date_value' value='<%=to_date%>' >
<input type='hidden' name='from_date_value' id='from_date_value' value='<%=from_date%>' >
 <!-- modified for IN058157 start  -->
<input type='hidden' name='location_type' id='location_type' value='<%=locationType%>' >
 <input type='hidden' name='language_id' id='language_id' value='<%=locale%>' >
 <input type='hidden' name='interval_val' id='interval_val' value='0'><!-- aakh-crf-0165  -->
 <input type="hidden" name='graphMode' id='graphMode' id='graphMode' value='<%=graphMode%>'/><!-- aakh-crf-0165  -->
 <!--  modified for IN058157 end -->
</form>
</body>
</html>

