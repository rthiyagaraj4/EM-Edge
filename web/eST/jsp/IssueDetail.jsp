<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       		Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
15/10/2019		IN071552			Shazana Hasan								TBMC-SCF-0099 
---------------------------------------------------------------------------------------------------------------
*/
%> 
<%@page  import=" eST.IssueBean,java.util.ArrayList,java.util.HashMap,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
<%
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/Issue.js"></script>
<%
	try
	{
	
	int i							=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String avail_qty				=		"";
	String item_code				=		"";
	String remarks					=		"";
	String search_str				=		"";
	String item_desc = "";

	String tmp_conv					=		(String)request.getParameter("tmp_conv");
	String kit12					=		(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
	String kit_temp_code			=		(String)request.getParameter("kit_temp_code")==null?"":(String)request.getParameter("kit_temp_code");
	String usage_type				=		(String)request.getParameter("usage_type")==null?"":(String)request.getParameter("usage_type");  

	
	ArrayList alDetailData			=		new ArrayList();
	mode							=		request.getParameter( "mode" ) ;

	function_id						=		request.getParameter( "function_id" ) ;
	search_str						=		request.getParameter( "search_str" )==null?"":request.getParameter( "search_str" ) ;
	bean_id							=		"issueBean" ;
	bean_name						=		"eST.IssueBean";												 
	HashMap expdtl					=		new HashMap();

	IssueBean bean					=		(IssueBean)getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);

 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	
	String BARCODE_YN					=		request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;
	
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-feb-2014
	String  display_hold		   =	  "";
	String iss_item_hold_yn        =      "Y";
	String iss_item_hold_chk       =      "N";
	String iss_hold_item_disabled  =      "";
	String iss_hold_item_checked   =      "";
	String Close_yn                =      "N";   
	//ends
	
	//alDetailData					=		bean.getDtlRecords();//bean.getDetailValues();this one
	//alDetailData					=		bean.getDetailValues();

	ArrayList dummy = new ArrayList();

	if (BARCODE_YN.equals("TRUE"))
	alDetailData		=		bean.getDtlRecordsforBarCode()==null?dummy:bean.getDtlRecordsforBarCode();
	else
	alDetailData		=		bean.getDtlRecords();
  
	String temp						=		request.getParameter("arr")==null?"":request.getParameter("arr");

	java.util.StringTokenizer st	=		new java.util.StringTokenizer(temp,",");

	ArrayList arr					=		new ArrayList();

	while( st.hasMoreElements()){
			arr.add(st.nextElement() );
	}

	//expdtl							=		bean.getExpRecords();

	if (BARCODE_YN.equals("TRUE"))
		expdtl					=		bean.getExpRecordsforBarCode();
	else
		expdtl					=		bean.getExpRecords();
	
	boolean validatebarcode		=	bean.isBarCodeApplicableForValidation("VALIDATEBARCODE",bean.checkForNull(bean.getTrn_type(),"URG"));//Added for RUT-CRF-0079
	
	//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	 String trn_type = "URG";
	 if(bean.getTrn_type () != null) 
		trn_type					=		bean.getTrn_type ();
	 
	 if(trn_type.equals("ISS"))
		display_hold   = "visible";
		boolean site = bean.isSite_spec_yn();//Added for GHL-CRF-0413
	 //ends

%>	
	</head>
<body>
<form name='formIssueDetail' id='formIssueDetail' action="../../eST/jsp/IssueHistoryResult.jsp" method="post"  target="formIssueHistoryResult">
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 80;">
	</div>	
	<table border='0' cellpadding='0' cellspacing='0'>
	<tr>	
	<td class=label>&nbsp;&nbsp;
<% if(!site){//Added for GHL-CRF-0413
if(validatebarcode && !bean.checkForNull(mode).equals("1")){
%>	
	<input type="text" name="search_str" id="search_str" value="<%=search_str%>" size=25 maxlength=50 onclick="blockFormSubmit();if(this.value!=''){this.select()};" onkeyPress="CallBarcodeVerifyItems(event,this)"></td>&nbsp;&nbsp;	
<%
}else{
%>
	<input type="text" name="search_str" id="search_str" value="<%=search_str%>" size=25 maxlength=50>&nbsp;&nbsp;
<%}%>	
	</td>
	<td class=label><img src="../images\GoIcon16Cool.gif" id="go" onclick="locateItem(event,search_str);" title="Locate Item" ></img></td>
	<%} //Added for GHL-CRF-0413%>
	</tr>
	</table>
	<table border='1' cellpadding='0' cellspacing='0' width=300 align=center>
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<!-- Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014 -->
	<%if(display_hold.equals("visible")){%>
	<th><fmt:message key="Common.Hold.label" bundle="${common_labels}"/></th>
	<%} %>
	<th><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>
	<%

	if(mode==null){
		mode				=		"1";
	}

		HashMap ht					=		null;
		String classValue			=		"";
		String item_qty				=		"";
		String alt_text				=		"";
		HashMap rol_min				=		null;
		int expired_batch			=		0;
		String nod					=		"";
		Double qty					=		0.0;
		String to_store_max_qty		=		"";
		String to_store_qty_on_hand =		"";
		String display_flag			=		"visibility:hidden";
		String display_flag1		=		"display:";
		boolean display_gif			=		false;
		int EWDays					=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
		String barcode_item_exist	=		"";
		String locate_item			=		request.getParameter("locate_item")==null?"N":request.getParameter("locate_item");
		String exp_yn					=		"";//IN071552

	
		for(i=0;i<alDetailData.size();i++)
		{
			display_flag1		=		"display:";
			qty=0.0;
			if(((String)bean.getAccessCostDetails()).equals("Y")){
				display_flag		=		"visibility:visible";
			}
			ht					=		(HashMap)alDetailData.get(i);
				
			remarks				=		(String)ht.get("remarks");
			bean.setRemarks(remarks); //corrected by Sakti Sankar against inc#-720
			 String chk_chcked = "";
		    String chk_disabled = "";
			if(!((((String)ht.get("item_desc")).toLowerCase()).startsWith(search_str.toLowerCase())) &&  (locate_item.equals("Y") || !validatebarcode)){
				display_flag1   =		"display:none";
			}
			if(i%2==0){
				classValue	=		"QRYEVEN";
			}else{
				classValue	=		"QRYODD"; 
			}
			
		
		//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
				HashMap hmRecord	=	null;
				String spcfn_img_display;
				hmRecord = bean.getItemSpecfnRemarks(bean.checkForNull((String)ht.get("item_code")),bean.getLanguageId());
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
				//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
				item_desc = (String)ht.get("item_desc");
				item_desc = item_desc.replaceAll(" ","%20");
				item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
				item_desc = item_desc.replaceAll("%2520","%20");
				//Added ends
		if(((bean.checkForNull((String)ht.get("expiry_yn"))).equals("XX"))||(bean.checkForNull((String)ht.get("item_unit_cost"))).equals("")||((String)ht.get("stock_available")).equals("0")){
		%>			
			<tr id="tr_<%=i%>" style="<%=display_flag1%>">

				<td align='center' width='1' class="<%=classValue%>"> 
					<input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" checked disabled>
				</td>
				<!-- //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014 -->
				<%if(display_hold.equals("visible")){%>
				<td align='center' width='1' class="<%=classValue%>"> 
					<input type='checkbox' name="hold_<%=i%>" id="hold_<%=i%>"  disabled>
				</td>
				<%}%>
			<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" >
			<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
			<font size=1><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></span></font>&nbsp;<a style='<%=spcfn_img_display%>;'href="javascript:callItemSpcfnWindow('<%=bean.checkForNull((String)ht.get("item_code"))%>',document.formIssueDetail.item_desc_<%=i%>);"><img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_desc%>');"   onMouseout="onMOut(msg);"  src='../../eST/images/info.gif' alt="Item Remarks/Specification"  ></img></a>
			</td>
		</tr>
			<%}else{
				expired_batch				=		0;
				for(int k=0; k<((ArrayList)expdtl.get(i+"")).size(); k++){
				nod							=		(String)((HashMap)((ArrayList)expdtl.get(i+"")).get(k)).get("NOD");
				exp_yn							=   (String)((HashMap)((ArrayList)expdtl.get(i+"")).get(k)).get("EXPIRY_YN"); //IN071552
				
					qty=qty+Double.parseDouble((String)((HashMap)((ArrayList)expdtl.get(i+"")).get(k)).get("QTY"));
					if( (Integer.parseInt(nod) < EWDays) && (exp_yn.equalsIgnoreCase("Y")) ){  //IN071552
						expired_batch++;
					}
				}
				classValue					=		"";
				item_code					=		(String)ht.get("item_code") ;
 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
				if((bean.getAllowDecimalsYN((String)ht.get("item_code"))).equals("N")){
					no_of_decimals = 0;
				}else{
					no_of_decimals = no_of_decimals_temp;
				}
				//avail_qty					=		bean.checkForNull((String)bean.getDtlRecord(Integer.parseInt(i+"")).get("stock_available"),"0");	
				
				if (BARCODE_YN.equals("TRUE"))
				avail_qty		=		bean.checkForNull((String)bean.getDtlRecordforBarCode(Integer.parseInt(i+"")).get("stock_available"),"0");	
				else
				avail_qty		=		bean.checkForNull((String)bean.getDtlRecord(Integer.parseInt(i+"")).get("stock_available"),"0");	




				item_qty					=		bean.checkForNull((String)ht.get("item_qty"),"0");
				
				rol_min						=		bean.getROL((String)ht.get("item_code"),(String)ht.get("store_code"));

			if(((String)bean.getAccessCostDetails()).equals("Y")){
				display_flag				=		"visibility:visible";
			}
			//to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			//to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	

			if (BARCODE_YN.equals("TRUE")){
			to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecordforBarcode(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecordforBarcode(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	
			}else{
			to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	
			}


			alt_text					=		"";
			display_gif					=		false;
			if(expired_batch > 0){
				String exp_batch			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
				alt_text					=		expired_batch +exp_batch;
			}
			//if(i%2==0) classValue			=		"QRYEVEN";
			//else		classValue			=		"QRYODD"; 

			


			  String kit_usage_type = "";

			  /*if(ht.containsKey("kit_temp_code")){
				 kit_usage_type = bean.checkForNull((String)bean.getUsageType((String)ht.get("kit_temp_code"),(String)ht.get("item_code")));
			  }*/
			   if(ht.containsKey("usage_type")){
				 kit_usage_type = bean.checkForNull((String)ht.get("usage_type"));
			  }
			  
			  if(kit_usage_type.equals("R")){
			      chk_chcked   ="";
			      chk_disabled = "disabled";
			      }
			   else if(kit_usage_type.equals("O")){
			      chk_chcked   ="";
			     chk_disabled = "";
			   }
			  
			   else if(kit_usage_type.equals("P")){
			    chk_chcked   ="checked";
			    chk_disabled = "";
			   }
			    else if(kit_usage_type.equals("D")){
				chk_chcked   ="checked";
			    chk_disabled = "disabled";				
				}
    			 
			  
			  barcode_item_exist =	bean.checkForNull((String)ht.get("barcode_item_exist"));//added for RUT-CRF-0079;
			  
			  //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014	
			      Close_yn = bean.checkForNull(bean.getClose_yn(),"N");
				 if(trn_type.equals("ISS") && Close_yn.equals("N")){ 
					 
			    iss_item_hold_yn = bean.checkForNull((String)ht.get("iss_item_hold_yn"),"Y");
			    iss_item_hold_chk = bean.checkForNull((String)ht.get("iss_item_hold_chk"),"N");
			    iss_hold_item_disabled = "";
			    iss_hold_item_checked  = "";
			    
			    if(iss_item_hold_chk.equals("Y")){ 
			    	iss_hold_item_checked  = "checked";
				  }
					  if(iss_item_hold_yn.equals("N")){
						  iss_hold_item_disabled = "disabled";
						  iss_hold_item_checked  = "";
					  } 
				 }else{
					 iss_hold_item_disabled = "disabled";
					  iss_hold_item_checked  = "";
					 
				 }
			  //ends
			  
			  
			
			%>
		<tr id="tr_<%=i%>" style="<%=display_flag1%>">

			<td align='center' width='1' class="<%=classValue%>"> 
				 <input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>"  <%=chk_chcked%> <%=chk_disabled%> onclick = "chkstatus('<%=i%>');">
			</td>
			<!-- //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-FEB-2014 -->
			<%if(display_hold.equals("visible")){%>
			<td align='center' width='1' class="<%=classValue%>"> 
				 <input type='checkbox' name="hold_<%=i%>" id="hold_<%=i%>"   <%=iss_hold_item_disabled %>  <%=iss_hold_item_checked %>  onclick = "chkholdstatus('<%=i%>');">
			</td>
			<%}%>
			<!-- ends -->

			<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
			<% 
					if ( (Double.parseDouble(avail_qty) - Double.parseDouble(item_qty))  <  Double.parseDouble(bean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0"))){
						String less_than_min_stock		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.LessThanROLinFromStore.label","st_labels");
						alt_text						=		less_than_min_stock+"\n" + alt_text;
						//alt_text						=		alt_text + "Less Than R.O.L in From Store \n";
						display_gif						=		true;
					}
					if ( (Double.parseDouble(avail_qty) - Double.parseDouble(item_qty))  <  Double.parseDouble(bean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0"))){
						String BelowMinStkinFromStore	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.BelowMinStkinFromStore.label","st_labels");
						alt_text						=		alt_text+ BelowMinStkinFromStore+"\n";
						//alt_text						=		alt_text + "Below Min. Stk. in From Store \n";
						display_gif						=		true;
					}
					if (expired_batch > 0){
						display_gif = true;
					}
					if ( !(to_store_max_qty == null || to_store_max_qty.equals(""))){
						if ( (Double.parseDouble(to_store_qty_on_hand) + Double.parseDouble(item_qty))  >  Double.parseDouble(to_store_max_qty))
						{
						String ExceedsMaxStkinToStore	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExceedsMaxStkinToStore.label","st_labels");
						alt_text						=	alt_text+ExceedsMaxStkinToStore+"\n";
							//alt_text					=	alt_text + "Exceeds Max. Stk. in To Store \n";
							display_gif					=	true;
						}
					}
					if (display_gif) {
					%>
						<img src="../images\info1.gif" title="<%=alt_text%>" height=12 >&nbsp;
					<%}%>
				<!--<font size=1><a name="a_<%=i%>" href="javascript:modifyData(<%=i%>);setTempConvFactor(<%=tmp_conv%>);"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber(""+qty,no_of_decimals)%>&nbsp;&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></span></font></a>-->

				<font size=1>
				<a name="a_<%=i%>" id="a_<%=i%>" href="javascript:modifyData(<%=i%>);setTempConvFactor(<%=tmp_conv%>);"><%=ht.get("item_desc")%>&nbsp;</a>
				<a style='<%=spcfn_img_display%>;' href="javascript:callItemSpcfnWindow('<%=bean.checkForNull((String)ht.get("item_code"))%>',document.formIssueDetail.item_desc_<%=i%>);"> <img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_desc%>');"   onMouseout="onMOut(msg);"  src='../../eST/images/info.gif' ></img></a>
				<a href="javascript:modifyData(<%=i%>);setTempConvFactor(<%=tmp_conv%>);"><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber(""+qty,no_of_decimals)%>&nbsp;&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></span></font></a>
				<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" >
				<input type="hidden" name="barcode_item_exist_<%=i%>" id="barcode_item_exist_<%=i%>" value="<%=barcode_item_exist%>" > 
				<input type = "hidden" name = "item_hold_close_yn_<%=i%>" value = "<%=iss_item_hold_yn%>" >
			</td>
		</tr>
<%		}
	}
		bean.getTempBatchRecords().clear();//Added for GHL-CRF-0413
%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">
	<input type="hidden" name="close_yn" id="close_yn"				value="">
	<input type="hidden" name="tmp_conv" id="tmp_conv"				value="<%=tmp_conv%>">
	<input type="hidden" name="item_code" id="item_code"				value="<%=item_code%>">
	<input type="hidden" name="remarks" id="remarks"					value="<%=remarks%>">
	<input type="hidden" name="count" id="count"					value="">

	<input type="hidden" name="BARCODE_YN" id="BARCODE_YN" value="<%= BARCODE_YN %>">
	<input type="hidden" name="validatebarcode" id="validatebarcode" value="<%= validatebarcode %>">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
<%
	if(kit12.equals("kit")){
%>
	<script>
		setTimeout("parent.frameIssueList.frameIssueListHeader.example();",300);//example1();
	</script>
<%}
 if (request.getParameter("index")!=null && !(kit12.equals("kit"))) {
%>
<script language="JavaScript">
	document.getElementById("a_<%= (request.getParameter("index").equals("-1") ? "" + (i - 1) : request.getParameter("index")) %>").scrollIntoView();
	changeRowColor(document.getElementById("tr_<%= (request.getParameter("index").equals("-1") ? "" + (i - 1) : request.getParameter("index")) %>"));	
</script>
<%}%>
 <script language="JavaScript">
 changeRowColorForBarcode(<%=i%>);
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
}
	catch(Exception exception){
		System.out.println("exception..in issue..."+exception.getMessage());
		System.err.println("exception..in issue..."+exception.getMessage());
		exception.printStackTrace();
	}
%> 
 
</html>

