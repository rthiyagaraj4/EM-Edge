
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<%
	request.setCharacterEncoding("UTF-8");
	InPatientContext oInPatientContext = new InPatientContext();
	oInPatientContext.setRequest(request);
	String facility_id= ""; //(String)session.getValue("facility_id");
	String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
	String sPatientId = "" ;
	String sNursingUnitCode = "";
	String sNursingUnit = "";
	String sClinicianDesc = "";
	String sSpecialityCode = "";
	String sSpeciality = "";
	String sOrderBy = "";
	String sFacilityId = "";
	String sPractionerId = "";
	String sPractionerDesc = "";
	if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
	{
		facility_id = (String)session.getValue("facility_id");
		oInPatientContext.setFacilityId(facility_id);
	}
	
	if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
	{
		clinicianId = (String)session.getValue("ca_practitioner_id");
		oInPatientContext.setClinicianId(clinicianId);
	}
	
	String className = "dvLegendNotRequired";
	StringTokenizer st = null;
	String deceasedYn = "";
	int noofchildren = 0;
	String relationYn = "";
	String tempDischargeDate = "";
	String strPatientDetails = "";
	
	
	if(request.getParameter("hdnPatientId") != null && request.getParameter("hdnPatientId") != "" && request.getParameter("hdnPatientId") != " ")
	{
	 
		sPatientId = ((String)request.getParameter("hdnPatientId")).trim();
		oInPatientContext.setPatientId(sPatientId);
	 
	}
	
	if(request.getParameter("hdnNursingUnit") != null && request.getParameter("hdnNursingUnit") != "" && request.getParameter("hdnNursingUnit") != " ")
	{
	  
	 sNursingUnitCode = (String)request.getParameter("hdnNursingUnit");
	 oInPatientContext.setNursingUnitCode(sNursingUnitCode);
	}
	if(request.getParameter("hdnClinicianId") != null && request.getParameter("hdnClinicianId") != "" && request.getParameter("hdnClinicianId") != " ")
	{
	
	 sPractionerId = (String)request.getParameter("hdnClinicianId");
	 oInPatientContext.setPractionerId(sPractionerId);
	 
	}
	if(request.getParameter("hdnSpeciality") != null && request.getParameter("hdnSpeciality") != "" && request.getParameter("hdnSpeciality") != " ")
	{
	
	 sSpecialityCode = (String)request.getParameter("hdnSpeciality");
	 oInPatientContext.setSpecialityCode(sSpecialityCode);
	}
	
	if(request.getParameter("hdnOrderBy") != null &&  request.getParameter("hdnOrderBy") != "")
	{
		
		sOrderBy = (String)request.getParameter("hdnOrderBy");
		oInPatientContext.setOrderBy(sOrderBy);
	}
	
	
	if(request.getParameter("txtPracId") != null &&  request.getParameter("txtPracId") != "")
	{
		
		sPractionerDesc = (String)request.getParameter("txtPracId");
		oInPatientContext.setPractionerDesc(sPractionerDesc);
	}
	
	if(request.getParameter("txtNursingUnit") != null &&  request.getParameter("txtNursingUnit") != "")
	{
		
		sNursingUnit = (String)request.getParameter("txtNursingUnit");
		oInPatientContext.setNursingUnit(sNursingUnit);
		
	}
	if(request.getParameter("txtSpeciality") != null &&  request.getParameter("txtSpeciality") != "")
	{
		
		sSpeciality = (String)request.getParameter("txtSpeciality");
		oInPatientContext.setSpeciality(sSpeciality);
		
	}
	

%>
<!DOCTYPE html> 
<html> 
<head> 
<title>IP View</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> -->


<link rel="stylesheet" href="../css/iPadNew_IP.css" />  
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<link rel="stylesheet" href="../css/iPADNew.css" />  
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

<!--   -->
<script type="application/javascript" src="../js/iscroll.js"></script>


<script type="text/javascript">
//variables for setting the content frame height according to the device
//below values are header footer heights
var header_borderheight= 90;
var content_height;

var scrollContent1 ;
var scrollNav;

