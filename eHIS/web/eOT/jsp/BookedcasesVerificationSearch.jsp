
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>                
<%
//"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eOT.*,eOT.Common.OTRepository,eCommon.Common.*"
%>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,webbeans.eCommon.*,eOT.*,eCommon.XSSRequestWrapper,eOT.Common.OTRepository,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eOT/js/WaitList.js"></script>
	<script language="Javascript" src="../../eOT/js/Slate.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>

<script language='javascript'>
//MO CRF-20082
function clearPatientName(){
	var formObj = document.forms[0];
	formObj.patient_name.value='';
}

async function callPatientSearch(){

	var patient_id	=	document.forms[0].patientid;
	var patient_name	=	document.forms[0].patient_name; //MO CRF-20082
	var return_value =	"";

	return_value	=	(patient_id.value.length>0)?patient_id.value:await PatientSearch();
	if(return_value==null)  return;
	var obj=document.forms[0];
	if(return_value!=null){
		obj.patientid.value	=	return_value;
	}else{
		obj.patientid.value	="";
	}
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			patient_name.value="";//MO CRF-20082
			patient_id.focus();
			return;
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value;
			patient_name.value		= retVal_arr[0];//MO CRF-20082
	}
/*Commented by Suma as part of code tuning on April 23 2010*/
	//document.forms[0].submit();
	/*ends here*/
}

function autopopulatesearch()
{
	validateAll();
}
function validateAll()
{  
	var frmObj=document.forms[0];
	var asa=document.forms[0].stages1.value; // Added crf-0021
	var patient_class=document.forms[0].patient_class.value; // Added crf-0014
	var asa1=frmObj.stages1.value;
	if(frmObj.chk_sequence.checked==true)
	{
	var data="";
	var data1="";
	data=frmObj.theatre_date.value;
	data=changeDate(data);
	data1=frmObj.system_date.value;
	data1=changeDate(data1);
	var dat=new Date(data);
	var dat1=new Date(data1);

		if(dat < dat1)
		{
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var current_label = getLabel("Common.CurrentDate.label","common");
		var resequencing_label = getLabel("eOT.ResequencingDate.Label","OT");
		alert(msgArray[0]+resequencing_label+msgArray[1]+current_label+msgArray[2]);
		frmObj.chk_sequence.checked=false;
		return;
		}
	}
if(frmObj.theatre_date.value==''||frmObj.theatre_date.value==null)
	{

	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	var date_label = getLabel("Common.date.label","common");
	alert(msgArray[0]+date_label+(msgArray[1]));
	return ;
	}
if(frmObj.currstage_code.value ==null ||frmObj.currstage_code.value =='')
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var currentstage_label=getLabel("eOT.CurrentStage.Label","OT");
		alert(msgArray[0]+currentStage_label+(msgArray[1]));
		return;
	}
	verificationList();
}

function funReSetAll(){
	document.forms[0].reset();
	parent.qa_query_result.location.href = '../../eCommon/html/blank.html';
	parent.qa_query_result_tail.location.href = '../../eCommon/html/blank.html';
}

function funReSetwaitlistAll()
{
	document.forms[0].reset();
	parent.qa_query_result.location.href = '../../eCommon/html/blank.html';
}
 
function checkValidate(obj)
{

	var frmObj=document.forms[0];
	if(frmObj.theatre.value==null || frmObj.theatre.value=='')
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var theatrevalue_label=getLabel("eOT.TheatreValue.Label","OT");
		alert(msgArray[0]+theatrevalue_label+(msgArray[1]));
		obj.checked=false;
	}

	var data="";
	var data1="";
	data=frmObj.theatre_date.value;
	data=changeDate(data);
	data1=frmObj.system_date.value;
	data1=changeDate(data1);
	var dat=new Date(data);
	var dat1=new Date(data1);
	if(dat < dat1)
	{
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var current_label = getLabel("Common.CurrentDate.label","common");
		var resequencing_label = getLabel("eOT.ResequencingDate.Label","OT");
		alert(msgArray[0]+resequencing_label+msgArray[1]+current_label+msgArray[2]);
		obj.checked=false;
		 return;
	}
}

