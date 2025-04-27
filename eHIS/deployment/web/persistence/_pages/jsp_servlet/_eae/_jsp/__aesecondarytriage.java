package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.lang.Math.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import com.ehis.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aesecondarytriage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AESecondaryTriage.jsp", 1742461433846L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="   \n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  <script language=\'javascript\' src=\'../../eAE/js/AESecondaryTriage.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n <script language=\'javascript\' src=\'../../eAE/js/AEPractitionerComponent.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!--This line added for this CRF  AAKH-CRF-0010 [IN038535] -->\n <script> \n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\nfunction agecheck(obj,ca_install,patage,max,min,sex)\n{\t\n\tif(ca_install==\"Y\")\n\t{\n\t\tif(obj.name==\"circumference\")\n\t\t{\n\t\t\tif((trimCheck(min) <= patage) && sex ==\"F\")\n\t\t\t{\n\t\t\t}else\n\t\t\t{\n\t\t\t   AEScrollIntoView();\n\t\t\t}\n\t\t}else{\n\t\tif(patage <= max)\n\t\t{\n\t\t}else if((trimCheck(min) <= patage) && sex ==\"F\")\n\t\t{\n\t\t}else\n\t\t{\n\t\t\tAEScrollIntoView();\n\t\t}\n\t  }\n\t}\n}\n\n/*\n  function tab_click(objName)\n\t{\n\t\n\t\t   if(objName==\"Triage_tab\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'tab1\').scrollIntoView();\n\t\t\t}\n\t\t\tif(objName==\"assess_tab\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'tabCA\').scrollIntoView();\n\t\t\t\tshowCAChart();\n\t\t\t}\n\t}\n\n\tfunction tab_click1(id) \n\t\t{\n\t\t\tselectTab(id);\n\t\t\ttab_click(id);\n\t\t}\n\n\t\tfunction tab_click2(id,idval){\n\t\t\n\t\t\t\tselectTab(idval);\n\t\t\t\ttab_click22(idval);\n\t\t} \n\n\t\tfunction tab_click22(Object)\n\t\t{\n\t\t\t\t\t\n\t\t\tif(Object==\'patCond_tab\')\n\t\t\t{\n\t\t\t\t document.getElementById(\'tab1\').scrollIntoView();\n\t\t\t}\n\t\t\tif(Object==\'others_tab\')\n\t\t\t{\n\t\t\t\t   document.getElementById(\'sub2\').scrollIntoView();\n\t\t\t}\n\t\t}\n\n*/\n\t\t\t\tfunction expandCollapse(calledFrom) {\t\n\t\t\t\t\t/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start*/\n\t\t\t\t\tvar five_level_triage_appl_yn\t= \"N\";\n\t\t\t\t\tvar function_id\t= document.forms[0].function_id.value;\n\t\t\t\t\tvar modify_flag\t= document.forms[0].modify_flag.value;\n\t\t\t\t\tif(document.getElementById(\"five_level_triage_appl_yn\")!=null){\n\t\t\t\t\t\tfive_level_triage_appl_yn\t= document.getElementById(\"five_level_triage_appl_yn\").value; \n\t\t\t\t\t}\n\t\t\t\t\tif(modify_flag!=\'Y\'){\n\t\t\t\t\t\tparent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = false;\n\t\t\t\t\t}\n\t\t\t\t\t/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End*/\n\n\t\t\t\t\tif(calledFrom == \'Triage_Details_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'Triage_Details\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'Assessment\').style.display = \'none\';\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'Others\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'Assessment_tab\') {\n\t\t\t\t\t\tif(modify_flag!=\'Y\' && five_level_triage_appl_yn==\'Y\')\n\t\t\t\t\t\t\tparent.TriageButtonsFrame.document.SecondaryTriageButtonsForm.Record.disabled = true;\n\t\t\t\t\t\t////Commented by Dharma against HSA-SCF-0273 [IN:056357] on Aug 5th 2015 Start\n\t\t\t\t\t\t/*document.getElementById(\"Triage_Details\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Assessment\").style.display = \'inline\';\t\t\t\t\t\n\t\t\t\t\t    document.getElementById(\"Others\").style.display = \'none\';*/\n\t\t\t\t\t\t////Commented by Dharma against HSA-SCF-0273 [IN:056357]  on Aug 5th 2015 End\n\n\t\t\t\t\t    /*Below Condition For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start*/ \n\n\t\t\t\t\t    /*Modified By Dharma against AAKH-SCF-0247 [IN:058739] on Dec 28th 2015 Start*/\n\n\t\t\t\t\t\t/*if(five_level_triage_appl_yn!=\"Y\" || function_id==\'query\')\n\t\t\t\t\t   \t\tshowCAChart();*/\n\t\t\t\t\t\tif(five_level_triage_appl_yn!=\"Y\" || function_id==\'query\'){\n\t\t\t\t\t   \t\tshowCAChart();\t\t\t\t\t  \n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tdocument.getElementById(\'Triage_Details\').style.display = \'none\';\n\t\t\t\t\t\t\tdocument.getElementById(\'Assessment\').style.display = \'inline\';\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'Others\').style.display = \'none\';\n\t\t\t\t\t\t}\n\t\t\t\t\t    /*Modified By Dharma against AAKH-SCF-0247 [IN:058739] on Dec 28th 201 End*/ \n\t\t\t\t\t} else if(calledFrom == \'Condition_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'Triage_Details\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'Assessment\').style.display = \'none\';\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'Others\').style.display = \'none\';\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'others_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'Triage_Details\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'Assessment\').style.display = \'none\';\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'Others\').style.display = \'inline\';\t\t\t\t\t\t\n\t\t\t\t\t} \n\t\t\t\t\t/*Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start*/\n\t\t\t\t\telse if(calledFrom == \'allergy_dtls\'){\n\t\t\t\t\t\trecAllergyDet();\n\n\t\t\t\t\t\tdocument.getElementById(\'Triage_Details\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'Assessment\').style.display = \'none\';\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'Others\').style.display = \'none\';\t\n\t\t\t\t\t}/*End*/\n\t\t\t\t}\n\t\n\t</Script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n <body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'clearBed();enableMandatory();\'>\n\t\n \n <form name=\'AESecondaryTriage_form\' id=\'AESecondaryTriage_form\' action=\'../../servlet/eAE.AESecondaryTriageServlet\' method=\'post\' target=\'messageFrame\' >\n<input type=\'hidden\' name=\'diabled_pract\' id=\'diabled_pract\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'> <!--Added CRF AAKH-CRF-0010 [IN038535] -->\n ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t \t\n\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t \n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<!-- Added by krishna Pranay ML-MMOH-CRF-1759.1 -->\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<!-- Added by krishna Pranay ML-MMOH-CRF-1759.1 -->\n\t\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<div id=\'Triage_Details\'>\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Triage Details\">\n\t\t\t\t<a  class=\"tabClicked\" id=\'Triage_Details_tab\' >\n\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Triage_Details_tab\")\' id=\"Triage_tabspan\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<li class=\"tablistitem\" title=\"Assessment\">\n\t\t\t\t<a class=\"tabA\" id=\'Assessment_tab\' >\n\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"Assessment_tab\")\' id=\"assess_tabspan\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\t\t</ul>\n    </td></tr>\n    </table>\n\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n      <tr><td class=\'white\'>\n\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t<li class=\"tablistitem\" title=\"Condition / Case\">\n\t\t\t\t\t<a  class=\"tabClicked\" id=\"Condition_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Condition_tab\")\' id=\"patCond_tabspan\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<!--Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<li class=\"tablistitem\" title=\"Allergy Details\">\n\t\t\t\t\t<a  class=\"tabA\" id=\"allergy_dtls\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"allergy_dtls\")\' id=\"allergyDtls_tabspan\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<!--End-->\n\t\t\t\t<li class=\"tablistitem\" title=\"Others\">\n\t\t\t\t\t<a class=\"tabA\" id=\"others_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"others_tab\")\' id=\"others_tabspan\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t</ul>\n       </td></tr>\n</table>\n<!--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td> \n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td class=\'fields\' width=\'34%\' tabindex=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'text\'  id=\'triage_record_date_time1\' name=\'triage_record_date_time1\' id=\'triage_record_date_time1\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" maxLength=\'19\' size=\'16\' tabindex=\'\'onBlur=\'triageRecordDate(this);\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'triage_record_date_time1\', null, \'hh:mm:ss\' );\" style=\'cursor:pointer\'   /> <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" maxLength=\'19\' size=\'16\' tabindex=\'\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<td class=\'fields\' width=\'20%\' tabindex=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t<input type=\"button\" name=\"visit_24hr\" id=\"visit_24hr\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onClick=\"showLastVisitDetails(\'LastVisit24\');\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">\n\t\t\t</td>\n\t\t\t<td class=\'fields\' width=\'21%\' tabindex=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t<input type=\"button\" name=\"PrevEncounter\" id=\"PrevEncounter\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onClick=\"showPrevEncounter();\"  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" >\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<!--End-->\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'15%\' tabindex=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\"button\" name=\"visit_24hr\" id=\"visit_24hr\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">\n\t\t</td>\n\t\t<td class=\'fields\' width=\'15%\' tabindex=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\"button\" name=\"PrevEncounter\" id=\"PrevEncounter\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" >\n\t\t</td>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n<!--End-->\t\n\t\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t<input type=\'hidden\' name=\'secTrgRecDateTimeList\' id=\'secTrgRecDateTimeList\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n      <input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t  <tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t  </tr>\n\n     <tr><input type=\"hidden\" name=\'hddpriority\' id=\'hddpriority\'value=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">\n              <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t    ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t          ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->\n\t\t  <td class=\'fields\' width=\'25%\'>\n\t\t\t<select name=\'Priority_Zone_Type\' id=\'Priority_Zone_Type\' onchange=\'setPriority(this);setTreatment(this);\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">\n\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="----------\n\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t</select>\n\t\t\t</td>\n\t\t  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\n\t     ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="     \n\t          <td class=\'label\'   width=\'25%\' >\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<input type=\"checkbox\" name=\'priorityR\' id=\'priorityR\'   onClick=\'setPriority(this);setTreatment(this);\' ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="> </td>\n\t\t\t  <td class=\'label\'   width=\'25%\' >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="<input type=\"checkbox\" name=\'priorityY\' id=\'priorityY\'    onClick=\'setPriority(this);setTreatment(this);\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="></td> \n\t\t\t  <td class=\'label\'   width=\'25%\' >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="<input type=\"checkbox\" name=\'priorityG\' id=\'priorityG\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" onClick=\'setPriority(this);setTreatment(this);\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="></td>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t  <td class=\'fields\'   width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t  \t\t  <select name=\'prioritynew\' id=\'prioritynew\' id=\'prioritynew\' style=\'\' onchange=\'setPriority(this.value);setTreatment(this);\' ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="> \n\t    \t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="-------\n\t    \t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' style=\'background-color:";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =";\' ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</option>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t  \t  </select>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t  \t  </td>\n\t    ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\t\t  \n\t\t            </tr>  \n\t\t\t\t\t<tr> \n\t\t\t\t\t<td class=\'label\' width=\'25%\' > ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" </td> \n\t\t\t\t\t <td class=\'fields\' width=\'25%\' ><select name=\'priority11\' id=\'priority11\' tabindex=\'65\' ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">\n\t\t\t\t\t <option value=\'\'>--------";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="-------\n                  ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="  \n\t\t\t\t\t</select>\n\t\t  </td>\n\t\t  \n\t\t  \n\t\t  <!-- \tAdded by Ajay Hatwate for ML-MMOH-2069  -->\n\t\t            \n\t\t             ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t             ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t             <td class=\'label\' width=\'25%\' > ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" </td> \n\t\t\t\t\t <td class=\'fields\' width=\'25%\' ><input type=\'number\' id=\'queue_no1\' name=\'queue_no1\' id=\'queue_no1\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'validateQueueNo(this)\' maxLength=\'16\' size=\'16\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' tabindex=\'66\' ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =">\n\t\t             ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" \n\t\t             <img src=\'../../eCommon/images/mandatory.gif\' id=\'queue_no_mand_img\' align=\'center\' style=\'visibility:hidden\' ></img>\n\t\t             ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t             \n\t\t             <input type=button class=button value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' onClick=\"callSecQueueAudit();\">\n\t\t             \n\t\t             ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t             <!-- End of ML-MMOH-CRF-2069 -->\n\t\t  \n\t\t  \n\t\t\t\t\t  </tr> \n\t\t   \n\t\t<tr> \n\t\t\n\t\t\t  <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n\t\t\t   ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" \n\t\t\t   <select name=\'treat_area\' id=\'treat_area\'  ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" onChange=\'clearBed();clearBed1();\'>\n\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="-------</option>\n\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t    </select>\n\t\t\t </td>\n\t\t\t \n\t\t\t\t   <!-- onblur=\"ChangeUpperCase(this);checkForValidBed(this.value);\" -->\n\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'><input type=\'text\' name=\'bed_bay_no\' id=\'bed_bay_no\' size=\'8\' maxlength=\'8\'  readonly onblur=\"ChangeUpperCase(this);\" onKeyPress=\"return(CheckForSpecChars(event))\"  value =\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="><input type=button class=button value=\'?\' name=\'bed_button\' id=\'bed_button\'  onClick=\"callBedAvailChart();\" ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =">\n             </td>\n\t\t  </tr>\n          <tr> \n             <td class=\'label\' >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'><input type=\"checkbox\" name=\'Disaster_YN\' id=\'Disaster_YN\'  onClick=\'setDisaster(this)\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="></td>\n\t\t\t \n\t\t\t ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t   <td class=\'label\' >";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'><input type=\"text\" name=\'Disaster_Reference\' id=\'Disaster_Reference\'  onKeyPress=\"return CheckForSpecChar(event)\"\n\t\t\t  value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" maxLength=\"15\" ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" ></td>\n             <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t  <td class=\'label\' >";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'><input type=\"text\" name=\'Disaster_Reference\' id=\'Disaster_Reference\'   onKeyPress=\"return CheckForSpecChars(event)\"  value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' maxLength=\'15\' ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" ></td>\n\t\t\t <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t \n\t\t  </tr> \n\t\t  <tr>\n\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'><input type=\'text\'  name=\"disaster_area1\" id=\"disaster_area1\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" maxLength=\'10\' onblur=\'if(this.value !=\"\")searchDisasterArea(this,disaster_area1);\'  ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="><input type=\'button\' name=\'disaster\' id=\'disaster\' value=\'?\' class=\'button\'  tabindex=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' onclick=\'searchDisasterArea(this,disaster_area1);\' ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" >\n             </td>\n<!--            Added by Ajay Hatwate ML-MMOH-CRF-2111 -->\n           ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n           <tr>\n             <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t\t\t\t <select name=\'disaster_category\' id=\'disaster_category\' onChange=\"remVal(document.forms[0].disaster_type);setDisasterType(this);\" tabindex=\'63\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =">\n\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="-------</option>\n\t\t\t\t  ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t  </select>\n\t\t\t\t  </td>  \n\t\t\t\t    ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t  <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\'>\n\t\t\t\t <select name=\'disaster_type\' id=\'disaster_type\' tabindex=\'63\' ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="-------</option>\n\t\t\t\t  \n\t\t\t\t  ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t  \n\t\t\t\t  </select>\n\t\t\t\t  </td>\n           </tr>\n        \n<!--            End of ML-MMOH-CRF-2111\t\t -->\n           </tr>\n\t      <tr>\n\t\t\t <input type=\'hidden\' id=\'regndatetime\' name=\"visit_date_time\" id=\"visit_date_time\"  value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t      <td class=\'LABEL\'  width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t\t\t\t <select name=\'ambulatory_status\' id=\'ambulatory_status\' tabindex=\'63\' ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="--------\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n                 </select>\n              </td>\n\t\t\t   <!--Bewlow line added for this CRF AAKH-CRF-0010 [IN038535]-->\n\t\t\t\n\t\t<td class=\'LABEL\' width=\'25%\' style=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t<td class=\'fields\' width=\'25%\' style=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t\t<input type=text  name=practitioner_desc id=practitioner_desc size=30 maxlength=30 value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" onBlur=\"beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);\" ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="><input type=button class=button value=\'?\' name=pract_button id=pract_button   onclick=\"aegetPractitioner(this,practitioner_desc);\" ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="><input type=hidden value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" name=\"attend_pract_id\" id=\"attend_pract_id\"><input type=hidden value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" name=\"prev_pract_id\" id=\"prev_pract_id\"></td>\n\t\t   <!--End AAKH-CRF-0010 [IN038535]-->\n             ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n              <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\n  \t\t      <td  class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t\t\t\t <select name=\'ambulatory_status\' id=\'ambulatory_status\' tabindex=\'63\' >\n\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="-------\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n                 </select>\n              </td>\n\t\t\t  ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n              </td>\t\t  \n\t\t\t \n\t\t\t <!--Bewlow line added for this CRF AAKH-CRF-0010 [IN038535]-->\n\t\t\t \n\t\t\t\n\t\t<td class=\'LABEL\' width=\'25%\' style=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t\t<input type=text  name=practitioner_desc size=30 maxlength=30 value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="><input type=button class=button value=\'?\' name=pract_button   onclick=\"aegetPractitioner(this,practitioner_desc);\" ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" name=\"prev_pract_id\" id=\"prev_pract_id\"></td>\n\t\t   <!--End AAKH-CRF-0010 [IN038535]-->\n          </tr>\n\t\t  \n\t\t   <!--Below line added for this CRF ML-MMOH-CRF-0654-->\n\t\t   \n\t\t  ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\t\t   \n\t\t   <tr>\n\t\t    <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\t\t\t<td class=\'fields\'  colspan=\'3\'>\n\t\t\t\t   <select name=\'transport_mode\' id=\'transport_mode\' onChange=\"remVal(document.forms[0].mode_of_arrival);setTransMode(this);\" >\n\t\t\t\t    \t<option value=\'\'>----------";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="----------\n                ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t   </select>\n                   <select name=\'mode_of_arrival\' id=\'mode_of_arrival\' >\n\t\t\t\t\t\t <option value=\'\'>----------";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="----------\n\t\t\t\t   </select>\n\t\t    </td> \n\t\t    </td> \n          </tr>\t\n          <tr>\n            <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n\t\t\t<td class=\'fields\'  width=\'25%\'>\n\t\t\t\t <select name=\'accompany_by\' id=\'accompany_by\' ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =">\n\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="---\n\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" \n\t\t\t\t </select>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td> \n          </tr>\t\t  \n\t\t  ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t  <!--End ML-MMOH-CRF-0654-->\n\t\t   \n\t\t  <!-- ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</td>\n\t\t\t<td class=\'fields\'  width=\'25%\'>\n\t\t\t\t <select name=\'accompany_by\' id=\'accompany_by\' >\n\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="  -->\n\t\t  <!--End ML-MMOH-CRF-0654-->\n\t\t  \n\t\t  \n\t\t  <tr> \n\t\t\t  <td class=\'label\'   width=\'25%\'>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</td> \n\t\t\t ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t  <td class=\'fields\' width=\'25%\' \n\t\t\t\t  tabindex=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'><input type=\'text\' name=\'referral_id\' id=\'referral_id\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" maxlength=\'14\' size=\'14\'  onBlur=\'searchPatient(document.forms[0].referral_id);\' ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="><input type=\'button\' class=\'button\' value=\'?\' name=\'ref_id_search\' id=\'ref_id_search\'   onClick=\'getReferralID()\' ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="></td>\n\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t<td  class=\'fields\' width=\'25%\'><input type=\'text\' name=\'referral_id\' id=\'referral_id\' value=\'\' maxlength=\'14\' size=\'14\'  onBlur=\'\'  align=\'left\' disabled><input type=\'button\' class=\'button\' value=\'?\' name=\'ref_id_search\' id=\'ref_id_search\' onClick=\'getReferralID()\' disabled></td>\n\t\t   ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t     <input type=\'hidden\' name=\'injury_3\' id=\'injury_3\' value=\'\'>\n\n\t\t\t<!--Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650-->\n\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'><input type=\'text\'  name=\"complaint_desc\" id=\"complaint_desc\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" onblur=\'if(this.value !=\"\")searchComplaintType(this,complaint_desc);\' tabindex=\'65\' ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="><input type=\'button\' name=\'Complainttype\' id=\'Complainttype\' value=\'?\' class=\'button\' onclick=\'searchComplaintType(this,complaint_desc);\' ";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 =">\n\t\t\t\t</td>\t\n\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t<td></td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=button name=\'ChiefComplaints\' id=\'ChiefComplaints\' value= \'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'   onClick=\'ChiefComplaints_type()\'  class=\'Button\'  > \n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t </tr>\n\t\t <tr> \n\t\t\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'3\' tabindex=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'><textarea name=\'triage_remarks\' cols=\'50\'   align=\'left\'  onblur=\'makeValidString(this);checkMaxLen(this);\' onkeypress=\'checkMaxLimit(this,250);\' ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</textarea>\n\t\t  </td>\n\t\t  </tr>  \n\n\t\t <tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</td>\n\t\t </tr>\n\t\t <!--Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-0645 Start-->\n\t\t ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t<tr>\n\t\t<td colspan=4>\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'17%\'>\n\t\t\t\t\t<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\'>\n\t\t\t\t\t<input type=\'radio\' name=\'caseDetails\' id=\'caseDetails\' tabindex=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' id=\'trauma\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="></input>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'10%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' id=\'oscc\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="></input>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'10%\'>\n\t\t\t\t\t<span id=\'osccTypeLabel\' style=\"visibility:hidden\">";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="&nbsp;";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="</span>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'16%\'>\n\t\t\t\t\t<select name=\'osccType\' id=\'osccType\' style=\"visibility:hidden\" tabindex=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 =">\n\t\t\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="--------\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\'osccTypeMandImg\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  width=\'17%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\'>\n\t\t\t\t\t<input type=\'radio\' tabindex=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\' name=\"caseDetails\" id=\'medical\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\'> \n\t\t\t\t\t<input type=\'radio\' tabindex=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' name=\"caseDetails\" id=\'surgical\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="></input> \n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  width=\'17%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\' tabindex=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\' >\n\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'OandG\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="></input>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'oscc_yn\' id=\'oscc_yn\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n\t\t\t<input type=\'hidden\' name=\'medical_yn\' id=\'medical_yn\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\t\t\t<input type=\'hidden\' name=\'surgical_yn\' id=\'surgical_yn\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n\t\t ";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t <!--End-->\n\t\t <tr>  \n\t\t\t        <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</td>\n\t\t\t        <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'><input type=\'checkbox\'   name=\"CaseofTrauma\" id=\"CaseofTrauma\" value=\'N\' onClick=\'checktrauma(this);setMechInj1(this);\' ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 =">\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</td>\n                    <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\'><input type=\'checkbox\'  name=\"oscc_yn\" id=\"oscc_yn\"   value=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\' onClick=\'chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();\' ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =" tabindex=\'\' ";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 =">\n\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =" --> </td>\n         </tr>\n\t\t <tr> \n\t\t\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'><input type=\'checkbox\'  name=\"medical_yn\" id=\"medical_yn\" value=\'N\' onClick=\'chkMedicalValue(this);\' ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="></td>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'> <input type=\'checkbox\'  name=\"surgical_yn\" id=\"surgical_yn\"   value=\'N\' onClick=\'chkSurgValue(this);\' ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="> \n\t\t\t\t\t</td>\n\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =">\n\t\t\t\t<input type=\'hidden\' name=\'called_from_ca\' id=\'called_from_ca\' value=";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 =">\n\t\t ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t <tbody id=\'placeOfOccMechInjFieldsDisplay\' style=\"display:none;\">\n\t\t ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t <tr>\n\t\t \t<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->\n\t\t\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t<td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t          <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n  \t\t      <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n\t\t\t  <input type=\'text\'  id=\'accidentdatetime\' name=\'accidentdatetime\'  maxLength=\'16\' size=\'16\' tabindex=\'\'\n\t\t\t  value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\"  onBlur=\'doDate(this);\' ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 =">\n";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\t\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"if (!document.getElementById(\'accidentdatetime\').disabled) {return showCalendar(\'accidentdatetime\', null, \'hh:mm\' )}\"  ";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 =">\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\' id=\'dateOfOccurImg\' style=\"visibility:hidden\" align=\'center\'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n\t\n\t\t\t  \t<!--Added by Ashwini on 19-Jan-2017 for GDOH-CRF-0131-->\n\t\t\t\t<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->\n\t\t\t\t<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->\n\t\t\t\t ";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="/";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="</td>\n\t\t\t  ";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t  <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\n\t\t\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t\t  <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'><input type=\'text\' name=\"place_of_accident\" id=\"place_of_accident\"  maxLength=\'30\' size=\'25\'  tabindex=\'\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\n\t\t\t <td class=\'fields\' width=\'25%\'><select name=\'place_of_accident\' id=\'place_of_accident\' ";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =" >\n\t\t\t   <option value=\'\'>----------";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="----------</option> \n                ";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'placeOfOccurImg\' style=\"visibility:hidden\" align=\'center\'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n\t\t\t\t</td>\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t     </tr>\n\t     <tr>\t\n\t\t           <td class=\'LABEL\' width=\'25%\' >\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="<!--End-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t\t\t\t   </td>\n\t\t\t\t   ";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n  \t\t\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'>\n\t\t\t\t   ";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'2\' tabindex=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t\t\t\t   <select name=\'mechan_injury\' id=\'mechan_injury\' onChange=\'setInjury(this)\' ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="> \n\t\t\t\t    <option value=\'\'>--------";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="  \n                 </select><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand4\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t ";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n\t\t\t\t\t<font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t\t\t ";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n              </td>\n\t\t\t  <!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->\n\t\t\t  ";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\t\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="<!--End-->\n  \t\t      <input type=\'hidden\' name=\'mech_sub_code\' id=\'mech_sub_code\' value=";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 =" >\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'>\n\t\t\t\t<select name=\'injury\' id=\'injury\' tabindex=\'68\' ";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="--------\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand5\' style=\"visibility:hidden\" align=\'center\'></img>\n              </td> \n\t  </tr>\n\t  ";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t  </tbody>\n\t  ";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\n\t  <tr>\t\n\t\t      <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' colspan=\'2\' tabindex=\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\'>\n\t\t\t\t <select name=\'vehicle_invol\' id=\'vehicle_invol\' ";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 =">\n\t\t\t\t  <option value=\'\' >--------";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n                 </select><font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t ";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n              </td>\n\t\t\t  <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\'>\n\t\t\t\t<select name=\'vehicle_invol1\' id=\'vehicle_invol1\' tabindex=\'68\' ";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="-------\n\t\t\t\t";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\n\t\t\t\t</select>\n              </td> \t\t\t   \n\t   </tr>\n\n<!--Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->\n\t<tr>\n\t <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</td>\n\t\t<td class=\'fields\' width=\'25%\' colspan=\'2\' >\n\t\t\t<input type=\'text\' name=\"Vehicle_Reg_No1\" id=\"Vehicle_Reg_No1\"  maxLength=\'15\' size=\'20\' value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" onKeyPress=\"return SpCharChkForMotorVecRegNo(event);\" ";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="> <font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\' name=\"Vehicle_Reg_No2\" id=\"Vehicle_Reg_No2\"  maxLength=\'15\' size=\'20\' value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 =">\n\t\t</td>\n\t</tr>\n\n\t   <tr>\t\n\t\t      <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\'>\n\t\t\t\t <select name=\'protective_device\' id=\'protective_device\' ";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 =">\n\t\t\t\t   <option value=\'\'>---------";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="--------\n\t\t\t   ";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n                 </select>\n               </td>\n\t\t\t   <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\n               </td>\n\t\t\t   <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\'>\n\t\t\t\t   <select name=\'affected_site\' id=\'affected_site\' tabindex=\'\' ";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\n                 </select>\n              </td>\n\t  </tr> \n\t <tr><!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t         ";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\t\t\t  <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="</td>\n\t\t\t ";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\n\t\t    <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\n\t </tr>\n\t <tr>\t ";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="</td>\n\t           ";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n\t\t      <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="</td>\n               ";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\n\t\t\t   <!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t     <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\'><input type=\'checkbox\'  name=\"mlc_case_yn\" id=\"mlc_case_yn\"  onclick=\'chkMlcValue(this)\' ";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="   ";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="></td>\n             ";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\n             <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\"checkbox\" name=\'mlc_death\' id=\'mlc_death\' value=\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\' onclick=\'updateSelf(this)\' ";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 =" ></td></td>\n             ";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\n             <td class=\'LABEL\' width=\'25%\' colspan=\'2\'>&nbsp;</td>\n             ";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\n      </tr> \n\t  <tr>\n\t          <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\'>\n\t\t\t  <input type=\'text\'  name=\'police_rep_no1\' id=\'police_rep_no1\'   maxLength=\'";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 =" onpaste=\"maxLengthPaste(this, \'100\')\" ";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 =" size=\'15\' tabindex=\'\' value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\"  ";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="></td>\n\t\t\t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\'><input type=\'text\' name=\"police_stat_detail\" id=\"police_stat_detail\"  maxLength=\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 =" size=\'25\' tabindex=\'\' value=\'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\'  ";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="></td>\n\t  </tr>\n\t  <!-- Added by Ajay Hatwate for GHL-CRF-0650  -->\n\t  ";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n\t   <tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\"outside_mlc_dtls\" id=\"outside_mlc_dtls\" value=\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\' maxlength=\'100\' onpaste=\"maxLengthPaste(this, \'100\')\" ";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 =" ></td></td>\t\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\'  id=\'dateofmlccapture\' name=\"date_of_mlc_capture\" id=\"date_of_mlc_capture\" onBlur=\"validateMlcCapture(this)\" maxLength=\'19\' size=\'19\' value=\'";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'dateofmlccapture\',\'dd/mm/yyyy\' ,\'hh:mm:ss\',null );\" style=\'cursor:pointer\'></img>\n\t\t\t\t\t</td></td>\t\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<textarea name=\'mlc_remarks\' rows=3 maxlength=12 cols=45 onKeyPress=\"checkMaxLimit(this, 500)\" onpaste=\"maxLengthPaste(this, \'500\')\" ";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="</textarea>\n\t\t\t\t\t</td></td>\t\t\t\t\n\t</tr>\n\t  ";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\n\t  <!-- End of GHL-CRF-0650  -->\n     <tr><td colspan=4 class=label height=5></td></tr>\n  </table>\n</div>\n\t<div id=\'Others\' style = \'display:none\' >\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Triage Details\">\n\t\t\t\t<a  class=\"tabClicked\" id=\'Triage_Details_tab\' >\n\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Triage_Details_tab\")\' id=\"Triage_tabspan\">";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 =" \n\t\t</ul>\n    </td></tr>\n    </table>\n\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n      <tr><td class=\'white\'>\n\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t<li class=\"tablistitem\" title=\"Condition / Case\">\n\t\t\t\t\t<a  class=\"tabA\" id=\"Condition_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"Condition_tab\")\' id=\"patCond_tabspan\">";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="<!--End-->\n\t\t\t\t<li class=\"tablistitem\" title=\"Others\">\n\t\t\t\t\t<a class=\"tabClicked\" id=\"others_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"others_tab\")\' id=\"others_tabspan\">";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\'>\n\t\t\t<input type=\'text\'  id=\'other_triage_record_date_time\' name=\'triage_record_date_time\' id=\'triage_record_date_time\' value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 =">\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'other_triage_record_date_time\', null, \'hh:mm:ss\' );\" style=\'cursor:pointer\'   /> <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\'>\n\t\t\t <input type=\'text\'  id=\'other_triage_record_date_time\' name=\'triage_record_date_time\' id=\'triage_record_date_time\' value=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\" maxLength=\'19\' size=\'16\' tabindex=\'\' ";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'15%\' tabindex=\'";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\n<!--End-->\t\n\n <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' colspan=8 width=\"100%\">\n\t <tr>\n\t\t\t<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->\n\t\t\t";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="<!--End-->\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\n\t </tr>\n\n\t";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t <tr><td colspan=4 class=label height=5></td></tr>\n    <tr >\n\t\t<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->\n\t\t";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\n\t\t\t\t<td class=\'LABEL\'   width=\'25%\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\'>\n\t\t\t\t\t<input type=\"checkbox\" name=\'cbd\' id=\'cbd\' ";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="  disabled>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\'   width=\'25%\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\'> \n\t\t\t\t\t<input type=text  name=\'medication\' id=\'medication\'  onKeyPress=\"return CheckSpecCharOnKeyPress(event)\" onPaste = \"return false;\" value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" size=\"30\" maxlength=\"30\" ";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 =" >\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="<!--End-->\n\t\t\t <td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\'><input type=\"checkbox\" name=\'cap_bloodSugar\' id=\'cap_bloodSugar\'  ";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="  disabled>\n\t\t\t <td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\'> \n\t\t\t  <input type=\"checkbox\" name=\'spo2\' id=\'spo2\'   ";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 =" disabled >\n\t\t\t </td>\n\t\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\n\t</tr>\n\t <tr>\n\t     <td class=\'LABEL\'   width=\'25%\' >\t\t \n\t\t ";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="</td>\n\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\'> \n\t\t <input type=\"checkbox\" name=\'fbc\' id=\'fbc\' onClick=\'chkOrderCat3(this);\' ";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 =" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\">\n\t\t </td>\n\t\t <td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\'> \n\t\t <input type=\"checkbox\" name=\'ecg\' id=\'ecg\' ";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 =" disabled> \n         </td>\n\t </tr>\n\t <tr>\n\t\t<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->\n\t\t";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\n\t\t\t <td class=\'label\' width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\n\t\t\t\t";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\n\t\t\t\t</td>\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\'> \n\t\t\t\t<input type=\"checkbox\" name=\'dressing\' id=\'dressing\'   ";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 =" disabled>\n\t\t\t </td>\n\t\t\t <td class=\'label\' width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n\t\t\t </td>\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\'> \n\t\t\t\t<input type=text  name=\'initial_mgmt_others\' id=\'initial_mgmt_others\'  onKeyPress=\"return CheckSpecCharOnKeyPress(event)\" onPaste = \"return false;\" value=\"";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 =" >\n\t\t\t </td>\n\t\t";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="<!--End-->\n\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\n\t\t\t <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\'> \n\t\t\t  <input type=\"checkbox\" name=\'dressing\' id=\'dressing\'   ";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 =" disabled>\n\t\t\t </td>\n\t\t\t <td class=\'LABEL\' colspan=2>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\n\t </tr>\n    ";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\n\t <tr>\n  \t\t <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="</td>\n         <td class=\'fields\' colspan=\'2\' tabindex=\'";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\'>\n\t\t\t\t <select name=\'immobilization\' id=\'immobilization\' onChange=\'\' ";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 =" >\n\t\t\t\t\t<Option value=\'\'>&nbsp;------";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="-----&nbsp;</Option>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\n                 </select> \n         </td>\n\t\t <td colspan=2 class=\'LABEL\' >&nbsp;</td>  \n\n  </tr>\n <tr><td colspan=4 class=label height=5></td></tr>\n  <tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="</td>\n  </tr>\n <tr><td colspan=4 class=label height=5></td></tr>\n  <tr>\t\t\t\t \n\t\t      <td class=\'LABEL\' >";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\'>\n\t\t\t\t <select name=\'immunization_stat\' id=\'immunization_stat\' onChange=\'\' ";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 =">\n\t\t\t\t\t       <Option value=\'\'>-------";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="-------</Option>\n                           <Option value=\'F\'";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 =" >";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="</option>\n                           <Option value=\'P\'";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="  >";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="</option>\n                           <Option value=\'U\'";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="</option>\n\t\t\t\t </select>\n              </td>\n  \t\t      <td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="</td>\n\t\t      <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\'><input type=\'checkbox\'  name=\"att_given\" id=\"att_given\"   value=\'\' ";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 =" onblur=\"agecheck(this,\'";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\',\'";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\');\">\n\t\t\t  </td>\n\t </tr>\n\t <tr><td colspan=4 class=label height=5></td></tr>\n\t </table>\n\t\t";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\n\n\t\t<table  border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' colspan=12 width=\"100%\">\n\t    <tr>\n\t\t    <td class=\'COLUMNHEADER\' colspan=\'8\' >";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="</td>\n\t   </tr>\n\t <tr><td colspan=4 class=label height=5></td></tr>\n\t   <tr>\t\n         <td class=\'LABEL\'  width=\"25%\" >";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="</td>\n  \t\t <td class=\'fields\'  width=\"25%\" tabindex=\'";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\'><input type=\'checkbox\'  name=\"growth_age\" id=\"growth_age\"  ";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 =" onclick=\'chkhwc(event);\' ";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="></td>\n\t\t <td class=\'LABEL\' width=\"25%\">";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="</td>\n\t\t <td class=\'fields\'  width=\"25%\" tabindex=\'";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\'>\n\t\t <input type=\'checkbox\' align=\'left\' name=\"immun_date\" id=\"immun_date\"    ";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 =" >\n         </td>\n     </tr>\n     <tr>\n \t\t <td class=\'LABEL\' width=\"25%\">";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="</td>\n\t\t <td  class=\'fields\'  width=\"25%\" tabindex=\'";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\'><input type=\'checkbox\'  name=\"menarche\" id=\"menarche\"    onclick=\'checkmenstrual(this);\' ";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="></td>\n\t\t <td class=\'LABEL\' >";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="</td>\n  \t\t <td class=\'fields\' tabindex=\'";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\'><input type=\'text\'  name=\"height\" id=\"height\" ";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 =" id=\'height\'size=\"5\" maxlength=\'6\' value=\"";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\"onKeyPress=\'return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); \'\n\t\t onBlur=\'SPCheckPositiveNumber(this);\'>&nbsp;";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="</td>\n         \n\t   </tr>\n       <tr>\t\n\t\t <td class=\'LABEL\' >";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\'><input type=\'text\'  name=\"weight\" id=\"weight\" size=\"5\" maxlength=\'7\' value=\"";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\" onKeyPress=\'return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))\'\n\t\t onBlur=\'SPCheckPositiveNumber(this);\'";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 =">&nbsp;";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="</td>\n \t\t <td class=\'LABEL\' >";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\'><input type=\'text\'  name=\"circumference\" id=\"circumference\" size=\"5\" maxlength=\'6\'value=\"";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\"onKeyPress=\'return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))\'onBlur=\"SPCheckPositiveNumber(this);if(this.readOnly==false)agecheck(this,\'";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\');\"";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 =">&nbsp;&nbsp;";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="</td>\n\t  </tr> \n\t <tr><td colspan=4 class=label height=5></td></tr>\n </table>\n ";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\n   \n ";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\n\t\t\t\t\n     <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t <tr>\n\t\t    <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="</td>\n\t </tr>\n\t <tr><td colspan=4 class=label height=5></td></tr>\n     <tr>\t\t\n     \n\n\t\t    <td class=\'LABEL\' width=\"25%\" >";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="</td>\n            <td class=\'fields\' width=\'25%\' tabindex=\'";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\'>\n\t         <input type=\'checkbox\'  name=\"pregnant_at_present_yn_val\" id=\"pregnant_at_present_yn_val\" ";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 =" onClick=\'checkPregnant(this);if(this.checked ==false){nmdesig.innerHTML=\"\";nmdesig1.innerHTML=\"\";eddesig.innerHTML=\"\"};if(this.checked ==true  ){calculateEDD(),calculateNoOfDays();}\' ";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="></td>\n\t\t\t ";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\n\t\t\t<td class=\'LABEL\' width=\'25%\' size=\'20\' >";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\'><input type=\"text\" name=\"lmp_date\" id=\"lmp_date\"  id=\"lmpdate\" maxlength=\"10\" size=\"8\"  onblur=\'makeValidString(this);doDate1(this);if(this.value==\"\"){nmdesig.innerHTML=\"\";nmdesig1.innerHTML=\"\";} checkPregnantDate(this);if(pregnant_at_present_yn_val.checked==true)calculateEDD(),calculateNoOfDays();\'  value = \"";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\" ><img src=\'../../eCommon/images/CommonCalendar.gif\' name=\"lmp_calendar\" onClick=\"return showCalendar(\'lmpdate\');\"  style=\'cursor:pointer\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand2\' style=\"visibility:hidden\" align=\'center\'></img></td> \n\n\t\t\t";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\n\n\t\t\t<td class=\'LABEL\' width=\'25%\' size=\'20\' >";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\'><input type=\"text\" name=\"lmp_date\" id=\"lmp_date\" disabled id=\"lmpdate\" maxlength=\"10\" size=\"8\"  onblur=\'makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();\'  value = \"";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\" ><img src=\'../../eCommon/images/CommonCalendar.gif\' name=\"lmp_calendar\" onClick=\"return showCalendar(\'lmpdate\');\" disabled    style=\'cursor:pointer\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand2\' style=\"visibility:hidden\" align=\'center\'></img></td> \n\n\t\t";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\n       </tr>\n\t   \n\n\t   <tr>\t\t\n          \t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\n   \t\t       &nbsp;\n\t\t       <font name=\"weekVal\" id=\'nmdesig\' class=\'label\'></font>&nbsp;";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="&nbsp;\n\t\t       <font id=\'nmdesig1\' class=\'label\'></font>&nbsp;";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="</td>\n\t\t       <td class=\'LABEL\' align=\'left\' >";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\n   \t\t       &nbsp;\n\t\t       <font name=\"eddVal\" id=\'eddesig\' class=\'label\'></font> \n\t\t    </td>\n\t\t\t<td colspan=2 class=\'LABEL\' >&nbsp;</td>  \n\t</tr> \n   \t <tr><td colspan=4 class=label height=5></td></tr>\n </table>\n<script>\n/* code for calculating POA -- Weeks and Days as well as EDD values onload */\n\ncalculateNoOfDays();\ncalculateEDD();\n </script>\n ";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\n\n</div>\n\n\n<!-- New Tab Other Details Added on 04/02/2005  -->\n";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\n <div id=\'Assessment\' style= \'display:none\'>\n\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Triage Details\">\n\t\t\t\t<a class=\"tabA\" id=\'Triage_tab\' >\n\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"Triage_Details_tab\")\' id=\"Triage_tabspan\">";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\"Assessment\">\n\t\t\t\t<a class=\"tabClicked\" id=\"assess_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Assessment_tab\")\' id=\"assess_tabspan\">";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\t\n\t\t</ul>\n\t</td></tr></table>\n\t<!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start -->\n\t";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\n\t\t <table border=\"0\" cellspacing=\'0\' cellpadding=\'3\'  align=\'center\' width=\'100%\'>\n\t\t\t <tr><td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\n\t\t\t\n\t\t\t \t<tr><td   colspan=\'4\' ><a href=\"javascript:FnProceedClicnicalNotes(\'";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\')\">";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="</a></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\n\t\t\t\t<tr><td   colspan=\'4\' ><a href=\"javascript:FnNotApplicable();\">";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="</a></td></tr>\n\t\t\t  ";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\n\t\t\t \t<tr><td   colspan=\'4\' ><a href=\"javascript:FnProceedCARecordChart(\'";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\',\'\',\'";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\')\">CA ";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\n\t\t\t\t<tr><td   colspan=\'4\' ><a href=\"javascript:FnNotApplicable();\">CA ";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\n\t\t\t<tr><td  colspan=\'4\' ><a href=\"javascript:FnProceedRegisterPatientReferral(\'";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\');\">";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="</a></td></tr>\n\t\t </table>\n\t ";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\n\t <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End -->\n</div>\n";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Others\">\n\t\t\t\t\t<a class=\"tabA\" id=\"others_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" onClick=\'javascript:expandCollapse(\"others_tab\")\' id=\"others_tabspan\">";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t</ul>\n       </td></tr>\n</table>\n\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n      <input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="</td>\n\t  </tr>\n     <tr><input type=\"hidden\" name=\'hddpriority\' id=\'hddpriority\'value=";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 =">\n    \t\n          <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="</td>\n\t\t  <!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->\n\t\t  ";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\n\t\t  <td class=\'fields\' width=\'25%\'>\n\t\t\t<select name=\'Priority_Zone_Type\' id=\'Priority_Zone_Type\' onchange=\'setPriority(this);setTreatment(this)\'";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="----------\n\t\t\t\t\t\t \n\t\t";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\n\t  \t \t </select>\n\t  \t  </td>\n\t\t";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\t \n\t";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\t\n\t\t</tr> \n\t\t              <tr>\n\t\t\t\t\t  <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="</td>\n\t\t\t\t\t   <td class=\'fields\' width=\'25%\' ><select name=\'priority11\' id=\'priority11\' ";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="  \n\t\t\t\t\t</select>\n\t\t  </td>\n\t\t\t\t\t  </tr> \n\t\t   \n\t\t<tr> \n\t\t\t  <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\' >\n\t\t\t   ";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 =" onChange=\'clearBed();\'>\n\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\n\t\t\t    </select>\n\t\t\t </td>\n\t\t\t\t   <!-- onblur=\"ChangeUpperCase(this);checkForValidBed(this.value);\" -->\n\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'bed_bay_no\' id=\'bed_bay_no\' size=\'8\' maxlength=\'8\' onblur=\"ChangeUpperCase(this);\" onKeyPress=\"return(CheckForSpecChars(event))\"  value =\'";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\' ><input type=\"checkbox\" name=\'Disaster_YN\' id=\'Disaster_YN\'  onClick=\'setDisaster(this)\'";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\n\t\t\t <td class=\'label\' >";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\'><input type=\"text\" name=\'Disaster_Reference\' id=\'Disaster_Reference\'   onKeyPress=\"return CheckForSpecChars(event)\" \n           value=\'";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\'  ><input type=\'text\'  name=\"disaster_area1\" id=\"disaster_area1\" value=\"";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="><input type=\'button\' name=\'disaster\' id=\'disaster\' value=\'?\' class=\'button\'   onclick=\'searchDisasterArea(this,disaster_area1);\' ";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 =" >\n             </td>\n\t\t      <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\' >\n\t\t\t\t <select name=\'disaster_type\' id=\'disaster_type\' ";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="-------\n\t\t\t";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\n                 </select>\n              </td>\n           </tr>\n\t      <tr>\n\t\t\t <input type=\'hidden\' id=\'regndatetime\' name=\"visit_date_time\" id=\"visit_date_time\"  value=\'";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t\t <select name=\'ambulatory_status\' id=\'ambulatory_status\' ";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="</td>\n  \t\t      <td  class=\'fields\' width=\'25%\' >\n\t\t\t\t <select name=\'ambulatory_status\' id=\'ambulatory_status\' >\n\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\n              </td>\n\t\t\t  <td class=\'LABEL\' width=\'25%\' colspan=\'2\'></td>\n\n          </tr>\t \n\t\t  <!--Below line added for this CRF ML-MMOH-CRF-0654-->\n\t\t   \n\t\t  ";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\n\t\t  <!--End ML-MMOH-CRF-0654-->\n\t\t   \n\t\t <!-- ";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 =" -->\n\t\t  <!--End ML-MMOH-CRF-0654-->\n\t\t  \n\t\t  \n\t\t  \n\t\t  <tr> \n\t\t\t  <td class=\'label\'   width=\'25%\'>";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\n\t\t\t\t  <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'referral_id\' id=\'referral_id\' value=\"";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\' ><input type=\'text\'  name=\"complaint_desc\" id=\"complaint_desc\" value=\"";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\" onblur=\'if(this.value !=\"\")searchComplaintType(this,complaint_desc);\' ";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 =">\n\t\t\t  </td>\t\n\t\t\t";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\n\t\t </tr> \n\t\t <tr> \n\t\t\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'3\' ><textarea name=\'triage_remarks\' cols=\'50\'   align=\'left\'  onblur=\'makeValidString(this);checkMaxLen(this);\' onkeypress=\'checkMaxLimit(this,250);\' ";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="</td>\n\t\t </tr>\n\t <!--Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-0645 Start-->\n\t ";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="></input>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t</tr>\n\t\t<input type=\'hidden\' name=\'oscc_yn\' id=\'oscc_yn\' value=\'";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\'>\n\t\t<input type=\'hidden\' name=\'medical_yn\' id=\'medical_yn\' value=\'";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\'>\n\t\t<input type=\'hidden\' name=\'surgical_yn\' id=\'surgical_yn\' value=\'";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\'>\n\t ";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\n\t <!--End-->\n\t\t <tr>  \n\t\t\t        <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="</td>\n\t\t\t        <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'   name=\"CaseofTrauma\" id=\"CaseofTrauma\"  onClick=\'checktrauma(this);setMechInj1(this);\' ";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="</td>\n                    <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"oscc_yn\" id=\"oscc_yn\"   value=\'";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"medical_yn\" id=\"medical_yn\"  onClick=\'chkMedicalValue(this);\' ";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' > <input type=\'checkbox\'  name=\"surgical_yn\" id=\"surgical_yn\"   value=\'\' onClick=\'chkSurgValue(this);\' ";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 =">\n\t\t\t\t<!-- Added by Ajay Hatwate for ML-MMOH-CRf-1653 -->\n\n\t\t";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\n\t\t <tr>\t\n\t      <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="</td>\n\t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t <select name=\'case_type\' id=\'case_type\' ";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 =">\n\t\t\t <option value=\'\'>--------";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="--------\n\t\t\t  ";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\n\t\t\t </select>\n\t\t\t ";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t ";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\n\t\t\t </td>\n\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\n\t\t\t<!-- End of ML-MMOH-CRF-1653 -->\n\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t <tr>\n\t\t ";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\n\t\t <!-- if else added by mujafar for ML-MMOH-CRF-0647 -->\n\t\t\t";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\n\t\t\t\n\t\t\t  \n  \t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t  <input type=\'text\'  id=\'accidentdatetime\' name=\'date_time_accident\' id=\'date_time_accident\'   maxLength=\'16\' size=\'16\' \n\t\t\t  value=\"";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'accidentdatetime\', null, \'hh:mm\' );\" style=\'cursor:pointer\' ";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 =" ></img><img src=\'../../eCommon/images/mandatory.gif\' id=\'dateOfOccurImg\' style=\"visibility:hidden\" align=\'center\'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\n\t\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"if (!document.getElementById(\'accidentdatetime\').disabled) {return showCalendar(\'accidentdatetime\', null, \'hh:mm\' )}\"  ";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 =">\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\' id=\'dateOfOccurImg\' style=\"visibility:hidden\" align=\'center\'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n\n\t\t\t<!--Added by Ashwini on 19-Jan-2017 for GDOH-CRF-0131-->\n\t\t\t<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->\n\t\t\t<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->\n\t\t\t  ";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\n\t\t\t  <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\"place_of_accident\" id=\"place_of_accident\"  maxLength=\'30\' size=\'25\'   value=\"";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 =" \n\t\t\t <td class=\'fields\' width=\'25%\'><select name=\'place_of_accident\' id=\'place_of_accident\' ";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'placeOfOccurImg\' style=\"visibility:hidden\" align=\'center\'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n\t\t\t\t</td>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\n\t\t\t\t   </td>\n\t\t\t\t<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\n  \t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="<!--End-->\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' colspan=\'2\' >\t\n\t\t\t\t";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n\t\t\t\t <font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 =" >\n\t\t\t <td class=\'fields\' width=\'25%\' >\n\t\t\t\t<select name=\'injury\' id=\'injury\'  ";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' colspan=\'2\' >\n\t\t\t\t <select name=\'vehicle_invol\' id=\'vehicle_invol\' ";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\n                 </select><font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\n              </td>\n\t\t\t  <td class=\'fields\' width=\'25%\' >\n\t\t\t\t<select name=\'vehicle_invol1\' id=\'vehicle_invol1\' ";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\n\t\t\t\t</select>\n              </td> \t\t\t   \n\t   </tr>\n\n\t <!--Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->\n\t <tr>\n\t <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="</td>\n\t\t<td class=\'fields\' width=\'25%\' colspan=\'2\'>\n\t\t\t<input type=\'text\' name=\"Vehicle_Reg_No1\" id=\"Vehicle_Reg_No1\"  maxLength=\'15\' size=\'20\' value=\"";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="><font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t\t <select name=\'protective_device\' id=\'protective_device\' ";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\n               </td>\n\t\t\t   <td class=\'fields\' width=\'25%\' >\n\t\t\t\t   <select name=\'affected_site\' id=\'affected_site\' ";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\n                 </select>\n              </td>\n\t  </tr> \n\t <tr><!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t          ";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\n\t\t\t    <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\n\t\t\t  <!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t </tr>\n\t <tr>\t<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t            ";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\n\t\t\t  <!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t     <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"mlc_case_yn\" id=\"mlc_case_yn\"  onclick=\'chkMlcValue(this)\' ";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="  ";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="></td>\n               ";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\' onclick=\'updateSelf(this);\' ";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="></td></td>\n             ";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t  <input type=\'text\'  name=\'police_rep_no1\' id=\'police_rep_no1\'  maxLength=\'";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 =" size=\'15\' value=\"";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\"police_stat_detail\" id=\"police_stat_detail\"  maxLength=\'";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 =" size=\'25\'  value=\'";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\"outside_mlc_dtls\" id=\"outside_mlc_dtls\" maxlength=\'100\' value=\'";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\' onpaste=\"maxLengthPaste(this, \'100\')\" ";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 =" disabled></td></td>\t\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="> ";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 =" </textarea>\n\t\t\t\t\t</td></td>\t\t\t\t\n\t</tr>\n\t  ";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="\n\t  <!-- End of GHL-CRF-0650  -->\n     <tr><td colspan=4 class=label height=5></td></tr>\n  </table>\n</div> \n\t</div>\n\t<div id=\'Others\' style = \'display:none\' >\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Triage Details\">\n\t\t\t\t<a  class=\"tabClicked\" id=\'Triage_Details_tab\' >\n\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"Triage_Details_tab\")\' id=\"Triage_tabspan\">";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Others\">\n\t\t\t\t\t<a class=\"tabClicked\" id=\"others_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" onClick=\'javascript:expandCollapse(\"others_tab\")\' id=\"others_tabspan\">";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t</ul>\n       </td></tr>\n</table>\n\n <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' colspan=8 width=\"100%\">\n\t <tr>\n\t\t    <!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->\n\t\t\t";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\'> \n\t\t\t\t\t<input type=text  name=\'medication\' id=\'medication\'  onKeyPress=\"return CheckForSpecChar(event)\" onPaste = \"return false;\" value=\"";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\" size=\"30\" maxlength=\"30\" disabled>\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\' ><input type=\"checkbox\" name=\'cap_bloodSugar\' id=\'cap_bloodSugar\'  ";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="</td>\n\t\t\t <td class=\'fields\' width=\'25%\' > \n\t\t\t  <input type=\"checkbox\" name=\'spo2\' id=\'spo2\'   ";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="</td>\n\t\t <td class=\'fields\' width=\'25%\' > \n\t\t <input type=\"checkbox\" name=\'fbc\' id=\'fbc\' onClick=\'chkOrderCat3(this);\' ";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="  value=\"";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\" >\n\t\t </td>\n\t\t <td class=\'LABEL\'   width=\'25%\' >";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="</td>\n\t\t <td class=\'fields\' width=\'25%\' > \n\t\t <input type=\"checkbox\" name=\'ecg\' id=\'ecg\' ";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="\'> \n\t\t\t\t<input type=text  name=\'initial_mgmt_others\' id=\'initial_mgmt_others\'  onKeyPress=\"return CheckForSpecChar(event)\" onPaste = \"return false;\" value=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\" size=\"30\" maxlength=\"30\" disabled>\n\t\t\t </td>\n\t\t";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\n\t\t\t <td class=\'fields\' width=\'25%\' > \n\t\t\t  <input type=\"checkbox\" name=\'dressing\' id=\'dressing\'   ";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="</td>\n         <td class=\'fields\' colspan=\'2\' >\n\t\t\t\t <select name=\'immobilization\' id=\'immobilization\' onChange=\'\' ";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t\t <select name=\'immunization_stat\' id=\'immunization_stat\' onChange=\'\' ";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="</td>\n\t\t      <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"att_given\" id=\"att_given\"   value=\'\' ";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="</td>\n  \t\t <td class=\'fields\'  width=\"25%\" ><input type=\'checkbox\'  name=\"growth_age\" id=\"growth_age\"  ";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="</td>\n\t\t <td class=\'fields\'  width=\"25%\" >\n\t\t <input type=\'checkbox\' align=\'left\' name=\"immun_date\" id=\"immun_date\"    ";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="</td>\n\t\t <td  class=\'fields\'  width=\"25%\" ><input type=\'checkbox\'  name=\"menarche\" id=\"menarche\"    onclick=\'checkmenstrual(this);\' ";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="</td>\n  \t\t <td class=\'fields\' ><input type=\'text\'  name=\"height\" id=\"height\" ";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="</td>\n  \t\t <td class=\'fields\' ><input type=\'text\'  name=\"weight\" id=\"weight\" size=\"5\" maxlength=\'7\' value=\"";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="</td>\n  \t\t <td class=\'fields\' ><input type=\'text\'  name=\"circumference\" id=\"circumference\" size=\"5\" maxlength=\'6\'value=\"";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\n    ";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="</td>\n\t </tr>\n\t <tr><td colspan=\'4\' class=label height=\'5\'></td></tr>\n     <tr>\t\t\t\t \n\t\t    <td class=\'LABEL\' width=\"25%\" >";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="</td>\n            <td class=\'fields\' width=\'25%\' >\n\t         <input type=\'checkbox\'  name=\"pregnant_at_present_yn_val\" id=\"pregnant_at_present_yn_val\" ";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 =" onClick=\'checkmenstrual(this); checkPregnant(this);\' onBlur=\'if(this.checked ==false)AEScrollIntoView(1);\' ";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="></td>\n\t\t\t\n\t\t\t<td class=\'LABEL\' width=\'25%\' size=\'20\' >";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="</td>\n            <td class=\'fields\' width=\'25%\' ><input type=\"text\" name=\"lmp_date\" id=\"lmp_date\" disabled id=\"lmpdate\" maxlength=\"10\" size=\"8\"  onblur=\'makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();\'   value = \"";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\" ><img src=\'../../eCommon/images/CommonCalendar.gif\' name=\"lmp_calendar\" onClick=\"return showCalendar(\'lmpdate\');\" disabled    style=\'cursor:pointer\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand2\' style=\"visibility:hidden\" align=\'center\'></img></td> \n       </tr>\n\t   <tr>\t\t\n          \t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\n   \t\t       &nbsp;\n\t\t       <font name=\"eddVal\" id=\'eddesig\' class=\'label\'></font> \n\t\t    </td>\n\t\t\t<td colspan=2 class=\'LABEL\' >&nbsp;</td>  \n\t</tr> \n   \t <tr><td colspan=4 class=label height=5></td></tr>\n </table>\n<script>\n/* code for calculating POA -- Weeks and Days as well as EDD values onload */\ncalculateNoOfDays();\ncalculateEDD();\n</script>\n";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 =" \n</div>\n";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\t\n\t\t</ul>\n\t</td></tr></table>\n</div>\n";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\'>\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\'>\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\'>\n<input type=\'hidden\' name=\'visit_num\' id=\'visit_num\' value=\'";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\'>\n<input type=\'hidden\' name=\'hdddob\' id=\'hdddob\' value=";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 =">\n<input type=\'hidden\' name=\'bed_no\' id=\'bed_no\' value=\'";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\'>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 =">\n<input type=\'hidden\' name=\'treat_code\' id=\'treat_code\' value=\'";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\'> \n<input type=\'hidden\' name=\'menstrual_status\' id=\'menstrual_status\' value=";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 =">\n<input type=\'hidden\' name=\'pediatric_status\' id=\'pediatric_status\' value=";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 =">\n<input type=\'hidden\' name=\"mech_injr_subcat_code\" id=\"mech_injr_subcat_code\" value=\"";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 =">\n<input type=\'hidden\' name=\'RepDb\' id=\'RepDb\' value=";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="><!--Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1-->\n\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\'>\n<input type=\'hidden\' name=\'priority_zone\' id=\'priority_zone\' value=";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 =">\n<input type=\'hidden\' name=\'brought_dead\' id=\'brought_dead\' value=";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 =">\n<input type=\'hidden\' name=\'pat_priority\' id=\'pat_priority\' value=";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 =">\n<input type=\'hidden\' name=\'CaseofTrauma_val\' id=\'CaseofTrauma_val\' value=\'";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\'><!--Modified by Thamizh selvi against ML-MMOH-CRF-0645-->\n<input type=\'hidden\' name=\'disaster_area\' id=\'disaster_area\' value=\'";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="\'>\n<input type=\'hidden\' name=\'complaint_code\' id=\'complaint_code\' value=\"";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\">\n<input type=\'hidden\' name=\'rec_date_time\' id=\'rec_date_time\' value=\'";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\'>\n<input type=\'hidden\' name=\'sys_date_time\' id=\'sys_date_time\' value=\'";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\'>\n<!-- <input type=\'hidden\' name=\'sys_date_time1\' id=\'sys_date_time1\' value=\'";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\'> -->\n<input type=\'hidden\' name=\'sys_date_time1\' id=\'sys_date_time1\' value=\'";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\'>\n\n<!--Below line added for this CRF ML-MMOH-CRF-0654-->\n<input type=\'hidden\' name=\'mode_of_arrival_code\' id=\'mode_of_arrival_code\' value=\'";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="\'> \n<!--End this CRF ML-MMOH-CRF-0654-->\n\n<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\'";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\'>\n<input type=\'hidden\' name=\'patient_age\' id=\'patient_age\' value=\'";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\'>\n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="\'>\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 ="\'>\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="\'>\n<input type=\'hidden\' name=\'enable_rights_yn\' id=\'enable_rights_yn\' value=\'";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="\'>\n<input type=\'hidden\' name=\'sel_triage_yn\' id=\'sel_triage_yn\' value=\'";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="\'>\n<input type=\'hidden\' name=\'sel_cons_yn\' id=\'sel_cons_yn\' value=\'";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 ="\'>\n<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code1\' id=\'order_catalog_code1\' value=\'";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code2\' id=\'order_catalog_code2\' value=\'";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code3\' id=\'order_catalog_code3\' value=\'";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code4\' id=\'order_catalog_code4\' value=\'";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code5\' id=\'order_catalog_code5\' value=\'";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 ="\'>\n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'\'>\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 ="\'>\n<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="\'>\n<input type=\'hidden\' name=\'modify_flag\' id=\'modify_flag\' value=\'";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="\'>\n<input type=\'hidden\' name=\'min_age_for_lmp\' id=\'min_age_for_lmp\' value=\'";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );

    private final static java.lang.String  _wl_block634 ="\'>\n<input type=\'hidden\' name=\'year_value\' id=\'year_value\' value=\'";
    private final static byte[]  _wl_block634Bytes = _getBytes( _wl_block634 );

    private final static java.lang.String  _wl_block635 ="\'>\n<input type=\'hidden\' name=\'fbc_yn\' id=\'fbc_yn\' value=\'";
    private final static byte[]  _wl_block635Bytes = _getBytes( _wl_block635 );

    private final static java.lang.String  _wl_block636 ="\'>\n<input type=\'hidden\' name=\'modifyYN\' id=\'modifyYN\' value=\'";
    private final static byte[]  _wl_block636Bytes = _getBytes( _wl_block636 );

    private final static java.lang.String  _wl_block637 ="\'>\n\n<!--Added by Thamizh selvi on 12th Mar 2018 against ML-MMOH-CRF-0645 Start-->\n<input type=\'hidden\' name=\'isCaseDtlsRadioBtnAppl\' id=\'isCaseDtlsRadioBtnAppl\' value=\'";
    private final static byte[]  _wl_block637Bytes = _getBytes( _wl_block637 );

    private final static java.lang.String  _wl_block638 ="\'>\n<input type=\'hidden\' name=\'OandG_yn\' id=\'OandG_yn\' value=\'";
    private final static byte[]  _wl_block638Bytes = _getBytes( _wl_block638 );

    private final static java.lang.String  _wl_block639 ="\'>\n<input type=\'hidden\' name=\'mech_injr_code\' id=\'mech_injr_code\' value=\'";
    private final static byte[]  _wl_block639Bytes = _getBytes( _wl_block639 );

    private final static java.lang.String  _wl_block640 ="\'>\n<!--End-->\n\n<!--Below line added for this CRF AAKH-CRF-0010 [IN038535]-->\n<input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\'";
    private final static byte[]  _wl_block640Bytes = _getBytes( _wl_block640 );

    private final static java.lang.String  _wl_block641 ="\'>\n<input type=\'hidden\' name=\'open_to_all_prac_for_clinic_yn\' id=\'open_to_all_prac_for_clinic_yn\' value=\'";
    private final static byte[]  _wl_block641Bytes = _getBytes( _wl_block641 );

    private final static java.lang.String  _wl_block642 ="\'>\n<input type=\'hidden\' name=\'five_level_triage_appl_yn\' id=\'five_level_triage_appl_yn\' value=\'";
    private final static byte[]  _wl_block642Bytes = _getBytes( _wl_block642 );

    private final static java.lang.String  _wl_block643 ="\'>\n";
    private final static byte[]  _wl_block643Bytes = _getBytes( _wl_block643 );

    private final static java.lang.String  _wl_block644 ="\n\n<input type=\'hidden\' name=\'isMechInjLabelChngAppl\' id=\'isMechInjLabelChngAppl\' value=\"";
    private final static byte[]  _wl_block644Bytes = _getBytes( _wl_block644 );

    private final static java.lang.String  _wl_block645 ="\"><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n\n<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n<input type=\'hidden\' name=\'isReconfirmCOTAppl\' id=\'isReconfirmCOTAppl\' value=\'";
    private final static byte[]  _wl_block645Bytes = _getBytes( _wl_block645 );

    private final static java.lang.String  _wl_block646 ="\'>\n<input type=\'hidden\' name=\'reconf_cot_param\' id=\'reconf_cot_param\' value=\'";
    private final static byte[]  _wl_block646Bytes = _getBytes( _wl_block646 );

    private final static java.lang.String  _wl_block647 ="\'>\n\n<!--Added by k v shanmukh on 6th-Apr-2018 against ML-MMOH-CRF-0656 -->\n<input type=\'hidden\' name=\'isSecTrgBackDateTimeAppl\' id=\'isSecTrgBackDateTimeAppl\' value=\'";
    private final static byte[]  _wl_block647Bytes = _getBytes( _wl_block647 );

    private final static java.lang.String  _wl_block648 ="\'>\n\n<!--Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652-->\n<input type=\'hidden\' name=\'isDiagDtlsSectionAppl\' id=\'isDiagDtlsSectionAppl\' value=\'";
    private final static byte[]  _wl_block648Bytes = _getBytes( _wl_block648 );

    private final static java.lang.String  _wl_block649 ="\'>\n\n<!--end-->\n\n<input type=\'hidden\' name=\'isPriorityZoneAppl\' id=\'isPriorityZoneAppl\' value=\'";
    private final static byte[]  _wl_block649Bytes = _getBytes( _wl_block649 );

    private final static java.lang.String  _wl_block650 ="\'>\t\n<input type=\'hidden\' name=\'isMLCAppl\' id=\'isMLCAppl\' value=\'";
    private final static byte[]  _wl_block650Bytes = _getBytes( _wl_block650 );

    private final static java.lang.String  _wl_block651 ="\'> <!-- Added by Ajay Hatwate for GHL-CRF-0650 -->\n<input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\'";
    private final static byte[]  _wl_block651Bytes = _getBytes( _wl_block651 );

    private final static java.lang.String  _wl_block652 ="\'> <!-- Added by Ajay Hatwate for GHL-CRF-0650 -->\n<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1653 -->\n<input type=\'hidden\' name=\'caseTypeYn\' id=\'caseTypeYn\' value=\'";
    private final static byte[]  _wl_block652Bytes = _getBytes( _wl_block652 );

    private final static java.lang.String  _wl_block653 ="\'> \n<input type=\'hidden\' name=\'caseTypeMandYn\' id=\'caseTypeMandYn\' value=\'";
    private final static byte[]  _wl_block653Bytes = _getBytes( _wl_block653 );

    private final static java.lang.String  _wl_block654 ="\'>\n<!-- End of ML-MMOH-CRF-1653 -->\n<!-- Added by Ajay Hatwate for ML-MMOH-CRf-2103 -->\n<input type=\'hidden\' name=\'tick_mlc_if_oscc_checked_yn\' id=\'tick_mlc_if_oscc_checked_yn\' value=\'";
    private final static byte[]  _wl_block654Bytes = _getBytes( _wl_block654 );

    private final static java.lang.String  _wl_block655 ="\'>\n<!-- End of ML-MMOH-CRf-2103 -->\n\n<!-- Added by Ajay Hatwate for ML-MMOH-CRF-2069 -->\n<input type=\'hidden\' name=\'isSecondaryTriageQueueNum\' id=\'isSecondaryTriageQueueNum\' value=\'";
    private final static byte[]  _wl_block655Bytes = _getBytes( _wl_block655 );

    private final static java.lang.String  _wl_block656 ="\' >\n <input type=\'hidden\' name=\'queue_appl_priority_zone\' id=\'queue_appl_priority_zone\' value=\'";
    private final static byte[]  _wl_block656Bytes = _getBytes( _wl_block656 );

    private final static java.lang.String  _wl_block657 ="\' >\n <input type=\'hidden\' name=\'queue_num_mandatory\' id=\'queue_num_mandatory\' value=\'";
    private final static byte[]  _wl_block657Bytes = _getBytes( _wl_block657 );

    private final static java.lang.String  _wl_block658 ="\' >\n <input type=\'hidden\' name=\'queue_secondary_triage\' id=\'queue_secondary_triage\' value=\'";
    private final static byte[]  _wl_block658Bytes = _getBytes( _wl_block658 );

    private final static java.lang.String  _wl_block659 ="\' >\n <input type=\'hidden\' name=\'queue_max_num_allowed\' id=\'queue_max_num_allowed\' value=\'";
    private final static byte[]  _wl_block659Bytes = _getBytes( _wl_block659 );

    private final static java.lang.String  _wl_block660 ="\' >\n <input type=\'hidden\' name=\'queue_no\' id=\'queue_no\' value=\'";
    private final static byte[]  _wl_block660Bytes = _getBytes( _wl_block660 );

    private final static java.lang.String  _wl_block661 ="\' >\n  <input type=\'hidden\' name=\'latestMensDtlStatus\' id=\'latestMensDtlStatus\' value=\'";
    private final static byte[]  _wl_block661Bytes = _getBytes( _wl_block661 );

    private final static java.lang.String  _wl_block662 ="\' ><!-- added by krishna Pranay ML-MMOH-CRF-1759.1 -->\n <input type=\'hidden\' name=\'invokeMenstrualHistYN\' id=\'invokeMenstrualHistYN\' value=\'";
    private final static byte[]  _wl_block662Bytes = _getBytes( _wl_block662 );

    private final static java.lang.String  _wl_block663 ="\' ><!-- added by krishna Pranay ML-MMOH-CRF-1759.1 -->\n <input type=\'hidden\' name=\'rec_view_lmp_details_label\' id=\'rec_view_lmp_details_label\' value=\'";
    private final static byte[]  _wl_block663Bytes = _getBytes( _wl_block663 );

    private final static java.lang.String  _wl_block664 ="\' ><!-- added by krishna Pranay ML-MMOH-CRF-1759.1 -->\n<!-- End of ML-MMOH-CRF-2069 -->\n\n\n</form> \n";
    private final static byte[]  _wl_block664Bytes = _getBytes( _wl_block664 );

    private final static java.lang.String  _wl_block665 ="\n<script>\n/* code for populating values onload in treatmentarea and mechanical injury sub category list boxes Added on 02/12/2004*/\nif(document.forms[0])\nsetInjury(document.forms[0].mechan_injury);\n/*Added by Thamizh selvi against ML-MMOH-CRF-0645 Start*/\nif(document.forms[0].isCaseDtlsRadioBtnAppl.value == \"true\"){\n\tif(document.forms[0].CaseofTrauma_val.value != \"Y\" && document.forms[0].oscc_yn.value != \"Y\" && document.forms[0].surgical_yn.value != \"Y\" && document.forms[0].OandG_yn.value != \"Y\"){\n\t\tdocument.forms[0].medical.checked\t= true;\n\t\tdocument.forms[0].medical_yn.value\t= \"Y\";\n\t}\n\tonLoadCaseDtlsChk();\n}/*End*/\n //window.setTimeout(\'setTreatment(document.forms[0].priority_zone)\',200);\n//Below line added for this CRF ML-MMOH-CRF-0654 \nif(\"";
    private final static byte[]  _wl_block665Bytes = _getBytes( _wl_block665 );

    private final static java.lang.String  _wl_block666 ="\"==\"true\"){\nif(document.forms[0])\nsetTimeout(\"setTransMode(document.forms[0].transport_mode)\",50);// setTrans(document.forms[0].transport_mode);\n}\n//En dthis CRF ML-MMOH-CRF-0654 \n</script>\n</body>\n";
    private final static byte[]  _wl_block666Bytes = _getBytes( _wl_block666 );

    private final static java.lang.String  _wl_block667 ="\n\n\n</html>\n\n";
    private final static byte[]  _wl_block667Bytes = _getBytes( _wl_block667 );
 
  public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	

		return single ; 
			
			}	



	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
