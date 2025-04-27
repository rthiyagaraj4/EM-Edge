<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,eIPAD.selectorder.*,eIPAD.selectorder.healthobject.*,eIPAD.selectorder.request.*,eIPAD.selectorder.response.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String locale = "en";
String patientClass = "";
String orderPeriod = "";
int dayValue = 1;

OrderCategoryRequest oCategoryReq = new OrderCategoryRequest();
oCategoryReq.setRequest(request);
oCategoryReq.setLanguageID(locale);
oCategoryReq.setCalledFrom("ALL");
OrderCategoryResponse oCategoryRes = null;
List<OrderCategoryHO> lstOrderCategory = new ArrayList<OrderCategoryHO>();
ExistingOrderRequest existingOrderReq = new ExistingOrderRequest();

/*
 Creating the request object to get the order contents based on the criteria selected.
*/
String postBack = "";
String orderCategory = "";
String currentEncounterId = "";
String viewEncounter = "";
String toDate = DateUtils.getCurrentDate("DMY", "en");
String fromDate;
String strInterval = "d";


if(request.getParameter("hdnPostBack") != null)
{
	postBack = request.getParameter("hdnPostBack");

}

if(postBack != null && postBack.equals("true"))
{
	existingOrderReq.setRequest(request);
	existingOrderReq.setSession(session);
	existingOrderReq.setLanguageId(locale);
	if(session.getValue("practitioner_type") != null )
	{
		existingOrderReq.setPracType((String)session.getValue("practitioner_type"));
	}
	if(session.getValue("PatientID") != null)
	{
		existingOrderReq.setPatientId((String)session.getValue("PatientID"));
	}
	

	if(request.getParameter("cmbCurrentEncounter") != null)
	{
		viewEncounter = request.getParameter("cmbCurrentEncounter");
	}
	
	if(session.getValue("EpisodeId") != null && viewEncounter.equals("CUR"))
	{
		existingOrderReq.setEncounterId((String)session.getValue("EpisodeId"));
	}
	
	if(request.getParameter("cmbOrderCategory") != null)
	{
		orderCategory = request.getParameter("cmbOrderCategory");
	}
	if(session.getValue("EpisodeId") != null)
	{
		currentEncounterId = (String)session.getValue("EpisodeId");
	}
	if(request.getParameter("cmbPeriod") != null)
	{
		orderPeriod = request.getParameter("cmbPeriod");
	}

	if(orderPeriod.equals("OW") )
	{
		strInterval = "w";
	}
	if(orderPeriod.equals("OM") )
	{
		strInterval = "M";
	}
	if(orderPeriod.equals("OY") )
	{
		strInterval = "Y";
	}
	if(orderPeriod.equals("OD") )
	{
		strInterval = "d";
	}
	if(orderPeriod.equals("TD") )
	{
		strInterval = "d";
		dayValue = 3;
	}

	fromDate = DateUtils.minusDate(toDate, "DMY", "en", dayValue, strInterval);
	existingOrderReq.setFromDate(fromDate);
	existingOrderReq.setToDate(toDate);
	existingOrderReq.setOrderCategory(orderCategory);

	
}
SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();

%>
<!DOCTYPE html>
<html>
<head>
<title>Existing Orders</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />
<script src="../jquery-1.5.2.min.js"></script>
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<link rel="stylesheet" href="../css/iPadOrder.css" />

<script type="text/javascript">
function changeOrientation(orient)
{

}
function getOrderContents()
{
	document.getElementById("hdnOrderPeriod").value = document.getElementById("cmbPeriod").value;
	document.getElementById("hdnViewEncounter").value = document.getElementById("cmbCurrentEncounter").value;
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("frmExistingOrder").submit();
}


function deselectCheckBox(orderCatalogCode,orderId)
{
	if($("[data-orderId = '" + orderId + "']") != null)
	{
		$("[data-orderId = '" + orderId + "']").attr('checked',false);
	}
		// $("[data-orderCatalogCode = '" + orderCatalogCode + "']").removeAttr('checked');
}

