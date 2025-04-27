<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.Properties, eMM.Common.MmRepository, eMM.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<!--<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>-->
	<script src='../../eOR/js/OrCommonLookup.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
<!-- 	<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
	<script language="javascript" src='../../eMM/js/UserAccessForMaterialGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad='FocusFirstElement();disableCreate();'>
<form name='Search_form' id='Search_form' onMouseDown="CodeArrest()" >
<%
 	String mode				=	"";
//	String bean_id			=	"";
//	String bean_name		=	"";
//	String store_code_list	=	"";

//    String usre_id		    =	"";
//	String user_name		=	"";
//	String store_code		=	"";
//	String store_desc		=	"";

%>		   
  <br>
  <table border='0' cellpadding='0' cellspacing='0' width='85%' align=center>
    <tr>
	 <td  class='label'>&nbsp;&nbsp;</td>
	 <td  class='label'>&nbsp;&nbsp;</td>
	 <td  class='label'>&nbsp;&nbsp;</td>
	</tr>
    <tr>
	  	<td  class='label'><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  class=fields id=td5>
		 <input type="text" name="user_name" id="user_name" value="" size=60 maxLength=60 ><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(user_name)" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="user_id" id="user_id" value="" size="15"></td>	       	       
		 <td></td>
	</tr> 

	<tr>   
	 <td></td><td></td>
		<td width='*'  class=fields>
		<input type="button" name="Search" id="Search" class= 'button' value= '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchDetails()"></input>
		</td>									
	<tr>
	 <td  class='label'>&nbsp;&nbsp;</td>
	 <td  class='label'>&nbsp;&nbsp;</td>
	 <td  class='label'>&nbsp;&nbsp;</td>
	</tr>
</table>

<input type='hidden' name='SelectYNStr' id='SelectYNStr' value="">
<input type='hidden' name='language_id' id='language_id' value="<%=locale%>">
<input type="hidden" name="SQL_SM_APPL_USER_USER_LOOK_UP" id="SQL_SM_APPL_USER_USER_LOOK_UP" value="<%=MmRepository.getMmKeyValue("SQL_SM_APPL_USER_USER_LOOK_UP")%>">
<input type='hidden' name='mode' id='mode' value="<%=mode%>">		 
</form>
</body>
</html>



