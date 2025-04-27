<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.text.NumberFormat,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/DrugStockStatusByStore.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name="formStockStatusByStoreResult" id="formStockStatusByStoreResult">
<%
	String bean_id					=		"DrugStockStatusByStoreBean";
	String bean_name				=		"eST.DrugStockStatusByStoreBean";
	DrugStockStatusByStoreBean bean		=		(DrugStockStatusByStoreBean) getBeanObject(bean_id,  bean_name, request );  
	bean.setLanguageId(locale);
	bean.clear();
	String item_code_img    = "display:none";
	String atc_desc_img     = "display:none";
	String item_desc_img    = "display:none";
	String generic_name_img = "display:none";
	String qoh_img          = "display:none";
	//Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013
	String avail_qty_img    = "display:none";
	String uom_img          = "display:none";
	String unit_cost_img    = "display:none";
	String item_value_img   = "display:none";
	String stock_item_img   = "display:none";
	String Ro_level_img     = "display:none";
	//ends
	//String base_uom_qoh_img ="display:none";
	//String item_alpha_code_img = "display:none";
	//String dosage_form_img = "display:none";
	//String qty_on_hand_img = "display:none";
	
			
	String s1 ="../../eST/images/Ascending.gif";
	String s2 ="../../eST/images/Descending.gif";
	String sort_order = request.getParameter("sort_order");
	String item_code				=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code_from			=		request.getParameter( "store_code_from")==null?"":request.getParameter( "store_code_from") ;
	String store_code_to			=		request.getParameter( "store_code_to")==null?"":request.getParameter( "store_code_to") ;
	String item_desc				=		request.getParameter( "item_desc" )==null?"":request.getParameter( "item_desc" ) ;
	String stock_level				=		request.getParameter( "stock_level")==null?"":request.getParameter( "stock_level" ) ;
	String fm_item_class			=		request.getParameter( "fm_item_class")==null?"":request.getParameter( "fm_item_class" ) ;
	String to_item_class			=		request.getParameter( "to_item_class")==null?"":request.getParameter( "to_item_class" ) ;
	String fm_anal1					=		request.getParameter( "fm_anal1")==null?"":request.getParameter( "fm_anal1" ) ;
	String to_anal1					=		request.getParameter( "to_anal1")==null?"":request.getParameter( "to_anal1" ) ;
	String fm_anal2					=		request.getParameter( "fm_anal2")==null?"":request.getParameter( "fm_anal2" ) ;
	String to_anal2					=		request.getParameter( "to_anal2")==null?"":request.getParameter( "to_anal2" ) ;
	String fm_anal3					=		request.getParameter( "fm_anal3")==null?"":request.getParameter( "fm_anal3" ) ;
	String to_anal3					=		request.getParameter( "to_anal3")==null?"":request.getParameter( "to_anal3" ) ;
	String stock_item				=		request.getParameter( "stock_item" ).trim( )==null?"":request.getParameter( "stock_item" ) ;
	
