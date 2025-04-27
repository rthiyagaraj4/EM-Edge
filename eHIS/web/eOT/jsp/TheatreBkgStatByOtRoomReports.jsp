<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>           

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOT/js/OtReports.js"> </script>
	<script language="javascript" src="../../eOT/js/OTReportsLkupSQL.js"> </script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String operationRoom_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	String bookingdate=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingDate.label","common_labels");

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();

	String booking_date = "";
	if(facility_id == null) facility_id="";
	//String SQL = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY ORDER BY 2";
	String SQL = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  ORDER BY 2";
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
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(SQL);
		rst = pstmt.executeQuery();
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%' align="centre">
<tr> 
		<!--57887 starts-->
	  <td class='label' width='17%'>
		<fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/>
	  </td>
	  <td class='fields' width='40%'>
		  <input type='text' name='param1_disp' id='param1_disp' size='8' value='<%=booking_date%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"  maxlength='10'>
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');"> <img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(booking_date,"DMY",locale,"en")%>'>
	 </td>
	 <!--57887 ends-->
	<td class='label' width='18%'>
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width='25%'>
	    <input type='hidden' name='param12' id='param12'> 
		<input type='hidden' name='param11' id='param11'> 
		<input type='text' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param11'  param2 = 'param12' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param11.value='',param12.value=''  " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		 <input type='button' class='button' value='?' name='FrmOperRoomLookUp' id='FrmOperRoomLookUp' onClick="callCommonLookup(from_oper_room_desc);" >
	</td>
	

<!-- 	<td class='label' align='right' nowrap>To Operation Room &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param3' id='param3'> 
		<input type='text' name='to_oper_room_desc' id='to_oper_room_desc' size='20'  > 
		 <input type='button' class='button' value='?' name='ToOperRoomLookUp' id='ToOperRoomLookUp' onClick="searchCode(param3,to_oper_room_desc,'Operation Rooms',document.forms[0].qry_oper_room.value);">
	</td>
 --></tr>

<tr>
	<td class='label' width='17%'>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='40%'>
		<input type='hidden' name='param8' id='param8'> 
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='from_speciality_desc' id='from_speciality_desc' size='20' title='<%=speciality_title%>' param1 = 'param7'  param2 = 'param8' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='FrmSpecialityLookUp' id='FrmSpecialityLookUp' onClick="callCommonLookup(from_speciality_desc);" >
	</td>
	

<!-- 	<td class='label' align='right' nowrap>To Speciality &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param8' id='param8'> 
		<input type='text' name='to_speciality_desc' id='to_speciality_desc' size='20' > 
		<input type='button' class='button' value='?' name='ToSpecialityLookUp' id='ToSpecialityLookUp' onClick="searchCode(param8,to_speciality_desc,'Speciality',document.forms[0].qry_speciality.value);" >

	 </td>
 -->

	 <td class='label' width='18%'>
		 <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
		</td>
     <td class='fields' width='25%'>
	    <input type='hidden' name='param10' id='param10'>
		<input type='hidden' name='param9' id='param9'> 
		<input type='text' name='from_surgeon_desc' id='from_surgeon_desc' size='20' title='<%=surgeon_title%>' param1 = 'param9'  param2 = 'param10' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='FrmSurgeonLookUp' id='FrmSurgeonLookUp' onClick="callCommonLookup(from_surgeon_desc);" >
	</td>
	<!--<td class='label' align='right' nowrap>To Surgeon &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param10' id='param10'> 
		<input type='text' name='to_surgeon_desc' id='to_surgeon_desc' size='20' > 
		<input type='button' class='button' value='?' name='ToSurgeonLookUp' id='ToSurgeonLookUp' onClick="searchCode(param10,to_surgeon_desc,'Surgeon',document.forms[0].qry_surgeon.value);" >
	 </td>-->
</tr>
<tr>
	<td class='label' width='17%'>
		<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width='40%'>
	    <input type='hidden' name='param5' id='param5' > 
		<input type='hidden' name='param4' id='param4' > 
		<!-- ML-MMOH-CRF-0752.3-US001 -->
		<input type='text' name='from_ward_desc' id='from_ward_desc' size='67' title='<%=ward_title%>' param1 = 'param4'  param2 = 'param5' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this); else param4.value='',param5.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='FrmWardLookUp' id='FrmWardLookUp' onClick="callCommonLookup(from_ward_desc);" >
	</td>

<!-- 	<td class='label' align='right' nowrap>To Ward &nbsp;</td>
	 <td align='left'>
	     <input type='hidden' name='param5' id='param5' > 
		  <input type='text' name='to_ward_desc' id='to_ward_desc' size='20' > 
		  <input type='button' class='button' value='?' name='ToWardLookUp' id='ToWardLookUp' onClick="searchCode(param5,to_ward_desc,'Ward',document.forms[0].qry_ward.value);" >
	 </td>
 -->
	<td class='label' width='18%'>
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
	 <select name="param6" id="param6" >  
	 <option value="">
		<fmt:message key="Common.all.label" bundle="${common_labels}"/>
	</option>
    <% while(rst.next()){ %>
	  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> 
	</option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg TheatreBkgStatByOtRoomReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%>
	 </select>
	 <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
 </tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="P_facility_id" id="P_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRORBKS">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRORBKS">
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="1" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=bookingdate%>" disabled>
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="0" disabled>
    <input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param11##Operation Room" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param12" disabled>
	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param7##Speciality" disabled>
	<input type="hidden" name="compare_to_2" id="compare_to_2" value="param8" disabled>
	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param4##Ward" disabled>
	<input type="hidden" name="compare_to_3" id="compare_to_3" value="param5" disabled>
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param11#param12#param7#param8#param9#param10#param4#param5#param6#P_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">
    </table>
</form>
</body>
</html>

