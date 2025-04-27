package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillslmtdet1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtDet1.jsp", 1709114426369L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n\n<HEAD>\n\n\n<!--\t<TITLE> Bill Settlement Details  11 </TITLE> -->\n\t\t<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </TITLE>\n\t<!--\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t-->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n\t<script language=\'javascript\'>\t\n\n\tfunction dfltslmt()\n    {\n\tvar dfltslmt = document.forms[0].dfltslmttypecode.value;\t\n\n\tvar billslmtamt = document.forms[0].billslmtamt.value;\t\n\n\tif (billslmtamt == null || billslmtamt == 0 || billslmtamt == \"\")\n\t\treturn;\t\n\t\t\n\ttry\n\t{\n\t\tfor(i=0;i<document.forms[0].slmttype.options.length;i++)\n\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\tvar cashSetValue = document.forms[0].slmttype.options[i].value;\n\t\t\t\t\t\n\t\t\tif (cashSetValue == null)\n\t\t\t{\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tvar len = cashSetValue.length;\n\t\t\tvar subValue =\"\";\n\n\t\t\tif (len >0)\n\t\t\t{\n\t\t\t\tsubValue = cashSetValue.substring(0,len-1);\n\t\t\t}\n\t\t\tif (subValue == dfltslmt)\n\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\tdocument.forms[0].slmttype.value = cashSetValue;\n\t\t\t\tcalldfltslmt(cashSetValue);\n\t\t\t}\n\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t}\n\t\t\t\t\n\t}\n\tcatch(e)\n\t{\n\t}\t\t\t\t\n   }\n   \n\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t<script>\t\t\n\t\t\t\n\t\t\tfunction checkslmtamt()\n\t\t\t{\n\t\t\t\tvar v_billslmtamt = \"\";\t\t\t\n\t\t\t\tvar v_billpayableamt = \"\";\n\n\t\t\t\tv_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\n\t\t\t\tv_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;\t\t\t\n\n\t\t\t\tif ( parseFloat(v_billslmtamt) > parseFloat(v_billpayableamt))\n\t\t\t\t{\n//\t\t\t\t\talert(\"Allocated amount is greater than outstanding amount\");\n\t\t\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.select();\n\t\t\t\t\tparent.frames[0].d\tocument.forms[0].billslmtamt.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( parseFloat(v_billslmtamt) < 0 )\n\t\t\t\t{\n//\t\t\t\t\talert(\" Refund cannot be allowed\");\n\t\t\t\t\talert(getMessage(\"BL9536\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.select();\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( parseFloat(v_billslmtamt) == 0 || v_billslmtamt == \"\" || v_billslmtamt == null )\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].slmttype.value = \"\";\n\t\t\t\t\tcalldfltslmt(\"\");\t\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction billslmtprocess()\n\t\t\t{\t\n\t\t\t\tvar v_slmttype\t\t= \"\";\n\t\t\t\tvar v_cashslmtflag\t= \"\";\n\t\t\t\tvar v_instref\t\t= \"\";\n\t\t\t\tvar v_instdate\t\t= \"\";\n\t\t\t\tvar v_instremark\t= \"\";\n\t\t\t\tvar v_slmtidno\t\t= \"\";\n\t\t\t\tvar v_slmtpayername = \"\";\n\t\t\t\tvar v_billslmtamt = \"\";\t\n\t\t\t\tvar v_slmtapprrefno = \"\";\n\n\t\t\t\tvar v_rectype =\"\";\n\t\t\t\tvar v_ext_acc_facility_id = \"\";\n\t\t\t\tvar v_ext_acc_code = \"\";\n\t\t\t\tvar v_ext_acc_dept = \"\";\n\t\t\t\tvar v_online_approval = \"\";\n\t\t\t\tvar v_batch_no = \"\";\n\t\t\t\tvar v_sale_draft_no = \"\";\n\t\t\t\tvar v_ext_acc_interface_yn = \"\";\n\n\t\t\t\tv_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\n\t\t\t\tv_slmttype = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\t\t\t\n\n\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\n\t\t\t\t\n\t\t\t\tif (v_billslmtamt == null ) v_billslmtamt =\"\";\n\t\t\t\tif (v_slmttype == null ) v_slmttype = \"\";\n\t\n\t\t\t\tif (v_slmttype == \"\" && parseFloat(v_billslmtamt) > 0)\n\t\t\t\t{\t\n//\t\t\t\t\talert( \"Settlement Type cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9521\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_slmttype != \"\" && parseFloat(v_billslmtamt) == 0)\n\t\t\t\t{\t\n//\t\t\t\t\talert( \"Settlement Type cannot be selected for Zero amount\");\n\t\t\t\t\talert(getMessage(\"BL9522\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\n\n\t\t\t\tif (v_slmttype != \"\" &&  v_billslmtamt ==\"\" )\n\t\t\t\t{\t\n//\t\t\t\t\talert( \"Settlement Amount cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tvar str = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\t\n\t\t\t\tv_cashslmtflag =str.charAt(2);\t\t\n\t\t\t\t\n\t\t\t\tif (v_slmttype != \"\")\n\t\t\t\t{\n\t\t\t\t\tv_ext_acc_interface_yn = parent.frames[1].document.forms[0].ext_acc_interface_yn.value;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif (v_ext_acc_interface_yn == \"Y\" && v_slmttype != \"\")\n\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tv_rectype = parent.frames[1].document.forms[0].rectype.value;\n\t\t\t\t\tv_ext_acc_facility_id = parent.frames[1].document.forms[0].ext_acc_fac_id.value;\n\t\t\t\t\tv_ext_acc_code = parent.frames[1].document.forms[0].acccode.value;\n\t\t\t\t\tv_ext_acc_dept = parent.frames[1].document.forms[0].dept.value;\n\t\t\t\t\t\n\t\t\t\t\tif ( v_rectype == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Receipt Type cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9524\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].rectype.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t\tif ( v_ext_acc_code == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Account code cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9525\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].acccode.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t\tif ( v_ext_acc_dept == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Accounting department cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9526\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].dept.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\n\t\t\t\tif (v_cashslmtflag != \"Y\" && v_slmttype != \"\")\n\t\t\t\t{\n\t\t\t\t\t\tv_instref = parent.frames[1].document.forms[0].instref.value;\n\t\t\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value;\n\t\t\t\t\t\tv_instremark = parent.frames[1].document.forms[0].instremark.value;\n\t\t\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\t\t\t\tif (parent.frames[1].document.forms[0].onlineapproval.checked)\n\t\t\t\t\t\t\tv_online_approval = \'Y\';\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tv_online_approval = \'N\';\n\n\t\t\t\t\t\tv_batch_no = parent.frames[1].document.forms[0].batchno.value;\n\t\t\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;\n\n\t\t\t\t\t\tif ( v_instref == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Instrument Ref cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9527\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif ( v_instdate == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Instrument Date cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9528\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif (v_instremark == \"\" && (v_cashslmtflag == \"A\" || v_cashslmtflag == \"B\"))\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Bank/Card Co. Name cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9529\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].instremark.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif (v_slmtapprrefno == \"\" && v_cashslmtflag == \"A\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Approval code cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9531\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].apprrefno.focus();\n\t\t\t\t\t\t\treturn false;\t\t\t\t\t\t\n\t\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Payer\'s name cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername != \"\" && v_slmtidno == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Payer\'s Ref Id cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"Y\" && v_batch_no == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Batch No cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9530\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"N\" && v_batch_no != \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Online Approved credit card transaction can only have batch number\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9534\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\t\t\tif (v_cashslmtflag == \"A\" && v_sale_draft_no == \"\")\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Sale Draft No cannot be blank\");\n\t\t\t\t\t\t\talert(getMessage(\"BL9535\",\"BL\"));\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].saledraftno.focus();\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tif (v_cashslmtflag == \"Y\" && v_slmttype != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t\n\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[2].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
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

    private final static java.lang.String  _wl_block21 ="\',arguments,features); \n\t\t\t\t*/\n\n\t\t\t\treturn;\t\t\t\n\n\t\t\t\t}\t\t\t\n\t\t\t}\n\n\n\n\t\t\tfunction calldfltslmt(val)\n\t\t\t{\n\t\t\t\tvar str = val;\n\t\t\t\tvar obj=str.substring(0,2);\n\t\t\t\tvar v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tif (obj.charAt(2) != \"Y\" && obj != \"\" && v_billslmtamt != \"\")\n\t\t\t\t{\t\t\t\tparent.frames[1].location.href=\'../../eBL/jsp/BLBillSlmtType.jsp?slmttype=\'+obj+\'&slmtidno=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&slmtpayername=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&billdoctypecode=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t}\t\n\n\t\t\t\tif ( v_billslmtamt == \"\" && str != \"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.value = \"\";\n//\t\t\t\t\talert(\"Settlement Amount cannot be blank\");\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\t\t\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\n\t\t\t\t}\n\n\t\t\tfunction callslmt(Obj)\n\t\t\t{\n\t\t\t\tvar str = Obj.value;\n\t\t\t\tvar obj=str.substring(0,2);\n\t\t\t\tvar v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tif (obj.charAt(2) != \"Y\" && obj != \"\" && v_billslmtamt != \"\")\n\t\t\t\t{\t\t\t\tparent.frames[1].location.href=\'../../eBL/jsp/BLBillSlmtType.jsp?slmttype=\'+obj+\'&slmtidno=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t}\t\n\n\t\t\t\tif ( v_billslmtamt == \"\" && str != \"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.forms[0].slmttype.value = \"\";\n//\t\t\t\t\talert(\"Settlement Amount cannot be blank\");\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\t\t\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\n\t\t\t\t}\n\t</script>\t   \n</HEAD>\n\n<BODY\tonLoad=\"dfltslmt();\"  onUnload=\"billslmtprocessclose();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" >\n\n\t<FORM name=\'BillSlmtDetForm\' id=\'BillSlmtDetForm\' method=\'Login\'  action=\'\'  scrolling=\'NO\' >\n\t\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\t \n\t<tr>\n<!--\t<td class=\"label\" width=\"25%\">Bill No</td>\t -->\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\t \n\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billdoctype\" id=\"billdoctype\" SIZE=\"7\" MAXLENGTH=\"10\" \t\t\t\tVALUE=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  style=\'text-align:left\'> / <INPUT TYPE=\"TEXT\" \n\tREADONLY name=\"billdocnum\" id=\"billdocnum\" SIZE=\"8\" MAXLENGTH=\"10\"  VALUE=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' style=\'text-align:right\'></td>\n<!--\t<td class=\"label\" width=\"25%\">Payable Amount</td>\t-->\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\t\n\t<!--\n\t<td>&nbsp;<INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"8\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  style=\'text-align:right\'>&nbsp;<INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"  OK  \" onClick=\'billslmtprocess()\'><td> \t\n\t-->\n\n\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  style=\'text-align:right\'></td> \t\n\t</tr>\n\t<tr>\t\t\n<!--\t<td class=\"label\" width=\"25%\">Amount Settled</td>\t-->\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\t\n\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\n\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" name=\"billslmtamt\" id=\"billslmtamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  style=\'text-align:right\' onBlur=\'return checkslmtamt();\'> </td>\t\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n      <td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billslmtamt\" id=\"billslmtamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  style=\'text-align:right\' onBlur=\'return checkslmtamt();\'> </td>\t\n\t ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n<!-- \t<td width=\"25%\"  class=\"label\" >Settlement Type<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'></td> -->\n \t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'></td>\n\t<td width=\"25%\" class=\"fields\" ><select name=\'slmttype\' id=\'slmttype\' onChange=\'callslmt(this)\'><option value=\'\'>---";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="---</option>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\t\t\t\talert(v_error);\t\t\t\t \n\t\t\t\t\t </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\n\t\t\t\t</select></td>\n\t\t\t\t<!-- <td class=\"label\"> </td> -->\n\t\t\t</tr>\n<!--\n\t\t\t<tr>\t\t\n\t\t\t\t<td width=\"\" class=\"label\"></td>\n\t\t\t\t<td width=\"\" class=\"label\"></td>\n\t\t\t\t<td width=\"\" class=\"label\"></td>\n\t\t\t\t<td width=\"\" class=\"label\"></td>\n\t\t\t\t<td width=\"\" class=\"label\"></td>\n\t\t\t</tr>\n-->\n\t\t</table> \n\t\t<INPUT TYPE=\"HIDDEN\" name=\"pagecloseind\" id=\"pagecloseind\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"0\">\t\t\n\t\t<INPUT TYPE=\"HIDDEN\" name=\"dfltslmttypecode\" id=\"dfltslmttypecode\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\t \n\t</FORM>\t\n\t<INPUT TYPE=\"HIDDEN\" name=\"slmtdate\" id=\"slmtdate\"\t   SIZE=\"20\" MAXLENGTH=\"20\" \tVALUE=\"\"> \n\t<INPUT TYPE=\"HIDDEN\" name=\"slmtdocrefdesc\" id=\"slmtdocrefdesc\" SIZE=\"50\" MAXLENGTH=\"100\"\tVALUE=\"\">\t\n\t<INPUT TYPE=\"HIDDEN\" name=\"slmtdocref\" id=\"slmtdocref\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"\">\t \n\t<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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

	String strdfltslmttypecode = "";

	String locale	= (String)session.getAttribute("LOCALE");
	String querystring=(String)request.getQueryString();