function checkDateValidate(da,da1) {
if(CheckDate(da1)==true)

{
	if(da1.value!="" && da.value!="")
	{
		var dat1=changeDate(da.value);
		var dat2=changeDate(da1.value);
		var date1=new Date(dat1);
		var date2=new Date(dat2);
		if(dat2 < dat1)
		{
		   	var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var theatre_label = getLabel("eOT.TheatreDate.Label","OT");
			var current_label = getLabel("Common.CurrentDate.label","common");
			alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
		}
	}
}
}
function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
String facilityid=(String)session.getValue("facility_id");
String schedulekey=CommonBean.checkForNull(request.getParameter("schedulekey"));
String WaitListkey=CommonBean.checkForNull(request.getParameter("WaitListkey"));
String PatIDLen = "";
String sql_asa_score=""; //added crf-0021
String sql_patient_class =""; //added crf-0014
String patient_class ="";//added crf-0014
String ASA_SCORE_CODE="";
String PATIENT_PHYSICAL_STATUS="";
if(schedulekey.equals("") && WaitListkey.equals(""))
{
schedulekey="schedulekey";
}

		String sql="",strSysDate="",surgeon1="",currstage="";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;		

try 
{
		conn = ConnectionManager.getConnection(request);

		String sql_surgery_type_waitlist = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE NATURE_TYPE = 'EM' AND LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' ORDER BY 2";

		String sql_surgery_type_booked = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' ORDER BY 2";
		sql_asa_score = "SELECT ASA_SCORE_CODE,PATIENT_PHYSICAL_STATUS FROM MR_ASA_SCORE WHERE  eff_status = 'E' ORDER BY 1"; //Added crf -0021
		//Added crf -0014
		//sql_patient_class ="select distinct patient_class from pr_encounter where facility_id ='"+facilityid+"'";
		/*Below query is changed against 39794 
		sql_patient_class="select distinct A.patient_class FROM pr_encounter A where a.FACILITY_ID='"+facilityid+"' UNION select distinct B.patient_class FROM ot_booking_hdr B WHERE B.OPERATING_FACILITY_ID='"+facilityid+"' AND B.patient_class IS NOT NULL";*/
		/*Below query is changed against 41231 */
		sql_patient_class ="SELECT PATIENT_CLASS, SHORT_DESC FROM AM_PATIENT_CLASS";
		currstage=CommonBean.checkForNull(request.getParameter("currstage"));
		surgeon1=CommonBean.checkForNull(request.getParameter("surgeon"));
	
		pstmt=conn.prepareCall("SELECT PATIENT_ID_LENGTH,to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 from MP_PARAM");
		rs=pstmt.executeQuery();

		if(rs!=null &&rs.next()==true)
		{
		    PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
			strSysDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
		}
		if(rs!=null)		rs.close();
		if(pstmt !=null) pstmt.close();

	
%>
<form name="VerificationSearchForm" id="VerificationSearchForm">

<table cellpadding=3 cellspacing="0" border="0" width="100%" align="center">

<% if(schedulekey.equals("schedulekey")) {%> 
<tr>
	<td class='label' width='25%' >
		<fmt:message key="eOT.TheatreDate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<input type="text" class="fields" name="theatre_date" id="theatre_date" size="10" maxlength=10 value="<%=strSysDate%>" Onblur="javascript:isValidDate(this);" onkeypress="return checkForSpecCharsforID(event);">
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('theatre_date');" >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<!-- Onblur='checkDateValidate(document.forms[0].system_date,this);' Modified Onblur against SKR-SCF-1284 -->

	<td class='label' width='25%' >
		<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/>
	</td>

	<td class='fields' width='25%' >
	<!--<td class="label" colspan="1">-->
		<input class="fields" name='theatre_type_desc' id='theatre_type_desc' maxlength='20' size='20' value= "" onBlur="if(this.value!='')searchTheatreType(theatre_type_desc); else theatre_type_code.value='' " >
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchTheatreType(theatre_type_desc);">	
	</td>
<tr>
	<td class='label' width='25%' >
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<input name='theatre' id='theatre' maxlength='20' size='20' value= "" onBlur="if(this.value!='')return searchTheatre(theatre); else room_code.value=''">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick=" return searchTheatre(theatre);">
	</td>

	<td class='label' width='25%' >
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>

	<td>
		<input name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='20' size='20' value= "" onBlur="if(this.value!='')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value=''">
		<input type='button' class='button' value='?' name='surButton' id='surButton'   onClick="return searchSpeciality(SPECIALITY_DESC);">
	</td> 
</tr>
<!-- MO-CRF-20082 start-->
<tr>
	<td class='label' width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="fields" width="25%" >  
					<!-- IN:052629 -->
						<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value="" onkeypress="return CheckForSpecChars(event)" onBlur="if(this.value!='')callPatientSearch();else clearPatientName(); ">
						<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
	</td>
	</td>
	<td class='label' width="25%" >
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>     
	</td>
	<td class='fields' width="25%" >
			<input type='text' name='patient_name' id='patient_name' maxlength='100' size='30' value= "" readOnly><!--IN:053032-->
	</td>
	
</tr>
<!-- MO-CRF-20082 end -->
<tr>
	<td class='label' width='25%' >
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td>
		<input name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=surgeon1%>" onBlur="if(this.value!='')return searchSurgeon(SURGEON); else SURGEON_CODE.value=''">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="return searchSurgeon(SURGEON);" >
	</td>
	<td class='label' width='25%' >
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<select name="surgery_type" id="surgery_type"> <option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
     <%
		pstmt=conn.prepareStatement(sql_surgery_type_booked);
		rs=pstmt.executeQuery();
		if(rs!=null){
		while (rs.next()){				
		out.print("<option value='"+rs.getString("NATURE_CODE")+"'>"+rs.getString("SHORT_DESC")+"</option>");
		}
}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
  	%>
		 </select>
	</td>
</tr>
<tr>
	<td class='label' width='25%' >
		<fmt:message key="eOT.CurrentStage.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<select name='currstage_code' id='currstage_code' onchange='selectstages();getserialno();autopopulatesearch();'>
		<%
	
		sql=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SEARCH_SELECT1");
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,locale);
		rs=pstmt.executeQuery();
		if(rs!=null){
		while (rs.next()){				
		out.print("<option 					value='"+rs.getString("STAGE_CODE1")+"'>"+rs.getString("STAGE_DESC1")+"</option>");
		}
	}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();	
		
		%>
		</select>				
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='label' width='25%' >
		<fmt:message key="eOT.ChangeStage.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<select name='stages' id='stages' onchange='assignchangestages(this);'disabled>
			<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			</option>
		
		</select>				

	</td>
</tr>
<tr>
	<td class='label' width='25%' >
		<fmt:message key="eOT.RearrangeSequence.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<input type='checkbox' class='fields' name='chk_sequence' id='chk_sequence' OnClick="checkValidate(this);">
	</td>
	 <!-- Added new start CRF-0021 -->
	<td class='label' width='25%' >
		<fmt:message key="eOT.AsaScore.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<select name='stages1' id='stages1'> <option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		 <%
			
		pstmt=conn.prepareStatement(sql_asa_score);
		rs=pstmt.executeQuery();
		if(rs!=null){
		while (rs.next()){				
		out.print("<option value='"+rs.getString("ASA_SCORE_CODE")+"'>"+rs.getString("ASA_SCORE_CODE")+"</option>");
		PATIENT_PHYSICAL_STATUS=rs.getString("PATIENT_PHYSICAL_STATUS");
		ASA_SCORE_CODE=rs.getString("ASA_SCORE_CODE");
		}
	
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		
		%>   
		</select>		
	<!-- Added end -->
	<tr>
<!-- Added by MuthuN CHL-CRF-0014 starts -->
	<td class='label' width='25%' >
		<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<select name='patient_class' id='patient_class'> <option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		 <%
			
		pstmt=conn.prepareStatement(sql_patient_class);
		rs=pstmt.executeQuery();
		if(rs!=null){
		while (rs.next()){				
		out.print("<option value='"+rs.getString("patient_class")+"'>"+rs.getString("patient_class")+"</option>");
		patient_class=rs.getString("patient_class");
		}
	
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		
		%>   
		</select>		
	 </td>	
	<!-- Added end -->
	 <td class='button' width='25%' colspan="2"> 
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="validateAll()">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="funReSetAll();">
	</td>
</tr>
<% } else {%>

<tr>
	<td class='label' width='25%' >
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<select name="surgery_type" id="surgery_type" >
		<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
	    <%
		
		pstmt=conn.prepareStatement(sql_surgery_type_waitlist);
		rs=pstmt.executeQuery();
		if(rs!=null){
		while (rs.next()){				
		out.print("<option value='"+rs.getString("NATURE_CODE")+"'>"+rs.getString("SHORT_DESC")+"</option>");
		}
		rs.close();
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		
		%>
		</select>
	</td>
	<td class='label' width='25%' >
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>

	<td class='fields' width='25%' >
		<input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='20' size='20' value= "" onBlur="if(this.value!='')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value=''" >
		<input type='button' class='button' value='?' name='surButton' id='surButton'   onClick="return searchSpeciality(SPECIALITY_DESC);">
	</td> 
</tr>
<tr>
<td class='label' width='25%' >
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<input type='text' class='fields' name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=surgeon1%>" onBlur="if(this.value!='')return searchSurgeon(SURGEON); else  SURGEON_CODE.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="return searchSurgeon(SURGEON);" >
	</td>
	
	<td class='label' width='25%' >
		<fmt:message key="Common.view.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%' >
		<select name="view" id="view" >  
		<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/>
		</option>
		<option value="U" ><fmt:message key="Common.Unassigned.label" bundle="${common_labels}"/> </option>
		<option value="S" ><fmt:message key="Common.Assigned.label" bundle="${common_labels}"/></option>
		</select>  
	</td>
</tr>
<!--Added below part for MOD change by Anitha-->
<tr>
	<td class='label' width='25%' >
	<fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>&nbsp;					<fmt:message key="Common.from.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%' >
	<input type="text" class="fields" name="preferred_from" id="preferred_from" size="10" maxlength=10 value="<%=strSysDate%>"  Onblur="javascript:isValidDate(this);" onkeypress="return checkForSpecCharsforID(event);" >
	<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('preferred_from');" >
	</td><!-- Onblur='CheckDate(this);' Modified Onblur against SKR-SCF-1284 -->
	<td class='label' width='25%' >
	<fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>&nbsp;					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%' >
	<input type="text" class="fields" name="preferred_to" id="preferred_to" size="10" maxlength=10 value="" Onblur="javascript:isValidDate(this);" onkeypress="return checkForSpecCharsforID(event);">
	<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('preferred_to');" >
	</td><!-- Onblur='CheckDate(this);' Modified Onblur against SKR-SCF-1284 -->
</tr>
<!-- MO-CRF 20082 Start-->
<tr>
		<td class='label' width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%" >    
		<!--MO-IN:052629-->
			<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)" onBlur="if(this.value!='')callPatientSearch();else clearPatientName();" value= "" >
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
		</td>
	</td>
			<td class='label' width="25%" >
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>     
		</td>
		<td class='fields' width="25%" >
			<input type='text' name='patient_name' id='patient_name' maxlength='100' size='30' value= "" readOnly><!--IN:053032-->
	</td>
	
</tr>
<!-- MO-CRF-20082 END-->
<!-- end -->
<tr>
	<td width='25%' colspan='3'></td>
	<td class='button' width='25%'>
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="validatewaitlistAll();">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="funReSetwaitlistAll();">
	</td>
</tr>
<% } %>
</table>
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<input type='hidden' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value=''>
<input type='hidden' name='SURGEON_CODE' id='SURGEON_CODE' value=''>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>'>
<input type='hidden' name='theatre_type_code' id='theatre_type_code' value=''>
<input type='hidden' name='sequence' id='sequence' value='N'>
<input type='hidden' name='room_code' id='room_code' value=''>
<input type='hidden' name='system_date' id='system_date' value="<%=strSysDate%>">
<input type="hidden" name="next_stage_code_1" id="next_stage_code_1" value="">
<input type="hidden" name="next_specific_ind_1" id="next_specific_ind_1" value="">
<input type="hidden" name="next_action_done_1" id="next_action_done_1" value=""> 
<input type="hidden" name="next_stage_desc_1" id="next_stage_desc_1" value="">
<input type="hidden" name="previlage_1" id="previlage_1" value="">
<input type='hidden' name='WaitListkey' id='WaitListkey' value='<%=WaitListkey%>'>
<input type='hidden' name='schedulekey' id='schedulekey' value='<%=schedulekey%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='ASA_SCORE_CODE' id='ASA_SCORE_CODE' value="<%=ASA_SCORE_CODE%>">  <!-- added crf -0021-->
</form>
</body>
</html>
<%}catch(Exception e)
{
	e.printStackTrace();

}finally
		{
			try{

				if(rs!=null) rs.close();
				pstmt.close();
			ConnectionManager.returnConnection(conn, request);
			}catch(Exception ee){}
		}%>

