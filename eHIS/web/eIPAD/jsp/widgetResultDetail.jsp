<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String strPracType = "";
String strRecType = "";
String strRecDate = "";
double resultNum = 0;
String color_cell_indicator = "";
String normalLow = "";
String normalHigh = "";
String hist_data = "";
String descCellInd = "";

PatientContext oPatientContext = new PatientContext();
oPatientContext.request = request;

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

%>
<!DOCTYPE html> 
<html> 
<head> 
<title>jQuery Mobile Application</title> 
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<link rel="stylesheet" href="../css/ipadAllergyContent.css" />

<script>
var bHeaderImage = false;
var bChildDetails = true;
function DisplayOrHideDetails(HeaderName,objImg)
{
	
	
	 var imgPath = objImg.src; 
	 if( imgPath.indexOf("Expanded") != -1 )
		 {
		 objImg.src = "../images/More group icon main.png";
			$("[data-class = '" + HeaderName + "']").css('display','none');
		 }
	 else
		 {
		 objImg.src = "../images/Expanded Group Icon Main.png";
			$("[data-class = '" + HeaderName + "']").css('display','block');
		 }
	 var src = "../images/Expanded group Icon.png";
	// $("[data-image = '" + HeaderName + "']").css('background', 'url(' + src + ')'); 
	$("[data-image = '" + HeaderName + "']").attr("src" , src);
	
}
function HideChildRows(evendate,objChildImg)
{
	
	 var imgPath = objChildImg.src; //encodeURIComponent("images/Expanded group Icon.png");
	// alert(imgPath);
	 if( imgPath.indexOf("Expanded") != -1 )
		 {
		   objChildImg.src = "../images/More Group Icon.png";
		   $("[data-childrows = '" + evendate + "']").css('display','none');
		 }
	 else
		 {
		 objChildImg.src = "../images/Expanded group Icon.png";
		 $("[data-childrows = '" + evendate + "']").css('display','block');
		 }
}
function shownotes(histRecType,contrSysId,accessionNum,contrSysEventCode)
{ 
	

	
	var newAccessionNum = escape(accessionNum);
	 document.getElementById("notesContentFrame1").src = "ResultDetailsNotes.jsp?hist_rec_type=" + histRecType + "&contr_sys_id=" + contrSysId + "&accession_num=" + newAccessionNum + "&contr_sys_event_code=" + contrSysEventCode;
	 
	 $.mobile.changePage("#notesContentFrame", "pop", false,false);
	 
}
function closenotes()
{
	 $.mobile.changePage("mainresults","pop", true,false);
	
	}
function changeOrientation(orient)
{
		
	if(orient == "landscape")
	   {
		
	    $("#notesContentFrame1").css('min-height','491px');
	
	    document.getElementById("notesContentFrame1").contentWindow.changeOrientation(orient);
	   
		   
	   }
     else
	   {
    	
    	$("#notesContentFrame1").css('min-height','747px');
 
    	 document.getElementById("notesContentFrame1").contentWindow.changeOrientation(orient);
    
  	   
	   }
 
}
function refreshResultsExpandedview1()
{
	window.parent.refreshResultsExpandedview();
	
	}
function expandwidget3()
{
	
	window.parent.expandwidget2();
}
</script>
</head> 
<body> 

