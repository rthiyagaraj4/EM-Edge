<!DOCTYPE html>
 <!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
31/12/2021		TFS-6900		Prabha			MOHE-CRF-0040
---------------------------------------------------------------------------------------------------------------
*/ --> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.DispMedicationBean, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
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
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String login_user	=	(String)session.getValue("login_user");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT> 
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script type="text/javascript" src="../../eCommon/js/DateUtils.js"></script>
        <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Added for RUT-CRF-0083.5 [IN:041511] -->
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
		String locale			= (String)session.getAttribute("LOCALE");
		String bean_id = "DispMedicationBean" ;
		String bean_name = "ePH.DispMedicationBean";
		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		String disp_locn_catg = bean.getDispLocnCatg();
		String issue_token_on_regn = "";
		if(disp_locn_catg.equals("O")){
			issue_token_on_regn = bean.getIssueTokenOnRegnYN();
			if(issue_token_on_regn.equals("")){
				issue_token_on_regn="N";
			}
		}
		String disp_stage = bean.getDispStage();
		String fill_list = bean.getFillList();
		String disp_locn_code	 = bean.getDispLocnCode();
		String function_id		= CommonBean.checkForNull(request.getParameter("function_id"));
		String homepage		= CommonBean.checkForNull(request.getParameter("homepage")); //Added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		String dispSwitchLogin = "";
		if(homepage.equals("Y"))
			dispSwitchLogin ="display:none;"; //Added for Bru-HIMS-CRF-073.1 [IN:047222] -end
		
		String disp_stage_name  = "";/* added for SRR20056-CRF-0663 --START*/
		
		//Commented for MOHE-CRF-0040 - START
		
		 Hashtable param_legends = bean.getLegendsFromParam(); //Modified for MOHE-CRF-0040
		if(disp_stage.equals("V")){
			disp_stage_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Verification.label","ph_labels");
			// sAbsoluteOrder	= ""; //Commented for SRR20056-CRF-0663
		}
		else if(disp_stage.equals("A")){
			disp_stage_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allocate.label","common_labels");
		}
		else if(disp_stage.equals("F")){
			disp_stage_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Fill.label","ph_labels");
		}
		else if(disp_stage.equals("B")){
			disp_stage_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Bill/Receipt.label","ph_labels");
		}
		else if(disp_stage.equals("D")){
			disp_stage_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Deliver.label","ph_labels");
		}
		else if(disp_stage.equals("AS")){
			disp_stage_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AllStages.label","ph_labels");
		} //Modified for MOHE-CRF-0040
		
		//Commented for MOHE-CRF-0040 - End
%>
		<form name="frmDispMedicationQueryCriteriaButtons" id="frmDispMedicationQueryCriteriaButtons" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
				<tr>
					<TD>&nbsp;&nbsp;&nbsp;<b><%=java.net.URLDecoder.decode(bean.getDispLocnName(),"UTF-8")%></b></td>

					<td  class="label" align="RIGHT" nowrap><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/>&nbsp;&nbsp;

				<b> <%= disp_stage_name %> </b>					
					</TD>
					<td ALIGN="RIGHT">
<%
					if (issue_token_on_regn.equals("Y") && disp_locn_catg.equals("O") ){  
%>
						<input type="button" name="btnHideShowCriteria" id="btnHideShowCriteria" value='<fmt:message key="ePH.ShowCriteria.label" bundle="${ph_labels}"/>' class="button" onClick="hideShowCriteria(this)">	
<%
					} //code added for Bru-HIMS-CRF-416[IN045566]-- Start
					else if(!fill_list.equals("DWF")){					
%>
						<input type="button" name="btnHideShowCriteria" id="btnHideShowCriteria" value='<fmt:message key="ePH.HideCriteria.label" bundle="${ph_labels}"/>' class="button" onClick="ShowHideCriteria(this,'<%=disp_stage%>','<%=fill_list%>','<%=disp_locn_catg%>')">	
<%					
					}//code added for Bru-HIMS-CRF-416[IN045566]-- End
%>
					</td>
					<td ALIGN="RIGHT">
						<label style="visibility:hidden;cursor:pointer;" id='lblDMSLink'>&nbsp; <!-- added for RUT-CRF-0083.5 [IN:041511] --start -->
							<img  src='../../eCommon/images/ExternalDocument.PNG' align="center" title='<fmt:message key="ePH.ExternalDocumentLink.label" bundle="${ph_labels}"/>' id='imgDMSLink' ></img>&nbsp;
							<input type='hidden' name='patient_id_DMSLink' id='patient_id_DMSLink' value=''>
							<input type='hidden' name='episode_id_DMSLink' id='episode_id_DMSLink' value=''>
							<input type='hidden' name='patient_class_DMSLink' id='patient_class_DMSLink' value=''>
							<input type='hidden' name='Ordering_Facility_id_DMSLink' id='Ordering_Facility_id_DMSLink' value=''>
						</label><!-- added for RUT-CRF-0083.5 [IN:041511] --End -->
						<input type="button"   class="button" name="btnSwitch" id="btnSwitch" value='<fmt:message key="ePH.SwitchLogin.label" bundle="${ph_labels}"/>' onClick="switchToLogin()" style='<%=dispSwitchLogin%>'>
