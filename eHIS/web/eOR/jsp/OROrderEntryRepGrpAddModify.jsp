<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.io.*,eOR.*,eCA.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<head>
	<%
	
	 
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderType.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eOR/js/ChargeType.js"></script>
	<script language='javascript' src='../../eOR/js/OROrderEntryRepGrp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="OROrderentryreportgrp" id="OROrderentryreportgrp" target='messageFrame'>

<%

	String cust_rep_grp_code ="";
	String	cust_rep_grp_desc ="";
	String order_category ="";
	String cust_report_id ="";
	String report_type_id ="";
	String appl_ord_type ="A";
	String eff_status ="E";
	String mode  ="";
try{
	java.util.Properties props = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) props.getProperty("LOCALE");
	String bean_id = "Or_OrderEntryRptGrp" ;
	String bean_name = "eOR.OrderEntryReportGrouping";
	mode         = request.getParameter( "mode" )==null?"1":request.getParameter( "mode" );
	
	OrderEntryReportGrouping orderEntryGrpBean = (OrderEntryReportGrouping)getObjectFromBean(bean_id,bean_name,session);	
	orderEntryGrpBean.setLanguageId(localeName);
	orderEntryGrpBean.clearObject();
	orderEntryGrpBean.setLanguageId(localeName);
	orderEntryGrpBean.setMode( mode ) ;
	CommonCollectionUtils<String, String> reportIDMap = null;	
	HashMap<String, String> dataMap = null;	
	//String mode="1";
	//String ordertypecode=request.getParameter("ordertypecode");
	ArrayList order_cat = new ArrayList();
	order_cat=orderEntryGrpBean.getcatagory();
	reportIDMap = orderEntryGrpBean.getCustomRepIDs();

	
	//String checked		= "";
	orderEntryGrpBean.setFunctionId(request.getParameter("function_id")==null?"":request.getParameter("function_id"));

	if ( mode.equals(  CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{
		   cust_rep_grp_code			=   request.getParameter( "cust_rep_grp_code" )==null?"":request.getParameter( "cust_rep_grp_code" ) ;	  
			
			dataMap = orderEntryGrpBean.loadData(cust_rep_grp_code.trim()) ;		
			
			if(dataMap != null && dataMap.size() > 0)
			{	
				cust_rep_grp_code =dataMap.get("CUST_REP_GRP_CODE")==null?"":dataMap.get("CUST_REP_GRP_CODE");
				cust_rep_grp_desc =dataMap.get("CUST_REP_GRP_DESC")==null?"":dataMap.get("CUST_REP_GRP_DESC");
				order_category =dataMap.get("ORDER_CATEGORY")==null?"":dataMap.get("ORDER_CATEGORY");
				cust_report_id =dataMap.get("CUST_REPORT_ID")==null?"":dataMap.get("CUST_REPORT_ID");
				report_type_id =dataMap.get("REPORT_TYPE_ID")==null?"":dataMap.get("REPORT_TYPE_ID");
				appl_ord_type =dataMap.get("APPL_ORD_TYPE")==null?"A":dataMap.get("APPL_ORD_TYPE");
				eff_status =dataMap.get("EFF_STATUS")==null?"E":dataMap.get("EFF_STATUS");
			}
	 }
	%>
<table cellpadding='2' cellspacing='2'  name='OROrderentryreport' id='OROrderentryreport'  width='65%' align='center'>
       <tr>	
				    <td class="Label"><fmt:message  key="eOR.ReportType.label" bundle="${or_labels}"/></td>
				    <td  class="fields" width="25%"><select name='report_type_id' id='report_type_id' <%if(mode.equals("2")){%>disabled<%}%>>
				        <option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				        <option value='ORD' <%if(!report_type_id.equals("")){%>selected<%}%>><fmt:message  key="eOR.OrderFormatSheet.label" bundle="${or_labels}"/></option></select><img src="../../eCommon/images/mandatory.gif"></td></tr>
      <tr>
                    <td class="Label"><fmt:message  key="eOR.GroupingCode.label" bundle="${or_labels}"/></td>
				    <td class='fields' colspan="2"><input type="text" name='cust_rep_grp_code' id='cust_rep_grp_code' maxlength="10" value="<%=cust_rep_grp_code%>" onBlur="ChangeUpperCase( this );" onKeyPress="return CheckForSpecChars(event);" <%if(mode.equals("2")){%>disabled<%}%>/><img src="../../eCommon/images/mandatory.gif"></td></tr>
      <tr>
                    <td class="Label"><fmt:message  key="eOR.GroupingDescription.label"              bundle="${or_labels}"/></td>
				    <td class='fields' colspan="2"><input type="text" name='cust_rep_grp_desc' id='cust_rep_grp_desc' value="<%=cust_rep_grp_desc%>" maxlength="30"/><img src="../../eCommon/images/mandatory.gif"></td></tr>
      <tr>
		            <td class="Label"><fmt:message  key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
				    <td  class="fields" width="25%" id='textOrderCategory'><select name='order_category' id='order_category'             onChange='OrderCatg(this)' <%if(mode.equals("2")){%>disabled<%}%>>
				        <option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option><%
	       
	                      for(int i=0; i<order_cat.size(); i++){
					      String[] record = (String [])order_cat.get(i);
						  %>
						  <option value='<%=record[0]%>' <%if(order_category.equals(record[0])){%>selected<%}%>><%=record[1]%>
						   <%	
				            }
		                   %>
						  </select><img src="../../eCommon/images/mandatory.gif"></td>
						</tr>
	  <tr> 
		           <td class="Label"><fmt:message  key="eOR.PrintReportFormat.label" bundle="${or_labels}"/></td>
				   <td  class="fields" width="25%"><select name='cust_report_id' id='cust_report_id' <%if(mode.equals("2")){%>disabled<%}%>>
				        <option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
						<%
							   
							   if(reportIDMap != null && reportIDMap.size() >0)
							   {									
							         for(String reportKey : reportIDMap.keyList())
									{
						%>
										<option value='<%=reportKey%>' <%if(cust_report_id.equals(reportKey)){%>selected<%}%>><%=reportIDMap.get(reportKey)%></option>
						<%		}
								}%>
						</select><img src="../../eCommon/images/mandatory.gif"></td></tr>
	  <tr> 
		           <td class="Label"><fmt:message  key="eOR.ApplicableOrderType.label" bundle="${or_labels}"/>&nbsp;&nbsp;<input type="radio" name='appl_ord_type' id='appl_ord_type' value='A' <%if(appl_ord_type.equals("A")){%> checked<%}%> onclick='getordertype(this)'><fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<input type="radio" name="appl_ord_type" id="appl_ord_type" value="S" <%if(appl_ord_type.equals("S")){%> checked<%}else {%>  <%}%> onclick='getordertype(this)'><fmt:message key="Common.specific.label" bundle="${common_labels}" /></td></tr>     
				   <tr>
						 <td class="Label" width='33%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='<%=eff_status%>'  onClick='changeStatus(this);' <%if(eff_status.equals("E")){%> checked<%}%>>
						</td>
				   </tr>
</table>
    <input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	</form>

<%
	
putObjectInBean(bean_id,orderEntryGrpBean,session);}catch(Exception e){
System.out.println("@@in OROrderEntryRepGrpAddModify.jsp ="+e);
e.printStackTrace();
}%>
<%
		if(appl_ord_type.equals("S"))
		{
		%>
			<script>					
				parent.OrderEntryReport.rows = "10%,27%,*,12%";			
				
				parent.paneldetails1.location.href='../../eOR/jsp/OROrderEntryRepGrpDetail.jsp?order_category=<%=order_category%>&cust_rep_grp_code=<%=cust_rep_grp_code%>&mode=<%=mode%>';
    		</script>
	<%	
		}			
	%>
	<script>
		//var msg = "";	
		//parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	</script>
</body>
</html>


