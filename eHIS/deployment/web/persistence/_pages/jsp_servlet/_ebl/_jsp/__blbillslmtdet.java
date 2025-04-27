package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillslmtdet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtDet.jsp", 1709114425806L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<HEAD>\n<!--\t<TITLE> Bill Settlement Details  11 </TITLE> -->\n\t\t<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </TITLE>\n<!--\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\'javascript\'>\t\n\t/*function dfltslmt()\n    {\n\tvar dfltslmt = document.forms[0].dfltslmttypecode.value;\t\n\tvar billslmtamt = document.forms[0].billslmtamt.value;\t\n\tif (billslmtamt == null || billslmtamt == 0 || billslmtamt == \"\")\n\t\treturn;\t\t\t\n\ttry\n\t{\n\t\tfor(i=0;i<document.forms[0].slmttype.options.length;i++)\n\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\tvar cashSetValue = document.forms[0].slmttype.options[i].value;\n\t\t\t\t\t\n\t\t\tif (cashSetValue == null)\n\t\t\t{\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tvar len = cashSetValue.length;\n\t\t\tvar subValue =\"\";\n\n\t\t\tif (len >0)\n\t\t\t{\n\t\t\t\tsubValue = cashSetValue.substring(0,len-1);\n\t\t\t}\n\t\t\tif (subValue == dfltslmt)\n\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\tdocument.forms[0].slmttype.value = cashSetValue;\n\t\t\t\tcalldfltslmt(cashSetValue);\n\t\t\t}\t\t\t\t\t\t\t\t\t\n\t\t}\t\t\t\t\n\t}\n\tcatch(e)\n\t{\n\t}\t\t\t\t\n   }\n   */\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\n\t<script>\t\t\n\t\t\tfunction ChkNumberInput1(fld, e, deci,sn)\n\t\t\t{\n\t\t\t\tvar strCheck =\"\";\n\t\t\t\tif(document.forms[0].billpayableamt.value < 0)\n\t\t\t\t{\n\t\t\t\t\tif (parseInt(deci)>0)\n\t\t\t\t\t\tstrCheck = \'-.0123456789\';\n\t\t\t\t\telse\n\t\t\t\t\t\tstrCheck = \'-0123456789\';\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif (parseInt(deci)>0)\n\t\t\t\t\t\tstrCheck = \'.0123456789\';\n\t\t\t\t\telse\n\t\t\t\t\t\tstrCheck = \'0123456789\';\t\n\t\t\t\t}\n\t\t\t\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\t\t\t\tif (whichCode == 13) return true;  // Enter\n\t\t\t\t\n\t\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\n\t\t\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\t\t\tif(key == \".\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'.\' char\n\t\t\t\tif(key == \"-\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'-\' char\n\t\t\t}\n/*\t\t\tfunction checkslmtamt()\n\t\t\t{\n\t\t\t\tvar v_billslmtamt = \"\";\t\t\t\n\t\t\t\tvar v_billpayableamt = \"\";\n\n\t\t\t\tv_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\n\t\t\t\tv_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;\t\t\t\n\n\t\t\t\tif ( parseFloat(v_billslmtamt) > parseFloat(v_billpayableamt))\n\t\t\t\t{\n//\t\t\t\t\talert(\"Allocated amount is greater than outstanding amount\");\n\t\t\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.select();\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( parseFloat(v_billslmtamt) < 0 )\n\t\t\t\t{\n//\t\t\t\t\talert(\" Refund cannot be allowed\");\n\t\t\t\t\talert(getMessage(\"BL9536\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.select();\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( parseFloat(v_billslmtamt) == 0 || v_billslmtamt == \"\" || v_billslmtamt == null )\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].slmttype.value = \"\";\n\t\t\t\t\tcalldfltslmt(\"\");\t\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction billslmtprocess()\n\t\t\t{\t\n\t\t\t\tvar v_slmttype\t\t= \"\";\n\t\t\t\tvar v_cashslmtflag\t= \"\";\n\t\t\t\tvar v_instref\t\t= \"\";\n\t\t\t\tvar v_instdate\t\t= \"\";\n\t\t\t\tvar v_instremark\t= \"\";\n\t\t\t\tvar v_slmtidno\t\t= \"\";\n\t\t\t\tvar v_slmtpayername = \"\";\n\t\t\t\tvar v_billslmtamt = \"\";\t\n\t\t\t\tvar v_slmtapprrefno = \"\";\n\n\t\t\t\tvar v_rectype =\"\";\n\t\t\t\tvar v_ext_acc_facility_id = \"\";\n\t\t\t\tvar v_ext_acc_code = \"\";\n\t\t\t\tvar v_ext_acc_dept = \"\";\n\t\t\t\tvar v_online_approval = \"\";\n\t\t\t\tvar v_batch_no = \"\";\n\t\t\t\tvar v_sale_draft_no = \"\";\n\t\t\t\tvar v_ext_acc_interface_yn = \"\";\n\n\t\t\t\tv_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\n\t\t\t\tv_slmttype = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\t\t\t\n\n\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\n\t\t\t\t\n\t\t\t\tif (v_billslmtamt == null ) v_billslmtamt =\"\";\n\t\t\t\tif (v_slmttype == null ) v_slmttype = \"\";\n\t\n\t\t\t\tif (v_slmttype == \"\" && parseFloat(v_billslmtamt) > 0)\n\t\t\t\t{\t\n//\t\t\t\t\talert( \"Settlement Type cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9521\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_slmttype != \"\" && parseFloat(v_billslmtamt) == 0)\n\t\t\t\t{\t\n//\t\t\t\t\talert( \"Settlement Type cannot be selected for Zero amount\");\n\t\t\t\t\talert(getMessage(\"BL9522\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\n\n\t\t\t\tif (v_slmttype != \"\" &&  v_billslmtamt ==\"\" )\n\t\t\t\t{\t\n//\t\t\t\t\talert( \"Settlement Amount cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tvar str = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\t\n\t\t\t\tv_cashslmtflag =str.charAt(2);\t\t\n\t\t\t\t\n\t\t\t\tif (v_slmttype != \"\")\n\t\t\t\t{\n\t\t\t\t\tv_ext_acc_interface_yn = parent.frames[1].document.forms[0].ext_acc_interface_yn.value;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif (v_ext_acc_interface_yn == \"Y\" && v_slmttype != \"\")\n\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tv_rectype = parent.frames[1].document.forms[0].rectype.value;\n\t\t\t\t\tv_ext_acc_facility_id = parent.frames[1].document.forms[0].ext_acc_fac_id.value;\n\t\t\t\t\tv_ext_acc_code = parent.frames[1].document.forms[0].acccode.value;\n\t\t\t\t\tv_ext_acc_dept = parent.frames[1].document.forms[0].dept.value;\n\t\t\t\t\t\n\t\t\t\t\tif ( v_rectype == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Receipt Type cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9524\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].rectype.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t\tif ( v_ext_acc_code == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Account code cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9525\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].acccode.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t\tif ( v_ext_acc_dept == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Accounting department cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9526\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].dept.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\n\t\t\t\tif (v_cashslmtflag != \"Y\" && v_slmttype != \"\")\n\t\t\t\t{\n\t\t\t\t\t\tv_instref = parent.frames[1].document.forms[0].instref.value;\n\t\t\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value;\n\t\t\t\t\t\tv_instremark = parent.frames[1].document.forms[0].instremark.value;\n\t\t\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\t\t\t\tif (parent.frames[1].document.forms[0].onlineapproval.checked)\n\t\t\t\t\t\t\tv_online_approval = \'Y\';\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tv_online_approval = \'N\';\n\n\t\t\t\t\t\tv_batch_no = parent.frames[1].document.forms[0].batchno.value;\n\t\t\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;\n\n\t\t\t\t\t\tif ( v_instref == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Instrument Ref cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9527\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif ( v_instdate == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Instrument Date cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9528\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif (v_instremark == \"\" && (v_cashslmtflag == \"A\" || v_cashslmtflag == \"B\"))\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Bank/Card Co. Name cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9529\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].instremark.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif (v_slmtapprrefno == \"\" && v_cashslmtflag == \"A\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Approval code cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9531\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].apprrefno.focus();\n\t\t\t\t\t\t\treturn false;\t\t\t\t\t\t\n\t\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Payer\'s name cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername != \"\" && v_slmtidno == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Payer\'s Ref Id cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"Y\" && v_batch_no == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Batch No cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9530\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"N\" && v_batch_no != \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Online Approved credit card transaction can only have batch number\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9534\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"A\" && v_sale_draft_no == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Sale Draft No cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9535\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].saledraftno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tif (v_cashslmtflag == \"Y\" && v_slmttype != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t\n\t\t\t\t    \n\t\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[2].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&billdocnum=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&billpayableamt=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&facilityid=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&user=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&patientid=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&episodetype=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&episodeid=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&visitid=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&slmtamt=\'+v_billslmtamt+\'&slmttypecode=\'+v_slmttype.substring(0,2)+\'&slmtdocref=\'+v_instref+\'&slmtdocrefdate=\'+v_instdate+\'&slmtdocrefremark=\'+v_instremark+\'&slmtidno=\'+v_slmtidno+\'&slmtpayername=\'+v_slmtpayername+\'&slmtapprrefno=\'+v_slmtapprrefno+\'&onlineapproval=\'+v_online_approval+\'&batchno=\'+v_batch_no+\'&saledraftno=\'+v_sale_draft_no+\'&rectype=\'+v_rectype+\'&extaccfacid=\'+v_ext_acc_facility_id+\'&extacccode=\'+v_ext_acc_code+\'&extaccdept=\'+v_ext_acc_dept; \n\t\t\t\t\t\n\t\t\t}\n\n\t\t\tfunction billslmtprocessclose()\n\t\t\t{\t\t\t\t\n\n\t\t\tif ( parent.frames[0].document.forms[0].pagecloseind.value != \"1\" )\n\t\t\t\t{\t\n\t\t\t\t\n\t\t\t\tparent.frames[2].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'; \t\t\t\t\n\n\t\t\t\t/*\n\t\t\t\tvar dialogHeight\t= \"1\" ;\n\t\t\t\tvar dialogWidth\t\t= \"1\" ;\n\t\t\t\tvar dialogTop\t\t= \"1\";\n\t\t\t\tvar center\t\t\t= \"1\";\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar features\t\t= \"dialogHeight:\"  + dialogHeight + \n\t\t\t\t\t\t\t\t\t  \"; dialogWidth:\" + dialogWidth + \t\n\t\t\t\t\t\t\t\t\t  \"; center: \"\t   + center + \n\t\t\t\t\t\t\t\t\t  \"; status: \"\t   + status\t+ \n\t\t\t\t\t\t\t\t\t  \"; dialogTop :\"  + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tvar retVal = \t\t\twindow.showModalDialog(\'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',arguments,features); \n\t\t\t\t*/\n\n/*\t\t\t\treturn;\t\t\t\n\n\t\t\t\t}\t\t\t\n\t\t\t}\n\n\n\n\t\t\tfunction calldfltslmt(val)\n\t\t\t{\n\t\t\t\tvar str = val;\n\t\t\t\tvar obj=str.substring(0,2);\n\t\t\t\tvar v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tif (obj.charAt(2) != \"Y\" && obj != \"\" && v_billslmtamt != \"\")\n\t\t\t\t{\t\t\t\tparent.frames[1].location.href=\'../../eBL/jsp/BLBillSlmtType.jsp?slmttype=\'+obj+\'&slmtidno=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&slmtpayername=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&billdoctypecode=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t}\t\n\n\t\t\t\tif ( v_billslmtamt == \"\" && str != \"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.value = \"\";\n//\t\t\t\t\talert(\"Settlement Amount cannot be blank\");\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\t\t\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\n\t\t\t\t}\n\n\t\t\tfunction callslmt(Obj)\n\t\t\t{\n\t\t\t\tvar str = Obj.value;\n\t\t\t\tvar obj=str.substring(0,2);\n\t\t\t\tvar v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tif (obj.charAt(2) != \"Y\" && obj != \"\" && v_billslmtamt != \"\")\n\t\t\t\t{\t\t\t\tparent.frames[1].location.href=\'../../eBL/jsp/BLBillSlmtType.jsp?slmttype=\'+obj+\'&slmtidno=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t}\t\n\n\t\t\t\tif ( v_billslmtamt == \"\" && str != \"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.value = \"\";\n//\t\t\t\t\talert(\"Settlement Amount cannot be blank\");\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\t\t\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\n\t\t}*/\n\tfunction putdeci(object)\n\t{\t\t\n\t\t\n\t\tif(object.value!=\'\')\n\t\t{\n\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\tputDecimal(object,17,decimal);\n\t\t}\n\t\t\n\t\t\n\t}\n\nfunction funServiceDet()\n{\n\t\n\tvar query_string=document.forms[0].query_string.value;\n\tvar amt_sett=document.forms[0].billslmtamtdet.value;\n\tvar pay_amt=document.forms[0].billpayableamt.value;\n\tvar remOutStndAmt = parseFloat(pay_amt)-parseFloat(amt_sett);\n\tvar custId = document.forms[0].custId.value;\n\tvar sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;\t\t\n//\tvar slmt_amt_disabled_YN = parent.frames[3].document.forms[0].slmt_amt_disabled_YN.value;\n\t\tvar slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;\n\tif(pay_amt < 0)\n\t{\n\t\tvar temp=amt_sett.indexOf(\'-\');\n\t\tif(temp != -1 ) \n\t\t{\n\t\t\tif(temp != 0 ) \n\t\t\t{\t\t\t\t\n\t\t\t\talert(getMessage(\"INVALID_NUMBER_FORMAT\",\"common\"));\n\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\t\n\tif(pay_amt>0 && amt_sett<0)\n\t{\n\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\tdocument.forms[0].billslmtamtdet.select();\t\n\t\treturn false;\n\t}\n\tif(pay_amt<0 && amt_sett>0)\n\t{\n\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\tdocument.forms[0].billslmtamtdet.select();\t\n\t\treturn false;\n\t}\n\t\t\n\t\tif(amt_sett!=\"\")\n\t\t{\n\t\t\tif(sett_amt!=0)\n\t\t\t{\n\t\t\t\tif(parseFloat(amt_sett)<parseFloat(sett_amt) || parseFloat(amt_sett)>parseFloat(sett_amt))\n\t\t\t\t{\n\t\t\t\t\t alert(getMessage(\"BL9782\",\"BL\"));\n//\t\t\t\t\t document.forms[0].billslmtamtdet.select();\n//\t\t\t\t\t return false;\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t\tvar out_standing_amt=document.forms[0].billpayableamt.value;\n\t\t\tif(amt_sett<0)\n\t\t\t{\t\t\t\t\n\t\t\t\n\t\t\t//if(parseFloat(amt_sett)>parseFloat(out_standing_amt))\n\t\t\tif(parseFloat(out_standing_amt)>parseFloat(amt_sett))\n\n\t\t\t{\t\t\t\n\t\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\tif(amt_sett>0)\n\t\t\t{\n\t\t\t\n\t\t\tif(parseFloat(amt_sett)>parseFloat(out_standing_amt))\n\n\t\t\t{\t\t\t\n\t\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\t\tif(custId == \'MOHBR\'){\t\n\t\t\t\t\tif(amt_sett!=\'\'){\n\t\t\t\t\t\t\tvar remamt = document.forms[0].remOutStndAmt.value;\n\t\t\t\t\t\t\tvar ttamt=\"0.0\";\n\t\t\t\t\t\t\t if(remamt!=\'\' )\n\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t var blamtt = document.forms[0].billslmtamtdet.value;\n\t\t\t\t\t\t\t\t var ttamt = parseFloat(blamtt) + parseFloat(remamt);\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t  }\n\t\t\t\t\t\tif(parseFloat(pay_amt)>0){\n\t\t\t\t\t\t\tif(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(amt_sett)<parseFloat(pay_amt)){\n\t\t\t\t\t\t\t\tvar resp = confirm(\"Partial settlement being processed \\n  Do you want to continue? \");\n\t\t\t\t\t\t\t\tif(resp == true){\n\t\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = remOutStndAmt;\n\t\t\t\t\t\t\t\t\tputdeci(document.forms[0].remOutStndAmt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.value = pay_amt;\n\t\t\t\t\t\t\t\t\tputdeci(document.forms[0].billslmtamtdet);\n\t\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = \'0.0\';\n\t\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = remOutStndAmt;\n\t\t\t\t\t\t\t\tputdeci(document.forms[0].remOutStndAmt)\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tif(parseFloat(ttamt) !=  parseFloat(pay_amt) && parseFloat(pay_amt)<parseFloat(amt_sett)){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.value = pay_amt;\n\t\t\t\t\t\t\t\tputdeci(document.forms[0].billslmtamtdet);\n\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = \'0.0\';\n\t\t\t\t\t\t\t\tdocument.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\t\t\treturn false;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = remOutStndAmt;\n\t\t\t\t\t\t\t\tputdeci(document.forms[0].remOutStndAmt)\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tdocument.forms[0].remOutStndAmt.value = \'\';\n\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\tdocument.forms[0].service_check.value=\'Y\';\n\t\t//document.forms[0].submit();\n\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLBillSlmtService.jsp?\"+query_string+\"&slmt_amt_disabled_YN=\"+slmt_amt_disabled_YN;\n}\n\nfunction funServiceDet_onLoad()\n{\n\tvar query_string=document.forms[0].query_string.value;\n\tvar slmt_amt_disabled_YN = document.forms[0].slmt_amt_disabled_YN.value;\n\tvar amt_sett=document.forms[0].billslmtamtdet.value;\n//\t\tvar sett_amt=parent.frames[3].document.forms[0].total_settled_amt.value;\t\n\t\t\n\t\tif(amt_sett!=\"\")\n\t\t{\n/*\n\t\tif(parseFloat(amt_sett)<parseFloat(sett_amt))\n\t\t{\n\t\t\t alert(getMessage(\"BL9759\",\"BL\"));\n\t\t\t document.forms[0].billslmtamtdet.select();\n\t\t\t return false;\n\t\t}\n*/\t\t\n\t\tvar out_standing_amt=document.forms[0].billpayableamt.value;\n\t\tif(parseFloat(amt_sett)>parseFloat(out_standing_amt))\n\t\t{\t\t\t\n\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t document.forms[0].billslmtamtdet.select();\n\t\t\t return false;\n\n\t\t}\n\t\t}\n\tdocument.forms[0].service_check.value=\'Y\';\n\t//document.forms[0].submit();\n\tparent.frames[1].location.href=\"../../eBL/jsp/BLBillSlmtService.jsp?\"+query_string+\"&slmt_amt_disabled_YN=\"+slmt_amt_disabled_YN;\n\t\n}\n\n\nfunction rectypelkup()\n\t\t{\n\t\tvar msg=\"\";\n\t\tvar target\t\t\t\t= document.forms[0].rectype;\n\t\tvar retVal\t\t\t\t= new String();\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"40\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar tit\t\t\t\t\t= \"\";\n\t\t//Below line (v_facility_id) is added by muthu against IN:032615 on 10-5-12\n\t\tvar v_facility_id =document.forms[0].strfacilityid.value;// \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\n\t\tvar v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\tvar\tv_single_serv_grp = document.forms[0].str_single_service_grp_yn.value;//\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\t\t\n\t\tvar v_acc_episode_type = document.forms[0].str_acc_episode_type.value;//\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\t\n\t\tvar v_acc_catg_code = document.forms[0].str_acc_category_code.value;//\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\t\t\n\t\tvar v_acc_serv_grp_used_yn = document.forms[0].str_acc_serv_grp_used_yn.value;//\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\t\t\n\t\tvar v_serv_grp = document.forms[0].str_service_grp.value;//\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\';\t\t\n\t\tvar v_episode_type =document.forms[0].str_episode_type.value;// \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\t\t\n\t\tvar v_reln_code =document.forms[0].str_reln_code.value;//\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\n\n\t\tvar locale = document.forms[0].locale.value;\n\t\t\n\n// PE Changes\t\t\t\n//\t\tsql = \"select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`\"+locale+\"` and recpt_nature_code = `BI` and status is null and (( `\"+v_ext_acc_interface_yn+\"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`\"+v_single_serv_grp+\"`=`Y` and episode_type in (`\"+v_acc_episode_type+\"`,`U`) and category in (`UNRESTRICTED`,`\"+v_acc_catg_code+\"`) and ((`\"+v_acc_serv_grp_used_yn+\"` = `Y` and blng_serv_grp = `\"+v_serv_grp+\"`) or (`\"+v_acc_serv_grp_used_yn+\"` = `N` and  blng_serv_grp is null ))) or (`\"+v_single_serv_grp+\"`=`N` and episode_type in (`U`,`\"+v_episode_type+\"`) and category IN ( `\"+v_reln_code+\"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `\"+v_ext_acc_interface_yn+\"` = `N`    )\";\t\n\n\t\tsql = \"select receipt_type_code, long_desc from bl_receipt_type_lang_vw where language_id=`\"+locale+\"` and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id=`\"+v_facility_id+\"`) and recpt_nature_code = `BI` and status is null and (( `\"+v_ext_acc_interface_yn+\"` = `Y` and  receipt_type_code in ( select receipt_type_code from bl_rev_acct_by_receipt_type where rcpt_nature_code = `BI` and status is null and ((`\"+v_single_serv_grp+\"`=`Y` and episode_type in (`\"+v_acc_episode_type+\"`,`U`) and category in (`UNRESTRICTED`,`\"+v_acc_catg_code+\"`) and ((`\"+v_acc_serv_grp_used_yn+\"` = `Y` and blng_serv_grp = `\"+v_serv_grp+\"`) or (`\"+v_acc_serv_grp_used_yn+\"` = `N` and  blng_serv_grp is null ))) or (`\"+v_single_serv_grp+\"`=`N` and episode_type in (`U`,`\"+v_episode_type+\"`) and category IN ( `\"+v_reln_code+\"`,`UNRESTRICTED`) and blng_serv_grp is null )))) or `\"+v_ext_acc_interface_yn+\"` = `N`)\";\t\t\t\n\n\t\tsearch_code=\"receipt_type_code\";\n\t\tsearch_desc=\"long_desc\";\n//\t\ttit=\"Receipt Types\"; \n\t\ttit=encodeURIComponent(getLabel(\"eBL.RECEIPT_TYPE.label\",\"BL\"));\n\t\t//tit=getLabel(\"eBL.RECEIPT_TYPE.label\",\"BL\");\t\t\n\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\t\tvar arr=new Array();\n\t\t//alert(\"retVal\" +retVal);\n\t\tif (!(retVal == null))\n\t\t{\n  \t\t    var retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\n\t\t\n\t\t\tdocument.forms[0].rectypedesc.value=arr[0];\n\t\t    document.forms[0].rectype.value=arr[1];\n\t\t\t\n\t\t\tdocument.forms[0].acccode.value=\'\';\n\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\n\t\t\tdocument.forms[0].dept.value=\'\';\n\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\n\t\t\tdocument.forms[0].rectypedesc.value=\'\';\n\t\t\tdocument.forms[0].rectype.value = \'\';\t\t\t\t\t\t\n\n\t\t\tdocument.forms[0].acccode.value=\'\';\n\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\n\t\t\tdocument.forms[0].dept.value=\'\';\n\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\n\t\t\ttarget.focus();\n\t\t}\n\t\n\n\t}\n\nfunction acccodelkup()\n\t\t{\n\t\tvar msg=\"\";\n\t\tvar target\t\t\t\t= document.forms[0].acccode;\n\t\tvar retVal\t\t\t\t= new String();\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"40\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar tit\t\t\t\t\t= \"\";\n\t\t\n\t\tvar v_ext_acc_interface_yn = document.forms[0].ext_acc_interface_yn.value;//\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\tvar v_acc_catg_code = document.forms[0].str_acc_category_code.value;//\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\t\t\n\t\tvar v_rec_type = document.forms[0].rectype.value;\t\t\n\t\tvar locale = document.forms[0].locale.value;\n\n//PE Changes\t\t\n//\t\tsql = \"\tselect distinct a.account_code, b.long_desc from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`\"+locale+\"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code  and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `\"+v_rec_type+\"` and a.status is null and ((`\"+v_single_serv_grp+\"`=`Y` and a.episode_type in (`U`, `\"+v_acc_episode_type+\"`) and a.category in (`UNRESTRICTED`,`\"+v_acc_catg_code+\"` ) and ((`\"+v_acc_serv_grp_used_yn+\"` = `Y` and a.blng_serv_grp = `\"+v_serv_grp+\"`) or (`\"+v_acc_serv_grp_used_yn+\"` = `N` and  a.blng_serv_grp is null ))) or (`\"+v_single_serv_grp+\"`=`N` and a.episode_type in (`U`, `\"+v_episode_type+\"`) and a.category IN ( `\"+v_reln_code+\"`,`UNRESTRICTED`) and a.blng_serv_grp is null ))\";\t\n\n\t/*Commented by MuthuN against showing the Account code for National and Unrestricted on 06-06-12 & Updated Query is given below\n\t\t\tsql = \"select distinct a.account_code, b.long_desc from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`\"+locale+\"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code and a.acc_entity_code = b.acc_entity_code and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `\"+v_rec_type+\"` and a.status is null and ((`\"+v_single_serv_grp+\"`=`Y` and a.episode_type in (`U`, `\"+v_acc_episode_type+\"`) and a.category in (`UNRESTRICTED`,`\"+v_acc_catg_code+\"` ) and ((`\"+v_acc_serv_grp_used_yn+\"` = `Y` and a.blng_serv_grp = `\"+v_serv_grp+\"`) or (`\"+v_acc_serv_grp_used_yn+\"` = `N` and  a.blng_serv_grp is null ))) or (`\"+v_single_serv_grp+\"`=`N` and a.episode_type in (`U`,`\"+v_episode_type+\"`) and a.category IN ( `\"+v_reln_code+\"`,`UNRESTRICTED`) and a.blng_serv_grp is null ))\";*/\n\n\tsql = \"select account_code,long_desc from (select a.account_code, b.long_desc , decode(a.episode_type, `\"+v_acc_episode_type+\"`,`1`,`999`) order1, decode(a.category,`\"+v_acc_catg_code+\"`\t,1,999) order2 from bl_rev_acct_by_receipt_type a,bl_receipt_type_lang_vw b where b.language_id=`\"+locale+\"` and  a.rcpt_nature_code = b.recpt_nature_code and a.receipt_type_code = b.receipt_type_code and a.acc_entity_code = b.acc_entity_code and b.recpt_nature_code = `BI` and  a.rcpt_nature_code = `BI` and a.receipt_type_code = `\"+v_rec_type+\"` and a.status is null and a.episode_type in (`U`, `\"+v_acc_episode_type+\"`) and a.category in(`UNRESTRICTED`,`\"+v_acc_catg_code+\"`) order by 3,4 ) where rownum=1\";\n\n\t\t\tsearch_code=\"account_code\"; \n\t\t\tsearch_desc=\"long_desc\";\n\t\t\t\n\t\t\t//search_code=\"a.account_code\"; - Commented by Muthukumar on 6-6-12 against Account_code\n\t\t\t//search_desc=\"along_desc\"; - Commented by Muthukumar on 6-6-12 against Account_code\n//\t\ttit=\"Account Codes\"; \n\t\ttit=encodeURIComponent(getLabel(\"eBL.ACCOUNT_CODE.label\",\"BL\"));\n\t\t//tit=getLabel(\"eBL.ACCOUNT_CODE.label\",\"BL\");\n\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\t\tvar arr=new Array();\n\n\t\tif (!(retVal == null))\n\t\t{\n  \t\t    var retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\n\t\t\n\t\t\tdocument.forms[0].acccodedesc.value=arr[0];\n\t\t    document.forms[0].acccode.value=arr[1];\n\t\t\tdocument.forms[0].acccode.focus();\t\t\t\t\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\n\t\t\tdocument.forms[0].acccodedesc.value=\'\';\n\t\t\tdocument.forms[0].acccode.value = \'\';\t\t\t\t\t\t\t\t\t\n\n\t\t\ttarget.focus();\n\t\t}\n\t}\n\tfunction deptlkup()\n\t{\n\t\tvar msg=\"\";\n\t\tvar target\t\t\t\t= document.forms[0].dept;\n\t\tvar retVal\t\t\t\t= new String();\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"40\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar tit\t\t\t\t\t= \"\";\t\t\n\t\tvar v_dept_code =document.forms[0].str_ext_dept_code.value;//\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\t\tvar v_facility_id =document.forms[0].strfacilityid.value;// \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\tvar locale = document.forms[0].locale.value;\t\t\n\t\tsql = \"\tselect dept_code, long_desc from am_dept_lang_vw where language_id=`\"+locale+\"` and dept_code like nvl(`\"+v_dept_code+\"`,dept_code )\";\n\t\tsearch_code=\"dept_code\";\n\t\tsearch_desc=\"long_desc\";\n//\t\ttit=\"Accounting Departments\"; \n\t\ttit=encodeURIComponent(getLabel(\"eBL.ACCOUNTING_DEPT.label\",\"BL\"));\n\t\t//tit=getLabel(\"eBL.ACCOUNTING_DEPT.label\",\"BL\");\t\t\n\t\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\t\tvar arr=new Array();\n\t\tif (!(retVal == null))\n\t\t{\n  \t\t    var retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\t\t\n\t\t\tdocument.forms[0].deptdesc.value=arr[0];\n\t\t    document.forms[0].dept.value=arr[1];\n\t\t\tdocument.forms[0].dept.focus();\t\t\n\t\t}\n\t\telse\n\t\t{\t\t\t\t\n\t\t\tdocument.forms[0].deptdesc.value=\'\';\n\t\t\tdocument.forms[0].dept.value = \'\';\t\t\t\t\t\t\n\t\t\ttarget.focus();\n\t\t}\n\t\n\n\t}\t\nfunction funCurStlmt()\n{ \n\tvar total_records=document.forms[0].total_records.value;\n\tvar v_tot_curr_stlmt=document.forms[0].tot_curr_stlmt.value;\n\n\t\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar pend_amt=eval(\"document.forms[0].pend_set\"+j);\n\t\tvar curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\tif(curr_set.value==\"\")\n\t\t{\n\t\t\tcurr_set.value=0.00;\n\t\t\tputdeci(curr_set);\n\t\t\t//curr_set.focus();\n\t\t\tcurr_set.select();\n\t\t\treturn false;\n\t\t}\n\n\n\t\tif ( parseFloat(curr_set.value) > parseFloat(pend_amt.value))\n\t\t{\n\t\t\t alert(getMessage(\"BL9658\",\"BL\"));\n\t\t\t//alert(\"Current Settlements should not be greater then Pending Settlements\");\n\t\t\t//curr_set.value=\"\";\t\t\n\t\t\tcurr_set.select();\n\t\t}\n\t\ttotCurrSlmt();\n\t\t\n\t\t\n\t\n\tif(parseFloat(curr_set.value) >parseFloat(v_tot_curr_stlmt))\n\t\t{\n\t\t//alert(\'Testing 1\');\n\t\t\talert(getMessage(\"BL9621\",\"BL\"));\n\t\t\tcurr_set.value=0.00;\n\t\t\tputdeci(curr_set);\n\t\t\t//curr_set.focus();\n\t\t\tcurr_set.select();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\n\t/*var settled_amt_det=document.forms[0].billslmtamtdet.value;\n\tvar a1=new Array();\n\tvar total=0.0;\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar v_curr_set=eval(\"document.forms[0].curr_set\"+j);\t\n\t\ta1[j]=v_curr_set.value;\n\t\ttotal=parseFloat(total)+parseFloat(a1[j]);\n\t\talert(\"total :\"+total);\n\n\t\tif(parseFloat(total)!=parseFloat(settled_amt_det))\n\t\t\t{\n\t\talert(\"Allocated Amt Must Be Equal To Settled Amt\");\n\t\t//v_curr_set.focus();\n\t\treturn false;\n\t}\n\t}*/\n\n\n\n\nfunction funCurrMultSlmt()\n\t\t{\n\t      var s_amt=document.forms[0].billslmtamtdet.value;\t\t  \n\t\t  var total_records=document.forms[0].total_records.value;\t\n\t\t  if(total_records>0)\n\t\t\t{\n\t\t  for(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t  var pend_amt=eval(\"document.forms[0].pend_set\"+j);\t\t\t  \n\t\t\t  var v_pend_amt=pend_amt.value;\n\t\t\t  var curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\t\t  if(parseFloat(s_amt)> parseFloat(pend_amt.value))\n\t\t\t\t{\t\t\t\t  \t\t \n\t\t\t\t  curr_set.value=v_pend_amt;\t\t\t\t  \n\t\t\t\t  putdeci(curr_set);\n\t\t\t\t}\n\t\t\t\telse{\t\t\t\t\t\n\t\t\t\t\tif(parseFloat(s_amt)>0)\n\t\t\t\t\t{\t\t\t\t\t \n\t\t\t\t\t curr_set.value=s_amt;\n\t\t\t\t\t putdeci(curr_set);\n\t\t\t\t\t}\n\t\t\t\t\telse{curr_set.value=0;\n\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t}\n\n\t\t\t\t }\n\t\t\t\ts_amt=parseFloat(s_amt)-parseFloat(v_pend_amt);\t\t\t\t\t\n\n\t\t\ttotCurrSlmt();\n\t\t\t}\n\t\t\t}\n\t\t}\n\n\tfunction totCurrSlmt()\n\t\t{\n\t\t\tvar tot_curr_set=0.0;\n\t\t\tvar v_curr_set=\"\";\n\t\t\tvar a1=new Array();\n\t\t\tvar s_amt=document.forms[0].billslmtamtdet.value;\n\t\t\tvar total_records=document.forms[0].total_records.value;\t\t  \n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tv_curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\t\t\ta1[j]=v_curr_set.value;\n\t\t\t\t if(a1[j]==\"\"){a1[j]=\"0.0\";}\n\t\t\t\ttot_curr_set=parseFloat(tot_curr_set) + parseFloat(a1[j]);\n\t\t\t\t\n\t\t\t}\n\t\t\tdocument.forms[0].tot_curr_stlmt.value=tot_curr_set;\n\t\t\tvar total_curr_stlmt=eval(\"document.forms[0].tot_curr_stlmt\");\n\t\t\tputdeci(total_curr_stlmt);\n\t\t\t\n\t\t}\n\n\tfunction slmt_amt_disabled_YN()\n\t{\n\t\tvar alw_co_wit_bl_slmt_yn=document.forms[0].alw_co_wit_bl_slmt_yn.value;\n\t\tvar called_frm=document.forms[0].called_frm.value;\n\t\tvar str_episode_type=document.forms[0].episode_type.value;\n\t\tvar slmt_amt_disabled_YN=document.forms[0].slmt_amt_disabled_YN.value;\n\n\t\tif(alw_co_wit_bl_slmt_yn == \"Y\" && called_frm==\"CHECKOUT_VISIT\" && str_episode_type == \"E\")\n\t\t{\n\t\t\tdocument.forms[0].billslmtamtdet.disabled=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(slmt_amt_disabled_YN==\"Y\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].billslmtamtdet.disabled=true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].billslmtamtdet.disabled=false;\n\t\t\t}\n\t\t}\n\t}\n\t\n\t//Added for KDAH-CRF-0318\n\tfunction fnDispBillTaxDesc(){\n\t\tvar billLevelTax = document.BillSlmtDetForm.billLevelTax.value;\n\t\tvar addlChargeAmt = document.BillSlmtDetForm.addlChargeAmtForBill.value;\n\t\tif(addlChargeAmt == \'\'){\n\t\t\taddlChargeAmt = 0;\n\t\t}\n\t\tif(billLevelTax == \'Y\' && addlChargeAmt > 0){\n\t\t\tdocument.getElementById(\'billLevelTaxDesc\').innerText = \'(Including Bill level Tax)\';\n\t\t\tdocument.getElementById(\'billLevelTaxDesc\').style.display = \'inline\';\t\t\t\n\t\t}\n\t}\n\t</script>\t  \n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" <script> \n\t\t\t\tvar v_error_text = \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\t\t\t\t\t\n\t\t\t\tif ( v_error_text != \'\')\n\t\t\t    {\n\t\t\t\t\t\talert(v_error_text);\n\n\t\t\t\t\t\t//return false;\n\t\t\t\t\t\t//window.close();\t\n\t\t\t\t}\n\t\t\t\t</script>  \n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n</HEAD>\n\n\t<BODY onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" onload=\'slmt_amt_disabled_YN();funServiceDet_onLoad();fnDispBillTaxDesc();\' >\t\n\t<FORM name=\'BillSlmtDetForm\' id=\'BillSlmtDetForm\' method=\'post\'  action=\'\'  scrolling=\'NO\' >\n<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\t \n\t\t<tr><td class=\'columnHeader\' colspan=\'16\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td></tr>\n\t\t<tr>\n<!--\t<td class=\"label\" width=\"25%\">Bill No</td>\t -->\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\t \n\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"billdoctype\" id=\"billdoctype\" SIZE=\"7\" MAXLENGTH=\"10\" \t\t\t\tVALUE=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  style=\'text-align:left\' READONLY> / <INPUT TYPE=\"TEXT\" \n\t\t name=\"billdocnum\" id=\"billdocnum\" SIZE=\"8\" MAXLENGTH=\"10\"  VALUE=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' style=\'text-align:right\' READONLY></td>\n\t\n<!--\t<td class=\"label\" width=\"25%\">Payable Amount</td>\t-->\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" &nbsp;<span style=\'display: none;font-size: 9px;\' id=\'billLevelTaxDesc\' name=\'billLevelTaxDesc\'></span></td>\t\n<!--\n\t\t<td>&nbsp;<INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"8\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'  style=\'text-align:right\'>&nbsp;<INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"  OK  \" onClick=\'billslmtprocess()\'><td> \t-->\t\n\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'  style=\'text-align:right\'>&nbsp;</td> \n<!--Added by Muthu on 9/5/12 against against JD-0008 Starts here -->\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\" name=\"drugpenality\" id=\"drugpenality\" SIZE=\"15\" MAXLENGTH=\"20\" VALUE=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'  style=\'text-align:right\' readOnly/> </td>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n<!--Added by Muthu on 9/5/12 against against JD-0008 Ends here -->\n\t\t</tr>\n\t\t<tr>\n<!--added here by ram-->\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\n\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\"rectype\" id=\"rectype\" maxlength=\'3\' size=\'3\'  tabindex=\'1\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'><input type=\'button\' class=\'button\' name=\"rectypebut\" id=\"rectypebut\" value=\'?\' onClick=\"return rectypelkup()\" tabindex=\'2\'>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t<input type= hidden name=\"rectypedesc\" id=\"rectypedesc\"  value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\t\n\t\t\t\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\t\n\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\"acccode\" id=\"acccode\" maxlength=\'10\' size=\'10\'  tabindex=\'3\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'><input type=\'button\' class=\'button\' name=\"acccodebut\" id=\"acccodebut\" value=\'?\' onClick=\"return acccodelkup()\"  tabindex=\'4\'><img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;</td>\n\t\t<input type= hidden name=\"acccodedesc\" id=\"acccodedesc\"  value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\t\n\t\t<!-- <td class=\"fields\" width=\"25%\">\n\t\t<td class=\"fields\" width=\"25%\"> -->\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' readonly name=\"dept\" id=\"dept\" maxlength=\'6\' size=\'6\'  tabindex=\'5\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'><input type=\'button\' class=\'button\' name=\"deptbut\" id=\"deptbut\" value=\'?\' onClick=\"return deptlkup()\" tabindex=\'6\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t<input type= hidden name=\"deptdesc\" id=\"deptdesc\"  value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\t\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\n\t\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\" name=\"billslmtamtdet\" id=\"billslmtamtdet\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,2,1))\' onBlur=\'putdeci(this);funServiceDet()\'> </td>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t\n\t\t\t\t\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\" readonly name=\"remOutStndAmt\" id=\"remOutStndAmt\" SIZE=\"14\" MAXLENGTH=\"10\" \tVALUE=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\' onBlur=\'putdeci(this);funServiceDet()\'> </td>\n\t\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\" name=\"billslmtamtdet\" id=\"billslmtamtdet\" SIZE=\"14\" MAXLENGTH=\"10\" \tVALUE=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\' onBlur=\'putdeci(this);funServiceDet()\'> </td>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\n\t\t\t<td width=\"25%\" class=\"fields\"><INPUT TYPE=\"TEXT\" readonly name=\"remOutStndAmt\" id=\"remOutStndAmt\" SIZE=\"14\" MAXLENGTH=\"10\" \tVALUE=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\' onBlur=\'putdeci(this);funServiceDet()\'> </td>\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t<td width=\"25%\">&nbsp;</td>\t\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\t\n<!--here end-->\n\t</tr>\n\t<tr>\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t<td width=\"25%\" class=\"fields\" colspan=\'3\'><input type=\'checkbox\' name=\'recievedthrumail\' id=\'recievedthrumail\' ></td>\n\t</tr>\n\t\t<!-- <td class=\"label\"> </td> -->\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"15\" ></td>\n\t\t\t</tr>\n\t\t</table> \n\n<INPUT TYPE=\"HIDDEN\" name=\"pagecloseind\" id=\"pagecloseind\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"0\">\t\t\n<INPUT TYPE=\"HIDDEN\" name=\"dfltslmttypecode\" id=\"dfltslmttypecode\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'\' >\t \t\n<INPUT TYPE=\"HIDDEN\" name=\"slmtdate\" id=\"slmtdate\"\t   SIZE=\"20\" MAXLENGTH=\"20\" \tVALUE=\"\"> \n<INPUT TYPE=\"HIDDEN\" name=\"slmtdocrefdesc\" id=\"slmtdocrefdesc\" SIZE=\"50\" MAXLENGTH=\"100\"\tVALUE=\"\">\t\n<INPUT TYPE=\"HIDDEN\" name=\"slmtdocref\" id=\"slmtdocref\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"\">\n<INPUT TYPE=\"HIDDEN\" name=\"ext_acc_interface_yn\" id=\"ext_acc_interface_yn\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_acc_facility_id\" id=\"str_ext_acc_facility_id\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_account_code\" id=\"str_ext_account_code\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_dept_ind\" id=\"str_ext_dept_ind\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_dept_code\" id=\"str_ext_dept_code\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_single_service_grp_yn\" id=\"str_single_service_grp_yn\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_service_grp\" id=\"str_service_grp\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_acc_episode_type\" id=\"str_acc_episode_type\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\n<INPUT TYPE=\"HIDDEN\" name=\"str_acc_serv_grp_used_yn\" id=\"str_acc_serv_grp_used_yn\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\t\n<INPUT TYPE=\"HIDDEN\" name=\"str_acc_category_code\" id=\"str_acc_category_code\"  SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\t\n<INPUT TYPE=\"HIDDEN\" name=\"str_reln_code\" id=\"str_reln_code\"      SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\t\n\n<INPUT TYPE=\"HIDDEN\" name=\"str_episode_type\" id=\"str_episode_type\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"strfacilityid\" id=\"strfacilityid\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\"hidden\" name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n<input type=\"hidden\" name=\"service_check\" id=\"service_check\"  value=\'\'>\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n<input type=\'hidden\' name=\"query_string\" id=\"query_string\"  value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type=\'hidden\' name=\"strroundingamt\" id=\"strroundingamt\"  value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\n<input type=\'hidden\' name=\"slmt_amt_disabled_YN\" id=\"slmt_amt_disabled_YN\"  value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\n<input type=\'hidden\' name=\"called_frm\" id=\"called_frm\"  value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n<input type=\'hidden\' name=\"alw_co_wit_bl_slmt_yn\" id=\"alw_co_wit_bl_slmt_yn\"  value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\"  value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n<input type=\'hidden\' name=\'custId\' id=\'custId\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n<input type=\'hidden\' name=\'addlChargeAmtForBill\' id=\'addlChargeAmtForBill\' id=\'addlChargeAmtForBill\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n<input type=\'hidden\' name=\'billLevelTax\' id=\'billLevelTax\' id=\'billLevelTax\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n<input type=\'hidden\' name=\'billAlreadyPrinted\' id=\'billAlreadyPrinted\' id=\'billAlreadyPrinted\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n</FORM>\t\n\n</BODY>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

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

 	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String strclientip ="";
	strclientip=p.getProperty("client_ip_address");	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; ResultSet rs21 = null; ResultSet rscurr=null;
//	System.out.println("locale :"+locale);
//	String strdfltslmttypecode = "";
	String		ext_acc_interface_yn=""; 	String		str_receipt_type_code = "";	String		str_ext_acc_facility_id = "";
	String		str_ext_account_code	= ""; 	String		str_ext_dept_ind = "";	String		str_ext_dept_code     = "";
	String		str_single_service_grp_yn = ""; 	String		str_service_grp		= ""; 	String		str_acc_episode_type= "";
	String		str_acc_category_code	= ""; 	String		str_acc_serv_grp_used_yn	= ""; 	String		str_reln_code		= "";
	String		str_episode_type		= "";	
	String sqlStr = "";
	
	//String str_sys_message_id="";String billdoctype =  ""; 	String strrectype ="";String strbillslmtamtdet =""; 	
	//String str_part_rcpt_cntr_allowed_yn="";String str_part_rfnd_cntr_allowed_yn="";String str_part_rcpt_user_allowed_yn="";
	//String str_part_rfnd_user_allowed_yn="";
	String		str_error_text		= ""; 	String      strslmttype		=""; String		strfacilityid	=""; 	
	int noofdecimal=2;  	String strbilldoctypecode=""; 	String strbilldocnum=""; 
	String strbillpayableamt=""; double v_billpayableamt=0; 	  
	String strrectypedesc="";	 	//String stracccode ="";  	
	String stracccodedesc ="";
	//String strdept =""; 	
	String strdeptdesc =""; 	
	int total_records=0;String query_string="";	 
	String slmt_amt_disabled_YN="";	String strdfltcashbillslmtamt = "";String strslmtamt = "";String strchangereceiptamtind = "";
	String strrcptallowedyn = "",strroundingamt="";

	String called_frm="",alw_co_wit_bl_slmt_yn="N";
	String custId = BLReportIdMapper.getCustomerId();
	//KDAH-CRF-0318
	String addlChargeAmtForBill = "";
	String billLevelTax = "N";
	String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
	if(billAlreadyPrinted == null) billAlreadyPrinted="N";
 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		query_string=request.getQueryString();
		if(query_string==null || query_string.equals("")) query_string="";
//		System.out.println("query_string from det:" + query_string);
		strbilldoctypecode = request.getParameter("billdoctypecode");	
		if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";
//		System.out.println("strbilldoctypecode req:"+strbilldoctypecode);	
		strbilldocnum = request.getParameter("billdocnum");	
		if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";
		strbillpayableamt = request.getParameter("billpayableamt");	
		if(strbillpayableamt==null || strbillpayableamt.equals("")) strbillpayableamt="";
		if(!strbillpayableamt.equals(""))
		{
			v_billpayableamt=Double.parseDouble(strbillpayableamt);
		}
		strfacilityid = request.getParameter("facilityid");	
		if(strfacilityid==null || strfacilityid.equals("")) strfacilityid="";

		String strpatientid  = request.getParameter("patientid");	
		String strepisodetype = request.getParameter("episodetype");
		String strepisodeid = request.getParameter("episodeid");	
		String strvisitid = request.getParameter("visitid");	
		String strslmtpayername = request.getParameter("slmtpayername");
		String struser = request.getParameter("loggeduser");	
		String strslmtidno = request.getParameter("slmtidno");
		String strcashcounter = request.getParameter("cashcounter");
		String strrcptallowedynuser = "";
		String strchangereceiptalloweduser = "";
		//String strchangeyn	= "N";	
		strroundingamt = request.getParameter("strroundingamt");
		if ( strroundingamt == null || strroundingamt.equalsIgnoreCase("null")) 
		{strroundingamt ="";}
//		System.out.println("strroundingamt in DET" + strroundingamt);

		if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
		{strbilldoctypecode ="";}
		if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
		{strbilldocnum = "";}
		if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
		{strbillpayableamt = "";}
		if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")) 
		{strfacilityid = "";}
		if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
		{strpatientid = "";}
		if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
		{strepisodetype = "";}
		if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
		{strepisodeid = "";}
		if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";
		if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null"))  
		{strslmtpayername = "";}
		if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) strslmtidno = "";
		if ( struser == null || struser.equalsIgnoreCase("null")) struser = "";
		if ( strcashcounter == null || strcashcounter.equalsIgnoreCase("null")) 
		strcashcounter ="";

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

