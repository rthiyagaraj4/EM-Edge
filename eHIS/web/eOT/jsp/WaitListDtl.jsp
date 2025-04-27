<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.Common.OTRepository,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<html> 
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String cancelled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
String pending =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
String apptscheduled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApptScheduled.Label","ot_labels");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!-- 57404 -->
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>	
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
 <head>
 <script>
 
 var remarks_value=getLabel("eOT.PreOperativeDiagnosis.Label","OT");//Added by lakshmi against MO-CRF-20051
 function submitPrevNext(from, to)
 { 
	var frmObj=document.forms[0];//VerificationSearchForm
	var locale = frmObj.locale.value;
	var change_from_date = dateUtils(frmObj.from_date.value,locale); 
	var change_to_date = dateUtils(frmObj.to_date.value,locale); 
	if(!callDateCheck(change_from_date,change_to_date)) return;

	if(frmObj.from_date.value!=''){
	//Commented against MO-CRF-20086
	//var sql="SELECT (to_date(to_char(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')-to_date(to_char(WAITLIST_DATE,'dd/mm/yyyy'),'dd/mm/yyyy')) R_DAY1,NVL(C.WARN_LIMIT_WAITLIST_DAYS,0) WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,'N') STAT1,v.PATIENT_ID  PATIENT_ID1, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,'dd/mm/yyyy HH24:MI')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS,v.STATUS  FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and C.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and v.language_id='"+locale+"'";
	//Added against MO-CRF-20086
	var sql="SELECT * FROM (SELECT (to_date(to_char(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')-to_date(to_char(WAITLIST_DATE,'dd/mm/yyyy'),'dd/mm/yyyy')) R_DAY1,NVL(C.WARN_LIMIT_WAITLIST_DAYS,0) WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,'N') STAT1,v.PATIENT_ID  PATIENT_ID1, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,'dd/mm/yyyy HH24:MI')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS,v.STATUS,(SELECT ORDER_FIELD_VALUE from or_order_field_values D where D.ORDER_ID=V.ORDER_ID and D.ADDED_FACILITY_ID=V.OPERATING_FACILITY_ID and D.ORDER_FIELD_MNEMONIC = 'OT_CATEGORY_TYPE' AND ROWNUM=1)  CATEGORY,(SELECT ORDER_FIELD_VALUE from or_order_field_values D where D.ORDER_ID=V.ORDER_ID and D.ADDED_FACILITY_ID=V.OPERATING_FACILITY_ID and D.ORDER_FIELD_MNEMONIC = 'PRIORITY'  AND ROWNUM=1)  PRIORITY  FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and C.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and v.language_id='"+locale+"'";
	
	var where="";
	var where2="";//Added against MO-CRF-20086
   if(frmObj.speciality_code.value!=null && frmObj.speciality_code.value!='')
	where=escape(" and instr(NVL(ALL_SPECIALITY_CODES,SPECIALITY_CODE),'#"+frmObj.speciality_code.value+"#')>0");

   if(frmObj.surgeon_code.value!=null && frmObj.surgeon_code.value!='')
	where+=escape(" and v.SURGEON_CODE ='"+frmObj.surgeon_code.value+"'");

	if(frmObj.order_id.value!=null && frmObj.order_id.value!='')
	   where+=escape(" and v.ORDER_ID ='"+frmObj.order_id.value+"'");

	if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
     where +=" AND PREFERRED_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')";

	if(frmObj.patient_id.value!=null && frmObj.patient_id.value!='')
	   where+=escape(" and v.PATIENT_ID ='"+frmObj.patient_id.value+"'");
	else
		if(frmObj.patient_name.value!=null&&frmObj.patient_name.value!='')
		where+= escape(" and UPPER(v.PATIENT_NAME) like UPPER('"+frmObj.patient_name.value+"%')");

	if(frmObj.status_old.value=='S')
	 where+=escape(" and v.BOOKING_NUM IS NOT NULL");
	else
	if(frmObj.status_old.value=='U')
	 where+=escape(" and v.BOOKING_NUM IS  NULL");
	
	sql+=where+")";//modified against MO-CRF-20086
	
	//Added against MO-CRF-20086 Starts Here
	if((frmObj.category.value!=null && frmObj.category.value!='') && (frmObj.priority.value!=null && frmObj.priority.value!=''))
	 where2+=escape("where  ((NVL('"+frmObj.category.value+"',CATEGORY)=CATEGORY AND '"+frmObj.category.value+"' IS NOT NULL) OR ('"+frmObj.category.value+"' IS NULL)) AND ((NVL('"+frmObj.priority.value+"',PRIORITY)=PRIORITY AND '"+frmObj.priority.value+"' IS NOT NULL) OR ('"+frmObj.priority.value+"' IS NULL)) ");
	  
	else if(frmObj.category.value!=null && frmObj.category.value!='')
	   where2+=escape("where  ((NVL('"+frmObj.category.value+"',CATEGORY)=CATEGORY AND '"+frmObj.category.value+"' IS NOT NULL) OR ('"+frmObj.category.value+"' IS NULL))");
	   
	else 
	if(frmObj.priority.value!=null && frmObj.priority.value!='')
	   where2+=escape("where  ((NVL('"+frmObj.priority.value+"',PRIORITY)=PRIORITY AND '"+frmObj.priority.value+"' IS NOT NULL) OR ('"+frmObj.priority.value+"' IS NULL))");
    
	sql+=where2;	
	//Added against MO-CRF-20086 Ends Here
	var param='sql='+sql+'&surgeonCode='+frmObj.surgeon_code.value+"&from="+from+"&to="+to+"&speciality_code="+frmObj.speciality_code.value+"&surgeon_code="+frmObj.surgeon_code.value+"&order_id="+frmObj.order_id.value+"&patient_id="+frmObj.patient_id.value+"&patient_name="+frmObj.patient_name.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&status="+frmObj.status_old.value+"&category="+frmObj.category.value+"&priority="+frmObj.priority.value;//Modified against MO-CRF-20086
	parent.frames[0].location.href = '../../eOT/jsp/WaitListDtlFrame.jsp?'+param;	
	}else{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]);
	}
 }
 </script>
  </head>

