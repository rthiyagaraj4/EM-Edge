<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.common.response.*" %>
<%@page import="eIPAD.chartsummary.common.healthobject.*" %>
<%@page import="eIPAD.chartsummary.common.healthobject.*" %>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

String eventTypeCode = "";
String eventTypeIndicator = "01";
String searchCriteria = "";
String title = "";
String searchBy = "desc";
String allergenType  = "";
String sfsType = "1";
if(request.getParameter("EC") != null)
{
	eventTypeCode = request.getParameter("EC");
}
if(request.getParameter("EI") != null)
{
	eventTypeIndicator = (String)request.getParameter("EI");
}
if(request.getParameter("SC") != null )
{
	searchCriteria = request.getParameter("SC");
}
if(request.getParameter("title") != null)
{
	title = request.getParameter("title");
}
if(request.getParameter("SB") != null)
{
	searchBy = request.getParameter("SB");
}
if(request.getParameter("AT") != null)
{
	allergenType = request.getParameter("AT");
}
if(request.getParameter("hdnSfsType") != null && !request.getParameter("hdnSfsType").equals(""))
{
	sfsType = request.getParameter("hdnSfsType");
}

%>
<!DOCTYPE html> 
<html> 
<head> 
<title>Allergy Search</title>   
<style>
</style>
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>

