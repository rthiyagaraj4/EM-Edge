<!DOCTYPE html>
      
<%@ page import="java.sql.*, java.util.*,java.net.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eAE/js/AEUtilities.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatientGI.js'></script>

<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt = null;
Statement stmt = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
PreparedStatement pstmt3 = null; 
java.util.Properties p 		= null;
String client_ip_address="";
String user_id="";
int rs=0;
int rs1=0;
ResultSet rset=null;

try{
	con = ConnectionManager.getConnection(request);
	String facilityId				=(String) session.getValue("facility_id");
	String clinic_code				=request.getParameter("clinic_code");
	String practitioner_id			=request.getParameter("practitioner_id");
	String encounter_id				=request.getParameter("encounter_id");	
	String treatment_area_code		=request.getParameter("treatment_area_code");
	String bed_no					=request.getParameter("bed_no");
	String patient_id				=request.getParameter("patient_id");
	String service_code				=request.getParameter("service_code");
	String mode				=request.getParameter("mode");
	
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	client_ip_address = p.getProperty("client_ip_address");
	user_id	= (String)session.getValue("login_user") ;



	if(mode.equals("BookBed")){
	
			if(true){
		stmt=con.createStatement();
		rset=stmt.executeQuery("select '1' from ae_bed_for_trmt_area where occupying_patient_id='"+patient_id+"' and facility_id='"+facilityId+"'");
		
		boolean occupy_flag=false;

		if(rset!=null){
			if(rset.next())
				occupy_flag=true;
		}
		if(rset!=null) rset.close();
        if(stmt!=null) stmt.close();


		if(!occupy_flag){

			con.setAutoCommit( false );

			String sql1="update op_patient_queue set treatment_area_code = '"+treatment_area_code+"',  ae_bed_no = '"+bed_no+"',  practitioner_id = '"+practitioner_id+"', modified_by_id = '"+user_id+"', modified_date = SYSDATE,  modified_at_ws_no = '"+client_ip_address+"', modified_facility_id = '"+facilityId+"' where facility_id = '"+facilityId+"' and encounter_id = '"+encounter_id+"'";

			
			String sql2="update AE_BED_FOR_TRMT_AREA set OCCUPYING_PATIENT_ID =  '"+patient_id+"',CURRENT_STATUS ='O' where FACILITY_ID = '"+facilityId+"' AND  CLINIC_CODE = '"+clinic_code+"' AND  TREATMENT_AREA_CODE = '"+treatment_area_code+"' AND BED_NO = '"+bed_no+"'";

			String sql3="insert into ae_pat_movement_log (patient_id,facility_id,encounter_id,assign_tmt_area_code,assign_bed_no,assign_practitioner_id,assign_date,assign_clinic_code,added_facility_id,added_date,added_by_id,added_at_ws_no,service_code) 	values ('"+patient_id+"','"+facilityId+"','"+encounter_id+"','"+treatment_area_code+"','"+bed_no+"','"+practitioner_id+"',sysdate,'"+clinic_code+"','"+facilityId+"',sysdate,'"+user_id+"','"+client_ip_address+"','"+service_code+"')";

			String sql4="update pr_encounter set ATTEND_PRACTITIONER_ID = '"+practitioner_id+"', modified_by_id = '"+user_id+"', modified_date = SYSDATE, modified_at_ws_no = '"+client_ip_address+"', modified_facility_id = '"+facilityId+"', service_code = '"+service_code+"' where facility_id = '"+facilityId+"' and encounter_id='"+encounter_id+"'";

			 pstmt = con.prepareStatement(sql1);
			 pstmt1 = con.prepareStatement(sql2);
			 pstmt2 = con.prepareStatement(sql3);
			 pstmt3 =  con.prepareStatement(sql4);

			
			rs=pstmt.executeUpdate();
			
			rs1=pstmt1.executeUpdate();
			


			if(rs>0 && rs1>0 ){
				con.commit();
				%><script>
				
				
				alert( getMessage('RECORD_INSERTED','SM'));
				parent.frames[0].document.forms[0].refresh.click();
			
				
				</script><%	
			}else{
				con.rollback();
				%><script>alert('Transaction failed 1 ');parent.frames[0].document.forms[0].refresh.click();
					</script><%
			}
		}else{
			%>
				<script>
				alert('patient currently occupies another bed');
				parent.frames[0].document.forms[0].refresh.click();
			</script>
				
			<%
		    if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
             
			}

	}else{%>
					<script>
		alert( getMessage('SECURED_NOT_ALLOWED','Common'));
		parent.frames[0].document.forms[0].refresh.click();
	</script>

	<%}
	}else{
		try{
			String sql4="update ae_bed_for_trmt_area set current_status='A',reason_for_reserve='' where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and treatment_area_code='"+treatment_area_code+"' and bed_no='"+bed_no+"' ";

			pstmt3 =  con.prepareStatement(sql4);



			rs=pstmt3.executeUpdate();
			if(rs>0){
				%><script>
					alert( getMessage('RECORD_INSERTED','SM'));
					parent.frames[0].document.forms[0].refresh.click();</script><%

			}else{
				%>
					<script>
					alert('Transaction failed 2');
					parent.frames[0].document.forms[0].refresh.click();
				</script>
					
				<%

			}

		}catch( Exception e ){
			e.printStackTrace();
			%><script>alert('Transaction failed 3');
			parent.frames[0].document.forms[0].refresh.click();</script><%

		}
		finally
		{
			
			if(pstmt3!=null) pstmt3.close();
		
		}

	}
}
catch( Exception e ){
	con.rollback();
	e.printStackTrace();
	%>
		<script></script>
	<%
}
finally
{
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(pstmt2!=null) pstmt2.close();
	if(pstmt3!=null) pstmt3.close();
	ConnectionManager.returnConnection(con,request);
}
%>		

