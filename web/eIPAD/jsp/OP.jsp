
<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String apptfromdate_greg = "04/04/2012";
String appttodate_greg = "05/04/2012";
String patientid = "SO00001819";
StringBuffer sql = new StringBuffer("") ;
sql.append("where");



sql.append("  appt_date between to_date('"+apptfromdate_greg+"','dd/mm/yyyy') and ");
sql.append(" to_date('"+appttodate_greg+"','dd/mm/yyyy')  and patient_id is not null");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");



 
 sqlStr.append("select * from CA_OP_EPISODE_VW where rownum < 15");

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
<title></title> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> 
<link rel="stylesheet" href="../css/ipad.css" />  
<script src="../jquery-1.5.2.min.js"></script> 
<script src="../jquery.mobile-1.0a4.1.min.js"></script> 

<script type="text/javascript">

 $(document).bind("swipe", function(event, data){
	//alert("helloo")
	event.preventDefault();	
 });
 function showCriteria()
 {
	 $('#divSrchCriteria').slideToggle('fast');
 }
 $(document).ready(function () {
	 window.parent.HideLoadingMsg();
 });

 </script>
<body >
 <section id="page1" data-role="page"  > 
  
 <div id = "divSrch"  data-role ="none" class="dvApp" onclick = "showCriteria()">
  <span class = "spanDvsrch">Search Criteria</span> 
  <img src = "Heading-Panel-down-Arrow.png" class = "imgg"></img>
  <!--  <span class = "spanDvsrch">Search Criteria</span> 
  <table style="height:100%;width:100%" border = "1">
  <tr style="height:100%;width:100%">
  <td style="height:100%;width:98%">hi</td>
  <td style="height:100%;width:2%">
	  <table>
	   <tr style="height:20%;width:100%">
	    <td style="height:20%;width:100%">hy</td>
	   </tr>
	  </table>
  </td>
  <tr>
  </table>
 -->
  </div>
  
  
  <div id="divSrchCriteria"  data-inset = "true" data-role = "content" data-theme = "d" style = "display:none;height:200px">
   <table border = "0" style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0">
   <tr width = "100%" style = "height:30%">
      <td width = "50%" align = "center">
      <label for="sample">View List</label>
      <select id = "sample" name = "sample">
       <option>sample content1</option>
        <option>sample content2</option>
      </select>
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
 <span class = "spanDvsrch"> OutPatients List</span>
   <table class = "tbApp" border = "0"> 

<tr style = "width:100%;height:100%"> 
<td style = "width:40%;height:100%"></td>
<td style = "width:60%;height:100%" align ="center" valign = "middle"> 

<select data-inline="true" class="cmb" data-role="none"> 

<option>Patient ID</option> 
<option>Patient ID</option> 
<option>Patient ID</option> 
<option>Patient ID</option>

</select> 

</td> 

</tr> 

