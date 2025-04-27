<!DOCTYPE html>
<%@page  import ="java.sql.*,webbeans.eCommon.ConnectionManager,"contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<jsp:useBean id="verifychecklist" class="webbeans.eCommon.RecordSet" scope="session"/>

 <%	
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter("func_mode") ;
	String facility_id			= checkForNull(request.getParameter( "facility_id" )) ;
	String chk_in_dt_time		= checkForNull(request.getParameter( "chk_in_dt_time" )) ;
	String chk_out_dt_time		= checkForNull(request.getParameter( "chk_out_dt_time" )) ;
	String oper_room_code		= checkForNull(request.getParameter( "oper_room_code" )) ;

	String units				= checkForNull(request.getParameter( "units" )) ;
	String serv_code			= checkForNull(request.getParameter( "serv_code" )) ;
	String oper_num				= checkForNull(request.getParameter( "oper_num" )) ;
	String module_id			= checkForNull(request.getParameter( "module_id" )) ;
	String patient_id			= checkForNull(request.getParameter( "patient_id" )) ;
	String booking_num			= checkForNull(request.getParameter( "booking_num" )) ;
	String order_id				= checkForNull(request.getParameter( "order_id" )) ;
	String speciality_code		= checkForNull(request.getParameter( "speciality_code" )) ;
	String oper_code			= checkForNull(request.getParameter( "oper_code" )) ;
	String surgeon_code			= checkForNull(request.getParameter( "surgeon_code" )) ;


	String encounter_id		= "";		
	String visit_id			= "";		
	String episode_id		= "";		
	String episode_type		= "";		
	String no_of_units		= "";		
	String bill_serv_code	= "";		
	String strErrorCode		= "";		
	String strSysMsgId		= "";
	String strErrText		= "";
	String panel_string		= "";
	String chrg_based_yn	= "";
	String total_amt		= "";
	String pat_payable_amt	= "";
	String excl_incl_ind	= "";
	String preapp_yn		= "";
	String pat_paid_amt		= "";
	String charged_yn		= "";
	String pat_billed_yn	= "";
	String error_lvl		= "";
	String sts_mess_id		= "";
	String err_txt			= "";
	String oper_room_chk_yn	= "";
	String patient_class	= "";
	String bl_episode_type	= "";
	String oper_room_charge_yn	= "";

	String sep	= "##";
	String splitter	= "$$";
	StringBuilder sbr = new StringBuilder();
	Connection con = null;
	PreparedStatement pstmt  = null;
	CallableStatement cstmt  = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		if(func_mode.equalsIgnoreCase("checkORChargeYN")){	
			String oper_room= checkForNull(request.getParameter( "oper_room_code" )) ;			
			String sql="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_OPER_ROOM WHERE OPER_ROOM_CODE ='"+oper_room+"' AND OPERATING_FACILITY_ID='"+facility_id+"' ";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				oper_room_charge_yn=rst.getString(1);
			}
			out.println(oper_room_charge_yn);
		}else if(func_mode.equalsIgnoreCase("checkORParameter")){	
			if(pstmt!=null)pstmt.close();
			if(rst!=null)rst.close();
			String sql="SELECT CHARGE_OPERATING_ROOM_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				oper_room_chk_yn=rst.getString(1);
			}
			out.println(oper_room_chk_yn);
		}else if(func_mode.equalsIgnoreCase("getOperRoomCheck")){
			if(pstmt!=null)pstmt.close();
			if(rst!=null)rst.close();
			String oper_room_chrging_stg="";
			String sql="select nvl(OPER_ROOM_FINALIZATION_STAGE,'X') from ot_param_for_facility where operating_facility_id ='"+facility_id+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				oper_room_chrging_stg=rst.getString(1);
			}	
    	  out.println(oper_room_chrging_stg);

		}else if(func_mode.equalsIgnoreCase("callChargeUnits")){	

			String sql="{call BL_PROC_ITEM_VALIDATIONS_MP. OT_CAL_RES_USAGE_UNITS('"+facility_id+"','OT','"+oper_room_code+"',to_date('"+chk_in_dt_time+"','DD/MM/YYYY HH24:MI'),to_date('"+chk_out_dt_time+"','DD/MM/YYYY HH24:MI'),null,?,?,?,?,?)}";
			cstmt=con.prepareCall(sql);
			cstmt.registerOutParameter(1,Types.VARCHAR);
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.VARCHAR);
			cstmt.registerOutParameter(5,Types.VARCHAR);
			cstmt.executeQuery();
			no_of_units=cstmt.getString(1);
			bill_serv_code=checkForNull(cstmt.getString(2));
			strErrorCode=checkForNull(cstmt.getString(3));
			strSysMsgId=checkForNull(cstmt.getString(4));
			strErrText=checkForNull(cstmt.getString(5));
			sbr.append(no_of_units).append(sep).append(bill_serv_code).append(sep).append(strErrorCode).append(sep).append(strSysMsgId).append(sep).append(strErrText);
			out.println(sbr.toString());
		}else if(func_mode.equalsIgnoreCase("callServPanel")){
			if(pstmt!=null)pstmt.close();
			if(rst!=null)rst.close();
			String sql="SELECT ENCOUNTER_ID, VISIT_ID, EPISODE_ID,EPISODE_TYPE,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				encounter_id=checkForNull(rst.getString(1));
				visit_id=checkForNull(rst.getString(2));		
				episode_id=checkForNull(rst.getString(3));	
				episode_type=checkForNull(rst.getString(4));		
				patient_class=checkForNull(rst.getString(5));		
			}
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
			pstmt = con.prepareStatement(sql_bl_episode_type);
			rst = pstmt.executeQuery();
			while(rst.next()){
				bl_episode_type=checkForNull(rst.getString(1));		

			}
			if(bl_episode_type.equals("")){
				bl_episode_type=episode_type;
			}
			if(!encounter_id.equals("")){
				String serv_panel_proc="{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+facility_id+"','"+module_id+"','"+order_id+"',null,'"+bl_episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"',null,sysdate,'"+oper_code+"','S','"+serv_code+"','"+units+"',null,'P','"+surgeon_code+"',?,?,?,?,?,?,null,null,?,?,?,'"+locale+"',?,?,?)}";
				cstmt=con.prepareCall(serv_panel_proc);
				cstmt.registerOutParameter(1,Types.VARCHAR);
				cstmt.registerOutParameter(2,Types.VARCHAR);
				cstmt.registerOutParameter(3,Types.VARCHAR);
				cstmt.registerOutParameter(4,Types.VARCHAR);
				cstmt.registerOutParameter(5,Types.VARCHAR);
				cstmt.registerOutParameter(6,Types.VARCHAR);
				cstmt.registerOutParameter(7,Types.VARCHAR);
				cstmt.registerOutParameter(8,Types.VARCHAR);
				cstmt.registerOutParameter(9,Types.VARCHAR);
				cstmt.registerOutParameter(10,Types.VARCHAR);
				cstmt.registerOutParameter(11,Types.VARCHAR);
				cstmt.registerOutParameter(12,Types.VARCHAR);
				cstmt.executeQuery();
				panel_string=cstmt.getString(1);
				chrg_based_yn=checkForNull(cstmt.getString(2));
				total_amt=checkForNull(cstmt.getString(3));
				pat_payable_amt=checkForNull(cstmt.getString(4));
				excl_incl_ind=checkForNull(cstmt.getString(5));	
				preapp_yn=checkForNull(cstmt.getString(6));	
				pat_paid_amt=checkForNull(cstmt.getString(7));	
				charged_yn=checkForNull(cstmt.getString(8));	
				pat_billed_yn=checkForNull(cstmt.getString(9));	
				error_lvl=checkForNull(cstmt.getString(10));	
				sts_mess_id=checkForNull(cstmt.getString(11));	
				err_txt=checkForNull(cstmt.getString(12));	
			}
			sbr.append(panel_string).append(splitter).append(chrg_based_yn).append(splitter).append(total_amt).append(splitter).append(strSysMsgId).append(pat_payable_amt).append(excl_incl_ind).append(splitter).append(preapp_yn).append(splitter).append(pat_paid_amt).append(splitter).append(charged_yn).append(splitter).append(pat_billed_yn).append(splitter).append(error_lvl).append(splitter).append(sts_mess_id).append(sep).append(err_txt);
			out.println(sbr.toString());
		}
	}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from OperRoomChargeUnits..jsp :"+e);
		}
		finally{
			if(sbr!=null)sbr.setLength(0);
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(cstmt!=null)cstmt.close();
			if(con!=null) con.close();
		}
%>

