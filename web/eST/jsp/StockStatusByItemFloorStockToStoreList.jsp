<!--
--------------------------------------------------------------------------------------------------------------------
Date         Edit History               Name                        Description
--------------------------------------------------------------------------------------------------------------------
25/07/2024    45057      Gunasekar      M.f.mohamed Ali           ML-MMOH-CRF-1704
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="eST.StockStatusByStoreBean,eST.StockStatusByItemBean, java.util.HashMap,webbeans.eCommon.*,java.util.ArrayList,java.text.NumberFormat , java.util.Locale" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
        <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/StockStatusByItem.js"></script>
		<title><fmt:message key="eST.FloorStockStoreWise.label" bundle="${st_labels}"/></title>
	</head>
	<%

		boolean searched			    =	(request.getParameter("searched") == null) ?false:true;
		String item_code			    =	 request.getParameter("item_code")==null?"":request.getParameter("item_code");
		String fm_store_code			=	 request.getParameter("fm_store_code")==null?"":request.getParameter("fm_store_code");
		String move_year			    =	 request.getParameter("move_year")==null?"":request.getParameter("move_year");
		String move_month			    =	 request.getParameter("move_month")==null?"":request.getParameter("move_month");
		String store_code_from			=	 request.getParameter("store_code_from")==null?"":request.getParameter("store_code_from");
		String store_code_to			=	 request.getParameter("store_code_to")==null?"":request.getParameter("store_code_to");
		String strCostAccess			=	 request.getParameter("cost_access")==null?"":request.getParameter("cost_access");
		String dflt_facility_id	      =		request.getParameter( "dflt_facility_id" )==null?"":request.getParameter( "dflt_facility_id" );		
		String bean_id				    =	 "StockStatusByItemBean";
	    String bean_name			    =	 "eST.StockStatusByItemBean";
	    StockStatusByItemBean bean      =	 (StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	    bean.setLanguageId(locale);

        String user_name			    =	 (String) session.getValue( "login_user" ) ;
	
        try{
		HashMap sqlMap				    =	  new HashMap();
		HashMap funcMap				    =	  new HashMap();
		ArrayList displayFields		    =	  new ArrayList();
		ArrayList chkFields			    =	  new ArrayList();
		
		int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_FLOOR_STOCK_TO_STORE_LIST"));
        displayFields.add("store");	
		displayFields.add("issue_qty");	
		displayFields.add("issue_cost");

		chkFields.add(item_code);
		chkFields.add(move_month);
		chkFields.add(move_year);
		chkFields.add(move_month);
		chkFields.add(move_year);
		chkFields.add(fm_store_code);
		chkFields.add(item_code);
		chkFields.add(CommonBean.checkForNull(dflt_facility_id,"%"));
		chkFields.add(locale);
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(user_name);
		chkFields.add(move_month);
		chkFields.add(move_year);
		chkFields.add(fm_store_code);
		chkFields.add(item_code);
		chkFields.add(CommonBean.checkForNull(dflt_facility_id,"%"));
		chkFields.add(locale);
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(user_name);
	    funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
        if((result.size()>=3)){
		
		%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white" align="Right">&nbsp;<%=result.get(1)%></td>
			</tr>
		</table>
			
		<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center" id='tb1'>
				<th align="center"><fmt:message key="eST.FloorStockStore.label" bundle="${common_labels}"/></th>
				<th  align="Right" ><fmt:message key="eST.Quantity.label" bundle="${st_labels}"/>&nbsp;</th>
				<%if(strCostAccess.equals("Y")){%>
				<th align="Right" ><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/>&nbsp;</th>
				<%}
				int intCount=0;
				ArrayList data = new ArrayList();
				for (int i=2; i<result.size(); i++) {
					++intCount;
					String className = (i % 2 == 0)?"QRYEVEN":"QRYODD";
					data = (ArrayList)result.get(i);	
				%>
				<tr>
						<td class="<%=className%>" style="TEXT-ALIGN:left"><%=(String)data.get(0)%></td>
						<td class="<%=className%>" style="TEXT-ALIGN:right"><%=data.get(1)%></td>
						<%if(strCostAccess.equals("Y")){%>
						<td class="<%=className%>" style="TEXT-ALIGN:right"><%=bean.setNumberFormat((String)data.get(2),noOfDecimalsForCost)%></td>
						<%}%>
			   </tr>
			<%
				}
			%>
			</table>
<%	
	}
	out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByItemFloorStockToStoreList.jsp", searched));
	}
	   catch(Exception e) {
	   e.printStackTrace();
				 }
        putObjectInBean(bean_id,bean,request);
%>		
	</body>
</html>

