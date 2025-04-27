<!DOCTYPE html>
<!--

    Developed by    :   R.Nanda Kumar 
    Created on  :   18/01/2001
    Module      :   Out Patient Management
    Function    :   Consultation - Patient Arrival. This file is called from the 
                CallPatArrival which is called from the SingleManagePatientQueryResult 
                page.
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>

<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale=(String)session.getAttribute("LOCALE");
	
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
		String workStationId	= (String) p.getProperty("client_ip_address") == null ? "" : (String) p.getProperty("client_ip_address");
		String login_user			= (String) session.getValue("login_user");
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Ends-->
	
	String p_encounter_id   = request.getParameter("Encounter_Id");
    String p_queue_status   = request.getParameter("Queue_Status");
	/*Below line added for this CRF Bru-HIMS-CRF-133*/
	String curr_locntype = request.getParameter("curr_locntype")==null?"":request.getParameter("curr_locntype");
	String curr_locncode = request.getParameter("curr_locncode")==null?"":request.getParameter("curr_locncode");
	String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
    String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");	
	//End this CRF Bru-HIMS-CRF-133
	
	String revert_to_check_in = request.getParameter("revert_to_check_in");
	if(revert_to_check_in == null) revert_to_check_in="N";

	String PreviousDay = request.getParameter("PreviousDay");
	
	if(PreviousDay.equals("0") || PreviousDay.equals("0"))  PreviousDay = "+0";
	
	String p_patient_id=request.getParameter("patient_id");
	String p_clinic_code=request.getParameter("locn_code");
	String p_locn_type=request.getParameter("locn_type");
	String p_pract_id=request.getParameter("pract_id");
	String roomAlloted=request.getParameter("room_num");
	String appt_id=request.getParameter("appt_id");
    String p_status=request.getParameter("p_status");
	String dt=request.getParameter("dt");
	String queue_date=request.getParameter("p_queue_date");
	String arrival_date=request.getParameter("arrival_date");
	String cur_short_desc=request.getParameter("curr_locn");
	cur_short_desc=java.net.URLDecoder.decode(cur_short_desc,"UTF-8"); 
	
	if(cur_short_desc == null) cur_short_desc="";
	String cur_care_locn_type=request.getParameter("curr_locn_type_desc");
	if(cur_care_locn_type == null) cur_care_locn_type="";
	String VISIT_ADM_TYPE_IND=request.getParameter("VISIT_ADM_TYPE_IND");
	String appt_case_yn=request.getParameter("appt_case_yn");

	String other_res_class=request.getParameter("other_res_class");
	if(other_res_class == null) other_res_class="";
	String other_res_code=request.getParameter("other_res_code");
	if(other_res_code == null) other_res_code="";
	String queue_num=request.getParameter("queue_num");
	if(queue_num == null) queue_num="0";
	String appt_walk_ind=request.getParameter("appt_walk_ind");
	if(appt_walk_ind == null) appt_walk_ind="";
	String queue_id=request.getParameter("queue_id");
	if(queue_id == null) queue_id=""; 

	String assign_q_num_by = request.getParameter("assign_q_num_by")==null?"":request.getParameter("assign_q_num_by");
	
	String dt_display=DateUtils.convertDate(dt,"DMYHM","en",locale);
	String arr_dt_display=DateUtils.convertDate(arrival_date,"DMYHM","en",locale);
    String qms_interfaced_yn="N";   
%>

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
	<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
	<script  language='javascript' src="../../eXH/js/ExternalApplication.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script> <!-- //added by Himanshu Saxena asked by Interface team against ML-BRU-CRF-0628.10 on 22-05-2023 End-->
	<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 End-->
	
	<script language='javascript' src="../../eOP/js/ConsPatArrival.js"></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function allowNumOnly(event)
		{
			var strCheck = '0123456789';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1)
				return false;  
			else
				return true ;			
		}
		function chkValue(obj)
		{
			if(obj.value!="")
			{
				if(obj.value<1)
				{
					alert(getMessage("INVALID_POSITIVE_NUMBER","COMMON"));
					obj.select();
				}
			}
		}
	</script>

