package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __clinicallocationchkmaxpat extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ClinicAllocationChkMaxPat.jsp", 1711964747229L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head></head>\n <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<body class=message  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=dummy>\n<script src=\'../../eOA/js/BookAppointment.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<script>\n\t\tvar errors = getMessage(\"TOT_ALCN_NOT_GT_MX_PAT_DAY\",\"OA\");\n\t\talert(errors);\n\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\" ;\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar error = getMessage(\"SCH_ALREADY_EXISTS\",\"OA\");\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\" +error;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar max_patient_per_day=parseInt(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\');\n\t\t\t\t\t\tvar total_New_Old_Pat=parseInt(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\');\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].rule_appl_yn.value ==\'Y\'){\n\t\t\t\t\t\t\tif(max_patient_per_day == total_New_Old_Pat){\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].submit() ;\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\'SUM_MAX_NEW_OLD_MAXPATPERDAY\',\'OA\');\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].submit() ;\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar max_patient_per_day=parseInt(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\n\t\t\t\t\tvar total_New_Old_Pat=parseInt(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');\n\t\t\t\t\tif(parent.frames[1].document.forms[0].rule_appl_yn.value ==\'Y\'){\n\t\t\t\t\t\tif(max_patient_per_day == total_New_Old_Pat){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].submit() ;\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\'SUM_MAX_NEW_OLD_MAXPATPERDAY\',\'OA\');\n\t\t\t\t\t\t}\n\t\t\t\t\t}else{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].submit() ;\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\tvar max_patients_per_day = parseInt(parent.frames[1].document.forms[0].max_patients_per_day.value);\n\n\t\t\t\tif(parent.frames[1].document.forms[0].rule_appl_yn.value == \'Y\'){\n\t\t\t\t\tvar max_new_patients = parseInt(parent.frames[1].document.forms[0].max_new_patients.value);\n\t\t\t\t\tvar max_old_patients = parseInt(parent.frames[1].document.forms[0].max_old_patients.value);\n\t\t\t\t\tif(max_patients_per_day == (max_new_patients+max_old_patients)){\n\t\t\t\t\t\tparent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].l_max_pat_per_slot.value=parent.frames[1].document.forms[0].b_max_slots_per_day.value;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].action=\"../../servlet/eOA.TimeTableServlet\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].submit() ;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\'SUM_MAX_NEW_OLD_MAXPATPERDAY\',\'OA\');\n\t\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tparent.frames[1].document.forms[0].b_max_slots_per_day.disabled = false;\n\t\t\t\tparent.frames[1].document.forms[0].l_max_pat_per_slot.value=parent.frames[1].document.forms[0].b_max_slots_per_day.value;\n\t\t\t\tparent.frames[1].document.forms[0].action=\"../../servlet/eOA.TimeTableServlet\";\n\t\t\t\tparent.frames[1].document.forms[0].submit() ;\n\t\t\t}\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	String balnkString="";
	boolean check_ovelap = true;
	boolean allow_sch_overlap = false;
	int count = 0;
