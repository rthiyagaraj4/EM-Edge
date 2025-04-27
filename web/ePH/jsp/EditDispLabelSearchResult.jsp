<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" SRC="../../ePH/js/EditDispLabel.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
<%
	String facility_id		= (String) session.getValue( "facility_id" );
	String patient_id       = (String) request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String dispense_no      = (String) request.getParameter("dispense_no")==null?"":request.getParameter("dispense_no");
	String dispense_date    = (String) request.getParameter("dispense_date")==null?"":request.getParameter("dispense_date");
	if(!locale.equals("en"))
	     dispense_date =com.ehis.util.DateUtils.convertDate(dispense_date,"DMY",locale,"en");
	String bean_id          = "EditDispLabelBean" ;
	String bean_name        = "ePH.EditDispLabelBean";
	EditDispLabelBean bean  = (EditDispLabelBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	ArrayList disp_details  = (ArrayList) bean.getDispenseDetails(patient_id, dispense_no, dispense_date, facility_id);
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0"> 
		<form name="frmEditDispLabelQryResult" id="frmEditDispLabelQryResult">
<%
		if(disp_details.size() > 0){
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
				<tr>
					<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></th>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				</tr>
<%
				String disp_date = "", Practitioner = "";
				for(int i = 0; i < disp_details.size(); i=i+9){
					disp_date = (String) disp_details.get(i+3);
					Practitioner = (String) disp_details.get(i+5);  //Declared  variable practitioner for getting practioner name in to thai regarding incident num:25474 on 15/DEC/2010==By Sandhya
%>
					<tr id = "row_'<%=i%>'">
						<td width="15%" ><%=disp_details.get(i)%></td>
						<td width="50%" ><%=disp_details.get(i+1)%></td>
						<td width="12%"><%=disp_details.get(i+2)%></td>
						<td ><%=com.ehis.util.DateUtils.convertDate((String) disp_details.get(i+3),"DMYHM","en",locale)%></td>
						<!--disp_details.get(i+1) is encoded for SRR20056-SCF-6260[Incident No.25586] -->
						<td  onClick="loadEditLabelDialog('<%=disp_details.get(i)%>','<%=java.net.URLEncoder.encode((String)disp_details.get(i+1),"UTF-8")%>','<%=disp_details.get(i+2)%>','<%=disp_date%>','<%=disp_details.get(i+4)%>','<%=java.net.URLEncoder.encode(Practitioner,"UTF-8")%>','<%=disp_details.get(i+6)%>','<%=disp_details.get(i+7)%>','<%=disp_details.get(i+8)%>')"><a href="#"><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></a></td> <!-- patient_class -- disp_details.get(i+8) added for Added for Bru-HIMS-CRF-414 [IN045554]-->
					</tr>
<%
				}
%>
			</table>
<%
		}
		else{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> 
<%
		}
%>
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

