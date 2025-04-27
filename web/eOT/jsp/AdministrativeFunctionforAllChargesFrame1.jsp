<!DOCTYPE html>
   <%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOR.OrderEntryBillingQueryBean,eST.OTTransactionBean,eST.*,java.sql.*,java.sql.ResultSet,java.util.HashMap,eOR.OrderEntryBillingQueryBean" contentType=" text/html;charset=UTF-8" %> 
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <%@include file="../../eCommon/jsp/Common.jsp" %>
	<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<link rel='StyleSheet' href='../../eCommon/html/<%=request.getParameter("sStyle")%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script Language="javascript" src="../../eOT/js/AdministrativeFunctionforAllCharges.js"></script>
		<script language="JavaScript" src="../../eST/js/Sales.js"></script> 
		<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!--MMS-QH-CRF-0199 -->
		<% String bill_flag = checkForNull(request.getParameter("bill_flag")); %>
<!--MMS-QH-CRF-0199-->
<style type="text/css">		
	.my_dropdown {		    
	    width: 180px ; min-width: 100px; max-width: 200px;		    
	}
	select:focus{width:200px !important;}	
	</style>
	<!--MMS-QH-CRF-0199-->
	<script>
	$(document).ready(function() {
	var maxLength = 30;
	    $('#my_dropdown > option').text(function(i, text) {
	    if (text.length > maxLength) {
	        return text.substr(0, maxLength) + '...';  
	        }
	    });
	});
</script>
<p>
<tr>
						<td><table width="100%" border="0" onclick="createTable_op();">
							<tr>
								<th align="left"><img name="OP_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuOP',this);" />OperationsProcedures
							</tr>
						</table></td>
						</tr>
							
					    <%
						if(("Y").equals(request.getParameter("flag_op"))){
						%>
						<table border='0' cellpadding='0' cellspacing='0' width='100%'  id='moreCriteriaOP' name='moreCriteriaOP' id='moreCriteriaOP' style='visible:hidden;display:none;' 
                        bordercolor='white'> 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing='0' width='100%'  id='moreCriteriaOP' name='moreCriteriaOP' id='moreCriteriaOP' style='display:inline;'  bordercolor='white'> 
						<%}%>
						</table>
						<tr>
						<div id="menuExpand1" style='display:none;visibility:visible;height:60px;width:100%' >
						<table id="OP_arrow" style='display:visible;' >	
                        </table>
						<tr>
						</tr>
						</div>
						</tr>
						<tr>
						<div id="menuExpan1" style='display:none;visibility:visible;height:20px;width:100%' >
						<table>
						<tr>
						<%
						String disable_op="";
                        if(!("A").equals(request.getParameter("oper_finalization_stage")))
                        	disable_op="disabled";	
						if(("Y").equals(request.getParameter("proc_chrg_cmp_yn")))
						{
%>
						<td  class='Label' width="25%">
							<fmt:message key="Common.completed.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
						<input type='checkbox'  class='label' name='oper_compl_yn' id='oper_compl_yn' onClick='validateCheckBox_op(this);' disabled checked>
						</td>	
<%
						}
						else 
						{
%>
						<td  class='Label' width="25%">
							<fmt:message key="Common.completed.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
						<input type='checkbox'  class='label' name='oper_compl_yn' id='oper_compl_yn' onClick='validateCheckBox_op(this);' <%=disable_op%> >
						</td>
<%
						}
