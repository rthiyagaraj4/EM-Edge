<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");



//sqlStr.append("SELECT A.PATIENT_CLASS EPISODE_TYPE_DESC,'I' EPISODE_TYPE,A.PATIENT_ID,REPLACE(DECODE('en','en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') PATIENT_NAME,TO_CHAR(A.DOB,'dd/mm/yyyy') DOB,A.AGE,A.SEX,A.LOCN_TYPE,A.CUR_WARD_CODE LOCN_CODE,  NULL FILEUM,NVL(A.CUR_ROOM_NUM,' ')ROOM_NUM,NVL(A.CUR_BED_NUM,' ')BED_NUM, A.CUR_PHYSICIAN_ID PHYSICIAN_ID,AM_GET_DESC.AM_PRACTITIONER(A.CUR_PHYSICIAN_ID,'ru','2') PHYSICIAN_NAME,A.SERVICE_CODE SPLTY_CODE,NVL(AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'ru','1'),' ') SPLTY_NAME,TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE,TO_CHAR(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy') DISCHARGE_DATE_TIME,A.EPISODE_ID,TO_NUMBER('') VISIT_ID,A.ADMISSION_TYPE_CODE VIS_ADM_TYPE_CODE,CASE WHEN A.ADT_STATUS IN ('00','08') THEN CASE WHEN A.ADT_STATUS='08' THEN 'DS' WHEN A.CUR_BED_NUM IS NOT NULL THEN 'BA' ELSE 'AD' END WHEN A.ADT_STATUS='01' THEN  CASE WHEN  (SELECT 'Y' FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.EPISODE_ID AND DIS_ADV_STATUS='0' AND ROWNUM=1)='Y' THEN 'AP' WHEN  (SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL WHERE FACILITY_ID=A.FACILITY_ID AND  ENCOUNTER_ID = A.EPISODE_ID  AND ROWNUM=1 AND STATUS!='E' ) = 'Y' THEN 'DR'  ELSE CASE WHEN A.CUR_BED_NUM IS NOT NULL THEN 'BA' ELSE 'AD' END END END VISIT_EPISODE_STATUS,' ' APPT_TIME,' 'QUEUE_NUM,A.ADT_STATUS QUEUE_STATUS ,TO_CHAR(SYSDATE,'hh24:mi:ss') QRYTIME,A.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,TRUNC(A.ADMISSION_DATE_TIME) VISIT_DATE,NULL SECURITY_LEVEL, NULL PROTECTION_IND, (REPLACE(DECODE('en','en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) ,'''','')||','||A.AGE||','||A.SEX) P_LINE,CA_GET_PATIENT_CURR_STATUS(A.FACILITY_ID,A.PATIENT_ID,A.EPISODE_ID,A.PATIENT_CLASS,'NAREN',A.DECEASED_YN)  STATUS,A.PATIENT_CLASS,NULL UNASSIGN_PATIENT_YN,A.ADMISSION_DATE_TIME ORDERBYDATE,A.REFERRAL_ID, A.DOB ACTUAL_DOB,A.ADMISSION_DATE_TIME ADM_DATE1, TO_CHAR(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') CLS_CONS_DATE, NULL PRIORITY_ZONE ,'visit_type' FROM CA_IP_ACTIVE_EPISODE_VW_i A where rownum < 15");
String facility_id=(String)session.getValue("facility_id");
String clinicianId =(String)session.getValue("ca_practitioner_id");
Boolean bRadioCode = true;
Boolean bRadioDesc = false;
//sqlStr.append("SELECT   REPLACE (DECODE ('en','en', patient_name,NVL (patient_name_loc_lang, patient_name)),'''','') patient_name,a.patient_id,NVL (a.age_hrs, a.age) age, a.sex,am_get_desc.am_practitioner (a.cur_physician_id,'en','2') physician_name,TO_CHAR (a.admission_date_time, 'dd/mm/yyyy hh24:mi') adm_visit_date,NVL (a.cur_room_num, ' ') room_num,NVL (a.cur_bed_num, ' ') bed_num,TO_CHAR (a.discharge_date_time, 'dd/mm/yyyy') discharge_date_time FROM ca_ip_active_episode_vw a WHERE a.facility_id = ? AND a.patient_class = 'IP' AND (a.adt_status IN ('01', '02')) AND a.cur_physician_id = ? AND (NOT EXISTS (SELECT 1 FROM mo_mortuary_regn WHERE patient_id = a.patient_id AND body_part_obtained_from IS NULL)) AND UPPER (a.cur_bed_num) LIKE UPPER ('%')ORDER BY patient_name,bed_num,discharge_date_time,physician_name");
//sqlStr.append("SELECT   REPLACE (DECODE ('en','en', patient_name,NVL (patient_name_loc_lang, patient_name)),'''','') patient_name,a.patient_id,NVL (a.age_hrs, a.age) age, a.sex,am_get_desc.am_practitioner (a.cur_physician_id,'en','2') physician_name,TO_CHAR (a.admission_date_time, 'dd/mm/yyyy') adm_visit_date,NVL (a.cur_room_num, ' ') room_num,NVL (a.cur_bed_num, ' ') bed_num,TO_CHAR (a.discharge_date_time, 'dd/mm/yyyy') discharge_date_time FROM ca_ip_active_episode_vw a WHERE a.facility_id ='" + facility_id +"' AND a.patient_class = 'IP' AND (a.adt_status IN ('01', '02')) AND a.cur_physician_id = '" + clinicianId + "' AND (NOT EXISTS (SELECT 1 FROM mo_mortuary_regn WHERE patient_id = a.patient_id AND body_part_obtained_from IS NULL)) AND UPPER (a.cur_bed_num) LIKE UPPER ('%')ORDER BY patient_name,bed_num,discharge_date_time,physician_name");
//sqlStr.append("SELECT NURSING_UNIT_CODE Code,LONG_DESC Description FROM IP_NURSING_UNIT A ");
//sqlStr.append("select apf.practitioner_id,ap.practitioner_name from am_pract_for_facility apf join am_practitioner ap on apf.practitioner_id = ap.practitioner_id");
sqlStr.append("SELECT a.SPECIALITY_CODE code,a.SHORT_DESC description FROM AM_SPECIALITY_lang_vw a WHERE eff_status = 'E' AND LANGUAGE_ID  ='en' AND SPECIALITY_CODE IN (SELECT NVL(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE FROM am_practitioner");
sqlStr.append(" WHERE practitioner_id ='" + clinicianId +"' UNION ALL SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES  ");
sqlStr.append(" WHERE FACILITY_ID ='" + facility_id +"' AND practitioner_id ='" + clinicianId +"')");

