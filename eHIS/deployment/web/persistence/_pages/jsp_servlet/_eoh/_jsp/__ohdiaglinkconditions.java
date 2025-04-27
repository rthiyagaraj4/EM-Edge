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
import webbeans.eCommon.*;
import java.util.*;
import eOH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __ohdiaglinkconditions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHDiagLinkConditions.jsp", 1709119348333L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<html>\n\t\t\t<head>\n\t\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t\t\t<script src=\"../../eOH/js/OHDiagLinkConditions.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t</head>\n\t\t\t<body onload=\'checkAllRecord()\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t\t\t<form name=\'oh_diag_link_condition\' id=\'oh_diag_link_condition\' action=\'../../eOH/jsp/OHDiagLinkConditionsValidation.jsp\' method=\'post\' >\n\n\t\t\t\t\t<table align=\'center\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\'>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t<td width=\"15%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'link_condition_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'link_condition_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'link_code_chk";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'link_code_chk";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\"N\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'link_code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'link_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'chart_line_num_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'chart_line_num_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'condition_type_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'condition_type_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'site_type_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'site_type_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'area_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'area_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'condition_code_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'condition_code_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'surface_code_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'surface_code_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"15%\" colspan=\"6\" class=\"button\"><input type=\'button\' class=\"button\" name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onclick=\'recordLink(this)\'>&nbsp;\n\t\t\t\t\t\t\t<input type=\'button\' class=\"button\" name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onclick=\'window.close()\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<input type=\'hidden\' name=\'record_count\' id=\'record_count\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'chart_num\' id=\'chart_num\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'click_mode\' id=\'click_mode\' value=\'\'>\n\t\t\t\t\t<!--Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->\n\t\t\t\t\t<input type=\'hidden\' name=\'oh_chart_level\' id=\'oh_chart_level\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t</form>\t\t\t\t\n\t\t\t</body>\n\t\t</html>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
 
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
	PreparedStatement pstmt_date=null;
	PreparedStatement pstmt=null;
	ResultSet rs_date=null;
	ResultSet rs=null;

	String facility_id = "";
	String encounter_id = "";
	String chart_num = "";
	String link_already_exists_yn = "N";
	String link_disable = "";

	String locale = (String)session.getAttribute("LOCALE"); 
	String login_user = (String)session.getAttribute("login_user"); 

	String patient_id = checkForNull(request.getParameter("patient_id"));
	String term_set_id = checkForNull(request.getParameter("term_set_id"));
	String term_code = checkForNull(request.getParameter("term_code"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String accession_num = checkForNull(request.getParameter("accession_num"));
	RecordSet OHDiagLinkConditionOBJ	=	(webbeans.eCommon.RecordSet)session.getAttribute("OHDiagLinkConditionOBJ");
	
	StringTokenizer accession_num_token = new StringTokenizer(accession_num,"||");
	while(accession_num_token.hasMoreTokens()){
		facility_id		=accession_num_token.nextToken();
		encounter_id	=accession_num_token.nextToken();
		chart_num	=accession_num_token.nextToken();
	}
	
	String site_type = "";
	String area = "";
	String surface_code = "";
	String surface_desc = "";
	String condition_type = "";
	String chart_line_num = "";
	String condition_code = "";
	String chart_number	  = "";
	String code			  = "";
	int record_count = 0;
	int row_count = 0;
	String classValue = "";
	String chkAttribute = "";
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//



	try{
		con=ConnectionManager.getConnection(request);

		if(tooth_numbering_system.equals("")){
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			pstmt=con.prepareStatement("SELECT PREF_NUMBERING_SYSTEM FROM OH_USER_PREFERENCES WHERE APPL_USER_ID = ?");
			pstmt.setString(1,login_user);
			rs=pstmt.executeQuery();
			while(rs.next()){
				tooth_numbering_system = checkForNull(rs.getString("PREF_NUMBERING_SYSTEM"));
			}
		}

		if(tooth_numbering_system.equals("")){
			//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()){
				oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(oh_chart_level.equals("E")){
			   pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM");
			}else{//End
			   pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
				pstmt.setString(1,facility_id);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				tooth_numbering_system = checkForNull(rs.getString("TOOTH_NUMBERING_SYSTEM"));
			}
		}

	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						
							//pstmt=con.prepareStatement("SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, (SELECT 'Y' FROM OH_DIAG_COND_LINK L WHERE L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID=? AND L.TERM_CODE=? AND L.CHART_NUM=A.CHART_NUM AND L.CHART_LINE_NUM=A.CHART_LINE_NUM) LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' ORDER BY A.CONDITION_TYPE");

							//pstmt=con.prepareStatement("SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1')  QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM  in (select chart_num from OH_RESTORATIVE_CHART_HDR where OPERATING_FACILITY_ID = ? and patient_id = ? and CHART_STATUS = 'A') AND TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' AND (A.CHART_NUM, A.CHART_LINE_NUM, A.CONDITION_CODE) NOT IN (SELECT CHART_NUM, CHART_LINE_NUM, CONDITION_CODE FROM OH_DIAG_COND_LINK WHERE PATIENT_ID = ?) UNION SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B, OH_DIAG_COND_LINK L WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID= ? AND L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID= ? AND L.TERM_CODE = ? AND L.OCCUR_SRL_NO = 1 AND L.CHART_NUM = A.CHART_NUM AND L.CHART_LINE_NUM = A.CHART_LINE_NUM AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' ORDER BY CONDITION_TYPE ");
							pstmt=con.prepareStatement("SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1')  QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'N' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM  in (select chart_num from OH_RESTORATIVE_CHART_HDR where OPERATING_FACILITY_ID = ? and patient_id = ? and CHART_STATUS = 'A') AND TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' AND (A.CHART_NUM, A.CHART_LINE_NUM, A.CONDITION_CODE) NOT IN (SELECT CHART_NUM, CHART_LINE_NUM, CONDITION_CODE FROM OH_DIAG_COND_LINK WHERE PATIENT_ID = ?) UNION SELECT A.CHART_NUM,A.CHART_LINE_NUM, A.CONDITION_TYPE, A.CONDITION_CODE, A.SURFACE_CODE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, A.TREATMENT_CONDITION_DATE,  B.CONDITION_DESC, 'Y' LINK_ALREADY_EXISTS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_CONDITION_LANG_VW B, OH_DIAG_COND_LINK L WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID= ? AND L.PATIENT_ID = A.PATIENT_ID AND L.TERM_SET_ID= ? AND L.TERM_CODE = ? AND L.CHART_NUM = A.CHART_NUM AND L.CHART_LINE_NUM = A.CHART_LINE_NUM AND A.TREATMENT_CONDITION = 'C' AND A.CONDITION_CODE IS NOT NULL AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ? AND NVL(A.STATUS,'X') <> 'E' ORDER BY CONDITION_TYPE ");
							
							//IN THE ABOVE QUERY ROWNUM = 1 IS TAKEN INSTEAD OF PERMANENT_DECIDUOUS FOR QUADRANT_DESC....THIS IS BCOZ QUANDRANT_SNO IS SAME FOR BOTH PERMANENT AND DECIDUOUS CONDITIONS..SINCE WE ARE CONSIDERING ONLY DESC WE CAN USE THIS CONDITION....
							pstmt.setString(1,locale);
							pstmt.setString(2,locale);
							pstmt.setString(3,tooth_numbering_system);
							pstmt.setString(4,locale);
							pstmt.setString(5,tooth_numbering_system);
							pstmt.setString(6,locale);
							pstmt.setString(7,tooth_numbering_system);
							pstmt.setString(8,locale);
							pstmt.setString(9,facility_id);
							pstmt.setString(10,patient_id);
							pstmt.setString(11,facility_id);
							pstmt.setString(12,patient_id);
							pstmt.setString(13,locale);
							pstmt.setString(14,patient_id);

							pstmt.setString(15,locale);
							pstmt.setString(16,locale);
							pstmt.setString(17,tooth_numbering_system);
							pstmt.setString(18,locale);
							pstmt.setString(19,tooth_numbering_system);
							pstmt.setString(20,locale);
							pstmt.setString(21,tooth_numbering_system);
							pstmt.setString(22,locale);
							pstmt.setString(23,facility_id);
							pstmt.setString(24,patient_id);
							pstmt.setString(25,term_set_id);
							pstmt.setString(26,term_code);
							pstmt.setString(27,locale);
							
							rs=pstmt.executeQuery();
							record_count = 0;
							while(rs.next()){
								
								record_count++;
								row_count++;
								condition_type = checkForNull(rs.getString("CONDITION_TYPE"));
								chart_number = checkForNull(rs.getString("CHART_NUM"));
								chart_line_num = checkForNull(rs.getString("CHART_LINE_NUM"));
								condition_code = checkForNull(rs.getString("CONDITION_CODE"));
								surface_code = checkForNull(rs.getString("SURFACE_CODE"));
								site_type = checkForNull(rs.getString("SITE_TYPE"));
								
								if(site_type.equals("ARCH")){
									area = checkForNull(rs.getString("ARCH_DESC"));
								}
								else if(site_type.equals("QUAD")){
									area = checkForNull(rs.getString("QUADRANT_DESC"));
								}
								else{
									area = checkForNull(rs.getString("TOOTH_NO"));
								}
								
								surface_desc = checkForNull(rs.getString("SURFACE_NAME"));

								code = chart_number + "||" +chart_line_num+ "||"+ condition_code;

								link_already_exists_yn = checkForNull(rs.getString("LINK_ALREADY_EXISTS_YN"),"N");

								link_disable="";
								if(link_already_exists_yn.equals("Y")){
									chkAttribute="CHECKED";
									link_disable="disabled";
								}else{
									if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.containsObject(code)) 
									{
										chkAttribute = "CHECKED";							
									}
									else
									{
										chkAttribute="";							
									}
								}

								if ( row_count % 2 == 0 )
                                         classValue = "QRYEVEN" ;
								else
				                    	classValue = "QRYODD" ;
								
						
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(checkForNull(rs.getString("CONDITION_TYPE_DESC"))));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(checkForNull(rs.getString("CONDITION_DESC"))));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(checkForNull(rs.getString("SITE_TYPE_DESC"))));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(area));
            _bw.write(_wl_block10Bytes, _wl_block10);

										if(surface_code.equals("")){
									
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);

										}else{
									
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(surface_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

										}
									
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(link_disable));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(condition_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(site_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(area));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(condition_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(surface_code));
            _bw.write(_wl_block36Bytes, _wl_block36);

							}
						
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block42Bytes, _wl_block42);

	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(rs_date!=null) rs_date.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt_date!=null) pstmt_date.close();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
