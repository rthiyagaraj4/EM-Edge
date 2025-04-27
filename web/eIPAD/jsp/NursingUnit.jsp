
<%@page import="java.util.*,java.util.List,java.sql.*,eIPAD.*,eIPAD.HealthObjects.*,eIPAD.sfs.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");

Boolean bRadioCode = true;
Boolean bRadioDesc = false;
String strPostBack = "";
String sfacility_id = "";
String sclinicianId = "";
String sPracId = "";
String sPractionerId = "";
String sSearchBy = "" ;
String sSearchCriteria = "" ;
String sSearchText = "";
String SearchBy = "" ;
String SearchCriteria = "" ;
String SearchText = "";

SFSContext oSFSContext = new SFSContext();
oSFSContext.setRequest(request);



if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
{
	sfacility_id = (String)session.getValue("facility_id");
	oSFSContext.setSfacility_id(sfacility_id);
}

if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
{
	sclinicianId = (String)session.getValue("ca_practitioner_id");
	//oSFSContext.setSclinicianId(sclinicianId);
}
if(request.getParameter("sPractionerId") != null && request.getParameter("sPractionerId") != "")
{
	sPractionerId = (String)request.getParameter("sPractionerId");
	oSFSContext.setsPractionerId(sPractionerId);
}

if( sPractionerId!= null && !sPractionerId.equals("")  )
{
	sclinicianId = sPractionerId;
}
oSFSContext.setSclinicianId(sclinicianId);
strPostBack = request.getParameter("hdnIsPostBack");

if(request.getParameter("group1") != null && request.getParameter("group1") != "" )
{
	
	sSearchBy = (String)request.getParameter("group1");
	oSFSContext.setsSearchBy(sSearchBy);
	
	if(sSearchBy != null && sSearchBy.equals("desc")){
		bRadioDesc = true;
		bRadioCode = false;
	}
	
	
}
if(request.getParameter("cmbCriteria") != null && request.getParameter("cmbCriteria") != "" )
{
	sSearchCriteria = (String)request.getParameter("cmbCriteria");
	oSFSContext.setsSearchCriteria(sSearchCriteria);
}	
if(request.getParameter("txtSrchCriteria") != null && request.getParameter("txtSrchCriteria") != "" )
{
	sSearchText = (String)request.getParameter("txtSrchCriteria");
	oSFSContext.setsSearchText(sSearchText);
	}



%>


<!DOCTYPE html> 
<html> 
<head> 
<title>Nursing Unit</title> 
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
 function closeSrch(strCode,strDesc,objTr)
 {
	// alert("hi");
	objTr.style.border = "3px solid #48d1d8";
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
	window.parent.test(strCode,strDesc);
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
     
  <div id = "divSrch"  data-role ="none" class="dvApp" >
    <span class = "spanDvsrch">Nursing Unit</span> 
  
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
			            <table style="width:100%" border = "0" cellspacing = "0" cellpadding = "0">
			             <tr style="width:100%">
			             <td align = "right" valign ="center" >
			               <input type ="button" name='search_btn' id='search_btn' value='Search' class="btnType1"  data-role = "none" onclick = "show(this)"/>
			             </td>
			             <td style="width:7%"></td> 
			             <td> 
			               <input type ="button" name='clear_btn' id='clear_btn' value='Close' class="btnType1"  data-role = "none" onclick = "closeSrch('','',this)"/>
			             </td>  
			             </tr>
			            </table>
			          </td>
			       <!--   <td style="width:2%">&nbsp;</td> --> 
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
   int nRowCount = 1;		       			    
   int nCssCount = 1;  // To display alternate Row Color.
   int nDummyRowcount = 1;
   int nLoopCount = 0;
   int nListSize = 0;
   SFSDetails bean = new SFSDetails();
   List<SFSUnit> objNursingUnitDetails = new ArrayList<SFSUnit>(); 
  
   try {
	   if(strPostBack != null && strPostBack.equals("true"))
	   {
		   oSFSContext.setType(SFSContext.NURSINGUNIT);
   objNursingUnitDetails = bean.getSFSUnit(oSFSContext); 
	   }
  
   nListSize =  objNursingUnitDetails.size();
   //out.println(nListSize);
   SFSUnit oNursingUnit = null;
   if(nListSize > 0)
   {
 	  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount++)
 	  {
 		 oNursingUnit = objNursingUnitDetails.get(nLoopCount);
 		  if(oNursingUnit != null )
		  {
			
		  
	 
	  %>
     <table class = "tbIpContent2" cellpadding = "0" cellspacing = "0"  border = "0">
      <tr class = "trSrchRow<%=nCssCount %>"  onclick = "srchclose('<%=oNursingUnit.getsCode()%>','<%=oNursingUnit.getsDescription()%>',this)">
        <td style="width:30%" align = "left" valign = "center">
          <span class = "srchLabel"><%=oNursingUnit.getsCode()%></span>
        </td>
        <td style="width:70%" align = "left" valign = "center">
            <span class = "srchLabel"><%=oNursingUnit.getsDescription()%></span>
        </td>
        
      </tr>
     </table>
      <%
 		 
		  }
		  nRowCount = nRowCount + 1;
		  if(nCssCount==1)
		  {
			   nCssCount = nCssCount +1;
		  }
		  else
		  {
			  nCssCount = nCssCount -1;
		  }	 
	  }
   }
   else
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
   <input type = "hidden" name = "hdnSearchText" id = "hdnSearchText"  value = "<%=sSearchText %>"/>
   <input type = "hidden" name = "hdnSearchcriteria" id = "hdnSearchcriteria" value = "<%=sSearchCriteria %>" />
   <input type = "hidden" name = "hdnRdCode" id = "hdnRdCode" value = "<%=bRadioCode %>" />
   <input type = "hidden" name = "hdnRdDesc" id = "hdnRdDesc" value = "<%=bRadioDesc%>" />
</form>
 </section>  
       
     

<%
}catch ( Exception e ){
	//out.println(sqlStr.toString() + e);
	e.printStackTrace();
}
finally{

}
   
		
%>
</body>  
    

