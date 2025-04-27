<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page import="eSS.PhyInvEntryBean" %>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/PhyInvEntry.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	</head>	
	<%
		String bean_id				=			"phyInvEntryBean";
		String bean_name			=			"eSS.PhyInvEntryBean";
		String mode					=			request.getParameter("mode");
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		
		String phy_inv_id			=			request.getParameter("phy_inv_id");
		String owner_store_code		=			request.getParameter("owner_store_code");
		String current_store_code	=			request.getParameter("current_store_code");

		PhyInvEntryBean phyInvEntryBean = (PhyInvEntryBean) getBeanObject( bean_id, bean_name,request );  
		phyInvEntryBean.clear();

		phyInvEntryBean.setMode(mode.trim());
		phyInvEntryBean.setFunctionId(phyInvEntryBean.checkForNull(request.getParameter("function_id")));
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			
			phyInvEntryBean.setPhy_inv_id(phy_inv_id.trim());
			phyInvEntryBean.setStore_code(owner_store_code);
			phyInvEntryBean.setCurr_store_code(current_store_code);
			phyInvEntryBean.loadData();
		}

putObjectInBean(bean_id,phyInvEntryBean,request);
	%>
	<frameset rows='75,*'>
		<frame name='PhyInvEntryHeaderFrame' src="../../eSS/jsp/PhyInvEntryHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
 		<frameset cols="40%,*" >
			<frame name='PhyInvEntryDetailFrame' src="../../eSS/jsp/PhyInvEntryDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
			<frameset rows="15,*">
				<frame name='PhyInvEntryListHeaderFrame' src="../../eSS/html/PhyInvEntryListHeader.html" frameborder=0 scrolling='no'   noresize>
				<frame name='PhyInvEntryListFrame' src="../../eSS/jsp/PhyInvEntryList.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize>
			</frameset>
		</frameset>
	</frameset>
</html>
