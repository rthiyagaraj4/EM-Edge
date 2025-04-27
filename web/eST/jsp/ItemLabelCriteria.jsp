<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    			Name				Rev. Date		Rev. By			Description
----------------------------------------------------------------------------------------------------------------------------------

02/08/2017		MMS-DM-CRF-099.2			Shazana hasan		02/08/2017				Chandra				Modified for MMS-DM-CRF-099.2
------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>


<%-- JSP Page specific attributes start --%>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" import="eST.ItemLabelBean" %>
<%--JSP Page specific attributes end --%>
<%--Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%--Mandatory declarations end --%>
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
		<script language="javascript" src="../../eST/js/ItemLabelCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id	 = "ItemLabelBean";
		String bean_name = "eST.ItemLabelBean";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		String store_code_list			=	"";//Added for NMC-JD-CRF-0208
		
		// Added for MMS-DM-CRF-099.2 start
		Connection	con=null;
		boolean site=false;
		boolean label_by_store =false;
		try{
			con	= ConnectionManager.getConnection(request);
			 site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","GRN_VIEW_REPORT");
			 label_by_store = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_ITEM_LABEL_BY_STORE");//Added for NMC-JD-CRF-0208
			System.out.println("Site==>"+site);
			//bean.setIssite(site);
			
		}
		finally
		{
			con.close();
		}	
		// Added for MMS-DM-CRF-099.2 END
		ItemLabelBean bean = (ItemLabelBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		store_code_list  = bean.getStore_code_List();//Added for NMC-JD-CRF-0208
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formItemLabelCriteria" id="formItemLabelCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
			
				<tr>
					<td align="left" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=label>
					<INPUT id=radio2 type=radio name=radio1  CHECKED onCLick="GRNChecked();" class="label">
					<fmt:message key="eST.ByGRN.label" bundle="${st_labels}"/></td>
					<td class=label >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<INPUT id=radio2 type=radio name=radio3  onCLick="ITEMChecked();" class="label">
					<fmt:message key="eST.ByItem.label" bundle="${st_labels}"/><td align="right" class="label"></td>
<%               if(label_by_store){
%>
					<td class=label >
					<INPUT id=radio2 type=radio name=radio4  onCLick="STOREChecked();" >
					<fmt:message key="eST.ByStore.label" bundle="${st_labels}"/><td align="right" class="label"></td>
					<td class=label><td align="right" class="label"></td>
<% }else{%>
                    <td class=fields class="label">
					<INPUT id=radio2 type=radio name=radio4  onCLick="STOREChecked();" style ="visibility:hidden">
					</td>
					<td class=label><td align="right" class="label"></td>
<%}%>
				</tr>
              <tr>
			   <td colspan="7"> &nbsp;&nbsp;</td>
			  </tr>
				
				<tr>
      				
					<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20  size=20   name="p_fm_item_code" id="p_fm_item_code"  value="" disabled><input class="button" name="p_fm_sr2" id="p_fm_sr2" disabled onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class=label >&nbsp;&nbsp;<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 disabled 
					name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" disabled name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
					<td align='right' class='label' id = "store_lb" style="display:none"><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                    <td align='left' class=label  id = "p_store_code_lb" style="display:none"><select id='p_store_code' name="p_store_code" id="p_store_code" value="?" ><%=store_code_list%></select>&nbsp;<img id='store_img' src='../../eCommon/images/mandatory.gif' align='center' style="display:none"><input type="hidden" name="store_id" id="store_id" value="" size="15"></td>
                 </tr>
				 <tr>
			   <td colspan="7"> &nbsp;&nbsp;</td>
			  </tr>
				 <tr>
					<td align="left" class="label" ><fmt:message key="eST.GRNDocType.label"   bundle="${st_labels}"/></td>
					<td class=label  COLSPAN=7>&nbsp;&nbsp;<select name="p_doc_type_code" id="p_doc_type_code" ><%=bean.getDoc_type_code_ListOptions("GRN","")%></select>&nbsp;&nbsp;
				<%if(site){%>
					<!-- Added for MMS-DM-CRF-099.2 -->
					
					<fmt:message key="eST.DocNo.label" bundle="${st_labels}"/>
					<input maxLength=20 size=10 name="p_doc_no" id="p_doc_no" value="" >
					<input class="button" name="p_grn_no" id="p_grn_no" onClick="return searchGrnNum(p_doc_no,p_doc_type_code);" type="button" value="?"> <!-- Added for MMS-DM-CRF-099.2 -->
					<IMG id='doc_type_mnd' style="visibility:visible" src="../../eCommon/images/mandatory.gif" > </td>
					<%}
				else{
				%>
				<input maxLength=20 size=10 name="p_doc_no" id="p_doc_no" value="" > 
				<IMG id='doc_type_mnd' style="visibility:visible" src="../../eCommon/images/mandatory.gif" > </td>
				<%} %>
				</tr>    
				<tr>
			   <td colspan="7"> &nbsp;&nbsp;</td>
			  </tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.NoofCopies.label"   bundle="${st_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<input type=text disabled name=P_no_labels id=P_no_labels size=10 maxlength=10 class="NUMBER" value="" onKeyPress="return isValidInteger();" ><IMG id='no_of_cp_mnd' style="visibility:hidden" src="../../eCommon/images/mandatory.gif" ></td>
				</tr>
				<tr>
			   <td colspan="7"> &nbsp;&nbsp;</td>
			  </tr>
				<td class=label align=right></td>
					<td class=label colspan=7>&nbsp;&nbsp;</td>
				<tr>
					<td class=label colspan=6>&nbsp;&nbsp;</td>
					<td class="button"><input type="button" class="button" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' name="print_report" id="print_report" onClick="printReports()">
					&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="Common.view.label" bundle="${common_labels}"/>' name="view_report" id="view_report"onClick="viewLabels()">
				</tr>

				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBITLBL">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>"> 
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<!-- INC NO 49291 -->
			<input type="hidden" name="dest_locn_type" id="dest_locn_type"			value="S">
			<input type="hidden" name="dest_locn_code" id="dest_locn_code"			value="PARAMETER_WILL_BE_PASSED">
			<!--//Added By Rabbani #Inc no: 49630 on 16-Jun-2014 -->
			<input type="hidden" name="P_OFFLINE" id="P_OFFLINE"			     value="Y">
			<input type="hidden" name="site" id="site"			     value="<%=site%>"><!--Added by Shazana for MMS-DM-CRF-099.2-->
			
</form>
			<input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			

<%
	putObjectInBean(bean_id,bean,request);
%>
	<script>
		parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
	</script>
	</body>
</html>	

