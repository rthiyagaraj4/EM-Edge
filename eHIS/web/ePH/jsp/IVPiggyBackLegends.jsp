<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");  
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
		String patient_id			= request.getParameter("patient_id");
		String encounter_id			= request.getParameter("encounter_id");
		String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name			= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;
		String  iv_type=iv_bean.getIVType();

		ArrayList drugList			= iv_bean.getDrugDetails();
		/*if(drugList !=null && drugList.size()>=1){
			HashMap hm	= (HashMap)drugList.get(0);		
		}*/

		String facility_id						=  (String)session.getValue("facility_id");
		String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
		String param_bean_name					= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean		= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		String drug_db_interface_yn				=	param_bean.getDrugDBInterface_yn(facility_id);  
		param_bean.clear();
		Connection con				= null;
		 con						= ConnectionManager.getConnection(request);
		boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
		

%>
		<form name="frmpiggybacklegends" id="frmpiggybacklegends">
			<table border="1" width="100%"  cellspacing="0" cellpadding="0" >
				<tr>
					<td colspan="2" class="white">
						<tr>
<%
							if(drug_db_interface_yn.equals("Y")){
%>
								<td NOWRAP width="2%" class="SHIFTTOTAL" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
								<td NOWRAP width="15%" style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.ExternalDataBaseChecks.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;</td>
<%
							}
%>
							<td WRAP width="2%" class="ALLERGY" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
							<td WRAP  width="15%" style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/></td>
							<td  WRAP width="2%" class="DOSELIMIT"  border="1" bordercolor="black" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
							<td  WRAP  width="15%" style="font-size:7pt" class="label" border="0" bordercolor="label" ><fmt:message key="ePH.ExceedDose.label" bundle="${ph_labels}"/></td>
							<td  WRAP width="2%" class="CURRENTRX"
							border="1" bordercolor="black" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
							<td  WRAP width="15%" style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></td>
						<%if(drug_abuse_appl){ %><!-- abuse for aakh-crf-0140 start -->
							<td  WRAP width="2%" style="BACKGROUND-COLOR:purple;" class="CURRENTRX"
							border="1" bordercolor="black" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
							<td  WRAP width="15%" style="font-size:7pt" class="label" border="0" bordercolor="label">Abuse Details</td>
						<%} %>	<!-- abuse for aakh-crf-0140 end -->
<%
							if(!(iv_type.equals("IVPB") )){
%>
								<td WRAP width="15%" class="white">&nbsp;</td>
								<td WRAP class="white">
									<input type="button" name="btn_override_reason" id="btn_override_reason" value='<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>' class="button" style="visibility:hidden" onClick="showOverRideRemarks()">&nbsp;&nbsp;&nbsp;
								</td>
<%
							}
%>
						</tr>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<%
	putObjectInBean(iv_bean_id,iv_bean,request);
	putObjectInBean(param_bean_id,param_bean,request);
%>

