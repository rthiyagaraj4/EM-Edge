<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*,java.sql.Connection,  java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<html>
<head>
<%
//Added by MuthuN for CRF-268 PicklistBean for CSSD Transaction 
	String pick_bean_id 			=	"OTPickListBean";
	String pick_bean_name 			=	"eOT.OTPickListBean";	
	OTPickListBean picklist_bean	=	(OTPickListBean)getBeanObject( pick_bean_id, pick_bean_name, request );
	picklist_bean.setPickList(null);
%>
</head>
</html>
