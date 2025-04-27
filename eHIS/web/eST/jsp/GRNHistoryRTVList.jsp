<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import="eST.*,java.util.*,java.lang.*,webbeans.eCommon.*,java.text.NumberFormat" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
request.setCharacterEncoding("UTF-8");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function 
		*/
		String locale			= (String)session.getAttribute("LOCALE");
		String bean_id = "GRNHistoryBean";
		String bean_name = "eST.GRNHistoryBean";
		GRNHistoryBean bean = (GRNHistoryBean) getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);
		int no_of_decimals=bean.getNoOfDecimals();

		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> 
		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/GRNHistoy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eST.GRNHistoryRTVList.label" bundle="${st_labels}"/></title>
	</head>
	<%
		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String doc_no = request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		String doc_type_code = request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		String doc_no_temp="";
		String doc_type_code_temp="";
		String display_flag="N";
	try{
		HashMap sqlMap = new HashMap();
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();
		ArrayList chkFields = new ArrayList();
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("ST_SQL_GRN_HISTORY_RTV_DTLS"));
		//Line In repo 914			
		
		displayFields.add("doc_type_code");	                     
		displayFields.add("doc_no");	                         
		displayFields.add("item_qty_normal");                    
		displayFields.add("item_qty_bonus");	                 
		displayFields.add("rtv_unit_cost");	                     
		displayFields.add("item_cost_value");						
		displayFields.add("expiry_date_or_receipt_date");						
		displayFields.add("batch_id");						     
		displayFields.add("short_desc");						 
		displayFields.add("item_qty");						 
	
		chkFields.add( doc_type_code);
		chkFields.add( doc_no);
		chkFields.add( item_code);
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3)){
		%>
		<table cellpadding=0 cellspacing=0 width="99%" align="center">
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center" id='tb1'>
					<th><fmt:message key="eST.DocType/No.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.NormalQty.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.BonusQuantity.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.BatchQuantity.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
				<%
				ArrayList data = new ArrayList();
			for (int i=2; i<result.size(); i++) {
					String className = (i % 2 == 0)?"QRYEVEN":"QRYODD";
					data = (ArrayList)result.get(i);
					display_flag = "N";
				if((!doc_no_temp.equals((String)data.get(1)))||(!doc_type_code_temp.equals((String)data.get(0)))  )
						{
								display_flag = "Y";
								doc_no_temp = (String)data.get(1) ;
								doc_type_code_temp = (String)data.get(0);
						}
			%>
			<tr>
						<td class = "<%=className%>"align="Left">&nbsp;<%=(display_flag=="Y"?(doc_type_code_temp+"/"+doc_no_temp):"")%></td>
						<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Unit Cost, Normal Qty, Bonus Quantity, Batch Quantity, Cost Value.				
					-->
						<td class = "<%=className%>" style="TEXT-ALIGN:right" ><%=(display_flag=="Y"?bean.setNumber(bean.checkForNull((String)data.get(2),"0"),no_of_decimals):"")%>&nbsp;</td>
						<td class = "<%=className%>" style="TEXT-ALIGN:right" ><%=(display_flag=="Y"?bean.setNumber(bean.checkForNull((String)data.get(3),"0"),no_of_decimals):"")%>&nbsp;</td>
						<td class = "<%=className%>" style="TEXT-ALIGN:right" ><%=(display_flag=="Y"?bean.setNumber(bean.checkForNull((String)data.get(4),"0"),noOfDecimalsForCost):"")%>&nbsp;</td>
						<td class = "<%=className%>" style="TEXT-ALIGN:right" ><%=bean.setNumber(bean.checkForNull((String)data.get(9),"0"),no_of_decimals)%>&nbsp;</td>
						<td class = "<%=className%>" style="TEXT-ALIGN:right" ><%=bean.setNumber(bean.checkForNull((String)data.get(5)),noOfDecimalsForCost)%>&nbsp;</td>
						<td class = "<%=className%>"align="Left">&nbsp;<%=CommonBean.checkForNull((String)data.get(7))%></td>		
						<td class = "<%=className%>"align="Left">&nbsp;<%=CommonBean.checkForNull((String)data.get(6))%></td>
			</tr>
			<%
				}
			%>
			</table>
		</form>
<%	
	}
	out.println(CommonBean.setForm (request ,"../../eST/jsp/GRNHistoyBatchList.jsp", searched));
	}
				catch(Exception e) {
					e.printStackTrace();
				}
%>
	</body>
</html>

