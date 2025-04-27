<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderOPResultTail.jsp
File Description: Second Frame of Result Page: This is to search all the Outpatients who 
						1) Books an appointment but yet to visit 
						2) Visit clinic with appointment
						3) Direct Visit without appointment
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="Javascript" src="../../eDS/js/json.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript">
var EMCount = 0;
//Function: Loading Kitchen for the given Speciality:
function setKitchen(){

	//var speciality = parent.qa_query_result.document.getElementById("hdnSpeciality").value;
	var speciality  = parent.parent.placeMealOrderOPSearch.document.getElementById("hdnHdrSpeciality").value;
	var facilityid 	= parent.parent.placeMealOrderOPSearch.document.getElementById("facility_id").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="language_Id=en&mode=loadKitchen_EM&speciality="+speciality+"&facilityid="+facilityid;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert('param'+param);
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	
	//Getting Kitchen Code and OPMealtype Count::
	var kitchenCode = jsonObjResponse.kitchenCode;
	EMCount = jsonObjResponse.EMCount;
	
	parent.parent.placeMealOrderOPSearch.document.getElementById("hdnkitchen").value = kitchenCode;
}

//Function: For Launching Place Meal Order window :
async function placeEMMealOrder()
	{ 
		setKitchen();
	
		var kitchen = parent.parent.placeMealOrderOPSearch.document.getElementById("hdnkitchen").value;
	
		if(kitchen == "")
		{
			alert(getMessage("DS_KIT_NOTAVAIL_FOR_SPEC","DS"));
			return;
		}
		
		if(EMCount < 1)
		{
			alert(getMessage("DS_MTYP_NOTCONFIG_EM","DS"));
			return;
		}
		
		var retVal =    new String();
		var dialogHeight    = "500px" ;
		var dialogWidth = "900px" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
		
		var divOrderList = parent.qa_query_result.document.getElementById("divOrderList");
		var jsonDataObject = new Object();
		jsonDataObject.facilityid 	= parent.parent.placeMealOrderOPSearch.document.getElementById("facility_id").value;
		jsonDataObject.speciality 	= parent.parent.placeMealOrderOPSearch.document.getElementById("hdnHdrSpeciality").value;
		var location = parent.parent.placeMealOrderOPSearch.document.getElementById("hdnlocation_EM").value;//ML-MMOH-CRF-0596
		var arrEnctObject = new Array();
		parent.qa_query_result.chkGlobalValues();
        	jsonDataObject.enctObj = parent.globalForEnctRecord;
          	var jsonData = JSON.stringify(jsonDataObject);
		var arguments="jsonData="+jsonData+"&language_Id=en&mode=loadEMMealOrder";
		var urlpat="../../eDS/jsp/PlaceMealOrderEMFrames.jsp?location="+location;//ML-MMOH-CRF-0596
		retVal =await top.window.showModalDialog(urlpat,arguments,features);//ML-MMOH-CRF-0596
		jsonDataObject = new Object();
		indexRecord = 0;
		if(retVal == "true" || retVal == true)
		{
			while(parent.globalForEnctRecord.length > 0) 
			{
				parent.globalForEnctRecord.splice(0, 1);
			}
			while(parent.globalForApptRecord.length > 0) 
			{
				parent.globalForApptRecord.splice(0, 1);
			}
			parent.qa_query_result.document.getElementById("hdnplaceorder").value = 0;
			//globalForSelRecord = new Array();
			//parent.frames.placeMealOrderOPResult.location.href ="../../eDS/jsp/PlaceMealOrderOPResultFrame.jsp";
			parent.frames.qa_query_result.location.href ="../../eDS/jsp/PlaceMealOrderEMResult.jsp?from=&to=";
			parent.frames.qa_query_result_tail.location.href ="../../eDS/jsp/PlaceMealOrderEMResultTail.jsp";
		}
	}

	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!--<fmt:setBundle basename="eDS.resources.Labels" var="ds_labels"/>-->
  </head>
    <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
    <form >
	<div id="placeOrder">
	<table width="100%" ><tr><td align=right><INPUT type="button" disabled align=right name="btnplaceOrder" id="btnplaceOrder" value="<fmt:message key="eDS.placeOrder.Label" bundle="${ds_labels}" />" class="button" onClick="placeEMMealOrder();"/>
	</td></tr>
	</table>
	</div>
    <table border="1" cellpadding=3  cellspacing="1" width="100%">

	<td align=='right' width='3%' class='OAGREEN'> </td>
	<td align='left' width='13%' colspan='3' class='label'><fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}"/></td>

	<td align='right' width='3%' class='OARED'></td>
	<td align='left' width='13%' colspan='3' class='label'><fmt:message key="eOT.OrderPendingForPatient.Label" bundle="${ot_labels}"/></td>

	<td align='right' width='3%' class='OAYELLOW'> </td>
	<td align='left' width='13%' colspan='3' class='label'><fmt:message key="eOT.OrderModified.Label" bundle="${ot_labels}"/></td>
	
	<!--Added Against ML-MMOH-CRF-0600 Starts Here-->
	<td align='right' width='3%' ><img src="../../eDS/css/Action_Pending.PNG"></img></td>
	<td align='left' width='13%' colspan='3' class='label'><fmt:message key="eDS.PendingMealAcknowledgements.Label" bundle="${ds_labels}"/></td>
	<!--Added Against ML-MMOH-CRF-0600 Ends Here-->
	</tr>

    </table>    
    </form>
    </body>
</html>

