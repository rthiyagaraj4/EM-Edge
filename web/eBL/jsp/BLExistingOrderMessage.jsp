<!DOCTYPE html>
<%@page import="eBL.placeorder.model.BLChargePatientExistingOrderBean"%>
<%@page import="eBL.placeorder.model.BLChargePatientNewOrderBean"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

<head>
<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="JavaScript">
$(document).ready(function(){
	if($('#calledFrom').val() == 'cancelAll' || $('#calledFrom').val() == 'cancelBLServ'){
		
	}
});
</script>
<script language='JavaScript'>
			function toLoadFrame(){
				var dialogFrame = parent.parent.document.getElementById('dialog-body').contentWindow;
					//parent.document.getElementById('BL_mainFrame').rows = dialogFrame.document.getElementById('allFramesMessage').value;
					//<input type='hidden' id='allFramesMessage' 	name='allFramesMessage'   value='7%,0%,0%,6%,25%,6%,28%,23%,4%'>
					//dialogFrame.pline.style.height="7vh";	
					//console.log(dialogFrame.document.getElementById('pline'));
					/* parent.document.getElementById('pline').style.height = "7vh";
						parent.document.getElementById('BillingBanner').style.height = "0vh";
						parent.document.getElementById('BillingMenu').style.height = "0vh";
						parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
						parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "25vh";
						parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "6vh";
						parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "28vh";
						parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "23vh";
						parent.document.getElementById('messageFrame').style.height = "4vh"; */
						dialogFrame.document.getElementById('pline').style.height = "7vh";
						dialogFrame.document.getElementById('BillingBanner').style.height = "0vh";
						dialogFrame.document.getElementById('BillingMenu').style.height = "0vh";
						dialogFrame.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
						dialogFrame.document.getElementById('BLChargePatientEncounterTabPage').style.height = "22vh";
						dialogFrame.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "6vh";
						dialogFrame.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "28vh";
						dialogFrame.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "18vh";
						dialogFrame.document.getElementById('messageFrame1').style.height = "8vh"; 
						
						dialogFrame.BLChargePatientExisOrderTraverse.location.href='../../eCommon/html/blank.html';
						dialogFrame.BLChargePatientExisOrderServDetails.location.href='../../eCommon/html/blank.html';				
						dialogFrame.BLChargePatientExisOrderServEdit.location.href = "../../eCommon/html/blank.html";
/* 					parent.BLChargePatientExisOrderTraverse.location.href='../../eCommon/html/blank.html';
					parent.BLChargePatientExisOrderServDetails.location.href='../../eCommon/html/blank.html';				
					parent.BLChargePatientExisOrderServEdit.location.href = "../../eCommon/html/blank.html"; */
			}
				</script>

</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<p align="left">
<%
	request.setCharacterEncoding("UTF-8");	
	String error=request.getParameter( "err_num" );
	
	System.out.println(" error==>"+error);
	String calledFrom = request.getParameter("calledFrom");
	System.out.println(" calledFrom ===>"+calledFrom);
	String warning = request.getParameter("warning");
	System.out.println("warning:"+request.getParameter( "err_value" ));
	
	//System.out.println("error->"+error);
	if ( error != null ) { System.out.println("error 78->"+error);
	%>
		
		<%=error %>
		
	<%	
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		System.out.println("error_value->"+error_value);
		if ( error_value.equals( "1" ) ){
			String beanId = "BLChargePatientNewOrderBean" ;
			String beanName = "eBL.placeorder.model.BLChargePatientNewOrderBean";
			BLChargePatientNewOrderBean chargeBean = (BLChargePatientNewOrderBean) getObjectFromBean(beanId, beanName, session);
			//cleanBeanObject(beanId, beanName, request);
			chargeBean.clearAll();
			
			beanId = "BLChargePatientExistingOrderBean" ;
			beanName = "eBL.placeorder.model.BLChargePatientExistingOrderBean";

			BLChargePatientExistingOrderBean serviceBean = (BLChargePatientExistingOrderBean) getObjectFromBean(beanId, beanName, session);
			//cleanBeanObject(beanId, beanName, request);
			serviceBean.clearAll();
			if("newOrder".equals(calledFrom)){ 
			System.out.println("inside nweOrder");%>
			<script type='text/javascript'>
				toLoadFrame();
				//alert('<%=error%>');
			</script>
		<%}
			else if("existingOrder".equals(calledFrom)){%>
				<script language='JavaScript'>
					alert('APP-SM0070 Operation Completed Successfully ....');
					parent.BLChargePatientEncounterTabPage.document.getElementById('add_mod').click();
				</script>
			<%}
			else if("processOrder".equals(calledFrom)){%>
				<script language='JavaScript'>
					alert('APP-SM0070 Operation Completed Successfully ....');
					parent.BillReceiptTab.document.getElementById('futureOrder').click();
				</script>
			<%}
			else if("cancelBLServ".equals(calledFrom)){%>
			<script language='JavaScript'>
				alert('APP-SM0070 Operation Completed Successfully ....');
				//console.log("cancelBLServ");
				var dialogFrame = parent.parent.document.getElementById('dialog-body').contentWindow;
				//console.log(dialogFrame);
				//console.log(dialogFrame.document.getElementById('BLChargePatientEncounterTabPage'));
				var dialogFrameforBL=dialogFrame.document.getElementById('BLChargePatientEncounterTabPage');
				var dialogFrameforBL1=dialogFrame.document.getElementById('BLChargePatientEncounterTabPage').contentWindow;
				//console.log(dialogFrameforBL1.document.getElementById('add_mod'));
				var dialogFrameforBLServ=dialogFrameforBL1.document.getElementById('add_mod');
				dialogFrameforBLServ.click();
				//console.log();
				//console.log(parent.BLChargePatientEncounterTabPage.document.getElementById('add_mod'));
				//parent.BLChargePatientEncounterTabPage.document.getElementById('add_mod').click();
			</script>
			<%}
			else if("cancelAll".equals(calledFrom)){%>
			<script language='JavaScript'>
				alert('APP-SM0070 Operation Completed Successfully ....');
				//console.log("cancelAll");
				var dialogFrame = parent.parent.document.getElementById('dialog-body').contentWindow;
				//console.log(dialogFrame);
				//console.log(dialogFrame.document.getElementById('BLChargePatientEncounterTabPage'));
				var dialogFrameforBL=dialogFrame.document.getElementById('BLChargePatientEncounterTabPage');
				var dialogFrameforBL1=dialogFrame.document.getElementById('BLChargePatientEncounterTabPage').contentWindow;
				//console.log(dialogFrameforBL1.document.getElementById('add_mod'));
				var dialogFrameforBLServ=dialogFrameforBL1.document.getElementById('add_mod');
				dialogFrameforBLServ.click();
				
				//var dialogFrame = parent.parent.document.getElementById('dialog-body').contentWindow;
				//console.log(dialogFrame.document.getElementById('messageFrame'));
				//console.log(dialogFrame.document.getElementById('BLChargePatientEncounterTabPage'));
				//console.log(parent.BLChargePatientEncounterTabPage.document.getElementById('add_mod'));
				//parent.BLChargePatientEncounterTabPage.document.getElementById('add_mod').click();
			</script>
			<%}
		}
			
	}

%>
<input type='hidden' name='calledFrom'  id='calledFrom' value='<%=calledFrom %>'>
<input type='hidden' name='error'  id='error' value='<%=error %>'>
<input type='hidden' name='warning'  id='warning' value='<%=warning %>'>
</p>
<p id='ehiserror'></p>
</BODY>

