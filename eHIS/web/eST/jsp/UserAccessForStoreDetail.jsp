<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
21/02/2016		IN0057461			B.Badmavathi					ML-MMOH-CRF-0448
21/04/2016		IN0056060			B.Badmavathi					Authorize at Issue Store	
06/04/2022		TFSID-23934											MO-CRF-20177
28/04/2022		TFSID-29303											MO-CRF-20174
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="javax.servlet.ServletContext, java.util.HashMap,java.sql.*, webbeans.eCommon.*, eST.UserAccessForStoreBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
	<title><fmt:message key="Common.UserAccessforStoreListing.label" bundle="${common_labels}"/></title>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale					= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eST/js/StTransaction.js'></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/UserAccessForStore.js"></script>
</head>

<body>
<center>
<form method=post name="UserAccessForStoreListForm" id="UserAccessForStoreListForm" action="" onMouseDown="CodeArrest()">
   <%
 	Connection con				= null;
	String mode									 =		"";
	String bean_id								 =		"";
	String bean_name							 =		"";
	String	grn_allowed_yn_disabled				 =		"";			
	String	rtv_allowed_yn_disabled				 =		""; 
	String	mfg_allowed_yn_disabled				 =		"";				
	String  req_allowed_yn_disabled				 =		""; 
	String	iss_allowed_yn_disabled				 =		""; 
	String	urg_allowed_yn_disabled				 =		""; 
	String	ret_allowed_yn_disabled				 =		""; 
	String	tfr_allowed_yn_disabled				 =		""; 
	String	adj_allowed_yn_disabled				 =		""; 
	String	var_allowed_yn_disabled				 =		""; 
	String	sal_allowed_yn_disabled				 =		""; 
	String	srt_allowed_yn_disabled				 =		""; 
    String	split_batch_allowed_yn_disabled		 =		""; 
	String	bin_change_allowed_yn_disabled		 =		""; 
	String	obs_allowed_yn_disabled				 =		""; 
	String	prt_allowed_yn_disabled				 =		""; 
	String  authorize_special_req_disabled		 =		"";
	String  stk_item_con_allowed_yn_disabled	 =		"";
	String user_id								 =		"";
	String store_code							 =		"";
	String dflt_item_search						 =      "";
	String cancel_req_checked					 =		"";
	String trn_type  = "null";
	//String dis								 =		"";
	String interface_to_external_po_yn			 =		"";
	String	prq_allowed_yn_disabled				 =		""; 
	String	prq_allowed_yn_disabled_grn			 =		""; 
	String	cndmn_exp_btch_allowed_yn_disabled	 =		""; 
	String  display								 =		"";
	String view_sale_yn_visibility               =     "visibility:hidden";
	String view_cost_yn_visibility               =     "visibility:hidden";
    String display_flag					         =        "visibility:hidden";
    String view_sale_yn_checked			         =		"";
    String view_cost_yn_checked				     =		"";
	bean_id										 =		"userAccessForStoreBean" ;
	bean_name									 =		"eST.UserAccessForStoreBean";
	user_id										 =		 request.getParameter("user_id");
	store_code									 =		 request.getParameter("store_code");
	String dflt_sal_type						 =      "";   // Added by Padmapriya
	String disp_curr_enc_findtl_yn				 =		request.getParameter("disp_curr_enc_findtl_yn");	//Added by suresh.r 12-11-2013 against JD-CRF-156
	String disp_min_rol_yn				 =		"";
	String authorize_at_issue_store_allowed_yn ="";//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
	String authorize_allowed_yn_disabled	   ="";//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
	

	// Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria

	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
	    dflt_item_search						 =		 request.getParameter("dflt_item_search")==null?"":request.getParameter("dflt_item_search");
		dflt_sal_type						 =		 request.getParameter("dflt_sal_type")==null?"":request.getParameter("dflt_sal_type");  //Added by Padmapriya
	}else{
	    dflt_item_search						 =		 request.getParameter("dflt_item_search")==null?"":request.getParameter("dflt_item_search");
		dflt_sal_type						 =		 request.getParameter("dflt_sal_type")==null?"":request.getParameter("dflt_sal_type");  //Added by Padmapriya
	}
	//Added ends
	
	UserAccessForStoreBean bean					 =		(UserAccessForStoreBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);	
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts 
	String prt_final_visibility               =     "visibility:hidden";
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_PRODUCT_TRANSFER");
	bean.setSite_spec_yn(site_main);
	boolean site=bean.isSite_spec_yn();
	//Added for ML-MMOH-CRF-0448 B.Badmavathi ends

	
	bean.clear();

	try{
	ServletContext context						=	getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ;

	bean.setUser_id(user_id);
	bean.setStore_code(store_code);
     disp_min_rol_yn				            =		bean.checkForNull(request.getParameter("disp_min_rol_yn"),"N");
	HashMap hmRecord							=	bean.getStoreData();
	HashMap hmRecordForUserAccess				=	bean.getUserAccessForStoreData();

	if ((hmRecordForUserAccess!=null)&&(hmRecordForUserAccess.size()>0)) {

		bean.initialize(hmRecordForUserAccess);
		 context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	
		bean.setMode( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ;
		bean.setUser_id(user_id);
	    bean.setStore_code(store_code);
		}
 
	    mode=bean.getMode();
	   if (hmRecord.get("OBS_ALLOWED_YN").toString().equals("N")){
		obs_allowed_yn_disabled="disabled";
		bean.setObs_allowed_yn("N");
	   }
	   //Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts
	   if (hmRecord.get("AUTHORIZE_AT_ISSUE_ALLOWED_YN").toString().equals("N")){
			authorize_allowed_yn_disabled="disabled";
			bean.setAuthorize_at_issue_store_allowed_yn("N");
	   }
	   //Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
		if(bean.getCancelRequest_yn().equals("N"))
			cancel_req_checked="";
		else
			cancel_req_checked="checked";
				
	interface_to_external_po_yn=bean.getInterface_to_external_po_yn((String)session.getAttribute("ACC_ENTITY_ID"));
	
    if (hmRecord.get("RTV_ALLOWED_YN").toString().equals("N")){
		rtv_allowed_yn_disabled="disabled";
		bean.setRtv_allowed_yn("N");
        bean.setRtv_finalize_allowed_yn("N");
        bean.setRtv_delete_yn("N");
	}

    if (hmRecord.get("ISS_ALLOWED_YN").toString().equals("N")){
		iss_allowed_yn_disabled="disabled";
		bean.setIss_allowed_yn("N");
		bean.setIss_finalize_allowed_yn("N");
		bean.setIss_delete_yn("N");
	}

    if (hmRecord.get("RET_ALLOWED_YN").toString().equals("N")){
		ret_allowed_yn_disabled="disabled";
		bean.setRet_allowed_yn("N");
		bean.setRet_finalize_allowed_yn("N");
		bean.setRet_delete_yn("N");
		
	}

    if (hmRecord.get("ADJ_ALLOWED_YN").toString().equals("N")){
		adj_allowed_yn_disabled="disabled";
		bean.setAdj_allowed_yn("N");
		bean.setAdj_finalize_allowed_yn("N");
		bean.setAdj_delete_yn("N");
	}

	if (hmRecord.get("PRT_ALLOWED_YN").toString().equals("N")){
		prt_allowed_yn_disabled="disabled";
		bean.setPrt_allowed_yn("N");
		bean.setPrt_delete_yn("N");
	}

	if (hmRecord.get("SPLIT_BATCH_ALLOWED_YN").toString().equals("N")){
		split_batch_allowed_yn_disabled="disabled";
        bean.setSplit_batch_allowed_yn("N");    
	}

	


    if (hmRecord.get("SAL_ALLOWED_YN").toString().equals("N")){
		sal_allowed_yn_disabled="disabled";
		bean.setSal_allowed_yn("N");
		bean.setSal_authorize_allowed_yn("N");
		bean.setSal_delete_yn("N");
	}

	if (hmRecord.get("STK_ITEM_CON_ALLOWED_YN").toString().equals("N")){
		stk_item_con_allowed_yn_disabled="disabled";
		bean.setStk_item_con_allowed_yn("N");
	}

	
 
    if (hmRecord.get("GRN_ALLOWED_YN").toString().equals("N")){
		grn_allowed_yn_disabled="disabled";
		bean.setGrn_allowed_yn("N");
		bean.setGrn_finalize_allowed_yn("N");
		bean.setGrn_delete_yn("N");
		prq_allowed_yn_disabled_grn="disabled";
	}

    


    if (hmRecord.get("URG_ALLOWED_YN").toString().equals("N")){
		urg_allowed_yn_disabled="disabled";
		bean.setUrg_allowed_yn("N");
		bean.setUrg_finalize_allowed_yn("N");
		bean.setUrg_delete_yn("N");
	}

	if (hmRecord.get("MFG_ALLOWED_YN").toString().equals("N")){
		mfg_allowed_yn_disabled="disabled";
		bean.setMfg_allowed_yn("N");
		bean.setMfg_finalize_allowed_yn("N");
		bean.setMfg_delete_yn("N");
	}

	if (hmRecord.get("TFR_ALLOWED_YN").toString().equals("N")){
		tfr_allowed_yn_disabled="disabled";
		bean.setTfr_allowed_yn("N");
		bean.setTfr_finalize_allowed_yn("N");
		bean.setTfr_delete_yn("N");
	}

	if (hmRecord.get("VAR_ALLOWED_YN").toString().equals("N")){
		var_allowed_yn_disabled="disabled";
		bean.setVar_allowed_yn("N");
	}

    if (hmRecord.get("BIN_CHANGE_ALLOWED_YN").toString().equals("N")){
		bin_change_allowed_yn_disabled="disabled";
		bean.setBin_change_allowed_yn("N");
	}

	if (hmRecord.get("REQ_ALLOWED_YN").toString().equals("N")){
		req_allowed_yn_disabled="disabled";
		bean.setReq_allowed_yn("N");
		bean.setReq_authorize_allowed_yn("N");
		bean.setReq_delete_yn("N");
	}
   
	if (hmRecord.get("SRT_ALLOWED_YN").toString().equals("N")){
		srt_allowed_yn_disabled="disabled";
		bean.setSrt_allowed_yn("N");
		bean.setSrt_finalize_allowed_yn("N");
		bean.setSrt_delete_yn("N");
	}

	if (hmRecord.get("AUTHORIZE_SPECIAL_REQ_YN").toString().equals("N")){
		authorize_special_req_disabled="disabled";
		bean.setAuthorizeSpecialReq_yn("N");
	}

	if (hmRecord.get("PRQ_ALLOWED_YN").toString().equals("N")){
		prq_allowed_yn_disabled="disabled";
		bean.setPRQ_allowed_yn("N");
		bean.setPRQ_finalize_allowed_yn("N");
		bean.setPrq_delete_yn("N");
	}
	
	
	//if (hmRecord.get("DISP_MIN_ROL_YN").toString().equals("N")){
	//	bean.setDisp_min_rol_yn("N");
	//}
	




//getCndmn_exp_btch_allowed_yn
	if (hmRecord.get("CNDMN_EXP_BTCH_ALLOWED_YN").toString().equals("N")){
		cndmn_exp_btch_allowed_yn_disabled="disabled";
		bean.setCndmn_exp_btch_allowed_yn("N");
	}
	
	//Added By Rabbani #inc no:28266 on 16/09/11 
	//Starts Here
	         if(bean.getView_sale_yn().equals("Y"))
			view_sale_yn_checked = "checked"; 
			
			if(bean.getView_cost_yn().equals("Y")) 
			  view_cost_yn_checked = "checked"; 
		     
		ArrayList  alist =  bean.getTrnTypeArrayList();
	   for(int i=0; i<alist.size(); i++){
	   HashMap  blist = (HashMap)alist.get(i);
	   for(int j=0; j<blist.size(); j++){
	    trn_type = (String)blist.get("TRNTYPE");
	       if(trn_type.equals("TFR")){
		              display = "visible";
				     view_sale_yn_visibility			=		"visibility:visible";
					 view_cost_yn_visibility			=		"visibility:visible";
					 display_flag				        =       "visibility:visible";
		   }
		  }
	    }
           //Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013 Starts
					 HashMap hmrecords = new HashMap();
					 hmrecords = bean.getAckReqdyn();
					 String iss_ack_reqd_yn  = bean.checkForNull((String)hmrecords.get("ISS_ACK_REQ_YN"),"N");
					 String urg_ack_reqd_yn  = bean.checkForNull((String)hmrecords.get("URG_ACK_REQ_YN"),"N");
					 String ret_ack_reqd_yn  = bean.checkForNull((String)hmrecords.get("RET_ACK_REQ_YN"),"N");
					 String tfr_ack_reqd_yn  = bean.checkForNull((String)hmrecords.get("TFR_ACK_REQ_YN"),"N");
//					 System.err.println("hmrecords==>" +hmrecords);		
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts 
  	if(site)
	 {
              	prt_final_visibility			=		"visibility:visible";
	   }	//Added for ML-MMOH-CRF-0448 B.Badmavathi ends

%>
		
<table border="1" cellpadding="0" cellspacing="0" width=100% align="center">
     <tr>
       <th colspan=2><fmt:message key="eST.TransactionApplicable.label" bundle="${st_labels}"/></th>
       <th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/>/<br><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></th>
	   <th><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
<%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
	   <th><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></th>
	   <th><fmt:message key="eST.Confirm.label" bundle="${st_labels}"/></th>
<%}%>
	   <th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
       <th colspan=2><fmt:message key="eST.TransactionApplicable.label" bundle="${st_labels}"/></th>
       <th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/>/<br><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></th>
       <th wrap><fmt:message key="eST.PromptForFinalize.label" bundle="${st_labels}"/></th>
<%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
	  <th><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></th>
	  <th><fmt:message key="eST.Confirm.label" bundle="${st_labels}"/></th>
<%}%>
      <th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
