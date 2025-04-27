<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

		<script language="javascript" src="../../eST/js/SRRStockStatusReportCostValueCriteria.js"></script>
        <script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>			 
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>	     
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>																		   
	<%													   
		
		String bean_id				=		"ReportsStockStatusBean";
		String bean_name			=		"eST.ReportsStockStatusBean";
		//String p_report_id		=		 null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		
		ReportsStockStatusBean bean =		(ReportsStockStatusBean) getBeanObject( bean_id,  bean_name,request  );  
		String p_store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP WHERE EFF_STATUS = ? order by SHORT_DESC","E"));

		
/* Incident No :18071
		
  Change :STBSTKS4 Option is Added 
  Date : 1/11/2010
  By   : Rams
*/
//		bean.setLanguageId(locale);
		bean.clear();
		bean.setLanguageId(locale);

		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockStatusReportCostValueCriteria" id="formStockStatusReportCostValueCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='80%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				<tr>
					<td  class="label" width="20%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" onChange="checkListItem(this)" > 
					<option  value=''>&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
						<option  value='C'><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></option>
						<option  value='A'><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/></option>
						</select><b style="visibility:visible" id="image_style"><%=bean.getImage("M")%> </b></td>
					<td class="label" ><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/> <fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
					<td class="label" ><select name="p_report_order_type" id="p_report_order_type" ><option  value='p_by_store'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
						<option  value='p_by_group'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/> <fmt:message key="Common.Group.label" bundle="${common_labels}"/></option></select><b style="visibility:visible" id="image_style"><%=bean.getImage("M")%> </b></td>   
				</tr>
				<tr><td class='label' colspan='4'>&nbsp;</td></tr>
																										 
				<tr>
					<td  class="label" ><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_STORE_GROUP_fm" id="P_STORE_GROUP_fm" ><%=p_store_group%>
					</select></td>
					 <td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=4>&nbsp;&nbsp;<SELECT name="P_STORE_GROUP_to" id="P_STORE_GROUP_to" ><%=p_store_group%></select></td>	 
				</tr>												   
			   <tr><td class='label' colspan='4'>&nbsp;</td></tr>										    
																										  
				<tr>		    
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="P_STORE_CODE_FM" id="P_STORE_CODE_FM" value="" ><input class="button"  onClick="return searchCodeStore(P_STORE_CODE_FM);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=4>&nbsp;&nbsp;<input maxLength=6 size=6  name="P_STORE_CODE_to" id="P_STORE_CODE_to" value="" ><input class="button" onClick="return searchCodeStore(P_STORE_CODE_to);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
					<tr><td class='label' colspan='4'>&nbsp;</td></tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="P_ITEM_CLASS_FM" id="P_ITEM_CLASS_FM" value="" ><input class="button" onClick="return searchCodeItemClass(P_ITEM_CLASS_FM);" type="button" value="?"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="P_ITEM_CLASS_to" id="P_ITEM_CLASS_to" value="" > <input class="button" onClick="return searchCodeItemClass(P_ITEM_CLASS_to);" type="button" value="?"></td>
				</tr>																	  
				<tr><td class='label' colspan='4'>&nbsp;</td></tr>
				<tr>			  
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" > <input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"> </td>
				</tr>
					<tr><td class='label' colspan='4'>&nbsp;</td></tr>

				  <tr>
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> <fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="P_ITEM_ANAL_LEVEL" id="P_ITEM_ANAL_LEVEL" ><option value="">  ----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------  </option>
					<option value ='1'><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 1</option>
						<option  value='2'><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 2</option>										   
						<option  value='3'><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 3</option></select><b style="visibility:hidden" id="image_style_item"><%=bean.getImage("M")%> </b></td>					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					
					</tr>
					   <tr><td class='label' colspan='4'>&nbsp;</td></tr>

				<tr>
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="P_ITEM_ANAL_FM" id="P_ITEM_ANAL_FM" >
					<option value="">&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					ArrayList	arraylist		=		null;
					HashMap		hmItemCode		=		null;	
					String code					=		"";
					String	desc				=		"";

					arraylist					=		bean.getArrayCodeList();
					int arrLength				=		arraylist.size();
					for(int i=0;i<arrLength; i++)												  
					{
						hmItemCode				=		(HashMap) arraylist.get(i);
						code					=		(String)hmItemCode.get("code");
						desc					=		(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select> <b style="visibility:hidden" id="image_style_item"><%=bean.getImage("M")%> </b></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td> 
					<td class=fields >&nbsp;&nbsp;<select name="P_ITEM_ANAL_to" id="P_ITEM_ANAL_to" >
					<option value="">&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					ArrayList	arraylistto		=		null;
					HashMap		hmItemCodeto		=		null;	
					String codeto					=		"";
					String	descto				=		"";								  

					arraylistto					=		bean.getArrayCodeList();
					int arrLengthto				=		arraylistto.size();
					for(int i=0;i<arrLengthto; i++)
					{
						hmItemCodeto				=		(HashMap) arraylistto.get(i);
						codeto					=		(String)hmItemCodeto.get("code");
						descto					=		(String)hmItemCodeto.get("desc");
					
					%> 	<option value="<%=codeto%>"  ><%=descto%></option> 	
				<% 	} %>
					</select></td>
					
				</tr>

								
				</tr>

					<tr><td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>				   
					<td align="right" class="label" >&nbsp;&nbsp;</td>
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

			
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="P_USER_NAME" id="P_USER_NAME"						value="<%=user_name%>">				 
			<input type="hidden" name="P_FACILITY_ID" id="P_FACILITY_ID"					value="<%=facility_id%>">
			<input type="hidden" name="P_LANGUAGE_ID" id="P_LANGUAGE_ID"					value="<%=locale%>">
			<input type="hidden" name="p_report_id" id="p_report_id"	>
			

		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">		   
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

