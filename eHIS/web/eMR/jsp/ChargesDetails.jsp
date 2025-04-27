<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<html>
<%	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId = (String)session.getValue("facility_id");
   
   
	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String toShow			= checkForNull(request.getParameter("toShow"));	
	String classification_appl_yn = checkForNull(request.getParameter("classification_appl_yn")); // added by mujafar for ML-MMOH-CRF-0762 start
	classification_appl_yn= classification_appl_yn.trim();
	
	String req_type = checkForNull(request.getParameter("req_type"));
	String req_code = checkForNull(request.getParameter("req_code"));
	String requestor_desc = checkForNull(request.getParameter("requestor_desc"));
	String call_function = checkForNull(request.getParameter("call_function"));
	String dis_chl_list = "";
	String request_id = checkForNull(request.getParameter("request_id")); //  added by mujafar for ML-MMOH-CRF-0762
	

	
	
	if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		dis_chl_list="disabled";
	
	Connection con=null;
	int  count =0; // added by mujafar for ML-MMOH-CRF-0762 end


	
	
%>
	<head>
	<script>
	//  // added by mujafar for ML-MMOH-CRF-0762 start
	async function callAudit()
	
	{
	var retVal			= new String();
	var center			= "3" ;
	var dialogTop		= "100";  
	var dialogHeight	= "28vh"; //  added by mujafar for ML-MMOH-CRF-0762
	var dialogWidth		= "35vw";
	var status			= "no";
	var arguments	= "" ;
	var features		= " dialogHeight:"+dialogHeight+"; scroll=auto; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;
	retVal=await window.showModalDialog("../../eMR/jsp/checklistAuditFrame.jsp?req_type="+document.forms[0].req_type.value+"&req_code="+document.forms[0].req_code.value+"&request_id="+document.forms[0].request_id.value+"&classification_appl_yn="+document.forms[0].classification_appl_yn.value,arguments,features);		
	//  added by mujafar for ML-MMOH-CRF-0762
	}
	// added by mujafar for ML-MMOH-CRF-0762 end
	</script>
	
	
	
	
	
	
	
<%
	//ChecklistDetails Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] 
	if(toShow.equals("DateDetails"))
	{	%>
		<title><fmt:message key="eMR.DateDetails.label" bundle="${mr_labels}"/></title>
<%	}else if(toShow.equals("ChecklistDetails")){%>
		<title><fmt:message key="eMR.CheckListDetails.label" bundle="${mr_labels}"/></title>
<%}else
	{	%>
		<title><fmt:message key="eMR.ChargesDetails.label" bundle="${mr_labels}"/></title>
<%	}	%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<!--Below one line added by Venkatesh.S (4008) on 20/June/2012  aganist 33482 -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<!-- code fix end for 33482 -->
		
	</head>
