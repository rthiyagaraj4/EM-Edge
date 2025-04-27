<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>               
<% String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title></title>
	<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>

<script>
		
		var speciality_title=getLabel("Common.speciality.label","common");
		var procedure_title=getLabel("Common.Procedure.label","common");

function checkProcess(obj){

	var frmObj=document.forms[0];
	frmObj.param20.value="";
	if(obj.checked==true)
	{
		 frmObj.param18.value='Y';
		 frmObj.p_report_id.value='OTRSTOSG';
		 frmObj.pgm_id.value='OTRSTOSG';

//Suma, 07/06/2010, Statistics by Speciality report issue
		var len = frmObj.param6.length;
		var val = frmObj.param6.value;
		for (var i=len;i>-1;i--)
		{
			frmObj.param6.remove(i); 
		}
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var anaesthetist_title=getLabel("Common.Anaesthetist.label","Common");
		var element = document.createElement('OPTION'); 
		element.text = surgeon_title;
		element.value= '2';
		frmObj.param6.add(element);
		var element = document.createElement('OPTION');
		element.text = anaesthetist_title;
		element.value= '3';
		frmObj.param6.add(element);
		if(val=='2'||val=='3')
			frmObj.param6.value = val;
		else
			assignReportId(frmObj.param6);
			/////////////////////////////////////
		 
	}
	else
	{
		 frmObj.param18.value='N';
		 frmObj.p_report_id.value='OTRSTOPG';
		 frmObj.pgm_id.value='OTRSTOPG';
		 		//Suma, 07/06/2010, Statistics by Speciality report issue
		var len = frmObj.param6.length;
		var val = frmObj.param6.value;

		var theatre_title=getLabel("Common.Theatre.label","Common");
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var anaesthetist_title=getLabel("Common.Anaesthetist.label","Common");
		var anaesthesia_title=getLabel("Common.Anaesthesia.label","Common");
		var duration=getLabel("Common.duration.label","Common");
		var operationType_title=getLabel("eOT.OperationType.Label","ot");



		for (var i=len;i>-1;i--)
		{
			frmObj.param6.remove(i); 
		}
		var element = document.createElement('OPTION'); 
		element.text = theatre_title;
		element.value= '1';
		frmObj.param6.add(element);
		var element = document.createElement('OPTION'); 
		element.text = surgeon_title;
		element.value= '2';
		frmObj.param6.add(element);
		var element = document.createElement('OPTION');
		element.text = anaesthetist_title;
		element.value= '3';
		frmObj.param6.add(element);
		var element = document.createElement('OPTION'); 
		element.text = anaesthesia_title;
		element.value= '4';
		frmObj.param6.add(element);
		var element = document.createElement('OPTION');
		element.text =duration;
		element.value= '5';
		frmObj.param6.add(element);
		var element = document.createElement('OPTION');
		element.text = operationType_title;
		element.value= '6';
		frmObj.param6.add(element);
		frmObj.param6.value = val;
		frmObj.param6.selectedIndex=0;
		//Modified by DhanasekarV on 22/02/2011 against incident IN026582
		assignReportId();
		/////////////////////////////////////
		 
	}

}
</script>

