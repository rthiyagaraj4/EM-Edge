<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--OrderingRuleByPractitionerlAddModifyMiddle.jsp -->
<%--
*	Copyright © IBA Health India (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eOR
*	Purpose 		:	
*	Created By		:	Harichandra Reddy 
*	Created On		:	03 Aug 2007
--%>
<%-- 	
-----------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
-----------------------------------------------------------------------------------------------------------------------

15/08/2020		IN071361	Nijitha S	15/08/2020	Ramesh G	AAKH-CRF-0116
29/01/2021		13628		Nijitha S	29/01/2021	Nijitha S	ML-MMOH-SCF-1720
-----------------------------------------------------------------------------------------------------------------------
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script><!-- IN071361 -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderingRuleByPractitioner.js"></script>
 	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head><body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	/* Mandatory checks start */
	String mode				=	request.getParameter( "mode" ) ;
	String pract_type		=	request.getParameter( "pract_type" ) ;
	String force_auth_options = "";
	
	if(pract_type == null)pract_type = "";
	pract_type = pract_type.trim();
	
	String bean_id = "Or_OrderingRuleByPractitionerBean" ;
	String bean_name = "eOR.OrderingRuleByPractitionerBean";

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	OrderingRuleByPractitionerBean bean = (OrderingRuleByPractitionerBean)getBeanObject( bean_id,bean_name ,request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	ArrayList Category_Data = new ArrayList();
	//ArrayList selected_categories = new ArrayList();
	String pract_timebased_appli_yn = bean.getPractTimeBasedRuleApplicableYN();//IN071361
%>
<form name='dept_only_Catalog_appl_middle' id='dept_only_Catalog_appl_middle' target='messageFrame' >
<table class='grid' cellpadding='3' cellspacing=0 width="100%" border="1">
	<tr>
		<th  class="columnheader" align="left"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
		<th  class="columnheader" align="left"><fmt:message key="eOR.OrderDeptOnlyCatalogs.label" bundle="${or_labels}"/></th> 
		<th  class="columnheader" align="left"><fmt:message key="eOR.ForceAuthorization.label" bundle="${or_labels}"/></th>
		<th  class="columnheader" align="left"><fmt:message key="eOR.ForceCo-Sign.label" bundle="${or_labels}"/></th>
		<!-- IN071361 Starts -->
		<%if("Y".equals(pract_timebased_appli_yn) ){%>
		<th class=columnheader width='15%'><fmt:message key="eOR.TimeBasedRule.label" bundle="${or_labels}"/></th>
		<th class=columnheader width='15%'><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/></th>
		<%} %>
		<!-- IN071361 Ends -->
	</tr>
	<%
	Category_Data = bean.getOrderCategory(pract_type);
	//selected_categories = bean.getSelectedOrderCategories(pract_type);
	//System.out.println("size========"+selected_categories);
	String[] record=null;
	String classValue = "";
	String checked1 = "",checked2 = "",checked3 = "";
	String time_based_rule = "";//IN071361
	String expiry_rule = "";//IN071361
	for(int i=0; i<Category_Data.size(); i++)
	{	
		record = (String [])Category_Data.get(i);
			    
				 if(record[2].equals("Y"))
					checked1 = " checked ";
				if(record[3].equals("Y"))
					checked2 = " checked ";
				if(record[4].equals("Y"))
					checked3 = " checked ";
				force_auth_options = record[3]==null?"":record[3];
		 if(i%2==0)
		{
			classValue = "gridData";
		}
		else
		{
			classValue = "gridData";
		}
		%>
		<tr>
			<td align="left" class='<%= classValue %>'><%=record[1]%><input type="hidden"  name="ord_category_code<%=i%>" id="ord_category_code<%=i%>"  value="<%=record[0]%>">	</td>
			<td align="left" class='<%= classValue %>'><input type=checkbox name="dept_only<%=i%>" id="dept_only<%=i%>"  value="" <%=checked1%>></td>
			<td align="left" class="<%= classValue %>">
				<select name="force_auth<%=i%>" id="force_auth<%=i%>">
					<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<option value="AF" <%=(force_auth_options.equalsIgnoreCase("AF"))?"selected":""%>><fmt:message key="eOR.AuthorizeForceAuthorization.label" bundle="${or_labels}"/></option>
					<option value="Y" <%=(force_auth_options.equalsIgnoreCase("Y"))?"selected":""%>><fmt:message key="eOR.ForceAuthorization.label" bundle="${or_labels}"/></option>
				</select>
			</td>
			<td align="left" class="<%= classValue %>" ><input type=checkbox name="force_cosign<%=i%>" id="force_cosign<%=i%>" value="" <%=checked3%>  ></td>
			<!-- IN071361 Starts -->
			<%if("Y".equals(pract_timebased_appli_yn) ){%>
			<td  class='<%= classValue %>' width='20%'>
					
					<%
						time_based_rule = record[6];
						if(time_based_rule==null){ time_based_rule = ""; }%>
					<SELECT name="time_based_rule<%=i%>" id="time_based_rule<%=i%>" onChange="onRuleChange('<%=i%>')" style="width:175px">
						<option value=" "> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>						
						<option value="DAD" <% if(time_based_rule.equals("DAD")){out.println(" selected ");}%>><fmt:message key="Common.DayAfterDischarge.label" bundle="${common_labels}"/>/OP or AE Checkout </option>
						<option value="HAD" <% if(time_based_rule.equals("HAD")){out.println(" selected ");}%>><fmt:message key="Common.HourAfterDischarge.label" bundle="${common_labels}"/>/OP or AE Checkout</option>
						<option value="DAA" <% if(time_based_rule.equals("DAA")){out.println(" selected ");}%>><fmt:message key="eOR.DayAfterDischargeAdvice.label" bundle="${or_labels}"/></option>
						<option value="HAA" <% if(time_based_rule.equals("HAA")){out.println(" selected ");}%>><fmt:message key="eOR.HourAfterDischargeAdvice.label" bundle="${or_labels}"/></option>
					</SELECT>
						<span id='time_based_<%=i%>'></span>
				</td>
				<td  class='<%= classValue %>'  >
					<%
						expiry_rule = record[5];
						if(expiry_rule == null){expiry_rule = "";}
					%>
					<input type='text' name='expiry_rule<%=i%>' id='expiry_rule<%=i%>' value='<%=expiry_rule%>' size='2' maxlength='2' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="return ORChkPositiveNumber(this,'<%=i%>')" class='NUMBER'>			
					<span id='exp_rule_<%=i%>' >
					<% if(expiry_rule.trim().equals("")){%>
						
					<%}else{%>	
						<img src='../../eCommon/images/mandatory.gif' align=center>
					<%}%>	
					</span>
				</td>
				<%} %>
				<!-- IN071361 Ends -->
		</tr>
	<%
				checked1 = "";
			    checked2 = "";
			    checked3 = "";
	}
	%>
</table>
<input type="hidden" name="tot_count" id="tot_count" value="<%=Category_Data.size()%>">
<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="pract_timebased_appli_yn" id="pract_timebased_appli_yn" value="<%= pract_timebased_appli_yn %>"><!--13628 -->
</form>

</body>
</html>		
<%
putObjectInBean( bean_id, bean , request) ;  
%>

