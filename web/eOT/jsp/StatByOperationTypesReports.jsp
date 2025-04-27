<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>                
<% String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");

	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	
	// String  sql_operation_type = "SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE   WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) ORDER BY 2";
	
	String  sql_operation_type = "SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW   WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID ='"+locale+"' ORDER BY 2";

	//String  sql_oper_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";//MMS-QH-CRF-0199

	String  sql_oper_procedure = "SELECT OPER_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";//MMS-QH-CRF-0199

	String sql_time_range = "SELECT TIME_RANGE_CODE, TIME_RANGE_CODE FROM OT_OPER_TIME_RANGE ORDER BY 2";

  
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//surgery_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}

		
	
	}catch(Exception e){
		System.err.println("Err Msg StatByOperationTypesReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 

		
	}
%>

<html>
<head><title></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script>
	var operationType_title=getLabel("eOT.OperationType.Label","ot");
	var procedure_title=getLabel("Common.Procedure.label","common");
</script>

   	<script language="javascript">
	function assignReportId(obj){
		var formObj = document.forms[0];
		var facility_id = formObj.facility_id.value;
		var locale = formObj.locale.value;
		var type=obj.value;

		var theatre_title=getLabel("Common.Theatre.label","common");
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var anaesthetist_title=getLabel("Common.Anaesthetist.label","common");
		var anaesthesia_title=getLabel("Common.Anaesthesia.label","common");
		var speciality_title=getLabel("Common.speciality.label","common");
		if(type=='5'){
			formObj.hidedesc.style.visibility='hidden';
			formObj.hidelookup.style.visibility='hidden';
		}else{
			formObj.hidedesc.style.visibility='visible';
			formObj.hidelookup.style.visibility='visible';
		}
	/*	formObj.time1.value="";
		formObj.time2.value="";
		formObj.time3.value="";
		formObj.time4.value="";
		formObj.time5.value="";
		formObj.time6.value="";
		formObj.time7.value="";
		formObj.time8.value="";
		formObj.time9.value="";
		formObj.time10.value="";
		formObj.param8.value="";
*/
		formObj.CommonLookUp1.disabled=false;
//		formObj.CommonLookUp2.disabled=false;
//		formObj.param8.disabled=true;

		if(type=="1"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			//formObj.param17_desc.value="";
			test.innerHTML=theatre_title;
//			test1.innerHTML="To Theatre ";
			//formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";
			formObj.p_report_id.value="OTRSOTTH";

			formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";
			formObj.p_report_id.value="OTRSOTTH";

		}else if(type=="2"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			//formObj.param17_desc.value="";
			test.innerHTML=surgeon_title;
//			test1.innerHTML="To Surgeon ";
			formObj.qry_sql.value="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID ='"+facility_id+"' AND PRACT_TYPE IN ('MD','SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
			formObj.p_report_id.value="OTRSTOPT";
		}else if(type=="3"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			//formObj.param17_desc.value="";
			test.innerHTML=anaesthetist_title;
//			test1.innerHTML="To Anaesthetist ";
			formObj.qry_sql.value="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID ='"+facility_id+"' AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2"; 
			formObj.p_report_id.value="OTRSTOPT";
		}else if(type=="4"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			//formObj.param17_desc.value="";
			test.innerHTML=anaesthesia_title;
//			test1.innerHTML="To Anaesthesia ";
			formObj.qry_sql.value="SELECT ANAESTHESIA_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_ANAESTHESIA WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ANAESTHESIA_CODE) LIKE UPPER(?) ORDER BY 2"; 
			formObj.p_report_id.value="OTRSOTTH";
		}else if(type=="5"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			//formObj.param17_desc.value="";
			test.innerHTML="";
//			test1.innerHTML="To Theatre ";
			formObj.qry_sql.value=""; 
			formObj.CommonLookUp1.disabled=true;
//			formObj.CommonLookUp2.disabled=true;
//			formObj.param8.disabled=false;
			formObj.p_report_id.value="OTRSTOPT";
		}else if(type=="6"){
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			//formObj.param17_desc.value="";
			test.innerHTML=speciality_title;
//			test1.innerHTML="To Speciality ";
			formObj.qry_sql.value="SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A, AM_SPECIALITY B WHERE A.SPECIALITY_CODE = B.SPECIALITY_CODE AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2"; 
			formObj.p_report_id.value="OTRSOTTH";
		}else{
			formObj.param7.value="";
			formObj.param7_desc.value="";
			formObj.param17.value="";
			//formObj.param17_desc.value="";
			//test.innerHTML=theatre_title;
//			test1.innerHTML="To Theatre ";
			//formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";

			formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";

			formObj.p_report_id.value="OTRSOTTH";
		}
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 -->
  <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
 <table border='0' cellpadding=3  cellspacing='0' width='100%'>
<tr> 
	 <td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/></td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	  <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'  colspan="9">
	
	  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
	  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td colspan='8'></td>
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param10' id='param10' value=""> 
		<input type='hidden' name="param9" id="param9" value=""> 
		<!-- else part is added by DhanasekarV on 23-02-2011 against issue 26582 -->
		<input type='text' name='param9_desc' id='param9_desc' size='20' onBlur="if(this.value!='')srchCommonCode(param9,param9_desc,param10,operationType_title, document.forms[0].sql_text_2.value ); else {param9.value = ''; param10.value='';}"><input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="srchCommonCode(param9,param9_desc,param10,operationType_title, document.forms[0].sql_text_2.value );" >
	
	<!-- <td class='label' align='right'nowrap>To Operation Type</td>
     <td align='left' colspan="9">
		<input type='hidden' name='param10' id='param10' value=""> 
		<input type='text' name='param10_desc' id='param10_desc' size='20'  > 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(param10,param10_desc, 'To Operation Type', document.forms[0].sql_text_2.value );" >
	</td>
	<td align='left' colspan="6"></td> -->

	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%' colspan='4'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="param3" id="param3" value=""> 
		<!-- else part is added by DhanasekarV on 23-02-2011 against issue 26582 -->
		<input type='text' name='param3_desc' id='param3_desc' size='20' onBlur="if(this.value!='')srchCommonCode(param3,param3_desc, param4,procedure_title, document.forms[0].sql_text.value );else {param3.value = ''; param4.value='';}" colspan="2"><input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="srchCommonCode(param3,param3_desc, param4,procedure_title, document.forms[0].sql_text.value );" >
	</td>
 <td colspan='12'></td>
			<!-- 	<td class='label' align='right'nowrap>To Procedure</td>
     <td align='left' colspan="9">
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='text' name='param4_desc' id='param4_desc' size='20'  colspan="2"> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(param4,param4_desc, 'To Procedure', document.forms[0].sql_text.value );" >
	</td>
	<td align='left' colspan="6"></td> -->
</tr>

 <tr> 
	<td class='label' width='25%' ><fmt:message key="eOT.ListOption.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
    <select name="param6" id="param6"  onchange="assignReportId(this);">  
    <option value= "1" > <fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> </option>
    <option value= "2" > <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </option>
    <option value= "3" > <fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </option>
    <option value= "4" > <fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/> </option>
    <option value= "5" > <fmt:message key="Common.duration.label" bundle="${common_labels}"/> </option>
    <option value= "6" > <fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </option>	 
	</td>
	<td class='label' width='25%' id='test'> <!-- <td class='label' align='right' id="test" nowrap> -->
<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%' colspan='4'>
	  <input type='hidden' name='param17' id='param17'>
	  <input type='hidden' name='param7' id='param7'>
	  <input type='text' id='hidedesc' name='param7_desc' id='param7_desc' size='20' onBlur="if(this.value!='')srchCommonCode(param7,param7_desc,param17,param6.options[param6.selectedIndex].text,document.forms[0].qry_sql.value);"><input type='button'  id='hidelookup' class='button' value='?' name='CommonLookUp1' id='CommonLookUp1' onClick="srchCommonCode(param7,param7_desc,param17,param6.options[param6.selectedIndex].text,document.forms[0].qry_sql.value);" >
	 </td>
 <td colspan='12'></td>
			
		<!-- <td class='label' align='right' id="test1" nowrap>To Theatre</td>
	<td align='left'>
	  <input type='hidden' name='param17' id='param17'>
	  <input type='text' name='param17_desc' id='param17_desc' size='20'  >
	    <input type='button' class='button' value='?' name='CommonLookUp2' id='CommonLookUp2' onClick="searchCode(param17,param17_desc,param6.options[param6.selectedIndex].text,document.forms[0].qry_sql.value);" >
	 </td>
	<td align='left' colspan="16"></td> -->

</tr> 

<%--
<tr> 
	<!-- <td class='label' width='25%'><fmt:message key="eOT.TimeRange.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%' colspan="8">
	 <select name="param8" id="param8"  disabled onChange="getTimes(this);">  
		  <option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option> -->
	<%
	try {
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_time_range);
		rst = pstmt.executeQuery();
		while(rst.next()){ %>
		  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option> 
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg StatByOperationTypesReports.jsp "+e.getMessage());
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
</tr>
--%>
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRSOTTH">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRSOTTH">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_operation_type%>" disabled>
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_oper_procedure%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_time_range%>" disabled>
    <!-- <input type="hidden" name="qry_sql" id="qry_sql" value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='<%=facility_id%>' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2" disabled> -->

	<input type="hidden" name="qry_sql" id="qry_sql" value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='<%=locale%>' AND OPERATING_FACILITY_ID ='<%=facility_id%>' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Registration Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param9##Operation Type">
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param10">

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param3##Procedure">
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param4">

 	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param7##Code">
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="param17">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param9#param10#param4#param3#param6#param7#param17#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

 </form>
</body>
</html>

