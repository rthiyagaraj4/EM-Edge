<!DOCTYPE html>
<%@ page import ="java.sql.*,ecis.utils.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	//String p_user_name		= (String) session.getValue( "login_user" );
	String p_language_id		= (String) session.getValue( "LOCALE" );
	String p_module_id=checkForNull(request.getParameter("p_module_id"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String encounter_id=checkForNull(request.getParameter("encounter_id"));
	//String location_desc=checkForNull(request.getParameter("location_desc"));
	String White=request.getParameter("White")==null?"N":request.getParameter("White");
	String Blue=request.getParameter("Blue")==null?"N":request.getParameter("Blue");
	String Red=request.getParameter("Red")==null?"N":request.getParameter("Red");
	String noofcopies=checkForNull(request.getParameter("copies"));
	//String req_yn=checkForNull(request.getParameter("req_yn"));	
	String result="";
	Connection con = null;
	ResultSet rSet=null;
	CallableStatement cs  = null;
	PreparedStatement pstmt=null;
	String message1 ="";
	String message2 ="";
	String message3 ="";
	String care_locn_type="";
	String care_locn_code="";
	/*Changes for 37658 - Begin*/
	String rep_server_key1="";
	String rep_server_key2="";
	String rep_server_key3="";
	/*Changes for 37658 - End*/
%>
<%
try{
OnlineReport report1=null;
OnlineReport report2=null;
OnlineReport report3=null;
OnlineReports onlinereports=new OnlineReports();
con = ConnectionManager.getConnection(request);
Boolean flag=true;
String pr_encounter_SQL="select facility_id,assign_care_locn_type,assign_care_locn_code from pr_encounter where facility_id=? and encounter_id=?";
	pstmt=con.prepareStatement(pr_encounter_SQL);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,encounter_id);
	rSet=pstmt.executeQuery();
	if(rSet!=null && rSet.next()){
		p_facility_id=rSet.getString("facility_id");
		care_locn_type=rSet.getString("assign_care_locn_type");
		care_locn_code=rSet.getString("assign_care_locn_code");
	}
if(White.equals("Y")){
	/*report=new OnlineReport(p_facility_id,p_module_id,"IPBWBLBW","N","CICU");
	report.addParameter("p_facility_id",p_facility_id);
	report.addParameter("p_module_id",p_module_id);
	report.addParameter("p_language_id",p_language_id);
	report.addParameter("p_report_id","IPBWBLBW");
	report.addParameter("copies",noofcopies);
	report.addParameter("p_patient_id",patient_id);
	report.addParameter("p_encounter_id",encounter_id);
	onlinereports.add(report);*/
	cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//changes for 37658
	cs.setString( 1,    "IP" ) ;
	cs.setString( 2,    "IPBWBLBW" ) ;
	cs.setString( 3,    care_locn_type ) ;
	cs.setString( 4,    care_locn_code ) ;
	cs.setString( 5,    p_facility_id ) ;
	cs.setString( 6,    noofcopies ) ;
	cs.setString( 7,    "P" ) ;
	cs.registerOutParameter( 8,  Types.VARCHAR ) ;
	cs.registerOutParameter( 9,  Types.VARCHAR ) ;
	cs.registerOutParameter( 10, Types.VARCHAR ) ;
	cs.registerOutParameter( 11, Types.VARCHAR ) ;
	cs.registerOutParameter( 12, Types.VARCHAR ) ;
	cs.registerOutParameter( 13, Types.VARCHAR ) ;
	cs.registerOutParameter( 14, Types.VARCHAR ) ;
	cs.registerOutParameter( 15, Types.VARCHAR ) ;
	cs.registerOutParameter( 16, Types.VARCHAR ) ;
	cs.registerOutParameter( 17, Types.VARCHAR ) ;
	cs.execute() ;
	message1=cs.getString( 15 ) ;
	rep_server_key1=cs.getString( 17 ) ;//changes for 37658
	if(message1==null){
		report1 = new OnlineReport(p_facility_id,"IP","IPBWBLBW",care_locn_type,care_locn_code);
		report1.addParameter("p_facility_id",p_facility_id);
		report1.addParameter("p_report_id","IPBWBLBW");
		report1.addParameter("p_module_id",p_module_id);
		report1.addParameter("copies",noofcopies);
		report1.addParameter("p_language_id",p_language_id);
		report1.addParameter("p_encounter_id",encounter_id);
		report1.addParameter("p_facility_id",p_facility_id);
		report1.addParameter("p_patient_id",patient_id);
		onlinereports.add(report1);
	}else if(!message1.equals("")){

		

	}
}

if(Blue.equals("Y")){
	System.err.println("Calling report_routing in IPPrintPatientWristbandReport.jsp in line 113");
	cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//changes for 37658
	cs.setString( 1,    "IP" ) ;
	cs.setString( 2,    "IPBWBLBB" ) ;
	cs.setString( 3,    care_locn_type ) ;
	cs.setString( 4,    care_locn_code ) ;
	cs.setString( 5,    p_facility_id ) ;
	cs.setString( 6,    noofcopies ) ;
	cs.setString( 7,    "P" ) ;
	cs.registerOutParameter( 8,  Types.VARCHAR ) ;
	cs.registerOutParameter( 9,  Types.VARCHAR ) ;
	cs.registerOutParameter( 10, Types.VARCHAR ) ;
	cs.registerOutParameter( 11, Types.VARCHAR ) ;
	cs.registerOutParameter( 12, Types.VARCHAR ) ;
	cs.registerOutParameter( 13, Types.VARCHAR ) ;
	cs.registerOutParameter( 14, Types.VARCHAR ) ;
	cs.registerOutParameter( 15, Types.VARCHAR ) ;
	cs.registerOutParameter( 16, Types.VARCHAR ) ;
	cs.registerOutParameter( 17, Types.VARCHAR ) ;
	cs.execute() ;
	message2=cs.getString( 15 ) ;
	rep_server_key2=cs.getString( 17 ) ;//changes for 37658
	if(message2==null){
		report2 = new OnlineReport(p_facility_id,"IP","IPBWBLBB",care_locn_type,care_locn_code);
		report2.addParameter("p_facility_id",p_facility_id);
		report2.addParameter("p_report_id","IPBWBLBB");
		report2.addParameter("p_module_id",p_module_id);
		report2.addParameter("copies",noofcopies);
		report2.addParameter("p_language_id",p_language_id);
		report2.addParameter("p_encounter_id",encounter_id);
		report2.addParameter("p_facility_id",p_facility_id);
		report2.addParameter("p_patient_id",patient_id);
		onlinereports.add(report2);
	}else if(!message2.equals("")){

		

	}
}
if(Red.equals("Y")){
	cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//changes for 37658
	cs.setString( 1,    "IP" ) ;
	cs.setString( 2,    "IPBWBLBR" ) ;
	cs.setString( 3,    care_locn_type) ;
	cs.setString( 4,    care_locn_code ) ;
	cs.setString( 5,    p_facility_id ) ;
	cs.setString( 6,    noofcopies ) ;
	cs.setString( 7,    "P" ) ;
	cs.registerOutParameter( 8,  Types.VARCHAR ) ;
	cs.registerOutParameter( 9,  Types.VARCHAR ) ;
	cs.registerOutParameter( 10, Types.VARCHAR ) ;
	cs.registerOutParameter( 11, Types.VARCHAR ) ;
	cs.registerOutParameter( 12, Types.VARCHAR ) ;
	cs.registerOutParameter( 13, Types.VARCHAR ) ;
	cs.registerOutParameter( 14, Types.VARCHAR ) ;
	cs.registerOutParameter( 15, Types.VARCHAR ) ;
	cs.registerOutParameter( 16, Types.VARCHAR ) ;
	cs.registerOutParameter( 17, Types.VARCHAR ) ;
	cs.execute() ;
	message3=cs.getString( 15 ) ;
	rep_server_key3=cs.getString( 17 ) ;//changes for 37658
	if(message3==null){
		report3 = new OnlineReport(p_facility_id,"IP","IPBWBLBR",care_locn_type,care_locn_code);
		report3.addParameter("p_facility_id",p_facility_id);
		report3.addParameter("p_report_id","IPBWBLBR");
		report3.addParameter("p_module_id",p_module_id);
		report3.addParameter("copies",noofcopies);
		report3.addParameter("p_language_id",p_language_id);
		report3.addParameter("p_encounter_id",encounter_id);
		report3.addParameter("p_facility_id",p_facility_id);
		report3.addParameter("p_patient_id",patient_id);
		onlinereports.add(report3);
	}else if(!message3.equals("")){

		

	}
}
%>
<input type='hidden' name='rep_server_key1' id='rep_server_key1' value="<%=rep_server_key1%>">	<!--IN037658-->
<input type='hidden' name='rep_server_key2' id='rep_server_key2' value="<%=rep_server_key2%>">	<!--IN037658-->
<input type='hidden' name='rep_server_key3' id='rep_server_key3' value="<%=rep_server_key3%>">	<!--IN037658-->
<%
if(White.equals("Y") && flag){
	if(message1!=null){
		flag=false;
	}
}
if(Blue.equals("Y") && flag){
	if(message2!=null){
		flag=false;
	}
}
if(Red.equals("Y") && flag){
	if(message3!=null){
		flag=false;
	}
}
if(flag){
	result=onlinereports.execute(request,response);
	%>
	<Script>
		var msg=getMessage('REPORT_SUBMIT_SERVER','Common');
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	</script>
<%}else{
	%>	
	<script>
		var msg=getMessage('REPORT_RULE_NOT_DEFINED','Common');
		//alert(msg)
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	</script>
<%}
}catch(Exception e){
	out.println(e);
	e.printStackTrace();
}finally{
	if(rSet!=null)rSet.close();
	if(pstmt!=null)pstmt.close();
	if(cs!=null)cs.close();
	if(con!=null) ConnectionManager.returnConnection(con,request); 
}
%>
<%!
	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>

