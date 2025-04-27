<!--Created by Ashwini on 06-May-2024 for ML-MMOH-CRF-2125-->
<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>

<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 

<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<script>

function submitPrevNext(from, to)
{
	document.forms[0].finalserviceList.value=parent.frames[0].serviceList;
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

</script>

<%
request.setCharacterEncoding("UTF-8");
request = new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
String finalserviceList = request.getParameter("finalserviceList");
String search_by = request.getParameter("search_by");
String search_txt = request.getParameter("search_txt");
if(finalserviceList == null) finalserviceList="";
if(search_by == null) search_by="";
if(search_txt == null) search_txt="";
search_txt = search_txt.replaceAll("\'","\'\'");
	
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=0;
 
if (from == null){ start = 0 ; } else { start = Integer.parseInt( from ) ; }
if (to == null){ end = 13; } else { end = Integer.parseInt( to ) ; }

Connection con=null;
PreparedStatement pstmt=null;
Statement stmt=null;
PreparedStatement stmtap=null;
ResultSet rs=null;
ResultSet rsap=null;
	
String unLinkserviceList = request.getParameter("unLinkserviceList");
String ServiceCodeList = "";
Statement ServiceCodeStmt = null;
ResultSet ServiceCoders = null ;

String facility_id=request.getParameter("facility_id");
if(facility_id == null) facility_id="";

String alphabet=request.getParameter("alphabet");
if( alphabet == null) alphabet="";

String splty_code=request.getParameter("splty_code");
if( splty_code == null) splty_code="";

String req_end= request.getParameter("totCount");
if(req_end == null) req_end="0";

if(search_by.equals("01"))
   search_by="service_code";
else if(search_by.equals("02"))
   search_by="short_desc";
	
try
{
con = ConnectionManager.getConnection(request);

String serviceSql=" Select A.service_code, B.short_desc, 'Y', 'Y', upper(short_desc) from am_service_for_speciality A, am_service B where   A.service_code = B. service_code and A.Facility_Id = '"+facility_id+"'and A.Speciality_Code = '"+splty_code+"' ";

if(!search_by.equals("") && !search_txt.equals(""))
	serviceSql=serviceSql+" and upper(B."+search_by+") like upper('"+search_txt+"%') "; 

serviceSql=serviceSql+" Union Select service_code, short_desc, 'N', 'N', upper(short_desc) from am_service where eff_status = 'E' ";

if(!search_by.equals("") && !search_txt.equals(""))
	 serviceSql=serviceSql+" and upper("+search_by+") like upper('"+search_txt+"%') ";

serviceSql=serviceSql+" and service_code not in (Select service_code from am_service_for_speciality where Speciality_Code = '"+splty_code+"' and Facility_id = '"+facility_id+"' ";

if(!search_by.equals("") && !search_txt.equals(""))
	serviceSql=serviceSql+" and upper("+search_by+")  like upper('"+search_txt+"%') "; 

serviceSql=serviceSql+" ) order by 5 ";

try {
	stmt = con.createStatement();
	rs = stmt.executeQuery(serviceSql);

	ServiceCodeStmt = con.createStatement();
	ServiceCoders = ServiceCodeStmt.executeQuery(serviceSql);

	while(ServiceCoders.next()){
		if(ServiceCoders.getString(4).substring(0,1).equals("Y")){
			ServiceCodeList = ServiceCoders.getString("service_code")+","+ServiceCodeList;	
		}
	}
} catch(Exception e) {
	e.printStackTrace();
}
%>

</head>

<body OnMouseDown="CodeArrest();" class='CONTENT' onKeyDown ='lockKey()'>
<form name='service_for_speciality_form' id='service_for_speciality_form' action='../../eAM/jsp/ServiceforSpecialityResult.jsp' method='post'>

<table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
<tr>
<td class="white">			
<table align='right'>
<tr>
<td>
<input type=hidden name=from id=from value='<%=start%>'>
<input type=hidden name=to id=to value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<%

if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}

while( i<end && rs.next() ){ 

if(maxRecord==0){

if ( !(start <= 1) ) {
%>
	<a href='javascript:submitPrevNext(<%=(start-13)%>,<%=(end-13)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
	<input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
}
%>
	<a href='javascript:submitPrevNext(<%=(start+13)%>,<%=(end+13)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<input type=hidden name='whichPage' id='whichPage' value='next'>

</td>
</tr>
</table>
<tr>
<td>
<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td class='columnheader' width='79%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>
<%  
}

String classValue="",str3="";
String chkAttribute="";String ServiceCode="";

ServiceCode=rs.getString("service_code");

if(rs.getString(4).substring(0,1).equals("Y"))
	chkAttribute="CHECKED";
else
	chkAttribute="";

if( i%2 == 0) 
	classValue="QRYEVEN";
else
	classValue="QRYODD";

str3 = rs.getString(3).substring(0,1);
%>

<tr>
	<td class='<%=classValue%>'><%=rs.getString(2)%></td>
	<td align='center' class='<%=classValue%>'><input type='hidden' name='enable<%=i%>' value='<%=ServiceCode%>$<%=rs.getString(3).substring(0,1)%>$<%=rs.getString(4).substring(0,1)%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>' onClick='parent.frames[0].changeEnable(this,enable<%=i%>,"<%=str3%>")' value='<%=rs.getString("service_code")%>' ></td>
</tr>

<% 
i++;  
maxRecord++;

}

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
<%}

if ( maxRecord < 13 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<%
} else {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<%
}

session.setAttribute("AXSRightRecSet", accessRightRecSet);
%>

</table>		
</td>
</tr>
</table>

<input type='hidden' name='splty_code' id='splty_code' value='<%=splty_code%>'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='finalserviceList' id='finalserviceList' value='<%=finalserviceList%>'>
<input type='hidden' name='unLinkserviceList' id='unLinkserviceList' value='<%=unLinkserviceList%>'>
<input type='hidden' name='checkedserviceList' id='checkedserviceList' value='<%=ServiceCodeList%>'>
<input type='hidden' name='totCount' id='totCount' value='<%=i%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>

</form>
</body>
</html>

<%	 

StringTokenizer steff=new StringTokenizer(finalserviceList,"~");
int cnt=steff.countTokens();

for(int u3=0;u3<cnt;u3++)
{
	String st4=steff.nextToken();
	StringTokenizer st5=new StringTokenizer(st4,"$");
	st5.nextToken();
	String status=st5.nextToken(); 
	st5.nextToken();
	String name=st5.nextToken(); 
	
	if(status.equals("Y"))
		out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=true;</script>");
	else
		out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=false;</script>");
}
}catch(Exception e){
	e.printStackTrace();
}finally{
try{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null)	pstmt.close();
	if(stmtap!=null) stmtap.close();
}catch(Exception e){
	e.printStackTrace();
}
ConnectionManager.returnConnection(con,request);
}
%>

