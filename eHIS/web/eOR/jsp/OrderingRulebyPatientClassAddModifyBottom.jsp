<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--OrderingRulebyPatientClass.jsp -->
<!---------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------
?             100         ?           created
25/8/2011     IN029071         Akbar       Added two new Time Based Rule in 
						  'Ordering Rule by Patient Class' function for MEDICITY
---------------------------------------------------------------------->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085								  
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OrderingRulebyPatientClass.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head><body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" >
<form name='OrderingRuleby_PatientClass1' id='OrderingRuleby_PatientClass1' method=post>
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode	   = request.getParameter( "mode" ) ;
	String order_category = request.getParameter("order_category");
	String preselect_ord_type =  request.getParameter("preselect_ord_type");
//	out.println(">>>>>>>>"+preselect_ord_type);
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderingRulebyPatientClass" ;
	String bean_name = "eOR.OrderingRulebyPatientClass";
	String preselect_pr_disable = "" ;

	//if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
	//	return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	OrderingRulebyPatientClass bean = (OrderingRulebyPatientClass)getBeanObject( bean_id, bean_name, request) ;  
	bean.setLanguageId(localeName);
	preselect_ord_type = (String)bean.getPreselectOrderType();
	preselect_ord_type = preselect_ord_type.trim();

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	int totalCount = (int)bean.checkExists(order_category);
	if(totalCount!=0){
		mode = "2";
	}
	bean.clear() ;
	bean.setMode( mode ) ;



/* Initialize Function specific end */
	//if ( mode.equals( CommonInterface.MODE_MODIFY )  || mode.equals( CommonInterface.MODE_DELETE ) ) {
		

	//}
		String slClassValue = "";
		String preselect_pr_type = "";
		String time_based_rule = "";
		String expiry_rule = "";
		String future_order = "";
		String futureorderduration = "";
		String floor_to_start_day_yn="";


		ArrayList OrderTypeData = bean.getPatientClass(order_category) ;
%>
			<table cellpadding='3' cellspacing=0 width="100%" border="1" style="border-top: 1.5px solid #333; border-right: 1.5px solid #333; border-bottom: 1.5px solid #333; border-left: 1.5px solid #333;">
			<tr>
				<th class=columnheader align="left" width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
				<th class=columnheader align="left" width='15%'><fmt:message key="eOR.PreselectOrderType.label" bundle="${or_labels}"/></th>
				<th class=columnheader align="left" width='15%'><fmt:message key="eOR.TimeBasedRule.label" bundle="${or_labels}"/></th>
				<th class=columnheader align="left" width='15%'><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/></th>
				<th class=columnheader align="left" width='25%' colspan='2'><fmt:message key="eOR.FutureOrderRule.label" bundle="${or_labels}"/></th>
				<th class=columnheader align="left" width='15%'><fmt:message key="eOR.RoundOffStartTime.label" bundle="${or_labels}"/></th>
			</tr>
			<input type=hidden name='totalLength' id='totalLength' value='<%=OrderTypeData.size()%>'>

<%
String[] record=null;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			record = (String[])OrderTypeData.get(i);
				if(i % 2 == 0){
					slClassValue = "gridData";
				}else {
					slClassValue = "gridData";
				}

