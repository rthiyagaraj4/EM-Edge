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
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String opertype_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationType.Label","ot_labels");
	String procedure_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String nurse_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nurse.label","common_labels");
	String roleType_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");
	String surgery_date = "";
	//commented and added below query on 12/8/2010 for report issue 
	//String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ROLE_TYPE IN ('OS', 'AS') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY 2";
	String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ROLE_TYPE IN ('NS') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY 2";
	//String  sql_role_type = "SELECT B.ROLE_ID CODE,ROLE_DESC DESCRIPTION FROM OT_PRACT_TYPES_FOR_ROLE_TYPE A,OT_ROLES_LANG_VW B WHERE	  A.ROLE_TYPE = B.ROLE_TYPE AND PRACT_TYPE ='NS' AND B.LANGUAGE_ID='en' AND APPL_TO_OT_SLATE ='N' AND UPPER(ROLE_DESC) LIKE UPPER(?) AND UPPER(ROLE_ID) LIKE UPPER(?) ORDER BY 2";
	//String  sql_role_type = "SELECT B.ROLE_ID CODE,ROLE_DESC DESCRIPTION FROM OT_PRACT_TYPES_FOR_ROLE_TYPE A,OT_ROLES_LANG_VW B WHERE	  A.ROLE_TYPE = B.ROLE_TYPE AND PRACT_TYPE ='NS' AND B.LANGUAGE_ID='en' AND APPL_TO_OT_SLATE ='N'  ORDER BY 2";
	

	String  sql_roles = "SELECT A.ROLE_ID CODE, A.ROLE_DESC DESCRIPTION FROM OT_ROLES_LANG_VW A  WHERE LANGUAGE_ID='"+locale+"' AND ROLE_TYPE IN ('OS', 'AS') AND ROLE_TYPE = nvl('@@',ROLE_TYPE) AND UPPER(A.ROLE_DESC) LIKE UPPER(?) AND UPPER(A.ROLE_ID) LIKE UPPER(?)ORDER BY 2";


	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_lang_vw where language_id = ? ORDER BY 2";
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
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		pstmt = con.prepareStatement(sql_surgery_type);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();

		//pstmt_role_type = con.prepareStatement(sql_role_type);
		//rst_role_type = pstmt_role_type.executeQuery();

%>

<html>
<head><title></title>
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
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var speciality_title=getLabel("Common.speciality.label","Common");
		var operationType_title=getLabel("eOT.OperationType.Label","ot");
		var procedure_title=getLabel("Common.Procedure.label","Common");
		var roleType_title=getLabel("Common.RoleType.label","Common");
		var role_title=getLabel("Common.Role.label","Common");
</script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 commented on 2/18/2011 by Anitha-->
 <form name='OtReportOptionsForm' id='OtReportOptionsForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	  <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td colspan='2'></td>
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param3' id='param3' value=""> 
		<input type='hidden' name="param4" id="param4" value=""> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' title='<%=procedure_title%>' param1 = 'param3'  param2 = 'param4' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param4_desc);" >
	</td>
	<td class='label' width='25%'><fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param5' id='param5'> 
		<input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='20' title='<%=opertype_title%>' param1 = 'param5'  param2 = 'param6' key ='OPER_TYPE' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param6_desc);" >
	</td>
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.nurse.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param7' id='param7' value=""> 
		<input type='hidden' name="param8" id="param8" value=""> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' title='<%=nurse_title%>' param1 = 'param7'  param2 = 'param8' key ='NURSE' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param8_desc);" >
	</td>
	<td class='label' width='25%'><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		<select name="param9" id="param9" >  
			<option value= "" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<% while(rst.next()){ %>
			  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
		<%   }//end of while-loop
            }catch(Exception e){
				System.err.println("Err Msg SummaryOfOperBySurgeonReports.jsp "+e.getMessage());
			}finally{
				if(rst!=null)rst.close();
				if(rst!=null)pstmt.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }
		%>
		</select>
	</td>
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
	<!--  <td class='fields' width='25%'>
		<input type='hidden' name='param10' id='param10'> 
		<input type='hidden' name='param11' id='param11'> 
		<input type='text' name='param11_desc' id='param11_desc' size='20' title='<%=roleType_title%>' param1 = 'param10'  param2 = 'param11' key ='ROLL_TYPE' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param11.value='' "> 
		<input type='button' class='button' value='?' name='StatusLookUp' id='StatusLookUp' onClick="callCommonLookup(param11_desc);" >
	</td>  -->
	 <td class='fields' width='25%'>
        <input type='hidden' name='param10' id='param10'> 
        <input type='hidden' name='param11' id='param11'> 
		<input type='text' name='param11_desc' id='param11_desc' size='20' onBlur="if(this.value!='')searchCode(param10,param11_desc,roleType_title,document.forms[0].sql_text_3.value);else param10.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='StatusLookUp' id='StatusLookUp' onClick="searchCode(param10,param11_desc,roleType_title,document.forms[0].sql_text_3.value);" >
	</td>  

	<!-- <td class='label' width='25%'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		<select name="param10" id="param10" >  
			<option value= "" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<% //while(rst_role_type.next()){ %>
			  <option value='<%//=rst_role_type.getString(1)%>'> <%//=rst_role_type.getString(2)%> </option>
		<%   //*}//end of while-loop
			// }
			//catch(Exception e){
			//	System.err.println("Err Msg SummaryOfOperBySurgeonReports.jsp "+e.getMessage());
			//}finally{
			//	if(rst!=null)rst.close();
			//	if(rst!=null)pstmt.close();
			//	if(con!=null)
			//	ConnectionManager.returnConnection(con,request);
		// }*/
		%>
		</select>
	</td> -->
</tr>


	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRNUGRP">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRNUGRP">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_role_type%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_roles%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param9##Surgery Type" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param9" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param10##Roll Type" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param10" disabled>

	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param5##Operation Type" disabled>
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="param6" disabled>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

