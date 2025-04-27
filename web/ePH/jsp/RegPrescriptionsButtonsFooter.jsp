<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %><!-- java.sql.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager adeed for ML-BRU-CRF-0469-->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		 //ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT> 
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
		//String displayData			 = request.getParameter("displayData");//Commented for ML-BRU-SCF-1199 [IN:045703]
		String	bean_id						=	"RegPrescriptionsBean" ;//Added for ML-BRU-SCF-1199 [IN:045703] -start
		String	bean_name					=	"ePH.RegPrescriptionsBean";
		RegPrescriptionsBean bean			= (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ; 
		ArrayList printResult =	bean.getPrintResultDetails();
		String print_pres_on_regn_yn = (String)printResult.get(0);	
		String issue_token_on_regn_yn= (String)printResult.get(1);//Added for ML-BRU-SCF-1199 [IN:045703]-end
		//StringTokenizer st			 = new StringTokenizer(displayData,"~");//Commented for ML-BRU-SCF-1199 [IN:045703]
		
		String printPresOnRegnYN	 = "";
		
		// Added for ML-BRU-CRF-0469 - start
		boolean displayGrossAmtYn           = false;
		Connection con			= null;
		try{
			con = ConnectionManager.getConnection(request);
			displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");
		}
		catch(Exception e){
			e.printStackTrace();
			displayGrossAmtYn = false;
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}  // Added for ML-BRU-CRF-0469  - End


		if (((print_pres_on_regn_yn).trim()).equals("N")){
			printPresOnRegnYN = "disabled";
		}

		String	disp_bean_id				=	"DispMedicationAllStages" ;
		String	disp_bean_name			    =	"ePH.DispMedicationAllStages";	
		
		DispMedicationAllStages disp_bean   = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name,request);
		String  billing_interface_yn		=	disp_bean.checkforbillinginterface();

		String total_payable	            = "";
		String patient_payable	            = "";
		String total_gross_amount           = "";//added for ML-BRU-CRF-0469
		double dPatientPayable = 0; //added for Bru-HIMS-CRF-094 [IN:029959]
		String total_gross_amount_amt = "";  //added for ML-BRU-CRF-0469
		if(billing_interface_yn.equals("Y")){
			String total_payable_amt         = request.getParameter("total_payable")==null?"":request.getParameter("total_payable");
			String patient_payable_amt       = request.getParameter("patient_payable")==null?"":request.getParameter("patient_payable");
			//added for ML-BRU-CRF-0469 start
			if(displayGrossAmtYn){
			   total_gross_amount_amt       = request.getParameter("total_gross_amount")==null?"":request.getParameter("total_gross_amount");
			}
			//added for ML-BRU-CRF-0469 end
			if(!patient_payable_amt.equals("")) //added for Bru-HIMS-CRF-094 [IN:029959]
				dPatientPayable = Double.parseDouble(patient_payable_amt);
			total_payable	            = "<label >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalChargeAmount.label","ph_labels")+" :"+total_payable_amt+"</label>";

			patient_payable	            = "<label >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalPayableAmount.label","ph_labels")+" :"+patient_payable_amt+"</label>";  
			//added for ML-BRU-CRF-0469 start
			if(displayGrossAmtYn){
			total_gross_amount	        = "<label >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalGrossAmount.label","ph_labels")+" :"+total_gross_amount_amt+"</label>";
			}
			//added for ML-BRU-CRF-0469 end
			}
%>
		<form name="regPrescriptionsButtonsFooter" id="regPrescriptionsButtonsFooter" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
				<tr>    
					<td align="right"class="data" width='20%'></td> 
					<!-- added for ML-BRU-CRF-0469 start-->
					<%if(displayGrossAmtYn){ %>
					<td  class="data"  align='center' style="font-size:9pt" id='total_gross_amount' ><%=total_gross_amount%> </td>
					<%} %>
					<!-- added for ML-BRU-CRF-0469  end -->
					<td  class="data"  align='center' style="font-size:9pt" id='total_payable' ><%=total_payable%> </td>
					<td  class="data"  align='center' style="font-size:9pt" id='patient_payable' ><%=patient_payable%> </td>  
					<td class="label" align="right" style="display:none"><fmt:message key="ePH.PrintPrescription.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td align="left"> <input type="checkbox" name="print_pres_on_regn_yn" id="print_pres_on_regn_yn" <%=printPresOnRegnYN%> style="visibility:hidden"> </td>
					<td align="right"><input type="button" name="btnRegisterPres" id="btnRegisterPres" value='<fmt:message key="Common.Register.label" bundle="${common_labels}"/>' class="button" onClick="registerPrescription()" >
					</td> 
				</tr>
			</table>
			<input type="hidden" name="print_pres_on_regn_yn_hidden" id="print_pres_on_regn_yn_hidden"  value="<%=print_pres_on_regn_yn%>">
			<input type="hidden" name="issue_token_on_regn_yn" id="issue_token_on_regn_yn"  value="<%=issue_token_on_regn_yn%>">
			<input type="hidden" name="displayGrossAmtYn" id="displayGrossAmtYn"  value="<%=displayGrossAmtYn%>">	<!-- added for ML-BRU-CRF-0469 -->
		</form>
<%
		//if(billing_interface_yn.equals("Y")){
			if(dPatientPayable>0){ //added for Bru-HIMS-CRF-094 [IN:029959]
%>
				<script>
					setTimeout("displayPayeeIndicator('Y')",500);
				</script>
<%
			}
			else if(billing_interface_yn.equals("Y")){
%>
				<script>
					checkChargeDetailsForOtherOrders();
				</script>
<%
			}
	//	}
%>
	</body>
</html>