<%if(display.equals("visible")){%>
      <th style=<%=display_flag%>><fmt:message key="eST.costprice.label" bundle="${st_labels}"/></th>
      <th style=<%=display_flag%>><fmt:message key="eST.saleprice.label" bundle="${st_labels}"/></th>
<%}%>
 	</tr>
     <tr>
       <td class = "QRYODD"><fmt:message key="eST.OpeningStock.label" bundle="${st_labels}"/></td>
       <td align='center' class = "QRYODD"><input type=checkbox name="obs_allowed_yn" id="obs_allowed_yn"  value="Y" <%=obs_allowed_yn_disabled%> <%=bean.getChecked(bean.getObs_allowed_yn())%>></td>
       <td align='center' class = "QRYODD">&nbsp;</td>
       <td align='center' class = "QRYODD">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
       <%}%>
	    <td align='center' class = "QRYODD">&nbsp;</td>
        <td class = "QRYODD"><fmt:message key="eST.GoodsReceipt.label" bundle="${st_labels}"/> </td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="grn_allowed_yn" id="grn_allowed_yn"  value="Y" onclick =' checkfinalizeapplicable(grn_allowed_yn,grn_finalize_allowed_yn,"","",grn_delete_yn,grn_finalize_prompt_yn);disablePrq(this,"<%=interface_to_external_po_yn%>","<%=(String)hmRecord.get("PRQ_ALLOWED_YN")%>");'   <%=grn_allowed_yn_disabled%> <%=bean.getChecked(bean.getGrn_allowed_yn())%>></td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="grn_finalize_allowed_yn" id="grn_finalize_allowed_yn"  onclick =' checkfinalizepromptapplicable(this,grn_finalize_prompt_yn)'  value="Y" <%=bean.getGrn_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getGrn_finalize_allowed_yn())%>></td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="grn_finalize_prompt_yn" id="grn_finalize_prompt_yn"  value="Y" <%=bean.getGrn_allowed_yn().equals("Y") && bean.getGrn_finalize_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getGrn_finalize_prompt_yn())%>></td>
	  <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
	  <%}%>
	  <td align='center' class = "QRYODD"><input type=checkbox name="grn_delete_yn" id="grn_delete_yn"  value="Y" <%=bean.getGrn_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getGrn_delete_yn())%>></td>
	  <%if(display.equals("visible")){%>
	  <td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
	  <td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
	  <%}%>
     </tr>

     <tr>
	   <td class = "QRYEVEN"><fmt:message key="eST.VendorReturn.label" bundle="${st_labels}"/></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox name="rtv_allowed_yn" id="rtv_allowed_yn"  onclick ='checkfinalizeapplicable(rtv_allowed_yn,rtv_finalize_allowed_yn,"","",rtv_delete_yn,rtv_finalize_prompt_yn)' 	 value="Y" <%=rtv_allowed_yn_disabled%> <%=bean.getChecked(bean.getRtv_allowed_yn())%>></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox name="rtv_finalize_allowed_yn" id="rtv_finalize_allowed_yn"  onclick =' checkfinalizepromptapplicable(this,rtv_finalize_prompt_yn)'  value="Y" <%=bean.getRtv_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getRtv_finalize_allowed_yn())%>></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox name="rtv_finalize_prompt_yn" id="rtv_finalize_prompt_yn"  value="Y" <%=bean.getRtv_allowed_yn().equals("Y") && bean.getRtv_finalize_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getRtv_finalize_prompt_yn())%>></td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%}%>
	   <td align='center' class = "QRYEVEN"><input type=checkbox name="rtv_delete_yn" id="rtv_delete_yn"  value="Y" <%=bean.getRtv_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getRtv_delete_yn())%>></td>
	   <td class = "QRYEVEN"><fmt:message key="eST.Requisition.label" bundle="${st_labels}"/></td>
	   <td align='center' class = "QRYEVEN"><input type=checkbox  name="req_allowed_yn" id="req_allowed_yn"  value="Y"  onclick =' checkfinalizeapplicable(req_allowed_yn,req_authorize_allowed_yn,"","",req_delete_yn,req_authorize_prompt_yn)'  <%=req_allowed_yn_disabled%> <%=bean.getChecked(bean.getReq_allowed_yn())%>></td>
	   <td align='center' class = "QRYEVEN"><input type=checkbox  name="req_authorize_allowed_yn" id="req_authorize_allowed_yn"  onclick =' checkfinalizepromptapplicable(this,req_authorize_prompt_yn)' value="Y" <%=bean.getReq_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getReq_authorize_allowed_yn())%>></td>
	   <td align='center' class = "QRYEVEN"><input type=checkbox  name="req_authorize_prompt_yn" id="req_authorize_prompt_yn"  value="Y" <%=bean.getReq_allowed_yn().equals("Y") && bean.getReq_authorize_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getReq_authorize_prompt_yn())%>></td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		<%}%>  
		<td align='center' class = "QRYEVEN"><input type=checkbox name="req_delete_yn" id="req_delete_yn"  value="Y" <%=bean.getReq_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getReq_delete_yn())%>></td>
		<%if(display.equals("visible")){%>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%> >&nbsp;</td>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%> >&nbsp;</td>
		<%}%>
     </tr>
	<tr>
	<!--Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts-->
   	 	<td class = "QRYODD"><fmt:message key="eST.AuthorizeatIssueStore.label" bundle="${st_labels}"/></td>
		<td align='center' class = "QRYODD"><input type="checkbox"  name="authorize_at_issue_store_allowed_yn" id="authorize_at_issue_store_allowed_yn"  	value="Y" <%=authorize_allowed_yn_disabled%>  <%=bean.getChecked(bean.getAuthorize_at_issue_store_allowed_yn())%> ></td>
		<td align='center' class = "QRYODD">&nbsp;</td>
		<td align='center' class = "QRYODD">&nbsp;</td>
	    <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
		<%}%>
		<td align='center' class = "QRYODD">&nbsp;</td>
	<!--Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends-->	
		<td class = "QRYODD"><fmt:message key="eST.RequisitionIssues.label" bundle="${st_labels}"/></td>
        <td align='center' class = "QRYODD"><input type=checkbox name="iss_allowed_yn" id="iss_allowed_yn"  onclick =" checkfinalizeapplicable(iss_allowed_yn,iss_finalize_allowed_yn,iss_acknowledge_yn,iss_confirm_yn,iss_delete_yn,iss_finalize_prompt_yn)" value="Y" <%=iss_allowed_yn_disabled%>  <%=bean.getChecked(bean.getIss_allowed_yn())%>></td>
        <td align='center' class = "QRYODD"><input type=checkbox name="iss_finalize_allowed_yn" id="iss_finalize_allowed_yn"  onclick =' checkfinalizepromptapplicable(this,iss_finalize_prompt_yn)'  value="Y" <%=bean.getIss_allowed_yn().equals("N")?"disabled":""%> <%=bean.getChecked(bean.getIss_finalize_allowed_yn())%>></td>
        <td align='center' class = "QRYODD"><input type=checkbox name="iss_finalize_prompt_yn" id="iss_finalize_prompt_yn"  value="Y" <%=bean.getIss_allowed_yn().equals("Y") && bean.getIss_finalize_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getIss_finalize_prompt_yn())%>></td>
	    <%if(bean.getAckReqdForIssue() ){%>
	    <!-- Added by Rabbani #Bru-HIMS-CRF-112 -->
	       <%if(iss_ack_reqd_yn.equals("N")){%>
			   <td class="QRYODD"><input type=checkbox name="iss_acknowledge_yn" id="iss_acknowledge_yn"  value="Y"  disabled ></td>
		   <%}else{%>
		   		<td class="QRYODD"><input type=checkbox name="iss_acknowledge_yn" id="iss_acknowledge_yn"  value="Y" <%=bean.getIss_allowed_yn().equals("N")?"disabled":""%> <%=bean.getChecked(bean.getIss_acknowledge_yn())%>></td>
		   <%}%>
		 <td class="QRYODD"><input type=checkbox name="iss_confirm_yn" id="iss_confirm_yn"  value="Y" <%=bean.getIss_allowed_yn().equals("N")?"disabled":""%> <%=bean.getChecked(bean.getIss_confirm_yn())%>></td>
	   		<%}else if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		 		<td align='center' class = "QRYODD">&nbsp;</td>
		  		<td align='center' class = "QRYODD">&nbsp;</td>	
	   		<%}%>
	   	<td align='center' class = "QRYODD"><input type=checkbox name="iss_delete_yn" id="iss_delete_yn"  value="Y" <%=bean.getIss_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getIss_delete_yn())%>></td>
	   	<%if(display.equals("visible")){%>
			<td align='center' class = "QRYODD" style=<%=display_flag%> >&nbsp;</td>
			<td align='center' class = "QRYODD" style=<%=display_flag%> >&nbsp;</td>
		<%}%>       
	</tr>
	<tr>
       <td class = "QRYEVEN"><fmt:message key="eST.UrgentIssue.label" bundle="${st_labels}"/></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox  name="urg_allowed_yn" id="urg_allowed_yn"  value="Y" onclick =" checkfinalizeapplicable(urg_allowed_yn,urg_finalize_allowed_yn,urg_acknowledge_yn,urg_confirm_yn,urg_delete_yn,urg_finalize_prompt_yn)"  <%=urg_allowed_yn_disabled%>  <%=bean.getChecked(bean.getUrg_allowed_yn())%>></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox  name="urg_finalize_allowed_yn" id="urg_finalize_allowed_yn" onclick =' checkfinalizepromptapplicable(this,urg_finalize_prompt_yn)'  value="Y" <%=bean.getUrg_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getUrg_finalize_allowed_yn())%>></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox  name="urg_finalize_prompt_yn" id="urg_finalize_prompt_yn"  value="Y" <%=bean.getUrg_allowed_yn().equals("Y") && bean.getUrg_finalize_allowed_yn().equals("Y") ?"":"disabled"%> <%=bean.getChecked(bean.getUrg_finalize_prompt_yn())%>></td>
	   <%if(bean.getAckReqdForIssue()){%>
	   <!-- Added by Rabbani #Bru-HIMS-CRF-112 -->
	   	   <%if(urg_ack_reqd_yn.equals("N")){%>
		  		<td class="QRYEVEN"><input type=checkbox name="urg_acknowledge_yn" id="urg_acknowledge_yn"  value="Y"  disabled ></td>
		   <%}else{%>
		   		<td class = "QRYEVEN"><input type=checkbox  name="urg_acknowledge_yn" id="urg_acknowledge_yn"  value="Y" <%=bean.getUrg_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getUrg_acknowledge_yn())%>></td>
		   <%}%>
		   <td class = "QRYEVEN"><input type=checkbox  name="urg_confirm_yn" id="urg_confirm_yn"  value="Y" <%=bean.getUrg_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getUrg_confirm_yn())%>></td>
	   <%}else if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>	
	   <%}%>
	   <td align='center' class = "QRYEVEN"><input type=checkbox name="urg_delete_yn" id="urg_delete_yn"  value="Y" <%=bean.getUrg_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getUrg_delete_yn())%>></td>
		
	   <td class = "QRYEVEN"><fmt:message key="eST.IssueReturns.label" bundle="${st_labels}"/></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox name="ret_allowed_yn" id="ret_allowed_yn"   onclick =" checkfinalizeapplicable(ret_allowed_yn,ret_finalize_allowed_yn,ret_acknowledge_yn,ret_confirm_yn,ret_delete_yn,ret_finalize_prompt_yn)"   value="Y" <%=ret_allowed_yn_disabled%>  <%=bean.getChecked(bean.getRet_allowed_yn())%>></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox name="ret_finalize_allowed_yn" id="ret_finalize_allowed_yn" onclick =' checkfinalizepromptapplicable(this,ret_finalize_prompt_yn)'  value="Y" <%=bean.getRet_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getRet_finalize_allowed_yn())%>></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox name="ret_finalize_prompt_yn" id="ret_finalize_prompt_yn" value="Y" <%=bean.getRet_allowed_yn().equals("Y") && bean.getRet_finalize_allowed_yn().equals("Y") ?"":"disabled"%> <%=bean.getChecked(bean.getRet_finalize_prompt_yn())%>></td>
	   <%if( bean.getAckReqdForIssueReturn()){%>
	    <!-- Added by Rabbani #Bru-HIMS-CRF-112 -->
	 	 <%if(ret_ack_reqd_yn.equals("N")){%>
		   <td class="QRYEVEN"><input type=checkbox name="ret_acknowledge_yn" id="ret_acknowledge_yn"  value="Y"  disabled ></td>
		   <%}else{%>
		   <td class = "QRYEVEN"><input type=checkbox name="ret_acknowledge_yn" id="ret_acknowledge_yn" value="Y" <%=bean.getRet_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getRet_acknowledge_yn())%>></td>
		   <%}%>
		   <td class = "QRYEVEN"><input type=checkbox name="ret_confirm_yn" id="ret_confirm_yn" value="Y" <%=bean.getRet_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getRet_confirm_yn())%>></td>
	     <%}else if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		 	<td align='center' class = "QRYEVEN">&nbsp;</td>
		 	<td align='center' class = "QRYEVEN">&nbsp;</td>	
	   <%}%>
	   <td align='center' class = "QRYEVEN"><input type=checkbox name="ret_delete_yn" id="ret_delete_yn"  value="Y" <%=bean.getRet_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getRet_delete_yn())%>></td>
       <%if(display.equals("visible")){%>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%> >&nbsp;</td>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%> >&nbsp;</td>
		<%}%>
     </tr> 

     <tr>
        <td class = "QRYODD"><fmt:message key="eST.ManufacturingItems.label" bundle="${st_labels}"/></td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="mfg_allowed_yn" id="mfg_allowed_yn"  value="Y"	 onclick =' checkfinalizeapplicable(document.UserAccessForStoreListForm.mfg_allowed_yn,document.UserAccessForStoreListForm.mfg_finalize_allowed_yn,"","",mfg_delete_yn,mfg_finalize_prompt_yn)'  <%=mfg_allowed_yn_disabled%> <%=bean.getChecked(bean.getMfg_allowed_yn())%>></td>
        <td align='center' class = "QRYODD"><input type=checkbox name="mfg_finalize_allowed_yn" id="mfg_finalize_allowed_yn"  onclick =' checkfinalizepromptapplicable(this,mfg_finalize_prompt_yn)'  value="Y" <%=bean.getMfg_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getMfg_finalize_allowed_yn())%>></td>
        <td align='center' class = "QRYODD"><input type=checkbox name="mfg_finalize_prompt_yn" id="mfg_finalize_prompt_yn"  value="Y" <%=bean.getMfg_allowed_yn().equals("Y") && bean.getMfg_finalize_allowed_yn().equals("Y") ?"":"disabled"%> <%=bean.getChecked(bean.getMfg_finalize_prompt_yn())%>></td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
	   <%}%>
	   <td align='center' class = "QRYODD"><input type=checkbox name="mfg_delete_yn" id="mfg_delete_yn"  value="Y" <%=bean.getMfg_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getMfg_delete_yn())%>></td>
	  
	   <td class = "QRYODD"><fmt:message key="eST.StockAdjustment.label" bundle="${st_labels}"/></td>
       <td align='center' class = "QRYODD"><input type=checkbox name="adj_allowed_yn" id="adj_allowed_yn"  onclick =' checkfinalizeapplicable(adj_allowed_yn,adj_finalize_allowed_yn,"","",adj_delete_yn,adj_finalize_prompt_yn)'	 value="Y" <%=adj_allowed_yn_disabled%> <%=bean.getChecked(bean.getAdj_allowed_yn())%>></td>
       <td align='center' class = "QRYODD"><input type=checkbox  name="adj_finalize_allowed_yn" id="adj_finalize_allowed_yn"  onclick =' checkfinalizepromptapplicable(this,adj_finalize_prompt_yn)'  value="Y" <%=bean.getAdj_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getAdj_finalize_allowed_yn())%>></td>
       <td align='center' class = "QRYODD"><input type=checkbox  name="adj_finalize_prompt_yn" id="adj_finalize_prompt_yn"  value="Y" <%=bean.getAdj_allowed_yn().equals("Y") && bean.getAdj_finalize_allowed_yn().equals("Y") ?"":"disabled"%> <%=bean.getChecked(bean.getAdj_finalize_prompt_yn())%>></td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
       <%}%>
	   <td align='center' class = "QRYODD"><input type=checkbox name="adj_delete_yn" id="adj_delete_yn"  value="Y" <%=bean.getAdj_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getAdj_delete_yn())%>></td>
       <%if(display.equals("visible")){%>
	   <td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
	   <td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
	   <%}%>
	 </tr>

     <tr>
     <td class = "QRYEVEN"><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></td>
       <!--	Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->
       	<td align='center' class = "QRYEVEN"><input type=checkbox name="prt_allowed_yn" id="prt_allowed_yn"   onclick =' checkfinalizeapplicable(prt_allowed_yn,prt_finalize_allowed_yn,"","",prt_delete_yn,prt_finalize_prompt_yn)' value="Y" <%=prt_allowed_yn_disabled%> <%=bean.getChecked(bean.getPrt_allowed_yn())%>></td>
             
        <td align='center' class = "QRYEVEN"  ><input type=checkbox name="prt_finalize_allowed_yn" id="prt_finalize_allowed_yn"  style = "<%=prt_final_visibility%>" onclick =' checkfinalizepromptapplicable(this,prt_finalize_prompt_yn)'  value="Y" <%=bean.getPrt_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getPrt_finalize_allowed_yn())%>></td> <!--  Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 -->
        <td align='center' class = "QRYEVEN"   ><input type=checkbox name="prt_finalize_prompt_yn" id="prt_finalize_prompt_yn" style = "<%=prt_final_visibility%>" value="Y" <%=bean.getPrt_allowed_yn().equals("Y") && bean.getPrt_finalize_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getPrt_finalize_prompt_yn())%>></td>  <!--  Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 -->
	<!-- 	Added for ML-MMOH-CRF-0448 B.Badmavathi ends--> 
	    <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
	    <%}%>
        <td align='center' class = "QRYEVEN"><input type=checkbox name="prt_delete_yn" id="prt_delete_yn"  value="Y" <%=bean.getPrt_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getPrt_delete_yn())%>></td>
       
        <td class = "QRYEVEN"><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></td>
        <td align='center' class = "QRYEVEN"><input type=checkbox  name="tfr_allowed_yn" id="tfr_allowed_yn"  value="Y" 	onclick =" checkfinalizeapplicable(tfr_allowed_yn,tfr_finalize_allowed_yn,tfr_acknowledge_yn,tfr_confirm_yn,tfr_delete_yn,tfr_finalize_prompt_yn)" 	<%=tfr_allowed_yn_disabled%> <%=bean.getChecked(bean.getTfr_allowed_yn())%>></td>
        <td align='center' class = "QRYEVEN"><input type=checkbox  name="tfr_finalize_allowed_yn" id="tfr_finalize_allowed_yn" onclick =' checkfinalizepromptapplicable(this,tfr_finalize_prompt_yn)'  value="Y" <%=bean.getTfr_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getTfr_finalize_allowed_yn())%>></td>
        <td align='center' class = "QRYEVEN"><input type=checkbox  name="tfr_finalize_prompt_yn" id="tfr_finalize_prompt_yn"  value="Y" <%=bean.getTfr_allowed_yn().equals("Y") && bean.getTfr_finalize_allowed_yn().equals("Y") ?"":"disabled"%> <%=bean.getChecked(bean.getTfr_finalize_prompt_yn())%>></td>
	    <%if(bean.getAckReqdForStockTransfer()){%>
	         <!-- Added by Rabbani #Bru-HIMS-CRF-112 -->
	        <%if(tfr_ack_reqd_yn.equals("N")){%>
			   <td class="QRYEVEN"><input type=checkbox name="tfr_acknowledge_yn" id="tfr_acknowledge_yn"  value="Y"  disabled ></td>
		    <%}else{%>
			   <td class = "QRYEVEN"><input type=checkbox  name="tfr_acknowledge_yn" id="tfr_acknowledge_yn"  value="Y" <%=bean.getTfr_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getTfr_acknowledge_yn())%>></td>
			<%}%>
			<td class = "QRYEVEN"><input type=checkbox  name="tfr_confirm_yn" id="tfr_confirm_yn"  value="Y" <%=bean.getTfr_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getTfr_confirm_yn())%>></td>
	    <%}else if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		 	<td align='center' class = "QRYEVEN">&nbsp;</td>
		    <td align='center' class = "QRYEVEN">&nbsp;</td>	
	   <%}%>
		<td align='center' class = "QRYEVEN"><input type=checkbox name="tfr_delete_yn" id="tfr_delete_yn"  value="Y" <%=bean.getTfr_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getTfr_delete_yn())%>></td>
		<%if(display.equals("visible")){%>
			<td align='center' class = "QRYEVEN"  style = "<%=view_cost_yn_visibility%>" ><input type=checkbox name="view_cost_yn" id="view_cost_yn"  onClick="setValue(this);" value="Y" <%=bean.getChecked(bean.getView_cost_yn())%>></td>
       		<td align='center' class = "QRYEVEN"  style = "<%=view_sale_yn_visibility%>"  ><input type=checkbox name="view_sale_yn" id="view_sale_yn"  onClick="setValue(this);" value="Y" <%=bean.getChecked(bean.getView_sale_yn())%>></td>  
	   <%}%>
     </tr>

     <tr>
     <td class = "QRYODD"><fmt:message key="eST.SplitBatches.label" bundle="${st_labels}"/></td>
       <td align='center' class = "QRYODD"><input type=checkbox name="split_batch_allowed_yn" id="split_batch_allowed_yn"  value="Y" <%=split_batch_allowed_yn_disabled%> <%=bean.getChecked(bean.getSplit_batch_allowed_yn())%>></td>
       <td align='center' class = "QRYODD">&nbsp;</td>
       <td align='center' class = "QRYODD">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
	   <%}%>	
	    <td align='center' class = "QRYODD">&nbsp;</td>
        <td class = "QRYODD"><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="var_allowed_yn" id="var_allowed_yn"  value="Y" <%=var_allowed_yn_disabled%> <%=bean.getChecked(bean.getVar_allowed_yn())%>></td>
        <td align='center' class = "QRYODD">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
	   <%}%>
	   <td align='center' class = "QRYODD">&nbsp;</td>
	   <td align='center' class = "QRYODD">&nbsp;</td>
	   
	   <%if(display.equals("visible")){%>
	   <td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
	   <td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
	   <%}%>
     </tr>  
      
	 <tr>
        <td class='QRYEVEN'><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></td>
		<td class='QRYEVEN' align='center'><input type="checkbox" value="Y" name="sal_allowed_yn" id="sal_allowed_yn"  onclick =' checkfinalizeapplicable(sal_allowed_yn,sal_authorize_allowed_yn,"","",sal_delete_yn,sal_authorize_prompt_yn)'   <%=bean.getChecked(bean.getSal_allowed_yn())%> <%=sal_allowed_yn_disabled%> ></td>
		<td class='QRYEVEN' align='center'><input type="checkbox" value="Y" name="sal_authorize_allowed_yn" id="sal_authorize_allowed_yn" onclick =' checkfinalizepromptapplicable(this,sal_authorize_prompt_yn)'  <%=bean.getSal_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getSal_authorize_allowed_yn())%> ></td>
		<td class='QRYEVEN' align='center'><input type="checkbox" value="Y" name="sal_authorize_prompt_yn" id="sal_authorize_prompt_yn" <%=bean.getSal_allowed_yn().equals("Y") && bean.getSal_authorize_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getSal_authorize_prompt_yn())%> ></td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%}%>
	   <td align='center' class = "QRYEVEN"><input type=checkbox name="sal_delete_yn" id="sal_delete_yn"  value="Y" <%=bean.getSal_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getSal_delete_yn())%>></td>
		<td class = "QRYEVEN"><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/></td>
		<td class='QRYEVEN' align='center'><input type="checkbox" value="Y" name="srt_allowed_yn" id="srt_allowed_yn" 	onclick =' checkfinalizeapplicable(srt_allowed_yn,srt_finalize_allowed_yn,"","",srt_delete_yn,srt_finalize_prompt_yn)' 	<%=srt_allowed_yn_disabled%> <%=bean.getChecked(bean.getSrt_allowed_yn())%> ></td>
		<td class='QRYEVEN' align='center'><input type="checkbox" value="Y" name="srt_finalize_allowed_yn" id="srt_finalize_allowed_yn"onclick =' checkfinalizepromptapplicable(this,srt_finalize_prompt_yn)'  <%=bean.getSrt_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getSrt_finalize_allowed_yn())%> ></td>
		<td class='QRYEVEN' align='center'><input type="checkbox" value="Y" name="srt_finalize_prompt_yn" id="srt_finalize_prompt_yn" <%=bean.getSrt_allowed_yn().equals("Y") && bean.getSrt_finalize_allowed_yn().equals("Y") ?"":"disabled"%> <%=bean.getChecked(bean.getSrt_finalize_prompt_yn())%> ></td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
       <td align='center' class = "QRYEVEN">&nbsp;</td>
       <td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%}%>
	   <td align='center' class = "QRYEVEN"><input type=checkbox name="srt_delete_yn" id="srt_delete_yn"  value="Y" <%=bean.getSrt_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getSrt_delete_yn())%>></td>
	   <%if(display.equals("visible")){%>
	   <td align='center' class = "QRYEVEN" style=<%=display_flag%>>&nbsp;</td>
	   <td align='center' class = "QRYEVEN" style=<%=display_flag%>>&nbsp;</td>
	 <%}%>
       
     </tr>
   
	 <tr>
	  <td class = "QRYODD"><fmt:message key="eST.AuthorizeSpecialRequest.label" bundle="${st_labels}"/></td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="authorize_spl_req_allowed_yn" id="authorize_spl_req_allowed_yn"  value="Y" <%=authorize_special_req_disabled%> <%=bean.getChecked(bean.getAuthorizeSpecialReq_yn())%>></td>
        <td align='center' class = "QRYODD">&nbsp;</td>
        <td align='center' class = "QRYODD">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
		<%}%>
	    <td align='center' class = "QRYODD">&nbsp;</td>
       
		<td class = "QRYODD"><fmt:message key="eST.ChangeBin.label" bundle="${st_labels}"/></td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="bin_change_allowed_yn" id="bin_change_allowed_yn"  value="Y" <%=bin_change_allowed_yn_disabled%> <%=bean.getChecked(bean.getBin_change_allowed_yn())%>></td>
        <td align='center' class = "QRYODD">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
       <%}%>
	   	<td align='center' class = "QRYODD">&nbsp;</td>	
		<td align='center' class = "QRYODD">&nbsp;</td>
		<%if(display.equals("visible")){%>
		<td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>	 
        <td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>	  
         <%}%>
	</tr> 
	<tr>
	   <td class = "QRYEVEN"><fmt:message key="eST.ProcessExpiredBatch.label" bundle="${st_labels}"/></td>
       <td align='center' class = "QRYEVEN"><input type=checkbox  name="process_expired_items_yn" id="process_expired_items_yn"  value="Y" <%=bean.getChecked(bean.getProcessExpiredBatch_yn())%> ></td>
       <td align='center' class = "QRYEVEN">&nbsp;</td>
       <td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
       <%}%>
	     <td align='center' class = "QRYEVEN">&nbsp;</td>
		
         <td class = "QRYEVEN"><fmt:message key="eST.StockItemConsumption.label" bundle="${st_labels}"/></td>
		 <td class = "QRYEVEN" align='center'><input type="checkbox" value="Y" name="stk_item_con_allowed_yn" id="stk_item_con_allowed_yn" <%=stk_item_con_allowed_yn_disabled%> <%=bean.getChecked(bean.getStk_item_con_allowed_yn())%> ></td>
		 <td class = "QRYEVEN" align='center'>&nbsp;</td>
		 <td class = "QRYEVEN" align='center'>&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
			 <td class = "QRYEVEN" align='center'>&nbsp;</td>
			 <td class = "QRYEVEN" align='center'>&nbsp;</td>
		<%}%>
		 <td class = "QRYEVEN" align='center'>&nbsp;</td>
		 <%if(display.equals("visible")){%>
		 <td class = "QRYEVEN" align='center' style=<%=display_flag%>>&nbsp;</td>
		 <td class = "QRYEVEN" align='center' style=<%=display_flag%>>&nbsp;</td>
            <%}%>
    </tr>
	<tr>
		<td class = "QRYODD"><fmt:message key="Common.CancelRequest.label" bundle="${common_labels}"/></td>
        <td align='center' class = "QRYODD"><input type=checkbox  name="cancel_request_yn" id="cancel_request_yn"  onClick="setValue(this);"	value="Y"  <%=bean.getChecked(bean.getCancelRequest_yn())%>></td>
        <td align='center' class = "QRYODD">&nbsp;</td>
        <td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
       <%}%>
	     <td align='center' class = "QRYODD">&nbsp;</td>
      	<td class = "QRYODD"><fmt:message key="eST.ProcessSuspendedBatch.label" bundle="${st_labels}"/></td>
			<td align='center' class = "QRYODD"><input type="checkbox"  name="process_suspended_items_yn" id="process_suspended_items_yn"  	value="Y" <%=bean.getChecked(bean.getProcessSuspendedBatch_yn())%> ></td>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
		<%}%>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
			<%if(display.equals("visible")){%>
			<td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
			<td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
			<%}%>
      </tr>
	  <tr>
         <!-- //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 -->
         <td class = "QRYEVEN">Display Min Level & ROL </td>
        <td align='center' class = "QRYEVEN"><input type=checkbox  name="disp_min_rol_yn" id="disp_min_rol_yn"  onClick="setValue(this);"	value= <%=bean.checkForNull(bean.getDisp_min_rol_yn(),"N")%>  <%=bean.getChecked(bean.getDisp_min_rol_yn())%>></td>
        <td align='center' class = "QRYEVEN">&nbsp;</td>
        <td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
       <%}%>
	        <td align='center' class = "QRYEVEN">&nbsp;</td>
			<td class = "QRYEVEN"><fmt:message key="eST.CondemnExpiredBatches.label" bundle="${st_labels}"/></td>
			<td align='center' class = "QRYEVEN"><input type="checkbox"  name="cndmn_exp_btch_allowed_yn" id="cndmn_exp_btch_allowed_yn"  	value="Y" <%=bean.getChecked(bean.getCndmn_exp_btch_allowed_yn())%> <%=cndmn_exp_btch_allowed_yn_disabled%>></td>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
		<%}%>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
			<%if(display.equals("visible")){%>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%>>&nbsp;</td>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%>>&nbsp;</td>
			<%}%>
      </tr> 
	  <tr>
         <!-- TFS ID - 29303 - MO-CRF-20174 -->
         <td class = "QRYEVEN"><fmt:message key="eST.RejectRequestatIssueStore.label" bundle="${st_labels}"/></td>
		 <td align='center' class = "QRYEVEN"><input type=checkbox  name="reject_request_issue_store_allowed_yn" id="reject_request_issue_store_allowed_yn"  onClick="setValue(this);"	value= <%=bean.checkForNull(bean.getReject_Request_at_issue_store_allowed_yn(),"N")%>  <%=bean.getChecked(bean.getReject_Request_at_issue_store_allowed_yn())%>></td>
		 <td align='center' class = "QRYEVEN">&nbsp;</td>
         <td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
		   <td align='center' class = "QRYEVEN">&nbsp;</td>
       <%}%>
	        <td align='center' class = "QRYEVEN">&nbsp;</td>
	   	    <td class = "QRYEVEN"><fmt:message key="eST.CancelAuthorizeatIssueStore.label" bundle="${st_labels}"/></td><!-- TFS ID - 23934 - MO-CRF-20177 -->
		    <td align='center' class = "QRYEVEN"><input type=checkbox  name="cancel_authorize_iss_allow_yn" id="cancel_authorize_iss_allow_yn"  onClick="setValue(this);"	value= <%=bean.checkForNull(bean.getCancel_Authorize_at_issue_store_allowed_yn(),"N")%>  <%=bean.getChecked(bean.getCancel_Authorize_at_issue_store_allowed_yn())%>></td>
		    <td align='center' class = "QRYEVEN">&nbsp;</td>
		 	<td align='center' class = "QRYEVEN">&nbsp;</td>
	   <%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
		<%}%>
			<td align='center' class = "QRYEVEN">&nbsp;</td>
			<%if(display.equals("visible")){%>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%>>&nbsp;</td>
			<td align='center' class = "QRYEVEN" style=<%=display_flag%>>&nbsp;</td>
			<%}%>
      </tr>  
	      
	<%if(interface_to_external_po_yn.equals("Y")){%>
		<tr>
		<%
		%>
			<td class = "QRYODD"><fmt:message key="eST.PurchaseOrderRequest.label" bundle="${st_labels}"/></td>
			<td align='center' class = "QRYODD"><input type="checkbox"  name="prq_allowed_yn" id="prq_allowed_yn"  	value="Y" <%=bean.getChecked(bean.getPRQ_allowed_yn())%> onclick="validateFinilize(this);"<%=bean.getGrn_allowed_yn().equals("Y")?"":"disabled"%> <%=prq_allowed_yn_disabled%> ></td>
			<td align='center' class = "QRYODD"><input type=checkbox  name="prq_finalize_allowed_yn" id="prq_finalize_allowed_yn"  value="Y" <%=bean.getChecked(bean.getPRQ_finalize_allowed_yn())%> <%=(bean.getGrn_allowed_yn().equals("Y") && bean.getPRQ_allowed_yn().equals("Y"))?"":"disabled"%> ></td>
			<!-- <td align='center' class = "QRYODD"><input type=checkbox  name="prq_finalize_prompt_yn" id="prq_finalize_prompt_yn"  value="Y" <%=bean.getChecked(bean.getPRQ_finalize_allowed_yn())%> <%=(bean.getGrn_allowed_yn().equals("Y") && bean.getPRQ_allowed_yn().equals("Y"))?"":"disabled"%> ></td> -->
           <td align='center' class = "QRYODD">&nbsp;</td>
			<%if(bean.getAckReqdForIssue() || bean.getAckReqdForIssueReturn() ||  bean.getAckReqdForStockTransfer()){%>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		   <td align='center' class = "QRYODD">&nbsp;</td>
		 <%}%>
	 		<td align='center' class = "QRYODD"><input type=checkbox name="prq_delete_yn" id="prq_delete_yn"  value="Y" <%=bean.getPRQ_allowed_yn().equals("Y")?"":"disabled"%> <%=bean.getChecked(bean.getPrq_delete_yn())%>></td>
		
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<td align='center' class = "QRYODD">&nbsp;</td>
			<%if(display.equals("visible")){%>
			<td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
			<td align='center' class = "QRYODD" style=<%=display_flag%>>&nbsp;</td>
			<%}%>
        </tr>
		<%}%>
		
