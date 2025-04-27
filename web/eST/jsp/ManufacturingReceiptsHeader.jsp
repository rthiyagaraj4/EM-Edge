
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*, com.ehis.util.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="mm" class="eST.ManufacturingReceiptsBean"/>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");

	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src='../../eST/js/ManufacturingReceipts.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
	<script language='javascript' src='../../eST/js/StHeader.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="disbleStore();">
<%
	String trn_type					=		"MFG";
	String sql_id					=		"SQL_ST_MAN_REQ_STORE_SELECT";
	String bean_id					=		"ManufacturingReceiptsBean" ;
	String bean_name				=		"eST.ManufacturingReceiptsBean";

	ManufacturingReceiptsBean bean  =		(ManufacturingReceiptsBean)getBeanObject( "ManufacturingReceiptsBean", "eST.ManufacturingReceiptsBean",request  );
	bean.setLanguageId(locale);
	//System.out.println("req===>" +request.getQueryString());
	
	String facility_id				=		(String) session.getValue( "facility_id" ) ;
	String	mode					=		request.getParameter("mode");
	String disabled					=		"";
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String prep_mode				=		"";
	String prep_type				=		"";
	String loc_desc					=		"";
	String store_desc				=		"";
	String process_loss_percent		=		"";
	String legend					=		"";
	String disableDate				=		"";
	String auto_gen_batch_yn		=		"";
