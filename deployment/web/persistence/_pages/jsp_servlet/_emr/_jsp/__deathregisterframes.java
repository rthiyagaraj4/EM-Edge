package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;

public final class __deathregisterframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DeathRegisterFrames.jsp", 1742295715783L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n\t\t<iframe name=\'pline\' id=\'pline\' \tsrc=\"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" frameborder=\"0\" scrolling=\"NO\"/ style=\'height:7vh;width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'DR_HeaderDtl_Frame\' id=\'DR_HeaderDtl_Frame\' frameborder=\'0\' noresize scrolling=\'AUTO\' style=\'height:18vh;width:99vw\' src=\"../../eMR/jsp/AddModifyDeathRegisterHeaderDtls.jsp?patient_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&encounter_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&locn_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&gender=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&dob=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&speciality_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&episode_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" &practitioner_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&practitioner_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&patient_class=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&call_from=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&episode_type=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&finalize_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&visit_adm_date=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/></iframe>\n\t\t\t\t<iframe name=\'DR_DiagnosisDtl_Frame\' id=\'DR_DiagnosisDtl_Frame\' frameborder=\'0\' noresize scrolling=\'NO\' style=\'height:37vh;width:99vw\' src=\"../../eMR/jsp/AddModifyDeathRegisterDiagnosisDtls.jsp?patient_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/></iframe>\n\t\t\t\t<iframe name=\'DR_OtherDtl_Frame\' id=\'DR_OtherDtl_Frame\' frameborder=\'0\' noresize scrolling=\'AUTO\' style=\'height:29vh;width:99vw\' src=\"../../eMR/jsp/AddModifyDeathRegisterOthersDtls.jsp?patient_id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></iframe>\n\t\t\t\t<iframe name=\'DR_Button_Frame\' id=\'DR_Button_Frame\'  src=\"../../eMR/jsp/AddModifyDeathRegisterButtons.jsp?finalize_yn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" frameborder=\'0\' noresize scrolling=\'NO\' style=\'height:3vh;width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'DR_Message_Frame\' id=\'DR_Message_Frame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\'0\' noresize scrolling=\'NO\' style=\'height:3vh;width:99vw\'></iframe>\n\t\t\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);


Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String facility_id					= checkForNull((String) session.getValue( "facility_id" ));
String patient_id				=	checkForNull(request.getParameter("patient_id"));
String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
String locn_code				=	checkForNull(request.getParameter("Locn_Code"));
String gender	 					=	checkForNull(request.getParameter("Sex"));
String dob							=	checkForNull(	request.getParameter("Dob"));
String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
String episode_id				=	checkForNull(request.getParameter("episode_id"));
String practitioner_id			=	checkForNull(request.getParameter("practitioner_id"));
String practitioner_type	=	checkForNull(request.getParameter("practitioner_type"));
String patient_class			=	checkForNull(request.getParameter("patient_class"));
String call_from					=	checkForNull(request.getParameter("call_from"));
String episode_type			=	checkForNull(request.getParameter("episode_type"));
//String mode						=	checkForNull(request.getParameter("mode"));
String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"));
String visit_adm_date		=	checkForNull(request.getParameter("visit_adm_date"));

Boolean isDeceasedDiagClassDeathRegAppl = false;
String auto_fin_death_reg_appl_yn = "N";
String primary_diag_class = "";
String secondary_diag_class = "";
String both_pri_sec_count = "";
String pri_count = "";
String sec_count = "";
String linked_yn = "";
String auto_fin_death_reg_yn = "N";

String frame_rows			=	"7%,19%,37%,34%,3%,3%";

session.removeAttribute("combined_map");
session.removeAttribute("diag_dates_map");

	
	if(call_from.equals("VIEW_DEATH_REG")){
		frame_rows="7%,20%,37%,34%,0%,4%";
	}