//To handle HTML Special characters for GHL-CRF-0650 by Ajay Hatwate
	public static String escapeHTML(String s) {
	  StringBuilder procStr = new StringBuilder(Math.max(16, s.length()));
	  for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);
	      if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
	      	procStr.append("&#");
	      	procStr.append((int) c);
	      	procStr.append(';');
	      } else {
	      	procStr.append(c);
	      }
	  }
	  return procStr.toString();
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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con				      = null;  
PreparedStatement pstmt		      = null;
ResultSet rset				      = null;
PreparedStatement pstmt1	      = null;
ResultSet rset1				      = null;
PreparedStatement pstmt_date	  = null;
ResultSet rs_date			      = null;
PreparedStatement pstmtEncounter  = null; 
ResultSet rsetEncounter			  = null;
ResultSet rsetCA		  = null;
PreparedStatement pstmtCA	      = null;
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String locale			= (String)session.getAttribute("LOCALE");

String bed_no = "";
String dis_regn_ref = "";
/** for Other Details Tab Added on 04/02/2005 **/
String ca_install_yn = "";
String ECGProp			="";
String FBCProp		    ="";
String DressProp        ="";
String SpO2Prop 		="";
String capBloodSugProp  ="";
String order_catalog_code1  ="";
String order_catalog_code2  ="";
String order_catalog_code3  ="";
String order_catalog_code4  ="";
String order_catalog_code5  ="";
String order_catalog_code6  ="";
String fbccheck  ="";
String fbccheck_val  ="";
String modifyYN  = "Y";
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
String priority_zone_code	= "";
String priority_zone_desc	= "";
String priority_zone_color	= "";
String priority_zone_order	= "";
String priority_zone_hidden_fileds	= "";
String patient_class		= "";
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
int countECG =0;
int countDerss=0;
int countSpO2=0;
int countCapBlood=0;
String facilityId			= (String)session.getValue("facility_id");
String loginUser			= checkForNull((String)session.getValue("login_user"));
String patient_id			= request.getParameter("patient_id");