try{
		conn = ConnectionManager.getConnection(request);

	String fin_string=request.getParameter("fin_string");


	String max_patient=request.getParameter("max_patient");


	String calling_from=request.getParameter("calling_from");
	//String facilityid=(String)session.getValue("facility_id");

	

	if (calling_from==null) calling_from="";
	
	int max_patient_per_day=Integer.parseInt(max_patient);
	int chk_percen=0;
	int max_percen=0;
	String inner_string="";
	String patient="";
	//String holiday_check="Y";

	String caller=request.getParameter("caller");
	if (caller==null) caller="N";
	StringTokenizer indtoken = new StringTokenizer(fin_string, "|");
	if (calling_from.equals("day_schedule")){
		while (indtoken.hasMoreTokens()){
			inner_string = indtoken.nextToken();
				StringTokenizer stoken = new StringTokenizer(inner_string,"$");
					while(stoken.hasMoreTokens()){
							stoken.nextToken();
							patient					= stoken.nextToken();
							chk_percen				= Integer.parseInt(patient);
							stoken.nextToken();
							max_percen				+=chk_percen;

					}

		}
	}else{
		while (indtoken.hasMoreTokens()){
			inner_string = indtoken.nextToken();
				StringTokenizer stoken = new StringTokenizer(inner_string,"$");
					while(stoken.hasMoreTokens()){
							stoken.nextToken();
							patient					= stoken.nextToken();
							chk_percen				= Integer.parseInt(patient);
							stoken.nextToken();
							max_percen				+=chk_percen;

					}

		}
	}
	if(max_percen>max_patient_per_day){
            _bw.write(_wl_block2Bytes, _wl_block2);
}else{		
		if (calling_from.equals("day_schedule")){
			int max_new_patients=Integer.parseInt(request.getParameter("max_new_patients"));
			int max_old_patients=Integer.parseInt(request.getParameter("max_old_patients"));
			int total_New_Old_Pat=max_new_patients+max_old_patients;
			if(caller.equals("Y")){

				String facility_id=request.getParameter("facility_id");
				String cln_dt=request.getParameter("cln_dt");
				String cln_cd=request.getParameter("cln_cd");
				String practitioner=request.getParameter("practitioner")==null?"":request.getParameter("practitioner");
				
				String resourceType=request.getParameter("resourceType");
				String start_time=request.getParameter("start_time");
				String end_time=request.getParameter("end_time");
				String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
				String rule_appl_yn=request.getParameter("rule_appl_yn")==null?"":request.getParameter("rule_appl_yn");
				//String sql1="Select '1' From oa_clinic_schedule where facility_id=? and clinic_code=?  and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and nvl(Practitioner_id,'X')= nvl( ? ,'X') ";
				String sql1="";
				String sql="SELECT a.functionality_id, a.key_1, a.value_1, a.key_2, a.value_2 FROM sm_function_control a,sm_site_param b WHERE a.module_id = 'OA' AND a.functionality_id = 'ALLOW_SCH_OVERLAP' AND a.site_id = b.customer_id";				
				String ovelap_key_1="";
				String ovelap_value_1="";
				String ovelap_key_2="";
				String ovelap_value_2="";
				if(pstmt!=null)pstmt.close();
				pstmt=conn.prepareStatement(sql);
				if(rs!=null)rs.close();
				rs = pstmt.executeQuery();
				if( rs != null && rs.next()){
					allow_sch_overlap=true;
					ovelap_key_1=rs.getString("key_1");
					ovelap_value_1=rs.getString("value_1");
					ovelap_key_2=rs.getString("key_2");
					ovelap_value_2=rs.getString("value_2");				
				}
				if(mode!=null && mode.equals("insert")){
					//sql1="Select '1' From oa_clinic_schedule where facility_id=? and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and nvl(Practitioner_id,'X')= nvl( ? ,'X') AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR clinic_code=? ) ";
					if(practitioner.equals("")){
						sql1="SELECT count(*) count  FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id is null";
						pstmt=conn.prepareStatement(sql1);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,cln_dt);
						pstmt.setString(3,resourceType);
						pstmt.setString(4,cln_cd);
					}else{
						//if(rule_appl_yn.equals("Y")){// commented by sudhakar for overlapping schedules
							if(!allow_sch_overlap){
								sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND ((clinic_code = ? AND practitioner_id = ?)OR (practitioner_id = ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi')))))";
								pstmt=conn.prepareStatement(sql1);
								//pstmt.setString(1,facility_id);
								pstmt.setString(1,cln_dt);
								pstmt.setString(2,resourceType);
								pstmt.setString(3,cln_cd);
								pstmt.setString(4,practitioner);
								pstmt.setString(5,practitioner);
								pstmt.setString(6,start_time);
								pstmt.setString(7,end_time);
								pstmt.setString(8,start_time);
								pstmt.setString(9,end_time);	
								pstmt.setString(10,start_time);
								pstmt.setString(11,end_time);
							}else{
								sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id = ?";
								pstmt=conn.prepareStatement(sql1);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,cln_dt);
								pstmt.setString(3,resourceType);
								pstmt.setString(4,cln_cd);
								pstmt.setString(5,practitioner);
								if(ovelap_value_2!=null){
									if(rs!=null)rs.close();
									rs = pstmt.executeQuery();													
									if( rs != null && rs.next()){
										count = rs.getInt("count");
									}
								}
								if(!(count >0) && (ovelap_value_2!=null && !balnkString.equals(ovelap_value_2))){
									count=0;
									sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND practitioner_id = ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) AND resource_class = ?";
									pstmt=conn.prepareStatement(sql1);
									pstmt.setString(1,facility_id);
									pstmt.setString(2,cln_dt);
									pstmt.setString(3,resourceType);
									pstmt.setString(4,practitioner);
									pstmt.setString(5,start_time);
									pstmt.setString(6,end_time);
									pstmt.setString(7,start_time);
									pstmt.setString(8,end_time);
									pstmt.setString(9,start_time);
									pstmt.setString(10,end_time);
									pstmt.setString(11,ovelap_value_2);
								}
							}
						/*}else{// commented by sudhakar for overlapping schedules
							sql1="SELECT count(*) count FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id = ?";
							pstmt=conn.prepareStatement(sql1);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,cln_dt);
							pstmt.setString(3,resourceType);
							pstmt.setString(4,cln_cd);
							pstmt.setString(5,practitioner);						
						}*/
						
					}
				}else{//modify mode	
					if(practitioner.equals("")){
						sql1="SELECT count(*) count  FROM oa_clinic_schedule WHERE facility_id = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND resource_class = ? AND clinic_code = ? AND practitioner_id is null ";
						pstmt=conn.prepareStatement(sql1);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,cln_dt);
						pstmt.setString(3,resourceType);
						pstmt.setString(4,cln_cd);
					}else{
						//if(rule_appl_yn.equals("Y")){// commented by sudhakar for overlapping schedules
						if(!allow_sch_overlap){
							sql1="Select count(*) count From oa_clinic_schedule where clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and Practitioner_id= ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi')))";
							pstmt=conn.prepareStatement(sql1);
							//pstmt.setString(1,facility_id);
							pstmt.setString(1,cln_dt);
							pstmt.setString(2,resourceType);
							pstmt.setString(3,practitioner);
							pstmt.setString(4,start_time);
							pstmt.setString(5,end_time);
							pstmt.setString(6,start_time);
							pstmt.setString(7,end_time);
							pstmt.setString(8,start_time);
							pstmt.setString(9,end_time);
						}else{
							if(ovelap_value_2==null){
								check_ovelap =false;
							}else{
								sql1="Select count(*) count From oa_clinic_schedule where facility_id=? and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and Practitioner_id= ? AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN ? AND ? OR TO_CHAR (end_time, 'HH24:mi') BETWEEN ? AND ?) OR (? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR ? BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) AND resource_class = ?";
								pstmt=conn.prepareStatement(sql1);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,cln_dt);
								pstmt.setString(3,resourceType);
								pstmt.setString(4,practitioner);
								pstmt.setString(5,start_time);
								pstmt.setString(6,end_time);
								pstmt.setString(7,start_time);
								pstmt.setString(8,end_time);
								pstmt.setString(9,start_time);
								pstmt.setString(10,end_time);
								pstmt.setString(11,ovelap_value_2);
							}
						}
						/*}else{// commented by sudhakar for overlapping schedules
							sql1="Select count(*) count From oa_clinic_schedule where facility_id=? and clinic_date=to_date(?,'dd/mm/yyyy')  and RESOURCE_CLASS=? and Practitioner_id= ? AND clinic_code = ?";
							pstmt=conn.prepareStatement(sql1);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,cln_dt);
							pstmt.setString(3,resourceType);
							pstmt.setString(4,practitioner);
							pstmt.setString(5,cln_cd);
						}*/
					}			
				}				
				if(rs!=null)rs.close();
				if((mode!=null && mode.equals("insert")) || (mode!=null && mode.equals("modify") && check_ovelap)){
					rs = pstmt.executeQuery(); 
					//int count = 0;				
					if( rs != null && rs.next()){
						count = rs.getInt("count");
					}
				}
				if(((mode!=null && mode.equals("insert")) && count > 0) || (!(mode!=null && mode.equals("insert"))&&count > 1)){				
					
            _bw.write(_wl_block3Bytes, _wl_block3);
}else{
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(max_patient_per_day));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(total_New_Old_Pat));
            _bw.write(_wl_block6Bytes, _wl_block6);
}
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(max_patient_per_day));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(total_New_Old_Pat));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
}catch( Exception e ){
	e.printStackTrace();
	//out.println(e.toString());
}finally{
	try{
		if(conn!=null) 	ConnectionManager.returnConnection(conn,request);
	}catch(Exception e){out.println(e);}
}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