</head>
<!--  //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started   onload=QueueNumberLoad() function Added -->
<body   onKeyDown = 'lockKey();' onKeypress='return(applyclick(event));'>
<!--  //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Ends-->
<%
   // PreparedStatement pstmt       = null;
   // ResultSet rs        	  = null;
    
    PreparedStatement pstmt4	  = null;
    ResultSet rs4		  = null;
  
    String fac_id       = (String) session.getValue( "facility_id" ) ;
   	String roomno="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	Connection conn = null;
    //int total_rec=0;
	String ronly="";
	String selval="";
	String oth_res_desc="";
	
	String  selval1="disabled";
	String  ronly1="readOnly";
	String mand_queue_no="N";//Added by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121
	
	String Queue_No_Mandate="N";//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
	Boolean isMandQueueNoAppl;
	 boolean isQMSapplicable=false;
	
	try{

	conn=ConnectionManager.getConnection(request);
    isMandQueueNoAppl = CommonBean.isSiteSpecific(conn,"OP","MANDATORY_QUEUE_NO");//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
     isQMSapplicable=CommonBean.isSiteSpecific(conn,"OP","EXT_QUEUE_NO"); //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 Started-->

    		
    try{

		/*
		pstmt4=conn.prepareStatement("select ASSIGN_QUEUE_NUM_BY from op_param where OPERATING_FACILITY_ID = '"+fac_id+"' ");

		rs4 = pstmt4.executeQuery();

		if(rs4!=null && rs4.next())
		{
			assign_q_num_by = rs4.getString("ASSIGN_QUEUE_NUM_BY");
		}

		 if(rs4 != null) rs4.close();
		 if(pstmt4 != null) pstmt4.close();
		 */
		 
		pstmt4=conn.prepareStatement("select QUEUE_NO_MNDT_YN from op_param where OPERATING_FACILITY_ID = '"+fac_id+"' ");
		rs4 = pstmt4.executeQuery();
		if(rs4!=null && rs4.next())
		{
			mand_queue_no = rs4.getString("QUEUE_NO_MNDT_YN");
		}
		 if(rs4 != null) rs4.close();
		 if(pstmt4 != null) pstmt4.close();
		  if((isMandQueueNoAppl) && (mand_queue_no.equals("Y"))){
			 mand_queue_no="Y";
		 }else{ 
		  mand_queue_no="N";
		 }
			
		  //<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 Started-->	
		  if(isQMSapplicable){
		  Queue_No_Mandate="N";
		  String MandateField="";
		  pstmt4=conn.prepareStatement("select Queue_No_Mandate from op_clinic where FACILITY_ID = '"+fac_id+"' and CLINIC_CODE='"+p_clinic_code+"' and CLINIC_TYPE='C' ");
			rs4 = pstmt4.executeQuery();
			if(rs4!=null && rs4.next())
			{
				Queue_No_Mandate = rs4.getString("Queue_No_Mandate");
			}
			
			if(isQMSapplicable && Queue_No_Mandate.equals("Y")){
				 mand_queue_no="N";
			}
			else {
			 mand_queue_no="Y";	
			}
			 if(rs4 != null) rs4.close();
			 if(pstmt4 != null) pstmt4.close();
			//<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 End-->
		  }
		  
	qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(p_clinic_code,fac_id,conn);
	
	out.println("<form name='ConsPatArrivalForm' id='ConsPatArrivalForm' method='post' action='../../servlet/eOP.ConsPatArrivalServlet'>"); 

	out.println("<table width='95%' align='center' border='0'");
	out.println("<tr><td class='BORDER' align='center'>");
	out.println("<table cellpadding='6' cellspacing='0' BORDER='0'>");
	out.println("<tr><td class='label'  width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CurrentStatus.label","op_labels")+"</td>");    
	
    
	if (dt==null)
    {
        out.println("<td class='QUERYDATA' width='30%' nowrap>"+p_status+"</td>");
    }
    else
    {
        out.println("<td class='QUERYDATA' width='30%' nowrap>"+p_status+" / " +dt_display+ "</td>");
    } 
	out.println("<td class='label' colspan='2'></td></tr>");
    
	
	out.println("<tr><td  class='label'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;&nbsp;</td>");
    
    String cur_loc_desc = "&nbsp;" ;
   	cur_loc_desc = cur_short_desc +"/" + cur_care_locn_type  ;
    out.println("<td class='QUERYDATA'>"+cur_loc_desc+"</td><td class='label' colspan='2'></td></tr>"); 
	
	/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	out.println("<td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+"</td>");
	/*CRF end SS-CRF-0010 [IN034516]*/
    
    if(revert_to_check_in .equals("Y"))
    {
		selval="disabled";
		ronly="readOnly";
    	out.println("<td class='FIELDS' ><select name='roomnumsel' id='roomnumsel' disabled><option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;</option>");
    }
    else
    {
		selval="";
		ronly="";
    	out.println("<td class='FIELDS'><select name='roomnumsel' id='roomnumsel' onChange='selectroomno()'><option value=''>&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;</option>");
    }
        
	/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	 pstmt4=conn.prepareStatement("select a.practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id,'"+locale+"', 2) room_desc from op_pract_for_clinic a where facility_id='"+fac_id+"' and clinic_code='"+p_clinic_code+"' and eff_status='E' and resource_class='R' order by practitioner_id");
	 /*CRF end SS-CRF-0010 [IN034516]*/
	 
     rs4=pstmt4.executeQuery();
     String room_no="";
	 roomno=roomAlloted;
     
			
	   boolean flagval=false;
	   while(rs4.next())
       {flagval=true;
		 room_no=rs4.getString("room_no");
		 /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
		 room_desc=rs4.getString("room_desc");
		 /*CRF end SS-CRF-0010 [IN034516]*/
		 if(room_no.equals(roomAlloted))
		{
		/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			out.println("<option value='"+room_no+"'selected>"+room_no+" "+room_desc+"</option>");
			/*CRF end SS-CRF-0010 [IN034516]*/
		}
	 else
		{   /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			out.println("<option value='"+room_no+"'>"+room_no+" "+room_desc+"</option>");
			/*CRF end SS-CRF-0010 [IN034516]*/
		}
	   }
	
		if(flagval==true)	
		{
		out.println("</select>&nbsp;<img id='roomno_vis' src='../../eCommon/images/mandatory.gif' ></td>"); //Modified by Suji Keerthi for SKR-SCF-1504
		}
		else
		{
			 out.println("</select></td>");
			 roomno="NoRoom";
		}
      
	 if(rs4 != null) rs4.close();
	 if(pstmt4 != null) pstmt4.close();	
	
	if(!(other_res_code.equals("")))
	{	
		pstmt4 = conn.prepareStatement("SELECT DECODE(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2'),	               'R', AM_GET_DESC.AM_FACILITY_ROOM(facility_id, practitioner_id,'"+locale+"','2'), 'E', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2'),  'O', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2')) description FROM op_pract_for_clinic WHERE facility_id='"+fac_id+"' AND resource_class='"+other_res_class+"' AND clinic_code='"+p_clinic_code+"' AND practitioner_id='"+other_res_code+"'  AND eff_status='E'");	
		rs4 = pstmt4.executeQuery();
		if(rs4 != null)
		{
			if(rs4.next())
			{
				oth_res_desc=rs4.getString(1);
			}
		}
		if(rs4 != null) rs4.close();
		if(pstmt4 != null) pstmt4.close();
		if(oth_res_desc == null) oth_res_desc="";
	}%>
	
	
	<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 Started-->
	
	
	
	
	<!--Modified by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121-->
	<td  id='queue_div' style='visibility:hidden;display:none' class='label' width='20%'><fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/></td>
	<td id='queue_no_div' style='visibility:hidden;display:none' class='fields' width='25%'><input type='text' name='queue_no' id='queue_no' value = '' size='15' onKeyPress='return Check_SpecCharsValidationOP(event);' onPaste='return checkspecialandalphanumericOP(event);'  onblur = 'chkValue(this);' maxlength='15' >
	
	<!--<td id='queue_no_div' style='visibility:hidden;display:none' class='fields' width='25%'><input type='text' name='queue_no' id='queue_no' value = '' size='10' onKeyPress='return allowNumOnly(event);' onblur = 'chkValue(this);' maxlength='8' >-->
	<%if(("N").equals(mand_queue_no)){%><img id="mand_gif" src='../../eCommon/images/mandatory.gif'><%}%></td>
	</tr>
	<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 End-->
	
	
	<!--if condition modified by Himanshu Saxena for ML-BRU-CRF-0628.11 on 30-05-2023 Started
	//if(assign_q_num_by.equals("M") && qms_interfaced_yn.equals("N") -->
	<%
	if(assign_q_num_by.equals("M") && qms_interfaced_yn.equals("N"))
	{
		String q_value = "";
		String q_disable = "";

		if(revert_to_check_in .equals("Y"))
		{
			q_value = queue_num;
			q_disable = "true";
		}
		else
		{
			q_value = "";
			q_disable = "false";
		}		%>
			<script>	
		document.getElementById("queue_div").style.display="";
		document.getElementById("queue_no_div").style.display="";
		document.getElementById("queue_div").style.visibility="visible";
		document.getElementById("queue_no_div").style.visibility="visible";
		document.forms[0].queue_no.disabled=<%=q_disable%>;		
		document.forms[0].queue_no.value='<%=q_value%>';	
		</script><%
	}
	else if(assign_q_num_by.equals("S")) 
	{
		out.println("<td class='label' colspan='2'></td></tr>");
	}
   
	out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.otherrestype.label","op_labels")+"&nbsp;&nbsp;</td>");
	out.println("<td class='fields'><select name='other_res_type' id='other_res_type' onChange='clearResourceVal(this);' "+selval+" ><option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;</option>");
	if(other_res_class.equals("E"))
	{
	 out.println("<option value='"+other_res_class+"' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+" </option><option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");
	}else if(other_res_class.equals("O"))
	{
	 out.println("<option value='"+other_res_class+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+" </option><option value='O' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");
	}else
	{
 	 out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+" </option><option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");
	}
 out.println("</select></td><td class=label width='20%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.OtherResource.label","op_labels")+"</td><td class='fields' width='25%'>	<input type='text' name='other_res_txt' id='other_res_txt' maxlength='15' size='16' value='"+oth_res_desc+"'  "+ronly1+" ><input type='button' class='button' name='other_res_butt' id='other_res_butt' value='?'  onClick='otherResourceLookUp(this,other_res_txt);' "+selval1+">	</td></tr>"); 

	out.println("<input type='hidden' name='other_res_code' id='other_res_code' value='"+other_res_code+"'>");


	}catch(Exception e) { 
		e.printStackTrace();
		}


    out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ArrivalDateTime.label","common_labels")+"&nbsp;&nbsp;</td>");
    out.println("<td class='QUERYDATA'>"+arr_dt_display+"</td><td class='label' colspan='2'></td></tr>");
	

	%>

    <tr><td colspan='4' class='button' align="right"><input type='button'  class='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="submit_ok()"><input type='button' align='left' class='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='exitContact()'>
     </td>
      </tr>
