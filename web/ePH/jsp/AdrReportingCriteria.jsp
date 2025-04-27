<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
	<% 
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/ADRReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
<%
	String	bean_id			=	"ADRReportBean" ;
	String	bean_name		=	"ePH.ADRReportBean";
	ArrayList patdetails	=	new ArrayList();
	ArrayList ethnicNames=new ArrayList();
	String patlabel			=	"";
	ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	String disable = "";	
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage");
	String adr_no = request.getParameter("adr_no")==null?"":request.getParameter("adr_no");
	String ptnt_id = request.getParameter("ptnt_id")==null?"":request.getParameter("ptnt_id");
	if(!ptnt_id.equals("")){
		patdetails=bean.getPatientDetails(ptnt_id);
		if(patdetails.size()!=0){
			patlabel=(String)patdetails.get(0)+" / "+(String)patdetails.get(1)+" / " +(String)patdetails.get(2);
		}
	}
	String drug_name1 = request.getParameter("drug_name1")==null?"":request.getParameter("drug_name1");
	String patient_name = request.getParameter("patient_name")==null?"":request.getParameter("patient_name");
	String  adrStatus = request.getParameter("adrStatus")==null?"":request.getParameter("adrStatus");
	
	if(adrStatus.equals("C") || adrStatus.equals("S") || adrStatus.equals("E")  )//code added for HSA-CRF-0005[40601]
		disable = "disabled";
	
	String drugDisc = request.getParameter("drugDisc")==null?"":request.getParameter("drugDisc");
	if(!drugDisc.equals(""))
	   drugDisc		=   java.net.URLDecoder.decode(drugDisc,"UTF-8");
	String weight = request.getParameter("weight")==null?"":request.getParameter("weight");
	String sgndBy = request.getParameter("sgndBy")==null?"":request.getParameter("sgndBy");
				
		
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String ord_id = request.getParameter("ord_id")==null?"":request.getParameter("ord_id");
	String ord_line = request.getParameter("ord_line")==null?"":request.getParameter("ord_line");
	String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String ethnic_grp = request.getParameter("ethnic_grp")==null?"":request.getParameter("ethnic_grp");
	//String malay="",chinese="", indian="", other="";
	/*if(!ethnic_grp.equals("")){
		if(ethnic_grp.equals("M")){malay  = "Selected";}
		if(ethnic_grp.equals("C")){chinese  = "Selected";}
		if(ethnic_grp.equals("I")){indian  = "Selected";}
		if(ethnic_grp.equals("O")){other  = "Selected";}
	}*/
	String modedisabled="",readonly="";
	if(mode.equals("mode_modify")){
		modedisabled="disabled";
		readonly	=	"readonly";
	}
	ethnicNames=bean.getEthnicNames();

	if(patient_id.length()==0 && ptnt_id.length()==0){
		patlabel=patient_name;
		drug_name1=drugDisc;
	}
	String facility_id = request.getParameter("facility_id"); //Code added for added for 33963
	if(facility_id == null) facility_id = ""; //Code added for added for 33963
	
	String  sign_by_id = request.getParameter("sign_by_id")==null?"":request.getParameter("sign_by_id");//code added for HSA-CRF-0005[40601] -- Start
	String canErrorID = bean.getcanErrorID();
	String canErrorDate = bean.getcanErrorDate();
	String canRemarks = bean.getcanRemarks();
	String status ="",  ethnicName, ethnicCode;  //code added for HSA-CRF-0005[40601] --End
%> 
	<BODY   onMouseDown="CodeArrest()" onKeyDown="lockKey()"    > 
		<form name="formAdrReportingCriteria" id="formAdrReportingCriteria">
			<table cellpadding="0" cellspacing="0"  border="0" width="100%" align="center">
				<tr>
					<th colspan="10"> <fmt:message key="ePH.ADRReportingCriteria.label" bundle="${ph_labels}"/> </th>
				</tr>
				<tr>
					<td class="label" width='12%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td> 
					<td class="field"  width='10%'>
					<input type='text'  name='patient_id' id='patient_id' size=20 value="<%=ptnt_id%>"   onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" onBlur='callPatientLin(patient_id);' <%=disable%> <%=readonly%>>
					<input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button' onClick="callPatientLookup();" <%=disable%> <%=modedisabled%>/>&nbsp;
					<img align='center' src ='../../eCommon/images/mandatory.gif'></img> </td> 
					<td class='label' width='10%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td> 
					<td class="field"><input type='text'  name='patient_name' id="patient_name" size='50' value="<%=patlabel%>" <%=disable%>  maxlength="100"> </td> 
					<td class='label' ></td> 
					<td class="field" width="25%" colspan="3">
				</tr>
				<tr>
					<td class='label'  width='12%'><fmt:message key="ePH.SuspectedDrug.label" bundle="${ph_labels}"/></td>
<%	
					if(!mode.equals("mode_modify")){
%>
						<td class="field"  width='28%'><input type='text'  name='suspected_drug' id='suspected_drug' size="40"  value="<%=drugDisc%>" maxlength="60"  onKeyPress="return CheckForSpecChars(event)" onBlur="callWeight(order_id,order_line_no)"	disabled readonly ><input valign='top' type='button' name='drug_search' id='drug_search' value='?' class='button' onClick="DrugLookup()" disabled >&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
						</td> 
<%
					}
					else{
%>
						<td class="field"  width='28%'><input type='text'  name='suspected_drug' id='suspected_drug' size="40"  value="<%=drugDisc%>" maxlength="60"  onKeyPress="return CheckForSpecChars(event)" onBlur="callWeight(order_id,order_line_no)"	<%=disable%> readonly ><input valign='top' type='button' name='drug_search' id='drug_search' value='?' class='button' onClick="DrugLookup()" <%=disable%> <%=modedisabled%> >&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
						</td> 
<%
					}
