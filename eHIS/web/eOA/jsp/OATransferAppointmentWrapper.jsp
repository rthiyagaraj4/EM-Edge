<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.* ,eCommon.XSSRequestWrapper" %>  

<html>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<script>
		window.name = 'myModal';
		function loadPage(){
			//alert('loadPage:'+document.getElementById("rule_transfer").value);
			/*document.getElementById("rule_transfer").value ='N';
			alert(res_type)
			alert(document.getElementById("res_type").value)
			if(document.OATrnsfApptWarpperForm){
				document.OATrnsfApptWarpperForm.submit();
			}*/
			if(document.getElementById("rule_transfer") && document.getElementById("rule_transfer").value ==''){
				if((document.getElementById("rule_appl_yn") && document.getElementById("rule_appl_yn").value=='Y') && (document.getElementById("res_type") && document.getElementById("res_type").value == 'P')){
					if(window.confirm(getMessage("RESH_APPT_PRACT_UNKNOWN","OA"))){
						document.getElementById("rule_transfer").value ='Y';
						document.OATrnsfApptWarpperForm.submit();
					}else{
						document.getElementById("rule_transfer").value ='N';
						document.OATrnsfApptWarpperForm.submit();
					}
				}else{
					document.getElementById("rule_transfer").value ='N';
					document.OATrnsfApptWarpperForm.submit();
				}
			}
		}
	</script>
	<%
		request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String rule_transfer	= request.getParameter("rule_transfer")==null?"":request.getParameter("rule_transfer");
		String i_appt_ref_no	= request.getParameter("i_appt_ref_no");
		String res_type			= request.getParameter("res_type");
		String alcn_criteria	= request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String i_from_time		= request.getParameter("i_from_time")==null?"":request.getParameter("i_from_time");
		String i_to_time 		= request.getParameter("i_to_time")==null?"":request.getParameter("i_to_time");
		String i_clinic_code	= request.getParameter("i_clinic_code")==null?"":request.getParameter("i_clinic_code");
		String i_practitioner_id= request.getParameter("i_practitioner_id")==null?"":request.getParameter("i_practitioner_id");
		String new_appt_date	= request.getParameter("new_appt_date")==null?"":request.getParameter("new_appt_date");
		String i_appt_date		= request.getParameter("i_appt_date")==null?"":request.getParameter("i_appt_date");
		String appt_day1		= request.getParameter("appt_day1")==null?"":request.getParameter("appt_day1");
		String visit_type_ind	= request.getParameter("visit_type_ind")==null?"":request.getParameter("visit_type_ind");
		String i_team_id		= request.getParameter("i_team_id")==null?"":request.getParameter("i_team_id");
		String over_booked		= request.getParameter("over_booked")==null?"":request.getParameter("over_booked");
		String Forced			= request.getParameter("Forced")==null?"":request.getParameter("Forced");
		String clinic_type		= request.getParameter("clinic_type")==null?"":request.getParameter("clinic_type");
		String order_id			= request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String s=request.getQueryString();
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String rule_appl_yn ="N";
		if(rule_transfer.equals("")){
			try{
				con=ConnectionManager.getConnection(request);
				String oa_paramSQL="select rule_appl_yn  from oa_param where module_id='OA' ";
				pstmt=con.prepareStatement(oa_paramSQL);
				rs = pstmt.executeQuery();
				if (rs !=null && rs.next()){
					rule_appl_yn= rs.getString("rule_appl_yn")==null?"N":rs.getString("rule_appl_yn");
				}			
	%>
	<body onload='loadPage()'>
		<form name='OATrnsfApptWarpperForm' id='OATrnsfApptWarpperForm' action="../../eOA/jsp/OATransferAppointmentWrapper.jsp" target='myModal'>
			<input type='hidden' name='rule_transfer' id='rule_transfer' value='<%=rule_transfer%>'>
			<input type='hidden' name='i_appt_ref_no' id='i_appt_ref_no' value='<%=i_appt_ref_no%>'>
			<input type='hidden' name='res_type' id='res_type' value='<%=res_type%>'>
			<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>'>
			<input type='hidden' name='i_from_time' id='i_from_time' value='<%=i_from_time%>'>
			<input type='hidden' name='i_to_time' id='i_to_time' value='<%=i_to_time%>'>
			<input type='hidden' name='i_clinic_code' id='i_clinic_code' value='<%=i_clinic_code%>'>
			<input type='hidden' name='i_practitioner_id' id='i_practitioner_id' value='<%=i_practitioner_id%>'>
			<input type='hidden' name='new_appt_date' id='new_appt_date' value='<%=new_appt_date%>'>
			<input type='hidden' name='i_appt_date' id='i_appt_date' value='<%=i_appt_date%>'>
			<input type='hidden' name='appt_day1' id='appt_day1' value='<%=appt_day1%>'>
			<input type='hidden' name='visit_type_ind' id='visit_type_ind' value='<%=visit_type_ind%>'>
			<input type='hidden' name='i_team_id' id='i_team_id' value='<%=i_team_id%>'>
			<input type='hidden' name='over_booked' id='over_booked' value='<%=over_booked%>'>			
			<input type='hidden' name='Forced' id='Forced' value='<%=Forced%>'>
			<input type='hidden' name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>
			<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
			<input type='hidden' name='rule_appl_yn' id='rule_appl_yn' value='<%=rule_appl_yn%>'>
		</form>
	</body>
			<%}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(con!=null) 	ConnectionManager.returnConnection(con,request);
			}
		}else if(rule_transfer.equals("N")){%>
			<iframe name='trnaferFrame' id='trnaferFrame' src='../../eOA/jsp/TransferAppointmentFrame.jsp?<%=s%>' noresize frameborder=0 scrolling='no' style='height:100vh;width:100vw'></iframe>	
		<%}else if(rule_transfer.equals("Y")){
			String apptrefno = request.getParameter("i_appt_ref_no");
			s=s+"&apptrefno="+apptrefno;
		%>
			<iframe name='trnaferFrame' id='trnaferFrame' src='../../eOA/jsp/RuleBasedTransferFrame.jsp?<%=s%>' noresize frameborder=0 scrolling='no' style='height:100vh;width:100vw'></iframe>	
		<%}%>
</html>

