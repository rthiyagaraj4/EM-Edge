package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import org.json.simple.*;

public final class __aesecondarytriageinclude extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AESecondaryTriageInclude.jsp", 1742179949935L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<div id=\'Triage_Details\'>\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Triage Details\">\n\t\t\t\t<a  class=\"tabClicked\" id=\'Triage_Details_tab\' >\n\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Triage_Details_tab\")\' id=\"Triage_tabspan\">";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<li class=\"tablistitem\" title=\"Assessment\">\n\t\t\t\t<a class=\"tabA\" id=\'Assessment_tab\' >\n\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"Assessment_tab\")\' id=\"assess_tabspan\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\t\t</ul>\n    </td></tr>\n    </table>\n\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n      <tr><td class=\'white\'>\n\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t<li class=\"tablistitem\" title=\"Condition / Case\">\n\t\t\t\t\t<a  class=\"tabClicked\" id=\"Condition_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Condition_tab\")\' id=\"patCond_tabspan\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<!--Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<li class=\"tablistitem\" title=\"Allergy Details\">\n\t\t\t\t\t<a  class=\"tabA\" id=\"allergy_dtls\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"allergy_dtls\")\' id=\"allergyDtls_tabspan\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<!--End-->\n\t\t\t\t<li class=\"tablistitem\" title=\"Others\">\n\t\t\t\t\t<a class=\"tabA\" id=\"others_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"others_tab\")\' id=\"others_tabspan\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t</ul>\n       </td></tr>\n</table>\n<!--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td> \n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td class=\'fields\' width=\'34%\' tabindex=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t<input type=\'text\'  id=\'triage_record_date_time1\' name=\'triage_record_date_time1\' id=\'triage_record_date_time1\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" maxLength=\'19\' size=\'16\' tabindex=\'\'onBlur=\'triageRecordDate(this);\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'triage_record_date_time1\', null, \'hh:mm:ss\' );\" style=\'cursor:pointer\'   /> <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" maxLength=\'19\' size=\'16\' tabindex=\'\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td class=\'fields\' width=\'20%\' tabindex=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t\t<input type=\"button\" name=\"visit_24hr\" id=\"visit_24hr\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onClick=\"showLastVisitDetails(\'LastVisit24\');\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n\t\t\t</td>\n\t\t\t<td class=\'fields\' width=\'21%\' tabindex=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t\t<input type=\"button\" name=\"PrevEncounter\" id=\"PrevEncounter\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\"showPrevEncounter();\"  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<!--End-->\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'15%\' tabindex=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\"button\" name=\"visit_24hr\" id=\"visit_24hr\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\t\t</td>\n\t\t<td class=\'fields\' width=\'15%\' tabindex=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\"button\" name=\"PrevEncounter\" id=\"PrevEncounter\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >\n\t\t</td>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<!--End-->\t\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<input type=\'hidden\' name=\'secTrgRecDateTimeList\' id=\'secTrgRecDateTimeList\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n      <input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t  <tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t  </tr>\n\n     <tr><input type=\"hidden\" name=\'hddpriority\' id=\'hddpriority\'value=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n              <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t    ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t          ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->\n\t\t  <td class=\'fields\' width=\'25%\'>\n\t\t\t<select name=\'Priority_Zone_Type\' id=\'Priority_Zone_Type\' onchange=\'setPriority(this);setTreatment(this);\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\t\t\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t</select>\n\t\t\t</td>\n\t\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t          <td class=\'label\'   width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<input type=\"checkbox\" name=\'priorityR\' id=\'priorityR\'   onClick=\'setPriority(this);setTreatment(this);\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\n\t\t\t \t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<input type=\"checkbox\" name=\'priorityY\' id=\'priorityY\'    onClick=\'setPriority(this);setTreatment(this);\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<input type=\"checkbox\" name=\'priorityG\' id=\'priorityG\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" onClick=\'setPriority(this);setTreatment(this);\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =">\n\t          </td>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="  \n\t    ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t  \t\t  <td class=\'fields\'   width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t  \t\t  <select name=\'prioritynew\' id=\'prioritynew\' id=\'prioritynew\'  onchange=\'setPriority(this.value);setTreatment(this);\' ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="> \n\t    \t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="-------\n\t    \t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' style=\'background-color:";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =";\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t  \t  </select>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t  \t  </td>\n\t    ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t\t  \n\t\t            </tr>  \n\t\t\t\t\t<tr> \n\t\t\t\t\t<td class=\'label\' width=\'25%\' > ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" </td> \n\t\t\t\t\t <td class=\'fields\' width=\'25%\' ><select name=\'priority11\' id=\'priority11\' tabindex=\'65\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n\t\t\t\t\t <option value=\'\'>--------";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="-------\n                  ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="  \n\t\t\t\t\t</select>\n\t\t             </td>   \n\t\t             <!-- \tAdded by Ajay Hatwate for ML-MMOH-2069  -->\n\t\t             ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t             ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t             <td class=\'label\' width=\'25%\' > ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" </td> \n\t\t\t\t\t <td class=\'fields\' width=\'25%\' ><input type=\'number\' id=\'queue_no1\' name=\'queue_no1\' id=\'queue_no1\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'validateQueueNo(this)\' maxLength=\'16\' size=\'16\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' tabindex=\'66\' ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t\t\t ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" \n\t\t             <img src=\'../../eCommon/images/mandatory.gif\' id=\'queue_no_mand_img\' align=\'center\' style=\'visibility:hidden\' ></img>\n\t\t             ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t             \n\t\t             <input type=button class=button value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' onClick=\"callSecQueueAudit();\">\n\t\t             \n\t\t             ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t             <!-- End of ML-MMOH-CRF-2069 -->\n\t\t\t\t\t</tr>  \n\n\t\t<tr> \n\t\t\n\t\t\t  <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t\t   ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" \n\t\t\t   <select name=\'treat_area\' id=\'treat_area\'  ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" onChange=\'clearBed();clearBed1();\'>\n\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="-------</option>\n\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t    </select>\n\t\t\t </td>\n\t\t\t \n\t\t\t\t   <!-- onblur=\"ChangeUpperCase(this);checkForValidBed(this.value);\" -->\n\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'><input type=\'text\' name=\'bed_bay_no\' id=\'bed_bay_no\' size=\'8\' maxlength=\'8\'  readonly onblur=\"ChangeUpperCase(this);\" onKeyPress=\"return(CheckForSpecChars(event))\"  value =\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="><input type=button class=button value=\'?\' name=\'bed_button\' id=\'bed_button\'  onClick=\"callBedAvailChart();\" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =">\n             </td>\n\t\t  </tr>\n          <tr> \n             <td class=\'label\' >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'><input type=\"checkbox\" name=\'Disaster_YN\' id=\'Disaster_YN\'  onClick=\'setDisaster(this)\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="></td>\n\t\t\t ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t   <td class=\'label\' >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'><input type=\"text\" name=\'Disaster_Reference\' id=\'Disaster_Reference\'  onKeyPress=\"return CheckForSpecChar(event)\"\n\t\t\t  value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" maxLength=\"15\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" ></td>\n             <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t  <td class=\'label\' >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'><input type=\"text\" name=\'Disaster_Reference\' id=\'Disaster_Reference\'   onKeyPress=\"return CheckForSpecChars(event)\"  value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' maxLength=\'15\' ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" ></td>\n\t\t\t <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t  </tr> \n\t\t  <tr>\n\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'><input type=\'text\'  name=\"disaster_area1\" id=\"disaster_area1\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" maxLength=\'10\' onblur=\'if(this.value !=\"\")searchDisasterArea(this,disaster_area1);\'  ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="><input type=\'button\' name=\'disaster\' id=\'disaster\' value=\'?\' class=\'button\'  tabindex=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' onclick=\'searchDisasterArea(this,disaster_area1);\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" >\n             </td>\n             ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t      <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t\t\t\t <select name=\'disaster_type\' id=\'disaster_type\' tabindex=\'63\' ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =">\n\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="-------\n\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n                 </select>\n              </td>\n              ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n           </tr>\n<!--            Added by Ajay Hatwate ML-MMOH-CRF-2111 -->\n           ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n           <tr>\n             <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t\t\t\t <select name=\'disaster_category\' id=\'disaster_category\' onChange=\"remVal(document.forms[0].disaster_type);setDisasterType(this);\" tabindex=\'63\' ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="-------</option>\n\t\t\t\t  ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t  </select>\n\t\t\t\t  </td>  \n\t\t\t\t  <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\'>\n\t\t\t\t <select name=\'disaster_type\' id=\'disaster_type\' tabindex=\'63\' ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t  </select>\n\t\t\t\t  </td>\n           </tr>\n\t\t      ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n<!--            End of ML-MMOH-CRF-2111\t\t -->\n\t      <tr>\n\t\t\t <input type=\'hidden\' id=\'regndatetime\' name=\"visit_date_time\" id=\"visit_date_time\"  value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t      <td class=\'LABEL\'  width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' >";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t\t\t <select name=\'ambulatory_status\' id=\'ambulatory_status\' tabindex=\'63\' ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="--------\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n                 </select>\n              </td>\n             ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n              <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</td>\n  \t\t      <td  class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n\t\t\t\t <select name=\'ambulatory_status\' id=\'ambulatory_status\' tabindex=\'63\' >\n\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="-------\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n                 </select>\n              </td>\n\t\t\t  ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n              </td>\t\t   \n\t\t\t <!--Bewlow line added for this CRF AAKH-CRF-0010 [IN038535]-->\n\t\t<td class=\'LABEL\' width=\'25%\' style=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td>\n\t\t<td class=\'fields\' width=\'25%\' style=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t\t<input type=text  name=practitioner_desc id=practitioner_desc size=30 maxlength=30 value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" onBlur=\"beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);\" ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="><input type=button class=button value=\'?\' name=pract_button id=pract_button   onclick=\"aegetPractitioner(this,practitioner_desc);\" ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="><input type=hidden value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" name=\"attend_pract_id\" id=\"attend_pract_id\"><input type=hidden value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" name=\"prev_pract_id\" id=\"prev_pract_id\"></td>\n\t\t   <!--End AAKH-CRF-0010 [IN038535]-->\n          </tr>\n\t\t   <!--Below line added for this CRF ML-MMOH-CRF-0654-->\n\t\t  ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\t\t   \n\t\t   <tr>\n\t\t    <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t\t<td class=\'fields\'  colspan=\'3\'>\n\t\t\t\t   <select name=\'transport_mode\' id=\'transport_mode\' onChange=\"remVal(document.forms[0].mode_of_arrival);setTransMode(this);\" >\n\t\t\t\t    \t<option value=\'\'>----------";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="----------\n                ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t   </select>\n                   <select name=\'mode_of_arrival\' id=\'mode_of_arrival\' >\n\t\t\t\t\t\t <option value=\'\'>----------";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="----------\n\t\t\t\t   </select>\n\t\t    </td> \n\t\t    </td> \n          </tr>\t\n          <tr>\n            <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t\t\t<td class=\'fields\'  width=\'25%\'>\n\t\t\t\t <select name=\'accompany_by\' id=\'accompany_by\' ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =">\n\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="---\n\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" \n\t\t\t\t </select>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td> \n          </tr>\t\t  \n\t\t  ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t  <!--End ML-MMOH-CRF-0654-->\n\t\t  <tr> \n\t\t\t  <td class=\'label\'   width=\'25%\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td> \n\t\t\t ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t  <td class=\'fields\' width=\'25%\' \n\t\t\t\t  tabindex=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'><input type=\'text\' name=\'referral_id\' id=\'referral_id\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" maxlength=\'14\' size=\'14\'  onBlur=\'searchPatient(document.forms[0].referral_id);\' ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="><input type=\'button\' class=\'button\' value=\'?\' name=\'ref_id_search\' id=\'ref_id_search\'   onClick=\'getReferralID()\' ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="></td>\n\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t<td  class=\'fields\' width=\'25%\'><input type=\'text\' name=\'referral_id\' id=\'referral_id\' value=\'\' maxlength=\'14\' size=\'14\'  onBlur=\'\'  align=\'left\' disabled><input type=\'button\' class=\'button\' value=\'?\' name=\'ref_id_search\' id=\'ref_id_search\' onClick=\'getReferralID()\' disabled></td>\n\t\t   ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t     <input type=\'hidden\' name=\'injury_3\' id=\'injury_3\' value=\'\'>\n\n\t\t\t<!--Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650-->\n\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'><input type=\'text\'  name=\"complaint_desc\" id=\"complaint_desc\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" onblur=\'if(this.value !=\"\")searchComplaintType(this,complaint_desc);\' tabindex=\'65\' ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="><input type=\'button\' name=\'Complainttype\' id=\'Complainttype\' value=\'?\' class=\'button\' onclick=\'searchComplaintType(this,complaint_desc);\' ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =">\n\t\t\t\t</td>\t\n\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t<td></td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=button name=\'ChiefComplaints\' id=\'ChiefComplaints\' value= \'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'   onClick=\'ChiefComplaints_type()\'  class=\'Button\'  > \n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t </tr>\n\t\t <tr> \n\t\t\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'3\' tabindex=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'><textarea name=\'triage_remarks\' cols=\'50\'   align=\'left\'  onblur=\'makeValidString(this);checkMaxLen(this);\' onkeypress=\'checkMaxLimit(this,250);\' ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</textarea>\n\t\t  </td>\n\t\t  </tr>  \n\t\t <tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n\t\t </tr>\n\t\t <!--Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-0645 Start-->\n\t\t ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t<tr>\n\t\t<td colspan=4>\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'17%\'>\n\t\t\t\t\t<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\'>\n\t\t\t\t\t<input type=\'radio\' name=\'caseDetails\' id=\'caseDetails\' tabindex=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' id=\'trauma\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="></input>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'10%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' id=\'oscc\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="></input>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'10%\'>\n\t\t\t\t\t<span id=\'osccTypeLabel\' style=\"visibility:hidden\">";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="&nbsp;";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</span>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'16%\'>\n\t\t\t\t\t<select name=\'osccType\' id=\'osccType\' style=\"visibility:hidden\" tabindex=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =">\n\t\t\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="--------\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\'osccTypeMandImg\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  width=\'17%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\'>\n\t\t\t\t\t<input type=\'radio\' tabindex=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' name=\"caseDetails\" id=\'medical\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\'> \n\t\t\t\t\t<input type=\'radio\' tabindex=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' name=\"caseDetails\" id=\'surgical\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="></input> \n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  width=\'17%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\' tabindex=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' >\n\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'OandG\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="></input>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'oscc_yn\' id=\'oscc_yn\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'>\n\t\t\t<input type=\'hidden\' name=\'medical_yn\' id=\'medical_yn\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>\n\t\t\t<input type=\'hidden\' name=\'surgical_yn\' id=\'surgical_yn\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n\t\t ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t <!--End-->\n\t\t <tr>  \n\t\t\t        <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="</td>\n\t\t\t        <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'><input type=\'checkbox\'   name=\"CaseofTrauma\" id=\"CaseofTrauma\" value=\'N\' onClick=\'checktrauma(this);setMechInj1(this);\' ";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =">\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</td>\n                    <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'><input type=\'checkbox\'  name=\"oscc_yn\" id=\"oscc_yn\"   value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' onClick=\'chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();\' ";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" tabindex=\'\' ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 =">\n\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 =" --> </td>\n         </tr>\n\t\t <tr> \n\t\t\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\'><input type=\'checkbox\'  name=\"medical_yn\" id=\"medical_yn\" value=\'N\' onClick=\'chkMedicalValue(this);\' ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="></td>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'> <input type=\'checkbox\'  name=\"surgical_yn\" id=\"surgical_yn\"   value=\'N\' onClick=\'chkSurgValue(this);\' ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="> \n\t\t\t\t\t</td>\n\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 =">\n\t\t\t\t<input type=\'hidden\' name=\'called_from_ca\' id=\'called_from_ca\' value=";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 =">\n\t\t\t\t<!-- Added by Ajay Hatwate for ML-MMOH-CRf-1653 -->\n\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t <tr>\t\n\t      <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</td>\n\t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t <select name=\'case_type\' id=\'case_type\' ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =" >\n\t\t\t <option value=\'\'>--------";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="--------\n\t\t\t  ";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t </select>\n\t\t\t ";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t ";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t </td>\n\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t<!-- End of ML-MMOH-CRF-1653 -->\n\t\t ";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t <tbody id=\'placeOfOccMechInjFieldsDisplay\' style=\"display:none;\">\n\t\t ";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t <tr>\n\t\t \t<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->\n\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t<td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t          <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n  \t\t      <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'>\n\t\t\t  <input type=\'text\'  id=\'accidentdatetime\' name=\'date_time_accident\' id=\'date_time_accident\'   maxLength=\'16\' size=\'16\' tabindex=\'\'\n\t\t\t  value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\"  onBlur=\'doDate(this);\' ";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'accidentdatetime\', null, \'hh:mm\' );\" style=\'cursor:pointer\' ";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 =" ></img><img src=\'../../eCommon/images/mandatory.gif\' id=\'dateOfOccurImg\' style=\"visibility:hidden\" align=\'center\'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n\t\n\t\t\t  \t<!--Added by Ashwini on 19-Jan-2017 for GDOH-CRF-0131-->\n\t\t\t\t<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->\n\t\t\t\t<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->\n\t\t\t\t ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="/";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</td>\n\t\t\t  ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t  <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t  <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'><input type=\'text\' name=\"place_of_accident\" id=\"place_of_accident\"  maxLength=\'30\' size=\'25\'  tabindex=\'\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t\t <td class=\'fields\' width=\'25%\'><select name=\'place_of_accident\' id=\'place_of_accident\' ";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 =" >\n\t\t\t   <option value=\'\'>----------";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="----------</option> \n                ";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'placeOfOccurImg\' style=\"visibility:hidden\" align=\'center\'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t     </tr>\n\t     <tr>\t\n\t\t           <td class=\'LABEL\' width=\'25%\' >\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="<!--End-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t\t\t   </td>\n\t\t\t\t   ";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n  \t\t\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'>\n\t\t\t\t   ";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'2\' tabindex=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\t\t\t\t   <select name=\'mechan_injury\' id=\'mechan_injury\' onChange=\'setInjury(this)\' ";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="> \n\t\t\t\t    <option value=\'\'>--------";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="  \n                 </select><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand4\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t ";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n\t\t\t\t\t<font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\t\t\t ";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n              </td>\n\t\t\t  <!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->\n\t\t\t  ";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\t\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="<!--End-->\n  \t\t      <input type=\'hidden\' name=\'mech_sub_code\' id=\'mech_sub_code\' value=";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 =" >\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'>\n\t\t\t\t<select name=\'injury\' id=\'injury\' tabindex=\'68\' ";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="--------\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand5\' style=\"visibility:hidden\" align=\'center\'></img>\n              </td> \n\t  </tr>\n\t  ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t  </tbody>\n\t  ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t  <tr>\t\n\t\t      <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' colspan=\'2\' tabindex=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'>\n\t\t\t\t <select name=\'vehicle_invol\' id=\'vehicle_invol\' ";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 =">\n\t\t\t\t  <option value=\'\' >--------";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n                 </select><font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t ";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n              </td>\n\t\t\t  <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\'>\n\t\t\t\t<select name=\'vehicle_invol1\' id=\'vehicle_invol1\' tabindex=\'68\' ";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="-------\n\t\t\t\t";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t\t\t</select>\n              </td> \t\t\t   \n\t   </tr>\n<!--Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->\n\t<tr>\n\t <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="</td>\n\t\t<td class=\'fields\' width=\'25%\' colspan=\'2\' >\n\t\t\t<input type=\'text\' name=\"Vehicle_Reg_No1\" id=\"Vehicle_Reg_No1\"  maxLength=\'15\' size=\'20\' value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" onKeyPress=\"return SpCharChkForMotorVecRegNo(event);\" ";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="> <font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\' name=\"Vehicle_Reg_No2\" id=\"Vehicle_Reg_No2\"  maxLength=\'15\' size=\'20\' value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 =">\n\t\t</td>\n\t</tr>\n\t   <tr>\t\n\t\t      <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'>\n\t\t\t\t <select name=\'protective_device\' id=\'protective_device\' ";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 =">\n\t\t\t\t   <option value=\'\'>---------";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="--------\n\t\t\t   ";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n                 </select>\n               </td>\n\t\t\t   <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n               </td>\n\t\t\t   <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\'>\n\t\t\t\t   <select name=\'affected_site\' id=\'affected_site\' tabindex=\'\' ";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\n                 </select>\n              </td>\n\t  </tr> \n\t <tr><!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t         ";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\n\t\t\t  <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="</td>\n\t\t\t ";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t    <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\n\t </tr>\n\t <tr>\t ";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="</td>\n\t           ";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\n\t\t      <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="</td>\n               ";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n\t\t\t   <!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t     <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\'><input type=\'checkbox\'  name=\"mlc_case_yn\" id=\"mlc_case_yn\"  onclick=\'chkMlcValue(this)\' ";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="   ";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="></td>\n             ";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n             <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\"checkbox\" name=\'mlc_death\' id=\'mlc_death\' value=\'";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\' onclick=\'updateSelf(this)\' ";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 =" ></td></td>\n             ";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n             <td class=\'LABEL\' width=\'25%\' colspan=\'2\'>&nbsp;</td>\n             ";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n      </tr> \n\t  <tr>\n\t          <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\'>\n\t\t\t  <input type=\'text\'  name=\'police_rep_no1\' id=\'police_rep_no1\'   maxLength=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 =" onpaste=\"maxLengthPaste(this, \'100\')\" ";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 =" size=\'15\' tabindex=\'\' value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\"  ";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="></td>\n\t\t\t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\'><input type=\'text\' name=\"police_stat_detail\" id=\"police_stat_detail\"  maxLength=\'";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 =" size=\'25\' tabindex=\'\' value=\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\'  ";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="></td>\n\t  </tr>\n\t  <!-- Added by Ajay Hatwate for GHL-CRF-0650  -->\n\t  ";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\n\t   <tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\"outside_mlc_dtls\" id=\"outside_mlc_dtls\" value=\'";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\' maxlength=\'100\' onpaste=\"maxLengthPaste(this, \'100\')\" ";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 =" ></td></td>\t\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\'  id=\'dateofmlccapture\' name=\"date_of_mlc_capture\" id=\"date_of_mlc_capture\" onBlur=\"validateMlcCapture(this)\" maxLength=\'19\' size=\'19\' value=\'";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'dateofmlccapture\',\'dd/mm/yyyy\' ,\'hh:mm:ss\',null );\" style=\'cursor:pointer\'></img>\n\t\t\t\t\t</td></td>\t\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<textarea name=\'mlc_remarks\' rows=3 maxlength=12 cols=45 onKeyPress=\"checkMaxLimit(this, 500)\" onpaste=\"maxLengthPaste(this, \'500\')\" ";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="</textarea>\n\t\t\t\t\t</td></td>\t\t\t\t\n\t</tr>\n\t  ";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\t  <!-- End of GHL-CRF-0650  -->\n     <tr><td colspan=4 class=label height=5></td></tr>\n  </table>\n</div>\n\t<div id=\'Others\' style = \'display:none\' >\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Triage Details\">\n\t\t\t\t<a  class=\"tabClicked\" id=\'Triage_Details_tab\' >\n\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Triage_Details_tab\")\' id=\"Triage_tabspan\">";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 =" \n\t\t</ul>\n    </td></tr>\n    </table>\n\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n      <tr><td class=\'white\'>\n\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t<li class=\"tablistitem\" title=\"Condition / Case\">\n\t\t\t\t\t<a  class=\"tabA\" id=\"Condition_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"Condition_tab\")\' id=\"patCond_tabspan\">";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="<!--End-->\n\t\t\t\t<li class=\"tablistitem\" title=\"Others\">\n\t\t\t\t\t<a class=\"tabClicked\" id=\"others_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"others_tab\")\' id=\"others_tabspan\">";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\'>\n\t\t\t<input type=\'text\'  id=\'other_triage_record_date_time\' name=\'triage_record_date_time\' id=\'triage_record_date_time\' value=\"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 =">\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'other_triage_record_date_time\', null, \'hh:mm:ss\' );\" style=\'cursor:pointer\'   /> <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\'>\n\t\t\t <input type=\'text\'  id=\'other_triage_record_date_time\' name=\'triage_record_date_time\' id=\'triage_record_date_time\' value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" maxLength=\'19\' size=\'16\' tabindex=\'\' ";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'15%\' tabindex=\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\n<!--End-->\t\n <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' colspan=8 width=\"100%\">\n\t <tr>\n\t\t\t<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->\n\t\t\t";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="<!--End-->\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t </tr>\n\t";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\n\t <tr><td colspan=4 class=label height=5></td></tr>\n    <tr >\n\t\t<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->\n\t\t";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n\t\t\t\t<td class=\'LABEL\'   width=\'25%\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\'>\n\t\t\t\t\t<input type=\"checkbox\" name=\'cbd\' id=\'cbd\' ";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="  disabled>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\'   width=\'25%\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\'> \n\t\t\t\t\t<input type=text  name=\'medication\' id=\'medication\'  onKeyPress=\"return CheckSpecCharOnKeyPress(event)\" onPaste = \"return false;\" value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" size=\"30\" maxlength=\"30\" ";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 =" >\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="<!--End-->\n\t\t\t <td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\'><input type=\"checkbox\" name=\'cap_bloodSugar\' id=\'cap_bloodSugar\'  ";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="  disabled>\n\t\t\t <td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\'> \n\t\t\t  <input type=\"checkbox\" name=\'spo2\' id=\'spo2\'   ";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 =" disabled >\n\t\t\t </td>\n\t\t";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\n\t</tr>\n\t <tr>\n\t     <td class=\'LABEL\'   width=\'25%\' >\t\t \n\t\t ";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="</td>\n\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\'> \n\t\t <input type=\"checkbox\" name=\'fbc\' id=\'fbc\' onClick=\'chkOrderCat3(this);\' ";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 =" value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t\t </td>\n\t\t <td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\'> \n\t\t <input type=\"checkbox\" name=\'ecg\' id=\'ecg\' ";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 =" disabled> \n         </td>\n\t </tr>\n\t <tr>\n\t\t<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->\n\t\t";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\n\t\t\t <td class=\'label\' width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\n\t\t\t\t";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\n\t\t\t\t</td>\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\'> \n\t\t\t\t<input type=\"checkbox\" name=\'dressing\' id=\'dressing\'   ";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 =" disabled>\n\t\t\t </td>\n\t\t\t <td class=\'label\' width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\n\t\t\t </td>\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\'> \n\t\t\t\t<input type=text  name=\'initial_mgmt_others\' id=\'initial_mgmt_others\'  onKeyPress=\"return CheckSpecCharOnKeyPress(event)\" onPaste = \"return false;\" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 =" >\n\t\t\t </td>\n\t\t";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="<!--End-->\n\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\'> \n\t\t\t  <input type=\"checkbox\" name=\'dressing\' id=\'dressing\'   ";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 =" disabled>\n\t\t\t </td>\n\t\t\t <td class=\'LABEL\' colspan=2>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\n\t </tr>\n    ";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\n\t <tr>\n  \t\t <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="</td>\n         <td class=\'fields\' colspan=\'2\' tabindex=\'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\'>\n\t\t\t\t <select name=\'immobilization\' id=\'immobilization\' onChange=\'\' ";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 =" >\n\t\t\t\t\t<Option value=\'\'>&nbsp;------";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="-----&nbsp;</Option>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\n                 </select> \n         </td>\n\t\t <td colspan=2 class=\'LABEL\' >&nbsp;</td>  \n  </tr>\n <tr><td colspan=4 class=label height=5></td></tr>\n  <tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="</td>\n  </tr>\n <tr><td colspan=4 class=label height=5></td></tr>\n  <tr>\t\t\t\t \n\t\t      <td class=\'LABEL\' >";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\'>\n\t\t\t\t <select name=\'immunization_stat\' id=\'immunization_stat\' onChange=\'\' ";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 =">\n\t\t\t\t\t       <Option value=\'\'>-------";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="-------</Option>\n                           <Option value=\'F\'";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 =" >";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="</option>\n                           <Option value=\'P\'";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="  >";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="</option>\n                           <Option value=\'U\'";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="</option>\n\t\t\t\t </select>\n              </td>\n  \t\t      <td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="</td>\n\t\t      <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\'><input type=\'checkbox\'  name=\"att_given\" id=\"att_given\"   value=\'\' ";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 =" onblur=\"agecheck(this,\'";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\',\'";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\');\">\n\t\t\t  </td>\n\t </tr>\n\t <tr><td colspan=4 class=label height=5></td></tr>\n\t </table>\n\t\t";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\n\n\t\t<table  border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' colspan=12 width=\"100%\">\n\t    <tr>\n\t\t    <td class=\'COLUMNHEADER\' colspan=\'8\' >";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="</td>\n\t   </tr>\n\t <tr><td colspan=4 class=label height=5></td></tr>\n\t   <tr>\t\n         <td class=\'LABEL\'  width=\"25%\" >";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="</td>\n  \t\t <td class=\'fields\'  width=\"25%\" tabindex=\'";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\'><input type=\'checkbox\'  name=\"growth_age\" id=\"growth_age\"  ";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 =" onclick=\'chkhwc(event);\' ";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="></td>\n\t\t <td class=\'LABEL\' width=\"25%\">";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="</td>\n\t\t <td class=\'fields\'  width=\"25%\" tabindex=\'";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\'>\n\t\t <input type=\'checkbox\' align=\'left\' name=\"immun_date\" id=\"immun_date\"    ";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 =" >\n         </td>\n     </tr>\n     <tr>\n \t\t <td class=\'LABEL\' width=\"25%\">";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="</td>\n\t\t <td  class=\'fields\'  width=\"25%\" tabindex=\'";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\'><input type=\'checkbox\'  name=\"menarche\" id=\"menarche\"    onclick=\'checkmenstrual(this);\' ";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="></td>\n\t\t <td class=\'LABEL\' >";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="</td>\n  \t\t <td class=\'fields\' tabindex=\'";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\'><input type=\'text\'  name=\"height\" id=\"height\" ";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 =" id=\'height\'size=\"5\" maxlength=\'6\' value=\"";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\"onKeyPress=\'return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); \'\n\t\t onBlur=\'SPCheckPositiveNumber(this);\'>&nbsp;";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="</td>    \n\t   </tr>\n       <tr>\t\n\t\t <td class=\'LABEL\' >";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\'><input type=\'text\'  name=\"weight\" id=\"weight\" size=\"5\" maxlength=\'7\' value=\"";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\" onKeyPress=\'return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))\'\n\t\t onBlur=\'SPCheckPositiveNumber(this);\'";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 =">&nbsp;";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="</td>\n \t\t <td class=\'LABEL\' >";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\'><input type=\'text\'  name=\"circumference\" id=\"circumference\" size=\"5\" maxlength=\'6\'value=\"";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\"onKeyPress=\'return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))\'onBlur=\"SPCheckPositiveNumber(this);if(this.readOnly==false)agecheck(this,\'";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\');\"";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 =">&nbsp;&nbsp;";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="</td>\n\t  </tr> \n\t <tr><td colspan=4 class=label height=5></td></tr>\n </table>\n ";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\n ";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\t\t\t\n     <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t <tr>\n\t\t    <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="</td>\n\t </tr>\n\t <tr><td colspan=4 class=label height=5></td></tr>\n     <tr>\t\t\n\t\t    <td class=\'LABEL\' width=\"15%\" >";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="</td>\n            <td class=\'fields\' width=\'10%\' tabindex=\'";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\'>\n            <!-- krishna pranay regarding ML-MMOH-CRF-1759.1 start-->\n           ";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n          <input type=\'checkbox\' name=\"pregnant_at_present_yn_val\" id=\"pregnant_at_present_yn_val\" ";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 =" onClick=\'checkPregnant(this); if(this.checked == false) { nmdesig.innerHTML = \"\"; nmdesig1.innerHTML = \"\"; eddesig.innerHTML = \"\"; } if(this.checked == true) { calculateEDD1(); calculateNoOfDays1(); }\'>\n            ";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\n\t         <input type=\'checkbox\'  name=\"pregnant_at_present_yn_val\" id=\"pregnant_at_present_yn_val\" ";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 =" onClick=\'checkPregnant(this);if(this.checked ==false){nmdesig.innerHTML=\"\";nmdesig1.innerHTML=\"\";eddesig.innerHTML=\"\"};if(this.checked ==true  ){calculateEDD(),calculateNoOfDays();}\' ";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\n\n\t\t\t ";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\n\t\t\t <td width=\"10%\" tabindex=\'";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\' nowrap>\n    \t\t<a id=\"mensHistHyperLinkDisplay\" href=\"javascript:menstHistDtl(\'";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\' ,\'";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\')\" style=\"text-decoration: underline;\">";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\n\t\t\t<td width=\"10%\" tabindex=\'";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\' nowrap>\n    \t\t<a id=\"mensHistHyperLinkDisplay\" href=\"javascript:viewMenstrualHistoryDtl(\'";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\')\" style=\"text-decoration: underline;\">\n        \t";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\n    \t\t</a>\n\t\t\t</td>\n\t\t\t ";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\n\t\t\t \t<td width=\"10%\" tabindex=\'";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\')\" style=\"text-decoration: underline;display:none;\">\n        \t";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\n    \t\t</a>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\n\t\t\t ";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\n\t\t\t<td class=\'LABEL\' width=\'25%\' size=\'20\' id=\"lmplabel\">";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="</td>\n            <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\'><input type=\"text\"  name=\"lmp_date\" id=\"lmp_date\" ";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="  id=\"lmpdate\" maxlength=\"10\" size=\"8\"  onblur=\'makeValidString(this);doDate1(this);if(this.value==\"\"){nmdesig.innerHTML=\"\";nmdesig1.innerHTML=\"\";} checkPregnantDate(this);if(pregnant_at_present_yn_val.checked==true)calculateEDD(),calculateNoOfDays();\'  value = \"";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\" ><img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\"lmp_calendar\"  name=\"lmp_calendar\" onClick=\"return showCalendar(\'lmpdate\');\" ";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 =" style=\'cursor:pointer\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand2\' style=\"visibility:hidden\" align=\'center\'></img></td> \n\t\t\t";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\'><input type=\"text\" name=\"lmp_date\" id=\"lmp_date\" disabled ";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 =" id=\"lmpdate\" maxlength=\"10\" size=\"8\"  onblur=\'makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();\'  value = \"";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" ><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"lmp_calendar\" name=\"lmp_calendar\" onClick=\"return showCalendar(\'lmpdate\');\" disabled ";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="   style=\'cursor:pointer\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand2\' style=\"visibility:hidden\" align=\'center\'></img></td> \n\t\t";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\n       </tr>\n\t   <tr>\t\n\t   ";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\n\t\t\t<td class=\'LABEL\' width=\'25%\' size=\'20\' style=\"display:none;\"  id=\"lmplabel1\">";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\'  id=\"Lmpinputfield\" style=\"display:none;\" ><input type=\"text\" name=\"lmpdate1\" id=\"lmpdate1\" style=\"display:none;\"  ";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 =" id=\"lmpdate1\" maxlength=\"10\" size=\"8\"  onblur=\'makeValidString(this);doDate1(this); checkPregnantDate(this);\'  value = \"";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\" ><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"lmp_calendar1\" name=\"lmp_calendar1\" onClick=\"return showCalendar(\'lmpdate1\');\" style=\"display:none;\" disabled ";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="   style=\'cursor:pointer\'></td> \n            ";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\n            <td class=\'LABEL\' width=\'25%\' size=\'20\' style=\"display:none;\"  id=\"lmplabel1\">";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 =" id=\"lmpdate1\" maxlength=\"10\" size=\"8\"  onblur=\'makeValidString(this);doDate1(this);if(this.value==\"\"){nmdesig.innerHTML=\"\";nmdesig1.innerHTML=\"\";} checkPregnantDate(this);if(pregnant_at_present_yn_val.checked==true)calculateEDD1(),calculateNoOfDays1();\'  value = \"";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\n          \t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="&nbsp;<font name=\"weekVal\" id=\'nmdesig\' class=\'label\'></font>&nbsp;";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="&nbsp;<font id=\'nmdesig1\' class=\'label\'></font>&nbsp;";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="</td>\n\t\t       <td class=\'LABEL\' align=\'left\' >";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="&nbsp;<font name=\"eddVal\" id=\'eddesig\' class=\'label\'></font> \n\t\t    </td>\n\t\t\t<td colspan=2 class=\'LABEL\' >&nbsp;</td>  \n\t</tr> \n   \t <tr><td colspan=4 class=label height=5></td></tr>\n </table>\n <input type=\'hidden\' id=\'CALmpDate\' name=\'CALmpDate\' id=\'CALmpDate\' value=\'";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\'>\n<input type=\'hidden\' id=\'CAEdd\' name=\'CAEdd\' id=\'CAEdd\' value=\'";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\'>\n<input type=\'hidden\' id=\'CADays\' name=\'CADays\' id=\'CADays\' value=\'";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\'>\n<input type=\'hidden\' id=\'CAWeeks\' name=\'CAWeeks\' id=\'CAWeeks\' value=\'";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\'>\n<input type=\'hidden\' id=\'lmpdate2\' name=\'lmpdate2\' id=\'lmpdate2\' value=\'";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\'>\n<input type=\'hidden\' id=\'latestMensDtlStatus\' name=\'latestMensDtlStatus\' id=\'latestMensDtlStatus\' value=\'";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\'>\n<input type=\'hidden\' id=\'check_yn\' name=\'check_yn\' id=\'check_yn\' value=\'";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\'>\n\n";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\n<script>\n    calculateNoOfDays1();\n    calculateEDD1();\n</script>\n";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\n\n\n\n<script>\n/* code for calculating POA -- Weeks and Days as well as EDD values onload */\ncalculateNoOfDays();\ncalculateEDD();\n</script>\n\n<script>\nfunction setInitialValues() {\n\tvar CALmpDate = document.getElementById(\"CALmpDate\").value;\n\tvar CAWeeks=document.getElementById(\"CAWeeks\").value;\n\tvar CADays=document.getElementById(\"CADays\").value;\n\tvar CAEdd=document.getElementById(\"CAEdd\").value;\n\tvar latestMensDtlStatus=document.getElementById(\"latestMensDtlStatus\").value;\n\tvar invokeMenstrualHistYN=document.getElementById(\"invokeMenstrualHistYN\").value;\n\tvar check_yn=document.getElementById(\"check_yn\").value;\n\n    if(latestMensDtlStatus==\"A\" && invokeMenstrualHistYN ==\"Y\")\n    \t{\n    \t document.getElementById(\'lmpdate1\').value = CALmpDate; \n    \t    document.getElementById(\'nmdesig\').innerHTML = CAWeeks;\n    \t    document.getElementById(\'nmdesig1\').innerHTML = CADays;\n    \t    document.getElementById(\'eddesig\').innerHTML = CAEdd;\n    \tdocument.getElementById(\'lmpdate1\').style.display=\'inline\';\n    \tdocument.getElementById(\'lmplabel1\').style.display=\'inline\';\n    \tdocument.getElementById(\'lmp_calendar1\').style.display=\'inline\';\n    \tdocument.getElementById(\'lmplabel\').style.visibility=\'hidden\';\n    \tdocument.getElementById(\'lmpdate\').style.visibility=\'hidden\';\n      \tdocument.getElementById(\'lmp_calendar\').style.visibility=\'hidden\';\n    \tdocument.getElementById(\'Lmpinputfield\').style.display=\'inline\';\n\n    \t}\n    else if(latestMensDtlStatus!=\"A\" && invokeMenstrualHistYN ==\"Y\" && check_yn==\"checked\"){\n    \tdocument.getElementById(\'lmpdate1\').style.display=\'inline\';\n    \tdocument.getElementById(\'lmplabel1\').style.display=\'inline\';\n    \tdocument.getElementById(\'lmp_calendar1\').style.display=\'inline\';\n    \tdocument.getElementById(\'lmp_calendar1\').disabled =true;\n    \tdocument.getElementById(\'lmplabel\').style.display=\'none\';\n    \tdocument.getElementById(\'lmpdate\').style.display=\'none\';\n      \tdocument.getElementById(\'lmp_calendar\').style.display=\'none\';\n    \tdocument.getElementById(\'Lmpinputfield\').style.display=\'inline\';\n    \tdocument.getElementById(\'Lmpinputfield\').disabled =true;\n\n    }\n}\n\n// Attach the function to the window.onload event\nwindow.onload = function() {\n    setInitialValues();\n};\n </script>\n ";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\n</div>\n<!-- New Tab Other Details Added on 04/02/2005  -->\n";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\n <div id=\'Assessment\' style= \'display:none\'>\n\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Triage Details\">\n\t\t\t\t<a class=\"tabA\" id=\'Triage_tab\' >\n\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"Triage_Details_tab\")\' id=\"Triage_tabspan\">";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\"Assessment\">\n\t\t\t\t<a class=\"tabClicked\" id=\"assess_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Assessment_tab\")\' id=\"assess_tabspan\">";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\t\n\t\t</ul>\n\t</td></tr></table>\n\t<!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start -->\n\t";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\n\t\t <table border=\"0\" cellspacing=\'0\' cellpadding=\'3\'  align=\'center\' width=\'100%\'>\n\t\t\t <tr><td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\n\t\t\t \t<tr><td   colspan=\'4\' ><a href=\"javascript:FnProceedClicnicalNotes(\'";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\')\">";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="</a></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\n\t\t\t\t<tr><td   colspan=\'4\' ><a href=\"javascript:FnNotApplicable();\">";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="</a></td></tr>\n\t\t\t  ";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\n\t\t\t \t<tr><td   colspan=\'4\' ><a href=\"javascript:FnProceedCARecordChart(\'";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\',\'\',\'";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\')\">CA ";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\n\t\t\t\t<tr><td   colspan=\'4\' ><a href=\"javascript:FnNotApplicable();\">CA ";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\n\t\t\t<tr><td  colspan=\'4\' ><a href=\"javascript:FnProceedRegisterPatientReferral(\'";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\');\">";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="</a></td></tr>\n\t\t </table>\n\t ";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\n\t <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End -->\n</div>\n";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	  public String specialCharacter(String single){
			int i=0;
			
			
	if(( single.indexOf('\'', i)!=-1)){
		single=(String)single.replace('\'',' ');
	}


	return single ; 
		
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
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);



