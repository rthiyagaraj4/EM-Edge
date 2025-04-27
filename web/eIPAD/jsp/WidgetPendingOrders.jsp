<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String strOrder = "";
	String strFormat = "";

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

function expandPendiOrderwidget()
{
	
	window.parent.expandwidgetsecond();
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


function orderFormatWindow(orderId,lineId){

	/* var dialogHeight ='36' ;
	var dialogWidth = '48' ;
	var dialogTop	= '129';
	var dialogLeft = '11' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "orderId="+ orderId+"&lineId="+lineId;
	var retVals = window.showModalDialog("ViewPendingOrderFormatFrame.jsp?"+finalString,arguments,features); */
	
	var finalString	= "orderId="+ orderId+"&lineId="+lineId;
	document.getElementById("orderFormatFrame").src = "ViewPendingOrderFormat.jsp?"+finalString;
	$.mobile.changePage("#orderFrame", "pop", false,false);
}

function closenotes()
{
	 $.mobile.changePage("mainPendingOrder","pop", true,false);
	
}

</script>

</script>
</head>
<body>

	<section id="mainPendingOrder" data-role="page"
		style="background-color: white">

		<div class="dvWidgetHeaderResults">
			<table style="width: 100%" border="0" cellpadding="0" cellspacing="0">
				<tr style="width: 100%">
					<td style="width: 95%" valign="middle"><span
						class="spaDvHeaderResults">PendingOrders</span></td>

					
					<td style="width: 5%" align="center" valign="middle"
						onclick="expandPendiOrderwidget()"><img
						src="../images/Collapse icon.png"></img></td>
				</tr>
			</table>
		</div>
		
		
		<%
					eIPAD.PendingOrderDetails bean = new eIPAD.PendingOrderDetails();
					List<PendingOrder> objPendingOrder = new ArrayList<PendingOrder>();
					int nRowCount = 1; //To hold the rowcount and to limit the row size to 6.		       			    
					int nCssCount = 1; // To display alternate Row Color.
					int nDummyRowcount = 1;
					int nListSize = 0;

					int nLoopCount = 0;
					PendingOrder oPendingOrder = null;
					
					String orderId = "";
					String orderLineNum = "";
					
					try {
						objPendingOrder = bean.getPendingOrderDetails(oPatientContext);
						nListSize = objPendingOrder.size();
						if (nListSize > 0) {
							%>
							<table class="tbWidgetContent" cellpadding="0" cellspacing="0"
			border="0">

			<tr class="trWidgetSummary1">
				<td style='width: 4%' align="center" valign="middle">&nbsp;</td>
				<td style='width: 96%' align='left'>
					<table style="width: 100%;" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td style='width: 35%' align='left'><span
								class="spWidHeaderAllergy"><b>Order Category</b></span></td>

							<td style='width: 15%' align='left'><span
								class="spWidHeaderAllergy"><b>Date</b></span></td>
							<td style='width: 15%' align='left'><span
								class="spWidHeaderAllergy"><b>By</b></span></td>
							<td style='width: 35%' align='left'><span
								class="spWidHeaderAllergy"><b>Format</b></span></td>


						</tr>
					</table>
				</td>
				

			</tr>
		</table>
							<% 
							for (nLoopCount = 0; nLoopCount < nListSize; nLoopCount++) {
								oPendingOrder = objPendingOrder.get(nLoopCount);
								if (oPendingOrder != null) {
									orderId = oPendingOrder.getOrderId();
									orderLineNum = oPendingOrder.getOrderLineNum();
									strFormat = oPendingOrder.getsFormatExists();
				%>

		<%
			if (!strOrder.equals(oPendingOrder.getsOrderDesc())) {
		%>
		<table class = "tbParent" border="0"
			cellspacing="0" cellpadding="0">
			<tr class='trResultsHeader'>
				<td style='width: 4%' align="center" valign="middle"><img
					src="../images/More group icon main.png"
					onclick="DisplayOrHideDetails('<%=oPendingOrder.getsOrderDesc()%>' , this)"></img></td>
				<td style='width: 96%' align='left'>
					<table style="width: 100%;" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td style='width: 35%' align='left'><span
								class="spWidHeaderAllergies"><b><%=oPendingOrder.getsOrderDesc()%></b></span></td>

							

						</tr>
					</table>
				</td>
			</tr>
		</table>

		<%
			}
		%>
		<div data-role="none" data-class="<%=oPendingOrder.getsOrderDesc()%>"
			style="display: none">


			<table class = "tbParent" border="0"
				cellspacing="0" cellpadding="0">

				<tr class="trAllergySummary">
					<td style='width: 4%;' align="center" valign="middle">&nbsp;</td>

					<td style='width: 96%' align='left'>
						<table style="width: 100%;" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td style='width: 35%' align='left'><span
									class="spaDvAllergyDetails1"><b><%=oPendingOrder.getsItemShortDesc()%></span></td>

								<td style='width: 15%' align='left'><span
									class="spaDvAllergyDetails1"><b><%=oPendingOrder.getsTestDateTime()%></b></span></td>
								<td style='width: 15%' align='left'><span
									class="spaDvAllergyDetails1"><b><%=oPendingOrder.getsOrdPractId()%></b></span></td>
                              
								<td style='width: 35%' align='left'>
								 <% if(strFormat.equals("Y"))
                      {
                      %> 
                         <a class='gridLink' href="javascript:orderFormatWindow('<%=orderId%>','<%=orderLineNum%>')">
                         <img src = "../images/Pending Order.JPG" style = "margin-top : 7px;">
                         </img>
                         </a>
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
			strOrder = oPendingOrder.getsOrderDesc();
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

<section id="orderFrame" data-role = "page" style = "background-color: #ffffff;padding:0px">
<div  style = "height:auto;overflow:auto;padding:0px;background-color: #ffffff" data-role = "none">
     <iframe frameborder="0" id="orderFormatFrame" src="" scrolling ="yes" style="padding:0px;display:block" width = "100%"  ></iframe>
     </div>
</section>


</body>
</html>











