<!DOCTYPE html>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>
<%@page import="eIPAD.chartsummary.encounterlist.request.EncounterListRequest"%>
<%@page import="eIPAD.chartsummary.encounterlist.bc.EncounterListBC"%>
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import ="com.ehis.persist.PersistenceHelper" %> 
<%@page import="ePH.IVPrescriptionBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<% 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String patient_id = patientContext.getPatientId();
String encounter_id	= patientContext.getEncounterId();
String patient_class = patientContext.getPatientClass();
String or_bean_name				= "eOR.OrderEntryBean";
String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
String tick_sheet_id = request.getParameter("tick_sheet_id");
ArrayList SectionDisplay = orbean.getSectionPopulate("PH",tick_sheet_id,"");
String[] record	 = null;
if(SectionDisplay !=null && SectionDisplay.size()>0){
%>
<div id="subsectionScroller" class="ticksheeDrugHeaderRowStyle" style="width:100%;height:8vhpx;overflow:hidden;position:relative;">
	<div  style="width:auto;height:100%;position:absolute;overflow:hidden;">
		<ul style="white-space: nowrap;margin:0;padding-left:0px;padding-top:10px;">
		<% for(int j=0; j<SectionDisplay.size(); j++)
		{
			record = (String[])SectionDisplay.get(j);%>
			<li id="tickSheet<%=j%>" class="ticksheetHeaderStyle" data-code=<%=record[0]%> onclick="ticksheetDrugTabSelection('<%= record[0]%>','tickSheet<%=j%>');">
			<%=record[1]%></li>	<% record = null;
		}%>
		</ul>
	</div>
</div>
<%}else{%>
	 <input type="hidden" name="NoRecordsSections" id="NoRecordsSections" id="NoRecordsSections" value="NO" />	
<%}%>
<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" />
<script>
$(document).ready(function() 
{
	setTimeout(function() {
       assignsubsectionScroll();
    }, 200);
	if($('#tickSheet0').data("code")!=undefined)
	{	
	ticksheetDrugTabSelection($('#tickSheet0').data("code"));
	$("#tickSheet0").addClass("ticksheetIsActive");		
	}	
	
});

var subsectScroll;
function assignsubsectionScroll() {
	 subsectScroll = new IScroll('#subsectionScroller', { 
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
	 
	subsectScroll.on('scrollStart', function() {
		    var ifCartOpened = $("#cartOpened").val();
		        if(ifCartOpened == "Y"){
			        $("#cartOpened").val("N");
	                $("#cartView").hide();
	                $("#cartWrapper").show();
	                $("#cart").show();
		        }
	    
    });
	subsectScroll.on('scrollEnd', function() {}); 
	
	if (subsectScroll != null) {
        subsectScroll.refresh();
    }
}
</script>

