<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page import ="eSS.ReportsMasterCodeBean, eSS.Common.* ,java.util.*,java.sql.*, eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%><!-- added for 21480 --> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------------
*/ %> 
<html>
	<head>
		<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale= (String)session.getAttribute("LOCALE");

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<!-- <script language="javascript" src="../../eSS/js/SsMessages.js"></script> -->
		<script language="javascript" src="../../eSS/js/MasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
			String bean_id = "reportsMasterCodeBean";
		String bean_name = "eSS.ReportsMasterCodeBean";
//		String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		ReportsMasterCodeBean bean = (ReportsMasterCodeBean) getBeanObject( bean_id,bean_name, request );  
		bean.clear();
		Connection con			= null;//MMOH-CRF-1661 START
		boolean linen_applicable_yn =false;
		try{
			con				= ConnectionManager.getConnection(request);
			linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
			if(linen_applicable_yn){
				bean.setLinen_applicable_yn("Y");
			}else{
				bean.setLinen_applicable_yn("N");   
			}
		} 
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in ReportGroup.jsp..");  
		} 
		finally{
			if(con != null)
	    		ConnectionManager.returnConnection(con,request);
		}
		
		
	%>
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formReportGroup" id="formReportGroup" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
			</tr>
			<tr>
					<td align="right" class="label"><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<select name="p_group_code" id="p_group_code" >
					<%=bean.getGroupCode()%>
					</select></td>
					<!-- Added against KDAH_CRF_0247-->
					<td class="label"><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="P_Surgery_Type" id="P_Surgery_Type" value="" maxLength='10' size='8' ><input type='button' class='BUTTON' value='?' onClick="callSurgeryTypeSearchWindow(P_Surgery_Type);"  ></td>
				</tr>
				<!--tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr-->
				<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_group_code" id="p_fm_group_code" value=""  ><input class="button" onClick="return searchCodeGroup(p_fm_group_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_group_code" id="p_to_group_code" value=""  ><input class="button" onClick="return searchCodeGroup(p_to_group_code);" type="button" value="?"></td>
					</tr>
					<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					</tr>
					<tr>
					<td align="right" class="label"><fmt:message key="eSS.ItemClass.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=15 size=15 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=15 size=15 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class=label colspan='3'>&nbsp;&nbsp;<select name="p_nature" id="p_nature" >
					<%=bean.getNature()%>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
				      <!-- Added by Rabbani #inc no:40147(ML-BRU-SCF-0854) on 21-MAY-2013 -->
					<td align="right" class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" >
					<%=bean.getReportType()%>
					</select></td>
					<!-- ends -->
					<td align="right" class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class=label colspan='2'>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
					<%=bean.getOrderByGroup()%>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<!--tr>
					<td align="right" class="label" >Report Type</td>
					<td class=label colspan='3'>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" >
					<%=bean.getReportType()%>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr-->
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="SS">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="SSBGROUP">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">


			<!-- Commented against ML-BRU-SCF-0854.1[41892]
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_FOR_REPORT" id="SQL_SS_GROUP_LOOKUP_FOR_REPORT" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">-->
			<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ITEM_LOOKUP")%>">
			<!-- Added against ML-BRU-SCF-0854.1[41892]-->
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_REPORT" id="SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_REPORT" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_REPORT")%>">
			<!-- Added against KDAH_CRF_0247-->
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_SURG_TYPE_REPORT" id="SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_SURG_TYPE_REPORT" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_SURG_TYPE_REPORT")%>">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

