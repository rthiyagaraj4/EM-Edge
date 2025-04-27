<%@page import="eOR.ORReviewResult.ORReviewResultHome"%>
<%@page import="eOR.Common.OrRepository"%>
<%@page import="com.ehis.eslp.ServiceLocator"%>
<%@page import="eIPAD.pendingresults.PrevResultDateContainer"%>
<%@page import="eIPAD.pendingresults.PrevResultCountResponse"%>
<%@page import="eIPAD.pendingresults.PreviousResultsResponse"%>
<%@page import="eIPAD.pendingresults.PreviousResultsRequest"%>
<%@page import="eIPAD.pendingresults.ResultDetail"%>
<%@page import="eIPAD.pendingresults.ResultCategory"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="eIPAD.pendingresults.PendingResultForPatient"%>
<%@page import="eIPAD.pendingresults.PatientDetail"%>
<%@page import="eIPAD.pendingresults.PendingResultsResponse"%>
<%@page import="eIPAD.pendingresults.PendingResults"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIPAD.pendingresults.PendingResultsRequest"%>
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
	// from and to period is not useful as of now but having such 
	// properties in the request helps when the from and to time period
	// components are introduced
	String fromPeriod = request.getParameter("hdnFromPeriod");
	fromPeriod = CommonBean.checkForNull(fromPeriod,
			IPADConstants.LAST_ONE_WEEK);
	if (fromPeriod.trim().equals("")) {
		fromPeriod = IPADConstants.LAST_ONE_WEEK;
	}

	String toPeriod = request.getParameter("hdnTPeriod");
	toPeriod = CommonBean.checkForNull(toPeriod);

	String selectedPeriod = request.getParameter("hdnSelectedPeriod");//hdnSelectedPeriod
	selectedPeriod = CommonBean.checkForNull(selectedPeriod,
			IPADConstants.LAST_ONE_WEEK);
	
	String selectedPeriodText="";
	if(selectedPeriod.equals("LOD")){
		selectedPeriodText="Last One Day";
	}
	else if(selectedPeriod.equals("LTD")){
		selectedPeriodText="Last Three Days";
	}
	else if(selectedPeriod.equals("LOM")){
		selectedPeriodText="Last One Month";
	}
	else if(selectedPeriod.equals("LOY")){
		selectedPeriodText="Last One Year";
	}
	else{
		selectedPeriodText="Last One Week";
	}

	String searchClicked = request.getParameter("hdnSearchClicked");
	if (searchClicked == null || searchClicked.trim().equals("")) {
		searchClicked = "Y";
	}

	String normalcy = "";
	String patientId = "";
	// if search button is clicked then this page is reloaded
	// hence the need to set the patient id and the normalcy
	// comes in this case only
	if ("Y".equalsIgnoreCase(searchClicked)) {
		// changed to get the patient id from the patient text
		if(request.getParameter("hdnPatientId") != null && request.getParameter("hdnPatientId") != "")
		{
			patientId = ((String)request.getParameter("hdnPatientId")).trim().toUpperCase();
		}
		patientId = CommonBean.checkForNull(patientId);
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	} else {
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	}

	String groupby = request.getParameter("hdnGroupby");
	groupby = CommonBean.checkForNull(groupby);
	//String caNormalcyInd = request.getParameter("normalcy_ind");
	//caNormalcyInd = CommonBean.checkForNull(caNormalcyInd,"Z");
	String getTaskApplicability = request
			.getParameter("hdnGetTaskApplicability");
	getTaskApplicability = CommonBean
			.checkForNull(getTaskApplicability);

	// this will store the complete review clicked status
	String completeReviewClicked = request
			.getParameter("hdnCompleteReviewClicked");
	completeReviewClicked = CommonBean.checkForNull(
			completeReviewClicked, "N");

	// this will store the forward review clicked status
	String forwardReviewClicked = request
			.getParameter("hdnForwardReviewClicked");
	forwardReviewClicked = CommonBean.checkForNull(
			forwardReviewClicked, "N");

	String selectedRows = request.getParameter("hdnSelectedRows");
	selectedRows = CommonBean.checkForNull(selectedRows);
%>
<!DOCTYPE html>
<html>
<head>

<title>Pending Results Review</title>
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!--  <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  -->

<!-- <link rel="stylesheet" href="../css/iPadPendingResultCriteria.css" /> -->
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<link rel="stylesheet" href="../css/iPADNew.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>  -->
<script type="application/javascript" src="../js/iscroll.js"></script>
<!--  -->



<script type="text/javascript">

//variables for setting the content frame height according to the device
//below values are header footer heights
var pageHFheight= 90;
var content_height;


var prMainScroll ;

