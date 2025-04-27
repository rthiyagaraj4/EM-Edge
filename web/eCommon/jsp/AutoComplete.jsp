<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" pageEncoding="ISO-8859-1" import="java.util.*,com.iba.framework.cache.pojo.business.Cache,
com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%

String key="";
Cache cache = CacheManager.getCache();
			if(request.getParameter("inputId") != null){
			key="AutoList"+request.getParameter("inputId");
			
			ArrayList cacheList=new ArrayList();
			if(! (cache.exists(Constants.USER_SESSION_CACHE, key)))
			{
			 cache.putObject(Constants.USER_SESSION_CACHE, key, cacheList);
			}
			cacheList = (ArrayList) cache.getObject(Constants.USER_SESSION_CACHE, key);
			if (request.getParameter("enteredValue") != null) {
			if(!cacheList.contains(request.getParameter("enteredValue"))){
					cacheList.add(request.getParameter("enteredValue"));
					}
					cache.putObject(Constants.USER_SESSION_CACHE, key,
							cacheList);
				}
				}
%>
<html>
  <head>
    
  </head>


  
  <body onKeyDown = 'lockKey()'>
  
    This is my JSP page. <br>
  </body>
</html>

