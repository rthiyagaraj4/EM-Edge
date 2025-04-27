package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOH.*;
import eOH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __resultentryculturetest extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/ResultEntryCultureTest.jsp", 1742903727169L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    <TITLE>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TITLE>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'/>\n \t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"JavaScript\" src=\"../js/ResultEntry.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>-->\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<Style>   </Style>\n</HEAD>\n<BODY >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<Form name=\'result_culture_test\' id=\'result_culture_test\' action=\'../../eOH/jsp/ResultEntryCultureTestPreview.jsp\'>\n\t<Input name=\'antibiotic_length\' id=\'antibiotic_length\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n    <Input name=\'organism_string\' id=\'organism_string\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n    <Input name=\'chart_no_columns\' id=\'chart_no_columns\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<Table>\n\t\t<TR>\n\t\t\t<td class=\'ORCOLUMNHEADING\'><B><Font COLOR=\'WHITE\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\\";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</Font></B></TD>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<TD class=\'label\'><Select name=\'organism";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'organism";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onChange=\'organismClick(this)\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="><Option value=\'\'> ---";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="---  </Option>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t</Select><Input name=\'column_type";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'column_type";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' type=\'hidden\' value=\'\'></TD>\n\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<TR>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<TD class=\'ORCHARTHEADING\'><B><Font size=\'1\' color=\'WHITE\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</Font></B><Input name=\'antibiotic";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'antibiotic";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'><Input name=\'antibiotic_desc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'antibiotic_desc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><Input name=\'discr_msr_id";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'discr_msr_id";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'><Input name=\'result_type";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'result_type";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'></TD>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<TD class=\'ORCHARTHEADING\' id=\'anti";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="_td\'><Input name=\'anti";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'anti";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' type=\'hidden\' value=\'\' ></TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' type=\'hidden\' value=\'\'></TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<TD class=\'ORROWHEADING\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<Input name=\'antibiotic";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'></TD>\n\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<TD class=\'label\' id=\'anti";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="_td\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<input type=\'text\' name=\'anti";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' size=\'5\' class=\'NUMBER\' onKeyPress=\'return allowValidNumber(this,event,\"+10+\",0)\' onblur=\'antibioticClick(this)\'  maxlength=\'7\'>\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' size=\'5\' class=\'NUMBER\'  onblur=\'antibioticClick(this)\'  maxlength=\'7\'>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\'anti";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' size=\'5\' class=\'NUMBER\' onblur=\'antibioticClick(this)\' maxlength=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onKeyPress=\'return checkValid(this,window.event,";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =",";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =")\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<input type=\'hidden\' name=\'num_uom";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'num_uom";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t<select name=\'anti";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'  onChange=\'antibioticClick(this)\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t<option value=\'\'>-- ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" --</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' selected>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t</Select>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' onBlur=\'antibioticClick(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'anti";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\" style=\'cursor:pointer\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'  onBlur=\'antibioticClick(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'anti";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\',null,\'hh:mm\');\" style=\'cursor:pointer\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' onKeyPress=\'enterCheck()\'  onBlur=\'checkChartTemplateTime(this);antibioticClick(this);\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'anti";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'  onClick=\'checkClick(this);antibioticClick(this)\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t    \t\t\t<Script>\n\t\t\t\t\t\tif (";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" < ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =") {\n\t\t\t\t\t\t\teval(\"document.result_culture_test.organism\"+";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =").disabled = false;\n\t\t\t\t\t\t}\n\t\t\t\t\t</Script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t<TD class=\'ORROWHEADING\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'></TD>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t<TD class=\'label\' id=\'anti";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="_td\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'anti";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'  onKeyPress=\'return checkValid(this,window.event,";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t\t<select name=\'anti";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'  onChange=\'antibioticClick(this)\' >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'\'>-- Select --</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t</Select>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\');\" style=\'cursor:pointer\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' onKeyPress=\'enterCheck()\' onBlur=\'checkChartTemplateTime(this);antibioticClick(this);\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'anti";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' onClick=\'antibioticClick(this)\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t    \t\t\t<Script>\n\t\t\t\t\t\t\t\t\tif (";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =") {\n\t\t\t\t\t\t\t\t\t\teval(\"document.result_culture_test.organism\"+";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =").disabled = false;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</Script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t</TR>\n\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t</Table>\n\t<Script>\n\t\tdocument.result_culture_test.antibiotic_length.value = \'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\';\n\t\t//alert(document.result_culture_test.antibiotic_length.value);\n\t</Script>\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t<Script>\n\t\t\t\torganismClick(document.result_culture_test.organism";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =");\n\t\t\t</Script>\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n   \t\t\t\t\t<Script>document.result_culture_test.anti";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =".value = \'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'</Script>\n   \t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\n</Form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
 try{
	String bean_id = "Oh_ResultEntry" ;
	
	String bean_name = "eOH.ResultEntryBean";
	String index	= request.getParameter("index");
	String chart_result_type = request.getParameter("chart_result_type");
	if (chart_result_type == null) chart_result_type = "";
	String antibiotic_organism_reqd_yn = request.getParameter("antibiotic_organism_reqd_yn");
	String remarks = request.getParameter("remarks");
	if (index == null) index = "0";
	if (antibiotic_organism_reqd_yn == null) antibiotic_organism_reqd_yn = "";
	if (remarks == null) remarks = "";
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	String organism_string		= "";
	ArrayList headingDetails	= bean.getChartHeadingDetails(chart_result_type);
	String horizontalHeading	= "";
	String verticalHeading		= "";
	int	chart_no_columns		= 0;
	ArrayList organismDetails	= bean.getOrganismDetails(chart_result_type);

	/*String organismString		= "";
    if (organismDetails != null) {
		for (int i=0; i < organismDetails.size(); i++) {
			String [] record = (String[])organismDetails.get(i);
			organismString += "<option value='"+record[1]+"'>"+record[0]+"</option>";
		}
	}*/
	if (headingDetails != null &&headingDetails.size() > 0) {
		String [] headingRecord = (String[])headingDetails.get(0);
		verticalHeading			= bean.checkForNull(headingRecord[0]);
		horizontalHeading		= bean.checkForNull(headingRecord[1]);
		chart_no_columns		= Integer.parseInt(bean.checkForNull(headingRecord[2],"0"));
	}

	int columnCounter			= 0;
	int prevIndx				= 0;
	int currIndx				= 0;

	ArrayList antibioticValues	= bean.getAntibioticDetails(chart_result_type);
	if (antibioticValues == null) antibioticValues = new ArrayList();

	HashMap parentMap 	=	bean.getCultureTestRecord();
	HashMap map			= new HashMap();

	if (parentMap != null && parentMap.containsKey(index))
		map = (HashMap)parentMap.get(index);

	


            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(antibioticValues.size()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(organism_string));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(chart_no_columns));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(horizontalHeading));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(verticalHeading));
            _bw.write(_wl_block17Bytes, _wl_block17);
