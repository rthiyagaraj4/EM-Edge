<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhDispDrugBatchDetails.js"></script>
    <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	String user_name  =  (String) session.getValue( "login_user" ) ;
    String bean_id				= "SRRPhDispDrugBatchDetailsBean" ;
	String bean_name			= "ePH.SRRPhDispDrugBatchDetailsBean";
	SRRPhDispDrugBatchDetailsBean bean = 
	(SRRPhDispDrugBatchDetailsBean) getBeanObject(bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
%>

<BODY onload="FocusFirstElement()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="PhDispDrugBatchDetails" id="PhDispDrugBatchDetails" ACTION="../../eCommon/jsp/report_options.jsp"    TARGET="messageFrame">
    <BR><BR><BR>
	<table cellpadding="2" cellspacing="0" width="70%" align="center" border="0"> 
	<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr><td COLSPAN="6" class="label">&nbsp;</td></tr> 
	<tr>
		<td class="label"><fmt:message key="ePH.DispensedDateFrom.label" bundle="${ph_labels}"/></td>
		<td class='label' colspan='2'><input type="text" name="p_fm_date1" id="p_fm_date1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_date1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		<input type="hidden" name="p_fm_date" id="p_fm_date" value="">
		</td>
		<td class='label' colspan='2'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td><input type="text" name="p_to_date1" id="p_to_date1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);"><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		<input type="hidden" name="p_to_date" id="p_to_date" value="">
		</td>
		
	</tr>
	<tr>
		<td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="2">&nbsp;<select name="p_disp_locn_code" id="p_disp_locn_code" maxlength="40">
			<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<%
					ArrayList	arraylist		=	null;
					HashMap		hmDispCode		=	null;	
					String code = "";String	desc		=	"";
					arraylist		=	bean.getArrayCodeList(facility_id);
					int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmDispCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmDispCode.get("code");
						desc				=	(String)hmDispCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
			<% 	} %>
			</select>
		</td>
	</tr>
	<td  class="label"><fmt:message key="ePH.Patientage.label" bundle="${ph_labels}"/></td>
	<td class="fields" colspan='2'>&nbsp;<input type="text"  value="" name="Pat_age_frm" id="Pat_age_frm" size='3' maxLength='3' class='NUMBER'  onKeyPress="return CheckForSequence(event);" onblur="ChkSplChars(this)">&nbsp;<label><fmt:message key="Common.year.label" bundle="${common_labels}"/>
	</td>
	<td  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td class="fields" colspan='2'><input type="text"  value="" name="Pat_age_to" id="Pat_age_to" size='3' maxLength='3' class='NUMBER'  onKeyPress="return CheckForSequence(event);" onblur="ChkSplChars(this)">&nbsp;<label><fmt:message key="Common.year.label" bundle="${common_labels}"/>
	</td>
	<tr>
	</tr>
	<tr>
        <td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<input type="text"  name="drug_desc" id="drug_desc"  maxlength="40" size="40" ><input class="button" onClick="return searchDrugCode(drug_desc);" type="button" value="?">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_trade_id" id="p_trade_id">
			<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option></select>
		</td>
	</tr>
	<tr>
       <td class=label><fmt:message key="Common.BatchNo.label" bundle="${common_labels}"/></td>
	   <td class=label COLSPAN="3"><input type="text" name="p_batch_id" id="p_batch_id" size=10 maxlength=10 value="" ></td> 
	</tr>
	<tr>
	   <td class="label"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
	   <td COLSPAN="3">&nbsp;<input type="text" name="p_exp_date" id="p_exp_date" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_exp_date');" ></td>
	</tr> 
	<tr>
		<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="pclause" id="pclause">
			<option value="1"><fmt:message key="Common.age.label" bundle="${common_labels}"/></option>
			<option value="2"><fmt:message key="Common.BatchNo.label" bundle="${common_labels}"/></option>
			<option value="3"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></option>
		<option value="4"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></option>
		</td>
	</tr>
 	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
	<input type="hidden" name="p_drug_code" id="p_drug_code"	> 
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<!-- <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDISPBATCH"> -->
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDISPBATCH">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
	


</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>


