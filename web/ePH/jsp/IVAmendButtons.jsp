<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<%
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");	
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	String or_mode			= request.getParameter("or_mode");
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
%>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<%

		if(bean.getIVType().equals("IVD")) { 
%>
			<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<%	
		}
		else {	
%>
			<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescription.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%	
		}
%>	
	</HEAD>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<FORM name="formIVPrescriptionButtons" id="formIVPrescriptionButtons">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<TR>
					<TD >
<%	
					if(or_mode==null){	
						or_mode="";
					}
					or_mode					= bean.getOrMode();
					
/* //FBD Tuning -- seems not uesd... uncomment if required
					ArrayList drugList		= bean.getDrugDetails();
					ArrayList exProd		= new ArrayList();
					ArrayList drugDesc		= new ArrayList();

					for(int i=0;i<drugList.size();i++) {
						HashMap drugDetails = (HashMap)drugList.get(i);
						if (drugDetails.size() != 0) {
							String extprod	= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");

							if (!extprod.equals("")) {
								drugDesc.add((String)drugDetails.get("SHORT_DESC"));
								exProd.add(extprod);
							}
						}
					}
					if (drugDesc.size()>=2) {
						String beanid1		= "@ExternalProductLinkBean"+patient_id+encounter_id ;
						String beanname1	= "ePH.ExternalProductLinkBean";
						ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject( beanid1, beanname1 , request) ;

						//Store Drug ids
						if(exProd.size() > 0){
							beanex.storeDrugIds(patient_id, "", exProd, drugDesc);
						}
						//Store interactions

						//beanex.getDDInteractions();
						HashMap drug_Details =new HashMap();// beanex.getInteractions();

						if (!drug_Details.isEmpty()) {*/ //FBD Tuning -- seems not uesd... uncomment if required
%>
						<!--	<IMG SRC="../images/DrugInteractions.gif" onMouseOver="changeCursor(this)" onClick="viewInteraction('<%/*=patient_id*/ %>', '', '<% /*=encounter_id*/ %>');" HEIGHT="20"> -->
<%
					/*	} //FBD Tuning -- seems not uesd... uncomment if required
						putObjectInBean(beanid1,beanex,request);
					} //FBD Tuning -- seems not uesd... uncomment if required*/
%>
					<INPUT TYPE="button" CLASS="button" name="PREVIEW" id="PREVIEW" VALUE='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>'  onClick="previewRX()">
					<INPUT TYPE="button" CLASS="button" name="RELEASE" id="RELEASE" VALUE='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' onClick="releaseRX()">
<%
					if(!or_mode.equals("amend")){
%> 
						<INPUT TYPE="button" CLASS="button" name="CLEAR" id="CLEAR" VALUE='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="callClearAll(1)">
<%
					}
%>
					</TD>
				</TR>
			</TABLE>
		</FORM>
	</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

