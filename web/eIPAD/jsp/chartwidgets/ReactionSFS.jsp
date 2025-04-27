<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Map.Entry"%>
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
String sfsType = "3";
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
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />

<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>


</style>

<script>
var sfsScroll;
var sfsArray = null;
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
function loadSfsScroller() {
	/*
	sfsScroll = new iScroll('SfsScrollWrapper',
			);
	*/
	 setTimeout(function () {
		 sfsScroll = new iScroll('SfsScrollWrapper', {
				useTransform: true,
				zoom: false,
				onBeforeScrollStart: function (e) {
				var target = e.target;
				while (target.nodeType != 1) target = target.parentNode;

				if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' )
				e.preventDefault();
				}
				});
		}, 100); 
}
document.addEventListener('DOMContentLoaded', loadSfsScroller, false);
$(document).ready(function () {
	
	if($('#SB').val() == "CODE")
	{
		$('#RoundI').css("left" , "0%");
	}
	else
	{
		$('#RoundI').css("left" , "70%");
	}
	//---------Slider functionality starts---------------
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
function displayResults()
{
	var SC = document.getElementById("AllergySfsText").value;
	if(SC != null && SC != "")
	{
		SC = SC.replace("'", "\'");
	}
	document.getElementById("SC").value = SC;
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("CSsfsForm").submit();
}
function clearData()
{
	$('#SB').val("desc");
	$('#RoundI').css("left" , "70%");
	$('#AllergySfsText').val("");
}
function getSelectedDetails()
{
	//unchecking other check box if no text was entered in it
	if(($("#chkOther").is(':checked')) && ($('#SfsOthersText').val().trim() == "")){
		$("#chkOther").attr("checked" , false);
		$("#chkOther").attr("data-isOtherChecked" , "F");
	}
	var sfsDataArr = [];
	$("[data-isChecked = 'T']").each(function(index, value) {
		//alert($(this).checked);
		//var bCheck = $(this).attr("checked");
		//alert(bCheck)
		
			var code = $(this).attr("data-code");
			var desc = $("[data-rel = '"+code +"']").html();
			
			var sfsObject = new Object();
			sfsObject.code = code;
		    sfsObject.desc = desc; 
		    sfsObject.sfsType = $('#hdnSfsType').val();//document.getElementById("hdnSfsType").value;
		    sfsDataArr.push(sfsObject);
		  	//alert(code);
		    //alert(desc);
		
	});

	if(document.getElementById("chkOther").checked)
	{
		var sfsObject = new Object();
		sfsObject.code = "Oth";
		sfsObject.desc = $('#SfsOthersText').val();
		
		sfsObject.sfsType = $('#hdnSfsType').val();//document.getElementById("hdnSfsType").value;
	    sfsDataArr.push(sfsObject);
	}
	window.parent.getReactionSfsDetails(sfsDataArr);
	//sfsArray = sfsDataArr;
}
function getSfsDataArray()
{
	return sfsArray;
}
function selectReaction(obj)
{
	//alert(obj.checked)
	if(obj.checked)
	{
		var arrReactioncode = window.parent.returnReactionCode();
		var bAddReaction =  true;
		if(arrReactioncode != null && arrReactioncode.length > 0)
		{
		   var i = 0;
		   var arrLength = arrReactioncode.length;
		   var code = $(obj).attr("data-code");
		   for(i =0 ; i < arrLength; i ++)
		   {
			   if(arrReactioncode[i] == code)
			   {
				   bAddReaction = false;
				   $(obj).attr("checked" , false);
					$("#DuplicateSelection_Error").show();
					setTimeout(function(){
						$("#DuplicateSelection_Error").hide();
					},5000);
					$("#DuplicateSelection_Error").bind('click',function(){
						$(this).hide();
					});
				   break;
			   }
		   }
		}
		if( bAddReaction )
		  $(obj).attr("data-isChecked" , "T");
	}
	else
	{
		$(obj).attr("data-isChecked" , "F");
	}
	if($("[data-isChecked = 'T']").length > 0){
		enableSfsSelectButton();
	}
	else if($("[data-isChecked = 'T']").length <= 0 && $("[data-isOtherChecked = 'T']").length <= 0) {
		disableSfsSelectButton()
	}
}
function cancelSfs()
{
	window.parent.sfsCancel();
}
function activateOtherReactions(chkObj){
	if($(chkObj).is(":checked") == true){
		$(chkObj).attr("data-isOtherChecked" , "T");
		$("#SfsOthersText").removeClass("SfsDullElement");
		$("#SfsOthersText").removeAttr("disabled");
		//if the others text box contains any value
		enableSfsSelectButton();
	}
	else{
		$("#SfsOthersText").addClass("SfsDullElement");
		$("#SfsOthersText").attr("disabled","disabled");
		$(chkObj).attr("data-isOtherChecked" , "F");
		if($("[data-isChecked = 'T']").length <= 0){
			disableSfsSelectButton();
		}
	}
}

function enableSfsSelectButton(){
	$("#SfsSelectReactsButton").removeClass("SfsHeaderButtonDisableTheme").addClass("SfsHeaderButtonTheme");
	$("#SfsSelectReactsButton").attr("onclick", "getSelectedDetails()");
}

function disableSfsSelectButton(){
	$("#SfsSelectReactsButton").removeClass("SfsHeaderButtonTheme").addClass("SfsHeaderButtonDisableTheme");
	$("#SfsSelectReactsButton").attr("onclick", "");
}
function toggleSearchFields(togImg){
	$("#SfsSearchFields").toggle();
	$(togImg).toggleClass("SfsTogHide");
	$(togImg).toggleClass("SfsTogExpand");
}

</script>

</head>
<body >
	<div class="SfsParent SfsParentTheme" data-role="none">
	<form id="CSsfsForm" class="SfsForm" action="" method="post" name="CSsfsForm" id="CSsfsForm">
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
								<div class="SfsHeaderButton SfsHeaderButtonDisableTheme" id="SfsSelectReactsButton" data-role="none" >
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
							<div class="SfsBodySearchFieldsCol" id="SfsSearchFields" data-role="none">
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
																  		<div class="sliderSfsInsTheme sliderSfsIns">
																  		    <div data-role = "none" class = "RoundSfs sfsCritRoundTheme" id = "RoundI" data-count = "I"></div>
																  		   
																  		    
																  			<div data-role = "none" class = "scaleSeparatorSfs1"  >
																  			</div>
																  			<div data-role = "none" class = "scaleSeparatorSfs2"   >
																  			</div>
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
									<div class="SfsSearchResOthersContainer SfsSearchResOthersContainerTheme" data-role="none">
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
										<div class="SfsScrollWrapperWithOthers" id="SfsScrollWrapper" data-role="none">
											<div class="SfsScroller" data-role="none">
												<div class="SfsSearchResTable" data-role="none">
													
													<%
													if(request.getParameter("hdnPostBack") != null && request.getParameter("hdnPostBack").equals("true"))
													{
														SfsResponse oSfsRes = null;
														// List<SfsHo> lstSfsHO = null;
														 Iterator<Entry<String, String>> iter = null;
														if(request.getAttribute("SfsResponse") != null)
														{
															oSfsRes = (SfsResponse)request.getAttribute("SfsResponse");
															if(oSfsRes != null && oSfsRes.isSuccessResponse() && !oSfsRes.isEmptyDataResponse())
															{
																 //lstSfsHO = oSfsRes.getLstSfsHO();
																 if(oSfsRes.getoSfsMap() != null)
																 {
																	 iter = oSfsRes.getoSfsMap().entrySet().iterator();
																 }
																 if(iter != null)
																 {
																
																	 while (iter.hasNext()) {
																		 Map.Entry<String, String> mEntry = (Map.Entry<String, String>) iter.next();
																		 String code = (String)mEntry.getKey();
																		 String value = (String)mEntry.getValue();
																			 %>
																			<div class="SfsSearchResRow" data-role="none">
																				<div class="SfsSearchResCodeCol SfsSearchResBodyTheme SfsSearchResTextTheme" data-role="none" >
																					<div style="display:table">
																						<div style="display:table-row">
																							<div style="display:table-cell">
																								<div class="SfsChkBoxTheme1">
																									<input type="checkbox" id="<%=code%>" data-code = "<%=code%>" data-check = "T" data-isChecked = "F" onclick = "selectReaction(this)">
																									<label for="<%=code%>"></label>
																								</div>
																							</div>
																							<div style="display:table-cell;vertical-align:middle">
																								<div class="SfsReacChkBoxLabel"><%=code%></div>
																							</div>
																						</div>
																					</div>
																				</div>
																				<div class="SfsSearchResDescCol SfsSearchResBodyTheme SfsSearchResTextTheme" data-role="none" data-rel = "<%=code%>" ><%=value %></div>
																			</div>
																			 <% 
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
												
												</div><!-- table end -->
											</div>
											<!-- Error message for duplicate selection -->
											<div class="formValWarningTheme formValError" id="DuplicateSelection_Error" style="bottom: 0px; left: 0px;display:none">
										  	 	<div class="formValErrorMsgTheme" id="DuplicateSelection_ErrorMsg">Record already exists for the Reaction</div>
										  	 </div>
										</div>
										<div class="SfsSearchResTable" data-role="none">
											<div class="SfsSearchResRow" data-role="none">
												<div class="SfsSearchResOthersfillCol">
												</div>
												<div class="SfsSearchResOthersChkCol" data-role="none">
													<div class="SfsChkBoxTheme2">
														<input type="checkbox" id = "chkOther" onchange="activateOtherReactions(this)" data-isOtherChecked = "F"/>
														<label for="chkOther"></label>
													</div>
												</div>
												<div class="SfsSearchResOthersLabelCol SfsSearchFieldTextTheme" data-role="none">
													<%=csResBundle.getString("common.other") %>
												</div>
												<div class="SfsSearchResOthersTxtBoxCol" data-role="none">
													<input id="SfsOthersText" class="SfsTextBoxTheme SfsOthersTextBox SfsDullElement" data-role = "none" type="text" name="SfsOthersText" id="SfsOthersText" disabled="disabled" />
												</div>
											</div>
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

