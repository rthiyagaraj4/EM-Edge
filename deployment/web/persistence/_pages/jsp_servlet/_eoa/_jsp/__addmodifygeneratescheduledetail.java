package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifygeneratescheduledetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/addmodifyGenerateScheduleDetail.jsp", 1729082978973L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eOA/js/GenerateSchedule.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/\nfunction checkAll(){\nvar len=document.GenerateScheduleDetail_form.nochkbox.value;\n\t if(document.GenerateScheduleDetail_form.selected_chk.checked){\t \t\n\t for(var k=0; k<len; k++){  \n\t eval(\'document.GenerateScheduleDetail_form.selected_\'+k).checked=true;\t\n\t eval(\'document.GenerateScheduleDetail_form.selected_\'+k).value=\"Y\";\t \n\t}\n }else{  \n\tfor(var k=0; k<len; k++){ \n\t  eval(\'document.GenerateScheduleDetail_form.selected_\'+k).checked=false;\n      eval(\'document.GenerateScheduleDetail_form.selected_\'+k).value=\"N\";         \n\t} \n  }\n  document.GenerateScheduleDetail_form.nochkbox.value=len;\n}\n\nfunction checkSinglechk(){\n var singchklen=document.GenerateScheduleDetail_form.selected_chk.value;\nfor(var m=0; m<singchklen; m++){\n\tif(eval(\'document.GenerateScheduleDetail_form.selected_\'+m).checked){ \n       eval(\'document.GenerateScheduleDetail_form.selected_\'+m).checked=true;\t\n\t   eval(\'document.GenerateScheduleDetail_form.selected_\'+m).value=\"Y\";\n    }else{ \n\t   eval(\'document.GenerateScheduleDetail_form.selected_\'+m).checked=false;\n       eval(\'document.GenerateScheduleDetail_form.selected_\'+m).value=\"N\";\n\t   if(document.GenerateScheduleDetail_form.selected_chk.checked){\t  \n\t   document.GenerateScheduleDetail_form.selected_chk.checked=false;\n\t   }\t   \n    }\t \n  }\t\n}\n/*End for this CRF[CRF AMRI-CRF-0236]*/\n</script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t<form name=\'GenerateScheduleDetail_form\' id=\'GenerateScheduleDetail_form\'  method=\'post\' target=\'messageFrame\'>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'80%\'>\n\t<td colspan=\'4\'  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t<tr>\n\t\t<td  width=\'13%\' class=\'CAGROUPHEADING\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td  width=\'29%\' class=\'CAGROUPHEADING\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td  width=\'47%\' class=\'CAGROUPHEADING\' align=\'center\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<td width=\'10%\' align=\'center\' class=\'CAGROUPHEADING\'> \n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\n\t\n\t\t\n\t\t<input type=\'checkbox\' name=\'selected_chk\' id=\'selected_chk\'  onclick =\'checkAll()\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'selected_chk1\' id=\'selected_chk1\' id=\'selected_chk1\'>\n\t\t<input type=\'hidden\' name=\'selected_chk2\' id=\'selected_chk2\' id=\'selected_chk2\'>\n\t\t<input type=\'hidden\' name=\'selected_chk3\' id=\'selected_chk3\' id=\'selected_chk3\'>\n\t\t<input type=\'hidden\' name=\'selected_chk4\' id=\'selected_chk4\' id=\'selected_chk4\'>\n\t\t<input type=\'hidden\' name=\'selected_chk5\' id=\'selected_chk5\' id=\'selected_chk5\'>\n\t\t<input type=\'hidden\' name=\'selected_chk6\' id=\'selected_chk6\' id=\'selected_chk6\'>\n\t\t<input type=\'hidden\' name=\'selected_chk7\' id=\'selected_chk7\' id=\'selected_chk7\'>\n\t\t<input type=\'hidden\' name=\'selected_chk8\' id=\'selected_chk8\' id=\'selected_chk8\'>\n\t\t\t\n\t\t</td>\n\t\t</tr>\n\t\n\t</table>\n\t\n\t\t<!--<div  style=\"position:relative;height:400px;overflow:auto\"> -->\n\t\t<div  style=\"position:relative;height:380px;vertical-align:top;overflow:auto\"> \n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'80%\'>\n\t\t\n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr>\t\t\n\t\t<td colspan=\'3\' width=\'43%\'>&nbsp;</td>\t\t\n\t\t<td width=\'47%\' align=\'center\'>\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'width=\'90%\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'14%\' class=\'labelcenter\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\'14%\' class=\'labelcenter\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t<td width=\'14%\' class=\'labelcenter\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\n\t\t<td width=\'10%\' align=\'center\' class=\'CAGROUPHEADING\'>&nbsp;</td>\n\t\t</tr>\n     ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t\t<tr align=\'left\' >\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\t\n\t\t\t\t\t\t<td width=\'3%\' class=\'labelleft\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t<td width=\'10%\' class=\'labelleft\'  nowrap >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </td>\n\t\t\t\t\t\t<td width=\'29%\' class=\'labelleft\' nowrap >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'practitioner_id_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'practitioner_id_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<td width=\'47%\'align=\'center\'>\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'width=\'90%\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'day_1\' id=\'day_1\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'day_2\' id=\'day_2\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="></td>\n\n\t\t\t\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'day_3\' id=\'day_3\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="></td>\n\n\t\t\t\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'day_4\' id=\'day_4\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="></td>\n\n\t\t\t\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'day_5\' id=\'day_5\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="></td>\n\n\t\t\t\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'day_6\' id=\'day_6\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="></td>\n\n\t\t\t\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'day_7\' id=\'day_7\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="></td>\n\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t<td width=\'7%\' align=\'center\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'selected_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'selected_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  value=\'Y\' onclick=\"checkSinglechk()\" checked> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<!-- Below lin changed @ UAT-3 by Sudhakar-->\n\t\t\t\t <td width=\'3%\'  class=\'labelleft\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td><td width=\'10%\'  class=\'labelleft\' nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td><td width=\'29%\'  class=\'labelleft\' nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</font>\n\t\t\t\t<input type=\'hidden\' name=\'practitioner_id_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'></td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t\t\t<td width=\'47%\'align=\'center\'>\n\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'90%\'>\n\t\t\t\t<tr>\n\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t<input type=\'checkbox\' name=\'day_1\' id=\'day_1\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="></td>\n\t\t\t\t\n\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t<input type=\'checkbox\' name=\'day_2\' id=\'day_2\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="></td>\n\n\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t<input type=\'checkbox\' name=\'day_3\' id=\'day_3\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\n\n\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t<input type=\'checkbox\' name=\'day_4\' id=\'day_4\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="></td>\n\n\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t<input type=\'checkbox\' name=\'day_5\' id=\'day_5\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="></td>\n\n\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t<input type=\'checkbox\' name=\'day_6\' id=\'day_6\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="></td>\n\n\t\t\t\t<td width=\'14%\' align=\'center\'>\n\t\t\t\t<input type=\'checkbox\' name=\'day_7\' id=\'day_7\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="></td>\n\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\n\t\t\t\t<td width=\'7%\' align=\'center\'>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<input type=\'checkbox\' name=\'selected_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'  value=\'Y\' onclick=\"checkSinglechk()\" checked>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t<input type=\'hidden\' name=\'nochkbox\' id=\'nochkbox\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n</table>\n</form>\n</body>\n<script>\n/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/\n  document.GenerateScheduleDetail_form.selected_chk.value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\';\n  document.GenerateScheduleDetail_form.selected_chk.checked=true;\t\n //End CRF[CRF AMRI-CRF-0236]\n</script>\n</html>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rset=null ;
//Statement stmt1=null;
//ResultSet rset1=null ;

