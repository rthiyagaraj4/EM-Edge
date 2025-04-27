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

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgEnq.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	String type=request.getParameter("type");
	String service_code=request.getParameter("service_code");
	int totalRecords=0;
	String packageCode						= "" ;
	packageCode								= request.getParameter("packageCode");
	packageCode								= packageCode == null ?"" :packageCode;
	String packageSeqNo						= request.getParameter("packageSeqNo") ;
	packageSeqNo							= packageSeqNo == null ? "":packageSeqNo ;
	//String parent_indx						=	request.getParameter("parent_indx") == null ? "" :request.getParameter("parent_indx") ;
	String dtlsDisp							= "none";
	String refndDisp						= "none";
	String uSelect							= "";
	String dSelect							="";
	String bean_id							= "bl_PkgEnqBean" ;
	String bean_name						= "eBL.PkgEnqBean";
	PkgEnqBean bean							= (PkgEnqBean)getBeanObject(bean_id,bean_name,request);	
	HashMap excludedItems_RB				=   new HashMap();
	excludedItems_RB						=  bean.getExcludedItems_RB();
	String srvLimit_type					="";
	String srvLimit_service_code			="";
	String srvLimit_service_desc			="";
	String exludeService					="N";
	String srvLimit_qty_limit				="";
	String srvLimit_amt_limit				="";
	String srvLimit_factor_appl				="";	
	String srvLimit_amt_limit_ind			="";
	String srvLimit_replace					="";
	String srvLimit_replaceSrv_code			="N";
	String srvLimit_replaceSrv_desc			= "";
	String srvLimit_refund					="N";
	String srvLimit_refundAmt				="";
	String srvLimit_auto_refund				="N";
	String srvLimit_roundTo					= "";
	String srvLimit_roundInd				= "";
	String srvLimit_utilizedAmt				= "";
	String srvLimit_utilizedQty				= "";
	String srvLimit_refundedYN				= "N";
	ArrayList srvLimit_type_list			=	new ArrayList();
	ArrayList srvLimit_service_code_list	=	new ArrayList();
	ArrayList srvLimit_service_desc_list	=	new ArrayList();
	ArrayList exludeService_list		    =	new ArrayList();
	ArrayList srvLimit_qty_limit_list		=	new ArrayList();
	ArrayList srvLimit_amt_limit_list		=	new ArrayList();
	ArrayList srvLimit_factor_appl_list		=	new ArrayList();
	ArrayList amt_limit_ind_list			=	new ArrayList();
	ArrayList srvLimit_replace_list			=	new ArrayList();
	ArrayList srvLimit_replaceSrv_code_list	=	new ArrayList();
	ArrayList srvLimit_refund_list			=	new ArrayList();
	ArrayList srvLimit_refundAmt_list		=	new ArrayList();
	ArrayList srvLimit_auto_refund_list		=	new ArrayList();
	ArrayList srvLimit_roundTo_list			=	new ArrayList();
	ArrayList srvLimit_roundInd_list		=	new ArrayList();
	ArrayList srvLimit_utilizedAmt_list		=	new ArrayList();
	ArrayList srvLimit_utilizedQty_list		=	new ArrayList();
	ArrayList srvLimit_refundedYN_list		=	new ArrayList();
	ArrayList	srvLimit_replaceSrv_desc_list		=	new ArrayList();
	ArrayList rBServiceLimits				=	new ArrayList();
	if(excludedItems_RB.size()>0 && excludedItems_RB.containsKey(service_code) )
	{
		rBServiceLimits =(ArrayList)excludedItems_RB.get(service_code);
		
		if(rBServiceLimits.size()>0)
		{
			srvLimit_type_list				= (ArrayList)rBServiceLimits.get(0);
			srvLimit_service_code_list		= (ArrayList)rBServiceLimits.get(1);
			srvLimit_service_desc_list		= (ArrayList)rBServiceLimits.get(2);
			exludeService_list				= (ArrayList)rBServiceLimits.get(3);
			srvLimit_qty_limit_list			= (ArrayList)rBServiceLimits.get(4);
			srvLimit_amt_limit_list			= (ArrayList)rBServiceLimits.get(5);	
			srvLimit_factor_appl_list		= (ArrayList)rBServiceLimits.get(6);
			amt_limit_ind_list				= (ArrayList)rBServiceLimits.get(7);	
			srvLimit_replace_list			= (ArrayList)rBServiceLimits.get(8);
			srvLimit_replaceSrv_code_list	= (ArrayList)rBServiceLimits.get(9);	
			srvLimit_refund_list			= (ArrayList)rBServiceLimits.get(10);
			srvLimit_refundAmt_list			= (ArrayList)rBServiceLimits.get(11);
			srvLimit_auto_refund_list		= (ArrayList)rBServiceLimits.get(12);	
			srvLimit_roundTo_list			= (ArrayList)rBServiceLimits.get(13);
			srvLimit_roundInd_list			= (ArrayList)rBServiceLimits.get(14);
			srvLimit_utilizedAmt_list		= (ArrayList)rBServiceLimits.get(15);	
			srvLimit_utilizedQty_list		= (ArrayList)rBServiceLimits.get(16);
			srvLimit_refundedYN_list		= (ArrayList)rBServiceLimits.get(17);
			srvLimit_replaceSrv_desc_list	= (ArrayList)rBServiceLimits.get(18);	


			if(srvLimit_service_code_list.size()>0){
				totalRecords=srvLimit_service_code_list.size();
				}
		}
	}
