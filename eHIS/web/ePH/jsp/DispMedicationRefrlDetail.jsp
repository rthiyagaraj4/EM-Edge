<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

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
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 
	</head>
<title> <fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/> </title>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="referralDetailForm" id="referralDetailForm" >
<%

	String patient_id			=	request.getParameter("patient_id");
	String order_id			=	request.getParameter("order_id");
	String order_line_no			=	request.getParameter("order_line_no");
	String SQL_PH_DISP_PRACT_REFERRAL_SELECT=PhRepository.getPhKeyValue("SQL_PH_DISP_PRACT_REFERRAL_SELECT");
	String bean_id		= "DispMedicationBean" ;
	String bean_name	= "ePH.DispMedicationBean";
	
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	//bean.setLanguageId(locale);
       	ArrayList patdtls		=	new ArrayList();
		HashMap facility        =   null;
		HashMap dtl=null;
		ArrayList drugdtls=null;
		ArrayList facilitys=null;
		ArrayList orderLines = new ArrayList();
		patdtls=bean.getPatientDtl(patient_id);
%>
    <table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
	<tr>
			
			<td  class="COLUMNHEADER" class="small" width="8%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="32%"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="12%"><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="12%"><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="10%"><fmt:message key="Common.OrderingPract.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="10%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
	</tr>
	<% 
	    if(patdtls.size()!= 0){
	%>
	<tr><td ><%=patient_id%></td><td><%=patdtls.get(0)%></td><td><%=patdtls.get(1)%></td><td><%=patdtls.get(2)%></td><td><%=patdtls.get(3)%></td><td><%=patdtls.get(4)%></td></tr>
		<% } %>
		<tr ><td colspan="6">&nbsp;</td></tr>
   </table>
   <table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="" >
			    <td  class="COLUMNHEADER" colspan="6" ><fmt:message key="ePH.ReferralDetail.label" bundle="${ph_labels}"/></td>
                
				<tr><td class="label" ><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></td>
				
		<%  facilitys=bean.getRefFacility(); 
			if( facilitys.size() > 1 ){

%>
			<TD COLSPAN="2" >
			&nbsp;<SELECT name="referral_facility" id="referral_facility" onChange="">
				<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</OPTION>	
<%
				  for(int t=0;t<facilitys.size();t++)
				{
				   facility=(HashMap)facilitys.get(t);
	      %>
				
				<OPTION  VALUE='<%=facility.get("FACILITY_ID")%> '><%=facility.get("FACILITY_NAME") %></OPTION>
				<%}}else {%><td><input type="text" size="15" name="referral_facility" id="referral_facility" disabled value='<%=facility.get("FACILITY_NAME")%>'><input type="hidden"  value='<%=facility.get("FACILITY_ID")%>'><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td><% } %>
			</SELECT><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
		</TD>
				</tr>
				<tr><td class="label" ><fmt:message key="ePH.ReferralLocation.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;<input type="text" size="15" name="referral_location" id="referral_location"><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td></td></tr>
				<tr><td class="label"  name="referral_remarks"><fmt:message key="ePH.ReferralRemarks.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;<textarea size="555" name="referral_remarks" width="30" height="10"></textarea><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td></tr>
    <tr><td colspan="2">&nbsp;</td></tr>
				</table>
	
   
    <table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
	<tr>
			
			<td  class="COLUMNHEADER" class="small" width="32%"><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="8%"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="10%"><fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="10%"><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="10%"><fmt:message key="ePH.QtyUOM.label
" bundle="${ph_labels}"/></td>
			<td  class="COLUMNHEADER" class="small" width="10%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	</tr>
				<% 
					orderLines = bean.getOrderLineNumFrRefrl(order_id);
					if(orderLines.size()!=0){
						for(int k=0;k<orderLines.size();k++){
						order_line_no =(String)orderLines.get(k);
						String classvalue = "";
							if(k%2 ==0){
								classvalue = "QRYODD";
							}else{
								classvalue = "QRYEVEN";
							}
		                drugdtls=bean.getDrugDtl(order_id,order_line_no);
				   		if(drugdtls.size()!= 0){
					    for(int p=0;p<drugdtls.size();p++){
							dtl=(HashMap)drugdtls.get(p);
							String order_qty=(String)dtl.get("ORDER_QTY");
							String disp_qty=(String)dtl.get("disp_qty");
							if(disp_qty == null){ disp_qty="";}
							int order=0;
							int disp=0;
							if(order_qty != null){
							 order=Integer.parseInt(order_qty);
							} else {order=0;}
							if(disp_qty != null){
							 disp=Integer.parseInt(disp_qty);
							} else {
								disp=0;}


							 disp=Integer.parseInt(disp_qty);
							int balance=0;
							if(order > disp){ balance = order - disp;} 
							
							%>

	<tr>
		<td class="<%=classvalue%>" style="font-size:9"><%=(String)dtl.get("DRUG_DESC")%></td>
		<td class="<%=classvalue%>"  style="font-size:9" ><%=(String)dtl.get("ORDER_QTY") %></td>
		<td class="<%=classvalue%>" style="font-size:9" ><%=(String)dtl.get("disp_qty")%></td>
		<td class="<%=classvalue%>" style="font-size:9" ><%=balance %></td>
		<td class="<%=classvalue%>" style="font-size:9" ><%=(String)dtl.get("order_uom") %></td>
		<td class="<%=classvalue%>" style="font-size:9" ><input type="checkbox" name="status_<%=p%>" id="status_<%=p%>" onclick="refynstatus(this,'<%= order_id%>','<%= order_line_no %>');"></td></tr>
		<%}
   }
}
}	%>
</table>
    <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
   <tr>
		<td  colspan="6" class="white">
		<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="referralyn(document.referralDetailForm,'<%=order_id%>');">	
		<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="parent.window.returnValue='OK';validate();">
	</td>	
   </tr>
   </table>
<input type="hidden" name="SQL_PH_DISP_PRACT_REFERRAL_SELECT" id="SQL_PH_DISP_PRACT_REFERRAL_SELECT" value="<%=SQL_PH_DISP_PRACT_REFERRAL_SELECT%>">

</form>  
</body>
</html>

<%
//putObjectInBean(bean_id,bean,request);
%>

