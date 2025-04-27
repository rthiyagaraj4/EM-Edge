package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __dprecodingaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingAddModify.jsp", 1742299603194L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n</head>\n<script>\nfunction imposeMaxLength(obj,maxlength){\n\treturn (obj.value.length < maxlength);\n\n}\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\tparent.RecodeScreen.rows=\"47%,47%,5%,0%\";\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\n<body onKeyDown=\'lockKey()\'>\n<form name=\'DiagProcAddModify\' id=\'DiagProcAddModify\' action=\'../../servlet/eMR.DiagProcRecodingServlet\' onLoad=\'chkDiag();\' method=\'post\' target=\"messageFrame\">\n\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\"100%\">\n\t\t<tr><td class=\'PANELTOOLBAR\' colspan=\'6\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' name=\'sel_item1\' id=\'sel_item1\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' readonly></td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<input type=\'hidden\' name=\'sel_item1\' id=\'sel_item1\' value=\'\'>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td width=\'18%\' class=\'fields\'>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<select name=\"code_set\" id=\"code_set\">\n\t\t\t\t<!-- <option value=\'\'>----- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" -----</option> -->\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' selected>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td width=\'18%\' class=\'fields\'>\n\t\t\t\t<select name=\"code_set\" id=\"code_set\"> \n\t\t\t\t<!-- <option value=\'\'>----- ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' selected> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td class=\'label\' colspan=\'1\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\'text\' name=\'diagprob_code\' id=\'diagprob_code\' size=\'5\' onblur=\'getDescription(1);\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">&nbsp;<input type=\"text\"  name=\"diagprob_desc\" id=\"diagprob_desc\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" size=\"22\" readonly onblur=\'\'  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="><input type=\'button\' class=\'button\' value=\'?\' onclick=\'callTermCode(1);\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="><img  src=\'../../eCommon/images/mandatory.gif\'><span nowrap title=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"long_desc_0\" style=\"cursor:pointer;display:";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><a href=\"javascript:showLongDescription(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'0\')\" ><b>!</b></a></span>&nbsp;<input type=\'button\' class=\'button\' value=\'+\' onclick=\'addTermSet(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =");\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="><input type=\"hidden\" name=\'long_desc_val_0\' id=\'long_desc_val_0\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/>\n\t\t\t</td>\n\t\t\t<input type=\'hidden\' name=\"hid_diagprob_code_0\" id=\"hid_diagprob_code_0\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<td class=\'label\' width=\'12%\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td class=\'fields\' width=\'18%\'>\n\t\t\t\t\t\t<select name=\"proc_type\" id=\"proc_type\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" onchange=\"showProcdatestimes(this)\" >\n\t\t\t\t\t\t\t<option value=\"\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">---Select---</option>\n\t\t\t\t\t\t\t<option value=\"OT\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\t\t\t\t\t\t\t<option value=\"NO\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t\t\t</select>&nbsp;<img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t<tr id=\'t1\' style=\'visibility:hidden;display:none\'>\n\t\t\t<td class=\'label\' width=\'12%\' ></td>\n\t\t\t<td class=\'fields\' width=\'18%\'><input type=\'textbox\' name=\'diagprob_code1\' id=\'diagprob_code1\' size=\'5\' onblur=\'getDescription(2);\'>&nbsp;<input type=\"text\"  name=\"diagprob_desc1\" id=\"diagprob_desc1\" value=\"\" size=22 readonly onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' onclick=\'callTermCode(2);\' >&nbsp;&nbsp;<span nowrap title=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"long_desc_1\" style=\"cursor:pointer;display:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'1\')\"><b>!</b></a></span>&nbsp;<input type=\'hidden\' name=\"hid_diagprob_code_1\" id=\"hid_diagprob_code_1\" value=\"\"><input type=\"hidden\" name=\'long_desc_val_1\' id=\'long_desc_val_1\' value=\"\"/></td>\n\t\t</tr>\n\t\t<tr id=\'t2\' style=\'visibility:hidden;display:none\'>\n\t\t\t<td class=\'label\' width=\'12%\' ></td>\n\t\t\t<td class=\'fields\' width=\'18%\'><input type=\'textbox\' name=\'diagprob_code2\' id=\'diagprob_code2\' size=\'5\' onblur=\'getDescription(3);\'>&nbsp;<input type=\"text\"  name=\"diagprob_desc2\" id=\"diagprob_desc2\" value=\"\" size=22 readonly onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' onclick=\'callTermCode(3);\'>&nbsp;&nbsp;<span nowrap title=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"long_desc_2\" style=\"cursor:pointer;display:";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'2\')\"><b>!</b></a></span>&nbsp;<input type=\'hidden\' name=\"hid_diagprob_code_2\" id=\"hid_diagprob_code_2\" value=\"\"><input type=\"hidden\" name=\'long_desc_val_2\' id=\'long_desc_val_2\' value=\"\"/></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'18%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"proc_cd_xtn\" id=\"proc_cd_xtn\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" size=\'2\' maxlength=\'2\' onkeypress=\'return allowValidNumber(this,event,2, 0);\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"proc_cd_xtn\" id=\"proc_cd_xtn\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'18%\'>\n\t\t\t\t\t\t\t\t\t<select name=\"proc_laterality\" id=\"proc_laterality\" ><option value=\'\'>----- ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" -----</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"L\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"R\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"B\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"N\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t<input type=\"hidden\"  name=\"proc_laterality\" id=\"proc_laterality\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t<!--\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'==\"Y\"){\n\t\t\t\t\t\t\tpopulateLateralityVal(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');\n\t\t\t\t\t}\n\t\t\t\t//-->\n\t\t\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t</tr>\n\t\t<tr  id=\"proc_dt_times\" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n\t\t\t<td class=\'label\' colspan=\'1\' nowrap><label id=\"id_start_dt_time\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</label></td>\n\t\t\t<td class=\'spanData\'   colspan=\'2\' nowrap>\n\t\t\t\t<input type=\"text\"  name=\"start_dt_time\" id=\"start_dt_time\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" size=\'18\' maxlength=\'18\' onblur=\"procDateValidation(this)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'start_dt_time\',\'dd/mm/yyyy\',\'hh:24mi\');\"/></select><img id=\'start_mand\'  src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t<span >\n\t\t\t\t\t<label id=\"id_end_dt_time\" >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</label>&nbsp;<input type=\"text\"  name=\"end_dt_time\" id=\"end_dt_time\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" size=\'18\'  maxlength=\'18\' onblur=\"procDateValidation(this)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'end_dt_time\',\'dd/mm/yyyy\',\'hh:24mi\');\"/><img id=\'end_mand\'   src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\t\t\t\n\t\t\t\t</span>\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<tr> \n\t\t\t\t<td class=\"label\" width=\'12%\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t<td width=\'18%\' class=\'fields\'><select name=\"status\" id=\"status\" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =">\n\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t<option value=\'X\' ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" <!-- MODIFIED by mujafar for ML-MMOH-CRF-1270 -->\n\t\t\t\t</td><td class=\'fields\' width=\'18%\'><textarea name=\"remarks\"  rows=\"2\" cols=\"40\" maxlength=\'30\' onBlur=\"makeValidString(this);checkMaxLimitOfRemark(this);checkQuote();\" onkeypress=\"return imposeMaxLength(this, 30);\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</textarea></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<td class=\'label\' width=\'12%\' >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t<td class=\'fields\' width=\'32%\'>\n\t\t\t<input type=\'textbox\' name=\'diagprob_code\' id=\'diagprob_code\' size=\'5\' onblur=\'if(document.forms[0].dflt_termset.value != \"\")getDescription(1);\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" size=22 readonly onblur=\'\' ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="><input type=\'button\' class=\'button\' value=\'?\' onclick=\'show_window(1);\' ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="><img  src=\'../../eCommon/images/mandatory.gif\'>&nbsp;<span nowrap title=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\',\'0\')\"><b>!</b></a></span>&nbsp;<input type=\'button\' class=\'button\' value=\'+\' onclick=\'recordSupportDiagnosis(0,\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\",\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\");\' name=\"spprt_diag_btn_0\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" disabled title=\"Supporting Diagnosis\" >&nbsp;<input id=\'addDiag\' type=\'button\' class=\'button\' value=\'+\' onclick=\'addTermSet(";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="> <input type=\'hidden\' name=\"code_indicator_0\" id=\"code_indicator_0\" value=\"\">\n\t\t</td>\n\t\t<input type=\'hidden\' name=\"record_assosicate_codes_0\" id=\"record_assosicate_codes_0\" value=\"\">\n\t\t<input type=\'hidden\' name=\"hid_diagprob_code_0\" id=\"hid_diagprob_code_0\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\" name=\'long_desc_val_0\' id=\'long_desc_val_0\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"/>\n\t\t\n\t\t\t\t<!--  added by mujafar for ML-MMOH-CRF-1281 -->\n\t\t\n\t\t<td class=\'label\' width=\'12%\' id=\'other_disp1\' name=\'other_disp1\' style =\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="s </td>\n\t\t<td class=\'fields\' width=\'20%\' id=\'other_disp2\' name=\'other_disp2\' style =\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >\n\t\t<select name=\'term_oth_desc\' id=\'term_oth_desc\' id=\'term_oth_desc\' style=\'width:100\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" >\n\t\t<option value=\'\'>-- ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" --</option>\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" > ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</option>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t</select><img src= \'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\n\t\t<!--   added by mujafar for ML-MMOH-CRF-1281 -->\n\t\t\n\t\t\n\t\t\n\t\t</tr>\n\t\t<tr id=\'t1\' style=\'visibility:hidden;display:none\'>\n\t\t\t<td class=\'label\' width=\'12%\' ></td>\n\t\t\t<td class=\'fields\' width=\'32%\'>\n\t\t\t\t<input type=\'textbox\' name=\'diagprob_code1\' id=\'diagprob_code1\' size=\'5\' onblur=\'getDescription(2);\'>&nbsp;<input type=\"text\"  name=\"diagprob_desc1\" id=\"diagprob_desc1\" value=\"\" size=22 readonly onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' onclick=\'show_window(2);\' >&nbsp;&nbsp;&nbsp;&nbsp;<span nowrap title=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\',\'1\')\"><b>!</b></a></span>&nbsp;<input type=\'button\' class=\'button\' name=\"spprt_diag_btn_1\" id=\"spprt_diag_btn_1\" value=\'+\' onclick=\'recordSupportDiagnosis(1,\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\");\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" disabled title=\"Supporting Diagnosis\" >&nbsp;<input type=\'hidden\' name=\"code_indicator_1\" id=\"code_indicator_1\" value=\"\">&nbsp;<input type=\'hidden\' name=\"record_assosicate_codes_1\" id=\"record_assosicate_codes_1\" value=\"\">&nbsp;<input type=\'hidden\' name=\"hid_diagprob_code_1\" id=\"hid_diagprob_code_1\" value=\"\">\t<input type=\"hidden\" name=\'long_desc_val_1\' id=\'long_desc_val_1\' value=\"\"/>\n\n\t\t</td>\n\t\t</tr>\n\t\t<tr id=\'t2\' style=\'visibility:hidden;display:none\'>\n\t\t\t<td class=\'label\' width=\'12%\' ></td>\n\t\t\t<td class=\'fields\' width=\'32%\'>\n\t\t\t\t<input type=\'textbox\' name=\'diagprob_code2\' id=\'diagprob_code2\' size=\'5\' onblur=\'getDescription(3);\'>&nbsp;<input type=\"text\"  name=\"diagprob_desc2\" id=\"diagprob_desc2\" value=\"\" size=22 readonly onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' onclick=\'show_window(3);\' >&nbsp;&nbsp;&nbsp;&nbsp;<span nowrap title=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\',\'2\')\"><b>!</b></a></span>&nbsp;<input type=\'button\' name=\"spprt_diag_btn_2\" id=\"spprt_diag_btn_2\" class=\'button\' value=\'+\' onclick=\'recordSupportDiagnosis(2,\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" disabled title=\"Supporting Diagnosis\" >&nbsp;<input type=\'hidden\' name=\"code_indicator_2\" id=\"code_indicator_2\" value=\"\">&nbsp;<input type=\'hidden\' name=\"record_assosicate_codes_2\" id=\"record_assosicate_codes_2\" value=\"\">&nbsp;<input type=\'hidden\' name=\"hid_diagprob_code_2\" id=\"hid_diagprob_code_2\" value=\"\"><input type=\"hidden\" name=\'long_desc_val_2\' id=\'long_desc_val_2\' value=\"\"/>\n\n\t\t\t</td>\n\t\t</tr>\n\t\t\n\t\t<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t\t<td class=\'fields\' width=\'18%\'><textarea name=\"doctor_desc\"  rows=\"2\" cols=\"55\" maxlength=\'100\' onBlur=\"makeValidString(this);checkMaxLimitOfDoctorsDesc(this);\" onkeypress=\"return imposeMaxLength(this, 100);\" ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</textarea><img  style=\"visibility:";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t<!--End ML-MMOH-CRF-1269-->\n\n\t\t<!-- In Below lines added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300 -->\n\t\t<!-- Below condition is changed for ML-MMOH-CRF-1581 BY KAMATCHI S-->\n\t\t ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" \n\t\t<tr>\n\t\t<td class=\'label\' width=\'12%\' id=\'enc_stage_tab_id\'  style=\'\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\t\t\n\t\t<td class=\'fields\' width=\'18%\' id=\'enc_stage_tab_id1\'  style=\'\'><select name=\'diag_stage\' id=\'diag_stage\' ><option value=\'\'>----- ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" -----</option>\n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t</select><img src= \'../../eCommon/images/mandatory.gif\' id=\'enc_stage_tab_img\'></td></tr>\t\t\n\t\t ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="  \n\t\t  <tr>  \n\t\t<td class = \'label\' width=\'12%\'>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t\t<td class=\'fields\' width=\'18%\'><textarea type=\'textarea\' name=\'complaint_desc\' value=\'\' readonly >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</textarea><input type=\'hidden\' name=\'complaint_id\' id=\'complaint_id\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'></input><input type=\'button\' name=\'ComplaintSrch\' id=\'ComplaintSrch\' value=\'?\'  OnClick=\'selectProblem();\' class=\'button\'  ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="disabled";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" ></input></td>\n\t\t ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" \n\t\t <tr>\n\t\t   <td class = \'label\' width=\'12%\' colspan=\'2\'></td>  \n\t\t  ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="   \n\t\t  <td  class=\"label\" width=\'20%\' >";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =" </td>\n\t\t  ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t      <td  class=\"label\" width=\'20%\' >";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->\n\t\t  ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t<td  class=\"fields\" width=\'20%\' >   \n\t\t\t<select name=\"notification_setup\" id=\"notification_setup\" onchange=\'EnableNotifySetup()\'  >   \n\t\t\t <OPTION value=\"\">---------- ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="----------</option> \n\t\t\t ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t</select>  \n\t\t</td> </tr>\t \n\t     ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t \t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t<tr>\t\n\t\t\t<td  class=\"label\" width=\'20%\' id=\'diag_classf_legend\'>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t</td>\n\t\t\t<td  class=\"fields\" width=\'20%\' >\n\t\t\t\t<select name=\"diag_classfication\" id=\"diag_classfication\"  id=\'diag_classf_desc\' onchange=\"restirctPrimaryDiag(this)\">\n\t\t\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" -----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<span>";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</span>\n\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t<td  class=\"label\" width=\'20%\' >";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'20%\'><select name=\"accuracy\" id=\"accuracy\" ><option value=\'\'>----- ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =" -----</option>\n\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t<input type=\'hidden\' name=\'accuracy\' id=\'accuracy\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'18%\'><select name=\"severity\" id=\"severity\" ><option value=\'\'>----- ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" -----</option>\n\t\t\t\t\t<option value=\'D\' ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</option>\n\t\t\t\t\t<option value=\'L\' ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</option>\n\t\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</option>\n\t\t\t\t\t<option value=\'E\' ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</option>\n\t\t\t\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t<input type=\'hidden\' name=\'severity\' id=\'severity\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'18%\'><select name=\"priority\" id=\"priority\" ><option value=\'\'>----- ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n\n\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t<tr>\t\n\t\t\t<td class=\'label\' width=\'12%\' id=\"onset_type_tabid\" style=\'\' >";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t\t\t<td width=\'18%\' class=\'fields\'><select name=\"onset_type\" id=\"onset_type\" ><option value=\'\'>----- ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =" -----</option><option value=\'N\' ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" >";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</option><option value=\'A\' ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</option><option  value=\'C\' ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</option>\n\t\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t<input type=\'hidden\' name=\'onset_type\' id=\'onset_type\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' name=\'onset_date\' id=\'onset_date\'  value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' id=\'date1\' size=\'18\' maxlength=\'18\' Onblur=\"validateDatetime(this,getLabel(\'Common.onsetdate.label\',\'Common\'))\" ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'onset_date\',\'dd/mm/yyyy\',\'hh:24mi\');\" ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="/><img  src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</td>\n\t\t\t<td width=\'20%\' class=\'fields\'><input type=\'text\' name=\'status_date\' id=\'status_date\' size=\'18\' maxlength=\'18\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' Onblur=\"validateDate(this,getLabel(\'Common.Ason.label\',\'Common\'))\" ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'status_date\');\" ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="/><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t<input type=\'hidden\' name=\'status_date\' id=\'status_date\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\n\t\t\t\t<td class=\'fields\'><select name=\"applicable_side\" id=\"applicable_side\"><option value=\'\'>----- ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" -----</option>\n\t\t\t\t<option value=\'L\' ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</option>\n\t\t\t\t<option  value=\'R\' ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</option>\n\t\t\t\t<option value=\'B\' ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</option>\n\t\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'applicable_side\' id=\'applicable_side\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\t\n\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="<!-- modified by mujafar for ML-MMOH-CRF-1270 -->\n\t\t\t\t</td><td class=\'fields\' width=\'18%\'><textarea name=\"remarks\"  rows=\"2\" cols=\"40\" maxlength=\'30\' onBlur=\"makeValidString(this);checkMaxLimitOfRemark(this);checkQuote();\" onkeypress=\"return imposeMaxLength(this, 30);\" ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\n\n\t\t<tr>\n\t\t\t<td width=\'20%\' class=\'label\'></td>\n\t\t\t<td width=\'20%\' class=\'label\'></td>\n\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t<td width=\'20%\'><input type=\'button\' name=\'Save\' id=\'Save\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' class=\'button\' onclick=\'recodeVal();\'>&nbsp;<!-- <input type=\'button\' name=\'reset\' id=\'reset\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' onclick=\'resetAddModify();\' class=\'button\'> --><input type=\'button\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'  class=\'button\' onclick=\"resetProcdatetimes()\"></td>\n\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t<tr>\n\t</table>\n\t<input type=\'hidden\' name=\'dumy_onset\' id=\'dumy_onset\' value=\"\">\n\t<input type=\'hidden\' name=\'sel_code\' id=\'sel_code\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n\t<input type=\'hidden\' name=\'sel_code1\' id=\'sel_code1\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n\t<input type=\'hidden\' name=\'Pat_id\' id=\'Pat_id\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n\t<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n\t<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n\t<input type=\'hidden\' name=\'srl_no\' id=\'srl_no\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\'>\n\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'>\n\t<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>\n\t<input type=\'hidden\' name=\'dflt_termset\' id=\'dflt_termset\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n\t<input type=\'hidden\' name=\'EncounterId\' id=\'EncounterId\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n\t<input type=\'hidden\' name=\'Patient_Class\' id=\'Patient_Class\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n\t<input type=\'hidden\' name=\'confirm_appl\' id=\'confirm_appl\' value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\"> <!-- added by mujafar for ML-MMOH-CRF-0878 -->\n\t<input type=\'hidden\' name=\'caused_death\' id=\'caused_death\' value=\'N\'>\n\t<input type=\'hidden\' name=\'occur_srl_no\' id=\'occur_srl_no\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\n\t<input type=\'hidden\' name=\'recode_status\' id=\'recode_status\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\n\t<input type=\'hidden\' name=\'orig_termset\' id=\'orig_termset\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\n\t<input type=\'hidden\' name=\'orig_termcode\' id=\'orig_termcode\' value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'>\n\t<input type=\'hidden\' name=\'procedure_yn\' id=\'procedure_yn\' value=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\'>\n\t<input type=\'hidden\' name=\'newCode_yn\' id=\'newCode_yn\' value=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'>\n\t<input type=\'hidden\' name=\'accuracy_appl_yn\' id=\'accuracy_appl_yn\' value=\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n\t<input type=\'hidden\' name=\'severity_appl_yn\' id=\'severity_appl_yn\' value=\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'>\n\t<input type=\'hidden\' name=\'priority_appl_yn\' id=\'priority_appl_yn\' value=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'>\n\t<input type=\'hidden\' name=\'onset_date_appl_yn\' id=\'onset_date_appl_yn\' value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'>\n\t<input type=\'hidden\' name=\'as_on_date_appl_yn\' id=\'as_on_date_appl_yn\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'>\n\t<input type=\'hidden\' name=\'i\' id=\'i\' value=\'\'>\n\t<input type=\'hidden\' name=\'termcode_cnt\' id=\'termcode_cnt\' value=\'\'>\t\t\n\t<input type=\'hidden\' name=\'sel_item\' id=\'sel_item\' value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'>\n\t<input type=\'hidden\' name=\'sel_srl_no\' id=\'sel_srl_no\' value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'>\n\t<input type=\'hidden\' name=\'sel_term_code\' id=\'sel_term_code\' value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'>\n\t<input type=\'hidden\' name=\'sel_term_set\' id=\'sel_term_set\' value=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'>\n\t<input type=\'hidden\' name=\'activity\' id=\'activity\' value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'>\n\n\t<input type=\'hidden\' name=\'currentdate\' id=\'currentdate\' value=\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'>\n\t<input type=\'hidden\' name=\'onset_type_appl_yn\' id=\'onset_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'>\n\t<input type=\'hidden\' name=\'status_appl_yn\' id=\'status_appl_yn\' value=\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>\n\t<input type=\'hidden\' name=\'proc_status_appl_yn\' id=\'proc_status_appl_yn\' value=\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'>\n\t<input type=\'hidden\' name=\'sel_stages_val\' id=\'sel_stages_val\' value=\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\'>\n\t<input type=\'hidden\' name=\'sel_status\' id=\'sel_status\' value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\n\t<input type=\'hidden\' name=\'grpby_val\' id=\'grpby_val\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\n\t<input type=\'hidden\' name=\'sel_mod_id\' id=\'sel_mod_id\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'><!-- Added On 7/10/2009 -->\n\t<input type=\'hidden\' name=\'sel_cod_xtn\' id=\'sel_cod_xtn\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'><!-- Added On 7/10/2009 -->\n\t<input type=\'hidden\' name=\'sel_cod_xtn_dtl\' id=\'sel_cod_xtn_dtl\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'><!-- Added On 7/10/2009 -->\n\t<input type=\'hidden\' name=\'allow_recode_diag_yn\' id=\'allow_recode_diag_yn\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'>\n\t<input type=\'hidden\' name=\'allow_recode_proc_yn\' id=\'allow_recode_proc_yn\' value=\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\'>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\'>\n\t<!-- Added On 12/12/2009 for SRR-CRF-303.1 -->\n\t<input type=\'hidden\' name=\'pat_visit_dt_time\' id=\'pat_visit_dt_time\' value=\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\'>\n\t<input type=\'hidden\' name=\'pat_disch_dt_time\' id=\'pat_disch_dt_time\' value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\'>\n\t<input type=\'hidden\' name=\'proc_type_hid_yn\' id=\'proc_type_hid_yn\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'>\n\t<input type=\'hidden\' name=\'laterality_ind\' id=\'laterality_ind\' value=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'>\n\t<!-- Added For 303.1 -->\n\t<input type=\'hidden\' name=\'proc_srt_dt_hid\' id=\'proc_srt_dt_hid\' value=\"Y\">\n\t<input type=\'hidden\' name=\'proc_end_dt_hid\' id=\'proc_end_dt_hid\' value=\"Y\">\n\t<!-- Added For 303.2 -->\n\t<input type=\'hidden\' name=\'dagger_independent_yn_0\' id=\'dagger_independent_yn_0\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t<input type=\'hidden\' name=\'dagger_independent_yn_1\' id=\'dagger_independent_yn_1\' value=\"N\">\n\t<input type=\'hidden\' name=\'dagger_independent_yn_2\' id=\'dagger_independent_yn_2\' value=\"N\">\n\t<input type=\'hidden\' name=\'hdr_modified_dt\' id=\'hdr_modified_dt\' value=\"\">\n\t<!--//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234-->\n\t<input type=\'hidden\' name=\'diagnosis_by_long_desc_yn\' id=\'diagnosis_by_long_desc_yn\' value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t <!--Below lines hidden fields are added against HAS-CRF-300 -->\n    <input type=\'hidden\' name=\'diag_enc_level\' id=\'diag_enc_level\' value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t<input type=\'hidden\' name=\'notifiable_form_mand_yn\' id=\'notifiable_form_mand_yn\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\"/>   \n\t<input type=\'hidden\' name=\'notifiable_code\' id=\'notifiable_code\' value=\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\'></input>\n\t<input type=\'hidden\' name=\'email_yn\' id=\'email_yn\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'></input>\n\t<input type=\'hidden\' name=\'default_note_type\' id=\'default_note_type\' value=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'></input> \n    <input type=\'hidden\' name=\'specialty_code\' id=\'specialty_code\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\">\n\t<input type=\'hidden\' name=\'diagprob_short_desc\' id=\'diagprob_short_desc\' value=\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\'></input> \n     <!--END HAS-CRF-300 -->\t\n\n\t<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t<input type=\'hidden\' name=\'doctorsDescription\' id=\'doctorsDescription\' value=\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\'></input> \n\t<input type=\'hidden\' name=\'isMultiDescAppl\' id=\'isMultiDescAppl\' value=\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\'></input> <!--added by mujafar for ML-MMOH-CRF-1281 -->\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
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
 request.setCharacterEncoding("UTF-8");
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

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String loginUser		= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale = (String)session.getAttribute("LOCALE");
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
	

