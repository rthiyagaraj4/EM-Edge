<!DOCTYPE html>
<%@ page import=" eST.StockStatusByStoreBean,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> 
		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StockStatusByStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/></title>
	</head>
	<%

	//	String bean_id = "StockStatusByStoreBean";
	//	String bean_name = "eST.StockStatusByStoreBean";
		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		
		String store_code = request.getParameter("store_code")==null?"":request.getParameter( "store_code" ) ;
		//String mode = request.getParameter("mode")==null?"":request.getParameter( "mode" ) ;
//	String function_id = request.getParameter("function_id")==null?"":request.getParameter( "function_id" ) ;
		String classvalue = "";
	//	StockStatusByStoreBean bean = (StockStatusByStoreBean) mh.getBeanObject(bean_id, request,  bean_name);  
		//bean.loadData(store_code, item_code);
		//java.util.ArrayList alItems = bean.getAlItems();
		//int i=0;
	
		HashMap sqlMap = new HashMap();
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();
		ArrayList chkFields = new ArrayList();
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_STORE_DETAIL_LIST"));
			
	
		displayFields.add("store_desc");		//2
		displayFields.add("item_desc");
		displayFields.add("batch_id");
		displayFields.add("bin_desc");
		displayFields.add("expiry_date");
		displayFields.add("trade_name");
		displayFields.add("qty_on_hand");

		chkFields.add(store_code);
		chkFields.add(item_code);
		chkFields.add(locale);
		chkFields.add(locale);
		chkFields.add(locale);


		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
			{
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
		
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
		
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center" id='tb1'>
				<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>
				<%
					//if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
					
						ArrayList records=new ArrayList();
						for(int recCount=2; recCount<result.size(); recCount++) {
							classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
							//String link_columns = "1";
							records=(ArrayList) result.get(recCount);

				%>
			<tr>
				
			
			<td class="<%=classvalue%>" align="left"><font size=1><%=CommonBean.checkForNull((String)records.get(0),"&nbsp;")%></font></td>
			<td class="<%=classvalue%>" align="left"><font size=1><%=CommonBean.checkForNull((String)records.get(1),"0")%></font></td>
			<td class="<%=classvalue%>" align="right"><font 
			size=1><%=CommonBean.checkForNull((String)records.get(2),"0")%></font></td>
			<td class="<%=classvalue%>" align="left"><font 
			size=1><%=CommonBean.checkForNull((String)records.get(3),"0")%></font></td>
			<td class="<%=classvalue%>" align="center"><font 
			size=1><%=CommonBean.checkForNull((String)records.get(4),"")%></font></td>
			<td class="<%=classvalue%>" align="left"><font 
			size=1><%=CommonBean.checkForNull((String)records.get(5),"0")%></font></td>
			<td class="<%=classvalue%>" align="right"><font 
			size=1><%=CommonBean.checkForNull((String)records.get(6),"0")%></font></td>

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
				//document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
				//window.close();
				parent.document.getElementById('dialog_tag').close();
			</script>
		<%
		}
		%>
			
		
		
		
		</form>
<%
				out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByStoreList.jsp", searched));
%>
	</body>
</html>

