
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/TransactionListReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
 		
	</head>
	<%
		String bean_id = "TransactionListReportBean";
		String bean_name = "eST.TransactionListReportBean";
		TransactionListReportBean bean = (TransactionListReportBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		HashMap alstartdate	=	null;
		 
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		        alstartdate             =        bean.getDurationforStartDate();
         String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	     String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
		 
      
	%>
	<body onLoad="FocusFirstElement()">
		<form name="formTransactionListReportCriteria" id="formTransactionListReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		  <table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			   <tr>
			   <td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr></tr>
                <tr></tr>
				<tr></tr>
				<tr></tr>
                <tr></tr>
				<tr></tr>
			 <tr>
	         <td align="left" class="label" width='35%'><fmt:message key="eST.TransactionType.label"   bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <select name="P_TRN_TYPE" id="P_TRN_TYPE" onchange="loadData();">
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
			
			<option  value='GRN'><fmt:message key="eST.GoodsReceivedNote.label" bundle="${st_labels}"/></option>
			<option  value='ISS'><fmt:message key="eST.RequisitionIssues.label" bundle="${st_labels}"/></option>
			<option  value='URG'><fmt:message key="eST.UrgentIssue.label" bundle="${st_labels}"/></option>
			<option  value='SAL'><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></option>
			<option  value='C'><fmt:message key="eST.Sales.label" bundle="${st_labels}"/> - <fmt:message key="eST.StockItemConsumption.label" bundle="${st_labels}"/></option>
			<!--
			<option  value='B'><fmt:message key="eST.GoodsReturntoVendor.label" bundle="${st_labels}"/></option>
			<option  value='C'><fmt:message key="eST.ManufacturingReceipt.label" bundle="${st_labels}"/></option>
			<option  value='D'><fmt:message key="Common.Request.label" bundle="${common_labels}"/></option>
			<option  value='E'><fmt:message key="Common.Issue.label" bundle="${common_labels}"/></option>
			<option  value='F'><fmt:message key="eST.IssueReturn.label" bundle="${st_labels}"/></option>
			<option  value='G'><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></option>
			<option  value='H'><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></option>
			<option  value='I'>Stock <fmt:message key="Common.Variance.label" bundle="${common_labels}"/></option>
			<option  value='J'><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></option>
			<option  value='K'><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></option>
			<option  value='L'><fmt:message key="eST.SalesReturn.label" bundle="${st_labels}"/></option>
			<option  value='M'><fmt:message key="eST.SplitBatch.label" bundle="${st_labels}"/></option>
			<option  value='N'><fmt:message key="eST.ChangeBinLocation.label" bundle="${st_labels}"/></option>
			<option  value='0'><fmt:message key="eST.StockItemConsumption.label" bundle="${st_labels}"/></option>
			<option  value='P'><fmt:message key="eST.OpeningStock.label" bundle="${st_labels}"/></option> -->
		    </select><%=bean.getImage("M")%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
			   <label id = 'mode' style="visibility:hidden">Mode</label> 
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		    <select name="p_transaction_mode" id="p_transaction_mode" onchange=""  style="visibility:hidden" >
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
			<option  value='I'><fmt:message key="eST.ByIssuingStore.label" bundle="${st_labels}"/></option>
			<option  value='R'><fmt:message key="eST.ByReceivingStore.label" bundle="${st_labels}"/></option>
			</select><img id='trn_mode_img' style="visibility:hidden" src="../../eCommon/images/mandatory.gif" ></img>
			 </td>
            <td class=label align=left width="30%"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></font>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<select name="P_Report_OPTION" id="P_Report_OPTION">
			<option value="Q"><fmt:message key="eST.ByQuantity.label" bundle="${st_labels}"/></option>
			<option value="V"><fmt:message key="eST.ByValue.label" bundle="${st_labels}"/></option>
			</select><%=bean.getImage("M")%></td>
		    </tr>
            <tr></tr>
			<tr></tr>
			 <tr></tr>
			<tr></tr>
			 <tr> 
			 <td class=label ><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/>  From  &nbsp;&nbsp;&nbsp;&nbsp;<input type=text name="p_trn_date_from" id="p_trn_date_from" size=10 maxlength=10 class="DATE"  value="<%=currentdateminus%>" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_trn_date_from');" ></img><%=bean.getImage("M")%></td>
            <td class=label ><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/>
			 <fmt:message key="Common.to.label" bundle="${common_labels}"/>  
			&nbsp;&nbsp;&nbsp; <input type=text name="p_trn_date_to" id="p_trn_date_to" size=10 maxlength=10 class="DATE" value="<%=currentdate%>"  onBlur="CheckDate(this);checkDocDate(document.forms[0]);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_trn_date_to');" ></img><%=bean.getImage("M")%></td>
			</tr>      
			<tr></tr>
			<tr></tr>
			 <tr></tr>
			 <tr></tr> 
			<tr>
			 <td class=label  nowrap><fmt:message key="eST.Facility.label" bundle="${st_labels}"/>/<fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <select name="facility_id" id="facility_id" onchange="loadStore(this);" ><option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><%=bean.getFacilitynames()%></select><select name="p_store_code" id="p_store_code" ><option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option><%=bean.getStores()%></select></td>
			<td  class="label">Top  &nbsp; <input maxLength=5 size=3 name="P_top_Nrecords" id="P_top_Nrecords" value="" class="NUMBER" onkeypress="return isValidNumber(this,event,8,0);" onBlur="checkIntegerFormat(this);"><%=bean.getImage("M")%>Items</td>
			 </tr>
			
 			<!--<tr></tr>
			 <tr></tr>
			 <tr></tr>
			 <tr></tr>
			 <tr>
			 <td class=label ><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>  Mode 
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <select name="p_transaction_mode" id="p_transaction_mode" onchange="" disabled >
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
			<option  value='I'><fmt:message key="eST.IssuingStore.label" bundle="${st_labels}"/></option>
			<option  value='R'>Receiving Store</option>
			</select><img id='trn_mode_img' style="visibility:hidden" src="../../eCommon/images/mandatory.gif" ></img>
			 </td>
			 </tr>  -->
			  </table>
			  </td>  
			 </tr>
			</table>
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="P_FROM_date" id="P_FROM_date" 					value="">
			<input type="hidden" name="P_TO_date" id="P_TO_date" 						value="">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="p_report_id" id="p_report_id"						value="STBTRNTN">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			</form>
	</body>
</html>	

