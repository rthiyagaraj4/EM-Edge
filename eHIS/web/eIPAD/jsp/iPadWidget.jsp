<%@page import="eCommon.Common.CommonBean"%>
<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String PatientID = "";//request.getParameter("hdnPatientId");
String strEpisodeId = "";//request.getParameter("hdnEpisodeId");
String admitDate = "";
String dischargeDateTime = "";
String locnCode = "";
String locnType = "";
String serviceCode = "";

if(request.getParameter("hdnPatientId") != null)
{
	PatientID = request.getParameter("hdnPatientId");
}
if(request.getParameter("hdnEpisodeId") != null)
{
	strEpisodeId = request.getParameter("hdnEpisodeId");
}
session.putValue("PatientID", PatientID);
session.putValue("EpisodeId", strEpisodeId);
String strPatientClass =  "";
if(request.getParameter("hdnPatClass") != null)
{
	strPatientClass = request.getParameter("hdnPatClass");
}
if(request.getParameter("hdnAdmitDate") != null)
{
	admitDate = request.getParameter("hdnAdmitDate");
}
if(request.getParameter("hdnDischargeDateTime") != null)
{
	dischargeDateTime = request.getParameter("hdnDischargeDateTime");
}
if(request.getParameter("hdnLocnCode") != null)
{
	locnCode = request.getParameter("hdnLocnCode");
}
if(request.getParameter("hdnLocnType") != null)
{
	locnType = request.getParameter("hdnLocnType");
}
if(request.getParameter("hdnServiceCode") != null)
{
	serviceCode = request.getParameter("hdnServiceCode");
}

session.putValue("AdmitDate", admitDate);
session.putValue("DischargeDateTime", dischargeDateTime);
session.putValue("LocnCode", locnCode);
session.putValue("LocnType", locnType);
session.putValue("ServiceCode", serviceCode);

// code added to get the main page url from the request
String mainPageUrl = request.getParameter("hdnMainPageURL");
mainPageUrl = CommonBean.checkForNull(mainPageUrl);
if("".equals(mainPageUrl.trim())){
	mainPageUrl = "../html/widget.html";
}

String params = request.getParameter("hdnParams");

// code added to get the parameter which will be useful
// in hiding the navigation icons
// hiding of these icons should happen in the case
// of previous results screen part of pending results functionality
// in the normal flow, this parameter will not be set
String hideIconParam = request.getParameter("hdnHideIcon");
hideIconParam = CommonBean.checkForNull(hideIconParam, "N");

String site = "";
String jdbc_user = "";
String facility_name = "";
String facility_id= "";
String locale = "en";

Boolean bPatientId = false;
Boolean bPatientName = false;
Boolean bAge = false;
Boolean bGender = false;
Boolean bDOB = false;
Boolean bEncounter = false;
Boolean bNationality = false;
Boolean bNursingUnit = false;
Boolean bBedNo = false;
Boolean bLanguage = false;

String strBannerPatientID = "";
String strBannerPatientName = "";
String strAge = "";
String strGender = "";
String strDOB = "";
String strEncounter = "";
String strNationality = "";
String strNursingUnit = "";
String strBedNo = "";
String strLanguage = "";

StringBuffer sqlStr = new StringBuffer("");
StringBuffer sbPatientDetails = new StringBuffer("");
StringBuffer sbPatientLocationDetails = new StringBuffer("");
StringBuffer sbPatientGenderDetails = new StringBuffer("");
StringBuffer sqlPatientDetails = new StringBuffer("");

String strFromdate = DateUtils.getCurrentDate("DMY", "en");

if(session.getValue("facility_id") != null )
{
	facility_id = (String)session.getValue("facility_id");
}
if(session.getValue("userSite") != null)
{
 site = (String)session.getValue("userSite");
}

if(session.getValue("jdbc_user") != null)
{
	jdbc_user = (String)session.getValue("jdbc_user");
}

if(session.getValue("facility_name") != null)
{
	facility_name = (String)session.getValue("facility_name");
}



