package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
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

public final class __addmodifyopproc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AddModifyOPProc.jsp", 1743500700479L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\">\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/procedures.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCA/js/DateCheck.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/dchk.js\" language=\"javascript\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script>\n    var dt1;\n    function proc_getcode_temp(Obj)\n    {\n\t\tif(makeValidString(Obj)==false || document.OPProc_form.mode.value == \'update\')\n            return false;\n\n\t\tvar pq = document.OPProc_form.s_scheme.value;pq=\"\";\n\t\tvar p_called_from_widget  = document.OPProc_form.p_called_from_widget.value;\n\t\tif (pq == 3 || pq == 4|| pq == 6)\n\t\t{\n\t\t\tvar p_code = Obj.value;\n\t\t\tvar p_scheme    = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\tvar modal_yn = document.OPProc_form.modal_yn.value;\n\n\t\t\tif(modal_yn == \"Y\")\n\t\t\t{\n\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/getProcCodeModal.jsp\'><input type=\'hidden\' name=\'p_code\' id=\'p_code\' value=\'\"+p_code+\"\'><input type=\'hidden\' name=\'p_scheme\' id=\'p_scheme\' value=\'\"+p_scheme+\"\'><input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'\"+modal_yn+\"\'></form></body></html>\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t//CHL-CRF Start. [IN035950]\n\t\t\t\tif(p_called_from_widget!=\"\"){\n\t\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/getProcCodeModal.jsp\'><input type=\'hidden\' name=\'p_code\' id=\'p_code\' value=\'\"+p_code+\"\'><input type=\'hidden\' name=\'p_scheme\' id=\'p_scheme\' value=\'\"+p_scheme+\"\'><input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'\"+modal_yn+\"\'></form></body></html>\";\n\t\t\t\t}else{\n\t\t\t\t//CHL-CRF End.[IN035950]\n\t\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/getProcCode.jsp\'><input type=\'hidden\' name=\'p_code\' id=\'p_code\' value=\'\"+p_code+\"\'><input type=\'hidden\' name=\'p_scheme\' id=\'p_scheme\' value=\'\"+p_scheme+\"\'><input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'\"+modal_yn+\"\'></form></body></html>\";\n\t\t\t\t}//CHL-CRF [IN035950]\n\t\t\t}\n\n\t\t\tif(modal_yn == \"Y\")\n\t\t\t{\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t//CHL-CRF Start. [IN035950]\n\t\t\t\tif(p_called_from_widget!=\"\"){\n\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t}else{\n\t\t\t\t//CHL-CRF End.[IN035950]\n\t\t\t\t\ttop.content.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\ttop.content.messageFrame.document.form1.submit();\n\t\t\t\t}//CHL-CRF [IN035950]\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\tvar term_set_id = document.OPProc_form.proc_set.value;\n\t\t\tvar term_code = Obj.value;\n\t\t\tvar modal_yn = document.OPProc_form.modal_yn.value;\n\t\t\tif(modal_yn == \"Y\")\n\t\t\t{\n\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/getProcCodeModal.jsp\'><input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'\"+term_set_id+\"\'><input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'\"+term_code+\"\'><input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'\"+modal_yn+\"\'></form></body></html>\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t//CHL-CRF Start. [IN035950]\n\t\t\t\tif(p_called_from_widget!=\"\"){\n\t\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/getProcCodeModal.jsp\'><input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'\"+term_set_id+\"\'><input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'\"+term_code+\"\'><input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'\"+modal_yn+\"\'></form></body></html>\";\n\t\t\t\t}else{\n\t\t\t\t//CHL-CRF End.[IN035950]\n\t\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/getProcCode.jsp\'><input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'\"+term_set_id+\"\'><input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'\"+term_code+\"\'><input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'\"+modal_yn+\"\'></form></body></html>\";\n\t\t\t\t}//CHL-CRF [IN035950]\n\t\t\t}\n\n\t\t\tif(modal_yn == \"Y\")\n\t\t\t{\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t//CHL-CRF Start. [IN035950]\n\t\t\t\tif(p_called_from_widget!=\"\"){\n\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t}else{\n\t\t\t\t//CHL-CRF End.[IN035950]\n\t\t\t\t\ttop.content.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\ttop.content.messageFrame.document.form1.submit();\n\t\t\t\t}//CHL-CRF [IN035950]\n\t\t\t}\n\t\t\t\n\t\t}\n\t}\n\t\n\n    async function show_window()\n    {\n\t\tvar s_scheme=document.forms[0].s_scheme.value;\n\t\tvar retVal =    new String();\n\t\tvar dialogHeight= \"28\" ;\n\t\tvar dialogWidth = \"43\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments   = \"\" ;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\tretVal =await  window.showModalDialog(\"../../eCA/jsp/SearchProcedureMain.jsp?s_scheme=\"+s_scheme+\"&s_scheme_desc=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",arguments,features);\n\n\t\tif (!(retVal == null))\n\t\t{\n\t\t\tvar vals=retVal.split(\"/\");\n\t\t\tdocument.OPProc_form.code.value=vals[0];\n\t\t\tif(vals[1] == null || vals[1] == undefined)\n\t\t\t{\n\t\t\t\tvals[1] = \"\";\n\t\t\t}\n\t\t\tdocument.OPProc_form.description1.value=vals[1];\n\t\t}\n\t\tdocument.OPProc_form.code.focus();\n    }\n\n    function val_date(obj)\n\t{\n\t\tif(obj.value !=\'\')\n\t\t{\n\t\t\tif(doDateTimeChk(obj))\n\t\t\t{\n\t\t\t\tHTMLVal = \"<html><body><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/getProcCode.jsp\'><input type=\'hidden\' name=\'validate_dttime\' id=\'validate_dttime\' value=\'Y\'><input type=\'hidden\' name=\'to_dttime\' id=\'to_dttime\' value=\'\"+obj.value+\"\'></form></body></html>\";\n\t\t\t\ttop.content.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\ttop.content.messageFrame.document.form1.submit();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"CA\"));\n\t\t\t\twindow.event.returnValue = false;\n\t\t\t}\n\t   }\n\t}\t\t\n</script>\n\n<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\' onload=\'checkPractitioner();\'>\n<form name=\'OPProc_form\' id=\'OPProc_form\' action=\"../../servlet/eCA.ProceduresServlet\"  method=\'post\' target=\'messageFrame\'>\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> <!-- SRR20056-SCF-9395 [IN037505] -->\n<input type=\"hidden\"  name=\"modal_yn\" id=\"modal_yn\"\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\'hidden\' name=\'p_called_from_widget\' id=\'p_called_from_widget\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'> <!-- //CHL-CRF [IN035950]-->\n<br>\n        <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' height=\'100%\'>\n\t\t\t<tr align=\"left\">\n\t\t\t\t<th class=\'COLUMNHEADER\' colspan=2 >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t<th class=\'COLUMNHEADER\' colspan=2 id=disMar ><font color=red></font></th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n                <td colspan=\'2\' class=\'FIELDS\'>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\t\t\t\t\t<select name=\"code_set\" id=\"code_set\"  disabled <option value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\'></option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<select name=\"code_set\" id=\"code_set\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" disabled ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onChange=\"showTable(this);\" ><option value=\'\'>----- ----- ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="----- -----</option>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"proc_set\" id=\"proc_set\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"proc_set_desc\" id=\"proc_set_desc\" value=\"\">\n\t\t\t\t</td>\n\t\t\t\t<td width=\'25%\'></td>\n            </tr>\n            <tr id=\'proc_CODE\' style=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n                <td width = 25% class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n                <td   class=\'FIELDS\'>\n\t\t\t\t\t<input type=\"text\"  name=\"code\" id=\"code\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" size=\'20\' maxlength=\"30\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onkeypress=\"return CheckForSpecChars2(event)\" onBlur = \'return proc_getcode_temp(this)\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="readonly";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" readonly><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'><input type=\"button\" class=\'Button\' name=\"exclamation\" id=\"exclamation\" title=\'Long Description\' value=\"!\" onClick=\'showDescription(description)\' style=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ><input type=\"hidden\" name=\"s_scheme\" id=\"s_scheme\"   value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="><input type=\"button\" class=\'Button\' name=\"search_button\" id=\"search_button\" title=\'Search\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onClick=\'callTermCode()\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" disabled>\n\t\t\t\t</td>\n               <td> </td><td></td>\n            </tr>\n            <tr id=\'proc_DESC\' style=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t<td colspan=\'2\' class=\'fields\'>\n                    <input type=\"text\"  onBlur=\"makeValidString(this);\" name=\"description1\" id=\"description1\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  style=\"width: 340px;\" maxlength=100 readonly><img src=\'../../eCommon/images/mandatory.gif\'><input type=\"hidden\" onBlur=\"makeValidString(this);\"  name=\"description\" id=\"description\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t</td>\n\t\t\t\t<!--36285 start-->\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" \n\t\t      <td class=\'fields\' align=\'right\'>&nbsp;&nbsp; ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" &nbsp; \n\t\t\t\t <select name=\'classifition_type\' id=\'classifition_type\' onChange=\"validatePrimaryClassificationAvaliableYN();\"  ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =">\n\t\t\t\t     <option value=\'\'>-----";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="-----</option>\n\t\t\t\t\t <option value=\'P\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="select";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\t\t\t\t\t <option value=\'S\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t </select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].classifition_type.value = \'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\';\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' == \'X\')\n\t\t\t\t\t\t\tdocument.forms[0].classifition_type.disabled = true;\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<td<input type=\"hidden\" name=\"classifition_type\" id=\"classifition_type\" value=\"\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<!--36285 start-->\t\t\t\t\n\t\t\t\t\n\t\t\t\t <td class=\'fields\' align=\'right\'>&nbsp;&nbsp; ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" &nbsp;\n\t\t\t\t\t<select name=\'laterality\' id=\'laterality\'>\n\t\t\t\t\t\t<option value=\'\'>-----";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="-----</option>\n\t\t\t\t\t\t<option value=\'L\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</option>\n\t\t\t\t\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</option>\n\t\t\t\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</option>\n\t\t\t\t\t\t<option value=\'N\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].laterality.value = \'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' == \'X\')\n\t\t\t\t\t\t\tdocument.forms[0].laterality.disabled = true;\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n            </tr>\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n            <tr>\n\t\t\t\t<td class=\'label\' width =\'24%\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t<td class=\'FIELDS\'>\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t<input type=\'text\' size=16 maxlength=\'16\' name=\'date\' id=\'date\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="onblur=\"callCheckDateTime(this);timeCalculate(this);\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'date\');\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="<img src=\'../../eCommon/images/mandatory.gif\'><input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' onblur=\"callCheckDateTime(this);timeCalculate(this);\"><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'date\');\" ><img src=\'../../eCommon/images/mandatory.gif\'  ><input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t<input type=text name=Hrs id=Hrs size=3 maxlength=\'2\' value=\'\' onKeyPress = \"return allowValidNumber(this,event,2,0);\" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="onBlur=\' timeCalculate(this);CheckPositiveNumber(this);\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">&nbsp;Hrs. <input type=text name=Min id=Min size=3 maxlength=\'2\' value=\'\' ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="onBlur=\'checkDur(this);timeCalculate(this);CheckPositiveNumber(this);\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" onKeyPress = \"return allowValidNumber(this,event,2,0);\" maxlength=2>&nbsp; Min.\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t<input type=\'text\' size=16 maxlength=\'16\' name=\'enddate\' id=\'enddate\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'  ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="onblur=\"callCheckDateTime(this);clear_hrs();timeCalculate(this);\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'enddate\');\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'ServerDate1\' id=\'ServerDate1\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t<input type=\'text\' size=16 maxlength=\'16\' name=\'enddate\' id=\'enddate\' value=\'\'  onblur=\"callCheckDateTime(this);clear_hrs();timeCalculate(this);\"><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'enddate\');\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'ServerDate1\' id=\'ServerDate1\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' >\n\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t<script language=javascript>\n\t\t\t\t\t\t\tif(document.forms[0].enddate.value != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.forms[0].enddate.focus();\n\t\t\t\t\t\t\t\tdocument.forms[0].enddate.blur();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\t\t\n\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t<input type=\'text\' name=\'loc\' id=\'loc\' size=\'15\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="onBlur=\"populateLocation()\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="><input type=\'button\' class=\'button\' value=\'?\'  name=\'searchLoc\' id=\'searchLoc\' onClick=\"populateLocation()\" ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="><input type=hidden name=\'Location\' id=\'Location\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n            <tr>\n\t\t\t\t<td class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t<td colspan=3 class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'pract\' id=\'pract\' size=\'15\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="onBlur=\"populatePract_blur(this)\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="><input type=\'button\' class=\'button\' value=\'?\'  name=\'searchpract\' id=\'searchpract\' onClick=\"populatePract()\" ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="><input type=hidden name=\'practitioner\' id=\'practitioner\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'>\n\n\t\t\t\t\t<b>,</b><input type=\'text\' name=\'pract1\' id=\'pract1\' size=\'15\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="onBlur=\"populatePract2_blur(this)\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="><input type=\'button\' class=\'button\' value=\'?\'  name=\'searchpract2\' id=\'searchpract2\' onClick=\"populatePract2()\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="><input type=hidden name=\'practitioner1\' id=\'practitioner1\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\n\t\t\t\t\t<b>,</b><input type=\'text\' name=\'pract2\' id=\'pract2\' size=\'15\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="onBlur=\"populatePract3_blur(this)\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" ><input type=\'button\' class=\'button\' value=\'?\'  name=\'searchpract3\' id=\'searchpract3\' onClick=\"populatePract3()\" ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="><input type=hidden name=\'practitioner2\' id=\'practitioner2\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'> \n\t\t\t\t</td>\n\t\t\t</tr>\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="&nbsp;</td>\n\t\t\t\t<td colspan=3 class=\'fields\'>\n\t\t\t\t\t<select name=\'anaesthetists1\' id=\'anaesthetists1\' onchange=\'chkDupPract(this)\' ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="><option value=\'\'>----- ----- ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="----- -----</option>\n            ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t</select><b>,</b><select name=\'anaesthetists2\' id=\'anaesthetists2\' onchange=\'chkDupPract(this)\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t</select><b>,</b><select name=\'anaesthetists3\' id=\'anaesthetists3\' onchange=\'chkDupPract(this)\' ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="----- -----</option>\n             ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t</select></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t\t\t<td colspan=3 class=\'FIELDS\'>\n\t\t\t\t\t<input type=\'text\' name=\'nurse\' id=\'nurse\' size=\'15\'  value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="onBlur=\"populateNurse()\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="><input type=\'button\' class=\'button\' value=\'?\'  name=\'\' id=\'\' onClick=\"populateNurse()\" ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="><input type=hidden name=\'scrubnurse\' id=\'scrubnurse\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t</tr>\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="&nbsp;</td>\n\t\t\t\t<td colspan=3 class=\'FIELDS\'> \n\t\t\t\t\t<select name=\'anaesthesia\' id=\'anaesthesia\' ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\t\n\t\t\t<tr>\n                    <td class=\"label\">";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"anaesthesDet\" rows=\'2\' maxlength=500  onFocus=\'getObject(this)\'  onKeyPress=\'checkMaxLimit(this,500);\'   onBlur=\"makeValidString(this);\" cols=\'60\' ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</textarea>\n\t\t\t\t\t</td>\n            </tr>\n            <tr>\n                    <td class=\"label\">";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"indication\" rows=\'2\'  maxlength=2000 onFocus=\'getObject(this)\'                   onKeyPress=\'checkMaxLimit(this,2000);\'  onBlur=\"makeValidString(this);\" cols=\'60\' ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"monitor\" rows=\'2\'  onFocus=\'getObject(this)\' onBlur=\"makeValidString(this);\" maxlength=500 onKeyPress=\'checkMaxLimit(this,500);\' cols=\'60\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"hpi\" rows=\'2\' maxlength=500  onFocus=\'getObject(this)\' onKeyPress=\'checkMaxLimit(this,500);\'   onBlur=\"makeValidString(this);\" cols=\'60\' ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"proceduresummary\" rows=\'2\'  maxlength=2000  onFocus=\'getObject(this)\'                     onKeyPress=\'checkMaxLimit(this,2000);\'  onBlur=\"makeValidString(this);\" cols=\'60\' ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"findings\" rows=\'2\' onBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'getObject(this)\' onKeyPress=\'checkMaxLimit(this,500);\' cols=\'60\' ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"impression\" rows=\'2\' onBlur=\"makeValidString(this);\" cols=\'60\'  onFocus=\'getObject(this)\' onKeyPress=\'checkMaxLimit(this,200);\' maxlength=200 ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</textarea>\n\t\t\t\t\t</td>\n            </tr>\n            <tr>\n                    <td  class=\"label\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"disposition\" rows=\'2\' maxlength=200 onBlur=\"makeValidString(this);\"  onFocus=\'getObject(this)\' onKeyPress=\'checkMaxLimit(this,200);\' cols=\'60\' ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"events\" rows=\'2\' onBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'getObject(this)\' onKeyPress=\'checkMaxLimit(this,500);\' cols=\'60\' ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"postProcedure\" rows=\'2\' onBlur=\"makeValidString(this);\" cols=\'60\'  onFocus=\'getObject(this)\' onKeyPress=\'checkMaxLimit(this,200);\' maxlength=200 ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="&nbsp;</td>\n                    <td colspan=\'3\' class=\'FIELDS\'>\n\t\t\t\t\t\t<textarea style=\"resize:none\"  name=\"specimen\" rows=\'2\' maxlength=200 onBlur=\"makeValidString(this);\"  onFocus=\'getObject(this)\' onKeyPress=\'checkMaxLimit(this,200);\' cols=\'60\' ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</textarea>\n\t\t\t\t\t</td>\n            </tr>\n        </table>\n        <input type=\"hidden\"  name=\"practitionernameSESSION\" id=\"practitionernameSESSION\"    value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n        <input type=\"hidden\"  name=\"locncode\" id=\"locncode\"       value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n        <input type=\"hidden\"  name=\"locntype\" id=\"locntype\"       value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n        <input type=\"hidden\"  name=\"facility_id\" id=\"facility_id\"         value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n        <input type=\"hidden\"  name=\"facilityid\" id=\"facilityid\"         value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n        <input type=\"hidden\"  name=\"encounterid\" id=\"encounterid\"        value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n        <input type=\"hidden\"  name=\"patientid\" id=\"patientid\"      value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n        <input type=\"hidden\"  name=\"record_type\" id=\"record_type\"        value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n        <input type=\"hidden\"  name=\"cause_indicator\" id=\"cause_indicator\"    value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n        <input type=\"hidden\"  name=\"patient_class\" id=\"patient_class\"      value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' >\n\t\t<input type=\"hidden\"  name=\"mode\" id=\"mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t<input type=\"hidden\"  name=\"upd_pat_id\" id=\"upd_pat_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t<input type=\"hidden\"  name=\"upd_srl_no\" id=\"upd_srl_no\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t<input type=\"hidden\"  name=\"upd_encounter_id\" id=\"upd_encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t<input type=\"hidden\"  name=\"order_id\" id=\"order_id\"\tvalue=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t<input type=\"hidden\"  name=\"order_line_num\" id=\"order_line_num\"\tvalue=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"> \n\t\t<input type=\"hidden\"  name=\"dup_chk\" id=\"dup_chk\"\tvalue=\"\">\n\n\t\t<input type=\"hidden\"  name=\"dummy\" id=\"dummy\"\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"errorRemarks\" id=\"errorRemarks\" value=\"\">\n\t\t<input type=\"hidden\" name=\"visitdate\" id=\"visitdate\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t<input type=\"hidden\" name=\"visit_adm_date_time\" id=\"visit_adm_date_time\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t<input type=\"hidden\" name=\"qryStr\" id=\"qryStr\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t<!--\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"> - commented for  SRR20056-SCF-9395 [IN037505] --> \n\t\t<input type=\"hidden\" name=\"accession_number\" id=\"accession_number\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"> \n\t\t<input type=\"hidden\" name=\"curr_level\" id=\"curr_level\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t\t<input type=\"hidden\" name=\"enablePriSecProc\" id=\"enablePriSecProc\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"><!-- // 36285 -->\n\t\t<input type=\"hidden\" name=\"p_classifition_type\" id=\"p_classifition_type\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t</td>\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );
	
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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created 
20/01/2012		CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]										
------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------
05/08/2015	IN037505	   Karthi L	       ?			  ?			[SRR20056-SCF-9373 ] - After select Start Date/time and Duration, System doesn?t calculate and display Ending date/time.
10/03/2022  36285          Hariharan k       		                  MMs-DM-CRF-0221.v1.0(003)
------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String visitdate= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
	String accession_number= request.getParameter("accession_number")==null?"":request.getParameter("accession_number");
	visitdate = com.ehis.util.DateUtils.convertDate(visitdate,"DMYHM","en",locale);
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
	String facility_id		= (String) session.getValue("facility_id");// 36285 
	String bean_id 						= "@ProceduresBean";// 36285
	String bean_name 					= "eCA.ProceduresBean";// 36285
	ProceduresBean bean					= (ProceduresBean)getBeanObject( bean_id, bean_name, request ) ;// 36285
	String  enablePriSecProc = bean.getProceduresData(facility_id);
	// 36285
	//String proc_scheme_id="";// 36285