<script language="javascript">
	function assignReportId(){
		var formObj = document.forms[0];
		var facility_id = formObj.facility_id.value;
		var locale = formObj.locale.value;
		var type= formObj.param6.value;
		var theatre_title=getLabel("Common.Theatre.label","Common");
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var anaesthetist_title=getLabel("Common.Anaesthetist.label","Common");
		var anaesthesia_title=getLabel("Common.Anaesthesia.label","Common");
		var operationType_title=getLabel("eOT.OperationType.Label","ot");
		if(type=='5'){
			formObj.param7_desc.style.visibility='hidden';
			formObj.CommonLookUp1.style.visibility='hidden';
		}else{
			formObj.param7_desc.style.visibility='visible';
			formObj.CommonLookUp1.style.visibility='visible';
		}
		if(type=="1"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
//			formObj.param17_desc.value="";
			test.innerHTML="Theatre ";
			test.innerHTML=theatre_title;

//			test1.innerHTML="To Theatre ";
			//formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";

			formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";
		}else if(type=="2"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			formObj.param20.value="";
//			formObj.param17_desc.value="";
			//test.innerHTML="Surgeon ";
			test.innerHTML=surgeon_title;
//			test1.innerHTML="To Surgeon ";
			formObj.qry_sql.value="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID ='"+facility_id+"' AND PRACT_TYPE IN ('MD','SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
		}else if(type=="3"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			formObj.param20.value="";
//			formObj.param17_desc.value="";
			//test.innerHTML="Anaesthetist ";
			test.innerHTML=anaesthetist_title;
//			test1.innerHTML="To Anaesthetist ";
			formObj.qry_sql.value="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID ='"+facility_id+"' AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2"; 
		}else if(type=="4"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			formObj.param20.value="";
//			formObj.param17_desc.value="";
			//test.innerHTML="Anaesthesia ";
			test.innerHTML=anaesthesia_title;
//			test1.innerHTML="To Anaesthesia ";
			formObj.qry_sql.value="SELECT ANAESTHESIA_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_ANAESTHESIA WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ANAESTHESIA_CODE) LIKE UPPER(?) ORDER BY 2"; 
		}else if(type=="5"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			formObj.param20.value="";
			//test.innerHTML="Theatre ";
			test.innerHTML="";
			formObj.qry_sql.value=""; 
		}else if(type=="6"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			formObj.param20.value="";
//			formObj.param17_desc.value="";
			//test.innerHTML="OperationType";
			test.innerHTML=operationType_title;
//			test1.innerHTML="To Operation Type ";
			
			// formObj.qry_sql.value="SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) ORDER BY 2"; 
            
			formObj.qry_sql.value="SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID ='"+formObj.locale.value+"' ORDER BY 2"; 

		}else{
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			formObj.param20.value="";
//			formObj.param17_desc.value="";
			test.innerHTML="Theatre ";
			//test.innerHTML=theatre_title;
//			test1.innerHTML="To Theatre ";

			//formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";

			formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";
		}
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String fromregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromRegistrationDate.Label","ot_labels");
	String toregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToRegistrationDate.Label","ot_labels");

	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	
	// String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE WHERE ROLE_TYPE IN ('OS', 'AS') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY 2";

	String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ROLE_TYPE IN ('OS', 'AS') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY 2";

	String  sql_oper_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
	String sql_time_range = "SELECT TIME_RANGE_CODE, TIME_RANGE_CODE FROM OT_OPER_TIME_RANGE ORDER BY 2";

  
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//Buddhist date conversion (Thai Locale)
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("MON_YEAR"),"MY","en",locale);
			//surgery_date = rst.getString("CURRENT_DATE");
		}

		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		pstmt = con.prepareStatement(sql_time_range);
		rst = pstmt.executeQuery();
	
%>
<body  onload='assignReportId()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 -->
 <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
 <table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromRegistrationMonth.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='5'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);"  maxlength='7'> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1','mm/y');"><img src='../../eCommon/images/mandatory.gif'></img>(MM/YYYY)
	 </td>
	 <td class='label' width='25%'><fmt:message key="eOT.ToRegistrationMonth.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='5'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);"  maxlength='7'>
		 <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2','mm/y');"><img src='../../eCommon/images/mandatory.gif'></img>(MM/YYYY)
	 </td>
	 <td colspan='8'></td>
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param10' id='param10' value=""> 
		<input type='hidden' name="param9" id="param9" value=""> 
		<input type='text' name='param9_desc' id='param9_desc' size='20' title='<%=speciality_title%>' param1 = 'param9'  param2 = 'param10' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value='' ">
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param9_desc);" >
	</td>
	<!-- <td class='label' align='right'nowrap>To Speciality</td>
     <td align='left' colspan="9">
		<input type='hidden' name='param10' id='param10' value=""> 
		<input type='text' name='param10_desc' id='param10_desc' size='20'  > 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(param10,param10_desc, 'To Speciality', document.forms[0].sql_text_2.value );" >
	</td>
	<td align='left' colspan="6"></td> -->

	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%' colspan='6'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="param3" id="param3" value=""> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=procedure_title%>' param1 = 'param3'  param2 = 'param4' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " colspan="2">
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
 <td colspan='3'></td>
	<!-- <td class='label' align='right'nowrap>To Procedure</td>
     <td align='left' colspan="9">
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='text' name='param4_desc' id='param4_desc' size='20'  colspan="2"> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(param4,param4_desc, 'To Procedure', document.forms[0].sql_text.value );" >
	</td>
	<td align='left' colspan="6"></td> -->
