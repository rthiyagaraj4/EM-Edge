<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse"%>
<%@page import="eIPAD.chartsummary.orderentry.bc.MOrderEntryBC"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>
<!DOCTYPE html>
<html> 
<head> 
<title></title>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<%-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0a4.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0a4.1.min.css" />   --%>

<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<%-- <script src="${path}/eIPAD/kendo.web.min.js"></script> --%>
<script src="${path}/eIPAD/js/lib/kendo/kendo2013q3/kendo.web.min.js"></script>
<script src="${path}/eIPAD/js/lib/kendo/kendo2013q3/kendo.mobile.min.js"></script>
<script src="${path}/eIPAD/js/lib/kendo/kendo2013q3/kendo.mobile.scroller.min.js"></script>
<script src="${path}/eIPAD/console.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/PlaceOrders.css" />
<script src="${path}/eIPAD/js/PlaceOrders.js"></script>

<script type="text/javascript">








</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
String or_bean_name = "eOR.OrderEntryBean";
OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);

MOrderEntryBC bc = new MOrderEntryBC();
MOrderEntryFieldResponse tickSheetListResponse = bc.getTickSheetList(bean, null, true);
ArrayList<MOrderEntryFieldItem> tickSheetList = tickSheetListResponse.getFieldItems();
%> 

<style>


</style>
</head>
<body style="display: block; margin: 0px; height: 100%; width: 100%;">
<form id="ChartSummaryForm" name = "ChartSummaryForm" method = "post" action = "" class="ChartSummaryFormElem">
<div data-role = "none" id = "dvMez" class = "blurPopup" onclick="" data-popid=""></div>
<div id="OrdSearchSFS" class="orderSearchSfs" style="display:none" >
	<div id="sfsarrow" data-role="none" class="sfs-bubble-arrow sfs-bubble-arrowIPTheme"></div>
	<div data-role="none" class="ordSfsSmall sfsIPTheme"  style="display:block">
		<iframe id="sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" height="300px" width="340px" src="${path}/eIPAD/jsp/chartwidgets/orders/MoeAddlSearchCrit.jsp"></iframe>  
	</div> 
</div>

