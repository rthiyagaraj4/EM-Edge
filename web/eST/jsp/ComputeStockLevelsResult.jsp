<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*, java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/ComputeStockLevels.js'></script> 
		<!-- <script language='javascript' src='../../eST/js/MonthlySummaryReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	<style type="text/css">
	.NOBORDER{
		border:1;
		border-width: 1;
		border-style: solid;
		text-align: right;
	}
	</style>
	</head>
	<body onunload="updateItemDetails();">
	<form name="formComputeStockLevelsResult" id="formComputeStockLevelsResult">
	<%


		String bean_id						=	"computeStockLevelsBean";
		String bean_name					=	"eST.ComputeStockLevelsBean";

		eST.ComputeStockLevelsBean bean		=	(eST.ComputeStockLevelsBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

		String consumption_period			=		bean.checkForNull(request.getParameter("consumption_period"));
//		String language_id					=		bean.checkForNull(request.getParameter("language_id"));
		String fm_to_item_class_code		=		bean.checkForNull(request.getParameter("fm_item_code"),"!");
		String to_to_item_class_code		=		bean.checkForNull(request.getParameter("to_item_code"),"~");
		String fm_item_class_code			=		bean.checkForNull(request.getParameter("fm_item_class_code"),"!");
		String to_item_class_code			=		bean.checkForNull(request.getParameter("to_item_class_code"),"~");
		String excludeexternalstores		=		bean.checkForNull(request.getParameter("excludeexternalstores"),"");

		boolean searched					=		(request.getParameter("searched") == null) ?false:true;

		String classvalue					=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));

			HashMap sqlMap					=		new HashMap();
			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_FOR_CALCULATE_STOCK_LEVELS"));

			HashMap funcMap					=		new HashMap();
			ArrayList displayFields			=		new ArrayList();

			displayFields.add("ITEM_CODE");
			displayFields.add("ITEM_DESC");
			displayFields.add("MIN_STK_QTY");
			displayFields.add("MAX_STK_QTY");
			displayFields.add("REORDER_LEVEL");
			displayFields.add("REORDER_QTY");
			displayFields.add("QTY_ON_HAND");

			ArrayList chkFields				=		new ArrayList();
			chkFields.add(consumption_period);
			chkFields.add(fm_to_item_class_code);
			chkFields.add(to_to_item_class_code);
			chkFields.add(fm_to_item_class_code);
			chkFields.add(to_to_item_class_code);
			chkFields.add(fm_item_class_code);
			chkFields.add(to_item_class_code);
			chkFields.add(consumption_period);
			chkFields.add(excludeexternalstores);
			chkFields.add(locale);

		// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){

		
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
				<tr>
					<th rowspan=2><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type="checkbox" name="checkAll" id="checkAll" value="" onClick="toggleCheck(formComputeStockLevelsResult);" checked></th>
					<th rowspan=2><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
					<th rowspan=2><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>

					<th colspan='4'>-- <fmt:message key="eST.ComputedDetails.label" bundle="${st_labels}"/>  --</th>
					<th colspan='4'>-- <fmt:message key="eST.OldDetails.label" bundle="${st_labels}"/>  --</th>
				</tr>		
				<tr>
					<th><fmt:message key="eST.MinStock.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.ROQuantity.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.MinStock.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.ROQuantity.label" bundle="${st_labels}"/></th>
				</tr>		
		<%
			ArrayList records				=		null;
			HashMap hmCalculatedItemDetails =		bean.getCalculatedItemDetails();
			HashMap hmCalculatedDetail		=		null;
				i = 0;
			for(recCount=2;recCount<result.size(); recCount++){

				if (recCount % 2 == 0)
					classvalue				=		"OAQRYODD";
				else
					classvalue				=		"OAQRYEVEN";
		%>
			<tr id="tr_<%=i%>">
		<%
				records						=		(ArrayList) result.get(recCount);
				hmCalculatedDetail			=		(HashMap)hmCalculatedItemDetails.get(records.get(0)); 
				
			 /**
			* @Name - Suri
			* @Date - 22/01/2010
			* @Inc# - IN015496
			* @Desc - Code added to accept decimal values dynamically.
			* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			*/
	   int no_of_decimals=0;
		if((bean.getAllowDecimalsYN((String)records.get(0))).equals("Y")){
			no_of_decimals=bean.getNoOfDecimals();
		}
		else{
			no_of_decimals=0;
		}
	  	

		%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align='center'><input type="checkbox" value="Y" name="add_item_<%=records.get(0)%>" id="add_item_<%=records.get(0)%>" <%=bean.getChecked((String)hmCalculatedDetail.get("selected"))%> onFocus="return changeRowColor(tr_<%=i%>);" onClick="updateRemove(this,remove_item_<%=records.get(0)%>,'<%=i%>')"><input type="hidden" name="remove_item_<%=records.get(0)%>" id="remove_item_<%=records.get(0)%>" value="<%=((String)hmCalculatedDetail.get("selected")).equals("N")?records.get(0):""%>">
				 <input type="hidden" name="chk_box_<%=i%>" id="chk_box_<%=i%>" value="Y">
				 <input type="hidden" name="item_name_<%=i%>" id="item_name_<%=i%>" value="<%=records.get(0)%>"> 
				
				</td>

				
				<td class="<%=classvalue%>" onclick="disableClick(event);"  title="<%=records.get(0)%>"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"  align='right'><%=bean.setNumber((bean.checkForNull((String)records.get(6),"0")),no_of_decimals)%></td>

				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right" width=10><input type="text" class="NOBORDER" name ="min_stk_qty_<%=records.get(0)%>" value="<%=hmCalculatedDetail.get("min_stk_qty")%>" size="12" maxlength="12"  onkeypress = "return isValidNumber(this,event,12,0);" onFocus="return changeRowColor(tr_<%=i%>);" ></td>

				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right" width=10><input type="text" class="NOBORDER" name ="max_stk_qty_<%=records.get(0)%>" value="<%=hmCalculatedDetail.get("max_stk_qty")%>" size="12" maxlength="12"  onkeypress = "return isValidNumber(this,event,12,0);" onFocus="return changeRowColor(tr_<%=i%>);" ></td>

				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right" width=10><input type="text" class="NOBORDER" name ="reorder_level_<%=records.get(0)%>" value="<%=hmCalculatedDetail.get("reorder_level")%>" size="12" maxlength="12"  onkeypress = "return isValidNumber(this,event,12,0);" onFocus="return changeRowColor(tr_<%=i%>);" ></td>

				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right" width=10><input type="text" class="NOBORDER" name ="reorder_qty_<%=records.get(0)%>" value="<%=hmCalculatedDetail.get("reorder_qty")%>" size="12" maxlength="12"  onkeypress = "return isValidNumber(this,event,12,0);" onFocus="return changeRowColor(tr_<%=i%>);" ></td>


				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right"><%=records.get(2)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right"><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right"><%=records.get(4)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align="right"><%=records.get(5)%></td>
			</tr>
		<%
					i++;
			}

		%>
		</table>	
		<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name%>">
		<input type="hidden" name="total_index" id="total_index" value="<%=i%>">
	</form>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ComputeStockLevelsResult.jsp", searched));
	
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

