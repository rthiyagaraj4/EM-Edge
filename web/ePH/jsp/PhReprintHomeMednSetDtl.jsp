<!DOCTYPE html>
 <!--  Author 	:	Arun M (157457)
Module name 	:	ePH
Function 	:	RePrint for Home Medication Summary-->
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhReprintHomeMdn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" style="overflow-x:hidden;overflow-y:scroll">
<%
	
	String bean_id 			= "PhReprintHomeMednBean";
	String bean_name 		= "ePH.PhReprintHomeMednBean";
	String item_desc		=	request.getParameter("item_desc")==null?"":request.getParameter("item_desc").toString();
	String instruction		=	request.getParameter("instruction")==null?"":request.getParameter("instruction").toString();
	String qty_value		=	request.getParameter("qty_value")==null?"":request.getParameter("qty_value").toString();

	PhReprintHomeMednBean bean = (PhReprintHomeMednBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	ArrayList	AddDtlRec	=	bean.getDuplicateDtlRec();
%>

<form name="PhReprintHomeMednSetDtlform" id="PhReprintHomeMednSetDtlform" >
 <div style="overflow:scroll;height:80px;width:100%;overflow:auto">
	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="MednSetDetailTable"  scrolling="auto" >
		<tr>
			<th class="border" width="25%"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </th>
			<th class="border" width="15%"><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></th>
			<th class="border" width="10%" ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th class="border" width="10%"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
		</tr>
		<%for(int i=0;i<AddDtlRec.size();i++){
		    String setDtlRec=AddDtlRec.get(i).toString();
		    String[] DtlRecDelimit=setDtlRec.split("/");
			%>
		<tr id='addmodifydtl' onscroll="auto"> 
		<%for(int j=0;j<DtlRecDelimit.length;j++){%> 
			<td  class="label" align="center"><%=DtlRecDelimit[0]%></td>
			<td  class="label" align="center"><%=DtlRecDelimit[1]%></td>
			<td  class="label" align="center"><%=DtlRecDelimit[2]%></td>
			<td align="center"><input type="checkbox" name="selected" id="selected" value="E" onclick="checkPatientselect()" ></td><!--Added Onclick Function for RUT-SCF-0384[IN46988]-->
			<%break;} %>
		</tr>
		<%} %>
	</table>
	</div>
	<table cellpadding=0 cellspacing=0 width="100%" align="right" border="0">
	<tr>
	<td align="right" width="95%">
			<input type="button" name="btnView" id="btnView" value='<fmt:message key="Common.view.label" bundle="${common_labels}"/>' class="button" onClick="viewReport(this)" >
	</td>
			<td align="right">
			<input type="button" name="btnPrint" id="btnPrint" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' class="button" onClick="printReport()" >
		</td>
		</tr>
	</table>
	
	<input type="hidden" name="number_of_rows" id="number_of_rows" value="">
	<input type="hidden" name="p_patient_id" id="p_patient_id" value=""><!--Added for RUT-SCF-0384[IN46988]-->
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