	try
	{   
		PreparedStatement stmt = null;
		ResultSet rset = null ;
		PreparedStatement pstmt = null;
	
		con = ConnectionManager.getConnection(request);
		String sql = "";
		String sql1 = "";
		String operating_facility_id = "";
		String practitioner_id1 = "";
		String patient_id = "";
		String encounter_id = "";
		String sel = "";
		String name = "";
		String curr_level = "";
		String ass_pract_name = "";
		String ass_pract_name3 = "";
		String id = "";
		String s_scheme = "";
		String s_scheme_desc = "";
		String desc = "";
		String record_type = "O";
		String cause_indicator = "";
		String locn_code = "";
		String locn_type = "";
		String order_id = "";
		String order_line_num = "";
		String or_order_id = "";
		String code_disable = "";
		String term_set_id = "";	
		String disp_code = "display:";
		int i = 1;
		operating_facility_id = (String)session.getValue("facility_id");
		String practitioner_type = (String)session.getValue("practitioner_type")==null?"":(String)session.getValue("practitioner_type");
		StringBuffer sql_proc = new StringBuffer(); 
		String Encounter_Id	= request.getParameter("Encounter_Id") == null ? "" : request.getParameter("Encounter_Id");
		term_set_id = request.getParameter("term_set_id") == null ? "" : request.getParameter("term_set_id");
	
		
		String resp_id = (String)session.getValue("responsibility_id");
		String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");

		//practitioner_id1 = (String)session.getValue("ca_practitioner_id");

		practitioner_id1 = (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");

		String practitioner_name = "";
		String visit_adm_date_time = "";
		or_order_id		= request.getParameter("orderId") == null ? "" : request.getParameter("orderId");
		order_line_num	= request.getParameter("order_line_num") == null ? "" : request.getParameter("order_line_num");
		encounter_id	= request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
		patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		locn_code		= request.getParameter("location_code") == null ? "" : request.getParameter("location_code");
		locn_type		= request.getParameter("location_type") == null ? "" : request.getParameter("location_type");

		String patient_class = request.getParameter("patient_class")==null?"": request.getParameter("patient_class");
		String proc_code				= "";
		String proc_narration			= "";
		String proc_codelong_desc		= "";
		String proc_date				= "";
		String start_datetime = "";
		String end_datetime = "";
		String ass_practitioner1 = "";
		String ass_practitioner2 = "";
		String ass_practitioner3 = "";
		String anaesthetist1 = "";
		String anaesthetist2 = "";
		String anaesthetist3 = "";
		String anaesthesia_code = "";
		String anaesthesia_detail = "";
		String indication = "";
		String monitoring = "";
		String events = "";
		String post_proc_std_orders = "";
		String specimen_sent = "";
		String scrub_nurse = "";
		String upd_practitioner_name	= "";
		String upd_practitioner_id		= "";
		String hpi						= "";
		String proc_summary				= "";
		String findings					= "";
		String impression				= "";
		String disposition				= "";
		String upd_encounter_id			= "";
		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		
		String upd_code = request.getParameter("code") == null ? "" : request.getParameter("code");
		String upd_pat_id = request.getParameter("pat_id") == null ? "" : request.getParameter("pat_id");
		String upd_srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
		String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
		String upd_enc_id = request.getParameter("encounter_id1") == null ? "" : request.getParameter("encounter_id1");
		
		String scrubname="";
		String laterality_ind = "";
		String proc_perf_locn_code = "";
		String locn_desc = "";
		String modify_Yn = "";
		String sql_task = "";
		String classifition_type=""; //36285

		if(!term_set_id.equals("") && !mode.equals("OR"))
		{
			mode ="update";
			disp_code ="display:";
		}
		order_id = or_order_id;

		String pracsql="Select  practitioner_name from am_practitioner_LANG_VW WHERE practitioner_id=? AND LANGUAGE_ID = ?";
		pstmt = con.prepareStatement(pracsql);
		pstmt.setString(1,practitioner_id1);
		pstmt.setString(2,locale);
		rset= pstmt.executeQuery();

		if(rset.next())
		practitioner_name=rset.getString("practitioner_name");

		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();


	    sql1 ="SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time FROM pr_encounter WHERE encounter_id=? AND facility_id=?";
		pstmt=con.prepareStatement(sql1);
		if(mode.equals("update"))
		{
			pstmt.setString(1,upd_enc_id);
		}
		else
		{

           pstmt.setString(1,Encounter_Id);
		}
		pstmt.setString(2,operating_facility_id);
		rset=pstmt.executeQuery();

		if(rset.next())
		{
		visit_adm_date_time = rset.getString("visit_adm_date_time")==null?"":rset.getString("visit_adm_date_time");
		visit_adm_date_time = com.ehis.util.DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);
		}
		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();
		if(mode.equals("update"))
		{
			String sql_nquery ="SELECT CURR_LEVEL FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID=? AND ENCOUNTER_ID=?";
			try
			{
				pstmt=con.prepareStatement(sql_nquery);
				pstmt.setString(1,operating_facility_id);
				pstmt.setString(2,encounter_id);
				rset=pstmt.executeQuery();
				if(rset!=null)
				{
					while(rset.next())
					{
						curr_level=rset.getString("CURR_LEVEL");						
					}
				}
				if(rset != null)rset.close();
				if(pstmt != null)pstmt.close();				
			}
			catch(Exception e)
			{
				e.printStackTrace() ;				
			}
		}		
		if(mode.equals("update"))
		{
			//String sql_query = "select proc_code, proc_narration, to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date, practitioner_name upd_practitioner_name, hpi, proc_summary, findings, impression, disposition, a.practitioner_id upd_practitioner_id, encounter_id, order_id, order_line_num,           start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime ,  ass_practitioner1,  ass_practitioner2,(select short_name from am_practitioner where practitioner_id=ass_practitioner2 ) ass_pract_name , anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, long_desc from pr_encounter_procedure a , am_practitioner b ,mr_term_code where a.practitioner_id = b.practitioner_id and proc_code = ? and patient_id =? and srl_no =? and term_code = proc_code ";

			//String sql_query = "select rtrim(proc_code) proc_code, SHORT_DESC proc_narration, to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') upd_practitioner_name, hpi, proc_summary, findings, impression, disposition, a.practitioner_id upd_practitioner_id, encounter_id, order_id, order_line_num, start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime ,  ass_practitioner1,  ass_practitioner2,AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner2,?,'1')  ass_pract_name , anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, long_desc, laterality_ind, ass_practitioner3, AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner3,?,'1')  ass_pract_name3, a.proc_perf_locn_code, OP_GET_DESC.OP_CLINIC(?,a.proc_perf_locn_code,?,'2') locn_desc from pr_encounter_procedure a , mr_term_code where  rtrim(proc_code) = ? and patient_id =? and srl_no =? and term_code = rtrim(proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME";
			String sql_query = "select rtrim(proc_code) proc_code, SHORT_DESC proc_narration, to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') upd_practitioner_name, hpi, proc_summary, findings, impression, disposition, a.practitioner_id upd_practitioner_id, encounter_id, order_id, order_line_num, start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime ,  ass_practitioner1,  ass_practitioner2,AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner2,?,'1')  ass_pract_name , anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, long_desc, laterality_ind, ass_practitioner3, AM_GET_DESC.AM_PRACTITIONER(a.ass_practitioner3,?,'1')  ass_pract_name3, a.proc_perf_locn_code, OP_GET_DESC.OP_CLINIC(?,a.proc_perf_locn_code,?,'2') locn_desc,a.CLASSIFITION_TYPE from pr_encounter_procedure a , mr_term_code where  rtrim(proc_code) = ? and patient_id =? and srl_no =? and term_code = rtrim(proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME";//36285
			pstmt = con.prepareStatement(sql_query);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,operating_facility_id);
			pstmt.setString(5,locale);
			pstmt.setString(6,upd_code);
			pstmt.setString(7,upd_pat_id);
			pstmt.setString(8,upd_srl_no);
			rset= pstmt.executeQuery();
			
			if(rset!=null)
			{
				if(rset.next())
				{
					proc_code				=	rset.getString("proc_code");
					proc_narration			=	rset.getString("proc_narration");
					proc_date				=	rset.getString("proc_date");
					upd_practitioner_name	=	rset.getString("upd_practitioner_name");
					hpi						=	rset.getString("hpi");
					proc_summary			=	rset.getString("proc_summary");
					findings				=	rset.getString("findings");
					impression				=	rset.getString("impression");
					disposition				=	rset.getString("disposition");
					upd_practitioner_id		=   rset.getString("upd_practitioner_id");
					upd_encounter_id		=	rset.getString("encounter_id");
					order_id                =   rset.getString("order_id");
					order_line_num          =   rset.getString("order_line_num");
					start_datetime			=	rset.getString("start_datetime");
					end_datetime			=	rset.getString("end_datetime");
					ass_practitioner1		=	rset.getString("ass_practitioner1");
					ass_practitioner2		=	rset.getString("ass_practitioner2");
					ass_pract_name			=	rset.getString("ass_pract_name")==null?"":rset.getString("ass_pract_name");
					anaesthetist1			=	rset.getString("anaesthetist1");
					anaesthetist2			=	rset.getString("anaesthetist2");
					anaesthetist3			=	rset.getString("anaesthetist3");
					anaesthesia_code		=	rset.getString("anaesthesia_code");
					anaesthesia_detail		=	rset.getString("anaesthesia_detail");
					indication				=   rset.getString("indication");
					monitoring				=	rset.getString("monitoring");
					events					=   rset.getString("events");
					post_proc_std_orders    =   rset.getString("post_proc_std_orders");
					specimen_sent           =   rset.getString("specimen_sent");
					scrub_nurse				=   rset.getString("scrub_nurse");
					proc_codelong_desc		=	rset.getString("long_desc");
					laterality_ind			=	rset.getString("laterality_ind");
					ass_pract_name3			=	rset.getString("ass_pract_name3") == null ? "" : rset.getString("ass_pract_name3");
					ass_practitioner3		=	rset.getString("ass_practitioner3") == null ? "" : rset.getString("ass_practitioner3");
					proc_perf_locn_code		=	rset.getString("proc_perf_locn_code") == null ? "" : rset.getString("proc_perf_locn_code");
					locn_desc				=	rset.getString("locn_desc") == null ? "" : rset.getString("locn_desc");
					classifition_type       =   rset.getString("classifition_type");//36285
					

					if(start_datetime== null)start_datetime			= "";
					if(end_datetime== null )end_datetime			= "";
					if(ass_practitioner1== null )ass_practitioner1	= "";
					if(ass_practitioner2== null )ass_practitioner2	= "";
					if(anaesthetist1== null )anaesthetist1			= "";
					if(anaesthetist2== null )anaesthetist2			= "";
					if(anaesthetist3== null )anaesthetist3			= "";
					if(anaesthesia_code== null )anaesthesia_code	= "";
					if(anaesthesia_detail== null )anaesthesia_detail= "";
					if(indication== null )indication				= "";
					if(monitoring== null )monitoring				= "";
					if(events== null )events						= "";
					if(post_proc_std_orders== null )post_proc_std_orders	= "";
					if(specimen_sent== null )specimen_sent			= "";
					if(scrub_nurse== null )scrub_nurse				= "";
					if(proc_code				== null	)proc_code				= "";
					if(proc_narration			== null )proc_narration			= "";
					if(proc_date				== null )proc_date				= "";
					if(upd_practitioner_name	== null )upd_practitioner_name	= "";
					if(hpi						== null )hpi					= "";
					if(proc_summary				== null )proc_summary			= "";
					if(findings					== null )findings				= "";
					if(impression				== null )impression				= "";
					if(disposition				== null )disposition			= "";
					if(upd_practitioner_id		== null )upd_practitioner_id	= "";
					if(upd_encounter_id			== null )upd_encounter_id		= "";
					if(order_id                 == null )order_id				= "";
					if(order_line_num			== null )order_line_num			= "";
					if(proc_codelong_desc		== null )proc_codelong_desc		= "";
					if(laterality_ind			== null )laterality_ind			= "";
					if(classifition_type		== null )classifition_type	    = "";//36285
					

					proc_date		=	com.ehis.util.DateUtils.convertDate(proc_date,"DMYHM","en",locale);
					end_datetime	=	com.ehis.util.DateUtils.convertDate(end_datetime,"DMYHM","en",locale);
				}
			}
			code_disable ="readonly";	
		}
		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();

