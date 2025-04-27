package jsp_servlet._eoa._js;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eDS.Common.JSONObject;

public final class __getgrouplocation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/js/GetGroupLocation.jsp", 1709117089654L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="          \n            \n            \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

//Based on the action arguments its return values..By default it will return group details and total member in the group as json format.... dharma
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id		= (String) session.getValue( "facility_id" ) ;
	String Group_id			= request.getParameter("GroupId")==null?"":request.getParameter("GroupId");
	String LOCN_NAME		= "";
	String LOCN_CODE		= "";
	String MIN_PATIENTS		= "";
	String MAX_PATIENTS		= "";
	String apptdate			= request.getParameter("apptdate")==null?"":request.getParameter("apptdate");
	String apptslabfmtime	= request.getParameter("fromtime")==null?"":request.getParameter("fromtime");
	String apptslabtotime	= request.getParameter("totime")==null?"":request.getParameter("totime");
	String cliniccode		= request.getParameter("cliniccode")==null?"":request.getParameter("cliniccode");
	String action			= request.getParameter("action")==null?"":request.getParameter("action");
	String action1			= request.getParameter("action1")==null?"":request.getParameter("action1");
	int isJsonResults		= 0;
	int TotMemberInGroup	= 0;
	int BookingCount		= 0;
	int SlabOverLapCount	= 0;
	int AvailableSlabCount	= 0;
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	
	JSONObject json = new JSONObject();
	String sql = "select  op_get_desc.op_clinic('"+facility_id+"', LOCN_CODE, '"+locale+"','1') LOCN_NAME,LOCN_CODE,MIN_PATIENTS,MAX_PATIENTS  from oa_group_hdr where GROUP_ID=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,Group_id);
	rs1 = pstmt.executeQuery();			
	if(rs1!=null && rs1.next()) {		 
		LOCN_NAME = rs1.getString("LOCN_NAME")==null?"":rs1.getString("LOCN_NAME");
		LOCN_CODE = rs1.getString("LOCN_CODE")==null?"":rs1.getString("LOCN_CODE");	
		MIN_PATIENTS = rs1.getString("MIN_PATIENTS")==null?"":rs1.getString("MIN_PATIENTS");
		MAX_PATIENTS = rs1.getString("MAX_PATIENTS")==null?"":rs1.getString("MAX_PATIENTS");	
	} 
	
	if(!LOCN_NAME.equals("") && !MIN_PATIENTS.equals("") && !MAX_PATIENTS.equals("")){
	      json.put("LOCN_NAME", LOCN_NAME);  
	      json.put("LOCN_CODE", LOCN_CODE); 
	      json.put("MIN_PATIENTS", MIN_PATIENTS);  
	      json.put("MAX_PATIENTS", MAX_PATIENTS); 
	      isJsonResults	= 1;
	}
		
	
	
	String sql1 = "select count(*) TOTGRPMEM from OA_GROUP_DTLS where GROUP_ID=?";
	pstmt = conn.prepareStatement(sql1);
	pstmt.setString(1,Group_id);
	rs1 = pstmt.executeQuery();	
	if(rs1!=null && rs1.next()) {		 
		TotMemberInGroup = rs1.getInt("TOTGRPMEM");
	}
	json.put("TotMemberInGroup", TotMemberInGroup);

		
	if(action.equals("get_booking_count")){
		String sql2 = "select count(*) BookingCount from oa_appt where GROUP_ID='"+Group_id+"' and appt_slab_from_time=to_date('"+apptslabfmtime+"','hh24:mi') and appt_slab_to_time=to_date('"+apptslabtotime+"','hh24:mi') and appt_date=to_date('"+apptdate+"','dd/mm/yyyy') and  facility_id = '"+facility_id+"' ";
		pstmt = conn.prepareStatement(sql2);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			BookingCount = rs1.getInt("BookingCount");
		}
		json.put("BOOKING_COUNT", BookingCount);//group booking count
	}else if(action.equals("get_slap_overlap_count")){
		String Sql3	= "SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = '"+facility_id+"'   AND ((TO_DATE('"+apptslabfmtime+"','HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE ('"+apptslabtotime+"', 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE ('"+apptslabfmtime+"', 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE ('"+apptslabtotime+"', 'hh24:miss'))) AND appt_date = TO_DATE ('"+apptdate+"', 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls)";
		pstmt = conn.prepareStatement(Sql3);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			SlabOverLapCount = rs1.getInt("SlabOverLapCount");
		}
		json.put("SLAP_OVERLAP_COUNT", SlabOverLapCount);//slab over lab count

		
	
	}else if(action.equals("chk_is_group_location")){
		String locnCode			= request.getParameter("locnCode");
		int IsGroupLocation	= 0;
		String Sql5	= "SELECT count(*) GroupLocationCount  FROM oa_group_hdr WHERE ADDED_FACILITY_ID = '"+facility_id+"' and LOCN_CODE = '"+locnCode+"' ";
		pstmt = conn.prepareStatement(Sql5);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			IsGroupLocation = rs1.getInt("GroupLocationCount");
			isJsonResults	= 1;
		}
		json.put("IsGroupLocation", IsGroupLocation);
	}
	

	
	if(action1.equals("get_available_slaps_count")){
		
		String sql4 = "select count(*) AvailableSlabCount from oa_clinic_schedule_slot_slab where to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') =to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')=to_date('"+apptslabtotime+"','hh24:mi') and CLINIC_DATE=to_date('"+apptdate+"','dd/mm/yyyy') and CLINIC_CODE='"+cliniccode+"' and FACILITY_ID='"+facility_id+"'  AND schedule_status is null";
		pstmt = conn.prepareStatement(sql4);
		System.err.println("Sql4 =>>>"+sql4);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			AvailableSlabCount = rs1.getInt("AvailableSlabCount");
			isJsonResults	= 1;
		}
		json.put("AVAILABLE_SLAP_COUNT", AvailableSlabCount);
		
	}
	
	
	
	if(pstmt != null) pstmt.close();
	if(rs1  != null) rs1.close();
	json.put("isJsonResults", isJsonResults);
	out.print(json);
	
	
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
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
