package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __morecordpostmortem extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MORecordPostmortem.jsp", 1742812868666L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" <!--json  by mujafar for ML-MMOH-CRF-0880 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head> \n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\n\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\" ></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eMO/js/MOManageDeceased.js\'></script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n </head>\n  \n <body OnMouseDown=\'CodeArrest()\' onLoad=\"enablePMDtls(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');enableSpecGif();\" onKeyDown=\"lockKey()\" >\t \n <form name=\"MORecordPostmortem\" id=\"MORecordPostmortem\"  action=\"../../servlet/eMO.MOManageDeceasedAssignAreaServlet\"  method=\"post\" target=\"messageFrame\" >\n\n<!-- \n <a name=\"tab1\"   onFocus=\'javascript:AEScrollIntoView(1);\'></a>\n <table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\' >\n <tr><td width=\'1%\' class=\'BODYCOLORFILLED\'></td><td  class=\'BODYCOLORFILLED\' >&nbsp;&nbsp;<a align =\'left\' href=\"javascript:AEScrollIntoView(1)\" style=\"cursor:pointer;\" ><img src=\'../../eMO/images/Registration.gif\' border=0 ></a>\n <a align=\'left\' href=\"javascript:AEScrollIntoView(2)\"><img   src=\"../../eMO/images/FindingsClick.gif\" border=0 id=\'hidetab2\'  style=\"visibility:hidden\"></a>\n <a align=\'left\' href=\"javascript:AEScrollIntoView(3)\" tabindex=\'-1\' ><img src=\"../../eMO/images/SpecimenClick.gif\" id=\'hidetab3\' style=\"visibility:hidden\" border=0></a>\n <a align=\'left\'  href=\"javascript:AEScrollIntoView(4)\" tabindex=\'-1\' ><img src=\"../../eMO/images/TissueProcurementClick.gif\" id=\'hidetab4\' style=\"visibility:hidden\" border=0></a>&nbsp;\n </td>\n </tr> \n </table>\n\n -->\n\n<a name=\"tab1\"  tabindex=\'0\' onFocus=\'javascript:AEScrollIntoView(1);\'></a> \t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Registration\">\n\t\t\t<a onclick=\"AEScrollIntoView(1)\"  class=\"tabClicked\" id=\"1\" ><span class=\"tabSpanclicked \" id=\"regs_tabspan\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Find\" id=\'hidetab2\' style=\"display:none\">\n\t\t\t<a onclick=\"AEScrollIntoView(2)\" class=\"tabA\" id=\"2\" ><span class=\"tabASpan\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Specimen\"  id=\'hidetab3\'  style=\"visibility:hidden\">\n\t\t\t<a onclick=\"AEScrollIntoView(3)\" class=\"tabA\" id=\"3\" ><span class=\"tabASpan\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"TissueProcurement\" id=\'hidetab4\' style=\"visibility:hidden\">\n\t\t\t<a onclick=\"AEScrollIntoView(4)\" class=\"tabA\" id=\"4\" ><span class=\"tabASpan\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n <tr> \t  \n <td class=\'label\' width=\'30%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n <td width=\'30%\' class=\'fields\' ><INPUT TYPE=\"text\" size=30 maxlength=30 onBLur=\"beforeGetPractitioner(this,\'pract_but14\',pract14)\" name=\"pract_desc14\" id=\"pract_desc14\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"><input type=\'button\' class=\'button\'  name=\'pract_but14\' id=\'pract_but14\' value=\'?\' onClick=\"getValues(this,pract_desc14,pract14)\";><img src=\'../../eCommon/images/mandatory.gif\'><input type=hidden name=\'pract14\' id=\'pract14\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></td>\n <td class=\'label\' width=\'30%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n <td  class=\'label\' width=\'10%\'><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></td>\n </tr>\n <!-- <tr><td colspan=5>&nbsp;</Td></tr> -->\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n <td colspan=\'3\' class=\'fields\' ><TEXTAREA NAME=\"PM_PURPOSE\" ROWS=\"2\" COLS=\"50\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TEXTAREA><img src=\'../../eCommon/images/mandatory.gif\'><!-- <INPUT TYPE=\"text\" name=\"PM_PURPOSE\" id=\"PM_PURPOSE\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  maxlength=250 size=40 > --> </td></tr>\n <tr>\n <Td class=\'label\' colspan=\'4\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></Td>\n </tr>\n <tr>\n <th class=\'columnheader\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n <th class=\'columnheader\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th> \n <th class=\'columnheader\' colspan=\'2\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</Th>\n </tr> \n <tr>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"post_perf_pract_desc1\" id=\"post_perf_pract_desc1\" maxlength=30  onBlur=\"beforeGetPractitioner(this,\'post_perf_pract_but\',post_perf_pract1)\" size=30 value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><INPUT TYPE=\"hidden\" name=\"post_perf_pract1\" id=\"post_perf_pract1\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><input type=\'button\' class=\'button\' readOnly name=\'post_perf_pract_but\' id=\'post_perf_pract_but\' value=\'?\' onClick=\"getValues(this,post_perf_pract_desc1,post_perf_pract1)\";></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"post_perf_desig_desc1\" id=\"post_perf_desig_desc1\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"\n  size=30  disabled></td>\n  <td colspan=\'2\' class=\'fields\'><INPUT TYPE=\"text\"  maxlength=15 name=\"post_perf_role1\" id=\"post_perf_role1\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n  </tr> \n <tr>\n <Td colspan=\'4\' class=\'label\'><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</Th>\n </tr>\n <tr>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pract_desc1\" id=\"pract_desc1\" maxlength=30  onBlur=\"beforeGetPractitioner(this,\'pract_but\',pract1)\" size=30 value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><INPUT TYPE=\"hidden\" name=\"pract1\" id=\"pract1\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"><input type=\'button\' class=\'button\' readOnly name=\'pract_but\' id=\'pract_but\' value=\'?\' onClick=\"getValues(this,pract_desc1,pract1)\";></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"desig_desc1\" id=\"desig_desc1\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"\n  size=30  disabled></td><td colspan=\'2\' class=\'fields\'><INPUT TYPE=\"text\"  maxlength=15 name=\"role1\" id=\"role1\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"></td>\n  </tr>\n  <tr>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pract_desc2\" id=\"pract_desc2\" maxlength=30 onBlur=\"beforeGetPractitioner(this,\'pract_but1\',pract2)\" size=30 value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><INPUT TYPE=\"hidden\" name=\"pract2\" id=\"pract2\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><input type=\'button\' class=\'button\' readOnly name=\'pract_but1\' id=\'pract_but1\' value=\'?\' onClick=\"getValues(this,pract_desc2,pract2)\";></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"desig_desc2\" id=\"desig_desc2\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"size=30 disabled></td>\n  <td colspan=\'2\' class=\'fields\'><INPUT TYPE=\"text\" name=\"role2\" id=\"role2\" maxlength=15 value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"></td>\n  </tr>\n  <tr>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pract_desc3\" id=\"pract_desc3\" maxlength=15  onBlur=\'PractLookupRetVal(this.value,this.name)\'  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  size=30></td>\n  <input type=hidden name=\'pract3\' id=\'pract3\' value=\'ignore\'>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"desig_desc3\" id=\"desig_desc3\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=30 ></td>\n  <td colspan=\'2\' class=\'fields\'><INPUT TYPE=\"text\" name=\"role3\" id=\"role3\" maxlength=15   value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n  </td>\n\n  \n <!--  <td ><INPUT TYPE=\"text\" name=\"pract_desc3\" id=\"pract_desc3\" maxlength=30 onBlur=\"beforeGetPractitioner(this,\'pract_but3\',pract3)\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" size=30><INPUT TYPE=\"hidden\" name=\"pract3\" id=\"pract3\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"><input type=\'button\' class=\'button\' readOnly name=\'pract_but3\' id=\'pract_but3\' value=\'?\' onClick=\"getValues(this,pract_desc3,pract3)\";></td>\n  <td colspan=2 align=center><INPUT TYPE=\"text\" name=\"desig_desc3\" id=\"desig_desc3\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" size=30 disabled></td>\n  <td colspan=2 align=center><INPUT TYPE=\"text\" name=\"role3\" id=\"role3\" maxlength=15  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" ></td>\n  --> </tr>\n  <tr>\n\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pract_desc4\" id=\"pract_desc4\" maxlength=15  onBlur=\'PractLookupRetVal(this.value,this.name)\'  value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"  size=30></td>\n  <input type=hidden name=\'pract4\' id=\'pract4\' value=\'ignore\'>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"desig_desc4\" id=\"desig_desc4\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" size=30 ></td>\n  <td colspan=\'2\' class=\'fields\'><INPUT TYPE=\"text\" name=\"role4\" id=\"role4\" maxlength=15   value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n  </td>\n  </tr>\n  <tr>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pract_desc5\" id=\"pract_desc5\" maxlength=15 value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"  onBlur=\'PractLookupRetVal(this.value,this.name)\' size=30></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"desig_desc5\" id=\"desig_desc5\"  value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" size=30 ></td>\n\t  <input type=hidden name=\'pract5\' id=\'pract5\' value=\'ignore\'>\n  <td colspan=\'2\' class=\'fields\'><INPUT TYPE=\"text\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" NAME=\"role5\" maxlength=15 ></td>\n</tr>\n<tr>\n<td colspan=\'4\' class=\'label\'><b>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =":</b></td>\n</tr>\n<tr>\n<th class=\'columnheader\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</th>\n<th class=\'columnheader\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</th>\n<th class=\'columnheader\' colspan=\'2\'></th>\n</tr> \n <tr>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pract6\" id=\"pract6\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" maxlength=30 size=30></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"desi1\" id=\"desi1\"  maxlength=30 value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"size=30 ></td>\n  <td colspan=\'2\' ></td>\n  </tr>\n  <tr>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pract7\" id=\"pract7\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"  maxlength=30 size=30></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"desi2\" id=\"desi2\" maxlength=30 value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"size=30 ></td>\n  <td colspan=\'2\' ></td> \n  </tr> \n <tr>\n\t<th colspan=\'4\' class=\'querydata\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</th>\n</tr>\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;</td>\n <td class=\'label\'><b>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</b></td>\n <td class=\'label\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n <td class=\'label\'><label id=hrmindiff></label></td>\n </tr>\n <tr>\n <td class=\'label\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"pm_start_date_time\" id=\"pm_start_date_time\"  maxlength=16 value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" onBlur=\'validateDate(this);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'pmstart\' onClick=\"document.forms[0]. pm_start_date_time.select();return showCalendar(\'pm_start_date_time\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n <td class=\'label\' >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n <td class=\'label\'><label id=endhrmindiff></label></td>\n </tr>\n <tr>\n <td class=\'label\' >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n <td  class=\'fields\'><INPUT TYPE=\"text\" name=\"pm_end_date_time\" id=\"pm_end_date_time\" maxlength=16  readOnly onBlur=\'validateDate1(this);\' value=\t\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'pmcmpdis\' disabled onClick=\"document.forms[0].pm_end_date_time.select();return showCalendar(\'pm_end_date_time\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n <!--Below field added by Mano Aganist ML-MMOH-CRF-0791 -->\n ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t<td class=\'fields\'>\n\t\t<Select name=\'examination_type\' id=\'examination_type\'>\n\t\t<Option value=\'N\' ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="selected";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</Option>\n\t\t<option value=\'I\' ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option>\n\t    <option value=\'E\' ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</option></td>\n   ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<input type=\"hidden\" name=\'examination_type\' id=\'examination_type\' value = \'N\'/>\n ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<!--End of ML-MMOH-CRF-0791-->\n </tr>\n<tr><td colspan=\'4\'>&nbsp;<td></tr>\n </table> \n <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n \n\n <a name=\"tab4\"  tabindex=\'11\' onFocus=\'javascript:AEScrollIntoView(4);\'></a> \t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Registration\">\n\t\t\t<a onclick=\"AEScrollIntoView(1)\"   class=\"tabA\" id=\"1\" ><span class=\"tabASpan\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Find\"  id=\'hidetab9\' style=\"display:none\"  > <!-- modified by mujafar for ML-MMOH-CRF-0880 -->\n\t\t\t<a onclick=\"AEScrollIntoView(2)\"  class=\"tabA\" id=\"2\" ><span  class=\"tabASpan\" >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Specimen\" >\n\t\t\t<a onclick=\"AEScrollIntoView(3)\" class=\"tabA\" id=\"3\" ><span class=\"tabASpan\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"TissueProcurement\" id=\'hidetis7\' style=\"if(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>0) visibility:hidden;else visibility:visible\">\n\t\t\t<a onclick=\"AEScrollIntoView(4)\" class=\"tabClicked\" id=\"4\" ><span class=\"tabSpanclicked\" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\n\t <!-- <a name=\"tab4\" tabindex=\'11\' onfocus=\'javascript:AEScrollIntoView(2);\' ></a>\n\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\'><tr><td width=\'1%\' class=\'BODYCOLORFILLED\'>&nbsp;&nbsp;&nbsp;&nbsp;<a align=\'left\'href=\"javascript:AEScrollIntoView(1);\" tabindex=\'-1\'><img src=\"../../eMO/images/RegistrationClick.gif\" border=0></a><a align=\'left\' href=\"javascript:AEScrollIntoView(2)\"><img  src=\"../../eMO/images/FindingsClick.gif\" border=0 ></a><a align=\'left\' href=\"javascript:AEScrollIntoView(3);\" tabindex=\'-1\' ><img src=\"../../eMO/images/SpecimenClick.gif\"   border=0></a><a align=\'left\' href=\"javascript:AEScrollIntoView(4)\" tabindex=\'-1\' ><img src=\"../../eMO/images/TissueProcurement.gif\" id=\'hidetis7\'  style=\"if(\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>0) visibility:hidden;else visibility:visible\" border=0></a>&nbsp;</td></tr></table>\t-->\n\n<table width=\'100%\' cellpadding=\'0\' align=center cellspacing=\'0\' BORDER=\'0\'> \n<tr>\n<th class=\'columnheader\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</th>\n<th colspan=2 class=\'columnheader\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</th>\n\n</tr>\n\n\t \n\t  \n ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\t\n  \n<tr>\n<td class=\'label\'><B>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</B></td>\n<td  class=\'fields\'>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\t\n<INPUT TYPE=\"checkbox\" name=\"org";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"org";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" onClick=\"clearTissueProc(this,tissue";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =",\'tis";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\',\'tissueimg";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\')\" checked ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'> </td>\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t<INPUT TYPE=\"checkbox\" name=\"org";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"  ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" onClick=\"clearTissueProc(this,tissue";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\')\" value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n<td class=\'fields\' colspan=\'2\' ><INPUT TYPE=\"text\"  maxlength=16  disabled value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' NAME=\"tissue";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" onBlur=\"validateDate1(this);\">\t<img src=\"../../eCommon/images/CommonCalendar.gif\" disabled id=\'tis";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' onClick=\"document.forms[0].tissue";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =".select();return showCalendar(\'tissue";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img id=\'tissueimg";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\t\n</tr>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n<tr><td class=\'label\' colspan=4>&nbsp;</td></tr>\n<tr><td class=\'label\' colspan=4>&nbsp;</td></tr>\n</table>\n<table width=\'100%\' align=center cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\'>\n<tr>\t<td class=\'label\' colspan=4>&nbsp;</td></tr>\n<tr><td class=\'label\' colspan=4>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="&nbsp;</td>\n<td class=\'fields\'><INPUT TYPE=\"text\" name=\"tissue_procured_by\" id=\"tissue_procured_by\" size=40 maxlength=30 onBlur=\"beforeGetPractitioner(this,\'pract_but13\',pract13)\" ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"><INPUT TYPE=\"hidden\" name=\"pract13\" id=\"pract13\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"><input type=\'button\' class=\'button\' ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" name=\'pract_but13\' value=\'?\' onClick=\"getValues(this,tissue_procured_by,pract13)\";><img src=\'../../eCommon/images/mandatory.gif\' id=\'imgenable6\' style=\"visibility:hidden\" ></td>\n<td class=\'label\' >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n<td class=\'fields\'><INPUT TYPE=\"text\" name=\"tissue_proc_date\" id=\"tissue_proc_date\"   ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" maxlength=16 value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"onBlur=\"validateDate1(this);\"><img ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].tissue_proc_date.select();return showCalendar(\'tissue_proc_date\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'imgenable7\' style=\"visibility:hidden\"></td>\n\n</tr>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n<tr><td class=\'label\' colspan=4>&nbsp;</td></tr>\n<tr><td class=\'label\' colspan=4>&nbsp;</td></tr>\n</table>\n <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n <a name=\"tab2\"  onFocus=\'javascript:AEScrollIntoView(3);\'></a> \t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Registration\">\n\t\t\t<a onclick=\"AEScrollIntoView(1)\"   class=\"tabA\" id=\"1\" ><span class=\"tabASpan\" >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Find\" id=\'hidetab8\' style=\"display:none\"  > <!-- modified by mujafar for ML-MMOH-CRF-0880 -->\n\t\t\t<a onclick=\"AEScrollIntoView(2)\"  class=\"tabA\" id=\"2\" ><span  class=\"tabASpan\" >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Specimen\" >\n\t\t\t<a onclick=\"AEScrollIntoView(3)\" class=\"tabClicked\" id=\"3\" ><span class=\"tabSpanclicked\">";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"TissueProcurement\" id=\'hidetis5\' style=\"visibility:hidden\">\n\t\t\t<a onclick=\"AEScrollIntoView(4)\" class=\"tabA\" id=\"4\" ><span class=\"tabASpan\" >";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\n<!--<a name=\"tab2\"  onFocus=\'javascript:AEScrollIntoView(3);\'></a> \n<table width=\'100%\' cellpadding=\'0\'   cellspacing=\'0\' BORDER=\'0\'><tr><td width=\'1%\' class=\'BODYCOLORFILLED\'></td><td width=\'50%\' class=\'BODYCOLORFILLED\'>&nbsp;<a align =\'left\' href=\"javascript:AEScrollIntoView(1)\"><img src=\"../../eMO/images/RegistrationClick.gif\" border=0></a><a align=\'left\' href=\"javascript:AEScrollIntoView(2)\" tabindex=\'-1\'><img src=\"../../eMO/images/FindingsClick.gif\" border=0  ></a><a align=\'left\'  href=\"javascript:AEScrollIntoView(3)\" tabindex=\'-1\' ><img src=\"../../eMO/images/Specimen.gif\" border=0></a><a align=\'left\'  href=\"javascript:AEScrollIntoView(4)\" tabindex=\'-1\' ><img src=\"../../eMO/images/TissueProcurementClick.gif\" id=\'hidetis5\' style=\"visibility:hidden\" border=0></a></td></tr>\n</table>-->\n\n<table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=0 align=\'center\'>\n \n \n<tr><td colspan=4 class=\'label\' ><b>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =":</b></td></tr>\t\n  <tr>\n  <th class=\'columnheader\' width=\'25%\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</th>\n  <th class=\'columnheader\' width=\'25%\'>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</th>\n  </tr>\n <tr>\n  <td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" name=\"speci_desc1\" id=\"speci_desc1\"  onblur=\"enableSpecGif();\" maxlength=40 value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" ><img id=\'specimagae1\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td></td>\n  <td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" name=\"speci_type1\" id=\"speci_type1\"   onblur=\"enableSpecGif();\" maxlength=50 value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"><img id=\'specitypeimage1\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" name=\"anotomical_site_desc1\" id=\"anotomical_site_desc1\"   maxlength=30 onblur=\" beforeAnotomicalSiteClick(this,\'anot1\');enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"  ><input type=\'button\' class=\'button\' readOnly name=\'anot1\' id=\'anot1\' value=\'?\' onClick=\" getAnotimicalDetail(this,\'anotomical_site_desc1\',\'anotomical_site_code1\')\";><img id=\'specanotimagae1\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" name=\"collection_time1\" id=\"collection_time1\"  maxlength=16  onBlur=\"validateDate1(this);enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'col1\' onClick=\"document.forms[0].collection_time1.select();return showCalendar(\'collection_time1\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img id=\'specollimagae1\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"><input type=hidden name=\'anotomical_site_code1\' id=\'anotomical_site_code1\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"></td>\n  </tr>\n  <tr> \n  <td class=\'fields\' ><INPUT TYPE=\"text\" name=\"speci_desc2\" id=\"speci_desc2\"  onblur=\"enableSpecGif();\"  maxlength=40 value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"><img id=\'specimagae2\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\' ><INPUT TYPE=\"text\" name=\"speci_type2\" id=\"speci_type2\"   onblur=\"enableSpecGif();\"maxlength=50 value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" ><img id=\'specitypeimage2\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\' ><INPUT TYPE=\"text\" name=\"anotomical_site_desc2\" id=\"anotomical_site_desc2\" maxlength=30 onblur=\" beforeAnotomicalSiteClick(this,\'anot2\');enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"><input type=\'button\' class=\'button\' readOnly name=\'anot2\' id=\'anot2\' value=\'?\' onClick=\" getAnotimicalDetail(this,\'anotomical_site_desc2\',\'anotomical_site_code2\')\";><img id=\'specanotimagae2\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\' ><INPUT TYPE=\"text\" name=\"collection_time2\" id=\"collection_time2\" maxlength=16  onBlur=\"validateDate1(this); enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'col2\' onClick=\"document.forms[0].collection_time2.select();return showCalendar(\'collection_time2\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img id=\'specollimagae2\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"><input type=hidden name=\'anotomical_site_code2\' id=\'anotomical_site_code2\'  value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"></td>\n  </tr>\n  <tr> \n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_desc3\" id=\"speci_desc3\" onblur=\"enableSpecGif();\" maxlength=40 value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"><img id=\'specimagae3\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_type3\" id=\"speci_type3\"  onblur=\"enableSpecGif();\" maxlength=50 value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\"><img id=\'specitypeimage3\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"anotomical_site_desc3\" id=\"anotomical_site_desc3\"  maxlength=30 onblur=\" beforeAnotomicalSiteClick(this,\'anot3\');enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\"><input type=\'button\' class=\'button\' readOnly name=\'anot3\' id=\'anot3\' value=\'?\'onClick=\" getAnotimicalDetail(this,\'anotomical_site_desc3\',\'anotomical_site_code3\')\"><img id=\'specanotimagae3\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"collection_time3\" id=\"collection_time3\" maxlength=16  onBlur=\"validateDate1(this);enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'col3\' onClick=\"document.forms[0].collection_time3.select();return showCalendar(\'collection_time3\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img id=\'specollimagae3\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"><input type=hidden name=\'anotomical_site_code3\' id=\'anotomical_site_code3\'  value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"></td>\n  </tr>\n  <tr> \n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_desc4\" id=\"speci_desc4\" onblur=\"enableSpecGif();\" maxlength=40 value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"><img id=\'specimagae4\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_type4\" id=\"speci_type4\" onblur=\"enableSpecGif();\" maxlength=50 value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"><img id=\'specitypeimage4\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"anotomical_site_desc4\" id=\"anotomical_site_desc4\"  maxlength=30  onblur=\" beforeAnotomicalSiteClick(this,\'anot4\');enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"><input type=\'button\' class=\'button\' readOnly name=\'anot4\' id=\'anot4\' value=\'?\' onClick=\" getAnotimicalDetail(this,\'anotomical_site_desc4\',\'anotomical_site_code4\')\";><img id=\'specanotimagae4\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"collection_time4\" id=\"collection_time4\" maxlength=16  onBlur=\"validateDate1(this);enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'col4\' onClick=\"document.forms[0].collection_time4.select();return showCalendar(\'collection_time4\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img id=\'specollimagae4\'    src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"><input type=hidden name=\'anotomical_site_code4\' id=\'anotomical_site_code4\'  value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"></td>\n  </tr>\n  <tr> \n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_desc5\" id=\"speci_desc5\" onblur=\"enableSpecGif();\" maxlength=40 value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"><img id=\'specimagae5\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_type5\" id=\"speci_type5\"  onblur=\"enableSpecGif();\" maxlength=50 value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"><img id=\'specitypeimage5\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"anotomical_site_desc5\" id=\"anotomical_site_desc5\"  maxlength=30 onblur=\"beforeAnotomicalSiteClick(this,\'anot5\');enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"><input type=\'button\' class=\'button\' readOnly name=\'anot5\' id=\'anot5\' value=\'?\' onClick=\" getAnotimicalDetail(this,\'anotomical_site_desc5\',\'anotomical_site_code5\')\";><img id=\'specanotimagae5\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"collection_time5\" id=\"collection_time5\" maxlength=16 onBlur=\"validateDate1(this);enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'col5\' onClick=\"document.forms[0].collection_time5.select();return showCalendar(\'collection_time5\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"><img id=\'specollimagae5\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"><input type=hidden name=\'anotomical_site_code5\' id=\'anotomical_site_code5\'  value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"></td>\n  </tr>\n  <tr> \n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_desc6\" id=\"speci_desc6\"   maxlength=40 onblur=\"enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"><img id=\'specimagae6\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"speci_type6\" id=\"speci_type6\" onblur=\"enableSpecGif();\" maxlength=50 value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"><img id=\'specitypeimage6\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"anotomical_site_desc6\" id=\"anotomical_site_desc6\"  maxlength=30 onblur=\"beforeAnotomicalSiteClick(this,\'anot6\');enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"><input type=\'button\' class=\'button\' readOnly name=\'anot6\' id=\'anot6\' value=\'?\'onClick=\" getAnotimicalDetail(this,\'anotomical_site_desc6\',\'anotomical_site_code6\')\";><img id=\'specanotimagae6\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"collection_time6\" id=\"collection_time6\" maxlength=16  onBlur=\"validateDate1(this);enableSpecGif();\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'col6\' onClick=\"document.forms[0].collection_time6.select();return showCalendar(\'collection_time6\', null, \'hh:mm\' );\"style=\"cursor=\'hand\'\" ><img id=\'specollimagae6\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"><input type=hidden name=\'anotomical_site_code6\' id=\'anotomical_site_code6\'  value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"></td>\n  </tr>\n  <tr><td colspan=4>&nbsp;</td></tr>\n<tr><td class=\'label\'>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n<td colspan=\'3\' class=\'fields\'><INPUT TYPE=\"text\" size=40 name=\"pract_desc12\" id=\"pract_desc12\" maxlength=30 onBlur=\"beforeGetPractitioner(this,\'pract_but12\',pract12)\"  value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"><INPUT TYPE=\"hidden\" name=\"pract12\" id=\"pract12\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"><input type=\'button\' class=\'button\' readOnly name=\'pract_but12\' id=\'pract_but12\' value=\'?\' onClick=\"getValues(this,pract_desc12,pract12)\";><img id=\'imgenable3\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></td>\n</tr>\n<tr>\n<td class=\'label\'>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n<td class=\'fields\'><INPUT TYPE=\"text\" name=\"spec_handed_over_to\" id=\"spec_handed_over_to\"  maxlength=30 value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"><img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\" id=\'imgenable4\' ></td>\n<td class=\'label\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\n<td class=\'fields\'><INPUT TYPE=\"text\" name=\"spec_handed_over_date\" id=\"spec_handed_over_date\" maxlength=16  value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" onBlur=\'validateDate1(this);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].spec_handed_over_date.select();return showCalendar(\'spec_handed_over_date\', null, \'hh:mm\' );\" id=\'spechand\' style=\"cursor=hand\"><img src=\'../../eCommon/images/mandatory.gif\' id=\'imgenable5\'    style=\"visibility:hidden\"></td>\n</tr>\n </table>\n\t\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\n\n\n\n<a name=\'kin\'></a>\n<!--<a name=\"tab3\"  onFocus=\'javascript:AEScrollIntoView(3);\'></a> \n<table width=\'100%\' cellpadding=\'0\'   cellspacing=\'0\' BORDER=\'0\'><tr><td width=\'1%\' class=\'BODYCOLORFILLED\'></td><td width=\'50%\' class=\'BODYCOLORFILLED\'>&nbsp;<a align =\'left\' href=\"javascript:AEScrollIntoView(1)\"><img src=\"../../eMO/images/RegistrationClick.gif\" border=0></a><a align=\'left\' href=\"javascript:AEScrollIntoView(2)\" tabindex=\'-1\'><img src=\"../../eMO/images/Findings.gif\" border=0 ></a><a align=\'left\' href=\"javascript:AEScrollIntoView(3)\" tabindex=\'-1\' ><img src=\"../../eMO/images/SpecimenClick.gif\" border=0></a><a align=\'left\'  href=\"javascript:AEScrollIntoView(4)\" tabindex=\'-1\' ><img src=\"../../eMO/images/TissueProcurementClick.gif\" id=\'hidetis6\' style=\"visibility:hidden\" border=0></a></td></tr>\n\n</table>-->\n\n<a name=\"tab3\"  onFocus=\'javascript:AEScrollIntoView(2);\'></a> \t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Registration\">\n\t\t\t<a onclick=\"AEScrollIntoView(1)\"   class=\"tabA\" id=\"1\" ><span class=\"tabASpan\" >";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Find\"  >\n\t\t\t<a onclick=\"AEScrollIntoView(2)\"  class=\"tabClicked\" id=\"2\" ><span  class=\"tabSpanclicked\" >";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"TissueProcurement\" id=\'hidetis6\' style=\"visibility:hidden\">\n\t\t\t<a onclick=\"AEScrollIntoView(4)\" class=\"tabA\" id=\"4\" ><span class=\"tabASpan\" >";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\t<!-- Below line(s) <div> added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572] -->\n<div  style=\"position:relative;height:500px;vertical-align:top;overflow:auto\"> \n<table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=0 align=\'center\' scrolling=\'yes\' >\n<tr>\n<td class=\'label\' width=\'23%\'>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" </td>\n<td colspan=\'3\' class=\'fields\'><INPUT TYPE=\"text\" size=50 maxlength=30 value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"onBlur=\"beforeGetPractitioner(this,\'pract_but9\',pract9)\" NAME=\"pract_desc9\"><input type=\'button\' class=\'button\' readOnly name=\'pract_but9\' id=\'pract_but9\' value=\'?\' onClick=\"getValues(this,pract_desc9,pract9)\";><img id=\'imgenable1\' style=\"visibility:hidden\" src=\'../../eCommon/images/mandatory.gif\'><input type=hidden name=\'pract9\' id=\'pract9\' value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\"></td>\n</tr>\n<tr>\n<tH colspan=\'4\' class=\'columnheader\'>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</th>\n</tr>\n<tr>\n<td colspan=\'4\' class=\'label\'><b>1. ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</b></td>\n </tr>\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n<!-- BRU-HIMS-CRF-270-->\n<tr> <td class=\'label\'> a.";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n<td class=\'fields\' width=\'40%\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc\" id=\"mr_diagnosis_desc\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"  maxlength=70 onblur=\"callDiagnosis1(this,mr_diagnosis_code,\'mr_diagnosis_desc\');\"  maxlength=70 size=40><input type=\'button\' class=\'button\' name=\'mr_diagnosis_select\' id=\'mr_diagnosis_select\' onclick=\"callDiagnosis(this,mr_diagnosis_code,\'mr_diagnosis_desc\');\" value=\'?\'></td>\n <td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</td>\n <td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" name=\"onset_date1\" id=\"onset_date1\" maxlength=16  value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" onblur=\'validateDate1(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt1\' onClick=\"document.forms[0].onset_date1.select();return showCalendar(\'onset_date1\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n </tr>\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</td>\n <!-- BRU-HIMS-CRF-270 END HERE-->\n <td colspan=\'3\' class=\'fields\'><textarea name=\'cause_remarks1\' rows=\'1\' cols=\'30\'    onKeyPress=\'checkMaxLimit(this,200)\' onblur=\'makeValidStringRemark(this);checkLength(this,200);\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =" >";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</textarea></td>\n </tr>\n <!-- BRU-HIMS-CRF-270-->\n<tr>\n <td class=\'label\'>b.";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n<td class=\'fields\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc1\" id=\"mr_diagnosis_desc1\"  maxlength=70 onblur=\"callDiagnosis1(this,mr_diagnosis_code1,\'mr_diagnosis_desc1\');\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" size=40><input type=\'button\' class=\'button\' name=\'mr_diagnosis_select1\' id=\'mr_diagnosis_select1\' onclick=\"callDiagnosis(this,mr_diagnosis_code1,\'mr_diagnosis_desc1\');\" value=\'?\'></td>\n <td  class=\'label\'>";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"onset_date2\" id=\"onset_date2\"  maxlength=16  value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"onblur=\'validateDate1(this)\' ><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt2\' onClick=\"document.forms[0].onset_date2.select();return showCalendar(\'onset_date2\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n\n </tr>\n\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n <td colspan=\'3\' class=\'fields\'><textarea name=\'cause_remarks2\' rows=\'1\' cols=\'30\'  onKeyPress=\'checkMaxLimit(this,200)\' onblur=\'makeValidStringRemark(this);checkLength(this,200);\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</textarea></td>\n <!-- BRU-HIMS-CRF-270 END HERE-->\n </tr> \n<tr>\n<td colspan=\'4\' class=\'label\' ><b>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</b></td>\n </tr>\n <tr>\n <td class=\'label\'>c.";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc2\" id=\"mr_diagnosis_desc2\"  maxlength=70 value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"size=40><!--input type=\'button\' class=\'button\' style=\"visibility:hidden\" name=\'mr_diagnosis_select2\' onclick=\"callDiagnosis(this,mr_diagnosis_code2,\'mr_diagnosis_desc2\');\" disabled value=\'?\'--></td> \n <td class=\'label\'>";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"onset_date3\" id=\"onset_date3\" maxlength=16  value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"  onblur=\'validateDate1(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt3\' onClick=\"document.forms[0].onset_date3.select();return showCalendar(\'onset_date3\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n </tr>\n <tr>\n <td class=\'label\' >d.";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc3\" id=\"mr_diagnosis_desc3\"  maxlength=70 value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"size=40><!--input type=\'button\' class=\'button\' style=\"visibility:hidden\" disabled name=\'mr_diagnosis_select3\' onclick=\"callDiagnosis(this,mr_diagnosis_code3,\'mr_diagnosis_desc3\');\" value=\'?\'--></td>\n <td class=\'label\' >";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</td> \n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"onset_date4\" id=\"onset_date4\" maxlength=16  value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" onblur=\'validateDate1(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt4\' onClick=\"document.forms[0].onset_date4.select();return showCalendar(\'onset_date4\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n </tr>\n<tr>\n<td colspan=\'4\'  class=\'label\'><b>2.";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</b></td>\n </tr>\n <!-- BRU-HIMS-CRF-270-->\n<tr>\n <td class=\'label\'>a.";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="</td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc4\" id=\"mr_diagnosis_desc4\"  maxlength=70 onblur=\"callDiagnosis1(this,mr_diagnosis_code4,\'mr_diagnosis_desc4\');\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" size=40><input type=\'button\' class=\'button\' name=\'mr_diagnosis_select4\' id=\'mr_diagnosis_select4\' onclick=\"callDiagnosis(this,mr_diagnosis_code4,\'mr_diagnosis_desc4\');\" value=\'?\'></td> \n <td class=\'label\'>";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"onset_date5\" id=\"onset_date5\"  maxlength=16  value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" onblur=\'validateDate1(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt5\' onClick=\"document.forms[0].onset_date5.select();return showCalendar(\'onset_date5\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n </tr>\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</td>\n <!-- BRU-HIMS-CRF-270 END HERE-->\n <td colspan=\'3\' class=\'fields\'><textarea name=\'cause_remarks3\' rows=\'1\' cols=\'30\'   onKeyPress=\'checkMaxLimit(this,200)\' onblur=\'makeValidStringRemark(this);checkLength(this,200);\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="</textarea></td>\n </tr>\n <!-- BRU-HIMS-CRF-270-->\n  <tr>\n <td class=\'label\' >b.";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc5\" id=\"mr_diagnosis_desc5\"   maxlength=70 onblur=\"callDiagnosis1(this,mr_diagnosis_code5,\'mr_diagnosis_desc5\');\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" size=40><input type=\'button\' class=\'button\' name=\'mr_diagnosis_select5\' id=\'mr_diagnosis_select5\' onclick=\"callDiagnosis(this,mr_diagnosis_code5,\'mr_diagnosis_desc5\');\" value=\'?\'></td>\n <td class=\'label\'>";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"onset_date6\" id=\"onset_date6\"  maxlength=16  value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" onblur=\'validateDate1(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt6\' onClick=\"document.forms[0].onset_date6.select();return showCalendar(\'onset_date6\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n </tr>\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\n <!-- BRU-HIMS-CRF-270 END HERE-->\n\n <td colspan=\'3\' class=\'fields\'><textarea name=\'cause_remarks4\' rows=\'1\' cols=\'30\'  onKeyPress=\'checkMaxLimit(this,200)\' onblur=\'makeValidStringRemark(this);checkLength(this,200);\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</textarea></td>\n </tr>\n <!-- BRU-HIMS-CRF-270-->\n<tr>\n <td class=\'label\' >c.";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc6\" id=\"mr_diagnosis_desc6\"   maxlength=70 onblur=\"callDiagnosis1(this,mr_diagnosis_code6,\'mr_diagnosis_desc6\');\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" size=40><input type=\'button\' class=\'button\' name=\'mr_diagnosis_select6\' id=\'mr_diagnosis_select6\' onclick=\"callDiagnosis(this,mr_diagnosis_code6,\'mr_diagnosis_desc6\');\" value=\'?\'></td>\n \n <td class=\'label\'>";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"onset_date7\" id=\"onset_date7\"  maxlength=16  value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" onblur=\'validateDate1(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt7\' onClick=\"document.forms[0].onset_date7.select();return showCalendar(\'onset_date7\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n </tr>\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</td>\n <td colspan=\'3\' class=\'fields\'><textarea name=\'cause_remarks5\' rows=\'1\' cols=\'30\' onKeyPress=\'checkMaxLimit(this,200)\' onblur=\'makeValidStringRemark(this);checkLength(this,200);\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</textarea></td>\n </tr>\n <tr>\n <td class=\'label\' >d.";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</td>\n  <td class=\'fields\'><INPUT TYPE=\"text\" name=\"mr_diagnosis_desc7\" id=\"mr_diagnosis_desc7\"   maxlength=70 onblur=\"callDiagnosis1(this,mr_diagnosis_code7,\'mr_diagnosis_desc7\');\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" size=40><input type=\'button\' class=\'button\' name=\'mr_diagnosis_select7\' id=\'mr_diagnosis_select7\' onclick=\"callDiagnosis(this,mr_diagnosis_code7,\'mr_diagnosis_desc7\');\" value=\'?\'></td>\n <td class=\'label\'>";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="</td>\n <td class=\'fields\'><INPUT TYPE=\"text\" name=\"onset_date8\" id=\"onset_date8\"  maxlength=16  value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" onblur=\'validateDate1(this)\'><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'onsetdt8\' onClick=\"document.forms[0].onset_date8.select();return showCalendar(\'onset_date8\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\"></td>\n</tr>\n <tr>\n <td class=\'label\'>";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</td>\n  <td colspan=\'3\' class=\'fields\'><textarea name=\'cause_remarks6\' rows=\'1\' cols=\'30\'  onKeyPress=\'checkMaxLimit(this,200)\' onblur=\'makeValidStringRemark(this);checkLength(this,200);\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</textarea></td>\n </tr>\n  <!-- BRU-HIMS-CRF-270 END HERE-->\n   <!-- In below line dropdown list field modified by venkatesh.s against 45192 on 22-Nov-2013 -->\n<tr>\n <td class=\'label\' >";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</td>\n<td class=\'fields\' colspan=\'3\'>\n<select name=\'manner_of_death1\' id=\'manner_of_death1\' ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =" tabindex=\'15\'>\n<option value=\'\'>&nbsp;----";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="----&nbsp;</option>\n\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\n\t\t<option value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' selected>";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</option>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'>";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</option>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t</select>&nbsp;<img id=\'imgenable8\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\">\n</td>\n\n<!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->\n</tr>\n<td class=\'label\'>";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="</td>\n<td class=\'fields\' colspan=\'3\'><select name=\'manner_of_death_after_potmrtm\' id=\'manner_of_death_after_potmrtm\' tabindex=\'15\'>\n<option value=\'\'>&nbsp;----";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="----&nbsp;</option>\n";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t <option value=\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</option>\n\t\t\t\t ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t   <option value=\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</option>\n\t\t\t  ";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n</select>\n<tr>\n<!--end Bru-HIMS-CRF-365 [IN:039572]-->\n</tr>\n<tr>\n<td class=\'label\'>";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="</td>\n<td colspan=\'3\' class=\'fields\'><TEXTAREA NAME=\"postmortem_findings\" ROWS=\"3\" COLS=\"70\" onBlur=\'document.forms[0].pract_desc9.focus();\'>";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="</TEXTAREA><img id=\'imgenable2\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"><td>\n</tr>\n</table>\n</div>\n\t\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br>\n<input type=hidden name=\'facility_id\' id=\'facility_id\'\t value=";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 =">\n<!-- <input type=hidden name=\'diag_code\' id=\'diag_code\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'> -->\n<input type=hidden name=\'diag_code\' id=\'diag_code\' value=\'ICD10\'>\n<input type=hidden name=\'diag_desc\' id=\'diag_desc\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'>\n<input type=hidden name=\'body_rec_date_time\' id=\'body_rec_date_time\' value=\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\'>\n\n<input type=hidden name=\'mr_diagnosis_code\' id=\'mr_diagnosis_code\'\t value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n<input type=hidden name=\'mr_diagnosis_code1\' id=\'mr_diagnosis_code1\' value=\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\'>\n<input type=hidden name=\'mr_diagnosis_code2\' id=\'mr_diagnosis_code2\' value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'>\n<input type=hidden name=\'mr_diagnosis_code3\' id=\'mr_diagnosis_code3\' value=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\'>\n<input type=hidden name=\'mr_diagnosis_code4\' id=\'mr_diagnosis_code4\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'>\n<input type=hidden name=\'mr_diagnosis_code5\' id=\'mr_diagnosis_code5\' value=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'>\n<input type=hidden name=\'mr_diagnosis_code6\' id=\'mr_diagnosis_code6\' value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\'>  <!-- BRU-HIMS-CRF-270-->\n<input type=hidden name=\'mr_diagnosis_code7\' id=\'mr_diagnosis_code7\' value=\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'>\t<!-- BRU-HIMS-CRF-270-->\n<input type=\'hidden\' name=\'system_date\' id=\'system_date\' value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n<input type=\'hidden\' name=\'end_date\' id=\'end_date\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n<input type=\'hidden\' name=\'registration_no\' id=\'registration_no\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n<input type=\'hidden\' name=\'pmstatus\' id=\'pmstatus\' value=\"S\">\n<input type=\'hidden\' name=\'viewdata\' id=\'viewdata\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\">\n<input type=\'hidden\' name=\'postmortem_type\' id=\'postmortem_type\' value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\">\n<input type=\'hidden\' name=\'postmortem_status\' id=\'postmortem_status\' value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\">\n<!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->\n<input type=\'hidden\' name=\'manner_of_death\' id=\'manner_of_death\' value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\">\n\n\n\n\n<input type=\'hidden\' name=\'isPMFindingDetailsAppl\' id=\'isPMFindingDetailsAppl\' value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\"> <!--added by mujafar for ML-MMOH-CRF-0880 -->\n<input type=\'hidden\' name=\'record_pm_find_dtls_yn\' id=\'record_pm_find_dtls_yn\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\"> <!--added by mujafar for ML-MMOH-CRF-0880 -->\n <input type=\'hidden\' name=\'tissuecnt\' id=\'tissuecnt\' value=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'>\n <input type=\'hidden\' name=\'body_part_obtained_from_disable\' id=\'body_part_obtained_from_disable\' value=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\'>\n <input type=\'hidden\' name=\'body_part_obtained_from\' id=\'body_part_obtained_from\' value=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\'>\n <input type=\'hidden\' name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\'>\n <input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'>\n <input type=\'hidden\' name=\'deceased_yn\' id=\'deceased_yn\' value=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'>\n <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\'>\n\n <input type=\'hidden\' name=\'donatedorgan\' id=\'donatedorgan\' value=\"\">\n <input type=\'hidden\' name=\'cnt\' id=\'cnt\' value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n<script>\n// BRU-HIMS-CRF-270\nif(document.MORecordPostmortem.mr_diagnosis_desc.value!=\'\')\n{\ndocument.MORecordPostmortem.cause_remarks1.disabled=false;\n}\nif(document.MORecordPostmortem.mr_diagnosis_desc1.value!=\'\')\n{\ndocument.MORecordPostmortem.cause_remarks2.disabled=false;\n}\nif(document.MORecordPostmortem.mr_diagnosis_desc4.value!=\'\')\n{\ndocument.MORecordPostmortem.cause_remarks3.disabled=false;\n}\nif(document.MORecordPostmortem.mr_diagnosis_desc5.value!=\'\')\n{\ndocument.MORecordPostmortem.cause_remarks4.disabled=false;\n}\nif(document.MORecordPostmortem.mr_diagnosis_desc6.value!=\'\')\n{\ndocument.MORecordPostmortem.cause_remarks5.disabled=false;\n}\nif(document.MORecordPostmortem.mr_diagnosis_desc7.value!=\'\')\n{\ndocument.MORecordPostmortem.cause_remarks6.disabled=false;\n}\n</script>\n\n";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
String facility_id=	(String)	 session.getValue("facility_id");
String locale=(String)session.getAttribute("LOCALE");
Connection con 					= null;
Statement stmt						= null;
PreparedStatement  pstmt         =null;
ResultSet rset					    = null;
String autopsyno="";
String diag_code			= "";
String diag_desc			= "";
String pm_performed_by="";
String pm_performed_by_name="";
String role_for_practitioner="";
String pm_performed_by_desg="";
int tissuecnt=0;
String  body_received_date    ="";
String  pm_requested_by="";
String pm_requested_by_name="";
String  postmortem_type="";
String  postmortem_type_desc="";
String postmortem_status="";
String sys_date="";
String pm_purpose="";
String postmortem_findings="";
String specimen_collected_by="";
String encounter_id="";
String patient_class="";
String patient_id="";