%>
			<tr>
				<td  class='<%= slClassValue %>'><%=record[1]%> <input type=hidden name='pat_class<%=i%>' id='pat_class<%=i%>' value='<%=record[0]%>'></td>
				<td  class='<%= slClassValue %>'>
					<%
					if(preselect_ord_type.equals("N")){
						preselect_pr_type =record[2];
						if(preselect_pr_type.equals("N")){
							preselect_pr_type = "";
						}else if(preselect_pr_type.equals("Y")){
							preselect_pr_type = " checked ";
						}
						preselect_pr_disable = " disabled ";
					}else {
						preselect_pr_type =record[2];
						if(preselect_pr_type.equals("N")){
							preselect_pr_type = "";
						}else if(preselect_pr_type.equals("Y")){
							preselect_pr_type = " checked ";
						}
					}

					%>
					<input type='checkbox' name='preselect_pr_type<%=i%>' id='preselect_pr_type<%=i%>' value='' <%=preselect_pr_type%> <%=preselect_pr_disable%>>
				</td> 
				<td  class='<%= slClassValue %>' width='20%'>
					
					<%
						time_based_rule = record[3];
						if(time_based_rule==null){ time_based_rule = ""; }%>
					<SELECT name="time_based_rule<%=i%>" id="time_based_rule<%=i%>" onChange="onRuleChange('<%=i%>')" style="width:175px">
						<option value=" "> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>						
						<option value="DAD" <% if(time_based_rule.equals("DAD")){out.println(" selected ");}%>><fmt:message key="Common.DayAfterDischarge.label" bundle="${common_labels}"/></option>
						<!---[101]/start--->
						<%
						if(record[0].equals("IP"))	
						{
						%>
						<option value="DAS" <% if(time_based_rule.equals("DAS")){out.println(" selected ");}%>><fmt:message key="eOR.DayAfterDisAdv.label" bundle="${or_labels}"/></option>
						<%
						}	
						%>
						<!---[101]/end----->
						<option value="DAA" <% if(time_based_rule.equals("DAA")){out.println(" selected ");}%>><fmt:message key="eOR.DayAfterAdmVist.label" bundle="${or_labels}"/></option>
						<option value="HAD" <% if(time_based_rule.equals("HAD")){out.println(" selected ");}%>><fmt:message key="Common.HourAfterDischarge.label" bundle="${common_labels}"/></option>
						<!---[101]/start--->
						<%
						if(record[0].equals("IP"))	
						{	
						%>											
						<option value="HAS" <% if(time_based_rule.equals("HAS")){out.println(" selected ");}%>><fmt:message key="eOR.HourAfterDisAdv.label" bundle="${or_labels}"/></option>
						<%
						}	
						%>
						<!---[101]/end----->
						<option value="HAA" <% if(time_based_rule.equals("HAA")){out.println(" selected ");}%>><fmt:message key="eOR.HourAfterAdmVist.label" bundle="${or_labels}"/></option>
					</SELECT>
						<span id='time_based_<%=i%>'></span>
				</td>
				<td  class='<%= slClassValue %>'  >
					<%
						expiry_rule = record[4];
						if(expiry_rule == null){expiry_rule = "";}
					%>
					<input type='text' name='expiry_rule<%=i%>' id='expiry_rule<%=i%>' value='<%=expiry_rule%>' size='3' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="return ORChkPositiveNumber(this,'<%=i%>')" class='NUMBER'>			
					<span id='exp_rule_<%=i%>' >
					<% if(expiry_rule.trim().equals("")){%>
						
					<%}else{%>	
						<img src='../../eCommon/images/mandatory.gif' align=center>
					<%}%>	
					</span>
				</td>
							<td  class='<%= slClassValue %>'  width='10%'>
							<%future_order=record[5];
					if(future_order==null){future_order="";}
					%>
							<input type='text' name='future_order<%=i%>' id='future_order<%=i%>' value='<%=future_order%>'      size='3' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' class="NUMBER"  onBlur="onRuleChanges('<%=i%>')">
					</td>
							<td  class='<%= slClassValue %>' width='14%' >
							<%futureorderduration=record[6];
					if(futureorderduration==null){futureorderduration="";}%>
							<SELECT name="futureorderduration<%=i%>" id="futureorderduration<%=i%>" onchange="chkFutureOrder(this,'<%=i%>')"><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  ---</option>
							<option value="M" <% if(futureorderduration.equals("M")){out.println(" selected ");}%>><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
							<option value="H" <% if(futureorderduration.equals("H")){out.println(" selected ");}%>> <fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
							<option value="D" <% if(futureorderduration.equals("D")){out.println(" selected ");}%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
							<option value="W" <% if(futureorderduration.equals("W")){out.println(" selected ");}%>><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
							<option value="m" <% if(futureorderduration.equals("m")){out.println(" selected ");}%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
							<option value="Y" <% if(futureorderduration.equals("Y")){out.println(" selected ");}%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
							</SELECT>
							<span id='futureduration<%=i%>' >
					<% if(futureorderduration.trim().equals("")){%>
						
					<%}else{%>	
						<img src='../../eCommon/images/mandatory.gif' align=center>
					<%}%>	
					</span>
				</td>
				<td class='<%= slClassValue %>' >
				 <%
						floor_to_start_day_yn = record[7];
						if(floor_to_start_day_yn == null){floor_to_start_day_yn = "";}
						if(floor_to_start_day_yn.equals("N")){
							floor_to_start_day_yn = "";
						}else if(floor_to_start_day_yn.equals("Y")){
							floor_to_start_day_yn = " checked ";
						}
				%> 
				<input type=checkbox name="floor_to_start_day_yn<%=i%>" id="floor_to_start_day_yn<%=i%>"  value="" <%=floor_to_start_day_yn%>></td>
			</tr>
<%		preselect_pr_disable = "";
		}  
		OrderTypeData=null;
//						out.println(bean.chk);
%>
			</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

<input type="hidden" name="order_category" id="order_category" value="">
<input type="hidden" name="patientClass" id="patientClass" value="">
<input type="hidden" name="preselect_ord_type" id="preselect_ord_type" value="">
<input type="hidden" name="time_based_rule" id="time_based_rule" value="">
<input type="hidden" name="expiry_rule" id="expiry_rule" value="">
<input type="hidden" name="future_order" id="future_order" value="">
<input type="hidden" name="futureorderduration" id="futureorderduration" value="">
<input type="hidden" name="floor_to_start_day_yn" id="floor_to_start_day_yn" value="">


</form>
</body>
</html>
<%
putObjectInBean( bean_id, bean, request) ;
%>

