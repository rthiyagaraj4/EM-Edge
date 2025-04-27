<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
		<form name="regprescriptionsissuetokenfooter" id="regprescriptionsissuetokenfooter" >
<%
			try{
				String	bean_id			=	"RegPrescriptionsBean" ;
				String	bean_name		=	"ePH.RegPrescriptionsBean";
				/* Initialize Function specific start */
				RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;
				//bean.setLanguageId(locale);
				ArrayList result = bean.getNationalityDetails();
%>
				<table cellpadding="0" cellspacing="0" width="50%" align="left" border="0" >
					<tr>
					<th style="font-size:xx-small" colspan="2"><fmt:message key="ePH.IssueToken.label" bundle="${ph_labels}"/></th>
					</tr>
					<tr>
						<td class="label"  width="35%"><fmt:message key="ePH.PatientCollectingMedication.label" bundle="${ph_labels}"/></td>
						<td  width="15%">&nbsp;<input type="checkbox" name="pat_coll_med" id="pat_coll_med" disabled  onClick="getMedicationCollectorDetails(this)" ></td>		
					</tr>
					<tr>
						<th style="font-size:xx-small"  colspan="2"><fmt:message key="ePH.MedicationCollectorDetails.label" bundle="${ph_labels}"/></th>
					</tr>
					<tr>
						<td colspan="2">
							<table cellpadding="0" cellspacing="0" width="80%" align="left" border="0" >
								<tr>
									<td class="label" nowrap ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
									<td >&nbsp;<input type="text" name="med_pat_name" id="med_pat_name" value="" size="23" disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="mand_img_name" style="visibility:hidden"></img></td>
								</tr>
								<tr>
									<td class="label" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
									<td > &nbsp;<select name="med_pat_gender" id="med_pat_gender" disabled><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
									<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="mand_img_gender" style="visibility:hidden"></img></td>
								</tr>
								<tr>
									<td class="label"  nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
									<td  >&nbsp;<select name="med_pat_nationality" id="med_pat_nationality" disabled><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
									<%
										for (int i=0;i<result.size();i++){
									%>
										<option value="<%=(String)result.get(i)%>"><%=(String)result.get(++i)%></option>
									<%
										}
									%>
									</select>&nbsp;
									<img src="../../eCommon/images/mandatory.gif" align="center" id="mand_img_nationality" style="visibility:hidden"></img></td>
								</tr>	
								<th colspan="2"  style="font-size:xx-small"><fmt:message key="ePH.TokenDetails.label" bundle="${ph_labels}"/></th>
								<tr>
									<td colspan="2">
										<table cellpadding="0" cellspacing="0" width="90%" align="left" border="0">
										<tr>
											<td class="label"  nowrap ><fmt:message key="Common.Series.label" bundle="${common_labels}"/>&nbsp;</td>
											<td class="label" >&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="text" name="token_series_desc" id="token_series_desc" value="" size="15" disabled><input type="hidden" name="token_series_code" id="token_series_code" value=""></td>
											<td id="next_token_no_id"  width="10%"></td>
										</tr>
										<tr>
											<td class="label"  nowrap><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;</td>
											<td >&nbsp;&nbsp;&nbsp;<input type="checkbox" name="print_token_series" id="print_token_series" disabled></td>
										</tr>
										</table>
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<%
			}
			catch(Exception e){
				e.printStackTrace();
			}
%>
		</form>
	</body>
</html>

