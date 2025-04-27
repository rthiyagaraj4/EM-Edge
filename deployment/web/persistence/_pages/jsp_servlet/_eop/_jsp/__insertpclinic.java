package jsp_servlet._eop._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __insertpclinic extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/InsertPClinic.jsp", 1720584365706L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eOP/js/menuItemCheck.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOP/js/OPPractitionerComponent.js\'></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script language=\'javascript\' src=\'../../eOP/js/PClinic.js\'></script>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script language=\'javascript\' src=\'../../eOP/js/ResourceForUnit.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n <script>\n \n function restrictEnterKey(evnt)\n {\n\tif(evnt.keyCode == 13)\n\t\treturn false;\n }\n\n </script>\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\' onKeyPress=\'return restrictEnterKey(event);\'> \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\"clinic_form\" id=\"clinic_form\" action=\"../../servlet/eOP.PractitionerClinicServlet\" method=\"post\" target=\"messageFrame\">\n\n<BR><BR><BR><BR>\n <!-- The following block is used to get the clinic names. based on the \n\t   effectiveStatus and facilityID from the table OP_clinic.\n\t \n\t   menuitemCheck(): This should be called in an onChange() Event.Based on the \n\t   clinic selection- WorkingDays ,Enabled checkbox and Applicable VisitTypeIndicator\n\t   are either checked OR unchecked\n--> \n\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr>\n\t\t<td>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" > \n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"5%\" class=\"label\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td width=\'10%\' class=\'fields\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<input type=\'text\' name=\"clinic_desc\" id=\"clinic_desc\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"clinic\" id=\"clinic\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<select name=\'clinic\' id=\'clinic\' onChange=\'clearPractVals();GetValues(this)\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><!--onChange=\"menuItemCheck(this.value)\"-->\n\t\t\t\t\t\t\t<option value=\'\' selected>&nbsp;-------- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" --------&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\" class=\'label\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t<td width=\"20%\" class=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<input type=\"text\" name=\"pract_name\" id=\"pract_name\" maxlength=\"25\" size=\"25\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onBlur=\"onBlurCallPractitionerSearch(document.forms[0].preact_butt,pract_name);\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="><input type=\'button\' name=\'preact_butt\' id=\'preact_butt\' value=\'?\' class=\'button\'  onClick=\"getPract(this,pract_name);\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="><input type=\"hidden\" name=\"practitioner\" id=\"practitioner\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"5%\" class=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'fields\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<input type=\'checkbox\'  name=\'active\' id=\'active\' onClick=\'assignval(this)\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<table cellpadding=\'3\' cellspacing=0 border=0 width=\'100%\' align=\'center\'>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'152pts\' class=\'label\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\t\n\t\t\t\t\t\t<td class=\'fields\' width=\'33%\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\"unit_type_desc\" id=\"unit_type_desc\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"unit_type\" id=\"unit_type\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t<select name=\"unit_type\" id=\"unit_type\" onChange=\"GetValues(this);\">\n\t\t\t\t\t\t\t\t<option value=\'\' >&nbsp;-------- ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" --------&nbsp;\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</select> <img src=\"../../eCommon/images/mandatory.gif\"></img> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tunittypemodify(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'156pts\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\t\n\t\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\"res_unit1\" id=\"res_unit1\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"res_unit\" id=\"res_unit\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\"res_unit1\" id=\"res_unit1\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" size=\'30\' readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"res_unit\" id=\"res_unit\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t<select name=\"res_unit\" id=\"res_unit\" disabled>\n\t\t\t\t\t\t\t\t<option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" --------&nbsp;\n\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"res_unit1\" id=\"res_unit1\"  onBlur=\"onBlurgetLoc(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\',document.getElementById(\'unit_type\').value,document.getElementById(\'res_unit1\'));ValidateResName(this);GetValues(document.getElementById(\'res_unit1\'));\"><input type=\"button\" name=\"qloc_butt\" id=\"qloc_butt\" value=\"?\" class=\"button\" onClick=\"getLocn(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\',document.getElementById(\'unit_type\').value,document.getElementById(\'res_unit1\'));ValidateResName(this);GetValues(document.getElementById(\'res_unit1\'));\" ><img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"res_unit\" id=\"res_unit\"> \t\n\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t<select name=\"res_unit\" id=\"res_unit\" onChange=\'ValidateResName(this);GetValues(this);\'>\n\t\t\t\t\t\t\t\t<option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" --------&nbsp;\n\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t  \t<tr>\n\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\"res_class_desc\" id=\"res_class_desc\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" readonly><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"res_class\" id=\"res_class\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<select name=\"res_class\" id=\"res_class\" onChange=\"ValidateResName(this);GetValues(this);\" >\n\t\t\t\t\t\t\t<option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t    <option value=\'P\'>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tresclassmod(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\"res_type_desc\" id=\"res_type_desc\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" readonly>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" \t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t<select name=\"res_type\" id=\"res_type\" onChange=\"clearpract(this)\" >\n\t\t\t\t\t\t\t\t<option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" --------&nbsp;\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t       <select name=\"res_type\" id=\"res_type\" onChange=\"clearpract(this)\" disabled>\n\t\t\t\t\t\t\t\t<option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" --------&nbsp;\n\t\t\t\t\t\t\t     \n\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t</td>\t\t\n\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' nowrap>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t<input type=\"text\" name=\"res_name\" id=\"res_name\" maxlength=\"25\" size=\"25\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" onBlur=\"onblurres()\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="><input type=\'button\' name=\'reslookup_butt\' id=\'reslookup_butt\' value=\'?\' class=\'button\'  onCLick=\"resourcenamelookup()\" ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"res_id\" id=\"res_id\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t<input type=\'checkbox\'  name=\'active\' id=\'active\' onClick=\'assignval(this)\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t\t<tr>\n\t\t<td>\n\t\t\t<!-- Added by Sen on 15/06/2004 for creating two tables representing the availability of \n\t\t\tclinic and practitioner -->\n\t\t\t<table border=1 cellpadding=0 cellspacing=0 width=\'100%\' >\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' class=\'oaborder\'>\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'10%\'>&nbsp;\n\t\t\t\t\t\t\t\t</td>   \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'labelleft\' width=\'5%\' style=\"color: #00008B;\">";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'8\'>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t<td class=\'QUERYDATA\' id=\'week_appl_day_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' == \"W\")\n\t\t\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\teval(document.getElementById(\"week_appl_day_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\")).innerText=getLabel(\'Common.specific.label\',\'Common\');\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(document.getElementById(\"week_appl_day_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\")).innerText=getLabel(\'Common.all.label\',\'Common\');\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" 1</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\'  class=\'fields\'>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'working_week_1_day_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' id=\'working_week_1_day_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' disabled ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" 2</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'working_week_2_day_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' id=\'working_week_2_day_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'  disabled ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" 3</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'working_week_3_day_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' id=\'working_week_3_day_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =" 4</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'working_week_4_day_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' id=\'working_week_4_day_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =" 5</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'working_week_5_day_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' id=\'working_week_5_day_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'  value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'50%\' class=\'oaborder\'>\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'10%\' >&nbsp;\n\t\t\t\t\t\t\t\t</td>   \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'labelleft\' width=\'5%\' style=\"color: #00008B;\">";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'8\'>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'1%\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t\t\t\t\t\t<td width=\'1%\' class=\'fields\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\"pract_week_appl_daydesc_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"pract_week_appl_daydesc_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" size=\'4\' maxlength=\'4\' align=\'center\' readonly>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"pract_week_appl_day_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" id=\"pract_week_appl_day_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\'1%\' class=\'fields\'>\n\t\t\t\t\t\t\t\t\t\t\t<select name=\"pract_week_appl_day_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" onChange=\'chekUnchek(this,\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\")\' class=\'label\' align=\'center\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'W\'  >";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" </option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'A\'  >";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" </option>\n\t\t\t\t\t\t\t\t\t\t\t</select>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tassignweekappl(\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\',\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\')\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pract_working_week_1_day_";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' id=\'pract_working_week_1_day_";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' onClick=\'assigndays(this)\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =">\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pract_working_week_1_day_";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="1\' id=\'pract_working_week_1_day_";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="1\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pract_working_week_2_day_";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' id=\'pract_working_week_2_day_";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'   onClick=\'assigndays(this)\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pract_working_week_2_day_";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="1\' id=\'pract_working_week_2_day_";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pract_working_week_3_day_";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' id=\'pract_working_week_3_day_";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pract_working_week_3_day_";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="1\' id=\'pract_working_week_3_day_";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pract_working_week_4_day_";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' id=\'pract_working_week_4_day_";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pract_working_week_4_day_";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="1\' id=\'pract_working_week_4_day_";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'pract_working_week_5_day_";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' id=\'pract_working_week_5_day_";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'pract_working_week_5_day_";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="1\' id=\'pract_working_week_5_day_";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<!-- Addition by sen ends-->\n\t\t\t<BR>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" >\t\n\t\t\t\t<th class=\'columnheader\' align=\'left\'>";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</th>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"Border\">\n\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'4\'>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=label>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=\'fields\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=\'emergency\' id=\'emergency\' value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"  onClick=\'assignval(this)\' ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'emergency1\' id=\'emergency1\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=label>";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=\'first\' id=\'first\' value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" onClick=\'assignval(this)\' ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first1\' id=\'first1\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=label nowrap>";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'5%\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=\'follow\' id=\'follow\' value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'follow1\' id=\'follow1\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'5%\' class=label>";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=\'routine\' id=\'routine\' value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'routine1\' id=\'routine1\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=\'series\' id=\'series\' value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 =">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'series1\' id=\'series1\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=\"consult\" id=\"consult\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" onClick=\"assignval(this)\" ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"consult1\" id=\"consult1\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'6\'>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n\n\t<input type=\"hidden\" name=\"function\" id=\"function\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n\t<input type=\"hidden\" name=\"eff_date_from\" id=\"eff_date_from\" >\n\t<input type=\"hidden\" name=\"eff_date_to\" id=\"eff_date_to\" >\n\t<input type = \"hidden\" name=\"fac_id\" id=\"fac_id\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t<input type = \"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\'\'>\n\t<input type = \"hidden\" name=\"rd_appl_yn\" id=\"rd_appl_yn\" value=\'\'>\n\n\n\t<!-- Following fields represent images in the original file-->\n\t<input type=\"hidden\" name=\"i1\" id=\"i1\" >\n\t<input type=\"hidden\" name=\"i2\" id=\"i2\" >\n\t<input type=\"hidden\" name=\"i3\" id=\"i3\" >\n\t<input type=\"hidden\" name=\"i4\" id=\"i4\" >\n\t<input type=\"hidden\" name=\"i5\" id=\"i5\" >\n\t<input type=\"hidden\" name=\"i6\" id=\"i6\" >\n\t<input type=\"hidden\" name=\"i7\" id=\"i7\" >\n\t</form>\n\t</body>\n\t</html>\n\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
try{
    con=ConnectionManager.getConnection(request);    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
	String callfunc=request.getParameter("call_func");

	String clinicmod="";
	String clinicdesc="";
	String unittype="";
	String unittypedesc="";
	
	String resclass="";
	String resclassdesc="";
	String cliniccode="";
	String restypecode="";
	String restype="";
	String restypedesc="";	
	String resunit="";
	String resunitdesc="";
	
	String practitionerid="";
	String practname="";
	String effstatus="E";
	
	String daysofweek = "";	
	
	
	String clinicworkingWeekApplday[] = new String[7];
	String clinicworkingweekappldesc[] = new String[7];
	
	
	String clinicworkingweek1day[] = new String[7];
	String clinicworkingweek2day[] = new String[7];
	String clinicworkingweek3day[]=  new String[7];
	String clinicworkingweek4day[] = new String[7];
	String clinicworkingweek5day[] = new String[7];

	String workingWeekApplday[] = new String[7];
	String workingweekappldesc[] = new String[7];
	
	
	String workingweek1day[] = new String[7];
	String workingweek2day[] = new String[7];
	String workingweek3day[]=  new String[7];
	String workingweek4day[] = new String[7];
	String workingweek5day[] = new String[7];

	String FI_VISIT_TYPE_APPL_YN ="";
    String FU_VISIT_TYPE_APPL_YN="";
    String RT_VISIT_TYPE_APPL_YN="";
    String SR_VISIT_TYPE_APPL_YN="";
    String CS_VISIT_TYPE_APPL_YN="";
    String EM_VISIT_TYPE_APPL_YN="";

	String emerchk="N";
	String firstchk="Y";
	String followchk="Y";
	String routinechk="Y";
	String serieschk="Y";
	String consultchk="Y";
	String chkval="";
	String disable="";
	String readonly="";
	String disable1="";
	String sel="";
	String sql="";  
	String fnval="";
	StringBuffer sql1= new StringBuffer();
	StringBuffer sqlmain = new StringBuffer();
    String facilityid=(String)session.getValue("facility_id");
   
    
	String care_locn_type_ind="";
	// used for whether it is Create/ Modify Mode   
	

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	if(callfunc.equals("Pract_for_clinic"))
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else if(callfunc.equals("Resource_unit"))
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	
            _bw.write(_wl_block10Bytes, _wl_block10);


	for(int j=1;j<=7;j++)
	{
		workingWeekApplday[j-1]="W";
		
		workingweek1day[j-1]="N";
		workingweek2day[j-1]="N";
		workingweek3day[j-1]="N";
		workingweek4day[j-1]="N";
		workingweek5day[j-1]="N";
	}
	for(int j=1;j<=7;j++)
	{
		clinicworkingWeekApplday[j-1]="W";
		
		clinicworkingweek1day[j-1]="N";
		clinicworkingweek2day[j-1]="N";
		clinicworkingweek3day[j-1]="N";
		clinicworkingweek4day[j-1]="N";
		clinicworkingweek5day[j-1]="N";
	}
	if(callfunc.equals("Pract_for_clinic"))
	{
		clinicmod=(request.getParameter("clinic_code") == null)?"":request.getParameter("clinic_code");
		
		if(!clinicmod.equals(""))
		{
			fnval="modify";
			
			try{
				practitionerid=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");		
				try{
				
				sqlmain.append("select clinic_code,working_week_1_day_1,working_week_1_day_2,working_week_1_day_3,working_week_1_day_4,working_week_1_day_5,working_week_1_day_6,working_week_1_day_7");
					sqlmain.append(",working_week_2_day_1,working_week_2_day_2,working_week_2_day_3,working_week_2_day_4,working_week_2_day_5,working_week_2_day_6,working_week_2_day_7");
					sqlmain.append(",working_week_3_day_1,working_week_3_day_2,working_week_3_day_3,working_week_3_day_4,working_week_3_day_5,working_week_3_day_6,working_week_3_day_7");
					sqlmain.append(",working_week_4_day_1,working_week_4_day_2,working_week_4_day_3,working_week_4_day_4,working_week_4_day_5,working_week_4_day_6,working_week_4_day_7");
					sqlmain.append(",working_week_5_day_1,working_week_5_day_2,working_week_5_day_3,working_week_5_day_4,working_week_5_day_5,working_week_5_day_6,working_week_5_day_7 ");
					sqlmain.append(",working_week_appl_day_1,working_week_appl_day_2,working_week_appl_day_3,working_week_appl_day_4,working_week_appl_day_5,working_week_appl_day_6,working_week_appl_day_7 ");
					sqlmain.append(",working_day_1,working_day_2,working_day_3,working_day_4,working_day_5,working_day_6,working_day_7 ");

					sqlmain.append(",FI_VISIT_TYPE_APPL_YN,FU_VISIT_TYPE_APPL_YN,RT_VISIT_TYPE_APPL_YN,SR_VISIT_TYPE_APPL_YN,CS_VISIT_TYPE_APPL_YN,EM_VISIT_TYPE_APPL_YN ");

					sqlmain.append(" from op_clinic where care_locn_type_ind = 'C' and clinic_code='"+clinicmod+"' and facility_id='"+facilityid+"'");

					pstmt=con.prepareStatement(sqlmain.toString());
				rs=pstmt.executeQuery();
				if(rs != null && rs.next())
				{

					for(int i=1;i<=7;i++)
					{
						clinicworkingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
						
							if(clinicworkingWeekApplday[i-1].equals("W"))
							{
							clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
						
						clinicworkingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
						
						clinicworkingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
						clinicworkingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
						clinicworkingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
						clinicworkingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
					}	
				
				 FI_VISIT_TYPE_APPL_YN = rs.getString("FI_VISIT_TYPE_APPL_YN");
				 FU_VISIT_TYPE_APPL_YN = rs.getString("FU_VISIT_TYPE_APPL_YN");
				 RT_VISIT_TYPE_APPL_YN = rs.getString("RT_VISIT_TYPE_APPL_YN");
				 SR_VISIT_TYPE_APPL_YN = rs.getString("SR_VISIT_TYPE_APPL_YN");
				 CS_VISIT_TYPE_APPL_YN = rs.getString("CS_VISIT_TYPE_APPL_YN");
			     EM_VISIT_TYPE_APPL_YN = rs.getString("EM_VISIT_TYPE_APPL_YN");
				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sqlmain.setLength(0);

				}catch(Exception e)
				{
					e.printStackTrace();
				}

				/********/
				sql1.append("select a.clinic_code clinic_code ,c.short_desc clinic_desc,a.practitioner_id practitioner_id,b.practitioner_name practitioner_name,a.eff_status eff_status ");
				sql1.append(",a.working_week_appl_day_1 working_week_appl_day_1,a.working_week_appl_day_2 working_week_appl_day_2,a.working_week_appl_day_3 working_week_appl_day_3,a.working_week_appl_day_4 working_week_appl_day_4,a.working_week_appl_day_5 working_week_appl_day_5,a.working_week_appl_day_6 working_week_appl_day_6,a.working_week_appl_day_7 working_week_appl_day_7 ");				
				sql1.append(",a.working_week_1_day_1 working_week_1_day_1,a.working_week_1_day_2 working_week_1_day_2,a.working_week_1_day_3 working_week_1_day_3,a.working_week_1_day_4 working_week_1_day_4,a.working_week_1_day_5 working_week_1_day_5,a.working_week_1_day_6 working_week_1_day_6,a.working_week_1_day_7 working_week_1_day_7");
				sql1.append(",a.working_week_2_day_1 working_week_2_day_1,a.working_week_2_day_2 working_week_2_day_2,a.working_week_2_day_3 working_week_2_day_3,a.working_week_2_day_4 working_week_2_day_4,a.working_week_2_day_5 working_week_2_day_5,a.working_week_2_day_6 working_week_2_day_6,a.working_week_2_day_7 working_week_2_day_7");		
				sql1.append(",a.working_week_3_day_1 working_week_3_day_1,a.working_week_3_day_2 working_week_3_day_2,a.working_week_3_day_3 working_week_3_day_3,a.working_week_3_day_4 working_week_3_day_4,a.working_week_3_day_5 working_week_3_day_5,a.working_week_3_day_6 working_week_3_day_6,a.working_week_3_day_7 working_week_3_day_7");		
				sql1.append(",a.working_week_4_day_1 working_week_4_day_1,a.working_week_4_day_2 working_week_4_day_2,a.working_week_4_day_3 working_week_4_day_3,a.working_week_4_day_4 working_week_4_day_4,a.working_week_4_day_5 working_week_4_day_5,a.working_week_4_day_6 working_week_4_day_6,a.working_week_4_day_7 working_week_4_day_7");
				sql1.append(",a.working_week_5_day_1 working_week_5_day_1,a.working_week_5_day_2 working_week_5_day_2,a.working_week_5_day_3 working_week_5_day_3,a.working_week_5_day_4 working_week_5_day_4,a.working_week_5_day_5 working_week_5_day_5,a.working_week_5_day_6 working_week_5_day_6,a.working_week_5_day_7 working_week_5_day_7,");
				sql1.append("a.fi_visit_type_appl_yn fi_visit_type_appl_yn,a.fu_visit_type_appl_yn fu_visit_type_appl_yn,a.rt_visit_type_appl_yn rt_visit_type_appl_yn,a.sr_visit_type_appl_yn sr_visit_type_appl_yn,a.cs_visit_type_appl_yn cs_visit_type_appl_yn,a.em_visit_type_appl_yn em_visit_type_appl_yn ");
				sql1.append(" from op_pract_for_clinic a,am_practitioner b,op_clinic c where a.facility_id='"+facilityid+"' and a.clinic_code='"+clinicmod+"' and a.practitioner_id='"+practitionerid+"' and a.practitioner_id=b.practitioner_id and a.clinic_code = c.clinic_code");
				
				pstmt=con.prepareStatement(sql1.toString());
				rs=pstmt.executeQuery();
				
				if(rs != null && rs.next())
				{
					
					clinicdesc=(rs.getString("clinic_desc") == null)?"":rs.getString("clinic_desc");
					practname=(rs.getString("practitioner_name") == null) ?"":rs.getString("practitioner_name");
					effstatus=(rs.getString("eff_status") == null)?"D":rs.getString("eff_status");
					

					for(int i=1;i<=7;i++)
					{
						workingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
						
							if(workingWeekApplday[i-1].equals("W"))
							{
							workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
						
						workingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
						
						workingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
						workingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
						workingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
						workingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
					}	
					firstchk=(rs.getString("fi_visit_type_appl_yn") == null)?"N":rs.getString("fi_visit_type_appl_yn");
					followchk=(rs.getString("fu_visit_type_appl_yn") == null)?"N":rs.getString("fu_visit_type_appl_yn");
					routinechk=(rs.getString("rt_visit_type_appl_yn") == null)?"N":rs.getString("rt_visit_type_appl_yn");
					serieschk=(rs.getString("sr_visit_type_appl_yn") == null)?"N":rs.getString("sr_visit_type_appl_yn");
					consultchk=(rs.getString("cs_visit_type_appl_yn") == null)?"N":rs.getString("cs_visit_type_appl_yn");
					emerchk=(rs.getString("em_visit_type_appl_yn") == null)?"N":rs.getString("em_visit_type_appl_yn");
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sql1.setLength(0);

		}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			fnval="insert";
		}
	}
	else if(callfunc.equals("Resource_unit"))
	{
		
		unittype=(request.getParameter("unit_type") == null)?"":request.getParameter("unit_type");
		care_locn_type_ind=(request.getParameter("care_locn_type") == null)?"":request.getParameter("care_locn_type");

		resunit=(request.getParameter("resource_unit") == null)?"":request.getParameter("resource_unit");
		resunit=resunit.trim();
		resclass=(request.getParameter("res_class") == null)?"":request.getParameter("res_class");
		practitionerid=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");
		

		if(!unittype.equals(""))
		{
			fnval="modify";
			try{

				try{
				
				sqlmain.append("select clinic_code,working_week_1_day_1,working_week_1_day_2,working_week_1_day_3,working_week_1_day_4,working_week_1_day_5,working_week_1_day_6,working_week_1_day_7");
					sqlmain.append(",working_week_2_day_1,working_week_2_day_2,working_week_2_day_3,working_week_2_day_4,working_week_2_day_5,working_week_2_day_6,working_week_2_day_7");
					sqlmain.append(",working_week_3_day_1,working_week_3_day_2,working_week_3_day_3,working_week_3_day_4,working_week_3_day_5,working_week_3_day_6,working_week_3_day_7");
					sqlmain.append(",working_week_4_day_1,working_week_4_day_2,working_week_4_day_3,working_week_4_day_4,working_week_4_day_5,working_week_4_day_6,working_week_4_day_7");
					sqlmain.append(",working_week_5_day_1,working_week_5_day_2,working_week_5_day_3,working_week_5_day_4,working_week_5_day_5,working_week_5_day_6,working_week_5_day_7 ");
					sqlmain.append(",working_week_appl_day_1,working_week_appl_day_2,working_week_appl_day_3,working_week_appl_day_4,working_week_appl_day_5,working_week_appl_day_6,working_week_appl_day_7 ");
					sqlmain.append(",working_day_1,working_day_2,working_day_3,working_day_4,working_day_5,working_day_6,working_day_7 ");
					sqlmain.append(",FI_VISIT_TYPE_APPL_YN,FU_VISIT_TYPE_APPL_YN,RT_VISIT_TYPE_APPL_YN,SR_VISIT_TYPE_APPL_YN,CS_VISIT_TYPE_APPL_YN,EM_VISIT_TYPE_APPL_YN ");
					sqlmain.append(" from op_clinic where clinic_code='"+resunit+"' and facility_id='"+facilityid+"'");

					pstmt=con.prepareStatement(sqlmain.toString());
					rs=pstmt.executeQuery();
				if(rs != null && rs.next())
				{

					for(int i=1;i<=7;i++)
					{
						clinicworkingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
						
							if(clinicworkingWeekApplday[i-1].equals("W"))
							{
							clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
						
						clinicworkingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
						
						clinicworkingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
						clinicworkingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
						clinicworkingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
						clinicworkingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
					}	
				 FI_VISIT_TYPE_APPL_YN = rs.getString("FI_VISIT_TYPE_APPL_YN");
				 FU_VISIT_TYPE_APPL_YN = rs.getString("FU_VISIT_TYPE_APPL_YN");
				 RT_VISIT_TYPE_APPL_YN = rs.getString("RT_VISIT_TYPE_APPL_YN");
				 SR_VISIT_TYPE_APPL_YN = rs.getString("SR_VISIT_TYPE_APPL_YN");
				 CS_VISIT_TYPE_APPL_YN = rs.getString("CS_VISIT_TYPE_APPL_YN");
			     EM_VISIT_TYPE_APPL_YN = rs.getString("EM_VISIT_TYPE_APPL_YN");

				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sqlmain.setLength(0);

				}catch(Exception e)
				{
					e.printStackTrace();
				}

				sql1.append("select a.care_locn_type_ind care_locn_type_ind,decode(a.care_locn_type_ind,'C','Clinic','E','Exam/Procedure Unit','D','Daycare Unit') unit_type_desc,a.resource_class resource_class,decode(a.resource_class,'P','Practitioner','R','Room','E','Equipment','O','Other') res_class_desc,a.resource_type resource_type,a.clinic_code clinic_code ,a.practitioner_id practitioner_id,decode(a.resource_class, 'P', b.practitioner_name,'R', d.short_desc, 'E', e.long_desc, 'O', e.short_desc) practitioner_name,a.eff_status eff_status ,c.long_desc res_unit_desc " );
				sql1.append(",a.working_week_appl_day_1 working_week_appl_day_1,a.working_week_appl_day_2 working_week_appl_day_2,a.working_week_appl_day_3 working_week_appl_day_3,a.working_week_appl_day_4 working_week_appl_day_4,a.working_week_appl_day_5 working_week_appl_day_5,a.working_week_appl_day_6 working_week_appl_day_6,a.working_week_appl_day_7 working_week_appl_day_7 ");		
				sql1.append(",a.working_week_1_day_1 working_week_1_day_1,a.working_week_1_day_2 working_week_1_day_2,a.working_week_1_day_3 working_week_1_day_3,a.working_week_1_day_4 working_week_1_day_4,a.working_week_1_day_5 working_week_1_day_5,a.working_week_1_day_6 working_week_1_day_6,a.working_week_1_day_7 working_week_1_day_7");
				sql1.append(",a.working_week_2_day_1 working_week_2_day_1,a.working_week_2_day_2 working_week_2_day_2,a.working_week_2_day_3 working_week_2_day_3,a.working_week_2_day_4 working_week_2_day_4,a.working_week_2_day_5 working_week_2_day_5,a.working_week_2_day_6 working_week_2_day_6,a.working_week_2_day_7 working_week_2_day_7");		
				sql1.append(",a.working_week_3_day_1 working_week_3_day_1,a.working_week_3_day_2 working_week_3_day_2,a.working_week_3_day_3 working_week_3_day_3,a.working_week_3_day_4 working_week_3_day_4,a.working_week_3_day_5 working_week_3_day_5,a.working_week_3_day_6 working_week_3_day_6,a.working_week_3_day_7 working_week_3_day_7");		
				sql1.append(",a.working_week_4_day_1 working_week_4_day_1,a.working_week_4_day_2 working_week_4_day_2,a.working_week_4_day_3 working_week_4_day_3,a.working_week_4_day_4 working_week_4_day_4,a.working_week_4_day_5 working_week_4_day_5,a.working_week_4_day_6 working_week_4_day_6,a.working_week_4_day_7 working_week_4_day_7");
				sql1.append(",a.working_week_5_day_1 working_week_5_day_1,a.working_week_5_day_2 working_week_5_day_2,a.working_week_5_day_3 working_week_5_day_3,a.working_week_5_day_4 working_week_5_day_4,a.working_week_5_day_5 working_week_5_day_5,a.working_week_5_day_6 working_week_5_day_6,a.working_week_5_day_7 working_week_5_day_7,");
				sql1.append("a.fi_visit_type_appl_yn fi_visit_type_appl_yn,a.fu_visit_type_appl_yn fu_visit_type_appl_yn,a.rt_visit_type_appl_yn rt_visit_type_appl_yn,a.sr_visit_type_appl_yn sr_visit_type_appl_yn,a.cs_visit_type_appl_yn cs_visit_type_appl_yn,a.em_visit_type_appl_yn em_visit_type_appl_yn ");
				sql1.append(" from op_pract_for_clinic a,am_practitioner b, op_clinic c,am_facility_room d , am_resource e where a.facility_id='"+facilityid+"' and a.clinic_code='"+resunit+"' and a.care_locn_type_ind='"+care_locn_type_ind+"' and a.resource_class = '"+resclass+"' and a.practitioner_id='"+practitionerid+"' and a.practitioner_id=b.practitioner_id(+) and a.clinic_code = c.clinic_code and a.facility_id = e.facility_id(+) AND a.resource_class = e.resource_class (+) and a.practitioner_id=e.resource_id(+) and a.facility_id = d.operating_facility_id(+) AND a.practitioner_id = d.room_num(+)");
				
			
				pstmt=con.prepareStatement(sql1.toString());
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{					
						care_locn_type_ind=(rs.getString("care_locn_type_ind")==null)?"":
							rs.getString("care_locn_type_ind");
						practname=(rs.getString("practitioner_name") == null) ?"":rs.getString("practitioner_name");

						unittypedesc=(rs.getString("unit_type_desc") == null) ?"":rs.getString("unit_type_desc");
						
						resclassdesc=(rs.getString("res_class_desc") == null) ?"":rs.getString("res_class_desc");

						restype=(rs.getString("resource_type") == null)?"":rs.getString("resource_type");

						resunitdesc=(rs.getString("res_unit_desc") == null)?"":rs.getString("res_unit_desc");

						effstatus=(rs.getString("eff_status") == null)?"D":rs.getString("eff_status");

						
						for(int i=1;i<=7;i++)
						{
							workingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
							if(workingWeekApplday[i-1].equals("W"))
							{
							workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
							
							workingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
							workingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
							workingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
							workingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
							workingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
						}	
						firstchk=(rs.getString("fi_visit_type_appl_yn") == null)?"N":rs.getString("fi_visit_type_appl_yn");
						followchk=(rs.getString("fu_visit_type_appl_yn") == null)?"N":rs.getString("fu_visit_type_appl_yn");
						routinechk=(rs.getString("rt_visit_type_appl_yn") == null)?"N":rs.getString("rt_visit_type_appl_yn");
						serieschk=(rs.getString("sr_visit_type_appl_yn") == null)?"N":rs.getString("sr_visit_type_appl_yn");
						consultchk=(rs.getString("cs_visit_type_appl_yn") == null)?"N":rs.getString("cs_visit_type_appl_yn");
						emerchk=(rs.getString("em_visit_type_appl_yn") == null)?"N":rs.getString("em_visit_type_appl_yn");
					}
				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sql1.setLength(0);

				if(effstatus.equals("D"))
				{
					if(resclass.equals("P"))
					{
						sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E'  and pract_type='"+restype+"' ";
					}
					else if(resclass.equals("R"))
					{
						sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' and locn_type='"+restype+"'";
					}
					else if(resclass.equals("E"))
					{
						sql="select resource_type,short_desc from am_resource_type where resource_class='E' and resource_type='"+restype+"' ";
					}
					else if(resclass.equals("O"))
					{
						sql="select resource_type,short_desc from am_resource_type where resource_class='O' and resource_type='"+restype+"' ";
					}
					if(!sql.equals(""))
					{
						try
						{
							pstmt=con.prepareStatement(sql);
							rs=pstmt.executeQuery();
							if(rs != null && rs.next())
							{
								restypedesc=(rs.getString(2) == null)?"":rs.getString(2);
							}

						 if(rs != null )rs.close();
						 if(pstmt != null ) pstmt.close();

						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}

			

			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		else
		{
			fnval="insert";
		}
	}
	



            _bw.write(_wl_block11Bytes, _wl_block11);

	if(callfunc.equals("Pract_for_clinic"))
	{
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

						if(fnval.equals("modify") && effstatus.equals("D"))
						{
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinicdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinicmod));
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
						else
						{
						if(fnval.equals("modify"))
							  disable="disabled";
                         else disable="";
						
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

							
								try
								{        
									sql=" Select clinic_code,long_desc from op_clinic where eff_status='E' and open_to_all_pract_yn='N' and facility_id = '"+facilityid+"' and clinic_type='C' and CARE_LOCN_TYPE_IND = 'C' and PRIMARY_RESOURCE_CLASS = 'P' order by long_desc  ";
									pstmt=con.prepareStatement(sql);
									rs = pstmt.executeQuery();
									if( rs != null )
									{
										while( rs.next())
										{			
											cliniccode=(rs.getString("clinic_code") == null)?"":rs.getString("clinic_code");	
											
											if(clinicmod.equals(cliniccode))
											{
												sel="selected";
											}
											else
											{
												sel="";
											}
											
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((rs.getString("long_desc") == null)?"":rs.getString("long_desc") ));
            _bw.write(_wl_block23Bytes, _wl_block23);

										}
				   
									}
									if (pstmt != null) pstmt.close();
									if (rs != null) rs.close();
						
								}catch(Exception e)
								{
									e.printStackTrace();
								}
							
            _bw.write(_wl_block24Bytes, _wl_block24);

						}
						
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

						if(fnval.equals("modify") || effstatus.equals("D"))
						{
							disable="disabled";
							readonly="readonly";
						}
						else
						{
							disable="";
							readonly="";
						}
						
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

							if(effstatus.equals("E"))
							{
								chkval="checked";
							}
							else
							{
								chkval="";
							}
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block35Bytes, _wl_block35);

			}
			else if(callfunc.equals("Resource_unit"))
			{
				String unittypecode="";
				String unittypedesc1="";
			
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(unittypedesc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(unittype));
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							else
							{	
							
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

								pstmt=con.prepareStatement("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in('C','E','Y') and sys_user_def_ind='S' order by 2");
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										unittypecode=rs.getString("locn_type");
										unittypedesc1=rs.getString("short_desc");

										
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(unittypecode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(unittypedesc1));
            _bw.write(_wl_block45Bytes, _wl_block45);

									}
								}

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								
            _bw.write(_wl_block46Bytes, _wl_block46);
									
								if(fnval.equals("modify"))
								{
								
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(unittype));
            _bw.write(_wl_block48Bytes, _wl_block48);

								}							
							}
							
							
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(resunitdesc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(resunit));
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
							else
							{
								//ValidateResName(this);
								if(fnval.equals("modify"))
								{
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(resunitdesc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(resunit));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
}else{
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

								}					
							}
							
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(resclassdesc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(resclass));
            _bw.write(_wl_block65Bytes, _wl_block65);

							}
							else
							{
															
							
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(care_locn_type_ind.equals("D")&&fnval.equals("modify"))
								{
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
}else{
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);

								if(fnval.equals("modify"))
								{
								
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(resclass));
            _bw.write(_wl_block75Bytes, _wl_block75);

								}
								
							
            _bw.write(_wl_block76Bytes, _wl_block76);

							}
							
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(restypedesc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(restype));
            _bw.write(_wl_block81Bytes, _wl_block81);

							}
							else
							{
							
            _bw.write(_wl_block82Bytes, _wl_block82);
if(fnval.equals("insert"))
									{
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
}else{
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
	
							  try{
									if(fnval.equals("modify"))
									{
										if(resclass.equals("P"))
										{
											sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E' order by desc_sysdef";
										}
										else if(resclass.equals("R"))
										{
											sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
										}
										else if(resclass.equals("E"))
										{
											sql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
										}
										else if(resclass.equals("O"))
										{
											sql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
										}

										if(!sql.equals(""))
										{
											pstmt=con.prepareStatement(sql);
											rs=pstmt.executeQuery();
											if(rs != null)
											{
												
												while(rs.next())
												{
													restypecode=( rs.getString(1)== null)?"": rs.getString(1);
													
														
													if(restypecode.equals(restype))
													{
														sel="selected";
													}
													else
													{
														sel="";
													}
													
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(restypecode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block88Bytes, _wl_block88);

														}
												}
											}
											if(pstmt != null) pstmt.close();
											if(rs != null) rs.close();

										}						
										
									
								}catch(Exception e)
								{
									e.printStackTrace();
								}
							
							  }
            _bw.write(_wl_block89Bytes, _wl_block89);

								}
								
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

							if(fnval.equals("modify") || effstatus.equals("D"))
							{
								disable="disabled";
								readonly="readonly";
								disable1="";
							}
							else if(!fnval.equals("modify"))
							{
								disable="disabled";
								//disable="";
								readonly="";
								disable1="disabled";
							}
							else
							{
								disable="";
								readonly="";
							}
							// <%=disable
							
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

							if(effstatus.equals("E"))
							{
								chkval="checked";
							}
							else
							{
								chkval="";
							}
							
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block99Bytes, _wl_block99);

			}
			
            _bw.write(_wl_block100Bytes, _wl_block100);

								try
								{
									pstmt=con.prepareStatement("select day_no,day_of_week from sm_day_of_week order by day_no");
									rs = pstmt.executeQuery();
									if(rs != null)
									{
										while(rs.next())
										{
											daysofweek = rs.getString("day_of_week").substring(0,3);
											
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(daysofweek));
            _bw.write(_wl_block102Bytes, _wl_block102);

										}
										
									}
									if(pstmt != null) pstmt.close();
									if( rs != null) rs.close();
								}catch(Exception e)
								{
									e.printStackTrace();
								}
								
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

								for(int j=1;j<=7;j++)
								{									
								
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(j));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(clinicworkingWeekApplday[j-1]));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(j));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            _bw.write(_wl_block110Bytes, _wl_block110);

								}
								
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek1day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
									
							
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(j));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(clinicworkingweek1day[j-1]));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block117Bytes, _wl_block117);

							}
							
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek2day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(j));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(j));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(clinicworkingweek2day[j-1]));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block123Bytes, _wl_block123);

							}
							
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek3day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(j));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(j));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(clinicworkingweek3day[j-1]));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block123Bytes, _wl_block123);

							}
							
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek4day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(j));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(j));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(clinicworkingweek4day[j-1]));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block123Bytes, _wl_block123);

							}
							
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek5day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(j));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(j));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(clinicworkingweek5day[j-1]));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block123Bytes, _wl_block123);

							}
							
            _bw.write(_wl_block137Bytes, _wl_block137);

							try
							{
								pstmt=con.prepareStatement("select day_no,day_of_week from sm_day_of_week order by day_no");
								if (rs != null) rs.close();
								rs = pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{										
										daysofweek = rs.getString("day_of_week").substring(0,3);
										
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(daysofweek));
            _bw.write(_wl_block139Bytes, _wl_block139);

										
									}													
								}
								if(pstmt != null) pstmt.close();
								if( rs != null) rs.close();
							}catch(Exception e)
							{
								e.printStackTrace();
							}
							
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);

							
								
							for(int i=1;i<=7;i++)
							{
								
								

						

								

						if(fnval.equals("modify") && effstatus.equals("D"))
								{	
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(workingweekappldesc[i-1]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(workingWeekApplday[i-1]));
            _bw.write(_wl_block147Bytes, _wl_block147);
	}
								else
								{	
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

									if(fnval.equals("modify"))
									{
									
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(workingWeekApplday[i-1]));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(clinicworkingWeekApplday[i-1]));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block155Bytes, _wl_block155);

									}
								   					 
								}
								
							}
							
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

							
							
							for(int j=1;j<=7;j++)
							{
									chkval="";
									disable="";
									
									if(workingweek1day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek1day[j-1].equals("N"))
									{
										
										if(clinicworkingweek1day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
										
									}
									else
									{
										
										if((clinicworkingweek1day[j-1].equals("H")) && (workingweek1day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							
							
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(j));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(j));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(workingweek1day[j-1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(j));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(j));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(workingweek1day[j-1]));
            _bw.write(_wl_block163Bytes, _wl_block163);

							}
							
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

							for(int j=1;j<=7;j++)
							{		
									chkval="";
									disable="";
									if(workingweek2day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek2day[j-1].equals("N"))
									{
										if(clinicworkingweek2day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										if((clinicworkingweek2day[j-1].equals("H")) && (workingweek2day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(j));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(j));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(workingweek2day[j-1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(j));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(j));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(workingweek2day[j-1]));
            _bw.write(_wl_block163Bytes, _wl_block163);

							}
							
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

							for(int j=1;j<=7;j++)
							{	
									chkval="";
									disable="";
									
									if(workingweek3day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek3day[j-1].equals("N"))
									{
										if(clinicworkingweek3day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										if((clinicworkingweek3day[j-1].equals("H")) && (workingweek3day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(j));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(j));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(workingweek3day[j-1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(j));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(j));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(workingweek3day[j-1]));
            _bw.write(_wl_block163Bytes, _wl_block163);

							}
							
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

							for(int j=1;j<=7;j++)
							{	
									chkval="";
									disable="";
								if(workingweek4day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek4day[j-1].equals("N"))
									{
										if(clinicworkingweek4day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										

										if((clinicworkingweek4day[j-1].equals("H")) && (workingweek4day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
						
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(j));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(j));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(workingweek4day[j-1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(j));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(j));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(workingweek4day[j-1]));
            _bw.write(_wl_block163Bytes, _wl_block163);

							}
							
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

							for(int j=1;j<=7;j++)
							{		
								chkval="";
									disable="";
									if(workingweek5day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek5day[j-1].equals("N"))
									{
										if(clinicworkingweek5day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										if((clinicworkingweek5day[j-1].equals("H")) && (workingweek5day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(j));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(j));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(workingweek5day[j-1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(j));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(j));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(workingweek5day[j-1]));
            _bw.write(_wl_block163Bytes, _wl_block163);

							}
							
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

											chkval="";
											disable="";
											if(emerchk.equals("Y"))
											{
												chkval="checked";
											}
											else if(emerchk.equals("N"))
											{
												if(EM_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}

									
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(emerchk));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(emerchk));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

											chkval="";
											disable="";
											if(firstchk.equals("Y"))
											{
												chkval="checked";
												
											}
											else if(firstchk.equals("N"))
											{
												if(FI_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}

									
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(firstchk));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(firstchk));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

											chkval="";
											disable="";
										if(followchk.equals("Y"))
											{
												chkval="checked";
											}
											else if(followchk.equals("N"))
											{
												if(FU_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
										
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(followchk));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(followchk));
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

											chkval="";
											disable="";
											if(routinechk.equals("Y"))
											{
												chkval="checked";
											}
											else if(routinechk.equals("N"))
											{
												if(RT_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
									
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(routinechk));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(routinechk));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

											chkval="";
											disable="";
											if(serieschk.equals("Y"))
											{
												chkval="checked";
											}
											else if(serieschk.equals("N"))
											{
												if(SR_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
										
									
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(serieschk));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(serieschk));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

											chkval="";
											disable="";
											if(consultchk.equals("Y"))
											{
												chkval="checked";
											}
											else if(consultchk.equals("N"))
											{
												if(CS_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
									
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(consultchk));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(consultchk));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(callfunc));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block209Bytes, _wl_block209);

	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}


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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourceclass.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcename.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WeekAppl.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.specific.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WeekAppl.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.specific.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.ApplicableVisitTypeIndicators.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.first.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.followup.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Series.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Consult.label", java.lang.String .class,"key"));
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
}
