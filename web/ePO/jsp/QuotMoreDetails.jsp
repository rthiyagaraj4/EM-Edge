<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,ePO.QuotationDetailBean,ePO.QuotationBean" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.MoreDetails.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/Quotation.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			//function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body >
<%
QuotationDetailBean requestDetail;
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String supp_code						=				request.getParameter("supp_code");
	String po_mode							=				request.getParameter("po_mode");
	String item_desc						=				request.getParameter("item_desc");
	String item_code						=				request.getParameter("item_code");
	String quot_uom_desc				=				request.getParameter("temp_uom");
	String quot_uom_code				=				request.getParameter("temp_uom_code");
	String quot_qty						=				request.getParameter("quot_qty");
	
	String delv_freq_type = "";
	String no_of_delv = "";
	String first_delv_dt = "";
	String eq_shipment = "";
	String catalogue_no = "";
	String origin_country =  "";
	String item_remarks = "";
	String replace_type = "";
	String sample_type = "";
	String sample_qty = "";
	String trade_id = "";
	String manufactur_id = "";
	String item_specification = "";
	
	QuotationBean bean						=				(QuotationBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date								=			bean.getSystemDate();

	
	System.out.println("bean.getItemRecords(item_code) = "+bean.getItemRecords(item_code));
		if(bean.getItemRecords(item_code) != null){
			ArrayList al = bean.getItemRecords(item_code);
			  for (int j=0;j<al.size();j++) {
				HashMap hm = (HashMap)al.get(j);
							
					item_specification = bean.checkForNull((String)hm.get("ITEM_SPECIFICATION"));
					replace_type = bean.checkForNull((String)hm.get("REPLACE_TYPE"));
					sample_type = bean.checkForNull((String)hm.get("SAMPLE_TYPE"));
					manufactur_id = bean.checkForNull((String)hm.get("MANUFACTURER_ID"));
					trade_id = bean.checkForNull((String)hm.get("TRADE_ID"));
					sample_qty = bean.checkForNull((String)hm.get("SAMPLE_QTY"));
					delv_freq_type = bean.checkForNull((String)hm.get("DELV_FREQ_TYPE"));
					no_of_delv = bean.checkForNull((String)hm.get("NO_OF_DELV"));
					first_delv_dt = bean.checkForNull((String)hm.get("FIRST_DELV_DT"));
					eq_shipment = bean.checkForNull((String)hm.get("EQ_SHIPMENT"));
					catalogue_no = bean.checkForNull((String)hm.get("CATALOGUE_NO"));
					origin_country =  bean.checkForNull((String)hm.get("ORIGIN_COUNTRY"));
					item_remarks = bean.checkForNull((String)hm.get("ITEM_REMARKS"));
					bean.setPlaceOfOrigin(origin_country);
				}	
			}else{
					requestDetail					=			bean.getItemDetail(item_code);
					System.out.println("requestDetail in details = "+requestDetail);
				if(requestDetail != null){	
					
					item_specification			    =			bean.checkForNull(requestDetail.getItem_specification());
					replace_type					=			bean.checkForNull(requestDetail.getReplace_type());
					sample_type						=			bean.checkForNull(requestDetail.getSample_type());
					manufactur_id					=			bean.checkForNull(requestDetail.getManufactur_id());
					trade_id 						= 			bean.checkForNull(requestDetail.getTrade_id());
					sample_qty 						= 			bean.checkForNull(requestDetail.getSample_qty());
					delv_freq_type					=			bean.checkForNull(requestDetail.getDelv_freq_type());
					no_of_delv						=			bean.checkForNull(requestDetail.getNo_of_delv());
					first_delv_dt					=			bean.checkForNull(requestDetail.getFirst_delv_date());
					eq_shipment						=			bean.checkForNull(requestDetail.getEq_shipment());
					catalogue_no					=			bean.checkForNull(requestDetail.getCatalogue_no());
					origin_country				    =			bean.checkForNull(requestDetail.getOrigin_country());
					item_remarks					=			bean.checkForNull(requestDetail.getItem_remarks());
					bean.setPlaceOfOrigin(origin_country);
				}
			}
						
				
			
				String shipmentYesSelected = "";
				String shipmentNoSelected = "";
		
				if(eq_shipment.equals("Y")){
					shipmentYesSelected = "selected";
				}else if(eq_shipment.equals("N")){
					shipmentNoSelected = "selected";
				}
				
				String dailySelected = "";
				String monthlySelected = "";
				String yearlySelected = "";
				String quarterlySelected = "";
				String halfyearlySelected = "";
				String alternateSelected = "";
				String nightlySelected = "";
		
				if(delv_freq_type.equals("DL")){
					dailySelected = "selected";
				}else if(delv_freq_type.equals("AL")){
					alternateSelected = "selected";
				}else if(delv_freq_type.equals("FN")){
					nightlySelected = "selected";
				}else if(delv_freq_type.equals("MN")){
					monthlySelected = "selected";
				}else if(delv_freq_type.equals("QT")){
					quarterlySelected = "selected";
				}else if(delv_freq_type.equals("HY")){
					halfyearlySelected = "selected";
				}else if(delv_freq_type.equals("YR")){
					yearlySelected = "selected";
				}	
				
				String replaceYesSelected = "";
		String replaceNoSelected = "";
		
		if(replace_type.equals("Y")){
			replaceYesSelected = "selected";
			
		}else if(replace_type.equals("N")){
			replaceNoSelected = "selected";
		}
		
		String sampleYesSelected = "";
		String sampleNoSelected = "";
		String sampleDisabled = "";
		
		if(sample_type.equals("Y")){
			sampleYesSelected = "selected";
			sampleDisabled = "";
			
		}else if(sample_type.equals("N")){
			sampleNoSelected = "selected";
			sampleDisabled = "disabled";
		}
		
		

%>
<form name="formQuotMoreDetails" id="formQuotMoreDetails">
	<table border='0' cellpadding='2' cellspacing='0'   align=center scrolling=yes>
		<tr>
			<td class="label" colspan=2><b><fmt:message key="ePO.Item.label"	bundle="${po_labels}"/></b>&nbsp;
				<%=item_code%>  &nbsp;&nbsp;  <%=item_desc%>
			</td>
			<td class="label" colspan= 3><b>Total Quotation Quantity : </b><%=quot_qty%> &nbsp;&nbsp; <%=quot_uom_desc%>
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.DelvFreq.label" bundle="${po_labels}"/></td>
			<td >&nbsp;&nbsp;<select name="delv_freq_type" id="delv_freq_type" >
				<option value="DL" <%=dailySelected%> >Daily</option>
				<option value="AL" <%=alternateSelected%> >Alternate Days</option>
				<option value="FN" <%=nightlySelected%> >Bi-Monthly</option>
				<option value="MN" <%=monthlySelected%> >Monthly</option>
				<option value="QT" <%=quarterlySelected%> >Quarterly</option>
				<option value="HY" <%=halfyearlySelected%> >Half Yearly</option>
				<option value="YR" <%=yearlySelected%> >Yearly</option>
			</select></td>
			<td>&nbsp;</td>
			<td align="right" class="label" ><fmt:message key="ePO.NoOfDelv.label" bundle="${po_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text"  class=NUMBER  value = "<%=no_of_delv%>" name="no_of_delv" size='3' maxLength='3' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"></td>
		</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.FirstDelvDate.label" bundle="${po_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=first_delv_dt%>" name="first_delv_date"  maxLength="10" size="10"  onBlur="CheckDate(this);"  >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('first_delv_date');" ></img>
			</td>
			<td>&nbsp;</td>
			<td align="right" class="label" ><fmt:message key="ePO.EqShipment.label" bundle="${po_labels}"/></td>
			<td >&nbsp;&nbsp;<select name="eq_shipment" id="eq_shipment" >
				<option value="Y" <%=shipmentYesSelected%> >Yes</option>
				<option value="N" <%=shipmentNoSelected%> >No</option>
			</select></td>
		</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.CatalogueNo.label" bundle="${po_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text"  class=NUMBER value = "<%=catalogue_no%>" name="catalogue_no" size='30' maxLength='30' ></td>
			<td>&nbsp;</td>
			
			<td align="right" class="label" ><fmt:message key="ePO.CountryOfOrigin.label" bundle="${po_labels}"/></td>
			<td>&nbsp;&nbsp;
			<!--<input type="text" value = "<%=origin_country%>" name="origin_country" size='10' maxLength='10' ></td> -->
	 	      <select name="origin_country" id="origin_country" value="" ><%=bean.getPlaceOfOriginList()%></select></td>
	<tr>
			
		</tr>
		<tr>
				<td class="label"> <fmt:message key="ePO.Replacable.label" bundle="${st_labels}"/></td>
				<td class="field" >&nbsp; 
					<select name="replace_type" id="replace_type" onchange="">
						<option value="Y" <%=replaceYesSelected%>>Yes</option>
						<option value="N" <%=replaceNoSelected%>>No</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="label"> <fmt:message key="ePO.SampleProvided.label" bundle="${st_labels}"/></td>
				<td class="field" > &nbsp;
					<select name="sample_type" id="sample_type" onchange="sampleChange(this);">
						<option value="Y" <%=sampleYesSelected%>>Yes</option>
						<option value="N" <%=sampleNoSelected%>>No</option>
					</select>
				</td>
				<td>&nbsp;</td>
				<td class="label" >	<fmt:message key="ePO.SampleQty.label" bundle="${po_labels}"/></td>
				<td class="field" >&nbsp;
					<input type="text" name="sample_qty" id="sample_qty"  class=NUMBER size="5" maxlength="5"  value="<%=sample_qty%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" <%=sampleDisabled%>>
				</td>
			</tr>
			<tr>
				<td class="label" >	<fmt:message key="ePO.TradeId.label" bundle="${po_labels}"/></td>
				<td class="field" >&nbsp;
				<select name="trade_id" id="trade_id"  onChange = "loadManufacturer(this);">
				<% if(trade_id != " " && trade_id != null) { %>
					<%=bean.getTrade_id_List(item_code,trade_id)%>
				<% } else {	%>	
					<script>LoadTrade('<%=item_code%>')</script>
				<% } %>	
					</select>
				</td>
		        <td>&nbsp;</td>
				<td class="label" >	<fmt:message key="ePO.Manufacturer.label" bundle="${po_labels}"/></td>
				<td class="field" >&nbsp;
				<select name="manufactur_id" id="manufactur_id"  onChange = "">
					<% if(manufactur_id != " " && manufactur_id != null) { %>
						<%=bean.getManufacturer_id_List(trade_id,manufactur_id)%>
					<% } else {	%>	
						<option value="">---Select---</option>  
						
					<% } %>		
					</select>		
				</td>
			</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.ItemSpecification.label" bundle="${po_labels}"/></td>
			<td class="fields"   colspan='2' >&nbsp;&nbsp;<textarea   name="item_specification" rows='4' cols='40' onBlur="SPCheckMaxLen('Item Specification',this,400);" onPaste="checkMaxLengthPaste(this,400);" onKeyPress="checkMaxLimit(this,400);" ><%=item_specification%></textarea></td>
			 
			<td align="right" class="label" ><fmt:message key="ePO.ItemRemarks.label" bundle="${po_labels}"/></td>
			<td class="fields"   colspan='2' >&nbsp;&nbsp;<textarea   name="item_remarks" rows='4' cols='40' onBlur="SPCheckMaxLen('Item Remarks',this,1000);" onPaste="checkMaxLengthPaste(this,1000);" onKeyPress="checkMaxLimit(this,1000);" ><%=item_remarks%></textarea>
			<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = "<%=item_remarks%>" >
			<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,item_remarks);">
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>&nbsp;</tr>
		<tr>&nbsp;</tr>
		<tr>&nbsp;</tr>
		<tr>&nbsp;</tr>
		 
		<tr>
				<td></td>
				<td></td>
				<td colspan = '2'>&nbsp;</td>
				<td align=right>
					<input type="button" class="button" name="Ok" id="Ok" value="OK"  onClick="exitMoreItemDetails();">
				</td>
		</tr>
	</table>
	<input type="hidden" 	name=sys_date				value="<%=sys_date%>">
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden" 	name="item_code" id="item_code"			value="<%=item_code %>">
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
	<input type="hidden"	name="bean_master_type" id="bean_master_type"						value="POQUOT">
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