String SearchBy = "" ;
String SearchCriteria = "" ;
String SearchText = "";
String strPostBack = "";
Statement stmt				= null;
ResultSet rs				= null;

Statement stmt1				= null;
ResultSet rs1				= null;
ResultSet rs2				= null;
Connection con=null;

//if(request.getParameter("hdnIsPostBack") != null && request.getParameter("hdnIsPostBack") == "true")
//{
	strPostBack = request.getParameter("hdnIsPostBack");
		if(request.getParameter("group1") != null && request.getParameter("group1") != "" )
		{
			SearchBy = (String)request.getParameter("group1");
		}
		
		if(request.getParameter("cmbCriteria") != null && request.getParameter("cmbCriteria") != "" )
		{
			SearchCriteria = (String)request.getParameter("cmbCriteria");
		}
		if(request.getParameter("txtSrchCriteria") != null && request.getParameter("txtSrchCriteria") != "" )
		{
			SearchText = (String)request.getParameter("txtSrchCriteria");
		 
		}
		
		
		
		if(!SearchBy.equals("") && SearchBy.equals("code") && !SearchText.equals (""))
		{
			bRadioCode = true;
			bRadioDesc = false;
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("SW"))
			sqlStr.append(" AND upper(a.SPECIALITY_CODE) like upper('" + SearchText + "%')");
		   
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("CN"))
			   sqlStr.append(" AND upper(a.SPECIALITY_CODE) like upper('%" + SearchText + "%')");
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("EW"))
			   sqlStr.append(" AND upper(a.SPECIALITY_CODE) like upper('%" + SearchText + "')");
		   
		}
		
		
		if(!SearchBy.equals("") && SearchBy.equals("desc") && !SearchText.equals (""))
		{
			
			bRadioCode = false;
			bRadioDesc = true;	
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("SW"))
			   sqlStr.append(" AND upper(a.SHORT_DESC) like upper('" + SearchText + "%')");
		   
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("CN"))
			   sqlStr.append(" AND upper(a.SHORT_DESC) like upper('%" + SearchText + "%')");
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("EW"))
			   sqlStr.append(" AND upper(a.SHORT_DESC) like upper('%" + SearchText + "')");
		   
		}
		
		
		
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;

		try {
		//con = ConnectionManager.getConnection(request);
		//stmt = con.createStatement();


		if (rs!=null) rs.close();   
		
		if(strPostBack != null && strPostBack.equals("true") )
		{
			
			con = ConnectionManager.getConnection(request);
			if(con != null)
			stmt = con.createStatement();
		    if(stmt != null)
			rs = stmt.executeQuery(sqlStr.toString());
		}
		//out.println(sqlStr.toString());

		






%>


<!DOCTYPE html> 
<html> 
<head> 
<title>Prac</title> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<link rel="stylesheet" href="../css/ipad.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script> 

<style>
  .bgClr{   
              height : 30px;
         
      
        background :   -moz-linear-gradient( #015555 , #2496ac ); 
        background :  -webkit-gradient(linear, left top, left bottom, from( #015555 ), to( 

#2496ac )); /* Saf4+, Chrome */
        background : -webkit-linear-gradient( #015555 , #2496ac ); /* Chrome 10+, Saf5.1+ 

*/
        border:1px solid red;
        border-radius:5px;
        -moz-border-radius:5px;
       font-family: Gotham-Bold;
	font-size: 12pt;
       /* margin-left : 25px;*/
  }
  .tbIpContent2 tr:active{    
   background-color:#a2d7d7; 
   } 
</style>
<script type="text/javascript">
/*
 $(document).bind("swipe", function(event, data){
	//alert("helloo")
	event.preventDefault();	
 });
 */
function openPatient()
 {
	// alert("hi");
	// window.parent.location ="Appointment.html";
	// $('#page12').html("Loading.....")
	 // window.parent.slidee("true");
	 // window.location ="Appointment.html";
	 //window.parent.location ="Appointment.html";
	
	//window.open("Appointment.html");
 }
 function showCriteria()
 {
	// $('#divSrchCriteria').slideToggle('fast');
	//alert("searchcc");
	// window.parent.test();
	// $("#page12").dialog("close");
 
 }
 function closeSrch(strCode,strDesc)
 {
	// alert("hi");
	 window.parent.CloseSearchCriteria();
 }
 function srchclose(strCode,strDesc,objTr)
 {
	// alert("hii");
	// $(this).css('background' , '#a2d7d7');
	//alert($(this));
	//$(this).removeClass("trSrchRow2");
	//$(this).addClass("trIpRowsTouch");
	// alert($(this));
	// window.parent.test(strCode,strDesc);
	//alert(objTr);
	//alert(objTr.style.background-color);
	//objTr.style.border = "3px solid";
	objTr.style.backgroundColor = "#a2d7d7";
	//var d = document.getElementById("tbSrchcontrol");
	window.parent.Speciality(strCode,strDesc);
	//alert(objTr);
 }
 function dummyFn()
 {
	 
 }
 function changerowColor(objTr)
 {
	// alert("hj");

	 objTr.style.backgroundColor = "#a2d7d7";
 }
 function move(e)
 {
	 e.preventDefault(); 
 }
 function show(objTr)
 {
	 objTr.style.border = "3px solid #48d1d8";
	// alert(objTr.style.backgroundColor);
	//alert( $(this));
	// $(this).removeClass('btnType1');               
	// $(this).addClass('bgClr');
     document.getElementById("hdnIsPostBack").value = "true";
	document.getElementById("frmNursingUnit").submit();
 }
	 
 function LoadDefaultValues()
 {
	 document.getElementById("txtSrchCriteria").value =  document.getElementById("hdnSearchText").value;
	 document.getElementById("cmbCriteria").value =  document.getElementById("hdnSearchcriteria").value;
	 if(document.getElementById("hdnRdCode").value == "true")
     {
		 document.getElementById("rdCode").checked = true;
	 }
	 else
	{
		 document.getElementById("rdDesc").checked = true;
	}
	 
 }
 </script>
   
<body onload = "LoadDefaultValues()">
  
    <section id="specialityPage" data-role="page"  style="padding:0px">  
    <form id = "frmNursingUnit" method = "post" name = "frmNursingUnit" >
    <div style="width:100%;height:auto><%=sqlStr.toString() %></div>
  <div id = "divSrch"  data-role ="none" class="dvApp" >
    <span class = "spanDvsrch">Speciality</span> 
  
  </div>
  
  
  <div id="divspeciality"   style = "display:block;height:auto" class = "dvCriteria">
  <table style="height:75px;width:100%" border = "0" cellpadding = "0" cellspacing = "0" id = "tbSrchcontrol" >

     <tr style="height:30px">
      <td align = "left" style="width:34%"><span class = "spSrchCriteria">Search By</span></td>
      <td align = "left" style="width:32%"><span class = "spSrchCriteria">Search Criteria</span></td>
      <td align = "left" style="width:32%"><span class = "spSrchCriteria">Search Text</span></td>
      <td align = "left" style="width:2%"></td>
 
     </tr>
     
     <tr style="height:35px">
      <td align = "left" style="width:34%" valign = "center" nowrap = "false">
       <table style="width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
         <tr style="width:100%;height:100%">
	         <td style="width :25%" align = "center">
		     	 <input type = "radio" name="group1" id="group1"  id="rdCode" data-role = "none" class = "radioGroup" value = "code" />
		     </td> 
		     <td style="width :20%">
		     	 <span class = "spRadio">Code</span>
		      </td>
		      <td style="width :25%" align = "center">
		     	 <input type = "radio" name="group1" id="group1"  data-role = "none" class = "radioGroup" value = "desc" id = "rdDesc"/>
		      </td>
		      <td style="width :20%">
		     	 <span class = "spRadio">Description</span>
		      </td>
		       <td style="width :10%">
		     	 &nbsp;
		      </td>
	     </tr> 
	    </table>  
      </td>
      <td align = "left" style="width:32%">
        <select  class="cmbSrchCriteria" data-role="none" id="cmbCriteria" name = "cmbCriteria"> 
           
			<option value = "SW">Starts With</option> 
			<option value = "CN">Contains</option> 
			<option value = "EW">Ends With</option> 
			

		</select> 
      </td>
      <td align = "left" style="width:32%"><input type = textbox data-role = "none" class = "tbPatCriteria" name = "txtSrchCriteria" id = "txtSrchCriteria"/></td>
        <td align = "left" style="width:2%"></td>
     </tr>
     <tr style = "height:10px;width:100%">
       <td >&nbsp;</td>
     <tr>

     
   </table>
   <div id = "divSrchPanel" style="height:auto" class = "dvSrchPanel">
			      <table style="height:44px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
			        <tr style="width:100%">
			          <td style="width:75%">&nbsp;</td>
			          <td style= "width:25%" nowrap = "false"> 
			            <table style="width:100%" border = "0">
			             <tr style="width:100%">
			             <td align = "right" valign ="center" >
			               <input type ="button" name='search_btn' id='search_btn' value='Search' class="btnType1"  data-role = "none" onclick = "show(this)"/>
			             </td>
			             <td style="width:8%"></td> 
			             <td> 
			               <input type ="button" name='clear_btn' id='clear_btn' value='Close' class="btnType1"  data-role = "none" onclick = "closeSrch('','',this)"/>
			             </td>  
			             </tr>
			            </table>
			          </td>
			      
			        </tr>
			      </table>
	     </div>
   
   </div>
   
   
   	      
   
 
   <div id = 'divSrchcContent'   class = 'dvSrchcontent' >
     <div  data-role ="none" class ="dvApp">
	  
			<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  <tr style = "height:100%;width:30%">
			    <td style = "width:30%" align ="left" >
			         <span class = "spanDvsrch">Code</span>
			    </td>
			    <td style = "width:70%" align = "left" valign = "center">
			     
			     <span class = "spanDvsrch">Description</span>   
			    </td>
			    
			    
			  </tr>
		    </table>	  
	  </div>
   <%
	  int nClassCount = 1;
	  int cnt = 0;
	  
	 if(rs != null) 
	 {
	  while (  rs.next() ){ 
	  %>
     <table class = "tbIpContent2" cellpadding = "0" cellspacing = "0"  border = "0">
      <tr class = "trSrchRow<%=nClassCount %>"  onclick = "srchclose('<%=rs.getString("code")%>','<%=rs.getString("description")%>',this)">
        <td style="width:30%" align = "left" valign = "center">
          <span class = "srchLabel"><%=rs.getString("code")%></span>
        </td>
        <td style="width:70%" align = "left" valign = "center">
            <span class = "srchLabel"><%=rs.getString("description")%></span>
        </td>
        
      </tr>
     </table>
      <%
	   cnt = cnt + 1;
		   if(nClassCount==1)
		   {
			   nClassCount = nClassCount +1;
		   }
		   else
		   {
			   nClassCount = nClassCount -1;
		   }
	  }//while
	 }//if
	   if(cnt == 0)
	   {
		   if(strPostBack != null && strPostBack.equals("true"))
		   {
		  %>
		      <%= IPADConstants.NORECORDS_HTML%>
		  <%
		   }
	   }
	  %>
     
  
    </div>
   <input type = "hidden" name = "hdnIsPostBack" id = "hdnIsPostBack" value = "false" />
   <input type = "hidden" name = "hdnSearchText" id = "hdnSearchText"  value = "<%=SearchText %>"/>
   <input type = "hidden" name = "hdnSearchcriteria" id = "hdnSearchcriteria" value = "<%=SearchCriteria %>" />
   <input type = "hidden" name = "hdnRdCode" id = "hdnRdCode" value = "<%=bRadioCode %>" />
   <input type = "hidden" name = "hdnRdDesc" id = "hdnRdDesc" value = "<%=bRadioDesc%>" />
</form>
 </section>  
       
     

   <%
}catch ( Exception e ){
	out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(con,request);
}

		
%> 

  
      </body>  
    

