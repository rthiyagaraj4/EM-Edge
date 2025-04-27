<!DOCTYPE html>
 
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesFieldResponse"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@page import="eOR.OrderEntryQueryBean"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
String mode = request.getParameter("mode")==null?"FREQ":request.getParameter("mode");

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	ClinicalNotesBC bc = new ClinicalNotesBC();
	ClinicalNotesFieldResponse noteTypeListResp;
	if(mode.equals("FREQ")){
		noteTypeListResp = bc.getFrequentlyUsedNoteTypes(patientContext);
	}else{
		noteTypeListResp = bc.getAllFilterNoteTypes(patientContext);
	}
	
	List<ClinicalNotesFieldItem> noteTypeList = noteTypeListResp.getFieldList();



%>
<style>
.vscroller5{
	width: 100%;
	height: auto;
	position: absolute;
	z-index: 1;
}

</style>
<script>
$(document).ready(function(){
	assignNoteListContentsScroll()
});

var ordItemContentsScroll;

function assignNoteListContentsScroll () {
	ordItemContentsScroll = new IScroll('#OrdItemContentsWrap', { 
		scrollX: false, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}
function clearTemplateFilterTxt(){
	$("#NoteTypeFilterTxt").val("");
	$("#NoteFilterTxtClearButton").addClass("cstFieldDull");
	filterNoteTypes();
	
}
function filterNoteTypes(){
	$("#norecordsMatch").hide();
	var filterTxt = $("#NoteTypeFilterTxt").val();
	var hasTemplate = false;
	filterTxt = filterTxt.toLowerCase();
	$(".NoteTypeBlock .NoteTypeBlock-desc").each(function(){
		var thisNoteDesc = $(this).data("text");
		$(this).html(thisNoteDesc); //reset text if already bolded
	});
	$(".NoteTypeBlock .NoteTypeBlock-spec").each(function(){
		var thisNoteSpec = $(this).data("text");
		$(this).html(thisNoteSpec); //reset text if already bolded
	});
	if(filterTxt.length<1){
		
		$('#NoteFilterTxtClearButton').attr('src', path+'/eIPAD/images/SearchGray16x16.png');
		$(".NoteTypeBlock").each(function(){
			//var thisNoteDesc = $("#"+$(this).attr('id')+" .NoteTypeBlock-desc").data("text");
			//$("#"+$(this).attr('id')+" .NoteTypeBlock-desc").html(thisNoteDesc); //reset text if already bolded
			//var thisNoteSpec = $("#"+$(this).attr('id')+" .NoteTypeBlock-spec").data("text");
			//$("#"+$(this).attr('id')+" .NoteTypeBlock-spec").html(thisNoteSpec); //reset text if already bolded
			$(this).show();
		});
		
	}else{
		 $('#NoteFilterTxtClearButton').attr('src', path+'/eIPAD/images/Close-small.png');
		 $("#removeSearchClass").removeClass("dvSerarchIcon").addClass("slSfsTextBoxCloseButton");
		 $("#removeSearchClass").css("padding-left","10px");
		$(".NoteTypeBlock").each(function(){
			
			var thisNoteDesc = $("#"+$(this).attr('id')+" .NoteTypeBlock-desc").data("text");
			//$("#"+$(this).attr('id')+" .NoteTypeBlock-desc").html(thisNoteDesc); //reset text if already bolded
			thisNoteDesc = thisNoteDesc.toString().trim().toLowerCase();
			var thisNoteSpec = $("#"+$(this).attr('id')+" .NoteTypeBlock-spec").data("text");
			//$("#"+$(this).attr('id')+" .NoteTypeBlock-spec").html(thisNoteSpec); //reset text if already bolded
			thisNoteSpec = thisNoteSpec.toString().trim().toLowerCase();
			if(thisNoteDesc.indexOf(filterTxt)!=-1 || thisNoteSpec.indexOf(filterTxt)!=-1){
				if(thisNoteDesc.indexOf(filterTxt)!=-1){
					var start_bold = thisNoteDesc.indexOf(filterTxt);
					var end_bold = start_bold + filterTxt.length;
					thisNoteDesc = $("#"+$(this).attr('id')+" .NoteTypeBlock-desc").data("text");
					thisNoteDesc = thisNoteDesc.substring(0,start_bold) + '<b>' + thisNoteDesc.substring(start_bold,end_bold) + '</b>' + thisNoteDesc.substring(end_bold,thisNoteDesc.length);
					$("#"+$(this).attr('id')+" .NoteTypeBlock-desc").html(thisNoteDesc);
				}
				if(thisNoteSpec.indexOf(filterTxt)!=-1){
					var start_bold = thisNoteSpec.indexOf(filterTxt);
					var end_bold = start_bold + filterTxt.length;
					thisNoteSpec = $("#"+$(this).attr('id')+" .NoteTypeBlock-spec").data("text");
					thisNoteSpec = thisNoteSpec.substring(0,start_bold) + '<b>' + thisNoteSpec.substring(start_bold,end_bold) + '</b>' + thisNoteSpec.substring(end_bold,thisNoteSpec.length);
					$("#"+$(this).attr('id')+" .NoteTypeBlock-spec").html(thisNoteSpec);
				}
				hasTemplate = true;
				$(this).show();
				
			}else{
				$(this).hide();
			}
		});
		if(!hasTemplate){
			$("#norecordsMatch").show();
		}
	}
	ordItemContentsScroll.refresh();
}
</script>
<style>
.norecords{
    display: block;
    height: 100%;
    vertical-align: middle;
    text-align: left;
    padding-left: 10px;
    color: #454a4b;
    font-size: 13px;
    font-family: arial;
}
.roundiconstyle{
    background: #196986;
    -moz-border-radius: 60px;
    -webkit-border-radius: 60px;
    border-radius: 60px;
    -moz-box-shadow: 0px 0px 2px #196986;
    -webkit-box-shadow: 0px 0px 2px #196986;
    box-shadow: 0px 0px 2px #196986;
}
}
</style>
<div style="display:table;width:100%;height:100%">

<%if(!mode.equals("FREQ")){ %>
	<!-- filter text box row -->
	<div style="display:table-row">
<%-- 		<div style="display:table-cell;height:2%;width:100%;padding:10px">
			<div style="display:table;width:100%;height:40px;background:#efefef;">	
				<div style="display:table-row">
					<div style="display:table-cell;width:95%;height:100%;vertical-align:middle;">
						<input type="text" style="width:98%;height:100%;border:none;background:#fff;padding:5px" onkeyup="filterNoteTypes()" id="NoteTypeFilterTxt" name="NoteTypeFilterTxt" id="NoteTypeFilterTxt"/>
					</div>
					<div style="display:table-cell;height:100%;vertical-align:middle;text-align:center;padding:5px;" onclick="clearTemplateFilterTxt()">
					    <img src="${path}/eIPAD/images/Search18x18.png" id="NoteFilterTxtClearButton" class="roundiconstyle">
					</div>
				</div>
			</div>
		</div> --%>
		<!-- Allergy search bar -->
		<div class="divEvent divEventTheme" style="width: 96.5%;margin-top: 10px;margin-bottom: 10px;">
			<table cellpadding="0" cellspacing="0"
				style="width: 100%; height: 100%">
				<tr style="width: 100%; height: 100%">
					<td style="width: 99%; height: 100%" valign="middle">
					<input type="text" class="txtContent" style="height:31px;width:98%" onkeyup="filterNoteTypes()" id="NoteTypeFilterTxt" name="NoteTypeFilterTxt" id="NoteTypeFilterTxt"/>
					</td>

					<td style="width: 1%; height: 100%">
						<div class="cellDivider">
							<div id="removeSearchClass" class="dvSerarchIcon" onclick="clearTemplateFilterTxt()">
							    <img src="${path}/eIPAD/images/SearchGray16x16.png" id="NoteFilterTxtClearButton">
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- filter text box row -->
<%
	}
%>
	<div style="display:table-row">
		<div style="display:table-cell;width:100%;height:98%">
			<div id="OrdItemContentsWrap" style="position: relative;width: 100%;height:100%;overflow: hidden;background: #f7f7f7">
			<%if(noteTypeList!= null && !noteTypeList.isEmpty()){ %>
				<div class="vscroller5" id="">
					<div style="display:block;margin: 5px 9px;">
					
					<%
					for(int i=0;i<noteTypeList.size();i++) {
						ClinicalNotesFieldItem fieldItem = noteTypeList.get(i);
					%>
						<div id="NoteTypeBlock_<%=fieldItem.getCode()%><%if(fieldItem.getDetail2()!=null){%>_<%=fieldItem.getDetail2()%><%}%>" class="NoteTypeBlock" style="display:inline-block;width:170px;height:63px;background:#fff;border:1px solid #cecfce;border-radius:5px;margin:1px" onclick="loadNoteSections('<%=fieldItem.getCode()%>')">
							<div style="display:table;width:100%;height:100%">
								<div style="display:table-row">
									<div style="display:table-cell;width:100%;height:33px">
										<div style="display:table;width:100%;height:100%">
											<div style="display:table-row;">
												<div style="display:table-cell;width:32px;height:100%;vertical-align:middle;padding-top:5px;padding-left:5px;padding-bottom:0px;padding-right:0px">
													<img src="${path}/eIPAD/images/Note24x31.png"/>
												</div>
												<div class="NoteTypeBlock-desc" style="display:table-cell;height:100%;vertical-align:middle;text-align:left;padding-left:3px;color:#454a4b;font-size:13px;font-family:arial" data-text="<%=fieldItem.getDesc() %>"><%=fieldItem.getDesc() %></div>
											</div>
										</div>
									</div>
									
								</div>
								<div style="display:table-row">
									<div style="display:table-cell;width:100%;vertical-align:bottom;text-align:right;color:#989898;font-size:12px;font-family:arial;padding-right:5px;padding-bottom:5px;" class="NoteTypeBlock-spec" data-text="<%if(fieldItem.getDetail()!=null && !fieldItem.getDetail().equals("*ALL")){%><%=fieldItem.getDetail()%><%}%>"><%if(fieldItem.getDetail()!=null && !fieldItem.getDetail().equals("*ALL")){%><%=fieldItem.getDetail()%><%}%></div>
								</div>
							</div>
						</div>
					<%} %>	
					</div>
				</div>
				<%} else{  %>
				<div id="" class="norecords" style=""> No template matches the search criteria</div>
				<%} %>
				<div id="norecordsMatch" class="norecords" style="display:none"> No template matches the search criteria</div>
			</div>
		</div>
	</div>
</div>

<%} %>
	