//	String batch_id_series			=		"";
//	String next_batch_id			=		"";
	String Remarks					=		"";
	String PackedBy					=		"";
	String CounterChk				=		"";
	String modiEnable				=		"disabled";
	String allow_deci_yn			=		"N";
	String barcode_id_              =       "";  
	String next_batch_id            =       "";
	String batch_id_series          =       "";
	String no_of_labels             =       "";
	 int no_of_decimals				=        0;

	 //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
      String disable				=	""; 
	  String disableItem            =   "";
	  String disablefield			=	"disabled";
	  String disableAddMod			=	"disabled";
	  String  select1               =   "";
	  String select2                =    "";
	  String disable_direct				=	""; 
      String disable_req			=	"";
	  String dflt_mfg_mode	 =		bean.checkForNull(request.getParameter("dflt_mfg_mode"),"R");
     //ends
     //Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 beg
     String mfg_req_yn	= bean.checkForNull(request.getParameter( "mfg_req_yn" ), "N");
     String store_code="",item_code="",mfg_item_dis="",mfg_item_butt_dis="";
     //ends
	 //Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
	String comp_Qty_disabled        =       "";
	String display_flag	            =      "visibility:visible";  
	String disable_req_qty          =      ""; 
	 //Added by Rabbani #Inc no :40572 (Ref:37445(RUT-CRF-0097)) on 05-JUN-2013
    boolean mfg_process_loss_na	    =	bean.MFG_PROCESS_LOSS_NA(trn_type);
 	 
    String newDate="";
	//ends
	 
     
	ArrayList recordSet				=		new ArrayList();
	HashMap record					=		new HashMap();
	String  mfg_delete_yn			=   "";
    boolean BarCodeApplicable	    =	bean.isBarCodeApplicable(facility_id,trn_type);
	         HashMap BarCodeRules   =   bean.getNewBarCodeRules(facility_id);
	        String BarcodeRule      =   bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));		
	        String BarcodeRule_Disable = "";
		    if(BarcodeRule.equals("P") ||BarcodeRule.equals("S") )
			   BarcodeRule_Disable = "ReadOnly";
	try{
	if(!index.equals("-1")){
		recordSet					=		bean.getDataRecordList();
		prep_type					=		request.getParameter("prep_type");
		prep_mode					=		request.getParameter("prep_mode");
		loc_desc					=		request.getParameter("loc_desc");
		store_desc					=		request.getParameter("store_desc");
		barcode_id_				    =		bean.checkForNull(request.getParameter("barcode_id"));  
		no_of_labels				=		bean.checkForNull(request.getParameter("no_of_labels"));  

		record						=		(HashMap)	recordSet.get(Integer.parseInt(index));
		
		
		bean.setReq_store((String)record.get("REQUESTING_STORE_CODE"));
		bean.setStore_code((String)record.get("REQUESTING_STORE_CODE"));
		bean.setDoc_no((String)record.get("DOC_NO"));
		bean.setPrep_loc((String)record.get("PREPARE_LOCATION_CODE"));
		bean.setReq_type((String)record.get("PREPARATION_TYPE"));
		bean.setPrep_mode((String)record.get("PREPARATION_MODE"));
		bean.setItem_code((String)record.get("ITEM_CODE"));
		//bean.setReq_qty((String)record.get("REQUEST_QTY"));
		bean.setPatient_id((String)record.get("PATIENT_ID"));
		bean.setEncounter_id((String)record.get("ENCOUNTER_ID"));
		
		 //Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
		if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))
			bean.setReq_qty((String)record.get("REQUEST_QTY"));
		else
			bean.setReq_qty((String)record.get("ITEM_QTY"));
			
		if(bean.getReq_type().equals("E"))
			disabled				=		"disabled";
		if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))
			bean.setShort_desc((String)record.get("SHORT_DESC"));
		else
			bean.setShort_desc((String)record.get("ITEMDESC"));

		bean.setStock_uom((String)record.get("UOM_CODE"));
		process_loss_percent=((String)record.get("PROCESS_LOSS_PERCENT"));
		bean.setBatch_id((String)record.get("BATCH_ID"));
		//Added for ML-MMOH-CRF-1909 starts
		HashMap hmshelfTemp = (HashMap) bean.getShelfLifeTime(bean.getItem_code());
		String shelf_life_value = bean.checkForNull((String) hmshelfTemp.get("SHELF_LIFE_VALUE"));
		String shelf_life_flag = bean.checkForNull((String) hmshelfTemp.get("SHELF_LIFE_FLAG"));
		if (shelf_life_value != null && shelf_life_value != "" && shelf_life_flag != null && shelf_life_flag != "") {
			newDate = bean.setExpiryDate(shelf_life_flag, shelf_life_value);
			bean.setExpiry_date(newDate);
			disableDate = "disabled";
		} else {

			bean.setExpiry_date((String) record.get("EXPIRY_DATE"));
		}
		//Added for ML-MMOH-CRF-1909 ends
		bean.setBinLocation_code((String)record.get("BIN_LOCATION_CODE"));
		bean.setTrade_id((String)record.get("TRADE_ID"));
		bean.setDoc_date(bean.getSystemDate());
		bean.setRemarks((String)record.get("REMARKS"));
		bean.setPackedBy((String)record.get("PACKED_BY"));
		bean.setCounterChk((String)record.get("COUNTER_CHECKED_BY"));
		bean.setRemarks_code((String)record.get("REMARKS")); 

		Remarks				=		(String)record.get("REMARKS");
		PackedBy			=		(String)record.get("PACKED_BY");
		CounterChk			=		(String)record.get("COUNTER_CHECKED_BY");

		if(((String)record.get("EXPIRY_YN")).equals("Y")  || bean.getReq_type().equals("E"))
			legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		else {
			legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			
			if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))
			bean.setExpiry_date(bean.getSystemDate());
			disableDate		=		"disabled";
		}
		
		if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))
		{			
				bean.setDoc_type_code(bean.checkForNull((String)((HashMap)bean.getStParameter()).get("DEF_MFG_DOC_TYPE_CODE")));
				modiEnable	=		"";
		}
		else
		bean.setDoc_type_code((String)record.get("DOC_TYPE_CODE"));
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

		bean.setMode(mode);
		bean.setIndex(index);
		bean.setPatient_name((String)record.get("PATIENT_NAME"));
		if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		HashMap hmParameter = new HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",bean.getDoc_type_code());
		hmParameter.put("doc_no",bean.getDoc_no());
		hmParameter.put("trn_type","MFG");
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
			out.println("<script>alert(getMessage('PHY_INV_PROCESS_INITIATED','ST'));history.go(-1);</script>");
		}
       //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
		 disable				=	"disabled";
	     disableItem            =   "disabled";
		 //ends		
		  disable_req_qty       =     "disabled"; //Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
	   }
	   
		HashMap auto_gen_batch_id	=	 bean.getBatchGenDetails();
		auto_gen_batch_yn			=	(String)auto_gen_batch_id.get("AUTO_GEN_BATCH_YN");
		next_batch_id               =    bean.checkForNull((String)auto_gen_batch_id.get("NEXT_BATCH_ID"));  
		batch_id_series             =    bean.checkForNull((String)auto_gen_batch_id.get("BATCH_ID_SERIES")); 
		
		
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		String mfg_request_no				=		bean.checkForNull((String)record.get("MFG_REQUEST_NO"),"");
		if(mfg_request_no.equals(""))
		dflt_mfg_mode = "D";
		else
		dflt_mfg_mode = "R";
		
		}
		//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 beg
		if(mfg_req_yn.equals("Y")){
			store_code = (String)request.getParameter("store_code");
			item_code = (String)request.getParameter("item_code");
			bean.setReq_store(store_code);
			bean.setStore_code(store_code);
			mfg_item_dis="disabled";
			mfg_item_butt_dis="disabled";
	    }//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 end
	String stock_uom_desc=		bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC stock_uom_desc from  am_uom_lang_vw where uom_code=? and language_id=?",new String[]{bean.checkForNull((String)record.get("UOM_CODE"),""),locale}).get("STOCK_UOM_DESC"),"");

      mfg_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  mfg_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getStore_code()),(String) session.getValue( "login_user" )}).get("MFG_DELETE_YN"),"N");
       allow_deci_yn  =    bean.checkForNull(bean.getAllowDecimalsYN((String)record.get("ITEM_CODE")),"N");
       no_of_decimals  =   bean.getNoOfDecimals();
      if(allow_deci_yn.equals("N"))
       no_of_decimals =0;
	   
	 //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
	 if(dflt_mfg_mode.equals("D")){
	 select1 = "checked";
	  //Added by Rabbani for avoid doubleclick on radio button on 12-APR-2013
	  if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){ 
	     disable_direct				=	"disabled"; 
         disable_req			     =	""; 
	   } //ends
	 bean.setDoc_date(bean.getSystemDate());
	 }else{
	 select2 = "checked";
	 //Added by Rabbani for avoid doubleclick on radio button on 12-APR-2013
	  if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){ 
	    disable_direct				=	""; 
        disable_req			         =	"disabled"; 
		}
	 }
   //display = "visible";
   //ends
   
   if(mfg_process_loss_na){   //Added by Rabbani #Inc no :40572 (Ref:37445(RUT-CRF-0097)) on 05-JUN-2013
      comp_Qty_disabled      =   "disabled";
      display_flag			 =   "visibility:hidden";
	  process_loss_percent  = "0" ;
	  
   }
   
   //Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
   String ACC_ENTITY_ID = "ZZ";
   HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_EXTEMP_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID);
	
    String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
    String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
    String prep_extemp   =   bean.checkForNull((String)hmTemp.get("PREP_EXTEMP_LG"));
    String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
    
    if(prep_prepack.equals("") && prep_standard.equals("") && prep_extemp.equals("") && prep_others.equals("") ){
   	 
   	    prep_prepack  = "Pre Packing";
       prep_standard = "Standard Formulary";
        prep_extemp   = "Extemporaneous";
        prep_others   =  "Others";
    }
    
    if(dflt_mfg_mode.equals("R")){
    	String prepa_type = (String)record.get("PREPARATION_TYPE");
    	if(prepa_type.equals("P"))
       prep_type		=	prep_prepack;	
    	else if(prepa_type.equals("S"))
    	       prep_type		=	prep_standard;	
    	else if(prepa_type.equals("E"))
    	       prep_type		=	prep_extemp;	
    	else
    		prep_type		=	prep_others;	
   
    }
    
   
   //ends
