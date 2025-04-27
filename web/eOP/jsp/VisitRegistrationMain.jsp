<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

    try
    { 

		con = ConnectionManager.getConnection(request);
		String facilityid       = (String) session.getValue("facility_id");
		if(facilityid == null || facilityid.equals("null"))
			facilityid = "";  
		String userid           = (String) session.getValue("login_user");
		if(userid == null || userid.equals("null"))
			userid = "";
		String query_string     =(request.getParameter("querY_string") == null)?"":request.getParameter("query_string");    
//		String fromserv     =(request.getParameter("fromserv") == null)?"":request.getParameter("fromserv");   
			
		String call_from     =(request.getParameter("call_from") == null)?"":request.getParameter("call_from");

		String patient     =(request.getParameter("patient") == null)?"":request.getParameter("patient");
		String q_appt_ref_no     =(request.getParameter("q_appt_ref_no") == null)?"":request.getParameter("q_appt_ref_no");
		String referral_id     =(request.getParameter("referral_id") == null)?"":request.getParameter("referral_id");
		String q_clinic_code     =(request.getParameter("q_clinic_code") == null)?"":request.getParameter("q_clinic_code");
		String q_locn_type     =(request.getParameter("q_locn_type") == null)?"":request.getParameter("q_locn_type");
		String q_Appt_time     =(request.getParameter("q_Appt_time") == null)?"":request.getParameter("q_Appt_time");				
		String q_visit_adm_type     =(request.getParameter("q_visit_adm_type") == null)?"":request.getParameter("q_visit_adm_type");
		String q_practitioner_id     =(request.getParameter("q_practitioner_id") == null)?"":request.getParameter("q_practitioner_id");
		
		String contact_reason_code =(request.getParameter("contact_reason_code") == null)?"":request.getParameter("contact_reason_code");
		String reason     =(request.getParameter("reason") == null)?"":request.getParameter("reason");
			
		String service_code     =(request.getParameter("service_code") == null)?"":request.getParameter("service_code");	
		String resource_class     =(request.getParameter("resource_class") == null)?"":request.getParameter("resource_class");
		String bl_install_yn = ((String)session.getValue("bl_operational"))==null?"N":(String)session.getValue("bl_operational");//Added for the CRF 41.1
		
		String emer_regn_allow_yn="";		
		String oper_stn_access_rule     = "";		
		String disable_pat_reg ="" ;
		String build_episode_rule="";
		String register_visit_walkin = "";
		String register_visit_referral = "";
		String OsVal="";
		String OsVal1="";
		String register_pat_yn="";
		String visit_for_inpat_yn =""; 

		String accept_dis_inv_no =""; 
		String visit_type_derv_rule =""; //added for 41.1
		String reg_vis = "" ;
		String bl_interface_yn="N";
		String or_install_yn="N";
		String patient_id = request.getParameter("p1") ;
		if(patient_id == null)  patient_id = "";
		String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id"); 
		
		String oa_install_yn="";
		String wait_list_inv=(request.getParameter("wait_list_inv")==null)?"N":request.getParameter("wait_list_inv");
		String register_visit_yn="N";
		String status=request.getParameter("status");
		if(status == null) status="N"; 		
		 
        //pstmt	= con.prepareStatement("Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_VISIT_YN'),AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_PAT_YN') FROM dual");	

        pstmt	= con.prepareStatement("Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_VISIT_YN') OsVal, AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_PAT_YN') OsVal1, (select install_yn from sm_module where module_id='OA') install_yn, (select operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR') operational_yn FROM dual");
		
		rs	= pstmt.executeQuery() ;
		rs.next();
	    OsVal = rs.getString("OsVal")==null?"":rs.getString("OsVal");
		OsVal1 = rs.getString("OsVal1")==null?"":rs.getString("OsVal1");
		oa_install_yn = rs.getString("install_yn")==null?"":rs.getString("install_yn");
		or_install_yn = rs.getString("operational_yn")==null?"":rs.getString("operational_yn");

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

        if(OsVal.equals("1"))
		 {
		 out.print(" <script>alert(getMessage('VISIT_REGN_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		 }else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {
				register_visit_yn="Y";
    	   
			  if((!OsVal1.equals("1")) && (!OsVal1.equals("2")) && (!OsVal1.equals("3")) && (!OsVal1.equals("4")) && (!OsVal.equals("5")))
			  { 
				register_pat_yn="Y"; 				
			  }

		/* Merged with previous query for Performance Tuning on 16th Apr 2010

		pstmt  = con.prepareStatement("select install_yn from sm_module where module_id='OA'");
		rs = pstmt.executeQuery();
		if(rs.next())
        oa_install_yn = rs.getString("install_yn");
    	if(rs != null) rs.close();
	    if(pstmt != null) pstmt.close();
	
		pstmt   = con.prepareStatement("select operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR'");
		rs=pstmt.executeQuery();
		if(rs != null && rs.next())
		{
		   or_install_yn=rs.getString("operational_yn");
		}
		

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		*/	
		
		pstmt  = con.prepareStatement("select oper_stn_access_rule, build_episode_rule, bl_interfaced_yn, ALLOW_WL_INV_WO_APPT_YN, ALLOW_EMER_REGN_YN, REG_VISIT_FOR_INPAT_YN, accept_display_inv_no,visit_type_derv_rule from op_param where operating_facility_id='"+facilityid+"'");//modified for 41.1

		rs = pstmt.executeQuery();
		if(rs.next())
	      {
				oper_stn_access_rule = rs.getString("oper_stn_access_rule")==null?"":rs.getString("oper_stn_access_rule");
				bl_interface_yn = rs.getString("bl_interfaced_yn")==null?"":rs.getString("bl_interfaced_yn");
				wait_list_inv=rs.getString("ALLOW_WL_INV_WO_APPT_YN")==null?"":rs.getString("ALLOW_WL_INV_WO_APPT_YN");
				build_episode_rule=rs.getString("build_episode_rule")==null?"":rs.getString("build_episode_rule");
				emer_regn_allow_yn=rs.getString("ALLOW_EMER_REGN_YN")==null?"N":rs.getString("ALLOW_EMER_REGN_YN");
				visit_for_inpat_yn =rs.getString("REG_VISIT_FOR_INPAT_YN")==null?"N":rs.getString("REG_VISIT_FOR_INPAT_YN");

				accept_dis_inv_no = rs.getString("accept_display_inv_no") == null ? "":rs.getString("accept_display_inv_no");
				visit_type_derv_rule = rs.getString("visit_type_derv_rule") == null ? "":rs.getString("visit_type_derv_rule");
				
		  }   

	    if(rs != null) rs.close();
	    if(pstmt != null) pstmt.close();
    	if(oper_stn_access_rule.equals(""))	{	
	    %>
	     <script>
	      alert(getMessage('OP_PARAM_NOT_FOUND','OP')); 
	     document.location.href ='../../eCommon/jsp/dmenu.jsp'
	     </script>
		 <%}   	
		 else if(visit_type_derv_rule.equals("B") && bl_install_yn.equals("N"))	{	
	    %>
	     <script>
	      alert(getMessage('VST_TYP_DERV_INS','OP')); 
	     document.location.href ='../../eCommon/jsp/dmenu.jsp'
	     </script>
		 <%}
		
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();
		
	} 
	
	 
 		if(wait_list_inv.equals("Y") && status.equals("Y"))
		{
			wait_list_inv ="Y";
			
		}
       
       %>
		<html>

		<%
			if(call_from.equals("CA"))
			{
		%>				

				<%-- <frameset rows='18,23.5%,7.5%,*,13%' id='visit'  framespacing=0>

				<frame name='patient_main' src='../../eOP/jsp/VisitRegistrationHead.jsp?&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&error=&disable_pat_reg=<%=disable_pat_reg%>&reg_vis_param=<%=reg_vis%>&function_id=<%=function_id%>&bl_interface_yn=<%=bl_interface_yn%>&wait_list_inv=<%=wait_list_inv%>&status=<%=status%>&or_install_yn=<%=or_install_yn%>&build_episode_rule=<%=build_episode_rule%>&register_pat_yn=<%=register_pat_yn%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>&call_from=<%=call_from%>' frameborder=0 scrolling='no' noresize>

				<frame name='patient_sub'  src='../../eOP/jsp/VisitRegistrationCriteria.jsp?patient=<%=patient%>&q_appt_ref_no=<%=q_appt_ref_no%>&referral_id=<%=referral_id%>&q_clinic_code=<%=q_clinic_code%>&q_visit_adm_type=<%=q_visit_adm_type%>&q_practitioner_id=<%=q_practitioner_id%>&q_visit_adm_type_ind=R&build_episode_rule=<%=build_episode_rule%>&bl_interface_yn=<%=bl_interface_yn%>				&oa_install_yn=<%=oa_install_yn%>&oper_stn_id=<%=OsVal%>&function_id=<%=function_id%>&or_install_yn=<%=or_install_yn%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&accept_dis_inv_no=<%=accept_dis_inv_no%>&query_string=<%=query_string%>' frameborder=0 scrolling='no' noresize>



				<frame name='patient_sub2' id='patient_sub2' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize>
                
				<frame name='patient_sub3' id='patient_sub3' src='../../eOP/jsp/VisitRegistrationResult.jsp?patient=<%=patient%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&q_appt_ref_no=<%=q_appt_ref_no%>&referral_id=<%=referral_id%>&q_clinic_code=<%=q_clinic_code%>&locn_ind=<%=q_locn_type%>&q_appt_time=<%=q_Appt_time%>&q_visit_adm_type=<%=q_visit_adm_type%>&q_practitioner_id=<%=q_practitioner_id%>&q_visit_adm_type_ind=R&build_episode_rule=<%=build_episode_rule%>&bl_interface_yn=<%=bl_interface_yn%>&oa_install_yn=<%=oa_install_yn%>&oper_stn_id=<%=OsVal%>&functionId=<%=function_id%>&menu_function_id=<%=function_id%>&or_install_yn=<%=or_install_yn%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&contact_reason_code=<%=contact_reason_code%>&reason=<%=reason%>&service_code=<%=service_code%>&query_String=<%=query_string%>&call_from=<%=call_from%>&resource_class=<%=resource_class%>' frameborder=0 noresize scrolling='no'>
<!-- passed the value visit_for_inpat_yn for SRR20056-SCF-3046.1 [IN:026060] by Suresh M on 21.01.2010 -->
				<frame name='patient_sub4' id='patient_sub4' src='../../eOP/jsp/VisitRegistrationApptRecds.jsp?patient_id=<%=patient%>&cur_appt_ref_no=<%=q_appt_ref_no%>&referral_id=<%=referral_id%>&bl_interface_yn=<%=bl_interface_yn%>&oa_install_yn=<%=oa_install_yn%>&oper_stn_id=<%=OsVal%>&function_id=<%=function_id%>&or_install_yn=<%=or_install_yn%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&build_episode_rule=<%=build_episode_rule%>&call_from=<%=call_from%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>' frameborder=0 scrolling='auto' noresize>
 --%>
				<iframe name='patient_main' src='../../eOP/jsp/VisitRegistrationHead.jsp?&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&error=&disable_pat_reg=<%=disable_pat_reg%>&reg_vis_param=<%=reg_vis%>&function_id=<%=function_id%>&bl_interface_yn=<%=bl_interface_yn%>&wait_list_inv=<%=wait_list_inv%>&status=<%=status%>&or_install_yn=<%=or_install_yn%>&build_episode_rule=<%=build_episode_rule%>&register_pat_yn=<%=register_pat_yn%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>&call_from=<%=call_from%>' frameborder=0 scrolling='no' style='height: 4vh;width:99vw'></iframe>
				<iframe name='patient_sub'  src='../../eOP/jsp/VisitRegistrationCriteria.jsp?patient=<%=patient%>&q_appt_ref_no=<%=q_appt_ref_no%>&referral_id=<%=referral_id%>&q_clinic_code=<%=q_clinic_code%>&q_visit_adm_type=<%=q_visit_adm_type%>&q_practitioner_id=<%=q_practitioner_id%>&q_visit_adm_type_ind=R&build_episode_rule=<%=build_episode_rule%>&bl_interface_yn=<%=bl_interface_yn%>				&oa_install_yn=<%=oa_install_yn%>&oper_stn_id=<%=OsVal%>&function_id=<%=function_id%>&or_install_yn=<%=or_install_yn%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&accept_dis_inv_no=<%=accept_dis_inv_no%>&query_string=<%=query_string%>' frameborder=0 scrolling='no' style='height: 58vh;width:99vw'></iframe>
				<iframe name='patient_sub2' id='patient_sub2' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' scrolling='no' style='height: 0vh;width:99vw'></iframe>
				<iframe name='patient_sub3' id='patient_sub3' src='../../eOP/jsp/VisitRegistrationResult.jsp?patient=<%=patient%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&q_appt_ref_no=<%=q_appt_ref_no%>&referral_id=<%=referral_id%>&q_clinic_code=<%=q_clinic_code%>&locn_ind=<%=q_locn_type%>&q_appt_time=<%=q_Appt_time%>&q_visit_adm_type=<%=q_visit_adm_type%>&q_practitioner_id=<%=q_practitioner_id%>&q_visit_adm_type_ind=R&build_episode_rule=<%=build_episode_rule%>&bl_interface_yn=<%=bl_interface_yn%>&oa_install_yn=<%=oa_install_yn%>&oper_stn_id=<%=OsVal%>&functionId=<%=function_id%>&menu_function_id=<%=function_id%>&or_install_yn=<%=or_install_yn%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&contact_reason_code=<%=contact_reason_code%>&reason=<%=reason%>&service_code=<%=service_code%>&query_String=<%=query_string%>&call_from=<%=call_from%>&resource_class=<%=resource_class%>' frameborder=0 noresize scrolling='no' style='height: 0vh;width:99vw'></iframe>
<!-- passed the value visit_for_inpat_yn for SRR20056-SCF-3046.1 [IN:026060] by Suresh M on 21.01.2010 -->
				<iframe name='patient_sub4' id='patient_sub4' src='../../eOP/jsp/VisitRegistrationApptRecds.jsp?patient_id=<%=patient%>&cur_appt_ref_no=<%=q_appt_ref_no%>&referral_id=<%=referral_id%>&bl_interface_yn=<%=bl_interface_yn%>&oa_install_yn=<%=oa_install_yn%>&oper_stn_id=<%=OsVal%>&function_id=<%=function_id%>&or_install_yn=<%=or_install_yn%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&build_episode_rule=<%=build_episode_rule%>&call_from=<%=call_from%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>' frameborder=0 scrolling='auto' style='height: 0vh;width:99vw'></iframe>
				
		<%
		    }
			else
			{
		%>

		   
			<%-- <frameset rows='20,45%,0,*,0' id='visit'  framespacing=0>
				<frame name='patient_main' src='../../eOP/jsp/VisitRegistrationHead.jsp?&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&error=&disable_pat_reg=<%=disable_pat_reg%>&reg_vis_param=<%=reg_vis%>&function_id=<%=function_id%>&bl_interface_yn=<%=bl_interface_yn%>&wait_list_inv=<%=wait_list_inv%>&status=<%=status%>&or_install_yn=<%=or_install_yn%>&build_episode_rule=<%=build_episode_rule%>&register_pat_yn=<%=register_pat_yn%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>' frameborder=0 scrolling='no' noresize> --%>
				<iframe name='patient_main' id='patient_main' src='../../eOP/jsp/VisitRegistrationHead.jsp?&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&error=&disable_pat_reg=<%=disable_pat_reg%>&reg_vis_param=<%=reg_vis%>&function_id=<%=function_id%>&bl_interface_yn=<%=bl_interface_yn%>&wait_list_inv=<%=wait_list_inv%>&status=<%=status%>&or_install_yn=<%=or_install_yn%>&build_episode_rule=<%=build_episode_rule%>&register_pat_yn=<%=register_pat_yn%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>' frameborder='0'  scrolling='no' style='height: 4vh;width:99vw'></iframe>
		<%         
           
				if(wait_list_inv.equals("N"))
				{
			 
			%>
				<%-- <frame name='patient_sub'  src='../../eOP/jsp/VisitRegistrationCriteria.jsp?&objName=checkin_tab&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&disable_pat_reg=<%=disable_pat_reg%>&reg_vis_param=<%=reg_vis%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&function_id=<%=function_id%>&bl_interface_yn=<%=bl_interface_yn%>&or_install_yn=<%=or_install_yn%>&wait_list_inv=<%=wait_list_inv%>&build_episode_rule=<%=build_episode_rule%>&register_visit_yn=<%=register_visit_yn%>&register_pat_yn=<%=register_pat_yn%>&accept_dis_inv_no=<%=accept_dis_inv_no%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>' frameborder=0 scrolling='no' noresize> --%>
				<iframe name='patient_sub' id='patient_sub' src='../../eOP/jsp/VisitRegistrationCriteria.jsp?&objName=checkin_tab&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&disable_pat_reg=<%=disable_pat_reg%>&reg_vis_param=<%=reg_vis%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&function_id=<%=function_id%>&bl_interface_yn=<%=bl_interface_yn%>&or_install_yn=<%=or_install_yn%>&wait_list_inv=<%=wait_list_inv%>&build_episode_rule=<%=build_episode_rule%>&register_visit_yn=<%=register_visit_yn%>&register_pat_yn=<%=register_pat_yn%>&accept_dis_inv_no=<%=accept_dis_inv_no%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>' frameborder='0'  scrolling='no' style='height: 58vh;width:99vw'></iframe>
			<%
				}
				else
				{ 
				%>
				<%-- <frame name='patient_sub' src='../../eOP/jsp/VisitRegistrationCriteria.jsp?&objName=invitation_tab&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&disable_pat_reg=<%=disable_pat_reg%>&from_head=Y&reg_vis_param=<%=reg_vis%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&function_id=<%=function_id%>&divval=Y&bl_interface_yn=<%=bl_interface_yn%>&or_install_yn=<%=or_install_yn%>&wait_list_inv=<%=wait_list_inv%>&build_episode_rule=<%=build_episode_rule%>&register_visit_yn=<%=register_visit_yn%>&register_pat_yn=<%=register_pat_yn%>&accept_dis_inv_no=<%=accept_dis_inv_no%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>' frameborder=0 scrolling='no' noresize> --%>
				<iframe name='patient_sub' id='patient_sub' src='../../eOP/jsp/VisitRegistrationCriteria.jsp?&objName=invitation_tab&oper_stn_id=<%=OsVal%>&emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&oa_install_yn=<%=oa_install_yn%>&disable_pat_reg=<%=disable_pat_reg%>&from_head=Y&reg_vis_param=<%=reg_vis%>&register_visit_walkin=<%=register_visit_walkin%>&register_visit_referral=<%=register_visit_referral%>&function_id=<%=function_id%>&divval=Y&bl_interface_yn=<%=bl_interface_yn%>&or_install_yn=<%=or_install_yn%>&wait_list_inv=<%=wait_list_inv%>&build_episode_rule=<%=build_episode_rule%>&register_visit_yn=<%=register_visit_yn%>&register_pat_yn=<%=register_pat_yn%>&accept_dis_inv_no=<%=accept_dis_inv_no%>&query_string=<%=java.net.URLEncoder.encode(query_string,"UTF-8")%>' frameborder='0'  scrolling='no' style='height: 58vh;width:99vw'></iframe>
				<%
				}
			
            
		%>
			
			<!-- <frame name='patient_sub2' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize>
			<frame name='patient_sub3' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
			<frame name='patient_sub4' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize>	 -->
			
			<iframe name='patient_sub2' id='patient_sub2' src='../../eCommon/html/blank.html' frameborder='0'  scrolling='no' style='height: 0vh;width:99vw'></iframe>
			<iframe name='patient_sub3' id='patient_sub3' src='../../eCommon/html/blank.html' frameborder='0'  scrolling='no' style='height: 0vh;width:99vw'></iframe>
			<iframe name='patient_sub4' id='patient_sub4' src='../../eCommon/html/blank.html' frameborder='0'  scrolling='auto' style='height: 0vh;width:99vw'></iframe>
			<%
			}
			%>
			<!-- </frameset>	 -->		
			
			</html>
		<%			
        }
    catch (Exception e) { out.println(e) ; e.printStackTrace();}
	finally{

	 if(con != null) ConnectionManager.returnConnection(con,request);

}
%>
