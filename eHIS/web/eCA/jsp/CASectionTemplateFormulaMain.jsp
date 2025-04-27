<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%  
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String qs=request.getQueryString();
	String formulaResultType=request.getParameter("formulaResultType")==null?"":request.getParameter("formulaResultType");
	String includeDates				=request.getParameter("includeDates");	
%>
<script>
	//alert('formulaResultType-><%=formulaResultType%>===includeDates--><%=includeDates%>');
</script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<head>
	<title>Formula Definition</title>
</head>
<%if(formulaResultType.equals("N") && includeDates.equals("N"))
{%>
	<iframe name='templateFormulaComponentListFrame' id='templateFormulaComponentListFrame' src='../../eCA/jsp/CASectionTemplateFormulaComponentList.jsp?<%=qs%>' frameborder="no" scrolling="auto" noresize style='height:40vh;width:100vw'></iframe>
		<iframe name='templateFormulaConstructionFrame' id='templateFormulaConstructionFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling="auto" noresize style='height:52vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder="no" scrolling="auto" noresize style='height:5vhs;width:100vw'></iframe>
	
<%}else{%>
	<iframe name='templateFormulaComponentListFrame' id='templateFormulaComponentListFrame' src='../../eCA/jsp/CASectionTemplateDateComponent.jsp?<%=qs%>' frameborder="no" scrolling="auto" noresize style='height:85vh;width:100vw'></iframe>		
		<iframe name='templateFormulaComponentToolbarFrame' id='templateFormulaComponentToolbarFrame' src='../../eCA/jsp/CASectionTemplateDateComponentToolbar.jsp?<%=qs%>' frameborder="no" scrolling="no" noresize style='height:5vh;width:100vw'></iframe>
			
<%}%>

