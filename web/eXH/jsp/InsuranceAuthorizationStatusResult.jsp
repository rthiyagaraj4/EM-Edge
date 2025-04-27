<!DOCTYPE html>
<%
/*
Added by Niveditha For MOHE-CRF-0026.3
*/
%>

<%@page import="java.util.*, java.util.HashMap, java.sql.*, eXH.*,webbeans.eCommon.*, eCommon.Common.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String login_user ="", facilityId = "", strClientIpAddress = "";
		Connection con = null;
		Properties p = null;
		HttpSession httpSession = request.getSession(false);
		p = (Properties)httpSession.getValue("jdbc"); 
		facilityId = ""+httpSession.getAttribute("facility_id");
		strClientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		
		login_user = p.getProperty("login_user");
		String locale = (String)session.getAttribute("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		int sNo=0;
		
		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		String fromDate_search = request.getParameter("fromDate_search") == null ? "" : request.getParameter("fromDate_search");
		String toDate_search = request.getParameter("toDate_search") == null ? "" : request.getParameter("toDate_search");
		String episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
		String disp_location = request.getParameter("disp_location") == null ? "" : request.getParameter("disp_location");
		String auth_status = request.getParameter("auth_status") == null ? "" : request.getParameter("auth_status");

		List<PatientDetails> oSummGroupCompList = null;
		InsuranceAuthStatusBean bean = null;
		PatientDetails sSummGroupBean = null;
		List<PatientDetails> checkauthstatus = null;
		
		
		
		String patidSubGroup="", episodeidSubGroup="", encounteridSubGroup="", dispnoSubGroup="", drugcodeSubGroup="", orderlinenumSubGroup="", orderidSubGroup="", catdescSubGroup="", authstatusSubGroup="",authstatusdescSubGroup="", dispqtySubGroup="", dispuomcodeSubGroup="", patientclassSubGroup="", basepriceSubGroup="",basepriceopSubGroup="", basepriceipSubGroup="", basepricerfSubGroup="", basepriceemSubGroup="", basepricedcSubGroup="", prevSubGroup = "", currentSubGroup = "", emptySubGroup = "", itemcodeSubGroup="", benefitValueSubGroup="", getauthstatuscheck="", benefitCurrencySubGroup="", displocncodeSubGroup="" ,orderdatetimeSubGroup="", claimIdSubGroup="", approvalNoSubGroup="";
		
		int compFlag = 0, compTemplate = 0, compColumns = 0, j = 0, nGroupCompListSize = 0, k = 0, noOfRows1 = 0, ctr=0, cnt = 0, sequenceNumber = 0, colSpan = 6, srlNo = 1;

		boolean subGroupFlag = false;
		
		
		
	try
	{

		con = ConnectionManager.getConnection(request);

		bean = new InsuranceAuthStatusBean();

		oSummGroupCompList = (ArrayList)bean.getInsAuthStatusRecordsDetails(patient_id,encounter_id,fromDate_search,toDate_search,episode_type,disp_location,auth_status,facilityId);		
		
		sSummGroupBean = new PatientDetails();	
		nGroupCompListSize = oSummGroupCompList.size();	

		checkauthstatus = new ArrayList<PatientDetails>();

%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script  language="javascript" src="../../eXH/js/InsAuthStatus.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
	<script language='javascript' src='../../eXH/js/ExternalApplication.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
   <form name ="InsuranceAuthorizationStatusResultForm" action="../../servlet/eXH.InsAuthStatusResultServlet" method=post target="messageFrame">
<%

if(nGroupCompListSize==0){
		%>
		<script>errorCall()</script>

<%	
}	else{
	%>
	<div id='table_container_left' style='overflow:auto;width:100%;height:100%;' style="margin:0px auto; padding:0px 5px;">  
	<table  width="100%"  class='grid' id='titleTable'>
	
		  <tr style='height:100%;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2);'>
			<th width="5%" class='COLUMNHEADER' ><fmt:message key="eXH.AutoCheckBox.label" bundle="${xh_labels}"/></th>
			<th width="8%" class='COLUMNHEADER' align="left"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th width="8%" class='COLUMNHEADER' align="left"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
			<th width="20%" class='COLUMNHEADER' align="left"><fmt:message key="eXH.OrderidItemDesc.label" bundle="${xh_labels}"/>
			<th width="8%" class='COLUMNHEADER' align="left"><fmt:message key="eXH.AuthorizationStatus.label" bundle="${xh_labels}"/>
			<th width="8%" class='COLUMNHEADER' align="left"><fmt:message key="eXH.ItemPrice.label" bundle="${xh_labels}"/>
			<th width="8%" class='COLUMNHEADER' align="left"><fmt:message key="eXH.AllocatedQty.label" bundle="${xh_labels}"/>
			<th width="8%" class='COLUMNHEADER' align="left"><fmt:message key="eXH.ApprovedAmt.label" bundle="${xh_labels}"/>
			<th width="10%" class='COLUMNHEADER' ><fmt:message key="eXH.StsValidBillGen.label" bundle="${xh_labels}"/>
        </tr>
		

<%		

	for (int i=0;i<nGroupCompListSize;i++){
							
		sSummGroupBean = oSummGroupCompList.get(i);
		patidSubGroup = sSummGroupBean.getPatientId();
		encounteridSubGroup = sSummGroupBean.getEncounterId();
		dispqtySubGroup = sSummGroupBean.getDispQty();
		dispuomcodeSubGroup = sSummGroupBean.getDispUomCode();
		dispnoSubGroup = sSummGroupBean.getDispNo();
		drugcodeSubGroup = sSummGroupBean.getDispDrugCode(); 
		orderidSubGroup = sSummGroupBean.getOrderId();
		patientclassSubGroup = sSummGroupBean.getPatientClass();
		basepriceSubGroup = sSummGroupBean.getNetPrice();
		itemcodeSubGroup = sSummGroupBean.getItemCode();
		getauthstatuscheck = sSummGroupBean.getAuthStatus();
		catdescSubGroup = sSummGroupBean.getShortDesc();
		orderlinenumSubGroup = sSummGroupBean.getSrlNo();
		benefitValueSubGroup = sSummGroupBean.getBenefitValue();
		benefitCurrencySubGroup = sSummGroupBean.getBenefitCurrency();
		displocncodeSubGroup = sSummGroupBean.getDispLocnCode();
		orderdatetimeSubGroup = sSummGroupBean.getOrderDateTime();
		claimIdSubGroup = sSummGroupBean.getClaimId();
		approvalNoSubGroup = sSummGroupBean.getApprovalNo();

		currentSubGroup = dispnoSubGroup;
		
		subGroupFlag = false;
		
			if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){
				subGroupFlag = true;
				out.println("<tr id = 'trGrpHeader"+j+"'>");
				out.println("<td class='CAGROUP' style='padding-left:10px; padding-right:10px;' > </td>");
				out.println("<td class='CAGROUP'> ");
				out.println("<input type='hidden' name = 'comp_subgroup"+j+"' value = '"+patidSubGroup+"' >");					
				out.println(patidSubGroup+" </td>");
				out.println("<td class='CAGROUP'>"+encounteridSubGroup+"</td>");
				out.println("<td class='CAGROUP'>"+orderidSubGroup+" / "+dispnoSubGroup+"</td>");
				out.println("<td class='CAGROUP'></td>");
				out.println("<td class='CAGROUP'></td>");
				out.println("<td class='CAGROUP'></td>");
				out.println("<td class='CAGROUP'></td>");	
	
				if("P".equals(getauthstatuscheck)){
					out.println("<td class='CAGROUP'><a href='#' onClick='generatebill()' / > Generate Bill </a></td>");
				}else{
					out.println("<td class='CAGROUP'>Generate Bill</td>");
				}
				
				out.println("<td class='gridData' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+j+"' id='seq_num_text"+j+"' value = '"+j+"'> </td>");
				
				out.println("</tr>");
				noOfRows1 = 0;
				k = j;
				
				j++;
								
			}
			
			out.println("<td style='display:none'> <input type='hidden' name ='patient_id_value"+j+"' value = '"+patidSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='encounter_id_value"+j+"' value = '"+encounteridSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='disp_no_value"+j+"' value = '"+dispnoSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='drug_code_value"+j+"' value = '"+drugcodeSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='order_line_num_value"+j+"' value = '"+orderlinenumSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='order_id_value"+j+"' id='order_id_value"+j+"' value = '"+orderidSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='disp_qty_value"+j+"' id='disp_qty_value"+j+"' value = '"+dispqtySubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='disp_uom_code_value"+j+"' id='disp_uom_code_value"+j+"' value = '"+dispuomcodeSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='patient_class_value"+j+"' id='patient_class_value"+j+"' value = '"+patientclassSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='claim_id_value"+j+"' id='claim_id_value"+j+"' value = '"+claimIdSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='approval_no_value"+j+"' id='approval_no_value"+j+"' value = '"+approvalNoSubGroup+"' > </td>");
			out.println("<tr width='100%' id = 'trGrpHeader'>");
			out.println("<td class='gridDataChart'> <input type='checkbox' id='checkbox' name='secChk"+j+"' id='secChk"+j+"' onclick=\"selectedRecord(this)\"> </td>");
			out.println("<td class='gridDataChart'></td>");
			out.println("<td class='gridDataChart'></td>");
			out.println("<td class='gridDataChart'>"+catdescSubGroup+"</td>");	
			
			if(null != getauthstatuscheck && !"".equals(getauthstatuscheck)){
				if("N".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Pending";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("P".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Approved";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("E".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Rejected";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("R".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Partially Approved";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("S".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Submitted";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else{
				authstatusdescSubGroup ="Pending";
				getauthstatuscheck = "N";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
			}else{
				authstatusdescSubGroup ="Pending";
				getauthstatuscheck = "N";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
			}
		
			out.println("<td class='gridDataChart'>"+basepriceSubGroup+"</td>");
			out.println("<td style='display:none'> <input type='hidden' name='base_price_value"+j+"' id='base_price_value"+j+"' value = '"+basepriceSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='approved_amount_value"+j+"' id='approved_amount_value"+j+"' value = '"+benefitValueSubGroup+"' > </td>");
			
			out.println("<td class='gridDataChart'>"+dispqtySubGroup+"</td>");

			if(null != benefitValueSubGroup && !"".equals(benefitValueSubGroup)){
				out.println("<td class='gridDataChart'>"+benefitValueSubGroup+"</td>");
			}else{
				out.println("<td class='gridDataChart'></td>");
			}
			
			out.println("<td class='gridDataChart'></td>");
			
			out.println("</tr>");

			out.println("<td class='gridData' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+j+"' id='seq_num_text"+j+"' value = '"+j+"'> </td>");
			
			out.println("</tr>");																
					
			j++;
			cnt++;
			srlNo++;
	
			prevSubGroup = currentSubGroup;
							
	} 
	
	}
	
	}catch(Exception e){
		out.println("Exception in try of InsuranceAuthorizationStatusResult.jsp"+e.toString());
		e.printStackTrace();
	}%>

	</table>
	</div>
	
<input type="hidden" value="<%=srlNo-1%>" name="count" />
<input type="hidden" value="<%=j%>" name="countrows" />
<input type='hidden' name='locale' id='locale' value ='<%=locale%>'>  
<input type='hidden' name='facilityId' id='facilityId' value ='<%=facilityId%>'>  
<input type='hidden' name='login_user' id='login_user' value ='<%=login_user%>'>  
<input type='hidden' name='strClientIpAddress' id='strClientIpAddress' value ='<%=strClientIpAddress%>'>  

</form>
</body>
</html>

