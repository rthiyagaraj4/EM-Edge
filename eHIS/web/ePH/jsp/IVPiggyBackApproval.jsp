<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
   <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script> -->
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPiggyBack.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%  
		String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String ord_auth_reqd_yn     = request.getParameter("ord_auth_reqd_yn")==null?"":request.getParameter("ord_auth_reqd_yn");
		String ord_authorized_yn          = request.getParameter("auth_yn_val")==null?"":request.getParameter("auth_yn_val");
		String ord_spl_appr_reqd_yn = request.getParameter("ord_spl_appr_reqd_yn")==null?"":request.getParameter("ord_spl_appr_reqd_yn");
		String ord_approved_yn      = request.getParameter("approval_yn_val")==null?"":request.getParameter("approval_yn_val");
		String ord_cosign_reqd_yn   = request.getParameter("ord_cosign_reqd_yn")==null?"":request.getParameter("ord_cosign_reqd_yn");
		String ord_cosigned_yn        = request.getParameter("cosign_yn_val")==null?"":request.getParameter("cosign_yn_val");
		String consent_reqd_yn      = request.getParameter("consent_reqd_yn")==null?"":request.getParameter("consent_reqd_yn");
		String disp_locn_code    =request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");//added for ml-mmoh-crf-0863
		String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name			= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;

		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		String or_bean_name		= "eOR.OrderEntryBean";
		OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
		
		String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id, bean_name, request );
		String called_amend_from=bean.getCalledFromAmend();
		
		String display_auth_rule	="visibility:hidden";
		String color_auth_rule	= "RED";
		String auth_amend_pres_yn="";//added for ml-mmoh-crf-0863
		auth_amend_pres_yn = iv_bean.getAuthAmendPres(disp_locn_code);//added for ml-mmoh-crf-0863
		String order_status="";//added for ml-mmoh-crf-0863
				order_status=iv_bean.getOrderStatus();//added for ml-mmoh-crf-0863
		 
		//System.out.println(order_status+"disp_locn_code &&&&&order_status&&&&&auth_amend_pres_yn"+ord_auth_reqd_yn);
%>
		<form name="frmpiggybackApproval" id="frmpiggybackApproval">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<TR>
<%
					display_auth_rule = "visibility:hidden";
					if(ord_auth_reqd_yn.equals("Y")){
						display_auth_rule = "visibility:visible";
						color_auth_rule = "color:red";
						if(ord_authorized_yn.equals("Y"))
							color_auth_rule = "color:green";
						// IF CONDTION added for ml-mmoh-crf-0863 
						
						if(auth_amend_pres_yn.equals("Y") && called_amend_from.equals("PH"))
							color_auth_rule = "color:green";
					}
%>
					<td class="label" align='center'><label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></label></td>
<%
					display_auth_rule = "visibility:hidden";
					color_auth_rule = "color:red";
					if(ord_spl_appr_reqd_yn.equals("Y")){
						display_auth_rule = "visibility:visible";
						if(ord_approved_yn.equals("Y"))
							color_auth_rule = "color:green";
					}
%>
					<td class="label"  align='center' colspan='2'><label id='lbl_splapprvl' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="ePH.splapproval.label" bundle="${ph_labels}"/></label></td>
<%
					display_auth_rule = "visibility:hidden";
					color_auth_rule = "color:red";
					if(ord_cosign_reqd_yn.equals("Y")){
						display_auth_rule = "visibility:visible";
						if(ord_cosigned_yn.equals("Y"))
							color_auth_rule = "color:green";
					}
%>
					<td class="label" align='center'><label id='lbl_cosign' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></label></td>
					<TD WIDTH="15%" CLASS="label" ID="monograph">
					</TD>
				</TR>
			</TABLE>
		</form>
	</body>
</html>
<%
	putObjectInBean(iv_bean_id,iv_bean,request);
	putObjectInBean(or_bean_id,ORbean,request);
	putObjectInBean(bean_id,bean,request);
%>

