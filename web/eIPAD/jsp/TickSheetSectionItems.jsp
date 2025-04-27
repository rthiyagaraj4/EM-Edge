<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,eIPAD.selectorder.*,eIPAD.selectorder.healthobject.*,eIPAD.selectorder.request.*,eIPAD.selectorder.response.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String locale = "en";
String patientClass = "";
String sectionCode = "";
String tickSheetId = "";
String orderCategory = "";
String orderCatalogNature = "P";
String encounterId = "";
boolean bPostBack = false;
if(request.getParameter("patientclass") != null)
{
	 patientClass = request.getParameter("patientclass");
}
if(request.getParameter("ordercategory") != null)
{
	orderCategory = request.getParameter("ordercategory");
}
if(request.getParameter("ticksheetid") != null)
{
	 tickSheetId = request.getParameter("ticksheetid");
}
if(request.getParameter("sectioncode") != null)
{
	sectionCode = request.getParameter("sectioncode");
}
if(request.getParameter("hdnPostBack") != null && request.getParameter("hdnPostBack").trim().equals("true"))
{
	bPostBack = true;
}

if(bPostBack)
{
	if(request.getParameter("hdnPatientClass") != null)
	{
		 patientClass = request.getParameter("hdnPatientClass");
	}
	if(request.getParameter("hdnOrderCategory") != null)
	{
		orderCategory = request.getParameter("hdnOrderCategory");
	}
	if(request.getParameter("hdnTickSheetId") != null)
	{
		 tickSheetId = request.getParameter("hdnTickSheetId");
	}
	if(request.getParameter("hdnSectionCode") != null)
	{
		sectionCode = request.getParameter("hdnSectionCode");
	}
	if(request.getParameter("hdnCatalogNature") != null)
	{
		orderCatalogNature = request.getParameter("hdnCatalogNature");
	}
}
TickSheetItemsReq oTckItmsReq = new TickSheetItemsReq();
oTckItmsReq.setRequest(request);
oTckItmsReq.setLanguageId(locale);
if(session.getValue("practitioner_type") != null )
{
	oTckItmsReq.setPracType((String)session.getValue("practitioner_type"));
}
if(session.getValue("facility_id") != null )
{
	oTckItmsReq.setFacilityID((String)session.getValue("facility_id"));
}
String locnType = (String)session.getValue("LocnType");
if(locnType != null && locnType.equalsIgnoreCase("W"))
{
	locnType = "N";
}
oTckItmsReq.setLocationType(locnType);
oTckItmsReq.setLocationCode((String)session.getValue("LocnCode")); 
oTckItmsReq.setPrivApplicabilityYN("");
if(session.getValue("ca_practitioner_id") != null)
{
	oTckItmsReq.setClinicianID((String)session.getValue("ca_practitioner_id"));
}
if(session.getValue("responsibility_id") != null )
{
	oTckItmsReq.setResponsibilityID((String)session.getValue("responsibility_id"));
}
oTckItmsReq.setTickSheetId(tickSheetId);
oTckItmsReq.setSectionCode(sectionCode);
oTckItmsReq.setPatientClass(patientClass);
oTckItmsReq.setOrderCatalogNature(orderCatalogNature);
oTckItmsReq.setOrderCategory(orderCategory);
if(session.getValue("EpisodeId") != null )
{
	oTckItmsReq.setEncounterID((String)session.getValue("EpisodeId"));
	encounterId = (String)session.getValue("EpisodeId");
}
if(session.getValue("Gender") != null )
{
	oTckItmsReq.setGender((String)session.getValue("Gender"));
}
if(session.getValue("DOB") != null )
{
	oTckItmsReq.setDOB((String)session.getValue("DOB"));
}
oTckItmsReq.setAdmitDate((String)session.getValue("AdmitDate")); 
oTckItmsReq.setDischargeDateTime((String)session.getValue("DischargeDateTime"));