String wd1 = checkForNull(request.getParameter("wd1"));
String wd2 = checkForNull(request.getParameter("wd2"));
String wd3 = checkForNull(request.getParameter("wd3"));
String wd4 = checkForNull(request.getParameter("wd4"));
String wd5 = checkForNull(request.getParameter("wd5"));
String wd6 = checkForNull(request.getParameter("wd6"));
String wd7 = checkForNull(request.getParameter("wd7"));

String from_date = checkForNull(request.getParameter("from_date"));
String to_date = checkForNull(request.getParameter("to_date"));

//String locationType=request.getParameter("locationType");

String facilityId = (String) session.getValue( "facility_id" ) ;


String da[]  = new String[7];

String cliniccode = checkForNull(request.getParameter("clinic_code"));
String days = checkForNull(request.getParameter("days"));
int i= 0;
StringTokenizer str 	= new StringTokenizer(days,"|");

while(str.hasMoreTokens()){
	da[i] = str.nextToken();
	i++;
}

String ID="";
String dayofweek="";
//int last;
String pre_pract="";
String pre_resource="";
String cur_pract="";
//int first=1;
String day = "";
String d="";
int s=0;
int no=0;
String preID = "";
boolean X_flag = false;

String checkBoxAttribute1="";
String checkBoxAttribute2="";
String checkBoxAttribute3="";
String checkBoxAttribute4="";
String checkBoxAttribute5="";
String checkBoxAttribute6="";
String checkBoxAttribute7="";

String dis1 = "DISABLED";
String dis2 = "DISABLED";
String dis3 = "DISABLED";
String dis4 = "DISABLED";
String dis5 = "DISABLED";
String dis6 = "DISABLED";
String dis7 = "DISABLED";

