<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<!--

	Developed by 	:	R.Nanda Kumar
	Created on 	:	18/01/2000
	Module		:	Out Patient Management
	Function	:	Consultation - Patient Arrival. This file is used to call
				the ConsPatArrival.jsp file from the CallPatArrival.jsp for
				displaying records based on the arrival.
-->
<HTML>
	<HEAD>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<%  
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
	        response.addHeader("X-Content-Type-Options", "nosniff");
			String encounter=request.getParameter("p3");
			String queuestatus=request.getParameter("p1");
			String PreviousDay = request.getParameter("p11");
			String revert_to_check_in = request.getParameter("revert_to_check_in");
			if (revert_to_check_in==null) revert_to_check_in  = "N";
			String facility= (String) session.getValue( "facility_id" ) ;
			/*Below line added for this CRF Bru-HIMS-CRF-133*/
	        String curr_locntype = request.getParameter("curr_locntype")==null?"":request.getParameter("curr_locntype");
	        String curr_locncode = request.getParameter("curr_locncode")==null?"":request.getParameter("curr_locncode");
	        String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
			String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	    	//End this CRF Bru-HIMS-CRF-133

			String patient_id=request.getParameter("p2");
			String locn_type=request.getParameter("p4");
			String locn_code=request.getParameter("p5");
			String pract_id=request.getParameter("p6");
			
			String room_num=request.getParameter("p19");

			String p_status=request.getParameter("p15");
			String dt=request.getParameter("p16");
			String appt_id=request.getParameter("p17");
			String p_queue_date=request.getParameter("p18");
			String arrival_date=request.getParameter("p14");
			String curr_locn=request.getParameter("p20");
			String curr_locn_type_desc=request.getParameter("p21");
			String VISIT_ADM_TYPE_IND=request.getParameter("p22");
			String appt_case_yn=request.getParameter("p23");

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

			String assign_q_num_by = request.getParameter("p31") == null?"":request.getParameter("p31");			
		 		
			if (queuestatus.equals("01"))
			{
				out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.FirstTimeArrival.label","op_labels")+"</TITLE>");
			}
			else
			{
				out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReverttoCheckin.label","op_labels")+"</TITLE>");
			}
		%>
          <!--below line modified for this CRF Bru-HIMS-CRF-133 -->
		<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling=no style='height:25vh;width:100vw'></iframe>
		<iframe name='detail' id='detail' src="../../eOP/jsp/ConsPatArrival.jsp?revert_to_check_in=<%=revert_to_check_in%>&Encounter_Id=<%=encounter%>&Queue_Status=<%=queuestatus%>&PreviousDay=<%=PreviousDay%>&patient_id=<%=patient_id%>&locn_type=<%=locn_type%>&locn_code=<%=locn_code%>&pract_id=<%=pract_id%>&room_num=<%=room_num%>&p_status=<%=p_status%>&dt=<%=dt%>&appt_id=<%=appt_id%>&p_queue_date=<%=p_queue_date%>&arrival_date=<%=arrival_date%>&curr_locn=<%=curr_locn%>&curr_locn_type_desc=<%=curr_locn_type_desc%>&VISIT_ADM_TYPE_IND=<%=VISIT_ADM_TYPE_IND%>&appt_case_yn=<%=appt_case_yn%>&other_res_class=<%=other_res_class%>&other_res_code=<%=other_res_code%>&queue_num=<%=queue_num%>&appt_walk_ind=<%=appt_walk_ind%>&queue_id=<%=queue_id%>&assign_q_num_by=<%=assign_q_num_by%>&curr_locntype=<%=curr_locntype%>&curr_locncode=<%=curr_locncode%>&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>" noresize  frameborder=no marginheight=0 marginwidth=0 style='height:52vh;width:100vw'></iframe>
		<iframe name='dummyframe' id='dummyframe' src='../../eCommon/jsp/error.jsp' noresize frameborder=no marginheight=0 marginwidth=0 scrolling=no style='height:0vh;width:100vw'></iframe>

	</HEAD>

</HTML>

