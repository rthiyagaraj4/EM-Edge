<!DOCTYPE html>
<!--Created by Thamizh selvi 7th Nov 2016 against HSA-CRF-0213-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Connection con =null;
	String p_module_id		= "MR" ;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String locale = (String)session.getAttribute("LOCALE");
	String report_id = "";

	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;
	
	String function_id		= request.getParameter("function_id");

	
try 
{
	con=ConnectionManager.getConnection(request);
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eMR/js/repLeadMorbMort.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();datechange();radioChange();labelVisible();"  onKeyDown = 'lockKey()'>
<form name="LeadingMorbidityMortality" id="LeadingMorbidityMortality" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>

<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='left' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%' class="fields"  >
						 <SELECT name="report_type" id="report_type" onchange='datechange()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
                 
                <tr>
					<td align='left' id='MY1'class="label"> &nbsp; </td>
					<td align='left' id='MY' > &nbsp; </td>
					<td align='left' id='MY3' > &nbsp; </td>
			    </tr>
			
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='left' width='30%' class="label">
					<span id="morb" style="visiblity:hidden;"><fmt:message key="eMR.TopMorbidity.label" bundle="${mr_labels}"/></span>
					<span id="mort" style="visiblity:hidden;"><fmt:message key="eMR.TopMortality.label" bundle="${mr_labels}"/></span>
					</td>
					<td align='left' width='25%' class="fields">
					<input type=text  name='p_top_codes' id='p_top_codes' size="10" maxlength="3" onBlur="CheckNum(this);" onKeyPress='return(ChkNumberInput(this,event,0))'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="eMR.ReportCategory.label" bundle="${mr_labels}"/></td>
						<td align='left' width='70%' class="fields" colspan='2'>
							<input type="radio" id="chapIcd2" name="p_report_category" id="p_report_category" value="ICD10" onClick='radioChange();' checked><fmt:message key="eMR.ICD10.label" bundle="${mr_labels}"/>
							<input type="radio" id="chapIcd1" name="p_report_category" id="p_report_category" value="Chapter" onClick='radioChange();'><fmt:message key="eMR.Chapter.label" bundle="${mr_labels}"/>
						</td>
				</tr>
				
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
					
				</tr>

				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tbody id="ICD10">
				<tr>
					<td align='left' width='35%' id='ChapIcd10' class="label"><fmt:message key="eMR.ICD10.label" bundle="${mr_labels}"/></td>
					<td class="fields" width='20%' id='fromChapIcd' >
					<input type='text' name='p_from_termcode' id='p_from_termcode' maxlength='20' size='10' onKeyPress="return SpCharChkForICD10(event);">
					<input type='button' name='from_term_code' id='from_term_code' value='?' class='button'  onclick='ICD10Lookup(this, p_from_termcode)'>
					</td>
					<td class="fields" width='40%' id='toChapIcd'>
					<input type='text' name='p_to_termcode' id='p_to_termcode' maxlength='20' size='10' onKeyPress="return SpCharChkForICD10(event);">
					<input type='button' name='to_term_code' id='to_term_code' value='?' class='button'  onclick='ICD10Lookup(this, p_to_termcode)'>
					</td>
				</tr>
				</tbody>
				<tbody id="Chapter" style="display:none;">
				<tr>
					<td align='left' width='35%' id='ChapIcd10' class="label"><fmt:message key="eMR.Chapter.label" bundle="${mr_labels}"/></td>
					<td class="fields" width='20%' id='fromChapIcd' >
					<select name='p_from_chap' id='p_from_chap'><option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				
					<%
						JSONArray chapJsonArr	= new JSONArray();
						chapJsonArr  = eMR.MRCommonBean.getChapterList(con);	
						
						for(int i = 0 ; i < chapJsonArr.size() ; i++) 
						{
								JSONObject json	= (JSONObject)chapJsonArr.get(i);
								String termCode  = (String) json.get("term_code");;
								
								out.println("<option value='"+termCode+ "'>"+termCode+"</option>");
								
						}
						
						
					%>
					</select>
					</td>
					<td class="fields" width='40%' id='toChapIcd'> 
					<select name='p_to_chap' id='p_to_chap'><option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
					
					<%	
						
						for(int i = 0 ; i < chapJsonArr.size() ; i++) 
						{
								JSONObject json1	= (JSONObject)chapJsonArr.get(i);
								String termCode  = (String) json1.get("term_code");;
								
								out.println("<option value='"+termCode+ "'>"+termCode+"</option>");
								
						}
					%>
					</select>
					</td>
				
				</tr>
				</tbody>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
						<td class="fields" width='25%'  >
							<select name='p_patient_class' id='p_patient_class'>
								<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/>
								<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
								<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
								<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
								<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
							</select></td>
						</td>
				</tr>

            </table>
        </td>
</tr>
</table>

<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=report_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
<input type="hidden" name="p_chap_icd" id="p_chap_icd"		value="ICD10">
<input type='hidden' name='current_date' id='current_date'	value= "<%=currentdate%>">
<input type='hidden' name='p_function_id' id='p_function_id'	value= "<%=function_id%>">


</form>
</body>
</html>
<%
} catch(Exception e) {  
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

