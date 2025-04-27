<!DOCTYPE html>
<%@page  import ="java.sql.*,webbeans.eCommon.ConnectionManager,eOT.OTBillingBean"contentType="text/html;charset=UTF-8" %>
<%  request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

 <%
	String locale               = (String)session.getAttribute("LOCALE"); 
	String func_mode            = request.getParameter("func_mode") ;
	String facility_id			= checkForNull(request.getParameter( "facility_id" )) ;
	String chk_in_dt_time		= checkForNull(request.getParameter( "chk_in_dt_time" )) ;
	String chk_out_dt_time		= checkForNull(request.getParameter( "chk_out_dt_time" )) ;
	String recovery_room_code	= checkForNull(request.getParameter( "recovery_room_code" )) ;
	String units				= checkForNull(request.getParameter( "units" )) ;
	String serv_code			= checkForNull(request.getParameter( "serv_code" )) ;
	String module_id			= checkForNull(request.getParameter( "module_id" )) ;
	String patient_id			= checkForNull(request.getParameter( "patient_id" )) ;
	String order_id				= checkForNull(request.getParameter( "order_id" )) ;
	String oper_code			= checkForNull(request.getParameter( "oper_code" )) ;
	String surgeon_code			= checkForNull(request.getParameter( "surgeon_code" )) ;
	String oper_room_code		= checkForNull(request.getParameter( "oper_room_code" )) ;
	String change_holding_code	= checkForNull(request.getParameter( "change_holding_code" )) ;
	String order_line_num		= checkForNull(request.getParameter( "order_line_num" )) ;
	String encounter_id		    = checkForNull(request.getParameter( "encounter_id" )) ;
	String episode_id		    = checkForNull(request.getParameter( "episode_id" )) ;
	String episode_type		    = checkForNull(request.getParameter( "episode_type" )) ;
	String visit_id		        = checkForNull(request.getParameter( "visit_id" )) ;
	String no_of_units		    = "";		
	String bill_serv_code	    = "";		
	String strErrorCode		    = "";		
	String strSysMsgId		    = "";
	String strErrText		    = "";
	String panel_string		    = "";
	String chrg_based_yn	    = "";
	String total_amt		    = "";
	String pat_payable_amt	    = "";
	String excl_incl_ind	    = "";
	String preapp_yn		    = "";
	String pat_paid_amt		    = "";
	String charged_yn		    = "";
	String pat_billed_yn	    = "";
	String error_lvl		    = "";
	String sts_mess_id		    = "";
	String err_txt			    = "";
	String sep	                = "##";
	String splitter	            = "$$";
	/*String patient_class		= checkForNull(request.getParameter( "patient_class" )) ;
	String speciality_code		= checkForNull(request.getParameter( "speciality_code" )) ;
	String booking_num			= checkForNull(request.getParameter( "booking_num" )) ;
	String oper_num				= checkForNull(request.getParameter( "oper_num" )) ;
	String params			    = checkForNull(request.getParameter( "params" )) ;
	String encounter_id		    = "";		
	String visit_id			    = "";		
	String episode_id		    = "";		
	String episode_type		    = "";
	String patient_class	    = "";
	String bl_episode_type	    = "";*/		
    StringBuilder sbr           = new StringBuilder();
	Connection con              = null;
	PreparedStatement pstmt     = null;
	CallableStatement cstmt     = null;
	ResultSet rst               = null;

	try{
		con = ConnectionManager.getConnection(request);
		
		if(func_mode.equalsIgnoreCase("callChargeUnits")){	
			String sql="{call BL_PROC_ITEM_VALIDATIONS_MP. OT_CAL_RES_USAGE_UNITS('"+facility_id+"','RR','"+recovery_room_code+"',to_date('"+chk_in_dt_time+"','MM/DD/YYYY HH24:MI'),to_date('"+chk_out_dt_time+"','MM/DD/YYYY HH24:MI'),null,?,?,?,?,?)}";
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
			if(!encounter_id.equals("")){
				String serv_panel_proc="{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+facility_id+"','"+module_id+"','"+order_id+"','"+order_line_num+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"',null,sysdate,'"+oper_code+"','S','"+serv_code+"','"+units+"',null,'P','"+surgeon_code+"',?,?,?,?,?,?,null,null,?,?,?,'"+locale+"',?,?,?)}";
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
			sbr.append(panel_string).append(splitter).append(chrg_based_yn).append(splitter).append(total_amt).append(splitter).append(strSysMsgId).append(splitter).append(pat_payable_amt).append(splitter).append(excl_incl_ind).append(splitter).append(preapp_yn).append(splitter).append(pat_paid_amt).append(splitter).append(charged_yn).append(splitter).append(pat_billed_yn).append(splitter).append(error_lvl).append(splitter).append(sts_mess_id).append(sep).append(err_txt);
			out.println(sbr.toString());
		}else if(func_mode.equalsIgnoreCase("callORChargeUnits")){	

			String sql="{call BL_PROC_ITEM_VALIDATIONS_MP.OT_CAL_RES_USAGE_UNITS('"+facility_id+"','OT','"+oper_room_code+"',to_date('"+chk_in_dt_time+"','MM/DD/YYYY HH24:MI'),to_date('"+chk_out_dt_time+"','MM/DD/YYYY HH24:MI'),null,?,?,?,?,?)}";
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
		}else if(func_mode.equalsIgnoreCase("callHAChargeUnits")){	
			String sql="{call BL_PROC_ITEM_VALIDATIONS_MP. OT_CAL_RES_USAGE_UNITS('"+facility_id+"','HB','"+change_holding_code+"',to_date('"+chk_in_dt_time+"','MM/DD/YYYY HH24:MI'),to_date('"+chk_out_dt_time+"','MM/DD/YYYY HH24:MI'),null,?,?,?,?,?)}";
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
		}
	}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from HoldingAreaChargeUnits..jsp :"+e);
		}
		finally{
			if(sbr!=null)sbr.setLength(0);
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(cstmt!=null)cstmt.close();
			if(con!=null) con.close();
		}
%>

