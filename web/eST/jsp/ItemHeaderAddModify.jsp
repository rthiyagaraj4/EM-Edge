<!DOCTYPE html>
<%--This JSP is call when a user clicks on Create Button--%>

<%-- JSP Page specific attributes start --%>
<%@page import=" eST.ItemBean, eST.Common.* , eCommon.Common.*, java.util.*,javax.servlet.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<useBean id="ddd" class="eST.Common.StRepository"/>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../../eST/js/Item.js"></script>
		<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!--TH-KW-CRF-0039-->
</head>
<body onload="javascript:document.formItemHeader.medical_item_yn.disabled=true;">
<%
	String mode;
	String bean_id					=		"";
	String bean_name				=		"";
	String codeDisabled				=		"";
	String drug_disabled			=		"disabled";
	String Expiry_disabled			=		"disabled";
	String sterile_disabled			=		"disabled";
	String sterile_status			=		"disabled";
	String Man_Part_status			=		"disabled";
	String modify_disabled			=		"";
	String m_ps_item_yn				=		"";
	String m_sole_source_yn			=		"";
	String m_manufacturer_id		=		"";
	String m_gen_uom_code			=		"";
	String m_long_desc				=		"";
	String m_gen_uom_desc			=		"";
	String batch_id_disabled		=		"";
	String special_req_item_value	=		"";
	String special_req_item_chk		=		"";
	String currsuppdesc				=		"";
	String long_desc				=		"";
	String img_path					=		"";
	String promptAlertDisabled		=		"disabled";
	String visible					=		"visibility:hidden";
	boolean		or_status			=		false;
	String consiment_tr				=		"";
	boolean item_instruction_site	=		false;  //TH-KW-CRF-0039
	
	/* Mandatory checks start */
	mode							=		request.getParameter( "mode" ) ;
	bean_id							=		"itemBean" ;
	bean_name						=		"eST.ItemBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

	/* Mandatory checks end */
	/* Initialize Function specific start */
	ItemBean bean					=		(ItemBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;
    ServletContext context			=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//Added by Sakti sankar against CRF#12 INC#29966
	img_path = bean.checkForNull((String)(((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_IMAGE_CATLG_PATH_SELECT"),bean.getLoginFacilityId())).get("ITEM_IMAGE_CATLG_PATH")));

	String []parameters = {bean.checkForNull(request.getParameter("item_code")),bean.getLoginFacilityId()};
	String img_file_name = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_IMAGE_FILE_NAME_SELECT"),parameters)).get("FILE_NAME"));
	//Added ends
	
	/* Initialize Function specific end */
	if (bean.isCSSDModuleInstalled())
	{
		sterile_status				=		"enabled";
	}
	else
	{
		sterile_status				=		"disabled";
	}	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		or_status					=		bean.getDrugStatusInOR((String)request.getParameter("item_code"));
		codeDisabled				=		"disabled";
		currsuppdesc				=		bean.checkForNull(request.getParameter("currsuppdesc"));

		bean.setItemCode(request.getParameter("item_code"));
		String qty_on_hand = ((String)bean.fetchRecord("SELECT NVL(SUM (QTY_ON_HAND),0) QTY_ON_HAND FROM ST_ITEM_BATCH WHERE ITEM_CODE=?",new String[]{bean.getItemCode()}).get("QTY_ON_HAND"));
	    //String consiment_tr;
		if(qty_on_hand.equals("0"))
		{
		consiment_tr="Y";
		}else
         consiment_tr="N";  
	
		m_ps_item_yn				=		bean.checkForNull(request.getParameter("m_ps_item_yn"));
		m_sole_source_yn			=		bean.checkForNull(request.getParameter("m_sole_source_yn"));		
		if(m_sole_source_yn.equals("Y"))
			m_manufacturer_id		=		request.getParameter("m_manufacturer_id");
		m_gen_uom_desc				=		bean.checkForNull(request.getParameter("m_gen_uom_code"));
		m_gen_uom_code				=		bean.checkForNull(request.getParameter("m_gen_uom"));
		long_desc					=		bean.checkForNull(request.getParameter("long_desc"));
	    	
        bean.loadData() ;
	if(!currsuppdesc.equals(""))
	{
		m_long_desc					=		bean.getsuppdesc(request.getParameter("item_code"));
	
	}else
	{	
		m_long_desc					=		"";
	
	}
		modify_disabled				=		"disabled";
		codeDisabled				=		"disabled";
		if (!bean.fetchRecord(bean.getStRepositoryValue( "SQL_ST_BATCH_CONTROL_SELECT_COUNT"),bean.getItemCode()).get("TOTAL").toString().equals("0")) {
			batch_id_disabled		=		"disabled";
		}
		if (bean.isCSSDModuleInstalled())
			{
				if(bean.getAutoclaveableYn().equals("Y"))
				sterile_disabled	=		"enabled";
			}else
			{
				sterile_disabled	=		"disabled";
	           special_req_item_value = bean.checkForNull(bean.getSpecialItemYn(),"N");
	           //String special_req_item_chk;
			if((bean.getSpecialItemYn()).equals("Y")){
				special_req_item_chk =		"checked";
			}else{
				special_req_item_chk =		"";
			}
		if(bean.getDrugYn().equals("N") && bean.getMedicalYn().equals("Y")){
			visible = "visibility:visible";
			promptAlertDisabled = "";
		}
      }
}else{
	bean.setReorderableYn("Y");
	bean.setAppforconYn("Y"); 
	}

	item_instruction_site = bean.getItemInstructionSiteSpecific();  //TH-KW-CRF-0039
 

 
%>
<form name="formItemHeader" id="formItemHeader">
	<table border="0" cellpadding="2" cellspacing="0" width='100%'  >
		<tr>
			<td width='6%'  class="label" nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<input type="hidden" name="item_desc" id="item_desc" value="">
			<td  class="fields" wrap>&nbsp;&nbsp;<input type="text" value="<%=bean.getItemCode()%>" name="item_code" size="20" maxLength="20" class="UPPER" onKeyPress="return KeyPressSpecCharsItemCode(event);" onBlur="getItemDetails(document);" <%=codeDisabled%>><input type='button' class='BUTTON' value='?' onClick='checkMMInstParam(item_code,item_desc);' name="item_search" id="item_search">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'>&nbsp;</img><b id="td_short_desc" title="<%=m_long_desc%>"><%=bean.checkForNull(request.getParameter("item_name"))%></b>
			&nbsp;&nbsp;
			</td>
			
		</tr>
	</table>
	<table border="0" cellpadding="3" cellspacing="0" width='100%' height='35px' >
		<tr>
			<td   class="fields" id="td_ps_item_yn">&nbsp;&nbsp;<input type="hidden" value="" name="ps_item_yn" id="ps_item_yn"></td>
			<td   class="label" id="td_sole_source_yn">
			</td>
			<td   class="label" id="td_trade_id_applicable_yn" >&nbsp;&nbsp;
			</td>
			<td   class="label" id="td_gen_uom_code">&nbsp;&nbsp;
			</td>
			<td   class="label" id="td_manufacturer">&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='98%'  >
		<tr>
			<td width='10%'  class="label"><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></td>
			<td   class="fields" width='5%'>&nbsp;&nbsp; <input type="checkbox" value="Y" name="medical_item_yn" id="medical_item_yn" <%=bean.getMedicalYn().equals("Y")?"checked":""%> <%=modify_disabled%> onClick="return changeDrug();"> 
			</td> 
	<%	
		if(mode.equals("1")) {
	%>
			<td width='5%'  class="label">
				<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
			</td>
			<td class="fields" width='5%'>
				&nbsp;&nbsp;
				<input type="checkbox" value="Y" name="drug_item_yn" id="drug_item_yn" <%=drug_disabled%> onclick="changeExpiry();" <%=bean.getDrugYn().equals("Y")?"checked":""%>>
			</td>
	<%	
		} 
		else {
	        
	%>
           <td width='5%'  class="label">
				<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
		   </td>
		   <td class="fields" width='5%'>
				&nbsp;&nbsp;
				<input type="checkbox" value="Y" name="drug_item_yn" id="drug_item_yn" <%=bean.getDrugYn().equals("Y")?"checked":""%> <%=modify_disabled%>>
		   </td><% 
		}  
	%>
			<td width='5%'  class="label">
				<fmt:message key="Common.Expiry.label" bundle="${common_labels}"/>
			</td>
			<td  class="fields" width='5%'>
				&nbsp;
				<input type="checkbox" value="Y" name="expiry_yn" id="expiry_yn" onclick="changeUseAfterExpiry()" <%=bean.getExpiryYn().equals("Y")?"checked":""%>>
			</td>
			<td  width='8%'  class="label"><fmt:message key="eST.UseAfterExpiry.label" bundle="${st_labels}"/></td>
			<td  class="fields">&nbsp;&nbsp;<input type="checkbox" value="Y" name="use_after_expiry_yn" id="use_after_expiry_yn"  <%=bean.getUseAfterExpiryYn().equals("Y")?"checked":""%> <%=Expiry_disabled%>>
			</td>
		</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='92%'  >
		<tr>
	<%	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
			<td width='12%'   class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
			<td  width='25%'  class="fields" >&nbsp;&nbsp;<select name="batch_id_applicable_yn" id="batch_id_applicable_yn" style="width:154px" <%=batch_id_disabled%> ><%=bean.getBatchIDList()%></select>&nbsp;&nbsp;&nbsp;
			</td>
	<%	}
		else
		{%>
			<td width='12%'   class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
						<td  width='17%'  class="fields" >&nbsp;&nbsp;<select name="batch_id_applicable_yn" id="batch_id_applicable_yn" style="width:154px" <%=modify_disabled%> ><%=bean.getBatchID()%></select>&nbsp;&nbsp;&nbsp;
			</td>
	<%	}%>
<!-- /**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Making issue_ing_qty_yn as hidden and changing the Legend Name to Allow Delimal Qty
	*/
 -->
<%if((bean.getDispDecimalDtlsYN()).equals("Y")){%>
			<td  width='22%'  class="label">
			<!-- <fmt:message key="eST.IssueIntegerQuantity.label" bundle="${st_labels}"/> --> 
			Allow Decimal Qty
			</td>
			<td  class="fields">&nbsp;&nbsp;
				<input type="hidden" value="Y" name="issue_int_qty_yn" id="issue_int_qty_yn"  <%=bean.getIssueQtyYn().equals("Y")?"checked":""%> >
				<input type="checkbox" value="Y" name="allow_decimals_yn" id="allow_decimals_yn"  <%=bean.getAllow_decimals_yn().equals("Y")?"checked":""%> <%=bean.getAllow_decimals_yn().equals("Y")?"disabled":""%>>
			</td>
<%}else{%>
			<td  width='30%'  class="label">&nbsp;</td>
<%}%>
			</td>
 
			<% if(item_instruction_site) { %>
				<td  width='10%' class="label" ><fmt:message key="eST.ItemInstruction.label" bundle="${st_labels}"/></td>
				<td  width='5%' class="label" nowrap><textarea name="item_instruction" rows="2" cols="20" onKeyPress="checkMaxLimit(this,120);" onBlur="SPCheckMaxLen('Item Remarks',this,120);"><%=bean.checkForNull(bean.getItemInstruction())%></textarea> </td> <!-- Added for TH-KW-CRF-0039 -->

			<% }  else { %> <!--SKR-SCF-1715, to display --> 
				<td  width='10%' class="label" >&nbsp;</td>	
				<td  width='5%' class="label" >&nbsp;</td>	
			<%	} %> 	 
			<td width='10%'  class="label">
				<fmt:message key="eST.LabelRequired.label" bundle="${st_labels}"/>
			</td>
			<td  class="fields" width='5%'>
				&nbsp;
				<input type="checkbox" value="Y" name="label_reqd_yn" id="label_reqd_yn" <%=bean.getLabelYn().equals("Y")?"checked":""%>>
			</td>
			
		</tr>
		</table>
<table border="0" cellpadding="0" cellspacing="0" width='100%' >
		<tr>
		<td  width='18%'  class="label"><fmt:message key="eST.SpecialReqItem.label" bundle="${st_labels}"/></td>
		<td  class="fields">&nbsp;<input type="checkbox" value="<%=special_req_item_value%>" name='special_req_item' <%=special_req_item_chk%> onClick='setSpecialItemValue()'>
		</td>
		<td  class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>
		<td class="label"><fmt:message key="eST.PromptAlertforPreferredItem.label" bundle="${st_labels}"/></td>
			<td  class="label"><input type="checkbox" value="Y" name='prompt_alert_yn' id='prompt_alert_yn' <%=bean.getPromptAlertYn().equals("Y")?"checked":""%> <%=promptAlertDisabled%>><td>
			
			<td  class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>
			
			<td  class="label">&nbsp;<fmt:message key="eST.FractionalUOM.label" bundle="${st_labels}"/></td>&nbsp;</td>
			<td  class="fields" ><select name="repacking_uom" id="repacking_uom" >
		<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) { 
				%>
				  <%=bean.getRepackingUOM(m_gen_uom_code)%> 
					<%}else
				{%>
				<option>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%}%>
				</select>				
				</td>
		</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="1" width='100%'>
	</table>
	<table border="0" cellpadding="1" cellspacing="0" width='100%'>
			<tr>
				<td width='17%'  class="label" ><fmt:message key="eST.ManufacturingItem.label" bundle="${st_labels}"/></td>
				<td width='19%'  class="fields">&nbsp;<input type='checkbox' name="mfg_item_yn" id="mfg_item_yn" value="Y" 
				<%=bean.getMfgYn().equals("Y")?"checked":""%>></td>
			<%	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )) {%>
				<td  width='10%'  class="label"><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/>&nbsp;</td>
				<td width='47%' class="fields"  colspan='3' ><input type='text' name="drug_desc" id="drug_desc" value=""  size='42' maxLength='60' onblur="CheckForValidDrug();" disabled><input type='button' class='BUTTON' value='?' onClick='callDrugSearch()' name="drug_search" id="drug_search" disabled>&nbsp;</td>
			<%}else{%>
					 <td  width='10%'  class="label"  ></td>
					<td width='47%'  colspan='3' >&nbsp;&nbsp;</td>
			<%}%>
			</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' >
			<tr>
				<td width='18%'  class="label" colspan='2' nowrap><fmt:message key="eST.PhyInventoryType.label" bundle="${st_labels}"/></td></td><td class=fields>&nbsp;<input type='text' name="phy_inv_type" id="phy_inv_type"   onblur="checkSpecialChars(this);" value="<%=bean.checkForNull(bean.getPhyInvType())%>" size='4' maxLength='4'  ></td>
				<td  width='21%'  class="label" nowrap><fmt:message key="eST.PhyCountPerYear.label" bundle="${st_labels}"/></td><td class=fields>&nbsp;<select name="phy_inv_count_per_year" id="phy_inv_count_per_year" ><%=bean.getCountPerYear()%></select></td>
				<td  width='21%'  class="label" colspan ="2" >&nbsp;<fmt:message key="eST.RepackGroup.label" bundle="${st_labels}"/>&nbsp; </td>
				<td  class="fields"><select name="repacking_unit" id="repacking_unit"  ><%=bean.getRepackingGroup()%></select></td>
				</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  >
			<th ><fmt:message key="eST.SalesAttributes.label" bundle="${st_labels}"/></th>
	</table>
	<table border="0" cellpadding="1" cellspacing="0" width='100%'  >
			<tr>
				<td  width='18%'  class="label" ><fmt:message key="eST.SaleUOM.label" bundle="${st_labels}"/></td>
				<td width='57%'  class="fields" >&nbsp;&nbsp;<select name="sale_uom" id="sale_uom" onChange="getUOMConvertionFactor();">
				<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) { 
				%>
				<%=bean.getAM_Uom_List()%>
				<%}else
				{%>
				<option>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%}%>
				</select>&nbsp;&nbsp;<b id="td_sale_stk_uom_conv"></b>
				</td>
				<td  class="label" ><fmt:message key="eST.MinSalesQuantity.label" bundle="${st_labels}"/></td>
				<td  class="fields" >&nbsp;&nbsp<input type="text" value="<%if(bean.getMinSaleQty()==0) out.println("");else out.println(bean.getMinSaleQty());%>" name="min_sale_qty" maxLength="6" size="6" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" ></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.Refundallowed.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;<input type="checkbox" value="Y" name="refund_allow_yn" id="refund_allow_yn" <%=bean.getRefundYn().equals("Y")?"checked":""%> ></td>
				<td  class="label"><fmt:message key="eST.ReturnAllowed.label" bundle="${st_labels}"/></td>
				<td  class="fields" >&nbsp;<input type="checkbox" value="Y" name="return_allowed_yn" id="return_allowed_yn" <%=bean.getChecked(bean.getReturnYn())%> ></td>
			</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  >
			<th  ><fmt:message key="eST.OtherAttributes.label" bundle="${st_labels}"/></th>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  >
			<tr>
				<td width='18%'  class="label"><fmt:message key="eST.Sterilizable.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;<input type='checkbox' name="autoclaveable_yn" id="autoclaveable_yn" value="Y" onClick="changeSterile();" <%=bean.getAutoclaveableYn().equals("Y")?"checked":""%>></td>
				<td  width='11%'  class="label" ><fmt:message key="Common.SterileType.label" bundle="${common_labels}"/></td>
				<td   class="fields">&nbsp;&nbsp;<input type='text' name="sterile_type" id="sterile_type"  value="<%=bean.checkForNull(bean.getSterileType())%>" size="15" maxlength="15" <%=sterile_disabled%> readonly ><input type='button' class='BUTTON' value='?' onClick='searchSterile(sterile_type,sterile_desc);' name="sterile_search" id="sterile_search"  <%=sterile_disabled%> ><input type='hidden' value=''  name="sterile_desc" id="sterile_desc" ></td>
				<td   class="label"><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/></td>
				<td    class="fields">&nbsp;&nbsp<select name="abc_class_code" id="abc_class_code" >
				<%=bean.getABCAnalysis()%></select></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></td>
				<td  class="fields"  >&nbsp;&nbsp;<select style="width:110px" name="machine_code" id="machine_code" <%=Man_Part_status%>>
				<%=bean.getMachine()%>
				</select></td>
				<td  class="label" ><fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></td></td>
				<td  class="fields" colspan="3">&nbsp;&nbsp;<input type='text' name="spare_part_id" id="spare_part_id"  value="<%=bean.checkForNull(bean.getSparePartId())%>" size='30' maxLength='30'  <%=Man_Part_status%> ></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></td></td>
				<td  class="fields">&nbsp;<input type="checkbox" value="Y" name="consignment_item_yn" id="consignment_item_yn" <%=bean.getConsignmentYn().equals("Y")?"checked":""%>  onclick="return validteChange();"></td>
				<td  class="label" ><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/></td>
				<td  class="fields">&nbsp;<input type='checkbox' name="insurance_item_yn" id="insurance_item_yn"  value="Y" <%=bean.getInsuranceYn().equals("Y")?"checked":""%> ></td>
				<td  class="label"><fmt:message key="eST.CurrentPackSize.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type="text" value="<%if(bean.getCurrPackSize()==0) out.println("");else out.println(bean.getCurrPackSize());%>" name="curr_pack_size"  size='6' maxLength='6' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" >
				</td>
			</tr>
			<tr>
				<td  class="label" >
				<%if(!(img_file_name.equals(""))){%>
					<a href="javascript:showImage('<%=img_file_name%>');">
				<%}%>
				<fmt:message key="eST.ItemImageCatalogue.label" bundle="${st_labels}"/></a></td>
				<!--<td  class="fields" id="td_filepath" style="<%=visible%>">&nbsp;<input type="text" value="<%=bean.getImgFileName()%>" name="image_file_name"  size='25' maxLength='200' onchange="dispImageFile(formItemHeader,this);"></td>-->
			</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  >
			<th  ><fmt:message key="eST.ReorderAttributes.label" bundle="${st_labels}"/></th>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
				<td width='19%'  class="label"><fmt:message key="eST.Reorderable.label" bundle="${st_labels}"/></td>
				<td width='20%'  class="fields">&nbsp;<input type='checkbox' name="re_orderable_yn" id="re_orderable_yn" value="Y" <%=bean.getReorderableYn().equals("Y")?"checked":""%> ></td>
				<td   class="label" ><fmt:message key="eST.MinStockLevel.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='text' name="min_stk_qty" id="min_stk_qty"  value="<%if(bean.getMinStkQty()==0) out.println("");else out.println(bean.getMinStkQty());%>" size='12' maxLength='9' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" ></td>
				<td   class="label" ><fmt:message key="eST.MaxStockLevel.label" bundle="${st_labels}"/></td>
				<td   width='11%'  class="fields">&nbsp;&nbsp;<input type='text' name="max_stk_qty" id="max_stk_qty"  value="<%if(bean.getMaxStkQty()==0) out.println("");else out.println(bean.getMaxStkQty());%>" size='12' maxLength='9' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER"  >&nbsp;</td>
			</tr>
			<tr>
				<td   class="label" ><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></td>
				<td   class="fields">&nbsp;&nbsp;<input type='text' name="reorder_level" id="reorder_level"  value="<%if(bean.getReorderLevel()==0) out.println("");else out.println(bean.getReorderLevel());%>" size='12' maxLength='9' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" ></td>
				<td  class="label"><fmt:message key="eST.ReorderQuantity.label" bundle="${st_labels}"/></td>
				<td  class="fields" colspan="3">&nbsp;&nbsp;<input type='text' name="reorder_qty" id="reorder_qty"  value="<%if(bean.getReorderQty()==0) out.println("");else out.println(bean.getReorderQty());%>" size='12' maxLength='9' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" >
				</td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.LeadDays.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type="text" value="<%if(bean.getLeadDays() ==0) out.println("");else out.println(bean.getLeadDays());%>" name="lead_days" size='4' maxLength='4' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" ></td>
				<td  class="label" ><fmt:message key="eST.MinStockDays.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type='text' name="min_stock_days" id="min_stock_days"  value="<%if(bean.getMinStockDays()==0) out.println("");else out.println(bean.getMinStockDays());%>" size='4' maxLength='4' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" ></td>
				<td  class="label"><fmt:message key="eST.BufferPercentage.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.checkForNull(bean.getBufferPerc())%>" name="buffer_perc"  size='5' maxLength='5' onkeypress="return isValidNumber(this,event,3,2);" class="NUMBER" onBlur="return checkDoubleFormat(this);" >
				</td>
			</tr>
	</table>
	<!--Added by Rabbani, #inc no:30127 on 09/01/12 -->
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  >
			<th ><fmt:message key="eST.InterfaceAttributes.label" bundle="${st_labels}"/></th>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
				<!--<td width='19%'  class="label"><fmt:message key="eST.ApplicableforConsumption.label" bundle="${st_labels}"/></td>-->
				<td width='19%'  class="label"><fmt:message key="eST.InterfaceToThirdParty.label" bundle="${st_labels}"/></td>
				<td  class="fields">&nbsp;<input type='checkbox' name="appl_for_cons" id="appl_for_cons" value="Y" <%=bean.checkForNull(bean.getAppforconYn()).equals("Y")?"checked":""%> ></td>
	</tr>
	</table>
	
	<br>
	<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"					value="<%= bean_name %>">
	<input type="hidden" name="language_id" id="language_id"					value="<%= locale %>">
	<input type="hidden" name="function_id" id="function_id"					value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="SQL_ST_ITEM_SELECT_SINGLE" id="SQL_ST_ITEM_SELECT_SINGLE"	value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_SINGLE_LOOKUP")%>">
	<input type="hidden" name="SQL_ST_ITEM_SELECT_INV_P" id="SQL_ST_ITEM_SELECT_INV_P" 	value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_INV_P_LOOKUP")%>" >
	<input type="hidden" name="SQL_ST_STERILE_SELECT" id="SQL_ST_STERILE_SELECT"		value="<%=bean.getStRepositoryValue("SQL_ST_STERILE_SELECT")%>">
	<input type="hidden" name="sterile_status" id="sterile_status"				value="<%=sterile_status%>">
	<input type="hidden" name="trade_id_applicable_yn" id="trade_id_applicable_yn"		value="" >
	<input type="hidden" name="item_gen_uom_code" id="item_gen_uom_code"			value="<%=m_gen_uom_code%>" >
	<input type="hidden" name="item_gen_uom_desc" id="item_gen_uom_desc"			value="<%=m_gen_uom_desc%>" >
	<input type='hidden' name="drug_code" id="drug_code"					value="" >
	<input type='hidden' name="drug_item_indicator" id="drug_item_indicator"			value="" >
	<input type='hidden' name="drug_code_can_be_enabled" id="drug_code_can_be_enabled"	value="false" >
	<input type='hidden' name="long_desc" id="long_desc"					value="<%=long_desc%>" >
	<input type="hidden" name="or_status" id="or_status"					value="<%=or_status%>">
	<input type="hidden" name="img_path" id="img_path"					value="<%=img_path%>">
	<input type="hidden" name="consiment_tr" id="consiment_tr"					value="<%=consiment_tr%>">
