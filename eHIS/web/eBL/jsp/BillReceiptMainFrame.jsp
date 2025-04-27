<!DOCTYPE html>
<!--
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K
--------------------------------------------------------------------------------------------------------
-->
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*,org.apache.commons.codec.binary.Base64" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<HTML>
<HEAD>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<% 	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


String FacilityId = (String)session.getAttribute("facility_id");
String call_from  = request.getParameter("call_from");
String encounter_date	= request.getParameter("encounter_date");
String patient_id	="";
String encounter_id	="";
//V220412
if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patient_id	= request.getParameter("patient_id");
	encounter_id	= request.getParameter("encounter_id");
}
//V220412

String episode_id	= request.getParameter("episode_id");
String visit_id	= request.getParameter("visit_id");
String episode_type = request.getParameter("episode_type");
String payerGroup = request.getParameter("payerGroup");
String payer = request.getParameter("payer");

String userId = (String) session.getValue("login_user");
String reqParam = request.getQueryString();

String beanId = "BillReceiptExistOrderExclusion" ;
String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
exclusionBean.clearAll();

%>
    <title>Bill Generation</title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<input type='hidden' id='allFramesExisting' name='allFramesExisting'  value='7%,4%,25%,18%,30%,13%,4%'>
	<input type='hidden' id='hideSearchCriteria' 		name='hideSearchCriteria' 	 value='7%,4%,0%,31%,40%,14%,4%'>
	<input type='hidden' id='allFramesNewDtl' 	name='allFramesNewDtl' 	 value='7%,0%,0%,6%,0%,47%,37%,5%'>
	<input type='hidden' id='allFramesNewRcrd' 	name='allFramesNewRcrd'   value='7%,0%,0%,5%,0%,29%,50%,5%'>
	<input type='hidden' id='allFramesMessage' 	name='allFramesMessage'   value='7%,0%,0%,32%,25%,7%,29%,5%'>
	<input type='hidden' id='allFramesOtherOut' 	name='allFramesOtherOut'   value='7%,6%,0%,6%,76%,0%,0%,5%'>
	<input type='hidden' id='allFramesUnConfirmed' 	name='allFramesUnConfirmed'   value='7%,6%,0%,86%,0%,0%,0%,5%'>
	<input type='hidden' id='showEncBilling' 	name='showEncBilling'   value='7%,6%,27%,44%,0%,12%,4%'>
	<input type='hidden' id='framesAltered' 	name='framesAltered'   value='7%,6%,27%,44%,0%,12%,4%'>

	<script>
	function refresh(){
		var reqParam = BillReceiptExisOrderSearch.document.forms[0].queryString.value;
		BillReceiptExisOrderSearch.document.location.href = "../../eBL/jsp/BillReceiptExistingOrderSearch.jsp?"+reqParam;
		BillReceiptExisOrderDetails.document.location.href = '../../eCommon/html/blank.html';
		BillReceiptExisOrderSummary.document.location.href = '../../eBL/jsp/BillReceiptExisOrderSummary.jsp';
		BillReceiptWindow.document.location.href = '../../eBL/jsp/BillReceiptPaymentMain.jsp';
		messageFrame.document.location.href = '../../eCommon/jsp/error.jsp';
	}

	function closeWindow(){
		window.close();
		/* const dialogTag = parent.parent.document.getElementById('dialog_tag');    
		dialogTag.close(); */
	}
	</script>
</HEAD>
		<iframe name='pline' id='pline' 		frameborder='0'	src="../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient_id%>"  scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='BillReceiptTab' id='BillReceiptTab' 	frameborder='0'	src="../../eBL/jsp/BillReceiptTabs.jsp?<%=reqParam %>"  scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
			<iframe name='BillReceiptInfo' id='BillReceiptInfo'	src='../../eBL/jsp/BillReceiptInfo.jsp?<%=reqParam %>'  frameborder=0  noresize style='height:27vh;width:100vw'></iframe> 									
			<iframe name='BillReceiptExisOrderSearch' id='BillReceiptExisOrderSearch'	src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:16vh;width:100vw'> </iframe>
			<iframe name='BillReceiptExisOrderDetails' id='BillReceiptExisOrderDetails'	src='../../eCommon/html/blank.html'  frameborder=0 noresize style='height:24vh;width:100vw'></iframe>
			<iframe name='BillReceiptExisOrderSummary' id='BillReceiptExisOrderSummary'	src='../../eCommon/html/blank.html'  frameborder=0 noresize style='height:8vh;width:100vw'></iframe>
			<!-- <iframe name='BillReceiptWindow' id='BillReceiptWindow'	src='../../eCommon/html/blank.html'  frameborder=0 noresize style='height:4vh;width:100vw'></iframe>  BillReceiptPaymentMain.jsp -->
			<iframe name='messageFrame1' id='messageFrame1'		frameborder='0' src='../../eCommon/jsp/error.jsp'  scrolling='auto' noresize style='height:8vh;width:100vw'></iframe>
		
		
			<!---<FRAMESET id="BL_mainFrame"  ROWS ='7%,4%,25%,18%,30%,13%,4%' framespacing=0 >			
			<frame name='pline' 		frameborder='0'	src="../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient_id%>"  scrolling='no' noresize>
			<frame name='BillReceiptTab' 	frameborder='0'	src="BillReceiptTabs.jsp?<%=reqParam %>"  scrolling='no' noresize>
			<FRAME name='BillReceiptInfo'	src='BillReceiptInfo.jsp?<%=reqParam %>'  frameborder=0  noresize> 									
			<FRAME name='BillReceiptExisOrderSearch'	src='../../eCommon/html/blank.html' frameborder=0 noresize  > 
			<FRAME name='BillReceiptExisOrderDetails'	src='../../eCommon/html/blank.html'  frameborder=0 noresize>
			<FRAME name='BillReceiptExisOrderSummary'	src='../../eCommon/html/blank.html'  frameborder=0 noresize>--->
			<!-- <FRAME name='BillReceiptWindow'	src='../../eCommon/html/blank.html'  frameborder=0 noresize>  BillReceiptPaymentMain.jsp -->
			<!--<frame name='messageFrame'		frameborder='0' src='../../eCommon/jsp/error.jsp'  scrolling='auto' noresize>
		</FRAMESET>--->
		
</HTML>


