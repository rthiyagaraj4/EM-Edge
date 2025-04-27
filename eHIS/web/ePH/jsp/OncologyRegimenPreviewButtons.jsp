<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	   // String locale			= (String)session.getAttribute("LOCALE");
	   // 
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/OncologyRegimen.js"></script>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String facility_id		= (String) session.getValue("facility_id");
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	String disable_yn  		= request.getParameter("disable_yn");
	String drug_db_interface_yn = request.getParameter("drug_db_interface_yn") == null ? "N":request.getParameter("drug_db_interface_yn");
	if(disable_yn==null || disable_yn.equals("")) disable_yn = "Y";
	String disabledButton	= "DISABLED";
	String preview_rx_yn=request.getParameter("preview_rx_yn") == null ? "N":request.getParameter("preview_rx_yn"); //added for ML-MMOH-CRF-0341 [IN:057179]
	String previewManDisp = "none", previewReleaseDisp="inline";
			if(preview_rx_yn.equals("Y")){
				previewManDisp = "inline";
				previewReleaseDisp = "none";
			}
	HashMap record2=new HashMap(); 
	String oncology_screening_type="";
	String note_type="";
	String accession_num="";
	
	record2=bean.ChkAdMixture();
	oncology_screening_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_TYPE"));
    note_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_FORM_ID"));
	
	if(!oncology_screening_type.equals("")){
		HashMap record3=new HashMap();
		record3=bean.ChkScreeningDetails(facility_id,encounter_id,note_type);
		accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
	}

	String amend_yn			= "";
	String disable_flag     ="Y";
	ArrayList drugList		= bean.getDrugDetails();
	HashMap drugDetails = null;
	for(int i=0;i<drugList.size();i++) {
		drugDetails = (HashMap)drugList.get(i);
		if (drugDetails!=null && drugDetails.size() > 0){
			 amend_yn	= (String)drugDetails.get("AMEND_YN")==null?"":(String)drugDetails.get("AMEND_YN");
			 if(amend_yn.equals("N")){
				 disable_flag="Y";
				 break;
			 }
			 else{
				 disable_flag="N";
			 }
		}
	}        
	if(disable_flag.equals("Y")) {
         disabledButton		= "DISABLED";
	 }
	 else {
		 disabledButton		= "";
	 }
%>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="OncologyRegimenPrescriptionButtons" id="OncologyRegimenPrescriptionButtons">
			<table cellpadding="0" cellspacing="0" width="99%"  border="0">
				<tr>
					<td width='100%' colspan="2" class="white">
						<table  border="2" bordercolor="black">
							<tr>
<%
								if(drug_db_interface_yn.equals("Y")){
%>
									<td WRAP width="5%" class="SHIFTTOTAL"><img src='../../ePH/images/exceed1.gif' ></img></td><td WRAP  width="25%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.ExternalDataBaseChecks.label" bundle="${ph_labels}"/></td>
<%
								}
%>
								<td WRAP width="5%" class="ALLERGY"><img src='../../ePH/images/exceed1.gif' ></img></td><td WRAP  width="20%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/></td><td  WRAP width="5%" class="DOSELIMIT"  border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td><td WRAP  width="30%" style="font-size:7pt" class="white" border="0" bordercolor="white"  ><fmt:message key="ePH.BeyondDoseLimit.label" bundle="${ph_labels}"/></td>
								<td  WRAP width="5%" class="CURRENTRX"	border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td><td  WRAP width="25%" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></td>
							</tr>
						</table>
					</td>
				</tr>	
				<tr style='display:<%=previewReleaseDisp%>'>
					<td>
					 <input type="button"CLASS="button" name="PREVIEW" id="PREVIEW" VALUE='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>' onClick="preview()" width="40" <%=disabledButton%> >
					 <input type="button"  CLASS="button" name="RELEASE" id="RELEASE" VALUE= '<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' onClick="releaseOncology()"  width="40" <%=disabledButton%>> 
					</td>
				</tr>
				<tr style='display:<%=previewManDisp%>'>
						<td  class="white"  width='50%' align='center' colspan="2"> <input type="button"CLASS="button" name="PREVIEW" id="PREVIEW" VALUE='Preview & Release RX' onClick="preview()" width="40" <%=disabledButton%> >
						</td>	
				</tr>
				<tr><td colspan=2 class='label'>&nbsp;</td></tr>
				<tr><td colspan=2>&nbsp;</td></tr>
			</table>
			<input type="hidden" name="accession_num" id="accession_num" value="<%=accession_num%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="note_type" id="note_type" value="<%=note_type%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="oncology_screening_type" id="oncology_screening_type" value="<%=oncology_screening_type%>">
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

