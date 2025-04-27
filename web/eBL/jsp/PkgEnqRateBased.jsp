<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*, eBL.PkgDefBean" %>
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
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgEnq.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	
	int totalRecords=1;
	String packageCode	=	request.getParameter("packageCode") ;
	packageCode			=	packageCode == null ? "" :packageCode ;
	String packageSeqNo	=	request.getParameter("packageSeqNo") ;
	packageSeqNo		=	packageSeqNo == null ? "" :packageSeqNo ;
	String bean_id		= "bl_PkgEnqBean" ;
	String bean_name	= "eBL.PkgEnqBean";
	PkgEnqBean bean			= (PkgEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	String		type				="";
	String 		service_code		="";
	String 	    service_desc		="";
	String 		catalog_code		="";
	String 		catalog_desc		="";
	String 		ind					="";
	String 		factorOrRate		="";
	String 		qty_limit			="";
	String 		amt_limit_ind		="";
	String 		amt_limit			="";
	String 		replace				="N";
	String 		replaceSrv_code		="";
	String 		replaceSrv_desc		="";
	String 		replaceSrv_cat_code	="";
	String 		replaceSrv_cat_desc	="";
	String 		refund				="N";
	String		autoRefund			= "N";
	String 		refundAmt			="";
	String 		factor_appl			="";
	String 		service_limit		="N";
	String 	    roundTo				= "";
	String      roundInd			= "";
	String      closePkg			= "N";
	String     	closePkgVal			= "N";
	String		utilizedAmt			= "";
	String		utilizedQty			= "";
	String		refundedYN			= "N";
	String      uSelect				= "";
	String      dSelect				= "";
	
	///String order_associated=request.getParameter("orderAssociated") == null ? "N" : request.getParameter("orderAssociated");
	String order_associated=bean.getOrderAssociated() == null ? "N" : bean.getOrderAssociated();

	ArrayList	type_list				=	new ArrayList();
	ArrayList	service_code_list		=	new ArrayList();
	ArrayList	service_desc_list	    =	new ArrayList();
	ArrayList	catalog_code_list		=	new ArrayList();
	ArrayList	catalog_desc_list		=	new ArrayList();
	ArrayList	ind_list				=	new ArrayList();
	ArrayList	factorOrRate_list		=	new ArrayList();
	ArrayList	qty_limit_list			=	new ArrayList();
	ArrayList	amt_limit_ind_list		=	new ArrayList();
	ArrayList	amt_limit_list			=	new ArrayList();
	ArrayList	replace_list			=	new ArrayList();
	ArrayList	replaceSrv_code_list    =	new ArrayList();
	ArrayList	replaceSrv_desc_list    =	new ArrayList();
	ArrayList	replaceSrv_cat_code_list=	new ArrayList();
	ArrayList	replaceSrv_cat_desc_list=	new ArrayList();
	ArrayList	refund_list				=	new ArrayList();
	ArrayList	refundAmt_list			=	new ArrayList();	
	ArrayList	auto_refund_list		=	new ArrayList();	
	ArrayList	factor_appl_list		=	new ArrayList();	
	ArrayList	service_limit_list		=	new ArrayList();
	ArrayList	roundTo_list			=	new ArrayList();
	ArrayList	roundInd_list			=	new ArrayList();
	ArrayList	closePkg_list			=	new ArrayList();
	ArrayList	utilizedAmt_list		=	new ArrayList();
	ArrayList	utilizedQty_list		=	new ArrayList();
	ArrayList	refundedYN_list			=	new ArrayList();
	ArrayList	rBServices				=	new ArrayList();
	HashMap includedItems_RB			=   bean.getIncludedItems_RB();
	
	if(includedItems_RB!=null && includedItems_RB.size()>0 && includedItems_RB.containsKey(packageCode) )
	{
		rBServices =(ArrayList)includedItems_RB.get(packageCode);  
		if(rBServices.size()>0)
		{
			type_list				= (ArrayList)rBServices.get(0);
			service_code_list		= (ArrayList)rBServices.get(1);
		    service_desc_list		= (ArrayList)rBServices.get(2);
			catalog_code_list		= (ArrayList)rBServices.get(3);
			catalog_desc_list		= (ArrayList)rBServices.get(4);
			ind_list				= (ArrayList)rBServices.get(5);
			factorOrRate_list		= (ArrayList)rBServices.get(6);
			qty_limit_list			= (ArrayList)rBServices.get(7);
			amt_limit_ind_list		= (ArrayList)rBServices.get(8);
			amt_limit_list			= (ArrayList)rBServices.get(9);
			replace_list			= (ArrayList)rBServices.get(10);
			replaceSrv_code_list	= (ArrayList)rBServices.get(11);
			replaceSrv_desc_list	= (ArrayList)rBServices.get(12);
			replaceSrv_cat_code_list= (ArrayList)rBServices.get(13);
			replaceSrv_cat_desc_list= (ArrayList)rBServices.get(14);
			refund_list				= (ArrayList)rBServices.get(15);
			refundAmt_list			= (ArrayList)rBServices.get(16);
			factor_appl_list		= (ArrayList)rBServices.get(17);
			service_limit_list		= (ArrayList)rBServices.get(18);
			auto_refund_list		= (ArrayList)rBServices.get(19);
			roundTo_list			= (ArrayList)rBServices.get(20);
			roundInd_list			= (ArrayList)rBServices.get(21);
			closePkg_list			= (ArrayList)rBServices.get(22);
			utilizedAmt_list		= (ArrayList)rBServices.get(23);
			utilizedQty_list	    = (ArrayList)rBServices.get(24);
			refundedYN_list			= (ArrayList)rBServices.get(25);
			if(service_code_list.size()>0){
				totalRecords=service_code_list.size();
			}
		}
	}
	
%>

<form name='rate_based_dtl' id='rate_based_dtl'  target='messageFrame' >	
<table class='grid' width='100%' id="rate_based_tbl">
<th class='columnheader' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></th> 
<th class='columnheader' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></th> 
<th class='columnheader' > <fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th> 
<th class='columnheader' ><fmt:message key="eBL.AmountIndicator.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.FactorRate.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></th>
<th  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></th>
<th  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.CLOSE_PACKAGE.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></th>
<%if(!(packageSeqNo.equals("")))
{%>
<th class='columnheader' ><fmt:message key="eBL.UtilizedQty.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.UtilizedAmt.label" bundle="${bl_labels}"/></th>
<th class='columnheader' ><fmt:message key="eBL.Refunded.label" bundle="${bl_labels}"/></th>
<%}%>
</tr>

<%for(int i=0; i<totalRecords; i++)
{	
	if(service_code_list.size()>0)
	{
		type			= (String)type_list.get(i);
		service_code	= (String)service_code_list.get(i);
		service_desc	=(String) service_desc_list.get(i);
		catalog_code	=(String) catalog_code_list.get(i);
		catalog_desc	= (String)catalog_desc_list.get(i);
		ind				= (String)ind_list.get(i);
		factorOrRate	= (String)factorOrRate_list.get(i);
		qty_limit		=(String) qty_limit_list.get(i);
		amt_limit_ind	=(String) amt_limit_ind_list.get(i);
		amt_limit		= (String)amt_limit_list.get(i);
		replace			= (String)replace_list.get(i);
		if(replace==null || replace.equals("") || replace.equals("null"))
			replace="N";
		replaceSrv_code	= (String)replaceSrv_code_list.get(i);
		replaceSrv_desc	= (String)replaceSrv_desc_list.get(i);
		replaceSrv_cat_code	=(String) replaceSrv_cat_code_list.get(i);
		replaceSrv_cat_desc	= (String)replaceSrv_cat_desc_list.get(i);
		refund			=(String) refund_list.get(i);			
		if(refund==null || refund.equals("") || refund.equals("null"))
		refund			="N";
		refundAmt		= (String)refundAmt_list.get(i);
		//System.out.println("@@ i="+i);
		//System.out.println("@@ refundAmt="+refundAmt);
		autoRefund		= (String)auto_refund_list.get(i);
		factor_appl		= (String)factor_appl_list.get(i);
		service_limit	= (String)service_limit_list.get(i);
		if(service_limit==null || service_limit.equals("") || service_limit.equals("null"))
		service_limit	="N";
		roundTo			= (String)roundTo_list.get(i);
		roundInd		= (String)roundInd_list.get(i);
		closePkg		=(String) closePkg_list.get(i);
		utilizedAmt		=(String) utilizedAmt_list.get(i);
		utilizedQty		=(String) utilizedQty_list.get(i);
		refundedYN		=(String) refundedYN_list.get(i);

	}
	uSelect = roundInd.equals("U")? " selected "	 :"";
	dSelect = roundInd.equals("D")? " selected "	 :"";
	closePkgVal = closePkg.equals("Y") ? "on" :"off";
		
	%>
<tr>
	<td align="left" nowrap> 
	<select name='type<%=i%>' id='type<%=i%>' disabled ><option value='G' <%=type.equals("G")?"selected":""%> ><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/></option><option value='C' <%=type.equals("C")?"selected":""%>><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option><option value='S' <%=type.equals("S")?"selected":""%>><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>
	</select>
	</td>
				
	<td align="left" nowrap><input type='hidden' name='service_code<%=i%>' id='service_code<%=i%>'  value='<%=service_code%>'><input type='text' name = 'service_desc<%=i%>' size='10' disabled maxlength='10' value="<%=service_desc%>"></td>
			
	<td align="left" nowrap><input type='text' name = 'catalog_desc<%=i%>'  disabled size='10' maxlength='10' value='<%=catalog_desc%>'><input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=catalog_code%>"></td>
	
	<td  align="left" nowrap>
	<%if(type.equals("G") || type.equals("C")){ %>
	<select name='ind<%=i%>' id='ind<%=i%>' disabled><option value='S' <%=ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option><option value='R' <%=ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option><option value='P' <%=ind.equals("P")?"selected":""%> >
	<fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option></select>
	<%}else{%>	
	<select name='ind<%=i%>' id='ind<%=i%>' disabled><option value='S' <%=ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option><option value='R' <%=ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option><option value='U' <%=ind.equals("U")?"selected":""%> ><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option><option value='P' <%=ind.equals("P")?"selected":""%> ><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option><option value='X' <%=ind.equals("X")?"selected":""%> ></option></select>
	<%}%>
	</td>

	<td align="left" nowrap><input type='text' name='factorOrRate<%=i%>' id='factorOrRate<%=i%>' size='5'  value="<%=factorOrRate%>" disabled/></td>
			
	<td align="left" nowrap><input type='text'    name='qty_limit<%=i%>' id='qty_limit<%=i%>'   size='3' disabled value="<%=qty_limit%>" /></td>

	<td  align="left" nowrap>
	<select name='amt_limit_ind<%=i%>' id='amt_limit_ind<%=i%>' disabled>
	<option value='A' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
	<option value='P' ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
	<option value='U' ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
	</select>
	</td>

	<td><input type='text' name='perAmt_limit<%=i%>' id='perAmt_limit<%=i%>' size='5' maxlength='5'   value="<%=amt_limit%>"disabled /></td>
	<td  class='fields' ><input type='text' name='roundTo<%=i%>' id='roundTo<%=i%>' size='3'   value="<%=roundTo%>" disabled /></td>

	<td  class='fields' >
	<select name='roundInd<%=i%>' id='roundInd<%=i%>' disabled>
	<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
	<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
	</select>
	</td>
	<td  align="left" nowrap>
	<input type='checkbox'   disabled name='replace<%=i%>' id='replace<%=i%>'  <%=replace.equals("Y")?"checked":""%> value="<%=replace%>" disabled/>
	<%if(replace.equals("Y")){%><a name='replace_dtls<%=i%>' href='#' onClick='showReplaceDtls("<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a><%}%> <input type="hidden" name="replaceSrv_code<%=i%>" id="replaceSrv_code<%=i%>" value="<%=replaceSrv_code%>"><input type="hidden" name="replaceSrv_desc<%=i%>" id="replaceSrv_desc<%=i%>" value="<%=replaceSrv_desc%>"><input type="hidden" name="replaceSrv_cat_code<%=i%>" id="replaceSrv_cat_code<%=i%>" value="<%=replaceSrv_cat_code%>"><input type="hidden" name="replaceSrv_cat_desc<%=i%>" id="replaceSrv_cat_desc<%=i%>" value="<%=replaceSrv_cat_desc%>">
	</td>

	<td align="left" nowrap><input type='checkbox'   disabled name='refund<%=i%>' id='refund<%=i%>' <%=refund.equals("Y")?"checked":""%>  value="<%=refund%>"/><%if(refund.equals("Y")){%><input type='text' name='refundAmt<%=i%>' id='refundAmt<%=i%>' value='<%=refundAmt%>' size='5' disabled ><%}%></td>
	<td align="left" nowrap><input type='checkbox'   disabled name='autoRefund<%=i%>' id='autoRefund<%=i%>' <%=autoRefund.equals("Y")?"checked":""%>  value="<%=autoRefund%>"/></td>
	<td align="left" nowrap><input type='checkbox'    name='factor_appl<%=i%>' id='factor_appl<%=i%>' <%=factor_appl.equals("Y")?"checked":""%> value="<%=factor_appl%>" disabled/></td>
	<td align="left" nowrap>
	<input type='radio' name='closePkg' id='closePkg' <%=closePkgVal.equals("Y")?" checked ":""%> disabled /><input type='hidden' name='closePkg<%=i%>' id='closePkg<%=i%>' value="<%=closePkgVal%>" /></td>
	<td align="left" nowrap><input type='checkbox'   disabled name='service_limit<%=i%>' id='service_limit<%=i%>' <%=service_limit.equals("Y")?"checked":""%> value="<%=service_limit%>" disabled/><%if(service_limit.equals("Y")){%><a name='service_limit_dtls<%=i%>' href='#' onClick='serviceLimitDtls("<%=packageSeqNo%>","<%=i%>","<%=packageCode%>","<%=type%>","<%=service_code%>")' ><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a><%}%></td>
	<%if(!(packageSeqNo.equals("")))
	{%>
		<td><input type='text' name='utilizedAmt<%=i%>' id='utilizedAmt<%=i%>' size='5' maxlength='5'   value="<%=utilizedAmt%>"disabled /></td>
		<td  class='fields' ><input type='text' name='utilizedQty<%=i%>' id='utilizedQty<%=i%>' size='3' maxlength="3"  value="<%=utilizedQty%>" disabled /></td>
		<td align="left" nowrap><input type='checkbox'    name='refundedYN<%=i%>' id='refundedYN<%=i%>' <%=refundedYN.equals("Y")?"checked":""%> value="<%=refundedYN%>" disabled/></td>
	<%}%>
	</tr>
	<%
	}
	%>
 </table>
 	<input type="hidden" name="order_associated" id="order_associated" value="<%=order_associated%>">	
</form>
</body>
  <%putObjectInBean(bean_id,bean,request);%>
</html>

