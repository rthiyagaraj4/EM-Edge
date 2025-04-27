<!DOCTYPE html>
 <%
/*
---------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------------------------
02/12/2019       71868          Haribabu                                       GHL-SCF-1471
17/05/2021                      Chandrashekar Arram                            MO-CRF-20166
20/10/2021		TFS-24350			Shazana		20/10/2021		Manickam		MO-CRF-20173
-----------------------------------------------------------------------------------------------------------------------------
*/
%> 
 <%@ page import="eST.AuthorizeAtIssueStoreBean,eST.AuthorizeAtIssueStoreDetailBean,java.util.HashMap,java.util.ArrayList, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
			String locale			=	 (String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/AuthorizeAtIssueStore.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
		<script>
			function_id						=		"<%= request.getParameter( "function_id" ) %>"
		</script>
</head>
<%
	boolean editMode						=		false;
	AuthorizeAtIssueStoreDetailBean authorizeAtIssueStoreDetail;
	String mode								=		request.getParameter("mode");
	String edit								=		request.getParameter("edit");
	String disabled							=		"";
	String disable_add						=		"";
	String item_desc						=		"";
	String uom								=		"";
	String YTDValue							=		"";
	String issuing_qty						=		"";
	String checked							=		"";
	String stock_item_yn					=		"";
	String pur_uom_code						=		"";
	String req_conv_fact					=		"";
	String req_uom_qty						=		"";
	String iss_uom_code						=		"";
	String iss_uom_qty						=		"";
	String iss_conv_fact					=		"";
	String store_code						=		"";
	String uom_code							=		"";
	String pur_disabled						=		"";
	String request_by_store_uom_desc		=		"";
	String request_on_store_uom_desc		=		"";
	String req_by_qty_on_hand				=		"";
	String	kit_item_yn						=		"";
	String	kit_template_uom				=		"";
// Rams For the CRF 537.3
	String	iss_conv_text				=		"";
	String	req_conv_text				=		"";
	
	String	display_style				=		"display:none";
	String	kit_req_enable				=		"visibility:hidden";
	String from_multiples				=			"1";
	String to_multiples					=			"1";
	String batch_multiples				=			"1";
	String issue_uom_multiples			=			"1";
	String req_batch_multiples			=			"1";
	String req_uom_multiples			=			"1";
	String imgMandatory					=		"visibility:hidden";
	String	iss_history_style		=			 "visibility:hidden";//Added for MO-CRF-20166
	String close_remarks_desc = "";///MO-CRF-20173  


	int srl_no								=		 -1;
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	mode									=		mode.trim();
	String bean_id							=		"authorizeAtIssueStoreBean";
	String bean_name						=		"eST.AuthorizeAtIssueStoreBean";
	String caption							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String item_code						=		request.getParameter("item_code");
	String	request_on_store_code			=		(request.getParameter( "request_on_store_code" )!=null ? (request.getParameter("request_on_store_code").trim()):"" );
	String	request_by_store_code			=		(request.getParameter( "request_by_store_code" )!=null ? (request.getParameter("request_by_store_code").trim()):"" );
	
	AuthorizeAtIssueStoreBean bean			=		(AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	
	String index						=		bean.checkForNull(request.getParameter("index"),"-1");
	bean.setCloseRemarksDesc("");//MO-CRF-20173  
 	/**
	* @Name - Mahesh
	* @Date - 19/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals					=			bean.getNoOfDecimals();
		if (item_code != null) {
 	/**
	* @Name - Mahesh
	* @Date - 19/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/


		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		caption								=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		editMode							=		true;
		disabled							=		"disabled";
		if(edit.equals("2"))
			pur_disabled					=		"disabled";
		authorizeAtIssueStoreDetail			=		bean.getItemDetail(item_code.trim());
		item_code							=		authorizeAtIssueStoreDetail.getItem_code();
		item_desc							=		authorizeAtIssueStoreDetail.getItem_desc();
		uom									=		authorizeAtIssueStoreDetail.getUom_desc();
		issuing_qty							=		bean.setNumber(authorizeAtIssueStoreDetail.getIssuing_item_qty(),no_of_decimals);
		stock_item_yn						=		authorizeAtIssueStoreDetail.getStock_item_yn();

		//code added for displaying Request and Issue UOM
		iss_conv_text                        =      authorizeAtIssueStoreDetail.getIssConvText();
		req_conv_text                        =      authorizeAtIssueStoreDetail.getReqConvText();

		pur_uom_code						=		authorizeAtIssueStoreDetail.getPurUomCode();
		req_conv_fact						=		authorizeAtIssueStoreDetail.getReqConvFact();  //check here
		req_uom_qty							=		bean.setNumber(authorizeAtIssueStoreDetail.getReqUomQty(),no_of_decimals);
		store_code							=		authorizeAtIssueStoreDetail.getStore_code();
		uom_code							=		authorizeAtIssueStoreDetail.getUomCode();
		kit_template_uom				=			bean.checkForNull(authorizeAtIssueStoreDetail.getKit_template_uom());
		kit_item_yn						=			bean.checkForNull(authorizeAtIssueStoreDetail.getKit_item_yn(),"N");
		if(kit_item_yn.equals("Y")){
		display_style				=			 "visibility:visible";
		}else{
		display_style				=			 "display:none";
		}
		if(kit_item_yn.equals("Y") && edit.equals("2") ){
			kit_req_enable="";
		}else{
			kit_req_enable=pur_disabled;
		}
		request_by_store_uom_desc			=		bean.getShortDesc(item_code,request_by_store_code);
		
		request_on_store_uom_desc			=		bean.getShortDesc(item_code,(String)request_on_store_code);

		if(authorizeAtIssueStoreDetail.getIssConvFact() !=null){
			iss_conv_fact					=		authorizeAtIssueStoreDetail.getIssConvFact();//check here
		}

		if(authorizeAtIssueStoreDetail.getIssUomQty() !=null){
			iss_uom_qty						=		bean.setNumber(authorizeAtIssueStoreDetail.getIssUomQty(),no_of_decimals);
		}

		req_by_qty_on_hand					=		bean.setNumber(bean.checkForNull(bean.getReq_by_on_qty(),"0"),no_of_decimals);

		if((authorizeAtIssueStoreDetail.getIssUomCode()).length() > 0 && authorizeAtIssueStoreDetail.getIssUomCode() !=null){
			iss_uom_code					=		authorizeAtIssueStoreDetail.getIssUomCode();

		}else{
			iss_uom_code					=		bean.getDefaultIssueUOM(item_code,store_code);
			if(iss_uom_code==null || iss_uom_code == "")
			{
				iss_uom_code				=		uom_code;
				authorizeAtIssueStoreDetail.setIssUomCode(iss_uom_code);
				iss_conv_fact				=		req_conv_fact; //check here
				authorizeAtIssueStoreDetail.setIssConvFact(iss_conv_fact);
				iss_uom_qty					=		req_uom_qty;
				authorizeAtIssueStoreDetail.setIssUomQty(iss_uom_qty);
			}
		}
		if(stock_item_yn.equals("Y")) {
		checked								=		"checked";
		}

		from_multiples				=			authorizeAtIssueStoreDetail.getFromMultiples(); 
		to_multiples				=			authorizeAtIssueStoreDetail.getToMultiples(); 
		batch_multiples				=			authorizeAtIssueStoreDetail.getBatchMultiples(); 
		issue_uom_multiples			=			authorizeAtIssueStoreDetail.getIssueUOMMultiples(); 
		req_batch_multiples			=			authorizeAtIssueStoreDetail.getReqBatchMultiples(); 
		req_uom_multiples			=			authorizeAtIssueStoreDetail.getReqUOMMultiples(); 
	
	}
	else {
		item_code							=		"";
		authorizeAtIssueStoreDetail			=		new AuthorizeAtIssueStoreDetailBean();
		disable_add							=		"disabled";
	}
	if (item_code != null && item_code.trim() != "")	{
		YTDValue							=		bean.getYTTDIssueQty(authorizeAtIssueStoreDetail.getItem_code());
	}
	String decimal_precision = "0";
	if (authorizeAtIssueStoreDetail.getCanAcceptDecimal())	{
		decimal_precision					=		bean.getDecimalPrecision((String)session.getAttribute("ACC_ENTITY_ID"));
	}
	
	//String available_qty =		bean.checkForNull((String)bean.fetchRecord("SELECT SUM(QTY_ON_HAND) AVAILABLE_QTY FROM st_item_batch WHERE item_code=? AND store_code=?",new String[]{item_code,store_code}).get("AVAILABLE_QTY"));
	
	ArrayList alParameters = new ArrayList();
	alParameters.add(item_code);
	alParameters.add(bean.checkForNull(store_code));

	String issue_history_durn = bean.getIssueHistoryDurn();//Added for MO-CRF-20166
		if(issue_history_durn ==null || issue_history_durn.equals("0"))//Added for MO-CRF-20166
		 issue_history_durn ="";//Added for MO-CRF-20166
	
		
	String available_qty =		bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_AVAIL_QTY_SELECT"),alParameters).get("AVAILABLE_QTY"));
	
		String facilityid	=		(String)session.getValue("facility_id");
		ArrayList chParameters = new ArrayList();
		chParameters.add(facilityid);
		String allow_remarks =		bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_AND_REMARKS_SELECT"),chParameters).get("ALLOW_PARTIALQTY_WO_RMKS"));
		String allow_batch_search =		bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_AND_REMARKS_SELECT"),chParameters).get("ALLOW_BATCH_CHANGE_ON_AUTH"));
		
		ArrayList alExpRecords = null;
		bean.setTempRecords(item_code,alExpRecords);
		
		
		if(bean.checkForNull(authorizeAtIssueStoreDetail.getRemarksCode()) != null && bean.checkForNull(authorizeAtIssueStoreDetail.getRemarksCode()) !="")
			imgMandatory = "visibility:visible";
			//Commented code removed against GHL-SCF-1097
			item_desc = item_desc.replaceAll(" ","%20");
					item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc = item_desc.replaceAll("%2520","%20");
			if(!item_desc.equals("") && !issue_history_durn.equals(""))//Added for MO-CRF-20166
	           iss_history_style          =            "visibility:visible";//Added for MOD-CRF-20166		 
			boolean closeItemAtAuth_yn=false;//MO-CRF-20173
			Connection con = null;
			try
			{
				con = ConnectionManager.getConnection();	
				closeItemAtAuth_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_CLOSE_ITEM_AT_AUTHORIZE"); 
				System.err.println("value for closeItemAtAuth_yn: "+closeItemAtAuth_yn); 
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in site specific "+e);
			}
			finally{
		    	if(con != null)
		    		ConnectionManager.returnConnection(con,request); 
		    } 
			
			String checkedYN							=		"";
			String closeItemChecked = authorizeAtIssueStoreDetail.getClose_item_yn();
			String Qtystyle= "";
			Qtystyle = "visibility:hidden";
			if(closeItemChecked.equals("Y") ){
				checkedYN = "checked";  
				Qtystyle =  "visibility:visible";
			}//MO-CRF-20173 END 
			String closeRemarksDesc = authorizeAtIssueStoreDetail.getCloseRemarksDesc();//MO-CRF-20173  
			  
			
%>
<body>
	<form name="formAuthorizeAtIssueStoreDetail" id="formAuthorizeAtIssueStoreDetail">
	<table border="0" cellspacing="0" width="100%">
	  <tr>
		<td align="left" class="label">
			<fmt:message key="Common.item.label" bundle="${common_labels}"/>
		</td>
		<td >
			&nbsp;&nbsp;
			<input type="text" name="item_desc" id="item_desc" size="70" maxlength="60"  value="" <%=disabled%>>
			<input type="hidden" name="item_desc_temp" id="item_desc_temp" value="<%=item_desc%>" >
			<input type="button" name="item_search" id="item_search" value="?" class="button" onClick="return callItemSearch();" <%=disabled%>>
			<img src="../../eCommon/images/mandatory.gif" align="center">
			</img>
			<label class="label">
				&nbsp;
				<fmt:message key="Common.uom.label" bundle="${common_labels}"/>
				&nbsp;
			</label>
			<label id='uom_label' class="label">
				&nbsp;
				<B>
					<%=uom%>
				</B>
			</label>
			<label class="label">&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<label class="label" style = "<%=iss_history_style%>"><a name ="iss_history" class='gridLink' href="javascript:viewIssueHistory();"> <B>Issue History</B><a></label><!-- Added for MO-CRF-20166 href modified for IN19719-->
		</td>
		<td  class="label">
			<fmt:message key="eST.StockItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td class='label'>		<input type="checkbox" name="stock_item_yn" id="stock_item_yn" <%=checked%> disabled>
		<!-- MO-CRF-20173 -->
		<td  class="label">
			<fmt:message key="eST.CloseItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td class='label'><input type="checkbox" name="close_item" id="close_item" <%=checkedYN%> onclick="setValueCheck(this)" >  
		</td>
		<!-- MO-CRF-20173 -->
		<td>
		<label style='<%=Qtystyle%>' id="Remarkslabel" onMouseOver="changeCursor(this);"  class="label" name ="close_remarks" onClick = "showRemarksOnClose(closeRemarksDesc);"  ><font class='HYPERLINK'> 
	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></label></td>
		</tr><!-- MO-CRF-20173 -->
		<tr>
		<td class=label><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='label' colspan="6">&nbsp;&nbsp;<textarea rows=1 cols=40 name="remarks_desc" readonly><%=bean.checkForNull(authorizeAtIssueStoreDetail.getRemarksDesc())%></textarea>
		<input type="hidden" name="remarks_code" id="remarks_code" value = "<%=bean.checkForNull(authorizeAtIssueStoreDetail.getRemarksCode())%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksItem(remarks_code,remarks_desc);" ><img id ="remarks_mandatory" src="../../eCommon/images/mandatory.gif" align=center style ="<%=imgMandatory%>"></td>
		<td id="kit_template"  class="label" STYLE="<%=display_style%>" >
				<fmt:message key="eST.KitTemplateUOM.label" bundle="${st_labels}"/> </td>
		<td class='label' id="kit_template1"  class="label" STYLE="<%=display_style%>" colspan="4" >		<input type="text" name="kit_template_uom" id="kit_template_uom" value="<%=kit_template_uom%>" size="15"readonly>
			</td>
	  </tr>
	  <tr>
<!--	   <table border="0" cellspacing="0" cellpadding="1" width="100%">
	   <tr>
			<td align = right class ="label" nowrap Width="10%"> <B>&nbsp; <fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/> -> </B></td>
			<td align = right class ="label" nowrap Width="8%" > <fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="12%" > <fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="8%"> &nbsp;<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="8%"> &nbsp;<fmt:message key="Common.maximum.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap Width="8%"> &nbsp;<fmt:message key="eST.Reorder.label" bundle="${st_labels}"/></td>
			<td align ="left"  class="label"  nowrap >	&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.YTDIssQty.label" bundle="${st_labels}"/>	</td>
			<td Width="70%" >&nbsp;&nbsp;<b>	<label class="label" id="ytd_value"><%=bean.checkForNull(YTDValue,"&nbsp;")%></label></b></td>
	</tr>
	<tr>
			<td align = right class ="label" nowrap> <fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_by_qty_on_hand">   <%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_by_qty_on_hand(),"0")%></label></td>
			<td align = right class ="label" nowrap> <label class="label" id="lb_req_by_store_uom_desc"> </label><%=request_by_store_uom_desc%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_by_min_stk_level"><%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_by_min_stk_level(),"&nbsp;")%></label></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_by_max_stk_level"><%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_by_max_stk_level(),"&nbsp;")%></label></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_by_reorder_level">  <%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_by_reorder_level(),"&nbsp;")%></label></td>
			<td align ="left"  class="label"  nowrap colspan ="2">&nbsp;</td>
	</tr>
		<tr>
			<td align = right class ="label" nowrap> <fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_on_qty_on_hand">	<%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_on_qty_on_hand(),"0")%></label></td>
			<td align = right class ="label" nowrap> <label class="label" id="lb_req_on_store_uom_desc"> </label><%=request_on_store_uom_desc%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_on_min_stk_level"><%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_on_min_stk_level(),"&nbsp;")%></label></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_on_max_stk_level"><%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_on_max_stk_level(),"&nbsp;")%></label></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_req_on_reorder_level">  <%=bean.checkForNull(authorizeAtIssueStoreDetail.getReq_on_reorder_level(),"&nbsp;")%></label></td>
			<td align ="left"  class="label"  nowrap colspan ="2">&nbsp;</td>
	</tr>
  </table>-->
   <table border="0" cellspacing="0" cellpadding="0" width="100%">
	  <tr>
		<td class=label align=left ><fmt:message key="eST.ReqUOM.label" bundle="${st_labels}"/></td>
		<%
		String caption_mod=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		if(!caption.equals(caption_mod)){
						%>
			<!--/**
			* @Name - Priya
			* @Date - 29/04/2010
			* @Inc# - 21040
			* @Desc - calRequestQty(); is called in the onblur of  IssueUOM select box
			*/-->
		<td align=left  class='label' colspan="2">&nbsp;<select name='pur_uom_code' id='pur_uom_code' onBlur="calculateConversion('REQ_UOM');checkUOMConvFactor();calRequestQty();" <%=pur_disabled%>>
		<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>	---&nbsp;&nbsp;&nbsp;&nbsp;</option>
			
		</select><label>&nbsp;&nbsp;<fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</label><b id="id_pur_uom_conv"><%=req_conv_text%></b>
		</td>
			<%}else{
			%>
			
			<td align=left  class='label' colspan="2">&nbsp;<select name='pur_uom_code' id='pur_uom_code' onBlur="calculateConversion('REQ_UOM');checkUOMConvFactor();calRequestQty();" <%=pur_disabled%> ><%=bean.getPur_uom_code_Modify_List(uom_code,pur_uom_code,item_code)%></select><label>&nbsp;&nbsp;<fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</label><b id="id_pur_uom_conv"><%=req_conv_text%></b>
		</td>
		<%}%>
		<td align="left" class="label"><fmt:message key="eST.ReqUOMQty.label" bundle="${st_labels}"/></td>
		<td >&nbsp;<input type="text" name="req_uom_qty" id="req_uom_qty" size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="CheckQuantity(this);calRequestQty();" value="<%=req_uom_qty%>" <%=kit_req_enable%> >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>

		<td align="left" class="label" ><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></td>
		<%
			String req_item_qty_disabled = "";
			if(authorizeAtIssueStoreDetail.getReq_item_qty() != null && (Double.parseDouble(authorizeAtIssueStoreDetail.getReq_item_qty()) != 0) ) {
				req_item_qty_disabled = "disabled";
			}
		%>
		<td colspan="2">
			
			<input type="text" name="req_item_qty" id="req_item_qty" size="12" maxlength="15" class="NUMBER" onkeypress = "return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,
			4);"  
			value="<%=(req_uom_qty).equals("")?"":bean.setNumber(authorizeAtIssueStoreDetail.getReq_item_qty(),no_of_decimals)%>" disabled >
			<img src="../../eCommon/images/mandatory.gif" align=center>
		</td>
		
		</tr>
		<tr>
			<td class=label align=left ><fmt:message key="eST.IssueUOM.label" bundle="${st_labels}"/></td>
		<%
		String caption_mod1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		if(!caption.equals(caption_mod1)){
						%>
		<!--/**
			* @Name - Priya
			* @Date - 29/04/2010
			* @Inc# - 21040
			* @Desc - calIssueQty(); is called in the onblur of  IssueUOM select box
			*/-->
		<td align=left  class='label' colspan="2">&nbsp;<select name='iss_uom_code' id='iss_uom_code' onBlur="calculateConversion('');checkISSUOMConvFactor();calIssueQty();">
		<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>	---&nbsp;&nbsp;&nbsp;&nbsp;</option>
			
		</select><label>&nbsp;&nbsp;<fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</label><b id="id_iss_uom_conv"><%=iss_conv_text%></b>
		</td>
			<%}else{
			%>
			
			<td align=left  class='label' colspan="2">&nbsp;<select name='iss_uom_code' id='iss_uom_code' onBlur="calculateConversion('');checkISSUOMConvFactor();calIssueQty();"  ><%=bean.getPur_uom_code_Modify_List(uom_code,iss_uom_code,item_code)%></select><label>&nbsp;&nbsp;<fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</label><b id="id_iss_uom_conv"><%=iss_conv_text%></b>
		</td>
		<%}%>
		<td align="left" class="label"><fmt:message key="eST.IssueUOMQuantity.label" bundle="${st_labels}"/></td>
		<% if(allow_remarks.equals("N")) {%>
			<td >&nbsp;<input type="text" name="iss_uom_qty" id="iss_uom_qty" size=12 maxlength=12 class="NUMBER"  onchange="resetQty(this);" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="valueChange(this);CheckQuantity(this);calIssueQty();" value="<%=iss_uom_qty%>" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td> <!-- Modified for IN:71868 -->
		<% } else {%>
			<td >&nbsp;<input type="text" name="iss_uom_qty" id="iss_uom_qty" size=12 maxlength=12 class="NUMBER"  onchange="resetQty(this);" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="CheckQuantity(this);calIssueQty();" value="<%=iss_uom_qty%>" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td> <!-- Modified for IN:71868 -->
		<% } %>
		<td align="left" class="label">
			<fmt:message key="eST.AuthorizeQuantity.label" bundle="${st_labels}"/>
		</td>

		<td colspan="2">
			
			<input type="text" name="issuing_qty" id="issuing_qty" size="12" maxlength="15" class="NUMBER" onkeypress = "return isValidNumber(this,event,12,
			<%=no_of_decimals%>);" onBlur="isValidIntegerZero(this);" value="<%=issuing_qty%>" disabled>		
			<img src="../../eCommon/images/mandatory.gif" align=center>
		</td>
		
		</tr>
		
	  <tr>
	  <td align="left" class="label">
			<fmt:message key="eST.PendReqdQty.label" bundle="${st_labels}"/>
		</td>
		<td >
			&nbsp;&nbsp;
			<b>
				<label class="label" id="pending_item_qty">
					<%=item_code.equals("")?"&nbsp;":bean.setNumber(authorizeAtIssueStoreDetail.getPending_item_qty(),no_of_decimals)%> 
				</label>
				<input type="hidden"	name="pending_item_qty_chk" id="pending_item_qty_chk"		value="<%=bean.setNumber(authorizeAtIssueStoreDetail.getPending_item_qty(),no_of_decimals)%>">
			</b>
		</td>
		<td align="left" class="label" nowrap>
			<fmt:message key="Common.PackSize.label" bundle="${common_labels}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<b>
				<label class="label" id="curr_pack_size">
					<%=bean.checkForNull(authorizeAtIssueStoreDetail.getCurr_pack_size(),"&nbsp;")%>
				</label>
			</b>
		</td>
		<td align="left"  class="label">
			<fmt:message key="eST.YTDIssQty.label" bundle="${st_labels}"/>
			:&nbsp;<b>	<label class="label" id="ytd_value"><%=bean.setNumber(bean.checkForNull(YTDValue,""),no_of_decimals)%></label></b></td>
		<td class=label>
			<a href="javascript:batchDetails('<%=bean_id%>','<%=bean_name%>','<%=mode%>')">View Batch Details</a>
		</td>
			<td colspan="4" align="left">
			<input name="add" id="add" class="button" type="button" value="<%=caption%>" <%=disable_add%> onClick="isValidDoubleFormat(req_uom_qty);calRequestQty();calIssueQty();updateItemRecord();">
			&nbsp;&nbsp;
			<input class="button" type="button" name="cmdCancel" id="cmdCancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="resetDetail();"> &nbsp;&nbsp;
			<input class="button" type="button" name="ItemDetails" id="ItemDetails" value='<fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>' onClick="ItemDetail();" <%=disable_add%>>
		</td>
		</table>
	  </tr>
	</table>
		<input type="hidden"	name="mode" id="mode"								value="<%=mode%>">
		<input type="hidden"	name="language_id" id="language_id"						value="<%=locale%>">
		<input type="hidden"	name="item_code" id="item_code"						value="<%=item_code%>">
		<input type="hidden"	name="srl_no" id="srl_no"							value="<%=srl_no%>">
		<input type="hidden"	name="bean_id" id="bean_id"							value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"						value="<%= bean_name %>">
		<input type="hidden"	name="function_id" id="function_id"						value="<%=bean.getFunctionId()%>">
		<input type="hidden"	name="pending_item_qty" id="pending_item_qty"					value="">
		<input type="hidden"	name="qty_on_store" id="qty_on_store"						value="<%=authorizeAtIssueStoreDetail.getReq_on_qty_on_hand()%>">
		<input type="hidden"	name="qty_by_store" id="qty_by_store"						value="<%=authorizeAtIssueStoreDetail.getReq_by_qty_on_hand()%>">
		<input type="hidden"	name="editing" id="editing"							value="<%=editMode?2:1%>">
		<input type='hidden'	name="request_by_store_code" id="request_by_store_code"			value="">
		<input type='hidden'	name="request_on_store_code" id="request_on_store_code"			value="">
		<input type='hidden'	name="uom" id="uom"								value="<%=uom_code%>">
		<input type='hidden'	name="req_conv_fact" id="req_conv_fact"					value="<%=req_conv_fact%>">
		<input type='hidden'	name="iss_conv_fact" id="iss_conv_fact"					value="<%=iss_conv_fact%>">
		<input type="hidden"	name="req_by_qty_on_hand" id="req_by_qty_on_hand"				value="<%=authorizeAtIssueStoreDetail.getReq_by_qty_on_hand()%>">
		<input type="hidden"	name="req_by_min_stk_level" id="req_by_min_stk_level"				value="<%=authorizeAtIssueStoreDetail.getReq_by_min_stk_level()%>">
		<input type="hidden"	name="req_by_max_stk_level" id="req_by_max_stk_level"				value="<%=authorizeAtIssueStoreDetail.getReq_by_max_stk_level()%>">
		<input type="hidden"	name="req_by_reorder_level" id="req_by_reorder_level"				value="<%=authorizeAtIssueStoreDetail.getReq_by_reorder_level()%>">
		<input type="hidden"	name="req_on_qty_on_hand" id="req_on_qty_on_hand"				value="<%=authorizeAtIssueStoreDetail.getReq_on_qty_on_hand()%>">
		<input type="hidden"	name="req_on_min_stk_level" id="req_on_min_stk_level"				value="<%=authorizeAtIssueStoreDetail.getReq_on_min_stk_level()%>">
		<input type="hidden"	name="req_on_max_stk_level" id="req_on_max_stk_level"				value="<%=authorizeAtIssueStoreDetail.getReq_on_max_stk_level()%>">
		<input type="hidden"	name="req_on_reorder_level" id="req_on_reorder_level"				value="<%=authorizeAtIssueStoreDetail.getReq_on_reorder_level()%>">
		<input type="hidden"	name="frm_tmp_conv" id="frm_tmp_conv"						value="">
		<input type="hidden"	name="to_tmp_conv" id="to_tmp_conv"						value="">
		<input type="hidden"	name="request_by_store_uom_desc" id="request_by_store_uom_desc"		value="<%=request_by_store_uom_desc%>">
		<input type="hidden"	name="request_on_store_uom_desc" id="request_on_store_uom_desc"		value="<%=request_on_store_uom_desc%>">
		<input type="hidden"	name="uom_desc" id="uom_desc"							value="<%=uom%>">
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id"						value="">
		
		<input type="hidden"		name="kit_item_yn" id="kit_item_yn"				 value="<%=kit_item_yn%>">
		<input type="hidden"	name="iss_uom_qty_chk" id="iss_uom_qty_chk"						value="<%=iss_uom_qty%>">
		<input type="hidden"	name="allow_remarks" id="allow_remarks"						value="<%=allow_remarks%>">
		<input type="hidden"	name="allow_batch_search" id="allow_batch_search"						value="<%=allow_batch_search%>">
		<input type="hidden"	name="close_remarks_desc_1" id="close_remarks_desc_1"						value="<%=close_remarks_desc%>">   
		
  <!--
  Added By Rams for the 537.3 crf
  
  -->
       <input type="hidden"	name="iss_conv_text" id="iss_conv_text"						value="<%=iss_conv_text%>">
		<input type="hidden"	name="req_conv_text" id="req_conv_text"						value="<%=req_conv_text%>">
		<input type="hidden" name="from_multiples" id="from_multiples"							value="<%=from_multiples%>">
		<input type="hidden" name="to_multiples" id="to_multiples"							value="<%=to_multiples%>">
		<input type="hidden" name="batch_multiples" id="batch_multiples"							value="<%=batch_multiples%>">
		<input type="hidden" name="issue_uom_multiples" id="issue_uom_multiples"						value="<%=issue_uom_multiples%>">
		<input type="hidden" name="req_batch_multiples" id="req_batch_multiples"							value="<%=req_batch_multiples%>">
		<input type="hidden" name="req_uom_multiples" id="req_uom_multiples"						value="<%=req_uom_multiples%>">


<!-- 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/

 -->	
		<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
		<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">
		<input type="hidden"		name="index" id="index"				     value="<%=index%>">
		<input type="hidden"		name="available_qty" id="available_qty"			 value="<%=available_qty%>">
		<input type="hidden"		name="total_batch_qty" id="total_batch_qty"			 value="">
		<input type="hidden"		name="closeRemarksDesc" id="closeRemarksDesc"			 value="<%=closeRemarksDesc%>"> 
		<input type="hidden"		name="closeItemList" id="closeItemList"			 value="<%=bean.getCloseItemList()%>"> <!-- MO-CRF-20173 -->
		
		
		<%
putObjectInBean(bean_id,bean,request);
%>
	</form>
</body>
</html>
<script>
Setitemdesc(document.formAuthorizeAtIssueStoreDetail.item_desc_temp);
</script>