<section id = "mainresults" data-role="page" style = "background-color: #ffffff;padding:0px"> 

					  <div class="dvWidgetHeaderResults" >
						  <table style="width:100%" border = "0" cellpadding = "0" cellspacing = "0">
							  <tr style="width:100%">
								  <td  style="width:90%" valign = "middle" >
								  <span class="spaDvHeaderResults">Results</span>
								  </td>
							      <td  style="width:5%" align = "center" valign = "middle" onclick = "refreshResultsExpandedview1()">
							         <img src = "../images/Refresh1.PNG"></img>
							      </td>
							       <td  style="width:5%" align = "center" valign = "middle" onclick = "expandwidget3()">
							         <img src = "../images/Collapse icon.png"></img>
							      </td>
							  </tr>
						  </table>
					  </div>
					
 <%  
 
 eIPAD.ResultDetails bean = new eIPAD.ResultDetails();
 List<Results> objResultDetails = new ArrayList<Results>(); 
 int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
 int nCssCount = 1;  // To display alternate Row Color.
 int nDummyRowcount = 1;
 int nListSize = 0;

 int nLoopCount = 0;
 Results oResults = null;
 
 try {
	
	 objResultDetails = bean.getResultDetails(oPatientContext);
	 nListSize =  objResultDetails.size();

	 if(nListSize > 0)
	 {
		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
		  {
			  
			  oResults = objResultDetails.get(nLoopCount);
			  if(oResults != null )
			  {

				  color_cell_indicator = oResults.sNormalRangeSymbol;
				  normalLow = oResults.sNormalLow;
				  normalHigh = oResults.sNormalHigh;
				  resultNum = oResults.sResultNum;
				  hist_data = oResults.sHistData;
				  descCellInd = oResults.sDescCellIndicator;
  %>
  
  <%if(!strRecType.equals(oResults.sHistRecTypeDesc)) 
  {
  %>
   <table style = "width:100%;border: 1px solid #afb0b0 " border = "0" cellspacing = "0" cellpadding = "0" >
      <tr class = 'trResultsHeader'  >
         <td style = 'width:5%' align = "center" valign = "middle">
           <img src = "../images/More group icon main.png" onclick = "DisplayOrHideDetails('<%= oResults.sHistRecTypeDesc%>' , this)"></img>
         </td>
          <td style = 'width:95%' align = 'left' >
              <span class = 'spWidHeaderResluts'><b><%= oResults.sHistRecTypeDesc%></b></span>
              
          </td>
      </tr>
     </table> 
     <%
   }
     %>
     
   <%
   if(!strRecDate.equals(oResults.sEventDateTime )) 
   {
   %>  
    <div data-class = "<%= oResults.sHistRecTypeDesc%>" style = "display:none;padding:0px" data-role = "none">
    
    <table style = "width:100%" border = "0" cellspacing = "0" cellpadding = "0">
     <tr class = "trResultDate" >
        <td style = 'width:5%;height:100%'> </td>
        <td style = 'width:95%;height:100%'>
           <table style= 'width:100%;height:100%' border = "0" cellspacing = '0' cellpadding = '0' class = "tbResultDate">
              <tr style = 'width:100%;height:100%'>
                <td style = 'width:4%' align = "center" valign = "middle"> 
                  <img src = "../images/Expanded group Icon.png" style = "margin-top: 3px" onclick = "HideChildRows('<%=oResults.sEventDateTime %>' , this)" data-image = "<%= oResults.sHistRecTypeDesc%>"></img>
                </td>
                <td style = 'width:96%' valign = "center"><span class = "spaResultsDate"><%=oResults.sEventDateTime %></span> 
               
                </td>
              </tr>
           </table>
        </td>
     </tr>
     </table> 
   </div> 
     <%
   }
     %>  
      <div data-role = "none" data-class = "<%= oResults.sHistRecTypeDesc%>" style = "display:none" data-childrows = "<%=oResults.sEventDateTime %>">
      <table style = "width:100%" border = "0" cellspacing = "0" cellpadding = "0">
     <tr class = "trResultDetails" >
      
        <td style = 'width:5%'> </td>
        <td style = 'width:95%'>
          
           <table style= 'width:100%;height:100%' border = "0" cellspacing = '0' cellpadding = '0' class = "tbResultDetails">
              <tr style = 'width:100%;height:100%'>
                <td style = 'width:4%'> </td>
                <td style = 'width:96%' valign = "center">
                   <table style = 'width:100%;height:100%' border = '0' cellspacing = '0' cellpadding = '0'>
                      <tr style = 'width:100%;height:100%'>
                       
                       <td style = 'width:96%'> 
                           <table style = 'width:100%' border = '0' cellspacing = '0' cellpadding = '0'>
                             <tr style = 'height : 25px'>
                               <td style = 'width:50%' valign = 'center' > 
                               <span class = 'spanResultDetails'> <%=oResults.sEventDesc%> </span>
                               </td>
                               <td style = 'width:25%' valign = 'center' > 
                                  <span class = 'spanResultDetails'> Time : <%=oResults.sEventTime  %> </span> </td>
                                    
                                     <td style = 'width:25%' valign = 'center' >
                                     <span class = 'spanResultDetails'> <%=oResults.sCareFlowDetail%> </span> 
                                  <%
			         if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
			         {
			         %>
			            &nbsp;<img src = "../images/<%=color_cell_indicator%>"> </img>
			         <%
			         }
			         else
			         {//1
			        	 if(!normalLow.equals("") && !normalHigh.equals(""))
			        	 {//2
			        		 if(resultNum>0)
			        		 {//3
			        			 if((resultNum >= Float.parseFloat(normalLow)) && (resultNum <= Float.parseFloat(normalHigh)))
			        			 {//4
			         %> 
			               &nbsp;&nbsp;<img src = "../images/NI_Normal.png"  style = "margin-top : 7px"> </img>
			          
			         <%
			        			 }//e4
			        		 }//e3
			        	 }//e2
			        	 if(!normalLow.equals("") && normalHigh.equals(""))
			        	 {//22
			        		 
			        		 if(resultNum>0)
			        		 {//33
			        			 if(resultNum >= Float.parseFloat(normalLow)) 
			        			 {//44
			        	 %>
			        	        &nbsp;&nbsp;<img src = "../images/NI_Normal.png"  style = "margin-top : 7px"> </img>
			        	        
			           <% 
			        			 }//e44
			        		 }//e33
			        	 }//e22
			        	 
			        	 if(normalLow.equals("") && !normalHigh.equals(""))
			        	 { //222
			        		 if(resultNum>0)
			        		 {//333
			        			 if(resultNum <= Float.parseFloat(normalHigh))
			        			 {//444
			        	  %>
			        	  &nbsp;&nbsp;<img src = "../images/NI_Normal.png" style = "margin-top : 7px"> </img>
			        	  
			      <% 
			        			 }//e444
			        		 }//e333
			        	 }//e222
			       }//end 1
			         %>
			          <% 
			         if(!descCellInd.equals(""))
				{
			        	 
				
			        	 %> 
			        	 &nbsp;<span
									class="spanResultDetails"><b><%=oResults.sDescCellIndicator%></span>	
							<%
			         }
			         %>		
                               </td>
                               
                               
                             </tr>
                             <tr style = 'height : 20px'>
                               <td colspan = '3' valign = 'center' > 
                                  <span class = 'spanResultDetails'> Reported By : <%=oResults.sReportedBy %> </span>
                               </td>
                              </tr>
                              
                              <tr style = 'height : 20px'>
                               <td colspan = '3' valign = 'center' > 
                                  <span class = 'spanResultDetails'> Patient Class : <%=oResults.sPatientClass %></span>
                               </td>
                              </tr>    
                               
                         
                            
                           </table>
                       </td>
                       <td style =  'width:4%' align = "left" valign = "top">
                      <% if(hist_data != null  && !hist_data.trim().equals(""))
                      {
                      %> 
                         <img src = "../images/Grid Note icon.png" style = "margin-top : 2px;" onclick = "shownotes('<%= oResults.sHistRecType%>','<%= oResults.sContrSysId%>','<%= oResults.sAccession_num%>','<%= oResults.sContrSysEventCode%>')">
                         </img>
                       <%
			         }
			         %>
                       </td> 
                           
                      </tr>
                   </table>
                 </td>
              </tr>
           </table>
        </td> 
        
     </tr>
     </table>
     </div>
  	 <%
  	strRecType = oResults.sHistRecTypeDesc;
  	strRecDate = oResults.sEventDateTime; 
			  }//if oresults! = null
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
<section id="notesContentFrame" data-role = "page" style = "background-color: #ffffff;padding:0px">
<div  style = "height:auto;overflow:auto;padding:0px;background-color: #ffffff" data-role = "none">
     <iframe frameborder="0" id="notesContentFrame1" src="" scrolling ="yes" style="padding:0px;display:block" width = "100%"  ></iframe>
     </div>
     </section>
</body>
</html>

