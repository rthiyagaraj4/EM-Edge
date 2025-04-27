<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>               
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eOT/js/Booking.js' language='javascript'></script>
<script language='javascript' src='../../eOT/js/CancelTransfer.js' ></script>
  <head>
  		<style>
		 TD.OTMENULAYER
		  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 10PT ;
	 	  BACKGROUND-COLOR: #D8BFD8;
	 	  COLOR: WHITE;
		}
		TD.OTMENU
		  {
			BACKGROUND-COLOR: #C0C0C0 ;
			FONT-SIZE: 9PT ;
			BORDER-STYLE: DASHED;
			BORDER-LEFT-COLOR: #FFA500;
			BORDER-RIGHT-COLOR: #FFA500;
			BORDER-TOP-COLOR: #FFFACD;
			BORDER-BOTTOM-COLOR: #FFFACD;
		  }
		TD.OTCLASS{
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:30;	
			   }
.menu {text-align:left;position:absolute;width:'1300px'}

	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 400px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 250px;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
</style>

<script language='javascript'>
// Invoke Mail Servlet
async function sendMail(fetchCount){
	var formObj = document.pendingOrderDtlForm;	

	var booking_num = eval("formObj.mail_booking_num_"+fetchCount).value;
	var facility_id = formObj.facility_id.value;
			 
	var dialogHeight= "11" ;  // 7
	var dialogWidth	= "26" ; // 22
	var dialogTop = (window.screen.availHeight-dialogHeight)/3;//"210" ;
	var dialogLeft = (window.screen.availWidth-dialogWidth)/4;// "240" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
    var myBars = 'directories=no;location=no;menubar=no' ;

	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop+myBars;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../eOT/jsp/BookingMailReportConfirm.jsp?booking_num="+booking_num+"&facility_id="+facility_id,arguments,features);
	return retVal;
}
function scrollTitle()
{
var tab1=document.getElementById("headerTable");
var y = document.body.scrollTop;
tab1.style.top=y;
}

function assign()
{
var tab1=document.getElementById("headerTable");
tab1.style.top=0;
tab1.style.left=0;
}

function callNoRecord()
{
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
 }
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>
<!-- <body onload='assign()' onscroll="scrollTitle()"> -->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='pendingOrderDtlForm' id='pendingOrderDtlForm' action='' method = 'post'>
<%	
String strStageCode=checkForNull(request.getParameter("stage_code"));

