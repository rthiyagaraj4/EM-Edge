package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __ohtrmtsendoutackvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHTrmtSendOutAckValidation.jsp", 1709117122895L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;

	try{
		con = ConnectionManager.getConnection();
		
		if(func_mode.equalsIgnoreCase("getRegDateTime")){	
			String patient_id = checkForNull(request.getParameter("patient_id")) ;
			String chart_num = checkForNull(request.getParameter("chart_num")) ;
			String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
			String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
			
			String regn_date_time = "";
			String sent_out_date = "";
			String acknowledge_date = "";
			String received_date = "";

			pstmt=con.prepareStatement("SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') REGN_DATE_TIME, TO_CHAR(SENT_OUT_DATE,'DD/MM/YYYY HH24:mi') SENT_OUT_DATE, TO_CHAR(RECEIVED_DATE,'DD/MM/YYYY HH24:mi') RECEIVED_DATE, TO_CHAR(ACKNOWLEDGE_DATE,'DD/MM/YYYY HH24:mi') ACKNOWLEDGE_DATE FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,task_seq_no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				regn_date_time = checkForNull(rs.getString("REGN_DATE_TIME"));
				sent_out_date = checkForNull(rs.getString("SENT_OUT_DATE"));
				received_date = checkForNull(rs.getString("RECEIVED_DATE"));
				acknowledge_date = checkForNull(rs.getString("ACKNOWLEDGE_DATE"));
			}
			
			out.println(regn_date_time+"##"+sent_out_date+"##"+acknowledge_date+"##"+received_date);
		}
		else if(func_mode.equalsIgnoreCase("checkForExtLoc")){	
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String ext_perm_loc = "";

			pstmt=con.prepareStatement("SELECT EXT_PERM_LOC FROM OH_TASKS WHERE TASK_CODE = ?");
			pstmt.setString(1,task_code);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ext_perm_loc = checkForNull(rs.getString("EXT_PERM_LOC"));
			}
			out.println(ext_perm_loc);
		}
		else if(func_mode.equalsIgnoreCase("getCurDateTime")){	
			
			String cur_date_time = "";

			pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') CUR_DATE_TIME FROM DUAL");
			rs=pstmt.executeQuery();
			while(rs.next()){
				cur_date_time = checkForNull(rs.getString("CUR_DATE_TIME"));
			}
			out.println(cur_date_time);
		}
		else if(func_mode.equalsIgnoreCase("getNoteType")){	
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String oh_note_type = "";

			pstmt = con.prepareStatement("SELECT OH_NOTE_TYPE FROM OH_TASKS WHERE TASK_CODE = ?");
			pstmt.setString(1,task_code);
			rs=pstmt.executeQuery();
			while(rs.next()){
				oh_note_type = checkForNull(rs.getString("OH_NOTE_TYPE"));
			}
			out.println(oh_note_type);
		}
		else if(func_mode.equalsIgnoreCase("getSendOutCompleted")){	
			String patient_id = checkForNull(request.getParameter("patient_id")) ;
			String chart_num = checkForNull(request.getParameter("chart_num")) ;
			String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
			String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
			String sendout_yn = "";

			pstmt = con.prepareStatement("SELECT SENDOUT_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE =? AND TASK_CODE = ? AND TASK_SEQ = ?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,task_seq_no);
			rs=pstmt.executeQuery();
			while(rs.next()){
				sendout_yn = checkForNull(rs.getString("SENDOUT_YN"));
			}
			out.println(sendout_yn);
		}
		else if(func_mode.equalsIgnoreCase("checkNotesCompletedYN")){	
			String contr_mod_accession_num = checkForNull(request.getParameter("contr_mod_accession_num")) ;
			String event_status = "";
			String accession_num = "";

			//pstmt = con.prepareStatement("SELECT EVENT_STATUS FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ?");
			pstmt = con.prepareStatement("SELECT EVENT_STATUS, ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM=?");
			pstmt.setString(1,contr_mod_accession_num);
			rs=pstmt.executeQuery();
			while(rs.next()){
				event_status = checkForNull(rs.getString("EVENT_STATUS"));
				accession_num = checkForNull(rs.getString("ACCESSION_NUM"));
			}
			out.println(event_status+"##"+accession_num);
		}
		else if(func_mode.equalsIgnoreCase("getAckDetailsFromDB")){	
			String patient_id = checkForNull(request.getParameter("patient_id")) ;
			String chart_num = checkForNull(request.getParameter("chart_num")) ;
			String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
			String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
			String task_code = checkForNull(request.getParameter("task_code")) ;
			String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
			String called_from = checkForNull(request.getParameter("called_from")) ;
			String acknowledge_date = "";
			String ack_receipt_no = "";
			String acknowledged_by = "";
			String expected_delivery_date = "";
			String acknowledged_yn = "";
			String send_practitioner_id = "";
			String performing_location = "";
			String sent_out_date = "";
			String sent_to = "";
			String sendout_yn = "";
			String received_date = "";
			String received_by = "";
			String received_yn = "";
			String remarks = "";
			String lab_price = "";
			String rcv_receipt_no = "";
			
			if(called_from.equals("ack")){
				pstmt=con.prepareStatement("SELECT TO_CHAR(ACKNOWLEDGE_DATE,'DD/MM/YYYY HH24:MI') ACKNOWLEDGE_DATE, ACK_RECEIPT_NO, ACKNOWLEDGED_BY, TO_CHAR(EXPECTED_DELIVERY_DATE,'DD/MM/YYYY HH24:MI') EXPECTED_DELIVERY_DATE, ACKNOWLEDGED_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id);				
				pstmt.setString(2,chart_num);				
				pstmt.setString(3,chart_line_num);				
				pstmt.setString(4,trmt_code);				
				pstmt.setString(5,task_code);				
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				
				while(rs!=null && rs.next()){
					acknowledge_date=checkForNull(rs.getString("ACKNOWLEDGE_DATE"));
					ack_receipt_no=checkForNull(rs.getString("ACK_RECEIPT_NO"));
					acknowledged_by=checkForNull(rs.getString("ACKNOWLEDGED_BY"));
					expected_delivery_date=checkForNull(rs.getString("EXPECTED_DELIVERY_DATE"));
					acknowledged_yn=checkForNull(rs.getString("ACKNOWLEDGED_YN"));
				}
				out.println(acknowledge_date+"##"+ack_receipt_no+"##"+acknowledged_by+"##"+expected_delivery_date+"##"+acknowledged_yn);
			}else if(called_from.equals("sentout")){
				pstmt=con.prepareStatement("SELECT SEND_FROM_FACILITY_ID, SEND_FROM_LOCATION, SEND_PRACTITIONER_ID, PERFORMING_LOCATION, TO_CHAR(SENT_OUT_DATE,'DD/MM/YYYY HH24:MI') SENT_OUT_DATE, SENT_TO, SENDOUT_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id);				
				pstmt.setString(2,chart_num);				
				pstmt.setString(3,chart_line_num);				
				pstmt.setString(4,trmt_code);				
				pstmt.setString(5,task_code);				
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				
				while(rs!=null && rs.next()){
					//send_from_facility_id=checkForNull(rs.getString("SEND_FROM_FACILITY_ID"));
					//send_from_location=checkForNull(rs.getString("SEND_FROM_LOCATION"));
					send_practitioner_id=checkForNull(rs.getString("SEND_PRACTITIONER_ID"));
					performing_location=checkForNull(rs.getString("PERFORMING_LOCATION"));
					sent_out_date=checkForNull(rs.getString("SENT_OUT_DATE"));
					sent_to=checkForNull(rs.getString("SENT_TO"));
					sendout_yn=checkForNull(rs.getString("SENDOUT_YN"));
				}
				out.println(send_practitioner_id+"##"+performing_location+"##"+sent_out_date+"##"+sent_to+"##"+sendout_yn);
			}else if(called_from.equals("rcv")){
				pstmt=con.prepareStatement("SELECT TO_CHAR(RECEIVED_DATE,'DD/MM/YYYY HH24:MI') RECEIVED_DATE, RECEIVED_BY, RECEIVED_YN, REMARKS, LAB_PRICE, RCV_RECEIPT_NO FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id);				
				pstmt.setString(2,chart_num);				
				pstmt.setString(3,chart_line_num);				
				pstmt.setString(4,trmt_code);				
				pstmt.setString(5,task_code);				
				pstmt.setString(6,task_seq_no);
				rs=pstmt.executeQuery();
				
				while(rs!=null && rs.next()){
					received_date=checkForNull(rs.getString("RECEIVED_DATE"));
					received_by=checkForNull(rs.getString("RECEIVED_BY"));
					received_yn=checkForNull(rs.getString("RECEIVED_YN"));
					remarks=checkForNull(rs.getString("REMARKS"));
					lab_price=checkForNull(rs.getString("LAB_PRICE"));
					rcv_receipt_no=checkForNull(rs.getString("RCV_RECEIPT_NO"));
				}
				out.println(received_date+"OH2SEP21"+received_by+"OH2SEP21"+received_yn+"OH2SEP21"+remarks+"OH2SEP21"+lab_price+"OH2SEP21"+rcv_receipt_no);
			}
		}
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from OHTrmtSendOutAckValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
