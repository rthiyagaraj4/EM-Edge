package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import eCommon.XSSRequestWrapper;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.CommonBean;

public final class __blbillslmtdet2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtDet2.jsp", 1742746840714L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210113             8157          NMC-JD-CRF-0072               Shikha Seth\n2            V210224             8157          NMC-JD-CRF-0072               Shikha Seth\n3\t\t\t\t 15771\t       NMC-JD-SCF-0164\t\t     Sethuraman D\n4\t      \tV220404\t\t\t     27973\t\t\t\tMMS-ME-SCF-0046-TF\t\t\t\t\tMohana Priya K\n5\t\t\tV220506\t\t\t\t27018\t\t\t\tNMC-JD-SCF-0262\t\t\tMohana Priya K\n6\t\t\tV220808\t\t\t\t35014\t\tBL-TH-KW-CRF-0017-US001/03-Other\n\t\t\t\t\t\t\t\t\t\t\t\tSettlement types\t\t\t\tMohanaPriya K\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n<!--\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t<script language=\'javascript\'>\t\n\t\tfunction dfltslmt()\n\t\t{\n\t\t\tshow_valid_button();\t\t\t\t\n\t\t\tif(document.forms[0].cc_approval_check_YN.value==\"N\")\n\t\t\t{\t\t\t\t\n\t\t\t\tvar dfltslmt = document.forms[0].dfltslmttypecode.value;\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tvar billslmtamt = document.forms[0].billslmtamt.value;\t\n\t\t\t\tif (billslmtamt == null || billslmtamt == 0 || billslmtamt == \"\")\n\t\t\t\t\treturn;\t\t\t\t\t\t\n\t\t\t\tfor(i=0;i<document.forms[0].slmttype.options.length;i++)\n\t\t\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar cashSetValue = document.forms[0].slmttype.options[i].value;\t\t\t\t\t\t\n\t\t\t\t\tif (cashSetValue == null)\n\t\t\t\t\t{\n\t\t\t\t\t\tcontinue;\n\t\t\t\t\t}\n\t\t\t\t\tvar len = cashSetValue.length;\n\t\t\t\t\tvar subValue =\"\";\n\t\t\t\t\tif (len >0)\n\t\t\t\t\t{\n\t\t\t\t\t\tsubValue = cashSetValue.substring(0,2);\t\t\t\t\t\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\tif (subValue == dfltslmt)\n\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\tdocument.forms[0].slmttype.value = cashSetValue;\n\t\t\t\t\t\t//calldfltslmt(cashSetValue);//V220506\n\t\t\t\t\t\tcallslmt(\"Y\"); //V220506\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t<script>\t\t\n\t\t\t\n\t\tfunction checkslmtamt(val)\n\t\t{\n\t\t\t\n\t\t\tvar v_billslmtamt = \"\";\t\t\t\n\t\t\tvar v_billpayableamt = \"\";\n\n\t\t\tvar str = document.forms[0].slmttype.value;\n\t\t\tvar v_cashslmtflag =str.charAt(2);\t\n\t\t\t//V210224 start\n\t\t\tvar v_couponflag = str.charAt(3);\n\t\t\tvar siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value;\t\t\n\t\t\t// V210224 end\n\t\t\tif(v_cashslmtflag ==\"Y\"){\n\t\t\t\tif(val.value<0){\n\t\t\t\t\tputdeci(val); //V220808\n\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.value=val.value;\n\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.focus();\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.value=\'\';\n\t\t\t\t} //V220803\n\t\t\t\tparent.frames[1].document.forms[0].cash_return.value=\'\';\n\t\t\t}\n\n\t\t\tv_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\n\t\t\tv_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;\n\t\t\t\n\t\t\tif(v_billpayableamt < 0)\n\t\t\t{\n\t\t\t\tvar temp=v_billslmtamt.indexOf(\'-\');\n\t\t\t\tif(temp != -1 ) \n\t\t\t\t{\n\t\t\t\t\tif(temp != 0 ) \n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"INVALID_NUMBER_FORMAT\",\"common\"));\n\t\t\t\t\t\tdocument.forms[0].billslmtamt.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t\t}\t\t\t\t\n\t\t\t\n\t\t\tif(v_billpayableamt>0 && v_billslmtamt<0 || v_billpayableamt<0 && v_billslmtamt>0 )\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\t\t\tdocument.forms[0].billslmtamt.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\n\t\t\tvar billslmtamt=document.forms[0].billslmtamt.value;\n\t\t\t//if(billslmtamt==0)\t //V210224 commented\t\t\n\t\t\tif(billslmtamt==0 && !(siteCouponInSlmt ==\'true\' && v_cashslmtflag == \'D\' && v_couponflag==\'Y\')) //V210224\n\t\t\t{\tif(parent.frames[0].document.forms[0].billslmtamt.readOnly == \'false\') { //V210224\n\t\t\t\t//alert(\"Amount Settled must be greater than zero\");\n\t\t\t\talert(getMessage(\"BL9776\",\"BL\"));\n\t\t\t\tdocument.forms[0].billslmtamt.select();\n\t\t\t\treturn false;\n\t\t\t\t} //V210224\n\t\t\t}\n\n\t\t\tif ( parseFloat(Math.abs(v_billslmtamt)) > parseFloat(Math.abs(v_billpayableamt)))\n\t\t\t{\n\t\t\t\t//alert(\"Allocated amount is greater than outstanding amount\");\n\t\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.select();\n\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t/*\tif ( parseFloat(v_billslmtamt) < 0 )\n\t\t\t{\n\t\t\t\t//alert(\" Refund cannot be allowed\");\n\t\t\t\talert(getMessage(\"BL9536\",\"BL\"));\n\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.select();\n\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\treturn false;\n\t\t\t}*/\n\n\t\t\tif ( parseFloat(v_billslmtamt) == 0 || v_billslmtamt == \"\" || v_billslmtamt == null )\n\t\t\t{\n\t\t\t\tif (!(siteCouponInSlmt ==\'true\' && v_cashslmtflag == \'D\' && v_couponflag==\'Y\')) { //V210224\n\t\t\t\t\tdocument.forms[0].slmttype.value = \"\";\n\t\t\t\t\tcalldfltslmt(\"\");\t\n\t\t\t\t} //V210224\n\t\t\t}\n\t\t\tvar temp_billslmtamt=eval(\"document.forms[0].billslmtamt\");\n\t\t\tputdeci(temp_billslmtamt);\n\t\t\tif(document.forms[0].slmttype.value ==\"CAY\")\n\t\t\t{\n\t\t\t\t//parent.frames[1].document.forms[0].cash_given.focus();\n\t\t\t}\n\n\t\t}\n\n\t\tfunction billslmtprocess()\n\t\t{\t\n\t\t\tvar v_slmttype\t\t= \"\";\n\t\t\tvar v_cashslmtflag\t= \"\";\n\t\t\tvar v_instref\t\t= \"\";\n\t\t\tvar v_instdate\t\t= \"\";\n\t\t\tvar v_instremark\t= \"\";\n\t\t\tvar v_slmtidno\t\t= \"\";\n\t\t\tvar v_slmtpayername = \"\";\n\t\t\tvar v_billslmtamt = \"\";\t\n\t\t\tvar v_slmtapprrefno = \"\";\n\n\t\t\tvar v_rectype =\"\";\n\t\t\tvar v_ext_acc_facility_id = \"\";\n\t\t\tvar v_ext_acc_code = \"\";\n\t\t\tvar v_ext_acc_dept = \"\";\n\t\t\tvar v_online_approval = \"\";\n\t\t\tvar v_batch_no = \"\";\n\t\t\tvar v_sale_draft_no = \"\";\n\t\t\tvar v_ext_acc_interface_yn = \"\";\n\n\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\tvar v_cc_term_id_num = \"\";\n\t\t\tvar v_cc_instbranch = \"\";\n\t\t\tvar v_cc_trx_date_time = \"\";\n\n\t\t\tv_billslmtamt = parent.frames[1].document.forms[0].billslmtamt.value;\t\t\t\t\t\n\t\t\tv_slmttype = parent.frames[1].document.forms[0].slmttype.value;\t\t\t\t\t\t\t\n\n\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\n\t\t\t\n\t\t\tif (v_billslmtamt == null ) v_billslmtamt =\"\";\n\t\t\tif (v_slmttype == null ) v_slmttype = \"\";\n\n\t\t\tif (v_slmttype == \"\" && parseFloat(v_billslmtamt) > 0)\n\t\t\t{\t\n\t\t\t\t//alert( \"Settlement Type cannot be blank\");\n\t\t\t\talert(getMessage(\"BL9521\",\"BL\"));\n\t\t\t\t//parent.frames[1].document.forms[0].slmttype.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif (v_slmttype != \"\" && parseFloat(v_billslmtamt) == 0)\n\t\t\t{\t\n\t\t\t\t//alert( \"Settlement Type cannot be selected for Zero amount\");\n\t\t\t\talert(getMessage(\"BL9522\",\"BL\"));\n\t\t\t\t//parent.frames[1].document.forms[0].slmttype.focus();\n\t\t\t\treturn false;\n\t\t\t}\t\t\t\n\n\t\t\tif (v_slmttype != \"\" &&  v_billslmtamt ==\"\" )\n\t\t\t{\t\n\t\t\t\t//alert( \"Settlement Amount cannot be blank\");\n\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\t//parent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tvar str = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\t\n\t\t\tv_cashslmtflag =str.charAt(2);\t\t\n\t\t\t\n\t\t\tif (v_slmttype != \"\")\n\t\t\t{\n\t\t\t\tv_ext_acc_interface_yn = parent.frames[1].document.forms[0].ext_acc_interface_yn.value;\n\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\tif (v_ext_acc_interface_yn == \"Y\" && v_slmttype != \"\")\n\n\t\t\t{\t\t\t\t\t\n\t\t\t\tv_rectype = parent.frames[1].document.forms[0].rectype.value;\n\t\t\t\tv_ext_acc_facility_id = parent.frames[1].document.forms[0].ext_acc_fac_id.value;\n\t\t\t\tv_ext_acc_code = parent.frames[1].document.forms[0].acccode.value;\n\t\t\t\tv_ext_acc_dept = parent.frames[1].document.forms[0].dept.value;\n\t\t\t\t\n\t\t\t\tif ( v_rectype == \"\")\n\t\t\t\t{\n\t\t\t\t\t//alert(\"Receipt Type cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9524\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].rectype.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( v_ext_acc_code == \"\")\n\t\t\t\t{\n\t\t\t\t\t//alert(\"Account code cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9525\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].acccode.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( v_ext_acc_dept == \"\")\n\t\t\t\t{\n\t\t\t\t\t//alert(\"Accounting department cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9526\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].dept.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\t\t\t\t\n\n\t\t\tif (v_cashslmtflag != \"Y\" && v_slmttype != \"\")\n\t\t\t{\n\t\t\t\tv_instref = parent.frames[1].document.forms[0].instref.value;\n\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value;\n\t\t\t\tv_instremark = parent.frames[1].document.forms[0].instremark.value;\n\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\t\tif (parent.frames[1].document.forms[0].onlineapproval.checked)\n\t\t\t\t\tv_online_approval = \'Y\';\n\t\t\t\telse\n\t\t\t\t\tv_online_approval = \'N\';\n\n\t\t\t\tv_batch_no = parent.frames[1].document.forms[0].batchno.value;\n\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;\n\n\t\t\t\tif ( v_instref == \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Instrument Ref cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9527\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( v_instdate == \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Instrument Date cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9528\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_instremark == \"\" && (v_cashslmtflag == \"A\" || v_cashslmtflag == \"B\"))\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Bank/Card Co. Name cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9529\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].instremark.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_slmtapprrefno == \"\" && v_cashslmtflag == \"A\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Approval code cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9531\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].apprrefno.focus();\n\t\t\t\t\treturn false;\t\t\t\t\t\t\n\t\t\t\t}\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername == \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Payer\'s name cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername != \"\" && v_slmtidno == \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Payer\'s Ref Id cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"Y\" && v_batch_no == \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Batch No cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9530\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"N\" && v_batch_no != \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Online Approved credit card transaction can only have batch number\");\n\t\t\t\t\talert(getMessage(\"BL9534\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\tif (v_cashslmtflag == \"A\" && v_sale_draft_no == \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Sale Draft No cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9535\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].saledraftno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\n\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\tv_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;\n\t\t\t\tv_cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;\n\t\t\t\tv_cc_instbranch = parent.frames[1].document.forms[0].instbranch.value;\n\t\t\t}\n\t\t\telse\n\t\t\tif (v_cashslmtflag == \"Y\" && v_slmttype != \"\")\n\t\t\t{\n\t\t\t\n\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t}\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->\t\n\t\t\t//parent.frames[2].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&billdocnum=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&billpayableamt=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&facilityid=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&user=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&patientid=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&episodetype=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&episodeid=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&visitid=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&slmtamt=\'+v_billslmtamt+\'&slmttypecode=\'+v_slmttype.substring(0,2)+\'&slmtdocref=\'+v_instref+\'&slmtdocrefdate=\'+v_instdate+\'&slmtdocrefremark=\'+v_instremark+\'&slmtidno=\'+v_slmtidno+\'&slmtpayername=\'+v_slmtpayername+\'&slmtapprrefno=\'+v_slmtapprrefno+\'&onlineapproval=\'+v_online_approval+\'&batchno=\'+v_batch_no+\'&saledraftno=\'+v_sale_draft_no+\'&rectype=\'+v_rectype+\'&extaccfacid=\'+v_ext_acc_facility_id+\'&extacccode=\'+v_ext_acc_code+\'&extaccdept=\'+v_ext_acc_dept; \n\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\tparent.frames[2].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&slmtamt=\'+v_billslmtamt+\'&slmttypecode=\'+v_slmttype.substring(0,2)+\'&slmtdocref=\'+v_instref+\'&slmtdocrefdate=\'+v_instdate+\'&slmtdocrefremark=\'+v_instremark+\'&slmtidno=\'+v_slmtidno+\'&slmtpayername=\'+v_slmtpayername+\'&slmtapprrefno=\'+v_slmtapprrefno+\'&onlineapproval=\'+v_online_approval+\'&batchno=\'+v_batch_no+\'&saledraftno=\'+v_sale_draft_no+\'&rectype=\'+v_rectype+\'&extaccfacid=\'+v_ext_acc_facility_id+\'&extacccode=\'+v_ext_acc_code+\'&extaccdept=\'+v_ext_acc_dept+\'&cctermidnum=\'+v_cc_term_id_num+\'&cctrxdatetime=\'+v_cc_trx_date_time+\'&instbranch=\'+v_cc_instbranch; \n\t\t\t\t\n\t\t}\n\n\t\tasync function billslmtprocessclose()\n\t\t{\t\t\t\t\n\n\t\t\tif ( parent.frames[0].document.forms[0].pagecloseind.value != \"1\" )\n\t\t\t{\t\n\t\t\t    parent.frames[2].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'; \t\t\t\t\n\n\t\t\t\t/*\n\t\t\t\tvar dialogHeight\t= \"50vh\" ;\n\t\t\t\tvar dialogWidth\t\t= \"50vw\" ;\n\t\t\t\tvar dialogTop\t\t= \"1\";\n\t\t\t\tvar center\t\t\t= \"1\";\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar features\t\t= \"dialogHeight:\"  + dialogHeight + \n\t\t\t\t\t\t\t\t\t  \"; dialogWidth:\" + dialogWidth + \t\n\t\t\t\t\t\t\t\t\t  \"; center: \"\t   + center + \n\t\t\t\t\t\t\t\t\t  \"; status: \"\t   + status\t+ \n\t\t\t\t\t\t\t\t\t  \"; dialogTop :\"  + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tvar retVal = await window.showModalDialog(\'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',arguments,features); \n\t\t\t\t*/\n\n\t\t\t\treturn;\t\t\t\n\n\t\t\t}\t\t\t\n\t\t}\n\n\t\tfunction calldfltslmt(val)\n\t\t{\n\t\t\tshow_valid_button();\t\t\t\t\n\t\t\tvar str = val;\n\t\t\tvar obj=str.substring(0,2);\t\t\t\t\t\t\t\t\n\t\t\tvar v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\n\t\t\tvar function_id = document.forms[0].function_id.value;\n\t\t\tvar rec_ref=parent.frames[0].document.forms[0].rec_ref.value;\n\t\t\tvar patientid = document.forms[0].patientid.value;\t//Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\tvar coupon_yn = obj.charAt(3); //V210113\n\t\t\tif (obj.charAt(2) != \"Y\" && obj != \"\" && v_billslmtamt != \"\")\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLBillSlmtType2.jsp?slmttype=\"+obj+\"&slmtidno=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&slmtpayername=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&billdoctypecode=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&billslmtamt=\"+v_billslmtamt+\"&function_id=\"+function_id+\"&rec_ref=\"+rec_ref+\"&patientid=\"+patientid+\"&coupon_yn=\"+coupon_yn; //V210113 \n\t\t\t\t//patientid - Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t}\t\n\n\t\t\tif ( v_billslmtamt == \"\" && str != \"\")\n\t\t\t{\n\t\t\t\tparent.frames[0].document.forms[0].slmttype.value = \"\";\n\t\t\t\t//alert(\"Settlement Amount cannot be blank\");\t\t\t\t\t\n\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\t\t\t\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\tfunction callslmt(val)\n\t\t{\t\t\t\t\t\n\t\t\t//disp_valid_button();\t\t\t\t\n\t\t\tvar str =document.forms[0].slmttype.value;\t\n\t\t\tvar action_ind = document.forms[0].action_ind.value;\n\t\t\tvar obj=str.substring(0,2);\t\t\t\t\n\t\t\tvar slmt_flag=str.charAt(2);\t\t\t\t\t\n\t\t\tvar v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\n\t\t\tvar querystring =document.forms[0].querystring.value;\t\n\t\t\tstrscashcountercode=document.forms[0].strscashcountercode.value;\n\t\t\tcredit_card_approvd_YN=document.forms[0].credit_card_approvd_YN.value;\n\t\t\tfield_separator=document.forms[0].field_separator.value;\n\t\t\tpiped_op=document.forms[0].piped_op.value;\n\t\t\t//var warning_message_text = str.substring(3,str.length);\t\n\t\t\tvar warning_message_text = str.substring(4,str.length);\t\n\t\t\tvar function_id = document.forms[0].function_id.value;\t\t\t\t\n\t\t\tvar rec_ref=parent.frames[0].document.forms[0].rec_ref.value;\n\t\t\tvar patientid = document.forms[0].patientid.value; //patientid - Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\tvar coupon_yn = str.charAt(3);\t\t\t\t\t//V210113\n\t\t\tvar siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value; //V210224\n\t\t\tvar billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value; //V210224\n\t\t\tif(val==\'Y\' && warning_message_text != \"\")\n\t\t\t{\n\t\t\t\talert(warning_message_text);\n\t\t\t}\t\t\t\t\n\n\t\t\t//V210224 start\n\t\t\t if (siteCouponInSlmt == \"true\" && coupon_yn == \"Y\" && slmt_flag == \"D\" && action_ind ==\"modify\"){\t\t\t\t\t\n\t\t\t\t \tparent.frames[0].document.forms[0].billslmtamt.readOnly = \"true\";\n\t\t\t}else if (siteCouponInSlmt == \"true\" && coupon_yn == \"Y\" && slmt_flag == \"D\" && action_ind ==\"add\"){\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.value = \"\";\t\t\t\t\t\t\t\t\t \n\t\t\t\t \tparent.frames[0].document.forms[0].billslmtamt.readOnly = \"true\";\n\t\t\t}else {\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.value = billpayableamt;\n\t\t\t\tv_billslmtamt = billpayableamt;\n\t\t\t\tif(parent.frames[0].document.forms[0].billslmtamt.readOnly ==\'true\')\n\t\t\t\t \tparent.frames[0].document.forms[0].billslmtamt.readOnly = \"false\";\n\t\t\t}\n\t\t\t// V210224 end\n\t\t\tif (obj.charAt(2) != \"Y\" && obj != \"\" && ((siteCouponInSlmt == \"true\" && coupon_yn == \"Y\" && slmt_flag == \"D\") || v_billslmtamt != \"\"  ))\n\t\t\t//if (obj.charAt(2) != \"Y\" && obj != \"\" && v_billslmtamt != \"\" ) //V210224 commented\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLBillSlmtType2.jsp?slmttype=\"+obj+\"&slmtidno=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&strscashcountercode=\"+strscashcountercode+\"&billslmtamt=\"+v_billslmtamt+\"&field_separator=\"+field_separator+\"&piped_op=\"+piped_op+\"&credit_card_approvd_YN=\"+credit_card_approvd_YN+\"&slmt_change=\"+val+\"&slmt_flag=\"+slmt_flag+\"&function_id=\"+function_id+\"&\"+querystring+\"&rec_ref=\"+rec_ref+\"&patientid=\"+patientid+\"&coupon_yn=\"+coupon_yn;\n\t\t\t\t//patientid - Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t}\t\n\n\n\t\t\t//if ( v_billslmtamt == \"\" && str != \"\") //V210224 commented\n\t\t\tif ( v_billslmtamt == \"\" && str != \"\" && !(siteCouponInSlmt == \"true\" && coupon_yn == \"Y\" && slmt_flag == \"D\")) //V210224\n\t\t\t{\n\t\t\t\tparent.frames[0].document.forms[0].slmttype.value = \"\";\n\t\t\t\t//alert(\"Settlement Amount cannot be blank\");\t\t\t\t\t\n\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\t\t\t\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\tfunction putdeci(object)\n\t\t{\t\n\t\t\tif(object.value!=\'\')\n\t\t\t{\n\t\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\t\tputDecimal(object,17,decimal);\n\t\t\t}\n\t\t}\n\n\t\tfunction disableAllElements_billslmt_remove()\n\t\t{\t\n\t\t\tvar action_ind=document.forms[0].action_ind.value;\n\t\t\tif(action_ind==\"remove\")\n\t\t\t{\n\t\t\t\tvar len = document.forms[0].elements.length;\n\t\t\t\tfor(var i=0;i<len;i++)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].elements(i).disabled=true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tfunction ChkNumberInput1(fld, e, deci,sn)\n\t\t{\n\t\t\tvar strCheck =\"\";\n\t\t\tif(document.forms[0].billpayableamt.value < 0)\n\t\t\t{\n\t\t\t\tif (parseInt(deci)>0)\n\t\t\t\t\tstrCheck = \'-.0123456789\';\n\t\t\t\telse\n\t\t\t\t\tstrCheck = \'-0123456789\';\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif (parseInt(deci)>0)\n\t\t\t\t\tstrCheck = \'.0123456789\';\n\t\t\t\telse\n\t\t\t\t\tstrCheck = \'0123456789\';\t\n\t\t\t}\n\t\t\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\t\t\tif (whichCode == 13) return true;  // Enter\n\n\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\n\t\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\t\tif(key == \".\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'.\' char\n\t\t\t//if(key == \"-\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'-\' char\n\t\t}\n\n\n\n\t\t/*function disp_valid_button()\n\t\t{\t\n\t\t\n\t\tvar str = document.forms[0].slmttype.value; \t\t\t\t\t\n\t\t var cashslmtflag =str.charAt(2)\n\t\t\tif(cashslmtflag==\'A\')\n\t\t\t{\t\t\t\n\t\t\t\tif(document.forms[0].billpayableamt.value != \'\')\n\t\t\t\t{\t\t\n\t\t\t\t\tdocument.getElementById(\'show_button\').style.display=\'inline\';\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t\tdocument.getElementById(\'show_button\').style.display=\'none\';\n\t\t\t\n\n\t\t}*/\n\t\tfunction show_valid_button()\n\t\t{\t\t\n\t\t\tif(document.forms[0].cc_approval_check_YN.value == \"Y\")\t\t\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'show_button\').style.display=\'inline\';\n\t\t\t\tvar mess_const_for_cc_mc=document.forms[0].mess_const_for_cc_mc.value;\n\t\t\t\tvar slmttype = document.forms[0].slmttype.value;\n\n\n\n\t\t\t\tif(document.forms[0].cc_trx_approved_YN.value == \"N\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[4].location.href=\'../../eBL/jsp/BLCreditCardInterfaceValidation.jsp?mess_const_for_cc_mc=\'+encodeURIComponent(mess_const_for_cc_mc)+\'&slmttype=\'+slmttype;\n\t\t\t\t}\n\n\t\t\t}\n\t\t\t\n\t\t}\n\n\t\tfunction validate_cc_tranx(obj)\n\t\t{\n\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/process.jsp\';\n\t\t\tvar str = document.forms[0].slmttype.value; \t\t\t\t\t\n\t\t\tvar cashslmtflag =str.charAt(2);\n\n\t\t\tif (obj == \"validate_cc_pymt\"){\n\n\t\t\t\tcreditCardForm=\tparent.frames[1].document.forms[0];\n\n\t\t\t\tcreditCardForm.credit_card_batch_id.value=\"\";\n\t\t\t\tcreditCardForm.credit_card_roc_no.value=\"\";\n\t\t\t\tcreditCardForm.credit_trn_status.value=\"N\";\n\t\t\t\t\n\t\t\t\t//Added by Sethu for KDAH-CRF-0535 on 07/01/2020\n\t\t\t\tcreditCardForm.cc_request_type.value=\"WITHDRAW_MONEY\";\n\n\t\t\t\tvar status_btn = parent.frames[0].document.getElementById(\"validate_cc_status\");\n\n\t\t\t\tif (status_btn)\n\t\t\t\t\tstatus_btn.disabled = true;\n\n\t\t\t\tparent.frames[0].document.getElementById(\'show_button_status\').style.display=\'inline\';\n\n\t\t\t}\n\t\t\t\n\t\t\t//Added by Sethu for KDAH-CRF-0535 on 07/01/2020\n\t\t\tif (obj == \"validate_cc_status\"){\n\t\t\t\tcreditCardForm=\tparent.frames[1].document.forms[0];\t\t\t\t\n\t\t\t\tcreditCardForm.cc_request_type.value=\"CHECK_STATUS\";\t\n\t\t\t}\n\n\t\t\tif(document.forms[0].billslmtamt.value != \'\' && cashslmtflag == \'A\')\n\t\t\t{\t\t\t\n\t\t\t\tdocument.forms[0].cc_approval_check_YN.value=\'Y\';\t\t\t\t\t\t\t\t\n\t\t\t\tdocument.forms[0].submit();\n\t\t\t}\t\t\n\n\t\t}\n\n\t</script>\t   \n</HEAD>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<BODY\tonLoad=\"callslmt();show_valid_button();disableAllElements_billslmt_remove()\"  onUnload=\"billslmtprocessclose();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" >\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\n\t<!--<BODY\tonLoad=\"dfltslmt();callslmt(\'Y\');\"  onUnload=\"billslmtprocessclose();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" >-->\n\t\t<BODY\tonLoad=\"dfltslmt();\"  onUnload=\"billslmtprocessclose();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" >\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<FORM name=\'BillSlmtDetForm\' id=\'BillSlmtDetForm\' method=\'post\'  action=\'../../eBL/jsp/BLBillSlmtDet2.jsp\'  scrolling=\'NO\' >\n\t\n\t\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\t \n<!--\n\t<tr>\n<!--\t<td class=\"label\" width=\"25%\">Bill No</td>\t \n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\t \n\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billdoctype\" id=\"billdoctype\" SIZE=\"7\" MAXLENGTH=\"10\" \t\t\t\tVALUE=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  style=\'text-align:left\'> / <INPUT TYPE=\"TEXT\" \n\tREADONLY name=\"billdocnum\" id=\"billdocnum\" SIZE=\"8\" MAXLENGTH=\"10\"  VALUE=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' style=\'text-align:right\'></td>\n<!--\t<td class=\"label\" width=\"25%\">Payable Amount</td>\t\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\t\n\t<!--\n\t<td>&nbsp;<INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"8\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  style=\'text-align:right\'>&nbsp;<INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"  OK  \" onClick=\'billslmtprocess()\'><td> \t\n\t\n\n\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  style=\'text-align:right\'></td> \t\n\t</tr> -->\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<tr>\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\t\n<!--\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billpayableamt\" id=\"billpayableamt\" SIZE=\"15\" MAXLENGTH=\"20\" \t\t\t\t\tVALUE=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  style=\'text-align:right\' ></td> -->\t\n\t\t\t<td class=\"label\" width=\"25%\" ><div >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</div></td>\n\t\t\t<INPUT TYPE=\"hidden\"  name=\"billpayableamt\" id=\"billpayableamt\"\tVALUE=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\n\t\t\t<td class=\"fields\" width=\"25%\"></td>\n\t\t\t<td class=\"fields\" width=\"25%\"></td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\t\n\t\t\t<td class=\"label\" width=\"25%\"><div >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\t\n\t\t\t<td class=\"fields\" width=\"25%\"></td>\n\t\t\t<td class=\"fields\" width=\"25%\"></td>\n\t\t\t</tr>\n\t\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<tr>\t\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n<!--\t\t<td class=\"label\" width=\"25%\">Amount Settled</td>\t-->\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" name=\"billslmtamt\" id=\"billslmtamt\" SIZE=\"14\" MAXLENGTH=\"10\" \tVALUE=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\' onBlur=\'return checkslmtamt(this);checkForNumber(this);\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="> </td>\t<!--V220803-->\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n<!--\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billslmtamt\" id=\"billslmtamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,2))\' onBlur=\'return checkslmtamt();\'> </td>\t\n-->\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'  style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,document.forms[0].noofdecimal.value))\' onBlur=\'return checkslmtamt(this);checkForNumber(this);\'> </td>\t<!--V220803-->\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<!--\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\" READONLY name=\"billslmtamt\" id=\"billslmtamt\" SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'  style=\'text-align:right\' onBlur=\'return checkslmtamt();\'> </td>\t\n-->\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n<!-- \t<td width=\"25%\"  class=\"label\" >Settlement Type<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'></td> -->\n \t\t\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'></td>\n\t\t\t<td width=\"25%\" class=\"fields\" ><select name=\'slmttype\' id=\'slmttype\' onChange=\'callslmt(\"Y\")\' ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="---</option>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\t//alert(\"eee\");\n\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\';\n\t\t\t\t\t\talert(v_error);\t\t\t\t \n\t\t\t\t\t </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t\t\t\n\t\t\t\t</select>\t\n\t\t\t\t<!-- <td class=\"label\"> </td> -->\n<!--\n\t\t\t\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<div id=\'show_button\' style=\'display:inline\'>\n\t\t\t\t\t<input type=\'button\' name=\'validate_cc_pymt\' id=\'validate_cc_pymt\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" class=\'button\' onClick=\'validate_cc_tranx()\' disabled> \n\t\t\t\t</div>\t\t\t\t\n\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t<div id=\'show_button_status\' style=\'display:inline\'>\n\t\t\t\t<input type=\'button\' name=\'validate_cc_status\' id=\'validate_cc_status\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" class=\'button\' onClick=\'validate_cc_tranx()\' disabled>  \n\t\t\t\t</div>\n\t\t\t\t\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n\t\t\t\t<div id=\'show_button\' style=\'display:none\'>\n\t\t\t\t\t<input type=\'button\' name=\'validate_cc_pymt\' id=\'validate_cc_pymt\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" class=\'button\'onClick=\'validate_cc_tranx()\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =">\n\t\t\t\t</div>\n\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t<div id=\'show_button_status\' style=\'display:none\'>\n\t\t\t\t<input type=\'button\' name=\'validate_cc_status\' id=\'validate_cc_status\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" class=\'button\' onClick=\'validate_cc_tranx()\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n\t\t\t\t</div>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n-->\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td width=\"25%\" class=\"fields\" >&nbsp;</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\" >&nbsp;</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\" colspan=\"2\" align=\"\">\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t<div id=\'show_button\' style=\'display:inline\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'validate_cc_pymt\' id=\'validate_cc_pymt\' id=\'validate_cc_pymt\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" class=\'button\' onClick=\"validate_cc_tranx(this.id)\" disabled> \n\t\t\t\t\t</div>\t\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<div id=\'show_button_status\' style=\'display:inline\'>\n\t\t\t\t\t<input type=\'button\' name=\'validate_cc_status\' id=\'validate_cc_status\' id=\'validate_cc_status\'  value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" class=\'button\' onClick=\"validate_cc_tranx(this.id)\" disabled>  \n\t\t\t\t\t</div>\t\t\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t<div id=\'show_button\' style=\'display:none\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'validate_cc_pymt\' id=\'validate_cc_pymt\' id=\'validate_cc_pymt\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" class=\'button\' onClick=\"validate_cc_tranx(this.id)\" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t\t\t</div>\t\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<div id=\'show_button_status\' style=\'display:none\'>\n\t\t\t\t\t<input type=\'button\' name=\'validate_cc_status\' id=\'validate_cc_status\' id=\'validate_cc_status\'  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" class=\'button\' onClick=\"validate_cc_tranx(this.id)\" disabled>\n\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t</td>\n\t<!--\n\t\t\t\t<td width=\"25%\" class=\"fields\">\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\t\t\t\t\t\n\t\t\t\t\t<div id=\'show_button_status\' style=\'display:inline\'>\n\t\t\t\t\t<input type=\'button\' name=\'validate_cc_status\' id=\'validate_cc_status\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" class=\'button\' onClick=\'validate_cc_tranx()\' disabled>  \n\t\t\t\t\t</div>\t\t\t\t\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\t\t\t\t\t\n\t\t\t\t\t<div id=\'show_button_status\' style=\'display:none\'>\n\t\t\t\t\t<input type=\'button\' name=\'validate_cc_status\' id=\'validate_cc_status\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =">\n\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t</td>\n\t\t\t\t-->\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td colspan=\"4\" >&nbsp;</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t\n\n\t\t</table> \n\t<INPUT TYPE=\"HIDDEN\" name=\"pagecloseind\" id=\"pagecloseind\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"0\">\t\t\n\t<INPUT TYPE=\"HIDDEN\" name=\"dfltslmttypecode\" id=\"dfltslmttypecode\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' >\t \n\t<INPUT TYPE=\"HIDDEN\" name=\"slmtdate\" id=\"slmtdate\"\t   SIZE=\"20\" MAXLENGTH=\"20\" \tVALUE=\"\"> \n\t<INPUT TYPE=\"HIDDEN\" name=\"slmtdocrefdesc\" id=\"slmtdocrefdesc\" SIZE=\"50\" MAXLENGTH=\"100\"\tVALUE=\"\">\t\n\t<INPUT TYPE=\"HIDDEN\" name=\"slmtdocref\" id=\"slmtdocref\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"\">\t \n\t<!--<INPUT TYPE=\"HIDDEN\" name=\"slmt_type_short_desc\" id=\"slmt_type_short_desc\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">-->\n\t<INPUT TYPE=\"HIDDEN\" name=\"querystring\" id=\"querystring\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t<INPUT TYPE=\"HIDDEN\" name=\"total_amt_payable\" id=\"total_amt_payable\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' >\n\t<input type=\'hidden\' name=\'rec_ref\' id=\'rec_ref\' id=\'rec_ref\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' >\n\t\n\t<input type= hidden name=\"action_ind\" id=\"action_ind\"  value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t<input type= hidden name=\"strscashcountercode\" id=\"strscashcountercode\"  value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t<input type=\'hidden\' name=\'total_settled_amt\' id=\'total_settled_amt\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t<input type=\'hidden\' name=\'settled_amt_det\' id=\'settled_amt_det\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t<input type=\'hidden\' name=\'cashcounter\' id=\'cashcounter\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t<input type=\'hidden\' name=\'slmtidno\' id=\'slmtidno\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t<input type=\'hidden\' name=\'loggeduser\' id=\'loggeduser\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\t<input type=\'hidden\' name=\"slmtpayername\" id=\"slmtpayername\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\'hidden\' name=\'visitid\' id=\'visitid\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n\t<input type=\'hidden\' name=\'episodeid\' id=\'episodeid\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n\t<input type=\'hidden\' name=\'episodetype\' id=\'episodetype\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n\t<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t<input type=\'hidden\' name=\'billdocnum\' id=\'billdocnum\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t<input type=\'hidden\' name=\'billdoctypecode\' id=\'billdoctypecode\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t<input type=\'hidden\' name=\'mess_const_for_cc_mc\' id=\'mess_const_for_cc_mc\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t<input type=\'hidden\' name=\'credit_card_approvd_YN\' id=\'credit_card_approvd_YN\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t<input type=\'hidden\' name=\'cc_approval_check_YN\' id=\'cc_approval_check_YN\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t<input type=\'hidden\' name=\'cc_trx_approved_YN\' id=\'cc_trx_approved_YN\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t<input type=\'hidden\' name=\'mesg_frm_cc_mc\' id=\'mesg_frm_cc_mc\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t<input type=\'hidden\' name=\'p_strslmtamt\' id=\'p_strslmtamt\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n\t<input type=hidden name=\'str_credit_card_machine_int_yn\' id=\'str_credit_card_machine_int_yn\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\n\t<input type=\'hidden\' name=\'field_separator\' id=\'field_separator\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t<input type=\'hidden\' name=\'piped_op\' id=\'piped_op\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\n\t<input type=\'hidden\' name=\'warning_message_text\' id=\'warning_message_text\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n<!-- \t\tGHL-CRF-0366.1 Karthik added the below code for Credit Card Integration -->\n\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t<input type=\'hidden\' name=\'strclientip\' id=\'strclientip\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t<input type=\'hidden\' name=\'moduleid\' id=\'moduleid\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t<input type=\'hidden\' name=\'responsibility_id\' id=\'responsibility_id\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\n\t\n\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\n\t<input type=\'hidden\' name=\'p_doc_date\' id=\'p_doc_date\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\t\n\t<input type=\'hidden\' name=\'prepaid_card_number\' id=\'prepaid_card_number\' value=\'\'>\n\t<input type=\'hidden\' name=\'receipt_date\' id=\'receipt_date\' value=\'\'>\n\t<input type=\'hidden\' name=\'receipt_number\' id=\'receipt_number\' value=\'\'>\n\t<input type=\'hidden\' name=\'trn_type\' id=\'trn_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'trn_number\' id=\'trn_number\' value=\'\'>\n\t<input type=\'hidden\' name=\'ext_input_key\' id=\'ext_input_key\' value=\'\'>\n\t<input type=\'hidden\' name=\'ext_application_id\' id=\'ext_application_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'ext_function\' id=\'ext_function\' value=\'\'>\n\t<input type=\'hidden\' name=\'slmt_type_code\' id=\'slmt_type_code\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n<!-- \tGHL-CRF-0366.1 Karthik added the below code for Credit Card Integration -->\n\t<input type=\'hidden\' name=\'slmt_check_status\' id=\'slmt_check_status\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t<input type=\'hidden\' name=\'siteCouponInSlmt\' id=\'siteCouponInSlmt\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t\n</FORM>\t\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);


	request.setCharacterEncoding("UTF-8");   
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	 //V220404
	System.err.println("BLBillSlmtDet2.jsp");
	String strdfltslmttypecode = "";
	String locale	= (String)session.getAttribute("LOCALE");
	String short_desc ="";String querystring="";
	String strbillpayableamt="";//String p_total_amt_payable="";
	int noofdecimal=2;	

	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rscurr            = null;

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String strclientip = p.getProperty("client_ip_address");
	con	=	ConnectionManager.getConnection(request);
	
	String sqlStmtType="", strbilldoctypecode="",strbilldocnum="",strfacilityid="",strpatientid="",strepisodetype="",strepisodeid="",strvisitid="",strslmtpayername="",struser="",strslmtidno="",strcashcounter="",total_settled_amt="",p_settled_amt_det="",action_ind="",rec_ref="";
	String str_v_payable_amt="0.00",strscashcountercode="",p_slmttype="",p_strslmtamt = "", str_remaining_amt="";			
	String strslmtamt = "",readonly1="", p_billdoctypecode="",str_v_mod_payable_amt="0.00";			
	double v_payable_amt=0; double v_mod_payable_amt=0;	
	String cc_type="",mess_const_for_cc_mc="",cc_approval_check_YN="N",cc_trx_approved_YN="N";
	String p_field_separator="",p_piped_op="",p_errtext="";
	String mesg_frm_cc_mc="",credit_card_approvd_YN="N";
	String str_credit_card_machine_int_yn="",str_credit_card_machine_id="",str_err_code="",str_error_text="",str_sys_message_id="";
	String cash_slmt_flag="";String slmt_type_code="";
	String coupon_yn = "";//V210113
	String warning_message_text = "";

	String function_id="";
	
	//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
	String slmt_check_status = "N";

	String standard_code = "", segment_id = "";
	boolean siteCouponInSlmt = CommonBean.isSiteSpecific(con, "BL", "TO_ENABLE_COUPON_IN_SETTLEMENT");	//V210224

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	//Added by Manivel Natarajan on 10/Aug/2006	
	try
	{
		p_slmttype=request.getParameter("slmttype");	
		
		if ( p_slmttype == null || p_slmttype.equalsIgnoreCase("null")) 
			{p_slmttype ="";}
		//System.err.println("p_slmttype in Det2sp:"+p_slmttype);
		cc_approval_check_YN=request.getParameter("cc_approval_check_YN");
		if(cc_approval_check_YN == null) cc_approval_check_YN="N";		

		strbilldoctypecode = request.getParameter("billdoctypecode");
		strbilldocnum = request.getParameter("billdocnum");	
		strbillpayableamt = request.getParameter("billpayableamt");			
		strfacilityid = request.getParameter("facilityid");	
		strpatientid  = request.getParameter("patientid");	
 		strepisodetype = request.getParameter("episodetype");	
		strepisodeid = request.getParameter("episodeid");
		strvisitid = request.getParameter("visitid");				
		strslmtpayername = request.getParameter("slmtpayername");	
		struser = request.getParameter("loggeduser");	
		strslmtidno = request.getParameter("slmtidno");
		strcashcounter = request.getParameter("cashcounter");
		//String strdfltcashbillslmtamt = "";		String strrcptallowedyn = "";
		//String strchangereceiptamtind = "";		String strrcptallowedynuser = "";
		//String strchangereceiptalloweduser = "";	//String strslmttype= request.getParameter("slmttype");	
		querystring=(String)request.getQueryString();
		action_ind=request.getParameter("action");	
		if(action_ind==null || action_ind.equals("")) action_ind="";		
		p_settled_amt_det=request.getParameter("settled_amt_det");
		rec_ref=request.getParameter("rec_ref");
	
		if ( p_settled_amt_det == null || p_settled_amt_det.equalsIgnoreCase("null") || p_settled_amt_det.equals("")) 
			{p_settled_amt_det ="0.0";}		
		total_settled_amt=request.getParameter("total_settled_amt");
		if ( total_settled_amt == null || total_settled_amt.equalsIgnoreCase("null") || total_settled_amt.equals("")) 
			{total_settled_amt ="0.0";}
		v_payable_amt=Double.parseDouble(p_settled_amt_det)-Double.parseDouble(total_settled_amt);		
		str_v_payable_amt=String.valueOf(v_payable_amt);

		function_id = request.getParameter("function_id");
		if(function_id == null) function_id="";
		
//02-01-09
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
		{
			System.err.println("3 from det 2="+e.toString());
			e.printStackTrace();
		}

		CurrencyFormat cf = new CurrencyFormat();
		str_v_payable_amt = cf.formatCurrency(str_v_payable_amt, noofdecimal);	
		str_remaining_amt=str_v_payable_amt;
		
		if(action_ind.equals("modify")||action_ind.equals("remove"))
		{
			//if(p_slmttype.equals("CCA")) {readonly1="disabled";}		
			p_strslmtamt=request.getParameter("billslmtamt");
			if(p_strslmtamt.equals("")) p_strslmtamt="";		
			v_mod_payable_amt=Double.parseDouble(p_strslmtamt)+v_payable_amt;		
			str_v_mod_payable_amt=String.valueOf(v_mod_payable_amt);
			//CurrencyFormat cf = new CurrencyFormat();
			str_v_mod_payable_amt = cf.formatCurrency(str_v_mod_payable_amt, noofdecimal);
		}
		p_billdoctypecode=request.getParameter("billdoctypecode");
		if ( p_billdoctypecode == null || p_billdoctypecode.equalsIgnoreCase("null") || p_billdoctypecode.equals("")) 
				{p_billdoctypecode ="";}

		if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null") || p_billdoctypecode.equals("")) 
				{strbilldoctypecode ="";}

		if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")|| strbilldocnum.equals("")) 
				{strbilldocnum = "";}

		if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")|| strbillpayableamt.equals("")) 
				{strbillpayableamt = "";}

		if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")|| strfacilityid.equals("")) 
				{strfacilityid = "";}

		if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")|| strpatientid.equals("")) 
				{strpatientid = "";}

		if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")|| strepisodetype.equals("")) 
				{strepisodetype = "";}


		if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")|| strepisodeid.equals("")) 
				{strepisodeid = "";}

		if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";

		if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")|| strslmtpayername.equals(""))  
				{strslmtpayername = "";}

		if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")|| strslmtidno.equals("")) strslmtidno = "";

		if ( struser == null || struser.equalsIgnoreCase("null") || struser.equals("")) struser = "";

		if ( strcashcounter == null || strcashcounter.equalsIgnoreCase("null")|| strcashcounter.equals("")) 
					strcashcounter ="";
		if(cc_approval_check_YN.equals("Y"))
		{
			str_v_payable_amt=request.getParameter("billslmtamt");
			if(str_v_payable_amt == null) str_v_payable_amt="";
			cc_trx_approved_YN=request.getParameter("cc_trx_approved_YN");
			if(cc_trx_approved_YN == null) cc_trx_approved_YN="N";
			mesg_frm_cc_mc=request.getParameter("mesg_frm_cc_mc");
			if(mesg_frm_cc_mc == null) mesg_frm_cc_mc="";
			strbillpayableamt = request.getParameter("billpayableamt");	
			if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
			{strbillpayableamt = "";}			
			action_ind=request.getParameter("action_ind");	
			if(action_ind==null || action_ind.equals("")) action_ind="";	

			//p_strslmtamt=request.getParameter("p_strslmtamt");	
			//if(p_strslmtamt==null || p_strslmtamt.equals("")) p_strslmtamt="";	
			p_strslmtamt=request.getParameter("billslmtamt");
			if(p_strslmtamt.equals("")) p_strslmtamt="";		

			str_v_mod_payable_amt=request.getParameter("billpayableamt");
			if(str_v_mod_payable_amt.equals("")) str_v_mod_payable_amt="";		
		}
			
		if(cc_trx_approved_YN.equals("Y"))
		{
			try
			{
				CallableStatement  call = con.prepareCall("{ call BL_CREDIT_CARD.CONSTRUCT_IN_MESSAGE(?,?,?,?,?,?) }");

				call.setString(1,mesg_frm_cc_mc);// Message recd from CC Machine
				call.setString(2,locale);
				call.registerOutParameter(3,java.sql.Types.VARCHAR);
				call.setString(4,"J"); // Platform Type - J- Java					
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);

				call.execute();

				p_field_separator=call.getString(3);
				if(p_field_separator == null) p_field_separator="";

				p_piped_op=call.getString(5);					
				if(p_piped_op == null) p_piped_op="";
				p_errtext=call.getString(6);
				if(p_errtext == null) p_errtext="";

				call.close();
				if(!p_errtext.equals(""))
				{
					credit_card_approvd_YN="N";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_errtext));
            _bw.write(_wl_block10Bytes, _wl_block10);


				}
				else
				{
					credit_card_approvd_YN="Y";		
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception while calling BL_CREDIT_CARD.CONSTRUCT_IN_MESSAGE:"+e);
				e.printStackTrace();
			}

		}
		//end of credit card interface
		/*	
		try
		{				
			pstmt = con.prepareStatement(" select nvl(dflt_cash_bill_slmt_amt,'N') from bl_parameters where operating_facility_id = '" + strfacilityid + "'");

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

		*/
   
		try
		{
			//pstmt = con.prepareStatement(" select slmt_type_code from BL_EPISODE_FIN_DTLS where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "' and visit_id = '"+ strvisitid +"' and patient_id='"+strpatientid+"'");	   
			//added by rammohan for defult slmt type 
			if(strepisodetype.equals("D") || strepisodetype.equals("I"))
			{
				//sqlStmtType="select slmt_type_code from BL_EPISODE_FIN_DTLS where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "'  and patient_id='"+strpatientid+"'";
				
				pstmt = con.prepareStatement("select slmt_type_code from BL_EPISODE_FIN_DTLS where operating_facility_id = ? and episode_type = ? and episode_id = ?  and patient_id=?");
				
				pstmt.setString(1,strfacilityid);
				pstmt.setString(2,strepisodetype);
				pstmt.setString(3,strepisodeid);
				pstmt.setString(4,strpatientid);
				
			}
			else if(strepisodetype.equals("O") || strepisodetype.equals("E"))
			{			
				//sqlStmtType="select slmt_type_code from BL_VISIT_FIN_DTLS where operating_facility_id = '" + strfacilityid + "' and episode_type = '" + strepisodetype + "' and episode_id = '" + strepisodeid + "' and visit_id = '"+ strvisitid +"' and patient_id='"+strpatientid+"'";
				
				pstmt = con.prepareStatement("select slmt_type_code from BL_VISIT_FIN_DTLS where operating_facility_id = ? and episode_type = ? and episode_id = ? and visit_id = ? and patient_id=?");
				
				pstmt.setString(1,strfacilityid);
				pstmt.setString(2,strepisodetype);
				pstmt.setString(3,strepisodeid);
				pstmt.setString(4,strvisitid);
				pstmt.setString(5,strpatientid);
				
			}
			else if(strepisodetype.equals("R"))
			{
			//	sqlStmtType="select slmt_type_code from BL_PATIENT_FIN_DTLS where patient_id='"+strpatientid+"'";
				pstmt = con.prepareStatement("select slmt_type_code from BL_PATIENT_FIN_DTLS where patient_id= ? ");
				pstmt.setString(1,strpatientid);
				
			}		
		//	pstmt = con.prepareStatement(sqlStmtType);
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null ) 
			{
				strdfltslmttypecode =  rs.getString(1);						
			}
			else
			{
				strdfltslmttypecode = "";
			}
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();	
		}
		catch(Exception e) 
		{ }
		/*finally 
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 	
		}*/	

		if ( strdfltslmttypecode == null || strdfltslmttypecode.equalsIgnoreCase("null")) 
				strdfltslmttypecode = "";