//		System.out.println("querystring in BLBillSlmtDet1.jsp:"+querystring);
 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	try{
	String strbilldoctypecode = request.getParameter("billdoctypecode");
	String strbilldocnum = request.getParameter("billdocnum");	
	String strbillpayableamt = request.getParameter("billpayableamt");	
	String strfacilityid = request.getParameter("facilityid");	
	String strpatientid  = request.getParameter("patientid");	
 	String strepisodetype = request.getParameter("episodetype");	
	String strepisodeid = request.getParameter("episodeid");
	String strvisitid = request.getParameter("visitid");		
	String strslmtpayername = request.getParameter("slmtpayername");	
	String struser = request.getParameter("loggeduser");	
	String strslmtidno = request.getParameter("slmtidno");

	String strcashcounter = request.getParameter("cashcounter");
	String strdfltcashbillslmtamt = "";
	String strrcptallowedyn = "";
	String strchangereceiptamtind = "";
	String strrcptallowedynuser = "";
	String strchangereceiptalloweduser = "";
	String strslmtamt = "";
	String strchangeyn	= "N";
	

		
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

	Connection con				= null;
	PreparedStatement pstmt		= null;

	//unused variable, commented on 09/06/05
	//PreparedStatement pstmt1	= null;
	//Statement stmt1				= null;
	//ResultSet rs4				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	//ResultSet rs3				= null;


	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			

	String strclientip = p.getProperty("client_ip_address");	

	con	=	ConnectionManager.getConnection(request);
	try
	{				
		pstmt = con.prepareStatement(" select nvl(dflt_cash_bill_slmt_amt,'N') from bl_parameters where operating_facility_id = ? ");
		pstmt.setString(1,strfacilityid);
		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{
			strdfltcashbillslmtamt =  rs.getString(1);						
		}
		else
				strdfltcashbillslmtamt = "N";
	}
	catch(Exception e) 
	{ }
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
	}	


	if ( strdfltcashbillslmtamt == null || strdfltcashbillslmtamt.equalsIgnoreCase("null")) 
	   strdfltcashbillslmtamt = "N";


   
   try
	{				
		pstmt = con.prepareStatement(" select slmt_type_code from bl_visit_fin_dtls where operating_facility_id = ? and episode_type = ? and episode_id = ? and visit_id = ? ");
		
		pstmt.setString(1,strfacilityid);
		pstmt.setString(2,strepisodetype);
		pstmt.setString(3,strepisodeid);
		pstmt.setString(4,strvisitid);

		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{
			strdfltslmttypecode =  rs.getString(1);						
		}
		else
		{
			strdfltslmttypecode = "";
		}
	}
	catch(Exception e) 
	{ }
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
	}	

    if ( strdfltslmttypecode == null || strdfltslmttypecode.equalsIgnoreCase("null")) 
	   strdfltslmttypecode = "";


	try
	{		
		pstmt = con.prepareStatement(" select nvl(op_applicable_ind,'N'),nvl(change_receipt_amt_ind,'N') from  bl_cash_counter where cash_counter_code = ? and operating_facility_id = ? ");
		
		pstmt.setString(1,strcashcounter);
		pstmt.setString(2,strfacilityid);

		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{
			strrcptallowedyn =  rs.getString(1);			
			strchangereceiptamtind =  rs.getString(2);			
		}
		else
		{	strrcptallowedyn = "N";
			strchangereceiptamtind = "N";
		}		
	}

	catch(Exception e) 
	{}

	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
	}	

	if ( strrcptallowedyn == null || strrcptallowedyn.equalsIgnoreCase("null")) 
	   strrcptallowedyn = "N";

	if (strchangereceiptamtind == null || strchangereceiptamtind.equalsIgnoreCase("null")) 
	   strchangereceiptamtind = "N";

	try
	{		
		pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = ? and credit_auth_user_id = ? ");
		
		pstmt.setString(1,strfacilityid);
		pstmt.setString(2,struser);

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
	}
	catch(Exception e) 
	{}

	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
		//Moved here in Bangalore on 13/10/2005
