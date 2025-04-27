<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>       
<% String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	String reportperiodicity= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ReportPeriodicity.Label","ot_labels");
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	if(facility_id == null) facility_id="";
//	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_surgeon = "SELECT PRACTITIONER_ID CODE, SHORT_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY UPPER(SHORT_DESC)";
	String  sql_position = "SELECT A.POSITION_CODE CODE, A.POSITION_DESC DESCRIPTION FROM AM_POSITION_LANG_VW A  WHERE A.LANGUAGE_ID='"+locale+"' AND UPPER(A.POSITION_DESC) LIKE UPPER(?) AND UPPER(A.POSITION_CODE) LIKE UPPER(?) ORDER BY 2";
	String function_id = request.getParameter("function_id");
  
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String year="";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//Buddhist date conversion (Thai Locale)			
			//surgery_date = rst.getString("CURRENT_DATE");
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}

		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
 		pstmt = con.prepareStatement(sql_surgery_type);
		rst = pstmt.executeQuery();

/*	}
	catch(Exception e){
		System.err.println("Err Msg SummaryOfOperByOtRoomReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
 */

 // Year Calculation
year = surgery_date.substring(surgery_date.length()-4,surgery_date.length()); // substring when format is dd/mm/yyyy. Added by Bhavani
%>

<html>
<head><title></title>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/CommonLookup.js"></script>

	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
<!-- 	<script src="../../eOT/js/OTMessages.js" ></script>
	<script src="../../eCommon/js/messages.js" ></script> -->
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="Javascript" src="../../eOT/js/SurgeonsOperTimeStatReports.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm'  action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> 
 -->
 <form name='OtReportOptionsForm' id='OtReportOptionsForm'>
 <table border='0' cellpadding='3' cellspacing='0' width='100%'>

<tr>
      			<td  class='label' width='30%'><fmt:message key="eOT.ReportPeriodicity.Label" bundle="${ot_labels}"/></td>
      			<td align='left'  width='30%'>
				<select name='P_PERIODICITY' id='P_PERIODICITY' onChange='funPeriodicity()'><option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option><option value='D' ><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></option><option value='M' ><fmt:message key="Common.monthly.label" bundle="${common_labels}"/><option value='Q'><fmt:message key="eOT.Quarterly.Label" bundle="${ot_labels}"/><option value='B'><fmt:message key="eOT.BiAnnually.Label" bundle="${ot_labels}"/><option value='A'><fmt:message key="eOT.Annually.Label" bundle="${ot_labels}"/></select>
		   		<img align='center' src='../../eCommon/images/mandatory.gif'></img>
		   		</td>
			<td  colspan='2' width='40%'>		
			</tr>
<tr>
	<td  align='left' class=label nowrap><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>

	<td align='left' >

	<input type='text' name='P_FROM_YEAR' id='P_FROM_YEAR' value='<%=year%>'  size=10 maxlength=4>

	<select name='P_FROM' id='P_FROM'>
	<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	</select>   		

	<img src='../../eCommon/images/mandatory.gif' id='hide'>
	</td>

		<td  align='left' class=label><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td  colspan='2'>
		<input type='text' name='P_TO_YEAR' id='P_TO_YEAR' value='<%=year%>'   size=10 maxlength=4>

		<select name='P_TO' id='P_TO'  OnChange='check_to_date(this);'>
		<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
		</select>   
		<img src='../../eCommon/images/mandatory.gif' id='periodto_list_hide'>			
		</td>	
	</tr>

<tr> 
	  <td class='label' align='left' nowrap><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/></td>
	  <td align='left'>
		  <input type='text' name='param1' id='param1' size='8'  value='' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" disabled> <img id='img1' src='../../eCommon/images/CommonCalendar.gif' onClick=" dummy('param1');" > <img id='f_mand' src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	  <td class='label' align='left' nowrap><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/></td>
	  <td align='left'>
		  <input type='text' name='param2' id='param2' size='8'  value='' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" disabled> <img id='img2' src='../../eCommon/images/CommonCalendar.gif' onClick=" dummy('param2');" > <img id='t_mand' src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td colspan='2'></td>
</tr>

<tr>
	<td  class='label' align='left'nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
     <td  align='left'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' onBlur="if(this.value!='') return searchSurgeon(param3,param3_desc, param4, 'Surgeon', document.forms[0].sql_text_1.value );else param3.value='' "> 
		   <input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="searchSurgeon(param3,param3_desc, param4, 'Surgeon', document.forms[0].sql_text_1.value );" >

	<td class='label' align='left'nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
     <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
				<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=procedure_title%>' param1 = 'param5'  param2 = 'param6' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else callClearParam(param5,param6)" colspan="2">
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
</tr>

<tr>
	<td class='label' align='left'nowrap><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
     <td align='left'>
		 <input type='hidden' name='param8' id='param8'> 
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' onBlur="if(this.value!='')  srchCommonCode(param7,param7_desc,param8,'Position',document.forms[0].sql_text_3.value); else callClearParam(param7,param8)" > 
		<input type='button' class='button' value='?' name='PositionLookUp' id='PositionLookUp' onClick="srchCommonCode(param7,param7_desc,param8,'Position',document.forms[0].sql_text_3.value);" >
	</td>
	<td class='label' align='left' nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
	<td align='left'>
	 <select name="param9" id="param9" >  
	 <option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<% while(rst.next()){ %>
		  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg SurgeonsOperTimeStatReports.jsp "+e.getMessage());
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
	<input type="hidden" name="function_id1" id="function_id1"	value="<%=function_id%>">
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRSOTST">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRSOTST">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_procedure%>" disabled>
	<input type="hidden" name="p_date" id="p_date" value="<%=surgery_date%>" disabled>
	<input type="hidden" name="locale" id="locale" value="<%=locale%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>
<!-- 	<input type="hidden" name="mandatory_1" id="mandatory_1" value="P_FROM##From" disabled>  -->
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="P_PERIODICITY##<%=reportperiodicity%>" disabled> 
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">


	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="0" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="1" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param5##Procedure" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param6" disabled>
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_position%>" disabled>
	<input type="hidden" name="year" id="year" value="<%=year%>" disabled>
<!--  <input type='hidden' name='reportParams' id='reportParams' value="P_PERIODICITY#P_FROM_YEAR#P_TO_YEAR#P_FROM#P_TO#param4#param3#param6#param5#param7#param8#param9#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">
 -->
</form>
</body>
</html>

