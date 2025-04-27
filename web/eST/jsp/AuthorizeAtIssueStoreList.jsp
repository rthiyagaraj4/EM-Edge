<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
20/04/2017		63281			B.Badmavathi								     To display Available Quantity at Request Store 
20/10/2021		TFS-24350			Shazana					20/10/2021		Manickam				MO-CRF-20173
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eST.AuthorizeAtIssueStoreBean, eST.AuthorizeAtIssueStoreDetailBean,java.text.*,java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<html>
	<head>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
	</head>
	<%
		String bean_id							=			"authorizeAtIssueStoreBean";
		String bean_name						=			"eST.AuthorizeAtIssueStoreBean";
		String item_code						=			request.getParameter("item_code");
		String className						=			"";
		String prevObj							=			"";
		String prevColor						=			"";
		String prevSerColor						=			"";
		java.util.ArrayList alItemKeys			=			new java.util.ArrayList();
		java.util.ArrayList delListItems			=			new java.util.ArrayList();

		java.util.ArrayList alAddedItemKeys		=			null;
		java.util.HashMap hmItemStore			=			null;


		String mode								=			request.getParameter("mode");
		String function_id						=			request.getParameter("function_id");
		String itemStoreKey						=			"";
		AuthorizeAtIssueStoreBean bean			=			(AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
 	/**
	* @Name - Mahesh
	* @Date - 19/01/2010
	* @Inc# - IN015496
	* @Desc - No.of Decimals is storeed in a temp variable as this page displays more than one item at a time.
	*/
		int no_of_decimals_temp			=		bean.getNoOfDecimals();
		int no_of_decimals				=		0;
		alItemKeys.addAll(bean.getItemKeys());
		alAddedItemKeys							=			bean.getAddedItemKeys();
		if (alAddedItemKeys != null && alAddedItemKeys.size() >0) {
			alItemKeys.addAll(alAddedItemKeys);
		}
		hmItemStore								=		bean.getHmItemDetail();
		ArrayList	errorItems					=		bean.getKitErrorData();
		String severity							=		"";
		int i=0,j=1;
		String trObject							=		bean.checkForNull(request.getParameter("trObject"));
		String kit12							=		bean.checkForNull(request.getParameter("kit12"));
		double req_qty								=		0; 
		float unit_cost							=		0.0f;
		String stk_value						=		"0";
		String cost								=		"0";
		String	view_cost						=		bean.checkForNull((String)	bean.fetchRecord("select VIEW_COST_YN  from MM_VIEW_COST_FOR_USER where APPL_USER_ID=?",(String) session.getValue( "login_user" ) ).get("VIEW_COST_YN"),"N");
      
           try {
	        String[] strParameters = new String[3];
			
			strParameters[0] = bean.getDoc_no();
            strParameters[1] = bean.getDoc_type_code();
			strParameters[2] = CommonBean.getLoginFacilityId();
             delListItems = (ArrayList)bean.fetchRecords("SELECT distinct item_code FROM st_issue_dtl idtl, st_issue_hdr ihdr WHERE ihdr.doc_no = ? and  ihdr.doc_type_code = ? and ihdr.facility_id = ? and   ihdr.doc_no = idtl.doc_no AND ihdr.doc_type_code = idtl.doc_type_code AND ihdr.facility_id = idtl.facility_id AND ihdr.seq_no = idtl.seq_no AND ihdr.finalized_yn = 'D'",strParameters);
	
		   } catch (Exception ex)
		   {
		   ex.printStackTrace();
		   throw ex;
		   }

		   /**
			 * @Name - Priya
			 * @Date - 27/05/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
			int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
		boolean close_item_auth_appl=false;//MO-CRF-20173
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			close_item_auth_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST", "ST_CLOSE_ITEM_AT_AUTHORIZE");
			System.err.println("value for close_item_auth_appl: " + close_item_auth_appl);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in site specific " + e);
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, request);
		} //MO-CRF-20173 END
	%>
	<body >
		<form name='formAuthorizeAtIssueStoreList' id='formAuthorizeAtIssueStoreList'>
			<table border='1' width='100%' cellpadding='0' cellspacing='0'>
			<tr>
				<td class = "OARED">&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width='48%' class="LABEL">&nbsp; <fmt:message key="eST.BelowMinimumStockLevel.label" bundle="${st_labels}"/></td>
				<td class = "OAYELLOW">&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width='48%' class="LABEL">&nbsp; <fmt:message key="eST.BelowRe-OrderLevel.label" bundle="${st_labels}"/></td>
			</tr>
			</table>
			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0'>
 			<tr>
				<th width="2%"><fmt:message key="eST.S.label" bundle="${st_labels}"/></th>
				<%if(alItemKeys.size()>1){
					if(((String)bean.getTogglePoint()).equals("ASC")){
				%>
						<th onclick ="changeOrder();" width="22%" style="WORD-BREAK:BREAK-ALL;cursor:pointer"><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<img src="../../eST/images/Ascending.gif" alt="Ascending Order" border=none> </th>
					<%}else if(((String)bean.getTogglePoint()).equals("DESC")){%>
						<th onclick ="changeOrder();" width="22%" style="WORD-BREAK:BREAK-ALL;cursor:pointer"><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<img src="../../eST/images/Descending.gif" alt="Descending Order" border=none> </th>
					<%}else{%>
						<th onclick ="changeOrder();" width="22%" style="WORD-BREAK:BREAK-ALL;cursor:pointer"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				<%		}
				 }else{
				%>
					<th width="22%" style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				<%}%>
				<th width="6%"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
				<%if(view_cost.equals("Y")){%>
				<th width="6%"><fmt:message key="eST.Cost.label" bundle="${st_labels}"/></th>
				<th width="10%"><fmt:message key="eST.StockValue.label" bundle="${st_labels}"/></th>
				<%}%>
				<th width="10%"><fmt:message key="eST.CommittedQty.label" bundle="${st_labels}"/></th>
				<th width="10%"><fmt:message key="Common.IssuedQuantity.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="eST.AvlQtyatIssueStore.label" bundle="${st_labels}"/></th>
				<th width="8%"><fmt:message key="eST.AvlQtyatReqStore.label" bundle="${st_labels}"/></th><!-- Added for MMS-DM-CRF-0097  -->
				<th width="10%"><fmt:message key="eST.AuthorizeQuantity.label" bundle="${st_labels}"/></th>
 				 <!-- MO-CRF-20173 -->
 				<th width="10%"><fmt:message key="eST.CloseItem.label" bundle="${st_labels}"/></th>
 				
			</tr>
			<%
				int m = 0;
			String strCloseItemVal= ""; //MO-CRF-20173
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					 int totalSize = alItemKeys.size();
					m = totalSize-1;
					AuthorizeAtIssueStoreDetailBean detailBean;
					for (i=0,j=1;	i<totalSize;	i++,j++){
						//Mahesh Sorting
						if(((String)bean.getTogglePoint()).equals("ASC")){
							itemStoreKey = (String) bean.arTempCode.get(m);
							m--;
							//itemStoreKey = (String) alItemKeys.get(i);
						}
						else if(((String)bean.getTogglePoint()).equals("DESC"))
							itemStoreKey = (String) bean.arTempCode.get(i);
						else
							itemStoreKey	= (String) alItemKeys.get(i);
			
							detailBean		= (AuthorizeAtIssueStoreDetailBean) hmItemStore.get(itemStoreKey);
							strCloseItemVal = detailBean.getClose_item_yn();//MO-CRF-20173
							if(strCloseItemVal==null || strCloseItemVal.equals("")){
								strCloseItemVal = "N";
							}//MO-CRF-20173
							// Added for GHL-SCF-1097 starts						
							String 	item_desc = detailBean.getItem_desc();
							item_desc = item_desc.replaceAll(" ","%20");
							item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
							item_desc = item_desc.replaceAll("%2520","%20");		
							// Added for GHL-SCF-1097 ends
			/**
			 * @Name - Priya
			 * @Date - 23/06/2010
			 * @Inc# - 20890
			 * @Desc -  To get CONVERSION FACTOR
			 */
				double convFactorReqonStore=bean.getConvFactTemp(detailBean.getItem_code(),bean.getRequest_on_store());
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - If Decimals is allowed for that item, then No.of decimals is assigned to the variable else 0.
	*/
						if((bean.getAllowDecimalsYN((String)detailBean.getItem_code())).equals("Y")){
							no_of_decimals = no_of_decimals_temp;
						}else{
							no_of_decimals = 0;
						}
						if (detailBean != null) {
							className			=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
							if (detailBean.getSeverity_color().equals("HIGH")) {
								severity		=	"OARED";
							}
							else if (detailBean.getSeverity_color().equals("LOW")) {
								severity		=	"OAYELLOW";
							}
							else {
								severity		=	className;
							}
						String comm_qty =	bean.checkForNull(detailBean.getCommitted_item_qty(),"0");
					if(bean.getRequestStatus().equals("A") || bean.getRequestStatus().equals("P"))
					  
					  {
					   
					   if(!((comm_qty).equals("0")))
					    
					        {
                          
							detailBean.setIssuing_item_qty("0");  
						    
							}
					}

							if(!detailBean.getReq_on_min_stk_level().equals(""))
							{
							   if((Double.parseDouble(detailBean.getReq_on_qty_on_hand())*(bean.getConvFactTemp((String)detailBean.getItem_code(),(String)bean.getRequest_on_store())))<(Double.parseDouble(detailBean.getReq_on_min_stk_level())))
								{
								  								  
								  severity		=	"OARED";
								  
								}
							}
							if (item_code!=null){
								if (item_code.equals(detailBean.getItem_code())) {
									prevObj			=	""+i;
									prevColor		=	className;								
									prevSerColor	=	severity;								
									className		=	"STLIGHTPINK";

								}
							}
					double qty_diff =0;
					if (!detailBean.getReq_by_max_stk_level().equals(""))
						{
									double Max_by_qty=Double.parseDouble(detailBean.getReq_by_max_stk_level())*(bean.getConvFactTemp((String)detailBean.getItem_code(),(String)bean.getRequest_by_store()));
                                  
									qty_diff		= (Double.parseDouble(detailBean.getReq_by_qty_on_hand() )+Double.parseDouble(detailBean.getIssuing_item_qty())) - Double.parseDouble(""+Max_by_qty) ;
									//qty_diff = Integer.parseInt(detailBean.setNumber((""+qty_diff),3));
									
						}
					String kit						=	"";
					for(int k=0;k<errorItems.size();k++){
						if(((String)detailBean.getItem_code()).equals((String)errorItems.get(k))){
							kit = "kit";
							break;
						}
					}
					if(kit.equals("kit")){
					unit_cost = Float.parseFloat((String)bean.checkForNull(detailBean.getUnit_cost(),"0.0"));
					/**
					 * @Name - Priya
					 * @Date - 23/06/2010
					 * @Inc# - 20890
					 * @Desc -  To convert base qty to Issue Stock UOM Qty
					 */
					//req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"))/convFactorReqonStore;
					req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"));
					stk_value = bean.setNumber(""+unit_cost*req_qty,noOfDecimalsForCost);
					cost =bean.setNumber(""+unit_cost,noOfDecimalsForCost);
					
					detailBean.setIssuing_item_qty("0");
				
					%>
				<tr id="tr_<%=i%>">
					<td class="<%=severity%>" align='left'>
						<a name="a<%=i%>" id="a<%=i%>">&nbsp;&nbsp;</a>
					</td>
					<td class="<%=className%>"  align='left' style="WORD-BREAK:BREAK-ALL;" title="<%=detailBean.getItem_code()%>">
							<%=java.net.URLDecoder.decode(detailBean.getItem_desc(),"UTF-8")%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getReq_item_qty(),"0"),no_of_decimals)%>
					</td>
					<%if(view_cost.equals("Y")){%>
					<td class="<%=className%>" nowrap align='right'>
						<%=cost%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=stk_value%>
					</td>
				
					<%}%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getCommitted_item_qty(),"0"),no_of_decimals)%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getIssued_item_qty(),"0"),no_of_decimals)%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getPending_item_qty(),"0"),no_of_decimals)%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getReq_on_qty_on_hand(),"0"),no_of_decimals)%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.getReq_by_avail_qty(detailBean.getItem_code()) %><!-- Added for MMS-DM-CRF-0097  -->
					</td> 
					<%
					if (qty_diff > 0)
					{
					String exceec_stock_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels");
					String qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");
					%>
						<td class="<%=className%>"  Style = " COLOR : #F40000  " nowrap align='right' title ="<%=exceec_stock_level%><%=qty_diff%> <%=qty_legend%>"><B><%=bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)%></B>&nbsp; </td>
				<% }
					else
							{%>
							<td class="<%=className%>" nowrap align='right' ><%=bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)%>&nbsp; </td>
					<%	} %>


				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
					<input type="hidden" name="issuing_item_qty_<%=i%>" id="issuing_item_qty_<%=i%>" value="<%=detailBean.getIssuing_item_qty()%>">
					<%}else{
				%>
				
				<tr id="tr_<%=i%>">
					<td class="<%=severity%>" align='left'>
						<a name="a<%=i%>" id="a<%=i%>">&nbsp;&nbsp;</a>
					</td>
					<% if(detailBean.getCommitted_item_qty().equals("0")) {%>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='left' onClick="displayItemDetail(<%=i%>);" onMouseOver="changeCursor(this);" title="<%=detailBean.getItem_code()%>">
						
						<font class="HYPERLINK">
						<!--	<java.net.URLDecoder.decode(detailBean.getItem_desc(),"UTF-8")%>  commented against GHL-SCF-1097 -->
							<%=detailBean.getItem_desc()%>
						</font>
					 <%  } if(!(detailBean.getCommitted_item_qty().equals("0")) || delListItems.contains(detailBean.getItem_code()) ) { %>
					 <td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='left' onClick="" onMouseOver="" title="<%=detailBean.getItem_code()%>">
					<!--	<java.net.URLDecoder.decode(detailBean.getItem_desc(),"UTF-8")%>  commented against GHL-SCF-1097 -->
					   <%=detailBean.getItem_desc()%>
					   <% } %>
					</td>
					<%
					unit_cost = Float.parseFloat((String)bean.checkForNull(detailBean.getUnit_cost(),"0.0"));
					/**
					 * @Name - Priya
					 * @Date - 23/06/2010
					 * @Inc# - 20890
					 * @Desc -  To convert base qty to Issue Stock UOM Qty
					 */
					//req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"))/convFactorReqonStore;
					//Added against inc#50521 
					req_qty =	Double.parseDouble((String)bean.checkForNull(detailBean.getReq_item_qty(),"0"));
					stk_value =bean.setNumber(""+(unit_cost*req_qty),noOfDecimalsForCost);
					cost =bean.setNumber(""+unit_cost,noOfDecimalsForCost);
					
					%>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getReq_item_qty(),"0"),no_of_decimals)%>
					</td>
					<%if(view_cost.equals("Y")){%>
					<td class="<%=className%>" nowrap align='right' title="<%=unit_cost%>">
						<%=cost%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=stk_value%>
					</td>
				       
					<%
					}%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getCommitted_item_qty(),"0"),no_of_decimals)%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getIssued_item_qty(),"0"),no_of_decimals)%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
						<%=bean.setNumber(bean.checkForNull(detailBean.getPending_item_qty(),"0"),no_of_decimals)%>
					</td>
					<td class="<%=className%>" nowrap align='right'>
					<%=bean.setNumber(bean.checkForNull(""+(Double.parseDouble(detailBean.getReq_on_qty_on_hand()))),no_of_decimals)%>
					</td>
					 <td class="<%=className%>" nowrap align='right'>
						<%=bean.getReq_by_avail_qty(detailBean.getItem_code()) %><!-- Added for MMS-DM-CRF-0097  --> 
					</td>
					<%
					if (qty_diff > 0)
					{
					String exceec_stock_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels");
					String qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");
					%>
						<td class="<%=className%>"  Style = " COLOR : #F40000  " nowrap align='right' title ="<%=exceec_stock_level%><%=qty_diff%> <%=qty_legend%>"><B><%=bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)%></B>&nbsp; </td>
				<% }
					else
							{%>
							<td class="<%=className%>" nowrap align='right' ><%=bean.setNumber(bean.checkForNull(detailBean.getIssuing_item_qty(),"0"),no_of_decimals)%>&nbsp; </td>
					<%	} %>
					<!-- MO-CRF-20173 -->
 					<td class="<%=className%>" nowrap align='right'>
						<%
					if(detailBean.getClose_item_yn().equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");  
				%>
						
					</td>

				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
					<input type="hidden" name="issuing_item_qty_<%=i%>" id="issuing_item_qty_<%=i%>" value="<%=detailBean.getIssuing_item_qty()%>">
				<%
					}}
				}
			}
			%>
			</table>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
			<input type="hidden" name="totalRecords" id="totalRecords"			value="<%=i%>">
			<input type="hidden" name="records" id="records"					value="<%=j%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"  value="">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%=function_id%>">
			<input type="hidden" name="doc_type_code" id="doc_type_code"			value="">
			<input type="hidden" name="doc_no" id="doc_no"					value="">
			<input type="hidden" name="doc_date" id="doc_date"				value="">
			<input type="hidden" name="doc_ref" id="doc_ref"					value="">
			<input type="hidden" name="request_by_store" id="request_by_store"		value="">
			<input type="hidden" name="request_on_store" id="request_on_store"		value="">
			<input type="hidden" name="item_class_code" id="item_class_code"			value="">
			<input type="hidden" name="finalize_yn" id="finalize_yn"				value="">
			<input type="hidden" name="autono_yn" id="autono_yn"				value="">
			<input type="hidden" name="view_cost" id="view_cost"				value="<%=view_cost%>">
			<input type="hidden" name="locale" id="locale"				value="<%=locale%>"> 

<%	
	putObjectInBean(bean_id,bean,request);
%>
		</form>
	</body>
<%if(trObject.length() > 1){%>
<% } %>

<%if (item_code!=null) {
	if(kit12.equals("kit12")){
	%>

<script language="JavaScript">
	statusOfItem();
	<%
		}
	%>
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
	prevObj=document.getElementById('tr_<%=prevObj%>')
	prevColor="<%=prevColor%>";
	prevSerColor="<%=prevSerColor%>";
	// Commented by Sakti and passed prevObj index instead of item code. Problem happening if item_code is having "-" and "."
	//document.getElementById("a")<%=item_code%>.scrollIntoView();
	//document.getElementById("a")<%=item_code%>.scrollIntoView();
	document.getElementById('a<%=prevObj%>').scrollIntoView();
	document.getElementById('a<%=prevObj%>').scrollIntoView(); 
</script>
<%}%>
</html>