/* In Below lines variables ared added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
 String	enc_stage_yn	="N";
 String inpatient_appl_yn = "N";// Added by KAMATCHI S for ML-MMOH-CRF-1581 
 String daycare_appl_yn = "N";//Added by KAMATCHI S for ML-MMOH-CRF-1581
 String isInpatientDaycare="N";//Added by KAMATCHI S for ML-MMOH-CRF-1581
 String diagstagecode	="";
 String diastgSel_1		=""; 
 String diastgSel_2		="";
 String diastgSel_3		="";
 String  chife_compln_yn="N";
 String complaint_Desc	= ""; 
 String complaint_id	="";
 boolean firstTime  = true;
 String _complaint_Desc ="";
 String _complaint_id 	=""; 
 String  notify_yn	   ="N";
 String email_yn	   ="";
 String default_note_type="";
 String notifiable_code="";
 String email_sel_yn	 ="";
 String deflt_note_type="";
 String diag_enc_level="N";
 String notifiable_form_mand_yn="N"; 
String specialty_code="";
String notifiable_frm_mand_gif="";
 /*HSA-CRF-300 end*/
 String stage_no = "";
 String confirm_appl         = ""; // added by mujafar for ML-MMOH-CRF-0878
 String temp_code = "";
 String dflt_termset = "";
 String Pat_id = "";
 String gender = "";
 String age = "";
 String dob = "";
 String spec_code = "";
 String EncounterId = "";
 String Patient_Class = "";
 String diag_class_appl_yn = "";
 String accuracy_appl_yn = "";
 String severity_appl_yn = "";
 String priority_appl_yn = "";
 String onset_type_appl_yn = "";
 String onset_date_appl_yn = "";
 String applicable_side_appl_yn = "";
 String status_appl_yn = "";
 String as_on_date_appl_yn = "";
 String remarks_appl_yn = "";
 String tcode = "";
 String setcode = "";
 String sel_code = "";
 String sel_code1 = "";
 String dflt_values = "";
 String diag_class_code = "";
 String curr_accuracy_code = "";
 String curr_severity = "";
 String curr_priority = "";
 String curr_onset_type = "";
 String curr_onset_date = "";
 String status = "";
 String status_date = "";
 String applicable_side = "";
 String curr_remarks = "";
 String caused_death = "";
 String occur_srl_no = "";
 String recode_status = "";

 String sevr_L_select = "";
 String sevr_D_select = "";
 String sevr_S_select = "";
 String sevr_E_select = "";
 String type_A_select = "";
 String type_C_select = "";
 String type_N_select = "";
 String stus_A_select = "";
 String stus_R_select = "";
 String stus_X_select = "";
 String stus_E_select = "";
 String applicable_l = "";
 String applicable_r = "";
 String applicable_b = "";
 String applicable_n = "";
 String orig_termset = "";
 String orig_termcode = "";
 String l1_termCode = "";
 //String cnt_flag = "";
