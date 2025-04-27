package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __singlepageconsultationprintpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SinglePageConsultationPrintPreview.jsp", 1709116320575L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script language=javascript src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCA/js/SinglePageConsultation.js\"\n\tlanguage=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\t\n</head>\n<body class=\'CONTENT\' onScroll=false>\n<form>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<table width=\'100%\' cellpadding=3 cellspacing=0 border=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<table width=\'100%\' style=\'height:100px;\' border=0 cellpadding=3 cellspacing=0 align=center >\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  align=\'center\' id=\'headerImageID\'>\n\t\t\t\t\t\t\t\t<img src=\'../../eCA/jsp/CADisplayImages.jsp\' >\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\'  align=\'center\'><h3>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</h3></td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\'  align=\'center\'><h4>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</h4></td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\'center\'><h4>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</h4></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<table width=\'100%\' cellpadding=3 cellspacing=0 border=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'20%\' align=\'center\'><img src=\'../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\' border=\'0\' width=\'40\' height=\'40\'></td>\n\t\t\t\t<td width=\'60%\' align=\'center\'><h3>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</h3></td>\n\t\t\t<td width=\'20%\' align=\'center\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\'20%\' align=\'center\'>&nbsp;</td>\n\t\t\t\t<td width=\'60%\' align=\'center\'><h4>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</h4></td>\n\t\t\t\t<td width=\'20%\' align=\'center\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\'20%\' align=\'center\'>&nbsp;</td>\n\t\t\t\t<td width=\'60%\' align=\'center\'><h4>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</h4></td>\n\t\t\t\t<td width=\'20%\' align=\'center\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\n\t\t<table cellpadding=0 cellspacing=0  width=\'100%\'>\n\t\t\t\t\t\t<div \n\t\t\t\t\t\t\t width=\'100%\' style=\'overflow:auto\'>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  \n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t</div>\n\t\t</table>\n\t\t\n\t\t<table cellpadding=0 cellspacing=0  width=\'100%\'>\n\t\t\t\t\t\t<div \n\t\t\t\t\t\t\t width=\'100%\' style=\'overflow:auto;\'>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t</div>\n\t\t</table>\n\t\t\n\t\t<table cellpadding=0 cellspacing=0  width=\'100%\'>\n\t\t\t\t\t\t<div \n\t\t\t\t\t\t\t width=\'100%\' style=\'overflow:auto\'>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="  \n\t\t\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t</div>\n\t\t</table>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Nijitha												SKR-CRF-0036- new file created.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
	String optionDesc = "";
	Connection con  = null;
	ResultSet oRs = null;
	PreparedStatement pstmt  = null;
	con =  ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT nvl(USER_DEF_LONG_DESC,LONG_DESC) USER_DEF_LONG_DESC FROM CA_OPTION WHERE OPTION_ID=?");
	pstmt.setString(1,option_id);

	oRs = pstmt.executeQuery();
	while(oRs.next())
	{
		optionDesc	=  oRs.getString("USER_DEF_LONG_DESC") == null ? "" : oRs.getString("USER_DEF_LONG_DESC");
	}
	if(oRs!=null) oRs.close();
	if(pstmt!=null) pstmt.close();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(optionDesc));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
		Date currentDate = new Date();
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id_spc") == null ? "" : request.getParameter("encounter_id_spc");
		String widgetHeaderShade = request.getParameter("widgetHeaderShade") == null ? "" : request.getParameter("widgetHeaderShade");
		String reloadWidgetCount = request.getParameter("reloadWidgetCount") == null ? "" : request.getParameter("reloadWidgetCount");
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		String locale			= (String) p.getProperty("LOCALE");
		StringBuilder patient_detail = new StringBuilder();
		String attending_practitioner = "";
		String admitting_practitioner = "";
		String practitioner_name = "";		
		String siteName	=	"";
		String facilityName = "";
		String print_date_time = "";
		String patient_name = "";
		String imageLogoHeader = "";
		int paramIndex = 0;
		
		pstmt = con.prepareStatement("SELECT SF.FACILITY_NAME FACILITY_NAME,SS.SITE_NAME SITE_NAEM FROM SM_FACILITY_PARAM_LANG_VW SF,SM_SITE_PARAM_LANG SS WHERE SF.SITE_ID = SS.SITE_ID AND SF.LANGUAGE_ID = SS.LANGUAGE_ID ANd SF.FACILITY_ID=? AND SF.LANGUAGE_ID=?");
		pstmt.setString(1,facilityId);
		pstmt.setString(2,locale);

		oRs = pstmt.executeQuery();
		while(oRs.next())
		{
			siteName	=  oRs.getString("SITE_NAEM") == null ? "" : oRs.getString("SITE_NAEM");
			facilityName = oRs.getString("FACILITY_NAME") == null ? "" : oRs.getString("FACILITY_NAME");
		}
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
		
		patient_detail = patient_detail.append("SELECT AM_GET_DESC.AM_PRACTITIONER(?,?,1) practitioner_name,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(SELECT SHORT_NAME FROM am_practitioner WHERE practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM PR_ENCOUNTER a, MP_PATIENT B WHERE A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? AND a.patient_id = ?");
		pstmt = con.prepareStatement(patient_detail.toString());
		pstmt.setString(++paramIndex,practitioner_id);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,encounter_id);
		pstmt.setString(++paramIndex,patient_id);
		oRs = pstmt.executeQuery();
		if (oRs.next())
		{
			attending_practitioner = oRs.getString("attending_practitioner");
			admitting_practitioner = oRs.getString("admitting_practitioner")==null?"":oRs.getString("admitting_practitioner");
			print_date_time = oRs.getString("print_date_time")==null?"":oRs.getString("print_date_time");
			patient_name = oRs.getString("PATIENT_NAME")==null?"":oRs.getString("PATIENT_NAME");
			practitioner_name = oRs.getString("practitioner_name")==null?"":oRs.getString("practitioner_name");
			
		}
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
	
	
		pstmt	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
		oRs = pstmt.executeQuery();
		if(oRs.next()){
			imageLogoHeader="Y";				
		}
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
		if (con != null)
			ConnectionManager.returnConnection(con, request);

            _bw.write(_wl_block9Bytes, _wl_block9);
if("Y".equals(imageLogoHeader)){
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(siteName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(optionDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(siteName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(optionDesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            {java.lang.String __page ="SinglePageConsultationHeader.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("encounter_id"), weblogic.utils.StringUtils.valueOf(encounter_id
                        )},{ weblogic.utils.StringUtils.valueOf("patient_name"), weblogic.utils.StringUtils.valueOf(patient_name
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block22Bytes, _wl_block22);
            {java.lang.String __page ="SinglePageConsultation.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("encounter_id_spc"), weblogic.utils.StringUtils.valueOf(encounter_id
                        )},{ weblogic.utils.StringUtils.valueOf("widgetHeaderShade"), weblogic.utils.StringUtils.valueOf(widgetHeaderShade
                        )},{ weblogic.utils.StringUtils.valueOf("reloadWidgetCount"), weblogic.utils.StringUtils.valueOf(reloadWidgetCount
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block26Bytes, _wl_block26);
            {java.lang.String __page ="SinglePageConsultationFooter.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("practitioner_name"), weblogic.utils.StringUtils.valueOf(practitioner_name
                        )},{ weblogic.utils.StringUtils.valueOf("print_date_time"), weblogic.utils.StringUtils.valueOf(print_date_time
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block28Bytes, _wl_block28);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
