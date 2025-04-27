package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patlistbyrelnprovresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByRelnProvResult.jsp", 1742464194443L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History      Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?           created\n20/08/2012\t\tIN029180\t\tChowminya G\t\t The system is not running by sequence number of newborn.\t\n13/03/2014\t\tIN044157\t\tChowminya\t\t [AAKH CRF 0010.1]Five level Triage system  AE requirement\n15/04/2023\t\t37866\t\t\tRamesh G\t\t \t\t\t\t\t\t\t\tMMS-DM-CRF-0226 \n22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778\t\t\t\t\n10/30/2023   32902      Twinkle Shah    \t    Ramesh Goli      MMS-DM-CRF-0210\t\t\t\n05/12/2023   54073     srinivasa N T              ramesh Goli          \t\n---------------------------------------------------------------------------------------------------------------\n\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCA/html/IeStyle.css\'>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/CAStyle.css\"></link>\n -->\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n <script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/PatListByRelnProvResult.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n<head>\n</head>\n<body onload=\"storeValues(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\"  onscroll=\'moveFrame()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t<td class=\'white\' width=\'90%\'></td> \n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'previous\' ></td>\n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'next\' ></td>\n\t\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<!------------------------ Changes for Prevoius Next Functionality----------->\n\t<input type=\"hidden\" name=\"locationType1\" id=\"locationType1\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\"hidden\" name=\"relationshipCode1\" id=\"relationshipCode1\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"reln_req_yn1\" id=\"reln_req_yn1\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"fromDate1\" id=\"fromDate1\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\" name=\"toDate1\" id=\"toDate1\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\" name=\"groupByReln1\" id=\"groupByReln1\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" name=\"groupByEpisode1\" id=\"groupByEpisode1\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"navigate\">\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n\t<input type=\"hidden\" name=\"form\" id=\"form\" value=\"Relation\">\n\n    <input type=\"hidden\" name=\"patientId1\" id=\"patientId1\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"queueId1\" id=\"queueId1\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"sortOrder1\" id=\"sortOrder1\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"queueStatus1\" id=\"queueStatus1\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"attend_practId1\" id=\"attend_practId1\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"speciality1\" id=\"speciality1\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\n<!------------------------ end of change---------------------------------->\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<Script>\n\t\t\t\ttop.content.workAreaFrame.colorRefframe.document.getElementById(\'previous\').innerHTML = \"\";\n\t\t\t\ttop.content.workAreaFrame.colorRefframe.document.getElementById(\'next\').innerHTML = \"\"\n\t\t\t</Script>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<Script>\n\t\t\t\tif(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById(\'previous\')){\n\t\t\t\t\ttop.content.workAreaFrame.colorRefframe.document.getElementById(\'previous\').innerHTML =\"<INPUT TYPE=\'button\' class=\'button\' name=\'prev\' id=\'prev\' onClick=navigate(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\') title=\'Previous\' value=\'  \\<  \' >\";}\n\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'previous\').innerHTML = \"<a class=\'gridLink\' href=`javascript:onClick=navigate(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')`title=\'Previous\' value=\' Previous  \' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</a>\";\n\t\t\t\t\t}\n\t\t\t\t</Script>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<Script>\n\t\t\t\tif(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.next)\n\t\t\t\t\t{\n\t\t\t\t\ttop.content.workAreaFrame.colorRefframe.document.getElementById(\'next\').innerHTML = \"<INPUT TYPE=\'button\' class=\'button\' name=\'nex\' id=\'nex\'  onClick=navigate(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\') title=\'Next\' value=\'  \\>  \' >\";\n\t\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tdocument.getElementById(\'next\').innerHTML = \"<a class=\'gridLink\' href=`javascript:onClick=navigate(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')`title=\'Next\' value=\' next  \' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<script>\n\t\t\t\t//if(top.content.workAreaFrame.colorRefframe.document.getElementById(\'next\'))\n\t\t\t\t\ttop.content.workAreaFrame.colorRefframe.document.getElementById(\'next\').innerHTML=\"&nbsp;\";\n\t\t\t\t//if(top.content.workAreaFrame.colorRefframe.document.getElementById(\'previous\'))\n\t\t\t\t\ttop.content.workAreaFrame.colorRefframe.document.getElementById(\'previous\').innerHTML=\"&nbsp;\";\t\t\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<input type=\"hidden\" name=\"maxNoRecords\" id=\"maxNoRecords\"value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<tr><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheader\' nowrap><a style=\'color:white\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</a></td><td class=\'columnheadercenter\' nowrap><a  id=\'a01\'   href=\"javascript:callForOrderBy(\'PC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a1\'   href=\"javascript:callForOrderBy(\'REL\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a2\'   href=\"javascript:callForOrderBy(\'RELT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a3\'   href=\"javascript:callForOrderBy(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</a></td><!--54073-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<td class=\'columnheader\'   nowrap><a style=\'color:white\'   >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\n\t\t\t\t\t<td class=\'columnheadercenter\' nowrap><a id=\'a5\'   href=\"javascript:callForOrderBy(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a6\'   href=\"javascript:callForOrderBy(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a7\'   href=\"javascript:callForOrderBy(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a8\'   href=\"javascript:callForOrderBy(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a81\'   href=\"javascript:callForOrderBy(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a9\'   href=\"javascript:callForOrderBy(\'PR\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a10\'   href=\"javascript:callForOrderBy(\'LOC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a11\'   href=\"javascript:callForOrderBy(\'SD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a12\'   href=\"javascript:callForOrderBy(\'ED\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a4\'   href=\"javascript:callForOrderBy(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a13\'   href=\"javascript:callForOrderBy(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a></td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"  name=\"restPatientYN";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t<tr><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheader\' nowrap><a style=\'color:white\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a01\'   href=\"javascript:callForOrderBy(\'REL\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a1\'   href=\"javascript:callForOrderBy(\'RELT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a2\'   href=\"javascript:callForOrderBy(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</a></td><!--54073-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t<td class=\'columnheader\'   nowrap><a style=\'color:white\'   >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</a></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheadercenter\' nowrap><a id=\'a4\'   href=\"javascript:callForOrderBy(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a5\'   href=\"javascript:callForOrderBy(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a6\'   href=\"javascript:callForOrderBy(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a7\'   href=\"javascript:callForOrderBy(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheadercenter\' nowrap><a id=\'a73\'   href=\"javascript:callForOrderBy(\'VT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheadercenter\' nowrap><a id=\'a71\' href=\"javascript:callForOrderBy(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a8\'   href=\"javascript:callForOrderBy(\'PR\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a9\'   href=\"javascript:callForOrderBy(\'LOC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a10\'   href=\"javascript:callForOrderBy(\'SD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a11\'   href=\"javascript:callForOrderBy(\'ED\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a3\'   href=\"javascript:callForOrderBy(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a12\'   href=\"javascript:callForOrderBy(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</a></td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t<tr><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheader\' nowrap><a style=\'color:white\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a4\'   href=\"javascript:callForOrderBy(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a72\' href=\"javascript:callForOrderBy(\'IQS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a></td><td class=\'columnheadercenter\' nowrap><a id=\'a71\' href=\"javascript:callForOrderBy(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</a></td></tr><!--54073-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\n\t\t\t\t\t<tr><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheadercenter\' width=\'16px\'>&nbsp;</td><td class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td><td class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<td class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\n\t\t\t\t<tr id=\'titleHdrIP\' style=\'visibility:hidden\'><td class=\'columnheader\' nowrap width=\'16px\'>&nbsp;</td><td class=\'columnheader\' nowrap width=\'16px\'>&nbsp;</td><td class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td><td class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t<tr id=\'titleHdrIP\' style=\'visibility:hidden\'><td class=\'columnheader\' nowrap width=\'16px\'>&nbsp;</td><td class=\'columnheader\' nowrap width=\'16px\'>&nbsp;</td><td class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t<td class=\'columnheader\'   nowrap ><a style=\'color:white\'   >";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t<td class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n        </table>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_visit_id\" id=\"episode_visit_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"\">\n\t\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"discharge_date\" id=\"discharge_date\" value=\"\">\n\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_Status\" id=\"episode_Status\" value=\"\">\n\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"\">\n\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"\">\n\t\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"\">\n\t\t<input type=\"hidden\" name=\"pline\" id=\"pline\" value=\"\">\n\t\t<input type=\"hidden\" name=\"reln_req_yn\" id=\"reln_req_yn\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t<input type=\"hidden\" name=\"insert_op\" id=\"insert_op\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n        <input type=\"hidden\" name=\"medical_team\" id=\"medical_team\" value=\"\">\n        <input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\n        </form>\n\n\t\t<div id=\'motherLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\';\n\t\t\t}\n\t\t\tif(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById(\"TitleTab\") != null){\n\t\t\t\t//top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById(\"TitleTab\").width =\tdocument.getElementById(\"PatCriteriaTbl\").offsetWidth;\n\t\t\t\tif(document.getElementById(\"PatCriteriaTbl\").rows[0] != null){\n\t\t\t\t\tfor (j=0; j < document.getElementById(\"PatCriteriaTbl\").rows[0].cells.length; j++) {\n\t\t\t\t\t\tvar wid=document.getElementById(\"PatCriteriaTbl\").rows[0].cells[j].offsetWidth+\"px\";\n\t\t\t\t\t\t//alert(wid);\n\t\t\t\t\t\tif(top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById(\"TitleTab\").rows[0].cells[j] != null){\n\t\t\t\t\t\t\ttop.content.workAreaFrame.PatResultFr.RelnResultTitle.document.getElementById(\"TitleTab\").rows[0].cells[j].style.width=wid;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//document.getElementById(\"PatCriteriaTbl\").deleteRow(0);\n\t\t\t}\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\';\n\t\t\t}\n\t\t\tif(\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'!=\'\')\n\t\t\t{\n\t\t\t\t//*** added to make all anchors white before making the selcted one pink\n\t\t\t\tfor(i=0;i<document.anchors.length;i++)\n\t\t\t\t{\n\t\t\t\t\tdocument.anchors(i).style.color=\'white\';\n\n\t\t\t\t}\n\t\t\t\t//***\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'==\'1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'PatCriteriaTbl\').all.";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =".style.color=\'pink\';\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'==\'2\')\n\t\t\t\t\tdocument.getElementById(\'PatCriteriaTbl\').all.";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =".style.color=\'yellow\';\n\t\t\t}\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t<script>\n\t\t\t\tparent.parent.PatCriteriaFr.document.getElementById(\'searchID\').disabled = false;\n\t\t\t</script>\n    </body>\n</html>\n\n\n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locn_type =	request.getParameter("locn_type");
	String legendstyle="padding-left:0px;padding-right:0px";

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block8Bytes, _wl_block8);


