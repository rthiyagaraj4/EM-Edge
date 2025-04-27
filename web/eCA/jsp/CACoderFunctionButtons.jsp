<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
20/08/2020	IN073540	    Chandrashekar										AAKH-CRF-0122.3
31/10/2022                  Kamatchi S                                          TH-KW-CRF-0143
16/03/2022       41064             krishna pranay             16/03/2023     Ramesh Goli              AAKH-CRF-0172
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/CoderFunction.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String bean_id1					= "NewClinicalEventHistBean" ;
	String bean_name1				= "eCA.NewClinicalEventHistBean";
	String clinician_id				= (String) session.getValue("ca_practitioner_id");
	String resp_id					= (String)session.getValue("responsibility_id");
	String SessionId            = request.getParameter("session_id");//V230406 AAKH-CRF-0172
	String userid		= (String) session.getValue( "report_connect_string" ) ;
	String self_submit	= "YES";
	String facility	= (String) session.getValue( "facility_id" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String login_user = (String)session.getValue("login_user"); 
	String Clin_id=(String)session.getValue("ca_practitioner_id");
	String desformat="pdf";
	String destype="cache",report_option="V";
	String machine_name="",reqdate="",report="",server="",copies="",queue_name="";
	String message="",app_server_ip="",rep_server_key="",report_Server="";
	ArrayList viewing=new ArrayList();  
	NewClinicalEventHistBean bean1	= (NewClinicalEventHistBean)getBeanObject( bean_id1, bean_name1 , request) ; 
	viewing=bean1.viewCall(facility,ws_no,reportServer,userid,report_option);
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
	String bg_color       ="#A0A0A0";
	String bg_col1   ="#FFA500";
	String bg_col2   ="#008000";
	String bg_col3 ="#ffc0cb";//41064
    String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String patient_class = request.getParameter("patient_class");
	String mode  ="";
	String up_remarks ="";
	String up_status  ="";
	String prev_status ="";
	String completed_date ="";
	String completed_by ="";
	String supervisor_by ="";//41064
	String supervisor_date ="";//41064
      String classValue = "" ;//41064
	// 41064 start
	String supervisor_yn =""; ////41064
	supervisor_yn=(String)bean.getsupervisor(login_user);//41064
	
	String disabled="";
	
	// 41064 end
	//Added by Kamatchi S for TH-KW-CRF-0143 START
	String episode_type = request.getParameter("episode_type");
	if(patient_class.equals("DC"))
		episode_type = "D";
	if(patient_class.equals("EM"))
		episode_type = "E";
	String episode_id = "";
	if(episode_type.equals("O") || episode_type.equals("E"))
	episode_id = request.getParameter("episode_id_new");
	if(episode_type.equals("I") || episode_type.equals("D"))
	 episode_id = request.getParameter("episode_id");
	String visit_Id = request.getParameter("visit_Id");
	Connection con	= null;
	con = ConnectionManager.getConnection(request);
	Boolean siteSpecServiceCode = false;
	String coderClearanceStatus = "";
	//41064 start
	String supervisorApplYN="N";
	boolean siteSupervisor =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CA_SUPERVISOR_CLEARANCE");//41064
	if(siteSupervisor)
		supervisorApplYN="Y";
     //41064 end
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_SERVICE_CODE_REQD");
	
	coderClearanceStatus = bean.getCoderClearanceStatus(facility,patient_id,episode_type,episode_id,visit_Id);
	//Added by Kamatchi S for TH-KW-CRF-0143 END
	System.err.println("patient_id@@==="+patient_id+"encounter_id@@==="+encounter_id+"patient_class@@==="+patient_class);
	ArrayList status_record =bean.getCoderStatus(patient_id,encounter_id);
	System.err.println("status_record=="+status_record);
	if(status_record.size()>0){
		up_remarks =(String)status_record.get(0)==null?"":(String)status_record.get(0);
		up_status  =(String)status_record.get(1)==null?"":(String)status_record.get(1);
		prev_status =(String)status_record.get(1)==null?"":(String)status_record.get(1);
		completed_date = (String)status_record.get(2)==null?"":(String)status_record.get(2);
		completed_by= (String)status_record.get(3)==null?"":(String)status_record.get(3);
		supervisor_date = (String)status_record.get(4)==null?"":(String)status_record.get(4);//41064
		supervisor_by= (String)status_record.get(5)==null?"":(String)status_record.get(5);//41064
		mode ="update";
	}else{
		mode ="insert";
	}
	//41064 start
		String billed_yn=(String)bean.getbilledYN(facility,patient_id,episode_type,episode_id,visit_Id);
		if(billed_yn !=null && billed_yn !="" && billed_yn.equals("N") && ("CO".equals(up_status)||"SC".equals(up_status))){  
		disabled="";
		}
		else{
			disabled="disabled";
		}
		//41064 end
	if(viewing.size() >= 8){
			report=(String)viewing.get(0);
			server=(String)viewing.get(1);
			copies=(String)viewing.get(2);
			queue_name=(String)viewing.get(3);
			message=(String)viewing.get(4);
			app_server_ip=(String)viewing.get(5);
			rep_server_key=(String)viewing.get(6);
			report_Server=(String)viewing.get(7);
		}

System.err.println("up_remarks@@==="+up_remarks+"up_status==="+up_status+"prev_status==="+prev_status);
%>
<!-- onLoad Added by Kamatchi S for TH-KW-CRF-0143-->
<body onload="enableStatus('<%=coderClearanceStatus%>');" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
     <form name='coderButtons' id='coderButtons' action="../../servlet/eCA.CACoderFunctionServlet" method="post" target="messageFrame">


	   
			<table width='100%' id='remarks_tab' class='grid' align='center' >
			<TR>

                    <th class='fields'><fmt:message key="eCA.CompleteStatus.label" bundle="${ca_labels}"/></th>
				</TR>
				
				<TR><td class="remarks" style='background-color: <%=bg_color%>'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
                   <td class=fields><TextArea cols='200' name='remarks' value='' onKeyPress="return ChkMaxLen('<fmt:message key='Common.remarks.label' bundle='${common_labels}'/>',this,4000)" onBlur='chkRemarksLength(this,4000)'><%=up_remarks%></TextArea></td>
                </TR>
       </table>

	   
			<table width='100%' id='remarks_tab' class='field' align='center' >
			<TR>

			   <td class='label' style='background-color: <%=bg_color%>'><fmt:message key="eCA.DoctorQuery.label" bundle="${ca_labels}"/><td>
				<td><input type="checkbox"  value="" id="doct_qry" name="doct_qry" id="doct_qry" onclick="setCheck(this,'DQ')"> </td>
			  
			   <td class='label' style='background-color: <%=bg_color%>'><fmt:message key="eCA.SupervisorQuery.label" bundle="${ca_labels}"/><td>
				<td><input type="checkbox"  value="" id="sup_qry" name="sup_qry" id="sup_qry" onclick="setCheck(this,'SQ')"> </td>
			  
			   <td class='label' style='background-color: <%=bg_color%>'><fmt:message key="Common.Hold.label" bundle="${common_labels}"/><td>
				<td><input type="checkbox"  value="" id="hold_qry" name="hold_qry" id="hold_qry" onclick="setCheck(this,'HD')"> </td>
			  
			   <td class='label' style='background-color: <%=bg_col1%>' ><fmt:message key="Common.PartiallyCompleted.label" bundle="${common_labels}"/><td>
				<td><input type="checkbox"  value="" id="par_complete" name="par_complete" id="par_complete" onclick="setCheck(this,'PC')"> </td>
			  
			   <td class='label' style='background-color: <%=bg_col2%>'><fmt:message key="Common.complete.label" bundle="${common_labels}"/><td>
				<td><input type="checkbox"  value="" id="complete" name="complete" id="complete" onclick="setCheck(this,'CO')"> </td>
				
				<!-- -41064 start -->
				<% if(supervisor_yn !=null && supervisor_yn.equals("Y") && siteSupervisor){ %>
				<td class='label' style='background-color: <%=bg_col3%>'width='15%'><fmt:message key="eCA.supervisorCleranceCompleted.label" bundle="${ca_labels}"/><td>
				<td><input type="checkbox"  value="" id="sup_cl_complete" name="sup_cl_complete" id="sup_cl_complete" onclick="setCheck(this,'SC')"  <%=disabled%>> </td>
			
				<% } else{%>
				<input type="hidden"  value="N" id="sup_cl_complete" name="sup_cl_complete" id="sup_cl_complete" >
				<%}%>
					<!-- -41064 end -->
		  </TR>

       </table>

          <table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
				<tr>
				    <td class='label' ><fmt:message key="eCA.Author.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/>:<td>
					<td width ="20%"> &nbsp;<%=completed_by%> </td>
					<td class='label' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>:<td>
					<td width ="20%"> &nbsp;<%=completed_date%> </td>
					<% if(siteSpecServiceCode){%><!-- Added by Kamatchi S for TH-KW-CRF-0143-->
					<td><input type='button'  name='Cancel' id='Cancel' id='Cancel' onclick="cancelCoder();" value="<fmt:message key='eBL.CancelCC.label' bundle='${bl_labels}'/>"></td>
					<td >&nbsp;</td>
					<td><input type='button' name='Generate' id='Generate' id='Generate' onclick="generateCoder();" value="<fmt:message key='eBL.GenerateCC.label' bundle='${bl_labels}'/>"></td>
					<%}%>
					<td align='right' width='80%'><input type='button' class='button' name='preview' id='preview' onclick="run()" value="<fmt:message key='eCA.Preview.label' bundle='${ca_labels}'/>">
					<input type='button' class='button' name='save' id='save' id="btn_save"onclick="apply()" value="<fmt:message key='Common.Save.label' bundle='${common_labels}'/>"></td>
				    </tr>
				    <!-- 41064 start -->
				    <tr>
					<% if(supervisor_yn !=null && supervisor_yn.equals("Y") && siteSupervisor){ %>
					 <td class='label' ><fmt:message key="eCA.Audited.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="eCA.by.label" bundle="${ca_labels}"/>:<td>
					<td width ="20%"> &nbsp;<%=supervisor_by%> </td>
					<%} %>				
					<% if(supervisor_yn !=null && supervisor_yn.equals("Y") && siteSupervisor){ %>
					<td class='label' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>:<td>
					<td width ="20%"> &nbsp;<%=supervisor_date%> </td>
					<%} %>	
					<% if(supervisor_yn !=null && supervisor_yn.equals("Y") && siteSupervisor){ %> 
					<td class='classValue' width='8%'><font size=1>
					<a class='gridLink'  href="javascript:AuditTrail('<%=patient_id%>','<%=encounter_id%>','<%=facility%>','<%=locale%>');" >Audit Trail</a>
					</font></td>
					<%} %>
					<!-- 41064 end -->
				</tr>
           </table>
        

<input type=hidden id = 'patient_id ' name='patient_id' id='patient_id' value=<%=patient_id%>>	
<input type=hidden  id ='encounter_id' name='encounter_id' id='encounter_id' value=<%=encounter_id%>>	
<input type=hidden id ='patient_class' name='patient_class' id='patient_class' value=<%=patient_class%>>	
<input type=hidden name='bean_id' id='bean_id' value=<%=bean_id%>>	
<input type=hidden name='bean_name' id='bean_name' value=<%=bean_name%>>	
<input type=hidden name='called_from' id='called_from' value="CODER_SEARCH">	
<input type=hidden name='mode' id='mode' value="<%=mode%>">
<input type=hidden name='status' id='status' value="<%=up_status%>">	
<input type=hidden name='prev_status' id='prev_status' value="<%=prev_status%>">
<input type='hidden' id='machine_name' name='machine_name' id='machine_name' value='<%=machine_name%>'><!-- IN070032 -->
<input type='hidden' id='locale' name='locale' id='locale' value='<%=locale%>'><!-- IN070032 -->
<input type='hidden' id='report_Server' name='report_Server' id='report_Server' value='<%=report_Server%>'><!-- IN070032 -->
<input type='hidden' id='report' name='report' id='report' value='<%=report%>'><!-- IN070032 -->
<input type='hidden' id='server' name='server' id='server' value='<%=server%>'><!-- IN070032 -->
<input type='hidden' id='copies' name='copies' id='copies' value='<%=copies%>'><!-- IN070032 -->
<input type='hidden' id='queue_name' name='queue_name' id='queue_name' value='<%=queue_name%>'><!-- IN070032 -->
<input type='hidden' id='message' name='message' id='message' value='<%=message%>'><!-- IN070032 -->
<input type='hidden' id='app_server_ip' name='app_server_ip' id='app_server_ip' value='<%=app_server_ip%>'><!-- IN070032 -->
<input type='hidden' id='rep_server_key' name='rep_server_key' id='rep_server_key' value='<%=rep_server_key%>'><!-- IN070032 -->	
<input type='hidden' id='self_submit' name='self_submit' id='self_submit' value='<%=self_submit%>'><!-- IN070032 -->
<input type='hidden' id='report_option' name='report_option' id='report_option' value='<%=report_option%>'><!-- IN070032 -->
<input type='hidden' id='destype' name='destype' id='destype' value='<%=destype%>'><!-- IN070032 -->
<input type='hidden' id='desformat' name='desformat' id='desformat' value='<%=desformat%>'><!-- IN070032 -->
<input type='hidden' id='userid' name='userid' id='userid' value='<%=userid%>'><!-- IN070032 -->
<input type='hidden' id='facility_id' name='facility_id' id='facility_id' value='<%=facility%>'><!-- IN070032 -->
<input type='hidden' id='login_user' name='login_user' id='login_user' value='<%=login_user%>'><!-- IN070032 -->
<input type='hidden' id='Clin_id' name='Clin_id' id='Clin_id' value='<%=Clin_id%>'><!-- IN070032 -->
<input type='hidden' id = 'episode_id ' name='episode_id' id='episode_id' value='<%=episode_id%>'><!--Added by Kamatchi S for TH-KW-CRF-0143-->
<input type='hidden' id = 'episode_type ' name='episode_type' id='episode_type' value=<%=episode_type%>><!--Added by Kamatchi S for TH-KW-CRF-0143-->
<input type='hidden' id = 'visit_Id ' name='visit_Id' id='visit_Id' value=<%=visit_Id%>><!--Added by Kamatchi S for TH-KW-CRF-0143-->
<input type='hidden' id = 'siteSpecServiceCode ' name='siteSpecServiceCode' id='siteSpecServiceCode' value=<%=siteSpecServiceCode%>><!--Added by Kamatchi S for TH-KW-CRF-0143-->
<input type='hidden' id = 'coderClearanceStatus ' name='coderClearanceStatus' id='coderClearanceStatus' value=<%=coderClearanceStatus%>><!--Added by Kamatchi S for TH-KW-CRF-0143-->
<input type='hidden' id = 'SessionId ' name='SessionId' id='SessionId' value=<%=SessionId%>><!--V230406-AAKH-CRF-0172-->
<input type='hidden' id = 'supervisorApplYN' name='supervisorApplYN' id='supervisorApplYN' value='<%=supervisorApplYN %>'><!-- 41064  -->

</body>
<script>
<%
        if(mode.equals("update")){
%>
	    var up_status =document.coderButtons.status.value;
         if(up_status == 'DQ'){
					document.getElementById("doct_qry").checked=true;
					
					document.getElementById("sup_qry").disabled=true;
					document.getElementById("hold_qry").disabled=true;
					document.getElementById("par_complete").disabled=true;
					document.getElementById("complete").disabled=true;
				//	document.getElementById("sup_cl_complete").disabled=true;// 41064
					document.coderButtons.status.value ="DQ";
					
				}
		else if(up_status == 'SQ'){
					document.getElementById("sup_qry").checked=true;
					document.coderButtons.status.value ="SQ";
					
					document.getElementById("doct_qry").disabled=true;
					document.getElementById("hold_qry").disabled=true;
					document.getElementById("par_complete").disabled=true;
					document.getElementById("complete").disabled=true;
					//document.getElementById("sup_cl_complete").disabled=true;//41064
					
					
				}
		else if(up_status == 'HD'){
					document.getElementById("hold_qry").checked=true;
					document.coderButtons.status.value ="HD";
					
					document.getElementById("doct_qry").disabled=true;
					document.getElementById("sup_qry").disabled=true;
					document.getElementById("par_complete").disabled=true;
					document.getElementById("complete").disabled=true;
				//	document.getElementById("sup_cl_complete").disabled=true;//41064
					
				}
		else if(up_status == 'PC'){
					document.getElementById("par_complete").checked=true;
					document.coderButtons.status.value ="PC";
				}
		else if(up_status == 'CO'){
					document.getElementById("complete").checked=true;
					document.coderButtons.status.value ="CO";
					document.getElementById("doct_qry").disabled=true;
					document.getElementById("sup_qry").disabled=true;
					document.getElementById("hold_qry").disabled=true;
					document.getElementById("par_complete").disabled=true;
					document.getElementById("complete").disabled=true;
					//41064 start
					if('<%=supervisorApplYN%>'=='Y')
						document.getElementById("btn_save").disabled=false;
					else
						document.getElementById("btn_save").disabled=true;
					//41064 end
    	}
         //41064 start
		else if(up_status == 'SC'){
			document.getElementById("sup_cl_complete").checked=true;
			document.coderButtons.status.value ="SC";
			document.getElementById("doct_qry").disabled=true;
			document.getElementById("sup_qry").disabled=true;
			document.getElementById("hold_qry").disabled=true;
			document.getElementById("par_complete").disabled=true;
			document.getElementById("complete").disabled=true;
			
}//41064  end
		else
					document.coderButtons.status.value ="NW";
				
<%
				}
%>

</script>
</html>
<%
putObjectInBean(bean_id,bean,request); 
%>