//end
		/*
		try
		{		
			pstmt = con.prepareStatement(" select nvl(op_applicable_ind,'N'),nvl(change_receipt_amt_ind,'N') from  bl_cash_counter where cash_counter_code = '" + strcashcounter + "' and operating_facility_id = '" + strfacilityid + "'");

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
		*/

		/*
		try
		{		
			pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = '" + strfacilityid + "' and credit_auth_user_id = '" + struser + "'");

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
			//ConnectionManager.returnConnection(con, request);	
		}	

		if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
		   strrcptallowedynuser = "N";

		if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
		   strchangereceiptalloweduser = "N";	
		*/

		/*	
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
		*/
		//COMMENTED ON 02/01/09 ADD AT LINE 132
		/*try{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			rscurr.close();
			pstmt.close();
		}catch(Exception e) {System.err.println("3 from det 2="+e.toString());}*/
		//COMMENT END

		/*p_total_amt_payable=request.getParameter("total_amt_payable");
		if ( p_total_amt_payable == null || p_total_amt_payable.equalsIgnoreCase("null")) 
		{p_total_amt_payable ="";}
		CurrencyFormat cf = new CurrencyFormat();
		p_total_amt_payable = cf.formatCurrency(p_total_amt_payable, noofdecimal);*/


            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(URLEncoder.encode(strslmtpayername)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(URLEncoder.encode(strslmtpayername)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block27Bytes, _wl_block27);

	if(action_ind.equals("modify")||action_ind.equals("remove")||credit_card_approvd_YN.equals("Y"))	
	{

            _bw.write(_wl_block28Bytes, _wl_block28);

	}
	else
	{
	
            _bw.write(_wl_block29Bytes, _wl_block29);

	}


            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block36Bytes, _wl_block36);
		if(action_ind.equals("modify"))
		{
		//p_total_amt_payable

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(str_v_mod_payable_amt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(str_v_mod_payable_amt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_v_mod_payable_amt));
            _bw.write(_wl_block41Bytes, _wl_block41);

		}else{

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(str_remaining_amt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_remaining_amt));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}

            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
