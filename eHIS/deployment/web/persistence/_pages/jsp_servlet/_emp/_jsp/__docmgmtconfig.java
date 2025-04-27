package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eMP.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __docmgmtconfig extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/DocMgmtConfig.jsp", 1709118610198L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../js/DocMgmtConfig.js\' language=\'javascript\' ></script>\n<Script src=\'../../eCommon/js/CommonLookup.js\' language=\"JavaScript\" ></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<body onscroll=\'scrollTitleTop()\' class=\'CONTENT\' OnMouseDown=\"CodeArrest()\"\n\tonload=\'FocusFirstElement();\' onKeyDown=\"lockKey()\">\n\t<form name=\"DocMgmtConfigForm\" id=\"DocMgmtConfigForm\"\n\t\taction=\"../../servlet/eMP.DocMgmtConfigServlet\" method=\"post\"\n\t\ttarget=\"messageFrame\">\n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 800px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"3\">Scan Document Option&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\">Scanning Enabled&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\' colspan=\"2\"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"doc_scan_enabled\" id=\"doc_scan_enabled\" id=\"doc_scan_enabled\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\tonclick=\'setScanEnabled(this)\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\">Scan UI Enabled&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\' colspan=\"2\"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"doc_scan_ui_enabled\" id=\"doc_scan_ui_enabled\" id=\"doc_scan_ui_enabled\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\">Document to be saved as&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\' ><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"doc_save_as\" id=\"doc_save_as\" value=\"0\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">PDF</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"doc_save_as\" id=\"doc_save_as\" value=\"1\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">IMAGE</td>\n\t\t\t\t</tr>\n\t\t\t\t</tbody>\n\t\t</table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 800px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"3\">Document Option&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"50%\">Document Storage Option&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'   width=\"25%\" ><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"doc_folder_option\" id=\"doc_folder_option\" value=\"0\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\tonclick=\'setDocPathEnabled(this)\'>Database(Existing)</td>\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'Fields\' width=\"25%\"><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"doc_folder_option\" id=\"doc_folder_option\" value=\"1\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\tonclick=\'setDocPathEnabled(this)\'>Shared Path</td>\n\t\t\t\t</tr>\t\n\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'  width=\"50%\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"doc_types\" id=\"doc_types\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\"sharedPathMandatoryImg\" name=\"sharedPathMandatoryImg\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'  colspan=\"2\"  width=\"50%\" ><input type=\"text\"\n\t\t\t\t\t\t\t\t\tname=\"doc_shared_path\" id=\"doc_shared_path\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\t\t\t\t\t\t\t\t\tsize=90 maxlength=128 \n\t\t\t\t\t\t\t\t\tonkeypress=\"return CheckForSpecCharsWithSpaceBlur(event)\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t \n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\n\n\t\t\t</tbody>\n\t\t</table>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 800px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"3\">Photo Option&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"50%\">Photo Storage Option&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'   width=\"25%\" ><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"doc_photo_option\" id=\"doc_photo_option\" value=\"0\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\tonclick=\'setDocPathEnabled(this)\'>Database(Existing)</td>\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'Fields\' width=\"25%\"><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"doc_photo_option\" id=\"doc_photo_option\" value=\"1\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\tonclick=\'setDocPathEnabled(this)\'>Shared Path</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'gridData\'  width=\"50%\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"photo_types\" id=\"photo_types\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\"photoPathMandatoryImg\" name=\"photoPathMandatoryImg\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\t\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t\t<td class=\'Fields\'  colspan=\"2\"  width=\"50%\" ><input type=\"text\"\n\t\t\t\t\t\t\t\t\t\tname=\"photo_shared_path\" id=\"photo_shared_path\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"\n\t\t\t\t\t\t\t\t\t\tsize=90 maxlength=128 \n\t\t\t\t\t\t\t\t\t\tonkeypress=\"return CheckForSpecCharsWithSpaceBlur(event)\"\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >\t\t\t\t\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t</tbody>\n\t\t</table>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 800px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"3\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"50%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t<td class=\'Fields\'   width=\"25%\">\n\t\t\t\t\t<input type=\"radio\" name=\"inventory_folder_option\" id=\"inventory_folder_option\" value=\"0\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="onclick=\'setDocPathEnabled(this)\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\t\t\t\t\n\t\t\t\t\t<td class=\'Fields\' width=\"25%\">\t\t\t\t\t\n\t\t\t\t\t<input type=\"radio\" name=\"inventory_folder_option\" id=\"inventory_folder_option\" value=\"1\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t</tr>\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'  width=\"50%\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"inv_types\" id=\"inv_types\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\"sharePathMandImg\" name=\"sharePathMandImg\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\n\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'  colspan=\"2\"  width=\"50%\" ><input type=\"text\"\n\t\t\t\t\t\t\t\t\tname=\"inventory_shared_path\" id=\"inventory_shared_path\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"\"\n\t\t\t\t\t\t\t\t\tsize=90 maxlength=128 \n\t\t\t\t\t\t\t\t\tonkeypress=\"return CheckForSpecCharsWithSpaceBlur(event)\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\n\t\t\t\t\t\t\t\t\t\t\n\t\t<br>\n\n\t\t<input type=hidden name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\t\t\n\t\t<input type=hidden name=\"ScanningUIEnabled\" id=\"ScanningUIEnabled\" value=\"\">\n\t\t<input type=hidden name=\"ScanningEnabled\" id=\"ScanningEnabled\" value=\"\"> \n\t\t<input type=hidden name=\"DocSaveAs\" id=\"DocSaveAs\" value=\"\"> \n\t\t<input type=hidden name=\"DocFolderOption\" id=\"DocFolderOption\" value=\"\"> \n\t\t<input type=hidden name=\"DocSharedPath\" id=\"DocSharedPath\" value=\"\"> \n\t\t<input type=hidden name=\"WebServiceUrl\" id=\"WebServiceUrl\" value=\"\"> \n\t\t<input type=hidden name=\"DocCheckStatus\" id=\"DocCheckStatus\" value=\"\"> \n\t\t<input type=hidden name=\"isDocumentOption\" id=\"isDocumentOption\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n\t\t<input type=hidden name=\"isScanningOption\" id=\"isScanningOption\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"> \n\t\t<input type=hidden name=\"isPhotoOption\" id=\"isPhotoOption\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"> \n\t\t<!--Added by kamatchi s for MO-CRF-20171.1-->\n\t\t<input type=hidden name=\"isInventoryOption\" id=\"isInventoryOption\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=hidden name=\"InvFolderOption\" id=\"InvFolderOption\" value=\"\"> \n\t\t<input type=hidden name=\"invSharedPath\" id=\"invSharedPath\" value=\"\">\n\t\t<input type=hidden name=\"PhotoDocOption\" id=\"PhotoDocOption\" value=\"\">\n\t\t<input type=hidden name=\"PhotoSharedpath\" id=\"PhotoSharedpath\" value=\"\">\n\t\t<input type=hidden name=\"facilityId\" id=\"facilityId\" value=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">\n\t\t<input type=hidden name=\"facilityId_df\" id=\"facilityId_df\" value=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
24/09/2014     		1   		Sethuraman      Created for Document Configuration   changed.
-------------------------------------------------------------------------------------------------------------------------------------
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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");	
	String mode="";
	String readOnly = "";
	String status = "";		
	String signatureStatus = "";		
	String enabled_checked="";
	String disabledStatus = "disabled";
	int doc_scan_enabled = 0;
	String sFacilityId = "",sFacilityId_df = "";
	int iDocScanEnabled = 0;	
	int iDocSaveAs = 0; 
	int iDocFolderOption = 0; 
	String sDocSharedPath = "";
	String sWebServiceUrl = "";
	int iPhotoFolderOption = 0;

	int iDocScanUIEnabled = 0; // Added by prithivi on 24/2/2016
	//int iDocCheckStatus = 0; 
	
	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	sFacilityId = (request.getParameter("facilityId")==null)?"":request.getParameter("facilityId");	
	sFacilityId_df = (request.getParameter("facilityId_df")==null)?"":request.getParameter("facilityId_df");	
	
	//Added by Bhuvana on 23/05/2019
	int iPhotoStorageOption= 0;
	boolean isDebugYN = false; 
	boolean isDocumentOption = false;
	boolean isPhotoOption = false;
	boolean isScanningOption = false;
	boolean isFinancialDocument = false;//Added by Santhosh for GHL-CRF-0648

	int iInvFolderOption = 0;//Added by Kamatchi S for MO-CRF-20171.1      
	boolean isInventoryOption = false;//Added by Kamatchi S for MO-CRF-20171.1
	Connection conn	= null;
	conn = ConnectionManager.getConnection(request); 
	
	isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

	System.out.println("DocMgmtConfig isDebugYN--> "+isDebugYN);

	//Ended by Bhuvana on 23/05/2019
	
	System.out.println("sFacilityId --> "+sFacilityId+" sFacilityId_df --> "+sFacilityId_df);
	try{

		isDocumentOption = CommonBean.isSiteSpecific(conn, "SM","DOCUMENTATION");
		if (isDebugYN) System.out.println("isDocumentOption"+isDocumentOption+".");

		isPhotoOption = CommonBean.isSiteSpecific(conn, "SM","PATIENT_PHOTO");
		if (isDebugYN) System.out.println("isPhotoOption"+isPhotoOption);

		isScanningOption = CommonBean.isSiteSpecific(conn, "SM","SCANNING" );
		if (isDebugYN) System.out.println("isScanningOption"+isScanningOption);
		//Ended by Bhuvana on 23/05/2019
		
		//Added by kamatchi S for MO-CRF-20171.1
		isInventoryOption = CommonBean.isSiteSpecific(conn, "SM","INVENTORY" );//Added by Kamatchi S for MO-CRF-20171.1
		if (isDebugYN) System.out.println("isInventoryOption"+isInventoryOption);//Added by Kamatchi S for MO-CRF-20171.1

		DocumentConfigOption docConfigOption = new DocumentConfigOption(); 	

		List<DocumentConfigBean> oDocConfigList = null;
		//DocumentConfigBean sDocumentConfigBean = null;	

		List<DocumentTypeBean> oDocTypeList = null;   // Added by prithvi on 24/08/2015

		DocumentConfigBean oDocumentConfigBean = null;	
			
		oDocConfigList = new ArrayList<DocumentConfigBean>();
		//sDocumentConfigBean = new DocumentConfigBean();		

		oDocConfigList = docConfigOption.getDocumentConfigDetails(sFacilityId_df);
		if (isDebugYN) System.out.println("oDocConfigList..."+oDocConfigList);

		int nDocConfigListsize = oDocConfigList.size();
		
		//Added by Santhosh for GHL-CRF-0648
		isFinancialDocument = CommonBean.isSiteSpecific(conn, "SM","DOCUMENTATION_FIN");

		if (nDocConfigListsize>0)
		{						
			oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
			
			//sFacilityId 	= oDocumentConfigBean.getsFacilityId();
			iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
			if (isDebugYN) System.out.println("iDocScanEnabled......."+iDocScanEnabled);

			iDocScanUIEnabled = oDocumentConfigBean.getiDocScanUIEnabled();
			if (isDebugYN) System.out.println("iDocScanUIEnabled......."+iDocScanUIEnabled);

			iDocSaveAs = oDocumentConfigBean.getiDocSaveAs();  
			iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();
			iInvFolderOption = oDocumentConfigBean.getiInvFolderOption();//Added by Kamatchi S for MO-CRF-20171.1
			
			iPhotoFolderOption = oDocumentConfigBean.getsPhotoDocOption(); //Added by bhuvana 23/05/2019.
			
			if (isDebugYN) System.out.println("iPhotoFolderOption.."+iPhotoFolderOption);
			if (isDebugYN) System.out.println("sFacilityId.."+sFacilityId);
			if (isDebugYN) System.out.println("iDocFolderOption......."+iDocFolderOption);
			if (isDebugYN) System.out.println("iInvFolderOption......."+iInvFolderOption);//Added by kamatchi S MO-CRF-20171.1
			//iDocCheckStatus = oDocumentConfigBean.getiDocCheckStatus();
			oDocTypeList=oDocumentConfigBean.getiDocTypeList();          // Added by prithvi on 24/08/2015
		}	


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
          
if (isScanningOption) 
{ 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( iDocScanEnabled == 1 ? "checked" : "" ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( ((iDocScanUIEnabled == 1 && iDocScanEnabled == 1) ? "checked" : "") ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( iDocScanEnabled == 0 ? "disabled" : "" ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( iDocSaveAs == 0 ? "checked='checked'" : "" ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( iDocScanEnabled == 0 ? "disabled" : "" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( iDocSaveAs == 1 ? "checked='checked'" : "" ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( iDocScanEnabled == 0 ? "disabled" : "" ));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
} 

            _bw.write(_wl_block14Bytes, _wl_block14);
 
if (isDocumentOption) 
{ 

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( iDocFolderOption == 0 ? "checked='checked'" : "" ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( iDocFolderOption == 1 ? "checked='checked'" : "" ));
            _bw.write(_wl_block17Bytes, _wl_block17);
 
			 for(int i=0; i<oDocTypeList.size();i++)       // Added by prithvi on 24/08/2015
			 {
				System.out.println("Bhuvi: "+oDocTypeList.get(i).getsFileCategory()+".");
				if ("D".equals(oDocTypeList.get(i).getsFileCategory()) && !"GRN Documents".equals(oDocTypeList.get(i).getsDocumentName())) //Condition changed by kamatchi S for MO-CRF-20171.1
		{ 
		//Added by Santhosh for GHL-CRF-0648
			if(isFinancialDocument && "FN".equals(oDocTypeList.get(i).getsDocumentType())){
			}
			else {
 
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentType() ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentName() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( iDocFolderOption == 1 ? "style='visibility: visible;'" : "style='visibility: hidden;'" ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentSharedPath() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( iDocFolderOption == 1 ? "enabled" : "readonly " ));
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
		}
		
            _bw.write(_wl_block24Bytes, _wl_block24);
 
			}
			
            _bw.write(_wl_block25Bytes, _wl_block25);
 
}

            _bw.write(_wl_block14Bytes, _wl_block14);
 	
if (isPhotoOption) 
{ 

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( iPhotoFolderOption == 0 ? "checked='checked'" : "" ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( iPhotoFolderOption == 1 ? "checked='checked'" : "" ));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
		
			 for(int i=0; i<oDocTypeList.size();i++)       // Added by prithvi on 24/08/2015
			 {
				System.out.println("Bhuvi: "+oDocTypeList.get(i).getsFileCategory()+".");
				if ("P".equals(oDocTypeList.get(i).getsFileCategory())) 
		{ 
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentType() ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentName() ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( iPhotoFolderOption == 1 ? "style='visibility: visible;'" : "style='visibility: hidden;'" ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentSharedPath() ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( iPhotoFolderOption == 1 ? "enabled" : "readonly " ));
            _bw.write(_wl_block34Bytes, _wl_block34);
 
		 }
		
            _bw.write(_wl_block24Bytes, _wl_block24);
 
			 }
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block36Bytes, _wl_block36);
 
} 

            _bw.write(_wl_block37Bytes, _wl_block37);
 //Added by Kamatchi S for MO-CRF-20171.1
if(isInventoryOption) 
{ 

            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( iInvFolderOption == 0 ? "checked='checked'" : "" ));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( iInvFolderOption == 1 ? "checked='checked'" : "" ));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
 
			 for(int i=0; i<oDocTypeList.size();i++)       
			 {
				System.out.println("Bhuvi: "+oDocTypeList.get(i).getsFileCategory()+".");
				String DocType = "";
				String DocName = "";
				DocType = oDocTypeList.get(i).getsFileCategory();
				DocName = oDocTypeList.get(i).getsDocumentName();

				if (DocType.equals("D") && DocName.equals("GRN Documents"))
				{ 
					
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentType() ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oDocTypeList.get(i).getsDocumentName() ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( iInvFolderOption == 1 ? "style='visibility: visible;'" : "style='visibility: hidden;'" ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(oDocTypeList.get(i).getsInventorySharedPath()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iInvFolderOption == 1 ? "enabled" : "readonly " ));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
		 }
		
            _bw.write(_wl_block24Bytes, _wl_block24);
 
			 }
			
            _bw.write(_wl_block25Bytes, _wl_block25);
 
}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(isDocumentOption));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(isScanningOption));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(isPhotoOption));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(isInventoryOption));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sFacilityId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sFacilityId_df));
            _bw.write(_wl_block55Bytes, _wl_block55);

}catch(Exception e1)
			{
			 out.println("(DocMgmtConfig.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}

            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.InventoryDocOption.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.DocStorageOption.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.DataBaseExist.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.SharedPath.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
