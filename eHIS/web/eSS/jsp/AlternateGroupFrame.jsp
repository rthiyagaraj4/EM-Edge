<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.*,eSS.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle			=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	<jsp:useBean id="alAlternateGroupList" scope="session" class="java.util.ArrayList"/>
<%
	String bean_id = "alternateGroupListBean";
	String bean_name = "eSS.AlternateGroupListBean";
	alAlternateGroupList.clear();
	AlternateGroupListBean bean = (AlternateGroupListBean) getBeanObject(bean_id, bean_name, request  );

	String group_code				=	request.getParameter("group_code");
	ArrayList alAlternateGroupRecords	=	null;
	int i	=0;
	
	if( group_code!=null )
	{
		try{
			alAlternateGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT_DETAIL"),group_code);
			for (i=0;i<alAlternateGroupRecords.size();i++){
				HashMap hmAlternateGroupRecord=(HashMap)alAlternateGroupRecords.get(i);
				hmAlternateGroupRecord.put("alternate_group_code",	(String)hmAlternateGroupRecord.get("ALTERNATE_GROUP_CODE") );
				hmAlternateGroupRecord.put("description",			(String)hmAlternateGroupRecord.get("SHORT_DESC"));
				hmAlternateGroupRecord.put("mode",					eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmAlternateGroupRecord.remove("ALTERNATE_GROUP_CODE") ;
				hmAlternateGroupRecord.remove("SHORT_DESC");
				alAlternateGroupList.add(hmAlternateGroupRecord);
			}
		}
		catch(Exception e){
			// out.print(exception);
			e.printStackTrace(); // COMMON-ICN-0185
		}
	}
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eSS/js/AlternateGroup.js'></script>
<script language='javascript' src='../../eSS/js/SsTransaction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameAlternateGroup' id='frameAlternateGroup' src='../../eSS/jsp/AlternateGroupAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:20%;width:100vw'></iframe>
	<iframe name='frameAlternateGroupDetail' id='frameAlternateGroupDetail' frameborder="0" scrolling="no" noresize src='../../eCommon/html/blank.html'  style='height:100vh;width:100vw'></iframe>
</html>

