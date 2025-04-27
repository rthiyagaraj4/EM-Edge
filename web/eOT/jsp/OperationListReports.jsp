<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% String locale = (String)session.getAttribute("LOCALE");
   locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>               
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		   
<%



	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String Speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String Ward_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ward.label","common_labels");
	String operationdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDate.Label","ot_labels");
	
	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
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
	}
	catch(Exception e){
		System.err.println("Err Msg OperationListReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
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
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="JavaScript" src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<!--57890 starts-->
<tr> 
	  <td class='label' width="25%" nowrap>
		<fmt:message key="eOT.OperationDate.Label" bundle="${ot_labels}"/>
		</td>
	  <td class ="fields" width="25%" >
		  <input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
	 	 <td colspan='2'></td>
	 </tr>
<!--57890 ends-->
<tr>
	<td class='label' width="25%" >
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
	</td>
     <td class ="fields" width="25%" >
		<input type='hidden' name='param10' id='param10'> 
		<input type='hidden' name='param9' id='param9'> 
		<input type='text' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param9'  param2 = 'param10' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value='' "> 
		<input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp' onClick="callCommonLookup(from_oper_room_desc);" >
	</td>
	<td class='label' width="25%"nowrap>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width="25%" >
		<input type='hidden' name='param8' id='param8'> 
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='from_speciality_desc' id='from_speciality_desc' size='20' title='<%=Speciality_title%>' param1 = 'param7'  param2 = 'param8' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' "  > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(from_speciality_desc);" >
	</td>

</tr>

<tr>
	<td class='label' width="30%"nowrap>
	<fmt:message key="Common.Ward.label" bundle="${common_labels}"/>	
	</td>
     <td class="fields" width="30%" >
	    <input type='hidden' name='param5' id='param5' > 
		<input type='hidden' name='param4' id='param4' >
		<!-- ML-MMOH-CRF-0752.3-US001 -->
		<input type='text' name='from_ward_desc' id='from_ward_desc' size='67' title='<%=Ward_title%>' param1 = 'param4'  param2 = 'param5' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this); else param4.value='',param5.value='' " > 
		<input type='button' class='button' value='?' name='WardLookUp' id='WardLookUp'
		onClick="callCommonLookup(from_ward_desc);" >
	</td>
	  <td class='label' width="20%" nowrap>
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/> 
	</td>
	  <td class='fields' width="20%">
		  <select name="param6" id="param6" >  
		  <option value="*ALL" >
			<fmt:message key="Common.all.label" bundle="${common_labels}"/>
			</option>
		  <option value="*ALLEM" >
		<fmt:message key="eOT.AllEmergency.Label" bundle="${ot_labels}"/> </option>
		 <option value="*ALLEL" >
		 <fmt:message key="eOT.AllElective.Label" bundle="${ot_labels}"/> </option>
		 </select>
	 </td>
	 <td colspan='2'></td>
</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROPLST">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROPLST">
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="1" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=operationdate%>" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param9##Operation Room" disabled>
	<input type="hidden" name="compare_to_1" id="compare_to_1" value="param10" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param7##Speciality" disabled>
	<input type="hidden" name="compare_to_2" id="compare_to_2" value="param8" disabled>

	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param4##Ward" disabled>
	<input type="hidden" name="compare_to_3" id="compare_to_3" value="param5" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param10#param9#param7#param8#param4#param5#param6#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