String currentdateTime = "";
String currentdate = "";
String currentTime = "";
String procedure_yn = "";
String newCode_yn = "";
String newCode_st = "";
String diag_code_st = "";
String chk_yn = "";
String sel_srl_no="";
String sel_status="";
String sel_satus_vals="";
String sel_stages_vals="";
String sel_term_code="";
String sel_grp_vals="";
String sel_term_set="";
String diagnosis_by_long_desc_yn="N";//Maheshwaran K added for HSA-CRF-0234

String action="";
String DB_Recode_Stages="";///For Insersion OF Recoding Record Greater level  
String DB_Recode_Status="";///For Insersion OF Recoding Record Greater level  
String DB_Recode_Grpvals="";///For Insersion OF Recoding Record Greater level  
String prin_diag="";
String mode="";
String modify_temp_code="";
String modify_diag_val="";
String modify_diag_long_desc="";
String modify_proc_long_desc="";
String modify_proc_val="";
String fields_dis="";
String short_desc						="";
//String modify_term_code="";
String modify_proc_code			="";
String rmrk_disabl						= "";
boolean show_code_xtn			=false;
String code_extn_dtl					="";
String laterality_ind					="";//Added On 12/12/2009 For SRR-CRF-303.1
String proc_srt_dt_time			="";//Added On 12/12/2009 For SRR-CRF-303.1
String proc_end_dt_time			="";//Added On 12/12/2009 For SRR-CRF-303.1
String sel_mod_id						="";
String sel_cont_mod_id				="";
String sel_cod_xtn					="";
//String sel_acess_num="";
String sel_cod_xtn_dtl				="";
String sel_laterality_ind				=""; //Added On 12/12/2009 for SRR-CRF-303.1
String sel_proc_srt_dt_time		=""; //Added On 12/14/2009 for SRR-CRF-303.1
String sel_proc_end_dt_time		=""; //Added On 12/14/2009 for SRR-CRF-303.1
String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");//Added On 7/13/2009
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");//Added On 7/13/2009
String allow_ot_proc_recode_yn			= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/13/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/13/2009
String p_proc_filter	= "";//Added On 7/13/2009
String hideExtn			= "";//Added On 7/13/2009
String disabled			= "";//Added On 7/13/2009
String OT_selcted		= "";//Added On 7/13/2009
//String Nonot_disabled	= "";//Added On 7/13/2009
String Nonot_selected		= "";//Added On 7/13/2009
String contr_mod_id			="";
String sel_mod_id_dmy		="";
int ot_count						=0;
int nonot_count				=0;
String Both						="N";
String proc_type_val		="";
String drg_calculation_yn	= "";
String free_text_yn			= "";
String mr_param_proc_type		=	"";
String exclude_orig_code			=	"";
String disp_in							=	"";
String code_xtn_appl_yn			=	"";
String laterality_appl_yn			=	"";
String proc_remarks_appl_yn	=	"";
String pat_visit_dt_time			=	""; // Added on 12/11/2009
String pat_disch_dt_time			=	""; // Added on 12/11/2009
String proc_status_appl_yn		=	""; //Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
String dagger_independent_yn	=	"";
String modify_term_set				=	"";
String long_desc						=	"";
String display_long_desc			=	"none";