for (int i = 0; i < chart_no_columns; i++) {
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((!((map.containsKey("organism"+i))?(String)map.get("organism"+i):"").equals("")) || (i == 0))?"":"disabled"));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 //organismDetails = null;
				if (organismDetails != null) {
					for (int j=0; j < organismDetails.size(); j++) {
						String [] record = (String[])organismDetails.get(j);
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(eHISFormatter.select((map.containsKey("organism"+i) || record[2].equals(""+(i+1)))?((map.containsKey("organism"+i))?(String)map.get("organism"+i):record[1]):"",record[1])));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
				}
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
for (int i=0;i < antibioticValues.size();i++) {
			String record [] 			= (String[])antibioticValues.get(i);
			String discr_msr_id			= bean.checkForNull(record[3]);
			String result_type			= bean.checkForNull(record[4]);
			String copy_prev_vert_yn	= bean.checkForNull(record[5]);
		
            _bw.write(_wl_block32Bytes, _wl_block32);
 

			
            _bw.write(_wl_block33Bytes, _wl_block33);
if (discr_msr_id.equals("")) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
	prevIndx	= currIndx;
				currIndx	= i;
				if (discr_msr_id.equals("") && record[5].equals("N")) {

				
            _bw.write(_wl_block45Bytes, _wl_block45);
for (int j=0;j < chart_no_columns; j++) {
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
}

				} else if (discr_msr_id.equals("") && record[5].equals("Y")) {
					for (int j=0;j < chart_no_columns; j++) {
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
				}
			} else {
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_type));
            _bw.write(_wl_block53Bytes, _wl_block53);
