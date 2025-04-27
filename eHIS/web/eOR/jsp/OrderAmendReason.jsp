<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = "1";
	String bean_id = request.getParameter("bean_id"); ;
	String bean_name = request.getParameter("bean_name");;
	String ord_cat = request.getParameter("ord_cat");
	String amendReasonMandYN = request.getParameter("amendReasonMandYN");
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);	
	allValues		= bean.getOrderAmendReasons(ord_cat);
	
%>

<html>
<head>
	<title><fmt:message key="eOR.amendreason1.label" bundle="${or_labels}"/></title>
	<!--<title>Amend Reason<fmt:message key="eOR.AmendReason.label" bundle="${or_labels}"/></title>-->
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<Script>
 	function initialize() 
	{
			var retArray=new Array();
			retArray=parent.window.dialogArguments;
			if(retArray!=null && retArray.length!=0)
			{
    					document.getElementById("reason_desc").value = retArray[0];
    					document.getElementById("cancel_reason").selectedIndex = retArray[1];
			}
 	}
 	function CheckMaxLength(obj,max) 
 	{  
 		if(obj.value.length >= max) 
 		{
 			alert(getMessage('MAX_255_CHARS','OR'))
 			obj.focus();
 			return false;
 		}
 		else 
 			return true;
 	}
 	function displayDesc(obj)
 	{ 
 		if(""!=obj.value){ 			
 			document.forms[0].amend_desc.value = eval("document.forms[0]."+obj.value+".value");
 		}else{
 			document.forms[0].amend_desc.value ="";
 		}
 	}
 	function closeWindow()
 	{ 		
 		window.returnValue="WindowClose"; 		
 		
 		window.close();
 	}
 	function selectReason(){
 		if(document.amend_reason_form.amendReasonMandYN.value=="Y"){
 			if(document.amend_reason_form.amend_desc.value == "")
 	 		{
 				alert(getMessage('DESC_NOT_BLANK','OR'))
 	 			return false;
 	 		} 			
 			
 		} 		
 		if(document.amend_reason_form.amend_desc.value.length>0){
 			if(document.amend_reason_form.amend_desc.value.length >= 255) 
 	 		{
 	 			alert(getMessage('MAX_255_CHARS','OR'));
 	 			return false;
 	 		} 			
 		}
 		
 		window.returnValue=encodeURIComponent(document.amend_reason_form.amend_desc.value); 		
 		
 		window.close();
 		
 	}
	 </Script>
</head>
<body   onload='initialize();'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST name="amend_reason_form" id="amend_reason_form">
	<table cellpadding=3 cellspacing=0 border=0 width='100%' height='100%' align='center'>
		<tr>
			<td class=label><fmt:message key="eOR.amendreason1.label" bundle="${or_labels}"/></td>
			<td class=fields>
				<SELECT name="amend_reason" id="amend_reason" onchange='displayDesc(this)'>
					<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
					try{
						for(int i=0; i<allValues.size(); i++){
							String[] record = (String [])allValues.get(i);
							//System.out.println("--->"+record[0]+"<-------->"+record[1]+"<-------->"+record[2]+"<------");
							%>
							<option value="A<%=i%>"><%=record[1]%></option>
							<%
              			}
					}catch(Exception e){
					//	out.println(e);
						e.printStackTrace();//COMMON-ICN-0181
					}
				%>
				</SELECT>				
			</td>
		</tr>
		<tr>
			<td class="fields" colspan="2">
				<TEXTAREA NAME="amend_desc" ROWS="12" COLS="50" onBlur = "return makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"></TEXTAREA> 
				<% if("Y".equals(amendReasonMandYN)){%>
				<img src="../../eCommon/images/mandatory.gif"></img>
				<%} %>
			</td>
		</tr>
		<tr>
			<td colspan='3' class='button'>
				<input type=button class=button name='ok' id='ok' Value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick='selectReason()'>
				<input type=button class=button name='close' id='close' Value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='closeWindow()'>
			</td>
		</tr>
		<%
			try{
				for(int i=0; i<allValues.size(); i++){
					String[] record = (String [])allValues.get(i);					
					%>					
					<input type='hidden' name='A<%=i%>' id='A<%=i%>' value='<%=record[2]%>' />
					<%
            			}
			}catch(Exception e){
			//	out.println(e);
				e.printStackTrace();//COMMON-ICN-0181
			}
		%>
		<input type="hidden" name="amendReasonMandYN" id="amendReasonMandYN" value="<%=amendReasonMandYN %>"/>
	</table>
	
</FORM>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