String fbc_yn			= request.getParameter("fbc_yn")==null?"N":request.getParameter("fbc_yn"); 

/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
String open_to_all_pract_yn=checkForNull(request.getParameter("open_to_all_pract_yn"));
String open_to_all_prac_for_clinic_yn=checkForNull(request.getParameter("open_to_all_prac_for_clinic_yn"));
//End AAKH-CRF-0010 [IN038535]

	if(fbc_yn.equals("Y")) {
		fbccheck="Checked";
		fbccheck_val="Y";
	} else {
		fbccheck="";
		fbccheck_val="N";
	}
// for Frame reference changes
String called_from_ca = request.getParameter("called_from_ca");
if((called_from_ca==null) || (called_from_ca.equals("null")) || (called_from_ca=="") || (called_from_ca.equals("")))
	called_from_ca= "N";
String query_string = checkForNull(request.getParameter("query_string"));
String params		 = request.getQueryString() ;




StringBuffer sbBuff = null;
sbBuff = new StringBuffer();
String clinic_code			= request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code"); 
String priority			    = checkForNull(request.getParameter("priority_zone"));
String brought_dead			=  checkForNull(request.getParameter("brought_dead"));
String rec_date_time		= checkForNull(request.getParameter("rec_date_time"));
//Below condtion added for this [IN:051341]
if(rec_date_time.equals("null")) rec_date_time="";

String encounter_id			= checkForNull(request.getParameter("encounter_id"));
String sys_date_time        = checkForNull(request.getParameter("sys_date_time"));
String sys_date_time1        = checkForNull(request.getParameter("sys_date_time1"));
String treat_code			= checkForNull(request.getParameter("treatment_area_code"));
String patient_gender       = checkForNull(request.getParameter("patient_gender"));
String practitioner_id      = checkForNull(request.getParameter("practitioner_id"));
String speciality_code      = checkForNull(request.getParameter("speciality_code"));
String modify_flag			= request.getParameter("modify_flag")==null?"N":request.getParameter("modify_flag"); 
String function_id = checkForNull(request.getParameter("function_id"));
String year_value1			= request.getParameter("year_value")==null?"":request.getParameter("year_value"); 
String year_value		="";
String min_age_for_lmp				="";
String heightDesc				= "";
String weightDesc				= "";
String circumDesc				= "";
String sex						= "";
String date_of_birth			= "";
String menstrual_status			= "false";
String pediatric_status			= "false";
String disabled					= "disabled";
String visit_date				= "";
String priorityStatus1			= "";
String priorityStatus2			= "";
String priorityStatus3			= "";
String priority_no				= "4";
String a_status				    = "";
String complaint_code           = "";
String complaint                = "";
String disaster_yn				= "";
String medical_yn               = "";
String surgical_yn				= "";
String checkedSur               = "";
String checkedMed               = "";
String mech_injr_code			= "";
String mech_injr_subcat_code	= "";
String checked1					= "";
String checked2					= "";
String checked3					= "";
String checked4					= "";
String checked5					= "";
String checked6					= "";
String checked7					= "";
String checked8					= "";
String checked9					= "";
String optSelected				= "";
String vehicle_invlovedcode		= "";
String vehicle_invlovedcode1	= "";
//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
String Vehicle_Reg_No1			= "";
String Vehicle_Reg_No2			= "";
String protective_device_code	= "";
String pat_position_code		= "";
String oscc_yn					= "";
String mlc_yn					= "";
//String mlc_case_yn					= "";
String police_rep_no			= "";
String police_station_dtls		= "";
String  immunization_status		= "";
String selected					= "";
String selected1				= "";
String selected2				= "";
String att_given				= "";
String dev_mile_stone			= "";
String imm_date					= "";
String circumference			= "";
String height					= "";
String weight					= "";
String  menarche_yn				= "";
String disaster_town_code		= "";
String lmp_date					= "";
String disPriority				= "";
String disTreatArea				= "";
String pregnant_yn				= "";
String disabled11				= "";
String mech_injury_subcatg_code	= "";
String disable3					= "";
String disabled111				= "";
String disabled12				= "";
String disabled13				= "";
String sqlDate					= "";
String disabled99				= "";
String disabled991				= "";
String disabledPre				= "";
String disMenarche				= "";
String disBed					= "";
String disBed1					= "";
String disDisaster				= "";
String pat_priority             = ""; 
String trauma_yn                = ""; 
String dis_area                 = "";
String dis1						= "";
String dis2						= "";
String dis3					    = "";
String dis5					    = "";
String dis6					    = "";
String dis7					    = "";
String dis8					    = "";
String dis9					    = "";
String dis10					= "";
String dis11				    = "";
String dis12				    = "";
String dis13				    = "";
String dis14				    = "";
String dis15				    = "";
String disHeight				= "";
String disWeight				= "";
String disCir				    = "";
String disImm					= "";
String triage_remarks           = "";
String disMed					= "";
String disSur					= "";
String disOscc					= "";
String disMLC					= "";
String optSelectedTreat			= "";
String immobilization			= "";
String disImmobil				= "";
String disaster_type_code       = "";
String sys_date                 = "";
String priority_code            = "";
String episode_id               = "";
String visit_num                = "";
String pat_dtls_unknown_yn      = "";
String referral_id				= "";
String disRefID                 = "";
//String speciality_code          = "";
String date_time_of_accident    = "";
String place_of_accident        = "";
String disDateAcci				= "";
String disPlaceAcci				= "";
String enable_rights_yn="";
String sel_triage_yn="";
String sel_cons_yn="";

/*--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->*/

String dis_triage_record_date_time="";
String display_triage_record_date_time="";

/*END*/

//Added By Shanmukh for MMS-DM-CRF-0147
String sql2="";
Boolean isPriorityZoneAppl			= false;

/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
String color                  ="";
String  sql                   ="";
String  green                 ="";
String  red                   ="";
String  yellow                ="";


/* CRF  SKR-CRF-0021 [IN028173] end  */


int  patient_age				= 0;
int min_age_pregnancy			= 0;
int nb_mother_min_age           = 0;
int min_age_pregnancy1			= 0;
int max_age_paediatric			= 0;
int	 tindex                     = 0;
 int minageforlmp=0;
 int yearvalue=0;
 int ca_encntr_cnt = 0;

// Tuesday, May 04, 2010 PE_EXE venkat s

String dis_yn="";
String dis_town_code="";
String dis_type_code="";
String dis_complaint_code="";


/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
String prioritynewdisabled		= ""; 
String priority_selected		= "";
String five_level_triage_appl_yn	= "N";
String ca_chart_rec_status			= "";
String clinical_notes_status		= "";
String sys_date_qry					= "";
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/

/*Below line added for this CRF AAKH-CRF-0010 [IN038535] Senthil*/
String leveloftriage_visibility = "visibility:hidden";
String attend_practitioner_id="",attend_practitioner_name="";
String dis16				    = "";

//End AAKH-CRF-0010

//Below line added for this CRF ML-MMOH-CRF-0654
Boolean modeofarrival=false;
String transport_mode_code="",arrival_code="",accompanied_by_code="";
String accompanied_by_dis = "";
//End ML-MMOH-CRF-0654

/*Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-645 Start*/
Boolean isCaseDtlsRadioBtnAppl	= false;
String OandGYn					= "N";
String disOandGYn				= "";
String checkedOandGYn			= "";
/*End*/

Boolean isMechInjLabelChngAppl	= false;//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-649

//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
Boolean isReconfirmCOTAppl = false;
String reconf_cot_param = "";

/*Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start*/
Boolean isChngBtnPositionAppl = false;
int countRecEnc				=  0;
double prev_visit_hrs		= 0d;
String EncounterProp	= "";
String VisitProp		= "";
/*End*/

/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
Boolean isOrderCatalogChngAppl	= false;
String orderCatalogCode6		= "";
String cbdProp					= "";
String initialMgmtLblName		= "";
String dressingLblName			= "";
String medication				= "";
String intialMgmtOthers			= "";
String disIntialMgmtOthers		= "";
String disMedication			= "";
int countCBD					= 0;
/*End*/

/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
String called_from	= checkForNull(request.getParameter("called_from"));
String RepDb		= checkForNull(request.getParameter("RepDb"));
if(called_from.equals("CDR"))
	facilityId	= checkForNull(request.getParameter("facility_id"));
String sqlFinal		= "";
/*End*/

Boolean isMLCAppl = false;//Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023
String mlcQuery = "";
String disMLCDeath ="disabled";
String disOutMLCDet = "disabled";
String disDateOfCapt = "disabled";
String disMLCRemark = "disabled";
String MLC_REMARKS="";
String MLC_NO_OUTSIDE_DTLS="";
String MLC_DEATH_YN ="";
String MLC_CAPTURE_DATE ="";
String pol_rep_no_mx_size = "20";
String pol_stn_det_mx_size = "30";
String visit_date_time = "";
//Added by Ajay Hatwate for ML-MMOH-CRf-1653
String caseTypeYn = "", caseTypeMandYn = "", caseType = "", caseTypeDisable = "";
//Added by Ajay Hawtate for ML-MMOH-CRF-2103
String tickMlcOnOsccChecked = "", disaster_category_yn = "";//Added by Ajay Hatwate for ML-MMOH-CRf-2111
		
// Added by Ajay Hatwate for ML-MMOH-CRF-2069
boolean isSecondaryTriageQueueNum = false;
String queue_secondary_triage = "", queue_appl_priority_zone = "" , queue_num_mandatory = "", queue_max_num_allowed = "", dis_queue_no = "disabled", queue_no = "";


