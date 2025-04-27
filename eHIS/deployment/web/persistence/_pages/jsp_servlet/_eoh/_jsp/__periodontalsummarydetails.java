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

public final class __periodontalsummarydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PeriodontalSummaryDetails.jsp", 1709119359411L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t\t\t<form name=\"PeridontalSummary\" id=\"PeridontalSummary\" method=\"post\" target=\"messageFrame\">\n\t\t\t\t\n\t\t\t\t\t<table width=\"96%\" cellpadding =4 cellspacing=\'1\' border=\'0\' align=\'center\' valign=\'center\'>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t\n\t\t\t\t\t<br>\n\t\t\t\t\t<table align=\"center\" width=\"96%\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<!-- <td width=\"35%\" class=\'LABEL\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td> -->\n\t\t\t\t\t\t\t<td width=\"35%\" class=\'LABEL\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t<td width=\"15%\" class=\'LABEL\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"35%\" class=\'LABEL\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t<td width=\"15%\" class=\'LABEL\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chart_num\" id=\"chart_num\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"called_from_viewchart_yn\" id=\"called_from_viewchart_yn\" value=\"Y\">\n\t\t\t\t\t<input type=\"hidden\" name=\"called_from_viewchart_gingival\" id=\"called_from_viewchart_gingival\" value=\"N\">\n\t\t\t\t\t<input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</form>\n\t\t\t</body>\n\t\t</html>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
 
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
	//PreparedStatement pstmt3=null;
	ResultSet rs1=null;
	//ResultSet rs3=null;
	
	//boolean isExfoliated = false;
	//int count_GS = 0;
	//

	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String quadrant_sno = checkForNull(request.getParameter("quadrant_sno"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
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
	

	String code_desc="";
	
	String gs_count = checkForNull(request.getParameter("gs_count"));
	if(gs_count.equals("")) gs_count = "0.0"; 

	String th_count = checkForNull(request.getParameter("th_count"));
	if(th_count.equals("")) th_count = "0"; 


	Double gs_count_int = Double.valueOf(gs_count).doubleValue();
	int th_count_int = Integer.parseInt(th_count);
	
	String ns_tooth_no = "";
	String gingival_status_desc = "";
	String gingival_status_value = "";
	//String GS_desc = "";
	//String GS_desc1 = "";

	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	String tooth_no = "";
	String mapped_tooth_no = "";
	//String super_yn = "";
	//String MD_yn = "";
	//String exfolth_yn = "N";
	//String deciduous_tooth_yn = "N";
	//String condition_type = "";
	String status = "";
	//

	//String Of_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Of.Label","oh_labels");
	String For_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.For.Label","oh_labels");

	try{
			con=ConnectionManager.getConnection(request);

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			if(gingival_recording_by.equals("Q")){
				
				/* Commented by Sharon Crasta on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT */
				//pstmt=con.prepareStatement("SELECT QUADRANT_DESC CODE_DESC FROM OH_QUADRANT WHERE NUMBERING_SYSTEM=? AND QUADRANT_SNO = ? AND PERMANENT_DECIDUOUS = ?");

				pstmt=con.prepareStatement("SELECT QUADRANT_DESC CODE_DESC FROM OH_QUADRANT WHERE NUMBERING_SYSTEM=? AND QUADRANT_SNO = ? ");

				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,quadrant_sno);
				//pstmt.setString(3,permanent_deciduous_flag);
			}
			else{
				pstmt=con.prepareStatement("SELECT SEXTANT_DESC CODE_DESC FROM OH_SEXTANT WHERE NUMBERING_SYSTEM=? AND SEXTANT_SNO = ?");
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,quadrant_sno);
				
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				code_desc = checkForNull(rs.getString("CODE_DESC"));
				code_desc = For_label+" "+code_desc;
				//GS_desc = Of_label+" "+code_desc;
				//GS_desc1 = For_label+" "+code_desc;
			}

			

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


		
		
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW C WHERE C.CONDITION_TYPE = A.CONDITION_TYPE AND LANGUAGE_ID = ?) CONDITION_TYPE_DESC, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
			
			//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW C WHERE C.CONDITION_TYPE = A.CONDITION_TYPE AND LANGUAGE_ID = ?) CONDITION_TYPE_DESC, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");

			//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
			if(oh_chart_level.equals("E")){
				if(gingival_recording_by.equals("Q")){
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'  AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
				else{
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'  AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
			
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,locale);
				//pstmt.setString(3,locale);
				//pstmt.setString(3,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,quadrant_sno);
				rs = pstmt.executeQuery();
			}else{
				if(gingival_recording_by.equals("Q")){
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'  AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
				else{
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y' AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
			
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,locale);
				//pstmt.setString(3,locale);
				//pstmt.setString(3,facility_id);
				pstmt.setString(3,other_chart_facility_id);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_num);
				pstmt.setString(6,quadrant_sno);
				rs = pstmt.executeQuery();	
					
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

							while(rs!= null && rs.next()){
								ns_tooth_no = checkForNull(rs.getString("NS_TOOTH_NO"));
								gingival_status_desc = checkForNull(rs.getString("GINGIVAL_STATUS_DESC"));
								gingival_status_value = checkForNull(rs.getString("VALUE"));
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
						//	}
								//
						
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ns_tooth_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(gingival_status_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(gingival_status_value));
            _bw.write(_wl_block11Bytes, _wl_block11);

							}
						
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(th_count));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(gs_count));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

								if(th_count_int > 0){
									out.println(format_decimal((gs_count_int/th_count_int),2));
								}
								else{
									out.println(th_count_int);
								}
							
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

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

            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.NoOfConditionsRecorded.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.NoOfToothsRecordedFor.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.SumOfGingivalStatus.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.AvgOfGingivalStatus.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
