<!DOCTYPE html>
<%@ page import=" ePO.QuotationBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/Quotation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	System.out.println("source = "+source);
	String facilityid=(String)session.getValue("facility_id");
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	QuotationBean bean = (QuotationBean) getBeanObject("quotationBean","ePO.QuotationBean", request );  
	bean.initialize();
	bean.setLanguageId(locale);

	if(!bean.checkForNull((String)	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("PO_INTERFACE_YN"),"N").equals("Y")){ 	
	%>
  <SCRIPT>alert("Purchase Module Not Applicable");window.location.href = '../../eCommon/jsp/dmenu.jsp'</SCRIPT>   
   <%
  } 
	if(!bean.checkForNull((String)bean.fetchRecord("select  QUOT_ALLOWED_YN  from  PO_USER_FOR_DELVORD where USER_ID=?",new String[]{(String) session.getValue( "login_user" )}).get("QUOT_ALLOWED_YN"),"N").equals("Y")){
  %>
  <SCRIPT>alert("User does not have access");window.location.href = '../../eCommon/jsp/dmenu.jsp'</SCRIPT>   
 <%
	} 
	putObjectInBean("quotationBean",bean,request);
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>

</html>


