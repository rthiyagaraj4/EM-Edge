<!DOCTYPE html>
<%@page  import=" eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<!--<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eXH/js/DispenseItemMachineCodes.js"></script>
	<!--<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<%


		String bean_id						=			"itemForStoreBean";
		String bean_name					=			"eST.ItemForStoreBean";
		String checked						=			"checked";
		String disabled						=			"";
		String className					=			"";
		ArrayList alItemKeys				=			null;
		ArrayList duplicateValues			=			null;
		HashMap hmItemStore					=			null;
		String selectCheck					= "";
		String mode							=			request.getParameter("mode");
		String function_id					=			request.getParameter("function_id");
		String mainModule_id	            =           request.getParameter("module_id") ;
		String facility_id                  =           request.getParameter("facility_id") ;
		String disp_locn                    =           request.getParameter("disp_locn") ;
		String machine                      =           request.getParameter("machine") ;
		String item                         =           request.getParameter("item") ;
		String rowCount= "";
		rowCount = request.getParameter("hid_facility_id") ;
		
		int i								=			0;

		%>
	<body onMouseDown='CodeArrest();'>
		<form name='formDispItemsForMachineCodesList' id='formDispItemsForMachineCodesList' id="formDispItemsForMachineCodesList" method="post" action="../../servlet/eXH.XHDispItemsForMachineCodeServlet">
			<table name ="dispItemsMachineCodesListTable" id="dispItemsMachineCodesListTable" border='1' cellpadding=0  cellspacing='0' width='100%'>
 			<tr>
				
				<td class='columnheader'>
					<fmt:message key="eXH.FacilityID.label" bundle="${xh_labels}"/>
				</td>
				<td class='columnheader'>
					<fmt:message key="eXH.DispLocnCode.label" bundle="${xh_labels}"/>
				</td>
				<td class='columnheader'>
					<fmt:message key="eXH.Machine.label" bundle="${xh_labels}"/>
				</td>
				<td class='columnheader'>
					<fmt:message key="eXH.item.label" bundle="${xh_labels}"/>
				</td>
				<td class='columnheader'>
					<fmt:message key="eXH.HighAlertDrugYN.label" bundle="${xh_labels}"/>
				</td>
				<td class='columnheader'>
					<fmt:message key="eXH.PackOnlyExpensiveDrugYN.label" bundle="${xh_labels}"/>
				</td>
				<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				
			</tr>
			
			</table>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"			value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
						<input type="hidden" name="facility_id" id="facility_id"					value="<%=facility_id%>">
					
			<input type=hidden   name='locale' id='locale'                      value='<%=locale%>'>
		</form>

	</body>
</html>

