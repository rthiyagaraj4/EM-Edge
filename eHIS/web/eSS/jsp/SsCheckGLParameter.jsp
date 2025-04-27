<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import=" eSS.*, eSS.Common.* , eCommon.Common.*" %>
<script language='javascript' src='../../eSS/js/SsMessages.js'></script>
<%
	String bean_id = "ssTransaction";
	String bean_name = "eSS.Common.SsTransaction";
	SsTransaction bean = (SsTransaction)getBeanObject( bean_id, bean_name, request ) ;
	
//	SsTransaction bean = (SsTransaction)mh.getBeanObject( "ssTransaction", request,  "eSS.Common.SsTransaction");
	bean.setAccEntityId((String)session.getAttribute("ACC_ENTITY_ID"));
	if(!bean.hasGLParameter()) {
%>
		<script language="javascript">
			alert(getMessage("SS_NOT_INTRFCD_WTH_GL"));	
			history.go(-1);
		</script>
<%
	}
	bean = null;
%>
<% putObjectInBean(bean_id,bean,request);%>

