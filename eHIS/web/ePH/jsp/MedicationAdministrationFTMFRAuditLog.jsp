<!DOCTYPE html>
 <%@page contentType="text/html; charset=UTF-8" import="java.util.*,ePH.*,eCommon.XSSRequestWrapper"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePH.AuditLogDetails.label" bundle="${ph_labels}"/></title>
<%
 		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String orderID= request.getParameter("orderId");
		String sch_date_time= request.getParameter("sch_date_time")==null?"":(String)request.getParameter("sch_date_time");
		String flow_rate_sl_no_str= request.getParameter("flow_rate_sl_no");
		String flowRateDurationUnitDesc =request.getParameter("flowRateDurationUnitDesc")==null?"":request.getParameter("flowRateDurationUnitDesc");
		String infusion_vol_str_unit_desc =request.getParameter("sch_infusion_vol_str_unit_desc")==null?"":request.getParameter("sch_infusion_vol_str_unit_desc"); 
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
		<script>
			function closeWindow(){
				window.close();
			}
		</script>
	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="MedicationAdministrationFTMFRAuditLog" id="MedicationAdministrationFTMFRAuditLog">
			<table cellpadding="0" cellspacing="0" width="102%" align="center" border="1">
				<tr>
					<td class="TDSTYLE"><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.ActionBy.label" bundle="${ph_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="TDSTYLE"><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/>&nbsp<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
<%
				try{
					String bean_id							= "MedicationAdministrationFTBean";
					String bean_name						= "ePH.MedicationAdministrationFTBean";
					MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
					
					if(sch_date_time.equals("")) 
						sch_date_time="FromMFR";
					//else// else commented and if condition added for LEAP-INT-PH-SCF-14965 [IN057864]
					if(!locale.equals("en"))
 					sch_date_time=com.ehis.util.DateUtils.convertDate(sch_date_time,"DMYHM",locale,"en");
					
					int flow_rate_sl_no=Integer.parseInt(flow_rate_sl_no_str);
					ArrayList auditLogList=bean.getMFRAuditLogDetails(orderID,flow_rate_sl_no,sch_date_time);
					HashMap auditLogMap;
					String srl_no="";
					String action="";
					String actionBy="";
					String actionDate="";
					String remarks="", prevFlowRate ="", currFlowRate="", flowRate="", dispPrevFlowRate="";

					for(int index=0;index<auditLogList.size();index++){
						auditLogMap=(HashMap)auditLogList.get(index);
						srl_no=(String)auditLogMap.get("SRL_NO");
						action=(String)auditLogMap.get("ACTION");
						flowRate=(String)auditLogMap.get("FLOW_RATE")==null?"":(String)auditLogMap.get("FLOW_RATE");
						currFlowRate = "";
						dispPrevFlowRate = "";
						if(action.equals("ST"))
							action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
						else if(action.equals("HO"))
							action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOLD.label","ph_labels");
						else if(action.equals("RE")){
							action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
							if(!flowRate.equals(prevFlowRate)){
								currFlowRate = flowRate+" "+java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")+" / "+flowRateDurationUnitDesc;
								dispPrevFlowRate = prevFlowRate+" "+java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")+" / "+flowRateDurationUnitDesc;
							}
						}
						else if(action.equals("CO"))
							action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.COMPLETED.label","ph_labels");
						else if(action.equals("FRC") )
							action="FLOW RATE CHANGED";
						else if(action.equals("CH")){
							action =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.change.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FlowRate.label","ph_labels");
							currFlowRate = flowRate+" "+java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")+" / "+flowRateDurationUnitDesc;
							dispPrevFlowRate = prevFlowRate+" "+java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")+" / "+flowRateDurationUnitDesc;
						}
						else if(action.equals("AD"))
							action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Administered.label","ph_labels");
						else
							action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NOTSTARTED.label","ph_labels");
						actionBy=(String)auditLogMap.get("ACTION_BY");
						actionDate=(String)auditLogMap.get("ACTION_TIME");
						remarks=(String)auditLogMap.get("REMARKS")==null?"&nbsp;":(String)auditLogMap.get("REMARKS");
						prevFlowRate = flowRate;
%>
						<tr>
							<td class="label"><%=(index+1)%></td>
							<td class="label"><%=action%></td>
							<td class="label"><%=actionBy%></td>
							<td class="label" nowrap><%=com.ehis.util.DateUtils.convertDate(actionDate,"DMYHM","en",locale)%></td>
							<td class="label"><%=remarks%></td>
							<td class="label">&nbsp;<%=dispPrevFlowRate%></td>
							<td class="label">&nbsp;<%=currFlowRate%></td>
						</tr>
<%		
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
%>
				<tr><td colspan=7 align="right" class='button'><input type="button" name="btnOK" id="btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="closeWindow();">&nbsp;&nbsp;&nbsp;</td></tr>
			</table>
		</form>
	</body>
</html>

