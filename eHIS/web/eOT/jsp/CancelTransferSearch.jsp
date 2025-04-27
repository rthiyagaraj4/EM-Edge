<!DOCTYPE html>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.util.Properties,eOT.*,eOT.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@page  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<html>
<head>
<title>
</title>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="Javascript" src="../../eOT/js/CancelTransfer.js"></script>
<script language="Javascript" src="../../eOT/js/Booking.js" language="javascript"></script>
<script language="Javascript">
function changeDate(da){
	var dat=new Array();
	var retDat="";
	dat=da.split("/");

	if(dat!=null&& dat != '' && dat.length > 0)
	{
    if(dat[1].length==1) 	dat[1]="0"+dat[1];
	if(dat[0].length==1) 	dat[0]="0"+dat[0];

	retDat=dat[1]+"/";
	retDat+=dat[0]+"/";
	retDat+=dat[2];
	}
	return retDat;
}

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
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var todate_label = getLabel("Common.todate.label","common");
		var fromdate_label = getLabel("Common.fromdate.label","common");
		alert(msgArray[0]+todate_label+msgArray[1]+fromdate_label+msgArray[2]);
		return false;
	}else
		return true;
}


async function callPatientSearch()
{
	var patient_id	=	document.forms[0].patientid;
	var patient_name	=	document.forms[0].patientName;
	var return_value =	"";
	return_value	=(patient_id.value.length>0)?patient_id.value:await PatientSearch();	
	if(return_value==null)  return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			patient_id.focus();
			return
	}
	if(retVal!="" ){
		var retVal_arr = retVal.split("##");
		patient_id.value		=return_value
		patient_name.value		= retVal_arr[0];
	}
	
}

function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patientid.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patientName.value="";

	
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="addlSearchCriteriaForm" id="addlSearchCriteriaForm" method='post' action='../../eOT/jsp/CancelTransferSearch.jsp'>

	<%	
	String facilityid=(String)session.getValue("facility_id");
	Properties p=(Properties)session.getValue("jdbc");
    String login_user= p.getProperty("login_user");

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String preferedDate="",sql="",strPatientId="",strSurgeonCode="",strSpecialityCode="",strSurgeonName="",strSpecialityDesc="",strPatientName="",strCheckinFlag="",strBookScheduleYN = "",strTransferYN="",strCancelYN="",restrict_theatre_booking_yn = "",PatIDLen="",function_id="";

	function_id=request.getParameter("function_id");
	strCheckinFlag=request.getParameter("checkin_booking_flag");
	strCheckinFlag=strCheckinFlag==null?"":strCheckinFlag;
	strPatientId=request.getParameter("patientid");
	strPatientId=strPatientId==null?"":strPatientId;
	strSurgeonCode=request.getParameter("SURGEON_CODE");
	strSurgeonCode=strSurgeonCode==null?"":strSurgeonCode;
	strSpecialityCode=request.getParameter("SPECIALITY_CODE");
	strSpecialityCode=strSpecialityCode==null?"":strSpecialityCode;
	strSurgeonName=request.getParameter("SURGEON");
	strSurgeonName=strSurgeonName==null?"":strSurgeonName;
	strSpecialityDesc=request.getParameter("SPECIALITY_DESC");
	strSpecialityDesc=strSpecialityDesc==null?"":strSpecialityDesc;