Connection con				      = null;  
PreparedStatement pstmt		      = null;
ResultSet rset				      = null;
PreparedStatement pstmt1	      = null;
PreparedStatement pstmtEncounter      = null;
ResultSet rset1				      = null;
ResultSet rsetEncounter				      = null;
String sqlFinal		= "";
String sql2		= "";
StringBuffer sbBuff = new StringBuffer();

String ca_install_yn= checkForNull( request.getParameter( "ca_install_yn") );
int tindex = 0;
String sys_date_time= checkForNull( request.getParameter( "sys_date_time") );
String dis_triage_record_date_time= checkForNull( request.getParameter( "dis_triage_record_date_time") );
String VisitProp= checkForNull( request.getParameter( "VisitProp") );
String EncounterProp= checkForNull( request.getParameter( "EncounterProp") );
String facilityId= checkForNull( request.getParameter( "facilityId") );
String RepDb= checkForNull( request.getParameter( "RepDb") );
String sqlDate= checkForNull( request.getParameter( "sqlDate") );
String priority= checkForNull( request.getParameter( "priority") );
String five_level_triage_appl_yn= checkForNull( request.getParameter( "five_level_triage_appl_yn") );
String disPriority= checkForNull( request.getParameter( "disPriority") );
String optSelected= checkForNull( request.getParameter( "optSelected") );
String priorityStatus1= checkForNull( request.getParameter( "priorityStatus1") );
String priorityStatus2= checkForNull( request.getParameter( "priorityStatus2") );
String priorityStatus3= checkForNull( request.getParameter( "priorityStatus3") );
String disabled111= checkForNull( request.getParameter( "disabled111") );
String disabled11= checkForNull( request.getParameter( "disabled11") );
String disabled12= checkForNull( request.getParameter( "disabled12") );
String disabled13= checkForNull( request.getParameter( "disabled13") );
String red= checkForNull( request.getParameter( "red") );
String yellow= checkForNull( request.getParameter( "yellow") );
String green = checkForNull( request.getParameter( "green") );
String prioritynewdisabled = checkForNull( request.getParameter( "prioritynewdisabled") );
String priority_zone_code= checkForNull( request.getParameter( "priority_zone_code") );
String priority_zone_desc= checkForNull( request.getParameter( "priority_zone_desc") );
String priority_zone_order= checkForNull( request.getParameter( "priority_zone_order") );
String priority_zone_color= checkForNull( request.getParameter( "priority_zone_color") );
String priority_zone_hidden_fileds= checkForNull( request.getParameter( "priority_zone_hidden_fileds") );
String priority_selected= checkForNull( request.getParameter( "priority_selected") );
String priority_no= checkForNull( request.getParameter( "priority_no") );
String dis_regn_ref= checkForNull( request.getParameter( "dis_regn_ref") );
StringBuffer sqlAmbulatory= new StringBuffer(checkForNull( request.getParameter( "sqlAmbulatory")));
String AmbulatorySql= checkForNull( request.getParameter( "AmbulatorySql") );
String modify_flag= checkForNull( request.getParameter( "modify_flag") );
String modifyYN= checkForNull( request.getParameter( "modifyYN") );
String dis_area= checkForNull( request.getParameter( "dis_area") );
String display_triage_record_date_time= checkForNull( request.getParameter( "display_triage_record_date_time") );
String encounter_id= checkForNull( request.getParameter( "encounter_id") );
String locale= checkForNull( request.getParameter( "locale") );
String priority_code= checkForNull( request.getParameter( "priority_code") );
String queue_appl_priority_zone= checkForNull( request.getParameter( "queue_appl_priority_zone") );

