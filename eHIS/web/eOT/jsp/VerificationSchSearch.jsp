<!DOCTYPE html>
<%@ page import ="eOT.SlateBean,java.util.ArrayList,java.util.HashMap,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository,java.net.URLDecoder" contentType="text/html;charset=UTF-8"%>
<% 
String locale = ((String)session.getAttribute("LOCALE"));          
%>
<%! public static String encode(String data){	  
	  byte byteData[] = data.getBytes();
	  String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
}
%>
<html> 
<head>
<title></title> 

<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>

<!--<script type="text/javascript" src="../../eOT/js/common.js"></script>-->
<script language="Javascript" src="../../eOT/js/Booking.js"></script>
<script language="Javascript" src="../../eOT/js/BookingPatientSearch.js"></script>
<script language="Javascript" src="../../eOT/js/WaitList.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>
<script language="Javascript">

function checkNumeric(obj){
	var xx=0;
	var strVal=obj.value;
	if(strVal.length==0) return false;
	for(xx=0;xx<strVal.length;xx++)
	if(strVal.charAt(xx)<'0' || strVal.charAt(xx) >'9'){ 
		alert(getMessage("NUMERIC_ENTRY_ONLY",'OT'));
		obj.value="";
		obj.focus();
		return false;
	 }
	 return true;
}	
function checkValidation(objCheck){
	var frmObj=document.forms[0];
	var pos=objCheck.getAttribute('position');
	
	var serial_no =frmObj.serial_no.value;
	var user_id=frmObj.user_id.value;
	var next_stage_code=eval("frmObj.next_stage_code"+pos+".value");
	var to_stage_code=eval("frmObj.to_stage_code"+pos+".value");
//	eval("frmObj.to_stage_code"+pos+".value")=objCheck.value;
	var next_specific_ind=eval("frmObj.next_specific_ind"+pos+".value");
	var next_action_done=eval("frmObj.next_action_done"+pos+".value");
	var next_stage_desc=eval("frmObj.next_stage_desc"+pos+".value");
	var previlage=eval("frmObj.previlage"+pos+".value");
	var msg_1 = getMessage("APP-OT0071","OT");
	var msgArray = msg_1.split("#");
	var not_done_msg = msgArray[0]+next_stage_desc+msgArray[1];
	//Added  [IN:048375]
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=booking_verifi_stage&req_stage_code="+to_stage_code+"&serial_no="+serial_no,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var comp = retVal.split("::");
	//Added [IN:048375]
   if(objCheck.value!=next_stage_code){
	  if(next_action_done=='S'){
		  alert(not_done_msg);
		  objCheck.value="";
	  }
	  if(next_action_done=='A'){
		  alert(not_done_msg);
	  }   
  }
	  if((previlage=='N' && comp[0]=='SPC')&&(comp[1]!=user_id)){
		alert(getMessage("APP-OT0072","OT"));
		objCheck.value="";
		  }

	}
function setInitValue(){
	var frmObj=document.VerificationDtlForm; //Added for ML-MMOH-SCF-2410
	
	var max=frmObj.maxno.value;
	var maxno;	var pos;
	var priority;
//	alert("init value");

	if (max!=''&&max!=null){
	  maxno=parseInt(max,10);
	  for(pos=0;pos<=maxno;pos++){
		priority=eval("frmObj.priority_code"+pos);
		reason_code=eval("frmObj.reason_code"+pos);
		if(priority != null && priority != 'undefined'&& priority !=''){
			priority.value=priority.DB_VALUE;
		}
	  }//end of for
	}//end of if
	}

function getReArrangeSeqFlag_booking_veri()
{
	var formObj=parent.parent.frames[1].document.VerificationSearchForm;
	var facility_id=formObj.facility_id.value;  
	var sql="select RESEQUENCE_REASON_MANDATORY_YN from ot_param_for_facility where operating_facility_id='"+facility_id+"' ";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	return retVal;
}

    function validateReason_rear(){

		var objForm=document.VerificationDtlForm;
		
		var reason_flag=true;
		 var seq; var reason;var bookingseqno;
		var max_no=objForm.maxno.value;
		if (max_no!=null && max_no!=''){
			max_no=parseInt(max_no,10);
			for(pos=0;pos<=max_no-1;pos++){
				seq=eval("objForm.seq_no"+pos+".value");
				bookingseqno=eval("objForm.sequence_no"+pos+".value");
				reason = eval("objForm.reason_code"+pos+".value");

				if((seq==""|| seq==999) && reason!="")
				{
					reason="";
				}
				if(  (seq!=999 && seq!="" && reason!="" ) || ( (seq==999 || seq=="") && reason=="" ) )  { 
					continue;
				}else{
					reason_flag=false;
				break;
			}
		}
		return reason_flag;
	 }
   }

 	function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
		if(confirm(getMessage('APP-OT0191','OT')))
		{
	var submit_flag=false;
	
	var msg_blank = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg_blank.split("&");
	var msg = msgArray[0]+getLabel("Common.reason.label","Common")+" "+msgArray[1];

		var formObj=parent.parent.frames[1].document.VerificationSearchForm;
	
	var re_arange_seq_flag=getReArrangeSeqFlag_booking_veri();
	if(formObj.chk_sequence.checked==true && re_arange_seq_flag=="Y"){
			if(validateReason_rear()==false){
				submit_flag=false;
			}else{
				submit_flag=true;
			}
	}else{
		submit_flag=true;
	}
	
	var objForm1=document.VerificationDtlForm;

		if(objForm1!=null)
	{
		 var stagecode; 
		var max_no=objForm1.maxno.value;
		var from=objForm1.from.value;
		var to=objForm1.to.value;
		
if(formObj.chk_sequence.checked==false)
	{
		if (from!=''&&from!=null){
			max_no=parseInt(max_no);
			from=parseInt(from-1);
			to=parseInt(to-1);

			for(pos=0;pos<max_no-1;pos++){
				var stagecode=eval("objForm1.to_stage_code"+pos+".value");
				var stageFinalizationCode=eval("objForm1.finalizationcode"+pos+".value");
				var facilityid=eval("objForm1.facilityid"+pos+".value");
				
				var patient_id=eval("objForm1.patient_id"+pos+".value");
	
				var order_id=eval("objForm1.order_id"+pos+".value");
							
				var booking_num=eval("objForm1.booking_num"+pos+".value");
		
				if(stagecode==stageFinalizationCode)
				{
					
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var temp_jsp="BookingValidation.jsp?booking_no="+booking_num+"&facility_id="+facilityid+"&patient_id="+patient_id+"&mode=insert"+"&orderid="+order_id;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var resText =trimString1(xmlHttp.responseText);
					
					var pt_array  = resText.split("##");
					if(pt_array[0]=="E")
					{
							alert(pt_array[2]);
							alert(pt_array[3]);
							submit_flag=false;
						
					}
					if(pt_array[0]=="S" && pt_array[1]=="S")
					{
						alert(pt_array[2]);
						submit_flag=false;
						
					}

					
					if(pt_array[0]=="S" && pt_array[1]=="O")
					{
						if(window.confirm(pt_array[2]))
						{
							submit_flag=true;
						}
						else 
						{
							submit_flag=false;
						}
					}
					
					if(pt_array[0]=="S" && pt_array[1]=="A")
					{
						submit_flag=true;
						
					}
					if(pt_array[0]=="S" && pt_array[1]=="M")
					{
						alert(pt_array[2]);
						submit_flag=true;
						
					}

				if(submit_flag==false)
				{
					msg="";
				}

				}
				
			}
		}
	}
		if(submit_flag==true){
	
		var objForm=document.VerificationDtlForm;
		var xmlStr= collectAllDetails(objForm);
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr="<root>"+xmlStr;
		xmlStr+="</root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(xmlStr.indexOf("<root></root>")!=-1){
		var msg1 = getMessage("NO_CHANGE_TO_SAVE","Common");
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg1;
		return;
	    }
		xmlHttp.open("POST", "../../servlet/eOT.BookingServlet", false);
		xmlHttp.send(xmlDoc);
		var resTxt=xmlHttp.responseText;
		var objf=parent.parent.parent.parent.frames[2].document.forms[0];
			parent.parent.parent.frames[0].document.location.href=objf.qury.value;
			parent.parent.frames[2].document.location.href="../../eOT/jsp/VerificationSchSearch.jsp?"+objForm.param1.value;
		
		var msg_inserted = getMessage("RECORD_INSERTED","SM");
		parent.parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg_inserted;	
	}else
		{
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		}

	}else
	{

	}
		}else
		{
				var frmObj=document.forms[0];
	if(frmObj.surgeon_code.value=='*ALL') frmObj.surgeon_code.value='';
	if(frmObj.room_code.value=='*ALL') frmObj.room_code.value='';
	var locale = frmObj.locale.value;
    var theatre_date=dateUtils(frmObj.theatre_date.value,locale);
	var booking_stage=frmObj.booking_stage.value;
	var seq = (frmObj.chk_sequence.checked==true) ?"Y":"N"
	var param='room_code='+frmObj.room_code.value+'&chk_sequence='+seq+"&theatre_date="+theatre_date+"&speciality_code="+frmObj.speciality_code1.value+"&surgeon_code="+frmObj.surgeon_code.value+"&theatre_type_code="+frmObj.theatre_type_code.value+"&surgery_type="+frmObj.surgery_type.value+"&from="+from+"&to="+to+"&booking_stage="+booking_stage;

	parent.parent.frames[2].location.href = '../../eOT/jsp/VerificationHdrFrame.jsp?'+param;	
	parent.parent.frames[3].location.href='../../eOT/jsp/VerificationColorInd.jsp';
	
		}
}

