<!DOCTYPE html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="path" value = "${pageContext.request.contextPath}"/>
	<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" /> 	
	<%
	 String id_data = request.getParameter("id_data");	 
	 %>
    <div class="legendToggler legendTogglerTheme pharLegendtoggler"  onclick="toggleLegend(this,'<%=id_data%>')"><img src = "${path}/eIPAD/images/LegendIcon.png" style="padding:10px 10px 10px 22px;float:right;"/></div>
 <div class="legendContainerPhar" id ="legendContainerPhar<%=id_data%>" style="">					
		<div id="legendWrapper<%=id_data%>" class="legendWrapper pharLegendWrapper" style="">
			<div id="legendScroller" class="legendScrollerCss">
				<div class="legendTabs" ><div class = "pharLegendCancelledTheme"></div><span>Cancelled</span></div>
				<div class="legendTabs" ><div class="pharLegendDiscontinuedTheme" ></div><span>Discontinued</span></div>
				<div class="legendTabs" ><img src="${path}/eIPAD/images/beyondDoseLimit25X25.png"/><span>	Beyond dosage limit </span></div>				
				<div class="legendTabs" ><img src="${path}/eIPAD/images/drugInteraction25X25.png" /><span>	Drug interaction </span></div>
				<div class="legendTabs" ><img src="${path}/eIPAD/images/duplicateDrug25X25.png" /><span>	Duplicate drug </span></div>
				<div class="legendTabs" ><img src="${path}/eIPAD/images/pharmAllergy25X25.png"/><span>Allergy indicator</span></div>				
				<div class="legendTabs" ><img src="${path}/eIPAD/images/authorizeRxDet25X25.png" /><span>	Authorise</span></div>
				<div class="legendTabs" ><img src="${path}/eIPAD/images/Cosign24x24.png"/><span> Co-sign </span></div>
				<div class="legendTabs" ><img src="${path}/eIPAD/images/Specialapproval.png"/><span> Special approval </span></div>
				<div class="legendTabs" ><img src="${path}/eIPAD/images/externalDatabase25X25.png"/><span> External database check </span></div>
			  </div>
		</div>
</div>
<script>
var path;
var pharLegendsScroll;
$(document).ready(function() {	
	path = $("#hdnPath").val();
	assignrefersh();	
});
function toggleLegend(elemm,currentId){	
assignrefersh();
	$('#legendContainerPhar'+currentId).toggle(); 
	 var totalWidth = 0;
	 $('.legendScrollerCss .legendTabs').each(function(index) {
     totalWidth += parseInt($(this).outerWidth());
   	});
	$('.legendScrollerCss').css("width",(totalWidth+90)+'px');	
	 pharLegendsScroll = new IScroll('#legendWrapper'+currentId, { 
		scrollX: true, 
		scrollY: false, 
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		hideScrollbar:true,
		scrollbars: true,
		bindToWrapper: true,
		fadeScrollbars :true		
	});	
	
 }  
 function assignrefersh(){
	 
	 if(pharLegendsScroll != null){
    	pharLegendsScroll.refresh();
		}
 } 
</script>