%>
						</tr>
						</table>
						</div>
						</tr>
						</tr>
						
						<%if(("Y").equals(request.getParameter("operation_sub_services_yn"))){%>
                        <tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><img name="ASC_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuASC',this);" /><fmt:message key="eOT.AdditionalSurgeryCharges.Label" bundle="${ot_labels}"/></th>
								</tr>
							</table></td>
						</tr>
							<%
						if(("Y").equals(request.getParameter("flag_asc"))){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaASC' name='moreCriteriaASC' id='moreCriteriaASC' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaASC ' name='moreCriteriaASC' id='moreCriteriaASC' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						
						<tr>
						<div id="menuExpandASC" style='display:none;visibility:visible;overflow:auto;height:25px;width:100%'>
						<table id="ASC_arrow" style='display:visible;overflow:auto;'>
                        <tr>
					
						<td align="right">
						<a class="gridLink" id="ASC" href="javascript:callAdditionalCharges();">
						<fmt:message key="eOT.ViewAdditionalCharges.Label" bundle="${ot_labels}"/></a>
						</td>
						</tr>
                        </table>
						</div>
						</tr>

                        <%}%>
						
						<table width="100%" border="0" >
								<tr>
									<th align="left"><img name="DC_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuDC',this);" /><fmt:message key="eOT.DirectConsumption.Label" bundle="${ot_labels}"/></th>
								</tr>
							</table>
						
						<%
						if(("Y").equals(request.getParameter("flag_dc"))){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaDC' name='moreCriteriaDC' id='moreCriteriaDC' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaDC' name='moreCriteriaDC' id='moreCriteriaDC' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						
						<div id="menuExpand3" style='display:none;visibility:visible;overflow:auto;height:60px;width:100%'>
						<table id="DC_arrow" width="100%" style='display:visible;overflow:auto;'  border='0' >
                         
						 <%if((("Y").equals(request.getParameter("rec_packs_in_admin_notes_yn"))) && (("").equals(request.getParameter("consumable_entry_cmp_yn")) ||("N").equals(request.getParameter("consumable_entry_cmp_yn")))){%>
						<tr><td align="left"  colspan='4'>
						<a class="gridLink" id="DC"  style='visibility:hidden;display:none' href="javascript:callOTSalesWindow_admin();">
						<fmt:message key="eOT.ConsumablesUsed.Label" bundle="${ot_labels}"/></a>&nbsp;&nbsp;&nbsp;					
						<a class="gridLink" id="DC_vw"  style='visibility:hidden;display:none;' href="javascript:callOTSalesWindow_view();">
						<fmt:message key="eOT.ViewConsumablesUsed.Label" bundle="${ot_labels}"/></a>&nbsp;&nbsp;&nbsp;
						</td></tr>

						<%}%>
					    <%if((("Y").equals(request.getParameter("rec_packs_in_admin_notes_yn"))) && ("Y").equals(request.getParameter("consumable_entry_cmp_yn"))){%>
						
						<tr><td align="left"  colspan='4'>
						<a class="gridLink" id="DC"  style='visibility:hidden;display:none;' ></a>	
						<a class="gridLink" id="DC_vw"  style='visibility:hidden;display:none;' href="javascript:callOTSalesWindow_view();">
						<fmt:message key="eOT.ViewConsumablesUsed.Label" bundle="${ot_labels}"/></a>	</td></tr>
						<%}else if((("N").equals(request.getParameter("rec_packs_in_admin_notes_yn"))) ) {%>
							<td align="right" width='100%'><a class="gridLink" id="DC"  style='visibility:hidden;display:none;' ></a>	
						<a class="gridLink" id="DC_vw"  style='visibility:hidden;display:none;' ></a></td>
						<%}%> 
						
						</table>
						</div>
						
						<%if(("Y").equals(request.getParameter("rec_implants_in_admin_notes_yn"))|| ("Y").equals(request.getParameter("rec_packs_in_admin_notes_yn")) || ("Y").equals(request.getParameter("rec_equp_in_admin_notes_yn")) || ("Y").equals(request.getParameter("rec_instr_in_admin_notes_yn")))
	                   {%>
   						<tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><img name="AC_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuAC',this);" /><fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/></th>
								</tr>
							</table></td>
						</tr>
							<%
						if(("Y").equals(request.getParameter("flag_ac"))){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaAC' name='moreCriteriaAC' id='moreCriteriaAC' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaAC' name='moreCriteriaAC' id='moreCriteriaAC' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						<%}%>
						
</p>