</table>

<%
		    }
			catch(Exception e){
				out.println("Exception@1: "+e.toString());
				e.printStackTrace();
			}
			finally{
					if(con != null) ConnectionManager.returnConnection(con, request); //connection was not closed propery, changed as per jsp one // when doing MO-CRF-20177
					//con.close();
			}
 
%>  
   
    <input type="hidden"	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden"	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden"	name="bean_name" id="bean_name"			value="<%= bean_name %>">
    <input type="hidden"	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden"	name="user_id" id="user_id"				value="<%=request.getParameter("user_id")%>">
	<input type="hidden"	name="store_code" id="store_code"			value="<%=request.getParameter("store_code")%>">
	<input type="hidden"	name="dflt_item_search" id="dflt_item_search"		value="<%=dflt_item_search%>"> <!-- Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria -->
	<input type="hidden"	name="count" id="count">
	<input type="hidden" 	name="interface_to_external_po_yn" id="interface_to_external_po_yn"			value="<%=interface_to_external_po_yn%>">
	<input type="hidden"	name="dflt_sal_type" id="dflt_sal_type"		value="<%=dflt_sal_type%>">   <!-- Added by Padmapriya -->
	<input type="hidden"	name="disp_curr_enc_findtl_yn" id="disp_curr_enc_findtl_yn"		value="<%=disp_curr_enc_findtl_yn%>"><!-- Added by suresh.r 12-11-2013 against JD-CRF-156 -->
	<input type="hidden"	name="site" id="site"			value="<%=site %>"
	 
</form>
</center>
<!-- Added by suresh.r on 07-05-2014 against #48871(MO-GN-5447) beg-->
<script type="text/javascript">
<% if(bean.getBLModuleInstalled().equals("Y")){%>
	parent.UserForStoreHeaderFrame.document.getElementById("trhidfindtl").style.display="";
<% }else{%>
	parent.UserForStoreHeaderFrame.document.getElementById("trhidfindtl").style.display="none";
<% }%>
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


<!-- Added by suresh.r on 07-05-2014 against #48871(MO-GN-5447) end -->
<%putObjectInBean(bean_id,bean,request);%>
</body>
</html>

