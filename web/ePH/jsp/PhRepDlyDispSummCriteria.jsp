<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhRepDispSummary.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	String bean_id				= "PHRepMednAdmnListBean" ;
	String bean_name			= "ePH.PHRepMednAdmnListBean";
	PHRepMednAdmnListBean bean	= (PHRepMednAdmnListBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(locale);
	String facility_id = (String)session.getValue("facility_id");
	ArrayList dateList =null;
	dateList          = bean.getMednDateList();
	String p_fm_date=(String)dateList.get(0);
	String p_to_date=(String)dateList.get(1);
	p_fm_date=com.ehis.util.DateUtils.convertDate(p_fm_date,"DMYHM","en",locale);
	p_to_date=com.ehis.util.DateUtils.convertDate(p_to_date,"DMYHM","en",locale);
   

	ArrayList dispLocnList = bean.getDispLocnList(facility_id);
	if(dispLocnList == null)
		dispLocnList = new ArrayList();
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name="formPhRepDlyDispSumm" id="formPhRepDlyDispSumm" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<TABLE WIDTH="100%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
<TR>
<td colspan="6">&nbsp;</td>
</tr>
<TR>
	<TD CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
	<TD>&nbsp;&nbsp;<select name='p_disp_locn' id='p_disp_locn'>
			<option value='ALL'>--- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ---</option>
<%
			for(int i=0; i<dispLocnList.size();i+=2){
%>
				<option value = <%= dispLocnList.get(i)%>><%= dispLocnList.get(i+1)%></option>
<%
			}
%>
		</select>
	</TD>
	<TD CLASS="label"><fmt:message key="ePH.FromDispDateTime.label" bundle="${ph_labels}"/></TD>
	<td>&nbsp;&nbsp;<input type="text" name="p_fm_date" id="p_fm_date" OnBlur='CheckDateT(this);' value="<%=p_fm_date%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('p_fm_date',null,'hh:mm');document.formPhRepDlyDispSumm.p_fm_date.focus();return false;" ></td>
	<TD CLASS="label"><fmt:message key="ePH.ToDispDateTime.label" bundle="${ph_labels}"/></TD>
	<td>&nbsp;&nbsp;<input type="text" name="p_to_date" id="p_to_date" OnBlur='CheckDateT(this);' value="<%=p_to_date%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('p_to_date',null,'hh:mm');document.formPhRepDlyDispSumm.p_to_date.focus();return false;" ></td>
</TR>
<TR>
<td colspan="6">&nbsp;</td>
</tr>
</table>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDISPSUM">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

