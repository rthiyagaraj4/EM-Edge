<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@ page
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<HTML>
<HEAD>
<%!
private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script>

	$(document).ready(function(){
		//$('#searchCriteriaDiv').hide();
		/*var bannerSize = $(parent.BillingBanner.document).find('#bannerSize').val();
		var pDoc = parent.document;
		var frameAltered = $(pDoc).find('#framesAltered').val();
		if(frameAltered == 'no'){
			if(bannerSize<=2){
				$(pDoc).find('#framesAltered').val('yes');
				$(pDoc).find('#BL_mainFrame').attr('rows','5%,8%,8%,21%,21%,33%,4%');
			}
		}*/
		
		//AAKH-CRF-0152-US021
		
		
		billReceiptExisting();
	});
	
	async function billReceiptExisting()
	{
		if($('#episode_type').val() == 'I' || $('#episode_type').val()== 'D' || $('#episode_type').val() == 'O' || $('#episode_type').val() == 'E'){
			if($('#episode_type').val() == 'I' || $('#episode_type').val() == 'D'){
				await computeBedCharge();
			}
			//TH-KW-CRF-0092/V230127
			if($('#unprocessBill').val() == 'Y'){
				await callUnprocessedBill();
			}//TH-KW-CRF-0092/V230127
			
		}
		//AAKH-CRF-0152-US021  
		

		$('#resizeBtnSearch').click(function(){
			var defValue = $(this).attr('defValue');
			if(defValue =='shrink'){
				$(this).attr('defValue','expand');
				$(this).attr('src','../../eOT/images/ShowMore.gif');
				$('#searchCriteriaDiv').hide();
				parent.document.getElementById('BL_mainFrame').rows =  parent.document.getElementById('allFramesExisting').value;
			}
			else{
				$(this).attr('defValue','shrink');
				$(this).attr('src','../../eOT/images/ShowLess.gif');
				$('#searchCriteriaDiv').show();
				parent.document.getElementById('BL_mainFrame').rows =  parent.document.getElementById('hideSearchCriteria').value;
			}
		});
		var tabDoc = parent.BillReceiptTab.document;
		var allow_locn_based_bill_yn = $(parent.BillReceiptTab.document).find('#allow_locn_based_bill_yn').val();
		if($(tabDoc).find('#allow_locn_based_bill_yn').val() == 'N'){
			$('#serviceLocation').val('');
			$('#serviceLocation').attr('disabled','disabled');
			//$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
		}
		else{
			$('#serviceLocation').val('');
			$('#serviceLocation').removeAttr('disabled');
			//$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
		}
		
		var infoDoc = parent.BillReceiptInfo.document;
		if( ($('#episode_type').val() == 'I' ||$('#episode_type').val() == 'D') && 
				($(infoDoc).find('#inPatBillType').val() == 'D' || $(infoDoc).find('#inPatBillType').val() == 'D')){
			await clearAndDisableSearchFields();
		}
		await showServiceDetails(1,50);
		
	}
	