for (int j=0;j < chart_no_columns; j++) {
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
  boolean default_value = false;
				if (result_type.equals("I")) {
					
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
				if (result_type.equals("H")) {
					
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block59Bytes, _wl_block59);
	}
						if (result_type.equals("N")) {
						
							int maxlength = 1;
							if(record[6]==null || record[6].trim().equals(""))
								record[6] = "0";
							if(record[8]==null || record[8].equals("") || record[8].equals("0")) {
								maxlength = Integer.parseInt(record[6]);
								record[8] = "0";
							} else {
								maxlength = Integer.parseInt(record[8]) + Integer.parseInt(record[8]) + 1;
							}

							String[] record1 = new String[6];
							record1 = bean.getNumericResultTypeDetails(discr_msr_id);

							for(int indx=0; indx<record1.length; indx++)
								if(record1[indx]== null) record1[indx]="";

							double max_val	= 0;
							double min_val	= 0;
							if (!record1[2].equals("")) max_val	= Double.parseDouble(record1[2]);
							if (!record1[1].equals("")) min_val	= Double.parseDouble(record1[1]);
						
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(maxlength));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(record1[0]));
            out.print( String.valueOf((max_val != 0.0 && min_val !=0.0)?"("+min_val+"-"+max_val+")":""));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record1[0]));
            _bw.write(_wl_block67Bytes, _wl_block67);
} else if (result_type.equals("L")) {
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block69Bytes, _wl_block69);
	ArrayList listItems = bean.getListResultTypeDetails(discr_msr_id);

							//String option_string	= "";
							int selectedCount		= 0;
							//out.println("<select name='result_"+i+"' id='result_"+i+"' onchange='onListChange("+i+")' "+disabled+" "+disabled1+">");
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
if(listItems!=null) {
								for(int k=0; k<listItems.size(); k++) {
									String[] listValues = new String[4];
									listValues = (String[])listItems.get(k);
									if(listValues[1]!=null && listValues[1].equalsIgnoreCase("Y")) {
										default_value = true;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(listValues[2]));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(listValues[0]));
            _bw.write(_wl_block74Bytes, _wl_block74);
	selectedCount++;
									} else if (map.containsKey(columnCounter+""+j) && ((String)map.get(columnCounter+""+j)).equals(listValues[2])) {
										default_value = true;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(listValues[2]));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(listValues[0]));
            _bw.write(_wl_block74Bytes, _wl_block74);
	selectedCount++;
									} else {
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(listValues[2]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(listValues[0]));
            _bw.write(_wl_block74Bytes, _wl_block74);
}
								}
							}
            _bw.write(_wl_block76Bytes, _wl_block76);
} else if (result_type.equals("D")) {
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block78Bytes, _wl_block78);
} else if (result_type.equals("E")) {
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block80Bytes, _wl_block80);
} else if (result_type.equals("T")) {
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block81Bytes, _wl_block81);
} else if (result_type.equals("C")) {
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
					
            _bw.write(_wl_block84Bytes, _wl_block84);
	if ((((!((map.containsKey("organism"+j))?(String)map.get("organism"+j):"").equals("")) || (j == 0)) && ((map.containsKey(columnCounter+""+j)) && map.get(columnCounter+""+j) != null && (!((String)map.get(columnCounter+""+j)).equals("") ))) || default_value){
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(j+1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(chart_no_columns));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(j+1));
            _bw.write(_wl_block88Bytes, _wl_block88);
}

				}
			}
			columnCounter++;
			
            _bw.write(_wl_block89Bytes, _wl_block89);
 	if (copy_prev_vert_yn.equals("Y")) {
				//out.println("<script>alert('"+prevIndx+","+currIndx+","+chart_result_type+"')</script>");
				for(int rowIndx = prevIndx; rowIndx < currIndx; rowIndx++) {
					String tempRecord [] 		= (String[])antibioticValues.get(rowIndx);
					String tempDiscr_msr_id			= bean.checkForNull(tempRecord[3]);
					String tempResult_type			= bean.checkForNull(tempRecord[4]);
					//String tempCopy_prev_vert_yn	= bean.checkForNull(tempRecord[5]);
					
					
            _bw.write(_wl_block90Bytes, _wl_block90);
if (tempDiscr_msr_id.equals("")) {
            _bw.write(_wl_block91Bytes, _wl_block91);
} else {
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(tempRecord[0]));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempRecord[1]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempRecord[0]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempDiscr_msr_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tempResult_type));
            _bw.write(_wl_block93Bytes, _wl_block93);