<%
/*
	String PatRecordSet		= checkForNull(request.getParameter("PatRecordSet"));
	String FwdToPract		= checkForNull(request.getParameter("FwdToPract"));
	String ReportComplete	= checkForNull(request.getParameter("ReportComplete"));
	String Received			= checkForNull(request.getParameter("Received"));
	String Delivered		= checkForNull(request.getParameter("Delivered"));
*/
	String prepareDate= checkForNull(request.getParameter("PrepareDate"));
	if(!(prepareDate==null || prepareDate.equals("")))
				prepareDate		= DateUtils.convertDate(prepareDate,"DMYHM","en",localeName);

	String applCompletionDate= checkForNull(request.getParameter("applCompletionDate"));
	if(!(applCompletionDate==null || applCompletionDate.equals("")))
		applCompletionDate		= DateUtils.convertDate(applCompletionDate,"DMYHM","en",localeName);

	String applSubmissionDate= checkForNull(request.getParameter("applSubmissionDate"));
	if(!(applSubmissionDate==null || applSubmissionDate.equals("")))
		applSubmissionDate		= DateUtils.convertDate(applSubmissionDate,"DMYHM","en",localeName);

	String RequestDate= checkForNull(request.getParameter("RequestDate"));
	if(!(RequestDate==null || RequestDate.equals("")))
		RequestDate				= DateUtils.convertDate(RequestDate,"DMYHM","en",localeName);

	String ReceivedDate= checkForNull(request.getParameter("ReceivedDate"));
	if(!(ReceivedDate==null || ReceivedDate.equals("")))
		ReceivedDate			= DateUtils.convertDate(ReceivedDate,"DMYHM","en",localeName);

	String DeliveredDate= checkForNull(request.getParameter("DeliveredDate"));
	if(!(DeliveredDate==null || DeliveredDate.equals("")))
		DeliveredDate			= DateUtils.convertDate(DeliveredDate,"DMYHM","en",localeName);


	String charges_appl_yn	= checkForNull(request.getParameter("charges_appl_yn"),"No");
	if(charges_appl_yn.equals("Y"))
		charges_appl_yn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
	else
		charges_appl_yn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

	String addl_charges_yn	= checkForNull(request.getParameter("addl_charges_yn"),"No");
	if(addl_charges_yn.equals("Y"))
		addl_charges_yn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
	else
		addl_charges_yn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

	String receipt_no		= checkForNull(request.getParameter("receipt_no"));
	if(receipt_no.equals("")) receipt_no = "-";
	String addl_receipt_no	= checkForNull(request.getParameter("addl_receipt_no"));
		if(addl_receipt_no.equals("")) addl_receipt_no = "-";
	String amount			= checkForNull(request.getParameter("amount"));
		if(amount.equals("")) amount = "-";
	String addl_amount		= checkForNull(request.getParameter("addl_amount"));
		if(addl_amount.equals("")) addl_amount = "-";

	String receipt_date		= checkForNull(request.getParameter("receipt_date"));
	if(!(receipt_date==null || receipt_date.equals("")))
		receipt_date		= DateUtils.convertDate(receipt_date,"DMYHM","en",localeName);
	if(receipt_date.equals("")) receipt_date = "-";

	String addl_receipt_date= checkForNull(request.getParameter("addl_receipt_date"));
	if(!(addl_receipt_date==null || addl_receipt_date.equals("")))
		addl_receipt_date	= DateUtils.convertDate(addl_receipt_date,"DMYHM","en",localeName);
	if(addl_receipt_date.equals("")) addl_receipt_date = "-";

%>

<body onKeyDown='lockKey()'>
	<form name='DiaplayForm' id='DiaplayForm'>
