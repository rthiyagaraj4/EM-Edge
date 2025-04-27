<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8"  import=" eST.IssueReturnBean,java.util.HashMap,java.util.ArrayList"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/IssueReturn.js"></script>
	</head>

	<%
	int i							=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String item_code				=		request.getParameter("item_code");
	//String store_code				=		request.getParameter("store_code")==null?"":request.getParameter("store_code");
	String frm_store_min_qty		=		"";
	String to_store_max_qty			=		"";
	String to_store_qty_on_hand		=		"";
	boolean display_gif				=		false;
	String alt_text					=		"";
	String avail_qty				=		"";
	String item_qty					=		"";
	String display_flag				=		"visibility:hidden";
	String tmp_conv					=		(String)request.getParameter("tmp_conv");
	String frm_tmp_conv				=		(String)request.getParameter("frm_tmp_conv");
	String ret_qty					=		request.getParameter("ret_qty")==null?"":request.getParameter("ret_qty");
	String item_desc				=		"";

	mode							=		request.getParameter( "mode" ) ;
	if(mode==null)mode				=		"1";
	function_id						=		request.getParameter( "function_id" ) ;
	
	bean_id							=		"issueReturnBean" ;
	bean_name						=		"eST.IssueReturnBean";

	IssueReturnBean bean			=		(IssueReturnBean)getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);

 	/**
	* @Name - Mahesh
	* @Date - 02/02/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;
	ArrayList alDetailData			=		bean.getDtlRecords();//bean.getDetailValues();
	//if(!(store_code.equals(""))){
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag			=		"visibility:visible";
	//}

%>


	<body>
	<form name='formIssueReturnDetail' id='formIssueReturnDetail' >
	<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 80">
	</div>
		<table border='1' cellpadding='0' cellspacing='0' width=300 align=center>
			<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	        <th><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></th>


		 <%  
			 HashMap ht					=	null;
                String classValue		=		"";
			 for(i=0;i<alDetailData.size();i++) {
          		 classValue		=		"";
				ht				=		(HashMap)alDetailData.get(i);
				//out.println("ht===>"+ht);
				avail_qty				=		(String)bean.getDtlRecord(Integer.parseInt(i+"")).get("stock_available");	
				//avail_qty				=		avail_qty.trim();
				item_qty				=		(String)ht.get("item_qty");
				//item_qty				=		item_qty.trim();
				frm_store_min_qty		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("frm_store_min_stk_level"));	 
				to_store_max_qty		=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_max_stk_level"));	
				to_store_qty_on_hand	=		bean.checkForNull((String)bean.getMinMaxRecord(Integer.parseInt(i+"")).get("to_store_qty_on_hand"));	

					alt_text			=		"";
					display_gif			=		false;
 	/**
	* @Name - Mahesh
	* @Date - 02/02/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
					if((bean.getAllowDecimalsYN((String)ht.get("item_code"))).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals = no_of_decimals_temp;
					}

				if(i%2==0)classValue	=		"QRYEVEN";
				else classValue			=		"QRYODD";
		if (item_code!=null) {
			if (item_code.equals((String)ht.get("item_code"))) {
				classValue				=		"STLIGHTPINK";
			}

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
				//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
					item_desc = (String)ht.get("item_desc");
					item_desc = item_desc.replaceAll(" ","%20");
					item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
					item_desc = item_desc.replaceAll("%2520","%20");
					//Added ends
		%>
			
		
			<tr  id="tr_<%=i%>">
				<td align='center' width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>
				<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
				<%
				
				if ( !(frm_store_min_qty == null || frm_store_min_qty.equals("")))
				{
					if ( (Double.parseDouble(avail_qty) - Double.parseDouble(item_qty))  <  Double.parseDouble(frm_store_min_qty)){
					String BelowMinStkinFromStore	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.BelowMinStkinFromStore.label","st_labels");
					alt_text						=	alt_text+ BelowMinStkinFromStore+"\n";
					//alt_text						=	alt_text + "Below Min. Stk. in From Store \n";
						display_gif					=	true;
					}
				}
				if ( !(to_store_max_qty == null || to_store_max_qty.equals("")))
				{
					if ( (Double.parseDouble(to_store_qty_on_hand) + Double.parseDouble(item_qty))  >  Double.parseDouble(to_store_max_qty))
					{	
					String ExceedsMaxStkinToStore	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ExceedsMaxStkinToStore.label","st_labels");
					alt_text						=	alt_text+ExceedsMaxStkinToStore+"\n";
					//alt_text						=	alt_text + "Exceeds Max. Stk. in To Store \n";
						display_gif					=	true;
					}
				}
				if (display_gif) {
				%>
					<img src="../images\info1.gif" title="<%=alt_text%>" height=12 >&nbsp;
				<%}%>


				<!--<font size=1><a  name="a_<%=i%>" href="javascript:modifyData(<%=i%>);setTempConvFactor(<%=tmp_conv%>);setFromTempConvFactor( <%=frm_tmp_conv%>);"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber((String)ht.get("item_qty"),no_of_decimals)%>&nbsp;&nbsp;<label style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></label></font></a></td>-->

				<font size=1><a  name="a_<%=i%>" href="javascript:modifyData(<%=i%>);setTempConvFactor(<%=tmp_conv%>);setFromTempConvFactor( <%=frm_tmp_conv%>);"><%=ht.get("item_desc")%>&nbsp;</a><a style='<%=spcfn_img_display%>;'href="javascript:callItemSpcfnWindow('<%=bean.checkForNull((String)ht.get("item_code"))%>',document.formIssueReturnDetail.item_desc_<%=i%>);"><img onmouseover="onMOver(msg,event,'<%=item_specfin_name%>','<%=item_remarks%>','<%=item_desc%>');"   onMouseout="onMOut(msg);"  src='../../eST/images/info.gif'   ></img></a><a  href="javascript:modifyData(<%=i%>);setTempConvFactor(<%=tmp_conv%>);setFromTempConvFactor( <%=frm_tmp_conv%>);"><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=bean.setNumber((String)ht.get("item_qty"),no_of_decimals)%>&nbsp;&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></span></font></a>
				<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" ></td>
			</tr>
	<%
		item_code  = (String)ht.get("item_code") ;
}
				//Added for GHL-CRF-0413 starts
				bean.getTempBatchRecords().clear();
				bean.getAlTempExpRecords().clear();
				//Added for GHL-CRF-0413 ends
%>
	</table>
		<input type="hidden" name="total_checkboxes" id="total_checkboxes"			value="<%=i%>">
		<input type="hidden" name="function_id" id="function_id"					value="<%= function_id %>">
		<input type="hidden" name="records_to_delete" id="records_to_delete"			value="">
		<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"					value="<%= bean_name %>">
		<input type="hidden" name="tmp_conv" id="tmp_conv"					value="<%=tmp_conv%>">
		<input type="hidden" name="frm_tmp_conv" id="frm_tmp_conv"				value="<%=frm_tmp_conv%>">
		<input type="hidden" name="ret_qty" id="ret_qty"						value="<%=ret_qty%>">
		<input type="hidden" name="item_code" id="item_code"					value="<%=item_code%>">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
<%if(alDetailData.size()>0)
	%><script>
		    setTimeout("toConvFactor();",1500);
	//	toConvFactor();
		</script>
<%if (request.getParameter("index")!=null && !request.getParameter("index").equals("undefined")) {%>
<script language="JavaScript">
	document.getElementById('a_')<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
	changeRowColor(document.getElementById('tr_')<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</html>