function Loading()
{
	//document.getElementById("cmbOrderCategory").value = document.getElementById("hdnOrderCategory").value;
	//document.getElementById("cmbOrdCriteria").value = document.getElementById("hdnCriteriaCombo").value;
	//document.getElementById("cmbOrderType").value = document.getElementById("hdnOrderType").value;
	//var catalogCode = window.parent.returnCatalogCode();
	//alert(catalogCode);
	document.getElementById("cmbPeriod").value = document.getElementById("hdnOrderPeriod").value;
	document.getElementById("cmbCurrentEncounter").value = document.getElementById("hdnViewEncounter").value;
	var arOrderId = window.parent.returnOrderId();
	if(arOrderId != null)
	{
		var arCount = arOrderId.length;
		//alert(arCount);
		var i = 0;
		var code = "";
		for(i=0;i<arCount;i++)
		{
			code = arOrderId[i];
			//data-orderCatalogCode
			if($("[data-orderId = '" + code + "']") != null)
			 $("[data-orderId = '" + code + "']").attr('checked',true);
		}
	}
	
}

 function showCriteria()
 {
	 $('#divSrchCriteria').slideToggle('fast');
	 if(bShCriteria)
	   {
		        bShCriteria = true;
			   document.getElementById("imgCriteria").src = "../images/Heading-Panel-down-Arrow.png" ;
	   }
	   else
	   {
		       bShCriteria = false;
			   document.getElementById("imgCriteria").src = "../images/Heading-Panel-Up-Arrow.png" ;
	   }
 }
 function addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId)
 {
 	window.parent.addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId);
 }
 $(document).ready(function () {
 	//window.parent.setAlignment();
 });
 </script>
 </head>
 <body onload = "Loading()" >
  <section  data-role="page"  style="padding:0px;" background-color : #ffffff">
  <form name='frmExistingOrder' id='frmExistingOrder' method='post' id="frmExistingOrder" >
  <div data-role = "none" class ='divmain' id = 'dvmain'  style="padding:0px">
	  <div id = "searchPageHeader"   class="resultPageHeader" >
		 <table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  <tr style = "height:100%;width:100%">
			    <td style = "width:95%">
			         <span class = "resultTextStyle">Search</span>
			    </td>
			    <td style = "width:5%" align = "center" valign = "center">
			       
			    </td>


			  </tr>
		    </table>

	  </div>
	   <div class = "dvStroke" data-role ="none"></div>

	  <div id="divSrchCriteria"  data-role ="none" class = "dvCriteria">
	   		 		    <table style="height:auto;width:100%" >
				 		 <tr style = "height:auto;width:100%">
				 		   <td style = "height:auto;width:90%">
		   <table style="height:65px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">

			     <tr style="height:30px;width:100%">
			      <td align = "left" style="width:25%"><span class = "spanPeriod">View</span></td>
			      <td align = "left" style="width:25%"><span class = "spanPeriod">Order Category</span></td>
			      <td align = "left" style="width:25%"><span class = "spanPeriod">Period</span></td>
			      <td style="width:1%">&nbsp;</td>
			     </tr>
			     <tr style="height:35px;width:100%">
			      <td align = "left" style="width:25%">
					<select  class="cmbPeriod" data-role="none" id="cmbCurrentEncounter" name = "cmbCurrentEncounter">
					  <option value = "CUR">Current Encounter Orders</option>
					  <option value = "ALL">All Encounter Orders</option>

					</select>
				</td>
			      <td align = "left" style="width:25%">
				  <select  class="cmbPeriod" data-role="none" id="cmbOrderCategory" name = "cmbOrderCategory">
					  <option value="">Select</option>
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
					        						  String selected = "";
					        						  if(oCategoryHO.getOrderCategory() != null && orderCategory != null && oCategoryHO.getOrderCategory().equals(orderCategory))
					        						  {
					        							  selected = "selected";
					        						  }
					        						  %>
					        						   <option value = "<%=oCategoryHO.getOrderCategory() %>" <%=selected %> > <%=oCategoryHO.getShortDescription() %></option>
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
			      <td align = "left" style="width:25%">
					<select  class="cmbPeriod" data-role="none" id="cmbPeriod" name = "cmbPeriod">
					  <option value = "OD">Last One Day</option>
					  <option value = "TD">Last Three Days</option>
					  <option value = "OW">Last One Week</option>
					  <option value = "OM">Last One Month</option>
					  <option value = "OY">Last One Year</option>
					</select>
				  </td>


			            </tr>


					  </table>

					</td>
				 		   <td align = "center" vaalign = "center" style="width:10%" onclick = "getOrderContents()" ><img src = "../images/SearchOrder.PNG"></img>
				 		   </td>
				 		 </tr>
			 		 </table>
	   </div>

				<div id="resultPageHeader"  class="resultPageHeader">
					<table style="height: 100%; width: 100%" cellpadding="0"
						cellspacing="0" border="0">
						<tr style="height: 100%; width: 100%">
							<td style="width: 7%" align = "center" valign = "center"></td>
							<td style="width: 24%" align = "left" valign = "center"><span class="resultTextStyleExisting">
							Order Catalog</span></td>
							<td style="width: 17%" align = "center" valign = "center"><span class="resultTextStyleExisting">
							Start Date</span></td>
							<td style="width: 19%" align = "center" valign = "center"><span class="resultTextStyleExisting">
							End Date</span></td>
							<td style="width: 16%" align = "center" valign = "center"><span class="resultTextStyleExisting">
							Order Type</span></td>
							<td style="width: 17%" align = "center" valign = "center"><span class="resultTextStyleExisting">
							Status</span></td>

						</tr>
					</table>
				</div>
						<div id = "searchResults" data-role = "none" class = "dvSearchResults">
					<%
				     if(postBack != null && postBack.equals("true"))
				     {
					 ExistingOrderResponse existingOrderRes = null;

				    	 List<ExistingOrderHO> lstExistingOrderHO =  new ArrayList<ExistingOrderHO>();
				    	 ExistingOrderHO existingOrderHO = new ExistingOrderHO();
				    	 int nOrderContentCount = 0;
				    	 int nLoopCount = 0;
				    	 try{
				    		 if(existingOrderReq != null)
				    		 {

				    			 existingOrderRes = oSelectOrderDetails.getExistingOrder(existingOrderReq);
				    			 if( existingOrderRes != null)
				    			 {
				    				 lstExistingOrderHO = existingOrderRes.getLstExtOrderHO();
				    			 }
				    			 if(lstExistingOrderHO != null)
				    			 {
				    				 nOrderContentCount = lstExistingOrderHO.size();
				    				 if(nOrderContentCount > 0)
				    				 {
				    					 for(nLoopCount = 0 ; nLoopCount < nOrderContentCount; nLoopCount ++)
				    					 {
				    						 existingOrderHO = lstExistingOrderHO.get(nLoopCount);
				    						 if(existingOrderHO != null)
				    						 {
				    							 %>
				    							 <table class = "tbSearchResults" cellpadding = "0" cellspacing = "0">
													  <tr style = "width:100%;height:100%">
													    <td align = "center" valign = "center" style = "height : 100%;width:7%">
													      <input type = "checkbox" data-role = "none" class = "chkBox" id = "chkBox<%=nLoopCount%>" data-catalogNature = "" data-currentCatlogNatue = "" data-orderId = "<%= existingOrderHO.getOrderID()%>"  data-orderCatalogCode = "<%= existingOrderHO.getOrderCatalogCode()%>"  
													      onclick = "addToSaveArea('<%= existingOrderHO.getOrderCatalogCode()%>','<%=currentEncounterId%>','<%=existingOrderHO.getOrderDetail()%>',this,'<%= existingOrderHO.getOrderID()%>')" name = "chkBox<%=nLoopCount%>"/>
													    </td>
													    <td align = "left" valign = "center" style = "height : 100%;width:24%;word-break:break-all" >
													    	<span class = "spanResultContentExisting"><%= existingOrderHO.getOrderDetail()%></span>
													    </td>
														<td align = "center" valign = "center" style = "height : 100%;width:17%" >
															<span class = "spanResultContentExisting"><%= existingOrderHO.getStartDate()%></span>
														</td>
														<td align = "center" valign = "center" style = "height : 100%;width:19%" >
															<span class = "spanResultContentExisting"><%= existingOrderHO.getEndDate()%></span>
														</td>
														<td align = "center" valign = "center" style = "height : 100%;width:16%;word-break:break-all" >
															<span class = "spanResultContentExisting"><%= existingOrderHO.getOrderTypeDesc()%></span>
														</td>
														<td align = "center" valign = "center" style = "height : 100%;width:17%;word-break:break-all" >
															<span class = "spanResultContentExisting"><%= existingOrderHO.getOrderStatusDesc()%></span>
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
				    		 out.print(e.toString());
				    	 }
				     }
				  %>
					
				</div>
			</div>
			<input type = "hidden" id = "hdnPostBack" name = "hdnPostBack" value = "false" />
			<input type = "hidden" id = "hdnViewEncounter" name = "hdnViewEncounter" value = "<%=viewEncounter%>"/>
		 	<input type = "hidden" id = "hdnOrderCategory" name = "hdnOrderCategory" value = "<%=orderCategory%>"/>
			<input type = "hidden" id = "hdnOrderPeriod" name = "hdnOrderPeriod" value = "<%=orderPeriod%>"/>



	   </form>
	   </section>
	   </body>

