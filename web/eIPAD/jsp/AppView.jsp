
<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String apptfromdate_greg = "04/04/2012";
String appttodate_greg = "05/04/2012";
String patientid = "SO00001819";
StringBuffer sql = new StringBuffer("") ;
sql.append("where");

String Clin_id=(String)session.getValue("ca_practitioner_id");

sql.append("  appt_date between to_date('"+apptfromdate_greg+"','dd/mm/yyyy') and ");
sql.append(" to_date('"+appttodate_greg+"','dd/mm/yyyy')  and patient_id is not null");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");
sqlStr.append(" Select patient_id,AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_appt_patient_vw.facility_id and CLINIC_CODE=oa_appt_patient_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC , RESOURCE_CLASS ,CLINIC_CODE,CARE_LOCN_TYPE_IND,appt_ref_no, to_char(appt_date,'dd/mm/rrrr') appt_date1,appt_date,referral_id, nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time, appt_slab_from_time appt_slab_from_time1, nvl(to_char(appt_slab_to_time,'hh24:mi'),' ')appt_slab_to_time,nvl(to_char(appt_duration,'hh24:mi'),' ')appt_duration,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc , OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC ,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name ,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by,sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') added_by,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, FACILITY_ID,  to_char(modified_date,'dd/mm/yyyy hh24:mi') modified_date ,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')  SPECIALITY_DESC , SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1)FACILITY_NAME ,appt_status,ORDER_CATALOG_CODE,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,GENDER ,oth_contact_no,get_age(DATE_OF_BIRTH) age,(select DECEASED_YN from mp_patient where patient_id=oa_appt_patient_vw.patient_id) DECEASED_YN  from  ");
sqlStr.append("oa_appt_patient_vw ");
sqlStr.append(sql.toString()) ; 
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

