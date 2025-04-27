<!DOCTYPE html>
<%
//"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" 
%>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,webbeans.eCommon.*,eCommon.Common.CommonBean,eOT.Common.*,eOT.*"  contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='SurgeryDetailsForm' id='SurgeryDetailsForm'>
<% 	
	//String allSpecialities_query_value="";	
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String check_in_time = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("check_in_time"),"DMYHM","en",locale));
	String check_in_or_time = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("check_in_or_time"),"DMYHM","en",locale));
	//String check_in_or_time = CommonBean.checkForNull(request.getParameter("check_in_or_time"));
	String check_in_rec_time = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("check_in_rec_time"),"DMYHM","en",locale));
	String check_out_rec_time = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("check_out_rec_time"),"DMYHM","en",locale));	
	/*String strRecoveryEndDateTime = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("end_time_rec"),"DMYHM","en",locale));  
	System.out.println("strRecoveryEndDateTime --> Testing "+strRecoveryEndDateTime); 
	String strRecoveryEndDateTime =""; 
	System.out.println("strRecoveryEndDateTime --> Testing "+strRecoveryEndDateTime);  */

	//Added by lakshmi against IN29152 starts here
	String check_out_or_time = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("check_out_or_time"),"DMYHM","en",locale));
	String recovery_room_desc = CommonBean.checkForNull(request.getParameter("recovery_room_desc"));
	//Added by lakshmi against IN29152 ends here

	String OR_FLAG="OFF";
	if(!check_in_or_time.equals("")) OR_FLAG="ON";
	String RECOVERY_FLAG="OFF";
	if(!check_in_rec_time.equals("")) RECOVERY_FLAG="ON";
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//CASE CALLED QUERY
	String CASE_CALLED="SELECT TO_CHAR(CASE_CALLED_TIME,'DD/MM/YYYY HH24:MI') FROM OT_QUEUE WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
	//HOLDING AREA QRY
		//String HOLD_AREA="SELECT B.HOLDING_AREA_DESC,TO_CHAR(A.CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM  OT_OPER_HOLDING_DTLS A,OT_HOLDING_AREAS B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.HOLDING_AREA_CODE=B.HOLDING_AREA_CODE AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID ORDER BY 2";

		String HOLD_AREA="SELECT B.HOLDING_AREA_DESC,TO_CHAR(A.CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM  OT_OPER_HOLDING_DTLS A,OT_HOLDING_AREAS_LANG_VW B WHERE B.LANGUAGE_ID ='"+locale+"' AND A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.HOLDING_AREA_CODE=B.HOLDING_AREA_CODE AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID ORDER BY 2";
	//Modified by DhanasekarV on 22/11/2010  against issue IN025160
	//OPERATION TIMINGS QRY
	String OPER_TIMIMGS ="SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE, '*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,NVL(TO_CHAR(A.PREPARATION_TIME,'HH24:MI'),' ') PREP_TIME,TO_CHAR(A.ANEST_PROC_START_TIME,'DD/MM/YYYY HH24:MI') PROC_START_TIME,TO_CHAR(A.ANEST_PROC_END_TIME,'DD/MM/YYYY HH24:MI') PROC_END_TIME,TO_CHAR(A.ANEST_START_TIME,'DD/MM/YYYY HH24:MI') ANST_START_TIME,TO_CHAR(A.ANEST_END_TIME,'DD/MM/YYYY HH24:MI') ANST_END_TIME,TO_CHAR(A.SURG_START_TIME,'DD/MM/YYYY HH24:MI') SUG_START_TIME,TO_CHAR(A.SURG_END_TIME,'DD/MM/YYYY HH24:MI') SUG_END_TIME FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.SPECIALITY_CODE = B.SPECIALITY_CODE(+)";
	
	//TRANSFER BACK TO OT FROM RECOVERY ROOM QRY
	//String TRANSFER_BACK = "SELECT A.OPER_ROOM_CODE, A.TRFR_REASON, A.OPER_STATUS,B.SHORT_DESC THEATRE_DESC, C.REASON_DESC, D.STATUS_DESC FROM OT_POST_OPER_HDR A, OT_OPER_ROOM B, OT_REASONS C, OT_STATUS D WHERE A.OPERATING_FACILITY_ID = ? AND A.SOURCE_OPER_NUM = ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.OPER_ROOM_CODE = B.OPER_ROOM_CODE AND A.TRFR_REASON = C.REASON_CODE AND A.OPER_STATUS = D.STATUS_CODE";

	// String TRANSFER_BACK = "SELECT A.OPER_ROOM_CODE, A.TRFR_REASON, A.OPER_STATUS,B.SHORT_DESC THEATRE_DESC, C.REASON_DESC, D.STATUS_DESC FROM OT_POST_OPER_HDR A, OT_OPER_ROOM_LANG_VW B, OT_REASONS_LANG_VW C, OT_STATUS D WHERE B.LANGUAGE_ID='"+locale+"' AND C.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID = ? AND A.SOURCE_OPER_NUM = ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.OPER_ROOM_CODE = B.OPER_ROOM_CODE AND A.TRFR_REASON = C.REASON_CODE AND A.OPER_STATUS = D.STATUS_CODE";

	String TRANSFER_BACK = "SELECT A.OPER_ROOM_CODE, A.TRFR_REASON, A.OPER_STATUS,B.SHORT_DESC THEATRE_DESC, C.REASON_DESC, D.STATUS_DESC, A.TRFR_REMARKS FROM OT_POST_OPER_HDR A, OT_OPER_ROOM_LANG_VW B, OT_REASONS_LANG_VW C, OT_STATUS_LANG_VW D WHERE B.LANGUAGE_ID='"+locale+"' AND C.LANGUAGE_ID='"+locale+"' AND D.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID = ? AND A.SOURCE_OPER_NUM = ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.OPER_ROOM_CODE = B.OPER_ROOM_CODE AND A.TRFR_REASON = C.REASON_CODE AND A.OPER_STATUS = D.STATUS_CODE";
		
	String transfer_area="";
	String operation_status="";
	String reason="";
	String remarks="";
	String TRANSFER_FLAG="OFF";
	HashMap map = new HashMap();
	HashMap oper_map = new HashMap();

	String case_called="";
		
	int index=0;
	int row=0;

	try{
		con = ConnectionManager.getConnection(request);

		//CASE CALLED TIME
		pstmt = con.prepareStatement(CASE_CALLED);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			case_called=com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString(1)),"DMYHM","en",locale);
		}
		
		//HOLDING AREA 
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(HOLD_AREA);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			++index;
			HashMap hash = new HashMap();
			hash.put("hold_bay",CommonBean.checkForNull(rst.getString(1)));
			hash.put("hold_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString(2)),"DMYHM","en",locale));
			map.put(""+index,hash);
			hash=null;
		}

		//OPERATION TIMING DETAILS
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(OPER_TIMIMGS);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			++row;
			HashMap hash = new HashMap();
			hash.put("speciality_desc",CommonBean.checkForNull(rst.getString("SPL_DESC")));
		
		//Commented by DhanasekarV on 22/11/2010 against issue IN025160	 /*hash.put("prep_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString("PREP_TIME")),"DMYHM","en",locale));*/
		hash.put("prep_time",rst.getString("PREP_TIME"));

	hash.put("proc_start_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString("PROC_START_TIME")),"DMYHM","en",locale));
			hash.put("proc_end_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString("PROC_END_TIME")),"DMYHM","en",locale));
			hash.put("anst_start_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString("ANST_START_TIME")),"DMYHM","en",locale));
			hash.put("anst_end_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString("ANST_END_TIME")),"DMYHM","en",locale));
			hash.put("sug_start_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString("SUG_START_TIME")),"DMYHM","en",locale));
			hash.put("sug_end_time",com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst.getString("SUG_END_TIME")),"DMYHM","en",locale));
	

//Commented by DhanasekarV on 22/11/2010 aginast issue IN025160
/*		hash.put("proc_start_time",CommonBean.checkForNull(rst.getString("PROC_START_TIME")));
			hash.put("proc_end_time",CommonBean.checkForNull(rst.getString("PROC_END_TIME")));
			hash.put("anst_start_time",CommonBean.checkForNull(rst.getString("ANST_START_TIME")));
			hash.put("anst_end_time",CommonBean.checkForNull(rst.getString("ANST_END_TIME")));
			hash.put("sug_start_time",CommonBean.checkForNull(rst.getString("SUG_START_TIME")));
			hash.put("sug_end_time",CommonBean.checkForNull(rst.getString("SUG_END_TIME")));*/
			oper_map.put(""+row,hash);
			hash=null;
		}
		
		//TRANSFER BACK TO OPERATION ROOM 
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(TRANSFER_BACK);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			transfer_area=CommonBean.checkForNull(rst.getString(4));
			reason=CommonBean.checkForNull(rst.getString(5));
			operation_status = CommonBean.checkForNull(rst.getString(6));
			remarks = CommonBean.checkForNull(rst.getString(7));
			if(!reason.equals(""))
			TRANSFER_FLAG="ON";
		}
	}catch(Exception e){
		 System.err.println("Err Msg in SurgeryDetails.jsp "+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
<!--<tr>
	<td class="CAGROUPHEADING" colspan="4">Check In Details </td>
</tr>-->
<tr>
	<td class='label'width="25%"><fmt:message key="eOT.CaseCalledTime.Label" bundle="${ot_labels}"/> </td>
	<td class='fields' width="25%"><b> <%=case_called%></b> </td>

	<td class='label' width="25%"><fmt:message key="eOT.CheckInTime.Label" bundle="${ot_labels}"/> </td>
	<td class='fields' width="25%"><b><%=check_in_time%></b> </td>
</tr>
<tr>
	<td colspan="4"></td>
</tr>

<% if(map.size()>0){%>
	<table border='1' cellpadding='3' cellspacing='0' width='100%' align="center">
	<tr>
		<td class="CAGROUPHEADING" colspan="4"><fmt:message key="eOT.HoldingAreaDetails.Label" bundle="${ot_labels}"/> </td>
	</tr>
	<th><fmt:message key="eOT.HoldingBay.Label" bundle="${ot_labels}"/> </td>
	<th><fmt:message key="eOT.CheckInTime.Label" bundle="${ot_labels}"/> </td>
<% 
	int size = map.size();
	String hold_bay ="";
	String hold_time="";
	String qryVal="";
	HashMap hold_map=null;
	for(int i=size;i>0;i--){
		hold_map = (HashMap) map.get(""+i);
		hold_bay= (String) hold_map.get("hold_bay");
		hold_time= (String) hold_map.get("hold_time");
		qryVal=i%2==0?"QRYODD":"QRYEVEN";
%>
  <tr>
	<td class='<%=qryVal%>'  ><b><%=hold_bay%></b></td>
	<td class='<%=qryVal%>'  ><b><%=hold_time%></b></td>
  </tr>
   <% }// end for Loop %>
</table>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
<td colspan="4"></td>
</table>
<% } // end of if %>
<% if( OR_FLAG.equals("ON") ){%>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
	<tr>
		<td class="CAGROUPHEADING" colspan="8"><fmt:message key="eOT.OperationTimings.Label" bundle="${ot_labels}"/></td>
	</tr>
	<tr>
		<!--<td colspan="2"> </td>-->
		<td class='label' width="25%" ><fmt:message key="eOT.CheckIntoORTime.Label" bundle="${ot_labels}"/> </td>
		<td class='fields' width="25%" ><b> <%=check_in_or_time%></b> </td>

		<!--Added by lakshmi agaisnt IN29152 starts here-->
		<td class='label' width="25%" ><fmt:message key="eOT.CheckOutFromORDateTime.Label" bundle="${ot_labels}"/> </td>
		<td class='fields' width="25%" ><b> <%=check_out_or_time%></b> </td>
		<!--Added by lakshmi agaisnt IN29152 starts here-->
		<!--<td colspan="3"> </td>-->
	</tr>
	<tr>
	<td colspan="4"></td>
	</tr>
	</table>
	
<%if(oper_map.size()>0){ %>
	<table border='1' cellpadding='3' cellspacing='0' width='100%' align="center">
	<th class='columnHeaderCenter'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>                      
	<th class='columnHeaderCenter'>Prepartion Time(in mins)</th>			
	<th class='columnHeaderCenter'><fmt:message key="eOT.AnaesthesiaProcedureStartTime.Label" bundle="${ot_labels}"/></th>
	<th class='columnHeaderCenter'><fmt:message key="eOT.AnaesthesiaProcedureEndTime.Label" bundle="${ot_labels}"/></th>  
	<th class='columnHeaderCenter'><fmt:message key="eOT.AnaesthesiaStartTime.Label" bundle="${ot_labels}"/></th>          
	<th class='columnHeaderCenter'><fmt:message key="eOT.AnaesthesiaEndTime.Label" bundle="${ot_labels}"/></th>            
	<th class='columnHeaderCenter'><fmt:message key="eOT.ProcedureStartTime.Label" bundle="${ot_labels}"/></th>            
	<th class='columnHeaderCenter'><fmt:message key="eOT.ProcedureEndTime.Label" bundle="${ot_labels}"/></th>
<% 
	int len = oper_map.size();
	String qryVal="";
	HashMap temp_map = new HashMap();
	for(int i=len;i>0;i--){
		temp_map = (HashMap) oper_map.get(""+i);
		qryVal=i%2==0?"QRYODD":"QRYEVEN";

%>
	<tr>
	<td class='<%=qryVal%>'><%=(String)temp_map.get("speciality_desc")%></td>
	<td class='<%=qryVal%>'><%=(String) temp_map.get("prep_time")%></td>
	<td class='<%=qryVal%>'><%=(String) temp_map.get("proc_start_time")%></td>
	<td class='<%=qryVal%>'><%=(String) temp_map.get("proc_end_time")%></td>
	<td class='<%=qryVal%>'><%=(String) temp_map.get("anst_start_time")%></td>
	<td class='<%=qryVal%>'><%=(String) temp_map.get("anst_end_time")%></td>
	<td class='<%=qryVal%>'><%=(String)temp_map.get("sug_start_time")%></td>
	<td class='<%=qryVal%>'><%=(String) temp_map.get("sug_end_time")%></td>
	</tr>
<%}//for loop ends
} // if ends here %>		
	</table>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
		<td colspan="4"></td>
	</table>
<% } //if OR_FLAG END %>
<%if (RECOVERY_FLAG.equals("ON")){ %>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
	<tr>
		<td class="CAGROUPHEADING" colspan="2"><fmt:message key="eOT.RecoveryDetails.Label" bundle="${ot_labels}"/></td>
	</tr>
	<!--Added by lakshmi agaisnt IN29152 starts here-->
	<tr>
		<td class='label' width="25%" ><fmt:message key="eOT.RecoveryRoom.Label" bundle="${ot_labels}"/> </td>
		<td class='fields' width="25%" ><b> <%=recovery_room_desc%></b> </td>
	</tr>
	<!--Added by lakshmi agaisnt IN29152 starts here-->

	<tr>
		<td class='label' width="25%" ><fmt:message key="eOT.CheckIntoRecoveryTime.Label" bundle="${ot_labels}"/> </td>
		<td class='fields' width="25%" ><b> <%=check_in_rec_time%></b> </td>
	</tr>
	<tr>
		<td class='label' width="25%" ><fmt:message key="eOT.RecoveryEndTime.Label" bundle="${ot_labels}"/> </td> <!-- Modified By Muthukumar against lN:029152 on 12-10-11 -->
		<td class='fields' width="25%" ><b> <%=check_out_rec_time%></b> </td>
	</tr>
	<tr>
		<td colspan="2"></td>
	</tr>
</table>
<%} // RECOVERY_FLAG endS %>

<%if (TRANSFER_FLAG.equals("ON")){ %>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
	<tr>
		<td class="CAGROUPHEADING" colspan="2"><fmt:message key="eOT.TransferDetails.Label" bundle="${ot_labels}"/></td>
	</tr>
	<tr>
		<td class='label' width="25%" ><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/> </td>
		<td class='fields' width="25%" ><b> <%=transfer_area%></b> </td>
	</tr>
	<tr>
		<td class='label' width="25%" ><fmt:message key="Common.reason.label" bundle="${common_labels}"/> </td>
		<td class='fields' width="25%" ><b> <%=reason%></b> </td>
	</tr>
	<tr>
		<td class='label' width="25%" ><fmt:message key="eOT.OperationStatus.Label" bundle="${ot_labels}"/> </td>
		<td class='fields' width="25%" ><b> <%=operation_status%></b> </td>
	</tr>
	<tr>
		<td class='label' align='right' nowrap>Remarks &nbsp;</td>
		<td class='label' align='left' ><b> <%=remarks%></b> </td>
	</tr>
	<tr>
		<td colspan="2"></td>
	</tr>
</table>
<%} // TRANSFER_FLAG endS %>


</table>	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