String res_type="";
String res_class="";
String locale			= (String)session.getAttribute("LOCALE");



            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
/*Below line modified for this CRF[AMRI-CRF-0236]*/
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
/*Below Line Added for this CRF  [AMRI-CRF-0236]*/
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(wd1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(wd2));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(wd3));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(wd4));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(wd5));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(wd6));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(wd7));
            _bw.write(_wl_block18Bytes, _wl_block18);
/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/
            _bw.write(_wl_block19Bytes, _wl_block19);

		try{
		//stmt1 = con.createStatement();
		String anchor="";
		/*String strsql="select count(*) as total from  oa_clinic_time_table a, sm_day_of_week b  where a.facility_id = '"+facilityId+"' and clinic_code = '"+cliniccode+"' and a.day_no = b.day_no and a.care_locn_type_ind='"+locationType+"' ";


		rset1 = stmt1.executeQuery(strsql);
		rset1.next();
		last = rset1.getInt("total");*/

		//stmt=con.createStatement();
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//String sqlchk =" select  a.practitioner_id,  decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, substr(b.day_of_week,1,3), a.day_no, a.resource_class from oa_clinic_time_table a,  sm_day_of_week b  where a.facility_id = '"+facilityId+"' and a.care_locn_type_ind='"+locationType+"' and  clinic_code = '"+cliniccode+"'   and a.day_no = b.day_no  order by nvl(practitioner_name,'!'),a.day_no  ";
		
        
		String sqlchk ="select a.clinic_code, A.PRACTITIONER_ID,Nvl(decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')),'!') pract_name, decode(A.resource_class, 'P',AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, substr(b.day_of_week,1,3), a.day_no day_no, a.resource_class,a.PHYS_ROSTER_REQD_YN from oa_clinic_time_table a, sm_day_of_week b where a.facility_id = '"+facilityId+"' and a.clinic_code = '"+cliniccode+"' and a.day_no = b.day_no AND 0 < (SELECT (case when a.PHYS_ROSTER_REQD_YN = 'Y' then (select distinct count(1) from OA_ROSTER_FOR_PRACT where facility_id = '"+facilityId+"' and clinic_code = a.clinic_code and practitioner_id = a.practitioner_id AND FACILITY_ID = A.FACILITY_ID and ON_DUTY_DATE between to_date('"+from_date+"','dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy')) else 1 end) FROM DUAL) UNION select a.clinic_code, A.PRACTITIONER_ID, Nvl(decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')),'!') pract_name,decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, substr(b.day_of_week,1,3), a.day_no day_no,a.resource_class,a.PHYS_ROSTER_REQD_YN from oa_clinic_time_table a, sm_day_of_week b where a.facility_id = '"+facilityId+"' and a.clinic_code = '"+cliniccode+"' AND a.PHYS_ROSTER_REQD_YN = 'N' and a.day_no = b.day_no order by pract_name,day_no ";
		
		
		

		rset=stmt.executeQuery(sqlchk);

		//rset.last();
		//last = rset.getRow();
		//rset.beforeFirst();

		if(rset != null){
			while(rset.next()){
				ID=checkForNull(rset.getString(2));
				cur_pract=checkForNull(rset.getString(4));
				day  = checkForNull(rset.getString(5));
				res_type=checkForNull(rset.getString("resource_class"));

				if(res_type.equals("P"))
				{
				res_class="Practitioner";
				}else if(res_type.equals("R"))
				{
				res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_type.equals("E"))
				{
				res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_type.equals("O"))
				{
				res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
				}
				

				if(res_type==null) res_type="";
				if(res_class==null) res_class="";

				if(cur_pract == null || cur_pract.equals("")){
					cur_pract = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels");
				}
				//if((!(cur_pract.equals(pre_pract) || first ==1)) || last == first){
				if((!(cur_pract.equals(pre_pract) || rset.isFirst())) || rset.isLast()){
					//if( last == first){
					if(rset.isLast()){

						if(cur_pract.equals(pre_pract))
						{
							d=d+day+"|";
						
						}
						else
						{
							X_flag = true;
						}
					}
								
					if(preID == null || preID.equals("") ||(preID.substring(0,preID.indexOf("*"))).equals("null") || !pre_resource.equals("Practitioner")) 
						anchor="&nbsp;";
					else	         
						anchor="<a href='javaScript:showPractWindow(\""+preID+"\")'>+&nbsp;</a>";
			
					if(!d.equals("")){						
						if(pre_resource.equals("Practitioner"))
							pre_resource=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(anchor));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pre_resource));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pre_pract));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(s));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(s));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(preID));
            _bw.write(_wl_block26Bytes, _wl_block26);

					}
								
					StringTokenizer st 	= new StringTokenizer(d.toString(),"|");

					while(st.hasMoreTokens()){
						no++;
						dayofweek=st.nextToken();
						if(dayofweek.equals(wd1)){
							checkBoxAttribute1 = "CHECKED" ;
							dis1 = "" ;}
						if(dayofweek.equals(wd2)){
							checkBoxAttribute2 = "CHECKED" ;
							dis2 = "" ;}
						if(dayofweek.equals(wd3)){
							checkBoxAttribute3 = "CHECKED" ;
							dis3 = "" ;}
						if(dayofweek.equals(wd4)){
							checkBoxAttribute4 = "CHECKED" ;
							dis4 = "" ;}
						if(dayofweek.equals(wd5)){
							checkBoxAttribute5 = "CHECKED" ;
							dis5 = "" ;}
						if(dayofweek.equals(wd6)){
							checkBoxAttribute6 = "CHECKED" ;
							dis6= "" ;}
						if(dayofweek.equals(wd7)){
							checkBoxAttribute7 = "CHECKED" ;
							dis7 = "" ;
						}
					}

					if(!d.equals("")){
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(wd1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(wd2));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis2));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(wd3));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute3));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(wd4));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute4));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis4));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wd5));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute5));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(wd6));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute6));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis6));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(wd7));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute7));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block36Bytes, _wl_block36);
/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(s));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(s));
            _bw.write(_wl_block39Bytes, _wl_block39);
