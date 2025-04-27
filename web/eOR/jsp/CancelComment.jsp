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
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CancelOrder" ;
	String bean_name = "eOR.CancelOrder";

	String ord_cat = request.getParameter("ord_cat");
	String cancelled_at = request.getParameter("cancelled_at");
	String reason_desc = request.getParameter("reason_desc");
	if(reason_desc!=null && !reason_desc.equals("")) {
		reason_desc = reason_desc.replace('\"','\n');
	}
	//out.println(ord_cat+"<BR>");
//	out.println(cancelled_at+"<BR>");

	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	//CancelOrder bean = (CancelOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	allValues		= bean.getCancelReason(ord_cat);
	//out.println(allValues.size());
%>

<html>
<head>
	<title><fmt:message key="eOR.CancelReason.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
 	<script language="JavaScript" src="../js/CancelOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 	<Script>
 	function initialize() 
	{
			var retArray=new Array();
			retArray=top.dialogArray[top.dialogArray.length - 1].querySelector("#dialog-body").contentWindow.dialogArguments;
			if(retArray == undefined)
				retArray=top.dialogArray[top.dialogArray.length - 2].querySelector("#dialog-body")?.contentWindow.dialogArguments;
				
			if(retArray!=null && retArray.length!=0)
			{
    					document.getElementById("reason_desc").value = retArray[0];
    					document.getElementById("cancel_reason").selectedIndex = retArray[1];
			}
 		}
	 </Script>
</head>
<style>
textarea {
  resize: none;
}
</style>
<body   onload='FocusFirstElement();initialize();'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST name="cancel_comment" id="cancel_comment">
<table cellpadding=3 cellspacing=3 border=0 width='100%' height='100%' align='center'>
	<tr>
		<td class=label><fmt:message key="eOR.CancelReason.label" bundle="${or_labels}"/></td>
		<td class=fields>
			<SELECT name="cancel_reason" id="cancel_reason" onchange='displayDesc(this)'>
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
				try{


				for(int i=0; i<allValues.size(); i++){
					String[] record = (String [])allValues.get(i);

		%>
				<option value="<%=record[1]%>"><%=record[2]%>
		<%
              }
//				allValues.clear();
			}catch(Exception e){
				//out.println(e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		%>
	</SELECT>
	</td>
	</tr>
	<tr>
	<td class="fields" colspan="2">
	<TEXTAREA name="reason_desc" id="reason_desc" ROWS="12" COLS="50" onBlur = "return makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"></TEXTAREA> <%--=reason_desc%--%>
	</td>
	</tr>
	<tr>
		<td colspan='2' class='button' align='right' style="padding-right:50px;">
			<input type=button class=button  name='ok' id='ok' Value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick='selectReason()'>
		</td>
	</tr>
	</table>
	<input type="hidden" name="cancelled_at" id="cancelled_at" value="<%=cancelled_at%>">
</FORM>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

