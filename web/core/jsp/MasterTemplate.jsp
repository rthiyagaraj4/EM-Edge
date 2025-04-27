<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" %>
<jsp:directive.page import="com.iba.framework.core.vo.UserPreferences"/>
<jsp:directive.page import="com.iba.framework.cache.pojo.business.Cache"/>
<jsp:directive.page import="com.iba.framework.cache.pojo.business.CacheManager"/>
<jsp:directive.page import="com.iba.framework.core.util.Constants"/>
<%@ include file="/framework/html/Tag.text"%>
<script>
	var functionId= '<%=request.getParameter("function_id")%>'
</script>

		<ibaTiles:useAttribute name="toolbar"  id="toolbar" classname="String"/>
		<ibaTiles:useAttribute name="content"  id="content" classname="String"/>
		<ibaTiles:useAttribute name="messageFrame" id="messageFrame" classname="String"/>
		
		<%
			toolbar=toolbar+"?"+request.getQueryString();
			String languageId = (String) session.getAttribute("LOCALE");
			String functionId=(String)session.getAttribute("functionId");
			String moduleId=(String)session.getAttribute("moduleId");
			String facilityId=(String)session.getAttribute("facility_id");
			
			UserPreferences userPrefs =new UserPreferences();
			userPrefs.setDateFormat("dd/MM/yyyy") ;
			userPrefs.setTimeFormat("HH:mm");
			userPrefs.setLocale(languageId);
			try{
			/* Cache cache = CacheManager.getCache();
			cache.putObject(Constants.USER_SESSION_CACHE, request.getSession().getId(),  Constants.USER_PREFS,userPrefs); */	//Commented Against AMRI-SCF-0679
			
			}catch(Exception ex){}
	
			
		%>		
    <frameset rows="10%,*,10%" frameborder="no" framespacing="0">
	<ibaHTML:frame frameName="commontoolbarFrame" href="<%=toolbar%>" scrolling='no' noresize="true" />
	<ibaHTML:frame frameName="content" href="<%=content%>"  noresize="true" />
	<ibaHTML:frame frameName="messageFrame" href="<%=messageFrame%>"  noresize="true" /> 
	</frameset>
	



