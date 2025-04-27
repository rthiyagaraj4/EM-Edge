<!DOCTYPE html>

 <%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*",import="eCommon.XSSRequestWrapper"; contentType="text/html;charset=UTF-8 "%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>




<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/ReturnMedication.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.ReturnMedicationLogin.label" bundle="${ph_labels}"/></title>
</HEAD>
<%
	String password="";
	String userName="";
	String userId="";

	String origpwd=request.getParameter("password");
	String patclass=request.getParameter("patclass");
	
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
	String bean_id = "ReturnMedicationBean"+login_at_ws_no ; ;
	String bean_name = "ePH.ReturnMedicationBean";
	ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject(bean_id,bean_name,request) ;
	String homepage			= request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String store_code			= request.getParameter("store_code")==null?"": request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]

	ArrayList userDetails=bean.getUserDetails();
	if (userDetails.size()>0){
		userName=(String)userDetails.get(0);
		password=(String)userDetails.get(1);
		userId=(String)userDetails.get(2);
	}
	//Retrieve dispense locations for Out Patient (default)
	ArrayList dispLocn=new ArrayList();
	dispLocn=bean.getDispLocn("O",locale);
%>
<body onLoad="document.FormReturnMedicationLogin.password.focus();" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<form name="FormReturnMedicationLogin" id="FormReturnMedicationLogin">
<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0" >
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td align="right" class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
	<td align="left" >&nbsp;&nbsp;
		<input type="user_name" name="user_name" id="user_name" size="55" maxlength="60" value="<%=userName%>" readOnly>		
	</td>
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<td align="left" >&nbsp;&nbsp;
<% 	if (origpwd.equals("")) { %>
	<input type="password" name="password" id="password" size="55" maxlength="60" value="" onKeyPress="uppercase()"  autocomplete="off">  <!--41741 autocomplete="off"-->
	<%}else{%>
		<input type="password" name="password" id="password" size="55" readonly maxlength="60" onKeyPress="uppercase()" value="<%=origpwd%>" autocomplete="off">	 <!--41741 autocomplete="off"-->
	<%}%>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>		
	</td>
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
	<td align="left" >&nbsp;&nbsp;
		<select name="Patient_Category" id="Patient_Category" onChange="populateDispLocn()">
		
		<% 	if (patclass.equals("O")) { %>
		<option value="O" selected><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
		<%}
		else{%>
			<option value="O" ><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
		<%}%>
		
		<% 	if (patclass.equals("I")) { %>
		<option value="I" selected><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
		<%}
		else{%>
			<option value="I" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
		<%}%>
		
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
	<td align="left">&nbsp;&nbsp;
		<select name="disp_locn" id="disp_locn"  >
		<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;</option>
		<%
			if (dispLocn.size()>0){
				for (int i=0;i<dispLocn.size();i=i+2){
					if (dispLocn.size()==2 || store_code.equals((String)dispLocn.get(i))){
						out.println("<option selected value=\""+dispLocn.get(i)+"\">"+dispLocn.get(i+1)+"</option>");
					}
					else{
						out.println("<option value=\""+dispLocn.get(i)+"\">"+dispLocn.get(i+1)+"</option>");
					}
				}
			}
		%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>	
</tr>
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td align="right" colspan="2" class="white">
		<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="checkLogin()">	
		<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.close();">
	</td>	
</tr>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="orig_pwd" id="orig_pwd" value="<%=password%>">
	<input type="hidden" name="user_id" id="user_id" value="<%=userId%>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