<%
					/*	String displayAddCriteria=""; //code commented for Bru-HIMS-CRF-416[IN045566]-- Start
						if (issue_token_on_regn.equals("N") && disp_locn_catg.equals("O")){						
							displayAddCriteria = "style='display:none'";
						} */  //code commented for Bru-HIMS-CRF-416[IN045566]-- End  
%>
						<input type="button" name="btnAdditionalCriteria" id="btnAdditionalCriteria" value='<fmt:message key="Common.AdditionalCriteria.label" bundle="${common_labels}"/>' class="button" onClick="showAdditionalCriteria(this,'<%=issue_token_on_regn%>','<%=fill_list%>')"><!-- code 'displayAddCriteria' removed  and 'fill_list' added for Bru-HIMS-CRF-416[IN045566] -->
						
				<!--		<input type="button" name="btnShowCriteria" id="btnShowCriteria" value='<fmt:message key="ePH.ShowCriteria.label" bundle="${ph_labels}"/>' class="button" onClick="showCriteria(this)" style="display:none"> //code commented for Bru-HIMS-CRF-416[IN045566] --> 

						<input type="button" id="btnSearch" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' class="button" onClick="<%if(bean.getStockDtl()!=null){bean.getStockDtl().clear();}%>checkRestoreChangesUponRefresh('<%=disp_locn_catg%>','<%=issue_token_on_regn%>','<%=disp_stage%>','<%=fill_list%>','<%=login_user%>','<%=disp_locn_code%>')"><!-- clear barcode stock values added for KDAH-CRF-0231 [IN-034551] -->
					</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=bean.getDispLocnCatg()%>">
			<input type="hidden" name="issue_token_on_regn" id="issue_token_on_regn" value="<%=issue_token_on_regn%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			<input type="hidden" name="display_dms_link_yn" id="display_dms_link_yn" value="">  <!-- added for RUT-CRF-0083.5 [IN:041511] --start -->
			<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>"> <!-- added for RUT-CRF-0083.5 [IN:041511] End -->
		</form>
	</body>
	<script>
<% 
		///if ((disp_locn_catg.equals("O") && issue_token_on_regn.equals("N")) || (homepage.equals("Y") && !fill_list.equals("AF") && !fill_list.equals("DWF") ))	{	//Commnented for GHL-ICN-0085 //Common-ICN-0075
			//setTimeout("clickRefresh();", 10); //Commnented for GHL-ICN-0085 //Common-ICN-0075
		//}	 //Commnented for GHL-ICN-0085 //Common-ICN-0075
%>
		//Added for  RUT-CRF-0083.5 [IN:041511] -Start
		$( "#imgDMSLink" ).click(function() {
			 $.ajax({  
				  url:'../../servlet/eXH.InvokeExternalApplication',  
				  type:'post',  
				  data:{'P_USE_ID':'<%=login_user%>','P_PATIENT_ID':document.frmDispMedicationQueryCriteriaButtons.patient_id_DMSLink.value,'P_ENCNTR_DATE':'','P_VISIT_ID':'','P_EPISODE_ID':document.frmDispMedicationQueryCriteriaButtons.episode_id_DMSLink.value,'P_EPISODE_TYPE':document.frmDispMedicationQueryCriteriaButtons.patient_class_DMSLink.value,'P_PHYSICIAN_ID':'','P_ACCESSION_NUM':'','P_ORDER_ID':'','P_ORDER_TYPE_CODE':'','P_LOCN_TYPE':'','P_LOCN_CODE':'','P_CUST_CODE':'','P_ITEM_CODE':'','P_RESP_ID':'','P_FACILITY_ID':document.frmDispMedicationQueryCriteriaButtons.Ordering_Facility_id_DMSLink.value,'P_INV_ORG_ID':'','P_MODULE_ID':'','P_FUNCTION_ID':'','P_ACCESS_RIGHTS':'','P_LANGUAGE_ID':'<%=locale%>','P_MULTI_SITE_YN':'','P_MULTI_LANG_YN':'','P_WS_NO':'','P_Ext_Input_Key':'','P_Ext_ Application_ID':'DMS','P_Ext_Function':'VIEW','P_pwd':'','P_Connect_string':''},
				  dataType: 'html'		    
			});
		});
		//Added for  RUT-CRF-0083.5 [IN:041511] -End
	</script>
</html>