/* Commented and added Request Parameter from Main.jsp for PE Changes
		try
		{				
			pstmt = con.prepareStatement(" select nvl(dflt_cash_bill_slmt_amt,'N'),nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id = '" + strfacilityid + "'");
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strdfltcashbillslmtamt =  rs.getString(1);
				ext_acc_interface_yn =rs.getString("ext_acc_interface");
			}
			else
				strdfltcashbillslmtamt = "N";
				ext_acc_interface_yn = "N";
		
		rs.close();
		pstmt.close();
		}catch(Exception e) 
		{   e.printStackTrace();
			System.out.println("Exception in bl_parameters query:"+e);
		}
*/		
		strdfltcashbillslmtamt = request.getParameter("dfltcashbillslmtamt");
		if ( strdfltcashbillslmtamt == null || strdfltcashbillslmtamt.equalsIgnoreCase("null")) 
			strdfltcashbillslmtamt = "N";
		ext_acc_interface_yn = request.getParameter("ext_acc_interface_yn");
		if(ext_acc_interface_yn == null || ext_acc_interface_yn.equalsIgnoreCase("null")) ext_acc_interface_yn="N";
		
		addlChargeAmtForBill = request.getParameter("addl_charge_amt");
		if(addlChargeAmtForBill == null || "null".equals(addlChargeAmtForBill)){
			addlChargeAmtForBill = "";
		}
