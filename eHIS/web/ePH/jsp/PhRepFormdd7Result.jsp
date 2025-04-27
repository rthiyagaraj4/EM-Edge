<!DOCTYPE html>
<%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<% 
request.setCharacterEncoding("UTF-8");
			//Added by Himanshu for MMS-ME-SCF-0097 Starts 
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	//out.println("locale---->" +locale);
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/PhRepFormdd7.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<!-- <form name="PhRepPrescriptionResultForm" id="PhRepPrescriptionResultForm" > -->

<form name='QueryForm' id='QueryForm'>
<%	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	String bean_id = "PrintPrescriptionReportBean" ;
	String bean_name = "ePH.PrintPrescriptionReportBean";
	PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;

	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	String orig_order_id = CommonBean.checkForNull(request.getParameter("orig_order_id"));
	String order_date_from = CommonBean.checkForNull(request.getParameter("order_date_from"));
	String order_date_to = CommonBean.checkForNull(request.getParameter("order_date_to"));
	String order_type = CommonBean.checkForNull(request.getParameter("order_type"));
	String encounter_id  = CommonBean.checkForNull(request.getParameter("encounter_id"));
	String pres_practitioner_id = CommonBean.checkForNull(request.getParameter("pres_practitioner_id"));
	String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
	String locn_code = CommonBean.checkForNull(request.getParameter("locn_code"));
	String order_type_code = CommonBean.checkForNull(request.getParameter("order_type_code"));
	String facility_id=(String) session.getValue( "facility_id" );
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
	String order_legend="";
	String order_type1=order_type;
	String order_by = CommonBean.checkForNull(request.getParameter("order_by"));
	

	ArrayList result =new ArrayList();
	result=bean.getAllFormdd7(patient_id,orig_order_id,order_date_from,order_date_to,encounter_id,pres_practitioner_id,locn_type,locn_code,facility_id,from,to,order_type,order_by);

  /* ArrayList Nresult= new ArrayList();
   Nresult=bean.getNarcoticQuery(patient_id,orig_order_id,order_date_from,order_date_to,encounter_id,pres_practitioner_id,locn_type,locn_code,facility_id,from,to,order_type,order_by);
*/
	ArrayList iv_legend=new ArrayList();
	iv_legend=bean.getIVLegends();
	
	if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
		
	%>
		<table cellpadding=0 cellspacing=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(0));
	%>
	</td></tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<%
		if(order_type.equals("All"))
		{
		%>
		<th ><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></th><th ><fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th><th ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th><th ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<%
		}
		else 
		{
		%>
		<th ><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></th><th ><fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th><th ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th><th ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th><th>St</th>
		<%
		}
		String []record=new String[12];
		for (int i=1;i<result.size();i++){
			record= (String[])result.get(i);
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			if(order_type.equals("All"))
				order_type1=record[11];
			record[1]=com.ehis.util.DateUtils.convertDate(record[1],"DMY","en",locale);
			record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMY","en",locale);
	%>
		<tr>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>','<%=record[8]%>','<%=record[9]%>','<%=order_type1%>','<%=record[3]%>')"><%=record[0]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[1]%></td>
	    <!--	<%
			if(order_type.equals("All"))
			{
				if(record[11].equals(""))
				{
					order_legend="Normal Rx";
				}
			%>
			<td class="<%=classvalue%>" style="font-size=9"><%=order_legend%></td>
			<%
			}
			%>
!-->
			<td class="<%=classvalue%>" style="font-size=9"><%=record[2]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[10]%></td>
            <td class="<%=classvalue%>" style="font-size=9"><%=record[3]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[4]%></td>			
			<td class="<%=classvalue%>" style="font-size=9"><%=CommonBean.checkForNull(record[5])%></td>		
			<td class="<%=classvalue%>" style="font-size=9"><%=record[6]%></td>			
			<%
				String status = record[7];
			if(status==null)
				status="";
				String statusColor = "";
				if(status.equals("OS") || status.equals("RG") ){
					statusColor = "#FF0000";
				}else if(status.equals("DP")){
					statusColor = "#CC9933";
				}else if(status.equals("DF")){
					statusColor = "#990000";
				}
				
			%>
			<td class="<%=classvalue%>" width="1%" align='center' style='background-color:<%=statusColor%>;' >&nbsp;&nbsp;</td>
		</tr>
	<%
		}
	}else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","PH"));</script>
	<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PhRepFormdd7Result", searched) );
	
	
	%>
	

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="order_id" id="order_id" value="">
	<input type="hidden" name="order_date_from" id="order_date_from" value="">
	<input type="hidden" name="order_date_to" id="order_date_to" value="">
	<input type="hidden" name="encounter_id" id="encounter_id" value="">
	<input type="hidden" name="pres_practitioner_id" id="pres_practitioner_id" value="">
	<input type="hidden" name="order_type" id="order_type" value="">
	<input type="hidden" name="order_by" id="order_by" value="">
	<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

