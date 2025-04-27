package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import eOH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __recorddiaglinkedcondition extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/RecordDiagLinkedCondition.jsp", 1709119366852L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n        <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/RecordDiagForTrmt.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/Hashtable.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n  <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n  <form name=\"OHDiagLinkedConditions\" id=\"OHDiagLinkedConditions\"   method=\"post\" target=\"messageFrame\">\n      <table align=\'center\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\'>\n             ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"><input type=\'checkbox\' name=\'chk_select";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'chk_select";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' cond_chart_num = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' cond_chart_line_num = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' cond_code = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  onclick=\"validateCheckBox(this,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></td>\n\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"><input type=\'checkbox\' name=\'close_cond";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'close_cond";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onclick=\"validateCloseCondCheckBox(this,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="></td>\n\n\t\t\t\t\t\t<input type=\'hidden\' name=\'condition_type_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'condition_type_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'condition_code_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'condition_code_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'site_type_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'site_type_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'area_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'area_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'surface_code_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'surface_code_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'link_already_exists_yn";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'link_already_exists_yn";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'trmt_code\' id=\'trmt_code\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'trmt_chart_line_num\' id=\'trmt_chart_line_num\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t<input type=\'hidden\' name=\'trmt_chart_num\' id=\'trmt_chart_num\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\' name=\'occur_srl_no\' id=\'occur_srl_no\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t<input type=\'hidden\' name=\'diag_status\' id=\'diag_status\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n            \n\t\t</form>\n </body> </html>\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );
 
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        String locale = (String)session.getAttribute("LOCALE"); 
		String facility_id = (String)session.getValue("facility_id") ;

		String patient_id = checkForNull(request.getParameter("patient_id"));
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
		String site_type_param = checkForNull(request.getParameter("site_type"));
		String area_param = checkForNull(request.getParameter("area_param"));
		String thrng_nos_ref = checkForNull(request.getParameter("thrng_nos_ref"));

		String trmt_chart_num = checkForNull(request.getParameter("chart_num"));
		String trmt_chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	    String term_code = checkForNull(request.getParameter("term_code"));
	    String term_set_id = checkForNull(request.getParameter("term_set_id"));
	    String occur_srl_no = checkForNull(request.getParameter("occur_srl_no"));
	    String diag_status = checkForNull(request.getParameter("diag_status"));
	    String mode = checkForNull(request.getParameter("mode"));
	    String trmt_code = checkForNull(request.getParameter("trmt_code"));
		String status_disabled =  checkForNull(request.getParameter("status_disabled"));
		String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
		String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
		String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		
		String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		

		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
			other_chart_facility_id=facility_id;
		}
		if(!other_chart_facility_id.equals(facility_id) || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668		
			status_disabled = "disabled";	
		}

		String site_type = "";
		String area = "";
		String area_desc = "";
		String surface_code = "";
		String surface_desc = "";
	    String condition_type = "";
		String condition_code = "";
		String condition_desc = "";
		String site_type_desc = "";
		int row_count = 0;
		String classValue = "";
		String close_disabled = "";
		String link_already_exists_yn = "N";
		String chk_yn = "";
		String cond_closed_yn = "";
		String close_disabled_yn = "";
		String select_disabled_yn = "";
		String chk_closed_yn = "";
		String [] thrng_nos_ref_arr = null;
		

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	try{
			con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block7Bytes, _wl_block7);

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			   
				//pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO, A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC,(SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC,(SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.COND_CHART_NUM = A.CHART_NUM  AND L.COND_CHART_LINE_NUM = A.CHART_LINE_NUM AND L.CONDITION_CODE = A.CONDITION_CODE) LINK_ALREADY_EXISTS_YN,(SELECT COND_CLOSED_YN FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.COND_CHART_NUM = A.CHART_NUM  AND L.COND_CHART_LINE_NUM = A.CHART_LINE_NUM AND L.CONDITION_CODE = A.CONDITION_CODE) COND_CLOSED_YN FROM OH_RESTORATIVE_CHART_DTL A,  OH_DIAG_COND_LINK E WHERE A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CONDITION_CODE = E.CONDITION_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND  NVL(A.STATUS,'X')!='E' AND E.TERM_CODE = ? ORDER BY A.CONDITION_TYPE");
				if(oh_chart_level.equals("E")){
					pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO,A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN, L.COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A,  OH_RESTORATIVE_CHART_DIAG_COND L WHERE E.PATIENT_ID = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO= ? AND A.PATIENT_ID= E.PATIENT_ID AND A.CHART_NUM  = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM  = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE  = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND L.PATIENT_ID = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.OCCUR_SRL_NO = E.OCCUR_SRL_NO AND L.COND_CHART_NUM = E.CHART_NUM  AND L.COND_CHART_LINE_NUM = E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE AND L.TRMT_CHART_NUM = ? AND L.TRMT_CHART_LINE_NUM = ? AND L.TRMT_CODE = ? UNION SELECT A.CONDITION_TYPE,  A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO, A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN, 'N' COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A WHERE E.PATIENT_ID  = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO = ?  AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND (E.PATIENT_ID, E.TERM_SET_ID, E.TERM_CODE, E.OCCUR_SRL_NO, E.CHART_NUM, E.CHART_LINE_NUM, E.CONDITION_CODE) NOT IN (SELECT PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, COND_CHART_NUM, COND_CHART_LINE_NUM, CONDITION_CODE FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE  L.PATIENT_ID  = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE  = E.TERM_CODE AND L.OCCUR_SRL_NO  = E.OCCUR_SRL_NO AND L.COND_CHART_NUM  = E.CHART_NUM AND L.COND_CHART_LINE_NUM= E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE) ORDER BY CONDITION_TYPE");

					pstmt.setString(1,locale);//LANGUAGE_ID
					pstmt.setString(2,locale);//LANGUAGE_ID
					pstmt.setString(3,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(4,locale);//LANGUAGE_ID
					pstmt.setString(5,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(6,locale);//LANGUAGE_ID
					pstmt.setString(7,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(8,locale);//LANGUAGE_ID
					pstmt.setString(9,locale);//LANGUAGE_ID
					pstmt.setString(10,patient_id);//PATIENT_ID
					pstmt.setString(11,term_set_id);//PATIENT_ID
					pstmt.setString(12,term_code);//CHART_NUM
					pstmt.setString(13,occur_srl_no);//CHART_NUM
					//pstmt.setString(14,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(14,trmt_chart_num);//OPERATING_FACILITY_ID
					//pstmt.setString(15,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(15,trmt_chart_num);//CHART_NUM
					pstmt.setString(16,trmt_chart_line_num);//CHART_NUM
					pstmt.setString(17,trmt_code);//CHART_NUM

					pstmt.setString(18,locale);//LANGUAGE_ID
					pstmt.setString(19,locale);//LANGUAGE_ID
					pstmt.setString(20,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(21,locale);//LANGUAGE_ID
					pstmt.setString(22,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(23,locale);//LANGUAGE_ID
					pstmt.setString(24,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(25,locale);//LANGUAGE_ID
					pstmt.setString(26,locale);//LANGUAGE_ID
					pstmt.setString(27,patient_id);//PATIENT_ID
					pstmt.setString(28,term_set_id);//PATIENT_ID
					pstmt.setString(29,term_code);//CHART_NUM
					pstmt.setString(30,occur_srl_no);//CHART_NUM
				//	pstmt.setString(32,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(31,trmt_chart_num);//OPERATING_FACILITY_ID
					
					rs=pstmt.executeQuery();
				
				}else{
					pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO,A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN, L.COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A,  OH_RESTORATIVE_CHART_DIAG_COND L WHERE E.PATIENT_ID = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO= ? AND A.OPERATING_FACILITY_ID= ? AND A.PATIENT_ID= E.PATIENT_ID AND A.CHART_NUM  = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM  = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE  = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND L.PATIENT_ID = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE = E.TERM_CODE AND L.OCCUR_SRL_NO = E.OCCUR_SRL_NO AND L.COND_CHART_NUM = E.CHART_NUM  AND L.COND_CHART_LINE_NUM = E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE AND L.TRMT_CHART_NUM = ? AND L.TRMT_CHART_LINE_NUM = ? AND L.TRMT_CODE = ? UNION SELECT A.CONDITION_TYPE,  A.CONDITION_CODE, A.ARCH_SNO, A.QUADRANT_SNO, A.TOOTH_NO REF_TOOTH_NO, A.SURFACE_CODE, A.CHART_NUM, A.CHART_LINE_NUM, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN, 'N' COND_CLOSED_YN FROM OH_DIAG_COND_LINK E, OH_RESTORATIVE_CHART_DTL A WHERE E.PATIENT_ID  = ? AND E.TERM_SET_ID = ? AND E.TERM_CODE = ? AND E.OCCUR_SRL_NO = ? AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE = E.CONDITION_CODE  AND NVL(A.STATUS,'X') <>'E' AND (E.PATIENT_ID, E.TERM_SET_ID, E.TERM_CODE, E.OCCUR_SRL_NO, E.CHART_NUM, E.CHART_LINE_NUM, E.CONDITION_CODE) NOT IN (SELECT PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, COND_CHART_NUM, COND_CHART_LINE_NUM, CONDITION_CODE FROM OH_RESTORATIVE_CHART_DIAG_COND L WHERE  L.PATIENT_ID  = E.PATIENT_ID AND L.TERM_SET_ID = E.TERM_SET_ID AND L.TERM_CODE  = E.TERM_CODE AND L.OCCUR_SRL_NO  = E.OCCUR_SRL_NO AND L.COND_CHART_NUM  = E.CHART_NUM AND L.COND_CHART_LINE_NUM= E.CHART_LINE_NUM AND L.CONDITION_CODE = E.CONDITION_CODE) ORDER BY CONDITION_TYPE");

					pstmt.setString(1,locale);//LANGUAGE_ID
					pstmt.setString(2,locale);//LANGUAGE_ID
					pstmt.setString(3,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(4,locale);//LANGUAGE_ID
					pstmt.setString(5,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(6,locale);//LANGUAGE_ID
					pstmt.setString(7,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(8,locale);//LANGUAGE_ID
					pstmt.setString(9,locale);//LANGUAGE_ID
					pstmt.setString(10,patient_id);//PATIENT_ID
					pstmt.setString(11,term_set_id);//PATIENT_ID
					pstmt.setString(12,term_code);//CHART_NUM
					pstmt.setString(13,occur_srl_no);//CHART_NUM
					//pstmt.setString(14,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(14,other_chart_facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(15,trmt_chart_num);//OPERATING_FACILITY_ID
					//pstmt.setString(15,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(16,trmt_chart_num);//CHART_NUM
					pstmt.setString(17,trmt_chart_line_num);//CHART_NUM
					pstmt.setString(18,trmt_code);//CHART_NUM

					pstmt.setString(19,locale);//LANGUAGE_ID
					pstmt.setString(20,locale);//LANGUAGE_ID
					pstmt.setString(21,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(22,locale);//LANGUAGE_ID
					pstmt.setString(23,tooth_numbering_system);//NUMBERING_SYSTEM
					pstmt.setString(24,locale);//LANGUAGE_ID
					pstmt.setString(25,tooth_numbering_system);//LANGUAGE_ID
					pstmt.setString(26,locale);//LANGUAGE_ID
					pstmt.setString(27,locale);//LANGUAGE_ID
					pstmt.setString(28,patient_id);//PATIENT_ID
					pstmt.setString(29,term_set_id);//PATIENT_ID
					pstmt.setString(30,term_code);//CHART_NUM
					pstmt.setString(31,occur_srl_no);//CHART_NUM
				//	pstmt.setString(32,facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(32,other_chart_facility_id);//OPERATING_FACILITY_ID
					pstmt.setString(33,trmt_chart_num);//OPERATING_FACILITY_ID
					
					rs=pstmt.executeQuery();
			}
				boolean found_flag = false;
				int m=0;
			
				while(rs.next()){
					row_count++;
					condition_type = checkForNull(rs.getString("CONDITION_TYPE"));
					condition_code = checkForNull(rs.getString("CONDITION_CODE"));
					condition_desc = checkForNull(rs.getString("CONDITION_DESC"));
					site_type_desc = checkForNull(rs.getString("SITE_TYPE_DESC"));
					site_type = checkForNull(rs.getString("SITE_TYPE"));
					link_already_exists_yn = checkForNull(rs.getString("LINK_ALREADY_EXISTS_YN"));
					cond_closed_yn = checkForNull(rs.getString("COND_CLOSED_YN"));
					
					if(link_already_exists_yn.equals("Y")){
						chk_yn = "checked";
						close_disabled_yn = "";
					}
					else{
						chk_yn = "";
						close_disabled_yn = "disabled";
					}

					if(cond_closed_yn.equals("Y")){
						chk_closed_yn = "checked";
						close_disabled_yn = "disabled";
						select_disabled_yn = "disabled";
					}
					else{
						chk_closed_yn = "";
						select_disabled_yn = "";
						//close_disabled_yn = "";
					}

					if(site_type.equals("ARCH")){
						area_desc = checkForNull(rs.getString("ARCH_DESC"));
						area = checkForNull(rs.getString("ARCH_SNO"));
					}
					else if(site_type.equals("QUAD")){
						area_desc = checkForNull(rs.getString("QUADRANT_DESC"));
						area = checkForNull(rs.getString("QUADRANT_SNO"));
					}
					else{
						area_desc = checkForNull(rs.getString("TOOTH_NO"));
						area = checkForNull(rs.getString("REF_TOOTH_NO"));
					}

					surface_desc = checkForNull(rs.getString("SURFACE_NAME"));
					surface_code = checkForNull(rs.getString("SURFACE_CODE"));

					if ( row_count % 2 == 0 ){
						classValue = "QRYEVEN" ;
					}else{
						classValue = "QRYODD" ;
					}
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(checkForNull(rs.getString("CONDITION_TYPE_DESC"))));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(condition_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(site_type_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

							if(surface_desc.equals("")){
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

							}else{
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(surface_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

							}

							if(!site_type_param.equals(site_type)){
								if(site_type_param.equals("THRNG") && site_type.equals("TOOTH")){
									if(thrng_nos_ref.indexOf(",") != -1){
										thrng_nos_ref_arr = thrng_nos_ref.split(",");
										m=0;
										close_disabled = "disabled";
										found_flag = false;
										
										while(m<thrng_nos_ref_arr.length && found_flag == false){
											if(thrng_nos_ref_arr[m].equals(area)){
												close_disabled = "";
												found_flag = true;
												
											}
											m++;
										}
									}
									
								}
								else{
									close_disabled = "disabled";
								}
							}
							else{
								if(area_param.equals(area)){
									close_disabled = "";
								}
								else{
									close_disabled = "disabled";
								}
							}
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(rs.getString("CHART_NUM"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rs.getString("CHART_LINE_NUM"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(condition_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(close_disabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(select_disabled_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(rs.getString("CHART_NUM"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rs.getString("CHART_LINE_NUM"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(condition_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk_closed_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(close_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(close_disabled_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(condition_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(condition_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(site_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(area));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(surface_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(link_already_exists_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);

				}
			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(trmt_chart_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(trmt_chart_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(diag_status));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block50Bytes, _wl_block50);

   }catch ( Exception e ) {
	           e.printStackTrace() ;
    }finally {
	        try{
		         if(rs!=null) rs.close();
		         if(pstmt!=null) pstmt.close();
		          if(con!=null) 
			            ConnectionManager.returnConnection(con,request);
	                 }catch(Exception es){es.printStackTrace();}
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