</script>
<%-- JSP Page specific attributes end --%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	
			String reqParam = request.getQueryString();
			
			String locale="";
			String p_facility_id="";
			
			String servClass="";
			String servClassCode="";
			String billServ="";
			String billServCode="";
			String item="";
			String itemCode="";
			String entServGrp="";			
			String entServGrpCode="";
			String entGrpLine="";
			String entGrpLineCode="";		
			
			String serviceCode="";
			
			
			boolean firstRec=true;
			String firstServiceCode=null;
			System.out.println("start>>>>>>>>>>>>>>");
			
			
			 String encounter_date = replaceNull(request.getParameter("encounter_date"));
			 //V220512
			/*
			 String encounter_id = replaceNull(request.getParameter("encounter_id"));
			 String patient_id = replaceNull(request.getParameter("patient_id"));
			*/
			String patient_id	="";
			String encounter_id	="";

			if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
				patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
				encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
			}else{
				patient_id	= replaceNull(request.getParameter("patient_id"));
				encounter_id	= replaceNull(request.getParameter("encounter_id"));
			}
			//V220512 vulnerablity 
			 
			 String blng_grp_id = replaceNull(request.getParameter("blng_grp_id"));
			 String episode_id = replaceNull(request.getParameter("episode_id"));
			 String visit_id = replaceNull(request.getParameter("visit_id"));
			String episode_type = replaceNull(request.getParameter("episode_type"));
			String acctSeqNo = replaceNull(request.getParameter("acctSeqNum"));
			String payerGroup = replaceNull(request.getParameter("payerGroup"));
			String payer = replaceNull(request.getParameter("payer"));
			String policy = replaceNull(request.getParameter("policy"));
			String policyNum = replaceNull(request.getParameter("policyNum"));
			//TH-KW-CRF-0092/V230127
			Connection con=null;
			String unprocessBill="";
			boolean unprocessedBill=false;
			try{	
				HttpSession httpSession = request.getSession(false);				
				locale	= (String)session.getAttribute("LOCALE");	
				p_facility_id = (String)httpSession.getValue("facility_id");
				//TH-KW-CRF-0092/V230127
				try{
				con = ConnectionManager.getConnection();
				unprocessedBill= eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENABLE_FUTURE_ORDER");
					if (unprocessedBill) {
						unprocessBill = "Y";
					}else {
						unprocessBill = "N";
					}
					System.err.println("unprocessBill billgen "+unprocessBill);
				} catch(Exception ex) {
					System.err.println("Error in BillReceiptExistingOrderSearch.jsp for getting unprocessBill Connection: "+ex);
					ex.printStackTrace();
				}
				//TH-KW-CRF-0092/V230127
				
				//Getting Billing Service group
				
				HashMap<String,String> blngServGroup = new HashMap<String,String>();
				PlaceOrderBC placeOrderBC = new PlaceOrderBC();
				blngServGroup = placeOrderBC.getBlngServGroup(locale);
				request.setAttribute("blngServGroup", blngServGroup);
				
				//Getting Service Locations
				LinkedHashMap<String,String> serviceLocn = new LinkedHashMap<String,String>();
				BillReceiptRequest brRequest = new BillReceiptRequest();
				brRequest.setLocale(locale);
				brRequest.setFacilityId(p_facility_id);
				
				BillReceiptBC receiptBC = new BillReceiptBC();
				serviceLocn = receiptBC.getServiceLocation(brRequest);
				request.setAttribute("serviceLocn", serviceLocn);
				
				System.out.println("locale>>>>>"+locale);		
			  }catch(Exception eX){	
				out.println("Error= "+eX);
				}
			
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
	<script language='javascript' src='../../eBL/js/BLChargePatientServiceLookup.js'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



	<script>
	function servCodeChange(){
		//alert("changed");
		//alert(document.forms[0].name);
		//alert(document.forms[0].serviceCode.value);
		var  loc=document.forms[0].locale.value;
		var sercod=document.forms[0].serviceCode.value;
		//var document.forms[0].serviceCode=document.forms[0].serviceCode.value;		
	}
	var pDoc= parent.BillReceiptExisOrderSummary.document;
	$('#exemptAmt').val($(pDoc).find('#exemptReq').val());
		
	
	</script>
