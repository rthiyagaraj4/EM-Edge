<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                                           
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<%
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String fromoperationdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String bookingstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingStatus.label","common_labels");
	


	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String tat_Req_Yn="N";
	String from_status="";
	String to_status="";
	try{
		con = ConnectionManager.getConnection(request);

		String sql = "SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE,NVL(TAT_RQ_YN,'N') REQ_YN,TAT_FROM_STATUS FROM_STATUS,TAT_TO_STATUS  TO_STATUS FROM OT_PARAM_FOR_FACILITY  where operating_facility_id = '"+facility_id+"'";


		pstmt = con.prepareStatement(sql) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			tat_Req_Yn =  rst.getString("REQ_YN");
			from_status=rst.getString("FROM_STATUS");
			to_status=rst.getString("TO_STATUS");
		}

	}
	catch(Exception e){
		System.err.println("Err Msg TheatreBookingsBySurgeonReports.jsp "+e.getMessage());
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
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<!--<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<script>
function assign_value()
		{
			//alert("assign_value ==> "+document.forms[0].group_by.value);
		    document.forms[0].p_view_by.value = document.forms[0].group_by.value;
		}
</script>

<body OnMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<!--<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">

<% if (tat_Req_Yn.equals ("Y")==true) { %>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align="centre">

<tr> 
	  <td class='label' width='25%'>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	   <td class='fields' width='25%'>
		  <input type='text' name='p_from' id='p_from' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" >   
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p_from');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		 
	 <td class='label' width='25%'>
	 <fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='p_to' id='p_to' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p_to');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	</tr>
									  
<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param1' id='param1' value=""> 
		<input type='hidden' name="param11" id="param11" value=""> 
		<input type='text' name='param11_desc' id='param11_desc' size='20'  title='<%=procedure_title%>' param1 = 'param11'  param2 = 'param1' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param11.value='',param1.value='' " > 
		   <input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param11_desc);" >
	</td>
 	
		 
	<td class='label' width='25%'>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param3' id='param3'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param3'  param2 = 'param5' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param3.value='' "  > 
		   <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
 	
</tr>

<tr>
	<td class='label' width='25%'>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param2' id='param2' >
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' title='<%=surgeon_title%>' param1 = 'param7'  param2 = 'param2' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param2.value='' " > 
		 <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>
 

	<td class="label" width='25%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%'>
			<select name='group_by' id='group_by' value="S" onChange='assign_value(this);'>
				<option value='S'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
				<option value='P'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
				<option value='G'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></option>	
			</select>
			 <img src='../../eCommon/images/mandatory.gif'></img>
		</td>
</tr>
	
	</table>


	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	

	<!--<input type="hidden" name="p_param1" id="p_param1" value ="">
	<input type="hidden" name="p_param2" id="p_param2" value ="">
	<input type="hidden" name="p_param3" id="p_param3" value =""> -->

	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRAVTAT">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRAVTAT">

	<input type="hidden" name="p_from_status_code" id="p_from_status_code" value ="<%=from_status%>">
	<input type="hidden" name="p_to_status_code" id="p_to_status_code" value ="<%=to_status%>">
 	<input type="hidden" name="p_view_by" id="p_view_by"	value="S">

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<!--<input type="hidden" name="p_site_name" id="p_site_name" value ="Brunei Hospital">-->
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="p_from##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="p_to##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="p_from" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="p_to" disabled>

<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param5#p_view_by#p_from_status_code#p_to_status_code#p_from#p_to#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">



	<!--<input type="hidden" name="p_report_id" id="p_report_id" value="OTRAVTAT">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRAVTAT">-->
	

<!--	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>
	<input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param10##<%=bookingstatus%>" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param11##Procedure" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param12" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
-->
  <% } else %>
  <script> alert(getMessage('APP-OT0209','OT'));</script>
   

</form>
</body>
</html>