String specimen_collected_by_name="";
String specimen_handed_over_date="";
String specimen_handed_over_to="";
String postmortem_start_date_time="";
String postmortem_end_date_time="";
String body_part_obtained_from_disable="";
String tissue_procured_by_name="";        
String tissue_procured_by="";             
String tissue_procure_performed_date="";  
String team_ind_id="";
String freetextpract[]=new String[4];	
String freetextpractname[]=new String[4];	
String freetextdese[]=new String[4];	
String freetextrole[]=new String[4];

String pract[]=new String[5];	
String dese[]=new String[5];	
String role[]=new String[5];	
String practname[]=new String[5];
String ddesc[]=new String[3];
String dcode[]=new String[3];
String onsetdate[]=new String[3];
String dcause[]=new String[3]; 			//bru-hims-crf-270
String ddesc1[]=new String[3];
String dcode1[]=new String[3];
String onsetdate1[]=new String[3];
String tisprocdis="";
String ddesc2[]=new String[5];
String dcode2[]=new String[5];
String onsetdate2[]=new String[5];
String dcause2[]=new String[5]; 		//bru-hims-crf-270

String findingtype[]=new String[8];	 	//bru-hims-crf-270
String diagdesc[]=new String[8];		//bru-hims-crf-270
String diagcode[]=new String[8];		//bru-hims-crf-270
String onsetdatetime[]=new String[8]; 	//bru-hims-crf-270
String diagcause[]=new String[8];		//bru-hims-crf-270

