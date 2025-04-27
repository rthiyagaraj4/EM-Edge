
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B						GHL-CRF-0456
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
			 request.setCharacterEncoding("UTF-8");
			String locale			=		(String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
			<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
			<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eST/js/StCommon.js"></script>
			<script language="Javascript" src="../../eST/js/ItemSearch.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
</head>
<body>
<%	
	String mfg_base_qty					=			"";
	String curr_supp_code				=			"";
	String uom_desc						=			"";
	String manufacture_desc				=			"";
	String min_stk_qty					=			"";
	String max_stk_qty					=			"";
	String long_desc					=			"";
	String ps_item_yn					=			"";
	String sole_source_yn				=			"";
	String manufacturer_id				=			"";
	String gen_uom_code					=			"";
	String unit_cost					=			"";
	String mfg_item_yn					=			"";
	String medical_item_yn				=			"";
	String abc_class_code				=			"";
	String machine_code					=			"";
	String spare_part_id				=			"";
	String trade_id_applicable_yn		=			"";
	String batch_id_applicable_yn		=			"";
	String classvalue					=			"";
	String expiryyn						=			"";
	String item_code					=			"";
	String item_name					=			"";
	String item_class					=			"";
	String alpha_code					=			"";
	String consignment					=			"";
	String preparation_type				=			"";
	String preparation_mode				=			"";
	String str_uom_code					=			"";
	String gen_uom_desc					=			"";
	String req_uom_code					=			"";
	String allow_decimals_yn			=			"";
	int	no_of_decimals					=			0;

	int maxRec							=			0; 
	int start							=			0;
	int end								=			0;
	int displaySize						=			0;
	int count							=			0;
	String item_specfin_name = "";
	String item_remarks = "";
	String qty_on_hand = "";
	String avl_qty = "";
	
	String min_str_qty = "";
	String max_str_qty = "";
	String reorder_level = "";

	String from							=			request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=			request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String radioval						=			request.getParameter( "radioval" )==null?"IC":request.getParameter( "radioval" ) ;
	String trn_type						=			request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ; //Added by Sakti against AMS-CRF-0011
	String search_no					=			request.getParameter( "search_no" )==null?"":request.getParameter( "search_no" ) ; //Added by suresh.r on 17-06-2014 against
	
	String bean_id						=			 "ItemSearchBean";
	String bean_name					=			 "eST.ItemSearchBean";
	ItemSearchBean bean					=			(ItemSearchBean) getBeanObject( bean_id,bean_name,request);

	//need to remoce
	String img_path = bean.checkForNull((String)(((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_IMAGE_CATLG_PATH_SELECT"),bean.getLoginFacilityId())).get("ITEM_IMAGE_CATLG_PATH")));
	

	
	String store_desc					=			CommonBean.checkForNull(bean.getStore_desc(),"");

	String store_code					=			CommonBean.checkForNull(bean.getStore_code(),"");
	//String item_class_code			=			CommonBean.checkForNull(bean.getItem_class(),"");
	
	
	store_desc							=			store_desc.equals("%")?"":store_desc;
	store_code							=			store_code.equals("%")?"":store_code;
	bean.setLanguageId(locale);
//	String search_string				=			bean.getSearch_string();
	boolean search						=			bean.getSearch() ;

	//if(radioval=="IC")search			=			true;
	ArrayList result					=			new ArrayList();	
	HashMap dataList					=			null;
	try{
		result							=			bean.getDataList();
		maxRec							=			result.size();
		displaySize						=			Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize						=			Integer.parseInt("12");
		if ( from == null || from =="" )
			start						=			0;
		else
			start						=			Integer.parseInt( from ) ;
		if ( to == null || to ==""){
			end							=			displaySize ;
		}
		else{
			end							=			 Integer.parseInt( to ) ;	
		}
		if(result.size() > 0 ){
		%>
			<form name=ItemsearchForm id=ItemsearchForm  >
			
			<div name='msg' id='msg' style="position:fixed; width: 0; height: 0; left: 201; top: 62">
			</div>
			<table cellpadding=2 cellspacing=0 width="100%"  align=center>
			<tr>
			<table border="1" cellpadding="2" cellspacing="0" width="100%"  id='tb1'>
			<th width='10%'  class='CAGROUP_HEADING' nowrap><a href="javascript:ordercols('ITEM_CODE');"><b><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></b></a></th>
			<th width='1%'  class='CAGROUP_HEADING'><a href="javascript:ordercols('ITEM_DESC');"><b><fmt:message key="Common.item.label" bundle="${common_labels}"/></b></a></th>
			<th width='3%'  class='CAGROUP_HEADING'><a href="javascript:ordercols('EXPIRY_YN');"><b><fmt:message key="Common.Expiry.label" bundle="${common_labels}"/></b></a></th>
			<th width='1%'  class='CAGROUP_HEADING'><a href="javascript:ordercols('UOM_DESC');"><b><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></b></a></th>
			<th width='3%'  class='CAGROUP_HEADING'><a href="javascript:ordercols('ITEM_CLASS_DESC');"><b><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></b></a></th>
			<th width='3%'  class='CAGROUP_HEADING'><a href="javascript:ordercols('ALPHA_CODE');"><b><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></b></a></th>
			<th width='3%'  class='CAGROUP_HEADING'><a href="javascript:ordercols('GEN_UOM_DESC');"><b><fmt:message key="eST.BaseUOM.label" bundle="${st_labels}"/></b></a></th><!-- Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 -->
			<!--Added by Sakti sankar against AMRI-CRF-100024 and AMS-CRF-0028-->
			<%if(!store_code.equals("")){%>
			<th width='1%'  class='CAGROUP_HEADING' nowrap><a href="javascript:ordercols('QTY_ON_HAND');"><b><fmt:message key="eST.QtyOnHand.label" bundle="${st_labels}"/></b></a></th>
			<th width='3%'  class='CAGROUP_HEADING' nowrap><a href="javascript:ordercols('AVAILABLE_QTY');"><b><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></b></a></th>
			<!-- //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 -->
			<th width='1%'  class='CAGROUP_HEADING' nowrap><a href="javascript:ordercols('MIN_STR_QTY');"><b><fmt:message key="eST.MinimumLevel.label" bundle="${st_labels}"/></b></a></th>
		<th width='3%'  class='CAGROUP_HEADING' nowrap><a href="javascript:ordercols('REORDER_LEVEL');"><b><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></b></a></th>
		<th width='3%'  class='CAGROUP_HEADING' nowrap><a href="javascript:ordercols('MAX_STR_QTY');"><b><fmt:message key="eST.MaximumLevel.label" bundle="${st_labels}"/></b></a></th>
		<%}//Added ends
			count	= start;
			int chkCount = 0;
			String img_display;
			String spcfn_img_display; //Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
			while ( count < maxRec && count < end)
			{
				dataList = (HashMap)result.get(count);
				//Added by Sakti sankar against CRF#12 and INC#29966	
				String []parameters = {bean.checkForNull((String)dataList.get("ITEM_CODE")),bean.getLoginFacilityId()};
				String img_file_name = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_IMAGE_FILE_NAME_SELECT"),parameters)).get("FILE_NAME"));
				
				System.out.println("img_file_name"+img_file_name);
				img_display="display:none";
				if(!img_file_name.equals("")) {
					img_display="display:inline";
				}
				//Added ends

				//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
				
				HashMap hmRecord	=	null;
				hmRecord = bean.getItemSpecfnRemarks(bean.checkForNull((String)dataList.get("ITEM_CODE")),bean.getLanguageId());
				item_specfin_name = CommonBean.checkForNull((String)hmRecord.get("ITEM_SPECIFICATION"),"");
				item_remarks = CommonBean.checkForNull((String)hmRecord.get("ITEM_REMARKS"),"");
				spcfn_img_display="display:inline";
				if(item_specfin_name.equals("") && item_remarks.equals("")) {
					spcfn_img_display="display:none";
				}
			   //Added ends
			   
			   /*Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 beg
				String []param = {bean.checkForNull((String)dataList.get("ITEM_CODE")),bean.getLanguageId()};
				String base_uom_desc = bean.checkForNull((String)((HashMap)bean.fetchRecord("SELECT AM.SHORT_DESC DESCR FROM MM_ITEM_LANG_VW MM, AM_UOM_LANG_VW AM WHERE MM.GEN_UOM_CODE=AM.UOM_CODE AND MM.LANGUAGE_ID=AM.LANGUAGE_ID AND MM.ITEM_CODE=? AND MM.LANGUAGE_ID=?",param)).get("DESCR"));
				Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 end*/

				if ( count % 2 == 0 )
					classvalue				=			"QRYEVEN" ;
				else
					classvalue				=			 "QRYODD" ;
	
				mfg_base_qty				=			CommonBean.checkForNull((String)dataList.get("MFG_BASE_QTY"),"0");
				machine_code				=			CommonBean.checkForNull((String)dataList.get("MACHINE_CODE"));
				min_stk_qty					=			CommonBean.checkForNull((String)dataList.get("MIN_STK_QTY"),"0");
				max_stk_qty					=			CommonBean.checkForNull((String)dataList.get("MAX_STK_QTY"),"0");

				long_desc					=			CommonBean.checkForNull((String)dataList.get("LONG_DESC"));
				
				if(!long_desc.equals("")){
					long_desc = long_desc.replaceAll(" ","%20");
					long_desc = java.net.URLEncoder.encode(long_desc,"UTF-8");
					long_desc = long_desc.replaceAll("%2520","%20");
				}
				
				//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
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

				ps_item_yn					=			CommonBean.checkForNull((String)dataList.get("PS_ITEM_YN"),"N");
				sole_source_yn				=			CommonBean.checkForNull((String)dataList.get("SOLE_SOURCE_YN"),"N");
				manufacturer_id				=			CommonBean.checkForNull((String)dataList.get("MANUFACTURER_ID"));
				gen_uom_code				=			CommonBean.checkForNull((String)dataList.get("GEN_UOM_CODE"));
				unit_cost					=			CommonBean.checkForNull((String)dataList.get("UNIT_COST"),"0");

				uom_desc					=			CommonBean.checkForNull((String)dataList.get("UOM_DESC"));

				if(!uom_desc.equals("")){
					uom_desc = uom_desc.replaceAll(" ","%20");
					uom_desc = java.net.URLEncoder.encode(uom_desc,"UTF-8");
					uom_desc = uom_desc.replaceAll("%2520","%20");
				}

				manufacture_desc			=			CommonBean.checkForNull((String)dataList.get("MANUFACTURE_DESC"));
				
				if(!manufacture_desc.equals("")){
					manufacture_desc = manufacture_desc.replaceAll(" ","%20");
					manufacture_desc = java.net.URLEncoder.encode(manufacture_desc,"UTF-8");
					manufacture_desc = manufacture_desc.replaceAll("%2520","%20");
				}
				
				spare_part_id				=			CommonBean.checkForNull((String)dataList.get("SPARE_PART_ID"));
				mfg_item_yn					=			CommonBean.checkForNull((String)dataList.get("MFG_ITEM_YN"));
				medical_item_yn				=			CommonBean.checkForNull((String)dataList.get("MEDICAL_ITEM_YN"));
				abc_class_code				=			CommonBean.checkForNull((String)dataList.get("ABC_CLASS_CODE"));
				trade_id_applicable_yn		=			CommonBean.checkForNull((String)dataList.get("TRADE_ID_APPLICABLE_YN"),"N");
				batch_id_applicable_yn		=			CommonBean.checkForNull((String)dataList.get("BATCH_ID_APPLICABLE_YN"),"N");
		
		
		
				expiryyn					=			CommonBean.checkForNull((String)dataList.get("EXPIRY_YN"),"N");
				item_code					=			CommonBean.checkForNull((String)dataList.get("ITEM_CODE"),"");
				item_name					=			CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"");
				
				if(!item_name.equals("")){
					item_name = item_name.replaceAll(" ","%20");
					item_name = java.net.URLEncoder.encode(item_name,"UTF-8");
					item_name = item_name.replaceAll("%2520","%20");
				}

				item_class					=			CommonBean.checkForNull((String)dataList.get("ITEM_CLASS_DESC"),"");
				if(!item_class.equals("")){
					item_class = item_class.replaceAll(" ","%20");
					item_class = java.net.URLEncoder.encode(item_class,"UTF-8");
					item_class = item_class.replaceAll("%2520","%20");
				}

				alpha_code					=			CommonBean.checkForNull((String)dataList.get("ALPHA_CODE"),"");
				consignment					=			CommonBean.checkForNull((String)dataList.get("CONSIGNMENT_ITEM_YN"),"N");
				curr_supp_code				=			CommonBean.checkForNull((String)dataList.get("CURR_SUPP_CODE"),"");
				preparation_type			=			CommonBean.checkForNull((String)dataList.get("PREPARATION_TYPE"),"");
				preparation_mode			=			CommonBean.checkForNull((String)dataList.get("PREPARATION_MODE"),"");
				//str_uom_code				=			CommonBean.checkForNull((String)dataList.get("DEF_ISSUE_UOM"),"");

				gen_uom_desc				=			CommonBean.checkForNull((String)dataList.get("GEN_UOM_DESC"),"");
				if(!gen_uom_desc.equals("")){
					gen_uom_desc = gen_uom_desc.replaceAll(" ","%20");
					gen_uom_desc = java.net.URLEncoder.encode(gen_uom_desc,"UTF-8");
					gen_uom_desc = gen_uom_desc.replaceAll("%2520","%20");
				}

				req_uom_code				=			CommonBean.checkForNull((String)dataList.get("DEF_REQUEST_UOM"),"");
				no_of_decimals				=			Integer.parseInt(CommonBean.checkForNull((String)dataList.get("NO_OF_DECIMALS"),"0"));
				allow_decimals_yn				=			CommonBean.checkForNull((String)dataList.get("ALLOW_DECIMALS_YN"),"N");
				//Added by Sakti sankar against AMRI-CRF-100024 and AMS-CRF-0028
				if(!store_code.equals("")){
				qty_on_hand = CommonBean.checkForNull((String)dataList.get("QTY_ON_HAND"),"0");
				avl_qty =CommonBean.checkForNull((String)dataList.get("AVAILABLE_QTY"),"0");
				
				//min_str_qty =   CommonBean.checkForNull((String)dataList.get("MIN_STR_QTY"),"0");  
				//max_str_qty =   CommonBean.checkForNull((String)dataList.get("MAX_STR_QTY"),"0");
				//reorder_level = CommonBean.checkForNull((String)dataList.get("REORDER_LEVEL"),"0");
				//ADDED BY Rabbani Inc no :50694 on 22-AUG-2014
				min_str_qty =   CommonBean.checkForNull((String)dataList.get("MIN_STR_QTY"),"");  
				max_str_qty =   CommonBean.checkForNull((String)dataList.get("MAX_STR_QTY"),"");
				reorder_level = CommonBean.checkForNull((String)dataList.get("REORDER_LEVEL"),"");
				
				if(min_str_qty.equals("0"))
				 min_str_qty = "";
				 if(max_str_qty.equals("0"))
				 max_str_qty = "";
				 if(reorder_level.equals("0"))
				 reorder_level = "";
				 
				 
				 
				}//Added ends

				// Added by Sakti against AMS-CRF-0011 to disable item code hyperlink if available qty is zero
				String hyper = "";
				String onClick = "";
				if((!store_code.equals("")) && avl_qty.equals("0")  ) { 
					onClick = "onClick=\"disableClick(event);\"";
					hyper = "";
				}else{
					hyper = "HYPERLINK";
				}
				//Added ends
				//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 beg
				if((trn_type.equals("PRD") || trn_type.equals("PRQ")) && search_no.equals("2")){
					hyper = "HYPERLINK";
					onClick = "";
				}//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end

				if(maxRec==1){
				%>
				<script>
				//returnVals("<%=mfg_base_qty%>","<%=machine_code%>","<%=min_stk_qty%>","<%=max_stk_qty%>","<%=long_desc%>","<%=ps_item_yn%>","<%=sole_source_yn%>","<%=manufacturer_id%>","<%=gen_uom_code%>","<%=unit_cost%>","<%=manufacture_desc%>","<%=trade_id_applicable_yn%>","<%=batch_id_applicable_yn%>","<%=expiryyn%>","<%=item_code%>","<%=item_name%>","<%=item_class%>","<%=alpha_code%>","<%=uom_desc%>","<%=consignment%>","<%=store_code%>","<%=store_desc%>","<%=curr_supp_code%>","<%=preparation_type%>","<%=preparation_mode%>","<%=str_uom_code%>");
				returnVals("<%=mfg_base_qty%>","<%=machine_code%>","<%=min_stk_qty%>","<%=max_stk_qty%>","<%=replaceNewLineChar(long_desc)%>","<%=ps_item_yn%>","<%=sole_source_yn%>","<%=manufacturer_id%>","<%=gen_uom_code%>","<%=unit_cost%>","<%=manufacture_desc%>","<%=trade_id_applicable_yn%>","<%=batch_id_applicable_yn%>","<%=expiryyn%>","<%=item_code%>","<%=item_name%>","<%=item_class%>","<%=alpha_code%>","<%=uom_desc%>","<%=consignment%>","<%=store_code%>","<%=store_desc%>","<%=curr_supp_code%>","<%=preparation_type%>","<%=preparation_mode%>","<%=gen_uom_desc%>","<%=req_uom_code%>","<%=allow_decimals_yn%>","<%=no_of_decimals%>");
				</script>
				<%
				}
				
		%>
<!-- 				<tr onClick="returnVals('<%=mfg_base_qty%>','<%=machine_code%>','<%=min_stk_qty%>','<%=max_stk_qty%>','<%=replaceNewLineChar(long_desc)%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=manufacturer_id%>','<%=gen_uom_code%>','<%=unit_cost%>','<%=replaceNewLineChar(manufacture_desc)%>','<%=trade_id_applicable_yn%>','<%=batch_id_applicable_yn%>','<%=expiryyn%>','<%=item_code%>','<%=replaceNewLineChar(item_name)%>','<%=item_class%>','<%=alpha_code%>','<%=uom_desc%>','<%=consignment%>','<%=store_code%>','<%=store_desc%>','<%=curr_supp_code%>','<%=preparation_type%>','<%=preparation_mode%>','<%=str_uom_code%>');" >
 -->				<tr onClick="returnVals('<%=mfg_base_qty%>','<%=machine_code%>','<%=min_stk_qty%>','<%=max_stk_qty%>','<%=replaceNewLineChar(long_desc)%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=manufacturer_id%>','<%=gen_uom_code%>','<%=unit_cost%>','<%=replaceNewLineChar(manufacture_desc)%>','<%=trade_id_applicable_yn%>','<%=batch_id_applicable_yn%>','<%=expiryyn%>','<%=item_code%>','<%=replaceNewLineChar(item_name)%>','<%=item_class%>','<%=alpha_code%>','<%=uom_desc%>','<%=consignment%>','<%=store_code%>','<%=store_desc%>','<%=curr_supp_code%>','<%=preparation_type%>','<%=preparation_mode%>','<%=gen_uom_desc%>','<%=req_uom_code%>','<%=allow_decimals_yn%>','<%=no_of_decimals%>');" >
					<!--commented by Rabbani #Inc no:35672 on 19/10/12
					<td class="<%=classvalue%>"   onmouseover="changeCursor(this);onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=java.net.URLDecoder.decode(long_desc,"UTF-8")%>');"   onMouseout="onMOut(msg);" nowrap><font class='HYPERLINK'><%=(String)dataList.get("ITEM_CODE")%></font></td>
					 
					<td class="<%=classvalue%>"   onmouseover="changeCursor(this);onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');"   onMouseout="onMOut(msg);" nowrap><font class='HYPERLINK'><%=(String)dataList.get("ITEM_CODE")%></font></td> -->
					

					<!--  Added by Sakti against AMS-CRF-0011 Function Specific enable and disable hyper link -->
					<!-- Modified if cdn by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 added trn_type.equals("PRQ") -->
					<%if(! (trn_type.equals("RTV") || trn_type.equals("URG") || trn_type.equals("REQ") || trn_type.equals("RET") || trn_type.equals("MFG") || trn_type.equals("SAL") || trn_type.equals("TFR") || trn_type.equals("PRD") || trn_type.equals("CBL") || trn_type.equals("CHANGE_EXP") || trn_type.equals("CEB") || trn_type.equals("SPB") || trn_type.equals("SUSPEND") || trn_type.equals("SRT") || trn_type.equals("PRQ"))) { %>
					
						<!-- <td class="<%=classvalue%>" onmouseover="changeCursor(this);onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');"   onMouseout="onMOut(msg);" nowrap><font class='HYPERLINK'><%=(String)dataList.get("ITEM_CODE")%></font></td> -->
						<td class="<%=classvalue%>" style="cursor: pointer;" onclick="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');"><font class='HYPERLINK'><%=(String)dataList.get("ITEM_CODE")%></font></td>
					<%}else{ %>
						<%if(trn_type.equals("PRD") || trn_type.equals("PRQ")){ //Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 beg%>
							 <td class="<%=classvalue%>" <%=onClick %>  <%if((!store_code.equals("")) && avl_qty.equals("0") && search_no.equals("1")) {%> onclick="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');" <%}else{%>  style="cursor: pointer;" onclick="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');" <%} %>><font class="<%=hyper%>"><%=(String)dataList.get("ITEM_CODE")%></font></td> 
							<!--<td class="<%=classvalue%>" <%=onClick %>  <%if((!store_code.equals("")) && avl_qty.equals("0") && search_no.equals("1")) {%> onmouseover="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');" <%}else{%> onmouseover="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');  changeCursor(this); " <%} %>  onMouseout="onMOut(msg);" nowrap><font class="<%=hyper%>"><%=(String)dataList.get("ITEM_CODE")%></font></td>-->
						<%}else{ //Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end%>
						<!-- Added by Sakti against AMS-CRF-0011 to disable item code hyperlink if available qty is zero --> 
						<!--<td class="<%=classvalue%>" <%=onClick %>  <%if((!store_code.equals("")) && avl_qty.equals("0") ) {%> onmouseover="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');" <%}else{%> onmouseover="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');  changeCursor(this); " <%} %>  onMouseout="onMOut(msg);" nowrap><font class="<%=hyper%>"><%=(String)dataList.get("ITEM_CODE")%></font></td>-->
						 <td class="<%=classvalue%>" <%=onClick %>  <%if((!store_code.equals("")) && avl_qty.equals("0") ) {%> onclick="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>');" <%}else{%>  style="cursor: pointer;" onclick="onMMove(msg,event,'<%=machine_code%>','<%=ps_item_yn%>','<%=sole_source_yn%>','<%=unit_cost%>','<%=spare_part_id%>','<%=mfg_item_yn%>','<%=medical_item_yn%>','<%=abc_class_code%>','<%=consignment%>','<%=long_desc%>'); " <%} %>"><font style="cursor: pointer;" class="<%=hyper%>"><%=(String)dataList.get("ITEM_CODE")%></font></td> 
						<%}%>
					<%} %>
					<!-- Added ends Function Specific enable and disable hyper link -->
					
					
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap  ><%=java.net.URLDecoder.decode(item_name,"UTF-8")%>&nbsp;<a style='<%=img_display%>;' href="javascript:callimageframe('<%=img_file_name%>','<%=item_code%>');"><img  src='../../eST/images/Arrow.png' alt="Item Image"  ></img></a>&nbsp;&nbsp;<a style='<%=spcfn_img_display%>;'  href="javascript:callItemSpcfnWindow('<%=bean.checkForNull((String)dataList.get("ITEM_CODE"))%>','<%=java.net.URLDecoder.decode(item_name,"UTF-8")%>');"><img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_name%>');"   onMouseout="onMOut(msg);"  src='../../eST/images/info.gif'   ></img></a></td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%if(((String)dataList.get("EXPIRY_YN")).equals("Y")){%><img  src='../../eCommon/images/enabled.gif'></img><%}else{%><img  src='../../eCommon/images/disabled.gif'></img><%}%></td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=java.net.URLDecoder.decode(uom_desc,"UTF-8")%>&nbsp;</td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=java.net.URLDecoder.decode(item_class,"UTF-8")%></td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=(String)dataList.get("ALPHA_CODE")%></td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=(String)dataList.get("GEN_UOM_DESC")%></td><!-- Added by suresh.r on 08-08-2014 against  MMS-SCF-0390 -->
					<!--Added by Sakti sankar against AMRI-CRF-100024-Inc#32850 and AMS-CRF-0028-->
					<%if(!store_code.equals("")){%>
					<td class="<%=classvalue%>" style="TEXT-ALIGN:right"   onclick="disableClick(event);" ><%=qty_on_hand%></td>
					<td class="<%=classvalue%>" style="TEXT-ALIGN:right"   onclick="disableClick(event);" ><%=avl_qty%></td>
					
					<td class="<%=classvalue%>" style="TEXT-ALIGN:right"   onclick="disableClick(event);" ><%=CommonBean.checkForNull(min_str_qty,"&nbsp;")%></td>
					<td class="<%=classvalue%>" style="TEXT-ALIGN:right"   onclick="disableClick(event);" ><%=CommonBean.checkForNull(reorder_level,"&nbsp;")%></td>
					<td class="<%=classvalue%>" style="TEXT-ALIGN:right"   onclick="disableClick(event);" ><%=CommonBean.checkForNull(max_str_qty,"&nbsp;")%></td>
					
					
					<%}%>
				</tr> 
		<%

	
				count++;
			chkCount++;
			}
		%> 
			</table>
			<input type="hidden" name="item_code" id="item_code" >
			<input type="hidden" name="short_desc" id="short_desc" >
			<input type="hidden" name="store_desc" id="store_desc"	value="<%=bean.getStore_desc()%>">
			<input type="hidden" name="alpha_code" id="alpha_code" >
			<input type="hidden" name="machine_code" id="machine_code" >
			<input type="hidden" name="spare_part_id" id="spare_part_id" >
			<input type="hidden" name="start" id="start"				value="<%=start%>">
			<input type="hidden" name="end" id="end"					value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords"		value='<%=result.size()%>'>
			<input type="hidden" name="displaySize" id="displaySize"			value="<%=displaySize%>">
			<input type="hidden" name="count" id="count"				value="1">

			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%= bean_name %>">
			<input type="hidden" name="img_path" id="img_path"					value="<%= img_path %>">
		<%
			out.flush();
		} else{
		%>
			 <script>
					if('<%=radioval%>'=="IC" && <%=search%>==true){
							
							changeRadVal();
					}
					else{
												
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
						document.location.href="../../eCommon/html/blank.html";
						parent.qryCriteria.document.ItemSearchCriteria_Form.next.disabled=true;						
						parent.qryCriteria.document.ItemSearchCriteria_Form.previous.disabled=true;
					}
			</script>
		<%
		}
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</form>
<script>activeLink();</script>
</html>
<%!

public String replaceNewLineChar(String message) {
		String changed			=		"";
        changed					=		 message.replaceAll("\n","\\n/");
		changed					=		 changed.replaceAll("\"","\\\"");
		changed					=		 changed.replaceAll("'","\\\\'");	
        return changed;
}
 /*/ Modified on 5/9/2006  as per TSG request
   public String replaceNewLineChar(String message) {
	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};
        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
					{
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
							i+=chChar[j].length();
							System.err.println("J="+j+" =="+sb);
                            continue upper;
                        }
                    }
System.err.println("i="+i+" =="+sb);
					}
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
	System.err.println("Return string="+sb.toString());
        return sb.toString();
    } */
%>