//String item_alpha_code			=		request.getParameter( "item_alpha_code" )==null?"":request.getParameter( "item_alpha_code" ) ;
	//String dosage_form				=		request.getParameter( "dosage_form" )==null?"":request.getParameter( "dosage_form" ) ;
	String generic_name				=		request.getParameter( "generic_name" )==null?"":request.getParameter( "generic_name" ) ;
	
	String classvalue				=		"";
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	DecimalFormat dfTest1 = new DecimalFormat("###,###.00");
	
	int no_of_decimals=bean.getNoOfDecimals(); 
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	int count = 0;

	try{

		CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
		store_code_from				=		CommonBean.checkForNull(store_code_from);
		store_code_to				=		CommonBean.checkForNull(store_code_to);
		item_code					=		CommonBean.checkForNull(item_code);
		item_desc					=		CommonBean.checkForNull(item_desc)+"%";
		//stock_item					=		CommonBean.checkForNull(stock_item,"")+"%";
		stock_item					=		CommonBean.checkForNull(stock_item,"%");
		
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		String curr_item_store		=		"";
		String prev_item_store		=		"";
				
		//Commented by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013
		//String sql="SELECT DISTINCT x.store_code, store_desc, itm_code, item_desc, stock_item_yn,qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom,unit_cost, item_value, avail_qty, base_uom_qoh, issue_uom_avl, reorder_level,item_alpha_code,generic_name,dosage_form FROM (SELECT   store_code, store_desc,  itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, uom_desc, def_issue_uom, issue_uom, unit_cost, item_value, (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) avail_qty, base_uom_qoh,ROUND (NVL(  (SUM (  NVL (bt_qty_on_hand, 0) - NVL (committed_qty, 0) ) ) / NVL ((st_get_uom_conv_fac_sing_str (itm_code, store_code ) ), 1 ),0 ), 4 ) issue_uom_avl, reorder_level, item_alpha_code,generic_name,dosage_form FROM (SELECT DISTINCT stb.batch_id, a.store_code, b.short_desc store_desc, a.item_code itm_code, c.short_desc item_desc, a.stock_item_yn,NVL (a.qty_on_hand, 0) qty_on_hand, c.gen_uom_code gen_uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = c.gen_uom_code AND language_id = ?) uom_desc, a.def_issue_uom def_issue_uom, TRIM (st_display_cost_decimals (a.item_code, a.store_code ) ) unit_cost, item_value, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = a.def_issue_uom AND language_id = ?) issue_uom, stb.qty_on_hand bt_qty_on_hand, stb.committed_qty committed_qty, NVL (  NVL (a.qty_on_hand, 0) * NVL ((st_get_uom_conv_fac_sing_str (a.item_code, a.store_code ) ), 1 ), 0 ) base_uom_qoh, a.reorder_level reorder_level, c.alpha_code item_alpha_code,(SELECT generic_name FROM ph_generic_name_lang_vw phg, ph_drug_lang_vw phd WHERE phg.generic_id = phd.generic_id AND phd.item_code = a.item_code AND phg.language_id = phd.language_id AND phd.language_id = ? AND phd.drug_code = k.item_code ) generic_name, (SELECT form_desc FROM ph_form_lang_vw phf, ph_drug_lang_vw phd WHERE phf.form_code = phd.form_code AND phd.item_code = a.item_code AND phf.language_id = phd.language_id AND phf.language_id = ? AND phd.drug_code = k.item_code ) dosage_form FROM st_item_store a, mm_store_lang_vw b, mm_item_lang_vw c, st_store e, st_item_batch stb, st_item k WHERE a.store_code = b.store_code AND a.item_code = c.item_code AND a.store_code BETWEEN ? AND ? AND a.item_code = NVL (?, a.item_code) AND UPPER (c.short_desc) LIKE UPPER (?) AND (   (    NVL (a.qty_on_hand, 0) >= 0 AND 'A' = ? ) OR (    NVL (a.qty_on_hand, 0) > 0 AND 'S' = ? ) OR (    NVL (a.qty_on_hand, 0) = 0 AND 'Z' = ? ) OR (    NVL (a.qty_on_hand, 0) < NVL (a.reorder_level, 0)AND 'B' = ? ) ) AND (a.stock_item_yn LIKE (?)) AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = ? AND c.item_class_code BETWEEN NVL (?,'!') AND NVL (?,'~') AND NVL (c.item_anal1_code, 'X') BETWEEN NVL(?,NVL(c.item_anal1_code,'X')) AND NVL(?,NVL(c.item_anal1_code,'X')) AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (c.item_anal3_code, 'X') BETWEEN NVL(?,NVL (c.item_anal3_code,'X')) AND NVL(?,NVL (c.item_anal3_code,'X')) AND facility_id = ? AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (   expiry_yn = 'N' OR (    expiry_yn = 'Y' AND (   (    use_after_expiry_yn = 'Y' AND ('Y' = 'Y') ) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )) )) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level, item_alpha_code, generic_name,dosage_form, unit_cost, base_uom_qoh) x, st_acc_entity_param i, st_user_access_for_store j WHERE j.user_id LIKE (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN '%' WHEN i.restrict_view_stk_status = 'UAS' THEN ? END ) AND x.store_code = j.store_code";

			
	
	    //ADDED by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 23-July-2013
		String sql=  eST.Common.StRepository.getStKeyValue("SQL_ST_DRUG_STOCK_STATUS_BY_STORE_QUERY_RESULT");
		
	
	    chkFields.add(locale);
		chkFields.add(locale);
		chkFields.add(locale);
		//chkFields.add(locale);
		chkFields.add(locale); //atc_desc chk fileld
		chkFields.add(locale); //generic_id chk fileld
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
       	chkFields.add(item_code);
		
          if (!(item_desc.equals("%"))) {
			sql = sql + "  AND UPPER (c.short_desc) LIKE UPPER (?)" ;
			chkFields.add(item_desc); 
		 }
		 
		 if(stock_level.equals("A")){
		 sql = sql + " and NVL (a.qty_on_hand, 0) >=0 "; 
		 }else if(stock_level.equals("S")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) > 0 ";		
		}else if(stock_level.equals("Z")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) = 0 ";		
		}else if(stock_level.equals("B")){
  		 sql = sql + " and NVL (a.qty_on_hand, 0) < NVL (a.reorder_level,0) ";		
		}
		if (!stock_item.equals("%")) {
			sql = sql + "  AND a.stock_item_yn =  ? " ;
			chkFields.add(stock_item);
		}
		sql = sql + " AND b.eff_status = 'E' AND e.store_code = b.store_code AND e.store_type_flag != 'N' AND b.language_id = c.language_id AND b.language_id = ?";
		chkFields.add( locale);
		
		if (!(fm_item_class.equals("")) ||  !(to_item_class.equals(""))) {
		
		sql = sql + " AND  c.item_class_code BETWEEN NVL (?,'!') AND NVL (?,'~')"; 
		
		    chkFields.add(fm_item_class);
			chkFields.add(to_item_class);
		}
		
		if (!(fm_anal1.equals("")) ||  !(to_anal1.equals(""))) {

			sql = sql + " AND NVL (c.item_anal1_code, 'X') BETWEEN NVL(?,NVL(c.item_anal1_code,'X')) AND NVL(?,NVL(c.item_anal1_code,'X')) ";  
			
			chkFields.add(fm_anal1);
			chkFields.add(to_anal1);
		}
		
		
		 if (!(fm_anal2.equals("")) ||  !(to_anal2.equals(""))) {

			sql = sql + " AND NVL (c.item_anal2_code, 'X') BETWEEN NVL (?,NVL (c.item_anal2_code,'X')) AND NVL (?,NVL (c.item_anal2_code,'X')) ";

			chkFields.add(fm_anal2);
			chkFields.add(to_anal2);
		}
		if (!(fm_anal3.equals("")) ||  !(to_anal3.equals(""))) {
			sql = sql +  " AND NVL (c.item_anal3_code, 'X') BETWEEN NVL(?,NVL (c.item_anal3_code,'X')) AND NVL(?,NVL (c.item_anal3_code,'X'))" ;
			
			chkFields.add(fm_anal3);
			chkFields.add(to_anal3);
		}
		    String trn_across_facility_yn =		bean.checkForNull((String)bean.fetchRecord("select  trn_across_facility_yn  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("TRN_ACROSS_FACILITY_YN"),"N");
			if(trn_across_facility_yn.equals("N")){
            sql = sql + "  AND FACILITY_ID  = ? ";
		    chkFields.add(bean.getLoginFacilityId());
            }
		sql = sql + "  AND a.store_code = stb.store_code(+) AND a.item_code = stb.item_code(+) AND k.item_code = a.item_code AND (expiry_yn = 'N' OR (expiry_yn = 'Y' AND ((('Y' = 'Y')) OR decode(a.qty_on_hand, 0, sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('','dd/mm/yyyy'), SYSDATE )))) )) GROUP BY store_code, store_desc, itm_code, item_desc, stock_item_yn, qty_on_hand, gen_uom_code, item_value, def_issue_uom, gen_uom_code, uom_desc, issue_uom, reorder_level, generic_name,unit_cost, base_uom_qoh, generic_id, atc_class_lev4_desc, medical_item_yn,drug_item_yn,base_unit_cost) x, st_acc_entity_param i, st_user_access_for_store j WHERE j.user_id LIKE (CASE WHEN i.restrict_view_stk_status = 'ALL' THEN '%' WHEN i.restrict_view_stk_status = 'UAS' THEN ? END ) AND x.store_code = j.store_code";
		
		chkFields.add(bean.getLoginById());
		
		
		 if(sort_order.equals("")){
			// sort_order = " ORDER BY store_desc, item_desc";
			//Added by Rabbani #Inc no:42039 on 30-July-2013
			 //sort_order = " ORDER BY store_desc, medical_item_yn";
			 sort_order = " ORDER BY  store_desc,DRUG_ITEM_YN DESC, medical_item_yn DESC,UPPER(generic_name)";
		     generic_name_img ="display:''";
		 }else if(sort_order.contains("item_code")){
			 if(sort_order.contains("Asc")){
		     	sort_order = " ORDER BY store_desc,itm_code";
				item_code_img ="display:''";
			    s2=s1;
			}
			 if(sort_order.contains("Desc")){
		           sort_order = " ORDER BY store_desc,itm_code DESC";
	               item_code_img ="display:''";
			       s1=s2;
		         }		
		}else if(sort_order.contains("atc_class_lev4_desc")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     atc_desc_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   atc_desc_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("item_desc")){
		     if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  item_desc_img ="display:''";
			  s2=s1;
			}
			if(sort_order.contains("Desc")){
			   sort_order = " ORDER BY "+sort_order;
			   item_desc_img ="display:''";
			   s1=s2;			
			}
	     }else if(sort_order.contains("generic_name")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     generic_name_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc")){
               sort_order = " ORDER BY "+sort_order;
			   generic_name_img ="display:''";
			   s1=s2;			
			}
		}
		/*else if(sort_order.contains("BASE_UOM_QOH")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     base_uom_qoh_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc")){
               sort_order = " ORDER BY "+sort_order;
			   base_uom_qoh_img ="display:''";
			   s1=s2;			
			}
		}*/
		//Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013
		else if(sort_order.contains("qty_on_hand")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     qoh_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc")){
               sort_order = " ORDER BY "+sort_order;
			   qoh_img ="display:''";
			   s1=s2;			
			}
		}
		//else if(sort_order.contains("avail_qty")){
		else if(sort_order.contains("issue_uom_avl")){ //Added by Rabbani #Inc no:44420(RUT-SCF-0307) on 21-OCT-2013
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     avail_qty_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   avail_qty_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("issue_uom")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     uom_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   uom_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("unit_cost")){
            if(sort_order.contains("Asc")){
                 sort_order = " ORDER BY "+sort_order;
			     unit_cost_img ="display:''";
			     s2=s1;
			}
			if(sort_order.contains("Desc"))	{
               sort_order = " ORDER BY "+sort_order;
			   unit_cost_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("item_value")){
			if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  item_value_img ="display:''";
			  s2=s1;
			}else{
			   sort_order = " ORDER BY "+sort_order;
			   item_value_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("stock_item_yn")){
			if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  stock_item_img ="display:''";
			  s2=s1;
			 }else{
			   sort_order = " ORDER BY "+sort_order;
			   stock_item_img ="display:''";
			   s1=s2;			
			}
		}else if(sort_order.contains("reorder_level")){
			if(sort_order.contains("Asc")){
              sort_order = " ORDER BY "+sort_order;
			  Ro_level_img ="display:''";
			  s2=s1;
			}else{
			   sort_order = " ORDER BY "+sort_order;
			   Ro_level_img ="display:''";
			   s1=s2;			
			}
		}
		//ends
		
		 sqlMap.put("sqlData", sql+sort_order);
		
		displayFields.add("STORE_DESC");	
		displayFields.add("ITM_CODE");		
		displayFields.add("ITEM_DESC");
		displayFields.add("AVAIL_QTY");        
		displayFields.add("ISSUE_UOM");         
		displayFields.add("ISSUE_UOM_AVL");     
		
		displayFields.add("BASE_UOM_QOH");        
		displayFields.add("UOM_DESC");
		displayFields.add("QTY_ON_HAND");       
		displayFields.add("UNIT_COST");
		displayFields.add("ITEM_VALUE");
		displayFields.add("STOCK_ITEM_YN");
		displayFields.add("STORE_CODE");
		displayFields.add("REORDER_LEVEL"); //13
	  //displayFields.add("ITEM_ALPHA_CODE");
		displayFields.add("GENERIC_NAME");
	  //displayFields.add("DOSAGE_FORM");
		displayFields.add("ATC_CLASS_LEV4_DESC"); //15
		displayFields.add("GENERIC_ID"); //16
		displayFields.add("BASE_UNIT_COST"); //Added by Sakti against TTM-SCF-0106 to get base_unit_cost
		displayFields.add("ITEM_VALUE_NEW"); //Added by Sakti against TTM-SCF-0106 to get (base uom unit_cost*qty)item_value_new

		 
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table  border = 0 cellpadding=0 cellspacing=0 width="100%" align="center">
			  
			<tr>
				<td width="80%" class="white" >&nbsp;</td>
				<td width="20%" class="white" >&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<!--<table   cellpadding=0 cellspacing=1 width="100%" align="center">
				<%if(((String)bean.getAccessCostDetails()).equals("N")){%>
				<th nowrap width="64%" colspan=2>&nbsp;</th>
				<th nowrap colspan=3 width = "14%">Inventory On Hand</th>
				<th nowrap colspan=2>&nbsp;</th>
				<%}%>
				<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
                  <th nowrap width="64%" colspan=2>&nbsp;</th>
				<th  colspan=2 width = "14%">Inventory On Hand</th>
				<th nowrap colspan=2>&nbsp;</th>
                 <%}%>
			</table>-->
			    <table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
				<th nowrap width="15%" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="item_code"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}" />&nbsp;&nbsp;<img name="item_code" style=<%=item_code_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<!--Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013 -->
				<th nowrap width="18%" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="atc_class_lev4_desc"><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}" />&nbsp;&nbsp;<img name="atc_class_lev4_desc" style=<%=atc_desc_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<th nowrap style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="item_desc" width="15%"onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;<img name="item_desc_img" style=<%=item_desc_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<th nowrap style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="generic_name" width="15%" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;&nbsp;<img name="generic_name_img" style=<%=generic_name_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<!--Added by Rabbani #RUT-CRF-0068.1[Inc no:36976] on 19-July-2013 -->
				<!--<th nowrap style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="dosage_form" width="15%"onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');"><fmt:message key="eST.DosageForm.label" bundle="${st_labels}"/>&nbsp;&nbsp;<img name="dosage_form" style=  src=<%=s1%> border=none alt="Sort Order"></th>  -->
				<th colspan=2 width = "20%" align="center" > Inventory On Hand
				<table border="" width="100%" cellpadding="0" cellspacing="0" align="center"> 
				<th nowrap width="30%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="qty_on_hand" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">QOH&nbsp;<img name="qoh_img" style=<%=qoh_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				
				<th nowrap width="30%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="issue_uom_avl" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">Avl.Qty<img name="avail_qty_img" style=<%=avail_qty_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				</table></th>
				<th nowrap width="12%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="issue_uom" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">UOM<img name="uom_img" style=<%=uom_img%> src=<%=s1%> border=none alt="Sort Order"></th>
	
		<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
				<th nowrap width="12%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="unit_cost" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');"><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/><img name="unit_cost_img" style=<%=unit_cost_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<th nowrap width="12%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="item_value" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">Cost Value &nbsp;<img name="item_value_img" style=<%=item_value_img%> src=<%=s1%> border=none alt="Sort Order"></th>
		<%}%>	
				<th nowrap width="12%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="stock_item_yn" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');"><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/><img name="stock_item_img" style=<%=stock_item_img%> src=<%=s1%> border=none alt="Sort Order"></th>
				<th nowrap width="12%" style="WORD-BREAK:BREAK-ALL;cursor:pointer" name="reorder_level" onclick ="sortOrder(this,'../../eST/images/Ascending.gif','../../eST/images/Descending.gif');">RO Level<img name="Ro_level_img" style=<%=Ro_level_img%> src=<%=s1%> border=none alt="Sort Order"></th>
			</tr> 
			
			
				<%
						ArrayList records=new ArrayList();
						for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++) {
								classvalue			=	(recCount % 2 == 0)?"QRYEVEN":"QRYODD";
	
								records				=	(ArrayList) result.get(recCount);
							   count = Integer.parseInt((String)bean.fetchRecord(StRepository.getStKeyValue("SQL_ST_DRUG_STOCK_STATUS_BY_STORE_ATC_COUNT"),new String[]{CommonBean.checkForNull((String)records.get(16)), locale}).get("COUNT"));
				%>
			    <%
				
								curr_item_store		=		(String)records.get(0);
				if(!curr_item_store.equals(prev_item_store))
				{
				%>
				<tr>
				<td colspan=12 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b> 
				<%=CommonBean.checkForNull((String)records.get(0),"")%>&nbsp;</td>
							
				</tr>
				<%
								store_code_from			=		CommonBean.checkForNull((String)records.get(0),"");
			  }
			 else{%>
			<%}%>
				
		<tr id="tr_<%=k%>">
	<td class="<%=classvalue%>" onClick="callBatchSearchScreen('<%=(String)records.get(1)%>','<%=(String)records.get(12)%>' );" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(1)%></font></td>
	<%if(count>1){%>
	<td class="<%=classvalue%>" onClick="callATCdesc('<%=(String)records.get(16)%>');" onmouseover="changeCursor(this);" ><font size = 1 ><%=CommonBean.checkForNull((String)records.get(15),"&nbsp;")%></font><font size = 1 class='HYPERLINK'><b>...More</b></font></td>
	<%}else{%>
	<td class="<%=classvalue%>" align="left" style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=CommonBean.checkForNull((String)records.get(15),"&nbsp;")%></td>
	<%}%>
	<td class="<%=classvalue%>" align="left" style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
	<td class="<%=classvalue%>" align="left" style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=CommonBean.checkForNull((String)records.get(14),"&nbsp;")%></td>
	 
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=bean.setNumberFormat(bean.checkForNull((String)records.get(8),"0"),no_of_decimals)%></font></td>
 	
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1 ><%=bean.setNumberFormat(bean.checkForNull((String)records.get(5),"0"),no_of_decimals)%></font></td>
	<td class="<%=classvalue%>" align="left"><font size=1><%=bean.checkForNull((String)records.get(4),"&nbsp;")%></font></td>
	
	<% String val=CommonBean.checkForNull((String)records.get(17),"0"); %>
<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right" title="<%=val%>"><font size=1><%=bean.setNumberFormat(bean.checkForNull(val,"0"),noOfDecimalsForCost)%></font></td>
	<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1>
	<% String num=CommonBean.checkForNull((String)records.get(18),"0");
	%>
	
	<%=num.equals("0")? "0.00":bean.setNumberFormat(bean.checkForNull(num,"0"),noOfDecimalsForCost)%></font></td>
<%}%>
	<td class="<%=classvalue%>" align="center"><font size=1>
					
	<%
	if(CommonBean.checkForNull((String)records.get(11)).equals("Y"))
	out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
	out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

				%>
	
				</font></td>
				
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)records.get(13),"&nbsp;")%></font></td>
		<td class='NODISPLAY'><%=records.get(8)%></td>	
		  
      
		</tr>
			
		<%
			prev_item_store=curr_item_store;
			}
		%>
		
		<%
	
		} 
		else{
			

		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		
		}
		out.println(" </table>	</form>");
		out.flush();
		
		out.println(CommonBean.setForm (request ,"../../eST/jsp/DrugStockStatusByStoreResult.jsp", searched));

		
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());

		e.printStackTrace();
	}
%>
	<%
putObjectInBean(bean_id,bean,request);
%>
		
</body>
</html>

