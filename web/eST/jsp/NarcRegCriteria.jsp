<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.sql.*, java.lang.*,eST.*, eST.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/NarcReg.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id					=		"MonthlySummaryReportBean";
		String bean_name				=		"eST.MonthlySummaryReportBean";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
				
		MonthlySummaryReportBean bean = (MonthlySummaryReportBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
		String []stParameters=	{facility_id, "ALL"};
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		
		String curr_proc_month =(String)hmRecord.get("CURR_PROC_MONTH");		
		String curr_proc_year  = com.ehis.util.DateUtils.convertDate((String)hmRecord.get("CURR_PROC_YEAR"),"YY","en",locale);
	    String LoginFacilityId			=		bean.getLoginFacilityId();
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="NarcRegCriteria" id="NarcRegCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left>Report Criteria</th>
				
				<tr>
					<td align="left" class="label">Store</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_str_code" id="p_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick=" searchCodeStore(p_str_code);"  type="button"  value="?"><img src="../../eCommon/images/mandatory.gif" align="center"></img></td></td>
					<td align="left" class="label">Item</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_item_code" id="p_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_item_code);" type="button" value="?" ><img src="../../eCommon/images/mandatory.gif" align="center"></img></td></td>
					<td class="label">&nbsp;</td>

				</tr>
								
				<tr>
					<td align="left">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;From</td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label" colspan=5 width"10%">&nbsp;&nbsp;To</td>
				</tr>
				<tr>	
					<td align="left" class="label">Month/Year</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_from_month" id="p_from_month" value="<%=curr_proc_month%>" onBlur="Pfrmmnth();" onKeyPress="return isValidInteger();"  class="NUMBER"> 
					<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_from_year" id="p_from_year" value="<%=curr_proc_year%>" onBlur="Pfrmyear();" onKeyPress="return isValidInteger();"  class="NUMBER"><img src="../../eCommon/images/mandatory.gif" align="center"></img>   </td> 
				 <td align="left" class="label">Month/Year</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_to_month" id="p_to_month" value="<%=curr_proc_month%>" onBlur="Ptomnth();" onKeyPress="return isValidInteger();"  class="NUMBER"> 
					<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_to_year" id="p_to_year" value="<%=curr_proc_year%>" onBlur="Ptoyear();" onKeyPress="return isValidInteger();"  class="NUMBER"><img src="../../eCommon/images/mandatory.gif" align="center"></img>   </td> 
				 	<td class="label">&nbsp;</td>
				 </tr>
				
				
				
				
			   <!--  <tr>
					<td align="right" class="label">Print Technical Specification</td>
					<td align="left">&nbsp;<input type="checkbox" value="E" name="print_spec" id="print_spec"></td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr> -->
                
				</table>
				</td>  

				</tr>
			</table>

			
			
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id" value="STBNARDC">
			<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="curr_proc_month" id="curr_proc_month"					value="<%=curr_proc_month%>">
			<input type="hidden" name="curr_proc_year" id="curr_proc_year"					value="<%=curr_proc_year %>">
			
		</form>
		          
			</body>
</html>	

