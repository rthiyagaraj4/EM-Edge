<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<HEAD>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <%
        request.setCharacterEncoding("UTF-8");
		String tit=request.getParameter("title");
        if(tit==null)
tit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelCheckout.label","common_labels");
			String locale = (String)session.getAttribute("LOCALE");
          
    %>
	<title><%=tit%></title>
	<%
				
		Connection con=null;
 	    PreparedStatement pstmt = null ;
		ResultSet rs=null;
		Boolean isAllowRegForSameService = false; //Added by Mujafar  for ML-MMOH-CRF-1437
		

		String facility= (String) session.getValue( "facility_id" ) ;
		String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
		String encounter_id = request.getParameter("encounter_id");
		String patient_id = request.getParameter("pat_id");
		String loc_type = request.getParameter("clinic_type");
		String oplocation = request.getParameter("location_id");
		String pract = request.getParameter("pract_id");
		String module_id = request.getParameter("module_id");
		String queue_date = request.getParameter("queue_date");
		String service_code = request.getParameter("service_code");

		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String registered_in_mo_yn=request.getParameter("registered_in_mo_yn")==null?"":request.getParameter("registered_in_mo_yn");

		
	try
	{
            con=ConnectionManager.getConnection(request);
			isAllowRegForSameService = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALLOW_VISIT_SAME_SER");//Added by Mujafar  for ML-MMOH-CRF-1437
/*
		String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+facility+"','"+userid+"','X','','CANCEL_CHECKOUT_YN') FROM dual" ;  
			pstmt=con.prepareStatement(sql_new);
            rs=pstmt.executeQuery();
            rs.next();
	        String OsVal=rs.getString(1);
        
			if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")))
	        {
			   check_out_yn="Y";
			   
            }else
				{
				check_out_yn="N";
				}
			if(pstmt!=null ) pstmt.close();	
			if (rs != null)  rs.close();

			if(check_out_yn.equals("N"))
			{ */

		//	}else


			//{

		/*	String sql1= "SELECT REGISTERED_IN_MO_YN FROM mp_patient where PATIENT_ID='"+patient_id+"'";			
			String registered_in_mo_yn = "";
			pstmt=con.prepareStatement(sql1);
            rs=pstmt.executeQuery();            
    		if(rs.next() && rs!=null) 	{						
				registered_in_mo_yn=rs.getString("REGISTERED_IN_MO_YN");				
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();		*/	


			String sql2= "SELECT TO_CHAR(ADMISSION_DATE_TIME, 'dd/mm/yyyy hh24:mi')ADMISSION_DATE_TIME from IP_OPEN_ENCOUNTER where PATIENT_ID='"+patient_id+"'";
			String addmission_date_time = "";
			String open_encounter = "";		
				
			pstmt=con.prepareStatement(sql2);
            rs=pstmt.executeQuery();            
    		if(rs.next() && rs!=null) 	{						
				addmission_date_time=rs.getString("ADMISSION_DATE_TIME");				
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			boolean checkdate =false;
			
			checkdate =com.ehis.util.DateUtils.isAfter(addmission_date_time,queue_date,"DMYHM",locale);			
			if(checkdate) 
				open_encounter = "Y";					
			else
				open_encounter = "N";		
			
			String sql4= "select * from op_patient_queue where FACILITY_ID ='"+facility+"' and PATIENT_ID ='"+patient_id+"' and  SERVICE_CODE='"+service_code+"' and  queue_status = '07' and  queue_date > to_date('"+queue_date+"','dd/mm/yyyy hh24:mi:ss')";		
			
			String recordExists = "";
			pstmt=con.prepareStatement(sql4);
			rs=pstmt.executeQuery();
			if(rs.next() && rs!=null){
				recordExists = "Y";
			} else{
				recordExists = "N";
			}

			if(recordExists.equals("Y")){
			%>
			<script>
				alert(getMessage("CHECKED_OUT_ENCOUNTER_EXISTS","OP"));
				window.close();
				</script>
			<%
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			String sql3="";
			if(isAllowRegForSameService) //Added by Mujafar  for ML-MMOH-CRF-1437
				sql3= "select * from op_patient_queue where FACILITY_ID ='"+facility+"' and PATIENT_ID ='"+patient_id+"' and locn_code='"+oplocation+"' and  SERVICE_CODE='"+service_code+"' and  queue_status < '07'";
			else
				sql3= "select * from op_patient_queue where FACILITY_ID ='"+facility+"' and PATIENT_ID ='"+patient_id+"' and  SERVICE_CODE='"+service_code+"' and  queue_status < '07'";
			String op_pat_queue_val ="";			
			pstmt=con.prepareStatement(sql3);
            rs=pstmt.executeQuery();            
    		if(rs.next() && rs!=null) 	{						
				op_pat_queue_val="Y";
			} else {
				op_pat_queue_val = "N";
			}			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();			
			
			if(registered_in_mo_yn.equals("Y")){
				%>
					<script>
						alert(getMessage("REGISTERED_IN_MORTUARY","Common"));	
						window.close();
					</script>
				<%
			} 

			if(open_encounter.equals("Y")){
				%>
					<script>
						alert(getMessage("CURRENTLY_IN_PATIENT1","Common"));	
						window.close();						
					</script>
				<%
			} 

			if(op_pat_queue_val.equals("Y")){
				%>
					<script>
						alert(getMessage("ALREADY_VISITED_SAME_LOCN","Common"));		
						window.close();
					</script>
				<%
			} 

			 if(bl_install_yn.equals("Y")){%>
				<FRAMESET ROWS='9%,88%,0%,0%' framespacing=0>  
			<%}else{%>	
				<FRAMESET ROWS='9%,88%,0%' framespacing=0>  
			<%}%>	
			
				<FRAME name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no'>
				<!--<frame name='detail' id='detail' src='../../eOP/jsp/OPCancellCheckoutModel.jsp?module_id=<%=module_id%>&encounter_id=<%=encounter_id%>&pract=<%=pract%>&oplocation=<%=oplocation%>&patient_id=<%=patient_id%>&loc_type=<%=loc_type%>&function_id=<%=function_id%>&oper_stn_id=<%=oper_stn_id%>&<%=request.getQueryString()%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no'>-->
				<frame name='detail' id='detail' src="../../eOP/jsp/OPCancellCheckoutModel.jsp?module_id=<%=module_id%>&encounter_id=<%=encounter_id%>&pract=<%=pract%>&oplocation=<%=oplocation%>&patient_id=<%=patient_id%>&loc_type=<%=loc_type%>&function_id=<%=function_id%>&oper_stn_id=<%=oper_stn_id%>&<%=request.getQueryString()%>" noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no'><!--Modified by Rameswar Against IN55430-->
				<frame name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' framesetborder=0 frameborder=0 noresize scrolling='no'>
				 <% if(bl_install_yn.equals("Y")){%>
				 <frame name='billingfr' id='billingfr' src='../../eBL/jsp/BLSessionValuesReset.jsp' frameborder=0 noresize scrolling='no'>
				 <%}%>
			</FRAMESET>
	<%
		//}
	}catch(Exception e){out.println("Errorr"+e);
			e.printStackTrace();	
				
	}finally{
		//if(cs != null)  cs.close() ;
		ConnectionManager.returnConnection(con,request);
		}
	
	%>

</head>
</html>

