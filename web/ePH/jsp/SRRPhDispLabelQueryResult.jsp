<!DOCTYPE html>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
		
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/SRRPhDispLabel.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="SRRPhDispLabelQueryResult" id="SRRPhDispLabelQueryResult">
<%
			String locale			= (String)session.getAttribute("LOCALE");
			try{

				String bean_id				= "SRROnlineReportSet1Bean" ;
				String bean_name			= "ePH.SRROnlineReportSet1Bean";
				SRROnlineReportSet1Bean bean		= (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name,request) ;
				bean.setLanguageId(locale);

				String bean_id1				= "DispMedicationAllStages" ;
				String bean_name1			= "ePH.DispMedicationAllStages";
				DispMedicationAllStages disp_bean		= (DispMedicationAllStages)getBeanObject( bean_id1,bean_name1,request) ;
				disp_bean.setLanguageId(locale);
				String p_facility_id		= (String) session.getValue( "facility_id" ) ;

				String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
				String prescription_id = CommonBean.checkForNull(request.getParameter("prescription_id"));
				String p_encounter = CommonBean.checkForNull(request.getParameter("p_encounter"));
				String pract_code = CommonBean.checkForNull(request.getParameter("pract_code"));
				String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
				String locn_code = CommonBean.checkForNull(request.getParameter("locn_code"));
				String p_token_no_from = CommonBean.checkForNull(request.getParameter("p_token_no_from"));
				String p_token_no_to = CommonBean.checkForNull(request.getParameter("p_token_no_to"));
				String p_disp_locn_code = CommonBean.checkForNull(request.getParameter("p_disp_locn_code"));
				String adr_reported_date_from = CommonBean.checkForNull(request.getParameter("adr_reported_date_from"));
				String adr_reported_date_to = CommonBean.checkForNull(request.getParameter("adr_reported_date_to"));
				String p_fill_id = CommonBean.checkForNull(request.getParameter("p_fill_id"));
				String p_langue = CommonBean.checkForNull(request.getParameter("p_langue"));
				String p_printall_yn = CommonBean.checkForNull(request.getParameter("p_printall_yn"));
				String from = CommonBean.checkForNull(request.getParameter("from"));
				String to = CommonBean.checkForNull(request.getParameter("to"));

				// added for SRR20056-SCF-7214 IN2727 -start
				if(p_langue == null || p_langue.equals(""))
					p_langue = locale;
				// added for SRR20056-SCF-7214 IN2727 -end
				ArrayList result =new ArrayList();
				// Added for SKR-SCF-0589[Inc:34387]-Start
				ArrayList result1 =new ArrayList();
				HashMap	record1			= null;
				ArrayList disp_srl		= new ArrayList(); 
				ArrayList order_line_status	=  new ArrayList();//Added for SKR-SCF-0589[Inc:34387]
				ArrayList dispdtl_no	=  new ArrayList();//Added for SKR-SCF-0589[Inc:34387
				result=bean.getDispLabelList(patient_id,adr_reported_date_from,adr_reported_date_to,p_encounter,p_token_no_from,p_token_no_to,p_disp_locn_code,locn_type,locn_code,p_facility_id,locale,p_fill_id,p_langue,p_printall_yn,prescription_id,pract_code,from,to);

				if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
%>
					<table cellpadding=0 cellspacing=0 align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
								// For display the previous/next link
								out.println(result.get(0));
%>
							</td>
						</tr>
					</table>
      
	
					<table cellpadding="0" cellspacing="0" width="98%" align="center" border="1" id="reprint_rep">
						<tr>
							<th  nowrap><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></th>
							<th  nowrap><fmt:message key="ePH.TokenNo./DailySeqNo.label" bundle="${ph_labels}"/></th>
							<th  nowrap><fmt:message key="ePH.FillID.label" bundle="${ph_labels}"/></th>
							<th  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
							<th        ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
							<th  nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/></th  >
							<th  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
							<th  nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
						</tr>
<%
						String []record=new String[11];
						for (int i=1;i<result.size();i++){
							record= (String[])result.get(i);
							String classvalue="";
							if ( i % 2 == 0 )
								classvalue = "QRYEVEN" ;
							else
								classvalue = "QRYODD" ;
							//Added for SKR-SCF-0589[Inc:34387]-Start
							result1=bean.getPatientActiveOrders(record[3],"CR",record[0],record[5],p_disp_locn_code,p_facility_id,locale,record[1],p_langue);
							String disp_no="";
							String srl_no="";
							String orderline_status="";	//Added for SKR-SCF-0589[Inc:34387]
							
							for(int j=0;j<result1.size();j++){
								record1=(HashMap)result1.get(j);
								disp_no			    =  record1.get( "disp_no" )==null?"":(String) record1.get( "disp_no" );
								srl_no			    =  record1.get( "srl_no" )==null?"":(String) record1.get( "srl_no" );				
								orderline_status   =  record1.get( "order_line_status" )==null?"":(String) record1.get( "order_line_status" );	//Added for SKR-SCF-0589[Inc:34387]
								dispdtl_no.add(j,disp_no);
								disp_srl.add(j,srl_no);
								order_line_status.add(j,orderline_status);	//Added for SKR-SCF-0589[Inc:34387]
							}//Added for SKR-SCF-0589[Inc:34387]-End
							//Below record_date is passed instead of record[0] by Archana Dhal related to IN025078
						
							String record_date=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale);

							if( (record[1] == null)  || (record[1].equals("")))  record[1] ="&nbsp";
							if( (record[2] == null)  || (record[2].equals("")))  record[2] ="&nbsp";
							//out.println("record[2]"+record[2]);
							// in showPrintReport() call 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
	%>
							<tr>
								<td class="<%=classvalue%>" style="font-size=9" nowrap><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>','<%=record[3]%>','<%=record[5]%>','CR','<%=p_disp_locn_code%>','<%=record[1]%>','<%=p_langue%>')"><%=record_date%></font></td>
								<td class="<%=classvalue%>" style="font-size=9" nowrap><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>','<%=record[3]%>','<%=record[5]%>','CR','<%=p_disp_locn_code%>','<%=record[1]%>','<%=p_langue%>')"><%=record[1]%></font></td>
								<td class="<%=classvalue%>" style="font-size=9" nowrap><%=record[2]%></td>
								<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[3]%></td>
								<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[4]%></td>
								<td class="<%=classvalue%>" style="font-size=9"        ><%=record[5]%></td>
								<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[6]%></td>			
								<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[7]%></td>	
							</tr>
<%
						}
					}
					else{
%>
						<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
							parent.frames[2].location.href = "../../eCommon/html/blank.html";
						</script>
<%
					}
