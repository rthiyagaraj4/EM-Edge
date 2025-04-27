<!DOCTYPE html>
  <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
%>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/GenericNameByATC.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String param	=	request.getParameter("param");
	if (param==null)
		param="";
	if (param.equals("")){
%>
<iframe name="genericname_top" id="genericname_top" frameborder="0" scrolling="no" noresize  src="../../eCommon/html/blank.html" style="height:15vh;width:100vw"></iframe><iframe name="genericname_bottom" id="genericname_bottom" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:85vh;width:100vw"></iframe>
<%
	}
	else if (param.equals("createIfFrameIsNull")){
%>
<iframe name="genericname_top" id="genericname_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/GenericNameAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:15vh;width:100vw"></iframe><iframe name="genericname_bottom" id="genericname_bottom" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/GenericNameByATCAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:85vh;width:100vw"></iframe>

<%
	}
	else if(param.equals("queryIfFrameIsNull")){
%>
<iframe name="genericname_top" id="genericname_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/GenericNameByATCQueryCriteria.jsp" style="height:15vh;width:100vw"></iframe><iframe name="genericname_bottom" id="genericname_bottom" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/GenericNameByATCAddModify.jsp?queryCriteria=Y" style="height:85vh;width:100vw"></iframe>
<%
	}
	else if (param.equals("ModifyIfFrameIsNull")){
		String generic_id=request.getParameter("generic_id");
		String drugclass=request.getParameter("drugclass");
		String enabledisable=request.getParameter("enabledisable");
%>
<iframe name="genericname_top" id="genericname_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/GenericNameAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_MODIFY")%>&generic_id=<%=generic_id %>&drugclass=<%=drugclass%>" style="height:15vh;width:100vw"></iframe><iframe name="genericname_bottom" id="genericname_bottom" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/GenericNameByATCAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_MODIFY")%>&generic_id=<%=generic_id %>&enabledisable=<%=enabledisable%>" style="height:85vh;width:100vw"></iframe>
<%
	}
	else if (param.equals("ATCClassification")){
		String retVal =request.getParameter("atcclassification");
%>
	<iframe name="genericname_top" id="genericname_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/GenericNameAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_MODIFY")%>&atcclassification=<%=retVal%>&resultByATC=Y" style="height:15vh;width:100vw"></iframe><iframe name="genericname_bottom" id="genericname_bottom" frameborder="0" scrolling="auto" src="../../ePH/jsp/GenericNameByATCAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_MODIFY")%>&atcclassification=<%=retVal%>&resultByATC=Y" style="height:85vh;width:100vw"></iframe>
<%
	}
	else if (param.equals("PHARMACOClassification")){
		String retVal =request.getParameter("atcclassification");
%>
	<iframe name="genericname_top" id="genericname_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/PharmacoClassAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_MODIFY")%>&atcclassification=<%=retVal%>&resultByATC=M" style="height:15vh;width:100vw"></iframe><iframe name="genericname_bottom" id="genericname_bottom" frameborder="0" scrolling="auto" src="../../ePH/jsp/GenericNameByPharmacoAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_MODIFY")%>&atcclassification=<%=retVal%>&resultByATC=M" style="height:85vh;width:100vw"></iframe>
<%
	}
%>
</html>

