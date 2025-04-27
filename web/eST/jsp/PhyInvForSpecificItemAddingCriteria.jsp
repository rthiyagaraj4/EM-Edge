<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
15/07/2014				43320					Abdul Rabbani	    		  		                       AMRI-CRF-100019
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>     
<head>
<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->	
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/PhyInvForSpecificItem.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<script>
        
    </script>
<%
	String facility_id=(String)session.getValue("facility_id");
// pmd 29/01/05
//	java.util.HashMap defaultParameter = null;
	String bean_id = "PhyInvForSpecificItemBean";
	String bean_name = "eST.PhyInvForSpecificItemBean";
	
	PhyInvForSpecificItemBean bean = (PhyInvForSpecificItemBean) getBeanObject( bean_id, bean_name,request);  
	bean.setFacility_id(facility_id);
	bean.setLanguageId(locale);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
%>
<body onload="load_f_criteria('<%=request.getParameter("disable_temp_id")%>')">
<form name="FormPhyInvForSpecificItemAddingCriteria" id="FormPhyInvForSpecificItemAddingCriteria">
<div align="left">
<table border="1" cellpadding="0" cellspacing="0" width='100%'  align=center>
	<tr>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'   height='30' align=center>
		<tr>
		<td   class="label" width=80></td>
		<td   class="label" width=130><fmt:message key="eST.TemporaryPhyInvID.label" bundle="${st_labels}"/></td>
		<td   class="fields" >
		<select name="temp_id" id="temp_id" disabled="true" onChange="dis_detail(document.FormPhyInvForSpecificItemAddingCriteria);">
		<%=bean.getTempphyid()%>
		</select>
		</td>
		<td   class="label" width=150>&nbsp;</td>
		</tr>
	</table>
	</tr>
	<tr>
<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center >
	<tr>
		<td  class="label" width=80 height=35></td>
		<td  class="label" width=130>Store&nbsp;</td>
		<td  class="fields" width=210 nowrap >
		<select name='store_code' id='store_code' onChange="dis_item_class(this);"><%=bean.getStore()%></select><%=bean.getImage("M")%>
		</td>
		<!--<td class="label" ></td>
		<td class="label" ></td> -->
		 
<!-- 		<td  class="fields">&nbsp;<input class='button' type='button' name='showItem' id='showItem' value='<fmt:message key="eST.AddItems.label" bundle="${st_labels}"/>'  onClick="return fun_submit();" class="label">&nbsp;&nbsp;
		</td>
 --> 
    <!-- ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014 starts -->
	<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>&nbsp;&nbsp;
	<td class='fields' align="left"><input maxLength=4 size=4 name="item_class_code" id="item_class_code" value="" >&nbsp;<input class="button" name = "item_class_lookup" onClick="return searchCodeItemClass(item_class_code);" type="button" value="?"></td>	
	<!-- ends -->
    <td   class="label" width=100>&nbsp;</td>
	</tr>	
	<tr>
	<td  class="label" width=80 height=35></td>
	<td  class="label" width=130><fmt:message key="eST.FromItem.label" bundle="${st_labels}"/>&nbsp;</td>
	<td  class="fields" width=200 nowrap>
	<input type='text'  size='20'  maxlength='20' name='item_codeF' id='item_codeF'  value="">
	
	<input class='button' type='button' name='searchResultF' id='searchResultF' 
	onClick="return searchItemCode(item_codeF);" value='?' class="label"><%=bean.getImage("M")%>
	</td>
	<td  class="label" width=100><fmt:message key="eST.ToItem.label" bundle="${st_labels}"/></td>
	<td  class="fields" nowrap>
	&nbsp;<input type='text'  size='22'  maxlength='20' name='item_codeT' id='item_codeT'  value="">
	<input class='button' type='button' name='searchResultT' id='searchResultT' value='?'  onClick="return searchItemCode(item_codeT);" class="label"><%=bean.getImage("M")%>
	</td>
	<td   class="label" width=100>&nbsp;</td>
</tr>
 <tr>
	<td  class="label" width=80 height=35></td>
	<td  class="label" width=130>&nbsp;</td>
	<td  class="fields" width=210 nowrap >
<!-- 	<select name='store_code' id='store_code'><%=bean.getStore()%></select><%=bean.getImage("M")%>
	</td>
 -->	<td class="label" ></td>
	<td  class="fields">&nbsp;<input class='button' type='button' name='showItem' id='showItem' value='<fmt:message key="eST.AddItems.label" bundle="${st_labels}"/>'  onClick="return fun_submit();" class="label">&nbsp;&nbsp;
	</td>
	<td   class="label" width=100>&nbsp;</td>
</tr>	
 </table>
</table>
</div>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="ST">
<input type="hidden" name="mode" id="mode" value="<%=eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")%>">
<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
<input type="hidden" name="finalized_yn" id="finalized_yn" value="">
<input type="hidden" name="finalize_allowed_yn" id="finalize_allowed_yn" value="Y">
<input type="hidden" name="remarks" id="remarks" value="">
<input type="hidden" name="total_rec" id="total_rec" value="">
<input type="hidden" name="checkBoxVals" id="checkBoxVals" value="">
<input type="hidden" name="temp_disable" id="temp_disable" value="">
<input type="hidden" name="store_code_1" id="store_code_1" value="">  
<input type="hidden" name="item_class_code1" id="item_class_code1" value="">
<input type="hidden" name="item_class_store" id="item_class_store" value="">
<input type="hidden" name="disable_temp_id" id="disable_temp_id" value="<%=request.getParameter("disable_temp_id")%>">
   
<!-- //ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014 -->
<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG_PHY" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG_PHY" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_LANG_PHY")%>">
<!--<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_date,doc_type_code,doc_no">-->
</form>
<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_STORE")%>">
<input type="hidden" name="SQL_ST_ITEM_LOOKUP_LANG" id="SQL_ST_ITEM_LOOKUP_LANG" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP_LANG")%>">
<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP")%>">


<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

