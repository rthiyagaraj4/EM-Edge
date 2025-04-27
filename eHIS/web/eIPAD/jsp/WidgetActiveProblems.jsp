<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
    String strEncounterId = "";
	

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
	if(oPatientContext.sEncounterId != null && !oPatientContext.sEncounterId.equals(""))
	{
		strEncounterId = oPatientContext.sEncounterId;
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

function expandactprobdiagwidget()
{
	window.parent.expandwidget6();
}
</script>
</head>
<body>

	<section id="mainSchedule" data-role="page"
		style="background-color: white">

		<div class="dvWidgetHeaderResults">
			<table style="width: 100%" border="0" cellpadding="0" cellspacing="0">
				<tr style="width: 100%">
					<td style="width: 95%" valign="middle"><span
						class="spaDvHeaderResults">Active Problem and Diagnosis</span></td>

					
					<td style="width: 5%" align="center" valign="middle"
						onclick="expandactprobdiagwidget()"><img
						src="../images/Collapse icon.png"></img></td>
				</tr>
			</table>
		</div>
		
		<%
			eIPAD.ProblemDetails bean = new eIPAD.ProblemDetails();
			List<Problem> objProblemDetails = new ArrayList<Problem>();
			int nRowCount = 1; //To hold the rowcount and to limit the row size to 6.		       			    
			int nCssCount = 1; // To display alternate Row Color.
			int nDummyRowcount = 1;
			int nListSize = 0;

			int nLoopCount = 0;
			Problem oProblem = null;

			try {

				objProblemDetails = bean
						.getProblemDetails(oPatientContext);
				nListSize = objProblemDetails.size();

				if (nListSize > 0) {
				%>
				<div data-role="none" class="dvSelectOrderSearchResults">
			<table style="width: 100%; height: 100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr style="width: 100%; height: 100%">
				    <td style="width: 6%" align="left" valign="center">&nbsp;</td>
				    
				    <td style="width: 11%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Encounter ID</span></td>
					<td style="width: 8%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Diag/Prob</span></td>
					<td style="width: 20%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Description</span></td>
					<td style="width: 10%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">By</span></td>	
						<td style="width: 12%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Onset Date</span></td>
                    <td style="width: 12%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Date/Time</span></td>
					<td style="width: 7%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Severity</span></td>
					<td style="width: 7%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Accuracy</span></td>
					<td style="width: 7%;word-break:break-all" align="left" valign="center"><span
						class="spanSelectOrderSearchResults">Status</span></td>
				
				</tr>
			</table>
		</div>
				<% 	
					for (nLoopCount = 0; nLoopCount < nListSize; nLoopCount++) {

						oProblem  = objProblemDetails.get(nLoopCount);
								
						if (oProblem  != null) {
		%>
		<table class="tbIpContent2" border="0" cellpadding="0" cellspacing="0"
			style="height: 30px">
			<tr class="dvSelectOrderRow<%=nCssCount%>">
			<td style="width: 1%" align="left" valign="center">&nbsp;</td>
			<%if(oProblem.getScurrenstate().equals("problems")){%>
		    <td style = "width: 1.5%;word-break:break-all" align="center" valign = "center"><img src="../images/Blue Bullet.png"></img></td>
		    <%}else{%>
		    <td style = "width: 1.5%;word-break:break-all" align="center" valign = "center"><img src="../images/Yellow Bullet.png"></img></td>
			
			<%}%>
			<td style="width: 1%" align="left" valign="center">&nbsp;</td>
			<%if(oProblem.getsEncounterID().equals(strEncounterId)){%>
			<td style = "width: 1.5%;word-break:break-all" align="center" valign = "center"><img src="../images/Dark Blue.png"></img></td>
			 <%}else{%>
			 <td style = "width: 1.5%;word-break:break-all" align="center" valign = "center">&nbsp;</td> 
			 <%}%>		
			<td style="width: 1%" align="left" valign="center">&nbsp;</td>
			    <td style="width: 11%; height: 100%;word-break:break-all" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oProblem.getsEncounterID()%></span>

				</td>
			
				<td style="width: 8%; height: 100%;word-break:break-all" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oProblem.getsDiagnosisProblem()%></span>

				</td>
				<td style="width: 20%; height: 100%;word-break:break-all" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oProblem.getsProblemDesc()%></span>
				

				</td>
				<td style="width: 10%; height: 100%;word-break:break-all" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oProblem.getsPracName()%></span>

				</td>
				<td style="width: 12%; height: 100%;word-break:break-all" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oProblem.getsOnsetDate()%></span>

				</td>
				
                <td style="width: 12%; height: 100%;word-break:break-all" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oProblem.getsDateTime()%></span>

				</td>
				<td style="width: 7%; height: 100%;word-break:break-all" align="left" valign="center">

					<span class="spanSelectOrderRows1"><%=oProblem.getsProblemSevereity()%></span>

				</td>
				<td style="width: 7%; height: 100%;word-break:break-all" align="left" valign="center">

					<span class="spanSelectOrderRows1"><%=oProblem.getsProblemAccuracy()%></span>

				</td>
				<td style="width: 7%; height: 100%;word-break:break-all" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oProblem.getsStatus()%></span>

				</td>
				
				
				
			</tr>
		</table>
	
		<%
			}
						nRowCount = nRowCount + 1;
						if (nCssCount == 1) {
							nCssCount = nCssCount + 1;
						} else {
							nCssCount = nCssCount - 1;
						}

					}//for
			%>
			<table class = "tbproblegends" border = "0" cellpadding = "0" cellspacing = "0" >
			<tr style = "width:100%;height:100%">
				  
				  <td style = "width:25%;height:100%">
				    <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					         <tr style = "width:100%;height:100%">
					         <td style="width: 10%" align="left" valign="center">&nbsp;</td>
					           <td style = "width:90%;" align="left" valign="center"><span class="spprobLegends">Legends</span></td>
					           
					        </tr>
					        
					     </table>
				  </td>
				   <td style = "width:25%;height:100%"> 
				    <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					         <tr style = "width:100%;height:100%">
					         <td style="width: 10%" align="left" valign="center"><img src="../images/Blue Bullet.png"></img></td>
					         <td style="width: 1%" align="left" valign="center">&nbsp;</td>
					           <td style = "width:89%;" align="left" valign="center"><span class="spprobLegends">Problem</span></td>
					           
					        </tr>
					     </table>
				  </td>
				   <td style = "width:25%;height:100%"> 
				    <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					         <tr style = "width:100%;height:100%">
					         <td style="width: 10%" align="left" valign="center"><img src="../images/Yellow Bullet.png"></img></td>
					         <td style="width: 1%" align="left" valign="center">&nbsp;</td>
					           <td style = "width:89%;" align="left" valign="center"><span class="spprobLegends">Differentials</span></td>
					           
					        </tr>
					     </table>
				  </td>
				   <td style = "width:25%;height:100%"> 
				    <table style = "width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					         <tr style = "width:100%;height:100%">
					         <td style="width: 10%" align="left" valign="center"><img src="../images/Dark Blue.png"></img></td>
					         <td style="width: 1%" align="left" valign="center">&nbsp;</td>
					           <td style = "width:89%;" align="left" valign="center"><span class="spprobLegends">Current Encounter</span></td>
					           
					        </tr>
					     </table>
				  </td>
				  
			</tr>
		
		
		</table> 
			<% 		
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




</body>
</html>
		

