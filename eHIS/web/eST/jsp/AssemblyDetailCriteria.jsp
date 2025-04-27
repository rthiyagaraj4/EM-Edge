<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.AssemblyDetailBean,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language='javascript' src="../../eST/js/AssemblyDetail.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String bean_id				=		"AssemblyDetailBean";
	String bean_name			=		"eST.AssemblyDetailBean";
	String disable				=		"";
	String allow_deci_yn        =       "";

	AssemblyDetailBean bean		=		(AssemblyDetailBean) getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String index				=	bean.checkForNull(request.getParameter("index"),"-1");
	String mode					=	request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	ArrayList dataList			=	new ArrayList();
	ArrayList recordSet			=	new ArrayList();
	int no_deci              =       bean.getNoOfDecimals();
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	String desc					=		"";
	String uom					=		"";
	String bqty					=		"";
	String ploss				=		"";
	String item_code            =       "";
	String prep_type            =       "";
	String prep_mode            =       "";
	String label_type           =       "";
	String shelf_life_value		=		""; //Added for ML-MMOH-CRF-1909
	String shelf_life_flag		=		""; //Added for ML-MMOH-CRF-1909
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
	
			disable				=		"disabled";
			dataList			=		bean.getDataList();
			recordSet			=		(ArrayList) dataList.get(Integer.parseInt(index));
			desc				=		(String)recordSet.get(8);
			uom					=		(String)recordSet.get(9);
			bqty				=		(String)recordSet.get(1);
			ploss				=		(String)recordSet.get(4) ;
			item_code 		    =        bean.checkForNull((String)recordSet.get(0));
			prep_type           =        bean.checkForNull((String)recordSet.get(5));
			prep_mode           =        bean.checkForNull((String)recordSet.get(6));
			label_type          =        bean.checkForNull((String)recordSet.get(7));
			allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN((String)recordSet.get(0)),"N");
           	 if(bean.getAllowDecimalsYN(item_code).equals("N"))
			no_deci             =  0;
           	shelf_life_value	=		bean.checkForNull((String)recordSet.get(11)); //Added for ML-MMOH-CRF-1909
           	shelf_life_flag		=		bean.checkForNull((String)recordSet.get(12)); //Added for ML-MMOH-CRF-1909
		
	}
	//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
	String ACC_ENTITY_ID = "ZZ";
    HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID); 
     String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
     String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
     String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
     
      if(prep_prepack.equals("") && prep_standard.equals("") && prep_others.equals("") ){
    	 prep_prepack  = "Pre Packing";
         prep_standard = "Standard Formulary";
         prep_others   =  "Others";
     }
	%>
<body onMouseDown="CodeArrest()">
<form name="AssemblyDetail_form" id="AssemblyDetail_form" >
<div align="left">
<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
<tr>
	<td colspan=6 >&nbsp;</td>
</tr>
<tr >
	<td  class="label" align="left" > <fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td  class="fields"  colspan="3"><input type='text' size='70'  maxlength='60' name='item_code_desc' id='item_code_desc'  value="<%=bean.checkForNull(desc)%>"  onBlur="ChangeUpperCase(this)" <%=disable%>><input class='button' type='button' name='searchItem' id='searchItem' value='?' <%=disable%> onClick="callItemSearchScreen(item_code_desc,document.forms[0])" class="label">&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif' >
	<td  class="label" nowrap>&nbsp;&nbsp;<fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/>&nbsp;</td>
	<td  id ="stock_uom"  name="stock_uom"  class="QUERYDATA" WIDTH="20%">&nbsp;<%=bean.checkForNull(uom)%></td>
	
	
</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
<tr>
	<td   class="label" width='9%' nowrap><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></td>
	<td  class="fields">&nbsp;<select name='prep_type' id='prep_type' >
					<!--<option value="P"  <%=bean.getPrep_type().equals("P")?"Selected":""%>><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></option>
					<option value="S"<%=bean.getPrep_type().equals("S")?"Selected":""%>><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></option>
					<option value="O"<%=bean.getPrep_type().equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option> -->
					<!--<option value="P"  <%=prep_type.equals("P")?"Selected":""%>><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></option>
					<option value="S" <%=prep_type.equals("S")?"Selected":""%>><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></option>
					<option value="O"<%= prep_type.equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option> -->
					<!-- //Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 -->
					 
			<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){ %>
			<%if(!prep_prepack.equals("")){ %>
			 <OPTION VALUE="P" <%=prep_type.equals("P")?"Selected":""%>><%=prep_prepack %></OPTION>
			 <% } if(!prep_standard.equals("")){ %>
			<OPTION VALUE="S" <%=prep_type.equals("S")?"Selected":""%>><%=prep_standard %></OPTION>
			<% } if(!prep_others.equals("")){ %>
			<OPTION VALUE="O" <%=prep_type.equals("O")?"Selected":""%>><%=prep_others %></OPTION>
			<%}
			}else{%>
			
			        <OPTION VALUE="P" <%=prep_type.equals("P")?"Selected":""%>><%=prep_prepack %></OPTION>
					<OPTION VALUE="S" <%=prep_type.equals("S")?"Selected":""%>><%=prep_standard %></OPTION>
					<OPTION VALUE="O" <%=prep_type.equals("O")?"Selected":""%>><%=prep_others %></OPTION>
			<%} %>>
			
					<!-- ends -->
	               </select></td>
	<td  class="label" nowrap><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></td>
	<td  class='fields' colspan="2" ><select name='prep_mode' id='prep_mode' >
					<!--<option value="S"  <%=bean.getPrep_mode().equals("S")?"Selected":""%>><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></option>
					<option value="N"<%=bean.getPrep_mode().equals("N")?"Selected":""%>><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></option>
					<option value="O"<%=bean.getPrep_mode().equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>-->
					
					<option value="S" <%=prep_mode.equals("S")?"Selected":""%>><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></option>
					<option value="N"<%=prep_mode.equals("N")?"Selected":""%>><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></option>
					<option value="O"<%=prep_mode.equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
	    </select></td>
	<td  class="label" width="10%">&nbsp;<fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
	<!-- 		
			* @Name - Priya
			* @Date - 12/02/2010
			* @Inc# - 19272
			* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called and maxlength is changed to 12.			
		-->
	<td  class='fields' colspan="4"><input type="text" name="base_qty" id="base_qty"  onKeyPress="return isValidNumber(this,event,7,<%=no_deci%>);" onBlur="checkDoubleFormat(this); " class="NUMBER" size="12" maxlength="12" value="<%=bean.setNumber((String)bqty,no_deci)%>" >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>&nbsp;</td>
	
