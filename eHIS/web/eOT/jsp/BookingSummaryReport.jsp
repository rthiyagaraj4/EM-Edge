<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	locale=locale.toLowerCase();
//	String surgerytype = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String nursingUnit_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ward.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String bookingdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingDate.label","common_labels");

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
		
	//Code altered by Selvam for PHASE 3 Delivery
	//String  sql_ward = "SELECT A.NURSING_UNIT_CODE CODE, A.SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A WHERE A.LANGUAGE_ID='"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 2";
	String  sql_ward = "SELECT A.NURSING_UNIT_CODE CODE, A.LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A WHERE A.LANGUAGE_ID='"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 2";

	//String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY ORDER BY 2";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  ORDER BY 2";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){

			//Buddhist date conversion (Thai Locale)
			//surgery_date = rst.getString("CURRENT_DATE");
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			
		}
		pstmt.close();
		rst.close();

		pstmt = con.prepareStatement(sql_surgery_type);
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
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
<script language="JavaScript" src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var operationRoom_value=getLabel("eOT.OperationRoom.Label","OT");
	var speciality_value=getLabel("Common.speciality.label","common");
	var nursingUnit_value=getLabel("Common.nursingUnit.label","common");
	var surgeon_title=getLabel("Common.Surgeon.label","Common");
	
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!--<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> Commented against IN057876 -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
  <table border='0' cellpadding='3' align='center' cellspacing='0' width='100%'>
  <tr>
    <td class='label' width='21%' ><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
    <td class='fields' width='42%' ><input type='text' class='fields' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onBlur="isValidDate(this);">
      <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');"><img src='../../eCommon/images/mandatory.gif'></img> 
      <!-- Added against IN057876 -->
      
      <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'></td>
    <td class='label' width='17%' ><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
    <td class='fields' width='20%' ><input type='hidden' name='param8' id='param8' value=''>
      <input type='hidden' name='param9' id='param9' value=''>
      <input type='text' class='fields' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param8'  param2 = 'param9' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param8.value=''">
      <input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp' onClick="callCommonLookup(from_oper_room_desc);"></td>
  </tr>
  <tr>
    <td class='label' width='21%' ><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width='42%'><input type='hidden' name='param17' id='param17'>
      <input type='hidden' name='param16' id='param16'>
      <input type='text' name='param16_desc' id='param16_desc' size='20' title='<%=surgeon_title%>' param1 = 'param16'  param2 = 'param17' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param16.value=''">
      <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param16_desc);" ></td>
    <td class='label' width='17%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
    <td class='fields' width='20%'><input type='hidden' name='param15' id='param15'>
      <input type='hidden' name='param14' id='param14'>
      <input type='text' name='from_speciality_desc' id='from_speciality_desc' size='20' title='<%=speciality_title%>' param1 = 'param14'  param2 = 'param15' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param14.value='';">
      <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp'  onClick="callCommonLookup(from_speciality_desc);"></td>
  </tr>
  <tr>
    <td class='label' width='21%' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
    <td class='fields' width='42%'><input type='hidden' name='param10' id='param10' >
      <input type='hidden' name='param11' id='param11' >
      
      <!-- ML-MMOH-CRF-0752.3-US001 -->
      
      <input type='text' name='from_ward_desc' id='from_ward_desc' size='60' title='<%=nursingUnit_title%>' param1 = 'param10'  param2 = 'param11' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='' ">
      <input type='button' class='button' value='?' name='WardLookUp' id='WardLookUp'   onClick="callCommonLookup(from_ward_desc);"></td>
    <td class='label' width='17%' ><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
    <td class='fields' width='20%' ><input type='hidden' name='param19' id='param19' >
      <select name="param12" id="param12">
        <option value="*ALL" class='fields'>
        <fmt:message key="Common.all.label" bundle="${common_labels}"/>
        </option>
        <% while(rst.next()){ %>
        <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
        <%   }//end of while-loop
		}catch(Exception e){
			System.err.println("Err Msg BookingSummaryReport.jsp "+e.getMessage());
		}finally{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request); 
		}%>
      </select></td>
  </tr>

  <input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
  <input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
  <input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
  <input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
  <input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
  <input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
  <input type="hidden" name="p_report_id" id="p_report_id" value="OTRBKSUM">
  <input type="hidden" name="pgm_id" id="pgm_id" value="OTRBKSUM">
  <input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_surgery_type%>" disabled>
  <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="1" disabled>
  <input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=bookingdate%>" disabled>
  <input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="4" disabled>
  <input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param8##" disabled>
  <input type="hidden" name="compare_to_1" id="compare_to_1" value="param9" disabled>
  <input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param14##" disabled>
  <input type="hidden" name="compare_to_2" id="compare_to_2" value="param15" disabled>
  <input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param10##" disabled>
  <input type="hidden" name="compare_to_3" id="compare_to_3" value="param11" disabled>
  <input type="hidden" name="compare_fm_4" id="compare_fm_4" value="param16##" disabled>
  <input type="hidden" name="compare_to_4" id="compare_to_4" value="param17" disabled>
  <input type='hidden' name='locale' id='locale' value="<%=locale%>">
  <input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
  
  <!-- Added against IN057876 -->
  <input type='hidden' name='reportParams' id='reportParams' value="param1#param8#param9#from_oper_room_desc#param17#param16#param16_desc#param15#param14#from_speciality_desc#param10#param11#param19#param12#facility_id#p_facility_id#p_user_id#p_user_name#user_id#p_module_id#p_report_id#pgm_id#locale#p_language_id#param7_desc#param7">
  <input type="hidden" name="param7_desc" id="param7_desc"	value="" >
  <input type="hidden" name="param7" id="param7"	value="" >
  </table>
</form>
</body>
</html>

