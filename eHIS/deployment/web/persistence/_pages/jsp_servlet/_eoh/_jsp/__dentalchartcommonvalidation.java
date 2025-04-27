package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dentalchartcommonvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/DentalChartCommonValidation.jsp", 1709117115029L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/

 
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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	PreparedStatement pstmt_hdr = null;
	PreparedStatement pstmt_dtl = null;
	PreparedStatement pstmt_task = null;
	PreparedStatement pstmt_GS = null;
	//Added by Sharon Crasta on 1/25/2010 for SRR20056-CRF-0479(IN010877)
	PreparedStatement pstmt_complication = null;
	PreparedStatement pstmt_composition = null;
	PreparedStatement pstmt_diag = null;
	PreparedStatement pstmt_diag_cond = null;
	PreparedStatement pstmt_diag_link = null;
	//End
	ResultSet rs = null;
	int flag=0;
	int flag_tasks=0;									  
	int flag_GS=0;
	int index_insert=0;
	int index_insert_GS=0;
	//Added by Sharon Crasta on 1/25/2010 for SRR20056-CRF-0479(IN010877)
	int flag_complication = 0;
	int flag_composition = 0;
	int flag_diag = 0;
	int flag_diag_cond = 0;
	int flag_diag_link = 0;
	int index_insert_complication = 0;
	int index_insert_composition = 0;
	int index_insert_diag = 0;
	int index_insert_diag_cond = 0;
	int index_insert_diag_link = 0;
	//End
	String client_ip_address="";
	String facility_id = "";	
	String login_user=""; 									   
	String practitioner_id=""; 
		
	java.util.Properties prop = null;
	facility_id = (String)session.getValue( "facility_id" ) ;
	practitioner_id = (String)session.getValue( "ca_practitioner_id" ) ;

	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	client_ip_address = prop.getProperty( "client_ip_address" );
	login_user = prop.getProperty( "login_user" );

	String func_mode = request.getParameter( "func_mode" ) ;
	ArrayList flag_arr= new ArrayList();

	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("copyPrevTrmtCond")){	
			String patient_id	= request.getParameter( "patient_id" );
			String chart_num	= request.getParameter( "chart_num" );
			String patient_class = request.getParameter( "patient_class" );
			String episode_type=checkForNull(request.getParameter("episode_type"));
			String source_code=checkForNull(request.getParameter("location_code"));
			String source_type=checkForNull(request.getParameter("location_type"));
			String other_chart_facility_id=checkForNull(request.getParameter("other_chart_facility_id"));
			String oh_chart_level=checkForNull(request.getParameter("oh_chart_level"));
			String copy_yn=checkForNull(request.getParameter("copy_yn"));	

			String chart_num_int2 = "";
			int chart_num_insert = 1;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			String sql = "";		
	
			// Update the current active chart to Closed state. ('C')
			if (oh_chart_level.equals("F")){
				sql = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=?";
				pstmt_hdr = con.prepareStatement(sql);
				pstmt_hdr.setString(1,login_user);
				//pstmt_hdr.setString(2,facility_id);
				pstmt_hdr.setString(2,other_chart_facility_id);
				pstmt_hdr.setString(3,patient_id);
				pstmt_hdr.setString(4,chart_num);
				flag = pstmt_hdr.executeUpdate();
			}else{
				sql = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE PATIENT_ID = ? AND CHART_NUM=?";
				pstmt_hdr = con.prepareStatement(sql);
				pstmt_hdr.setString(1,login_user);
				//pstmt_hdr.setString(2,facility_id);
				//pstmt_hdr.setString(2,other_chart_facility_id);
				pstmt_hdr.setString(2,patient_id);
				pstmt_hdr.setString(3,chart_num);
				flag = pstmt_hdr.executeUpdate();		
			}

			flag_arr.add(""+flag);
			if(!flag_arr.contains("0")){
				con.commit();
			}else{
				con.rollback();
			}
			
			pstmt_hdr = con.prepareStatement("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE  PATIENT_ID = ? ");
			pstmt_hdr.setString(1,patient_id);
			rs = pstmt_hdr.executeQuery();

			while(rs.next()){
				chart_num_int2 = checkForNull(rs.getString("CHART_NUM"));  //to copy the previous record
			}

			if(pstmt_hdr != null) pstmt_hdr.close();

			// Insert a new chart with status as Active ('A')			
			chart_num_insert = Integer.parseInt(chart_num_int2) + 1;

			sql = "INSERT INTO OH_RESTORATIVE_CHART_HDR(OPERATING_FACILITY_ID, PATIENT_ID,CHART_NUM, CHART_DATE, CHART_TYPE,CLINICAL_GROUP_CODE, CHART_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CHART_TITLE) (SELECT OPERATING_FACILITY_ID, PATIENT_ID,?, SYSDATE, CHART_TYPE,NULL,'A', ?, SYSDATE,  ?, ?, ?, SYSDATE,  ?, ?, CHART_TITLE FROM  OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND  CHART_NUM = ?)";
			pstmt_hdr = con.prepareStatement(sql);
			pstmt_hdr.setString(1,chart_num_insert+"");
			pstmt_hdr.setString(2,login_user);
			pstmt_hdr.setString(3,client_ip_address);
			pstmt_hdr.setString(4,facility_id);
			pstmt_hdr.setString(5,login_user);
			pstmt_hdr.setString(6,client_ip_address);
			pstmt_hdr.setString(7,facility_id);
			pstmt_hdr.setString(8,patient_id);
			pstmt_hdr.setString(9,chart_num);
			flag = pstmt_hdr.executeUpdate();
			flag_arr.add(""+flag);

			if(!flag_arr.contains("0")){
				con.commit();
			}else{
				con.rollback();
			}
			
			if(pstmt_hdr != null) pstmt_hdr.close();	
			//INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE

			if(copy_yn.equals("Y")){
				sql = "INSERT INTO OH_RESTORATIVE_CHART_DTL(OPERATING_FACILITY_ID, PATIENT_ID,CHART_NUM, CHART_LINE_NUM, ENCOUNTER_ID, PATIENT_CLASS, TREATMENT_CONDITION, TRMT_CATEGORY_TYPE, TRMT_CATEGORY_CODE, TRMT_CODE, CONDITION_TYPE, CONDITION_CODE, TREATMENT_INT_EXT, TREATMENT_CONDITION_DATE, SITE_TYPE, TOOTH_NO, TOOTH_RANGE, ARCH_SNO, QUADRANT_SNO, SURFACE_CODE, CUSP_TIP_CODE, LOCATION, SUPERNUMERARY_YN, ORDER_ID, STATUS, TREATMENTS_OUTCOME, REMARKS, MIXED_DENT_DECIDUOUS_YN, PRACTITIONER_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, SOURCE_CODE, SOURCE_TYPE, COMPLETE_ON_ORDER_YN, HIDE_IMAGE_YN, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, COMPLICATION_CODE, RESULT_TEXT, TRMT_COMPLETED_YN, COND_CLOSED_YN, COND_CLOSED_TRMT_CODE, COND_CLOSED_CHART_NUM, COND_CLOSED_CHART_LINE_NUM, COND_CLOSED_BY, COND_CLOSED_DATE, COPIED_YN, SUPER_TOOTH_NO, RETAINED_TOOTH_NO, SUPER_KEY_NUM, FAILURE_REMARKS, PONTIC_TOOTH_DTLS, PROGRESSION_REF,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)(SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, ENCOUNTER_ID , ?, TREATMENT_CONDITION, TRMT_CATEGORY_TYPE, TRMT_CATEGORY_CODE, TRMT_CODE, CONDITION_TYPE, CONDITION_CODE, TREATMENT_INT_EXT, TREATMENT_CONDITION_DATE, SITE_TYPE, TOOTH_NO, TOOTH_RANGE, ARCH_SNO, QUADRANT_SNO, SURFACE_CODE, CUSP_TIP_CODE, LOCATION, SUPERNUMERARY_YN, ORDER_ID, STATUS,TREATMENTS_OUTCOME,REMARKS,MIXED_DENT_DECIDUOUS_YN,?,EPISODE_ID,?,VISIT_ID,?,?,COMPLETE_ON_ORDER_YN, HIDE_IMAGE_YN, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, COMPLICATION_CODE, RESULT_TEXT, TRMT_COMPLETED_YN, COND_CLOSED_YN, COND_CLOSED_TRMT_CODE, COND_CLOSED_CHART_NUM, COND_CLOSED_CHART_LINE_NUM, COND_CLOSED_BY, COND_CLOSED_DATE, 'Y', SUPER_TOOTH_NO, RETAINED_TOOTH_NO, SUPER_KEY_NUM, FAILURE_REMARKS, PONTIC_TOOTH_DTLS, PROGRESSION_REF,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? )";

				pstmt_dtl = con.prepareStatement(sql);
				pstmt_dtl.setString(1,chart_num_insert+"");
				pstmt_dtl.setString(2,patient_class);

				pstmt_dtl.setString(3,practitioner_id);
				pstmt_dtl.setString(4,episode_type);
				pstmt_dtl.setString(5,source_code);
				pstmt_dtl.setString(6,source_type);

				pstmt_dtl.setString(7,login_user);
				pstmt_dtl.setString(8,client_ip_address);
				pstmt_dtl.setString(9,facility_id);
				pstmt_dtl.setString(10,login_user);
				pstmt_dtl.setString(11,client_ip_address);
				pstmt_dtl.setString(12,facility_id);
				pstmt_dtl.setString(13,patient_id);
				pstmt_dtl.setString(14,chart_num);
				flag = pstmt_dtl.executeUpdate();
				flag_arr.add(""+flag);

				if(!flag_arr.contains("0")){
					con.commit();
				}else{
					con.rollback();
				}

				if(pstmt_dtl != null) pstmt_dtl.close();
			
				pstmt_task= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_TASKS (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, SEQ_NO, ORDER_ID, ORDER_LINE_NUM, DURATION, SCHEDULE_DATE_TIME, SCHEDULE_REF_NO, PERFORMED_DATE, OUTCOME_CODE, STATUS, ADDITIONAL_TASK_YN, COMPLICATION_CODE, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, TRMT_DTLS_ENTRY_CMPL_YN, REGN_DATE_TIME, START_DATE_TIME, END_DATE_TIME, EXTRA_SITTING_YN, APPT_REQD_YN, BL_TASK_CHARGE, EXT_PERFORMING_FACILITY_ID, EXT_PERFORMING_DEPTLOC_CODE, SENT_DATE, ACK_DATE, BILL_SUB_REGN_NUM, BILL_SUB_REGN_LINE_NUM, PRACTITIONER_ID, BILLED_YN, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, COPIED_YN, TASK_SEQ, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TASK_CMPLICATION_CMPL_YN) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, SEQ_NO, ORDER_ID, ORDER_LINE_NUM, DURATION, SCHEDULE_DATE_TIME, SCHEDULE_REF_NO,PERFORMED_DATE, OUTCOME_CODE, STATUS, ADDITIONAL_TASK_YN, COMPLICATION_CODE, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, TRMT_DTLS_ENTRY_CMPL_YN, REGN_DATE_TIME, START_DATE_TIME, END_DATE_TIME, EXTRA_SITTING_YN, APPT_REQD_YN, BL_TASK_CHARGE, EXT_PERFORMING_FACILITY_ID, EXT_PERFORMING_DEPTLOC_CODE, SENT_DATE, ACK_DATE, BILL_SUB_REGN_NUM, BILL_SUB_REGN_LINE_NUM, PRACTITIONER_ID, BILLED_YN, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, 'Y', TASK_SEQ, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? , TASK_CMPLICATION_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? )");

				index_insert = 1;
													
				pstmt_task.setString(index_insert++,chart_num_insert+"");			//16
				pstmt_task.setString(index_insert++,login_user);			//16
				pstmt_task.setString(index_insert++,client_ip_address);		//17
				pstmt_task.setString(index_insert++,facility_id);			//18
				pstmt_task.setString(index_insert++,login_user);			//19
				pstmt_task.setString(index_insert++,client_ip_address);		//20
				pstmt_task.setString(index_insert++,facility_id);			//21
				pstmt_task.setString(index_insert++,patient_id);				//2
				pstmt_task.setString(index_insert++,chart_num);	
				flag_tasks = pstmt_task.executeUpdate();
				
				if(flag_tasks != 0){
					con.commit();
				}else{
					con.rollback();
				}
				
				if(pstmt_task != null) pstmt_task.close();
			
				// GS Not applicable for Baseline Chart
				pstmt_GS= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_GING_STS (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, LINE_NUM, TOOTH_NO, QUADRANT_SNO, SEXTENT_SNO, GINGIVAL_STATUS_CODE, VALUE, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, LINE_NUM, TOOTH_NO, QUADRANT_SNO, SEXTENT_SNO, GINGIVAL_STATUS_CODE, VALUE, STATUS, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? )");

				index_insert_GS = 1;
												
				//pstmt_GS.setString(index_insert_GS++,facility_id);			//16
				pstmt_GS.setString(index_insert_GS++,chart_num_insert+"");			//16
				pstmt_GS.setString(index_insert_GS++,client_ip_address);		//17
				pstmt_GS.setString(index_insert_GS++,facility_id);			//18
				pstmt_GS.setString(index_insert_GS++,login_user);			//19
				pstmt_GS.setString(index_insert_GS++,client_ip_address);		//20
				pstmt_GS.setString(index_insert_GS++,facility_id);			//21
				pstmt_GS.setString(index_insert_GS++,facility_id);				//1
				pstmt_GS.setString(index_insert_GS++,patient_id);				//2
				pstmt_GS.setString(index_insert_GS++,chart_num);	
				flag_GS = pstmt_GS.executeUpdate();
			
				if(flag_GS != 0){
					con.commit();
				}else{
					con.rollback();
				}

				//Added by Sharon Crasta on 1/25/2010 for SRR20056-CRF-0479(IN010877)
				//Added to copy the the composition details.
				if(pstmt_GS != null) pstmt_GS.close();

				pstmt_composition= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_MATRL (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_LINE_NUM, TRMT_CODE, COMPOSITION_CLASS_CODE, COMPOSITION_CODE, COMPOSITION_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TASK_CODE, COMPOSITION_SEQ_NO, TASK_SEQ) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, TRMT_CODE, COMPOSITION_CLASS_CODE, COMPOSITION_CODE, COMPOSITION_REMARKS, ?, SYSDATE, ? , ? , ? , SYSDATE, ? , ?, TASK_CODE, COMPOSITION_SEQ_NO, TASK_SEQ FROM OH_RESTORATIVE_CHART_MATRL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? )");

				index_insert_composition = 1;
												
				pstmt_composition.setString(index_insert_composition++,chart_num_insert+"");			//16
				pstmt_composition.setString(index_insert_composition++,login_user);
				pstmt_composition.setString(index_insert_composition++,client_ip_address);		//17
				pstmt_composition.setString(index_insert_composition++,facility_id);			//18
				pstmt_composition.setString(index_insert_composition++,login_user);			//19
				pstmt_composition.setString(index_insert_composition++,client_ip_address);		//20
				pstmt_composition.setString(index_insert_composition++,facility_id);			//21
				pstmt_composition.setString(index_insert_composition++,facility_id);				//1
				pstmt_composition.setString(index_insert_composition++,patient_id);				//2
				pstmt_composition.setString(index_insert_composition++,chart_num);	
				flag_composition = pstmt_composition.executeUpdate();
			
				if(flag_composition != 0){
					con.commit();
				}else{
					con.rollback();
				}
			
				if(pstmt_composition != null) pstmt_composition.close();

				//Added to copy the the complication details.
				pstmt_complication= con.prepareStatement("INSERT INTO OH_RESTO_CHRT_COMPLICATION (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, TASK_SEQ, COMPLICATION_CODE, COMPLICATION_SEQ_NO, COMPLICATION_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, TASK_SEQ, COMPLICATION_CODE, COMPLICATION_SEQ_NO, COMPLICATION_REMARKS, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTO_CHRT_COMPLICATION WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? )");

				index_insert_complication = 1;
												
				pstmt_complication.setString(index_insert_complication++,chart_num_insert+"");			//16
				pstmt_complication.setString(index_insert_complication++,login_user);
				pstmt_complication.setString(index_insert_complication++,client_ip_address);		//17
				pstmt_complication.setString(index_insert_complication++,facility_id);			//18
				pstmt_complication.setString(index_insert_complication++,login_user);			//19
				pstmt_complication.setString(index_insert_complication++,client_ip_address);		//20
				pstmt_complication.setString(index_insert_complication++,facility_id);			//21
				pstmt_complication.setString(index_insert_complication++,facility_id);				//1
				pstmt_complication.setString(index_insert_complication++,patient_id);				//2
				pstmt_complication.setString(index_insert_complication++,chart_num);	
				flag_complication = pstmt_complication.executeUpdate();
			
				if(flag_complication != 0){
					con.commit();
				}else{
					con.rollback();
				}

				//Added to copy the the Diagnosis details.By Sridevi Joshi on 6/2/2010 for IN021668
				pstmt_diag= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG (OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, TRMT_CHART_NUM, TRMT_CHART_LINE_NUM, TRMT_CODE, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, ?, TRMT_CHART_LINE_NUM, TRMT_CODE, STATUS, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_DIAG WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND TRMT_CHART_NUM = ? )");

				index_insert_diag = 1;
												
				pstmt_diag.setString(index_insert_diag++,chart_num_insert+"");			//16
				pstmt_diag.setString(index_insert_diag++,login_user);
				pstmt_diag.setString(index_insert_diag++,client_ip_address);		//17
				pstmt_diag.setString(index_insert_diag++,facility_id);			//18
				pstmt_diag.setString(index_insert_diag++,login_user);			//19
				pstmt_diag.setString(index_insert_diag++,client_ip_address);		//20
				pstmt_diag.setString(index_insert_diag++,facility_id);			//21
				pstmt_diag.setString(index_insert_diag++,facility_id);				//1
				pstmt_diag.setString(index_insert_diag++,patient_id);				//2
				pstmt_diag.setString(index_insert_diag++,chart_num);	
				flag_diag = pstmt_diag.executeUpdate();
			
				if(flag_diag != 0){
					con.commit();
				}else{
					con.rollback();
				}

				//Added to copy the the Diagnosis/Conditions details.By Sridevi Joshi on 6/2/2010 for IN021668
				pstmt_diag_link= con.prepareStatement("INSERT INTO OH_DIAG_COND_LINK (PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, CHART_NUM, CHART_LINE_NUM, CONDITION_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, ?, CHART_LINE_NUM, CONDITION_CODE, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_DIAG_COND_LINK WHERE PATIENT_ID = ? AND CHART_NUM = ? )");

				index_insert_diag_link = 1;
												
				pstmt_diag_link.setString(index_insert_diag_link++,chart_num_insert+"");			//16
				pstmt_diag_link.setString(index_insert_diag_link++,login_user);
				pstmt_diag_link.setString(index_insert_diag_link++,client_ip_address);		//17
				pstmt_diag_link.setString(index_insert_diag_link++,facility_id);			//18
				pstmt_diag_link.setString(index_insert_diag_link++,login_user);			//19
				pstmt_diag_link.setString(index_insert_diag_link++,client_ip_address);		//20
				pstmt_diag_link.setString(index_insert_diag_link++,facility_id);			//21
				pstmt_diag_link.setString(index_insert_diag_link++,patient_id);				//2
				pstmt_diag_link.setString(index_insert_diag_link++,chart_num);	
				flag_diag_link = pstmt_diag_link.executeUpdate();
			
				if(flag_diag_link != 0){
					con.commit();
				}else{
					con.rollback();
				}

				//Added to copy the the Diagnosis/Conditions details.By Sridevi Joshi on 6/2/2010 for IN021668
				pstmt_diag_cond= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG_COND (OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, TRMT_CHART_NUM, TRMT_CHART_LINE_NUM, TRMT_CODE, COND_CHART_NUM, COND_CHART_LINE_NUM, CONDITION_CODE, COND_CLOSED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, ?, TRMT_CHART_LINE_NUM, TRMT_CODE, ?, COND_CHART_LINE_NUM, CONDITION_CODE, COND_CLOSED_YN, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND TRMT_CHART_NUM = ? )");

				index_insert_diag_cond = 1;
												
				pstmt_diag_cond.setString(index_insert_diag_cond++,chart_num_insert+"");			//16
				pstmt_diag_cond.setString(index_insert_diag_cond++,chart_num_insert+"");			//16
				pstmt_diag_cond.setString(index_insert_diag_cond++,login_user);
				pstmt_diag_cond.setString(index_insert_diag_cond++,client_ip_address);		//17
				pstmt_diag_cond.setString(index_insert_diag_cond++,facility_id);			//18
				pstmt_diag_cond.setString(index_insert_diag_cond++,login_user);			//19
				pstmt_diag_cond.setString(index_insert_diag_cond++,client_ip_address);		//20
				pstmt_diag_cond.setString(index_insert_diag_cond++,facility_id);			//21
				pstmt_diag_cond.setString(index_insert_diag_cond++,facility_id);				//1
				pstmt_diag_cond.setString(index_insert_diag_cond++,patient_id);				//2
				pstmt_diag_cond.setString(index_insert_diag_cond++,chart_num);	
				flag_diag_cond = pstmt_diag_cond.executeUpdate();
			
				if(flag_diag_cond != 0){
					con.commit();
				}else{
					con.rollback();
				}

			}
			out.println(flag);
		}
		else if(func_mode.equalsIgnoreCase("newChartFromBaselineMenu")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" ));
			String patient_class = request.getParameter( "patient_class" );

			String episode_type=checkForNull(request.getParameter("episode_type"));
			String source_code=checkForNull(request.getParameter("source_code"));
			String source_type=checkForNull(request.getParameter("source_type"));
			String copy_yn=checkForNull(request.getParameter("copy_yn"));			
			String chart_type	= checkForNull(request.getParameter( "chart_type" ));
			
			String chart_title	= "";
			int chart_num_int = 1;
			String sql				= "";	
			String oh_chart_level=checkForNull(request.getParameter("oh_chart_level"));
			String other_chart_facility_id=checkForNull(request.getParameter("other_chart_facility_id"));
			String chart_num =checkForNull(request.getParameter("chart_num"));

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			int chart_num_insert = 1;
			
			if(oh_chart_level.equals("E")){
				pstmt_hdr = con.prepareStatement("SELECT CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'");
				pstmt_hdr.setString(1,patient_id);
				rs = pstmt_hdr.executeQuery();
			
				while(rs.next()){
						chart_num = checkForNull(rs.getString("CHART_NUM"),"1");
				}
			
				// Update the current active chart to Closed state. ('C')
				if(pstmt_hdr != null) pstmt_hdr.close();

				sql = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE  PATIENT_ID = ? AND CHART_STATUS='A'";
				pstmt_hdr = con.prepareStatement(sql);
				pstmt_hdr.setString(1,login_user);
				pstmt_hdr.setString(2,patient_id);
				flag = pstmt_hdr.executeUpdate();
				flag_arr.add(""+flag);
				if(!flag_arr.contains("0")){
					con.commit();
				}else{
					con.rollback();
				}
			}else{
				pstmt_hdr = con.prepareStatement("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'");
				pstmt_hdr.setString(1,patient_id);
				rs = pstmt_hdr.executeQuery();
			
				while(rs.next()){
					chart_num = checkForNull(rs.getString("CHART_NUM"),"1");
				} 
			
				// Update the current active chart to Closed state. ('C')
				if(pstmt_hdr != null) pstmt_hdr.close();
				sql = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_STATUS='A'";
				pstmt_hdr = con.prepareStatement(sql);
				pstmt_hdr.setString(1,login_user);
				pstmt_hdr.setString(2,facility_id);
				pstmt_hdr.setString(3,patient_id);
				flag = pstmt_hdr.executeUpdate();
				flag_arr.add(""+flag);
				if(!flag_arr.contains("0")){
					con.commit();
				}else{
					con.rollback();
				}
			}

			if(flag != 0){
				chart_num_int = Integer.parseInt(chart_num);
				chart_num_int = chart_num_int+1;
			}

			if(pstmt_hdr != null) pstmt_hdr.close();

			String chart_num_int2="";
			
			// Insert a new chart with status as Active ('A')			
			
			sql = "INSERT INTO OH_RESTORATIVE_CHART_HDR(OPERATING_FACILITY_ID, PATIENT_ID,CHART_NUM, CHART_DATE, CHART_TYPE,CLINICAL_GROUP_CODE, CHART_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CHART_TITLE) VALUES (?, ?, ?, SYSDATE, ? ,NULL,'A', ?, SYSDATE,  ?, ?, ?, SYSDATE,  ?, ?, ?)";
			pstmt_hdr = con.prepareStatement(sql);
			pstmt_hdr.setString(1,facility_id);
			pstmt_hdr.setString(2,patient_id);
			pstmt_hdr.setString(3,chart_num_int+"");
			pstmt_hdr.setString(4,chart_type);
			pstmt_hdr.setString(5,login_user);
			pstmt_hdr.setString(6,client_ip_address);
			pstmt_hdr.setString(7,facility_id);
			pstmt_hdr.setString(8,login_user);
			pstmt_hdr.setString(9,client_ip_address);
			pstmt_hdr.setString(10,facility_id);
			pstmt_hdr.setString(11,chart_title);
			flag = pstmt_hdr.executeUpdate();

			if(flag != 0){
				con.commit();
			}else{
				con.rollback();
			}
			
			if(copy_yn.equals("Y")){
				if(oh_chart_level.equals("E")){
					pstmt_hdr = con.prepareStatement("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS='C'");
					pstmt_hdr.setString(1,patient_id);
					rs = pstmt_hdr.executeQuery();
				}else{
					pstmt_hdr = con.prepareStatement("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS='C'");
					pstmt_hdr.setString(1,facility_id);
					pstmt_hdr.setString(2,patient_id);
					rs = pstmt_hdr.executeQuery();
				}
			
				while(rs.next()){
					chart_num_int2 = checkForNull(rs.getString("CHART_NUM"));
				}

				chart_num_insert = Integer.parseInt(chart_num) + 1;
				if(pstmt_hdr != null) pstmt_hdr.close();
			
				
				sql = "INSERT INTO OH_RESTORATIVE_CHART_DTL(OPERATING_FACILITY_ID, PATIENT_ID,CHART_NUM, CHART_LINE_NUM, ENCOUNTER_ID, PATIENT_CLASS, TREATMENT_CONDITION, TRMT_CATEGORY_TYPE, TRMT_CATEGORY_CODE, TRMT_CODE, CONDITION_TYPE, CONDITION_CODE, TREATMENT_INT_EXT, TREATMENT_CONDITION_DATE, SITE_TYPE, TOOTH_NO, TOOTH_RANGE, ARCH_SNO, QUADRANT_SNO, SURFACE_CODE, CUSP_TIP_CODE, LOCATION, SUPERNUMERARY_YN, ORDER_ID, STATUS, TREATMENTS_OUTCOME, REMARKS, MIXED_DENT_DECIDUOUS_YN, PRACTITIONER_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, SOURCE_CODE, SOURCE_TYPE, COMPLETE_ON_ORDER_YN, HIDE_IMAGE_YN, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, COMPLICATION_CODE, RESULT_TEXT, TRMT_COMPLETED_YN, COND_CLOSED_YN, COND_CLOSED_TRMT_CODE, COND_CLOSED_CHART_NUM, COND_CLOSED_CHART_LINE_NUM, COND_CLOSED_BY, COND_CLOSED_DATE, COPIED_YN, SUPER_TOOTH_NO, RETAINED_TOOTH_NO, SUPER_KEY_NUM, FAILURE_REMARKS, PONTIC_TOOTH_DTLS, PROGRESSION_REF,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)(SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, ENCOUNTER_ID , ? , TREATMENT_CONDITION, TRMT_CATEGORY_TYPE, TRMT_CATEGORY_CODE, TRMT_CODE, CONDITION_TYPE, CONDITION_CODE, TREATMENT_INT_EXT, TREATMENT_CONDITION_DATE, SITE_TYPE, TOOTH_NO, TOOTH_RANGE, ARCH_SNO, QUADRANT_SNO, SURFACE_CODE, CUSP_TIP_CODE, LOCATION, SUPERNUMERARY_YN, ORDER_ID, STATUS,TREATMENTS_OUTCOME,REMARKS,MIXED_DENT_DECIDUOUS_YN,?,EPISODE_ID,?,VISIT_ID,?,?,COMPLETE_ON_ORDER_YN, HIDE_IMAGE_YN, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, COMPLICATION_CODE, RESULT_TEXT, TRMT_COMPLETED_YN, COND_CLOSED_YN, COND_CLOSED_TRMT_CODE, COND_CLOSED_CHART_NUM, COND_CLOSED_CHART_LINE_NUM, COND_CLOSED_BY, COND_CLOSED_DATE, 'Y', SUPER_TOOTH_NO, RETAINED_TOOTH_NO, SUPER_KEY_NUM, FAILURE_REMARKS, PONTIC_TOOTH_DTLS, PROGRESSION_REF,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? )";

				pstmt_dtl = con.prepareStatement(sql);
				pstmt_dtl.setString(1,chart_num_insert+"");
				pstmt_dtl.setString(2,patient_class);
				pstmt_dtl.setString(3,practitioner_id);
				pstmt_dtl.setString(4,episode_type);
				pstmt_dtl.setString(5,source_code);
				pstmt_dtl.setString(6,source_type);
				pstmt_dtl.setString(7,login_user);
				pstmt_dtl.setString(8,client_ip_address);
				pstmt_dtl.setString(9,facility_id);
				pstmt_dtl.setString(10,login_user);
				pstmt_dtl.setString(11,client_ip_address);
				pstmt_dtl.setString(12,facility_id);
				pstmt_dtl.setString(13,patient_id);
				pstmt_dtl.setString(14,chart_num_int2);
				flag = pstmt_dtl.executeUpdate();
				flag_arr.add(""+flag);
			
				if(!flag_arr.contains("0")){
					con.commit();
				}else{
					con.rollback();
				}
				
				if(pstmt_dtl != null) pstmt_dtl.close();
				
			   	pstmt_task= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_TASKS (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, SEQ_NO, ORDER_ID, ORDER_LINE_NUM, DURATION, SCHEDULE_DATE_TIME, SCHEDULE_REF_NO, PERFORMED_DATE, OUTCOME_CODE, STATUS, ADDITIONAL_TASK_YN, COMPLICATION_CODE, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, TRMT_DTLS_ENTRY_CMPL_YN, TASK_CMPLICATION_CMPL_YN, REGN_DATE_TIME, START_DATE_TIME, END_DATE_TIME, EXTRA_SITTING_YN, APPT_REQD_YN, BL_TASK_CHARGE, EXT_PERFORMING_FACILITY_ID, EXT_PERFORMING_DEPTLOC_CODE, SENT_DATE, ACK_DATE, BILL_SUB_REGN_NUM, BILL_SUB_REGN_LINE_NUM, PRACTITIONER_ID, BILLED_YN, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, COPIED_YN, TASK_SEQ, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, SEQ_NO, ORDER_ID, ORDER_LINE_NUM, DURATION, SCHEDULE_DATE_TIME, SCHEDULE_REF_NO,PERFORMED_DATE, OUTCOME_CODE, STATUS, ADDITIONAL_TASK_YN, COMPLICATION_CODE, CANCEL_REASON, CANCELLED_BY, CANCELLED_DATE, TRMT_DTLS_ENTRY_CMPL_YN, TASK_CMPLICATION_CMPL_YN, REGN_DATE_TIME, START_DATE_TIME, END_DATE_TIME, EXTRA_SITTING_YN, APPT_REQD_YN, BL_TASK_CHARGE, EXT_PERFORMING_FACILITY_ID, EXT_PERFORMING_DEPTLOC_CODE, SENT_DATE, ACK_DATE, BILL_SUB_REGN_NUM, BILL_SUB_REGN_LINE_NUM, PRACTITIONER_ID, BILLED_YN, PATIENT_CLASS, EPISODE_ID, ENCOUNTER_ID, VISIT_ID, 'Y', TASK_SEQ, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? )");

				index_insert = 1;
				pstmt_task.setString(index_insert++,chart_num_insert+"");			//16
				pstmt_task.setString(index_insert++,login_user);			//16
				pstmt_task.setString(index_insert++,client_ip_address);	
				pstmt_task.setString(index_insert++,facility_id);			//18
				pstmt_task.setString(index_insert++,login_user);			//19
				pstmt_task.setString(index_insert++,client_ip_address);		//20
				pstmt_task.setString(index_insert++,facility_id);			//21
				pstmt_task.setString(index_insert++,patient_id);				//2
				pstmt_task.setString(index_insert++,chart_num_int2);
				
				flag_tasks = pstmt_task.executeUpdate();

				if(flag_tasks != 0){
					con.commit();
				}else{
					con.rollback();
				}
			}
			
			if(pstmt_task != null) pstmt_task.close();

			// GS Not applicable for Baseline Chart
			pstmt_GS= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_GING_STS (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, LINE_NUM, TOOTH_NO, QUADRANT_SNO, SEXTENT_SNO, GINGIVAL_STATUS_CODE, VALUE, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, LINE_NUM, TOOTH_NO, QUADRANT_SNO, SEXTENT_SNO, GINGIVAL_STATUS_CODE, VALUE, STATUS, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? )");
			index_insert = 1;
												
			pstmt_GS.setString(index_insert++,chart_num_insert+"");			//16
			pstmt_GS.setString(index_insert++,login_user);			//16
			pstmt_GS.setString(index_insert++,client_ip_address);		//17
			pstmt_GS.setString(index_insert++,facility_id);			//18
			pstmt_GS.setString(index_insert++,login_user);			//19
			pstmt_GS.setString(index_insert++,client_ip_address);		//20
			pstmt_GS.setString(index_insert++,facility_id);			//21
			pstmt_GS.setString(index_insert++,facility_id);				//1
			pstmt_GS.setString(index_insert++,patient_id);				//2
			pstmt_GS.setString(index_insert++,chart_num_int2);	
			flag_GS = pstmt_GS.executeUpdate();
			
			if(flag_GS != 0){
				con.commit();
			}else{
				con.rollback();
			}
			

			//Added by Sharon Crasta on 1/25/2010 for SRR20056-CRF-0479(IN010877)
			//Added to copy the the composition details.
			if(pstmt_GS != null) pstmt_GS.close();

			pstmt_composition= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_MATRL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,TRMT_CODE,COMPOSITION_CLASS_CODE,COMPOSITION_CODE,COMPOSITION_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,TASK_CODE,COMPOSITION_SEQ_NO,TASK_SEQ) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, TRMT_CODE, COMPOSITION_CLASS_CODE, COMPOSITION_CODE, COMPOSITION_REMARKS, ?, SYSDATE, ? , ? , ? , SYSDATE, ? , ?, TASK_CODE, COMPOSITION_SEQ_NO, TASK_SEQ FROM OH_RESTORATIVE_CHART_MATRL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? )");

			index_insert_composition = 1;
											
			//pstmt_GS.setString(index_insert_GS++,facility_id);			//16
			pstmt_composition.setString(index_insert_composition++,chart_num_insert+"");			//16
			pstmt_composition.setString(index_insert_composition++,login_user);
			pstmt_composition.setString(index_insert_composition++,client_ip_address);		//17
			pstmt_composition.setString(index_insert_composition++,facility_id);			//18
			pstmt_composition.setString(index_insert_composition++,login_user);			//19
			pstmt_composition.setString(index_insert_composition++,client_ip_address);		//20
			pstmt_composition.setString(index_insert_composition++,facility_id);			//21
			pstmt_composition.setString(index_insert_composition++,facility_id);				//1
			pstmt_composition.setString(index_insert_composition++,patient_id);				//2
			pstmt_composition.setString(index_insert_composition++,chart_num);	
			flag_composition = pstmt_composition.executeUpdate();
		
			if(flag_composition != 0){
				con.commit();
			}else{
				con.rollback();
			}
			
			if(pstmt_composition != null) pstmt_composition.close();
			//Added to copy the the complication details.
			pstmt_complication= con.prepareStatement("INSERT INTO OH_RESTO_CHRT_COMPLICATION (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, TASK_SEQ, COMPLICATION_CODE, COMPLICATION_SEQ_NO, COMPLICATION_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, ?, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, TASK_SEQ, COMPLICATION_CODE, COMPLICATION_SEQ_NO, COMPLICATION_REMARKS, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTO_CHRT_COMPLICATION WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ? )");

			index_insert_complication = 1;
											
			//pstmt_GS.setString(index_insert_GS++,facility_id);			//16
			pstmt_complication.setString(index_insert_complication++,chart_num_insert+"");			//16
			pstmt_complication.setString(index_insert_complication++,login_user);
			pstmt_complication.setString(index_insert_complication++,client_ip_address);		//17
			pstmt_complication.setString(index_insert_complication++,facility_id);			//18
			pstmt_complication.setString(index_insert_complication++,login_user);			//19
			pstmt_complication.setString(index_insert_complication++,client_ip_address);		//20
			pstmt_complication.setString(index_insert_complication++,facility_id);			//21
			pstmt_complication.setString(index_insert_complication++,facility_id);				//1
			pstmt_complication.setString(index_insert_complication++,patient_id);				//2
			pstmt_complication.setString(index_insert_complication++,chart_num);	
			flag_complication = pstmt_complication.executeUpdate();
		
			if(flag_complication != 0){
				con.commit();
			}else{
				con.rollback();
			}
			 //End

			 //Added to copy the the Diagnosis details.By Sridevi Joshi on 6/2/2010 for IN021668
			pstmt_diag= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG (OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, TRMT_CHART_NUM, TRMT_CHART_LINE_NUM, TRMT_CODE, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, ?, TRMT_CHART_LINE_NUM, TRMT_CODE, STATUS, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_DIAG WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND TRMT_CHART_NUM = ? )");

			index_insert_diag = 1;
											
			pstmt_diag.setString(index_insert_diag++,chart_num_insert+"");			//16
			pstmt_diag.setString(index_insert_diag++,login_user);
			pstmt_diag.setString(index_insert_diag++,client_ip_address);		//17
			pstmt_diag.setString(index_insert_diag++,facility_id);			//18
			pstmt_diag.setString(index_insert_diag++,login_user);			//19
			pstmt_diag.setString(index_insert_diag++,client_ip_address);		//20
			pstmt_diag.setString(index_insert_diag++,facility_id);			//21
			pstmt_diag.setString(index_insert_diag++,facility_id);				//1
			pstmt_diag.setString(index_insert_diag++,patient_id);				//2
			pstmt_diag.setString(index_insert_diag++,chart_num);	
			flag_diag = pstmt_diag.executeUpdate();
		
			if(flag_diag != 0){
				con.commit();
			}else{
				con.rollback();
			}

				//Added to copy the the Diagnosis/Conditions details.By Sridevi Joshi on 6/2/2010 for IN021668
				pstmt_diag_link= con.prepareStatement("INSERT INTO OH_DIAG_COND_LINK (PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, CHART_NUM, CHART_LINE_NUM, CONDITION_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, ?, CHART_LINE_NUM, CONDITION_CODE, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_DIAG_COND_LINK WHERE PATIENT_ID = ? AND CHART_NUM = ? )");

				index_insert_diag_link = 1;
												
				pstmt_diag_link.setString(index_insert_diag_link++,chart_num_insert+"");			//16
				pstmt_diag_link.setString(index_insert_diag_link++,login_user);
				pstmt_diag_link.setString(index_insert_diag_link++,client_ip_address);		//17
				pstmt_diag_link.setString(index_insert_diag_link++,facility_id);			//18
				pstmt_diag_link.setString(index_insert_diag_link++,login_user);			//19
				pstmt_diag_link.setString(index_insert_diag_link++,client_ip_address);		//20
				pstmt_diag_link.setString(index_insert_diag_link++,facility_id);			//21
				pstmt_diag_link.setString(index_insert_diag_link++,patient_id);				//2
				pstmt_diag_link.setString(index_insert_diag_link++,chart_num);	
				flag_diag_link = pstmt_diag_link.executeUpdate();
			
				if(flag_diag_link != 0){
					con.commit();
				}else{
					con.rollback();
				}

			//Added to copy the the Diagnosis/Conditions details.By Sridevi Joshi on 6/2/2010 for IN021668
				pstmt_diag_cond= con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DIAG_COND (OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, TRMT_CHART_NUM, TRMT_CHART_LINE_NUM, TRMT_CODE, COND_CHART_NUM, COND_CHART_LINE_NUM, CONDITION_CODE, COND_CLOSED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (SELECT OPERATING_FACILITY_ID, PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, ?, TRMT_CHART_LINE_NUM, TRMT_CODE, ?, COND_CHART_LINE_NUM, CONDITION_CODE, COND_CLOSED_YN, ? , SYSDATE, ? , ? , ? , SYSDATE, ? , ? FROM OH_RESTORATIVE_CHART_DIAG_COND WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND TRMT_CHART_NUM = ? )");

				index_insert_diag_cond = 1;
												
				pstmt_diag_cond.setString(index_insert_diag_cond++,chart_num_insert+"");			//16
				pstmt_diag_cond.setString(index_insert_diag_cond++,chart_num_insert+"");			//16
				pstmt_diag_cond.setString(index_insert_diag_cond++,login_user);
				pstmt_diag_cond.setString(index_insert_diag_cond++,client_ip_address);		//17
				pstmt_diag_cond.setString(index_insert_diag_cond++,facility_id);			//18
				pstmt_diag_cond.setString(index_insert_diag_cond++,login_user);			//19
				pstmt_diag_cond.setString(index_insert_diag_cond++,client_ip_address);		//20
				pstmt_diag_cond.setString(index_insert_diag_cond++,facility_id);			//21
				pstmt_diag_cond.setString(index_insert_diag_cond++,facility_id);				//1
				pstmt_diag_cond.setString(index_insert_diag_cond++,patient_id);				//2
				pstmt_diag_cond.setString(index_insert_diag_cond++,chart_num);	
				flag_diag_cond = pstmt_diag_cond.executeUpdate();
			
				if(flag_diag_cond != 0){
					con.commit();
				}else{
					con.rollback();
				}

			out.println(flag);
		}else if(func_mode.equalsIgnoreCase("updateChartStatus")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" ));
			String chart_type	= checkForNull(request.getParameter( "chart_type" ));
			String chart_title	= "";
			int chart_num_int = 1;
			String sql				= "";	
			String oh_chart_level=checkForNull(request.getParameter("oh_chart_level"));
			String other_chart_facility_id=checkForNull(request.getParameter("other_chart_facility_id"));
			String chart_num =checkForNull(request.getParameter("chart_num"));

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			if(oh_chart_level.equals("E")){
				pstmt_hdr = con.prepareStatement("SELECT CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'");
				pstmt_hdr.setString(1,patient_id);
				rs = pstmt_hdr.executeQuery();
			
				while(rs.next()){
					chart_num = checkForNull(rs.getString("CHART_NUM"),"1");
				}
			
					
				// Update the current active chart to Closed state. ('C')
				if(pstmt_hdr != null) pstmt_hdr.close();
				sql = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE  PATIENT_ID = ? AND CHART_STATUS='A'";
				pstmt_hdr = con.prepareStatement(sql);
				pstmt_hdr.setString(1,login_user);
				pstmt_hdr.setString(2,patient_id);
				flag = pstmt_hdr.executeUpdate();
				flag_arr.add(""+flag);
				if(!flag_arr.contains("0")){
					con.commit();
				}else{
					con.rollback();
				}
			}else{
				pstmt_hdr = con.prepareStatement("SELECT MAX(CHART_NUM) CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'");
					pstmt_hdr.setString(1,patient_id);
					rs = pstmt_hdr.executeQuery();
				while(rs.next()){
						chart_num = checkForNull(rs.getString("CHART_NUM"),"1");
				} 
			
				// Update the current active chart to Closed state. ('C')
				if(pstmt_hdr != null) pstmt_hdr.close();
				sql = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_STATUS='A'";
				pstmt_hdr = con.prepareStatement(sql);
				pstmt_hdr.setString(1,login_user);
				pstmt_hdr.setString(2,facility_id);
				pstmt_hdr.setString(3,patient_id);
				flag = pstmt_hdr.executeUpdate();
				flag_arr.add(""+flag);
				if(!flag_arr.contains("0")){
					con.commit();
				}else{
					con.rollback();
				}
			}

			if(flag != 0){
				chart_num_int = Integer.parseInt(chart_num);
				chart_num_int = chart_num_int+1;
			}

			if(pstmt_hdr != null) pstmt_hdr.close();
			
			sql = "INSERT INTO OH_RESTORATIVE_CHART_HDR(OPERATING_FACILITY_ID, PATIENT_ID,CHART_NUM, CHART_DATE, CHART_TYPE,CLINICAL_GROUP_CODE, CHART_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CHART_TITLE) VALUES (?, ?, ?, SYSDATE, ? ,NULL,'A', ?, SYSDATE,  ?, ?, ?, SYSDATE,  ?, ?, ?)";
			pstmt_hdr = con.prepareStatement(sql);
			pstmt_hdr.setString(1,facility_id);
			pstmt_hdr.setString(2,patient_id);
			pstmt_hdr.setString(3,chart_num_int+"");
			pstmt_hdr.setString(4,chart_type);
			pstmt_hdr.setString(5,login_user);
			pstmt_hdr.setString(6,client_ip_address);
			pstmt_hdr.setString(7,facility_id);
			pstmt_hdr.setString(8,login_user);
			pstmt_hdr.setString(9,client_ip_address);
			pstmt_hdr.setString(10,facility_id);
			pstmt_hdr.setString(11,chart_title);
			flag = pstmt_hdr.executeUpdate();

			if(flag != 0){
				con.commit();
			}else{
				con.rollback();
			}
						
			out.println(flag);
		}
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from DentalChartCommonValidation.jsp "+e);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt_task!=null) pstmt_task.close();
		if(pstmt_dtl!=null) pstmt_dtl.close();
		if(pstmt_hdr!=null) pstmt_hdr.close();
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
