package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOR.OrderEntryBillingQueryBean;
import eOR.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dentaltreatment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/DentalTreatment.jsp", 1709119331052L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!-- <script>\n\tvar contextPath=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\n\tvar retieveSesion=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n</script> -->\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<html>\n\t\t\t<head>\n\t\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n\t\t\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/DentalTreatment.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/OHBilling.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/GetImages.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/FillImages.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/DrawShapes.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/DentalTreatmentStages.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/RecordDiagForTrmt.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/TrmtMatDetails.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eOH/js/TrmtComplicationDetails.js\"></script>\n\t\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t\t\t<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t\t\t<script>\n                     function countSurface(){//added by parul ...selected surface should not be more than no_of_surface\n\t                 var count=0;\n\t\t\t\t\t var no_of_surface=document.forms[0].no_of_surface.value;\n\t\t\t\t\t var oh_surface=document.forms[0].oh_surface.value;\n\t\t\t\t\t\t for(var m=0;m<document.forms[0].oh_surface.options.length;m++){\n\t\t\t\t\t\t\tif(document.forms[0].oh_surface.options[m].selected==true){\n\t\t\t\t\t\t\t\tsurface_ref=document.forms[0].oh_surface.options[m].value;\n\t\t\t\t\t\t\t\tcount++;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t if  (count>no_of_surface){\n\t\t\t\t\t\t\talert(\"selected surface should not be more than no_of_surface\")\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t<style>\n\t\t\t\t\tTD.Menu{\n\t\t\t\t\t\t\tBACKGROUND-COLOR:white;\n\t\t\t\t\t\t\tborder-color:#999999\n\t\t\t\t\t}\n\t\t\t\t</style>\n\t\t\t</head>\n\t\t\t<body topmargin=\'0\' leftmargin=\'0\' class=\'CONTENT\' onload=\"setValuesFromMenu(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');CurrTime(); \" OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t\t\t<form name=\'OHTreatmentForm\' id=\'OHTreatmentForm\' method=\'post\' action=\'../../servlet/eOH.OHDentalChartTrmtServlet\' target=\'messageFrame\'>\n\t\t\t\t\t<table align=\'center\' cellpadding=\'4\' cellspacing=\'\' border=\'0\' width=\'100%\'>\n\t\t\t\t\t\t<!-- <tr>\n\t\t\t\t\t\t\t<td></td><td></td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t  <font color=\"blue\"><a id=\"dentistComments\" onclick=\"showDentistComments(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" style=\"cursor:pointer\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></font>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr> -->\n\t<!-- Comments @DentalTreatment.jsp By Muthukumar on 20-09-2011  - Treatment Forms Starts here -->\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t<!-- <select ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" name=\'oh_category\'  onChange=\'populateSiteOptions(this,\"onSelectCategory\");populateTreatments(this);populateConditionCode(this);checkForMaxilla(this);populateStatus(this);\'> -->\n\t\t\t\t\t\t\t\t<!-- commented by parul on 7/21/2009 for IN012683,When u select trmt cataegory for range and before record if u change trmt cataegory area leaged and value should be refresh-->\n\t\t\t\t\t\t\t\t <select ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" name=\'oh_category\'  onChange=\"populateSiteOptions(this,\'onSelectCategory\');populateTreatments(this);checkForMaxilla(this);populateStatus(this);getAreaLegendFromPage(this);populateAreaFromPage(this,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');getSurfaceLegend(this);getSurfaceLegendFromPage(this);populateSurfaces(this);enableDisableSurfaceFromPage(this);\">   \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"25%\" nowrap class=\'LABEL\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t<select name=\'oh_treatment\' id=\'oh_treatment\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onChange=\'chkTreatment(this);populateConditionCode(document.forms[0].oh_category,this);\' nowrap>\n\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\">\n\t\t\t\t\t\t\t\t   <select name=\"oh_site\" id=\"oh_site\" onChange=\"getAreaLegendFromPage(this);populateAreaFromPage(this,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');enableDisableSurface(this);enableDisableCuspTip(this);getSurfaceLegendFromPage(this);populateSurfacesFromPage(this);\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">  \n\t\t\t\t\t\t\t\t  <!-- <select name=\"oh_site\" id=\"oh_site\" onChange=\"getAreaLegendFromPage(this);populateAreaFromPage(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');enableDisableSurface(this);enableDisableCuspTip(this)\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="   ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">  -->\n\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<img id=\'SiteMandatory\' src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap id=\"change_area\" ></td>\n\t\t\t\t\t\t\t<td width=\"25%\" id=\"area_field\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap id=\"change_surface\"> ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" id=\"surface_field\">\n\t\t\t\t\t\t\t\t\t<select name=\"oh_surface\" id=\"oh_surface\"  onchange=\"countSurface();\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">\n\t\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t<IMG id=\'MandatorySurface\' style=\'visibility:hidden\' name=\'MandatorySurface\' border=\"0\" src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t</td>   \n                          ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t  <!--  size=3 multiple,  added  by SRR-CRF20056-0442 on 20/01/2010-->\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap id=\"change_surface\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" id=\"surface_field\">\n\t\t\t\t\t\t\t\t\t<select name=\"oh_surface\" id=\"oh_surface\" size=3 multiple  onchange=\"countSurface();populateCuspTip(this);\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="> \n\t\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t<IMG id=\'MandatorySurface\' style=\'visibility:hidden\' name=\'MandatorySurface\' border=\"0\" src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\n\t\t\t\t\t\t \t<td width=\"20%\" class=\'LABEL\' nowrap id=\"cusp_area\" style=style=\"visibility:hidden;position:absolute\" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" id=\'cusp_field\' style=style=\"visibility:hidden;position:absolute\" >\n\t\t\t\t\t\t\t\t<select name=\"oh_cusp_tip\" id=\"oh_cusp_tip\"  size=3 multiple ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =">\n\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap id=\"task_legend\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" id=\"task_code_display\">\n\t\t\t\t\t\t\t\t\t\t<select name=\"oh_task\" id=\"oh_task\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">\n\t\t\t\t\t\t\t\t\t\t\t<option value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t<td width=\"25%\"></td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" \n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap> ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t<select name=\"treatment_status\" id=\"treatment_status\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" onChange=\"changeStatus(this);\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"\" selected>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"10\" selected>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"15\" selected>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"25\" selected>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"53\" selected>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"52\" selected>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"55\" selected>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"75\" selected>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"90\" selected>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"70\" selected>Pending Authorozation<!-- ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" --></option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"60\" selected>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"PO\" selected>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t\t\t\t\t\t\t\t\t\t<!--Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)-->\n\t\t\t\t\t\t\t\t\t\t<option value=\"A\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t  <option value=\"E\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t<!--Commented and Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480) -->\n\t\t\t\t\t\t\t\t\t\t<!-- <option value=\"E\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option> -->\n\t\t\t\t\t\t\t\t\t\t<!-- <option value=\"A\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option> -->\n\t\t\t\t\t\t\t\t\t\t<option value=\"E\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t \t<font color=\"blue\"><a id=\"showCancelForReason\" onclick=\"showReasonForCancel(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\')\" style=\"cursor:pointer;visibility:hidden;position:absolute\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="<img id=\"mandatoryReason\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></a>\n\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t   <td id =\"maxillaTrmt\" width=\"25%\">\n\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a onclick=\"showOperRemarks(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</a></font>\n\t\t\t\t\t\t\t\t\t\t<IMG id=\'MandatoryRemarks\' style=\'visibility:hidden\' name=\'MandatoryRemarks\' border=\"0\" src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t<!-- <div id = \"Add/Cancel\" style=\'visibility:hidden;display:none\'> -->\n\t\t\t\t\t\t\t\t<!-- \t<table id=\'Add\' cellpadding=\"3\" cellspacing=0 border=\'0\' width=\'100%\' \talign=\'center\' >  -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t \t<tr id=\'add_data\' style=\"visibility:hidden\"> \n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<select name=\"tasks_applicable\" id=\"tasks_applicable\">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<select name=\"row_seq\" id=\"row_seq\">\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"RA\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"RB\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t </tr> \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t <!-- \t<font color=\"blue\"><a id=\"showCancelForReason\" onclick=\"showReasonForCancel(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\')\" style=\"cursor:pointer;visibility:hidden\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</a><img id=\"mandatoryReason\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></font> -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t<!-- </td> -->\n\t\t\t\t\t\t<!-- \t <td width=\"25%\"></td>\n\t\t\t\t\t\t\t<td width=\"25%\"></td> \n\t\t\t\t\t\t</tr> -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!----Added by yadav on 1/14/2010 for registration Date and time for CRF-443-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t <td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t\t\t\t\t\t<td width=\"25%\"><input type=\"text\"  size=\"10\" readonly id=\"regDate\" name=\"regDate\" id=\"regDate\" VALUE=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="/> <input type=\"Text\" onblur=\"verify(this)\" id=\"regTime\" name=\"regTime\" id=\"regTime\" size=\'3\' maxlength=\"5\"  VALUE=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" /><img src=\'../../eCommon/images/mandatory.gif\'></td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t<!------------------------------end------------------------------->\n\t\t\t\t\t\t<!-- Added By Yadav on 10/9/2009 for CRF 707 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t<!-- td id,style added by parul on 08/06/2010 for IN021923 -->\n\t\t\t\t\t\t\t<td id =\'performed_ot\' style=\"visibility:visible\" width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t\t\t\t<td id =\'performed_ot_chk\' style=\"visibility:visible\" width=\"25%\"><input type=\"checkbox\" id=\"otParam\" name=\"check\" id=\"check\"  onClick=\"setValue(this)\" ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" /></td> \n \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!------------------------------end------------------------------->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!-- Written by Sharon Crasta on 9/29/2008 to display the Start Date and End Date depending on the Tasks(RG,IM,IR,RS)-->\n\t\t\t\t\t\t<tr id=\'start_end_add_data\' style=\"visibility:visible\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t <input type=\"text\" name=\"strtDate\" id=\"strtDate\" VALUE=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" size=\"10\" maxlength=\"10\" onKeyPress=\"NumberCheck(this); \" onBlur=\"checkDateValidity(this);\" ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="/> \n\t\t\t\t\t\t\t\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'strtDate\');\" ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"strtTime\" id=\"strtTime\" VALUE=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" size=\"5\" maxlength=\"5\" onKeyPress=\"NumberTimeCheck(this);\" onBlur=\" checkTimeValidity(this);\" ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="/> \t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"endDate\" id=\"endDate\" VALUE=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" size=\"10\" maxlength = \"10\" onKeyPress=\"NumberCheck(this); \" onBlur=\"checkDateValidity(this);\" ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="/>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'endDate\');\" ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"endTime\" id=\"endTime\" VALUE=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" size=\"5\" maxlength=\"5\" onKeyPress=\"NumberTimeCheck(this);\" onBlur=\"checkTimeValidity(this);\" ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="/> \n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t <tr> \n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap id=\'outcome_label\' style=\"visibility:visible\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" id=\'outcome_select\' style=\"visibility:visible\">\n\t\t\t\t\t\t\t\t\t\t<!--<select name=\"oh_outcome\" id=\"oh_outcome\" ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" >-->\n\t\t\t\t\t\t\t\t\t\t<select name=\"oh_outcome\" id=\"oh_outcome\"  onChange=\"chkForFailureReason(this);\" ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" >\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</option> \n\t\t\t\t\t\t\t\t\t\t\t<option value=\"S\">";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</option>\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"F\">";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</option>\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- \t<td width=\"25%\" class=\'LABEL\' nowrap id=\'complication_label\' style=\"visibility:visible\">";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" id=\'complication_select\' style=\"visibility:visible\">\n\t\t\t\t\t\t\t\t\t\t<select name=\"oh_complication\" id=\"oh_complication\" ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =">";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td> -->\n\t\t\t\t\t\t\t\t\t<td width=\"20%\" class=\'LABEL\' nowrap  id=\"change_reason\" style=\'visibility:hidden\' >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"field\" id=\'reason_field\' style=\'visibility:hidden\' >\n\t\t\t\t\t \t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td id =\"maxillaTrmt\" width=\"25%\" colspan=\"3\" nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a onclick=\"showOperRemarks(\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</a></font><IMG id=\'MandatoryRemarks\' style=\'visibility:hidden\' name=\'MandatoryRemarks\' border=\"0\" src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a onclick=\"recordDiagForTrmt(\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\');\" style=\"cursor:pointer\">";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</a></font>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a onclick=\"recordMatUsed(\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</a></font> \n                                        &nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a onclick=\"recordComplicationUsed(\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</a></font> \n\n                                      <!-- added by parul on 12/02/2010 for CRF-496 & 477 -->\n\t\t\t\t\t\t\t\t\t\t<!-- <font color=\"blue\"><a id=\"cancelReason\" onclick=\"showReasonForCancel(\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</a><IMG id=\'MandatoryRemarks\' style=\'visibility:hidden\' name=\'MandatoryCancelReason\'  src=\'../../eCommon/images/mandatory.gif\'></font> -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t    &nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a style=\"cursor:pointer\" onClick=\"openNotes(\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\');\">";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</a> &nbsp;&nbsp;</font>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\t\n\t\t\t\t\t\t\t\t\t\t\t<!-- <td class=\"label\">";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</a></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"confirm_complete_charges\" name=\"complete_charges\" id=\"complete_charges\" value = \"\" ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="/>\n\t\t\t\t\t\t\t\t\t\t\t</td> -->\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td id=\'edit_charges\' class=\"button\"  align=\"right\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="     \n\t\t\t\t\t\t\t\t\t\t\t        \n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a style=\"cursor:pointer\" onClick=\"callBillingWindow(\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</a> &nbsp;&nbsp;</font>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <input type=\"button\" class=\"button\" name=\"record_charges\" id=\"record_charges\" value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' onclick =\"recordCharges();\"  ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="> -->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<font color=\"blue\"><a style=\"cursor:pointer\">";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</a> &nbsp;&nbsp;</font>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"button\" align=\"right\" id=\"save_reset_button\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"button\"  colspan = \"4\" align=\"right\" id=\"save_reset_button\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"button\" colspan = \"4\" align=\"right\" id=\"save_reset_button\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t\t<td class=\"button\" colspan = \"4\" align=\"right\" id=\"save_reset_button\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t<!--Commented and Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480) -->\n\t\t\t\t\t\t\t\t<!-- <input type=\"button\" class=\"button\" id = \"record_button\" name=\"save\" id=\"save\" value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' onclick =\"actionToServlet(\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\');\" ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =">&nbsp; -->\n\t\t\t\t\t\t\t\t<!--Commented by Sharon Crasta on 7/27/2009 for Print Preview-->\n\t\t\t\t\t\t\t\t<!-- <input type=\"button\" class=\"button\" name=\"Print Chart\" id=\"Print Chart\" value=\'Print Preview\' onclick=\"printOverview();\">  -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" id = \"record_button\" name=\"save\" id=\"save\" value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\');\" disabled>&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =">&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"reset\" id=\"reset\" value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' onclick=\"Treatment_Reset_Button(document.forms[0])\" ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t</table>\n\t<!-- Comments @DentalTreatment.jsp By Muthukumar on 20-09-2011  - Treatment Forms Ends here -->\n\t\t\t\t\t<input type = \"hidden\" name= \"locale\" value = \"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"facility_id\" value = \"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"ca_practitioner_id\" value = \"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"episode_id\" value = \"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"episode_type\" value = \"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"visit_id\" value = \"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"location_code\" value = \"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"location_type\" value = \"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\n\t\t\t\t\t<input type = \"hidden\" name= \"tooth_numbering_system\" value = \"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"mixed_dentition_YN\" value = \"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"chart_type\" value = \"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t\t\t<input type = \"hidden\" name=\'header_tab\' id=\'header_tab\' value=";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 =" >\n\t\t\t\t\t<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"tab_name\" value = \"\">\n\n\t\t\t\t\t<input type=\"hidden\" name=\'show_new_active_yn\' id=\'show_new_active_yn\' value=";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =" >\n\t\t\t\t\t<input type=\"hidden\" name=\'chart_hdr_insert_yn\' id=\'chart_hdr_insert_yn\' value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'thrng_nos_ref\' id=\'thrng_nos_ref\' value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'thrng_nos\' id=\'thrng_nos\' value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'called_from_viewchart_yn\' id=\'called_from_viewchart_yn\' value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'baseline_chart_yn\' id=\'baseline_chart_yn\' value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'chart_line_num\' id=\'chart_line_num\' value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'ind_chart_line_num\' id=\'ind_chart_line_num\' value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'cat_code\' id=\'cat_code\' value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'clinical_group_code\' id=\'clinical_group_code\' value=\"\" >\n\t\t\t\t\t<input type = \"hidden\" name= \"clinical_group_hid\" value = \"\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"remarks\" value = \"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"display_tooth_no\" value = \"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\"> \n\t\t\t\t\t<!-- <input type = \"hidden\" name= \"reasonforcancel\" value = \"\">  -->\n\t\t\t\t\t<input type = \"hidden\" name= \"reasonforcancel\" value = \"\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"status_for_filling\" value = \"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"RD_Normal_yn\" value = \"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\"> \n\n\t\t\t\t\t<!-- These are for the disabled fields. Take the values from these fields in the servlet to insert into database -->\n\t\t\t\t\t<input type = \"hidden\" name= \"category\" value = \"\">\n\t\t\t\t\t<input type = \"hidden\" name= \"site\" value = \"\">\n\t\t\t\t\t<input type = \"hidden\" name= \"area\" value = \"\">\n\t\t\t\t\t<input type = \"hidden\" name= \"treatment\" value = \"\">\n\t\t\t\t\t<input type = \"hidden\" name= \"oh_status\" value = \"\">\n\t\t\t\t\t<input type = \"hidden\" name= \"outcome\" value = \"\">\n\t\t\t\t\t<input type = \"hidden\" name= \"outcome_new\" value = \"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"treatment_status_param\" value = \"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"order_id\" value = \'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n\t\t\t\t\t<input type = \"hidden\" name= \"order_line_num\" value = \'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n\t\t\t\t\t<input type = \"hidden\" name= \"trmt_code\" value = \'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\t\t\t\t\t<input type = \"hidden\" name= \"task_code\" value = \'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'> \n\t\t\t\t\t<input type = \"hidden\" name= \"task_desc\" value = \"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\"> \n\t\t\t\t\t<!--Added single quotes for task_desc IN023245 by AnithaJ   -->\n\t\t\t\t\t<input type = \"hidden\" name= \"date_diff_flag\" value = \"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"seq_no\" value = \"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"diagcodeselected\" value = \"\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"comp_code_selected\" value = \"\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"arch_quad\" value = \"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"called_from_viewchart_gingival\" id=\"called_from_viewchart_gingival\" value=\"N\" >\n\n\t\t\t\t\t<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value= \'Or_RegisterOrder\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value= \'eOR.RegisterOrder\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'total_recs\' id=\'total_recs\' value= \'1\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'chk0\' id=\'chk0\' value= \'on\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_id0\" id=\"ord_id0\" value = \'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'cont_order_ind0\' id=\'cont_order_ind0\' value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'appt_ref_num0\' id=\'appt_ref_num0\' value= \'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'appt_reqd_yn\' id=\'appt_reqd_yn\' value= \'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'encounter_id0\' id=\'encounter_id0\' value = \"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'view_by0\' id=\'view_by0\' value= \'H\'>\n\t\t\t\t\t<input type=\"hidden\" name= \"practitioner_id\" value = \"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value= \'1\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'line_id0\' id=\'line_id0\' value= \'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_total_charge\' id=\'bl_total_charge\' value= \'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_task_charge\' id=\'bl_task_charge\'  value= \'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'trmt_order_catalog_code\' id=\'trmt_order_catalog_code\'  value= \'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'task_order_catalog_code\' id=\'task_order_catalog_code\'  value= \'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'>\n\n\t\t\t\t\t<!-- Variables for Billing Function -->\n\t\t\t\t\t<input type=\'hidden\' name=\'billing_appl_yn\' id=\'billing_appl_yn\'  value= \'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_key\' id=\'bl_key\'  value= \'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_key_line_no\' id=\'bl_key_line_no\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_task_code\' id=\'bl_task_code\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_patient_id\' id=\'bl_patient_id\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_episode_type\' id=\'bl_episode_type\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_episode_id\' id=\'bl_episode_id\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_visit_id\' id=\'bl_visit_id\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_encounter_id\' id=\'bl_encounter_id\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_service_date\' id=\'bl_service_date\'  value= \'\'>\n\t\t\t\t\t<!-- <input type=\'hidden\' name=\'bl_P\' id=\'bl_P\'  value= \'\'> -->\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_pract_staff_id\' id=\'bl_pract_staff_id\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_serv_panel_ind\' id=\'bl_serv_panel_ind\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_serv_panel_code\' id=\'bl_serv_panel_code\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_panel_str\' id=\'bl_panel_str\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_total_payable\' id=\'bl_total_payable\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_patient_payable\' id=\'bl_patient_payable\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_preapp_yn\' id=\'bl_preapp_yn\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_patient_paid_amt\' id=\'bl_patient_paid_amt\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_charged_yn\' id=\'bl_charged_yn\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_quantity\' id=\'bl_quantity\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_total_payable_for_trmt\' id=\'bl_total_payable_for_trmt\'  value= \'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'total_existing_task_amount\' id=\'total_existing_task_amount\'  value= \'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'charging_stage\' id=\'charging_stage\'  value= \'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'>\n\t\t\t\t\t<!-- Added by Sharon Crasta on 2/3/2009 --- Variable for callingBillingWindow-->\n\t\t\t\t\t<input type=\'hidden\' name=\'bill_sub_regn_num\' id=\'bill_sub_regn_num\'  value= \'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'bill_sub_regn_line_num\' id=\'bill_sub_regn_line_num\'  value= \'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_data_exists_yn\' id=\'bl_data_exists_yn\'  value= \'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'billed_yn\' id=\'billed_yn\'  value= \'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'order_catalog_bill_yn\' id=\'order_catalog_bill_yn\'  value= \'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\n\t\t\t\t\t<!-- Added by Sharon Crasta on 10/13/2008 --- Variable for Registered Date/Time-->\n\t\t\t\t\t<input type=\'hidden\' name=\'regn_date_time1\' id=\'regn_date_time1\'  value= \'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\n\t\t\t\t\t\n\t\t\t\t\t<!-- Added by Sharon Crasta on 3/14/2009 for CRF #0423 Facility/Enterprise -->\n\t\t\t\t\t<input type = \"hidden\" name= \"other_facilitychart_yn\" value = \"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n\t\t\t\t\n\t\t\t\t    <!--Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)-->\n\t\t\t\t\t<input type = \"hidden\" name= \"treatment_flag\" value = \"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"task_seq_no\" value = \"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"record_trmt_button_disabled\" value = \"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n\t\t\t\t\t<input type = \"hidden\" name= \"trmt_done_yn\" value = \"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t\t\t\t\t<!-- -->\n\t\t\t\t\t<!--  written by parul on 151008 for multiple surface -->\n\t\t\t\t\t<input type=\"hidden\" name=\'no_of_surface\' id=\'no_of_surface\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" > \n\n\t\t\t\t\t<!-- These variables are used in the developing Menu -->\n\t\t\t\t\t<input type=\"hidden\" name=\"function_id_list\" id=\"function_id_list\" value=\"\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"function_name_list\" id=\"function_name_list\" value=\"\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"function_type_list\" id=\"function_type_list\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"function_type_desc_list\" id=\"function_type_desc_list\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"function_cat_code_list\" id=\"function_cat_code_list\" value=\"\">\n\n\t\t\t\t\t<!--  written by parul on 24/08/2009 for CRF#0483 -->\n\t\t\t\t\t<input type=\"hidden\" name=\'cusptip_ref\' id=\'cusptip_ref\' value=\"\" >\n\t\t\t\t\t<input type = \"hidden\" name= \"surface_hid\" value = \"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"cusp_tip_code_hid\" value = \"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\"> \n\n\t\t\t\t\t<input type=\"hidden\" name=\'override_inc_exl\' id=\'override_inc_exl\' value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'reason_override_inc_exl\' id=\'reason_override_inc_exl\' value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'ext_perm_loc_param\' id=\'ext_perm_loc_param\' value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\" >\n\t\t\t\t\t<!-- Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700-->\n\t\t\t\t\t<input type=\"hidden\" name=\'dentist_comments\' id=\'dentist_comments\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"performed_In_OT\" id=\"performed_In_OT\" value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"dc_bl_episode_type\" id=\"dc_bl_episode_type\" value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t\t\t\t<!-- Added by yadav on 10/24/2009-->\n\t\t\t\t\t<input type=\"hidden\" name=\"ohContext\" id=\"ohContext\" value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\t\t\t\t\t<!-- Added by yadav on 1/19/2010-->\n\t\t\t\t\t<input type=\"hidden\" name=\"orderDate\" id=\"orderDate\" value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n\n\t\t\t\t\t<!-- Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages -->\n\t\t\t\t\t<input type=\"hidden\" name=\'super_tooth_ref\' id=\'super_tooth_ref\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" >\n\n\t\t\t\t\t<!-- Added by Sharon Crasta on 12/11/2009 for IN016953-->\n\t\t\t\t\t<input type=\"hidden\" name=\"trmt_status_param_extraction\" id=\"trmt_status_param_extraction\" value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n\n\t\t\t\t\t<!-- added by parul for SRR-CRF20056-0442 on 12/01/2010-->\n\t\t\t\t\t<input type=\"hidden\" name=\'surface_ref\' id=\'surface_ref\' value=\"\" >\n\n\t\t\t\t\t<!-- //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894 -->\n\t\t\t\t\t<input type=\"hidden\" name=\'super_key_num\' id=\'super_key_num\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\'ref_tooth_no\' id=\'ref_tooth_no\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" >\n\t\t\t\t\t<!-- Added by Sharon Crasta on 2/5/2010 for SRR20056-CRF-0485(IN010920) -->\n\t\t\t\t\t<input type=\"hidden\" name=\'task_status_orig\' id=\'task_status_orig\' value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" >\n\t\t\t\t\t<!-- -->\n\t\t\t\t\t<!-- Added by Sharon Crasta on 2/15/2010 for IN019319 -->\n\t\t\t\t\t<input type=\"hidden\" name=\'order_id_for_add\' id=\'order_id_for_add\' value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" >\n\t\t\t\t\t<!-- -->\n\t\t\t\t\t<input type = \"hidden\" name= \"selected_first_thno\" value = \"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"progression_ref\" value = \"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n\t\t\t\t\t<!-- Added by Sharon Crasta on 2/16/2010 for SRR20056-CRF-0475(IN010868)-->\n\t\t\t\t\t<input type = \"hidden\" name= \"pontic_tooth_values\" value = \"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\"> \n\t\t\t\t\t<input type = \"hidden\" name= \"tooth_range\" value = \"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\"> \n\n\t\t\t\t\t<input type=\"hidden\" name=\'sub_parts\' id=\'sub_parts\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" >\n\n\t\t\t\t\t<!-- Added by Sridevi Joshi on 8/20/2010 for IN023363 -->\n\t\t\t\t\t<input type=\"hidden\" name=\'oh_surface_hid\' id=\'oh_surface_hid\' value=\"\" >\n\n\t\t\t\t\t</form>\n\t\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t\t\t<table id=\'tooltiptable\' cellpadding=\"3\" cellspacing=0 border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'100%\' id=\'menu_table\' class=\"Menu\"></td>\n\t\t\t\t\t\t\t<!-- </td> -->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div> \n\t\t\t</body>\n\t\t</html>\n\t";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\n\n\n\n";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}

	
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(session.getAttribute("PREFERRED_STYLE")));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String or_bean_id 							= "Or_billingQueryBean";
	String or_bean_name 						= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request );
	or_bean.clearBean();

	Connection con=null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;			
	int treatment_status_param_int = 0;
	String sql = "";
	String disabled = ""; 
	String checked="";
	String val="";											    
	String disable_param="";
	//String ot_status_disable="";
	String disabled_bill_complete = "";
	String complication_code_selected = "";
	String trmt_order_catalog_code = "";
	String task_order_catalog_code = "";
	String record_charges_butn_disabled = "";
	String record_button_disabled = "";
	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	String record_trmt_button_disabled = "";
	//
	String oh_status_disabled = "";
	String result_completed = "N";
	String start_date = "";
	String start_time = "";
	String end_date = "";
	String end_time = "";
	String charging_stage = "";
	String no_of_surface = "2";//added by parul on 070109 ,taken for multiple surface 
	String dc_bl_episode_type = "";
	String trmt_ot_disable = "";


	//Added by Sharon Crasta on 10/3/2008 for the Registration Date and Time.
	String regn_date_time = "";

	//Added by Sharon Crasta on 10/20/2008--- Flag to disable the Treatment Start Date/ Time and Treatment End Date/Time
	String treatment_start_end_date_disabled_flag = "";

	int completed_count = 0;

	String[] startFields = null;
	String[] endFields = null;
			
	String otFlag=checkForNull(request.getParameter("called_from"));
	String params = request.getQueryString();
	
	String facility_id = (String)session.getValue("facility_id") ;
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;
	String patient_id = request.getParameter( "patient_id" ) ;
	String encounter_id = request.getParameter( "encounter_id" ) ;
	String patient_class = request.getParameter( "patient_class" ) ;
	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;
	String seq_no = request.getParameter( "seq_no" ) ;
	String trmt_done_yn = request.getParameter( "trmt_done_yn" ) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String mixed_dentition_YN = checkForNull(request.getParameter("mixed_dentition_YN"));
	String ref_tooth_no = checkForNull(request.getParameter("ref_tooth_no"));
	String tooth_range = checkForNull(request.getParameter("thrng_ref"));
	String trmt_level_flag = checkForNull(request.getParameter("trmt_level_flag"));//Added by Sridevi Joshi on 3/19/2010 for IN018200

	String code = checkForNull(request.getParameter("code"));
	String site = checkForNull(request.getParameter("site"));
	String type = checkForNull(request.getParameter("type"));
	String cat_code = checkForNull(request.getParameter("cat_code"));
	String arch_quad = checkForNull(request.getParameter("arch_quad"));
	String thrng_nos = checkForNull(request.getParameter("thrng_nos"));
	String outcome = checkForNull(request.getParameter("outcome"));
	String surface = checkForNull(request.getParameter("surface"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String task_code = checkForNull(request.getParameter("task_code"));
	
	String task_desc = checkForNull(request.getParameter("task_desc"));
	String ext_perm_loc_param = checkForNull(request.getParameter("ext_perm_loc_param"));

	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
	String remarks = checkForNull(request.getParameter( "remarks" )) ;
	String appt_reqd_yn = checkForNull(request.getParameter( "appt_reqd_yn" )) ;
	String display_tooth_no = checkForNull(request.getParameter( "display_tooth_no" )) ; // This value will be a range saperated by , or a single tooth no depending on the site type.This value is populated from RHS menu

	//billing params
	String bl_total_payable_for_trmt = checkForNull(request.getParameter("total_payable_for_trmt"));
	String bl_data_exists_yn = checkForNull(request.getParameter("bl_data_exists_yn"));
	String bl_key = checkForNull(request.getParameter("bl_key"));
	String billing_appl_yn = checkForNull(request.getParameter("billing_appl_yn"));
	String billed_yn = checkForNull(request.getParameter( "billed_yn" )) ;

	// Added for Billing. These columns have to be queried like other columns, before coming to this jsp.
	String bill_sub_regn_num		= checkForNull(request.getParameter( "bill_sub_regn_num" ));
	String bill_sub_regn_line_num	= checkForNull(request.getParameter( "bill_sub_regn_line_num" ));

	//Order Catalog Billable yn flag
	String order_catalog_bill_yn	= checkForNull(request.getParameter( "order_catalog_bill_yn" ));

	//newly added from dentalcondition.jsp
	String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	String header_tab = request.getParameter( "header_tab" ) ;
	String show_new_active_yn = checkForNull(request.getParameter( "show_new_active_yn" )) ;
	String thrng_nos_ref = checkForNull(request.getParameter( "thrng_nos_ref" )) ;
	String called_from_viewchart_yn = checkForNull(request.getParameter( "called_from_viewchart_yn" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;

	String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
	String flag = checkForNull(request.getParameter( "flag" )) ;

	String ind_chart_line_num = checkForNull(request.getParameter( "ind_chart_line_num" )) ; //Indivisual chart_line_num of a tooth in case of Tooth Range
	String complication_code = checkForNull(request.getParameter( "complication_code" )) ;
	String treatment_status_param = checkForNull(request.getParameter("treatment_status"));
	
	String start_date_time = checkForNull(request.getParameter("start_date_time"));//Added by Sharon Crasta on 10/9/2008 ---- Splits the date and time based on " " (space as delimiter)
	String end_date_time = checkForNull(request.getParameter("end_date_time"));//Added by Sharon Crasta on 10/9/2008 ---- Splits the date and time based on " " (space as delimiter)
	
	String status_disabled =  "";
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ; 
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
   	String add_new_yn =checkForNull(request.getParameter("add_new_yn")) ;
   	String add_new_done_flag =checkForNull(request.getParameter("add_new_done_flag")) ;
	
	
	String treatment_flag =checkForNull(request.getParameter("treatment_flag")) ;//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	String task_seq_no =checkForNull(request.getParameter("task_seq_no")) ;//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480),
	
	String cusp_tip_code = checkForNull(request.getParameter( "cusp_tip_code" )) ;
	String maxila_area = checkForNull(request.getParameter( "maxila_area" )) ;
	String maxila_parts = checkForNull(request.getParameter( "maxila_parts" )) ;
	String maxila_sub_parts = checkForNull(request.getParameter( "maxila_sub_parts" )) ;

	String dentist_comments = checkForNull(request.getParameter( "dentist_comments" )) ;//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700

	String flag1 = checkForNull(request.getParameter( "flag1" )) ;//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
	String super_key_num = checkForNull(request.getParameter( "super_key_num" )) ;//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894

	//Added by Sharon Crasta on 12/11/2009 for IN016953
	//Added because if after placing an extraction order the tooth is exfoliated or missing or unerupted or p[artially erupted, then the placed order should be cancelled.
	String treatment_status_param_for_extraction =  checkForNull(request.getParameter("trmt_status_for_extraction"));
	String failure_reason =  checkForNull(request.getParameter("failure_reason"));//added by parul on 28/02/2010 for CRF-477

	//End
	//Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0485(IN010920)
	String task_status_orig =  checkForNull(request.getParameter("task_status_orig"));

	//treatment_status_param = task_status_orig;
	//End
	//Added by Sharon Crasta on 2/15/2010 for IN019319
	String order_id_for_add = checkForNull(request.getParameter("order_id"));
	//End
	String selected_first_thno = checkForNull(request.getParameter( "selected_first_thno" )) ;//added by parul on 311008
	//Added by Sharon Crasta on 2/24/2010 for SRR20056-CRF-0475(IN010868)
	String pontic_tooth_values = checkForNull(request.getParameter( "pontic_tooth_values" )) ;
	//End
	String progress_note_group = "";
	String progression_ref = "";
	
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "";
	   date_diff_flag = "enable";
	   called_from_viewchart_yn = "N";
	}
			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	
	//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	//if((!other_chart_facility_id.equals(facility_id)) &&  (treatment_status_param.equals("25") || treatment_status_param.equals("52") || treatment_status_param.equals("55") || treatment_status_param.equals("80") || treatment_status_param.equals("60") || treatment_status_param.equals("85") || treatment_status_param.equals("75") || treatment_status_param.equals("90"))) { 
	if((!other_chart_facility_id.equals(facility_id)) &&  (treatment_status_param.equals("25") || treatment_status_param.equals("52") || treatment_status_param.equals("55") || treatment_status_param.equals("80") || treatment_status_param.equals("85") || treatment_status_param.equals("75") || treatment_status_param.equals("90"))) { 
		status_disabled = "disabled";
	} 

	if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable") || other_facilitychart_yn.equals("N")) { 
		status_disabled = "disabled";
	}

	if(baseline_chart_yn.equals("N") && other_facilitychart_yn.equals("Y")) {
		status_disabled = "disabled";
	} 
	 
	//
	//Legends
	String record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	String remarks_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	String cancel_reason_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CancelReason.label","or_labels");
	//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
	//String dentist_comments_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DentistComments.label","oh_labels");
	//
	if(start_date_time.indexOf(" ") != -1){
		startFields = start_date_time.split(" ");
		start_date = checkForNull(com.ehis.util.DateUtils.convertDate(startFields[0],"DMY","en",locale));
		start_time = startFields[1];
	}

	if(end_date_time.indexOf(" ") != -1){
		endFields = end_date_time.split(" ");
		end_date = checkForNull(com.ehis.util.DateUtils.convertDate(endFields[0],"DMY","en",locale));
		end_time = endFields[1];
	}

	if(treatment_status_param.equals("60") || treatment_status_param.equals("85") || treatment_status_param.equals("75") || treatment_status_param.equals("90")){
		result_completed = "Y";
	}

	
	/* Starts Block to disable the fields */

	if(treatment_status_param.equals("PLAN") || result_completed.equals("Y")){ // Initially the or_order_status would be null
		oh_status_disabled = "disabled";
	}

	if(result_completed.equals("Y") && !task_code.equals("")){
		disabled = "disabled";
	}

	if(billed_yn .equals("Y")  || (!result_completed.equals("Y"))){
		disabled_bill_complete = "disabled";
	}

	if(billed_yn.equals("Y")){
		record_charges_butn_disabled = "disabled";
	}

	if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){
		disabled = "disabled";
		oh_status_disabled = "disabled";
		status_disabled = "disabled";
	}	

	//Added by Sharon Crasta on 10/20/2008 -- Start Date/Time and End Date/Time is disabled once the treatment is done.
	if(treatment_status_param.equals("60") && result_completed.equals("Y") && !task_code.equals("") && trmt_done_yn.equals("Y")){
		 treatment_start_end_date_disabled_flag = "disabled";
	}

	//Added for IN015620 by Sridevi Joshi on 23/20/09
	if(ext_perm_loc_param.equals("Y") && treatment_status_param.equals("60")){
		treatment_start_end_date_disabled_flag = "disabled";
	}

	
	
	//Shifted from top to bottom of the block
	if(result_completed.equals("Y") && !task_code.equals("") && !trmt_done_yn.equals("Y") && billing_appl_yn.equals("Y")){
		record_button_disabled = disabled;
	} else {
		record_button_disabled = disabled;
	}
	/* Ends Block to disable the fields */

	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	if(treatment_flag.equals("Y") && !treatment_status_param.equals("E")){
			record_trmt_button_disabled = "disabled";
			record_charges_butn_disabled = "disabled";
	}
	//

	/* Starts Block for Record button legend */
	//charging_stage = "RST";
	if(treatment_status_param.equals("10") && appt_reqd_yn.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Schedule.label","common_labels");
	}
	else if(treatment_status_param.equals("10") && appt_reqd_yn.equals("N")){ // this condition is added by bshankar on 09FEB2008. If appt_reqd_yn is NO, there is no scheduling and directly registration has to be done
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels");
		charging_stage = "REG";
	}

	//if(treatment_status_param.equals("15")){
	if(treatment_status_param.equals("15") && !treatment_flag.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels");
		charging_stage = "REG";
	}
	
	if(treatment_status_param.equals("15") && treatment_flag.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
		
	}
	
	if(treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80")) {
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultEntry.label","or_labels");
		charging_stage = "RST";
	}

	if(result_completed.equals("Y") && !task_code.equals("") && billing_appl_yn.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultEntry.label","or_labels");
		charging_stage = "RST";
	}

	if(result_completed.equals("Y") && task_code.equals("")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	}

	if(treatment_status_param.equals("") || treatment_status_param.equals(null) || treatment_status_param.equals("null")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	}

	if(!treatment_status_param.equals("") && !treatment_status_param.equals("PLAN")){
		treatment_status_param_int = Integer.parseInt(treatment_status_param);
	}

	if(baseline_chart_yn.equals("Y")){
		record_button_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
	} 

	if(otFlag.equals("OT") && treatment_status_param_int<25){
		//trmt_ot_disable = "disabled";
	}

	/* Ends Block for Record button legend */

	try{
		con = ConnectionManager.getConnection(request);	
		if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT A.ORDER_CATALOG_CODE TRMT_ORDER_CATALOG_CODE, B.ORDER_CATALOG_CODE TASK_ORDER_CATALOG_CODE FROM OH_TREATMENT A, OH_TASKS B WHERE  A.TRMT_CODE = ? AND B.TASK_CODE = ?");
			pstmt.setString(1,trmt_code);
			pstmt.setString(2,task_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				trmt_order_catalog_code = checkForNull(rs.getString("TRMT_ORDER_CATALOG_CODE"));
				task_order_catalog_code = checkForNull(rs.getString("TASK_ORDER_CATALOG_CODE"));
			}
		}
        /* Below Code is added by sathish against CRF-0487 on 24-02-2010*/
		if(called_from_viewchart_yn.equals("Y")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			
			if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT PROGRESS_NOTE_GROUP FROM OH_TREATMENT  WHERE  TRMT_CODE = ?");
				pstmt.setString(1,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){	
					progress_note_group = checkForNull(rs.getString("PROGRESS_NOTE_GROUP"));
				}
			}
			else{
//				pstmt=con.prepareStatement("SELECT PROGRESS_NOTE_GROUP FROM OH_TREATMENT  WHERE OPERATING_FACILITY_ID=? AND TRMT_CODE = ?");
				pstmt=con.prepareStatement("SELECT PROGRESS_NOTE_GROUP FROM OH_TREATMENT  WHERE  TRMT_CODE = ?");
				// Modified by DhanasekarV  on may/07/2012
//				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){	
					progress_note_group = checkForNull(rs.getString("PROGRESS_NOTE_GROUP"));
				}
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

            if(oh_chart_level.equals("E")){
				pstmt=con.prepareStatement("SELECT PROGRESSION_REF FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM=?  AND TRMT_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){
					progression_ref = checkForNull(rs.getString("PROGRESSION_REF"));
				}
			}else{
				pstmt=con.prepareStatement("SELECT PROGRESSION_REF FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID= ? AND CHART_NUM = ? AND CHART_LINE_NUM=?  AND TRMT_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				rs = pstmt.executeQuery();
				while(rs.next()){
					progression_ref = checkForNull(rs.getString("PROGRESSION_REF"));
				}
			}
		}
		/* Added code by sathish ends here*/

		//Added for IN014255 by Sridevi Joshi

		if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT COUNT(*) COMPLETED_COUNT FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (25,53,52,55,75,90,70,60,85))");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				completed_count = Integer.parseInt(checkForNull(rs.getString("COMPLETED_COUNT"),"0"));
			}
		}


		if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement("SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ? AND EPISODE_TYPE =?");
			pstmt.setString(1,patient_class);
			pstmt.setString(2,episode_type);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dc_bl_episode_type = checkForNull(rs.getString("BL_EPISODE_TYPE"));
			}
	
