<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
		<SCRIPT LANGUAGE="javascript" SRC="../js/PrescriptionTDM.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
<%
		String patient_id		= CommonBean.checkForNull(request.getParameter("patient_id"));
		String drug_code		= CommonBean.checkForNull(request.getParameter("drug_code"));
		String encounter_id		= request.getParameter("encounter_id");	
		String order_id		    = CommonBean.checkForNull(request.getParameter("order_id"));
		String strExistenceYn        = request.getParameter("ExistenceYn");
		String drug_desc        = request.getParameter("drug_desc");
		String order_line_num	= CommonBean.checkForNull(request.getParameter("ord_line_num"));	
        String flag				= request.getParameter("flag")==null?"":request.getParameter("flag");
		//String chkdisable		= "";
		Hashtable	 hmReason	=  new Hashtable();
		String bean_id			= "@PrescriptionTDMBean"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionTDMBean";
		String reason_for_req_code="";
		String remarks			= "";
		String smoker_yn		= "";
		String alcohlic_yn		= "";
		String pregnant_yn		= "";
		String select			= "";
		String dis_flag			= "";
		//String strOrdNo		="";
		//String strDrugCode	= "";
		String smoking_value="N";
		String alchohol_value="N";
		String pregnant_value="N";
		String tdm_order_open_close_yn_1="N";
		//String tdm_order_open_close_yn_2="N";
		ArrayList alOrdDetl		= new ArrayList();

		PrescriptionTDMBean bean	= (PrescriptionTDMBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		bean.setDrugCode(drug_code);
		bean.setOrderLineNum(order_line_num);
		bean.setPatientId(patient_id);
		bean.setOrderId(order_id);
		alOrdDetl = bean.getOrderDetails();
		for(int nCtr = 0; nCtr < alOrdDetl.size(); nCtr+=5){
			if(!(CommonBean.checkForNull((String)alOrdDetl.get(nCtr+4))).equals("")){
				tdm_order_open_close_yn_1="Y";
			}
		}
		hmReason = bean.getReasonCodes();
		if(!order_id.equals("") && !order_line_num.equals("")){
			//chkdisable=bean.chkExistence(patient_id,strOrdNo,strDrugCode); 
			if(strExistenceYn.equals("Y")){
				HashMap remarks_details=new HashMap();
				String tdm_order_id=bean.getTDMOrderId(order_id);
				remarks_details=bean.getRemarksDetails(tdm_order_id,order_line_num);
				if(tdm_order_open_close_yn_1.equals("Y")) {
					dis_flag="disabled";
				}
				reason_for_req_code=(String)remarks_details.get("REASON_FOR_REQ_CODE");
				remarks=(String)remarks_details.get("REMARKS");
				smoker_yn=(String)remarks_details.get("SMOKER_YN");
				if(smoker_yn.equals("Y")){
					smoker_yn="checked";
					smoking_value="Y";
				}
				else{
					smoker_yn="";
				}
				alcohlic_yn=(String)remarks_details.get("ALCOHLIC_YN");
				if(alcohlic_yn.equals("Y")){
					alcohlic_yn="checked";
					alchohol_value="Y";
				}
				else{
					alcohlic_yn="";
				}
				pregnant_yn=(String)remarks_details.get("PREGNANT_YN");
				if(pregnant_yn.equals("Y")){
					pregnant_yn="checked";
					pregnant_value="Y";
				}
				else{
					pregnant_yn="";
				}
			}
		}
%>
		<FORM name="formTDMPrescriptionRemarks" id="formTDMPrescriptionRemarks">
			<table cellpadding=0 cellspacing=0 width="100%"  border="0">
				<th colspan="6" style="font-size:11" align="left"> <fmt:message key="ePH.TDMRequest.label" bundle="${ph_labels}"/> - <%=drug_desc%></th>		
				<tr><td colspan ="6"></td></tr>	
				<tr>
					<td class="label"  align="right" nowrap ><fmt:message key="ePH.ReasonForrequest.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class="label"  align="left" nowrap  ><select name="reason_for_req" id="reason_for_req" onchange="setRForReq(this)" <%=dis_flag%>>
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
					if (hmReason != null){
						Enumeration enReason = hmReason.keys();
						String strReaCode = "";
						String strReaDesc = "";
						while( enReason.hasMoreElements() ){
							strReaCode = (String) enReason.nextElement();
							if(strReaCode.equals(reason_for_req_code)){
								select="selected";
							}
							strReaDesc = (String) hmReason.get(strReaCode);
%>
							<OPTION value="<%=strReaCode%>" <%=select%>><%=strReaDesc%></OPTION> 
<%
						}
					}
%>
					</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"  id="order_type_man" ></img>
					</td>         
					<td class="label"  align="left" nowrap ><fmt:message key="Common.Smoking.label" bundle="${common_labels}"/>
						<input type="checkbox" name="smoking" id="smoking" value ="<%=smoking_value%>" <%=smoker_yn %> <%=dis_flag%> onclick="setCBValue(this)">&nbsp;&nbsp; <fmt:message key="ePH.Takesalcohol.label" bundle="${ph_labels}"/>
						<input type="checkbox" name="alcohol" id="alcohol" value ="<%=alchohol_value%>" <%=alcohlic_yn %> <%=dis_flag%> onclick="setCBValue(this)">&nbsp;&nbsp; <fmt:message key="Common.Pregnant.label" bundle="${common_labels}"/>
						<input type="checkbox" name="pregnant" id="pregnant" value ="<%=pregnant_value%>" <%=pregnant_yn %> <%=dis_flag%>  onclick="setCBValue(this)">
					</td>		
				</tr>		
				<!-- </table>
				<table cellpadding=0 cellspacing=0 width="100%"  border="1"> -->
				<tr>
					<td class="label"   align ="right" nowrap ><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class ="label" align ="left" nowrap colspan=2><textarea name = "clinc_comments" rows ="2" cols = "70" <%=dis_flag%>><%=remarks%></textarea></td> 		
				</tr> 
			   <tr><td colspan ="3"></td></tr>
			   <tr><td colspan ="3"></td></tr>		
			</table>
			<table cellpadding=0 cellspacing=0 width="100%"  border="0">
				<th width = "20%" align ="left"><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
<%
				if(!flag.equals("P")){
%>
				<th width = "18%" align ="left"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
<%
				}
%>
				<th width = "18%" align ="left"><fmt:message key="ePH.SampleTypes.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.When.label" bundle="${ph_labels}"/> ?</th> 
				<th width = "18%" align ="left"><fmt:message key="ePH.SamplingTime.label" bundle="${ph_labels}"/></th>
				<th width = "28%" align ="left"><fmt:message key="ePH.LabOrders.label" bundle="${ph_labels}"/></th>
			</table>
			<input type ="hidden" name = "reason_for_request">
		</FORM>
	</body>
	<% putObjectInBean(bean_id,bean,request); %>
</HTML>