//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
Boolean doctorsDescription = false; 
Boolean isEncounterStage = false;//Added by KAMATCHI S for ML-MMOH-CRF-1581
String tdesc = "";
String term_code_desc = "";
String sel_desc = "";
String sel_desc_trim = "";
String rec_doc_desc = "";
String doc_desc_visibile_yn = "";

String sel_mod_id_temp = "";
String sel_cod_xtn_temp = "";
String free_text_temp = "";
String term_sht_desc  = checkForNull(request.getParameter("term_sht_desc")); // added by mujafar for ML-MMOH-CRF-1281 
String isMultiDescAppl = "";
String includevisibility="visibility:hidden"; 

int i			= 0;
int srl_no  = 0;
int temp	= 0;

Connection conn=null;
try{

 specialty_code							= request.getParameter("specialty_code");// HSA-CRF-300
 stage_no							= request.getParameter("stage_no");
 confirm_appl         = checkForNull(request.getParameter("confirm_appl")); // added by mujafar for ML-MMOH-CRF-0878
 procedure_yn					= checkForNull(request.getParameter("procedure_yn"));
 temp_code						= checkForNull(request.getParameter("temp_code"));
 dflt_termset						= request.getParameter("dflt_termset");
 Pat_id								= request.getParameter("Pat_id");
 gender								= request.getParameter("gender");
 age									= request.getParameter("age");
 dob									= request.getParameter("dob");
 spec_code						= request.getParameter("spec_code");
 EncounterId						= request.getParameter("EncounterId");
 Patient_Class					= request.getParameter("Patient_Class");
 caused_death					= request.getParameter("caused_death");
 recode_status					= request.getParameter("recode_status");
 newCode_yn					= checkForNull(request.getParameter("newCode_yn"));
 l1_termCode					= request.getParameter("l1_termCode");
 chk_yn							= request.getParameter("chk_yn");
 DB_Recode_Stages			= request.getParameter("DB_Recode_Stages");///For Insersion OF Recoding Record Greater level 
 DB_Recode_Status			= request.getParameter("DB_Recode_Status");///For Insersion OF Recoding Record Greater level 
 DB_Recode_Grpvals		= request.getParameter("DB_Recode_Grpvals");///For Insersion OF Recoding Record Greater level 
 allow_recode_diag_yn		= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
 allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
 prin_diag							= checkForNull(request.getParameter("prin_diag"));
 mode								= checkForNull(request.getParameter("mode"));
 modify_temp_code			= checkForNull(request.getParameter("modify_temp_code"));
 modify_proc_code			= checkForNull(request.getParameter("modify_proc_code"));
 code_extn_dtl					= checkForNull(request.getParameter("code_extn_dtl"));
 laterality_ind					= checkForNull(request.getParameter("laterality_ind"));//Added For 12/12/2009 For SRR-CRF-303.1
// proc_srt_dt_time				= checkForNull(request.getParameter("proc_srt_dt_time"));//Added For 12/12/2009 For SRR-CRF-303.1
// proc_end_dt_time			= checkForNull(request.getParameter("proc_end_dt_time"));//Added For 12/12/2009 For SRR-CRF-303.1
 contr_mod_id					= checkForNull(request.getParameter("contr_mod_id"));
 /*F.Y.I:
	1.There will be a  Value for  pat_visit_dt_time only in case of Procedure (Newcode/Recode)
*/
 pat_visit_dt_time= checkForNull(request.getParameter("pat_visit_dt_time")); //Added On 12/11/2009 For SRR-CRF-303.1
 pat_disch_dt_time= checkForNull(request.getParameter("pat_disch_dt_time")); //Added On 12/11/2009 For SRR-CRF-303.1
 dagger_independent_yn= checkForNull(request.getParameter("dagger_independent_yn"),"N"); //Added On 12/11/2009 For SRR-CRF-303.2
 isMultiDescAppl = checkForNull(request.getParameter("isMultiDescAppl")); // added by mujafar for ML-MMOH-CRF-1281 
 
 if(chk_yn == null)
 chk_yn="N";
 conn = ConnectionManager.getConnection(request);	
 PreparedStatement pstmt		= null;
 ResultSet rs				= null;
 ResultSet rset				= null;
 //Statement stmt		= null;
 
 JSONObject DescriptionJsonObj		= new JSONObject(); // added by mujafar for ML-MMOH-CRF-1281 
 JSONArray DescriptionJsonArray = new JSONArray();
 JSONObject termCodeCountObj = new JSONObject();
  int descCount=0;


 doctorsDescription =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DOCTOR_DESC"); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269

 isEncounterStage =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","TERM_RECODE_DIAG"); //Added by KAMATCHI  S for ML-MMOH-CRF-1581

if(newCode_yn.equals("Y")){
	newCode_st="disabled";
	action="New";
}else if(mode.equals("Modify")){
	temp_code	=	modify_temp_code;
	action="DiagModify";
}else if(mode.equals("ProcModify")){
	temp_code	=	modify_proc_code;
	rmrk_disabl="disabled";
	show_code_xtn=true;
	action="ProcModify";
}else{
	newCode_st="";
	action="Recode";
}
if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
	p_proc_filter ="B";
//	hideExtn="hidden";
	disabled="";
//	Nonot_disabled="";
	OT_selcted="";
	Nonot_selected="";
}else if(allow_ot_proc_recode_yn.equals("Y")){
	p_proc_filter	="O";
//	hideExtn="visible";
	disabled	="disabled";
	OT_selcted	="selected";
//	Nonot_disabled	="disabled";

}else if(allow_non_ot_proc_recode_yn.equals("Y")){
	p_proc_filter	="N";
//	hideExtn="hidden";
//	OT_disabled	="";
	OT_selcted	="";
	disabled	="disabled";
	Nonot_selected	="selected";
}

