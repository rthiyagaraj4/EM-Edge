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
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __periodontalsummaryforsextant extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PeriodontalSummaryForSextant.jsp", 1709119359739L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t\t<head>\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> \n\t\t\t<script language=\"javascript\" src=\"../../eOH/js/PeriodontalSummary.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t\t\t<form name=\"PeridontalSummary\" id=\"PeridontalSummary\" method=\"post\" target=\"messageFrame\">\n\t\t\t\t   <!-- <table width=\"80%\" cellpadding =0 cellspacing=\'1\' border=\'0\' align=\'center\' valign=\'center\' style=\"background-color:white\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'label\' width=\"20%\" style=\"background-color:white\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'LABEL\' width=\"20%\" style=\"background-color:white\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table> -->\n\t\t\t\t\t\n\t\t\t<table width=\"80%\" cellpadding =4 cellspacing=\'1\' border=\'1\' align=\'center\' valign=\'center\'>\n\t\t\t\n\t\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  \n\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap >\n\t\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  \n                         \n\t\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n                         \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t<!-- <table width=\"80%\" cellpadding =4 cellspacing=\'1\' border=\'0\' align=\'center\' valign=\'center\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'LABEL\' width=\"10%\" style=\"background-color:white\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t\t<td class=\'LABEL\' width=\"10%\" style=\"background-color:white\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table> -->\n\t\t\t\t\t<table align=\"center\" width=\"80%\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =":";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t</tr><tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' colspan=3 style=\"background-color:\'white\'\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' colspan=3><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =":</b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chart_num\" id=\"chart_num\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"called_from_tab\" id=\"called_from_tab\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n                    <input type=\"hidden\" name=\"called_from_ging_summary\" id=\"called_from_ging_summary\" value=\"Y\">\n                    <input type=\"hidden\" name=\"called_from_viewchart_yn\" id=\"called_from_viewchart_yn\" value=\"Y\">\n                    <input type=\"hidden\" name=\"called_from_viewchart_gingival\" id=\"called_from_viewchart_gingival\" value=\"N\">\n                    <input type=\"hidden\" name=\"gingival_recording_by\" id=\"gingival_recording_by\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"permanent_deciduous_flag\" id=\"permanent_deciduous_flag\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t\t<!--Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)-->\n\t\t\t\t\t<input type=\"hidden\" name=\"mixed_dentition_YN\" id=\"mixed_dentition_YN\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</form>\n\t\t\t</body>\n\t\t</html>\n\t\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
 
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
 String locale = (String)session.getAttribute("LOCALE"); 
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	PreparedStatement pstmt1=null;
	//PreparedStatement pstmt2=null;
	
	ResultSet rs1=null;
