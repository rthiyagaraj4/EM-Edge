package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __visitregistrationmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/VisitRegistrationMain.jsp", 1737974575610L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t     <script>\n\t      alert(getMessage(\'OP_PARAM_NOT_FOUND\',\'OP\')); \n\t     document.location.href =\'../../eCommon/jsp/dmenu.jsp\'\n\t     </script>\n\t\t ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t     <script>\n\t      alert(getMessage(\'VST_TYP_DERV_INS\',\'OP\')); \n\t     document.location.href =\'../../eCommon/jsp/dmenu.jsp\'\n\t     </script>\n\t\t ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<html>\n\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<iframe name=\'patient_main\' src=\'../../eOP/jsp/VisitRegistrationHead.jsp?&oper_stn_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&emer_regn_allow_yn=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&visit_for_inpat_yn=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&oa_install_yn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&register_visit_walkin=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&register_visit_referral=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&error=&disable_pat_reg=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&reg_vis_param=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&function_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&bl_interface_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&wait_list_inv=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&status=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&or_install_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&build_episode_rule=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&register_pat_yn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&query_string=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&call_from=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=0 scrolling=\'no\' style=\'height: 4vh;width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'patient_sub\'  src=\'../../eOP/jsp/VisitRegistrationCriteria.jsp?patient=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&q_appt_ref_no=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&referral_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&q_clinic_code=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&q_visit_adm_type=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&q_practitioner_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&q_visit_adm_type_ind=R&build_episode_rule=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\t&oa_install_yn=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&oper_stn_id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&accept_dis_inv_no=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' frameborder=0 scrolling=\'no\' style=\'height: 58vh;width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'patient_sub2\' id=\'patient_sub2\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' scrolling=\'no\' style=\'height: 0vh;width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'patient_sub3\' id=\'patient_sub3\' src=\'../../eOP/jsp/VisitRegistrationResult.jsp?patient=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&locn_ind=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&q_appt_time=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&functionId=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&menu_function_id=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&contact_reason_code=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&reason=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&service_code=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&query_String=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&resource_class=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' frameborder=0 noresize scrolling=\'no\' style=\'height: 0vh;width:99vw\'></iframe>\n<!-- passed the value visit_for_inpat_yn for SRR20056-SCF-3046.1 [IN:026060] by Suresh M on 21.01.2010 -->\n\t\t\t\t<iframe name=\'patient_sub4\' id=\'patient_sub4\' src=\'../../eOP/jsp/VisitRegistrationApptRecds.jsp?patient_id=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&cur_appt_ref_no=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' frameborder=0 scrolling=\'auto\' style=\'height: 0vh;width:99vw\'></iframe>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t   \n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<iframe name=\'patient_main\' id=\'patient_main\' src=\'../../eOP/jsp/VisitRegistrationHead.jsp?&oper_stn_id=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' frameborder=\'0\'  scrolling=\'no\' style=\'height: 4vh;width:99vw\'></iframe>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<iframe name=\'patient_sub\' id=\'patient_sub\' src=\'../../eOP/jsp/VisitRegistrationCriteria.jsp?&objName=checkin_tab&oper_stn_id=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&disable_pat_reg=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&register_visit_yn=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' frameborder=\'0\'  scrolling=\'no\' style=\'height: 58vh;width:99vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<iframe name=\'patient_sub\' id=\'patient_sub\' src=\'../../eOP/jsp/VisitRegistrationCriteria.jsp?&objName=invitation_tab&oper_stn_id=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&from_head=Y&reg_vis_param=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&divval=Y&bl_interface_yn=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' frameborder=\'0\'  scrolling=\'no\' style=\'height: 58vh;width:99vw\'></iframe>\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\n\t\t\t<!-- <frame name=\'patient_sub2\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize>\n\t\t\t<frame name=\'patient_sub3\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\'>\n\t\t\t<frame name=\'patient_sub4\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize>\t -->\n\t\t\t\n\t\t\t<iframe name=\'patient_sub2\' id=\'patient_sub2\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\'  scrolling=\'no\' style=\'height: 0vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\'patient_sub3\' id=\'patient_sub3\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\'  scrolling=\'no\' style=\'height: 0vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\'patient_sub4\' id=\'patient_sub4\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\'  scrolling=\'auto\' style=\'height: 0vh;width:99vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<!-- </frameset>\t -->\t\t\n\t\t\t\n\t\t\t</html>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

    try
    { 

		con = ConnectionManager.getConnection(request);
		String facilityid       = (String) session.getValue("facility_id");
		if(facilityid == null || facilityid.equals("null"))
			facilityid = "";  
		String userid           = (String) session.getValue("login_user");
		if(userid == null || userid.equals("null"))
			userid = "";
		String query_string     =(request.getParameter("querY_string") == null)?"":request.getParameter("query_string");    
//		String fromserv     =(request.getParameter("fromserv") == null)?"":request.getParameter("fromserv");   
			
		String call_from     =(request.getParameter("call_from") == null)?"":request.getParameter("call_from");

		String patient     =(request.getParameter("patient") == null)?"":request.getParameter("patient");
		String q_appt_ref_no     =(request.getParameter("q_appt_ref_no") == null)?"":request.getParameter("q_appt_ref_no");
		String referral_id     =(request.getParameter("referral_id") == null)?"":request.getParameter("referral_id");
		String q_clinic_code     =(request.getParameter("q_clinic_code") == null)?"":request.getParameter("q_clinic_code");
		String q_locn_type     =(request.getParameter("q_locn_type") == null)?"":request.getParameter("q_locn_type");
		String q_Appt_time     =(request.getParameter("q_Appt_time") == null)?"":request.getParameter("q_Appt_time");				
		String q_visit_adm_type     =(request.getParameter("q_visit_adm_type") == null)?"":request.getParameter("q_visit_adm_type");
		String q_practitioner_id     =(request.getParameter("q_practitioner_id") == null)?"":request.getParameter("q_practitioner_id");
		
		String contact_reason_code =(request.getParameter("contact_reason_code") == null)?"":request.getParameter("contact_reason_code");
		String reason     =(request.getParameter("reason") == null)?"":request.getParameter("reason");
			
		String service_code     =(request.getParameter("service_code") == null)?"":request.getParameter("service_code");	
		String resource_class     =(request.getParameter("resource_class") == null)?"":request.getParameter("resource_class");
		String bl_install_yn = ((String)session.getValue("bl_operational"))==null?"N":(String)session.getValue("bl_operational");//Added for the CRF 41.1
		
		String emer_regn_allow_yn="";		
		String oper_stn_access_rule     = "";		
		String disable_pat_reg ="" ;
		String build_episode_rule="";
		String register_visit_walkin = "";
		String register_visit_referral = "";
		String OsVal="";
		String OsVal1="";
		String register_pat_yn="";
		String visit_for_inpat_yn =""; 

		String accept_dis_inv_no =""; 
		String visit_type_derv_rule =""; //added for 41.1
		String reg_vis = "" ;
		String bl_interface_yn="N";
		String or_install_yn="N";
		String patient_id = request.getParameter("p1") ;
		if(patient_id == null)  patient_id = "";
		String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id"); 
		
		String oa_install_yn="";
		String wait_list_inv=(request.getParameter("wait_list_inv")==null)?"N":request.getParameter("wait_list_inv");
		String register_visit_yn="N";
		String status=request.getParameter("status");
		if(status == null) status="N"; 		
		 
        //pstmt	= con.prepareStatement("Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_VISIT_YN'),AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_PAT_YN') FROM dual");	

        pstmt	= con.prepareStatement("Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_VISIT_YN') OsVal, AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','REGISTER_PAT_YN') OsVal1, (select install_yn from sm_module where module_id='OA') install_yn, (select operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR') operational_yn FROM dual");
		
		rs	= pstmt.executeQuery() ;
		rs.next();
	    OsVal = rs.getString("OsVal")==null?"":rs.getString("OsVal");
		OsVal1 = rs.getString("OsVal1")==null?"":rs.getString("OsVal1");
		oa_install_yn = rs.getString("install_yn")==null?"":rs.getString("install_yn");
		or_install_yn = rs.getString("operational_yn")==null?"":rs.getString("operational_yn");

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

        if(OsVal.equals("1"))
		 {
		 out.print(" <script>alert(getMessage('VISIT_REGN_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		 }else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {
				register_visit_yn="Y";
    	   
			  if((!OsVal1.equals("1")) && (!OsVal1.equals("2")) && (!OsVal1.equals("3")) && (!OsVal1.equals("4")) && (!OsVal.equals("5")))
			  { 
				register_pat_yn="Y"; 				
			  }

		/* Merged with previous query for Performance Tuning on 16th Apr 2010

		pstmt  = con.prepareStatement("select install_yn from sm_module where module_id='OA'");
		rs = pstmt.executeQuery();
		if(rs.next())
        oa_install_yn = rs.getString("install_yn");
    	if(rs != null) rs.close();
	    if(pstmt != null) pstmt.close();
	
		pstmt   = con.prepareStatement("select operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR'");
		rs=pstmt.executeQuery();
		if(rs != null && rs.next())
		{
		   or_install_yn=rs.getString("operational_yn");
		}
		

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		*/	
		
		pstmt  = con.prepareStatement("select oper_stn_access_rule, build_episode_rule, bl_interfaced_yn, ALLOW_WL_INV_WO_APPT_YN, ALLOW_EMER_REGN_YN, REG_VISIT_FOR_INPAT_YN, accept_display_inv_no,visit_type_derv_rule from op_param where operating_facility_id='"+facilityid+"'");//modified for 41.1

		rs = pstmt.executeQuery();
		if(rs.next())
	      {
				oper_stn_access_rule = rs.getString("oper_stn_access_rule")==null?"":rs.getString("oper_stn_access_rule");
				bl_interface_yn = rs.getString("bl_interfaced_yn")==null?"":rs.getString("bl_interfaced_yn");
				wait_list_inv=rs.getString("ALLOW_WL_INV_WO_APPT_YN")==null?"":rs.getString("ALLOW_WL_INV_WO_APPT_YN");
				build_episode_rule=rs.getString("build_episode_rule")==null?"":rs.getString("build_episode_rule");
				emer_regn_allow_yn=rs.getString("ALLOW_EMER_REGN_YN")==null?"N":rs.getString("ALLOW_EMER_REGN_YN");
				visit_for_inpat_yn =rs.getString("REG_VISIT_FOR_INPAT_YN")==null?"N":rs.getString("REG_VISIT_FOR_INPAT_YN");

				accept_dis_inv_no = rs.getString("accept_display_inv_no") == null ? "":rs.getString("accept_display_inv_no");
				visit_type_derv_rule = rs.getString("visit_type_derv_rule") == null ? "":rs.getString("visit_type_derv_rule");
				
		  }   

	    if(rs != null) rs.close();
	    if(pstmt != null) pstmt.close();
    	if(oper_stn_access_rule.equals(""))	{	
	    
            _bw.write(_wl_block2Bytes, _wl_block2);
}   	
		 else if(visit_type_derv_rule.equals("B") && bl_install_yn.equals("N"))	{	
	    
            _bw.write(_wl_block3Bytes, _wl_block3);
}
		
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();
		
	} 
	
	 
 		if(wait_list_inv.equals("Y") && status.equals("Y"))
		{
			wait_list_inv ="Y";
			
		}
       
       
            _bw.write(_wl_block4Bytes, _wl_block4);

			if(call_from.equals("CA"))
			{
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_pat_reg));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(reg_vis));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(wait_list_inv));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(query_string,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(accept_dis_inv_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(q_locn_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(q_Appt_time));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);

		    }
			else
			{
		
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_pat_reg));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(reg_vis));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(wait_list_inv));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(query_string,"UTF-8")));
            _bw.write(_wl_block48Bytes, _wl_block48);
         
           
				if(wait_list_inv.equals("N"))
				{
			 
			
            _bw.write(_wl_block49Bytes, _wl_block49);
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_pat_reg));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(reg_vis));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(wait_list_inv));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(register_visit_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(accept_dis_inv_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(query_string,"UTF-8")));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}
				else
				{ 
				
            _bw.write(_wl_block49Bytes, _wl_block49);
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_pat_reg));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(reg_vis));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(wait_list_inv));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(register_visit_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(accept_dis_inv_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(query_string,"UTF-8")));
            _bw.write(_wl_block57Bytes, _wl_block57);

				}
			
            
		
            _bw.write(_wl_block58Bytes, _wl_block58);

			}
			
            _bw.write(_wl_block59Bytes, _wl_block59);
			
        }
    catch (Exception e) { out.println(e) ; e.printStackTrace();}
	finally{

	 if(con != null) ConnectionManager.returnConnection(con,request);

}

            _bw.write(_wl_block60Bytes, _wl_block60);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
