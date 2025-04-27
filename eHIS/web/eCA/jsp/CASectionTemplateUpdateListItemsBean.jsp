<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date   		Rev.By		Description
--------------------------------------------------------------------------------------------------------------------------------
14/08/2017		IN064910		Raja S			14/08/2017		Ramesh G	The sequence not listed accordingly as per configuration in Discrete Measure function.
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%
	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
%>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compItemId= request.getParameter("compItemId");
	String currentCompIdSrlNo= request.getParameter("currentCompIdSrlNo");
//	String strBeanFmtCompIdSrlNo = "";
	//String compIdSrlNo= request.getParameter("compIdSrlNo");
	String defaultItemId= request.getParameter("defaultButton")==null?"":request.getParameter("defaultButton");

	int count = Integer.parseInt(request.getParameter("count"));
	String listItemId = "";
	String listItemText = "";
	//HashMap hashmap=new HashMap(); //Commented for IN064910
	LinkedHashMap hashmap=new LinkedHashMap(); //Added for IN064910
	hashmap.put("DEFAULT_CODE",defaultItemId);
	for(int i=0;i<count;i++)
	{
		if(request.getParameter("check"+i)!=null && request.getParameter("check"+i).equals("Y"))
		{
			listItemId = request.getParameter("listItemId"+i);
			listItemText = request.getParameter("listItemText"+i);
			hashmap.put(listItemId,listItemText);
			//out.println(currentCompIdSrlNo+" " +i);
			
			//out.println(currentCompIdSrlNo+"    "+compItemId);
			//out.println(templateBean.displayData());
			
		}
	}
	
//	strBeanFmtCompIdSrlNo = "C_"+currentCompIdSrlNo);
//	strBeanFmtCompIdSrlNo = strBeanFmtCompIdSrlNo.trim();

	templateBean.setStatus(currentCompIdSrlNo,compItemId,hashmap);
	//added later for refreshing with update items in the list as checkbox was not comming clicked due to no data in setStatusEDWhenList
	templateBean.setStatusEDWhenList(currentCompIdSrlNo,compItemId,"false");		
	putObjectInBean("templateBean",templateBean,session);
	hashmap = null;
%>
<script>
parent.window.close();
</script>

