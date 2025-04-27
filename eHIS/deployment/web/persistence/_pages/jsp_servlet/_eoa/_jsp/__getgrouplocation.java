package jsp_servlet._eoa._jsp;

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
import eDS.Common.JSONArray;

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
        if (sci.isResourceStale("/eoa/jsp/GetGroupLocation.jsp", 1727255757992L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
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
	String practitionerid			= request.getParameter("practitionerid")==null?"":request.getParameter("practitionerid");
	String patientId			= request.getParameter("patientId")==null?"":request.getParameter("patientId");
	String LocnCode			= request.getParameter("LocnCode")==null?"":request.getParameter("LocnCode");
	int isJsonResults		= 0;
	int TotMemberInGroup	= 0;
	int BookingCount		= 0;
	int SlabOverLapCount	= 0;
	int AvailableSlabCount	= 0;
	int rowcnt=0;
	String PATIENT_ID	= "";
	String patient_line	= "";
	String recordslist	= "";
	String classValue	= "";
	String group_name	= "";
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	JSONObject json = new JSONObject();
	if(action.equals("chk_valid_patient")){
		webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
		patdata.setFacility_id(facility_id);
		String pat_status = patdata.CheckStatus(conn,patientId);
		json.put("pat_status", pat_status);
		out.print(json);
	}else if(action.equals("get_patient_details")){//For the Patient list its return json array.. Dharma
		int IsAlreadyExists	= 1;
		String sql1 = "select SUBSTR (get_patient_line (a.patient_id, '"+locale+"'),1,LENGTH (get_patient_line (a.patient_id,  '"+locale+"')) - 6) patient_line,a.patient_id FROM mp_patient a WHERE a.deceased_yn = 'N' AND a.suspend_yn = 'N' AND a.active_yn = 'Y' and a.patient_id NOT IN ( SELECT DISTINCT c.patient_id FROM oa_group_dtls c, oa_group_hdr d WHERE c.GROUP_ID = d.GROUP_ID  AND d.locn_code = ?) and a.patient_id=?";
		pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1,LocnCode);
		pstmt.setString(2,patientId);
		rs1 = pstmt.executeQuery();
		JSONArray PatientlistArr = new JSONArray();
		if(rs1!=null && rs1.next()){
			IsAlreadyExists	= 0;
			JSONObject jsonobj = new JSONObject();
			PATIENT_ID		= (rs1.getString("PATIENT_ID")==null || rs1.getString("PATIENT_ID")=="")?"" : rs1.getString("PATIENT_ID");
			patient_line	= (rs1.getString("patient_line")==null || rs1.getString("patient_line")=="")?"" : rs1.getString("patient_line");
			
			jsonobj.put("patient_line",patient_line);
			jsonobj.put("patient_id",PATIENT_ID);
			rowcnt++;
			PatientlistArr.put(jsonobj);
		}else{
			String sql6="select a.GROUP_NAME from  oa_group_hdr a,oa_group_dtls b where  a.GROUP_ID = b.GROUP_ID and a.locn_code = ? and b.patient_id=?";
			pstmt = conn.prepareStatement(sql6);
			pstmt.setString(1,LocnCode);
			pstmt.setString(2,patientId);
			rs1 = pstmt.executeQuery();
			if(rs1!=null && rs1.next()){
				group_name		= (rs1.getString("GROUP_NAME")==null || rs1.getString("GROUP_NAME")=="")?"" : rs1.getString("GROUP_NAME");
			}
		}
		
		if(rowcnt>0){
			recordslist = PatientlistArr.toString();	
		}
		if(pstmt != null) pstmt.close();
		if(rs1  != null) rs1.close();
		
		json.put("recordslist", recordslist);
		json.put("group_name", group_name);
		json.put("IsAlreadyExists", IsAlreadyExists);
		out.print(json);

	}else if(action.equals("get_existing_grp_patient_details")){//For the Group Patient list because return the records as json array.. Dharma

		
		String sql1 = "select SUBSTR (get_patient_line (a.patient_id, '"+locale+"'),1,LENGTH (get_patient_line (a.patient_id,  '"+locale+"')) - 6) patient_line,a.patient_id FROM mp_patient a, oa_group_dtls b WHERE a.patient_id = b.patient_id AND b.GROUP_ID = ? AND a.deceased_yn = 'N' AND a.suspend_yn = 'N' AND a.active_yn = 'Y'";
		pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1,Group_id);
		rs1 = pstmt.executeQuery();	
		JSONArray PatientlistArr = new JSONArray();

		while(rs1.next()){
	 		JSONObject jsonobj = new JSONObject();
	 		PATIENT_ID		= (rs1.getString("PATIENT_ID")==null || rs1.getString("PATIENT_ID")=="")?"" : rs1.getString("PATIENT_ID");
	 		patient_line	= (rs1.getString("patient_line")==null || rs1.getString("patient_line")=="")?"" : rs1.getString("patient_line");
	 		if(rowcnt%2==0)
	 			classValue="AR_QRYEVEN";
			else
				classValue="AR_QRYODD";
	 		jsonobj.put("patient_line",patient_line);
	 		jsonobj.put("tdclass",classValue);
	 		jsonobj.put("patient_id",PATIENT_ID);
	 		PatientlistArr.put(jsonobj);
			rowcnt++;
		}
		if(rowcnt>0){
			recordslist = PatientlistArr.toString();	
		}
		
		if(pstmt != null) pstmt.close();
		if(rs1  != null) rs1.close();
		
		json.put("recordslist", recordslist);
		json.put("count", rowcnt);
		out.print(json);
		
		
	}else{
		
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
			
		
		
	//	String sql1 = "select count(*) TOTGRPMEM from OA_GROUP_DTLS where GROUP_ID=?";
		String sql1 = "select count(*) TOTGRPMEM FROM mp_patient a, oa_group_dtls b WHERE a.patient_id = b.patient_id AND b.GROUP_ID = ? AND a.deceased_yn = 'N' AND a.suspend_yn = 'N' AND a.active_yn = 'Y'";
		pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1,Group_id);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			TotMemberInGroup = rs1.getInt("TOTGRPMEM");
		}
		json.put("TotMemberInGroup", TotMemberInGroup);

	}	
	if(action.equals("get_booking_count")){
		//String sql2 = "select count(*) BookingCount from oa_appt where GROUP_ID='"+Group_id+"' and appt_slab_from_time=to_date('"+apptslabfmtime+"','hh24:mi') and appt_slab_to_time=to_date('"+apptslabtotime+"','hh24:mi') and appt_date=to_date('"+apptdate+"','dd/mm/yyyy') and  facility_id = '"+facility_id+"' ";
		String sql2 = "select count(*) BookingCount from oa_appt where GROUP_ID=? and appt_slab_from_time=to_date(?,'hh24:mi') and appt_slab_to_time=to_date(?,'hh24:mi') and appt_date=to_date(?,'dd/mm/yyyy') and  facility_id = ? ";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1,Group_id);
		pstmt.setString(2,apptslabfmtime);
		pstmt.setString(3,apptslabtotime);
		pstmt.setString(4,apptdate);
		pstmt.setString(5,facility_id);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			BookingCount = rs1.getInt("BookingCount");
		}
		json.put("BOOKING_COUNT", BookingCount);//group booking count
	}else if(action.equals("get_slap_overlap_count")){
		//String Sql3	= "SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = '"+facility_id+"'   AND ((TO_DATE('"+apptslabfmtime+"','HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE ('"+apptslabtotime+"', 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE ('"+apptslabfmtime+"', 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_to_time, 'hh24:miss'),'hh24:miss') < TO_DATE ('"+apptslabtotime+"', 'hh24:miss'))) AND appt_date = TO_DATE ('"+apptdate+"', 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = '"+Group_id+"')";
		String Sql3	= "SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = ? AND ((TO_DATE(?,'HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE (?, 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE (?, 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_to_time, 'hh24:miss'),'hh24:miss') < TO_DATE (?, 'hh24:miss'))) AND appt_date = TO_DATE (?, 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = ?)";
		pstmt = conn.prepareStatement(Sql3);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,apptslabfmtime);
		pstmt.setString(3,apptslabtotime);
		pstmt.setString(4,apptslabfmtime);
		pstmt.setString(5,apptslabtotime);
		pstmt.setString(6,apptdate);
		pstmt.setString(7,Group_id);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			SlabOverLapCount = rs1.getInt("SlabOverLapCount");
		}
		json.put("SLAP_OVERLAP_COUNT", SlabOverLapCount);//slab over lab count

		
	
	}else if(action.equals("chk_is_group_location")){
		String locnCode			= request.getParameter("locnCode");
		int IsGroupLocation	= 0;
		//String Sql5	= "SELECT count(*) GroupLocationCount  FROM oa_group_hdr WHERE  LOCN_CODE = '"+locnCode+"' ";
		String Sql5	= "SELECT count(*) GroupLocationCount  FROM oa_group_hdr WHERE  LOCN_CODE = ? ";
		pstmt = conn.prepareStatement(Sql5);
		pstmt.setString(1,locnCode);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			IsGroupLocation = rs1.getInt("GroupLocationCount");
			isJsonResults	= 1;
		}
		json.put("IsGroupLocation", IsGroupLocation);
	}
	
	if(action1.equals("get_available_slaps_count")){
		
		//String sql4 = "select count(*) AvailableSlabCount from oa_clinic_schedule_slot_slab where to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') =to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')=to_date('"+apptslabtotime+"','hh24:mi') and CLINIC_DATE=to_date('"+apptdate+"','dd/mm/yyyy') and CLINIC_CODE='"+cliniccode+"' and FACILITY_ID='"+facility_id+"' AND nvl(practitioner_id,'X') = nvl('"+practitionerid+"','X') AND schedule_status is null";
		String sql4 = "select count(*) AvailableSlabCount from oa_clinic_schedule_slot_slab where to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') =to_date(?,'hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')=to_date(?,'hh24:mi') and CLINIC_DATE=to_date(?,'dd/mm/yyyy') and CLINIC_CODE=? and FACILITY_ID=? AND nvl(practitioner_id,'X') = nvl(?,'X') AND schedule_status is null";
		pstmt = conn.prepareStatement(sql4);
		pstmt.setString(1,apptslabfmtime);
		pstmt.setString(2,apptslabtotime);
		pstmt.setString(3,apptdate);
		pstmt.setString(4,cliniccode);
		pstmt.setString(5,facility_id);
		pstmt.setString(6,practitionerid);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			AvailableSlabCount = rs1.getInt("AvailableSlabCount");
			isJsonResults	= 1;
		}
		json.put("AVAILABLE_SLAP_COUNT", AvailableSlabCount);
	}
	//For Except the Group Patient list because return the records as json array.. Dharma
	if(!action.equals("get_existing_grp_patient_details") && !action.equals("get_patient_details") && !action.equals("chk_valid_patient") ){
		if(pstmt != null) pstmt.close();
		if(rs1  != null) rs1.close();
		json.put("isJsonResults", isJsonResults);
		out.print(json);
	}
	
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