		sql_task = "SELECT GET_TASK_APPLICABILITY('MOIDFY_PROCEDURE',NULL,?,?,?,?,?) FROM DUAL";
		pstmt = con.prepareStatement(sql_task);
		pstmt.setString(1,resp_id);
		pstmt.setString(2,reln_id);
		pstmt.setString(3,operating_facility_id);
		pstmt.setString(4,Encounter_Id);
		pstmt.setString(5,patient_id);
		
		rset= pstmt.executeQuery();
		if(rset!=null)
		{
			if(rset.next())
			{
				modify_Yn = rset.getString(1);
			}
		}
		if(rset != null)rset.close();
		if(pstmt != null)pstmt.close();

		sql="Select proc_code_scheme scheme,decode(proc_code_scheme,'3','CPT4','4','ICD9-CM','6','ICD10-PCS') scheme_desc from mr_parameter";
		try
		{
			stmt=con.prepareStatement(sql);
			rset=stmt.executeQuery();
			if(rset!=null)
			{
				while(rset.next())
				{
					s_scheme=rset.getString(1);
					s_scheme_desc =rset.getString(2);
				}
			}
			if(rset != null)rset.close();
			if(stmt != null)stmt.close();
			if(pstmt!=null)pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}

		if (mode.equals("OR"))
		{
			s_scheme = "";
			try
			{
    			if (s_scheme.equals("3"))
				{
    				sql="Select cpt_code proc_code,short_desc from mr_cpt_code where cpt_code=?";
    			}
				else if ((s_scheme.equals("4"))||(s_scheme.equals("6")))
				{
    				sql="Select diag_code proc_code,short_desc,record_type,cause_indicator from mr_icd_code where record_type='O' and diag_code=?";
    			}
				else
				{
					sql="select term_code proc_code,short_desc ,long_desc from mr_term_code where term_set_id like upper(?) and term_code like upper(?)";
				}
    		  
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,term_set_id);
    			pstmt.setString(2,upd_code);
    			rset = pstmt.executeQuery();
    			while(rset.next())
				{
					proc_code = rset.getString("proc_code");	
					if (proc_code == null) proc_code = "";
    				desc = rset.getString("short_desc");
					if (desc == null) desc = "";
					proc_codelong_desc = rset.getString("long_desc");
    				if (proc_codelong_desc == null) proc_codelong_desc = "";
    			}
		 
				if(rset != null) rset.close();
		  
			}
			catch (Exception e)
			{
				e.printStackTrace() ;
			}
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(s_scheme));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(s_scheme_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

						if(!term_set_id.equals("")) {  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
if(mode.equals("update") ||( modal_yn.equals("Y")&&!called_from.equals("MR"))){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 }
					if(sql_proc.length() > 0) sql_proc.delete(0,sql_proc.length());
					sql_proc.append("select a.term_set_id,priority_appl_yn||'='||nature_appl_yn||'='||severity_appl_yn||'='||onset_type_appl_yn||'='||factors_appl_yn||'='||notification_appl_yn term_set_id1,term_set_desc "); 
					sql_proc.append("from mr_term_set a where exists (select 1 from mr_term_set_for_facility where FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from "); 
					sql_proc.append("mr_term_set_for_pract_type where PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID) ");
					if (!patient_class.equals("XT"))
					sql_proc.append(" and exists (select 1 from mr_term_set_for_specialty where SPECIALTY_CODE in (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?) AND TERM_SET_ID=A.TERM_SET_ID)  "); 
					sql_proc.append(" and (exists (select 1 from mr_term_set_for_pract ib  where PRACTITIONER_ID=? AND "); 
					sql_proc.append(" TERM_SET_ID=A.TERM_SET_ID) or not exists (select 1 from "); 
					sql_proc.append(" mr_term_set_for_pract  where PRACTITIONER_ID=?) ) and "); 
					sql_proc.append(" Eff_status='E' and proc_spec_yn='Y' order by term_set_desc");
			
					pstmt = con.prepareStatement(sql_proc.toString());
					pstmt.setString(i++,operating_facility_id);
					pstmt.setString(i++,practitioner_type);

					if (!patient_class.equals("XT"))
					{
						pstmt.setString(i++,operating_facility_id);
						pstmt.setString(i++,Encounter_Id);
					}
					pstmt.setString(i++,practitioner_id1);
					pstmt.setString(i++,practitioner_id1);
					rset = pstmt.executeQuery();

					while(rset.next())
					{
						String proc_desc = rset.getString("term_set_desc");
						String proc_set_id = rset.getString("term_set_id")+"~"+proc_desc;
						String temp_proc_set = rset.getString("term_set_id");
						
						if(term_set_id.equals(temp_proc_set))
						{
							out.print("<option value='"+proc_set_id+"' selected >"+proc_desc+"</option>");
						}
						else
						{
							out.print("<option value='"+proc_set_id+"' >"+proc_desc+"</option>");
						}
					}
					if(rset	!= null)   rset.close();
					if(pstmt  != null)   pstmt.close();		
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disp_code));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_disable));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(mode.equals("OR")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((proc_codelong_desc.equals("") ? "visibility:hidden":"visibility:visible")));
            _bw.write(_wl_block31Bytes, _wl_block31);
