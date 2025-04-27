<!DOCTYPE html>
<%@ page import ="eST.BatchSearchBean,eCommon.Common.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*,java.text.NumberFormat,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
 <%
			request.setCharacterEncoding("UTF-8");
 			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<link rel="stylesheet" type ="text/css" href="../../eST/html/IeStyle.css"></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="Javascript" src="../../eST/js/BatchSearch.js"> </script>
 	    <script language="javascript" src="../../eST/js/StTransaction.js"></script>
        <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>
<%
	String from							=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String stlightgreen					=		"";
	BatchSearchBean bean				=		(BatchSearchBean) getBeanObject( "batchSearchBean","eST.BatchSearchBean",request );
	bean.setLanguageId(locale);

	String searchFunction				= 		bean.getSearchFunction() ;
	String multipleSelect				=		bean.getMultipleSelect() ;
	String includeSuspendedBatches		=		bean.getIncludeSuspendedBatches() ;
	String includeExpiredBatches		= 		bean.getIncludeExpiredBatches() ;
	String includeZeroStockBatches		=		bean.getIncludeZeroStockBatches() ;
	String maxAllowed					=		bean.getMaxAllowed() ;
	String p_list_all_trades_yn			=		request.getParameter( "p_list_all_trades_yn" )==null?"":request.getParameter( "p_list_all_trades_yn" ) ;
	  

	int maxRec							=		0; 
	int start							=		0;
	int end								=		0;
	int displaySize						=		0;
	int count							=		0;	
	String expiry_yn					=		"";
	int EWDays							=		0;

	String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
	String  classvalue					=		"";
	ArrayList result					=		new ArrayList();	
	HashMap dataList					=		null;

	String curr_item_store				=		"";
	String prev_item_store				=		"";
	String suspended					=		"";
	String stSQL						=		"";
	String item_code_from				=		"";
	String item_code_to					=		"";
	ArrayList alParameters	=	new ArrayList();
	ArrayList listRecord	=	new ArrayList();
	// Added By Rams 12/15/2009 For the Decimal CRF 537.1 Begins
	/* @Name - Rams
 * @Date - 12/15/2009
 * @Inc# - CRF 537.1
 * @Desc - For the Decimal related display
 */
  /** @Name - Priya
	* @Date - 01/02/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - To use common method, the previous coding has been removed
	*/
