<!DOCTYPE html>
<%@ page import = "org.apache.commons.lang.StringEscapeUtils,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.Common.OTRepository" %>

<%! public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
	}
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="Javascript" src="../../eOT/js/CancelTransfer.js"></script>
<script language="Javascript" src="../../eOT/js/Booking.js" language="javascript"></script>
<Script src="../../eXH/js/showModalDialog.js" language="JavaScript"></Script>
<head>
<script>
function checkDate(){
	var data="";
	var data1="";
	var obj=document.forms[0];
	data=obj.from_date.value;
	data=changeDate(data);
	data1=obj.to_date.value;
	data1=changeDate(data1);
	var dat=new Date(data);
	var dat1=new Date(data1);
	if(dat>dat1){
		//alert("To Date should not be less than from date");
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var todate_label = getLabel("Common.todate.label","common");
		var fromdate_label = getLabel("Common.fromdate.label","common");
		alert(msgArray[0]+todate_label+msgArray[1]+fromdate_label+msgArray[2]);
		//	obj.to_date.value.focus();
		return false;
	}else
		return true;
}
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;

	var facility_id = frmObj.facility_id.value;
	var change_from_date = dateUtils(frmObj.from_date.value,locale,"DMY"); 
	var change_to_date = dateUtils(frmObj.to_date.value,locale,"DMY"); 

	if(checkDate()){

		if(change_from_date!=''){
		var sql="SELECT APPT_REF_NUM APPT_REF_NUM1, SURGEON_CODE SURGEON_CODE1,ORDER_ID ORDER_ID1, to_char(APPT_DATE,'dd/mm/yyyy') APPT_DATE1, PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = A.patient_id ) PATIENT_NAME1,OPER_ROOM_DESC OPER_ROOM_DESC1, TO_CHAR (appt_from_time, 'DD/MM/YYYY HH24:MI:SS') APPTFROMDATETIME, TO_CHAR (appt_to_time, 'DD/MM/YYYY HH24:MI:SS') APPTTODATETIME, to_char(APPT_FROM_TIME,'hh24:mi') APPT_FROM_TIME1, to_char(APPT_TO_TIME,'hh24:mi')  APPT_TO_TIME1,SPECIALITY_DESC SPECIALITY_DESC1,SPECIALITY_CODE SPECIALITY_CODE1, SURGEON_NAME SURGEON_NAME1 FROM OT_SCHD_OPERS_VW A  where OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and A.LANGUAGE_ID='"+locale+"' ";
		var where="";

		if(frmObj.speciality_code.value!=null && frmObj.speciality_code.value!='')
			where=escape("  and instr(NVL(ALL_SPECIALITY_CODES,SPECIALITY_CODE),'#"+frmObj.speciality_code.value+"#') > 0 ");

		if(frmObj.theatre_type_code.value!=null && frmObj.theatre_type_code.value!='')
		where+=escape(" and OPER_ROOM_CODE IN (SELECT OPER_ROOM_CODE FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND THEATRE_TYPE='"+frmObj.theatre_type_code.value+"')");


		if(frmObj.surgeon_code.value!=null && frmObj.surgeon_code.value!='')
		where+=escape(" and SURGEON_CODE ='"+frmObj.surgeon_code.value+"'");

if(frmObj.room_code.value!=null && frmObj.room_code.value!='')
	where+=escape(" and OPER_ROOM_CODE ='"+frmObj.room_code.value+"'");


		if((change_from_date!=null && change_from_date!='')||(change_to_date!=null && change_to_date!=''))
		 where +=escape(" AND APPT_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')");


		if((frmObj.ref_no.value !=null && frmObj.ref_no.value!='')||(frmObj.ref_no.value!=null && frmObj.ref_no.value!=''))
			where+= escape(" AND APPT_REF_NUM ='"+frmObj.ref_no.value+"' ");


		if(frmObj.patient_id.value!=null && frmObj.patient_id.value!='')
			   where+=escape(" and PATIENT_ID ='"+frmObj.patient_id.value+"'");
		else
		 if(frmObj.patient_name.value!=null&&frmObj.patient_name.value!='')
				where+= escape(" and UPPER(patient_name) like UPPER('"+frmObj.patient_name.value+"%')");

		where += escape(" AND OPER_NUM IS NULL ");
		where += escape(" AND NVL(BOOKING_STATUS,'X') <> '9' AND NVL(OPER_STATUS,'XX') <> '99' ");

		sql+=where;  

			var param='sql='+sql+'&date_compare='+dateUtils(frmObj.date_compare.value,locale)+'&cancel_yn='+frmObj.cancel_yn.value+'&transfer_yn='+frmObj.transfer_yn.value+"&from="+from+"&to="+to+"&speciality_code="+frmObj.speciality_code.value+"&surgeon_code="+frmObj.surgeon_code.value+"&ref_no="+frmObj.ref_no.value+"&patient_id="+frmObj.patient_id.value+"&patient_name="+frmObj.patient_name.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&room_code="+frmObj.room_code.value+"&theatre_type_code="+frmObj.theatre_type_code.value+"&room_code="+frmObj.room_code.value+"&function_id="+frmObj.function_id.value;
		parent.parent.frames[1].location.href = '../../eOT/jsp/CancelTransferDtlFrm.jsp?'+param;	
	}else{
		 //alert("APP-OT1 Appt Date cannot be Blank");
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 //alert(msgArray[0]+" Appt Date "+msgArray[1]);
		 alert(msgArray[0]+getLabel("Common.AppointmentDate.label","Common")+msgArray[1]);		 
	}
}
}
</script>
 </head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='pendingOrderDtlForm' id='pendingOrderDtlForm' action='' method = 'post'>