</table> 
  </div>
 
 
     <div id = 'divcnt' data-role = 'content' class = 'divcontent' >
  <ul data-role="listview" >
  <%
  int u = 1;
  while (  rs.next() ){ 
  %>
 
<li class ="ui-btn-text-data<%=u %>"  >   <a href="#" rel ="external" style = "height:65px"> 
  
  
                 
                    <ul style="list-style-type: none;" >
                  	  <li class="firstleftUl">
                  	    
                  	       <img src="human.png"></img> 
                  	    
                    	</li>
                    
                    </ul>
                    <ul style="list-style-type: none;" >
                  	  <li class="leftUl">
                  	      <p onclick = "openPatient()"><span class="lz-list-label-Patient" ><%=rs.getString("patient_name")%></span>&nbsp;&nbsp;&nbsp;<span class = "lz-list-label-Patient"><%=rs.getString("patient_id")%></span></p>
                      		  <p>
                       			  <span class="lz-list-label">Room No.:</span><span class="lz-list-data"><%=rs.getString("service_code")%></span>
                       		</p>
                       		
                       		<p>
                       			  <span class="lz-list-label">Practitioner.:</span><span class="lz-list-data"><%=rs.getString("physician_name")%></span>
                       		</p>
                    	</li>
                    
                    </ul>
                    <ul  style = "list-style-type: none"  >
                    		 <li class="rightUl">
                      			  <p>
                           			 <span class="lz-list-label"><%=rs.getString("sex")%>/30M</span> 
                       			 </p>
                       			 
                          		  
                            		
                            		 
                            		<p>
                               			 <span class="lz-list-label">Bed No.:</span> <span class="lz-list-data"><%=rs.getString("queue_status")%></span> 
                            		</p>
                    		</li>
                </ul>
                
                <ul  style = "list-style-type: none"  >
                    		 <li class="lastrightUl">
                      			  <p>
                          		  
                          		     
                          		      
                               			 <span class="lz-list-label">LOC.:</span>
                               		
                               			
                               			  <span class="lz-list-data"><%=rs.getString("locn_code")%></span> 
                               				 
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
  
<footer data-role = "none" >
  
<table class = "tblegends" border = "0" cellpadding = "0" cellspacing = "0">
<tr style = "width:100%;height:100%">
  <td style = "width:42%;height:100%" class="tdlegends"> 
  
     <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
         <tr style = "width:100%;height:50%">
           <td style = "width:14%;height:100%" align="center"><img src="Legend-Critical.png" style="vertical-align:middle;padding-top:5px"></img> </td>
           <td style = "width:14%;height:100%" align="center"><img src="Legend-semi-critical.png" style="vertical-align:middle;padding-top:5px"></img> </td>
           <td style = "width:14%;height:100%" align="center"><img src="Legend-non-critical.png" style="vertical-align:middle;padding-top:5px"></img> </td>
        </tr>
        <tr style = "width:100%;height:50%">
           <td style = "width:14%;height:100%" align="center" nowrap ="false"><span class="spLegends">Critical </span></td>
           <td style = "width:14%;height:100%" align="center" nowrap ="false"><span class="spLegends">Semi-Critical</span> </td>
           <td style = "width:14%;height:100%" align="center" nowrap ="false"><span class="spLegends">Non Critical </span></td>
        </tr>
     </table>
     
  <td>
  
  
  <td style = "width:42%;height:100%" class="tdlegends"> 
	  <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
	         <tr style = "width:100%;height:50%">
	           <td style = "width:14%;height:100%" align="center" ><img src="Legend-Deceased.png" style="vertical-align:middle;padding-top:5px"></img> </td>
	           <td style = "width:14%;height:100%" align="center" ><img src="Legend-newborn-exists.png" style="vertical-align:middle;padding-top:5px"></img> </td>
	           <td style = "width:14%;height:100%" align="center" ><img src="Legend-Discharged.png" style="vertical-align:middle;padding-top:5px"></img> </td>
	        </tr>
	        <tr style = "width:100%;height:50%">
	           <td style = "width:14%;height:100%" align="center" nowrap ="false"><span class="spLegends">Deceased </span></td>
	           <td style = "width:14%;height:100%" align="center" nowrap ="false"><span class="spLegends">Newborn Exists</span> </td>
	           <td style = "width:14%;height:100%" align="center" nowrap ="false"><span class="spLegends">Discharged </span></td>
	        </tr>
	     </table>
  
  <td>
  <td style = "width:16%;height:100%"> 
    <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
	         <tr style = "width:100%;height:50%">
	           <td style = "width:100%;height:100%" align="center"><img src="Legend-no-PP-relationship.png" style="vertical-align:middle;padding-top:5px"></img> </td>
	           
	        </tr>
	        <tr style = "width:100%;height:50%">
	           <td style = "width:100%;height:100%" align="center" nowrap ="false"><span class="spLegends">No PP Relationship </span></td>
	           
	        </tr>
	     </table>
  <td>
<tr>
</table>
</footer>

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