String specdesc[]=new String[6];	
String spectype[]=new String[6];	
String anatomsite[]=new String[6];	
String anatomsitedesc[]=new String[6];
String colectdate[]=new String[6];


String pm_certified_by="";
String pm_certified_by_desc="";
String actual_death_manner_code="";
String postmortem_finding="";
String witness[]=new String[2];	
String witnessdese[]=new String[2];	
String witnessname[]=new String[2];	
//String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String registration_no=request.getParameter("regn_no")==null?"":request.getParameter("regn_no");
String viewdata=request.getParameter("viewdata")==null?"":request.getParameter("viewdata");

String body_part_obtained_from="";
String age="";
String date_of_birth="";
String deceased_yn="";

String death_manner_code="";
String death_manner_code_yn="";
String examination_type = "";   //Added by Mano against ML-MMOH-CRF-0791


ddesc[0]="";			
dcode[0]="";			
onsetdate[0]="";		
dcause[0]="";			//bru-hims-crf-270
freetextpract[0]="";
freetextpractname[0]="";
freetextdese[0]="";
freetextrole[0]="";

freetextpract[1]="";
freetextpractname[1]="";
freetextdese[1]="";
freetextrole[1]="";

freetextpract[2]="";
freetextpractname[2]="";
freetextdese[2]="";
freetextrole[2]="";


