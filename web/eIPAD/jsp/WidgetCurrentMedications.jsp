<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	

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

function expandCurrentMedicationwidget()
{
	window.parent.expandwidgetsecond();
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
						class="spaDvHeaderResults">Current Medications</span></td>

					
					<td style="width: 5%" align="center" valign="middle"
						onclick="expandCurrentMedicationwidget()"><img
						src="../images/Collapse icon.png"></img></td>
				</tr>
			</table>
		</div>
		
		<%
		eIPAD.CurrentMedicationDetails bean = new eIPAD.CurrentMedicationDetails();
		List<CurrentMedications> objCurrentMedications = new ArrayList<CurrentMedications>(); 
		int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
		int nCssCount = 1;  // To display alternate Row Color.
		int nDummyRowcount = 1;
		int nListSize = 0;

		int nLoopCount = 0;
		CurrentMedications oCurrentMedications = null;


		try {
		objCurrentMedications = bean.getCurrentMedicationsDetails(oPatientContext);
		nListSize =  objCurrentMedications.size();
		if(nListSize > 0)
		{
			%>
			<div data-role="none" class="dvSelectOrderSearchResults">
				<table style="width: 100%; height: 100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr style="width: 100%; height: 100%">
					    <td style="width: 2%" align="left" valign="center">&nbsp;</td>
						<td style="width: 15%" align="left" valign="center"><span
							class="spanSelectOrderSearchResults">OrderID</span></td>
						<td style="width: 40%" align="left" valign="center"><span
							class="spanSelectOrderSearchResults">Order Catalog</span></td>
						<td style="width: 10%" align="left" valign="center"><span
							class="spanSelectOrderSearchResults">Quantity</span></td>
						<td style="width: 23%" align="left" valign="center"><span
							class="spanSelectOrderSearchResults">Ordered By</span></td>
						<td style="width: 10%" align="left" valign="center"><span
							class="spanSelectOrderSearchResults">Priority</span></td>
						
					</tr>
				</table>
		  </div>
			<% 
			  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
			  {
				  oCurrentMedications= objCurrentMedications.get(nLoopCount);
				  if(oCurrentMedications != null) 
				  {
		%>
		<table class="tbIpContent2" border="0" cellpadding="0" cellspacing="0"
			style="height: 36px">
			<tr class="dvSelectOrderRow<%=nCssCount%>">
			<td style="width: 2%" align="left" valign="center">&nbsp;</td>
				<td style="width: 15%; height: 100%" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oCurrentMedications.getsOrderID()%></span>

				</td>
				<td style="width: 40%; height: 100%" align="left" valign="center">
					<span class="spanSelectOrderRows1"><b><%=oCurrentMedications.getsCatalogDesc()%></b><%=oCurrentMedications.getsOrderCatalog()%></span>
				

				</td>
				<td style="width: 10%; height: 100%" align="left" valign="center">

					<span class="spanSelectOrderRows1"><%=oCurrentMedications.getsQuantity()%></span>

				</td>
				<td style="width: 23%; height: 100%" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oCurrentMedications.getsOrderedBy()%></span>

				</td>
				<td style="width: 10%; height: 100%" align="left" valign="center">
					<span class="spanSelectOrderRows1"><%=oCurrentMedications.getsPriority()%></span>

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
		

