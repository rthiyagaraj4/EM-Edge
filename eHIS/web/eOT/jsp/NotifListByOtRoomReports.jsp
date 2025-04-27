<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%
	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");

	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String asst_surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AsstSurgeon.Label","ot_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	String noticedate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.NoticeDate.Label","ot_labels");
	
	
	//String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY ORDER BY 2";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
	ResultSet rst1 = null;
	try{
		con = ConnectionManager.getConnection(request); 						   

		String	sql="SELECT TO_CHAR((SYSDATE+1), 'DD/MM/YYYY') TDATE, TO_CHAR(OT_SEC1_NOTICE_FM_TIME,'hh24:mi') SEC1_FM_TIME1,TO_CHAR(OT_SEC1_NOTICE_TO_TIME,'hh24:mi') SEC1_TO_TIME1,      TO_CHAR(OT_SEC2_NOTICE_FM_TIME,'hh24:mi') SEC2_FM_TIME1,  TO_CHAR(OT_SEC2_NOTICE_TO_TIME,'hh24:mi') SEC2_TO_TIME1,       TO_CHAR(OT_SEC3_NOTICE_FM_TIME,'hh24:mi') SEC3_FM_TIME1,  TO_CHAR(OT_SEC3_NOTICE_TO_TIME,'hh24:mi')SEC3_TO_TIME1  	FROM OT_PARAM_FOR_FACILITY    WHERE OPERATING_FACILITY_ID = ?";
		String sql_patient_type = "SELECT patient_class,  short_desc  FROM am_patient_class_lang_vw WHERE patient_class IN ('IP', 'OP', 'EM', 'XT', 'DC')	and language_id =?";

	    String fdate="";
	    String strSecFr1="";
	    String strSecFr2="";
	    String strSecFr3="";
	    String strSecTo1="";
	    String strSecTo2="";
	    String strSecTo3="";
		
		pstmt = con.prepareStatement(sql) ;
		pstmt.setString(1,facility_id);
		rst = pstmt.executeQuery();

		while(rst.next()){
			//budhist date conversion
			 fdate=com.ehis.util.DateUtils.convertDate(rst.getString("TDATE"),"DMY","en",locale);	
			 strSecFr1=checkForNull(rst.getString("SEC1_FM_TIME1"));
			 strSecFr2=checkForNull(rst.getString("SEC2_FM_TIME1"));
			 strSecFr3=checkForNull(rst.getString("SEC3_FM_TIME1"));
			 strSecTo1=checkForNull(rst.getString("SEC1_TO_TIME1"));
			 strSecTo2=checkForNull(rst.getString("SEC2_TO_TIME1"));
			 strSecTo3=checkForNull(rst.getString("SEC3_TO_TIME1"));
   	   }

		if(rst!=null) 	rst.close();
		pstmt.close();

		pstmt = con.prepareStatement(sql_surgery_type);
		rst = pstmt.executeQuery();
		
		if(rst1!=null) 	rst1.close();
		if(pstmt1!=null)pstmt1.close();

		pstmt1 = con.prepareStatement(sql_patient_type);
		pstmt1.setString(1,locale);
		rst1 = pstmt1.executeQuery();
			 
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
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="Javascript" src="../../eOT/js/OTReportsLkupSQL.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script language="Javascript">
		var locale = "<%= locale %>";
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
Commented against IN057877 -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
      <table border='0' cellpadding=3 cellspacing='0' width='100%'>
      <tr>
    <td class='label' width="19%" nowrap><fmt:message key="eOT.NoticeDate.Label" bundle="${ot_labels}"/></td>
    <td class='fields' colspan="3"><input type='text' name='param1_disp' id='param1_disp' size='8' value='<%=fdate%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
          <img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('param1_disp');"><img src='../../eCommon/images/mandatory.gif'></img> 
          <!-- Added against IN057877 -->
          
          <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(fdate,"DMY",locale,"en")%>'></td>
  </tr>
      <tr>
    <td class='label' width="19%" ><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
    <td class='label' width="25%" nowrap><fmt:message key="eOT.Section1.Label" bundle="${ot_labels}"/></td>
    <td class='label' width="18%" nowrap><fmt:message key="eOT.Section2.Label" bundle="${ot_labels}"/></td>
    <td class='label' width="38%" nowrap><fmt:message key="eOT.Section3.Label" bundle="${ot_labels}"/></td>
  </tr>
      <tr>
    <td class='label' width="19%" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
    <td class='fields' width="25%" ><input type='text' name='section1_from' id='section1_from' size='6' value="<%=strSecFr1%>"  readonly></td>
    <td class='fields' width="18%"><input type='text' name='section2_from' id='section2_from' size='6' value="<%=strSecFr2%>" readonly></td>
    <td class='fields' width="38%"><input type='text' name='section3_from' id='section3_from' size='6' value="<%=strSecFr3%>" readonly></td>
  </tr>
      <tr>
    <td class='label' width="19%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
    <td class='fields' width="25%" ><input type='text' name='section1_to' id='section1_to' size='6' value="<%=strSecTo1%>" readonly></td>
    <td class='fields' width="18%" ><input type='text' name='section2_to' id='section2_to' size='6' value="<%=strSecTo2%>" readonly></td>
    <td class='fields' width="38%" ><input type='text' name='section3_to' id='section3_to' size='6' value="<%=strSecTo3%>" readonly></td>
  </tr>
      <tr>
    <td class='label' width="19%" nowrap><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
    <td class='fields' width="25%" ><input type='hidden' name='param8' id='param8'>
          <input type='hidden' name='param9' id='param9'>
          <input type='text' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param8'  param2 = 'param9' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param8.value='',param9.value='' "  >
          <input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp'  onClick="callCommonLookup(from_oper_room_desc);" ></td>
    <td class='label' width="18%" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
    <td  class='fields' width="38%" ><input type='hidden' name='param14' id='param14'>
          <input type='hidden' name='param15' id='param15'>
          <input type='text' name='from_speciality_desc' id='from_speciality_desc' size='20'  title='<%=speciality_title%>' param1 = 'param14'  param2 = 'param15' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param14.value='',param15.value=''" >
          <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp'     onClick="callCommonLookup(from_speciality_desc);"  ></td>
  </tr>
      <tr>
    <td class='label' width="19%" nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width="25%" ><input type='hidden' name='param17' id='param17'>
          <input type='hidden' name='param16' id='param16'>
          <input type='text' name='param16_desc' id='param16_desc' size='20'title='<%=surgeon_title%>' param1 = 'param16'  param2 = 'param17' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param16.value='',param17.value='' " >
          <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param16_desc);" ></td>
    <td class='label' width="18%" nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
    <!-- ML-MMOH-CRF-0752.3-US001 -->
    <td class='fields' width="38%" ><input type='hidden' name='param10' id='param10' >
          <input type='hidden' name='param11' id='param11' >
          <input type='text' name='from_ward_desc' id='from_ward_desc' size='60' title='<%=ward_title%>' param1 = 'param10'  param2 = 'param11' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param11.value=''" >
        <input type='button' class='button' value='?' name='WardLookUp' id='WardLookUp' onClick="callCommonLookup(from_ward_desc);" ></td>
  </tr>
      <tr>
    <td class='label' width='19%' ><fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/>
          &nbsp;1 </td>
    <td class="fields" width="25%"><input type='hidden' name='param20' id='param20'>
          <input type='hidden' name='param21' id='param21'>
          <input type='text' name='asst_surgeon_name1' id='asst_surgeon_name1' size='20' title='<%=asst_surgeon_title%>' param1 = 'param20'  param2 = 'param21' key ='ASST_SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param21.value='',param20.value=''" >
          <input type='button' class='button' value='?' name='btnAsstSurg1' id='btnAsstSurg1' onClick="callCommonLookup(asst_surgeon_name1);" ></td>
    <td class='label' width='18%' ><fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/>
          &nbsp;2 </td>
    <td class="fields" width="38%"><input type='hidden' name='param18' id='param18'>
          <input type='hidden' name='param19' id='param19'>
          <input type='text' name='asst_surgeon_name2' id='asst_surgeon_name2' size='20' title='<%=asst_surgeon_title%>' param1 = 'param18'  param2 = 'param19' key ='ASST_SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param18.value='',param19.value=''" >
          <input type='button' class='button' value='?' name='btnAsstSurg2' id='btnAsstSurg2' onClick="callCommonLookup(asst_surgeon_name2);" ></td>
  </tr>
      <tr>
    <td class='label' width="19%" nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
    <td class='fields' width="25%" ><select name="param12" id="param12" >
        <option value= "*ALL" >
        <fmt:message key="Common.all.label" bundle="${common_labels}"/>
        </option>
        <% while(rst.next()){ %>
        <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
        <%   }//end of while-loop%>
      </select></td>
    <td class='label' align='left' width="18%" nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
    <td class='fields' width="38%" ><select name="param22" id="param22" >
        <option value="">
        <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
        </option>
        <% while(rst1.next()){ %>
        <option value='<%=rst1.getString(1)%>'> <%=rst1.getString(2)%> </option>
        <%   }
	 }catch(Exception e){
			System.err.println("Err Msg NotifListByOTRoomReport.jsp "+e.getMessage());
		}finally{
			if(rst!=null)rst.close();
			if(rst1!=null)rst1.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request); 
		}%>
      </select></td></tr>
  <tr>
      <td class='label' width="19%"  nowrap><fmt:message key="Common.print.label" bundle="${common_labels}"/></td>
      <td class='fields' width="25%" >
      <select name="param13" id="param13" >
      <option value= "Y" >
  <fmt:message key="eOT.FinalisedBookings.Label" bundle="${ot_labels}"/>
  </option>
      <option value= "N" >
  <fmt:message key="eOT.NonFinalisedBookings.Label" bundle="${ot_labels}"/>
  </option>
      <option value= "A" >
  <fmt:message key="eOT.AllBookings.Label" bundle="${ot_labels}"/>
  </option>
  </select>
      </td>
      <td class='label' width="18%"  nowrap>
      </td>
      <td class='label' width="38%"  nowrap>
      </td>
      </tr>
    
      <input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
      <input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
      <input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
      <input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
      <input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
      <input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
      <input type="hidden" name="p_report_id" id="p_report_id" value="OTROTNRM">
      <input type="hidden" name="pgm_id" id="pgm_id" value="OTROTNRM">
      <input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_surgery_type%>" disabled>
      <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="1" disabled>
      <input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=noticedate%>" disabled>
      <input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
      <input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param8##Operation Room" disabled>
      <input type="hidden" name="compare_to_1" id="compare_to_1" value="param9" disabled>
      <input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param14##Speciality" disabled>
      <input type="hidden" name="compare_to_2" id="compare_to_2" value="param15" disabled>
      <input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param10##Ward" disabled>
      <input type="hidden" name="compare_to_3" id="compare_to_3" value="param11" disabled>
      <input type='hidden' name='locale' id='locale' value="<%=locale%>">
      <input type='hidden' name="p_language_id" id="p_language_id" value="<%=locale%>">
      
      <!-- Added against IN057877 -->
      <input type='hidden' name='reportParams' id='reportParams' value="param1#section1_from#section2_from#section3_from#section1_to#section2_to#section3_to#param8#param9#from_oper_room_desc#param14#param15#from_speciality_desc#param17#param16#param16_desc#param10#param11#param20#param21#asst_surgeon_name1#param18#param19#asst_surgeon_name2#param12#param22#param13#facility_id#p_facility_id#p_user_id#p_user_name#user_id#p_module_id#p_report_id#pgm_id#locale#p_language_id">
      </table>
    </form>
</body>
</html>