s++;
            _bw.write(_wl_block40Bytes, _wl_block40);

						d="";
					}
				}

				d=d+day+"|";
				//first++;
				pre_pract = cur_pract;
				pre_resource=res_class;
				preID = ID+"*"+res_type;

				checkBoxAttribute1="";
				checkBoxAttribute2="";
				checkBoxAttribute3="";
				checkBoxAttribute4="";
				checkBoxAttribute5="";
				checkBoxAttribute6="";
				checkBoxAttribute7="";

				dis1 = "DISABLED";
				dis2 = "DISABLED";
				dis3 = "DISABLED";
				dis4 = "DISABLED";
				dis5 = "DISABLED";
				dis6 = "DISABLED";
				dis7 = "DISABLED";
				if(X_flag){
				 	dayofweek = day;

					if (preID==null) 
						preID="";
				 	
						if(preID == null || preID.equals("") ||(preID.substring(0,preID.indexOf("*"))).equals("null") || !pre_resource.equals("Practitioner")) 
							anchor="&nbsp;";
						else
							anchor="<a href='javaScript:showPractWindow(\""+preID+"\")'>+&nbsp;</a>";

					if(res_class.equals("Practitioner"))	
						   res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");	
					
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(anchor));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(cur_pract));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(s));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(s));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(preID));
            _bw.write(_wl_block45Bytes, _wl_block45);

				
				if(dayofweek.equals(wd1)){
					checkBoxAttribute1 = "CHECKED" ;
					dis1 = "" ;}
				if(dayofweek.equals(wd2)){
					checkBoxAttribute2 = "CHECKED" ;
					dis2 = "" ;}
				if(dayofweek.equals(wd3)){
					checkBoxAttribute3 = "CHECKED" ;
					dis3 = "" ;}
				if(dayofweek.equals(wd4)){
					checkBoxAttribute4 = "CHECKED" ;
					dis4 = "" ;}
				if(dayofweek.equals(wd5)){
					checkBoxAttribute5 = "CHECKED" ;
					dis5 = "" ;}
				if(dayofweek.equals(wd6)){
					checkBoxAttribute6 = "CHECKED" ;
					dis6= "" ;}
				if(dayofweek.equals(wd7)){
					checkBoxAttribute7 = "CHECKED" ;
					dis7 = "" ;
				}
				
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(wd1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wd2));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis2));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(wd3));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute3));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(wd4));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute4));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis4));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(wd5));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute5));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(wd6));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute6));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis6));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(wd7));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkBoxAttribute7));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block53Bytes, _wl_block53);
/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(s));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(s));
            _bw.write(_wl_block55Bytes, _wl_block55);
s++;
            _bw.write(_wl_block56Bytes, _wl_block56);

			}
		}// while loop of recordset
	} // if recordset null
	
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(s));
            _bw.write(_wl_block58Bytes, _wl_block58);

	if(rset != null) rset.close();
	//if(rset1 != null) rset1.close();
	if(stmt != null) stmt.close();
	//if(stmt1 != null) stmt1.close();
}catch(Exception e) {
	//out.println(e.toString()); 
	e.printStackTrace();
	
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(s));
            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ResourceDetail.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.TimeTableAvailableDays.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
