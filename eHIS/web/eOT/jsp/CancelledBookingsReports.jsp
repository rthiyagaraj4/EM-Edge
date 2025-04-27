<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<%

	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String frombookingdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromBookingDate.Label","ot_labels");
	String tobookingdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToBookingDate.Label","ot_labels");
	String surgerytype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String surgery_date = "";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";
	
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
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		
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
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<!-- <script src="../../eOT/js/OTMessages.js" ></script> -->
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
  <table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
  <tr>
    <td class='label' width='21%'><fmt:message key="eOT.FromBookingDate.Label" bundle="${ot_labels}"/></td>
    <!--057884 starts-->
    <td class='fields' width='18%'><input type='text' name='p1_disp' id='p1_disp' size='8'  value='<%=surgery_date%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
      <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p1_disp');"><img src='../../eCommon/images/mandatory.gif'></img>
      <input type='hidden' name='p1' id='p1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'></td>
    <td class='label' width="21%" nowrap><fmt:message key="eOT.ToBookingDate.Label" bundle="${ot_labels}"/></td>
    <td class='fields' width='40%'><input type='text' name='p2_disp' id='p2_disp' size='8'  value='<%=surgery_date%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
      <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p2_disp');"> <img src='../../eCommon/images/mandatory.gif'></img>
      <input type='hidden' name='p2' id='p2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'></td>
    <!--057884 ends--> 
  </tr>
  <tr>
    <td class='label' width='21%'><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
    <td class='fields' width='18%'><input type='hidden' name='p4' id='p4'>
      <input type='hidden' name='p3' id='p3'>
      <input type='text' name='p3_desc' id='p3_desc' size='20' title='<%=operationRoom_title%>' param1 = 'p3'  param2 = 'p4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else p3.value='',p4.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(p3_desc);" ></td>
    
    <!-- <td class='label' align='right'nowrap>To Operation Room&nbsp;</td>
     <td align='left'>
		<input type='hidden' name='p4' id='p4'> 
		<input type='text' name='p4_desc' id='p4_desc' size='20' > 
		 <input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="searchCode(p4,p4_desc,'To Operation Room', document.forms[0].sql_text_1.value);" >
	</td> -->
    <td class='label' width='21%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
    <td class='fields' width='40%'><input type='hidden' name='p8' id='p8'>
      <input type='hidden' name='p7' id='p7'>
      <input type='text' name='p7_desc' id='p7_desc' size='20'  title='<%=speciality_title%>' param1 = 'p7'  param2 = 'p8' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else p7.value='',p8.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(p7_desc);" ></td>
    
    <!-- 	<td class='label' align='right' nowrap>To Speciality &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='p8' id='p8'> 
		<input type='text' name='p8_desc' id='p8_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(p8,p8_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td>
 --></tr>
  <tr>
    <td class='label' width='21%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width='18%'><input type='hidden' name='p10' id='p10'>
      <input type='hidden' name='p9' id='p9'>
      <input type='text' name='p9_desc' id='p9_desc' size='20' title='<%=surgeon_title%>' param1 = 'p9'  param2 = 'p10' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else p9.value='',p10.value='' "  maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(p9_desc);" ></td>
    <!--<td class='label' align='right' nowrap>To Surgeon &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='p10' id='p10'> 
		<input type='text' name='p10_desc' id='p10_desc' size='20' > 
		 <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(p10,p10_desc, 'To Surgeon', document.forms[0].sql_text_3.value);" >
	 </td>-->
    
    <td class='label' width='21%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
    <td class='fields' width='40%'><input type='hidden' name='p12' id='p12' >
      <input type='hidden' name='p11' id='p11' >
      
      <!-- ML-MMOH-CRF-0752.3-US001 -->
      
      <input type='text' name='p11_desc' id='p11_desc' size='67' title='<%=surgeon_title%>' param1 = 'p11'  param2 = 'p12' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this); else p11.value='',p12.value=''" maxlength='70' onKeyPress="return CheckForSpecChars_local(event);">
      <input type='button' class='button' value='?' name='FrmWardLookUp' id='FrmWardLookUp' onClick="callCommonLookup(p11_desc);" ></td>
    
    <!-- 	<td class='label' align='right' nowrap>To Ward &nbsp;</td>
	 <td align='left'>
	     <input type='hidden' name='p12' id='p12' > 
		  <input type='text' name='p12_desc' id='p12_desc' size='20' > 
		    <input type='button' class='button' value='?' name='ToWardLookUp' id='ToWardLookUp' onClick="searchCode(p12,p12_desc, 'To Ward', document.forms[0].sql_text_4.value);" >
	 </td>
 --></tr>
  <tr>
    <td class='label' width='21%'><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
    <td class='fields' width='18%'><select name="p6" id="p6" >
        <option value="" >
        <fmt:message key="Common.all.label" bundle="${common_labels}"/>
        </option>
        <% while(rst.next()){ %>
        <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
        <%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg OperationListReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%>
      </select>
      <img src='../../eCommon/images/mandatory.gif'></img></td>
    <td colspan='2'></td>
  </tr>
  <input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
  <input type="hidden" name="P_facility_id" id="P_facility_id"	value="<%=facility_id%>">
  <input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
  <input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
  <input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
  <input type="hidden" name="p_report_id" id="p_report_id" value="OTRCNBKG">
  <input type="hidden" name="pgm_id" id="pgm_id" value="OTRCNBKG">
  <input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
  <input type="hidden" name="sql_text" id="sql_text" value="<%=sql_surgery_type%>" disabled>
  <input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
  <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
  <input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="p1##<%=frombookingdate%>" disabled>
  <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="p2##<%=tobookingdate%>" disabled>
  <input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="p6##<%=surgerytype%>" disabled>
  <input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
  <input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="p1##Booking Date" disabled>
  <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="p2" disabled>
  <input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
  <input type="hidden" name="compare_fm_1" id="compare_fm_1" value="p3##Operation Room" disabled>
  <input type="hidden" name="compare_to_1" id="compare_to_1" value="p4" disabled>
  <input type="hidden" name="compare_fm_2" id="compare_fm_2" value="p7##Speciality" disabled>
  <input type="hidden" name="compare_to_2" id="compare_to_2" value="p8" disabled>
  <input type="hidden" name="compare_fm_3" id="compare_fm_3" value="p11##Ward" disabled>
  <input type="hidden" name="compare_to_3" id="compare_to_3" value="p12" disabled>
  <input type='hidden' name='locale' id='locale' value="<%=locale%>">
  <input type='hidden' name='reportParams' id='reportParams' value="p1#p2#p3#p4#p7#p8#p9#p10#p11#p12#p6#P_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">
  </table>
</form>

</body>
</html>

