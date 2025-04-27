<!DOCTYPE html>
<%@page  import="java.util.*,java.sql.*, java.lang.*,eST.VMISalesOrConsumptionReportBean, eST.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/VMISalesOrConsumption.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"VMISalesOrConsumptionReportBean";
		String bean_name			=		"eST.VMISalesOrConsumptionReportBean";
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		
		
		VMISalesOrConsumptionReportBean bean =  (VMISalesOrConsumptionReportBean) getBeanObject(bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));

		String  Date1 =null;
		String  month =null;
		String  to_date =  com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();

		/*String bean_id1				=		"GoodsReceivedNoteBean";
		String bean_name1			=		"eST.GoodsReceivedNoteBean";

		GoodsReceivedNoteBean bean1	=		(GoodsReceivedNoteBean) getBeanObject(bean_id1,bean_name1,request);
		bean1.clear();
		bean1.setLanguageId(locale);*/
		String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

		String []stParameters		=		{bean.getLoginFacilityId(), "ALL"};
		HashMap hmRecord			=		null;
		hmRecord					=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		
		String curr_proc_month		=		(String)hmRecord.get("CURR_PROC_MONTH");
		String curr_proc_year		=		(String)hmRecord.get("CURR_PROC_YEAR"); 
		String LoginFacilityId		=		bean.getLoginFacilityId();
		%>

	<body onLoad="FocusFirstElement();changeReport();">

		<form name="VMISalesOrConsumptionCriteria" id="VMISalesOrConsumptionCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
							
				<tr>
					<td  class="label">Report Type</td>&nbsp;
					<td class=fields colspan=10>&nbsp;&nbsp;<SELECT name="p_report_type" id="p_report_type"  >
					<!--<option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> -->
					<OPTION VALUE="C"><fmt:message key="eST.Supplier wise Sales and Consumption Report.label" bundle="${st_labels}"/></OPTION>
					<!--<OPTION VALUE="S"><fmt:message key="eST.Supplier Wise Stock Report.label" bundle="${st_labels}"/></OPTION>
					<OPTION VALUE="P"><fmt:message key="eST.Product/Batch Wise Report.label" bundle="${st_labels}"/></OPTION>
					<OPTION VALUE="T"><fmt:message key="eST.Transaction Register For The Period.label" bundle="${st_labels}"/></OPTION>-->
					</select></td>
					</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.SupplierCode.label" bundle="${common_labels}"/></td>&nbsp;
					<td class='fields'>&nbsp;&nbsp;<select name='p_supp_code' id='p_supp_code' value="<%=bean.getSupp_code()%>" >
					<%
						out.println(bean.getSupp_code_List());
					%>
		</select>
					
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=15 size=15 name="p_store_code" id="p_store_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_store_code);"  type="button" value="?"></td>
					</tr>
				
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=15 size=15  name="p_item_code" id="p_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_item_code);" type="button" value="?"></td>
					</tr>
				
				<tr>
					<td class=label align="left"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
					<td class='fields'>
			&nbsp;
			<%
			Connection	con 		= null;
			Statement   stmt		= null;
			ResultSet   resultSet   = null;
				
			try{
				
				String sql= "select 01||'/'||CURR_PROC_MONTH||'/'||CURR_PROC_YEAR Date1 FROM ST_FACILITY_PARAM WHERE FACILITY_ID='"+LoginFacilityId+"' ";
             
				con		  = ConnectionManager.getConnection(request);
				stmt      = con.createStatement();
				resultSet = stmt.executeQuery(sql);

				if (resultSet != null && resultSet.next()) {
				Date1	 =  (String)resultSet.getString("Date1");
				month    =   com.ehis.util.DateUtils.convertDate(Date1,"DMY","en",locale ).toString();
				}
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}finally{
    			ConnectionManager.returnConnection(con,request);
			}
			%>
		
			<input type="text"  name="p_fr_doc_date" id="p_fr_doc_date" size="8" maxlength="10" class="DATE" value="<%=month%>" onBlur="CheckDate(this, '<%=locale%>');"  class="NUMBER"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_doc_date');"></img><%=bean.getImage("M")%>
			<td class=label align="left"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td><td  class=fields colspan=5>&nbsp;&nbsp;<input type=text name="p_to_doc_date" id="p_to_doc_date" size="8" maxlength="10" class="DATE" value="<%=to_date%>" onBlur="CheckDate(this,'<%=locale%>');" class="NUMBER" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>

			<tr>
			<td align="left" class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<select name="p_doc_type_code" id="p_doc_type_code"><%=bean.getDoc_type_code_ListOptions()%></select></td></td>
			</tr>
		
		    <!--<tr>
			<td class=label align=right width="30%"><font style="visibility:visible" id = 'p_vat_style'><fmt:message key="eST.VAT.label" bundle="${st_labels}"/></font></td>
			<td class=fields>&nbsp;&nbsp;<input type="text" size="8" maxlength="8" class='NUMBER' name="p_vat" id="p_vat" onKeyPress="return isValidInteger();" id="p_count_style" style="visibility:visible"><font style="visibility:visible" id = 'p_item_style'>&nbsp%</font></td>
			</tr>-->
			
			
			</table>
			</td>  

			</tr>
			</table>
			
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id"							value="">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
    </form>
		<%
        putObjectInBean(bean_id,bean,request);
        %>
	</body>
</html>	

