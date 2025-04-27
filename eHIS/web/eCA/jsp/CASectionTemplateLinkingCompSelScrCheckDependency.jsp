<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
%>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String selectedCompIdSrlNo=request.getParameter("selectedCompIdSrlNo")==null?"":request.getParameter("selectedCompIdSrlNo");
String index=request.getParameter("index")==null?"":request.getParameter("index");
int val = templateBean.isDependent(selectedCompIdSrlNo);
%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script>
<%if(val==-1){%>
	var msg =getMessage("COMP_ALREADY_LINKED","CA");
	msg =msg.replace('linked with another','parent of set of')
	alert(msg);
	//alert("Component is already parent of set of component");
	parent.templateLinkingCompSelectionFrame.document.forms[0].check<%=index%>.checked=false;
	if(parent.templateLinkingCompSelectionFrame.document.forms[0].compType<%=index%>.value=="L")
		parent.templateLinkingCompSelectionFrame.countList--;
	else
		parent.templateLinkingCompSelectionFrame.countOther--;
	
<%}else if(val==-2){%>
	alert(getMessage("COMP_ALREADY_LINKED","CA"));
	//alert("Component is already linked with another component");
	parent.templateLinkingCompSelectionFrame.document.forms[0].check<%=index%>.checked=false;
	if(parent.templateLinkingCompSelectionFrame.document.forms[0].compType<%=index%>.value=="L")
		parent.templateLinkingCompSelectionFrame.countList--;
	else
		parent.templateLinkingCompSelectionFrame.countOther--;
<%}%>
</script>