</tr>
 <tr>
	<td  class="label"  nowrap><fmt:message key="Common.labelType.label" bundle="${common_labels}"/></td>
	<td  class="fields">&nbsp;<select name='label_type' id='label_type' >
				<option value="1"  <%=label_type.equals("1")?"Selected":""%>><fmt:message key="eST.WithFormulary.label" bundle="${st_labels}"/></option>
				<option value="2"<%=label_type.equals("2")?"Selected":""%>><fmt:message key="eST.WithoutFormulary.label" bundle="${st_labels}"/></option></select></td> 
	<!-- //Added for ML-MMOH-CRF-1909-->
	<td  class="label"  nowrap><fmt:message key="eST.ShelfLife.label" bundle="${st_labels}"/></td>
    <td class="fields"><input type="text" name="shelfLifeValue1" id="shelfLifeValue1" id="shelfLifeValue" onchange="isValidShelfLifeValue(this);" maxlength="3" value="<%=shelf_life_value%>" > </td>
    <td  class="fields">&nbsp;<select name="shelfLifeFlag1" id="shelfLifeFlag1" id="shelfLifeFlag" value="<%=shelf_life_flag%>">
    			  <option value=""<%if(shelf_life_flag.equals("")) out.print("selected");%>><fmt:message key="eST.Select.label" bundle="${st_labels}"/></option>
                  <option value="D"<%if(shelf_life_flag.equals("D")) out.print("selected");%>><fmt:message key="eST.Day(s).label" bundle="${st_labels}"/></option>
                  <option value="W"<%if(shelf_life_flag.equals("W")) out.print("selected");%>><fmt:message key="eST.Week(s).label" bundle="${st_labels}"/></option>
                  <option value="M"<%if(shelf_life_flag.equals("M")) out.print("selected");%>><fmt:message key="eST.Month(s).label" bundle="${st_labels}"/></option>
                  <option value="Y"<%if(shelf_life_flag.equals("Y")) out.print("selected");%>><fmt:message key="eST.Year(s).label" bundle="${st_labels}"/></option>
				   </select></td>
	<td  class="label">&nbsp;</td>
	<td  onClick="showInstruction('<%=bean.getItem_code()%>','<%=mode%>');" onmouseover="changeCursor(this);" class="label" ><font class='HYPERLINK'><fmt:message key="eST.PrepareInstruction.label" bundle="${st_labels}"/></font></td>
	<td  class="label" nowrap colspan="2"><fmt:message key="eST.ProcessLoss.label" bundle="${st_labels}"/> %</td>
	<td   class='fields' colspan="2"><input type="text" name="process_loss" id="process_loss" onKeyPress="return isValidNumberCost(this,event,2,2);"  onBlur="assignzero(this);checkDoubleFormat(this,false);" class="NUMBER" size="8" maxlength="5" value="<%=bean.checkForNull(ploss)%>">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>&nbsp;</td>

</tr> 

</table>
</div>
	<input type='hidden' name='mode' id='mode'		value='<%=mode%>'>
	<input type='hidden' name='checkBoxVals' id='checkBoxVals' >
	<input type='hidden' name='bean_id' id='bean_id'		value="<%=bean_id%>" >
	<input type='hidden' name='bean_name' id='bean_name'	value="<%=bean_name%>" >
	<input type='hidden' name='item_code' id='item_code'	value="<%=item_code%>" >
	<input type='hidden' name='index' id='index'		value="<%=index%>" >
	<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>" >
	<input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>" >
	<!-- 		
		* @Name - Priya
		* @Date - 12/02/2010
		* @Inc# - 19272
		* @Desc - Code added to accept decimal values dynamically.			
		-->

	<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="<%=bean.getAllowDecimalsYN(item_code)%>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

</html>