String queue_max_num_allowed= checkForNull( request.getParameter( "queue_max_num_allowed") );
String queue_no= checkForNull( request.getParameter( "queue_no") );
String dis_queue_no= checkForNull( request.getParameter( "dis_queue_no") );
String queue_num_mandatory= checkForNull( request.getParameter( "queue_num_mandatory") );
String patient_id= checkForNull( request.getParameter( "patient_id") );
String clinic_code = checkForNull( request.getParameter( "clinic_code") );
String patient_gender= checkForNull( request.getParameter( "patient_gender") );
String treat_code= checkForNull( request.getParameter( "treat_code") );
String optSelectedTreat = checkForNull( request.getParameter( "optSelectedTreat") );
String disTreatArea= checkForNull( request.getParameter( "disTreatArea") );
String bed_no= checkForNull( request.getParameter( "bed_no") );
String disBed= checkForNull( request.getParameter( "disBed") );
String disBed1= checkForNull( request.getParameter( "disBed1") );
String checked1= checkForNull( request.getParameter( "checked1") );
String disDisaster = checkForNull( request.getParameter( "disDisaster") );
String visit_date = checkForNull( request.getParameter( "visit_date") );
String dis1= checkForNull( request.getParameter( "dis1") );
String dis2= checkForNull( request.getParameter( "dis2") );
String dis3= checkForNull( request.getParameter( "dis3") );
String dis5= checkForNull( request.getParameter( "dis5") );
String dis7= checkForNull( request.getParameter( "dis7") );
String dis16= checkForNull( request.getParameter( "dis16") );
String disMed= checkForNull( request.getParameter( "disMed") );
String disSur = checkForNull( request.getParameter( "disSur") );
String disOandGYn= checkForNull( request.getParameter( "disOandGYn") );
String a_status= checkForNull( request.getParameter( "a_status") );
String leveloftriage_visibility = checkForNull( request.getParameter( "leveloftriage_visibility") );
String attend_practitioner_name= checkForNull( request.getParameter( "attend_practitioner_name") );
String attend_practitioner_id= checkForNull( request.getParameter( "attend_practitioner_id") );
String transport_mode_code= checkForNull( request.getParameter( "transport_mode_code") );
String accompanied_by_code= checkForNull( request.getParameter( "accompanied_by_code") );
String accompanied_by_dis= checkForNull( request.getParameter( "accompanied_by_dis") );
String pat_dtls_unknown_yn= checkForNull( request.getParameter( "pat_dtls_unknown_yn") );
String referral_id= checkForNull( request.getParameter( "referral_id") );
String disRefID= checkForNull( request.getParameter( "disRefID") );
String complaint= checkForNull( request.getParameter( "complaint") );
String triage_remarks= checkForNull( request.getParameter( "triage_remarks") );
String checkedMed= checkForNull( request.getParameter( "checkedMed") );
String checkedSur= checkForNull( request.getParameter( "checkedSur") );
String checkedOandGYn= checkForNull( request.getParameter( "checkedOandGYn") );
String oscc_yn= checkForNull( request.getParameter( "oscc_yn") );
String medical_yn= checkForNull( request.getParameter( "medical_yn") );
String surgical_yn= checkForNull( request.getParameter( "surgical_yn") );
String queue_secondary_triage= checkForNull( request.getParameter( "queue_secondary_triage") );
String disaster_category_yn= checkForNull( request.getParameter( "disaster_category_yn") );
String disaster_type_code= checkForNull( request.getParameter( "disaster_type_code") );
String disaster_category_code= checkForNull( request.getParameter( "disaster_category_code") );
String checked2= checkForNull( request.getParameter( "checked2") );
String checked9= checkForNull( request.getParameter( "checked9") );
String disOscc= checkForNull( request.getParameter( "disOscc") );
String disable3= checkForNull( request.getParameter( "disable3") );
String called_from_ca= checkForNull( request.getParameter( "called_from_ca") );

