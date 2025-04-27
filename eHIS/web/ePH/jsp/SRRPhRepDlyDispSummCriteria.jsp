<!DOCTYPE html>
 <%-- saved on 29/12/2009 --%>
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
	String p_user_name= (String) session.getValue( "login_user" ) ;
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
 -->	<SCRIPT LANGUAGE="javascript" SRC="../js/SRRPhRepDispSummary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</HEAD>
<%
	String bean_id				= "SRRPHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.SRRPHRepDispStatisByDispBean";
	SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(locale);
	String myLoginFacilityId = (String)session.getValue("facility_id");
	ArrayList dateList =null;
	dateList          = bean.getMednDateList();
	String p_fm_date=(String)dateList.get(0);
	String p_to_date=(String)dateList.get(1);
	p_fm_date=com.ehis.util.DateUtils.convertDate(p_fm_date,"DMYHM","en",locale);
	p_to_date=com.ehis.util.DateUtils.convertDate(p_to_date,"DMYHM","en",locale);
   // String myLoginFacilityId = bean.getLoginFacilityId ();
	String select_status = "";

	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name="formSRRPhRepDlyDispSumm" id="formSRRPhRepDlyDispSumm" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<TABLE WIDTH="100%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
<TR>
	<td  class="label" width="20%" align="right"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
	<td width='14%'>
						  
						  	

						  <SELECT name="p_order_facility" id="p_order_facility" onChange='populateDispLocs(this.value,p_language_id)'>
						  <% ArrayList order_facilities = (ArrayList) bean.getOrderingFacilities(p_user_name,locale);
									if(order_facilities.size()!=0)
									{
										for(int i=0; i<order_facilities.size();i++)
											{	
												if(myLoginFacilityId.equals(order_facilities.get(i)))
													select_status = "selected";
												else
													select_status = "";
											%>
							<OPTION VALUE="<%=(String)order_facilities.get(i++)%>" <%=select_status%>><%=(String)order_facilities.get(i)%></OPTION>
											<%
											}
									}
							%>
												
						  </SELECT></td>
</TR>
<TR><TD>&nbsp;</TD></TR>
<TR>
	<TD CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
	<TD><select name='p_disp_locn' id='p_disp_locn'>
			<option value=''>--- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ---</option>
<%
			ArrayList dispLocnList = bean.getDispLocnList(myLoginFacilityId);
			if(dispLocnList == null)
				dispLocnList = new ArrayList();
			for(int i=0; i<dispLocnList.size();i+=2){
%>
				<option value = <%= dispLocnList.get(i)%>><%= dispLocnList.get(i+1)%></option>
<%
			}
%>
		</select>
	</TD>
	<TD CLASS="label"><fmt:message key="ePH.FromDispDateTime.label" bundle="${ph_labels}"/></TD>
	<td>&nbsp;&nbsp;<input type="text" name="p_fm_date1" id="p_fm_date1" OnBlur='ValidateTime(this)' value="<%=p_fm_date%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('p_fm_date1',null,'hh:mm');document.formSRRPhRepDlyDispSumm.p_fm_date1.focus();return false;" ></td>
	<TD CLASS="label"><fmt:message key="ePH.ToDispDateTime.label" bundle="${ph_labels}"/></TD>
	<input type = "hidden" name = "p_fm_date" value = "">
	<td>&nbsp;&nbsp;<input type="text" name="p_to_date1" id="p_to_date1" OnBlur='ValidateTime(this)' value="<%=p_to_date%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('p_to_date1',null,'hh:mm');document.formSRRPhRepDlyDispSumm.p_to_date1.focus();return false;" ></td>
	<input type = "hidden" name = "p_to_date" value = "">
</TR>
<TR>
<td colspan="6">&nbsp;</td>
</tr>
</table>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= myLoginFacilityId %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDISPSUM_SRR">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

