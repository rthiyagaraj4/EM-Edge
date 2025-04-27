<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<html>
<head>


<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<Script src="../../eOA/js/SecondaryResource.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String locale = (String)session.getAttribute("LOCALE");
			String Clinic_Code=request.getParameter("Clinic_Code");
			String Clinic_Name=request.getParameter("Clinic_Name");
			String Practitioner_id=request.getParameter("Practitioner_id");
			String Practitioner_name=request.getParameter("Practitioner_name");
			String From_time=request.getParameter("From_time");
			String To_time=request.getParameter("To_time");
			String VisitTypeCD=request.getParameter("VisitTypeCD");
			String VisitTypeDesc=request.getParameter("VisitTypeDesc");
			String time_table_type=request.getParameter("time_table_type");
			String Appt_date=request.getParameter("Appt_date");
			String facilityid=(String)session.getValue("facility_id");
			String patient_id=request.getParameter("patient_id");
			String no_of_slots=request.getParameter("no_of_slots");

			String care_locn_ind=request.getParameter("care_locn_ind");
			String res_class=request.getParameter("res_class");

			String recurring_cur_select=request.getParameter("recurring_cur_select");


			String care_locn_ind_desc="";

			if(care_locn_ind.equals("C")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(care_locn_ind.equals("E")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(care_locn_ind.equals("D")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}


			String res_class_desc="";



			if(res_class.equals("P"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_class.equals("E"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_class.equals("R"))
	{
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_class.equals("O"))
	{
res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}



			String day_of_week="";
			Connection conn = null;
			Statement stmt=null,stmt1=null;
			ResultSet rs=null;
			ResultSet rs1=null;
			PreparedStatement pstmt=null;
			String appDate;
			String day_limit="";

		%>
		<body OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()' onLoad ='focusprefdate1()'>
		<form name="recur_day_criteria" id="recur_day_criteria" method="post">
		<%
try
{
	conn = ConnectionManager.getConnection(request);


stmt1=conn.createStatement();	
rs1=stmt1.executeQuery("select to_char(to_date('"+Appt_date+"','dd/mm/yyyy'),'D') appt_date, to_char(to_date('"+Appt_date+"','dd/mm/yyyy') + 1,'dd/mm/yyyy') appt_date1, max_recurr_days from oa_param");
rs1.next();

day_of_week=rs1.getString("appt_date");
appDate=rs1.getString("appt_date1");
day_limit=rs1.getString("max_recurr_days");

if(day_limit==null || day_limit.equals(""))
	day_limit="0";

	%>
<table  cellpadding="2" cellspacing="0" width="100%" valign='top' border='0'>
	<td class='COLUMNHEADER' colspan=4><fmt:message key="eOA.AppointmentCriteria.label" bundle="${oa_labels}"/></td>
<table cellpadding="2" cellspacing="0" width="100%" valign='top' border='0'>
	<tr>
			<td  class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td  class="fields"><b><%=care_locn_ind_desc%> </td>
			<td  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class='fields'><b><%=Clinic_Name%></b></td>
	</tr>
			<td  class="label"><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
			<td  class="fields"><b><%=res_class_desc%></td>
			<td  class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<td  class='fields'><b><%=Practitioner_name%></b></td>

	</tr>
	<tr>
			<td  class="label"><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
			<td  class="fields"><b><%=VisitTypeDesc%></b></td>
			<td  class="label"><fmt:message key="Common.time.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
			<td  class="fields"><b><%=From_time%>&nbsp;-&nbsp;<%=To_time%></b></td>
			
	</tr>

	<%
		String  appDate_display=DateUtils.convertDate(appDate,"DMY","en",locale);
	%>
	<tr>
			<td  class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td  class="fields">
			<input id="date_from" type=text name='from_date' id='from_date' onchange="enable_disable()" size='10' maxlength='10' tabindex=1 value='<%=appDate_display%>'				Onblur='validate_date_from(this,appt_date,to_date);' ><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].from_date.focus();return showCalendar('date_from',null);"  ><img src="../../eCommon/images/mandatory.gif" align ='center'></img>-&nbsp;
			 <input id="date_to" type=text name='to_date' id='to_date' onchange="enable_disable()" size='10' maxlength='10' tabindex =2 value=''  Onblur='validate_date_to(this,from_date,appt_date)'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].to_date.focus();return showCalendar('date_to',null);" ><img src="../../eCommon/images/mandatory.gif" align='center'></img>
			</td>
			
			<td  class="label"><fmt:message key="eOA.RecurringType.label" bundle="${oa_labels}"/></td>
			<td  class="fields" >
			<select name="cbo_rec_type" id="cbo_rec_type" tabindex =3  onchange="enable_disable()";> 
			<option value='0'>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='1'> <fmt:message key="Common.daily.label" bundle="${common_labels}"/> </option>
			<option value='2'> <fmt:message key="Common.weekly.label" bundle="${common_labels}"/> </option>
			</select><img src="../../eCommon/images/mandatory.gif" align ='center'>
			</td>
	</tr>

	<tr>
			<td colspan=2 class="fields">
				<fmt:message key="Common.sun.label" bundle="${common_labels}"/><input type="checkbox" name="Sun" id="Sun" value="1" disabled onclick="enable_disable()">
				<fmt:message key="Common.mon.label" bundle="${common_labels}"/><input type="checkbox" name="Mon" id="Mon" value="2" disabled onclick="enable_disable()">
				<fmt:message key="Common.tue.label" bundle="${common_labels}"/><input type="checkbox" name="Tue" id="Tue" value="3" disabled onclick="enable_disable()">
				<fmt:message key="Common.wed.label" bundle="${common_labels}"/><input type="checkbox" name="Wed" id="Wed" value="4" disabled onclick="enable_disable()">
				<fmt:message key="Common.thu.label" bundle="${common_labels}"/><input type="checkbox" name="Thu" id="Thu" value="5" disabled onclick="enable_disable()">
				<fmt:message key="Common.fri.label" bundle="${common_labels}"/><input type="checkbox" name="Fri" id="Fri" value="6" disabled onclick="enable_disable()">
				<fmt:message key="Common.sat.label" bundle="${common_labels}"/><input type="checkbox" name="Sat" id="Sat" value="7" disabled onclick="enable_disable()">
			</td>
			<td class='fields' colspan=2>
			<input type='button' value='<fmt:message key="Common.display.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/>' name='dis_date' tabindex=4 onClick="checkEmpty1()" class="BUTTON" >&nbsp;
			<input type='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearFields()" class="BUTTON" >&nbsp;
			<input type="button" onclick="parent.frames[1].validate_rec()" name="AcceptDates" id="AcceptDates" value='<fmt:message key="eOA.AcceptDate.label" bundle="${oa_labels}"/>' class="BUTTON" disabled>

			</td>
	</tr>


</table>
	
</table>

	<input type="hidden" name ="dayOfWeek" value="<%=day_of_week%>">
	<input type="hidden" name ="appt_date" value="<%=appDate%>"> 
	<input type="hidden" name ="cliniccode" value="<%=Clinic_Code%>">
	<input type="hidden" name ="practitionerid" value="<%=Practitioner_id%>">
	<input type="hidden" name ="visittype" value="<%=VisitTypeCD%>">
	<input type="hidden" name ="facilityid" value="<%=facilityid%>">
	<input type="hidden" name ="time_table_type" value="<%=time_table_type%>">
	<input type="hidden" name ="From_time" value="<%=From_time%>">
	<input type="hidden" name ="To_time" value="<%=To_time%>">
    <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name ="no_of_slots" value="<%=no_of_slots%>">
	<input type="hidden" name ="recurring_cur_select" value="<%=recurring_cur_select%>">
	<input type="hidden" name ="care_locn_ind" value="<%=care_locn_ind%>">
	<input type="hidden" name ="res_class" value="<%=res_class%>">
	<input type="hidden" name ="day_limit" value="<%=day_limit%>">
	




	<%
	if (rs!=null) rs.close();
	if(rs1 !=null)rs1.close();
	if (stmt!=null) stmt.close();
	if (pstmt!=null) pstmt.close();
	if(stmt !=null) stmt.close();
	if(stmt1 !=null)stmt1.close();
}catch(Exception ex){
	ex.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	//out.println("exception is "+ ex);

}finally
{
    ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>

