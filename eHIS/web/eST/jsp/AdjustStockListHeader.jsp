<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
18/07/2023      47139             hariharan K                  Ramesh      ML-MMOH-CRF-1982
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.AdjustStockBean, eST.Common.*,eMM.Common.* , eCommon.Common.*, java.sql.*,webbeans.eCommon.*, java.text.*, java.util.HashMap" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<title> 
	</title>
	<%
	
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/AdjustStock.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%	
	eST.AdjustStockBean bean		=		(AdjustStockBean) getBeanObject( "adjustStockBean","eST.AdjustStockBean",request );
	bean.setLanguageId(locale);	

	StHeaderBean beanHdr			=		(StHeaderBean) bean.getStHeaderBean();
	beanHdr.setLanguageId(locale);

	String store_code				=		beanHdr.getStore_code();
	String doc_srl_no				=		request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	String batch_id_applicable_yn	=		request.getParameter("batch_id_applicable_yn");
	String trade_id_applicable_yn	=		request.getParameter("trade_id_applicable_yn");
	String tot_adj_qty				=		request.getParameter("tot_adj_qty")==null?"":request.getParameter("tot_adj_qty");
	String item_cost_value			=		"";
	String item_unit_cost			=		"";
	String item_adj_type			=		"";
	String disabled					=		"";
	String checked					=		"";
	String mode					=		"";
	String adj_item_qty					=		"";
	HashMap DtlArray				=		new HashMap();
	String item_unit_cost_org		=		"";
	/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();
	
	//String item_code = bean.checkForNull(request.getParameter("item_code")); commented by ganga for unused variables on Wednesday, October 19, 2011
	String dec_allowed_yn = "N";

	/**
 * @Name - Priya
 * @Date - 18/05/2010
 * @Inc# - 
 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	// Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013  
	String chk_disp            ="";
	String disabled_disp       = "";
	String disposable = bean.checkForNull((String)bean.getDisposable_yn(),"N");
	String disposable_disabled = bean.checkForNull(request.getParameter("disposable_disabled"),"");
	String  disposable_chk = "";
	//<!-- ML-MMOH-CRF-1982 -- start -->
	boolean st_stock_adj_cost_value_yn=false;
	String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	Connection con				= null;
	try
	{	
		
		con						= ConnectionManager.getConnection(request);
		st_stock_adj_cost_value_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_STOCK_ADJ_COST_VALUE");
		
        }
	finally
	{
		if(con != null)
      		ConnectionManager.returnConnection(con,request);	
	}
    //<!-- ML-MMOH-CRF-1982 -- end --> 
	 

	%>
	</head>
	<body onLoad="FocusFirstElement();totalqty('<%=no_of_decimals%>');checkForQuantityAndValue('fromqty');">
	<form name=formAdjustStockListHeader>
	
<%
	if(doc_srl_no!="-1") {
		/**
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
			*/
		//	dec_allowed_yn=bean.getAllowDecimalsYN(item_code);
		
		DtlArray					=		bean.getDetailList(doc_srl_no);
		
		System.out.println("DtlArray"+DtlArray.toString());
		
		item_adj_type=(String)DtlArray.get("adjustment_type");
		dec_allowed_yn=(String)DtlArray.get("dec_allowed_yn");
		if(dec_allowed_yn.equals("N")){
			no_of_decimals = 0;
		}
		mode=(String)DtlArray.get("mode");
		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue( "MODE_MODIFY") )){
		disabled="disabled";
		
		if(item_adj_type.equals("P")){
		checked="checked";

		}else{
		checked="";
		}
		}else{
		disabled="";
		if(item_adj_type.equals("P")){
		checked="checked";
		}else{
		checked="";
		}
		}
		// Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 
		if(disposable.equals("Y")){
	    chk_disp            ="checked";
	    disabled_disp       = "disabled";
	    }
		//ends
	