function submitPrevNext_emer(from, to)
{

	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 

	var frmObj=document.forms[0];
	if(frmObj.surgeon_code.value=='*ALL') frmObj.surgeon_code.value='';
  //  var theatre_date=frmObj.theatre_date.value;
    var facility_id=frmObj.facility_id.value;
	var locale = frmObj.locale.value;
	var sql="SELECT PATIENT_ID, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = A.PATIENT_ID) PATIENT_NAME, OPER_DESC SPECIALITY_DESC,BOOKING_NUM, SURGEON_NAME, SURGERY_TYPE, TRUNC(SYSDATE - WAITLIST_DATE) WAITLISTED_DAYS,ORDER_ID,WAITLIST_NUM,TO_CHAR(PREFERRED_DATE,'DD/MM/YYYY') PREFERRED_DATE ,TO_CHAR(WAITLIST_DATE,'DD/MM/YYYY HH24:MI') WAITLIST_DATE, NVL2(BOOKING_NUM,'Assigned','Unassigned') STATUS, TO_CHAR(BOOKING_DATE,'DD/MM/YYYY') BOOKING_DATE, THEATRE_DESC, TO_CHAR(BOOKING_START_TIME,'HH24:MI') BOOKING_START_TIME FROM OT_WAITLIST_VW A WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND NATURE_TYPE='EM' AND LANGUAGE_ID='"+locale+"'" ;
	var where="";
	if(isNull(frmObj.view.value)==false && frmObj.view.value=="A"){
		where+="AND (BOOKING_NUM IS NULL OR (BOOKING_NUM IS NOT NULL AND TRUNC(BOOKING_DATE) = TRUNC(SYSDATE)))";
	}
	
	if(isNull(frmObj.view.value)==false && frmObj.view.value=="U"){
		where+=" AND BOOKING_NUM IS NULL";
	}
	if(isNull(frmObj.view.value)==false && frmObj.view.value=="S"){
		where+="  AND BOOKING_NUM IS NOT NULL AND TRUNC(BOOKING_DATE) = TRUNC(SYSDATE)";
	}

	if(isNull(frmObj.speciality_code.value)==false)	 	 	
	where+=" AND SPECIALITY_CODE ='"+frmObj.speciality_code1.value+"'";

	if(isNull(frmObj.surgeon_code.value)==false)	 	
		where+=" AND SURGEON_CODE ='"+frmObj.surgeon_code.value+"'";

	if(isNull(frmObj.surgery_type.value)==false)	 	 	
		where +="  AND  NATURE_CODE ='"+frmObj.surgery_type.value+"'";

	sql+=where;  
	var param='sql='+sql+'&from='+from+'&to='+to+'&waitlistkey=YES';


	parent.parent.frames[2].location.href = '../../eOT/jsp/VerificationHdrFrame.jsp?'+param;	
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='setInitValue()'>
<!--<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>-->
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<form name="VerificationDtlForm" id="VerificationDtlForm">
<%
	String chk_sequence = checkForNull(request.getParameter("chk_sequence"));
	String roomCode=checkForNull(request.getParameter("room_code"));
	String waitlistkey=checkForNull(request.getParameter("waitlistkey"));
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
	String sql="",strPatientId="",strPatientName="",strTheatreDesc="",strBookingDate="",strBookingStatus="",surgery_type="",waitlisted_days="",waitlisted_date="",preferred_date="",waitlist_num="",status="",booking_date="",theatre_desc="",booking_start_time="",strApptFromTime="",strSpecialityDesc="",strSurgeonName="",strCurStage="",strPacStageYN="",strBookingSeq="",strPriorityCode="",strSerialNo="",strBookingNum="",strRoomCode="",strStageCode="",strSeqCheck="",strDisable="",strDisable1="",strOrderId="",strSex="",strDOB="",strReasonCode="",reason_code_1="",strNextStageCode="",strNextSpecificInd="",strNextActionDone="",strNextStageDesc="",strUserPrevilage="",stageFinalizationCode="",strPacYN="",strSurgeonCode="",strSpecialityCode="",oper_status="",oper_status_desc="",reason_description="",proc_description="",strEncounterId="",current_locn="",room_bed_no="",curr_locn="",roomNo="",bed_no="",order_status_text = "",strOper_desc = "";
	int count_oper=0;
	String user_id = (String)session.getValue("login_user");
   	String assignTheatre =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AssignedTheatre.Label","ot_labels");
	String assignDate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels");
	String assignTime = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AssignedTime.Label","ot_labels");
	String facilityid  = (String) session.getValue("facility_id");
	String user_id1  = (String) session.getValue("login_user");
	String theatre_date = request.getParameter("theatre_date");
	String booking_stage = request.getParameter("booking_stage");
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String patient_id = checkForNull(request.getParameter("patient_id"));//MO-CRF-20082
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String room_code = checkForNull(request.getParameter("room_code"));
	String theatre_type_code = checkForNull(request.getParameter("theatre_type_code"));
	String surgerytype = checkForNull(request.getParameter("surgery_type"));
	strSeqCheck=checkForNull(request.getParameter("chk_sequence"));
	String stages1 = checkForNull(request.getParameter("stages1"));		//crf-0021
	String patient_class = checkForNull(request.getParameter("patient_class")); //crf-0014
	String view = checkForNull(request.getParameter("view"));
	String seq = checkForNull(request.getParameter("seq"));
	String empty="".intern();
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
//    String asaScoreCode = "";
	//Anitha Added on 12/17/2010
	String patientid = checkForNull(request.getParameter("patientid"));//MO-CRF-20082
	String preferred_from = checkForNull(request.getParameter("preferred_from"));
	String preferred_to = checkForNull(request.getParameter("preferred_to"));

	StringBuffer staus_times;

	StringBuffer proc_desc = new StringBuffer();
	StringBuffer show_proc = new StringBuffer();
	StringBuffer emr_proc_desc=new StringBuffer();
	StringBuffer where_cond = new StringBuffer();
	String bean_id	 = "SlateBean";
	String bean_name = "eOT.SlateBean";
	SlateBean bean	 = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String req_start = "", req_end = "";
		int start = 0 ;
		int end = 0 ;
		int s=0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	{

		if(chk_sequence.equals("Y"))
		{
			end=300;

		}else
		{
	  	end = 50 ;

		}
	}
	else
	{
		end = Integer.parseInt( to ) ;
	}

		req_start       =   (request.getParameter("start")==null)?"0" :   request.getParameter("start");
		req_end         =   (request.getParameter("end")==null)?"0" :   request.getParameter("end");

	HashMap all_scheduled_case_details = bean.getScheduledCases();
	HashMap scheduled_case_details=new HashMap();
	StringBuffer sb_oper_desc = new StringBuffer();
	String operationsProcedures_value=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
	sb_oper_desc.append(operationsProcedures_value);
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	PreparedStatement pstmt4=null;
	PreparedStatement pstmt5=null;
	PreparedStatement pstmt6=null;
	PreparedStatement pstmtreason=null;
	PreparedStatement pstmt7=null;
	PreparedStatement pstmt_locn_room_bed=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs_locn_room_bed=null;
	sql=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT1");
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
	PreparedStatement pstmt8 = null;
	ResultSet rst3 = null;
	String Disp_Image="";
	//String Text_Image_color="";
	try{		
			conn = ConnectionManager.getConnection(request);
			pstmt=conn.prepareStatement(sql_sm_report); // Added for IN:41808
			rs=pstmt.executeQuery();
			if(rs !=null && rs.next())
			{
			customer_id1=checkForNull(rs.getString("customer_id"));
			}	
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();// End for IN:41808
            //Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
			pstmt8 =conn.prepareStatement("SELECT * from PR_HIGH_RISK_CONDITION where PATIENT_ID=? AND CLOSE_DATE IS NULL");
	
		String 	classvalue=empty;
		HashMap hashIndColor=new HashMap();
		HashMap hashTxtColor=new HashMap();
		String color_ind = "",text_color = "",sql1="",sql2="",sql3="",sql4="",sql5="";
		String sql_status="SELECT STATUS_DESC FROM OT_STATUS_LANG_VW WHERE STATUS_CODE=? AND LANGUAGE_ID='"+locale+"' ";
		PreparedStatement pstmtstatus=conn.prepareStatement(sql_status);
		String sqlreason1="SELECT REASON_DESC,REASON_CODE FROM OT_REASONS_LANG_VW WHERE REASON_CODE = ? AND LANGUAGE_ID='"+locale+"' ";

		pstmtreason=conn.prepareStatement(sqlreason1);
		int i=0;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,locale);
		rs= pstmt.executeQuery();
		while (rs.next()){
			strStageCode=rs.getString("STAGE_CODE1");
			color_ind	= empty+rs.getString("COLOR_IND1");
			text_color	= empty+rs.getString("TEXT_COLOR1");
			hashIndColor.put(strStageCode,color_ind);
			hashTxtColor.put(strStageCode,text_color);
	   }

	   rs.close();
	   pstmt.close();

		if(waitlistkey.equals(empty)){
			//Query moved from booking.js

					sql ="SELECT A.PATIENT_ID PATIENT_ID1,A.BOOKING_STATUS BOOKING_STATUS1,A.ORDER_ID ORDER_ID1, decode( '"+locale+"' ,'en',nvl(b.patient_name,b.patient_name_loc_lang), nvl(b.patient_name_loc_lang,b.patient_name)) PATIENT_NAME1,B.SEX SEX1,to_char(B.DATE_OF_BIRTH,'dd/mm/yyyy') DOB1,C.SHORT_DESC THEATRE_DESC1,to_char(A.APPT_DATE,'dd/mm/yyyy') APPT_DATE1,to_Char(A.APPT_FROM_TIME,'hh24:mi') APPT_FROM_TIME1,D.SHORT_DESC SPECIALITY_DESC1,DECODE(SURGEON_CODE,NULL,NULL,E.SHORT_NAME) SURGEON_NAME1,F.STAGE_CODE STAGE_CODE1,F.POST_STAGE_DESC CUR_STAGE_DESC1,F.SERIAL_NO SERIAL_NO1,NVL(F.PAC_STAGE_YN,'N') PAC_STAGE_YN1,G.PRIORITY_DESC PRIORITY_DESC1,G.PRIORITY_CODE PRIORITY_CODE1,A.BOOKING_SEQUENCE BOOKING_SEQUENCE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1,A.APPT_REF_NUM  BOOKING_NUM1,A.SEQ_CHNG_REASON_CODE REASON_CODE,A.SURGEON_CODE SURG_CODE,A.PRIMARY_SPECIALITY_CODE SPLTY_CODE,A.OPER_STATUS OPER_STATUS1,OT_PAT_CURR_LOCATION (A.OPERATING_FACILITY_ID,NULL,A.APPT_REF_NUM,NULL,'"+locale+"') current_locn,h.long_desc oper_desc,a.asa_score_code,i.patient_class FROM OT_QUEUE A,MP_PATIENT B,OT_OPER_ROOM_LANG_VW C,AM_SPECIALITY_LANG_VW D,ot_booking_hdr i,(SELECT x.language_id, x.practitioner_id,x.PRACTITIONER_NAME short_name FROM am_practitioner_lang_vw x WHERE x.language_id = ? and x.practitioner_id	<>'*ALL'	UNION SELECT language_id, '*ALL' practitioner_id, 'All' short_name FROM sm_language Where language_id='"+locale+"')  E,OT_BOOKING_FIN_STAGES F,OT_BOOKING_PRIORITY G,OT_OPER_MAST_LANG_VW H  WHERE D.LANGUAGE_ID=? AND E.LANGUAGE_ID=?  AND C.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID= ?  AND A.APPT_YN = 'Y'  AND A.APPT_DATE = TO_DATE(?,'DD/MM/YYYY') AND (?= '*A' OR BOOKING_STAGE= ?) AND A.PATIENT_ID = B.PATIENT_ID AND  A.OPER_STATUS <> '99'  AND A.BOOKING_STATUS <> '9' AND  a.PRIMARY_OPER_CODE = h.oper_code AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.OPER_ROOM_CODE = C.OPER_ROOM_CODE AND A.PRIMARY_SPECIALITY_CODE= D.SPECIALITY_CODE  	 AND NVL(A.SURGEON_CODE,'*ALL')	= E.PRACTITIONER_ID  AND A.BOOKING_STAGE	= F.STAGE_CODE and a.booking_priority_code = g.priority_code (+) and h.language_id ='"+locale+"' and a.order_id = i.order_id and i.CANCELLATION_DATE is NULL" ;  // added asa_score_code for crf-0021 and [IN:045158] 

			if(! "".equals(speciality_code)){
				where_cond.append(" AND INSTR(NVL(A.ALL_SPECIALITY_CODES,A.PRIMARY_SPECIALITY_CODE),'#"+speciality_code+"#')>0");
			}
			if(!patient_class.equals("")){ 				//crf-0014
			 patient_class=patient_class.toUpperCase();
				where_cond.append("  AND i.patient_class ='"+patient_class+"'");
			}
			
			if(! "".equals(surgeon_code)){
				where_cond.append(" AND A.SURGEON_CODE ='"+surgeon_code+"'");
			}
			//MO-CRF-20082 START
			if(! "".equals(patient_id)){
							where_cond.append(" AND A.PATIENT_ID ='"+patient_id+"'");
			}
			//MO-CRF-20082 END
			if(! "".equals(room_code)&& "".equals(theatre_type_code)){
				where_cond.append(" AND A.OPER_ROOM_CODE ='"+room_code+"'");
			}
			
			if(! "".equals(theatre_type_code)&& "".equals(room_code)){
				where_cond.append(" AND A.OPER_ROOM_CODE IN (SELECT OPER_ROOM_CODE  FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID='"+facilityid+"'   AND THEATRE_TYPE ='"+theatre_type_code+"')");
			}
            if(! "".equals(room_code)&& !"".equals(theatre_type_code)){
				where_cond.append(" AND A.OPER_ROOM_CODE ='"+room_code+"' AND C.THEATRE_TYPE = '"+theatre_type_code+"' ");
			}

			if(! "".equals(surgerytype)){
				where_cond.append("  AND A.APPT_REF_NUM IN (SELECT BOOKING_NUM FROM OT_BOOKING_HDR WHERE NATURE_CODE ='"+surgerytype+"')");
			}
			if(!stages1.equals("")){  //crf-0021
			 stages1=stages1.toUpperCase();
				where_cond.append("  AND a.ASA_SCORE_CODE ='"+stages1+"'");
			} 
			if( "Y".equals(seq)){
				where_cond.append(" ORDER BY  BOOKING_SEQUENCE1");
			} else {
				where_cond.append(" ORDER BY  APPT_FROM_TIME1,SERIAL_NO1");
			}

			//where_cond.append(order_by);

			sql+=where_cond.toString();

			where_cond.setLength(0);
			strStageCode=checkForNull(request.getParameter("stage_code"));
			sql2=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT3");
			pstmt2=conn.prepareStatement(sql2);
			
			pstmt2.setString(1,locale);
			sql3=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT5");
			pstmt3=conn.prepareStatement(sql3);
			sql4="SELECT 'X' FROM OT_BOOKING_FIN_STAGES_DTL WHERE STAGE_CODE = ? AND FACILITY_ID = ? AND APPL_USER_ID=?"; 
			pstmt4=conn.prepareStatement(sql4);
			sql5=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT2");	
			pstmt5=conn.prepareStatement(sql5);
		
			String sql6="SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('SC')  AND NVL(ACTIVE_YN,'N')='Y')  AND LANGUAGE_ID='"+locale+"' ";
			pstmt6=conn.prepareStatement(sql6);
			String sql7 = "SELECT STAGE_CODE FROM OT_BOOKING_FIN_STAGES WHERE SERIAL_NO IN (SELECT MAX(SERIAL_NO) FROM OT_BOOKING_FIN_STAGES) ORDER BY SERIAL_NO";
			pstmt=conn.prepareStatement(sql7);
	
			//String oper_sql = "SELECT B.LONG_DESC LONG_DESC1  FROM  OT_BOOKING_DTLS A, OT_OPER_MAST_LANG_VW B WHERE A.OPERATING_FACILITY_ID 	= ? AND	 A.BOOKING_NUM 	= ?  AND  A.OPER_CODE	= B.OPER_CODE  AND LANGUAGE_ID='"+locale+"' ";
			//pstmt7=conn.prepareStatement(oper_sql);
			rs= pstmt.executeQuery();
			//proc_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")).append(",");  
			while (rs.next()){
				stageFinalizationCode=checkForNull(rs.getString(1));
			}
			rs.close();
			pstmt.close();

			sql1=OTRepository.getOTKeyValue("SQL_OT_VERIFICATION_SELECT4");	
			pstmt1=conn.prepareStatement(sql1);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityid);
			pstmt.setString(6,theatre_date);
//			pstmt.setString(7,theatre_date); // COMMENTED FOR PE
			pstmt.setString(7,booking_stage);
			pstmt.setString(8,booking_stage);
			rs=pstmt.executeQuery();
			if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{
			while( s<=end && rs.next()){	

			if(i==0)
						{
%>
						<input type=hidden name='from' id='from' value='<%=start%>'>
						<input type=hidden name='to' id='to' value='<%=end%>'>
					
	<table width='100%' border='0' align='center' >
		<tr>
		<td width='20%' align='right' class='NONURGENT'>
		<%			

		if(chk_sequence.equals("Y"))
		{
		if ( !(start <= 1)) {
	%>
		<a href='javascript:submitPrevNext(<%=(start-300)%>,<%=(end-300)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
	//	if ( !((start+15) > i ))
			{
	%>
		<a href='javascript:submitPrevNext(<%=(start+300)%>,<%=(end+300)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
		}else
		{
		
		if ( !(start <= 1)) {
	%>
		<a href='javascript:submitPrevNext(<%=(start-50)%>,<%=(end-50)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
	//	if ( !((start+15) > i ))
			{
	%>
		<a href='javascript:submitPrevNext(<%=(start+50)%>,<%=(end+50)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
		}
	%>
		
	</td>
	 </tr>
		</table>
<%
proc_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")).append(",");			
if(roomCode.length()!=0 || strSeqCheck.equals("Y")==true)/*// Changed for 44637*/ {
	%>

<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0' align='center'>
	<tr>
			<th class='columnHeader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.Currentlocation/RoomNo/BedNo.Label" bundle="${ot_labels}"/></th>
			<!-- Added by MuthuN CHL-CRF-0014 starts -->
			<th class='columnHeader' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
			<!-- Added by MuthuN CHL-CRF-0014 ends -->
			<th class='columnHeader' nowrap><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></th>		
			<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.ChangeSequence.Label" bundle="${ot_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.CurrentStage.Label" bundle="${ot_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.CurrentSequence.Label" bundle="${ot_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.AsaScore.Label" bundle="${ot_labels}"/></th> <!-- newly added CRF 0021  -->
			
			</tr>
<%}else{%> 
		<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0' align='center' >
		<tr>
			<th class='columnHeader' nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.Currentlocation/RoomNo/BedNo.Label" bundle="${ot_labels}"/></th>
			<!-- Added by MuthuN CHL-CRF-0014 starts -->
			<th class='columnHeader' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
			<!-- Added by MuthuN CHL-CRF-0014 ends -->
			<th class='columnHeader' nowrap><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></th>		
			<th class='columnHeader' nowrap><fmt:message key="eOT.ChangeStage.Label" bundle="${ot_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.CurrentStage.Label" bundle="${ot_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.CurrentSequence.Label" bundle="${ot_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.AsaScore.Label" bundle="${ot_labels}"/></th> <!-- newly added CRF 0021  -->
			
			
			</tr>
<%}	%>

<%
			}

			count_oper++;
			oper_status_desc="";
			strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
			strBookingStatus=checkForNull(rs.getString("BOOKING_STATUS1"));
			strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
			strSex=checkForNull(rs.getString("SEX1"));
			strDOB=checkForNull(rs.getString("DOB1"));
			strTheatreDesc=checkForNull(rs.getString("THEATRE_DESC1"));
			strBookingDate=checkForNull(rs.getString("APPT_DATE1"));
			strApptFromTime=checkForNull(rs.getString("APPT_FROM_TIME1"));	
			strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
			strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));
			strCurStage=checkForNull(rs.getString("CUR_STAGE_DESC1"));
			strStageCode=checkForNull(rs.getString("STAGE_CODE1"));
			strPacStageYN=checkForNull(rs.getString("PAC_STAGE_YN1"));
			strPriorityCode=checkForNull(rs.getString("PRIORITY_CODE1"));
			strSerialNo=checkForNull(rs.getString("SERIAL_NO1"));
			strBookingSeq=checkForNull(rs.getString("BOOKING_SEQUENCE1"));
			strBookingNum=checkForNull(rs.getString("BOOKING_NUM1"));
			strRoomCode=checkForNull(rs.getString("OPER_ROOM_CODE1"));
			oper_status=checkForNull(rs.getString("OPER_STATUS1"));
			strOrderId=checkForNull(rs.getString("ORDER_ID1"));
			strReasonCode=checkForNull(rs.getString("REASON_CODE"));
			strSurgeonCode=checkForNull(rs.getString("SURG_CODE"));
			strSpecialityCode=checkForNull(rs.getString("SPLTY_CODE"));
			current_locn=checkForNull(rs.getString("current_locn"));
			strOper_desc=checkForNull(rs.getString("oper_desc"));
			stages1=checkForNull(rs.getString("asa_score_code")); //crf-0021
			patient_class=checkForNull(rs.getString("patient_class")); //crf-0014
			//proc_desc = (count_oper==1)?proc_desc.append(strOper_desc):proc_desc.append(","+strOper_desc);
			 //show_proc =(count_oper==1)?show_proc.append("<B>").append(count_oper).append(". ").append("</B>").append(proc_description).append("<B>").append("(").append((strSpecialityDesc)).append(")").append("</B>"):show_proc.append(",").append("<B>").append(count_oper+". ").append("</B>").append(proc_description).append("<B>").append("(").append((strSpecialityDesc)).append(")").append("</B>");
			if(strSurgeonCode.equals("")){
				strSurgeonName=all_surgeons;
			}
			strOper_desc=strOper_desc+"( "+strSpecialityDesc+")";
				try {
	if(current_locn!=""){	
			int counter=0;
				StringTokenizer strToken1=new StringTokenizer(current_locn,"$$");
				 counter=strToken1.countTokens();

				if(strToken1.hasMoreTokens()){
					 if(counter <=1)
					{
				 curr_locn=strToken1.nextToken();
				 if(curr_locn.equals("^")) curr_locn="";
				  roomNo="";
					bed_no="";
					}else if(counter <=2)
					{
						 curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						  if(roomNo.equals("^")) roomNo="";
						  bed_no="";
					}else
					{
				curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						  if(roomNo.equals("^")) roomNo="";
				 bed_no=strToken1.nextToken();
				  if(bed_no.equals("^")) bed_no="";
					}
				}

				
			if(roomNo.equals("") && bed_no.equals(""))
				{
					room_bed_no=curr_locn;
					
				}else	if(roomNo.equals(""))
				{
				room_bed_no=curr_locn+"/"+bed_no;
			
				}else if(bed_no.equals(""))
				{
					room_bed_no=curr_locn+"/"+roomNo;
					
				}else if(curr_locn.equals(""))
				{
				room_bed_no=roomNo+"/"+bed_no;
				
				}else 
				{
					room_bed_no=curr_locn+"/"+roomNo+"/"+bed_no;
				
				}
			}else{
				room_bed_no="";
			}
				}catch(Exception e){
			   //System.err.println("Verification Sch Search.jsp Curr Location "+e);
			   e.printStackTrace();
		   }
			int count=0;
		   color_ind=empty+hashIndColor.get(strStageCode);
		   text_color=empty+hashTxtColor.get(strStageCode);
		   classvalue="OTCLASS"+strStageCode;
		   color_ind = checkForNull(color_ind);

	%>
	<tr>
		<%
			try{
				strPacYN="N";
				pstmt1.setString(1,strStageCode);
				rs1=pstmt1.executeQuery();
				while (rs1.next()){			 
					strPacYN=checkForNull(rs1.getString("PAC_YN1"));	
				}	
				if(strOrderId.length()==0) strPacYN="N";
				rs1.close();
	}catch(Exception xx) {
		xx.printStackTrace();
	}
%>
      <input type='hidden' name='patsexdob<%=i%>' id='patsexdob<%=i%>' value="<%=java.net.URLEncoder.encode(strPatientName,"UTF-8")+"::"+strSex+"::"+strDOB%>">
	   <input type='hidden' name='proc_desc<%=i%>' id='proc_desc<%=i%>' value="<%=proc_desc.toString()%>">
	   
	
	<%
      if(strBookingStatus.equals("R")==false){
		strDisable1=empty;
		scheduled_case_details=(HashMap)all_scheduled_case_details.get(i+"");

	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 starts here
		pstmt8.setString(1,strPatientId);
		rst3 = pstmt8.executeQuery();
		if(rst3.next()){
			Disp_Image ="../../eOT/images/High_risk.gif";
			//Text_Image_color="RED";
				}
		else{
			Disp_Image ="../../eOT/images/drugInfo.gif";
			//Text_Image_color="BLACK";
				}
    //Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 ends here
		%>	

		<input type="hidden" name="order_status_text_<%=i%>" id="order_status_text_<%=i%>" value="<%=order_status_text%>">

		<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=strPatientId%>">

		<!--<td style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >

		<img src='../../eOT/images/drugInfo.gif' onmouseover="Tip(indicatorToolTip('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)" onmouseout="UnTip()">
		<%=strPatientId%></td>-->

		<!--Modified by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012f-->
		<td style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">

		<img src='<%=Disp_Image%>' onmouseover="Tip(indicatorToolTip('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)" onmouseout="UnTip()"><%=strPatientId%></td>

		<td width='' nowrap id='orderctl<%=i%>' style='cursor:pointer' class='gridDataBlue' onClick="displayToolTip('<%=strBookingNum%>','<%=facilityid%>','<%=strPatientId%>','<%=strBookingDate%>','<%=strRoomCode%>','<%=strSeqCheck%>','<%=strPacYN%>','<%=strOrderId%>','<%=i%>','<%=strStageCode%>','<%=stageFinalizationCode%>','<%=strSurgeonCode%>','<%=java.net.URLEncoder.encode(strSurgeonName,"UTF-8")%>','<%=strSpecialityCode%>','<%=java.net.URLEncoder.encode(strSpecialityDesc,"UTF-8")%>','<%=oper_status%>','<%=strEncounterId%>',this,'imgArrow<%=i%>','<%=strBookingStatus%>')"  
		<% if(strSeqCheck.equals("Y")==true){%> width='13%' <%}else{%> width='18%'<%}%> ' 
		><a href="#" style="color: blue; text-decoration: underline;"><%=strPatientName%></a><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'>
		<%}	else{
			strDisable1="disabled";
			strCurStage="Rescheduled";
		%>
		<input type="hidden" name="order_status_text_<%=i%>" id="order_status_text_<%=i%>" value="<%=order_status_text%>">
		<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=strPatientId%>">
		<td style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >

		<img src='../../eOT/images/drugInfo.gif' onmouseover="Tip(indicatorToolTip('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)" onmouseout="UnTip()">
		<%=strPatientId%></td>
		<td width='' nowrap id='orderctl<%=i%>' style='cursor:pointer' class='gridDataBlue' onClick="displayToolTip('<%=strBookingNum%>','<%=facilityid%>','<%=strPatientId%>','<%=strBookingDate%>','<%=strRoomCode%>','<%=strSeqCheck%>','<%=strPacYN%>','<%=strOrderId%>','<%=i%>','<%=strStageCode%>','<%=stageFinalizationCode%>','<%=strSurgeonCode%>','<%=java.net.URLEncoder.encode(strSurgeonName,"UTF-8")%>','<%=strSpecialityCode%>','<%=java.net.URLEncoder.encode(strSpecialityDesc,"UTF-8")%>','<%=oper_status%>','<%=strEncounterId%>',this,'imgArrow<%=i%>','<%=strBookingStatus%>')"
		<% if(strSeqCheck.equals("Y")==true){%> width='16%' <%}else{%> width='18%'<%}%>    onMouseOver='hidemenu();'>
		<%=strPatientName%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'>	
		

	<%}%>
</td>

		
		<td width='15%' style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" nowrap><%=room_bed_no%></td>

		
		<%  if(strSeqCheck.equals("Y")==false){	%>

		<!-- Start CRF-0014-->
			<td width='8%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">
				<%=patient_class%>
			</td>
			<!-- End -->
			<td  width='15%' style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">
				<%=strTheatreDesc%></td>	
			
			<td width='15%' style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">
				<%=strApptFromTime%>
			</td>
			<td  class="gridData" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" ><img src='../../eOT/images/drugInfo.gif' onmouseover="Tip(reasonToolTip('proc_desc',<%=i%>) )" onmouseout="UnTip()">
			<%=strOper_desc%> </td>
			<%
		
				if(strSeqCheck.equals("Y") !=true){
				%>
				<td width='5%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<select name='to_stage_code<%=i%>' id='to_stage_code<%=i%>' position="<%=i%>" OnChange="checkValidation(this);" <%=strDisable1%> >
				<option name='' value=''>&nbsp;</option>
				<% 
					pstmt5.setString(1,locale);
					pstmt5.setString(2,strStageCode);
					rs1=pstmt5.executeQuery();
					if(rs1!=null){
						while (rs1.next()){			 
							out.print("<option value='"+rs1.getString("STAGE_CODE1")+"'>"		+rs1.getString("STAGE_DESC1")+"</option>");
						}	
						rs1.close();
					}
				%>
				</select>
				</td>



<%}%>
			<td class="gridData" width='12%' style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" nowrap>
				<%=strSurgeonName%>
			</td>

		<%	if(strSeqCheck.equals("Y") !=true){
	%>

					<td  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" width="3%" >
		<select name='priority_code<%=i%>' id='priority_code<%=i%>' DB_VALUE="<%=strPriorityCode%>" <%=strDisable1%> >
		<option name='' value=''></option>

<%
			rs1=pstmt2.executeQuery();
			if(rs1!=null){
			while (rs1.next()){			 
				out.print("<option value='"+rs1.getString("PRIORITY_CODE1")+"'>"+rs1.getString("PRIORITY_DESC1")+"</option>");

			}
			rs1.close();
		}
		}
%>
		</select>				
	</td>
		

			<% 
	
			if(!oper_status.equals("") && !oper_status.equals("10")){
				pstmtstatus.setString(1,oper_status);
				rs2= pstmtstatus.executeQuery();
				while (rs2.next()){
					oper_status_desc="("+checkForNull(rs2.getString("STATUS_DESC"))+")";
				}
			}
			%>
			

			<td  width='11%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" nowrap>
				<%=strCurStage+oper_status_desc%>
			</td>

								
			<td width='8%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">
				<%=strBookingSeq%>
			</td>
				<!-- Start CRF-0021-->
			<td width='8%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">
				<%=stages1%>
			</td>
			<!-- End -->
			
			<% } else { //Rearrange checked %> 
				
			<td width='8%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">
				<%=patient_class%>
			</td><!-- Added for 44637 -->
			<td  width='12%' style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
			<%=strTheatreDesc%>
			</td>
			
			<td width='5%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>"  >
				<%=strApptFromTime%>
			</td>

				 <td  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" ><img src='../../eOT/images/drugInfo.gif' onmouseover="Tip(reasonToolTip('proc_desc',<%=i%>) )" onmouseout="UnTip()">
				<%=strOper_desc%> 
	
			</td> 
			<td width='11%' style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" nowrap>
			<%=strSurgeonName%>
			</td>
			
			<td  width="7%" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
	<%
		if(strSeqCheck.equals("Y")==true)
			strDisable=empty;
		else 	
			strDisable="disabled";
	   if(strDisable1.equals("disabled"))
		    strDisable=strDisable1;
	%>
	<input type='text' name='seq_no<%=i%>' id='seq_no<%=i%>' class='label' size='3' maxlength='3' DB_VALUE="<%=strBookingSeq%>" position="<%=i%>" value="" <%=strDisable%>  OnBlur="checkNumeric(this);">
	</td>
	
			
		<%}%>


		</select>
		</td>
	<%
		if(strSeqCheck.equals("Y")==true){
			if(!strReasonCode.equals(empty)){
		   pstmtreason.setString(1,strReasonCode);
		   rs1=pstmtreason.executeQuery();
			if(rs1!=null){
				while (rs1.next()){			 
					reason_description=rs1.getString("REASON_DESC");
					reason_code_1=rs1.getString("REASON_CODE");
				}
				rs1.close();
			}

		}
	%>
	<td  width="18%"  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>"  nowrap>
		<input type='hidden' name='reason_code<%=i%>' id='reason_code<%=i%>' class='label' DB_VALUE='<%=reason_code_1%>' value=''>
		<input name='reason_desc<%=i%>' id='reason_desc<%=i%>'  position='<%=i%>' DB_VALUE="<%=reason_description%>" size='15' maxlength='250' value="" onBlur="if(this.value!='')return searchreason(reason_desc<%=i%>,reason_code<%=i%>);else reason_code<%=i%>.value=''">

		<input type='button' class='button' value='?' name='surButton' id='surButton'   onClick=" return searchreason(reason_desc<%=i%>,reason_code<%=i%>);" >
	</td>

<td width='7%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" nowrap>
			<%=strCurStage%>
			</td>
			<td  width='8%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=strBookingSeq%>
				</td>
				<!-- Added for 44637 -->
	
			<td width='8%'  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>">
				<%=stages1%>
			</td>
<%} else{ %>


			<%}%>
<%
	strNextStageCode=empty; 
	strNextSpecificInd=empty; 
	strNextActionDone=empty;
	strNextStageDesc=empty;
	pstmt3.setString(1,locale);
	pstmt3.setString(2,strSerialNo);
	rs1=pstmt3.executeQuery();
	if(rs1!=null){
		while (rs1.next()){			 
			strNextStageCode=checkForNull(rs1.getString("STAGE_CODE1"));
			strNextSpecificInd=checkForNull(rs1.getString("SPECIFIC_IND1"));
			strNextActionDone=checkForNull(rs1.getString("ACTION_IF_NOT_DONE1"));
			strNextStageDesc=checkForNull(rs1.getString("POST_STAGE_DESC1"));	
		}	
		if(rs1!=null) rs1.close();
	}
%>
<%
	strUserPrevilage="N";
	if(strNextSpecificInd.equals("SPC")==true){
		pstmt4.setString(1,strNextStageCode);
		pstmt4.setString(2,facilityid);
		pstmt4.setString(3,user_id1);
		rs1=pstmt4.executeQuery();
		if(rs1!=null){
			while (rs1.next()){			 
				strUserPrevilage="Y";
			}	
			if(rs1!=null) rs1.close();
		}
	}
	
%>
	<input type="hidden" name="next_stage_code<%=i%>" id="next_stage_code<%=i%>" value="<%=strNextStageCode%>">
	<input type="hidden" name="next_specific_ind<%=i%>" id="next_specific_ind<%=i%>" value="<%=strNextSpecificInd%>">
	<input type="hidden" name="next_action_done<%=i%>" id="next_action_done<%=i%>" value="<%=strNextActionDone%>"> 
	<input type="hidden" name="next_stage_desc<%=i%>" id="next_stage_desc<%=i%>" value="<%=strNextStageDesc%>"> 
    <input type="hidden" name="previlage<%=i%>" id="previlage<%=i%>" value="<%=strUserPrevilage%>">
	<input type="hidden" name="from_stage_code<%=i%>" id="from_stage_code<%=i%>" value="<%=strStageCode%>">
	<input type="hidden" name="order_id<%=i%>" id="order_id<%=i%>" value="<%=strOrderId%>">
	<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=strPatientId%>">
	<input type="hidden" name="room_code<%=i%>" id="room_code<%=i%>" value="<%=strRoomCode%>"> 
	<input type="hidden" name="booking_num<%=i%>" id="booking_num<%=i%>" value="<%=strBookingNum%>"> 
	<input type="hidden" name="sequence_no<%=i%>" id="sequence_no<%=i%>" value="<%=strBookingSeq%>"> 
  	<input type="hidden" name="booking_date<%=i%>" id="booking_date<%=i%>" value="<%=strBookingDate%>"> 
  	<input type="hidden" name="finalizationcode<%=i%>" id="finalizationcode<%=i%>" value="<%=stageFinalizationCode%>"> 
  	<input type="hidden" name="stageFinalizationCode" id="stageFinalizationCode" value="<%=stageFinalizationCode%>"> 
  	<input type="hidden" name="facilityid<%=i%>" id="facilityid<%=i%>" value="<%=facilityid%>"> 
  	<input type="hidden" name="facility_ids" id="facility_ids" value="<%=facilityid%>"> 
	<input type="hidden" name="seq_change_yn<%=i%>" id="seq_change_yn<%=i%>" value="<%=strPacStageYN%>"> 
	</tr>
	<%
	s++;
i++;
	}
				}

if(i==0)
			{
	 out.println("<script>callNoRecord();</script>");
}
		if ( i < 15 || (!rs.next()) ) {
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
		<%}

//handling of emergence cases Logic Started Here.......
} else if(waitlistkey.equals("YES")){
	String strQuery=empty;
	
	String emr_proc_sql = "SELECT B.SHORT_DESC DESC1  FROM  OT_WAITLISTING_DTL A, OT_OPER_MAST_LANG_VW B WHERE A.OPERATING_FACILITY_ID  = ? AND  A.WAITLIST_NUM  = ?  AND  A.OPER_CODE = B.OPER_CODE AND LANGUAGE_ID='"+locale+"' " ;
	sql=checkForNull(request.getParameter("sql"));

	//Added for ML-MMOH-SCF-2410 - starts
	String preferredfrom=request.getParameter("preferred_from");
	String preferredto=request.getParameter("preferredto");
	if(preferredfrom.equals("true")){
	String value1=request.getParameter("value1");
	sql+="  AND  TO_DATE(PREFERRED_DATE) >= to_date('"+value1+"','dd/mm/yyyy HH24:MI')";
	}
	if(preferredto.equals("true")){
	String value2=request.getParameter("value2");
	sql+="  AND  TO_DATE(PREFERRED_DATE) <= (to_date('"+value2+"','dd/mm/yyyy HH24:MI'))";
	}//Added for ML-MMOH-SCF-2410 - ends

	pstmt=conn.prepareStatement(sql);
	pstmt1=conn.prepareStatement(emr_proc_sql);
	rs=pstmt.executeQuery();

		if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{

	while(s<=end && rs.next()){	

		if(i==0)
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
			<a href='javascript:submitPrevNext_emer(<%=(start-15)%>,<%=(end-15)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
			<input type=hidden name='whichPage' id='whichPage' value='prev'>
		<%
			}
		//	if ( !((start+15) > fetchCount ))
				{
		%>
			<a href='javascript:submitPrevNext_emer(<%=(start+15)%>,<%=(end+15)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
		<%
			}
		%>
		
	</td>
	 </tr>
	</table>
		<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0' align='center'>
<tr nowrap>
	<th class='columnHeader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="eOT.Currentlocation/RoomNo/BedNo.Label" bundle="${ot_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></th>		
	<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></th>	
	<th class='columnHeader' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="eOT.WaitlistDate.Label" bundle="${ot_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="eOT.WaitlistDays.Label" bundle="${ot_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
	</tr>

		<%}
	  strPatientId=checkForNull(rs.getString("PATIENT_ID"));
	  strPatientName=java.net.URLEncoder.encode(checkForNull(rs.getString("PATIENT_NAME")));
	  strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC"));
	  //strSurgeonName=java.net.URLEncoder.encode(checkForNull(rs.getString("SURGEON_NAME")));//commented for 056016
		//056016 start
		//strSurgeonName=URLDecoder.decode(checkForNull(rs.getString("SURGEON_NAME")),"UTF-8");
		strSurgeonName=checkForNull(rs.getString("SURGEON_NAME"));
		//056016 end
	  surgery_type=checkForNull(rs.getString("SURGERY_TYPE"));
	  waitlisted_days=checkForNull(rs.getString("WAITLISTED_DAYS"));
	  waitlisted_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("WAITLIST_DATE"),"DMYHM","en",locale));
  	  preferred_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREFERRED_DATE"),"DMY","en",locale));
	  waitlist_num=checkForNull(rs.getString("WAITLIST_NUM"));
	  strBookingNum=checkForNull(rs.getString("BOOKING_NUM"));
	  strOrderId=checkForNull(rs.getString("ORDER_ID"));
	  status=checkForNull(rs.getString("STATUS"));
	  booking_date=checkForNull(rs.getString("BOOKING_DATE"));
	  theatre_desc=checkForNull(rs.getString("THEATRE_DESC"));
	  booking_start_time=checkForNull(rs.getString("BOOKING_START_TIME"));	  
	  if(hashIndColor!=null){
	  color_ind=empty+hashIndColor.get(strStageCode);
	  text_color=empty+hashTxtColor.get(strStageCode);
	  }
	  strQuery = (i%2==0)?"gridData":"gridData";
	  if(strSurgeonName.equals("")){
			strSurgeonName=all_surgeons;
	  }
      
	  pstmt1.setString(1,facilityid);
	  pstmt1.setString(2,waitlist_num);
	  rs1=pstmt1.executeQuery();
	  int count = 0;
	  emr_proc_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")).append(",");
	  while (rs1.next()){			 
		 count++;
		 proc_description=rs1.getString(1);
		emr_proc_desc = (count==1)?emr_proc_desc.append(proc_description):emr_proc_desc.append(","+proc_description);	
	  }
	  rs1.close();
%>
<tr>
<!-- ***IMPORTANT NOTE:-- on click of displaytooltip, assignment and references  of these values is different in related java script function.. .the names assigned here will not match with the java script fucnction..***-->
<%
		try {
				
				//056016 start
				String locnSql = "SELECT OT_PAT_CURR_LOCATION(?, ?, ?, ?, ?) CURR_LOCN FROM DUAL";
				pstmt_locn_room_bed = conn.prepareStatement(locnSql); 
				//056016 end
				
				 pstmt_locn_room_bed.setString(1,facilityid);
				 pstmt_locn_room_bed.setString(2,"");
				 pstmt_locn_room_bed.setString(3,"");
				 pstmt_locn_room_bed.setString(4,waitlist_num);
				 pstmt_locn_room_bed.setString(5,locale);
				
				rs_locn_room_bed = pstmt_locn_room_bed.executeQuery();
				if( rs_locn_room_bed.next())
				{
					current_locn=rs_locn_room_bed.getString(1);
					if(current_locn ==null) current_locn="";
			
				}
				StringTokenizer strToken1=new StringTokenizer(current_locn,"$$");
				//56016 start
					curr_locn="";roomNo="";bed_no="";room_bed_no="";
				//56016 end
				if(strToken1.hasMoreTokens()){
				 curr_locn=strToken1.nextToken();
				   if(curr_locn.equals("^")) curr_locn="";
				 roomNo=strToken1.nextToken();
				 if(roomNo.equals("^")) roomNo=""; 
				 bed_no=strToken1.nextToken();
				 if(bed_no.equals("^")) bed_no="";
				}
				if(roomNo.equals("") && bed_no.equals(""))
				{
					room_bed_no=curr_locn;
				}else	if(roomNo.equals(""))
				{
				room_bed_no=curr_locn+"/"+bed_no;
				}else if(bed_no.equals(""))
				{
					room_bed_no=curr_locn+"/"+roomNo;
				}else if(curr_locn.equals(""))
				{
				room_bed_no=roomNo+"/"+bed_no;
				}else 
				{
					room_bed_no=curr_locn+"/"+roomNo+"/"+bed_no;
				}

				}catch(Exception e){
			   e.printStackTrace();
		   }
		   //56016
		   if(status.equals("Unassigned")) {
			scheduled_case_details=(HashMap)all_scheduled_case_details.get(i+"");
	%>
		<td class="<%=strQuery%>" style="font-size:7pt;font-weight:normal;"  nowrap>
		<input type="hidden" name="order_status_text_<%=i%>" id="order_status_text_<%=i%>" value="<%=order_status_text%>">
		<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=strPatientId%>">
		<img src='../../eOT/images/drugInfo.gif' 
		onmouseover="Tip(indicatorToolTip('<%=i%>'),HEIGHT,-100,FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',FONTCOLOR,'#CCFFCC',STICKY,true,CLICKCLOSE,true)"
		onmouseout="UnTip()"> 
		<%=strPatientId%>
		</td>
	<td width='' nowrap id='orderctl<%=i%>' style='cursor:pointer' class='gridDataBlue'  onClick="displayToolTipEmergency('<%=waitlisted_days%>','<%=facilityid%>','<%=strPatientId%>','<%=booking_date%>','<%=strPatientName%>','<%=booking_start_time%>','<%=strBookingNum%>','<%=strOrderId%>','<%=i%>','WAIT','',
	'<%=theatre_desc%>','<%=status%>','<%=surgery_type%>','<%=waitlist_num%>','<%=strSpecialityCode%>','<%=strSpecialityDesc%>',this,'imgArrow<%=i%>')"  
	 width='15%'   onMouseOver='hidemenu();'><%=rs.getString("PATIENT_NAME")%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'>
</td>
<%} else {
%>
<td class="<%=strQuery%>" style="font-size:7pt;font-weight:normal"  nowrap>
		<input type="hidden" name="order_status_text_<%=i%>" id="order_status_text_<%=i%>" value="<%=order_status_text%>">
		<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=strPatientId%>">

		<img src='../../eOT/images/drugInfo.gif' 
		onmouseover="Tip(indicatorToolTip('<%=i%>'),HEIGHT,-100,FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',FONTCOLOR,'#CCFFCC',STICKY,true,CLICKCLOSE,true)"
		onmouseout="UnTip()"> <%=strPatientId%>
		</td>

	<td width='' nowrap id='orderctl<%=i%>' style='cursor:pointer' class='gridDataBlue' onClick="displayToolTip4('<%=strPatientId%>','<%=strBookingNum%>','<%=strOrderId%>','WAIT',this,'imgArrow<%=i%>')"  width='40%'   onMouseOver='hideToolTip1();'><%=rs.getString("PATIENT_NAME")%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'>

	
</td>
<%}%>
		
		<td class="<%=strQuery%>" width='15%'  nowrap><%=room_bed_no%></td>

<input type ="hidden" name='proc_desc<%=i%>' id='proc_desc<%=i%>' value="<%=emr_proc_desc%>" >
<%emr_proc_desc.setLength(0);%>
<td nowrap class="<%=strQuery%>" width='15%' ><img src='../../eOT/images/drugInfo.gif' onmouseover="Tip(reasonToolTip('proc_desc',<%=i%>) )" onmouseout="UnTip()">
<!--removed URI decode for ML-BRU-SCF-1401  start-->
<%=strSpecialityDesc%>
</td>
<td class="<%=strQuery%>" width='14%' nowrap >
<%=strSurgeonName%>
</td>
<td class="<%=strQuery%>" width='11%'>
<%=surgery_type%>
</td>
<!--removed URI decode for ML-BRU-SCF-1401 end-->
<td class="<%=strQuery%>" width='11%'><%=preferred_date%></td>
<td class="<%=strQuery%>" width='11%' nowrap><%=waitlisted_date%></td>
<td class="<%=strQuery%>" width='11%'><%=waitlisted_days%></td>
<%	staus_times=new StringBuffer();
		if(status.equals("Assigned")){
		
		staus_times.append(""+assignTheatre+" : ");
		staus_times.append(theatre_desc);
		staus_times.append("#");
		staus_times.append(" "+assignDate+"     : ");
		//Modified by DhanasekarV against the issue IN025145 on 20/11/2010
		 
 		staus_times.append(DateUtils.convertDate(booking_date,"DMY","en",locale));
//		staus_times.append(booking_date);
		staus_times.append("#");
		staus_times.append(""+assignTime+"      : ");
		staus_times.append(booking_start_time);
		out.println("<input type='hidden' name='reason"+i+"' id='reason"+i+"' value=\""+staus_times+"\" >");
		//
%>

	<td class="<%=strQuery%>" width='11%' style="font-size:7pt;font-weight:normal;color:red" nowrap><img src='../../eOT/images/drugInfo.gif' OnMouseOver="reasonToolTip3('reason',<%=i%>)" onMouseOut="hidemenu();" ><%=status%>
		
	</td>
<%}else{%>
	<td class="<%=strQuery%>" width='11%' ><%=status%></td>
<%}%>
<tr>		
	<input type="hidden" name="booking_num<%=i%>" id="booking_num<%=i%>" value="<%=strOrderId%>">
	<input type="hidden" name="waitlist_num<%=i%>" id="waitlist_num<%=i%>" value="<%=waitlist_num%>"> 

<%	  i++;
	s++;

}
				}
	
	if(i==0)
		 out.println("<script>callNoRecord();</script>");

		if ( i < 15 || (!rs.next()) ) {
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

	rs.close();
	pstmt.close();%>
<%}%>

<input type='hidden' name='chk_sequence' id='chk_sequence' value="<%=strSeqCheck%>">
<input type='hidden' name='speciality_code' id='speciality_code' value="<%=strSpecialityCode%>">
<input type='hidden' name='param1' id='param1' value="<%=request.getQueryString()%>">
<input type='hidden' name='waitlist_key_dtl' id='waitlist_key_dtl' value="<%=waitlistkey%>">
<input type='hidden' name="maxno" id="maxno" id="maxno" value="<%=i%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityid%>">
<input type='hidden' name='test' id='test' value="<%=theatre_date%>">
<input type='hidden' name='hidden_surgeon_code' id='hidden_surgeon_code' value="<%=strSurgeonCode%>">
<input type='hidden' name='user_id' id='user_id' value="<%=user_id%>">
<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=surgeon_code%>">
<input type='hidden' name='stages1' id='stages1' value="<%=stages1%>">   <!-- Added crf - 0021 -->
<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">   <!-- Added crf - 0014 -->
<input type='hidden' name='surgery_type' id='surgery_type' value="<%=surgerytype%>">
<input type='hidden' name='speciality_code1' id='speciality_code1' value="<%=speciality_code%>">
<input type='hidden' name='view' id='view' value="<%=view%>">
<input type='hidden' name='room_code' id='room_code' value="<%=room_code%>">
<input type='hidden' name='theatre_date' id='theatre_date' value="<%=theatre_date%>">
<input type='hidden' name='booking_stage' id='booking_stage' value="<%=booking_stage%>">
<input type='hidden' name='theatre_type_code' id='theatre_type_code' value="<%=theatre_type_code%>">
<input type='hidden' name='Hidn_enc_id_check' id='Hidn_enc_id_check' value=<%=session.getAttribute("enc_id")%>>
<input type='hidden' name='preferred_from' id='preferred_from' value="<%=preferred_from%>">
<input type='hidden' name='preferred_to' id='preferred_to' value="<%=preferred_to%>">
<input type='hidden' name='patientid' id='patientid' value="<%=patientid%>">
<input type='hidden' name='serial_no' id='serial_no' value="<%=strSerialNo%>">
</table>

<%
	if(rs!=null)	rs.close();
	if(rs1!=null) rs1.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(pstmt2!=null) pstmt2.close();
	if(pstmt3!=null) pstmt3.close();
	if(pstmt4!=null) pstmt4.close();
	if(pstmt5!=null) pstmt5.close();
	if(pstmt7!=null) pstmt7.close();
	if(pstmtstatus!=null) pstmtstatus.close(); 
	if(pstmtreason!=null)pstmtreason.close();
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012f
	if(rst3 != null) rst3.close();
	if(pstmt8!= null) pstmt8.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(rs_locn_room_bed!=null) rs_locn_room_bed.close();
		if(pstmt_locn_room_bed!=null)pstmt_locn_room_bed.close();
		proc_desc.setLength(0);
		show_proc.setLength(0);
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
	}
%>
<input type='hidden' name='function_id' id='function_id' value='<%=checkForNull(request.getParameter("function_id"))%>'>
<input type='hidden' name='customer_name' id='customer_name' value="<%=customer_id1%>"> <!-- Added for IN:41808 -->
</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:80%; top:9px; visibility:hidden;' bgcolor='blue'></div>
</body>
</html>

