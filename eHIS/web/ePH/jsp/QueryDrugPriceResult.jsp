<!DOCTYPE html>
<%@ page import ="ePH.PHReportsBean,eCommon.Common.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*,java.text.NumberFormat,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
    <head>
		<title></title>
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<link rel="stylesheet" type ="text/css" href="../../eST/html/IeStyle.css"></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/QueryDrugPrice.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    </head>
	<body>
<%
		String from				=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
		String to				=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
		String stlightgreen		=		"";
		String Adapter_id		= "PhAdapter" ;
		String Adapter_name		= "ePH.PHReportsBean";
		PHReportsBean bean		= (PHReportsBean)getBeanObject(Adapter_id ,Adapter_name,request) ;
		bean.setLanguageId(locale);
		String maxAllowed					=		"1";  
		int maxRec							=		0; 
		int start							=		0;
		int end								=		0;
		int displaySize						=		0;
		int count							=		0;	
		String  classvalue					=		"";
		ArrayList result					=		new ArrayList();	
		HashMap dataList					=		null;
		String curr_item_store				=		"";
		String prev_item_store				=		"";
		String prev_item_code="", curr_item_code="";
		String stSQL						=		"";
		String item_code_from				=		"";
		String item_code_to					=		"";
		String store_code_from              =       "";
		String store_code_to              =       "";
		ArrayList alParameters	=	new ArrayList();
		ArrayList listRecord	=	new ArrayList();
		try{
			item_code_from = request.getParameter("item_code_from")==null?"":request.getParameter("item_code_from");
			item_code_to = request.getParameter("item_code_to")==null?"":request.getParameter("item_code_to");
			store_code_from=request.getParameter("store_code_from")==null?"":request.getParameter("store_code_from");
			store_code_to = request.getParameter("store_code_to")==null?"":request.getParameter("store_code_to");
			if(store_code_to.equals(""))
				store_code_to = store_code_from;
			if(item_code_to.equals(""))
				item_code_to = item_code_from;
			alParameters.add(locale);
			alParameters.add(locale);
			alParameters.add(store_code_from.trim());
			alParameters.add(store_code_to.trim());
			alParameters.add(item_code_from.trim());
			alParameters.add(item_code_to.trim());
			alParameters.add(locale);
			alParameters.add(locale);
			stSQL = ePH.Common.PhRepository.getPhKeyValue("SQL_PH_DRUG_PRICE_DETAILS_SELECT");
			HashMap dataList_new = null;
			listRecord			=		bean.fetchRecords(stSQL,alParameters);
			for(int i=0;i<listRecord.size();i++){
				dataList_new		=		(HashMap)listRecord.get(i);
				listRecord.set(i,dataList_new); 
			}  
			result = listRecord;
			maxRec					=		result.size();
			displaySize				=		Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
			displaySize				=		Integer.parseInt("12");
			if ( from == null || from =="" )
				start				=		0;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null || to ==""){
				end					=		displaySize;
			}
			else{
				end					=		Integer.parseInt( to ) ;	
			}
		
		    if(result.size() > 0 ){
		%>  
				<form name="fromDrugPriceResult" id="fromDrugPriceResult">
					<table cellpadding=0 cellspacing=0 width="90%" align='center' border='0'>
						<tr>
							<td  class='label' style='text-align:right;'>
							<label id='lblPrev' style='display:none;'>
							<a href='javascript:goPrev();'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></label>&nbsp;
							<label id='lblNext' style='display:none;'><a href='javascript:goNext();' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></label>
							</td>
						</tr>
					</table>
					<table cellpadding=0 cellspacing=0 width="99%" align='center' border='1'>
						<tr>
							<th class='CAGROUP_HEADING' width='10%'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th> 
							<th class='CAGROUP_HEADING' width='20%'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
							<th class='CAGROUP_HEADING' width='10%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></th>
							<th class='CAGROUP_HEADING' width='10%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
							<th class='CAGROUP_HEADING' width='10%'><fmt:message key="eST.IssueUOM.label" bundle="${st_labels}"/></th>
							<th class='CAGROUP_HEADING' width='10%'><fmt:message key="eST.MRP.label" bundle="${st_labels}"/></th>
							<th class='CAGROUP_HEADING' width='10%'><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th> 
							<th class='CAGROUP_HEADING' width='10%'><fmt:message key="ePH.StockUnit.label" bundle="${ph_labels}" />&nbsp;<fmt:message key="eST.Cost.label" bundle="${st_labels}" /></th>
							<th class='CAGROUP_HEADING' width='5%'><fmt:message key="ePH.StockOnHandQty.label" bundle="${ph_labels}" /></th>
							<th class='CAGROUP_HEADING' width='5%'><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}" /></th>
						</tr>