<body >
<form name='pendingOrderDtlForm' id='pendingOrderDtlForm' action='' method = 'post' >


<%	

	String sql=request.getParameter("sql");
	String strPatientId="",strPatientName="",strSurgeoryType="",strSpecialityDesc="",strSurgeonName="",strSurgeonCode="",strOrderId="",strQuery="",strOperDesc="",strPrefDate="",strSpeciality="",strBookingNum="",strColor="",strColorStat="",strTextColor="",strMultipleOperYN="",strTempBookNo="",strWaitListNo="",strWaitlist="",strwarningdays="",waitListDays="",status="";
	String strCategory="",strPriority="";//Added against MO-CRF-20086
	String strPreOperDiag=""; //Added by lakshmi against MO-CRF-20051

	int colorDt=0;
	int colorDt1=0;
	int fetchCount=0;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt1=null;
	ResultSet rs1=null;
		String from = request.getParameter( "from"  );
		String to = request.getParameter( "to")  ;
		String from_date = request.getParameter( "from_date") ;
		String to_date = request.getParameter( "to_date" );
		String surgeon_code = CommonBean.checkForNull(request.getParameter( "surgeon_code" )) ;
		String order_id = CommonBean.checkForNull(request.getParameter( "order_id" )) ;
		String speciality_code = CommonBean.checkForNull(request.getParameter( "speciality_code" )) ;
		String patient_id = CommonBean.checkForNull(request.getParameter( "patient_id" )) ;
		String patient_name =CommonBean.checkForNull( request.getParameter( "patient_name" )) ;
		String facilityid=(String)session.getValue("facility_id");
		//Added against MO-CRF-20086
		String category=CommonBean.checkForNull( request.getParameter( "category" ));
		String priority=CommonBean.checkForNull( request.getParameter( "priority" ));
		//Added against MO-CRF-20086
		int start = 0 ;
		int end = 0 ;
		int s=0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 15 ;
	else
		end = Integer.parseInt( to ) ;

 	try{
		conn = ConnectionManager.getConnection(request);

		String sql_desc="SELECT SHORT_DESC OPER_DESC FROM OT_WAITLISTING_DTL A, OT_OPER_MAST B WHERE  A.WAITLIST_NUM = ? AND A.OPER_CODE = B.OPER_CODE ";
		pstmt1=conn.prepareStatement(sql_desc);
	
		pstmt=conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if ( start != 1 )
			for( int j=1; j<start; s++,j++ )
			{
				rs.next() ;
			}
			if(rs != null)
			{
				while(s<=end && rs.next() ){

					if(fetchCount==0)
					{
			%>
						<input type=hidden name='from' id='from' value='<%=start%>'>
						<input type=hidden name='to' id='to' value='<%=end%>'>					

						<table width='100%' border='0' align='center' >
							<tr>
								<td width='20%' align='right' class='NONURGENT'>
			<%
						if ( !(start <= 1)) {
			%>
							<a href='javascript:submitPrevNext(<%=(start-15)%>,<%=(end-15)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type=hidden name='whichPage' id='whichPage' value='prev'>
			<%
						}
						if ( !((start+15) > fetchCount ))
						{
			%>
								<a href='javascript:submitPrevNext(<%=(start+15)%>,<%=(end+15)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
			<%
						}
			%>
		
								</td>
	 						</tr>
						</table>
						
						<table class='grid' border='0' width='100%' cellpadding=3  cellspacing=0>
							<tr>
								<th class='columnHeader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
								<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
								<th class='columnHeader' nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></th>
								<th class='columnHeader' nowrap><fmt:message key="eOT.Procedure(s).Label" bundle="${ot_labels}"/></th>
								<th class='columnHeader' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>		
								<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
								<th class='columnHeader' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></th>	
							    	<!--  Added Starts Against MO-CRF-20086-->	
								<th class='columnHeader' nowrap><fmt:message key="eOT.CategoryType.Label" bundle="${ot_labels}"/></th>	
								<th class='columnHeader' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>	
								<!--  Added Ends Against MO-CRF-20086-->	
								<th class='columnHeader' nowrap><fmt:message key="eOT.WaitlistDate.Label" bundle="${ot_labels}"/></th>
								<th class='columnHeader' nowrap><fmt:message key="eOT.WaitlistDays.Label" bundle="${ot_labels}"/></th>
								<th class='columnHeader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
								<!--Added by lakshmi against MO-CRF-20051-->
								<th class='columnHeader' nowrap><fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></th>
							</tr>
			
			<%
						}

						strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
						strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
						strSurgeoryType=checkForNull(rs.getString("SURGERY_TYPE1"));
						strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
						strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));	
						strSurgeonCode=checkForNull(rs.getString("SURGEON_CODE1"));
						strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
						strMultipleOperYN=checkForNull(rs.getString("MULTIPLE_OPERS_YN1"));
						strOperDesc=checkForNull(rs.getString("OPER_DESC1"));
						strOrderId=checkForNull(rs.getString("ORDER_ID1"));
						strPrefDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREFERRED_DATE1"),"DMY","en",locale));
						strSpeciality=checkForNull(rs.getString("SPECIALITY_CODE1"));
						strBookingNum=checkForNull(rs.getString("BOOKING_NUM1"));
						strColorStat=checkForNull(rs.getString("STAT1"));
						strColor=checkForNull(rs.getString("R_DAY1"));
						strWaitlist=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("WAITLIST_DATE1"),"DMYHM","en",locale));
						strwarningdays=checkForNull(rs.getString("WARNING_DAYS"));
						waitListDays = checkForNull(rs.getString("R_DAY1"));
						status = checkForNull(rs.getString("STATUS"));
						strCategory=checkForNull(rs.getString("CATEGORY"));//Added against MO-CRF-20086
			            strPriority=checkForNull(rs.getString("PRIORITY"));//Added against MO-CRF-20086
			
						if(("9").equals(status))
							status=cancelled;
						else if(("P").equals(status))
							status=pending;
						else if(("A").equals(status))
							status=apptscheduled;
			
						colorDt=Integer.parseInt(strColor);
						colorDt1=Integer.parseInt(strwarningdays);
						strQuery=(fetchCount%2==0)?"gridData":"gridData";
						//strPreOperDiag = checkForNull(rs.getString("PRE_OPER_DIAG"));//Added by lakshmi against MO-CRF-20051
						//System.out.println("strPreOperDiag:::lakshmi"+strPreOperDiag);//lakshmi
			%>
			
						<tr>
							<input type='hidden' name='xx<%=fetchCount%>' id='xx<%=fetchCount%>' value='<%=strSurgeonName%>'>
							<input type='hidden' name='speciality_code_<%=fetchCount%>' id='speciality_code_<%=fetchCount%>' value='<%=strSpeciality%>'>
							<input type='hidden' name='yy<%=fetchCount%>' id='yy<%=fetchCount%>' value='<%=strSpecialityDesc%>'>
			<%
						strTextColor="BLACK";
						if(colorDt>=colorDt1)
						{  
							if(strColorStat.equals("Y") && strBookingNum.length()==0)
							{
								strTextColor="RED";
							}else if(strColorStat.equals("N")){
								strTextColor="RED";
							}
						}
		
						if(strBookingNum.length()>0){
			%>
							<td width='' nowrap id='orderctl<%=fetchCount%>' style='cursor:pointer' class='gridDataBlue' onClick="displayToolTip3('<%=strOrderId%>','<%=strSurgeonCode%>','<%=strPrefDate%>','<%=fetchCount%>','<%=strPatientId%>','<%=strWaitListNo%>',this,'imgArrow<%=fetchCount%>');"  width='10%'  onMouseOver='hidemenu();' nowrap><%=strPatientId%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=fetchCount%>'></td>
			<%
						}
						else
						{
			%>
							<td width='' nowrap id='orderctl<%=fetchCount%>' style='cursor:pointer' class='gridDataBlue' onClick=" displayToolTip2('<%=strOrderId%>','<%=strSurgeonCode%>','<%=strPrefDate%>','<%=fetchCount%>','<%=strPatientId%>','<%=strWaitListNo%>',this,'imgArrow<%=fetchCount%>');"  width='10%'  onMouseOver='hidemenu();' nowrap><%=strPatientId%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=fetchCount%>'></td>
			<%
						}

			%>
							<td class='<%=strQuery%>' nowrap><%=strPatientName%>&nbsp;</td>
							<td class='<%=strQuery%>' nowrap><%=strSurgeoryType%></td>
			<%
						if(strMultipleOperYN.equals("Y"))
						{
							String operationsProcedures_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")+",";
							pstmt1.setString(1,strWaitListNo);
							rs1=pstmt1.executeQuery();
							strTempBookNo=operationsProcedures_value;
							while(rs1.next()){
								strTempBookNo=strTempBookNo+rs1.getString(1)+",";
							}		
							rs1.close();
			%>
							<input type='hidden' name='reason<%=fetchCount%>' id='reason<%=fetchCount%>' value='<%=strTempBookNo%>' >
							<td class='<%=strQuery%>' OnMouseOver="reasonToolTip('reason',<%=fetchCount%>)"  onMouseOut='hidemenu();' nowrap><%=strOperDesc%></td>
			<%
						}
						else
						{
			%>
							<td class='<%=strQuery%>' nowrap><%=strOperDesc%></td>
			<% 
						} 
			%>

							<td class='<%=strQuery%>'  nowrap><%=strSpecialityDesc%></td>
							<td class='<%=strQuery%>' nowrap><%=strSurgeonName%></td>
							<td class='<%=strQuery%>' ><%=strPrefDate%></td>
							<!--Added against MO-CRF-20086 Starts Here-->
							<td class='<%=strQuery%>' ><%=strCategory%></td>
							<td class='<%=strQuery%>' nowrap><%=strPriority%></td>
							<!--Added against MO-CRF-20086 Ends Here-->
							<td class='<%=strQuery%>' nowrap > <font color='<%=strTextColor%>' ><%=strWaitlist%></td>
							<td class='<%=strQuery%>' ><%=waitListDays%></td>
						    <td class='<%=strQuery%>' ><%=status%></td>
							<!--Added by lakshmi against MO-CRF-20051-->
							<td class='<%=strQuery%>' >
	<!--<input type='hidden' name='MYREMARKS<%=fetchCount%>' id='MYREMARKS<%=fetchCount%>' value="<%=strPreOperDiag%>">-->
							<a  class='<%=strQuery%>' href="javascript:showWaitlistRemarks('<%=strOrderId%>');">
							<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
							</td> 		
