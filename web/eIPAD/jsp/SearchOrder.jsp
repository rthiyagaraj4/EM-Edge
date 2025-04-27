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
oCategoryReq.setCalledFrom("ALL");
OrderCategoryResponse oCategoryRes = null;
List<OrderCategoryHO> lstOrderCategory = new ArrayList<OrderCategoryHO>();
SearchOrderRequest oSrchOrderReq = new SearchOrderRequest();

/*
 Creating the request object to get the order contents based on the criteria selected.
*/
String postBack = "";
String criteria = "";
String orderCategory = "";
String orderType = "";
String orderText = "";
String catalogNature = "";
String encounterId = "";
boolean bPopOrderType = false;
if(request.getParameter("hdnPostBack") != null)
{
	postBack = request.getParameter("hdnPostBack");

}
if(session.getValue("EpisodeId") != null )
{
	
	encounterId = (String)session.getValue("EpisodeId");
}
if(request.getParameter("hdnPopOrderType") != null && request.getParameter("hdnPopOrderType").equals("true"))
{
	bPopOrderType = true;
	
	if(request.getParameter("cmbOrderCategory") != null)
	{
		orderCategory = request.getParameter("cmbOrderCategory");
	}
	if(request.getParameter("cmbOrderType") != null)
	{
		orderType = request.getParameter("cmbOrderType");
	}
	
	
}

if(postBack != null && postBack.equals("true") && !bPopOrderType)
{
	catalogNature = "P";
	oSrchOrderReq.setRequest(request);
	if(request.getParameter("hdnPatientClass") != null && !request.getParameter("hdnPatientClass").equals(""))
	{
		patientClass = request.getParameter("hdnPatientClass");
	}
	if(request.getParameter("txtCriteria") != null)
	{
		orderText = request.getParameter("txtCriteria");
	}
	if(request.getParameter("cmbOrderCategory") != null)
	{
		orderCategory = request.getParameter("cmbOrderCategory");
	}
	if(request.getParameter("cmbOrdCriteria") != null)
	{
		criteria = request.getParameter("cmbOrdCriteria");
	}
	if(request.getParameter("hdnCatalogNature") != null)
	{
		catalogNature = request.getParameter("hdnCatalogNature");
	}
	if(request.getParameter("cmbOrderType") != null)
	{
		orderType = request.getParameter("cmbOrderType");
	}
	if(session.getValue("PatientID") != null)
	{
		oSrchOrderReq.setPatientId((String)session.getValue("PatientID"));
	}
	if(session.getValue("EpisodeId") != null )
	{
		oSrchOrderReq.setEncounterId((String)session.getValue("EpisodeId"));
	}
	if(session.getValue("facility_id") != null )
	{
		oSrchOrderReq.setFacilityId((String)session.getValue("facility_id"));
	}
	oSrchOrderReq.setPatientClass(patientClass);
	if(session.getValue("ca_practitioner_id") != null)
	{
		oSrchOrderReq.setClinicianId((String)session.getValue("ca_practitioner_id"));
	}
	if(session.getValue("practitioner_type") != null )
	{
		oSrchOrderReq.setPractionerType((String)session.getValue("practitioner_type"));
	}
	if(session.getValue("responsibility_id") != null )
	{
		oSrchOrderReq.setResponisibilityId((String)session.getValue("responsibility_id"));
	}
	oSrchOrderReq.setLanguageId(locale);
	if(session.getValue("Gender") != null )
	{
		oSrchOrderReq.setGender((String)session.getValue("Gender"));
	}
	if(session.getValue("DOB") != null )
	{
		oSrchOrderReq.setDOB((String)session.getValue("DOB"));
	}
	oSrchOrderReq.setAdmitDate((String)session.getValue("AdmitDate")); 
	oSrchOrderReq.setServicecode((String)session.getValue("ServiceCode")); 
	oSrchOrderReq.setDischargeDateTime((String)session.getValue("DischargeDateTime")); 
	oSrchOrderReq.setLocationCode((String)session.getValue("LocnCode")); 
	String locnType = (String)session.getValue("LocnType");
	if(locnType != null && locnType.equalsIgnoreCase("W"))
	{
		locnType = "N";
	}
	oSrchOrderReq.setLocationType(locnType);
	oSrchOrderReq.setOrderType(orderType);
	oSrchOrderReq.setOrderCategory(orderCategory);
	oSrchOrderReq.setOrderText(orderText);
	oSrchOrderReq.setCriteria(criteria);
	oSrchOrderReq.setOrderCatalogNature(catalogNature);
	oSrchOrderReq.setRestrictBy("N");
	
}
SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();