<%
if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))
{	%>
		<script>
	
		document.getElementById('td_gen_uom_code').innerHTML		=		getLabel("Common.StockUOM.label","Common")+"<b > <%=m_gen_uom_desc%></b>";
		var m_gen_uom_code							=		'<%=m_gen_uom_code%>';
		var sale_uom								=		document.formItemHeader.sale_uom.value;
		if(sale_uom==m_gen_uom_code)
		{
			document.getElementById('td_sale_stk_uom_conv').innerText	=		getLabel("Common.ConversionFactor.label","MM")+"  1";
		}
		</script>
	<%
		if(m_ps_item_yn.equals("Y"))
		{
			%>
			<script>
				
			document.getElementById('td_ps_item_yn').innerHTML			=		getLabel("eMM.PharmacyStockItem.label","MM")+"<img align='center' src='../../eCommon/images/enabled.gif'></img>";
			document.formItemHeader.machine_code.disabled	=		true;
			var drug_item									=		"<%=bean.getDrugYn()%>";
			var medical_item								=		"<%=bean.getMedicalYn()%>";
			if(drug_item=="Y")
			{
				document.formItemHeader.spare_part_id.disabled	=		true;
			}
			else
			{
				document.formItemHeader.spare_part_id.disabled	=		false;
			}
			if(medical_item=="Y")
			{
				document.formItemHeader.machine_code.disabled	=		true;
			}
			else
			{
				document.formItemHeader.machine_code.disabled	=		false;
			}
			document.formItemHeader.medical_item_yn.checked		=		true;
			document.formItemHeader.medical_item_yn.disabled	=		true;
			document.formItemHeader.drug_item_yn.disabled		=		false;
			</script>
<%		}
		else
		{
			%>
			<script>
				
			document.getElementById('td_ps_item_yn').innerHTML				=		getLabel("eMM.PharmacyStockItem.label","MM")+"<img align='center' src='../../eCommon/images/disabled.gif'></img>";
			var drug_item										=		"<%=bean.getDrugYn()%>";
			var medical_item									=		"<%=bean.getMedicalYn()%>";
			if(drug_item=="Y")
			{
			document.formItemHeader.spare_part_id.disabled		=		true;
			}
			else
			{
				document.formItemHeader.spare_part_id.disabled	=		false;
			}
			if(medical_item=="Y")
			{
				document.formItemHeader.machine_code.disabled	=		true;
			}
			else
			{
				document.formItemHeader.machine_code.disabled	=		false;
			}
			</script>
		<%}
			if(m_sole_source_yn.equals("Y"))
		{
			%>
			<script>
			
			document.getElementById('td_sole_source_yn').innerHTML			=		"&nbsp;"+getLabel("Common.SoleSource.label","MM") +"<img align='center' src='../../eCommon/images/enabled.gif'></img>";
			document.getElementById('td_trade_id_applicable_yn').innerHTML	=		getLabel("Common.Trade.label","Common")+"<img align='center' src='../../eCommon/images/disabled.gif'></img>";
			document.getElementById('td_manufacturer').innerHTML				=		getLabel("Common.Manufacturer.label","MM")+" <b><%=m_manufacturer_id%></b>";
			</script>
<%		}
		else
		{
%>
			<script>

				document.getElementById('td_sole_source_yn').innerHTML				=		"&nbsp;"+getLabel("Common.SoleSource.label","MM") +" <img align='center' src='../../eCommon/images/disabled.gif'></img>";
				document.formItemHeader.mfg_item_yn.disabled			=		true;
				document.getElementById('td_trade_id_applicable_yn').innerHTML		=		getLabel("Common.Trade.label","Common") +"<img align='center' src='../../eCommon/images/enabled.gif'></img>";
				document.formItemHeader.trade_id_applicable_yn.value	=		"Y";
			</script>
<%
		}
		if(modify_disabled.equals("disabled")) {
%>
			<script>
			document.formItemHeader.drug_item_yn.disabled=true;
			document.formItemHeader.expiry_yn.disabled=true;
			if(document.formItemHeader.expiry_yn.checked==true)
			document.formItemHeader.use_after_expiry_yn.disabled=false;
			else
            document.formItemHeader.use_after_expiry_yn.disabled=true;  
			document.formItemHeader.mfg_item_yn.disabled=true;
			</script>
<%					 
		}			 
	}
%>

<script>//changeUseAfterExpiry();</script>

</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
<%! 
public static String HTMLencode(String desc){
		
		StringBuffer item_desc = new StringBuffer(desc.trim()); 
		for (int i=0; i<item_desc.length(); ++i) {
            char c = item_desc.charAt(i);
            if (c == '<') {
                item_desc.replace(i,i+1,"&lt;");
                i += 3;
            } else if (c == '>') {
                item_desc.replace(i,i+1,"&gt;");
                i += 3;
            } else if (c == '\"') {
                item_desc.replace(i,i+1,"&quot;");
                i += 5;
            }else if(c=='\''){
		               item_desc.replace(i,i+1,"&#039");
                i += 5;
						  
		    }else if(c=='`') {
				item_desc.replace(i,i+1,"&#096;");
			  i+=5;
			}
        }
		return item_desc.toString();
		}
%>
</body>
</html>

