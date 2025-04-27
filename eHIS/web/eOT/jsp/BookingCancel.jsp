<!DOCTYPE html>
 <%@ page import ="java.util.*,java.text.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,java.util.Properties,eOT.Common.OTRepository,java.util.regex.Pattern,java.util.regex.PatternSyntaxException" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");

%>
<html>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<head>
	<title> <fmt:message key="eOT.BookingWindow.Label" bundle="${ot_labels}"/></title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script type="text/javascript">
	reschedule_value=getLabel("Common.Reschedule.label","common");
	reason_value=getLabel("Common.reason.label","common");
	transfer_value=getLabel("Common.Transfer.label","common");
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<form name='PreOperHdr' id='PreOperHdr' >
<%
	Properties p= (Properties)session.getValue("jdbc");
	String login_user=""+p.getProperty("login_user");
	String flag=checkForNull(request.getParameter("transfer"));
	int choice = (!flag.equals(""))?Integer.parseInt(flag):0;
	String strOrderId=checkForNull(request.getParameter("orderid"));
	String strCancelFlag=checkForNull(request.getParameter("cancel_flag"));
	String strBookingNum=checkForNull(request.getParameter("booking_no"));
	String startTime = checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	String endTime = checkForNull(request.getParameter("endTime"));
	String start_time = checkForNull(request.getParameter("start_time"));
	String timeDifference = checkForNull(request.getParameter("timeDifference"));
	String newTime = "";
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		if(start_time != null && start_time.trim().length() > 0 && timeDifference !="") // condition Added for IN:45296 //added against 54761		
		{
			Date d = df.parse(start_time);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.MINUTE, Integer.parseInt(timeDifference));	
			newTime = df.format(cal.getTime());
		}
	String strFacilityId=checkForNull(request.getParameter("facility_id"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String roomDesc = checkForNull(request.getParameter("roomDesc"));
	String over_booking_case_yn=checkForNull(request.getParameter("over_booking_case_yn"));
    over_booking_case_yn=over_booking_case_yn==null?"N":over_booking_case_yn;
    over_booking_case_yn=over_booking_case_yn.equals("null")?"N":over_booking_case_yn;
    over_booking_case_yn=over_booking_case_yn.equals("")?"N":over_booking_case_yn;
	String function_id=request.getParameter("function_id");
	String disable_flag=("BookingQry".equals(called_from))?"disabled":"";
	String func_role_id="",inform_date="",inform_time="",cancel_remarks="",checked_yn="",strUser="",strSysDate="",strHead="",strLabel="",strReasonDesc="",inform_date_time="",sql_cur_date="",dt_time="",sql="";	
	String[] dateArr= null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;		
	ResultSet rs1=null;		
	String strStatus = "";
	int range = 0;
	Pattern Regex = null;
if("BookingQry".equals(called_from) || "CancelTransfer".equals(called_from)){
	%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<%}
		switch(choice){
		case 0: 
				strHead=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancellationDetails.label","common_labels");	
				strLabel=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelledby.label","common_labels");		
				break;
		case 1: 
				strHead=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TransferDetails.Label","ot_labels");
				strLabel=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferredBy.label","common_labels");
				break;
		case 6: 
				strHead=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MarkforReschedule.Label","ot_labels");
				strLabel=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RescheduledBy.Label","ot_labels");
				break;
		
	}
	try{
		 Regex = Pattern.compile("\\s",Pattern.CANON_EQ | Pattern.MULTILINE);
	}catch (PatternSyntaxException ex) {
		System.err.println("Err in Regular Expression from BookingCancel.jsp-->"+ex);
	}
	try{
				conn = ConnectionManager.getConnection(request);
				sql_cur_date=OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1");		
				pstmt=conn.prepareStatement(sql_cur_date);
				rs=pstmt.executeQuery();
				if(rs.next()){
					dt_time=checkForNull(rs.getString("DATE_TIME"));
				}
				rs.close();
				pstmt.close();



		// Modified by DhanasekarV agianist issue 26661  on 03/05/2011
		if("BookingQry".equals(called_from)==true)
				{
			
						sql = "SELECT NVL(B.ORDER_STATUS,'X') ORDERSTATUS FROM OT_BOOKING_HDR A,OR_ORDER B WHERE A.BOOKING_NUM = ?	AND B.ORDER_ID  = NVL(A.ORDER_ID,'X') AND A.OPERATING_FACILITY_ID =? " ;

						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1,strBookingNum);
						pstmt.setString(2,strFacilityId);
						rs=pstmt.executeQuery();
						if(rs.next()){
						strStatus=checkForNull(rs.getString("ORDERSTATUS"));
						
						}
						rs.close();
						pstmt.close();
				 }
		//END 26661



			 
		if(strCancelFlag.equals("1")==true){
			sql="SELECT CANCELLED_BY CANCELLED_BY1,TO_CHAR(CANCELLATION_DATE,'DD/MM/YYYY HH24:MI')  CANCELLATION_DATE1,(SELECT REASON_DESC FROM OT_REASONS_LANG_VW RV WHERE LANGUAGE_ID = V.LANGUAGE_ID AND RV.REASON_CODE = R.REASON_CODE) REASON_DESC1,WARD_INFORMED_YN, TO_CHAR(WARD_INFORMED_TIME,'DD/MM/YYYY HH24:MI') INFORMED_TIME,CANCELLED_REMARKS REMRKS,TO_CHAR(V.ADDED_DATE,'DD/MM/YYYY HH24:MI') BOOKED_DATE FROM OT_BOOKINGS_VW V,OT_REASONS R WHERE NVL(R.STATUS,'E')='E' AND R.REASON_CODE IN (SELECT REASON_CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE = 'CA' AND NVL(ACTIVE_YN,'N') = 'Y') AND V.OPERATING_FACILITY_ID=? AND V.BOOKING_NUM=? AND V.CANCEL_REASON_CODE=R.REASON_CODE AND V.LANGUAGE_ID='"+locale+"' ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,strFacilityId);
			pstmt.setString(2,strBookingNum);
			rs=pstmt.executeQuery();
			if(rs.next()){
				strUser=checkForNull(rs.getString("CANCELLED_BY1"));
				strSysDate=checkForNull(rs.getString("CANCELLATION_DATE1"));
				strReasonDesc=checkForNull(rs.getString("reason_desc1"));
				checked_yn = checkForNull(rs.getString("WARD_INFORMED_YN"));
				checked_yn=("Y".equals(checked_yn))?"checked":"";
				inform_date_time = checkForNull(rs.getString("INFORMED_TIME"));	
				cancel_remarks = checkForNull(rs.getString("REMRKS"));
				range = inform_date_time.trim().length();
				//Modified by DhanasekarV aginst 26661 on 21/11/2011	
				if (inform_date_time != null && inform_date_time.length()>0)
				{
				dateArr = Regex.split(inform_date_time,range);				
				inform_date =dateArr[0];
				inform_time = dateArr[1];
				}
				else 
				{
					inform_date ="";
					inform_time="";
				}

			}
			rs.close();
			pstmt.close();
		
	    }else{
				//Commented and added below query for 24448 on 10/18/2010 by ANithaJ
				//sql=OTRepository.getOTKeyValue("SQL_OT_BOOKINGCANCEL_SELECT1");		
				sql="select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ?";		
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,login_user);
				pstmt.setString(2,locale);
				rs=pstmt.executeQuery();
				if(rs.next()){
					strUser=checkForNull(rs.getString("func_role_id"));					
					//strSysDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMYHM","en",locale);
				}
				rs.close();
				pstmt.close();
			  //Commented below query for 24448 on 10/18/2010 by ANithaJ
			  //String sql1="SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = ?";
			  //strUser="";
			  //strUser=func_role_id; END	
		  	// Modified by DhanasekarV against issue IN026658 on 29/04/2011		
			strSysDate	= dt_time;		   
		   }
		// Modified by DhanasekarV against issue IN026658 on 29/04/2011		
		   strSysDate = com.ehis.util.DateUtils.convertDate(strSysDate,"DMYHM","en",locale);
		    //Added below query for 24448 by AnithaJ on 10/18/2010  START
  			  String sql1="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW where LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID=?";

			   pstmt1=conn.prepareStatement(sql1);
			   //pstmt1.setString(1,login_user);Anitha
			   pstmt1.setString(1,strUser);
			   rs1=pstmt1.executeQuery();
				if(rs1.next()){
					func_role_id=checkForNull(rs1.getString("SHORT_NAME1"));
				}
			//END
		}catch(Exception e){
			System.err.println("Exception in BookingProcedureDtl.jsp===="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			if(conn !=null) ConnectionManager.returnConnection(conn,request);
		}
%>


<table border="1" cellpadding=3 cellspacing="0" width="100%" align='center'>
<tr> 
	<th class='columnheader' ><%=strHead%></th>
</tr>
</table>

<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
<%if("".equals(called_from) && !("6").equals(flag)){%>
<tr>
     <td class='label' width="25%" ><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></td>
	<td  class='fields' width="25%" >
		<input type='text' class='fields' name='transfer_to' id='transfer_to' size='30'   value='<%=roomDesc%>' disabled>
	</td>
</tr>
<%}%>
<tr>
	<td class='label' width="25%" ><%=strLabel%></td>
	<td  class='fields' width="25%" >
		<input type='text' class='fields' name='cancel_by1' id='cancel_by1' size='30'   value='<%=func_role_id%>' disabled>
		<!-- Added cancel_by hidden field by AnithaJ for 24448 on 10/18/2010-->
		<input type='hidden' name='cancel_by' id='cancel_by' value='<%=strUser%>'>
	</td>
	<td class='label' width="25%">
		<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%">
		<input type='text' class='fields' name='cancel_date' id='cancel_date' size='15'   value='<%=strSysDate%>' disabled>
	</td>
</tr>

<tr>
	<td class='label' width="25%"   >
		<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%"  colspan="3">
	<%
	if(flag.equals("6")){%>
		<input type='text' name='reason_desc' id='reason_desc' size='80'  class='fields' width="25%" onblur="if(this.value!='')callOnBlurReshedule(this,reschedule_value,'<%=locale%>');" value="" >
		<input type='hidden' name='reason_code' id='reason_code' value="">
		<input type='button' class='button' name='quest1' id='quest1' value='?' onClick="funOTCheckDetail1('Reshedule',reschedule_value,'<%=locale%>')">
		<img src='../../eCommon/images/mandatory.gif'>
		</img>
	</td>
	<%}else if(flag.equals("1")){%>
		<input type='text' name='reason_desc' id='reason_desc' size='80' align='right'  value="" onblur="if(this.value!='')callOnBlurReasonCode(this,transfer_value,'<%=locale%>');">
		<input type='hidden' name='reason_code' id='reason_code' value="">
		<input type='button' class='button' name='quest1' id='quest1' value='?' onClick="funOTCheckDetail1('Transfer',transfer_value,'<%=locale%>')">
		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	<%}else{%>
		<input type='text' name='reason_desc' id='reason_desc' size='80'  align='right'  value="<%=strReasonDesc%>" onblur="if(this.value!='')callOnBlurReasonCode(this,reschedule_value,'<%=locale%>');">
		<input type='hidden' name='reason_code' id='reason_code' value="">
	<%if(strCancelFlag.equals("1")==false){%>
		<input type='button' class='button' name='quest1' id='quest1' value='?' onClick="funOTCheckDetail1('Reason',reason_value,'<%=locale%>')">
		<img src='../../eCommon/images/mandatory.gif'>
		</img>
	<%}%>
	</td>
	</tr>
	
	
	<tr>
		<td class='label' width="25%">
			<fmt:message key="eOT.CancelOrder.Label" bundle="${ot_labels}"/>
		</td>
		<td class='fields' width="25%" colspan="3">
		<%
		//System.out.println("eOT strOrderId  "+strOrderId);
			if(strOrderId.length()==0){	
		// Modified by DhanasekarV agianist issue 26661  on 03/05/2011			
	
			if(strStatus.equals("OS")==true)
			out.println("<input type=checkbox name='cancelorder' id='cancelorder' disabled>");
			else
				out.println("<input type=checkbox name='cancelorder' id='cancelorder' checked disabled>");	
			}else{
				out.println("<input type=checkbox name='cancelorder' id='cancelorder'>");
			}
		}%>
		</td>
		</tr>
		
	<% if("BookingQry".equals(called_from) || "CancelTransfer".equals(called_from)){ %>
		<tr>
		<td class='label' width="25%">
			<fmt:message key="eOT.InformedWard.Label" bundle="${ot_labels}"/>
		</td>
		<td class='fields' width="25%">
			<input type="checkbox" name="ward_informed_yn" id="ward_informed_yn" onclick="checkWardInformedYN();" <%=checked_yn%> <%=disable_flag%> >
		</td>
	<td class='label' width="25%">
			<fmt:message key="eOT.InformedWard.Label" bundle="${ot_labels}"/>
			<fmt:message key="Common.date.label" bundle="${common_labels}"/>
	</td>

	<td class='fields' width="25%">
		<input type='text' name='inform_date' id='inform_date' size='8' value='<%=inform_date%>' maxlength='10' onBlur="isValidDate(this);"  disabled >
		<input type='text' name='inform_time' id='inform_time' size='2' value='<%=inform_time%>' maxlength='5' onBlur="isValidTime(this);" disabled>
		<img type='image' id="img1" src="../../eCommon/images/Blank1.gif"></img>
		</td>		
</tr>	
<tr>
	<td class='label' width="25%" >
		<fmt:message key="Common.CancelRemarks.label" bundle="${common_labels}"/> 
	</td>
	<td class='fields' width="25%" colspan="3" >
		<input type="text" name="cancelled_remarks" id="cancelled_remarks" maxlength='80' size='80' value="<%=cancel_remarks%>" disabled>
		<img type='image' id="img2" src="../../eCommon/images/Blank1.gif"></img>
		<img type='image' id="img3" src="../../eCommon/images/Blank1.gif"></img>

	</td>
</tr>
	<%}%>
</table>
<input type='hidden' name='orderid' id='orderid' value='<%=strOrderId%>'>
<input type='hidden' name='booking_num' id='booking_num' value='<%=strBookingNum%>'>
<input type='hidden' name='startTime' id='startTime' value='<%=startTime%>'> <!-- 44528 - Chaitanya -->
<input type='hidden' name='endTime' id='endTime' value='<%=endTime%>'>
<input type='hidden' name='start_time' id='start_time' value='<%=start_time%>'>
<input type='hidden' name='newTime' id='newTime' value='<%=newTime%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=strFacilityId%>'>
<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='dt_time' id='dt_time' value="<%=dt_time%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='over_booking_case_yn' id='over_booking_case_yn' value="<%=over_booking_case_yn%>"> <!-- added By Yadav Icn 13718 -->
</form>
</BODY>
</HTML>