%>

<form name='srvLimit_rate_based_dtl' id='srvLimit_rate_based_dtl'  target='messageFrame' >
<table class='grid' width='100%' id="srvLimit_rate_based_tbl">


<td class='columnheader' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>

<td class='columnheader' ><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>
<%if(!(packageSeqNo.equals("")))
{%>
<td class='columnheader' ><fmt:message key="eBL.UtilizedQty.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.UtilizedAmt.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.Refunded.label" bundle="${bl_labels}"/></td>
<%}%>
</tr>

<%	 	

	for(int i=0; i<totalRecords; i++)
	{	 
		if(srvLimit_service_code_list.size()>0)
		{
			srvLimit_type			= (String)srvLimit_type_list.get(i);
			srvLimit_service_code	= (String)srvLimit_service_code_list.get(i);
		    srvLimit_service_desc	=(String) srvLimit_service_desc_list.get(i);
			exludeService			=(String) exludeService_list.get(i);
			if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
				exludeService="N";
			
			srvLimit_qty_limit		= (String)srvLimit_qty_limit_list.get(i);
			srvLimit_amt_limit		= (String)srvLimit_amt_limit_list.get(i);
			srvLimit_factor_appl	= (String)srvLimit_factor_appl_list.get(i);
			srvLimit_amt_limit_ind	= (String)amt_limit_ind_list.get(i);		
			srvLimit_replace		= (String)srvLimit_replace_list.get(i);		srvLimit_replaceSrv_code=(String)srvLimit_replaceSrv_code_list.get(i);
			srvLimit_refund			= (String)srvLimit_refund_list.get(i);		srvLimit_refundAmt		= (String)srvLimit_refundAmt_list.get(i);	srvLimit_auto_refund	= (String)srvLimit_auto_refund_list.get(i);	srvLimit_roundTo		= (String)srvLimit_roundTo_list.get(i);
			srvLimit_roundInd		= (String)srvLimit_roundInd_list.get(i);
			srvLimit_utilizedAmt	=(String) srvLimit_utilizedAmt_list.get(i);
			srvLimit_utilizedQty	=(String) srvLimit_utilizedQty_list.get(i);
			srvLimit_refundedYN		=(String) srvLimit_refundedYN_list.get(i);
			srvLimit_replaceSrv_desc=(String)srvLimit_replaceSrv_desc_list.get(i);
		}
		if(srvLimit_replace.equals("Y"))
			  dtlsDisp = "inline";
		if(srvLimit_replace.equals("Y"))
			refndDisp = "inline";
	
		uSelect = srvLimit_roundInd.equals("U")? " selected "	 :"";
		dSelect = srvLimit_roundInd.equals("D")? " selected "	 :"";
		
		%>
<tr>
<td align="left" nowrap> 
<%
if(type.equals("G")){
%>
<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>' disabled ><option value='C' <%=srvLimit_type.equals("C")?"selected":""%>><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option><option value='S' <%=srvLimit_type.equals("S")?"selected":""%>><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option></select>
<%
}else{%>
<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>' disabled ><option value='S' <%=srvLimit_type.equals("S")?"selected":""%>><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option></select>
<%}
%>
</td>
					
<td align="left" nowrap>
<input type='text' name='srvLimit_service_code<%=i%>' id='srvLimit_service_code<%=i%>' value='<%=srvLimit_service_code%>' size='10' disabled >
<input type='text' name = 'srvLimit_service_desc<%=i%>' size='10' maxlength='10' value="<%=srvLimit_service_desc%>" disabled></td>

<td align="left" nowrap ><input type='checkbox' name='exludeService<%=i%>' id='exludeService<%=i%>'  disabled  <%=exludeService.equals("Y")?"checked":""%> value="<%=exludeService%>" /></td>
			
<td align="left" nowrap><input type='text'    name='srvLimit_qty_limit<%=i%>' id='srvLimit_qty_limit<%=i%>'   size='5'  disabled  /></td>

<td  align="left" nowrap>
<select name='srvLimit_amt_limit_ind<%=i%>' id='srvLimit_amt_limit_ind<%=i%>' disabled >
<option value='A' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P' ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
</select>
</td>

<td align="left" nowrap><input type='text' name='srvLimit_amt_limit<%=i%>' id='srvLimit_amt_limit<%=i%>'   disabled  size='5' maxlength='5'  value="<%=srvLimit_amt_limit%>"/></td>
<td  class='fields' ><input type='text' name='srvLimit_roundTo<%=i%>' id='srvLimit_roundTo<%=i%>' size='3'  value="<%=srvLimit_roundTo%>" disabled /></td>
<td  class='fields' >
<select name='srvLimit_roundInd<%=i%>' id='srvLimit_roundInd<%=i%>'   disabled >
<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>

<td  align="left" nowrap>
<input type='checkbox'    disabled  name='srvLimit_replace<%=i%>' id='srvLimit_replace<%=i%>'  <%=srvLimit_replace.equals("Y")?"checked":""%> value="<%=srvLimit_replace%>" disabled />
<a name='srvLimit_replace_dtls<%=i%>' id='srvLimit_replace_dtls<%=i%>' href='#'	style ='display:<%=dtlsDisp%>' onClick='srvLimitShowReplaceDtls("<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a><input type="hidden" name="srvLimit_replaceSrv_code<%=i%>" id="srvLimit_replaceSrv_code<%=i%>" value="<%=srvLimit_replaceSrv_code%>"><input type="hidden" name="srvLimit_replaceSrv_desc<%=i%>" id="srvLimit_replaceSrv_desc<%=i%>" value="<%=srvLimit_replaceSrv_desc%>">
</td>

<td align="left" nowrap><input type='checkbox'    disabled  name='srvLimit_refund<%=i%>' id='srvLimit_refund<%=i%>' <%=srvLimit_refund.equals("Y")?"checked":""%>  value="<%=srvLimit_refund%>"/><input type='text' name='srvLimit_refundAmt<%=i%>' id='srvLimit_refundAmt<%=i%>' value=''  style ='display:<%=refndDisp%>' size='5' disabled ></td>
<td align="left" nowrap><input type='checkbox'    disabled  name='srvLimit_autoRefund<%=i%>' id='srvLimit_autoRefund<%=i%>' <%=srvLimit_auto_refund.equals("Y")?"checked":""%>  value="<%=srvLimit_auto_refund%>"/></td>
<td align="left" nowrap>
<input type='checkbox' name='srvLimit_factor_appl<%=i%>' id='srvLimit_factor_appl<%=i%>'  disabled  <%=srvLimit_factor_appl.equals("Y")?"checked":""%> value="<%=srvLimit_factor_appl%>" /></td>

<%if(!(packageSeqNo.equals("")))
{%>
<td><input type='text' name='srvLimit_utilizedAmt<%=i%>' id='srvLimit_utilizedAmt<%=i%>' size='5' maxlength='5'   value="<%=srvLimit_utilizedAmt%>" disabled /></td>
<td  class='fields' ><input type='text' name='srvLimit_utilizedQty<%=i%>' id='srvLimit_utilizedQty<%=i%>' size='3' maxlength="3"  value="<%=srvLimit_utilizedQty%>" disabled /></td>
<td align="left" nowrap><input type='checkbox'    name='srvLimit_refundedYN<%=i%>' id='srvLimit_refundedYN<%=i%>' <%=srvLimit_refundedYN.equals("Y")?"checked":""%> value="<%=srvLimit_refundedYN%>" disabled/></td>
<%}%>

</tr>
<%
}
%>
 </table>
  </form> 
  
 </body>

 <%putObjectInBean(bean_id,bean,request);%>
</html>