//	ResultSet rs2=null;
//	boolean isExfoliated = false;
//	int count_GS = 0;
	//


	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String called_from_tab=checkForNull(request.getParameter("called_from_tab"));
	String gingival_recording_by=checkForNull(request.getParameter("gingival_recording_by"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	String mixed_dentition_YN=checkForNull(request.getParameter("mixed_dentition_YN"));
	//
	//Added by Sharon Crasta for CRF #0423 on 3/30/2009
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
	}

	String tooth_no = "";
	String q1_tooth = "";
	String q2_tooth = "";
	String q3_tooth = "";
	String q4_tooth = "";
	String q5_tooth = "";
	String q6_tooth = "";
	

	int count = 0;
	int gingival_status_sum =0;
	int tooth_count = 0;
	int q1_count = 0;
	int q2_count = 0;
	int q3_count = 0;
	int q4_count = 0;
	int q5_count = 0;
	int q6_count = 0;

	double gs_q1_count = 0.0;
	double gs_q2_count = 0.0;
	double gs_q3_count = 0.0;
	double gs_q4_count = 0.0;
	double gs_q5_count = 0.0;
	double gs_q6_count = 0.0;

	int th_q1_count = 0;
	int th_q2_count = 0;
	int th_q3_count = 0;
	int th_q4_count = 0;
	int th_q5_count = 0;
	int th_q6_count = 0;

	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	String ns_tooth_no = "";
	String mapped_tooth_no = "";
	//String super_yn = "";
	//String MD_yn = "";
	//String exfolth_yn = "N";
	//String deciduous_tooth_yn = "N";
	//String condition_type = "";
	String status = "";
	//

	//String msg = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"APP-OH00088","OH"); 
	//String msg = "";

	StringBuffer str = new StringBuffer();
	
	if(gingival_recording_by.equals("Q")){
		str.append("<script>");
		str.append("var msg=getMessage('APP-OH00088','OH');");
	
		str.append("document.write(msg);");
		str.append("</script>");
	}
	else{
		str.append("<script>");
		str.append("var msg=getMessage('APP-OH00089','OH');");

		str.append("document.write(msg);");
		str.append("</script>");
	}
	

	
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
		try{
			con=ConnectionManager.getConnection(request);
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				//pstmt=con.prepareStatement("SELECT DISTINCT (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) TOOTH_NO, A.GINGIVAL_STATUS_CODE FROM OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND QUADRANT_SNO = ?");
				if(oh_chart_level.equals("E")){
					//pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO");
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO");
					pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO	FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM, A.STATUS  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E'  AND NVL(STATUS,'X') != 'Y' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO, A.STATUS ORDER BY NS_TOOTH_NO ASC");
				
					pstmt.setString(1,tooth_numbering_system);
					//pstmt.setString(2,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					rs=pstmt.executeQuery();
				}else{
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO");
					pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO	FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM, A.STATUS  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E'  AND NVL(STATUS,'X') != 'Y' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO, A.STATUS ORDER BY NS_TOOTH_NO ASC");
					
					pstmt.setString(1,tooth_numbering_system);
					//pstmt.setString(2,facility_id);
					pstmt.setString(2,other_chart_facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_num);
					rs=pstmt.executeQuery();
				}
			
				while(rs.next()){
					ns_tooth_no = checkForNull(rs.getString("NS_TOOTH_NO"));
					gingival_status_sum = rs.getInt("GINGIVAL_STATUS_SUM");
					tooth_count = rs.getInt("TOOTH_COUNT");
					//Added by Sharon Crasta on 8/7/2009 for IN009739(SRR20056-CRF-0457)
					tooth_no = rs.getString("TOOTH_NO");
					mapped_tooth_no = rs.getString("MAPPED_TOOTH_NO");
					status = rs.getString("STATUS");
					
					
					 
					 if(rs1 != null) rs1.close();
					 if(pstmt1 != null) pstmt1.close();
					 if (mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
							
							if(status.equals("A")){
								
								pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ? ");
								pstmt1.setString(1,tooth_numbering_system);
								pstmt1.setString(2,mapped_tooth_no);
								
								rs1=pstmt1.executeQuery();
								while(rs1!=null && rs1.next()){
									   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
								}
							}

							if(status.equals("S")){
							   ns_tooth_no = ns_tooth_no + "s";					
							}

							if(status.equals("R")){
								 pstmt1 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
								 pstmt1.setString(1,tooth_numbering_system);
								 pstmt1.setString(2,tooth_no);
								
								 rs1=pstmt1.executeQuery();
								 while(rs1!=null && rs1.next()){
									   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
								}
							}
						}
						else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P")){
						
						if(status.equals("D")){
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?");
							//pstmt.setString(1,other_chart_facility_id);
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,mapped_tooth_no);
							
							rs1=pstmt1.executeQuery();
							while(rs1!=null && rs1.next()){
								   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
							}
							//ns_tooth_no =  disply_tooth_no_deciduous;
						}
					}
					else{
						if(status.equals("S")) {
							ns_tooth_no =  ns_tooth_no + "s";
						}
						if(status.equals("R")){
							 pstmt1 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
							 pstmt1.setString(1,tooth_numbering_system);
							 pstmt1.setString(2,tooth_no);
							
							 rs1=pstmt1.executeQuery();
							 while(rs1!=null && rs1.next()){
								   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
							}
						}
					}
					 //
					if(rs.getString("SEXTENT_SNO").equals("1")){
						if(q1_count == 0){
							//q1_tooth = tooth_no;
							q1_tooth = ns_tooth_no;
							gs_q1_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q1_count = tooth_count;
						}
							
						else{
							//q1_tooth = q1_tooth+"/"+tooth_no;
							q1_tooth = q1_tooth+"/"+ns_tooth_no;
							gs_q1_count = gs_q1_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q1_count = th_q1_count+tooth_count;
						}
						q1_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("2")){
						if(q2_count == 0){
							//q2_tooth = tooth_no;
							q2_tooth = ns_tooth_no;
							gs_q2_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q2_count = tooth_count;
							
							
						}
						else{
							//q2_tooth = q2_tooth+"/"+tooth_no;
							q2_tooth = q2_tooth+"/"+ns_tooth_no;
							gs_q2_count = gs_q2_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q2_count = th_q2_count+tooth_count;
						}
						q2_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("3")){
						if(q3_count == 0){
							//q3_tooth = tooth_no;
							q3_tooth = ns_tooth_no;
							gs_q3_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q3_count = tooth_count;
						}
						else{
							//q3_tooth = q3_tooth+"/"+tooth_no;
							q3_tooth = q3_tooth+"/"+ns_tooth_no;
							gs_q3_count = gs_q3_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q3_count = th_q3_count+tooth_count;
						}
						q3_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("4")){
						if(q4_count == 0){
							//q4_tooth =tooth_no;
							q4_tooth =ns_tooth_no;
							gs_q4_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q4_count = tooth_count;
						}
						else{
							//q4_tooth = q4_tooth+"/"+tooth_no;
							q4_tooth = q4_tooth+"/"+ns_tooth_no;
							gs_q4_count = gs_q4_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q4_count = th_q4_count+tooth_count;
						}
						q4_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("5")){
						if(q5_count == 0){
							//q5_tooth =tooth_no;
							q5_tooth =ns_tooth_no;
							gs_q5_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q5_count = tooth_count;
						}
						else{
							//q5_tooth = q5_tooth+"/"+tooth_no;
							q5_tooth = q5_tooth+"/"+ns_tooth_no;
							gs_q5_count = gs_q5_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q5_count = th_q5_count+tooth_count;
						}
						q5_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("6")){
						if(q6_count == 0){
							//q6_tooth =tooth_no;
							q6_tooth =ns_tooth_no;
							gs_q6_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q6_count = tooth_count;
						}
						else{
							//q6_tooth = q6_tooth+"/"+tooth_no;
							q6_tooth = q6_tooth+"/"+ns_tooth_no;
							gs_q6_count = gs_q6_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q6_count = th_q6_count+tooth_count;
						}
						q6_count++;
					}
				
				}


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(q1_tooth));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(q2_tooth));
            _bw.write(_wl_block10Bytes, _wl_block10);

                      if(called_from_tab.equals("Y")){
				   
            _bw.write(_wl_block11Bytes, _wl_block11);

									if(th_q1_count > 0){
										out.println(gs_q1_count);
									}
									else{
										out.println(th_q1_count);
									}
								
            _bw.write(_wl_block12Bytes, _wl_block12);

									if(th_q2_count > 0){
										out.println(gs_q2_count);
									}
									else{
										out.println(th_q2_count);
									}
								
            _bw.write(_wl_block13Bytes, _wl_block13);

									if(th_q4_count > 0){
										out.println(gs_q4_count);
									}
									else{
										out.println(th_q4_count);
									}
								
            _bw.write(_wl_block14Bytes, _wl_block14);

									if(th_q3_count > 0){
										out.println(gs_q3_count);
									}
									else{
										out.println(th_q3_count);
									}
								
            _bw.write(_wl_block15Bytes, _wl_block15);

									if(th_q5_count > 0){
										out.println(gs_q5_count);
									}
									else{
										out.println(th_q5_count);
									}
								
            _bw.write(_wl_block14Bytes, _wl_block14);

									if(th_q6_count > 0){
										out.println(gs_q6_count);
									}
									else{
										out.println(th_q6_count);
									}
								
            _bw.write(_wl_block16Bytes, _wl_block16);
	
				     }else{
					 
            _bw.write(_wl_block17Bytes, _wl_block17);

									if(th_q1_count > 0){
										out.println("<a href=\"javascript:showGSDetails('1','"+gs_q1_count+"','"+th_q1_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q1_count/th_q1_count),2)+"</a>("+q1_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('1','','"+th_q1_count+"','"+gingival_recording_by+"')\">"+th_q1_count+"</a>");
									}
								
            _bw.write(_wl_block18Bytes, _wl_block18);

									if(th_q2_count > 0){
										out.println("<a href=\"javascript:showGSDetails('2','"+gs_q2_count+"','"+th_q2_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q2_count/th_q2_count),2)+"</a>("+q2_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('2','','"+th_q2_count+"','"+gingival_recording_by+"')\">"+th_q2_count+"</a>");
									}
								
            _bw.write(_wl_block14Bytes, _wl_block14);

									if(th_q3_count > 0){
										out.println("<a href=\"javascript:showGSDetails('3','"+gs_q3_count+"','"+th_q3_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q3_count/th_q3_count),2)+"</a>("+q3_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('3','','"+th_q3_count+"','"+gingival_recording_by+"')\">"+th_q3_count+"</a>");
									}
								
            _bw.write(_wl_block13Bytes, _wl_block13);

									if(th_q6_count > 0){
										out.println("<a href=\"javascript:showGSDetails('6','"+gs_q6_count+"','"+th_q6_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q6_count/th_q6_count),2)+"</a>("+q6_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('6','','"+th_q6_count+"','"+gingival_recording_by+"')\">"+th_q6_count+"</a>");
									}
								
            _bw.write(_wl_block14Bytes, _wl_block14);

									if(th_q5_count > 0){
										out.println("<a href=\"javascript:showGSDetails('5','"+gs_q5_count+"','"+th_q5_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q5_count/th_q5_count),2)+"</a>("+q5_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('5','','"+th_q5_count+"','"+gingival_recording_by+"')\">"+th_q5_count+"</a>");
									}
								
            _bw.write(_wl_block14Bytes, _wl_block14);

									if(th_q4_count > 0){
										out.println("<a href=\"javascript:showGSDetails('4','"+gs_q4_count+"','"+th_q4_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q4_count/th_q4_count),2)+"</a>("+q4_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('4','','"+th_q4_count+"','"+gingival_recording_by+"')\">"+th_q4_count+"</a>");
									}
								
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(q4_tooth));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(q3_tooth));
            _bw.write(_wl_block22Bytes, _wl_block22);

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("SELECT VALUE,GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW WHERE LANGUAGE_ID=?");
								pstmt.setString(1,locale);
								rs=pstmt.executeQuery();

								while(rs.next()){
							
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("VALUE")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("GINGIVAL_STATUS_DESC")));
            _bw.write(_wl_block25Bytes, _wl_block25);

									if(count==2){
							
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
									count++;
								}
							
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(str.toString()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(called_from_tab));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(gingival_recording_by));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(mixed_dentition_YN));
            _bw.write(_wl_block38Bytes, _wl_block38);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.note.label", java.lang.String .class,"key"));
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
}
