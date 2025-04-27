<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
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
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedicationAllStages.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	Connection con			= null;   //GHL-CRF-0549

	try{
	con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
    boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
	boolean formulary_billing_app = CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618

	
	String	bean_id				=	"DispMedicationAllStages" ;
	String	bean_name			=	"ePH.DispMedicationAllStages";
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request ) ;
	//bean.setLanguageId(locale);
	String	bean_id_1			=	"DispMedicationBean" ;
	String	bean_name_1			=	"ePH.DispMedicationBean";
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
	//bean_1.setLanguageId(locale);
	ArrayList	delivery_det	=	bean_1.getDeliveryDetails();
	Hashtable legend			=	bean_1.getLegendsFromParam();
	String title				=	"";
	String called_from			=	request.getParameter("called_frm")==null?"":request.getParameter("called_frm");
	String alt_drug_status		=	request.getParameter("alt_drug_status")==null?"":request.getParameter("alt_drug_status");
	String drug_code			=	request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String order_id				=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String drug_desc			=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
	String order_line_no		=	request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
	String source				=	request.getParameter("source")==null?"":request.getParameter("source");
	String oper_mode			=	request.getParameter("oper_mode");
	String barcode_flg			=	request.getParameter("barcode_flg"); //Added for KDAH-CRF-0231 [IN-034551] 
	String disabled             =	"enabled";
	String rec_no	= 	request.getParameter("rec_no")==null?"0":request.getParameter("rec_no");//rec_no to find grid contains data for barcode added for KDAH-CRF-0231 [IN-034551]
	String alt_drug_remarks_ind = bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
	if(source.equals("Alloc")) {
		if(legend.containsKey("A"))
			title	+=	(String)legend.get("A");
	}
	else if(source.equals("Fill")) {
		if(legend.containsKey("F"))
			title	+=	(String)legend.get("F");
	}

	String module_id		=	bean.getModuleId();
	String status			=	"";
	String bt_status		=	"";
	String value			=	"";
	String onClick			=	"";
	String width			=	"";
	String align			=	""; 
	String retVal			=	"";

	if(alt_drug_status.equals("Y"))
		status	=	"enabled";
	else
		status	=	"disabled";

	if(module_id.equals("2")){
		width	=	"97%";
		align	=	"left";
	}
	else	{
		width	=	"100%";
		align	=	"center";
	}
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="allocateDrugsButton" id="allocateDrugsButton">
			<table cellpadding="0" cellspacing="0" width="<%=width%>" align="<%=align%>" border="1">
