<!DOCTYPE html>

<%
/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

20/10/2020      IN073108    		Nijitha				20/10/2020       Ramesh G       ML-MMOH-CRF-1546
15/03/2021		15904				Durga Natarajan		15/03/2021		 Ramesh G		ALPHA-CA-Clinical Notes Audit Trail Report-Label Issue
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="eCA.CAClinicalNotesAuditTrialReportBean"%>
<%@ page import="java.sql.*,java.util.*,java.math.*,eCA.*,webbeans.eCommon.*,java.util.Date,java.text.SimpleDateFormat,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	ArrayList resultsData = new ArrayList();
	ArrayList noteDtls = new ArrayList();
	
	String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");

	String patient_id		=	(request.getParameter("patient_id")==null) ?	""	:	request.getParameter("patient_id");
	String encounter_id		=	(request.getParameter("encounter_id")==null) ?	""	:	request.getParameter("encounter_id");
	String noteType			=	(request.getParameter("noteType")==null)?"":request.getParameter("noteType");
	String accessionNum 	= 	(request.getParameter("accessionNum")==null)?"":request.getParameter("accessionNum");
	String recordedFacility 	= 	(request.getParameter("recordedFacility")==null)?"":request.getParameter("recordedFacility");
	String calledFromOption 	= 	(request.getParameter("calledFromOption")==null)?"":request.getParameter("calledFromOption");

	String prev_content_text = "";

	CAClinicalNotesAuditTrialReportBean auditTrialReportBean = new CAClinicalNotesAuditTrialReportBean();

	String	action_date_time	=	"";
	String  patientName 		=	"";
	String 	printDate			= 	"";
	String 	locationName		=	"";
	String	noteTypeDesc		= 	"";  
	String 	clinician_name		=	"";
	String 	siteName			=	"";
	String	facilityName		=	"";
	String	action_type			=	"";		
	String 	action_desc			=	"";
	String	prev_action_type 	= 	"";
	String	content_text		=	"";
	String	action_comment		=	"";		
	String 	action_status		=	"";
	String	prev_action_comment	=	"";
	String  action_date_time_th =	"";
	String  requested_by_pract	=	"";
	String  prev_requested_by_pract	=	"";
	String  prev_clinician_name	=	"";
	String	requested_time		=	"";
	String	requested_time_th   =	"";
	String	prev_action_date_time_th   =	"";
	String privilege_type 		= 	"";
	String specialtyDesc 		= 	"";
	long	clob_length			=	0;
	String[] note_content = new String[3];

HashMap clinicalnoteDtls = new HashMap();
System.out.println("-----localeName------->"+localeName+"<---------------");
System.out.println("-----patient_id------->"+patient_id+"<---------------");
System.out.println("------encounter_id------>"+encounter_id+"<---------------");
System.out.println("------facilityId------>"+facilityId+"<---------------");
System.out.println("------note_type------>"+noteType+"<---------------");
resultsData = auditTrialReportBean.getClinicalNotesAuditTrialPreviewDtls(localeName,accessionNum);
patientName = auditTrialReportBean.getPatientName(localeName,patient_id);
printDate =  auditTrialReportBean.getPrintDate(localeName);
locationName = auditTrialReportBean.getLocationName(localeName,patient_id,encounter_id,recordedFacility);
noteTypeDesc	= auditTrialReportBean.getNoteTypeDesc(noteType);
siteName		= auditTrialReportBean.getSiteName(localeName);
facilityName	= auditTrialReportBean.getFacilityName(facilityId,localeName);
%>
<!-- <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<title>Clinical Notes Audit Report</title>
</head>
<style>
	ADDRESS	{ 
			FONT-FAMILY: Verdana ;
		FONT-SIZE: 10pt ; 
		FONT-STYLE: NORMAL; 
		COLOR: BLACK; 
		}
		/* IN054024 Start. */
		PRE
		{
			font-size:10pt;			
			font-family: Verdana;
			//BACKGROUND-COLOR: #E2E3F0;
			BACKGROUND-COLOR: #FFFFFF;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;			
		}
		/* IN054024 End. */