String caseType= checkForNull( request.getParameter( "caseType") );
String caseTypeDisable= checkForNull( request.getParameter( "caseTypeDisable") );
String caseTypeMandYn= checkForNull( request.getParameter( "caseTypeMandYn") );
String caseTypeYn= checkForNull( request.getParameter( "caseTypeYn") );
String date_time_of_accident= checkForNull( request.getParameter( "date_time_of_accident") );
String localeName= checkForNull( request.getParameter( "localeName") );
int p_count=0;//Added by krishna Pranay ML-MMOH-CRF-1759.1
String disDateAcci= checkForNull( request.getParameter( "disDateAcci") );
String place_of_accident= checkForNull( request.getParameter( "place_of_accident") );
String disPlaceAcci= checkForNull( request.getParameter( "disPlaceAcci") );
String mech_injury_subcatg_code= checkForNull( request.getParameter( "mech_injury_subcatg_code") );
String vehicle_invlovedcode= checkForNull( request.getParameter( "vehicle_invlovedcode") );
String Vehicle_Reg_No1= checkForNull( request.getParameter( "Vehicle_Reg_No1") );
String dis6= checkForNull( request.getParameter( "dis6") );
String dis8= checkForNull( request.getParameter( "dis8") );
String dis9= checkForNull( request.getParameter( "dis9") );
String dis10= checkForNull( request.getParameter( "dis10") );
String dis11= checkForNull( request.getParameter( "dis11") );
String dis12= checkForNull( request.getParameter( "dis12") );
String dis13= checkForNull( request.getParameter( "dis13") );
String protective_device_code= checkForNull( request.getParameter( "protective_device_code") );
String pat_position_code= checkForNull( request.getParameter( "pat_position_code") );
String checked3= checkForNull( request.getParameter( "checked3") );
String checked5= checkForNull( request.getParameter( "checked5") );
String checked6= checkForNull( request.getParameter( "checked6") );
String checked7= checkForNull( request.getParameter( "checked7") );
String disMLC= checkForNull( request.getParameter( "disMLC") );
String MLC_DEATH_YN= checkForNull( request.getParameter( "MLC_DEATH_YN") );
String disMLCDeath= checkForNull( request.getParameter( "disMLCDeath") );
String pol_rep_no_mx_size= checkForNull( request.getParameter( "pol_rep_no_mx_size") );
String pol_stn_det_mx_size= checkForNull( request.getParameter( "pol_stn_det_mx_size") );
String police_station_dtls= checkForNull( request.getParameter( "police_station_dtls") );
String police_rep_no= checkForNull( request.getParameter( "police_rep_no") );
String MLC_NO_OUTSIDE_DTLS= checkForNull( request.getParameter( "MLC_NO_OUTSIDE_DTLS") );
String disOutMLCDet= checkForNull( request.getParameter( "disOutMLCDet") );
String MLC_CAPTURE_DATE= checkForNull( request.getParameter( "MLC_CAPTURE_DATE") );
String disDateOfCapt= checkForNull( request.getParameter( "disDateOfCapt") );
String disMLCRemark= checkForNull( request.getParameter( "disMLCRemark") );
String MLC_REMARKS= checkForNull( request.getParameter( "MLC_REMARKS") );
String initialMgmtLblName= checkForNull( request.getParameter( "initialMgmtLblName") );
String order_catalog_code1= checkForNull( request.getParameter( "order_catalog_code1") );
String order_catalog_code2= checkForNull( request.getParameter( "order_catalog_code2") );
String order_catalog_code3= checkForNull( request.getParameter( "order_catalog_code3") );
String order_catalog_code4= checkForNull( request.getParameter( "order_catalog_code4") );
String order_catalog_code5= checkForNull( request.getParameter( "order_catalog_code5") );
String order_catalog_code6= checkForNull( request.getParameter( "order_catalog_code6") );
String FBCProp= checkForNull( request.getParameter( "FBCProp") );
String ECGProp= checkForNull( request.getParameter( "ECGProp") );
String DressProp= checkForNull( request.getParameter( "DressProp") );
String SpO2Prop= checkForNull( request.getParameter( "SpO2Prop") );
String dressingLblName= checkForNull( request.getParameter( "dressingLblName") );
String intialMgmtOthers= checkForNull( request.getParameter( "intialMgmtOthers") );
String disIntialMgmtOthers= checkForNull( request.getParameter( "disIntialMgmtOthers") );
String dis14= checkForNull( request.getParameter( "dis14") );
String dis15= checkForNull( request.getParameter( "dis15") );
String disImmobil= checkForNull( request.getParameter( "disImmobil") );
String immobilization= checkForNull( request.getParameter( "immobilization") );
String selected= checkForNull( request.getParameter( "selected") );
String selected1= checkForNull( request.getParameter( "selected1") );
String selected2= checkForNull( request.getParameter( "selected2") );
String checked4= checkForNull( request.getParameter( "checked4") );
String checked8= checkForNull( request.getParameter( "checked8") );
int patient_age= Integer.parseInt(checkForNull( request.getParameter( "patient_age") ));
int max_age_paediatric= Integer.parseInt(( request.getParameter( "max_age_paediatric") ));
int min_age_pregnancy= Integer.parseInt(checkForNull( request.getParameter( "min_age_pregnancy") ));
String sex= checkForNull( request.getParameter( "sex") );
String pediatric_status= checkForNull( request.getParameter( "pediatric_status") );
String disabled991= checkForNull( request.getParameter( "disabled991") );
String disImm= checkForNull( request.getParameter( "disImm") );
String disMenarche= checkForNull( request.getParameter( "disMenarche") );
String disabled99= checkForNull( request.getParameter( "disabled99") );
String disHeight= checkForNull( request.getParameter( "disHeight") );
String disWeight= checkForNull( request.getParameter( "disWeight") );
String height= checkForNull( request.getParameter( "height") );
String weight= checkForNull( request.getParameter( "weight") );
String capBloodSugProp= checkForNull( request.getParameter( "capBloodSugProp") );
String cbdProp= checkForNull( request.getParameter( "cbdProp") );
String medication= checkForNull( request.getParameter( "medication") );
String disMedication= checkForNull( request.getParameter( "disMedication") );
String fbccheck= checkForNull( request.getParameter( "fbccheck") );
String fbccheck_val= checkForNull( request.getParameter( "fbccheck_val") );
String disCir= checkForNull( request.getParameter( "disCir") );
String disabled= checkForNull( request.getParameter( "disabled") );
String menstrual_status= checkForNull( request.getParameter( "menstrual_status") );
String disabledPre= checkForNull( request.getParameter( "disabledPre") );
String min_age_for_lmp= checkForNull( request.getParameter( "min_age_for_lmp") );
String year_value= checkForNull( request.getParameter( "year_value") );
int minageforlmp= Integer.parseInt(checkForNull( request.getParameter( "minageforlmp") ));
String lmp_date= checkForNull( request.getParameter( "lmp_date") );
String lmpdate1=checkForNull( request.getParameter( "lmp_date") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String clinical_notes_status= checkForNull( request.getParameter( "clinical_notes_status") );
String patient_class= checkForNull( request.getParameter( "patient_class") );
String episode_id= checkForNull( request.getParameter( "episode_id") );
String loginUser= checkForNull( request.getParameter( "loginUser") );
String ca_chart_rec_status= checkForNull( request.getParameter( "ca_chart_rec_status") );
String sys_date_qry= checkForNull( request.getParameter( "sys_date_qry") );
String circumference= checkForNull( request.getParameter( "circumference") );
String Vehicle_Reg_No2= checkForNull( request.getParameter( "Vehicle_Reg_No2") );
String vehicle_invlovedcode1= checkForNull( request.getParameter( "vehicle_invlovedcode1") );
String mech_injr_code= checkForNull( request.getParameter( "mech_injr_code") );
String PositionSql= checkForNull( request.getParameter( "PositionSql") );
String invokeMenstrualHistYN= checkForNull( request.getParameter( "invokeMenstrualHistYN") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String latestMensDtlStatus= checkForNull( request.getParameter( "latestMensDtlStatus") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String rec_view_lmp_details_label= checkForNull( request.getParameter( "rec_view_lmp_details_label") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String function_id= checkForNull( request.getParameter( "function_id") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String MensdisabledPre= checkForNull( request.getParameter( "MensdisabledPre") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String lastMensPeriod="",lastPeriodWeeks="",lastPeriodDays ="",lastPeriodEdd ="",unsureDatePeriod ="",unsureDateWeeks ="",unsureDateDays  ="",unsureRedd  ="",CALmpDate="",CAWeeks="",CADays="", CAEdd="",exisitng_pregency_yn="";	//Added by krishna Pranay ML-MMOH-CRF-1759.1
StringBuffer sqlPosition= new StringBuffer( checkForNull(request.getParameter( "sqlPosition")));

int countECG =0, countDerss=0, countSpO2=0, countCapBlood=0,countCBD=0,yearvalue=0;

Boolean isPriorityZoneAppl			= false;
Boolean modeofarrival=false;
Boolean isCaseDtlsRadioBtnAppl	= false;
Boolean isMechInjLabelChngAppl	= false;
Boolean isReconfirmCOTAppl = false;
Boolean isChngBtnPositionAppl = false;
Boolean isOrderCatalogChngAppl	= false;
Boolean isMLCAppl = false;
boolean isSecondaryTriageQueueNum = false;


try{
	 con = ConnectionManager.getConnection(request);
	 
	 boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
		/*end ML-MMOH-CRF-0354 [IN057191] */
		/*Below query modified for this CRF AAKH-CRF-0010 [IN038535]*/
		Boolean isLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131
		/*Below query modified for this CRF ML-MMOH-CRF-0644 [IN:062162]*/
		boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF");  
		//Added by Mano on 20-jan-2017 for MMOH-CRF-0644
		Boolean isPlaceOfOccuurrence = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","PLACE_OF_OCCURRENCE");  // Added by mujafar for ML-MMOH-CRF-0647
		//Below line added for this CRF ML-MMOH-CRF-0654
		 modeofarrival = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SECONDARY_TRIAGE");  
		 Boolean isReplacePresntngPrblmByChiefComp = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","REPLACE_PRE_PROB_BY_CHF_COMPL"); //Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650
		isCaseDtlsRadioBtnAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_CASE_DETAILS");//Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-645
		isMechInjLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","RENAME_MECH_INJ_SUB_INJ");//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-649
		Boolean isSecTrgBackDateTimeAppl=eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRG_BACK_DATE_APPL");// Added by Shanmukh on 6th-Apr-2018 for ML-MMOH-CRF-0656
		isChngBtnPositionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","DIAGNOSIS_DTLS_IN_24HRS_VISIT");//Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655
		isOrderCatalogChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_ORDER_CATALOG");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		isPriorityZoneAppl			= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147
		isMLCAppl 			=eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "MLC_DTLS");//Added by Ajay Hatwate for GHL-CRF-0650
		//Added by Ajay Hatwate for ML-MMOH-CRF-2069
		isSecondaryTriageQueueNum = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SECONDARY_TRIAGE_QNUM");
		//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		isReconfirmCOTAppl		= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "RECONFIRM_CASE_OF_TRAUMA");
	

            _bw.write(_wl_block3Bytes, _wl_block3);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);
}
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 } 
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(isSecTrgBackDateTimeAppl){
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 if(display_triage_record_date_time.equals("")){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
}else {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(display_triage_record_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
}else if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block34Bytes, _wl_block34);
 } 
            _bw.write(_wl_block35Bytes, _wl_block35);

	String secTrgRecDateTimeList=eAE.AECommonBean.getAETrgRecDateTime(con,facilityId,encounter_id,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	 	
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(secTrgRecDateTimeList));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sqlDate));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		if(!five_level_triage_appl_yn.equals("Y")){
            _bw.write(_wl_block42Bytes, _wl_block42);

		  
		  if(isPriorityZoneAppl){
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disPriority));
            _bw.write(_wl_block44Bytes, _wl_block44);

		try{
		sql2="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' and PRIORITY_ZONE not in('B','W') order by PRIORITY_ZONE_ORDER";
				
			    pstmt   = con.prepareStatement(sql2);
				pstmt.setString(1,locale) ;
				rset    = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				{
					if(rset.getString("PRIORITY_ZONE").equals(priority))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";
							   
					out.println("<option value='"+rset.getString("PRIORITY_ZONE")+"'"+optSelected+">"+rset.getString("PRIORITY_ZONE_DESC")+""); 
				}
		    }catch(Exception e){e.printStackTrace();}
						
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(red));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(priorityStatus1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disabled111));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(yellow));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(priorityStatus2));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disabled12));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(green));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(priorityStatus3));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disabled13));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(prioritynewdisabled));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
 
	    		String sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC,PRIORITY_ZONE_COLOR,PRIORITY_ZONE_ORDER FROM AE_PRIORITY_ZONE_LANG_VW ##REPDB## WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sql1.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1,locale) ;
				rset1    = pstmt.executeQuery();
				while(rset1!=null && rset1.next()){
					priority_zone_code	= rset1.getString("PRIORITY_ZONE");
					priority_zone_desc	= rset1.getString("PRIORITY_ZONE_DESC");
					priority_zone_order	=(rset1.getString("PRIORITY_ZONE_ORDER")==null || rset1.getString("PRIORITY_ZONE_ORDER")=="")?"":rset1.getString("PRIORITY_ZONE_ORDER");
					priority_zone_color = (rset1.getString("PRIORITY_ZONE_COLOR")==null || rset1.getString("PRIORITY_ZONE_COLOR")=="")?"":rset1.getString("PRIORITY_ZONE_COLOR");
					priority_zone_hidden_fileds	= priority_zone_hidden_fileds+"<input type='hidden' name='priority_zone_order_by_"+priority_zone_code+"' id='priority_zone_order_by_"+priority_zone_code+"' value='"+priority_zone_order+"'>";
					if(priority.equals(priority_zone_code)){
						priority_selected	= "selected";
						priority_no			= priority_zone_order;
					}else{
						priority_selected	= "";
					}
				
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(priority_selected));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
if(prioritynewdisabled.equals("")){ 
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);

		 if(rset1!=null) rset1.close();
		 if(pstmt1!=null) pstmt1.close();
	    	
	    } 
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disPriority));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"'  and PRIORITY_ZONE=? and EFF_STATUS='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlpriority.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 pstmt.setString(1,priority);
					     rset = pstmt.executeQuery();
						 
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(priority_code))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   
            _bw.write(_wl_block71Bytes, _wl_block71);

		            // System.out.println(isSecondaryTriageQueueNum + " isSecondaryTriageQueueNum " + queue_no + " queue_no "  + priority + " priority");
		             if(!modify_flag.equals("Y") && priority.equals(queue_appl_priority_zone)){
		            	 dis_queue_no = " ";
		             }
		             if(isSecondaryTriageQueueNum && queue_secondary_triage.equals("Y")){ 
            _bw.write(_wl_block72Bytes, _wl_block72);
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(queue_no ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(dis_queue_no ));
            _bw.write(_wl_block76Bytes, _wl_block76);
 
					 String queue_no_mand_img_dis = " disabled ";
					 if(queue_num_mandatory.equals("Y") && !modify_flag.equals("Y") && !priority.equals("U")){ 
						 queue_no_mand_img_dis = " ";
					 }
            _bw.write(_wl_block77Bytes, _wl_block77);

		             
		             int ex_queue_count = 0;
		             StringBuffer sqlTreatA = new StringBuffer();
					 sqlTreatA.append(" select count(*) count from  ae_queue_no_audit where PATIENT_ID=?  and encounter_id=? order by ADDED_DATE desc ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlTreatA.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/
					 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					 pstmt.setString(1,patient_id);
					 pstmt.setString(2,encounter_id);
					
					 rset = pstmt.executeQuery();
					 
					 while(rset!=null && rset.next())
					   {
						 ex_queue_count =rset.getInt("count");
						}
					 if(pstmt!=null) pstmt.close();
					 if(rset!=null) rset.close();
					 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
					 {
						sqlTreatA.delete(0,sqlTreatA.length());
					 }
		             if(ex_queue_count > 1){ 
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
 }
					 } 
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block82Bytes, _wl_block82);

				 StringBuffer sqlTreatA = new StringBuffer();
				 sqlTreatA.append("SELECT treatment_area_code, short_desc FROM ae_tmt_area_for_clinic_lang_vw ##REPDB## WHERE language_id='"+locale+"'  and facility_id = ? AND clinic_code = ?  AND priority_zone = ?  AND  (gender = ? OR gender IS NULL) ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlTreatA.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				 pstmt.setString(1,facilityId);
				 pstmt.setString(2,clinic_code);
				 pstmt.setString(3,priority);
				 pstmt.setString(4,patient_gender);
				
				 rset = pstmt.executeQuery();
				 
				 while(rset!=null && rset.next())
				   {
					 String code =rset.getString(1);
					 String desc =specialCharacter(rset.getString(2));
					 if (code.equals("null") || code==null) 
						 code="";
					  if (desc.equals("null") || desc==null) 
						 desc="";
					  if(code.equals(treat_code))
					   {
							optSelectedTreat="selected";
					   }
					   else
						   optSelectedTreat="";
			   
					   sbBuff.append("<option value=\""+code+"\" "+optSelectedTreat+">"+desc+"</option>");
				  }
				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
				 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
				 {
					sqlTreatA.delete(0,sqlTreatA.length());
				 }
				 
			   
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disTreatArea));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(sbBuff.toString()));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(disBed));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(disBed1));
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(checked1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disDisaster));
            _bw.write(_wl_block93Bytes, _wl_block93);

			 if(allowSplChar)
			 {
			 
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(dis_regn_ref));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block97Bytes, _wl_block97);

			 }
			 else
			 {
			 
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(dis_regn_ref));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block101Bytes, _wl_block101);

			 }
			 
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(dis_area));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block107Bytes, _wl_block107);
 if(disaster_category_yn.equals("N")){ 
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
  
                  try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
				  sqlFinal = "select a.disaster_type_code, a.short_desc from ae_disaster_type_lang_vw ##REPDB## a where a.language_id='"+locale+"'  and  a.eff_status='E' and  a.disaster_type_code like '%%' order by short_desc";
				  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
                  pstmtTrans = con.prepareStatement(sqlFinal);
				  /*End*/
				   rsetTrans = pstmtTrans.executeQuery();
				   while(rsetTrans!=null && rsetTrans.next())
					{
					  if(rsetTrans.getString(1).equals(disaster_type_code))
							   {
                                    optSelected="selected";			
							   }
							   else
							   {
								   optSelected="";				      
							   }
					  out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"' "+optSelected+" >"+rsetTrans.getString("short_desc")+""); 
					}
                  if(rsetTrans!=null) rsetTrans.close();
				  if(pstmtTrans!=null) pstmtTrans.close();
				  }catch(Exception e) {e.printStackTrace();}
	            
            _bw.write(_wl_block112Bytes, _wl_block112);
} 
            _bw.write(_wl_block113Bytes, _wl_block113);
