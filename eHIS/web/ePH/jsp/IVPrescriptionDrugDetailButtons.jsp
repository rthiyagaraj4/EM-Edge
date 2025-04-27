<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<HTML>  
	<HEAD>
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>

<%
	String patient_id	= request.getParameter("patient_id") == null ? "":request.getParameter("patient_id");
	String encounter_id	= request.getParameter("encounter_id") == null ? "":request.getParameter("encounter_id");
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
	try{
		String disabled="";
		String clrValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels");
		String amendValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels");
		String showButtons	= request.getParameter("showButtons") == null ? "":request.getParameter("showButtons");
		String order_type_flag = request.getParameter("order_type_flag")== null ? "":request.getParameter("order_type_flag");
		String mode = request.getParameter("mode")== null ? "":request.getParameter("mode");
		
		if(order_type_flag.equals("Existing") || mode.equals("amend")){
			disabled="disabled"; 
			clrValue=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels") ; 
			amendValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels");
		}
		String sRegRopt		= request.getParameter("sRegRopt") == null ? "":request.getParameter("sRegRopt");
		if(sRegRopt.equals("R"))
			disabled="disabled";

		String or_mode	=	 bean.getOrMode();
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<FORM name="formIVPrescriptionDrugDetailButtons" id="formIVPrescriptionDrugDetailButtons">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<TR>
<%
				if (showButtons.equals("Y")) {
					String limit_ind	= request.getParameter("limit_ind")==null?"":request.getParameter("limit_ind");
					String allergy_yn	= request.getParameter("allergy_yn")==null?"":request.getParameter("allergy_yn");
					String current_rx	= request.getParameter("current_rx")==null?"":request.getParameter("current_rx");
					String db_dosage	= request.getParameter("db_dosage")==null?"":request.getParameter("db_dosage");
					String db_allergy	= request.getParameter("db_allergy")==null?"":request.getParameter("db_allergy");
					String db_duplicate	= request.getParameter("db_duplicate")==null?"":request.getParameter("db_duplicate");
					String abuse_exists	= request.getParameter("abuse_exists")==null?"":request.getParameter("abuse_exists");//added for aakh-crf-0140
					String abuse_action	= request.getParameter("abuse_action")==null?"":request.getParameter("abuse_action");//added for aakh-crf-0140
					System.out.println("62 abuse_exists"+abuse_exists);
					String disp_override_link	= "display:none";
                    String abuse_override_link  ="display:none";//added for aakh-crf-0140
					if (limit_ind.equals("N") || allergy_yn.equals("Y") || current_rx.equals("Y")) {
						disp_override_link	= "display:inline";
					}

					if(limit_ind.equals("Y") && db_dosage.equals("N"))
						disp_override_link	= "display:inline";
					if(allergy_yn.equals("Y") && db_allergy.equals("N"))
						disp_override_link	= "display:inline";
					if(current_rx.equals("Y") && db_duplicate.equals("N"))
						disp_override_link	= "display:inline";
		            if(abuse_exists.equals("Y") && abuse_action.equals("B")){//added for aakh-crf-0140
		            	disp_override_link ="display:inline";
		            }
%>
					<TD WIDTH="22%"  NOWRAP><input type="button" class="button" name="OVERRIDE_LINK" id="OVERRIDE_LINK"  onClick="showOverRideRemarks()" value='<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>' style=<%=disp_override_link%>></TD>
					<TD WIDTH="75%" >
						<INPUT TYPE="button" CLASS="button" name="AMEND" id="AMEND" VALUE="<%=amendValue%>" onClick="callAmend()">
<%
					if(!or_mode.equals("amend")){
%>
						<INPUT TYPE="button" CLASS="button" name="CANCEL" id="CANCEL" VALUE='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' <%=disabled%> onClick="callCancel()">
						<INPUT TYPE="button" CLASS="button" name="CLEAR" id="CLEAR" VALUE="<%=clrValue%>" onClick="callClear()">
<%
					}
%>
				</TD>
<%
			}
			else {
%>
				<TD HEIGHT="20">&nbsp;</TD>
<%
			}
%>
				</TR>
			</TABLE>
		</FORM>
	</BODY>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