</style>
<script>
var sfsScroll;
var sfsDataArr = [];
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
function loadSfsScroller() {
	sfsScroll = new iScroll('SfsScrollWrapper');
}
document.addEventListener('DOMContentLoaded', loadSfsScroller, false);
function displayResults()
{  
	addSpinner();
	document.getElementById("SC").value = document.getElementById("AllergySfsText").value;
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("CSsfsForm").submit();
}
function trim1(myString)
{
 return myString.replace(/^\s+|\s+$/g, ''); 
}
function getSfsData(currentObj)
{
	  
	  var sfsObject = new Object();
      var code = "";
      var desc = "";
      code = $(currentObj).attr("data-code");
      desc = $(currentObj).attr("data-desc");
      var duplicateAllergenCode = "false";//validateAllergenCode(allergenCode);
      if($('#hdnSfsType').val() == "1")
      {
    	  //duplicateAllergenCode = validateAllergenCode(code); 
    	  var xmlhttp;
		var EI = $('#EI').val();
		var EC = $('#EC').val();
		var path = $('#hdnPath').val()  + "/eIPAD/jsp/chartwidgets/AllergenValidate.jsp";
		var sendString = "EC=" + EC+"&EI=" + EI + "&AC=" + code;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} 
		else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
			xmlhttp.open("POST", path, true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send(sendString);
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var respText = xmlhttp.responseText;
					respText =  trim1(respText);
					if(respText != "true")
					{
					      sfsObject.code = code;
					      sfsObject.desc = desc;
					      sfsObject.sfsType = $('#hdnSfsType').val();
					      sfsDataArr.push(sfsObject); 
					      window.parent.getSfsDetails(sfsDataArr);
					    //  window.parent.getSfsDetails();
					}
					else
					{
						$("#DuplicateSelection_Error").show();
						setTimeout(function(){
							$("#DuplicateSelection_Error").hide();
						},5000);
						$("#DuplicateSelection_Error").bind('click',function(){
							$(this).hide();
						});
					}
					
				
				}
			}
      }
     
      else
      {
	      sfsObject.code = code;
	      sfsObject.desc = desc;
	      sfsObject.sfsType = $('#hdnSfsType').val();
	      sfsDataArr.push(sfsObject); 
	      window.parent.getSfsDetails(sfsDataArr);
	     // window.parent.getSfsDetails();
      }
}
function validateAllergenCode(allergenCode)
{
	var xmlhttp;
	var EI = $('#EI').val();
	var EC = $('#EC').val();
	var path = $('#hdnPath').val()  + "/eIPAD/jsp/chartwidgets/AllergenValidate.jsp";
	var sendString = "EC=" + EC+"&EI=" + EI + "&AC=" + allergenCode;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} 
	else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
		xmlhttp.open("POST", path, true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(sendString);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var respText = xmlhttp.responseText;
				return respText;
			
			}
		}
}
function getSfsDataArray()
{
	return sfsDataArr;
}
function clearData()
{
	$('#SB').val("desc");
	$('#RoundI').css("left" , "70%");
	$('#AllergySfsText').val("");
}
function cancelSfs()
{
	window.parent.sfsCancel();
}
$(document).ready(function () {
	if($('#SB').val() == "CODE")
	{
		$('#RoundI').css("left" , "0%");
	}
	else
	{
		$('#RoundI').css("left" , "70%");
	}
	//---------slider functionality starts---------------
	jQuery.fn.sliderControl = function() { 
	    var scrollStartPos = 0; 
	    var scrollLast = 0;
	    var dvleft = 100;
	    var n33 = 0;
	    var n66 = 0;
	    var n99 = 0;
	    var touchleft = 0;
	    var iDcount = "1";
	    var offset = null;    
	    $(this).bind('touchstart', function(event) { 
	        var e = event.originalEvent; 
	        var orig = event.originalEvent;
		    var pos = $(this).position();
		    offset = {
		      x: orig.changedTouches[0].pageX - pos.left,
		      y: orig.changedTouches[0].pageY - pos.top
		     
		    };
	        iDcount = $(this).attr("data-count");
	        if(iDcount == null || iDcount == "")
	        	{
	        	  iDcount = "1";
	        	}
	       n33 =  $('#nDvParent' + iDcount).width() * 0.50;
	       
	       n99 =  $('#nDvParent' + iDcount).width() * 0.70;
	    }); 
	    $(this).bind('touchmove', function(event) { 
	    	event.preventDefault();
	    	event.stopPropagation();
	    	var e = event.originalEvent; 
	    	touchleft = e.touches[0].pageX - offset.x;
	    	if(touchleft < n99 && touchleft > 0)
	    	{
		    	 $(this).css("left" , touchleft);
		    	
	    	}
	    
	    }); 
	    $(this).bind('touchend', function(event) { 
	        if(touchleft < 0)
	        {
	        	 $(this).css("left" , "0%");
	        	 document.getElementById("SB").value = "CODE";
	  		 	
	        }
	    	if(touchleft > 0 && touchleft < n33)
	        {
	        	 
	         // alert(n33);
	        		  $(this).css("left" , "0%");
	        		  document.getElementById("SB").value = "CODE"; 
	        }
	    	
	    	if(touchleft > n33 )
	    	{
	    		
	   // alert(n33);
	   
	  // alert( $('#scaleDvI').width() * 0.50);
	    
	        	  
	        		  $(this).css("left" , "70%");
	        		 // alert("70");
	        		  document.getElementById("SB").value = "Desc";
	        		  
	        	  
	    	}
	    	if(touchleft > n99)
	    	{
	    		 $(this).css("left" , "70%");
	    		 document.getElementById("SB").value = "Desc";
	   		     
	    	}
	    	
	    });
	    return this; 
	};
	//---------slider functionality ends---------------
	$('#RoundI').sliderControl();
});
function toggleSearchFields(togImg){
	$("#SfsSearchFields").toggle();
	$(togImg).toggleClass("SfsTogHide");
	$(togImg).toggleClass("SfsTogExpand");
}
function addSpinner(){
	var a = $("#spinnerDiv")	
	if(a.length ==0)
	$("#SfsScrollWrapper").append("<div class='loadingCartItem' id='spinnerDiv'></div>");
}
function removeSpinner(){
	var a = $("#spinnerDiv")
	if(a.length > 0)
	$("#spinnerDiv").remove();
}
</script>
</head>
<body >
	<div class="SfsParent SfsParentTheme" data-role="none">
	<form id="CSsfsForm" class="SfsForm" action="${path}/chartsummary/AllergySfs" method="post" name="CSsfsForm" id="CSsfsForm">
		<div class="SfsParentTable" data-role="none">
			<div class="SfsParentHeaderRow" data-role="none">
				<div class="SfsParentHeaderCell" data-role="none">
					<div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
						<div class="SfsHeaderRow" data-role="none">
							<div class="SfsHeaderButtonCol" data-role="none">
								<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick = "cancelSfs()">
									<%=csResBundle.getString("common.cancel") %>
								</div>
							</div>
							<div class="SfsHeaderTextCol" data-role="none">
								<div class="SfsHeaderTextTheme" data-role="none">
									<%=title %>
								</div>
							</div>
							<div class="SfsHeaderButtonCol" data-role="none">
								<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" style = "display:none">
									<%=csResBundle.getString("common.select") %>
								</div>					
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="SfsParentBodyRow" data-role="none">
				<div class="SfsParentBodyCell" data-role="none">
					<div class="SfsBodyTable" data-role="none">
						<div class="SfsBodyRow" data-role="none">
							<div class="SfsBodySearchFieldsCol"  id="SfsSearchFields" data-role="none">
								<div class="SfsSearchFieldsContainer SfsSearchFieldsContainerTheme" data-role="none">
									<div style="display:table;width:100%;height:100%" data-role="none">
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none"><%=csResBundle.getString("common.searchBy") %></div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div  class="SfsSearchFieldsPaddedRow" data-role="none">
												<div style="display:table;width:100%" data-role="none">
													<div style="display:table-row" data-role="none">
														<div class="SfsSearchByCodeText SfsSearchFieldTextTheme" style="display:table-cell" data-role="none">
														<%=csResBundle.getString("common.code") %>
														</div>
														
														<div class="SfsSearchBySlider" style="display:table-cell;vertical-align:middle;text-align:left" data-role="none">
														  <div  style = "position:relative;width:70%;left:0px" data-role = "none">
																<div id = "nDvParentI" class = "parentSfs" data-role = "none">
																  		<div id = "scaleDvI" class = "scaleSfs sfsScaleTheme" data-role = "none" >
																  		    <div data-role = "none" class = "RoundSfs sfsCritRoundTheme" id = "RoundI" data-count = "I"></div>
																  		   
																  		    
																  			<div data-role = "none" class = "scaleSeparatorSfs1"  >
																  			</div>
																  			<div data-role = "none" class = "scaleSeparatorSfs2"   >
																  			</div>
																  			
																  		</div>
																  		
							  										</div>
						  									</div>
														</div>
														<div class="SfsSearchByDescText" style="display:table-cell;text-align:right;" data-role="none">
														<span class = "SfsSearchFieldTextTheme" style = "position:relative;margin-right:10px"><%=csResBundle.getString("common.description") %></span>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none"><%=csResBundle.getString("common.searchText") %></div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsTextBoxContainer" data-role="none"><input type="text" class="SfsTextBoxTheme SfsSearchText" id="AllergySfsText" name="AllergySfsText" id="AllergySfsText" value = "<%=searchCriteria%>"></div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										
										<div style="display:table-row" data-role="none">
											<div style="display:table-cell;vertical-align:bottom;" data-role="none">
												<div style="display:table;width:100%" data-role="none">
													<div style="display:table-row" data-role="none">
														<div class="SfsBodyButtonTheme SfsBodyButtonLeft" data-role="none" onclick = "clearData()">
															<%=csResBundle.getString("common.clear") %>
														</div>
														<div class="SfsBodyButtonTheme SfsBodyButtonRight" data-role="none" onclick = "displayResults()">
															<%=csResBundle.getString("common.search") %>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="SfsBodyFieldsDockCol" data-role="none">
								<div  class="SfsTogHide" onclick="toggleSearchFields(this)"></div>
							</div>
							<div class="SfsBodySearchResCol" style="display:table-cell" data-role="none">
								<div class="SfsSearchResContainer" data-role="none">
									<div class="SfsSearchResTable" data-role="none">
										<div class="SfsSearchResHeaderRow" data-role="none"> 
											<div class="SfsSearchResHeaderCodeCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme" data-role="none">
												<%=csResBundle.getString("common.code") %>
											</div>
											<div class="SfsSearchResHeaderDescCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme" data-role="none">
												<%=csResBundle.getString("common.description") %>
											</div>
										</div>
									</div>
									<div class="SfsScrollWrapper" id="SfsScrollWrapper" data-role="none">
										<div class="SfsScroller" data-role="none">
											<div class="SfsSearchResTable" data-role="none">
											
												
												<%
													if(request.getParameter("hdnPostBack") != null && request.getParameter("hdnPostBack").equals("true"))
													{
														SfsResponse oSfsRes = null;
														 List<SfsHo> lstSfsHO = null;
														if(request.getAttribute("SfsResponse") != null)
														{
															oSfsRes = (SfsResponse)request.getAttribute("SfsResponse");
															if(oSfsRes != null && oSfsRes.isSuccessResponse())
															{
																 lstSfsHO = oSfsRes.getLstSfsHO();
																 if(lstSfsHO != null)
																 {
																	 int nLstCount = lstSfsHO.size();
																	 int nLoopcount = 0;
																	 SfsHo oSfsHO = null;
																	 if(nLstCount > 0)
																	 {
																		 for(nLoopcount = 0;nLoopcount < nLstCount;nLoopcount++)
																		 {
																			 oSfsHO  = lstSfsHO.get(nLoopcount);
																			 if(oSfsHO != null)
																			 {
																			 %>
																			 <div class="SfsSearchResRow" data-role="none" onclick = "getSfsData(this)" data-code = "<%=oSfsHO.getCode() %>" data-desc = "<%=oSfsHO.getDescription() %>">
																				<div class="SfsSearchResCodeCol SfsSearchResBodyTheme SfsSearchResTextTheme" data-role="none">
																					<%=oSfsHO.getCode() %>
																				</div>
																				<div class="SfsSearchResDescCol SfsSearchResBodyTheme SfsSearchResTextTheme" data-role="none">
																					<%=oSfsHO.getDescription() %>
																				</div>
																			</div>
																			 <% 
																			 }
																		 }
																	 }
																	 else
																	 {
																		 if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																			{
																			  %>
																			  <div class="SfsSearchResRow" data-role="none" >
																						
																						<div class="SfsSearchResBodyTheme SfsSearchResTextTheme" style = "display:table-cell;width:100%"data-role="none">
																							<%=oSfsRes.getErrorsList().get(0).getErrorMessage() %>
																						</div>
																				</div>
																			  
																			  <% 
																			}
																	 }
																 }
															}
															else
															{
																if(oSfsRes != null)
																{
																	if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																	{
																	  %>
																	  <div class="SfsSearchResRow" data-role="none" >
																				
																				<div class="SfsSearchResBodyTheme SfsSearchResTextTheme" style = "display:table-cell;width:100%"data-role="none">
																					<%=oSfsRes.getErrorsList().get(0).getErrorMessage() %>
																				</div>
																		</div>
																	  
																	  <% 
																	}
																}
															}
														}
														
													}
												%>
												
											</div>
										</div>
										<!-- Error message for duplicate selection -->
										<div class="formValWarningTheme formValError" id="DuplicateSelection_Error" style="bottom: 0px; left: 0px;display:none">
									  	 	<div class="formValErrorMsgTheme" id="DuplicateSelection_ErrorMsg">Record already exists for the Allergen</div>
									  	 </div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<input type = "hidden" name = "EC" id = "EC" value = "<%=eventTypeCode%>"/>
		<input type = "hidden" name = "EI" id = "EI" value = "<%=eventTypeIndicator%>"/>
		<input type = "hidden" name = "hdnSfsType" id = "hdnSfsType" value = "<%=sfsType%>"/>
		<input type = "hidden" name = "SC" id = "SC" value = "<%=searchCriteria%>"/>
		<input type = "hidden" name = "SB" id = "SB" value = "<%=searchBy %>"/>
		<input type = "hidden" name = "AT" id = "AT" value = "<%=allergenType%>"/>
		<input type = "hidden" name = "hdnPath" id = "hdnPath" value = "${path}" />
		<input type = "hidden" name = "hdnPostBack" id = "hdnPostBack" value = "false" />
		<input type = "hidden" name = "title" id = "title" value = "<%=title %>" />
		
	</form>
	</div>

</body>
</html>

