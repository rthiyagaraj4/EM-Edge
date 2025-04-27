<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	  request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
</head>
<%
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	String tot_num_of_drugs	= request.getParameter("tot_num_of_drugs");
	
	if(tot_num_of_drugs==null)tot_num_of_drugs="0";
	Hashtable ht_drug_details	  = bean.getAllDrugDetails();
	
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmDispMedicationWSDisplaySec" id="frmDispMedicationWSDisplaySec">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="wsdisplaysectable">
		<tr>
			<td  colspan="6" style="background:#FDE6D0;font-size:10"><B><fmt:message key="ePH.DisplaySection.label" bundle="${ph_labels}"/></B></td>
		</tr>
		<tr>
			<td style="border-left:none;border-bottom:none" class="TDSTYLE1" rowspan="2" ><B><fmt:message key="ePH.Del.label" bundle="${ph_labels}"/></B></td>
			<td width="40%" style="border-left:none;border-bottom:none" class="TDSTYLE1" rowspan="2" ><B><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></B> </td>
			<td colspan="4" class="TDSTYLE1" ><B><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></B></td>
		</tr>
		<tr>
			<td class="TDSTYLE1"><B><fmt:message key="ePH.ReqAsperorder.label" bundle="${ph_labels}"/></B></td>
			<td class="TDSTYLE1"><B><fmt:message key="ePH.Preparation.label" bundle="${ph_labels}"/></B> </td>
			<td class="TDSTYLE1"><B><fmt:message key="ePH.AvlfromLeftOver.label" bundle="${ph_labels}"/></B></td>
			<td class="TDSTYLE1"><B><fmt:message key="ePH.Tobedrawnfromstock.label" bundle="${ph_labels}"/></B></td>
		</tr>
	<%
		if(ht_drug_details.size()>0){
			String classvalue="";
			for(int i=1;i<=Integer.parseInt(tot_num_of_drugs);i++){
				ArrayList drug_details = (ArrayList)ht_drug_details.get(i+"");
				if ( i % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;

				if(drug_details != null && drug_details.size()>0){
					String drug_name = bean.getDrugDesc((String)drug_details.get(0));
	%>
			<tr>
				<td class="<%=classvalue%>" width="2%">
					<input type='checkbox' name='chkDel<%=i%>' id='chkDel<%=i%>' onclick="deleterecord(drug_code,order_line_no<%=i%>,)"><input type='hidden' name='order_line_no<%=i%>' id='order_line_no<%=i%>' value='<%=i%>'>
					<input type="hidden" name="drug_code<%=i%>" id="drug_code<%=i%>" value="<%=(String)drug_details.get(0)%>">
				</td>
				<td class="<%=classvalue%>" width="40%">
					<label ><%=drug_name%></label>
			<%
				if(drug_details.size()==10){
					String rf_name = bean.getRFName((String)drug_details.get(5));
			%>
					<br><label style="color:#CC00CC">&nbsp;&nbsp;&nbsp;<%=rf_name%></label>
			<%
				}
			%>
				</td>
				<td class="<%=classvalue%>" width="15%">
					<label><%=drug_details.get(1)%></label>					
			<%
				if(drug_details.size()==10){
			%>
					<br><label style="color:#CC00CC">&nbsp;&nbsp;&nbsp;<%=drug_details.get(6)%></label>
			<%
				}
			%>
				</td>
				<td class="<%=classvalue%>" width="10%">
					<label><%=drug_details.get(2)%></label>
			<%
				if(drug_details.size()==10){
			%>
					<br><label style="color:#CC00CC">&nbsp;&nbsp;&nbsp;<%=drug_details.get(7)%></label>
			<%
				}
			%>

				</td>
				<td class="<%=classvalue%>" width="15%">
					<label><%=drug_details.get(3)%></label>
			<%
				if(drug_details.size()==10){
			%>
					<br><label style="color:#CC00CC">&nbsp;&nbsp;&nbsp;<%=drug_details.get(8)%></label>
			<%
				}
			%>
				</td>
				<td class="<%=classvalue%>" >
					<label><%=drug_details.get(4)%></label>					
			<%
				if(drug_details.size()==10){
			%>
					<br><label style="color:#CC00CC">&nbsp;&nbsp;&nbsp;<%=drug_details.get(9)%></label>
			<%
				}
			%>
				</td>
			</tr>
				<%
					}
				}
			}
		%>
		</table>
	</form>
</body>
</html>

<%
//putObjectInBean(bean_id,bean,request);
%>

