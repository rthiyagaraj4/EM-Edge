package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __totalagegroupsexnationalityform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/TotalAgeGroupSexNationalityForm.jsp", 1743586266920L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<HEAD>\n<TITLE></TITLE>\n<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"/eHIS/common/html/ecis.css\"></link>-->\n<script src=\"/eHIS/common/js/ValidateControl.js\"></script>\n<script src=\"/eHIS/common/js/common.js\"></script>\n<script src=\"/eHIS/or/js/TotalAgeGroupSexNationality.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n\t\t\n\tasync function searchCode(obj,target)\n\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"28\" ;\n\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar sql=\"\";\n\t\t\tvar search_code=\"\";\n\t\t\tvar search_desc=\"\";\n\t\t\tvar tit=\"\";\n\t\t\t\n\t\t\tif(obj.name==\"service_code\")\n\t\t\t{\n\t\t\t\ttit=\"Service Code\"\n\t\t\t\tsql=\"select service_code, short_desc from or_service \";\n\t\t\t\tsearch_code=\"service_code\";\n\t\t\t\tsearch_desc=\"short_desc\";\n\t\t\t}\n\t\t\telse if(obj.name==\"service_category\")\n\t\t\t{\n\t\t\t\ttit=\"Service Category\"\n\t\t\t\tsql=\"select service_category_code, short_desc from or_service_category \";\n\t\t\t\tsearch_code=\"service_category_code\";\n\t\t\t\tsearch_desc=\"short_desc\";\n\t\t\t}\n\n\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tretVal = await window.showModalDialog(\"/eHIS/common/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit,arguments,features);\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\n\t\t\t\ttarget.focus();\n\t}\n\n\t\n\n</script>\n</HEAD>\n<BODY OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<br>\n<br>\n\n<form name=\"TotalAgeGroupSexNationalityForm\" id=\"TotalAgeGroupSexNationalityForm\"   target=\"messageFrame\">\n\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t<th align=\'left\'> Report Criteria\n\t\t</th>\n\n\t<tr>\n\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\'>\n\t<tr>\n\t\t<td align=\'right\' width=\'30%\' class=\"label\">Service Type Code&nbsp;</td>\n\t\t<td width=\'20%\'>\n\t\t\t<select name=\'p_service_type_code\' id=\'p_service_type_code\' value=\'short_desc\'>\n\t\t\t\t<option value=\'\'>&nbsp;&nbsp;--- All ---&nbsp;&nbsp;\n\t\t\t\t<option value=\'DS\' >Clinical Srv</option>\n\t\t\t\t<option value=\'LB\' >Laboratory</option>\n\t\t\t\t<option value=\'RD\' >Radiology</option>\n\t\t\t</select>&nbsp;\n</td>\n<td>&nbsp</td>\n</tr>\n<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n</tr>\n<!-- Added from here for Order Status here  -->\n<tr>\n\t\t<td align=\'right\' width=\'30%\' class=\"label\">Result Status&nbsp;</td>\n\t\t<td width=\'20%\'  >\n\t\t\t\t\t<select name=\'p_order_Status\' id=\'p_order_Status\' value =\'long_desc\'>\n\t\t\t\t\t\t\t<option value=\'\'>&nbsp;&nbsp;--- All ---&nbsp;&nbsp;</option>\n\t\t\t\t\t\t\t<option value=\'2\'>Partial</option>\n\t\t\t\t\t\t\t<option value=\'3\'>Complete</option>\n\t\t\t\t\t</select>&nbsp;\n\t\t</td>\n\t\t<td>&nbsp</td>\n</tr>\n</td>\n</tr>\n<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n</tr>\n\n<!-- Till for Order Status here  -->\n<tr>\n\t\t\t<td align=\"center\" width=\"35%\">&nbsp;</td>\n\t\t\t<td class=\"label\" width=\"20%\">From</td>\n\t\t\t<td class=\"label\" width=\"40%\">To</td>\n</tr>\n<!--Added for Order Date From and To validations -->\n<tr>\n\t\t<td align=\'right\' width=\'30%\' class=\"label\">Period&nbsp;</td>\n\t\t<td width=\'20%\'  >\n\t\t<input type=text name=\'p_fr_order_date_time\' id=\'p_fr_order_date_time\'\n\t\tonBlur = \'CheckDate(this);\'  size=\"10\" maxlength=\"10\" align=\"center\">&nbsp;\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t</td>\n\t\t<td width=\'20%\'  >\n\t\t<input type=text name=\'p_to_order_date_time\' id=\'p_to_order_date_time\' \n\t\tonBlur=\"CheckDate(this);doDateCheckForOr()\"; size=\"10\" maxlength=\"10\" align=\"center\">&nbsp;\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t</td>\n</tr>\n<tr>\n\t\t<td>&nbsp;</td>\n\t\t<td>&nbsp;</td>\n</tr>\n<tr>\n\t\t<td align=\'right\' width=\'30%\' class=\"label\">Service Category&nbsp;</td>\n\t\t<td width=\'20%\'>\n\t\t\t\t<select name=\'p_fr_service_category\' id=\'p_fr_service_category\' value =\'short_desc\'>\n\t\t\t\t\t\t<option value=\'\'>&nbsp;&nbsp;---------- All -----------&nbsp;&nbsp;\n\t\t\t\t\t\t<option value=\'BIOCH\' >Biochemistry</option>\n\t\t\t\t\t\t<option value=\'NURSIN\' >Dressing</option>\n\t\t\t\t\t\t<option value=\'DRESS\' >Dressing(Obs)</option>\n\t\t\t\t\t\t<option value=\'ECGG\' >ECG</option>\n\t\t\t\t\t\t<option value=\'ECG\' >ECG (Obselete)</option>\n\t\t\t\t\t\t<option value=\'HAEM\' >Haematology</option>\n\t\t\t\t\t\t<option value=\'INJ\' >Injections</option>\n\t\t\t\t\t\t<option value=\'MICRO\' >Microbiology</option>\n\t\t\t\t\t\t<option value=\'NEBULI\' >Nebuliser</option>\n\t\t\t\t\t\t<option value=\'NUR\' >Nebulizer(Oblt)</option>\n\t\t\t\t\t\t<option value=\'RADIO\' >Radiology</option>\n\t\t\t\t\t\t<option value=\'ULTRO\' >Ultrasound</option>\n\t\t\t\t</select>&nbsp;\n\t\t</td>\n\t\t<td width=\'40%\'> \n\t\t\t<select name=\'p_to_service_category\' id=\'p_to_service_category\' value =\'short_desc\'> \n\t\t\t\t\t<option value=\'\'>&nbsp;&nbsp;---------- All -----------&nbsp;&nbsp;\n\t\t\t\t\t<option value=\'BIOCH\' >Biochemistry</option>\n\t\t\t\t\t<option value=\'NURSIN\' >Dressing</option>\n\t\t\t\t\t<option value=\'DRESS\' >Dressing(Obs)</option>\n\t\t\t\t\t<option value=\'ECGG\' >ECG</option>\n\t\t\t\t\t<option value=\'ECG\' >ECG (Obselete)</option>\n\t\t\t\t\t<option value=\'HAEM\' >Haematology</option>\n\t\t\t\t\t<option value=\'INJ\' >Injections</option>\n\t\t\t\t\t<option value=\'MICRO\' >Microbiology</option>\n\t\t\t\t\t<option value=\'NEBULI\' >Nebuliser</option>\n\t\t\t\t\t<option value=\'NUR\' >Nebulizer(Oblt)</option>\n\t\t\t\t\t<option value=\'RADIO\' >Radiology</option>\n\t\t\t\t\t<option value=\'ULTRO\' >Ultrasound</option>\n\t\t</select>&nbsp;\n\t\t</td>\n</tr>\n<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">Service&nbsp;</td>\n\t\t\t<td width=\'20%\'>\n\t\t\t<input type=text  name=\'p_fr_service_code\' id=\'p_fr_service_code\' size=\"10\" maxlength=\"10\" align=\"center\">\n\t\t\t<input type=\'button\' name=\'service_code\' id=\'service_code\' value=\'?\' class=\'button\' ><!--onclick=\'searchCode(this,p_fr_service_code)\'-->\n\t\t\t</td>\n\t\t\t<td width=\'40%\'> \n\t\t\t\t<input type=text  name=\'p_to_service_code\' id=\'p_to_service_code\' size=\"10\" maxlength=\"10\" align=\"center\">\n\t\t\t\t<input type=\'button\' name=\'service_code\' id=\'service_code\' value=\'?\' class=\'button\' ><!--onclick=\'searchCode(this,p_to_service_code)\'-->\n\t\t\t</td>\n</tr>\n<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n</tr>\n<tr>\n\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">&nbsp;</td>\n\t\t\t<td width=\'20%\'>\n</tr>\n<tr>\n\t\t<td>&nbsp;</td>\n\t\t<td>&nbsp;</td>\n</tr>\n<!-- End for Adding the Order Date  -->\n</table>\n</td>\n</tr>\n</table>\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\'CA\'>\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"OR\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"ORRSTAGS\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\tvalue=\"SUPPORT\">\n<INPUT TYPE=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" VALUE=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\n\n</form>\n</BODY>\n</HTML>\n\t\t\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