<!--	<a  class='<%=strQuery%>' href="javascript:showRemarks(document.forms[0].MYREMARKS<%=fetchCount%>,'0',remarks_value,1500);">
			<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a></td> -->
			<!--<a  class='gridLink' href="javascript:showRemarks('<%=strPreOperDiag%>','0',remarks_value);">
			<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>-->
						</tr>
			<%
					fetchCount++;
					s++;
				}
			}
	

			if(fetchCount==0){
				out.println("<script>callNoRecord();</script>");
			}
			if ( fetchCount < 15 || (!rs.next()) ) {
			%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
				</script>
			<% 
			} 
			else 
			{
			%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
				</script>
				
			<%
			}
			%>
 				</table>
 				<input type='hidden' name='locale' id='locale' value="<%=locale%>">
 				<input type='hidden' name='from_date' id='from_date' value="<%=from_date%>">
				<input type='hidden' name='to_date' id='to_date' value="<%=to_date%>">
				<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityid%>">
				<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>">
				<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>">
				<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
				<input type='hidden' name='patient_name' id='patient_name' value="<%=patient_name%>">
				<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=surgeon_code%>">
				<input type='hidden' name='status_old' id='status_old' value="<%=status%>">
				<input type='hidden' name='patientId' id='patientId' id="patientId" value="<%=strPatientId%>"><!--PMG MOD CRF-0024 US-3-->
				<!--Added against MO-CRF-20086 Starts Here-->
				<input type='hidden' name='category' id='category' value="<%=category%>">
				<input type='hidden' name='priority' id='priority' value="<%=priority%>">
				<!--Added against MO-CRF-20086 Ends Here-->
	 	</form>
	 	<!--div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	
		</div--> 
		<!--IE-11 059507-->
		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		 	<table id='tooltiptable' cellpadding="0" cellspacing=0 border='0'   style='position:absolute;' width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='menu_table'></td>
				</tr>
			</table>
		</div>
	</body>
	<!--IE-11 059507-->
	
</html> <%
	}catch(Exception ee){
		ee.printStackTrace();
		//System.err.println("Exception "+ee);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	}
	%>

