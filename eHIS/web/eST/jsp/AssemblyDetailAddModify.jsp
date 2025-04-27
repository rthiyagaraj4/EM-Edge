<%@ page import ="eST.AssemblyDetailBean,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="AssemblyDtlList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
<head>
	
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language='javascript' src='../../eCommon/js/common.js'></script> 
		 <script language='javascript' src='../../eST/js/AssemblyDetail.js'></script>
		 <script language='javascript' src='../../eST/js/StCommon.js'></script>
		 <script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <script>
 function checkPositiveNumber(obj) {  
   var  obj_value			=	"";
		obj_value			=	obj.value;    // checks for positive number greater than zero
	var obj_length			=	obj_value.length;

    var zero				=	obj_value.charAt(0);
   if(zero=="0")
	{
   		obj_value			=	obj_value.charAt(obj_value.length-1)
		document.AddModify_Frame.Seqence_No.value = obj_value;
	}
 	if(obj.value == ""){
		return true;
	}
	if(obj != null ){

		if(obj_value > 0){
			return true;
		}else{
			//alert("only allow numbers");
			obj.value= ""
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
	
}

 </script>
</head>
<%
	String bean_id								=		"AssemblyDetailBean";
	String bean_name							=		"eST.AssemblyDetailBean";
	String disable								=		"";
	String Manufactur							=		"";
	HashMap hmRecord							=		new HashMap();

	AssemblyDetailBean bean						=		(AssemblyDetailBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.clear();
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String default_value						=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	ArrayList ManufacturInstructionsList		=		new ArrayList();
    HashMap ManufacturInstructionsMap			=		new HashMap();
	ManufacturInstructionsList					=		bean.ManufacturingInstructions();
	String index								=		bean.checkForNull(request.getParameter("index"),"-1");

	
//	String legend								=		" Add ";
	String legend								=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	ArrayList recordSet							=		new ArrayList();
	recordSet									=		AssemblyDtlList;

	
	String mode									=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	String uom_code								=		"";
	String SEQ_NO								=		"";
	String PRINT_ON_LABEL_YN					=		"";
	String INSTRN_CODE							=		"";
	String INSTRN_CODE1							=		"";
	String instrn_code							=		"";
	String instrn_text							=		"";
	String MFG_DESC								=		"";
	String stk_uom								=		"";
	String allow_deci_yn                        =       "";
	int no_deci                                 =       bean.getNoOfDecimals();
	String item_code                            =    "";
	String printlabel                           =    "Y";
	String component_yn                         =     "Y";
	String cheked			                    =	  "";
	String cheked1			                    =	  "";
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){

	disable										=		"disabled";
	recordSet									=		bean.getDataModifyList();
	
	}

	if(!index.equals("-1")){
		//legend								=		" Modify ";
	    legend									=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		hmRecord								=		(HashMap)	recordSet.get(Integer.parseInt(index));

		bean.setChild_item_code(bean.checkForNull((String)hmRecord.get("CHILD_ITEM_CODE")));
		bean.setShort_desc(bean.checkForNull((String)hmRecord.get("SHORT_DESC")));
		bean.setComponent_qty(bean.checkForNull((String)hmRecord.get("COMPONENT_QTY")));
		bean.setComponent(bean.checkForNull((String)hmRecord.get("COMPONENT")));
		bean.setMfg_uom(bean.checkForNull((String)hmRecord.get("MFG_UOM_CODE")));
		bean.setMandatory(bean.checkForNull((String)hmRecord.get("MANDATORY")));
		bean.setStock_uom(bean.checkForNull((String)hmRecord.get("STOCK_UOM")));
		bean.setConv_factor(bean.checkForNull((String)hmRecord.get("CONV_FACTOR")));
		bean.setTd_sale_stk_uom_conv_rule(bean.checkForNull((String)hmRecord.get("TD_SALE_STK_UOM_CONV_RULE")));
		
		//30/11/2012
		 component_yn  =  bean.checkForNull(bean.getComponent());
		if(bean.checkForNull(((String)hmRecord.get("PRINTONLABEL"))).equals(""))
		 printlabel =  bean.checkForNull((String)hmRecord.get("PRINT_ON_LABEL_YN"));
		else
	     printlabel =  bean.checkForNull((String)hmRecord.get("PRINTONLABEL"));
	   
		uom_code								=		bean.checkForNull((String)hmRecord.get("UOM_CODE"));
		stk_uom									=		bean.checkForNull((String)hmRecord.get("STOCK_UOM"));
		Manufactur								=		bean.checkForNull((String)hmRecord.get("Manufactur"));
		INSTRN_CODE								=		bean.checkForNull((String)hmRecord.get("INSTRN_CODE"));
		MFG_DESC								=		bean.checkForNull((String)hmRecord.get("MFG_DESC"));
		allow_deci_yn								=		bean.checkForNull((String)hmRecord.get("ALLOW_DECI_YN"));
		item_code = bean.checkForNull((String)bean.getChild_item_code()) ;
		allow_deci_yn        =       bean.getAllowDecimalsYN(bean.getChild_item_code());
            if(allow_deci_yn.equals("N"))
			no_deci              =0;
		
		if(legend.equals("Modify"))
		{
          INSTRN_CODE1							=		Manufactur;
		}

		PRINT_ON_LABEL_YN						=		bean.checkForNull((String)hmRecord.get("PRINT_ON_LABEL_YN"));
		SEQ_NO									=		bean.checkForNull((String)hmRecord.get("SEQ_NO"));
		}
	else
		disable								=		"";
		
		if(printlabel.equals("Y")){
		cheked			=		"checked";
		}
		if(component_yn.equals("Y")){
		cheked1			=		"checked";
		}
	%>
	<body onMouseDown="CodeArrest()">
		<form name='AddModify_Frame' id='AddModify_Frame' method='post' >
		<center>
			<table border=0 cellpadding=1 cellspacing=0 width='100%' align=center>
			<tr>
				<td colspan=4>&nbsp;</td>
				<td   class="label"></td>
				<td   class="label"></td>
				<td   class="label"></td>
				<td   class="label"></td>
				<td   class="label"></td>
				<td   class="label"></td>
				<td   class="label"></td>
				<td   class="label"></td>
			</tr>
			<tr>
				<td  class="label" width='5%' nowrap>&nbsp;&nbsp;<fmt:message key="eST.Ingredients.label" bundle="${st_labels}"/></td>
			
				<td   class='fields' >&nbsp;<input type='text' size=70  maxlength=60 name='child_item_code_desc' id='child_item_code_desc'   value="<%=bean.checkForNull(bean.getShort_desc())%>"  <%=disable%> ><input type=button name='searchitem' id='searchitem' value="?" class='Button' <%=disable%> onClick="callItemSearchScreen(child_item_code_desc,document.forms[0]);" >&nbsp;&nbsp;&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
			
				<td >&nbsp;</td>
				
				
				<td >&nbsp;</td>
				<td  id="stock_uom" class="QUERYDATA" nowrap> <%=bean.checkForNull(bean.getStock_uom(),"&nbsp;")%></td>
				<td colspan=7>&nbsp;</td>
				</tr><tr>
				
				<td  class="label"  nowrap>&nbsp;
				<fmt:message key="eST.MfgInstructions.label" bundle="${st_labels}"/></td>
				<td class="label">
				<select name="Manufactur" id="Manufactur">
	            <OPTION value=""selected>&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- &nbsp;</OPTION>
				<% for(int i=0; i<ManufacturInstructionsList.size(); i++)
				{
					ManufacturInstructionsMap	= (HashMap)ManufacturInstructionsList.get(i);
					instrn_code					= (String)ManufacturInstructionsMap.get("instrn_code");
					instrn_text					= (String)ManufacturInstructionsMap.get("instrn_text");
				
				
				 if((instrn_code.equals(INSTRN_CODE.trim()))&&(mode.equals("2")))
				 {%>
			   <OPTION value="<%=INSTRN_CODE%>"selected ><%=instrn_text%></OPTION><%}
			  
				else if((instrn_code.equals(Manufactur.trim()))&&(mode.equals("1")))
				{%>
			   <OPTION value="<%=Manufactur%>"selected><%=instrn_text%></OPTION>
			   <%}
               
		else if((instrn_code.equals(INSTRN_CODE1.trim()))&&(mode.equals("2"))&&(legend.equals("Modify")))
				{%>
			   <OPTION value="<%=INSTRN_CODE1%>"selected><%=instrn_text%></OPTION>
			   <%}


			   else{%>
			   <OPTION value="<%=instrn_code%>"><%=instrn_text%></OPTION>
			   <%}
			}
			%>
			</SELECT>
		        </TD>
				<td   colspan = 10 class="label"></td>
			</tr>
			</table>
			<table border=0 cellpadding=1 cellspacing=0 width='100%' align=center>
			<tr>
				<td  width='10%' class="label">&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
				<!-- 		
			* @Name - Priya
			* @Date - 12/02/2010
			* @Inc# - 19272
			* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called and maxlength is changed to 12.			
		-->
				<td class="fields"  width="15%">&nbsp;&nbsp;&nbsp;&nbsp;<input type='text'  onKeyPress="return isValidNumber(this,event,7,<%=no_deci%>);"  onBlur="checkDoubleFormat(this);"  name="component_qty" class="NUMBER" value="<%=bean.setNumber((String)bean.getComponent_qty(),no_deci)%>" size=12 maxlength=12>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
				
				<td  width="10%" class="label"><fmt:message key="eST.MFGUOM.label" bundle="${st_labels}"/></td>
				<td  class='fields'   width="23%">&nbsp;
<%
	if(!index.equals("-1")){
%>
			  <select name='mfg_uom' id='mfg_uom' onBlur="getUOMConvertionFactor();" ><%=bean.getPur_uom_code_Modify_List(uom_code)%></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
<%
}else{
%>				
			
			  <select name='mfg_uom' id='mfg_uom' onBlur="getUOMConvertionFactor();" ><%=default_value%></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
<%}%>			
			   
               <td  width="10%" class="label" nowrap ><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
               <td class="fields"  nowrap >&nbsp;<input type='text'  name="Seqence_No" id="Seqence_No"  value='<%=SEQ_NO%>' size=5 maxlength=2  onKeyPress="return CheckForSequence(event);" onblur="checkSeqNo(this);return checkPositiveNumber(this);"  >&nbsp;<img src='../../eCommon/images/mandatory.gif' >
			  <fmt:message key="eST.StockConvFactor.label" bundle="${st_labels}"/>&nbsp;
				<b id="td_sale_stk_uom_conv_rule"><%=bean.checkForNull(bean.getTd_sale_stk_uom_conv_rule(),"&nbsp;")%></b></td>
				<td  class="QUERYDATA" ><b id="td_sale_stk_uom_conv" STYLE="visibility:hidden"><%=bean.checkForNull(bean.getConv_factor(),"&nbsp;")%></b></td>
			
				</tr>



			<tr>
				<td   class="label" >&nbsp;<fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
				<!--<td  class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='component' id='component' checked  value="<%= bean.getComponent()%>"   <%=(bean.getComponent()).equals("Y")?"checked":""%> ></td> -->
				
				<td  class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='component' id='component'  value=""   <%=cheked1%> ></td> 
				
				<td   class="label" align="left" nowrap><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td>
				<td  class='fields' >&nbsp;<input type='checkbox' name='mandatory' id='mandatory'   value="<%= bean.getMandatory()%>"   <%= (bean.getMandatory()).equals("Y")?"checked":""%>>
				</td> 
				<td   class="label"  nowrap><fmt:message key="eST.PrintOnlabel.label" bundle="${st_labels}"/></td>
			    <!--<td  class='fields' nowrap>&nbsp;<input type='checkbox' name='PrintOnlabel' id='PrintOnlabel'   value="Y" checked > -->
				<td  class='fields' colspan="3">&nbsp;<input type='checkbox' name='PrintOnlabel' id='PrintOnlabel'   value="" <%=cheked%> > 
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=button name='add' id='add' value=" <%=legend%> " class='Button'  onClick="displayResult(<%=index%>);">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=reset name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancelData()"class='Button'>
				</td>
			</tr>
			<tr>
				<td colspan='6' >&nbsp;</td>
				<td colspan='6' >&nbsp;</td>
				
			</tr>
		</table>
		<input type=hidden name ="child_item_code"			value="<%=bean.checkForNull(bean.getChild_item_code())%>">
		<input type='hidden' name='bean_id' id='bean_id'					value="<%=bean_id%>" >
		<input type='hidden' name='bean_name' id='bean_name'				value="<%=bean_name%>" >
		<input type='hidden' name='mode' id='mode'					value='<%=mode%>'>
		<input type='hidden' name='uom_code' id='uom_code'				value="<%=uom_code%>">
		<input type='hidden' name='SEQ_NO' id='SEQ_NO'					value="<%=SEQ_NO%>">
		<input type='hidden' name='MFG_DESC' id='MFG_DESC'				value="<%=MFG_DESC%>">
		<input type='hidden' name='assembly_size' id='assembly_size'			value="<%=AssemblyDtlList.size()%>">
		<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>" >
	    <input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>" >
		<!-- 		
		* @Name - Priya
		* @Date - 12/02/2010
		* @Inc# - 19272
		* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	</center>
	</form>
<%
	if(((AssemblyDtlList.size()>0)||(legend.equals("Modify")))){
%>
		<script>
			populateMFGUoms();
		</script>
<%
	}
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>