//=s_scheme
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((mode.equals("OR") ? "disabled":"")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((mode.equals("update") ? "disabled":"")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_code));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
if(mode.equals("update")) out.print(proc_narration); else out.print(desc);
            _bw.write(_wl_block38Bytes, _wl_block38);
if(mode.equals("update")) out.print(proc_codelong_desc); else out.print(desc);
            _bw.write(_wl_block39Bytes, _wl_block39);

			        if(enablePriSecProc.equals("Y")) {  
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
if(mode.equals("update") && !"".equals(classifition_type) ){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
if("P".equals(classifition_type)){
            _bw.write(_wl_block44Bytes, _wl_block44);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
if("S".equals(classifition_type)){
            _bw.write(_wl_block44Bytes, _wl_block44);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

				if(mode.equals("update"))
				{
			
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classifition_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(modify_Yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
		
				}
			
            _bw.write(_wl_block51Bytes, _wl_block51);

				  } else{
				
            _bw.write(_wl_block52Bytes, _wl_block52);

				  }
			    
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

				if(mode.equals("update"))
				{
			
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(laterality_ind));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(modify_Yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
		
				}
			
            _bw.write(_wl_block62Bytes, _wl_block62);

				String dt = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

					if(mode.equals("update"))
					{
				
			
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(proc_date));
            _bw.write(_wl_block66Bytes, _wl_block66);
if(modify_Yn.equals("X")){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
if(!modify_Yn.equals("X")){
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(proc_date));
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
					else
					{
						
			
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(dt));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dt));
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
			
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
if((mode.equals("update")&& modify_Yn.equals("X"))){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block76Bytes, _wl_block76);
if((mode.equals("update")&& modify_Yn.equals("X"))){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

					if(mode.equals("update"))
					{
			
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(end_datetime));
            _bw.write(_wl_block81Bytes, _wl_block81);
if(modify_Yn.equals("X")){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
if(!modify_Yn.equals("X")){
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(end_datetime));
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
					else
					{
			
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dt));
            _bw.write(_wl_block86Bytes, _wl_block86);

					}
			
            _bw.write(_wl_block87Bytes, _wl_block87);

					if(mode.equals("update"))
					{
			
            _bw.write(_wl_block88Bytes, _wl_block88);
 
					} 
			
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((mode.equals("update")?locn_desc:"")));
            _bw.write(_wl_block66Bytes, _wl_block66);
if((mode.equals("update")&& modify_Yn.equals("X"))){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf((mode.equals("update")?proc_perf_locn_code:"")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf((mode.equals("update")?upd_practitioner_name:practitioner_name)));
            _bw.write(_wl_block66Bytes, _wl_block66);
if((mode.equals("update")&& modify_Yn.equals("X"))){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(mode.equals("update")?(upd_practitioner_id):(practitioner_id1)));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf((mode.equals("update")?ass_pract_name:"")));
            _bw.write(_wl_block66Bytes, _wl_block66);
if((mode.equals("update")&& modify_Yn.equals("X"))){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block100Bytes, _wl_block100);
} if(upd_practitioner_id.equals("")&&practitioner_id1.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf((((mode.equals("update")&& modify_Yn.equals("X"))||(upd_practitioner_id.equals("")&&practitioner_id1.equals("")))?"disabled":"")));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf((mode.equals("update")?ass_practitioner2:"")));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf((mode.equals("update")?ass_pract_name3:"")));
            _bw.write(_wl_block66Bytes, _wl_block66);
