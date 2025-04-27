<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	session.putValue("desktopUser","Y");

	String button_name = request.getParameter("button_name")==null?"":request.getParameter("button_name");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/common.js'></script>	


	<script>
			
			if('<%=button_name%>' == "menu") {			
				var expandState = 0;
			} else {
				var expandState = 1;	
			}
			
			
			function expand(buttObj,type,module_id) {		
			
				if(expandState == 0) {				

					if(buttObj != null)	{
						
						if(type =="button")
						{
							buttObj.value='<fmt:message key="Common.hideMenu.label" bundle="${common_labels}"/>';
							
						}
						else
						{
							buttObj.innerText='<fmt:message key="Common.hideMenu.label" bundle="${common_labels}"/>'
							
						}
						
					}		
					
					parent.parent.contentFrameset.cols='200px,*';	
					//parent.parent.contentFrameset.rows='0%';
					//parent.parent.menucontent.location.href = "../../eCommon/jsp/UserDesktop.jsp?step=1";		
					expandState = 1;
					
				} else {					

 					if(buttObj != null)	{
						if(type =="button") {

							if(module_id=="ca") {
								buttObj.value='<fmt:message key="Common.showMenu.label" bundle="${common_labels}"/>'
							} else {
								buttObj.value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>'
							}

						} else {
								buttObj.innerText='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>'
							
						}
					}

						parent.parent.contentFrameset.cols='0%,*';
						//parent.parent.contentFrameset.rows='0%,*';
						//parent.parent.menucontent.location.href = "../../eCommon/jsp/UserDesktop.jsp?step=2";	
						expandState = 0;					
						
					}				
			} 

	</script>

<html>
<title> iSOFT </title>

		    <iframe name='Options1' id='Options1' src='../../eCommon/jsp/UserDeskTopSummary.jsp' frameborder='0'  scrolling='no' noresize style='height:2.8vh;width:100vw'>
				 <iframe name='Options2' id='Options2' src='../../eCommon/jsp/Tree.jsp' frameborder='0'  SCROLLING='no' noresize style='height:97.2vh;width:100vw'>
				 <iframe name='personalize' id='personalize'  frameborder="0" src='../../eCommon/html/blank.html'  scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>
			    	
	
</html>