ddesc1[1]="";
dcode1[1]="";
onsetdate1[1]="";

ddesc2[2]="";		
dcode2[2]="";		
onsetdate2[2]="";	
dcause2[2]="";		//bru-hims-crf-270

specdesc[0]="";
specdesc[1]="";
specdesc[2]="";
specdesc[3]="";
specdesc[4]="";
specdesc[5]="";

spectype[0]="";
spectype[1]="";
spectype[2]="";
spectype[3]="";
spectype[4]="";
spectype[5]="";

anatomsitedesc[0]="";
anatomsitedesc[1]="";
anatomsitedesc[2]="";
anatomsitedesc[3]="";
anatomsitedesc[4]="";
anatomsitedesc[5]="";


anatomsite[0]="";
anatomsite[1]="";
anatomsite[2]="";
anatomsite[3]="";
anatomsite[4]="";
anatomsite[5]="";


colectdate[0]="";
colectdate[1]="";
colectdate[2]="";
colectdate[3]="";
colectdate[4]="";
colectdate[5]="";





findingtype[0]="";
findingtype[1]="";
findingtype[2]="";
findingtype[3]="";
findingtype[4]="";
findingtype[5]="";
findingtype[6]=""; 	//bru-hims-crf-270
findingtype[7]="";	//bru-hims-crf-270
diagdesc[0]="";
diagdesc[1]="";
diagdesc[2]="";
diagdesc[3]="";
diagdesc[4]="";
diagdesc[5]="";
diagdesc[6]="";		//bru-hims-crf-270
diagdesc[7]="";		//bru-hims-crf-270
diagcode[0]="";
diagcode[1]="";
diagcode[2]="";
diagcode[3]="";
diagcode[4]="";
diagcode[5]="";
diagcode[6]="";		//bru-hims-crf-270
diagcode[7]="";		//bru-hims-crf-270
onsetdatetime[0]="";
onsetdatetime[1]="";
onsetdatetime[2]="";
onsetdatetime[3]="";
onsetdatetime[4]="";
onsetdatetime[5]="";
onsetdatetime[6]="";    //bru-hims-crf-270
onsetdatetime[7]="";	//bru-hims-crf-270

