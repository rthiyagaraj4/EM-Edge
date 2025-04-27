<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<HTML>
	<HEAD>
		<%  
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
	        response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con=null;
			String p_mode		= request.getParameter("p10");
			String encounter	= request.getParameter("p3");
			String PreviousDay = request.getParameter("p11");
			String facilityid 	= (String) session.getValue( "facility_id" ) ;
			String care_locn_id = request.getParameter("p13");
           	String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
			
			String patientID=request.getParameter("p2");
			String location_type=request.getParameter("p4");
			String location_code=request.getParameter("p5");
			String attend_practitioner_id=request.getParameter("p6");
            String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
			String sex=request.getParameter("p8");
			String dob=request.getParameter("p9");

			String p_status=request.getParameter("p15");
			String dtime=request.getParameter("p16");
			String p_queue_date  =request.getParameter("p18");
			String room_num =request.getParameter("p19");
			String appt_id =request.getParameter("p17");
			String ARRIVE_DATE_TIME=request.getParameter("p24");
			String VITAL_SIGNS_DATE_TIME=request.getParameter("p25");
			String other_res_class=request.getParameter("p26");
			if(other_res_class == null) other_res_class="";

			String other_res_code=request.getParameter("p27");
			if(other_res_code == null) other_res_code="";

			String queue_num=request.getParameter("p28");
			if(queue_num == null) queue_num="0";

			String appt_walk_ind=request.getParameter("p29");
			if(appt_walk_ind == null) appt_walk_ind="";
			String queue_id=request.getParameter("p30");
			if(queue_id == null) queue_id="";

			String assign_q_num_by = request.getParameter("assign_q_num_by")==null?"":request.getParameter("assign_q_num_by");
			
			if(assign_q_num_by == ""){
				assign_q_num_by=request.getParameter("p31");
			}
			// Thru CA module Starts
			String module_id=request.getParameter("module_id");
			if(module_id == null) module_id="";
			String locn_type=request.getParameter("locn_type");
			String locn_code=request.getParameter("locn_code");
			String practitioner_id=request.getParameter("practitioner_id");
			String visit_adm_date=request.getParameter("visit_adm_date");
			String patient_id=request.getParameter("patient_id");
			String case_type="";
			String ref_id="";
            //ends
		  /*Below line added for this CRF Bru-HIMS-CRF-133*/	
        String p_queue_status=request.getParameter("p1");		  
	    String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");	   
		String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		//End Bru-HIMS-CRF-133  	
					
			
		if(module_id.equals("CA"))
		{     		
			con=ConnectionManager.getConnection(request);
		 try{
    		
			String sql="SELECT APPT_ID, OTHER_RES_CLASS, OTHER_RESOURCE_ID, QUEUE_NUM, APPT_OR_WALK_IN_IND  CASE_TYPE, REFERRAL_ID FROM  OP_CURRENT_PATIENT WHERE facility_id = '"+facilityid+"' AND encounter_id='"+encounter+"'";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();

			  if(rs!=null)
				{
					if(rs.next())
					{
						
						appt_id				=   rs.getString("appt_id");
						if(appt_id == null) appt_id="";
						other_res_class		=   rs.getString("OTHER_RES_CLASS");
						if(other_res_class == null) other_res_class="";
						other_res_code		=   rs.getString("OTHER_RESOURCE_ID");
						if(other_res_code == null) other_res_code="";
						queue_num			=   rs.getString("QUEUE_NUM");
						ref_id				=   rs.getString("REFERRAL_ID");
						if(ref_id == null) ref_id="";
						case_type			= rs.getString("CASE_TYPE");
						if(!(appt_id.equals("") && ref_id.equals("")))
							appt_walk_ind="A";
						else if(!ref_id.equals(""))
							appt_walk_ind="R";
						else
							appt_walk_ind=case_type;

					}
				}
				if(rs != null) rs.close(); 
				if(pstmt != null) pstmt.close();
			}catch(Exception e )
			{
				e.printStackTrace();
			}finally
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
		}
	
			if(p_mode.equals("A"))
			{out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.assignpractitioner.label","op_labels")+"</TITLE>");
				
			}
			else
			{out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.reassignpractitioner.label","op_labels")+"</TITLE>");
				
			}
/*Below line modified for this CRF Bru-HIMS-CRF-133*/			
		%>
</HEAD>
		<% if(bl_install_yn.equals("Y")){%>
		<FRAMESET ROWS='14%,*,0%,0%' framespacing=0>
		<%}else{%>	
		<FRAMESET ROWS='14%,*,0%' framespacing=0>
			<%}%>	
			<FRAME NAME='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter%>&Facility_Id=<%=facilityid%>' noresize  frameborder=no scrolling=no>
			<frame name='detail' src='../../eOP/jsp/QmgmtRe_AssignPract.jsp?encounter_id=<%=encounter%>&mode=<%=p_mode%>&PreviousDay=<%=PreviousDay%>&care_locn_id=<%=care_locn_id%>&module_id=<%=module_id%>&locn_type=<%=locn_type%>&locn_code=<%=locn_code%>&practitioner_id=<%=practitioner_id%>&patient_id=<%=patient_id%>&visit_adm_date=<%=visit_adm_date%>&patientID=<%=patientID%>&location_type=<%=location_type%>&location_code=<%=location_code%>&attend_practitioner_id=<%=attend_practitioner_id%>&sex=<%=sex%>&dob=<%=dob%>&p_status=<%=p_status%>&dtime=<%=dtime%>&p_queue_date=<%=p_queue_date%>&room_num=<%=room_num%>&appt_id=<%=appt_id%>&ARRIVE_DATE_TIME=<%=ARRIVE_DATE_TIME%>&VITAL_SIGNS_DATE_TIME=<%=VITAL_SIGNS_DATE_TIME%>&other_res_class=<%=other_res_class%>&other_res_code=<%=other_res_code%>&queue_num=<%=queue_num%>&appt_walk_ind=<%=appt_walk_ind%>&oper_id=<%=oper_id%>&queue_id=<%=queue_id%>&assign_q_num_by=<%=assign_q_num_by%>&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>&p_queue_status=<%=p_queue_status%>' noresize frameborder=no marginheight=0 marginwidth=0 scrolling = no>
			<frame name='dummyfr' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
          <% if(bl_install_yn.equals("Y")){%>
		   <frame name='billingfr' src='../../eBL/jsp/BLSessionValuesReset.jsp' frameborder=0 noresize scrolling='no'>
<%}%>
    </FRAMESET>
</HTML>