%>
	<table border='0' cellpadding='0' cellspacing='2' width='100%' >
		<tr>
			<td colspan=3>&nbsp;</td>
			<!--Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts -->
			<td class=label align=right >
			<fmt:message key="eST.Disposable.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;
			<!--<input type="checkbox" name="disposable_yn" id="disposable_yn" value="<%=disposable%>" <%=chk_disp%> <%=disabled_disp%>>  -->
			<input type="checkbox" name="disposable_yn" id="disposable_yn" value="<%=disposable%>" <%=chk_disp%> disabled> 
			</td>
		</tr>
		 <% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
			<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 style="padding-left: 0px;" align=left class='label' colspan=2><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends%>
		<tr>
			<td class=label align=left width ='12%'><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td  class='fields' width='15%' nowrap colspan ='4' ><input type=text name=item_desc id=item_desc size=70 maxlength=60 disabled value="<%=DtlArray.get("item_desc")%>" ><input type=button name="item_search" id="item_search" class="button" disabled  onClick="callItemSearchScreen(item_code)"  value='?' ><%=bean.getImage("M")%></td>
			<td id=td_uom align=left class='label'><b>
		
			<%if( ((String)DtlArray.get("uom")).length() <= 40){%>
			<%=DtlArray.get("uom")%>
			<%}else{%>
				<%=((String)DtlArray.get("uom")).substring(0,8)%><br>
				<%=((String)DtlArray.get("uom")).substring(8)%>
			<%}%></b></td>
		</tr>
	</table>
	<table border='0' cellpadding='1' cellspacing='0' width='100%' >
	<tr>
	
		<td class=label align=right width ='10%'>&nbsp;&nbsp;</td>
		<td class=label align=left width ='18%'>&nbsp;<fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class=label align=left id='td_av_qty' name='td_av_qty'> <b><%=bean.setNumber(bean.checkForNull((String)DtlArray.get("avl_qty"),"0"),no_of_decimals).replace(".", "")%></b> </td>
		<td class=label align=right width ='20%'><fmt:message key="eST.MinStockLevel.label" bundle="${st_labels}"/> &nbsp;</td>
		<td class=label align=left id=min_stk_qty_label name=min_stk_qty_label><B><%=bean.checkForNull((String)DtlArray.get("min_stk_qty"))%></B></td>
		<td class=label align=right width ='20%'><fmt:message key="eST.MaxStockLevel.label" bundle="${st_labels}"/> &nbsp;</td>
		<td class=label align=left id=max_stk_qty_label name=max_stk_qty_label><B><%=bean.checkForNull((String)DtlArray.get("max_stk_qty"))%></B></td>
		<input type="hidden" name="avl_qty" id="avl_qty" value ="<%=bean.setNumber(bean.checkForNull((String)DtlArray.get("avl_qty"),"0"),no_of_decimals)%>">
		<input type="hidden" name="max_stk_qty" id="max_stk_qty" value ="<%=bean.checkForNull((String)DtlArray.get("max_stk_qty"))%>">
		<input type="hidden" name="min_stk_qty" id="min_stk_qty" value ="<%=bean.checkForNull((String)DtlArray.get("min_stk_qty"))%>">
	</tr>
	</table>
	<table border='0' cellpadding='1' cellspacing='0' width='100%' >
		<tr>
			<td class=label align='left' colspan='5'>
				<fmt:message key="eST.PositiveAdjustment.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="adjustment_type" id="adjustment_type" value="<%=item_adj_type%>" onclick="assignValue(this);" <%=checked%> <%=disabled%> <%=disabled_disp%> > 
			</td>
		</tr>
	
	<tr>
		<%	DecimalFormat dfTest		=		new DecimalFormat("0.000");//ML-MMOH-CRF-1982
			//item_cost_value				=		Double.parseDouble((String)DtlArray.get("item_cost_value"))+"";
			double item_cost_val = Double.parseDouble((String)DtlArray.get("item_cost_value"));		
			item_cost_value			=		String.valueOf(item_cost_val)+"";
		//	item_cost_value			=		dfTest.format(Double.parseDouble(item_cost_value));
			//item_unit_cost				=		Double.parseDouble((String)DtlArray.get("item_unit_cost"))+"";
			//item_unit_cost				=		dfTest.format(Double.parseDouble(item_unit_cost));
			if(!((String)DtlArray.get("item_unit_cost")).isEmpty())
					{
					  double item_unit_cost_val		=		Double.parseDouble((String)DtlArray.get("item_unit_cost"));
					  item_unit_cost			=		item_unit_cost_val+"";
					  item_unit_cost			=		dfTest.format(Double.parseDouble(item_unit_cost));
					  adj_item_qty=(String)DtlArray.get("adj_item_qty");
					}
					else
					{
						item_unit_cost			=	"";
						//item_unit_cost			=	dfTest.format(item_unit_cost);
						adj_item_qty=(String)DtlArray.get("adj_item_qty");
					}
			//item_unit_cost_org			=		Double.parseDouble((String)DtlArray.get("item_unit_cost_org"))+"";
			if(!((String)DtlArray.get("item_unit_cost_org")).isEmpty())
					{
					  double item_unit_cost_val		=		Double.parseDouble((String)DtlArray.get("item_unit_cost_org"));
					  item_unit_cost			=		item_unit_cost_val+"";
					 // item_unit_cost			=		dfTest.format(Double.parseDouble(item_unit_cost));
					 // adj_item_qty=(String)ht.get("adj_item_qty");
					}
					else
					{
						item_unit_cost			=	"";
						//item_unit_cost			=	dfTest.format(item_unit_cost);
					//	adj_item_qty=(String)ht.get("adj_item_qty");
					}
			/**
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - the no of decimals after the decimal ppoint is set for the varible 'adj_item_qty'
			*/
			adj_item_qty=bean.setNumber(bean.checkForNull((String)DtlArray.get("adj_item_qty"),"0"),no_of_decimals);
			item_cost_value				=		dfTest.format(Double.parseDouble(item_cost_value));
			
		%>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class=label align='left' width ='10%'><fmt:message key="eST.AdjustQuantity.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td align=left width="20%"><input type=text name=adj_item_qty  id=adj_item_qty size=12 maxlength=12 class="NUMBER" value="<%=bean.setNumber(bean.checkForNull((String)adj_item_qty,"0"),no_of_decimals).replace(".", "")%>" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);checkMinMaxLevel();totalqty('<%=no_of_decimals%>'); checkForQuantityAndValue('fromqty');"><%=bean.getImage("M")%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		
         <!-- ML-MMOH-CRF-1982 -- start -->
        <%if(st_stock_adj_cost_value_yn){%>
		 <td class=label align=right width="10%"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>&nbsp;
		<input type=text name=item_cost_value id=item_cost_value size=14 maxlength=14 class="NUMBER"  onkeypress="return isValidNumber1(this,event,10,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormatForAllNumbers(this);checkForQuantityAndValue('fromvalue');"  readonly><%=bean.getImage("M")%>&nbsp;&nbsp;</td>
		
		<td class=label align=right width="7%"><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>&nbsp;
		<td class=label align=left id=td_cost name=td_cost><B><%=item_unit_cost%></B></td>
	    <%}
	    else{%>
         
	 	<td class=label align=right width="10%" ><span style="visibility:hidden"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>&nbsp;&nbsp;</span></td>
		<td align=left colspan='1' width="18%" ><span style="visibility:hidden"><input type=text name=item_cost_value id=item_cost_value value="<%=item_cost_value%>" size=14 maxlength=14 class="NUMBER"  onkeypress="return isValidNumber1(this,event,10,<%=noOfDecimalsForCost%>);" onblur="checkNumberValid(); checkForQuantityAndValue('fromvalue');" disabled><%=bean.getImage("M")%>&nbsp;&nbsp;</span></td>

		<td class=label align=right  width="7%"><span style="visibility:hidden"><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>&nbsp;&nbsp;
		<span id=td_cost name=td_cost> <b><%=item_unit_cost%>&nbsp;&nbsp;&nbsp;&nbsp;</b></span></td>
		<%}%>
		 <!-- ML-MMOH-CRF-1982 -- end -->
		 
	</tr>
	<tr>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Size and maxlength of 'tot_adj_qty' is increased to 12 as it has to accept decimal numbers			
		-->
		<td class = label><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
 		<td><input type=text name=tot_adj_qty id=tot_adj_qty size=12 maxlength = 12 class="NUMBER" disabled value="<%=bean.setNumber(bean.checkForNull((String)tot_adj_qty,"0"),no_of_decimals)%>"></td>
		<td colspan=6>
 	</tr>
	<tr>
		<td class=label align='left' '><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<input type="hidden" name="remarks_code" id="remarks_code" value="<%=bean.checkForNull((String)DtlArray.get("remarks_code"))%>">
		<td colspan=6 align=left><textarea style="resize:none" rows=2 cols=50 name=remarks  readonly onblur="setRemarks();"><%=bean.checkForNull((String)DtlArray.get("remarks"))%></textarea><input type='button' class='BUTTON' value='?' onClick="searchRemarks(remarks_code,remarks);"><%=bean.getImage("M")%></td>
		
	</tr>
	<tr>
		<td colspan=7  align=right>&nbsp;<input type=button class=button name="batchSearch" id="batchSearch" value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' onclick="callBatchSearch();" <%=disabled_disp%> >
		</td>
	</tr>
	</table>
