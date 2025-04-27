<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
6/8/2021		TFS-22264			Shazana										MOHE-CRF-0084.1-US015
---------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*" %>
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
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/ReportStockMovement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

	</head>
	<%
		
		String bean_id = "StockMovementReportBean";
		String bean_name = "eST.StockMovementReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		StockMovementReportBean bean = (StockMovementReportBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
		boolean restrict_stores_user_access_yn =false;//MOHE-CRF-0084.1 START 
	    String strFacilityParam = "";
		String restrictInReportYN = "";
		Connection con				= null; 
		try{
			con						= ConnectionManager.getConnection(request);
		    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");
	    }
		catch(Exception ex)
	    {
	    	ex.printStackTrace();

	    }
	    finally{ 
	    	if(con != null)
	    		ConnectionManager.returnConnection(con,request); 
	    }
		strFacilityParam = bean.getRestrictUserAccessStore();
	
		if(strFacilityParam== null || strFacilityParam.equals(""))
			strFacilityParam = "N"; 
		if(restrict_stores_user_access_yn){
			if(strFacilityParam.equals("Y")){
				restrictInReportYN = "Y";
			}else{
				restrictInReportYN = "N"; 
			}
		}//end 
	
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockMovementReportCriteria" id="formStockMovementReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=5 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
				
				<tr>
					<td class="label" width="20%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td>
					<td class=fields  colspan='4'>&nbsp;&nbsp;<select name="p_report_id" id="p_report_id" onChange="loadcolumn(p_report_id);"  tabindex='1'> 
<option  value='STBMOVIT'><fmt:message key="eST.ByItem.label" bundle="${st_labels}"/></option>
<option  value='STBMOVST'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option
					</select></td>
				</tr>
				
				<tr>
					<td align="right"  width="30%">&nbsp;</td>
					<td class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td align="right" width="10%">&nbsp;</td>
					<td class="fields" width="40%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" width="30%"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<% if(restrict_stores_user_access_yn){ %><!-- MOHE-CRF-0084.1 -->
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value=""  tabindex='2'><input class="button"  onClick="return searchCodeStore1(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"  tabindex='3'></td>
					<%}else{ %>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value=""  tabindex='2'><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"  tabindex='3'></td>
					<%} %>
					<td class="label" width="10%">&nbsp;</td>
					<% if(restrict_stores_user_access_yn){ %> <!-- MOHE-CRF-0084.1 -->
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value=""  tabindex='4'><input class="button" onClick="return searchCodeStore1(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"  tabindex='5'></td>
					<%}else{ %>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value=""  tabindex='4'><input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"  tabindex='5'></td>
					<%} %>
					<td>&nbsp; </td>
				</tr>
				<tr>
					<td class="label" width="30%"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value=""  tabindex='5'><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?" tabindex='6'></td>
					<td class="label" width="10%">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value=""  tabindex='7'><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  tabindex='8'></td>
					<td>&nbsp; </td> 
				</tr>
				<tr>
					<td  class="label" width="30%"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value=""  tabindex='9'><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"  tabindex='10'></td>
					<td class="label" width="10%">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value=""  tabindex='11'><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?" tabindex='12'></td>
					<td>&nbsp; </td>
				</tr>
				<tr>
					<td class=label align=left width="30%"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_alp_code size=10 maxlength=10 value=""  tabindex='13' onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class=label width="10%">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_alp_code size=10 maxlength=10 value="" tabindex='14' onKeyPress="return CheckForSpecialChars(event);"></td>
					<td>&nbsp; </td>
				</tr>


				 <tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>1</td>
					<td class=fields align="left">&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td  class="label" width="10%">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>2</td>
					<td class=fields align="left">&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td>&nbsp; </td>
				</tr>
				<tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>3</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td  class="label" width="10%"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="p_report_option" id="p_report_option" tabindex='17'>
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="M"><fmt:message key="eST.MovedItemsOnly.label" bundle="${st_labels}"/></option>
					<option value="N"><fmt:message key="eST.NonMovedItemsOnly.label" bundle="${st_labels}"/></option>
					</select></td>
					<td>&nbsp; </td>
				   </tr>

				<tr>
					<td class=label  width="30%"><fmt:message key="eST.Excludetheitemsreceivedwithin.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" type=text name=P_EXC_MON size=2 maxlength=2 value="" onblur="return CheckNum(P_EXC_MON);" onKeyPress="return isValidInteger();"  tabindex='15'> <fmt:message key="Common.month.label" bundle="${common_labels}"/>(<fmt:message key="eST.S.label" bundle="${st_labels}"/>)</td>
					<td class=label align=left width="35%" width="10%"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name=P_ORDER_BY  tabindex='16'>
						<option value="trn_qty1 desc"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
						<option value="Item_code"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
						<option value="item_desc"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
					</select></td>
					<td>&nbsp; </td>
					</tr>
				<tr>
					<td class=label align=left width="30%"><fmt:message key="Common.Top.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=2>&nbsp;&nbsp;<input type="text" class="NUMBER" name="p_count" id="p_count" maxLength="8" size="8" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this);"  tabindex='17'> <fmt:message key="Common.item.label" bundle="${common_labels}"/>(<fmt:message key="eST.S.label" bundle="${st_labels}"/>)</td>
					<td class=label width="10%">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;</td>

					</tr>
			<tr></tr>
			<tr></tr>
			</table>
			

			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

			<tr>

			
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="eST.MovementCutoffMonthsSlotRanges.label" bundle="${st_labels}"/></th>
				
				<tr>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 1</td>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 2</td>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 3</td>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 4</td>
				</tr>

				<tr>
					<td class=fields >&nbsp;&nbsp;<input type=text name=p_fr_date1 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"  tabindex='18'></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_date2 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"   tabindex='20' ></td>

					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_date3 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"   tabindex='22'></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_date4 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"  tabindex='24' ></td>

				</tr>

					<tr>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date1 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"   tabindex='19'></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date2 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"   tabindex='21'></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date3 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"   tabindex='23'></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date4 size=3 maxlength=5 value="" onKeyPress="return isValidInteger();"   tabindex='25'></td>

				</tr>
			
				</table>
				</td>
				</tr>

	</table>			
				<tr></tr>
	</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
	
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<input type="hidden" name="p_strFacilityParam" id="p_strFacilityParam"		value="<%=strFacilityParam%>">   <!-- MOHE-CRF-0084.1 -->
</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">

<%
putObjectInBean(bean_id,bean,request);
%>
		
	</body>
</html>	

