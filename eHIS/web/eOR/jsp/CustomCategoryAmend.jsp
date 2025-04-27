<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/CustomCategory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%	
	request.setCharacterEncoding("UTF-8");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String login_user	= (String)session.getValue("login_user");

	String bean_id   = "custom_category" ;
	String bean_name = "eOR.CustomCategoryBean";	
	CustomCategoryBean bean = (CustomCategoryBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	bean.setLanguageId(localeName);
	ArrayList categoryData = new ArrayList();
%>
<form name="custom_category" id="custom_category" method="post" target="messageFrame">
<table  class='grid' width="100%">
	<tr>
		<td class="COLUMNHEADER" width="10%" style="text-align:center;">
			<fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
		</td>
		<td class="COLUMNHEADER" width="15%" style="text-align:center;">
			<fmt:message key="eOR.DispCustCat.label" bundle="${or_labels}"/>
		</td>
	</tr>
	<%
		int ilRow=0;
		String slClassValue = "";
		String checked1 = "";
		String mode = "";
		
		categoryData = bean.getCustomCategory(login_user);
		System.out.println("CustomCategoryAmend.jsp,categoryData=>"+categoryData.size());
		if(categoryData.size()==0)
		{
			mode = "1";
			categoryData = bean.getOrderCategory();
		}	
		else 
			mode = "2";
				
		String[] record=null;
		String result_disabled="";
		String chkPend = "Y";
		String disableChkPend="";
	%>
	<input name ='category_size' type='hidden' value='<%=categoryData.size()%>'>
	<%
		for(int i=0; i<categoryData.size(); i++)
		{
			record = (String [])categoryData.get(i);	
			System.out.println("record[0]=>"+record[0]+",record[1]=>"+record[1]+",record[2]=>"+record[2]);
			if(record[1].equals("null")||record[1].equals(" ")||record[1]==null)record[1]="";
			if(record[2].equals("null")||record[2].equals(" ")||record[2]==null)record[2]="N";
			if(ilRow % 2 == 0)
			{
				slClassValue = "gridData";
			}
			else   
			{
				slClassValue = "gridData";
			}
			if(record[0].equals("CN")||record[0].equals("CS"))
			{
				result_disabled="disabled";
			}
			else
			{
				result_disabled="";
			}
			if(record[2].equals("Y")) 
				checked1="checked";
						
			if(chkPend.equals("N"))	
			{
				disableChkPend = "disabled";
			}
			else
			{
				disableChkPend = "";
			}
			
			%>
		
			<tr>
				<td  class='<%= slClassValue %>'><%=record[0]%> 			
					<input type=hidden name=order_cat<%=i%> value=<%=record[0]%>>				
				</td>				

				<td class='<%= slClassValue %>'>
					<input type=text name=short_desc<%=i%> value="<%=record[1]%>" maxlength=15 onBlur="makeValidString(this);"><%if(i==0){%><img src="../../eCommon/images/mandatory.gif" ></img><%}%>
				</td>
			
				<td class='<%= slClassValue %>'  style="text-align:center;">
					<input type=checkbox name=chk1_<%=i%> value = <%=record[2]%> <%=checked1%> onClick='changeValue(this)' <%=disableChkPend%>>
				</td>
			
			</tr>
			<%	
			ilRow++;
			checked1 = "";
		}
	%>
</table>

<input type="hidden" name="totalRecords" id="totalRecords" value="<%=categoryData.size()%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="Order_Category">
<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">
<%
	categoryData=null;
%>
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

