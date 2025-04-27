<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eOR.InstructionbyAgeSex.label" bundle="${or_labels}"/></title>


<% request.setCharacterEncoding("UTF-8");%>
</head>


<iframe name='instr_byAge_modal_result' id='instr_byAge_modal_result' src='../../eOR/jsp/OrderCatalogInstructionByAgeResult.jsp?' frameborder=0 scrolling='auto' style='height:73vh;width:98vw'></iframe>
<iframe name='instr_byAge_modal_addmodify' id='instr_byAge_modal_addmodify'	src='../../eOR/jsp/OrderCatalogInstructionByAgeAddModify.jsp' frameborder=0 noresize scrolling='no' style='height:28vh;width:98vw'></iframe>

</html>

