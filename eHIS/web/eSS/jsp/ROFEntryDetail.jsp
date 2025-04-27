<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%> 
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001  
---------------------------------------------------------------------------------------------------------------
*/ %>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="eSS.ROFEntryBean,eSS.*,eSS.Common.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<html>
	<head>
<%		
		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale= (String)session.getAttribute("LOCALE");

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ROFEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id			=		"rofEntryBean";
		String bean_name		=		"eSS.ROFEntryBean";
		ROFEntryBean bean		=		(ROFEntryBean)getBeanObject( bean_id, bean_name, request ) ;

		String function_id		=		bean.checkForNull(request.getParameter("function_id"));
		String mode				=		bean.checkForNull(request.getParameter("mode"));
		String group_code		=		bean.checkForNull(request.getParameter("group_code"));
		String tray_no			=		bean.checkForNull(request.getParameter("tray_no"));
		String group_desc		=		"";
		String contaminated_yn	=		"";
		String sterile_type		=		"";
		String wash_type		=		"";
		String group_type_code  =		"";
		String editing_key		=		"";
		String checked			=		"";
		String cmdMode			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");

		String disabled			=		"";
		String readOnly			=		"";
		Connection con			= null;//MMOH-CRF-1661 START
		boolean linen_applicable_yn =false;
		try{
			con				= ConnectionManager.getConnection(request);
			linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
			if(linen_applicable_yn){
				bean.setLinenApplicableYN("Y"); 
			}else{
				bean.setLinenApplicableYN("N");  
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in ROFEntryDetail.jsp..");  
		} 
		finally{
			if(con != null)
	    		ConnectionManager.returnConnection(con,request);
		}//end 


		bean.setMode(mode);
		bean.setLanguageId(locale);
		tray_no					=		bean.checkForNull(tray_no);
		String[] detail			=		null;
		String selected_key		=		request.getParameter("selected_key");
		if (selected_key != null) {
			detail				=		bean.getDetail(selected_key);
			
			group_code			=		detail[0];
			group_desc			=		detail[1];
			tray_no				=		detail[2];
			contaminated_yn		=		detail[3];
			sterile_type		=		detail[4];
			wash_type			=		detail[5];
			group_type_code		=		detail[6];
			editing_key			=		detail[0]+"-"+detail[2];
			
			if (contaminated_yn.equals("Y"))	{
				checked			=		"checked";
			}
			bean.setSterile_type(sterile_type);
			bean.setWash_type(wash_type);
			cmdMode				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
			disabled			=		"disabled";
			readOnly			=		"readOnly";

		}

	%>
	<body onMouseDown="CodeArrest()">
		<form name="formROFEntryDetail" id="formROFEntryDetail">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<select name="group_type_code" id="group_type_code" <%=disabled%>><%=bean.getGroupTypes(group_type_code)%></select></td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<input type="text" name="group_desc" id="group_desc" maxlength=15 size=15 value="<%=group_desc%>" <%=readOnly%>><input class="button" onClick="searchGroupCode( group_code, group_desc)" type="button" name ="group_search" value="?" <%=disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<input type="text" name="tray_no" id="tray_no" value="<%=tray_no%>"  class='NUMBER' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);validateTrayNo();" readonly size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" <%=disabled%>><input class="button" type="button" name ="tray_no_search" value="?" onClick="return searchTrayNo(tray_no);" <%=disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="eSS.Contaminated.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<input type="checkbox" name="contaminated_yn" id="contaminated_yn" value="Y" <%=checked%>></td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
                    <%
					 if(cmdMode.equals("Modify"))
					 {  
                       
				       	 

				 %>
					<tr>
						<td align="left" class="label"><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<select name="sterile_type" id="sterile_type"	><%=bean.getSterilizationTypes()%> </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="eSS.WashingType.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<select name="wash_type" id="wash_type" ><%=bean.getWashTypes()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<% 
						out.println("<script>setSterilizationType();</script>") ;      	out.println("<script>setWashingType();</script>") ;   	
						
						} else { %>
					<tr>
						<td align="left" class="label"><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<select name="sterile_type" id="sterile_type"	><%=bean.getSterilizationTypes()%> </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label"><fmt:message key="eSS.WashingType.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<select name="wash_type" id="wash_type" ><%=bean.getWashTypes()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr> 
					<% } %>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" class="label" colspan='2'>
							<input type="button" value="<%=cmdMode%>" name="modify" class="BUTTON" onClick="return addToTable();">
							<input type="button" value="Cancel" name="cancel" id="cancel" class="BUTTON" onClick="clearDetailForm();">
						</td>
					</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="mode" id="mode" value="<%=mode%>">
			<input type='hidden' name="table_index" id="table_index" value="-1">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			<input type="hidden" name="max_qty" id="max_qty" value="">
			<input type="hidden" name="table_row_index" id="table_row_index" value="-1">
			<input type="hidden" name="group_code" id="group_code" value="<%=group_code%>">
			<input type="hidden" name="editing_key" id="editing_key" value="<%=editing_key%>">
			<input type="hidden" name="pack_item_code" id="pack_item_code" value="">
			<input type="hidden" name="pack_item_qty" id="pack_item_qty" value="">
			<input type="hidden" name="group_type_name" id="group_type_name" value="">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="multi_group_type_yn" id="multi_group_type_yn" value="<%=bean.getMultiGroupTypeYn()%>">
			
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_ROF_ENTRY_TYPE" id="SQL_SS_GROUP_LOOKUP_ROF_ENTRY_TYPE" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP_ROF_ENTRY_TYPE")%>">
		</form>
	</body>
	<%	putObjectInBean(bean_id,bean,request);%>
</html>

