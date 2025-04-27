<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../ePH/js/ConsumableOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<title><fmt:message key="ePH.PreferredSpecificItem.label" bundle="${ph_labels}"/></title>
<%
	try{
		String	bean_id			=	request.getParameter("bean_id");
		String	bean_name			=	request.getParameter("bean_name");
		ConsumableOrderBean bean		=	(ConsumableOrderBean)getBeanObject( bean_id, bean_name, request ) ;
		String	bl_disp_charge_dtl_in_drug_lkp_yn	=	bean.getDispChargeDtlInDrugLKPYN() == null ? "" : bean.getDispChargeDtlInDrugLKPYN();
		String	bl_disp_price_type_in_drug_lkp	=	bean.getDispPriceTypeinDrugLKPYN()	== null ? "" : bean.getDispPriceTypeinDrugLKPYN();
		String	bl_install_yn			=	bean.getBillInstallYN()	== null ? "" : bean.getBillInstallYN();
		String	item_desc			=	request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
		//String	order_type_code			=	request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
		String	priority			=	bean.getPriority() == null?"":bean.getPriority();		
		String  take_home_medication	= bean.getTakeHomeMedication() == null ?"":bean.getTakeHomeMedication();		
		
		item_desc = item_desc+"%";

		String	bl_preference_item_code		=			request.getParameter("bl_preference_item_code")==null?"":request.getParameter("bl_preference_item_code");
		String	bl_preference_priority		=			request.getParameter("bl_preference_priority")==null?"":request.getParameter("bl_preference_priority");

		//String facility_id					= (String) session.getValue("facility_id");
		ArrayList arrList	= (ArrayList)bean.getItemDetailsList_preferred(bl_preference_item_code,bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp,take_home_medication, priority,bl_preference_priority);
%>
		<body OnMouseDown='' onKeyDown = 'lockKey()'>
			<form name="frmItemNameCommonLookupResult" id="frmItemNameCommonLookupResult">
<%
				if(arrList!=null && arrList.size()>0){

					HashMap hmItemDetails= new HashMap();
					//added for the duplication check
					ArrayList existingList = bean.getPresItemList();
					ArrayList existingCodes = new ArrayList();
					if(existingList!=null && existingList.size()>0){
						for(int i=0; i<existingList.size(); i++){
							hmItemDetails = (HashMap)existingList.get(i);
							existingCodes.add(hmItemDetails.get("ITEM_CODE"));
						}
						hmItemDetails = null;
					}
					//end of duplication
					String classvalue = "";
					String disp_str = "";
					String item_code = "";
					String trade_code = "";
					String trade_name = "";
					String stock_yn = "";
					String avl_qty = "";
					String uom_code = "";
					String uom_desc = "";
					String store_code = "";
					String store_desc = "";
					String bl_reimburse_yn="";
					String bl_imported_yn = "";
					String bl_unit_price = "";
					String bl_sys_message_id = "";
					String bl_error_code="";
					String bl_error_text="";
					String strEnableDisable="";
%>
<br>
					<table border="1" width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td width="1%" class='COLUMNHEADER'>&nbsp;</td>
							<td width="50%" class='COLUMNHEADER'><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></td>
							 <td width="4%" class='COLUMNHEADER'>&nbsp;</td>
<%  
							if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
%>
								<td class="COLUMNHEADER" width="5%"><fmt:message key="ePH.Pay.label" bundle="${ph_labels}"/>
								</td>
								<td class="COLUMNHEADER" width="5%"><fmt:message key="Common.Reimburse.label" bundle="${common_labels}"/>
								</td>
								<td class="COLUMNHEADER" width="5%"><fmt:message key="ePH.National.label" bundle="${ph_labels}"/>
								</td>
								<td class="COLUMNHEADER" width="10%"><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/>
								</td>
<%
							}
%>
							<td class="COLUMNHEADER" width="10%"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
							<td class="COLUMNHEADER" width="10%"><fmt:message key="ePH.Quantity/Uom.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" width="4%"><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></td>
							</tr>
<%
							for (int i=0;i<arrList.size();i++){
								strEnableDisable = "";
								hmItemDetails = (HashMap)arrList.get(i);
								item_code			= (String)hmItemDetails.get("ITEM_CODE")==null?"":(String)hmItemDetails.get("ITEM_CODE"); 
								//added for the duplication check
								if(existingCodes.contains(item_code)){
									strEnableDisable = "disabled";
								}
								//end of duplication
								item_desc			= (String)hmItemDetails.get("ITEM_DESC")==null?"":(String)hmItemDetails.get("ITEM_DESC");        
								trade_code			= (String)hmItemDetails.get("TRADE_CODE")==null?"":(String)hmItemDetails.get("TRADE_CODE");       
								trade_name			= (String)hmItemDetails.get("TRADE_NAME")==null?"":(String)hmItemDetails.get("TRADE_NAME");       
								stock_yn			= (String)hmItemDetails.get("STOCK_YN")==null?"":(String)hmItemDetails.get("STOCK_YN");          
								avl_qty				= (String)hmItemDetails.get("AVAIL_QTY")==null?"0":(String)hmItemDetails.get("AVAIL_QTY"); 
								uom_code			= (String)hmItemDetails.get("UOM_CODE")==null?"":(String)hmItemDetails.get("UOM_CODE"); 
								uom_desc			= (String)hmItemDetails.get("UOM_DESC")==null?"":(String)hmItemDetails.get("UOM_DESC"); 
								store_code			= (String)hmItemDetails.get("STORE_CODE")==null?"":(String)hmItemDetails.get("STORE_CODE");           
								store_desc			= (String)hmItemDetails.get("STORE_DESC")==null?"":(String)hmItemDetails.get("STORE_DESC");           
								bl_reimburse_yn		= (String)hmItemDetails.get("BL_REIMBURSE_YN")==null?"":(String)hmItemDetails.get("BL_REIMBURSE_YN");     
								bl_imported_yn		= (String)hmItemDetails.get("BL_IMPORTED_YN")==null?"":(String)hmItemDetails.get("BL_IMPORTED_YN");    
								bl_unit_price		= (String)hmItemDetails.get("BL_UNIT_PRICE")==null?"":(String)hmItemDetails.get("BL_UNIT_PRICE");    
								bl_sys_message_id	= (String)hmItemDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)hmItemDetails.get("BL_SYS_MESSAGE_ID"); 
								bl_error_code		= (String)hmItemDetails.get("BL_ERROR_CODE")==null?"":(String)hmItemDetails.get("BL_ERROR_CODE");       
								bl_error_text		= (String)hmItemDetails.get("BL_ERROR_TEXT")==null?"":(String)hmItemDetails.get("BL_ERROR_TEXT");    
								

								if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										strEnableDisable = "disabled";
									}
								}

								if(hmItemDetails.get("STOCK_YN").equals("") || hmItemDetails.get("STOCK_YN").equals("N")){
%>
									<tr>
										<td class='INSUFFICIENTSTOCK' width='1%' title="<%=hmItemDetails.get("STORE_DESC")%>">&nbsp;</td>	
<%   
								}
								else { 
%>
									<tr>
										<td class='<%=classvalue%>' width='1%'></td>
<%
								}

								if(strEnableDisable.equals("")){
%>
									<td id="item<%=i%>" class="<%=classvalue%>" title="<%=store_desc%>" onclick="selectItem('<%=i%>');">
										<font class='HYPERLINK' onmouseover="changeCursor(this);" ><%=item_desc%></font>
<%
								}
								else{
%>
									<td id="item<%=i%>" class="<%=classvalue%>" title="<%=store_desc%>" onclick="disableClick(event);">
										<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);"><%= item_desc %>
										</label>