<%


//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 30-05-2023 Started-->
String alert_duration="6000";
pstmt4=conn.prepareStatement("SELECT COMM_PROCESS_IDLE_TIME FROM XH_INTERACTIVE_CONNECT_PARAM WHERE PLUGIN_TYPE = 'BQS'");
rs4 = pstmt4.executeQuery();
if(rs4!=null && rs4.next())
    {
        alert_duration = rs4.getString("COMM_PROCESS_IDLE_TIME");
        alert_duration=alert_duration+"000";

    }

//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 30-05-2023 Ends-->
	out.println("</table></td></tr></table>");	   
    
	out.print("<input type='hidden' name='revert_to_check_in' id='revert_to_check_in' value='"+revert_to_check_in+"'>");
	out.print("<input type='hidden' name='queuestatus' id='queuestatus' value='"+p_queue_status+"'>");
    out.print("<input type='hidden' name='patientid' id='patientid' value='"+p_patient_id+"'>");
    out.print("<input type='hidden' name='locntype' id='locntype' value='"+p_locn_type+"'>");
    out.print("<input type='hidden' name='clinic_code' id='clinic_code' value='"+p_clinic_code+"'>");
    out.print("<input type='hidden' name='practid' id='practid' value='"+p_pract_id+"'>");
    out.print("<input type='hidden' name='encntrid' id='encntrid' value='"+p_encounter_id+"'>");
    out.print("<input type='hidden' name='queue_date' id='queue_date' value='"+queue_date+"'>");
    
	 out.print("<input type='hidden' name='room_num' id='room_num' value='"+roomno+"'>");
	 out.println("<input type='hidden' name='prev_room' id='prev_room' value='"+roomno+"'>");
	 out.print("<input type='hidden' name='room_change' id='room_change' value=''>"); 	 
	 
	 out.print("<input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'>");
	 out.print("<input type='hidden' name='appt_case_yn' id='appt_case_yn' value='"+appt_case_yn+"'>");
	 out.print("<input type='hidden' name='VISIT_ADM_TYPE_IND' id='VISIT_ADM_TYPE_IND' value='"+VISIT_ADM_TYPE_IND+"'>");
	  out.print("<input type='hidden' name='res_code' id='res_code' value='"+other_res_code+"'>");
	  out.print("<input type='hidden' name='fac_id' id='fac_id' value='"+fac_id+"'>");
	 out.print("<input type='hidden' name='queue_num' id='queue_num' value='"+queue_num+"'>");
	 out.print("<input type='hidden' name='appt_walk_in' id='appt_walk_in' value='"+appt_walk_ind+"'>");
	 out.print("<input type='hidden' name='queue_id' id='queue_id' value='"+queue_id+"'>");
	 out.print("<input type='hidden' name='locale' id='locale' value='"+locale+"'>");
	 out.println("<input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value='"+assign_q_num_by+"'>");	 	
	 out.println("<input type='hidden' name='qms_interfaced_yn' id='qms_interfaced_yn' value='"+qms_interfaced_yn+"'>");	 	 	 
	 out.println("<input type='hidden' name='qms_exception' id='qms_exception' value='N'>");	
  
    out.println("<input type='hidden' name='curr_locntype' id='curr_locntype' value='"+curr_locntype+"'>");
    out.println("<input type='hidden' name='curr_locncode' id='curr_locncode' value='"+curr_locncode+"'>");
    out.println("<input type='hidden' name='isPatientEncMovement' id='isPatientEncMovement' value='"+isPatientEncMovement+"'>");	
	out.println("<input type='hidden' name='Sydate' id='Sydate' value='"+Sydate+"'>");	
	//Added by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121
	out.println("<input type='hidden' name='isMandQueueNoAppl' id='isMandQueueNoAppl' value='"+isMandQueueNoAppl+"'>");	
	out.println("<input type='hidden' name='mand_queue_no' id='mand_queue_no' value='"+mand_queue_no+"'>");
	
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
	out.println("<input type='hidden' name='isQMSapplicable' id='isQMSapplicable' value='"+isQMSapplicable+"'>");
	out.println("<input type='hidden' name='Queue_No_Mandate' id='Queue_No_Mandate' value='"+Queue_No_Mandate+"'>");
	out.println("<input type='hidden' name='alert_duration' id='alert_duration' value='"+alert_duration+"'>");
	out.println("<input type='hidden' name='work_station_id' id='work_station_id' value='"+workStationId+"'>");
	out.println("<input type='hidden' name='login_user' id='login_user' value='"+login_user+"'>");
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Ended-->
	
%>
	
 
<%
out.print("</form>");
%>

</body>
</html>
<%


}catch(Exception e) {
	e.printStackTrace();
	}
    finally{
    		if(conn!=null) ConnectionManager.returnConnection(conn,request);                
            }
%>

