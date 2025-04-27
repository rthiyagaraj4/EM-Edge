<!DOCTYPE html>

 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<!--     <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language='javascript' src='../../eST/js/ChangeBinLocation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%  
    String bin_code_list			=			"";
   	ChangeBinLocationBean bean		=			(ChangeBinLocationBean) getBeanObject( "ChangeBinLocationBean","eST.ChangeBinLocationBean" ,request); 
 	bean.setLanguageId(locale); 
	String bean_id = "ChangeBinLocationBean";
	String bean_name = "eST.ChangeBinLocationBean";  
	StHeaderBean beanHdr			=			(StHeaderBean) getBeanObject( "stHeaderBean","eST.Common.StHeaderBean",request );
	String store_code				=			beanHdr.getStore_code();		
	HashMap DtlArray				=			new HashMap();
    String doc_srl_no				=			request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	if(doc_srl_no!="-1") {
		DtlArray					=			bean.getDetailList(doc_srl_no);
	}

	String item_code				=			request.getParameter("item_code")==null?"":request.getParameter("item_code");
 	/**
			* @Name - Priya
			* @Date - 11/02/2010
			* @Inc# - 19210
			* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
			*/
		int no_deci                   =    bean.getNoOfDecimals();
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_deci = 0;
		}
//	String item_desc				=			request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
//  String batch_id					=			request.getParameter("batch_id")==null?"":request.getParameter("batch_id");
//  String trade_name				=			request.getParameter("trade_name")==null?"":request.getParameter("trade_name");
//  String uom						=			request.getParameter("uom")==null?"":request.getParameter("uom");
//  String expiry_date				=			request.getParameter("expiry_date")==null?"":request.getParameter("expiry_date");
	String new_bin_loc_desc			=			request.getParameter("new_bin_loc_desc")==null?"":request.getParameter("new_bin_loc_desc");
//	String adj_item_qty				=			request.getParameter("adj_item_qty")==null?"":request.getParameter("adj_item_qty");
	String new_bin_loc_code			=			request.getParameter("new_bin_loc_code")==null?"":request.getParameter("new_bin_loc_code");
     bin_code_list					=			bean.getSTITBin_location_code_List(store_code,item_code,new_bin_loc_code,locale);
	 
	 //Added by Rabbani #Inc no:29973 on 11/05/12 Starts
	   String facility_id	        =	beanHdr.getLoginFacilityId(); 
	   String  trn_type  = "CBL";
       String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
 	   boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facility_id,trn_type);   
	   //System.out.println("BarCodeApplicable===66===>" +BarCodeApplicable);
	   HashMap BarCodeRules = bean.getNewBarCodeRules(facility_id);
	  // System.out.println("BarCodeRules ===PRT==>"+BarCodeRules);
	   String BarcodeRule = bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));
       //System.out.println("BarcodeRule ===PRT==>"+BarcodeRule);			
	   String BarcodeRule_Disable = "";
	   if(BarcodeRule.equals("P") ||BarcodeRule.equals("S") )
	   BarcodeRule_Disable = "ReadOnly";
	   //ends
	   	String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	   
	   
%>

<BODY onLoad="FocusFirstElement();"><%//store_code%>
<form name=formChangeBinLocationList>
<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align=center>
<TR>
 <td colspan=5>
  <table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
  <% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 align=left class='label' colspan=2><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends%>
   <TR> 
    <TD class="label"  ><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</TD>
	<TD class="fields" >
	<% if(!doc_srl_no.equals("-1")){ %>
     	<input type=text name="item_desc" id="item_desc" size=70 maxlength=60 value="<%=DtlArray.get("item_desc")%>" readOnly><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen()" value='?' disabled>&nbsp;<%=bean.getImage("M")%>
    <% }else{ %>
	   <!--<input type=text name=item_desc size=70 maxlength=60><input type=button name="item_search" id="item_search" class="button" onClick="callItemSearchScreen()"  value='?'>&nbsp;<%=bean.getImage("M")%> -->
		 
		<input type=text name="item_desc" id="item_desc" size=70 maxlength=60 onkeypress="callBarCodeBatchSearchChangeBin(event, trn_type,parent.frameChangeBinLocationHeader.document.formChangeBinLocationHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>'); " ><input type=button name="item_search" id="item_search" class="button"  onClick="callBarCodeBatchSearchChangeBin(event,trn_type,parent.frameChangeBinLocationHeader.document.formChangeBinLocationHeader.store_code,'' ,this.form,'<%=bean_id%>','<%=bean_name%>');"  value='?' >&nbsp;<%=bean.getImage("M")%>
		
    <% } %></TD>
	
	
	<TD id=td_uom name=td_uom  class=label width="15%">
	<% if(!doc_srl_no.equals("-1")){ %><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;<b> <%=DtlArray.get("uom")%> </b><% }else{ %>
    <b>&nbsp;</b></TD>   <% } %>
	
	
	 