if(disaster_category_yn.equals("Y")){ 
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

				try {	
					pstmt = con.prepareStatement("select disaster_category_code, short_desc from ae_disaster_category where eff_status = 'E'");
					rset = pstmt.executeQuery();
					while(rset!=null && rset.next()) {
						if(rset.getString(1).equals(disaster_category_code)){
							out.println("<option value='"+rset.getString(1)+"' selected>"+rset.getString(2)+" ");
						}else{
							out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");							
						}
					}
				    if(pstmt!=null) pstmt.close();
 			        if(rset!=null) rset.close();
				}catch (Exception e) {e.printStackTrace();}
			
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
if(modifyYN.equals("Y")){  
	                  try
					  {	
					   PreparedStatement pstmtTrans = null;
					   ResultSet rsetTrans = null;
					   optSelected="";
					  sqlFinal = "SELECT DISASTER_TYPE_CODE,SHORT_DESC FROM  AE_DISASTER_TYPE ##REPDB## WHERE DISASTER_CATEGORY_CODE=? AND EFF_STATUS='E' ORDER BY 2";
					  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	                  pstmtTrans = con.prepareStatement(sqlFinal);
	                  pstmtTrans.setString(1, disaster_category_code);
					   rsetTrans = pstmtTrans.executeQuery();
					   
					   while(rsetTrans!=null && rsetTrans.next())
						{
						  if(rsetTrans.getString(1).equals(disaster_type_code))
								   {
	                                    out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"'  selected >"+rsetTrans.getString("short_desc")+""); 
								   }
						}
	                  if(rsetTrans!=null) rsetTrans.close();
					  if(pstmtTrans!=null) pstmtTrans.close();
					  }catch(Exception e) {e.printStackTrace();}
				  }
            _bw.write(_wl_block119Bytes, _wl_block119);
} 
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(visit_date));
            _bw.write(_wl_block121Bytes, _wl_block121);
