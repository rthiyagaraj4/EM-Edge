<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderEMFrames.jsp
File Description: Main/Outer Frame : This file is for Placing Meal Order For Emergency Patients.
CRF#			: Bru-HIMS-CRF-412
-->
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script type="text/javascript">
	//alert('OPFrames..');
	var jsonEMObj=window.dialogArguments;
	var warnOnClose = false;
	var warnMsg = "";
	function OPclose()
	{ 
		parent.window.returnValue=false; 
		if(placeMealOrderEMMain.gRecordUpdated.length > 0)
		{
			warnOnClose = true;
			warnMsg = getMessage("DS_CONFIRM_TO_CONT","DS");
			
			if(window.confirm(warnMsg))
				top.close();
			else
				warnOnClose = false;
				
			/*var sMsg = "The Changes will not be Saved. Are you sure you wish to continue?";
			var dialogUrl1 = "../../eDS/jsp/CommonDialogBox.jsp?dialogMessage="+sMsg;
			var dialogFeatures = "dialogHeight:5;dialogWidth:30;status:no;scroll:no";
			var returnValue = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);

			if(returnValue)
				top.close();
			else
				warnOnClose = false;*/
			
		}else
		{
			warnOnClose = true;
			top.close();
		}
		
	}
	
	window.onbeforeunload  = function OPautoClose() {
		if(!warnOnClose)
			return "";
	};
	
	function reset(){
		placeMealOrderEMMain.location.href='../../eDS/jsp/PlaceMealOrderEMMain.jsp';
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?';
	}
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css" : (String) session.getAttribute("PREFERRED_STYLE");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String location_EM=request.getParameter("location");//ML-MMOH-CRF-0596
	String jsonData = request.getParameter("jsonData");
	String source = url + params ;    
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
<title>Place Meal Order for Emergency Patients</title>

</head>

	<iframe name='toolbarFrame' id='toolbarFrame'  src="../../eDS/jsp/PlaceMealOrderEMSubmit.jsp"	 frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw;border:1'></iframe>
	<iframe name="placeMealOrderEMMain" id="placeMealOrderEMMain" src="../../eDS/jsp/PlaceMealOrderEMMain.jsp?<%=request.getQueryString()%>" scrolling="no" frameborder="0" noresize="noresize" style="height:80vh;width:100vw;border:1"></iframe>
	<iframe name="messageFrame" id="messageFrame"	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=1 noresize scrolling='auto' style='height:10vh;width:100vw;border:1'></iframe>
</html>

