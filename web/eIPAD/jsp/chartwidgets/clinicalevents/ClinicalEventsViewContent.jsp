<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>

<div class="eventsMainPanel">
   <div data-role="none" class="ChartSummaryMainWrapper" id="ChartSummaryMainWrapper" >
      <!-- scrolling content starts -->
	  <div class="ChartSummaryMainScroller" data-role = "none">        
        <div class="clinicalNotesView">
            <div id="clincalNotesTab" class="notesContent">	
                <div class="notesViewWrapper">
                   <div id="noEventsMsg" class="noEventsMsgDisplay">			
                      <p> No clinical events available </p> 
                   </div>         
                   <div class="notes">
                   </div>
                </div>
            </div>       
        </div>
      </div>
      <!-- scrolling content ends -->
  </div>
</div>
<div class="FilterOpenMsg">
   <p>Close Search / Filter panel to view clinical events</p>
</div>
<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
<script src="${path}/eIPAD/js/ClinicalEventsViewContent.js"></script>
<style> 
.noEventsMsgDisplay{
	height:300px;
	line-height:300px;
	display:none;
}
.noEventsMsgDisplay p{
	vertical-align: middle; 
    text-align: center;
    color: #c3c3c3;	
}
</style>

