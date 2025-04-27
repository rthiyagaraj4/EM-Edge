<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,eIPAD.selectorder.*,eIPAD.selectorder.healthobject.*,eIPAD.selectorder.request.*,eIPAD.selectorder.response.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String locale = "en";
String patientClass = "";
if(request.getParameter("patientclass") != null)
{
	 patientClass = request.getParameter("patientclass");
}

OrderCategoryRequest oCategoryReq = new OrderCategoryRequest();
oCategoryReq.setRequest(request);
oCategoryReq.setLanguageID(locale);
oCategoryReq.setCalledFrom("TickSheet");
OrderCategoryResponse oCategoryRes = null;
List<OrderCategoryHO> lstOrderCategory = new ArrayList<OrderCategoryHO>();

SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();

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
<link rel="stylesheet" href="../css/iPadOrderTickSheet.css" />
</head>
<script>
function showTickSheetResults()
{
	var orderCategory = document.getElementById("cmbOrderCategory").value;
	document.getElementById("tickSheetFrame").src = "TickSheet.jsp?ordercategory=" + orderCategory;
	if(orderCategory!=null && orderCategory!="")
	{
		var headcontent = $("#cmbOrderCategory option:selected").text();
		tickSheetHeader(headcontent,"");
	}
	else
	{
		tickSheetHeader("","");
	}

}
function showTicksheetSection(tickSheetId,tickSheetDesc)
{
	var orderCategory = document.getElementById("cmbOrderCategory").value;
	var patclass = document.getElementById("hdnPatClass").value;
	var url = "TickSheetItems.jsp?ticksheetid=" + tickSheetId + "&patientclass=" + patclass +"&ordercategory="+ orderCategory;
	document.getElementById("tickSheetFrame").src = url;
	var headContent = $("#cmbOrderCategory option:selected").text();
	tickSheetHeader(headContent,tickSheetDesc);
}

function tickSheetHeader(content, content01)
{
	if(content==null || content=="")
	{
		$("#tickSheetHeaderContentarea01").html("Tick Sheets");
		$("#tickSheetHeaderContentcell").css("display","none");
		$("#tickSheetHeaderRightarrowcelltree").css("display","none");
	}
	else if(content01==null || content01=="")
	{
		$("#tickSheetHeaderContentarea01").html(content);
		$("#tickSheetHeaderContentcell").css("display","none");
		$("#tickSheetHeaderRightarrowcelltree").css("display","none");
	}
	else
	{
		$("#tickSheetHeaderContentcell").css("display","table-cell");
		$("#tickSheetHeaderRightarrowcelltree").css("display","table-cell");
		$("#tickSheetHeaderContentarea01").html(content01);
		$("#tickSheetHeaderContentarea").html(content);
	}
}
function changeOrientation(orient)
{
	if(orient == "landscape")
	  {
		document.getElementById("tickSheetFrame").contentWindow.changeOrientation(orient);
	  }
  else
	  {
	    document.getElementById("tickSheetFrame").contentWindow.changeOrientation(orient);    
	  }
}
function deselectCheckBox(orderCatalogCode,orderId)
{
	 document.getElementById("tickSheetFrame").contentWindow.deselectCheckBox(orderCatalogCode,orderId);
}
</script>
<body >
	<section data-role = "page" style = "padding:0px;background-color : #ffffff">
		 <form id = "frmBaseTickSheet" method = "post" >
		 	<div data-role = "none" class ='divTickSheetmain' id = 'dvmain'  style="padding:0px">
		 		<div id = "dvCriteria" class = "dvCriteria">
		 		  <table style="height:auto;width:100%" >
		 		    <tr style = "height:auto;width:100%">
		 		      <td style = "height:auto;width:90%">
		 		        <table style="height:65px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
		 			  <tr style="height:30px;width:100%">
		 			    <td align = "left" style="width:33%" valign = "center"><span class = "spanPeriod">Order Category</span></td>
                        <td style="width:33%"> &nbsp;</td>
                        <td style="width:33%"> &nbsp;</td>
				         
		 			  <tr>
		 			 
		 			  
		 			  <tr style="height:35px;width:100%">
		 			     <td align = "left" style="width:33%">
					        <select  class="cmbPeriod" data-role="none" id="cmbOrderCategory" name = "cmbOrderCategory" onchange="showTickSheetResults()" > 
					          <option value = "">Select</option>
					         <%
					          try
					         {
					        	  int nOrderCatCount = 0;
					        	  OrderCategoryHO oCategoryHO = null;
					        	  oCategoryRes = oSelectOrderDetails.getOrderCategory(oCategoryReq);
					        	  if(oCategoryRes != null)
					        	  {
					        		  lstOrderCategory = oCategoryRes.getLstOrderCategory();
					        		  if(lstOrderCategory != null)
					        		  {
					        			  nOrderCatCount = lstOrderCategory.size();
					        			  if(nOrderCatCount > 0)
					        			  {
					        				  int nLoopCount = 0;
					        				  for(nLoopCount = 0 ; nLoopCount < nOrderCatCount; nLoopCount ++)
					        				  {
					        					  oCategoryHO = lstOrderCategory.get(nLoopCount);
					        					  if(oCategoryHO != null)
					        					  {
					        						 
					        						  %>
					        						   <option value = "<%=oCategoryHO.getOrderCategory() %>" > <%=oCategoryHO.getShortDescription() %></option>
					        						  <% 
					        					  }
					        				  }
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
							</select> 
			            </td>
			            
			            <td style="width:33%"> &nbsp;</td>
                        <td style="width:33%"> &nbsp;</td>
			            
			           
		 			  </tr>
		 			
		 			</table>
		 		      </td>
		 		     <td align = "center" style="width:10%"  valign = "bottom" onclick = "showTickSheetResults()"><img src = "../images/SearchOrder.PNG"></img></td>
		 		    <tr>
		 		  </table>
		 			
		 		</div>
		 	 	<div id="resultPageHeaderTickSheet"  class="resultPageHeaderTickSheet">
					
							<div id="tickSheetHeaderContainer" style="height:30px">
								<div id="tickSheetHeaderRow">
							        <div id="tickSheetHeaderContentcell" style="display:none" onclick="showTickSheetResults()">
							        	<div id="tickSheetHeaderContentarea">
							           Tick Sheets
							            </div>
							        </div>
							        <div id="tickSheetHeaderRightarrowcelltree" style="display:none">
							            <div id="tickSheetHeaderArrow-right">
							            </div>
							        </div>
							        <div id="tickSheetHeaderContentcell01">
							        	<div id="tickSheetHeaderContentarea01">
							           Tick Sheets
							            </div>
							        </div>
							        <div id="tickSheetHeaderRightarrowcell01">
							            <div id="tickSheetHeaderArrow-right01">
							            </div>
							        </div>
							       
							       
							    </div>
							</div>
					
				</div>
				<div id = "serachResults" data-role = "none" class = "dvSearchResults">
				  
				  <div style = "height:auto;overflow:auto;padding:0px;data-role = "none">
                      <iframe frameborder="0" id="tickSheetFrame"   src = "TickSheet.jsp" scrolling ="yes" style="padding:0px;display:block" width = "100%" ></iframe>
                  </div>   
					
				</div>
		 	</div>
		 
         <input type = "hidden" id = "hdnPatClass" name = "hdnPatClass" value = "<%= patientClass %>" />
         <input type = "hidden" id = "hdnArrowContentArea" name = "hdnArrowContentArea" value = "" />
         <input type = "hidden" id = "hdnArrowContentArea01" name = "hdnArrowContentArea01" value = "" />
		 </form>
	  
	</section>
</body>
</html>

