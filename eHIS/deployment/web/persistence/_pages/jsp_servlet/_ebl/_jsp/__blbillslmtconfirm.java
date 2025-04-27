package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import eCommon.Common.CommonBean;
import java.net.*;
import eXH.*;
import java.util.*;
import com.ehis.util.*;
import eBL.BLReportIdMapper;

public final class __blbillslmtconfirm extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtConfirm.jsp", 1737915539016L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t    Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210113             8157          NMC-JD-CRF-0072               Shikha Seth\n2            V210211             8157          NMC-JD-CRF-0072               Shikha Seth\n3            V210224             8157          NMC-JD-CRF-0072               Shikha Seth\n4\t     \t \t\t\t\t\t 15771\t       NMC-JD-SCF-0164\t\t     \t Sethuraman D\n5\t\t\t\t \t\t\t\t 15858\t       MOHE-CRF-0076\t\t     \t Sethuraman D\n6            V231128  \t\t\t 51666 \t\t   GHL-CRF-0642-US004\t\t\t Namrata Charate\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t\t<html>\n  \t\t<head>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!--\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\t\t<script language=\'javascript\' ></script>\t\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\t\t\n\t\t\t\n\t\tfunction billslmtprocess()\n\t\t{\t\t\t\t\n\t\t\tvar v_slmttype\t\t= \"\";\n\t\t\tvar v_cashslmtflag\t= \"\";\n\t\t\tvar v_instref\t\t= \"\";\n\t\t\tvar v_instdate\t\t= \"\";\n\t\t\tvar v_instremark\t= \"\";\n\t\t\tvar v_slmtidno\t\t= \"\";\n\t\t\tvar v_slmtpayername = \"\";\n\t\t\tvar v_billslmtamt = \"\";\t\n\t\t\tvar v_slmtapprrefno = \"\";\n\n\t\t\tvar v_rectype =\"\";\n\t\t\tvar v_ext_acc_facility_id = \"\";\n\t\t\tvar v_ext_acc_code = \"\";\n\t\t\tvar v_ext_acc_dept = \"\";\n\t\t\tvar v_online_approval = \"\";\n\t\t\tvar v_batch_no = \"\";\n\t\t\tvar v_sale_draft_no = \"\";\n\t\t\tvar v_ext_acc_interface_yn = \"\";\n\t\t\t\n\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\tvar v_cc_term_id_num = \"\";\n\t\t\tvar v_cc_instbranch = \"\";\n\t\t\tvar v_cc_trx_date_time = \"\";\n\n\t\t\tv_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\t\n\t\t\tv_slmttype = parent.frames[0].document.forms[0].slmttype.value;\t\t\n\t\t\t\n\t\t\t//Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\tvar slmtTypeCode = v_slmttype.substring(0,2);\n\t\t\tvar v_application_id = \"\";\n\t\t\tv_application_id = parent.frames[1].document.forms[0].application_id.value\n\n\t\t\n\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\n\t\t\t\t\n\t\t\tif (v_billslmtamt == null ) v_billslmtamt =\"\";\n\t\t\tif (v_slmttype == null ) v_slmttype = \"\";\n\n\t\t\tif (v_slmttype == \"\" && parseFloat(v_billslmtamt) > 0)\n//\t\t\t\t{\talert( \"Settlement Type cannot be blank\");\n\t\t\t{\talert(getMessage(\"BL9107\",\"BL\"));\n\t\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif (v_slmttype != \"\" && parseFloat(v_billslmtamt) == 0)\n//\t\t\t\t{\talert( \"Settlement Type cannot be selected for Zero amount\");\n\t\t\t{\talert(getMessage(\"BL9522\",\"BL\"));\n\t\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\n\t\t\tif (v_slmttype != \"\" &&  v_billslmtamt ==\"\" )\n//\t\t\t\t{\talert( \"Settlement Amount cannot be blank\");\n\t\t\t{\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tvar str = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\t\n\t\t\tv_cashslmtflag =str.charAt(2);\t\t\n\t\t\t\n\t\t\tif (v_slmttype != \"\")\n\t\t\t{\n\t\t\t\tv_ext_acc_interface_yn = parent.frames[1].document.forms[0].ext_acc_interface_yn.value;\n\t\t\t\t\t\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif (v_ext_acc_interface_yn == \"Y\" && v_slmttype != \"\")\n\t\t\t{\t\t\t\t\t\n\t\t\t\tv_rectype = parent.frames[1].document.forms[0].rectype.value;\n\t\t\t\tv_ext_acc_facility_id = parent.frames[1].document.forms[0].ext_acc_fac_id.value;\n\t\t\t\tv_ext_acc_code = parent.frames[1].document.forms[0].acccode.value;\n\t\t\t\tv_ext_acc_dept = parent.frames[1].document.forms[0].dept.value;\n\t\t\t\t\n\t\t\t\tif ( v_rectype == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Receipt Type cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9524\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].rectype.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( v_ext_acc_code == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Account code cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9525\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].acccode.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif ( v_ext_acc_dept == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Accounting department cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9526\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].dept.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\t\t\t\t\n\t\t\tif (v_cashslmtflag != \"Y\" && v_slmttype != \"\")\n\t\t\t{\n\t\t\t\tif (v_application_id != \"PAYTM\")\n\t\t\t\t{ //  Condition added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t\t\tv_instref = parent.frames[1].document.forms[0].instref.value;\n\t\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value;\n\n\t\t\t\t\t//v_instremark = parent.frames[1].document.forms[0].instremark.value;\n\n\t\t\t\t\tv_instremark = parent.frames[1].document.forms[0].instremarkcode.value;\t\t\n\n\t\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\t\t\tif (parent.frames[1].document.forms[0].onlineapproval.checked)\n\t\t\t\t\t\tv_online_approval = \'Y\';\n\t\t\t\t\telse\n\t\t\t\t\t\tv_online_approval = \'N\';\n\n\t\t\t\t\tv_batch_no = parent.frames[1].document.forms[0].batchno.value;\n\t\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;\n\t\t\t\t\t\n\t\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\t\tv_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;\n\t\t\t\t\tv_cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;\n\t\t\t\t\tv_cc_instbranch = parent.frames[1].document.forms[0].instbranch.value;\n\t\t\t\t}\n\t\t\t\telse if (applicationID == \"PAYTM\")\n\t\t\t\t{ // Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t\t\n\t\t\t\t\tv_instref = parent.frames[1].document.forms[0].instref.value; //PayTM User Code.\n\t\t\t\t\tv_batch_no = parent.frames[1].document.forms[0].batchno.value; //PayTM Promo Code.\n\t\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value; //PayTM Transaction Receipt Number.\n\t\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value; //PayTM Transaction date and time.\n\t\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value; //PayTM Merchant Order ID.\n\t\t\t\t}\n\n\t\t\t\tif ( v_instref == \"\")\n\t\t\t\t{\n//\t\t\t\t\t\t\talert(\"Instrument Ref cannot be blank\");\n\t\t\t\t\tif (v_application_id != \"PAYTM\"){ // Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t\t\t\talert(getMessage(\"BL6251\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t/*\n\t\t\t\t\telse // Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9500\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t*/\n\n\t\t\t\t}\n\n\t\t\t\tif ( v_instdate == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Instrument Date cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL6250\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_instremark == \"\" && (v_cashslmtflag == \"A\" || v_cashslmtflag == \"B\"))\n\t\t\t\t{\n//\t\t\t\t\talert(\"Bank/Card Co. Name cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9529\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].instremark.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"Y\" && v_batch_no == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Batch No cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9530\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\tif (v_slmtapprrefno == \"\" && v_cashslmtflag == \"A\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Approval code cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9531\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].apprrefno.focus();\n\t\t\t\t\treturn false;\t\t\t\t\t\t\n\t\t\t\t}\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Payer\'s name cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername != \"\" && v_slmtidno == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Payer\'s Ref Id cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\n\t\t\t\t\n\t\t\t\tif (v_slmtapprrefno == \"\" && v_application_id == \"PAYTM\") // Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t\t{\n//\t\t\t\t\talert(\"PayTM Transaction ID cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9501\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\t\t\t\n\n\n\t\t\t\t\n\n\t\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"N\" && v_batch_no != \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Online Approved credit card transaction can only have batch number\");\n\t\t\t\t\talert(getMessage(\"BL9534\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\t\t\t\t\n\n\t\t\t\tif (v_cashslmtflag == \"A\" && v_sale_draft_no == \"\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"Sale Draft No cannot be blank\");\n\t\t\t\t\talert(getMessage(\"BL9535\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].saledraftno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t/*\n\t\t\t\tif (v_sale_draft_no == \"\" && slmtTypeCode == \"PT\") //Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9502\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].saledraftno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t*/\n\t\t\t}\n\t\t\telse if (v_cashslmtflag == \"Y\" && v_slmttype != \"\")\n\t\t\t{\n\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t}\t\t\t\n\t\t\t\t\n\t\t\tvar genmesg = getMessage(\"BL9537\",\"BL\");\n\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\tparent.frames[2].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&billdocnum=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&billpayableamt=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&facilityid=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&user=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patientid=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&episodetype=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&episodeid=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&visitid=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16_0 ="&slmtamt=\'+v_billslmtamt+\'&slmttypecode=\'+v_slmttype.substring(0,2)+\'&slmtdocref=\'+v_instref+\'&slmtdocrefdate=\'+v_instdate+\'&slmtdocrefremark=\'+v_instremark+\'&slmtidno=\'+v_slmtidno+\'&slmtpayername=\'+v_slmtpayername+\'&slmtapprrefno=\'+v_slmtapprrefno+\'&onlineapproval=\'+v_online_approval+\'&batchno=\'+v_batch_no+\'&saledraftno=\'+v_sale_draft_no+\'&rectype=\'+v_rectype+\'&extaccfacid=\'+v_ext_acc_facility_id+\'&extacccode=\'+v_ext_acc_code+\'&extaccdept=\'+v_ext_acc_dept+\'&genmesg=\'+genmesg; \t\t\t\t\t\n\t\t}\n\t\t\n\tfunction acceptbillslmt()\n\t{\n\t\tvar v_instref = \"\";\n\t\tvar v_instdate = \"\";\n\t\tvar v_instremark = \"\";\n\t\tvar v_slmtidno = \"\";\n\t\tvar v_slmtpayername = \"\";\n\t\tvar v_slmtapprrefno = \"\";\n\t\tvar v_online_approval = \"\";\n\t\tvar v_batch_no = \"\";\n\t\tvar v_sale_draft_no = \"\";\n\t\t\n\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\tvar v_cc_term_id_num = \"\";\n\t\tvar v_cc_instbranch = \"\";\n\t\tvar v_cc_trx_date_time = \"\";\n\t\t\n\t\t//V210224 start\n\t\tvar siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value;\n\t\tvar str = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\n\t\tvar v_cashslmtflag =str.charAt(2);\t\t\n\t\tvar v_couponflag =str.charAt(3);\n\t\t//V210224 end\n\t\tvar slmt_type_main_frame = parent.frames[0].document.forms[0].slmttype.value;\n\t\t\n\t\tif(slmt_type_main_frame == \"\")\n\t\t{\t\t\t\t\t\n\t\t\talert(getMessage(\"BL9521\",\"BL\"));\n\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\treturn false;\n\t\t}\n\n\t\t var credit_card_num_yn = parent.frames[1].document.forms[0].credit_card_num_yn.value;\n\n\t\t var credit_card_co_yn = parent.frames[1].document.forms[0].credit_card_co_yn.value;\n\n\t\t var approval_code_yn = parent.frames[1].document.forms[0].approval_code_yn.value;\n\n\t\t var credit_card_check_yn = parent.frames[1].document.forms[0].credit_card_check_yn.value;\n\n\t\tvar credit_card_machine_int_yn = parent.frames[1].document.forms[0].str_credit_card_machine_int_yn.value;\n\t\tif(credit_card_machine_int_yn == \"\") credit_card_machine_int_yn=\" \";\n\t\t/* <!--Added by Monika for NMC-JD-CRF-0199 -->\t */\n\t\tvar terminal_id_reqd_yn = parent.frames[1].document.forms[0].terminal_id_reqd_yn.value;\n\t\tvar cc_terminal_id_enable = parent.frames[1].document.forms[0].cc_terminal_id_enable.value; \n\t\t\n\t\tvar v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\n\n\t\tvar v_slmttype = parent.frames[0].document.forms[0].slmttype.value;\n\n\t\t\n\t\t//Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\tvar slmtTypeCode = v_slmttype.substring(0,2);\n\t\tvar v_application_id = parent.frames[1].document.forms[0].application_id.value;\n\t\t\n\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\t\t\t\t\n\t\tif (v_billslmtamt == null ) v_billslmtamt =\"\";\n\t\tif (v_slmttype == null ) v_slmttype = \"\";\n\t\tvar cashier_cheque_yn=parent.frames[1].document.forms[0].cashier_cheque_yn.value;\n\n\t\tvar sale_draft_reqd_yn = parent.frames[1].document.forms[0].sale_draft_reqd_yn.value;\n\t\tvar payer_name_reqd_yn = parent.frames[1].document.forms[0].payer_name_reqd_yn.value;\n\t\tvar payer_ref_reqd_yn = parent.frames[1].document.forms[0].payer_ref_reqd_yn.value;\n\t\t//Added against  CRF AAKH-CRF-0014  37864  15/07/2013\n\t\tvar batch_no_reqd_yn = parent.frames[1].document.forms[0].batch_no_reqd_yn.value;\n\t\tvar slmt_doc_ref_date_reqd_yn = parent.frames[1].document.forms[0].slmt_doc_ref_date_reqd_yn.value;\n\t\t\n\t\t//if(v_billslmtamt==\"\") //V210224\n\t\tif(v_billslmtamt==\"\" && !(siteCouponInSlmt ==\'true\' && v_cashslmtflag == \'D\' && v_couponflag==\'Y\')) //V210224\n\t\t{\n\t\t\talert(getMessage(\"BL9776\",\"BL\"));\n\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\treturn false;\n\t\t}\n\t\t//V210224 start\n\t\tif(v_billslmtamt==\"\" && (siteCouponInSlmt ==\'true\' && v_cashslmtflag == \'D\' && v_couponflag==\'Y\'))\n\t\t{\n\t\t\talert(getMessage(\'BL0934\',\'BLEXT\')); \t\t\t\n\t\t\treturn false;\n\t\t}\n\t\t//V210224 end\n\n\t\tif (v_slmttype == \"\" && parseFloat(v_billslmtamt) > 0)\n\t\t{\t\n\t\t\talert(getMessage(\"BL9107\",\"BL\"));\n\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\treturn false;\n\t\t}\n\t\tif (v_slmttype != \"\" && parseFloat(v_billslmtamt) == 0)\n\t\t{\t\n\t\t\talert(getMessage(\"BL9522\",\"BL\"));\n\t\t\tparent.frames[0].document.forms[0].slmttype.focus();\n\t\t\treturn false;\n\t\t}\t\t\n\n\t\tif (v_slmttype != \"\" &&  v_billslmtamt ==\"\" )\n\t\t{\t\n\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\tparent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\treturn false;\n\t\t}\n\t\t// moved up can remove here\n\t\t//var str = parent.frames[0].document.forms[0].slmttype.value;\t\t\t\t\n\t\t//var v_cashslmtflag =str.charAt(2);\t\t\n\t\t//var v_couponflag =str.charAt(3);\t //V210113\n\t\t// moved up can remove here\n\t\tif (v_cashslmtflag != \"Y\" && v_slmttype != \"\" && v_couponflag==\"\") //V210113\n\t\t{\n\t\t\tif (v_application_id != \"PAYTM\" && v_application_id != \"PAYSKY\")\n\t\t\t{ //  Condition added by Sethu for GHL-CRF-0415 on 21/04/2017 and for MOHE-CRF-0076 on 08/08/2021\n\t\t\t\tv_instref = parent.frames[1].document.forms[0].instref.value;\n\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value;\n\t\t\t\tv_instremark = parent.frames[1].document.forms[0].instremarkcode.value;\t\t\n\t\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;\n\n\t\t\t\tif (parent.frames[1].document.forms[0].onlineapproval.checked)\n\t\t\t\t\tv_online_approval = \'Y\';\n\t\t\t\telse\n\t\t\t\t\tv_online_approval = \'N\';\n\n\t\t\t\tv_batch_no = parent.frames[1].document.forms[0].batchno.value;\n\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;\n\n\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\tv_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;\n\t\t\t\tv_cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;\n\t\t\t\tv_cc_instbranch = parent.frames[1].document.forms[0].instbranch.value;\n\t\t\t}\n\t\t\telse if (v_application_id == \"PAYTM\")\n\t\t\t{\n\t\t\t\t// Added by Sethu for GHL-CRF-0415 on 21/04/2017\t\t\t\t\n\t\t\t\tv_instref = parent.frames[1].document.forms[0].instref.value; //PayTM User Code.\n\t\t\t\tv_batch_no = parent.frames[1].document.forms[0].batchno.value; //PayTM Promo Code.\n\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value; //PayTM Transaction Receipt Number.\n\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value; //PayTM Transaction date and time.\n\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value; //PayTM Merchant Order ID.\n\t\t\t}\t\t\t\n\t\t\telse if (v_application_id == \"PAYSKY\")\n\t\t\t{\n\t\t\t\t// Added by Sethu for MOHE-CRF-0076 on 07/08/2021\t\t\t\t\n\t\t\t\tv_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value; //PAYSKY Transaction Receipt Number.\n\t\t\t\tv_instdate = parent.frames[1].document.forms[0].instdate.value; //PAYSKY Transaction date and time.\n\t\t\t\tv_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value; //PAYSKY Merchant Order ID.\n\t\t\t}\t\n\n\t\t\tif ( v_instref == \"\" && credit_card_num_yn == \"Y\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6251\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if (v_instref == \"\" && v_application_id == \"PAYTM\") // Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9500\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t\t//alert(\"slmt_doc_ref_date_reqd_yn  \"+slmt_doc_ref_date_reqd_yn);\n\t\t\t\n\t\t\tif ( v_instdate == \"\" && slmt_doc_ref_date_reqd_yn== \"Y\")\n\t\t\t{\t\t\n\t\t\t\talert(getMessage(\"BL6250\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if (v_instdate == \"\" && v_application_id == \"PAYTM\") // Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6250\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if (v_instdate == \"\" && v_application_id == \"PAYSKY\") // Added by Sethu for MOHE-CRF-0076 on 07/08/2021\n\t\t\t{ \n\t\t\t\talert(getMessage(\"BL6250\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t//\t\t\t\t\t\tif (v_instremark == \"\" && (v_cashslmtflag == \"A\" || v_cashslmtflag == \"B\"))\n\t\t\tif (v_instremark == \"\" && (v_cashslmtflag != \"Y\") && credit_card_co_yn == \"Y\")\n\t\t\t{\n\t\t\talert(getMessage(\"BL9529\",\"BL\"));\n\t\t\tparent.frames[1].document.forms[0].instremark.focus();\n\t\t\treturn false;\n\t\t\t}\n\n//\t\t\talert(\"batch_no_reqd_yn  \"+batch_no_reqd_yn);\n\t\t\n\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"Y\" && v_batch_no == \"\"&& batch_no_reqd_yn==\"Y\")\n\t\t\t{\n\t\t\talert(getMessage(\"BL9530\",\"BL\"));\n\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\treturn false;\n\t\t\t}\t\t\t\t\t\t\n\n//\t\t\tif (v_slmtapprrefno == \"\" && v_cashslmtflag == \"A\" && payer_ref_reqd_yn==\"Y\")\n//  Commented  against incident  43719 on 25/09/2013\n\n\t\t\tif (v_slmtapprrefno == \"\" && v_cashslmtflag == \"A\" && approval_code_yn == \"Y\")\n\t\t\t{\n\t\t\talert(getMessage(\"BL9531\",\"BL\"));\n\t\t\tparent.frames[1].document.forms[0].apprrefno.focus();\n\t\t\treturn false;\t\t\t\t\t\t\n\t\t\t}\t\t\t\t\n\n\n\t\t\tif (v_cashslmtflag == \"B\" && v_slmtpayername == \"\" && payer_name_reqd_yn==\"Y\")\n\t\t\t{\n\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif (v_cashslmtflag == \"A\" && v_sale_draft_no == \"\" && sale_draft_reqd_yn==\"Y\")\n\t\t\t{\n\t\t\talert(getMessage(\"BL9535\",\"BL\"));\n\t\t\tparent.frames[1].document.forms[0].saledraftno.focus();\n\t\t\treturn false;\n\t\t\t}\t\t\n\n\t\t\tif(payer_name_reqd_yn==\"Y\" && payer_ref_reqd_yn==\"Y\")\n\t\t\t{\n\t\t\t\tif ((v_cashslmtflag == \"B\" || v_cashslmtflag == \"A\") && v_slmtpayername != \"\" && v_slmtidno == \"\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t}\t\n\t\t\tif (v_cashslmtflag == \"A\" && v_online_approval == \"N\" && v_batch_no != \"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9534\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].batchno.focus();\n\t\t\t\treturn false;\n\t\t\t}\t\t\t\t\t\t\n\t\t\t/*if(sale_draft_reqd_yn==\"Y\" && v_sale_draft_no==\"\")\n\t\t\t{\n\t\t\talert(getMessage(\"BL9535\",\"BL\"));\n\t\t\tparent.frames[1].document.forms[0].saledraftno.focus();\n\t\t\treturn false;\n\t\t\t}*/\n\t\t\t//Commented the above If against 55178\n\t\t\tif(payer_name_reqd_yn==\"Y\" && v_slmtpayername==\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif(payer_ref_reqd_yn==\"Y\" && v_slmtidno==\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t/* Added By Monika against NMC-JD-CRF-0199  */\n\t\t\tif(v_cashslmtflag ==\"A\" && cc_terminal_id_enable == \"true\"){\n\t\t\t\tv_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;\n\t\t\t\tif(terminal_id_reqd_yn == \"Y\" && v_cc_term_id_num == \"\")\n\t\t\t\t{\n\t\t\t\t\tvar err = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\t\t\terr= err.replace(\'$\',getLabel(\'eBL.TID_NO.label\',\'BL\')); \n\t\t\t\t\talert(err);\n\t\t\t\t\tparent.frames[1].document.";
    private final static byte[]  _wl_block16_0Bytes = _getBytes( _wl_block16_0 );

    private final static java.lang.String  _wl_block16_1 ="forms[0].cc_term_id_num.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse if (v_cashslmtflag == \"Y\" && v_slmttype != \"\")\n\t\t{\n\t\t\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t}\t\t\t\n\t\t\n\t\tvar v_billslmtamt = \"\";\t\t\t\n\t\tvar v_billpayableamt = \"\";\n\n\t\tv_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;\t\t\t\t\n\t\tv_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;\t\t\t\n\n\t\tif ( parseFloat(Math.abs(v_billslmtamt)) > parseFloat(Math.abs(v_billpayableamt)))\n\t\t{\n\t\t\t\n\t\t\t//\t\t\t\t\talert(\"Allocated amount is greater than outstanding amount\");\n\t\t\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\tparent.frames[0].document.forms[0].billslmtamt.select();\n\t\t\t//parent.frames[0].document.forms[0].billslmtamt.focus();\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tvar instref=\"\";\n\t\tvar instdate=\"\";\n\t\tvar instremark=\"\";\n\t\tvar instbranch=\"\";\n\t\tvar onlineapproval=\"\";\n\t\tvar batchno=\"\";\n\t\tvar apprrefno=\"\";\n\t\tvar saledraftno=\"\";\n\t\tvar cashslmtflag=\"\";\n\t\tvar instbankname=\"\";\n\t\tvar cash_given=\"\";\n\t\tvar cash_return=\"\";\n\t\tvar short_desc=\"\";\n\t\tvar instremarkcode=\"\";\n\t\tvar billdoctype=\"\";\n\t\tvar slmt_type_short_desc=\"\";\n\t\tvar billdocnum=\"\";\n\t\tvar billpayableamt=\"\";\n\t\tvar total_amt_payable=\"\";\n\n\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\tvar cc_term_id_num = \"\";\n\t\tvar cc_trx_date_time = \"\";\n\t\t\n\n\t\t/*var billdoctype=parent.frames[0].document.forms[0].billdoctype.value;\n\t\tif(billdoctype==\"\") billdoctype=\" \";\n\n\t\tvar billdocnum=parent.frames[0].document.forms[0].billdocnum.value;\n\t\tif(billdocnum==\"\") billdocnum=\" \";\t*/\n\n\t\tvar billpayableamt=parent.frames[0].document.forms[0].billpayableamt.value;\n\t\tif(billpayableamt==\"\") billpayableamt=\" \";\t\n\n\t\tvar billslmtamt=parent.frames[0].document.forms[0].billslmtamt.value;\n\t\tif(billslmtamt==\"\") billslmtamt=\" \";\n\n\n\t\tvar slmttype=parent.frames[0].document.forms[0].slmttype.value;\n\t\tslmttype = slmttype.substring(0,3);\n\t\tif(slmttype==\"\") slmttype=\" \";\t\n\n\t\t//Added by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\tvar slmtTypeCode = slmttype.substring(0,2);\n\t\tvar v_application_id=parent.frames[1].document.forms[0].application_id.value;\n\t\t\n\n\t\tvar payername = \"\";\n\t\tvar recrefidno =\"\";\n\t\tvar ext_acc_interface_yn=\"\";\n\t\tvar ext_acc_fac_id=\"\";\n\n\t\tif (v_application_id != \"PAYTM\" && v_application_id != \"PAYSKY\") { //If condition Added by Sethu for GHL-CRF-0415 on 21/04/2017 and for MOHE-CRF-0076 on 08/08/2021\n\t\t\tpayername=parent.frames[1].document.forms[0].payername.value;\t\t\t\n\t\t\tif(payername==\"\") payername=\" \";\n\t\t\tif(credit_card_machine_int_yn!= \'Y\' && !CheckChars(parent.frames[1].document.forms[0].recrefidno))\t\t\t\n\t\t\t{ \n\t\t\n\t\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\"common\"));\n\t\t\t\tparent.frames[1].document.forms[0].recrefidno.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{ \n\t\t\t\trecrefidno=parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\tif(recrefidno==\"\") recrefidno=\" \";\n\t\t\t}\n\t\t\text_acc_interface_yn=parent.frames[1].document.forms[0].ext_acc_interface_yn.value;\n\t\t\tif(ext_acc_interface_yn==\"\") acext_acc_interface_ynccode=\" \";\t\n\t\t\text_acc_fac_id=parent.frames[1].document.forms[0].ext_acc_fac_id.value;\n\t\t\tif(ext_acc_fac_id==\"\") ext_acc_fac_id=\" \";\t\n\n\t\t\tshort_desc=parent.frames[1].document.forms[0].short_desc.value;\t\t\t\n\t\t\tif(short_desc==\"\") short_desc=\" \";\n\t\t}\t\t\n\n\t\tif(v_cashslmtflag==\"D\" && v_application_id != \"PAYTM\" && v_application_id != \"PAYSKY\" && v_couponflag==\"\") //v_application_id != \"PAYTM\" Added by Sethu for GHL-CRF-0415 on 21/04/2017 //v_couponflag V210113 and for MOHE-CRF-0076 on 08/08/2021\n\t\t{ \n\t\t\tif(v_slmtpayername==\"\" && payer_name_reqd_yn==\"Y\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif(v_slmtidno==\"\" && payer_ref_reqd_yn==\"Y\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\n\t\tif((v_cashslmtflag==\"Y\" ) || (v_cashslmtflag==\"D\" && v_couponflag==\"Y\") ) //v_couponflag V210113\n\t\t{\n\t\t\tinstref=\" \";\n\t\t\tinstdate=\" \";\n\t\t\tinstremark=\" \";\n\t\t\tinstbranch=\" \";\t\t\n\t\t\tonlineapproval=\" \";\n\t\t\tbatchno=\" \";\n\t\t\tapprrefno=\" \";\n\t\t\tsaledraftno=\" \";\n\t\t\tcashslmtflag=\" \";\n\t\t\tinstbankname=\" \";\n\t\t\ttotal_amt_payable=\" \";\n\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\tcc_term_id_num =  \" \";\n\t\t\tcc_trx_date_time = \" \";\n\t\t\tif (cashier_cheque_yn==\"Y\")\n\t\t\t{\t\t\n\t\t\t\tinstref=parent.frames[1].document.forms[0].instref.value;\t\t\n\t\t\t\tinstdate=parent.frames[1].document.forms[0].instdate.value;\n\t\t\t\tinstbankname=parent.frames[1].document.forms[0].instremark.value;\n\t\t\t\tinstbranch=parent.frames[1].document.forms[0].instbranch.value;\n\t\t\t\tinstremarkcode = parent.frames[1].document.forms[0].instremarkcode.value;\n\t\t\t\tif(instremarkcode==\"\") instremarkcode=\" \";\n\n\t\t\t\tif(instref==\"\" && credit_card_num_yn == \"Y\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL6251\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].instref.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif(instdate==\"\" )\n\t\t\t\t{ \n\t\t\t\talert(getMessage(\"BL6250\",\"BL\"));\n\t\t\t\tparent.frames[1].document.forms[0].instdate.focus();\n\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif(instbankname==\"\" && credit_card_co_yn ==\"Y\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9529\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].instremark.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tvar\tv_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;\n\t\t\t\tvar\tv_slmtpayername = parent.frames[1].document.forms[0].payername.value;\n\t\t\t\tif(v_slmtpayername==\"\" && payer_name_reqd_yn==\"Y\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].payername.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif(v_slmtidno==\"\" && payer_ref_reqd_yn==\"Y\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9533\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].recrefidno.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\tcc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;\n\t\t\t\tcc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;\n\t\t\t}\n\t\t\tcash_given=parent.frames[1].document.forms[0].cash_given.value;\t\t\t\n\t\t\tcash_return=parent.frames[1].document.forms[0].cash_return.value;\n\t\t\tif(cash_given==\"\")\n\t\t\t{\n\t\t\t\tif(!(siteCouponInSlmt ==\'true\' && v_cashslmtflag==\"D\" && v_couponflag==\"Y\")) { //V210224\n\t\t\t\t\talert(getMessage(\"BL9615\",\"BL\"));\n\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.focus();\n\t\t\t\t\treturn;\n\t\t\t\t} //V210224\n\t\t\t}\n\t\t\telse if(billslmtamt<0){\n\n\t\t\t\tif($(\'#rec_ref\').val()==\'F\')\n\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\tif(parseFloat(cash_given)>parseFloat(billslmtamt))\n\t\t\t\t\t{\t\t\t\n\t\t\t\t\t\talert(getMessage(\"BL9618\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\tif(parseFloat(cash_given)>parseFloat(billslmtamt))\n\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"BL9618\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t}\n\t\t\telse{\t\n\n\t\t\t\tif($(\'#rec_ref\').val()==\'F\')\n\t\t\t\t{\n\t\t\t\t\tif(parseFloat(cash_given)<parseFloat(billslmtamt))\n\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"BL9618\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\tif(parseFloat(cash_given)<parseFloat(billslmtamt)) \n\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"BL9618\",\"BL\"));\n\t\t\t\t\t\tparent.frames[1].document.forms[0].cash_given.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\t\t\n\t\t\t\t}\n\n\t\t\t}\t\t\t\t\n\t\t}\n\t\telse if (v_application_id == \"PAYTM\")\t\t// Else If confition Added \t by Sethu for GHL-CRF-0415 on 21/04/2017\n\t\t{\n\t\t\tcash_given=\"\";\n\t\t\tcash_return=\"\";\n\n\t\t\tinstref=parent.frames[1].document.forms[0].instref.value;\t\n\t\t\tif(instref==\"\") instref=\" \";\t\n\t\t\tinstdate=parent.frames[1].document.forms[0].instdate.value;\n\t\t\tif(instdate==\"\") instdate=\" \";\t\t\t\t\n\t\t\tsaledraftno=parent.frames[1].document.forms[0].saledraftno.value;\n\t\t\tif(saledraftno==\"\") saledraftno=\" \";\t\t\t\n\t\t\tcashslmtflag = parent.frames[1].document.forms[0].cashslmtflag.value;\n\t\t\tif(cashslmtflag==\"\") cashslmtflag=\" \";\n\t\t\ttotal_amt_payable=parent.frames[0].document.forms[0].total_amt_payable.value;\n\t\t\tif(total_amt_payable==\"\") total_amt_payable=\" \";\n\t\t\t//recrefidno=parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\tapprrefno=parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\t\n\t\t\tbatchno=parent.frames[1].document.forms[0].batchno.value;\n\t\t\tif(batchno==\"\") batchno= \" \";\n\n\t\t\tif (instref.length > 20){\n\t\t\t\tinstref = instref.substring(0,20);\n\t\t\t}\n\t\t}\n\t\telse if (v_application_id == \"PAYSKY\")\t\t// Else If confition Added by Sethu for MOHE-CRF-0076 on 07/08/2021\n\t\t{\n\t\t\tcash_given=\"\";\n\t\t\tcash_return=\"\";\n\n\t\t\tinstdate=parent.frames[1].document.forms[0].instdate.value;\n\t\t\tif(instdate==\"\") instdate=\" \";\t\t\t\t\n\t\t\tsaledraftno=parent.frames[1].document.forms[0].saledraftno.value;\n\t\t\tif(saledraftno==\"\") saledraftno=\" \";\t\t\t\n\t\t\tcashslmtflag = parent.frames[1].document.forms[0].cashslmtflag.value;\n\t\t\tif(cashslmtflag==\"\") cashslmtflag=\" \";\n\t\t\ttotal_amt_payable=parent.frames[0].document.forms[0].total_amt_payable.value;\n\t\t\tif(total_amt_payable==\"\") total_amt_payable=\" \";\n\t\t\t//recrefidno=parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\tapprrefno=parent.frames[1].document.forms[0].apprrefno.value;\n\t\t}\n\t\telse \n\t\t{\n\t\t\tcash_given=\"\";\n\t\t\tcash_return=\"\";\n\n\t\t\tif(credit_card_machine_int_yn != \"Y\" && !CheckChars(parent.frames[1].document.forms[0].instref))\n\t\t\t{\n\t\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\"common\"));\n\t\t\t\tparent.frames[1].document.forms[0].instref.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tinstref=parent.frames[1].document.forms[0].instref.value;\t\n\t\t\t\tif(instref==\"\") instref=\" \";\t\n\t\t\t}\n\t\t\tinstdate=parent.frames[1].document.forms[0].instdate.value;\n\t\t\tif(instdate==\"\") instdate=\" \";\t\n\t\n\t\t\tif(v_cashslmtflag==\"A\")\n\t\t\t{\t\t\n\t\t\t\tinstremark=parent.frames[1].document.forms[0].instremark.value;\n\t\t\t\tif(instremark==\"\") instremark=\" \";\t\t\n\t\t\t\tinstbankname=\" \";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tinstbankname=parent.frames[1].document.forms[0].instremark.value;\t\n\t\t\t\tif(instbankname==\"\") instbankname=\" \";\t\n\t\t\t\tinstremark=\" \";\n\t\t\t}\n\n\t\t\tinstbranch=parent.frames[1].document.forms[0].instbranch.value;\n\t\t\tif(instbranch==\"\") instbranch=\" \";\n\n\t\t//\tvar onlineapproval=eval(\"parent.frames[1].document.forms[0].onlineapproval\");\n\t\t\tif(parent.frames[1].document.forms[0].onlineapproval.checked)\n\t\t\t{\n\t\t\t\tonlineapproval=\"checked\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tonlineapproval=\"\";\n\t\t\t}\n\n\n\t\t\tif(credit_card_machine_int_yn != \"Y\" && !CheckChars(parent.frames[1].document.forms[0].batchno))\n\t\t\t{\n\n\t\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\"common\"));\n\t\t\t\tparent.frames[1].document.forms[0].batchno.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tbatchno=parent.frames[1].document.forms[0].batchno.value;\n\t\t\t\tif(batchno==\"\") batchno= \" \";\t\t\n\t\t\t}\n\n\t\t\tif(credit_card_machine_int_yn != \"Y";
    private final static byte[]  _wl_block16_1Bytes = _getBytes( _wl_block16_1 );

    private final static java.lang.String  _wl_block16_2 ="\" && !CheckChars(parent.frames[1].document.forms[0].apprrefno))\n\t\t\t{\n\n\t\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\"common\"));\n\t\t\t\tparent.frames[1].document.forms[0].apprrefno.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tapprrefno=parent.frames[1].document.forms[0].apprrefno.value;\n\t\t\t\tif(apprrefno==\"\") apprrefno=\" \";\t\n\t\t\t}\n\n\t\t\tif(credit_card_machine_int_yn != \"Y\" && !CheckChars(parent.frames[1].document.forms[0].saledraftno))\n\t\t\t{\n\n\t\t\t\talert(getMessage(\"CANNOT_BE_SPECIAL_CHAR\",\"common\"));\n\t\t\t\tparent.frames[1].document.forms[0].saledraftno.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tsaledraftno=parent.frames[1].document.forms[0].saledraftno.value;\n\t\t\t\tif(saledraftno==\"\") saledraftno=\" \";\n\t\t\t}\n\t\t\tcashslmtflag = parent.frames[1].document.forms[0].cashslmtflag.value;\n\t\t\tif(cashslmtflag==\"\") cashslmtflag=\" \";\n\n\t\t\tinstremarkcode = parent.frames[1].document.forms[0].instremarkcode.value;\n\t\t\tif(instremarkcode==\"\") instremarkcode=\" \";\n\n\n\t\t\ttotal_amt_payable=parent.frames[0].document.forms[0].total_amt_payable.value;\n\t\t\tif(total_amt_payable==\"\") total_amt_payable=\" \";\n\n\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\tcc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;\n\t\t\tif(cc_term_id_num==\"\") cc_term_id_num=\" \";\n\t\t\tcc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;\n\t\t\tif(cc_trx_date_time==\"\") cc_trx_date_time=\" \";\n\t\t}\n\t\t/*Added for KDAH CRF 339.2 - Rajesh V*/\n\t\tvar restrictEligibility = $(\'#restrictEligibility\').val();\n\t\t\n\t\tvar cashForTaxCalc = \'N\';\n\t\tif(restrictEligibility == \"Y\" ){\n\t\t\n\t\t\tvar slmtTypeCode = slmttype.substring(0,2);\n\t\t\t\n\t\t\tvar parmForCheck = \'calledFrom=blCashSlmt\'+\n\t\t\t\t\t\t\t\t\'&slmtTypeCode=\'+slmtTypeCode;\n\t\t\t$.ajax({\n\t\t\t\ttype:\"GET\",\n\t\t\t\turl:\"../jsp/BLCashSlmtRestrictAjax.jsp\",\n\t\t\t\tdata:parmForCheck,\n\t\t\t\tdataType:\"text\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\tcashForTaxCalc = $.trim(data);\n\t\t\t\t},\n\t\t\t\t error: function(data){\n\t\t\t\t\t cashForTaxCalc = \'N\';\n\t\t\t\t  }\n\t\t\t});\n\t\t\t\n\t\t\tif(cashForTaxCalc == \'Y\'){\n\t\t\t\tvar obj;\n\t\t\t\tvar cashCollected = 0;\n\t\t\t\tvar totalCashAmtColl = $(\'#totalCashAmtColl\').val();\n\t\t\t\tif(isNaN(totalCashAmtColl)){\n\t\t\t\t\ttotalCashAmtColl = 0;\n\t\t\t\t}\n\t\t\t\ttotalCashAmtColl = parseFloat(totalCashAmtColl)+parseFloat(v_billslmtamt);\n\t\t\t\tvar strBillDocCode = $(\'#strBillDocCode\').val();\n\t\t\t\tvar strBillDocNum = $(\'#strBillDocNum\').val();\n\t\t\t\tif(strBillDocCode != \'\' && strBillDocNum != \'\'){\n\t\t\t\t\tparmForCheck = \'calledFrom=BLPatientRecValidate\'+\n\t\t\t\t\t\t\t\t\t\'&docTypeCode=\'+strBillDocCode+\n\t\t\t\t\t\t\t\t\t\'&docNum=\'+strBillDocNum+\n\t\t\t\t\t\t\t\t\t\'&docDate=\'+\n\t\t\t\t\t\t\t\t\t\'&episodeType=\'+\'";
    private final static byte[]  _wl_block16_2Bytes = _getBytes( _wl_block16_2 );

    private final static java.lang.String  _wl_block17 ="\'+\n\t\t\t\t\t\t\t\t\t\'&episodeId=\'+\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'+\n\t\t\t\t\t\t\t\t\t\'&visitId=\'+\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'+\n\t\t\t\t\t\t\t\t\t\'&patientId=\'+\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'+\n\t\t\t\t\t\t\t\t\t\'&slmtAmt=\'+totalCashAmtColl;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tparmForCheck = \'calledFrom=BLPatientDepValidate\'+\n\t\t\t\t\t\t\t\t\t\'&patientId=\'+\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'+\n\t\t\t\t\t\t\t\t\t\'&depositAmt=\'+totalCashAmtColl;\n\t\t\t\t}\n\n\t\t\t\tif(parseFloat(totalCashAmtColl)>=0){\n\t\t\t\t\tvar errorCheck = \'\';\n\t\t\t\t\t$.ajax({\n\t\t\t\t\t\ttype:\"GET\",\n\t\t\t\t\t\turl:\"../jsp/BLCashSlmtRestrictAjax.jsp\",\n\t\t\t\t\t\tdata:parmForCheck,\n\t\t\t\t\t\tdataType:\"json\",\n\t\t\t\t\t\tasync:false,\n\t\t\t\t\t\tsuccess: function(data){\n\t\t\t\t\t\t\tif(data.allowYn == \'N\'){\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(data.errorText != \'\'){\n\t\t\t\t\t\t\t\t\terrorCheck = errorCheck+data.errorText;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tif(data.messageText != \'\'){\n\t\t\t\t\t\t\t\t\tif(errorCheck == \'\'){\n\t\t\t\t\t\t\t\t\t\terrorCheck = errorCheck+data.messageText;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\terrorCheck = errorCheck+\"\\n\"+data.messageText;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t//V231128\n\t\t\t\t\t\t\t\tif(data.messageTextExtn != \'\'){\n\t\t\t\t\t\t\t\t\tif(errorCheck == \'\'){\n\t\t\t\t\t\t\t\t\t\terrorCheck = errorCheck+data.messageTextExtn;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\terrorCheck = errorCheck+\"\\n\\n\"+data.messageTextExtn.replace(/\\\\n/g,\'\\n\');  \n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t},\n\t\t\t\t\t\t error: function(data){\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t  }\n\t\t\t\t\t});\n\t\t\t\t\tif(errorCheck != \'\'){\n\t\t\t\t\t\talert(errorCheck);\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\t// V210113 start\n\t\tvar coupon=\"\"; \n\t\tvar patMembershipID=\"\";\t\t\n\t\tvar couponAndAmt =\"\";\n\t\tif (v_couponflag != \'\') {\n\t\t\tcoupon=parent.frames[1].document.forms[0].couponcode.value; //shikha\n\t\t\tpatMembershipID=parent.frames[1].document.forms[0].patMembershipID.value; //shikha\n\t\t\tcouponAndAmt=parent.frames[1].document.forms[0].couponAndAmt.value; //shikha\t\t\t\n\t\t}else {\n\t\t\tcoupon=\"\";\n\t\t\tpatMembershipID=\"\";\n\t\t\tcouponAndAmt=\"\";\n\t\t}\t\t\n\t\t// V210113 end\n\t\t/*Added for KDAH CRF 339.2 - Rajesh V*/\t\t\n\t\tif(coupon !== \"\") {\n\t\t\tinstref = \"COUPONS\";\n\t\t}//V210224\t\t\n\t\t/*Added for KDAH CRF 339.2 - Rajesh V*/\n\t\t//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t//var retVal=billdoctype+\"::\"+billdocnum+\"::\"+billpayableamt+\"::\"+billslmtamt+\"::\"+slmttype+\"::\"+encodeURIComponent(payername)+\"::\"+recrefidno+\"::\"+ext_acc_interface_yn+\"::\"+ext_acc_fac_id+\"::\"+instref+\"::\"+instdate+\"::\"+instremark+\"::\"+instbranch+\"::\"+onlineapproval+\"::\"+batchno+\"::\"+apprrefno+\"::\"+saledraftno+\"::\"+cashslmtflag+\"::\"+instbankname+\"::\"+cash_given+\"::\"+cash_return+\"::\"+short_desc+\"::\"+instremarkcode+\"::\"+total_amt_payable+\"::\"+credit_card_machine_int_yn+\"::\"+cashForTaxCalc+\"::\"+coupon+\"::\"+patMembershipID+\"::\"+couponAndAmt; // V210113    \n\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\tvar retVal=billdoctype+\"::\"+billdocnum+\"::\"+billpayableamt+\"::\"+billslmtamt+\"::\"+slmttype+\"::\"+encodeURIComponent(payername)+\"::\"+recrefidno+\"::\"+ext_acc_interface_yn+\"::\"+ext_acc_fac_id+\"::\"+instref+\"::\"+instdate+\"::\"+instremark+\"::\"+instbranch+\"::\"+onlineapproval+\"::\"+batchno+\"::\"+apprrefno+\"::\"+saledraftno+\"::\"+cashslmtflag+\"::\"+instbankname+\"::\"+cash_given+\"::\"+cash_return+\"::\"+short_desc+\"::\"+instremarkcode+\"::\"+total_amt_payable+\"::\"+credit_card_machine_int_yn+\"::\"+cashForTaxCalc+\"::\"+cc_term_id_num+\"::\"+cc_trx_date_time+\"::\"+coupon+\"::\"+patMembershipID+\"::\"+couponAndAmt; // V210113\n\t//\talert(\"BLBillSlmtConfirm.jsp :\"+retVal);\n\t\t//prompt(\"\",retVal);\n\t\t//alert(retVal);\n\t\tparent.window.returnValue = retVal;\n\t\tparent.window.close();\n\t}\n\n\tfunction enableAllElements_billslmt_remove()\n\t{\n\t\tdocument.forms[0].remove_button.disabled=false;\n\t\t//document.forms[0].cancel_button.disabled=false;\n\t}\n\tfunction remove_billslmt()\n\t{\n\t\t\n\t\tparent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = \"remove\";\n\t\tparent.parent.document.getElementById(\'dialog_tag\').close(); \n\t\t/* parent.window.returnValue = \"remove\";\n\t\tparent.window.close(); */\t\n\t}\t\t\n\n\tfunction cancel()\n\t{\n\t//V210211 START\n\t\tvar str = parent.frames[0].document.forms[0].slmttype.value;\t\n\t\tvar siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value;\n\t\tvar cash_slmt_flag =str.charAt(2);\t\n\t\tvar coupon_yn = str.charAt(3);\t\n\t\t//V210211 END\n\t\t// V210113 start\n\t\tif ((siteCouponInSlmt== true || siteCouponInSlmt == \'true\') && cash_slmt_flag==\"D\" && coupon_yn==\"Y\") {\t//V210211\n\t\t\tvar patientID =parent.frames[1].document.forms[0].patientid.value; \n\t\t\tvar LoggedUser =parent.frames[1].document.forms[0].LoggedUser.value; \n\t\t\tvar clientIpAddress =parent.frames[1].document.forms[0].clientIpAddress.value; \n\t\t\tvar cash_given =parent.frames[1].document.forms[0].cash_given.value; \t\n\t\t\tvar coupon=parent.frames[1].document.forms[0].couponcode.value; \n\t\t\t//V210224 start\n\t\t\tvar coupons = parent.frames[1].document.forms[0].coupons.value;\n\t\t\tvar action_ind = document.forms[0].action_ind.value;\n\t\t\tif(action_ind == \"add\" || (action_ind == \"modify\" && coupon != coupons) ) {\n\t\t\t//V210224 end\n\t\t\t\t//V210211\n\t\t\t\tif (coupon != \"undefined\" && coupon != undefined && coupon != \"\" ) {\n\t\t\t\t\tif(confirm(getMessage(\"BL0924\",\"BLEXT\"))) //BL9760\n\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\tvar transactionid=\'\';\t\t\n\t\t\t\t\t\tvar NuhdeekResponse = NuhdeekTransactions(\'RELEASE\',patientID,coupon,transactionid, LoggedUser, clientIpAddress);\t\t\n\t\t\t\t\t\tvar NuhdeekResponseArr = NuhdeekResponse.split(\"$!^\");\t\t\n\t\t\t\t\t\tif (NuhdeekResponseArr[0] == \'S\') {\t\t\n\t\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t} else if (NuhdeekResponseArr[0]==\'E\') {\n\t\t\t\t\t\t\t\talert(NuhdeekResponseArr[4]);\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}else {\n\t\t\t\t\t\treturn false;\t\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t} //V210211\n\t\t\t} //V210224 \n\t\t}\n\t\t// V210113 end\n\t\tparent.parent.document.getElementById(\'dialog_tag\').close(); \n\t\t/* parent.window.close(); */\n\t}\n\n\tfunction enableAllElements_bill()\n\t{\n\t\tvar len = parent.frames[1].document.forms[0].elements.length;\n\t\tfor(var i=0;i<len;i++)\n\t\t{\n\t\t\tparent.frames[1].document.forms[0].elements(i).disabled=false;\n\t\t}\n\t\tdocument.forms[0].remove_button.disabled=true;\n\t}\n</script>\n\t\t\n  \t</head>\n\t<body onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      onSelect=\"codeArrestThruSelect();\">\n\t<form name=\'BillSlmtTypeForm\' id=\'BillSlmtTypeForm\' method=\'post\' action=\'\'  scrolling=no >\t\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\t\n\t<tr>\n\t<td class=\"label\" width=\"25%\" ></td>\n\t<input type=\'hidden\' name=\'rec_ref\' id=\'rec_ref\' id=\'rec_ref\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<!--<td class=\"label\" width=\"25%\"><INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"    OK    \" onClick=\'billslmtprocess()\'></td>\n\t-->\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<td class=\"label\" width=\"25%\"></td>\n<td class=\"label\" width=\"25%\"><!-- <INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"    ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="    \" onClick=\'billslmtprocess()\' DISABLED> -->\n<input type=\'button\'  name=\"accept_button\" id=\"accept_button\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" class=\'button\' onclick=\'acceptbillslmt()\'>\n<input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" class=\'button\' onClick=\'cancel()\'></td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<td class=\"label\" width=\"25%\"><!-- <INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"    ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onClick=\'billslmtprocess()\' DISABLED> -->\n<input type=\'button\'  name=\"accept_button\" id=\"accept_button\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" class=\'button\' onclick=\'acceptbillslmt()\'>\n<!--<input type=\'button\' class=\'button\' onclick=\'enableAllElements_billslmt_remove();remove_billslmt()\' name=\"remove_button\" id=\"remove_button\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">-->\n<!--<input type=\'button\' class=\'button\' onclick=\'enableAllElements_bill()\' name=\"modify_button\" id=\"modify_button\"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >-->\n<input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" class=\'button\' onClick=\'cancel()\'></td>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<td class=\"label\" width=\"25%\"><input type=\'button\' class=\'button\' onclick=\'enableAllElements_billslmt_remove();remove_billslmt()\' name=\"remove_button\" id=\"remove_button\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\n<input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</tr>         \n</table> \n<input type=\'hidden\' name=\'totalCashAmtColl\' id=\'totalCashAmtColl\' id=\'totalCashAmtColl\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'strBillDocCode\' id=\'strBillDocCode\' id=\'strBillDocCode\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'strBillDocNum\' id=\'strBillDocNum\' id=\'strBillDocNum\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'restrictEligibility\' id=\'restrictEligibility\' id=\'restrictEligibility\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'siteCouponInSlmt\' id=\'siteCouponInSlmt\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'action_ind\' id=\'action_ind\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n</form>\t \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
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
	String action_ind=request.getParameter("action");	
	String disabled_field="";
	String rec_ref=request.getParameter("rec_ref");
	//Added below Parm by Rajesh V - KDAH-CRF-339.2
	String totalCashAmtColl = request.getParameter("Cash_checklimit");
	String restrictEligibility = request.getParameter("restrictEligibility");
	
	//V210211
	Connection con = null;
	con	=	ConnectionManager.getConnection(request); 
	boolean siteCouponInSlmt = false;
	try {
		 siteCouponInSlmt = CommonBean.isSiteSpecific(con, "BL", "TO_ENABLE_COUPON_IN_SETTLEMENT");	
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		ConnectionManager.returnConnection(con, request);
	}
	//V210211
	
	if(totalCashAmtColl == null || "null".equals(totalCashAmtColl)){
		totalCashAmtColl = "0";
	}
	
	if(action_ind==null || action_ind.equals("")) action_ind="";
	

	if(action_ind.equals("modify")||action_ind.equals("add"))
	{
		disabled_field="disabled";
	}
	else{
		disabled_field="";
	}
	
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
	
	
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block16_0Bytes, _wl_block16_0);
            _bw.write(_wl_block16_1Bytes, _wl_block16_1);
            _bw.write(_wl_block16_2Bytes, _wl_block16_2);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rec_ref));
            _bw.write(_wl_block22Bytes, _wl_block22);

if(action_ind.equals("add"))
{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
			
}
else if(action_ind.equals("modify")) 
	{


            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled_field));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);

	}
else{
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled_field));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);

}
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalCashAmtColl ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strbilldoctypecode ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strbilldocnum ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(restrictEligibility ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(siteCouponInSlmt));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(action_ind));
            _bw.write(_wl_block42Bytes, _wl_block42);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
