package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eOH.*;
import eOR.OrderEntryBillingQueryBean;
import webbeans.eCommon.ConnectionManager;

public final class __dentaltrmtvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eoh/jsp/DentalTrmtValidation.jsp", 1709117115685L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	CallableStatement cstmt= null ;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	PreparedStatement pstmt_task = null;
	PreparedStatement pstmt_trmt_update = null;
	PreparedStatement pstmt_order_line_update = null;
	ResultSet rs = null;
	String facility_id      = (String) session.getAttribute("facility_id");
	String login_user      = (String) session.getAttribute("login_user");
	String practitioner_id = (String)session.getValue("ca_practitioner_id") ;

	//String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = prop.getProperty( "client_ip_address" );

	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("getTaskStatus")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;
			String task_status = "";
		
			pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TASK_CODE = ? AND TASK_SEQ = ?");
			
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,task_code);
			pstmt.setString(5,seq_no);
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				task_status = rst.getString("STATUS");
			}
			out.println(task_status);
		}else if(func_mode.equalsIgnoreCase("updateFacilityId")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" ));
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;
							 					
			int update_Task_Facility_Id_flag=0;
		
			pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET OPERATING_FACILITY_ID=? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ=?");
			
			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			pstmt.setString(5,trmt_code);
			pstmt.setString(6,task_code);
			pstmt.setString(7,seq_no);
			
			update_Task_Facility_Id_flag = pstmt.executeUpdate();
		
			if(update_Task_Facility_Id_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
		   	out.println(update_Task_Facility_Id_flag);
		}else if(func_mode.equalsIgnoreCase("getFacilityId")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;
			String registeredFacilityId = "";

			pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TASK_CODE = ? AND TASK_SEQ = ? ");
			
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,task_code);
			pstmt.setString(5,seq_no);
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				registeredFacilityId = rst.getString("OPERATING_FACILITY_ID");
			}
			out.println(registeredFacilityId);
		}else if(func_mode.equalsIgnoreCase("getOrderingFacilityId")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String order_id	= checkForNull(request.getParameter( "order_id" )) ;
			String ordering_facility_Id = "";

			pstmt = con.prepareStatement("SELECT ORDERING_FACILITY_ID FROM OR_ORDER WHERE PATIENT_ID = ? AND ORDER_ID = ?");
			
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,order_id);
			
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				ordering_facility_Id = rst.getString("ORDERING_FACILITY_ID");
			}
			out.println(ordering_facility_Id);
		}else if(func_mode.equalsIgnoreCase("getMaxChartNum")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_status	= checkForNull(request.getParameter( "chart_status" )) ;

			String chart_num = "";
			pstmt = con.prepareStatement("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR A WHERE PATIENT_ID = ? AND CHART_STATUS=? ");
			
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_status);
						
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				chart_num = rst.getString("CHART_NUM");
			}
			out.println(chart_num);
		}else if(func_mode.equalsIgnoreCase("getEncounterDetails")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;
							
			String encounter_id = "";
			String episode_id = "";
			String visit_id = "";
			String order_id = "";
			

			pstmt = con.prepareStatement("SELECT ENCOUNTER_ID, EPISODE_ID, VISIT_ID,ORDER_ID FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM =? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
			//pstmt = con.prepareStatement("SELECT ENCOUNTER_ID, EPISODE_ID, VISIT_ID FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM =? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");

			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,seq_no);

			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				encounter_id = checkForNull(rst.getString("ENCOUNTER_ID"));
				episode_id = checkForNull(rst.getString("EPISODE_ID"));
				visit_id = checkForNull(rst.getString("VISIT_ID"));
				order_id = checkForNull(rst.getString("ORDER_ID"));
			}
			out.println(encounter_id+"##"+episode_id+"##"+visit_id+"##"+order_id);
		}else if(func_mode.equalsIgnoreCase("getScheduledDateTime")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" ));
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;
			String schedule_date_time = "";
		
			pstmt=con.prepareStatement("SELECT SCHEDULE_DATE_TIME FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE=? AND TASK_CODE=? AND TASK_SEQ = ?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,seq_no);
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				schedule_date_time = rst.getString("SCHEDULE_DATE_TIME");
			}

		   	out.println(schedule_date_time);
		}else if(func_mode.equalsIgnoreCase("getOrderSetBillDetails")){
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" ));
			String order_set_bill_yn = "";
			
			pstmt=con.prepareStatement("SELECT BILL_YN FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = (SELECT  ORDER_CATALOG_CODE FROM OH_TREATMENT WHERE TRMT_CODE=?)");
			pstmt.setString(1,trmt_code);
							
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				order_set_bill_yn = rst.getString("BILL_YN");
			}
			out.println(order_set_bill_yn);
		}else if(func_mode.equalsIgnoreCase("getCrownAndRootCount")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no 	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level 	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			
			int crown_root_count = 0;
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT COUNT(*)RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO =? AND (SITE_TYPE='CROWN' OR SITE_TYPE= 'ROOT')");
				
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT COUNT(*)RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO =? AND (SITE_TYPE='CROWN' OR SITE_TYPE= 'ROOT')");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				crown_root_count = Integer.parseInt(rst.getString("RECORD_COUNT"));
			}
			out.println(crown_root_count);
		} else if(func_mode.equalsIgnoreCase("getSurfaceCode")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no 	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level 	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			
			String condition_type = "";
			String surface_code_int = "";
			String site_type = "";

		    StringBuffer condition_type_surface_code = new StringBuffer();
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE,SURFACE_CODE,SITE_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND (SITE_TYPE='CROWN' OR SITE_TYPE= 'ROOT')");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE,SURFACE_CODE,SITE_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND (SITE_TYPE='CROWN' OR SITE_TYPE= 'ROOT')");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);			
			}
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				condition_type = rst.getString("CONDITION_TYPE");
				surface_code_int = rst.getString("SURFACE_CODE");
				site_type = rst.getString("SITE_TYPE");
				condition_type_surface_code.append(condition_type+"##"+surface_code_int+"##"+site_type);
				condition_type_surface_code.append("~");
			}
			out.println(condition_type_surface_code);
		}
		else if(func_mode.equalsIgnoreCase("updateTrmtStatusForNullOrderId")){
			String patient_id		= checkForNull(request.getParameter( "patient_id" ));
			String chart_num		= checkForNull(request.getParameter( "chart_num" ));
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" ));
			String trmt_code		= checkForNull(request.getParameter( "trmt_code" ));
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" ));
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" ));
			String reasonforcancel	= checkForNull(request.getParameter( "reasonforcancel" ));
			String order_status_type	= checkForNull(request.getParameter( "order_status_type" ));

			int flag = 0;
			String frame_msg = "";
			ArrayList flag_arr= new ArrayList();
			
							
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(oh_chart_level.equals("E")) {
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE=?");
				pstmt.setString(1,order_status_type);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,reasonforcancel);
				pstmt.setString(6,login_user);
				pstmt.setString(7,patient_id);
				pstmt.setString(8,chart_num);
				pstmt.setString(9,chart_line_num);
				pstmt.setString(10,trmt_code);
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				pstmt_trmt_update=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE=?");
				
				pstmt_trmt_update.setString(1,order_status_type);
				pstmt_trmt_update.setString(2,login_user);
				pstmt_trmt_update.setString(3,client_ip_address);
				pstmt_trmt_update.setString(4,facility_id);
				pstmt_trmt_update.setString(5,reasonforcancel);
				pstmt_trmt_update.setString(6,login_user);
				pstmt_trmt_update.setString(7,patient_id);
				pstmt_trmt_update.setString(8,chart_num);
				pstmt_trmt_update.setString(9,chart_line_num);
				pstmt_trmt_update.setString(10,trmt_code);
				flag = pstmt_trmt_update.executeUpdate();
				flag_arr.add(""+flag);

			}else{
			   if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE = ?");
				pstmt.setString(1,order_status_type);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,reasonforcancel);
				pstmt.setString(6,login_user);
				pstmt.setString(7,other_chart_facility_id);
				pstmt.setString(8,patient_id);
				pstmt.setString(9,chart_num);
				pstmt.setString(10,chart_line_num);
				pstmt.setString(11,trmt_code);
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				pstmt_trmt_update=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE = ?");
				
				pstmt_trmt_update.setString(1,order_status_type);
				pstmt_trmt_update.setString(2,login_user);
				pstmt_trmt_update.setString(3,client_ip_address);
				pstmt_trmt_update.setString(4,facility_id);
				pstmt_trmt_update.setString(5,reasonforcancel);
				pstmt_trmt_update.setString(6,login_user);
				pstmt_trmt_update.setString(7,other_chart_facility_id);
				pstmt_trmt_update.setString(8,patient_id);
				pstmt_trmt_update.setString(9,chart_num);
				pstmt_trmt_update.setString(10,chart_line_num);
				pstmt_trmt_update.setString(11,trmt_code);
				flag = pstmt_trmt_update.executeUpdate();
				flag_arr.add(""+flag);
				
			}
			if(!flag_arr.contains("0")){
				frame_msg = "GET_MSG";
				con.commit();
			}else{
				frame_msg = "";
				con.rollback();
			}
			out.println(frame_msg);

		}
		else if(func_mode.equalsIgnoreCase("updateTaskStatusForNullOrderId")){
			String patient_id		= checkForNull(request.getParameter( "patient_id" ));
			String chart_num		= checkForNull(request.getParameter( "chart_num" ));
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" ));
			String trmt_code		= checkForNull(request.getParameter( "trmt_code" ));
			String task_code		= checkForNull(request.getParameter( "task_code" ));
			String task_seq_no		= checkForNull(request.getParameter( "task_seq_no" ));
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" ));
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" ));
			String reasonforcancel	= checkForNull(request.getParameter( "reasonforcancel" ));
			String order_status_type	= checkForNull(request.getParameter( "order_status_type" ));

			int flag = 0;
			String frame_msg = "";
			ArrayList flag_arr= new ArrayList();
			
							
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(oh_chart_level.equals("E")) {
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE=? ");
				pstmt.setString(1,order_status_type);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,reasonforcancel);
				pstmt.setString(6,login_user);
				pstmt.setString(7,patient_id);
				pstmt.setString(8,chart_num);
				pstmt.setString(9,chart_line_num);
				pstmt.setString(10,trmt_code);
				
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				pstmt_trmt_update=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				
				pstmt_trmt_update.setString(1,order_status_type);
				pstmt_trmt_update.setString(2,login_user);
				pstmt_trmt_update.setString(3,client_ip_address);
				pstmt_trmt_update.setString(4,facility_id);
				pstmt_trmt_update.setString(5,reasonforcancel);
				pstmt_trmt_update.setString(6,login_user);
				pstmt_trmt_update.setString(7,patient_id);
				pstmt_trmt_update.setString(8,chart_num);
				pstmt_trmt_update.setString(9,chart_line_num);
				pstmt_trmt_update.setString(10,trmt_code);
				pstmt_trmt_update.setString(11,task_code);
				pstmt_trmt_update.setString(12,task_seq_no);
				flag = pstmt_trmt_update.executeUpdate();
				flag_arr.add(""+flag);
				
			}else{
			   if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE = ?");
				pstmt.setString(1,order_status_type);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,reasonforcancel);
				pstmt.setString(6,login_user);
				pstmt.setString(7,other_chart_facility_id);
				pstmt.setString(8,patient_id);
				pstmt.setString(9,chart_num);
				pstmt.setString(10,chart_line_num);
				pstmt.setString(11,trmt_code);

				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				pstmt_trmt_update=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				
				pstmt_trmt_update.setString(1,order_status_type);
				pstmt_trmt_update.setString(2,login_user);
				pstmt_trmt_update.setString(3,client_ip_address);
				pstmt_trmt_update.setString(4,facility_id);
				pstmt_trmt_update.setString(5,reasonforcancel);
				pstmt_trmt_update.setString(6,login_user);
				pstmt_trmt_update.setString(7,other_chart_facility_id);
				pstmt_trmt_update.setString(8,patient_id);
				pstmt_trmt_update.setString(9,chart_num);
				pstmt_trmt_update.setString(10,chart_line_num);
				pstmt_trmt_update.setString(11,trmt_code);
				pstmt_trmt_update.setString(12,task_code);
				pstmt_trmt_update.setString(13,task_seq_no);
				flag = pstmt_trmt_update.executeUpdate();
				flag_arr.add(""+flag);
				
			}
			if(!flag_arr.contains("0")){
				frame_msg = "GET_MSG";
				con.commit();
			}else{
				frame_msg = "";
				con.rollback();
			}
			out.println(frame_msg);

		}
		else if(func_mode.equalsIgnoreCase("updateTrmtStatus")){
			String order_status_type		= checkForNull(request.getParameter( "order_status_type" ));
			String order_id					= checkForNull(request.getParameter( "order_id" ));
			String reasonforcancel			= checkForNull(request.getParameter( "reasonforcancel" ));
			String frame_msg = "";
			int flag = 0;
			int flag_order_line = 0;
			
			ArrayList flag_arr= new ArrayList();
					
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(order_status_type.equals("E")){

				// Update the order_line_status in or_order_line table:
				if(pstmt != null) pstmt.close();
				//pstmt = con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_DATE_TIME=SYSDATE, CAN_LINE_REASON=?, CAN_PRACT_ID=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
				pstmt = con.prepareStatement("UPDATE OR_ORDER SET ORDER_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=?");
				// Practitioner_id is to be updated for CAN_PRACT_ID instead of login_user
				//pstmt.setString(1,reasonforcancel);
				//pstmt.setString(2,login_user); // Pass the ca_practitioner_id
				//pstmt.setString(2,practitioner_id); // Pass the ca_practitioner_id
				pstmt.setString(1,login_user); 
				pstmt.setString(2,client_ip_address);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,order_id);
				//pstmt.setString(7,order_line_num);
				flag = pstmt.executeUpdate();

				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}

				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE ORDER_ID =?");
				pstmt.setString(1,order_status_type);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,reasonforcancel);
				pstmt.setString(6,login_user);
				pstmt.setString(7,order_id);
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}

				pstmt_task=con.prepareStatement("SELECT ORDER_ID FROM OR_ORDER_LINE WHERE ORDER_SET_ID =? ");
				pstmt_task.setString(1,order_id);
				rs = pstmt_task.executeQuery();
				while(rs.next()){
					
					pstmt_trmt_update=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET STATUS = ?, COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, CANCEL_REASON = ?, CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE ORDER_ID =?");

					pstmt_trmt_update.setString(1,order_status_type);
					pstmt_trmt_update.setString(2,login_user);
					pstmt_trmt_update.setString(3,client_ip_address);
					pstmt_trmt_update.setString(4,facility_id);
					pstmt_trmt_update.setString(5,reasonforcancel);
					pstmt_trmt_update.setString(6,login_user);
					pstmt_trmt_update.setString(7,rs.getString("ORDER_ID"));
					flag = pstmt_trmt_update.executeUpdate();
					flag_arr.add(""+flag);

					pstmt_order_line_update=con.prepareStatement("UPDATE OR_ORDER_LINE SET ORDER_LINE_STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '99'), CAN_DATE_TIME=SYSDATE, CAN_PRACT_ID=?, CAN_LINE_REASON=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_SET_ID=?");
				
					pstmt_order_line_update.setString(1,practitioner_id); // Pass the ca_practitioner_id
					pstmt_order_line_update.setString(2,reasonforcancel); 
					pstmt_order_line_update.setString(3,login_user); 
					pstmt_order_line_update.setString(4,client_ip_address);
					pstmt_order_line_update.setString(5,facility_id);
					pstmt_order_line_update.setString(6,order_id);
					
					flag_order_line = pstmt_order_line_update.executeUpdate();
					flag_arr.add(""+flag_order_line);
					
				}
			}
			if(!flag_arr.contains("0")){
				frame_msg = "GET_MSG";
				con.commit();
			}else{
				frame_msg = "";
				con.rollback();
			}
		
			out.println(frame_msg);
		    
		}
		else if(func_mode.equalsIgnoreCase("getTaskStatusForTrmtCancel")) {
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
										
					
			String task_status_for_cancel = "";
			String flag_for_cancel = "";
		
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){

				//pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE = ? ");
				pstmt = con.prepareStatement("SELECT  DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE = ? ");
			
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
			}else{
				//pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE = ? ");
				pstmt = con.prepareStatement("SELECT  DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE = ? ");
			
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);			
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				task_status_for_cancel = checkForNull(rst.getString("STATUS"));
				if(task_status_for_cancel.equals("25") || task_status_for_cancel.equals("52") || task_status_for_cancel.equals("53") ||  task_status_for_cancel.equals("55") || task_status_for_cancel.equals("60") || task_status_for_cancel.equals("80") || task_status_for_cancel.equals("85")){
					flag_for_cancel = "N";
					break;
				}
				else{
					flag_for_cancel = "Y";				
				}
			}
			out.println(flag_for_cancel);
		}
		 else if(func_mode.equalsIgnoreCase("insertNewTask")){	
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String chart_line_num = request.getParameter("chart_line_num");
			String trmt_code = request.getParameter("trmt_code");
			String task_code = request.getParameter("task_code");
			String order_set_id = request.getParameter("order_set_id");
			String order_set_line_num = request.getParameter("order_set_line_num");
			String encounter_id = request.getParameter("encounter_id");
			String episode_id = request.getParameter("episode_id");
			String visit_id = request.getParameter("visit_id");
			String patient_class = request.getParameter("patient_class");
			String seq_no = request.getParameter("seq_no");
			String task_seq_no = request.getParameter("task_seq_no");
			String source_code = request.getParameter("location_code") ;
			String source_type = request.getParameter("location_type") ;
			
			String task_status = "";
			String p_msg_txt = "";
			boolean flag_insert = false;
			
			int mark_error_count = 0;
			int outstanding_count = 0;
			int sch_count = 0;
			int register_count = 0;
			int progress_count = 0;
			int partial_count = 0;
			int resulted_count = 0;
			int resulted_RS_count = 0;

			int flag_dtl = 0;

			String update_error = "";
			String update_status = "";
			String update_sch = "";
			String update_register = "";
			String update_progress = "";
			String update_partial = "";
			String update_resulted = "";

			HashMap map = null;
		
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			cstmt=con.prepareCall("{call OH_PRC_INS_ORD_LINE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, facility_id );		// P_FACILITY_ID
			cstmt.setString(2, patient_id );		// P_PATIENT_ID 	
			cstmt.setString(3, order_set_id );		// P_ORD_SET_ID 		
			cstmt.setString(4, order_set_line_num );// P_ORD_SET_LINE 	
			cstmt.setString(5, encounter_id );		// P_ENCOUNTER_ID 
			cstmt.setString(6, episode_id );		// P_EPD_ID
			cstmt.setString(7, visit_id );		    // P_VISITID	 	
			cstmt.setString(8, patient_class );		// P_PAT_CLASS 
			cstmt.setString(9, source_type );		// P_SOURCE_TYPE 	
			cstmt.setString(10, source_code );		// P_SOURCE_CODE 
			cstmt.setString(11, task_code );		// P_TASK_CODE
			cstmt.setString(12, practitioner_id );	// P_PRCT_ID	
			cstmt.setString(13, trmt_code );		// P_TRMT_CODE	
			cstmt.setString(14, chart_num );		// P_CHART_NUM
			cstmt.setString(15, chart_line_num );	// P_CHART_LINE_NUM
			cstmt.setString(16, seq_no );			// P_SEQ_NO
			cstmt.setString(17, task_seq_no );		// P_TASK_SEQ 
			cstmt.setString(18, login_user );		// P_USER 
			cstmt.setString(19, client_ip_address );// P_WS_NO
			cstmt.registerOutParameter(20,Types.VARCHAR);	// P_TRACE
			cstmt.registerOutParameter(21,Types.VARCHAR);	// P_ERR_MSG	
			
			cstmt.execute();
			p_msg_txt = checkForNull(cstmt.getString(21));
			
			if(p_msg_txt.equals("")){
				flag_insert = true;
				con.commit();
			}
			else{
				flag_insert = false;
				con.rollback();
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			int j=0;
			map = new HashMap();
			//pstmt = con.prepareStatement("SELECT STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
			//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
			//pstmt = con.prepareStatement("SELECT DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");				
			pstmt = con.prepareStatement("SELECT DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");				
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			rs=pstmt.executeQuery();
			while(rs.next()){
				task_status = checkForNull(rs.getString("STATUS"));
				map.put(j,task_status);
				j++;
			}
			int map_size = map.size();

			for(int k=0;k<map_size;k++){
				if(map.get(k).equals("E")){
					mark_error_count++;
				}

				else if(map.get(k).equals("10")){
					outstanding_count++;
				}
				
				else if(map.get(k).equals("15")){
					sch_count++;
				}

				else if(map.get(k).equals("25")){
					register_count++;
				}

				else if(map.get(k).equals("52")){
					progress_count++;
				}

				else if(map.get(k).equals("55")){
					partial_count++;
				}

				else if(map.get(k).equals("85")){
					resulted_RS_count++;
				}

				else if(map.get(k).equals("60")){
					resulted_count++;
				}
			}
			String insert_status_type = "";
			if(mark_error_count == map_size){
				update_error = "Y";
				insert_status_type = "E";
			}
			else if(outstanding_count > 0){
				update_status = "Y";
				insert_status_type = "10";
			}
			else if((map_size-mark_error_count) == sch_count){
				update_sch = "Y";
				insert_status_type = "15";
			}
			else if((map_size-mark_error_count) == register_count){
				update_register = "Y";
				insert_status_type = "25";
			}
			else if((map_size-mark_error_count) == progress_count){
				update_progress = "Y";
				insert_status_type = "52";
			}
			else if((map_size-mark_error_count) == partial_count){
				update_partial = "Y";
				insert_status_type = "55";
			}
			else if((map_size-mark_error_count) == resulted_count){
				update_resulted = "Y";
				insert_status_type = "60";
				//insert_status_type = "85";
			}
			else if((map_size-mark_error_count) == resulted_RS_count){
				update_resulted = "Y";
				insert_status_type = "85";
			}
			
			if(update_status != "N" && !insert_status_type.equals("")){
					/*
					if(pstmt != null) pstmt.close();
					pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? ,CANCEL_REASON = ?,CANCELLED_BY = ?, CANCELLED_DATE = SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ?");
					pstmt.setString(1,order_status_type);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,reasonforcancel);
					pstmt.setString(6,login_user);
					pstmt.setString(7,facility_id);
					pstmt.setString(8,patient_id);
					pstmt.setString(9,chart_num);
					pstmt.setString(10,chart_line_num);
					flag = pstmt.executeUpdate();
					*/
					// update only dtl
					if(pstmt != null) pstmt.close();
					//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
					//pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, OPERATING_FACILITY_ID=? WHERE PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt.setString(1,insert_status_type);
					pstmt.setString(2,login_user);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,chart_num);
					pstmt.setString(8,order_set_id);
					flag_dtl = pstmt.executeUpdate();
				}
			
			if(flag_dtl != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			
			out.println(flag_insert);
		}
		else if(func_mode.equalsIgnoreCase("getOrderSetId")) {
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String oh_chart_level 	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;						
			String order_set_id_val = "";
			
			if(oh_chart_level.equals("E")){				
						
				pstmt = con.prepareStatement("SELECT ORDER_ID FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE = ? ");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
			}else{
				pstmt = con.prepareStatement("SELECT ORDER_ID FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE = ? ");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);			
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				order_set_id_val = rst.getString("ORDER_ID");
			}
			out.println(order_set_id_val);
		}
		else if(func_mode.equalsIgnoreCase("getSeqNoOfTask")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String order_id	= checkForNull(request.getParameter( "order_id" )) ;
											
			String seq_no = "";
			String task_seq_no = "";

			pstmt = con.prepareStatement("SELECT SEQ_NO, TASK_SEQ FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND  TRMT_CODE =?  AND TASK_CODE = ? AND ORDER_ID = ?");
			
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,order_id);
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				seq_no = rst.getString("SEQ_NO");
				task_seq_no = rst.getString("TASK_SEQ");
			}
			out.println(seq_no+"##"+task_seq_no);
		}
		else if(func_mode.equalsIgnoreCase("getMaxSeqNoOfTask")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String oh_chart_level 	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;						
					
			String seq_no = "";
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT MAX(SEQ_NO) SEQ_NO FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND  TRMT_CODE =? ");
				
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
			}else{
				pstmt = con.prepareStatement("SELECT MAX(SEQ_NO) SEQ_NO FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND  TRMT_CODE =? ");
				
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);			
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				seq_no = rst.getString("SEQ_NO");
			}
			out.println(seq_no);
		}
		else if(func_mode.equalsIgnoreCase("getTaskCodeDesc")){
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code = "";
			String task_desc = "";

			pstmt = con.prepareStatement("SELECT A.TASK_CODE,(SELECT B.TASK_DESC FROM OH_TASKS B WHERE A.TASK_CODE = B.TASK_CODE) TASK_DESC FROM OH_TREATMENT_TASKS A WHERE A.TRMT_CODE = ? ");
				
			pstmt.setString(1,trmt_code);
						
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				task_code = rst.getString("TASK_CODE");
				task_desc = rst.getString("TASK_DESC");
			}
			out.println(task_code+"##"+task_desc);
		}
		else if(func_mode.equalsIgnoreCase("getOrderCatalogId")){  
		
			String order_id	= checkForNull(request.getParameter( "order_id" )) ;
							
					
			String order_encounter_id = "";
		
			//Commented by Sharon Crasta on 3/16/2009 for CRF #0423 for Facility/Enterprise Chart
			//pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TASK_CODE = ? ");
			//pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_TASKS A WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TASK_CODE = ? ");
			pstmt = con.prepareStatement("SELECT ORDER_ID FROM OH_RESTORATIVE_CHART_TASKS A WHERE ORDER_ID = ?");
			
			pstmt.setString(1,order_id);
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				order_encounter_id = rst.getString("ORDER_ID");
			}
			out.println(order_encounter_id);
		}else if(func_mode.equalsIgnoreCase("checkForGingivalRecordedData")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;

				
			int gingival_recorded = 0;
		
			/*pstmt=con.prepareStatement("SELECT COUNT(*) GINGIVAL_RECORDED FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'");
	
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no); */

			if(oh_chart_level.equals("E")){
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//pstmt=con.prepareStatement("SELECT COUNT(*) GINGIVAL_RECORDED FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'N' AND NVL(STATUS,'X') != 'C'");
				pstmt=con.prepareStatement("SELECT COUNT(*) GINGIVAL_RECORDED FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'");
	
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);

			}
			else{
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//pstmt=con.prepareStatement("SELECT COUNT(*) GINGIVAL_RECORDED FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X')!='E' AND NVL(STATUS,'X') != 'N'  AND NVL(STATUS,'X') != 'C'");
				pstmt=con.prepareStatement("SELECT COUNT(*) GINGIVAL_RECORDED FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X')!='E'");
	
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			
			} 
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				  gingival_recorded = Integer.parseInt(rst.getString("GINGIVAL_RECORDED"));
			}
			
		   	out.println(gingival_recorded);
		}else if(func_mode.equalsIgnoreCase("updateGingivalRecordedData")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			
			int update_gingival_recording = 0;
			
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = 'E' WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND NVL(STATUS,'X') != 'E'");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				
			}
			else{
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = 'E' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND NVL(STATUS,'X') != 'E' ");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
						
			} 
			update_gingival_recording = pstmt.executeUpdate();

			if(update_gingival_recording >= 1){
				con.commit();
			}
			else{
				con.rollback();
			}
		   	out.println(update_gingival_recording);
		}else if(func_mode.equalsIgnoreCase("checkForGingivalRecordedDecidData")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			
			int gingival_decid_recorded = 0;
		
			pstmt=con.prepareStatement("SELECT COUNT(*) GINGIVAL_RECORDED FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') = 'D'");
	
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);

			rst = pstmt.executeQuery();
			while(rst != null && rst.next()){
				  gingival_decid_recorded = Integer.parseInt(rst.getString("GINGIVAL_RECORDED"));
			}
			
		   	out.println(gingival_decid_recorded);
		}
		else if(func_mode.equalsIgnoreCase("checkActiveChartExists")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			
			int count_active = 0;
			
			if(oh_chart_level.equals("E")){
			   pstmt=con.prepareStatement("SELECT COUNT(*) COUNT_ACTIVE FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'");
	
				pstmt.setString(1,patient_id);
			}else{
				pstmt=con.prepareStatement("SELECT COUNT(*) COUNT_ACTIVE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A'");
	
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
			}

			rst = pstmt.executeQuery();
			while(rst != null && rst.next()){
				  count_active = Integer.parseInt(rst.getString("COUNT_ACTIVE"));
			}
			
		   	out.println(count_active);
		}
		else if(func_mode.equalsIgnoreCase("getDentistComments")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			
			String dentist_comments = "";
			
			if(oh_chart_level.equals("E")){
			   pstmt=con.prepareStatement("SELECT DENTIST_COMMENTS FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_NUM = ?");
	
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
			}else{
				pstmt=con.prepareStatement("SELECT DENTIST_COMMENTS FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ?");
	
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
			}

			rst = pstmt.executeQuery();
			while(rst != null && rst.next()){
				  dentist_comments = rst.getString("DENTIST_COMMENTS");
			}
			
		   	out.println(dentist_comments);
		}
		else if(func_mode.equalsIgnoreCase("getChartApplicableYN")){
			String task_order_catalog_code	= checkForNull(request.getParameter( "task_order_catalog_code" )) ;
			String chart_appl_yn = "";
			
			pstmt=con.prepareStatement("SELECT RESULT_APPLICABLE_YN FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = ?");
			pstmt.setString(1,task_order_catalog_code);
			rst = pstmt.executeQuery();
			while(rst != null && rst.next()){
				  chart_appl_yn = rst.getString("RESULT_APPLICABLE_YN");
			}
		   	out.println(chart_appl_yn);
		}
		else if(func_mode.equalsIgnoreCase("getCountOfCharts")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id 	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			int count_charts = 0;

			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT COUNT(*)COUNT_CHART FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=?");
				pstmt.setString(1,patient_id);
			}else {
				pstmt=con.prepareStatement("SELECT COUNT(*)COUNT_CHART FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID=?");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
			}
			rst=pstmt.executeQuery();
			while(rst.next()){
				count_charts = Integer.parseInt(checkForNull(rst.getString("COUNT_CHART")));
				
			}
			out.println(count_charts);
		}
		else if(func_mode.equalsIgnoreCase("countTreatmentOnTooth")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type	= checkForNull(request.getParameter( "condition_type" )) ;

			String sql = "";		
			String record_count = "";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			pstmt.setString(5,condition_type);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				record_count = checkForNull(rst.getString("RECORD_COUNT"));
				
			}
			out.println(record_count);
         }
		 else if(func_mode.equalsIgnoreCase("checkForExtraction")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			StringBuffer sqlBuffer = new StringBuffer();
			int trmt_category_type_count = 0;
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25', '52','54','55','60','70','75','85','90')) OR CONDITION_TYPE = 'MISSTH')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");//Added condition_type = 'MISSTH') becoause when recording plain missing tooth the menu was getting displayed.

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25', '52','54','55','60','70','75','85','90')) OR CONDITION_TYPE = 'MISSTH')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");	//Added condition_type = 'MISSTH') becoause when recording plain missing tooth the menu was getting displayed.
			
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));								
			}
			
			out.println(trmt_category_type_count);
         }
		 
		 else if(func_mode.equalsIgnoreCase("checkForExtractionOnTreatmentTab")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			String sql = "";		
			int trmt_category_type_count = 0;
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sql = "SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (60,85))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sql = "SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (60,85))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));								
			}
			out.println(trmt_category_type_count);
         }
		 else if(func_mode.equalsIgnoreCase("getRDNormalData")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			String supernumerary_yn = "";
			String mixed_dent_deciduous_yn = "";
			String condition_type = "";

			//StringBuffer condition_buffer = new StringBuffer();

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN  FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH','SUPRTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN  FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE IN ('EXTRACT') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);

			}else{
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN  FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH','SUPRTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN  FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE IN ('EXTRACT') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
				mixed_dent_deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));

			}
			out.println(condition_type+"##"+supernumerary_yn+"##"+mixed_dent_deciduous_yn);
		}
		 else if(func_mode.equalsIgnoreCase("checkForExtractionSupernumerary")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;

			String super_tooth_count = "";
			String super_tooth_no = "";
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			int trmt_category_type_count = 0;
			
			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			/*if(super_tooth_ref.equals("RD")){
				retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			} */

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				//TREATMENTS_OUTCOME is added in the where clause to get the menu on permanent tooth after extraction failure is recoreded on that tooth after retained deciduous tooth condition is recorded. By SRidevi Joshi on 4/5/2010 for IN020356
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25', '52','54','55', '60','65','70','75','80','85','90')))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X')) AND NVL(TREATMENTS_OUTCOME,'Z') != 'F'");

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);
			}else{
				//TREATMENTS_OUTCOME is added in the where clause to get the menu on permanent tooth after extraction failure is recoreded on that tooth after retained deciduous tooth condition is recorded. By SRidevi Joshi on 4/5/2010 for IN020356
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25', '52','54','55', '60','65','70','75','80','85','90')))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X')) AND NVL(TREATMENTS_OUTCOME,'Z') != 'F'");

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
			}
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));								
			}
			
			out.println(trmt_category_type_count);
         }
		  else if(func_mode.equalsIgnoreCase("checkForExtractionSupernumeraryTreatment")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String isRetndCondYN	= checkForNull(request.getParameter( "isRetndCondYN" )) ;
			String isSuperCondYN	= checkForNull(request.getParameter( "isSuperCondYN" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			int trmt_category_type_count = 0;
			String supernumerary_yn = "";

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(isSuperCondYN.equals("Y")){
				if(mixed_dentition_YN.equals("Y")){
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR")){
							supernumerary_yn="";
						}else {
							supernumerary_yn="Y";
						}
					}else{
						if(RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRP") || RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("N") || RD_Normal_yn.equals("") || RD_Normal_yn.equals("null") || RD_Normal_yn.equals(null) || RD_Normal_yn.equals("undefined")){//Added by Sharon Crasta on 11/26/2009 for IN016114 the null check value.
								supernumerary_yn="";
						}else {
								supernumerary_yn="Y";
						}	
					}
				}else{
				  if(permanent_deciduous_flag.equals("D")){
					  if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}
					  }else if(permanent_deciduous_flag.equals("P")){
						   if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}

					  }
				}
			}
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (10,15,25,52,55,60,65,70,75,80, 85,90)) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							//}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS") || RD_Normal_yn.equals("") || RD_Normal_yn.equals("null") || RD_Normal_yn.equals(null)){//Added by Sharon Crasta on 11/26/2009 for IN016114 the null check value.){ ){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (10,15,25,52,55,60,65,70,75,80, 85,90)) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							//}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS") ||  RD_Normal_yn.equals("") || RD_Normal_yn.equals("null") || RD_Normal_yn.equals(null)){//Added by Sharon Crasta on 11/26/2009 for IN016114 the null check value.){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}

				//pstmt = con.prepareStatement(sql);
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));							
			}
		
			out.println(trmt_category_type_count);
         }
		 else if(func_mode.equalsIgnoreCase("checkForExtractionSupernumeraryExtTrmt")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			int trmt_category_type_count = 0;
			String super_tooth_count = "";
			String super_tooth_no = "";

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}
			
			//StringBuffer allRecords_trmt = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
			if(oh_chart_level.equals("E")){
				//sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");
							
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);

			}else{
				//sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
			}
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));			
			}
			out.println(trmt_category_type_count);
         }
		 else if(func_mode.equalsIgnoreCase("countForPartiallyEruptedTooth")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String isRetndCondYN	= checkForNull(request.getParameter( "isRetndCondYN" )) ;
			String isSuperCondYN	= checkForNull(request.getParameter( "isSuperCondYN" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			int trmt_category_type_count = 0;
			String supernumerary_yn = "";
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			
			if(isSuperCondYN.equals("Y")){
				if(mixed_dentition_YN.equals("Y")){
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR")){
							supernumerary_yn="";
						}else {
							supernumerary_yn="Y";
						}
					}else{
						//Added by Sharon Crasta on 11/23/2009  RD_Normal_yn.equals("NS")
						if(RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRP") || RD_Normal_yn.equals("NS")){
								supernumerary_yn="";
							}else {
								supernumerary_yn="Y";
							}	
					}
				}else{
				  if(permanent_deciduous_flag.equals("D")){
					  if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}
					  }else if(permanent_deciduous_flag.equals("P")){
						   if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}

					  }
				}
			}
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				//sql = "SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (60,85)))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				sqlBuffer.append("SELECT COUNT(*) CONDITION_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND CONDITION_TYPE = 'PARERTH' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}

				//pstmt = con.prepareStatement(sql);
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				//sql = "SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN 	(SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (60,85)))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";

				sqlBuffer.append("SELECT COUNT(*) CONDITION_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND CONDITION_TYPE = 'PARERTH' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}

				//pstmt = con.prepareStatement(sql);
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("CONDITION_TYPE_COUNT"));								
			}
			out.println(trmt_category_type_count);
         }
		 else if(func_mode.equalsIgnoreCase("getExtractRecordedMissing")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String isRetndCondYN	= checkForNull(request.getParameter( "isRetndCondYN" )) ;
			String isSuperCondYN	= checkForNull(request.getParameter( "isSuperCondYN" )) ;
			String cond_trmt_type	= checkForNull(request.getParameter( "cond_trmt_type" )) ;
			
			StringBuffer allRecords_trmt = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			String condition_type1 = "";	
			String supernumerary_yn = "";

			if(isSuperCondYN.equals("Y")){
				if(mixed_dentition_YN.equals("Y")){
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR")){
							supernumerary_yn="";
						}else {
							supernumerary_yn="Y";
						}
					}else{
						if(RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRP") || RD_Normal_yn.equals("NS")){
								supernumerary_yn="";
							}else {
								supernumerary_yn="Y";
							}	
					}
				}else{
				  if(permanent_deciduous_flag.equals("D")){
					  if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}
					  }else if(permanent_deciduous_flag.equals("P")){
						   if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}

					  }
				}
			}
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
		
			//sqlBuffer.append("SELECT TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			sqlBuffer.append("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE = ?" );

			if(isSuperCondYN.equals("Y")){
				if(supernumerary_yn.equals("Y")){
					sqlBuffer.append(" AND SUPERNUMERARY_YN='Y'");
				}else{
					sqlBuffer.append(" AND SUPERNUMERARY_YN IS NULL");
				}
			}
			
			if(isRetndCondYN.equals("Y")){
				if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
					if(RD_Normal_yn.equals("RD")){
						sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
					}else{
						sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
					}
				}else if(mixed_dentition_YN.equals("Y")){	
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
						   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(permanent_deciduous_flag.equals("D")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}
				}
			}

			pstmt=con.prepareStatement(sqlBuffer.toString());
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			pstmt.setString(4,cond_trmt_type);
			//pstmt.setString(4,condition_type);
	
			rst = pstmt.executeQuery();
			while(rst.next()){
				condition_type1 = checkForNull(rst.getString("CONDITION_TYPE"));
				allRecords_trmt.append(condition_type1);
				allRecords_trmt.append("~");
			}				

			out.println(condition_type1);

		} else if(func_mode.equalsIgnoreCase("countExtractionOrder")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String isRetndCondYN	= checkForNull(request.getParameter( "isRetndCondYN" )) ;
			String isSuperCondYN	= checkForNull(request.getParameter( "isSuperCondYN" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}				
					
			int count_extract = 0;
			String supernumerary_yn = "";
			StringBuffer sqlBuffer = new StringBuffer();
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(isSuperCondYN.equals("Y")){
				if(mixed_dentition_YN.equals("Y")){
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR")){
							supernumerary_yn="";
						}else {
							supernumerary_yn="Y";
						}
					}else{
						//Added by Sharon Crasta on 11/23/2009  RD_Normal_yn.equals("NS")
						if(RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRP") || RD_Normal_yn.equals("NS")){
								supernumerary_yn="";
							}else {
								supernumerary_yn="Y";
							}	
					}
				}else{
				  if(permanent_deciduous_flag.equals("D")){
					  if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}
					  }else if(permanent_deciduous_flag.equals("P")){
						   if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}

					  }
				}
			}
			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT COUNT(*) COUNT_EXTRACT  FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E  WHERE E.ORDER_STATUS_TYPE IN ('25','52','54','55'))");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sqlBuffer.append("SELECT COUNT(*) COUNT_EXTRACT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E  WHERE E.ORDER_STATUS_TYPE IN ('25','52','54','55'))");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				count_extract = Integer.parseInt(rst.getString("COUNT_EXTRACT"));
			}
			out.println(count_extract);
		}else if(func_mode.equalsIgnoreCase("forExtractionRecording")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String super_tooth_no	= checkForNull(request.getParameter( "super_tooth_no" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}	
			String chart_line_num = "";

			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT MAX(CHART_LINE_NUM) CHART_LINE_NUM  FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND CONDITION_TYPE IN  ('EXFOLTH') AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");
		
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);
				
			}else{
				pstmt = con.prepareStatement("SELECT MAX(CHART_LINE_NUM) CHART_LINE_NUM  FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND CONDITION_TYPE IN  ('EXFOLTH') AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X')) ");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				chart_line_num = rst.getString("CHART_LINE_NUM");
			}
			out.println(chart_line_num);
		}else if(func_mode.equalsIgnoreCase("forTrmtSuperRDyn")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_category_type = "";
			String mixed_dent_deciduous_yn = "";
			String supernumerary_yn = "";
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}	
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
			 	//pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE,MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'  AND TREATMENT_CONDITION = 'T'AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('10','15'))");
			 	pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE,MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'  AND TREATMENT_CONDITION = 'T'AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('10','15','25','52','55','60','65','70','75','80','85','90'))");
			 	
				
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,tooth_no);
			}else{
				//pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE,MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'  AND TREATMENT_CONDITION = 'T'AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('10','15'))");
				pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE,MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'  AND TREATMENT_CONDITION = 'T'AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('10','15','25','52','55','60','65','70','75','80','85','90'))");
				
				
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
				mixed_dent_deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
				supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
			}
			out.println(trmt_category_type+"##"+mixed_dent_deciduous_yn+"##"+supernumerary_yn);
		} 
		else if(func_mode.equalsIgnoreCase("checkForExtractionSupernumeraryDeciduous")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String isRetndCondYN	= checkForNull(request.getParameter( "isRetndCondYN" )) ;
			String isSuperCondYN	= checkForNull(request.getParameter( "isSuperCondYN" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			int trmt_category_type_count = 0;
			String supernumerary_yn = "";
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(isSuperCondYN.equals("Y")){
				if(mixed_dentition_YN.equals("Y")){
					if(permanent_deciduous_flag.equals("P")){
						//if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR")){
						if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR") || RD_Normal_yn.equals("") || RD_Normal_yn.equals("null") || RD_Normal_yn.equals(null) || RD_Normal_yn.equals("undefined")){//Added by Sharon Crasta on 11/26/2009 for IN016114 the null check value.){
							supernumerary_yn="";
						}else {
							supernumerary_yn="Y";
						}
					}else{
						
						if(RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRP") || RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("N") || RD_Normal_yn.equals("") || RD_Normal_yn.equals("null") || RD_Normal_yn.equals(null) || RD_Normal_yn.equals("undefined")){//Added by Sharon Crasta on 11/26/2009 for IN016114 the null check value.
								supernumerary_yn="";
							}else {
								supernumerary_yn="Y";
							}	
					}
				}else{
				  if(permanent_deciduous_flag.equals("D")){
					  if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}
					  }else if(permanent_deciduous_flag.equals("P")){
						   if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}

					  }
				}
			}
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25', '52','54','55', '60','65','70','75','80','85','90')))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							//if(RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							//}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS") || RD_Normal_yn.equals("") || RD_Normal_yn.equals("null") || RD_Normal_yn.equals(null)){//Added by Sharon Crasta on 11/26/2009 for IN016114 the null check value.)
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND ((TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25', '52','54','55', '60','65','70','75','80','85','90')))) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");

				if(isSuperCondYN.equals("Y")){
					if(supernumerary_yn.equals("Y")){
						sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
					}else{
						sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}
				}
				
				if(isRetndCondYN.equals("Y")){
					if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(mixed_dentition_YN.equals("Y")){	
						if(permanent_deciduous_flag.equals("P")){
							//if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							}else{
							   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}else if(permanent_deciduous_flag.equals("D")){
							if(RD_Normal_yn.equals("RD")){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
							//}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
							}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS") ||  RD_Normal_yn.equals("") || RD_Normal_yn.equals("null") || RD_Normal_yn.equals(null)){//Added by Sharon Crasta on 11/26/2009 for IN016114 the null check value.){
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
							}else{
								sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
							}
						}
					}
				}

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));
				
			}
			
			out.println(trmt_category_type_count);
         }
		  else if(func_mode.equalsIgnoreCase("checkForExtractionConditions")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			StringBuffer sqlBuffer = new StringBuffer();
			String super_tooth_count = "";
			String super_tooth_no = "";

			int trmt_category_type_count = 0;

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				
				//sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','25','52','55','60','65','70','75','80', '85','90')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");//Added condition_type = 'MISSTH') becoause when recording plain missing tooth the menu was getting displayed.
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','25','52','55','60','65','70','75','80', '85','90')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");//Added condition_type = 'MISSTH') becoause when recording plain missing tooth the menu was getting displayed.

			
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);
			}else{
				
				//sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','25','52','55','60','65','70','75','80', '85','90')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'");	//Added condition_type = 'MISSTH') becoause when recording plain missing tooth the menu was getting displayed.
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','25','52','55','60','65','70','75','80', '85','90')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");	//Added condition_type = 'MISSTH') becoause when recording plain missing tooth the menu was getting displayed.

			
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));								
			}
			out.println(trmt_category_type_count);
         } else if(func_mode.equalsIgnoreCase("extractionStatus")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}				
			
			String trmt_category_type = "";
			String mixed_dent_deciduous_yn = "";
			String supernumerary_yn = "";

			StringBuffer sqlBuffer = new StringBuffer();
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			
			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT TRMT_CATEGORY_TYPE,MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25','52','55','60','65','70','75','80', '85','90'))");

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sqlBuffer.append("SELECT TRMT_CATEGORY_TYPE,MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25','52','55','60','65','70','75','80', '85','90'))");

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
				mixed_dent_deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
				supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
				
			}
			out.println(trmt_category_type+"##"+mixed_dent_deciduous_yn+"##"+supernumerary_yn);
			
		}
		else if(func_mode.equalsIgnoreCase("allConditionsRecordedForArchQuad")) {
		    String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String arch_quad = checkForNull(request.getParameter( "arch_quad" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			String condition_type = "";
			String condition_desc = "";

			StringBuffer allRecords = new StringBuffer();
				
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN,       MIXED_DENT_DECIDUOUS_YN, STATUS  FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND ARCH_SNO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' ");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,arch_quad);
				rst=pstmt.executeQuery();
			}
			else{
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN,       MIXED_DENT_DECIDUOUS_YN, STATUS  FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND ARCH_SNO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' ");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,arch_quad);
								
				rst=pstmt.executeQuery();
			}

			while(rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));	
				condition_desc = checkForNull(rst.getString("CONDITION_CODE"));	
			
				allRecords.append(condition_type+"##"+condition_desc);
				allRecords.append("~");
			}
			out.println(allRecords);
		}
		else if(func_mode.equalsIgnoreCase("cancelOAAppt")){	
			String patient_id = request.getParameter("patient_id");
			String appt_ref_no = request.getParameter("appt_ref_no");
			String result = "";
			int result_task_update = 0;

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			cstmt=con.prepareCall("{call OA_CANCEL_APPOINTMENT (?,?,?,NULL,NULL,NULL,?,?,?,?,?,'C')}");
			cstmt.setString(1,facility_id );			 //P_FACILITY_ID  
			cstmt.setString(2,appt_ref_no );			 //APPTREFNO	
			cstmt.setString(3,patient_id );				 //PATIENTID	
			cstmt.setString(4,facility_id );			 //ADDEDFACILITYID	
			cstmt.setString(5,client_ip_address);		 //ADDEDATWORKSTATION
			cstmt.setString(6,"N");					 //FORCED
			cstmt.setString(7,login_user);				 //USERID
			cstmt.registerOutParameter(8,Types.VARCHAR);//RESULT
			cstmt.execute();
			result = checkForNull(cstmt.getString(8));
			
			if(result == ""){
				if(cstmt !=null) cstmt.close();

				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_TASKS SET SCHEDULE_DATE_TIME = NULL, SCHEDULE_REF_NO = NULL WHERE SCHEDULE_REF_NO = ? ");
			
				pstmt.setString(1,appt_ref_no);
				result_task_update = pstmt.executeUpdate();
		
				if(result_task_update != 0){
					con.commit();
				}
				else{
					con.rollback();
				}

			}else{
				con.rollback();
			}
			out.println(result);
		}
		else if(func_mode.equalsIgnoreCase("getTrmtCatCode")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			String tooth_range_values = "";
		
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'BRIDGE' AND NVL(STATUS,'X') != 'E' ");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID= ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'BRIDGE' AND NVL(STATUS,'X') != 'E'");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				tooth_range_values = checkForNull(rst.getString("TOOTH_RANGE"));
				
			}
			out.println(tooth_range_values);
		}
		else if(func_mode.equalsIgnoreCase("updateCutPonticTooth")){
		    String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String tooth_nos = checkForNull(request.getParameter( "tooth_nos" )) ;
			String trmt_category_type = checkForNull(request.getParameter( "trmt_category_type" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;

			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			int pontic_tooth_update = 0;
		
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PONTIC_TOOTH_DTLS = ? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE =? AND NVL(STATUS,'X') != 'E'");
					
				pstmt.setString(1,tooth_nos);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,tooth_no);
				//pstmt.setString(5,"EXTRACT");
				pstmt.setString(6,trmt_category_type);
			}else{
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PONTIC_TOOTH_DTLS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID=? AND CHART_NUM=?  AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'");
					
				pstmt.setString(1,tooth_nos);
				pstmt.setString(2,other_chart_facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,chart_line_num);
				pstmt.setString(6,tooth_no);
				//pstmt.setString(6,"EXTRACT");
				pstmt.setString(7,trmt_category_type);
			}
			pontic_tooth_update = pstmt.executeUpdate();
			
			if(pontic_tooth_update != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(pontic_tooth_update);
		}
		else if(func_mode.equalsIgnoreCase("updateCutPonticToothForExtract")){
		    String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String tooth_nos = checkForNull(request.getParameter( "tooth_nos" )) ;
			String trmt_category_type = checkForNull(request.getParameter( "trmt_category_type" )) ;

			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			int pontic_tooth_update = 0;
		
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PONTIC_TOOTH_DTLS = ? WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE =? AND NVL(STATUS,'X') != 'E'");
					
				pstmt.setString(1,tooth_nos);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,tooth_no);
				//pstmt.setString(5,"EXTRACT");
				pstmt.setString(6,trmt_category_type);
			}else{
				pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PONTIC_TOOTH_DTLS = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'");
					
				pstmt.setString(1,tooth_nos);
				pstmt.setString(2,other_chart_facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,chart_line_num);
				pstmt.setString(6,tooth_no);
				//pstmt.setString(6,"EXTRACT");
				pstmt.setString(7,trmt_category_type);
			}
			pontic_tooth_update = pstmt.executeUpdate();
			
			if(pontic_tooth_update != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(pontic_tooth_update);
		}
		else if(func_mode.equalsIgnoreCase("getAbutmentToothExtraction")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no		= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;

			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			int count_abutment_extract = 0;
			
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT COUNT(*) COUNT_ABUTMENT_EXTRACT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND NVL(STATUS,'X') != 'E'");
					
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);  
				rst = pstmt.executeQuery();
			}
			else{
				pstmt=con.prepareStatement("SELECT COUNT(*) COUNT_ABUTMENT_EXTRACT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID= ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND NVL(STATUS,'X') != 'E'");
					
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst = pstmt.executeQuery();
			}

			if(rst.next()){
			 	count_abutment_extract =  Integer.parseInt(rst.getString("COUNT_ABUTMENT_EXTRACT"));
			 	//count_abutment_extract =  rst.getInt("COUNT_ABUTMENT_EXTRACT");
			}
			out.println(count_abutment_extract);
		}
		else if(func_mode.equalsIgnoreCase("getPonticCutToothValues")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String trmt_category_type = checkForNull(request.getParameter( "trmt_category_type" )) ;
			
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			String tooth_range_values = "";
			String chart_line_num_pontic = "";

			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CHART_LINE_NUM, PONTIC_TOOTH_DTLS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,trmt_category_type);
			}else{
				pstmt = con.prepareStatement("SELECT CHART_LINE_NUM, PONTIC_TOOTH_DTLS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,tooth_no);
				pstmt.setString(6,trmt_category_type);
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				chart_line_num_pontic = checkForNull(rst.getString("CHART_LINE_NUM"));
				tooth_range_values = checkForNull(rst.getString("PONTIC_TOOTH_DTLS"));
			}
			out.println(tooth_range_values+"##"+chart_line_num_pontic);
		}
		else if(func_mode.equalsIgnoreCase("getOutcomeForExtraction")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String trmt_category_type = checkForNull(request.getParameter( "trmt_category_type" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			
			
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			String treatments_outcome_ext = "";

		
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT TREATMENTS_OUTCOME FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,trmt_category_type);
			
			}else{
				pstmt = con.prepareStatement("SELECT TREATMENTS_OUTCOME FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID= ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,tooth_no);
				pstmt.setString(6,trmt_category_type);
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				treatments_outcome_ext = rst.getString("TREATMENTS_OUTCOME");
			}
			out.println(treatments_outcome_ext);
		} 
		else if(func_mode.equalsIgnoreCase("getMaxChartLineNum")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String trmt_category_type	= checkForNull(request.getParameter( "trmt_category_type" )) ;
						
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}	
	
			int chart_line_num_max = 0;

			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT MAX(CHART_LINE_NUM) CHART_LINE_NUM  FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,trmt_category_type);
				
			
			}else{
			
				pstmt = con.prepareStatement("SELECT MAX(CHART_LINE_NUM) CHART_LINE_NUM  FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND TRMT_CATEGORY_TYPE='EXTRACT' AND NVL(STATUS,'X') != 'E' ");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,trmt_category_type);
			}
											
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				chart_line_num_max = rst.getInt("CHART_LINE_NUM");
			}

			out.println(chart_line_num_max);
		}else if(func_mode.equalsIgnoreCase("getProgression_Ref")){
		
			String patient_id	           = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	           = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	       = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code	           = checkForNull(request.getParameter( "trmt_code" )) ;
			String oh_chart_level          = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String progression_ref = "";
			
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
		
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT PROGRESSION_REF FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM=?  AND TRMT_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
			
			}else{
				pstmt = con.prepareStatement("SELECT PROGRESSION_REF FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM=?  AND TRMT_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				
			}
								
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				progression_ref = checkForNull(rst.getString("PROGRESSION_REF"));
			}
			out.println(progression_ref);
		}
		else if(func_mode.equalsIgnoreCase("update_Progression_ref")){
			String   patient_id		             = checkForNull(request.getParameter( "patient_id" ));
			String   chart_num		             = checkForNull(request.getParameter( "chart_num" ));
			String   chart_line_num	             = checkForNull(request.getParameter( "chart_line_num" ));
			String   trmt_code		             = checkForNull(request.getParameter( "trmt_code" ));
		    String   oh_chart_level	             = checkForNull(request.getParameter( "oh_chart_level" ));
			String   other_chart_facility_id	 = checkForNull(request.getParameter( "other_chart_facility_id" ));
			String   progression_ref	         = checkForNull(request.getParameter( "progression_ref" ));
			String   thrng_nos	                 = checkForNull(request.getParameter( "tooth_range" ));
			String   str="";
			String[] tooth_range_arr = null;
			String   chrt_ln_num = "";/*for Tooth range*/
			int flag = 0;
			int i=0;
            /* Below Condtion is for Tooth Range*/
			if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){ 
			tooth_range_arr = thrng_nos.split(",");
			
			for(i=0;i<tooth_range_arr.length;i++){
			str="";
			str = tooth_range_arr[i];
			int j=str.indexOf("$");
			String  str3=str.substring(0,j);
			
			chrt_ln_num=str3;
					
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(oh_chart_level.equals("E")) {
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PROGRESSION_REF = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE=? ");
				pstmt.setString(1,progression_ref);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,patient_id);
				pstmt.setString(6,chart_num);
				pstmt.setString(7,chrt_ln_num);
				pstmt.setString(8,trmt_code);
				
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
			}else{
			   if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PROGRESSION_REF = ?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE = ?");
				pstmt.setString(1,progression_ref);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,other_chart_facility_id);
				pstmt.setString(6,patient_id);
				pstmt.setString(7,chart_num);
				pstmt.setString(8,chrt_ln_num);
				pstmt.setString(9,trmt_code);
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}		
			}
			}
			}
			else{
				if(oh_chart_level.equals("E")) {
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PROGRESSION_REF = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE=? ");
				pstmt.setString(1,progression_ref);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,patient_id);
				pstmt.setString(6,chart_num);
				pstmt.setString(7,chart_line_num);
				pstmt.setString(8,trmt_code);
				
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
			}else{
			   if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET PROGRESSION_REF = ?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID =? AND CHART_NUM =? AND CHART_LINE_NUM=? AND TRMT_CODE = ?");
				pstmt.setString(1,progression_ref);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,other_chart_facility_id);
				pstmt.setString(6,patient_id);
				pstmt.setString(7,chart_num);
				pstmt.setString(8,chart_line_num);
				pstmt.setString(9,trmt_code);
				flag = pstmt.executeUpdate();
				if(flag != 0){
					con.commit();
				}
				else{
					con.rollback();
				}		
			}
			}
			out.println(flag);
		}else if(func_mode.equalsIgnoreCase("checkProgressNotesComplYN")){
		    String patient_id	       = checkForNull(request.getParameter( "patient_id" )) ;		
		    String chart_num	       = checkForNull(request.getParameter( "chart_num" )) ;		
		    String chart_line_num	       = checkForNull(request.getParameter( "chart_line_num" )) ;		
		    String trmt_code	       = checkForNull(request.getParameter( "trmt_code" )) ;	
			String flag_progression_notes = "";
            
		    pstmt = con.prepareStatement("SELECT 1 FROM CA_PAT_PROGRESSION_DTL A,CA_ENCNTR_NOTE B WHERE A.ACCESSION_NUM=B.ACCESSION_NUM AND A.PROGRESSION_REF IN (SELECT PROGRESSION_REF FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM=?  AND TRMT_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N') AND B.EVENT_STATUS NOT IN('4','5','9')");
		    
            pstmt.setString(1,patient_id);		
            pstmt.setString(2,chart_num);		
            pstmt.setString(3,chart_line_num);		
            pstmt.setString(4,trmt_code);		
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				flag_progression_notes = rst.getString(1);
			}
			out.println(flag_progression_notes);
		
		}
		else if(func_mode.equalsIgnoreCase("checkForBridge")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			String sql = "";		
			String status = "";		
			
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sql = "SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'BRIDGE' AND A.TREATMENT_INT_EXT ='I' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sql = "SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'BRIDGE' AND A.TREATMENT_INT_EXT ='I' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				status = checkForNull(rst.getString("STATUS"));								
			}
			out.println(status);
        }else if(func_mode.equalsIgnoreCase("insertTaskForToothRange")){	
			String patient_id = request.getParameter("patient_id");
			String chart_num = request.getParameter("chart_num");
			String chart_line_num = request.getParameter("chart_line_num");
			String order_set_id = request.getParameter("order_set_id");
			String seq_no = request.getParameter("seq_no");
			String chart_line_num_insert = request.getParameter("chart_line_num_insert");
			String task_status = "";
			boolean flag_insert = false;
			
			int mark_error_count = 0;
			int outstanding_count = 0;
			int sch_count = 0;
			int register_count = 0;
			int progress_count = 0;
			int partial_count = 0;
			int resulted_count = 0;
			int resulted_RS_count = 0;

			int flag_dtl = 0;
			int flag_tasks = 0;

			String update_error = "";
			String update_status = "";
			String update_sch = "";
			String update_register = "";
			String update_progress = "";
			String update_partial = "";
			String update_resulted = "";

			HashMap map = null;
			int index_insert=0;
		
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			pstmt_task= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_TASKS (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, SEQ_NO, ORDER_ID, ORDER_LINE_NUM, DURATION, SCHEDULE_DATE_TIME, SCHEDULE_REF_NO, PERFORMED_DATE, OUTCOME_CODE, STATUS, ADDITIONAL_TASK_YN, COMPLICATION_CODE, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, TRMT_DTLS_ENTRY_CMPL_YN, REGN_DATE_TIME, START_DATE_TIME, END_DATE_TIME, EXTRA_SITTING_YN, APPT_REQD_YN, BL_TASK_CHARGE, EXT_PERFORMING_FACILITY_ID, EXT_PERFORMING_DEPTLOC_CODE, SENT_DATE, ACK_DATE, BILL_SUB_REGN_NUM, BILL_SUB_REGN_LINE_NUM, PRACTITIONER_ID, BILLED_YN, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, COPIED_YN, TASK_SEQ, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TASK_CMPLICATION_CMPL_YN) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, ?, TRMT_CODE, TASK_CODE, SEQ_NO, ORDER_ID, ORDER_LINE_NUM, DURATION, SCHEDULE_DATE_TIME, SCHEDULE_REF_NO,PERFORMED_DATE, OUTCOME_CODE, STATUS, ADDITIONAL_TASK_YN, COMPLICATION_CODE, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, TRMT_DTLS_ENTRY_CMPL_YN, REGN_DATE_TIME, START_DATE_TIME, END_DATE_TIME, EXTRA_SITTING_YN, APPT_REQD_YN, BL_TASK_CHARGE, EXT_PERFORMING_FACILITY_ID, EXT_PERFORMING_DEPTLOC_CODE, SENT_DATE, ACK_DATE, BILL_SUB_REGN_NUM, BILL_SUB_REGN_LINE_NUM, PRACTITIONER_ID, BILLED_YN, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, 'N', TASK_SEQ, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? , TASK_CMPLICATION_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND SEQ_NO = ?)");

			index_insert = 1;
												
			pstmt_task.setString(index_insert++,chart_line_num_insert+"");			//16
			pstmt_task.setString(index_insert++,login_user);			//16
			pstmt_task.setString(index_insert++,client_ip_address);		//17
			pstmt_task.setString(index_insert++,facility_id);			//18
			pstmt_task.setString(index_insert++,login_user);			//19
			pstmt_task.setString(index_insert++,client_ip_address);		//20
			pstmt_task.setString(index_insert++,facility_id);			//21
			pstmt_task.setString(index_insert++,patient_id);				//2
			pstmt_task.setString(index_insert++,chart_num);	
			pstmt_task.setString(index_insert++,chart_line_num);	
			pstmt_task.setString(index_insert++,seq_no);	
			flag_tasks = pstmt_task.executeUpdate();
			
			if(flag_tasks != 0){
				con.commit();
			}else{
				con.rollback();
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			int j=0;
			map = new HashMap();
			//pstmt = con.prepareStatement("SELECT STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
			//Commented by Sharon Crasta on 3/17/2009 for CRF #0423 for Facility/Enterprise Chart
			//pstmt = con.prepareStatement("SELECT DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");				
			pstmt = con.prepareStatement("SELECT DECODE(STATUS,'E','E',(SELECT  ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE=STATUS)) STATUS FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");				
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			rs=pstmt.executeQuery();
			while(rs.next()){
				task_status = checkForNull(rs.getString("STATUS"));
				map.put(j,task_status);
				j++;
			}
			
			int map_size = map.size();

			for(int k=0;k<map_size;k++){
				if(map.get(k).equals("E")){
					mark_error_count++;
				}

				else if(map.get(k).equals("10")){
					outstanding_count++;
				}
				
				else if(map.get(k).equals("15")){
					sch_count++;
				}
																 
				else if(map.get(k).equals("25")){
					register_count++;
				}

				else if(map.get(k).equals("52")){
					progress_count++;
				}

				else if(map.get(k).equals("55")){
					partial_count++;
				}

				else if(map.get(k).equals("85")){
					resulted_RS_count++;
				}

				else if(map.get(k).equals("60")){
					resulted_count++;
				}
			}
			String insert_status_type = "";
			if(mark_error_count == map_size){
				update_error = "Y";
				insert_status_type = "E";
			}
			else if(outstanding_count > 0){
				update_status = "Y";
				insert_status_type = "10";
			}
			else if((map_size-mark_error_count) == sch_count){
				update_sch = "Y";
				insert_status_type = "15";
			}
			else if((map_size-mark_error_count) == register_count){
				update_register = "Y";
				insert_status_type = "25";
			}
			else if((map_size-mark_error_count) == progress_count){
				update_progress = "Y";
				insert_status_type = "52";
			}
			else if((map_size-mark_error_count) == partial_count){
				update_partial = "Y";
				insert_status_type = "55";
			}
			else if((map_size-mark_error_count) == resulted_count){
				update_resulted = "Y";
				insert_status_type = "60";
				//insert_status_type = "85";
			}
			else if((map_size-mark_error_count) == resulted_RS_count){
				update_resulted = "Y";
				insert_status_type = "85";
			}
			
			if(update_status != "N" && !insert_status_type.equals("")){
				// update only dtl
				if(pstmt != null) pstmt.close();
					
				pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = ?), COPIED_YN = 'N', MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, OPERATING_FACILITY_ID=? WHERE PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,insert_status_type);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,patient_id);
				pstmt.setString(7,chart_num);
				pstmt.setString(8,order_set_id);
				flag_dtl = pstmt.executeUpdate();
			}
			
			if(flag_dtl != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			
			out.println(flag_insert);
		}else if(func_mode.equalsIgnoreCase("getPonticValuesForMenu")){
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
					
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			String pontic_values = "";
					
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT PONTIC_TOOTH_DTLS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?   AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'BRIDGE' AND NVL(STATUS,'X') != 'E' AND PONTIC_TOOTH_DTLS IS NOT NULL");
			
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT PONTIC_TOOTH_DTLS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'BRIDGE' AND NVL(STATUS,'X') != 'E' AND PONTIC_TOOTH_DTLS IS NOT NULL");
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
								
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				pontic_values = rst.getString("PONTIC_TOOTH_DTLS");
			}
			out.println(pontic_values);
		} else if(func_mode.equalsIgnoreCase("checkForImpactionCondForMenu")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;

			String condition_type = "";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
			pstmt = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'IMPACTN' AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
			}
			out.println(condition_type);
		}else if(func_mode.equalsIgnoreCase("checkForERUPTHForMenu")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
					
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
								
			int count_erupt = 0;

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
			pstmt = con.prepareStatement("SELECT COUNT(*) COUNT_ERUPT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (SUPERNUMERARY_YN = 'N' OR SUPERNUMERARY_YN IS NULL) AND CONDITION_TYPE IN ('ERUPTH')");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			
			rst=pstmt.executeQuery();

			while(rst.next()){
				count_erupt = Integer.parseInt(rst.getString("COUNT_ERUPT"));
			}
			out.println(count_erupt);
		}else if(func_mode.equalsIgnoreCase("countTreatments")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
					
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
					
			String sql = "";		
			int record_count = 0;

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			
			}

			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				record_count = Integer.parseInt(rst.getString("RECORD_COUNT"));
				
			}
			out.println(record_count);
         }else if(func_mode.equalsIgnoreCase("getStatusForBridge")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String super_tooth_no	= checkForNull(request.getParameter( "super_tooth_no" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			String treatment_int_ext	= checkForNull(request.getParameter( "treatment_int_ext" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
					
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}	  
			String status_for_bridge	="" ;

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(super_tooth_no.equals("undefined")){
			  super_tooth_no="";
			}
			 if(oh_chart_level.equals("E")){

				pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID=? AND A.TRMT_CATEGORY_TYPE='BRIDGE' AND A.TOOTH_NO=? AND A.CHART_NUM=? AND NVL(A.STATUS,'X') != 'E' AND A.TREATMENT_INT_EXT=? AND (NVL(A.SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(A.RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,tooth_no);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,treatment_int_ext);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
			 }else{
			 	
			 	pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.TRMT_CATEGORY_TYPE='BRIDGE' AND A.TOOTH_NO=? AND A.CHART_NUM=? AND NVL(A.STATUS,'X') != 'E' AND A.TREATMENT_INT_EXT=? AND (NVL(A.SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(A.RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,treatment_int_ext);
				pstmt.setString(6,super_tooth_no);
				pstmt.setString(7,retained_tooth_no);
			 }
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				status_for_bridge = checkForNull(rst.getString("STATUS"));
			}
			out.println(status_for_bridge);
		
		} else if(func_mode.equalsIgnoreCase("checkForTrmtForMenu")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no		= checkForNull(request.getParameter( "tooth_no" )) ;

			int trmt_category_count = 0;

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
			pstmt = con.prepareStatement("SELECT COUNT(*)TRMT_CATEGORY_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE IN ('IMPACT','IMPLANT','DENTURE') AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_COUNT"));
			}
			out.println(trmt_category_count);
		}else if(func_mode.equalsIgnoreCase("ChkAllsurfaceForMenu")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String surface_code	="" ;
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT SURFACE_CODE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND TRMT_CATEGORY_TYPE='CROWN' AND TOOTH_NO=? AND CHART_NUM=? AND TREATMENT_INT_EXT = 'E' AND NVL(STATUS,'X') != 'E'");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,tooth_no);
			pstmt.setString(3,chart_num);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				surface_code = checkForNull(rst.getString("SURFACE_CODE"));

			}

			out.println(surface_code);
		
		} else if(func_mode.equalsIgnoreCase("checkForExtractforOutcome")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			String sql = "";		
			String status = "";		
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sql = "SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM > ? AND A.TOOTH_NO = ? AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND A.TREATMENT_INT_EXT ='I' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,tooth_no);
			}else{
				sql = "SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM > ? AND A.CHART_LINE_NUM = ? AND A.TOOTH_NO = ? AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND A.TREATMENT_INT_EXT ='I' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				status = checkForNull(rst.getString("STATUS"));								
			}
			out.println(status);
        }else if(func_mode.equalsIgnoreCase("getEnabledTasks")){
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			int count_e_status   = 0;

			pstmt = con.prepareStatement("SELECT COUNT(*)COUNT_E_STATUS FROM OR_ORDER_SET_COMPONENT C, OR_ORDER_CATALOG A WHERE A.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE AND C.ORDER_SET_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TREATMENT WHERE TRMT_CODE = ?) AND C.ORDER_CATEGORY = 'OH' AND A.EFF_STATUS = 'E'");
				
			pstmt.setString(1,trmt_code);
					
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				count_e_status = Integer.parseInt(rst.getString("COUNT_E_STATUS"));
			}
			out.println(count_e_status);
		}else if(func_mode.equalsIgnoreCase("checkChartExists")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String asOnDate	= checkForNull(request.getParameter( "asOnDate" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}				
			
			String chart_num = "";

			StringBuffer sqlBuffer = new StringBuffer();
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			
			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=? AND TRUNC(CHART_DATE) <= TO_DATE(?,'DD/MM/YYYY')");
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,asOnDate);
			}else{
				sqlBuffer.append("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TRUNC(CHART_DATE) <= TO_DATE(?,'DD/MM/YYYY')");
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,asOnDate);
			
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_num =  checkForNull(rst.getString("CHART_NUM"));
			}
		  out.println(chart_num);
		}
		else if(func_mode.equalsIgnoreCase("checkasOnDateChartNum")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String asOnDate	= checkForNull(request.getParameter( "asOnDate" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}				
			
			String chart_num = "";

			StringBuffer sqlBuffer = new StringBuffer();
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			
			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT MAX (CHART_NUM)CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))");
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,asOnDate);
			}else{
				sqlBuffer.append("SELECT MAX (CHART_NUM)CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))");
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,asOnDate);
			
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_num =  checkForNull(rst.getString("CHART_NUM"));
			}
		  out.println(chart_num);
		}else if(func_mode.equalsIgnoreCase("chkTASKCODE")){	//added by parul on 25/05/2010 for IN021288
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String sql="" ;
			String task_code	="" ;
			StringBuffer sqlBuffer = new StringBuffer();
			sql = "SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?ORDER BY SEQ_NO";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1,trmt_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				task_code = checkForNull(rst.getString("TASK_CODE"));
				sqlBuffer.append(task_code);
				sqlBuffer.append("~");
			}
			out.println(sqlBuffer);
		}
		
		
		else if(func_mode.equalsIgnoreCase("checkForEFF_STATUS")){//added by parul on 11/05/2010 for IN021288
			String task_code	= checkForNull(request.getParameter( "task_code")) ;
			String oh_task_status	="" ;
			String sql="" ;
			
			sql = "SELECT A.EFF_STATUS ORDER_CATALOG_STATUS, B.EFF_STATUS OH_TASK_STATUS FROM OR_ORDER_CATALOG A, OH_TASKS B WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND A.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TASKS WHERE TASK_CODE = ?) AND A.EFF_STATUS = 'E' AND B.EFF_STATUS = 'E'";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,task_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				oh_task_status = checkForNull(rst.getString("OH_TASK_STATUS"));
			}
			out.println(oh_task_status);
		}else if(func_mode.equalsIgnoreCase("getLongDescofTasks")){	//added by parul on 25/05/2010 for IN021288
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			int count_e_status   = 0;
            String long_desc="";
			StringBuffer sqlBuffer_desc = new StringBuffer();
			pstmt = con.prepareStatement("SELECT LONG_DESC FROM OR_ORDER_SET_COMPONENT C, OR_ORDER_CATALOG A WHERE A.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE AND C.ORDER_SET_CODE = (SELECT ORDER_CATALOG_CODE FROM OH_TREATMENT WHERE TRMT_CODE = ?) AND C.ORDER_CATEGORY = 'OH' AND A.EFF_STATUS != 'E'");
				
			pstmt.setString(1,trmt_code);
					
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				long_desc = checkForNull(rst.getString("LONG_DESC"));
				sqlBuffer_desc.append(long_desc);
				sqlBuffer_desc.append("~");
			}
			out.println(sqlBuffer_desc);
		}
		
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from DentalTrmtValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(cstmt !=null) cstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