if(action_ind.equals("modify") || action_ind.equals("remove"))
			{

            _bw.write(_wl_block2Bytes, _wl_block2);
 
/*
	if (strchangeyn.equals("Y"))
	{ 
*/		

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(p_strslmtamt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block48Bytes, _wl_block48);
 
/*
	} 
	 else
	 {*/
 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(p_strslmtamt));
            _bw.write(_wl_block50Bytes, _wl_block50);
 
//	  } 
			}
			else{

            _bw.write(_wl_block1Bytes, _wl_block1);
 
/*
	if (strchangeyn.equals("Y"))
	{ 
*/

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(str_v_payable_amt));
            _bw.write(_wl_block51Bytes, _wl_block51);
 
/*
	 } 
	 else
	 {
*/
     
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block53Bytes, _wl_block53);
 
//	  }
			}
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block56Bytes, _wl_block56);
 //V210224
			if(!action_ind.equals("modify")) {
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
} 
            _bw.write(_wl_block1Bytes, _wl_block1);


			try {
					//con	=	ConnectionManager.getConnection(request);

					// Cash Counter Check


					String temp_episodetype = "";
					if( strepisodetype.equals("O") || strepisodetype.equals("E"))
					{
						temp_episodetype = "O";
					}
					else if( strepisodetype.equals("I") || strepisodetype.equals("D"))
					{
						temp_episodetype = "I";					
					}
					else 
					{
						temp_episodetype = "R";					
					}

					CallableStatement call = 
					con.prepareCall("{ call bl_user_check_for_cash_counter (?,?,?,?,?,?,?)}");			
					call.setString(1,strfacilityid);
					call.setString(2,temp_episodetype);
					call.setString(3,struser);
					call.setString(4,strclientip);

					call.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.registerOutParameter(7,java.sql.Types.VARCHAR);	

					call.execute();									

					strscashcountercode	 = call.getString(5);	
					String strshiftid	  	     = call.getString(6);		
					String strsysmessageid		 = call.getString(7);		

					call.close();

					String strerrortext = "";

					if ( strscashcountercode == null ) strscashcountercode = "";
					if ( strshiftid == null ) strshiftid = "";
					if ( strsysmessageid == null ) strsysmessageid = "";


					if (!(strsysmessageid.equals("")))
					{
					/*try
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
					{ out.println(e.toString());}	*/
				
					if ( !(strerrortext.equals("")) )
					{
					
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block60Bytes, _wl_block60);

					}		
			      }

				 