//  Added by yadav on 1/13/2010 ,to get current Date in dd/MM/yyyy format  for CRF-443
		SimpleDateFormat df = null;
        String cDate = "";
		String cTime="";
		String timeStatus="";
		String dateStatus="";
		String orderDate="";
        Date aDate=new Date();
        if (aDate != null) {
            df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            cDate = df.format(aDate);
		String rDateTime=cDate.toString();
		String rDateTimerr[]=rDateTime.split(" ");
			cDate=checkForNull(com.ehis.util.DateUtils.convertDate(rDateTimerr[0],"DMY","en",locale));			
			//cTime=rDateTimerr[1];
        }
		


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(site));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(arch_quad));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(thrng_nos));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ref_tooth_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(treatment_status_param));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(outcome));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(surface));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(billed_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(billing_appl_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cusp_tip_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maxila_area));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maxila_parts));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maxila_sub_parts));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(failure_reason));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
										sql="SELECT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE LANGUAGE_ID = ? AND SPLTY_MODULE_ID = ? ORDER BY 2";
										pstmt=con.prepareStatement(sql);
										pstmt.setString(1,locale);
										pstmt.setString(2,"OH");
										rs=pstmt.executeQuery();
										while(rs.next()){
									
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rs.getString("TRMT_CATEGORY_TYPE")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("TRMT_CATEGORY_TYPE_DESC")));
            _bw.write(_wl_block19Bytes, _wl_block19);

										}
									
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block34Bytes, _wl_block34);


							 if (called_from_viewchart_yn.equals("Y")){
						
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

							   }else{
						  
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

								}
							
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

								if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && task_code != ""){
							
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(task_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);

								}
								else if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && task_code == "" &&  !treatment_flag.equals("Y")){
							
            _bw.write(_wl_block52Bytes, _wl_block52);

								}
							
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(oh_status_disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block55Bytes, _wl_block55);

									if((treatment_status_param.equals("") && (!called_from_viewchart_yn.equals("Y") || baseline_chart_yn.equals("Y")))){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668
								
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(treatment_status_param.equals("03") || treatment_status_param.equals("10") || treatment_status_param.equals("PLAN") || task_status_orig.equals("10")){
								
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(treatment_status_param.equals("15")){
								
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(treatment_status_param.equals("25")){
								
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(treatment_status_param.equals("53")){
								
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}
									else if(treatment_status_param.equals("52") ){
								
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}
									else if(treatment_status_param.equals("55") || treatment_status_param.equals("80")){
								
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}
									else if(treatment_status_param.equals("75")){ //Result Completed
								
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(treatment_status_param.equals("90")){ //Result Completed
								
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(treatment_status_param.equals("70")){ //Result Completed
								
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

									}else if(treatment_status_param.equals("60") || treatment_status_param.equals("85")){ //Result Completed
								
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(treatment_status_param.equals("") && called_from_viewchart_yn.equals("Y")){
								
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}else if(baseline_chart_yn.equals("Y") && called_from_viewchart_yn.equals("Y")){
								
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}
									//Added order_id_for_add.equals("") by Sharon Crasta on 2/15/2010 for IN019319
									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") &&  !treatment_flag.equals("Y") && !trmt_done_yn.equals("Y") && !order_id_for_add.equals("") && !date_diff_flag.equals("disable")){
								
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}

									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !result_completed.equals("Y") && treatment_flag.equals("Y") && completed_count == 0 && !date_diff_flag.equals("disable")) {
								
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}
									else if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !result_completed.equals("Y") && treatment_status_param_int < 25 && !task_code.equals("")  && !date_diff_flag.equals("disable")){
								
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									}
								
            _bw.write(_wl_block75Bytes, _wl_block75);

									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(cancel_reason_title));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(cancel_reason_title));
            _bw.write(_wl_block78Bytes, _wl_block78);

									}
            _bw.write(_wl_block79Bytes, _wl_block79);

									//if((treatment_status_param.equals("") && !called_from_viewchart_yn.equals("Y")) || (treatment_status_param.equals("10") || treatment_status_param.equals("PLAN")) && task_code == "" &&  !treatment_flag.equals("Y")) {
									//if((treatment_status_param.equals("") && task_code == "")  || (treatment_status_param.equals("10") || treatment_status_param.equals("PLAN"))) {
									//if(treatment_status_param.equals("") && task_code == "" &&  !treatment_flag.equals("Y")) {
									//if(!called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
									if(!called_from_viewchart_yn.equals("Y")){//removed condition for baseline_chart_yn by SRidevi Joshi on 5/31/2010 for IN021668--To show Remarks link for baseline closed chart
								
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(remarks_title));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(remarks_title));
            _bw.write(_wl_block81Bytes, _wl_block81);

									}
								 
            _bw.write(_wl_block82Bytes, _wl_block82);

									
									//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !result_completed.equals("Y") && treatment_status_param_int < 25){
									if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								
								
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

												if(rs != null) rs.close();
												if(pstmt != null) pstmt.close();
												//commented by parul on 01/06/2010 for IN021288 (only enabled tasks should populate on list)
												//sql="SELECT A.TASK_CODE,(SELECT B.TASK_DESC FROM OH_TASKS B WHERE A.TASK_CODE = B.TASK_CODE) TASK_DESC FROM OH_TREATMENT_TASKS A WHERE A.TRMT_CODE = ?";

												sql="SELECT A.TASK_CODE,(SELECT B.TASK_DESC FROM OH_TASKS B WHERE A.TASK_CODE = B.TASK_CODE) TASK_DESC FROM OH_TREATMENT_TASKS A,OH_TASKS B  WHERE A.TRMT_CODE = ?  AND B.EFF_STATUS = 'E' AND A.TASK_CODE=B.TASK_CODE";
												pstmt=con.prepareStatement(sql);
												pstmt.setString(1,trmt_code);
												rs=pstmt.executeQuery();
												while(rs.next()){	
									
								
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(rs.getString("TASK_CODE")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("TASK_DESC")));
            _bw.write(_wl_block57Bytes, _wl_block57);
	  
										}
								 
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

								
									}
									//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(cancel_reason_title));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cancel_reason_title));
            _bw.write(_wl_block93Bytes, _wl_block93);

								//	}
								
            _bw.write(_wl_block94Bytes, _wl_block94);
