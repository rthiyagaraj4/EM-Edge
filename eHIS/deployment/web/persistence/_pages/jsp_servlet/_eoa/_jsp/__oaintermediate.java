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
import eCommon.Common.*;
import org.json.simple.*;

public final class __oaintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAIntermediate.jsp", 1720615280389L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

public static String compareList(ArrayList newList) {

    ArrayList list1 = (ArrayList) newList.get(0);
	ArrayList tempList1 = new ArrayList(list1);

	ArrayList total_sel_from_serial_no = (ArrayList) newList.get(1);
	ArrayList temptotal_sel_from_serial_no = new ArrayList(total_sel_from_serial_no);
	ArrayList final_from_serial_no = new ArrayList();

	ArrayList total_sel_from_appt_ref_no = (ArrayList) newList.get(2);
	ArrayList temptotal_sel_from_appt_ref_no = new ArrayList(total_sel_from_appt_ref_no);
	ArrayList final_from_appt_ref_no = new ArrayList();

	ArrayList total_sel_from_visit_type_ind = (ArrayList) newList.get(3);
	ArrayList temptotal_sel_from_visit_type_ind = new ArrayList(total_sel_from_visit_type_ind);
	ArrayList final_from_visit_type_ind = new ArrayList();

	ArrayList list2 = (ArrayList) newList.get(4);
	ArrayList tempList2 = new ArrayList(list2);

	ArrayList total_to_side_srlno = (ArrayList) newList.get(5);
	ArrayList temptotal_to_side_srlno = new ArrayList(total_to_side_srlno);
	ArrayList final_to_side_srlno = new ArrayList();

    boolean exitI = false;
    boolean exitJ = false;
    boolean flag = false;
	int rem_cnt = 0;
	int noofslot = 0;
    ArrayList tosrlresultList = new ArrayList();
	String result_from_serial_no = "";
	String result_from_appt_ref_no = "";
	String result_from_visit_type_ind = "";
	StringBuilder result_to_srl_no = new StringBuilder();
	String result_to_serial_no = "";
	String resultList = "";

    for (int i = 0; i < tempList1.size(); i++) {
		
		if(tempList1.isEmpty()){
			exitI = true;
		}

        for (int j = 0; j <= tempList2.size(); j++) {
		
			if(j == tempList2.size()){
				exitJ = true;
			}else{
				exitJ = false;
			}

			if(!exitJ){
				
				if (((Integer)tempList2.get(j) - (Integer)tempList1.get(i)) >= 0) {

					rem_cnt = ((Integer)tempList2.get(j) - (Integer)tempList1.get(i));
					noofslot = (Integer)tempList1.get(i);
					tempList1.remove(i);

					final_from_serial_no.add(temptotal_sel_from_serial_no.get(i));
					temptotal_sel_from_serial_no.remove(i);

					final_from_appt_ref_no.add(temptotal_sel_from_appt_ref_no.get(i));
					temptotal_sel_from_appt_ref_no.remove(i);
					
					final_from_visit_type_ind.add(temptotal_sel_from_visit_type_ind.get(i));
					temptotal_sel_from_visit_type_ind.remove(i);

					if(rem_cnt == 0){
						tempList2.remove(j);
						final_to_side_srlno = processSerialNumbers(temptotal_to_side_srlno, j, noofslot);
						flag = true;
						i = -1;
					}else{
						tempList2.remove(j);
						tempList2.add(j,rem_cnt);
						final_to_side_srlno = processSerialNumbers(temptotal_to_side_srlno, j, noofslot);
						flag = true;
						i = -1;
					}

					tosrlresultList.add(final_to_side_srlno);
									
					if(tempList1.isEmpty() || flag == true){
					exitJ = true;
					}
				}
			}
				
			if (exitJ) {
				break;
			}
        }

        if (exitI) {
            break;
        }
    }

	if(!tempList1.isEmpty()){
		resultList = "NOEMPTYSLOTS";
	}else{
		for (int i = 0; i < final_from_serial_no.size(); i++) {
            result_from_serial_no += final_from_serial_no.get(i);
            if (i < final_from_serial_no.size() - 1) {
                result_from_serial_no += "$";
            }
        }

		for (int i = 0; i < final_from_appt_ref_no.size(); i++) {
            result_from_appt_ref_no += final_from_appt_ref_no.get(i);
            if (i < final_from_appt_ref_no.size() - 1) {
                result_from_appt_ref_no += "$";
            }
        }

		for (int i = 0; i < final_from_visit_type_ind.size(); i++) {
            result_from_visit_type_ind += final_from_visit_type_ind.get(i);
            if (i < final_from_visit_type_ind.size() - 1) {
                result_from_visit_type_ind += "$";
            }
        }
        
        for (int i = 0; i < tosrlresultList.size(); i++) {
            ArrayList subList = (ArrayList) tosrlresultList.get(i);
            for (int j = 0; j < subList.size(); j++) {
                result_to_srl_no.append(subList.get(j));
                if (j < subList.size() - 1) {
                    result_to_srl_no.append("^");
                }
            }
            if (i < tosrlresultList.size() - 1) {
                result_to_srl_no.append("$");
            }
        }

		result_to_serial_no = result_to_srl_no.toString();

		resultList = result_from_serial_no+"||"+result_from_appt_ref_no+"||"+result_from_visit_type_ind+"||"+result_to_serial_no;
	}

    return resultList;
}