</HEAD>
<body>
			<FORM name='BLChargePatientEncounterExistingOrder' id='BLChargePatientEncounterExistingOrder' method='' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width="100%" CELLSPACING=0 cellpadding=3 align='center'>
      		<tr>
      			<td width='20%' class='COLUMNHEADER' nowrap colspan="8">
      				<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"></fmt:message> 
      				<!-- &nbsp;&nbsp;<img id="resizeBtnSearch" alt="" defValue="expand" src="../../eOT/images/ShowMore.gif" style="cursor: pointer;" >  --> 
      			</td>
      		</tr>
      	</table>
      	<div id='searchCriteriaDiv'>
      	<table width="100%" CELLSPACING=0 cellpadding=3 align='center'>
      		<tr>
      			<td width='10%'  nowrap class='label'>
      				<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='15%' nowrap class='fields'>
      				<Select style="width: 180px;" name='serviceCode' id='serviceCode'  onchange='servCodeChange()'>
      				<option value=''>-------<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />
							-------	</option>
      					<c:forEach var="serv" items="${blngServGroup }">      						
      						<option value="${serv.key }">${serv.value }</option>
      					</c:forEach>
	      			</Select>
      			</td>
      			
      		
      			
      			<td class="label" width="10%">
      				<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/>
      			</td>	
				<td class="fields" width="15%">
					<INPUT TYPE="TEXT"  name="serv_class" id="serv_class" SIZE="15"  MAXLENGTH='40' VALUE="<%=servClass%>" onBlur="if(this.value != ''){ servClassLkup(this,document.forms[0].serv_class_code,'Y') } else{ clearCode(serv_class_code);}">
					<input type='button' class='button' name="servClass_but" id="servClass_but" value='?' onClick='servClassLkup(document.forms[0].serv_class,document.forms[0].serv_class_code)' >
					<input type= 'hidden' id='serv_class_code' name="serv_class_code"  value="<%=servClassCode%>">
				</td>	
      			
      			<td class="label" width="10%">
      				<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
      			</td>	
				<td class="fields" width="15%">
					<INPUT TYPE="TEXT"  name="bill_serv" id="bill_serv" SIZE="15"  MAXLENGTH='40' VALUE="<%=billServ%>" onBlur="if(this.value != ''){ billingServLkup(this,bill_serv_code,'Y') } else{ clearCode(bill_serv_code);}">
					<input type='button' class='button' name="frombillbut" id="frombillbut" value='?' onClick='billingServLkup(document.forms[0].bill_serv,bill_serv_code)' >
					<input type= 'hidden' id="bill_serv_code" name="bill_serv_code" id="bill_serv_code"  value="<%=billServCode%>">
				</td>	
				<td class="label" width="10%">
					<fmt:message key="Common.item.label" bundle="${common_labels}"/>
				</td>	
				<td class="fields" width="15%">
					<INPUT TYPE="TEXT"  name="item" id="item" SIZE="15"  MAXLENGTH='40' VALUE="<%=item%>" onBlur="if(this.value != ''){ itemLkup(this,document.forms[0].item_code,'Y') } else{ clearCode(item_code);}">
					<input type='button' class='button' name="item_but" id="item_but" value='?' onClick='itemLkup(document.forms[0].item,document.forms[0].item_code)' >
					<input type= 'hidden' name="item_code" id="item_code"  value="<%=itemCode%>">
				</td>	
					
				</tr>  
			 
				<tr>
				<td class="label" width="10%">
					<fmt:message key="eBL.EnterpriseServiceGroup.Label" bundle="${bl_labels}"/>
				</td>	
				<td class="fields" width="15%">
					<INPUT TYPE="TEXT"  name="ent_serv_grp" id="ent_serv_grp" SIZE="15"  MAXLENGTH='40' VALUE="<%=entServGrp%>" onBlur="if(this.value != ''){ entServGrpLkup(this,document.forms[0].entServ_Grp_code,'Y') } else{ clearCode(entServ_Grp_code);}">
					<input type='button' class='button' name="entServGrp_but" id="entServGrp_but" value='?' onClick='entServGrpLkup(document.forms[0].ent_serv_grp,document.forms[0].entServ_Grp_code)' >
					<input type= 'hidden' name="entServ_Grp_code" id="entServ_Grp_code"  value="<%=entServGrpCode%>">
				</td>	
				<td class="label" width="10%">
					<fmt:message key="eBL.EntGrpLine.label" bundle="${bl_labels}"/>
				</td>	
				<td class="fields" width="15%">
					<INPUT TYPE="TEXT"  name="ent_grp_line" id="ent_grp_line" SIZE="15"  MAXLENGTH='40' VALUE="<%=entGrpLine%>" onBlur="if(this.value != ''){ entGrpLineLkup(this,document.forms[0].entGrp_Line_code,'Y') } else{ clearCode(entGrp_Line_code);}">
					<input type='button' class='button' name="entGrpLine_but" id="entGrpLine_but" value='?' onClick='entGrpLineLkup(document.forms[0].ent_grp_line,document.forms[0].entGrp_Line_code)' >
					<input type= 'hidden' name="entGrp_Line_code" id="entGrp_Line_code"  value="<%=entGrpLineCode%>">
				</td>	
				<td class='label' width='10%'>
					<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>    
				</td>
				<td class="fields" width='15%'>
					<input type='text' name='from__date' id='from__date' SIZE='15' maxlength='30' VALUE='' onBlur='return checkDateBL(document.forms[0].from__date)' >
					<img id='from_bill_date_cal' name='from_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('from__date');" onBlur='return checkDateBL(document.forms[0].from__date)'>
				</td>
				<td class='label' width="10%">
					<fmt:message key="Common.todate.label" bundle="${common_labels}"/> 
				</td>
				<td class="fields" width='15%'>
					<input type='text' name='to_date' id='to_date' SIZE='15' maxlength='30'  VALUE='' onBlur='return checkDateBL(document.forms[0].to_date)'>
					<img id='to_bill_date_cal' name='to_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('to_date');" onBlur='return checkDateBL(document.forms[0].to_date)'>
				</td>
				
				</tr>    
								
      			<tr>

					<td class="label" width="10%">
						&nbsp;<fmt:message key="eBL.ServiceLocation.label"  bundle="${bl_labels}"/>
					</td>		
					<td class="fields" width="15%">
						<select name='serviceLocation' id='serviceLocation'  style="width: 175px;" onchange="showServiceDetails(1,50);"><!--V221023-->
							<option value=''>All</option>
							<c:forEach var="serviceLoc" items="${serviceLocn }">      						
      							<option value="${serviceLoc.key }">${serviceLoc.value }</option>
      						</c:forEach>						
      					</select>
					</td>
					<td class="label" width="10%">
						<fmt:message key="eBL.InterCoEncounters.label"  bundle="${bl_labels}"/>
					</td>		
					<td class="fields" width="15%">
						<select name='interCoEncounters' id='interCoEncounters' >
							<option value=''><fmt:message key="Common.Both.label"bundle="${common_labels}" /></option>
							<option value='Y'><fmt:message key="eBL.Billed.label"bundle="${bl_labels}" /></option>
							<option value='N'><fmt:message key="eBL.UnBilled.label"bundle="${bl_labels}" /></option>
						</select>
					</td>
					<td nowrap class="label" width='10%'>
						<fmt:message key="eBL.Service/Package.label"bundle="${bl_labels}" />
					</td>	
					<td nowrap width='15%'>
						<select name='servOrPkg' id='servOrPkg' >
							<option value=''><fmt:message key="Common.Both.label"bundle="${common_labels}" /></option>
							<option value='S'><fmt:message key="Common.service.label"bundle="${common_labels}" /></option>
							<option value='P'><fmt:message key="Common.Package.label"bundle="${common_labels}" /></option>
						</select>
					</td>
					<td nowrap class="label" width='10%'>				
						<input type="button" class='button' name="add_mod" id="add_mod"   value="Search" onclick="showServiceDetails(1,50);"  />		
					</td>
					<td nowrap class="label" width='15%'>				
						<input type="button" class='button' name="reset" id="reset"   value="Reset" onclick="resetExistingOrder();"  />		
					</td>
				</tr> 			 
      	</table>
      	</div>
      	<input type= 'hidden' name="filterBy" id="filterBy"  value="G">
      	<input type= 'hidden' name="locale" id="locale" value="<%=locale%>">
      	<input type= 'hidden' name="facility_id" id="facility_id" value="<%=p_facility_id %>">
      	<input type= 'hidden' name="patient_id" id="patient_id" value="<%=patient_id %>">
      	<input type= 'hidden' name="episode_id" id="episode_id"  value="<%=episode_id %>">
      	<input type= 'hidden' name="visit_id" id="visit_id" value="<%=visit_id %>">
      	<input type='hidden' name='encounter_date' id='encounter_date'  value='<%=encounter_date %>'>
      	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id %>'>
      	<input type='hidden' name='episode_type' id='episode_type'  value='<%=episode_type %>'>
      	<input type='hidden' name='acctSeqNo' id='acctSeqNo'  value='<%=acctSeqNo %>'>
      	<input type='hidden' name='queryString' id='queryString'  value='<%=reqParam%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer'  value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='policyNum' id='policyNum' value='<%=policyNum%>'>
     	 <input type='hidden' name='exemptAmt' id='exemptAmt' value=''>
		 <input type='hidden' name='unprocessBill' id='unprocessBill' value='<%=unprocessBill%>' ><!--V230127-->
</FORM>
</body>

</HTML>

