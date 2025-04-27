<!--<!DOCTYPE html>-->
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eST/js/ManufacturingRequest.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	//java.util.HashMap defaultParameter		=		null;
	String bean_id								=		"ManufacturingRequestBean";
	String bean_name							=		"eST.ManufacturingRequestBean";

	request.setCharacterEncoding("UTF-8");
	String locale								=		(String)session.getAttribute("LOCALE");
	

//	pmd 29/01/05
//	String disable								=		"";

	HashMap hmRecord=new HashMap();
	ManufacturingRequestBean bean				=		(ManufacturingRequestBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String index								=		bean.checkForNull(request.getParameter("index"),"-1");

	String seq_no								=		request.getParameter("seq_no");
		String allow_deci_yn        =       "";
	String no_deci              =       "";
//	String legend								=		" Add ";
	String legend								=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String disablefield							=		"";
	String disablefieldMod						=		"";
//	ArrayList dataList							=		new ArrayList();
	ArrayList recordSet							=		new ArrayList();
	recordSet									=		bean.getDataList();
	String mode									=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	String uom_code								=		"";

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	if(!index.equals("-1")){
		//legend								=		" Modify ";
        legend									=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		hmRecord								=		(HashMap)	recordSet.get(Integer.parseInt(index));

		bean.setChild_item_code(bean.checkForNull((String)hmRecord.get("CHILD_ITEM_CODE")));
		bean.setShort_desc(bean.checkForNull((String)hmRecord.get("SHORT_DESC")));
		bean.setComponent_qty(bean.checkForNull((String)hmRecord.get("COMPONENT_QTY")));
		bean.setMfg_uom(bean.checkForNull((String)hmRecord.get("MFG_UOM_CODE")));
		bean.setStock_uom(bean.checkForNull((String)hmRecord.get("STOCK_UOM")));
		uom_code=bean.checkForNull((String)hmRecord.get("UOM_CODE"));
         allow_deci_yn        =       bean.getAllowDecimalsYN(bean.getChild_item_code());
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";
		disablefield							=		"disabled";
		disablefieldMod							=		"";
		//disablefield							=		((String)hmRecord.get("DATATYPE")).equals("DB") ?"disabled":"";
	}
	else{
		bean.setChild_item_code("");
		bean.setShort_desc("");
		bean.setComponent_qty("");
		bean.setMfg_uom("");
		bean.setStock_uom("");

//		disable		="";
	}
	/**
		 * @Name - Priya
		 * @Date - 03/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and round up cost with noOfDecimalsForCost
		 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();

	%>
	<body onMouseDown="CodeArrest()">
		<form name='AddModify_Form' id='AddModify_Form' method='post' >
		<center>
			<table border=0 cellpadding=1 cellspacing=0 width='100%' align=center>
			<tr>
				<td colspan=5>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" width='10%' nowrap>&nbsp;&nbsp;<fmt:message key="eST.Ingredients.label" bundle="${st_labels}"/></td>
				<td  width='30%' class='fields'>&nbsp;<input type='text' size=70  maxlength=60 name='child_item_code_desc' id='child_item_code_desc'   value="<%=bean.checkForNull(bean.getShort_desc())%>"  <%=disablefield%> ><input type=button name='searchitem' id='searchitem' value="?" class='Button' <%=disablefield%> onClick="callItemSearchScreen(child_item_code_desc,document.forms[0]);">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
				<td  class="label" width='10%' nowrap><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/>&nbsp;</td>
				<td  id="stock_uom" class="QUERYDATA" ><%=bean.checkForNull(bean.getStock_uom(),"&nbsp;")%></td>
				<td  class="label" width='10%' nowrap>
			</select>
		        </TD>
				
			</tr>
			
			<tr>
				<td  width='10%' class="label">&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
				<td class="fields"  width="15%">&nbsp;<input type='text'  onKeyPress="allow_restrict_decimals1(this,event);"  onBlur="checkDoubleFormat(this,true); " name="component_qty" id="component_qty" class="NUMBER" <%=disablefieldMod%>  value="<%=bean.checkForNull(bean.getComponent_qty())%>" size=12 maxlength=11>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
				<td  width="10%" class="label"><fmt:message key="eST.MFGUOM.label" bundle="${st_labels}"/></td>
				<td   width="15%">&nbsp;<select name='mfg_uom' id='mfg_uom'  <%=disablefield%> ><%=bean.getMfgUom()%></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
				<td>&nbsp;</td>
		    </tr>
			<tr>
				<td  colspan=6 class='fields'><input type=button name='add' id='add' value=" <%=legend%> " class='Button'  onClick="displayResult('<%=index%>','<%=seq_no%>');"  disabled <%=disablefieldMod%>  >&nbsp;<input type=reset name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='Button'  onClick="cancelData('<%=index%>','<%=seq_no%>')">&nbsp;<input type=reset name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='Button'  onClick="closeWindow('<%=seq_no%>')">
				</td>
			</tr>
		</table>
		<input type=hidden name ="child_item_code"			value="<%=bean.checkForNull(bean.getChild_item_code())%>">
		<input type='hidden' name='bean_id' id='bean_id'					value="<%=bean_id%>" >
		<input type='hidden' name='bean_name' id='bean_name'				value="<%=bean_name%>" >
		<input type='hidden' name='mode' id='mode'					value='<%=mode%>'>
		<input type='hidden' name='store_code' id='store_code'				value='<%=bean.getReq_store()%>'>
		<input type='hidden' name='stock_item_yn' id='stock_item_yn' >
		<input type='hidden' name='uom_code' id='uom_code'				value="<%=uom_code%>">
		<input type='hidden' name='extemp_item_seq' id='extemp_item_seq'			value="<%=seq_no%>" >
		<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>" >
		<input type='hidden' name='dec_allowed_yn' id='dec_allowed_yn'		value="<%=allow_deci_yn%>" >
	    <input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>" >
	    <input type='hidden' name='no_of_decimals' id='no_of_decimals'		value="<%=no_deci%>" >
	 	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>

			<script>
				if('<%=index%>'!="-1")
				document.forms[0].add.disabled=false;
			</script>

	</center>
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>



