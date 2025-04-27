<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
15/10/2019		IN071552			Shazana Hasan							TBMC-SCF-0099 
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import=" eST.StockTransferBean,java.util.ArrayList,java.util.HashMap"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StockTransfer.js"></script>
<%

	int i							=		0;
	int expired_batch				=		0 ;

	String mode;
	String bean_id;
	String bean_name;
	String function_id;	
	String avail_qty				=		"";
    String  allow_deci_yn			=	"";
	String	no_deci				    =	"";
    String trn_type                 = null;     //16/09/11
	String  from_store_code = "";
	String item_code				=		"";// request.getParameter("item_code");
    String store_code				=		request.getParameter("store_code")==null?"":request.getParameter("store_code");
	String tmp_conv					=		(String)request.getParameter("tmp_conv");
	String frm_tmp_conv				=		(String)request.getParameter("frm_tmp_conv");
	String ret_qty					=		request.getParameter("ret_qty")==null?"":request.getParameter("ret_qty");
	
	String kit12					=		(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
	
	String display_flag				=		"visibility:hidden";
	HashMap ExpDtl					=		new HashMap();
	ArrayList alDetailData			=		new ArrayList();
	mode							=		request.getParameter( "mode" ) ;
	if(mode==null)		mode		=		"1";

	function_id						=		request.getParameter( "function_id" ) ;
	bean_id							=		"stockTransferBean" ;
	bean_name						=		"eST.StockTransferBean";
	StockTransferBean bean			=		(StockTransferBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	String item_desc				=		"";
	

	String BARCODE_YN					=		request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	

	//ArrayList alDetailData			=		bean.getDtlRecords();
	ArrayList dummy = new ArrayList();
	System.out.println("alDetailData-57----->"+bean.getDtlRecordsforBarCode());
	if (BARCODE_YN.equals("TRUE"))
	alDetailData		=		bean.getDtlRecordsforBarCode()==null?dummy:bean.getDtlRecordsforBarCode();
	else
	alDetailData		=		bean.getDtlRecords();
	System.out.println("alDetailData-----T----60--->"+alDetailData);


	avail_qty						=		bean.checkForNull(request.getParameter("avail_qty"));
	avail_qty						=		avail_qty.trim();
    String temp						=		request.getParameter("arr")==null?"":request.getParameter("arr");

	java.util.StringTokenizer st	=		new java.util.StringTokenizer(temp,",");
	ArrayList arr					=		new ArrayList();
	//if(!(store_code.equals(""))){
		if(alDetailData.size()>0)
		{
		 //Added By Rabbani #inc no:28266 on 16/09/11
		 //Starts here
		 ArrayList  alist =  bean.getTrnTypeArrayList();
	     for(int k=0; k<alist.size(); k++){
	     HashMap  blist = (HashMap)alist.get(k);
	     for(int l=0; l<blist.size();l++){
	     trn_type = (String)blist.get("TRNTYPE");
	      if(trn_type.equals("TFR")){
		  if(((String)bean.getCostYN(store_code)).equals("Y")){ 
	  	  display_flag	="visibility:visible"; 
			}		 
		    } 
		   }
		  }
		  if(trn_type == null){
	       if(((String)bean.getAccessCostDetails()).equals("Y")){
            display_flag	=		"visibility:visible"; 
            }
            }  

			System.out.println("display_flag---92"+display_flag);
	 //Ends here 
		 //if(((String)bean.getAccessCostDetails()).equals("Y"))
			//display_flag			=		"visibility:visible"; 
	//}
	}
	while( st.hasMoreElements()){
			arr.add(st.nextElement() );
	}

//	int rowsel						=		0;
    int EWDays						=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));


	//ExpDtl							=		bean.getExpRecords();

	if (BARCODE_YN.equals("TRUE"))
		ExpDtl					=		bean.getExpRecordsforBarCode();
	else
		ExpDtl					=		bean.getExpRecords();

	
%>
	</head>