<%if(BarCodeApplicable){%>
	
	  <td class = 'label'><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></td>
	  <% if(doc_srl_no.equals("-1")){ %>
			<td  class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id" id="barcode_id" size=12 maxlength=20 class="NUMBER" onKeyPress="return  CheckForSpecialChars(event);"  onBlur=""  value=""  <%=BarcodeRule_Disable%> ></td>
			<%}else{%>
			<td class='fields'>&nbsp;&nbsp;<input type=text name="barcode_id" id="barcode_id" size=12 maxlength=20 onKeyPress="return  CheckForSpecialChars(event);" class="NUMBER"  value= "<%=bean.checkForNull((String)DtlArray.get("new_barcode_id"))%>" <%=BarcodeRule_Disable%> > </td>
	  <%
	  }
	  }%>
	 
	<% if(!doc_srl_no.equals("-1")){%>

	<TD  class=label nowrap><fmt:message key="eST.ToBinLocation.label" bundle="${st_labels}"/>&nbsp;
	<select name="to_bin_location" id="to_bin_location" ><%=bin_code_list%> </select> <%=bean.getImage("M")%></TD>
	<input type=hidden name="Hnewbinloc" id="Hnewbinloc" value="<%=new_bin_loc_desc%>">	



	<%	} else{%>
	<%if(BarCodeApplicable){%>
	<TD  class=label nowrap><fmt:message key="eST.ToBinLocation.label" bundle="${st_labels}"/>&nbsp;
	<select name="to_bin_location" id="to_bin_location"   disabled onFocus="populateBinLocation();" onblur = "batchsearchbarcode();"><%=bin_code_list%> </select> <%=bean.getImage("M")%></TD>
	<%}else{%>
	<TD  class=label nowrap><fmt:message key="eST.ToBinLocation.label" bundle="${st_labels}"/>&nbsp;
	<select name="to_bin_location" id="to_bin_location" disabled onFocus="populateBinLocation();" ><%=bin_code_list%> </select> <%=bean.getImage("M")%></TD>
	
	<%}
	}%>
	<TD >
	<% if(!doc_srl_no.equals("-1")){ %> <input type=button name="batch_search" id="batch_search" class="button" value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' onClick="validateBinLocation();" disabled> <% }else{ %>
	<input type=button name="batch_search" id="batch_search" class="button" onclick="validateBinLocation(),batchsearchclick();" disabled value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>'></TD> <% } %>
   
	</tr>
  </table>
 </td>   
</TR>
<% if(!doc_srl_no.equals("-1")){ %>

 <TR>
  <TD colspan=5 class="label">
    <table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
    <TR>
     <TD id=batch name=batch class=label ><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></TD>
	 <TD id=batch_dtl name=batch_dtl class=fields colspan=1 ><b>&nbsp;<%=DtlArray.get("batch_id")%></b></TD>
     <TD id=tradename name=tradename class=label ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></TD>
	 <TD id=batch_dtl4 name=batch_dtl4  class=fields colspan=1 ><b>&nbsp;<%=DtlArray.get("trade_name")%></b></TD>
	 <TD id=available_qty name=available_qty class=label ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>.</TD>
	 <TD id=batch_dtl3 name=batch_dtl3  class=fields colspan=1 ><b>&nbsp;<%=bean.setNumber((String)DtlArray.get("avl_item_qty"),no_deci)%></b></TD>
	 <TD id=bin_location name=bin_location class=label ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></TD>
	 <TD id=batch_dtl1 name=batch_dtl1  class=fields colspan=1> <b>&nbsp;<%=DtlArray.get("old_bin_loc_desc")%></b></TD>
	 <TD id=expiry_date name=expiry_date class=label ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></TD>
	 <TD id=batch_dtl2 name=batch_dtl2  class=fields colspan=1 ><b>&nbsp;<%=com.ehis.util.DateUtils.convertDate((String)DtlArray.get("exp_date"),"DMY","en",locale)%></b></TD>
    <TR>
	</table>
   </TD>
 </TR>

<% }else{ %>

<TR>
  <TD colspan=5 class="label">
    <table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
	<TR>
     <TD id=batch class=label ></TD>
	 <TD id=batch_dtl  class=label colspan=1 >&nbsp;</TD>
     <TD id="tradename" class=label ></TD>
	 <TD id=batch_dtl4  class=label colspan=1 >&nbsp;</TD>
     <TD id=available_qty class=label ></TD>
	 <TD id=batch_dtl3  class=label colspan=1 >&nbsp;</TD>
     <TD id=bin_location class=label ></TD>
	 <TD id=batch_dtl1  class=label colspan=1 >&nbsp;</TD>
     <TD id=expiry_date class=label ></TD>
	 <TD id=batch_dtl2  class=label colspan=1 >&nbsp;</TD>
    </tr>
	</table>
  </TD>
</TR>

<% } %>


<% if(!doc_srl_no.equals("-1")){ %>

 <TR> 
  <TD colspan=5>
    <table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
	 <TR> 
        <TD class="label" ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;<input type=text name="adj_item_qty" id="adj_item_qty" size=12 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_deci%>);" onblur="checkDoubleFormat(this); " value=<%=bean.setNumber((String)DtlArray.get("adj_item_qty"),no_deci)%> ><%=bean.getImage("M")%></TD>

		<TD class=fields ><INPUT TYPE="button" name="Modify" id="Modify" value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' class="button" onclick="validateFormForModify();"><INPUT TYPE="button" name="" id="" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancel()" class="button"></TD>

	 </TR>
   </table> 
  </TD> 
 </TR>  

<% }else{ %>

 <TR> 
  <TD colspan=5>
    <table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align=center>
	   <TR>
		<TD  class="label" >&nbsp;<input type=hidden name="adj_item_qty" id="adj_item_qty" size=12 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_deci%>);" onblur="checkDoubleFormat(this); " readOnly></TD>

        <TD  class="label"><INPUT TYPE="button" name="Cancel" id="Cancel" 
		value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onClick="cancel()" class="button"></TD>


	  </TR>
    </table> 
  </TD> 
 </TR>
 			
