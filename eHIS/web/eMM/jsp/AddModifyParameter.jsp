<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
09/05/2017		IN062881		B.Badmavathi								     PO Mandatory in GRN 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script> <!--  Vaild String -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script> <!-- Code arrest,Focue -->
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script> <!-- On key press,Uppercase -->
	<script language="JavaScript" src="../../eMM/js/Parameter.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad="FocusFirstElement()" >
<%
	/* Mandatory checks start */
	String	mode				=	"";		
	String	bean_id				=	"",		bean_name		=	"";
	String	codeDisabled =	"";
	String checkDisabledPO =  "disabled"; 
    String checkDisabledSS =  "disabled"; 
    String checkDisabledST =  "disabled"; 
	mode				=	request.getParameter( "mode" );
	bean_id				=	"ParameterBean";
	bean_name			=	"eMM.ParameterBean";
	ParameterBean bean = (ParameterBean)getBeanObject( bean_id, bean_name, request );
bean.setLanguageId(locale);
	bean.clear() ;
	mode	=bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		bean.loadData();
	}
	ArrayList alModuleInstlChk = bean.CheckForEnable();
	for(int i=0;i<alModuleInstlChk.size();i++)
	{
		String stTempModuleChk=(String)alModuleInstlChk.get(i);

		if(i==0&&stTempModuleChk.equals("Y"))
                  checkDisabledPO="";
		if(i==1&&stTempModuleChk.equals("Y"))
				  checkDisabledSS="";
		if(i==2&&stTempModuleChk.equals("Y"))
				  checkDisabledST="";
	}

	String strAuditTrailDisabled="";
	HashMap hshAuditTrail=new HashMap();
	hshAuditTrail=(HashMap)bean.fetchRecord("SELECT  count(SRL_NO) as SRL_NO  FROM MM_PARAMETER_LOG");
	if(((String)hshAuditTrail.get("SRL_NO")).equals("0")){
		strAuditTrailDisabled="disabled";
	}
	//Added for GDOH-CRF-0109 starts
	 		String checkPOMandaoryDisable = "";
			HashMap hashPOMandaoryDisable=new HashMap();
			hashPOMandaoryDisable = (HashMap) bean.fetchRecord(bean.getMmRepositoryValue("SQL_ST_PO_ENTITY_PARAMETERS"),"ZZ");		//"SELECT PO_DETAILS_APPLICABLE_YN, PO_INTERFACE_YN, INTERFACE_TO_EXTERNAL_PO_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'");
			if(hashPOMandaoryDisable.get("INTERFACE_TO_EXTERNAL_PO_YN").equals("Y") ){
				checkPOMandaoryDisable="disabled";
				bean.setPo_mandatory_yn("N");
			} 
	//Added for GDOH-CRF-0109 ends
%>
<form name="formParameter" id="formParameter" >
<br><br>
<table cellpadding=0 cellspacing=0 width="95%"  id="t1" align=center>
<tr>
	<td colspan="3" align="right">
	<input class="button" type="button" name="AuditTrail" id="AuditTrail" value='<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>' onClick="auditTrailLogs();" <%=strAuditTrailDisabled%>>
	</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.DefaultBatchIDifBatchIDisNotApplicable.label" bundle="${mm_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;&nbsp;<input type="text" name="dflt_batch_id" id="dflt_batch_id"  <%=codeDisabled%>  value="<%=bean.getBatchID()%>" size="10" maxlength="10"  >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label" width='35%' ><fmt:message key="eMM.DefaultTradeIDifTradeIDisNotApplicable.label" bundle="${mm_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;&nbsp;<input type="text" name="dflt_trade_id" id="dflt_trade_id"  <%=codeDisabled%>  value="<%=bean.getTradeID()%>" size="25" maxlength="20" >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.AllowBonusEntry.label" bundle="${mm_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;<input type="checkbox" name="receive_bonus_yn" id="receive_bonus_yn"  value="Y" <%=bean.getReceiveBonusYN().equals("Y")?"checked":""%>></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.AllowSampleEntry.label" bundle="${mm_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;<input type="checkbox" name="receive_sample_yn" id="receive_sample_yn" value="Y" <%=bean.getReceiveSampleYN().equals("Y")?"checked":""%>></td>
</tr>
<tr>
  <td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.DecentralizedInventory.label" bundle="${mm_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;<input type="checkbox" name="decentralized_inv_yn" id="decentralized_inv_yn"  value="Y" disabled></td>
</tr>
<tr>
  <td colspan="3">&nbsp;</td>
</tr>
<!-- 	//Added for GDOH-CRF-0109 starts-->
<tr>
	<td  class="label"><fmt:message key="eMM.POMandatory.label" bundle="${mm_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;<input type="checkbox" name="po_mandatory_yn" id="po_mandatory_yn" value="Y" <%=checkPOMandaoryDisable %><%=bean.getPo_mandatory_yn().equals("Y")?"checked":""%>></td>
</tr>
<tr>
  <td colspan="3">&nbsp;</td>
</tr>
<!-- 	//Added for GDOH-CRF-0109 ends -->
<tr>
 <th colspan="3" ><fmt:message key="eMM.PeriodEndScope.label" bundle="${mm_labels}"/></td>
</tr>
<tr>
  <td colspan="3">&nbsp;</td>
</tr>
<tr>
  <td  class="label"><fmt:message key="eMM.PurchaseControl.label" bundle="${mm_labels}"/></td>
  <td class=fields colspan="2">&nbsp;<SELECT name="po_period_end_scope" id="po_period_end_scope"  value="Y" <%=checkDisabledPO%> <%=(!bean.getPo_period_end_scope().equals("N"))?"disabled":""%>>
  <option value="N"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
  <option value="P" <%=(bean.getPo_period_end_scope().equals("P"))?"selected":""%>>Purchase Unit</option>
  <option value="E" <%=(bean.getPo_period_end_scope().equals("E"))?"selected":""%>>Entity</option></SELECT></td>
</tr>
<tr>
  <td colspan="3">&nbsp;</td>
</tr>
<tr>
  <td  class="label"><fmt:message key="eMM.SterileStock.label" bundle="${mm_labels}"/></td>
  <td  class=fields colspan="2">&nbsp;<SELECT name="ss_period_end_scope" id="ss_period_end_scope"  value="Y"  <%=checkDisabledSS%> <%=(!bean.getSs_period_end_scope().equals("N"))?"disabled":""%>>
  <option value="N"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
  <option value="F" <%=(bean.getSs_period_end_scope().equals("F"))?"selected":""%>>Facility Level</option>
  <option value="E" <%=(bean.getSs_period_end_scope().equals("E"))?"selected":""%>>Entity Level</option></SELECT></td>
</tr>
<tr>
  <td colspan="3">&nbsp;</td>
</tr>
<tr>
  <td  class="label"><fmt:message key="eMM.InventoryManagement.label" bundle="${mm_labels}"/></td>
  <td  class=fields colspan="2">&nbsp;<SELECT name="st_period_end_scope" id="st_period_end_scope" value="Y"  <%=checkDisabledST%> <%=(!bean.getSt_period_end_scope().equals("N"))?"disabled":""%>>
  <option value="N"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
  <option value="F" <%=(bean.getSt_period_end_scope().equals("F"))?"selected":""%>>Facility</option>
  <option value="E" <%=(bean.getSt_period_end_scope().equals("E"))?"selected":""%>>Entity</option></SELECT></td>
</tr>
<tr>
  <td colspan="3">&nbsp;</td>
</tr>

</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

