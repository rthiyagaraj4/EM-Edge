<!DOCTYPE html>
<!--JSP Created Against AAKH-CRF-0113.3-->

<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@ page import="java.sql.*,java.util.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.*"  contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");		
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt5 = null; 
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt3 = null;
	
	ResultSet rs =null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs5 = null;
	ResultSet rs4 = null;
	ResultSet rs3 = null;
	
	String locale="";	
	String classval="";
	
	String interface_values = "";
	String speciality_desc = "";
	String facility_id = "";
	String patient_id = "";
	String patient_name = "";
	String encrypted_yn = "";
	String episode_type = "";
	String episode_id = "";
	String visit_id = "";
	String encounter_id = ""; 
	String doc_type_code = "";
	String doc_num = "";
//	String num_of_reports="";	//checklist
	String date_of_birth="";	
	String gender="";	
	String doc_date="";	
	String bill_amt="";	
	String file_path="";	 
	 
//	HttpSession httpSession = request.getSession(false);//checklist
	con =  ConnectionManager.getConnection(request);
	String jdbc_username="";
	String jdbc_password="";
	String jdbc_dns="";
	String jdbc_driver="";
	String login_app_user="";
	String login_id = System.getProperty("user.name");
	String client_ip_address = request.getRemoteAddr();
	//String locale=""	;
	try
	{	
		String paramString = request.getQueryString();		
		String interface_query = "SELECT PARAM_STRING FROM XH_EXTERNAL_CALL WHERE INT_SHORT_ID='"+paramString+"'";
		
		pstmt2 = con.prepareStatement(interface_query);		
		rs2 = pstmt2.executeQuery();		
		if(rs2 != null)
		{
			while(rs2.next()){
				interface_values = rs2.getString(1);
		}
		}
		//interface_values = "facility_id=AK&patient_id=0000008&encounter_id=100056190001&encrypted=Y";
		String[] interface_Arrvalues = interface_values.split("&");
		facility_id=interface_Arrvalues[0].substring(interface_Arrvalues[0].indexOf("=")+1);
		patient_id=interface_Arrvalues[1].substring(interface_Arrvalues[1].indexOf("=")+1);
		encounter_id=interface_Arrvalues[2].substring(interface_Arrvalues[2].indexOf("=")+1);
		encrypted_yn=interface_Arrvalues[3].substring(interface_Arrvalues[3].indexOf("=")+1);
		//con =  ConnectionManager.getConnection(request);	
		String sql = "select app_password.decrypt(appl_user_password),language_id from sm_appl_user where appl_user_id = ?";
		String sql1="select USER_ID,app_password.decrypt(password),CONNECT_STRING,DB_DRIVER  from sm_db_info" ;
			
		pstmt=con.prepareStatement(sql);
		pstmt1=con.prepareStatement(sql1);
		pstmt.setString(1,login_id);
		
		rs=	pstmt.executeQuery();
		rs1=pstmt1.executeQuery();
		while(rs.next()) 
		{
			login_app_user	=rs.getString(1);	
			locale	=rs.getString(2);	
		}
		while(rs1.next())
		{
			jdbc_username	=rs1.getString(1);	
			jdbc_password	=rs1.getString(2);
			jdbc_dns	=rs1.getString(3);
			jdbc_driver =rs1.getString(4);	
		}
		
		}
		catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				/* if (con != null) {
					ConnectionManager.returnConnection(con);
				} */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		//String jdbc_props = "";
		session.putValue("facility_id",facility_id);
		session.putValue("login_user",login_app_user);
		session.putValue("connection_pooling_yn","Y");
		session.putValue("LOCALE","en");
		session.putValue("PREFERRED_STYLE","IeStyle.css");
		
		Properties p = new Properties();
		
		p.setProperty( "login_user",login_app_user);
		//p.setProperty("login_pwd",strLogged_app_password);
		p.setProperty("connection_pooling_yn","Y") ;
		//p.setProperty("client_ip_address","CSCINDAE751724");
		p.setProperty("client_ip_address",client_ip_address);
		p.setProperty("strLogged_dns",jdbc_dns);
		p.setProperty("strLogged_driver",jdbc_driver) ;
		p.setProperty("ecis_jdbc_user",jdbc_username);
		p.setProperty("ecis_jdbc_password",jdbc_password);
		session.putValue( "jdbc",p );
