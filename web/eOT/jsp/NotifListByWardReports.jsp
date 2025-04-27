<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import  ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*"  %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
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
<script language="JavaScript" src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/Booking.js"></script><!--vikash-->
</head>
<%
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");

	//Session Values....
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");

	//Bundle Messages...
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String asst_surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AsstSurgeon.Label","ot_labels");//newly added by rajesh on 09/10
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	String noticedate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.NoticeDate.Label","ot_labels");
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID=? ORDER BY 2";
	//DB Resource Initialization....
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
try{
	con = ConnectionManager.getConnection(request);
	String sql_date = "SELECT to_char((sysdate+1),'dd/mm/yyyy') f_date from dual";
	String tdate="";
	
	pstmt = con.prepareStatement(sql_date);
	rst = pstmt.executeQuery();

	while(rst.next()){
		 tdate=rst.getString("f_date");
		 tdate=com.ehis.util.DateUtils.convertDate(tdate,"DMY","en",locale);	
	}

	pstmt = con.prepareStatement(sql_surgery_type);
	pstmt.setString(1,locale);
	rst = pstmt.executeQuery(); 						   
%>
<script language="Javascript">
	var locale = "<%= locale %>";
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
  <table border='0' cellpadding=3  cellspacing='0' width='100%'>
	<tr>
		<td class='label' width="21%"  nowrap>
			<fmt:message key="eOT.NoticeDate.Label" bundle="${ot_labels}"/>
		</td>
		<td class='fields' width="23%" >
			<input type='text' name='param1_disp' id='param1_disp' size='8' maxlength='10' value="<%=tdate%>" onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');">
			<img src='../../eCommon/images/mandatory.gif'>
			</img> 
			<!-- Added against IN057878 -->
			<input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(tdate,"DMY",locale,"en")%>'></td>
		<td class='fields' colspan='2'>&nbsp;</td>
	</tr>
  
	<tr>
		<td class='label' width="21%" nowrap>
			<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="23%" ><input type='hidden' name='param2' id='param2'>
			<input type='hidden' name='param3' id='param3'>
			<input type='text' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param2'  param2 = 'param3' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else {document.forms[0].param2.value='';document.forms[0].param3.value='';} ">
			<!-- Modified by Muthukumar against IN028639 on 08/09/2011 -->

			<input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp'   onClick="callCommonLookup(from_oper_room_desc);" >
		</td>
		<td class='label' width="17%" nowrap>
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="39%" ><input type='hidden' name='param7' id='param7'>
			<input type='hidden' name='param8' id='param8'>
			<input type='text' name='from_speciality_desc' id='from_speciality_desc' size='20' title='<%=speciality_title%>' param1 = 'param7'  param2 = 'param8' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param8.value='',param7.value='' " >
			<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp'  onClick="callCommonLookup(from_speciality_desc);" >
		</td>
	</tr>

	<tr>
		<td class='label' width="21%"  nowrap>
			<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="23%" ><input type='hidden' name='param10' id='param10'>
			<input type='hidden' name='param9' id='param9'>
			<input type='text' name='param9_desc' id='param9_desc' size='20' title='<%=surgeon_title%>' param1 = 'param9'  param2 = 'param10' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param9.value='' " >
			<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param9_desc);" >
		</td>
		<td class='label' width='17%' >
			<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/>
		&nbsp;1 
		</td>
		<td class="fields" width="39%"><input type='hidden' name='param14' id='param14'>
			<input type='hidden' name='param15' id='param15'>
			<input type='text' name='asst_surgeon_name1' id='asst_surgeon_name1' size='20' title='<%=asst_surgeon_title%>' param1 = 'param14'  param2 = 'param15' key ='ASST_SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param15.value='',param14.value=''" >
			<input type='button' class='button' value='?' name='btnAsstSurg1' id='btnAsstSurg1' onClick="callCommonLookup(asst_surgeon_name1);" >
		</td>
	</tr>

	<tr>
		<td class='label' width='21%' >
			<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/>
			&nbsp;2 
		</td>
		<td class="fields" width="23%"><input type='hidden' name='param16' id='param16'>
			<input type='hidden' name='param17' id='param17'>
			<input type='text' name='asst_surgeon_name2' id='asst_surgeon_name2' size='20' title='<%=asst_surgeon_title%>' param1 = 'param16'  param2 = 'param17' key ='ASST_SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param17.value='',param16.value=''" >
			<input type='button' class='button' value='?' name='btnAsstSurg2' id='btnAsstSurg2' onClick="callCommonLookup(asst_surgeon_name2);" >
		</td>
		<td class='label' width="17%" nowrap>
			<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
		</td>
		<!-- ML-MMOH-CRF-0752.3-US001 -->
		<td class='fields' width="39%" ><input type='hidden' name='param4' id='param4' >
			<input type='hidden' name='param5' id='param5' >
			<input type='text' name='from_ward_desc' id='from_ward_desc' size='67' title='<%=ward_title%>' param1 = 'param4'  param2 = 'param5' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this);else param5.value='',param4.value=''">
			<input type='button' class='button' value='?' name='WardLookUp' id='WardLookUp'  onClick="callCommonLookup(from_ward_desc);" >
		</td>
	</tr>

	<tr>
		<td class='label' width="21%"  nowrap>
			<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="23%" >
			<select name="param12" id="param12" >
			  <option value= "*ALL" >
			  <fmt:message key="Common.all.label" bundle="${common_labels}"/>
			  </option>
			  <% while(rst.next()){ %>
				<option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
			  <% }//end of while-loop
					if(rst!=null)rst.close();
					if(pstmt!=null) pstmt.close();
				}catch(Exception e){
					System.err.println("Err Msg NotificationListByWardReport.jsp "+e.getMessage());
				}finally{
					if(rst!=null)rst.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null)
					ConnectionManager.returnConnection(con,request); 
				}%>
			</select>
		</td>
		<td class='label' width="17%"  nowrap>
			<fmt:message key="Common.print.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="39%" >
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
	</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROTNWR">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROTNWR">

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="1" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=noticedate%>" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param2##Operation Room" disabled>
	<input type="hidden" name="compare_to_1" id="compare_to_1" value="param3" disabled>
	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param7##Speciality" disabled>
	<input type="hidden" name="compare_to_2" id="compare_to_2" value="param8" disabled>
	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param4##Ward" disabled>
	<input type="hidden" name="compare_to_3" id="compare_to_3" value="param5" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name="p_language_id" id="p_language_id" value="<%=locale%>">

	<!-- Added against IN057878 -->
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param3#from_oper_room_desc#param7#param8#from_speciality_desc#param10#param9#param9_desc#param14#param15#asst_surgeon_name1#param16#param17#asst_surgeon_name2#param4#param5#param12#param13#facility_id#p_facility_id#p_user_id#p_user_name#user_id#p_module_id#p_report_id#pgm_id#locale#p_language_id">
  </table>
</form>
</body>
</html>

