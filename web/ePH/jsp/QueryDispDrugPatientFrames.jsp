<!DOCTYPE html>
  <!--This file is saved on 28/10/2005-->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/QueryPresVsDispDrug.js"></script> 
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               
<iframe name="f_queryCriteria" id="f_queryCriteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/QueryDispDrugPatientCriteria.jsp" style="height:14vh;width:98vw"></iframe><iframe name="f_orderframe" id="f_orderframe" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:86vh;width:98vw"></iframe>
</html>	

