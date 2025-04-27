package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import ePH.PharmacistHomeBean;
import ePH.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __pharmacisthomesummary extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PharmacistHomeSummary.jsp", 1709121018584L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<STYLE>\n\t\t\t.gridData1\n\t\t\t{\n\t\t\t\tbackground-color: #FFFFFF;\n\t\t\t\theight:18px;\n\t\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\t\tfont-size: 10px;\n\t\t\t\tcolor: #000000;\n\t\t\t\tfont-weight:normal;\n\t\t\t\ttext-align:left;\n\t\t\t\tvertical-align:middle;\n\t\t\t\tborder-bottom:0px;\n\t\t\t\tborder-top:0px;\n\t\t\t\tborder-left:0px;\n\t\t\t\tborder-right:0px;\n\t\t\t\tborder-style:solid;\n\t\t\t\tborder-color:#EEEEEE;\n\t\t\t\tpadding-left:10px;\n\t\t\t\tpadding-right:10px;\n\t\t\t}\n\t\t\t.gridDataBlue1\n\t\t\t{\n\t\t\t\theight:18px;\n\t\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\t\tfont-size: 8pt;\n\t\t\t\tcolor: #0000FF;\n\t\t\t\tfont-weight:normal;\n\t\t\t\ttext-align:left;\n\t\t\t\tvertical-align:middle;\n\t\t\t\tborder-bottom:0px;\n\t\t\t\tborder-top:0px;\n\t\t\t\tborder-left:0px;\n\t\t\t\tborder-right:0px;\t\n\t\t\t\tbackground-color: #FFFFFF;\t\n\t\t\t\tborder-style:none;\n\t\t\t\tborder-color:#EEEEEE;\n\t\t\t}\n\t\t</STYLE>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script src=\'../../ePH/js/PharmacistHome.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \t\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<title>Summary Preview</title>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</head>\n\t<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<FORM METHOD=POST ACTION=\"\" name=\"frmMenu\" id=\"frmMenu\">\n\t\t\t<TABLE width=\'100%\' border=\"0\" align=\'center\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<tr><td align=\"left\" class=\'gridData1\'nowrap><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td></tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<tr><td class=\"gridData1\" nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")</td> </tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<a style=\'color:black;\' href=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onMouseOver=\'\' onclick=\"loadTitleName(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')  \"target=\"workAreaFrame\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a></td> </tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t<tr><td class=\"gridData1\" nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<a style=\'color:blue;\' href=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")</a></td> </tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<a style=\'color:black;\' onMouseOver=\'\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\n\t\t\t</TABLE>\n\t\t</FORM>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String SummaryPreviewPage=request.getParameter("SummaryPreviewPage") == null ? "" : request.getParameter("SummaryPreviewPage");			

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		if(SummaryPreviewPage.equals("SummaryPreviewPage")){			

            _bw.write(_wl_block9Bytes, _wl_block9);

		}

            _bw.write(_wl_block10Bytes, _wl_block10);
		
				String bean_id   = "PharmacistHomeBean" ;
				String bean_name = "ePH.PharmacistHomeBean";
				PharmacistHomeBean bean = (PharmacistHomeBean)getBeanObject( bean_id, bean_name, request ) ;
				bean.setLanguageId(locale);

				Connection con = null;
				String desktopID = request.getParameter("desktopID") == null ? "" : request.getParameter("desktopID");	
				String facility_id=(String) session.getValue("facility_id");
				String store_code = "" ,from_date = "" ,to_date = "";
				String User_id	  =	(String)session.getValue("login_user");		
				ArrayList arrList = new ArrayList();
				PreparedStatement pstmtComp = null,pstmtcnt=null;
				ResultSet rsComp = null,rscount=null;		
				String summaryHdr="";		
				String summarySubHrd="";	
				String prevsummaryHdr="";
				String summary_comp_id="";
				String prefixspace="";
				String sourceSQL="";
				String tempStr1 = "";				
				String totCount="0";
				String desktopFunctionID="";		
				String summarySubHrdbg ="";
				String module_id ="";
				String function_id ="";
				String access ="";
				store_code	=  bean.getStore_code();
				//to_date		=  com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
				//from_date	=  com.ehis.util.DateUtils.minusDate(to_date,"DMY",locale,7,"d").toString();
				try{
					con = ConnectionManager.getConnection(request);
					//pstmtComp = con.prepareStatement("SELECT MIN (LEVEL) level1, LPAD (' ', (MIN (LEVEL) - 1) * 12, ' ') prefixspace, c.summary_comp_desc summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc ) summary_comp_desc_bg, a.summary_comp_id || summary_comp_occ_num summary_comp_id, a.hdr_summary_comp_id || hdr_summary_comp_occ_num hdr_summary_comp_id, ds.source_sql, c.executable_name, order_seq, (SELECT module_id FROM sm_function WHERE executable_name LIKE c.executable_name || '%' AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) module_id, (SELECT function_id FROM sm_function WHERE executable_name LIKE c.executable_name || '%' AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) function_id, (SELECT insert_access_yn || update_access_yn || query_only_access_yn || delete_access_yn || print_access_yn FROM sm_menu_dtl WHERE function_id = (SELECT function_id FROM sm_function WHERE executable_name LIKE c.executable_name || '%' AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) AND ROWNUM = 1) access_yn, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE - NVL (disp_beyond_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), (SELECT SYSDATE - NVL (durn_for_start_date, 0) FROM st_facility_param WHERE facility_id = ?) ), 'dd/mm/yyyy' ) from_date, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE + NVL (disp_before_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), SYSDATE ), 'dd/mm/yyyy' ) TO_DATE FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds WHERE a.desktop_summary_id = ? AND c.summary_comp_id(+) = a.summary_comp_id AND ds.source_id(+) = c.summary_data_source_id GROUP BY c.summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc), a.summary_comp_id || summary_comp_occ_num, a.hdr_summary_comp_id || hdr_summary_comp_occ_num, ds.source_sql, c.APPLICABLE_MODULE_ID, c.executable_name, order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num ORDER BY order_seq");
					// ML-MMOH-CRF-1479 Start.
					//pstmtComp = con.prepareStatement("SELECT MIN (LEVEL) level1, LPAD ('&nbsp;&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;&nbsp;') prefixspace, c.summary_comp_desc summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc ) summary_comp_desc_bg, a.summary_comp_id || summary_comp_occ_num summary_comp_id, a.hdr_summary_comp_id || hdr_summary_comp_occ_num hdr_summary_comp_id, ds.source_sql, c.executable_name, order_seq, (SELECT module_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) module_id, (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) function_id, (SELECT insert_access_yn || update_access_yn || query_only_access_yn || delete_access_yn || print_access_yn FROM sm_menu_dtl WHERE function_id = (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) AND ROWNUM = 1) access_yn, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE - NVL (disp_beyond_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), (SELECT SYSDATE - NVL (durn_for_start_date, 0) FROM st_facility_param WHERE facility_id = ?) ), 'dd/mm/yyyy' ) from_date, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE + NVL (disp_before_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), SYSDATE ), 'dd/mm/yyyy' ) TO_DATE, TO_CHAR ( (SELECT SYSDATE - NVL (disp_beyond_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = 'RP') , 'dd/mm/yyyy' ) from_date_IP, TO_CHAR ((SELECT SYSDATE + NVL (disp_before_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = 'RP' ), 'dd/mm/yyyy' ) TO_DATE_IP, to_char(sysdate, 'dd/mm/yyyy') curr_date FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds WHERE a.desktop_summary_id = ? AND c.summary_comp_id(+) = a.summary_comp_id AND ds.source_id(+) = c.summary_data_source_id GROUP BY c.summary_comp_desc, summary_comp_desc_legend, /* NVL (c.summary_comp_desc_legend, c.summary_comp_desc),*/ a.summary_comp_id || summary_comp_occ_num, a.hdr_summary_comp_id || hdr_summary_comp_occ_num, ds.source_sql, c.APPLICABLE_MODULE_ID, c.executable_name, order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num ORDER BY order_seq");
				//	pstmtComp.setString(1,facility_id);
				//	pstmtComp.setString(2,facility_id);
				//	pstmtComp.setString(3,facility_id);
				//	pstmtComp.setString(4,desktopID);
				//	pstmtComp.setString(5,desktopID);
					
					pstmtComp = con.prepareStatement("SELECT MIN (LEVEL) level1, LPAD ('&nbsp;&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;&nbsp;') prefixspace, c.summary_comp_desc summary_comp_desc, NVL (c.summary_comp_desc_legend, c.summary_comp_desc ) summary_comp_desc_bg, a.summary_comp_id || summary_comp_occ_num summary_comp_id, a.hdr_summary_comp_id || hdr_summary_comp_occ_num hdr_summary_comp_id, ds.source_sql, c.executable_name, order_seq, (SELECT module_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) module_id, (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) function_id, (SELECT insert_access_yn || update_access_yn || query_only_access_yn || delete_access_yn || print_access_yn FROM sm_menu_dtl WHERE function_id = (SELECT function_id FROM sm_function WHERE FUNCTION_NAME like NVL (c.summary_comp_desc_legend, c.summary_comp_desc) AND module_id IN ('ST', 'PH', 'MM') AND ROWNUM = 1) AND ROWNUM = 1) access_yn, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE - NVL (disp_beyond_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), (SELECT SYSDATE - NVL (durn_for_start_date, 0) FROM st_facility_param WHERE facility_id = ?) ), 'dd/mm/yyyy' ) from_date, TO_CHAR (DECODE (c.APPLICABLE_MODULE_ID, 'PH', (SELECT SYSDATE + NVL (disp_before_no_of_days, 0) FROM ph_facility_param WHERE facility_id = ?), SYSDATE ), 'dd/mm/yyyy' ) TO_DATE, TO_CHAR ( (SELECT SYSDATE - NVL (disp_beyond_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = ?) , 'dd/mm/yyyy' ) from_date_IP, TO_CHAR ((SELECT SYSDATE + NVL (disp_before_no_of_days_IP, 0) FROM ph_facility_param WHERE facility_id = ? ), 'dd/mm/yyyy' ) TO_DATE_IP, to_char(sysdate, 'dd/mm/yyyy') curr_date FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds WHERE a.desktop_summary_id = ? AND c.summary_comp_id(+) = a.summary_comp_id AND ds.source_id(+) = c.summary_data_source_id GROUP BY c.summary_comp_desc, summary_comp_desc_legend, /* NVL (c.summary_comp_desc_legend, c.summary_comp_desc),*/ a.summary_comp_id || summary_comp_occ_num, a.hdr_summary_comp_id || hdr_summary_comp_occ_num, ds.source_sql, c.APPLICABLE_MODULE_ID, c.executable_name, order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num ORDER BY order_seq");
					pstmtComp.setString(1,facility_id);
					pstmtComp.setString(2,facility_id);
					pstmtComp.setString(3,facility_id);
					pstmtComp.setString(4,facility_id);
					pstmtComp.setString(5,facility_id);
					pstmtComp.setString(6,desktopID);
					pstmtComp.setString(7,desktopID);
					
					//ML-MMOH-CRF-1479 End.
					rsComp = pstmtComp.executeQuery();

					while(rsComp.next()){	
						totCount = "0";
						arrList.clear();
						summary_comp_id=rsComp.getString("summary_comp_id");

						if (prevsummaryHdr.equals(summary_comp_id)){
							continue;
						}
						else{
							prevsummaryHdr=summary_comp_id;				
						}
						summaryHdr=rsComp.getString("LEVEL1");
						summarySubHrd=rsComp.getString("SUMMARY_COMP_DESC");
						summarySubHrdbg=rsComp.getString("summary_comp_desc_bg");
						sourceSQL=rsComp.getString("SOURCE_SQL")==null?"":rsComp.getString("SOURCE_SQL");	
						//sourceSQL="";
						prefixspace=rsComp.getString("prefixspace")==null?"":rsComp.getString("prefixspace");	
						desktopFunctionID=rsComp.getString("EXECUTABLE_NAME")==null?"":rsComp.getString("EXECUTABLE_NAME");	
						module_id=rsComp.getString("MODULE_ID")==null?"":rsComp.getString("MODULE_ID");					
						function_id=rsComp.getString("FUNCTION_ID")==null?"":rsComp.getString("FUNCTION_ID");					
						access=rsComp.getString("ACCESS_YN")==null?"NNNN":rsComp.getString("ACCESS_YN");
						
						if (!sourceSQL.equals("")){			
							while (sourceSQL.indexOf("&&") > 0){
								tempStr1 = sourceSQL.substring(sourceSQL.indexOf("&&"), (sourceSQL.indexOf("##")+2));		
								sourceSQL  = sourceSQL.replaceFirst(tempStr1,"?");
								arrList.add( tempStr1.substring((tempStr1.indexOf("&&")+2),tempStr1.indexOf("##")));
							}
//System.err.println("====sourceSQL===>"+sourceSQL);
//System.err.println("====arrList==>"+arrList+"  facility_id===>"+facility_id+"=="+rsComp.getString("from_date")+"=="+rsComp.getString("to_date")+"==User_id"+User_id);
							pstmtcnt = con.prepareStatement(sourceSQL);		
							for (int j = 0 ;j<arrList.size() ;j++ )	{
								if (((String)arrList.get(j)).equalsIgnoreCase("LOGGED_IN_FACILITY")){									
									pstmtcnt.setString(j+1,facility_id);
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("LOGGED_IN_STORE")){									
									pstmtcnt.setString(j+1,store_code);									
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("FROM_DATE")){	
									pstmtcnt.setString(j+1,rsComp.getString("from_date"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("TO_DATE")){									
									pstmtcnt.setString(j+1,rsComp.getString("to_date"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("FROM_DATE_IP")){	
									pstmtcnt.setString(j+1,rsComp.getString("FROM_DATE_IP"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("TO_DATE_IP")){									
									pstmtcnt.setString(j+1,rsComp.getString("TO_DATE_IP"));
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("LOGGED_IN_USERID")){									
									pstmtcnt.setString(j+1,User_id);
								}
								else if (((String)arrList.get(j)).equalsIgnoreCase("FILL_DATE")){									
									pstmtcnt.setString(j+1,rsComp.getString("CURR_DATE"));
								}
							}
							rscount = pstmtcnt.executeQuery();
							if (rscount.next()){
								totCount = rscount.getString(1);				
								if (totCount==null)  totCount="0";
							}
							else{
								totCount="0";
							}
							if(rscount != null)
								rscount.close();
							if(pstmtcnt != null)
								pstmtcnt.close();							
						}
					   if(!desktopFunctionID.equals("")){
							if(desktopFunctionID.indexOf("?")!= -1)
								desktopFunctionID = desktopFunctionID +"&homepage=Y&store_code="+store_code+"&home_required_yn=N&module_id="+module_id+"&function_id="+function_id+"&access="+access+"&count="+totCount+"&heading="+summarySubHrd;
							else
								desktopFunctionID = desktopFunctionID +"?homepage=Y&store_code="+store_code+"&home_required_yn=N&module_id="+module_id+"&function_id="+function_id+"&access="+access+"&count="+totCount+"&heading="+summarySubHrdbg;
						}
						if(summaryHdr.equals("1") || desktopFunctionID.equals("")){

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block12Bytes, _wl_block12);
	
						}
						else{
							if(SummaryPreviewPage.equals("SummaryPreviewPage")){
								totCount="0";

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block15Bytes, _wl_block15);

							}
							else if(sourceSQL.equals("")){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prefixspace));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(desktopFunctionID));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(summarySubHrdbg));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block19Bytes, _wl_block19);

							}
							else{
								if(!totCount.equals("0")){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(prefixspace));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(desktopFunctionID));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(summarySubHrdbg));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block22Bytes, _wl_block22);

								}
								else{

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(prefixspace));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block22Bytes, _wl_block22);

								}
							}
						}
					}									
				}
				catch(Exception e){
					e.printStackTrace();
					out.println("Error while gettting the menu: "+sourceSQL+" summary_comp_id="+summary_comp_id);
				}
				finally{
					try{
						if(rsComp!= null) rsComp.close();
						if(pstmtComp!=null) pstmtComp.close();
						if(con!= null) ConnectionManager.returnConnection(con,request);
					}
					catch(Exception e){
						e.printStackTrace();
						out.println("Exception in PharmacistHomeSummary.jsp"+e.toString());
						
					}
				}

            _bw.write(_wl_block24Bytes, _wl_block24);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
