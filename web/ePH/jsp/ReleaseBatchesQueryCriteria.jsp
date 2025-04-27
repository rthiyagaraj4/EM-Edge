<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		 <script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>  <!--  added for mohe-scf-0202 -->
		<script language="javascript" src="../../ePH/js/ReleaseBatches.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
		String bean_id				= "ReleaseBatchesBean";
		String bean_name			= "ePH.ReleaseBatchesBean";
		String bean_id1			= "DispMedicationBean" ;//Added for Bru-HIMS-CRF-416[IN045566]
		String bean_name1		= "ePH.DispMedicationBean";	//Added for Bru-HIMS-CRF-416[IN045566]
		ReleaseBatchesBean bean		= (ReleaseBatchesBean)getBeanObject( bean_id,bean_name,request);
		DispMedicationBean bean1	= (DispMedicationBean)getBeanObject( bean_id1,bean_name1,request);//Added for Bru-HIMS-CRF-416[IN045566]
		String reccount = bean1.getRecCount();//Added for Bru-HIMS-CRF-416[IN045566]
		String drug_code="";	
		String drug_desc="";	
		bean.clear();
		
		bean.setMode(CommonRepository.getCommonKeyValue("MODE_MODIFY"));
		bean.setLanguageId(locale);
		bean.getDefltValues(); //Added for SKR-SCF-0979 [IN:048119]
		ArrayList disp_locn		=	bean.getDispLocns(locale);
		String patientid 		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//Added for Bru-HIMS-CRF-416[IN045566]--START
		String fromPage 		= request.getParameter("frompage")==null?"":request.getParameter("frompage");
		String disp_stage = bean1.getDispStage();
		String refflag= "";
		String patient_class = bean1.getPatientclass();
		String fillList = bean1.getFillList();
		String filling_status = bean1.getFillingStatus();
		bean1.setRelPatientID(patientid);//Added for Bru-HIMS-CRF-416[IN045566]
		bean1.setreleaseFlag("releasebatch");//Added for Bru-HIMS-CRF-416[IN045566]
		String disp_locn_code 		= request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
		String from_date 		= request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date 		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
		if(from_date.trim().length()>11 && to_date.trim().length()>11){
			from_date = from_date.substring(0, 10);
			to_date = to_date.substring(0,10);
		}
	
		String disable ="";
		if(patient_class!=null && patient_class.trim().length()>0&& patient_class.equalsIgnoreCase("OP")){
			if(disp_stage.equalsIgnoreCase("D"))
				refflag="true";
			else 
				refflag="false";
		}
		else if((patient_class!=null && patient_class.trim().length()>0 && patient_class.equalsIgnoreCase("IP"))){
			if(disp_stage.equalsIgnoreCase("D") && fillList.equalsIgnoreCase("DF"))
				refflag="true";
			else
				refflag="false";
		}
		if( fromPage.trim().length()>0 && fromPage.equals("dispmed"))
			disable = "disabled";
		if( fromPage.trim().length()>0 && !fromPage.equals("dispmed")){
			patientid = "";
			disp_locn_code = "";
			from_date = "";
			to_date = "";
		}//Added for Bru-HIMS-CRF-416[IN045566]--end
		String bl_installed_yn=bean.checkforbillinginterface();
%>
		<form name="formReleasebatches" id="formReleasebatches">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<input type="hidden" name="patientid" id="patientid"	value="<%=patientid%>" ><!--Added for Bru-HIMS-CRF-416[IN045566] -start-->
				<input type="hidden" name="disp_locn_code" id="disp_locn_code"	value="<%=disp_locn_code%>" >
				<input type="hidden" name="from_date" id="from_date"	value="<%=from_date%>" >
				<input type="hidden" name="to_date" id="to_date"	value="<%=to_date%>" >
				<input type="hidden" name="fromPage" id="fromPage"	value="<%=fromPage%>" >
				<input type="hidden" name="reccount" id="reccount"	value="<%=reccount%>" >
				<input type="hidden" name="refflag" id="refflag"	value="<%=refflag%>" ><!--Added forBru-HIMS-CRF-416[IN045566] -end-->
				<input type="hidden" name="SQL_PH_DRUG_SEARCH_DRUG" id="SQL_PH_DRUG_SEARCH_DRUG" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2")%>">
<%
				if(fromPage.equals("dispmed")){//Added for Bru-HIMS-CRF-416[IN045566]-start
%>
					<input type='button'  value='Apply' class='button' onclick="dispapply();">
<%
				}//Added for Bru-HIMS-CRF-416[IN045566] -end