<%	
	String facilityid  = (String) session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;	
	ResultSet rs=null;
	String user_id = (String)session.getValue("login_user");
	int fetchCount=0;
	String sql="",function_id="",strApptRefNo="",strApptDate="",strPatientId="",strPatientName="",strOperRoomDesc="",strApptFromTime="",strApptToTime="",strSpecialityDesc="",strSpecialityCode="",strSurgeonName="",strSurgeonCode="",strSysDate="",strCancelYN="",strTransferYN="",strOrderId="",strQuery="";
	String apptfromdatetime = "";
	String appttodatetime = "";

	String cancelappointment_title   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels");
	String transferappointment_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
		String from = request.getParameter( "from"  );
		String to = request.getParameter( "to")  ;
		String from_date = request.getParameter( "from_date") ;
		String to_date = request.getParameter( "to_date" );
		String surgeon_code = CommonBean.checkForNull(request.getParameter( "surgeon_code" )) ;
		String theatre_type_code = CommonBean.checkForNull(request.getParameter( "theatre_type_code" )) ;
		String speciality_code = CommonBean.checkForNull(request.getParameter( "speciality_code" )) ;
		String patient_id = CommonBean.checkForNull(request.getParameter( "patient_id" )) ;
		String patient_name =CommonBean.checkForNull( request.getParameter( "patient_name" )) ;
		String room_code =CommonBean.checkForNull( request.getParameter( "room_code" )) ;
		String ref_no =request.getParameter( "ref_no" ) ;
		if(ref_no ==null) ref_no="";
		String date_compare = request.getParameter( "date_compare" ) ;
		String cancel_yn =CommonBean.checkForNull( request.getParameter( "cancel_yn" )) ;
		 function_id =CommonBean.checkForNull( request.getParameter( "function_id" )) ;
		String transfer_yn =CommonBean.checkForNull( request.getParameter( "transfer_yn" )) ;
		String restrict_theatre_booking_yn =CommonBean.checkForNull( request.getParameter( "restrict_theatre_booking_yn" )) ;
		String book_yn =CommonBean.checkForNull( request.getParameter( "book_yn" )) ;
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

	strCancelYN=checkForNull(request.getParameter("cancel_yn"));
	strTransferYN=checkForNull(request.getParameter("transfer_yn"));
	sql=StringEscapeUtils.unescapeHtml(request.getParameter("sql"));
	strSysDate=request.getParameter("date_compare");
	pstmt=conn.prepareStatement(sql);
	rs=pstmt.executeQuery();

		if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{

while(s<=end && rs.next()){
			
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
		//	if ( !((start+15) > fetchCount ))
				{
		%>
			<a href='javascript:submitPrevNext(<%=(start+15)%>,<%=(end+15)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
		<%
			}
		%>
		
	</td>
	 </tr>
	</table>

		<table class='grid' border='1' width='100%' cellpadding=3 cellspacing=0>
<tr>
		<th class='columnHeader' nowrap><fmt:message key="Common.Appt.RefNo.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></th>		
		<th class='columnHeader' nowrap><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
		<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
</tr>

<%

	}
		strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
		strApptRefNo=checkForNull(rs.getString("APPT_REF_NUM1"));
		strApptDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("APPT_DATE1"),"DMY","en",locale));
		strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));	
		strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
		strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));
		strApptFromTime=checkForNull(rs.getString("APPT_FROM_TIME1"));
		strApptToTime=checkForNull(rs.getString("APPT_TO_TIME1"));	
		apptfromdatetime = checkForNull(rs.getString("APPTFROMDATETIME"));
		appttodatetime = checkForNull(rs.getString("APPTTODATETIME"));
		strSurgeonCode=checkForNull(rs.getString("SURGEON_CODE1"));	
		strOperRoomDesc=checkForNull(rs.getString("OPER_ROOM_DESC1"));
		strOrderId=checkForNull(rs.getString("ORDER_ID1"));

		if(strSurgeonCode.equals("")){
				strSurgeonName=all_surgeons;
			}

	strQuery=(fetchCount%2==0)?"class='gridData'":"class='gridData'";
	%><tr>
		<input type='hidden' name='xx<%=fetchCount%>' id='xx<%=fetchCount%>' value='<%=strSurgeonName%>'>
		<input type='hidden' name='splty<%=fetchCount%>' id='splty<%=fetchCount%>' value='<%=strSpecialityDesc%>' >