for (int j=0;j < chart_no_columns; j++) {
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block95Bytes, _wl_block95);
  boolean default_value = false;
									if (tempResult_type.equals("N")) {
                                        int maxlength = 1;
										if(tempRecord[6]==null || tempRecord[6].trim().equals(""))
											tempRecord[6] = "0";
										if(tempRecord[8].equals("") || tempRecord[8].equals("0")) {
											maxlength = Integer.parseInt(tempRecord[6]);
											tempRecord[8] = "0";
										} else {
											maxlength = Integer.parseInt(tempRecord[8]) + Integer.parseInt(tempRecord[8]) + 1;
										}

										String[] record1 = new String[6];
										record1 = bean.getNumericResultTypeDetails(tempDiscr_msr_id);

										for(int indx=0; indx<record1.length; indx++)
											if(record1[indx]== null) record1[indx]="";

										double max_val	= 0;
										double min_val	= 0;
										if (!record1[2].equals("")) max_val	= Double.parseDouble(record1[2]);
										if (!record1[1].equals("")) min_val	= Double.parseDouble(record1[1]);
									
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(maxlength));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(tempRecord[6]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tempRecord[8]));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(record1[0]));
            out.print( String.valueOf((max_val != 0.0 && min_val !=0.0)?"("+min_val+"-"+max_val+")":""));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(record1[0]));
            _bw.write(_wl_block98Bytes, _wl_block98);
} else if (tempResult_type.equals("L")) {
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block100Bytes, _wl_block100);
	ArrayList listItems = bean.getListResultTypeDetails(tempDiscr_msr_id);

										//String option_string	= "";
										int selectedCount		= 0;
										//out.println("<select name='result_"+i+"' id='result_"+i+"' onchange='onListChange("+i+")' "+disabled+" "+disabled1+">");
            _bw.write(_wl_block101Bytes, _wl_block101);
if(listItems!=null) {
											for(int k=0; k<listItems.size(); k++) {
												String[] listValues = new String[4];
												listValues = (String[])listItems.get(k);
												if (map.containsKey(columnCounter+""+j) && ((String)map.get(columnCounter+""+j)).equals(listValues[2])) {
													default_value = true;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(listValues[2]));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(listValues[0]));
            _bw.write(_wl_block103Bytes, _wl_block103);
	selectedCount++;
												}else if((map.containsKey(columnCounter+""+j) && ((String)map.get(columnCounter+""+j)).equals("")) && (listValues[1]!=null && listValues[1].equalsIgnoreCase("Y"))) {
													default_value = true;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(listValues[2]));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(listValues[0]));
            _bw.write(_wl_block103Bytes, _wl_block103);
	selectedCount++;
												} else {
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(listValues[2]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(listValues[0]));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
											}
										}
            _bw.write(_wl_block104Bytes, _wl_block104);
} else if (tempResult_type.equals("D")) {
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block105Bytes, _wl_block105);
} else if (tempResult_type.equals("E")) {
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block105Bytes, _wl_block105);
} else if (tempResult_type.equals("T")) {
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block106Bytes, _wl_block106);
} else if (tempResult_type.equals("C")) {
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(columnCounter));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((map.containsKey(columnCounter+""+j))?((String)map.get(columnCounter+""+j)):""));
            _bw.write(_wl_block108Bytes, _wl_block108);
}
								
            _bw.write(_wl_block109Bytes, _wl_block109);
	if ((((!((map.containsKey("organism"+j))?(String)map.get("organism"+j):"").equals("")) || (j == 0)) && ((map.containsKey(columnCounter+""+j)) && map.get(columnCounter+""+j) != null && (!((String)map.get(columnCounter+""+j)).equals("") ))) || default_value){
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(j+1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(chart_no_columns));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(j+1));
            _bw.write(_wl_block112Bytes, _wl_block112);
}
							}
            _bw.write(_wl_block91Bytes, _wl_block91);
	columnCounter++;
						}
            _bw.write(_wl_block113Bytes, _wl_block113);
}
			}
		}
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(columnCounter));
            _bw.write(_wl_block115Bytes, _wl_block115);
for (int i = 0; i < chart_no_columns; i++) {
		if ((map.containsKey("organism"+i)) && (!((String)map.get("organism"+i)).equals(""))) {
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
}
	}
	for (int i=0;i < antibioticValues.size();i++) {
		for (int j=0;j < chart_no_columns; j++) {
   			if (map.containsKey(i+""+j)) {
   				if (map.get(i+""+j) != null) {
   					//out.println("<script>alert('"+(String)map.get(i+""+j)+"')</script>");
					   
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((String)map.get(i+""+j)));
            _bw.write(_wl_block120Bytes, _wl_block120);
}
   			}
		}
	}
	
            _bw.write(_wl_block121Bytes, _wl_block121);
            _bw.write(_wl_block122Bytes, _wl_block122);

putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	out.println("====exception====="+e.toString());
	e.printStackTrace();
}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CultureTest.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
