<!DOCTYPE html>
<!-- 
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/02/2017	IN061750		Shazana													ML-MMOH-SCF-0946		
-------------------------------------------------------------------------------------------------------------------------------
*/
 -->


<%@ page import="eST.RequestBean, eST.RequestDetailBean,java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=   (String)session.getAttribute("LOCALE");
		String sStyle			=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/Request.js"></script>
</head>
	<%
		String bean_id					=		"requestBean";
		String bean_name				=		"eST.RequestBean";
		String checked					=		"";
		String disabled					=		"";
		String className				=		"";

		java.util.ArrayList alItemKeys  =		new java.util.ArrayList();
		java.util.HashMap hmItemStore   =		null;
		String mode						=		request.getParameter("mode");
		String function_id				=		request.getParameter("function_id");
		String kit12					=		(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
		String itemStoreKey				=		"";
		RequestBean bean				=		(RequestBean) getBeanObject(bean_id,bean_name, request  ); 
		bean.setLanguageId(locale);
		String strOrderBy=CommonBean.checkForNull((String)bean.getTogglePoint());
		String item_desc = "";
		String reset_mode						=		CommonBean.checkForNull(request.getParameter("reset_mode"));
		
		
		if(reset_mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			bean.initialize();
		}
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No.of Decimals is storeed in a temp variable as this page displays more than one item at a time.
	*/
		//int no_of_decimals_temp			=		bean.getNoOfDecimals();
		int no_of_decimals				=		0;

		ArrayList sortedKeys = (ArrayList)bean.sortList();
		if (sortedKeys != null && sortedKeys.size() >0) {
			alItemKeys.addAll(sortedKeys);
		}else{
			for(int i=0;i<bean.getItemKeys().size();i++) {
				alItemKeys.add(bean.getItemKeys().get(i));	
			} 
		
			java.util.ArrayList newKeys = bean.getItemKeysAdded();

			if (newKeys != null && newKeys.size() >0) {
				alItemKeys.addAll(newKeys);
			}
		}
		hmItemStore						=		bean.getHmItemDetail();
		
		int i							=		0;
		//Added for ML-MMOH-SCF-0946 starts 
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_CREATE_REQUEST_REQ_UOM");
		bean.setSite_spec_yn(site_main);
		System.out.println("site_main: "+site_main);
		//Added for ML-MMOH-SCF-0946 ends
	%>
	<body >
		<form name='formRequestList' id='formRequestList'>
		<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
			</div>
			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' >
 				<tr>
					<th width='2%'><fmt:message key="eST.S.label" bundle="${st_labels}"/></th>
					<th width='3%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
					<%if(alItemKeys.size()>1){
					if(strOrderBy.equals("ASC")){
					%>
					<th onclick ="changeOrder('DESC');" style="WORD-BREAK:BREAK-ALL;cursor:pointer"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp; <img src="../../eST/images/Descending.gif" alt="Descending Order" border=none></th>
					<%}else if(strOrderBy.equals("DESC")){%>
					<th onclick ="changeOrder('ASC');" style="WORD-BREAK:BREAK-ALL;cursor:pointer"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp; 
					<img src="../../eST/images/Ascending.gif" alt="Ascending Order" border=none></th>
					<%}else{%>
					<th onclick ="changeOrder('ASC');" style="WORD-BREAK:BREAK-ALL;cursor:pointer"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
					<%		}
					 }else{
					%>
					<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
					<%}%>
					<th nowrap><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></th>
					<th nowrap><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>
					<th nowrap><fmt:message key="eST.MaxStockLevel.label" bundle="${st_labels}"/> </th>
					<th nowrap><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
					<th nowrap><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
				</tr>
					<%
					String item_codeindex						=			request.getParameter("index");
					String prevTRObj="";
					if (alItemKeys != null && (alItemKeys.size()>0)) {
					
					int totalSize			=		alItemKeys.size();
					for (i=0;	i<totalSize;	i++){
						itemStoreKey		=		(String) alItemKeys.get(i);
						
						RequestDetailBean detailBean = (RequestDetailBean) hmItemStore.get(itemStoreKey); 
			 
			 String  pur_uom_code    =	  detailBean.getPurUomCode();			
			 String pur_uom_desc	 =    bean.getReqUomDesc(pur_uom_code);
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - If Decimals is allowed for that item, then No.of decimals is assigned to the variable else 0.
	*/
						if((detailBean.getDec_allowed_yn()).equals("Y")){
							no_of_decimals = detailBean.getNo_of_decimals();
						}else{
							no_of_decimals = 0;
						}
						if (detailBean != null){

                          if( (detailBean.getCheck_box_status()).equals("Y") )
							  checked		=		"checked" ;
						  else
						      checked		=		"" ;

                         
							  className		=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
						if (item_codeindex!=null){
								if (item_codeindex.equals(detailBean.getItem_code())) {
									prevTRObj			=	""+i;
								}
							}
						double qty_diff		=		0;

						if (!detailBean.getMax_stk_qty().equals(""))
						{
						
						  double Max_by_qty =Double.parseDouble(detailBean.getMax_stk_qty())*(bean.getConvFactTemp((String)detailBean.getItem_code(),(String)bean.getRequest_by_store()));

							qty_diff		= (Double.parseDouble(detailBean.getQty_on_hand() )+Double.parseDouble(detailBean.getRequired_qty())) - Max_by_qty ;
						 
						
						}
						
						 
						
						
			 // String kit_usage_type = bean.checkForNull((String)bean.getUsageType((String)detailBean.getKitTemp_code(),(String)detailBean.getItem_code()));
		      String kit_usage_type = bean.checkForNull((String)detailBean.getUsagetype());
			  
			  if(kit_usage_type.equals("R")){
			    checked   ="checked";
			    disabled  = "disabled";			    
			   }
			   else if(kit_usage_type.equals("O")){
			      checked   ="checked";
			      disabled = "";
			    }
			    else if(kit_usage_type.equals("P")){
			    checked   ="";
			    disabled = "";
			    }
			    else if(kit_usage_type.equals("D")){
				checked   ="";
			    disabled = "disabled";
				}else{
				  checked   ="checked";
			      disabled = "";
				}
				//Added by Rabbani #Inc no:39550(AAKH-SCF-0050) on 06-JUN-2013
				if((detailBean.getCheck_box_status()).equals("")){
				checked   ="";
				disabled  = "disabled";	
				}
				 
				//ends

				//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
				
				HashMap hmRecord	=	null;
				String spcfn_img_display;
				hmRecord = bean.getItemSpecfnRemarks(bean.checkForNull(detailBean.getItem_code()),bean.getLanguageId());
				String item_specfin_name = CommonBean.checkForNull((String)hmRecord.get("ITEM_SPECIFICATION"),"");
				String item_remarks = CommonBean.checkForNull((String)hmRecord.get("ITEM_REMARKS"),"");
				spcfn_img_display="display:inline";
				if(item_specfin_name.equals("") && item_remarks.equals("")) {
					spcfn_img_display="display:none";
				}
				
				if(!item_specfin_name.equals("")){
					item_specfin_name = item_specfin_name.replaceAll(" ","%20");
					item_specfin_name = java.net.URLEncoder.encode(item_specfin_name,"UTF-8");
					item_specfin_name = item_specfin_name.replaceAll("%2520","%20");
				}
				if(!item_remarks.equals("")){
					item_remarks = item_remarks.replaceAll(" ","%20");
					item_remarks = java.net.URLEncoder.encode(item_remarks,"UTF-8");
					item_remarks = item_remarks.replaceAll("%2520","%20");
				}
				
		//Added ends
					// This is added by Ganga for ML-BRU-SCF-0963 42099	 			
					item_desc = detailBean.getItem_desc();
					//item_desc = java.net.URLDecoder.decode(item_desc,"UTF-8"); //commented for  [IN:055189]
					item_desc = item_desc.replaceAll(" ","%20");
					item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
					item_desc = item_desc.replaceAll("%2520","%20");

					if((detailBean.getCheck_box_status()).equals("")){
						String avail_stock	=	bean.checkForNull((String)detailBean.getAvailable_stock(),"0");
						String required_qty =	bean.checkForNull((String)detailBean.getRequired_qty(),"0");
						
		
						
						%>
				<tr id="tr_<%=i%>">
					<td	class="<%=(Double.parseDouble(avail_stock)-Double.parseDouble(required_qty)<0)?"OARED":className%>"				title="<%=(Double.parseDouble(avail_stock)-Double.parseDouble(required_qty)<0)?"Insufficient Stock":""%>">&nbsp;</td>
					<td class="<%=className%>" nowrap align='center'><input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=itemStoreKey%>" <%=disabled%> <%=checked%> onClick="updateCheckStatus(this);"></td>
					<td id="a_<%=i%>" class="<%=className%>" nowrap  align='left'> <%=detailBean.getItem_code()%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='left'><%=detailBean.getItem_desc()%>&nbsp;<a style='<%=spcfn_img_display%>;'href="javascript:callItemSpcfnWindow('<%=detailBean.getItem_code()%>',document.formRequestList.item_desc_<%=i%>);"><img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_desc%>');"   onMouseout="onMOut(msg);"   src='../../eST/images/info.gif' alt="Item Remarks/Specification"  ></img></a>
					<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" ></td>
					<td class="<%=className%>" nowrap align='left'><%=bean.checkForNull(detailBean.getUomDesc(),"&nbsp;")%></td>
					<td class="<%=className%>" nowrap align='center'><%=bean.getImage(detailBean.getStock_item_yn())%></td>
					<td class="<%=className%>" nowrap align='right'><%=detailBean.getQty_on_hand().equals(" ")?"&nbsp;": detailBean.getQty_on_hand()%></td>
					<td class="<%=className%>" nowrap align='right'>&nbsp;<%=detailBean.getMax_stk_qty().equals(" ")?"&nbsp;": detailBean.getMax_stk_qty()%></td>
				<%
					if (qty_diff > 0)
					{
					String exceec_stock_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels");
					String qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");%>
					
					<!-- ADDED FOR ML-MMOH-0979 START -->
					<% if(site_main) { %>
					
 					<td class="<%=className%>"  Style = " COLOR : #F40000  " nowrap align='right' title ="<%=exceec_stock_level%> <%=qty_diff%> <%=qty_legend%>"><B><%=bean.checkForNull(detailBean.getReqUomQty(),"&nbsp;")%></B>&nbsp; </td>  					
 					<% } else { %>
					 <td class="<%=className%>"  Style = " COLOR : #F40000  " nowrap align='right' title ="<%=exceec_stock_level%> <%=qty_diff%> <%=qty_legend%>"><B><%=bean.checkForNull(detailBean.getRequired_qty(),"&nbsp;")%></B>&nbsp; </td>  
					<% } %>					
					<!-- ADDED FOR ML-MMOH-0979 end -->
					
					
					
				<% }
					else 
				{ %>
				
				<!-- ADDED FOR ML-MMOH-0979 START -->
				<%if(site_main){ %>
				
 					 <td class="<%=className%>" nowrap align='right' ><%=bean.checkForNull(detailBean.getReqUomQty(),"&nbsp;")%>&nbsp; </td> 
				<%} else { %>
				
				 <td class="<%=className%>" nowrap align='right' ><%=bean.checkForNull(detailBean.getRequired_qty(),"&nbsp;")%>&nbsp; </td> 
				<%} %>
				<!-- ADDED FOR ML-MMOH-0979 end-->
				
				<%	} %>

 					
 				<!-- ADDED FOR ML-MMOH-SCF-0946 STARTS-->
				<%if(site_main){ %>
				<td class="<%=className%>" nowrap align='right'><%=pur_uom_desc%></td>
				<%}else { %>
				<td class="<%=className%>" nowrap align='right'><%=bean.checkForNull(detailBean.getUomDesc())%></td>
				<%} %>
				<!-- ADDED FOR ML-MMOH-SCF-0946 ENDS-->
					
				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
				<%
					}else{
				%>
				<tr id="tr_<%=i%>">
					<td	class="<%=(Double.parseDouble(bean.checkForNull((String)detailBean.getAvailable_stock(),"0"))-Double.parseDouble((String)detailBean.getRequired_qty())<0)?"OARED":className%>"  title="<%=(Double.parseDouble(bean.checkForNull((String)detailBean.getAvailable_stock(),"0"))-Double.parseDouble((String)detailBean.getRequired_qty())<0)?"Insufficient Stock":""%>">&nbsp;	</td>
					<td class="<%=className%>" nowrap align='center'><input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=itemStoreKey%>" <%=disabled%> <%=checked%> onClick="updateCheckStatus(this);"></td>
					<td id="a_<%=i%>" class="<%=className%>" nowrap align='left' onClick="displayItemDetail(<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=detailBean.getItem_code()%></font></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='left'><%=detailBean.getItem_desc()%>&nbsp;<a style='<%=spcfn_img_display%>;' href='javascript:callItemSpcfnWindow("<%=detailBean.getItem_code()%>",document.formRequestList.item_desc_<%=i%>);'><img onmouseover='onMOver(msg,event,"<%=item_specfin_name%>","<%=item_remarks%>","<%=item_desc%>");'   onMouseout="onMOut(msg);"    src='../../eST/images/info.gif' ></img></a>
					<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" ></td>
					<td class="<%=className%>" nowrap align='left'><%=bean.checkForNull(detailBean.getUomDesc(),"&nbsp;")%></td>
					<td class="<%=className%>" nowrap align='center'><%=bean.getImage(detailBean.getStock_item_yn())%></td>
					<td class="<%=className%>" nowrap align='right'><%=detailBean.getQty_on_hand().equals(" ")?"&nbsp;": bean.setNumber(detailBean.getQty_on_hand(),no_of_decimals)%></td>
					<td class="<%=className%>" nowrap align='right'><%=detailBean.getMax_stk_qty().equals("")?"&nbsp;": detailBean.getMax_stk_qty()%></td>
				<%
					if (qty_diff > 0)
					{
					String exceec_stock_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.exceedmaxStockLevel.label","st_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels");
					String qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");%>
					
					<!-- ADDED FOR ML-MMOH-0979 START -->
					<% if(site_main) { %>
					
					<td class="<%=className%>"  Style = " COLOR : #F40000  " nowrap align='right' title ="<%=exceec_stock_level%> <%=qty_diff%> <%=qty_legend%>"><B><%=bean.checkForNull(bean.setNumber(detailBean.getReqUomQty(),no_of_decimals),"&nbsp;")%></B>&nbsp; </td>
					<% } else { %>
					<td class="<%=className%>"  Style = " COLOR : #F40000  " nowrap align='right' title ="<%=exceec_stock_level%> <%=qty_diff%> <%=qty_legend%>"><B><%=bean.checkForNull(bean.setNumber(detailBean.getRequired_qty(),no_of_decimals),"&nbsp;")%></B>&nbsp; </td>
					<% } %>					
					<!-- ADDED FOR ML-MMOH-0979 end -->
					
				<% }
					else
				{
						//added for ML-MMOH-0979 START
						if(site_main){
				%>
					<td class="<%=className%>" nowrap align='right' ><%=bean.checkForNull(bean.setNumber(detailBean.getReqUomQty(),no_of_decimals),"&nbsp;")%>&nbsp; </td>
				<% }else { %>
				
				<td class="<%=className%>" nowrap align='right' ><%=bean.checkForNull(bean.setNumber(detailBean.getRequired_qty(),no_of_decimals),"&nbsp;")%>&nbsp; </td>
				
				<% } %>
				
				<%	} %> <!--  added for ML-MMOH-0979 END -->
					
				<!-- ADDED FOR ML-MMOH-SCF-0946 STARTS-->
				<%if(site_main){ %>
				<td class="<%=className%>" nowrap align='right'><%=pur_uom_desc%></td>
				<%}else { %>
				<td class="<%=className%>" nowrap align='right'><%=bean.checkForNull(detailBean.getUomDesc())%></td>
				<%} %>
				<!-- ADDED FOR ML-MMOH-SCF-0946 ENDS-->
				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
				<%
					}
				}
				}
			}
			%>
			</table>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"			value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden" name="doc_type_code" id="doc_type_code"				value="">
			<input type="hidden" name="doc_no" id="doc_no"						value="">
			<input type="hidden" name="doc_date" id="doc_date"					value="">
			<input type="hidden" name="doc_ref" id="doc_ref"						value="">
			<input type="hidden" name="request_by_store" id="request_by_store"			value="">
			<input type="hidden" name="request_on_store" id="request_on_store"			value="">
			<input type="hidden" name="item_class_code" id="item_class_code"				value="">
			<input type="hidden" name="finalize_yn" id="finalize_yn"					value="">
			<input type="hidden" name="autono_yn" id="autono_yn"					value="">
			<input type="hidden" name="request_type" id="request_type"				value="">
		</form>
	<!-- Added for ML-MMOH-SCF-0946 START -->	
		<%	
	if(con != null)
		ConnectionManager.returnConnection(con,request);
%>
<!--Added for ML-MMOH-SCF-0946 END --> 
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
<%
	if(kit12.equals("kit")){
%>
	<script>
	//Commented by Rabbani #Inc no:39550(AAKH-SCF-0050) on 06-JUN-2013
		//setTimeout("parent.RequestDetailFrame.kitNextItemValidate();",100);//example1();
		  //example1();
	</script>
<%}
		if (request.getParameter("index")!=null  && !(kit12.equals("kit"))) {%>
<script language="JavaScript">
	// Commented by Sakti and passed prevTRObj index instead of item code . Here request.getParameter("index") is coming item_code
	//document.getElementById("a_")<%=(request.getParameter("index"))%>.scrollIntoView(); 
	document.getElementById("a_"+<%=prevTRObj%>).scrollIntoView();
	changeRowColor(document.getElementById("tr_"+<%=prevTRObj%>));	 
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</html> 