<div class="ordSelParent"> 
	<!--  Header START-->
	<div class="ordSelHeaderMenu">
		<div class="ordSelHeaderMenuCont">
			<div class="row">
				<div class="ordSelMenuCont">
					<div class="ordSelMenuIconbg">
						<div class="ordSelMenuIcon"> </div>
					</div>
				</div>
				<div class="ordSelMenuCont ordSelMenuTitle"> Order </div>
				<div class="ordSelMenuright ordSelHeaderBtnTheme" id="OrderSelectMaximizeBtn" onclick="maximizeOrderSel_selpage()">
			  		<div class="ordSelHdrBtnIcon"><img src="${path}/eIPAD/images/max.PNG" width="12" height="13" id="OrderSelectMaximizeImg" /></div>
			  	</div>
				<div class="ordSelMenuright ordSelHeaderBtnTheme" onClick="toggleAddlSearch()">
			  		<div class="ordSelHdrBtnIcon"><img src="${path}/eIPAD/images/Search.png" width="16" height="16" /></div>
			  	</div>
				<div class="ordSelMenuright">
				  	<div class="ordTickDropdownContTheme" data-role="none">
				    <%if(tickSheetListResponse.getResponseStatus()!=tickSheetListResponse.FIELD_DATAFETCH_FAILURE && tickSheetList!=null && !tickSheetList.isEmpty()){ %>
						<select name="cmbTickSheetSelect" id="cmbTickSheetSelect" id="cmbTickSheetSelect" data-role="none">
							<option>Select TickSheet</option>
				  	<%
						MOrderEntryFieldItem tickSheetItem;
						for(int i=0;i<tickSheetList.size();i++) {
						 	tickSheetItem = tickSheetList.get(i);
					%>
							<option value="<%=tickSheetItem.getCode() %>"><%=tickSheetItem.getDesc() %></option>
					<%  } %>
						</select>
						<script>
						$(document).ready(function() {
							initTicksheetCombo();
						});
						</script>
					<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--  Header END--> 
  
  	<!-- Ticksheet Combo START-->
  
	<div class="tickSectComboCont" id="TickSectCombocontainer">
    	<div  class="tickSectCombo" style="height:40px;position: relative;">
    		<input id="cmbTicksheetSection" name="cmbTicksheetSection" id="cmbTicksheetSection" data-type="ComboBox" data-role="none" />
		    <script>
				/* $(document).ready(function() {
					initTicksheetSectCombo();
				}); */
			</script>
		</div>
  	</div>
  
  <!-- Ticksheet Combo END-->
        <style>

      
      
      </style>
  <!-- Order Results START -->
	<div class="ordSelItemsCont">
    	<div class="ordItemsCont">
    	<!-- Panel Order Results START -->
			<div class="table ordItemsBox3" id="Panel_Orders" style="display:none">
				<div class="ordItemBoxIn">
			  		<div class="ordItemBoxTable">
			    		<div class="row ordItemBoxRowHd">
			      			<div class="ordItemBoxCellHd">
			        			<div class="table" style="width:100%;">
              						<div  class="row">
              							<div class="cell">
						        			<div class="ordItemBoxHdr">
						          				<div class="ordItemBoxHdrTxt">Panel<span id="Panel_Count"></span></div>
						        			</div>
				        				</div>
				        			</div>
			        			</div>
			      			</div>
			    		</div>
			    		<div class="row ordItemBoxRowCon">
			      			<div class="ordItemBoxRowConCell" style="position:relative;">
				      			<div class="table">
              						<div  class="row">
              							<div class="cell">
							      			<div> <iframe name="Panel_Frame" id="Panel_Frame"  src="" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0" 
				                         			style=width:100%;height:100%;position:absolute;"></iframe>
							      			</div>
						      			</div>
					      			</div>
				      			</div>
			      			</div>
			    		</div>
			  		</div>
				</div>
	     	</div>
      <!-- Panel Order Results END -->

      <!-- OrderSet Order Results START -->
      		<div class="table ordItemsBox3" id="OrderSet_Orders" style="display:none">
        		<div class="ordItemBoxIn">
					<div class="ordItemBoxTable">
            			<div class="row ordItemBoxRowHd">
              				<div class="ordItemBoxCellHd">
                				<div class="table" style="width:100%;">
              						<div  class="row">
              							<div class="cell">
			                				<div class="ordItemBoxHdr">
			                  					<div class="ordItemBoxHdrTxt">Order Set<span id="OrderSet_Count"></span></div>
			                				</div>
		                				</div>
		                			</div>
                				</div>
              				</div>
            			</div>
            			<div class="row ordItemBoxRowCon">
              				<div class="ordItemBoxRowConCell" style="position:relative;">
              					<div class="table">
              						<div  class="row">
              							<div class="cell">
			              					<div><iframe name="OrderSet_Frame" id="OrderSet_Frame"  src="" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0" 
				                         			style=width:100%;height:100%;position:absolute;"></iframe> 
							      			</div>
						      			</div>
						      		</div>
				      			</div>
							</div>
            			</div>
          			</div>
        		</div>
      		</div>
      <!-- OrderSet Order Results END -->
    
    	<!-- Individual Order Results START -->
      		<div class="table ordItemsBox3" id="Individual_Orders" style="display:none">
        		<div class="ordItemBoxIn">
          			<div class="ordItemBoxTable">
						<div class="row ordItemBoxRowHd">
              				<div class="ordItemBoxCellHd">
              					<div class="table" style="width:100%;">
              						<div  class="row">
              							<div class="cell">
             								<div class="ordItemBoxHdr">
                 								<div class="ordItemBoxHdrTxt">Individual<span id="Individual_Count"></span></div>
               								</div>
              							</div>
              						</div>
              					</div>
              				</div>
            			</div>
            			<div class="row ordItemBoxRowCon">
              				<div class="ordItemBoxRowConCell" style="position:relative;">
              					<div class="table">
              						<div  class="row">
              							<div class="cell">
		              						<div>
						      				 <iframe name="Individual_Frame" id="Individual_Frame"  src="" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0" 
			                         			style=width:100%;height:100%;position:absolute;"></iframe>
						      				</div>
				      					</div>
				      				</div>
				      			</div>
              				</div>
			            </div>
					</div>
			   	</div>
			</div>
      <!-- Individual Order Results END -->
      
      <!-- No Results START -->
      <div id="No_Orders" style="display:none">No Orders were found</div>
      
      <!-- No Results END -->
		</div>
	</div>
  <!-- Order Results END -->
</div>
<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
</form>
</body>
</html>