function assignPrScroll() {
		 setTimeout(function () {
		prMainScroll = new iScroll('divcnt', {
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

document.addEventListener('DOMContentLoaded', assignPrScroll, false);

document.addEventListener('touchmove', function(e) {
	e.preventDefault();
}, false);


var globaldrWidth;
var currentScrollingPendResDiv;

//previous results scroller object
var prevResScroll;
function assignPrevResHorizontalScroll(){
		//When the detailed result is scrolled iscroll object is assigned to this div
	  $('.prevResWrapperDiv').bind('touchstart click', function(event) { 

		  //alert(currentScrollingPendResDiv);
		  var currentDiv = $(this).attr('id');
		  //alert(currentDiv);

		  
		  if(currentScrollingPendResDiv){
			  
			  if(currentScrollingPendResDiv != currentDiv){
				  prevResScroll = new iScroll(currentDiv, {
						hScrollbar : false
				});
				currentScrollingPendResDiv = currentDiv;
				
			  }
		  }
		  else{
			  currentScrollingPendResDiv = currentDiv;
			  prevResScroll = new iScroll(currentDiv, {
					hScrollbar : false
			});
		  }
		  

		  
	  });  
}

document.addEventListener('DOMContentLoaded', assignPrevResHorizontalScroll, false);


//function to compute the previous results column width. This function should be called whenever the result frame gets resized
function computeDrWidth(){
	var globalprWidth= $('.prContentTable').width();
	// detailed results div width will be calculated below. 12 is the border and margin values
	globaldrWidth = Math.floor((globalprWidth - 12)/2);
	$('.drResultCategoryHeader').css('width', globaldrWidth+'px');
	$('.prevResWrapperDiv').css('width', globaldrWidth+'px');
	//alert(globaldrWidth);
}

function LoadPrevResDivs(){
	
	$(".prevResScrollerDiv:in-viewport").each(
			function() {
				var recordNum = $(this).attr('data-patnum');
				//alert("showing hscroll div" +recordNum);
				//Calculating the scroller width for each of the previous results div after loading detailed results. 
				//This is required to make the horizontal iScroll scroll till the end of the contents
				//If the previous results url is not loaded before load it, otherwise donot load it
				if($('#prevResScroller' + recordNum).find('.drRowContainerTheme table').length < 1)
				{
					//alert("loading prev res" +recordNum);
					$('#prevResScroller' + recordNum).load(
						document.getElementById("hdnDetailedResUrl"
								+ recordNum).value,
						function() {
							var scrollerWidth = $(
									'#prevResScroller' + recordNum).find(
									'.drRowContainerTheme table').width();
							//alert(recordNum + ' -  ' +scrollerWidth);
							$('#prevResScroller' + recordNum).css('width',
									scrollerWidth + 'px');
						});
				}
			});
}

	var currentScrollingDrDiv
	var detResScroll;
	function assignDetResVScroll() {
		//When the detailed result is scrolled iscroll object is assigned to this div
		$('.wrapperNested').bind(
				'touchmove click',
				function(event) {
					//prMainScroll.disable();
					//alert(currentScrollingDrDiv);
					var currentDiv = $(this).attr('id');
					//alert(currentDiv);

					if (currentScrollingDrDiv) {

						if (currentScrollingDrDiv != currentDiv) {
							setTimeout(function () {
								//alert("Creating new dr scroll");
								detResScroll = new iScroll(currentDiv, {
									useTransform : true,
									zoom : false,
	/* 								bounce: false,
									bounceLock: true,
									momentum: false, */
									onBeforeScrollStart : function(e) {
										var target = e.target;
										while (target.nodeType != 1) target = target.parentNode;

										if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' )
										e.preventDefault();
										
										//e.preventDefault(); 
										e.stopPropagation();
									}/*  ,
									onScrollEnd: function() {
										setTimeout(function () {
										  //LoadPrevResDivs();
										}, 100); 
									}  */
								});
								
							}, 100); 
							currentScrollingDrDiv = currentDiv;

						}
					} else {
						//alert("Creating new dr scroll");
						currentScrollingDrDiv = currentDiv;
						
						setTimeout(function () {
						detResScroll = new iScroll(currentDiv, {
							useTransform : true,
							zoom : false,
		/* 					bounce: false,
							bounceLock: true,
							momentum: false, */
							onBeforeScrollStart : function(e) {
								var target = e.target;
								while (target.nodeType != 1) target = target.parentNode;

								if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' )
								e.preventDefault();
								
								//e.preventDefault(); 
								e.stopPropagation();
							} /* ,
							onScrollEnd: function() {
								setTimeout(function () {
									  LoadPrevResDivs();
									}, 100); 
							}  */
						});
						
						}, 100); 
					}

				});
	}
	
	document.addEventListener('DOMContentLoaded', assignDetResVScroll, false);
	//document.addEventListener('DOMContentLoaded', LoadPrevResDivs, false);




	$(document).ready(
			function() {			
				  parent.removeSpinner();
				//Calling computeDrWidth() function to set the detailed results div width
				computeDrWidth();
				parent.setIframeHeight();
				

				//When enter key or space key is pressed in the patient ID text box, submit the form
				$('#PatientIdText').bind('keypress', function(e) {
					if (e.which == 32) {//space bar
						//alert('space');
						searchPendingResults();
					}
					if (e.which == 13) {//enter key
						//alert('enter');
						searchPendingResults();
					}

				});

				//Applying selected style to the current normalcy
				var currentNormalcySelected = document
						.getElementById("hdnNormalcyVal").value;
				//alert(currentNormalcySelected);
				if (currentNormalcySelected == ""
						|| currentNormalcySelected == "Z"
						|| currentNormalcySelected == "S")
					$('#normalcyAll').removeClass('prContentHolderIconTheme')
							.addClass('prContentHolderSelectedIconTheme');
				else if (currentNormalcySelected == "A")
					$('#normalcyAbnormal').removeClass(
							'prContentHolderIconTheme').addClass(
							'prContentHolderSelectedIconTheme');
				else if (currentNormalcySelected == "C")
					$('#normalcyCritical').removeClass(
							'prContentHolderIconTheme').addClass(
							'prContentHolderSelectedIconTheme');
				else if (currentNormalcySelected == "N")
					$('#normalcyNormal')
							.removeClass('prContentHolderIconTheme').addClass(
									'prContentHolderSelectedIconTheme');

			});
	
	function toggleMenuPR(){
		
		parent.toggleMenu();
		
		//setting timeout for computing detailed results column width because
		//a small gap will be created due to slow transition in the menu
		setTimeout(function(){
			computeDrWidth();
		},500);
		
		
	}

	var bShCriteria = true;

	function changeOrientation(orient,HFheight) {
	 	content_height = parent.getTotalPageDivHeight() - pageHFheight - HFheight;
		document.getElementById("divcnt").style.height = content_height+"px";
		if (prMainScroll != null)
			prMainScroll.refresh();
		computeDrWidth();
	}
	function showCriteria() {
		$('#searchCriteriaDiv').slideToggle('fast');
		if (bShCriteria) {
			bShCriteria = false;
			document.getElementById("imgCriteria").src = "../images/Heading-Panel-Up-Arrow.png";
		} else {
			bShCriteria = true;
			document.getElementById("imgCriteria").src = "../images/Heading-Panel-down-Arrow.png";
		}
	}

	function clearPatientIdText() {

		document.getElementById("PatientIdText").value = "";
		document.getElementById("hdnPatientId").value = "";
	}

	function searchPendingResults() {
		// get the selected period from the hidden component
		var hdnFromPeriod = document.getElementById("hdnFromPeriod");
		if (hdnFromPeriod) {
			selectedFromPeriod = hdnFromPeriod.value;
		}
		// the below code to also consider to period is only
		// to maintain uniformity - to period is not of use
		// presently
		var hdnToPeriod = document.getElementById("hdnToPeriod");
		var toPeriod;
		if (hdnToPeriod) {
			toPeriod = hdnToPeriod.value;
		}

		// set the flag that search button is clicked
		var hdnSearchClicked = document.getElementById("hdnSearchClicked");
		if (hdnSearchClicked) {
			hdnSearchClicked.value = "Y";
		}

		// get the selected normalcy and set it to the hidden component
		/* 		var normalcyComp = document.getElementById("NormalcyComp");
		 var hdnNormalcyComp = document.getElementById("hdnNormalcyVal");
		 if(normalcyComp){
		 var selectedNormalcy = normalcyComp.options[normalcyComp.selectedIndex].value;
		 if(hdnNormalcyComp){
		 hdnNormalcyComp.value = selectedNormalcy;
		 }
		 }
		 */
		var selectedNormalcy;
		var hdnNormalcyComp = document.getElementById("hdnNormalcyVal");
		if (hdnNormalcyComp) {
			if (hdnNormalcyComp.value != null && hdnNormalcyComp.value != '')
				selectedNormalcy = hdnNormalcyComp.value;
			else
				selectedNormalcy = 'S';
		}

		// get the patient id from the text and set it to the hidden component
		var patientIdComp = document.getElementById("PatientIdText");
		var hdnPatientComp = document.getElementById("hdnPatientId");
		if (patientIdComp) {
			var patientId = patientIdComp.value;
			patientId = $.trim(patientId);
			patientId = patientId.toUpperCase();
			patientIdComp.value = patientId;
			if (hdnPatientComp) {
				hdnPatientComp.value = patientId;
			}
		}

		// need to get groupby, and task applicability now
		var hdnGroupbyComp = document.getElementById("hdnGroupby");
		var groupbyVal;
		if (hdnGroupbyComp) {
			groupbyVal = hdnGroupbyComp.value;
		}

		var hdnTaskApplicability = document
				.getElementById("hdnGetTaskApplicability");
		var taskApplicabilityVal;
		if (hdnTaskApplicability) {
			taskApplicabilityVal = hdnTaskApplicability.value;
		}

		var hdnCompleteReviewClicked = document
				.getElementById("hdnForwardReviewClicked");
		if (hdnCompleteReviewClicked) {
			hdnCompleteReviewClicked.value = "";
		}

		// get the form and set the source url
		var pendingResultsForm = document.getElementById("PendingResultsForm");
		if (pendingResultsForm) {
			pendingResultsForm.action = "PendingResults-newUI.jsp?hdnFromPeriod="
					+ selectedFromPeriod
					+ "&hdnToPeriod="
					+ toPeriod
					+ "&hdnNormalcyVal="
					+ selectedNormalcy
					+ "&hdnGetTaskApplicability="
					+ taskApplicabilityVal
					+ "&hdnGroupby=" + groupbyVal;
			pendingResultsForm.submit();
		}
	}

	function setNormalcy(normalcy) {
		document.getElementById("hdnNormalcyVal").value = normalcy;
		searchPendingResults();

	}

	function Practitioner(strCode, strDesc) {
		document.getElementById("hdnPractCode").value = strCode;
		document.getElementById("hdnPractDesc").value = strDesc;

		forwardResult();
	}

	function showPractitioner() {
		document.getElementById("srchFrame").src = "Practitioner.jsp";
		$("#PendingResultsForm").toggle("fast");
		$("#Dialog").toggle("fast");
	}

	function showPracSfs() {
		document.getElementById("sfsFrame").src = "PendingResultsPractitionerSFS-newUI.jsp";
		$("#sfs").css('z-index', "1000");
		$("#sfsarrow").css('z-index', "1000");
		$('#sfs').toggle();
		$('#sfsarrow').toggle();
	}

	function completeReview() {
		var totalRecordComp = document.getElementById("hdnTotalRecords");
		var totalRecords;
		var totalRecordsInt;
		if (totalRecordComp) {
			totalRecords = totalRecordComp.value;
			totalRecordsInt = parseInt(totalRecords);
		}
		//alert('total records='+totalRecordsInt);

		var checkComp;
		var checkedCompCount = 0;
		var selectedRows = "";
		for (count = 1; count <= totalRecordsInt; count++) {
			checkComp = document.getElementById("check" + count);
			if (checkComp) {
				if (checkComp.checked) {
					if (checkedCompCount > 0) {
						selectedRows += "," + count;
					} else {
						selectedRows += "" + count;
					}
					checkedCompCount++;
				}
			}
		}

		if (checkedCompCount == 0) {
			alert('Check Atleast One Event');
			return false;
		}

		var selectedRowsComp = document.getElementById("hdnSelectedRows");
		if (selectedRowsComp) {
			selectedRowsComp.value = selectedRows;
		}

		// this should be deleted after the entire code for complete review
		// is done
		//return false;

		var completeReviewComp = document
				.getElementById("hdnCompleteReviewClicked");
		if (completeReviewComp) {
			completeReviewComp.value = "Y";
		}

		var confirmFlag = confirm("Do you want to complete the review of Selected Pending Results");
		if (confirmFlag) {
			var pendingResultsForm = document
					.getElementById("PendingResultsForm");
			if (pendingResultsForm) {
				pendingResultsForm.submit();
			}
		} else {
			return false;
		}

	}

	function forwardResult() {
		var totalRecordComp = document.getElementById("hdnTotalRecords");
		var totalRecords;
		var totalRecordsInt;
		if (totalRecordComp) {
			totalRecords = totalRecordComp.value;
			totalRecordsInt = parseInt(totalRecords);
		}
		//alert('total records='+totalRecordsInt);

		var checkComp;
		var checkedCompCount = 0;
		var selectedRows = "";
		for (count = 1; count <= totalRecordsInt; count++) {
			checkComp = document.getElementById("check" + count);
			if (checkComp) {
				if (checkComp.checked) {
					if (checkedCompCount > 0) {
						selectedRows += "," + count;
					} else {
						selectedRows += "" + count;
					}
					checkedCompCount++;
				}
			}
		}

		if (checkedCompCount == 0) {
			alert('Check Atleast One Event');
			return false;
		}

		var selectedRowsComp = document.getElementById("hdnSelectedRows");
		if (selectedRowsComp) {
			selectedRowsComp.value = selectedRows;
		}

		// this should be deleted after the entire code for complete review
		// is done
		//return false;

		var completeReviewComp = document
				.getElementById("hdnCompleteReviewClicked");
		if (completeReviewComp) {
			completeReviewComp.value = "N";
		}

		var forwardReviewComp = document
				.getElementById("hdnForwardReviewClicked");
		if (forwardReviewComp) {
			forwardReviewComp.value = "Y";
		}

		var confirmFlag = confirm("Do you want to Forward the selected Results");
		if (confirmFlag) {
			var pendingResultsForm = document
					.getElementById("PendingResultsForm");
			if (pendingResultsForm) {
				pendingResultsForm.submit();
			}
		} else {
			return false;
		}

	}

	function selectAllRecords() {

		parentchkbox = document.getElementById("selectAll");
		$("#divcnt input:checkbox").each(function() {
			this.checked = parentchkbox.checked;
		});

	}

	function selectPatientCategories(pc) {

		parentchkbox = document.getElementById("checkb" + pc);
		$("[data-patientcat = '" + pc + "']").each(function() {
			this.checked = parentchkbox.checked;
		});

	}

	function selectAllPatientCategories(patientCounter) {
		parentchkbox = document.getElementById("checkc" + patientCounter);
		$("[data-patient = '" + patientCounter + "']").each(function() {
			this.checked = parentchkbox.checked;
		});
	}

	function DisplayOrHideDetails(HeaderName, tableobj) {
		var objImgId = "expander" + HeaderName;
		var objImg = document.getElementById(objImgId)
		var imgPath = objImg.src;
		if (imgPath.indexOf("Collapse") != -1) {
			objImg.src = "../images/Expandview.png";
			$("[data-class = '" + HeaderName + "']").css('display', 'none');
			$("[data-class='Expandable" + HeaderName + "']").removeClass(
					'prContentTableSelectedTheme').addClass(
					'prContentTableTheme');
		} else {
			objImg.src = "../images/Collapseview.png";
			$("[data-class = '" + HeaderName + "']").css('display', 'block');
			$("[data-class='Expandable" + HeaderName + "']").removeClass(
					'prContentTableTheme').addClass(
					'prContentTableSelectedTheme');
		}
		var src = "../images/Expanded group Icon.png";
		// $("[data-image = '" + HeaderName + "']").css('background', 'url(' + src + ')'); 
		$("[data-image = '" + HeaderName + "']").attr("src", src);


		if (prMainScroll != null)
			prMainScroll.refresh();
		
		if(prevResScroll !=null)
			prevResScroll.refresh();
		
		//assignDetResVScroll();
		if (detResScroll != null) {
			detResScroll.refresh();
		}

	}
	


	function DetailedResultExpand(expUIMarker) {

		$("[data-fulldet = 'detResCompressCol" + expUIMarker + "']").css(
				'width', '50%');
		$("[data-fulldet = 'detResHideCol" + expUIMarker + "']").css('display',
				'none');
		$("[data-fulldet = 'detResExpandCol" + expUIMarker + "']").css('width',
				globaldrWidth + 'px');
		$("[data-fulldet = 'detResExpandCol" + expUIMarker + "']").css(
				'display', 'block');
		$("[data-fulldet = 'detResExpandColHead" + expUIMarker + "']").css(
				'display', 'block');
		$("[data-fulldet = 'detResCloseCol" + expUIMarker + "']").css(
				'display', 'block');
		$("[data-fulldet = 'detResExpandCol" + expUIMarker + "'] .prevResScrollerDiv").each(
				function() {
					var recordNum = $(this).attr('data-patnum');
					//Calculating the scroller width for each of the previous results div after loading detailed results. 
					//This is required to make the horizontal iScroll scroll till the end of the contents
					if($('#prevResScroller' + recordNum).find('.drRowContainerTheme table').length < 1)
					{
					$('#prevResScroller' + recordNum).load(
							document.getElementById("hdnDetailedResUrl"
									+ recordNum).value,
							function() {
								var scrollerWidth = $(
										'#prevResScroller' + recordNum).find(
										'.drRowContainerTheme table').width();
								//alert(recordNum + ' -  ' +scrollerWidth);
								$('#prevResScroller' + recordNum).css('width',
										scrollerWidth + 'px');
							});
					}
				}); 

		//assignPrevResHorizontalScroll();
		//assignDetResVScroll();
		
		//LoadPrevResDivs();
		if (prevResScroll != null) {
			prevResScroll.refresh();
		}
		if (detResScroll != null) {
			detResScroll.refresh();
		} 
	}

	function DetailedResultCompress(expUIMarker) {
		$("[data-fulldet = 'detResCompressCol" + expUIMarker + "']").css(
				'width', '100%');
		$("[data-fulldet = 'detResHideCol" + expUIMarker + "']").css('display',
				'block');
		$("[data-fulldet = 'detResExpandCol" + expUIMarker + "']").css('width',
				'0%');
		$("[data-fulldet = 'detResExpandCol" + expUIMarker + "']").css(
				'display', 'none');
		$("[data-fulldet = 'detResExpandColHead" + expUIMarker + "']").css(
				'display', 'none');
		$("[data-fulldet = 'detResCloseCol" + expUIMarker + "']").css(
				'display', 'none');
	}

	function DetailedIndvResultExpand(recordCounter) {

		$("[data-indvdet = 'detResCompressCol" + recordCounter + "']").css(
				'width', '50%');
		$("[data-indvdet = 'detResArrowCol" + recordCounter + "']").css(
				'display', 'none');
		$("[data-indvdet = 'detResCloseCol" + recordCounter + "']").css(
				'display', 'block');
		$("[data-indvdet = 'detResExpandCol" + recordCounter + "']").css(
				'width', globaldrWidth + 'px');
		$("[data-indvdet = 'detResExpandCol" + recordCounter + "']").css(
				'display', 'block');

		//Calculating the scroller width for each of the previous results div after loading detailed results. 
		//This is required to make the horizontal iScroll scroll till the end of the contents
		if($('#prevResScroller' + recordCounter).find('.drRowContainerTheme table').length < 1)
		{
	 		$('#prevResScroller' + recordCounter).load(
					document.getElementById("hdnDetailedResUrl"
							+ recordCounter).value,
					function() {
						var scrollerWidth = $(
								'#prevResScroller' + recordCounter).find(
								'.drRowContainerTheme table').width();
						//alert(recordNum + ' -  ' +scrollerWidth);
						$('#prevResScroller' + recordCounter).css('width',
								scrollerWidth + 'px');
					}); 
		}
		//assignPrevResHorizontalScroll();
		//assignDetResVScroll();
		
		//LoadPrevResDivs();
		if (prevResScroll != null) {
			prevResScroll.refresh();
		}
/* 		if (detResScroll != null) {
			detResScroll.refresh();
		} */
	}

	function DetailedIndvResultCompress(recordCounter,recordGroup) {
		$("[data-indvdet = 'detResCompressCol" + recordCounter + "']").css(
				'width', '100%');
		$("[data-indvdet = 'detResArrowCol" + recordCounter + "']").css(
				'display', 'block');
		$("[data-indvdet = 'detResCloseCol" + recordCounter + "']").css(
				'display', 'none');
		$("[data-indvdet = 'detResExpandCol" + recordCounter + "']").css(
				'width', '0%');
		$("[data-indvdet = 'detResExpandCol" + recordCounter + "']").css(
				'display', 'none');
		//when all previous results are closed, header is also collapsed
		if($("[data-fulldet = 'detResExpandCol" + recordGroup + "']:visible").length == 0){
			DetailedResultCompress(recordGroup);
		}
			
	}

	function toggleLegend() {
		$('#legendContainer').toggle();
	}

	function showPeriodSelect() {
		$("#periodSelect").css('z-index', "1000");
		$("#periodArrow").css('z-index', "2000");
		$('#periodSelect').toggle();
		$('#periodArrow').toggle();
	}
	function selectPeriod(sPeriod) {
		showPeriodSelect();
		document.getElementById("hdnSelectedPeriod").value = sPeriod;
		document.getElementById("hdnFromPeriod").value = sPeriod;
		searchPendingResults();
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body style= "width:100%; height:100%;">
	<div id = "sfsarrow" data-role = "none" class = "pr-sfs-bubble-arrow sfs-bubble-arrowIPTheme" ></div>
   	<div data-role = "none" class = "pr-sfs sfsIPTheme"  id = "sfs" >
  	 	<iframe id = "sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" height = "300px" width = "400px" src = ""></iframe>  
   	</div> 
	<div id = "periodArrow" data-role = "none" class = "periodSelectArrow periodSelectArrowTheme" ></div>
   	<div data-role = "none" class = "periodSelectContainer periodSelectContainerTheme"  id = "periodSelect" >
			<table cellpadding = "0" cellspacing = "0" border = "0">
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LOD')">Last One Day</div></td></tr>
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LTD')">Last Three Days</div></td></tr>
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LOW')">Last One Week</div></td></tr>
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LOM')">Last One Month</div></td></tr>
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LOY')">Last One Year</div></td></tr>
			</table>
   	</div> 
	<div data-role = "page" style = "padding:0px;width:100%;height:100%;">

		<form name='PendingResultsForm' id='PendingResultsForm' method='post' id="PendingResultsForm" style = "width:100%;height:100%;">

			<div class ="prHeader">
				<div class="prHeaderMenuContainer1 prHeaderMenuContainer1Theme">
					<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
						<tr style = "height:100%;width:100%">
							<td style = "width:7%; padding-left:5px;">
			        			<div class = "WidgetButtonTheme" onclick="toggleMenuPR()"><img src = "../images/MenuIcon.png"/></div>
			   				</td>
			    			<td style = "width:73%">
			         			<div class = "prHeaderPageTitle prHeaderPageTitleTheme">Pending Results Review</div>
			   				</td>
					   		<td style = "width:20%">
					         		<div class="prHeaderSearchPatientText prHeaderSearchPatientTextTheme">
					         		<table cellpadding = "0" cellspacing = "0" border = "0"><tr>
								   	<td style="width:5%; padding-top:5px"><img src="../images/Search.png" onclick="searchPendingResults()" style="margin-left:5px;"/></td>
								    <td style="width:90%;">
								        <input type="text" name = "PatientIdText" id = "PatientIdText"  placeholder="Patient ID"  class="prHeaderSearchPatientTxtBox prHeaderSearchPatientTxtBoxTheme" value = "<%=patientId%>">
								    </td>
								   	<td style="width:5%; padding-top:5px;padding-right:6px"><img src="../images/Close-small.png" style="padding-right: 10px" onclick="clearPatientIdText()"/></td>
								   	</tr></table>
								   	</div>
					   		</td>
						</tr>
		    		</table>
				</div>

	  			<div class = "prHeaderMenuContainer2">
	  				<div  data-role ="none" class ="prContentHolderHeader prContentHolderHeaderTheme">
						<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  				<tr style = "height:100%;width:100%" align="center" valign="middle">
								<td style = "width:4%">
							         <div class="prCheckboxContainer"><input type="checkbox" name="selectAll" id="selectAll" id="selectAll" value="selectAll" onchange="selectAllRecords()" class="prCheckboxTheme"></div>
							    </td>
							    <td style = "width:8%">
							         <div class = "WidgetButtonTheme" onclick="showPracSfs()"><img src = "../images/Forward.png"/></div>
							    </td>
							    <td style = "width:4%"></td>
							    <td style = "width:8%">
							         <div class = "WidgetButtonTheme" onclick="completeReview()"><img src = "../images/ReviewComplete.PNG"/></div>
							    </td>
							    <td style = "width:20%">

							    </td>
							    <td style = "width:30%"><div class = "prHeaderMenu2ButtonsTheme" onclick="showPeriodSelect()"><%=selectedPeriodText %></div></td>
							    <td style = "width:15%" align = "right" valign = "center">
							    	<table class= "prContentHolderIconContainer" cellpadding = "0" cellspacing = "0" border = "0">
									    <tr>
											<td class = "prContentHolderIconTheme" onclick="setNormalcy('S')" id="normalcyAll"><img src = "../images/view01.png" style="vertical-align: middle;"/></td>
											<td class = "prContentHolderIconTheme" onclick="setNormalcy('N')" id="normalcyNormal"><div class="prNormalcyNormalTheme"></div></td>
								        	<td class = "prContentHolderIconTheme" onclick="setNormalcy('A')" id="normalcyAbnormal"><div class="prNormalcyAbnormalTheme"></div></td>
								        	<td class = "prContentHolderIconTheme" onclick="setNormalcy('C')" id="normalcyCritical"><div class="prNormalcyCriticalTheme"></div></td>

								        </tr>
						        	</table>	
						    	</td>
			 				</tr>
		    			</table>	  
	  				</div>
	  			</div>
	  		</div>


	
		<div id = 'divcnt'  class = 'divPRcontent divPRcontentTheme' >
			<div style = "width:100%;height:auto;overflow:auto" >
	<%
		PendingResultsResponse pendingResultsResponse = null;
		Map<PatientDetail, PendingResultForPatient> pendingResultMap = null;
		int recordCounter = 1;
		// this will contain the total records obtained
		int totalRecords = 0;
		// code should be put here to complete the review if
		// user has clicked on complete review button
		// same way handle the forward to practitioner request
		if ("Y".equalsIgnoreCase(completeReviewClicked)) {
			String hist_rec_type = "";
			String contr_sys_id = "";
			String contr_sys_event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				contr_sys_event_code = request
						.getParameter("hdnControlSysEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				create_date_time = request
						.getParameter("hdnCreationDateTime" + token);
				review_remarks = request
						.getParameter("hdnReviewRemarks" + token);

				record = new String[7];
				record[0] = hist_rec_type;
				record[1] = contr_sys_id;
				record[2] = contr_sys_event_code;
				record[3] = accession_num;
				record[4] = review_type;
				record[5] = create_date_time;
				record[6] = review_remarks;

				// this is the key used in the desktop application
				// and only this key is understood by the ejb
				dataMap.put("review_data" + selectionCounter, record);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
								+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						contr_sys_event_code = request
								.getParameter("hdnControlSysEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						create_date_time = request
								.getParameter("hdnCreationDateTime" + token);
						review_remarks = request
								.getParameter("hdnReviewRemarks" + token);
	
						record = new String[7];
						record[0] = hist_rec_type;
						record[1] = contr_sys_id;
						record[2] = contr_sys_event_code;
						record[3] = accession_num;
						record[4] = review_type;
						record[5] = create_date_time;
						record[6] = review_remarks;
	
						// this is the key used in the desktop application
						// and only this key is understood by the ejb
						dataMap.put("review_data" + selectionCounter, record);
	
						selectionCounter++;
					}
				}
			}

			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_DELETE"));
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT"));
				sqlMap.put(
						"SQL_OR_RESULT_REVIEW_REVIEWED_PRACT",
						OrRepository
								.getOrKeyValue("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT"));
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("insert", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				%>
				<script>
				alert("Could not complete the review.");
				</script>
				<%		
					}
				}else{
				%>
				<script>
				alert("Could not complete the review. Error in getting result from EJB layer ");
				</script>
				<%
				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		// this code is for forward functionality
		if ("Y".equalsIgnoreCase(forwardReviewClicked)) {

			String hist_rec_type = "";
			String contr_sys_id = "";
			String event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";
			String normalcy_ind = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			// this list will have the details of all the records
			// being forwarded
			List<Map<String,String>> forwardPractDetailsList = new ArrayList<Map<String,String>>();
			// Map will have the details about one record being forwarded
			Map<String,String> forwardPractDetailsMap = new HashMap<String,String>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				event_code = request
						.getParameter("hdnEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
				
				forwardPractDetailsMap.put("hist_rec_type", hist_rec_type);
				forwardPractDetailsMap.put("contr_sys_id", contr_sys_id);
				forwardPractDetailsMap.put("accession_num", accession_num);
				forwardPractDetailsMap.put("review_type", review_type);
				forwardPractDetailsMap.put("event_code", event_code);
				forwardPractDetailsMap.put("normalcy_ind", normalcy_ind);
				
				forwardPractDetailsList.add(forwardPractDetailsMap);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						event_code = request
								.getParameter("hdnEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
						
						selectionCounter++;
					}
				}
			}

			// now form the forward practitioner id list
			List<String> forwardPractIdList = new ArrayList<String>();
			// get the practitioner id to forward the result
			// from the request parameter
			// presently the assumption is that this parameter will contain
			// only one practitioner id - in future, multiple practitioner
			// id selection can be also be supported by setting
			// a comma separated string in the parameter
			String forwardPractId = request.getParameter("hdnPractCode");
			forwardPractIdList.add(forwardPractId);
			dataMap.put("forwardPract_id",forwardPractIdList);
			
			// this is the key used in the desktop application
			// and only this key is understood by the ejb
			dataMap.put("forwardPractHash", forwardPractDetailsList);
			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			// no need to send the total count as it is not needed
			//dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT",
						OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT") );
	            sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK",
	            		OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK") );
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
				%>
				<script>
				alert("Could not forward the result.");
				</script>
				<%
			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("modify", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				%>
				<script>
				alert("Could not forward the result.");
				</script>
				<%		
					}else{
				%>
				<script>
				alert("Successfully forwarded the result.");
				</script>
				<%		
					}
				}else{
				%>
				<script>
				alert("Could not forward the result. Error in getting result from EJB layer ");
				</script>
				<%
				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		int patientCounter = 0;
		
		if ("Y".equalsIgnoreCase(searchClicked)) {
			PendingResultsRequest pendingResultsRequest = new PendingResultsRequest();
			pendingResultsRequest.setRequest(request);
			pendingResultsRequest.setSession(session);
			pendingResultsRequest.setNormalcyIndicator(normalcy);
			pendingResultsRequest.setLocale(IPADConstants.LOCALE);

			PendingResults beanInst = new PendingResults();
			pendingResultsResponse = beanInst
					.getPendingResults(pendingResultsRequest);
			pendingResultMap = pendingResultsResponse
					.getPendingResultsMap();
			totalRecords = pendingResultsResponse.getTotalRecords();

			if (pendingResultMap == null || pendingResultMap.isEmpty()) {
	%>
			
			
			<span class="prSearchResultsEmptyTheme"><%= IPADConstants.NORECORDS_HTML%></span>
			<%
					} else {
							Set<Entry<PatientDetail, PendingResultForPatient>> entrySet = pendingResultMap
									.entrySet();
							Iterator<Entry<PatientDetail, PendingResultForPatient>> iterator = entrySet
									.iterator();
							Entry<PatientDetail, PendingResultForPatient> entry = null;
							PatientDetail patientDetail = null;
							String patientDetailString = null;
							// this var is used as the parameter
							// passed to the expand or hide js function parameter
							// basically this var will contain the patient name
							// without single quote
							String patDtlStrForDisplay = null;
							int pendingResultCount = 0;

							
							
							PendingResultForPatient pendingResultForPatient = null;
							Map<ResultCategory, List<ResultDetail>> pendingResultMapForPatient = null;
							ResultCategory resultCategory = null;
							Entry<ResultCategory, List<ResultDetail>> resultCatEntry = null;
							while (iterator.hasNext()) {
								
								// increment the patient counter
								patientCounter++;
								
								entry = iterator.next();
								patientDetail = entry.getKey();
								patientDetailString = patientDetail.getPatientId();
								
								// code added to fix the bug where if the patient name
								// itself contains a single quote then the 
								// javascript function called to expand or hide does not
								// work - in fact the js function itself is not being called
								patDtlStrForDisplay = "";
								int charIndex = 0;
								int oldIndex = 0;
								while(true){
									charIndex = patientDetailString.indexOf("'",charIndex);
									if(charIndex < 0){
										break;
									}
									if(oldIndex < charIndex){
										oldIndex++;
									}
									patDtlStrForDisplay += patientDetailString.substring(oldIndex, charIndex);
									oldIndex = charIndex;
									charIndex++;
								}
								if(oldIndex > 0){
									patDtlStrForDisplay += patientDetailString.substring(oldIndex+1);	
								}else{
									patDtlStrForDisplay += patientDetailString;
								}
								
								
								patientDetailString += " ";
								patientDetailString += patientDetail.getAge();
								patientDetailString += ",";
								patientDetailString += patientDetail.getSex();
								patientDetailString += "    ";
								//patientDetailString += patientDetail.getPatientId();

								pendingResultForPatient = entry.getValue();
								pendingResultCount = pendingResultForPatient
										.getPendingRecordCountForPatient();
				%>
			
			

			<input type="hidden" id="hdnTotalRecords" name="hdnTotalRecords" id="hdnTotalRecords" value="<%=totalRecords%>"/>
			
				<table class = "prContentTable prContentTableTheme" cellpadding = "0" cellspacing = "0"  border = "0" data-class="Expandable<%=patDtlStrForDisplay%>">
				<tr class="prResultsHeader">
					<td style='width: 4%' align="center" valign="middle"> 
						<div class="prCheckboxContainer">
							<input type="checkbox" id="checkc<%=patientCounter%>" name="checkc<%=patientCounter%>" onchange="selectAllPatientCategories('<%=patientCounter%>')" value="" class="prCheckbox prCheckboxTheme">
						</div>
					</td>
					<td style='width: 96%' align='left'>
						<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0" onclick="DisplayOrHideDetails('<%=patDtlStrForDisplay%>' , this)">
							<tr>
								<td style='width: 88%' align='left'>
								<div class="prTxtRowsBold prTxtRowsBoldTheme"><%=patientDetailString%></div>
								<div class="prTxtRows prTxtRowsTheme"><%=patientDetail.getPatientName()%></div>	
								</td>
								<td style="width:6%" align="center">
									<div><input type="button" value="<%=pendingResultCount%>" class="prCountButtonTheme"> </div>
								</td>
								
								<td style="width:6%" align="center">
									<div><img id="expander<%=patDtlStrForDisplay%>" src="../images/Expandview.png"/></div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				
								<%
					pendingResultMapForPatient = pendingResultForPatient
										.getPendingResultMapForPatient();
								Set<Entry<ResultCategory, List<ResultDetail>>> resultCatSet = pendingResultMapForPatient
										.entrySet();
								Iterator<Entry<ResultCategory, List<ResultDetail>>> resultCatItr = resultCatSet
										.iterator();
								List<ResultDetail> resultDetailList = null;
								int resCatCount = 0; //We use this variable for grouping the category results for the expandable view in UI

								while (resultCatItr.hasNext()) {
									resCatCount++;
									String expUIMarker = "P"+patientCounter+"R"+resCatCount;
									//patDtlStrForDisplay +="_R"+resCatCount;
									resultCatEntry = resultCatItr.next();
									resultCategory = resultCatEntry.getKey();
									//pendingResultCount = pendingResultForPatient.getPatientRecordCountForCategory(resultCategory);

									resultDetailList = resultCatEntry.getValue();
									if (resultDetailList != null
											&& !resultDetailList.isEmpty()) {
										
				%>

				
				<div data-role="none" data-class="<%=patDtlStrForDisplay%>" style="display: none;position:relative">
						<div style="border: 1px solid #afb0b0;position:relative">

							<div class="prDetailedResultsExpandedContainer" style="overflow:hidden;position:relative">
								<div id="prDetailedResultsHeader" style="position: relative; float: left; display: block; width: 100%" data-fulldet="detResCompressCol<%=expUIMarker%>">
									<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
										<tr style="width: 100%;" class="prResultCategoryHeader prResultCategoryHeaderTheme">
											<td style='width: 3%' align="center" valign="middle">
												<div class="prCheckboxContainer">
													<input type="checkbox" id="checkb<%=expUIMarker%>" name="checkb<%=expUIMarker%>" onchange="selectPatientCategories('<%=expUIMarker%>')" value="<%=resultDetailList.size()%>" data-patient="<%=patientCounter%>" class="prCheckbox prCheckboxTheme">
												</div>
											</td>
											<td style='width: 80%' align='left'>
												<div class="prResultCategoryTextStyleTheme"><%=resultCategory.getCategory()%>
												</div>
											</td>
											<td style="width: 7%" align='left'>
											<input type="button" value="<%=resultDetailList.size()%>" class="prCountButtonTheme"> 
											</td>
											<td style='width: 10%' align='right'>
												<div class="prDetailedResultsToggleIcon" data-fulldet="detResHideCol<%=expUIMarker%>" onclick="DetailedResultExpand('<%=expUIMarker%>')">
													<img src="../images/ResultOpen.PNG" />
												</div>
											</td>
										</tr>
									</table>
								</div>
								<div style="position: relative; float: right; display: none; width: 0%;" class="drResultCategoryHeader drResultCategoryHeaderTheme" data-fulldet="detResExpandColHead<%=expUIMarker%>">
									<div class="drDetailedResultsToggleIcon" onclick="DetailedResultCompress('<%=expUIMarker%>')">
										<img src="../images/ResultClose.PNG" />
									</div>
								</div>
								<%
									String DetResScrollerheight = "height:325px;";
								%>

								<div id="wrapperNested<%=expUIMarker%>" class="wrapperNested" style="position:relative;width:100%;overflow:hidden;<% if(resultDetailList.size()>5){ %>height:325px; <%} %>">
									<div id="scrollerNested" class="scrollerNestedDiv" style="height:auto;width:100%;overflow:hidden">

								<%
									String eventName = null;
									final String REPORTEDBY = "Reported by";
									final String AT = "at";
									String practitioner = null;
									String reportedTime = null;
									StringBuffer resultBuff = new StringBuffer();
									String resultNum = "";
									String resultNumUom = "";
									String completeResult = "";
									String notesType = null;
									String normalLow = "";
									String normalHigh = "";
									String resultStr = "";
									int recordIndex = 0;

									String patient_Id = null;
									String eventClass = null;
									String eventGroup = null;
									String eventCode = null;
									String histRecType = null;
									String normalcyInd = null;
									// extra parameters needed for processing
									String sysId = null;
									String accessionNum = null;
									String createDateTime = null;
									String reviewType = null;
									String controlSysEventCode = null;
									String encounterId = null;

									// iterate through the records and show the results
									for (ResultDetail resultDetail : resultDetailList) {

										patient_Id = resultDetail.getPatientId();
										patient_Id = CommonBean.checkForNull(patient_Id);
										eventClass = resultDetail.getEventClass();
										eventClass = CommonBean.checkForNull(eventClass);
										eventGroup = resultDetail.getEventGroup();
										eventGroup = CommonBean.checkForNull(eventGroup);
										eventCode = resultDetail.getEventCode();
										eventCode = CommonBean.checkForNull(eventCode);
										histRecType = resultDetail.getHistoryRecType();
										normalcyInd = resultDetail.getNormalcyInd();
										normalcyInd = CommonBean.checkForNull(normalcyInd);

										sysId = resultDetail.getSysId();
										sysId = CommonBean.checkForNull(sysId);

										accessionNum = resultDetail.getAccessionNum();
										accessionNum = CommonBean.checkForNull(accessionNum);

										createDateTime = resultDetail.getCreateDateTime();
										createDateTime = CommonBean.checkForNull(createDateTime);
										createDateTime = DateUtils.convertDate(createDateTime, "DMYHM", "en", "en");

										reviewType = resultDetail.getReviewType();
										reviewType = CommonBean.checkForNull(reviewType);

										controlSysEventCode = resultDetail.getContrSysEventCode();
										controlSysEventCode = CommonBean.checkForNull(controlSysEventCode);

										encounterId = resultDetail.getEncounterId();
										encounterId = CommonBean.checkForNull(encounterId);

										// this code will form the result string 
										// which needs to be shown in the GUI
										resultBuff.delete(0, resultBuff.length());
										eventName = resultDetail.getEventName();
										practitioner = resultDetail.getReportedBy();
										reportedTime = resultDetail.getReportedAt();
										resultBuff.append(REPORTEDBY).append(" ");
										resultBuff.append(practitioner).append(" ");
										resultBuff.append(AT).append(" ");
										resultBuff.append(reportedTime);

										notesType = resultDetail.getNotesType();
										resultStr = resultDetail.getResultStr();
										resultNum = resultDetail.getResultNum();
										resultNumUom = resultDetail.getResultNumUom();
										normalLow = resultDetail.getNormalLow();
										normalHigh = resultDetail.getNormalHigh();
										if ("NUM".equalsIgnoreCase(notesType)) {
											completeResult = resultNum + "&nbsp;&nbsp;" + resultNumUom + "&nbsp;&nbsp;" + "(" + normalLow + "-"
													+ normalHigh + ")";
										} else if ("STR".equalsIgnoreCase(notesType)) {

										}

										StringBuffer detResUrl = new StringBuffer("PreviousResultsData-newUI.jsp");
										detResUrl.append("?hdnSelectedPeriod=");
										detResUrl.append(fromPeriod);
										detResUrl.append("&hdnFromPeriod=");
										detResUrl.append(fromPeriod);
										detResUrl.append("&hdnToPeriod=");
										detResUrl.append(toPeriod);
										detResUrl.append("&hdnSearchClicked=");
										detResUrl.append(searchClicked);
										detResUrl.append("&hdnNormalcyVal=");
										detResUrl.append(normalcy);
										detResUrl.append("&hdnCANormalcyInd=");
										detResUrl.append(normalcy);
										detResUrl.append("&hdnPatient_Id=");
										detResUrl.append(patient_Id);
										detResUrl.append("&hdnGroupby=");
										detResUrl.append(groupby);
										detResUrl.append("&hdnGetTaskApplicability=");
										detResUrl.append(getTaskApplicability);
										detResUrl.append("&hdnPractDesc=");
										detResUrl.append("");
										detResUrl.append("&hdnPractCode=");
										detResUrl.append("");
										detResUrl.append("&hdnPatientid=");
										detResUrl.append(patient_Id);
										detResUrl.append("&hdnEventClass=");
										detResUrl.append(eventClass);
										detResUrl.append("&hdnEventCode=");
										detResUrl.append(eventCode);
										detResUrl.append("&hdnEventGroup=");
										detResUrl.append(eventGroup);
										detResUrl.append("&hdnHistRectType=");
										detResUrl.append(histRecType);
										detResUrl.append("&hdnNormalcyIndicator=");
										detResUrl.append(normalcyInd);
										detResUrl.append("&hdnEpisodeId=");
										detResUrl.append(encounterId);
										detResUrl.append("&hdnPatClass=");
										detResUrl.append("IP");
								%>
								<input type="hidden" name="hdnPatientId<%=recordCounter%>" id="hdnPatientId<%=recordCounter%>" id="hdnPatientId<%=recordCounter%>" value="<%=patient_Id%>" />
								<input type="hidden" name="hdnEventClass<%=recordCounter%>" id="hdnEventClass<%=recordCounter%>" id="hdnEventClass<%=recordCounter%>" value="<%=eventClass%>" />
								<input type="hidden" name="hdnEventCode<%=recordCounter%>" id="hdnEventCode<%=recordCounter%>" id="hdnEventCode<%=recordCounter%>" value="<%=eventCode%>" /> 
								<input type="hidden" name="hdnEventGroup<%=recordCounter%>" id="hdnEventGroup<%=recordCounter%>" id="hdnEventGroup<%=recordCounter%>" value="<%=eventGroup%>" />
								<input type="hidden" name="hdnHistRectType<%=recordCounter%>" id="hdnHistRectType<%=recordCounter%>" id="hdnHistRectType<%=recordCounter%>" value="<%=histRecType%>" />
								<input type="hidden" name="hdnNormalcyIndicator<%=recordCounter%>" id="hdnNormalcyIndicator<%=recordCounter%>" id="hdnNormalcyIndicator<%=recordCounter%>" value="<%=normalcyInd%>" /> 
								<input type="hidden" name="hdnControlSysId<%=recordCounter%>" id="hdnControlSysId<%=recordCounter%>" id="hdnControlSysId<%=recordCounter%>" value="<%=sysId%>" /> 
								<input type="hidden" name="hdnAccessionNum<%=recordCounter%>" id="hdnAccessionNum<%=recordCounter%>" id="hdnAccessionNum<%=recordCounter%>" value="<%=accessionNum%>" /> 
								<input type="hidden" name="hdnReviewRemarks<%=recordCounter%>" id="hdnReviewRemarks<%=recordCounter%>" id="hdnReviewRemarks<%=recordCounter%>" value="" /> 
								<input type="hidden" name="hdnReviewType<%=recordCounter%>" id="hdnReviewType<%=recordCounter%>" id="hdnReviewType<%=recordCounter%>" value="<%=reviewType%>" />
								<input type="hidden" name="hdnCreationDateTime<%=recordCounter%>" id="hdnCreationDateTime<%=recordCounter%>" id="hdnCreationDateTime<%=recordCounter%>" value="<%=createDateTime%>" /> 
								<input type="hidden" name="hdnControlSysEventCode<%=recordCounter%>" id="hdnControlSysEventCode<%=recordCounter%>" id="hdnControlSysEventCode<%=recordCounter%>" value="<%=controlSysEventCode%>" /> 
								<input type="hidden" name="hdnEncounterId<%=recordCounter%>" id="hdnEncounterId<%=recordCounter%>" id="hdnEncounterId<%=recordCounter%>" value="<%=encounterId%>" />
								<input type="hidden" name="hdnDetailedResUrl<%=recordCounter%>" id="hdnDetailedResUrl<%=recordCounter%>" id="hdnDetailedResUrl<%=recordCounter%>" value="<%=detResUrl%>" />


								<div class="prDetailedResultsStrip prDetailedResultsStripTheme" data-role="none" data-class="<%=resultCategory.getCategory()%>" style="display: block; position: relative; float: left; width: 100%" data-childrows="<%=resultCategory.getCategory()%>" data-fulldet="detResCompressCol<%=expUIMarker%>" data-indvdet="detResCompressCol<%=recordCounter%>">
									<table style='width: 100%; height: 100%' border='0'
										cellspacing='0' cellpadding='0'>
										<tr style='width: 100%; height: 100%'>
											<td style='width: 3%'>
												<div class="prCheckboxContainer">
													<input type="checkbox" class="prCheckboxTheme" id='check<%=recordCounter%>' name='check<%=recordCounter%>' value="check" data-patient="<%=patientCounter%>" data-patientcat="<%=expUIMarker%>" />
												</div>
											</td>
											<td style='width: 3%' class="prDetailedResultsNormalcy" valign="middle">
												<%
													if (normalcyInd.equals("") || normalcyInd.equals("Z") || normalcyInd.equals("S")) {
												%>
												<div></div> <%
 													} else if (normalcyInd.equals("A")) {
												 %>
												<div class="prNormalcyAbnormalTheme"></div> <%
												 	} else if (normalcyInd.equals("C")) {
												 %>
												<div class="prNormalcyCriticalTheme"></div> <%
												 	} else if (normalcyInd.equals("N")) {
												 %>
												<div class="prNormalcyNormalTheme"></div> <%
												 	}
 												%>
											</td>
											<td style="width: 80%" align="left">
												<table style='width: 100%; height: 100%' border='0' cellspacing='0' cellpadding='0'>
													<tr>
														<td width="100%">
															<div class="prDetailedResultsTextStyle1Theme"><%=eventName%></div>
															<div class="prDetailedResultsTextStyle2Theme"><%=resultBuff.toString()%></div>
														</td>
													</tr>
													<%-- <tr>
                      								<td width="100%">
                      								<span class="resultStyle">
                      								<%=completeResult%>
                      								</span>
                      								</td>
                      							</tr> --%>
												</table>
											</td>
											<td style="width: 5%" align="center">
												<%
													// TODO
													// need to get the count of previous results
													PreviousResultsRequest previousResultsRequest = new PreviousResultsRequest();
													previousResultsRequest.setRequest(request);
													previousResultsRequest.setSession(session);
													previousResultsRequest.setPatientId(patient_Id);
													previousResultsRequest.setLocale(IPADConstants.LOCALE);
													previousResultsRequest.setEventClass(eventClass);
													previousResultsRequest.setEventCode(eventCode);
													previousResultsRequest.setEventGroup(eventGroup);
													previousResultsRequest.setHistRectType(histRecType);
													previousResultsRequest.setMaskDates(true);

													PrevResultCountResponse prevResultCountResponse = beanInst.getPreviousResultsCount(previousResultsRequest);
													List<PrevResultDateContainer> previousResultsCountList = prevResultCountResponse.getPrevResultDateContainerList();
													if (previousResultsCountList != null && !previousResultsCountList.isEmpty()) {
												%>
												<div onclick="DetailedIndvResultExpand('<%=recordCounter%>')" data-fulldet="detResHideCol<%=expUIMarker%>" data-indvdet="detResArrowCol<%=recordCounter%>">
													<img src="../images/Right_Arrow.png"></img>
												</div>
												<div onclick="DetailedIndvResultCompress('<%=recordCounter%>','<%=expUIMarker%>')" data-fulldet="detResCloseCol<%=expUIMarker%>" data-indvdet="detResCloseCol<%=recordCounter%>" style="display: none">
													<img src="../images/CloseDark.png"></img>
												</div> 
												<%
												 	}
												 %>
											</td>
										</tr>
									</table>



								</div>
								<div class="drExpandableColsTheme prevResWrapperDiv"
									style="position: relative; float: right; display: none; width: 0%; height: 63px; background-color: #143E4F; border-bottom: 1px solid #C7CFD2; border-top: 1px solid #FFFFFF;"
									data-fulldet="detResExpandCol<%=expUIMarker%>"
									data-indvdet="detResExpandCol<%=recordCounter%>" id="wrapper<%=recordCounter%>">
									<%-- <iframe  frameborder="0" style = "display:block;" scrolling ="no" height = "63px" width = "100%" src="<%=detResUrl%>"></iframe> --%>

									<div id="prevResScroller<%=recordCounter%>" class="prevResScrollerDiv" data-patnum="<%=recordCounter%>">


									</div>
								</div>


								<%
									recordIndex++;
															// this is a global counter
															recordCounter++;
														}
								%>
								
								</div> </div> <!-- </div> -->
							</div>
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
				<div class="legendToggler legendTogglerTheme" onclick="toggleLegend()">
					<img src="../images/LegendIcon.png" style="padding:10px 10px 10px 22px;" />
				</div>
				<div class="legendContainer" id="legendContainer">
					<table class="tblegends tblegendsTheme" border="0" cellpadding="" cellspacing="">
						<tr style="width: 100%; height: 100%;">
							<td style="width: 20px; height: 100%; padding-left: 5px;">
								<div class="prNormalcyCriticalTheme"></div>
							</td>
							<td style="width: auto; height: 100%;" class="legendTextFooterTheme">Critical</td>
							<td style="width: 20px; height: 100%; padding-left: 5px;">
								<div class="prNormalcyAbnormalTheme"></div>
							</td>
							<td style="width: auto; height: 100%;" class="legendTextFooterTheme">Abnormal</td>
							<td style="width: 20px; height: 100%; padding-left: 5px;">
								<div class="prNormalcyNormalTheme"></div>
							</td>
							<td style="width: auto; height: 100%">Normal</td>
							<td style="width: 40%; height: 100%"></td>
						</tr>
					</table>
				</div>
			</div>

			<input type="hidden" id="hdnPatientCounter" name="hdnPatientCounter" id="hdnPatientCounter" value="<%=patientCounter%>" /> 
			<input type="hidden" name="hdnFromPeriod" id="hdnFromPeriod" id="hdnFromPeriod" value="<%=fromPeriod%>" />
			<input type="hidden" name="hdnToPeriod" id="hdnToPeriod" id="hdnToPeriod" value="<%=toPeriod%>" /> 
			<input type="hidden" name="hdnNormalcyVal" id="hdnNormalcyVal" id="hdnNormalcyVal" value="<%=normalcy%>" /> 
			<input type="hidden" name="hdnPatientId" id="hdnPatientId" id="hdnPatientId" value="<%=patientId%>" /> 
			<input type="hidden" name="hdnSearchClicked" id="hdnSearchClicked" id="hdnSearchClicked" value="<%=searchClicked%>" /> <input type="hidden" name="hdnGroupby" id="hdnGroupby" id="hdnGroupby" value="<%=groupby%>" /> 
			<input type="hidden" name="hdnCANormalcyInd" id="hdnCANormalcyInd" id="hdnCANormalcyInd" value="<%=normalcy%>" />
			<input type="hidden" name="hdnGetTaskApplicability" id="hdnGetTaskApplicability" id="hdnGetTaskApplicability" value="<%=getTaskApplicability%>" /> 
			<input type="hidden" name="hdnSelectedPeriod" id="hdnSelectedPeriod" id="hdnSelectedPeriod" value="<%=selectedPeriod%>" /> 
			<input type="hidden" ame="hdnPractDesc" id="hdnPractDesc" value="" /> 
			<input type="hidden" name="hdnPractCode" id="hdnPractCode" id="hdnPractCode" value="" /> 
			<input type="hidden" name="hdnCompleteReviewClicked" id="hdnCompleteReviewClicked" id="hdnCompleteReviewClicked" value="<%=completeReviewClicked%>" />
			<input type="hidden" name="hdnForwardReviewClicked" id="hdnForwardReviewClicked" id="hdnForwardReviewClicked" value="<%=forwardReviewClicked%>" /> 
			<input type="hidden" name="hdnSelectedRows" id="hdnSelectedRows" id="hdnSelectedRows" value="" />


		</form>

		<!-- 	 <div data-role="none" id='Dialog' style="width:100%; height:auto;display:none;background:#ffffff;">
    	 <iframe src = "" width = "100%" height = "1000px" scrolling = "yes" id="srchFrame" frameborder="0"></iframe>  
	 </div> -->

	</div>


</body>
</html>

