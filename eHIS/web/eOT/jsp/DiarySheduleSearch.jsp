<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.util.Properties,eCommon.Common.CommonBean,eOT.Common.OTRepository,eOT.*,eCommon.Common.*" %>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Newly Included by Rajesh foe Amazon Changes

Properties p=(Properties)session.getValue("jdbc");
String locale = (String)session.getAttribute("LOCALE");
String client_ip_address = p.getProperty("client_ip_address");
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
String param = request.getQueryString();	
System.out.println("Params in DiaryScheduleSearch.jsp :"+param);
String fpp_category = request.getParameter("fpp_category");	//ML-MMOH-CRF-1939-US005
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script  language="javascript" src="../../eOT/js/Booking.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>

<script language="JavaScript" >	

function setAssignValue(dat){
	return dat;
}
function clearSurgeon(){
	var obj=document.forms[0];
	obj.SURGEON_CODE.value='';
	obj.SURGEON.value='';
	if(obj.SPECIALITY_DESC.value!=''){
		obj.PROCEDURE.value='';
		obj.probutton.disabled=true;
	} 
}

async function bookExternalFacility()
{
	var bookingURL = "../../eOT/jsp/ExternalFacilityLinker.jsp?<%=param%>";
	var dialogHeight	= "10" ;
	var dialogWidth	= "25" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
	var reportURL 	= await window.showModalDialog( bookingURL, arguments, features ) ;
}
function funResetAll(){
	var obj=document.forms[0];
	obj.SURGEON.value='';
	obj.SPECIALITY_DESC.value='';
	obj.PREFERRED_MONTH.value='';
	obj.PREFERRED_DATE.value='';    
	obj.SURGEON_CODE.value='';
	obj.PROCEDURE.value='';
	obj.SPECIALITY_CODE.value='';
	obj.SPECIALITY_CODE.value='';
	obj.theatre.value='';
	obj.room_code.value='';
	obj.chkavilable.checked=false;
    obj.chkavilable.value='N'
	obj.surButton.disabled=false;
	obj.spcButton.disabled=false;
	obj.probutton.disabled=false;
	parent.parent.frames[1].frames[2].location.href = "../../eCommon/html/blank.html?";
}

  function disableAll(){
	var obj=document.forms[0];
	obj.surButton.disabled=true;
	obj.spcButton.disabled=true;
	obj.probutton.disabled=true;
	obj.PREFERRED_MONTH.disabled=true;
	obj.PREFERRED_DATE.disabled=true;
	obj.imagedate.disabled=true;
	obj.imagemonth.disabled=true;

	obj.search.disabled=true;
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="addlSearchCriteriaForm" id="addlSearchCriteriaForm" >
<%	
	//setting character encoding b4 retrieving any request paramter
	request.setCharacterEncoding("UTF-8");
	
	//retrieving Session Attributes
	String facilityid=(String)session.getValue("facility_id");
    String login_user= p.getProperty("login_user");

	//Retrieving Request parameter
	String called_from = checkForNull(request.getParameter("booking_called_from"));
	String strPrefDate=checkForNull(request.getParameter("prefDate"));
	if("OR".equals(called_from)){
		strPrefDate=com.ehis.util.DateUtils.convertDate(strPrefDate,"DMY",locale,"en");
	}
	String strOrderId=checkForNull(request.getParameter("orderid")).trim();
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")).trim(); // ChAiTu - 186
	String ammendFlag = checkForNull(request.getParameter("ammendFlag")).trim(); //MMS-QH-CRF-186
	String strSurgeonCode=checkForNull(request.getParameter("surgeonCode")).trim();
	String strSpecialityCode=checkForNull(request.getParameter("speciality_code")).trim();
	String strBookingNo=checkForNull(request.getParameter("booking_no"));
	String startTime = checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	String endTime = checkForNull(request.getParameter("endTime"));
	String patientId = checkForNull(request.getParameter("patientId")); //PMG2014-CRF-0024
	System.out.println("=========strBookingNo===DiarySheduleSearch======"+strBookingNo);
	System.out.println("=========startTime===DiarySheduleSearch======"+startTime);
	System.out.println("=========endTime===DiarySheduleSearch======"+endTime);
	System.out.println("=========patientId===DiarySheduleSearch======"+patientId);
	System.out.println("=========selOrderIds===DiarySheduleSearch======"+selOrderIds);
	String function_id=checkForNull(request.getParameter("function_id"));
	String alternateBooking=checkForNull(request.getParameter("alternateBooking"));
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;


	//cannonical Representation of Empty String
	String empty = "".intern();
	//Variables Declarations & Initialization.......
	String preferedDate=empty;
	String preferedMonth=empty;
	String prefDate=empty;
	String diary_sched_for_surg_reqd_yn=empty;
	String strSurgeonName=empty;
	String strSpecialityDesc=empty;
	String strBookingYN=empty;
	String restrictTheatreBookingYN=empty;
	String transfer_schedule_yn="";
	StringBuilder sbr = new StringBuilder(300);
	String multiFacility = "";
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	
	
	//SQL QRY Strings used.....
	String speciality_sql="SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW WHERE   SPECIALITY_CODE=? AND LANGUAGE_ID=?";
	String surgeon_sql="SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=? AND LANGUAGE_ID=?";
	String sql_access_rights="SELECT BOOK_SCHEDULE_YN BOOK_SCHEDULE_YN1, (SELECT NVL(RESTRICT_THEATRE_BOOKING_YN,'N') FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=A.OPERATING_FACILITY_ID) RESTRICT_THEATRE_BOOKING_YN,NVL(TRANSFER_SCHEDULE_YN,'N') TRANSFER_SCHEDULE_YN  FROM OT_BOOKING_ACCESS_RIGHTS A WHERE A.OPERATING_FACILITY_ID =?  AND APPL_USER_ID=?";
		/*Commented by Suma as part of query tuning on April 21 2010  the same is added in below query sql_param_chk*/
	//String sql_pref_date="SELECT TO_CHAR(SYSDATE,'mm/dd/yyyy') dat1,TO_CHAR(SYSDATE,'mm/yyyy') month1,TO_CHAR(SYSDATE,'dd/mm/yyyy') dat2  FROM dual";

/*Added by Suma for incident 19261 to sort order by surgeon or theatre in booking function */
	String sql_param_chk="Select DIARY_SCHED_FOR_SURG_REQD_YN,TO_CHAR(SYSDATE,'mm/dd/yyyy') dat1,TO_CHAR(SYSDATE,'mm/yyyy') month1,TO_CHAR(SYSDATE,'dd/mm/yyyy') dat2 from ot_param_for_facility where OPERATING_FACILITY_ID= ?";
	/*ends here*/
	
	//if it is  From OR don't decode otherwise decode surgeon_desc and speciality_desc
	if("OR".equals(called_from)){
		//need to convert english to thai date(since comming from OR comming as English Date)
		strPrefDate=com.ehis.util.DateUtils.convertDate(strPrefDate,"DMY","en",locale);
	}
		try{
			//retreiving surgeonDesc if it is called from OR
			conn = ConnectionManager.getConnection(request);			
			
/*Added by Suma for incident 19261 to sort order by surgeon or theatre in booking function */
				pstmt1 = conn.prepareStatement(sql_param_chk);
				pstmt1.setString(1,facilityid);
				rs1=pstmt1.executeQuery();
				if(rs1!=null && rs1.next()){
					diary_sched_for_surg_reqd_yn=checkForNull(rs1.getString(1));
					preferedDate=rs1.getString("dat1");
				prefDate=com.ehis.util.DateUtils.convertDate(rs1.getString("dat2"),"DMY","en",locale);
				preferedMonth=rs1.getString("month1");

			}
			
	/*ends here*/


			pstmt = conn.prepareStatement(surgeon_sql);
			pstmt.setString(1,strSurgeonCode);
			pstmt.setString(2,locale);
		    rs=pstmt.executeQuery();
			if(rs.next()){
				strSurgeonName=checkForNull(rs.getString(1));
			}
			if(rs!=null)		rs.close();
			if(pstmt !=null)  pstmt.close();

				if(strSurgeonName.equals("") && !function_id.equals("OT_BOOKING")){
				strSurgeonName=all_surgeons;
			}
			//retreiving speciality desc if it is called from OR
			pstmt = conn.prepareStatement(speciality_sql);
			pstmt.setString(1,strSpecialityCode);
			pstmt.setString(2,locale);
			rs=pstmt.executeQuery();
			if(rs.next()){
				strSpecialityDesc=checkForNull(rs.getString(1));
			}
			if(rs!=null)		rs.close();
			if(pstmt !=null)  pstmt.close();
		}catch(Exception ee){
			ee.printStackTrace();
			//System.err.println("Error in DiaryScheduleSearch.jsp surgeon_sql: "+ee);
		
	}

	
	try{
		if(conn==null) conn = ConnectionManager.getConnection(request);
		
		//Added for MO-CRF-20106
		String customer_id="";
		String sql_cust="Select customer_id from SM_SITE_PARAM where rownum = 1";
		pstmt1=conn.prepareStatement(sql_cust);
		rs1=pstmt1.executeQuery();
		
		if(rs1 !=null && rs1.next())
			customer_id=checkForNull(rs1.getString("customer_id"));		
		if(rs1!=null)
			rs1.close();
		if(pstmt1!=null)
			pstmt1.close();
		//Added for MO-CRF-20106

		pstmt = conn.prepareStatement(sql_access_rights);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,login_user);
		rs=pstmt.executeQuery();
		if(rs.next()){
			strBookingYN=checkForNull(rs.getString("BOOK_SCHEDULE_YN1"));
			restrictTheatreBookingYN=checkForNull(rs.getString("RESTRICT_THEATRE_BOOKING_YN"));
			transfer_schedule_yn=checkForNull(rs.getString("TRANSFER_SCHEDULE_YN"));
		}
		if(rs!=null)	 rs.close();
		if(pstmt!=null)  pstmt.close();
         
		 if(("").equals(strBookingYN))
		{
		strBookingYN="N";
		}
		 if(("").equals(restrictTheatreBookingYN))
		{
		restrictTheatreBookingYN="Y";
		}
		if(("").equals(transfer_schedule_yn))
		{
		transfer_schedule_yn="Y";
		}

		//checking booking Rights here
		// NOTE: ("OT_SLATE").equals(called_from) is for OT Slate Reschdule from slate tab 
		if("Y".equals(restrictTheatreBookingYN)){
			if((transfer_schedule_yn.equals("N") ) && (("OT_SLATE").equals(called_from) || ("OT_TO_BE_RESCHD_CASES").equals(function_id)||("OT_SLATE_JAVA").equals(function_id)||("OT_BOOKING_CANCEL_TRANSFER").equals(function_id) || ("BookingVerification").equals(function_id))){
				sbr.append("<script>");
				sbr.append("var msg=getMessage('APP-OT0090T','OT');");
				sbr.append("alert(msg);");
				if("Y".equals(alternateBooking) || ("OT_SLATE").equals(called_from))
                {
                	sbr.append("window.close();");
                }
                else
                sbr.append("parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				sbr.append("</script>");
				out.println(sbr.toString());
				sbr.setLength(0);
			}
	        else
			if((strBookingYN.equals("N") || strBookingYN.length()==0) && !("OT_SLATE").equals(called_from) && !("OT_TO_BE_RESCHD_CASES").equals(function_id) && !("OT_SLATE_JAVA").equals(function_id)&& !("OT_BOOKING_CANCEL_TRANSFER").equals(function_id) && !("BookingVerification").equals(function_id)){
				sbr.append("<script>");
				sbr.append("var msg=getMessage('APP-OT0092','OT');");
				sbr.append("alert(msg);");
				if("Y".equals(alternateBooking) || "OR".equals(called_from))
				{
					sbr.append("window.close();");
				}else{
				sbr.append("window.parent.parent.parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				}
				//sbr.append("parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				sbr.append("</script>");
				out.println(sbr.toString());
				sbr.setLength(0);
			}
		}

		if (strPrefDate.length()==0)	
			strPrefDate = prefDate;		
 		
		//CRF 298 
		
		//Fetch Site Param and Facility Set up Param
		
		if("Y".equals(alternateBooking) && strOrderId.length() > 0)
		{
			
			boolean orderExists = false;
			String checkIfOrderIdExists = "SELECT 1 FROM OT_PENDING_ORDERS_VW WHERE ORDER_ID = ? AND LANGUAGE_ID = 'en'";//186
			
			pstmt = conn.prepareCall(checkIfOrderIdExists);
			pstmt.setString(1, strOrderId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				orderExists = true;
				
			}
			if(rs!=null)	 
				rs.close();
			if(pstmt!=null)  
				pstmt.close();
			if(!orderExists)
			{
				sbr.append("<script>");
				sbr.append("var msg=getMessage('APP-OT0211','OT');");
				sbr.append("alert(msg);");
				
				sbr.append("window.close();");
				//sbr.append("parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				sbr.append("</script>");
				out.println(sbr.toString());
				sbr.setLength(0);
			}
		}
		//show only from Menu / Pending Verification / from OR
		if(alternateBooking == null || !alternateBooking.equals("Y") 
		&& (called_from.equals("") || called_from.equals("BOOKING") || called_from.equals("OR"))
		&& (function_id != null && !function_id.equals("OT_BOOKING_CANCEL_TRANSFER")
				&& !function_id.equals("OT_TO_BE_RESCHD_CASES")))
		{
			String siteFacilitySetUpSQL="";//MO-CRF-20106
			
			if(customer_id.equalsIgnoreCase("MOHBR")){			
			siteFacilitySetUpSQL = "SELECT NVL(MULTI_FACILITY,'N') MULTI_FACILITY FROM OT_PARAM_FOR_FACILITY " + 
											"WHERE EXISTS(" + OTRepository.getOTKeyValue("ALT_FAC_SITE_SETTING") + ") AND OPERATING_FACILITY_ID = ?";
			}else if(customer_id.equalsIgnoreCase("MOD")){		
			siteFacilitySetUpSQL = "SELECT NVL(MULTI_FACILITY,'N') MULTI_FACILITY FROM OT_PARAM_FOR_FACILITY " + 
											"WHERE EXISTS(" + OTRepository.getOTKeyValue("ALT_FAC_SITE_SETTING_MOD") + ") AND OPERATING_FACILITY_ID = ?";
			}
			
			pstmt = conn.prepareCall(siteFacilitySetUpSQL);
			pstmt.setString(1, facilityid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				multiFacility = rs.getString("MULTI_FACILITY");
			}
			
		
			if(rs!=null)	 
				rs.close();
			if(pstmt!=null)  
				pstmt.close();
		}

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg From DiarySheduleSearch.jsp"+e.getMessage());
	}finally{
		try{
			if(rs!=null)		rs.close();
			if(pstmt !=null)  pstmt.close();
			ConnectionManager.returnConnection(conn,request);
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
	}
%>


<table cellpadding=0 cellspacing="0" border="0" width="100%" align="center">
   <tr>
		<td class="label" width='25%' nowrap >
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<input name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='30' size='15' value="<%=strSpecialityDesc%>"  onBlur="if(this.value!='')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value='' "> 
			<input type='button' class='button' value='?' 
			name='spcButton' id='spcButton'  onClick="return searchSpeciality(SPECIALITY_DESC);clearSurgeon();"  >
		</td>
		<td class="label" align="left" width='25%' nowrap >
			<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<input name='SURGEON' id='SURGEON' maxlength='30' size='15' value= "<%=strSurgeonName%>"  onBlur="if(this.value!='')return searchSurgeon(SURGEON); else SURGEON_CODE.value='' " >
			<input type='button' class='button' value='?' 
			name='surButton' id='surButton' onClick="return searchSurgeon(SURGEON);" >
		</td>
	</tr>
	<tr>
		<td  class='label' width="25%" >
			<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> 
		</td>
		<td class='fields' width='25%'>
			<input type='text' name='PROCEDURE' id='PROCEDURE' maxlength='30' size='15' value= "" onBlur="if(this.value!='')return funOTCheckDetail1('Procedure','','<%=locale%>'); else oper_code.value='' " >
			<input type='button' name='probutton' id='probutton' class='button' value='?' onClick="return funOTCheckDetail1('Procedure','','<%=locale%>');" >
		</td>
		<td   class='label' width='25%'>
			<fmt:message key="eOT.FirstAvailableDate.Label" bundle="${ot_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<input type='checkbox' name='chkavilable' id='chkavilable' onClick="setFirstDate(this)">
		</td>
	</tr>

	<tr>
		<td  class='label' width='25%' > 
			<fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<input type='text' name='PREFERRED_DATE' id='PREFERRED_DATE' size='11'   value='<%=strPrefDate%>'  maxlength='10'  Onblur="javascript:isValidDate(this);" onkeypress="return checkForSpecCharsforID(event);">
			<img src="../../eCommon/images/CommonCalendar.gif"
			name='imagemonth' onClick="return showCalendar('PREFERRED_DATE','dd/mm/y');">
		</td>
		<td class='label' width='25%'>
			<fmt:message key="Common.PreferredMonth.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<input type='text' name='PREFERRED_MONTH' id='PREFERRED_MONTH' size='11'   value=''  maxlength='7' Onblur="javascript:isValidMonth(this);" onkeypress="return checkForSpecCharsforID(event);">
			<img src="../../eCommon/images/CommonCalendar.gif" 
			onClick="return showCalendar('PREFERRED_MONTH','mm/y');">
		</td>		
	</tr>
	<tr>
		<td class='label' width='25%'>
			<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<input name='theatre' id='theatre' maxlength='30' size='15' value= '' onBlur="if(this.value!='')return searchOTTheatre(theatre); else clearValues1(); ">
			<input type='button' class='button' value='?' 
			name='btn_theatre' id='btn_theatre' onClick="return searchOTTheatre(theatre);" >
		</td>		
		<td colspan='2' align='right' width='25%' >
			<input type="button" class="button" name="search" id="search" value="Search" onClick="validateAll();">
			<input type="button" class="button" name="clear" id="clear" value="Clear" 	onClick="funResetAll()">
<%
	if("Y".equals(multiFacility))
	{
%>	
			<input type="button" class="button" name="External Facility" id="External Facility" value='<fmt:message key="eOT.ExternalFacility.Label" bundle="${ot_labels}"/>' 
				onClick="javascript:bookExternalFacility()">
<%
	}
%>			
		</td>
	</tr>
</table>

   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<input type='hidden' name='SURGEON_CODE' id='SURGEON_CODE' value='<%=strSurgeonCode%>'>
<input type='hidden' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value="<%=strSpecialityCode%>">
<input type='hidden' name='room_code' id='room_code' value="">
<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>'%>
<input type='hidden' name='date_compare' id='date_compare' value='<%=preferedDate%>'>
<input type='hidden' name='sysdate' id='sysdate' value='<%=prefDate%>'>
<input type='hidden' name='month_compare' id='month_compare' value='<%=preferedMonth%>'>
<input type='hidden' name='orderid' id='orderid' value='<%=strOrderId%>'>
<input type='hidden' name='selOrderIds' id='selOrderIds' id='selOrderIds' value='<%=selOrderIds%>'> <%-- ChAiTu - 186 --%>
<input type='hidden' name='ammendFlag' id='ammendFlag' id='ammendFlag' value='<%=ammendFlag%>'> <%-- MMS-QH-CRF-186 --%>
<input type='hidden' name='booking_no' id='booking_no' value='<%=strBookingNo%>'>
<input type='hidden' name='startTime' id='startTime' value='<%=startTime%>'> <!-- 44528 - Chaitanya -->
<input type='hidden' name='endTime' id='endTime' value='<%=endTime%>'>
<input type='hidden' name='oper_code' id='oper_code' value='<%=strBookingNo%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='patientId' id='patientId' id='patientId' value="<%=patientId%>"> <%-- PMG2014-CRF-0024 --%>
<!-- Added by Suma for incident 19261 to sort order by surgeon or theatre in booking function 
 -->
<input type='hidden' name='diary_sched_for_surg_reqd_yn' id='diary_sched_for_surg_reqd_yn' value="<%=diary_sched_for_surg_reqd_yn%>">
<input type='hidden' name='fpp_category' id='fpp_category' value="<%=fpp_category%>"> <!--ML-MMOH-CRF-1939-US005-->

<!-- ends here
 -->
<script> funAutoSearch();</script>
</form>
</body>
</html>