%>
<form name="Header" id="Header">
   <jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="default_doc"		value="MFG" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
	<jsp:param name="store_code"		value="<%=bean.getStore_code()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.getDoc_type_code()%>" />
	<jsp:param name="doc_no"			value="<%=bean.getDoc_no()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_ref"			value="<%=bean.getDoc_ref()%>" />
	<jsp:param name="mfg_req_yn"		value="<%=mfg_req_yn%>" />
</jsp:include>
 

<table border=0 cellpadding=1 cellspacing=0 width='100%' align=center>

     <!--Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts -->
        <tr>
		<td colspan="2" class="label"><fmt:message key="eST.DirectManufacturing.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="mfg_mode" id="mfg_mode" value="D" <%=select1%> <%=disable%> <%=disable_direct%> onclick = "selectmode();">
		<span id="id_span_byreq" style="visibility:visible;">
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.ByRequest.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="mfg_mode" id="mfg_mode" value="R"  <%=select2%> <%=disable%> <%=disable_req%> onclick= "selectmfgmode();"></span></td> 
		  
		 </tr>
		 <tr>
	<td>&nbsp;</td>
   </tr> 
           <%if(dflt_mfg_mode.equals("D")){
	        if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){  
			legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
	 	     modiEnable	=		"";
			 
			%>
			<tr>
			 <td  class="LABEL"  nowrap><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></td>
	         <td   colspan=0 class='fields'>&nbsp;<select name='prep_loc' id='prep_loc' onChange="prep_select(this)"><%=bean.getPrepLoc()%></select><%=bean.getImage("M")%></td>
			<td   class="LABEL" nowrap><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></td>
	        <td colspan=0 class='fields' nowrap>&nbsp;<select name='req_type' id='req_type' onChange="onChanegeVal(this)" <%=disable%>>
			<OPTION VALUE="A"> --------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </OPTION>
			
			<%if(!prep_prepack.equals("")){ %>
			<OPTION VALUE="P"><%=prep_prepack %></OPTION>
			<%}if(!prep_standard.equals("")){ %>
			<OPTION VALUE="S"><%=prep_standard %></OPTION>
			<%}if(!prep_extemp.equals("")){ %>
			<OPTION VALUE="E"><%=prep_extemp %></OPTION>
			<%}if(!prep_others.equals("")){ %>
			<OPTION VALUE="O"><%=prep_others %></OPTION>
			<%} %>
			
			<!--  <OPTION VALUE="P"  ><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="S"  ><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="E"  ><fmt:message key="eST.Extemporaneous.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O"  ><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION> -->
			
			
	         </select><%=bean.getImage("M")%></td>
			<td  class="LABEL" nowrap><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></td>
	        <td colspan=0  class='fields'>&nbsp;<select name='prep_mode' id='prep_mode' <%=disable%>>
			<OPTION VALUE="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
			<OPTION VALUE="S"  ><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="N" ><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O" ><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>
			</select><%=bean.getImage("M")%></td>
           </td>
		   </tr>
		  <tr>
         <%if(bean.getReq_type().equals("E")){%>
		  <td  class="LABEL" width='5%' colspan=0 nowrap ><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</td>
		 <%}else{%>
		  <td  class="LABEL" width='5%'nowrap><label  onMouseOver="changeCursor(this);"  class="label"   id = 'item_chk'   onClick = "showAssemblyDetails('<%=bean.checkForNull(bean.getItem_code(),"")%>','<%=bean.checkForNull(bean.getReq_type(),"")%>','<%=bean.checkForNull(bean.getPrep_mode(),"")%>','<%=index%>','<%=bean.checkForNull(bean.getShort_desc(),"")%>','<%=stock_uom_desc%>');"><font class='HYPERLINK'><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</font></label></td>
	      <td  class='fields' colspan=0 >&nbsp;<input type='text' size=20  maxlength=60 name='item_code_desc' id='item_code_desc'   <%=disable%> <%=disableItem%> <%=mfg_item_dis %> value="<%=item_code%>"><input type=button name='searchitem' id='searchitem' value="?" class='Button' <%=disable%> <%=mfg_item_butt_dis %>  onClick="callItemSearchScreenmfg(item_code_desc,document.forms[0]);"><%=bean.getImage("M")%></td>
	     <%}%>
		 <td>  
		 <span id= "uom"   >&nbsp;</span>
		 <b><span id="stock_uom"><%=stock_uom_desc%></span></b></td>
		<td  colspan=0 class='fields'><input type=button name='ExItem' id='ExItem'  id ="ExItem"  style="visibility:hidden" value='<fmt:message key="eST.ExternalItem.label" bundle="${st_labels}"/>' class='Button'  onClick="callItemChildWindow('<%=index%>');" <%=disablefield%> ></td>
		
		<td class="LABEL"  nowrap><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/> </td>
    	<td  class="LABEL"><input type="text" value="<%=bean.checkForNull(bean.getReq_qty())%>"  name="req_qty" class="NUMBER" maxlength=12 size=12 onKeyPress='return allow_req_decimals(this,event);'  onBlur="checkDoubleFormat(this,true);chkreqqty(); " ><%=bean.getImage("M")%></td>
	   <label id="rq"></label>
		<!--<td   width='12%' class="label"><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class="fields"  width='8%'  ><b><%=record.get("MFG_REQUEST_NO")%></b></td> -->
	   </tr>
		<tr>
	   <td class='LABEL'   ><span id="pid" name="pid"  style="visibility:hidden" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></span></td>
	   <td colspan='0' class='fields'>&nbsp;<input type='text' name='patient_id' id='patient_id' class = "UPPER"  size=20 maxLength=<%=bean.getpatlength()%>  id="p_text" name="p_text"  style="visibility:hidden"  value="<%=bean.checkForNull(bean.getPatient_id())%>"  onBlur="ChangeUpperCase(this);getPatientName(patient_id,document.forms[0]);" ><input type='button'  id="p_button" name="p_button" class='button' name="patient" id="patient" value="?"  style="visibility:hidden"   onClick="callPatientSearch(patient_id,patient_name,document.forms[0])" ><span id=im style="visibility:hidden"><%=bean.getImage("M")%></span><font size=1><b id="pn" name="pn">&nbsp;<%=bean.checkForNull(bean.getPatient_name())%></b></font>
	 </td>
	 <td class='LABEL'   colspan=0   ><span id="eid" style="visibility:hidden" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></span></td>
	<td class='fields'>&nbsp;<select name='encounter_id' id='encounter_id'  id="e_sel" style="visibility:hidden">
	<%=bean.getEncounter_id_List()%>
	 </select></td>
      </tr>
	  <%}else{%>
		<tr>
		<td  class="LABEL"  nowrap><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></td>
	    <td   class='fields'>&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc()%></select><%=bean.getImage("M")%></td>
<!-- 	("A, -------- Select -------- ;P,Pre packing;S,Standard Formulary ;E,Extemporaneous ;O,Others",getReq_type()); -->
	      <td   class="LABEL" ><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></td>
	      <td class='fields'>&nbsp;<select name='req_type' id='req_type' onChange="onChanegeVal(this)"  <%=disable%> <%=disableItem%>  >
			<OPTION VALUE="A" <%=bean.getReq_type().equals("A")?"Selected":""%>> --------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </OPTION>
			
			 <OPTION VALUE="P" <%=bean.getReq_type().equals("P")?"Selected":""%>><%=prep_prepack %></OPTION>
			<OPTION VALUE="S" <%=bean.getReq_type().equals("S")?"Selected":""%>><%=prep_standard %></OPTION>
			<OPTION VALUE="E" <%=bean.getReq_type().equals("E")?"Selected":""%>><%=prep_extemp %></OPTION>
			<OPTION VALUE="O" <%=bean.getReq_type().equals("O")?"Selected":""%>><%=prep_others %></OPTION>
			 
			
			
			
			<!-- <OPTION VALUE="P" <%=bean.getReq_type().equals("P")?"Selected":""%>><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="S" <%=bean.getReq_type().equals("S")?"Selected":""%>><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="E" <%=bean.getReq_type().equals("E")?"Selected":""%>><fmt:message key="eST.Extemporaneous.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O" <%=bean.getReq_type().equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>  -->
			</select><%=bean.getImage("M")%></td>
	   <td  class="label" nowrap><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></td>
	   <td  class='fields'>&nbsp;<select name='prep_mode' id='prep_mode'  <%=disableItem%>  ><OPTION VALUE=""  <%=bean.getPrep_mode().equals("")?"Selected":""%>>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
			<OPTION VALUE="S" <%=bean.getPrep_mode().equals("S")?"Selected":""%>><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="N" <%=bean.getPrep_mode().equals("N")?"Selected":""%>><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O" <%=bean.getPrep_mode().equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION></select><%=bean.getImage("M")%></td>
      </td>
      </tr>
		 <tr>
         <%if(bean.getReq_type().equals("E")){%>
		  <td  class="LABEL" width='5%' colspan=0 nowrap><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</td>
		  <td  class='fields' colspan=0 >&nbsp;<input type='text' size=20  maxlength=60 name='item_code_desc' id='item_code_desc'  <%=disable%> <%=disableItem%> value="<%=bean.checkForNull(bean.getItem_code(),"&nbsp;")%>"><input type=button name='searchitem' id='searchitem' value="?" class='Button'  <%=disable%> ><%=bean.getImage("M")%></td>
		<%}else{%>
		  <td  class="LABEL" width='5%' nowrap><label onMouseOver="changeCursor(this);"  class="label" onClick = "showAssemblyDetails('<%=bean.checkForNull(bean.getItem_code(),"")%>','<%=bean.checkForNull(bean.getReq_type(),"")%>','<%=bean.checkForNull(bean.getPrep_mode(),"")%>','<%=index%>','<%=bean.checkForNull(bean.getShort_desc(),"")%>','<%=stock_uom_desc%>');"><font class='HYPERLINK'><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</font></label></td>
	      <td  class='fields' colspan=0 >&nbsp;<input type='text' size=20  maxlength=60 name='item_code_desc' id='item_code_desc'   <%=disable%> <%=disableItem%> value="<%=bean.checkForNull(bean.getShort_desc(),"&nbsp;")%>"><input type=button name='searchitem' id='searchitem' value="?" class='Button'  <%=disable%> <%=disableItem%>  onClick="callItemSearchScreenmfg(item_code_desc,document.forms[0]);"><%=bean.getImage("M")%></td>
	    <%}%>
		<td  class="LABEL" width='8%' nowrap><span id=uom ><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;</span></td>
		<%if(!bean.getReq_type().equals("E")){%>
		<td   id="stock_uom" width='22%' class="QUERYDATA" ><%=stock_uom_desc%></td>
		<%}%>
		<%if(bean.getReq_type().equals("E")){%>
		 <TD>&nbsp;</TD>
		<%}%>
		 <td   width='8%' class="label" colspan=0 ><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/>&nbsp;</td>
    	 <td   width="12%"  class='fields'><input type='text'  onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);"  onBlur="checkDoubleFormat(this,true);chkreqqty(); " name="req_qty" class="NUMBER" <%=disableItem%> value="<%=bean.checkForNull(bean.getReq_qty())%>" size=12 maxlength=12><%=bean.getImage("M")%></td>
	    <label id="rq"></label>
	    </tr>
	    
		 <tr> 
	  <td class='LABEL'   ><span id="pid"  style="visibility:hidden" ><fmt:message key="Common.patientId.label"  bundle="${common_labels}"/></span></td>
	  <%if(bean.getReq_type().equals("E")){%>
	 <td colspan='0' class='fields'>&nbsp;<input type='text' name='patient_id' id='patient_id' size=20 maxLength=<%=bean.getpatlength()%> value="<%=bean.checkForNull(bean.getPatient_id())%>" <%=disable%>  onBlur="getPatientName(patient_id,document.forms[0]);" ><input type='button'  id="p_button"  name="p_button" class='button' value="?"  <%=disable%>  onClick="callPatientSearch(patient_id,patient_name,document.forms[0])"><span id=im ><%=bean.getImage("M")%></span><font size=1><b id="pn" name="pn">&nbsp;<%=bean.checkForNull(bean.getPatientName())%></b></font>
	</td>
	<%}%>
	<td class='LABEL'   colspan=0   ><span id="eid" style="visibility:hidden" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></span></td>
	 <%if(bean.getReq_type().equals("E")){%>
	<td class='fields'>&nbsp;<select name='encounter_id' id='encounter_id' <%=disable%>  id="e_sel" >
	<%=bean.getEncounter_id_List()	%>
	</select></td>
	<%}%>
	<td  colspan=4 class='fields'><input type=button name='ExItem' id='ExItem'  id ="ExItem" style="visibility:hidden"   value='<fmt:message key="eST.ExternalItem.label" bundle="${st_labels}"/>' class='Button'  onClick="callItemChildWindow('<%=index%>');"> 
	<!--<input type=button name='add' id='add' id = "add" value="add " class='Button'  style="visibility:hidden" <%=disableAddMod%>   onClick="hdrData(<%=index%>);"    >&nbsp;<input type=reset name='cancel' id='cancel' id = "cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='Button'  style="visibility:hidden"  onClick="cancelHdrData(<%=index%>)">  -->
	</td>
   </tr>
   <%}
	 }else{ %>
	<tr>
       <%if(bean.getReq_type().equals("E")){%>
		  <td  class="LABEL" width='5%' nowrap><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</td>
		<%}else{%>
		  <td  class="LABEL" width='5%' nowrap><label onMouseOver="changeCursor(this);"  class="label" onClick = "showAssemblyDetails('<%=bean.checkForNull(bean.getItem_code(),"")%>','<%=bean.getReq_type() %>','<%=prep_mode%>','<%=index%>','<%=bean.checkForNull(bean.getShort_desc(),"")%>','<%=stock_uom_desc%>');"><font class='HYPERLINK'><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</font></label></td>
		<%}%>
		 <%if(bean.getReq_type().equals("E")){%>
				<td   class="QUERYDATA"  width='27%' id="stock_uom" ><%=(String)record.get("ITEM_CODE")%></td>
		 <%}else{%>
				<td   class="QUERYDATA"  width='27%' id="stock_uom" ><%=bean.checkForNull(bean.getShort_desc(),"&nbsp;")%></td>
		<%}%>
		<td  class="LABEL" width='8%' nowrap><span id=uom ><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;</span></td>
		<td   id="stock_uom" width='22%' class="QUERYDATA" ><%=stock_uom_desc%></td>
		
		<!--<td   width='8%' class="label"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class="fields"  width='8%'  ><b id="rq"><%=bean.setNumber(bean.getReq_qty(),no_of_decimals)%></b></td> -->
		<!--Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013 -->
		<td class='LABEL'  nowrap><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></td>
	     <td nowrap><input type='text'   name="req_qty" id="req_qty" onKeyPress='return allow_req_decimals(this,event);'  onBlur="checkDoubleFormat(this,true);chkreqqty();" class="NUMBER"  value="<%=bean.setNumber(bean.getReq_qty(),no_of_decimals)%>"  size=12  maxlength=12 <%=disable_req_qty%> ><%=bean.getImage("M")%></td>
		 <label id="rq"></label>
		<td   width='12%' class="label"><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/>&nbsp;&nbsp; 
		<b><%=record.get("MFG_REQUEST_NO")%></b></td>
	</tr>
		<tr>
		<td  class="LABEL" width='8%' nowrap><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/>&nbsp;</td>
		<td   class="QUERYDATA" ><%=loc_desc%></td>
		<td  width='12%' class="label"><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class="fields"   ><b ><%=prep_type%></b></td>
		<td  width='8%' class="label"><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class="fields"  colspan='3' ><b><%=prep_mode%></b></td>
	</tr>
	<tr> 
		<td  class="LABEL" width='5%' nowrap><span id='pid'  style="visibility:hidden"><fmt:message key="eST.InternalReportsReprint.label" bundle="${st_labels}"/>&nbsp;</span></td>
		<td    class="QUERYDATA" ><%=bean.checkForNull(bean.getPatient_id(),"&nbsp;")%></td>
		<td  class="LABEL" width='8%' nowrap><span id=eid style="visibility:hidden"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</span></td>
		<td    class="QUERYDATA" colspan=6><%=bean.checkForNull(bean.getEncounter_id(),"&nbsp;")%></td>
	</tr>
	<%}%>
	<td  class="LABEL"  nowrap><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>&nbsp;</td>

	<td>
	<%