</style>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" <%if("Print".equals(calledFromOption)){%> onLoad = "Print();" <%}%>>
<form name='printClinicalAuditTrail' id='printClinicalAuditTrail'>	
	<table width='100%' border="0">
		<tr>
			<td>
				<table width='99%'  align='center' border="0">
					<tr>
						<td width='20%' align='center' id='headerImageID' rowspan="3" valign="middle">
							<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='50' height='50'>
						</td>
						<td width='60%' colspan='2' align='center'>
							<h3><%=siteName%></h3>
						</td>						
						<td align="rigth" width='20%'>
							<%=printDate%>
						</td>								
					</tr>
					<tr>								
						<td width='60%' colspan='2' align='center'>
							<h4><%=facilityName%></h4>
						</td>						
						<td align="rigth" width='20%' rowspan="2">
							&nbsp;
						</td>								
					</tr>
					<tr>
						<td width='60%' colspan='2' align='center'>
							<h4><fmt:message  key="eCA.ClinicalNoteAuditTrial.label" bundle="${ca_labels}"></fmt:message></h4>
						</td>						
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>	
		<tr>
			<td>
				<table width='99%'  align='center' border="0">
					<tr valign="top">
						<td width='15%' align='left'>	<b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></td>
						<td width='1%' align='center'>	<b>:</b></td>
						<td width='29%' align='left'>	<b><%=patient_id %></b></td>
						
						<td width='15%' align='left'>	<b><fmt:message key="eCA.PatientName.label" bundle="${ca_labels}"/></b></td>
						<td width='1%' align='center'>	<b>:</b></td>
						<td width='39%' align='left'>	<b><%=patientName%></b></td>
					</tr>
					<tr valign="top">
						<td width='15%' align='left'>	<b><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></b></td>
						<td width='1%' align='center'>	<b>:</b></td>
						<td width='29%' align='left'>	<b><%=encounter_id %></b></td>
						
						<td width='15%' align='left'>	<b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></td>
						<td width='1%' align='center'>	<b>:</b></td>
						<td width='39%' align='left'>	<b><%=locationName%></b></td>
					
					</tr>				
				</table>
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>			
				<table width='99%'  align='center' style="border: 1px solid black;">
					<tr >
						<td>
							<table width='100%'  align='center' style="border: 1px solid black;">
								<tr>
									<td width='15%' align='left'>	<b><fmt:message  key="Common.NoteType.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='84%' align='left'>	<b><%=noteTypeDesc %></b></td>
								</tr>				
							</table>			
						</td>
					</tr>
					<tr><td>&nbsp;</td></tr>
				
					<%	
					for(int k=0; k<resultsData.size(); k++){
						if(k!=0){
						%>
						<tr >
							<td  align='center'>
							--------------------------------------------------------------------------------------------------------------------------------------
						
						</td></tr>
						<% 
						}
						String[] report_details = (String[])resultsData.get(k);
												
						action_date_time	=	report_details[0];
						if(action_date_time.equals("")){
							action_date_time	="&nbsp;";
							action_date_time_th	= "&nbsp;";
						}else
							action_date_time_th	=	com.ehis.util.DateUtils.convertDate(action_date_time,"DMYHMS","en",locale);

						clinician_name		=	report_details[1];
						action_type			=	report_details[2];
						action_status		=	report_details[3];
						action_comment		=	report_details[4];
						requested_by_pract	=	report_details[5];
						requested_time		=	report_details[6];
						privilege_type		=	report_details[7];
						specialtyDesc		=	report_details[8];
						clob_length =	Long.valueOf(report_details[9]);
						
						noteDtls = auditTrialReportBean.getNoteContent(localeName,accessionNum,action_date_time);
						if(null!=noteDtls && noteDtls.size() > 0)
							note_content = (String[])noteDtls.get(0);
									
						if( ( action_type.equals("RV") || action_type.equals("SN") || action_type.equals("PR")) && ( clob_length >0 ) ){
							content_text= note_content[0];
						}/* else{
							content_text = "&nbsp;";
						}
						 */
						if(action_status.equals("CO")){
							if(action_type.equals("TR"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
							else if(action_type.equals("PR"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Recorded.label","ca_labels");
							else if(action_type.equals("RV"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
								//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
							else if(action_type.equals("SN")){
								if(privilege_type.equals("1")){
									action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels") + " - " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
								}
								if(privilege_type.equals("2"))
								{
									action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels") + " - " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.forwardedForAuth.label","ca_labels");
								}
								else{
									action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
									//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels");
								}
							}else if(action_type.equals("ER"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.InError.label","ca_labels");
							else if(action_type.equals("RS"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
							else if(action_type.equals("FS"))
								//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ specialtyDesc+" - "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
							else if(action_type.equals("SP"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+"-"+ requested_by_pract ;

							else if(action_type.equals("SS"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ specialtyDesc;			
				
						}else if(action_status.equals("RQ")){
							if(action_type.equals("RV"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingReview.label","ca_labels");
							else if(action_type.equals("SN"))
							{ 
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingSign.label","ca_labels");
								//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
							}
							else if(action_type.equals("RS"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.received.label","common_labels");

							else if(action_type.equals("FS"))
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingReview.label","ca_labels")+" "+ specialtyDesc;								
						}else if(action_status.equals("RJ")){
								action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
						}
						if(action_date_time==null)	content_text	=	"&nbsp;";
									
						if ( k == 0 ){
							content_text =  auditTrialReportBean.getClinicalNotesContentLastModified(localeName,accessionNum,action_date_time);		
							
						}else{
							content_text=  prev_content_text;
							if((action_type.equals("TR") || prev_action_type.equals("ER") || action_type.equals("PR") || action_type.equals("SN") || action_type.equals("RV")  || action_type.equals("SP")) && "".equals(content_text))
							{
								content_text =  auditTrialReportBean.getClinicalNotesContentLastModified(localeName,accessionNum,action_date_time);	 
								prev_content_text = content_text;
							}
							
						}
						
						if(action_type.equals("SN")){
					%>
					<tr>
						<td>
							<table width='99%'  align='center' border="0">
								<tr valign="top">
									<td width='15%' align='left'>	<b><fmt:message  key="Common.authorizedby.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='34%' align='left'>	<b><%=clinician_name %></b></td>
									
									<td width='25%' align='left'>	<b><fmt:message  key="Common.Authorized.label" bundle="${common_labels}"/>&nbsp;<fmt:message  key="Common.datetime.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='24%' align='left'>	<b><%=action_date_time %></b></td>
								</tr>
								<tr valign="top">	
									<td width='15%' align='left'>	<b><fmt:message  key="Common.status.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='84%' align='left' colspan="4">	<b><%=action_desc %></b></td>
								</tr>						
							</table>
						</td>
					</tr>	
					<%
					}else if(action_type.equals("RV")){			
					%>
					<tr>
						<td>
							<table width='99%'  align='center' border="0">
								<tr valign="top">
									<td width='15%' align='left'>	<b><fmt:message  key="Common.modifiedby.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='34%' align='left'>	<b><%=clinician_name %></b></td>
									
									<td width='25%' align='left'>	<b><fmt:message  key="Common.modifieddatetime.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='24%' align='left'>	<b><%=action_date_time %></b></td>
								</tr>
								<tr valign="top">	
									<td width='15%' align='left'>	<b><fmt:message  key="Common.status.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='84%' align='left' colspan="4">	<b><%=action_desc %></b></td>
								</tr>
								<tr valign="top">	
									<td width='15%' align='left'>	<b><fmt:message  key="Common.Modify.label" bundle="${common_labels}"/>&nbsp;<fmt:message  key="Common.remarks.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='84%' align='left' colspan="4">	<b><%=action_comment%></b></td>							
								</tr>						
							</table>
						</td>
					</tr>
					<%
					}else{
					%>
					<tr>
						<td>
							<table width='99%'  align='center' border="0">
								<tr valign="top">
									<td width='15%' align='left'>	<b><fmt:message  key="Common.Performed.label" bundle="${common_labels}"/> <fmt:message  key="Common.by.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='34%' align='left'>	<b><%=clinician_name %></b></td>
									
									<td width='25%' align='left'>	<b><fmt:message  key="Common.Performed.label" bundle="${common_labels}"/>&nbsp;<fmt:message  key="Common.datetime.label" bundle="${common_labels}"/></b></td> <!-- 15904 Bundle changed from ca to common -->
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='24%' align='left'>	<b><%=action_date_time %></b></td>
								</tr>
								<tr valign="top">	
									<td width='15%' align='left'>	<b><fmt:message  key="Common.status.label" bundle="${common_labels}"/></b></td>
									<td width='1%' align='center'>	<b>:</b></td>
									<td width='84%' align='left' colspan="4">	<b><%=action_desc %></b></td>
								</tr>						
							</table>
						</td>
					</tr>
					<%
					}
					%>
					<tr>
						<td>
							<table width='99%'  align='center' border="0">
								<tr>
									<td width='100%' align='left'>
									<%=content_text%>
									</td>							
								</tr>						
							</table>
						</td>
					</tr>			
					<%			
						prev_action_type = action_type;
						prev_requested_by_pract = requested_by_pract; 
						prev_clinician_name = clinician_name; 
						prev_action_date_time_th = action_date_time_th;
						prev_action_comment = action_comment;
						if(null!=note_content[0] && !"".equals(note_content[0]))
							prev_content_text = note_content[0];
					
					}
					%>
				</table>
			</td>
		</tr>	
	</table>
	<script>
				function Print() 
				{
					if (document.all) {
						var i = 0;		
						while( i < document.applets.length ) 
						{
							var j = 0 ;
							while ( !document.applets[i].isActive() && j++ <=75000 ) 
								window.status = i;
							i++;
						}	
					}
					window.print();
					setTimeout(function() { window.close(); },2500);					
				}
			</script>
</form>
</body>
</html>