try
 {
        con = ConnectionManager.getConnection(request);	
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
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
		if(isMLCAppl){
			pol_rep_no_mx_size = "100";
			pol_stn_det_mx_size = "100";
		}
		
		//Added by Ajay Hatwate for ML-MMOH-CRF-2069
		isSecondaryTriageQueueNum = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SECONDARY_TRIAGE_QNUM");
		
		
		
		//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		isReconfirmCOTAppl		= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "RECONFIRM_CASE_OF_TRAUMA");
		JSONObject aeParamJson	= new JSONObject();
		aeParamJson				= eAE.AECommonBean.getAEParam(con, facilityId);
		reconf_cot_param		= (String)aeParamJson.get("reconfirm_case_of_trauma");	
		
		String qry=" SELECT a.min_age_for_lmp,a.enable_accs_rights_in_queue,a.min_age_for_preg_dtl, a.FIVE_LEVEL_TRIAGE_APPL_YN,a.max_age_for_paed_dtl,a.ORDER_CATALOG_CODE1,a.ORDER_CATALOG_CODE2,a.order_catalog_code3,a.ORDER_CATALOG_CODE4,a.ORDER_CATALOG_CODE5,a.ORDER_CATALOG_CODE6,calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) YEAR,b.sex,to_char(b.date_of_birth, 'dd/mm/yyyy') date_of_birth, b.pat_dtls_unknown_yn, (select install_yn from sm_module ##REPDB## where module_id='CA' ) ca_install_yn, a.DRESSING_LABEL_CONFIG, a.INITIAL_MGMT_LABEL_CONFIG, a.case_type_yn, a.case_type_mand_yn, a.TICK_MLC_IF_OSCC_IS_TICKED_YN, a.ENABLE_DISASTER_CATEG,a.queue_secondary_triage,a.queue_appl_priority_zone,a.queue_num_mandatory,a.queue_max_num_allowed FROM  mp_patient ##REPDB## b,ae_param ##REPDB## a WHERE  b.patient_id =?  and a.operating_facility_id =? ";//Modified by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		//Modified above query by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		qry = qry.replaceAll("##REPDB##",RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
        pstmt			=	con.prepareStatement(qry);
		pstmt.setString	(	2,	facilityId		);
		pstmt.setString	(	1,	patient_id		);
		rset = pstmt.executeQuery();
		
		if(rset!= null &&  rset.next() )
		{
			min_age_for_lmp=rset.getString("min_age_for_lmp")==null?"":rset.getString("min_age_for_lmp");
			enable_rights_yn		= rset.getString("enable_accs_rights_in_queue")==null?"":rset.getString("enable_accs_rights_in_queue");
			year_value=rset.getString("YEAR")==null?"":rset.getString("YEAR");
			min_age_pregnancy1 = rset.getInt("min_age_for_preg_dtl");
			
			/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
			five_level_triage_appl_yn		= rset.getString("FIVE_LEVEL_TRIAGE_APPL_YN")==null?"N":rset.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
			if(five_level_triage_appl_yn.equals("Y"))leveloftriage_visibility="visibility:visible";
			
			max_age_paediatric = rset.getInt("max_age_for_paed_dtl");
			order_catalog_code1 = checkForNull(rset.getString("ORDER_CATALOG_CODE1"));	
			order_catalog_code2 = checkForNull(rset.getString("ORDER_CATALOG_CODE2"));	
			order_catalog_code3  = checkForNull(rset.getString("order_catalog_code3"));
			order_catalog_code4 = checkForNull(rset.getString("ORDER_CATALOG_CODE4"));	
			order_catalog_code5 = checkForNull(rset.getString("ORDER_CATALOG_CODE5"));	
			order_catalog_code6 = checkForNull(rset.getString("ORDER_CATALOG_CODE6"));	
			patient_age = rset.getInt("YEAR");
			sex	=  rset.getString("sex")==null?"":rset.getString("sex");
			date_of_birth = rset.getString("date_of_birth");
			pat_dtls_unknown_yn = rset.getString("pat_dtls_unknown_yn");			
			ca_install_yn = rset.getString("ca_install_yn");			
			/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
			dressingLblName		= checkForNull(rset.getString("DRESSING_LABEL_CONFIG"));			
			initialMgmtLblName	= checkForNull(rset.getString("INITIAL_MGMT_LABEL_CONFIG"));	
			/*End*/
			caseTypeYn 			= checkForNull(rset.getString("case_type_yn"));
			caseTypeMandYn 			= checkForNull(rset.getString("case_type_mand_yn"));
			tickMlcOnOsccChecked 	= rset.getString("TICK_MLC_IF_OSCC_IS_TICKED_YN")==null?"Y":rset.getString("TICK_MLC_IF_OSCC_IS_TICKED_YN");
			disaster_category_yn = rset.getString("ENABLE_DISASTER_CATEG")==null?"N":rset.getString("ENABLE_DISASTER_CATEG");//Added by Ajay Hatwate for ML-MMOH-CRf-2111
			
			//Added by Ajay Hatwate for ML-MMOH-CRF-2069 on 08/07/2024
			
		  	queue_secondary_triage = rset.getString("queue_secondary_triage")==null?"N":rset.getString("queue_secondary_triage");
			queue_appl_priority_zone = rset.getString("queue_appl_priority_zone")==null?"N":rset.getString("queue_appl_priority_zone");
			queue_num_mandatory = rset.getString("queue_num_mandatory")==null?"N":rset.getString("queue_num_mandatory");
			queue_max_num_allowed = rset.getString("queue_max_num_allowed")==null?"N":rset.getString("queue_max_num_allowed");

			//System.out.println(five_level_triage_appl_yn + " : five_level_triage_appl_yn " +queue_secondary_triage + " : queue_secondary_triage " + queue_appl_priority_zone + " : queue_appl_priority_zone " + queue_num_mandatory + " : queue_num_mandatory " + queue_max_num_allowed + " : queue_max_num_allowed"  );
			
			
			//End of ML-MMOH-CRF-2069
		} 
		/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		if(!five_level_triage_appl_yn.equals("Y")){
		/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
		    
	        sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW ##REPDB## WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				
				sql = sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			    
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")){red=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")){yellow=rset.getString("PRIORITY_ZONE_DESC");}
				}
		    
			
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	
	
		}/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		
		
		
		
		
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();

			String pract_type="";		
			
			if(enable_rights_yn.equals("Y")){
			String pract_sql="select  b.pract_type pract_type from sm_appl_user ##REPDB## a,am_practitioner ##REPDB## b where a.appl_user_id = ? and a.func_role_id = b.practitioner_id";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			
			pract_sql = pract_sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
			pstmt=con.prepareStatement(pract_sql);
			pstmt.setString(1,loginUser);
			rset								= pstmt.executeQuery();
			
			if(rset!=null  && rset.next()){
			pract_type =rset.getString("pract_type")==null?"":rset.getString("pract_type");
			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			if(!(pract_type.equals(""))){
			String access_rights_sql="select SEC_TRIAG_YN,CONS_YN from AE_ACCS_RIGHTS_BY_PRAC_TYPE ##REPDB## where pract_type =?";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			access_rights_sql = access_rights_sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

			pstmt=con.prepareStatement(access_rights_sql);
			pstmt.setString	(1,pract_type);
			rset = pstmt.executeQuery();
			if(rset!= null &&  rset.next() ){
				sel_triage_yn=rset.getString("SEC_TRIAG_YN")==null?"":rset.getString("SEC_TRIAG_YN");
				sel_cons_yn=rset.getString("CONS_YN")==null?"":rset.getString("CONS_YN");
			}
			if(rset!=null) rset.close();
			if(pstmt!=null)pstmt.close();
			}
			}

			if(ca_install_yn.equals("Y")) { 	
				//pstmtCA = con.prepareStatement("select count(*) cnt from CA_ENCNTR_DISCR_MSR where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID = '"+encounter_id+"' and PATIENT_ID = '"+patient_id+"' and TO_CHAR(TEST_OBSERV_DT_TM,'DD/MM/YYYY HH24:MI') = TO_CHAR(to_date('"+rec_date_time+"','DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI')");
				//Commented above line and added below code against MMS-DM-CRF-0115.3
				String caSql = "select count(*) cnt from CA_ENCNTR_DISCR_MSR ##REPDB## where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID = '"+encounter_id+"' and PATIENT_ID = '"+patient_id+"' and TO_CHAR(TEST_OBSERV_DT_TM,'DD/MM/YYYY HH24:MI') = TO_CHAR(to_date('"+rec_date_time+"','DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI')";
				caSql = caSql.replaceAll("##REPDB##",RepDb);
				pstmtCA = con.prepareStatement(caSql);
				/*End*/
				rsetCA = pstmtCA.executeQuery();
				
				if(rsetCA!=null  && rsetCA.next()) {
					ca_encntr_cnt		= rsetCA.getInt("cnt");
				}
				if(rsetCA!=null) rsetCA.close();
				if(pstmtCA!=null) pstmtCA.close(); 
		     }		

			 if(ca_encntr_cnt>0) {
				modifyYN = "N";
			 }
 try
     { 
		StringBuffer PREncount = new StringBuffer();
		PREncount.append("select to_char(trunc(visit_adm_date_time),'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy hh24:mi') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys1,");
		PREncount.append("EPISODE_ID,OP_EPISODE_VISIT_NUM , ");
		PREncount.append(" to_char(sysdate,'dd/mm/yyyy')  sqlDate,REFERRAL_ID,MLC_YN, ");
		PREncount.append(" to_char(DATE_TIME_OF_ACCIDENT,'dd/mm/yyyy hh24:mi') date_time_of_accident,");
		PREncount.append(" PLACE_OF_ACCIDENT, ");
		PREncount.append(" disaster_yn, disaster_town_code, disaster_type_code,disaster_category_code,complaint_code ");
		PREncount.append(", ATTEND_PRACTITIONER_ID, am_get_desc.am_practitioner ##REPDB##(ATTEND_PRACTITIONER_ID,'"+locale+"',1 ) practitioner_name ");
		//above line added CRF AAKH-CRF-0010 [IN038535]

		/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1 */
		
		//Below line modified by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
		PREncount.append(",VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE,VEHICLE_REG_NO1,VEHICLE_REG_NO2,PAT_POSITION_CODE");


		/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2 */
		PREncount.append(",TRAUMA_YN,OSCC_YN,MEDICAL_YN,SURGICAL_YN,MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,PROTECTIVE_DEVICE_CODE,TRANSPORT_MODE, ARRIVAL_CODE, ACCOMPANIED_BY_CODE, O_AND_G_YN, CASE_TYPE");  //Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
		//Modified above query by Thamizh selvi against ML-MMOH-CRF-0645
		//Added by Ajay Hatwate for GHL-CRF-0650
				if(isMLCAppl){
					PREncount.append(",to_char(visit_adm_date_time,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time ,MLC_REMARKS, MLC_NO_OUTSIDE_DTLS, MLC_DEATH_YN, to_char(MLC_CAPTURE_DATE,'DD/MM/YYYY HH24:MI:SS') MLC_CAPTURE_DATE, POL_REP_NO, POL_STN_ID");	
				}
		
				//Added by Ajay Hatwate for ML-MMOH-CRF-2069
				if(isSecondaryTriageQueueNum){
					PREncount.append(", SECONDARY_TRIAGE_QUEUE_NO ");
				}
		
		PREncount.append(" from  PR_ENCOUNTER ##REPDB## where ENCOUNTER_ID=? and FACILITY_ID=? ");
		//Modified above query by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		sqlFinal = PREncount.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
		pstmt_date = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		pstmt_date.setString	(1,	encounter_id);
		pstmt_date.setString	(2,	facilityId);

		rs_date = pstmt_date.executeQuery();
		

		if (rs_date!=null)
		{
			while(rs_date.next())
			{
				visit_date               = rs_date.getString(1);	
			//	sys_date                 = rs_date.getString("sys");
				sys_date            = rs_date.getString("sys1");
				sys_date_qry             = rs_date.getString("sys");
				episode_id               = rs_date.getString("EPISODE_ID");
                visit_num                = rs_date.getString("OP_EPISODE_VISIT_NUM");
				sqlDate                  = rs_date.getString("sqlDate");
				referral_id              = checkForNull(rs_date.getString("REFERRAL_ID"));
				mlc_yn			         = checkForNull(rs_date.getString("MLC_YN"));
				date_time_of_accident    = checkForNull(rs_date.getString("date_time_of_accident"));
                place_of_accident        = checkForNull(rs_date.getString("place_of_accident"));
				
	//  Tuesday, May 04, 2010 PE_EXE Venkat s
                dis_yn        = checkForNull(rs_date.getString("disaster_yn"));
                dis_town_code        = checkForNull(rs_date.getString("disaster_town_code"));
                dis_type_code        = checkForNull(rs_date.getString("disaster_type_code"));
                dis_category_code        = checkForNull(rs_date.getString("disaster_category_code"));
                dis_complaint_code        = checkForNull(rs_date.getString("complaint_code"));
				
				/*below line added for this CRF RF AAKH-CRF-0010 [IN038535]*/
				attend_practitioner_id = checkForNull(rs_date.getString("ATTEND_PRACTITIONER_ID"));
				attend_practitioner_name= checkForNull(rs_date.getString("practitioner_name"));

				/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
				vehicle_invlovedcode= checkForNull(rs_date.getString("VEHICLE_INVOLVED1_CODE"));
				vehicle_invlovedcode1= checkForNull(rs_date.getString("VEHICLE_INVOLVED2_CODE"));
				
				//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
				Vehicle_Reg_No1= checkForNull(rs_date.getString("VEHICLE_REG_NO1"));
				Vehicle_Reg_No2= checkForNull(rs_date.getString("VEHICLE_REG_NO2"));
				
				pat_position_code= checkForNull(rs_date.getString("PAT_POSITION_CODE"));

				/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
				trauma_yn= checkForNull(rs_date.getString("TRAUMA_YN"));
				oscc_yn= checkForNull(rs_date.getString("OSCC_YN"));
				medical_yn= checkForNull(rs_date.getString("MEDICAL_YN"));
				surgical_yn= checkForNull(rs_date.getString("SURGICAL_YN"));
				mech_injr_code= checkForNull(rs_date.getString("MECH_INJURY_CATG_CODE"));
				mech_injr_subcat_code= checkForNull(rs_date.getString("MECH_INJURY_SUBCATG_CODE"));
				protective_device_code= checkForNull(rs_date.getString("PROTECTIVE_DEVICE_CODE"));
				/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
				
				//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
				transport_mode_code=checkForNull(rs_date.getString("transport_mode"));
				arrival_code=checkForNull(rs_date.getString("arrival_code"));
				accompanied_by_code=checkForNull(rs_date.getString("accompanied_by_code"));

				OandGYn = checkForNull(rs_date.getString("O_AND_G_YN"));//Added by Thamizh selvi for ML-MMOH-CRF-0645
				caseType = checkForNull(rs_date.getString("case_type"));//Added by Ajay Hatwate for ML-MMOH-CRF-1653
				queue_no = checkForNull(rs_date.getString("SECONDARY_TRIAGE_QUEUE_NO"));//Added by Ajay Hatwate for ML-MMOH-CRF-2069

				 /*Added by Ajay Hawtate for GHL-CRF-0650 */
				if(isMLCAppl){
					MLC_REMARKS=checkForNull(rs_date.getString("MLC_REMARKS"));
					MLC_NO_OUTSIDE_DTLS=checkForNull(rs_date.getString("MLC_NO_OUTSIDE_DTLS"));
					MLC_DEATH_YN =rs_date.getString("MLC_DEATH_YN")==null?"N":rs_date.getString("MLC_DEATH_YN");
					MLC_CAPTURE_DATE =checkForNull(rs_date.getString("MLC_CAPTURE_DATE"));
					police_rep_no = checkForNull(rs_date.getString("POL_REP_NO"));
					police_station_dtls = checkForNull(rs_date.getString("POL_STN_ID"));
					visit_date_time = checkForNull(rs_date.getString("visit_adm_date_time"));
					MLC_REMARKS = escapeHTML(MLC_REMARKS);
					MLC_NO_OUTSIDE_DTLS = escapeHTML(MLC_NO_OUTSIDE_DTLS);
					police_rep_no = escapeHTML(police_rep_no);
					police_station_dtls = escapeHTML(police_station_dtls);
					if(MLC_DEATH_YN.equals("Y")){
						disMLCDeath = "";
					}
				}

			}
		}
			if(sys_date_time.equals("")) sys_date_time = sys_date;

	    if(!a_status.equals("")) dis1 = disabled;
		if (rs_date != null)   rs_date.close();
		if (pstmt_date != null) pstmt_date.close();
		if((PREncount != null) && (PREncount.length() > 0))
		{
			PREncount.delete(0,PREncount.length());
		}
		if (referral_id.equals(""))
				 disRefID ="";
		else
				 disRefID="disabled";

     }
     catch(Exception e) { e.printStackTrace();}
	 /*Added by Thamizh selvi against ML-MMOH-CRF-0655 Start*/
	 try
	  {	
	   StringBuffer sqlPr = new StringBuffer();
       sqlPr.append("select count(*) from pr_encounter ##REPDB## where ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	   sqlPr.append("facility_id= ?  and patient_id= ? and encounter_id !=? ");
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		sqlFinal = sqlPr.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
	   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
       pstmtEncounter.setString(1,facilityId );
	   pstmtEncounter.setString(2,patient_id );
	   pstmtEncounter.setString(3,encounter_id );

	   rsetEncounter = pstmtEncounter.executeQuery();
		  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  countRecEnc=rsetEncounter.getInt(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((sqlPr != null) && (sqlPr.length() > 0))
		  {
			sqlPr.delete(0,sqlPr.length());
		  }
		  if (countRecEnc==0)
		  {
			  EncounterProp = "disabled";
		  }else
		  {
			  EncounterProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}

	   try
	  {	
	   StringBuffer prevEnc = new StringBuffer();
	   prevEnc.append("SELECT (SYSDATE - MAX (VISIT_STATUS_SET_ON_DATE)) ");
	   prevEnc.append(" * 24  PREV_VISIT_HRS FROM PR_ENCOUNTER ##REPDB## WHERE  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	   prevEnc.append(" facility_id = ?  AND patient_id = ?  ");
	   prevEnc.append(" AND VISIT_STATUS in ('07', '09')   ");
	   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		sqlFinal = prevEnc.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
	   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
       pstmtEncounter.setString(1, facilityId);
	   pstmtEncounter.setString(2, patient_id);

	   rsetEncounter = pstmtEncounter.executeQuery();
			  while(rsetEncounter!=null && rsetEncounter.next())
				 {
				  prev_visit_hrs = rsetEncounter.getDouble(1);
				 }
		  if(rsetEncounter!=null) rsetEncounter.close();
		  if(pstmtEncounter!=null) pstmtEncounter.close();
		  if((prevEnc != null) && (prevEnc.length() > 0))
		  {
			prevEnc.delete(0,prevEnc.length());
		  }
		  if(prev_visit_hrs > 24 || prev_visit_hrs == 0) {
			  VisitProp = "disabled";
		  }else if(prev_visit_hrs > 0 && prev_visit_hrs <= 24)
		  {
			  VisitProp ="";
		  }
	  }catch(Exception e) {e.printStackTrace();}
	  /*End*/
  try{
        StringBuffer  emerdetails = new StringBuffer();
		emerdetails.append("select COMPLAINT_CODE, ");
		emerdetails.append("MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,");
		emerdetails.append(" VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE, ");
		//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
		emerdetails.append(" VEHICLE_REG_NO1,VEHICLE_REG_NO2, ");
		emerdetails.append(" PROTECTIVE_DEVICE_CODE,PAT_POSITION_CODE, ");
		emerdetails.append(" OSCC_YN,FBC_YN,");
		emerdetails.append(" IMMUNIZATION_STATUS,ATT_GIVEN_YN,DEVP_MILESTONE_AGE_YN,");
		emerdetails.append(" IM_UPTO_DATE_YN,MENARCHE_YN,HEIGHT,WEIGHT,");
		emerdetails.append(" CIRCUMFERENCE, ");
		emerdetails.append(" to_char(LMP_DATE,'dd/mm/yyyy') LMP_DATE,PREGNANT_YN,");
		emerdetails.append(" MECH_INJURY_SUBCATG_CODE,PAT_PRIORITY,TRAUMA_YN,");
		emerdetails.append(" REMARKS,MEDICAL_YN,SURGICAL_YN,IMMOBILIZATION_CODE,"); 
		emerdetails.append(" TREATMENT_AREA_CODE ,PRIORITY_ZONE,BED_NO, PAT_PRIORITY,"); 
		emerdetails.append(" POL_STN_ID,POL_REP_NO,DISASTER_YN,DISASTER_TOWN_CODE,");
		emerdetails.append(" to_char(DATE_TIME_OF_ACCIDENT,'dd/mm/yyyy hh24:mi') DATE_TIME_OF_ACCIDENT,");
		emerdetails.append(" PLACE_OF_ACCIDENT, ");
		//Modified for CRF ML-MMOH-CRF-0654 by Ajay Hatwate
		if(isMLCAppl){
			emerdetails.append(" mlc_death_yn, MLC_REMARKS, MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS, ");	
		}
		//Added by Ajay Hatwate for ML-MMOH-CRF-2069
		if(isSecondaryTriageQueueNum){
			emerdetails.append(" SECONDARY_TRIAGE_QUEUE_NO, ");
		}
		emerdetails.append(" DISASTER_TYPE_CODE,disaster_category_code,AMBULATORY_STATUS,transport_mode,arrival_code,accompanied_by_code, O_AND_G_YN, INITIAL_MGMT_MEDICATION, INITIAL_MGMT_OTHERS, CASE_TYPE from ");//Modified by Thamizh selvi against ML-MMOH-CRF-0645, ML-MMOH-CRF-0651	
		emerdetails.append(" AE_PAT_EMERGENCY_DETAIL ##REPDB## where ENCOUNTER_ID= ? AND ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		emerdetails.append(" FACILITY_ID=? and ");
		emerdetails.append(" recorded_date=to_date(?,'dd/mm/yyyy hh24:mi:ss') " );  
	//	emerdetails.append(" to_char(RECORDED_DATE,'dd/mm/yyyy hh24:mi:ss')=? " );     

		StringBuffer  sqltreatment2 = new StringBuffer();
		sqltreatment2.append("select TREATMENT_AREA_CODE ,PRIORITY_ZONE,REFERRAL_ID,AE_BED_NO, PAT_PRIORITY,DIS_REGN_REFERENCE,patient_class from ");
		sqltreatment2.append(" op_patient_queue ##REPDB## where ENCOUNTER_ID =? and  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		sqltreatment2.append(" FACILITY_ID=? ");
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String treatmentSql = sqltreatment2.toString();
		treatmentSql = treatmentSql.replaceAll("##REPDB##",RepDb);
		/*End*/

   /*       
		StringBuffer  sqlaeage = new StringBuffer();
		sqlaeage.append("select MIN_AGE_FOR_PREG_DTL, MAX_AGE_FOR_PAED_DTL,ORDER_CATALOG_CODE3 ");
		sqlaeage.append(" from ae_param where OPERATING_FACILITY_ID= ? ");
				
		StringBuffer  sqltreatment1 = new StringBuffer();
		sqltreatment1.append("select TREATMENT_AREA_CODE ,PRIORITY_ZONE,BED_NO, PAT_PRIORITY from ");
		sqltreatment1.append(" ae_pat_emergency_detail where ENCOUNTER_ID =? and  ");
		sqltreatment1.append(" FACILITY_ID=? and recorded_date=to_date(?,'dd/mm/yyyy hh24:mi:ss')");
		 
	    StringBuffer  sqlAge = new StringBuffer();
		sqlAge.append("select Calculate_Age(TO_CHAR(date_of_birth, ");
		sqlAge.append(" 'dd/mm/yyyy'),1), sex,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') ");
		sqlAge.append("date_of_birth,pat_dtls_unknown_yn from mp_patient where patient_id = ?  ");

		StringBuffer sqlComplaint = new StringBuffer();
		sqlComplaint.append("select COMPLAINT_CODE,COMPLAINT_DESC from AM_COMPLAINT_LANG_VW  where language_id='"+locale+"' and EFF_STATUS='E' order by COMPLAINT_DESC ");

 

  */
		StringBuffer sqlUnit = new StringBuffer();
		sqlUnit.append(" select UNIT_OF_LENGTH_NB,UNIT_OF_WT_NB,");
		sqlUnit.append(" UNIT_OF_CIRCUM_NB,NB_MOTHER_CUTOFF_AGE from MP_PARAM ##REPDB## ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
 

		
        StringBuffer sqlAmbulatory = new StringBuffer();
		sqlAmbulatory.append(" select AMBULATORY_STATUS,SHORT_DESC from ");
		sqlAmbulatory.append(" AM_AMBULATORY_STATUS_LANG_VW ##REPDB## where ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1   
		sqlAmbulatory.append(" language_id='"+locale+"'  and EFF_STATUS='E' and ");
		sqlAmbulatory.append(" nvl(eff_date_from,sysdate) >= sysdate ");
		sqlAmbulatory.append(" and nvl(eff_date_to,sysdate) <= sysdate ");
		sqlAmbulatory.append(" order by SHORT_DESC ");
		
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String AmbulatorySql = sqlAmbulatory.toString();
		AmbulatorySql = AmbulatorySql.replaceAll("##REPDB##",RepDb);
		/*End*/
	   
		StringBuffer  sqlPosition = new StringBuffer();
		//sqlPosition.append("select PAT_POSITION_CODE,SHORT_DESC from AE_PAT_POSITION_LANG_VW  where language_id='"+locale+"' and EFF_STATUS='E' order by SHORT_DESC");
		sqlPosition.append("SELECT a.PAT_POSITION_CODE, a.SHORT_DESC FROM AE_PAT_POSITION_LANG_VW ##REPDB## a WHERE a.language_id = '"+locale+"' AND a.EFF_STATUS = 'E' AND a.pat_position_code like '%%' ORDER BY a.SHORT_DESC");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String PositionSql = sqlPosition.toString();
		PositionSql = PositionSql.replaceAll("##REPDB##",RepDb);

		sqlFinal = sqlUnit.toString();
		sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		/*End*/
                       pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				       rset = pstmt.executeQuery();
					   
					   while(rset!=null && rset.next())
					   {
                             heightDesc = rset.getString("UNIT_OF_LENGTH_NB");
							 weightDesc = rset.getString("UNIT_OF_WT_NB");
							 circumDesc = rset.getString("UNIT_OF_CIRCUM_NB");
							 nb_mother_min_age = rset.getInt("NB_MOTHER_CUTOFF_AGE");
					   }                      

					     if(nb_mother_min_age>0) 
							 min_age_pregnancy=nb_mother_min_age;                              
						else
                             min_age_pregnancy=min_age_pregnancy1;
					
   					   if(rset!=null) rset.close();
					   if(pstmt!=null) pstmt.close();
                       if((sqlUnit != null) && (sqlUnit.length() > 0))
					   {
							sqlUnit.delete(0,sqlUnit.length());
					   }
					   if(heightDesc!=null && heightDesc.equalsIgnoreCase("C"))
							heightDesc = "CM";
					   else if(heightDesc!=null && heightDesc.equalsIgnoreCase("I"))
							heightDesc = "Inch";
					   if(weightDesc!=null && weightDesc.equalsIgnoreCase("K"))
							weightDesc = "KG";
					   else if(weightDesc!=null && weightDesc.equalsIgnoreCase("L"))
							weightDesc = "LB";
					   if(circumDesc!=null && circumDesc.equalsIgnoreCase("C"))
							circumDesc = "CM";
					   else if(circumDesc!=null && circumDesc.equalsIgnoreCase("I"))
							circumDesc = "Inch";	
					/*	
                       pstmt = con.prepareStatement(sqlaeage.toString());
					   pstmt.setString(1,facilityId);

				       rset = pstmt.executeQuery();
					   
					   while(rset!=null && rset.next())
					   {
                             min_age_pregnancy1 = rset.getInt(1);
							 max_age_paediatric = rset.getInt(2);
                             order_catalog_code3  = checkForNull(rset.getString("order_catalog_code3"));

					   } 
					  
					  if(rset!=null) rset.close();
					  if(pstmt!=null) pstmt.close();
					  if((sqlaeage != null) && (sqlaeage.length() > 0))
					  {
							sqlaeage.delete(0,sqlaeage.length());
					  }
					*/
				
     			  if(modify_flag.equals("Y")) {
					  try {
                        if (!rec_date_time.equals("")) {
							   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
								sqlFinal = emerdetails.toString();
								sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
								/*End*/
								mlcQuery = sqlFinal;
							   pstmt1 = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1					   
							   pstmt1.setString	(1,	encounter_id);
							   pstmt1.setString	(2,	facilityId);
							   pstmt1.setString	(3,	rec_date_time);
							   
							   display_triage_record_date_time=rec_date_time; // Added for ML-MMOH-0656 by shanmukh on 4th-Apr-2018
							   rset1 = pstmt1.executeQuery();
							   
							   while(rset1!=null && rset1.next()) {
									 complaint_code=checkForNull(rset1.getString("COMPLAINT_CODE")); 
									 mech_injr_code=checkForNull(rset1.getString("MECH_INJURY_CATG_CODE"));
									 mech_injr_subcat_code=checkForNull(rset1.getString("MECH_INJURY_SUBCATG_CODE"));
									 vehicle_invlovedcode=checkForNull(rset1.getString("VEHICLE_INVOLVED1_CODE"));
									 vehicle_invlovedcode1=checkForNull(rset1.getString("VEHICLE_INVOLVED2_CODE"));

								//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
									Vehicle_Reg_No1=checkForNull(rset1.getString("VEHICLE_REG_NO1"));
									 Vehicle_Reg_No2=checkForNull(rset1.getString("VEHICLE_REG_NO2"));
									 protective_device_code=checkForNull(rset1.getString("PROTECTIVE_DEVICE_CODE"));
									 pat_position_code=checkForNull(rset1.getString("PAT_POSITION_CODE"));
									 oscc_yn=checkForNull(rset1.getString("OSCC_YN"));
									 immunization_status=checkForNull(rset1.getString("IMMUNIZATION_STATUS"));
									 att_given=checkForNull(rset1.getString("ATT_GIVEN_YN"));
									 dev_mile_stone=checkForNull(rset1.getString("DEVP_MILESTONE_AGE_YN"));
									 emerdetails.append(" IM_UPTO_DATE_YN,MENARCHE_YN,HEIGHT,WEIGHT,");
									 imm_date=checkForNull(rset1.getString("IM_UPTO_DATE_YN"));
									 menarche_yn=checkForNull(rset1.getString("MENARCHE_YN"));
									 height=checkForNull(rset1.getString("HEIGHT"));
									 weight=checkForNull(rset1.getString("WEIGHT"));
									 circumference=checkForNull(rset1.getString("CIRCUMFERENCE"));
									 lmp_date=checkForNull(rset1.getString("LMP_DATE"));
									 pregnant_yn=checkForNull(rset1.getString("PREGNANT_YN"));
									 mech_injury_subcatg_code=checkForNull(rset1.getString("MECH_INJURY_SUBCATG_CODE"));
									 pat_priority       =checkForNull(rset1.getString("PAT_PRIORITY"));
									 trauma_yn          =checkForNull(rset1.getString("TRAUMA_YN"));
									 triage_remarks     =checkForNull(rset1.getString("REMARKS"));
									 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
									 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
									 bed_no= rset1.getString("BED_NO")==null?"":rset1.getString("BED_NO");
									 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
									 surgical_yn        =checkForNull(rset1.getString("SURGICAL_YN"));
									 medical_yn         =checkForNull(rset1.getString("MEDICAL_YN"));
									 immobilization     =checkForNull(rset1.getString("IMMOBILIZATION_CODE"));									 
									 police_rep_no      =checkForNull(rset1.getString("POL_REP_NO"));
									 police_station_dtls=checkForNull(rset1.getString("POL_STN_ID"));
									 a_status		    =checkForNull(rset1.getString("AMBULATORY_STATUS"));
									 date_time_of_accident    = checkForNull(rset1.getString("DATE_TIME_OF_ACCIDENT"));
									 place_of_accident        = checkForNull(rset1.getString("PLACE_OF_ACCIDENT"));
									 fbc_yn        = checkForNull(rset1.getString("FBC_YN"));
									 //Below line added for this CRF ML-MMOH-CRF-0654
									 transport_mode_code=checkForNull(rset1.getString("transport_mode"));
									 arrival_code=checkForNull(rset1.getString("arrival_code"));
									 accompanied_by_code=checkForNull(rset1.getString("accompanied_by_code"));

									 //End this CRF ML-MMOH-CRF-0654

									 OandGYn = checkForNull(rset1.getString("O_AND_G_YN"));//Added by Thamizh selvi against ML-MMOH-CRF-0645
									 
									 /*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
									 medication			= checkForNull(rset1.getString("INITIAL_MGMT_MEDICATION"));
									 intialMgmtOthers	= checkForNull(rset1.getString("INITIAL_MGMT_OTHERS"));
									 /*End*/

									 //Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023
									 if(isMLCAppl){
										 MLC_REMARKS = checkForNull(rset1.getString("MLC_REMARKS")); 
										 MLC_CAPTURE_DATE = checkForNull(rset1.getString("MLC_CAPTURE_DATE")); 
										 MLC_NO_OUTSIDE_DTLS = checkForNull(rset1.getString("MLC_NO_OUTSIDE_DTLS")); 
										 MLC_DEATH_YN = checkForNull(rset1.getString("mlc_death_yn")); 
										MLC_REMARKS = escapeHTML(MLC_REMARKS);
										MLC_NO_OUTSIDE_DTLS = escapeHTML(MLC_NO_OUTSIDE_DTLS);
										police_rep_no = escapeHTML(police_rep_no);
										police_station_dtls = escapeHTML(police_station_dtls);
									 }
									 caseType = checkForNull(rset1.getString("case_type"));//Added by Ajay Hatwate for ML-MMOH-CRF-1653					
									 caseTypeDisable =" disabled ";//Added by Ajay Hatwate for ML-MMOH-CRF-1653
				queue_no = checkForNull(rset1.getString("SECONDARY_TRIAGE_QUEUE_NO"));
				dis_queue_no = " disabled ";
											// System.out.println(caseType + " case Type " + caseTypeDisable + " isCTDisabled " + queue_no + " queue_no ");
									if(fbc_yn.equals("Y")) {
										 fbccheck="Checked";
										 fbccheck_val="Y";
							        } else {
										fbccheck="";
										fbccheck_val="N";
									}
							    }
								
								 if(rset1!=null) rset1.close();
								 if(pstmt1!=null) pstmt1.close();
								 if((emerdetails != null) && (emerdetails.length() > 0)) {
									emerdetails.delete(0,emerdetails.length());
								 }	
								 
								 
								 disaster_yn=dis_yn;
								 disaster_town_code=dis_town_code;
								 disaster_type_code=dis_type_code;
								 disaster_category_code=dis_category_code;
								 referral_id=referral_id;
				 							 
		/*	 Tuesday, May 04, 2010 PE_EXE Venkat s
								 StringBuffer sqlTiage1 = new StringBuffer();
								 sqlTiage1.append("select disaster_yn,disaster_town_code,disaster_type_code,disaster_category_code,referral_id  from pr_encounter where encounter_id ='"+encounter_id+"'  and facility_id ='"+facilityId+"' ");								
								 pstmt1 = con.prepareStatement(sqlTiage1.toString());
								 rset1 = pstmt1.executeQuery();
								 
								 while(rset1!=null && rset1.next()) {								
									 disaster_yn=checkForNull(rset1.getString("disaster_yn"));
									 disaster_town_code =checkForNull(rset1.getString("disaster_town_code"));
									 disaster_type_code =checkForNull(rset1.getString("disaster_type_code"));
									 disaster_category_code =checkForNull(rset1.getString("disaster_category_code"));
									 referral_id=checkForNull(rset1.getString("referral_id"));
								}
								if(rset1!=null) rset1.close();
								if(pstmt1!=null) pstmt1.close();
								if((sqlTiage1 != null) && (sqlTiage1.length() > 0)) {
								    sqlTiage1.delete(0,sqlTiage1.length());
								} 
								*/
					
           			      } else {

								 disaster_yn=dis_yn;
								 disaster_town_code=dis_town_code;
								 disaster_type_code=dis_type_code;
								 disaster_category_code=dis_category_code;
								 referral_id=referral_id;
							/* Tuesday, May 04, 2010 PE_EXE Venkat s
								StringBuffer sqlTiage1 = new StringBuffer();
								sqlTiage1.append("select disaster_yn,disaster_town_code,disaster_type_code,disaster_category_code,referral_id  from pr_encounter where encounter_id ='"+encounter_id+"'  and facility_id ='"+facilityId+"' ");
							  
								pstmt1 = con.prepareStatement(sqlTiage1.toString());
								rset1 = pstmt1.executeQuery();
								
								while(rset1!=null && rset1.next())
								{							
								 disaster_yn=checkForNull(rset1.getString("disaster_yn"));
								 disaster_town_code =checkForNull(rset1.getString("disaster_town_code"));
								 disaster_type_code =checkForNull(rset1.getString("disaster_type_code"));
								 disaster_category_code =checkForNull(rset1.getString("disaster_category_code"));
								 referral_id=checkForNull(rset1.getString("referral_id"));
								}
								if(rset1!=null) rset1.close();
								if(pstmt1!=null) pstmt1.close();
								if((sqlTiage1 != null) && (sqlTiage1.length() > 0))
								 {
									sqlTiage1.delete(0,sqlTiage1.length());
								 }
           			    	  */
						  }

					
					 }catch(Exception e) {
							e.printStackTrace();
					 }
                     dis1    = disabled;
					 dis3    = disabled;
                     disMed  = disabled;
                     disSur  = disabled;
					 dis2    = "readonly";
					 dis5    = disabled;
                     disOscc = disabled;
					 dis6    = disabled; 
					 dis7    = disabled;
					 dis8    = disabled;
					 dis9    = disabled;
					 dis10    = disabled;
					 dis11   = disabled;
                     disMLC  = disabled;
					 dis12   = disabled;
					 dis13   = disabled;
					 dis14   = disabled;
					 dis15   = disabled;
					 disabled991   = disabled;
					 disabled99    = disabled;
					 disImm = disabled;
					 disMenarche = disabled;
					 disHeight= disabled;
					 disWeight = disabled;
					 disCir = disabled;
					 disabledPre = disabled;
					 disabled111=disabled;
					 disabled13=disabled;
					 disabled12=disabled;
					 disPriority=disabled;
					 disTreatArea=disabled;
					 disBed=disabled;
					 disBed1=disabled;
					 disDisaster=disabled;
					 disabled11=disabled;
					 disImmobil=disabled;
					 disRefID =disabled;
					 FBCProp  ="disabled";
					 disDateAcci = disabled;
					 disPlaceAcci = disabled;
					 
					 dis_triage_record_date_time=disabled; // Added for ML-MMOH-0656 by shanmukh

					 
					 dis16 = disabled; //AAKH-CRF-0010 [IN:038535]	
					 
					 accompanied_by_dis=disabled; //Added for this CRF ML-MMOH-CRF-0654

					 disOandGYn = disabled;//Added by Thamizh selvi against ML-MMOH-CRF-0645

					 /*Added by Thamizh selvi on 13th Apr 2018 against ML-MMOH-CRF-0651 Start*/
					 disIntialMgmtOthers	= disabled;
					 disMedication			= disabled;
					 /*End*/
					 

					 prioritynewdisabled = "disabled";
				   }else if(modify_flag.equals("N"))
	                {



								 disaster_yn=dis_yn;
								 disaster_town_code=dis_town_code;
								 disaster_type_code=dis_type_code;
								 disaster_category_code=dis_category_code;
								 referral_id=referral_id;
								 complaint_code=dis_complaint_code;
									/* Tuesday, May 04, 2010 PE_EXE Venkat s
									StringBuffer sqlTiage1 = new StringBuffer();
									sqlTiage1.append("select disaster_yn,disaster_town_code,disaster_type_code,disaster_category_code,referral_id,complaint_code  from pr_encounter where encounter_id ='"+encounter_id+"'  and facility_id ='"+facilityId+"' ");

									pstmt1 = con.prepareStatement(sqlTiage1.toString());
									//  pstmt1.setString(1,encounter_id);
									///	  pstmt1.setString(2,facilityId);

									rset1 = pstmt1.executeQuery();
									
									while(rset1!=null && rset1.next())
									{
									disaster_yn=checkForNull(rset1.getString("disaster_yn"));
									disaster_town_code=checkForNull(rset1.getString("disaster_town_code"));
									disaster_type_code =checkForNull(rset1.getString("disaster_type_code"));
									disaster_category_code =checkForNull(rset1.getString("disaster_category_code"));
									referral_id=checkForNull(rset1.getString("referral_id"));
									complaint_code=checkForNull(rset1.getString("complaint_code"));
									}
									if(rset1!=null) rset1.close();
									if(rset1!=null) rset1.close();
									if(pstmt1!=null) pstmt1.close();
									if((sqlTiage1 != null) && (sqlTiage1.length() > 0))
									{
									sqlTiage1.delete(0,sqlTiage1.length());
									}
									*/
           			    }



              if(medical_yn.equals("Y")) {
		          checkedMed="checked";
			  }else{
                     checkedMed="";
			  }
			 if(surgical_yn.equals("Y")) {
		             checkedSur="checked";
			   }else{
                     checkedSur="";
               } 
			 if(disaster_yn.equals("Y")) {
		            checked1="checked";
			  } else {
                    checked1="";
					disabled11="disabled";
              }
			 if(oscc_yn.equals("Y")) {        
				 checked2="checked";
	  			  disable3="disabled";
	         } else {
				 checked2="";
	         }    
			 if(mlc_yn.equals("Y")) {		
		          checked3="checked";
				  dis12   = "";
				  dis13   = "";
				  disMLCDeath = "";
				  disOutMLCDet = "";
				  disDateOfCapt = "";
				  disMLCRemark = "";
             }else{
                  checked3="";
				  dis12   = "disabled";
				  dis13   = "disabled";
				  disMLCDeath = "disabled";
				  disOutMLCDet = "disabled";
				  disDateOfCapt = "disabled";
				  disMLCRemark = "disabled";
            }
			  /*Added by Thamizh selvi against ML-MMOH-CRF-0645*/
			  if(OandGYn.equals("Y"))
		          checkedOandGYn = "checked";
			  else
                  checkedOandGYn = "";
			  /*End*/
				    


                if(immunization_status.equals("F"))
	             {
				          selected="selected" ;
						  dis14 = disabled;
	             }
                else if(immunization_status.equals("P"))
	            {
                          selected1="selected" ;
						  dis14 = disabled;
                }
                else if(immunization_status.equals("U"))
	            {
                         selected2="selected" ;
						 dis14 = disabled;
                } 

                if(att_given.equals("Y"))
	            {
				         checked4="checked" ;
						 dis15 = disabled;
                }
			    else
	            { 
                         checked4="" ;
                }
				if(dev_mile_stone.equals("Y"))
	             {
				          checked5="checked" ;
						  disabled99="disabled";
						  disabled991="disabled";

                 }
				else
	            {
                          checked5="" ;	
                }
				if(imm_date.equals("Y")){
				          checked6="checked" ;
						  disImm = disabled;
				}

				else{
                          checked6="" ;	
				}
				if(menarche_yn.equals("Y"))
				{	
				          checked7="checked" ;
						  checked8="checked";
						  disMenarche=disabled;
		        }
						  
			    else
				{
                          checked7="" ;	
						  checked8="" ;
				}
                if(sex.equalsIgnoreCase("M"))
	            {
					disMenarche=disabled;
				} 
			    if(pregnant_yn.equals("Y"))
	             {
				
				          checked8="checked" ;
						  disabledPre=disabled;
				
                 }
				  
			    else
	             {
                       checked8="" ;
                 }
              if(trauma_yn.equals("Y")){
				
				
				          checked9="checked" ;
						 // dis5 = disabled; 	/*commented by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
			  }
			    else
	           {
                          checked9="" ;
               } 

	
		 if (!rec_date_time.equals(""))
	     {

	/*		 
             pstmt1 = con.prepareStatement(sqltreatment1.toString());
			
			 pstmt1.setString	(1,	encounter_id);
			 pstmt1.setString	(2,	facilityId);
			 pstmt1.setString	(3,	rec_date_time);

			 rset1 = pstmt1.executeQuery();
			 
			
			 while(rset1!=null && rset1.next())
			 {
			  
			 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
			 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
			 bed_no= rset1.getString("BED_NO")==null?"":rset1.getString("BED_NO");
			 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
			 }
			 if(rset1!=null) rset1.close();
			 if(pstmt1!=null) pstmt1.close();
   */		
			pstmt1 = con.prepareStatement(treatmentSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			pstmt1.setString	(1,	encounter_id);
			pstmt1.setString	(2,	facilityId);
			rset1 = pstmt1.executeQuery();
			
			while(rset1!=null && rset1.next())
			{
	  
			dis_regn_ref= rset1.getString("DIS_REGN_REFERENCE")==null?"":rset1.getString("DIS_REGN_REFERENCE");
			referral_id= rset1.getString("REFERRAL_ID")==null?"":rset1.getString("REFERRAL_ID");
			patient_class	= rset1.getString("patient_class")==null?"":rset1.getString("patient_class");

			}
			
		    if(rset1!=null) rset1.close();
			if(pstmt1!=null) pstmt1.close();

		 } else {
					pstmt1 = con.prepareStatement(treatmentSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					pstmt1.setString	(1,	encounter_id);
					pstmt1.setString	(2,	facilityId);
					rset1 = pstmt1.executeQuery();
					while(rset1!=null && rset1.next()){				  
						 treat_code = rset1.getString("TREATMENT_AREA_CODE")==null?"":rset1.getString("TREATMENT_AREA_CODE"); 
						 priority = rset1.getString("PRIORITY_ZONE")==null?"":rset1.getString("PRIORITY_ZONE"); 
						 bed_no= rset1.getString("AE_BED_NO")==null?"":rset1.getString("AE_BED_NO");
						 priority_code= rset1.getString("PAT_PRIORITY")==null?"":rset1.getString("PAT_PRIORITY");
						 dis_regn_ref= rset1.getString("DIS_REGN_REFERENCE")==null?"":rset1.getString("DIS_REGN_REFERENCE");
						 referral_id= rset1.getString("REFERRAL_ID")==null?"":rset1.getString("REFERRAL_ID");
						 patient_class	= rset1.getString("patient_class")==null?"":rset1.getString("patient_class");
					}			
					 if(rset1!=null) rset1.close();
					 if(pstmt1!=null) pstmt1.close();
			      }
		 /*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		 
			if(!five_level_triage_appl_yn.equals("Y")){
		 
				  if (priority.equals("R")) priorityStatus1="checked";
				  else if (priority.equals("Y")) priorityStatus2="checked";
				  else if (priority.equals("G")) priorityStatus3="checked";
				  if (priority.equals("R")) priority_no="1";
				  else if (priority.equals("Y")) priority_no="3";
				  else if (priority.equals("G")) priority_no="2";
				  else if (priority.equals("U")) priority_no="4";
		
				  if (priority.equals("R")) {  
					 priorityStatus1="checked";
					 disabled12="disabled";
					 disabled13="disabled";								   
				  } else if (priority.equals("Y")) {
					 priorityStatus2="checked";
					 disabled111="disabled";
					 disabled13="disabled";
				  } else if (priority.equals("G")) {
					  priorityStatus3="checked";
					  disabled111="disabled";
					  disabled12="disabled";
				  }
			}else{
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 7th 2014 Start*/	
			  	sql="select get_task_applicability ##REPDB##('CA_CHART_REC',(select dflt_privilege_status from  ca_appl_task ##REPDB## where APPL_TASK_ID = 'CA_CHART_REC'),'CA','','"+facilityId+"','"+episode_id+"','"+patient_id+"') ca_chart_rec_status from dual";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sql.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
			  	pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			  	rset    = pstmt.executeQuery();
				while(rset!=null && rset.next()){
					ca_chart_rec_status		= (rset.getString("ca_chart_rec_status")==null || rset.getString("ca_chart_rec_status")=="")?"":rset.getString("ca_chart_rec_status");
				}
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
			
				sql="select get_task_applicability ##REPDB##('CLINICAL_NOTES',(select dflt_privilege_status from  ca_appl_task ##REPDB## where APPL_TASK_ID = 'CLINICAL_NOTES'),'CA','','"+facilityId+"','"+episode_id+"','"+patient_id+"') clinical_notes_status from dual";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sql.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
			  	pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			  	rset    = pstmt.executeQuery();
				while(rset!=null && rset.next()){
					clinical_notes_status		= (rset.getString("clinical_notes_status")==null || rset.getString("clinical_notes_status")=="")?"":rset.getString("clinical_notes_status");
				}
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 7th 2014 End*/
				
			
			}
		          
	  StringBuffer sqlarea = new StringBuffer();
	  sqlarea.append("select LONG_DESC from mp_res_town_lang_vw ##REPDB## where  language_id='"+locale+"'  and res_town_code=?");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sqlarea.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	  pstmt1 = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
      pstmt1.setString(1,disaster_town_code);
	   
	  rset1 = pstmt1.executeQuery();
	  
		 while(rset1!=null && rset1.next())
		 {
		 dis_area = rset1.getString("LONG_DESC");
		 }
		 if(rset1!=null) rset1.close();
		 if(pstmt1!=null) pstmt1.close();
		 if((sqlarea != null) && (sqlarea.length() > 0))
		 {
			sqlarea.delete(0,sqlarea.length());
		 }


     /**  If CA Installed New Tab Other Details Added on 03/02/2005 **/ 

            _bw.write(_wl_block9Bytes, _wl_block9);

				
				  StringBuffer sqlComplaint1 = new StringBuffer();
	              sqlComplaint1.append("select COMPLAINT_DESC from AM_COMPLAINT_LANG_VW ##REPDB## where  language_id='"+locale+"'  and COMPLAINT_CODE=?");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlComplaint1.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				  pstmt1 = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				  pstmt1.setString(1,complaint_code);
				   
				  rset1 = pstmt1.executeQuery();
				    
					 while(rset1!=null && rset1.next())
					 {
					 complaint = rset1.getString("COMPLAINT_DESC")==null?"":rset1.getString("COMPLAINT_DESC");
					 }
					 if(rset1!=null) rset1.close();
					 if(pstmt1!=null) pstmt1.close();
					 if((sqlComplaint1 != null) && (sqlComplaint1.length() > 0))
					 {
						sqlComplaint1.delete(0,sqlComplaint1.length());
					 }
				 

					//Added By Krishna Pranay regarding ML-MMOH-CRF-1759.1 start
					 pstmt1 = con.prepareStatement("SELECT INVOKE_MENSTRUAL_HISTORY_YN FROM MP_PARAM");
					 rset1 = pstmt1.executeQuery();
					    if (rset1.next()){
					    	invokeMenstrualHistYN = rset1.getString("INVOKE_MENSTRUAL_HISTORY_YN");
					    }
					    if(pstmt1!=null) pstmt1.close();
					    if(rset1!=null) rset1.close();	
					
					 
					   pstmt1 = con.prepareStatement("SELECT EVENT_STATUS FROM ( SELECT EVENT_STATUS, ROW_NUMBER() OVER (ORDER BY ADDED_DATE DESC) AS rn FROM CA_MENS_HIS_TRANS_DTL WHERE PATIENT_ID = ? ) ranked WHERE rn = 1");
					   pstmt1.setString(1, patient_id);
					   rset1 = pstmt1.executeQuery();
					   if (rset1.next()){
					   latestMensDtlStatus = rset1.getString("EVENT_STATUS")==null?"":rset1.getString("EVENT_STATUS");
					   }
					   if(pstmt1!=null) pstmt1.close();
					   if(rset1!=null) rset1.close();	 
					   
					   
					   if ("Y".equals(invokeMenstrualHistYN) && "A".equals(latestMensDtlStatus)) {
							rec_view_lmp_details_label = "eMP.ViewModifyMenstrualHistoryDetails.label";
							MensdisabledPre=disabled;
					   }
					   else
					   {
						   rec_view_lmp_details_label = "eMP.RecordMenstrualHistoryDetails.label";
					   }
					 //Added By Krishna Pranay regarding ML-MMOH-CRF-1759.1 end
			  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block11Bytes, _wl_block11);

if(!function_id.equals("query"))
{
            _bw.write(_wl_block2Bytes, _wl_block2);
            {java.lang.String __page ="../../eAE/jsp/AESecondaryTriageInclude.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("ca_install_yn"), weblogic.utils.StringUtils.valueOf(ca_install_yn
                        )},{ weblogic.utils.StringUtils.valueOf("isSecTrgBackDateTimeAppl"), weblogic.utils.StringUtils.valueOf(isSecTrgBackDateTimeAppl
                        )},{ weblogic.utils.StringUtils.valueOf("sys_date_time"), weblogic.utils.StringUtils.valueOf(sys_date_time
                        )},{ weblogic.utils.StringUtils.valueOf("dis_triage_record_date_time"), weblogic.utils.StringUtils.valueOf(dis_triage_record_date_time
                        )},{ weblogic.utils.StringUtils.valueOf("VisitProp"), weblogic.utils.StringUtils.valueOf(VisitProp
                        )},{ weblogic.utils.StringUtils.valueOf("EncounterProp"), weblogic.utils.StringUtils.valueOf(EncounterProp
                        )},{ weblogic.utils.StringUtils.valueOf("facilityId"), weblogic.utils.StringUtils.valueOf(facilityId
                        )},{ weblogic.utils.StringUtils.valueOf("RepDb"), weblogic.utils.StringUtils.valueOf(RepDb
                        )},{ weblogic.utils.StringUtils.valueOf("sqlDate"), weblogic.utils.StringUtils.valueOf(sqlDate
                        )},{ weblogic.utils.StringUtils.valueOf("priority"), weblogic.utils.StringUtils.valueOf(priority
                        )},{ weblogic.utils.StringUtils.valueOf("five_level_triage_appl_yn"), weblogic.utils.StringUtils.valueOf(five_level_triage_appl_yn
                        )},{ weblogic.utils.StringUtils.valueOf("isPriorityZoneAppl"), weblogic.utils.StringUtils.valueOf(isPriorityZoneAppl
                        )},{ weblogic.utils.StringUtils.valueOf("disPriority"), weblogic.utils.StringUtils.valueOf(disPriority
                        )},{ weblogic.utils.StringUtils.valueOf("optSelected"), weblogic.utils.StringUtils.valueOf(optSelected
                        )},{ weblogic.utils.StringUtils.valueOf("priorityStatus1"), weblogic.utils.StringUtils.valueOf(priorityStatus1
                        )},{ weblogic.utils.StringUtils.valueOf("priorityStatus2"), weblogic.utils.StringUtils.valueOf(priorityStatus2
                        )},{ weblogic.utils.StringUtils.valueOf("priorityStatus3"), weblogic.utils.StringUtils.valueOf(priorityStatus3
                        )},{ weblogic.utils.StringUtils.valueOf("disabled111"), weblogic.utils.StringUtils.valueOf(disabled111
                        )},{ weblogic.utils.StringUtils.valueOf("disabled11"), weblogic.utils.StringUtils.valueOf(disabled11
                        )},{ weblogic.utils.StringUtils.valueOf("disabled12"), weblogic.utils.StringUtils.valueOf(disabled12
                        )},{ weblogic.utils.StringUtils.valueOf("disabled13"), weblogic.utils.StringUtils.valueOf(disabled13
                        )},{ weblogic.utils.StringUtils.valueOf("red"), weblogic.utils.StringUtils.valueOf(red
                        )},{ weblogic.utils.StringUtils.valueOf("yellow"), weblogic.utils.StringUtils.valueOf(yellow
                        )},{ weblogic.utils.StringUtils.valueOf("green"), weblogic.utils.StringUtils.valueOf(green
                        )},{ weblogic.utils.StringUtils.valueOf("prioritynewdisabled"), weblogic.utils.StringUtils.valueOf(prioritynewdisabled
                        )},{ weblogic.utils.StringUtils.valueOf("priority_zone_code"), weblogic.utils.StringUtils.valueOf(priority_zone_code
                        )},{ weblogic.utils.StringUtils.valueOf("priority_zone_desc"), weblogic.utils.StringUtils.valueOf(priority_zone_desc
                        )},{ weblogic.utils.StringUtils.valueOf("priority_zone_order"), weblogic.utils.StringUtils.valueOf(priority_zone_order
                        )},{ weblogic.utils.StringUtils.valueOf("priority_zone_color"), weblogic.utils.StringUtils.valueOf(priority_zone_color
                        )},{ weblogic.utils.StringUtils.valueOf("priority_zone_hidden_fileds"), weblogic.utils.StringUtils.valueOf(priority_zone_hidden_fileds
                        )},{ weblogic.utils.StringUtils.valueOf("priority_selected"), weblogic.utils.StringUtils.valueOf(priority_selected
                        )},{ weblogic.utils.StringUtils.valueOf("priority_no"), weblogic.utils.StringUtils.valueOf(priority_no
                        )},{ weblogic.utils.StringUtils.valueOf("dis_regn_ref"), weblogic.utils.StringUtils.valueOf(dis_regn_ref
                        )},{ weblogic.utils.StringUtils.valueOf("disaster_category_yn"), weblogic.utils.StringUtils.valueOf(disaster_category_yn
                        )},{ weblogic.utils.StringUtils.valueOf("disaster_type_code"), weblogic.utils.StringUtils.valueOf(disaster_type_code
                        )},{ weblogic.utils.StringUtils.valueOf("sqlAmbulatory"), weblogic.utils.StringUtils.valueOf(sqlAmbulatory
                        )},{ weblogic.utils.StringUtils.valueOf("AmbulatorySql"), weblogic.utils.StringUtils.valueOf(AmbulatorySql
                        )},{ weblogic.utils.StringUtils.valueOf("modify_flag"), weblogic.utils.StringUtils.valueOf(modify_flag
                        )},{ weblogic.utils.StringUtils.valueOf("modifyYN"), weblogic.utils.StringUtils.valueOf(modifyYN
                        )},{ weblogic.utils.StringUtils.valueOf("dis_area"), weblogic.utils.StringUtils.valueOf(dis_area
                        )},{ weblogic.utils.StringUtils.valueOf("display_triage_record_date_time"), weblogic.utils.StringUtils.valueOf(display_triage_record_date_time
                        )},{ weblogic.utils.StringUtils.valueOf("encounter_id"), weblogic.utils.StringUtils.valueOf(encounter_id
                        )},{ weblogic.utils.StringUtils.valueOf("locale"), weblogic.utils.StringUtils.valueOf(locale
                        )},{ weblogic.utils.StringUtils.valueOf("priority_code"), weblogic.utils.StringUtils.valueOf(priority_code
                        )},{ weblogic.utils.StringUtils.valueOf("queue_appl_priority_zone"), weblogic.utils.StringUtils.valueOf(queue_appl_priority_zone
                        )},{ weblogic.utils.StringUtils.valueOf("queue_max_num_allowed"), weblogic.utils.StringUtils.valueOf(queue_max_num_allowed
                        )},{ weblogic.utils.StringUtils.valueOf("queue_no"), weblogic.utils.StringUtils.valueOf(queue_no
                        )},{ weblogic.utils.StringUtils.valueOf("dis_queue_no"), weblogic.utils.StringUtils.valueOf(dis_queue_no
                        )},{ weblogic.utils.StringUtils.valueOf("queue_num_mandatory"), weblogic.utils.StringUtils.valueOf(queue_num_mandatory
                        )},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("clinic_code"), weblogic.utils.StringUtils.valueOf(clinic_code
                        )},{ weblogic.utils.StringUtils.valueOf("patient_gender"), weblogic.utils.StringUtils.valueOf(patient_gender
                        )},{ weblogic.utils.StringUtils.valueOf("treat_code"), weblogic.utils.StringUtils.valueOf(treat_code
                        )},{ weblogic.utils.StringUtils.valueOf("optSelectedTreat"), weblogic.utils.StringUtils.valueOf(optSelectedTreat
                        )},{ weblogic.utils.StringUtils.valueOf("disTreatArea"), weblogic.utils.StringUtils.valueOf(disTreatArea
                        )},{ weblogic.utils.StringUtils.valueOf("bed_no"), weblogic.utils.StringUtils.valueOf(bed_no
                        )},{ weblogic.utils.StringUtils.valueOf("disBed"), weblogic.utils.StringUtils.valueOf(disBed
                        )},{ weblogic.utils.StringUtils.valueOf("bedBed1"), weblogic.utils.StringUtils.valueOf(disBed1
                        )},{ weblogic.utils.StringUtils.valueOf("checked1"), weblogic.utils.StringUtils.valueOf(checked1
                        )},{ weblogic.utils.StringUtils.valueOf("checked2"), weblogic.utils.StringUtils.valueOf(checked2
                        )},{ weblogic.utils.StringUtils.valueOf("checked3"), weblogic.utils.StringUtils.valueOf(checked3
                        )},{ weblogic.utils.StringUtils.valueOf("checked5"), weblogic.utils.StringUtils.valueOf(checked5
                        )},{ weblogic.utils.StringUtils.valueOf("checked6"), weblogic.utils.StringUtils.valueOf(checked6
                        )},{ weblogic.utils.StringUtils.valueOf("checked7"), weblogic.utils.StringUtils.valueOf(checked7
                        )},{ weblogic.utils.StringUtils.valueOf("checked9"), weblogic.utils.StringUtils.valueOf(checked9
                        )},{ weblogic.utils.StringUtils.valueOf("disDisaster"), weblogic.utils.StringUtils.valueOf(disDisaster
                        )},{ weblogic.utils.StringUtils.valueOf("visit_date"), weblogic.utils.StringUtils.valueOf(visit_date
                        )},{ weblogic.utils.StringUtils.valueOf("dis1"), weblogic.utils.StringUtils.valueOf(dis1
                        )},{ weblogic.utils.StringUtils.valueOf("dis2"), weblogic.utils.StringUtils.valueOf(dis2
                        )},{ weblogic.utils.StringUtils.valueOf("dis3"), weblogic.utils.StringUtils.valueOf(dis3
                        )},{ weblogic.utils.StringUtils.valueOf("dis5"), weblogic.utils.StringUtils.valueOf(dis5
                        )},{ weblogic.utils.StringUtils.valueOf("dis7"), weblogic.utils.StringUtils.valueOf(dis7
                        )},{ weblogic.utils.StringUtils.valueOf("dis16"), weblogic.utils.StringUtils.valueOf(dis16
                        )},{ weblogic.utils.StringUtils.valueOf("disMed"), weblogic.utils.StringUtils.valueOf(disMed
                        )},{ weblogic.utils.StringUtils.valueOf("disMLC"), weblogic.utils.StringUtils.valueOf(disMLC
                        )},{ weblogic.utils.StringUtils.valueOf("disSur"), weblogic.utils.StringUtils.valueOf(disSur
                        )},{ weblogic.utils.StringUtils.valueOf("disOandGYn"), weblogic.utils.StringUtils.valueOf(disOandGYn
                        )},{ weblogic.utils.StringUtils.valueOf("disOscc"), weblogic.utils.StringUtils.valueOf(disOscc
                        )},{ weblogic.utils.StringUtils.valueOf("disable3"), weblogic.utils.StringUtils.valueOf(disable3
                        )},{ weblogic.utils.StringUtils.valueOf("a_status"), weblogic.utils.StringUtils.valueOf(a_status
                        )},{ weblogic.utils.StringUtils.valueOf("leveloftriage_visibility"), weblogic.utils.StringUtils.valueOf(leveloftriage_visibility
                        )},{ weblogic.utils.StringUtils.valueOf("attend_practitioner_name"), weblogic.utils.StringUtils.valueOf(attend_practitioner_name
                        )},{ weblogic.utils.StringUtils.valueOf("attend_practitioner_id"), weblogic.utils.StringUtils.valueOf(attend_practitioner_id
                        )},{ weblogic.utils.StringUtils.valueOf("transport_mode_code"), weblogic.utils.StringUtils.valueOf(transport_mode_code
                        )},{ weblogic.utils.StringUtils.valueOf("accompanied_by_code"), weblogic.utils.StringUtils.valueOf(accompanied_by_code
                        )},{ weblogic.utils.StringUtils.valueOf("accompanied_by_dis"), weblogic.utils.StringUtils.valueOf(accompanied_by_dis
                        )},{ weblogic.utils.StringUtils.valueOf("pat_dtls_unknown_yn"), weblogic.utils.StringUtils.valueOf(pat_dtls_unknown_yn
                        )},{ weblogic.utils.StringUtils.valueOf("referral_id"), weblogic.utils.StringUtils.valueOf(referral_id
                        )},{ weblogic.utils.StringUtils.valueOf("disRefID"), weblogic.utils.StringUtils.valueOf(disRefID
                        )},{ weblogic.utils.StringUtils.valueOf("complaint"), weblogic.utils.StringUtils.valueOf(complaint
                        )},{ weblogic.utils.StringUtils.valueOf("triage_remarks"), weblogic.utils.StringUtils.valueOf(triage_remarks
                        )},{ weblogic.utils.StringUtils.valueOf("checkedMed"), weblogic.utils.StringUtils.valueOf(checkedMed
                        )},{ weblogic.utils.StringUtils.valueOf("checkedSur"), weblogic.utils.StringUtils.valueOf(checkedSur
                        )},{ weblogic.utils.StringUtils.valueOf("checkedOandGYn"), weblogic.utils.StringUtils.valueOf(checkedOandGYn
                        )},{ weblogic.utils.StringUtils.valueOf("oscc_yn"), weblogic.utils.StringUtils.valueOf(oscc_yn
                        )},{ weblogic.utils.StringUtils.valueOf("medical_yn"), weblogic.utils.StringUtils.valueOf(medical_yn
                        )},{ weblogic.utils.StringUtils.valueOf("surgical_yn"), weblogic.utils.StringUtils.valueOf(surgical_yn
                        )},{ weblogic.utils.StringUtils.valueOf("queue_secondary_triage"), weblogic.utils.StringUtils.valueOf(queue_secondary_triage
                        )},{ weblogic.utils.StringUtils.valueOf("disaster_category_code"), weblogic.utils.StringUtils.valueOf(disaster_category_code
                        )},{ weblogic.utils.StringUtils.valueOf("disaster_category_yn"), weblogic.utils.StringUtils.valueOf(disaster_category_yn
                        )},{ weblogic.utils.StringUtils.valueOf("called_from_ca"), weblogic.utils.StringUtils.valueOf(called_from_ca
                        )},{ weblogic.utils.StringUtils.valueOf("caseType"), weblogic.utils.StringUtils.valueOf(caseType
                        )},{ weblogic.utils.StringUtils.valueOf("caseTypeDisable"), weblogic.utils.StringUtils.valueOf(caseTypeDisable
                        )},{ weblogic.utils.StringUtils.valueOf("caseTypeMandYn"), weblogic.utils.StringUtils.valueOf(caseTypeMandYn
                        )},{ weblogic.utils.StringUtils.valueOf("caseTypeYn"), weblogic.utils.StringUtils.valueOf(caseTypeYn
                        )},{ weblogic.utils.StringUtils.valueOf("date_time_of_accident"), weblogic.utils.StringUtils.valueOf(date_time_of_accident
                        )},{ weblogic.utils.StringUtils.valueOf("localeName"), weblogic.utils.StringUtils.valueOf(localeName
                        )},{ weblogic.utils.StringUtils.valueOf("disDateAcci"), weblogic.utils.StringUtils.valueOf(disDateAcci
                        )},{ weblogic.utils.StringUtils.valueOf("place_of_accident"), weblogic.utils.StringUtils.valueOf(place_of_accident
                        )},{ weblogic.utils.StringUtils.valueOf("disPlaceAcci"), weblogic.utils.StringUtils.valueOf(disPlaceAcci
                        )},{ weblogic.utils.StringUtils.valueOf("dis6"), weblogic.utils.StringUtils.valueOf(dis6
                        )},{ weblogic.utils.StringUtils.valueOf("dis8"), weblogic.utils.StringUtils.valueOf(dis8
                        )},{ weblogic.utils.StringUtils.valueOf("dis9"), weblogic.utils.StringUtils.valueOf(dis9
                        )},{ weblogic.utils.StringUtils.valueOf("dis10"), weblogic.utils.StringUtils.valueOf(dis10
                        )},{ weblogic.utils.StringUtils.valueOf("dis11"), weblogic.utils.StringUtils.valueOf(dis11
                        )},{ weblogic.utils.StringUtils.valueOf("dis12"), weblogic.utils.StringUtils.valueOf(dis12
                        )},{ weblogic.utils.StringUtils.valueOf("dis13"), weblogic.utils.StringUtils.valueOf(dis13
                        )},{ weblogic.utils.StringUtils.valueOf("mech_injury_subcatg_code"), weblogic.utils.StringUtils.valueOf(mech_injury_subcatg_code
                        )},{ weblogic.utils.StringUtils.valueOf("vehicle_invlovedcode"), weblogic.utils.StringUtils.valueOf(vehicle_invlovedcode
                        )},{ weblogic.utils.StringUtils.valueOf("Vehicle_Reg_No1"), weblogic.utils.StringUtils.valueOf(Vehicle_Reg_No1
                        )},{ weblogic.utils.StringUtils.valueOf("protective_device_code"), weblogic.utils.StringUtils.valueOf(protective_device_code
                        )},{ weblogic.utils.StringUtils.valueOf("pat_position_code"), weblogic.utils.StringUtils.valueOf(pat_position_code
                        )},{ weblogic.utils.StringUtils.valueOf("MLC_DEATH_YN"), weblogic.utils.StringUtils.valueOf(MLC_DEATH_YN
                        )},{ weblogic.utils.StringUtils.valueOf("disMLCDeath"), weblogic.utils.StringUtils.valueOf(disMLCDeath
                        )},{ weblogic.utils.StringUtils.valueOf("pol_rep_no_mx_size"), weblogic.utils.StringUtils.valueOf(pol_rep_no_mx_size
                        )},{ weblogic.utils.StringUtils.valueOf("pol_stn_det_mx_size"), weblogic.utils.StringUtils.valueOf(pol_stn_det_mx_size
                        )},{ weblogic.utils.StringUtils.valueOf("police_station_dtls"), weblogic.utils.StringUtils.valueOf(police_station_dtls
                        )},{ weblogic.utils.StringUtils.valueOf("police_rep_no"), weblogic.utils.StringUtils.valueOf(police_rep_no
                        )},{ weblogic.utils.StringUtils.valueOf("MLC_NO_OUTSIDE_DTLS"), weblogic.utils.StringUtils.valueOf(MLC_NO_OUTSIDE_DTLS
                        )},{ weblogic.utils.StringUtils.valueOf("disOutMLCDet"), weblogic.utils.StringUtils.valueOf(disOutMLCDet
                        )},{ weblogic.utils.StringUtils.valueOf("MLC_CAPTURE_DATE"), weblogic.utils.StringUtils.valueOf(MLC_CAPTURE_DATE
                        )},{ weblogic.utils.StringUtils.valueOf("disDateOfCapt"), weblogic.utils.StringUtils.valueOf(disDateOfCapt
                        )},{ weblogic.utils.StringUtils.valueOf("disMLCRemark"), weblogic.utils.StringUtils.valueOf(disMLCRemark
                        )},{ weblogic.utils.StringUtils.valueOf("MLC_REMARKS"), weblogic.utils.StringUtils.valueOf(MLC_REMARKS
                        )},{ weblogic.utils.StringUtils.valueOf("initialMgmtLblName"), weblogic.utils.StringUtils.valueOf(initialMgmtLblName
                        )},{ weblogic.utils.StringUtils.valueOf("order_catalog_code1"), weblogic.utils.StringUtils.valueOf(order_catalog_code1
                        )},{ weblogic.utils.StringUtils.valueOf("order_catalog_code2"), weblogic.utils.StringUtils.valueOf(order_catalog_code2
                        )},{ weblogic.utils.StringUtils.valueOf("order_catalog_code3"), weblogic.utils.StringUtils.valueOf(order_catalog_code3
                        )},{ weblogic.utils.StringUtils.valueOf("order_catalog_code4"), weblogic.utils.StringUtils.valueOf(order_catalog_code4
                        )},{ weblogic.utils.StringUtils.valueOf("order_catalog_code5"), weblogic.utils.StringUtils.valueOf(order_catalog_code5
                        )},{ weblogic.utils.StringUtils.valueOf("order_catalog_code6"), weblogic.utils.StringUtils.valueOf(order_catalog_code6
                        )},{ weblogic.utils.StringUtils.valueOf("FBCProp"), weblogic.utils.StringUtils.valueOf(FBCProp
                        )},{ weblogic.utils.StringUtils.valueOf("ECGProp"), weblogic.utils.StringUtils.valueOf(ECGProp
                        )},{ weblogic.utils.StringUtils.valueOf("DressProp"), weblogic.utils.StringUtils.valueOf(DressProp
                        )},{ weblogic.utils.StringUtils.valueOf("SpO2Prop"), weblogic.utils.StringUtils.valueOf(SpO2Prop
                        )},{ weblogic.utils.StringUtils.valueOf("dressingLblName"), weblogic.utils.StringUtils.valueOf(dressingLblName
                        )},{ weblogic.utils.StringUtils.valueOf("intialMgmtOthers"), weblogic.utils.StringUtils.valueOf(intialMgmtOthers
                        )},{ weblogic.utils.StringUtils.valueOf("disIntialMgmtOthers"), weblogic.utils.StringUtils.valueOf(disIntialMgmtOthers
                        )},{ weblogic.utils.StringUtils.valueOf("disImmobil"), weblogic.utils.StringUtils.valueOf(disImmobil
                        )},{ weblogic.utils.StringUtils.valueOf("immobilization"), weblogic.utils.StringUtils.valueOf(immobilization
                        )},{ weblogic.utils.StringUtils.valueOf("dis14"), weblogic.utils.StringUtils.valueOf(dis14
                        )},{ weblogic.utils.StringUtils.valueOf("dis15"), weblogic.utils.StringUtils.valueOf(dis15
                        )},{ weblogic.utils.StringUtils.valueOf("selected"), weblogic.utils.StringUtils.valueOf(selected
                        )},{ weblogic.utils.StringUtils.valueOf("selected1"), weblogic.utils.StringUtils.valueOf(selected1
                        )},{ weblogic.utils.StringUtils.valueOf("selected2"), weblogic.utils.StringUtils.valueOf(selected2
                        )},{ weblogic.utils.StringUtils.valueOf("checked4"), weblogic.utils.StringUtils.valueOf(checked4
                        )},{ weblogic.utils.StringUtils.valueOf("checked8"), weblogic.utils.StringUtils.valueOf(checked8
                        )},{ weblogic.utils.StringUtils.valueOf("patient_age"), weblogic.utils.StringUtils.valueOf(patient_age
                        )},{ weblogic.utils.StringUtils.valueOf("max_age_paediatric"), weblogic.utils.StringUtils.valueOf(max_age_paediatric
                        )},{ weblogic.utils.StringUtils.valueOf("min_age_pregnancy"), weblogic.utils.StringUtils.valueOf(min_age_pregnancy
                        )},{ weblogic.utils.StringUtils.valueOf("sex"), weblogic.utils.StringUtils.valueOf(sex
                        )},{ weblogic.utils.StringUtils.valueOf("pediatric_status"), weblogic.utils.StringUtils.valueOf(pediatric_status
                        )},{ weblogic.utils.StringUtils.valueOf("disabled991"), weblogic.utils.StringUtils.valueOf(disabled991
                        )},{ weblogic.utils.StringUtils.valueOf("disImm"), weblogic.utils.StringUtils.valueOf(disImm
                        )},{ weblogic.utils.StringUtils.valueOf("disMenarche"), weblogic.utils.StringUtils.valueOf(disMenarche
                        )},{ weblogic.utils.StringUtils.valueOf("disHeight"), weblogic.utils.StringUtils.valueOf(disHeight
                        )},{ weblogic.utils.StringUtils.valueOf("disWeight"), weblogic.utils.StringUtils.valueOf(disWeight
                        )},{ weblogic.utils.StringUtils.valueOf("height"), weblogic.utils.StringUtils.valueOf(height
                        )},{ weblogic.utils.StringUtils.valueOf("weight"), weblogic.utils.StringUtils.valueOf(weight
                        )},{ weblogic.utils.StringUtils.valueOf("circumference"), weblogic.utils.StringUtils.valueOf(circumference
                        )},{ weblogic.utils.StringUtils.valueOf("capBloodSugProp"), weblogic.utils.StringUtils.valueOf(capBloodSugProp
                        )},{ weblogic.utils.StringUtils.valueOf("cbdProp"), weblogic.utils.StringUtils.valueOf(cbdProp
                        )},{ weblogic.utils.StringUtils.valueOf("medication"), weblogic.utils.StringUtils.valueOf(medication
                        )},{ weblogic.utils.StringUtils.valueOf("disMedication"), weblogic.utils.StringUtils.valueOf(disMedication
                        )},{ weblogic.utils.StringUtils.valueOf("capBloodSugProp"), weblogic.utils.StringUtils.valueOf(capBloodSugProp
                        )},{ weblogic.utils.StringUtils.valueOf("fbccheck"), weblogic.utils.StringUtils.valueOf(fbccheck
                        )},{ weblogic.utils.StringUtils.valueOf("fbccheck_val"), weblogic.utils.StringUtils.valueOf(fbccheck_val
                        )},{ weblogic.utils.StringUtils.valueOf("disCir"), weblogic.utils.StringUtils.valueOf(disCir
                        )},{ weblogic.utils.StringUtils.valueOf("disabled"), weblogic.utils.StringUtils.valueOf(disabled
                        )},{ weblogic.utils.StringUtils.valueOf("menstrual_status"), weblogic.utils.StringUtils.valueOf(menstrual_status
                        )},{ weblogic.utils.StringUtils.valueOf("disabledPre"), weblogic.utils.StringUtils.valueOf(disabledPre
                        )},{ weblogic.utils.StringUtils.valueOf("min_age_for_lmp"), weblogic.utils.StringUtils.valueOf(min_age_for_lmp
                        )},{ weblogic.utils.StringUtils.valueOf("year_value"), weblogic.utils.StringUtils.valueOf(year_value
                        )},{ weblogic.utils.StringUtils.valueOf("minageforlmp"), weblogic.utils.StringUtils.valueOf(minageforlmp
                        )},{ weblogic.utils.StringUtils.valueOf("lmp_date"), weblogic.utils.StringUtils.valueOf(lmp_date
                        )},{ weblogic.utils.StringUtils.valueOf("clinical_notes_status"), weblogic.utils.StringUtils.valueOf(clinical_notes_status
                        )},{ weblogic.utils.StringUtils.valueOf("episode_id"), weblogic.utils.StringUtils.valueOf(episode_id
                        )},{ weblogic.utils.StringUtils.valueOf("patient_class"), weblogic.utils.StringUtils.valueOf(patient_class
                        )},{ weblogic.utils.StringUtils.valueOf("loginUser"), weblogic.utils.StringUtils.valueOf(loginUser
                        )},{ weblogic.utils.StringUtils.valueOf("ca_chart_rec_status"), weblogic.utils.StringUtils.valueOf(ca_chart_rec_status
                        )},{ weblogic.utils.StringUtils.valueOf("sys_date_qry"), weblogic.utils.StringUtils.valueOf(sys_date_qry
                        )},{ weblogic.utils.StringUtils.valueOf("sqlPosition"), weblogic.utils.StringUtils.valueOf(sqlPosition
                        )},{ weblogic.utils.StringUtils.valueOf("Vehicle_Reg_No2"), weblogic.utils.StringUtils.valueOf(Vehicle_Reg_No2
                        )},{ weblogic.utils.StringUtils.valueOf("vehicle_invlovedcode1"), weblogic.utils.StringUtils.valueOf(vehicle_invlovedcode1
                        )},{ weblogic.utils.StringUtils.valueOf("mech_injr_code"), weblogic.utils.StringUtils.valueOf(mech_injr_code
                        )},{ weblogic.utils.StringUtils.valueOf("PositionSql"), weblogic.utils.StringUtils.valueOf(PositionSql
                        )},{ weblogic.utils.StringUtils.valueOf("invokeMenstrualHistYN"), weblogic.utils.StringUtils.valueOf(invokeMenstrualHistYN
                        )},{ weblogic.utils.StringUtils.valueOf("latestMensDtlStatus"), weblogic.utils.StringUtils.valueOf(latestMensDtlStatus
                        )},{ weblogic.utils.StringUtils.valueOf("rec_view_lmp_details_label"), weblogic.utils.StringUtils.valueOf(rec_view_lmp_details_label
                        )},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("MensdisabledPre"), weblogic.utils.StringUtils.valueOf(MensdisabledPre
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block2Bytes, _wl_block2);
}
else
 {

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
if(isSecTrgBackDateTimeAppl){
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(display_triage_record_date_time.equals("")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(display_triage_record_date_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block44Bytes, _wl_block44);
 } 
            _bw.write(_wl_block45Bytes, _wl_block45);
}else if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block50Bytes, _wl_block50);
 } 
            _bw.write(_wl_block51Bytes, _wl_block51);

	
			String secTrgRecDateTimeList=eAE.AECommonBean.getAETrgRecDateTime(con,facilityId,encounter_id,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	 	
	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(secTrgRecDateTimeList));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sqlDate));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		if(!five_level_triage_appl_yn.equals("Y")){
            _bw.write(_wl_block58Bytes, _wl_block58);

		  
		  if(isPriorityZoneAppl){
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disPriority));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

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
						
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(!five_level_triage_appl_yn.equals("Y")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(red));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(priorityStatus1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled111));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(yellow));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(priorityStatus2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled12));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(green));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(priorityStatus3));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(disabled13));
            _bw.write(_wl_block71Bytes, _wl_block71);
}else{
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(prioritynewdisabled));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
 
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
				
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(priority_selected));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
if(prioritynewdisabled.equals("")){ 
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);

		 if(rset1!=null) rset1.close();
		 if(pstmt1!=null) pstmt1.close();
	    	
	    } 
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(disPriority));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

					   
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
					   
            _bw.write(_wl_block88Bytes, _wl_block88);

		             //System.out.println(isSecondaryTriageQueueNum + " isSecondaryTriageQueueNum ");
		             if(priority.equals(queue_appl_priority_zone)){
		            	 dis_queue_no = " ";
		             }
		             if(isSecondaryTriageQueueNum && queue_secondary_triage.equals("Y")){ 
            _bw.write(_wl_block89Bytes, _wl_block89);
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(queue_no ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(dis_queue_no ));
            _bw.write(_wl_block93Bytes, _wl_block93);
 
		             String queue_no_mand_img_dis = " disabled ";
					 if(queue_num_mandatory.equals("Y") && !modify_flag.equals("Y") && !priority.equals("U")){ 
						 queue_no_mand_img_dis = " ";
					 }
            _bw.write(_wl_block94Bytes, _wl_block94);

		             
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
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
 }
		             
		             
		             } 
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block99Bytes, _wl_block99);

			     
		        
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
				 
			   
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(disTreatArea));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(sbBuff.toString()));
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(disBed));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(disBed1));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(checked1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disDisaster));
            _bw.write(_wl_block110Bytes, _wl_block110);

			 if(allowSplChar)
			 {
			 
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(dis_regn_ref));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block114Bytes, _wl_block114);

			 }
			 else
			 {
			 
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(dis_regn_ref));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block118Bytes, _wl_block118);

			 }
			 
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(dis_area));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block124Bytes, _wl_block124);
if(disaster_category_yn.equals("Y")){ 
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

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
				
			
            _bw.write(_wl_block129Bytes, _wl_block129);
} 
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
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
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(visit_date));
            _bw.write(_wl_block134Bytes, _wl_block134);
