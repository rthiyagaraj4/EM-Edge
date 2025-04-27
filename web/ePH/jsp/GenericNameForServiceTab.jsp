<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!-- 
Developed by	: Surendra Reddy.
Module/Function : Generic Name for Service (Master)
-->
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>


<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="genericnameforservice_tab" id="genericnameforservice_tab">
	<table border="0" width="100%" cellspacing="0" cellpadding="0">
		<tr>
		 <td   class="white">
        <ul id="tablist" class="tablist" >
			<li class="tablistitem" title='<fmt:message key="ePH.ByGenericName.label" bundle="${ph_labels}"/>'>
			<a onclick="tab_click1('Bygenericname_tab')" class="tabClicked" id="Bygenericname_tab" >
				<span class="tabSpanclicked" id="Bygenericname_tabspan"><fmt:message key="ePH.ByGenericName.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="ePH.ByService.label" bundle="${ph_labels}"/>'>
			<a onclick="tab_click2('ByService_tab')" class="tabA" id="ByService_tab" >
                 <span class="tabAspan" id="ByService_tabspan"><fmt:message key="ePH.ByService.label" bundle="${ph_labels}"/></span>
			</a>
			</li>
           </ul>
		   </td>
		</tr>
	</table>
</form>
</body>

</html>

