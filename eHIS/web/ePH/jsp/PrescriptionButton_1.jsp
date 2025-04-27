<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History            Name        		             Description
---------------------------------------------------------------------------------------------------------------
28/05/2019	IN:067951	            Devindra			              MMS-KH-CRF-0016
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>
<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
   <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		 

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
<!-- 	<script language="JavaScript" src="../js/PhMessages.js"></script>
 -->	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script> <!-- added for Bru-HIMS-CRF-265 [IN:032315] -->
 </head>
	<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- begin	-->
	<!--<script language="VBScript">
		Function vbConfirm(msg)
		   butVal = 32 + 4 + 0 + 0
		   vbConfirm = MsgBox(msg,butVal,"Duplicate Drug")
		End Function
	</script>-->
	<script  language="Javascript">

function jsConfirm(msg) {        
return confirm(msg); 
}
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- end	-->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//HttpSession xx = request.getSession(false);
//Properties jdbc_props = (Properties)xx.getValue("jdbc");

		String source			= request.getParameter("mode");
		if(source==null) source	= "";
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");
		String drug_db_interface_yn	= request.getParameter("drug_db_interface_yn"); //added for Bru-HIMS-CRF-265 [IN:032315]
		if(drug_db_interface_yn==null) drug_db_interface_yn	= "";
		String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id, bean_name, request);
		bean.setLanguageId(locale);
		int count=bean.getReconciliationapp_yn();//added for mms-kh-crf-0016
		String reconciliation_yn=bean.getReconciliation_yn();
		String Reconciliation_disply="";//added for mms-kh-crf-0016
//corrected for PE By Naveen method moved to PrescriptionHeader_1 page

 //  int  profile_count		= bean.getProfileCount(patient_id);
		int  profile_count		= bean.getDrugProfileCount();
		int srlNo=	bean.getSrlNo(); //added for Bru-HIMS-CRF-265 [IN:032315] 
		String button_status	= "";

		if(source.equals("blank")) {
			button_status			=   "disabled";
		}
		String sliding_scale_yn		=	CommonBean.checkForNull(request.getParameter("sliding_scale_yn"));
		String btnVisibility		=   "", canDiscBtnVisibility="display:none"; //canDiscBtnVisibility added for Bru-HIMS-CRF-265 [IN:032315] 
		if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y")){
			btnVisibility="visibility:hidden";
		}
%>
<form name="prescription_button" id="prescription_button" >
    <table cellpadding=0 cellspacing=0 width="85%" height="100%" border="0">
		<tr>
			<%
				if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y")){
			%>
			<td  >
				<input type="button" class="button" value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>'  onclick="addSlidingScaleDrug('add','N')" <%=button_status%>></input>
				<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick="addSlidingScaleDrug('delete','N')" name="cancel" <%=button_status%>></input>
			</td>
			<%
				}else{
			%>
			<td   >
				<input type="button" class="button" value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' onclick="addDrug('<%=source%>')"  <%=button_status%>></input>
				<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick="addDrug('delete')"  name="cancel" <%=button_status%>></input>
			</td>
			<%
				}
if(!bean.getAmend_alternate_yn().equals("Y")){//added for  JD-CRF-0198 [IN:058599]
				%>
			<td >
				<input type="button" class="button" value='<fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/>'  onclick="showMedicalItem()"  name="medical_item">
<%
				//code modified for External Prescription..
				if(profile_count>=1 && ( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")  ) ) {
%>	
					<input type="button" class="button" value='<fmt:message key="ePH.PreviousOrders.label" bundle="${ph_labels}"/>' onclick="showPreviousOrders()" name="btnPrevOrders" style="<%=btnVisibility%>">
<%
				}

%>
				<input type="button" class="button" value='<fmt:message key="ePH.DiscontinueCancelOrders.label" bundle="${ph_labels}"/>' onclick="callDiscCancelOrders('<%=patient_id%>','<%=encounter_id%>','','','','','','<%=srlNo%>','<%=drug_db_interface_yn%>','','buttons','<%=sliding_scale_yn%>')" name="btnDiscOrders" style="<%=canDiscBtnVisibility%>"> <!-- added for Bru-HIMS-CRF-265 [IN:032315]  -start -->
			</td>
			<%if(reconciliation_yn.equals("Y"))
				Reconciliation_disply="";
			else
				Reconciliation_disply="disabled";
			
			%>
			<td>
			<input type="button" class="button" value='<fmt:message key="ePH.Reconciliation.label" bundle="${ph_labels}"/>' <%=Reconciliation_disply%> onclick="medicationReconciliation('recn_button')" > <!--recn_button added for IN070786 -->
			</td>
			<td   >
				
<!--				<input type="button" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  onclick="resetDrugdetails('insert')"  <%=button_status%> name="btnReset" style="<%=btnVisibility%>">
-->
				<input type="button" class="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearDrugdetails()"  <%=button_status%> name="btnClear" style="<%=btnVisibility%>">
<%
}//added for  JD-CRF-0198 [IN:058599]
%>
			</td>
		</tr>
	</table>
</form>
<% // if condition and script added for IN24060 --07/10/2010-- priya
				if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y")){
%>
			<script> //setTimeout("addSlidingScaleDrug('add','Y');",2000);</script><!-- commented for TBMC-SCF-0166-->
<%
				}
   putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

