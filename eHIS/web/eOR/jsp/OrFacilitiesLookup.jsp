<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History    Name       	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------------------
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015 - Comments : Created this file
-------------------------------------------------------------------------------------------------------------------------------
*/
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.Common.OrderEntryRecordBean"%>
<%@page import="eOR.Common.OrAdapter"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,eCommon.Common.*,eOR.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
    <head>
        <title><fmt:message key="eOR.Facilities.label" bundle="${or_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	
	String function_id = request.getParameter("funcion_id")==null?"":request.getParameter("funcion_id");
	String bean_id = request.getParameter("bean_id")==null?"":request.getParameter("bean_id");//"Or_OrderCatalog";
	String bean_name = request.getParameter("bean_name")==null?"":request.getParameter("bean_name");//"eOR.OrderCatalogBean";
	
	OrAdapter bean = null;
	bean = (OrAdapter) getBeanObject(bean_id,bean_name, request);
	System.out.println("62=>"+bean.getFunctionId());
	
	
	String l_func_id = bean.getFunctionId();
	String l_mode = bean.checkForNull(request.getParameter("mode"));
	String l_disable = "";
	System.out.println("67,l_mode=>"+l_mode+",l_func_id=>"+l_func_id);
	
	//if(Integer.parseInt(l_mode) == 2 && ("OR_ORDER_MASTER".equals(l_func_id)||"OR_ORDER_SET".equals(l_func_id)))
		//l_disable = "disabled";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/OrCommonFunction.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<table align='center' cellpadding=3 cellspacing=0 border='0' width='100%' class='grid'>
			<tr>
				<td class="columnheader" align='center'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td class="columnheader" align='center'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> <input type='checkbox' name='includeAll' id='includeAll' <%=l_disable%> onclick='includeAllFacilities(this)'/></td>
			</tr>
		</table>
		<div style='width:640px;height:400px'>
			<div style='width:640px;height:400px;overflow:auto'>
				<table width='100%' align='center width='100%' class='grid''>
				
<%
	ArrayList<String[]> facilities = bean.getFacilitiesForMapping();
	int facSize = facilities.size();

	try 
	{
		if (facSize > 0) 
		{
			for (int i = 0; i < facSize; i++) 
			{
				String records[] = facilities.get(i);
%>
				<tr>
					<td class="gridData"><%=records[0]%></td>
					<td class="gridData"><input type='checkbox' <%=l_disable%> onclick= 'includeIndividualFac(this)' name='facility<%=i%>' value = '<%=records[1]%>' <%=(bean.getMappedFacilities().contains(records[1]))?"checked":""%>/></td>
				</tr>
		<%
			}
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
%>
	 		</table>
	 			</div>
	 				</div>
	 	<input type='hidden' name='noOfRec' id='noOfRec' value ='<%=facSize%>'/>
	 	<input type='hidden' name='noOfMappedFac' id='noOfMappedFac' value ='<%=bean.getMappedFacilities().size()%>'/>
	 	<input type='hidden' name='bean_id' id='bean_id' value ='<%=bean_id%>'/>
	 	<input type='hidden' name='bean_name' id='bean_name' value ='<%=bean_name%>'/>
		<div align='right'>
			<table  cellpadding='0' cellspacing='0' >
				<tr>
					<td>
					<input type='button' name='close' id='close' <%=l_disable%> value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='includeFacilites()' class='button'> &nbsp; <input type='button' name='close' id='close' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='window.close()' class='button'>	
					</td>
				</tr>
			</table>	
		</div>
		<script>
		defaultSelectAll();
		</script>
	 </body>
</html>

