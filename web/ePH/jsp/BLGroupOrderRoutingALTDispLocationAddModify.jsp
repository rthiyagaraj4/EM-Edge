<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
	<html>
		<head>
<% 
			request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
			String locale			= (String)session.getAttribute("LOCALE");
			
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
			<script language="Javascript" src="../../eCommon/js/common.js"></script>
			<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
			<script language="Javascript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
			String bean_id					=   "BLGroupOrderRoutingBean" ;
			String bean_name				=	"ePH.BLGroupOrderRoutingBean";
			String disp_loc_code            =   request.getParameter("disp_loc_code");
			String disp_loc_desc            =    CommonBean.checkForNull(request.getParameter("disp_loc_desc"));
			String mode                     =   request.getParameter("mode");
			String callFrom                 =   request.getParameter("callFrom");
			String ord_src_type             =   request.getParameter("ORD_SRC_TYPE");
			String order_fcy                =   request.getParameter("order_fcy");
			String perform_fcy              =   request.getParameter("perform_fcy");
			String ordering_source_code     =   request.getParameter("ordering_source_code");
			String disp_locn_update="";
			String day_type_update="";
			ArrayList displocns=new ArrayList();
			BLGroupOrderRoutingBean bean=(BLGroupOrderRoutingBean)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			HashMap rtn=new HashMap();
		
%>
			<form name="AltDisplocnHeader" id="AltDisplocnHeader" >
				<table cellpadding='0' cellspacing='0' width="100%" align="center" border="0">
					<TR>
						<TD class ="label" width='9%'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
						<td class ="label" width='25%'><label id="locn_desc" name='locn_desc' value="<%=disp_loc_code%>"><b><%=disp_loc_desc%></b></label></td>
						
						<TD  CLASS="label" width='10%' ><fmt:message key="ePH.DayType.label" bundle="${ph_labels}"/></TD>
						<TD class ="label" width='20%' ><SELECT name="day_type" id="day_type" id="day_type" onChange="setvisibility(this)">
							<OPTION VALUE="" >&nbsp;&nbsp;---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----&nbsp;&nbsp;</OPTION>
							<OPTION VALUE="0"><fmt:message key="Common.Holidays.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="1"><fmt:message key="Common.sun.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="2"><fmt:message key="Common.mon.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="3"><fmt:message key="Common.tue.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="4"><fmt:message key="Common.wed.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="5"><fmt:message key="Common.thu.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="6"><fmt:message key="Common.fri.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="7"><fmt:message key="Common.sat.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE="8" ><fmt:message key="Common.AllDays.label" bundle="${common_labels}"/></OPTION>
							</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
						</TD>
						<TD width='*' class="button"> <input type="button" class="BUTTON" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="AltDispLocationDetails('<%=disp_loc_code%>','<%=callFrom%>','<%=mode%>')">&nbsp;&nbsp;&nbsp;<input type="button" class="BUTTON" name="btnAddAltDispLocnDtls" id="btnAddAltDispLocnDtls" value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>' onClick="saveAltDispLocnDtls('<%=disp_loc_code%>','<%=callFrom%>','<%=mode%>')">&nbsp;&nbsp;&nbsp;<input type="button" class="BUTTON" name="btnClearAltDispLocnDtls" id="btnClearAltDispLocnDtls" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAltDispLocnDtls('<%=ord_src_type%>','<%=order_fcy%>','<%=perform_fcy%>','<%=mode%>','<%=callFrom%>')">&nbsp;&nbsp;&nbsp;</td>
						
					</TR>
				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
				<input type="hidden" name="callFrom" id="callFrom" value="<%=callFrom%>">
				<input type="hidden" name="ordering_source_code" id="ordering_source_code" value="<%=ordering_source_code%>">
				<input type="hidden" name="disp_loc_code" id="disp_loc_code" value="<%=disp_loc_code%>">
			</form>
		</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