sqlStr.append(" SELECT   a.elmt_ref element_ref, a.display_length display_len, a.line_ref display_line, a.disp_ord display_order, a.tool_tip_text tool_tip, a.prefix_label_text display_text,");
sqlStr.append(" a.num_of_spaces no_of_spaces, b.elmt_desc element_desc, b.max_length max_length, b.disp_length_config_yn config, b.dflt_disp_length default_disp_length, b.dflt_line_ref default_disp_line, b.dflt_disp_ord default_disp_order, b.dflt_tool_tip_text default_tool_tip, b.dflt_sel_yn def_sel_yn, ");
sqlStr.append(" b.prefix_label_type prefix_label_type, b.elmt_ref element_ref_def, b.icon_based_yn icon_yn, b.image_name img_name ");
sqlStr.append(" FROM mp_pat_banner_dtl a, mp_pat_banner_elmt b");
sqlStr.append(" WHERE a.banner_ref(+) = 'U01' AND a.banner_categ(+) = 'E' AND a.elmt_ref(+) = b.elmt_ref  AND b.appl_categ IN ('E','B') ORDER BY DECODE (b.elmt_ref, 'PAT_PHOTO', 1, 2), NVL2 (a.line_ref, a.line_ref, b.dflt_line_ref), a.disp_ord,  b.dflt_disp_ord");

Statement stmt				= null;
ResultSet rs				= null;

