<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//check for the selected components to be linked.....and loading the dependent components into the bean
java.util.Vector dependentComponent = new java.util.Vector();
String selectedCompIdSrlNo= "";
int count = Integer.parseInt(request.getParameter("count"));
String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
String srlNo=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
for(int i=0;i<count;i++)
{
	if(request.getParameter("check"+i)!=null && request.getParameter("check"+i).equals("Y"))
	{
		selectedCompIdSrlNo = request.getParameter("selectedCompIdSrlNo"+i);
		dependentComponent.add(selectedCompIdSrlNo);
	}
}
templateBean.setAssociatedComponents((compId+srlNo),dependentComponent);

putObjectInBean("templateBean",templateBean,session);

dependentComponent = null;
%>
<script>parent.window.close()</script>

