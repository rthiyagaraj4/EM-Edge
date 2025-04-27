<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
 <script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language='javascript' src="../../eST/js/AssemblyDetail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
  	<title><fmt:message key="eST.Manufacturing.label" bundle="${st_labels}"/> <fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></title>
</head>
<%
	//	boolean editMode = false;
		String bean_id = "AssemblyDetailBean";
		String bean_name = "eST.AssemblyDetailBean";
		AssemblyDetailBean bean = (AssemblyDetailBean)getBeanObject( bean_id, bean_name,request);  
				bean.setLanguageId(locale);
      //  String mode = request.getParameter("mode") ;
		String instructions = "";
          instructions = bean.checkForNull(bean.getInstruction()); 

	%>
<body onload='FocusFirstElement();' scroll="NO">
	<form name= "formMfgInstructions">
	<br>
	<table border="0" cellspacing="0" width="80%" align=center>
	  <tr>
		<td  >&nbsp;</td>
	  </tr>
	  <tr>
			<td  class='fields'><textarea name="instruction" rows="10" cols="75"><%=instructions%></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif" ></td>
	  </tr>
	  <tr>
		<td   class='fields'><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="updateInstructions();"></td>
	  </tr>
	</table>
		<input type='hidden' name='bean_id' id='bean_id' value="<%=bean_id%>" >
        <input type='hidden' name='bean_name' id='bean_name' value="<%=bean_name%>" >
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

