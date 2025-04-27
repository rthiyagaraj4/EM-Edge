<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eST.ItemLabelBean" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/ItemLabelCriteriaByBatch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id	 = "ItemLabelBean";
		String bean_name = "eST.ItemLabelBean";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;

		ItemLabelBean bean = (ItemLabelBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formItemLabelCriteriaByBatch" id="formItemLabelCriteriaByBatch" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>

					
				<tr>
					<td align="left" class="label" width='7%'><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields width='45%'>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fr_str_code" id="p_fr_str_code"  value="" onkeyup="clearDesc()"><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fr_str_code);"  type="button" value="?">
					<label id="id_store_desc" ></label><!-- Added by suresh.r on 19-05-2015 against ML-BRU-SCF-1532--></td>
					<!--<td class=label>&nbsp;&nbsp;-->
					<td class="label" width='2%'>&nbsp;</td>
					
				</tr>
				
				<tr>
					 <td  class="label" width='7%'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields width='45%'>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" onkeyup="clearDesc()"><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?">
					<label id="id_item_desc" ></label><!-- Added by suresh.r on 19-05-2015 against ML-BRU-SCF-1532--></td>
					<td class="label" width='2%'>&nbsp;</td>
					
					 </tr>
				<tr>
					 <td  class="label" width='7%'><fmt:message key="eST.AllBatches.label" bundle="${st_labels}"/></label></td>
					 <td class='fields'  width='45%'>&nbsp;&nbsp;<input type="checkbox" name="all_batch_search" id="all_batch_search"  onClick="disable_Batch_Button()"  value=""  ></td>
					 <td class='fields' width='2%'><input type=button name="batch_search_from" id="batch_search_from" class="button"  disabled   onclick="callBatchSearch();"  value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>'></td>
					
					 
					 </tr>
					
				<tr>
					<td class="label" width='7%'><fmt:message key="eST.NoofCopies.label"   bundle="${st_labels}"/></td>
					<td class='fields' width='45%'>&nbsp;&nbsp;<input type=text  name=P_no_labels size=10 maxlength=10 class="NUMBER" value="" onKeyPress="return isValidInteger();" ><IMG   src="../../eCommon/images/mandatory.gif" ></td>
					<td class="label" width='2%'>&nbsp;</td>
					
				</tr>
				

		<tr>
	  <td id=fm_display_dtl_1_bl class="label" nowrap>&nbsp;</td>
	  <td><table><tr><td id=fm_display_dtl_1_bt class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  <td id=fm_display_dtl_1_el class="label"  nowrap>&nbsp;</td>
	  <td id=fm_display_dtl_1_et class="label"  nowrap>&nbsp;</td>
	  <!--<td id=fm_display_slp_1_el class="label"  nowrap>&nbsp;</td>
	  <td id=fm_display_slp_1_et class="label"  nowrap >&nbsp;</td>-->
	  <td id=fm_display_dtl_2 class="label"  nowrap>&nbsp;</td></tr></table></td>
	  <td class="label" width='2%'>&nbsp;</td>
	
	</tr>
	<tr>
	  <td colspan=10>&nbsp;</td>
    </tr>
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBITLB2_BRU">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">

			<input type="hidden"	name="fm_batch_id" id="fm_batch_id"						value="">
			<input type="hidden"	name="fm_expiry_date" id="fm_expiry_date"					value="">

			
</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			

<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

