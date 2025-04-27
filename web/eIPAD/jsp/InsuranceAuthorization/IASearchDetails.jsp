<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String locale			= (String)session.getAttribute("LOCALE");
Properties p = (Properties)session.getAttribute("jdbc") ;
String login_at_ws_no =	p.getProperty("client_ip_address");
%>
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/kendo.common.min.css" />
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/kendo.default.min.css" />
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src="<%=path%>/eIPAD/kendo.web.min.js"></script>
	 
	<script language="JavaScript" src="<%=path%>/eCommon/js/common.js"></script>
	<script language="JavaScript" src="<%=path%>/eIPAD/js/IALoginUI.js"></script>
	<script src="<%=path%>/eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="<%=path%>/eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>		
<%
	String patientid = request.getParameter("patientid")==null?"": request.getParameter("patientid");
	String encounterid = request.getParameter("encounterid") == null ? "": request.getParameter("encounterid");
	String facilityid = request.getParameter("facility_id") == null ? "": request.getParameter("facility_id");
	String user_name			= (String) session.getValue( "appl_user_name" ) ;
	String login_user_id		=	(String)session.getValue("login_user");
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	/* ArrayList primaryInsurnceList				= new ArrayList();	
	ArrayList seconderyInsurnceList				= new ArrayList(); */
	ArrayList PatientInsurenceAuthorizationDetails			= new ArrayList();	
	CAInsurenceAuthorizationFormsBean bean = (CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	try{	
		PatientInsurenceAuthorizationDetails=bean.getPatientInsurenceAuthorizationDetails(patientid,encounterid,locale);	
		/* primaryInsurnceList=(ArrayList)PatientInsurenceAuthorizationDetails.get("primaryInsurnceList");
		seconderyInsurnceList=(ArrayList)PatientInsurenceAuthorizationDetails.get("seconderyInsurnceList");	*/
		String count= bean.getInsurenceFormsCount(patientid,encounterid); 
		String report_id="";
		String approval_number= "";
		String[] primaryInsurnceList=null;
%>
<BODY> 		
	<form name="formClaimFormsResult" id="formClaimFormsResult" >
	<%
	if(!count.equals("0")){
	%>
		<div style="display:table;width:100%;height:auto;" align="center">
			<div style="display:table-row;width:100%;height:auto;">
				<div style="display: table-cell;width:30%;height:auto;">
    				<div style="display:table;width:100%;height:auto;">
						<div style="display:table-row;width:100%;height:auto;">
    						<div class="iaLoginRowFonts" style="display:table-cell;width:100%;height:auto;">
								<fmt:message key="eCA.BillingGroupPriorityWise.label" bundle="${ca_labels}"/>
							</div>
						</div>
						<%-- <%if(primaryInsurnceList.size()>0){ --%>
						<%
							for(int i=0;i<PatientInsurenceAuthorizationDetails.size();i++){
								primaryInsurnceList  = (String[])PatientInsurenceAuthorizationDetails.get(i); 
									approval_number=primaryInsurnceList[2];
									%>
								<div style="display:table-row;width:100%;height:auto;">
    								<div class="iaLoginRowFonts" style="display:table-cell;width:100%;height:auto;">
										<%=primaryInsurnceList[0]%>
										<input type="radio" name="preority" id="preority" id="<%=primaryInsurnceList[1]%>"   value="<%=primaryInsurnceList[1]%>" onclick="myTabFunction(this.value)"  >
										<input type="hidden" name="approval_num<%=primaryInsurnceList[1]%>" id="approval_num<%=primaryInsurnceList[1]%>" id="approval_num<%=primaryInsurnceList[1]%>" value="<%=approval_number %>" >
									</div>
								</div>
						<%	}
							%>
						<%-- }
						if(seconderyInsurnceList.size()>0){
							for(int i=0;i<seconderyInsurnceList.size();i+=4){ %>
								<div style="display:table-row;width:100%;height:auto;">
    								<div class="iaLoginRowFonts" style="display:table-cell;height:auto;" colspan="2">
										<%=seconderyInsurnceList.get(i+2)%>
											<input type="radio" name="preority" id="preority" id="<%=seconderyInsurnceList.get(i+0)%>"   value="<%=seconderyInsurnceList.get(i+3)%>" onclick="myTabFunction(this.value)"  >
									</div>
								</div>
							<%	}
						}%> --%>
						<div style="display:table-row;width:100%;height:auto;">
    						<div class="iaLoginRowFonts" style="display:table-cell;width:100%;height:auto;" colspan="2">
								&nbsp;<input type="hidden" name="p_report_id" id="p_report_id" value="" >
							</div>
						</div>
						<div style="display:table-row;width:100%;height:auto;">
    						<div class="iaLoginRowFonts" style="display:table-cell;width:100%;height:auto;" colspan="2" align="center">
								<input type="button" class="k-button" value="View"  name="View" id="View" onclick="viewDetailsInTab('<%=patientid%>','<%=encounterid%>','<%=facilityid%>')" disabled />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
		<input type="hidden" value="<%=patientid%>"  name="patient_id" >
		<input type="hidden" value="<%=encounterid%>"  name="encounterid" >
        <input type="hidden" name="facility_id" id="facility_id"		value="<%=facilityid%>" >				
		<input type="hidden" name="user_name" id="user_name" id="user_name"		value="<%=user_name%>" >
		<input type="hidden" name="login_user_id" id="login_user_id"	id="login_user_id"	value="<%=login_user_id%>" >
		<input type="hidden" name="language_id" id="language_id"	id="language_id"	value="<%=locale%>" >
		<input type="hidden" name="path_value" id="path_value" id="path_value"		value="<%=path%>" >
		<input type="hidden" name="ws_no" id="ws_no" id="ws_no"		value="<%=login_at_ws_no%>" >
		<%
			}else{
				
			
		%>
		<div style="display:table;width:100%;height:auto;" align="center">
			<div style="display:table-row;width:100%;height:auto;">
				<div style="display: table-cell;width:30%;height:auto;">
    				<div style="display:table;width:100%;height:auto;">
						<div style="display:table-row;width:100%;height:auto;">
    						<div class="iaLoginRowFonts" style="display:table-cell;width:100%;height:auto;">
								<fmt:message key="eCA.notInsurencePatient.label" bundle="${ca_labels}"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</form>	
</BODY>
<%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}
	putObjectInBean(bean_id,bean,request);
%>
</html>

