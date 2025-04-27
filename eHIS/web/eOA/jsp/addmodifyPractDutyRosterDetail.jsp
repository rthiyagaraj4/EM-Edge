<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper " %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOA/js/PractDutyRoster.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String locale = (String)session.getAttribute("LOCALE");

String P_facilityId = (String) session.getValue( "facility_id" ) ;
String P_locncode =request.getParameter("locn_code");

String P_carelocn =request.getParameter("carelocn");

String P_resource =request.getParameter("resource1");
String P_practid =request.getParameter("pract_id");
String P_days =request.getParameter("days");
String P_fromdt=request.getParameter("from_dt");
String P_todt=request.getParameter("to_dt");

P_fromdt=DateUtils.convertDate(P_fromdt,"DMY",locale,"en");
P_todt=DateUtils.convertDate(P_todt,"DMY",locale,"en");

String day[] = new String[7];
int i=0;
int k=0;
String classValue ="";
String P_date= "";
String P_date_disp= "";
String fnval = "insert";
day[0] = null;
day[1] = null;
day[2] = null;
day[3] = null;
day[4] = null;
day[5] = null;
day[6] = null;

String  O_date    	 ="";
String  O_day         ="";

StringTokenizer st = new StringTokenizer(P_days,"|");

while(st.hasMoreTokens()){
	day[i] = st.nextToken();
	i++;
}

%>

<body  OnMouseDown="CodeArrest() " onKeyDown = 'lockKey()'>
<form name='generate_date' id='generate_date' action='../../servlet/eOA.PractDutyRosterServlet' method='post' target='messageFrame'>

<%
Connection con = null;
CallableStatement cstmt = null;

try{
	con = ConnectionManager.getConnection(request);
	cstmt=con.prepareCall("{call OA_GENERATE_ROSTER_DATES( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );

	cstmt.setString( 1,	P_facilityId ) ;
	cstmt.setString( 2,	P_locncode ) ;
	cstmt.setString( 3,	P_practid);
	cstmt.setString( 4,	P_fromdt);
	cstmt.setString(5, P_todt);
	cstmt.setString( 6,	day[0]);
	cstmt.setString( 7,	day[1]);
	cstmt.setString( 8,	day[2]);
	cstmt.setString( 9,	day[3]);
	cstmt.setString( 10,	day[4]);
	cstmt.setString( 11,	day[5]);
	cstmt.setString( 12,	day[6]);
	cstmt.setString( 13, P_carelocn );
	cstmt.setString( 14, P_resource );
	cstmt.registerOutParameter(15,	Types.CLOB ) ;
	cstmt.registerOutParameter(16,	Types.CLOB) ;

	if(!(day[0]==null && day[1]==null && day[2]==null && day[3]==null  && day[4]==null &&day[5]==null &&day[6]==null ))	{  
		cstmt.execute() ;
		
		O_date=cstmt.getString( 15 );
		O_day =cstmt.getString( 16 );
		
		if(!(O_date == null || O_day ==null)){%>

			<table border='1' cellpadding='0' cellspacing='0' align='center' width='80%'>
			<td class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<%
			
			StringTokenizer str = new StringTokenizer(O_date,"|");
			StringTokenizer str1 = new StringTokenizer(O_day,"|");
			
			while(str.hasMoreTokens() && str1.hasMoreTokens())
			{

				String day_desc =str1.nextToken();

				day_desc=day_desc.trim();
				if(day_desc.equalsIgnoreCase("Monday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_desc.equalsIgnoreCase("Tuesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_desc.equalsIgnoreCase("Wednesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_desc.equalsIgnoreCase("Thursday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_desc.equalsIgnoreCase("Friday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_desc.equalsIgnoreCase("Saturday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_desc.equalsIgnoreCase("Sunday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


				if ( k % 2==0 )
						classValue = "QRYODD" ;
				else
						classValue = "QRYEVEN" ;

				P_date = str.nextToken();

				P_date_disp=DateUtils.convertDate(P_date,"DMY","en",locale);
				%>
				<tr><td width='30%' align='center' class='<%=classValue%>'><%=P_date_disp%></font></td>
				<td width='30%' align='left' class='<%=classValue%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=day_desc%></font></td>
				<td width='20%' align='center' class='<%=classValue%>'> <input type='checkbox' name='select_date' id='select_date' value='<%=P_date%>' checked></td> </tr>
				<%
				k++;
			}
		}else{%>
			<script>
			var error=getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
			alert(error);
			parent.frames[0].document.forms[0].checkdtlframe.value='NO';
			</script>
			<%
		}
	}
	%>
	<script>parent.frames[0].document.forms[0].checkdtlframe.value='YES';
	</script>
	<%
	if(cstmt != null) cstmt.close();

}catch(Exception e){
	//out.print(e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='noofrec' id='noofrec' value='<%=k%>' >
<input type='hidden' name='on_duty_date' id='on_duty_date' value='' >
<input type='hidden' name='clinic_code' id='clinic_code' value='<%=P_locncode%>' >
<input type='hidden' name='resourcek' id='resourcek' value='<%=P_resource%>' >
<input type='hidden' name='carelocnk' id='carelocnk' value='<%=P_carelocn%>' >
<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=P_practid%>' >
<input type='hidden' name='function' id='function' value='<%=fnval%>'>
<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
</form>
</body>
</html>