<%
	}
	else {
	//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts  
	    if(disposable.equals("Y")){
	    chk_disp            ="checked";
	    disabled_disp       = "disabled";
	    }
		if(disposable_disabled.equals("disabled"))
		  disposable_chk       = "disabled";
		   
%>
	<table border='0' cellpadding='1' cellspacing='0' width='100%' >
		<tr>
			<td colspan=3>&nbsp;</td>
			<!--Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013 Starts -->
			<td colspan=2>&nbsp;</td>
			<td class=label >
				<fmt:message key="eST.Disposable.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="disposable_yn" id="disposable_yn" value="<%=disposable%>" <%=chk_disp%> <%=disabled_disp%> <%=disposable_chk%> onclick="checkstatus(this);"> 
			</td>
		</tr>
			 <% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 style="padding-left: 0px;" align=left class='label' colspan=2><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends%>
	<tr>
		<td class=label align=left ><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  align=left ><input type=text name=item_desc size=70 maxlength=60 onblur="ValidateItem(this);"><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen(item_code)"  value='?' ><%=bean.getImage("M")%></td>
		<td id=td_uom align=left class=label ></td>
	</tr>
	</table>
		
	<table border='0' cellpadding='1' cellspacing='0' width='100%' >
	<tr>
		<td class=label align=right width ='10%'>&nbsp;&nbsp;</td>
		<td class=label align=left width ='18%'>&nbsp;<fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class=label align=left id=td_av_qty name=td_av_qty> </td>
		<td class=label align=right width ='20%'><fmt:message key="eST.MinStockLevel.label" bundle="${st_labels}"/> &nbsp;</td>
		<td class=label align=left id=min_stk_qty_label name=min_stk_qty_label></td>
		<td class=label align=right width ='20%'><fmt:message key="eST.MaxStockLevel.label" bundle="${st_labels}"/>&nbsp;</td>
		<td class=label align=left id=max_stk_qty_label name=max_stk_qty_label></td>
		<input type="hidden" name="avl_qty" id="avl_qty" >
		<input type="hidden" name="max_stk_qty" id="max_stk_qty" >
		<input type="hidden" name="min_stk_qty" id="min_stk_qty" >
	</tr>
	</table>
	<table border='0' cellpadding='1' cellspacing='0' width='100%' >
	<tr>
	<td class=label align=left colspan='2'><fmt:message key="eST.PositiveAdjustment.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;
	<input type="checkbox" name="adjustment_type" id="adjustment_type" value="P" onclick="assignValue(this);" <%=disabled_disp%>  checked ></td>
	</tr>
	<tr>
		<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.			
		-->
		<td class=label align=left width="10%"><fmt:message key="eST.AdjustQuantity.label" bundle="${st_labels}"/>&nbsp;</td>
		<td align=left width="20%"><input type=text name=adj_item_qty id=adj_item_qty size=12 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="checkDoubleFormat(this);checkMinMaxLevel();checkForQuantityAndValue('fromqty');totalqty('<%=no_of_decimals%>');"> <%=bean.getImage("M")%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<!-- ML-MMOH-CRF-1982 -- start-->
		<%if(st_stock_adj_cost_value_yn){%>
		 <td class=label align=right width="10%"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>&nbsp;
		<input type=text name=item_cost_value size=14 maxlength=14 class="NUMBER"  onkeypress="return isValidNumber1(this,event,10,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormatForAllNumbers(this);checkForQuantityAndValue('fromvalue');"  readonly><%=bean.getImage("M")%>&nbsp;&nbsp;</td>
		<td class=label align=right width="7%"><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>&nbsp;
		<td class=label align=left id=td_cost><B><%=item_unit_cost%></B></td>
	    <%}
	    else{%>
         
	 	<td class=label align=right width="10%" ><span style="visibility:hidden"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>&nbsp;&nbsp;</span></td>
		<td align=left colspan='1' width="18%" ><span style="visibility:hidden"><input type=text name=item_cost_value value="<%=item_cost_value%>" size=14 maxlength=14 class="NUMBER"  onkeypress="return isValidNumber1(this,event,10,<%=noOfDecimalsForCost%>);" onblur="checkNumberValid(); checkForQuantityAndValue('fromvalue');" disabled><%=bean.getImage("M")%>&nbsp;&nbsp;</span></td>

		<td class=label align=right  width="7%"><span style="visibility:hidden"><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>&nbsp;&nbsp;
		<span id=td_cost> <b><%=item_unit_cost%>&nbsp;&nbsp;&nbsp;&nbsp;</b></span></td>
		<%}%>
		<!-- ML-MMOH-CRF-1982 -- end-->
		
		
	</tr>
	<tr>
	<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Size and maxlength of 'tot_adj_qty' is increased to 12 as it has to accept decimal numbers			
		-->
		<td class = label><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
 		<td><input type=text name=tot_adj_qty size=12 maxlength = 12 class="NUMBER" disabled value=""></td>
		<td colspan=6> 
 	</tr>
	<tr>
		<td class=label align=left width ='10%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
		<input type="hidden" name="remarks_code" id="remarks_code" value="<%=bean.checkForNull((String)((HashMap)bean.getDefault_remarks()).get("REMARKS_CODE"))%>">
		<td colspan="6" align=left><textarea rows=2 cols=50 name=remarks style="resize:none;" readonly onblur="setRemarks();" ><%=bean.checkForNull((String)((HashMap)bean.getDefault_remarks()).get("REMARKS"))%></textarea>	<input type='button' class='BUTTON' value='?'onClick="searchRemarks(remarks_code,remarks);"><%=bean.getImage("M")%> </td>
		
	</tr>
	<tr>
		<td colspan=7  align=right>&nbsp;<input type=button class=button name="batchSearch" id="batchSearch" value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' <%=disabled_disp%>  onclick="callBatchSearch();">
		</td>
	</tr>
	</table>
<%
	}