if(modify_flag.equals("Y")) { 
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(a_status))
							   {
                                    optSelected="selected";	
							   }
							   else
							   {
								   optSelected="";	      
							   }	  
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   
            _bw.write(_wl_block127Bytes, _wl_block127);

		     }
			 if(modify_flag.equals("N")) {
		     
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery(); 
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   
            _bw.write(_wl_block132Bytes, _wl_block132);
}
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(attend_practitioner_name));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
if(modeofarrival){
		  
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw ##REPDB## WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlAMTrans.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/
                   pstmtTrans = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1				
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next()){	
				  
						if(rsetTrans.getString(1).equals(transport_mode_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
                       out.println("<option value='"+rsetTrans.getString(1)+"'"+optSelected+">"+rsetTrans.getString(2)+" "); 					
				  }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(accompanied_by_dis));
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   optSelected="";	
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW ##REPDB## WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlAMEsc.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/

				   pstmtAccom = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next()){
					 
						if(rsetAccom.getString(1).equals(accompanied_by_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
						   out.println("<option value='"+rsetAccom.getString(1)+"'"+optSelected+">"+rsetAccom.getString(2)+" ");
										
					}
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             
            _bw.write(_wl_block150Bytes, _wl_block150);
}
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
if(pat_dtls_unknown_yn.equals("N")){
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(disRefID));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(disRefID));
            _bw.write(_wl_block157Bytes, _wl_block157);
}else if(pat_dtls_unknown_yn.equals("Y")) {
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block159Bytes, _wl_block159);
if(!isReplacePresntngPrblmByChiefComp){ 
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(complaint));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block165Bytes, _wl_block165);
}else{
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")));
            _bw.write(_wl_block167Bytes, _wl_block167);
}
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(dis2));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(triage_remarks));
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(checked9));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(disOscc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

								JSONArray osccTypeJsonArr	= new JSONArray();
								osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(con,locale,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	
									
								for(int i = 0 ; i < osccTypeJsonArr.size() ; i++) 
								{
									JSONObject osccTypejson		= (JSONObject)osccTypeJsonArr.get(i);
									String injCategoryCode		= (String) osccTypejson.get("injCategoryCode");
									String injSubCategoryCode	= (String) osccTypejson.get("injSubCategoryCode");
									String subCategoryShortDesc	= (String) osccTypejson.get("subCategoryShortDesc");
											
									out.println("<option value="+injCategoryCode+","+injSubCategoryCode+">"+subCategoryShortDesc+"</option>");
											
								}
											
						
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(checkedMed));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disMed));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(checkedSur));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disSur));
            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(checkedOandGYn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disOandGYn));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block194Bytes, _wl_block194);
 }else{ 
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(checked9));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(disOscc));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable3));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(checkedMed));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disMed));
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(checkedSur));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disSur));
            _bw.write(_wl_block209Bytes, _wl_block209);
 } 
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(called_from_ca));
            _bw.write(_wl_block212Bytes, _wl_block212);
 if(caseTypeYn.equals("Y")){ 
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(caseTypeDisable));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

			   StringBuffer sqlCaseType = new StringBuffer();
			 	 
			 
			   sqlCaseType.append("SELECT case_type_code, short_desc FROM ae_case_type WHERE EFF_STATUS ='E' ORDER BY 2");

			   pstmt = con.prepareStatement(sqlCaseType.toString());
			   rset = pstmt.executeQuery();
			   while(rset!=null && rset.next())
			   {				   
				  if(caseType.equals(rset.getString(1))){
				 	out.println("<option value='"+rset.getString(1)+"' selected >"+rset.getString(2)+" ");
				  }else{
					out.println("<option value='"+rset.getString(1)+"' >"+rset.getString(2)+" ");  
				  }
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null)	rset.close();
			   if((sqlCaseType != null) && (sqlCaseType.length() > 0))
				 {
				   sqlCaseType.delete(0,sqlCaseType.length());
				 } 
			   
            _bw.write(_wl_block217Bytes, _wl_block217);
if(caseTypeMandYn.equals("Y")){ 
            _bw.write(_wl_block218Bytes, _wl_block218);
} 
            _bw.write(_wl_block219Bytes, _wl_block219);
} 
            _bw.write(_wl_block220Bytes, _wl_block220);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block221Bytes, _wl_block221);
 } 
            _bw.write(_wl_block222Bytes, _wl_block222);
if(isPlaceOfOccuurrence == true){
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
}else{
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
}
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(disDateAcci));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(disDateAcci));
            _bw.write(_wl_block230Bytes, _wl_block230);
if(isLabelChngAppl == true){ 
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);
}
			  else if(isPlaceOfOccuurrence == true){
			  
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

			  }
			  else{
				
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block236Bytes, _wl_block236);
} 
            _bw.write(_wl_block237Bytes, _wl_block237);
if(isPlaceOfOccuurrence == false){
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(place_of_accident));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(disPlaceAcci));
            _bw.write(_wl_block157Bytes, _wl_block157);
}
			else{	
			
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(disPlaceAcci));
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
  
                  try 
				  {	
				   PreparedStatement pstmtTrans1 = null;
				   ResultSet rsetTrans1 = null;
				   /*Above line commented and below code added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = "select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE ##REPDB## where  eff_status='E' order by short_desc";
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					pstmtTrans1 = con.prepareStatement(sqlFinal);
					/*End*/		
				   rsetTrans1 = pstmtTrans1.executeQuery();   
				   while(rsetTrans1!=null && rsetTrans1.next())
					{ 
						 if(rsetTrans1.getString(1).equals(place_of_accident))
							   {
                                    optSelected="selected";				
							   }
							   else
							   {
								   optSelected="";				      
							   }
					  out.println("<option value='"+rsetTrans1.getString("PLACE_OCCURRENCE_TYPE_CODE")+"' "+optSelected+" >"+rsetTrans1.getString("short_desc")+""); 		  
					}
                  if(rsetTrans1!=null) rsetTrans1.close();
				  if(pstmtTrans1!=null) pstmtTrans1.close();
				  }catch(Exception e) {/* out.println("Exception in Place of Occurrence="+e);	 */		e.printStackTrace();}
	            
            _bw.write(_wl_block244Bytes, _wl_block244);
}
            _bw.write(_wl_block245Bytes, _wl_block245);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
 }else{ 
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
 } 
            _bw.write(_wl_block249Bytes, _wl_block249);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block251Bytes, _wl_block251);
 }else{ 
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block251Bytes, _wl_block251);
 } 
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(dis6));
            _bw.write(_wl_block254Bytes, _wl_block254);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

					  //if(modify_flag.equals("Y")) {
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW ##REPDB##  WHERE language_id='"+locale+"'  and EFF_STATUS='E' and   oscc_yn=  '"+oscc_yn+"'  ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 	/*modify_flag is commented and above query is modifed by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

						/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlMechaInjury.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 
						 	 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString("INJ_CATEGORY_CODE").equals(mech_injr_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";

                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlMechaInjury != null) && (sqlMechaInjury.length() > 0))
						 {
							sqlMechaInjury.delete(0,sqlMechaInjury.length());
						 }
					  // } 
					   
            _bw.write(_wl_block255Bytes, _wl_block255);
 if(!isMechInjLabelChngAppl){ 
            _bw.write(_wl_block256Bytes, _wl_block256);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block257Bytes, _wl_block257);
 } 
            _bw.write(_wl_block258Bytes, _wl_block258);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block259Bytes, _wl_block259);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);
 } 
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(mech_injury_subcatg_code));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block264Bytes, _wl_block264);
 } 
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block268Bytes, _wl_block268);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

						 StringBuffer sqlVehicleInv = new StringBuffer();
						 sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw ##REPDB## where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"' and ARRIVAL_CODE like '%%' order by 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlVehicleInv.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode))
							   {
                                    optSelected="selected";										
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   
            _bw.write(_wl_block269Bytes, _wl_block269);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(dis9));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block272Bytes, _wl_block272);

						 pstmt = con.prepareStatement(sqlFinal);
					     rset = pstmt.executeQuery();
						  
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode1))
							   {
                                    optSelected="selected";										
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlVehicleInv != null) && (sqlVehicleInv.length() > 0))
						 {
							sqlVehicleInv.delete(0,sqlVehicleInv.length());
						 }
					   
            _bw.write(_wl_block273Bytes, _wl_block273);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(Vehicle_Reg_No1));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(Vehicle_Reg_No2));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block278Bytes, _wl_block278);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(dis10));
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block281Bytes, _wl_block281);

			   StringBuffer sqlProtect = new StringBuffer();
			  // sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' ORDER BY 2");
			   sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  and EFF_STATUS ='E' and PROTECTIVE_DEVICE_CODE like '%%' ORDER BY 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlProtect.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
			   pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   rset = pstmt.executeQuery();    
			   optSelected="";
			   while(rset!=null && rset.next())
			   {
					if(rset.getString(1).equals(protective_device_code))
				   {
						optSelected="selected";									
				   }
				   else
					   optSelected=""; 
				  out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null) rset.close();
			   if((sqlProtect != null) && (sqlProtect.length() > 0))
				 {
					sqlProtect.delete(0,sqlProtect.length());
				 }
			   
            _bw.write(_wl_block282Bytes, _wl_block282);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(dis11));
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

						   pstmt = con.prepareStatement(PositionSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  if(rset.getString(1).equals(pat_position_code))
							   {
                                    optSelected="selected";								
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlPosition != null) && (sqlPosition.length() > 0))
							{
								sqlPosition.delete(0,sqlPosition.length());
							}
					   
            _bw.write(_wl_block285Bytes, _wl_block285);
if(siteSpecific){
            _bw.write(_wl_block286Bytes, _wl_block286);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block287Bytes, _wl_block287);
}else {
            _bw.write(_wl_block288Bytes, _wl_block288);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
}
            _bw.write(_wl_block289Bytes, _wl_block289);
if(siteSpecific){
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block290Bytes, _wl_block290);
}else{
            _bw.write(_wl_block291Bytes, _wl_block291);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block292Bytes, _wl_block292);
}
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(checked3));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(disMLC));
            _bw.write(_wl_block296Bytes, _wl_block296);
 if(isMLCAppl){ 
            _bw.write(_wl_block297Bytes, _wl_block297);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(MLC_DEATH_YN ));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(disMLCDeath ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(MLC_DEATH_YN.equals("Y")?" Checked ":"" ));
            _bw.write(_wl_block300Bytes, _wl_block300);
}else{ 
            _bw.write(_wl_block301Bytes, _wl_block301);
 }
            _bw.write(_wl_block302Bytes, _wl_block302);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(pol_rep_no_mx_size ));
            _bw.write(_wl_block89Bytes, _wl_block89);
 if(isMLCAppl){ 
            _bw.write(_wl_block304Bytes, _wl_block304);
} 
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(police_rep_no));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(dis12));
            _bw.write(_wl_block307Bytes, _wl_block307);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(pol_stn_det_mx_size ));
            _bw.write(_wl_block89Bytes, _wl_block89);
 if(isMLCAppl){ 
            _bw.write(_wl_block304Bytes, _wl_block304);
} 
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(police_station_dtls));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(dis13));
            _bw.write(_wl_block311Bytes, _wl_block311);
 if(isMLCAppl){ 
            _bw.write(_wl_block312Bytes, _wl_block312);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(MLC_NO_OUTSIDE_DTLS ));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(disOutMLCDet ));
            _bw.write(_wl_block315Bytes, _wl_block315);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(MLC_CAPTURE_DATE ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(disDateOfCapt ));
            _bw.write(_wl_block317Bytes, _wl_block317);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(disMLCRemark ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(MLC_REMARKS));
            _bw.write(_wl_block319Bytes, _wl_block319);
} 
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);
}
            _bw.write(_wl_block321Bytes, _wl_block321);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 } 
            _bw.write(_wl_block322Bytes, _wl_block322);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(isSecTrgBackDateTimeAppl){
            _bw.write(_wl_block323Bytes, _wl_block323);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 if(display_triage_record_date_time.equals("")){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block325Bytes, _wl_block325);
}else {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(display_triage_record_date_time));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
}else if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block34Bytes, _wl_block34);
 } 
            _bw.write(_wl_block329Bytes, _wl_block329);
 if(isOrderCatalogChngAppl && !initialMgmtLblName.trim().equals("")){ 
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(initialMgmtLblName));
            _bw.write(_wl_block224Bytes, _wl_block224);
 }else{ 
            _bw.write(_wl_block331Bytes, _wl_block331);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
 } 
            _bw.write(_wl_block332Bytes, _wl_block332);
