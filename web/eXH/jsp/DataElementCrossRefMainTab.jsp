<!DOCTYPE html>
<HTML> 
<HEAD>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params="";
params=(String)session.getAttribute("params");
params=params+"&expand="+"&home_required_yn=N";
session.setAttribute("params",params);
String source=request.getParameter("source");
//System.out.println("source"+source);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<!--<script language='javascript' src='../../eXH/js/DataElementCrossReference.js'></script>--->
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferencebasicelement.js" ></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY  leftmargin=0 topmargin=0  bgcolor='' onload="callJSPs('element_dtl')" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="MasterMenu_form" id="MasterMenu_form" action='' method='get' target='messageFrame'>
	
		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
        <tr><td>
		<ul id="tablist" class="tablist" >
		 <li class="tablistitem" title='<fmt:message key="eXH.Elements.Label" bundle="${xh_labels}"/>'>
				<a onclick="callJSPs('element_dtl')" class="tabA" id="element_dtl" >
					<span class="tabAspan" id="element_dtl_tabspan"><fmt:message key="eXH.Elements.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
			<!----<li class="tablistitem" title="Filter_ID">
				<a onclick="callJSPs('Filter_id')" class="tabA" id="Filter_id" >
					<span class="tabAspan" id="Filter_id_tabspan">Filter Layer</span>
				</a>
		   </li>----------->
			<li class="tablistitem" title='<fmt:message key="eXH.TransactionLayer.Label" bundle="${xh_labels}"/>'>
				<a onclick="callJSPs('appl_cross')" class="tabA" id='appl_cross' >
					<span class="tabAspan" id="appl_cross_tabspan"><fmt:message key="eXH.TransactionLayer.Label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			<li class="tablistitem" title="Derivation-ID">
				<a onclick="callJSPs('Derivation_id')" class="tabA" id="Derivation-ID" >
					<span class="tabAspan" id="Derivation-ID_tabspan"><fmt:message key="eXH.DerivationLayer.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
			 <li class="tablistitem" title="Element-ID">
				<a onclick="callJSPs('element_id')" class="tabA" id="element_id" >
					<span class="tabAspan" id="element_id_tabspan"><fmt:message key="eXH.EncodingLayer.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
<li class="tablistitem" title="Rearrange-ID">
				<a onclick="callJSPs('Rearrange_id')" class="tabA" id="Rearrange_id" >
					<span class="tabAspan" id="Rearrange_id_tabspan"><fmt:message key="eXH.RearrangementLayer.Label" bundle="${xh_labels}"/></span> 
				</a>
		   </li>

<li class="tablistitem" title="Standard-ID">
				<a onclick="callJSPs('Standard_id')" class="tabA" id="Standard_id" >
					<span class="tabAspan" id="Standard_id_tabspan"><fmt:message key="eXH.StandardLayer.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		    
		   </ul>
	 </td>
   </tr>
</table>

		<input type='hidden' name='tab' id='tab' value='element'/>
		<input type='hidden' name='action_type' id='action_type' value='S'/>
<input type='hidden' name='source' id='source' value='<%=source%>'/>
</form>	
</BODY>
</HTML>


