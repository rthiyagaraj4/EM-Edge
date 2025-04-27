package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __newbornlistdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/NewBornListDetails.jsp", 1736397727061L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n   ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n   <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<!-- ****  Modified by kishor kumar n on 02/12/2008 for crf0387 applied new css grid. **** -->\n\t\t\n\t\t\n   <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n   <script language=\'javascript\' src=\'../../eCA/js/NewBornList.js\'></script>\n   <script language=\'javascript\' src=\'../../eCA/js/CAMenu.js\'></script>\n   <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n   <script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script> <!-- 32902 -->\n   <style>\n   thead\n\t\t{\n\t\t\tposition: sticky;\n\t\t\ttop: 0px; \n\t\t\tz-index: 1;\n\t\t}\n   </style>\n   </head>\n<body   onMouseDown=\"CodeArrest()\" onScroll=\'moveFrame()\' onKeyDown=\"lockKey()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<div id=\'divDataTitle\' style=\'position:relative\'>\n<table id=\'PatCriteriaTb\'  width=\'100%\' class=\'grid\'><!--IN032364-->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr>\n\t\t\t<td width=\'\' nowrap class=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">&nbsp;</td>\n\t\t\t<td width=\'\' nowrap ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" class=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td width=\'\' nowrap class=\'gridData\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td><!-- ML-MMOH-CRF-1778 -->\n\t\t\t<td width=\'\' nowrap class=\'gridData\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td width=\'\' nowrap class=\'gridData\' onMouseOut=\"clearLayer()\"  onMouseOver=\"showMotherDetail(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',this)\">\n\t\t\t\t\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:patOpenChart(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\">\n\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</a>\n\t\t\t\t<!-- \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' added above for IN072994 -->\n\t\t\t</td>\n\t\t\t<td width=\'\' nowrap class=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" width= >&emsp;\n\t\t\t\t<font size=1> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\n\t\t\t</td>\n\t\t\t<td width=\'\' nowrap class=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >&emsp;\n\t\t\t\t<font size=1> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">&emsp;\n\t\t\t\t<font size=1> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >&emsp;\n\t\t\t\t<font size=1> <font  size=1>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >&emsp;&emsp;&emsp;\n\t\t\t    <font size=1> ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >&emsp;&emsp;&emsp;\n\t\t\t      <font size=1> ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\n\t\t\t\t\t<!-- \'&emsp\'  above for 22856 -->\n\t\t\t</td>\n\t\t\t</tr>\n    \t    \n\t\t\t<!-- <tr> \n\t\t\t<td width=\'2%\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>&nbsp;</td>\n\t\t\t<td width=\'2%\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\t\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'25%\' class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onMouseOut=\'clearLayer()\' onMouseOver= \"showMotherDetail(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',this)\">\n\t\t\t\t\t<font size=1><a href=\"javascript:patOpenChart(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a>\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'3%\' class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'5%\' class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'10%\'  class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'6%\' class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t\t\t<font  size=1>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t<td width=\'5%\'  class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t</font>\n\t\t\t</td>\n\t\t\t</tr>-->\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n<script>\n\tMotherDetails[";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="]=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";MotherName[";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\nscan_count_required_yn[";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";alert_required_yn[";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";remarks_required_yn[";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";//Added for IN072994\n</script>\n<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"  name=\"restPatientYN";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'><!-- 32902  --> \n<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'><!-- 32902  --> \n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n</table>\n\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n<input type=\"hidden\" name=\"reln_ReqYn\" id=\"reln_ReqYn\" value=\"\">\n<input type=\"hidden\" name=\"reln_Yn\" id=\"reln_Yn\" value=\"\">\n<input type=\"hidden\" name=\"insert_op\" id=\"insert_op\" value=\"N\">\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n<input type=\"hidden\" name=\"reOrder\" id=\"reOrder\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<input type=\"hidden\" name=\"anchorID\" id=\"anchorID\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<input type=\"hidden\" name=\"scrol\" id=\"scrol\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\'hidden\' name=\'called_function_id\' id=\'called_function_id\' value= \'NEW_BORN\'> \n<input type=\'hidden\' name=\"relnreqyn\" id=\"relnreqyn\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\n<input type=\'hidden\' name=\"decease\" id=\"decease\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\n</form>\n<div id=\'motherLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\';\n\t\t\t}\n\t\t\tif(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'==\'1\')\n\t\t\t\t{\n\t\t\t\t\t//top.content.workAreaFrame.NewBornTitleFrame.document.NewBornTitleForm.document.getElementById(\"PatCriteriaTbl\").all.";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =".style.color=\'pink\';\n\t\t\t\t\ttop.content.workAreaFrame.NewBornTitleFrame.document.getElementById(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\').style.color=\'pink\';\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'==\'2\')\n\t\t\t\t\t//top.content.workAreaFrame.NewBornTitleFrame.document.NewBornTitleForm.document.getElementById(\"PatCriteriaTbl\").all.";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =".style.color=\'yellow\';\n\t\t\t\t\ttop.content.workAreaFrame.NewBornTitleFrame.document.getElementById(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\').style.color=\'yellow\';\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\n\n<script>\n\n\nconst newHeaderRow = `<tr>\n<td class=\'COLUMNHEADERCENTER\'  rowspan=2 width=\'\' nowrap >&nbsp;</td>\n<td class=\'COLUMNHEADERCENTER\'  rowspan=2 width=\'\' nowrap >&nbsp;</td>\n<!-- //22856-start-->\n<td class=\'COLUMNHEADERCENTER\'  rowspan=2 width=\'\' nowrap align=\"left\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n <!-- //22856-End-->\n<td class=\'COLUMNHEADERCENTER\'  rowspan=2 width=\'\' nowrap align=\"left\"><a id=\'a1\'   href=\"javascript:callOrderBy(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</a></td>\n<td class=\'COLUMNHEADERCENTER\'  rowspan=2 width=\'\' nowrap align=\"left\"><a id=\'a2\'   href=\"javascript:callOrderBy(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</a></td>\n<td class=\'COLUMNHEADERCENTER\'  rowspan=2 width=\'\' nowrap align=\"left\"><a id=\'a3\'   href=\"javascript:callOrderBy(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</a></td>\n<td class=\'COLUMNHEADERCENTER\'  rowspan=2 width=\'\' nowrap align=\"left\"><a id=\'a4\'   href=\"javascript:callOrderBy(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a></td>\n<td class=\'COLUMNHEADERCENTER\'   rowspan=2  width=\'\' nowrap align=\"left\"><a id=\'a5\'   href=\"javascript:callOrderBy(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a></td>\n<td class=\'COLUMNHEADERCENTER\'   width=\'\' nowrap colspan=3  style=\'color:white\' align=\"left\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n<td class=\'COLUMNHEADERCENTER\'   rowspan=2 width=\'\' nowrap align=\"left\"><a id=\'a6\'   href=\"javascript:callOrderBy(\'MN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</a></td>\n<td class=\'COLUMNHEADERCENTER\'   rowspan=2 width=\'\' nowrap style=\'color:white\' align=\"left\">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n</tr>\n\n<tr>\n<td class=\'COLUMNHEADERCENTER\'  width=\'\' nowrap align=\"left\" >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n<td class=\'COLUMNHEADERCENTER\'  width=\'\' nowrap align=\"left\" >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n<td class=\'COLUMNHEADERCENTER\'  width=\'\' nowrap align=\"left\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n</tr>`;\n\n\n// Get the table by its ID\nconst table = document.getElementById(\'PatCriteriaTb\');\n\n//Check if the table exists\nif (table) {\n// Get or create the <thead> element\nlet thead = table.querySelector(\'thead\');\nif (!thead) {\nthead = document.createElement(\'thead\');\ntable.prepend(thead);\n}\n\n// Add the new header row to the <thead>\nthead.innerHTML += newHeaderRow;\n} else {\nconsole.error(\"Table with ID \'PatCriteriaTb\' not found.\");\n}\ndocument.getElementById(\'PatCriteriaTb\').style.marginTop=\"0px\";\nparent.document.getElementById(\'NewBornTitleFrame\').style.display=\"none\";\n</script>\n\n\t\t\n<script>\n\t\t\n\t\tif(parent.NewBornTitleFrame.document.getElementById(\"PatCriteriaTbl\")==null)\n\t\t{\n\t\t\t\n\t\t\tsetTimeout(\"alignHeading();\",300);\n\t\t}\n\t\telse \n\t\t\talignHeading();\n</script>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t<script>\n\t\tif(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'!=\'\')\n\t\t{\n\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\';\n\t\t}\n\t\tif(\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'!=\'\')\n\t\t{   //*** added to make all anchors white before making the selcted one pink\n\t\t\t// Get all anchor tags in the document\n\t\t\tconst anchors = document.querySelectorAll(\'a\');\n\n\t\t\t// Filter anchor tags where the id contains \'a\'\n\t\t\tconst filteredAnchors = Array.from(anchors).filter(anchor => anchor.id.includes(\'a\'));\n\n\t\t\tfor(i=0;i<filteredAnchors.length;i++)\n\t\t\t{\n\t\t\t\tfilteredAnchors[i].style.color=\'white\';\n\n\t\t\t}\n\t\t\t//***\n\t\t\tif(\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'==\'1\')\n\t\t\t{\n\t\t\t\t//document.getElementById(\"PatCriteriaTbl\").";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =".style.color=\'pink\';\n\t\t\t\tdocument.getElementById(\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\').style.color=\'pink\';\n\t\t\t}\n\t\t\telse if(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'==\'2\')\n\t\t\t{\n\t\t\t\t//document.getElementById(\"PatCriteriaTbl\").";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =".style.color=\'yellow\';\n\t\t\t\tdocument.getElementById(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\').style.color=\'yellow\';\n\t\t\t}\n\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\n\n</body>\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );
	
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
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History			Name			Description
--------------------------------------------------------------------------------------------------------------
?				100						?           created
18/04/2012		IN030318				Ramesh G		This age of the newborn is displayed in the newborn list in location list as well as in the patient banner in patient?s chart.	
24/04/2012		IN032435,IN032437		Ramesh G		The age of new born is displayed as Null.							
13/07/2012    	IN032364       			Nijitha S     Alignment is not proper in New Born List.					
20/08/2012		IN029180		        Chowminya G		 The system is not running by sequence number of newborn.
08/07/2020     IN072994          Chandrashekar raju    	08/07/2020			Ramesh G              Modified for MMS-DM-CRF-0170.1	
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
11/08/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
---------------------------------------------------------------------------------------------------------------

*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con =null;
PreparedStatement pstmt = null;
ResultSet rsPatList=null;
PreparedStatement pstmt1 = null;//Added for IN072994
ResultSet resultSet=null;//Added for IN072994


Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");

//32902 start
String restPatientYN	=	"";
String ca_bean_id 						= "@CACommonGetPatientDtlBean";
String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
int accessRightsViewPatient=0;
//32902 end
try
{
con = ConnectionManager.getConnection(request);
/* criteria parameters */
String admit=request.getParameter("admit")==null?"":request.getParameter("admit");
String health=request.getParameter("health")==null?"":request.getParameter("health");
String decease=request.getParameter("decease")==null?"":request.getParameter("decease");
String newbornid=request.getParameter("newbornid")==null?"":request.getParameter("newbornid");
String motherid=request.getParameter("motherid")==null?"":request.getParameter("motherid");
String newbornenc=request.getParameter("newbornenc")==null?"":request.getParameter("newbornenc");
String locationCode=request.getParameter("locationCode")==null?"":request.getParameter("locationCode");
String clinicianId =(String)session.getValue("ca_practitioner_id");
String facility_id=(String)session.getValue("facility_id");
accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902

if(facility_id == null) facility_id="";

String orderBy = request.getParameter("ID")==null?"":request.getParameter("ID");
String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
String relnreqyn= request.getParameter("reln_req_yn")==null?"":request.getParameter("reln_req_yn");
StringBuffer QueryString=new StringBuffer();
String sex="";
String bar_code_scan_site_YN =request.getParameter("bar_code_scan_site_YN")==null?"":request.getParameter("bar_code_scan_site_YN");//Added for IN072994

int i=1;

//QueryString.append(" select A.PATIENT_ID,C.PATIENT_NAME,TO_CHAR(A.TIME_OF_BIRTH,'DD/MM/YYYY HH24:MI') DOB,decode(C.SEX,'M','Male','F','Female','Unknown') sex ,	(select D.SHORT_DESC from ip_nursing_unit d where D.FACILITY_ID =B.FACILITY_ID AND D.NURSING_UNIT_CODE=B.PAT_CURR_LOCN_CODE) LOCATION_DESC,BABY_ENC.BED_NUM BASINET_NO,(SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID=A.MOTHER_PATIENT_ID) MOTHER_NAME,baby_enc.encounter_id, baby_enc.patient_class,(SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=B.FACILITY_ID AND NURSING_UNIT_CODE=BABY_ENC.NURSING_UNIT_CODE) BABY_LOCN,BABY_ENC.ROOM_NUM BABY_ROOM_NUM,CASE WHEN baby_enc.encounter_id IS NOT NULL THEN BABY_ENC.BED_NUM  ELSE (SELECT BED_NO FROM IP_NURSING_UNIT_BED WHERE /*FACILITY_ID=b.facility_id AND NURSING_UNIT_CODE=B.NURSING_UNIT_CODE AND MAIN_BED_NO=B.BED_NUM AND*/ OCCUPYING_PATIENT_ID = A.patient_id AND ROWNUM=1) END BABY_BED_NUM ,(SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=B.FACILITY_ID AND NURSING_UNIT_CODE=B.NURSING_UNIT_CODE) MOTHER_LOCN,B.ROOM_NUM MOTHER_ROOM_NUM,B.BED_NUM MOTHER_BED_NUM,GET_AGE(A.TIME_OF_BIRTH) AGE,CA_GET_PATIENT_CURR_STATUS(a.ENCOUNTER_FACILITY_ID,a.patient_id,baby_enc.encounter_id,NVL2(baby_enc.encounter_id,'IP','XT'),?) status, b.patient_id mother_patient_id, to_char(b.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') mother_adm_date,(select get_age(date_of_birth) from mp_patient where patient_id=b.patient_id) mother_age from ip_open_encounter b ,MP_BIRTH_REGISTER A ,MP_PATIENT C ,(select patient_id,encounter_id,patient_class,NURSING_UNIT_CODE,ROOM_NUM,BED_NUM from ip_open_encounter where adt_status in ('01','08','09')) baby_enc where  b.facility_id = a.ENCOUNTER_FACILITY_ID and b.encounter_id = a.MOTHER_ENCOUNTER_ID and c.patient_id = a.patient_id   and baby_enc.patient_id(+)=a.patient_id  and a.ENCOUNTER_FACILITY_ID=? ");

//QueryString.append(" select A.PATIENT_ID,replace(decode(?,'en',C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME,TO_CHAR(A.TIME_OF_BIRTH,'DD/MM/YYYY HH24:MI')DOB,sex,IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,b.pat_curr_locn_code,?,'1') LOCATION_DESC,BABY_ENC.BED_NUM BASINET_NO,(SELECT replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') FROM MP_PATIENT WHERE PATIENT_ID=A.MOTHER_PATIENT_ID) MOTHER_NAME,baby_enc.encounter_id,baby_enc.patient_class,IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,BABY_ENC.NURSING_UNIT_CODE,?,'1') BABY_LOCN,BABY_ENC.ROOM_NUM BABY_ROOM_NUM,CASE WHEN baby_enc.encounter_id IS NOT NULL THEN BABY_ENC.BED_NUM ELSE(SELECT BED_NO FROM IP_NURSING_UNIT_BED WHERE OCCUPYING_PATIENT_ID = A.patient_id AND ROWNUM=1) END BABY_BED_NUM ,IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,B.NURSING_UNIT_CODE,?,'1')MOTHER_LOCN,B.ROOM_NUM MOTHER_ROOM_NUM,B.BED_NUM MOTHER_BED_NUM,GET_AGE(A.TIME_OF_BIRTH) AGE,CA_GET_PATIENT_CURR_STATUS(a.ENCOUNTER_FACILITY_ID,a.patient_id,baby_enc.encounter_id,NVL2(baby_enc.encounter_id,'IP','XT'),?) status, b.patient_id mother_patient_id, to_char(b.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') mother_adm_date,(select get_age(date_of_birth) from mp_patient where patient_id=b.patient_id) mother_age from ip_open_encounter b ,MP_BIRTH_REGISTER A ,MP_PATIENT C ,(select patient_id,encounter_id,patient_class,NURSING_UNIT_CODE,ROOM_NUM,BED_NUM from ip_open_encounter where adt_status in ('01','08','09')) baby_enc where  /* a.OUTCOME='L' and*/  b.facility_id = a.ENCOUNTER_FACILITY_ID and b.encounter_id = a.MOTHER_ENCOUNTER_ID and c.patient_id = a.patient_id   and baby_enc.patient_id(+)=a.patient_id  and a.ENCOUNTER_FACILITY_ID=? ");

//[IN030318] QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, get_age (bpi.DATE_OF_BIRTH,nvl(bpi.DECEASED_DATE,sysdate)) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");
// [IN032435] QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, MP_GET_AGE_YMDH(bpi.date_of_birth,bpi.DECEASED_DATE) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");
// [IN032437] QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, nvl(MP_GET_AGE_YMDH(bpi.date_of_birth,bpi.DECEASED_DATE),get_age (bpi.DATE_OF_BIRTH,nvl(bpi.DECEASED_DATE,sysdate))) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");

//QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, CA_GET_AGE_IN_HRS (bpi.date_of_birth,bpi.DECEASED_DATE) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");
QueryString.append("SELECT a.patient_id,REPLACE (DECODE (?,'en', bpi.patient_name, NVL (bpi.patient_name_loc_lang, bpi.patient_name) ), '''','' ) patient_name, TO_CHAR (a.time_of_birth, 'DD/MM/YYYY HH24:MI') dob, bpi.sex, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.pat_curr_locn_code,?,'1' ) location_desc, bei.bed_num basinet_no, DECODE (?,'en', mpi.patient_name, NVL (mpi.patient_name_loc_lang, mpi.patient_name) ) mother_name, bei.encounter_id, bei.patient_class, ip_get_desc.ip_nursing_unit (bei.facility_id, bei.nursing_unit_code,?,'1') baby_locn, bei.room_num baby_room_num, bei.bed_num baby_bed_num, ip_get_desc.ip_nursing_unit (mei.facility_id, mei.nursing_unit_code,?,'1') mother_locn, mei.room_num mother_room_num, mei.bed_num mother_bed_num, CA_GET_AGE_IN_HRS (bpi.date_of_birth,bpi.DECEASED_DATE) age,ca_get_patient_curr_status (a.encounter_facility_id, a.patient_id, bei.encounter_id, NVL2 (bei.encounter_id, 'IP', 'XT'),? ) status, mei.patient_id mother_patient_id, TO_CHAR (mei.admission_date_time,'dd/mm/yyyy hh24:mi') mother_adm_date, get_age (mpi.date_of_birth) mother_age,  bpi.DECEASED_YN,bpi.restrict_reinstate_yn  FROM ip_open_encounter mei, mp_birth_register a, mp_patient mpi, mp_patient bpi, ip_open_encounter bei WHERE mei.facility_id = ? AND a.encounter_facility_id=mei.facility_id AND a.mother_encounter_id  =mei.encounter_id  AND mpi.patient_id = a.mother_patient_id AND bpi.patient_id = a.patient_id AND bei.patient_id(+) = a.patient_id ");

if (!locationCode.equals("*ALL"))
	QueryString.append(" and ( exists ( select 1 from ip_open_encounter where PATIENT_ID=a.patient_id and PAT_CURR_LOCN_CODE=? ) or mei.PAT_CURR_LOCN_CODE=? )") ;

if((admit.equals("N") || health.equals("N") ))
{
    if (admit.equals("Y"))
	{
		if (decease.equals("N"))
			QueryString.append(" and exists (select 1 from ip_open_encounter where patient_id=a.patient_id and adt_status in ('01','08','09') ) and exists (select 1 from ip_open_encounter where patient_id=a.mother_patient_id )");
		else
			QueryString.append(" and (exists (select 1 from ip_open_encounter where patient_id=a.patient_id and adt_status in ('01','08','09') ) and exists (select 1 from ip_open_encounter where patient_id=a.mother_patient_id ) or  bpi.DECEASED_YN ='Y' ) ");
	}
	else
	{
		if(decease.equals("N"))
			QueryString.append(" and not exists (select 1 from ip_open_encounter where patient_id=a.patient_id) ");
		else
			QueryString.append(" and ( not exists (select 1 from ip_open_encounter where patient_id=a.patient_id) or  bpi.DECEASED_YN ='Y' ) ");
	}
}
if(decease.equals("N"))
{
	QueryString.append("and bpi.DECEASED_YN ='N'");
}
else if((admit.equals("N") && health.equals("N") ))
{
	QueryString.append("and  bpi.DECEASED_YN ='Y'");
}

if (!newbornid.equals(""))
	QueryString.append(" and a.patient_id=? ");

if (!motherid.equals(""))
	QueryString.append(" and a.MOTHER_PATIENT_ID=? ");

if (!newbornenc.equals(""))
	QueryString.append("  and bei.encounter_id  =? ");

QueryString.append(" AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,bpi.patient_id,mei.facility_id) "); //32902  

if(orderBy.equals("PID"))
{QueryString.append(" order by PATIENT_ID ");}
else if(orderBy.equals("PN"))
{QueryString.append(" order by PATIENT_NAME ");}
else if(orderBy.equals("DOB")||orderBy.equals("AGE"))
{QueryString.append(" order by TIME_OF_BIRTH ");}
else if(orderBy.equals("SEX"))
{QueryString.append(" order by SEX ");}
else if(orderBy.equals("MN"))
{QueryString.append(" order by 7 ");}
else
{QueryString.append(" order by PATIENT_ID ");}//Modified --[IN029180]

if(reOrder.equals("2"))
	QueryString.append(" desc");

out.println("<form name='NewBornForm' id='NewBornForm' action='OpenChartWrapper.jsp' method = 'post' target=messageFrame  OnMouseDown='CodeArrest()' OnKeyDown='disableKeys()'>"); 

            _bw.write(_wl_block2Bytes, _wl_block2);


int k=0, rowindex =1,r=1; 

String rowclass = "gridData";


pstmt = con.prepareStatement(QueryString.toString());

pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,locale);
pstmt.setString(rowindex++,clinicianId);
pstmt.setString(rowindex++,facility_id);
//pstmt.setString(rowindex++,clinicianId);
//pstmt.setString(rowindex++,facility_id);
if (!locationCode.equals("*ALL"))
{
 pstmt.setString(rowindex++,locationCode);
 pstmt.setString(rowindex++,locationCode);
}
if (!newbornid.equals(""))
	pstmt.setString(rowindex++,newbornid);

if (!motherid.equals(""))
	pstmt.setString(rowindex++,motherid);

if (!newbornenc.equals(""))
	pstmt.setString(rowindex++,newbornenc);
pstmt.setString(rowindex++,clinicianId); //32902

rsPatList = pstmt.executeQuery();


String patientid= "";
String encounterid= "";
String patientclass= "";
String status="";
String relationYn="";
String newbornclass="";
String text="&nbsp;";
String style="";
String deceasedYn = "";
String localeDate = "";
int count=1;//22856


            _bw.write(_wl_block9Bytes, _wl_block9);


while(rsPatList.next()) 
{
	if (k % 2 == 0 )
		rowclass = "gridData";
	else
		rowclass = "gridData";

	StringBuffer motherlink=new StringBuffer();	
	String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
	restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902


	patientid = rsPatList.getString("PATIENT_ID")==null?"":rsPatList.getString("PATIENT_ID");
	encounterid = rsPatList.getString("encounter_id")==null?"":rsPatList.getString("encounter_id");
	patientclass = rsPatList.getString("patient_class")==null?"":rsPatList.getString("patient_class");
	status = rsPatList.getString("status")==null?"":rsPatList.getString("status");
	sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
	deceasedYn = rsPatList.getString("DECEASED_YN")==null?"N":rsPatList.getString("DECEASED_YN");
	if(sex.equals("M"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else
		if(sex.equals("F"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

	StringTokenizer st = new StringTokenizer(status,"|");
		
	while (st.hasMoreTokens())
	{
		 st.nextToken(); //emergencyYn =
		 st.nextToken(); //deceasedYn = 
		 st.nextToken(); //n=
		 relationYn = st.nextToken();
	}
	//Adding start for IN072994
	if(bar_code_scan_site_YN.equals("Y") && (!newbornid.equals("") || !motherid.equals(""))){

       pstmt1 = con.prepareStatement("SELECT SCAN_REQUIRED_YN,ALERT_REQUIRED_YN,REMARKS_REQUIRED_YN FROM PR_BARCODE_SCAN_SETUP WHERE FUNCTION_ID = 'NEW_BORN_LIST' AND PATIENT_CLASS =? ") ;
			pstmt1.setString(1, patientclass.trim());

			resultSet = pstmt1.executeQuery() ;

			if(resultSet.next())
			{ 
				scan_count_required_yn = resultSet.getString("SCAN_REQUIRED_YN")==null?"N":resultSet.getString("SCAN_REQUIRED_YN");
				alert_required_yn      = resultSet.getString("ALERT_REQUIRED_YN")==null?"N":resultSet.getString("ALERT_REQUIRED_YN");
				remarks_required_yn    = resultSet.getString("REMARKS_REQUIRED_YN")==null?"N":resultSet.getString("REMARKS_REQUIRED_YN");
			}
	}
//Adding end for IN072994
	if(relnreqyn.equals("Y"))
	{
		if(relationYn.equals("N"))
			text = "<font size=2><b>*</b></font>";
		else
			text="&nbsp;";
	}

	if(deceasedYn.equals("Y"))
	{
		{newbornclass="CADECEASED"; style="";}
	}
	else
	{
		if(encounterid.equals(""))
			{newbornclass="NEWBORN"; style="style=background:#00FF00";}
		else 
			{newbornclass="DISCHARGED";style="style=background:#0099FF";} 
	}

	if(locale.equals("en"))
		localeDate = rsPatList.getString("DOB") == null ? "" : rsPatList.getString("DOB");
	else
		localeDate = com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMYHM","en",locale);


	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(style));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(newbornclass));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(text));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count++ ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(r));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(relationYn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(r));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((rsPatList.getString("PATIENT_NAME")==null?"&nbsp;":rsPatList.getString("PATIENT_NAME"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(r));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(localeDate));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rsPatList.getString("AGE")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((rsPatList.getString("BABY_LOCN")==null?"&nbsp;":rsPatList.getString("BABY_LOCN"))));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((rsPatList.getString("BABY_ROOM_NUM")==null ?"&nbsp;":rsPatList.getString("BABY_ROOM_NUM"))));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((rsPatList.getString("BABY_BED_NUM")==null?"&nbsp;":rsPatList.getString("BABY_BED_NUM"))));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rsPatList.getString("MOTHER_NAME")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((rsPatList.getString("MOTHER_BED_NUM")==null ?"&nbsp;":rsPatList.getString("MOTHER_BED_NUM"))));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(style));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(newbornclass));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(text));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(r));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((rsPatList.getString("PATIENT_NAME")==null?"&nbsp;":rsPatList.getString("PATIENT_NAME"))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMYHM","en",locale)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rsPatList.getString("AGE")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((rsPatList.getString("BABY_LOCN")==null?"&nbsp;":rsPatList.getString("BABY_LOCN"))));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((rsPatList.getString("BABY_ROOM_NUM")==null ?"&nbsp;":rsPatList.getString("BABY_ROOM_NUM"))));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((rsPatList.getString("BABY_BED_NUM")==null?"&nbsp;":rsPatList.getString("BABY_BED_NUM"))));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rsPatList.getString("MOTHER_NAME")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((rsPatList.getString("MOTHER_BED_NUM")==null ?"&nbsp;":rsPatList.getString("MOTHER_BED_NUM"))));
            _bw.write(_wl_block50Bytes, _wl_block50);


/*Mother tooltip construction */

String strMotherAdmDate = rsPatList.getString("mother_adm_date");

if(strMotherAdmDate == null)
	strMotherAdmDate = "&nbsp;";

if(!strMotherAdmDate.equals("&nbsp;"))
	strMotherAdmDate = com.ehis.util.DateUtils.convertDate(strMotherAdmDate,"DMYHM","en",locale);

motherlink.append("<tr><td class=ORPANEL nowrap><font size=1>"+rsPatList.getString("MOTHER_NAME")+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+rsPatList.getString("mother_age")+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+rsPatList.getString("mother_patient_id")+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+(rsPatList.getString("MOTHER_LOCN")==null?"&nbsp;":rsPatList.getString("MOTHER_LOCN"))+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+(rsPatList.getString("MOTHER_ROOM_NUM")==null?"&nbsp;":rsPatList.getString("MOTHER_ROOM_NUM"))+"</font></td>"+"<td class=ORPANEL><font size=1>"+(rsPatList.getString("MOTHER_BED_NUM")==null?"&nbsp;":rsPatList.getString("MOTHER_BED_NUM"))+"</font></td>"+
					"<td class=ORPANEL><font size=1>"+strMotherAdmDate+"</font></td>"+"</tr>");
String PatName = rsPatList.getString("PATIENT_NAME");

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(r));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(motherlink.toString()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(r));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PatName));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(r));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(scan_count_required_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(r));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alert_required_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(r));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(remarks_required_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block61Bytes, _wl_block61);

i++;
k++;
r++;
}
	if(i==1)
	{

out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
out.println("<script>top.content.workAreaFrame.NewBornTitleFrame.location.href='../../eCommon/html/blank.html';top.content.workAreaFrame.NewBornResultFrame.location.href='../../eCommon/html/blank.html';</script>");
	}


            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(decease));
            _bw.write(_wl_block67Bytes, _wl_block67);
if(!anchorID.equals("")){
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

if(!anchorID.equals("")){
	
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally 
{
	if(pstmt!=null)pstmt.close();
	if(rsPatList!=null)rsPatList.close();
	if(pstmt1!=null)pstmt1.close();//Added for IN072994
	if(resultSet!=null)resultSet.close();//Added for IN072994
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
            _bw.write(_wl_block101Bytes, _wl_block101);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NewBornID.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NewBornName.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NewBornLocation.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MothersName.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MothersBed.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