<%	if(toShow.equals("DateDetails"))
	{	%>
		<table border="0" width="100%" cellspacing='0' cellpadding='3'>
			<tr>
				<th width="100%" colspan="2"><fmt:message key="eMR.DateDetails.label" bundle="${mr_labels}"/></th>
			</tr>
			<tr>
				<td class="label" align="right" width="50%"><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/></td>
				<td class="querydata" align="left" width="50%"><%=RequestDate%></td>
			</tr>
			<tr>
				<td class="label" align="right" ><fmt:message key="eMR.ApplicationCompletionDates.label" bundle="${mr_labels}"/></td>
				<td class="querydata" align="left"><%=applCompletionDate%></td>
			</tr>
			<tr>
				<td class="label" align="right" ><fmt:message key="eMR.ForwardedDate.label" bundle="${mr_labels}"/></td>
				<td class="querydata" align="left"><%=applSubmissionDate%></td>
			</tr>
			<tr>
				<td class="label" align="right" ><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/></td>
				<td class="querydata" align="left"><%=prepareDate%></td>
			</tr>
			<tr>
				<td class="label" align="right" ><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></td>
				<td class="querydata" align="left"><%=ReceivedDate%></td>
			</tr>
			<tr>
				<td class="label" align="right" ><fmt:message key="eMR.DeliveredDate.label" bundle="${mr_labels}"/></td>
				<td class="querydata" align="left"><%=DeliveredDate%></td>
			</tr>
			<tr><td></td><td class='button'><input type=button name="Close" id="Close" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="closeW();"></td></tr>
		</table>
<%	}
	else if(toShow.equals("ChargeDetails"))
	{	%>
		<table border="0" width="100%" cellspacing='0' cellpadding='3'>
			<tr><th align=center colspan='2'><fmt:message key="Common.PaymentDetails.label" bundle="${common_labels}"/></th>
				<th align=left colspan='2'><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>	
				<td align='right' class='label' width="25%"><fmt:message key="eMR.ChargesApplicable.label" bundle="${mr_labels}"/></td>
				<td align='left' class="querydata" width="25%"><%=charges_appl_yn%></td>
				<td align='right' class='label' width="25%"><fmt:message key="eMR.AdditionalCharges.label" bundle="${mr_labels}"/></td>
				<td align='left' class="querydata" width="25%"><%=addl_charges_yn%></td>
			</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/></td>
				<td align='left' class="querydata" ><%=receipt_no%></td>
				<td align='right' class='label'><fmt:message key="eMR.AdditionalReceiptNo.label" bundle="${mr_labels}"/></td>
				<td align='left' class="querydata" ><%=addl_receipt_no%></td>
			</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class="querydata" ><%=amount%></td>
				<td align='right' class='label'><fmt:message key="eMR.AdditionalAmount.label" bundle="${mr_labels}"/></td>
				<td class="querydata" ><%=addl_amount%></td>
			</tr>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
				<td class="querydata" ><%=receipt_date%></td>
				<td align='right' class='label'><fmt:message key="eMR.AdditionalReceiptDate.label" bundle="${mr_labels}"/></td>
				<td class="querydata" ><%=addl_receipt_date%></td>
			</tr>
			<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='button'><input type=button name="Close" id="Close" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="closewindow();"></td>
			</tr>
		</table>
<%	}
/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
else if(toShow.equals("ChecklistDetails")	){
	
	if(!classification_appl_yn.equals("true"))  // added by mujafar for ML-MMOH-CRF-0762
	{ 
	%>
<table border="0" width="100%" cellspacing='0' cellpadding='0'>
			<tr><td>&nbsp;</td><td>&nbsp;</td><td colspan='4'>&nbsp;</td></tr>
			<tr>
		 <td  class="label" align="right" width="65%"><fmt:message key="eMR.ConsentFromPatientNextofKin.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select name="con_pat_next" id="con_pat_next" >
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected >No</option>
				<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			</tr>

			<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
		 <td  class="label" align="right" width="60%"><fmt:message key="eMR.CopyofIdentificationDocumentofRequestor.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select name="copy_ident_doc_req" id="copy_ident_doc_req" >
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected >No</option>
				<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			</tr>
				<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
		 <td  class="label" align="right" width="60%"><fmt:message key="eMR.MaritalCertificateofSpouse.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select name="mor_cer_of_spo" id="mor_cer_of_spo" >
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected >No</option>
				<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			</tr>
				<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
		 <td  class="label" align="right" width="60%"><fmt:message key="eMR.StatutoryDeclaration.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select name="stat_dec" id="stat_dec" >
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected >No</option>
				<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			</tr>
				<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
		 <td  class="label" align="right" width="60%"><fmt:message key="eMR.ConsentFromEmbassy.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select name="con_from_emba" id="con_from_emba" >
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			</tr>
				<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
		 <td  class="label" align="right" width="60%"><fmt:message key="eMR.PaymentAutolinkFromBilling.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select name="payment" id="payment" >
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			</tr>
			</tr>
				<tr><td colspan='5'>&nbsp;</td></tr>
			<tr>
			<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align="right"><input type=button name="Close" id="Close" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="close_window();"></td></tr>
			<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
		</table>



<script>
	var arrgu		 = '<%=request.getParameter("arrgu")%>';
	var isDisable	 = '<%=request.getParameter("isDisable")%>';
		if(arrgu) {
			var obj = arrgu.split('~')
			document.forms[0].con_pat_next.value=obj[0];
			document.forms[0].copy_ident_doc_req.value=obj[1];
			document.forms[0].mor_cer_of_spo.value=obj[2];
			document.forms[0].stat_dec.value=obj[3];
			document.forms[0].con_from_emba.value=obj[4];
			document.forms[0].payment.value=obj[5];

			if(isDisable=="Y"){
				document.forms[0].con_pat_next.disabled=true;
				document.forms[0].copy_ident_doc_req.disabled=true;
				document.forms[0].mor_cer_of_spo.disabled=true;
				document.forms[0].stat_dec.disabled=true;
				document.forms[0].con_from_emba.disabled=true;
				document.forms[0].payment.disabled=true;
			}
		}

		function close_window() {
			var con_pat_next=document.forms[0].con_pat_next.value;
			var copy_ident_doc_req=document.forms[0].copy_ident_doc_req.value;
			var mor_cer_of_spo=document.forms[0].mor_cer_of_spo.value;
			var stat_dec=document.forms[0].stat_dec.value;
			var con_from_emba=document.forms[0].con_from_emba.value;
			var payment=document.forms[0].payment.value;
			var retVal =con_pat_next+'~'+copy_ident_doc_req+'~'+mor_cer_of_spo+'~'+stat_dec+'~'+con_from_emba+'~'+payment;
			window.returnValue =retVal  ;
			//window.close();
			const dialogTag = parent.document.getElementById("dialog_tag");    
		    dialogTag.close();
			
		
		}
</script>
<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End-->
<%}

else
{ //  added by mujafar for ML-MMOH-CRF-0762
try
{
			con=ConnectionManager.getConnection(request);
			JSONArray checkListJsonArr = new JSONArray();
			
			checkListJsonArr							= eMR.MRCommonBean.getChecklistValues(con,req_type,req_code);
			
			count = checkListJsonArr.size();
			
			
			String[] checklist_code = new String[count];
%>	
<table border="0" width="100%" cellspacing='0' cellpadding='0'>
<tr><td>&nbsp;</td><td>&nbsp;</td><td colspan='4'>&nbsp;</td></tr>
<%

for(int i = 0 ; i < checkListJsonArr.size() ; i++)
{
				JSONObject json	= (JSONObject)checkListJsonArr.get(i);
				String long_desc  = (String) json.get("long_desc");
				String chk_list_code = (String) json.get("chk_list_code");
				checklist_code[i]=chk_list_code;
%>
	<tr>
			<td  class="label" align="right" width="60%"><%=long_desc%>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select name='checkList<%=i%>' id='checkList<%=i%>' >
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected >No</option>
				<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr><td></td> </tr>
		<tr><td></td> </tr>
		<tr><td></td> </tr>

<%
}
%>
<tr><td>&nbsp;</td></tr>
<tr><td  ><input type=button name="chk_list_details" id="chk_list_details" class="button" size='5' <%=dis_chl_list%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckListDetails.label","mr_labels")%>" onclick="callAudit();"></td><td>&nbsp;</td><td align="right"><input type=button name="Close" id="Close" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="close_window1();"></td></tr>
			<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
		</table>
		
<input type='hidden' name='classification_appl_yn' id='classification_appl_yn' value='<%=classification_appl_yn%>' >
<input type='hidden' name='count' id='count' value='<%=count%>' >
<input type='hidden' name='request_id' id='request_id' value="<%=request_id%>"> <!-- added by mujafar for ML-MMOH-CRF-0762 -->
<input type='hidden' name='req_type' id='req_type' value="<%=req_type%>"> 
<input type='hidden' name='req_code' id='req_code' value="<%=req_code%>"> 
<script>
	var arrgu		 = '<%=request.getParameter("arrgu")%>';
	var isDisable	 = '<%=request.getParameter("isDisable")%>';
	
		if(arrgu) {
			var count = document.forms[0].count.value;
			var obj = arrgu.split('~')
			var i;
			for( i=0;i<count;i++)
			{  
				eval("document.forms[0].checkList"+i).value = obj[i];
				
				if(isDisable=="Y"){
					eval("document.forms[0].checkList"+i).disabled = true;
				}
					
			}
			
			
			
			
			
			
		}
		

</script>
<script>
function close_window1() {
			
			var count = document.forms[0].count.value;
			var retVal = "";
			for(var i=0;i<count;i++)
			{
				if(retVal != "")
				retVal= retVal+'~'+eval("document.forms[0].checkList"+i).value;
				else
				retVal = eval("document.forms[0].checkList"+i).value;
			}
			
			
			
			window.returnValue =retVal  ;
			window.close();
		}
</script>

		

<%

}

catch(Exception e){
	//out.println("Exception @ ChargesDetails.jsp "+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}








}




} // added by mujafar for ML-MMOH-CRF-0762
%>






		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
<script>
function closeW(){
	const dialogTag =parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
function closewindow(){
	const dialogTag =parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

<!--

//-->
</script>
