

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*" %>
<html>
<head></head>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<body class=message  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name=dummy>
<script src='../../eOA/js/BookAppointment.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	String balnkString="";
	boolean check_ovelap = true;
	boolean allow_sch_overlap = false;
	int count = 0;
try{
		conn = ConnectionManager.getConnection(request);

	String fin_string=request.getParameter("fin_string");


	String max_patient=request.getParameter("max_patient");


	String calling_from=request.getParameter("calling_from");
	//String facilityid=(String)session.getValue("facility_id");

	

	if (calling_from==null) calling_from="";
	
	int max_patient_per_day=Integer.parseInt(max_patient);
	int chk_percen=0;
	int max_percen=0;
	String inner_string="";
	String patient="";
	//String holiday_check="Y";

	String caller=request.getParameter("caller");
	if (caller==null) caller="N";
	StringTokenizer indtoken = new StringTokenizer(fin_string, "|");
	if (calling_from.equals("day_schedule")){
		while (indtoken.hasMoreTokens()){
			inner_string = indtoken.nextToken();
				StringTokenizer stoken = new StringTokenizer(inner_string,"$");
					while(stoken.hasMoreTokens()){
							stoken.nextToken();
							patient					= stoken.nextToken();
							chk_percen				= Integer.parseInt(patient);
							stoken.nextToken();
							max_percen				+=chk_percen;

					}

		}
	}else{
		while (indtoken.hasMoreTokens()){
			inner_string = indtoken.nextToken();
				StringTokenizer stoken = new StringTokenizer(inner_string,"$");
					while(stoken.hasMoreTokens()){
							stoken.nextToken();
							patient					= stoken.nextToken();
							chk_percen				= Integer.parseInt(patient);
							stoken.nextToken();
							max_percen				+=chk_percen;

					}

		}
	}
	if(max_percen>max_patient_per_day){%>
		<script>
		var errors = getMessage("TOT_ALCN_NOT_GT_MX_PAT_DAY","OA");
		alert(errors);
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
		</script>

	<%}else{		
		if (calling_from.equals("day_schedule")){
			int max_new_patients=Integer.parseInt(request.getParameter("max_new_patients"));
			int max_old_patients=Integer.parseInt(request.getParameter("max_old_patients"));
			int total_New_Old_Pat=max_new_patients+max_old_patients;
			if(caller.equals("Y")){

				String facility_id=request.getParameter("facility_id");
				String cln_dt=request.getParameter("cln_dt");
				String cln_cd=request.getParameter("cln_cd");
				String practitioner=request.getParameter("practitioner")==null?"":request.getParameter("practitioner");
				
				String resourceType=request.getParameter("resourceType");
				String start_time=request.getParameter("start_time");
				String end_time=request.getParameter("end_time");
				String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
				String rule_appl_yn=request.getParameter("rule_appl_yn")==null?"":request.getParameter("rule_appl_yn");
				//String sql1="Select '1' From oa_clinic_schedule where facility_id=? and clinic_code=?  and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and nvl(Practitioner_id,'X')= nvl( ? ,'X') ";
				String sql1="";
				String sql="SELECT a.functionality_id, a.key_1, a.value_1, a.key_2, a.value_2 FROM sm_function_control a,sm_site_param b WHERE a.module_id = 'OA' AND a.functionality_id = 'ALLOW_SCH_OVERLAP' AND a.site_id = b.customer_id";				
				String ovelap_key_1="";
				String ovelap_value_1="";
				String ovelap_key_2="";
				String ovelap_value_2="";
				if(pstmt!=null)pstmt.close();
				pstmt=conn.prepareStatement(sql);
				if(rs!=null)rs.close();
				rs = pstmt.executeQuery();
				if( rs != null && rs.next()){
					allow_sch_overlap=true;
					ovelap_key_1=rs.getString("key_1");
					ovelap_value_1=rs.getString("value_1");
					ovelap_key_2=rs.getString("key_2");
					ovelap_value_2=rs.getString("value_2");				
				}
				if(mode!=null && mode.equals("insert")){
					//sql1="Select '1' From oa_clinic_schedule where facility_id=? and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and nvl(Practitioner_id,'X')= nvl( ? ,'X') AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR clinic_code=? ) ";
					if(practitioner.equals("")){
						sql1="SELECT count(*) count  FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id is null";
						pstmt=conn.prepareStatement(sql1);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,cln_dt);
						pstmt.setString(3,resourceType);
						pstmt.setString(4,cln_cd);
					}else{
						//if(rule_appl_yn.equals("Y")){// commented by sudhakar for overlapping schedules
							if(!allow_sch_overlap){
								sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND ((clinic_code = ? AND practitioner_id = ?)OR (practitioner_id = ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi')))))";
								pstmt=conn.prepareStatement(sql1);
								//pstmt.setString(1,facility_id);
								pstmt.setString(1,cln_dt);
								pstmt.setString(2,resourceType);
								pstmt.setString(3,cln_cd);
								pstmt.setString(4,practitioner);
								pstmt.setString(5,practitioner);
								pstmt.setString(6,start_time);
								pstmt.setString(7,end_time);
								pstmt.setString(8,start_time);
								pstmt.setString(9,end_time);	
								pstmt.setString(10,start_time);
								pstmt.setString(11,end_time);
							}else{
								sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id = ?";
								pstmt=conn.prepareStatement(sql1);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,cln_dt);
								pstmt.setString(3,resourceType);
								pstmt.setString(4,cln_cd);
								pstmt.setString(5,practitioner);
								if(ovelap_value_2!=null){
									if(rs!=null)rs.close();
									rs = pstmt.executeQuery();													
									if( rs != null && rs.next()){
										count = rs.getInt("count");
									}
								}
								if(!(count >0) && (ovelap_value_2!=null && !balnkString.equals(ovelap_value_2))){
									count=0;
									sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND practitioner_id = ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) AND resource_class = ?";
									pstmt=conn.prepareStatement(sql1);
									pstmt.setString(1,facility_id);
									pstmt.setString(2,cln_dt);
									pstmt.setString(3,resourceType);
									pstmt.setString(4,practitioner);
									pstmt.setString(5,start_time);
									pstmt.setString(6,end_time);
									pstmt.setString(7,start_time);
									pstmt.setString(8,end_time);
									pstmt.setString(9,start_time);
									pstmt.setString(10,end_time);
									pstmt.setString(11,ovelap_value_2);
								}
							}
						/*}else{// commented by sudhakar for overlapping schedules
							sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id = ?";
							pstmt=conn.prepareStatement(sql1);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,cln_dt);
							pstmt.setString(3,resourceType);
							pstmt.setString(4,cln_cd);
							pstmt.setString(5,practitioner);						
						}*/
						
					}
				}else{//modify mode	
					if(practitioner.equals("")){
						sql1="SELECT count(*) count  FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id is null ";
						pstmt=conn.prepareStatement(sql1);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,cln_dt);
						pstmt.setString(3,resourceType);
						pstmt.setString(4,cln_cd);
					}else{
						//if(rule_appl_yn.equals("Y")){// commented by sudhakar for overlapping schedules
						if(!allow_sch_overlap){
							sql1="Select count(*) count From oa_clinic_schedule where clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and Practitioner_id= ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi')))";
							pstmt=conn.prepareStatement(sql1);
							//pstmt.setString(1,facility_id);
							pstmt.setString(1,cln_dt);
							pstmt.setString(2,resourceType);
							pstmt.setString(3,practitioner);
							pstmt.setString(4,start_time);
							pstmt.setString(5,end_time);
							pstmt.setString(6,start_time);
							pstmt.setString(7,end_time);
							pstmt.setString(8,start_time);
							pstmt.setString(9,end_time);
						}else{
							if(ovelap_value_2==null){
								check_ovelap =false;
							}else{
								sql1="Select count(*) count From oa_clinic_schedule where facility_id=? and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and Practitioner_id= ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) AND resource_class = ?";
								pstmt=conn.prepareStatement(sql1);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,cln_dt);
								pstmt.setString(3,resourceType);
								pstmt.setString(4,practitioner);
								pstmt.setString(5,start_time);
								pstmt.setString(6,end_time);
								pstmt.setString(7,start_time);
								pstmt.setString(8,end_time);
								pstmt.setString(9,start_time);
								pstmt.setString(10,end_time);
								pstmt.setString(11,ovelap_value_2);
							}
						}
						/*}else{// commented by sudhakar for overlapping schedules
							sql1="Select count(*) count From oa_clinic_schedule where facility_id=? and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and Practitioner_id= ? AND clinic_code = ?";
							pstmt=conn.prepareStatement(sql1);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,cln_dt);
							pstmt.setString(3,resourceType);
							pstmt.setString(4,practitioner);
							pstmt.setString(5,cln_cd);
						}*/
					}			
				}				
				if(rs!=null)rs.close();
				if((mode!=null && mode.equals("insert")) || (mode!=null && mode.equals("modify") && check_ovelap)){
					rs = pstmt.executeQuery(); 
					//int count = 0;				
					if( rs != null && rs.next()){
						count = rs.getInt("count");
					}
				}
				if(((mode!=null && mode.equals("insert")) && count > 0) || (!(mode!=null && mode.equals("insert"))&&count > 1)){				
					%>
					<script>
						var error = getMessage("SCH_ALREADY_EXISTS","OA");
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" +error;
					</script>
				<%}else{%>
					<script>
						var max_patient_per_day=parseInt('<%=max_patient_per_day%>');
						var total_New_Old_Pat=parseInt('<%=total_New_Old_Pat%>');
						if(parent.frames[1].document.forms[0].rule_appl_yn.value =='Y'){
							if(max_patient_per_day == total_New_Old_Pat){
								parent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;
								parent.frames[1].document.forms[0].submit() ;
							}else{
								parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('SUM_MAX_NEW_OLD_MAXPATPERDAY','OA');
							}
						}else{
							parent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;
							parent.frames[1].document.forms[0].submit() ;
						}
					</script>
				<%}%>
			<%}else{%>
				<script>
					var max_patient_per_day=parseInt('<%=max_patient_per_day%>');
					var total_New_Old_Pat=parseInt('<%=total_New_Old_Pat%>');
					if(parent.frames[1].document.forms[0].rule_appl_yn.value =='Y'){
						if(max_patient_per_day == total_New_Old_Pat){
							parent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;
							parent.frames[1].document.forms[0].submit() ;
						}else{
							parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('SUM_MAX_NEW_OLD_MAXPATPERDAY','OA');
						}
					}else{
						parent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;
						parent.frames[1].document.forms[0].submit() ;
					}
				</script>
			<%}%>

		<%}else{%>
			<script>
			var max_patients_per_day = parseInt(parent.frames[1].document.forms[0].max_patients_per_day.value);

				if(parent.frames[1].document.forms[0].rule_appl_yn.value == 'Y'){
					var max_new_patients = parseInt(parent.frames[1].document.forms[0].max_new_patients.value);
					var max_old_patients = parseInt(parent.frames[1].document.forms[0].max_old_patients.value);
					if(max_patients_per_day == (max_new_patients+max_old_patients)){
						parent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;
						parent.frames[1].document.forms[0].l_max_pat_per_slot.value=parent.frames[1].document.forms[0].b_max_slots_per_day.value;
						parent.frames[1].document.forms[0].action="../../servlet/eOA.TimeTableServlet";
						parent.frames[1].document.forms[0].submit() ;
					}else{
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('SUM_MAX_NEW_OLD_MAXPATPERDAY','OA');
					}
			}else{
				parent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;
				parent.frames[1].document.forms[0].l_max_pat_per_slot.value=parent.frames[1].document.forms[0].b_max_slots_per_day.value;
				parent.frames[1].document.forms[0].action="../../servlet/eOA.TimeTableServlet";
				parent.frames[1].document.forms[0].submit() ;
			}
			</script>
	<%}
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
}catch( Exception e ){
	e.printStackTrace();
	//out.println(e.toString());
}finally{
	try{
		if(conn!=null) 	ConnectionManager.returnConnection(conn,request);
	}catch(Exception e){out.println(e);}
}
%>		
</form>
</body>
</html>