Connection con =null;

PreparedStatement stmtMotherLink = null;
ResultSet rsMotherLink = null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facility_id=(String)session.getValue("facility_id");
//String resp_id = (String)session.getValue("responsibility_id");
//String user_id = (String)session.getValue("login_user");
if(facility_id == null) facility_id="";
String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
String decesedColor="";
String	 encounterType    ="";
String	 relationshipCode ="";
String	 relnreqyn		   ="";
String	  fromDate   	   ="";
String	  toDate   		   ="";
String	  groupByReln	   ="";
String	  groupByEpisode   ="";
String patientId = "";
String queueId = ""; //alt id1
String queueStatus = "";
String sortOrder = "";
String Episode_Type_Desc="";
String Relationship_Type="";
String strGender="";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
String strVisitAdmDate	=	"";
String strBeginDate		=	"";
String strEndDate		=	"";
String strBirthDate		=	"";

//32902 start
String restPatientYN	=	"";
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	int accessRightsViewPatient=0;
//32902 end

String prev =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
String next =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

String pat_id1 ="";
String checkedOut ="";
String discharged ="";
String nonencspec ="";
int maxNoRecords = 0;
String attend_practId = "";
String speciality = "";
String dateofbirth1 = "";

try
{
	con = ConnectionManager.getConnection(request);
	//HttpSession thisSession = request.getSession(false);
	String clinicianId=(String) session.getValue("ca_practitioner_id");
	boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION");  //37866
	//added by ankur
	//values comming from title frame
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	//to give scrolling effect which clicked on title for sorting
	String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
	String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	//ends here
	String visitType = request.getParameter("visitType")==null?"":request.getParameter("visitType");
	
	if(mode.equals("search") || mode.equals(""))//when request for search for first time
	{

		relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");
		encounterType = request.getParameter("locationType");
		relationshipCode = request.getParameter("relationshipCode");
		if(relationshipCode==null || relationshipCode.equals("null") || relationshipCode=="")
			relationshipCode = "";
		fromDate = request.getParameter("fromDate");
		if(fromDate==null || fromDate.equals("null") || fromDate.equals("") )
			fromDate="";
		toDate = request.getParameter("toDate");
		if(toDate==null || toDate.equals("null") || toDate.equals(""))
			toDate="";

		//out.println("fromDate"+fromDate);
		//out.println("toDate"+toDate);
		groupByReln = request.getParameter("groupByReln");
		groupByEpisode = request.getParameter("groupByEpisode");
		patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		queueId = request.getParameter("queueId")==null?"":request.getParameter("queueId");
		sortOrder = request.getParameter("sortOrder")==null?"v":request.getParameter("sortOrder");
		queueStatus = request.getParameter("queueStatus")==null?"":request.getParameter("queueStatus");
		if (queueStatus.equals("00")) 
			queueStatus = "";

		checkedOut = request.getParameter("checkedOut")==null?"":request.getParameter("checkedOut");
		discharged = request.getParameter("discharged")==null?"":request.getParameter("discharged");
		nonencspec = request.getParameter("nonencspec")==null?"":request.getParameter("nonencspec");
		attend_practId = request.getParameter("attend_practId")==null?"":request.getParameter("attend_practId");
		speciality = request.getParameter("speciality")==null?"":request.getParameter("speciality");
	}
	else
	{
		relnreqyn = request.getParameter("reln_req_yn1")==null?"Y":request.getParameter("reln_req_yn1");
		encounterType = request.getParameter("locationType1");
		relationshipCode = request.getParameter("relationshipCode1");
		if(relationshipCode==null || relationshipCode.equals("null") || relationshipCode=="")
			relationshipCode="";
		fromDate = request.getParameter("fromDate1");
		if(fromDate==null || fromDate.equals("null") || fromDate=="")
			fromDate="";
		toDate = request.getParameter("toDate1");
		if(toDate==null || toDate.equals("null") || toDate=="")
			toDate="";
		groupByReln= request.getParameter("groupByReln1");
		groupByEpisode= request.getParameter("groupByEpisode1");
		patientId = request.getParameter("patientId1")==null?"":request.getParameter("patientId1");
		queueId = request.getParameter("queueId1")==null?"":request.getParameter("queueId1");
		sortOrder = request.getParameter("sortOrder1")==null?"":request.getParameter("sortOrder1");
		queueStatus = request.getParameter("queueStatus1")==null?"":request.getParameter("queueStatus1");
		if (queueStatus.equals("00")) 
			queueStatus = "";
		attend_practId = request.getParameter("attend_practId1")==null?"":request.getParameter("attend_practId1");
		speciality = request.getParameter("speciality1")==null?"":request.getParameter("speciality1");
	}
	
	fromDate	= com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
	toDate		= com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");

	boolean isScroll = true;
	boolean isIP = false;
	boolean isOP = false;
	boolean floatTitle  = false;
	if(locn_type==null)locn_type="";
	String locn_code =	request.getParameter("locn_code");
	
	if(locn_code==null)
		locn_code="";
	if(groupByEpisode.equals("Y") && groupByReln.equals("Y"))
	{
		
		floatTitle = true;
		isScroll = false;
		if(!locn_type.equals(""))
		{
			if(locn_type.equals("OP"))
			{
				isOP = true;
				encounterType = "OP";
			}
			else if(locn_type.equals("IP"))
			{
				isIP = true;
				encounterType = "IP";
			}
			else if(locn_type.equals("EM"))
			{
				isOP = true;
				encounterType = "EM";
			}
			else if(locn_type.equals("DC"))
			{  
				isIP = true;
				encounterType = "DC";
			}
			else if(locn_type.equals("XT"))
			{  
				isOP = true;
				encounterType = "XT";
			}
		}
		if(!locn_code.equals(""))
		{
			relationshipCode = locn_code;
		}
			
	}
	else if(groupByEpisode.equals("Y") && groupByReln.equals("N"))
	{
				
		if(!locn_type.equals(""))
		{
			if(locn_type.equals("OP"))
			{
				isOP = true;
				encounterType = "OP";
			}
			else if(locn_type.equals("IP"))
			{
				isIP = true;
				encounterType = "IP";
			}
			else if(locn_type.equals("DC"))
			{
				isIP = true;
				encounterType = "DC";
			}
			else if(locn_type.equals("EM"))
			{
				isOP = true;
				encounterType = "EM";
			}
			else if(locn_type.equals("XT"))
			{
				isOP = true;
				encounterType = "XT";
			}
			
		}
			
					
			if(locn_code.equals("RALL"))
			{
				relationshipCode = "";
			}
			else
			{
			relationshipCode = locn_code;
			}
		
			
	}
	else if(groupByEpisode.equals("N") && groupByReln.equals("N"))
	{
		if(encounterType.equals("Z"))
		encounterType = "";
		if(relationshipCode.equals("ALL"))
			relationshipCode="";

	}

    StringBuffer QueryString = new StringBuffer();
	StringBuffer WhereClause= new StringBuffer();
	if(QueryString.length() > 0) QueryString.delete(0,QueryString.length());
	
	 //QueryString.append("Select A.PRACTITIONER_ID PHYS_PROV_ID , A.PATIENT_ID , A.PATIENT_CLASS EPISODE_TYPE_DESC , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE , A.ENCOUNTER_ID EPISODE_ID , TO_NUMBER('') VISIT_ID, C.SEX , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') END LOCAN_NAME  , A.PRACT_RELN_ID PHYS_PROV_RELN_ID , to_char(A.BEGIN_DATE_TIME,'dd/mm/yyyy hh24:mi') BEGIN_DATE_TIME_STR , nvl(to_char(A.END_DATE_TIME,'dd/mm/yyyy hh24:mi'),'') END_DATE_TIME_STR , CA_GET_DESC.CA_PRACT_RELN(A.PRACT_RELN_ID,?,'1') PHYS_PROV_RELN_NAME   , AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PHY_PROV_NAME   , replace(decode(?,?,C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME, to_char(C.DATE_OF_BIRTH,'dd/mm/yyyy') DOB   ,   C.DATE_OF_BIRTH, GET_AGE(C.DATE_OF_BIRTH) AGE , to_char(B.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE  , to_char(B.DISCHARGE_DATE_TIME, 'dd/mm/yyyy') DISCHARGE_DATE  , B.ASSIGN_ROOM_NUM ROOM_NO, B.ASSIGN_BED_NUM BED_NO  , CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.ENCOUNTER_ID,a.PATIENT_CLASS,?,C.DECEASED_YN) STATUS , A.PATIENT_CLASS , B.VISIT_ADM_DATE_TIME orderbydate  , B.REFERRAL_ID REFERRAL_ID,b.PRIORITY_ZONE, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,(select LIFETIME_OR_ENCNTR from  ca_pract_reln where PRACT_RELN_ID=A.PRACT_RELN_ID ) RELATIONSHIP_TYPE,OP_GET_DESC.OP_VISIT_TYPE(?,VISIT_ADM_TYPE,?,1) visit_type FROM CA_ENCNTR_PRACT_RELN A, PR_ENCOUNTER B,MP_PATIENT C WHERE B.FACILITY_ID=A.FACILITY_ID AND B.ENCOUNTER_ID= A.ENCOUNTER_ID  AND nvl(C.suspend_yn,'*') != 'Y' AND C.PATIENT_ID=A.PATIENT_ID AND A.facility_id = ? AND A.practitioner_id = ? AND A.status='01' /*AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7*/  ");
	//QueryString.append("Select A.PRACTITIONER_ID PHYS_PROV_ID , A.PATIENT_ID , A.PATIENT_CLASS EPISODE_TYPE_DESC , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE , A.ENCOUNTER_ID EPISODE_ID , TO_NUMBER('') VISIT_ID, C.SEX , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') END LOCAN_NAME  , A.PRACT_RELN_ID PHYS_PROV_RELN_ID , to_char(A.BEGIN_DATE_TIME,'dd/mm/yyyy hh24:mi') BEGIN_DATE_TIME_STR , nvl(to_char(A.END_DATE_TIME,'dd/mm/yyyy hh24:mi'),'') END_DATE_TIME_STR , CA_GET_DESC.CA_PRACT_RELN(A.PRACT_RELN_ID,?,'1') PHYS_PROV_RELN_NAME   , AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PHY_PROV_NAME   , replace(decode(?,?,C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME, to_char(C.DATE_OF_BIRTH,'dd/mm/yyyy') DOB   ,   C.DATE_OF_BIRTH, GET_AGE(C.DATE_OF_BIRTH) AGE , to_char(B.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE  , to_char(B.DISCHARGE_DATE_TIME, 'dd/mm/yyyy') DISCHARGE_DATE  , B.ASSIGN_ROOM_NUM ROOM_NO, B.ASSIGN_BED_NUM BED_NO  , CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.ENCOUNTER_ID,a.PATIENT_CLASS,?,C.DECEASED_YN) STATUS , A.PATIENT_CLASS , B.VISIT_ADM_DATE_TIME orderbydate  , B.REFERRAL_ID REFERRAL_ID,b.PRIORITY_ZONE, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,(select LIFETIME_OR_ENCNTR from  ca_pract_reln where PRACT_RELN_ID=A.PRACT_RELN_ID ) RELATIONSHIP_TYPE,OP_GET_DESC.OP_VISIT_TYPE(?,VISIT_ADM_TYPE,?,1) visit_type,ca_ae_get_priority_zone_color(b.PRIORITY_ZONE,'en') ae_zone_color,oa_appt_virtual_status(B.facility_id,B.patient_id,B.ENCOUNTER_ID,B.patient_class) virtualApptYN  FROM CA_ENCNTR_PRACT_RELN A, PR_ENCOUNTER B,MP_PATIENT C WHERE B.FACILITY_ID=A.FACILITY_ID AND B.ENCOUNTER_ID= A.ENCOUNTER_ID  AND nvl(C.suspend_yn,'*') != 'Y' AND C.PATIENT_ID=A.PATIENT_ID AND A.facility_id = ? AND A.practitioner_id = ? AND A.status='01' /*AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7*/  "); //IN044157 //32902
	 QueryString.append("Select A.PRACTITIONER_ID PHYS_PROV_ID , A.PATIENT_ID , A.PATIENT_CLASS EPISODE_TYPE_DESC , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE , A.ENCOUNTER_ID EPISODE_ID , TO_NUMBER('') VISIT_ID, C.SEX , CASE WHEN A.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,B.ASSIGN_CARE_LOCN_CODE,?,'1') END LOCAN_NAME  , A.PRACT_RELN_ID PHYS_PROV_RELN_ID , to_char(A.BEGIN_DATE_TIME,'dd/mm/yyyy hh24:mi') BEGIN_DATE_TIME_STR , nvl(to_char(A.END_DATE_TIME,'dd/mm/yyyy hh24:mi'),'') END_DATE_TIME_STR , CA_GET_DESC.CA_PRACT_RELN(A.PRACT_RELN_ID,?,'1') PHYS_PROV_RELN_NAME   , AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1') PHY_PROV_NAME   , replace(decode(?,?,C.PATIENT_NAME,nvl(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)),'''','') PATIENT_NAME, to_char(C.DATE_OF_BIRTH,'dd/mm/yyyy') DOB   ,   C.DATE_OF_BIRTH, GET_AGE(C.DATE_OF_BIRTH) AGE , to_char(B.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE  , to_char(B.DISCHARGE_DATE_TIME, 'dd/mm/yyyy') DISCHARGE_DATE  , B.ASSIGN_ROOM_NUM ROOM_NO, B.ASSIGN_BED_NUM BED_NO  , CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.ENCOUNTER_ID,a.PATIENT_CLASS,?,C.DECEASED_YN) STATUS , A.PATIENT_CLASS , B.VISIT_ADM_DATE_TIME orderbydate  , B.REFERRAL_ID REFERRAL_ID,b.PRIORITY_ZONE, to_char(SYSDATE,'hh24:mi:ss') QRYTIME,(select LIFETIME_OR_ENCNTR from  ca_pract_reln where PRACT_RELN_ID=A.PRACT_RELN_ID ) RELATIONSHIP_TYPE,OP_GET_DESC.OP_VISIT_TYPE(?,VISIT_ADM_TYPE,?,1) visit_type,ca_ae_get_priority_zone_color(b.PRIORITY_ZONE,'en') ae_zone_color,oa_appt_virtual_status(B.facility_id,B.patient_id,B.ENCOUNTER_ID,B.patient_class) virtualApptYN, C.restrict_reinstate_yn  FROM CA_ENCNTR_PRACT_RELN A, PR_ENCOUNTER B,MP_PATIENT C WHERE B.FACILITY_ID=A.FACILITY_ID AND B.ENCOUNTER_ID= A.ENCOUNTER_ID  AND nvl(C.suspend_yn,'*') != 'Y' AND C.PATIENT_ID=A.PATIENT_ID AND A.facility_id = ? AND A.practitioner_id = ? AND A.status='01' /*AND BEGIN_DATE_TIME BETWEEN SYSDATE-7 AND SYSDATE AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND SYSDATE+7*/  "); //32902

	 if (!relationshipCode.equals(""))	 
		QueryString.append(" AND A.pract_reln_id = ? ");
     if (!encounterType.equals(""))
		QueryString.append(" AND A.patient_class = ? ");
	 if (!patientId.equals(""))
		 QueryString.append(" AND A.PATIENT_ID =? ");
	
	if(!encounterType.equals(""))
	{
	
		if(encounterType.equals("XT"))
		{
			
			if(nonencspec.equals("N"))
			{
				QueryString.append("and a.ENCOUNTER_ID is not null ");
			}
		}
		else if (encounterType.equals("OP")||encounterType.equals("EM"))
		{
			if(checkedOut.equals("N"))
			{
				QueryString.append("and b.visit_status between '00' and '06' ");
			}
			else

			{
				//QueryString.append("and b.visit_status between '00' and '07'");
				/***MODIFIED BY Deepa on 1/27/2010 at 11:44 AM for MF performance issue****/
				QueryString.append("and b.visit_status between '00' and '09'");
				/***MODIFIED BY Deepa on 1/27/2010 at 11:44 AM for MF performance issue****/
			}
			if (encounterType.equals("OP"))
			{
				if(!visitType.equals(""))
				{
					QueryString.append(" and VISIT_ADM_TYPE = ? "); // visitType
				}
			}

		}
		else if (encounterType.equals("IP")||encounterType.equals("DC"))
		{
			//out.println("encounterType&&&"+encounterType);
			//out.println("discharged&&&"+discharged);
			if(discharged.equals("N"))
			{
				QueryString.append("and b.adt_status between '01' and '02'  ");
			}
			else
			{
				QueryString.append(" and b.adt_status between '01' and '08'   ");
			}
		}
	}
	if(!attend_practId.equals(""))
	{
		QueryString.append(" and  B.ATTEND_PRACTITIONER_ID = ? ");
	}
	if(!speciality.equals(""))
	{
		QueryString.append(" and B.SPECIALTY_CODE = ? ");
	}
	 if(!fromDate.equals("")&&(!toDate.equals("")))
	{
		QueryString.append( "and ((TO_DATE(?,'DD/MM/YYYY') between trunc(A.BEGIN_DATE_TIME) and nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))) or (TO_DATE(?,'DD/MM/YYYY') between trunc(A.BEGIN_DATE_TIME) and nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))) or (trunc(A.BEGIN_DATE_TIME) between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY')))");

	}
	/*Below null condition check for from and to date is commented by Archana on 6/4/2010  for IN021572 as now it is made mandatory in criteria page*/
	/*else if(!fromDate.equals("") && (toDate.equals("")))
	{
		QueryString.append(" and ( A.BEGIN_DATE_TIME >= to_date( ?, 'DD/MM/YYYY' ) or TO_DATE(?,'DD/MM/YYYY') between trunc(A.BEGIN_DATE_TIME) and nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))  )");
	}
	else if(fromDate.equals("") && !toDate.equals(""))
	{
		QueryString.append(" and ( nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy'))<= to_date( ?,'DD/MM/YYYY' ) OR to_date( ?,'DD/MM/YYYY' ) BETWEEN TRUNC(A.BEGIN_DATE_TIME)  AND nvl(A.END_DATE_TIME,to_date('1/1/4000','dd/mm/yyyy')))  ");
	}*/

	//new qry ends..

	WhereClause.append(" PHYS_PROV_ID = ? and status IS NULL  AND sysdate between BEGIN_DATE_TIME AND nvl(END_DATE_TIME,sysdate) ");
	/*if(WhereClause.length() > 0) WhereClause.delete(0,WhereClause.length());*/
	if( encounterType.equals("OP") || encounterType.equals("IP") || encounterType.equals("DC") || encounterType.equals("EM")) 
	{
		WhereClause.append(" and patient_class= ?  ");
	}
	if(!(relationshipCode.equals("ALL") ))
	{
		WhereClause.append("and PHYS_PROV_RELN_ID=?  ");
	}	
	WhereClause.append(" and ( (TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY')) )");
	
	QueryString.append("AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(a.practitioner_id,a.patient_id,a.facility_id)");  //32902

	//QueryString.append(WhereClause.toString());
	String desc="";
	if(reOrder.equals("2"))
	{
		desc=" desc";
	}
	if(orderBy.equals("PC"))
	{
		QueryString.append(" Order By episode_type_desc"+desc);
	}
	else if(orderBy.equals("LOC"))
	{
		QueryString.append(" Order By LOCAN_NAME "+desc);
	}
	else if(orderBy.equals("PN"))
	{
		QueryString.append(" Order By PATIENT_NAME"+desc);
	}
	else if(orderBy.equals("SAP"))
	{
		QueryString.append(" Order By splty_name"+desc);
	}
	else if(orderBy.equals("DOB"))
	{
		QueryString.append(" Order By DATE_OF_BIRTH "+desc);
		//to_date(dob,'dd/mm/yyyy')"+desc;
	}
	else if(orderBy.equals("AGE"))
	{
		if(reOrder.equals("1"))
		{
			QueryString.append(" Order By DATE_OF_BIRTH");
		}
		else
			QueryString.append(" Order By DATE_OF_BIRTH desc");
	}
	else if(orderBy.equals("SEX"))
	{
		QueryString.append(" Order By SEX"+desc);
	}
	else if(orderBy.equals("PID"))
	{
		QueryString.append(" Order By patient_id"+desc);
	}
	else if(orderBy.equals("REL"))
	{
		QueryString.append(" Order By PHYS_PROV_RELN_NAME"+desc);
	}
	else if(orderBy.equals("RELT"))
	{
		QueryString.append(" Order By RELATIONSHIP_TYPE"+desc);
	}
	else if(orderBy.equals("RID"))
	{
		QueryString.append(" Order By referral_id"+desc);
	}
	else if(orderBy.equals("AP"))
	{
		QueryString.append(" Order By ACTUAL_PHYSICIAN_ID"+desc);
	}
	else if(orderBy.equals("MS"))
	{
		QueryString.append(" Order By splty_name"+desc);
	}
	else if(orderBy.equals("AT"))
	{
		QueryString.append(" Order By appt_time"+desc);
	}
	else if(orderBy.equals("VT"))
	{
		QueryString.append(" Order By visit_type"+desc);
	}
	else if(orderBy.equals("QN"))
	{
		QueryString.append(" Order By lpad(queue_num,6,0)"+desc);
	}
	else if(orderBy.equals("AD"))
	{
		QueryString.append(" Order By VISIT_ADM_DATE_TIME "+desc);
	}
	else if(orderBy.equals("SD"))
	{
		QueryString.append(" Order By BEGIN_DATE_TIME"+desc);
	}
	else if(orderBy.equals("ED"))
	{
		QueryString.append(" Order By END_DATE_TIME"+desc);
	}
	else if(orderBy.equals("PR"))
	{
		QueryString.append(" Order By PHY_PROV_NAME"+desc);
	}
	else if(orderBy.equals("DD"))
	{
		QueryString.append(" Order By DISCHARGE_DATE_TIME"+desc);
	}
	else if(orderBy.equals("IQS"))
	{
		//QueryString.append(" Order By queue_status "+desc);
	}
	else if(groupByEpisode.equals("N") && groupByReln.equals("N"))
	{
		if (sortOrder.equals("v"))
			QueryString.append(" Order By orderbydate");
		else if(sortOrder.equals("p"))
			QueryString.append(" Order By Patient_Name");
	}
	else
	{
		if (sortOrder.equals("v"))
			QueryString.append(" Order By Episode_Type desc , phys_prov_reln_name,orderbydate,patient_name");
		else if(sortOrder.equals("p"))
			QueryString.append(" Order By Episode_Type desc , phys_prov_reln_name,Patient_Name");
	}
	//end of query construction
	out.println("<form name='PatCriteriaFrm' id='PatCriteriaFrm' action='OpenChartWrapper.jsp' method = 'post' target='messageFrame'>");
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	out.println("<table id='PatCriteriaTbl' width='100%'class='grid'>");

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterType));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(relationshipCode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(groupByReln));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(groupByEpisode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(queueId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sortOrder));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queueStatus));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attend_practId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block23Bytes, _wl_block23);

	/*----------------Code at for next Previous------*/
	int start   = 0 ;
    int end     = 0 ;
    int iterate = 1;
    if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ;
	if ( to == null )
		end = 11 ;
	else
		end = Integer.parseInt(to) ;
	int counts=start;//54073
	/*--------------------------------------------------*/
	//IN044157 - Start
	String AEZone5 = "N";
	PreparedStatement stmtAE = con.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
	ResultSet rsAE = null;
	stmtAE.setString(1,facility_id);
	rsAE = stmtAE.executeQuery();
	while(rsAE.next()){
		AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
	}
	if(stmtAE!=null)stmtAE.close();
	if(rsAE!=null)rsAE.close();
	//IN044157 - End
    PreparedStatement stmtPatList = con.prepareStatement(QueryString.toString());
	ResultSet rsPatList = null;
	
	StringBuffer layer = new StringBuffer();
	//String sqlMotherLink = "select a.patient_id pat_id , replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)),'''','') short_name  , to_char(b.date_of_birth, 'dd/mm/yyyy') date_of_birth  , to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH , a.WEIGHT  , a.WEIGHT_UNIT  , a.LENGTH||' cms'  LENGTH_OF_BABY , a.CIRCUMFERENCE||' cms'  CIRCUMFERENCE_OF_HEAD  , a.APGAR_SCORE  , b.sex from  mp_birth_register a  ,mp_patient b  where  b.patient_id=a.patient_id and a.MOTHER_PATIENT_ID = ?  and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by TIME_OF_BIRTH ";
	String sqlMotherLink = "select a.patient_id pat_id , replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)),'''','') short_name  , to_char(b.date_of_birth, 'dd/mm/yyyy') date_of_birth  , to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH , a.WEIGHT  , a.WEIGHT_UNIT  , a.LENGTH||' cms'  LENGTH_OF_BABY , a.CIRCUMFERENCE||' cms'  CIRCUMFERENCE_OF_HEAD  , a.APGAR_SCORE  , b.sex from  mp_birth_register a  ,mp_patient b  where  b.patient_id=a.patient_id and a.MOTHER_PATIENT_ID = ?  and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc ";//Modified --[IN029180]
	stmtMotherLink = con.prepareStatement(sqlMotherLink);
	try 
	{
		int k=0;
		int i=0;
		String rowclass = "QRYEVEN";
		int count=0, countvar=1;//CRF--1778

		/*stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,clinicianId);
		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,patientId);
		stmtPatList.setString(++count,queueId);
		stmtPatList.setString(++count,clinicianId);
		if( encounterType.equals("OP") || encounterType.equals("IP") || encounterType.equals("DC") || encounterType.equals("EM") ) 
			stmtPatList.setString(++count,encounterType);
		if(!(relationshipCode.equals("ALL") ))
			stmtPatList.setString(++count,relationshipCode);
		stmtPatList.setString(++count,fromDate);
		stmtPatList.setString(++count,toDate);
		stmtPatList.setString(++count,fromDate);
		stmtPatList.setString(++count,toDate); */

		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,locale);
		stmtPatList.setString(++count,clinicianId);
		//new shaiju
		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,locale);
			// new shaiju

		stmtPatList.setString(++count,facility_id);
		stmtPatList.setString(++count,clinicianId);
	   if (!relationshipCode.equals(""))	 
			stmtPatList.setString(++count,relationshipCode);
	   if (!encounterType.equals(""))
			stmtPatList.setString(++count,encounterType);
	   if (!patientId.equals(""))
		    stmtPatList.setString(++count,patientId);
	     
       if (encounterType.equals("OP"))
		{
			if(!visitType.equals(""))
			{
				stmtPatList.setString(++count,visitType);
			}

		}

		if(!attend_practId.equals(""))
		{
			stmtPatList.setString(++count,attend_practId);
		}
		if(!speciality.equals(""))
		{
			stmtPatList.setString(++count,speciality);
		}
		if(!fromDate.equals("")&&(!toDate.equals("")))
	    {
			stmtPatList.setString(++count,fromDate);
			stmtPatList.setString(++count,toDate);
			stmtPatList.setString(++count,fromDate);
			stmtPatList.setString(++count,toDate);
	   }
	   /*Below null condition check for from and to date is commented by Archana on 6/4/2010  for IN021572 as now it is made mandatory in criteria page*/
	   /*else if(!fromDate.equals("") && (toDate.equals("")))
	   {
			stmtPatList.setString(++count,fromDate);
			stmtPatList.setString(++count,fromDate);
	   }
       else if(fromDate.equals("") && !toDate.equals(""))
	   {
		   stmtPatList.setString(++count,toDate);
		   stmtPatList.setString(++count,toDate);
		}*/

		rsPatList = stmtPatList.executeQuery();
		
		while(rsPatList.next())
			maxNoRecords += 1;
		if(maxNoRecords == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.RelnResultTitle.location.href='../../eCommon/html/blank.html'</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCommon/html/blank.html'</script>");
		}

		if(rsPatList!=null)rsPatList.close();
		if(isScroll)
		{
            _bw.write(_wl_block24Bytes, _wl_block24);
if ( !(start <= 1) )
			{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(prev));
            _bw.write(_wl_block29Bytes, _wl_block29);
} 
			if ( !( (start+11) > maxNoRecords ) )
			{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(next));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
		}
		else
		{
            _bw.write(_wl_block33Bytes, _wl_block33);
}
		rsPatList = stmtPatList.executeQuery();
		
		if(isScroll)
		{
			if ( start != 1 )
			{
				for( int j=1; j<start;j++ )
				{
					rsPatList.next() ;
					iterate++;
				}
			}
		}//end of isScroll
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(maxNoRecords));
            _bw.write(_wl_block35Bytes, _wl_block35);

		if(groupByEpisode.equals("N") && groupByReln.equals("N"))
		{
			boolean header=false;

			while(rsPatList.next() && iterate <=end ) 
			{
				iterate++ ;
				if(header==false) 
				{
					
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)){
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
}
					//37866 End.
					
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

					out.println("<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
					header=true;
					i++;
				}
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";

				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				
				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");


				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/
				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					rowclass = "DECEASED1";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}

				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{	
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";
				}	
				//IN044157 - end	
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				//disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");

				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date.equals(""))
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);
				// color coding ends
				if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						//String sqlMotherLink_query1 = sqlMotherLink + "  ";
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						String strMotBirthDate = "";
						while(rsMotherLink.next())
						{
							strMotBirthDate = rsMotherLink.getString("date_of_birth");

							if(strMotBirthDate == null || strMotBirthDate.equals("") )
								strMotBirthDate = "&nbsp;";

							if(!strMotBirthDate.equals("&nbsp;") )
								strMotBirthDate = com.ehis.util.DateUtils.convertDate(strMotBirthDate,"DMY","en",locale);

							layer.append( "<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+strMotBirthDate+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
							"<td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
						}
						if (rsMotherLink != null) rsMotherLink.close();
						//if(stmtMotherLink != null ) stmtMotherLink.close();		
					}
				}
			
				Episode_Type_Desc=rsPatList.getString("EPISODE_TYPE_DESC");
				
				if(Episode_Type_Desc.equals("OP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("IP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("EM"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("DC"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("XT"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
				}
				else
				{
					Episode_Type_Desc=" ";
				}

				strGender=rsPatList.getString("SEX");
				
				if(strGender.equals("M"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					strGender="M";
				}
				else if(strGender.equals("F"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					strGender="F";
				}
				else
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					strGender="U";
				}

				Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");

				if(Relationship_Type.equals("E"))
				{
					Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
				}
				if(Relationship_Type.equals("L"))
				{
					Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
				}

				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate			=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
				   {
					 if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				   }

				  //out.println("strEndDate"+strEndDate);
				  // out.println("fromDate1"+fromDate);
				  
			
				out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
				//IN044157 - Start
				out.println("<tr>");
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+ counts++ +"</td><td class='"+rowclass+"' nowrap><font size=1>"+Episode_Type_Desc+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("PHYS_PROV_RELN_NAME")==null?"":rsPatList.getString("PHYS_PROV_RELN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+Relationship_Type+"</font></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td>");//54073
				//37866 Start.
				if(isVirtualConsSiteSpec && "OP".equals(locn_type) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
					out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
				}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
					out.println("<td class='"+rowclass+"'  nowrap>&nbsp;</td>");
				}
				//37866 End.
				out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>"); 
				if(rsPatList.getString("referral_id")!=null){
				out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></font></td></tr>");
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' ><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></font></td></tr>");

				}
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");				
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");				
				out.println("</script>");
				
				 // start.32902  
				
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block60Bytes, _wl_block60);

				  // end. 32902  

				i++;
				k++;
			}
		}
		else if(groupByEpisode.equals("Y") && groupByReln.equals("N"))
		{
			boolean outpHeader=false;
			boolean inpHeader=false;
			boolean header = false;

			while(rsPatList.next() && iterate <=end ) 
			{
				iterate++ ;
				rowclass = "gridData";
				//records_yn=true;
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");


				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					rowclass = "DECEASED1";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}
				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End	
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				// color coding ends
//				disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);

				if(rsPatList.getString("episode_type").equals("O"))
				{
					if(outpHeader==false)
					{
						if(header==false) 
						{
							
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

								//37866 Start.
								if(isVirtualConsSiteSpec && "OP".equals(locn_type)){
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
}
								//37866 End.
								
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
 if(encounterType.equals("OP")){
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

							out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
							header=true;
						}
						i++;
						i++;
						outpHeader=true;
					}
					
					Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");
					
					if(Relationship_Type.equals("E"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
					}
					if(Relationship_Type.equals("L"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
					}

					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}


				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902					
	            accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902

				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("PHYS_PROV_RELN_NAME")==null?"":rsPatList.getString("PHYS_PROV_RELN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+Relationship_Type+"</font></td><td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></font></td>");//54073
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
						out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
					}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
						out.println("<td class='"+rowclass+"'  nowrap>&nbsp;</td>");
					}
					//37866 End.
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate +"</font></td>");
					
					if(encounterType.equals("OP")){
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("visit_type") +"</font></td>");
					}
						
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font>&nbsp;&nbsp;&nbsp;</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font  color="+decesedColor+"><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{
						out.println("<td class='"+rowclass+"' nowrap><font  color="+decesedColor+"><a  class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
				}
				else if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						String strMotBirthDate = "";
						while(rsMotherLink.next())
						{
							strMotBirthDate = rsMotherLink.getString("date_of_birth");

							if(strMotBirthDate == null || strMotBirthDate.equals("") )
								strMotBirthDate = "&nbsp;";

							if(!strMotBirthDate.equals("&nbsp;") )
								strMotBirthDate = com.ehis.util.DateUtils.convertDate(strMotBirthDate,"DMY","en",locale);

							layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+strMotBirthDate+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
						}
					
							if (rsMotherLink != null) rsMotherLink.close();
							//if(stmtMotherLink != null ) stmtMotherLink.close();
					}
					if(inpHeader==false)
					{
						if(header==false) 
						{
							
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

							out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
							header=true;
						}
						i++;
						i++;
						inpHeader=true;
					}
				
					Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");

					if(Relationship_Type.equals("E"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
					}
					if(Relationship_Type.equals("L"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
					}
					
					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}
				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902					
	            accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }
					out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("PHYS_PROV_RELN_NAME")==null?"":rsPatList.getString("PHYS_PROV_RELN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+Relationship_Type+"</font></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink'  href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td> ");//54073
					
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{	
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");

					}
				}
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");
				out.println("</script>");
				 // start.32902  
				
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block60Bytes, _wl_block60);

				  // end. 32902  
				i++;
				k++;
			}
		}  
		else if(groupByEpisode.equals("N") && groupByReln.equals("Y"))
		{
			boolean header = false;
			String currLocn="";
			while(rsPatList.next() && iterate <=end ) 
			{
				iterate++ ;
				//records_yn=true;\
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");


				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/

				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					//rowclass = "DECEASED1";
					rowclass = "gridData";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					//rowclass = "GRAY";
					rowclass = "gridData";
					decesedColor="";
				}else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}
				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				// color coding ends
				//disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);

				layer = new StringBuffer();
				if(noofchildren > 0)
				{
					stmtMotherLink.setString(1,locale);
					stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
					stmtMotherLink.setString(3,facility_id);
					stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
					rsMotherLink = stmtMotherLink.executeQuery(sqlMotherLink);
					while(rsMotherLink.next())
					{
						if(locale.equals("en"))
	                    {
		                 dateofbirth1=rsMotherLink.getString("date_of_birth");
	                    }
	                   else
	                  {
		               dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                  }
						layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+dateofbirth1+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
					}
				
						if (rsMotherLink != null) rsMotherLink.close();
						//if(stmtMotherLink != null ) stmtMotherLink.close();
				}
				if(header==false) 
				{
					
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)){
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
}
					//37866 End.
					
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

					out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
					header=true;
					i++;
				}
				if(!currLocn.equals(rsPatList.getString("PHYS_PROV_RELN_NAME"))) 
				{
					Relationship_Type=rsPatList.getString("RELATIONSHIP_TYPE");

					if(Relationship_Type.equals("E"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
					}
					if(Relationship_Type.equals("L"))
					{
						Relationship_Type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
					}
					
					out.println("<tr><td colspan='14' class='CAGROUP' ><font size='1'><B>"+rsPatList.getString("PHYS_PROV_RELN_NAME")+"/"+Relationship_Type+"</td></tr></font>");
					i++;
					currLocn = rsPatList.getString("PHYS_PROV_RELN_NAME");
				}
			
				Episode_Type_Desc=rsPatList.getString("EPISODE_TYPE_DESC");

				if(Episode_Type_Desc.equals("OP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("IP"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("EM"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				}
				else if(Episode_Type_Desc.equals("DC"))
				{
					Episode_Type_Desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				}
				else
				{
					Episode_Type_Desc=" ";
				}
				
				strGender=rsPatList.getString("SEX");
				
				if(strGender.equals("M"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					strGender="M";
				}
				else if(strGender.equals("F"))
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					strGender="F";
				}
				else
				{
					//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					strGender="U";
				}
				
				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");

				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
				{
					  if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				}
				out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
				//IN044157 - Start
				out.println("<tr>");
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class='"+rowclass+"' nowrap><font size=1>"+Episode_Type_Desc+"</font></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td>");
				//37866 Start.
				if(isVirtualConsSiteSpec && "OP".equals(locn_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
					out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
				}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
					out.println("<td class='"+rowclass+"'  nowrap>&nbsp;</td>");
				}
				//37866 End.
				out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");
				if(rsPatList.getString("REFERRAL_ID")!= null){
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'> <font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a  class='gridLink' > <font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
				}

				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");
				out.println("</script>");
				i++;
				k++;
			}
		}
		else if(groupByEpisode.equals("Y") && groupByReln.equals("Y"))
		{
			boolean outpHeader=false;
			boolean inpHeader=false;
			//boolean header = false;
			String currLocn="";
			while(rsPatList.next())
			{
				iterate++ ;
				//records_yn=true;
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/
				// color coding
				String status = rsPatList.getString("status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";
				String practitioner_id=""; //32902
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE")==null))
						if( !rsPatList.getString("DISCHARGE_DATE").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("EPISODE_STATUS") == null))
						if(rsPatList.getString("EPISODE_STATUS").equals("4"))
							className = "DISCHARGED";
				}*/

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE") == null ? "" : rsPatList.getString("DISCHARGE_DATE");

				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					//rowclass = "DECEASED1";
					rowclass = "gridData";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					//rowclass = "GRAY";
					rowclass = "gridData";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}
				emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{if(emergencyYn.equals("R"))  
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				if(relationYn.equals("N")) 	
					text = "<font size=2><b>*</b></font>";
				// color coding ends
				//disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				disp_cls_cons_date		 = rsPatList.getString("DISCHARGE_DATE");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;"))
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMY","en",locale);
				
				if(rsPatList.getString("episode_type").equals("O"))
				{
					if(outpHeader==false)
					{
						out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						i++;
                        i++;
					}
					if(!currLocn.equals(rsPatList.getString("PHYS_PROV_RELN_NAME"))) 
					{
						i++;
						currLocn=rsPatList.getString("PHYS_PROV_RELN_NAME");
					}

					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}

				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902				
                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902				 
				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }

				pat_id1= rsPatList.getString("PATIENT_ID");
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ countvar++ +"</td><td class='"+rowclass+"' nowrap><font size=1><a class='gridLink'  href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td>");
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(locn_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
						out.println("<td class='"+rowclass+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("EPISODE_TYPE")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
					}else if(isVirtualConsSiteSpec && "OP".equals(locn_type)){ 	
						out.println("<td class='"+rowclass+"' width=85 nowrap></td>");
					}
					//37866 End.
					out.println("<td class='"+rowclass+"'&nbsp;&nbsp;nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' &nbsp;nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td>");
					if(encounterType.equals("OP")){
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("visit_type")+"</font></td>");
					}
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font>&nbsp;&nbsp;&nbsp;</td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("LOCAN_NAME")==null?"":rsPatList.getString("LOCAN_NAME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td> ");
					
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' ><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					
					  // start.32902  
					
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block93Bytes, _wl_block93);

					  // end. 32902  
				}
				else if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						String strMotBirthDate	=	"";
						while(rsMotherLink.next())
						{
							strMotBirthDate = rsMotherLink.getString("date_of_birth");

							if(strMotBirthDate == null || strMotBirthDate.equals("") )
								strMotBirthDate = "&nbsp;";

							if(!strMotBirthDate.equals("&nbsp;") )
								strMotBirthDate = com.ehis.util.DateUtils.convertDate(strMotBirthDate,"DMY","en",locale);

							layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+strMotBirthDate+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+(rsMotherLink.getString("APGAR_SCORE")==null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE"))+"</font></td></tr>");
						}
					}
					if(inpHeader==false)
					{
						out.println("<script language='javascript'>top.content.workAreaFrame.PatCriteriaFr.document.getElementById(\"asOn\").innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						i++;
						i++;
					}
					if(!currLocn.equals(rsPatList.getString("PHYS_PROV_RELN_NAME"))) 
					{
						i++;
						currLocn = rsPatList.getString("PHYS_PROV_RELN_NAME");
					}

					strGender=rsPatList.getString("SEX");
				
					if(strGender.equals("M"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						strGender="M";
					}
					else if(strGender.equals("F"))
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						strGender="F";
					}
					else
					{
						//strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						strGender="U";
					}
				strVisitAdmDate		=	rsPatList.getString("VISIT_ADM_DATE");
				strBeginDate		=	rsPatList.getString("BEGIN_DATE_TIME_STR");
				strEndDate		=	rsPatList.getString("END_DATE_TIME_STR");
				strBirthDate		=	rsPatList.getString("DOB");
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902

				if(strVisitAdmDate == null || strVisitAdmDate.equals("") )
					strVisitAdmDate = "&nbsp;";

				if(strBeginDate == null || strBeginDate.equals("") )
					strBeginDate = "&nbsp;";

				if(strEndDate == null || strEndDate.equals("") )
					strEndDate = "&nbsp;";
			
				if(strBirthDate == null || strBirthDate.equals("") )
					strBirthDate = "&nbsp;";

				if(!strVisitAdmDate.equals("&nbsp;") )
					strVisitAdmDate = com.ehis.util.DateUtils.convertDate(strVisitAdmDate,"DMYHM","en",locale);

				if(!strBeginDate.equals("&nbsp;") )
					strBeginDate = com.ehis.util.DateUtils.convertDate(strBeginDate,"DMYHM","en",locale);

				if(!strEndDate.equals("&nbsp;") )
					strEndDate = com.ehis.util.DateUtils.convertDate(strEndDate,"DMYHM","en",locale);

				if(!strBirthDate.equals("&nbsp;") )
					{
					   if(!(locale.equals("en")))
	                   {
		                strBirthDate=com.ehis.util.DateUtils.convertDate(strBirthDate,"DMY","en",locale);
	                   }
	                else
	                 {
						strBirthDate=strBirthDate;
		               
	                  }
				    }
					out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
					//IN044157 - Start
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td> <td class=gridData nowrap>&nbsp;"+ countvar++ +"</td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+rsPatList.getString("LOCAN_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;&nbsp;&nbsp;"+strBirthDate+"</font></td>");//CRF 1778
					//out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td> <td class=gridData nowrap>&nbsp;"+ countvar++ +"</td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("LOCAN_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");//CRF 1778
					//out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strGender+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PATIENT_ID")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strVisitAdmDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>&nbsp;</font></td><td class='"+rowclass+"' nowrap><font size=1>"+disp_cls_cons_date+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("PHY_PROV_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("LOCAN_NAME")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBeginDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strEndDate+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+strBirthDate+"</font></td>");
					if(rsPatList.getString("REFERRAL_ID")!= null)
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null ? "&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
					else
					{
						out.println("<td class='"+rowclass+"'  width=90 nowrap><font size=1><a class='gridLink' ><font color="+decesedColor+">"+(rsPatList.getString("REFERRAL_ID")== null?"&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("REFERRAL_ID")) +"</font></a></font></td></tr>");
					}
				}
				
				//32902 start

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block96Bytes, _wl_block96);

			//32902 end
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
				out.println("patientIdArr["+i+"]='"+rsPatList.getString("PATIENT_ID")+"';");
				out.println("</script>");
				i++;
				k++;
			}
			if(isIP)
			{
				
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

				inpHeader=true;
			}
			if(isOP)
			{
				
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

				//37866 Start.
				if(isVirtualConsSiteSpec && "OP".equals(locn_type)){
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
}
				//37866 End.
				
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

				outpHeader=true;
			}
			//pat_id1= rsPatList.getString("PATIENT_ID");
		}
		if(rsPatList != null) rsPatList.close();
		if(stmtPatList!=null) stmtPatList.close();
		
	}
	catch(Exception e)
	{
		//out.println("Exception "+e.toString());//COMMON-ICN-0181
		e.printStackTrace(System.err);
		System.out.println(e.toString());
	}
	
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block107Bytes, _wl_block107);
if(floatTitle){
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block110Bytes, _wl_block110);
}else if(!anchorID.equals("")){
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);
}
	catch ( Exception e) 
	{
		
		System.out.println(e);
		e.printStackTrace();
		
	}
	finally 
	{		
		//if (rsMotherLink != null) rsMotherLink.close();
		if(stmtMotherLink != null ) stmtMotherLink.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RelationshipType.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitAdmCloseDate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RelationshipType.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RelationshipType.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }
}