public static ArrayList processSerialNumbers(ArrayList serialList, int index, int noofslot) {
	String indexStr = (String) serialList.get(index);
	String[] serialNumbers = indexStr.split("~");

	ArrayList serialNumberList = new ArrayList();
	for (String num : serialNumbers) {
		if (!num.equals("")) {
			serialNumberList.add(num);
		}
	}

	ArrayList removedValues;
	if (serialNumberList.size() >= noofslot) {
		removedValues = new ArrayList(serialNumberList.subList(0, noofslot));
		serialNumberList = new ArrayList(serialNumberList.subList(noofslot, serialNumberList.size()));
	} else {
		removedValues = new ArrayList(serialNumberList);
		serialNumberList.clear();
	}

	StringBuilder newIndexStr = new StringBuilder();
	for (Object value : serialNumberList) {
		newIndexStr.append((String) value).append("~");
	}
	
	if (newIndexStr.length() == 0) {
		serialList.remove(index);
	} else {
		serialList.set(index, newIndexStr.toString());
	}

	return removedValues;
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	Connection conn	= null;
	conn = ConnectionManager.getConnection(request);
	String locale = (String)session.getAttribute("LOCALE");

try{

	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	
	String action =	(String) hash.get("action")==null?"":(String) hash.get("action");

	if(action.equals("")){
		action = request.getParameter("action")==null?"": request.getParameter("action");
	}
	
	if(action.equals("allowUncheckValidate")){
		int extnd_cnt = eOA.OACommonBean.getScheduleExtendYNCnt(conn);
		out.println(extnd_cnt);
	}

	if(action.equals("timeDifference")){
		String endtime = (String) hash.get("endtime");
		String time_diff = eOA.OACommonBean.getEndTimeDifference(conn,endtime);
		out.println(time_diff);
	}

	if(action.equals("getIdentAtCheckinVal")){
		String fac_id = (String) hash.get("fac_id");
		String clinic_code = (String) hash.get("clinic_code");
		String ident_at_checkin = "";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			String sql = "SELECT ident_at_checkin FROM op_clinic WHERE facility_id = ? AND clinic_code = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,fac_id);
			pstmt.setString(2,clinic_code);
			
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				ident_at_checkin = rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getIdentAtCheckinVal - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		out.println(ident_at_checkin);
	}

	if(action.equals("bulktransfer_to_sch_exists")){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql_label = new StringBuffer();
		int to_slot_cnt = 0;
		String to_sch_yn = "";

		String facilityId = (String) session.getValue("facility_id");
		String locn_type = (String) hash.get("locn_type");
		String clinic_type_to = (String) hash.get("clinic_type_to");
		String resc_class_to = (String) hash.get("resc_class_to");
		String to_date = (String) hash.get("to_date");
		String resc_code_to = (String) hash.get("resc_code_to");
		
		try{
			sql_label.append("SELECT count(*) to_slot_cnt FROM oa_clinic_schedule_slot_slab a WHERE a.facility_id = '"+facilityId+"' AND a.care_locn_type_ind = '"+locn_type+"' AND a.clinic_code = '"+clinic_type_to+"' AND a.resource_class = '"+resc_class_to+"' AND a.clinic_date = TO_DATE ('"+to_date+"', 'dd/mm/yyyy')  AND a.pri_appt_ref_no is null AND ext_slot_yn is null AND ");

			if(resc_code_to.equals("")){
				sql_label.append("a.practitioner_id is null");
			}else{
				sql_label.append("a.practitioner_id = '"+resc_code_to+"'");
			}

			pstmt = conn.prepareStatement(sql_label.toString());
			
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()) 
			{
				to_slot_cnt = rs.getInt(1);
			}

			if(to_slot_cnt > 0){
				to_sch_yn = "Y";
			}else{
				to_sch_yn = "N";
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in bulktransfer_to_sch_exists - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		out.println(to_sch_yn);
	}

	if(action.equals("MultiSelectionApptRescheduling")){
		String fac_id = (String) hash.get("fac_id");
		String from_locn = (String) hash.get("from_locn");
		String from_resc = (String) hash.get("from_resc");
		String from_date = (String) hash.get("from_date");
		from_date = com.ehis.util.DateUtils.convertDate(from_date,"DMY","en",locale);
		String from_srl_no = (String) hash.get("from_srl_no");
		int from_srl_num = Integer.parseInt(from_srl_no);
		String to_locn = (String) hash.get("to_locn");
		String to_resc = (String) hash.get("to_resc");
		String to_date = (String) hash.get("to_date");
		to_date = com.ehis.util.DateUtils.convertDate(to_date,"DMY","en",locale);
		String to_srl_no = (String) hash.get("to_srl_no");
		String trf_from_time = (String) hash.get("trf_from_time");
		String trf_to_time = (String) hash.get("trf_to_time");
		String selected_appt = (String) hash.get("selected_appt");
		String curr_user_id = (String) hash.get("curr_user_id");
		String workstation_id = (String) hash.get("workstation_id");
		String reason_code_revision = (String) hash.get("reason_code_revision");
		String to_res_class = (String) hash.get("to_res_class");
		String no_of_slots = (String) hash.get("no_of_slots");
		int num_of_slots = Integer.parseInt(no_of_slots);
		String resch_status = "";
		CallableStatement cstmt = null;

		try{
			cstmt = conn.prepareCall("{call OA_RESCHEDULE_MULTIPLE_APPT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, fac_id );
			cstmt.setString( 2, from_locn );
			cstmt.setString( 3, from_resc );
			cstmt.setString( 4, from_date );
			cstmt.setInt( 5, from_srl_num );
			cstmt.setString( 6, to_locn );
			cstmt.setString( 7, to_resc );
			cstmt.setString( 8, to_date );
			cstmt.setString( 9, to_srl_no );
			cstmt.setString( 10, trf_from_time );
			cstmt.setString( 11, trf_to_time );
			cstmt.setString( 12, selected_appt );
			cstmt.setString( 13, curr_user_id );
			cstmt.setString( 14, workstation_id );
			cstmt.setString( 15, reason_code_revision );
			cstmt.setString( 16, to_res_class );
			cstmt.setInt( 17, num_of_slots );
			cstmt.registerOutParameter( 18, Types.VARCHAR );

			cstmt.execute() ;

			resch_status = cstmt.getString( 18 ); 
			if(resch_status == null) resch_status = "";

			if(resch_status.equals("SUCCESS")){
				conn.commit();
			}else{
				conn.rollback();
			}
		
		}catch(Exception ex){
			ex.printStackTrace();
			conn.rollback();
		}finally{
			try{
				if(cstmt!=null)cstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in MultiSelectionApptRescheduling - "+ex.getMessage());
				ex.printStackTrace();
				conn.rollback();
			}
		}

		out.println(resch_status);
	}

	if(action.equals("to_sch_continuous_slots_chk")){
		
		String total_to_srl_no = (String) hash.get("total_to_srl_no");
		String[] avl_to_srl_no = total_to_srl_no.split("\\$");
		int len_avl_to_srl_no = avl_to_srl_no.length;

		ArrayList total_to_continuous_slots = new ArrayList();
		ArrayList total_to_side_srlno = new ArrayList();
		ArrayList newList = new ArrayList();

		int count = 0;
		int id = 0;
		String to_side_srlno = "";
		String finallist = "";
            
        for (int i = 0; i < len_avl_to_srl_no; i++)
		{
			int currentId = Integer.parseInt(avl_to_srl_no[i]);

			if(id == 0)
			id = currentId;
			
			if(id == currentId || id+1 == currentId){
				id = currentId;
				to_side_srlno += id+"~";
				count++;
			}else{
				total_to_continuous_slots.add(count);
				total_to_side_srlno.add(to_side_srlno);
				id = currentId;
				to_side_srlno = "";
				to_side_srlno += id+"~";
				count = 1;
			}

			if((len_avl_to_srl_no-1) == i){	
				total_to_continuous_slots.add(count);
				total_to_side_srlno.add(to_side_srlno);
			}
		}

		if(!total_to_continuous_slots.isEmpty()) {
			
			ArrayList list1 = new ArrayList();
			String sel_from_no_of_slots = (String) hash.get("sel_from_no_of_slots");
			String[] sel_frm_no_of_slots = sel_from_no_of_slots.split("\\$");

			for (String frmslot : sel_frm_no_of_slots) {
				list1.add(Integer.parseInt(frmslot));
			}

			ArrayList total_sel_from_serial_no = new ArrayList();
			String sel_from_serial_no = (String) hash.get("sel_from_serial_no");
			String[] sel_frm_srl_no = sel_from_serial_no.split("\\$");

			for (String frmsrlno : sel_frm_srl_no) {
				total_sel_from_serial_no.add(Integer.parseInt(frmsrlno));
			}

			ArrayList total_sel_from_appt_ref_no = new ArrayList();
			String sel_from_appt_ref_no = (String) hash.get("sel_from_appt_ref_no");
			String[] sel_frm_appt_no = sel_from_appt_ref_no.split("\\$");

			for (String frmapptno : sel_frm_appt_no) {
				total_sel_from_appt_ref_no.add(frmapptno);
			}

			ArrayList total_sel_from_visit_type_ind = new ArrayList();
			String sel_from_visit_type_ind = (String) hash.get("sel_from_visit_type_ind");
			String[] sel_from_visit_ind = sel_from_visit_type_ind.split("\\$");

			for (String frmvstind : sel_from_visit_ind) {
				total_sel_from_visit_type_ind.add(frmvstind);
			}

			ArrayList list2 = total_to_continuous_slots;

			newList.add(list1);
			newList.add(total_sel_from_serial_no);
			newList.add(total_sel_from_appt_ref_no);
			newList.add(total_sel_from_visit_type_ind);
			newList.add(list2);
			newList.add(total_to_side_srlno);

			finallist = compareList(newList);
		}

		out.println(finallist);
	}

}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                          

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
