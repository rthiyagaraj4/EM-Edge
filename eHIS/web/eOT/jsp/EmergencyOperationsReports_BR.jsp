<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" %>            
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>   
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String procedure_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' 	AND NATURE_TYPE = 'EM'  ORDER BY 2";
	String surgery_date = "";
	PreparedStatement pstmt_sm_report_display = null; //lakshmi
	ResultSet rst_sm_report_display=null; //lakshmi
	String customer_id="";//lakshmi
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
		if(pstmt!=null)pstmt.close();
		if(rst!=null)rst.close();
		pstmt = con.prepareStatement(sql_surgery_type);
		rst = pstmt.executeQuery();		
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
	<script language="javascript" src="../../eOT/js/OTReportsLkupSQL.js"> </script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	var operationRoom_title=getLabel("eOT.OperationRoom.Label","OT");
	var speciality_title=getLabel("Common.speciality.label","common");
	var surgeon_title=getLabel("Common.Surgeon.label","Common");

		</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm'>
<table border='0' cellpadding=3  cellspacing='0' width='100%'>

<tr> 
	  <td class='label' width='25%'>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> 
	  </td>
	  <td class='fields' width='25%'>
	  <!-- Added against 57895 Starts -->
		  <input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
		
	  <td class='label' width='25%'>
		<fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> 
	  </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2_disp' id='param2_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2_disp');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param2' id='param2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	<!-- Added against 57895 Ends -->
	 </td>	
</tr>


<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/> 
	</td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM_ER' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param3_desc);"  >
	</td>
		
<!-- 	<td class='label' align='right' nowrap>To Operation Room &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param4,param4_desc, 'To Operation Room', document.forms[0].sql_text_2.value);" >
	 </td> -->

	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY_ER' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
	

<!-- 	<td class='label' align='right' nowrap>To Speciality &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param6,param6_desc, 'To Speciality', document.forms[0].sql_text_1.value);" >
	 </td> -->
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
	    <input type='hidden' name='param8' id='param8' value=''>
		<input type='hidden' name='param7' id='param7' value=''> 
		<!--<input type='text' name='param7_desc' id='param7_desc' value='' size='20'title='<%=speciality_title%>' param1 = 'param7'  param2 = 'param8' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> --> <!-- Commented by lakshmi against IN033101 -->

		<!-- Modified by lakshmi against IN033101 -->
		<input type='text' name='param7_desc' id='param7_desc' value='' size='20'title='<%=surgeon_title%>' param1 = 'param7'  param2 = 'param8' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>
	
	<!--<td class='label' align='right' nowrap>To Surgeon &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' > 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(param8,param8_desc, 'To Surgeon', document.forms[0].sql_text_3.value);" >-->
	<td class='label' width='25%'>
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
	 <select name="param9" id="param9" >  
	<option value= "*ALL" >
		<fmt:message key="Common.all.label" bundle="${common_labels}"/> </option> 
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
	 </td>
</tr>
<tr>
    <td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%' colspan='3'>
		 <input type='hidden' name='param11' id='param11'> 
		<input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param10_desc' id='param10_desc' size='20'  maxlength='70' title='<%=procedure_title%>' param1 = 'param10'  param2 = 'param11' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param11.value=''" onkeypress="return CheckForSpecChars_local(event);"> 
		   <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param10_desc);" >
	</td>
</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTREMGOP">

	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTREMGOP">
    
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="4" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Operation Room" disabled>
	<input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
	<input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>
    	
	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param9##Surgery Type" disabled>
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="param9" disabled>
	
	<input type="hidden" name="compare_fm_4" id="compare_fm_4" value="param10##Procedure" disabled>
	<input type="hidden" name="compare_to_4" id="compare_to_4" value="param11" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

