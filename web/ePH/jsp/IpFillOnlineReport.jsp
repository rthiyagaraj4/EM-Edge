<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*, ePH.Common.*,java.util.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	
	String locale			 = (String)session.getAttribute("LOCALE");
	String facility_id		 = (String) session.getValue("facility_id");
    String reoprtLabel       = "";
	String str               = "";
	String checkStatus_value = "";
	String checkStatus       = "";
	


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IPFillAll.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<title><fmt:message key="ePH.OnlinePrintSetup.label" bundle="${ph_labels}"/></title>
     
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="IpFillOnlineReportForm" id="IpFillOnlineReportForm">
<%
    String bean_id = "IpFillAllBean" ;
	String bean_name = "ePH.IpFillAllBean";
	/* Initialize Function specific start */
	IpFillAllBean bean = (IpFillAllBean)getBeanObject(bean_id, bean_name, request ) ;
	
	String disp_locn_code   = CommonBean.checkForNull(request.getParameter( "disp_locn_code" ));
	String fill_proc_id	     = request.getParameter("flag");
	String proc_type	     = request.getParameter("proc_type");

   	 HashMap printMap = bean.getIpFillOnlineReport(facility_id,disp_locn_code);
	// out.println("printMap----->"+printMap);
	 String to_date=bean.getSysdate(); 
	 Set keyset=printMap.keySet();
	 Object[] sorted_set = keyset.toArray();
	 Arrays.sort(sorted_set);

%>
<TABLE   cellspacing="0" cellpadding="0" border="1" width = "100%">    
<tr>
<td class='COLUMNHEADER' width=35%><fmt:message key="ePH.PHOnlineReportName.label" bundle="${ph_labels}"/></td >
<td class='COLUMNHEADER'  width=15%><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td>


</tr>
<%
 	   %>
		<tr style='height:21px;'>
		<%
		if(printMap.size()>0){
		for (int i=0;i<sorted_set.length;i++)
		{
		    str=sorted_set[i].toString();			
			
			if (str.equals("CERTIFICATE_REIMBURSEMENT")){
			reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CERTIFICATE_REIMBURSEMENT.label","ph_labels");
			%>
			<td nowrap><%=reoprtLabel%> </td>
				 <%
				if(printMap.get(str).toString().equals("PD")){
				checkStatus="checked";
				checkStatus_value="CERTIFICATE_REIMBURSEMENT";
				}else{
				checkStatus="";
				checkStatus_value="";
				}%>
			<td nowrap align="center"><input type="checkbox" name="certificate_reimbursement" id="certificate_reimbursement" <%=checkStatus%> onclick="certificate_reimbursement1(this)" value="<%=checkStatus_value%>" ></td>
			<%}
			else if (str.equals("DISPENSE_SHEET")){	reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DISPENSE_SHEET.label","ph_labels");
			%>
				<td nowrap><%=reoprtLabel%> </td>
			   <%
				if(printMap.get(str).toString().equals("PD")){
				checkStatus="checked";
				checkStatus_value="DISPENSE_SHEET";
				}else{
				checkStatus="";
				checkStatus_value="";
				}%>
			<td nowrap align="center"><input type="checkbox" name="dispense_sheet" id="dispense_sheet" <%=checkStatus%> onclick="dispense_sheet1(this)" value="<%=checkStatus_value%>"></td>
			<%}
			else if (str.equals("DRUG_LABEL")){
			reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DRUG_LABEL.label","ph_labels");
			%>
					<td nowrap><%=reoprtLabel%> </td>
			   <%
				if(printMap.get(str).toString().equals("PD")){
				checkStatus="checked";
				checkStatus_value="DRUG_LABEL";
				}else{
				checkStatus="";
				checkStatus_value="";
				}%>
			<td nowrap align="center"><input type="checkbox" name="drug_label" id="drug_label"   <%=checkStatus%> onclick="drug_label1(this)" value="<%=checkStatus_value%>"></td>
			<%}
			else if (str.equals("FILL_LIST_DRUGMEDICAL")){	reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_DRUGMEDICAL.label","ph_labels");
			%>
					<td nowrap><%=reoprtLabel%> </td>
			   <%
				if(printMap.get(str).toString().equals("PD")){
				checkStatus="checked";
				checkStatus_value="FILL_LIST_DRUGMEDICAL";
				}else{
				checkStatus="";
				checkStatus_value="";
				}%>
			<td nowrap align="center"><input type="checkbox" name="fill_list_drugmedical" id="fill_list_drugmedical" onclick="fill_list_drugmedical1(this)"  <%=checkStatus%> value="<%=checkStatus_value%>"></td>
			<%}
			else if (str.equals("FILL_LIST_PATIENT")){
			reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_PATIENT","ph_labels");
			%>
					<td nowrap><%=reoprtLabel%> </td>
			   <%
				if(printMap.get(str).toString().equals("PD")){
				checkStatus="checked";
				checkStatus_value="FILL_LIST_PATIENT";
				}else{
				checkStatus="";
				checkStatus_value="";
				}%>
			<td nowrap align="center"><input type="checkbox" name="fill_list_patient" id="fill_list_patient" onclick="fill_list_patient1(this)"  <%=checkStatus%>  value="<%=checkStatus_value%>" ></td>
			<%}
			else  if (str.equals("MEDICAL_SUPPLY_LABEL")) {
				reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICAL_SUPPLY_LABEL.label","ph_labels");
				%>
					<td nowrap><%=reoprtLabel%> </td>
				<%
				if(printMap.get(str).toString().equals("PD")){
				checkStatus="checked";
				checkStatus_value="MEDICAL_SUPPLY_LABEL";
				}else{
				checkStatus="";
				checkStatus_value="";
				}%>
			<td nowrap align="center"><input type="checkbox" name="medical_supply_label" id="medical_supply_label" <%=checkStatus%> onclick="medical_supply_label1(this)" value="<%=checkStatus_value%>" ></td>
			<%}else if (str.equals("MEDICATION_LIST"))	{
				reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICATION_LIST.label","ph_labels");	
				%>
				<td nowrap><%=reoprtLabel%> </td>
			   <%
				if(printMap.get(str).toString().equals("PD")){
				checkStatus="checked";
				checkStatus_value="MEDICATION_LIST";
				}else{
				checkStatus="";
				checkStatus_value="";
				}%>
			<td nowrap align="center"><input type="checkbox" name="medication_list" id="medication_list" <%=checkStatus%> onclick="medication_list1(this)" value="<%=checkStatus_value%>" ></td>
			<%}%>
		    </tr> 	    
			
	 <%}//END FOR LOOP
%>
	<tr>
	 <td colspan="2" align="center"><BR><input type='Button' class='Button'  value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>'  onclick="OnlineReport('<%=fill_proc_id%>','<%=disp_locn_code%>','<%=proc_type%>','<%=to_date%>')" >&nbsp;&nbsp;&nbsp;<input type='Button' class='Button'  value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick='window.close();' ></td>
	 </tr>
	 <%}else{%>
	   	 <script>alert(getMessage('PH_NO_REPORTS','PH'));parent.window.close();</script>
	<%}%>
</table>
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