%>

	<BR>
	<input type="hidden"	name="doc_type_code" id="doc_type_code" >
	<input type="hidden"	name="doc_no" id="doc_no" >
	<input type="hidden"	name="tmp_conv" id="tmp_conv" >
	<input type="hidden"	name="language_id" id="language_id"						value="<%=locale%>" >
	<input type="hidden"	name="item_code" id="item_code"						value="<%=bean.checkForNull(request.getParameter("item_code"))%>">
	<input type="hidden"	name="store_code" id="store_code"						value="<%=store_code%>">
	<input type="hidden"	name="item_unit_cost" id="item_unit_cost"					value="<%=item_unit_cost%>">
	<input type="hidden"	name="item_last_unit_cost" id="item_last_unit_cost"				value="<%=request.getParameter("itemlastcost")%>">
	<input type="hidden"	name="item_store_unit_cost_1" id="item_store_unit_cost_1"			value="<%=request.getParameter("storecost")%>">
	<input type="hidden"	name="uom" id="uom" >
	<input type="hidden"	name="uom_code" id="uom_code">
	<input type="hidden"	name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
	<input type="hidden"	name="expiry_yn" id="expiry_yn">
	<input type="hidden"	name="batch_id_applicable_yn" id="batch_id_applicable_yn"			value="<%=batch_id_applicable_yn%>">
	<input type="hidden"	name="trade_id_applicable_yn" id="trade_id_applicable_yn"			value="<%=trade_id_applicable_yn%>">
	<input type="hidden"	name="trade_id" id="trade_id">
	<input type="hidden"	name="doc_srl_no" id="doc_srl_no"						value="<%=(request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")%>">
	<input type="hidden"	name="batch_details" id="batch_details" >
	<input type="hidden"	name="mode" id="mode"								value="<%=request.getParameter("mode")%>">
	<input type="hidden"	name="line_mode" id="line_mode"						value="<%=request.getParameter("line_mode")%>">
	<input type="hidden"	name="phy_inv_id" id="phy_inv_id"						value="">
	<input type="hidden"	name="rem_trans_type" id="rem_trans_type"					value="ADJ">
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	<!-- 		
			* @Name - Priya
			* @Date - 13/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=dec_allowed_yn%>">
	<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">
	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>
	<!--Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts -->
	<!--<input type="hidden" name="disp_batch_id" id="disp_batch_id"			value=""> -->
	<input type="hidden"     name="disposable_item_yn" id="disposable_item_yn"			   value="<%=bean.getDisposable_yn()%>"> 
	<input type="hidden"	name="item_unit_cost_org" id="item_unit_cost_org"					value="<%=item_unit_cost_org%>">
	<input type="hidden"	name="item_2d_barcode_yn" id="item_2d_barcode_yn"	value='<%=item_2d_barcode_yn%>'><!-- added for MOHE-CRF-0167 -->

<%
putObjectInBean("adjustStockBean",bean,request);
%>
</form>
</body>
</html>

