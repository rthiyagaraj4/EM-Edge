<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<%-- Mandatory declarations end --%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src="../../eST/js/ManufacturingRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	//java.util.HashMap defaultParameter = null;
	String bean_id = "ManufacturingRequestBean";
	String bean_name = "eST.ManufacturingRequestBean";
//pmd 29/01/05
//String disable ="";
	ManufacturingRequestBean bean = (ManufacturingRequestBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String index				=	bean.checkForNull(request.getParameter("index"),"-1");
	String remarks	= request.getParameter( "remarks" )==null?"":  request.getParameter( "remarks" );
	
	%>
	<body onMouseDown="CodeArrest()">
	<form name="manufacturing_form" id="manufacturing_form" >

	<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td class='fields'><textarea name=remarks  cols=50 rows=10  onKeyPress="return setTextAreaMaxLength(this, 200);" ><%=remarks%></textarea></td>
	</tr>

	<tr><td>&nbsp;</td></tr>
	<tr >
		<td  class="WHITE" ><input type=button name='ok' id='ok' value=" OK " class='Button'  onClick="retainVal(remarks);"     >&nbsp;<input type=button name='Cancel' id='Cancel' value=" Cancel " class='Button'  onClick="closeModal(<%=index%>);"    >
	</td>
</tr>
</table>
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

