package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmrequestselectedfiles extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMRequestSelectedFiles.jsp", 1733927839657L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 6/15/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Request of File\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMRequestFile.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\'>\n<FORM name = \'fm_select_form\' action=\'../../servlet/eFM.FMParameterServlet\' method=\'get\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'left\' id=\"srch_result\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>parent.frames[3].document.getElementById(\"hdr_tab\").style.visibility=\'Visible\';</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<TR>\n\t\t\t<Td colspan = \'8\' class=\'columnheader\'><b><h5><font size=1>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></Td>\n\t\t</TR>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<TR>\n\t\t\t<Td colspan = \'8\' class=\'COLUMNHEADER\'><b><h5><font size=1>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t<tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<td width=\"25%\" class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ><font size=1><b>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b><br><input type=hidden name=p_file_no";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="`";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">&nbsp;&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</font></td>\n\t<td width=\"12%\" align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"><font size=1>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<input type=\'hidden\' name=\"file_type";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"file_type";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"><input type=\'hidden\' name=\"p_volume_no";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"p_volume_no";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><input type=\'hidden\' name=\"p_patient_id";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"p_patient_id";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></font></td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n<td width=\"25%\" class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"ParamID\"><font size=1><input type=hidden name=p_file_no";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</font></td><td width=\'8%\' align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"><font size=1><a href=\"javascript:GetRemarks(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</a></font></td><td width=\"13%\" align=\"left\" class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><font size=1><input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" value=\"\">\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t</font></td><td width=\'8%\' align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t</font></td><td width=\"8%\"  class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"><font size=1>&nbsp;&nbsp;</font></td><td width=\"13%\"  class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t \n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</font></td><td width=\'13%\'  class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"><font size=1>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" <br> &nbsp;&nbsp;(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =")\n\t</font></td>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"><input type=\'text\' id=\'fileReqdOn";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' name=\'p_file_required_on";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' maxlength=\'16\' size=\'12\'  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" onblur=\'checkDateAlert(document.forms[0].serverDate,this)\'><img  ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" src=\'../../eCommon/images/CommonCalendar.gif\' id=\'imgFileReqd";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' onClick=\"return showCalendar(\'fileReqdOn";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\', \'DMYHM\', null,true);\"/></td>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\',\'DMYHM\', null,true);\"/></td>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t<td width=\'9%\'  class=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" <br>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t</font></td><td width=\'8%\' align=\"center\" style=\"background-color:";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><font size=1>\n\t<input type=checkbox name=req_select";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" value=\"Y\">\n\t</font></td></tr>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n</TABLE>\n<script>\n\t\n\t//////////////////////////////////////////////////////////////////////////////////\n\n\tparent.frames[3].document.forms[0].p_patient_id.value = \"\";\nparent.frames[3].document.forms[0].p_patient_id.focus();\n\tif(\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" == \"N\")\n\t{\n\t\tparent.frames[3].document.getElementById(\"FileNo\").innerHTML = \"<input type=\'Text\' name=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' value=\'\' onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\'ChangeUpperCase(this);getPatIDVolume(this.value);";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' maxLength=\'20\' size=\'20\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t}\n\telse if(\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" == \"Y\")\n\t{\n\t\tparent.frames[3].document.getElementById(\"FileType\").innerHTML = \"<input type=\'Text\' name=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' value=\'\' onBlur=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t}\n\t\n\tvar selectBox   =\t\t\t\t\t\n\teval(";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =".document.";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =".";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =");\n\tvar seletLen\t=\tMath.abs(selectBox.length);\n\tfor (i=0; i<seletLen; i++)\n\t{\n\t\tselectBox.remove(0);\n\t}\n\n\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =").document.createElement(\"OPTION\");\t\t\n\tselectOption.value\t=\t\"\";\n\tselectOption.text\t=\t\"-\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-\";\n\tselectBox.add(selectOption);\n\t\t\t\n\t//////////////////////////////////////////////////////////////////////////////////\n\t\t\t\n\tparent.frames[3].document.forms[0].p_deselect_values.value = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\tparent.frames[1].document.forms[0].perm_fs_locn_code.value= \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\tvar old_value = parent.frames[3].document.forms[0].added_values.value;\n\tif (old_value != \"\")\n\t\told_value += \"|\"+\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\telse old_value = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\tparent.frames[3].document.forms[0].added_values.value=old_value;\n\tparent.frames[3].document.forms[0].p_select_values.value = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\tparent.frames[3].document.forms[0].p_total_records.value = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\n\tvar p_in_files\t\t= parent.frames[3].document.forms[0].p_select_values.value;\n\tvar p_not_files\t= parent.frames[3].document.forms[0].p_deselect_values.value;\n\n\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form2\' id=\'form2\' method=\'post\' action=\'../../eFM/jsp/FMRequestDeSelectedFiles.jsp\'><input name=\'p_new_string\' id=\'p_new_string\' type=\'hidden\' value=\"+p_in_files+\"><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_not_files+\"></form></BODY></HTML>\";\n\n\n\tparent.frames[3].document.forms[0].p_total_select.value = \'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\';\n\tfor (i=0;i<7;i++)\n\t{\n\t\tif ((document.getElementById(\"srch_result\").rows[i+1] != null) && (document.getElementById(\"srch_result\").rows[i+1].cells[i] != null))\n\t\t{\n\t\t\tparent.frames[3].document.getElementById(\"hdr_tab\").rows[0].cells[i].width = document.getElementById(\"srch_result\").rows[i+1].cells[i].width; \n\t\t}\n\t}\n\t\n</script>\n<input type=\'hidden\' name=p_select_values value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=p_total_select value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=serverDate value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\n</FORM>\n</BODY>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//	String p_facility_id	= (String) session.getValue( "facility_id" ) ;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con				= null;
	java.sql.Statement stmt		= null;	
	ResultSet rs				= null;	
