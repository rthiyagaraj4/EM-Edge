<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,org.springframework.context.*,org.springframework.beans.factory.*,org.springframework.web.context.support.*,net.sf.ehcache.*" %>
<%!
	private static transient BeanFactory beanFactory;
	private static transient Cache httpSessionCache;
	private static transient Cache messageCache;
	private static transient Cache labelCache;
%>
<%
	String cacheName = request.getParameter("cacheName"); 
	
	if (beanFactory == null){
		ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		beanFactory = (BeanFactory)appCtx;
		httpSessionCache =  (Cache)beanFactory.getBean("httpSessionCache");	
		labelCache =  (Cache)beanFactory.getBean("labelCache");		
		messageCache =  (Cache)beanFactory.getBean("messageCache");		
	}
	
	Cache cache = null;
	if(cacheName.equalsIgnoreCase("http.session.cache")){
		cache = httpSessionCache;
	}else if(cacheName.equalsIgnoreCase("label.cache")){
		cache = labelCache;
	}else if(cacheName.equalsIgnoreCase("message.cache")){
		cache = messageCache;
	}
		
	Statistics statistics = cache.getStatistics();

	List keyList = cache.getKeysWithExpiryCheck();
	
%>	
		<table>
			<th colspan=2 align=center>Details As On&nbsp;&nbsp;<%=new java.util.Date()%></th>
			<tr>
				<td>
					<table>
						<th colspan=2>
							Cache Details
						</th>
						<tr>
							<td><b>Cache Name&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().getName()%></td>	
						</tr>
						<tr>
							<td><b>Cache maxElementsInMemory&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().getMaxElementsInMemory()%></td>	
						</tr>
						<tr>
							<td><b>Cache maxElementsOnDisk&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().getMaxElementsOnDisk()%></td>	
						</tr>
						<tr>
							<td><b>Cache eternal&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().isEternal()%></td>	
						</tr>
						<tr>
							<td><b>Cache overflowToDisk&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().isOverflowToDisk()%></td>	
						</tr>
						<tr>
							<td><b>Cache timeToIdleSeconds&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().getTimeToIdleSeconds()%></td>	
						</tr>
						<tr>
							<td><b>Cache timeToLiveSeconds&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().getTimeToLiveSeconds()%></td>	
						</tr>
						<tr>
							<td><b>Cache diskPersistent&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().isDiskPersistent()%></td>	
						</tr>
						<tr>
							<td><b>Cache diskExpiryThreadIntervalSeconds&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().getDiskExpiryThreadIntervalSeconds()%></td>	
						</tr>
						<tr>
							<td><b>Cache memoryStoreEvictionPolicy&nbsp;&nbsp;</b></td>
							<td><%=cache.getCacheConfiguration().getMemoryStoreEvictionPolicy()%></td>	
						</tr>
						<tr>
							<td><b>Cache inMemorySize&nbsp;&nbsp;</b></td>
							<td><%=cache.calculateInMemorySize()+" in bytes"%></td>	
						</tr>			
						<tr>
							<td><b>Cache memoryStoreSize&nbsp;&nbsp;</b></td>
							<td><%=cache.getMemoryStoreSize()%></td>	
						</tr>
						<tr>
							<td><b>Cache diskStoreSize&nbsp;&nbsp;</b></td>
							<td><%=cache.getDiskStoreSize()%></td>	
						</tr>
					</table>
				</td>
				<td>
					<table>
						<th colspan=2>
							Cache Statistics
						</th>
						<tr>
							<td><b>Associated Cache Name&nbsp;&nbsp;</b></td>
							<td><%=statistics.getAssociatedCacheName()%></td>	
						</tr>
						<tr>
							<td><b>Cache Hits&nbsp;&nbsp;</b></td>
							<td><%=statistics.getCacheHits()%></td>	
						</tr>
						<tr>
							<td><b>Cache Misses&nbsp;&nbsp;</b></td>
							<td><%=statistics.getCacheMisses()%></td>	
						</tr>
						<tr>
							<td><b>Cache inMemoryHits&nbsp;&nbsp;</b></td>
							<td><%=statistics.getInMemoryHits()%></td>	
						</tr>
						<tr>
							<td><b>Cache onDiskHits&nbsp;&nbsp;</b></td>
							<td><%=statistics.getOnDiskHits()%></td>	
						</tr>
						<tr>
							<td><b>Cache objectCount&nbsp;&nbsp;</b></td>
							<td><%=statistics.getObjectCount()%></td>	
						</tr>
						<tr><td colspan=2>&nbsp;</td></tr>
						<tr><td colspan=2>&nbsp;</td></tr>
						<tr><td colspan=2>&nbsp;</td></tr>
						<tr><td colspan=2>&nbsp;</td></tr>
						<tr><td colspan=2>&nbsp;</td></tr>
						<tr><td colspan=2>&nbsp;</td></tr>
						<tr><td colspan=2>&nbsp;</td></tr>
					</table>
				</td>
			</tr>
		</table> 
		<br />
		<table>
			<th colspan=2 align=center>Cache Contents (Valid, Non-expired Keys)</th>
			<% for(int j=0;j<keyList.size();j++){%>
			<tr>
				<td><%=(j+1)%></td><td><%=keyList.get(j).toString()%></td>
			</tr>
			<% } %>
		</table>
		
