<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eXH.*" %>

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
		<!--<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>-->
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<%
	String patient_id						= request.getParameter("patient_id") ;
	String encounter_id						= request.getParameter("encounter_id");
    String facility_id						=  (String)session.getValue("facility_id");
	String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
    String param_bean_name					= "ePH.DrugInterfaceControlBean";
    DrugInterfaceControlBean param_bean		= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
    String drug_db_interface_yn				=	param_bean.getDrugDBInterface_yn(facility_id);  
	param_bean.clear();
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
	<%	  
    Connection con			= null;  // Added for aakh-crf-0140
	try{
    con				= ConnectionManager.getConnection(request);
    boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
    %>
		<table border="1" width="100%"  cellspacing="0" cellpadding="0" >
			<tr>
				<td colspan="2" class="white">
					<tr>
<%
						if(drug_db_interface_yn.equals("Y")){
%>
							<td NOWRAP width="12" class="SHIFTTOTAL" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
							<td NOWRAP  style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.ExternalDataBaseChecks.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;</td>
<%
						}
%>
						<td WRAP width="5%" class="ALLERGY" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
						<td WRAP  width="28%" style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/></td>
						<td  WRAP width="5%" class="DOSELIMIT"  border="1" bordercolor="black" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
						<td  WRAP  width="28%" style="font-size:7pt" class="label" border="0" bordercolor="label" ><fmt:message key="ePH.ExceedDose.label" bundle="${ph_labels}"/></td>
						<td  WRAP width="5%" class="CURRENTRX"
						border="1" bordercolor="black" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
						<td  WRAP width="28%" style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></td>
					<!-- aBde for AAKH-CRF-0140 START -->
					<%if(drug_abuse_appl){ %>
					<td  WRAP width="5%" style="BACKGROUND-COLOR:purple;" class="CURRENTRX"
						border="1" bordercolor="black" align='center'><img src='../../ePH/images/exceed1.gif' ></img></td>
						<td  WRAP width="28%" style="font-size:7pt" class="label" border="0" bordercolor="label">Drug Abuse</td>
						<!-- abuse for AAKH-CRF-0140 end -->
						<%} %>
				</tr>
				</td>
			</tr>
		</table>
		<% putObjectInBean(param_bean_id,param_bean,request);
		}
	catch(Exception e){
		e.printStackTrace();
	}
    finally{
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} %>
	</body>
</html>



