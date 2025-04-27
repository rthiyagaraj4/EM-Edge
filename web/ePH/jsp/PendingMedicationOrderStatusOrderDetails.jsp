<!DOCTYPE html>
 <%--corrected on 10/25/2005--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

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
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
		 <script language="javascript" src="../../ePH/js/PendingMedicationOrder.js"></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<!-- <body > -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frmDispMedicationPatientIDDisplay" id="frmDispMedicationPatientIDDisplay" >
<%
			String	bean_id				=	"DispMedicationAllStages" ;
			String	bean_name			=	"ePH.DispMedicationAllStages";	
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);

			String patient_id	       =	request.getParameter("patient_id");	
			String ordering_facility_code	=	request.getParameter("ordering_facility_code");
			String disp_locn_code	   =	request.getParameter("disp_locn_code");
			String called_from		   =	request.getParameter("called_from");		   
			//called_from=Dispensing"
			ArrayList result		   =    (ArrayList) bean.getpendingorders(patient_id, ordering_facility_code,disp_locn_code,called_from);			
			//boolean issue_token		   =    bean.checkTokenSeries(disp_locn_code);
			int width				   =    30;
			String  classValue		   =    "";
			String prev_order_id	   =    "";
			String new_order_id	       =    "";
			ArrayList pendingrefillorders = null;

			if(called_from.equals("Dispensing")){
%>
				<title><fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></title>
<%
			}
			if(result.size()>0){
%>	
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="patientiddisplaytable">
					<tr id="header">
						<th width="'<%=width%>'%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
						<th width="'<%=width%>'%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
						<th width="'<%=width%>'%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
						<th width="'<%=width%>'%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
						<th width="'<%=width%>'%" nowrap><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></th>
						<th width="'<%=width%>'%" nowrap><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></th>
						<th width="'<%=width%>'%" nowrap><fmt:message key="ePH.TokenDate.label" bundle="${ph_labels}"/></th>
						<th width="'<%=width%>'%" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
						<th width="'<%=width%>'%" nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></th>
					</tr>
					<!-- <tr><td align="left" colspan=5><label>Disp Location   :<%=disp_locn_code%></label></td></tr> -->
<%
					for(int i=0;i<result.size();i=i+10){
						new_order_id = (String)result.get(i);
						pendingrefillorders = new ArrayList();
						if( called_from.equals("Dispensing")){
							if(((String)result.get(i+8)).equals(disp_locn_code))
								classValue	="style='font-size:9;background-color:#fde6d0'" ;
							else
								classValue	="class='QRYEVEN' style='font-size:9'";
						}
						else{
							if(i%2==0)
								classValue="class='QRYEVENSMALL'";
							else
								classValue="class='QRYODDSMALL'";
						}
%>
						<tr>
<%
							if(!prev_order_id.equals(new_order_id)||prev_order_id.equals("")) {
%>
								<td <%=classValue%> ><label>&nbsp;<%=result.get(i)%>&nbsp;</label>
<%  
									pendingrefillorders =(ArrayList) bean.getpendingRefillorders(patient_id,(String)result.get(i));
									if(pendingrefillorders.size()>0){
%>		
										<label style="color:blue;cursor:pointer;" onclick="callPendingrefillorders('<%=patient_id%>','<%=result.get(i)%>');" ><b><fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/></b></label>
<%
									}
%>
								</td>
<%
							}
							else{
%>
								<td <%=classValue%> ><label>&nbsp;&nbsp;</label></td>
<%
							}
%>
							<td <%=classValue%>  nowrap><label>&nbsp;<%=result.get(i+1)%>&nbsp;</label></td>
							<td <%=classValue%>   nowrap><label>&nbsp;<%=com.ehis.util.DateUtils.convertDate((String)result.get(i+2),"DMYHM","en",locale)  %>&nbsp;</label></td>
							<td align="left" <%=classValue%>  ><label>&nbsp;<%=result.get(i+3)%>&nbsp;</label></td>
							<td <%=classValue%> ><label>&nbsp;<%=result.get(i+4)%>&nbsp;</label></td>
							<td <%=classValue%>><label>&nbsp;<%=result.get(i+5)%>&nbsp;</label></td>
							<td <%=classValue%> ><label>&nbsp;<%=com.ehis.util.DateUtils.convertDate((String)result.get(i+6),"DMY","en",locale)%>&nbsp;</label></td>
							<td <%=classValue%> ><label>&nbsp;<%=result.get(i+7)%>&nbsp;</label></td>
							<td <%=classValue%> ><label>&nbsp;<%=result.get(i+9)%>&nbsp;</label></td>
						</tr>	
<% 
						prev_order_id    = new_order_id;
					}
%>	
				</table>
<%
			}
			else {
%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));   //Added "alert" and commented "below window message" for SKR-SCF-1108 [IN:057252] 
                     			//window.returnValue="NO_RECORD_FOUND_FOR_CRITERIA";     
					//window.close();
				</script>
<%
			}
%>
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