try {
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
stmt1	 = conn.createStatement();
if (rs!=null) rs.close();   
rs = stmt.executeQuery(sqlStr.toString());






%>
<!DOCTYPE html> 
<html> 
<head> 
<title>Appointments View</title> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" /> 
<link rel="stylesheet" href="ipad.css" />  
<script src="http://code.jquery.com/jquery-1.5.2.min.js"></script> 
<script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>


<script type="text/javascript">
/*
 $(document).bind("swipe", function(event, data){
	//alert("helloo")
	event.preventDefault();	
 });
 */
 /*
 $(document).bind("mobileinit", function(){ 
	 alert("hello")
	 $.extend($.mobile, {        loadingMessage: "Chargement en cours..."      
		 });    
});
 */
 /*
 $("#page12").live("pagebeforecreate", function() {
		// Asynchronously include a footer template
	$.mobile.loadingMessage = 'Loading...';	
	$.mobile.pageLoading();
	//alert("hitapp");
		})
		*/
 $(document).bind("mobileinit", function () {
     // As of Beta 2, jQuery Mobile's Ajax navigation does not work in all cases (e.g.,
     // when navigating from a mobile to a non-mobile page, or when clicking "back"
     // after a form post), hence disabling it.
     $.mobile.ajaxEnabled = false;
     $.mobile.loadingMessage = 'loading';

 });
 $(document).ready(function () {
	// alert("hihih");
	 window.parent.HideLoadingMsg();
 });
// alert("loading")
function openPatient(patientid)
 {
	// alert("hi");
	// window.parent.location ="Appointment.html";
	// $('#page12').html("Loading.....")
	//alert(patientid);
	 window.parent.slidee("true");
	// window.location ="Appointment.html";
	/*
	var myBars = 'directories=no,location=no,menubar=no,status=no' ;
			var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
			//var myFeatures = myBars + ', ' + myOptions ;
			var myFeatures =  myOptions ;
			var ecisWindow = open( 'iPadWidget.html', 'iPadWidget.html', myFeatures,false ) ;

	*/
	 //window.parent.location ="iPadWidget.html";
	
	window.parent.loadwidgets(patientid);
	
	//window.open("Appointment.html");
 }
 function showCriteria()
 {
	 $('#divSrchCriteria').slideToggle('fast');
 }
 function showLoadingMsg()
 {
 	$.mobile.pageLoading();
 }
 /*
 function HideLoadingMsg()
 {
 	 $.mobile.pageLoading(true);
 }
 */
 function test()
 {
	 var i = 0;
		// alert("hihih");
		
	 //$('#divcnt').append("<table style='height:1000px;width:100%' border = '1'><tr><td><span class='lz-list-label'>Naren</span></td><td><img src='human.png'></img> </td></tr></table>")
 }
 </script>
    
<body >
  
    <section id="page12" data-role="page"  >  
   <form>
   <div id = "divSrch"  data-role ="none" class="dvApp" onclick = "showCriteria()" >
  
  <span class = "spanDvsrch">Search Criteria</span> 
  <img src = "Heading-Panel-down-Arrow.png" class = "imgg"></img>
 
  
  </div>
  
  
  <div id="divSrchCriteria"  data-inset = "true" data-role = "content" data-theme = "d" style = "display:none;height:200px">
   <table border = "0" style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0">
   <tr width = "100%" style = "height:30%">
      <td width = "50%" align = "center">
     <!--   <div data-role="fieldcontain"> -->

      <label for="sample">View List</label>
      <select id = "sample" name = "sample"   data-native-menu="true"  data-inline="true" >
       <option value="choose" data-placeholder="true">Choose...</option>
       <option>sample content1</option>
        <option>sample content2</option>
         <option>sample content3</option>
        <option>sample content4</option>  
         
       
      </select>
     
     <!--   </div>  -->
      </td>
      <td width = "50%" align = "center">
      <input type = "search"  value = "PatientID"/>
      </td>
   </tr>
   <tr width = "100%" style = "height:30%">
        <td width = "50%" align = "center">
        <label for = "txtprac">Practitioner</label>
        <input type = "search"  value = "PatientID" id ="txtprac" name = "txtprac"/>
        </td>
        <td width = "50%" align = "center">
        <input type = "search"  value = "Clinic"/>
        
        </td>  
   </tr>
   <tr width = "100%" style = "height:20%">
        <td width = "50%"></td>
        <td width = "50%" align = "center">
          <input type = "button" value = "search" data-inline="true" />  <input type = "button" value = "clear"  data-inline="true" />
        </td>  
   </tr>
   </table>
   </div> 
   
   
  <div  data-role ="none" class ="dvApp">
  <span class = "spanDvsrch"> Appointment List</span> 
 
 </div>

 
  
  
  
  <div id = 'divcnt'  data-role = "content" class = 'divcontent' >
 
  <ul data-role="listview" id="uiapp">
  <%
  int u = 1;
  while (  rs.next() ){ 
  %>
  <!--  
 
 
  -->
  <li class ="ui-btn-text-data<%=u %>"  >   <a href="#" rel ="external" style = "height:65px"> 
  
                  
                 
                    <ul style="list-style-type: none;" >
                  	  <li class="firstleftUl">
                  	    
                  	       <img src="human.png"></img> 
                  	    
                    	</li>
                    
                    </ul>
                    <ul style="list-style-type: none;" >
                  	  <li class="leftUl">
                  	      <p onclick = "openPatient('<%=rs.getString("patient_id")%>')"><span class="lz-list-label-Patient" ><%=rs.getString("patient_name")%></span>&nbsp;&nbsp;&nbsp;<span class = "lz-list-label-Patient"><%=rs.getString("patient_id")%></span></p>
                      		  <p>
                       			  <span class="lz-list-label">Appointment No.:</span><span class="lz-list-data"><%=rs.getString("appt_ref_no")%></span>
                       		</p>
                       		
                       		<p>
                       			  <span class="lz-list-label">Practitioner.:</span><span class="lz-list-data"><%=rs.getString("practitioner_full_name")%></span>
                       		</p>
                    	</li>
                    
                    </ul>
                    <ul  style = "list-style-type: none"  >
                    		 <li class="rightUl">
                      			  <p>
                           			 <span class="lz-list-label"><%=rs.getString("gender")%>/<%=rs.getString("age")%></span> 
                       			 </p>
                       			 
                          		  
                            		
                            		 
                            		<p>
                               			 <span class="lz-list-label">Appointment Date.:</span> <span class="lz-list-data"><%=rs.getString("appt_date1")%></span> 
                            		</p>
                    		</li>
                </ul>
                
                <ul  style = "list-style-type: none"  >
                    		 <li class="lastrightUl">
                      			  <p>
                          		  
                          		     
                          		      
                               			 <span class="lz-list-label">LOC.:</span>
                               		
                               			
                               			  <span class="lz-list-data"><%=rs.getString("clinic_code")%></span> 
                               				 
                            		</p>
                    		</li>
                </ul>
                   </a> 
                </li>
 
  

    
   <%
    if(u==1)
    {
    	u = u +1;
    }
    else
    {
    	u = u -1;
    }
  }//while
  %>
    
  
 
 
  </ul>
  
  </div>
   
  <input type = "hidden" name ="hdComp" value ="csc" />
</form>
       </section>  
       
     

   
<%
}catch ( Exception e ){
	out.println("Exception " + e);
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
    

