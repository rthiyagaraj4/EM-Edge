<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.io.*,java.util.Hashtable, java.util.HashMap,ePH.*,ePH.SetupAuditLogBean, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
		<Title><fmt:message key="ePH.DeliveryBin.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></Title>
<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body>
<%
		try{
			String	bean_id			=	"DispMedicationBean" ;
			String	bean_name		=	"ePH.DispMedicationBean";
			DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);

			String	bean_id_2		=	"DispMedicationAllStages" ;
			String	bean_name_2		=	"ePH.DispMedicationAllStages";
			DispMedicationAllStages bean_2	= (DispMedicationAllStages)getBeanObject( bean_id_2, bean_name_2, request);
             bean_2.setObject(bean);//Added for TH-KW-CRF-0020.9
			String token_series = request.getParameter("token_series")==null?"":request.getParameter("token_series");
			String patient_arvd = request.getParameter("patient_arvd");
			String patient_id	= request.getParameter("patient_id");
			String curr_stage	=	request.getParameter("curr_stage")==null?"":request.getParameter("curr_stage");
			String facility_id					= (String) session.getValue("facility_id");
			String ordering_facility_id					= request.getParameter("ordering_facility_id");// added for ML-BRU-SCF-0792 [IN:039236]
			String disp_locn_code	=	bean.getDispLocnCode();
			String storage_locn_appl_yn =  request.getParameter("storage_locn_appl_yn");
			String token_no				= "";
			String delivery_bin_yn =  request.getParameter("delivery_bin_yn");//Added for TH-KW-CRF-0020.9
			String encounter_id =  request.getParameter("encounter_id");//Added for TH-KW-CRF-0020.9
			ArrayList arrTokenList = new ArrayList();//Added for HSA-CRF-0136 [IN:048412]
			bean.setOrderingFacility(ordering_facility_id);// added for ML-BRU-SCF-0792 [IN:039236]
			ArrayList result = bean.getOrders(patient_id.trim());

			ArrayList storage_locns = (ArrayList)bean_2.getStrNamesDispLocn(disp_locn_code);
			String storage_location_code = (String)bean_2.getStorageLocation(disp_locn_code,token_series,patient_id);
%>
			<form name="DispMedicationStorageLocation" id="DispMedicationStorageLocation">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
					<tr><td class="white" colspan="7">&nbsp;</td></tr>
					<tr><td class="label" colspan="7">&nbsp;</td></tr>
<%
					if(storage_locns!= null && storage_locns.size()>0){
%>
						<TR>
							<td class="label" align='right'><fmt:message key="ePH.DeliveryBin.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td class="label" align="right">
								<select name="storage_locn" id="storage_locn">
								<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>    
<%
								if(storage_locns!= null && storage_locns.size()>0){	
									for(int i=0;i<storage_locns.size();i=i+2){
										if(storage_location_code.equals((String)storage_locns.get(i))){
%>
											<option value="<%=storage_locns.get(i)%>" selected><%=storage_locns.get(i+1)%></option>	
<%				
										}
										else{
%>
											<option value="<%=storage_locns.get(i)%>"><%=storage_locns.get(i+1)%></option>
<%	
										}
									}
								}
%>
								</select>
							</td>
							<td>&nbsp;&nbsp;<td>
						</TR>
<%
					}
					else{
%>
						<TR>
							<td class="label" align='right'><fmt:message key="ePH.DeliveryBin.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td class="label" align="right">
								<select name="storage_locn1" id="storage_locn1">
									<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>   
								</select>
							</td>
							<td colspan="5" height="20">&nbsp;&nbsp;<input type="hidden" name="storage_locn" id="storage_locn" value="">
							<td>
						</TR>
<%
					}
%>
					<tr><td class="label" colspan="7">&nbsp;</td></tr>
					<tr><td class="white" colspan="7">&nbsp;</td></tr>
					<tr>
						<td align="right" colspan="3" class="white">
						<input type="button" class="button" name="rec_ref1" id="rec_ref1" value="OK" onClick="updateStorageLocation(document.DispMedicationStorageLocation,'<%=token_series%>','<%=patient_id%>','<%=patient_arvd%>','<%=encounter_id%>','<%=delivery_bin_yn%>');"><!-- delivery_bin_yn and encounter_id added for TH-KW-CRF-0020.9 -->
						&nbsp;&nbsp;&nbsp;</td>
					</tr>
<%
			if(delivery_bin_yn.equals("N")){//Added fi condition alone for TH-KW-CRF-0020.9
					if(token_series.equals("*A"))//Added for HSA-SCF-0081 [IN:050227]
						token_series="";
					for(int i=0;i<result.size();i=i+11){
						token_no	= bean.getTokenNo();
						if(!token_no.equals("") && !token_series.equals(""))//Condition && !token_series.equals("") added for HSA-CRF-0136 [IN:048412]
							bean_2.setTokenVals((String)result.get(i+1),token_series+"_"+token_no);//Moved here for HSA-CRF-0136 [IN:048412]
						if(token_no.equals("") || token_series.equals("")){//Condition || token_series.equals("") added for HSA-CRF-0136 [IN:048412]
							arrTokenList	=	bean.getTokenDetails(disp_locn_code,patient_id,token_series,(String)result.get(i+1));
							if(arrTokenList!=null && arrTokenList.size()>0)		//Added for HSA-CRF-0136 [IN:048412]
								bean_2.setTokenVals((String)result.get(i+1),(String)arrTokenList.get(0)+"_"+(String)arrTokenList.get(1));//Added for HSA-CRF-0136 [IN:048412]
						}
					}
				}
%>
				</table>
				<input type="hidden" name="sysdate" id="sysdate"			value="<%=bean_2.getCurrDate()%>">
				<input type="hidden" name="bean_id_2" id="bean_id_2"		value="<%=bean_id_2%>">
				<input type="hidden" name="bean_name_2" id="bean_name_2"		value="<%=bean_name_2%>">
				<input type="hidden" name="curr_stage" id="curr_stage"		value="<%=curr_stage%>">	
				<input type="hidden" name="disp_locn_code" id="disp_locn_code"	value="<%=disp_locn_code%>">
			</form>
<%
			if(storage_locn_appl_yn.equals("N")){
%>
				<script>
					document.DispMedicationStorageLocation.storage_locn.value = "";
					document.DispMedicationStorageLocation.rec_ref1.click();
				</script>
<%
			}
		}
		catch(Exception es){
			es.printStackTrace();
		}
%>
	</body>
</html>