function loaded1() {
	//scrollContent1 = new iScroll('divcnt');
	//scrollNav = new iScroll('contentWrapper2');
	setTimeout(function () {
		scrollContent1 = new iScroll('divcnt');
	}, 100);
	}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', loaded1, false);


 $(document).ready(function () {
	 parent.setIframeHeight();
	var currentOrderBy = document.getElementById("hdnOrderBy").value;
    if(currentOrderBy == "" || currentOrderBy == "OR")
    	$('#orderByNone').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    else if(currentOrderBy == "patient_name")
    	$('#orderByPatientName').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    else if(currentOrderBy == "physician_name")
    	$('#orderByPhysicianName').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    else if(currentOrderBy == "bed_num")
    	$('#orderByBedNum').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    
    //submitting form when space or enter key is pressed in the patient id text box
    $('#txtPatientId').bind('keypress', function(e) {
        if (e.which == 32){//space bar
            //alert('space');
        	ipFormSubmit();
        }
        if (e.which == 13){//enter key
            //alert('enter');
        	ipFormSubmit();
        }
        
	});
    //-----scroll--------------
    /*
    var scrollContent1;
    window.addEventListener('DOMContentLoaded', loaded1, false);
    document.addEventListener('DOMContentLoaded', loaded1, false);
    scrollContent1 = new iScroll('divcnt');
    function loaded1() {
    	//scrollContent1 = new iScroll('divcnt');
    	//scrollNav = new iScroll('contentWrapper2');
    	setTimeout(function () {
    		scrollContent1 = new iScroll('divcnt');
    	}, 100);
    	}
    */
    //------scroll----------
    //sfsrelated code below
    $("#btnsfs").bind('touchstart', function(event) { 
        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get 'touches' 
        var e = event.originalEvent; 
      //  alert(e.touches[0].pageY)
       // alert($(this).scrollTop() );
        var scrollStartPos =  e.touches[0].pageY;
      //  alert(e.touches[0].pageX);
       //// alert(scrollStartPos);
        scrollStartPos = scrollStartPos ;
       //// $("#sfsarrow").css('top',scrollStartPos);
       // scrollStartPos = scrollStartPos + "30";
      //  alert(scrollStartPos)
      //  $("#sfs").css('top',scrollStartPos)
        var tleft = e.touches[0].pageX - "15"
       // alert(tleft);
      //   $("#sfsarrow").css('left', tleft);
      //  $("#sfs").css('top', scrollStartPos);
      //  alert(scrollStartPos);
       // scrollLast = event.touches[0].pageY;
         $("#sfs").css('z-index', "1000");
         $("#sfsarrow").css('z-index',"1000");
     //   $('#divscr').html ("scroostartpos111=" + scrollStartPos );
       // e.preventDefault(); 
    }); 
 });
 

 
 
 function changeOrientation(orient, HFheight)
 {
 	content_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight;
	document.getElementById("divcnt").style.height = content_height+"px";
	
	if(scrollContent1 != null)
	scrollContent1.refresh();
 }

 function clearPatientIdText()
 {
	 document.getElementById("txtPatientId").value="";
	 document.getElementById("hdnPatientId").value ="";
 }
 function toggleLegend(){
	 $('#legendContainer').toggle();
 }
 function openPatient(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)
 {
	
	 //window.parent.slidee("true");
	
	//alert(patientid);
	//alert("hi");
	//alert(episodeId);
	window.parent.loadwidgets(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode);
	//document.getElementById("IpForm").submit();
	//window.open("Appointment.html");
 }
 function show(objBtn)
 {
	  //alert("hiii");
	    var myBars = 'directories=no,location=no,menubar=no,status=no' ;
		var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
		//var myFeatures = myBars + ', ' + myOptions ;
		var myFeatures =  myOptions ;
		//var ecisWindow = open( 'iPadWidget.html', 'iPadWidget.html', myFeatures,false ) ;
		
		//var retval = window.showModalDialog("AppView.jsp", "", myFeatures);
		//$.mobile.changePage('#Dialog',{role:'dialog'})
		//$.mobile.changePage('#Dialog',{role:'dialog',transition: "pop"})
	//	document.getElementById("srchFrame").src = "appview.html";
    //   $.mobile.changePage("#Dialog", "slide" , false,false);
		//alert("finished");
		objBtn.style.border = "3px solid #48d1d8";
		document.getElementById("hdnPatientId").value = document.getElementById("txtPatientId").value;
		 document.getElementById("hdnNursingUnit").value = "";
		 document.getElementById("hdnClinicianId").value = "";
		 document.getElementById("hdnSpeciality").value = "";
		//document.getElementById("hdnClinicianId").value = document.getElementById("txtPracId").value;
		//document.getElementById("hdnNursingUnit").value = document.getElementById("txtNursingUnit").value;
		//document.getElementById("hdnSpeciality").value = document.getElementById("txtSpeciality").value;
		document.getElementById("IpForm").submit();


 }

 function ipFormSubmit()
 {
	 //$.trim($("#hdnPatientId").val($.trim($("#txtPatientId").val())));
	 //alert(document.getElementById("txtPatientId").value.length);
	 //var trimmedPatId= document.getElementById("txtPatientId").value.trim();
	 //alert(trimmedPatId.length);
	 document.getElementById("hdnPatientId").value = document.getElementById("txtPatientId").value;
	 document.getElementById("IpForm").submit();
 }


 function fnOrderBy(orderByVal)
 {
	//alert(orderByVal);
	 document.getElementById("hdnOrderBy").value = orderByVal;
	 document.getElementById("IpForm").submit();
 }

 function showsfs()
 {
 	//document.getElementById("sfs").style.display = "none";
 	//var e = event.originalEvent; 
 	//alert( $(obj).scrollTop());
 	//alert(e.touches[0].pageY);
 	document.getElementById("sfsFrame").src = "IPSearch-newUI.jsp";
 	$("#sfs").css('z-index', "1000");
 	$("#sfsarrow").css('z-index',"1000");
 	$('#sfs').toggle();
 	$('#sfsarrow').toggle();
 	//document.getElementById("frame1").src = "popup1.html";
 	//window.parent.show();
 }


 
 function refresh(){
	 document.getElementById("hdnOrderBy").value = "";
	 document.getElementById("hdnPatientId").value = "";
	 document.getElementById("hdnNursingUnit").value = "";
	 document.getElementById("hdnClinicianId").value = "";
	 document.getElementById("hdnSpeciality").value = "";
	 document.getElementById("IpForm").submit();
 }

 function slidesfsSearch(patientID){

	 /* alert(patientID); */
	 document.getElementById("hdnPatientId").value = patientID;
	 document.getElementById("hdnNursingUnit").value = "";
	 document.getElementById("hdnClinicianId").value = "";
	 document.getElementById("hdnSpeciality").value = "";
	 document.getElementById("IpForm").submit();
 }
 
 function hideRows(arrSP,arrPR,arrNU){
	
	 var totalCount = arrSP.length + arrPR.length + arrNU.length ;
	 var trackcount=0;
	 var multipleCrit = false; 
	 if(arrSP.length>0)
		 trackcount++;
	 if(arrPR.length>0)
		 trackcount++;
	 if(arrNU.length>0)
		 trackcount++;
	 if(trackcount>1)
		 multipleCrit = true;
	 
	 if(!multipleCrit){
		 
	 }
	 rows = $("#divcnt").find(".tbIpRow").hide();
	 //Selecting for the first criteria
	 if(arrSP.length>0){
		 for( var j =0;j<arrSP.length;j++){
			var code = arrSP[j];
			$("[data-spec = '"+code+"']").each(function (i,v ){
				$(this).show();
				scrollContent1.refresh();
			});
		}
	 }
	 else if(arrPR.length>0){
		 for( var j =0;j<arrPR.length;j++){
				var code = arrPR[j];
				$("[data-pract = '"+code+"']").each(function (i,v ){
					$(this).show();
					scrollContent1.refresh();
				});
		  }
	 }
	 else if(arrNU.length>0){
		 for( var j =0;j<arrNU.length;j++){
				var code = arrNU[j];
				$("[data-nursingunit = '"+code+"']").each(function (i,v ){
					$(this).show();
					scrollContent1.refresh();
				});
		  }
	 }
	 
	 //selecting other criterion
	 if(multipleCrit){
		 if(arrPR.length>0){
			 $(".tbIpRow:visible").each(function (i,v){
				 var thispr = $(this).data("pract");
				 if(arrPR.indexOf(thispr)==-1){
					 $(this).hide();
					 scrollContent1.refresh();
				 }
			 });
		 }
		 if(arrNU.length>0){
			 $(".tbIpRow:visible").each(function (i,v){
				 var thisnu = $(this).data("nursingunit");
				 if(arrNU.indexOf(thisnu)==-1){
					 $(this).hide();
					 scrollContent1.refresh();
				 }
			 });
		 }
	 }
	 //deselecting first criteria
	 if(totalCount==0){
		rows = $("#divcnt").find(".tbIpRow").show();
		 }
	 
	 
 }
 
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body style= "width:100%; height:100%;"  >

	<div id = "sfsarrow" data-role = "none" class = "sfs-bubble-arrow sfs-bubble-arrowIPTheme" ></div>
   	<div data-role = "none" class = "sfs sfsIPTheme"  id = "sfs" >
  	 	<iframe id = "sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" height = "300px" width = "340px" src = "IPSearch-newUI.jsp"></iframe>  
   	</div> 
	<div data-role = "page" class="ipListParent" style = "padding:0px;width:100%;height:100%;">
		<form name='IpForm' id='IpForm' method='post' id="IpForm" style = "width:100%;height:100%;">
			<div class ="ipHeader">
				<div class="ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme">
					<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
						<tr style = "height:100%;width:100%">
							<td style = "width:50px; padding-left:5px;">
			        			<div class = "WidgetButtonTheme" onclick="parent.toggleMenu()"><img src = "../images/MenuIcon.png"/></div>
			   				</td>
			    			<td style = "width:auto">
			         			<div class = "ipHeaderPageTitle ipHeaderPageTitleTheme"> In Patient</div>
			   				</td>
					   		<%-- <td style = "width:200px">
					         		<div class="ipHeaderSearchPatientText ipHeaderSearchPatientTextTheme">
					         		<table cellpadding = "0" cellspacing = "0" border = "0"><tr>
								   	<td style="width:5%; padding-top:5px"><img src="../images/Search.png" onclick="show(this)" style="margin-left:5px;"/></td>
								    <td style="width:90%;">
								        	<input type="text" name = "txtPatientId" id = "txtPatientId"  placeholder="Patient ID" onchange="show(this)" class="ipHeaderSearchPatientTxtBox ipHeaderSearchPatientTxtBoxTheme" value = "<%=oInPatientContext.getPatientId() %>">
								    </td>
								   	<td style="width:5%; padding-top:5px;padding-right:6px"><img src="../images/Close-small.png" style="padding-right: 10px" onclick="clearPatientIdText()"/></td>
								   	</tr></table>
								   	</div>
					   		</td>
							<td style = "width:50px; padding-left:5px;padding-right:5px;text-align:right" onclick="showsfs()">
					        	<div class = "WidgetButtonTheme" id="btnsfs" ><img src = "../images/Search.png" style="padding-top:5px;"/></div>
					   		</td> --%>
						</tr>
		    		</table>
				</div>

	  			<div class = "ipHeaderMenuContainer2">
	  				<div  data-role ="none" class ="ipContentHolderHeader ipContentHolderHeaderTheme">
						<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  				<tr style = "height:100%;width:100%">
							    <td style = "width:10%">
							         <span class = "ipContentHolderRefreshIcon"><img src = "../images/Refresh_black.png" onclick="refresh()"/></span>
							    </td>
							    <td></td>
							    <td style = "width:50%;padding-right:10px;" align = "right" valign = "center">
							    	<table class= "ipContentHolderIconContainer WidgetFilterContTheme" cellpadding = "0" cellspacing = "0" border = "0">
									    <tr>
											<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('OR')" id="orderByNone"><img src = "../images/view01.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('bed_num')" id="orderByBedNum"><img src = "../images/ByBed.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('patient_name')" id="orderByPatientName"><img src = "../images/ByPatient.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('physician_name')" id="orderByPhysicianName"><img src = "../images/View03.png" style="vertical-align: middle;"/></td>
								        </tr>
						        	</table>	
						    	</td>
			 				</tr>
		    			</table>	  
	  				</div>
	  			</div>
	  		</div>
    		<div id = "divcnt"  class = "divIPcontent divIPcontentTheme" style="overflow:hidden">
				<div style = "width:100%;height:auto;overflow:auto" >
				  <%
				  int nClassCount = 1;
				  int cnt = 0;
				  String Status = "";
				  String emergencyYn = "";
				  String n = null;
				  
				  InPatientList bean = new InPatientList();
				  List<InPatients> objInPatientList = new ArrayList<InPatients>(); 
				  int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
				  int nCssCount = 1;  // To display alternate Row Color.
				 
				  int nListSize = 0;
			
				  int nLoopCount = 0;
				  InPatients oInPatients = null;
				  try {
					  objInPatientList = bean.getInPatientLis(oInPatientContext);
					  if(objInPatientList != null)
					  {
					       nListSize =  objInPatientList .size();
					       
					  }
					 if(nListSize > 0)
					 {
					   for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
						{
					 
						   oInPatients = objInPatientList.get(nLoopCount); 
						   if(oInPatients != null)
						   {
					        Status = oInPatients.sStatus;
					        st = new StringTokenizer(Status,"|");
							  while (st.hasMoreTokens())
								{
									emergencyYn = st.nextToken();
									deceasedYn = st.nextToken();
									n = st.nextToken();
									if(!(n == null || n.equals("")))
										noofchildren = Integer.parseInt(n);
									relationYn = st.nextToken();
								}
					  
							  if(oInPatients.sDischargeDateTime != null)
							  {
									if( !oInPatients.sDischargeDateTime.equals(""))
										className = "dvLegendDischargedTheme";
							  }
							  
								
								if(deceasedYn.equals("D"))
								{
									className = "dvLegendDeceasedTheme";
									
								}
								if(noofchildren > 0) 
									className = "dvLegendNewBornTheme";
								
								if(relationYn.equals("N"))
								{
									className = "dvLegendNoRelationTheme";
								}
								
								 deceasedYn = "";
								 noofchildren = 0;
								 relationYn = "";
								 tempDischargeDate = "";
				  %>
 
   					<table class = "IPContentTable IPContentTableTheme tbIpRow" data-spec="<%=oInPatients.sSpecialityCode %>" data-pract="<%=oInPatients.sPhysicianName %>" data-nursingunit="<%=oInPatients.locationCode %>" cellpadding = "0" cellspacing = "0"  border = "0" onclick = "openPatient('<%=oInPatients.sPatientId%>' , '<%=oInPatients.sEpisodeId%>','<%=oInPatients.sAdmDateTime%>','<%=oInPatients.sDischargeDateTime%>','<%=oInPatients.locationType%>','<%=oInPatients.locationCode%>','<%=oInPatients.serviceCode%>')">
        				<tr class="trIpRows" id="patientDetailRow"  >
           					<td class="tdLegendCol" align="center" valign = "center" style = "width:5%">
              					<div class = "<%=className %>" ></div>
           					</td>
           					<td style = "width:5%" align="center" valign = "center" >
           					<div class = "imgPhoto imgPhotoTheme">
             					<img width="55" height="55" src="${path}/mobile/PatientImageServlet?PatientId=<%=oInPatients.sPatientId%>" class="PatImgTagTheme"></img>
             					</div>
           					</td>
           					<td style="width:85%">
					             <table style = "width:100%" border = "0" cellpadding = "0" cellspacing = "0">
									<tr class="trIpChildRows">
					                	<td style="width:100%;word-break:break-all" colspan = "2" >
					                        <%  
					                        // strPatientDetails = out.println(rs.getString("patient_name") )+ " " + out.println(rs.getString("sex"),rs.getString("age")) + " " + out.println(rs.getString("patient_id"));
					                        strPatientDetails = oInPatients.sPatientName + ", " + oInPatients.sPatientId + ", " + oInPatients.sGender + " ";
					                         
					                         %>
					                          <div class = "txtRows txtRowsTheme" > <%=strPatientDetails %></div>
					                    </td>
					                </tr>
               						<tr class="trIpChildRows">
				                         <td style="width:100%;word-break:break-all" colspan = "2">
				                          <span class="lz-list-label lz-list-labelTheme">Practitioner :</span><span class="lz-list-data1 lz-list-data1Theme"><%=oInPatients.sPhysicianName%></span>
				                         </td>
                         
                					</tr>
					                <tr class="trIpChildRows">
					                    <td style="width:100%;word-break:break-all" >
					                     <span class="lz-list-label lz-list-labelTheme">Room,Bed No :</span><span class="lz-list-data1 lz-list-data1Theme">
					                     <%=oInPatients.sRoomNo%>, <%=oInPatients.sBedNo%><span class="lz-list-data2 lz-list-data2Theme"> On <%=oInPatients.sAdmDateTime%></span></span>  
					                   </td>
					                </tr>
					             </table>
           					</td>
				           	<td style = "width:5%" align = "center" valign = "center">
				             	<img src="../images/Right_Arrow.png"  class="ipListArrowImage"/>
				           	</td>
				           	
        				</tr>
   					</table>   
					   <%
							   }
					   className = "dvLegendNotRequired";
					     nRowCount = nRowCount + 1;
						  if(nCssCount==1)
						  {
							   nCssCount = nCssCount +1;
						  }
						  else
						  {
							  nCssCount = nCssCount -1;
						  }	 
					   }//for
					 
						 }//if listsize 
						 else
						 {
							 %>
							  
							   <span class="ipSearchResultsEmptyTheme"><%= IPADConstants.NORECORDS_HTML%></span>
							 <% 
						 }
					  %>
   				</div>
       			<div class="legendToggler legendTogglerTheme" onclick="toggleLegend()"><img src = "../images/LegendIcon.png" style="padding:10px 10px 10px 22px;"/></div>
   				<div class ="legendContainer" id = "legendContainer">
		    		<table class = "tblegends tblegendsTheme" border = "0" cellpadding = "0" cellspacing = "0" >
						<tr style = "width:100%;height:100%;">
						  	<td style = "width:20px;height:100%;padding-left: 5px;"> 
						  		<div class = "dvLegendDischargedTheme"></div>
						 	</td>
						  	<td style = "width:auto;height:100%;" class="legendTextFooterTheme"> 
						  		Discharged
						  	</td>
						  	<td style = "width:20px;height:100%;padding-left: 5px;"> 
						  		<div class = "dvLegendDeceasedTheme"></div>
						  	</td>
						  	<td style = "width:auto;height:100%;" class="legendTextFooterTheme"> 
						  		Deceased
						  	</td>
						  	<td style = "width:20px;height:100%;padding-left: 5px;"> 
						  		<div class = "dvLegendNewBornTheme"></div>
						  	</td>
						  	<td style = "width:auto;height:100%" class="legendTextFooterTheme"> 
						  		Newborn Exist
						  	</td>
						  	<td style = "width:20px;height:100%;padding-left: 5px;"> 
						  		<div class = "dvLegendNoRelationTheme"></div>
						  	</td>
						  	<td style = "width:auto;height:100%" class=""> 
						  		No PP Relationship
						  	</td>
						  	<td style = "width:40px;height:100%"> 
						  	</td>
						</tr>
					</table>
		 		</div>
   
   				
   			</div>

    				
			<input type = "hidden" name ="hdnPatientId" id ="hdnPatientId" value = "<%=oInPatientContext.getPatientId()%>"/>
			<input type = "hidden" name ="hdnNursingUnit" id ="hdnNursingUnit" value = "<%=oInPatientContext.getNursingUnitCode() %>"/>
			<input type = "hidden" name ="hdnClinicianId" id ="hdnClinicianId" value = "<%=oInPatientContext.getPractionerId() %>"/>
			<input type = "hidden" name ="hdnSpeciality" id ="hdnSpeciality" value = "<%=oInPatientContext.getSpecialityCode() %>"/>
			<input type = "hidden" name ="hdnOrderBy" id ="hdnOrderBy" value = "<%=oInPatientContext.getOrderBy() %>"/>
		</form> 


  
	  <%
	}catch ( Exception e ){
		out.println("Exception " + e);
		e.printStackTrace();
	}
	finally{
	
	}
	%>
	</div>
</body>
</html>