if((mode.equals("update")&& modify_Yn.equals("X"))){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block104Bytes, _wl_block104);
}if(ass_practitioner2.equals("")) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf((((mode.equals("update")&& modify_Yn.equals("X"))||(ass_practitioner2.equals("")))?"disabled":"")));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf((mode.equals("update")?ass_practitioner3:"")));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

						sql="Select b.practitioner_name,a.practitioner_id from am_pract_for_facility A, AM_PRACTITIONER_LANG_VW B where a.facility_id= ? and a.eff_status='E' and b.pract_type='AN' and a.practitioner_id = b.practitioner_id and b.language_id = ? order by 1";
						try
						{
							stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							stmt.setString(1,operating_facility_id);
							stmt.setString(2,locale);
							rset=stmt.executeQuery();
							if(rset!=null)
							{
								while(rset.next())
								{
									name=rset.getString(1);
									id =rset.getString(2);
									if(mode.equals("update"))
									{
										if (id.trim().equalsIgnoreCase(anaesthetist1))
											sel="selected";
										else 
											sel="";
									}
									else
									{
											sel="";
									}
									out.println("<option value='"+id+"'" + sel +">"+name+"</option>");
								}
							}
														  
						}
						catch(Exception e)
						{
							e.printStackTrace() ;
						}
			
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
 
						try
						{
							rset.beforeFirst();
							if(rset!=null)
							{
								while(rset.next())
								{
									name=rset.getString(1);
									id =rset.getString(2);
									if(mode.equals("update"))
									{
										if (id.trim().equalsIgnoreCase(anaesthetist2))
											sel="selected";
										else
											sel="";
									}
									else
									{
										sel="";
									}
									out.println("<option value ='"+id+"'" + sel +">"+name+"</option>");
								}
							}
						}
						catch(Exception e)
						{
							e.printStackTrace() ;
						}

             
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
 
						try
						{
							rset.beforeFirst();
							if(rset!=null)
							{
								while(rset.next())
								{
									name=rset.getString(1);
									id =rset.getString(2);
									if(mode.equals("update"))
									{
										if (id.trim().equalsIgnoreCase(anaesthetist3))
											sel="selected";
										else 
											sel="";
									}
									else
									{
										sel="";
									}
									out.println("<option value='"+id+"'" + sel +">"+name+"</option>");
								}
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
							}
							catch(Exception e)
							{
								e.printStackTrace() ;
							}

				
            _bw.write(_wl_block114Bytes, _wl_block114);

				if(mode.equals("update"))
				{
					if(!scrub_nurse.equals(""))
					{
						sql="Select b.practitioner_name description,a.practitioner_id code from am_pract_for_facility A,AM_PRACTITIONER_LANG_VW B where a.facility_id= ? and a.eff_status='E' and b.pract_type='NS'  and a.practitioner_id = b.practitioner_id and b.language_id = ? and  upper(a.practitioner_id)  like upper(?)";
						try
						{
							stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							stmt.setString(1,operating_facility_id);
							stmt.setString(2,locale);
							stmt.setString(3,scrub_nurse);
							rset=stmt.executeQuery();
							if(rset!=null)
							{
								while(rset.next())
								{
									scrubname=rset.getString("description");
								}
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
						}
						catch(Exception e)
						{
							e.printStackTrace() ;
						}
					}
				}
			
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
if(mode.equals("update")) out.println(scrubname);
            _bw.write(_wl_block66Bytes, _wl_block66);
if((mode.equals("update")&& modify_Yn.equals("X"))){
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((mode.equals("update")?scrub_nurse:"")));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"disabled":"")));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

					sql="Select AM_GET_DESC.AM_ANAESTHESIA(ANAESTHESIA_CODE,?,'1')  LONG_DESC,ANAESTHESIA_CODE from AM_ANAESTHESIA where eff_status='E' order by 1";     
					try
					{
						stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						stmt.setString(1,locale);
						rset=stmt.executeQuery();
						if(rset!=null)
						{
							while(rset.next())
							{
								name=rset.getString(1);
								id =rset.getString(2);
								if(mode.equals("update"))
								{
									if (id.trim().equalsIgnoreCase(anaesthesia_code))
										sel="selected";
									else
										sel="";
								}
								else
								{
									sel="";
								}
								out.println("<option value='"+id+"' " + sel +">"+name+"</option>");
							}
						}
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
						if(stmt!=null) stmt.close();
					}
					catch(Exception e)
					{
						e.printStackTrace() ;
					}
			
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(anaesthesia_detail));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(indication));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(monitoring));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(hpi));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(proc_summary));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(findings));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(impression));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disposition));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(events));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(post_proc_std_orders));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(((mode.equals("update")&& modify_Yn.equals("X"))?"readonly":"")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(specimen_sent));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(operating_facility_id));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(operating_facility_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(record_type));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(upd_pat_id));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(upd_srl_no));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(upd_encounter_id));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(visitdate));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(enablePriSecProc));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(classifition_type));
            _bw.write(_wl_block160Bytes, _wl_block160);

	}
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewProcedure.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ProcedureSet.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcedureCode.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClassificationType.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Primaryppx.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Secondaryppx.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Laterality.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Left.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Right.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.StartingTime.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EndingTime.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Anaesthetists.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ScrubNurse.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthesia.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AnaesthesiaDetails.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Indication.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Monitoring.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HPI.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ProcedureSummary.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Findings.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Impression.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disposition.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Events.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PostProcedureStdOrders.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpecimenSent.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
