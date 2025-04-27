<%@ page import=" eMM.*, eMM.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String bean_id				=	"ItemMasterBean" ;
	String bean_name			=	"eMM.ItemMasterBean";
	ItemMasterBean bean = (ItemMasterBean) getBeanObject("ItemMasterBean","eMM.ItemMasterBean",request);
	bean.setLanguageId(locale);
	//String item_spec=request.getParameter("item_specification");
	
%>
<html>
	<head>
	<% 
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<title><fmt:message key="eMM.ItemSpecification.label" bundle="${mm_labels}"/>&nbsp;
		</title>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eMM/js/Item.js"> </script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

 <!--Added by Sakti against inc#39416-->
	</head>
	<body>
<form id='formRemark' name='formRemark' id='formRemark'>
  <p>
	<table width='297' height='100%' border='0'cellpadding='0' cellspacing='0' align=center>
	  <tr>
		  <td>&nbsp;
		  </td>
	  </tr>
	  <tr>
		  <td class=fields  valign='top'>
			  <textarea rows="6" name="remark" id="remark" cols="60" onBlur="makeValidString(this);" onpaste="checkMaxLengthPaste(this,4000);" onKeyPress="checkMaxLimit(this,4000);"><%=bean.getSpecification()%></textarea>
	      </td>
	  </tr>
	  <tr>
		<td class=fields>
			<input type="Button"  class="BUTTON" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  name="close" id="close" onclick="closeMe();">
		</td>
		</tr>
  </p>
  <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>

</body>
</html>

