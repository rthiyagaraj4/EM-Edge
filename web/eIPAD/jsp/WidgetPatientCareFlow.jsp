<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

String resultNum = "";
String color_cell_indicator = "";
String normalLow = "";
String normalHigh = "";
String streventdate = "";
String streventgroupdesc = "";
String streventclass = "";
String textExist = "";
String strEventGroupDesc = "";
String strEventClass = "";
String descCellInd = "";

	PatientContext oPatientContext = new PatientContext();
	oPatientContext.request = request;

	if (session.getValue("facility_id") != null) {
		oPatientContext.sFacilityId = (String) session
				.getValue("facility_id");
	}
	if (session.getValue("ca_practitioner_id") != null) {
		oPatientContext.sClinicianId = (String) session
				.getValue("ca_practitioner_id");
	}
	if (session.getValue("practitioner_type") != null) {
		oPatientContext.sPracType = (String) session
				.getValue("practitioner_type");
	}
	if (session.getValue("PatientID") != null) {
		oPatientContext.sPatientId = (String) session
				.getValue("PatientID");
	}
	if (session.getValue("EpisodeId") != null) {
		oPatientContext.sEncounterId = (String) session
				.getValue("EpisodeId");
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

function expandPatientCareflow()
{
	
	window.parent.expandwidget8();
}
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
function shownotes(histRecType,contrSysId,accessionNum,contrSysEventCode)
{ 
	

	
	var newAccessionNum = escape(accessionNum);
	 document.getElementById("patientcfsFrame1").src = "PatientCFSNotes.jsp?hist_rec_type=" + histRecType + "&contr_sys_id=" + contrSysId + "&accession_num=" + newAccessionNum + "&contr_sys_event_code=" + contrSysEventCode;
	 
	 $.mobile.changePage("#patientcfsFrame", "pop", false,false);
	 
}
function closecfs()
{
	 $.mobile.changePage("mainPatientCFS","pop", true,false);
	
	}
function changeOrientation(orient)
{
		
	if(orient == "landscape")
	   {
		
	    $("#patientcfsFrame1").css('min-height','491px');
	
	    document.getElementById("patientcfsFrame1").contentWindow.changeOrientation(orient);
	   
		   
	   }
     else
	   {
    	
    	$("#patientcfsFrame1").css('min-height','747px');
 
    	 document.getElementById("patientcfsFrame1").contentWindow.changeOrientation(orient);
    
  	   
	   }
 
}
</script>
</head>
<body>

	<section id="mainPatientCFS" data-role="page"
		style="background-color: white">

		<div class="dvWidgetHeaderResults">
			<table style="width: 100%" border="0" cellpadding="0" cellspacing="0">
				<tr style="width: 100%">
					<td style="width: 95%" valign="middle"><span
						class="spaDvHeaderResults">Patient Care Flow Sheet</span></td>

					
					<td style="width: 5%" align="center" valign="middle"
						onclick="expandPatientCareflow()"><img
						src="../images/Collapse icon.png"></img></td>
				</tr>
			</table>
		</div>
		<%
		eIPAD.PatientCFSDetails bean = new eIPAD.PatientCFSDetails();
		List<PatientCFS> objPatientCFSDetails = new ArrayList<PatientCFS>(); 
		int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
		int nCssCount = 1;  // To display alternate Row Color.
		int nDummyRowcount = 1;
		int nListSize = 0;

		int nLoopCount = 0;
		PatientCFS oPatientCFS = null;
		try {
		objPatientCFSDetails = bean.getPatientCFSDetails(oPatientContext);
		nListSize =  objPatientCFSDetails.size();

		if(nListSize > 0)
		{

			 for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
			 {
				 oPatientCFS = objPatientCFSDetails.get(nLoopCount);
				  if(oPatientCFS != null )
				  {
					    color_cell_indicator = oPatientCFS.getsNormalRangeSymbol();
                        normalLow = oPatientCFS.getsNormalLow();
						normalHigh = oPatientCFS.getsNormalHigh();
						resultNum = oPatientCFS.getsResultNum();
						textExist = oPatientCFS.getsTextExist();
						descCellInd = oPatientCFS.getsDescCellIndicator();
						String EventGroupDesc = oPatientCFS.getsEventDate() + oPatientCFS.getsEventClass() + oPatientCFS.getsEventGroupDesc();
						String EventClass = oPatientCFS.getsEventDate() + oPatientCFS.getsEventClass() ; 
						streventgroupdesc = oPatientCFS.getsEventGroupDesc();
						streventclass = oPatientCFS.getsEventClass();
						
				%>

		<%
			if (!streventdate.equals(oPatientCFS.getsEventDate()) ) {
		%>
		<table class = "tbParent"  border="0"
			cellspacing="0" cellpadding="0">
			<tr class='trResultsHeader'>
				<td style='width: 4%' align="center" valign="middle"><img
					src="../images/More group icon main.png"
					onclick="DisplayOrHideDetails('<%=oPatientCFS.getsEventDate()%>' , this)"></img></td>
				<td style='width: 96%' align='left'>
					<table style="width: 100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td style='width: 35%' align='left'><span
								class="spWidHeaderAllergies"><b><%=oPatientCFS.getsEventDate()%></b></span></td>

							

						</tr>
					</table>
				</td>
			</tr>
		</table>

		<%
			}
		%>
		
		<%
   if(!strEventClass.equals(EventClass) && !streventclass.equals(""))
   {
   %> 
		<div data-role="none" data-class="<%=oPatientCFS.getsEventDate()%>"
			style="display: none">


			<table class = "tbParent" border="0"
				cellspacing="0" cellpadding="0">

				<tr class="trpatientcfsSummary">
					<td style='width: 4%;' align="center" valign="middle">&nbsp;</td>

					<td style='width: 96%' align='left'>
						<table style="width: 100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td style='width: 35%' align='left'><span
									class="spaDvAllergyDetails1"><b><%=oPatientCFS.getsEventClass()%></span></td>

								

							</tr>
						</table>

					</td>
				</tr>
			</table>
		</div>
		<%
   }
     %>
     <%
     
   if(!strEventGroupDesc.equals(EventGroupDesc) && !streventgroupdesc.equals("") ) 
   {
   %> 
		<div data-role="none" data-class="<%=oPatientCFS.getsEventDate()%>"
			style="display: none">


			<table class = "tbParent" border="0"
				cellspacing="0" cellpadding="0">

				<tr class="trpatientcfsSummary">
					<td style='width: 4%;' align="center" valign="middle">&nbsp;</td>

					<td style='width: 96%' align='left'>
						<table style="width: 100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td style='width: 35%' align='left'><span
									class="spaDvAllergyDetails1"><b><%=oPatientCFS.getsEventGroupDesc()%></span></td>

								

							</tr>
						</table>

					</td>
				</tr>
			</table>
		</div>
		<%
   }
     %>
     <div data-role = "none" data-class = "<%= oPatientCFS.getsEventDate()%>" style = "display:none" >
      <table class = "tbParent" border="0"
				cellspacing="0" cellpadding="0">

				<tr class="trpatientcfsSummary">
					<td style='width: 10%;' align="center" valign="middle">&nbsp;</td>

					<td style='width: 90%' align='left'>
						<table style="width: 100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td style='width: 25%' align='left'><span
									class="spaDvAllergyDetails1"><b><%=oPatientCFS.getsDesc()%></span></td>
									<td style='width: 40%' align='left'>
									
									
                                <span
									class="spaDvAllergyDetails1"><b><%=oPatientCFS.getsCareFlowDetail()%></span>
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
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//3
			        			 if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)))
			        			 {//4
			         %> 
			               &nbsp;&nbsp;<img src = "../images/NI_Normal.png"  style = "margin-top : 7px"> </img>
			          
			         <%
			        			 }//e4
			        		 }//e3
			        	 }//e2
			        	 if(!normalLow.equals("") && normalHigh.equals(""))
			        	 {//22
			        		 
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//33
			        			 if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) 
			        			 {//44
			        	 %>
			        	        &nbsp;&nbsp;<img src = "../images/NI_Normal.png"  style = "margin-top : 7px"> </img>
			        	        
			           <% 
			        			 }//e44
			        		 }//e33
			        	 }//e22
			        	 
			        	 if(normalLow.equals("") && !normalHigh.equals(""))
			        	 { //222
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//333
			        			 if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
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
			        	 &nbsp;&nbsp;<span
									class="spaDvAllergyDetails1"><b><%=oPatientCFS.getsDescCellIndicator()%></span>	
							<%
			         }
			         %>					
			       </td>
			       <td style='width: 35%' align='left' valign = "top">
			       <% if(textExist != null  && !textExist.trim().equals(""))
                      {
                      %> 
                         <img src = "../images/Grid Note icon.png" style = "margin-top : 2px;" onclick = "shownotes('<%= oPatientCFS.getsHistRecType()%>','<%= oPatientCFS.getsContrSysID()%>','<%= oPatientCFS.getsAccessionNum()%>','<%= oPatientCFS.getsContrSysEventCode()%>')">
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
			</div>
                              
		<%
		streventdate = oPatientCFS.getsEventDate();
		/*streventclass = oPatientCFS.getsEventClass();*/
		/*streventgroupdesc = oPatientCFS.getsEventGroupDesc();*/
		strEventGroupDesc = EventGroupDesc;
		strEventClass = EventClass;
		
						}
						nRowCount = nRowCount + 1;
						if (nCssCount == 1) {
							nCssCount = nCssCount + 1;
						} else {
							nCssCount = nCssCount - 1;
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
		} catch (Exception e) {
			out.println("Exception " + e);
			//out.println(sqlStr.toString());
			e.printStackTrace();
		} finally {

		}
	%>

<section id="patientcfsFrame" data-role = "page" style = "background-color: #ffffff;padding:0px">
<div  style = "height:auto;overflow:auto;padding:0px;background-color: #ffffff" data-role = "none">
     <iframe frameborder="0" id="patientcfsFrame1" src="" scrolling ="yes" style="padding:0px;display:block" width = "100%"  ></iframe>
     </div>
     </section>
     
</body>
</html>