%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script type="text/javascript" src="../jquery-1.5.2.min.js"></script>  
<script type="text/javascript" src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<link rel="stylesheet" href="../css/iPadOrder.css" />
</head>
<script>
function changeOrientation(orient)
{
	if(orient == "landscape")
	  {
	//	
	  }
  else
	  {

	  }
}
function getOrderContents()
{
	document.getElementById("hdnCriteriaCombo").value = document.getElementById("cmbOrdCriteria").value;
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("hdnCatalogNature").value = "P";
	document.getElementById("frmSearchOrder").submit();
}
function deselectCheckBox(orderCatalogCode,orderId)
{
	if($("[data-orderCatalogCode = '" + orderCatalogCode + "']") != null)
	{
		$("[data-orderCatalogCode = '" + orderCatalogCode + "']").attr('checked',false);
	}
		// $("[data-orderCatalogCode = '" + orderCatalogCode + "']").removeAttr('checked');
}
function Loading()
{
	document.getElementById("cmbOrderCategory").value = document.getElementById("hdnOrderCategory").value;
	document.getElementById("cmbOrdCriteria").value = document.getElementById("hdnCriteriaCombo").value;
	document.getElementById("cmbOrderType").value = document.getElementById("hdnOrderType").value;
	var catalogCode = window.parent.returnCatalogCode();
	//alert("searchOrder");
	//alert(catalogCode);
	if(catalogCode != null)
	{
		var arCount = catalogCode.length;
		//alert(arCount);
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
	
	catalogNature = document.getElementById("hdnCatalogNature").value;
	postBack = document.getElementById("hdnPostBack").value;
	if(catalogNature=="P")
		$("#panelButton").removeClass('buttonStyle').addClass('buttonHighlight');
	else if(catalogNature=="A")
		$("#induvidualButton").removeClass('buttonStyle').addClass('buttonHighlight');
	else if(catalogNature=="S")
		$("#orderSetButton").removeClass('buttonStyle').addClass('buttonHighlight');
	
}
function filterOrderContents(catalogNature)
{
	document.getElementById("hdnCatalogNature").value = catalogNature;
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("frmSearchOrder").submit();
}
function populateOrderType()
{
	document.getElementById("hdnPopOrderType").value = "true";
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("frmSearchOrder").submit();
}
function addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId)
{
	var promptMsg = $(obj).attr('data-promptMsg');
	if(promptMsg != null && promptMsg != "" && obj.checked)
	{
		alert(promptMsg);
	}
	window.parent.addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId);
}
$(document).ready(function () {
	//window.parent.setAlignment();
});
</script>
<body onload = "Loading()">
	<section data-role = "page" style = "padding:0px;background-color : #ffffff">
		 <form id = "frmSearchOrder" method = "post" >
		 	<div data-role = "none" class ='divmain' id = 'dvmain'  style="padding:0px">
		 	    <div id="searchPageHeader"  class="resultPageHeader">
					<table style="height: 100%; width: 100%" cellpadding="0"
						cellspacing="0" border="0">
						<tr style="height: 100%; width: 100%">
							<td style="width: 90%"><span class="resultTextStyle">
							Search</span></td>
							 <td style="width: 10%">&nbsp;</td>
						</tr>
					</table>
				</div>
		 		<div id = "dvCriteria" class = "dvCriteria">
		 		    <table style="height:auto;width:100%" >
				 		 <tr style = "height:auto;width:100%">
				 		   <td style = "height:auto;width:90%">
				 		     <table style="height:65px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
		 			  <tr style="height:30px;width:100%">
		 			    <td align = "left" style="width:33%" valign = "center"><span class = "spanPeriod">Order Category</span></td>
				        <td align = "left" style="width:33%" valign = "center"><span class = "spanPeriod">OrderType</span></td>  
				        <td align = "left" style="width:33%" valign = "center" ><span class = "spanPeriod">Search Criteria</span></td> 
				        
		 			  <tr>
		 			 
		 			  
		 			  <tr style="height:35px;width:100%">
		 			     <td align = "left" style="width:33%">
					        <select  class="cmbPeriod" data-role="none" id="cmbOrderCategory" name = "cmbOrderCategory" onchange = "populateOrderType()"> 
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
			            <td align = "left" style="width:33%">
					        <select  class="cmbPeriod" data-role="none" id="cmbOrderType" name = "cmbOrderType"> 
					        <option value = "">Select</option>
					         <%
					           if(postBack != null && postBack.equals("true") && orderCategory != null && !orderCategory.equals(""))
					           {
					        	   int nOrderTypeCount = 0;
					        	   OrderTypeResponse oRes = null;
					        	   int nLoopCount = 0;
					        	   List<OrderTypeHO> lstOrderType = null ;
					        	   OrderTypeHO oTypeHO = null;
					        	   try
					        	   {
					        		   oRes = oSelectOrderDetails.getOrderType(orderCategory, locale, request);
					        		   if(oRes != null)
					        		   {
					        			   lstOrderType = oRes.getLstOrderType();
					        			   if(lstOrderType != null)
					        			   {
					        				   nOrderTypeCount = lstOrderType.size();
					        				   if(nOrderTypeCount > 0)
					        				   {
					        					   for(nLoopCount = 0 ; nLoopCount < nOrderTypeCount; nLoopCount ++)
					        					   {
					        						   oTypeHO = lstOrderType.get(nLoopCount);
					        						   if(oTypeHO != null)
					        						   {
					        							   %>
					        							   <option value = "<%=oTypeHO.getCode()%>"><%=oTypeHO.getDescription()%></option>
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
					        		   out.print(e.toString());
					        	   }
					           }
					         %>
							</select> 
			            </td>
			            <td align = "left" style="width:33%">
			              <table style = "width:100%;height:100%;margin-left : 7%" cellpadding = "0" cellspacing = "0">
			                 <tr style = "width:100%;height:100%">
			                   <td style = "width:50%;height:100%" align = "left">
			                    <input type = "text" data-role = "none"  class = "tbPatCriteria" id = "txtCriteria" name = "txtCriteria" value = "<%=orderText%>"/>
			                   </td>
			                   
			                   <td style = "width:50%;height:100%">
			                       <select  class="cmbOrdCriteria" data-role="none" id="cmbOrdCriteria" name = "cmbOrdCriteria"> 
							         <option value = "S">Starts</option> 
				                     <option value = "C">Contains</option>  
							         <option value = "E">Ends</option> 
							      </select>
			                   </td>
			                 </tr>
			              </table>
			                
					        
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
							<td style="width: 50%"><span class="resultTextStyle">
							Results</span></td>
							<td style="width: 16%" align="right" valign="center"><input
								type="button" value="Panel" data-role = "none" class="buttonStyle" id="panelButton" onclick = "filterOrderContents('P')"/></td>
							<td style="width: 16%" align="right" valign="center"><input
								type="button" value="Individual" data-role = "none" class="buttonStyle" id="induvidualButton" onclick = "filterOrderContents('A')"/></td>
							<td style="width: 16%" align="right" valign="center"><input
								type="button" value="Order Set" data-role = "none" class="buttonStyle" id="orderSetButton" onclick = "filterOrderContents('S')"/></td>
							 <td style="width: 2%">&nbsp;</td>
			
						</tr>
					</table>
				</div>
				<div id = "serachResults" data-role = "none" class = "dvSearchResults">
				  <%
				     if(postBack != null && postBack.equals("true") && !bPopOrderType)
				     {
				    	 SearchOrderResponse oSrchOrderRes = null;
				    	 String dischargeAdviceTime = "";
				    	 List<SearchOrderHO> lstSrchOrderHO =  new ArrayList<SearchOrderHO>();
				    	 SearchOrderHO oSrchOrderHO = new SearchOrderHO();
				    	 int nOrderContentCount = 0;
				    	 int nLoopCount = 0;
				    	 String promptYN = "";
				    	 String promptMsg = "";
				    	 try{
				    		 if(oSrchOrderReq != null)
				    		 {
				    			 dischargeAdviceTime = oSelectOrderDetails.getDischargeAdvDateTime(oSrchOrderReq.getPatientId(), oSrchOrderReq.getEncounterId(), request);
				    			 oSrchOrderReq.setDischargeAdviceDateTime(dischargeAdviceTime);
				    			 oSrchOrderRes = oSelectOrderDetails.getSearchOrderDetails(oSrchOrderReq);
				    			 if( oSrchOrderRes != null)
				    			 {
				    				 lstSrchOrderHO = oSrchOrderRes.getLstSrchOrderHO();
				    			 }
				    			 if(lstSrchOrderHO != null)
				    			 {
				    				 nOrderContentCount = lstSrchOrderHO.size();
				    				 if(nOrderContentCount > 0)
				    				 {
				    					 for(nLoopCount = 0 ; nLoopCount < nOrderContentCount; nLoopCount ++)
				    					 {
				    						 oSrchOrderHO = lstSrchOrderHO.get(nLoopCount);
				    						 if(oSrchOrderHO != null)
				    						 {
				    							 promptYN = oSrchOrderHO.getPromptAlertYN();
				    							 if(promptYN != null && promptYN.equalsIgnoreCase("Y"))
				    							 {
				    								 promptMsg = oSrchOrderHO.getPromptMsg();
				    							 }
				    							 else
				    							 {
				    								 promptMsg = "";
				    							 }
				    							 %>
				    							 <table class = "tbSearchResults" cellpadding = "0" cellspacing = "0">
													  <tr style = "width:100%;height:100%">
													    <td align = "center" valign = "center" style = "height : 100%;width:10%">
													      <input type = "checkbox" data-role = "none" class = "chkBox" id = "chkBox<%=nLoopCount%>" data-promptMsg = "<%= promptMsg %>" data-catalogNature = "<%=oSrchOrderHO.getGroupName()%>" data-currentCatlogNatue = "<%=catalogNature %>" data-orderId = "" data-orderCatalogCode = "<%= oSrchOrderHO.getOrderCatalogCode()%>" name = "chkBox<%=nLoopCount%>" onclick = "addToSaveArea('<%= oSrchOrderHO.getOrderCatalogCode()%>','<%=encounterId%>','<%= oSrchOrderHO.getCatalogSynonym()%>',this,'')"/>
													    </td>
													    <td align = "left" valign = "center" style = "height : 100%;width:90%;word-break:break-all" >
													    	<span class = "spanResultContent"><%= oSrchOrderHO.getCatalogSynonym()%></span>
													    </td>
													  <tr>
												</table>
				    							 <% 
				    						 }
				    					 }
				    				 }//if count > 0
				    				 else
					    			  {
					    				  %>
					    				     <%= IPADConstants.NORECORDS_HTML%>
					    				  <% 
					    			  }
				    			 }//end if lstcount
				    			 
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
		 	<input type = "hidden" id = "srchBotton" name = "srchButton" value = "<%=catalogNature%>"/>
		 	<input type = "hidden" id = "hdnPatientClass" name = "hdnPatientClass" value = "<%=patientClass %>" />
		 	<input type = "hidden" id = "hdnOrderCategory" name = "hdnOrderCategory" value = "<%=orderCategory%>"/>
		 	<input type = "hidden" id = "hdnOrderType" name = "hdnOrderType" value = "<%=orderType%>"/>
		 	<input type = "hidden" id = "hdnCriteriaText" name = "hdnCriteriaText" />
		 	<input type = "hidden" id = "hdnCriteriaCombo" name = "hdnCriteriaCombo" value = "<%=criteria%>"/>
		 	<input type = "hidden" id = "hdnCatalogNature" name = "hdnCatalogNature" value = "<%=catalogNature%>"/>
		 	<input type = "hidden" id = "hdnPopOrderType" name = "hdnPopOrderType" value = "false"/>
		 	<input type = "hidden" id = "hdnEncounterId" name = "hdnEncounterId" value = "<%=encounterId%>"/>
		 </form>
	  
	</section>
</body>
</html>

