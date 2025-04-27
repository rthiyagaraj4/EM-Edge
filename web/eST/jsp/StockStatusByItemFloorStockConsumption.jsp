<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History               Name                        Description
--------------------------------------------------------------------------------------------------------------------
25/07/2024    45057      Gunasekar      M.f.mohamed Ali        ML-MMOH-CRF-1704
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="eST.StockStatusByItemBean, eST.Common.* , eCommon.Common.*,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>


<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="Javascript" src="../../eST/js/StockStatusByItem.js">
	</script>
</head>
<body>

<%
	String item_code			  =			request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
	String store_code_from		  =			request.getParameter( "store_code_from" )==null?"":request.getParameter( "store_code_from" );
	String store_code_to		  =			request.getParameter( "store_code_to" )==null?"":request.getParameter( "store_code_to" );
	String bean_id				  =			"StockStatusByItemBean";
	String bean_name			  =			"eST.StockStatusByItemBean";
	StockStatusByItemBean bean    =			(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	boolean searched			  =	        (request.getParameter("searched") == null) ?false:true;
	String dflt_facility_id		  =		    request.getParameter( "dflt_facility_id" )==null?"":request.getParameter( "dflt_facility_id" );
 
	try{
		HashMap sqlMap			=			new HashMap();
		HashMap funcMap			=			new HashMap();
		ArrayList displayFields =			new ArrayList();
		ArrayList chkFields		=			new ArrayList();
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_FLOOR_STOCK_CONSUMPTION"));
        displayFields.add("move_month");	 		
		displayFields.add("move_year");	
		displayFields.add("consumption_qty");
		displayFields.add("consumption_cost");
		chkFields.add(CommonBean.checkForNull(item_code,"%"));
		chkFields.add(CommonBean.checkForNull(item_code,"%"));
		chkFields.add(CommonBean.checkForNull(dflt_facility_id,"%"));
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(bean.getLoginById());
		chkFields.add(CommonBean.checkForNull(item_code,"%"));
		chkFields.add(CommonBean.checkForNull(dflt_facility_id,"%"));
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(bean.getLoginById());

		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result		=			(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	%>
	<script>
	var cost_access="<%=bean.getAccessCostDetails()%>";	
	</script>

	<%	if((result.size()>=3)&&(!(((String) result.get(0)).equals("0")))){
		%>
		<table border="0" cellpadding=0 cellspacing=0 width="10%" align="center">
			<tr>
				<td width=100 class="white">&nbsp;</td>
				<td width=100 class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="55%" align="left" id='tb1'>
			<tr>
				<th  align="center" ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></th>
				<th  align="Right" ><fmt:message key="eST.ConsumptionQty.label" bundle="${st_labels}"/>&nbsp;</th>
		<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
				<th align="Right" ><fmt:message key="eST.ConsumptionCost.label" bundle="${st_labels}"/>&nbsp;</th>
		<%}%>	
			</tr>
			<%
			     String strYear = "";
				int intCount			=		0;
				ArrayList data = new ArrayList();
				for (int i=2; i<result.size(); i++) {
					++intCount;
					data				=		(ArrayList)result.get(i);
                    int  intmonth		=		Integer.parseInt((String)data.get(0));
					String strMonth		=		"";
					if (intmonth <10) {
						strMonth		=		"0"+intmonth;
					}else{
						strMonth		=		""+intmonth;
					}  			
					strYear = com.ehis.util.DateUtils.convertDate((String)data.get(1),"YY","en",locale);					
		   %>
					<tr>
						<td  id="period_<%=intCount%>" onClick="displyFromStores('<%=item_code%>','<%=strMonth%>','<%=strYear%>','<%=intCount%>','<%=store_code_from%>','<%=store_code_to%>', 'DisplyFromStores', '<%=dflt_facility_id%>');" style="color:blue;cursor:pointer "> <%=strMonth%> / <%=strYear%></td>
						<td  id="qty_<%=intCount%>" align="Right"><%=data.get(2)%></td>
						<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
						<td  id="cost_<%=intCount%>" align="Right"><%=bean.setNumberFormat((String)data.get(3),noOfDecimalsForCost)%></td>
						<%}%>	
					</tr>
			<%
				}
			%>
		</table>
	<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByItemFloorStockConsumption.jsp", searched));
	}
	catch(Exception e) {
		e.printStackTrace(); 
	}
	putObjectInBean(bean_id,bean,request);
%>

</body>
</html>