diagcause[0]="";		//bru-hims-crf-270
diagcause[1]="";		//bru-hims-crf-270
diagcause[2]="";		//bru-hims-crf-270
diagcause[3]="";		//bru-hims-crf-270
diagcause[4]="";		//bru-hims-crf-270
diagcause[5]="";		//bru-hims-crf-270
diagcause[6]="";		//bru-hims-crf-270
diagcause[7]="";		//bru-hims-crf-270

practname[0]="";
practname[1]="";
practname[2]="";
practname[3]="";
practname[4]="";
pract[0]="";
pract[1]="";
pract[2]="";
pract[3]="";
pract[4]="";
role[0]="";
role[1]="";
role[2]="";
role[3]="";
role[4]="";
dese[0]="";
dese[1]="";
dese[2]="";
dese[3]="";
dese[4]="";
witness[0]="";
witnessname[0]="";
witnessdese[0]="";
witness[1]="";
witnessname[1]="";
witnessdese[1]="";
try
  {
     	con = ConnectionManager.getConnection(request);
		
		boolean site_specific_exam_type = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","EXAMINATION_TYPE");
		/* added by mujafar for ML-MMOH-CRF-0880 start */
		boolean  isPMFindingDetailsAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","PM_FINDING_DETAILS_ALLOW_YN");
		String  record_pm_find_dtls_yn = "";
		
		JSONObject json = new JSONObject();
		
		json = eMO.MOCommonBean.getMOParam(con,facility_id);
		record_pm_find_dtls_yn = (String)json.get("record_pm_find_dtls_yn");
		/* end */
		pstmt  = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual");
        rset = pstmt.executeQuery();
        if (rset!=null)
        {
            while (rset.next())
            {
                sys_date = rset.getString(1);
				
            }
        }if (rset!=null) rset.close();
		 if(pstmt!=null) pstmt.close();

	 
	 stmt	= con.createStatement();
	 rset	= stmt.executeQuery("SELECT DECODE(DIAG_CODE_SCHEME,'1','ICD 10','2','ICD 9CM') SCHEME_DESC, DIAG_CODE_SCHEME FROM MR_PARAMETER");
		
	if ((rset != null) && (rset.next()))
	{
		diag_code = rset.getString("DIAG_CODE_SCHEME");
		diag_desc = rset.getString("SCHEME_DESC");

	}
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
	

pstmt = con.prepareStatement("select count(*) cnt from mo_organ_donation_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
rset=pstmt.executeQuery();
//int chkyn=0;
if(rset.next())
{
tissuecnt=rset.getInt("cnt");

 }if(pstmt!=null)pstmt.close();
 if(rset!=null)rset.close();

     stmt	= con.createStatement();
	 //rset	= stmt.executeQuery("SELECT postmortem_finding,AUTOPSY_NO, tissue_procured_by_name,tissue_procured_by,tissue_procure_performed_date, specimen_collected_by,specimen_collected_by_name,specimen_handed_over_date,specimen_handed_over_to ,BODY_RECEIVED_DATE,POSTMORTEM_TYPE_DESC,PM_REQUESTED_BY,pm_requested_by_name,POSTMORTEM_START_DATE_TIME,POSTMORTEM_END_DATE_TIME,PM_PURPOSE,PM_CERTIFIED_BY,PM_CERTIFIED_BY_NAME,ACTUAL_DEATH_MANNER_CODE,DEATH_MANNER_CODE,POSTMORTEM_FINDING,BODY_PART_OBTAINED_FROM,FACILITY_ID,PM_PERFORMED_BY, PM_PERFORMED_BY_NAME,ROLE_FOR_PRACTITIONER,PM_PERFORMED_BY_DESG FROM mo_mortuary_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"' " );
	
	
     /*Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
	 /*Below line(s) added by Mano on 28-sep-2017 against ML-MMOH-crf-0791*/
	String sql="SELECT postmortem_finding,AUTOPSY_NO,  am_get_desc.AM_PRACTITIONER(tissue_procured_by,'"+localeName+"','2')  tissue_procured_by_name,tissue_procured_by,tissue_procure_performed_date, specimen_collected_by, am_get_desc.AM_PRACTITIONER(specimen_collected_by,'"+localeName+"','2')  specimen_collected_by_name,specimen_handed_over_date,specimen_handed_over_to ,BODY_RECEIVED_DATE,postmortem_type,PM_REQUESTED_BY,	 am_get_desc.AM_PRACTITIONER(PM_REQUESTED_BY,'"+localeName+"','2') pm_requested_by_name,POSTMORTEM_START_DATE_TIME,POSTMORTEM_END_DATE_TIME,PM_PURPOSE,PM_CERTIFIED_BY,am_get_desc.AM_PRACTITIONER(PM_CERTIFIED_BY,'"+localeName+"','2') PM_CERTIFIED_BY_NAME,ACTUAL_DEATH_MANNER_CODE,DEATH_MANNER_CODE,POSTMORTEM_FINDING,BODY_PART_OBTAINED_FROM,FACILITY_ID,PM_PERFORMED_BY, am_get_desc.AM_PRACTITIONER(PM_PERFORMED_BY,'"+localeName+"','2') PM_PERFORMED_BY_NAME,ROLE_FOR_PRACTITIONER, am_get_desc.AM_PRACTITIONER(PM_PERFORMED_BY,'"+localeName+"','2') PM_PERFORMED_BY_DESG,encounter_id,patient_class,patient_id,postmortem_status,age,date_of_birth,deceased_yn,EXAMINATION_TYPE FROM mo_mortuary_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"' ";
	
     
	rset	= stmt.executeQuery(sql);
	

	
	if (rset.next())
	{   
		autopsyno=rset.getString("AUTOPSY_NO")==null?"":rset.getString("AUTOPSY_NO");
        pm_performed_by=rset.getString("PM_PERFORMED_BY")==null?"":rset.getString("PM_PERFORMED_BY");
        pm_performed_by_name=rset.getString("PM_PERFORMED_BY_NAME")==null?"":rset.getString("PM_PERFORMED_BY_NAME");
        role_for_practitioner=rset.getString("ROLE_FOR_PRACTITIONER")==null?"":rset.getString("ROLE_FOR_PRACTITIONER");
        pm_performed_by_desg=rset.getString("PM_PERFORMED_BY_DESG")==null?"":rset.getString("PM_PERFORMED_BY_DESG");
  		tissue_procured_by_name = rset.getString("tissue_procured_by_name")==null?"":rset.getString("tissue_procured_by_name");
     
	
		tissue_procured_by = rset.getString("tissue_procured_by")==null?"":rset.getString("tissue_procured_by");

		tissue_procure_performed_date = rset.getString("tissue_procure_performed_date")==null?"":rset.getString("tissue_procure_performed_date");

		if(tissue_procure_performed_date!=null && !tissue_procure_performed_date.equals(""))
			tissue_procure_performed_date = DateUtils.convertDate(tissue_procure_performed_date,"DMYHM","en",localeName); 


           
	    pm_requested_by_name= rset.getString("pm_requested_by_name")==null?"":rset.getString("pm_requested_by_name");
         postmortem_findings= rset.getString("postmortem_finding")==null?"":rset.getString("postmortem_finding");
		specimen_collected_by = rset.getString("specimen_collected_by")==null?"":rset.getString("specimen_collected_by");
		patient_id = rset.getString("patient_id")==null?"":rset.getString("patient_id");
		patient_class = rset.getString("patient_class")==null?"":rset.getString("patient_class");
		encounter_id = rset.getString("encounter_id")==null?"":rset.getString("encounter_id");

		


		
		specimen_handed_over_to = rset.getString("specimen_handed_over_to")==null?"":rset.getString("specimen_handed_over_to");
		
		
		specimen_collected_by_name = rset.getString("specimen_collected_by_name")==null?"":rset.getString("specimen_collected_by_name");
		
		specimen_handed_over_date = rset.getString("specimen_handed_over_date")==null?"":rset.getString("specimen_handed_over_date");
		if(specimen_handed_over_date!=null && !specimen_handed_over_date.equals(""))
			specimen_handed_over_date = DateUtils.convertDate(specimen_handed_over_date,"DMYHM","en",localeName); 

		body_received_date = rset.getString("BODY_RECEIVED_DATE")==null?"":rset.getString("BODY_RECEIVED_DATE");
		if(body_received_date!=null && !body_received_date.equals(""))
			body_received_date = DateUtils.convertDate(body_received_date,"DMYHM","en",localeName); 
		postmortem_type = rset.getString("postmortem_type")==null?"":rset.getString("postmortem_type");
		if(postmortem_type!=null && !postmortem_type.equals("") && postmortem_type.equals("M"))
			postmortem_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.MedicoLegal.label","mo_labels");
		else if(postmortem_type!=null && !postmortem_type.equals("") && postmortem_type.equals("C"))
			postmortem_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Clinical.label","mo_labels");


        pm_requested_by= rset.getString("PM_REQUESTED_BY")==null?"":rset.getString("PM_REQUESTED_BY");
        pm_purpose=rset.getString("PM_PURPOSE")==null?"":rset.getString("PM_PURPOSE");
	    postmortem_start_date_time=rset.getString("postmortem_start_date_time")==null?"":rset.getString("postmortem_start_date_time");
		if(postmortem_start_date_time!=null && !postmortem_start_date_time.equals(""))
			postmortem_start_date_time = DateUtils.convertDate(postmortem_start_date_time,"DMYHM","en",localeName); 

		body_part_obtained_from=rset.getString("body_part_obtained_from")==null?"N":rset.getString("body_part_obtained_from");
		body_part_obtained_from_disable=rset.getString("body_part_obtained_from")==null?"":rset.getString("body_part_obtained_from");
	    postmortem_end_date_time=rset.getString("POSTMORTEM_END_DATE_TIME")==null?"":rset.getString("POSTMORTEM_END_DATE_TIME");
		if(postmortem_end_date_time!=null && !postmortem_end_date_time.equals(""))
			postmortem_end_date_time = DateUtils.convertDate(postmortem_end_date_time,"DMYHM","en",localeName); 

	

		pm_certified_by=rset.getString("PM_CERTIFIED_BY")==null?"":rset.getString("PM_CERTIFIED_BY");
	  pm_certified_by_desc=rset.getString("PM_CERTIFIED_BY_NAME")==null?"":rset.getString("PM_CERTIFIED_BY_NAME");
		actual_death_manner_code=rset.getString("ACTUAL_DEATH_MANNER_CODE")==null?"":rset.getString("ACTUAL_DEATH_MANNER_CODE");
	  if(body_part_obtained_from_disable.equals(""))
		{
		body_part_obtained_from_disable="";
		}else
		{
		body_part_obtained_from_disable="disabled";
		}
	
	 /* Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572] */ 
	 death_manner_code=rset.getString("DEATH_MANNER_CODE")==null?"":rset.getString("DEATH_MANNER_CODE");
	 
	 if(!death_manner_code.equals("")){
	  death_manner_code_yn="disabled";
      } 
	 
     if(actual_death_manner_code.equals(""))
	 {
	 actual_death_manner_code=death_manner_code;
	 } 
      
	postmortem_finding=rset.getString("POSTMORTEM_FINDING")==null?"":rset.getString("POSTMORTEM_FINDING");
	//below line added by Mano Aganist ML-MMOH-CRF-0791
    examination_type=rset.getString("EXAMINATION_TYPE")==null?"N":rset.getString("EXAMINATION_TYPE");  //Mano aganist ML-MMOH-CRF-0791
		
	postmortem_status=rset.getString("postmortem_status")==null?"":rset.getString("postmortem_status");
	age = rset.getString("age")==null?"":rset.getString("age");
	date_of_birth = rset.getString("date_of_birth")==null?"":rset.getString("date_of_birth");
	deceased_yn = rset.getString("deceased_yn")==null?"N":rset.getString("deceased_yn");
	
	}
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
	
  int count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_postmortem_team_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();

  stmt	= con.createStatement();
  //rset	= stmt.executeQuery("SELECT PRACTITIONER_ID,PRACTITIONER_NAME,POSITION_DESC,ROLE_FOR_PRACTITIONER,TEAM_IND  from mo_postmortem_team_vw where registration_no='"+registration_no+"'and facility_id='"+facility_id+"' order by PRACTITIONER_ID");

   rset	= stmt.executeQuery("SELECT PRACTITIONER_ID,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_NAME,POSITION_DESC,ROLE_FOR_PRACTITIONER,TEAM_IND  from mo_postmortem_team_vw where registration_no='"+registration_no+"'and facility_id='"+facility_id+"' order by PRACTITIONER_ID");

int freetxtcnt=0;
int practcnt=0;
	while (rset.next())
	{ 

	/*for(int i=0;i<count;i++)
	{*/
    team_ind_id=rset.getString("TEAM_IND");  
	if(team_ind_id.equals("1"))
	{
	pract[practcnt]=rset.getString("PRACTITIONER_ID");  
	if(pract[practcnt]==null)pract[practcnt]="";
	
	practname[practcnt]=rset.getString("PRACTITIONER_NAME");  
	if(practname[practcnt]==null)practname[practcnt]="";
	
	dese[practcnt]= rset.getString("POSITION_DESC");  	
	if(dese[practcnt]==null)dese[practcnt]="";

	role[practcnt]=rset.getString("ROLE_FOR_PRACTITIONER");
	if(role[practcnt]==null)role[practcnt]="";
	

	practcnt++;
	}else
	{
	freetextpract[freetxtcnt]=rset.getString("PRACTITIONER_ID");  
	if(freetextpract[freetxtcnt]==null)freetextpract[freetxtcnt]="";
	
	freetextpractname[freetxtcnt]=rset.getString("PRACTITIONER_NAME");  
	if(freetextpractname[freetxtcnt]==null)freetextpractname[freetxtcnt]="";
	
	freetextdese[freetxtcnt]= rset.getString("POSITION_DESC");  	
	if(freetextdese[freetxtcnt]==null)freetextdese[freetxtcnt]="";

	freetextrole[freetxtcnt]=rset.getString("ROLE_FOR_PRACTITIONER");
	if(freetextrole[freetxtcnt]==null)freetextrole[freetxtcnt]="";
	

	 freetxtcnt++;
	
	}
	//rset.next();
	/*}*/

	
	}
 
  if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();

     count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_postmortem_finding where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
// mo_postmortem_finding_vw removed and mo_postmortem_finding replaced for IN032171 by Kamakshi N on 09.05.2012
  stmt	= con.createStatement();
  rset	= stmt.executeQuery("SELECT FINDING_TYPE,TERM_CODE_SHORT_DESC TERM_CODE_DESC,TERM_CODE,TO_CHAR (ONSET_RECORDED_DATE,'dd/mm/yyyy hh24:mi') ONSET_RECORDED_DATE,TERM_CODE_CAUSE  from mo_postmortem_finding where registration_no='"+registration_no+"'and facility_id='"+facility_id+"' order by FINDING_TYPE " );
	//TERM_CODE_CAUSE Added for this CRF bru-hims-crf-270
	if (rset.next())
	{ 

	for(int i=0;i<count;i++)
	{

	findingtype[i]=rset.getString("FINDING_TYPE");  
	if(findingtype[i]==null)findingtype[i]="";
	diagdesc[i]=rset.getString("TERM_CODE_DESC");  
	if(diagdesc[i]==null)diagdesc[i]="";
	diagcode[i]= rset.getString("TERM_CODE");
	if(diagcode[i]==null)diagcode[i]="";
	diagcause[i]= rset.getString("TERM_CODE_CAUSE");  	
	if(diagcause[i]==null)diagcause[i]="";
	onsetdatetime[i]=rset.getString("ONSET_RECORDED_DATE");
	if(onsetdatetime[i]==null)onsetdatetime[i]="";

	if(onsetdatetime[i]!=null && !onsetdatetime[i].equals(""))
			onsetdatetime[i] = DateUtils.convertDate(onsetdatetime[i],"DMYHM","en",localeName); 
	
	rset.next();
	}

	}
if(stmt!=null)stmt.close();
 if(rset!=null)rset.close();

   count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_specimen_collection_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();

  stmt	= con.createStatement();
  rset	= stmt.executeQuery("SELECT SPECIMENT_DESC,SPECIMEN_TYPE,ANATOMICAL_SITE_CODE,ANATOMICAL_SITE_DESC,COLLECTED_DATE  from mo_specimen_collection_vw where registration_no='"+registration_no+"'and facility_id='"+facility_id+"'");

  
	if (rset.next())
	{ 

	for(int i=0;i<count;i++)
	{

	specdesc[i]=rset.getString("SPECIMENT_DESC");  
	if(specdesc[i]==null)specdesc[i]="";
	spectype[i]=rset.getString("SPECIMEN_TYPE");  
	if(spectype[i]==null)spectype[i]="";
	anatomsite[i]= rset.getString("ANATOMICAL_SITE_CODE");  	
	if(anatomsite[i]==null)anatomsite[i]="";
	anatomsitedesc[i]=rset.getString("ANATOMICAL_SITE_DESC");
	if(anatomsitedesc[i]==null)anatomsitedesc[i]="";
	colectdate[i]=rset.getString("COLLECTED_DATE");
	if(colectdate[i]==null)colectdate[i]="";
	if(colectdate[i]!=null && !colectdate[i].equals(""))
		colectdate[i] = DateUtils.convertDate(colectdate[i],"DMYHM","en",localeName); 
        
    rset.next();
	}

	}
  
  
  
  
  
  if(stmt!=null)stmt.close();
 if(rset!=null)rset.close();
  
  
  count=0;
   stmt	= con.createStatement(); 
   rset	= stmt.executeQuery("SELECT count(*) cnt from mo_postmortem_witness where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");
   if (rset.next())
  {
  count=rset.getInt("cnt");
  }
   if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();
  stmt	= con.createStatement();
  rset	= stmt.executeQuery("select WITNESS_NAME,DESIGNATION from MO_POSTMORTEM_WITNESS where registration_no='"+registration_no+"'and facility_id='"+facility_id+"'");
	
	if (rset.next())
	{ 

	for(int i=0;i<count;i++)
	{

	witness[i]=rset.getString("WITNESS_NAME");  
	if(witness[i]==null)witness[i]="";

	witnessdese[i]=rset.getString("DESIGNATION");  
	if(witnessdese[i]==null)witnessdese[i]="";
	
	rset.next();
	}


	
	
	
	}
	if(rset!=null)  rset.close();
   if(stmt!=null)  stmt.close();

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(body_received_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(postmortem_start_date_time));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pm_requested_by_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pm_requested_by));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(postmortem_type_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pm_purpose));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pm_purpose));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(pm_performed_by_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pm_performed_by));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pm_performed_by_desg));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(role_for_practitioner));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(practname[0]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(pract[0]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dese[0]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(role[0]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(practname[1]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pract[1]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(dese[1]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(role[1]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(freetextpract[0]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(freetextdese[0]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(freetextrole[0]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(practname[2]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pract[2]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dese[2]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(role[2]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(freetextpract[1]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(freetextdese[1]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(freetextrole[1]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(freetextpract[2]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(freetextdese[2]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(freetextrole[2]));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(witness[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(witnessdese[0]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(witness[1]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(witnessdese[1]));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(body_received_date));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(postmortem_start_date_time));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(postmortem_end_date_time));
            _bw.write(_wl_block68Bytes, _wl_block68);
if(site_specific_exam_type){
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
if(examination_type.equals("N")){
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
if(examination_type.equals("I")){
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
if(examination_type.equals("E")){
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(tissuecnt));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tissuecnt));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
	int proccnt=0;
 String tissue_procurement_date="";
if(stmt!=null)stmt.close();
 if(rset!=null)rset.close();
//pstmt = con.prepareStatement("select ORGAN_CODE,ORGAN_DESC,TISSUE_PROCURED_YN,TISSUE_PROCUREMENT_DATE from mo_organ_donation_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");

pstmt = con.prepareStatement("select ORGAN_CODE,MO_GET_DESC.MO_ORGAN_FOR_DONATION(ORGAN_CODE,'"+localeName+"','2')  ORGAN_DESC,TISSUE_PROCURED_YN,TISSUE_PROCUREMENT_DATE from mo_organ_donation_regn_vw where registration_no='"+registration_no+"' and facility_id='"+facility_id+"'");

rset=pstmt.executeQuery();
int chkyn=0;
while(rset.next())
{ chkyn=1;
tissue_procurement_date= rset.getString("TISSUE_PROCUREMENT_DATE")==null?"":rset.getString("TISSUE_PROCUREMENT_DATE");
if(tissue_procurement_date!=null && !tissue_procurement_date.equals(""))
	tissue_procurement_date = DateUtils.convertDate(tissue_procurement_date,"DMYHM","en",localeName); 



            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rset.getString("ORGAN_DESC")));
            _bw.write(_wl_block87Bytes, _wl_block87);

	if(viewdata.equals("viewdata"))tisprocdis="disabled";
	if(rset.getString("TISSUE_PROCURED_YN").equals("Y")){
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(tisprocdis));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rset.getString("ORGAN_CODE")));
            _bw.write(_wl_block95Bytes, _wl_block95);
}else{
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(tisprocdis));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(rset.getString("ORGAN_CODE")));
            _bw.write(_wl_block95Bytes, _wl_block95);
}
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(tissue_procurement_date));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block106Bytes, _wl_block106);
proccnt++;}
            _bw.write(_wl_block107Bytes, _wl_block107);
if(chkyn>0){
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(tisprocdis));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(tissue_procured_by_name));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(tissue_procured_by));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(tisprocdis));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(tisprocdis));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(tissue_procure_performed_date));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(tisprocdis));
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(specdesc[0]));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(spectype[0]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(anatomsitedesc[0]));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(colectdate[0]));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(anatomsite[0]));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(specdesc[1]));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(spectype[1]));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(anatomsitedesc[1]));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(colectdate[1]));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(anatomsite[1]));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(specdesc[2]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(spectype[2]));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(anatomsitedesc[2]));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(colectdate[2]));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(anatomsite[2]));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(specdesc[3]));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(spectype[3]));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(anatomsitedesc[3]));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(colectdate[3]));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(anatomsite[3]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(specdesc[4]));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(spectype[4]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(anatomsitedesc[4]));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(colectdate[4]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(anatomsite[4]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(specdesc[5]));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(spectype[5]));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(anatomsitedesc[5]));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(colectdate[5]));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(anatomsite[5]));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(specimen_collected_by_name));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(specimen_collected_by));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(specimen_handed_over_to));
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(specimen_handed_over_date));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(pm_certified_by_desc));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(pm_certified_by));
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);

	int p1=0;
	int p2=0;
	int p3=0;
	// Loop Statement Changed For this CRF BRU_HIMS_CRF-270
	
