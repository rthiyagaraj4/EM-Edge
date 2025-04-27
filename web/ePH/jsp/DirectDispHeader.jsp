<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedicationAllStages.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</HEAD>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="DispMedicationAllocateDrugsTitle" id="DispMedicationAllocateDrugsTitle">
<% 
			String	bean_id				=	"DispMedicationAllStages" ;
			String	bean_name			=	"ePH.DispMedicationAllStages";
				
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject(bean_id,bean_name,request) ;
			//bean.setLanguageId(locale);
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";

			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject(bean_id_1,bean_name_1,request);
			bean_1.setLanguageId(locale);
			Hashtable legend			=	bean_1.getLegendsFromParam();
			String title				=	"";

			if(legend.containsKey("A"))
				title	=	(String)legend.get("A");

			String module_id	=	bean.getModuleId(); 
			if(module_id.equals("1")) { 
%>
				<table cellpadding="0" cellspacing="0" width="97%" align="left" border="1">
					<tr>
						<th style="font-size:9" width="50%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
						<th style="font-size:9" width="25%"><%=title%> <fmt:message key="Common.Qty.label" bundle="${common_labels}"/> </th>
						<th style="font-size:9" width="25%"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/>  </th>
					</tr>
				</table>
<%	
			}
			else{	
%>
				<table cellpadding="0" cellspacing="0" width="97%" align="left" border="1">
					<tr>
						<th style="font-size:9" width="68%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
						<th style="font-size:9" width="14%"><%=title%><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>  </th>
						<th style="font-size:9" width="18%"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></th>
					</tr>
				</table>

<%	
			}
%>
		</form>
<% 
		//putObjectInBean(bean_id,bean,request); 
		putObjectInBean(bean_id_1,bean_1,request); 
%>
	</body>
</html>