%>
<!-- <div id="headerTable"  class='menu'> -->
<table class='grid' border='1' width='100%' cellpadding=0 cellspacing=0>
<div id="tableContainer">
	<THEAD>
		<TR>
			<td class ='columnheader' nowrap>&nbsp;</td>
			<td class ='columnheader' nowrap> <fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap> <fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap> <fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.BookingNO.Label" bundle="${ot_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eIP.BookingDateTime.label" bundle="${ip_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.OrderID.Label" bundle="${ot_labels}"/></td>
			<!--<td class ='columnheader' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></td>-->
		</TR>
	</THEAD>
<TBODY>
<%
	String strFacilityId=checkForNull(request.getParameter("facility_id") );
	String strFromDate=checkForNull(request.getParameter("from_date"));
	String strToDate=checkForNull(request.getParameter("to_date"));
	String strRoomCode=checkForNull(request.getParameter("room_code") );
	String strSurgeonCode=checkForNull(request.getParameter("surgeon_code") );
	String strAneasthetistCode=checkForNull(request.getParameter("aneasthetist_code") );
	String strPatientId=checkForNull(request.getParameter("patient_id") );
	String strPatientName=checkForNull(request.getParameter("patient_name") );
	String strOrderBy=checkForNull(request.getParameter("order_by") );
	String strStatus=checkForNull(request.getParameter("status") );
	System.err.println("strStatus==bh=="+strStatus);
	String strOperCode=checkForNull(request.getParameter("oper_code"));
	String strSpecialityCode=checkForNull(request.getParameter("speciality_code") );
	String strSex=checkForNull(request.getParameter("sex") );
	String strSourceType=checkForNull(request.getParameter("source_type") );
	String strSourceCode=checkForNull(request.getParameter("source_code") );
	String preOperDiag=checkForNull(request.getParameter("preOperDiag") );
	String theatre_type_code=checkForNull(request.getParameter("theatre_type") );
	String strBookingNo=checkForNull(request.getParameter("bookingNum_desc") );
	String strorder_id=checkForNull(request.getParameter("ORDER_ID") );
String order_id = "";
	//ORDER_ID
	
	String preOperDiagnosis_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreOperativeDiagnosis.Label","ot_labels");
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	System.err.println("eOT status "+strStatus);

	String strQuery="";
	String strDOB="";
	String strTheatreDesc="";
	String strSpecialityDesc="";
	String strSurgeonName="";
	String strAneasthetistName="";
	//String strBookingNo="";
	String strBookingDate="";
	String strStartTime="";
	String strEndTime="";
	String strStatusDesc="";
	String strWaitListNo="";
	String strPreferredDate="";
	String strParameter="";
	String strOperDesc="";
	String strTempBookNo="";
	//String order_id="";
//Modified By DhanasekarV on 29/04/2011
//	String strOrderid ="";

	Connection conn=null;
	PreparedStatement pst=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;

	ResultSet rst=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String sql="";
	String sql1="";
	String subSql="";
	String strMenu="";
	String strMenuItem="";
	int fetchCount=0;
	String strStatusSubcancelled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	String strStatusSubrescheduled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ReScheduleCases.Label","ot_labels");
	String strStatusSubbooked=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels");
	String strStatuswaitlisted=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.WaitList.label","common_labels");
	String strStatusOpersiteIdentified=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels");// Added for IN:41808
	String marker=",";
	String strStatusSub="";
	StringBuilder qry_criteria = new StringBuilder();

   	qry_criteria=(strSurgeonCode.length()>0)?qry_criteria.append("AND SURGEON_CODE= NVL(?,SURGEON_CODE)"):qry_criteria;
	qry_criteria=(strBookingNo.length()>0)?qry_criteria.append("AND BOOKING_NUM= NVL(?,BOOKING_NUM)"):qry_criteria;

	    qry_criteria=(strAneasthetistCode.length()>0)?qry_criteria.append("AND	 ANAESTHETIST_CODE	= NVL(?, ANAESTHETIST_CODE)"):qry_criteria;
    qry_criteria=(strPatientId.length()>0)?qry_criteria.append("AND PATIENT_ID= NVL(?, PATIENT_ID) "):qry_criteria;
//Modified by DhanasekarV against IN027806  on 12/09/2011
	qry_criteria = ((strPatientId.length()==0)&&(strPatientName.length()>0))?qry_criteria.append("AND	 UPPER(PATIENT_NAME) LIKE  UPPER(?) "):qry_criteria;
	   qry_criteria = (strSex.length()>0) ?qry_criteria.append("AND SEX	= NVL(?, SEX) "):qry_criteria;
	   qry_criteria = (strSourceType.length()>0)?qry_criteria.append(" AND DECODE(SOURCE_TYPE,'N','W',SOURCE_TYPE) ='"+strSourceType+"' "):qry_criteria;
	   qry_criteria = (strSourceCode.length()>0)?qry_criteria.append("  AND SOURCE_CODE='"+strSourceCode+"' "):qry_criteria;
  if(strStatus.equals("C")){	
	strStatusSub=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	strStatusSub="'"+strStatusSub+"'";
	}else if(strStatus.equals("R")){ 
	strStatusSub=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ReScheduleCases.Label","ot_labels");
		strStatusSub="'"+strStatusSub+"'";
	}else if(strStatus.equals("A")){
		strStatusSub="DECODE(BOOKING_STATUS,'9','"+strStatusSubcancelled+"',DECODE( NVL(RESCHEDULED_COUNT,0),0,'"+strStatusSubbooked+"','"+strStatusSubrescheduled+"' ) ) ";
	}else if(strStatus.equals("B") ) {
		strStatusSub="DECODE(NVL(RESCHEDULED_COUNT,0),0,'"+strStatusSubbooked+"','"+strStatusSubrescheduled+"' )";
	}

if(strStatus.equals("W")==false){
	if(preOperDiag.length()>0){
		System.err.println("strStatus >0"+strStatus);
		//Sql query modified by Sanjay for IN:027806 on 23-Jun-11. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
		sql="SELECT PATIENT_ID PATIENT_ID1,(SELECT DECODE( '"+locale+"' ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID) PATIENT_NAME1,SEX SEX1,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, THEATRE_DESC  THEATRE_DESC1,SPECIALITY_DESC  SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1 , ANAESTHETIST_NAME ANAESTHETIST_NAME1,A.BOOKING_NUM  BOOKING_NUM1,TO_CHAR(BOOKING_DATE,'DD/MM/YYYY') BOOKING_DATE1, TO_CHAR(BOOKING_START_TIME,'HH24:MI') BOOKING_START_TIME1,TO_CHAR(BOOKING_END_TIME,'HH24:MI') BOOKING_END_TIME1, "+strStatusSub+" STATUS_DESC1, NULL WAITLIST_NUM1 , NULL PREFERRED_DATE1,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPER_DESC1,CANCELLED_BY CANCELLED_BY1,TO_CHAR(CANCELLATION_DATE,'DD/MM/YYYY')  CANCELLATION_DATE1,CANCEL_REASON_CODE CANCEL_REASON_CODE1,PRE_OPER_DIAG PRE_OPER_DIAG1  FROM  OT_BOOKINGS_VW A, OT_OPER_MAST C WHERE A.LANGUAGE_ID = ? AND A.OPERATING_FACILITY_ID = ? AND BOOKING_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),to_date('01/01/3000','dd/mm/yyyy')) AND 	 THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) AND UPPER(PRE_OPER_DIAG) LIKE UPPER('%"+preOperDiag+"%')  ";
	}else{
		System.err.println("strStatus else==="+strStatus);
		//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
		sql="SELECT PATIENT_ID PATIENT_ID1,(SELECT DECODE( '"+locale+"' ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID) PATIENT_NAME1,SEX SEX1,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH1, THEATRE_DESC  THEATRE_DESC1,SPECIALITY_DESC  SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1 , ANAESTHETIST_NAME ANAESTHETIST_NAME1,A.BOOKING_NUM  BOOKING_NUM1,TO_CHAR(BOOKING_DATE,'DD/MM/YYYY') BOOKING_DATE1, TO_CHAR(BOOKING_START_TIME,'HH24:MI') BOOKING_START_TIME1,TO_CHAR(BOOKING_END_TIME,'HH24:MI') BOOKING_END_TIME1, "+strStatusSub+" STATUS_DESC1, NULL WAITLIST_NUM1 , NULL PREFERRED_DATE1,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPER_DESC1,CANCELLED_BY CANCELLED_BY1,TO_CHAR(CANCELLATION_DATE,'DD/MM/YYYY')  CANCELLATION_DATE1,CANCEL_REASON_CODE CANCEL_REASON_CODE1,PRE_OPER_DIAG PRE_OPER_DIAG1  FROM  OT_BOOKINGS_VW A,  OT_OPER_MAST C, OT_OPER_ROOM D  WHERE A.LANGUAGE_ID = ? AND  A.OPERATING_FACILITY_ID=D.OPERATING_FACILITY_ID AND D.THEATRE_TYPE= nvl('"+theatre_type_code+"',D.THEATRE_TYPE) AND A.THEATRE_CODE=D.OPER_ROOM_CODE AND A.OPERATING_FACILITY_ID = ? AND  BOOKING_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),to_date('01/01/3000','dd/mm/yyyy')) AND 	 THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) ";
		
	}
}
subSql=qry_criteria.toString();
qry_criteria.setLength(0);
 if(strStatus.equals("B"))
	{
		sql=sql+subSql;
		sql=sql+"AND BOOKING_STATUS  NOT IN ('9')";
	}else if(strStatus.equals("C")) {
		sql=sql+subSql;
		sql=sql+"AND BOOKING_STATUS IN ('9')";
	}else if(strStatus.equals("R")){
		sql=sql+subSql;
		sql=sql+"AND BOOKING_STATUS NOT IN ('9')  AND  RESCHEDULED_COUNT IS NOT NULL";
	}else if(strStatus.equals("W")){
		if(strRoomCode.equals("*ALL")){
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql="SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1,THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1,SURGEON_NAME SURGEON_NAME1,ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM1, NULL BOOKING_DATE1, NULL BOOKING_START_TIME1,NULL BOOKING_END_TIME1, '"+strStatuswaitlisted+"' STATUS_DESC1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE,'dd/mm/yyyy')  PREFERRED_DATE1,OPER_DESC OPER_DESC1,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1,NULL PRE_OPER_DIAG1   FROM  OT_WAITLIST_VW W WHERE   OPERATING_FACILITY_ID = ? AND LANGUAGE_ID='"+locale+"'  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy')) ";
			sql=sql+subSql;
		}else{
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql="SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1,THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1,SURGEON_NAME SURGEON_NAME1,ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM1, NULL BOOKING_DATE1, NULL BOOKING_START_TIME1,NULL BOOKING_END_TIME1, '"+strStatuswaitlisted+"' STATUS_DESC1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE ,'dd/mm/yyyy') PREFERRED_DATE1,OPER_DESC OPER_DESC1,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1,NULL PRE_OPER_DIAG1  FROM  OT_WAITLIST_VW W WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = ?  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND  NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy'))  AND 	THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) ";
			sql=sql+subSql;
		}
	}else if(strStatus.equals("A") && preOperDiag.length()==0){
		sql=sql+subSql;
		if(strRoomCode.equals("*ALL")==false){
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql1="UNION SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1, ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM , NULL BOOKING_DATE , NULL BOOKING_START_TIME1 , NULL BOOKING_END_TIME1 , '"+strStatuswaitlisted+"' STATUS_DESC1, WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1 ,OPER_DESC OPER_DESC1,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1, NULL PRE_OPER_DIAG1  FROM OT_WAITLIST_VW W WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID     = ?  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND  NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy'))  AND 	THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) ";
			sql1=sql1+subSql;
		}else{
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql1="UNION SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1, ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM , NULL BOOKING_DATE , NULL BOOKING_START_TIME1 , NULL BOOKING_END_TIME1 , '"+strStatuswaitlisted+"' STATUS_DESC1, WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1 ,OPER_DESC OPER_DESC1 ,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1,NULL PRE_OPER_DIAG1   FROM OT_WAITLIST_VW W WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID     = ?  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND  NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy')) ";
			sql1=sql1+subSql;

		}
  }else if(strStatus.equals("A")){
			sql=sql+subSql;
  }
	if(strStageCode.length()>0){
		sql1=" and A.booking_num in(SELECT APPT_REF_NUM FROM OT_QUEUE WHERE operating_facility_id=? AND BOOKING_STAGE=?)";
		sql=sql+subSql;	
	}

	if(strOperCode.length()>0){
		if(strStatus.equals("B")||strStatus.equals("C")||strStatus.equals("R")){
			sql=sql+"  AND '"+strOperCode+"' IN (SELECT OPER_CODE 	FROM	OT_BOOKING_DTLS WHERE OPERATING_FACILITY_ID= A.OPERATING_FACILITY_ID 	AND	  BOOKING_NUM = A.BOOKING_NUM)";
	}else if(strStatus.equals("W")){
		    sql=sql+"AND '"+strOperCode+"' IN (SELECT OPER_CODE FROM	OT_WAITLISTING_DTL  W WHERE OPERATING_FACILITY_ID =W.OPERATING_FACILITY_ID  AND WAITLIST_NUM = W.WAITLIST_NUM)";
	}else{
		  sql=sql+"  AND '"+strOperCode+"' IN (SELECT OPER_CODE  FROM	OT_BOOKING_DTLS WHERE OPERATING_FACILITY_ID= A.OPERATING_FACILITY_ID AND	  BOOKING_NUM = A.BOOKING_NUM)";
		  sql1=sql1+"AND '"+strOperCode+"' IN (SELECT OPER_CODE FROM	OT_WAITLISTING_DTL 	W WHERE OPERATING_FACILITY_ID = W.OPERATING_FACILITY_ID  AND WAITLIST_NUM = W.WAITLIST_NUM) ";
	 }
   }


	if(strSpecialityCode.length()>0){
		sql=sql+" AND instr(ALL_SPECIALITY_CODES,'#'||?||'#') > 0 ";

		if(strStatus.equals("A") && preOperDiag.length()==0){
			sql1=sql1+" AND instr(ALL_SPECIALITY_CODES,'#'||?||'#') > 0 ";
		}
	}

	if(strStatus.equals("W")==false){
	  sql=sql+" AND C.OPER_CODE = ( SELECT oper_code FROM  OT_BOOKING_DTLS WHERE A.OPERATING_FACILITY_ID=OPERATING_FACILITY_ID AND BOOKING_NUM= A.BOOKING_NUM AND ROWNUM=1)";
	}
	
	if(sql1.length()>0)	 sql=sql+sql1;
	switch(strOrderBy.charAt(0)){
		case '1':sql=sql+" order by patient_name1";break;
		case '2':sql=sql+" order by patient_id1";break;
		case '3':sql=sql+" order by theatre_desc1";break;
		case '4':sql=sql+" order by surgeon_name1";break;
		case '5':sql=sql+" order by anaesthetist_name1";break;
		case '6':sql=sql+" order by speciality_desc1";break;
		case '7':sql=sql+" order by booking_num1";break;
		case '8':sql=sql+" order by booking_date1";break;
		case '9':sql=sql+" order by waitlist_num1";break;
		case 'A':sql=sql+" order by preferred_date1";break;
		case 'B':sql=sql+" order by status_Desc1";break;
	}
	conn = ConnectionManager.getConnection(request);
	try{
		pstmt=conn.prepareStatement(sql_sm_report); // Added for IN:41808
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
	   {
	   customer_id1=checkForNull(rs.getString("customer_id"));
	   }	
	    if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();// End for IN:41808
		pstmt=conn.prepareStatement(sql);		
		int index=0;
		if(strStatus.equals("W"))
		{
			pstmt.setString(++index,strFacilityId);
			pstmt.setString(++index,strFromDate);
			pstmt.setString(++index,strToDate);
		}
		else
		{
			pstmt.setString(++index,locale);
			pstmt.setString(++index,strFacilityId);
			pstmt.setString(++index,strFromDate);
			pstmt.setString(++index,strToDate);
		}

		if((strStatus.equals("W")==false)|| (strRoomCode.equals("*ALL")==false))
		{
			pstmt.setString(++index,strRoomCode);
			
			pstmt.setString(++index,strRoomCode);
			
		}
		if(strSurgeonCode.length()>0) {   
			
			pstmt.setString(++index,strSurgeonCode);
			
		}
		if(strBookingNo.length()>0) {   
			
			pstmt.setString(++index,strBookingNo);
			
		}
		if(strAneasthetistCode.length()>0) {
			
			pstmt.setString(++index,strAneasthetistCode);
			
		}
		if(strPatientId.length()>0)
		{
			
			pstmt.setString(++index,strPatientId);
			
		}
			//Modified by DhanasekarV against IN027806  on 12/09/2011
		if((strPatientId.length()==0) && (strPatientName.length()>0)){
			strPatientName="%"+strPatientName+"%";
			
			pstmt.setString(++index,strPatientName);
			
		}
		if(strSex.length()>0)	{
			
			pstmt.setString(++index,strSex);
			
		}
		if(strSpecialityCode.length()>0)  {
		
			pstmt.setString(++index,strSpecialityCode);
			
		}
		if(strStageCode.length()>0){
			
		   pstmt.setString(++index,strFacilityId);
		   
		   pstmt.setString(++index,strStageCode);
		   
		}
		
		//Added below condition on 1/18/2011 by Anitha for 25897
		if(strStatus.equals("A") && preOperDiag.length()==0){
			 
			pstmt.setString(++index,strFacilityId);
			 
			pstmt.setString(++index,strFromDate);
			
			pstmt.setString(++index,strToDate);
			
			if(strRoomCode.equals("*ALL")==false){
			
			pstmt.setString(++index,strRoomCode);
			
			pstmt.setString(++index,strRoomCode);

			}

			if(strSurgeonCode.length()>0){ 
				
				pstmt.setString(++index,strSurgeonCode);
				
			}
			if(strBookingNo.length()>0) {   
			
			pstmt.setString(++index,strBookingNo);
			
			}
			if(strAneasthetistCode.length()>0){ 
			
				pstmt.setString(++index,strAneasthetistCode);
				
			}
			if(strPatientId.length()>0) {
				
				pstmt.setString(++index,strPatientId);
				
			}
			//Modified by DhanasekarV against IN027806  on 12/09/2011
			if((strPatientId.length()==0) && (strPatientName.length()>0)){
			strPatientName="%"+strPatientName+"%";

				pstmt.setString(++index,strPatientName);
			}

			if(strSex.length()>0)	{
				
				pstmt.setString(++index,strSex);
				
			}
			if(strSpecialityCode.length()>0)  {
				
				pstmt.setString(++index,strSpecialityCode);
				
			}
		}
		
		rs=pstmt.executeQuery();		
		pstmt1=conn.prepareStatement("SELECT short_desc ||'('||(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW AA WHERE AA.LANGUAGE_ID = ? AND AA.SPECIALITY_CODE=C.SPECIALITY_CODE)||')' FROM OT_BOOKING_DTLS B, OT_OPER_MAST C  WHERE b.operating_Facility_id=? AND   B.OPER_CODE=C.OPER_CODE   AND B.BOOKING_NUM=?");

		pstmt2=conn.prepareStatement("SELECT short_desc||'('||(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW AA WHERE AA.LANGUAGE_ID = ? AND AA.SPECIALITY_CODE=C.SPECIALITY_CODE)||')' FROM OT_WAITLISTING_DTL B, OT_OPER_MAST C  WHERE b.operating_Facility_id=? AND  B.OPER_CODE=C.OPER_CODE   AND B.WAITLIST_NUM=?");
		
		
		//{
		
		while(rs.next())
		{
		fetchCount++;
		strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		
		strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
		strSex=checkForNull(rs.getString("SEX1"));   	
		strDOB=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));	
		strTheatreDesc=checkForNull(rs.getString("THEATRE_DESC1"));
		strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
		strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));
		strAneasthetistName=checkForNull(rs.getString("ANAESTHETIST_NAME1"));
		strBookingNo=checkForNull(rs.getString("BOOKING_NUM1"));
		strBookingDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("BOOKING_DATE1"),"DMY","en",locale));
		strStartTime=checkForNull(rs.getString("BOOKING_START_TIME1"));
		strEndTime=checkForNull(rs.getString("BOOKING_END_TIME1"));
		strStatusDesc=checkForNull(rs.getString("STATUS_DESC1"));
		strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
		strPreferredDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREFERRED_DATE1"),"DMY","en",locale));
		strOperDesc=checkForNull(rs.getString("OPER_DESC1"));
		preOperDiag=checkForNull(rs.getString("PRE_OPER_DIAG1"));
		if(fetchCount%2==0)	strQuery="gridData";
		else		strQuery="gridData";

			//Added for CRF-92 on 21-Jan-14 
			//Added order id query start
		try{
			if(strorder_id.length()>0){
				String sqlOrder="select order_id from OT_BOOKING_DTLS where BOOKING_NUM =? and OPERATING_FACILITY_ID=? AND order_id=?";
				    pst=conn.prepareStatement(sqlOrder);
					pst.setString(1,strBookingNo);
					pst.setString(2,strFacilityId);
					pst.setString(3,strorder_id);

			}else{
					String sqlOrder="select order_id from OT_BOOKING_DTLS where BOOKING_NUM =? and OPERATING_FACILITY_ID=?";
					pst=conn.prepareStatement(sqlOrder);
					pst.setString(1,strBookingNo);
					pst.setString(2,strFacilityId);
				}
			    rst=pst.executeQuery();
				order_id = "";
				
				if(rst !=null && rst.next())
			   {
				 order_id=checkForNull(rst.getString("order_id"));
			   }else
				   continue;
					if(pst!=null) pst.close();
					if(rst!=null)rst.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		//end
		StringBuilder sbr_menu = new StringBuilder();
		StringBuilder sbr_item = new StringBuilder();

		//Common for All Cases
		sbr_menu.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels"));
		sbr_item.append("BQ5");

		//For Booked Cases
		if(strStatusSubbooked.equals( strStatusDesc)){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ1");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			//sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PrintAppointmentSlip.Label","ot_labels"));
			//sbr_item.append(marker).append("BQ6");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			if(customer_id1.equalsIgnoreCase("RTN")){// Added for IN:41808
			//sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels"));
		//	sbr_item.append(marker).append("BQ7");
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemRequestDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ8");// Added for CRF 0092
			}
			
		}
		
		//For Cancelled Cases
		if(strStatusSubcancelled.equals( strStatusDesc)){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDetail.label","common_labels"));
			sbr_item.append(marker).append("BQ2");
		}

		//For Reschedule Cases
		if(strStatusSubrescheduled.equals( strStatusDesc )){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels"));
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreviousReschedule.Label","ot_labels"));
			sbr_item.append(marker).append("BQ1");
			sbr_item.append(marker).append("BQ4");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PrintAppointmentSlip.Label","ot_labels"));
			sbr_item.append(marker).append("BQ6");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			if(customer_id1.equalsIgnoreCase("RTN")){// Added for IN:41808
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels"));
			sbr_item.append(marker).append("BQ7");
			}
			if(customer_id1.equalsIgnoreCase("RTN")){// Added for CRF 0092
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemRequestDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ8");
			}
		}

		//For WaitListed Cases
		if(strStatuswaitlisted.equals( strStatusDesc)){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.WaitListDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ3");
		}
		
		strMenu = sbr_menu.toString();
		strMenuItem = sbr_item.toString();
		if(sbr_menu!=null) sbr_menu.setLength(0);
		if(sbr_item!=null) sbr_item.setLength(0);
	

		//strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels");
		//strMenuItem=strMenuItem+"BQ5";	
		
		//If booked case or Reschduled cases view Booking Menu


		/*if(strStatusDesc.equals("Booked")||strStatusDesc.equals("Rescheduled")||strStatusDesc.equals(strStatusSubbooked)||strStatusDesc.equals(strStatusSub))
			{
			//strMenu+="Booking Details";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ1";
			}
		if(strStatusDesc.equals("Cancelled") || strStatusDesc.equals(strStatusSub)) {
			if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Cancelled Details";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDetail.label","common_labels");
			strMenuItem=strMenuItem+"BQ2";
			}
		if(strStatusDesc.equals("Waitlisted"))
			{
			if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Waitlist Details";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.WaitListDetails.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ3";
			}
		if(strStatusDesc.equals("Rescheduled") || strStatusDesc.equals(strStatusSub))
			{
			if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Previous Reschedule";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreviousReschedule.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ4";
			}
	//	if(strStatusDesc.equals("Rescheduled")) {
		if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Patient Demographic";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ5";
		//	}*/

		strParameter = strBookingNo + "," + strFacilityId + "," + strPatientId + "," + strWaitListNo + "," + order_id + "," + strStatusDesc;
		System.err.println("===strParameter==="+strParameter);
		

		//out.println("<br>");
		out.println("<tr>");
