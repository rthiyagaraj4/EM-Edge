<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD>
<TITLE><fmt:message key="eOR.ConfirmAuthorise.label" bundle="${or_labels}"/></TITLE>

</HEAD>
<%	
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name='spl_auth' id='spl_auth' METHOD=POST >

<%
	//String readOnly = "" ;
	String checked = "" ;
	String disabled = "" ;
	/* Mandatory checks start */
	String mode	   = "1" ;

	String bean_id = "Or_AuthoriseOrder" ;
	String bean_name = "eOR.AuthoriseOrders";

	AuthoriseOrders bean = (AuthoriseOrders)getBeanObject( bean_id, bean_name, request ) ;

	HashMap all_final_values = (HashMap)bean.getFinalValues();

	int hmp_size		= all_final_values.size();
	int actual_size		= hmp_size/8;
	String slClassValue = "";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	//String ord_appr_reqd_yn		=  "";
	//String ord_appr_by_user_id	=  "";
	String order_category		=  "";

%>
<BR>
	<table cellpadding=3 cellspacing=0 border=1 width='100%' align=center class="grid">
	<tr><td class=columnheader><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></td></tr>
<%	for (int i=0; i< actual_size; i++){
		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
		//ord_appr_reqd_yn	= (String)all_final_values.get("ord_appr_by_user_id"+i);
		//ord_appr_by_user_id	= (String)all_final_values.get("ord_appr_reqd_yn"+i);
		order_category		= (String)all_final_values.get("order_category"+i);

		String spl_apprvl = "";

			spl_apprvl = (String)bean.getSplApprvlYN(practitioner_id,resp_id,order_category);

			out.println("spl_apprvl>"+spl_apprvl+"<");

			if(!(spl_apprvl.equals(""))){
				checked = " checked ";
			}else{
				checked = "";
				disabled = " disabled ";
			}
%>
			<tr>
				<td class='<%=slClassValue%>'><%=all_final_values.get("ord_catalog"+i)%></td>
				<td class='<%=slClassValue%>'><%=all_final_values.get("ord_id"+i)%></td>
				<td class='<%=slClassValue%>' align=center><input type=checkbox name='chk<%=i%>' id='chk<%=i%>'  <%=checked%> <%=disabled%>></td>
			</tr>
			<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=all_final_values.get("cont_order_ind"+i)%>">
			<input type=hidden name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=all_final_values.get("ord_typ_code"+i)%>">
			<input type=hidden name='ord_consent_yn<%=i%>' id='ord_consent_yn<%=i%>' value="<%=all_final_values.get("ord_consent_yn"+i)%>">
			<input type=hidden name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=all_final_values.get("ord_id"+i)%>">
<%
//     all_final_values.clear();				 
	}
%>
	</table>
<input type=hidden name='total_recs' id='total_recs' value='<%=actual_size%>'>
<input type="hidden" name="which_page" id="which_page" value="spl_apprvl">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">

</FORM>

</BODY>
</HTML>
<%
	//putObjectInBean(bean_id,bean,request);
%>

