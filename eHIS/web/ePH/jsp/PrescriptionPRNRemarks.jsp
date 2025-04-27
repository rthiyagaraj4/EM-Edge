<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String patient_id					= request.getParameter("patient_id"); 
	String encounter_id					= request.getParameter("encounter_id");
	String drug_code					= request.getParameter("drug_code");
	String drug							= request.getParameter("drug");
	String called_from					= request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String prn_yn						= request.getParameter("prn_yn")==null?"N":request.getParameter("prn_yn");
	String remarks_code					= request.getParameter("prn_remarks_code")==null?"":request.getParameter("prn_remarks_code");
	String remarks_dtl					= request.getParameter("prn_remarks_dtl")==null?"":request.getParameter("prn_remarks_dtl");
	String man_rem_on_prn_freq_yn		= request.getParameter("man_rem_on_prn_freq_yn")==null?"N":request.getParameter("man_rem_on_prn_freq_yn");
	String max_length_prn_reason		= (request.getParameter("max_length_prn_reason").equals("") || request.getParameter("max_length_prn_reason")==null)?"400":request.getParameter("max_length_prn_reason");
	
	int j=0;
	String sel="";
	String bean_id						= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name					= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean				= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	String presBean_id						= "@PrescriptionBean"+patient_id+encounter_id;
	String presBean_name					= "ePH.PrescriptionBean";
	PrescriptionBean presBean				= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);
	HashMap remarks						=  null;
	String from = "";
	String chk = "";
	String textAreaDisabled = "";

	remarks = bean.getPRNRemarks(drug_code);
	if(remarks != null){
		remarks_code			=  remarks.get("prn_remarks_code")==null?"":(String)remarks.get("prn_remarks_code");
		remarks_dtl				=  remarks.get("prn_remarks_dtl")==null?"":(String)remarks.get("prn_remarks_dtl");
	}
	if(!remarks_dtl.equals("") )
		from = "Amend";
	if(remarks != null  && remarks.size() > 0)
		from = "Amend";
	if(remarks_code.equals("") && from.equals("Amend"))
		chk = "checked";
	if(chk.equals("checked")){
		textAreaDisabled = "";
	}
	else{
		textAreaDisabled = "disabled";
	}
	HashMap temp = new HashMap();
	ArrayList prnRemarkForDrug = presBean.getPrnRemarkForDrug(drug_code);
	remarks_dtl=remarks_dtl.replaceAll(" ","%20");
	remarks_dtl = java.net.URLEncoder.encode(remarks_dtl,"UTF-8");
	remarks_dtl=remarks_dtl.replaceAll("%2520","%20");
	if(prnRemarkForDrug.size()==0){
		chk				 = "checked";
		textAreaDisabled = "";
	}
%>
<html>
	<head>
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></title>
	</head>
	<body >
		<form name="PrescriptionPRNRemarksForm" id="PrescriptionPRNRemarksForm" >
			<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0">
				<tr> 
					<td><fmt:message key="ePH.PRNRemarks.label" bundle="${common_labels}"/></td>
					<td  class="label" >
						<select name='prnRemCode' id='prnRemCode' onchange='displayRemarks()'>
							<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
							for(int i=0; i<prnRemarkForDrug.size(); i++){
								temp = (HashMap)prnRemarkForDrug.get(i);
								if(from.equals("Amend")) {
									sel="";
									if(!remarks_code.equals("")){
										if(((String)temp.get("REASON_CODE")).equals(remarks_code)){
											j=i;
											sel = "selected";
										}
									}
								}
								else{
									if(((String)temp.get("DEFAULT_REASON_YN")).equals("Y")){
										j=i;
										sel = "selected";
									}
									else
										sel="";
								}
%>
								<option value='<%=(String)temp.get("REASON_CODE")%>' <%=sel%> > <%=(String)temp.get("REASON_DESC")%> </option>
<%				
							}
%>
						</select>
<%
						for(int i=0; i<prnRemarkForDrug.size(); i++){
							temp = (HashMap)prnRemarkForDrug.get(i);
							sel =temp.get("REMARKS")==null?"":(String)temp.get("REMARKS");

							if(!(sel==null) && !(sel.equals(""))){
								sel=sel.replaceAll(" ","%20");
								sel = java.net.URLEncoder.encode(sel,"UTF-8");
								sel=sel.replaceAll("%2520"," ");
								sel=sel.replaceAll("%20"," ");
							}
%>
							<input type="hidden" value="<%=sel%>" name="remarks_<%=i%>">
<%
						}
%>
					</td>
				</tr>
				<tr> 
					<td>&nbsp;</td>
					<td  class="label" ><fmt:message key='ePH.PRNFreeTextRemarks.label' bundle='${ph_labels}'/>&nbsp;&nbsp;
					<input type='checkbox' name='prnFreeTextYN' id='prnFreeTextYN' onclick='changeRemType()' <%=chk%>></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td >&nbsp;&nbsp;<textarea rows="8" cols="45" name="remarks" onKeyPress="return(ChkMaxLen('Remarks',this,'<%=max_length_prn_reason%>'));" <%=textAreaDisabled%>></textarea>
<%
					if(man_rem_on_prn_freq_yn.equals("Y")){
%>
						<img src="../../eCommon/images/mandatory.gif" align="center"></td>
<%
					}
%>
				</tr>
			</table>
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
			<input type="hidden" name="drug" id="drug" value="<%=drug%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="patient_id" id="patient_id"		 value="<%=patient_id%>" >
			<input type="hidden" name="prn_yn" id="prn_yn"		 value="<%=prn_yn%>" >
			<input type="hidden" name="man_rem_on_prn_freq_yn" id="man_rem_on_prn_freq_yn"		 value="<%=man_rem_on_prn_freq_yn%>" >
			<input type="hidden" name="max_length_prn_reason" id="max_length_prn_reason"		 value="<%=max_length_prn_reason%>" >
			<script>
				var prn_rem = decodeURIComponent('<%=remarks_dtl%>');
				document.PrescriptionPRNRemarksForm.remarks.value=prn_rem;
				if(document.PrescriptionPRNRemarksForm.prnFreeTextYN.checked == true)
					document.PrescriptionPRNRemarksForm.prnRemCode.disabled=true;
<% 
				if(prnRemarkForDrug.size() > 0) {
%>	
					if(document.PrescriptionPRNRemarksForm.prnFreeTextYN.checked == false && document.PrescriptionPRNRemarksForm.prnRemCode.value != ""){
						var temp = (eval("document.PrescriptionPRNRemarksForm.remarks_"+<%=j%>).value);
						if(temp==null || temp=="null")
							temp = "";
						else
							temp = decodeURIComponent(temp);

						document.PrescriptionPRNRemarksForm.remarks.value=temp;
					}
<%
				}
				putObjectInBean(bean_id,bean,request);
%>
			</script>
		</form>
	</body>
</html>