/* Commented as the variable is not used @ all
	   try
		{				
			pstmt = con.prepareStatement(" select slmt_type_code from bl_visit_fin_dtls where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "' and visit_id = '"+ strvisitid +"'");
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strdfltslmttypecode =  rs.getString(1);						
			}
			else
			{
				strdfltslmttypecode = "";
			}
		rs.close();
		pstmt.close();
		}

		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_visit_fin_dtls query:"+e);
		}
	
		if ( strdfltslmttypecode == null || strdfltslmttypecode.equalsIgnoreCase("null")) 
			strdfltslmttypecode = "";
*/
		try
		{		
			//pstmt = con.prepareStatement(" select nvl(op_applicable_ind,'N'),nvl(change_receipt_amt_ind,'N') from  bl_cash_counter where cash_counter_code = '" + strcashcounter + "' and operating_facility_id = '" + strfacilityid + "'");	

//			System.out.println("strbillpayableamt "+strbillpayableamt);
//			System.out.println("strcashcounter "+strcashcounter);
//			System.out.println("strfacilityid "+strfacilityid);


			sqlStr = "select decode(sign(?),'1', decode('E','O',nvl(op_applicable_ind,'N'),'E',nvl(op_applicable_ind,'N'),'R', nvl(REF_APPLICABLE_IND,'N')) ,'-1',decode('E','O',nvl(OP_REFUND_IND,'N'),'E',nvl(OP_REFUND_IND,'N'),'R', nvl(REF_REFUND_IND,'N')) ) op_ref_applicable,decode(sign(?),'1',nvl(change_receipt_amt_ind,'N'),'-1',nvl(CHANGE_REFUND_AMT_IND,'N')) op_ref_changea_amt_ind from  bl_cash_counter where cash_counter_code = ?  and operating_facility_id = ?  ";
			
			pstmt = con.prepareStatement(sqlStr);
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strcashcounter);
			pstmt.setString(4,strfacilityid);
			
			rs = pstmt.executeQuery();	

			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedyn =  rs.getString(1);			
				strchangereceiptamtind =  rs.getString(2);			
			}
			else
			{
				strrcptallowedyn = "N";
				strchangereceiptamtind = "N";
			}		
			
			pstmt = null;
			rs = null;
			pstmt = con.prepareStatement("Select NVL(Bill_level_tax_yn,'N') Bill_level_tax_yn from bl_parameters");
			rs = pstmt.executeQuery();	
			if(rs != null && rs.next()){
				billLevelTax = rs.getString("Bill_level_tax_yn");
			}
			
			rs.close();
		pstmt.close();
		strrcptallowedyn="Y";
		strchangereceiptamtind="Y";
		}
		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_cash_counter query:"+e);
		}
		
		if ( strrcptallowedyn == null || strrcptallowedyn.equalsIgnoreCase("null")) 
			strrcptallowedyn = "N";
		if (strchangereceiptamtind == null || strchangereceiptamtind.equalsIgnoreCase("null")) 
		    strchangereceiptamtind = "N";

		try	
		{		
			//pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = '" + strfacilityid + "' and credit_auth_user_id = '" + struser + "'");
			
			sqlStr = "select decode(sign(?),'1',nvl(receipt_auth_yn,'N'),'-1',nvl(REFUND_AUTH_YN,'N')) receipt_refund_auth_yn, decode(sign(?),'1',nvl(change_receipt_allowed_yn,'N'),'-1',nvl(CHANGE_REFUND_ALLOWED_YN,'N')) rec_ref_change_allowed_yn from bl_users_for_credit_auth where operating_facility_id = ? and credit_auth_user_id = ?";
			pstmt = con.prepareStatement(sqlStr);
			
			pstmt.setString(1,strbillpayableamt);
			pstmt.setString(2,strbillpayableamt);
			pstmt.setString(3,strfacilityid);
			pstmt.setString(4,struser);
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strrcptallowedynuser =  rs.getString(1);				
				strchangereceiptalloweduser =  rs.getString(2);						
			}
			else
			{
				strrcptallowedynuser = "N";
				strchangereceiptalloweduser = "N";
			}
			rs.close();
			pstmt.close();
		}		
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_users_for_credit_auth query:"+e);
		}

		if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
			strrcptallowedynuser = "N";
		if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
		    strchangereceiptalloweduser = "N";	

