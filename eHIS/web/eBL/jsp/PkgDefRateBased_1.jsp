<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css' />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Bl_PkgDefBean" ;
	String bean_name = "eBL.PkgDefBean";
	String locale			= (String)session.getAttribute("LOCALE");
	String order_associated="N";
	int totalRecords=1;
	//totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	
	String ordCatDisabled="disabled";
	if(order_associated.equals("Y")){
	
		ordCatDisabled="";
	}
	
%>

<form name='rate_based_dtl' id='rate_based_dtl'  target='messageFrame' >	
<table class='grid' width='100%' id="rate_based_tbl">
<td class='columnheader' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td> 
<td class='columnheader' > <fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="eBL.AmountIndicator.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.FactorRate.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.PercentageLimit.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.NoLimit.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.del.label" bundle="${bl_labels}"/></td>
</tr>
<tr>
<td align="left" nowrap> 
<%if(order_associated.equals("Y")){%>
<select name='type0' id='type0' onChange='onServiceTypeChange(this,"0")'><option value='S'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option></select>
<%}else{%>
<select name='type0' id='type0' onChange='onServiceTypeChange(this,"0")'><option value='SG'><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/></option><option value='SC'><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option><option value='S'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option></select>
<%
}%>
</td>

						
<td align="left" nowrap><input type='hidden' name='service_code0' id='service_code0' value=''><input type='text' name = 'service_desc0' size='10' maxlength='10' onBlur="before_serviceLookUp(this,service_code0,type0,'0')"value=""><INPUT type='hidden' name='service_desc_temp0' id='service_desc_temp0' value=''><input type='button' name='service_button0' id='service_button0' class='button' value='?' onclick="serviceLookUp(service_desc0,service_code0,type0,'0')"></td>
			
<td align="left" nowrap><input type='hidden' name='catalog_code0' id='catalog_code0' value=''><input type='text' name = 'catalog_desc0'  <%=ordCatDisabled%> size='10' maxlength='10' onBlur="before_catalogLookUp(this,catalog_code0,service_code0,'0')" value=''><INPUT type='hidden' name='catalog_desc_temp0' id='catalog_desc_temp0' value=''><input type='button' name='catalog_button0' id='catalog_button0'  <%=ordCatDisabled%>  class='button' value='?' onclick="catalogLookUp(catalog_desc0,catalog_code0,service_code0,'0')"></td>
			
<td  align="left" nowrap><select name='ind0' id='ind0' onChange='onIndChange(this,"0")'><option value='std'><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option><option value='rule'><fmt:message key="Common.rule.label" bundle="${common_labels}"/></option><option value='user_def'><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option></select></td>
			
<td align="left" nowrap><input type='text' name='factorOrRate0' id='factorOrRate0' size='5'  onBlur='putdeci(this,"2");' onkeypress='return allowValidNumber1_temp(this,event,"2")';/></td>
			
<td align="left" nowrap><input type='text'    name='qty_limit0' id='qty_limit0'   size='5' disabled onBlur='chkQtyLimit(this);' onkeypress='return allowValidNumber1_temp(this,event,"2")'; value="" /></td>

<td align="left" nowrap><input type='text'  name='amt_percentage0' id='amt_percentage0' size='5'  disabled onBlur='putdeci(this,"2");validPercentage(this);chkAmtPercent(this,"0");' onkeypress='return allowValidNumber1_temp(this,event,"2")'; value="" /></td>
<td><input type='text' name='amt_limit0' id='amt_limit0'  disabled size='5' maxlength='5'  onBlur='putdeci(this,"2");chkAmt(this,"0");' onkeypress='return allowValidNumber1_temp(this,event,"2")'; value=""/></td>

<td align="left" nowrap ><input type='checkbox' disabled name='unlimited0' id='unlimited0' onClick='chkUnlimited(this,"0")' value="N" /></td>

<td  align="left" nowrap><input type='checkbox'  disabled name='replace0' id='replace0' onClick='chkReplace(this,"0")'/><input type="hidden" name="replaceSrv_code0" id="replaceSrv_code0" value=""><input type="hidden" name="replaceSrv_desc0" id="replaceSrv_desc0" value=""><input type="hidden" name="replaceSrv_cat_code0" id="replaceSrv_cat_code0" value=""><input type="hidden" name="replaceSrv_cat_desc0" id="replaceSrv_cat_desc0" value=""></td>

<td align="left" nowrap><input type='checkbox'  disabled name='refund0' id='refund0' onClick='chkRefund(this,"0")'/></td>

<td align="left" nowrap><input type='checkbox'  disabled name='service_limit0' id='service_limit0' onClick='chkServiceLimit(this,"0")' value="N"/></td>
<td align="left" nowrap><input type='checkbox'  name='deleteService0' id='deleteService0' onClick='chkDeleteService(this,"0")' value="N"/></td>

</tr>
 </table>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
 	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="order_associated" id="order_associated" value="<%=order_associated%>">	
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	
	 </form>
  <script>initializeRateForm();</script>
 </body>
</html>