if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				   StringBuffer sqlOrderCatalog6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b  where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   sqlECG3.append(sqlECG1);
				   sqlECG4.append(sqlECG1);
				   sqlECG5.append(sqlECG1);
				   sqlOrderCatalog6.append(sqlECG1);//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   StringBuffer s1 = new StringBuffer();
				   StringBuffer s3 = new StringBuffer();
				   StringBuffer s4 = new StringBuffer();
				   StringBuffer s5 = new StringBuffer();
				   StringBuffer s6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   s1.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code2+"'");
				   s3.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code4+"'");
				   s4.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code1+"'");
				   s5.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code5+"'");
				   s6.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code6+"'");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG1.append(s1).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countECG=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }

					  if (countECG>0)
					  {
						  ECGProp = "checked";
					  }else
					  {
						  ECGProp ="";
					  }
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG3.append(s3).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countDerss=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countDerss>0)
					  {
						  DressProp = "checked";
					  }else
					  {
						  DressProp ="";
					  }
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG4.append(s4).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countSpO2=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countSpO2>0)
					  {
						  SpO2Prop = "checked";
					  }else
					  {
						  SpO2Prop ="";
					  }
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG5.append(s5).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countCapBlood=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countCapBlood>0)
					  {
						  capBloodSugProp = "checked";
					  }else
					  {
						  capBloodSugProp ="";
					  }
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlOrderCatalog6.append(s6).toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				pstmtEncounter = con.prepareStatement(sqlFinal);
				rsetEncounter = pstmtEncounter.executeQuery();
				while(rsetEncounter!=null && rsetEncounter.next()){
				      countCBD = rsetEncounter.getInt(1);
				}
		  	    if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
				if (countCBD > 0){
					cbdProp = "checked";
				}else{
					cbdProp ="";
				}/*End*/
	}catch(Exception e) {e.printStackTrace();}
  
            _bw.write(_wl_block333Bytes, _wl_block333);
 if(isOrderCatalogChngAppl){ 
            _bw.write(_wl_block334Bytes, _wl_block334);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(cbdProp));
            _bw.write(_wl_block337Bytes, _wl_block337);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(medication));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(disMedication));
            _bw.write(_wl_block340Bytes, _wl_block340);
 }else{ 
            _bw.write(_wl_block341Bytes, _wl_block341);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(capBloodSugProp));
            _bw.write(_wl_block343Bytes, _wl_block343);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(SpO2Prop));
            _bw.write(_wl_block345Bytes, _wl_block345);
 } 
            _bw.write(_wl_block346Bytes, _wl_block346);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(FBCProp));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fbccheck));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(fbccheck_val));
            _bw.write(_wl_block350Bytes, _wl_block350);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(ECGProp));
            _bw.write(_wl_block352Bytes, _wl_block352);
 if(isOrderCatalogChngAppl){ 
            _bw.write(_wl_block353Bytes, _wl_block353);
 if(!dressingLblName.trim().equals("")){ 
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(dressingLblName));
            _bw.write(_wl_block355Bytes, _wl_block355);
 }else{
            _bw.write(_wl_block354Bytes, _wl_block354);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block355Bytes, _wl_block355);
 } 
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(DressProp));
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(intialMgmtOthers));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(disIntialMgmtOthers));
            _bw.write(_wl_block361Bytes, _wl_block361);
 }else{ 
            _bw.write(_wl_block362Bytes, _wl_block362);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(DressProp));
            _bw.write(_wl_block365Bytes, _wl_block365);
 } 
            _bw.write(_wl_block366Bytes, _wl_block366);
}
            _bw.write(_wl_block367Bytes, _wl_block367);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(disImmobil));
            _bw.write(_wl_block370Bytes, _wl_block370);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block371Bytes, _wl_block371);

			          try{
			               StringBuffer sqlImmob = new StringBuffer();
                           sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw ##REPDB## where language_id='"+locale+"' and eff_status='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						   sqlFinal = sqlImmob.toString();
						   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						   /*End*/
			               pstmt=con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						   rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(immobilization))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							    out.println( "<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+""); 
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   if((sqlImmob != null) && (sqlImmob.length() > 0))
							 {
								sqlImmob.delete(0,sqlImmob.length());
							 }
						  }catch(Exception e){e.printStackTrace();}
                 
            _bw.write(_wl_block372Bytes, _wl_block372);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block373Bytes, _wl_block373);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(dis14));
            _bw.write(_wl_block375Bytes, _wl_block375);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block377Bytes, _wl_block377);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block379Bytes, _wl_block379);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block379Bytes, _wl_block379);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block381Bytes, _wl_block381);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(checked4));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dis15));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(ca_install_yn));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(max_age_paediatric));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(min_age_pregnancy));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block386Bytes, _wl_block386);
 if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	
            _bw.write(_wl_block387Bytes, _wl_block387);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block388Bytes, _wl_block388);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(checked5));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(disabled991));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disabled99));
            _bw.write(_wl_block392Bytes, _wl_block392);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(checked6));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disImm));
            _bw.write(_wl_block395Bytes, _wl_block395);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(checked7));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disMenarche));
            _bw.write(_wl_block398Bytes, _wl_block398);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(disHeight));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(height));
            _bw.write(_wl_block402Bytes, _wl_block402);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block403Bytes, _wl_block403);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(disWeight));
            _bw.write(_wl_block406Bytes, _wl_block406);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block407Bytes, _wl_block407);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(circumference));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(ca_install_yn));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(max_age_paediatric));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(min_age_pregnancy));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(disCir));
            _bw.write(_wl_block411Bytes, _wl_block411);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block412Bytes, _wl_block412);
 } else{	
			  disabled="";
		 }
            _bw.write(_wl_block413Bytes, _wl_block413);

 
 //ML-MMOH-CRF-1759.1 end
 if(latestMensDtlStatus.equals("A") && modify_flag.equals("N")){		
 	   pstmt1 = con.prepareStatement("SELECT * FROM (SELECT event_status, TO_CHAR(last_menstrual_period, 'DD/MM/YYYY') AS last_menstrual_period, gestation_poa_weeks, gestation_poa_days, TO_CHAR(unsure_of_date, 'DD/MM/YYYY') AS unsure_of_date, gestation_pog_weeks, gestation_pog_days, TO_CHAR(edd, 'DD/MM/YYYY') AS edd, TO_CHAR(redd, 'DD/MM/YYYY') AS redd FROM ca_mens_his_trans_dtl WHERE patient_id =? AND event_status =? ORDER BY added_date DESC) WHERE ROWNUM = 1");
 	   pstmt1.setString(1, patient_id);
 	   pstmt1.setString(2, latestMensDtlStatus);

 	   rset1 = pstmt1.executeQuery();
 	   if (rset1.next()){
 		   lastMensPeriod = rset1.getString("LAST_MENSTRUAL_PERIOD")==null?"":rset1.getString("LAST_MENSTRUAL_PERIOD");
 		   lastPeriodWeeks = rset1.getString("GESTATION_POA_WEEKS")==null?"":rset1.getString("GESTATION_POA_WEEKS");
 		   lastPeriodDays = rset1.getString("GESTATION_POA_DAYS")==null?"":rset1.getString("GESTATION_POA_DAYS");
 		   unsureDatePeriod = rset1.getString("UNSURE_OF_DATE")==null?"":rset1.getString("UNSURE_OF_DATE");
 		   unsureDateWeeks = rset1.getString("GESTATION_POG_WEEKS")==null?"":rset1.getString("GESTATION_POG_WEEKS");
 		   unsureDateDays = rset1.getString("GESTATION_POG_DAYS")==null?"":rset1.getString("GESTATION_POG_DAYS");
 		   lastPeriodEdd = rset1.getString("EDD")==null?"":rset1.getString("EDD");
 		   unsureRedd = rset1.getString("REDD")==null?"":rset1.getString("REDD");

 		   if(!lastMensPeriod.equals(""))
 		   {
 			   CALmpDate=lastMensPeriod;
 		   }
 		   else
 		   {
 			   CALmpDate=unsureDatePeriod;
 		   }
 		   
 		   
 		   if(!lastPeriodWeeks.equals(""))
 		   {
 			   CAWeeks=lastPeriodWeeks;
 		   }
 		   else
 		   {
 			   CAWeeks=unsureDateWeeks;
 		   }
 		   
 		   if(!lastPeriodDays.equals(""))
 		   {
 			   CADays=lastPeriodDays;
 		   }
 		   else
 		   {
 			   CADays=unsureDateDays;
 		   }
 		   
 		   if(!lastPeriodEdd.equals(""))
 		   {
 			   CAEdd=lastPeriodEdd;

 		   }
 		   else
 		   {
 			   CAEdd=unsureRedd;
 		   }
 	   }
 	   if(pstmt1!=null) pstmt1.close();
 	   if(rset1!=null) rset1.close();	
 	}
 else if("Y".equals(invokeMenstrualHistYN) && modify_flag.equals("N")){
	 
	  pstmt1 = con.prepareStatement("SELECT PREGNANT_YN FROM AE_PAT_EMERGENCY_DETAIL WHERE ENCOUNTER_ID = ? AND RECORDED_DATE = (SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE ENCOUNTER_ID =?)");
	 	 pstmt1.setString(1, encounter_id);
	 	 pstmt1.setString(2, encounter_id);
	 	  rset1 = pstmt1.executeQuery();
			    if (rset1.next()){
			    	exisitng_pregency_yn= rset1.getString("PREGNANT_YN");
			    	if(exisitng_pregency_yn.equals("Y"))
			    	{
			    		checked8 = "checked";
			    	}
			    }
			    if(pstmt1!=null) pstmt1.close();
			    if(rset1!=null) rset1.close();	
				 CALmpDate=lmpdate1;
 }

			pstmt = con.prepareStatement("SELECT CASE WHEN COUNT(patient_id) = 1 AND MAX(EVENT_STATUS) = 'E' THEN 0 ELSE COUNT(patient_id) END AS p_count FROM ca_mens_his_trans_dtl WHERE patient_id = ?");
			pstmt.setString(1,patient_id);
			rset1 = pstmt.executeQuery();
			while (rset1.next()) {
				p_count = rset1.getInt(1);
			}
			if (rset1 != null)
				rset1.close();
			if (pstmt != null)
				pstmt.close(); 

		//ML-MMOH-CRF-1759.1 end
 if ((sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) || (sex.equalsIgnoreCase("F") && (patient_age >= Integer.parseInt(min_age_for_lmp))) ){
				 menstrual_status = "true"; 
            _bw.write(_wl_block414Bytes, _wl_block414);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block415Bytes, _wl_block415);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block417Bytes, _wl_block417);
  if ("A".equals(latestMensDtlStatus) && "Y".equals(invokeMenstrualHistYN)){
        	   checked8 = "checked";
           
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(checked8));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block419Bytes, _wl_block419);
  }else{
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(checked8));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(disabledPre));
            _bw.write(_wl_block93Bytes, _wl_block93);
 }
            _bw.write(_wl_block422Bytes, _wl_block422);
if(modify_flag.equals("Y") && invokeMenstrualHistYN.equals("Y") && p_count!=0){ 
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block426Bytes, _wl_block426);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
 }else if(checked8.equals("checked") && invokeMenstrualHistYN.equals("Y")){
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_gender ));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(year_value ));
            _bw.write(_wl_block429Bytes, _wl_block429);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag130 = null ;
            int __result__tag130 = 0 ;

            if (__tag130 == null ){
                __tag130 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag130);
            }
            __tag130.setPageContext(pageContext);
            __tag130.setParent(null);
            __tag130.setKey( rec_view_lmp_details_label 
);
            __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag130;
            __result__tag130 = __tag130.doStartTag();

            if (__result__tag130!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag130== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag130.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag130);
                return;
            }
            _activeTag=__tag130.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag130);
            __tag130.release();
            _bw.write(_wl_block430Bytes, _wl_block430);
}else if(invokeMenstrualHistYN.equals("Y")){ 
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_gender ));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(year_value ));
            _bw.write(_wl_block432Bytes, _wl_block432);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag131 = null ;
            int __result__tag131 = 0 ;

            if (__tag131 == null ){
                __tag131 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag131);
            }
            __tag131.setPageContext(pageContext);
            __tag131.setParent(null);
            __tag131.setKey( rec_view_lmp_details_label 
);
            __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag131;
            __result__tag131 = __tag131.doStartTag();

            if (__result__tag131!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag131== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag131.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag131);
                return;
            }
            _activeTag=__tag131.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag131);
            __tag131.release();
            _bw.write(_wl_block433Bytes, _wl_block433);
}
            _bw.write(_wl_block434Bytes, _wl_block434);

			 if((min_age_for_lmp!=null)&&(year_value!=null))
			 {
				minageforlmp=Integer.parseInt( min_age_for_lmp);
                yearvalue=Integer.parseInt( year_value);
              if(yearvalue>=minageforlmp)
				 {
				   
            _bw.write(_wl_block435Bytes, _wl_block435);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(DateUtils.convertDate(lmp_date,"DMY","en",localeName)));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block440Bytes, _wl_block440);
}else{
            _bw.write(_wl_block435Bytes, _wl_block435);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(DateUtils.convertDate(lmp_date,"DMY","en",localeName)));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block444Bytes, _wl_block444);
}}
            _bw.write(_wl_block445Bytes, _wl_block445);
if(modify_flag.equals("N") && invokeMenstrualHistYN.equals("Y")){ 
            _bw.write(_wl_block446Bytes, _wl_block446);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(lmpdate1));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block450Bytes, _wl_block450);
}else if(modify_flag.equals("Y") && invokeMenstrualHistYN.equals("Y")){ 
            _bw.write(_wl_block451Bytes, _wl_block451);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(lmpdate1));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(MensdisabledPre));
            _bw.write(_wl_block450Bytes, _wl_block450);
} 
            _bw.write(_wl_block453Bytes, _wl_block453);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block454Bytes, _wl_block454);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block455Bytes, _wl_block455);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block456Bytes, _wl_block456);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(CALmpDate));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(CAEdd));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(CADays));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(CAWeeks));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(lmpdate1));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(latestMensDtlStatus));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(checked8));
            _bw.write(_wl_block464Bytes, _wl_block464);
 if (modify_flag.equals("Y")) { 
            _bw.write(_wl_block465Bytes, _wl_block465);
 } 
            _bw.write(_wl_block466Bytes, _wl_block466);
  } 
            _bw.write(_wl_block467Bytes, _wl_block467);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block468Bytes, _wl_block468);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block469Bytes, _wl_block469);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block470Bytes, _wl_block470);
if(five_level_triage_appl_yn.equals("Y")){ 
            _bw.write(_wl_block471Bytes, _wl_block471);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block472Bytes, _wl_block472);