/*
		if (strdfltcashbillslmtamt.equals("N") || strrcptallowedyn.equals("N") || strrcptallowedynuser.equals("N") )
		{
			strslmtamt = "";
			strchangeyn = "Y";
		}
		else
		{ 
			strslmtamt = strbillpayableamt;
			if (strchangereceiptalloweduser.equals("N") || strchangereceiptamtind.equals("N"))
				strchangeyn = "N";
			else
				strchangeyn = "Y";	
	    }	
*/
//		System.err.println("strrcptallowedyn:"+strrcptallowedyn);
//		System.err.println("strrcptallowedynuser:"+strrcptallowedynuser);
		if(strrcptallowedyn.equals("Y") && strrcptallowedynuser.equals("Y"))
		{
			if(strdfltcashbillslmtamt.equals("Y"))
			{
				strslmtamt = strbillpayableamt;
			}

			if(strchangereceiptalloweduser.equals("Y") && strchangereceiptamtind.equals("Y"))
			{
				slmt_amt_disabled_YN="N";
			}
			else
			{
				slmt_amt_disabled_YN="Y";
			}
		}

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
		pstmt.close();
			}
			catch(Exception e)
			{    e.printStackTrace();
				System.out.println("3="+e.toString());
			}
/*
	if (!(strbillpayableamt.equals("")))		   
	{
		try
		{
			CallableStatement call = con.prepareCall("{ call blcommon.proc_chk_for_partial_rcpt_rfnd(?,?,?,?,?,?,?,?,?)}");			
			call.setString(1,strfacilityid);
			call.setString(2,struser);
			call.setString(3,strcashcounter);
			call.registerOutParameter(4,java.sql.Types.VARCHAR); 
			call.registerOutParameter(5,java.sql.Types.VARCHAR); 
			call.registerOutParameter(6,java.sql.Types.VARCHAR); 
			call.registerOutParameter(7,java.sql.Types.VARCHAR); 
			call.registerOutParameter(8,java.sql.Types.VARCHAR); 
			call.registerOutParameter(9,java.sql.Types.VARCHAR); 
			call.execute();				

			str_part_rcpt_cntr_allowed_yn=call.getString(4);
			str_part_rfnd_cntr_allowed_yn=call.getString(5);
			str_part_rcpt_user_allowed_yn=call.getString(6);
			str_part_rfnd_user_allowed_yn=call.getString(7);

			str_sys_message_id	 = call.getString(8);		
			str_error_text		 = call.getString(8);		
			call.close();	
			
			if ( str_part_rcpt_cntr_allowed_yn == null ) str_part_rcpt_cntr_allowed_yn = "";
			if ( str_part_rfnd_cntr_allowed_yn == null ) str_part_rfnd_cntr_allowed_yn = "";
			if ( str_part_rcpt_user_allowed_yn == null ) str_part_rcpt_user_allowed_yn = "";
			if ( str_part_rfnd_user_allowed_yn == null ) str_part_rfnd_user_allowed_yn = "";
			if ( str_sys_message_id == null ) str_sys_message_id = "";
			if ( str_error_text == null ) str_error_text = "";

			System.out.println("str_part_rcpt_cntr_allowed_yn:"+str_part_rcpt_cntr_allowed_yn);
			System.out.println("str_part_rfnd_cntr_allowed_yn:"+str_part_rfnd_cntr_allowed_yn);
			System.out.println("str_part_rcpt_user_allowed_yn:"+str_part_rcpt_user_allowed_yn);
			System.out.println("str_part_rfnd_user_allowed_yn:"+str_part_rfnd_user_allowed_yn);
			System.out.println("str_sys_message_id:"+str_sys_message_id);
			System.out.println("str_error_text:"+str_error_text);
		}
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in blcommon.proc_chk_for_partial_rcpt_rfnd:"+e); 
		}
	}

	if(v_billpayableamt>0)
	{
		if(str_part_rcpt_cntr_allowed_yn.equals("Y") && str_part_rcpt_user_allowed_yn.equals("Y") && v_billpayableamt>0)
		{
			slmt_amt_disabled_YN="N";
		}
		else
		{	
			slmt_amt_disabled_YN="Y";
		}
	}

	if(v_billpayableamt<0)
	{
		if(str_part_rfnd_cntr_allowed_yn.equals("Y") && str_part_rfnd_user_allowed_yn.equals("Y") && v_billpayableamt<0)
		{
			slmt_amt_disabled_YN="N";
		}
		else
		{	
			slmt_amt_disabled_YN="Y";
		}	
	}

	if (strdfltcashbillslmtamt.equals("Y") && str_part_rcpt_cntr_allowed_yn.equals("Y") && str_part_rcpt_user_allowed_yn.equals("Y") )
	{
		strslmtamt = strbillpayableamt;
		if(strchangereceiptamtind.equals("Y"))
		{
			slmt_amt_disabled_YN="N";
		}
	}
*/

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block38Bytes, _wl_block38);