<% } %>

</TABLE>

	<input type="hidden" name="doc_srl_no" id="doc_srl_no"			value="<%=(request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")%>">
	<input type="hidden" name="store_code" id="store_code"			value="<%=store_code%>">
	<input type="hidden" name="doc_no" id="doc_no">
	<input type="hidden" name="item_code" id="item_code"			<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("item_code")%> >
	<input type="hidden" name="batch_id" id="batch_id"			<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("batch_id")%> >
	<input type="hidden" name="uom_code" id="uom_code"			<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("uom_code")%> >
	<input type="hidden" name="uom" id="uom"					<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("uom")%> >
	<input type="hidden" name="trade_id" id="trade_id"			<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("trade_id")%> >
	<input type="hidden" name="trade_name" id="trade_name"			<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("trade_name")%> >
	<input type="hidden" name="avl_item_qty" id="avl_item_qty"		<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("avl_item_qty")%> >
	<input type="hidden" name="old_bin_loc_code" id="old_bin_loc_code"	<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("old_bin_loc_code")%> >
	<input type="hidden" name="old_bin_loc_desc" id="old_bin_loc_desc"	<% if(doc_srl_no!="-1") %> value="<%=DtlArray.get("old_bin_loc_desc")%>" >
	<input type="hidden" name="new_bin_loc_desc" id="new_bin_loc_desc"	<% if(doc_srl_no!="-1") %> value="<%=DtlArray.get("new_bin_loc_desc")%>" >
	<input type="hidden" name="exp_date" id="exp_date"			<% if(doc_srl_no!="-1") %> value=<%=DtlArray.get("exp_date")%> >
	<input type="hidden" name="phy_inv_id" id="phy_inv_id"			value="">
	<input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>">
	<!-- 		
		* @Name - Priya
		* @Date - 11/02/2010
		* @Inc# - 19210 
		* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	<!-- 30/04/12 -->
		<input type="hidden"    name="trn_type" id="trn_type"							    value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"							    value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"					value="<%=BarCodeApplicable%>" >
		<input type="hidden"    name="item_code_bar_code" id="item_code_bar_code"					value="" >
		<input type="hidden"    name="bar_code" id="bar_code"					value="" >
		<input type="hidden"    name="check" id="check"					value="" >
		<input type="hidden"    name="facility_id" id="facility_id"		    	value="<%=facility_id%>" >
		<input type="hidden"    name="manufacturer_id" id="manufacturer_id"			value="" >
	    <input type="hidden"    name="supplier_id" id="supplier_id"				value="" >
	    <input type="hidden"    name="mrp" id="mrp"						value="" >
	    <input type="hidden"    name="BarcodeRule" id="BarcodeRule"              value="<%=BarcodeRule%>">
	    <input type="hidden"    name="bean_id" id="bean_id"				    value="<%=bean_id%>">
        <input type="hidden"    name="bean_name" id="bean_name"			    value="<%= bean_name %>">
		<input type="hidden"		name="item_2d_barcode_yn" id="item_2d_barcode_yn"		 			 value='<%=item_2d_barcode_yn%>'><!-- added for MOHE-CRF-0167 -->
		
</form>
<%
	putObjectInBean("ChangeBinLocationBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);
%>
</BODY>
</HTML>