if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){
	  if(auto_gen_batch_yn.equals("N") ){
	  if(BarCodeApplicable){
	%>
	<input  type='text' class="UPPER" size=20  maxlength=10 name='batch_id' id='batch_id' onKeyPress="return  CheckForSpecialChars(event);"  onblur = "NewBarcodeString('ManufacturingReceiptsBean', 'eST.ManufacturingReceiptsBean', '<%=facility_id%>','<%=bean.getItem_code()%>',batch_id,expiry_date,'<%=bean.getDefault_trade_id()%>',bin_location,'<%=bean.getStore_code()%>',barcode_id,composition_for_qty);" value="<%=bean.checkForNull(bean.getBatch_id())%>" >
	<%}else{%>
	<input  type='text' class="UPPER" size=20  maxlength=10 name='batch_id' id='batch_id' onKeyPress="return  CheckForSpecialChars(event);"  value="<%=bean.checkForNull(bean.getBatch_id())%>" >
	<%}
	  }else{
	%>
	<input   type='text' class="UPPER" size=20  maxlength=10 name='batch_id' id='batch_id' readonly  value="" >
	<%}
	}else{
	    if(BarCodeApplicable){
		%>
		<input  type='text' class="UPPER" size=20  maxlength=10 name='batch_id' id='batch_id' onKeyPress="return  CheckForSpecialChars(event);"  onblur = "NewBarcodeString('ManufacturingReceiptsBean', 'eST.ManufacturingReceiptsBean', '<%=facility_id%>','<%=bean.getItem_code()%>',batch_id,expiry_date,'<%=bean.getDefault_trade_id()%>',bin_location,'<%=bean.getStore_code()%>',barcode_id,composition_for_qty);" value= "<%=bean.checkForNull(bean.getBatch_id())%>" disabled >
		<%}else{%>
		<input  type='text' class="UPPER" size=20  maxlength=10 name='batch_id' id='batch_id' onKeyPress="return  CheckForSpecialChars(event);"  value= "<%=bean.checkForNull(bean.getBatch_id())%>" disabled >
<%	}
    }
	%>
	<span id=im1 style="visibility:hidden"><%=bean.getImage("M")%></span></td>
	<td class='LABEL'  nowrap ><%=legend%>&nbsp;</td> 
	<% if(BarCodeApplicable){  if(newDate !=null && newDate !=""){%>
	<td   width="15%"><input type='text'   name="expiry_date" id="expiry_date"   value="<%=DateUtils.convertDate(bean.checkForNull(newDate),"DMY","en",locale)%>"  <%=disableDate%>  size=10 maxlength=10 onBlur="getBatchIDFromExpiryDate(this,sys_date); NewBarcodeString('ManufacturingReceiptsBean', 'eST.ManufacturingReceiptsBean', '<%=facility_id%>','<%=bean.getItem_code()%>',batch_id,expiry_date,'<%=bean.getDefault_trade_id()%>',bin_location,'<%=bean.getStore_code()%>',barcode_id,composition_for_qty)"><img name="cal" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date');"  <%=disableDate%>   onBlur="getBatchIDFromExpiryDate(this,sys_date);" ></img><span id=im2 style="visibility:hidden"><%=bean.getImage("M")%></span></td>
	<%}else{%>
	<td   width="15%"><input type='text'   name="expiry_date" id="expiry_date"   value="<%=DateUtils.convertDate(bean.checkForNull(bean.getExpiry_date()),"DMY","en",locale)%>"  <%=disableDate%>  size=10 maxlength=10 onBlur="getBatchIDFromExpiryDate(this,sys_date); NewBarcodeString('ManufacturingReceiptsBean', 'eST.ManufacturingReceiptsBean', '<%=facility_id%>','<%=bean.getItem_code()%>',batch_id,expiry_date,'<%=bean.getDefault_trade_id()%>',bin_location,'<%=bean.getStore_code()%>',barcode_id,composition_for_qty)"><img name="cal" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date');"  <%=disableDate%>   onBlur="getBatchIDFromExpiryDate(this,sys_date);" ></img><span id=im2 style="visibility:hidden"><%=bean.getImage("M")%></span></td>
	<%}}else{ if(newDate !=null && newDate !=""){%>
	<td   width="15%"><input type='text'   name="expiry_date" id="expiry_date"   value="<%=DateUtils.convertDate(bean.checkForNull(newDate),"DMY","en",locale)%>"  <%=disableDate%>  size=10 maxlength=10 onBlur="getBatchIDFromExpiryDate(this,sys_date)"><img name="cal" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date');"  <%=disableDate%> onBlur="getBatchIDFromExpiryDate(this,sys_date)" ></img><span id=im2 style="visibility:hidden"><%=bean.getImage("M")%></span></td>
	<%}else{%>
	<td   width="15%"><input type='text'   name="expiry_date" id="expiry_date"   value="<%=DateUtils.convertDate(bean.checkForNull(bean.getExpiry_date()),"DMY","en",locale)%>"  <%=disableDate%>  size=10 maxlength=10 onBlur="getBatchIDFromExpiryDate(this,sys_date)"><img name="cal" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date');"  <%=disableDate%> onBlur="getBatchIDFromExpiryDate(this,sys_date)" ></img><span id=im2 style="visibility:hidden"><%=bean.getImage("M")%></span></td>
	<%}}%>
	
	<td class='LABEL'  nowrap><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/>&nbsp;</td>
	<%if(BarCodeApplicable){%>
	<td   width="15%" colspan='3'>&nbsp;<select name="bin_location" id="bin_location"  <%=disabled%>  onchange =" NewBarcodeString('ManufacturingReceiptsBean', 'eST.ManufacturingReceiptsBean', '<%=facility_id%>','<%=bean.getItem_code()%>',batch_id,expiry_date,'<%=bean.getDefault_trade_id()%>',bin_location,'<%=bean.getStore_code()%>',barcode_id,composition_for_qty);"><%=bean.getSTITBin_location_code_List(bean.getStore_code(),bean.getItem_code(),bean.getBinLocation_code(),bean.getLanguageId())%> </select><span id=im3 style="visibility:hidden"><%=bean.getImage("M")%></span></td>
	<%}else{%>
	<td   width="15%" colspan='3'>&nbsp;<select name="bin_location" id="bin_location"  <%=disabled%> ><%=bean.getSTITBin_location_code_List(bean.getStore_code(),bean.getItem_code(),bean.getBinLocation_code(),bean.getLanguageId())%></select><span id=im3 style="visibility:hidden"><%=bean.getImage("M")%></span></td>
	<%}%>
	<tr> 
	<td class='LABEL'  nowrap><span id=tid><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/>&nbsp;</span></td>
	<td   width="15%" class='QUERYDATA'><span id=tname ><%=bean.getDefault_trade_id()%></span></td>
	<td class='LABEL' style="<%=display_flag%>" nowrap><fmt:message key="eST.ProcessLoss.label" bundle="${st_labels}"/>%&nbsp;</td>
	<td style="<%=display_flag%>"  width="15%"><input type='text'  onKeyPress="return allow_req_decimals(this, event);"  onBlur="checkDoubleFormat(this,false);calcComp(this); " name="process_loss" id="process_loss" class="NUMBER" value="<%=bean.checkForNull(process_loss_percent)%>" size=8 maxlength=5 <%=modiEnable%>><%=bean.getImage("M")%></td>
	<td class='LABEL'  nowrap><fmt:message key="eST.Compositionfor.label" bundle="${st_labels}"/></td>
	<%if(BarCodeApplicable){
	if(dflt_mfg_mode.equals("D")){
	%>
	<td nowrap><input type='text'     name="composition_for_qty" id="composition_for_qty" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="CheckQuantity(this,allow_deci_yn); checkCompQty(this,allow_deci_yn,no_deci); NewBarcodeString('ManufacturingReceiptsBean', 'eST.ManufacturingReceiptsBean', '<%=facility_id%>','<%=bean.getItem_code()%>',batch_id,expiry_date,'<%=bean.getDefault_trade_id()%>',bin_location,'<%=bean.getStore_code()%>',barcode_id,composition_for_qty)"   class="NUMBER" <%=comp_Qty_disabled%> value="<%=record.get("PREPARE_QTY")==null?"":record.get("PREPARE_QTY")%>" size=12 maxlength=12><%=bean.getImage("M")%><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
	<%}else{%>
	<td  nowrap><input type='text'     name="composition_for_qty" id="composition_for_qty" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="CheckQuantity(this,'<%=allow_deci_yn%>');checkCompQty(this,'<%=allow_deci_yn%>',<%=no_of_decimals%>);NewBarcodeString('ManufacturingReceiptsBean', 'eST.ManufacturingReceiptsBean', '<%=facility_id%>','<%=bean.getItem_code()%>',batch_id,expiry_date,'<%=bean.getDefault_trade_id()%>',bin_location,'<%=bean.getStore_code()%>',barcode_id,composition_for_qty)"   class="NUMBER" <%=comp_Qty_disabled%> value="<%=record.get("PREPARE_QTY")==null?"":record.get("PREPARE_QTY")%>" size=12 maxlength=12><%=bean.getImage("M")%><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
	
	<%}
	}else{%>
	<td  class='LABEL' width="15%" colspan='3' ><input type='text'     name="composition_for_qty" id="composition_for_qty" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="CheckQuantity(this,'<%=allow_deci_yn%>');checkCompQty(this,'<%=allow_deci_yn%>',<%=no_of_decimals%>)"   class="NUMBER" <%=comp_Qty_disabled%> value="<%=record.get("PREPARE_QTY")==null?"":record.get("PREPARE_QTY")%>" size=12 maxlength=12><%=bean.getImage("M")%>&nbsp;<fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
	<%}%>
	
	</tr>
		<TR>
		<!--<TD  class=label><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD><td  colspan=7><input type=text name=remarks readonly value="<%=Remarks==null?"":Remarks%>" size=100><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >--> 
		
		<%if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){%>
		<TD  class=LABEL ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD><td  colspan=0 nowrap><input type=text name=remarks id=remarks readonly value="" size=28><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" ><input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
		
		<%}else{%>
		<TD  class=LABEL><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD><td  colspan=0 nowrap><input type=text name=remarks  id=remarks readonly value="<%=bean.checkForNull(bean.getRemarks_desc())%>" size=28><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" ><input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
		<%}%> 
		<TD class=LABEL  nowrap><fmt:message key="Common.PackedBy.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD><input class="STSMALL" type='text' class="UPPER" size=30  maxlength=10 name='packed_by' id='packed_by' value="<%=(PackedBy==null || PackedBy.equals(""))?session.getAttribute("login_user"):PackedBy%>"   ></TD>
		<TD class=LABEL  nowrap><fmt:message key="eST.CounterChecked.label" bundle="${st_labels}"/> &nbsp;</TD>
		<TD>&nbsp;<input class="STSMALL" type='text' class="UPPER" size=30  maxlength=10 name='counter' id='counter' value="<%=CounterChk==null?"":CounterChk%>" ></TD>
		</TR>
		<TR>
		 <%if(BarCodeApplicable){%>	  
	    <td class = LABEL><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></td>
		<%if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){%>
		<td  class='fields' nowrap >&nbsp;<input type=text name="barcode_id" id="barcode_id" size=15 maxlength=20 class="NUMBER"  onKeyPress="return  CheckForSpecialChars(event);" onBlur="return  checkBarcodeChars(this);"     <%=BarcodeRule_Disable%>  ></td>
		 <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/> </td>
		  <td><input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' value="N" onClick="no_of_labels.disabled=!this.checked;checklabelyn();"> </td> 
		<td  class='LABEL'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/></td>
		<td> <input type=text name='no_of_labels' id='no_of_labels' size=10 maxlength=15 class="NUMBER" onKeyPress="return isValidInteger();"  value="" disabled></td>
		 <%}else{%>
			<td  class='fields'  >&nbsp;<input type=text name="barcode_id" id="barcode_id" size=15 maxlength=20 class="NUMBER"  onKeyPress="return  CheckForSpecialChars(event);"  value= "<%=barcode_id_%>" onBlur="return  checkBarcodeChars(this);"   <%=BarcodeRule_Disable%>  ></td>
			 <td class=LABEL ><fmt:message key="Common.Label.label" bundle="${common_labels}"/> </td>
		    <td><input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' value="Y" onClick="no_of_labels.disabled=!this.checked;checklabelyn();"> </td>
		   <td  class='LABEL'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/> </td>
		<td> <input type=text name='no_of_labels' id='no_of_labels' size=10 maxlength=15 class="NUMBER" onKeyPress="return isValidInteger();"  value="<%=no_of_labels%>"  onBlur="" disabled></td>
			<%} 
			 }%>
	  </tr>
	  <tr>
		 <TD>&nbsp;</TD>
		 <TD>&nbsp;</TD>
		<td  colspan='3' align = 'right'><input type=button name='select' id='select'  value='<fmt:message key="eST.GetData.label" bundle="${st_labels}"/>' class='Button'    onClick="loadDtlData(composition_for_qty,baseqty,'<%=locale%>');Disablepro(this,dflt_mfg_mode);" <%=modiEnable%>></td>
		
		</tr>