try{
	//String sql2="SELECT DIAG_CLASS_APPL_YN,ACCURACY_APPL_YN,SEVERITY_APPL_YN,PRIORITY_APPL_YN,ONSET_TYPE_APPL_YN,ONSET_DATE_APPL_YN,APPLICABLE_SIDE_APPL_YN,STATUS_APPL_YN,AS_ON_DATE_APPL_YN ,REMARKS_APPL_YN,LATERALITY_APPL_YN,CODE_EXTENSION_APPL_YN,PROC_REMARKS_APPL_YN,PROC_STATUS_APPL_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO="+stage_no+" AND ADDED_FACILITY_ID='"+p_facility_id+"'";
	/* In Below lines querie modified by venkatesh.s against HAS-CRF-300*/
	/* Below query is modified for ML-MMOH-CRF-1581 by KAMATCHI S */
	String sql2="SELECT DIAG_CLASS_APPL_YN,ACCURACY_APPL_YN,SEVERITY_APPL_YN,PRIORITY_APPL_YN,ONSET_TYPE_APPL_YN,ONSET_DATE_APPL_YN,APPLICABLE_SIDE_APPL_YN,STATUS_APPL_YN,AS_ON_DATE_APPL_YN ,REMARKS_APPL_YN,LATERALITY_APPL_YN,CODE_EXTENSION_APPL_YN,PROC_REMARKS_APPL_YN,PROC_STATUS_APPL_YN,ENC_STAGE_YN,CHIFE_COMP_YN,NOTIFIY_YN,INPATIENT_APPL_YN,DAYCARE_APPL_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO="+stage_no+" ";
	pstmt = conn.prepareStatement(sql2);
	rs = pstmt.executeQuery();	

	while(rs.next()) {
		  diag_class_appl_yn		= rs.getString("DIAG_CLASS_APPL_YN");
		  accuracy_appl_yn		= rs.getString("ACCURACY_APPL_YN");
		  severity_appl_yn		= rs.getString("SEVERITY_APPL_YN");
		  priority_appl_yn			= rs.getString("PRIORITY_APPL_YN");
  		  onset_date_appl_yn	= rs.getString("ONSET_DATE_APPL_YN");
  		  as_on_date_appl_yn	= rs.getString("AS_ON_DATE_APPL_YN");
		  onset_type_appl_yn	= rs.getString("ONSET_TYPE_APPL_YN");
		  applicable_side_appl_yn		= rs.getString("APPLICABLE_SIDE_APPL_YN");
		  status_appl_yn			= rs.getString("STATUS_APPL_YN");
		  remarks_appl_yn		= rs.getString("REMARKS_APPL_YN");
		  laterality_appl_yn		= rs.getString("LATERALITY_APPL_YN");
		  code_xtn_appl_yn		= rs.getString("CODE_EXTENSION_APPL_YN");
		  proc_remarks_appl_yn	= rs.getString("PROC_REMARKS_APPL_YN");
		  proc_status_appl_yn		= rs.getString("PROC_STATUS_APPL_YN"); //Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
		  enc_stage_yn		    = rs.getString("ENC_STAGE_YN");/*HSA-CRF-300*/
		  chife_compln_yn		= rs.getString("CHIFE_COMP_YN"); /*HSA-CRF-300*/
		  notify_yn		        = rs.getString("NOTIFIY_YN");/*HSA-CRF-300*/
		  inpatient_appl_yn		= rs.getString("INPATIENT_APPL_YN");//Added by KAMATCHI S for ML-MMOH-CRF-1581
		  daycare_appl_yn       = rs.getString("DAYCARE_APPL_YN");//Added by KAMATCHI S for ML-MMOH-CRF-1581
	}

		//Condition Added by KAMATCHI S for ML-MMOH-CRF-1581
		if(isEncounterStage && enc_stage_yn.equals("Y") && ((inpatient_appl_yn.equals("Y") && Patient_Class.equals("IP")) ||  (daycare_appl_yn.equals("Y") && Patient_Class.equals("DC")) ))
		{
			isInpatientDaycare="Y";
		}
	
	String sno = "";
	String testno = "";
	//out.println("<script>alert(\"chk_yn :"+chk_yn+"\");</script>");
/*if(mode.equals("Modify")){
	temp_code	=	modify_temp_code;
}else if(mode.equals("ProcModify")){
	temp_code	=	modify_proc_code;
	rmrk_disabl="disabled";
	show_code_xtn=true; 
}*/
//Maheshwaran K added diagnosis_by_long_desc_yn in the query for HSA-CRF-0234

/* In Below query NOTIFIABLE_FORM_MAND_YN and DIAG_ENC_LEVEL  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300 */
String sql_param="SELECT diagnosis_by_long_desc_yn,DRG_CALCULATION_YN,DF_NEW_PROC_TYPE_FR_RECODE,EXCLUDE_ORIG_CODE,NOTIFIABLE_FORM_MAND_YN,DIAG_ENC_LEVEL,(select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual) sdate FROM MR_PARAMETER"; 
    
	pstmt = conn.prepareStatement(sql_param);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		drg_calculation_yn		= checkForNull(rs.getString("DRG_CALCULATION_YN"));
		mr_param_proc_type	= checkForNull(rs.getString("DF_NEW_PROC_TYPE_FR_RECODE"));
		exclude_orig_code		= checkForNull(rs.getString("EXCLUDE_ORIG_CODE"),"N");
		diagnosis_by_long_desc_yn		= checkForNull(rs.getString("diagnosis_by_long_desc_yn"),"N");

		currentdateTime	= rs.getString("sdate");
		currentdate		= currentdateTime.substring(0,10);
		currentdate		=DateUtils.convertDate(currentdate,"DMY" ,"en",locale);
		currentTime		= currentdateTime.substring(11);
		
		notifiable_form_mand_yn			=checkForNull(rs.getString("NOTIFIABLE_FORM_MAND_YN")); //HAS-CRF-300
		diag_enc_level					=checkForNull(rs.getString("DIAG_ENC_LEVEL"));//HAS-CRF-300
	
		
	}

	if(newCode_yn.equals(""))
	{
	
		if(!chk_yn.equals("")){
			StringTokenizer st=new StringTokenizer(chk_yn,",");
			int test=st.countTokens();
			String t1="";

			for(int r2=0;r2<test;r2++){
				t1=st.nextToken();
				//out.println("<script>alert(\"t1 :"+t1+"\");</script>");

				 StringTokenizer st8=new StringTokenizer(temp_code,"~");
				 temp=st8.countTokens();

				for(int u2=0;u2<temp;u2++){
					String st2=st8.nextToken();
					StringTokenizer st1=new StringTokenizer(st2,"$");

					testno=st1.nextToken().trim();
						//out.println("<script>alert(\"testno :"+testno+"\");</script>");

					tcode=st1.nextToken().trim();

					sel_term_code=tcode+","+sel_term_code;

					setcode=st1.nextToken().trim();
					sel_term_set=setcode+","+sel_term_set;
					sel_status=st1.nextToken().trim();
					sel_srl_no=st1.nextToken().trim()+","+sel_srl_no;
					sel_satus_vals=st1.nextToken()+","+sel_satus_vals;
					sel_stages_vals=st1.nextToken()+","+sel_stages_vals;
					sel_grp_vals=st1.nextToken().trim()+","+sel_grp_vals;
					sel_mod_id_temp=st1.nextToken().trim()+","+sel_mod_id_temp;
					sel_cod_xtn_temp=st1.nextToken().trim()+","+sel_cod_xtn_temp;
					free_text_temp=st1.nextToken().trim()+","+free_text_temp;

					/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
					tdesc=st1.nextToken().trim();
					tdesc=java.net.URLDecoder.decode(tdesc);
					term_code_desc=tdesc+","+term_code_desc;
					/*End ML-MMOH-CRF-1269*/

					if(!t1.equals(testno))	{
						//out.println("<script>alert(\"here :"+testno+"\");</script>");
						if(procedure_yn.equals("Y")){
							sno = st1.nextToken().trim();
							st1.nextToken().trim();
							sel_cont_mod_id	=st1.nextToken().trim();
							sel_mod_id=sel_cont_mod_id+","+sel_mod_id;
							//Changed by Kamatchi S
							sel_cod_xtn=tdesc+","+sel_cod_xtn;
							st1.nextToken().trim();
//							sel_acess_num=st1.nextToken().trim()+","+sel_acess_num;
							sel_cod_xtn_dtl	= st1.nextToken().trim();
							sel_laterality_ind	= st1.nextToken().trim();
							sel_proc_srt_dt_time	= st1.nextToken().trim();
							sel_proc_end_dt_time	= st1.nextToken().trim();
						}

				
						if(procedure_yn.equals("Y")){
							if(u2 == 0)	{
								sel_code = tcode.trim()+","+setcode+","+sno;
								sel_code1 = tcode.trim();
								dflt_values="Y";
							}else{
								sel_code = sel_code+","+tcode.trim()+","+setcode+","+sno;
								sel_code1 = sel_code1+","+tcode.trim();
								dflt_values="N";
							}


						}else{

							if(u2 == 0){
								sel_code = tcode.trim()+","+setcode;
								sel_code1 = tcode.trim();
								sel_desc = tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
								dflt_values="Y";
							}else{
								sel_code = sel_code+","+tcode.trim()+","+setcode;
								sel_code1 = sel_code1+","+tcode.trim();
								sel_desc = sel_desc+","+tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
								dflt_values="N";
							}
						}
					}
				}

			}
		}else{

			StringTokenizer st8=new StringTokenizer(temp_code,"~");
			 temp=st8.countTokens();


			for(int u2=0;u2<temp;u2++){
				String st2=st8.nextToken();
				StringTokenizer st1=new StringTokenizer(st2,"$");

				testno=st1.nextToken().trim();

				tcode=st1.nextToken().trim();

				setcode=st1.nextToken().trim();
				
				sel_term_code=tcode+","+sel_term_code;
				sel_term_set=setcode+","+sel_term_set;

					sel_status=st1.nextToken().trim();
					sel_srl_no=st1.nextToken().trim()+","+sel_srl_no;
					sel_satus_vals=st1.nextToken()+","+sel_satus_vals;
					sel_stages_vals=st1.nextToken()+","+sel_stages_vals;
					sel_grp_vals=st1.nextToken().trim()+","+sel_grp_vals;
					sel_mod_id_temp=st1.nextToken().trim()+","+sel_mod_id_temp;
					sel_cod_xtn_temp=st1.nextToken().trim()+","+sel_cod_xtn_temp;
					free_text_temp=st1.nextToken().trim()+","+free_text_temp;

					/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
					tdesc=st1.nextToken().trim();
					tdesc=java.net.URLDecoder.decode(tdesc);
					term_code_desc=tdesc+","+term_code_desc;
					/*End ML-MMOH-CRF-1269*/

				//if(!t1.equals(testno))
				//{
				if(procedure_yn.equals("Y")){
					sno = st1.nextToken().trim();
					st1.nextToken().trim();
					sel_cont_mod_id	=st1.nextToken().trim();
					sel_mod_id=sel_cont_mod_id+","+sel_mod_id;
					//Changed by Kamatchi S
					sel_cod_xtn=tdesc+","+sel_cod_xtn;
					st1.nextToken().trim();
//					sel_acess_num=st1.nextToken().trim()+","+sel_acess_num;
					sel_cod_xtn_dtl=st1.nextToken().trim();
					sel_laterality_ind=st1.nextToken().trim();//Added On 12/12/2009 For SRR-CRF-303.1
					sel_proc_srt_dt_time	= st1.nextToken().trim();//Added On 12/14/2009 For SRR-CRF-303.1
					sel_proc_end_dt_time	= st1.nextToken().trim();//Added On 12/14/2009 For SRR-CRF-303.1

					sel_mod_id_dmy=sel_mod_id;

				}
				if(procedure_yn.equals("Y")){
					if(u2 == 0)	{
						sel_code = tcode.trim()+","+setcode+","+sno;
						sel_code1 = tcode.trim();
						dflt_values="Y";
					}else{
						sel_code = sel_code+","+tcode.trim()+","+setcode+","+sno;
						sel_code1 = sel_code1+","+tcode.trim();
						dflt_values="N";
					}


				}else{

					if(u2 == 0){
						sel_code = tcode.trim()+","+setcode;
						sel_code1 = tcode.trim();
						sel_desc = tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
						dflt_values="Y";
					}else{
						sel_code = sel_code+","+tcode.trim()+","+setcode;
						sel_code1 = sel_code1+","+tcode.trim();
						sel_desc = sel_desc+","+tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
						dflt_values="N";
					}
				}
			}
		}	

		if(temp > 1)
			newCode_st="disabled";
		else
			newCode_st="";

	if(sel_code.equals(""))
	{
		
            _bw.write(_wl_block7Bytes, _wl_block7);
}
}
		/*if(!procedure_yn.equals("Y")){
			stmt = conn.createStatement();
			String DEATH_DATE_SQL = "SELECT TO_CHAR(DECEASED_DATE_TIME,'DD/MM/YYYY HH24:MI')DECEASED_DATE_TIME FROM PR_ENCOUNTER WHERE ENCOUNTER_ID='"+EncounterId+"' AND FACILITY_ID='"+p_facility_id+"' " ;
			rset	  = stmt.executeQuery(DEATH_DATE_SQL);
			if (rset.next()){
				deceased_date_time	= checkForNull(rset.getString("DECEASED_DATE_TIME"));
			}
		}
		if ( rset != null ) rset.close();*/

		/*stmt = conn.createStatement();
		String getDate = "select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual" ;
		rset	  = stmt.executeQuery(getDate);
		if (rset.next())
		{
			currentdateTime	= rset.getString("sdate");
			currentdate		= currentdateTime.substring(0,10);
			currentdate		=DateUtils.convertDate(currentdate,"DMY" ,"en",locale);
			currentTime		= currentdateTime.substring(11);
		}
		if ( rset != null ) rset.close();
		*/
		if(!newCode_yn.equals("Y")){
			StringTokenizer sel_mod_id_dmy_st= new StringTokenizer(sel_mod_id_dmy,",");
			while(sel_mod_id_dmy_st.hasMoreTokens()){
				if(sel_mod_id_dmy_st.nextToken().equals("OT")){
					ot_count++;
					proc_type_val="OT";
				}else{
					nonot_count++;
//					proc_type_val="";
					Both	 ="Y";
				}
			}

			StringTokenizer sel_cd_st= new StringTokenizer(sel_term_code,",");
			StringTokenizer sel_termset_st= new StringTokenizer(sel_term_set,",");
			StringTokenizer sel_srlno_st= new StringTokenizer(sel_srl_no,",");



			String def_srl_no=sel_srlno_st.nextToken();
			String def_cd=sel_cd_st.nextToken();
			String def_set=sel_termset_st.nextToken();
			modify_term_set=def_set;
//			String pat_visit_dt_time			= "";
//			String pat_discharge_dt_time	= "";
//			String def_set_mod_id=sel_mod_id_dmy_st.nextToken();
			if(procedure_yn.equals("Y")){

				/*String VISIT_DISCHARGE_SQL="SELECT TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI')VISIT_ADM_DATE_TIME,TO_CHAR(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI')DISCHARGE_DATE_TIME FROM PR_ENCOUNTER WHERE  FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"' AND PATIENT_ID='"+Pat_id+"' ";
				pstmt = conn.prepareStatement(VISIT_DISCHARGE_SQL);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					pat_visit_dt_time= checkForNull(rs.getString("VISIT_ADM_DATE_TIME"));
					pat_discharge_dt_time= checkForNull(rs.getString("DISCHARGE_DATE_TIME"));
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();*/

				String sql3_for_proc="SELECT A.remarks,B.SHORT_DESC,B.LONG_DESC FROM MR_PROCEDURE_RECODING_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID='"+p_facility_id+"' and A.encounter_id='"+EncounterId+"' and  A.proc_code='"+def_cd+"' and A.PROC_CODE_SCHEME ='"+def_set+"' and A.STAGE_SRL_NO='"+def_srl_no+"' AND A.PROC_CODE=B.TERM_CODE AND  A.PROC_CODE_SCHEME=B.TERM_SET_ID";
				pstmt = conn.prepareStatement(sql3_for_proc);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					  curr_remarks	= checkForNull(rs.getString("remarks"));
					  short_desc		= checkForNull(rs.getString("SHORT_DESC"));
					  long_desc		= checkForNull(rs.getString("LONG_DESC"));
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();

				 if(mode.equals("ProcModify")){
					fields_dis="disabled";
					modify_proc_val=def_cd;
					modify_proc_long_desc=long_desc;
				}else{
					short_desc="";
					fields_dis="";
					modify_proc_val="";
					modify_proc_long_desc="";
			}
		}else{  
		           /* In Below lines query  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
				String sql3_for_diag="SELECT A.DIAG_CLASS_CODE,A.ACCURACY_CODE,A.SEVERITY,A.PRIORITY,A.ONSET_TYPE,to_char(A.ONSET_DATE,'dd/mm/yyyy HH24:mi') ONSET_DATE ,A.APPLICABLE_SIDE,A.STATUS,to_char(A.AS_ON_DATE,'dd/mm/yyyy') AS_ON_DATE,A.REMARKS,B.SHORT_DESC,B.LONG_DESC,B.FREE_TEXT_YN,A.TERM_CODE_SHORT_DESC,A.OCCUR_SRL_NO, A.ENC_STAGE ,A.NOTIFICATION_CODE,A.DOCTORS_DESCRIPTION FROM MR_DIAGNOSIS_RECODING_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID='"+p_facility_id+"' and A.encounter_id='"+EncounterId+"' and  A.term_code='"+def_cd+"' and  A.term_set_id='"+def_set+"' and A.STAGE_SRL_NO='"+def_srl_no+"' AND A.TERM_CODE=B.TERM_CODE AND A.TERM_SET_ID=B.TERM_SET_ID ";
				/*DOCTORS_DESCRIPTION Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
				
			   //out.println("<script>alert(\"sql3.))...:"+sql3+"\");</script>");
                    
					
				pstmt = conn.prepareStatement(sql3_for_diag);
				rs = pstmt.executeQuery();	
				

				while(rs.next()){
					  //orig_termset = checkForNull(rs.getString("PROC_CODE_SCHEME"));
					 // orig_termcode = checkForNull(rs.getString("PROC_CODE"));
					  diag_class_code			= checkForNull(rs.getString("diag_class_code"));
					  curr_accuracy_code		= checkForNull(rs.getString("accuracy_code"));
					  curr_severity				= checkForNull(rs.getString("severity"));
					  curr_priority				= checkForNull(rs.getString("priority"));
					  curr_onset_type			= checkForNull(rs.getString("onset_type"));
					  curr_onset_date			= checkForNull(rs.getString("onset_date"));
						curr_onset_date			=DateUtils.convertDate(curr_onset_date,"DMYHM","en",locale); 
					  applicable_side			= checkForNull(rs.getString("applicable_side"));
					  status					= checkForNull(rs.getString("status"));
					  status_date				= checkForNull(rs.getString("AS_ON_DATE"));
					  status_date				=	DateUtils.convertDate(status_date,"DMY","en",locale); 
					  curr_remarks				= checkForNull(rs.getString("remarks"));
					  free_text_yn				= checkForNull(rs.getString("FREE_TEXT_YN"));
					  if(free_text_yn.equals("Y")){
						  short_desc			= checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
					  }else{
						  short_desc			= checkForNull(rs.getString("SHORT_DESC"));
					  }
					  
				
				term_sht_desc		= checkForNull(rs.getString("TERM_CODE_SHORT_DESC")); //  added by mujafar for ML-MMOH-CRF-1281
			 
					  occur_srl_no				= checkForNull(rs.getString("OCCUR_SRL_NO"));
					  long_desc					= checkForNull(rs.getString("LONG_DESC"));
				           diagstagecode		= checkForNull(rs.getString("ENC_STAGE"));//HAS-CRF-300
					   notifiable_code			= checkForNull(rs.getString("NOTIFICATION_CODE"));//HAS-CRF-300

					   rec_doc_desc				= checkForNull(rs.getString("DOCTORS_DESCRIPTION"));//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
				      
				}
				
			/*For Modifing The Diag.Classification Code Disabling the Fields And Painting the Desc  as Follows */
			if(mode.equals("Modify")){
				fields_dis="disabled";
				modify_diag_val=def_cd;
//				modify_diag_long_desc=long_desc;
				modify_diag_long_desc=def_cd+","+def_set;
			}else{
				short_desc="";
				fields_dis="";
				modify_diag_val="";
				modify_diag_long_desc="";
			}
	
if(isMultiDescAppl.equals("true") && mode.equals("Modify") && procedure_yn.equals("N") ) //  added by mujafar for ML-MMOH-CRF-1281
 {
 
		
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(conn,def_set,tcode);
		DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		

		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) descCount = 1;
		}
	
	if(descCount==1)
		includevisibility="visibility:visible";
}
			
		}
		
	}
} catch(Exception e)
{
	//out.println("here"+e.toString());
	e.printStackTrace();
}
		if(curr_severity.equals("L"))
			sevr_L_select = "selected";
		else if(curr_severity.equals("D"))
			sevr_D_select = "selected";
		else if(curr_severity.equals("S"))
			sevr_S_select = "selected";
		else if(curr_severity.equals("E"))
			sevr_E_select = "selected";


		if(curr_onset_type.equals("A"))
			type_A_select = "selected";
		else if(curr_onset_type.equals("C"))
			type_C_select = "selected";
		else 
			type_N_select = "selected";


		if(status.equals("A"))
			stus_A_select = "selected";
		else if(status.equals("R"))
			stus_R_select = "selected";
		else if(status.equals("X"))
			stus_X_select = "selected";
		else if(status.equals("E"))
			stus_E_select = "selected";

		if(applicable_side.equals("L"))
			applicable_l = "selected";
		else if(applicable_side.equals("R"))
			applicable_r = "selected";
		else if(applicable_side.equals("B"))
			applicable_b = "selected";
		else if(applicable_side.equals("N"))
			applicable_n = "selected";

			if(occur_srl_no.equals(""))
				occur_srl_no="1";
				
				

