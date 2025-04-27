<!DOCTYPE html>
 <%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="ll" class="eMM.Common.MmRepository"/>
<jsp:useBean id="lwl" class="eMM.MM_license_rights"/>
<jsp:useBean id="lll" class="eMM.UserAccessForMaterialGroupBean"/>
<html>
<head>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eMM/js/UserAccessForMaterialGroup.js"></script>
    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>";
    </script>
</head>
<%
	String bean_id		=	"UserAccessForMaterialGroupBean";
	String bean_name	=	"eMM.UserAccessForMaterialGroupBean";
	UserAccessForMaterialGroupBean bean = (UserAccessForMaterialGroupBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	ArrayList	arrSSIV	=	null;
	HashMap		hmSSIV	=	null;
	String	IV  = "";
	String  PO	= "";
	
	arrSSIV =	bean.isSSIVModuleInstalled();
	int arrLen	=	arrSSIV.size();
	for(int i=0;i<arrLen; i++)
	{
		hmSSIV		=	(HashMap) arrSSIV.get(i); 
		IV				=	(String)hmSSIV.get("IV"); // "I" ;Comment should be removed
		PO				=	(String)hmSSIV.get("PO"); //"N";Comment should be removed
	}

	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params =request.getQueryString() ;
	String source = url + params ;

	if( (!IV.trim().equals("I")) && (PO.trim().equals("N"))){

		%>
		<script language="javascript">
		alert(getMessage("NOT_APPL_FOR_THIS_INSTAL","MM"));
		window.location.href =
'../../eCommon/jsp/dmenu.jsp'
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		}
	else {			 
	%>	
		
<iframe name = "commontoolbarFrame" frameborder = "0" scrolling = "no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name = "f_query_add_user" frameborder = "0" scrolling = "auto" noresize src="../../eMM/jsp/UserAccessForMaterialGroupHeader.jsp" style="height:19vh;width:100vw"></iframe>
<iframe name = "f_query_add_mod" frameborder = "0" scrolling = "auto" noresize src="../../eCommon/html/blank.html" style="height:64vh;width:100vw"></iframe>
<iframe name = "messageFrame" src="../../eCommon/jsp/error.jsp" frameborder = "0" noresize scrolling = "auto" style="height:9vh;width:100vw"></iframe>
	 <%
		}
	%>
	<%
putObjectInBean(bean_id,bean,request);
%>
</html>	

