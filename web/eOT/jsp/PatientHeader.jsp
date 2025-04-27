<!DOCTYPE html>
<html>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,java.io.*, java.text.*,webbeans.eCommon.*" %>
<%@ page import ="java.text.SimpleDateFormat,java.util.Date" %>  

<head>
	<meta charset="utf-8" /> 
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link rel="stylesheet" href="../../eOT/html/disstyle.css" type="text/css" media="screen, projection" />
	<script>
function start()
{ 
	var time=new Date();
	//Added Start AAKH-SCF-0280 [IN060381]
	var date=time.getDate(); 
	date=((date < 10) ? "0" : "") + date; 
	var month = new Array();
	month[0] = "Jan";
	month[1] = "Feb";
	month[2] = "Mar";
	month[3] = "Apr";
	month[4] = "May";
	month[5] = "Jun";
	month[6] = "Jul";
	month[7] = "Aug";
	month[8] = "Sep";
	month[9] = "Oct";
	month[10] = "Nov";
	month[11] = "Dec";
	var mon = month[time.getMonth()];
	var year=time.getFullYear(); 
	// Added End AAKH-SCF-0280 [IN060381]
	var hours=time.getHours();
	var minutes=time.getMinutes();
	minutes=((minutes < 10) ? "0" : "") + minutes;
	var seconds=time.getSeconds();
	seconds=((seconds < 10) ? "0" : "") + seconds;
	var clock=hours + ":" + minutes + ":" + seconds; 
	var display = date + " " + mon + " " + year; // Added for AAKH-SCF-0280 [IN060381]
	document.getElementById('dateSpan').innerHTML ="";
	document.getElementById('timeDiv').innerHTML =clock;
	document.getElementById('dateDiv').innerHTML =display; // Added for AAKH-SCF-0280 [IN060381]
} 

</script> 
	
</head>

<%
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String) session.getAttribute( "facility_id" ) ;
	String p_user_name= (String) session.getAttribute( "login_user" ) ;	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	Date todaysDate = new Date();
	String formatedDate = dateFormat.format(todaysDate);
	String formatedTime = timeFormat.format(todaysDate);
    String minuteFormat = formatedTime.substring(0, formatedTime.lastIndexOf(':'));
    String secondFormat = formatedTime.substring(formatedTime.lastIndexOf(':')+1, formatedTime.length());
	String facility_name = "" ;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	Connection con=ConnectionManager.getConnection();
	pstmt=con.prepareStatement( "SELECT (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME,APPL_USER_NAME,APPL_USER_ID FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?" );
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,p_user_name);
			rset = pstmt.executeQuery();
			if(rset !=null)	{
				if(rset.next()) {
					facility_name = rset.getString("FACILITY_NAME");
				}
			}
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			ConnectionManager.returnConnection(con);
%> 
<body >

   <span id="dateSpan"></span>
	<div class="header" id="header">
			<div class="headerbg">
				<div class="datetimeslot" id="3">
						<div class="dateslot" id="4">
							<div class="sdate" id="dateDiv"> </div><!-- Modified for AAKH-SCF-0280 [IN060381] -->
						</div>
						<div class="timeslot" >
							<div class="timecenter" id="6">
								<div id="timeDiv" class="stime"> </div>
								<!--<div id="secDiv" class="smalltime">
									<div class="smtime">:</div>
								</div>-->
							</div>
						</div>
				</div>
			</div>
			<div class="screentitle" id="7">
			<%=facility_name%>
			</div>
		</div>
		
</body>
<script>
self.setInterval("start()",1000);
</script>
</html>