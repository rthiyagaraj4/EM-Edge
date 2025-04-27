<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src='../js/CommonPolicyTabChangeFrame.js'></script> 
	<script language="javascript" src='../js/CommonPolicyDefinition.js'></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
				<li class="tablistitem" title='<fmt:message key="eBL.PolicyInclExclCoverage.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('inclExclCoverage')" class="tabClicked" id="inclExclCoverage">
					<span class="tabSpanclicked" id="inclExclCoveragespan">
						<fmt:message key="eBL.PolicyInclExclCoverage.label" bundle="${bl_labels}"/>
						</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eBL.PreApprovalDetails.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('preApproval')" class="tabA" id="preApproval" >
					<span class="tabAspan" id="preApprovalspan">					
					<fmt:message key="eBL.PreApprovalDetails.label" bundle="${bl_labels}"/>					
					</span></a>
			</li>
			<li>
				<a id="resizeLink" href='javascript:resizeFrames()' style="visibility: visible;"><img id="resizeBtn" alt="" src="../../eOT/images/ShowLess.gif" style="visibility: visible;"> </a>
				<a id="resetLink" href='javascript:resetFrames()' style="visibility: hidden;"><img id="resetBtn" alt="" src="../../eOT/images/ShowMore.gif" style="visibility: hidden;"></a>
			</li>
		</ul>
	</td>	
	</tr>
</table>

</body>
</html>