</tr>

 <tr> 
	<td class='label' width='25%'><fmt:message key="eOT.ListOption.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
    <select name="param6" id="param6"  onchange="assignReportId();">  
    <option value= "1" > <fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> </option>
    <option value= "2" > <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </option>
    <option value= "3" > <fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </option>
    <option value= "4" > <fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/> </option>
    <option value= "5" > <fmt:message key="Common.duration.label" bundle="${common_labels}"/> </option>
    <option value= "6" > <fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/> </option>	 
	</td>

  <td class='label' width='25%' id="test"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%' colspan='6'>
	  <input type='hidden' name='param17' id='param17'>
	  <input type='hidden' name='param7' id='param7'>
	  <input type='text' name='param7_desc' id='param7_desc'  size='20' onBlur="if(this.value!='')srchCommonCode(param7,param7_desc,param17,param6.options[param6.selectedIndex].text,document.forms[0].qry_sql.value);else param7.value='',param17.value=''">
	    <input type='button' class='button' value='?' name='CommonLookUp1' id='CommonLookUp1' onClick="srchCommonCode(param7,param7_desc,param17,param6.options[param6.selectedIndex].text,document.forms[0].qry_sql.value);" >
	 </td>
<td colspan='3'></td> 
	<!-- 	<td class='label' align='right' id="test1" nowrap>To Theatre</td>
	<td align='left'>
	  <input type='hidden' name='param17' id='param17'>
	  <input type='text' name='param17_desc' id='param17_desc' size='20'  >
	    <input type='button' class='button' value='?' name='CommonLookUp2' id='CommonLookUp2' onClick="searchCode(param17,param17_desc,param6.options[param6.selectedIndex].text,document.forms[0].qry_sql.value);" >
	 </td>
	<td align='left' colspan="16"></td> -->

</tr> 

 <tr> 
	<td class='label' width='25%' nowrap><fmt:message key="eOT.BySurgeonsPrimarySpeciality.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
	<input type ='checkbox' name ='param20' onClick='checkProcess(this)'>
	</td>

  <td class='label' width='25%'></td>
	<td class='fields' width='25%' colspan='6'> </td>
<td colspan='3'></td> 

</tr> 

<!-- <tr> 
	<td class='label' width='25%'><fmt:message key="eOT.TimeRange.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%' colspan="8">
	 <select name="param8" id="param8"  disabled onChange="getTimes(this);">  
		  <option value='' selected> ------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
	<% 
	while(rst.next()){ %>
		  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg StatisticsBySpecialityReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%>
	 </select>
		<input type='text' name='time1' id='time1' size='3.5' readonly>
	    <input type='text' name='time2' id='time2' size='3.5' readonly>
	    <input type='text' name='time3' id='time3' size='3.5' readonly>
	    <input type='text' name='time4' id='time4' size='3.5' readonly>
	    <input type='text' name='time5' id='time5' size='3.5' readonly>
	    <input type='text' name='time6' id='time6' size='3.5' readonly>
	    <input type='text' name='time7' id='time7' size='3.5' readonly>
	    <input type='text' name='time8' id='time8' size='3.5' readonly>
	    <input type='text' name='time9' id='time9' size='3.5' readonly>
	    <input type='text' name='time10' id='time10' size='3.5' readonly>
	</td>
	<td align='left' colspan="10"></td>
</tr> -->

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRSTOPG">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRSTOPG">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_speciality%>" disabled>
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_role_type%>" disabled>
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_oper_procedure%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_time_range%>" disabled>
   <!--  <input type="hidden" name="qry_sql" id="qry_sql" value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='<%=facility_id%>' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2" disabled> -->

   <input type="hidden" name="qry_sql" id="qry_sql" value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='<%=locale%>' AND OPERATING_FACILITY_ID ='<%=facility_id%>' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2" disabled>

	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromregistrationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=toregistrationdate%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Registration Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param9##Operation Type">
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param10">

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param3##Procedure">
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param4">

 	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param7##Code">
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="param17">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='cur_date' id='cur_date' value="<%=surgery_date%>">
	<input type="hidden" name="param18" id="param18" value="N" >
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param9#param10#param4#param3#param6#param7#param17#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

 </form>
</body>
</html>