int no_of_decimals=bean.getNoOfDecimals(); 
	
	// Ends
	try{
			
				EWDays					=		bean.getEntityparam_EWDays(ACC_ENTITY_ID);
				//result					=		bean.getDataList();
     // Shaiju added to show the expired batches starts				
				if((bean.getCustomerID()).equals("MC")){
				
				item_code_from = bean.getItem_code_from();
				item_code_to = bean.getItem_code_to();
				alParameters.add(item_code_from);
				alParameters.add(item_code_to);
				alParameters.add(bean.getStore_code_from());
				alParameters.add(bean.getStore_code_to());
				//alParameters.add("PHINPS");
				alParameters.add(bean.getManufacturer_code());
				alParameters.add(bean.getIncludeZeroStockBatches());
				alParameters.add(bean.getIncludeExpiredBatches());
				alParameters.add(bean.getCuttOffDate());
				alParameters.add(bean.getPeriod_of_expiry());
				//alParameters.add("");
				alParameters.add(bean.getIncludeSuspendedBatches());
				alParameters.add(bean.getBatch_id());
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getTrade_Code());
				alParameters.add(bean.checkForNull(((String)((HashMap)bean.fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", bean.getStore_code_from())).get("FACILITY_ID")),bean.getLoginFacilityId()));			alParameters.add(bean.getDrugType());
				alParameters.add(bean.getItemClassFrom());
				alParameters.add(bean.getItemClassTo());
				stSQL		=		" SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  avail_qty avail_qty,expiry_yn,batch_status,SUSPENDED_YN  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty  >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(((?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,99999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                   FROM st_item   WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  (SELECT 'X' FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!')  AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
	
				//int no_of_decimals=getNoOfDecimals();
				String allow_decimals_yn="N";

				listRecord			=		bean.fetchRecords(stSQL.toString(),alParameters);
				if(item_code_from.equals(item_code_to)){
			allow_decimals_yn=bean.getAllowDecimalsYN(item_code_from);
			}
			for(int i=0;i<listRecord.size();i++){
			HashMap dataList_new		=		(HashMap)listRecord.get(i);
			if(!item_code_from.equals(item_code_to)){
			allow_decimals_yn=bean.getAllowDecimalsYN((String)dataList_new.get("ITEM_CODE"));
			}
			if(allow_decimals_yn.equals("Y")){
			dataList_new.put("AVAIL_QTY",bean.setNumber((String)dataList_new.get("AVAIL_QTY"),no_of_decimals));
			dataList_new.put("QTY_ON_HAND",bean.setNumber((String)dataList_new.get("QTY_ON_HAND"),no_of_decimals));
			}else{
			dataList_new.put("AVAIL_QTY",bean.setNumber((String)dataList_new.get("AVAIL_QTY"),0));
			dataList_new.put("QTY_ON_HAND",bean.setNumber((String)dataList_new.get("QTY_ON_HAND"),0));
			}
			dataList_new.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
			listRecord.set(i,dataList_new); 
			}  
			result = listRecord;
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

			**/
		//	DataList			=		listRecord;
				
				}
				else
				{
// Shaiju added to show the expired batches Ends
				
					result					=		bean.getDataList();
				}
				
				maxRec					=		result.size();
			
		
		if(!searchFunction.equals("Y")){

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
		}
		if(result.size() > 0 ){
		%>
			<form name="BatchsearchForm" id="BatchsearchForm">
			<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
			</div>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
			<tr>
	
				<th  class='CAGROUP_HEADING' ></font></th> 
				<th  class='CAGROUP_HEADING' ><font size=1><b><fmt:message key="eST.Expiry/ReceiptDate.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.TradeName.label" bundle="${mm_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.Manufacturer.label" bundle="${mm_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BinLocation.label" bundle="${mm_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="Common.uom.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></b></font></th>
			<%if(searchFunction.equals("Y")){%>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font></th>
			<%}%>
			</tr>
		<%
			count				=		start;
			int chkCount		=		0;

            if(!searchFunction.equals("Y")) {

			while ( count < maxRec && count < end)
			{
				dataList		=		(HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue  =		"QRYEVEN" ;
				else
					classvalue  =		"QRYODD" ;
					
				curr_item_store =		(String)dataList.get("ITEM_CODE")+(String)dataList.get("STORE_CODE");

			if(!curr_item_store.equals(prev_item_store))
				{
					
					        expiry_yn	=		(String)dataList.get("EXPIRY_YN");
					if(expiry_yn.equals("N")) 
							expiry_yn	=		"No";
					else if(expiry_yn.equals("Y")) 
							expiry_yn	=		"Yes";
			%>
			<%if(searchFunction.equals("Y")){%>
			<tr>
				<td colspan=10  
						class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> 
								<%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")%>&nbsp
									;&nbsp; <b><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/> : </b><%=expiry_yn%>&nbsp;&nbsp;<b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> : 
								</b><%=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")%>
				</font></td>
			</tr>
			<%}else{%>
			 <tr>
				<td colspan=9  class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> <%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")%>&nbsp;&nbsp;<b><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/> : </b><%=expiry_yn%>&nbsp;&nbsp; <b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> :</b> <%=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")%></b></font></td>
			</tr> 
			<%}%>
			<%}%>
			
		 <tr id="tr_<%=chkCount%>">
			<%
				
				stlightgreen		=		classvalue;
				String tool			=		"";
				String description	=		"";
				String expiry_date  =		(String)dataList.get("EXPIRY_DATE");
		
			//suspended=bean.isSuspendYN((String)dataList.get("STORE_CODE"),(String)dataList.get("ITEM_CODE"),(String)dataList.get("BATCH_ID"),(String)dataList.get("BIN_LOCATION_CODE"),(String)dataList.get("EXPIRY_DATE"));

			//Below code is commented and following is added by Archana Dhal on 11/26/2010 related to incident no. IN024566
     		//suspended=(String)dataList.get("SUSPENDED_YN");
			suspended = CommonBean.checkForNull((String)dataList.get("SUSPENDED_YN"),"");
	
			if((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes")){
					stlightgreen	=		"STLIGHTCREAM";
					tool			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExpiredBatch.label","st_labels");
					//tool			=		"Expired Batch";
					description		=		"E";
				}
				else if (suspended.equals("Y")) 
					{
							
							stlightgreen	=	"STLIGHTCREAM";
							 tool			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedBatch.label","st_labels");
							//tool			=	"Suspended Batch";
							description		=	"S";
							
				}
				else if (((String)dataList.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)dataList.get("NOD")) <= EWDays){
						
						stlightgreen		=	"STLIGHTCREAM";
						String  tool_expd	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expiringin.label","st_labels");
						String tool_days	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
						tool				=	tool_expd +(String)dataList.get("NOD")+tool_days;
						description			=	"E"+(String)dataList.get("NOD");												
					}

			 	 if (((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& (suspended.equals("Y")))
					 {
					stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Suspended&ExpiredBatch.label","st_labels");
					//tool					=	"Suspended & Expired Batch";
					description				=	 "S/E";
					}
                 String stBatchStatus		=	(String)dataList.get("BATCH_STATUS") ;
				
				 if( stBatchStatus .equals("C") ){
					
					stlightgreen			=	"STLIGHTCREAM";
					tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NotifiedBatch.label","st_labels");
					//tool					=	"Notified Batch";
					description				=	"C";
				 }

                if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C")){
					
					stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired&NotifiedBatch.label","st_labels");
					//tool					=	"Expired & Notified Batch";
					description				=	"E/C";

				 }
			 if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C"))&& (suspended.equals("Y")))
					 {
					 stlightgreen			=	"STLIGHTCREAM";
					 tool					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedExpiredNotifiedBatch.label","st_labels");
					//tool					=	"Suspended,Expired & Notified Batch";
					description				=	"S/E/C";
					}
			%>
				<%if(description.equals("")){%>
				 <td class="<%=classvalue%>" >&nbsp;</td>
				<%}else{%>
				<td class="<%=stlightgreen%>"  title= "<%=tool%> " 
				<%if(!description.equals("E")){%>
				style = "cursor:pointer" onClick="showHistory1(tr_<%=chkCount%>,<%=chkCount%>,<%=count%>);" 
				<%}%>
				><font  size = 1 ><B><%=description%></B></font>
				</td>
				<%}%>
				<td class="<%=classvalue%>" >
				
				<font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" >
				<%
				String batch_id=(String)dataList.get("BATCH_ID");
				boolean value=com.ehis.util.DateUtils.validDate(batch_id,"DMY",locale);
				if(value)
				{					
				%>
	             <font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("BATCH_ID"),"DMY","en",locale),"&nbsp;")%></font></td>
				<%
				}
				else
				{
				%>
			   <font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
			  <%
				}
				%>
						
				<td class="<%=classvalue%>" >
				<font size=1><%=CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")%></font>
				</td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("MANUFACTURER_NAME"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("UOM_DESC"),"&nbsp;")%></font></td>
				<!--
				* @Name - Priya
				* @Date - 01/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - Modified by priya as if the value of 'QTY_ON_HAND' & 'AVAIL_QTY' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so used the common method
				-->
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity on hand,AVAIL_QTY .				
					-->
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber(bean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0"),no_of_decimals)%></font>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber(bean.checkForNull((String)dataList.get("AVAIL_QTY"),"0"),no_of_decimals)%></font>&nbsp;</td>
				
				
				
				<%
					if(  ! searchFunction.equals("Y"))	
					{%>
						<td  class="NODISPLAY"><input type=checkbox onClick="return checkAllowed(this);" name="check<%=count%>" id="check<%=count%>"></font></td><input type=hidden name="batch_id<%=count%>" id="batch_id<%=count%>" value="<%=(String)dataList.get("BATCH_ID")%>">
						<input type=hidden name="item_code<%=count%>" id="item_code<%=count%>" value="<%=(String)dataList.get("ITEM_CODE")%>"><input type=hidden name="item_desc<%=count%>" id="item_desc<%=count%>" value="<%=(String)dataList.get("ITEM_DESC")%>"><input type=hidden name="store_code<%=count%>" id="store_code<%=count%>" value="<%=(String)dataList.get("STORE_CODE")%>"><input type=hidden name="store_desc<%=count%>" id="store_desc<%=count%>" value="<%=(String)dataList.get("STORE_DESC")%>"><input type=hidden name="trade_id_applicable_yn<%=count%>" id="trade_id_applicable_yn<%=count%>" value="<%=(String)dataList.get("TRADE_ID_APPLICABLE_YN")%>"><input type=hidden name="expiry_date<%=count%>" id="expiry_date<%=count%>" value="<%=com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale)%>"><input type=hidden name="bin_location_code<%=count%>" id="bin_location_code<%=count%>" value="<%=(String)dataList.get("BIN_LOCATION_CODE")%>"><input type=hidden name="bin_desc<%=count%>" id="bin_desc<%=count%>" value="<%=(String)dataList.get("BIN_DESC")%>"><input type=hidden name="trade_id<%=count%>" id="trade_id<%=count%>" value="<%=(String)dataList.get("TRADE_ID")%>"><input type=hidden name="trade_name<%=count%>" id="trade_name<%=count%>" value="<%=(String)dataList.get("TRADE_NAME")%>"><input type=hidden name="uom_code<%=count%>" id="uom_code<%=count%>" value="<%=(String)dataList.get("UOM_CODE")%>"><input type=hidden name="qty_on_hand<%=count%>" id="qty_on_hand<%=count%>" value="<%=(String)dataList.get("QTY_ON_HAND")%>"><input type=hidden name="nod<%=count%>" id="nod<%=count%>" value="<%=(String)dataList.get("NOD")%>"><input type=hidden name="manufacturer_id<%=count%>" id="manufacturer_id<%=count%>" value="<%=(String)dataList.get("MANUFACTURER_ID")%>"><input type=hidden name="manufacturer_name<%=count%>" id="manufacturer_name<%=count%>" value="<%=(String)dataList.get("MANUFACTURER_NAME")%>"><input type=hidden name="avail_qty<%=count%>" id="avail_qty<%=count%>" value="<%=(String)dataList.get("AVAIL_QTY")%>"><input type=hidden name="expiry_yn<%=count%>" id="expiry_yn<%=count%>" value="<%=bean.checkForNull((String)dataList.get("EXPIRY_YN"),"N")%>">
					<%}
				%>
			</tr>
		<%
				count++;
			chkCount++;
			prev_item_store		=		curr_item_store;
			}
			}
			else
            {
                while ( count < maxRec) {

				dataList		=		(HashMap)result.get(count);

				

				if ( count % 2 == 0 )
					classvalue	=		"QRYEVEN" ;
				else
					classvalue	=		"QRYODD" ;
					
				curr_item_store	=		(String)dataList.get("ITEM_CODE")+(String)dataList.get("STORE_CODE");
				if(!curr_item_store.equals(prev_item_store))
				{

						expiry_yn		=		(String)dataList.get("EXPIRY_YN");
					if(expiry_yn.equals("N")) 
						expiry_yn		=		"No";
					else if(expiry_yn.equals("Y")) 
						expiry_yn		=		"Yes";
			%>
			<%if(searchFunction.equals("Y")){%>
			<tr>
				<td colspan=10  
					class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> 
				<%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")%>&nbsp;&nbsp; <b>
				<fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/>  : </b><%=expiry_yn%>&nbsp;&nbsp;
				<b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> : 
				</b><%=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")%>
			</font></td>
			</tr>
			<%}else{%>

			 <tr>
				<td colspan=9  class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> <%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"")%>&nbsp;&nbsp;<b><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/>  : </b><%=expiry_yn%>&nbsp;&nbsp; <b><fmt:message key="Common.Store.label" bundle="${mm_labels}"/> :</b> <%=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"")%></b></font></td>
			</tr> 
			<%}%>
			<%}%>

			<%
				stlightgreen			=		classvalue;
				String tool				=		"";
				String description		=		"";
				String expiry_date		=		(String)dataList.get("EXPIRY_DATE");

				if((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes")){

					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExpiredBatch.label","st_labels");
				//	tool				=		"Expired Batch";
					description			=		"E";
				}
				else if (suspended.equals("Y")) 
					{
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedBatch.label","st_labels");
				//	tool				=		"Suspended Batch";
					description			=		"S";
				}
				else if (((String)dataList.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)dataList.get("NOD")) <= EWDays){
					stlightgreen		=		"STLIGHTCREAM";
					String	 tool_exp	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expiringin.label","st_labels");
					String  tool_ds		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
					tool				=		tool_exp+(String)dataList.get("NOD")+tool_ds;
					description			=		"E"+(String)dataList.get("NOD");												
					}


			 	 if (((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&& (suspended.equals("Y")))
					 {
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Suspended&ExpiredBatch.label","st_labels");
				//	tool				=		"Expired & Suspended Batch";
					description			=		"S/E";
					}

				String stBatchStatus	=		(String)dataList.get("BATCH_STATUS") ;

				 if( stBatchStatus .equals("C") ){
					
					stlightgreen		=		"STLIGHTCREAM";
					 tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NotifiedBatch.label","st_labels");
					//tool				=		"Notified Batch";
					description			=		"C";

				 }

			 if(((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C")){
					stlightgreen		=		"STLIGHTCREAM";
					 tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Expired&NotifiedBatch.label","st_labels");
					//tool				=		"Expired & Notified Batch";
					description			=		"E/C";
		 }
	 if((((!bean.isGreaterThanSysdate(expiry_date))&& expiry_yn.equals("Yes"))&&stBatchStatus.equals("C"))&& (suspended.equals("Y")))
					 {
					stlightgreen		=		"STLIGHTCREAM";
					tool				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SuspendedExpiredNotifiedBatch.label","st_labels");
				//	tool				=		"Suspended,Expired & Notified Batch";
					description			=		"S/E/C";
					}
			%>
		
			
		 <tr id="tr_<%=chkCount%>">
				<%if(description.equals("")){%>
				 <td class="<%=classvalue%>" >&nbsp;</td>
				<%}else{%>
				<td class="<%=stlightgreen%>" title= "<%=tool%>" 
				<%if(!description.equals("E")){%>
				style = "cursor:pointer"   onClick="showHistory(tr_<%=chkCount%>,<%=chkCount%>);" 
				 <%}%>
				><font   size=1><B><%=description%></B></font></td>
				<%}%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" >
				<%//System.err.println("(String)dataList	2--"+(String)dataList.get("BATCH_ID"));%>
				<font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("MANUFACTURER_NAME"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BIN_DESC"),"&nbsp;")%></font></td>
				 <td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("UOM_DESC"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0")%></font>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)dataList.get("AVAIL_QTY"),"0")%></font>&nbsp;</td>
				
				<%
					if(searchFunction.equals("Y"))	
					{
					%>
						<td  class="<%=classvalue%>"><input type=checkbox onClick="return checkAllowed(this);" name="check<%=count%>" id="check<%=count%>"></font></td>

						<input type=hidden name="batch_id<%=count%>" id="batch_id<%=count%>"				value="<%=(String)dataList.get("BATCH_ID")%>">
						<input type=hidden name="item_code<%=count%>" id="item_code<%=count%>"				value="<%=(String)dataList.get("ITEM_CODE")%>">
						<input type=hidden name="item_desc<%=count%>" id="item_desc<%=count%>"				value="<%=(String)dataList.get("ITEM_DESC")%>">
						<input type=hidden name="store_code<%=count%>" id="store_code<%=count%>"				value="<%=(String)dataList.get("STORE_CODE")%>">
						<input type=hidden name="store_desc<%=count%>" id="store_desc<%=count%>"				value="<%=(String)dataList.get("STORE_DESC")%>">
						<input type=hidden name="trade_id_applicable_yn<%=count%>" id="trade_id_applicable_yn<%=count%>"	value="<%=(String)dataList.get("TRADE_ID_APPLICABLE_YN")%>">
						<input type=hidden name="expiry_date<%=count%>" id="expiry_date<%=count%>"				value="<%=com.ehis.util.DateUtils.convertDate((String)dataList.get("EXPIRY_DATE"),"DMY","en",locale)%>">
						<input type=hidden name="bin_location_code<%=count%>" id="bin_location_code<%=count%>"		value="<%=(String)dataList.get("BIN_LOCATION_CODE")%>">
						<input type=hidden name="bin_desc<%=count%>" id="bin_desc<%=count%>"				value="<%=(String)dataList.get("BIN_DESC")%>">
						<input type=hidden name="trade_id<%=count%>" id="trade_id<%=count%>"				value="<%=(String)dataList.get("TRADE_ID")%>">
						<input type=hidden name="trade_name<%=count%>" id="trade_name<%=count%>"				value="<%=(String)dataList.get("TRADE_NAME")%>">
						<input type=hidden name="uom_code<%=count%>" id="uom_code<%=count%>"				value="<%=(String)dataList.get("UOM_CODE")%>">
						<input type=hidden name="qty_on_hand<%=count%>" id="qty_on_hand<%=count%>"				value="<%=(String)dataList.get("QTY_ON_HAND")%>">
						<input type=hidden name="nod<%=count%>" id="nod<%=count%>"						value="<%=(String)dataList.get("NOD")%>">
						<input type=hidden name="manufacturer_id<%=count%>" id="manufacturer_id<%=count%>"			value="<%=(String)dataList.get("MANUFACTURER_ID")%>">
						<input type=hidden name="manufacturer_name<%=count%>" id="manufacturer_name<%=count%>"		value="<%=(String)dataList.get("MANUFACTURER_NAME")%>">
						<input type=hidden name="avail_qty<%=count%>" id="avail_qty<%=count%>"				value="<%=(String)dataList.get("AVAIL_QTY")%>">
						<input type=hidden name="expiry_yn<%=count%>" id="expiry_yn<%=count%>"				value="<%=(String)dataList.get("EXPIRY_YN")%>">
					<%}
				%>
			</tr>
		<%
				count++;
			chkCount++;
			prev_item_store=curr_item_store;
			}
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
			
		<%
			out.flush();
		} 
		else
		{
			%>
			<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
           </script>
  
		<%
			 if(p_list_all_trades_yn.equals("N"))
		{%>
			 <script>
				parent.window.close();
			</script>
		<%
		}
		}
			


	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</body>
</form>
<% if(!searchFunction.equals("Y")) { %>
         <script>activeLink();</script>
 <% } %>

</html>