<%
						count				=		start;
						int chkCount		=		0;
						String tool="", description="", expiry_date="", batch_id="";
						boolean value = false;
						String salePrice="", convFactor="", mrp="";
						while (count < maxRec && count < end) {
							dataList		=		(HashMap)result.get(count);
							if ( count % 2 == 0 )
								classvalue  =		"QRYEVEN" ;
							else
								classvalue  =		"QRYODD" ;
							//curr_item_store =		(String)dataList.get("ITEM_CODE")+(String)dataList.get("STORE_CODE");
							curr_item_store =	(String)dataList.get("STORE_CODE");
							curr_item_code =	(String)dataList.get("ITEM_CODE");
							if (!curr_item_store.equals(prev_item_store)) {
								prev_item_store = curr_item_store;
								prev_item_code = "";
%>
								<tr>
									<td colspan='10'  class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/> :</b> <%=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")%></b></font></td>
								</tr> 
<%
							}
%>
							<tr id="tr_<%=chkCount%>">
<%
								stlightgreen		=		classvalue;
								tool			=		"";
								description	=		"";
								expiry_date  =		(String)dataList.get("EXPIRY_DATE");
%>
								<td class="<%=classvalue%>">
<%
								if(curr_item_code.equals(prev_item_code)){
%>
									&nbsp;
<%
								}
								else{
%>
									<font size=1><%=CommonBean.checkForNull((String) dataList.get("ITEM_CODE"), "&nbsp;")%></font>
<%
								}
%>
								</td>
								<td class="<%=classvalue%>">
<%
								if(curr_item_code.equals(prev_item_code)){
%>
									&nbsp;
<%
								}
								else{
%>
									<font size=1><%=CommonBean.checkForNull((String) dataList.get("ITEM_DESC"), "&nbsp;")%></font></td>
<%
								}
								prev_item_code = curr_item_code;
%>
								<td class="<%=classvalue%>">
<%
								batch_id = (String) dataList.get("BATCH_ID");
								value = com.ehis.util.DateUtils.validDate(batch_id, "DMY", locale);
								if (value) {
%>
									<font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("BATCH_ID"),"DMY","en",locale),"&nbsp;")%></font></td>
<%
								}
								else{
%>
									<font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
<%
								}
								salePrice = CommonBean.checkForNull((String)dataList.get("SALE_PRICE"),"0");
								convFactor = CommonBean.checkForNull((String)dataList.get("COV_FACTOR"),"1");
								mrp = Float.parseFloat(salePrice)*Float.parseFloat(convFactor)+"";
								salePrice = Float.parseFloat(salePrice)+"";
								if(Float.parseFloat(mrp)==0)
									mrp = "&nbsp;";
								if(Float.parseFloat(salePrice)==0)
									salePrice = "&nbsp;";
%>
								<td class="<%=classvalue%>"><font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String) dataList.get("EXPIRY_DATE"),"DMY", "en", locale), "&nbsp;")%></font></td>
								<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("ISSUE_UOM_DESC"),"&nbsp;")%></font></td>
								<td class="<%=classvalue%>" style='text-align:right;'><font size=1><%=mrp%>&nbsp;</font></td>
								<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BASE_UOM_DESC"),"&nbsp;")%></font></td> 
								<td class="<%=classvalue%>" style='text-align:right;'><font size=1><%=salePrice%>&nbsp;</font></td>
								<td class="<%=classvalue%>" style='text-align:right;'><font size=1><%=CommonBean.checkForNull((String)dataList.get("STOCK_ON_HAND"),"&nbsp;")%>&nbsp;</font></td>
								<td class="<%=classvalue%>" style='text-align:right;'><font size=1><%=CommonBean.checkForNull(
								(String) dataList.get("ALLOCATED_QUANTITY"),"&nbsp;")%>&nbsp;</font></td>
							</tr>
<%
							count++;
							chkCount++;
							prev_item_store		=		curr_item_store;
						}
%>
						</table>
						<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
						<input type="hidden" name="start" id="start"					value="<%=start%>">
						<input type="hidden" name="end" id="end"						value="<%=end%>">
						<input type="hidden" name="totalRecords" id="totalRecords"			value='<%=result.size()%>'>
						<input type="hidden" name="maxAllowed" id="maxAllowed"				value="<%=maxAllowed%>">
						<input type="hidden" name="displaySize" id="displaySize"				value="<%=displaySize%>">
					</form>
<%
					out.flush();
				} 
				else{
%>
					<script>
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					</script>
<%
				}
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
%>
	</body>
<%
	if(maxRec > 0) { 
%>
		<script>activeLink();</script>
<%
	}
%>
</html>

