package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.StringTokenizer;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmreturntomrdresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMReturnToMRDResult.jsp", 1737538436009L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMReturnToMRD.js\'></script>\n\t\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<body onMouseDown = \"CodeArrest();\" onKeyDown = \'lockKey();\'> \n\t\t<form name=\'FMReturnToMRDResultForm\' id=\'FMReturnToMRDResultForm\' action=\'FMReturnToMRDResult.jsp\' method=\'POST\'>\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t<table align=\'right\' ><tr>\n\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<!--\t<td align =\'right\' id=\'prev\'>\n\t\t\t\t<a href=\'javascript:submitPrev(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =", ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t\t\t<a href=\'javascript:submitNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t\t\t</td> --> \n\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\t\t</tr></table></p>\n\t\t\t<br><br>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" align=\"CENTER\">\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t<th width=\"30%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t<th width=\"8%\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t<th width=\"8%\"> ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t\t<th width=\"13%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t<th width=\"17%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<tr>\n\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><font size=\"1\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" align=\"CENTER\"><font size=\"1\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\t\n\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><font size=\"1\"><b>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</b><br>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font></td>\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" align=\"CENTER\"><font size=\"1\"><input type=\"checkbox\" name=\"confirm";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"confirm";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"confirmid";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\"markCheckedRecords(this);\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" ></font></td>\t\n\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t <script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\tparent.result_frame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\tparent.criteria_frame.document.forms[0].all_button.disabled = false;\n\t\t\t    parent.criteria_frame.document.forms[0].add_button.disabled= false;\n\t\t    parent.criteria_frame.document.forms[0].clear_button.disabled= false;\n\t\t\t\t//parent.criteria_frame.document.forms[0].patient_id.value = \'\';\n\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t <script>\n\t\t\t\t/*Below field namesare being sent dynamically to \"FMFileSearchComponentValues.jsp\"  in \"FMReturnToMRDCriteria.jsp\"*/\n\t\t\tparent.criteria_frame.document.forms[0].patient_id.value = \'\';\n\t\t\tparent.criteria_frame.document.forms[0].patient_id.onblur();\n\t\t\t\tparent.criteria_frame.document.forms[0].patient_id.focus();\n\t\t\tparent.criteria_frame.document.forms[0].blur();\n\t\t\tif (parent.criteria_frame.document.forms[0].file_type)\n\t\t\t\tparent.criteria_frame.document.forms[0].file_type.value = \'\';\n\t\t\tif (parent.criteria_frame.document.forms[0].volume_no)\n\t\t\t\tparent.criteria_frame.document.getElementById(\"volno\").innerHTML=\"<select name=volume_no ><option value=\'\'>---\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"---</select>\";\n\t\t\tif (parent.criteria_frame.document.forms[0].file_no) {\n\t\t\t\tparent.criteria_frame.document.getElementById(\"file_no\").value = \"\";\n\t\t\t}\n\t\t\t\t//parent.criteria_frame.document.forms[0].volume_no.value =\'\';\n\t\t\t/*var pat_id_name = parent.criteria_frame.document.forms[0].patientid_name.value;\n\t\t\tif (eval(\"parent.criteria_frame.document.forms[0].\"+pat_id_name))\n\t\t\t{\n\t\t\teval(\"parent.criteria_frame.document.forms[0].\"+pat_id_name).value = \"\";\n\t\t\teval(\"parent.criteria_frame.document.forms[0].\"+pat_id_name).blur();\n\t\t\t}*/\n\t\t\t</script> \n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<SCRIPT>\n//\tdocument.getElementById(\"next\").style.visibility=\'hidden\'\n\t\n\t</SCRIPT>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n<SCRIPT>\n\t//document.getElementById(\"next\").style.visibility=\'visible\'\n\t</SCRIPT>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<script>\n\t  parent.criteria_frame.document.forms[0].all_button.disabled =false;\n\t  parent.criteria_frame.document.forms[0].add_button.disabled=false;\n\t\tparent.criteria_frame.document.forms[0].clear_button.disabled=false;\n\t\t\n\t\t</script>\n\t\n\t<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"Hidden\" name=\"fs_location\" id=\"fs_location\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"Hidden\" name=\"fs_req_location\" id=\"fs_req_location\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"Hidden\" name=\"returning_code\" id=\"returning_code\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"Hidden\" name=\"date_time\" id=\"date_time\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"Hidden\" name=\"transport_mode\" id=\"transport_mode\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"Hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\"Hidden\" name=\"file_type_appl_yn\" id=\"file_type_appl_yn\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"Hidden\" name=\"file_no\" id=\"file_no\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"Hidden\" name=\"file_type\" id=\"file_type\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=\"Hidden\" name=\"volume_no\" id=\"volume_no\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"Hidden\" name=\"added_items\" id=\"added_items\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"Hidden\" name=\"added_patients\" id=\"added_patients\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"Hidden\" name=\"show_all_yn\" id=\"show_all_yn\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\"Hidden\" name=\"valid_records\" id=\"valid_records\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\"Hidden\" name=\"added_volumes\" id=\"added_volumes\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\"Hidden\" name=\"transport_mode_desc\" id=\"transport_mode_desc\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\"Hidden\" name=\"pageflag\" id=\"pageflag\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\"Hidden\" name=\"pagesClicked\" id=\"pagesClicked\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t    <input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n    \t<input type=hidden name=\'fromSelect\' id=\'fromSelect\' value=\'\'>\n\t</form>\n\t<script>\n\t\t/*\n\t\tparent.criteria_frame.document.forms[0].fs_location1.disabled = true;\n\t\tparent.criteria_frame.document.forms[0].fs_req_location.disabled = true;\n\t\tparent.criteria_frame.document.forms[0].returning_desc.disabled = true;\n\t\tparent.criteria_frame.document.forms[0].ret_button.disabled = true;\n\t\t*/\n\t\t//parent.criteria_frame.document.forms[0].all_button.disabled = true;\n\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t</script>\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t   <SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\tdocument.getElementById(\"confirmid\" + ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =").checked = true;\n\t\t\t\tdocument.getElementById(\"confirmid\" + ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =").onclick();\t  \n\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n</html>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            webbeans.eCommon.RecordSet FMreturnToMRDResult= null;synchronized(session){
                FMreturnToMRDResult=(webbeans.eCommon.RecordSet)pageContext.getAttribute("FMreturnToMRDResult",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMreturnToMRDResult==null){
                    FMreturnToMRDResult=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("FMreturnToMRDResult",FMreturnToMRDResult,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facility_id				=	"";
String patient_id				=	"";
String fs_location				=	"";
String fs_req_location			=	"";
String returning_code			=	"";
String date_time				=	"";
String transport_mode			=	"";
String transport_mode_desc		=	"";
String file_no					=	"";
String file_type				=	"";
String volume_no				=	"";
String from		 				=	"";
String to		 				=	"";
String added_items				=	"";
String added_patients			=	"";
String added_volumes			=	"";
String file_type_appl_yn		=	"N";
String show_all_yn				=	"Y";
String valid_records			=	"Y";
String class_value				=	"QRYEVEN";
String Iss_Date_Time			=	"";
//String identity                     ="";
String locn_identity             ="";
String	req_start			= ""; 
String  req_end			= "";
String flagSelect= "";
String  checkedOnes		= "";
//String patient_line="";
String selectvalue="";
String chkall="";
String check_attribute		=	"";
String p_stored_val="";
//String pagesClicked		=	"";
//int record_count				=	0;
int start						=	0 ;
int end							=	0 ;
int count						=	1 ;
int	i						= 1;
int	pagecount			= 0;
StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();
//StringBuffer queryBuffer	=	new StringBuffer();

try
{
	facility_id 		=	checkForNull((String) session.getValue("facility_id"));
	fs_location			=	checkForNull(request.getParameter("fs_location"));
	fs_req_location		=	checkForNull(request.getParameter("fs_req_location"));
	returning_code		=	checkForNull(request.getParameter("returning_code"));
	date_time			=	checkForNull(request.getParameter("date_time"));
	transport_mode		=	checkForNull(request.getParameter("transport_mode"));
	transport_mode_desc	=	checkForNull(request.getParameter("transport_mode_desc"));
	patient_id			=	checkForNull(request.getParameter("patient_id"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	file_no				=	checkForNull(request.getParameter("file_no"));
	file_type			=	checkForNull(request.getParameter("file_type"));
	volume_no			=	checkForNull(request.getParameter("volume_no"));
	from				=	checkForNull(request.getParameter("from"));
	to					=	checkForNull(request.getParameter("to"));
	added_items			=	checkForNull(request.getParameter("added_items"));
	
	added_patients		=	checkForNull(request.getParameter("added_patients"));
	added_volumes		=	checkForNull(request.getParameter("added_volumes"));
	valid_records		=	checkForNull(request.getParameter("valid_records"));
	show_all_yn			=	checkForNull(request.getParameter("show_all_yn"), "Y");
	flagSelect = checkForNull(request.getParameter("fromSelect"));
	p_stored_val=checkForNull(request.getParameter("p_stored_val"));
	String pageflag = checkForNull(request.getParameter("pageflag"));
	String pagesClicked = checkForNull(request.getParameter("pagesClicked"));
	String patientno_volume="";
	String pat_id="";
	String vol_no="";
	String sqlString="";
	String file_creat_fac_id="";
	String curr_fs_locn_identity="";
	int count_tokens=0; 
	boolean executeYN = true;

	//out.println("pagesClicked-->"+pagesClicked);
	//out.println("pageflag-->"+pageflag);

	if(!pagesClicked.equals("")) {
		StringTokenizer st = new StringTokenizer(pagesClicked,"#");
			while(st.hasMoreTokens()) {
				String element = st.nextToken();
				if(element.equals(pageflag))
					executeYN = false;
			}
	} 		

	if(from.equals(""))
		start = 1 ;			
	else 
		start = Integer.parseInt( from );	

	if(to.equals("")) 
		end = 10 ;
	else 
		end = Integer.parseInt( to ) ;

	if(pageflag.equals(""))
		pagecount=1;
	else
		pagecount=Integer.parseInt(pageflag);

	   req_start       =   checkForNull(request.getParameter("start"),"0");
       req_end         =   checkForNull(request.getParameter("end"),"0");
	
		if(!flagSelect.equals(""))
				FMreturnToMRDResult.clearAll();
		
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<= (Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("confirm"+(i)) != null)
					{
						checkedOnes = request.getParameter("confirm"+(i));
						
						if(!(FMreturnToMRDResult.containsObject(checkedOnes)))
							FMreturnToMRDResult.putObject(checkedOnes);

						j++;
					}
				}
		          
        }
		
	connection	= ConnectionManager.getConnection(request);	

	//sqlBuffer.append("SELECT file_no, file_type_code, file_type_desc, volume_no, patient_id, get_patient_line (patient_id) patient_line, to_char(iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time, curr_fs_locn_code, curr_fs_locn_short_desc, volume_no FROM fm_curr_locn_vw ");
    sqlString  =" SELECT facility_id,PERM_FS_LOCN_CODE fs_locn_code FROM fm_curr_locn WHERE  patient_id ='"+patient_id+"' and CURR_FILE_STATUS='I' and CURR_FS_LOCN_IDENTITY='D' and PERM_FS_LOCN_CODE <>CURR_FS_LOCN_CODE and  curr_facility_id='"+facility_id+"' " ;

//	sqlString = "SELECT FACILITY_ID  FROM mr_pat_file_index WHERE  patient_id ='"+patient_id+"' and doc_folder_id is null ";
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close(); 
	preStatement	=	connection.prepareStatement(sqlString);
	resultSet		=	preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
	{
		file_creat_fac_id= resultSet.getString("FACILITY_ID");
	}
	  if(preStatement!=null) preStatement.close();
	  if(resultSet!=null)	resultSet.close(); 
	  	
	 if(!file_creat_fac_id.equals(facility_id))
					{
	preStatement	=connection.prepareStatement(" SELECT curr_fs_locn_identity  FROM fm_curr_locn WHERE  patient_id ='"+patient_id+"' and facility_id='"+file_creat_fac_id+"' and curr_file_status='I' and curr_fs_locn_code='"+fs_req_location+"' ");
		
		resultSet = preStatement.executeQuery();
	
	if ((resultSet != null) && (resultSet.next()))
	{
			curr_fs_locn_identity = resultSet.getString("curr_fs_locn_identity");
           }
		   if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		if(curr_fs_locn_identity==null)	 curr_fs_locn_identity="";		
					
					}
		
	
		
		sqlBuffer.append("SELECT" );
		sqlBuffer.append("  File_No" );
		sqlBuffer.append("  , File_Type_Code" );
		sqlBuffer.append("  , mr_get_desc.MR_FILE_TYPE(FACILITY_ID,File_Type_Code,'"+localeName+"',2) file_type_desc" );
		sqlBuffer.append("  , Volume_No" );
		sqlBuffer.append("  , Patient_Id" );
	   sqlBuffer.append("  , Get_patient_line(Patient_Id,'"+localeName+"') Patient_Line" );
		sqlBuffer.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/rrrr hh24:mi') Iss_Date_Time" );
		sqlBuffer.append("  , Iss_Date_Time Iss_Date_Time1" );
		//sqlBuffer.append("  , Curr_fs_Locn_Code" );
		//sqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',2) curr_fs_locn_short_desc" );
		sqlBuffer.append("  , PERM_FS_LOCN_CODE" );
		sqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(FACILITY_ID,PERM_FS_LOCN_CODE,'"+localeName+"',2) curr_fs_locn_short_desc" );
	sqlBuffer.append(",(select locn_identity from fm_storage_locn where facility_id = fm_curr_locn.facility_id and fs_locn_code = fm_curr_locn.perm_fs_locn_code) locn_identity " );
		sqlBuffer.append("FROM" );
		sqlBuffer.append("  fm_Curr_Locn " );

	//queryBuffer.append("SELECT COUNT(*) record_count FROM fm_curr_locn_vw ");


	//whereBuffer.append(" WHERE curr_file_status = 'O' and doc_folder_id is  null AND facility_id = '");
whereBuffer.append(" where curr_fs_locn_code = '");
	whereBuffer.append(fs_req_location);
	whereBuffer.append("' "); 

if(!file_creat_fac_id.equals(facility_id) && curr_fs_locn_identity.equals("D"))
	{
	whereBuffer.append(" AND curr_file_status ='I' and doc_folder_id is  null AND facility_id = '");
	whereBuffer.append(file_creat_fac_id);
	whereBuffer.append("' ");
	}else{
   whereBuffer.append("  AND curr_file_status in('O','I') and  perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_facility_id = '");
	whereBuffer.append(facility_id); 
	whereBuffer.append("' ");
	}
	
	/*whereBuffer.append("' AND curr_fs_locn_code = '");
	whereBuffer.append(fs_req_location);
	whereBuffer.append("' ");*/

	if (!returning_code.equals(""))
	{
		whereBuffer.append(" AND CURR_LOCN_ID = '");
		whereBuffer.append(returning_code);
		whereBuffer.append("' ");
	}
	
	if (!show_all_yn.equals("Y"))
	{
		
		whereBuffer.append(" AND file_no IN (");
		whereBuffer.append(added_items);
		/*whereBuffer.append(") AND patient_id IN (");
		whereBuffer.append(added_patients);
		whereBuffer.append(") ");
		
		if (!volume_no.equals(""))
		{
			whereBuffer.append(" AND volume_no IN (");
			whereBuffer.append(added_volumes);
			whereBuffer.append(") ");
		} */
	StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	    count_tokens=pat_volumeno.countTokens();
	   int P_cnt=0;
	 whereBuffer.append( ") AND ( ");
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	vol_no	=fileno1.nextToken();
	}
	// SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 whereBuffer.append( " ( patient_id ='"+pat_id+"' ");
	 if (!vol_no.equals(""))
			{
		if(count_tokens >P_cnt){
   // SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
		whereBuffer.append(" AND volume_no ='"+vol_no+"' ) OR ");	
			} else{
              //   SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
		     	whereBuffer.append(" AND volume_no ='"+vol_no +"' ) ) ");	
			}
			
			}
		}	
		
	}
	whereBuffer.append(" order by Iss_Date_Time1 desc ,File_No asc,Volume_No asc ");
	//whereBuffer.append(" order by Iss_Date_Time1 desc");
	//preStatement	=	connection.prepareStatement(queryBuffer.toString());
	//resultSet		=	preStatement.executeQuery();
	
	//if ((resultSet != null) && (resultSet.next()))
	//	record_count = resultSet.getInt("record_count");


	sqlBuffer.append(whereBuffer.toString());
	
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close(); 
	
	preStatement	=	connection.prepareStatement(sqlBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	
            _bw.write(_wl_block8Bytes, _wl_block8);
// if ((!(start <= 1)) || (!( (start+3) > record_count ))) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
// if ( !(start <= 1) ) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start-10));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end-10));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
// } //if ( !( (start+3) > record_count ) ) { 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end+10));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 //} 
            _bw.write(_wl_block16Bytes, _wl_block16);

		//}
		int cnt = 0;
		int rowcount= 0;
		if (resultSet != null)
		{
		 
		
            _bw.write(_wl_block17Bytes, _wl_block17);
 if (file_type_appl_yn.equals("Y")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 } else if (file_type_appl_yn.equals("N")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

			int strCount				=	0;
			//int inc						=	0;
			String confirm_values		=	"";
			StringTokenizer strToken	=	null;
		//	if ( start != 1 )
		//		for( int j=1; j<start; count++,j++ )
			//		resultSet.next() ;
			//int i=0;
			//while (resultSet.next() && count<=end)
			while (resultSet.next())
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
				check_attribute = "";
				strToken	=	new StringTokenizer(valid_records, ",");
				strCount	=	strToken.countTokens();
				confirm_values	=	checkForNull(resultSet.getString("file_no"));
				 locn_identity = 			(resultSet.getString("locn_identity")==null)?"&nbsp":resultSet.getString("locn_identity");
				
		if(!locn_identity.equals(""))
		{
			switch(locn_identity.charAt(0))
			{
				case 'D' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' :locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
				confirm_values	=confirm_values +  "||" + checkForNull(resultSet.getString("volume_no"));
			/*	for (inc=0; inc<strCount; inc++)
				{
					if (strToken.hasMoreTokens())
						if ((checkForNull(strToken.nextToken())).equals(confirm_values))
							check_attribute = "Checked";
			} */
			// selectvalue	= deficiency_code;
		 selectvalue=confirm_values;
				if(FMreturnToMRDResult.containsObject(selectvalue)) 
				{
					check_attribute = "CHECKED";
					chkall	= "CHECKED";
					//out.println("If");
				}
				else
				{
					check_attribute="";
					chkall	= "";
					//out.println("Else");
				}
			int recordIndex = FMreturnToMRDResult.indexOfObject(selectvalue);  			

			if(recordIndex!=-1)
				    if(check_attribute.equals("CHECKED"))   
					FMreturnToMRDResult.removeObject(recordIndex); 
			
			
			
			
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(file_type_appl_yn.equals("Y")) { 
			
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(resultSet.getString("patient_line"), "&nbsp;").substring(0,resultSet.getString("patient_line").length()-6)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((resultSet.getString("file_type_desc")==null?"":(resultSet.getString("file_type_desc")+" / "))));
            out.print( String.valueOf(checkForNull(resultSet.getString("volume_no"), "&nbsp;")));
            _bw.write(_wl_block31Bytes, _wl_block31);
 } else if (file_type_appl_yn.equals("N")) { 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_no"), "&nbsp;")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkForNull(resultSet.getString("patient_line"), "&nbsp;").substring(0,resultSet.getString("patient_line").length()-6)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(checkForNull(resultSet.getString("volume_no"), "&nbsp;")));
            _bw.write(_wl_block31Bytes, _wl_block31);
 } 
            _bw.write(_wl_block34Bytes, _wl_block34);

				Iss_Date_Time=checkForNull(resultSet.getString("iss_date_time"), "&nbsp;");
				if(!Iss_Date_Time.equals("&nbsp;"))
				{
					Iss_Date_Time=DateUtils.convertDate(Iss_Date_Time,"DMYHM","en",localeName);
				}

				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Iss_Date_Time));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(resultSet.getString("curr_fs_locn_short_desc")+ "(" + locn_identity +")", "&nbsp;")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(selectvalue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(check_attribute));
            _bw.write(_wl_block42Bytes, _wl_block42);

				count++;
				cnt++;
			}
			rowcount=resultSet.getRow();
		}
		
		if(cnt == 0)
		{
			
            _bw.write(_wl_block43Bytes, _wl_block43);
 
		}
		else
		{ 
            _bw.write(_wl_block44Bytes, _wl_block44);
	}
		//	if(rowcount<10){
	
            _bw.write(_wl_block45Bytes, _wl_block45);
//} else {
            _bw.write(_wl_block46Bytes, _wl_block46);
//}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(from));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(to));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fs_location));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(fs_req_location));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(returning_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(date_time));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(transport_mode));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(file_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(added_items));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(added_patients));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(show_all_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(valid_records));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(added_volumes));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(transport_mode_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(pagecount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pagesClicked));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(start));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(end));
            _bw.write(_wl_block69Bytes, _wl_block69);

	if((sqlBuffer != null) && (sqlBuffer.length() >0))
	{
		sqlBuffer.delete(0,sqlBuffer.length());
	}
	if((whereBuffer != null) && (whereBuffer.length() >0))
	{
		whereBuffer.delete(0,whereBuffer.length());
	}
	
	int cnt2=start + cnt;
//	if(!flagSelect.equals("") || chkall.equals("CHECKED"))
	
	//{
	if(executeYN == true) {
		for(int cnt1=start;cnt1<cnt2;cnt1++)
		{
            _bw.write(_wl_block70Bytes, _wl_block70);
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( cnt1 ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( cnt1 ));
            _bw.write(_wl_block73Bytes, _wl_block73);

		}
	}
	//}
if(preStatement!=null) preStatement.close();
if(resultSet!=null)	resultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
   session.setAttribute("FMreturnToMRDResult", FMreturnToMRDResult);
}

            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileTypeVolumeNo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileNoPatientDetails.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.issueddate.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.IssuedFSLocation.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ConfirmReturn.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