/*F.Y.I:For SRR-CRF-303.1,Procedure Type ,Code extention and Laterality was introduced.*/
	/*----For New Procedure---*/
	String disp_mand			 =	"";
	String disp_recode		 =	"";
	String ot_selected			 =	"";
	String not_selected		 =	"";
	String opt_selected		 =	"";
	String open_dt_times	 =	"style='visibility:hidden;display:none'";
	String lbl_in_time			 =	"";
	String lbl_out_time		 =	"";
	String open_chk_mand	 =	"hidden";
	String proc_type_hid_yn =	"N";
if(newCode_yn.equals("Y")){
	if(mr_param_proc_type.equals("NA")){
			proc_type_hid_yn		= "Y";
			hideExtn		 ="";
			opt_selected ="selected";
			disp_mand	 ="visible";
			open_dt_times	 =	"style='visibility:hidden;display:none'";
	}else{
			proc_type_hid_yn = "N";
			hideExtn		="disabled";
			disp_mand	="hidden";
		if(mr_param_proc_type.equals("OT")){
			ot_selected		="selected";
			proc_type_val	="OT";
			open_dt_times ="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
			open_chk_mand	= "visible";

		}else if(mr_param_proc_type.equals("NO")){
			not_selected		 ="selected";
			open_dt_times  ="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");

		}
	}
}else{
		if(ot_count>1){
			code_extn_dtl			="";
			laterality_ind	 			="";
			proc_srt_dt_time	 	= "";
			proc_end_dt_time	= "";
			ot_selected		="selected";
			open_dt_times	="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
			open_chk_mand	= "visible";
		}else if(nonot_count>1){
			code_extn_dtl			="";
			laterality_ind	 			="";
			proc_srt_dt_time	 	= "";
			proc_end_dt_time	= "";
			not_selected		 ="selected";
			open_dt_times  ="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");
		}else{
				if(ot_count==1){
					ot_selected	    ="selected";
					open_dt_times ="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
					open_chk_mand	= "visible";
				}else if(nonot_count==1){
					not_selected		="selected";
					open_dt_times	="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");
				}
				if(sel_cont_mod_id.equals("XT")){
					contr_mod_id	="";
				}else{
					contr_mod_id=sel_cont_mod_id;
				}
				if(sel_cod_xtn_dtl.equals("01")){
					code_extn_dtl	="";
				}else{
					code_extn_dtl=sel_cod_xtn_dtl;
				}
				if(sel_laterality_ind.equals("01")){
					laterality_ind	="";
				}else{
					laterality_ind=sel_laterality_ind;
				}
				if(sel_proc_srt_dt_time.equals("01")){
					proc_srt_dt_time	="";
				}else{
					proc_srt_dt_time=sel_proc_srt_dt_time;
				}
				if(sel_proc_end_dt_time.equals("01")){
					proc_end_dt_time	="";
				}else{
					proc_end_dt_time=sel_proc_end_dt_time;
				}

				if(sel_cont_mod_id.equals("OT")){
					ot_selected		="selected";
					open_dt_times	="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
					open_chk_mand	= "visible";
				}else{
					not_selected		 ="selected";
					open_dt_times  ="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");
					disp_mand		 = "visible";
				}
		}
		if(Both.equals("Y")){
			hideExtn	="disabled";
		if(ot_count>0 && nonot_count>0){
			proc_type_hid_yn  ="Y";
			disp_in="Y";
			disp_mand		 ="visible";
			open_dt_times	 =	"style='visibility:hidden;display:none'";
			opt_selected		  ="selected";
			ot_selected		  ="";
			not_selected		  ="";
			hideExtn			  ="";
			code_extn_dtl	  ="";
			laterality_ind		  ="";
			proc_srt_dt_time	 =	"";
			proc_end_dt_time =	"";

		}else{
			disp_in			="N";
			disp_recode	="N";
			hideExtn		="disabled";
		}
		}else{
			hideExtn		 = "disabled";
			disp_mand	 ="hidden";
		}
}
/****/
String build_diag_class_type="";
/*F.Y.I:For SRR-CRF-303.2[15597],Review Status.*/
		if(proc_status_appl_yn.equals("A")){
			stus_A_select = "selected";
		}else if(status.equals("X")){
			stus_X_select = "selected";
		}

