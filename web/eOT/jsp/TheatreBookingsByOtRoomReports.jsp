<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<%
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	String frombookingdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromBookingDate.Label","ot_labels");
	String tobookingdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToBookingDate.Label","ot_labels");
	String bookingstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingStatus.label","common_labels");

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String sql_veri_status = "SELECT STAGE_CODE, PRE_STAGE_DESC FROM OT_BOOKING_FIN_STAGES_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ORDER BY 2";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	Boolean isRescheduledAppl = false; //Added for ML-MMOH-CRF-1696-US001

	try{
		con = ConnectionManager.getConnection(request);

		isRescheduledAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "RESCHEDULED_BKNG_BY_OR"); //Added for ML-MMOH-CRF-1696-US001

		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		pstmt = con.prepareStatement(sql_veri_status);
		rst = pstmt.executeQuery();
%>
<html>
<head>
<title></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
  <table border='0' cellpadding='3' cellspacing='0' width='100%' align="centre">
  <tr>
    <td class='label' width='19%'><fmt:message key="eOT.FromBookingDate.Label" bundle="${ot_labels}"/></td>
    <td class='fields' width='23%'><input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
      <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');"> <img src='../../eCommon/images/mandatory.gif'></img> 
      <!-- Added against IN057880 -->
      
      <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'></td>
    <td class='label' width='16%'><fmt:message key="eOT.ToBookingDate.Label" bundle="${ot_labels}"/></td>
    <td class='fields' width='42%'><input type='text' name='param2_disp' id='param2_disp' size='8'  value='<%=surgery_date%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
      <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2_disp');"> <img src='../../eCommon/images/mandatory.gif'></img> 
      <!-- Added against IN057880 -->
      
      <input type='hidden' name='param2' id='param2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'></td>
  </tr>
  <tr>
    <td class='label' width='19%'><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
    <td class='fields' width='23%'><input type='hidden' name='param4' id='param4' value="">
      <input type='hidden' name="param3" id="param3" value="">
      <input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param3_desc);" ></td>
    <!-- <td class='label' align='right'nowrap>To Operation Room&nbsp;</td>
     <td align='left'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='text' name='param4_desc' id='param4_desc' size='30' > 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(param4,param4_desc, 'To Operation Room', document.forms[0].sql_text.value );" >
	</td> -->
    <td class='label' width='16%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
    <td class='fields' width='42%'><input type='hidden' name='param6' id='param6'>
      <input type='hidden' name='param5' id='param5'>
      <input type='text' name='param5_desc' id='param5_desc' size='20'   title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" ></td>
    <!-- <td class='label' align='right' nowrap>To Speciality &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='15' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param6,param6_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td> --> 
  </tr>
  <tr>
    <td class='label' width='19%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width='23%'><input type='hidden' name='param8' id='param8' value='' >
      <input type='hidden' name='param7' id='param7' value=''>
      <input type='text' name='param7_desc' id='param7_desc' size='20' title='<%=surgeon_title%>' param1 = 'param7'  param2 = 'param8' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value=''  " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param7_desc);"></td>
    <!-- 	<td class='label' align='right' nowrap>To Surgeon &nbsp;</td>
	 <td align='left'>--> 
    
    <!-- 		<input type='text' name='param8_desc' id='param8_desc' size='15' > 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(param8,param8_desc, 'To Surgeon', document.forms[0].sql_text_3.value);" > -->
    
    <td class='label' width='16%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
    <td class='fields' width='42%'><input type='hidden' name='param10' id='param10' value=''>
      <input type='hidden' name='param9' id='param9'>
      
      <!-- ML-MMOH-CRF-0752.3-US001 -->
      
      <input type='text' name='param9_desc' id='param9_desc' size='67' title='<%=ward_title%>' param1 = 'param9'  param2 = 'param10' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param9_desc);" ></td>
    
    <!-- 	<td class='label' align='right' nowrap>To Ward &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param10' id='param10' value=''> 
		<input type='text' name='param10_desc' id='param10_desc' size='15' value=''> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(param10,param10_desc, 'To Ward', document.forms[0].sql_text_1.value);" >

	 </td>
 --></tr>
  <tr>
  <td class='label' width='19%'><fmt:message key="Common.BookingStatus.label" bundle="${common_labels}"/></td>
  <td class='fields' width='23%'><!--<select name="param12" id="param12" >  -->
    
    <select name="param11" id="param11" >
      <option value="" >
      <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
      </option>
      <option value="0" >
      <fmt:message key="Common.active.label" bundle="${common_labels}"/>
      </option>
      <option value="1" >
      <fmt:message key="eOT.Registeredforoperation.Label" bundle="${ot_labels}"/>
      </option>
      <option value="2" >
      <fmt:message key="Common.NoShows.label" bundle="${common_labels}"/>
      </option>
      <option value="9" >
      <fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>
      </option>

	  <!-- Added by Arthi for ML-MMOH-CRF-1696-US001-->
	  <%if(isRescheduledAppl){%>
	  <option value="10" >
      <fmt:message key="eOT.Reschdl.Label" bundle="${ot_labels}"/>
      </option>
	  <%}%>
	  <!-- End ML-MMOH-CRF-1696-US001-->
    </select>
    <img src='../../eCommon/images/mandatory.gif'></img></td>
  <td class='label' width='16%'><fmt:message key="Common.VerificationStatus.label" bundle="${common_labels}"/></td>
  <td class='fields' width='42%'>
  <!--<select name="param11" id="param11" >   -->
  <select name="param12" id="param12" >
  <option value="">
  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
  </option>
  <% while(rst.next()){ %>
  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
 
  <%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg TheatreBkgByOtRoomReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%> </select>
  </td>
  </tr>
  <input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>" >
  <input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>" >
  <input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>" >
  <input type="hidden" name="p_module_id" id="p_module_id"  value="OT" >
  <input type="hidden" name="p_report_id" id="p_report_id" value="OTRORBKG" >
  <input type="hidden" name="pgm_id" id="pgm_id" value="OTRORBKG" >
  <input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>" >
  <input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
  <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="3" disabled>
  <input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=frombookingdate%>" disabled>
  <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tobookingdate%>" disabled>
  <!--	<input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param12##<%=bookingstatus%>" disabled>-->
  <input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param11##<%=bookingstatus%>" disabled>
  <input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
  <input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Booking Date" disabled>
  <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
  <input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
  <input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Operation Room" disabled>
  <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>
  <input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality">
  <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6">
  <input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param9##Ward">
  <input type="hidden" name="compare_to_3" id="compare_to_3" value="param10">
  <input type='hidden' name='locale' id='locale' value="<%=locale%>">
  <input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param3#param4#param5#param6#param7#param8#param9#param10#param11#param12#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#p_language_id">
  </table>
</form>
</body>
</html>

