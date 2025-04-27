<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*" %>
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
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
			<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/SuspendedReinstateBatches.js"></script>
		<!-- 		<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<%
		
		String bean_id = "SuspendedReinstateBean";
		String bean_name = "eST.SuspendedReinstateBean";
		//String p_report_id = "STBSTHLD";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		SuspendedReinstateBean bean = (SuspendedReinstateBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formSuspendedReinstateBatches" id="formSuspendedReinstateBatches" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<BR>
			</br>
						<BR>
			</br>			<BR>
			</br>

			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"></td>
				</tr>
				<!--  /** @ 
						 CRF_SRR20056-CRF-0537.1 
						change the batch width 10 to 20

				**/  -->
				<tr>
					<td align="left" class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_Batch_id" id="p_fm_Batch_id" value="" ></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_Batch_id" id="p_to_Batch_id" value="" ></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				
				<!-- <tr>
					<td class=label align=right>Suspend Date</td>
					<td class=label>&nbsp;&nbsp;<input type=text name=Suspend_dt_from size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Suspend_dt_from');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td><td class=label colspan=5>&nbsp;&nbsp;<input type=text name=Suspend_dt_to size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Suspend_dt_to');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td class=label align=right>Revoke Date</td>
					<td class=label>&nbsp;&nbsp;<input type=text name=Revoke_dt_from size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Revoke_dt_from');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td><td class=label colspan=5>&nbsp;&nbsp;<input type=text name=Revoke_dt_to size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Revoke_dt_to');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr> -->
				<tr>
				  <td align="left" class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				  <td align="left" class="fields" >&nbsp;
					<select name=p_status>
					  <option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					  <option value='C'><fmt:message key="eST.Notified.label" bundle="${st_labels}"/></option>
					  <option value='S'><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></option>
					  <option value='A'><fmt:message key="Common.Reinstated.label" bundle="${common_labels}"/></option>
					</select>
				  </td>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
                </tr>

				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBSRBAT">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">

			
			

		</form>
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
            <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">

<%
//putObjectInBean(bean_id,bean,request);
%>	
</body>
</html>