%>

<%!
	private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}

public String billingFormatConverter(Connection con, String amount) {	
	PreparedStatement pstmt_dec = null;
	ResultSet rs_dec = null;
	int noofdecimal = 2;
	try {	
		pstmt_dec = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
		rs_dec = pstmt_dec.executeQuery();
		if (rs_dec.next() && rs_dec != null)
			noofdecimal = rs_dec.getInt(1);
		if (rs_dec != null)
			rs_dec.close();
		if (pstmt_dec != null)
			pstmt_dec.close();
		if (amount == null || "".equals(amount)) {
			amount = "0.00";
		} else {
			CurrencyFormat cf = new CurrencyFormat();
			amount = cf.formatCurrency(amount, noofdecimal);
		}
	} catch (Exception e) {
		System.out.println("Exception Getting Number of Decimals. " + e.toString());
		e.printStackTrace();
	}
	return amount;
}
%>

<HTML>
	<HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<script language='javascript' src='../js/BLReprintReport.js'></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language='javascript' src='../js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<style>
.div1 {
	 display: block;
	margin-left: auto;
  margin-right: auto;
  width: 100%;
  height: 100%;
 border-style: double;
  padding: 100px;  
}
TD.GREEN  
		{			
			BACKGROUND-COLOR: D1FAC1 ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalGreen
		{
			COLOR:#444444;
			BACKGROUND-COLOR: D1FAC1 ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}
SPAN.SpanGreen
		{
			COLOR:#444444;
			BACKGROUND-COLOR: D1FAC1 ;
			FONT-SIZE: 8pt ;
			/* PADDING-LEFT:7px;
  			PADDING-RIGHT:7px */
		}

</style>
</HEAD>

<script>		
function highlightRow1(obj,qryClass){
	var frm =  document.resultForm;
	var rowClicked = frm.rowClicked.value;
	if(rowClicked != obj){
		if(rowClicked.length>0){
			$('#row'+rowClicked+' td' ).each(function(){
				$(this).attr('class','label');
			});	
			
			$('#row'+rowClicked+' td span' ).each(function(){
				$(this).attr('class','LABEL');
			});	
		}	
		
		$('#row'+obj+' td' ).each(function(){
			$(this).attr('class','LocalGreen');			
		});
		
		$('#row'+obj+' td span' ).each(function(){
			$(this).attr('class','SpanGreen');
		});	
		}
	frm.rowClicked.value = obj;
}
	
function interfaceReports(indx)
{
	var docTypeCode  = document.getElementById("doc_typ_code"+indx).value;
	var docNum = document.getElementById("doc_num"+indx).value;
	var patientId = document.getElementById("patient_id"+indx).value;
	var episodeType = document.getElementById("episode_type"+indx).value;
	var episodeId = document.getElementById("episode_id"+indx).value;
	var facility_id = document.getElementById("facility_id").value;
	var visitId = document.getElementById("visit_id"+indx).value;
	var locale = document.getElementById("locale").value;
	var login_user =$('#login_user').val();
	
	var p_report_id="BLRBLPRT";
	var  p_module_id = "BL" ;
	var detailed_yn ='Y';
	$.ajax({
		type:"GET",
		url:"../jsp/BLCommonReportValidation.jsp",
		data:"func_mode=ReprintReport &p_report_id="+p_report_id+
			"&param1="+docTypeCode+
			"&param2="+docTypeCode+
			"&param3="+docNum+
			"&param4="+docNum+
			"&param5="+

			"&param6="+detailed_yn+
			"&param7="+"R"+
			"&param8="+locale+
			"&param9="+
			"&param10="+
			
			"&param11="+
			"&param12="+
			"&param13="+
			"&param14="+episodeType,
		dataType:"text",
		async:false,
		success: function(data){
			var dummyDoc = parent.parent.dummyFrame.document;
			var retVal = trimString(data).split(":::");
			var session_id = '';
			var pgm_date = '';
			if(retVal.length == 2){
				session_id = retVal[0];
				pgm_date = retVal[1];
			}
			var htmlVal = "<html><body>";
			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eBL/jsp/InterfaceReports.jsp' >";
			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facility_id+"'>";
			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+p_report_id+"'>";
			
			htmlVal += "</form></body></html>";
			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
			dummyDoc.dummy_frm.submit();
			},
			 error: function(data){
		  }
	});
}
</script>

<%
 try
 { 
	String patient_details = "SELECT patient_name,TO_CHAR (date_of_birth, 'dd/mm/yyyy') date_of_birth,DECODE (sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender FROM mp_patient WHERE patient_id = '"+patient_id+"' and added_facility_id='"+facility_id+"'";
	pstmt3 = con.prepareStatement(patient_details);
	rs3 = pstmt3.executeQuery();
	if(rs3 != null)
	{
		while(rs3.next()){
			patient_name = rs3.getString(1);
			date_of_birth = rs3.getString(2);
			gender = rs3.getString(3);				
		} 
	}
				
	String speciality = "select distinct am_get_desc.am_speciality(b.specialty_code,'en','1') spec_desc from bl_bill_hdr a, pr_encounter b where b.ENCOUNTER_ID = '"+encounter_id+"'";
	pstmt4 = con.prepareStatement(speciality);
	rs4 = pstmt4.executeQuery();
	if(rs4 != null)
	{
		while(rs4.next()){
			speciality_desc = rs4.getString(1);
		}
	}			
	}catch(Exception eX)
	{	
		System.err.println("354,Exception==>"+eX);		
		out.println("Error= "+eX);
		eX.printStackTrace();
	}
	finally
	{
		if (rs3 != null)   rs3.close();
		if (rs2 != null)   rs2.close();
		if (rs4 != null)   rs4.close();
		if (pstmt3 != null) pstmt3.close();
		if (pstmt4 != null) pstmt4.close();
		if (pstmt2 != null) pstmt2.close();
	}
%>
	<body>
	<form name='resultForm' id='resultForm'> 
	<div class="div1">	
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td rowspan="2"><img src="../../eCommon/jsp/DisplayImages.jsp?param=facilityimage" width="196" height="47" /></td>	
	<td><b>Patient ID	:</b>	<%=patient_id%></td>
	<td><b>Patient Name	:</b>	<%=patient_name%></</td>
	<td><b>Encounter ID	:</b>	<%=encounter_id%></</td>

	</tr><tr>
	<td><b>Gender	:</b>	<%=gender%></td>
	<td><b>Date of Birth	:</b>	<%=date_of_birth%></td>
	<td><b>Speciality	:</b>	<%=speciality_desc%></td>
</tr>
</table>
</br>
<TABLE id="myTable" border='1px solid black;' cellpadding='10' cellspacing='0' align='left' width='30%'>
<tr>&nbsp;</tr>
<tr>
	<td class='COLUMNHEADER' width='5%'style="white-space: nowrap;text-align:center;" >Bill Document Number</td>
	<td class='COLUMNHEADER' width='12%' style="white-space: nowrap">Document Date</td>	
	<td class='COLUMNHEADER' width='15%' style="white-space: nowrap">Bill Amount</td>
</tr>
<tbody>		
<%
int i=1;
try
{
	String query_interface = "select a.operating_facility_id, b.patient_id, c.patient_name, c.date_of_birth, c.sex gender,b.episode_type, b.episode_id, b.visit_id, a.encounter_id, d.visit_adm_date_time encounter_date, g.practitioner_name doctor_name, b.doc_type_code , b.doc_num bill_reference,to_char(b.doc_date,'dd/mm/yyyy hh24:mi'), b.bill_amt, a.file_name, a.shared_path||a.file_name FROM BL_SMS_BILL_PRINT A, BL_BILL_HDR B, MP_PATIENT C,PR_ENCOUNTER D, IP_WARD E, OP_CLINIC F, AM_PRACTITIONER G WHERE a.doc_type_code = b.doc_type_code AND a.doc_num   = b.doc_num AND   b.patient_id    = c.patient_id AND   b.operating_facility_id = d.facility_id AND   a.encounter_id  = d.encounter_id AND   b.physician_id = g.practitioner_id AND   d.assign_care_locn_code = e.ward_code AND   a.episode_type in ('I','D')  AND   d.facility_id = '"+facility_id+"' AND   d.encounter_id='"+encounter_id+"'  UNION SELECT a.operating_facility_id, b.patient_id, c.patient_name, c.date_of_birth, c.sex gender, b.episode_type, b.episode_id, b.visit_id, a.encounter_id, d.visit_adm_date_time encounter_date, g.practitioner_name doctor_name, b.doc_type_code, b.doc_num bill_reference,to_char(b.doc_date,'dd/mm/yyyy hh24:mi'), b.bill_amt, a.file_name, a.shared_path||a.file_name FROM BL_SMS_BILL_PRINT A, BL_BILL_HDR B, MP_PATIENT C,PR_ENCOUNTER D, OP_CLINIC F, AM_PRACTITIONER G WHERE a.doc_type_code = b.doc_type_code AND   a.doc_num       = b.doc_num AND   b.patient_id    = c.patient_id AND   b.operating_facility_id = d.facility_id AND   a.encounter_id  = d.encounter_id AND   b.physician_id = g.practitioner_id AND   d.assign_care_locn_code = f.clinic_code(+) AND   f.clinic_code IS NOT NULL AND   a.episode_type in ('O','E') AND   d.facility_id = '"+facility_id+"' AND   d.encounter_id= '"+encounter_id+"' ORDER BY 1,9,12";
	pstmt5 = con.prepareStatement(query_interface);		
	rs5 = pstmt5.executeQuery();		
	classval = "label";
	if(rs5 != null)
	{
		while(rs5.next()){
			doc_type_code = rs5.getString(12);
			doc_num = rs5.getString(13);
			doc_date = rs5.getString(14);
			bill_amt = rs5.getString(15);
			file_path = rs5.getString(16);
			bill_amt=billingFormatConverter(con,bill_amt);				
%>
		<!--tr id=row<%=i%> onclick='highLight(<%=i%>,"<%=classval%>")'-->
		<tr id=row<%=i%> onclick='highlightRow1(<%=i%>,"<%=classval%>")'>
				<td id='row<%=i%>_col0' class=<%=classval%> width="50%" class="fields" style='cursor:pointer; white-space: nowrap' onclick="interfaceReports(<%=i%>);" scrolling='yes'>
				<a href class="LABEL" name='doc_num/type<%=i%>' id='doc_num/type<%=i%>'><%=doc_type_code%>/<%=doc_num%></a>
				</td>
				<td id='row<%=i%>_col1' class=<%=classval%> width="30%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='doc_date<%=i%>' id='doc_date<%=i%>'><%=doc_date%></span> 
				</td>

				<td id='row<%=i%>_col2' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='bill_tot_amt<%=i%>' id='bill_tot_amt<%=i%>'><%=bill_amt%></span> 
				</td>
			<input type='hidden'  name='file_path<%=i%>' id='file_path<%=i%>' value='<%=file_path%>'>	
			</tr>
			<input type='hidden' id='doc_typ_code<%=i%>' name='doc_typ_code<%=i%>' value='<%=doc_type_code%>'>
			<input type='hidden' name='doc_num<%=i%>' id='doc_num<%=i%>' value='<%=doc_num%>'>
			<input type='hidden' name='patient_id<%=i%>' id='patient_id<%=i%>' value='<%=patient_id%>'>
			<input type='hidden' name='episode_type<%=i%>' id='episode_type<%=i%>' value='<%=episode_type%>'>
			<input type='hidden'  name='episode_id<%=i%>' id='episode_id<%=i%>' value='<%=episode_id%>'>
			<input type='hidden'  name='visit_id<%=i%>' id='visit_id<%=i%>' value='<%=visit_id%>'>
			<input type='hidden'  name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>	
 <%
		i++;
		}
	}			
%>
<tbody>	
	</table>
<%				
		}
		catch(Exception eX)
		{		
			out.println("Error= "+eX);		
		}
		finally
		{
			if (rs3 != null)   rs3.close();
			if (pstmt3 != null) pstmt3.close();
			if (rs5 != null)   rs5.close(); 
			if (pstmt5 != null) pstmt5.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>
	<input type='hidden' name='login_user' id='login_user' id='login_user' value='<%=(String)session.getAttribute("login_user")%>'>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='rowClicked' id='rowClicked' id='rowClicked' value = ''>
	</div>
	</form>
	</body>
</html>
<!--JSP Created Against AAKH-CRF-0113.3-->