%>
				<tr>
					<td  class="label"><fmt:message key="ePH.AllocatedDateFrom.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<input type="text" name="dt_from" id="dt_from" value='<%=from_date%>' maxlength="10" size="10"  onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img> <!--Modified for Bru-HIMS-CRF-416[IN045566] -->
					</td> <%-- onBlur="CheckDate(this); changed to onBlur="CheckDateLeap(this,'DMY','<%=locale%>'); for RollForward from SRR - SRR20056-SCF-9375 [IN:056955] --%>

					<td  class="label"><fmt:message key="ePH.AllocatedDateTo.label" bundle="${ph_labels}"/></td>
					<td align="left"><input type="text" name="dt_to" id="dt_to" value='<%=to_date%>' maxlength="10" size="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" ><img src="../../eCommon/images/mandatory.gif" align="center"></img><!--Modified for Release Batch-->
					</td> <%-- onBlur="CheckDate(this); changed to onBlur="CheckDateLeap(this,'DMY','<%=locale%>'); for RollForward from SRR - SRR20056-SCF-9375 [IN:056955] --%>
					<td  class="label"></td>
					<td  class="label"></td>
					<td  class="label"></td>
					<td  class="label"></td>
				
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;
						<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" <%=disable%> onKeyPress="changeToUpper()" value=<%=patientid%> ><input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" <%=disable%> onClick="callPatientSearch(document.formReleasebatches.patient_id)"><!--Modified for Bru-HIMS-CRF-416[IN045566] -->
					</td>
					
					 <td  class="label"><fmt:message key="ePH.Batches.label" bundle="${ph_labels}"/></td>
					 <td>
					   <select name="batches" id="batches" >
								<option value="A" ><fmt:message key="ePH.AllocatedBy.label" bundle="${ph_labels}"/></option>
								<option value="D" ><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
								<option value="H" ><fmt:message key="ePH.HOLDBYCLINICIANS.label" bundle="${ph_labels}"/></option>
							</select>
					</td>
					<td  class="label"></td>
					<td  class="label"></td>
					<td  class="label"></td>
					<td  class="label"></td>
					
				</tr>   
				<tr>
					<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<select name="disp_locn" id="disp_locn">
					<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<% 
					for(int i=0; i<disp_locn.size();  i+=2){
						if(disp_locn_code != null && disp_locn_code.equalsIgnoreCase((String)disp_locn.get(i))){//Added for Bru-HIMS-CRF-416[IN045566]
%>
							<option value="<%=(String)disp_locn.get(i)%>" selected><%=(String)disp_locn.get(i+1)%></option>
<%
						}
						else{
%>
							<option value="<%=(String)disp_locn.get(i)%>"><%=(String)disp_locn.get(i+1)%></option>
<%
						}
					}
%>
					</select><img src="../../eCommon/images/mandatory.gif" align="center"></img> 
					</td>

					<td  class="label"  ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
					<td	 align="left" colspan="3">
					<input type="text" maxlength="60" size="60" name="drug_desc" id="drug_desc"   value="<%=drug_desc%>" >
					<input type="hidden" maxlength="10" size="10" name="drug_code" id="drug_code" value="<%=drug_code%>"><input type="button" class="button" value="?"   onClick="searchCode(this)">
				</tr>
				<tr>
<%
					if((bl_installed_yn.equals("Y"))){
%>
						<td colspan='2'></td>
						<td  class="label"><fmt:message key="ePH.PaymentStatus.label" bundle="${ph_labels}"/></td>
						<td>
						<select name="paidstatus" id="paidstatus" >
							<option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="P" ><fmt:message key="Common.Paid.label" bundle="${common_labels}"/></option>
							<option value="U" ><fmt:message key="ePH.UnPaid.label" bundle="${ph_labels}"/></option>
						</select>
						</td>
<% 
					}
					else {
%>
						<td colspan='4'></td>
						<input type="hidden" name="paidstatus" id="paidstatus"	value="" >
<% 
					}
%>
					<td  colspan="2"> 
					<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="callResultPage()">
					</td>
					<td colspan='2'></td>
				</tr>
			</table>
			<input type="hidden" name="bl_installed_yn" id="bl_installed_yn"	value="<%=bl_installed_yn%>" >
			<input type="hidden" name="batch_type" id="batch_type"	value="A" >
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