%>
				</table>
			
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="from" id="from" value="">
				<input type="hidden" name="to" id="to" value="">
				<input type="hidden" name="patient_id" id="patient_id" value="">
				<input type="hidden" name="p_token_no_from" id="p_token_no_from" value="">
				<input type="hidden" name="p_token_no_to" id="p_token_no_to" value="">
				<input type="hidden" name="adr_reported_date_from" id="adr_reported_date_from" value="">
				<input type="hidden" name="adr_reported_date_to" id="adr_reported_date_to" value="">
				<input type="hidden" name="p_encounter" id="p_encounter" value="">
				<input type="hidden" name="p_disp_locn_code" id="p_disp_locn_code" value="">
				<input type="hidden" name="pract_code" id="pract_code" value="">
				<input type="hidden" name="prescription_id" id="prescription_id" value="">
				<input type="hidden" name="locn_type" id="locn_type" value="">
				<input type="hidden" name="locn_code" id="locn_code" value="">
				<input type="hidden" name="p_fill_id" id="p_fill_id" value="">
				<input type="hidden" name="p_langue" id="p_langue" value="<%=p_langue%>">
				<!--Added for SKR-SCF-0589[Inc:34387 Start -->
				<input type="hidden" name="disp_srl_no" id="disp_srl_no" value="<%=disp_srl%>">
				<input type="hidden" name="dispdtl_no" id="dispdtl_no" value="<%=dispdtl_no%>">
				<input type="hidden" name="order_line_status" id="order_line_status" value="<%=order_line_status%>">
				<!--Added for SKR-SCF-0589[Inc:34387] End -->
<% 
				putObjectInBean(bean_id,bean,request); 
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
%>

		</form>
	</body>
</html>

