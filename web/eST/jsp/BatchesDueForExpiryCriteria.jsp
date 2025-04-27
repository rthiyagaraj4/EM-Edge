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
	<%@page contentType="text/html;charset=UTF-8" import="eST.Common.* ,eST.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*,java.util.*,java.lang.*" %>
	<%-- JSP Page specific attributes end --%>
	<%-- Mandatory declarations start --%>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%-- Mandatory declarations end --%>
	<html>
		<head>
<!-- 			<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
			<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
			<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language="javascript" src="../../eST/js/BatchesDueForExpiry.js"></script>
			<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<%
			
			
			//String p_report_id = null;
			String facility_id  =  (String) session.getValue( "facility_id" ) ;
			String user_name  =  (String) session.getValue( "login_user" ) ;
					
			
			String bean_id = "CondemnExpiredBatchesHeaderBean";//added for MOHE-CRF-US015 START
			String bean_name = "eST.CondemnExpiredBatchesHeaderBean";		
			CondemnExpiredBatchesHeaderBean bean = (CondemnExpiredBatchesHeaderBean) getBeanObject( bean_id,  bean_name, request );  
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
		    	System.out.println("Exception in BatchesDueForExpiryCriteria.jsp...");
		    }
		    finally{ 
		    	if(con != null)
		    		ConnectionManager.returnConnection(con,request); 
		    }
			strFacilityParam = bean.getRestrictUserAccessStore();
			//System.out.println("strFacilityParam: "+strFacilityParam);   
			if(strFacilityParam== null || strFacilityParam.equals(""))
				strFacilityParam = "N"; 
			if(restrict_stores_user_access_yn){
				if(strFacilityParam.equals("Y")){
					restrictInReportYN = "Y";
				}else{
					restrictInReportYN = "N"; 
				}
			}//end 
			//System.out.println("restrictInReportYN: "+restrictInReportYN);
		%>
		<body onLoad="FocusFirstElement();">
			<form name="BatchesDueForExpiryCriteria" id="BatchesDueForExpiryCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
			<br><br>
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
				<tr>
				<td width='100%' align='center' class="WHITE">
					<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
					<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
					<tr>
						<td align="left" class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
						<td class=fields colspan=7>&nbsp;&nbsp;<SELECT name="p_report_id" id="p_report_id" >
						<OPTION VALUE="STBDUEXP"> <fmt:message key="eST.ByItem.label" bundle="${st_labels}"/> </OPTION>
						<OPTION VALUE="STBDUEST"> <fmt:message key="eST.ByStore.label" bundle="${st_labels}"/> </OPTION>
						
						</select></td>

					</tr>
					
					<tr>
						<td align="right" width="22%">&nbsp;</td>
						<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td align="right" >&nbsp;</td>
						<td class="fields" colspan=5  width="49%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					
					<tr>
						<td class=label align='left'><fmt:message key="Common.CutOffDate.label" bundle="${common_labels}"/></td>
						<td class=fields colspan=2>&nbsp;&nbsp;<input type=text name='dt_from_1' id='dt_from_1' size=10 maxlength=10 class="DATE" value="" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');" ><!-- CheckDate(this); removed for Leap year issue, added CheckDateLeap(this,'DMY','<%=locale%>') by Badmavathi for SRR20056-SCF-10463 -->
						<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from_1');" ></img>
						<img src='../../eCommon/images/mandatory.gif' >&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td class="label"></td><td class=fields colspan=5><input type=text name='dt_to_1' id='dt_to_1' size=10 maxlength=10 class="DATE" value="" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');" > <!-- CheckDate(this); removed for Leap year issue, added CheckDateLeap(this,'DMY','<%=locale%>') by Badmavathi for SRR20056-SCF-10463 -->
						<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to_1');" ></img><img src='../../eCommon/images/mandatory.gif' >&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					
					<tr>
						<td align="left" class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
						<% if(restrict_stores_user_access_yn){ %><!-- MOHE-CRF-0084.1- US015 -->
						<td class=fields >&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_str_code" id="p_fm_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore1(p_fm_str_code);"  type="button" value="?"></td>
						<%}else{ %>
						<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_str_code" id="p_fm_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fm_str_code);"  type="button" value="?"></td>
						<%} %> 
						<td class="label">&nbsp;</td> 
						<% if(restrict_stores_user_access_yn){ %>
						<td class=fields colspan=5><input maxLength=6 size=6  name="p_to_str_code" id="p_to_str_code" value="" > <input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore1(p_to_str_code);"  type="button" value="?" ></td>
						<%}else{ %>
						<td class=fields colspan=5><input maxLength=6 size=6  name="p_to_str_code" id="p_to_str_code" value="" > <input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(p_to_str_code);"  type="button" value="?" ></td>
						<%} %>
					</tr>
					
					<tr>
						<td align="left" class="label" ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
						<td class=fields colspan="2">&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
						<td class="label"></td>
						<td class=fields colspan="1"><input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  ></td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
						<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
						<td class="label">&nbsp;</td>
						<td class=fields colspan=5><input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
					</tr>
					<tr>
						<td class=label align='left'><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
						<td class=fileds>&nbsp;&nbsp;<input type=text name=p_fr_alp_code size=10 maxlength=10  value="" onKeyPress="return CheckForSpecialChars(event);"></td>
						<td class="fields">&nbsp;</td><td class=fields colspan=5><input type=text name=p_to_alp_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					</tr>
					<tr>
						<td class=label align='left'><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
						<td class=fields>&nbsp;&nbsp;<input type=text name=p_batch_id size=10 maxlength=10 value="" ></td>
						<td align="left" class="label" width="20%"><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
						<td class=fields colspan=7><SELECT name="p_report_order" id="p_report_order" >
						<OPTION VALUE="IC"> <fmt:message key="eST.ByItemCode.label" bundle="${st_labels}"/></OPTION>
						<OPTION VALUE="SD"> <fmt:message key="eST.ByShortDescription.label" bundle="${st_labels}"/>  </OPTION>
						</select></td>
					</tr>
					</table>
					</td>  
					</tr>
				</table>
				<input type="hidden" name="dt_from" id="dt_from" 			value="">
				<input type="hidden" name="dt_to" id="dt_to" 				value="">
				<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
				<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
				<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
				<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">  
				<input type="hidden" name="p_strFacilityParam" id="p_strFacilityParam"		value="<%=strFacilityParam%>"><!-- MOHE-CRF-0084.1 -->
			<!-- <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">--><!--MOHE-CRF-0084.1 query added directly in js page -->
			<!--<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>"> -->
			<!--<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>"> --><!--MOHE-CRF-0084.1 END -->
				

			</form>
		</body>
	</html>	

