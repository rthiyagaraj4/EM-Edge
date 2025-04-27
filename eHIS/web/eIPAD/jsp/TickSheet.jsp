<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,eIPAD.selectorder.*,eIPAD.selectorder.healthobject.*,eIPAD.selectorder.request.*,eIPAD.selectorder.response.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String locale = "en";
String orderCategory = "";
if(request.getParameter("ordercategory") != null)
{
	orderCategory = request.getParameter("ordercategory");
}
TickSheetRequest oTckSheetReq = new TickSheetRequest();

oTckSheetReq.setRequest(request);
oTckSheetReq.setLanguageID(locale);
oTckSheetReq.setOrderCategory(orderCategory);
if(session.getValue("ca_practitioner_id") != null)
{
	oTckSheetReq.setClinicianID((String)session.getValue("ca_practitioner_id"));
}
oTckSheetReq.setServiceCode((String)session.getValue("ServiceCode"));
if(session.getValue("facility_id") != null )
{
	oTckSheetReq.setFacilityId((String)session.getValue("facility_id"));
}
String locnType = (String)session.getValue("LocnType");
if(locnType != null && locnType.equalsIgnoreCase("W"))
{
	locnType = "N";
}
oTckSheetReq.setLocationType(locnType);
oTckSheetReq.setLocationCode((String)session.getValue("LocnCode"));

%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<link rel="stylesheet" href="../css/iPadOrder.css" />
</head>
<script>
function showTickSheetSection(tickSheetId, tickSheetDesc)
{
	//alert(tickSheetId);
	window.parent.showTicksheetSection(tickSheetId, tickSheetDesc);
}
function changeOrientation(orient)
{
	if(orient == "landscape")
	  {
		
	  }
  else
	  {
	      
	  }
}
function deselectCheckBox(orderCatalogCode,orderId)
{
	 //document.getElementById("tickSheetFrame").contentWindow.deselectCheckBox(orderCatalogCode,orderId);
}
$(document).ready(function () {
	//window.parent.parent.setAlignment();
});
</script>
<body >
	<section data-role = "page" style = "padding:0px;background-color : #ffffff">
		 <form id = "frmTickSheet" method = "post" >
		 	<div data-role = "none" class ='divTickSheetmain' id = 'dvmain'  style="padding:0px">
		 		
		 	 
				<div id = "serachResults" data-role = "none" class = "dvSearchResults">
				  <%
				  SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();
				  List<TickSheetHO> lstTickSheet = null;
				  TickSheetHO oTckSheetHO = null;
				  TickSheetResponse oTckRes = null;
				  int nTckCount = 0;
				  int nLoopCount = 0;
				  try{
					  oTckRes = oSelectOrderDetails.getTickSheet(oTckSheetReq);
					  if(oTckRes != null)
					  {
						  lstTickSheet = oTckRes.getLstTickSheet();
						  if(lstTickSheet != null)
						  {
							  nTckCount = lstTickSheet.size();
							  if(nTckCount > 0)
							  {
								  for(nLoopCount = 0 ; nLoopCount < nTckCount; nLoopCount ++)
								  {
									  oTckSheetHO =  lstTickSheet.get(nLoopCount);
									  if(oTckSheetHO != null)
									  {
										  %>
										  <table class = "tbSearchResults" cellpadding = "0" cellspacing = "0">
													  <tr style = "width:100%;height:100%">
													   
													    <td align = "left" valign = "center" style = "height : 100%;width:100%" onclick = "showTickSheetSection('<%=oTckSheetHO.getTickSheetId()%>', '<%=oTckSheetHO.getTickSheetDesc()%>')">
													    	<span class = "spanResultContent"><%=oTckSheetHO.getTickSheetDesc() %></span>
													    </td>
													  <tr>
												</table>
										  <% 
									  }
								  }
							  }//ntck count
							  else
			    			  {
			    				  %>
			    				     <%= IPADConstants.NORECORDS_HTML%>
			    				  <% 
			    			  }
						  }
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
		 

		 </form>
	  
	</section>
</body>
</html>

