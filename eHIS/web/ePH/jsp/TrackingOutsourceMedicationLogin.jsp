<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/TrackingOutsourceMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.TrackingOutsourceMedicationLogin.label" bundle="${ph_labels}"/></title>
	</HEAD>
<%
	try{
	String disp_locn_details	=  "";
	String facility_id			= (String) session.getValue("facility_id");
	String identityForSwitch = request.getParameter("identityForSwitch")==null?"":request.getParameter("identityForSwitch");
	String homepage			= request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String store_code			= request.getParameter("store_code")==null?"": request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String bean_id   = "TrackingOutsourceMedicationBean" ;
	String bean_name = "ePH.TrackingOutsourceMedicationBean";
	TrackingOutsourceMedicationBean bean = (TrackingOutsourceMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);

	ArrayList result = bean.checkToProceed(facility_id.trim());
	if(result.size()>0) {
		disp_locn_details =(String)result.get(0);
	}
	//bean.setDispLocnDetails(disp_locn_details);
	StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
	int no_of_disp_locns = stdisp_locn_details.countTokens();
	String disableDispLocn = "", password="", passwordDisable="", dispLocnCode="";
	if(no_of_disp_locns==1){
		disableDispLocn = "disabled";
	}
	else{
		disableDispLocn = "";
	}
	if(identityForSwitch.equals("Switch")){
		password		= bean.getPassword();
		dispLocnCode	= bean.getDispLocnCode();
		passwordDisable = "disabled";
	}
	if(homepage.equals("Y")){ //Added for Bru-HIMS-CRF-073 [IN:029939]
		bean.setDispLocnCode(store_code);
		dispLocnCode = store_code;
	}
%>
	<body onMouseDown="" onKeyDown="lockKey()" onload="focusInToPassword('<%=identityForSwitch%>')">
		<form name="frmTrackingOutsourceMedicationLogin" id="frmTrackingOutsourceMedicationLogin">
			<table cellpadding="0" cellspacing="0" width="101%" align="center" border="0" >
				<tr><td colspan="2">&nbsp;</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
						<input type="user_name" name="user_name" id="user_name" size="55" maxlength="60" value="<%=bean.getUserName()%>" readOnly>
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
						<input type="password" name="password" id="password" size="55" maxlength="60" value="<%=password%>" <%=passwordDisable%>  onKeyPress="uppercase()"  autocomplete="off">  <!--41741 autocomplete="off"-->
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td >&nbsp;&nbsp;
						<select name="disp_locn" id="disp_locn" onChange=""  <%=disableDispLocn%>>
<%	
						if (no_of_disp_locns > 1){
%>
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						}
						String disp_locnDtl, strDispLocnCode;
						StringTokenizer st_disp_locn =	null;
						while (stdisp_locn_details.hasMoreTokens()){
							disp_locnDtl			= stdisp_locn_details.nextToken();
							st_disp_locn		= new StringTokenizer(disp_locnDtl,",");
							strDispLocnCode = st_disp_locn.nextToken();
							if(dispLocnCode.equals(strDispLocnCode)){
%>
								<option value="<%=strDispLocnCode%>"  selected><%=st_disp_locn.nextToken()%></option>	
<%
							}
							else{
%>
							<option value="<%=strDispLocnCode%>"  ><%=st_disp_locn.nextToken()%></option>		
<%
							}
						}
						st_disp_locn		=	null;
%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>	
				</tr>
					<td  colspan="2" class="white" align="right">
						<input type="button" class="BUTTON" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="proceedTracking()">	
						<input type="button" class="BUTTON" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="goHome()">&nbsp;&nbsp;&nbsp;
					</td>	
				</tr>
			</TABLE>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>