//		ConnectionManager.returnConnection(con, request);	
	}	

	


	if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
	   strrcptallowedynuser = "N";

	if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
       strchangereceiptalloweduser = "N";	

	if (strdfltcashbillslmtamt.equals("N") || strrcptallowedyn.equals("N")
        || strrcptallowedynuser.equals("N") )
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

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 
	if (strchangeyn.equals("Y"))
	{ 
	
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block34Bytes, _wl_block34);
 
	 } 
	 else
	 {
     
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block36Bytes, _wl_block36);
 
	  } 
	 
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

			try {
//					con	=	ConnectionManager.getConnection(request);

					// Cash Counter Check

					CallableStatement call = 
					con.prepareCall("{ call bl_user_check_for_cash_counter (?,?,?,?,?,?,?)}");			
					call.setString(1,strfacilityid);
					call.setString(2,"O");
					call.setString(3,struser);
					call.setString(4,strclientip);

					call.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.registerOutParameter(7,java.sql.Types.VARCHAR);	

					call.execute();									

					String strscashcountercode	 = call.getString(5);	
					String strshiftid	  	     = call.getString(6);		
					String strsysmessageid		 = call.getString(7);		

					call.close();

					String strerrortext = "";

					if ( strscashcountercode == null ) strscashcountercode = "";
					if ( strshiftid == null ) strshiftid = "";
					if ( strsysmessageid == null ) strsysmessageid = "";


					if (!(strsysmessageid.equals("")))
					{
					try
					{			
						call = 
						con.prepareCall("{ ? = call  blcommon.get_error_text(?)}");	
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.setString(2,strsysmessageid);
						call.execute();				
						strerrortext = call.getString(1);			
						call.close();	
						if ( strerrortext == null ) strerrortext = ""; 
					}
					catch(Exception e)
					{ 
						//out.println(e.toString());
						e.printStackTrace();
					}	
					if ( !(strerrortext.equals("")) )
					{
					
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block41Bytes, _wl_block41);

					}		
			      }
