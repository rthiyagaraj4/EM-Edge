<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String strDrug = "";
	

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

function expandAllergywidget()
{
	
	window.parent.expandwidget3();
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
</script>
</head>
<body>

	<section id="mainAllergy" data-role="page"
		style="background-color: white">

		<div class="dvWidgetHeaderResults">
			<table style="width: 100%" border="0" cellpadding="0" cellspacing="0">
				<tr style="width: 100%">
					<td style="width: 95%" valign="middle"><span
						class="spaDvHeaderResults">Allergies</span></td>

					
					<td style="width: 5%" align="center" valign="middle"
						onclick="expandAllergywidget()"><img
						src="../images/Collapse icon.png"></img></td>
				</tr>
			</table>
		</div>
		
		<%
			eIPAD.AllergyDetails bean = new eIPAD.AllergyDetails();
			List<Allergy> objAllergyDetails = new ArrayList<Allergy>();
			int nRowCount = 1; //To hold the rowcount and to limit the row size to 6.		       			    
			int nCssCount = 1; // To display alternate Row Color.
			int nDummyRowcount = 1;
			int nListSize = 0;

			int nLoopCount = 0;
			Allergy oAllergy = null;

			try {

				objAllergyDetails = bean.getAllergyDetails(oPatientContext);
				nListSize = objAllergyDetails.size();

				if (nListSize > 0) {
				%>
				<table class="tbWidgetContent" cellpadding="0" cellspacing="0" border="0">
			

			<tr class="trWidgetSummary12">
				<td class="tdWidImgHeader"></td>
				<td class="tdWidHeader"><span class="spWidHeaderAllergy"><b>Event
							type</b></span></td>
				<td class="tdWidHeader"><span class="spWidHeaderAllergy"><b>Allergy</b></span>
				</td>
				<td class="tdWidHeader"><span class="spWidHeaderAllergy"><b>Onset
							Date</b></span></td>
				<td class="tdWidHeader"><span class="spWidHeaderAllergy"><b>Status</b></span>
				</td>

			</tr>
		</table>
				<% 	
					for (nLoopCount = 0; nLoopCount < nListSize; nLoopCount++) {

						oAllergy = objAllergyDetails.get(nLoopCount);
						if (oAllergy != null) {
							
							 String	Drug = oAllergy.getsAllergyDesc()
									+ oAllergy.getsAllergenDesc()
									+ oAllergy.getsOnsetDate()
									+ oAllergy.getsStatus();
		%>

		<%if(!strDrug.equals(Drug))
  {
  %>
		<table style="width: 100%; border: 1px solid #afb0b0" border="0"
			cellspacing="0" cellpadding="0">
			<tr class='trResultsHeader'>
				<td style='width: 4%' align="center" valign="middle"><img
					src="../images/More group icon main.png"
					onclick="DisplayOrHideDetails('<%=Drug%>' , this)"></img></td>
				<td style='width: 96%' align='left'>
				<table style="width: 100%;" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td style='width: 25%' align='left'><span
								class="spWidHeaderAllergies"><b><%= oAllergy.getsAllergyDesc()%></b></span></td>

							<td style='width: 25%' align='left'><span
								class="spWidHeaderAllergies"><b><%= oAllergy.getsAllergenDesc()%></b></span></td>
							<td style='width: 25%' align='left'><span
								class="spWidHeaderAllergies"><b><%= oAllergy.getsOnsetDate()%></b></span></td>
							<td style='width: 25%' align='left'><span
								class="spWidHeaderAllergies"><b><%= oAllergy.getsStatus()%></b></span></td>


						</tr>
					</table>
				</td>
			</tr>
		</table>
		<div data-role = "none" data-class = "<%=Drug%>" style = "display:none" >
		<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="trAllergySummary" style='width: 3%'></td>
				<td class="trAllergSummary" style='width: 97%'>
					<table style="width: 100%;" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td style='width: 25%' align='left'><span
								class="spaDvContentAllergies"><b>Reaction Date </b></span></td>

							<td style='width: 25%' align='left'><span
								class="spaDvContentAllergies"><b>Reaction Description</b></span></td>
							<td style='width: 25%' align='left'><span
								class="spaDvContentAllergies"><b>Severity</b></span></td>
							<td style='width: 25%' align='left'><span
								class="spaDvContentAllergies"><b>Site Of Reaction</b></span></td>


						</tr>
					</table>
				</td>
			</tr>
		</table>
		</div>
		<%
   }
		
     %>
      <div data-role = "none" data-class = "<%=Drug%>" style = "display:none" >
		
		
		<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td class="trAllergySum" style='width: 3%'></td>

				<td class="trAllSummary<%=nCssCount %>" style='width: 97%'>
					<table style="width: 100%;" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td style='width: 25%' align='left'><span
								class="spaDvAllergyDetails"><b><%= oAllergy.getsReactiondate()%></span></td>

							<td style='width: 25%' align='left'><span
								class="spaDvAllergyDetails"><b><%= oAllergy.getsReactionDesc()%></b></span></td>
							<td style='width: 25%' align='left'><span
								class="spaDvAllergyDetails"><b><%= oAllergy.getsSevereityDesc()%>
								</b></span></td>
							<td style='width: 25%' align='left'><span
								class="spaDvAllergyDetails"><b><%= oAllergy.getsReactionSite()%></b></span></td>


						</tr>
					</table>
				</td>
			</tr>
		</table>
		 </div>
		<%
			
		strDrug = Drug;
						}//if oAllergy !=null
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




</body>
</html>