Statement stmt1				= null;
ResultSet rs1				= null;
ResultSet rs2				= null;
Connection conn=null;
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
String strRowCount = "";
try {
conn = ConnectionManager.getConnection(request);
if(conn != null)
{
	stmt = conn.createStatement();
	stmt1	 = conn.createStatement();
}
if (rs!=null) rs.close();  
if(stmt != null)
{
 rs = stmt.executeQuery(sqlStr.toString());
}

if(rs != null)
{
	String strBannerElement = "";
	//out.println("hi");
	 while (  rs.next() )
	 {
		 strBannerElement = rs.getString("element_ref");
		 if(strBannerElement != null && strBannerElement.equals("PATIENT_ID"))
		 {
			 bPatientId = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("PATIENT_NAME"))
		 {
			 bPatientName = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("AGE"))
		 {
			 bAge = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("GENDER"))
		 {
			 bGender = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("DATE_OF_BIRTH"))
		 {
			 bDOB = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("DATE_OF_BIRTH"))
		 {
			 bDOB = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("ENCOUNTER_ID"))
		 {
			 bEncounter = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("NATIONALITY"))
		 {
			 bNationality = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("LOCN_BED_ROOM_NO"))
		 {
			 bNursingUnit = true;
		 }
		 //
		 if(strBannerElement != null && strBannerElement.equals("PAT_NAME_LOCAL_LANG"))
		 {
			 bLanguage = true;
		 }
		 
	 }
	 rs.close(); 
	 if ( stmt != null ) stmt.close() ;
	
}

sqlPatientDetails.append(" SELECT   a.patient_id, REPLACE (DECODE ('" + locale+ "' , '" + locale + "' , a.patient_name,NVL (a.patient_name_loc_lang, a.patient_name) ),'''', '' ) patient_name, ");
sqlPatientDetails.append(" TO_CHAR (a.dob, 'dd/mm/yyyy') dob,  a.sex, a.patient_name_loc_lang, NVL (a.age_hrs, a.age) age,  c.LONG_DESC, a.episode_id, ");
sqlPatientDetails.append(" ip_get_desc.ip_nursing_unit ('" + facility_id + "' , a.cur_ward_code, '" + locale + "' , '1') locn_name, ");
sqlPatientDetails.append(" NVL (a.cur_room_num, ' ') room_num, NVL (a.cur_bed_num, ' ') bed_num FROM mp_country  c, ca_ip_active_episode_vw a JOIN mp_patient b on a.patient_id = b.patient_id");
sqlPatientDetails.append(" WHERE a.facility_id = '" + facility_id  + "' AND a.patient_id = '" + PatientID + "' AND a.patient_class = '"+strPatientClass + "' AND (a.adt_status IN ('01', '02')) and c.country_code = b.NATIONALITY_CODE AND (NOT EXISTS (  SELECT 1  FROM mo_mortuary_regn  WHERE patient_id = a.patient_id  AND body_part_obtained_from IS NULL)  ) AND UPPER (a.cur_bed_num) LIKE UPPER ('%') ");


if (rs1 !=null) rs1.close(); 
if(stmt1 != null)
{
	rs1 = stmt1.executeQuery(sqlPatientDetails.toString());
}
if(rs1 != null)
{
	String sex = "";
	if(rs1.next())
	{
		 strBannerPatientID = rs1.getString("patient_id");
		 strBannerPatientName = rs1.getString("patient_name");
		 strAge = rs1.getString("age");
		 if(rs1.getString("sex").equals("M") )
		 {
		  strGender = "Male";
		  sex = "M";
		 }
		 else
		 {
			 strGender = "Female";
			 sex = "F";
		 }
		 strDOB = rs1.getString("dob") ;
		 strEncounter = rs1.getString("episode_id") ;
		 strNationality = rs1.getString("LONG_DESC") ;
		 strNursingUnit = rs1.getString("locn_name") ;
		 strBedNo = rs1.getString("bed_num") ;
		 strLanguage = rs1.getString("patient_name_loc_lang") ;
	}
	rs1.close();
	if ( stmt1 != null ) stmt1.close() ;
	session.putValue("DOB",strDOB);
	session.putValue("Gender",sex);
	
	
}
%>




<!DOCTYPE html> 
<html> 
<head> 
<title>widget</title> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
 <meta name="apple-mobile-web-app-capable" content="yes" />

<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  

<link rel="stylesheet" href="../css/iPadwidget.css" />

<script src="../jquery-1.5.2.min.js"></script>  

<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 
<script>
  var orientation = "";
  function closeWindow()
  {
	 // window.history.back();
	// window.close();
	 window.location = "IpadBasePage.jsp";
  }
  function showLoadingMsg()
  {
	var hdnMainPageURLComp = document.getElementById("hdnMainPageURL");
  	var mainPageUrl;
  	if(hdnMainPageURLComp){
  		mainPageUrl = hdnMainPageURLComp.value;
  	}
  	//alert("Url to show in ipadwidget ="+mainPageUrl);
  	var hdnParamComp = document.getElementById("hdnParams");
  	var parameterVal="";
  	if(hdnParamComp){
  		parameterVal = hdnParamComp.value;
  	}
  	//alert("parameter value="+parameterVal);
  	//alert('main page url ='+mainPageUrl);
  	
  	mainPageUrl += "?" + parameterVal;
  	document.getElementById("widgetFrame").src = mainPageUrl;//"../html/widget.html"
 	$.mobile.pageLoading();
 
 	
  }
  function hideLoading()
  {
  	$.mobile.pageLoading(true);
  }
  function SelectOrder()
  {
	 // document.getElementById("widgetFrame").src = "SelectOrders.html";
  }
  function showNotes()
  {
	  document.getElementById("widgetFrame").src = "ViewNotes.jsp";
  }
  function showCreateNotes()
  {
	  //var gender = document.getElementById("hdnSex").value;
	   var patclass = document.getElementById("hdnPatientClass").value;
	  document.getElementById("widgetFrame").src = "CreateNotes.jsp?patclass=" + patclass;
  }
  function dispNotesContent(accessionNum,noteType)
  {
	  var patclass = document.getElementById("hdnPatientClass").value;
	  document.getElementById("widgetFrame").src = "CreateNotes.jsp?patclass=" + patclass +"&fromfunc=recentNotes&note_type=" + noteType+"&accessionNum=" + accessionNum; 
  }
  function showRecNotes()
  {
	  document.getElementById("widgetFrame").src = "RecentNotes.jsp"
  }
  function showRecordChart()
  {
	  var gender = document.getElementById("hdnSex").value;
	  var patclass = document.getElementById("hdnPatientClass").value;
	 // document.getElementById("widgetFrame").src = "RecordCharts.jsp?gender=" + gender;
	  document.getElementById("widgetFrame").src = "RecordCharts.jsp?patclass=" + patclass;
  }
  function showSelectOrders()
  {
	  var patclass = document.getElementById("hdnPatientClass").value;
	  document.getElementById("widgetFrame").src = "SelectOrderBasePage.jsp?patientclass=" + patclass + "&orientation=" + orientation;
  }
// function added to show the clinical event history page
  function showClinicalEventHistory(patientId,facilityId)
  {
	  //alert('PatientId ='+patientId+' ,Facility='+facilityId);
	  // the patient list is being passed as IP as the clinical
	  // history functionality is being shown for IP list only
	  // in future, when the OP, DC and EM patient list types
	  // are supported, then the parameter should be set
	  // in the page itself
	  document.getElementById("widgetFrame").src = "ViewClinicalEventHistory.jsp?patient_id="+patientId+"&facility_id="+facilityId+"&patientlist=IP&selectedperiod=LOD";
  }
  function scrolTop()
  {
	  //alert("helloj");
	  $.mobile.silentScroll(-2000);
  }
  function showChartView()
  {
	  document.getElementById("widgetFrame").src = "ChartView.jsp";
  }
  
  function openMainWindow(params){
	  //window.location = "IpadBasePage.jsp"+"?"+params;
	  window.location = "IpadBasePage.jsp"+"?"+params;
  }
  
  $(document).ready(function () {
	  
	  if (window.DeviceOrientationEvent) {  
		  window.addEventListener('orientationchange', myOrientResizeFunction, false);
		  orientation = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
		  }
	 
	  function myOrientResizeFunction(orientation){     
		 // alert(Math.abs(window.orientation));
		 
		   var orient = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
		   
		   if(orient == "landscape")
			   {
			     document.getElementById("widgetFrame").style.height = "553px";
			     document.getElementById("widgetFrame").contentWindow.changeOrientation(orient);
			   }
		   else
			   {
			   document.getElementById("widgetFrame").style.height = "809px";
			   document.getElementById("widgetFrame").contentWindow.changeOrientation(orient);
			   }
		    
		  }
	  
  });
</script>
</head> 
<body onload = "showLoadingMsg()"> 
<section id="page1" data-role="page"  style = "padding:0px;width:100%"> 
<form name = "frmwidget">
<header data-role="header"  style="height:175px;padding:0px;border : 0px">
<div id = "divheader" class="dvheader"    >

<table border = "0" style = "width:100%" cellpadding = "0" cellspacing = "0">

<tr  class="BannerTitle"align = "center">
 
<td align = "left" style ="width:33%"><span class="spTitle">Enterprise Management-12.0.2</span></td>
<td align = "center" style ="width:34%"><span class="spFooter2"><%=jdbc_user%></span></td>
<td align = "right" style ="width:33%"><span class="spFooter3" ><%=strFromdate %></span></td>

</tr>
</table>
 
<%
if(hideIconParam == null || hideIconParam.equals("") || "N".equalsIgnoreCase(hideIconParam)){
%> 
<table border = "0" style = "width:100%" cellpadding = "0" cellspacing = "0" class = "tbIcon">
	<tr class="tIcon"  >
	
		<td align = "left" style ="width:5%" valign = "bottom" class = "iconDivider">
		<!--   <img src = "../images/Disabled State.png" ></img>-->
		</td>
		    
		<td align = "left" style ="width:10%" valign = "center" class = "iconDivider" onclick = "showCreateNotes()">
		    <img src = "../images/Edit notes.png"></img>
		</td>
		<td align = "left" style ="width:10%" valign = "center" class = "iconDivider" onclick = "showNotes()">
		    <img src = "../images/View Notes.png" ></img>
		</td>
		
		<td align = "left" style ="width:10%" valign = "center" class = "iconDivider" onclick = "showRecordChart()">
		  
		  <img src = "../images/Record Chart.png"></img>
		</td>
		
		<td align = "left" style ="width:10%" valign = "center" class = "iconDivider" onclick = "showChartView()">
		     <img src = "../images/View Chart.png"></img>
		</td>
		

		
		<td align = "left" style ="width:10%" valign = "center" class = "iconDivider" onclick = "showClinicalEventHistory('<%=PatientID%>','<%=facility_id%>')">
		<img src = "../images/View Event History.png"></img>
		  
		</td>
		
		<td align = "left" style ="width:10%" valign = "center" class = "iconDivider" onclick = "showSelectOrders()">
		  <img src = "../images/Select-Order.PNG"></img>
		</td>
		
		<td align = "center" style ="width:10%" valign = "center">
		  
		</td>
		
		<td align = "center" style ="width:18%" valign = "center">
		  
		</td>
		
		<td align = "center" style ="width:7%" valign="middle">
		
		<img src = "../images/Back.png" class="imgLogoutt" onclick="closeWindow()"></img>
		</td>
	
	</tr>
</table>
<%
}
%>

<table border = "0" style = "width:100%" cellpadding = "0" cellspacing = "0" class = "tbBanner" style = "position:fixed">
<tr class="patBanner">
 <td align = "left" style ="width:13%" valign = "center" >
    <img src = "../images/Patient Banner Photo.png" class = "imgBanner" ></img>  
 </td>
<td align = "center" style ="width:87%">
  <table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
    
       <% if(bPatientId) {
    	   sbPatientDetails.append(strBannerPatientID + " "); 
     
      
       
       
     } 
       
       if(bPatientName) {
    	   sbPatientDetails.append(strBannerPatientName) ;   
        
       } 
       if( bPatientId || bPatientName)
       {
       %> 
       <tr style = "width:100%">
    
      <td valign = "middle" style = "width:100%">
       <input type = "textbox"  data-inline = "true" data-role = "none" readonly = "true"  class = " txtPatientNameBanner1" value = "<%=sbPatientDetails.toString() %> " />
       <!--  <img src = "images/Patient Banner Star.png"></img>  --> 
           </td>
      
    </tr>
       
        <%
       }
        %>  
          
       <%
         if(bLanguage && strLanguage != null && !strLanguage.equals("") && !strLanguage.equals("   "))
         {
       %>
       <tr style = "width:100%">
     
      <td valign = "middle" >
         <input type = "textbox"  data-role = "none" readonly = "true"  class = " txtPatientNameBanner" value = "<%=strLanguage %> " />
         
          </td>
      
    </tr>
       <%} %>
     <!-- 
     <tr style = "width:100%" >
     
      <td valign = "middle" style = "width : 100%"> 
      
      - -->
       <% if(bDOB) {
    	   sbPatientGenderDetails.append("DOB : " + strDOB + "   ");   
       } 
       
        if(bGender) {
    	   sbPatientGenderDetails.append("Sex : " + strGender + "   ");  
      } 
       
          if(bAge) {
        	 sbPatientGenderDetails.append("Age : " + strAge + "   "); 
       } 
       
        if(bNationality) {
        	sbPatientGenderDetails.append("Nationality : " + strNationality );
      } 
        
      if(bDOB || bGender || bAge || bNationality)  
      {
      %>
       <tr style = "width:100%" >
     
      <td valign = "middle" style = "width : 100%"> 
      <input type = "textbox"  data-role = "none" readonly = "true"  class = " txtPatientNameBanner" value = "<%=sbPatientGenderDetails.toString() %> " />
         </td>
      
    </tr>
      <%
      }
      %> 
    
     
        <% if(bEncounter) {
        	sbPatientLocationDetails.append("Encounter Id : " + strEncounter + "   ");
        	//strNursingUnit
        	
        
      } 
       
       if(bNursingUnit) {
    	   sbPatientLocationDetails.append("Nursing unit and Bed no : " + strNursingUnit + "," + strBedNo + "   ");
         
       } 
       if(bEncounter || bNursingUnit)
       {
       %>
       <tr style = "width:100%" >
     
      <td valign = "middle" > 
         <input type = "textbox"  data-role = "none" readonly = "true"  class = " txtPatientNameBanner" value = "<%=sbPatientLocationDetails.toString() %> " />
           </td>
      
    </tr>
       
       <%
       }
       %>
  
    
  </table>
</td>


</tr>

</table>



</div>

</header>

<div class ='divwidget' id = 'dvmain'   style="background-color:white;padding:0px">

<div id = "divView"   style = "height:auto;overflow:auto;backgound-color:white;padding:0px" > 
  
   
  
  <iframe frameborder="0" id="widgetFrame" src="" scrolling ="yes" style="padding:0px;display:block" ></iframe>  


     </div>         

</div>

   <footer data-role = "footer"   style="padding:0px;height:20px;;border : 0px">  
		    <div id = "divFooter" class="dvFooter"    data-role = "none"> 
				<table border = "0" style = "width:100%;height:100%" cellpadding = "0" cellspacing = "0" class="tbFooter">
					<tr valign="center">
						<td align = "left" style ="width:30%" valign="top"><span class="spFooter1"><%=facility_name %>-<%=site%></span></td>
						<td align = "right" style ="width:64%" valign="top"><span class="spFooter2">Copyright 2012 Computer Sciences Corporation - All rights reserved</span></td>
						<td align = "right" style ="width:6%" valign="top"><img src="../images/CSC_Logo.png" class="imgWidgetLogo"></img></td>
					
					</tr>
				</table>
		   </div> 
		  </footer>  
   <input type = "hidden" name = "hdnSex" id = "hdnSex" value = "<%=strGender %>" />
   <input type = "hidden" name = "hdnPatientClass" id = "hdnPatientClass" value = "<%=strPatientClass %>" />
   <input type="hidden" name="hdnMainPageURL" id="hdnMainPageURL" id="hdnMainPageURL" value="<%=mainPageUrl%>"/>
   <input type="hidden" name="hdnParams" id="hdnParams" id="hdnParams" value="<%=params %>"/>
   
</form>
</section>
 <%
}catch ( Exception e ){
	//out.println("Exception " + e);
	out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(conn,request);
}
%>

</body>
</html>