if(modify_flag.equals("Y")) { 
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

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

					   
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(attend_practitioner_name));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block148Bytes, _wl_block148);

		     }
			 if(modify_flag.equals("N")) {
		     
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

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
					   
            _bw.write(_wl_block153Bytes, _wl_block153);
}
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(attend_practitioner_name));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block157Bytes, _wl_block157);
if(modeofarrival){
		  
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
  
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
	            
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(accompanied_by_dis));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
  
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
	             
            _bw.write(_wl_block166Bytes, _wl_block166);
}
            _bw.write(_wl_block167Bytes, _wl_block167);
if(modeofarrival && modify_flag.equals("N")){
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");
                   pstmtTrans = con.prepareStatement(sqlAMTrans.toString());
					
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next())
					 {
					out.println("<option value='"+rsetTrans.getString(1)+"'>"+rsetTrans.getString(2)+""); 
					 }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");
				   pstmtAccom = con.prepareStatement(sqlAMEsc.toString());
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next())
					 {
					out.println("<option value='"+rsetAccom.getString(1)+"'>"+rsetAccom.getString(2)+""); 
					 }
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             
            _bw.write(_wl_block166Bytes, _wl_block166);
}
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
if(pat_dtls_unknown_yn.equals("N")){
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(disRefID));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(disRefID));
            _bw.write(_wl_block175Bytes, _wl_block175);
}else if(pat_dtls_unknown_yn.equals("Y")) {
            _bw.write(_wl_block176Bytes, _wl_block176);
}
            _bw.write(_wl_block177Bytes, _wl_block177);
if(!isReplacePresntngPrblmByChiefComp){ 
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(complaint));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block183Bytes, _wl_block183);
}else{
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")));
            _bw.write(_wl_block185Bytes, _wl_block185);
}
            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(dis2));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(triage_remarks));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(checked9));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(disOscc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);

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
											
						
            _bw.write(_wl_block201Bytes, _wl_block201);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(checkedMed));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disMed));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(checkedSur));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disSur));
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(checkedOandGYn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disOandGYn));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block212Bytes, _wl_block212);
 }else{ 
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(checked9));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(disOscc));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable3));
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(checkedMed));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disMed));
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(checkedSur));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disSur));
            _bw.write(_wl_block227Bytes, _wl_block227);
 } 
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(called_from_ca));
            _bw.write(_wl_block230Bytes, _wl_block230);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block231Bytes, _wl_block231);
 } 
            _bw.write(_wl_block232Bytes, _wl_block232);
if(isPlaceOfOccuurrence == true){
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
}else{
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
}
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(disDateAcci));
            _bw.write(_wl_block239Bytes, _wl_block239);
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(disDateAcci));
            _bw.write(_wl_block241Bytes, _wl_block241);
if(isLabelChngAppl == true){ 
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
}
			  else if(isPlaceOfOccuurrence == true){
			  
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);

			  }
			  else{
				
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
} 
            _bw.write(_wl_block248Bytes, _wl_block248);
if(isPlaceOfOccuurrence == false){
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(place_of_accident));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(disPlaceAcci));
            _bw.write(_wl_block175Bytes, _wl_block175);
}
			else{	
			
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(disPlaceAcci));
            _bw.write(_wl_block253Bytes, _wl_block253);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);
  
                  try 
				  {	
				   PreparedStatement pstmtTrans1 = null;
				   ResultSet rsetTrans1 = null;
                   //pstmtTrans1 = con.prepareStatement("select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE where  eff_status='E' order by short_desc");
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
	            
            _bw.write(_wl_block255Bytes, _wl_block255);
}
            _bw.write(_wl_block256Bytes, _wl_block256);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block257Bytes, _wl_block257);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block258Bytes, _wl_block258);
 }else{ 
            _bw.write(_wl_block259Bytes, _wl_block259);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block258Bytes, _wl_block258);
 } 
            _bw.write(_wl_block260Bytes, _wl_block260);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block262Bytes, _wl_block262);
 }else{ 
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block262Bytes, _wl_block262);
 } 
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(dis6));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

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
					   
            _bw.write(_wl_block266Bytes, _wl_block266);
 if(!isMechInjLabelChngAppl){ 
            _bw.write(_wl_block267Bytes, _wl_block267);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
 } 
            _bw.write(_wl_block269Bytes, _wl_block269);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
 } 
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(mech_injury_subcatg_code));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block275Bytes, _wl_block275);
 } 
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block279Bytes, _wl_block279);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

						 StringBuffer sqlVehicleInv = new StringBuffer();
						// sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"'  order by 2");

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
					   
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(dis9));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);

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
					   
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(Vehicle_Reg_No1));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block287Bytes, _wl_block287);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(Vehicle_Reg_No2));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block289Bytes, _wl_block289);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(dis10));
            _bw.write(_wl_block291Bytes, _wl_block291);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block292Bytes, _wl_block292);

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
			   
            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(dis11));
            _bw.write(_wl_block291Bytes, _wl_block291);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

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
					   
            _bw.write(_wl_block296Bytes, _wl_block296);
if(siteSpecific){
            _bw.write(_wl_block297Bytes, _wl_block297);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);
}else {
            _bw.write(_wl_block299Bytes, _wl_block299);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
}
            _bw.write(_wl_block300Bytes, _wl_block300);