try{
	conn = ConnectionManager.getConnection(request);

	isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG");
	
	/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
	if(isDeceasedDiagClassDeathRegAppl){

		String MRSql = "select auto_fin_death_reg_appl_yn, primary_diag_class, secondary_diag_class from mr_parameter";

		pstmt = conn.prepareStatement(MRSql);
		rs = pstmt.executeQuery();

		if(rs!=null && rs.next()){
			auto_fin_death_reg_appl_yn = checkForNull(rs.getString("auto_fin_death_reg_appl_yn"),"N");
			primary_diag_class = checkForNull(rs.getString("primary_diag_class"));
			secondary_diag_class = checkForNull(rs.getString("secondary_diag_class"));
		}

		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();

		if(auto_fin_death_reg_appl_yn.equals("Y") && (!primary_diag_class.equals("") || !secondary_diag_class.equals(""))){
			
			String cntSql = "SELECT CASE WHEN COUNT(DISTINCT diag_class_code) = 2 THEN COUNT(*) ELSE NULL END AS both_pri_sec_count, CASE WHEN SUM(CASE WHEN diag_class_code = (SELECT primary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) > 0 THEN SUM(CASE WHEN diag_class_code = (SELECT primary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) ELSE NULL END AS pri_count, CASE WHEN SUM(CASE WHEN diag_class_code = (SELECT secondary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) > 0 THEN SUM(CASE WHEN diag_class_code = (SELECT secondary_diag_class FROM mr_parameter) THEN 1 ELSE 0 END) ELSE NULL END AS sec_count FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' AND diag_class_code IN ( (SELECT primary_diag_class FROM mr_parameter), (SELECT secondary_diag_class FROM mr_parameter) )";

			pstmt = conn.prepareStatement(cntSql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,facility_id);

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

				both_pri_sec_count = (rs.getString("both_pri_sec_count")==null || rs.getString("both_pri_sec_count")=="")?"" : rs.getString("both_pri_sec_count");

				pri_count = (rs.getString("pri_count")==null || rs.getString("pri_count")=="")?"" : rs.getString("pri_count");

				sec_count = (rs.getString("sec_count")==null || rs.getString("sec_count")=="")?"" : rs.getString("sec_count");
			}

			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();

			String linksql = " SELECT CASE WHEN MAX (CASE WHEN link_diag_pri_sec_yn = 'Y' THEN 1 ELSE 0 END) = 1 THEN 'Y' ELSE '' END AS linked_yn FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' ";
		
			pstmt = conn.prepareStatement(linksql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,facility_id);

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

				linked_yn = (rs.getString("linked_yn")==null || rs.getString("linked_yn")=="")?"" : rs.getString("linked_yn");
			}

			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			if(!primary_diag_class.equals("") && !secondary_diag_class.equals(""))
			{
				if(!both_pri_sec_count.equals("") || linked_yn.equals("Y")){
					auto_fin_death_reg_yn = "Y";
				}
			}else if(!primary_diag_class.equals("") && secondary_diag_class.equals(""))
			{
				if(!pri_count.equals("")){
					auto_fin_death_reg_yn = "Y";
				}
			}else if(primary_diag_class.equals("") && !secondary_diag_class.equals(""))
			{
				if(!sec_count.equals("")){
					auto_fin_death_reg_yn = "Y";
				}
			}
		}

		if(auto_fin_death_reg_yn.equals("Y")){

			String UpdateSql = "UPDATE mr_death_register_hdr SET finalize_yn = 'Y' WHERE patient_id = ? AND encounter_id = ? AND facility_id = ?";

			pstmt = conn.prepareStatement(UpdateSql);
			pstmt.setString (1,patient_id);
			pstmt.setString (2,encounter_id);
			pstmt.setString (3,facility_id);
			int count = pstmt.executeUpdate();

			if(count > 0){
				finalize_yn = "Y";
				conn.commit(); 
			}else{
				conn.rollback();
			}

			if(pstmt!=null)pstmt.close();
		}
	}
	/*End ML-MMOH-CRF-1742*/

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block26Bytes, _wl_block26);

}catch(Exception ex){
	ex.printStackTrace();
	conn.rollback();
}finally{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MaintainDeathRegister.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
