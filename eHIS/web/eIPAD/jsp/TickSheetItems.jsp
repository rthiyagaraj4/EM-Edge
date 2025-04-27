<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,eIPAD.selectorder.*,eIPAD.selectorder.healthobject.*,eIPAD.selectorder.request.*,eIPAD.selectorder.response.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
 String locale = "en";
 String tickSheetId = "";
 String orderCategory = "";
 if(request.getParameter("ordercategory") != null)
 {
 	orderCategory = request.getParameter("ordercategory");
 }
 if(request.getParameter("ticksheetid") != null)
 {
	 tickSheetId = request.getParameter("ticksheetid");
 }
 String patientClass = "";
 if(request.getParameter("patientclass") != null)
 {
 	 patientClass = request.getParameter("patientclass");
 }
 TickSheetRequest oTckSheetReq = new TickSheetRequest();
 oTckSheetReq.setRequest(request);
 oTckSheetReq.setLanguageID(locale);
 oTckSheetReq.setOrderCategory(orderCategory);
 oTckSheetReq.setTickSheetId(tickSheetId);
 
 
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
function showTickSheetSectionItems(sectionCode,tickSheetId,currentObj)
{
	var patclass = document.getElementById("hdnPatClass").value;
	var orderCategory = document.getElementById("hdnOrderCategory").value
	var url = "TickSheetSectionItems.jsp?sectioncode=" + sectionCode+ "&ticksheetid=" + tickSheetId+ "&patientclass=" + patclass+"&ordercategory="+ orderCategory;;
	document.getElementById("tickSheetSectionFrame").src = url;
	//tbSearchResultsActive
	 $("[data-class = 'normal']").each(function(index, value) { 
	    $(this).attr("class" , "tbSearchResults");
	 });
	currentObj.setAttribute("class","tbSearchResultsActive");
}
function changeOrientation(orient)
{
	if(orient == "landscape")
	  {
	     $("#dvTickSection").css('min-height','342px');
	     $("#dvSectionItems").css('min-height','342px');
	    
	     $("#tickSheetSectionFrame").css('min-height','342px');
	  }
  else
	  {
	     $("#dvTickSection").css('min-height','599px');
	     $("#dvSectionItems").css('min-height','599px');
	     $("#tickSheetSectionFrame").css('min-height','599px');
	  }
}
function deselectCheckBox(orderCatalogCode,orderId)
{
	var obj = document.getElementById("tickSheetSectionFrame");
	if(obj != null && obj.contentWindow != null)
	{
		obj.contentWindow.deselectCheckBox(orderCatalogCode,orderId);
	}
	// document.getElementById("tickSheetSectionFrame").contentWindow.deselectCheckBox(orderCatalogCode);
}
$(document).ready(function () {
	//window.parent.parent.setAlignment();
});
</script>

<body  style = "background-color : #ffffff" >
	<section data-role = "page" style = "padding:0px;background-color : #ffffff">
		 <form id = "frmTickSheetItem" method = "post" >
			 <div data-role = "none" class ='divTickSheetmain' id = 'dvmain'  style="padding:0px" >
			  
			   
			   <div id = "dvTickSection" class = "dvTickSections" data-role = "none">
			   
			     <%
				  SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();
				  List<TickSheetHO> lstTickSheet = null;
				  TickSheetHO oTckSheetHO = null;
				  TickSheetResponse oTckRes = null;
				  int nTckCount = 0;
				  int nLoopCount = 0;
				  try{
					  oTckRes = oSelectOrderDetails.getTickSheetSection(oTckSheetReq);
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
										  <table class = "tbSearchResults" cellpadding = "0" cellspacing = "0" data-class = "normal" onclick = "showTickSheetSectionItems('<%=oTckSheetHO.getSectionCode()%>','<%=tickSheetId%>',this)">
													  <tr style = "width:90%;height:100%">
													   
													    <td align = "left" valign = "center" style = "height : 100%;width:88%" >
													    	<span class = "spanResultContent"><%=oTckSheetHO.getSectionDesc() %></span>
													    </td>
													    <td align = "center" valign = "center" style = "width:12%;height:100%">
													      <img src = "../images/Ticksheetarrow.PNG"></img>
													    </td>
													  <tr>
												</table>
										  <% 
									  }
								  }
							  }
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
			   <div id = "dvSectionItems" class = "dvSectionItems" data-role = "none">
			     <div style = "height:auto;overflow:auto;padding:0px;" data-role = "none">
                      <iframe frameborder="0" id="tickSheetSectionFrame"   class= "tickSheetFrame" scrolling ="yes" style="padding:0px;display:block" width = "100%" ></iframe>
                  </div> 
			    
			   </div>
			</div>
			<input type = "hidden" id = "hdnPatClass" name = "hdnPatClass" value = "<%= patientClass %>" />
			<input type = "hidden" id = "hdnOrderCategory" name = "hdnOrderCategory" value = "<%=orderCategory %>" />
		 </form> 
	</section>  
</body>

</html>