// PE Changes					pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag,warning_message_text from bl_slmt_type_lang_vw where language_id='"+locale+"' and status is null and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where 		operating_facility_id =  '"+ strfacilityid + "' and cash_counter_code = '"+ strscashcountercode + "' and status is null) order by short_desc  " ) ;
			//V210224 start
				if(action_ind.equals("modify"))	{
					pstmt = con.prepareStatement("Select slmt_type_code, short_desc, cash_slmt_flag,warning_message_text,coupon_yn from bl_slmt_type_lang_vw where language_id= ? and status is null and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id= ? ) and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where operating_facility_id = ? and cash_counter_code = ? and status is null) and  slmt_type_code = substr( ? ,0,2) and cash_slmt_flag= substr(? ,3) order by short_desc") ;
					
					pstmt.setString(1,locale);
					pstmt.setString(2,strfacilityid);
					pstmt.setString(3,strfacilityid);
					pstmt.setString(4,strscashcountercode);
					pstmt.setString(5,p_slmttype);
					pstmt.setString(6,p_slmttype);
					
				}else{
	//V210224 end
					pstmt = con.prepareStatement("Select slmt_type_code, short_desc, cash_slmt_flag,warning_message_text,coupon_yn from bl_slmt_type_lang_vw where language_id= ? and status is null and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id= ? ) and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where operating_facility_id = ? and cash_counter_code = ? and status is null) order by short_desc") ; //V210113
					
					pstmt.setString(1,locale);
					pstmt.setString(2,strfacilityid);
					pstmt.setString(3,strfacilityid);
					pstmt.setString(4,strscashcountercode);
					

				} //V210224
				
					rs2 = pstmt.executeQuery() ;
					if( rs2 != null ) 
					{
						
						while( rs2.next() ) 
						{
							short_desc="";
							slmt_type_code = rs2.getString( "slmt_type_code" ) ;
							//System.err.println("slmt_type_code121212 " +slmt_type_code);
							short_desc = rs2.getString( "short_desc" ) ;
							cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
//							System.err.println("slmt_type_code121212flag " +cash_slmt_flag);

							warning_message_text=rs2.getString("warning_message_text") ;
							coupon_yn = rs2.getString("coupon_yn"); //V210113
							if ( slmt_type_code == null ) slmt_type_code = "";
							if ( short_desc == null ) short_desc ="";
							if ( cash_slmt_flag == null ) cash_slmt_flag = "";
							if ( warning_message_text == null) warning_message_text = ""; 
							if ( coupon_yn == null) coupon_yn = ""; //V210113
	//						defaulting settlement type from visit fin dtls if exist...					    
							String temp_slmt_type_slmt_flag=slmt_type_code+cash_slmt_flag;
							
							boolean refundChkForCreditcardBlock=false;
							String totalAmtReq=request.getParameter("total_amt_payable");
							if(totalAmtReq==null) totalAmtReq="";
							String ccCheckTotalPayableAmt = ( totalAmtReq.equals("") ) ?"0.0":request.getParameter("total_amt_payable");
							float ccCheckTotalPayableAmtFloat=Float.parseFloat(ccCheckTotalPayableAmt);
							if(ccCheckTotalPayableAmtFloat<0){
								refundChkForCreditcardBlock=true;
							} 


							if( ( slmt_type_code.equals("CC") && refundChkForCreditcardBlock==true ) ){
								//Karthik added the logic to block Creditcard settlement for Refund Cases
							}
							else{

							if(temp_slmt_type_slmt_flag.equals(p_slmttype))
							{									
								out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+""+coupon_yn+""+warning_message_text+"\">"+short_desc+"</option>");	//V210113						
							}
							else
							{				

								out.println("<option  value=\""+slmt_type_code+""+cash_slmt_flag+""+coupon_yn+""+warning_message_text+"\">"+short_desc+"</option>");	//V210113		
							}
							
							}

	//						out.println("<input type=hidden name='slmt_type_short_desc' id='slmt_type_short_desc'  value='"+short_desc+"'>");
			//				out.println("<input type=hidden name='slmt_type_code' id='slmt_type_code'  value='"+slmt_type_code+"'>");
							
														
						}
					}
				
				
				
				}
				catch(Exception e) 
					{
						//out.println(e.toString());
						e.printStackTrace();	
					}