if(siteSpecific){
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block301Bytes, _wl_block301);
}else{
            _bw.write(_wl_block302Bytes, _wl_block302);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block303Bytes, _wl_block303);
}
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(checked3));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(disMLC));
            _bw.write(_wl_block307Bytes, _wl_block307);
 if(isMLCAppl){ 
            _bw.write(_wl_block308Bytes, _wl_block308);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(MLC_DEATH_YN ));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(disMLCDeath ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(MLC_DEATH_YN.equals("Y")?" Checked ":"" ));
            _bw.write(_wl_block311Bytes, _wl_block311);
}else{ 
            _bw.write(_wl_block312Bytes, _wl_block312);
 }
            _bw.write(_wl_block313Bytes, _wl_block313);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(pol_rep_no_mx_size ));
            _bw.write(_wl_block106Bytes, _wl_block106);
 if(isMLCAppl){ 
            _bw.write(_wl_block315Bytes, _wl_block315);
} 
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(police_rep_no));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(dis12));
            _bw.write(_wl_block318Bytes, _wl_block318);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(pol_stn_det_mx_size ));
            _bw.write(_wl_block106Bytes, _wl_block106);
 if(isMLCAppl){ 
            _bw.write(_wl_block315Bytes, _wl_block315);
} 
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(police_station_dtls));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(dis13));
            _bw.write(_wl_block322Bytes, _wl_block322);
 if(isMLCAppl){ 
            _bw.write(_wl_block323Bytes, _wl_block323);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(MLC_NO_OUTSIDE_DTLS ));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(disOutMLCDet ));
            _bw.write(_wl_block326Bytes, _wl_block326);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(MLC_CAPTURE_DATE ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(disDateOfCapt ));
            _bw.write(_wl_block328Bytes, _wl_block328);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(disMLCRemark ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(MLC_REMARKS));
            _bw.write(_wl_block330Bytes, _wl_block330);
} 
            _bw.write(_wl_block331Bytes, _wl_block331);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block332Bytes, _wl_block332);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block333Bytes, _wl_block333);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
if(isSecTrgBackDateTimeAppl){
            _bw.write(_wl_block334Bytes, _wl_block334);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(display_triage_record_date_time.equals("")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block336Bytes, _wl_block336);
}else {
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(display_triage_record_date_time));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(dis_triage_record_date_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block44Bytes, _wl_block44);
 } 
            _bw.write(_wl_block45Bytes, _wl_block45);
}else if(isChngBtnPositionAppl){ 
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(VisitProp));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block50Bytes, _wl_block50);
 } 
            _bw.write(_wl_block340Bytes, _wl_block340);
 if(isOrderCatalogChngAppl && !initialMgmtLblName.trim().equals("")){ 
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(initialMgmtLblName));
            _bw.write(_wl_block234Bytes, _wl_block234);
 }else{ 
            _bw.write(_wl_block342Bytes, _wl_block342);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
 } 
            _bw.write(_wl_block343Bytes, _wl_block343);
if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				   StringBuffer sqlOrderCatalog6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				//   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b, ae_param ##REPDB## c where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
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
				/*   s1.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE2");
				   s3.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE4");
				   s4.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE1");
				   s5.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE5");
				   s6.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE6");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   */
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
				  

  
            _bw.write(_wl_block344Bytes, _wl_block344);
 if(isOrderCatalogChngAppl){ 
            _bw.write(_wl_block345Bytes, _wl_block345);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(cbdProp));
            _bw.write(_wl_block348Bytes, _wl_block348);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(medication));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(disMedication));
            _bw.write(_wl_block351Bytes, _wl_block351);
 }else{ 
            _bw.write(_wl_block352Bytes, _wl_block352);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(capBloodSugProp));
            _bw.write(_wl_block354Bytes, _wl_block354);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(SpO2Prop));
            _bw.write(_wl_block356Bytes, _wl_block356);
 } 
            _bw.write(_wl_block357Bytes, _wl_block357);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(FBCProp));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fbccheck));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(fbccheck_val));
            _bw.write(_wl_block361Bytes, _wl_block361);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(ECGProp));
            _bw.write(_wl_block363Bytes, _wl_block363);
 if(isOrderCatalogChngAppl){ 
            _bw.write(_wl_block364Bytes, _wl_block364);
 if(!dressingLblName.trim().equals("")){ 
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(dressingLblName));
            _bw.write(_wl_block366Bytes, _wl_block366);
 }else{
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);
 } 
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(DressProp));
            _bw.write(_wl_block369Bytes, _wl_block369);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(intialMgmtOthers));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(disIntialMgmtOthers));
            _bw.write(_wl_block372Bytes, _wl_block372);
 }else{ 
            _bw.write(_wl_block373Bytes, _wl_block373);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(DressProp));
            _bw.write(_wl_block376Bytes, _wl_block376);
 } 
            _bw.write(_wl_block377Bytes, _wl_block377);
}
            _bw.write(_wl_block378Bytes, _wl_block378);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(disImmobil));
            _bw.write(_wl_block381Bytes, _wl_block381);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block382Bytes, _wl_block382);

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
                 
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(dis14));
            _bw.write(_wl_block386Bytes, _wl_block386);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block388Bytes, _wl_block388);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block390Bytes, _wl_block390);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block390Bytes, _wl_block390);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block392Bytes, _wl_block392);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(checked4));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis15));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(ca_install_yn));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(max_age_paediatric));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(min_age_pregnancy));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block397Bytes, _wl_block397);
 if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	
            _bw.write(_wl_block398Bytes, _wl_block398);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(checked5));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(disabled991));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled99));
            _bw.write(_wl_block403Bytes, _wl_block403);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(checked6));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disImm));
            _bw.write(_wl_block406Bytes, _wl_block406);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(checked7));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disMenarche));
            _bw.write(_wl_block409Bytes, _wl_block409);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(disHeight));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(height));
            _bw.write(_wl_block413Bytes, _wl_block413);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block414Bytes, _wl_block414);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(disWeight));
            _bw.write(_wl_block417Bytes, _wl_block417);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block418Bytes, _wl_block418);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(circumference));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(ca_install_yn));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(max_age_paediatric));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(min_age_pregnancy));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(disCir));
            _bw.write(_wl_block422Bytes, _wl_block422);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block423Bytes, _wl_block423);
 } else{
			
			  disabled="";
		 }
            _bw.write(_wl_block424Bytes, _wl_block424);

	

		if ((sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) || (sex.equalsIgnoreCase("F") && (patient_age >= Integer.parseInt(min_age_for_lmp))) ){
				 menstrual_status = "true"; 
            _bw.write(_wl_block425Bytes, _wl_block425);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block426Bytes, _wl_block426);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(checked8));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(disabledPre));
            _bw.write(_wl_block430Bytes, _wl_block430);

		
			 if((min_age_for_lmp!=null)&&(year_value!=null))
			 {
				minageforlmp=Integer.parseInt( min_age_for_lmp);
                yearvalue=Integer.parseInt( year_value);
              if(yearvalue>=minageforlmp)
				 {
				   
            _bw.write(_wl_block431Bytes, _wl_block431);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(DateUtils.convertDate(lmp_date,"DMY","en",localeName)));
            _bw.write(_wl_block433Bytes, _wl_block433);
}else{
            _bw.write(_wl_block434Bytes, _wl_block434);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(DateUtils.convertDate(lmp_date,"DMY","en",localeName)));
            _bw.write(_wl_block436Bytes, _wl_block436);
}}
            _bw.write(_wl_block437Bytes, _wl_block437);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block438Bytes, _wl_block438);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block439Bytes, _wl_block439);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block440Bytes, _wl_block440);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block441Bytes, _wl_block441);
  } 
            _bw.write(_wl_block442Bytes, _wl_block442);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block443Bytes, _wl_block443);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block444Bytes, _wl_block444);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block445Bytes, _wl_block445);
if(five_level_triage_appl_yn.equals("Y")){ 
            _bw.write(_wl_block446Bytes, _wl_block446);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block447Bytes, _wl_block447);
