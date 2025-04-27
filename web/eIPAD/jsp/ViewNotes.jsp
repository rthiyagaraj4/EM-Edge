<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strNotesDesc = "";
//String strPeriod = "OW";
//String strEncounterChk = "true";
//String strPeriod = "OD";
String strTodate = "";
String strFromDate = "";
String strPostBack = "";
String strInterval = "";
int value = 1;
String strPatientId = "";
String strEncounterId = "";


PatientContext oPatientContext = new PatientContext();
oPatientContext.request = request;
String strRowCount = "";
if(session.getValue("facility_id") != null )
{
	oPatientContext.sFacilityId = (String)session.getValue("facility_id");
}
if(session.getValue("ca_practitioner_id") != null)
{
	oPatientContext.sClinicianId  = (String)session.getValue("ca_practitioner_id");
}
if(session.getValue("practitioner_type") != null )
{
	oPatientContext.sPracType = (String)session.getValue("practitioner_type");
}
if(session.getValue("PatientID") != null)
{
	oPatientContext.sPatientId = (String)session.getValue("PatientID");
}
if(session.getValue("EpisodeId") != null )
{
	oPatientContext.sEncounterId = (String)session.getValue("EpisodeId");
}
if(session.getValue("login_user") != null )
{
	oPatientContext.loggedInUser = (String)session.getValue("login_user");
}
if(session.getValue("responsibility_id") != null )
{
	oPatientContext.responsibilityID = (String)session.getValue("responsibility_id");
}
oPatientContext.sEncounterCheck = "true";
oPatientContext.sPeriod = "OD";
//strPatientId = "HE00001197";
//strEncounterId = "10094030";

oPatientContext.sTodate = DateUtils.getCurrentDate("DMY", "en");

strPostBack = request.getParameter("hdnPostBack");
if(strPostBack != null && strPostBack.equals("true"))
{
	if(request.getParameter("cmbCriteria") != null)
	{
		oPatientContext.sPeriod = request.getParameter("cmbCriteria");
	}
	oPatientContext.sEncounterCheck = request.getParameter("hdnEncounterChk");
}

if(oPatientContext.sTodate != null && !oPatientContext.sTodate.equals(""))
{
	if(oPatientContext.sPeriod.equals("OW") )
	{
		strInterval = "w";
	}
	if(oPatientContext.sPeriod.equals("OM") )
	{
		strInterval = "M";
	}
	if(oPatientContext.sPeriod.equals("OY") )
	{
		strInterval = "Y";
	}
	if(oPatientContext.sPeriod.equals("OD") )
	{
		strInterval = "d";
	}
	if(oPatientContext.sPeriod.equals("TD") )
	{
		strInterval = "d";
		value = 3;
	}
	oPatientContext.sFromDate = DateUtils.minusDate(oPatientContext.sTodate, "DMY", "en", value, strInterval);
}











%>


<!DOCTYPE html> 
<html> 
<head> 
<title>jQuery Mobile Application</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<link rel="stylesheet" href="../css/iPadViewNotes.css" />

