<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<jsp:useBean id="alPackingList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/Packing.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
<%
	PackingListBean bean									=	(PackingListBean)getBeanObject( "packingListBean", "eSS.PackingListBean" ,request );  
	PackingDiscrepancyListBean packingDiscrepancyListBean   =	(PackingDiscrepancyListBean)getBeanObject( "packingDiscrepancyListBean", "eSS.PackingDiscrepancyListBean" , request );  
	packingDiscrepancyListBean.clear();

	bean.clear();
	bean.setLanguageId(locale);		
	String gif_visibility			=		"visibility:visibile";
	String disabled					=		"";
	String holdReasonDisabled		=		"";
	String packingDateDisabled		=		"";
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String cursor                   =       "CURSOR:HAND";
	if(!index.equals("-1")){
		bean.initialize((HashMap)alPackingList.get(Integer.parseInt(index)));
		if(bean.getHold_yn().equals("N"))
			holdReasonDisabled		=	"disabled";
		if(bean.getHold_yn().equals("Y")){
			gif_visibility = "visibility:hidden";
		
			packingDateDisabled	=	"disabled";}

	}
	else	
	{
			disabled				=	"disabled";
	      cursor  =   "CURSOR:HAND";
	}
			packingDiscrepancyListBean.setFilter(bean.getGroup_code(), bean.getTray_no());
			String expiry_date = "";//Adding start for TH-KW-CRF-0030
			boolean show_expiry_date = bean.isSiteSpecific("SS","SHOW_EXPIRY_DATE");
			if(!bean.getGroup_code().equals("")){
			  expiry_date = bean.getExpiryDate(bean.getGroup_code());
			  expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date,"DMYHM","en",locale);
			}//Adding end for TH-KW-CRF-0030

%>
	<body onMouseDown="CodeArrest();" onLoad="FocusFirstElement();">
		<form name="formPackingDetail" id="formPackingDetail" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
			<table border="0" cellpadding="3" cellspacing="0" width='100%' align='center'>
				<tr>
					<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="group_desc" id="group_desc" value="<%=bean.getGroup_desc()%>" maxLength='15' size='15' readOnly ><input type='button' class='BUTTON' value='?' name="group_search" id="group_search" disabled ><input type="hidden" name="group_code" id="group_code" value="<%=bean.getGroup_code()%>">&nbsp<a style = '<%=cursor%>' href='javascript:details();' <%=disabled%>  id='details'><fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp&nbsp</a></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' class="NUMBER" name="tray_no" id="tray_no" value="<%=bean.getTray_no()%>" maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' onKeyPress="return isValidInteger();"  disabled onBlur="searchTrayDetail();"><input type='button' class='BUTTON' value='?' onClick="searchTrayNo();"  name="tray_search" id="tray_search" disabled></td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="eSS.PackItem.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type="text" value="<%=bean.getPack_item_desc()%>" name="pack_item_desc" id="pack_item_desc" size='15' maxLength='15' readOnly><input type="hidden" value="<%=bean.getPack_item_code()%>" name="pack_item_code" id="pack_item_code" size='10' maxLength='10'><input type="button" class='BUTTON' value="?" name="item_search" id="item_search" onClick="searchPackItem(pack_item_code,pack_item_desc);" <%=disabled%> <%=disabled%>><!-- <%=bean.getMandatoryImageTag()%> --></td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="eSS.PackItemQty.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="pack_item_qty" id="pack_item_qty" class="NUMBER" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"  value="<%=bean.getPack_item_qty()%>" <%=disabled%>><!-- <%=bean.getMandatoryImageTag()%> --></td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="eSS.PackCost.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="pack_cost" id="pack_cost" class="NUMBER" maxLength="<%=bean.getCurrencySize()%>" size="<%=bean.getCurrencySize()%>" onKeyPress="return isValidNumber(this,event,<%=bean.getCurrencyFormat()%>);" value="<%=bean.getPack_cost()%>" <%=disabled%> disabled>
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.Hold.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;<input type='checkbox' name="hold_yn" id="hold_yn" value="Y" <%=disabled%> onClick="checkHoldStatus(this.checked);" <%=bean.getChecked(bean.getHold_yn())%>></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.HoldReason.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<textarea style="resize:none" "rows=2 cols=17 maxlength=100 name="hold_reason" onKeyPress="return setTextAreaMaxLength(this,100);" onBlur=" checkSetTextAreaMaxLength(hold_reason,100);" <%=holdReasonDisabled%> <%=disabled%>><%=bean.getHold_reason()%></textarea></td>
				</tr>
<%
                   if(show_expiry_date){//Added for TH-KW-CRF-0030
%>
				<tr><!-- Added for TH-KW-CRF-0030 -->
					<td class="label"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="expiry_date" id="expiry_date" value="<%=expiry_date%>" maxLength="15" size="15" disabled  >&nbsp;<input type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('packing_date');" disabled><img src="../../eCommon/images/mandatory.gif" name="date" align="center" style ="<%=gif_visibility%>" disabled ></img></td>
				</tr>
<%}%>
				<tr>
					<td class="label"><fmt:message key="eSS.PackingDate.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="packing_date" id="packing_date" value="<%=com.ehis.util.DateUtils.convertDate(bean.getPacking_date(),"DMY","en",locale)%>" maxLength="10" size="10" <%=disabled%>  <%=packingDateDisabled%> onBlur="checkSysdate(this,sysdate);">&nbsp;<input type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('packing_date');" <%=disabled%>><img src="../../eCommon/images/mandatory.gif" name="date" align="center" style ="<%=gif_visibility%>" ></img></td>
				</tr>
				<tr>
					<td  class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="check();" value="Modify" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetPackingDetail();" value="Cancel" <%=disabled%>>					
					</td>
				</tr>
				<tr>
					<td  class="label" colspan='2'>
						<input type='button' class='BUTTON' name="discrepancy" id="discrepancy" onClick="collectDiscrepancyDetail()" value="Discrepancy" <%=disabled%>>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index"					value="<%=index%>">
			<input type='hidden' name="locale" id="locale"					value="<%=locale%>">
			<input type='hidden' name="sysdate" id="sysdate"					value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
			<input type='hidden' name="function_id" id="function_id"				value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP"		value="<%= bean.getSsRepositoryValue("SQL_SS_ITEM_LOOKUP")%>">
			<input type="hidden" name="sys_date" id="sys_date"				value="<%= bean.getSSParameter().get("SYS_DATE")%>">

		</form>
<%
		putObjectInBean("packingListBean",bean,request);
		putObjectInBean("packingDiscrepancyListBean",packingDiscrepancyListBean,request);
%>
	</body>
</html>

