<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
		
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");				
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/**
				* @Name - Krishna Kiran 
				* @Date - 21/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - code added for getting the bean instance for calling the adapter functiions					getNoOfDecimals().
		*/
		String bean_id							=		"SuspendOrReinstateBatchBean";
		String bean_name						=		"eST.SuspendOrReinstateBatchBean";
		//String disable						=		"";
		
		SuspendOrReinstateBatchBean bean		=		(SuspendOrReinstateBatchBean) getBeanObject( bean_id, bean_name,request);  
		bean.setLanguageId(locale);
	%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script> 
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eST/js/ProductComplaint.js"></script>
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  
<%		
	String p_item_code		=	CommonBean.checkForNull(request.getParameter("item_code"));
	String p_manufacturer	=	CommonBean.checkForNull(request.getParameter("manufacturer"));
	String p_batch_id		=	CommonBean.checkForNull(request.getParameter("batch_id"));
	String classvalue		=	"";
	boolean searched				=			(request.getParameter("searched") == null) ?false:true;
	try{
		HashMap sqlMap				=			new HashMap();
		sqlMap.put("sqlData", "SELECT a.batch_id, TO_CHAR (a.expiry_date, 'dd/mm/yyyy') as expiry_date, a.trade_name, a.manufacturer_name, SUM (a.qty_on_hand) qtyonhand, a.trade_id FROM st_batch_search_lang_view a, ST_BATCH_CONTROL b , mm_store_lang_vw c, ST_ACC_ENTITY_PARAM d WHERE a.item_code = b.item_code AND a.batch_id = b.batch_id AND a.expiry_date = b.expiry_date_or_receipt_date AND a.item_code = ? AND b.batch_status = 'C' AND a.manufacturer_id LIKE (? || '%') AND a.batch_id LIKE (? || '%') AND a.language_id = c.language_id AND c.store_code = a.store_code AND a.language_id = ? AND DECODE (a.lang1,NULL,?,a.lang1) = ? AND DECODE (a.lang2,NULL,?,a.lang2) = ? AND c.facility_id = ? GROUP BY a.batch_id, a.expiry_date, a.trade_name,a.trade_id, a.manufacturer_name, b.batch_status, a.item_code, b.remarks, b.status_updated_by, b.status_remarks_oth ORDER BY 1, 2");

		

		//The fields are going to be display
		ArrayList displayFields		=			new ArrayList();
		displayFields.add("batch_id");
		displayFields.add("expiry_date");
		displayFields.add("trade_name");
		displayFields.add("qtyonhand");
		displayFields.add("trade_id");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields			=			new ArrayList();
		chkFields.add(p_item_code);
		chkFields.add(p_manufacturer);
		chkFields.add(p_batch_id);
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add((String)session.getAttribute("facility_id"));
		

		// Adding function related array list into the HashMap
		HashMap funcMap				=			new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		ArrayList result = (ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
		String printTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintWorksheet.label","common_labels");

		/**
				* @Name - Krishna Kiran 
				* @Date - 21/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - No of Decimal is brought here.
		*/
			int no_of_decimals = bean.getNoOfDecimals();
			int no_of_decimals_tmp = no_of_decimals;
			
			
%>
<body>
<form name="ProductComplaintResultForm" id="ProductComplaintResultForm"  >
	<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
			<td width="80%" class="white">&nbsp;</td>
			<td width="20%" class="white">&nbsp;
			<%
				out.println(result.get(1));
			%>
			</td>
		</tr>
	</table>
	<%
		
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			
	<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th>WS</th>
		<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/> </th>
		<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>
	  <%
	ArrayList records=new ArrayList();
	for(int recCount=2; recCount<result.size(); recCount++) {
		if ( recCount % 2 == 0 )
			classvalue = "QRYODD" ;
		else
			classvalue = "QRYEVEN" ;
		records=(ArrayList) result.get( recCount );
	%>
		<tr id="tr_<%=recCount%>">
			<td class="<%=classvalue%>" title= "<%=printTitle%>" style="cursor:pointer" onclick = "PrintWorkSheet('<%=records.get(0)%>','<%=records.get(1)%>','<%=records.get(4)%>');changeRowColor(tr_<%=recCount%>)">
			<div  align="center" ><img  src='../../eCommon/images/beprint.gif'></img></div></td>
			<td class="<%=classvalue%>" ><%=records.get(0)%>&nbsp;</td>
			<td class="<%=classvalue%>" ><%=records.get(1)%>&nbsp;</td>
			<td class="<%=classvalue%>" ><%=records.get(2)%>&nbsp;</td>
			<%
				/**
				* @Name - Krishna Kiran 
				* @Date - 19/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
				*/	
				
				if(bean.getAllowDecimalsYN(p_item_code).equals("N"))
					no_of_decimals = 0;				
				else
					no_of_decimals = no_of_decimals_tmp;				
			%> 
			<td class="<%=classvalue%>"> <div  align="right">&nbsp; <%=bean.setNumber(records.get(3).toString(),no_of_decimals)%>			
			</div></td>	  				
		</tr>

	<%}%>
	</table>
	</form>	
	<%
		out.flush();
			}
		else{
		%>
			<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common" ));</script>
		<%
		
			}
		out.println(CommonBean.setForm ( request ,"../../eST/jsp/ProductComplaintResult.jsp", searched) );
		}
		catch(Exception es){
			es.printStackTrace();
		}
	%>
</table>	
   <form name="ProductComplaintResultPrintForm" id="ProductComplaintResultPrintForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> 
			
			<input type="hidden" name="p_module_id" id="p_module_id"  value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id"  value="STBPDCOM">
			<input type="hidden" name="p_user_name" id="p_user_name"	 value="<%=session.getValue( "login_user" )%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=session.getValue( "facility_id" )%>">
			<input type="hidden" name="p_item_code" id="p_item_code" value="<%=p_item_code%>"> 
			<input type="hidden" name="p_trade_id" id="p_trade_id">
			<input type="hidden" name="p_batch_id" id="p_batch_id">
			<input type="hidden" name="p_expiry_date" id="p_expiry_date">
		</form>

</body>
</html>