</table>
		<%
		}		
			catch(Exception e){
			e.printStackTrace();
			}
		%>
		<input type="hidden"	name="no_of_decimals" id="no_of_decimals"		value="<%=no_of_decimals%>">
		<input type="hidden"	name="dec_allowed_yn" id="dec_allowed_yn"		value="<%=allow_deci_yn%>">
		<input type=hidden		name="baseqty" id="baseqty" >
		<input type=hidden		name="labeltype" id="labeltype" >
		<input type=hidden		name="comp_qty" id="comp_qty" >
		<input type=hidden		name="process_loss_percent" id="process_loss_percent" >
		<input type=hidden		name="sys_date" id="sys_date"								value="<%=DateUtils.getCurrentDate("DMY",locale)%>">
		<input type=hidden		name="index" id="index"								value="<%=index%>" >
		<input type=hidden		name="mode" id="mode"									value="<%=mode%>" >
		<input type=hidden		name="trade_id" id="trade_id"								value="<%=bean.getDefault_trade_id()%>" >
		<input type='hidden'	name='checkBoxVals' id='checkBoxVals' >
		<input type='hidden'	name='auto_gen_batch_yn' id='auto_gen_batch_yn'					value="<%=auto_gen_batch_yn%>">
		
		<input type='hidden'	name='locale' id='locale'								value="<%=locale%>">
		<input type='hidden'	name="trn_type" id="trn_type"								value="<%=trn_type%>">
		<input type='hidden'	name="doc_no" id="doc_no"								value="<%=bean.getDoc_no()%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="MFG">
		<input type="hidden"	name="mfg_delete_yn" id="mfg_delete_yn"						value="<%=mfg_delete_yn%>">
		<input type=hidden		name="prep_type" id="prep_type"							value="<%=(String)record.get("PREPARATION_TYPE")%>" >
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	    <input type ="hidden"	name="BarCodeApplicable" id="BarCodeApplicable"					   	value="<%=BarCodeApplicable%>">
	   <input type ="hidden"    name="BarcodeRule" id="BarcodeRule"                              value="<%=BarcodeRule%>">
	   <input type ="hidden"    name="next_batch_id" id="next_batch_id"                             value="<%=next_batch_id%>">
	   <input type ="hidden"    name="batch_id_series" id="batch_id_series"                           value="<%=batch_id_series%>">
	   <input type="hidden"     name="manufacturer_id" id="manufacturer_id"					        value="" >
	   <input type="hidden"     name="supplier_id" id="supplier_id"					            value="" >
	   <input type="hidden"     name="mrp" id="mrp"						                 value="" >
	   <input type="hidden"     name="new_barcode" id="new_barcode"						         value="" >
	   <!-- <input type="hidden"     name="bean_name" id="bean_name"		    		             value="<%=bean_name%>">
	    <input type="hidden"     name="bean_id" id="bean_id"					                 value="<%=bean_id%>">-->
		<input type="hidden"     name="facility_id" id="facility_id"					             value="<%=facility_id%>">
		<input type="hidden"     name="item_code" id="item_code"					            value="<%=(String)record.get("ITEM_CODE")%>">
        <input type="hidden"     name="storecode" id="storecode"	                value="<%=(String)record.get("REQUESTING_STORE_CODE")%>">
		<!--Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts -->
		<input type="hidden"     name="dflt_mfg_mode" id="dflt_mfg_mode"					       value="<%=dflt_mfg_mode%>">
		<input type='hidden' name='patient_name' id='patient_name'	                            value="<%=bean.getPatient_name()%>" >
		<input type='hidden' name='extemp_item_seq' id='extemp_item_seq'                             value="" >
		<input type='hidden' name='stock_desc' id='stock_desc'                                value="" >
		<input type='hidden' name='store_code_bar' id='store_code_bar'                                value="" >
		<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>" >
    	<input type='hidden' name='no_deci' id='no_deci'		        value="<%=no_of_decimals%>" >
	     <input type='hidden' name='phy_inv_id' id='phy_inv_id'		value="">
		 <input type='hidden' name='stock_item_yn' id='stock_item_yn' >
		 <input type='hidden' name='mfg_req_yn' id='mfg_req_yn' 	value="<%=mfg_req_yn%>"><!--Added by suresh.r on 12-12-2014 against BRU-HIMS-CRF-080  -->
		 
		 <input type='hidden' name="mfg_process_loss_na" id="mfg_process_loss_na"	 value="<%=mfg_process_loss_na%>" >
		 <input type='hidden' name="expiry" id="expiry"	 value="<%=bean.getExpiry_date()%>" >   <!--Added for ML-MMOH-CRF-1909 US3 -->
		   
		<script>
			if('<%=index%>'!="-1" ){
				if(document.forms[0]!=null){
				if(document.forms[0].prep_type.value!="E")
					getBaseQty();
				else
					document.forms[0].process_loss.value=0;
			}
		}
			if(document.forms[0]!=null){
			if(document.forms[0].process_loss.value!="" && document.forms[0].composition_for_qty.value == "")
				calcComp(document.forms[0].process_loss);

				displayGif(document.forms[0].prep_type);

				loadReceiptDtlData('<%=mode%>',document.forms[0].composition_for_qty.value,'<%=request.getParameter("doc_no")%>');
			}
			<%if(mfg_req_yn.equals("Y")){//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080%>
				document.getElementById("id_span_byreq").style.visibility="hidden";
				callItemSearchScreenmfg(document.forms[0].item_code_desc,document.forms[0]);
		    <%}//ends%>
			</script>
		</form>
<%
	putObjectInBean("ManufacturingReceiptsBean",bean,request);
%>
</body>
</html>