//added 23-10-2007
	try{
			if(cash_slmt_flag.equals("A")){
				//System.err.println("strscashcountercodeAAAA:"+strscashcountercode);
				String ccCheck="{ call BLCOMMON.GET_CREDIT_CARD_INT_DTL(?,?,?,?,?,?,?,?)}";
				//System.err.println("CC Check"+ccCheck);
				CallableStatement call =	con.prepareCall(ccCheck);
				call.setString(1, strfacilityid);  
				call.setString(2, strscashcountercode);  
				call.setString(3, slmt_type_code);  				
				call.registerOutParameter(4,java.sql.Types.VARCHAR);				
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.execute();

				str_credit_card_machine_int_yn = call.getString(4);
				if(str_credit_card_machine_int_yn == null) str_credit_card_machine_int_yn="";

				str_credit_card_machine_id=call.getString(5);
				if(str_credit_card_machine_id == null) str_credit_card_machine_id="";

				str_err_code= call.getString(6);
				if(str_err_code == null) str_err_code="";

				str_error_text= call.getString(7);
				if(str_error_text == null) str_error_text="";

				str_sys_message_id = call.getString(8);
				if(str_sys_message_id == null) str_sys_message_id="";
				
						call.close();
	
			}
		}catch(Exception ee)
		{
			System.err.println("error in CC check"+ee);
			ee.printStackTrace();
		}
		
