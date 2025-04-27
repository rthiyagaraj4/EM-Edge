<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script> 
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script>-->
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eST/js/SRRReprintCountSheet.js"></script> 
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id = "ReprintCountSheetBean";
		String bean_name = "eST.ReprintCountSheetBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		ReprintCountSheetBean bean = (ReprintCountSheetBean) getBeanObject( bean_id, bean_name, request);  
		bean.clear();
		bean.setLanguageId(locale);

		String store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP WHERE EFF_STATUS = ?","E"));
	%>
	<body onLoad="FocusFirstElement(); " >
		<form name="formReprintCountSheetReportCriteria" id="formReprintCountSheetReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
		<tr>
		<td width='100%' align='center' class="WHITE">
			<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
			<th colspan=8 align=left>&nbsp;&nbsp;<fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			<tr>
				<td class=label align=right><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<select name='p_PHY_INV_ID' id='p_PHY_INV_ID' onchange="getDateValue(p_PHY_INV_ID );" ><option value="" >----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
					ArrayList	arraylist		=	null;
					HashMap		hmItemCode		=	null;	
					String code = "";//String	desc		=	"";
			arraylist		=	bean.getArrayCodeList(facility_id);
				int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("phy_inv_id");
															
					%> 	<option value="<%=code%>"  ><%=code%></option> 	
				<% 	} %>
				
			%></select>	</td>
			
				<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.CountSheetDate.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=10 size=10 name="count_date" id="count_date" value="" onblur="return CheckDate(count_date);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('count_date');" ></img>&nbsp;</td>

               
				
				</tr>

				<tr>
					<td class=label align=right><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_STORE_GR" id="P_STORE_GR" ><%=store_group%>
					</select></td>
			

					 <td class=fields >&nbsp;&nbsp;<fmt:message key="Common.Store.label" bundle="${mm_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_st_code" id="p_st_code" value=""  tabindex='4'><input class="button" onClick="return searchCodeStore(p_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"  tabindex='5'></td>



				</tr>

				<tr>
				<td class=label align=right><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_item_desc" id="p_item_desc" value=""  tabindex='5'><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_item_desc);" type="button" value="?" tabindex='6'><input type="hidden" name="p_item_code" id="p_item_code" value=""></td>


           <td class=fields >&nbsp;&nbsp;<fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></td>
		   <td class=fields colspan=5>&nbsp;&nbsp;<input type='text' name='p_created_By' id='p_created_By' size="20" maxlength="10" value="" readonly ><input type="button" name="req_on_code" id="req_on_code" value="?" class="button" onClick="schduleCreatedByLookup(p_created_By);"></td></tr>



			<tr>	

				<td class=label align=right><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class=fields >&nbsp;&nbsp;<select name='p_report_id' id='p_report_id'>
				<option value="STBPHSHI" > <fmt:message key="eST.ByItem.label" bundle="${st_labels}"/></option>
				<option value="STBPHSHB" > <fmt:message key="eST.ByBinLocation.label" bundle="${st_labels}"/></option> </td>

				<td  class='fields' align=left></td>
				<td class=fields colspan=5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=button name='add' id='add' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='Button'  onClick="searchDetails();"></td>
			</tr>
			<tr >
				<td align="right"  class="label" >&nbsp;&nbsp;</td>
				<td align="right"  class="label" >&nbsp;&nbsp;</td>
			</tr>
			</table>
		</td>
		</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
	<input type="hidden" name="p_reprint " id="p_reprint "		value="Y">
	
	</form>
	<input type="hidden"	name="SQL_ST_USER_LOOKUP_USERACCESS" id="SQL_ST_USER_LOOKUP_USERACCESS"		value="<%=StRepository.getStKeyValue("SQL_ST_USER_LOOKUP_USERACCESS")%>">
	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
	
	
    <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" 
	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
	 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" 
	 value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