<%	
				if(called_from.equals("multi"))	{	
					if(module_id.equals("2"))
						retVal	=	"window.returnValue='"+source+"';";
					else
						retVal	=	"";



						
						
%>
					<tr>
<%
						if(item_type_site_app && !formulary_billing_app){	//GHL-CRF-0549 and !formulary_billing_app added for GHL-CRF-0618
%>
								<td class="white" align="left"><img src="../../ePH/images/LowCost.jpg" height='15' width='15' >
								<td>
								<fmt:message key="ePH.LowCostItem.label" bundle="${ph_labels}"/>
								</td >
								<td class="white" align="left"><img src="../../ePH/images/HighMargin.jpg" height='15' width='15' ></td>
								<td class="white" align="left"><fmt:message key="ePH.HighMarginItem.label" bundle="${ph_labels}"/>
								</td>
								<td class="white" align="left"><img src="../../ePH/images/Innovator.jpg" height='15' width='15' ></td><td class="white" align="left">
								<fmt:message key="ePH.Innovator.label" bundle="${ph_labels}"/>
						</td>
						<%}%>
						<%if(formulary_billing_app)  //Start of GHL-CRF-0618
						{%>
					
							<td class='white' width='1%'></td>	
							 <td class="white" align="left">
									<img src="../../ePH/images/Preference1.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem1.label" bundle="${ph_labels}"/>&nbsp;</td>
												
								<td class="white" align="left">
									<img src="../../ePH/images/Preference2.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem2.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference3.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem3.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference4.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.NonPreferedItem.label" bundle="${ph_labels}"/>&nbsp;</td>
							
							<%
							}%>    <!-- End of GHL-CRF-0618 -->

						<td  class='white'align="right">
						<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="storeValues('<%=source%>');<%=retVal%>"><!-- //source Added for Bru-HIMS-CRF-399 [IN:043767] -->
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="window.returnValue='';parent.window.close()"></td><!-- //window.returnValue Added for Bru-HIMS-CRF-399 [IN:043767] -->
					</tr>
<%
				}
				else if(called_from.equals("stock")) {	
%>
					<tr> 
<%		
						if(module_id.equals("2") ) {	
%>
							<%-- <td class='white' width='19%' style="font-size:9;font-weight:bold" ><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></td>
							<td class='white' width='3%'><HR style="color:#FF0000" width="80%"></td>
							<td class='white' width='3%'><HR style="color:#669900" width="80%"></td>
							<td class='white' width='3%'><HR style="color:#FF9966" width="80%"></td> --%>
							<td class='white' width='19%' style="font-size:9px; font-weight:bold;"><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></td>
							<td class='white' width='3%'><hr style="color:#FF0000; width:80%; border: 1px solid #FF0000;"></td>
							<td class='white' width='3%'><hr style="color:#669900; width:80%; border: 1px solid #669900;"></td>
							<td class='white' width='3%'><hr style="color:#FF9966; width:80%; border: 1px solid #FF9966;"></td>
							<!-- <td class='white' width='3%'><HR style="color:#6699CC" width="80%"></td> -->
<%
						}
						if(source.equals("Alloc")){
							onClick	=	"refreshAllocation()";
						}
						else {
							onClick	=	"refreshFilling()";
						}
%>
						<td class='white' width="18%" style="font-size:9px;font-weight:bold" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.NoStock.label" bundle="${ph_labels}"/></td>
						<td class='white' width='2%' ><img src='../../eCommon/images/disabled.gif'></td> 
						<td  class="white" width="48%">&nbsp;&nbsp;<input type="button" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class="button" onClick="callPreview('<%=patient_id%>','<%=order_id%>')"><input type="button" value='<fmt:message key="Common.complete.label" bundle="${common_labels}"/> <%=title%>' class="button" onClick="<%=onClick%>"></td>
					</tr>
<%
				}//ePH.forDrug.label
				else if(called_from.equals("stock_add")) {
					if(source.equals("Alloc")){
						value	=	title + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.forDrug.label","ph_labels");
					}
					else if(source.equals("Fill")) {
						//value	=	title+" for Drug";
						  value	=	title+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.forDrug.label","ph_labels");
					}
%>
					<tr>
						<td class="white">
<%
						//Added for Bru-HIMS-CRF-076 [IN:034551]		  
						if(bean_1.getStockDtl().get("barcode_id")!=null && !bean_1.getStockDtl().get("barcode_id").equals("")){
							bean_1.setBarcode_id(bean_1.getStockDtl().get("barcode_id").toString());
						}
%>
						<input type="button" value='<fmt:message key="ePH.Auto.label" bundle="${ph_labels}"/>  <%=value%>' class="button" onClick="if(callStockAdd('batch','auto')){}" name="auto_alloc_butt" >
						</td>
						<td  class="white">
						<input type="button" value="<%=value%>" class="button" onClick="if(callStockAdd('batch','normal')){}" name="stock_alloc_butt"><input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" onClick="resetStockForm()">
						</td>
					</tr>
<%
				}
				else if(called_from.equals("add") || called_from.equals("init"))	{	
					//value	=	"Close";
					value	=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels");

					if(!bean.getQuantity(patient_id,order_id))
					bt_status	="disabled";
					
					if(source.equals("Alloc")){
						onClick	=	"refreshAllocation()";
					}
					else if(source.equals("Fill")) {
						onClick	=	"refreshFilling()";
					}
					if(delivery_det!=null && delivery_det.size() > 1) {
						onClick		=	"parent.window.close()";
						bt_status	=	"enabled";
					}
%>
					<%-- <tr>
						<td class='white' width='23%' style="font-size:9;font-weight:bold" ><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></td>
						<td class='white' width='3%'><HR style="color:#FF0000" width="80%"></td>
						<td class='white' width='3%'><HR style="color:#669900" width="80%"></td>
						<td class='white' width='3%'><HR style="color:#FF9966" width="80%"></td>
						<td class='white' width='3%'><HR style="color:#6699CC" width="80%"></td>
						<td  class="white" width="65%">&nbsp;&nbsp;<input type="button" name="complete_alloc" id="complete_alloc" value="<%=value%>" class="button" <%=bt_status%> onClick="<%=onClick%>"></td>
					</tr> --%>
					<tr>
   						<td class='white' width='23%' style="font-size:9px; font-weight:bold;"><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></td>
   						<td class='white' width='3%'><hr style="border: 1px solid #FF0000; width: 80%;"></td>
   						<td class='white' width='3%'><hr style="border: 1px solid #669900; width: 80%;"></td>
   						<td class='white' width='3%'><hr style="border: 1px solid #FF9966; width: 80%;"></td>
   						<td class='white' width='3%'><hr style="border: 1px solid #6699CC; width: 80%;"></td>
    					<td class="white" width="65%">&nbsp;&nbsp;<input type="button" name="complete_alloc" id="complete_alloc" value="<%=value%>" class="button" <%=bt_status%> onClick="<%=onClick%>"></td>
</tr>
					
<%
				}
				else{	
					if(source.equals("Fill"))
						status="disabled";
					if(delivery_det!=null && delivery_det.size() > 1) {
	
%>
						<tr><td  class="white">&nbsp;</td></tr>
<%
					}
					else{	
						if(source.equals("Alloc")){
							value	=	title;
						}
						else if(source.equals("Fill")) {
							//value	=	"Fill";
							value	=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Fill.label","ph_labels");
						}
%>
						<tr>
<%	
							if(module_id.equals("2")) {	
%>
								<td class='white' width='25%' style="font-size:9;font-weight:bold" ><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></td>
								<td class='white' width='3%'><HR style="color:#FF0000" width="80%"></td>
								<td class='white' width='3%'><HR style="color:#669900" width="80%"></td>
								<td class='white' width='3%'><HR style="color:#FF9966" width="80%"></td>
								<td class='white' width='3%'><HR style="color:#6699CC" width="80%"></td>
<%
							}
%>
							<td  class="white" align='right'>
							<input type="button" value="<%=value%>" class="button" onClick="callAdd('batch')"><input type="button" value='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>' class="button" <%=status%> onClick="callMultiStrength('<%=drug_code%>','<%=drug_desc%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=source%>','','','','<%=alt_drug_remarks_ind%>')"><input type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'class="button" onClick="resetForm()">
<%
							if(module_id.equals("2")) {
%>
								<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="parent.window.close()">
<%	
							}
%>
							</td>
						</tr>
<%
					}
				}	
%>
			</table>
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		</form>
	</body>
	<script>
		callAutoFill('<%=oper_mode%>')
	</script>
</html>
<%	}
	catch(Exception e){
		e.printStackTrace();
	}finally{ 
        	if(con != null)
          		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
	}
//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id_1,bean_1,request);
%>