for(int j=0;j<=7;j++){
	if(findingtype[j].equals("1"))
	{ 
	ddesc[p1]=diagdesc[j];
	dcode[p1]=diagcode[j];
	onsetdate[p1]=onsetdatetime[j];
	dcause[p1]=diagcause[j];
	p1++; 
	}else if(findingtype[j].equals("2"))
	{
	ddesc1[p2]=diagdesc[j];
	dcode1[p2]=diagcode[j];
	onsetdate1[p2]=onsetdatetime[j];
	
	p2++;
	}else if(findingtype[j].equals("3"))
	{
	ddesc2[p3]=diagdesc[j];
	dcode2[p3]=diagcode[j];
	onsetdate2[p3]=onsetdatetime[j];
	dcause2[p3]=diagcause[j];
	p3++;
	}




}
if(ddesc[0]==null)ddesc[0]="";
if(onsetdate[0]==null)onsetdate[0]="";
if(dcode[0]==null)dcode[0]="";
if(dcause[0]==null)dcause[0]="";

if(ddesc[1]==null)ddesc[1]="";
if(onsetdate[1]==null)onsetdate[1]="";
if(dcode[1]==null)dcode[1]="";
if(dcause[1]==null)dcause[1]="";

if(ddesc1[0]==null)ddesc1[0]="";
if(onsetdate1[0]==null)onsetdate1[0]="";
if(dcode1[0]==null)dcode1[0]="";