if(clinical_notes_status.equals("A")){
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block475Bytes, _wl_block475);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block476Bytes, _wl_block476);
}else{ 
            _bw.write(_wl_block477Bytes, _wl_block477);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block478Bytes, _wl_block478);
}
			  if(ca_chart_rec_status.equals("A")){
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(sys_date_qry));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block481Bytes, _wl_block481);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block476Bytes, _wl_block476);
}else{ 
            _bw.write(_wl_block482Bytes, _wl_block482);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block476Bytes, _wl_block476);
} 
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block484Bytes, _wl_block484);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
} 
            _bw.write(_wl_block486Bytes, _wl_block486);
}
}catch(Exception e){
	e.printStackTrace();
}
            _bw.write(_wl_block0Bytes, _wl_block0);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ConditionCase.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergyDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Triage.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientCondition.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueNo.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditTrail.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterReference.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisRegnReference.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterArea.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterType.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterType.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ambulatorystatus.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ambulatorystatus.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeofArrival.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AccompaniedBy.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PresentingProblem.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CaseDetails.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OandG.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CaseType.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfOccurrence.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfAccident.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfAccident.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PickupPlace.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfOccurrence.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfAccident.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechOfMainInj.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MechanismofInjury.label", java.lang.String .class,"key"));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechaofSubInjury.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VehiclesInvolved.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.VehicleRegNo.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProtectiveDeviceUsed.label", java.lang.String .class,"key"));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PositionDuringIncident.label", java.lang.String .class,"key"));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlcdetails.label", java.lang.String .class,"key"));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MlcDeath.label", java.lang.String .class,"key"));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceReportNo.label", java.lang.String .class,"key"));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceStationDetails.label", java.lang.String .class,"key"));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OutMlcNoDtls.label", java.lang.String .class,"key"));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateOfMlcCapture.label", java.lang.String .class,"key"));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ConditionCase.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergyDetails.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Triage.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.InitialManagement.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CBD.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Medication.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CapBloodSugar.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.SpO2.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.FBC.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ecg.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Compression.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dressing.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dressing.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Immobilization.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ATTImmunizationDetails.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ImmunizationStatus.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullyImmunized.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PartiallyImmunized.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ATTGiven.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }

    private boolean _jsp__tag117(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag117 = null ;
        int __result__tag117 = 0 ;

        if (__tag117 == null ){
            __tag117 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag117);
        }
        __tag117.setPageContext(pageContext);
        __tag117.setParent(null);
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PediatricDetail.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag117;
        __result__tag117 = __tag117.doStartTag();

        if (__result__tag117!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag117== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag117.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag117);
            return true;
        }
        _activeTag=__tag117.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag117);
        __tag117.release();
        return false;
    }

    private boolean _jsp__tag118(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag118 = null ;
        int __result__tag118 = 0 ;

        if (__tag118 == null ){
            __tag118 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag118);
        }
        __tag118.setPageContext(pageContext);
        __tag118.setParent(null);
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Growth/DevelMilestoneAge.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag118;
        __result__tag118 = __tag118.doStartTag();

        if (__result__tag118!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag118== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag118.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag118);
            return true;
        }
        _activeTag=__tag118.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag118);
        __tag118.release();
        return false;
    }

    private boolean _jsp__tag119(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag119 = null ;
        int __result__tag119 = 0 ;

        if (__tag119 == null ){
            __tag119 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag119);
        }
        __tag119.setPageContext(pageContext);
        __tag119.setParent(null);
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Immunizationuptodate.label", java.lang.String .class,"key"));
        __tag119.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag119;
        __result__tag119 = __tag119.doStartTag();

        if (__result__tag119!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag119== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag119.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag119);
            return true;
        }
        _activeTag=__tag119.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag119);
        __tag119.release();
        return false;
    }

    private boolean _jsp__tag120(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag120 = null ;
        int __result__tag120 = 0 ;

        if (__tag120 == null ){
            __tag120 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag120);
        }
        __tag120.setPageContext(pageContext);
        __tag120.setParent(null);
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Menarche.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag120;
        __result__tag120 = __tag120.doStartTag();

        if (__result__tag120!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag120== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag120.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag120);
            return true;
        }
        _activeTag=__tag120.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag120);
        __tag120.release();
        return false;
    }

    private boolean _jsp__tag121(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag121 = null ;
        int __result__tag121 = 0 ;

        if (__tag121 == null ){
            __tag121 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag121);
        }
        __tag121.setPageContext(pageContext);
        __tag121.setParent(null);
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag121;
        __result__tag121 = __tag121.doStartTag();

        if (__result__tag121!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag121== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag121.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag121);
            return true;
        }
        _activeTag=__tag121.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag121);
        __tag121.release();
        return false;
    }

    private boolean _jsp__tag122(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag122 = null ;
        int __result__tag122 = 0 ;

        if (__tag122 == null ){
            __tag122 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag122);
        }
        __tag122.setPageContext(pageContext);
        __tag122.setParent(null);
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag122;
        __result__tag122 = __tag122.doStartTag();

        if (__result__tag122!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag122== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag122.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag122);
            return true;
        }
        _activeTag=__tag122.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag122);
        __tag122.release();
        return false;
    }

    private boolean _jsp__tag123(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag123 = null ;
        int __result__tag123 = 0 ;

        if (__tag123 == null ){
            __tag123 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag123);
        }
        __tag123.setPageContext(pageContext);
        __tag123.setParent(null);
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
        __tag123.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag123;
        __result__tag123 = __tag123.doStartTag();

        if (__result__tag123!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag123== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag123.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag123);
            return true;
        }
        _activeTag=__tag123.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag123);
        __tag123.release();
        return false;
    }

    private boolean _jsp__tag124(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag124 = null ;
        int __result__tag124 = 0 ;

        if (__tag124 == null ){
            __tag124 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag124);
        }
        __tag124.setPageContext(pageContext);
        __tag124.setParent(null);
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.kg.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag124;
        __result__tag124 = __tag124.doStartTag();

        if (__result__tag124!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag124== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag124.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag124);
            return true;
        }
        _activeTag=__tag124.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag124);
        __tag124.release();
        return false;
    }

    private boolean _jsp__tag125(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag125 = null ;
        int __result__tag125 = 0 ;

        if (__tag125 == null ){
            __tag125 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag125);
        }
        __tag125.setPageContext(pageContext);
        __tag125.setParent(null);
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Circumference.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag125;
        __result__tag125 = __tag125.doStartTag();

        if (__result__tag125!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag125== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag125.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag125);
            return true;
        }
        _activeTag=__tag125.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag125);
        __tag125.release();
        return false;
    }

    private boolean _jsp__tag126(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag126 = null ;
        int __result__tag126 = 0 ;

        if (__tag126 == null ){
            __tag126 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag126);
        }
        __tag126.setPageContext(pageContext);
        __tag126.setParent(null);
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag126;
        __result__tag126 = __tag126.doStartTag();

        if (__result__tag126!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag126== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag126.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag126);
            return true;
        }
        _activeTag=__tag126.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag126);
        __tag126.release();
        return false;
    }

    private boolean _jsp__tag127(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag127 = null ;
        int __result__tag127 = 0 ;

        if (__tag127 == null ){
            __tag127 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag127);
        }
        __tag127.setPageContext(pageContext);
        __tag127.setParent(null);
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MenstrualHistory.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag127;
        __result__tag127 = __tag127.doStartTag();

        if (__result__tag127!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag127== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag127.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag127);
            return true;
        }
        _activeTag=__tag127.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag127);
        __tag127.release();
        return false;
    }

    private boolean _jsp__tag128(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag128 = null ;
        int __result__tag128 = 0 ;

        if (__tag128 == null ){
            __tag128 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag128);
        }
        __tag128.setPageContext(pageContext);
        __tag128.setParent(null);
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PregnantatPresent.label", java.lang.String .class,"key"));
        __tag128.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag128;
        __result__tag128 = __tag128.doStartTag();

        if (__result__tag128!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag128== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag128.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag128);
            return true;
        }
        _activeTag=__tag128.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag128);
        __tag128.release();
        return false;
    }

    private boolean _jsp__tag129(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag129 = null ;
        int __result__tag129 = 0 ;

        if (__tag129 == null ){
            __tag129 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag129);
        }
        __tag129.setPageContext(pageContext);
        __tag129.setParent(null);
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ViewMenstrualHistoryDetails.label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag129;
        __result__tag129 = __tag129.doStartTag();

        if (__result__tag129!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag129== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag129.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag129);
            return true;
        }
        _activeTag=__tag129.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag129);
        __tag129.release();
        return false;
    }

    private boolean _jsp__tag132(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag132 = null ;
        int __result__tag132 = 0 ;

        if (__tag132 == null ){
            __tag132 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag132);
        }
        __tag132.setPageContext(pageContext);
        __tag132.setParent(null);
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.LMPDate.label", java.lang.String .class,"key"));
        __tag132.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag132;
        __result__tag132 = __tag132.doStartTag();

        if (__result__tag132!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag132== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag132.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag132);
            return true;
        }
        _activeTag=__tag132.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag132);
        __tag132.release();
        return false;
    }

    private boolean _jsp__tag133(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag133 = null ;
        int __result__tag133 = 0 ;

        if (__tag133 == null ){
            __tag133 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag133);
        }
        __tag133.setPageContext(pageContext);
        __tag133.setParent(null);
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.LMPDate.label", java.lang.String .class,"key"));
        __tag133.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag133;
        __result__tag133 = __tag133.doStartTag();

        if (__result__tag133!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag133== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag133.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag133);
            return true;
        }
        _activeTag=__tag133.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag133);
        __tag133.release();
        return false;
    }

    private boolean _jsp__tag134(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag134 = null ;
        int __result__tag134 = 0 ;

        if (__tag134 == null ){
            __tag134 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag134);
        }
        __tag134.setPageContext(pageContext);
        __tag134.setParent(null);
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.LMPDate.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag134;
        __result__tag134 = __tag134.doStartTag();

        if (__result__tag134!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag134== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag134.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag134);
            return true;
        }
        _activeTag=__tag134.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag134);
        __tag134.release();
        return false;
    }

    private boolean _jsp__tag135(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag135 = null ;
        int __result__tag135 = 0 ;

        if (__tag135 == null ){
            __tag135 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag135);
        }
        __tag135.setPageContext(pageContext);
        __tag135.setParent(null);
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.LMPDate.label", java.lang.String .class,"key"));
        __tag135.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag135;
        __result__tag135 = __tag135.doStartTag();

        if (__result__tag135!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag135== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag135.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag135);
            return true;
        }
        _activeTag=__tag135.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag135);
        __tag135.release();
        return false;
    }

    private boolean _jsp__tag136(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag136 = null ;
        int __result__tag136 = 0 ;

        if (__tag136 == null ){
            __tag136 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag136);
        }
        __tag136.setPageContext(pageContext);
        __tag136.setParent(null);
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.POA.label", java.lang.String .class,"key"));
        __tag136.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag136;
        __result__tag136 = __tag136.doStartTag();

        if (__result__tag136!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag136== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag136.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag136);
            return true;
        }
        _activeTag=__tag136.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag136);
        __tag136.release();
        return false;
    }

    private boolean _jsp__tag137(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag137 = null ;
        int __result__tag137 = 0 ;

        if (__tag137 == null ){
            __tag137 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag137);
        }
        __tag137.setPageContext(pageContext);
        __tag137.setParent(null);
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag137;
        __result__tag137 = __tag137.doStartTag();

        if (__result__tag137!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag137== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag137.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag137);
            return true;
        }
        _activeTag=__tag137.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag137);
        __tag137.release();
        return false;
    }

    private boolean _jsp__tag138(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag138 = null ;
        int __result__tag138 = 0 ;

        if (__tag138 == null ){
            __tag138 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag138);
        }
        __tag138.setPageContext(pageContext);
        __tag138.setParent(null);
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag138.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag138;
        __result__tag138 = __tag138.doStartTag();

        if (__result__tag138!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag138== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag138.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag138);
            return true;
        }
        _activeTag=__tag138.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag138);
        __tag138.release();
        return false;
    }

    private boolean _jsp__tag139(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag139 = null ;
        int __result__tag139 = 0 ;

        if (__tag139 == null ){
            __tag139 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag139);
        }
        __tag139.setPageContext(pageContext);
        __tag139.setParent(null);
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EDD.label", java.lang.String .class,"key"));
        __tag139.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag139;
        __result__tag139 = __tag139.doStartTag();

        if (__result__tag139!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag139== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag139.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag139);
            return true;
        }
        _activeTag=__tag139.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag139);
        __tag139.release();
        return false;
    }

    private boolean _jsp__tag140(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag140 = null ;
        int __result__tag140 = 0 ;

        if (__tag140 == null ){
            __tag140 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag140);
        }
        __tag140.setPageContext(pageContext);
        __tag140.setParent(null);
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag140;
        __result__tag140 = __tag140.doStartTag();

        if (__result__tag140!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag140== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag140.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag140);
            return true;
        }
        _activeTag=__tag140.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag140);
        __tag140.release();
        return false;
    }

    private boolean _jsp__tag141(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag141 = null ;
        int __result__tag141 = 0 ;

        if (__tag141 == null ){
            __tag141 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag141);
        }
        __tag141.setPageContext(pageContext);
        __tag141.setParent(null);
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
        __tag141.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag141;
        __result__tag141 = __tag141.doStartTag();

        if (__result__tag141!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag141== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag141.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag141);
            return true;
        }
        _activeTag=__tag141.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag141);
        __tag141.release();
        return false;
    }

    private boolean _jsp__tag142(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag142 = null ;
        int __result__tag142 = 0 ;

        if (__tag142 == null ){
            __tag142 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag142);
        }
        __tag142.setPageContext(pageContext);
        __tag142.setParent(null);
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
        __tag142.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag142;
        __result__tag142 = __tag142.doStartTag();

        if (__result__tag142!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag142== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag142.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag142);
            return true;
        }
        _activeTag=__tag142.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag142);
        __tag142.release();
        return false;
    }

    private boolean _jsp__tag143(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag143 = null ;
        int __result__tag143 = 0 ;

        if (__tag143 == null ){
            __tag143 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag143);
        }
        __tag143.setPageContext(pageContext);
        __tag143.setParent(null);
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag143;
        __result__tag143 = __tag143.doStartTag();

        if (__result__tag143!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag143== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag143.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag143);
            return true;
        }
        _activeTag=__tag143.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag143);
        __tag143.release();
        return false;
    }

    private boolean _jsp__tag144(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag144 = null ;
        int __result__tag144 = 0 ;

        if (__tag144 == null ){
            __tag144 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag144);
        }
        __tag144.setPageContext(pageContext);
        __tag144.setParent(null);
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalNotes.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag144;
        __result__tag144 = __tag144.doStartTag();

        if (__result__tag144!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag144== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag144.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag144);
            return true;
        }
        _activeTag=__tag144.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag144);
        __tag144.release();
        return false;
    }

    private boolean _jsp__tag145(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag145 = null ;
        int __result__tag145 = 0 ;

        if (__tag145 == null ){
            __tag145 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag145);
        }
        __tag145.setPageContext(pageContext);
        __tag145.setParent(null);
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag145;
        __result__tag145 = __tag145.doStartTag();

        if (__result__tag145!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag145== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag145.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag145);
            return true;
        }
        _activeTag=__tag145.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag145);
        __tag145.release();
        return false;
    }

    private boolean _jsp__tag146(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag146 = null ;
        int __result__tag146 = 0 ;

        if (__tag146 == null ){
            __tag146 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag146);
        }
        __tag146.setPageContext(pageContext);
        __tag146.setParent(null);
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalNotes.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag146;
        __result__tag146 = __tag146.doStartTag();

        if (__result__tag146!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag146== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag146.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag146);
            return true;
        }
        _activeTag=__tag146.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag146);
        __tag146.release();
        return false;
    }

    private boolean _jsp__tag147(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag147 = null ;
        int __result__tag147 = 0 ;

        if (__tag147 == null ){
            __tag147 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag147);
        }
        __tag147.setPageContext(pageContext);
        __tag147.setParent(null);
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag147;
        __result__tag147 = __tag147.doStartTag();

        if (__result__tag147!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag147== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag147.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag147);
            return true;
        }
        _activeTag=__tag147.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag147);
        __tag147.release();
        return false;
    }

    private boolean _jsp__tag148(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag148 = null ;
        int __result__tag148 = 0 ;

        if (__tag148 == null ){
            __tag148 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag148);
        }
        __tag148.setPageContext(pageContext);
        __tag148.setParent(null);
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag148;
        __result__tag148 = __tag148.doStartTag();

        if (__result__tag148!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag148== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag148.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag148);
            return true;
        }
        _activeTag=__tag148.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag148);
        __tag148.release();
        return false;
    }

    private boolean _jsp__tag149(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag149 = null ;
        int __result__tag149 = 0 ;

        if (__tag149 == null ){
            __tag149 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag149);
        }
        __tag149.setPageContext(pageContext);
        __tag149.setParent(null);
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegisterPatientReferral.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag149;
        __result__tag149 = __tag149.doStartTag();

        if (__result__tag149!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag149== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag149.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag149);
            return true;
        }
        _activeTag=__tag149.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag149);
        __tag149.release();
        return false;
    }
}
