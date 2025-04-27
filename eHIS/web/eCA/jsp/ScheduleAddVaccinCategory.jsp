<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------------------
?           100				?				created
05/12/2017	IN065683		Ramesh G									After create vaccine category as age specific, System 																			automatically add this vaccine category in manage 																				immunization for all patients.
13/07/2017	IN066331		Prakash C		13/07/2017		Ramesh G	 CA-Common-Manage Immunization
18/05/2023	41653		    Twinkle Shah	 18/05/2023	    M.f.mohamed Ali         MMS-JU-CRF-0015.3
07/09/2023	41654			Twinkle Shah				    Ramesh Goli             MMS-JU-CRF-0015.4															
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
 <%
 String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String Dob ="";
	Dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String vacc_categ_id = request.getParameter("categ_id")==null?"":request.getParameter("categ_id");
	String editMode = request.getParameter("editMode")==null?"":request.getParameter("editMode"); //41654
	String vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref"); //41654
	String CurrentDate ="";
	CurrentDate	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	Dob = com.ehis.util.DateUtils.formatDate(Dob,"DMY" , "DMYHM", locale);

	
%>
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCA/js/ScheduleForVacination.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
  <head> <title><fmt:message key="eCA.VaccinationSchedule.label" bundle="${ca_labels}"/> </title> </head>

  <body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	String vaccine_categ_id = request.getParameter("categ_id")==null?"":request.getParameter("categ_id");
	String userId=(String) session.getValue("login_user");

	String Vaccine_Name="";
	String Vaccine_Id="";
	String dose_no="";
	String freq_duration="";
	String freq_duration_type="";
	String freq_duration_type1="";
	String mandatory_yn="";
	String default_yn = "";
	String check="";
	String dis="";
	String val="";
	String className="";
	String disp_vacc_sort_yn=""; //41653
	String vaccin_categ_query="";//41653
	
	String sch_created_date=""; //41654
	String schedule_date =""; ///41654
	String vaccine_id =""; //41654
	String sch_date_Check=""; //41654
	String outCome_Code=""; //41654
	String mark_Status=""; //41654
	String existVaccine="";  //41654
	
	int k =0;
	//int i=1;
	//IN065683 Start.
	String specificAge = "N";  
	String specAgeYear = "0";
	String specAgeMonth = "0";
	String specAgeDay = "0";
	con = ConnectionManager.getConnection(request);
	pstmt= con.prepareStatement("SELECT NVL(AGE_SPECIFIC_YN,'N') AGE_SPECIFIC_YN FROM CA_IM_VAC_CATEG WHERE  VACC_CATEG_ID=?");
	pstmt.setString(1,vaccine_categ_id);
	rs= pstmt.executeQuery();
	if(rs.next()){
		specificAge  = rs.getString("AGE_SPECIFIC_YN");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	//IN065683 End.
	
	//start 41653
    pstmt= con.prepareStatement("SELECT NVL(DISP_VACC_SORT_YN,'N') DISP_VACC_SORT_YN FROM CA_IM_PARAM");	
    rs=pstmt.executeQuery();
    if(rs.next())
        {
    	disp_vacc_sort_yn  = rs.getString("DISP_VACC_SORT_YN");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	//end 41653
	
	// start 41654
   try
    { 
	    pstmt= con.prepareStatement("SELECT TO_CHAR(SCH_CREATED_DATE, 'DD/MM/YYYY HH24:MI') SCH_CREATED_DATE from CA_IM_PAT_VAC_SCH_HDR where VAC_SCH_REF = ? AND VACC_CATEG_ID = ?");	
	    pstmt.setString(1, vac_sch_ref);
	    pstmt.setString(2, vaccine_categ_id);
		rs=pstmt.executeQuery();
	    if(rs.next())
	    {
			sch_created_date =rs.getString("SCH_CREATED_DATE")==null?"":rs.getString("SCH_CREATED_DATE"); 
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
    }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	//41654 end. 
	%>

	<form name='addCategoryForm' id='addCategoryForm' method='post' target='messageFrame' action='../../servlet/eCA.ScheduleCategServlet'>
		<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr></tr>
		<!-- IN065683 Start.-->
		<%if("Y".equals(specificAge)){%>
			<input type="hidden" id="start_date" name="start_date" id="start_date" value = '<%=Dob%>' />

		<%}else{%>
		<!-- IN065683 End.-->
		<tr>
		
		<!--	<td width='25%'  class='label'><fmt:message key="eCA.CreatingUser.label" bundle="${ca_labels}"/></td>
			<td width='25%'  class='fields'><input type='text' name='creating_user' id='creating_user' value='<%=userId%>' size='20' maxlength='20'><input type='button' class='button' value='?' id='src_butn'  name='search_user' id='search_user' onClick="getUser()" ><input type=hidden value='' name='creating_user_id' id='creating_user_id'></td> -->
			
	        <%--41654   <td width='25%'  class='label' ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<td><input class = 'fields' id="start_date"  type="text" name="start_date" id="start_date" size=14 maxlength=16 value = '<%=CurrentDate%>' onblur = 'CheckDateTime(this,"startDate");' OnKeyPress="return CheckForNumsAndColon(event)"><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('start_date');" ><img src='../../eCommon/images/mandatory.gif'></td>
			<td width='50%'  class='label'></td>--%>
			
			<!--start 41654 -->
			<%
			if("editSchedule".equals(editMode)){
			%>
			<td width='25%'  class='label' ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<td><input class = 'fields' id="start_date"  type="text" name="start_date" id="start_date" size=14 maxlength=16 value ='<%=sch_created_date%>' readonly onblur = 'CheckDateTime(this,"startDate");' OnKeyPress="return CheckForNumsAndColon(event)"><input type='image' src="../../eCommon/images/CommonCalendar.gif" disabled id="cal_pv" onclick="return showCalendarValidate('start_date');" ><img src='../../eCommon/images/mandatory.gif'></td>
			<td width='50%'  class='label'></td>
			<%
			} 
			else
			{
			%>
			<td width='25%'  class='label' ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<td><input class = 'fields' id="start_date"  type="text" name="start_date" id="start_date" size=14 maxlength=16 value = '<%=CurrentDate%>' onblur = 'CheckDateTime(this,"startDate");' OnKeyPress="return CheckForNumsAndColon(event)"><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('start_date');" ><img src='../../eCommon/images/mandatory.gif'></td>
			<td width='50%'  class='label'></td>
			<%}%>
			<!--end 41654 -->

		</tr>
		<%} //IN065683%>
		</table>

		<table class='grid' id='scheduleVaccTitle' border='1' width='100%' cellpadding='3' cellspacing='0'>
		<tr>
			<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<!--<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.VaccineDoseNo.label" bundle="${ca_labels}"/></td> -->
			<!-- IN065683 Start. -->
			<!-- <td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td> -->
			<%if("Y".equals(specificAge)){%>
			<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.specific.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
			<%}else{%>
			<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
			<%}%>
			<!-- IN065683 End. -->
			<!--<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td> -->
			
			<!--start 41654 -->
			<%
			if("editSchedule".equals(editMode)){
			%>
		    <td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td> 
		    <%}%>
		    <!--end 41654 -->
		    
			<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
		</table>

	<% 
	//IN065683 Start
	//con = ConnectionManager.getConnection(request);
	
	//start 41654
	if("editSchedule".equals(editMode))
	{
		if("Y".equals(disp_vacc_sort_yn)) 
		{
		vaccin_categ_query="SELECT DECODE( NVL(C.VACCINE_ID,'N'),'N','N','Y') EXISTVACCINE,A.VACCINE_ID, A.DOSE_NO, A.FREQ_DURATION, A.FREQ_DURATION_TYPE, NVL (A.APPL_AGE_YEARS, '0') APPL_AGE_YEARS, NVL (A.APPL_AGE_MONTHS, '0') APPL_AGE_MONTHS, NVL (A.APPL_AGE_DAYS, '0') APPL_AGE_DAYS, A.MANDATORY_YN, A.DEFUALT_OPTION, CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID, ?, '2') SHORT_DESC,C.SCHEDULE_DATE,C.OUTCOME_CODE, DECODE ((SELECT 1 FROM CA_IM_PAT_VAC_ERR_DTL WHERE VAC_SCH_REF = C.VAC_SCH_REF AND VACCINE_ID = C.VACCINE_ID AND DOSE_NO = C.DOSE_NO AND ROWNUM = 1), 1, 'E', '' ) MARKSTATUS FROM CA_IM_VAC_SCH_FOR_CATEG A LEFT JOIN CA_IM_PAT_VAC_SCH_DTL C ON C.VACCINE_ID = A.VACCINE_ID AND C.DOSE_NO = A.DOSE_NO AND C.VAC_SCH_REF = ? WHERE A.VACC_CATEG_ID = ? ORDER BY 11, 3";
		}
		else
		{
	     vaccin_categ_query="SELECT DECODE( NVL(C.VACCINE_ID,'N'),'N','N','Y') EXISTVACCINE,A.VACCINE_ID, A.DOSE_NO, A.FREQ_DURATION, A.FREQ_DURATION_TYPE, NVL (A.APPL_AGE_YEARS, '0') APPL_AGE_YEARS, NVL (A.APPL_AGE_MONTHS, '0') APPL_AGE_MONTHS, NVL (A.APPL_AGE_DAYS, '0') APPL_AGE_DAYS, A.MANDATORY_YN, A.DEFUALT_OPTION, CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID, ?, '2') SHORT_DESC,C.SCHEDULE_DATE,C.OUTCOME_CODE, DECODE ((SELECT 1 FROM CA_IM_PAT_VAC_ERR_DTL WHERE VAC_SCH_REF = C.VAC_SCH_REF AND VACCINE_ID = C.VACCINE_ID AND DOSE_NO = C.DOSE_NO AND ROWNUM = 1), 1, 'E', '' ) MARKSTATUS FROM CA_IM_VAC_SCH_FOR_CATEG A LEFT JOIN CA_IM_PAT_VAC_SCH_DTL C ON C.VACCINE_ID = A.VACCINE_ID AND C.DOSE_NO = A.DOSE_NO AND C.VAC_SCH_REF = ? WHERE A.VACC_CATEG_ID = ? ORDER BY 8, 3"; 
		}
	}
	//start 41653
	else
	{
	if("Y".equals(disp_vacc_sort_yn)) 
	{
	vaccin_categ_query="SELECT A.VACCINE_ID, A.DOSE_NO, A.FREQ_DURATION, A.FREQ_DURATION_TYPE,NVL(A.APPL_AGE_YEARS,'0') APPL_AGE_YEARS, NVL(A.APPL_AGE_MONTHS,'0') APPL_AGE_MONTHS, NVL(A.APPL_AGE_DAYS,'0') APPL_AGE_DAYS, A.MANDATORY_YN, A.DEFUALT_OPTION, CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,'2') SHORT_DESC FROM CA_IM_VAC_SCH_FOR_CATEG A WHERE A.VACC_CATEG_ID =? Order by 10,2"; 
	}
	else
	{
	//vaccin_categ_query=" SELECT A.VACCINE_ID, A.DOSE_NO, A.FREQ_DURATION, A.FREQ_DURATION_TYPE, A.MANDATORY_YN, A.DEFUALT_OPTION, CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,'2') SHORT_DESC FROM CA_IM_VAC_SCH_FOR_CATEG A WHERE A.VACC_CATEG_ID =? Order by 7,2 ";
    vaccin_categ_query="SELECT A.VACCINE_ID, A.DOSE_NO, A.FREQ_DURATION, A.FREQ_DURATION_TYPE,NVL(A.APPL_AGE_YEARS,'0') APPL_AGE_YEARS, NVL(A.APPL_AGE_MONTHS,'0') APPL_AGE_MONTHS, NVL(A.APPL_AGE_DAYS,'0') APPL_AGE_DAYS, A.MANDATORY_YN, A.DEFUALT_OPTION, CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,'2') SHORT_DESC FROM CA_IM_VAC_SCH_FOR_CATEG A WHERE A.VACC_CATEG_ID =? Order by 7,2"; 
	}
	}
	// end 41653

	//end 41654
	//IN065683 End
	pstmt= con.prepareStatement(vaccin_categ_query);
	pstmt.setString(1,locale);
	//start 41654
	if("editSchedule".equals(editMode))
	{
	pstmt.setString(2,vac_sch_ref);
	pstmt.setString(3,vaccine_categ_id);
	}
	else
	{
	pstmt.setString(2,vaccine_categ_id);
	}
	//end 41654
	rs= pstmt.executeQuery();
	out.println("<table id='scheduleVaccData' border='1' width='100%' cellpadding='3' cellspacing=0>");
	while (rs.next())
	{
		sch_date_Check="";
		if (k % 2 == 0 )
			 className = "gridData";
		else
			className = "gridData"; //QRYEVEN
		
		Vaccine_Id  = rs.getString("VACCINE_ID")==null?"":rs.getString("VACCINE_ID");
		Vaccine_Name = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
		dose_no	= rs.getString("DOSE_NO")==null?"":rs.getString("DOSE_NO");
		freq_duration = rs.getString("FREQ_DURATION")==null?"":rs.getString("FREQ_DURATION");
		freq_duration_type = rs.getString("FREQ_DURATION_TYPE")==null?"":rs.getString("FREQ_DURATION_TYPE");
		mandatory_yn = rs.getString("MANDATORY_YN")==null?"":rs.getString("MANDATORY_YN");
		default_yn = rs.getString("DEFUALT_OPTION")==null?"":rs.getString("DEFUALT_OPTION");
		specAgeYear	= rs.getString("APPL_AGE_YEARS")==null?"0":rs.getString("APPL_AGE_YEARS");
		specAgeMonth = rs.getString("APPL_AGE_MONTHS")==null?"0":rs.getString("APPL_AGE_MONTHS");
		specAgeDay = rs.getString("APPL_AGE_DAYS")==null?"0":rs.getString("APPL_AGE_DAYS");
		//start 41654
		if("editSchedule".equals(editMode))
		{
		schedule_date =rs.getString("SCHEDULE_DATE")==null?"":rs.getString("SCHEDULE_DATE"); 
		outCome_Code =rs.getString("OUTCOME_CODE")==null?"":rs.getString("OUTCOME_CODE"); 
		mark_Status =rs.getString("MARKSTATUS")==null?"":rs.getString("MARKSTATUS");
		existVaccine  =rs.getString("EXISTVACCINE")==null?"N":(String)rs.getString("EXISTVACCINE");
		}		
		//end 41654
		
		if(mandatory_yn.equals("Y"))
		{
			check="checked";
			dis="disabled";
			val ="Y";
		}
		else 
		{
			check="";
			dis="";
			val ="N";
		}
		//if(default_yn.equals("Y")) commented for IN066331
		if(default_yn.equals("C"))
		{//IN066331 
			check="checked";
			val ="Y";
		}		
		//start 41654
		if(!schedule_date.equals(""))
		{
		sch_date_Check="checked";
		val="Y";
		}
		//end 41654

		if(freq_duration_type.equals("D"))
		{
			freq_duration_type1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
		}
		else if(freq_duration_type.equals("L"))
		{
			freq_duration_type1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
		}
		else if(freq_duration_type.equals("Y"))
		{
			freq_duration_type1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
		}
		else if(freq_duration_type.equals("H"))
		{
			freq_duration_type1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
		}else if(freq_duration_type.equals("M"))
		{
			freq_duration_type1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
		}else if(freq_duration_type.equals("W"))
		{
			freq_duration_type1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
		}

		//out.println("<tr><td width='' class="+className+" ><input type='hidden' name='Vaccine_Name"+k+"' id='Vaccine_Name"+k+"' value='"+Vaccine_Id+"'> <input type='hidden' name='dose_no"+k+"' id='dose_no"+k+"' value='"+dose_no+"'><input type='hidden' name='freq_duration"+k+"' id='freq_duration"+k+"' value='"+freq_duration+"'><input type='hidden' name='freq_duration_type"+k+"' id='freq_duration_type"+k+"' value='"+freq_duration_type+"'>" +Vaccine_Name+"</td><td width='' class="+className+" >"+freq_duration+"   "+freq_duration_type1+"</td><td width='' class="+className+ "><input type='checkbox' name ='select' value ='"+val+"' "+check+" "+dis+" onClick=changeSelectVal(this,\""+k+"\");><input type='hidden' name='select"+k+"' id='select"+k+"' value='"+val+"'></td></tr>");	
		out.println("<tr>");
		
		//Start. 41654 
		if("editSchedule".equals(editMode))
		{
		out.println("<td width='' class="+className+" ><input type='hidden' name='specAgeYear"+k+"' id='specAgeYear"+k+"' value='"+specAgeYear+"'><input type='hidden' name='specAgeMonth"+k+"' id='specAgeMonth"+k+"' value='"+specAgeMonth+"'><input type='hidden' name='specAgeDay"+k+"' id='specAgeDay"+k+"' value='"+specAgeDay+"'> <input type='hidden' name='Vaccine_Name"+k+"' id='Vaccine_Name"+k+"' value='"+Vaccine_Id+"'> <input type='hidden' name='dose_no"+k+"' id='dose_no"+k+"' value='"+dose_no+"'><input type='hidden' name='freq_duration"+k+"' id='freq_duration"+k+"' value='"+freq_duration+"'><input type='hidden' name='freq_duration_type"+k+"' id='freq_duration_type"+k+"' value='"+freq_duration_type+"'><input type='hidden' name='outCome_Code"+k+"' id='outCome_Code"+k+"' value='"+outCome_Code+"'><input type='hidden' name='mark_Status"+k+"' id='mark_Status"+k+"' value='"+mark_Status+"'><input type='hidden', name='existVaccine"+k+"' id='existVaccine"+k+"' id='existVaccine"+k+"' value='"+existVaccine+"' />" +Vaccine_Name+"</td>");
		}
		else
		{
		out.println("<td width='' class="+className+" ><input type='hidden' name='specAgeYear"+k+"' id='specAgeYear"+k+"' value='"+specAgeYear+"'><input type='hidden' name='specAgeMonth"+k+"' id='specAgeMonth"+k+"' value='"+specAgeMonth+"'><input type='hidden' name='specAgeDay"+k+"' id='specAgeDay"+k+"' value='"+specAgeDay+"'> <input type='hidden' name='Vaccine_Name"+k+"' id='Vaccine_Name"+k+"' value='"+Vaccine_Id+"'> <input type='hidden' name='dose_no"+k+"' id='dose_no"+k+"' value='"+dose_no+"'><input type='hidden' name='freq_duration"+k+"' id='freq_duration"+k+"' value='"+freq_duration+"'><input type='hidden' name='freq_duration_type"+k+"' id='freq_duration_type"+k+"' value='"+freq_duration_type+"'>" +Vaccine_Name+"</td>"); 
		}
		//41654
		//IN065683 Start.
		if("Y".equals(specificAge)){
		//out.println("<td width='' class="+className+" >"+specAgeYear+" Years "+specAgeMonth+" Months "+specAgeDay+" Days </td>");//Below were commented by Dinesh T
		//Below were added by Dinesh T, starts
		out.println("<td width='' class="+className+" >"+specAgeYear+"Y ");
		if(!"0".equals(specAgeMonth))
		out.println(specAgeMonth+"M ");
		if(!"0".equals(specAgeDay))
		out.println(specAgeDay+"D ");
		out.println("</td>");
		//ends
		}else{
		out.println("<td width='' class="+className+" >"+freq_duration+"   "+freq_duration_type1+"</td>");
		}
		//start 41654
		if("editSchedule".equals(editMode))
		{
		if(!schedule_date.equals(""))
		{
        out.println("<td width='' class="+className+" >"+schedule_date+"</td>"); 
		}
		else
		{
	     out.println("<td width='' class="+className+" > &nbsp;</td>"); 
		}
		}
		//end 41654
		
		//IN065683 End.
		
		//start 41654
	    if("editSchedule".equals(editMode))
		{
		out.println("<td width='' class="+className+ "><input type='checkbox' name ='select' id='select_check_box"+k+"' value ='"+val+"' "+check+" "+dis+" "+sch_date_Check+" onClick=changeSelectValEdit(this,\""+k+"\");><input type='hidden' name='select"+k+"' id='select"+k+"' id='select"+k+"' value='"+val+"'><input type='hidden' name='outCome_Code"+k+"' id='outCome_Code"+k+"' id='outCome_Code"+k+"' value='"+outCome_Code+"'><input type='hidden' name='mark_Status"+k+"' id='mark_Status"+k+"' id='mark_Status"+k+"' value='"+mark_Status+"'></td>");	
		}
	    else
	    {
		out.println("<td width='' class="+className+ "><input type='checkbox' name ='select' id='select_check_box"+k+"'value ='"+val+"' "+check+" "+dis+" onClick=changeSelectVal(this,\""+k+"\");><input type='hidden' name='select"+k+"' id='select"+k+"' id='select"+k+"' value='"+val+"'></td>");
	    }
	    //end 41654
		out.println("</tr>");	
	
		k++;
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if(con != null) ConnectionManager.returnConnection(con);

	 %>
		<tr style="visibility:hidden" >
			<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<!--<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.VaccineDoseNo.label" bundle="${ca_labels}"/></td> -->
			<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
			<!--<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td> -->
			<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
	<%
	out.println("</table>");
	%>

				
		<input type=hidden value='<%=locale%>' name='locale'>
		<input type=hidden value='<%=patient_id%>' name='patient_id'>
		<input type=hidden value='<%=encounter_id%>' name='encounter_id'>
		<input type=hidden value='<%=vacc_categ_id%>' name='vacc_categ_id'>
		<input type=hidden value='A' name='sch_status' id='sch_status'>
		<input type=hidden value='<%=k%>' name='count'>
		<input type=hidden value='<%=userId%>' name='creating_user'>
		<input type=hidden value='<%=userId%>' name='creating_user_id'> 
		<input type=hidden value='<%=Dob%>' name='Dob'>
		<input type=hidden value='<%=specificAge%>' name='specificAge'> <!-- IN065683 -->
		<input type=hidden value='<%=disp_vacc_sort_yn%>' name='disp_vacc_sort_yn'> <!--41653 -->
		<input type=hidden value='<%=editMode%>' name='editMode'> <!--41654 -->
		<input type=hidden value='<%=vac_sch_ref%>' name='vac_sch_ref'> <!--41654 -->
		
	  </form>
	<script>
		
			
			if(document.getElementById("scheduleVaccTitle") == null) 
			{
				setTimeout("alignHeading();",300);
			}
			else 
			{	
				alignHeading();
			}
			
	</script>
	
	</body>
  </html>	

