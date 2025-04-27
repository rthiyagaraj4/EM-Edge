<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/CapturePregnencyDetail.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--  added for 40685-->
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0"> 
		<form name="frmPatientDetails" id="frmPatientDetails" >
			<table cellpadding="0" cellspacing="0" height="10%" width="100%"  border="5" id="patient_details" > 
<%
			try{	
				 String bean_id		= "CapturePregnencyDetailBean";
				 String bean_name	= "ePH.CapturePregnencyDetailBean";

				CapturePregnencyDetailBean bean = (CapturePregnencyDetailBean)getBeanObject( bean_id,bean_name,request) ;
				bean.setLanguageId(locale);
				String reqString = request.getQueryString();
				
				String patient_id = request.getParameter("patient_id");
				String encounter_id = request.getParameter("encounter_id");
				String locn_desc = request.getParameter("locn_desc");
				String locn_code = request.getParameter("locn_code");
				String pract_name = request.getParameter("pract_name");
				String admin_date = request.getParameter("admin_date");
				String from	= CommonBean.checkForNull(request.getParameter("from"));
				String to	= CommonBean.checkForNull(request.getParameter("to"));
				ArrayList pregdetails				    =	null;
				String pregenant_yn="",lmp_date="",expd_delv_date="",actu_delv_date="",pregn_status_ind="",pract_id="",remarks=""; 
				String visible="";
				String srl_no="";
				String mode ="";
				String login_user_name="";
				int status_count =bean.getStatusCount(patient_id);
				ArrayList patientdetails = bean.getPatientDetails(patient_id);
				String visibility="";
				boolean pregn_status_ind_flag = false; //code added for IN040586
				String pregn_yn_ind_flag = ""; //added for 40685

				if(status_count==0){
					 mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");
				}
				else
					 mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY");
				if(patientdetails.size()>0){
					String patient_name       = (String)patientdetails.get(0);
					String age				  = (String)patientdetails.get(1);
					String sex			   	  = (String)patientdetails.get(2);
					String date_of_birth	  = (String)patientdetails.get(3);
					
					if(sex.equalsIgnoreCase("female"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else if(sex.equalsIgnoreCase("male"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(sex.equalsIgnoreCase("unknown"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
					<tr>
						<th class="commontoolbarfunction"  >&nbsp;<%=patient_id%>&nbsp;,&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>,&nbsp;<%=date_of_birth%>,&nbsp;<%=age%></th>
					</tr>
<%
					if(!encounter_id.equals("")){
%>
						<tr>
						   <th class="commontoolbarfunction"  >&nbsp;<%=encounter_id%>&nbsp;,&nbsp;<%=locn_desc%>,&nbsp;<%=pract_name%>,&nbsp;<%=admin_date%>
							</th>
						</tr>
<%
					}
%>
					</table>
					<script>parent.f_query_result1.location.href="../../ePH/jsp/CapturePregnencyDetailsAddModify.jsp?<%=reqString%>";</script>
<%
					pregdetails=(ArrayList)bean.getpregdetails(patient_id,encounter_id,from,to);
					if( (pregdetails.size()>=2) && ( !( ((String) pregdetails.get(0)).equals("0")) )){
%>
						<table id="" cellpadding=0 cellspacing=0 align="center" width='96%'>
							<tr>
								<td width="80%" class="white">&nbsp;</td>
								<td width="20%" class="white">&nbsp;
<%
								// For display the previous/next link
								out.println(pregdetails.get(0));
%>
								</td>
							</tr>
						</table>

						<table id="querypage" cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
							<tr>
								<th><fmt:message key="ePH.Pregnant.label" bundle="${ph_labels}"/></th>
								<th><fmt:message key="ePH.LastMenstrualPeriod.label" bundle="${ph_labels}"/></th>
								<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
								<th><fmt:message key="ePH.ActualDeliveryDate.label" bundle="${ph_labels}"/></th>
								<th><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
								<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
							</tr>
<%
							for(int i=1;i<pregdetails.size();i+=8){
								visibility="visibility:visible";
								pregenant_yn =(String)pregdetails.get(i);
								lmp_date =(String)pregdetails.get(i+1)==null?"":(String)pregdetails.get(i+1);
								expd_delv_date =(String)pregdetails.get(i+2)==null?"":(String)pregdetails.get(i+2);
								actu_delv_date =(String)pregdetails.get(i+3)==null?"":(String)pregdetails.get(i+3);
								pregn_status_ind =(String)pregdetails.get(i+4);
								pract_id =(String)pregdetails.get(i+5);
								login_user_name=bean.getPractitionerName(pract_id,locale);
								if(login_user_name!=null && !login_user_name.equals("")){
									login_user_name=login_user_name.replaceAll(" ","%20");
									login_user_name = java.net.URLEncoder.encode(login_user_name,"UTF-8");
									login_user_name=login_user_name.replaceAll("%2520","%20");
								}
								remarks =(String)pregdetails.get(i+6)==null?"":(String)pregdetails.get(i+6);// added null check for CRF-PH- RUT-CRF-0063/01 Null [IN:040486]
								if(remarks!=null && !remarks.equals("")){
									remarks=remarks.replaceAll(" ","%20");
									remarks = java.net.URLEncoder.encode(remarks,"UTF-8");
									remarks=remarks.replaceAll("%2520","%20");
								}
								srl_no  =(String)pregdetails.get(i+7);
								if(!locale.equals("en")){
									lmp_date  = DateUtils.convertDate(lmp_date, "DMY","en",locale);
									expd_delv_date  = DateUtils.convertDate(expd_delv_date, "DMY","en",locale);
									actu_delv_date  = DateUtils.convertDate(actu_delv_date, "DMY","en",locale);
								}

								String classvalue	= "";
								if ( i % 2 == 0 )
									classvalue = "QRYEVEN" ;
								else
									classvalue = "QRYODD" ;
								if(pregn_status_ind.equals("A")){
									pregn_status_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
									pregn_status_ind_flag = true; // code added for IN040586
								}
								else{
									pregn_status_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels");
									pregn_status_ind_flag = false; // code added for IN040586
								}
								if(pregenant_yn.equals("Y")){
									pregenant_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
									pregn_yn_ind_flag="Y";//added for 40685
								}
								else{
									pregenant_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
									pregn_yn_ind_flag="N";//added for 40685
								}
								//if(pregn_status_ind.equals("Active")){ //code commented for IN040586
								if(pregn_status_ind_flag){// code added for IN040586
									
%>
								<tr>
									<td align="left" class="<%=classvalue%>"><label style="cursor:pointer;color:blue" onClick="calvalues('<%=pregenant_yn%>','<%=lmp_date%>','<%=expd_delv_date%>','<%=actu_delv_date%>','<%=pregn_status_ind%>','<%=login_user_name%>','<%=remarks%>','<%=mode%>','<%=srl_no%>','<%=visibility%>','<%=pregn_status_ind_flag%>','<%=pregn_yn_ind_flag%>','<%=locale%>','<%=pract_id%>')">&nbsp;<%=pregenant_yn%>&nbsp;</label></td>
<%
	                                pregn_status_ind_flag = false; // code added for IN040586
                                    pregn_yn_ind_flag = "N"; //  added for 40685
							}
							else{
%>
								 <tr>
									<td align="left" class="<%=classvalue%>">&nbsp;<%=pregenant_yn%>&nbsp;</td>
<%
							}
%>
							<td align="left" class="<%=classvalue%>">&nbsp;<%=lmp_date%>&nbsp;</td>
							<td align="left" class="<%=classvalue%>">&nbsp;<%=java.net.URLDecoder.decode(login_user_name,"UTF-8")%>&nbsp;</td>
							<td align="left" class="<%=classvalue%>">&nbsp;<%=actu_delv_date%>&nbsp;</td>
							<td align="left" class="<%=classvalue%>">&nbsp;<%=pregn_status_ind%>&nbsp;</td>
							<td align="left" class="<%=classvalue%>">&nbsp;
<%
							if(remarks!=null && !remarks.equals("")){
%>
								<font class="HYPERLINK" style="cursor:pointer" onClick="showRemarks('<%=patient_id%>','<%=srl_no%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font>
<%
							}
%>
							</td>
<%
						}
					}
				}
				else{
%>
					<script>alert(getMessage('PH_PATIENT_PREG_APPL','PH'));</script>
<%
				}
%>   
				<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
				<input type="hidden" name="from" id="from" value="">
				<input type="hidden" name="to" id="to" value="">
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">
				<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
				<input type="hidden" name="lmp_date" id="lmp_date" value="<%=lmp_date%>">
				<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
				<input type="hidden" name="pregn_status_ind" id="pregn_status_ind" value="<%=pregn_status_ind%>">
				<input type="hidden" name="visibility" id="visibility" value="<%=visibility%>">
				<input type="hidden" name="locn_code" id="locn_code" value="<%=locn_code%>">
				<input type="hidden" name="pract_name" id="pract_name" value="<%=pract_name%>">
				<input type="hidden" name="admin_date" id="admin_date" value="<%=admin_date%>">
				<input type="hidden" name="locn_desc" id="locn_desc" value="<%=locn_desc%>">
				<input type="hidden" name="expd_delv_date" id="expd_delv_date" value="">
				<input type="hidden" name="actu_delv_date" id="actu_delv_date" value="">
				<input type="hidden" name="sys_date" id="sys_date" value="<%=DateUtils.convertDate(bean.getSysDate(), "DMY","en",locale)%>">
				</form>
<% 
				putObjectInBean(bean_id,bean,request);
			}
			catch(Exception e){
				out.println(e);
			}
%>
		
	</body>
</html>