if(ddesc1[1]==null)ddesc1[1]="";
if(onsetdate1[1]==null)onsetdate1[1]="";
if(dcode1[1]==null)dcode1[1]="";

if(ddesc2[0]==null)ddesc2[0]="";
if(onsetdate2[0]==null)onsetdate2[0]="";
if(dcode2[0]==null)dcode2[0]="";
if(dcause2[0]==null)dcause2[0]="";

if(ddesc2[1]==null)ddesc2[1]="";
if(onsetdate2[1]==null)onsetdate2[1]="";
if(dcode2[1]==null)dcode2[1]="";
if(dcause2[1]==null)dcause2[1]="";

if(ddesc2[2]==null)ddesc2[2]="";
if(onsetdate2[2]==null)onsetdate2[2]="";
if(dcode2[2]==null)dcode2[2]="";
if(dcause2[2]==null)dcause2[2]="";
if(ddesc2[3]==null)ddesc2[3]="";
if(onsetdate2[3]==null)onsetdate2[3]="";
if(dcode2[3]==null)dcode2[3]="";
if(dcause2[3]==null)dcause2[3]="";
String remark_disable="";
// If Statement newly added For this CRF BRU_HIMS_CRF-270
if(ddesc[0]=="")
	{
	remark_disable="disabled";
	}