<script>
function Loading()
{
	window.parent.hideLoading();
	 document.getElementById("cmbCriteria").value =  document.getElementById('hdnPeriod').value;
	 if(document.getElementById("hdnEncounterChk").value == "true")
     {
		 document.getElementById("chkEncounter").checked = true;
		// alert("hello");
	 }
	 else
	{
		 document.getElementById("chkEncounter").checked = false;
	}
	 
	  var dvheight = $("#dvNotesMenu").height() + "px";
		
	    $("#notesContentFrame").css('height', dvheight);
	// document.getElementById("notesContentFrame").style.height = document.getElementById("dvNotesMenu").style.height ;
}
function changeOrientation(orient)
{
		//alert(orient);
	if(orient == "landscape")
	   {
	//	document.getElementById("dvNotesMenu").style.min-height = "492px";
	    $("#dvNotesMenu").css('min-height','421px');
	    
	    var dvheight = $("#dvNotesMenu").height() + "px";
		//document.getElementById("notesContentFrame").style.height = $("#dvNotesMenu").height() ;
		//alert(document.getElementById("notesContentFrame").style.height);
		//alert($("#dvNotesMenu").height());
	    $("#notesContentFrame").css('height', dvheight);
	   }
     else
	   {
    	 //alert(document.getElementById("dvNotesMenu").style.min-height);
    	// document.getElementById("dvNotesMenu").style.min-height = "748px";
    	$("#dvNotesMenu").css('min-height','677px');
    	 var dvheight = $("#dvNotesMenu").height() + "px";
    	 $("#notesContentFrame").css('height', dvheight);
    	 //document.getElementById("notesContentFrame").style.height = $("#dvNotesMenu").height() ;
    	 //alert(document.getElementById("dvNotesMenu").style.height);
    	 //alert(document.getElementById("notesContentFrame").style.height);
	   }
 
}
function loadWidgets()
{
	window.parent.showLoadingMsg();
}
function showNotesContent(notesdesc,accessnum)
{
	//alert("hi");
	//var url = "jsp/ViewNotescontent.jsp?accession_num=" + accessnum + "&notesHeader=" + notesdesc;
	var newAccessionNum = escape(accessnum);
	var url = "ViewNotescontent.jsp?accession_num=" + newAccessionNum + "&notesHeader=" + notesdesc;
	//var url = "../eCA/jsp/ViewNotescontent.jsp?accession_num=" + accessnum + "&notesHeader=" + notesdesc;
	//var url = "../eCA/jsp/aa.html";
	//alert(url);
	document.getElementById("notesContentFrame").src = url;
	window.parent.scrolTop();
}
function submitNotesContent(obj)
{
	//hdnPostBack
	obj.style.border = "3px solid #48d1d8";
	document.getElementById("hdnPostBack").value = "true";
	if(document.getElementById("chkEncounter").checked)
		{
		document.getElementById("hdnEncounterChk").value = "true";
		}
	else
		{
		document.getElementById("hdnEncounterChk").value = "false";
		}
	
	document.getElementById("frmNotesContent").submit();
	
}
</script>
</head>