/*F.Y.I:For SRR-CRF-303.2[15597],Review Status.*/
String exculde_list_item	="NO";
String dis_status		 ="disabled";
if(action.equals("DiagModify")||action.equals("ProcModify") ){
		if(sel_status.equals("Review") && exclude_orig_code.equals("Y")){
			dis_status ="";
			exculde_list_item	="YES";
		}
/*F.Y.I:
	1.Added Long Desc when there is no difference between short_desc and long_desc then long_desc link wouldn't display.
	2.Added On 3/11/2010.
	3.Site Enhancement.
*/
	if(!(short_desc.equals(long_desc))&&!(modify_diag_val.equals("*OTH"))){
		display_long_desc ="inline";
	}

	} 
	

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(!newCode_yn.equals("Y")){
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sel_code1));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
		else{
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

		if(procedure_yn.equals("Y")){
				String QUERY_FOR_DLFT_TMSET ="";
				if(action.equals("ProcModify")){
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE TERM_SET_ID='"+modify_term_set+"'";
				}else{
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE PROC_SPEC_YN='Y' and RECODERS_APPL_YN='Y'" ;
				}
				
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

				pstmt = conn.prepareStatement(QUERY_FOR_DLFT_TMSET);
				rset = pstmt.executeQuery();
				
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

				while(rset.next()){	
					dflt_termset=rset.getString("TERM_SET_ID");
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rset.getString("TERM_SET_ID")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rset.getString("TERM_SET_DESC")));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
				}else{
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

				String QUERY_FOR_DLFT_TMSET ="";
				if(action.equals("DiagModify")){
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE TERM_SET_ID='"+modify_term_set+"'";
				}else{
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE DIAG_SPEC_YN='Y' AND RECODERS_APPL_YN='Y'" ;
				}
				
				pstmt = conn.prepareStatement(QUERY_FOR_DLFT_TMSET);
				rset = pstmt.executeQuery();
				while(rset.next()){
				dflt_termset=rset.getString("TERM_SET_ID");
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rset.getString("TERM_SET_ID")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rset.getString("TERM_SET_DESC")));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
			}
			if(!dflt_termset.equals("")){
				diag_code_st="";
				//			fields_dis="";
			}else{
				diag_code_st="disabled";
				//			fields_dis="disabled";
			}
		
            _bw.write(_wl_block26Bytes, _wl_block26);

			if(procedure_yn.equals("Y")){
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modify_proc_val));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(diag_code_st));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modify_proc_long_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(newCode_st));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(diag_code_st));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(modify_proc_long_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(modify_proc_val));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(hideExtn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(opt_selected));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ot_selected));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(not_selected));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modify_proc_long_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modify_proc_long_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);

						 if(code_xtn_appl_yn.equals("Y")){
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block56Bytes, _wl_block56);
} if(laterality_appl_yn.equals("Y")){
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
}else{
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(laterality_ind));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(laterality_appl_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(laterality_ind));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(open_dt_times));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(lbl_in_time));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(proc_srt_dt_time));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(open_chk_mand));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(lbl_out_time));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(proc_end_dt_time));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(open_chk_mand));
            _bw.write(_wl_block75Bytes, _wl_block75);
if(proc_status_appl_yn.equals("Y")){
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(dis_status));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(	stus_A_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(exculde_list_item.equals("YES")){
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(stus_X_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block80Bytes, _wl_block80);

			}else{
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(status));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
			if(proc_remarks_appl_yn.equals("Y")){
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(curr_remarks));
            _bw.write(_wl_block85Bytes, _wl_block85);
}else{
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(curr_remarks));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
// End Of Else;
	}else{
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(modify_diag_val));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(diag_code_st));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modify_diag_long_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(diag_code_st));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(newCode_st));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(diag_code_st));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(modify_diag_val));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(modify_diag_long_desc));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(includevisibility));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(includevisibility));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(includevisibility));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
if(descCount==1){
			
			JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);
							String chk_val = "";
							String descriptions="";
							for(int ii=1;ii<=10;ii++)
							{   chk_val = "";
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+ii));
								if(!descriptions.equals(""))
								{
								if(term_sht_desc.equals(descriptions))chk_val = "selected";
									
			
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chk_val));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block108Bytes, _wl_block108);
	}
							}
		}
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modify_diag_long_desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(diag_code_st));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modify_diag_long_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(diag_code_st));
            _bw.write(_wl_block114Bytes, _wl_block114);
