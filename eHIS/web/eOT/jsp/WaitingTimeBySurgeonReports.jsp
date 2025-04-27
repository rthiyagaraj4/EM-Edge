<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                   
 <% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>                

<html>
 <head>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String fromdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdate.label","common_labels");
	String todate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.todate.label","common_labels");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOT/js/OtReports.js"> </script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript">
	function assignReportId(obj){
		var formObj = document.forms[0];
		var facility_id=formObj.facility_id.value;
		var type=obj.value;
	
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var speciality_title=getLabel("Common.speciality.label","Common");
		var procedure_title=getLabel("Common.Procedure.label","Common");
		var procedures_title=getLabel("eOT.Procedure(s).Label","ot");

		if(type=="S"){
			formObj.param4.value="";
			formObj.param4_desc.value="";
			//test.innerHTML="Surgeon ";
			test.innerHTML=surgeon_title;
			//formObj.header.value="Surgeons "
			formObj.header.value=surgeon_title;
			formObj.p_report_id.value="OTRWTTSR";
			formObj.pgm_id.value="OTRWTTSR";
			formObj.qry_sql.value="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID ='"+facility_id+"' AND PRACT_TYPE IN ('MD','SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
		}else if(type=="P"){
			formObj.param4.value="";
			formObj.param4_desc.value="";
			//test.innerHTML="Procedure ";
			test.innerHTML=procedure_title;
			//formObj.header.value="Procedures ";
			formObj.header.value=procedures_title;
			formObj.p_report_id.value="OTRWTTOP";
			formObj.pgm_id.value="OTRWTTOP";
			//formObj.qry_sql.value="SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
			formObj.qry_sql.value="SELECT OPER_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";//MMS-QH-CRF-0199 
		}else{
			formObj.param4.value="";
			formObj.param4_desc.value="";
			//test.innerHTML="Speciality ";
			test.innerHTML=speciality_title;
			//formObj.header.value="Specialities"
			formObj.header.value=speciality_title;
			formObj.p_report_id.value="OTRWTTSY";
			formObj.pgm_id.value="OTRWTTSY";
			formObj.qry_sql.value="SELECT  B.SHORT_DESC DESCRIPTION, A.SPECIALITY_CODE CODE FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE = B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
		}
	}


	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	//String queryString = request.getQueryString();
	String booking_date = "";
	if(facility_id == null) facility_id="";
//String SQL = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY ORDER BY 2";
//String SQL = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG ORDER BY 2";


	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){

			//booking_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			booking_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	}catch(Exception e){
		System.err.println("Err Msg WaitingTimeBySurgeonReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
%>

<body OnMouseDown="CodeArrest()">
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<!--57889 starts-->
<tr> 
	  <td class='label' width='25%'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1_disp' id='param1_disp' size='8' value='<%=booking_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');"> <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(booking_date,"DMY",locale,"en")%>'>
	 </td>
	 <td class='label' width='25%'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param11_disp' id='param11_disp' size='8' value='<%=booking_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param11_disp');"> <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param11' id='param11' value='<%=DateUtils.convertDate(booking_date,"DMY",locale,"en")%>'>
	 </td>
</tr>
<!--57889 ends-->
<tr> 
	<td class='label' width='25%'><fmt:message key="eOT.WaitingTimeBy.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
	 <select name="type" id="type" onchange="assignReportId(this);">  
		  <option value='S'> <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </option>
		  <option value='P'> <fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> </option>
		  <option value='Y'> <fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </option>
	 </select>
	  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <!--<td colspan='2'></td>-->
	 <td class='label' width='25%' id='test'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'>
	  <input type='hidden' name='param4' id='param4'>
	  <input type='text' name='param4_desc' id='param4_desc' size='20' onBlur="if(this.value!='')searchCode(param4,param4_desc,document.forms[0].header.value,document.forms[0].qry_sql.value); else param4.value='' ">
	    <input type='button' class='button' value='?' name='CommonLookUp' id='CommonLookUp' onClick="searchCode(param4,param4_desc,document.forms[0].header.value,document.forms[0].qry_sql.value);" >
		
	 </td>
</tr>
<tr> 
	 <td class='label' width='25%' ><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
	<td align='left'>
	
	 <select name="param6" id="param6" >  
		  <option value='O'><fmt:message key="eOT.OrderDateVsApptDate.Label" bundle="${ot_labels}"/></option>
		  <option value='A'><fmt:message key="eOT.FirstScheduleDateVsReScheduledDate.Label" bundle="${ot_labels}"/></option>
	 </select>
	 
	 </td>
<td> <img src='../../eCommon/images/mandatory.gif'></img> </td> <td> </td>
</tr> 
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="P_facility_id" id="P_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRWTTSR">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRWTTSR">
	<input type="hidden" name="header" id="header" value="">
    <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2"> 
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param11##<%=todate%>" disabled>
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Booking Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param11" disabled>
    <!-- Commented by Sanjay for IN:26619 on 28-Jun-2011
	<input type="hidden" name="qry_sql" id="qry_sql" value="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '<%=facility_id%>' AND PRACT_TYPE IN ('MD','SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2" disabled>
	-->
	<!-- Below SQL modified by Sanjay for IN:26619 on 28-Jun-2011 -->
	<input type="hidden" name="qry_sql" id="qry_sql" value="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST_LANG_VW WHERE LANGUAGE_ID = '<%=locale%>' AND FACILITY_ID = '<%=facility_id%>' AND PRACT_TYPE IN ('MD','SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2" disabled> 
	<!-- Changes for IN:26619 ends -->
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param11#type#param4#param6#P_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">


</form>
</body>
</html>