if(treatment_status_param_int>=15 && !treatment_flag.equals("Y")) {
							//The below code gets the order date and time from oh_restorative_chart_dtl table
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								sql="SELECT TO_CHAR(TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:mi') FROM oh_restorative_chart_dtl WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,chart_line_num);
								rs=pstmt.executeQuery();
								while(rs.next()){
									orderDate = com.ehis.util.DateUtils.convertDate(rs.getString(1),"DMY","en",locale);
								}
								String regDateTime="";
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								sql="SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,chart_line_num);
								pstmt.setString(4,trmt_code);
								pstmt.setString(5,task_code);
								pstmt.setString(6,task_seq_no);
								//pstmt.setString(6,facility_id);
								rs=pstmt.executeQuery();
								while(rs.next()){
									regDateTime = checkForNull(rs.getString(1));
									//Modified by rajesh for thai date conversion
									//regDateTime = checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString(1),"DMYHM","en",locale));
									//regDateTime = checkForNull(rs.getString(1));
								}
								if(regDateTime!=""){
									String regn_date_timeArr[]=regDateTime.split(" ");
									cDate=com.ehis.util.DateUtils.convertDate(regn_date_timeArr[0],"DMY","en",locale);
									cTime=regn_date_timeArr[1];
									}
							if(treatment_status_param_int>=25)
							{
								timeStatus="disabled";
								dateStatus="disabled";
							}
								
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(cDate));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(dateStatus));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(cTime));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(timeStatus));
            _bw.write(_wl_block99Bytes, _wl_block99);
 }
            _bw.write(_wl_block100Bytes, _wl_block100);

									// The below code gets the Performed in OT flag from the OH_RESTORATIVE_CHART_TASKS table
									if(rs != null) rs.close();
									if(pstmt != null) pstmt.close();
									sql="SELECT PERFORMED_IN_OT FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
									pstmt=con.prepareStatement(sql);
									pstmt.setString(1,patient_id);
									pstmt.setString(2,chart_num);
									pstmt.setString(3,chart_line_num);
									pstmt.setString(4,trmt_code);
									pstmt.setString(5,task_code);
									pstmt.setString(6,task_seq_no);
									//pstmt.setString(6,facility_id);
									rs=pstmt.executeQuery();
									while(rs.next()){
									String	returnOtFlag = checkForNull(rs.getString(1));
									if(treatment_status_param.equals("60"))
									{
									//ot_status_disable= "disabled";
										if(returnOtFlag.equals("Y"))
										{
										 disable_param = "disabled";
										 checked="checked";
										 val="Y";
										}
										//Added by Sharon Crasta on 3/31/2010 for IN018302
										else if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")) { 
											disable_param = "disabled";
											checked="";
											val="N";
										}//End
										else 
										{
											disable_param = "disabled";
											checked="";
											val="N";
										}
									}
									else if(!treatment_status_param.equals("60"))
									{
										if(otFlag.equals("OT"))
										{
										 disable_param = "disabled";
										 checked="checked";
										 val="Y";
										}
										else if(returnOtFlag.equals("Y"))
										{
										 disable_param = "";
										 checked="checked";
										 val="Y";
										}
										//Added by Sharon Crasta on 3/31/2010 for IN018302
										else if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")) { 
											disable_param = "disabled";
											checked="";
											val="N";
										}//End
										else 
										{ disable_param = "";
										 checked="";
										 val="";
										}
									}
							}	
							if(treatment_status_param_int>=25 && !treatment_flag.equals("Y") && !trmt_level_flag.equals("Y")) {//trmt_level_flag is added by Sridevi Joshi on 3/19/2010 for IN018200
								
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disable_param));
            _bw.write(_wl_block103Bytes, _wl_block103);
 }
            _bw.write(_wl_block104Bytes, _wl_block104);
 	
								//To display the Treatment Start Date/Time and Treatment End Date/Time only on click of tasks.
								if(task_code != "")	{
									if(treatment_status_param.equals("25") || treatment_status_param.equals("52") || treatment_status_param.equals("55") || treatment_status_param.equals("60") || treatment_status_param.equals("80") || treatment_status_param.equals("85") || treatment_status_param.equals("70")){
							
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

											// The below code gets the Registration date and time from the OH_RESTORATIVE_CHART_TASKS table
											if(rs != null) rs.close();
											if(pstmt != null) pstmt.close();
											//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
											//sql="SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? ";
											sql="SELECT TO_CHAR(REGN_DATE_TIME,'DD/MM/YYYY HH24:mi') FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
											pstmt=con.prepareStatement(sql);
											pstmt.setString(1,patient_id);
											pstmt.setString(2,chart_num);
											pstmt.setString(3,chart_line_num);
											pstmt.setString(4,trmt_code);
											pstmt.setString(5,task_code);
											pstmt.setString(6,task_seq_no);
											//pstmt.setString(6,facility_id);
											rs=pstmt.executeQuery();
											while(rs.next()){
												regn_date_time = checkForNull(rs.getString(1));
											}

											
										
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(treatment_start_end_date_disabled_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(treatment_start_end_date_disabled_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(treatment_start_end_date_disabled_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block112Bytes, _wl_block112);
if(!ext_perm_loc_param.equals("Y")){
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(treatment_start_end_date_disabled_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(treatment_start_end_date_disabled_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(treatment_start_end_date_disabled_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block120Bytes, _wl_block120);
if(!ext_perm_loc_param.equals("Y")){
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block121Bytes, _wl_block121);

									}
								}	
							
            _bw.write(_wl_block122Bytes, _wl_block122);

							if(result_completed.equals("Y") && task_code == ""){
						
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
//=oh_status_disabled
            _bw.write(_wl_block15Bytes, _wl_block15);
//=disabled
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(status_disabled));
//=oh_status_disabled
            _bw.write(_wl_block15Bytes, _wl_block15);
//=disabled
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

												if(rs != null) rs.close();
												if(pstmt != null) pstmt.close();
												sql="SELECT A.COMPLICATION_CODE COMPLICATION_CODE, A.COMPLICATION_DESC COMPLICATION_DESC FROM OH_COMPLICATION_LANG_VW A, OH_COMPLICATION_TRMT_CAT_TYPE B WHERE A.COMPLICATION_CODE = B.COMPLICATION_CODE AND LANGUAGE_ID = ? AND B.TRMT_CATEGORY_TYPE = ? ORDER BY 2";
												pstmt=con.prepareStatement(sql);
												pstmt.setString(1,locale);
												pstmt.setString(2,type);
												rs=pstmt.executeQuery();
												while(rs.next()){
													if(complication_code.equals(rs.getString("COMPLICATION_CODE"))){
														complication_code_selected = "selected";
													}
													else{
														complication_code_selected = "";
													}
											
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(rs.getString("COMPLICATION_CODE")));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(complication_code_selected));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(rs.getString("COMPLICATION_DESC")));
            _bw.write(_wl_block132Bytes, _wl_block132);

												}
											
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);

							}

						
            _bw.write(_wl_block138Bytes, _wl_block138);

								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !treatment_flag.equals("Y")){
								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								if(called_from_viewchart_yn.equals("Y")){//removed condition for baseline_chart_yn by SRidevi Joshi on 5/31/2010 for IN021668--To show diagnosis/Remarks link for baseline closed chart
							
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(remarks_title));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(remarks_title));
            _bw.write(_wl_block140Bytes, _wl_block140);

											if(!treatment_status_param.equals("") && result_completed.equals("Y") && task_code.equals("")){ 
										
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(cat_code));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

											}	
										
            _bw.write(_wl_block144Bytes, _wl_block144);

								}
								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && treatment_status_param_int > 25){
									
								if(called_from_viewchart_yn.equals("Y")  && treatment_status_param_int > 15){
							
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(type));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(type));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(cancel_reason_title));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cancel_reason_title));
            _bw.write(_wl_block148Bytes, _wl_block148);

								}
								if(called_from_viewchart_yn.equals("Y")  && treatment_status_param_int > 15){
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(task_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(progress_note_group));
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
	}
							
            _bw.write(_wl_block152Bytes, _wl_block152);

								
								String temp_disable = "N"; // Can be used for temporarily disabling the Billing flag
								
								//if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
								if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y") && !treatment_flag.equals("Y")){
									if(billing_appl_yn.equals("Y") && temp_disable.equals("N") && !task_code.equals("") && order_catalog_bill_yn.equals("Y")){
										if((treatment_status_param.equals("10") && appt_reqd_yn.equals("N")) || treatment_status_param.equals("15")|| treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80") || result_completed.equals("Y")) {
										//if(treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80") || result_completed.equals("Y")) {
							
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
//=disabled_bill_complete
            _bw.write(_wl_block155Bytes, _wl_block155);

												//if(!billed_yn.equals("Y")){
												
												if(!treatment_status_param.equals("60")){ 
													if(!status_disabled.equals("disabled")){

											
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(task_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bill_sub_regn_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bill_sub_regn_line_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(record_charges_butn_disabled));
            _bw.write(_wl_block159Bytes, _wl_block159);

												}else{
											
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

												}
											}
											
            _bw.write(_wl_block162Bytes, _wl_block162);

										}
									}
								}
								
								if(called_from_viewchart_yn.equals("Y") && !baseline_chart_yn.equals("Y")){
									if(billing_appl_yn.equals("Y") && temp_disable.equals("N") && !task_code.equals("") && order_catalog_bill_yn.equals("Y")){
										if(treatment_status_param.equals("25") || treatment_status_param.equals("52")|| treatment_status_param.equals("55")|| treatment_status_param.equals("80") || result_completed.equals("Y")) {
							
            _bw.write(_wl_block163Bytes, _wl_block163);

										}
										else{
							
            _bw.write(_wl_block164Bytes, _wl_block164);

										}
									}
									else{
							
            _bw.write(_wl_block165Bytes, _wl_block165);

									}
								}
								else{
							
            _bw.write(_wl_block166Bytes, _wl_block166);

								}
							
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(record_button_legend));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(treatment_status_param));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(record_button_disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record_trmt_button_disabled));
            _bw.write(_wl_block170Bytes, _wl_block170);

								 
							   if(treatment_flag.equals("Y")){
							 
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(record_button_legend));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(treatment_status_param));
            _bw.write(_wl_block172Bytes, _wl_block172);
	
							
							}else{
							 
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(record_button_legend));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(treatment_status_param));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(record_button_disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record_trmt_button_disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trmt_ot_disable));
            _bw.write(_wl_block173Bytes, _wl_block173);

							}
							
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(mixed_dentition_YN));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(chart_type));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(header_tab));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(show_new_active_yn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(thrng_nos_ref));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(thrng_nos));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(called_from_viewchart_yn));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(ind_chart_line_num));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(cat_code));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(display_tooth_no));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(params));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(treatment_status_param));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(outcome));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(treatment_status_param));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(checkForNull(request.getParameter( "order_id" ))));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(checkForNull(request.getParameter( "order_line_num" ))));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(checkForNull(request.getParameter( "task_code" ))));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(java.net.URLEncoder.encode(task_desc,"UTF-8")));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(date_diff_flag));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(arch_quad));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(checkForNull(request.getParameter( "order_id" ))));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(checkForNull(request.getParameter( "appt_ref_no" ))));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(appt_reqd_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(checkForNull(request.getParameter( "order_line_num" ))));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(checkForNull(request.getParameter("bl_total_charge"))));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(checkForNull(request.getParameter("bl_task_charge"))));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(trmt_order_catalog_code));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(task_order_catalog_code));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(billing_appl_yn));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(bl_key));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(bl_total_payable_for_trmt));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(charging_stage));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(bill_sub_regn_num));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(bill_sub_regn_line_num));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(bl_data_exists_yn));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(billed_yn));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(order_catalog_bill_yn));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(regn_date_time));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(treatment_flag));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(task_seq_no));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(record_trmt_button_disabled));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(trmt_done_yn));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(no_of_surface));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(surface));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(cusp_tip_code));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(ext_perm_loc_param));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(dentist_comments));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(val));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(dc_bl_episode_type));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(orderDate));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(flag1));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(treatment_status_param_for_extraction));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(super_key_num));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(ref_tooth_no));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(task_status_orig));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(order_id_for_add));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(selected_first_thno));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(pontic_tooth_values));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(tooth_range));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(maxila_sub_parts));
            _bw.write(_wl_block263Bytes, _wl_block263);

	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		   }catch(Exception es){es.printStackTrace();}
	}
	
            _bw.write(_wl_block264Bytes, _wl_block264);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DentistComments.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Site.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Surface.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Surface.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.CuspTip.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TaskCode.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ordered.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Planned.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registered.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InProgress.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.PartiallyResulted.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ordered.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MarkError.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TasksApplicable.Label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Sequence.Label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.RowAbove.Label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.RowBelow.Label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.RegDateTime.Label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PerformedinOT.Label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.StartDate.Label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.EndDate.Label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Success.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Failure.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complications.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.FailureReason.Label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.LinkDiagCondition.Label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TreatmentDetails.Label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ComplicationDetails.Label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ProgressNotes.Label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ChargesCompletedYN.Label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.EditCharges.Label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.RecordCharges.Label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.EditCharges.Label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reset.label", java.lang.String .class,"key"));
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
}