<body onload = "Loading()" style = "background-color : #ffffff">
<section data-role = "page" style = "padding:0px;background-color : #ffffff">
 <form id = "frmNotesContent" >

 <div data-role = "none" class ='divmain' id = 'dvmain'  style="padding:0px" >
   <div data-role = "none" class = "dvViewNotes">
     <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
       <tr style="width:100%;height:100%">
         <td style = "width : 95%" align = "left" valign = "center">
            <span class = "spanViewNotes">View Notes</span>
            
         </td> 
         <td style="width:5%" onclick = "loadWidgets()" align = "center" valign = "middle">
            <img src = "../images/Close.png"></img>
         </td>
       </tr>
     </table>
   </div>
   <div id = "dvCriteria" class = "dvCriteria">
  
      <table style="height:68px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
		
			     <tr style="height:30px;width:100%">
				      <td align = "left" style="width:33%"><span class = "spanPeriod">Period</span></td>
				      <td align = "left" style="width:67%">   
				      </td>
			     </tr>
			     <tr style="height:35px;width:100%">
			      <td align = "left" style="width:33%">
			        <select  class="cmbPeriod" data-role="none" id="cmbCriteria" name = "cmbCriteria"> 
			         <option value = "OD">Last One Day</option> 
                      <option value = "TD">Last Three Days</option>  
			          <option value = "OW">Last One Week</option> 
			          <option value = "OM">Last One Month</option> 
			          <option value = "OY">Last One Year</option> 
					</select> 
			      </td>
			      <td align = "left" style="width:67%" valign = "middle">
			      
			      
			       <table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
			         <tr style = "width:100%;height:100%">
			           <td style = "width:50%;height:100%" valign = "middle" align = "center">
			              <input type = "checkbox" data-role = "none"  class = "chkEncounter" checked = true id = "chkEncounter" name = "chkEncounter"/><span class = "spEncounter">Limit To Current Encounter</span>
			           </td>
			           <td style = "width:50%;height:100%" valign = "middle" align = "left">
			           &nbsp;  &nbsp;
			             <input type ="button" name='search_btn' id='search_btn' value='Search' class="btnType1"  data-role = "none" onclick = "submitNotesContent(this)"/>
			           </td>
			         <tr>
			       </table>
			      </td>
			     
			       
			     </tr>
			     
			     
			     <tr style="height:3px;width:100%">
			       <td>&nbsp;</td>
			     </tr>
		   </table>
   </div>

   <div id = "dvNotesMenu" class = "dvNotesMenu" data-role = "none">
    
          
          <%
          NotesDetail bean = new NotesDetail();
          List<Notes> objNotesDetails = new ArrayList<Notes>(); 
          int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
          int nCssCount = 1;  // To display alternate Row Color.
          int nDummyRowcount = 1;
          int nListSize = 0;

          int nLoopCount = 0;
          Notes oNotes = null;
          try {
        	   objNotesDetails = bean.getNotes(oPatientContext);
        	   if(objNotesDetails != null)
        	      nListSize =  objNotesDetails.size();
        	  
        	 if(nListSize > 0)
            {
            	%>
            	  <table  style = "width:100%;height:auto" border = "0" cellspacing  = "0" cellpadding = "0" class = "TbNotesMenu">
			           <tr style = "width:100%;height:10px">
			            <td style = "width:5%"></td>
			            <td style = "width:95%" align = "left" valign = "middle"> </td>
			          </tr> 
            	<% 
        		 for(nLoopCount = 0 ; nLoopCount < nListSize; nLoopCount ++)
            	{
        			 oNotes = objNotesDetails.get(nLoopCount);	
            		if(oNotes != null)
            		{
	            		if(strNotesDesc != null && !strNotesDesc.equals(oNotes.sNoteTypeDesc))
	            		{
	            		
	                     %>
	                         
					          <tr style = "width:100%;height:20px">
					            <%
					              if(strNotesDesc.equals(""))
					            		  {
					            %>
					            <td style = "width:5%"></td>
					            <td style = "width:95%" align = "left" valign = "middle"> <span class = "spNotesMenu"><%= oNotes.sNoteTypeDesc%></span></td>
					            <%
					            		  }
					              else
					              {
					            %>
					            <td style = "width:5%;border-top : 1px solid #d2d0d0"></td>
					            <td style = "width:95%;border-top : 1px solid #d2d0d0" align = "left" valign = "middle"> <span class = "spNotesMenu"><%= oNotes.sNoteTypeDesc%></span></td>
					            <%
					              }
					            %>
					          </tr>
			          
			           
			          <%
	            		}
			          %>
		            <tr style = "width:100%;height:10px">
		            <td colspan = "2" >
		              
		            </td>
		          </tr>
		          <tr style = "width:100%;height:20px">
		            <td colspan = "2" onclick = "showNotesContent('<%= oNotes.sNoteTypeDesc%>','<%= oNotes.sAccessNum%>')">
		              <span class = "spNotesMenu1"><%= oNotes.sEventDateTime%></span>
		            </td>
		          </tr>
		          <tr style = "width:100%;height:10px">
		            <td colspan = "2" >
		              
		            </td>
		          </tr>
		          
          <%
           strNotesDesc = oNotes.sNoteTypeDesc;
            		}
            	} //for
            %>
              </table>
            <% 	
            } //end if
            else
            {
          %>
             
           <%
            }
           %>
       <!--     -->
        
   </div> 
   <div id = "dvNotesContent" class = "dvNotesContent">
      <%
      if(nListSize == 0)
      {
      %>
       <%= IPADConstants.NORECORDS_HTML%>
      <%
      }
      %> 
      <div style = "height:auto;overflow:auto;padding:0px" data-role = "none">
     <iframe frameborder="0" id="notesContentFrame" src="" scrolling ="yes" style="padding:0px;display:block" width = "100%" ></iframe>
     </div>
   </div>
</div>
<input type ="hidden" name = "hdnPostBack" id = "hdnPostBack" />
<input type ="hidden" name = "hdnEncounterChk" id = "hdnEncounterChk" value = "<%= oPatientContext.sEncounterCheck%>"/>
<input type = "hidden" name = "hdnPeriod" id = "hdnPeriod" value = "<%=oPatientContext.sPeriod%>"/>


</form> 
</section>  
 <%
}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{

}
%>
</body>

</html>

