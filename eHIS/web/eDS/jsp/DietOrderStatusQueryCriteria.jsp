<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0423 -->
<%@ page import="webbeans.eCommon.ConnectionManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="eDS.Common.DlQuery"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% request.setCharacterEncoding("UTF-8");%>
<%			
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");
 %>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/DietOrderStatus.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript'>
	function clearSource(){
		var frmObj=document.forms[0];
		frmObj.wardClinic_code.value='';
		frmObj.wardDesc.value='';
		frmObj.changed_wardClinic.value='';
	}

	function changeSourceType(){
	clearSource();
	patient_type_code=document.forms[0].patient_type_code.value;
	var val=document.getElementById("Patient_Class").value;
	var patient_type_code1=patient_type_code.split("$$");
	if(val==""){
		document.getElementById("wardClinic").value="";
		document.getElementById("wardClinicDesc").value =""; 
		document.getElementById("wardClinic").disabled=true;			
	}

	if(val=='DC'||val=='IP'){
		document.getElementById("wardClinic").value="W";
		document.getElementById("wardClinicDesc").value=getLabel("Common.nursingUnit.label","Common");
		document.getElementById("wardClinic").disabled=true;		
	}

	if(val=='EM'||val=='OP'){
		document.getElementById("wardClinic").value="C";
		document.getElementById("wardClinicDesc").value=getLabel("Common.clinic.label","Common");
		document.getElementById("wardClinic").disabled=true;		
	}
		document.getElementById("changed_wardClinic").value=document.getElementById("wardClinic").value;
		document.getElementById("changed_wardClinicDesc").value=document.getElementById("wardClinicDesc").value;
	}

	function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patient_id.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")

	formObj.patient_name.value="";
	formObj.sex.value="";	
	formObj.date_of_birth.value="";

	formObj.encounter_id.value="";
	formObj.episode_id.value="";
	formObj.visitid.value="";
	clearSource();
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="getSysDate()">
	<form name="DietOrderStatusQueryCriteria" id="DietOrderStatusQueryCriteria">
<%
	String strReferalWardClinic="",wardClinicDesc="",strRefWardClinicCode="",strReferalDesc="",patient_type_code="";
 %>
	<br/>
	<br/>
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>

<% 
	try{
		con = ConnectionManager.getConnection(request);
		String sql_patient_class="SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 1";
		pstmt = con.prepareStatement(sql_patient_class);
		rst = pstmt.executeQuery();
%>
	<tr>
	<!-- Patient Class for Diet order Status-->
		<td align="right" class="label" >
			<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
		</td>
		<td>
			<select name="Patient_Class" id="Patient_Class" onChange='changeSourceType();'>
				<option value="">
					<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				</option>
				
				<%while(rst.next()) {
				if(!rst.getString(1).equalsIgnoreCase("XT"))
				{
					patient_type_code=patient_type_code+rst.getString(1)+"$$";
				%>
					<option value="<%=rst.getString(1)%>">
					<%=rst.getString(2) %>
					</option>
				<%}}
				  if(rst !=null) rst.close();
				  if(pstmt !=null) pstmt.close();
				%>
					
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<!-- Ward/Clinic for Diet order Status-->
		<td align="right" class="label">
			<fmt:message key="eDS.WardClinic.Label" bundle="${ds_labels}"/>
		</td>
		
		<td class='fields'>
		<input type='hidden' name='wardClinic' id='wardClinic'  DB_VALUE='<%=strReferalWardClinic%>' value='<%=strReferalWardClinic%>'  >
		<input type='text' name='wardClinicDesc' id='wardClinicDesc' size='10'  value="<%=wardClinicDesc%>" disabled>
		<!-- ML-MMOH-CRF-0752.7-US001 -->
		<input type='text' name='wardClinic_code' id='wardClinic_code' size='67' maxlength ='60' value='<%=strReferalDesc%>' onBlur="if(this.value!='') searchWardClinicSelect(wardClinic_code);else callclear();">
		<input type='button' class='button' name='quest6' id='quest6' value='?' onClick="searchWardClinicSelect(wardClinic_code)">
		<div id='more_img' style='position:absolute;visibility:hidden;'>
		<img src='../../eCommon/images/mandatory.gif'></img></div>
		</td>

		<!--ServingDate for Diet order Status-->
		<td align="right" class="label">
			<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
		</td>
		<td>
			<input type ="text" size="10" name="servDate" id="servDate" value="" onkeypress="return checkForSpecCharsforID(event);" maxlength=10 onblur='isValidDate(this);'>
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('servDate');">	
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
<%}
	catch(Exception e){
		System.err.println("Exception in DietOrderStatus:"+e);
		e.printStackTrace();
	}
	finally{
		try{
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
			ConnectionManager.returnConnection(con);
		}
		catch(Exception e){
			System.err.println("Exception in DietOrderStatus:"+e);
			e.printStackTrace();
		}
	}
%>
	</table>
	<br/>
	<table width="100%">
		<tr>
			<td width="40%"></td>
			<td width="25%"></td>
			<td width="25%"></td>
			<td width="10%" colspan='6' align="right" class="label">
				<input type="button" class='BUTTON' name="select" id="select" value='<fmt:message key="Common.Select.label" bundle="${common_labels}"/>' onclick="submitForm();"/>
			</td>
		</tr>
	</table>
	<input type='hidden' name = 'locale' id = 'locale' value = '<%=locale%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='changed_wardClinic' id='changed_wardClinic'  value='<%=strReferalWardClinic%>'  >
	<input type='hidden' name='changed_wardClinicDesc' id='changed_wardClinicDesc'  value=''  >
	<input type='hidden' name='wardDesc' id='wardDesc' value='<%=strRefWardClinicCode%>'>
	<input type='hidden' name='HLongRefWdId' id='HLongRefWdId' value="">
	<input type='hidden' name='patient_type_code' id='patient_type_code' value='<%=patient_type_code%>' >
	<input type='hidden' name = 'currentDate' id = 'currentDate' value = ''>
		</form>
	</body>
</html>