//String cash_slmt_flag = "";		
if( strslmttype == null) strslmttype="";
/* Commented and moved up for PE Changes
try{
		String query_ext_acc="Select nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id='"+strfacilityid+"'";

				stmt=con.createStatement();
				rs21=stmt.executeQuery(query_ext_acc);
				if(rs21 != null)
				{
					while(rs21.next())
					{
						ext_acc_interface_yn =rs21.getString("ext_acc_interface");
						System.out.println("ext_acc_interface_yn :"+ext_acc_interface_yn);
					}
				}
				
		   }
		   catch(Exception e )
				{
                   e.printStackTrace();

				out.println(e);} 
		   finally
			{
				if (rs21 != null)   rs21.close();
				if (stmt != null) stmt.close();		
			}	
*/
	try{
			
			CallableStatement call = 
			con.prepareCall("{ call blopin.proc_ext_acc_serv_group_check (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
			call.setString(1,strfacilityid);
			call.setString(2,strbilldoctypecode);
			call.setString(3,strbilldocnum);
			call.setString(4,"BI");//P_RECEIPT_NATURE_CODE
			call.registerOutParameter(5,java.sql.Types.VARCHAR);	
			call.registerOutParameter(6,java.sql.Types.VARCHAR);	
			call.registerOutParameter(7,java.sql.Types.VARCHAR);	
			call.registerOutParameter(8,java.sql.Types.VARCHAR);	
			call.registerOutParameter(9,java.sql.Types.VARCHAR);	
			call.registerOutParameter(10,java.sql.Types.VARCHAR);	
			call.registerOutParameter(11,java.sql.Types.VARCHAR);	
			call.registerOutParameter(12,java.sql.Types.VARCHAR);	
			call.registerOutParameter(13,java.sql.Types.VARCHAR);	
			call.registerOutParameter(14,java.sql.Types.VARCHAR);	
			call.registerOutParameter(15,java.sql.Types.VARCHAR);	
			call.registerOutParameter(16,java.sql.Types.VARCHAR);	
			call.registerOutParameter(17,java.sql.Types.VARCHAR);	
			
			call.execute();									

			str_receipt_type_code	 = call.getString(5);	
			//strrectype  = call.getString(5);	
			str_ext_acc_facility_id  	 = call.getString(6);	
			str_ext_account_code	 = call.getString(7);	
			str_ext_dept_ind		 = call.getString(8);	
			str_ext_dept_code     	 = call.getString(9);	
			str_single_service_grp_yn = call.getString(10);	
			str_service_grp		= call.getString(11);	
			str_acc_episode_type	= call.getString(12);	
			str_acc_category_code	= call.getString(13);	
			str_acc_serv_grp_used_yn	= call.getString(14);	
			str_reln_code		= call.getString(15);	
			str_episode_type		= call.getString(16);	
			//System.err.println("In Det Page str_episode_type:"+str_episode_type);
			str_error_text		= call.getString(17);	

			call.close();
	
			if (str_receipt_type_code == null) str_receipt_type_code = "";
			if (str_ext_acc_facility_id == null) str_ext_acc_facility_id = "";
			if (str_ext_account_code == null) str_ext_account_code = "";
			if (str_ext_dept_ind == null) str_ext_dept_ind = "";
			if (str_single_service_grp_yn == null) str_single_service_grp_yn = "";
			if (str_service_grp == null) str_service_grp = "";
			if (str_acc_episode_type == null) str_acc_episode_type = "";
			if (str_acc_category_code == null) str_acc_category_code = "";
			if (str_acc_serv_grp_used_yn == null) str_acc_serv_grp_used_yn = "";
			if (str_reln_code == null) str_reln_code = "";
			if (str_episode_type == null) str_episode_type = "";
			if (str_error_text == null) str_error_text = "";
			if (str_ext_dept_code == null) str_ext_dept_code = "";

		
			
	
			
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block40Bytes, _wl_block40);


		}
		catch(Exception e )
			{
			 e.printStackTrace();
			 //out.println(e);
			} 



            _bw.write(_wl_block41Bytes, _wl_block41);

	try
		{
			String drug_penalty_yn ="";
			//int strdrugpenaltyamt =0;
			double strdrugpenaltyamt =0.0;
			CallableStatement call = con.prepareCall("{ call bl_addl_charge_for_bill.check_for_addl_charge(?,?,?,?,?)}");	
			call.setString(1,strfacilityid);
			call.setString(2,strbilldoctypecode);
			call.setString(3,strbilldocnum);
			call.registerOutParameter(4,java.sql.Types.VARCHAR); 
			call.registerOutParameter(5,java.sql.Types.INTEGER);
			call.execute();				
			drug_penalty_yn=call.getString(4);
			strdrugpenaltyamt=call.getDouble(5);
			//strdrugpenaltyamt=call.getInt(5);
			/*System.out.println("1. strfacilityid	  ==> "+strfacilityid);
			System.out.println("2. strbilldoctypecode ==> "+strbilldoctypecode);
			System.out.println("3. strbilldocnum      ==> "+strbilldocnum);
			System.out.println("4. drug_penalty_yn    ==> "+drug_penalty_yn);
			System.out.println("5. strdrugpenaltyamt  ==> "+strdrugpenaltyamt);*/
			call.close();			
			if ( drug_penalty_yn == null ) drug_penalty_yn = "N";
			/*System.out.println("11. strfacilityid	  ==> "+strfacilityid);
			System.out.println("12. strbilldoctypecode ==> "+strbilldoctypecode);
			System.out.println("13. strbilldocnum      ==> "+strbilldocnum);
			System.out.println("14. drug_penalty_yn    ==> "+drug_penalty_yn);
			System.out.println("15. strdrugpenaltyamt  ==> "+strdrugpenaltyamt);
			//if ( strdrugpenaltyamt ==  ) strdrugpenaltyamt = "";*/

            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block49Bytes, _wl_block49);

