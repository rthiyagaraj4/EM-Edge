<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

28/11/2019       IN059899        PRATHYUSHA                          JD-CRF-0200
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.Properties,ePH.*,ePH.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../ePH/js/MedicationAdministrationRights.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown="lockKey()">
<form name='Search_form' id='Search_form'>
<%
 	String mode				=	"";
	String bean_id			=	"";
	String bean_name		=	"";
	String codeDisabled     =   "";
	String user_id			=	"";
	String user_name		=	"";

	
	try{
	mode					=	 request.getParameter("mode");
	bean_id					=	"MedicationAdministrationRights" ;
	bean_name				=	"ePH.MedicationAdministrationRightsBean";
	if ( mode == null || mode.equals("") ) 
		return ;
	if (!(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	MedicationAdministrationRightsBean bean = (MedicationAdministrationRightsBean)getBeanObject( bean_id,bean_name, request) ;  
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		out.println("Exception@1: "+e.toString());
		e.printStackTrace();
	}

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	= "disabled";
		user_id	= request.getParameter("user_id");
		user_name= request.getParameter("user_name");
		
		
	}

%>

  <br>
  <table border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>
	<tr>
		<td  width='20%'>&nbsp;</td>
		<td >&nbsp;</td>
	</tr>
	 <tr>
	  	<td align='right' class='label'><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		 <td align='left' class=label id=td5>
		 <input type="text" name="user_name" id="user_name" value="<%=user_name%>" size=60 maxLength=60    align="centre" <%=codeDisabled%>><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(user_name)" align="left" <%=codeDisabled%>>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="user_id" id="user_id" value="<%=user_id%>" size="15"></td>
	</tr>
	
	<tr>
		<td colspan=2>&nbsp;&nbsp;</td>
	</tr> 
	</table>
<input type='hidden' name='SelectYNStr' id='SelectYNStr' value="">
<input type='hidden' name='mode' id='mode' value="<%=mode%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_RIGHTS_SELECT1")%>">
					
	


</form>
<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
		<script>searchDetails("MODE_MODIFY");</script>
	<%}%>
</body>
</html>



