<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,org.springframework.beans.factory.*,org.springframework.context.*,org.springframework.web.context.support.*,net.sf.ehcache.*" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%!
	private static transient BeanFactory beanFactory;
	private static transient Cache httpSessionCache;
	private static transient Cache messageCache;
	private static transient Cache labelCache;
	private static transient CacheManager cacheManager;
%>
<%

	if (beanFactory == null){
		ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		beanFactory = (BeanFactory)appCtx;
		cacheManager = (CacheManager)beanFactory.getBean("ehCacheManager");
		
		httpSessionCache =  (Cache)beanFactory.getBean("httpSessionCache");	
		labelCache =  (Cache)beanFactory.getBean("labelCache");		
		messageCache =  (Cache)beanFactory.getBean("messageCache");		
	}

	/*String[]cacheNames = cacheManager.getCacheNames();
	*/
	

	Statistics sessionStatistics = httpSessionCache.getStatistics();
	Statistics labelStatistics = labelCache.getStatistics();
	Statistics messageStatistics = messageCache.getStatistics();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title> EHCache Details for IBA-EHIS </title>
		<meta name="generator" content="editplus" />
		<meta name="author" content="" />
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<script type="text/javascript">
			
			function getXHR(){
				var request = false;
				try {
					request = new XMLHttpRequest();
				}catch (trymicrosoft) {
					try {
						request = new ActiveXObject("Msxml2.XMLHTTP");
					}catch (othermicrosoft) {
						try {
							request = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (failed) {
							request = false;
						}
					}
				}
				if (!request){
					alert("System Error initializing XMLHttpRequest!");
					return;
				}else return request;
			}


			function showDetails(cache){
				var xhr =  getXHR();
				var url = "../../eCommon/jsp/CacheInnerDetails.jsp?cacheName="+cache;
				xhr.open("POST", url, false);
				xhr.setRequestHeader("Content-Type","text/html")
				xhr.send("");
				var resText = xhr.responseText;
				var t = document.getElementsByTagName("DIV");
				for(j=0;j<t.length;j++){					
					if (t[j].id == 'DetailsTable') {						
						t[j].innerHTML = resText; 
					}
				}				
			}
		</script>
	</head>
	<body onKeyDown = 'lockKey()'>
		<table id="MainTable">
			<tr>
				<td><b>Cache Name&nbsp;&nbsp;</b></td>
				<td><b>Statistics&nbsp;&nbsp;</b></td>
				<td><b>Contents&nbsp;&nbsp;</b></td>
			</tr>
			<tr>
				<td><b>Http Session Cache&nbsp;&nbsp;</b></td>
				<td><%=sessionStatistics.toString()%>&nbsp;&nbsp;</td>
				<td><a href="javascript:showDetails('http.session.cache')"><b>Contents</b></a></td>
			</tr>
			<tr>
				<td><b>Label Cache&nbsp;&nbsp;</b></td>
				<td><%=labelStatistics.toString()%>&nbsp;&nbsp;</td>
				<td><a href="javascript:showDetails('label.cache')"><b>Contents</b></a></td>
			</tr>
			<tr>
				<td><b>Message Cache&nbsp;&nbsp;</b></td>
				<td><%=messageStatistics.toString()%>&nbsp;&nbsp;</td>
				<td><a href="javascript:showDetails('message.cache')"><b>Contents</b></a></td>
			</tr>
		</table>		
		<div id="DetailsTable">			
		</div>
	</body>
</html>