try
{
	con	= ConnectionManager.getConnection(request);
	stmt						= con.createStatement();
	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();
	String p_stored_val			= request.getParameter("p_select_files");
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String p_enter_fcy			= request.getParameter("p_enter_fcy");
	String p_req_fs_locn		= request.getParameter("p_req_fs_locn");
//	String conc_remarks		 	=request.getParameter("conc_remarks").trim();
    String perm_fs_locn_code="";
	//String facility_id 			= (String) session.getValue("facility_id");

	String conc_remarks		 	=(String)session.getAttribute("conc_remarks");
	session.removeAttribute("conc_remarks");
	String added_volumes	 	= request.getParameter("added_volumes");
	String file_type_appl_yn 	= request.getParameter("file_type_appl_yn");

	String fileno_name			= checkForNull(request.getParameter("fileno_name"));
	String filetype_name		= checkForNull(request.getParameter("filetype_name"));
	String file_no_function		= checkForNull(request.getParameter("file_no_function"));
	String file_type_function	= checkForNull(request.getParameter("file_type_function"));
	String frame_name			= checkForNull(request.getParameter("frame_name"));
	String form_name			= checkForNull(request.getParameter("form_name"));
	String volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
	ArrayList arrList = new ArrayList();
	if(added_volumes==null)  added_volumes = "";
	if(file_type_appl_yn==null)  added_volumes = "N";
    String filenum="";
	String volumenum="";
	String fileno_volume="";
	String serverDateTime="";

	//conc_remarks = java.net.URLDecoder.decode(conc_remarks,"UTF-8");

	added_volumes = java.net.URLDecoder.decode(added_volumes);

	if (!(conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null")  )) {
		StringTokenizer st = new StringTokenizer(conc_remarks, "~");
		
		while(st.hasMoreTokens()) {
			StringTokenizer recSt = new StringTokenizer(st.nextToken(), "`");
			while(recSt.hasMoreTokens()) {
			arrList.add(recSt.nextToken());
		}
			}
	}

	String p_select_values		= "";
	String p_added_values		= "";
	//String p_concat_string		= "";
	String p_files_not_in		= "";
	int p_count = 0;	
    int count_tokens=0;
	if (p_not_in_files==null) p_not_in_files="";
	if (p_include_in_select==null) p_include_in_select="";
	if (p_req_fs_locn==null) p_req_fs_locn="";

	/*StringTokenizer token=new StringTokenizer(p_stored_val,"|");
	while(token.hasMoreTokens())
		{
				if (p_count ==0 )
				{
					p_concat_string     = "'" + token.nextToken() +"'";
				}
				else
				{
					p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
				}
				p_count++;
		}		*/	
	//	p_count=0;

	if (!p_not_in_files.equals(""))
	{
		StringTokenizer token1=new StringTokenizer(p_not_in_files,"|");
		String getTokenValue="";

		while(token1.hasMoreTokens())
			{
				getTokenValue = token1.nextToken();

					if (p_count ==0 )
					{
						p_files_not_in     = "'" + getTokenValue +"'";
					}
					else
					{
						p_files_not_in     = p_files_not_in + ",'" + getTokenValue +"'";
					}
					p_count++;
			}
	}

		//SelectSqlBuffer.append(" select file_no,facility_id,patient_id,get_patient_line(patient_id)patient_line,fs_locn_short_desc, decode(curr_file_status,'I','Inside','O','Outside','L','Lost','T','In Transit','A','Archived','E','Other Facility', 'R', 'Returned')curr_file_status,(case when curr_fs_locn_code = '"+p_req_fs_locn+"' then 'X' else curr_file_status end)curr_file_status1, curr_fs_locn_short_desc, decode(curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, (CASE WHEN curr_fs_locn_code = '"+p_req_fs_locn+"' THEN  6 ELSE  DECODE(curr_file_status,'I',1,'O',1,'L',4,'T',2,'A',5,'E',3) END)order_by_status,(case when curr_facility_id <> '"+p_enter_fcy+"' then '(' || curr_facility_name || ')' else '&nbsp;' end)other_facility_name, volume_no, file_type_code, file_type_desc, to_char(sysdate,'dd/mm/yyyy') serverDate from fm_curr_locn_vw where file_no in("+p_concat_string+") ");
		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  File_No" );
		SelectSqlBuffer.append("  , Facility_Id" );
		SelectSqlBuffer.append("  , Patient_Id" );
		SelectSqlBuffer.append("  , Get_patient_line(Patient_Id,'"+localeName+"') Patient_Line" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+p_enter_fcy+"',perm_fs_locn_code,'"+localeName+"',2) fs_Locn_Short_desc" );
		SelectSqlBuffer.append("  , Curr_File_Status Curr_File_Status,perm_fs_locn_code" );
		SelectSqlBuffer.append("  , (" );
		SelectSqlBuffer.append("  CASE " );
		SelectSqlBuffer.append("  WHEN Curr_fs_Locn_Code = '"+p_req_fs_locn+"' " );
		SelectSqlBuffer.append("  THEN" );
		SelectSqlBuffer.append("    'X' " );
		SelectSqlBuffer.append("  ELSE Curr_File_Status " );
		SelectSqlBuffer.append("  END) Curr_File_Status1" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(Curr_Facility_Id,Curr_fs_Locn_Code,'"+localeName+"',2) Curr_fs_Locn_Short_desc" );
		SelectSqlBuffer.append("  , Curr_fs_Locn_Identity Curr_fs_Locn_Identity" );
		SelectSqlBuffer.append("  , (" );
		SelectSqlBuffer.append("  CASE " );
		SelectSqlBuffer.append("  WHEN Curr_fs_Locn_Code = '"+p_req_fs_locn+"' " );
		SelectSqlBuffer.append("  THEN" );
		SelectSqlBuffer.append("    6 " );
		SelectSqlBuffer.append("  ELSE Decode(Curr_File_Status,'I',1, 'O',1, 'L',4, 'T',2, 'A',5, 'E',3) " );
		SelectSqlBuffer.append("  END) Order_By_Status" );
		SelectSqlBuffer.append("  , (" );
		SelectSqlBuffer.append("  CASE " );
		SelectSqlBuffer.append("  WHEN Curr_Facility_Id <> '"+p_enter_fcy+"' " );
		SelectSqlBuffer.append("  THEN" );
		SelectSqlBuffer.append("    '(' ||(sm_Get_desc.SM_FACILITY_PARAM(Curr_FACILITY_ID,'"+localeName+"',1)) ||')' " );
		SelectSqlBuffer.append("  ELSE '&nbsp;' " );
		SelectSqlBuffer.append("  END) Other_Facility_Name" );
		SelectSqlBuffer.append("  , Volume_No" );
		SelectSqlBuffer.append("  , File_Type_Code" );
		SelectSqlBuffer.append("  , mr_get_desc.MR_FILE_TYPE('"+p_enter_fcy+"',File_Type_Code,'"+localeName+"',2) File_Type_desc " );
		SelectSqlBuffer.append("  , TO_CHAR(sysdate,'dd/mm/yyyy HH24:mi') serverDate,TO_CHAR(sysdate,'dd/mm/yyyy HH24:mi') serverDateTime " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  fm_Curr_Locn " );
		SelectSqlBuffer.append("WHERE Facility_Id ='"+p_enter_fcy+"' AND ( " );
		//SelectSqlBuffer.append("  AND File_No IN ("+p_concat_string+")");
	 //if (!added_volumes.equals(""))
	// SelectSqlBuffer.append( " AND volume_no in ("+added_volumes+")");
	  StringTokenizer fileno=new StringTokenizer(p_stored_val,"|");  
	  count_tokens=fileno.countTokens();
	   int P_cnt=0;
	  while(fileno.hasMoreTokens())
		{
	    P_cnt++;
	   fileno_volume    =fileno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(fileno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	filenum     =fileno1.nextToken() ;	
	volumenum	=fileno1.nextToken() ;
	}
	 SelectSqlBuffer.append("   ( File_No ='"+filenum+"' ");
	 if (!volumenum.equals(""))
			{
		if(count_tokens >P_cnt){
    SelectSqlBuffer.append( " AND volume_no ='"+volumenum+"' ) OR ");
			} else{
                  SelectSqlBuffer.append( " AND volume_no ='"+volumenum+"' )  ");
			}
			
			}
		}		
	// SelectSqlBuffer.append( " ) and curr_facility_id='"+p_enter_fcy+"' order by order_by_status,file_no ");
	 SelectSqlBuffer.append( " )  order by order_by_status,file_no,volume_no ");
	 rs = stmt.executeQuery(SelectSqlBuffer.toString());

		

            _bw.write(_wl_block8Bytes, _wl_block8);

int i = 1;
int p_rec_cnt = 0;
String classValue="";
String bgcolor="";
String p_allow_select="";
String p_checked="";
String serverDate="";
int p_request_cnt=0;
int p_not_request_cnt=0;


            _bw.write(_wl_block9Bytes, _wl_block9);

while ( rs.next() )
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	if ( i == 1 )
		serverDate =rs.getString("serverDate");
		serverDateTime =rs.getString("serverDateTime");
		serverDateTime=DateUtils.convertDate(serverDateTime,"DMYHM","en",localeName);
perm_fs_locn_code=rs.getString("perm_fs_locn_code");
	if(perm_fs_locn_code==null) perm_fs_locn_code="";
	if (rs.getString("curr_file_status1").equals("A"))
	{
		bgcolor			= "FFEECC";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T"))
	{
		bgcolor = "CCEEDD";
		p_allow_select	= "";
		p_checked		= "checked";

	}
	else if (rs.getString("curr_file_status1").equals("L"))
	{
		bgcolor = "FFFFEE";
		p_allow_select	= "disabled";
		p_checked		= "";

	}
	else if (rs.getString("curr_file_status1").equals("X"))
	{
		bgcolor = "ADD8E6";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("E"))
	{
		bgcolor = "E0FFFF";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else if (rs.getString("curr_file_status1").equals("O"))
	{
		bgcolor = "#D1BBA7";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else if (rs.getString("curr_file_status1").equals("R"))
	{
		bgcolor = "#C0C0C0";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else
	{
		bgcolor = "";
		p_allow_select	= "";
		p_checked		= "checked";
	}

	String curr_file_status = checkForNull(rs.getString("Curr_File_Status"));
		if(!curr_file_status.equals(""))
		{
			switch(curr_file_status.charAt(0))
			{
				case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

				case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

				case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

				case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

				case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

				case 'E' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;

				case 'R' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;
			}
		}

		String curr_fs_locn_ident_desc = checkForNull(rs.getString("Curr_fs_Locn_Identity"));
		if(!curr_fs_locn_ident_desc.equals(""))
		{
			switch(curr_fs_locn_ident_desc.charAt(0))
			{
				case 'D' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); 
					break;
				case 'T' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); 
					break;
				case 'C' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;
				case 'N' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;
				case 'X' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;
				case 'E' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;
				case 'Y' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
				default : curr_fs_locn_ident_desc = "";
			}
		}

	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O") || rs.getString("curr_file_status1").equals("T"))
	{
		if (p_request_cnt==0)
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
		}
		p_request_cnt++;

	}

	if (rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A"))
	{
		if (p_not_request_cnt==0)
		{
			if (p_request_cnt>0)
			{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			else
			{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}

		p_not_request_cnt++;
	}


            _bw.write(_wl_block13Bytes, _wl_block13);

	if (file_type_appl_yn.equals("N"))
	{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("facility_id") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( (rs.getString("volume_no")==null)?"&nbsp;":rs.getString("volume_no")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( rs.getString("file_type_code")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("volume_no")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block29Bytes, _wl_block29);

	}else if (file_type_appl_yn.equals("Y"))
	{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("facility_id") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( (rs.getString("file_type_desc")==null)?"&nbsp;":(rs.getString("file_type_desc")+" / ")));
            out.print( String.valueOf( (rs.getString("volume_no")==null)?"&nbsp;":rs.getString("volume_no")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( rs.getString("file_type_code")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("volume_no")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block29Bytes, _wl_block29);

	}
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("T") ||rs.getString("curr_file_status1").equals("O")) {
		if (conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null") || conc_remarks.equals("") ) {

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
		else {
			String tempstr  = "";
			int ind = arrList.indexOf(rs.getString("file_no")+rs.getString("volume_no"));
			if (ind != -1)
			tempstr = (String)arrList.get(ind+1);
			if (tempstr == null || tempstr.equals("#")) tempstr = "";

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tempstr));
            _bw.write(_wl_block40Bytes, _wl_block40);

		}
	}
	else {

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);

	}


            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( rs.getString("fs_locn_short_desc") ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( rs.getString("curr_fs_locn_short_desc")==null?"":rs.getString("curr_fs_locn_short_desc") ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( curr_fs_locn_ident_desc ));
            _bw.write(_wl_block47Bytes, _wl_block47);

if (conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null") || conc_remarks.equals("") ) {


            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(serverDateTime));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( p_allow_select ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( p_allow_select ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block56Bytes, _wl_block56);

		}
	else {
		String tempstr  = "";
			int ind = arrList.indexOf(rs.getString("file_no")+rs.getString("volume_no"));
			if (ind != -1)
			{
					tempstr = (String)arrList.get(ind+2);
			 	
			}
			if (tempstr == null || tempstr.equals("#")) 
			{
				
				tempstr = "";
			}
if(tempstr.equals("") && ind == -1)
		{
        tempstr=serverDateTime;
		}


            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tempstr));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( p_allow_select ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( p_allow_select ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block57Bytes, _wl_block57);

	}

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( curr_file_status));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( rs.getString("other_facility_name") ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( bgcolor ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( p_checked ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( p_allow_select ));
            _bw.write(_wl_block64Bytes, _wl_block64);

	if (p_select_values=="")
	{
		p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	else
	{
		p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	if (p_added_values=="")
	{
		p_added_values = rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	else
	{
		p_added_values = p_added_values + '|' + rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	i++;
	p_rec_cnt++;
  } //endwhile



            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(p_not_in_files));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(perm_fs_locn_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(p_added_values));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(p_added_values));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(p_stored_val));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(p_select_values));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(serverDate));
            _bw.write(_wl_block86Bytes, _wl_block86);

	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block87Bytes, _wl_block87);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.RequestedFiles.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Filescannotberequested.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Filescannotberequested.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EnterRemarks.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EnterRemarks.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
