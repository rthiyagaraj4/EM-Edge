<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
	<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
		 <script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		 <script language="javascript" src="../../eST/js/StCommon.js"></script>
	     <script language="javascript" src="../../eST/js/StTransaction.js"></script>
		 <script language="JavaScript" src="../../eST/js/StockItemConsumption.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	StockItemConsumptionBean bean	=		(StockItemConsumptionBean) getBeanObject( "stockItemConsumptionBean", "eST.StockItemConsumptionBean" ,request);
	bean.setLanguageId(locale);
	BatchSearchBean bean2 = (BatchSearchBean)getBeanObject("batchSearchBean", "eST.BatchSearchBean", request);
	bean2.setLanguageId(locale);
       bean2.batchSelQty =new HashMap();
	   System.err.println("selqty@@result==="+bean2.getSelectedQTY());
	String display_flag				=		"visibility:hidden";
	String bean_id				    =    "stockItemConsumptionBean";
	String bean_name			    =    "eST.StockItemConsumptionBean";
	Connection con				    = null;
	con						        = ConnectionManager.getConnection(request);
	boolean site_main               = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	bean.setSite_spec_yn(site_main);
	boolean site                    = bean.isSite_spec_yn();
	String trn_type                 = "CON";
	String	BARCODE_YN              = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String index					= bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no				= bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
	String  barcode_applicable      = "";
	String allow_decimals			= "N";
	String usage_type               = "";
	String remarks_code				= "";
	String uom_desc                 = "";
	String uom_code                 = "";
	String store_code               = bean.getStore_code();
	//System.err.println("store_code@@=="+store_code);
	String sel_disable              = "";
	String read_only                = "";
	String phy_ind_id               = "";
	String item_code                = "";
	double temp_conv                = 0.0;
	double avil_qty                 = 0.0;
	int k                           = 0;
	int doc_srl_no_forbean          = -1;
	int no_of_decimals				= 0;
	    no_of_decimals              = bean.getNoOfDecimals();
	int EWDays                      = 0;
	ArrayList result                = new ArrayList();

	if(!store_code.equals(""))
	   result =bean.getItemStoreList(store_code);
	//   System.err.println("result@@@=="+result);
	 int total_records              = result.size()/9;
	 EWDays = bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
	%>
	</head>
	<body onload="FocusFirstElement();GoBarcode();">
	<form name="formStockItemConsumptionListHeader" id="formStockItemConsumptionListHeader">
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
			     <td width="25%" class="white">&nbsp;</td>
				<td class='label' align="center" ><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
				<td colspan=2  class='fields' nowrap>&nbsp;<input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="checkBarcodeScan(event,barcode,trn_type,parent.frameStockItemConsumptionHeader.document.formStockItemConsumptionHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','StockItemConsumptionListHeader');"  ></td>
			</tr>	
		  </table>
		  <div id='divDataTitle' style='overflow:auto;height=500px;width=100%' >
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
			 <tr>
			        <th width ='5%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
					<th width ='10%'><fmt:message key="eST.ItemCode.label" bundle="${st_labels}"/></th>
					<th width ='25%' nowrap><fmt:message key="eST.Item.label" bundle="${st_labels}"/></th>
					<th width ='8%'><fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/></th>
					<th width ='8%'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
					<th width ='8%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
					<th width ='8%'><fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/></th>
					<th width ='8%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
					<th width ='2%'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></th>
			 </tr>	
			 <%
			 int recCount=0,i = 0;
			 String classvalue				=		"";
			
			ArrayList records=new ArrayList();
			for(i = 0; i<result.size(); i=i+9) {
				if (i % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;
              avil_qty         = Double.parseDouble((String)result.get(i+2));
			  uom_code         = (String)result.get(i+3);
			  uom_desc         = bean.getUOMDesc(uom_code);
			  phy_ind_id        = bean.checkForNull((String)result.get(i+3),"");
			  item_code        = (String)result.get(i);
			  temp_conv        = bean.getConvFactTemp(item_code,store_code);
			  sel_disable      = "disabled";
			  read_only        = "readonly";
			  if(avil_qty != 0.0 || avil_qty!=0 ){
                    sel_disable ="";
					read_only ="";
			  }
			  if(phy_ind_id.equals(""))
				   sel_disable ="";
			   
			  if(temp_conv==0.0)
				  temp_conv =1;

		%>
		           <tr id="tr_<%=k%>">
		
		            <td class="<%=classvalue%>"  onmouseover="changeCursor(this);" ><input type="checkbox" value="" onclick="actionRequired('<%=k%>','N')" id ="select_<%=k%>" name ="select_<%=k%>"    <%=sel_disable%>></td>
					<td class="<%=classvalue%>"  align="center" ><%=result.get(i)%></td>
					<input type="hidden" name="item_code_<%=k%>" id="item_code_<%=k%>" value="<%=result.get(i)%>">
			        <td class="<%=classvalue%>"  align="center" ><%=result.get(i+1)%></td>
					<input type="hidden" name="item_desc_<%=k%>" id="item_desc_<%=k%>" value="<%=result.get(i+1)%>">
					<td class="<%=classvalue%>"  align="center" ><%=result.get(i+2)%></td>
					<input type="hidden" name="avail_qty_<%=k%>" id="avail_qty_<%=k%>" value="<%=result.get(i+2)%>">
					<td class="<%=classvalue%>"  align="center" ><%=uom_desc%></td>
					<input type="hidden" name="store_uom_<%=k%>" id="store_uom_<%=k%>" value="<%=result.get(i+3)%>">
					<td class="<%=classvalue%>" ><input type=text name="store_qty_<%=k%>" id="store_qty_<%=k%>" id ="store_qty_<%=k%>" size=10 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onchange="setBeanDetails('<%=k%>',this,'<%=store_code%>')"  value="" <%=sel_disable%>></td>
					<td class="<%=classvalue%>" onClick="callBatchs('<%=k%>');" onmouseover="changeCursor(this);" >
				     <font class='HYPERLINK'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></font></td>
					<input type="hidden" name="batch_id<%=k%>" id="batch_id<%=k%>" value="">
					<td class="<%=classvalue%>" onClick="searchRemarks(remarks_code_<%=k%>,remarks_<%=k%>,'NEWSCREEN',<%=k%>);" onmouseover="changeCursor(this);" >
				      <font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></td>
					<input type="hidden" name="remarks_<%=k%>" id="remarks_<%=k%>" value="">
					<input type="hidden" name="remarks_code_<%=k%>" id="remarks_code_<%=k%>" value="">
					<td class="<%=classvalue%>" align="center"><input type=text name ="item_value_<%=k%>" id ="item_value_<%=k%>" size=10 maxlength=12 class="NUMBER"  onChange="" value="" readonly></td>

					<input type="hidden" name="unit_cost_<%=k%>" id="unit_cost_<%=k%>"         value="<%=result.get(i+4)%>">
					<input type="hidden" name="tmp_conv_<%=k%>" id="tmp_conv_<%=k%>"          value="<%=temp_conv%>">
					<input type="hidden" name="uom_code_<%=k%>" id="uom_code_<%=k%>"          value="<%=result.get(i+3)%>">
					<input type="hidden" name="uom_desc_<%=k%>" id="uom_desc_<%=k%>"          value="<%=uom_desc%>">
					<input type="hidden" name="expiry_yn_<%=k%>" id="expiry_yn_<%=k%>"         value="<%=result.get(i+6)%>">
					<input type="hidden" name="stock_item_yn_<%=k%>" id="stock_item_yn_<%=k%>"     value="<%=result.get(i+7)%>">
					<input type="hidden" name="hdr_qty_<%=k%>" id="hdr_qty_<%=k%>"           value="">
							
<%k++;}%>
       </table>
	   </div>
	    <input type="hidden"    name="trn_type" id="trn_type"		          value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"			  value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"	  value="<%=barcode_applicable%>" >
		<input type="hidden"    name="doc_srl_no_forbean" id="doc_srl_no_forbean"	  value="<%=doc_srl_no_forbean%>" >
		<input type="hidden"    name="no_of_decimals" id="no_of_decimals"		  value="<%=no_of_decimals%>" >
		<input type="hidden"    name="site" id="site"					  value="<%=site%>" >
		<input type="hidden"    name="index" id="index"				  value="<%=index%>" >
		<input type="hidden"    name="doc_srl_no" id="doc_srl_no"			  value="<%=doc_srl_no%>" >
		<input type="hidden"    name="function_id" id="function_id"			  value="<%= request.getParameter("function_id") %>">
		<input type="hidden"    name="new_con_screen_yn" id="new_con_screen_yn"	  value="Y">
		<input type="hidden"    name="total_records" id="total_records"		  value="<%=total_records%>">
		<input type="hidden"    name="store_code" id="store_code"		      value="<%=store_code%>">
		<input type="hidden"    name="ex_param_days" id="ex_param_days"          value="<%=EWDays%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="lang_id" id="lang_id"			      value="<%=locale%>">
	</form>   
	<%
	if(con != null)
		ConnectionManager.returnConnection(con,request);
%>
<%
putObjectInBean("stockItemConsumptionBean",bean,request);
%>
</body>
</html>