<%
		out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue'  onClick=\"commonDisplayTooltip('CT1,CT2','"+cancelappointment_title+","+transferappointment_title+"','"+strApptRefNo+","+facilityid+","+strSurgeonCode+","+fetchCount+","+strSysDate+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strPatientId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\" width='5%'  onMouseOver='hideToolTip();'><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('CT1,CT2','"+cancelappointment_title+","+transferappointment_title+"','"+strApptRefNo+","+facilityid+","+strSurgeonCode+","+fetchCount+","+strSysDate+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strPatientId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\">"+strApptRefNo+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
%>
		<td <%=strQuery%>  width='10%' class='<%=strQuery%>'  align='left'><%=strApptDate%></td>
		<td <%=strQuery%>  width='11%' class='<%=strQuery%>'  align='left'><%=strPatientId%></td>
		<td <%=strQuery%>  width='20%'class='<%=strQuery%>'  align='left'nowrap><%=strPatientName%></td>
		<td <%=strQuery%>  width='10%' class='<%=strQuery%>'  align='left' nowrap><%=strOperRoomDesc%></td>
		<td <%=strQuery%>  width='5%' class='<%=strQuery%>'  align='left'><%=strApptFromTime%></td>
		<td <%=strQuery%> width='5%' class='<%=strQuery%>'  align='left'><%=strApptToTime%></td>
		<td <%=strQuery%>  width='15%' class='<%=strQuery%>'  align='left' nowrap><%=strSpecialityDesc%></td>
		<td <%=strQuery%> width='15%'class='<%=strQuery%>'  align='left' nowrap><%=strSurgeonName%></td>
		</tr>
	<%fetchCount ++;
	s++;

		}
	}
if(fetchCount==0)
	 out.println("<script>callNoRecord1();</script>");

	if ( fetchCount < 15 || (!rs.next()) ) {
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% 
				} else {%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}

}catch(Exception ee){
	System.err.println("Err Msg in CancelTransferDtl.jsp: "+ee);
	ee.printStackTrace();
}
finally{
	if(rs!=null) rs.close();
	pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
 </table>

 <input type='hidden' name='param1' id='param1' value="<%=request.getQueryString()%>">
 <input type='hidden' name='locale' id='locale' value="<%=locale%>">
 <input type='hidden' name='login_user' id='login_user' value="<%=user_id%>">
 <input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
 <input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='from_date' id='from_date' value="<%=from_date%>">
<input type='hidden' name='to_date' id='to_date' value="<%=to_date%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityid%>">
<input type='hidden' name='theatre_type_code' id='theatre_type_code' value="<%=theatre_type_code%>">
<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>">
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
<input type='hidden' name='patient_name' id='patient_name' value="<%=patient_name%>">
<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=surgeon_code%>">
<input type='hidden' name='room_code' id='room_code' value="<%=room_code%>">
<input type='hidden' name='ref_no' id='ref_no' value="<%=ref_no%>">
<input type='hidden' name='date_compare' id='date_compare' value="<%=date_compare%>">
<input type='hidden' name='cancel_yn' id='cancel_yn' value="<%=cancel_yn%>">
<input type='hidden' name='transfer_yn' id='transfer_yn' value="<%=transfer_yn%>">
<input type='hidden' name='restrict_theatre_booking_yn' id='restrict_theatre_booking_yn' value="<%=restrict_theatre_booking_yn%>">
<input type='hidden' name='book_yn' id='book_yn' value="<%=book_yn%>">
<input type='hidden' name='patientId' id='patientId' id="patientId" value="<%=strPatientId%>"><!--PMG MOD CRF-0024 US-3-->

 </form>
 	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
	</div>
</html>