%>
					<td class="label" width="7%" ><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp; </td>
					<td class="data" width='5%' >
					<input type="text" name="weight" id="weight" size="10" maxlength="7" onKeyPress="return allowValidNumber(this,event,4,2);" value="<%=weight%>" <%=disable%> <%=readonly%> >&nbsp;<fmt:message key="Common.kg.label" bundle="${common_labels}"/></td>
					<td class="label" width="9%"><fmt:message key="Common.EthnicGroup.label" bundle="${common_labels}"/></td> 
					<td class="data" width="13%"  >
					<SELECT name="ethnic_grp" id="ethnic_grp" <%=disable%>><OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
					for(int i=1;i<ethnicNames.size();i=i+2){
						ethnicName=(String)ethnicNames.get(i);
						ethnicCode=(String)ethnicNames.get(i-1);
						if(ethnicCode.equals(ethnic_grp)){
%>
							<option value="<%=ethnicCode%>" selected><%=ethnicName%></option>
<%
						}
						else{
%>
							<option value="<%=ethnicCode%>"><%=ethnicName%></option>
<%
						}
					}
%>
					</SELECT><img align='center' src ='../../eCommon/images/mandatory.gif'></img>
					</td> 
<%
					if(mode.equals("mode_modify")) { //code added for HSA-CRF-0005[40601] -- Start
%>
						<td class="label" width="6%" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>	   
						<td class="field" width="7%">
							<select name="status" id="status"  onChange="captureStatus(this.value)"  >					
<%
							if(adrStatus.equals("U")){ 
%>
								<!-- <option value="" >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>--> <!-- Code commented for IN042470 -->
								<option value=<%=adrStatus%> >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option><!-- Code added for IN042470 -->
								<option value="C" ><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option>			
<%
							}
							else if(adrStatus.equals("S")){
%>	
								<option value="" >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
								<option value="E" ><fmt:message key="ePH.InError.label" bundle="${ph_labels}"/></option>	
<%
							}
							else if(adrStatus.equals("C")){ 
%>	
								<option value="C" ><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option>
<% 
							}
							else if(adrStatus.equals("E")){ 
%>
								<option value="E"  ><fmt:message key="ePH.InError.label" bundle="${ph_labels}"/></option>	
<%
							}
%>
							</select>  
						</td>
						<td>
							<div  id="remarks">
								<a href="javascript:showRemarks('<%=ptnt_id%>','<%=adr_no%>','<%=facility_id%>');" class="label" id="remarks_link" style="visibility:hidden>" title='<fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></a>&nbsp;<img align='center' id="mandSymbol" name="mandSymbol" src ='../../eCommon/images/mandatory.gif'></img>
							</div>
						</td>
<%   
					}//code added for HSA-CRF-0005[40601] -- End
%> 
					</tr>
				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
				<input type="hidden" name="order_id" id="order_id" value="">
				<input type="hidden" name="order_line_no" id="order_line_no"	value="">
				<input type="hidden" name="drug_code" id="drug_code"	value="<%=drug_code%>">
				<input type="hidden" name="mode" id="mode"	value="<%=mode%>">	
				<input type="hidden" name="pname" id="pname"	value="<%=patient_id%>">
				<input type="hidden" name="homepage" id="homepage"	value="<%=homepage%>">

				<input type="hidden" name="canErrorID" id="canErrorID" value=""> <!-- code added for HSA-CRF-0005[40601] -- Start -->  
				<input type="hidden" name="canErrorDate" id="canErrorDate" value="">  
				<input type="hidden" name="canRemarks" id="canRemarks" value="">  
				<input type="hidden" name="canReason" id="canReason" value="">  
				<input type="hidden" name="SignedBy" id="SignedBy" value="<%=sign_by_id%>" > <!-- code added for HSA-CRF-0005[40601] -- End -->  
				<input type="hidden" name="homepage" id="homepage" value="<%=homepage%>">
			</form>
<%
		if(mode.equals("mode_modify")){
%>
		<script>
			assignstatus('<%=adrStatus%>');
			parent.f_adrreport_tabdetail.location.href="../../ePH/jsp/AdrReportingTabDetail.jsp?ord_id="+'<%=ord_id%>'+"&ord_line="+'<%=ord_line%>'+"&sgndBy="+'<%=sgndBy%>'+"&mode="+'<%=mode%>'+"&patient_id="+'<%=ptnt_id%>'+"&adr_no="+'<%=adr_no%>'+"&ethnic_grp="+'<%=ethnic_grp%>'+"&patient_name="+'<%=patient_name%>'+"&drug_name1="+'<%=drug_name1%>'+"&facility_id="+'<%=facility_id%>' ;//Code added for added for 33963	
		</script>
<%	
		}   
		if(disable.equals("disabled")){
%>
			<script>
				parent.parent.frames[0].document.forms[0].apply.disabled = true;
			</script>
<%
		}
		else{
%>
			<script>
				try{
					document.formAdrReportingCriteria.patient_id.focus();   // Moved the line UP from below  for ML-BRU-SCF-0094[31887] 
					parent.parent.frames[0].document.forms[0].apply.disabled = false;	
				}
				catch(e){
				}
			</script>	
<%
		}
		putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