<%
								}
%>
									<input type="hidden" name="hdn_item_code<%=i%>" id="hdn_item_code<%=i%>" value="<%=item_code%>">
									<input type="hidden" name="hdn_line_no<%=i%>" id="hdn_line_no<%=i%>" value="<%=i%>">
									<input type="hidden" name="hdn_trade_code<%=i%>" id="hdn_trade_code<%=i%>" id="trade_code<%=i%>" value="<%=trade_code%>">
									<input type="hidden" name="hdn_trade_name<%=i%>" id="hdn_trade_name<%=i%>" value="<%=trade_name%>">
<%
									if(!trade_name.equals("")){
%>
										<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=trade_name%>)</label>
<%
									}
%>
							</td>
                        <td>
<!-- ============================================================================================================= -->
<%
						String fileName = bean.checkImageExists(item_code);
						if(!(fileName == null || fileName == ""))
						{
%>							
							<img src='../../ePH/images/camera.gif' width='17' height='15' title="Image" onclick = "showImage('<%=item_code%>','<%=trade_code%>');" onmouseover="changeCursor(this);">
<%
						}
						else{
%>
							&nbsp;
<%
						}
%>
									
<!-- ============================================================================================================= -->
					</td>
<%
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if(bl_unit_price.equals("")&& !bl_unit_price.equals("0")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}
%>
									<td class="<%=classvalue%>" align="center"><%=disp_str%>												
									</td>
