
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
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
 
	sPatientId = (String)request.getParameter("hdnPatientId");
	oInPatientContext.setPatientId(sPatientId);
 
}

if(request.getParameter("hdnNursingUnit") != null && request.getParameter("hdnNursingUnit") != "" && request.getParameter("hdnNursingUnit") != " ")
{
  
 sNursingUnitCode = (String)request.getParameter("hdnNursingUnit");
// oInPatientContext.setClinicianDesc(sClinicianDesc);
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


//out.println(sqlStr.toString());





%>
<!DOCTYPE html> 
<html> 
<head> 
<title>IP View</title> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
 <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> 

<link rel="stylesheet" href="../css/ipad.css" />  
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

<script src="../jquery.mobile-1.0a4.1.min.js"></script> 
<script type="text/javascript">
/*
 $(document).bind("swipe", function(event, data){
	//alert("helloo")
	event.preventDefault();	
 });
 */
 var bShCriteria = true;
 function scrolTop()
 {
	  //alert("helloj");
	 window.parent.scrolTop();
 }
 function showCriteria()
 {
	 $('#divSrchCriteria').slideToggle('fast');
	 if(bShCriteria)
	   {
		        bShCriteria = false;
			   document.getElementById("imgCriteria").src = "../images/Heading-Panel-Up-Arrow.png" ;
	   }
	   else
	   {
		       bShCriteria = true;
			   document.getElementById("imgCriteria").src = "../images/Heading-Panel-down-Arrow.png";
	   }
 }
 $(document).ready(function () {
	 window.parent.HideLoadingMsg();
	/* 
	 $(document).scroll(function(){
		 alert("higip");
         if ($(window).scrollTop() + $(window).height() == $(document).height())
         {
             
            alert("hi");
         }
     });
*/
    if(document.getElementById("hdnOrderBy").value != "")
	 document.getElementById("cmbOrderBy").value = document.getElementById("hdnOrderBy").value;
 });
 function appendIP()
 {
	// alert("hihih");
	// $('#ulIP').append("<li class ='ui-btn-text-data1'  >   <a href='#' rel ='external' style = 'height:65px'> <ul style='list-style-type: none;' ><li class='firstleftUl'><img src='human.png'></img> </li></ul> </a></li>");
	// $('#ulIP').append("<li class ='ui-btn-text-data1'  >   <a href='#' rel ='external' style = 'height:65px'> <ul style='list-style-type: none;' ><li class='firstleftUl'><img src='human.png'></img> </li></ul> </a></li>");
	// $('#ulIP').append("<li class ='ui-btn-text-data1'  >   <a href='#' rel ='external' style = 'height:65px'> <ul style='list-style-type: none;' ><li class='firstleftUl'><img src='human.png'></img> </li></ul> </a></li>");
	// $('#divcnt').append("<ul><li class ='ui-btn-text-data1'  >   <a href='#' rel ='external' style = 'height:65px'> <ul style='list-style-type: none;' ><li class='firstleftUl'><img src='human.png'></img> </li></ul> </a></li></ul>");
	//$('#divcnt').append("<table><tr><td>ghgh</td></tr></table>");
	// $('#divcnt').append("<ul data-role='listview'><li class ='ui-btn-text-data1'  >   <a href='#' rel ='external' style = 'height:65px'> <ul style='list-style-type: none;' ><li class='firstleftUl'><img src='human.png'></img> </li></ul> </a></li></ul>");
 }
 function test()
 {
	 var i = 0;
	// alert("hihih");
	 for(i=0;i<20;i++)
		 {
	      // $('#divcnt').append("<ul data-role='listview'><li class ='ui-btn-text-data1'  >   <a href='#' rel ='external' style = 'height:65px'> <ul style='list-style-type: none;' ><li class='firstleftUl'><img src='human.png'></img> </li></ul> </a></li></ul>");
	 
        }
	 // $('#divcnt').append("<table style='height:100px;width:100%'><tr><td><span class='lz-list-label'>Naren</span></td><td><img src='human.png'></img> </td></tr></table>")
 }
 function openPatient(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)
 {
	
	 window.parent.slidee("true");
	
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
		//document.getElementById("hdnClinicianId").value = document.getElementById("txtPracId").value;
		//document.getElementById("hdnNursingUnit").value = document.getElementById("txtNursingUnit").value;
		//document.getElementById("hdnSpeciality").value = document.getElementById("txtSpeciality").value;
		document.getElementById("IpForm").submit();


 }
 function clearValues()
 {
	 //alert("hiiii");
	    document.getElementById("hdnPatientId").value = "";
		document.getElementById("txtPatientId").value = "";
		document.getElementById("hdnClinicianId").value = "";
		document.getElementById("txtPracId").value = "";
		document.getElementById("hdnNursingUnit").value = ""; 
		document.getElementById("txtNursingUnit").value = "";
		document.getElementById("hdnSpeciality").value = "";
		document.getElementById("txtSpeciality").value = "";
 }
 function test(strCode,strDesc)
 {
	// alert("ip");
	 //$("#Dialog").dialog("close");
	 //$.mobile.changePage('#page1', "" , false,false);
	  
	  document.getElementById("txtNursingUnit").value = strDesc;
	  document.getElementById("hdnNursingUnit").value = strCode;
	  
	  
	  $("#IpForm").toggle("fast");
	  $("#Dialog").toggle("fast");
	  scrolTop();
	  document.getElementById("srchFrame").src = "";
 }
 function Practitioner(strCode,strDesc)
 {
	  document.getElementById("hdnClinicianId").value = strCode; 
	  document.getElementById("txtPracId").value  = strDesc;
	  $("#IpForm").toggle("fast");
	  $("#Dialog").toggle("fast");
	  scrolTop();
	  document.getElementById("srchFrame").src = "";
 }
 function Speciality(strCode,strDesc)
 {
	  document.getElementById("hdnSpeciality").value = strCode;
	  document.getElementById("txtSpeciality").value = strDesc;
	  $("#IpForm").toggle("fast");
	  $("#Dialog").toggle("fast");
	  scrolTop();
	  document.getElementById("srchFrame").src = "";
 }
 function showNursingUnit()
 {
	 
	
	// $.mobile.changePage("#Dialog", "slide" , false,false);
	 document.getElementById("srchFrame").src = "NursingUnit.jsp?PracId=" +  document.getElementById("hdnClinicianId").value;
	  $("#IpForm").toggle("fast");
	  $("#Dialog").toggle("fast");
	 
 }
 function showPractitioner()
 {
	 document.getElementById("srchFrame").src = "Practitioner.jsp";
	  $("#IpForm").toggle("fast");
	  $("#Dialog").toggle("fast");
	 
 }
 function showspeciality()
 {
	 document.getElementById("srchFrame").src = "specialitySFS.jsp";
	  $("#IpForm").toggle("fast");
	  $("#Dialog").toggle("fast");
	 
 }
 function CloseSearchCriteria()
 {
	 $("#IpForm").toggle("fast");
	  $("#Dialog").toggle("fast");
	  document.getElementById("srchFrame").src = "";
 }
 function fnOrderBy(objCmbOrderBy)
 {
	// alert(objCmbOrderBy.value);
	 document.getElementById("hdnOrderBy").value = objCmbOrderBy.value;
	 document.getElementById("IpForm").submit();
 }
 function LoadValues()
 {
	 
 }


 </script>
<body style= "width:100%" >
 <section id="page1" data-role="page"  style="padding:0px;width:100%"> 
  <form name='IpForm' id='IpForm' method='post' id="IpForm" style = "width:100%">
  <!--  <div style="width:100%;height:auto"></div> -->
	  <div id = "divSrch"  data-role ="none" class="dvApp" onclick = "showCriteria()">
		  <!--  <span class = "spanDvsrch">Search</span> -->
		 <!--    <img src = "Heading-Panel-down-Arrow.png" class = "imgg"></img>  -->
		 <table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  <tr style = "height:100%;width:100%">
			    <td style = "width:95%">
			         <span class = "spanDvsrch">Search</span>
			    </td>
			    <td style = "width:5%" align = "center" valign = "center">
			        <img src = "../images/Heading-Panel-down-Arrow.png" id = "imgCriteria"></img> 	
			    </td>
			    
			    
			  </tr>
		    </table>	  
		 
	  </div>
  
  <div class = "dvStroke" data-role ="none"></div> 

	  <div id="divSrchCriteria"  data-role ="none"  style = "display:none;height:auto;padding:0px" class = "dvCriteria">
	   
		   <table style="height:135px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
		
			     <tr style="height:30px;width:100%">
			      <td align = "left" style="width:33%"><span class = "spIpCriteria">Patient Id</span></td>
			      <td align = "left" style="width:33%"><span class = "spIpCriteria">Speciality</span></td>
			      <td align = "left" style="width:33%"><span class = "spIpCriteria">Nursing Unit</span></td>
			      <td style="width:1%">&nbsp;</td>
			     </tr>
			     <tr style="height:35px;width:100%">
			      <td align = "left" style="width:33%"><input type = textbox name = "txtPatientId" id = "txtPatientId"   data-role = "none" class = "tbPatCriteria" value = "<%=oInPatientContext.getPatientId() %>"/></td>
			      <td align = "left" style="width:33%"><input type = textbox data-role = "none" name = "txtSpeciality" id = "txtSpeciality" class = "tbCriteria" readonly = "true" onclick = "showspeciality()" value = "<%=oInPatientContext.getsSpeciality() %>"/></td>
			      <td align = "left" style="width:33%"><input type = textbox data-role = "none" name = "txtNursingUnit" id = "txtNursingUnit" class = "tbCriteria" readonly = "true" onclick = "showNursingUnit()" value = "<%=oInPatientContext.getNursingUnit() %>" /></td>
			        <td style="width:1%">&nbsp;</td>
			     </tr>
			     <tr style="height:30px;width:100%">
			      <td align = "left" style="width:33%"><span class = "spIpCriteria">Practitioner</span></td>
			      <td style="width:33%"></td>
			      <td style="width:33%"></td>
			       <td style="width:1%">&nbsp;</td>
			    
			     </tr>
			
			     <tr style="height:35px;width:100%">
			      <td align = "left" style="width:33%"><input type = textbox data-role = "none" name = "txtPracId"  id = "txtPracId" readonly = "true" class = "tbCriteria" onclick = "showPractitioner()" value = "<%=oInPatientContext.getPractionerDesc() %>" /></td>
			      <td style="width:33%">&nbsp;</td>
			      <td style="width:33%" nowrap = "false">
			        <!--   <input type ="button" name='search_btn' id='search_btn' value='Search' class="btnType1" data-role = "none" onclick = "show()"/><input type ="button" name='clear_btn' id='clear_btn' value='Clear' class="btnType1" data-role = "none"/>  -->
			      </td>
			       <td style="width:1%">&nbsp;</td>
			     </tr>
			     
			     <tr style="height:5px;width:100%">
			       <td>&nbsp;</td>
			     </tr>
		   </table>
	   
		      <div id = "divSrchPanel" style="height:auto" class = "dvSrchPanel" data-role ="none">
			      <table style="height:44px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
			        <tr style="width:100%">
			          <td style="width:75%">&nbsp;</td>
			          <td style= "width:25%" nowrap = "false"> 
			            <table style="width:100%" border = "0">
			             <tr style="width:100%">
			             <td align = "right" valign ="center">
			               <input type ="button" name='search_btn' id='search_btn' value='Search' class="btnType1"  data-role = "none" onclick = "show(this)"/>
			             </td>
			             <td style="width:7%"></td> 
			             <td> 
			               <input type ="button" name='clear_btn' id='clear_btn' value='Clear' class="btnType1"  data-role = "none" onclick = "clearValues()"/>
			             </td>  
			             </tr>
			            </table>
			          </td>
			          <!--  <td style="width:1%">&nbsp;</td>  -->
			        </tr>
			      </table>
	     </div>
	   </div>
	   
	  <div  data-role ="none" class ="dvApp">
			<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  <tr style = "height:100%;width:100%">
			    <td style = "width:77%">
			         <span class = "spanDvsrch"> InPatients</span>
			    </td>
			    <td style = "width:23%" align = "center" valign = "center">
			        <select data-inline="true" class="cmbOrderBy" data-role="none" id="cmbOrderBy" name = "cmbOrderBy" onchange = "fnOrderBy(this)" data-native-menu="true"> 					
							<option value = "OR">Order By</option> 
							<option value = "patient_name">Patient Name</option> 
							<option value = "physician_name">Practitioner</option>	
							<option value = "bed_num">Bed No</option> 				
						</select> 	
			    </td>
			 
			    
			  </tr>
		    </table>	  
	  </div>
   <div class = "dvStroke"></div> 
     <div id = 'divcnt'  class = 'divcontent' >

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
							className = "dvLegendDischarged";
				  }
				  
					
					if(deceasedYn.equals("D"))
					{
						className = "dvLegendDeceased";
						
					}
					if(noofchildren > 0) 
						className = "dvLegendNewBorn";
					
					if(relationYn.equals("N"))
					{
						className = "dvLegendNoRelation";
					}
					
					 deceasedYn = "";
					 noofchildren = 0;
					 relationYn = "";
					 tempDischargeDate = "";
	  %>
	   
	   <table class = "tbIpContent2" cellpadding = "0" cellspacing = "0"  border = "0" onclick = "openPatient('<%=oInPatients.sPatientId%>' , '<%=oInPatients.sEpisodeId%>','<%=oInPatients.sAdmDateTime%>','<%=oInPatients.sDischargeDateTime%>','<%=oInPatients.locationType%>','<%=oInPatients.locationCode%>','<%=oInPatients.serviceCode%>')">
	        <tr class="trIpRows<%=nCssCount %>" >
	           <td style="width:6%" align="center" valign = "center">
	             <% 
	               if(className != "dvLegendNoRelation")
	               {
	             %>
	              <div class = "<%=className %>" ></div>
	              
	              <%
	               }
	               else
	               {
	            	   %>
	            	   <div class = "<%=className %>" ><font size=5><b>*</b></font></div> 
	            	   <% 
	               }
	              %>
	           </td>
	           <td style = "width:7%" align="center" valign = "center" >
	             <img src="../images/Photo-4.png"  class = "imgPhoto"></img>
	           </td>
	           <td style="width:82%">
	             <table style = "width:100%" border = "0" cellpadding = "0" cellspacing = "0">
	                <tr class="trIpChildRows">
	                         <td style="width:100%" colspan = "2" >
	                        <%  
	                        // strPatientDetails = out.println(rs.getString("patient_name") )+ " " + out.println(rs.getString("sex"),rs.getString("age")) + " " + out.println(rs.getString("patient_id"));
	                        strPatientDetails = oInPatients.sPatientName + " " + oInPatients.sGender + "," + oInPatients.sAge + " " + oInPatients.sPatientId;
	                         
	                         %>
	                          <input type = "textbox" class = "txtRows<%=nCssCount %>" value = "<%=strPatientDetails %>" data-role = "none" readonly = "true"/>
	                         </td>
	                         
	                </tr>
	                
	                <tr class="trIpChildRows">
	                   <td style="width:60%" >
	                     <span class="lz-list-label">Room,Bed No :</span><span class="lz-list-data1"><%=oInPatients.sRoomNo%>,<%=oInPatients.sBedNo%></span>  
	                    
	                   </td>
	                    <td style="width:40%" >
	                     <span class="lz-list-label1">Adm Date :</span><span class="lz-list-data1"><%=oInPatients.sAdmDateTime%></span>  
	                     
	                     
	                    </td>
	                    
	                </tr>
	                 <tr class="trIpChildRows">
	                         <td style="width:100%" colspan = "2">
	                          <span class="lz-list-label">Practitioner :</span><span class="lz-list-data1"><%=oInPatients.sPhysicianName%></span>
	                         </td>
	                         
	                </tr>
	             </table>
	           
	           </td>
	           <td style = "width:4%" align = "center" valign = "center">
	             <img src="../images/More.png"  ></img>
	           </td>
	              <td style = "width:1%" align = "center" valign = "center">  
	             
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
			  
			   <%= IPADConstants.NORECORDS_HTML%>
			 <% 
		 }
	  %>
	  
		<table class = "tblegends" border = "0" cellpadding = "0" cellspacing = "0" >
			<tr style = "width:100%;height:100%">
				  
				  <td style = "width:75%;height:100%" class="tdlegends"> 
					  <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					         <tr style = "width:100%;height:52%">
					           <td style = "width:25%;height:100%" align="center"><div class = "divLegends" style="background-color:black"></div> </td>
					           <td style = "width:25%;height:100%" align="center"><div class = "divLegends" style="background-color:pink"></div> </td>
					           <td style = "width:25%;height:100%" align="center"><div class = "divLegends" style="background-color:orange"></div> </td>
					        </tr>
					        <tr style = "width:100%;height:48%">
					           <td style = "width:25%;height:100%" align="center" ><span class="spLegends">Deceased </span></td>
					           <td style = "width:25%;height:100%" align="center" nowrap = "false"><span class="spLegends">Newborn Exist</span> </td>
					           <td style = "width:25%;height:100%" align="center" ><span class="spLegends">Discharged </span></td>
					        </tr>
					     </table>
				  
				  <td>
				  <td style = "width:25%;height:100%"> 
				    <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					         <tr style = "width:100%;height:52%">
					           <td style = "width:100%;height:100%" align="center"><div class = "dvLegendNoRelation" ><font size=5><b>*</b></font></div> </td>
					           
					        </tr>
					        <tr style = "width:100%;height:48%">
					           <td style = "width:100%;height:100%" align="center" nowrap = "false"><span class="spLegends">No PP Relationship </span></td>
					           
					        </tr>
					     </table>
				  <td>
			</tr>
		
		
		</table>   
		
		
    </div>

<input type = "hidden" name ="hdnPatientId" id ="hdnPatientId" value = "<%=oInPatientContext.getPatientId()%>"/>
<input type = "hidden" name ="hdnNursingUnit" id ="hdnNursingUnit" value = "<%=oInPatientContext.getNursingUnitCode() %>"/>
<input type = "hidden" name ="hdnClinicianId" id ="hdnClinicianId" value = "<%=oInPatientContext.getPractionerId() %>"/>
<input type = "hidden" name ="hdnSpeciality" id ="hdnSpeciality" value = "<%=oInPatientContext.getSpecialityCode() %>"/>
<input type = "hidden" name ="hdnOrderBy" id ="hdnOrderBy" value = "<%=oInPatientContext.getOrderBy() %>"/>
</form> 

 <div data-role="none" id='Dialog' style="width:100%; height:auto;display:none">
     <iframe src = "" width = "100%" height = "1000px" scrolling = "yes" id="srchFrame" frameborder="0"></iframe>  
</div>

</section>
  
  <%
}catch ( Exception e ){
	out.println("Exception " + e);
	e.printStackTrace();
}
finally{

}
%>
</body>