if(drug_penalty_yn.equals("Y"))
	{

            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strdrugpenaltyamt));
            _bw.write(_wl_block52Bytes, _wl_block52);

	}
	}
		catch(Exception e) 
		{    e.printStackTrace();
			System.out.println("Exception in bl_addl_charge_for_bill.check_for_addl_charge:"+e); 
		}	

            _bw.write(_wl_block53Bytes, _wl_block53);
	
		double remOutStnndAmt = 0.00;
		try{
			remOutStnndAmt = Double.parseDouble(strbillpayableamt) - Double.parseDouble(strslmtamt);			
		}
		catch(Exception e){
			remOutStnndAmt = 0.00;
		}
		if (ext_acc_interface_yn.equals("Y"))
		{

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(str_receipt_type_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strrectypedesc));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(str_ext_account_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(stracccodedesc));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strdeptdesc));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block65Bytes, _wl_block65);

			if("MOHBR".equals(custId)){ 
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(remOutStnndAmt));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
		}
		else
		{

            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block71Bytes, _wl_block71);

			if("MOHBR".equals(custId)){ 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(remOutStnndAmt));
            _bw.write(_wl_block74Bytes, _wl_block74);
}
			else{ 
            _bw.write(_wl_block75Bytes, _wl_block75);
}
		}

            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(str_ext_acc_facility_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(str_ext_account_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(str_ext_dept_ind));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(str_ext_dept_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(str_single_service_grp_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(str_service_grp));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(str_acc_episode_type));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(str_acc_serv_grp_used_yn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(str_acc_category_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(str_reln_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strroundingamt));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(slmt_amt_disabled_YN));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(custId ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(addlChargeAmtForBill ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(billLevelTax ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(billAlreadyPrinted ));
            _bw.write(_wl_block103Bytes, _wl_block103);

}catch(Exception e)
	{
	 e.printStackTrace();
	System.out.println("Exception in main detl="+e);}
	finally{					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
			}

            _bw.write(_wl_block104Bytes, _wl_block104);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_SLMT_DTL.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_NO.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DrugPenalty.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT_TYPE.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ACCOUNT_CODE.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.department.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SLMT_AMT.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OutstandingAmount.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SLMT_AMT.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OutstandingAmount.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECD_THRU_MAIL.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