try{ 

 	conn = ConnectionManager.getConnection(request);

	 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
	 pstmt=conn.prepareStatement(sqlLen);
	 rs=pstmt.executeQuery();
	 while(rs.next() && rs!=null)
	{
     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

	 sql=""+OTRepository.getOTKeyValue("SQL_OT_BOOKING_AUTHORIZATION");

		 
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,facilityid);
	pstmt.setString(2,login_user);
    rs=pstmt.executeQuery();

	if(rs.next()==true)	 {		
		restrict_theatre_booking_yn=CommonBean.checkForNull(rs.getString("RESTRICT_THEATRE_BOOKING_YN"));
		strBookScheduleYN=CommonBean.checkForNull(rs.getString("BOOK_SCHEDULE_YN1"));
		strCancelYN=CommonBean.checkForNull(rs.getString("CANCEL_SCHEDULE_YN"));
		strTransferYN=CommonBean.checkForNull(rs.getString("TRANSFER_SCHEDULE_YN"));
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();


	strCancelYN=strCancelYN==null?"N":strCancelYN;
	strCancelYN=strCancelYN.equals("null")?"N":strCancelYN;
	strTransferYN=strTransferYN==null?"N":strTransferYN;
	strTransferYN=strTransferYN.equals("null")?"N":strTransferYN;
    
	if(("").equals(strBookScheduleYN)) strBookScheduleYN="N";
	if(("").equals(strCancelYN)) strCancelYN="N";
	if(("").equals(strTransferYN)) strTransferYN="N";
	if(("").equals(restrict_theatre_booking_yn)) restrict_theatre_booking_yn="Y";
	if(restrict_theatre_booking_yn.equals("Y") && strCancelYN.equals("N") && strTransferYN.equals("N")){
		
		out.println("<script>alert(getMessage('APP-OT0090','OT'))</script>");
		out.println("<script>callAuthorization(parent.parent.commontoolbarFrame,'User Not Authorized for cancel Transfer booking',getMessage('APP-OT0090','OT'))</script>");
	}

	
	
	pstmt=conn.prepareCall("SELECT to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 from dual");
	rs=pstmt.executeQuery();
	if(rs!=null &&rs.next()==true){
		preferedDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
	}
	if(rs!=null)		rs.close();
	pstmt.close();

	if(strPatientId.length()>0){

	 sql=""+OTRepository.getOTKeyValue("SQL_OT_PENDING_SERARCH_SELECT1");

	 	pstmt=conn.prepareCall(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,strPatientId);
		rs=pstmt.executeQuery();

	if(rs.next()){	    
   		strPatientName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
	}
	strPatientName=strPatientName==null?"":strPatientName;
  }
}
catch(Exception ee)
{
	ee.printStackTrace();
}
finally{

if(rs!=null)		rs.close();
pstmt.close();
ConnectionManager.returnConnection(conn,request);
}

%>

<table cellpadding="3" cellspacing="0" border="0" width="100%" align="right">

<tr>
<td class='label' width="25%" >
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
</td>
<td  class='fields' width="25%" >
	<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>'  onkeypress="return CheckForSpecChars(event)" value= "<%=strPatientId%>" onBlur="if(this.value!='')callPatientSearch();else clearDesc()">
	<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
</td>

<td class='label' width="25%" >
	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
</td>
<td  class='fields' width="25%">
	<input type='text' name='patientName' id='patientName' maxlength='40' size='30' value= "<%=strPatientName%>" readOnly>
</td>
</tr>


<tr>
	<td class='label' width="25%" >
		<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/>
	</td>

	<td class='fields' width="25%">
		<input name='theatre_type_desc' id='theatre_type_desc' maxlength='20' size='20' value= "" onBlur="if(this.value!='')searchTheatreType(theatre_type_desc);  else theatre_type_code.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton'onClick="searchTheatreType(theatre_type_desc);">	
	</td>

	<td class='label' width="25%" >
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>
	<td  class='fields' width="25%" >
			<input name='theatre' id='theatre' maxlength='20' size='20' value= "" onBlur="if(this.value!='')return searchTheatre(theatre); else room_code.value='' ">
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick=" return searchTheatre(theatre);">
	</td>
</tr>
<tr>
	<td class='label' width="25%"  >
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td  class='fields' width="25%" >
		<input name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='20' size='20' value= "<%=strSpecialityDesc%>" onBlur="if(this.value!='')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="return searchSpeciality(SPECIALITY_DESC);">
	</td>

	<td class='label' width="25%" >
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td  class='fields' width="25%" >
		<input name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=strSurgeonName%>" onBlur="if(this.value!='')return searchSurgeon(SURGEON); else SURGEON_CODE.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton'onClick="return searchSurgeon(SURGEON); ">
	</td>


</tr>
<tr>
	<td  class='label' width="25%"  >
		<fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/> 
	</td>
	<td  class='fields' width="25%"  >	
		<input type='text' name='from_date' id='from_date' size='20'   value='<%=preferedDate%>'  maxlength='10' Onblur="javascript:isValidDate(this);" onkeypress="return checkForSpecCharsforID(event);">
		<img src="../../eCommon/images/CommonCalendar.gif"	
		onClick="return showCalendar('from_date','dd/mm/y');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	
	<td  class='label' width="25%"  >
	<fmt:message key="Common.to.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%">
		<input type='text' name='to_date' id='to_date' size='20'   value=''  maxlength='10' Onblur="javascript:isValidDate(this);" onkeypress="return checkForSpecCharsforID(event);">
		<img src="../../eCommon/images/CommonCalendar.gif" 
		
		onClick="return showCalendar('to_date','dd/mm/y');">
	</td>
</tr>
<tr>
	<td  class='label' width="25%"  >
		<fmt:message key="Common.Appt.RefNo.label" bundle="${common_labels}"/> 
	</td>
	<td class='fields' width="25%" colspan="3" >
		<input type='text' name='ref_no' id='ref_no' maxlength='8' size='20' value= "" >
	</td>
</tr>
<tr >
	<td class='fields' width="25%"> </td>
	<td class='button' width="25%" colspan="3" align='right'>
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onClick="funCancelTransferSearch1();">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'onClick="funClearAll();">
	</td>
</tr>

</table>
	<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>


<input type='hidden' name='orderiddate' id='orderiddate' value=''>
<input type='hidden' name='date_compare' id='date_compare' value='<%=preferedDate%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>'>
<input type='hidden' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value='<%=strSpecialityCode%>'>
<input type='hidden' name='SURGEON_CODE' id='SURGEON_CODE' value='<%=strSurgeonCode%>'>
<input type='hidden' name='theatre_type_code' id='theatre_type_code' value=''>
<input type='hidden' name='room_code' id='room_code' value=''>
<input type='hidden' name='restrict_theatre_booking_yn' id='restrict_theatre_booking_yn' value='<%=restrict_theatre_booking_yn%>'>
<input type='hidden' name='book_yn' id='book_yn' value='<%=strBookScheduleYN%>'>
<input type='hidden' name='cancel_yn' id='cancel_yn' value='<%=strCancelYN%>'>
<input type='hidden' name='transfer_yn' id='transfer_yn' value='<%=strTransferYN%>'>
<input type='hidden' name='checkin_booking_flag' id='checkin_booking_flag' value='<%=strCheckinFlag%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
</form>
</body>
</html>