//	PE Changes				pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where language_id='"+locale+"' and status is null and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where 		operating_facility_id =  '"+ strfacilityid + "' and cash_counter_code = '"+ strscashcountercode + "' and status is null) order by short_desc  " ) ;

					pstmt = con.prepareStatement("Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where language_id=? and status is null and nvl(cashier_yn,'N') = 'Y' and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id=?) and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where operating_facility_id = ? and cash_counter_code =? and status is null) order by short_desc") ;
					
					
					pstmt.setString(1,locale);
					pstmt.setString(2,strfacilityid);
					pstmt.setString(3,strfacilityid);
					pstmt.setString(4,strscashcountercode);
					rs2 = pstmt.executeQuery() ;
					if( rs2 != null ) 
					{
						while( rs2.next() ) 
						{
							String slmt_type_code = rs2.getString( "slmt_type_code" ) ;
							String short_desc = rs2.getString( "short_desc" ) ;
							String cash_slmt_flag=rs2.getString("cash_slmt_flag") ;

							if ( slmt_type_code == null ) slmt_type_code = "";
							if ( short_desc == null ) short_desc ="";
							if ( cash_slmt_flag == null ) cash_slmt_flag = "";

							// defaulting settlement type from visit fin dtls if exist...					    
							
													
								out.println("<option value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");	
							
						}
					}
				 }
				catch(Exception e) 
					{
						//out.println(e.toString());
						e.printStackTrace();	
					}

				finally 
					{
						if (rs2 != null)   rs2.close();
						if (pstmt != null) pstmt.close();		 	
						//Moved here in Bangalore on 13/10/2005
						ConnectionManager.returnConnection(con, request);	
					}

					

	}catch(Exception e)
	{System.out.println("Exception in main detl="+e);}

			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strdfltslmttypecode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_NO.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AMT_SETTLED.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
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
}
