<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.results.request.ResultsCatConstants"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Locale"%>
<%@ page import="eIPAD.chartsummary.results.request.ResultsCatConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>
<script>
var path;
$(document).ready(function(){
	
	path = $('#hdnPath').val();
	
	$("#resultDataFrame").load( path + "/mobile/chartsummary/ResultsDataView?Category=<%=ResultsCatConstants.RESULTCATEGORY_LABORATORY %>",function(){
		scrollerRefresh(CSMainScroll);
	});
});
function openChartsView(){
	
	$("#PageLoadingAnimation").show();
	window.location.replace( path + '/mobile/chartsummary/ResultsChartView');
}

function showResultsOf(cat, widObj){
	$("#resultDataFrame").empty();
	$("#resultDataFrame").load( path + "/mobile/chartsummary/ResultsDataView?Category="+cat,function(){
		scrollerRefresh(CSMainScroll);
	});
	$(".widgetResTab").each(function(i){
		$(this).removeClass("widgetTabActiveTheme").addClass("widgetTabNonActiveTheme").addClass("widgetTabNonActive");
		$(widObj).removeClass("widgetTabNonActiveTheme").removeClass("widgetTabNonActive").addClass("widgetTabActiveTheme");
	})
}


</script>
<style>

#PageLoadingAnimation{
	z-index: 10000;
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	background-color: #808080;
	opacity: 0.6;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	display: none; 
}



</style>
<%
int allCount = request.getAttribute("AllCount")==null?0:(Integer)request.getAttribute("AllCount");
int labCount = request.getAttribute("LabCount")==null?0:(Integer)request.getAttribute("LabCount");
int radCount = request.getAttribute("RadCount")==null?0:(Integer)request.getAttribute("RadCount");
int surgCount = request.getAttribute("SurgCount")==null?0:(Integer)request.getAttribute("SurgCount");
int diagCount = request.getAttribute("DiagCount")==null?0:(Integer)request.getAttribute("DiagCount");
int othersCount = request.getAttribute("OthersCount")==null?0:(Integer)request.getAttribute("OthersCount");
%>
<div id="PageLoadingAnimation" > </div>
	<div class="widgetParent widgetParentTheme" data-role = "none">
<!-- 	<form id="AllergyWidgetForm" class="AllergyWidgetForm" action="" method="post" name="AllergyWidgetForm" id="AllergyWidgetForm"> -->
		<div class="widgetTable" data-role = "none">
			<div class="widgetHeaderRow widgetHeaderRowTheme" data-role = "none">
				<div class="widgetHeaderMarginCell" data-role = "none">
					<div class="widgetHeaderMarginExtn widgetHeaderMarginExtnTheme" data-role = "none"></div>
					<div class="widgetHeaderIcontriangle" data-role = "none"></div>
				</div>
				<div class="widgetHeaderCell widgetHeaderCellTheme" data-role = "none">
					<div class="widgetHeaderSubTable" data-role = "none">
						<div class="widgetHeaderSubRow" data-role = "none">
							<div class="widgetHeaderIconCol1" data-role = "none">
								<div class="widgetHeaderIconButton widgetHeaderIconButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/CS_Allergies.PNG" class="widgetHeaderButtonImage"></div>
								
							</div>

							<div class="widgetHeaderHeadingTextCol" data-role = "none"><span class="widgetHeaderHeadingTextTheme" data-role = "none"><%=csResBundle.getString("results.results") %></span> <input type="button" class="widgetHeaderCountButtonTheme" id="resultsViewCount" value="<%=allCount%>"></div>
							<div class="widgetHeaderPlusButtonCell" data-role = "none">
								<div class="WidgetButtonTheme" data-role = "none" onclick="openChartsView()"><img src="${path}/eIPAD/images/Chart11.png"></div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<div class="widgetContentRow" data-role = "none">
				<div class="widgetHeaderMarginCell" data-role = "none">
				</div>
				<div class="widgetContentCell widgetContentCellTheme" data-role = "none">
					<div style="display:table;width:100%;text-align: -webkit-center;">
						<div style="display:table-row" class="">
							<div style="display:table-cell" class="widgetTabBckgrndTheme"><!-- Tab container -->
								<div class="" style="display:table;margin-top:10px">
									<div class="widgetleftview">
										<div style="display:table-cell;width:48%"><!-- Empty area -->
										</div>
										<div style="display:table-cell" class="widgetTabActiveTheme widgetTab widgetResTab" onclick="showResultsOf('<%=ResultsCatConstants.RESULTCATEGORY_LABORATORY%>',this)"><!-- Individual tabs -->
											<div class="widgetItemTxt"><%=csResBundle.getString("results.laboratory") %> (<%=labCount %>)</div>
										</div>
										<div style="display:table-cell" class="widgetTabNonActiveTheme widgetTabNonActive widgetTab widgetResTab" onclick="showResultsOf('<%=ResultsCatConstants.RESULTCATEGORY_RADIOLOGYIMAGING%>',this)"><!-- Individual tabs -->
											<div class="widgetItemTxt"><%=csResBundle.getString("results.radiology") %> (<%=radCount %>)</div>
										</div>
										<div style="display:table-cell" class="widgetTabNonActiveTheme widgetTabNonActive widgetTab widgetResTab" onclick="showResultsOf('<%=ResultsCatConstants.RESULTCATEGORY_SURGERYPROCEDURE%>',this)"><!-- Individual tabs -->
											<div class="widgetItemTxt"><%=csResBundle.getString("results.surgery") %> (<%=surgCount %>)</div>
										</div>
										<div style="display:table-cell" class="widgetTabNonActiveTheme widgetTabNonActive widgetTab widgetResTab" onclick="showResultsOf('<%=ResultsCatConstants.RESULTCATEGORY_DEPTDIAGNOSTICS%>',this)"><!-- Individual tabs -->
											<div class="widgetItemTxt"><%=csResBundle.getString("results.deptdiagnostics") %> (<%=diagCount %>)</div>
										</div>
										<div style="display:table-cell" class="widgetTabNonActiveTheme widgetTabNonActive widgetTab widgetResTab" onclick="showResultsOf('<%=ResultsCatConstants.RESULTCATEGORY_OTHERS%>',this)"><!-- Individual tabs -->
											<div class="widgetItemTxt"><%=csResBundle.getString("results.others") %> (<%=othersCount %>)</div>
										</div>
										<div style="display:table-cell;width:48%"><!-- Empty area -->
										</div>
									</div>
								</div>
							</div>
						</div>
						<div style="display:table-row">
							<div style="display:table-cell"><!-- Results data frame container -->
								<div src="${path}/mobile/chartsummary/ResultsDataView?Category=<%=ResultsCatConstants.RESULTCATEGORY_OTHERS%>" style="border:0;height:auto;width:100%;overflow:auto;min-height:50px;background:#ffffff" id="resultDataFrame"></iframe>
							</div>
							
						</div>
					</div>
				</div>
			</div>
			
			
		</div>
<!-- 	</form>  -->
	</div>
	
	

