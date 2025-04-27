<!DOCTYPE html>

<%@page   import="eOT.*,eOT.Common.*, eCommon.Common.CommonBean,java.util.HashMap,java.util.Hashtable,java.sql.Connection,  java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String params = request.getQueryString();
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String) hash.get( "bean_id" );
	String bean_name	= (String) hash.get( "bean_name" );
	String facility_id	= (String)session.getValue("facility_id");
	String booking_num	= (String)hash.get("booking_num");
	String oper_num		= (String)hash.get("oper_num");
	String patient_id	= (String)hash.get("patient_id");
	String set_code		= (String)hash.get("set_code");
	String oper_code	= (String)hash.get("oper_code");
	String tray_num		= (String)hash.get("tray_num");
	String func_mode= request.getParameter("func_mode");
try{
	if(func_mode!= null && func_mode.equals("item_confirm")){
		String initial_status_cmpl_yn	= (String)hash.get("initial_status_cmpl_yn");
		String final_status_cmpl_yn		= (String)hash.get("final_status_cmpl_yn");
		int tot_count			= Integer.parseInt((String)hash.get("tot_count"));
		String item_code= "", cssd_qty = "", open_qty = "",initial_status	= "",return_qty		= "",final_status		= "",finalized_yn		= "",initial_remarks	= "",final_remarks	= "",general_remarks	= "";
		booking_num	=booking_num==null?"":booking_num;
		booking_num	=booking_num.equalsIgnoreCase("null")?"":booking_num;
		oper_num	=oper_num==null?"":oper_num;
		oper_num	=oper_num.equalsIgnoreCase("null")?"":oper_num;
		InstrumentCountBean bean = (InstrumentCountBean)mh.getBeanObject( bean_id, request, bean_name );
		HashMap set_map = new HashMap();
		HashMap new_set_map = new HashMap();
		HashMap temp_map = new HashMap();
		set_map=bean.getSetDetails(oper_code+set_code+tray_num);
		for(int i=1;i<=tot_count;i++){
			temp_map = (HashMap)set_map.get(i+"");
			item_code 		= (String)hash.get("item_code_"+i);
			cssd_qty		= (String)hash.get("cssd_qty_"+i);
			open_qty		= (String)hash.get("open_qty_"+i);
			initial_status	= (String)hash.get("initial_status_"+i);
			return_qty		= (String)hash.get("return_qty_"+i);
			final_status	= (String)hash.get("final_status_"+i);
			finalized_yn	= (String)hash.get("finalized_yn_"+i);
			initial_remarks	= (String)hash.get("initial_status_remarks_"+i);
			initial_remarks=java.net.URLDecoder.decode(initial_remarks,"UTF-8");
			final_remarks	= (String)hash.get("final_remarks_"+i);
			final_remarks=java.net.URLDecoder.decode(final_remarks,"UTF-8");
			general_remarks	= (String)hash.get("general_remarks_"+i);
			general_remarks=java.net.URLDecoder.decode(general_remarks,"UTF-8");
			temp_map.put("CSSD_QTY",cssd_qty);
			temp_map.put("OPEN_QTY",open_qty);
			temp_map.put("INITIAL_STATUS",initial_status);
			temp_map.put("RETURN_QTY",return_qty);
			temp_map.put("INITIAL_STATUS_REMARKS",initial_remarks);
			temp_map.put("FINAL_STATUS",final_status);
			temp_map.put("FINAL_REMARKS",final_remarks);
			temp_map.put("GENERAL_REMARKS",general_remarks);
			temp_map.put("INITIAL_STATUS_CMPL_YN",initial_status_cmpl_yn);
			temp_map.put("FINAL_STATUS_CMPL_YN",final_status_cmpl_yn);			
			temp_map.put("UPDATE_FLAG","Y");
			new_set_map.put(i+"",temp_map);
		}
		bean.removeSetDetails(set_code+tray_num+item_code);
		bean.storeSetDetails(set_code+tray_num+item_code,new_set_map);
		}else if(func_mode!= null && func_mode.equals("check_tray_duplication")){
			Connection connection   = null ;
			PreparedStatement pstmt = null ;
			ResultSet rs = null ;
			try{
				int tray_exists = 0;
				String sql	= "SELECT COUNT(*) TRAY_EXISTS FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID=? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND SET_CODE=? AND TRAY_NUM =?";
				connection	= ConnectionManager.getConnection(request);
				pstmt	= connection.prepareStatement(sql) ;
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,booking_num);
				pstmt.setString(4,oper_num);
				pstmt.setString(5,set_code);
				pstmt.setString(6,tray_num);
				rs		= pstmt.executeQuery();
				while(rs!=null && rs.next()){
					tray_exists = rs.getInt("TRAY_EXISTS");
				}
				// The below codes are passed to JS only to check the validation.
				// DUPLICATE_FOUND and NO_DUPLICATE_FOUND are not message keys.
				if(tray_exists>0){
					out.println("DUPLICATE_FOUND");
				}else{					
					out.println("NO_DUPLICATE_FOUND");
				}								
			}catch ( Exception e ) {
				System.err.println("Caught Exception error in InstrumentCountCreateSet: "+e);
				e.printStackTrace() ;
			}finally {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(connection!=null) ConnectionManager.returnConnection(connection,request);
			}
		}
	}catch( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountValidation: "+e);
		e.printStackTrace();
	}finally {
		try{
		}catch(Exception es){es.printStackTrace();}
	}
%>