%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<link rel="stylesheet" href="../css/iPadOrder.css" />
</head>
<script>
function getOrderContents()
{

}
function Loading()
{
	var catalogCode = window.parent.parent.parent.returnCatalogCode();
	//alert(catalogCode);
	if(catalogCode != null)
	{
		var arCount = catalogCode.length;
		var i = 0;
		var code = "";
		for(i=0;i<arCount;i++)
		{
			code = catalogCode[i];
			//data-orderCatalogCode
			if($("[data-orderCatalogCode = '" + code + "']") != null)
			 $("[data-orderCatalogCode = '" + code + "']").attr('checked',true);
		}
	}
	
	catalogNature =document.getElementById("hdnCatalogNature").value;
	if(catalogNature=="P")
		$("#panelButton").removeClass('buttonStyle').addClass('buttonHighlight');
	else if(catalogNature=="A")
		$("#induvidualButton").removeClass('buttonStyle').addClass('buttonHighlight');
	else if(catalogNature=="S")
		$("#orderSetButton").removeClass('buttonStyle').addClass('buttonHighlight');
}
function filterOrderContents(catalogNature)
{
   document.getElementById("hdnPostBack").value = "true";
   document.getElementById("hdnCatalogNature").value = catalogNature;
   document.getElementById("frmSectionItems").submit();
}
function addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId)
{
	var promptMsg = $(obj).attr('data-promptMsg');
	if(promptMsg != null && promptMsg != "" && obj.checked)
	{
		alert(promptMsg);
	}
	window.parent.parent.parent.addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId);
}
function deselectCheckBox(orderCatalogCode,orderId)
{
	if($("[data-orderCatalogCode = '" + orderCatalogCode + "']") != null)
	{
		$("[data-orderCatalogCode = '" + orderCatalogCode + "']").attr('checked',false);
	}
}
</script>
<body onload = "Loading()">
	<section data-role = "page" style = "padding:0px;background-color : #ffffff">
		 <form id = "frmSectionItems" method = "post" >
		 	<div data-role = "none" class ='divTickSheetmain' id = 'dvmain'  style="padding:0px">
		 	    
		 		
		 	 	<div id="resultPageHeader"  class="resultPageHeader">
					<table style="height: 100%; width: 100%" cellpadding="0"
						cellspacing="0" border="0">
						<tr style="height: 100%; width: 100%">
							<td style="width: 38%"><span class="resultTextStyle">
							</span></td>
							<td style="width: 20%" align="right" valign="center"><input
								type="button" value="Panel" data-role = "none" class="buttonStyle" id="panelButton" onclick = "filterOrderContents('P')"/></td>
							<td style="width: 20%" align="right" valign="center"><input
								type="button" value="Individual" data-role = "none" class="buttonStyle" id="induvidualButton" onclick = "filterOrderContents('A')"/></td>
							<td style="width: 20%" align="right" valign="center"><input
								type="button" value="Order Set" data-role = "none" class="buttonStyle" id="orderSetButton" onclick = "filterOrderContents('S')"/></td>
							 <td style="width: 2%">&nbsp;</td>
			
						</tr>
					</table>
				</div>
				<div id = "sectionItems" data-role = "none" class = "dvsecItems">
				 <%
				  TickSheetItemRes oTckSecItemRes = null;
				  List<TickSheetItemHO> lstTickSheetItem = null;
				  int nLoopCount = 0;
				  int nLstCount = 0;
				  TickSheetItemHO oTckItemHO = null;
				  String promptYN = "";
			      String promptMsg = "";
			      
				  SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();
				  try
				  {
					  oTckSecItemRes = oSelectOrderDetails.getTickSheetSectionItems(oTckItmsReq);
					  if(oTckSecItemRes != null)
					  {
						  lstTickSheetItem = oTckSecItemRes.getLstTickSheetItem();
					  }
					  if(lstTickSheetItem != null)
					  {
						  nLstCount = lstTickSheetItem.size();
					  }
					  if(nLstCount > 0)
					  {
						  for(nLoopCount = 0 ; nLoopCount < nLstCount; nLoopCount ++)
						  {
							  oTckItemHO = lstTickSheetItem.get(nLoopCount);
							  if(oTckItemHO != null)
							  {
								  	 promptYN = oTckItemHO.getPromptAlertYN();
	    							 if(promptYN != null && promptYN.equalsIgnoreCase("Y"))
	    							 {
	    								 promptMsg = oTckItemHO.getPromptMsg();
	    							 }
	    							 else
	    							 {
	    								 promptMsg = "";
	    							 }
								  %>
								  	 <table class = "tbSearchResults" cellpadding = "0" cellspacing = "0">
													  <tr style = "width:100%;height:100%">
													    <td align = "center" valign = "center" style = "height : 100%;width:10%">
													      <input type = "checkbox" data-role = "none" class = "chkBox" id = "chkBox<%=nLoopCount%>" data-promptMsg = "<%= promptMsg %>" data-catalogNature = "<%=oTckItemHO.getOrderCatalogNature()%>" data-currentCatlogNatue = "<%=orderCatalogNature %>" data-orderId = "" data-orderCatalogCode = "<%= oTckItemHO.getOrderCatalogCode()%>" name = "chkBox<%=nLoopCount%>" onclick = "addToSaveArea('<%= oTckItemHO.getOrderCatalogCode()%>','<%=encounterId%>','<%=oTckItemHO.getCatalogSynonym()%>',this,'')"/>
													    </td>
													    <td align = "left" valign = "center" style = "height : 100%;width:90%;word-break:break-all" >
													    	<span class = "spanResultContent"><%= oTckItemHO.getCatalogSynonym()%></span>
													    </td>
													  <tr>
												</table>
								  <% 
							  }
						  }
					  }//lstcount > 0
					  else
	    			  {
	    				  %>
	    				     <%= IPADConstants.NORECORDS_HTML%>
	    				  <% 
	    			  }
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
					  out.println(e.toString());
				  }
				 
						 
				 %>
					
				</div>
		 	</div>
		 	<input type = "hidden" id = "hdnPostBack" name = "hdnPostBack" value = "false" />
		 	<input type = "hidden" id = "hdnPatientClass" name = "hdnPatientClass"  value = "<%=patientClass%>"/>
		 	<input type = "hidden" id = "hdnOrderCategory" name = "hdnOrderCategory" value = "<%=orderCategory%>"/>		
		 	<input type = "hidden" id = "hdnCatalogNature" name = "hdnCatalogNature" value = "<%=orderCatalogNature%>"/>
		 	<input type = "hidden" id = "hdnTickSheetId" name = "hdnTickSheetId" value = "<%=tickSheetId%>"/>
		 	<input type = "hidden" id = "hdnSectionCode" name = "hdnSectionCode" value = "<%=sectionCode%>"/>
		 	<input type = "hidden" id = "hdnEncounterId" name = "hdnEncounterId" value = "<%=encounterId%>"/>
		 	
		 	
		 	
		 </form>
	  
	</section>
</body>
</html>