if(clinical_notes_status.equals("A")){
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block450Bytes, _wl_block450);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block451Bytes, _wl_block451);
}else{ 
            _bw.write(_wl_block452Bytes, _wl_block452);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block453Bytes, _wl_block453);
}
			  if(ca_chart_rec_status.equals("A")){
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(sys_date_qry));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block456Bytes, _wl_block456);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block451Bytes, _wl_block451);
}else{ 
            _bw.write(_wl_block457Bytes, _wl_block457);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block451Bytes, _wl_block451);
} 
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block459Bytes, _wl_block459);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block460Bytes, _wl_block460);
} 
            _bw.write(_wl_block461Bytes, _wl_block461);
}	
}
else
 {

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block462Bytes, _wl_block462);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(sqlDate));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block465Bytes, _wl_block465);

            if (_jsp__tag153(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block466Bytes, _wl_block466);
if(isPriorityZoneAppl){
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(disPriority));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag154(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block468Bytes, _wl_block468);

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
						
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(!five_level_triage_appl_yn.equals("Y")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(red));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(priorityStatus1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled111));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(yellow));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(priorityStatus2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled12));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(green));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(priorityStatus3));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(disabled13));
            _bw.write(_wl_block71Bytes, _wl_block71);
}else{
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(prioritynewdisabled));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag155(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
 
	    		String sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC,PRIORITY_ZONE_COLOR,PRIORITY_ZONE_ORDER FROM AE_PRIORITY_ZONE_LANG_VW ##REPDB## WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		       
				sql1 = sql1.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				pstmt   = con.prepareStatement(sql1.toString());
				pstmt.setString(1,locale) ;
				rset1    = pstmt.executeQuery();
				while(rset1!=null && rset1.next()){
					priority_zone_code	= rset1.getString("PRIORITY_ZONE");
					priority_zone_desc	= rset1.getString("PRIORITY_ZONE_DESC");
					priority_zone_order	=(rset1.getString("PRIORITY_ZONE_ORDER")==null || rset1.getString("PRIORITY_ZONE_ORDER")=="")?"":rset1.getString("PRIORITY_ZONE_ORDER");
					priority_zone_color = (rset1.getString("PRIORITY_ZONE_COLOR")==null || rset1.getString("PRIORITY_ZONE_COLOR")=="")?"":rset1.getString("PRIORITY_ZONE_COLOR");
					priority_zone_hidden_fileds	= priority_zone_hidden_fileds+"<input type='hidden' name='priority_zone_order_by_"+priority_zone_code+"' id='priority_zone_order_by_"+priority_zone_code+"' id='priority_zone_order_by_"+priority_zone_code+"' value='"+priority_zone_order+"'>";
					if(priority.equals(priority_zone_code)){
						priority_selected	= "selected";
						priority_no			= priority_zone_order;
					}else{
						priority_selected	= "";
					}
				
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(priority_selected));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block469Bytes, _wl_block469);
} 
            _bw.write(_wl_block470Bytes, _wl_block470);
}
            _bw.write(_wl_block471Bytes, _wl_block471);

            if (_jsp__tag156(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(disPriority));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag157(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

					   
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
					   
            _bw.write(_wl_block473Bytes, _wl_block473);

            if (_jsp__tag158(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block474Bytes, _wl_block474);

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
			   
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(disTreatArea));
            _bw.write(_wl_block475Bytes, _wl_block475);

            if (_jsp__tag159(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(sbBuff.toString()));
            _bw.write(_wl_block476Bytes, _wl_block476);

            if (_jsp__tag160(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(disBed));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(disBed1));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag161(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(checked1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disDisaster));
            _bw.write(_wl_block430Bytes, _wl_block430);

			 if(allowSplChar)
			 {
			 
            _bw.write(_wl_block479Bytes, _wl_block479);

            if (_jsp__tag162(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(dis_regn_ref));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block114Bytes, _wl_block114);

			 }
			 else
			 {
			
            _bw.write(_wl_block479Bytes, _wl_block479);

            if (_jsp__tag163(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(dis_regn_ref));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block114Bytes, _wl_block114);

			 }
			 
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag164(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(dis_area));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block483Bytes, _wl_block483);

            if (_jsp__tag165(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(disabled11));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag166(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
  
                  try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
                   //pstmtTrans = con.prepareStatement("select disaster_type_code, short_desc from ae_disaster_type_lang_vw  where language_id='"+locale+"'  and  eff_status='E' order by short_desc");
				   /*Above line commented and below code added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = "select disaster_type_code, short_desc from ae_disaster_type_lang_vw ##REPDB## where language_id='"+locale+"'  and  eff_status='E' order by short_desc";
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
	            
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(visit_date));
            _bw.write(_wl_block134Bytes, _wl_block134);
if(modify_flag.equals("Y")) { 
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag167(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag168(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

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

					   
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag169(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(leveloftriage_visibility));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(attend_practitioner_name));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(dis16));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block148Bytes, _wl_block148);

		     } if(modify_flag.equals("N")) {
		     
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag170(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block488Bytes, _wl_block488);

            if (_jsp__tag171(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

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
					   
            _bw.write(_wl_block153Bytes, _wl_block153);
}
            _bw.write(_wl_block489Bytes, _wl_block489);
if(modeofarrival){
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag172(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag173(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
  
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
	            
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag174(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag175(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(accompanied_by_dis));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag176(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
  
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
	             
            _bw.write(_wl_block166Bytes, _wl_block166);
}
            _bw.write(_wl_block490Bytes, _wl_block490);
if(modeofarrival && modify_flag.equals("N")){
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag177(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag178(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");
                   pstmtTrans = con.prepareStatement(sqlAMTrans.toString());
					
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next())
					 {
					out.println("<option value='"+rsetTrans.getString(1)+"'>"+rsetTrans.getString(2)+""); 
					 }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag179(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag180(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag181(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");
				   pstmtAccom = con.prepareStatement(sqlAMEsc.toString());
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next())
					 {
					out.println("<option value='"+rsetAccom.getString(1)+"'>"+rsetAccom.getString(2)+""); 
					 }
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             
            _bw.write(_wl_block166Bytes, _wl_block166);
}
            _bw.write(_wl_block491Bytes, _wl_block491);

            if (_jsp__tag182(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
if(pat_dtls_unknown_yn.equals("N")){
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(disRefID));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(disRefID));
            _bw.write(_wl_block175Bytes, _wl_block175);
}else if(pat_dtls_unknown_yn.equals("Y")) {
            _bw.write(_wl_block176Bytes, _wl_block176);
}
            _bw.write(_wl_block177Bytes, _wl_block177);
if(!isReplacePresntngPrblmByChiefComp){ 
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag183(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(complaint));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(dis3));
            _bw.write(_wl_block495Bytes, _wl_block495);
}
            _bw.write(_wl_block496Bytes, _wl_block496);

            if (_jsp__tag184(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(dis2));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(triage_remarks));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag185(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block498Bytes, _wl_block498);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag186(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(checked9));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag187(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(disOscc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag188(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag189(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag190(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);

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
											
						
            _bw.write(_wl_block201Bytes, _wl_block201);

            if (_jsp__tag191(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(checkedMed));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disMed));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag192(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(checkedSur));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disSur));
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag193(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(checkedOandGYn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disOandGYn));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block502Bytes, _wl_block502);
 }else{ 
            _bw.write(_wl_block503Bytes, _wl_block503);

            if (_jsp__tag194(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(checked9));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis5));
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag195(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(oscc_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(disOscc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable3));
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag196(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(checkedMed));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disMed));
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag197(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(checkedSur));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disSur));
            _bw.write(_wl_block227Bytes, _wl_block227);
 } 
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(called_from_ca));
            _bw.write(_wl_block508Bytes, _wl_block508);
 if(caseTypeYn.equals("Y")){ 
            _bw.write(_wl_block509Bytes, _wl_block509);

            if (_jsp__tag198(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(caseTypeDisable));
            _bw.write(_wl_block511Bytes, _wl_block511);

            if (_jsp__tag199(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block512Bytes, _wl_block512);

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
			   
            _bw.write(_wl_block513Bytes, _wl_block513);
if(caseTypeMandYn.equals("Y")){ 
            _bw.write(_wl_block514Bytes, _wl_block514);
} 
            _bw.write(_wl_block515Bytes, _wl_block515);
} 
            _bw.write(_wl_block516Bytes, _wl_block516);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block231Bytes, _wl_block231);
 } 
            _bw.write(_wl_block517Bytes, _wl_block517);
if(isPlaceOfOccuurrence == true){
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag200(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);

			}else{
            _bw.write(_wl_block518Bytes, _wl_block518);

            if (_jsp__tag201(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
}
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(disDateAcci));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(disDateAcci));
            _bw.write(_wl_block521Bytes, _wl_block521);
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(disDateAcci));
            _bw.write(_wl_block523Bytes, _wl_block523);
if(isLabelChngAppl == true){ 
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag202(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

            if (_jsp__tag203(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
}
			  else if(isPlaceOfOccuurrence == true){
			  
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag204(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);

			  }
			  else{
				
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag205(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
} 
            _bw.write(_wl_block248Bytes, _wl_block248);
if(isPlaceOfOccuurrence == false){
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(place_of_accident));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(disPlaceAcci));
            _bw.write(_wl_block175Bytes, _wl_block175);
}
			else
			{
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(disPlaceAcci));
            _bw.write(_wl_block253Bytes, _wl_block253);

            if (_jsp__tag206(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);
  
                   try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
                   //pstmtTrans = con.prepareStatement("select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE where  eff_status='E' order by short_desc");
				   /*Above line commented and below line added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = "select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE ##REPDB## where  eff_status='E' order by short_desc";
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   pstmtTrans = con.prepareStatement(sqlFinal);
				   /*End*/
				
				   rsetTrans = pstmtTrans.executeQuery();
				   
				   while(rsetTrans!=null && rsetTrans.next())
					{
					  if(rsetTrans.getString(1).equals(place_of_accident))
							   {
                                    optSelected="selected";
							
							   }
							   else
							   {
								   optSelected="";
							      
							   }
					  out.println("<option value='"+rsetTrans.getString("PLACE_OCCURRENCE_TYPE_CODE")+"' "+optSelected+" >"+rsetTrans.getString("short_desc")+""); 
					}
                  if(rsetTrans!=null) rsetTrans.close();
				  if(pstmtTrans!=null) pstmtTrans.close();
				  }catch(Exception e) {/* out.println("Exception in Place of Occurrence="+e); */			e.printStackTrace();}
	            
            _bw.write(_wl_block526Bytes, _wl_block526);
}
            _bw.write(_wl_block256Bytes, _wl_block256);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block257Bytes, _wl_block257);

            if (_jsp__tag207(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block258Bytes, _wl_block258);
 }else{ 
            _bw.write(_wl_block259Bytes, _wl_block259);

            if (_jsp__tag208(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block258Bytes, _wl_block258);
 } 
            _bw.write(_wl_block527Bytes, _wl_block527);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block528Bytes, _wl_block528);
 }else{ 
            _bw.write(_wl_block529Bytes, _wl_block529);
 } 
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(dis6));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag209(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

					 // if(modify_flag.equals("Y")) {
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  and EFF_STATUS='E' and   oscc_yn=  '"+oscc_yn+"'  ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
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
					//   }  
						 
            _bw.write(_wl_block266Bytes, _wl_block266);
 if(!isMechInjLabelChngAppl){ 
            _bw.write(_wl_block530Bytes, _wl_block530);

            if (_jsp__tag210(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
 } 
            _bw.write(_wl_block269Bytes, _wl_block269);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag211(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
 } 
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(mech_injury_subcatg_code));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(dis7));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag212(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block275Bytes, _wl_block275);
 } 
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag213(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block279Bytes, _wl_block279);

            if (_jsp__tag214(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

						 StringBuffer sqlVehicleInv = new StringBuffer();
						 //sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"'  order by 2");

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
					   
            _bw.write(_wl_block533Bytes, _wl_block533);

            if (_jsp__tag215(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(dis9));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag216(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);

						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
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
					   
            _bw.write(_wl_block535Bytes, _wl_block535);

            if (_jsp__tag217(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(Vehicle_Reg_No1));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block537Bytes, _wl_block537);

            if (_jsp__tag218(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(Vehicle_Reg_No2));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(dis8));
            _bw.write(_wl_block289Bytes, _wl_block289);

            if (_jsp__tag219(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(dis10));
            _bw.write(_wl_block291Bytes, _wl_block291);

            if (_jsp__tag220(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block292Bytes, _wl_block292);

			   StringBuffer sqlProtect = new StringBuffer();
			   //sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' ORDER BY 2");
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
			   
            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag221(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(dis11));
            _bw.write(_wl_block291Bytes, _wl_block291);

            if (_jsp__tag222(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

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
					   
            _bw.write(_wl_block540Bytes, _wl_block540);
if(siteSpecific){
            _bw.write(_wl_block541Bytes, _wl_block541);

            if (_jsp__tag223(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag224(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
}else{
            _bw.write(_wl_block299Bytes, _wl_block299);

            if (_jsp__tag225(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
}
            _bw.write(_wl_block542Bytes, _wl_block542);
if(siteSpecific){
            _bw.write(_wl_block543Bytes, _wl_block543);

            if (_jsp__tag226(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
}else{
            _bw.write(_wl_block302Bytes, _wl_block302);

            if (_jsp__tag227(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
}
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(checked3));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(disMLC));
            _bw.write(_wl_block546Bytes, _wl_block546);
 if(isMLCAppl){ 
            _bw.write(_wl_block308Bytes, _wl_block308);

            if (_jsp__tag228(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(MLC_DEATH_YN ));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(disMLCDeath ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(MLC_DEATH_YN.equals("Y")?" Checked ":"" ));
            _bw.write(_wl_block548Bytes, _wl_block548);
}else{ 
            _bw.write(_wl_block312Bytes, _wl_block312);
 }
            _bw.write(_wl_block313Bytes, _wl_block313);

            if (_jsp__tag229(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(pol_rep_no_mx_size ));
            _bw.write(_wl_block106Bytes, _wl_block106);
 if(isMLCAppl){ 
            _bw.write(_wl_block315Bytes, _wl_block315);
} 
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(police_rep_no));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(dis12));
            _bw.write(_wl_block318Bytes, _wl_block318);

            if (_jsp__tag230(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(pol_stn_det_mx_size ));
            _bw.write(_wl_block106Bytes, _wl_block106);
 if(isMLCAppl){ 
            _bw.write(_wl_block315Bytes, _wl_block315);
} 
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(police_station_dtls));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(dis13));
            _bw.write(_wl_block322Bytes, _wl_block322);
 if(isMLCAppl){ 
            _bw.write(_wl_block323Bytes, _wl_block323);

            if (_jsp__tag231(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(MLC_NO_OUTSIDE_DTLS ));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(disOutMLCDet ));
            _bw.write(_wl_block555Bytes, _wl_block555);

            if (_jsp__tag232(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(MLC_CAPTURE_DATE ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(disDateOfCapt ));
            _bw.write(_wl_block328Bytes, _wl_block328);

            if (_jsp__tag233(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(disMLCRemark ));
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(MLC_REMARKS));
            _bw.write(_wl_block557Bytes, _wl_block557);
} 
            _bw.write(_wl_block558Bytes, _wl_block558);

            if (_jsp__tag234(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag235(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block332Bytes, _wl_block332);

            if (_jsp__tag236(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block559Bytes, _wl_block559);

            if (_jsp__tag237(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block560Bytes, _wl_block560);
 if(isOrderCatalogChngAppl && !initialMgmtLblName.equals("")){ 
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(initialMgmtLblName));
            _bw.write(_wl_block234Bytes, _wl_block234);
 }else{ 
            _bw.write(_wl_block342Bytes, _wl_block342);

            if (_jsp__tag238(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);
 } 
            _bw.write(_wl_block343Bytes, _wl_block343);

		
		if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				   StringBuffer sqlOrderCatalog6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
			//	   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b, ae_param ##REPDB## c where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id and a.ORDERING_FACILITY_ID=c.OPERATING_FACILITY_ID ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 
				   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 
				   sqlECG3.append(sqlECG1);
				   sqlECG4.append(sqlECG1);
				   sqlECG5.append(sqlECG1);
				   sqlOrderCatalog6.append(sqlECG1);//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   StringBuffer s1 = new StringBuffer();
				   StringBuffer s3 = new StringBuffer();
				   StringBuffer s4 = new StringBuffer();
				   StringBuffer s5 = new StringBuffer();
				   StringBuffer s6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				/* s1.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE2");
				   s3.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE4");
				   s4.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE1");
				   s5.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE5");
				   s6.append(" and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE6");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
					*/
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

  
            _bw.write(_wl_block344Bytes, _wl_block344);
 if(isOrderCatalogChngAppl){ 
            _bw.write(_wl_block345Bytes, _wl_block345);

            if (_jsp__tag239(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(cbdProp));
            _bw.write(_wl_block348Bytes, _wl_block348);

            if (_jsp__tag240(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(medication));
            _bw.write(_wl_block562Bytes, _wl_block562);
 }else{ 
            _bw.write(_wl_block352Bytes, _wl_block352);

            if (_jsp__tag241(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(capBloodSugProp));
            _bw.write(_wl_block354Bytes, _wl_block354);

            if (_jsp__tag242(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(SpO2Prop));
            _bw.write(_wl_block356Bytes, _wl_block356);
 } 
            _bw.write(_wl_block357Bytes, _wl_block357);

            if (_jsp__tag243(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(FBCProp));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(fbccheck));
            _bw.write(_wl_block566Bytes, _wl_block566);
            out.print( String.valueOf(fbccheck_val));
            _bw.write(_wl_block567Bytes, _wl_block567);

            if (_jsp__tag244(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(ECGProp));
            _bw.write(_wl_block363Bytes, _wl_block363);
 if(isOrderCatalogChngAppl){ 
            _bw.write(_wl_block364Bytes, _wl_block364);
 if(!dressingLblName.equals("")){ 
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(dressingLblName));
            _bw.write(_wl_block366Bytes, _wl_block366);
 }else{
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag245(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag246(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);
 } 
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(DressProp));
            _bw.write(_wl_block369Bytes, _wl_block369);

            if (_jsp__tag247(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(++tindex));
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(intialMgmtOthers));
            _bw.write(_wl_block570Bytes, _wl_block570);
 }else{ 
            _bw.write(_wl_block373Bytes, _wl_block373);

            if (_jsp__tag248(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(DressProp));
            _bw.write(_wl_block376Bytes, _wl_block376);
 } 
            _bw.write(_wl_block377Bytes, _wl_block377);
}
            _bw.write(_wl_block378Bytes, _wl_block378);

            if (_jsp__tag249(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(disImmobil));
            _bw.write(_wl_block381Bytes, _wl_block381);

            if (_jsp__tag250(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block382Bytes, _wl_block382);

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
                 
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag251(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);

            if (_jsp__tag252(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(dis14));
            _bw.write(_wl_block386Bytes, _wl_block386);

            if (_jsp__tag253(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block388Bytes, _wl_block388);

            if (_jsp__tag254(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block390Bytes, _wl_block390);

            if (_jsp__tag255(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block390Bytes, _wl_block390);

            if (_jsp__tag256(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block392Bytes, _wl_block392);

            if (_jsp__tag257(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(checked4));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dis15));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(ca_install_yn));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(max_age_paediatric));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(min_age_pregnancy));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block397Bytes, _wl_block397);
 if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	
            _bw.write(_wl_block398Bytes, _wl_block398);

            if (_jsp__tag258(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);

            if (_jsp__tag259(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(checked5));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(disabled991));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled99));
            _bw.write(_wl_block403Bytes, _wl_block403);

            if (_jsp__tag260(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(checked6));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disImm));
            _bw.write(_wl_block406Bytes, _wl_block406);

            if (_jsp__tag261(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(checked7));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disMenarche));
            _bw.write(_wl_block409Bytes, _wl_block409);

            if (_jsp__tag262(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(disHeight));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(height));
            _bw.write(_wl_block413Bytes, _wl_block413);

            if (_jsp__tag263(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block414Bytes, _wl_block414);

            if (_jsp__tag264(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block579Bytes, _wl_block579);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(disWeight));
            _bw.write(_wl_block417Bytes, _wl_block417);

            if (_jsp__tag265(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block418Bytes, _wl_block418);

            if (_jsp__tag266(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(circumference));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(ca_install_yn));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(max_age_paediatric));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(min_age_pregnancy));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(disCir));
            _bw.write(_wl_block422Bytes, _wl_block422);

            if (_jsp__tag267(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block423Bytes, _wl_block423);
 } else{
			
			  disabled="";
		 }
            _bw.write(_wl_block581Bytes, _wl_block581);
if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) {
				 menstrual_status = "true"; 
            _bw.write(_wl_block425Bytes, _wl_block425);

            if (_jsp__tag268(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block582Bytes, _wl_block582);

            if (_jsp__tag269(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(checked8));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(disabledPre));
            _bw.write(_wl_block585Bytes, _wl_block585);

            if (_jsp__tag270(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(DateUtils.convertDate(lmp_date,"DMY","en",localeName)));
            _bw.write(_wl_block587Bytes, _wl_block587);

            if (_jsp__tag271(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block438Bytes, _wl_block438);

            if (_jsp__tag272(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block439Bytes, _wl_block439);

            if (_jsp__tag273(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block440Bytes, _wl_block440);

            if (_jsp__tag274(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block588Bytes, _wl_block588);
 } 
            _bw.write(_wl_block589Bytes, _wl_block589);
if(ca_install_yn.equals("Y")){
            _bw.write(_wl_block443Bytes, _wl_block443);

            if (_jsp__tag275(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block444Bytes, _wl_block444);

            if (_jsp__tag276(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block590Bytes, _wl_block590);
}
 }
 
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(visit_num));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block597Bytes, _wl_block597);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(treat_code));
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(menstrual_status));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(pediatric_status));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(mech_injr_subcat_code));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(RepDb));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block607Bytes, _wl_block607);
            out.print( String.valueOf(pat_priority));
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(trauma_yn));
            _bw.write(_wl_block609Bytes, _wl_block609);
            out.print( String.valueOf(disaster_town_code));
            _bw.write(_wl_block610Bytes, _wl_block610);
            out.print( String.valueOf(complaint_code));
            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(rec_date_time));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(sys_date_time1));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(arrival_code));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(params));
            _bw.write(_wl_block620Bytes, _wl_block620);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf(enable_rights_yn));
            _bw.write(_wl_block622Bytes, _wl_block622);
            out.print( String.valueOf(sel_triage_yn));
            _bw.write(_wl_block623Bytes, _wl_block623);
            out.print( String.valueOf(sel_cons_yn));
            _bw.write(_wl_block624Bytes, _wl_block624);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block625Bytes, _wl_block625);
            out.print( String.valueOf(order_catalog_code1));
            _bw.write(_wl_block626Bytes, _wl_block626);
            out.print( String.valueOf(order_catalog_code2));
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(order_catalog_code3));
            _bw.write(_wl_block628Bytes, _wl_block628);
            out.print( String.valueOf(order_catalog_code4));
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(order_catalog_code5));
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block632Bytes, _wl_block632);
            out.print( String.valueOf(modify_flag));
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(min_age_for_lmp));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(year_value1));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(fbc_yn));
            _bw.write(_wl_block636Bytes, _wl_block636);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(isCaseDtlsRadioBtnAppl));
            _bw.write(_wl_block638Bytes, _wl_block638);
            out.print( String.valueOf(OandGYn));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(mech_injr_code));
            _bw.write(_wl_block640Bytes, _wl_block640);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block642Bytes, _wl_block642);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block643Bytes, _wl_block643);
            out.print( String.valueOf(priority_zone_hidden_fileds));
            _bw.write(_wl_block644Bytes, _wl_block644);
            out.print( String.valueOf(isMechInjLabelChngAppl));
            _bw.write(_wl_block645Bytes, _wl_block645);
            out.print( String.valueOf(isReconfirmCOTAppl));
            _bw.write(_wl_block646Bytes, _wl_block646);
            out.print( String.valueOf(reconf_cot_param));
            _bw.write(_wl_block647Bytes, _wl_block647);
            out.print( String.valueOf(isSecTrgBackDateTimeAppl));
            _bw.write(_wl_block648Bytes, _wl_block648);
            out.print( String.valueOf(isChngBtnPositionAppl));
            _bw.write(_wl_block649Bytes, _wl_block649);
            out.print( String.valueOf(isPriorityZoneAppl));
            _bw.write(_wl_block650Bytes, _wl_block650);
            out.print( String.valueOf(isMLCAppl));
            _bw.write(_wl_block651Bytes, _wl_block651);
            out.print( String.valueOf(visit_date_time));
            _bw.write(_wl_block652Bytes, _wl_block652);
            out.print( String.valueOf(caseTypeYn));
            _bw.write(_wl_block653Bytes, _wl_block653);
            out.print( String.valueOf(caseTypeMandYn));
            _bw.write(_wl_block654Bytes, _wl_block654);
            out.print( String.valueOf(tickMlcOnOsccChecked));
            _bw.write(_wl_block655Bytes, _wl_block655);
            out.print( String.valueOf(isSecondaryTriageQueueNum ));
            _bw.write(_wl_block656Bytes, _wl_block656);
            out.print( String.valueOf(queue_appl_priority_zone ));
            _bw.write(_wl_block657Bytes, _wl_block657);
            out.print( String.valueOf(queue_num_mandatory ));
            _bw.write(_wl_block658Bytes, _wl_block658);
            out.print( String.valueOf(queue_secondary_triage ));
            _bw.write(_wl_block659Bytes, _wl_block659);
            out.print( String.valueOf(queue_max_num_allowed ));
            _bw.write(_wl_block660Bytes, _wl_block660);
            out.print( String.valueOf(queue_no));
            _bw.write(_wl_block661Bytes, _wl_block661);
            out.print( String.valueOf(latestMensDtlStatus ));
            _bw.write(_wl_block662Bytes, _wl_block662);
            out.print( String.valueOf(invokeMenstrualHistYN ));
            _bw.write(_wl_block663Bytes, _wl_block663);
            out.print( String.valueOf(rec_view_lmp_details_label));
            _bw.write(_wl_block664Bytes, _wl_block664);
}catch(Exception e){ e.toString(); e.printStackTrace();}
}catch(Exception e){ e.toString(); e.printStackTrace();}
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }

            _bw.write(_wl_block665Bytes, _wl_block665);
            out.print( String.valueOf(modeofarrival));
            _bw.write(_wl_block666Bytes, _wl_block666);
            _bw.write(_wl_block667Bytes, _wl_block667);
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueNo.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditTrail.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterReference.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisRegnReference.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterArea.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterType.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ambulatorystatus.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeofArrival.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AccompaniedBy.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PresentingProblem.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CaseDetails.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OandG.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfOccurrence.label", java.lang.String .class,"key"));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfAccident.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PickupPlace.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfOccurrence.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfAccident.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechOfMainInj.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MechanismofInjury.label", java.lang.String .class,"key"));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechaofSubInjury.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VehiclesInvolved.label", java.lang.String .class,"key"));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.VehicleRegNo.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProtectiveDeviceUsed.label", java.lang.String .class,"key"));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PositionDuringIncident.label", java.lang.String .class,"key"));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlcdetails.label", java.lang.String .class,"key"));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MlcDeath.label", java.lang.String .class,"key"));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceReportNo.label", java.lang.String .class,"key"));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceStationDetails.label", java.lang.String .class,"key"));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OutMlcNoDtls.label", java.lang.String .class,"key"));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateOfMlcCapture.label", java.lang.String .class,"key"));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ConditionCase.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllergyDetails.label", java.lang.String .class,"key"));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Triage.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.InitialManagement.label", java.lang.String .class,"key"));
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
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CBD.label", java.lang.String .class,"key"));
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
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Medication.label", java.lang.String .class,"key"));
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
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CapBloodSugar.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.SpO2.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.FBC.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ecg.label", java.lang.String .class,"key"));
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
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Compression.label", java.lang.String .class,"key"));
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
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dressing.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dressing.label", java.lang.String .class,"key"));
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
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Immobilization.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ATTImmunizationDetails.label", java.lang.String .class,"key"));
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
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ImmunizationStatus.label", java.lang.String .class,"key"));
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
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullyImmunized.label", java.lang.String .class,"key"));
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
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PartiallyImmunized.label", java.lang.String .class,"key"));
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
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ATTGiven.label", java.lang.String .class,"key"));
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
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PediatricDetail.label", java.lang.String .class,"key"));
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
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Growth/DevelMilestoneAge.label", java.lang.String .class,"key"));
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
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Immunizationuptodate.label", java.lang.String .class,"key"));
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
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Menarche.label", java.lang.String .class,"key"));
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
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
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
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.kg.label", java.lang.String .class,"key"));
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
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Circumference.label", java.lang.String .class,"key"));
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
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag130(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag130 = null ;
        int __result__tag130 = 0 ;

        if (__tag130 == null ){
            __tag130 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag130);
        }
        __tag130.setPageContext(pageContext);
        __tag130.setParent(null);
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MenstrualHistory.label", java.lang.String .class,"key"));
        __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag130;
        __result__tag130 = __tag130.doStartTag();

        if (__result__tag130!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag130== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag130.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag130);
            return true;
        }
        _activeTag=__tag130.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag130);
        __tag130.release();
        return false;
    }

    private boolean _jsp__tag131(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag131 = null ;
        int __result__tag131 = 0 ;

        if (__tag131 == null ){
            __tag131 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag131);
        }
        __tag131.setPageContext(pageContext);
        __tag131.setParent(null);
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PregnantatPresent.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag131;
        __result__tag131 = __tag131.doStartTag();

        if (__result__tag131!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag131== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag131.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag131);
            return true;
        }
        _activeTag=__tag131.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag131);
        __tag131.release();
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
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.POA.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
        __tag135.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EDD.label", java.lang.String .class,"key"));
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
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
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
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
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
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
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
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
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
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalNotes.label", java.lang.String .class,"key"));
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
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegisterPatientReferral.label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag150(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag150 = null ;
        int __result__tag150 = 0 ;

        if (__tag150 == null ){
            __tag150 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag150);
        }
        __tag150.setPageContext(pageContext);
        __tag150.setParent(null);
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ConditionCase.label", java.lang.String .class,"key"));
        __tag150.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag150;
        __result__tag150 = __tag150.doStartTag();

        if (__result__tag150!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag150== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag150.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag150);
            return true;
        }
        _activeTag=__tag150.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag150);
        __tag150.release();
        return false;
    }

    private boolean _jsp__tag151(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag151 = null ;
        int __result__tag151 = 0 ;

        if (__tag151 == null ){
            __tag151 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag151);
        }
        __tag151.setPageContext(pageContext);
        __tag151.setParent(null);
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag151;
        __result__tag151 = __tag151.doStartTag();

        if (__result__tag151!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag151== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag151.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag151);
            return true;
        }
        _activeTag=__tag151.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag151);
        __tag151.release();
        return false;
    }

    private boolean _jsp__tag152(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag152 = null ;
        int __result__tag152 = 0 ;

        if (__tag152 == null ){
            __tag152 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag152);
        }
        __tag152.setPageContext(pageContext);
        __tag152.setParent(null);
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientCondition.label", java.lang.String .class,"key"));
        __tag152.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag152;
        __result__tag152 = __tag152.doStartTag();

        if (__result__tag152!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag152== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag152.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag152);
            return true;
        }
        _activeTag=__tag152.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag152);
        __tag152.release();
        return false;
    }

    private boolean _jsp__tag153(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag153 = null ;
        int __result__tag153 = 0 ;

        if (__tag153 == null ){
            __tag153 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag153);
        }
        __tag153.setPageContext(pageContext);
        __tag153.setParent(null);
        __tag153.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
        __tag153.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag153;
        __result__tag153 = __tag153.doStartTag();

        if (__result__tag153!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag153== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag153.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag153);
            return true;
        }
        _activeTag=__tag153.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag153);
        __tag153.release();
        return false;
    }

    private boolean _jsp__tag154(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag154 = null ;
        int __result__tag154 = 0 ;

        if (__tag154 == null ){
            __tag154 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag154);
        }
        __tag154.setPageContext(pageContext);
        __tag154.setParent(null);
        __tag154.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag154.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag154;
        __result__tag154 = __tag154.doStartTag();

        if (__result__tag154!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag154== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag154.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag154);
            return true;
        }
        _activeTag=__tag154.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag154);
        __tag154.release();
        return false;
    }

    private boolean _jsp__tag155(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag155 = null ;
        int __result__tag155 = 0 ;

        if (__tag155 == null ){
            __tag155 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag155);
        }
        __tag155.setPageContext(pageContext);
        __tag155.setParent(null);
        __tag155.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag155.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag155;
        __result__tag155 = __tag155.doStartTag();

        if (__result__tag155!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag155== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag155.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag155);
            return true;
        }
        _activeTag=__tag155.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag155);
        __tag155.release();
        return false;
    }

    private boolean _jsp__tag156(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag156 = null ;
        int __result__tag156 = 0 ;

        if (__tag156 == null ){
            __tag156 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag156);
        }
        __tag156.setPageContext(pageContext);
        __tag156.setParent(null);
        __tag156.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag156.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag156;
        __result__tag156 = __tag156.doStartTag();

        if (__result__tag156!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag156== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag156.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag156);
            return true;
        }
        _activeTag=__tag156.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag156);
        __tag156.release();
        return false;
    }

    private boolean _jsp__tag157(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag157 = null ;
        int __result__tag157 = 0 ;

        if (__tag157 == null ){
            __tag157 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag157);
        }
        __tag157.setPageContext(pageContext);
        __tag157.setParent(null);
        __tag157.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag157.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag157;
        __result__tag157 = __tag157.doStartTag();

        if (__result__tag157!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag157== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag157.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag157);
            return true;
        }
        _activeTag=__tag157.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag157);
        __tag157.release();
        return false;
    }

    private boolean _jsp__tag158(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag158 = null ;
        int __result__tag158 = 0 ;

        if (__tag158 == null ){
            __tag158 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag158);
        }
        __tag158.setPageContext(pageContext);
        __tag158.setParent(null);
        __tag158.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
        __tag158.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag158;
        __result__tag158 = __tag158.doStartTag();

        if (__result__tag158!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag158== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag158.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag158);
            return true;
        }
        _activeTag=__tag158.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag158);
        __tag158.release();
        return false;
    }

    private boolean _jsp__tag159(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag159 = null ;
        int __result__tag159 = 0 ;

        if (__tag159 == null ){
            __tag159 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag159);
        }
        __tag159.setPageContext(pageContext);
        __tag159.setParent(null);
        __tag159.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag159.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag159;
        __result__tag159 = __tag159.doStartTag();

        if (__result__tag159!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag159== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag159.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag159);
            return true;
        }
        _activeTag=__tag159.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag159);
        __tag159.release();
        return false;
    }

    private boolean _jsp__tag160(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag160 = null ;
        int __result__tag160 = 0 ;

        if (__tag160 == null ){
            __tag160 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag160);
        }
        __tag160.setPageContext(pageContext);
        __tag160.setParent(null);
        __tag160.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag160.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag160;
        __result__tag160 = __tag160.doStartTag();

        if (__result__tag160!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag160== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag160.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag160);
            return true;
        }
        _activeTag=__tag160.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag160);
        __tag160.release();
        return false;
    }

    private boolean _jsp__tag161(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag161 = null ;
        int __result__tag161 = 0 ;

        if (__tag161 == null ){
            __tag161 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag161);
        }
        __tag161.setPageContext(pageContext);
        __tag161.setParent(null);
        __tag161.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
        __tag161.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag161;
        __result__tag161 = __tag161.doStartTag();

        if (__result__tag161!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag161== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag161.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag161);
            return true;
        }
        _activeTag=__tag161.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag161);
        __tag161.release();
        return false;
    }

    private boolean _jsp__tag162(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag162 = null ;
        int __result__tag162 = 0 ;

        if (__tag162 == null ){
            __tag162 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag162);
        }
        __tag162.setPageContext(pageContext);
        __tag162.setParent(null);
        __tag162.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterReference.label", java.lang.String .class,"key"));
        __tag162.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag162;
        __result__tag162 = __tag162.doStartTag();

        if (__result__tag162!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag162== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag162.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag162);
            return true;
        }
        _activeTag=__tag162.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag162);
        __tag162.release();
        return false;
    }

    private boolean _jsp__tag163(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag163 = null ;
        int __result__tag163 = 0 ;

        if (__tag163 == null ){
            __tag163 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag163);
        }
        __tag163.setPageContext(pageContext);
        __tag163.setParent(null);
        __tag163.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisRegnReference.label", java.lang.String .class,"key"));
        __tag163.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag163;
        __result__tag163 = __tag163.doStartTag();

        if (__result__tag163!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag163== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag163.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag163);
            return true;
        }
        _activeTag=__tag163.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag163);
        __tag163.release();
        return false;
    }

    private boolean _jsp__tag164(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag164 = null ;
        int __result__tag164 = 0 ;

        if (__tag164 == null ){
            __tag164 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag164);
        }
        __tag164.setPageContext(pageContext);
        __tag164.setParent(null);
        __tag164.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterArea.label", java.lang.String .class,"key"));
        __tag164.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag164;
        __result__tag164 = __tag164.doStartTag();

        if (__result__tag164!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag164== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag164.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag164);
            return true;
        }
        _activeTag=__tag164.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag164);
        __tag164.release();
        return false;
    }

    private boolean _jsp__tag165(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag165 = null ;
        int __result__tag165 = 0 ;

        if (__tag165 == null ){
            __tag165 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag165);
        }
        __tag165.setPageContext(pageContext);
        __tag165.setParent(null);
        __tag165.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterType.label", java.lang.String .class,"key"));
        __tag165.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag165;
        __result__tag165 = __tag165.doStartTag();

        if (__result__tag165!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag165== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag165.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag165);
            return true;
        }
        _activeTag=__tag165.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag165);
        __tag165.release();
        return false;
    }

    private boolean _jsp__tag166(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag166 = null ;
        int __result__tag166 = 0 ;

        if (__tag166 == null ){
            __tag166 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag166);
        }
        __tag166.setPageContext(pageContext);
        __tag166.setParent(null);
        __tag166.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag166.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag166;
        __result__tag166 = __tag166.doStartTag();

        if (__result__tag166!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag166== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag166.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag166);
            return true;
        }
        _activeTag=__tag166.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag166);
        __tag166.release();
        return false;
    }

    private boolean _jsp__tag167(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag167 = null ;
        int __result__tag167 = 0 ;

        if (__tag167 == null ){
            __tag167 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag167);
        }
        __tag167.setPageContext(pageContext);
        __tag167.setParent(null);
        __tag167.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ambulatorystatus.label", java.lang.String .class,"key"));
        __tag167.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag167;
        __result__tag167 = __tag167.doStartTag();

        if (__result__tag167!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag167== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag167.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag167);
            return true;
        }
        _activeTag=__tag167.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag167);
        __tag167.release();
        return false;
    }

    private boolean _jsp__tag168(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag168 = null ;
        int __result__tag168 = 0 ;

        if (__tag168 == null ){
            __tag168 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag168);
        }
        __tag168.setPageContext(pageContext);
        __tag168.setParent(null);
        __tag168.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag168.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag168;
        __result__tag168 = __tag168.doStartTag();

        if (__result__tag168!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag168== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag168.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag168);
            return true;
        }
        _activeTag=__tag168.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag168);
        __tag168.release();
        return false;
    }

    private boolean _jsp__tag169(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag169 = null ;
        int __result__tag169 = 0 ;

        if (__tag169 == null ){
            __tag169 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag169);
        }
        __tag169.setPageContext(pageContext);
        __tag169.setParent(null);
        __tag169.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag169.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag169;
        __result__tag169 = __tag169.doStartTag();

        if (__result__tag169!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag169== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag169.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag169);
            return true;
        }
        _activeTag=__tag169.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag169);
        __tag169.release();
        return false;
    }

    private boolean _jsp__tag170(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag170 = null ;
        int __result__tag170 = 0 ;

        if (__tag170 == null ){
            __tag170 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag170);
        }
        __tag170.setPageContext(pageContext);
        __tag170.setParent(null);
        __tag170.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ambulatorystatus.label", java.lang.String .class,"key"));
        __tag170.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag170;
        __result__tag170 = __tag170.doStartTag();

        if (__result__tag170!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag170== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag170.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag170);
            return true;
        }
        _activeTag=__tag170.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag170);
        __tag170.release();
        return false;
    }

    private boolean _jsp__tag171(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag171 = null ;
        int __result__tag171 = 0 ;

        if (__tag171 == null ){
            __tag171 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag171);
        }
        __tag171.setPageContext(pageContext);
        __tag171.setParent(null);
        __tag171.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag171.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag171;
        __result__tag171 = __tag171.doStartTag();

        if (__result__tag171!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag171== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag171.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag171);
            return true;
        }
        _activeTag=__tag171.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag171);
        __tag171.release();
        return false;
    }

    private boolean _jsp__tag172(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag172 = null ;
        int __result__tag172 = 0 ;

        if (__tag172 == null ){
            __tag172 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag172);
        }
        __tag172.setPageContext(pageContext);
        __tag172.setParent(null);
        __tag172.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeofArrival.label", java.lang.String .class,"key"));
        __tag172.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag172;
        __result__tag172 = __tag172.doStartTag();

        if (__result__tag172!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag172== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag172.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag172);
            return true;
        }
        _activeTag=__tag172.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag172);
        __tag172.release();
        return false;
    }

    private boolean _jsp__tag173(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag173 = null ;
        int __result__tag173 = 0 ;

        if (__tag173 == null ){
            __tag173 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag173);
        }
        __tag173.setPageContext(pageContext);
        __tag173.setParent(null);
        __tag173.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag173.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag173;
        __result__tag173 = __tag173.doStartTag();

        if (__result__tag173!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag173== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag173.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag173);
            return true;
        }
        _activeTag=__tag173.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag173);
        __tag173.release();
        return false;
    }

    private boolean _jsp__tag174(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag174 = null ;
        int __result__tag174 = 0 ;

        if (__tag174 == null ){
            __tag174 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag174);
        }
        __tag174.setPageContext(pageContext);
        __tag174.setParent(null);
        __tag174.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag174.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag174;
        __result__tag174 = __tag174.doStartTag();

        if (__result__tag174!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag174== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag174.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag174);
            return true;
        }
        _activeTag=__tag174.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag174);
        __tag174.release();
        return false;
    }

    private boolean _jsp__tag175(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag175 = null ;
        int __result__tag175 = 0 ;

        if (__tag175 == null ){
            __tag175 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag175);
        }
        __tag175.setPageContext(pageContext);
        __tag175.setParent(null);
        __tag175.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AccompaniedBy.label", java.lang.String .class,"key"));
        __tag175.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag175;
        __result__tag175 = __tag175.doStartTag();

        if (__result__tag175!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag175== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag175.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag175);
            return true;
        }
        _activeTag=__tag175.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag175);
        __tag175.release();
        return false;
    }

    private boolean _jsp__tag176(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag176 = null ;
        int __result__tag176 = 0 ;

        if (__tag176 == null ){
            __tag176 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag176);
        }
        __tag176.setPageContext(pageContext);
        __tag176.setParent(null);
        __tag176.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag176.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag176;
        __result__tag176 = __tag176.doStartTag();

        if (__result__tag176!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag176== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag176.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag176);
            return true;
        }
        _activeTag=__tag176.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag176);
        __tag176.release();
        return false;
    }

    private boolean _jsp__tag177(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag177 = null ;
        int __result__tag177 = 0 ;

        if (__tag177 == null ){
            __tag177 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag177);
        }
        __tag177.setPageContext(pageContext);
        __tag177.setParent(null);
        __tag177.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeofArrival.label", java.lang.String .class,"key"));
        __tag177.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag177;
        __result__tag177 = __tag177.doStartTag();

        if (__result__tag177!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag177== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag177.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag177);
            return true;
        }
        _activeTag=__tag177.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag177);
        __tag177.release();
        return false;
    }

    private boolean _jsp__tag178(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag178 = null ;
        int __result__tag178 = 0 ;

        if (__tag178 == null ){
            __tag178 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag178);
        }
        __tag178.setPageContext(pageContext);
        __tag178.setParent(null);
        __tag178.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag178.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag178;
        __result__tag178 = __tag178.doStartTag();

        if (__result__tag178!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag178== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag178.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag178);
            return true;
        }
        _activeTag=__tag178.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag178);
        __tag178.release();
        return false;
    }

    private boolean _jsp__tag179(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag179 = null ;
        int __result__tag179 = 0 ;

        if (__tag179 == null ){
            __tag179 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag179);
        }
        __tag179.setPageContext(pageContext);
        __tag179.setParent(null);
        __tag179.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag179.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag179;
        __result__tag179 = __tag179.doStartTag();

        if (__result__tag179!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag179== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag179.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag179);
            return true;
        }
        _activeTag=__tag179.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag179);
        __tag179.release();
        return false;
    }

    private boolean _jsp__tag180(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag180 = null ;
        int __result__tag180 = 0 ;

        if (__tag180 == null ){
            __tag180 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag180);
        }
        __tag180.setPageContext(pageContext);
        __tag180.setParent(null);
        __tag180.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AccompaniedBy.label", java.lang.String .class,"key"));
        __tag180.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag180;
        __result__tag180 = __tag180.doStartTag();

        if (__result__tag180!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag180== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag180.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag180);
            return true;
        }
        _activeTag=__tag180.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag180);
        __tag180.release();
        return false;
    }

    private boolean _jsp__tag181(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag181 = null ;
        int __result__tag181 = 0 ;

        if (__tag181 == null ){
            __tag181 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag181);
        }
        __tag181.setPageContext(pageContext);
        __tag181.setParent(null);
        __tag181.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag181.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag181;
        __result__tag181 = __tag181.doStartTag();

        if (__result__tag181!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag181== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag181.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag181);
            return true;
        }
        _activeTag=__tag181.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag181);
        __tag181.release();
        return false;
    }

    private boolean _jsp__tag182(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag182 = null ;
        int __result__tag182 = 0 ;

        if (__tag182 == null ){
            __tag182 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag182);
        }
        __tag182.setPageContext(pageContext);
        __tag182.setParent(null);
        __tag182.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag182.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag182;
        __result__tag182 = __tag182.doStartTag();

        if (__result__tag182!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag182== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag182.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag182);
            return true;
        }
        _activeTag=__tag182.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag182);
        __tag182.release();
        return false;
    }

    private boolean _jsp__tag183(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag183 = null ;
        int __result__tag183 = 0 ;

        if (__tag183 == null ){
            __tag183 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag183);
        }
        __tag183.setPageContext(pageContext);
        __tag183.setParent(null);
        __tag183.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PresentingProblem.label", java.lang.String .class,"key"));
        __tag183.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag183;
        __result__tag183 = __tag183.doStartTag();

        if (__result__tag183!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag183== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag183.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag183);
            return true;
        }
        _activeTag=__tag183.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag183);
        __tag183.release();
        return false;
    }

    private boolean _jsp__tag184(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag184 = null ;
        int __result__tag184 = 0 ;

        if (__tag184 == null ){
            __tag184 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag184);
        }
        __tag184.setPageContext(pageContext);
        __tag184.setParent(null);
        __tag184.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag184.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag184;
        __result__tag184 = __tag184.doStartTag();

        if (__result__tag184!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag184== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag184.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag184);
            return true;
        }
        _activeTag=__tag184.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag184);
        __tag184.release();
        return false;
    }

    private boolean _jsp__tag185(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag185 = null ;
        int __result__tag185 = 0 ;

        if (__tag185 == null ){
            __tag185 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag185);
        }
        __tag185.setPageContext(pageContext);
        __tag185.setParent(null);
        __tag185.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CaseDetails.label", java.lang.String .class,"key"));
        __tag185.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag185;
        __result__tag185 = __tag185.doStartTag();

        if (__result__tag185!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag185== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag185.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag185);
            return true;
        }
        _activeTag=__tag185.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag185);
        __tag185.release();
        return false;
    }

    private boolean _jsp__tag186(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag186 = null ;
        int __result__tag186 = 0 ;

        if (__tag186 == null ){
            __tag186 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag186);
        }
        __tag186.setPageContext(pageContext);
        __tag186.setParent(null);
        __tag186.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
        __tag186.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag186;
        __result__tag186 = __tag186.doStartTag();

        if (__result__tag186!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag186== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag186.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag186);
            return true;
        }
        _activeTag=__tag186.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag186);
        __tag186.release();
        return false;
    }

    private boolean _jsp__tag187(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag187 = null ;
        int __result__tag187 = 0 ;

        if (__tag187 == null ){
            __tag187 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag187);
        }
        __tag187.setPageContext(pageContext);
        __tag187.setParent(null);
        __tag187.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
        __tag187.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag187;
        __result__tag187 = __tag187.doStartTag();

        if (__result__tag187!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag187== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag187.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag187);
            return true;
        }
        _activeTag=__tag187.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag187);
        __tag187.release();
        return false;
    }

    private boolean _jsp__tag188(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag188 = null ;
        int __result__tag188 = 0 ;

        if (__tag188 == null ){
            __tag188 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag188);
        }
        __tag188.setPageContext(pageContext);
        __tag188.setParent(null);
        __tag188.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
        __tag188.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag188;
        __result__tag188 = __tag188.doStartTag();

        if (__result__tag188!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag188== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag188.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag188);
            return true;
        }
        _activeTag=__tag188.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag188);
        __tag188.release();
        return false;
    }

    private boolean _jsp__tag189(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag189 = null ;
        int __result__tag189 = 0 ;

        if (__tag189 == null ){
            __tag189 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag189);
        }
        __tag189.setPageContext(pageContext);
        __tag189.setParent(null);
        __tag189.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag189.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag189;
        __result__tag189 = __tag189.doStartTag();

        if (__result__tag189!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag189== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag189.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag189);
            return true;
        }
        _activeTag=__tag189.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag189);
        __tag189.release();
        return false;
    }

    private boolean _jsp__tag190(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag190 = null ;
        int __result__tag190 = 0 ;

        if (__tag190 == null ){
            __tag190 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag190);
        }
        __tag190.setPageContext(pageContext);
        __tag190.setParent(null);
        __tag190.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag190.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag190;
        __result__tag190 = __tag190.doStartTag();

        if (__result__tag190!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag190== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag190.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag190);
            return true;
        }
        _activeTag=__tag190.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag190);
        __tag190.release();
        return false;
    }

    private boolean _jsp__tag191(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag191 = null ;
        int __result__tag191 = 0 ;

        if (__tag191 == null ){
            __tag191 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag191);
        }
        __tag191.setPageContext(pageContext);
        __tag191.setParent(null);
        __tag191.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
        __tag191.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag191;
        __result__tag191 = __tag191.doStartTag();

        if (__result__tag191!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag191== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag191.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag191);
            return true;
        }
        _activeTag=__tag191.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag191);
        __tag191.release();
        return false;
    }

    private boolean _jsp__tag192(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag192 = null ;
        int __result__tag192 = 0 ;

        if (__tag192 == null ){
            __tag192 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag192);
        }
        __tag192.setPageContext(pageContext);
        __tag192.setParent(null);
        __tag192.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
        __tag192.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag192;
        __result__tag192 = __tag192.doStartTag();

        if (__result__tag192!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag192== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag192.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag192);
            return true;
        }
        _activeTag=__tag192.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag192);
        __tag192.release();
        return false;
    }

    private boolean _jsp__tag193(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag193 = null ;
        int __result__tag193 = 0 ;

        if (__tag193 == null ){
            __tag193 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag193);
        }
        __tag193.setPageContext(pageContext);
        __tag193.setParent(null);
        __tag193.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OandG.label", java.lang.String .class,"key"));
        __tag193.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag193;
        __result__tag193 = __tag193.doStartTag();

        if (__result__tag193!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag193== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag193.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag193);
            return true;
        }
        _activeTag=__tag193.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag193);
        __tag193.release();
        return false;
    }

    private boolean _jsp__tag194(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag194 = null ;
        int __result__tag194 = 0 ;

        if (__tag194 == null ){
            __tag194 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag194);
        }
        __tag194.setPageContext(pageContext);
        __tag194.setParent(null);
        __tag194.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
        __tag194.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag194;
        __result__tag194 = __tag194.doStartTag();

        if (__result__tag194!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag194== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag194.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag194);
            return true;
        }
        _activeTag=__tag194.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag194);
        __tag194.release();
        return false;
    }

    private boolean _jsp__tag195(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag195 = null ;
        int __result__tag195 = 0 ;

        if (__tag195 == null ){
            __tag195 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag195);
        }
        __tag195.setPageContext(pageContext);
        __tag195.setParent(null);
        __tag195.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
        __tag195.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag195;
        __result__tag195 = __tag195.doStartTag();

        if (__result__tag195!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag195== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag195.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag195);
            return true;
        }
        _activeTag=__tag195.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag195);
        __tag195.release();
        return false;
    }

    private boolean _jsp__tag196(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag196 = null ;
        int __result__tag196 = 0 ;

        if (__tag196 == null ){
            __tag196 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag196);
        }
        __tag196.setPageContext(pageContext);
        __tag196.setParent(null);
        __tag196.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
        __tag196.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag196;
        __result__tag196 = __tag196.doStartTag();

        if (__result__tag196!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag196== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag196.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag196);
            return true;
        }
        _activeTag=__tag196.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag196);
        __tag196.release();
        return false;
    }

    private boolean _jsp__tag197(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag197 = null ;
        int __result__tag197 = 0 ;

        if (__tag197 == null ){
            __tag197 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag197);
        }
        __tag197.setPageContext(pageContext);
        __tag197.setParent(null);
        __tag197.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
        __tag197.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag197;
        __result__tag197 = __tag197.doStartTag();

        if (__result__tag197!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag197== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag197.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag197);
            return true;
        }
        _activeTag=__tag197.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag197);
        __tag197.release();
        return false;
    }

    private boolean _jsp__tag198(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag198 = null ;
        int __result__tag198 = 0 ;

        if (__tag198 == null ){
            __tag198 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag198);
        }
        __tag198.setPageContext(pageContext);
        __tag198.setParent(null);
        __tag198.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CaseType.label", java.lang.String .class,"key"));
        __tag198.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag198;
        __result__tag198 = __tag198.doStartTag();

        if (__result__tag198!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag198== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag198.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag198);
            return true;
        }
        _activeTag=__tag198.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag198);
        __tag198.release();
        return false;
    }

    private boolean _jsp__tag199(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag199 = null ;
        int __result__tag199 = 0 ;

        if (__tag199 == null ){
            __tag199 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag199);
        }
        __tag199.setPageContext(pageContext);
        __tag199.setParent(null);
        __tag199.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag199.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag199;
        __result__tag199 = __tag199.doStartTag();

        if (__result__tag199!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag199== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag199.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag199);
            return true;
        }
        _activeTag=__tag199.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag199);
        __tag199.release();
        return false;
    }

    private boolean _jsp__tag200(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag200 = null ;
        int __result__tag200 = 0 ;

        if (__tag200 == null ){
            __tag200 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag200);
        }
        __tag200.setPageContext(pageContext);
        __tag200.setParent(null);
        __tag200.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfOccurrence.label", java.lang.String .class,"key"));
        __tag200.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag200;
        __result__tag200 = __tag200.doStartTag();

        if (__result__tag200!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag200== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag200.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag200);
            return true;
        }
        _activeTag=__tag200.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag200);
        __tag200.release();
        return false;
    }

    private boolean _jsp__tag201(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag201 = null ;
        int __result__tag201 = 0 ;

        if (__tag201 == null ){
            __tag201 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag201);
        }
        __tag201.setPageContext(pageContext);
        __tag201.setParent(null);
        __tag201.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfAccident.label", java.lang.String .class,"key"));
        __tag201.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag201;
        __result__tag201 = __tag201.doStartTag();

        if (__result__tag201!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag201== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag201.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag201);
            return true;
        }
        _activeTag=__tag201.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag201);
        __tag201.release();
        return false;
    }

    private boolean _jsp__tag202(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag202 = null ;
        int __result__tag202 = 0 ;

        if (__tag202 == null ){
            __tag202 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag202);
        }
        __tag202.setPageContext(pageContext);
        __tag202.setParent(null);
        __tag202.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfAccident.label", java.lang.String .class,"key"));
        __tag202.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag202;
        __result__tag202 = __tag202.doStartTag();

        if (__result__tag202!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag202== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag202.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag202);
            return true;
        }
        _activeTag=__tag202.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag202);
        __tag202.release();
        return false;
    }

    private boolean _jsp__tag203(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag203 = null ;
        int __result__tag203 = 0 ;

        if (__tag203 == null ){
            __tag203 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag203);
        }
        __tag203.setPageContext(pageContext);
        __tag203.setParent(null);
        __tag203.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PickupPlace.label", java.lang.String .class,"key"));
        __tag203.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag203;
        __result__tag203 = __tag203.doStartTag();

        if (__result__tag203!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag203== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag203.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag203);
            return true;
        }
        _activeTag=__tag203.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag203);
        __tag203.release();
        return false;
    }

    private boolean _jsp__tag204(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag204 = null ;
        int __result__tag204 = 0 ;

        if (__tag204 == null ){
            __tag204 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag204);
        }
        __tag204.setPageContext(pageContext);
        __tag204.setParent(null);
        __tag204.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfOccurrence.label", java.lang.String .class,"key"));
        __tag204.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag204;
        __result__tag204 = __tag204.doStartTag();

        if (__result__tag204!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag204== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag204.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag204);
            return true;
        }
        _activeTag=__tag204.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag204);
        __tag204.release();
        return false;
    }

    private boolean _jsp__tag205(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag205 = null ;
        int __result__tag205 = 0 ;

        if (__tag205 == null ){
            __tag205 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag205);
        }
        __tag205.setPageContext(pageContext);
        __tag205.setParent(null);
        __tag205.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfAccident.label", java.lang.String .class,"key"));
        __tag205.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag205;
        __result__tag205 = __tag205.doStartTag();

        if (__result__tag205!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag205== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag205.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag205);
            return true;
        }
        _activeTag=__tag205.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag205);
        __tag205.release();
        return false;
    }

    private boolean _jsp__tag206(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag206 = null ;
        int __result__tag206 = 0 ;

        if (__tag206 == null ){
            __tag206 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag206);
        }
        __tag206.setPageContext(pageContext);
        __tag206.setParent(null);
        __tag206.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag206.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag206;
        __result__tag206 = __tag206.doStartTag();

        if (__result__tag206!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag206== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag206.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag206);
            return true;
        }
        _activeTag=__tag206.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag206);
        __tag206.release();
        return false;
    }

    private boolean _jsp__tag207(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag207 = null ;
        int __result__tag207 = 0 ;

        if (__tag207 == null ){
            __tag207 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag207);
        }
        __tag207.setPageContext(pageContext);
        __tag207.setParent(null);
        __tag207.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechOfMainInj.label", java.lang.String .class,"key"));
        __tag207.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag207;
        __result__tag207 = __tag207.doStartTag();

        if (__result__tag207!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag207== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag207.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag207);
            return true;
        }
        _activeTag=__tag207.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag207);
        __tag207.release();
        return false;
    }

    private boolean _jsp__tag208(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag208 = null ;
        int __result__tag208 = 0 ;

        if (__tag208 == null ){
            __tag208 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag208);
        }
        __tag208.setPageContext(pageContext);
        __tag208.setParent(null);
        __tag208.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MechanismofInjury.label", java.lang.String .class,"key"));
        __tag208.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag208;
        __result__tag208 = __tag208.doStartTag();

        if (__result__tag208!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag208== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag208.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag208);
            return true;
        }
        _activeTag=__tag208.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag208);
        __tag208.release();
        return false;
    }

    private boolean _jsp__tag209(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag209 = null ;
        int __result__tag209 = 0 ;

        if (__tag209 == null ){
            __tag209 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag209);
        }
        __tag209.setPageContext(pageContext);
        __tag209.setParent(null);
        __tag209.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag209.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag209;
        __result__tag209 = __tag209.doStartTag();

        if (__result__tag209!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag209== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag209.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag209);
            return true;
        }
        _activeTag=__tag209.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag209);
        __tag209.release();
        return false;
    }

    private boolean _jsp__tag210(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag210 = null ;
        int __result__tag210 = 0 ;

        if (__tag210 == null ){
            __tag210 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag210);
        }
        __tag210.setPageContext(pageContext);
        __tag210.setParent(null);
        __tag210.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
        __tag210.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag210;
        __result__tag210 = __tag210.doStartTag();

        if (__result__tag210!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag210== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag210.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag210);
            return true;
        }
        _activeTag=__tag210.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag210);
        __tag210.release();
        return false;
    }

    private boolean _jsp__tag211(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag211 = null ;
        int __result__tag211 = 0 ;

        if (__tag211 == null ){
            __tag211 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag211);
        }
        __tag211.setPageContext(pageContext);
        __tag211.setParent(null);
        __tag211.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechaofSubInjury.label", java.lang.String .class,"key"));
        __tag211.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag211;
        __result__tag211 = __tag211.doStartTag();

        if (__result__tag211!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag211== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag211.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag211);
            return true;
        }
        _activeTag=__tag211.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag211);
        __tag211.release();
        return false;
    }

    private boolean _jsp__tag212(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag212 = null ;
        int __result__tag212 = 0 ;

        if (__tag212 == null ){
            __tag212 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag212);
        }
        __tag212.setPageContext(pageContext);
        __tag212.setParent(null);
        __tag212.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag212.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag212;
        __result__tag212 = __tag212.doStartTag();

        if (__result__tag212!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag212== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag212.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag212);
            return true;
        }
        _activeTag=__tag212.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag212);
        __tag212.release();
        return false;
    }

    private boolean _jsp__tag213(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag213 = null ;
        int __result__tag213 = 0 ;

        if (__tag213 == null ){
            __tag213 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag213);
        }
        __tag213.setPageContext(pageContext);
        __tag213.setParent(null);
        __tag213.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VehiclesInvolved.label", java.lang.String .class,"key"));
        __tag213.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag213;
        __result__tag213 = __tag213.doStartTag();

        if (__result__tag213!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag213== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag213.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag213);
            return true;
        }
        _activeTag=__tag213.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag213);
        __tag213.release();
        return false;
    }

    private boolean _jsp__tag214(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag214 = null ;
        int __result__tag214 = 0 ;

        if (__tag214 == null ){
            __tag214 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag214);
        }
        __tag214.setPageContext(pageContext);
        __tag214.setParent(null);
        __tag214.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag214.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag214;
        __result__tag214 = __tag214.doStartTag();

        if (__result__tag214!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag214== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag214.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag214);
            return true;
        }
        _activeTag=__tag214.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag214);
        __tag214.release();
        return false;
    }

    private boolean _jsp__tag215(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag215 = null ;
        int __result__tag215 = 0 ;

        if (__tag215 == null ){
            __tag215 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag215);
        }
        __tag215.setPageContext(pageContext);
        __tag215.setParent(null);
        __tag215.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
        __tag215.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag215;
        __result__tag215 = __tag215.doStartTag();

        if (__result__tag215!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag215== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag215.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag215);
            return true;
        }
        _activeTag=__tag215.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag215);
        __tag215.release();
        return false;
    }

    private boolean _jsp__tag216(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag216 = null ;
        int __result__tag216 = 0 ;

        if (__tag216 == null ){
            __tag216 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag216);
        }
        __tag216.setPageContext(pageContext);
        __tag216.setParent(null);
        __tag216.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag216.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag216;
        __result__tag216 = __tag216.doStartTag();

        if (__result__tag216!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag216== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag216.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag216);
            return true;
        }
        _activeTag=__tag216.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag216);
        __tag216.release();
        return false;
    }

    private boolean _jsp__tag217(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag217 = null ;
        int __result__tag217 = 0 ;

        if (__tag217 == null ){
            __tag217 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag217);
        }
        __tag217.setPageContext(pageContext);
        __tag217.setParent(null);
        __tag217.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.VehicleRegNo.label", java.lang.String .class,"key"));
        __tag217.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag217;
        __result__tag217 = __tag217.doStartTag();

        if (__result__tag217!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag217== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag217.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag217);
            return true;
        }
        _activeTag=__tag217.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag217);
        __tag217.release();
        return false;
    }

    private boolean _jsp__tag218(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag218 = null ;
        int __result__tag218 = 0 ;

        if (__tag218 == null ){
            __tag218 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag218);
        }
        __tag218.setPageContext(pageContext);
        __tag218.setParent(null);
        __tag218.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
        __tag218.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag218;
        __result__tag218 = __tag218.doStartTag();

        if (__result__tag218!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag218== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag218.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag218);
            return true;
        }
        _activeTag=__tag218.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag218);
        __tag218.release();
        return false;
    }

    private boolean _jsp__tag219(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag219 = null ;
        int __result__tag219 = 0 ;

        if (__tag219 == null ){
            __tag219 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag219);
        }
        __tag219.setPageContext(pageContext);
        __tag219.setParent(null);
        __tag219.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProtectiveDeviceUsed.label", java.lang.String .class,"key"));
        __tag219.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag219;
        __result__tag219 = __tag219.doStartTag();

        if (__result__tag219!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag219== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag219.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag219);
            return true;
        }
        _activeTag=__tag219.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag219);
        __tag219.release();
        return false;
    }

    private boolean _jsp__tag220(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag220 = null ;
        int __result__tag220 = 0 ;

        if (__tag220 == null ){
            __tag220 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag220);
        }
        __tag220.setPageContext(pageContext);
        __tag220.setParent(null);
        __tag220.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag220.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag220;
        __result__tag220 = __tag220.doStartTag();

        if (__result__tag220!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag220== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag220.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag220);
            return true;
        }
        _activeTag=__tag220.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag220);
        __tag220.release();
        return false;
    }

    private boolean _jsp__tag221(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag221 = null ;
        int __result__tag221 = 0 ;

        if (__tag221 == null ){
            __tag221 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag221);
        }
        __tag221.setPageContext(pageContext);
        __tag221.setParent(null);
        __tag221.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PositionDuringIncident.label", java.lang.String .class,"key"));
        __tag221.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag221;
        __result__tag221 = __tag221.doStartTag();

        if (__result__tag221!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag221== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag221.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag221);
            return true;
        }
        _activeTag=__tag221.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag221);
        __tag221.release();
        return false;
    }

    private boolean _jsp__tag222(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag222 = null ;
        int __result__tag222 = 0 ;

        if (__tag222 == null ){
            __tag222 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag222);
        }
        __tag222.setPageContext(pageContext);
        __tag222.setParent(null);
        __tag222.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag222.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag222;
        __result__tag222 = __tag222.doStartTag();

        if (__result__tag222!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag222== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag222.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag222);
            return true;
        }
        _activeTag=__tag222.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag222);
        __tag222.release();
        return false;
    }

    private boolean _jsp__tag223(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag223 = null ;
        int __result__tag223 = 0 ;

        if (__tag223 == null ){
            __tag223 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag223);
        }
        __tag223.setPageContext(pageContext);
        __tag223.setParent(null);
        __tag223.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
        __tag223.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag223;
        __result__tag223 = __tag223.doStartTag();

        if (__result__tag223!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag223== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag223.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag223);
            return true;
        }
        _activeTag=__tag223.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag223);
        __tag223.release();
        return false;
    }

    private boolean _jsp__tag224(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag224 = null ;
        int __result__tag224 = 0 ;

        if (__tag224 == null ){
            __tag224 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag224);
        }
        __tag224.setPageContext(pageContext);
        __tag224.setParent(null);
        __tag224.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag224.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag224;
        __result__tag224 = __tag224.doStartTag();

        if (__result__tag224!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag224== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag224.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag224);
            return true;
        }
        _activeTag=__tag224.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag224);
        __tag224.release();
        return false;
    }

    private boolean _jsp__tag225(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag225 = null ;
        int __result__tag225 = 0 ;

        if (__tag225 == null ){
            __tag225 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag225);
        }
        __tag225.setPageContext(pageContext);
        __tag225.setParent(null);
        __tag225.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlcdetails.label", java.lang.String .class,"key"));
        __tag225.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag225;
        __result__tag225 = __tag225.doStartTag();

        if (__result__tag225!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag225== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag225.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag225);
            return true;
        }
        _activeTag=__tag225.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag225);
        __tag225.release();
        return false;
    }

    private boolean _jsp__tag226(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag226 = null ;
        int __result__tag226 = 0 ;

        if (__tag226 == null ){
            __tag226 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag226);
        }
        __tag226.setPageContext(pageContext);
        __tag226.setParent(null);
        __tag226.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
        __tag226.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag226;
        __result__tag226 = __tag226.doStartTag();

        if (__result__tag226!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag226== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag226.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag226);
            return true;
        }
        _activeTag=__tag226.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag226);
        __tag226.release();
        return false;
    }

    private boolean _jsp__tag227(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag227 = null ;
        int __result__tag227 = 0 ;

        if (__tag227 == null ){
            __tag227 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag227);
        }
        __tag227.setPageContext(pageContext);
        __tag227.setParent(null);
        __tag227.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
        __tag227.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag227;
        __result__tag227 = __tag227.doStartTag();

        if (__result__tag227!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag227== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag227.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag227);
            return true;
        }
        _activeTag=__tag227.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag227);
        __tag227.release();
        return false;
    }

    private boolean _jsp__tag228(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag228 = null ;
        int __result__tag228 = 0 ;

        if (__tag228 == null ){
            __tag228 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag228);
        }
        __tag228.setPageContext(pageContext);
        __tag228.setParent(null);
        __tag228.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MlcDeath.label", java.lang.String .class,"key"));
        __tag228.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag228;
        __result__tag228 = __tag228.doStartTag();

        if (__result__tag228!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag228== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag228.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag228);
            return true;
        }
        _activeTag=__tag228.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag228);
        __tag228.release();
        return false;
    }

    private boolean _jsp__tag229(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag229 = null ;
        int __result__tag229 = 0 ;

        if (__tag229 == null ){
            __tag229 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag229);
        }
        __tag229.setPageContext(pageContext);
        __tag229.setParent(null);
        __tag229.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceReportNo.label", java.lang.String .class,"key"));
        __tag229.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag229;
        __result__tag229 = __tag229.doStartTag();

        if (__result__tag229!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag229== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag229.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag229);
            return true;
        }
        _activeTag=__tag229.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag229);
        __tag229.release();
        return false;
    }

    private boolean _jsp__tag230(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag230 = null ;
        int __result__tag230 = 0 ;

        if (__tag230 == null ){
            __tag230 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag230);
        }
        __tag230.setPageContext(pageContext);
        __tag230.setParent(null);
        __tag230.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceStationDetails.label", java.lang.String .class,"key"));
        __tag230.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag230;
        __result__tag230 = __tag230.doStartTag();

        if (__result__tag230!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag230== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag230.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag230);
            return true;
        }
        _activeTag=__tag230.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag230);
        __tag230.release();
        return false;
    }

    private boolean _jsp__tag231(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag231 = null ;
        int __result__tag231 = 0 ;

        if (__tag231 == null ){
            __tag231 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag231);
        }
        __tag231.setPageContext(pageContext);
        __tag231.setParent(null);
        __tag231.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OutMlcNoDtls.label", java.lang.String .class,"key"));
        __tag231.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag231;
        __result__tag231 = __tag231.doStartTag();

        if (__result__tag231!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag231== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag231.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag231);
            return true;
        }
        _activeTag=__tag231.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag231);
        __tag231.release();
        return false;
    }

    private boolean _jsp__tag232(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag232 = null ;
        int __result__tag232 = 0 ;

        if (__tag232 == null ){
            __tag232 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag232);
        }
        __tag232.setPageContext(pageContext);
        __tag232.setParent(null);
        __tag232.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateOfMlcCapture.label", java.lang.String .class,"key"));
        __tag232.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag232;
        __result__tag232 = __tag232.doStartTag();

        if (__result__tag232!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag232== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag232.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag232);
            return true;
        }
        _activeTag=__tag232.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag232);
        __tag232.release();
        return false;
    }

    private boolean _jsp__tag233(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag233 = null ;
        int __result__tag233 = 0 ;

        if (__tag233 == null ){
            __tag233 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag233);
        }
        __tag233.setPageContext(pageContext);
        __tag233.setParent(null);
        __tag233.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag233.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag233;
        __result__tag233 = __tag233.doStartTag();

        if (__result__tag233!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag233== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag233.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag233);
            return true;
        }
        _activeTag=__tag233.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag233);
        __tag233.release();
        return false;
    }

    private boolean _jsp__tag234(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag234 = null ;
        int __result__tag234 = 0 ;

        if (__tag234 == null ){
            __tag234 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag234);
        }
        __tag234.setPageContext(pageContext);
        __tag234.setParent(null);
        __tag234.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
        __tag234.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag234;
        __result__tag234 = __tag234.doStartTag();

        if (__result__tag234!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag234== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag234.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag234);
            return true;
        }
        _activeTag=__tag234.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag234);
        __tag234.release();
        return false;
    }

    private boolean _jsp__tag235(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag235 = null ;
        int __result__tag235 = 0 ;

        if (__tag235 == null ){
            __tag235 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag235);
        }
        __tag235.setPageContext(pageContext);
        __tag235.setParent(null);
        __tag235.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
        __tag235.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag235;
        __result__tag235 = __tag235.doStartTag();

        if (__result__tag235!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag235== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag235.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag235);
            return true;
        }
        _activeTag=__tag235.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag235);
        __tag235.release();
        return false;
    }

    private boolean _jsp__tag236(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag236 = null ;
        int __result__tag236 = 0 ;

        if (__tag236 == null ){
            __tag236 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag236);
        }
        __tag236.setPageContext(pageContext);
        __tag236.setParent(null);
        __tag236.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ConditionCase.label", java.lang.String .class,"key"));
        __tag236.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag236;
        __result__tag236 = __tag236.doStartTag();

        if (__result__tag236!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag236== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag236.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag236);
            return true;
        }
        _activeTag=__tag236.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag236);
        __tag236.release();
        return false;
    }

    private boolean _jsp__tag237(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag237 = null ;
        int __result__tag237 = 0 ;

        if (__tag237 == null ){
            __tag237 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag237);
        }
        __tag237.setPageContext(pageContext);
        __tag237.setParent(null);
        __tag237.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag237.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag237;
        __result__tag237 = __tag237.doStartTag();

        if (__result__tag237!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag237== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag237.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag237);
            return true;
        }
        _activeTag=__tag237.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag237);
        __tag237.release();
        return false;
    }

    private boolean _jsp__tag238(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag238 = null ;
        int __result__tag238 = 0 ;

        if (__tag238 == null ){
            __tag238 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag238);
        }
        __tag238.setPageContext(pageContext);
        __tag238.setParent(null);
        __tag238.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.InitialManagement.label", java.lang.String .class,"key"));
        __tag238.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag238;
        __result__tag238 = __tag238.doStartTag();

        if (__result__tag238!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag238== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag238.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag238);
            return true;
        }
        _activeTag=__tag238.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag238);
        __tag238.release();
        return false;
    }

    private boolean _jsp__tag239(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag239 = null ;
        int __result__tag239 = 0 ;

        if (__tag239 == null ){
            __tag239 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag239);
        }
        __tag239.setPageContext(pageContext);
        __tag239.setParent(null);
        __tag239.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CBD.label", java.lang.String .class,"key"));
        __tag239.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag239;
        __result__tag239 = __tag239.doStartTag();

        if (__result__tag239!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag239== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag239.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag239);
            return true;
        }
        _activeTag=__tag239.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag239);
        __tag239.release();
        return false;
    }

    private boolean _jsp__tag240(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag240 = null ;
        int __result__tag240 = 0 ;

        if (__tag240 == null ){
            __tag240 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag240);
        }
        __tag240.setPageContext(pageContext);
        __tag240.setParent(null);
        __tag240.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Medication.label", java.lang.String .class,"key"));
        __tag240.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag240;
        __result__tag240 = __tag240.doStartTag();

        if (__result__tag240!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag240== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag240.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag240);
            return true;
        }
        _activeTag=__tag240.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag240);
        __tag240.release();
        return false;
    }

    private boolean _jsp__tag241(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag241 = null ;
        int __result__tag241 = 0 ;

        if (__tag241 == null ){
            __tag241 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag241);
        }
        __tag241.setPageContext(pageContext);
        __tag241.setParent(null);
        __tag241.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.CapBloodSugar.label", java.lang.String .class,"key"));
        __tag241.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag241;
        __result__tag241 = __tag241.doStartTag();

        if (__result__tag241!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag241== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag241.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag241);
            return true;
        }
        _activeTag=__tag241.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag241);
        __tag241.release();
        return false;
    }

    private boolean _jsp__tag242(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag242 = null ;
        int __result__tag242 = 0 ;

        if (__tag242 == null ){
            __tag242 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag242);
        }
        __tag242.setPageContext(pageContext);
        __tag242.setParent(null);
        __tag242.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.SpO2.label", java.lang.String .class,"key"));
        __tag242.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag242;
        __result__tag242 = __tag242.doStartTag();

        if (__result__tag242!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag242== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag242.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag242);
            return true;
        }
        _activeTag=__tag242.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag242);
        __tag242.release();
        return false;
    }

    private boolean _jsp__tag243(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag243 = null ;
        int __result__tag243 = 0 ;

        if (__tag243 == null ){
            __tag243 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag243);
        }
        __tag243.setPageContext(pageContext);
        __tag243.setParent(null);
        __tag243.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.FBC.label", java.lang.String .class,"key"));
        __tag243.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag243;
        __result__tag243 = __tag243.doStartTag();

        if (__result__tag243!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag243== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag243.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag243);
            return true;
        }
        _activeTag=__tag243.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag243);
        __tag243.release();
        return false;
    }

    private boolean _jsp__tag244(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag244 = null ;
        int __result__tag244 = 0 ;

        if (__tag244 == null ){
            __tag244 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag244);
        }
        __tag244.setPageContext(pageContext);
        __tag244.setParent(null);
        __tag244.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ecg.label", java.lang.String .class,"key"));
        __tag244.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag244;
        __result__tag244 = __tag244.doStartTag();

        if (__result__tag244!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag244== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag244.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag244);
            return true;
        }
        _activeTag=__tag244.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag244);
        __tag244.release();
        return false;
    }

    private boolean _jsp__tag245(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag245 = null ;
        int __result__tag245 = 0 ;

        if (__tag245 == null ){
            __tag245 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag245);
        }
        __tag245.setPageContext(pageContext);
        __tag245.setParent(null);
        __tag245.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Compression.label", java.lang.String .class,"key"));
        __tag245.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag245;
        __result__tag245 = __tag245.doStartTag();

        if (__result__tag245!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag245== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag245.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag245);
            return true;
        }
        _activeTag=__tag245.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag245);
        __tag245.release();
        return false;
    }

    private boolean _jsp__tag246(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag246 = null ;
        int __result__tag246 = 0 ;

        if (__tag246 == null ){
            __tag246 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag246);
        }
        __tag246.setPageContext(pageContext);
        __tag246.setParent(null);
        __tag246.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dressing.label", java.lang.String .class,"key"));
        __tag246.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag246;
        __result__tag246 = __tag246.doStartTag();

        if (__result__tag246!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag246== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag246.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag246);
            return true;
        }
        _activeTag=__tag246.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag246);
        __tag246.release();
        return false;
    }

    private boolean _jsp__tag247(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag247 = null ;
        int __result__tag247 = 0 ;

        if (__tag247 == null ){
            __tag247 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag247);
        }
        __tag247.setPageContext(pageContext);
        __tag247.setParent(null);
        __tag247.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag247.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag247;
        __result__tag247 = __tag247.doStartTag();

        if (__result__tag247!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag247== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag247.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag247);
            return true;
        }
        _activeTag=__tag247.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag247);
        __tag247.release();
        return false;
    }

    private boolean _jsp__tag248(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag248 = null ;
        int __result__tag248 = 0 ;

        if (__tag248 == null ){
            __tag248 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag248);
        }
        __tag248.setPageContext(pageContext);
        __tag248.setParent(null);
        __tag248.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dressing.label", java.lang.String .class,"key"));
        __tag248.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag248;
        __result__tag248 = __tag248.doStartTag();

        if (__result__tag248!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag248== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag248.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag248);
            return true;
        }
        _activeTag=__tag248.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag248);
        __tag248.release();
        return false;
    }

    private boolean _jsp__tag249(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag249 = null ;
        int __result__tag249 = 0 ;

        if (__tag249 == null ){
            __tag249 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag249);
        }
        __tag249.setPageContext(pageContext);
        __tag249.setParent(null);
        __tag249.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Immobilization.label", java.lang.String .class,"key"));
        __tag249.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag249;
        __result__tag249 = __tag249.doStartTag();

        if (__result__tag249!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag249== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag249.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag249);
            return true;
        }
        _activeTag=__tag249.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag249);
        __tag249.release();
        return false;
    }

    private boolean _jsp__tag250(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag250 = null ;
        int __result__tag250 = 0 ;

        if (__tag250 == null ){
            __tag250 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag250);
        }
        __tag250.setPageContext(pageContext);
        __tag250.setParent(null);
        __tag250.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag250.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag250;
        __result__tag250 = __tag250.doStartTag();

        if (__result__tag250!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag250== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag250.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag250);
            return true;
        }
        _activeTag=__tag250.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag250);
        __tag250.release();
        return false;
    }

    private boolean _jsp__tag251(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag251 = null ;
        int __result__tag251 = 0 ;

        if (__tag251 == null ){
            __tag251 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag251);
        }
        __tag251.setPageContext(pageContext);
        __tag251.setParent(null);
        __tag251.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ATTImmunizationDetails.label", java.lang.String .class,"key"));
        __tag251.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag251;
        __result__tag251 = __tag251.doStartTag();

        if (__result__tag251!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag251== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag251.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag251);
            return true;
        }
        _activeTag=__tag251.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag251);
        __tag251.release();
        return false;
    }

    private boolean _jsp__tag252(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag252 = null ;
        int __result__tag252 = 0 ;

        if (__tag252 == null ){
            __tag252 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag252);
        }
        __tag252.setPageContext(pageContext);
        __tag252.setParent(null);
        __tag252.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ImmunizationStatus.label", java.lang.String .class,"key"));
        __tag252.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag252;
        __result__tag252 = __tag252.doStartTag();

        if (__result__tag252!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag252== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag252.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag252);
            return true;
        }
        _activeTag=__tag252.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag252);
        __tag252.release();
        return false;
    }

    private boolean _jsp__tag253(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag253 = null ;
        int __result__tag253 = 0 ;

        if (__tag253 == null ){
            __tag253 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag253);
        }
        __tag253.setPageContext(pageContext);
        __tag253.setParent(null);
        __tag253.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag253.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag253;
        __result__tag253 = __tag253.doStartTag();

        if (__result__tag253!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag253== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag253.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag253);
            return true;
        }
        _activeTag=__tag253.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag253);
        __tag253.release();
        return false;
    }

    private boolean _jsp__tag254(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag254 = null ;
        int __result__tag254 = 0 ;

        if (__tag254 == null ){
            __tag254 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag254);
        }
        __tag254.setPageContext(pageContext);
        __tag254.setParent(null);
        __tag254.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullyImmunized.label", java.lang.String .class,"key"));
        __tag254.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag254;
        __result__tag254 = __tag254.doStartTag();

        if (__result__tag254!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag254== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag254.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag254);
            return true;
        }
        _activeTag=__tag254.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag254);
        __tag254.release();
        return false;
    }

    private boolean _jsp__tag255(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag255 = null ;
        int __result__tag255 = 0 ;

        if (__tag255 == null ){
            __tag255 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag255);
        }
        __tag255.setPageContext(pageContext);
        __tag255.setParent(null);
        __tag255.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PartiallyImmunized.label", java.lang.String .class,"key"));
        __tag255.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag255;
        __result__tag255 = __tag255.doStartTag();

        if (__result__tag255!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag255== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag255.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag255);
            return true;
        }
        _activeTag=__tag255.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag255);
        __tag255.release();
        return false;
    }

    private boolean _jsp__tag256(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag256 = null ;
        int __result__tag256 = 0 ;

        if (__tag256 == null ){
            __tag256 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag256);
        }
        __tag256.setPageContext(pageContext);
        __tag256.setParent(null);
        __tag256.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag256.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag256;
        __result__tag256 = __tag256.doStartTag();

        if (__result__tag256!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag256== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag256.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag256);
            return true;
        }
        _activeTag=__tag256.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag256);
        __tag256.release();
        return false;
    }

    private boolean _jsp__tag257(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag257 = null ;
        int __result__tag257 = 0 ;

        if (__tag257 == null ){
            __tag257 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag257);
        }
        __tag257.setPageContext(pageContext);
        __tag257.setParent(null);
        __tag257.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ATTGiven.label", java.lang.String .class,"key"));
        __tag257.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag257;
        __result__tag257 = __tag257.doStartTag();

        if (__result__tag257!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag257== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag257.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag257);
            return true;
        }
        _activeTag=__tag257.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag257);
        __tag257.release();
        return false;
    }

    private boolean _jsp__tag258(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag258 = null ;
        int __result__tag258 = 0 ;

        if (__tag258 == null ){
            __tag258 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag258);
        }
        __tag258.setPageContext(pageContext);
        __tag258.setParent(null);
        __tag258.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PediatricDetail.label", java.lang.String .class,"key"));
        __tag258.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag258;
        __result__tag258 = __tag258.doStartTag();

        if (__result__tag258!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag258== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag258.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag258);
            return true;
        }
        _activeTag=__tag258.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag258);
        __tag258.release();
        return false;
    }

    private boolean _jsp__tag259(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag259 = null ;
        int __result__tag259 = 0 ;

        if (__tag259 == null ){
            __tag259 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag259);
        }
        __tag259.setPageContext(pageContext);
        __tag259.setParent(null);
        __tag259.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Growth/DevelMilestoneAge.label", java.lang.String .class,"key"));
        __tag259.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag259;
        __result__tag259 = __tag259.doStartTag();

        if (__result__tag259!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag259== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag259.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag259);
            return true;
        }
        _activeTag=__tag259.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag259);
        __tag259.release();
        return false;
    }

    private boolean _jsp__tag260(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag260 = null ;
        int __result__tag260 = 0 ;

        if (__tag260 == null ){
            __tag260 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag260);
        }
        __tag260.setPageContext(pageContext);
        __tag260.setParent(null);
        __tag260.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Immunizationuptodate.label", java.lang.String .class,"key"));
        __tag260.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag260;
        __result__tag260 = __tag260.doStartTag();

        if (__result__tag260!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag260== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag260.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag260);
            return true;
        }
        _activeTag=__tag260.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag260);
        __tag260.release();
        return false;
    }

    private boolean _jsp__tag261(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag261 = null ;
        int __result__tag261 = 0 ;

        if (__tag261 == null ){
            __tag261 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag261);
        }
        __tag261.setPageContext(pageContext);
        __tag261.setParent(null);
        __tag261.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Menarche.label", java.lang.String .class,"key"));
        __tag261.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag261;
        __result__tag261 = __tag261.doStartTag();

        if (__result__tag261!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag261== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag261.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag261);
            return true;
        }
        _activeTag=__tag261.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag261);
        __tag261.release();
        return false;
    }

    private boolean _jsp__tag262(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag262 = null ;
        int __result__tag262 = 0 ;

        if (__tag262 == null ){
            __tag262 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag262);
        }
        __tag262.setPageContext(pageContext);
        __tag262.setParent(null);
        __tag262.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
        __tag262.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag262;
        __result__tag262 = __tag262.doStartTag();

        if (__result__tag262!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag262== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag262.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag262);
            return true;
        }
        _activeTag=__tag262.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag262);
        __tag262.release();
        return false;
    }

    private boolean _jsp__tag263(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag263 = null ;
        int __result__tag263 = 0 ;

        if (__tag263 == null ){
            __tag263 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag263);
        }
        __tag263.setPageContext(pageContext);
        __tag263.setParent(null);
        __tag263.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag263.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag263;
        __result__tag263 = __tag263.doStartTag();

        if (__result__tag263!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag263== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag263.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag263);
            return true;
        }
        _activeTag=__tag263.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag263);
        __tag263.release();
        return false;
    }

    private boolean _jsp__tag264(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag264 = null ;
        int __result__tag264 = 0 ;

        if (__tag264 == null ){
            __tag264 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag264);
        }
        __tag264.setPageContext(pageContext);
        __tag264.setParent(null);
        __tag264.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
        __tag264.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag264;
        __result__tag264 = __tag264.doStartTag();

        if (__result__tag264!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag264== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag264.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag264);
            return true;
        }
        _activeTag=__tag264.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag264);
        __tag264.release();
        return false;
    }

    private boolean _jsp__tag265(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag265 = null ;
        int __result__tag265 = 0 ;

        if (__tag265 == null ){
            __tag265 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag265);
        }
        __tag265.setPageContext(pageContext);
        __tag265.setParent(null);
        __tag265.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.kg.label", java.lang.String .class,"key"));
        __tag265.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag265;
        __result__tag265 = __tag265.doStartTag();

        if (__result__tag265!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag265== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag265.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag265);
            return true;
        }
        _activeTag=__tag265.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag265);
        __tag265.release();
        return false;
    }

    private boolean _jsp__tag266(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag266 = null ;
        int __result__tag266 = 0 ;

        if (__tag266 == null ){
            __tag266 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag266);
        }
        __tag266.setPageContext(pageContext);
        __tag266.setParent(null);
        __tag266.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Circumference.label", java.lang.String .class,"key"));
        __tag266.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag266;
        __result__tag266 = __tag266.doStartTag();

        if (__result__tag266!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag266== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag266.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag266);
            return true;
        }
        _activeTag=__tag266.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag266);
        __tag266.release();
        return false;
    }

    private boolean _jsp__tag267(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag267 = null ;
        int __result__tag267 = 0 ;

        if (__tag267 == null ){
            __tag267 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag267);
        }
        __tag267.setPageContext(pageContext);
        __tag267.setParent(null);
        __tag267.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cm.label", java.lang.String .class,"key"));
        __tag267.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag267;
        __result__tag267 = __tag267.doStartTag();

        if (__result__tag267!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag267== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag267.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag267);
            return true;
        }
        _activeTag=__tag267.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag267);
        __tag267.release();
        return false;
    }

    private boolean _jsp__tag268(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag268 = null ;
        int __result__tag268 = 0 ;

        if (__tag268 == null ){
            __tag268 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag268);
        }
        __tag268.setPageContext(pageContext);
        __tag268.setParent(null);
        __tag268.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MenstrualHistory.label", java.lang.String .class,"key"));
        __tag268.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag268;
        __result__tag268 = __tag268.doStartTag();

        if (__result__tag268!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag268== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag268.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag268);
            return true;
        }
        _activeTag=__tag268.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag268);
        __tag268.release();
        return false;
    }

    private boolean _jsp__tag269(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag269 = null ;
        int __result__tag269 = 0 ;

        if (__tag269 == null ){
            __tag269 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag269);
        }
        __tag269.setPageContext(pageContext);
        __tag269.setParent(null);
        __tag269.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PregnantatPresent.label", java.lang.String .class,"key"));
        __tag269.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag269;
        __result__tag269 = __tag269.doStartTag();

        if (__result__tag269!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag269== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag269.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag269);
            return true;
        }
        _activeTag=__tag269.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag269);
        __tag269.release();
        return false;
    }

    private boolean _jsp__tag270(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag270 = null ;
        int __result__tag270 = 0 ;

        if (__tag270 == null ){
            __tag270 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag270);
        }
        __tag270.setPageContext(pageContext);
        __tag270.setParent(null);
        __tag270.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.LMPDate.label", java.lang.String .class,"key"));
        __tag270.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag270;
        __result__tag270 = __tag270.doStartTag();

        if (__result__tag270!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag270== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag270.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag270);
            return true;
        }
        _activeTag=__tag270.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag270);
        __tag270.release();
        return false;
    }

    private boolean _jsp__tag271(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag271 = null ;
        int __result__tag271 = 0 ;

        if (__tag271 == null ){
            __tag271 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag271);
        }
        __tag271.setPageContext(pageContext);
        __tag271.setParent(null);
        __tag271.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.POA.label", java.lang.String .class,"key"));
        __tag271.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag271;
        __result__tag271 = __tag271.doStartTag();

        if (__result__tag271!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag271== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag271.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag271);
            return true;
        }
        _activeTag=__tag271.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag271);
        __tag271.release();
        return false;
    }

    private boolean _jsp__tag272(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag272 = null ;
        int __result__tag272 = 0 ;

        if (__tag272 == null ){
            __tag272 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag272);
        }
        __tag272.setPageContext(pageContext);
        __tag272.setParent(null);
        __tag272.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
        __tag272.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag272;
        __result__tag272 = __tag272.doStartTag();

        if (__result__tag272!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag272== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag272.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag272);
            return true;
        }
        _activeTag=__tag272.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag272);
        __tag272.release();
        return false;
    }

    private boolean _jsp__tag273(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag273 = null ;
        int __result__tag273 = 0 ;

        if (__tag273 == null ){
            __tag273 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag273);
        }
        __tag273.setPageContext(pageContext);
        __tag273.setParent(null);
        __tag273.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag273.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag273;
        __result__tag273 = __tag273.doStartTag();

        if (__result__tag273!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag273== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag273.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag273);
            return true;
        }
        _activeTag=__tag273.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag273);
        __tag273.release();
        return false;
    }

    private boolean _jsp__tag274(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag274 = null ;
        int __result__tag274 = 0 ;

        if (__tag274 == null ){
            __tag274 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag274);
        }
        __tag274.setPageContext(pageContext);
        __tag274.setParent(null);
        __tag274.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EDD.label", java.lang.String .class,"key"));
        __tag274.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag274;
        __result__tag274 = __tag274.doStartTag();

        if (__result__tag274!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag274== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag274.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag274);
            return true;
        }
        _activeTag=__tag274.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag274);
        __tag274.release();
        return false;
    }

    private boolean _jsp__tag275(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag275 = null ;
        int __result__tag275 = 0 ;

        if (__tag275 == null ){
            __tag275 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag275);
        }
        __tag275.setPageContext(pageContext);
        __tag275.setParent(null);
        __tag275.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
        __tag275.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag275;
        __result__tag275 = __tag275.doStartTag();

        if (__result__tag275!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag275== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag275.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag275);
            return true;
        }
        _activeTag=__tag275.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag275);
        __tag275.release();
        return false;
    }

    private boolean _jsp__tag276(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag276 = null ;
        int __result__tag276 = 0 ;

        if (__tag276 == null ){
            __tag276 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag276);
        }
        __tag276.setPageContext(pageContext);
        __tag276.setParent(null);
        __tag276.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
        __tag276.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag276;
        __result__tag276 = __tag276.doStartTag();

        if (__result__tag276!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag276== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag276.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag276);
            return true;
        }
        _activeTag=__tag276.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag276);
        __tag276.release();
        return false;
    }
}
