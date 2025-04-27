<!DOCTYPE html>
<!--Created by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.ConnectionManager, java.util.*, eCommon.Common.*,eMP.*,java.io.*,org.json.simple.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>

<head>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language='javaScript'></Script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script> 
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script> 
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src="../js/MPUploadDocument.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%	
	Connection con		= null;
	String locale		= (String)session.getAttribute("LOCALE");
	String facility_id	= checkForNull((String)session.getValue("facility_id"));
	String operation	= "";
	String ins_val		= "";
	String DisableButn	= "";

	try
	{
		con	= ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		
		String patient_id		= checkForNull(request.getParameter("patient_id"));
		String patient_name		= checkForNull(request.getParameter("patient_name"));
		String contact_no		= checkForNull(request.getParameter("contact_no"));
		String date_of_birth	= checkForNull(request.getParameter("date_of_birth"));	
		String gender			= checkForNull(request.getParameter("gender"));	
		String function_id		= checkForNull(request.getParameter("function_id"));
		String enc_id			= checkForNull(request.getParameter("encounter_id"));
		
		JSONObject PatDtlJson = new JSONObject();
		JSONArray encDetailjsonArr = new JSONArray();
		PatDtlJson = eMP.MPCommonBean.getPatEncDtls(con,patient_id,facility_id);

		int noOfRecords	= 0;
		noOfRecords	= (Integer) PatDtlJson.get("noOfRecords");
%>

</head>
    
<body onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" <%if(noOfRecords > 0){ if(function_id.equals("UPLOAD_DOC")){%>onLoad="FieldsDisplayForEnc(<%=enc_id%>);"<%}else{%>onLoad="FieldsDisplayOrder();"<%}}%>>

	<form name='UploadDocumentResultForm' id='UploadDocumentResultForm' method='post' target='messageFrame' enctype='multipart/form-data'>

	<%
		if(noOfRecords == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		else
		{
	%>
		<table cellpadding='2' cellspacing='0' width='80%' align='center' border='0'>
			<tr>
				<td  colspan='11' class='COLUMNHEADER'><fmt:message key="Common.Demographics.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>	
			</tr>
			<tr><td colspan='2'>&nbsp;</td></tr>
			<tr>
				<td  class='label' width='15%' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td  class='data' width='30%'><%=patient_name%></td>
				<td  class='label' width='15%' nowrap><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/></td>
				<td  class='data' width='30%'><%=contact_no%></td>
			</tr>
			<tr><td colspan='2'>&nbsp;</td></tr>
			<tr>
				<td  class='label' width='15%' nowrap><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>
				<td  class='data' width='30%'><%=date_of_birth%></td>
				<td  class='label' width='15%' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td  class='data' width='30%'><%=gender%></td>
			</tr>
			<tr><td colspan='2'>&nbsp;</td></tr>
		</table>

		<table cellpadding='2' cellspacing='0' width='80%' align='center' border='1'>
			<tr>
				<td width='2%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap>&nbsp;</td>
				<td width='13%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='20%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='30%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.UploadInsDoc.label" bundle="${common_labels}"/>&nbsp;</td>
			</tr>

			<%

				encDetailjsonArr = (JSONArray)PatDtlJson.get("encDtlArray");

				for(int i = 0 ; i < encDetailjsonArr.size() ; i++) 
				{

				JSONObject encListObj	= (JSONObject)encDetailjsonArr.get(i);
				String encounter_id		= checkForNull((String) encListObj.get("encounter_id"));

				for(int k = 0 ; k < 5 ; k++) 
				{

					JSONObject docDtlJson = new JSONObject();
					docDtlJson = eMP.MPCommonBean.getPatDocDtls(con,patient_id,facility_id,encounter_id,i+"_"+k);

					String insurance_type	= checkForNull((String) docDtlJson.get("insurance_type"));
					String serial_no		= checkForNull((String) docDtlJson.get("serial_no"));

					if(!insurance_type.equals("") && serial_no.equals(i+"_"+k)){
						operation = "modify";
					}
					else{
						operation = "insert";
					}

			%>

				<tr id="result_tr<%=i%>_<%=k%>" style="display:table-row;">

					<%if(!insurance_type.equals("") && serial_no.equals(i+"_"+k)){%>
						<td width='2%' nowrap class="label"><a id="add_row<%=i%>_<%=k%>" style="visibility:visibile;" href="javascript:AddAnotherRow(<%=i%>,<%=k%>);"><b>+</b>&nbsp;</a><a id="remove_row<%=i%>_<%=k%>" style="visibility:hidden;" href="javascript:AddAnotherRow(<%=i%>,<%=k%>);"><b>-</b>&nbsp;</a></td>
					<%}else{%>
						<td width='2%' nowrap class="label">&nbsp;</td>
					<%}%>

					<td width='13%' nowrap class="label"><b><%=encounter_id%></b></td>

					<input type=hidden name="encounter_id<%=i%>_<%=k%>" id="encounter_id<%=i%>_<%=k%>" value="<%=encounter_id%>">

					<td width='20%' nowrap align='left'>
						<select name="insurance_type<%=i%>_<%=k%>" id="insurance_type<%=i%>_<%=k%>">
							<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
							<%
							JSONObject InsTypeJson = new JSONObject();
							JSONArray InsTypeJsonArr = new JSONArray();
							InsTypeJson = eMP.MPCommonBean.getInsuranceType(con,locale,encounter_id,patient_id);
							InsTypeJsonArr = (JSONArray)InsTypeJson.get("insTypeArray");

							for(int j = 0 ; j < InsTypeJsonArr.size() ; j++) 
							{
								JSONObject InsType = (JSONObject)InsTypeJsonArr.get(j);
								String ins_type_code = (String) InsType.get("ins_type");

								if(insurance_type.equals(ins_type_code) && serial_no.equals(i+"_"+k)){
									ins_val = "selected";
								}else{
									ins_val = "";
								}

								String ins_name = (String) InsType.get("ins_name");
								out.println("<option value='"+ins_type_code+"' "+ins_val+">"+ins_name+"</option>");	
							}
							%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>

						<%
						int ins_count = eMP.MPCommonBean.getInsuranceCount(con,encounter_id,patient_id);
				
						if(ins_count == 0)
						{
						%>
							<br>
								<span class='label'><font color="red"><fmt:message key="Common.PaymentTypeIsCash.label" bundle="${common_labels}"/></font></span>
							</br>
						<%
							DisableButn = "disabled";
						}else
						{
							DisableButn = "";
						}%>
					</td>

					<td width='30%' nowrap class='fields'>
						<div id='upload_doc_id<%=i%>_<%=k%>'>
							<input type='file' name='upload_doc_name<%=i%>_<%=k%>' id='upload_doc_name<%=i%>_<%=k%>' value='' size=40 maxlength=40 <%=DisableButn%> onkeypress='return onkeyPressEvent(event);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>&nbsp;<input type='button' name='docUpload<%=i%>_<%=k%>' id='docUpload<%=i%>_<%=k%>' value='Upload' size=4 <%=DisableButn%> onClick='ValidateFileType(<%=i%>,<%=k%>);'>&nbsp;&nbsp;<%if(!insurance_type.equals("") && serial_no.equals(i+"_"+k)){%><a href="javascript:ViewDocument(<%=i%>,<%=k%>);"><b><fmt:message key="Common.view.label" bundle="${common_labels}"/></b>&nbsp;</a><%}%>
						</div>
					</td>
				</tr>

				<input type='hidden' name='oper<%=i%>_<%=k%>' id='oper<%=i%>_<%=k%>' value="<%=operation%>"/>
				<input type='hidden' name='serial_no<%=i%>_<%=k%>' id='serial_no<%=i%>_<%=k%>' value="<%=i%>_<%=k%>"/>

			<%
				}
				}
			%>
		
		</table>

				<input type='hidden' name='operation' id='operation' value=""/>
				<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>"/>
				<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>"/>
				<input type='hidden' name='enc_arr_size' id='enc_arr_size' value="<%=encDetailjsonArr.size()%>"/>
				<input type='hidden' name='hidd_encounter_id' id='hidd_encounter_id' value=""/>
				<input type='hidden' name='hidd_insurance_type' id='hidd_insurance_type' value=""/>
				<input type='hidden' name='hidd_serial_no' id='hidd_serial_no' value=""/>
	
	<%
		}
	%>
    </form>

</body>
<%
	}catch(Exception e)
	{
		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

</html>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