<%
									if(bl_reimburse_yn.equals("")&& bl_reimburse_yn.equals("Y")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}
%>
									<td class="<%=classvalue%>" align="center"> <%=disp_str%>
									</td>
<%
									if(bl_imported_yn.equals("") && bl_imported_yn.equals("Y")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}
%>
									<td class="<%=classvalue%>" align="center"><%=disp_str%>
									</td>
<%
									if(!bl_unit_price.equals("")&& !bl_unit_price.equals("0")){
										disp_str = (String)hmItemDetails.get("BL_UNIT_PRICE") ;
									}
									else{
										disp_str = "&nbsp";

										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
										}
									}
%>
									<td class="<%=classvalue%>" align="center" title='' id='BL_ERROR<%=i%>'> <%=disp_str%>
									</td>
<%
									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										out.println("<script>dispTitle('"+bl_error_code+"','"+bl_error_text+"','"+bl_sys_message_id+"','"+i+"');</script>");
									}
								}
%>
								<td class="<%=classvalue%>" align="right" title="<%=store_desc%>"><font class='HYPERLINK' onmouseover="changeCursor(this);" ><label  onclick="displayStock('<%=item_code%>','<%=java.net.URLEncoder.encode(item_desc, "UTF-8")%>','<%=trade_code%>','<%=store_code%>','<%=java.net.URLEncoder.encode(store_desc, "UTF-8")%>','<%=uom_desc%>');"><%=avl_qty%>&nbsp;</label></font></td>
								<td class="<%=classvalue%>"><%=uom_desc%></td>
								<td class="<%=classvalue%>" align="center" >
									<input type="checkbox" name="chk_itemSelect<%=i%>" id="chk_itemSelect<%=i%>" value="" onClick="storeSelectedItem('<%=i%>','preferredDrug')" <%=strEnableDisable%>>
								</td>
							</tr>
<%
						}
%>
					</table>
					<br><br>
					<table  cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<TR>
						<TD COLSPAN="2"  class="white" align="right" ><input type="button" value="OK"  class="button"	onClick="returnAllSelectedDrugs_preferred()" name="selectPreferredItem" id="selectPreferredItem" disabled />
						 &nbsp;&nbsp; <input type="button" value="Close"  class="button"	onClick="parent.window.close()" /></TD>
					</TR>
<%
				}
				else if(arrList==null || arrList.size()<=0 || !arrList.get(0).equals("cancel")){
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					window.close();	
					</script>
<%
				} 
%>
				<input type="hidden" name="hdn_from" id="hdn_from" value="">
				<input type="hidden" name="hdn_to" id="hdn_to" value="">
				<input type="hidden" name="hdn_bean_id" id="hdn_bean_id" value="<%=bean_id%>">
				<input type="hidden" name="hdn_bean_name" id="hdn_bean_name" value="<%=bean_name%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="bl_disp_charge_dtl_in_drug_lkp_yn" id="bl_disp_charge_dtl_in_drug_lkp_yn" value="<%=bl_disp_charge_dtl_in_drug_lkp_yn%>">
				<input type="hidden" name="bl_disp_price_type_in_drug_lkp" id="bl_disp_price_type_in_drug_lkp" value="<%=bl_disp_price_type_in_drug_lkp%>">
				<input type="hidden" name="take_home_medication" id="take_home_medication" value="<%=take_home_medication%>">
				<input type="hidden" name="priority" id="priority" value="<%=priority%>">
				<input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>">
			</form>
		</body>
<%
	putObjectInBean(bean_id,bean,request); 
}
catch(Exception e){
	e.printStackTrace();
}
%>
</html>

