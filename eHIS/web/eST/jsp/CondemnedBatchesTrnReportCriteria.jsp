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
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
         <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/CondemnedBatchesTrnReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		   
		String bean_id = "CondemnedBatchesTrnReportBean";
		String bean_name = "eST.CondemnedBatchesTrnReportBean";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		CondemnedBatchesTrnReportBean bean = (CondemnedBatchesTrnReportBean) getBeanObject( bean_id,bean_name,request);  
		 
		  
		  bean.setLanguageId(locale);
		  bean.clear();
		 
		HashMap alstartdate           = bean.getDurationforStartDate();
      String currentdate	         =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	    =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
		
	%>
	<body onLoad="FocusFirstElement();">
			<form name="formCondemnedBatchesReport" id="formCondemnedBatchesReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
				<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
			<tr>
					<td   class="label" width="20%"><fmt:message key="eST.CondemnID.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" maxLength=10 size=10 name="p_condemn_id" id="p_condemn_id" onpaste="return false;" onKeyPress="return CheckforNumber();"></td> 
					 
			</tr>

			<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td align="right" >&nbsp; </td>
					<td class="fields" colspan=5>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
			</tr>
			<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.CondemnDate.label" bundle="${st_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input type=text name='dt_from' id='dt_from' size=10 maxlength=10 class="DATE" value="<%=currentdateminus%>"  onBlur="CheckDate(this);" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name='dt_to' id='dt_to' size=10 maxlength=10 class="DATE" value="<%=currentdate%>" onBlur="CheckDate(this);" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fm_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=10  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_batch_id" id="p_fm_batch_id" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=10 size=10  name="p_to_batch_id" id="p_to_batch_id" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<!--<tr><td class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=20 size=20 name="p_remarks" id="p_remarks" value="" readonly>
					<input type='button' class='BUTTON' value='?' onClick="searchRemarks(p_remarks_code,p_remarks);"><input type="hidden" name="p_remarks_code" id="p_remarks_code" value=""></td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
				</tr> -->
					</table>
				</td>  

				</tr>
			</table>
		
			<!--<input type="hidden" name="bean_id" id="bean_id" > 
			<input type="hidden" name="bean_name" id="bean_name"  > -->
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id"      value="STBCEBDC" >
		
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">

			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <!--<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <input type="hidden"	name="p_rem_trans_type" id="p_rem_trans_type"			value="CEB"> -->
		</form>
		 <%
//putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