//end 22-10-2007

				

			//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019
			String stdQuery = "select SEGMENT_ID, STANDARD_CODE from XH_STANDARD_CONTROL_SEG where ELEMENT_ID = 'SETTLEMENT_TYPE' and DEFAULT_VALUE = ? ";

			if (slmt_type_code.length() >0)
			{
				try{						
					pstmt = con.prepareStatement(stdQuery);						
					pstmt.setString(1, slmt_type_code);
					rs2 = pstmt.executeQuery() ;

					if( rs2 != null ) 
					{							
						while( rs2.next() ) 
						{
							segment_id = rs2.getString( "SEGMENT_ID" ) ;
							standard_code = rs2.getString( "STANDARD_CODE" ) ;																
						}
					}					
				}
				catch(Exception ee)
				{
					System.err.println("Error in checking the segment, standard code for the payemnt type ::: "+ee.getMessage());
					ee.printStackTrace();
				}


				if (segment_id.length()>0 && standard_code.length()>0)
				{
					stdQuery = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where SEGMENT_ID = ? and ELEMENT_ID = 'CHECK_TRN_STATUS' and STANDARD_CODE = ? ";

					try{
							
						pstmt = con.prepareStatement(stdQuery);
						
						pstmt.setString(1, segment_id);
						pstmt.setString(2, standard_code);
						rs2 = pstmt.executeQuery() ;

						if( rs2 != null ) 
						{							
							while( rs2.next() ) 
							{
								slmt_check_status = rs2.getString( "DEFAULT_VALUE" ) ;
							}
						}	
						
						
					}
					catch(Exception ee)
					{
						System.err.println("Error in checking the payment type check status flag for the payemnt type::: "+ee.getMessage());
						ee.printStackTrace();
					}							

				}
			}


			try {

				if (rs2 != null)   rs2.close();
				if (pstmt != null) pstmt.close();		 	
				//Moved here in Bangalore on 13/10/2005
				ConnectionManager.returnConnection(con, request);	

			}
			catch(Exception e) {}
			finally 
			{
				if (rs2 != null)   rs2.close();
				if (pstmt != null) pstmt.close();		 	
				//Moved here in Bangalore on 13/10/2005
				ConnectionManager.returnConnection(con, request);	
			}
			
	


            _bw.write(_wl_block61Bytes, _wl_block61);


			if (credit_card_approvd_YN.equals("Y"))
			{

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")));
            _bw.write(_wl_block64Bytes, _wl_block64);
			
			}
			else
			{						

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block69Bytes, _wl_block69);

			}

            _bw.write(_wl_block70Bytes, _wl_block70);

				if (credit_card_approvd_YN.equals("Y"))
				{

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")));
            _bw.write(_wl_block73Bytes, _wl_block73);
			
				}
				else
				{						

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_INFO.label","bl_labels")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")));
            _bw.write(_wl_block77Bytes, _wl_block77);

				}

            _bw.write(_wl_block78Bytes, _wl_block78);

				if (credit_card_approvd_YN.equals("Y"))
				{

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")));
            _bw.write(_wl_block80Bytes, _wl_block80);
			
				}
				else
				{						

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GET_CC_STATUS.label","bl_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(readonly1));
            _bw.write(_wl_block82Bytes, _wl_block82);

				}

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(strdfltslmttypecode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rec_ref));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(action_ind));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strscashcountercode));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(total_settled_amt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(p_settled_amt_det));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strcashcounter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(mess_const_for_cc_mc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(credit_card_approvd_YN));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(cc_approval_check_YN));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(cc_trx_approved_YN));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(mesg_frm_cc_mc));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(p_strslmtamt));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(str_credit_card_machine_int_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(p_field_separator));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(p_piped_op));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(warning_message_text));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
 
	String moduleid= request.getParameter("moduleid");
	String called_module_id=(String)session.getAttribute("called_module_id");	
	String responsibility_id=(String)session.getAttribute("responsibility_id");
	
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(called_module_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(responsibility_id));
            _bw.write(_wl_block120Bytes, _wl_block120);

	String pDocDate="";
	try{		

		con	=	ConnectionManager.getConnection(request);
		
		String docDateSql=	"SELECT to_char(DOC_DATE,'YYYYMMDDHH24MISS') FROM BL_BILL_HDR  "
				 + " WHERE  OPERATING_FACILITY_ID = ? AND PATIENT_ID  = ?     AND DOC_TYPE_CODE     = ?"
		         + " AND DOC_NUM  = ?     AND EPISODE_TYPE = ?       AND EPISODE_ID = ?"; 
		
		pstmt = con.prepareStatement(docDateSql) ;
		pstmt.setString(1, strfacilityid);
		pstmt.setString(2, strpatientid);
		pstmt.setString(3, strbilldoctypecode);
		pstmt.setString(4, strbilldocnum);
		pstmt.setString(5, strepisodetype);
		pstmt.setString(6, strepisodeid);
	
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{		
			if( rs.next() ) 
			{
				pDocDate=rs.getString(1);
			}
		}
	
	}catch(Exception ee)
	{
		System.err.println("error in CC check"+ee);
		ee.printStackTrace();
	}
	finally 
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 	
			if (con!=null) ConnectionManager.returnConnection(con, request);	
		}
	
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(pDocDate));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(slmt_type_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(slmt_check_status));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(siteCouponInSlmt));
            _bw.write(_wl_block125Bytes, _wl_block125);

	}catch(Exception e)
	{
		System.err.println("Exception in main detl="+e);
		e.printStackTrace();
	}
	finally{					
		if(con!=null) {
		ConnectionManager.returnConnection(con, request);
					  }
	}

            _bw.write(_wl_block126Bytes, _wl_block126);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REM_SLMT_AMT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REM_SLMT_AMT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AMT_SETTLED.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
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
}