%>
		<input type="hidden" name="mail_booking_num_<%=fetchCount%>" id="mail_booking_num_<%=fetchCount%>" value="<%=strBookingNo%>" >
		<td  class="button"> <input type="button" class="button" name="mail_<%=fetchCount%>" id="mail_<%=fetchCount%>" value="" onclick="sendMail('<%=fetchCount%>')" title='<fmt:message key="eOT.EmailPrintReminderLetter.Label" bundle="${ot_labels}"/>'> </td>

<% 
		out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"commonDisplayTooltip('"+strMenuItem+"','"+strMenu+"','"+strParameter+"',this,'imgArrow"+fetchCount+"');\"  onMouseOver='hideToolTip();'>"+strPatientName+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");


		
		if(strSex.equals("F")){
			strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(strSex.equals("M")){
			strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else{
			strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}

		out.println("<td class='"+strQuery+"' nowrap>&nbsp;"+strSex+"</td>");

		out.println("<td class='"+strQuery+"'  nowrap>&nbsp;"+strDOB+"</td>");


		out.println("<td class='"+strQuery+"' nowrap>&nbsp;"+strTheatreDesc+"</td>");

		//if waitlisted cases
		if(strStatusDesc.equals(strStatuswaitlisted))
			{
				pstmt2.setString(1,locale);
				pstmt2.setString(2,strFacilityId);
				pstmt2.setString(3,strWaitListNo);
				rs1=pstmt2.executeQuery();
			}
			else
			{
				pstmt1.setString(1,locale);
				pstmt1.setString(2,strFacilityId);
				pstmt1.setString(3,strBookingNo);
				rs1=pstmt1.executeQuery();
			}

			strTempBookNo=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
			while(rs1.next())
			{
				strTempBookNo=strTempBookNo+","+rs1.getString(1);
			}		

			if(rs1!=null)		rs1.close();

		out.println("<input type='hidden' name='reason"+fetchCount+"' id='reason"+fetchCount+"' value=\""+strTempBookNo+"\" >"); 

		out.println("<td "+strQuery+" class='"+strQuery+"'  OnMouseOver=\"reasonToolTip('reason',"+fetchCount+")\"  onMouseOut='hideToolTip();' nowrap>"+strOperDesc+" ("+strSpecialityDesc+")</td>");


		

		out.println("<td class="+strQuery+"   nowrap>&nbsp;"+strSpecialityDesc+"</td>");


		out.println("<td class="+strQuery+"   nowrap>&nbsp;"+strSurgeonName+"</td>");

		out.println("<td class="+strQuery+"   nowrap>&nbsp;"+strAneasthetistName+"</td>");


		out.println("<td class="+strQuery+"  nowrap>&nbsp;"+strStatusDesc+"</td>");

		out.println("<td class="+strQuery+"  >&nbsp;"+strBookingNo+"</td>");

		out.println("<td class="+strQuery+"   nowrap>"+strBookingDate+"("+strStartTime+"-"+strEndTime+")</td>");

		out.println("<td class="+strQuery+"  nowrap>&nbsp;"+order_id+"</td>");
		/*out.println("<td class="+strQuery+"  nowrap>&nbsp;"+strPreferredDate+"</td>");*/

        %>
	<!--	<input type="hidden" name="preOperDiag_<%=fetchCount%>" id="preOperDiag_<%=fetchCount%>"	value="<%=preOperDiag%>">-->
		<%
	/*	out.println("<td class="+strQuery+"   ><a class='gridDataBlue' href=\"javascript:showOperRemarks1('"+preOperDiagnosis_title+"','"+fetchCount+"');\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+"</a></td>");

		out.println("</tr>");*/
		
	}
	if(fetchCount==0)
		 out.println("<script>callNoRecord();</script>");

	}catch(Exception ee){
		//eOT.LogFile.log("OTDebugger","Exception "+ee,this);
		System.err.println("in BookingQryDtl.jsp"+ee.getMessage());
		ee.printStackTrace();
	}
	finally{
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt2!=null) pstmt2.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null)ConnectionManager.returnConnection(conn,request);
	}
%>
		<input type="hidden" name="facility_id" id="facility_id"	value="<%=strFacilityId%>">
	    <input type="hidden" name="order_id" id="order_id"	value="<%=order_id%>"><!-- Added for CRF-92 on 21-Jan-14 -->

		 </table>
					<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		 </form>
			<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
			</BODY>
			</TBODY>
			</div>
		</html>

