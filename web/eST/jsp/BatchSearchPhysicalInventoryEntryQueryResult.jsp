<!DOCTYPE html>

 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
 <%
			request.setCharacterEncoding("UTF-8");
 			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
        <script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	    <script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/PhysicalInventoryEntry.js"> </script>
 	    <script language="javascript" src="../../eST/js/StTransaction.js"></script>
        <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        		
</head>
<body>
<%
	String from							=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String searchby							=		request.getParameter( "searchby" )==null?"":request.getParameter( "searchby" ) ;
	//String stlightgreen					=		"";
	BatchSearchBean bean				=		(BatchSearchBean) getBeanObject( "batchSearchBean","eST.BatchSearchBean",request );
	
	String bean_id = "PhysicalInventoryEntryBean";
		String bean_name = "eST.PhysicalInventoryEntryBean";
		
		PhysicalInventoryEntryBean bean_phy = (PhysicalInventoryEntryBean) getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
	
	bean_phy.setLanguageId(locale);

	//String searchFunction				= 		bean.getSearchFunction() ; commented by ganga for unused variables on Wednesday, October 19, 2011
	String multipleSelect				=		bean.getMultipleSelect() ;
	String includeSuspendedBatches		=		bean.getIncludeSuspendedBatches() ;
	String includeExpiredBatches		= 		bean.getIncludeExpiredBatches() ;
	String includeZeroStockBatches		=		bean.getIncludeZeroStockBatches() ;
	String maxAllowed					=		bean.getMaxAllowed() ;
	//String p_list_all_trades_yn			=		request.getParameter( "p_list_all_trades_yn" )==null?"":request.getParameter( "p_list_all_trades_yn" ) ;
	  
	int maxRec							=		0; 
	int start							=		0;
	int end								=		0;
	int displaySize						=		0;
	int count							=		0;	
	//String expiry_yn					=		"";
	int EWDays							=		0;

	String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
	String  classvalue					=		"";
	ArrayList result					=		new ArrayList();	
	HashMap dataList					=		null;
	String s1 ="../../eST/images/Ascending.gif";
	String s2 ="../../eST/images/Descending.gif";

	String curr_store				=		"";
	String prev_store				=		"";
	try{
				EWDays					=		bean.getEntityparam_EWDays(ACC_ENTITY_ID);
				bean_phy.loadResultPage();
				result					=		bean_phy.getDataList();
				maxRec					=		result.size();
			
		
		

				displaySize				=		Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
				displaySize				=		Integer.parseInt("12");
				if ( from == null || from =="" )
					start				=		0;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null || to ==""){
					end					=		displaySize ;
				}
				else{
					end					=		Integer.parseInt( to ) ;	
				}
		
		
		if(result.size() > 0 ){
		%>
<form name=BatchsearchForm>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
			<tr>
				<th  class='CAGROUP_HEADING' ></font></th> 
				<th  class='CAGROUP_HEADING' onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" name='EXPDT' style="WORD-BREAK:BREAK-ALL;cursor:pointer" ><font size=1><b><fmt:message key="eST.Expiry/ReceiptDate.label" bundle="${st_labels}"/></b></font>&nbsp;&nbsp;&nbsp;<img src=<%=(bean_phy.getObj().equalsIgnoreCase("EXPDT") && bean_phy.getOrder().equalsIgnoreCase("ASC") )?s1:s2%> alt="Descending Order" border=none></th>
				<th  class='CAGROUP_HEADING' onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" name='BATCHID' style="WORD-BREAK:BREAK-ALL;cursor:pointer"><font size=1><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b></font>&nbsp;&nbsp;&nbsp;<img src=<%=(bean_phy.getObj().equalsIgnoreCase("BATCHID") && bean_phy.getOrder().equalsIgnoreCase("ASC") )?s1:s2%> alt="Descending Order" border=none></th>
				<%if(searchby.equals("D")) {%>
				<th  class='CAGROUP_HEADING' onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" name='TRADENAME' style="WORD-BREAK:BREAK-ALL;cursor:pointer"><font size=1><b><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></b></font>&nbsp;&nbsp;&nbsp;<img src=<%=(bean_phy.getObj().equalsIgnoreCase("TRADENAME") && bean_phy.getOrder().equalsIgnoreCase("ASC") )?s1:s2%> alt="Descending Order" border=none></th><!-- Modified for IN:074037  -->
				<%}else{%>
				<th  class='CAGROUP_HEADING' onclick ="" name='ITEMDESC' style="WORD-BREAK:BREAK-ALL;cursor:pointer"><font size=1><b><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></b></font>&nbsp;&nbsp;&nbsp;<img src=<%=(bean_phy.getObj().equalsIgnoreCase("TRADENAME") && bean_phy.getOrder().equalsIgnoreCase("ASC") )?s1:s2%> alt="Descending Order" border=none></th>
				<%}%>
				<th  class='CAGROUP_HEADING' onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" name='MANUF' style="WORD-BREAK:BREAK-ALL;cursor:pointer"><font size=1><b><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></b></font>&nbsp;&nbsp;&nbsp;<img src=<%=(bean_phy.getObj().equalsIgnoreCase("MANUF") && bean_phy.getOrder().equalsIgnoreCase("ASC") )?s1:s2%> alt="Descending Order" border=none></th>
				<%if(searchby.equals("D")) {%>
				<th  class='CAGROUP_HEADING' onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" name='BINC' style="WORD-BREAK:BREAK-ALL;cursor:pointer"><font size=1><b><fmt:message key="eMM.BinLocationCode.label" bundle="${mm_labels}"/></b></font>&nbsp;&nbsp;&nbsp;<img src=<%=(bean_phy.getObj().equalsIgnoreCase("BINC") && bean_phy.getOrder().equalsIgnoreCase("ASC") )?s1:s2%> alt="Descending Order" border=none></th>
				<%}%>
				<th  class='CAGROUP_HEADING' onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" name='UOM' style="WORD-BREAK:BREAK-ALL;cursor:pointer"><font size=1><b>
				<fmt:message key="Common.uom.label" bundle="${common_labels}"/></b></font>&nbsp;&nbsp;&nbsp;<img src=<%=(bean_phy.getObj().equalsIgnoreCase("UOM") && bean_phy.getOrder().equalsIgnoreCase("ASC") )?s1:s2%> alt="Descending Order" border=none></th>
				<th  class='CAGROUP_HEADING' ><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font></th>
				</tr>
				<%
							count	= start;
			        int chkCount = 0;
			       while ( count < maxRec && count < end)
			             {
								
								dataList = (HashMap)result.get(count);
							
								if ( count % 2 == 0 )
									classvalue = "QRYEVEN" ;
								else
								   classvalue = "QRYODD" ;
		             if(searchby.equals("D")) { 
					  curr_store	=(String)dataList.get("STORE_CODE");
					  if(!curr_store.equals(prev_store))
				{%>
				 <tr>
				<td colspan=8  
				class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/> : 
				</b><%=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")%></font>&nbsp;&nbsp;<font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :&nbsp;</b><%=CommonBean.checkForNull((String)dataList.get("ITEM_CODE"),"")%> &nbsp;&nbsp; <%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")%></font></td>
			
			</tr>
					<%}}%>
                <tr id='tr_<%=count%>'>
				<td class="<%=classvalue%>" ></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("EXPIRY_DATE_OR_RECEIPT_DATE"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
				<%if(searchby.equals("D")) {%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("SHORT_NAME"),"&nbsp;")%></font></td>
				<%}else{%>
				<td class="NODISPLAY" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("SHORT_NAME"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"&nbsp;")%></font></td>
				<%}%>
				<input type="hidden" name="trade_id<%=count%>" id="trade_id<%=count%>" value='<%=(String)dataList.get("TRADE_ID")%>'>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("MANUFACTURER_ID"),"&nbsp;")%></font></td>
				<%if(searchby.equals("D")) {%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_LOCATION_CODE"),"&nbsp;")%></font></td>
				<%}%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("SHORT_DESC"),"&nbsp;")%></font></td>
               <td  class="<%=classvalue%>"><input type="radio" name='radio' id='radio' value="<%=count%>" onClick='setValues(this);'></td>
			   </tr>
          <% 

					count++;
			       chkCount++;
				prev_store=curr_store;
				}
				
				%>
				</table>
				<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="start" id="start"					value="<%=start%>">
			<input type="hidden" name="end" id="end"						value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords"			value='<%=result.size()%>'>
			<input type="hidden" name="displaySize" id="displaySize"				value="<%=displaySize%>">
			<input type="hidden" name="multipleSelect" id="multipleSelect"			value="<%=multipleSelect%>">
			<input type="hidden" name="includeSuspendedBatches" id="includeSuspendedBatches" value="<%=includeSuspendedBatches%>">
			<input type="hidden" name="includeZeroStockBatches" id="includeZeroStockBatches" value="<%=includeZeroStockBatches%>">
			<input type="hidden" name="includeExpiredBatches" id="includeExpiredBatches"	value="<%=includeExpiredBatches%>">
            <input type="hidden" name="includeExpiredBatches" id="includeExpiredBatches"	value="Y">
			<input type="hidden" name="maxAllowed" id="maxAllowed"				value="<%=maxAllowed%>">
			<input type="hidden" name="count" id="count"					value="1">
			<input type="hidden" name="searchby" id="searchby"					value="<%=searchby%>">
				<%  out.flush();
		  }else{ %>

			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				//parent.window.close();
			 </script>
		<% 	} 

  	  }catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
putObjectInBean("PhysicalInventoryEntryBean",bean_phy,request);
%>
</body>
</form>
              
<script>activeLink();</script>

</html>

