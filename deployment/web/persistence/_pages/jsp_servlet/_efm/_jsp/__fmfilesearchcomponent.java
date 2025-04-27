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
import java.util.*;
import com.ehis.util.*;

public final class __fmfilesearchcomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileSearchComponent.jsp", 1726738429771L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<Script src=\"../../eFM/js/FMFileSearchComponents.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar msg = getMessage(\'INVALID_VALUE\',\'Common\'); \n\t\t\t\t\tmsg = msg.replace(\'#\',getLabel(\'Common.patientId.label\',\'Common\'));\n\t\t\t\t\talert(msg);\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =".document.";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =".";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =").value=\"\";\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =").select();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t\tif(eval(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")!=undefined)\n\t\t\teval(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =").value = \'\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(eval(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =").value == \'\')\n\t\t\t\t\t{\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =").value = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =").value = eval(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =").value + \",\" + \'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(eval(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =").value == \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =").patient_file_type.value == \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =").patient_file_type.value = \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t\t\t\t}\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' == \'P\')\n\t\t\t{\n\t\t\t\teval(";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\t\teval(";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =").readOnly = true;\n\t\t\t\teval(";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =").pat_search.disabled = true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\n\t\t\t\teval(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =").value = \'\';\n\t\t\t\teval(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =").readOnly = false;\n\t\t\t\teval(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =").pat_search.disabled = false;\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<script>\n\t\t\t\tvar selectBox =\n\t\t\t\teval(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =");\n\t\t\t\tvar seletLen  =\tMath.abs(selectBox.length);\n\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\tselectBox.remove(0);\n\t\t\t\tvar selectOption   =  eval(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\tselectOption.value =\t\"\";\n\t\t\t\tselectOption.text  =\t\"-----\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"-----\";\n\t\t\t\tselectBox.add(selectOption);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar selectBox   =\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =");\n\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =").document.createElement(\"OPTION\");\t\n\t\t\t\t\tvar code = \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t\t\t\t\tvar desc = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\t\t\tif(code != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tselectOption.value\t=\tcode;\n\t\t\t\t\t\tselectOption.text\t=\tdesc;\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<script>\n\t\t\t\tif (\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"==\"1\")\n\t\t\t\t{\n\t\t\t\teval(";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =").options[1].selected = true; \n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<script>\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(eval(";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =").select();\n\t\t\t\t\tpatientID=\"\";\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar selectBox   =\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =");\n\t\t\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\tselectOption.text\t=\t\"-----\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"-----\";\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<script>\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =".encounter_id).disabled=false;\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =".encounter_id_search).disabled=false;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =".document.getElementById(\"FileNo\")).innerHTML = \"<input type=\'text\' name=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' onKeyPress=\'return CheckForSpecChars(event)\' value=\'\' onBlur=\'getPatIDVolume(this.value);";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' maxlength=\'20\' size=\'20\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' maxlength=\'20\' size=\'20\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar filenoTxt\t= \"<input type=\'text\' name=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' maxlength=\'20\' size=\'20\'>\";\n\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"==\"Y\"){\n\t\t\t\t\t\t\t\t\t\tfilenoTxt += \"<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =".document.getElementById(\"FileNo\")).innerHTML = filenoTxt;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif (\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"==\"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t   var selectBox  =eval(";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =");\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\t\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\t\t\tselectOption.text\t=\t\"-----\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"-----\";\n\t\t\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =".document.getElementById(\"FileNo\")).innerHTML = \"<input type=\'text\' name=\'\"+\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"+\"\' id=\'\"+\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"+\"\' onKeyPress=\'return CheckForSpecChars(event)\' value=\'\"+\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"+\"\' onBlur=\'getPatIDVolume(this.value);";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' maxlength=\'20\' size=\'20\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar filenoTxt\t= \"<input type=\'text\' name=\'\"+\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' maxlength=\'20\' size=\'20\'>\";\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"==\"Y\"){\n\t\t\t\t\t\t\t\t\tfilenoTxt +=  \"<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =".document.getElementById(\"FileNo\")).innerHTML = filenoTxt;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t var dfltslt_cnt=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\t\t\t\t\t\t\t\t\tvar selectBox = eval(";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =");\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tvar seletLen = Math.abs(selectBox.length);\n\t\t\t\t\t\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\t\t\t\t\t\tvar selectOption =  eval(";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\t\t\t\t\t//\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\t\t\t\t//\tselectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\t\t\t//\t\tselectBox.add(selectOption);\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tif(eval(";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =").value !=\"\"){\n\t\t\t\t\t\t\t\t\t\t\tselectOption\t\t=  eval(";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\t\t\t\t\t\t\t\tselectOption.value\t=\t\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\';\n\t\t\t\t\t\t\t\t\t\t\tselectOption.text\t=\t\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\';\n\t\t\t\t\t\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse{\n                       \n\t\t\t\t\t             \t if(dfltslt_cnt==0)\n\t\t\t\t\t      \t         {\n\t\t\t\t\t      \t       selectOption.value\t=\t\"\";\n\t\t\t\t\t\t\t      selectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\t            selectBox.add(selectOption);\n\t\t\t\t\t\t        }\n\t\t\t\t             \t}\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"==\"FMConfirmRcptCriteria_form\")\n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =").AddFiles(";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =");\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"==\"ConfirmPullingListForm\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =").addFiles_confirm();\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" == \"FMReceiveFileMRD\"  )\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =").addFiles(";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" == \"FMRetutnToMRD\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =").searchForRecord(";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" == \"FileIsuueTab\")\n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =").submitAllDetails();\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\telse if(\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"==\"FMCancelRequestCriteria_form\")\n\t\t\t\t         {\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =").AddFiles();\n\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t       }\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\telse if(\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar search=\'search\';\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =").fetchResults(search);\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar optionValue\t= \"\";\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t  optionValue = optionValue + \"<option value=\'\"+\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"+\"\' ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =">\"+\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"+\"</option>\";\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t\toptionValue = optionValue + \"<option value=\'\"+\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"+\"\'>\"+\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"+\"</option>\";\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\tvar selectBox\t= \"<select name=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' value = \'\' onChange=\'populateFileVolume(\\\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\\\",this.value,\\\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\\\");";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' onmousewheel=\'return false;\' ><option>------------";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="-----------</option>\";\n\t\t\t\t\t\t\tselectBox += optionValue;\n\t\t\t\t\t\t\t//if(\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t\t\t\t//{\n\t\t\t\t\t\t//\tselectBox += \"</select>\";\n\t\t\t\t\t\t\t//}\n\t\t\t\t\t\t\t//else\n\t\t\t\t\t\t\t//{\n\t\t\t\t\t\t\t\tselectBox += \"</select>&nbsp;\";\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"==\"Y\"){\n\t\t\t\t\t\t\t\t\tselectBox +=\"<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t//\t}\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =".document.getElementById(\"FileNo\")).innerHTML = selectBox;\n\t\t\t\t\t\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =").populateFileVolume(\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\",eval(";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =").value,\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\");\n\t\t\t\n\t//eval(";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =").onblur(); \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t//\tconsole.log(\"942\");\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =".document.getElementById(\"FileType\")).innerHTML = \"<input type=\'text\' name=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'  value=\'\' readOnly onBlur=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar fileTypeTxt\t= \"<input type=\'text\' name=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\";\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"==\"Y\"){\n\t\t\t\t\t\t\t\tfileTypeTxt += \"<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =".document.getElementById(\"FileType\")).innerHTML = fileTypeTxt;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif (\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" == \"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar selectBox   =\n\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =");\n\t\t\t\t\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t\t\t\t{\teval(";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =".document.getElementById(\"FileType\")).innerHTML = \"<input type=\'text\' name=\'\"+\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"+\"\' readOnly value=\'\"+\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"+\"\' onBlur=\' ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar fileTypeTxt\t= \"<input type=\'text\' name=\'\"+\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\";\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"==\"Y\"){\n\t\t\t\t\t\t\t\t\tfileTypeTxt += \"<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =".document.getElementById(\"FileType\")).innerHTML = fileTypeTxt;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =").patient_file_type.value = \"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\";\t\n\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =").patient_file_type_desc.value = \"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\";\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\tvar selectBox   = eval(";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =");\n\t\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =".document).createElement(\"OPTION\");\t\t\n\t\t\t\t/*\tselectOption.value\t=\t\"\";\n\t\t\t\t\tselectOption.text\t=\t\"----\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"----\";\n\t\t\t\t\tselectBox.add(selectOption);*/\n\t\t\t     \t</script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!--\t<script>\n\t\t\t\t\t\t\t\t\t\tvar selectBox = \t\t\t\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =");\n\t\t\t\t\t\t\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\t\t\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\t\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =".document).createElement(\"OPTION\");\t\t\n\t\t\t\t\t\t\t\t//\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\t\t\t//\t\tselectOption.text\t=\t\"-Select-\";\n\t\t\t\t\t\t\t\t//\t\tselectBox.add(selectOption);-->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\tif(eval(";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =").value !=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar selectBox\t\t= eval(";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =");\n\t\t\t\t\t\tvar selectOption\t= eval(";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =".document).createElement(\"OPTION\");\t\t\n\t\t\t\t\t\tselectOption.value\t= \'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\';\n\t\t\t\t\t\tselectOption.text\t= \'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\';\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n                       \n\t\t\t\t\t \tvar dfltslt_cnt=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\";\n\t\t\t\t\t\t if(dfltslt_cnt==0)\n\t\t\t\t\t       {\n\t\t\t\t\t     var selectBox\t\t= eval(";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =".document).createElement(\"OPTION\");\n\t\t\t\t\t\t  \n\t\t\t\t\t\t  selectOption.value\t=\t\"\";\n\t\t\t\t\t     selectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\t selectBox.add(selectOption);\n\t\t\t\t\t\t   }\n\t\t\t\t         \t}\n\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--\tselectOption =  eval(";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =".document).createElement(\"OPTION\");\t\n\t\t\t\t\t\t\tselectOption.value\t=\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\';\n\t\t\t\t\t\t\t\tselectOption.text\t=\t\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\';\n\t\t\t\t\t\t\t\tselectBox.add(selectOption);-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\t\t\t\t<!--\t</script>  -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =").patient_file_type.value = \"\";\t\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =").patient_file_type_desc.value = \"\";\t\n\t\t\t\t\t\t\tvar optionValue\t= \"\";\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\toptionValue = optionValue + \"<option value=\'\"+\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\"+\"\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =" >\"+\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n                                optionValue = optionValue + \"<option value=\'\"+\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"+\"</option>\";\n                            \t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar selectBox\t= \"<select name=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' onChange=\'setValues(this.value);populateFileVolume(\\\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\\\",\\\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\\\",this.value);";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' onmousewheel=\'return false;\'><option value = \'\' >----------\"+getLabel(\'Common.defaultSelect.label\' ,\'common\') + \"---------</option>\";\n\t\t\t\t\t\t\tselectBox += optionValue;\n\t\t\t\t\t\t\tselectBox += \"</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar selectBox\t= \"<select name=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' onmousewheel=\'return false;\' ><option value = \'\' >----------\"+getLabel(\'Common.defaultSelect.label\' ,\'common\') + \"---------</option>\";\n\t\t\t\t\t\t\t\tselectBox += optionValue;\n\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"==\"Y\"){\n\t\t\t\t\t\t\t\t\tselectBox += \"</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =".document.getElementById(\"FileType\")).innerHTML = selectBox;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 =").setValues(eval(";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =").value);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =".document).createElement(\"OPTION\");\t\t\n\t\t\t\t\n\t\t\t     \t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\tif(eval(";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =").value !=\"\"){\n\t\t\t\t\t\n\t\t\t\t\t\tvar selectBox\t\t= eval(";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\';\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t}else{\n                       \n\t\t\t\t\t \tvar dfltslt_cnt=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =".document).createElement(\"OPTION\");\n\t\t\t\t\t\t  \n\t\t\t\t\t\t  selectOption.value\t=\t\"\";\n\t\t\t\t\t     selectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\t selectBox.add(selectOption);\n\t\t\t\t\t\t   }\n\t\t\t\t         \t}\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t<script>\n\t\t\teval(";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 =").value = \'\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t<script>\n\t\t\t\teval(";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 =".document.all.";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =").innerHTML=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\t\n\t\t\tif(\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'!=\"\")\teval(";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\"==\"fm_req_criteria\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 =").addFiles();\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t}\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\"==\"FMCancelRequestCriteria_form\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t}\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\"==\"FMConfirmRcptCriteria_form\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 =");\n\t\t\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\"==\"ConfirmPullingListForm\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t//if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t// Modified for IN:043804 by Dharma on 4th oct 2013\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =").addFiles_confirm();\n\t\t\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\n\t\t\t\t}\t\t\t\t\n\t\t\tif(\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" ==\"FMTransferFileCriteria_form\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" == \"FMReceiveFileMRDSearch\")\n\t\t\t\t{\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t}\n\t\t\t\telse if(\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" == \"FMRetutnToMRD\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" == \"FileIsuueTab\")\n\t\t\t\t{\n\t\t\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 =").submitAllDetails();\n\t\t\t\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" == \"FMChngStrLocnCriteriaForm\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =").fetchResults();\n\t\t\t\t\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" ==\"FMChFileRetDateCriteriaForm\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =").fetchResults(\"search\");\n\t\t\t\t\t";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\tvar selectBox   = eval(";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 =".document).createElement(\"OPTION\");\t\t\n\t\t\t\t/*\tselectOption.value\t=\t\"\";\n\t\t\t\t\tselectOption.text\t=\t\"----\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"----\";\n\t\t\t\t\tselectBox.add(selectOption);*/\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\tdfltslt_cnt=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\";\n\t\t\t\t\tvar dflt_file_type=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\";\n\t\t\t\t\tvar dflt_file_no=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\";\t\n\t\t\t\t\tvar dflt_flag =\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\";\t\n\t\t\t\t\tvar patient_file_type=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\";\n\t\t\t\t\tvar selectBox=\"\";\n\t\t\t\t    var selectOption=\"\";\t\n\t\t\t\t\tvar filenotype=\"\";\n                   var record_count=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\";\t \n\t\t  \n\t\t \t  if(eval(";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="))\n\t\t\t\t\t{\n\t\t\t       filenotype=eval(";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 =").value;\n\t\t\t\t\t} \n\t\t\t\t if(eval(";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="))\n\t\t\t\t\t{\n             filenotype=eval(";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 =").value;\n\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t if(filenotype !=\"\" || patient_file_type!=\"\"){\n\t\t\t\t\t\t selectBox\t\t= eval(";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 =");\n\t\t\t\t\t\t selectOption\t= eval(";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\';\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t\tif(dflt_file_type==\"\" && dflt_file_no==\"\" && dflt_flag==\"true\" && record_count>1)\n\t\t\t\t\t {\n                 if(eval(";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="))\n\t            removeitems(eval(";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="));\n                   \n\t\t\t\t   selectBox\t\t= eval(";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =".document).createElement(\"OPTION\");\t\n\t\t\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\t\tselectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\tselectBox.add(selectOption);\n\n\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t}else{\n                       \n\t\t\t\t\t\tif(dfltslt_cnt==0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\tselectBox\t\t= eval(";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 =".document).createElement(\"OPTION\");\t\n\t\t\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\t\tselectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t<script>\n\t\t\t\n\t\t\t\t\tvar errors =\"\";\n        if(eval(";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 =").value !=\"\"){\n  \t\t\n\t\terrors = getMessage(\'PATIENT_FILE_NOT_EXIST\',\'FM\');\n\n\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\"==\"ManualEntry_form\")\n\t\t\t\t{\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" == \"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" != \"parent.parent.messageFrame\" && (";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="==0))\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 =").document.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errors ;\n\t\t\t\t\telse if(\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" != \"parent.parent.messageFrame\")\n\t\t\t\t\t\tparent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\telse if(\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" == \"parent.parent.messageFrame\")\n\t\t\t\t\t\tparent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 =").CheckPatientExists1(\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\',\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\');\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//if(\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\"==\"ConfirmPullingListForm\" && \'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\' == 0 ){\n\t\t\t\t\t// Modified for IN:043804 by Dharma on 4th oct 2013\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\' == 0 && (\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\"==null || \"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\"==\"\")){\t\n\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].patient_id.onblur();\t\t\t\t\t\n\t\t\t       }\n\t\t\t\t   \n\t\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="==0))\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 =").document.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errors ;\n\t\t\t\telse if(\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" != \"parent.parent.messageFrame\")\n\t\t\t\t\tparent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\telse if(\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" == \"parent.parent.messageFrame\")\n\t\t\t\t\tparent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t}\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\"==\"ManualEntry_form\")\n\t\t\t  {\n                if(errors !=\"\")\n\t\t\t\t  {\n\t\t\t\t\tif(parent.searchResultFrame)\n\t\t\t\t\t  {\t\t\t\t\tparent.searchResultFrame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t  }\n\t\t\t\t  }\n\t\t\t  }\n\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n\t\t\t\t<!-- <script>\n\t\t\t\t//alert(\'APP-MP0112 Patient File not Created\');\n\t\t\t\t</script> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n</head>\n<script>\n\tvar errors =\"\";\n\n\nif(eval(";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="))\n\t\t{\nif(eval(";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 =").value !=\"\" && eval(";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 =").value !=\"\"){\n   // errors = getMessage(\'PATIENT_FILE_NOT_EXIST\',\'FM\');\nif(eval(";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="))\neval(";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 =").document.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errors ;\n}\n\t}\n\nif(\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\"==\"ManualEntry_form\")\n{\n\t\n\tif(\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" == \"Y\")\n\t{\n\t\tif(\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="==0))\n\t\t\teval(";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 =").document.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errors ;\n\t\telse if(\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\" == \"parent.parent.messageFrame\")\n\t\t\tparent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t}\n\telse\n\t\teval(";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\');\n}\nelse\n{\n\nif(\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="==0))\n\teval(";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 =").document.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errors ;\nelse if(\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\" == \"parent.parent.messageFrame\")\n\tparent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n}\n\n\n</script>\n";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n</html>\n";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

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
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);




Connection connection			= null;
PreparedStatement preStatement	= null;
PreparedStatement volStatement	= null;
ResultSet	resultSet			= null;
ResultSet	volResultSet		= null;

String facilityID				= "";
String patientID				= "";
String operation				= "";

String sqlString				= "";
String file_no					= "";
String fileType					= "";
String file_type_code			= "";
String file_type_desc			= "";
String fileNo					= "";
String patient_file_type		= "";
String doc_patient_id			= "";
String frame_name               = "";
String form_name                = "";
String messageframe_name        = "";
String patientid_name			= "";
String fileno_name              = "";
String filetype_name            = "";
String volumeno_name            = "";
String file_no_function		    = "";
String file_type_function	    = "";
String patline_ID			    = "";
String external_facility	    = "";
String param_patient_id			= "";
String patient_period_specific  = "D";
String volume_no_appl_yn        = "Y";
String file_type_appl_yn		= "N";
String patline_yn			    = "N";
String patient_name			    = "&nbsp;";
String sqlString1="";
String curr_facility_id="";
String  dflt_file_type="";
String perm_fs_locn_code="";
String dflt_file_no="";
String dflt_flag="";
String file_creat_fac_id1="";
String file_mandatory_yn	= "";
//String search="search";
String selected="";
int rec_count=0;
int vol_cnt = 0;
int vol_cntt = 0;
int vol_cnt1= 0;
int  dfltslt_cnt=0;
int record_count = 0;
int dfltcnt=0;
StringBuffer volumeBuffer =	new StringBuffer();

// For Document Feature - 28/8/2004  starts
String function_type			= "";
String document_folder_id		= "";
String document_type_id			= "";
String document_type_name		= "";
// For Document Feature - 28/8/2004  End.
String doctype_appl_yn = "";

// Function Name
String function_name = "";
String file_mov_flag = "";
String file_creat_fac_id ="";
String curr_fs_locn_identity="";
String fs_req_location="";
String confaciliytid="";
String faciliyt_token="";
String file_token="";
String fileNo_old="";
boolean flag = true;

try
{
	connection = ConnectionManager.getConnection(request);	

	facilityID 			= checkForNull((String) session.getValue("facility_id"));
	patientID			= checkForNull(request.getParameter("patientID"));
	
	external_facility	= checkForNull(request.getParameter("facilityID"));
	operation			= checkForNull(request.getParameter("operation"));
	file_type_appl_yn	= checkForNull(request.getParameter("file_type_appl_yn"));
	fileNo				= checkForNull(request.getParameter("fileNo"));
	fileNo_old=fileNo;
	fileType			= checkForNull(request.getParameter("fileType"));
	patient_file_type	= checkForNull(request.getParameter("patient_file_type"));
	frame_name			= checkForNull(request.getParameter("frame_name"));
		form_name			= checkForNull(request.getParameter("form_name"));
		if(frame_name.equals("parent.cancel_criteria"))
	{
   form_name="FMCancelRequestCriteria_form";
	}
	 messageframe_name	= checkForNull(request.getParameter("messageframe_name"));
	fileno_name			= checkForNull(request.getParameter("fileno_name"));
	if(form_name.equals("fm_req_criteria") || form_name.equals("ConfirmPullingListForm"))
	{
   if(fileno_name.equals("undefined")) fileno_name="p_file_no"; 
	}else{	
	if(fileno_name.equals("undefined")) fileno_name="file_no"; 
	}
	patientid_name		= checkForNull(request.getParameter("patientid_name"));
	filetype_name		= checkForNull(request.getParameter("filetype_name"));
	if(filetype_name.equals("undefined")) filetype_name="file_type_code"; 
	volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
	volume_no_appl_yn	= checkForNull(request.getParameter("volume_no_appl_yn"), "Y");
	file_no_function	= checkForNull(request.getParameter("file_no_function"));
	file_type_function	= checkForNull(request.getParameter("file_type_function"));
	patline_yn			= checkForNull(request.getParameter("patline_yn"), "N");
	patline_ID			= checkForNull(request.getParameter("patline_ID"));
	param_patient_id	= checkForNull(request.getParameter("param_patient_id"));

	// For Document Feature - 28/8/2004  starts
	function_type		= checkForNull(request.getParameter("function_type"));	
	document_folder_id	= checkForNull(request.getParameter("document_folder_id"));	
	document_type_id	= checkForNull(request.getParameter("document_type_id"));
	document_type_name	= checkForNull(request.getParameter("document_type_name"));
	// For Document Feature - 28/8/2004  End.
	doctype_appl_yn		= checkForNull(request.getParameter("doctype_appl_yn"));
	fs_req_location   =checkForNull(request.getParameter("fs_req_location"));
	dflt_flag   =checkForNull(request.getParameter("dflt_flag"));
	// Function Name
	function_name		= checkForNull(request.getParameter("function_name"));
	file_mov_flag		= checkForNull(request.getParameter("file_mov_flag"));
	
	file_mandatory_yn	= checkForNull(request.getParameter("file_mandatory_yn"), "Y");

	
	//if(form_name.equals("FMReturnToMRDCriteriaForm"))
	//{
		sqlString1 = "SELECT count(*) record_count FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ";
	//sqlString1 = "SELECT count(*) record_count  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and CURR_FILE_STATUS in('I','O' )  and PERM_FS_LOCN_CODE <>CURR_FS_LOCN_CODE  and  curr_facility_id='"+facilityID+"' ";

	//}else{
	//sqlString1 = "SELECT count(*) record_count FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ";
	//} 
			preStatement	=	connection.prepareStatement(sqlString1);
			resultSet = preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
	{
			rec_count = resultSet.getInt("record_count");
           }
				 
		   if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		  			
		   if(form_name.equals("FMReturnToMRDCriteriaForm"))
	     {
		   preStatement	=	connection.prepareStatement(" SELECT facility_id,PERM_FS_LOCN_CODE fs_locn_code FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and CURR_FILE_STATUS='I' and CURR_FS_LOCN_IDENTITY='D' and PERM_FS_LOCN_CODE <>CURR_FS_LOCN_CODE and  curr_facility_id='"+facilityID+"' ");
	   
		}  else if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !fileNo.equals("") ) {
       preStatement	=	connection.prepareStatement(" SELECT facility_id,fs_locn_code FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and file_no='"+fileNo+"'  and doc_folder_id is null ");
		}
	
		else
	   {
	     preStatement	=	connection.prepareStatement(" SELECT facility_id,fs_locn_code FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ");
	   } 
			resultSet = preStatement.executeQuery();
	
	
	
	if ((resultSet != null) && (resultSet.next()))
	{
			file_creat_fac_id = resultSet.getString("facility_id");
        
		  if(form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMChngStrLocnCriteriaForm"))
	     { 
		    file_creat_fac_id1=file_creat_fac_id;
		   }
		
			if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !fileNo.equals("")  )
		{
       file_creat_fac_id1=file_creat_fac_id;
		}
			
		perm_fs_locn_code = resultSet.getString("fs_locn_code");
	  }
		     if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
       
		 if(perm_fs_locn_code==null || perm_fs_locn_code.equals("null")) perm_fs_locn_code="";
	
			 if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
	
	
	if(file_type_appl_yn.equals("Y") && !fileType.equals(""))
	{
	 if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm"))
	  {
     StringTokenizer file_facility=new StringTokenizer(fileType,"~"); 
	 
		 while(file_facility.hasMoreTokens())
		{
	     file_token    =file_facility.nextToken() ;
	      faciliyt_token=file_facility.nextToken() ;
	   }
	file_creat_fac_id=faciliyt_token;
	fileType=file_token;
	patient_file_type=file_token;
	
	//file_type_code=file_token;
	}
	}
	
	
	if(dflt_flag.equals("true"))
	{
	
	preStatement	=	connection.prepareStatement(" SELECT a.file_type_code file_type_code, b.file_no file_no   FROM fm_file_type_for_fsl a, mr_pat_file_index b  WHERE a.eff_status = 'E'    AND a.fs_locn_code ='"+fs_req_location+"'    AND a.default_yn = 'Y'    AND b.patient_id = '"+patientID+"'    AND a.facility_id ='"+facilityID+"'     AND a.facility_id = b.facility_id  AND  a.file_type_code =b.file_type_code");
		
		resultSet = preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
	{
			dflt_file_type = resultSet.getString("file_type_code");
            dflt_file_no  = resultSet.getString("file_no"); 
			   }
		   if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		   if(dflt_file_type==null || dflt_file_type.equals("null")) dflt_file_type="";
		  if(dflt_file_no==null || dflt_file_no.equals("null")) dflt_file_no="";
	}
		 if(file_creat_fac_id==null) file_creat_fac_id="";

      if(!file_creat_fac_id1.equals(facilityID))
					{
		if(form_name.equals("FMChngStrLocnCriteriaForm"))
						{
	 preStatement	=	connection.prepareStatement(" SELECT curr_fs_locn_identity,curr_facility_id  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and facility_id='"+file_creat_fac_id+"'  ");
		}else if(form_name.equals("FMReturnToMRDCriteriaForm")){
		preStatement	=	connection.prepareStatement(" SELECT curr_fs_locn_identity,curr_facility_id  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and facility_id='"+file_creat_fac_id1+"' and curr_file_status='I' and curr_fs_locn_code='"+fs_req_location+"' ");	
				} else{
   preStatement	=	connection.prepareStatement(" SELECT curr_fs_locn_identity,curr_facility_id  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and facility_id='"+file_creat_fac_id+"' and curr_file_status='I' and curr_fs_locn_code='"+fs_req_location+"' ");
							}
			resultSet = preStatement.executeQuery();
	
	if ((resultSet != null) && (resultSet.next()))
	{
			curr_fs_locn_identity = resultSet.getString("curr_fs_locn_identity");
           curr_facility_id = resultSet.getString("curr_facility_id");
		   }
		   if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			if(curr_fs_locn_identity==null)	 curr_fs_locn_identity="";	
					
					}


            _bw.write(_wl_block2Bytes, _wl_block2);


	if(!external_facility.equals("")) facilityID = external_facility;

	if(function_type.equals("FileDetails"))
	{
		if(!param_patient_id.equals(""))
		{
			webbeans.op.PatientData patdata = new webbeans.op.PatientData();
			patdata.setFacility_id(facilityID);
			String patient_status = patdata.CheckStatus(connection,param_patient_id);
			if(patient_status.equals("INVALID_PATIENT"))
			{
				flag = false;
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
		}
		
		if(flag)
		{
		//	sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"' ";
			sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"' ";
			if(!document_folder_id.equals(""))
				sqlString = sqlString + " AND doc_folder_id = '"+document_folder_id+"' ";
			if(doctype_appl_yn.equals("Y") && !document_type_id.equals(""))
			{
				sqlString = sqlString + " AND doc_type_code = '"+document_type_id+"' ";
			}
			if(!param_patient_id.equals(""))
			{
				sqlString = sqlString +  " AND patient_id = '"+param_patient_id+"' ";
			}
			sqlString = sqlString + " AND doc_folder_id is NOT NULL ";
	
			preStatement = connection.prepareStatement(sqlString);
			resultSet = preStatement.executeQuery();
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
 
			while(resultSet.next())
			{
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_no"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_no"))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_code"))));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_code"))));
            _bw.write(_wl_block27Bytes, _wl_block27);

			}
		}
	}
	else if(function_type.equals("DocumentOnly"))
	{
		sqlString = " SELECT patient_period_specific, patient_id FROM fm_doc_folder WHERE facility_id = ? AND doc_folder_id = ? ";
		
		preStatement = connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, document_folder_id);
		resultSet = preStatement.executeQuery();
		if((resultSet != null) && (resultSet.next()))
		{
			patient_period_specific = resultSet.getString("patient_period_specific");
			doc_patient_id = resultSet.getString("patient_id");
			if(patient_period_specific == null || patient_period_specific.equals("null")) 					patient_period_specific = "D";
			if(doc_patient_id == null || patient_period_specific.equals("null")) 	
				doc_patient_id = "";
		}

		if(resultSet != null) resultSet.close();
		if(preStatement != null) preStatement.close();
			
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_period_specific));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(doc_patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block35Bytes, _wl_block35);

		sqlString =	" SELECT a.doc_type_code, b.doc_type_name FROM fm_doc_type_in_folder a, fm_doc_type b WHERE a.doc_type_code = b.doc_type_code and facility_id = ? AND doc_folder_id = ? ";

		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();

		preStatement = connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, document_folder_id);
		resultSet = preStatement.executeQuery();

		int count = 0;

		if(resultSet != null)
		{
			
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block38Bytes, _wl_block38);

			while(resultSet.next())
			{
				document_type_id	=	checkForNull(resultSet.getString("doc_type_code"));
				count++;
				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(checkForNull(resultSet.getString("doc_type_code"))));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(checkForNull(resultSet.getString("doc_type_name"))));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}
			
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

		}	
		if(count == 1)
		{
			sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"'  AND doc_folder_id = '"+document_folder_id+"' AND doc_type_code = '"+document_type_id+"' ";
		
			}
		else if(count > 1)
		{
			sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"'  AND doc_folder_id = '"+document_folder_id+"' ";
		}
		if(!doc_patient_id.equals(""))
		{
			sqlString  = sqlString + " AND patient_id = '"+doc_patient_id+"' ";
		}

	
	
	
	if 	(count >= 1){		
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		preStatement = connection.prepareStatement(sqlString);
		resultSet = preStatement.executeQuery();
	}

		if (count == 1)
		{
			if ((resultSet != null) && (resultSet.next()))
			{
				
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_no"))));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_code"))));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_code"))));
            _bw.write(_wl_block49Bytes, _wl_block49);

			}
		}
		else
		{
			while((resultSet != null) && (resultSet.next()))
			{
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_no"))));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_no"))));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_code"))));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_code"))));
            _bw.write(_wl_block52Bytes, _wl_block52);

			}
		}
	}
	else
	{
		if(!patientID.equals(""))
		{
			webbeans.op.PatientData patdata = new webbeans.op.PatientData();
			patdata.setFacility_id(facilityID);
			String patient_status = patdata.CheckStatus(connection,patientID);
			if(patient_status.equals("INVALID_PATIENT"))
			{
				flag = false;
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(volume_no_appl_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block56Bytes, _wl_block56);
		
			}
		}


if(flag)
		{
		  		if(function_name.equals("FileDeficiencyMonitoring"))
			{

		if(!patientID.equals(""))
					{
					
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block59Bytes, _wl_block59);

					}

			}
		}
      if(flag){			
		if(fileNo.equals("") && fileType.equals(""))
		{
		  if(file_type_appl_yn.equals("N")){
			 if(form_name.equals("FMReturnToMRDCriteriaForm")){
				if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					sqlString = "SELECT  count(*) record_count from mr_pat_file_index  WHERE  facility_id ='"+file_creat_fac_id1+"' and patient_id='"+patientID+"' ";
				}else{
				sqlString = "SELECT  count(*) record_count from fm_Curr_Locn  WHERE curr_file_status in ('O' ,'I') and perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_facility_id ='"+facilityID+"' and patient_id= '"+patientID+"' ";
				}
			 }else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){
                sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ";
			 }else{
			    sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE facility_id = '"+file_creat_fac_id+"' AND patient_id ='"+patientID+"' and doc_folder_id is null ";
			  }	
		  }	else if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMConfirmRcptCriteria_form")){
					//sqlString = "SELECT  count(*) record_count FROM  fm_Transit_File a , fm_Curr_Locn c WHERE A.dest_Facility_Id = ?   AND a.File_No = c.File_No   AND a.src_Facility_Id = c.Curr_Facility_Id   AND a.Volume_No = c.Volume_No   AND c.Curr_File_Status IN ('T','E')   AND c.Doc_Folder_Id IS  NULL AND c.patient_id = ? ";
					sqlString = "SELECT  count(*) record_count FROM  fm_Transit_File a , fm_Curr_Locn c WHERE A.dest_Facility_Id = ?   AND a.File_No = c.File_No   AND a.Volume_No = c.Volume_No   AND c.Curr_File_Status IN ('T','E')  and c.Doc_Folder_Id IS  NULL AND c.patient_id = ? ";				
			   }else if(form_name.equals("FMReturnToMRDCriteriaForm")){
				  if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					sqlString = "SELECT  count(*) record_count from mr_pat_file_index  WHERE  facility_id =? and patient_id= ? ";
				  }else{
					sqlString = "SELECT  count(*) record_count from fm_Curr_Locn  WHERE curr_file_status in( 'O' ,'I') and  perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_facility_id =? and patient_id= ? ";
				  }
				}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){
				 	sqlString = "SELECT count(*) record_count FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND  b.patient_id ='"+patientID+"' ";
				 }else	{
				  sqlString = "SELECT count(*) record_count FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id=? AND b.patient_id =? ";
				}
			}

			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		    preStatement	=	connection.prepareStatement(sqlString);			
				//if(form_name.equals("FMCancelRequestCriteria_form") || //form_name.equals("FMTransferFileCriteria_form"))
			if(file_type_appl_yn.equals("N")){				
			}
			if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form"))
				{
				}else{
					if(form_name.equals("FMChngStrLocnCriteriaForm")) {
						//preStatement.setString(1,file_creat_fac_id);
					}else if(form_name.equals("FMReturnToMRDCriteriaForm") && !file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
						preStatement.setString(1, file_creat_fac_id1);
					    preStatement.setString(2, patientID);					
				    }else{
						preStatement.setString(1, facilityID);
					    preStatement.setString(2, patientID);
					}			
	       		} 
			}
			resultSet = preStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
			record_count = resultSet.getInt("record_count");				
			if((form_name.equals("FMReturnToMRDCriteriaForm") ||  form_name.equals("FMConfirmRcptCriteria_form")) && record_count>1 && rec_count==1)	{
              record_count=rec_count;
			}
			
			if(file_type_appl_yn.equals("N")){
				if(form_name.equals("FMReturnToMRDCriteriaForm")){		
				   if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					  sqlString = "SELECT DISTINCT File_no file_no  FROM  fm_Curr_Locn  WHERE curr_file_status ='I' and perm_fs_locn_code <> curr_fs_locn_code and   curr_fs_locn_code='"+fs_req_location+"'  and doc_folder_id is  null AND facility_id ='"+file_creat_fac_id1+"'  AND patient_id ='"+patientID+"' ";
					}else{
                      sqlString = "SELECT DISTINCT File_no file_no  FROM  fm_Curr_Locn  WHERE curr_file_status in('O','I') and  perm_fs_locn_code <> curr_fs_locn_code  and doc_folder_id is  null AND curr_facility_id ='"+facilityID+"'  AND patient_id ='"+patientID+"' ";
					}
				}else if(form_name.equals("FMConfirmRcptCriteria_form")){
				   sqlString ="SELECT  DISTINCT a.file_no file_no FROM  fm_Transit_File a  , fm_Curr_Locn c WHERE  A.dest_Facility_Id ='"+facilityID+"'  AND a.File_No = c.File_No AND a.volume_no = c.volume_no   AND c.Curr_File_Status IN ('T','E') AND c.Doc_Folder_Id IS  NULL AND c.patient_id ='"+patientID+"' ";
				}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){
				   sqlString = "SELECT file_no  FROM  mr_pat_file_index  WHERE patient_id ='"+patientID+"' ";
				}else{									
					//	sqlString = "SELECT b.file_no file_no  FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id ='"+facilityID+"' AND b.patient_id ='"+patientID+"' ";
					sqlString = "SELECT file_no  FROM  mr_pat_file_index WHERE  facility_id ='"+facilityID+"' AND patient_id ='"+patientID+"' ";
				}			
			}else if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMConfirmRcptCriteria_form")){	
				   sqlString ="SELECT  DISTINCT a.File_Type_Code file_type_code,a.facility_id facility_id , MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID, A.FILE_TYPE_CODE,'en','2') file_type_desc FROM  fm_Transit_File a  , fm_Curr_Locn c WHERE  A.dest_Facility_Id = ?  AND a.File_No = c.File_No AND a.volume_no = c.volume_no   AND c.Curr_File_Status IN ('T','E') AND c.Doc_Folder_Id IS  NULL AND c.patient_id = ? ";
				}else if(form_name.equals("FMReturnToMRDCriteriaForm")){							
					if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					  sqlString = "SELECT DISTINCT File_Type_Code file_type_code, facility_id , mr_get_desc.MR_FILE_TYPE(facility_id,File_Type_Code,'"+localeName+"',2) file_type_desc  FROM  fm_Curr_Locn  WHERE curr_file_status ='I' and  perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_fs_locn_code='"+fs_req_location+"' and  facility_id = ?  AND patient_id= ? ";
					}else{
                       sqlString = "SELECT DISTINCT File_Type_Code file_type_code,facility_id , mr_get_desc.MR_FILE_TYPE(facility_id,File_Type_Code,'"+localeName+"',2) file_type_desc  FROM  fm_Curr_Locn  WHERE curr_file_status in ( 'O','I') and perm_fs_locn_code <> curr_fs_locn_code and  doc_folder_id is  null AND curr_facility_id = ?  AND patient_id= ? ";
					}				
				}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){				
					sqlString = "SELECT b.file_type_code file_type_code, a.short_desc file_type_desc , b.facility_id facility_id  FROM  mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code  AND b.patient_id ='"+patientID+"' ";
				}else{
					sqlString = "SELECT b.file_type_code file_type_code, a.short_desc file_type_desc FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id =? AND b.patient_id = ? ";
				}
			}		
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();	
			preStatement	=	connection.prepareStatement(sqlString);
			if(file_type_appl_yn.equals("N")){
			}
			if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){             
			 }					
			if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D") && form_name.equals("FMReturnToMRDCriteriaForm"))
			{
			  preStatement.setString(1, file_creat_fac_id1);
		 	  preStatement.setString(2, patientID);
			}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){             
			 }else{
				preStatement.setString(1, facilityID);
				preStatement.setString(2, patientID);
			 }
		 }
		
		 resultSet = preStatement.executeQuery();
			
		
			if(resultSet != null){ 				
				if(form_name.equals("FMConfirmRcptCriteria_form")){
				  rec_count=record_count;
				}
				if(file_type_appl_yn.equals("N")){						
					if(record_count==0){
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(file_mandatory_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(volume_no_appl_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block73Bytes, _wl_block73);

						}else if(record_count==1){
						  if(resultSet.next()){
							file_no = checkForNull(resultSet.getString("file_no"));
							
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(file_mandatory_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block82Bytes, _wl_block82);

															
							if(volume_no_appl_yn.equals("Y"))
							{
								
								if((volumeBuffer != null) && (volumeBuffer.length() > 0))
									volumeBuffer.delete(0, volumeBuffer.length());
								
								volumeBuffer.append("SELECT distinct volume_no,VOLUME_STATUS FROM fm_curr_locn WHERE facility_id = '");
								
						       if(form_name.equals("FMReturnToMRDCriteriaForm") && !file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					        {
							volumeBuffer.append(file_creat_fac_id1);
								}else{
                               volumeBuffer.append(facilityID);
								}
								
								volumeBuffer.append("' and patient_id = '");
								volumeBuffer.append(patientID);
								volumeBuffer.append("' ");
								
								if(!file_no.equals(""))
								{
									volumeBuffer.append(" AND file_no = '");
									volumeBuffer.append(file_no);
									volumeBuffer.append("' ");
								}
								
							volumeBuffer.append("ORDER BY volume_no desc ");
								
							
								
								if(volStatement != null) volStatement = null;
								if(volResultSet != null) volResultSet = null;

										
								
								
								volStatement	=	connection.prepareStatement(volumeBuffer.toString());
														
								volResultSet	=	volStatement.executeQuery();	
								
								
								if(volResultSet != null)
								{
									
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(dfltslt_cnt));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block86Bytes, _wl_block86);

										while(volResultSet.next())
										{
											vol_cnt++;
                           						
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block91Bytes, _wl_block91);

								dfltslt_cnt++;				
								}
										
            _bw.write(_wl_block92Bytes, _wl_block92);

								}
							}
						}
							
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block94Bytes, _wl_block94);
if(record_count == 1 && vol_cnt == 1){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(vol_cnt));
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(record_count == 1 && vol_cnt == 1){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block101Bytes, _wl_block101);
if(record_count == 1 && vol_cnt == 1){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(vol_cnt));
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block104Bytes, _wl_block104);
if(record_count == 1 && vol_cnt == 1){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(vol_cnt));
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block106Bytes, _wl_block106);
if(record_count == 1 && vol_cnt == 1){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block107Bytes, _wl_block107);
}
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block109Bytes, _wl_block109);
if(record_count == 1 && vol_cnt == 1){
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block113Bytes, _wl_block113);

									if(record_count == 1 && vol_cnt == 1){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);

					}
					else if(record_count > 1)
					{
																
						
            _bw.write(_wl_block116Bytes, _wl_block116);

							while(resultSet.next())
							{
								file_no		=	checkForNull(resultSet.getString("file_no"));
								if(file_no.equals(dflt_file_no))
								{
								dfltcnt++;
								selected="selected";
								patient_file_type=file_type_code;
								
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block120Bytes, _wl_block120);
 
								} else{
								
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block123Bytes, _wl_block123);

							}
								}
							
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(fileType));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(file_mandatory_yn));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(fileType));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block137Bytes, _wl_block137);
	}
						
            _bw.write(_wl_block138Bytes, _wl_block138);
	}
				else
				if(file_type_appl_yn.equals("Y"))
				{						
					if(record_count == 0)
					{
						
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(file_mandatory_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(volume_no_appl_yn));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block73Bytes, _wl_block73);

					}
					else if(record_count == 1)
					{
						if(resultSet.next())
						{
							file_type_code		=	checkForNull(resultSet.getString("file_type_code"));
						//	patient_file_type	=	checkForNull(resultSet.getString("file_type_code"));
							file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
							patient_file_type=file_type_code;
						if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm"))
							  {
									confaciliytid=checkForNull(resultSet.getString("facility_id"));
									file_type_code=file_type_code+"~"+confaciliytid;			
							       file_creat_fac_id=confaciliytid;
							  }
										
										
										
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(file_mandatory_yn));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block161Bytes, _wl_block161);

								
							if(volume_no_appl_yn.equals("Y"))
							{
								if((volumeBuffer != null) && (volumeBuffer.length() > 0))
									volumeBuffer.delete(0, volumeBuffer.length());
								
								
							if(form_name.equals("FMReturnToMRDCriteriaForm"))
									{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
									else
								{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
								//volumeBuffer.append(facilityID);
							//	volumeBuffer.append("' and patient_id = '");
								volumeBuffer.append(patientID);
								volumeBuffer.append("' ");
								
							
								if(!patient_file_type.equals("") && (!file_type_code.equals("undefined")))
								{
									volumeBuffer.append(" AND file_type_code = '");
									volumeBuffer.append(patient_file_type);
									volumeBuffer.append("' ");
								}
								volumeBuffer.append(" AND facility_id = '");
							if(form_name.equals("FMReturnToMRDCriteriaForm"))
			                   	{
				           	  if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					            {
								volumeBuffer.append(file_creat_fac_id1);
								} else{
                                 volumeBuffer.append(facilityID);
								   }
								} else if(form_name.equals("FMTransferFileCriteria_form")){
                                           if(file_creat_fac_id1.equals("")) file_creat_fac_id1=file_creat_fac_id;
											volumeBuffer.append(file_creat_fac_id1);
											} else  if(form_name.equals("FMChngStrLocnCriteriaForm")){
                                  	   volumeBuffer.append(file_creat_fac_id1);
								         } 										
											else{
                              volumeBuffer.append(facilityID);
								
								
								}
						    	volumeBuffer.append("' ");
								volumeBuffer.append("ORDER BY volume_no desc ");
									if(volResultSet!=null)	volResultSet.close();
								if(volStatement!=null) volStatement.close();
															
								volStatement	=	
								connection.prepareStatement(volumeBuffer.toString());
							volResultSet	=	volStatement.executeQuery();	
								if(volResultSet != null)
								{
									
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block166Bytes, _wl_block166);
	while(volResultSet.next())
									{
									      vol_cnt++;
												
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dfltslt_cnt));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block177Bytes, _wl_block177);

											dfltslt_cnt++;
											}
									
            _bw.write(_wl_block178Bytes, _wl_block178);

								}
							} 
						}
					}
					else if(record_count > 1)
					{
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block181Bytes, _wl_block181);

							while(resultSet.next())
							{
								file_type_code	=checkForNull(resultSet.getString("file_type_code"));										
								file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
								if(dflt_file_type.equals(file_type_code))
								{
								dfltcnt=1;
								selected="selected";
								patient_file_type=file_type_code;
								file_creat_fac_id=facilityID;
								if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm"))
							  {
									confaciliytid=checkForNull(resultSet.getString("facility_id"));
									file_type_code=file_type_code+"~"+confaciliytid;			
							 		  }
								
								
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block123Bytes, _wl_block123);
 
								}else{
									if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm") )
							  {
									confaciliytid=checkForNull(resultSet.getString("facility_id"));
									file_type_code=file_type_code+"~"+confaciliytid;			
							 		  }
									
									
									
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block186Bytes, _wl_block186);
}
							
							} 
							
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(fileNo));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(fileNo));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(file_mandatory_yn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block197Bytes, _wl_block197);

					
							if(volume_no_appl_yn.equals("Y") && dfltcnt==1)
							{
								if((volumeBuffer != null) && (volumeBuffer.length() > 0))
									volumeBuffer.delete(0, volumeBuffer.length());
								
								
							if(form_name.equals("FMReturnToMRDCriteriaForm"))
									{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
									else
								{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
								//volumeBuffer.append(facilityID);
							//	volumeBuffer.append("' and patient_id = '");
								volumeBuffer.append(patientID);
								volumeBuffer.append("' ");
								
								if(!patient_file_type.equals("") && (!file_type_code.equals("undefined")))
								{
									volumeBuffer.append(" AND file_type_code = '");
									volumeBuffer.append(patient_file_type);
									volumeBuffer.append("' ");
								}
								if(form_name.equals("FMChngStrLocnCriteriaForm"))
								{
								volumeBuffer.append(" AND curr_facility_id = '");
								}else{
								volumeBuffer.append(" AND facility_id = '");
								}
								if(form_name.equals("FMReturnToMRDCriteriaForm"))
			                   	{
				           	  if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					            {
								volumeBuffer.append(file_creat_fac_id1);
								} else{
                                   volumeBuffer.append(facilityID);
								}
										}else{
                              volumeBuffer.append(facilityID);
								
								
								}
									
									volumeBuffer.append("' ");
								volumeBuffer.append("ORDER BY volume_no desc ");
								if(volResultSet!=null)	volResultSet.close();
								if(volStatement!=null) volStatement.close();
					
														
								volStatement	=	connection.prepareStatement(volumeBuffer.toString());
								volResultSet	=	volStatement.executeQuery();	
								if(volResultSet != null)
								{
									
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block198Bytes, _wl_block198);
	while(volResultSet.next())
					{
				     vol_cnt++;
					
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(dfltslt_cnt));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block202Bytes, _wl_block202);

						dfltslt_cnt++;
						}
							
            _bw.write(_wl_block178Bytes, _wl_block178);

								}
							} 
							
							}
				}
			}
		}
		else if((!fileNo.equals("")) && (file_type_appl_yn.equals("N")))
		{
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			
						
			sqlString = "SELECT patient_id FROM mr_pat_file_index WHERE facility_id = ? AND file_no = ? and doc_folder_id is null";
			
			
			preStatement	=	connection.prepareStatement(sqlString);
			
			
			if((form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					{
			preStatement.setString(1, file_creat_fac_id1);
						
					}else if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form"))  && !fileNo.equals(""))
				{
			     preStatement.setString(1, file_creat_fac_id1);
			    }
					else{
                  preStatement.setString(1, facilityID);
						
					}
			
			preStatement.setString(2, fileNo);
				
				resultSet =	preStatement.executeQuery();
				
			
			if((resultSet != null) && (resultSet.next()))
			{
				
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(resultSet.getString("patient_id"))));
            _bw.write(_wl_block203Bytes, _wl_block203);

				patientID =	checkForNull(resultSet.getString("patient_id"));
							}
			else
			{
				
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block205Bytes, _wl_block205);

			}
		}
		if((patline_yn.equals("Y")) && (!patline_ID.equals("")))
		{
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();

			sqlString =	"SELECT decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name FROM mp_patient WHERE patient_id = ? ";

			preStatement = connection.prepareStatement(sqlString);
			preStatement.setString(1, patientID);
			resultSet =	preStatement.executeQuery();

			if((resultSet != null) && (resultSet.next()))
			patient_name = checkForNull(resultSet.getString("patient_name"));
			
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(patline_ID));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block209Bytes, _wl_block209);

		}
		
	if(((!patient_file_type.equals("")) && (file_type_appl_yn.equals("Y"))) || dflt_flag.equals("true"))
		{
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();

			if(form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") )
			{
		preStatement = connection.prepareStatement("SELECT file_no FROM fm_curr_locn where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			
					}
		/*	 else if(form_name.equals("FMConfirmRcptCriteria_form"))
			{
             preStatement = connection.prepareStatement("SELECT file_no FROM fm_curr_locn where facility_id = ? AND file_type_code = ? AND patient_id = ?");

			} */
			else
			{
	//	preStatement = connection.prepareStatement("SELECT file_no FROM mr_pat_file_index where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			preStatement = connection.prepareStatement("SELECT file_no FROM fm_curr_locn where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			}
			
			//preStatement.setString(1, facilityID);
if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form"))
			 {
			preStatement.setString(1,file_creat_fac_id);
 			 }else if(form_name.equals("ManualEntry_form") || form_name.equals("FMReceiveFileMRDSearch") ||  form_name.equals("FMCreateFileVolumeSearchForm")){
			preStatement.setString(1,facilityID);
				  
		   } else
			{
           preStatement.setString(1, facilityID);
		
		//   preStatement.setString(1, facilityID);
			}
			preStatement.setString(2, patient_file_type);
			preStatement.setString(3, patientID);
			resultSet =	preStatement.executeQuery();
			
 		
	 
		if((resultSet != null))
			{
				while(resultSet.next())
				{
				fileNo	=	checkForNull(resultSet.getString("file_no"));
				vol_cntt++;
				
				}
			vol_cnt=vol_cntt;
			
				
				
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(fileNo));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fileNo));
            _bw.write(_wl_block49Bytes, _wl_block49);

			}
								
				
					
					
					
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block213Bytes, _wl_block213);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block214Bytes, _wl_block214);
}
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block216Bytes, _wl_block216);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block218Bytes, _wl_block218);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(vol_cnt));
            _bw.write(_wl_block219Bytes, _wl_block219);
}
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block220Bytes, _wl_block220);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1 && record_count <= 1){
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block222Bytes, _wl_block222);
}
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block224Bytes, _wl_block224);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block226Bytes, _wl_block226);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(vol_cnt));
            _bw.write(_wl_block219Bytes, _wl_block219);
}
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block228Bytes, _wl_block228);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(vol_cnt));
            _bw.write(_wl_block219Bytes, _wl_block219);
}
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block229Bytes, _wl_block229);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block230Bytes, _wl_block230);
}
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block231Bytes, _wl_block231);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block232Bytes, _wl_block232);
}
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block233Bytes, _wl_block233);
if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block234Bytes, _wl_block234);
}
            _bw.write(_wl_block235Bytes, _wl_block235);

		}
				
		if((operation.equals("FILE_VOLUME")) && (volume_no_appl_yn.equals("Y")))
		{
			if((volumeBuffer != null) && (volumeBuffer.length() > 0))
				volumeBuffer.delete(0, volumeBuffer.length());
			
			if((file_type_appl_yn.equals("Y") && !patient_file_type.equals("")) || (file_type_appl_yn.equals("N") && !fileNo.equals("")) || (!dflt_file_type.equals("") && !dflt_file_no.equals("") && record_count>0) )	{

			volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
		
			
			volumeBuffer.append(patientID);
			volumeBuffer.append("' ");
				
			
			if(!fileNo.equals(""))
			{
				volumeBuffer.append(" AND file_no = '");
				volumeBuffer.append(fileNo);
				volumeBuffer.append("' ");
			}
           if(fileNo.equals("") && !dflt_file_no.equals(""))
			{
				volumeBuffer.append(" AND file_no = '");
				volumeBuffer.append(dflt_file_no);
				volumeBuffer.append("' ");
			}
			
			
			if(!patient_file_type.equals("") && (!patient_file_type.equals("undefined")))
			{
				volumeBuffer.append(" AND file_type_code = '");
				volumeBuffer.append(patient_file_type);
				volumeBuffer.append("' ");
			}
			if(patient_file_type.equals("") && (!dflt_file_type.equals("")))
			{
				volumeBuffer.append(" AND file_type_code = '");
				volumeBuffer.append(dflt_file_type);
				volumeBuffer.append("' ");
			}
			
	    	volumeBuffer.append(" AND facility_id = '");
						
			if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !fileNo_old.equals(""))
				{
				
		volumeBuffer.append(file_creat_fac_id1);
				} else if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm")) && fileNo_old.equals(""))
				{
               if(file_creat_fac_id.equals(""))  file_creat_fac_id=facilityID;
				
				volumeBuffer.append(file_creat_fac_id);
				}
				else
				{
        volumeBuffer.append(facilityID);

			}
			volumeBuffer.append("' ");
			volumeBuffer.append("ORDER BY volume_no desc ");
			if(volResultSet!=null)	volResultSet.close();
			if(volStatement!=null) volStatement.close();
        		volStatement	=	connection.prepareStatement(volumeBuffer.toString());
				
		volResultSet	=	volStatement.executeQuery();	
		
			if(volResultSet != null)
			{
				
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block237Bytes, _wl_block237);

				while(volResultSet.next())
				{
					vol_cnt1++;
					
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(dfltslt_cnt));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(dflt_file_type));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(dflt_file_no));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(dflt_flag));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(patient_file_type));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(checkForNull(volResultSet.getString("volume_no"))));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block254Bytes, _wl_block254);

				dfltslt_cnt++;
					}
			}
		}
			
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(file_mov_flag));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(vol_cnt1));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block276Bytes, _wl_block276);

		}
		//	if(record_count==0)
		//	{
				
            _bw.write(_wl_block277Bytes, _wl_block277);

		//	}
	}
	}

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(file_mov_flag));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block292Bytes, _wl_block292);

}


catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	if(preStatement!=null) preStatement.close();
	if(volStatement!=null) volStatement.close();
	if(resultSet!=null)	resultSet.close();
	if(volResultSet!=null)	volResultSet.close();

	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block293Bytes, _wl_block293);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
