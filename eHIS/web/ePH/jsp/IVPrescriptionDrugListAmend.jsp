<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String order_id			= request.getParameter("order_id");
	String patient_class	= request.getParameter("act_patient_class");

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
	String or_mode			= bean.getOrMode();
	ArrayList drugDetails_1	= bean.getDrugDetails();
	ArrayList drugList		= null;
	if(drugDetails_1.size()==0){
		drugList	= bean.loadAmendDetails(order_id, patient_id,patient_class);		
	}else {
		drugList	= drugDetails_1;
	}
	
	if (drugList.size() > 0) {
%>
<HTML>
<HEAD>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<FORM name="formIVPrescriptionDrugLists" id="formIVPrescriptionDrugLists">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">

<%
		String classValue = "SELECTEDRUGS";
		for(int i=0;i<drugList.size();i++) {

			HashMap drugDetails = (HashMap)drugList.get(i);
			if (drugDetails.size() > 0) {
				String srl_no					= (String)drugDetails.get("SRL_NO");
				String drug_desc				= (String)drugDetails.get("CATALOG_DESC");
				String generic_id				= (String)drugDetails.get("GENERIC_ID");
				String generic_name				= (String)drugDetails.get("GENERIC_NAME");
				String allergy_yn				= (String)drugDetails.get("ALLERGY_YN");
				String qty_value				= (String)drugDetails.get("QTY_VALUE");
				String or_qty_desc				= (String)drugDetails.get("OR_QTY_DESC");
				String limit_ind				= (String)drugDetails.get("LIMIT_IND");
				String mono_graph				= (String)drugDetails.get("MONO_GRAPH");
				String daily_dose				= (String)drugDetails.get("DAILY_DOSE");
				String unit_dose				= (String)drugDetails.get("UNIT_DOSE");
				String min_daily_dose			= (String)drugDetails.get("MIN_DAILY_DOSE");
				String min_unit_dose			= (String)drugDetails.get("MIN_UNIT_DOSE");
				String current_rx				= (String)drugDetails.get("CURRENT_RX");
				String allergy_override			= (String)drugDetails.get("ALLERGY_OVERRIDE");
				String dose_override			= (String)drugDetails.get("DOSE_OVERRIDE");
				String currentrx_override		= (String)drugDetails.get("CURRENTRX_OVERRIDE");
				String sch_over_yn				= (String)drugDetails.get("SCH_OVER_YN");
				String ext_prod_id				= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
				String allergy_override_gif		= "";
				String overdose_override_gif	= "";
				String currrx_override_gif		= "";
				String tooltip					= drug_desc+"/"+generic_name+" - "+qty_value+" "+or_qty_desc;
				String dispDesc					= "";

				if(drug_desc.length()>11) {
					dispDesc=drug_desc.substring(0,11)+"...";
				}
				else {
					dispDesc=drug_desc;
				}

				if(allergy_override!=null && allergy_override.equals("N")) {
					allergy_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
				}
				else {
					allergy_override_gif="&nbsp;";
				}

				if(dose_override!=null && dose_override.equals("N")) {
					overdose_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
				}
				else {
					overdose_override_gif="&nbsp;";
				}

				if(currentrx_override!=null && currentrx_override.equals("N")) {
					currrx_override_gif="<IMG SRC='../images/exceed1.gif'></IMG>";
				}
				else {
					currrx_override_gif="&nbsp;";
				}
%>

		<TR TITLE="<%=tooltip%>">

<%
				if(sch_over_yn.equals("Y") ) {
%>

			<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="64%" onClick="defaultDrug('<%=srl_no%>','<%=or_mode%>');" onMouseOver="changeCursor(this); changeCol(this);" onMouseOut="realCol(this,'<%=classValue%>');"><FONT COLOR="#FF3300"><%=dispDesc%></FONT>

<%
				if (!ext_prod_id.equals("")	) {
%>

				<IMG onMouseOver="changeCursor(this)" STYLE="filter:Chroma(Color=#FFFFFF)" SRC="../../ePH/images/info.gif" HEIGHT="20" WIDTH="20" onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc%>','<%=or_mode%>')">

<%
				}
%>

			</TD>

<%
				}
				else {
%>

			<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="64%" onClick="defaultDrug('<%=srl_no%>','<%=or_mode%>');" onMouseOver="changeCursor(this); changeCol(this);" onMouseOut="realCol(this,'<%=classValue%>');"><FONT CLASS="HYPERLINK"><%=dispDesc%></FONT>

<%
				if (!ext_prod_id.equals("")	) {
%>

				<IMG onMouseOver="changeCursor(this)" STYLE="filter:Chroma(Color=#FFFFFF)" SRC="../../ePH/images/info.gif" HEIGHT="20" WIDTH="20" onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc%>','<%=or_mode%>')">

<%
				}
%>

			</TD>

<%
				}
				if(allergy_yn!=null && allergy_yn.equals("Y")) {
%>

					<TD CLASS="ALLERGY1" COLSPAN="" NOWRAP WIDTH="10%" TITLE='<fmt:message key="ePH.AllergyDrug.label" bundle="${ph_labels}"/>' onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" onMouseOver="changeCursor(this);">&nbsp;<%=allergy_override_gif%>&nbsp;</TD>
<%
				}
				else {
%>
			<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="10%">&nbsp;</TD>
<%
				}
				if(limit_ind!=null && limit_ind.equals("N")) {
%>

			<TD CLASS="DOSELIMIT" COLSPAN="" NOWRAP WIDTH="10%" TITLE='<fmt:message key="ePH.ExceedDosageLimit.label" bundle="${ph_labels}"/>' onMouseOver="changeCursor(this);" onClick="showMonoGraph('<%=drug_desc%>','<%=mono_graph%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>');">&nbsp;<%=overdose_override_gif%>&nbsp;</TD>

<%
				}
				else {
%>

			<TD CLASS="<%=classValue%>" WIDTH="10%">&nbsp;</TD>

<%
				}
				if(current_rx!=null && current_rx.equals("Y")) {
%>

			<TD CLASS="CURRENTRX1" COLSPAN="" NOWRAP WIDTH="10%" TITLE='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>' onMouseOver="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">&nbsp;<%=currrx_override_gif%>&nbsp;</TD>

<%
				}
				else {
%>

			<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="10%">&nbsp;</TD>

<%
				}
%>

		</TR>

<%
			}
		}
%>

	</TABLE>
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
</FORM>
</BODY>
</HTML>

<%
	}
%>
<%
putObjectInBean(bean_id,bean,request);

%>

