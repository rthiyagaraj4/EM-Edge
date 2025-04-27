<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
 <%
  
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StockTransactionTypeReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
	<%
		  String bean_id				=		"StockTransactionTypeReportBean";
		  String bean_name			    =		"eST.StockTransactionTypeReportBean";
		HashMap alstartdate             =        null;
		String facility_id			    =		(String) session.getValue( "facility_id" ) ;
		String user_name			    =		(String) session.getValue( "login_user" ) ;
		StockTransactionTypeReportBean bean	 =		(StockTransactionTypeReportBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		  alstartdate           = bean.getDurationforStartDate();
       String currentdate	    =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	   String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale); 
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockTransactionType" id="formStockTransactionType" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			    <tr>
			    <td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			   <tr><td align="right" colspan=8>&nbsp;</td>
			   </tr>
			    <tr>
				<td class="label" align="left"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
				<td class=fields><input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fm_store_code);"  type="button"  value="?"><%=bean.getImage("M")%></td>
				<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5><input maxLength=6 size=6  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(p_to_store_code);"  type="button" value="?"  ><%=bean.getImage("M")%></td>
			   </tr>
			   <tr> <td align="right" colspan=8>&nbsp;</td></tr>
			    <tr>
				<td class="label" align="left"><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
				<td class=fields ><SELECT name="p_drug_medical_supply" id="p_drug_medical_supply" >
				<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="Y"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="N"><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></OPTION>
				</select>
				<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
				</td>
			    </tr>
			   <tr> <td align="right" colspan=8>&nbsp;</td></tr>
			   <tr>
				 <td class="label" align="left"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
				 <td class=fields><input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
				<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5><input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
		        </tr>
				<tr> <td align="right" colspan=8>&nbsp;</td></tr>
			    <tr>
				<td class="label" align="left"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
				<td class=fields><input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?" ></td>
				<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5><input maxLength=20 size=20  name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  ></td>
				</tr>
				<tr> 
				<td align="right" colspan=8>&nbsp;</td></tr>
                <tr> 
			    <td class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td><td><input type=text name="p_trn_date_from" id="p_trn_date_from" size=10 maxlength=10 class="DATE"  value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_trn_date_from');" ></img><%=bean.getImage("M")%></td>
               <!-- <td class=label ><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/>
			     <fmt:message key="Common.to.label" bundle="${common_labels}"/>  </td><td> -->
				 <td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td>  
			     <input type=text name="p_trn_date_to" id="p_trn_date_to" size=10 maxlength=10 class="DATE" value="<%=currentdate%>"  onBlur="ChekDate(this,'<%=locale%>');checkDocDate(document.forms[0]);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_trn_date_to');" ></img><%=bean.getImage("M")%></td>
			    </tr>  
				<tr> <td align="right" colspan=8>&nbsp;</td></tr>
				 <tr>
				 <td align="left" class="label"><fmt:message key="eST.TransactionType.label" bundle="${st_labels}"/></td>
				 <td class=fields align="left"><select name="p_trn_type" id="p_trn_type" ><%=bean.getTrn_Type_List()%></select></td>
				<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr><td align="right" colspan=8>&nbsp;</td></tr>
				 <td class="label" ><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
				<td><input class="NUMBER" type="text" size="8" maxlength="8"  onKeyPress="return isValidInteger();" name="p_doc_no" id="p_doc_no"  onBlur="return checkIntegerFormat(this);" ></td>
				<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
				<tr><td align="right" colspan=8>&nbsp;</td></tr>
				 <tr>
				 <td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>1</td>
				 <td class=fields align="left"><select name="p_item_anal1_code" id="p_item_anal1_code" ><%=bean.getItemAnal_code_List()%></select> 
				 </td>
				 <td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</td>
				 <td class=fields><select name="p_item_anal2_code" id="p_item_anal2_code" ><%=bean.getItemAnal_code_List()%></select></td>
				 </tr>
				 <tr><td align="right" colspan=8>&nbsp;</td></tr>
				 <tr>
				 <td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3</td>
				 <td class=fields><select name="p_item_anal3_code" id="p_item_anal3_code" ><%=bean.getItemAnal_code_List()%></select></td>
                 <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
				</tr> 
				 <tr><td align="right" colspan=8>&nbsp;</td></tr>
			      <tr>
			      <td  class="label" ><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
				  <td class=fields ><select name="p_report_order" id="p_report_order" >
				        <option value='ID'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
				        <option value='IC'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
				        <option value='Trn'><fmt:message key="eST.TransactionType.label" bundle="${st_labels}"/> Code</option>
						<option  value='IA1'><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1</option>
						<option  value='IA2'><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</option>
						<option  value='IA3'><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3 </option>
						<option  value='D'><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
                       </select></td>	
				  <td  class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<select name="p_eff_status" id="p_eff_status" ></option><%=bean.getNature()%></select></td>
				</tr>
				</table>
				</td>  
				</tr>
			  </table>

			
			<input type="hidden" name="bean_id" id="bean_id"             value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"           value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<input type="hidden" name="p_fm_date" id="p_fm_date" 		     value="">
			<input type="hidden" name="p_to_date" id="p_to_date" 			 value="">
			<input type="hidden" name="p_report_id" id="p_report_id"			  value="STBSTKTRN">
		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"   value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"    value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