if(ddesc[1]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[0]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[1]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[2]=="")
	{
	remark_disable="disabled";
	}
if(ddesc2[3]=="")
	{
	remark_disable="disabled";
	}	

            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(ddesc[0]));
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(onsetdate[0]));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(remark_disable));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(dcause[0]));
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(ddesc[1]));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(onsetdate[1]));
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(remark_disable));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dcause[1]));
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(ddesc1[0]));
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(onsetdate1[0]));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(ddesc1[1]));
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(onsetdate1[1]));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(ddesc2[0]));
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(onsetdate2[0]));
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(remark_disable));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dcause2[0]));
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(ddesc2[1]));
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(onsetdate2[1]));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(remark_disable));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dcause2[1]));
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(ddesc2[2]));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(onsetdate2[2]));
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(remark_disable));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dcause2[2]));
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(ddesc2[3]));
            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(onsetdate2[3]));
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(remark_disable));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dcause2[3]));
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(death_manner_code_yn));
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block221Bytes, _wl_block221);

if(pstmt!=null)pstmt.close();
 if(rset!=null)rset.close();			 
 //pstmt = con.prepareStatement("select death_manner_code,short_desc from mo_manner_of_death where eff_status='E' order by 2");
 pstmt = con.prepareStatement("select death_manner_code,short_desc from MO_MANNER_OF_DEATH_LANG_VW where eff_status='E' and LANGUAGE_ID='"+localeName+"'order by 2");
				 rset = pstmt.executeQuery();
				 while(rset.next())
				 {
			if(death_manner_code.equals(rset.getString("death_manner_code"))){  
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(rset.getString("death_manner_code")));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(rset.getString("short_desc")));
            _bw.write(_wl_block224Bytes, _wl_block224);
	}else{
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(rset.getString("death_manner_code")));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(rset.getString("short_desc")));
            _bw.write(_wl_block227Bytes, _wl_block227);
}}
			
				 //if(rset!=null) rset.close();
				 // if(pstmt!=null) pstmt.close();
				
				
            _bw.write(_wl_block228Bytes, _wl_block228);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);

             rset = pstmt.executeQuery();
			  while(rset.next()){

                 if(actual_death_manner_code.equals(rset.getString("death_manner_code"))){
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(rset.getString("death_manner_code")));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(rset.getString("short_desc")));
            _bw.write(_wl_block232Bytes, _wl_block232);
	}else{
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(rset.getString("death_manner_code")));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(rset.getString("short_desc")));
            _bw.write(_wl_block234Bytes, _wl_block234);
 }}
			  
			  if(rset!=null) rset.close();
			  if(pstmt!=null) pstmt.close();
			  
			  
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(postmortem_findings));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(body_received_date));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(dcode[0]));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(dcode[1]));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(dcode1[0]));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(dcode1[1]));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(dcode2[0]));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(dcode2[1]));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(dcode2[2]));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(dcode2[3]));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(postmortem_end_date_time));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(viewdata));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(postmortem_type));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(death_manner_code));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(isPMFindingDetailsAppl));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(record_pm_find_dtls_yn));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(tissuecnt));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(body_part_obtained_from_disable));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(body_part_obtained_from));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(age));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(proccnt));
            _bw.write(_wl_block269Bytes, _wl_block269);
	}
  catch(Exception e)
  {
  out.println(e);
  }finally{
  ConnectionManager.returnConnection(con,request);
  }


            _bw.write(_wl_block270Bytes, _wl_block270);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registration.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Finding.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specimen.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.TissueProcurement.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PMRequestedBy.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.TypeOfPostmortem.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PurposeForPrfmgPostMrtm.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemPrfmdBy.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.designation.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PresentDrngPostmrtm.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.designation.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyIdentifiedBy.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemStatus.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PatientCheckedInAt.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.WaitTimeDuration.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PMStartedAt.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ProcedureDuration.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PMCompletedAt.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ExaminationType.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.none.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.InternalExamination.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ExternalExamination.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registration.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Finding.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specimen.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.TissueProcurement.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.OrgansLstdForProcmnt.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.TissueProcured.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ProcurementTime.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PerformedBy.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformedDate.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registration.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Finding.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specimen.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.TissueProcurement.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DetlsofSpeciCollected.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.SpecimenDescription.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecimenType.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AnatomicalSite.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.CollectionTime.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CollectedBy.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.SpecimenHandedOverTo.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.SpecimenHandedDateTime.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registration.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Finding.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specimen.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.TissueProcurement.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemCertifiedBy.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseofDeath.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Diseasedeath.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cause.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cause.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.AntecedentCause.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cause.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cause.label", java.lang.String .class,"key"));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.OtherSignificantCond.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Condition.label", java.lang.String .class,"key"));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Condition.label", java.lang.String .class,"key"));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Condition.label", java.lang.String .class,"key"));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Condition.label", java.lang.String .class,"key"));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MannerofDeathuponReceipt.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MannerofDeathafterPostmortem.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.SmryOfFdgs.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