if(doctorsDescription && !newCode_yn.equals("Y")){
			if(mode.equals("Modify"))
			{
				sel_desc_trim = rec_doc_desc;
				if(!("").equals(sel_desc_trim))
				{
					doc_desc_visibile_yn = "visible";
				}else
				{
					doc_desc_visibile_yn = "hidden";
				}
			}else
			{
			if(sel_desc.length() <= 100)
			{
				sel_desc_trim = sel_desc;
			}else
			{
				sel_desc_trim = sel_desc.substring(0, 100);
				}
			}
		
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(sel_desc_trim));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(doc_desc_visibile_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
}
            _bw.write(_wl_block119Bytes, _wl_block119);
 if((enc_stage_yn.equals("Y") && Patient_Class.equals("IP") && !isEncounterStage)  || isInpatientDaycare.equals("Y")  ){
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
String enc_stg_sql	="SELECT list_value FROM mr_term_set_crit_for_pc WHERE  patient_class='"+Patient_Class+"' AND criteria IN ('ENCOUNTER_STAGE')";
		ArrayList enc_stg_list=new ArrayList(); 
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		pstmt = conn.prepareStatement(enc_stg_sql);
		rset = pstmt.executeQuery();
		while(rset.next()){
		enc_stg_list.add(checkForNull(rset.getString("list_value")));
		}		
		if(!(diagstagecode==null || diagstagecode.equals("")))
			{
			if(diagstagecode.equals("A"))
			diastgSel_1="selected";
			else if(diagstagecode.equals("I"))
			diastgSel_2="selected";
			else if(diagstagecode.equals("D"))
			diastgSel_3="selected";
			}		
		for(int ij=0;ij<enc_stg_list.size();ij++)
			{
			String list_value="";	
			String list_value1="";
			list_value=checkForNull((String) enc_stg_list.get(ij)); 			
		if(list_value.equals("ADMISSION"))
			{ 
			list_value="A";
			list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
			out.print("<option value='"+list_value+"' "+diastgSel_1+"  />"+list_value1 );
			}
		if(list_value.equals("INTERMEDIATE"))
			{
			list_value="I";
			list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
			out.print("<option value='"+list_value+"' "+diastgSel_2+"   />"+list_value1 );
			}
		if(list_value.equals("DISCHARGE"))
			{
			list_value="D";
			list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
			out.print("<option value='"+list_value+"' "+diastgSel_3+"  />"+list_value1 );
			}
			}
		 if(rset!=null) rset.close();
		
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);

		 if(chife_compln_yn.equals("Y")){		 
		  StringBuffer sql = new StringBuffer(); 
	sql.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text, to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and a.occur_srl_no='"+occur_srl_no+"'");
			if(!modify_diag_val.equals("*OTH"))
				sql.append("and a.term_code = ? "); 
			else
				sql.append("and a.term_code_short_desc = ? "); 
			sql.append("order by a.onset_date desc");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,p_facility_id);
			pstmt.setString(3,EncounterId);
			pstmt.setString(4,dflt_termset);
			if(!modify_diag_val.equals("*OTH"))
				pstmt.setString(5,modify_diag_val); 
			else
				pstmt.setString(5,short_desc);				
				rset = pstmt.executeQuery();
			while(rset.next())
				{ 
				complaint_Desc		= rset.getString("complaint_text")==null?"":rset.getString("complaint_text");
				complaint_id		= rset.getString("complaint_id")==null?"":rset.getString("complaint_id");
				if(firstTime)
				{
					_complaint_Desc = _complaint_Desc + "" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "" +complaint_id +"";
				}
				else
				{
					_complaint_Desc = _complaint_Desc + ";" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "$" +complaint_id +"";
				}
				firstTime = false;
			}
			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();  
		  
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(_complaint_Desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(_complaint_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
 if(!mode.equals("Modify")){ 
            _bw.write(_wl_block129Bytes, _wl_block129);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
}else{
            _bw.write(_wl_block131Bytes, _wl_block131);
 }if(notify_yn.equals("Y")){
		  //added by Sangeetha for ML-MMOH-CRF-0547
		  Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","TYPES_OF_NOTIFICATION_FORM"); 
		  if(legendChangeAsTypesOfNotiForm){
		  
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
 }
		  else{
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
 } 
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
 try 
				{ 
				String notify_sql="SELECT NOTIFICATION_CODE,SHORT_DESC,EMAIL_APPLICABLE,DEFAULT_NOTE_TYPE FROM MR_NOTIFICATION_SETUP WHERE EFF_STATUS='E'"; //senthil modified				
				pstmt = conn.prepareStatement(notify_sql);
				rset=pstmt.executeQuery();
				while(rset.next()) 
					{
					String notify_code=rset.getString("NOTIFICATION_CODE");
					String notify_desc=rset.getString("SHORT_DESC");
					email_yn=rset.getString("EMAIL_APPLICABLE");
					default_note_type=rset.getString("DEFAULT_NOTE_TYPE")==null?"":rset.getString("DEFAULT_NOTE_TYPE");		
              	if(notifiable_code.equals(notify_code))
						{
						email_sel_yn=email_yn;
						deflt_note_type=default_note_type; //Added Senthil
						out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"' selected>"+notify_desc+"</option>");
						}
					else{	
					out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"'>"+notify_desc+"</option>");	
					}
					}
				if(pstmt!=null) pstmt.close();
				if(rset	!= null)   rset.close();
				}
			catch(Exception e)
				{
				e.printStackTrace();
				}
            _bw.write(_wl_block138Bytes, _wl_block138);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
}
            _bw.write(_wl_block139Bytes, _wl_block139);
 
		if(!procedure_yn.equals("Y") || procedure_yn.equals("")){
			if(diag_class_appl_yn.equals("Y")){
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

					String sql1="SELECT A.DIAG_CLASS_CODE, A.SHORT_DESC,A.DIAG_CLASS_TYPE FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND B.TERM_SET_ID='"+dflt_termset+"' AND A.EFF_STATUS='E' ORDER BY A.SHORT_DESC";
					pstmt = conn.prepareStatement(sql1);
					rset = pstmt.executeQuery();
					int ii=1;
					while( rset.next() ){
						String  _diagcode = rset.getString( "DIAG_CLASS_CODE" ) ;
						String  _shortdesc=rset.getString("SHORT_DESC");
						String  _diagtype=rset.getString("DIAG_CLASS_TYPE");
						//out.println("<script>alert(\"_diagcode :"+_diagcode+"\");</script>");
						if(prin_diag.equals("Y") && _diagtype.equals("PD")){
						}else{
							if(diag_class_code.equals(_diagcode)){
								out.println("<option value ='"+_diagcode+"$"+_diagtype+"' selected>"+_shortdesc+"</option>");
								build_diag_class_type	=	build_diag_class_type+"<input type='hidden' name='diag_class_type_"+ii+"' id='diag_class_type_"+ii+"'value='"+_diagtype+"'>";
							}else{
								out.println("<option value ='"+_diagcode+"$"+_diagtype+"'>"+_shortdesc+"</option>");
								build_diag_class_type	=	build_diag_class_type+"<input type='hidden' name='diag_class_type_"+ii+"' id='diag_class_type_"+ii+"'value='"+_diagtype+"'>";
							}
						}
						ii++;
					}
					if(rset != null) rset.close();
					
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(build_diag_class_type));
            _bw.write(_wl_block144Bytes, _wl_block144);

		}
			

			if(accuracy_appl_yn.equals("Y")){
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

					String sql_accuracy	="select a.accuracy_code||'='||a.accuracy_indicator accuracy_code1, a.accuracy_code, mr_get_desc.MR_ACCURACY(b.accuracy_code,'"+locale+"',2) short_desc,b.DFLT_VALUE_YN from MR_ACCURACY a , mr_term_set_crit_for_pc b where  a.eff_status='E' AND a.accuracy_code=b.accuracy_code and b.patient_class='"+Patient_Class+"' and b.criteria='ACCURACY' order by a.short_desc";
					pstmt = conn.prepareStatement(sql_accuracy);
					rset = pstmt.executeQuery();	
					while(rset.next()){	 
						String accr_desc = rset.getString("short_desc");
						String codes = rset.getString("accuracy_code");
						if(curr_accuracy_code.equals(codes)){
							out.print("<option value='"+codes+"' selected />"+accr_desc );
						}else{
							out.print("<option value='"+codes+"'/>"+accr_desc );
						}
				}
				if(rset != null) rset.close();
		
            _bw.write(_wl_block148Bytes, _wl_block148);

			}else{
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(curr_accuracy_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
				if(severity_appl_yn.equals("Y")){
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(sevr_D_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(sevr_L_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(sevr_S_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(sevr_E_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
}else{
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(curr_severity));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
			if(priority_appl_yn.equals("Y")){
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

					String sql_priority	="select list_value,dflt_value_yn from  mr_term_set_crit_for_pc where  patient_class='"+Patient_Class+"' and criteria='PRIORITY'";
					pstmt = conn.prepareStatement(sql_priority);
					rset = pstmt.executeQuery();
				while(rset.next()){	
				String list_value="";
				//String dflt_value_yn = "";
				String list_value1="";
				list_value=rset.getString("list_value");
				//dflt_value_yn=rset.getString("dflt_value_yn");
				if(list_value.equals("NORMAL")){
					list_value="N";
					list_value1="Normal";
				}
				if(list_value.equals("HIGH")){
					list_value="H";
					list_value1="High";
				}
				if(list_value.equals("CRITICAL")){
					list_value="C";
					list_value1="Critical";
				}
				
				if(curr_priority.equals(list_value)){
						out.print("<option value='"+list_value+"' selected />"+list_value1 );
					}else{
						out.print("<option value='"+list_value+"'/>"+list_value1 );
					}

			}
			if(rset != null) rset.close();

			
			
            _bw.write(_wl_block160Bytes, _wl_block160);

			}
			else
			{
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(curr_priority));
            _bw.write(_wl_block162Bytes, _wl_block162);
}


			if(onset_type_appl_yn.equals("Y"))
			{
		
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(type_N_select));
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(type_A_select));
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(type_C_select));
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);

			}
			else
			{
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(curr_onset_type));
            _bw.write(_wl_block162Bytes, _wl_block162);
}


			if(onset_date_appl_yn.equals("Y"))
			{	
			
			
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(curr_onset_date));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block175Bytes, _wl_block175);

			}
			else
			{
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(curr_onset_date));
            _bw.write(_wl_block162Bytes, _wl_block162);
}


			if(status_appl_yn .equals("Y")){
		
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(dis_status));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(stus_A_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(exculde_list_item.equals("YES")){
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(stus_X_select));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block80Bytes, _wl_block80);

			}else{
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(status));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
			if(as_on_date_appl_yn  .equals("Y")){
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(status_date));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(fields_dis));
            _bw.write(_wl_block181Bytes, _wl_block181);

			}
			else
			{
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(status_date));
            _bw.write(_wl_block162Bytes, _wl_block162);
}

		
            _bw.write(_wl_block183Bytes, _wl_block183);
if(applicable_side_appl_yn.equals("Y")){
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(applicable_l));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(applicable_r));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(applicable_b));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(applicable_n));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
}else{
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(applicable_side));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block192Bytes, _wl_block192);
if(remarks_appl_yn.equals("Y")){
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(rmrk_disabl));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(curr_remarks));
            _bw.write(_wl_block85Bytes, _wl_block85);
}else{
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(curr_remarks));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block194Bytes, _wl_block194);

			if(newCode_yn.equals("Y"))
			{
				DB_Recode_Status	="";
				DB_Recode_Stages	="";
			
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block198Bytes, _wl_block198);

			}
			else
			{
			
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block198Bytes, _wl_block198);
}
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(sel_code));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(sel_code1));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(age));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(Patient_Class));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(confirm_appl));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(recode_status));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(orig_termset));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(orig_termcode));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(procedure_yn));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(newCode_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(accuracy_appl_yn));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(severity_appl_yn));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(priority_appl_yn));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(onset_date_appl_yn));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(as_on_date_appl_yn));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(sel_code));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(sel_srl_no));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(sel_term_code));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(sel_term_set));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(action));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(onset_type_appl_yn));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(status_appl_yn));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(proc_status_appl_yn));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(sel_stages_vals));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(sel_satus_vals));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(sel_grp_vals));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(sel_mod_id));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(sel_cod_xtn));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(sel_cod_xtn_dtl));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(allow_recode_diag_yn));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(allow_recode_proc_yn));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(pat_visit_dt_time));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(pat_disch_dt_time));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(proc_type_hid_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(laterality_ind));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(diagnosis_by_long_desc_yn));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(diag_enc_level));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(notifiable_form_mand_yn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(notifiable_code));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(email_sel_yn));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(default_note_type));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(doctorsDescription));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(isMultiDescAppl));
            _bw.write(_wl_block258Bytes, _wl_block258);

}catch( Exception ex){
	ex.printStackTrace();
}finally{
		ConnectionManager.returnConnection(conn,request);

}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProblemAssessment.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selected.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Items.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Set.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisSet.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OT.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.NonOT.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ext.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Laterality.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Left.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Right.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Excludecodes.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DoctorDesc.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncounterStage.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChiefComplaint.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TypesofNotification.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.WorkRelated.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Classification.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mild.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severe.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Extreme.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OnsetType.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Acute.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Chronic.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Excludecodes.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ason.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicableSide.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Left.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Right.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
