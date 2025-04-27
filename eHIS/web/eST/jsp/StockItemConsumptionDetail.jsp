<!DOCTYPE html>

<%@page contentType="text/html;charset=UTF-8" import=" eST.StockItemConsumptionBean,eST.Common.*,java.util.ArrayList,java.util.HashMap"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<title> </title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		 (String)session.getAttribute("LOCALE");	
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StockItemConsumption.js"></script>
<%
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String store_code			=		"";
	String avail_qty			=		"";
	String display_flag			=		"visibility:hidden";
	String kit12=(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
	String item_desc			=		"";
	
	
	mode						=		request.getParameter( "mode" ) ;
	if(mode==null)mode="1";
	function_id					=		request.getParameter( "function_id" ) ;
	store_code					=		request.getParameter("store_code")==null?"":request.getParameter("store_code");

	bean_id						=		"stockItemConsumptionBean" ;
	bean_name					=		"eST.StockItemConsumptionBean";

	StockItemConsumptionBean bean =		(StockItemConsumptionBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);

    avail_qty					  =		bean.checkForNull(request.getParameter("avail_qty"),"0") ;
//Added for GHL-CRF-0413 starts
    ArrayList alDetailData = null;
    if(bean.isSite_spec_yn()){
    	 alDetailData		  =		bean.getDtlRecordsforBarCode();//bean.getDetailValues();
    }
    else
     alDetailData		  =		bean.getDtlRecords();//bean.getDetailValues();
//Added for GHL-CRF-0413 ends
	//if(!(store_code.equals(""))){
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag		=		"visibility:visible";
	//}
	/**
	* @Name - Suri
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;
%>
	</head>
<body>
<form name='formStockItemConsumptionDetail' id='formStockItemConsumptionDetail' >
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 80"></div>

	<table border='1' cellpadding='0' cellspacing='0' width=300 align="center">
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>
	<%
	HashMap ht					=	null;
	HashMap rol_min				=	null;
	for(i=0;i<alDetailData.size();i++)
	{
		String classValue			=		"";
		ht					=		(HashMap)alDetailData.get(i);
		/**
	* @Name - Suri
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
	String deleted				=		"";
	String chk_disabled         =       "";
//Added for GHL-CRF-0413 starts
	if(bean.isSite_spec_yn()){
		if(((String)ht.get("decimal_allowedYN")).equals("N")){
			no_of_decimals = 0;
		}else{
			no_of_decimals = no_of_decimals_temp;
		}
	}
	else{
		if(((String)ht.get("dec_allowed_yn")).equals("N")){
			no_of_decimals = 0;
		}else{
			no_of_decimals = no_of_decimals_temp;
		}
	}
//Added for GHL-CRF-0413 ends	
		if(i%2==0) classValue		=		"QRYEVEN";
		else		classValue		=		"QRYODD";

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
	   if((((String)ht.get("expiry_yn")).equals("XX"))||((String)ht.get("item_unit_cost")).equals(" ")||((String)ht.get("stock_available")).equals("0")){
%>			
			<tr id="tr_<%=i%>">

				<td align='center' width='1' class="<%=classValue%>"> 
					<input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" checked disabled>
				</td>

			<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
			<font size=1><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></span></font>
			</td>
		</tr>
			<%}else{
				rol_min			=		(HashMap)bean.getROL((String)ht.get("item_code"),store_code);
				String alt_text			=		"";
				 if(Integer.parseInt((String)ht.get("expired_batch")) > 0){
		//			alt_text			=		(String)ht.get("expired_batch")+" Batch(es) expiring in "+(String)ht.get("ex_param_days")+" Days";
					String exp_batch	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
					alt_text			=		(String)ht.get("expired_batch")+exp_batch; 
				}	
			//31/07/12 Starts		
		  /*String kit_usage_type = bean.checkForNull((String)bean.getUsageType(bean.getKit_code(),(String)ht.get("item_code")));
		   String kit_usage_type = bean.checkForNull((String)bean.getUsageType((String)ht.get("kit_temp_code"),(String)ht.get("item_code")));*/
		   //18/09/12
		   String kit_usage_type = bean.checkForNull((String)ht.get("usage_type"));
			  System.out.println("usage_type=221 detail==>" +kit_usage_type);
			  
			  if(kit_usage_type.equals("R")){
			    deleted   ="";
			    chk_disabled = "disabled";
			    System.out.println("usage_type=221 detail=R=>" +kit_usage_type);
			   }
			   else if(kit_usage_type.equals("O")){
			   System.out.println("usage_type=221 detail==O==>" +kit_usage_type);
			      deleted       ="";
			      chk_disabled = "";
			    }
			    else if(kit_usage_type.equals("P")){
			    deleted         ="checked";
			    chk_disabled    = "";
			    System.out.println("usage_type=221 detail====P=>" +kit_usage_type);
			    }
			    else if(kit_usage_type.equals("D")){
				System.out.println("usage_type=221 detail====D=>" +kit_usage_type);
				deleted       ="checked";
			    chk_disabled  = "disabled";
				}	
				%>
			<tr id="tr_<%=i%>">
				<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=deleted%> <%=chk_disabled%> onclick = "chkstatus('<%=i%>');"></td>
				<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
				<% 
				if ( (Double.parseDouble(avail_qty) - Double.parseDouble((String)ht.get("item_qty")))  <  Double.parseDouble((String)rol_min.get("MIN_STK_QTY"))){
					String less_than_min_stock		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanminstock.label","st_labels");
					alt_text						=	 less_than_min_stock +"\n"+alt_text;
				%>
				<img src="../images\info1.gif" alt="<%=alt_text%>" height=12 >&nbsp;

				<%}
				else if ( (Double.parseDouble(avail_qty) - Double.parseDouble((String)ht.get("item_qty")))  <  Double.parseDouble((String)rol_min.get("REORDER_LEVEL"))){
					String less_than_rol			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanROL.label","st_labels");
					alt_text						=	less_than_rol+alt_text;
				%>
				<img src="../images\info1.gif" alt="<%=alt_text%>" height=12 >&nbsp;
				<%}
				else if(Double.parseDouble((String)ht.get("expired_batch")) > 0){
					%>
						<img src="../images\info1.gif" alt="<%=alt_text%>" height=12 >&nbsp;
		<%		}
				%>	
				<!--<font size=1><a  name="a_<%=i%>" href="javascript:modifyData(<%=i%>);"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber((String)ht.get("item_qty"),no_of_decimals)%>&nbsp;&nbsp;<label style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=(String)ht.get("item_cost_value")%></label></font></a></td>	-->
				
				<font size=1><a  name="a_<%=i%>" href="javascript:modifyData(<%=i%>);"><%=ht.get("item_desc")%>&nbsp;</a><a style='<%=spcfn_img_display%>;'href="javascript:callItemSpcfnWindow('<%=bean.checkForNull((String)ht.get("item_code"))%>',document.formSalesDetail.item_desc_<%=i%>);"><img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_desc%>');"   onMouseout="onMOut(msg);"   src='../../eST/images/info.gif' ></img></a><a   href="javascript:modifyData(<%=i%>);"><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber((String)ht.get("item_qty"),no_of_decimals)%>&nbsp;&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=(String)ht.get("item_cost_value")%></span></font></a><input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" > </td>	
			</tr>								
	<%}}
	bean.getTempBatchRecords().clear();//Added for GHL-CRF-0413
	%>
	</table>
		<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
<!-- 	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
		<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
 -->	<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">

	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
<%
	if(kit12.equals("kit")){
%>
	<script>
		//setTimeout("parent.frameSalesList.formSalesListHeader.example();",100);//example1();
		setTimeout("kitNextItem();",300);//example1();
	</script>
<%}

if (request.getParameter("index")!=null  && !(kit12.equals("kit"))) {%>
<script language="JavaScript">
	document.getElementById("a_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
	changeRowColor(document.getElementById("tr_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</html>

