<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale				= (String)session.getAttribute("LOCALE");
		String appl_user_name		= (String)session.getAttribute("appl_user_name");
		String login_user			= (String)session.getAttribute("login_user");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String call_from = request.getParameter("call_from");
		%>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/MedicationAdministration.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.CancelMarAdminstration.label" bundle="${ph_labels}"/> History</title>
	</HEAD>
<%
	try{
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String bean_id1 = "MedicationAdministrationFTBean.java" ;
		String bean_name1 = "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean bean1 = (MedicationAdministrationFTBean)getBeanObject( bean_id1, bean_name1, request ) ;
		String	bean_id			=	"QueryPatientDrugProfileBean" ;
		String	bean_name		=	"ePH.QueryPatientDrugProfileBean";

		QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		
		String drugName = request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		 
		String login_facility_id = (String)session.getValue( "facility_id" );
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String iv_prep_yn = request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String sch_date_time  = request.getParameter("sch_date_time")==null?"":request.getParameter("sch_date_time");
		String dosage_seq = request.getParameter("dosage_seq")==null?"":request.getParameter("dosage_seq");
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		
		ArrayList  reasonCodeValues=bean1.getCancilationHistoryForRX(iv_prep_yn,order_id,order_line_num,sch_date_time,patient_id,encounter_id,dosage_seq);
		
%>
		<body   >  
			<form name="cancelHistoryForm" id="cancelHistoryForm" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<label  id='drug_name' style="align-left:20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=drugName%></b></label>
				</table>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
				 
					 <td  class='Label'></td>
					<th  class='Label'><b><label  >Schedule Date & Time</label></b></th>
						<th  class='Label'><b>Prescribed Dose</b></label></th>
						<th  class='Label'><b><label  >Cancel Dose</label></b></th>
						<th  class='Label'><b>Cancel Date & Time</b></label></th>
						<th  class='Label'><b><label  >Admin Date & Time</label></b></th>
						<th  class='Label'><b>Cancel By</b></label></th>
						<th  class='Label'><b>Admin By</b></label></th>
						<th  class='Label'><b>Cancel Reason</b></label></th>
					     <%for(int i=0;i<reasonCodeValues.size();i=i+10){ %>
					     <tr style="height:40px">
					     <td  class='Label'></td>
						<td  class='Label' nowrap="nowrap"><b><label> <%=com.ehis.util.DateUtils.convertDate((String)reasonCodeValues.get(i+5),"DMYHM","en",locale)%></label></b></td>
						<td  class='Label' nowrap="nowrap"><b><%=reasonCodeValues.get(i+8)%> <%=CommonBean.checkForNull(bean.getUomDisplay(login_facility_id,(String)reasonCodeValues.get(i+9)))%></b></label></td>
						<td  class='Label' nowrap="nowrap"><b><label><%=reasonCodeValues.get(i+6)%> <%=CommonBean.checkForNull(bean.getUomDisplay(login_facility_id,(String)reasonCodeValues.get(i+7)))%></label></b></td>
						<td  class='Label' nowrap="nowrap"><b><%=com.ehis.util.DateUtils.convertDate((String)reasonCodeValues.get(i+2),"DMYHM","en",locale)%></b></label></td>
						<td  class='Label' nowrap="nowrap"><b><label><%=com.ehis.util.DateUtils.convertDate((String)reasonCodeValues.get(i+1),"DMYHM","en",locale)%></label></b></td>
						<td  class='Label' nowrap="nowrap"><b><%=reasonCodeValues.get(i+3)%></b></label></td>
						<td  class='Label' nowrap="nowrap"><b><%=reasonCodeValues.get(i+0)%></b></label></td>
						<td  class='Label'><b><%=reasonCodeValues.get(i+4)%></b></label></td>
					</tr>
					<%} %>
					
					
					
			</form>
		</body>
<%
		putObjectInBean(bean_id1,bean1,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