<body>
<form name='formStockTransferDetail' id='formStockTransferDetail'>
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 80"></div>

	<table border='1' cellpadding='0' cellspacing='0' width=300 align=center id="tab1">
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>

	<%
	ArrayList alTemp = new ArrayList();
	HashMap ht						=	null;
	HashMap hmTemp					=	null;
	HashMap rol_min					=	null;
	System.out.println("alDetailData.size()===>"+alDetailData.size());
	 for(i=0;i<alDetailData.size();i++)
	 {
 	    expired_batch					=		0 ;
		alTemp							=		(ArrayList)ExpDtl.get("" + i) ;
		String classValue				=		"";
		String item_qty					=		"";		
		ht								=		(HashMap)alDetailData.get(i);
		System.out.println("alDetailData==ht=>"+ht);

		item_qty						=		bean.checkForNull((String)ht.get("item_qty"),"0");

		if(ht.containsKey("allow_deci_yn"))
		allow_deci_yn					=		bean.checkForNull((String)ht.get("allow_deci_yn"),"N");
		else
		allow_deci_yn					=		bean.checkForNull((String)ht.get("decimal_allowedYN"),"N");
		
		if(ht.containsKey("no_deci"))
		no_deci						    =		bean.checkForNull((String)ht.get("no_deci"),"0");
		else
		no_deci						    =		bean.checkForNull((String)ht.get("no_of_decimals"),"0");


		avail_qty						=		bean.checkForNull((String)ht.get("stock_available"),"0") ;	
		item_code						=		(String)ht.get("item_code") ;
		store_code						=		(String)ht.get("store_code") ;
		String to_store_max_qty			=		"";
		String to_store_qty_on_hand		=		"";
		 String deleted				=		"";
	     String chk_disabled         =       "";
	
		if(i%2==0)classValue			=		"QRYEVEN";
		else	classValue				=		"QRYODD";
			
			//Added by Sakti sankar against AAKH-CRF-0022-Inc#38258	
				
				HashMap hmRecord	=	null;
				String spcfn_img_display;
				hmRecord = bean.getItemSpecfnRemarks(bean.checkForNull((String)ht.get("item_code")),bean.getLanguageId());
				String item_specfin_name = CommonBean.checkForNull((String)hmRecord.get("ITEM_SPECIFICATION"),"");
				String item_remarks = CommonBean.checkForNull((String)hmRecord.get("ITEM_REMARKS"),"");
				//System.out.println("item_specfin_name"+item_specfin_name);
				//System.out.println("item_remarks"+item_remarks);
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
				if((((String)ht.get("expiry_yn")).equals("XX"))||((String)ht.get("item_unit_cost")).equals("")||((String)ht.get("stock_available")).equals("0")){
%>			
			<tr id="tr_<%=i%>">

				<td align='center' width='1' class="<%=classValue%>"> 
					<input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" checked disabled>
				</td>

			<td width='230' class="<%=classValue%>" style='WORD-BREAK:BREAK-ALL;'>
			<font size=1><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<span style="<%=display_flag%>"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></span></font>
			</td>
		</tr>
			<%}else{

			for(int j=0;j<alTemp.size(); j++)
			 {
				hmTemp = (HashMap)alTemp.get(j); 
				int intTempNOD			=		Integer.parseInt((String)hmTemp.get("NOD"));

				if( (intTempNOD < EWDays || intTempNOD < 0) && (((String)hmTemp.get("EXPIRY_YN")).equals("Y")) ){ //IN071552
				  expired_batch			=		expired_batch + 1 ;
				}
			 }

			rol_min						=		(HashMap)bean.getROL((String)ht.get("item_code"),store_code);
			String alt_text				=		"";
			boolean display_gif			=		false;

			//to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			//to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	
			
			if (BARCODE_YN.equals("TRUE")){
			to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecordforBarcode(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecordforBarcode(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	
			
			}else{
			to_store_max_qty			=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
			to_store_qty_on_hand		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	
			}
			
			System.out.println("to_store_max_qty-->"+to_store_max_qty);
			System.out.println("to_store_qty_on_hand-->"+to_store_qty_on_hand);
			if( expired_batch > 0){
				String exp_batch		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
				alt_text				=		expired_batch +exp_batch ;
			}
			

			String kit_usage_type = "";

			  /*if(ht.containsKey("kit_temp_code")){
				 kit_usage_type = bean.checkForNull((String)bean.getUsageType((String)ht.get("kit_temp_code"),(String)ht.get("item_code")));
			  }*/
			  
			   if(ht.containsKey("usage_type")){
				 kit_usage_type = bean.checkForNull((String)ht.get("usage_type"));
			  }
			  System.out.println("usage_type=221 detail==>" +kit_usage_type);
			  
			  if(kit_usage_type.equals("R")){
			    deleted   ="";
			    chk_disabled = "disabled";
			   }
			   else if(kit_usage_type.equals("O")){
			      deleted   ="";
			      chk_disabled = "";
			    }
			    else if(kit_usage_type.equals("P")){
			    deleted   ="checked";
			    chk_disabled = "";
			    }
			    else if(kit_usage_type.equals("D")){
				deleted   ="checked";
			    chk_disabled = "disabled";
				}

		%>

		<tr id="tr_<%=i%>">

			<td align='center' width='1' class="<%=classValue%>"> 
				<input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=((arr.size()==alDetailData.size() || i < (alDetailData.size()-1)) && mode.equals("1") ?arr.get(i):"")%> <%=deleted%> <%=chk_disabled%> onclick = "chkstatus('<%=i%>');">
			</td>

			<td width='230' class="<%=classValue%>" style='WORD-BREAK:BREAK-ALL;'>
	<% 
					
					if ( (Double.parseDouble(avail_qty) - Double.parseDouble(item_qty))  <  Double.parseDouble((String)rol_min.get("REORDER_LEVEL"))){
					String less_than_min_stock		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.LessThanROLinFromStore.label","st_labels");
					alt_text						=		less_than_min_stock+"\n" + alt_text;
					//alt_text						=		alt_text + "Less Than R.O.L in From Store \n";
					display_gif						=		true;
					}
					if ( (Double.parseDouble(avail_qty) - Double.parseDouble(item_qty))  <  Double.parseDouble((String)rol_min.get("MIN_STK_QTY"))){

					String BelowMinStkinFromStore	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.BelowMinStkinFromStore.label","st_labels");
					alt_text						=		alt_text+ BelowMinStkinFromStore+"\n";
					//alt_text						=		alt_text + "Below Min. Stk. in From Store \n";
					display_gif						=		true;
					}
					if (expired_batch > 0){
						display_gif = true;
					}
					if ( !(to_store_max_qty == null || to_store_max_qty.equals("")))
					{
						if ( (Double.parseDouble(to_store_qty_on_hand) + Double.parseDouble(item_qty))  >  Double.parseDouble(to_store_max_qty))
						{
						String ExceedsMaxStkinToStore	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExceedsMaxStkinToStore.label","st_labels");
						alt_text						=		alt_text+ExceedsMaxStkinToStore+"\n";
						display_gif						=		true;
						}
					}
					if (display_gif) {
					%>
						<img src="../images\info1.gif" title="<%=alt_text%>" height=12 >&nbsp;
					<%}%>

			<% System.out.println("display_flag----->"+display_flag); %>

			 <!--<font size=1><a  name="a_<%=i%>" href="javascript:modifyData(<%=i%>,'<%=ht.get("item_code")%>');"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber((String)ht.get("item_qty"),Integer.parseInt(no_deci))%>&nbsp;&nbsp;<label style="<%=display_flag%>"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></label></font></a>-->

			 <font size=1><a  name="a_<%=i%>" id="a_<%=i%>" href="javascript:modifyData(<%=i%>,'<%=ht.get("item_code")%>');"><%=ht.get("item_desc")%>&nbsp;</a><a style='<%=spcfn_img_display%>;'href="javascript:callItemSpcfnWindow('<%=bean.checkForNull((String)ht.get("item_code"))%>',document.formStockTransferDetail.item_desc_<%=i%>);"><img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_desc%>');"   onMouseout="onMOut(msg);"   src='../../eST/images/info.gif' ></img></a><a   href="javascript:modifyData(<%=i%>,'<%=ht.get("item_code")%>');"><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber((String)ht.get("item_qty"),Integer.parseInt(no_deci))%>&nbsp;&nbsp;<span style="<%=display_flag%>"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></span></font></a>
			 <input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" > 

			</td>
		</tr>
				
	<%}}%>

	</table>
		<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
		<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
		<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">
		<input type="hidden" name="tmp_conv" id="tmp_conv"				value="<%=tmp_conv%>">
		<input type="hidden" name="frm_tmp_conv" id="frm_tmp_conv"			value="<%=frm_tmp_conv%>">
		<input type="hidden" name="ret_qty" id="ret_qty"					value="<%=ret_qty%>">
 		<input type="hidden" name="item_code" id="item_code"				value="<%=item_code%>">
    	 <input type="hidden" name="allow_deci_yn" id="allow_deci_yn" value="<%=allow_deci_yn%>">
	    <input type="hidden" name="no_deci" id="no_deci"		 value="<%=no_deci%>">
		<input type="hidden" name="from_store_code" id="from_store_code"				value= '<%=from_store_code%>'>

		<input type="hidden" name="BARCODE_YN" id="BARCODE_YN" value="<%= BARCODE_YN %>">

 	</form>
<%
putObjectInBean(bean_id,bean,request);
%>

</body>
<%
	if(kit12.equals("kit")){
%>
	<script>
		//setTimeout("parent.frameStockTransferList.formStockTransferListHeader.example();",100);//example1();
		setTimeout("kitNextItem();",200);//example1();
	</script>
<%}
if(alDetailData.size()>0)
%>
	<script>
		setTimeout("toConvFactor();",1500);//toConvFactor();
	</script>
<%if (request.getParameter("index")!=null && !(kit12.equals("kit"))) {%>
  
<script language="JavaScript">
	document.getElementById("a_<%= (request.getParameter("index").equals("-1") ? "" + (i - 1) : request.getParameter("index")) %>").scrollIntoView();
	changeRowColor(document.getElementById("tr_<%=(request.getParameter("index").equals("-1")?""+(i-1):request.getParameter("index"))%>"));	
</script> 
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</html>


