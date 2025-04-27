<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!--modified for AAKH-CRF-0117 --> 
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../js/ReissueMed.js"></script>
		<script language="JavaScript" src="../js/PhMessages.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<!-- <body topmargin=0 leftmargin=0> -->
	<body topmargin=0 leftmargin=0 onMouseDown="" onKeyDown="lockKey()">
		<form name="FormReissueMedicationIssuedResult" id="FormReissueMedicationIssuedResult" >
<%		
		Connection con			= null; //AAKH-CRF-0117
		try{
		con				= ConnectionManager.getConnection(request);//AAKH-CRF-0117
			String classvalue		=	"";
			String order_id			= request.getParameter("orderid");	
			String order_line_no	= request.getParameter("orderlineno");
			String drug_code		= request.getParameter("drug_code");
			String item_code		= request.getParameter("item_code");
			String qty				= request.getParameter("qty");
			String qty_uom			= request.getParameter("qty_uom");
			String no				= request.getParameter("no");
			String store_code		= request.getParameter("store_code");
			String end_date			= request.getParameter("end_date");
			String patient_class	= request.getParameter("patient_class");
			String fill_period		= request.getParameter("fill_period");
			String fill_unit		= request.getParameter("fill_unit");
			String rec_no			= request.getParameter("rec_no");			
			String patientid		= request.getParameter("patient_id");			
			String bl_interface_yn	= request.getParameter("bl_interface_yn"); 
			String Disp_facility_id = request.getParameter("Disp_facility_id");// Disp_facility_id added for FD-BRU-CRF-092
		
			String bean_id		= "ReissueMedBean" ;
			String bean_name	= "ePH.ReissueMedBean";
			ReissueMedBean bean = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;	
			bean.setLanguageId(locale);
			String facility_id					= (String) session.getValue("facility_id");
			ArrayList result = bean.getReissuedRecords(order_id,order_line_no);
			int tot_qty		=	0;
			boolean issued	=	false;
			int count=0;//Added for Bru-HIMS-CRF-405 [IN044830]
			boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117
%>
			<table width='100%' border="1">
				<tr>
					<th colspan="9" align="left"><fmt:message key="ePH.ReIssuedDetails.label" bundle="${ph_labels}"/></th>
				</tr>
				<tr>
					<th width="30%"><fmt:message key="ePH.DispensedDrug.label" bundle="${ph_labels}"/></th>
					<th width="14%"><fmt:message key="ePH.ReissueFacility.label" bundle="${ph_labels}"/></th> <!-- Added for FD-BRU-CRF-092 --> 
					<th width="14%"><fmt:message key="ePH.ReissueLocation.label" bundle="${ph_labels}"/></th>  <!-- Added for FD-BRU-CRF-092 -->
					<th width="14%"><fmt:message key="ePH.DispensedTime.label" bundle="${ph_labels}"/></th>
					<th width="6%"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
					<th width="10%"><fmt:message key="ePH.Re-issuedQuantity/UOM.label" bundle="${ph_labels}"/></th>    
					<th width="20%"><fmt:message key="ePH.ReissueReason.label" bundle="${ph_labels}"/></th> 
					<%if(approval_no_flag){ //added for AAKH-CRF-0117 
					%>
					<th width="5%" nowrap> <fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;</th>
					<%} %>

				</tr>
<%
				for(int i=0; i<result.size(); i+=9) { // Modified for Issuee 11510  only count increse by 1 and changed 8 to 9 for AAKH-CRF-0117-->
					if(i%2==0)
					  classvalue = "QRYODDSMALL" ;
					else
					   classvalue = "QRYEVENSMALL" ;
%>
					<tr>
						<td class="<%=classvalue%>" align="center"><%=(String)result.get( i )%></td>
						<td class="<%=classvalue%>" align="center"><%=(String)result.get(i +7)%></td> <!-- Added for FD-BRU-CRF-092 -->
						<td class="<%=classvalue%>" align="center"><%=(String)result.get(i +6)%></td><!-- Added for FD-BRU-CRF-092 -->
						<td class="<%=classvalue%>" align="center"><%=com.ehis.util.DateUtils.convertDate((String)result.get( i +3 ),"DMYHM","en",locale)%></td>
						<td class="<%=classvalue%>" align="center"><%=(String)result.get( i +2 )%></td>
						<!-- <td class="<%=classvalue%>" align="center"><%=(String)result.get( i +1 )%>/
						<%=(String)result.get( i +4 )%></td><!-- Modified for Issuee 11510 -->
						<td class="<%=classvalue%>" align="center"><%=(String)result.get( i +1 )%>/
						<%=bean.getUomDisplay(facility_id,result.get(i+4).toString())%></td>
						<td class="<%=classvalue%>" align="center"><%=(String)result.get( i +5 )%></td>
						<%if(approval_no_flag){ //added for AAKH-CRF-0117 
						%>
						<td class="<%=classvalue%>" align="center"><%=(String)result.get( i +8 )%></td>
					<%	}
					%>
					</tr>
<%	
					tot_qty	+=	Integer.parseInt((String)result.get( i +1 )	);
					count++;//Added for Bru-HIMS-CRF-405 [IN044830]
				}
				if(Integer.parseInt(qty) <=0)
					issued = true;
				/*if(tot_qty < Integer.parseInt(qty)){
					qty	=	(Integer.parseInt(qty)-tot_qty)+"";
				}
				else {
					issued	=	true;
				}*/
%>
				<input type="hidden" name="tot_qty" id="tot_qty"								value="<%=tot_qty%>"><!--Added for Bru-HIMS-CRF-405 [IN044830]-->
				<input type="hidden" name="tot_count" id="tot_count"							value="<%=count%>"><!--Added for Bru-HIMS-CRF-405 [IN044830]-->	
				<input type="hidden" name="bl_interface_yn" id="bl_interface_yn"						value="<%=request.getParameter("bl_interface_yn")%>">	
				<input type="hidden" name="tot_groos_pat_payable_str" id="tot_groos_pat_payable_str"	value="<%=request.getParameter("tot_groos_pat_payable_str")%>">	
				<input type="hidden" name="tot_gross_charge_amount_str" id="tot_gross_charge_amount_str"	value="<%=request.getParameter("tot_gross_charge_amount_str")%>">		 
				<input type="hidden" name="reissue_drug_name" id="reissue_drug_name"	value='<%=request.getParameter("reissue_drug_name")%>'> <!--  added for ML-BRU-SCF-1073 by Ganga-->		
			</table>
		</form>
	</body>
	<script>
<% 
		if(issued) {
%>
			var  bl_interface_yn            = document.FormReissueMedicationIssuedResult.bl_interface_yn.value;
			var tot_groos_pat_payable_str   = document.FormReissueMedicationIssuedResult.tot_groos_pat_payable_str.value;
			var tot_gross_charge_amount_str = document.FormReissueMedicationIssuedResult.tot_gross_charge_amount_str.value;
			if(bl_interface_yn=="Y"){
				parent.f_query_add_mod_result_det.location.href="../../eCommon/html/blank.html";
				parent.buttonFrame1.location.href="../../ePH/jsp/ReissueMedButtons.jsp?called_from=message"+"&bl_interface_yn="+bl_interface_yn+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str;
			}
			else{
				parent.f_query_add_mod_result_det.location.href="../../eCommon/html/blank.html";
				parent.buttonFrame1.location.href="../../ePH/jsp/ReissueMedButtons.jsp?called_from=message"+"&bl_interface_yn="+bl_interface_yn;
			}
<%
		}	
		else{
%>

			loadStockDetails('<%=drug_code%>','<%=item_code%>','<%=patientid%>','<%=order_id%>','<%=order_line_no%>','<%=qty%>','<%=qty_uom%>','<%=no%>','<%=store_code%>','<%=end_date%>','<%=patient_class%>','<%=fill_period%>','<%=fill_unit%>','<%=rec_no%>','<%=Disp_facility_id%>' , document.FormReissueMedicationIssuedResult.reissue_drug_name);  //Disp_facility_id added for FD-BRU-CRF-092							  		
<%	
		}
%>
	</script>
<%
	putObjectInBean(bean_id,bean,request);
}catch(Exception e){ //AAKH-CRF-0117 - start
		e.printStackTrace();
	}finally{  
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} //AAKH-CRF-0117 - end
%>	
</html>	

