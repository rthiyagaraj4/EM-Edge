<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<jsp:directive.page import="com.iba.framework.core.vo.UserPreferences"/>
<jsp:directive.page import="com.iba.framework.cache.pojo.business.Cache"/>
<jsp:directive.page import="com.iba.framework.cache.pojo.business.CacheManager"/>
<jsp:directive.page import="com.iba.framework.core.util.Constants"/>
<%@ include file="/framework/html/Tag.text"%>

		<ibaTiles:useAttribute name="lclaundrytoolbar" classname="String"/>
		<ibaTiles:useAttribute name="content" classname="String"/>
		<ibaTiles:useAttribute name="messageFrame" classname="String"/>
		<%
			String languageId = (String) session.getAttribute("LOCALE");
			UserPreferences userPrefs =new UserPreferences();
			userPrefs.setDateFormat("dd/MM/yyyy") ;
  			userPrefs.setTimeFormat("HH:mm");
			userPrefs.setLocale(languageId);

			/* Cache cache = CacheManager.getCache();
			cache.putObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS,userPrefs); */ //AMRI-SCF-0679
			
		%>
		 
	<frameset rows="19%,*,10%" frameborder="0" framespacing="0">
	<ibaHTML:frame frameName="lclaundrytoolbar" href="<%=lclaundrytoolbar%>" noresize="true" scrolling="no"/>
	<ibaHTML:frame frameName="content" href="<%=content%>"  noresize="true" />
	<ibaHTML:frame frameName="messageFrame" href="<%=messageFrame%>"  noresize="true" scrolling="no"/> 

</frameset>



