package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blbillslmtservicelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtServiceList.jsp", 1743571053711L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script type=\"text/javascript\">\n$(document).ready(function(){\n\n\t  $(\".fields\").click(function(){\n\t\t  \n\t\t  var index = $(\'#ServiceTable tr\').index($(this).closest(\'tr\'));\n\t\t  index= index-1;\n\t\t  var params=\"operation=INCLUDE\"\n\t\t  +\"&billdocnum=\"+eval(\"document.BillSlmtDetForm.billdocnum\").value+\"&billdoctypecode=\"+eval(\"document.BillSlmtDetForm.billdoctypecode\").value +\"&service_date=\"+eval(\"document.BillSlmtDetForm.service_date\"+index).value\n\t\t  +\"&trx_doc_ref=\"+eval(\"document.BillSlmtDetForm.trx_doc_ref\"+index).value +\"&trx_doc_ref_line_num=\"+eval(\"document.BillSlmtDetForm.trx_doc_ref_line_num\"+index).value +\"&trx_doc_ref_seq_num=\"+eval(\"document.BillSlmtDetForm.trx_doc_ref_seq_num\"+index).value\n\t\t  +\"&billing_service=\"+eval(\"document.BillSlmtDetForm.billing_service\"+index).value+\"&upd_net_charge_amt=\"+eval(\"document.BillSlmtDetForm.upd_net_charge_amt\"+index).value+\"&charge_amt=\"+eval(\"document.BillSlmtDetForm.charge_amt\"+index).value\n\t\t  +\"&settled_amt=\"+eval(\"document.BillSlmtDetForm.settled_amt\"+index).value;\n \t\t  \n\t\t  \n\t\t  $.ajax({\n                    url:\"../../eBL/jsp/BLBillSlmtServiceListStorage.jsp\",\n                    type:\'post\',\n                    data: params, \n                    success: function(data) {\n                        var obj = jQuery.parseJSON(data);                      \n                        //alert(obj.flag);\n                        if(obj.flag==\"SUCCESS\"){\n                        \twindow.returnValue=\"SUCCESS\";\n                        \twindow.close();\n                        }\n                    }\n\t\t          });  \n   \n\t\t});\t  \n\n\t  \n});\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\'javascript\'>\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n\t\t\t\tthead td, thead td.locked\t{\n\t\t\t\tbackground-color: navy;\n\t\t\t\tcolor: white;\n\t\t\t\tposition:relative;}\t\n\t\t\t\tthead td {\n\t\t\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \n\t\t\t\tz-index: 20;}\n\t\t\t\tthead td.locked {z-index: 30;}\n\t\t\t\ttd.locked,  th.locked{\n\t\t\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\t\t\tposition: relative;\n\t\t\t\tz-index: 10;}\n\t\t\t\ttd.locked,  th.locked{\n\t\t\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\t\t\tposition: relative;\n\t\t\t\tz-index: 10;}\n\t\t\t</style>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<script>\t\n\nvar firstTimeChange = \'Y\';\n/*Karthik added the below Scripts to add link for Package Details - Starts*/\n\nasync function openLinkScreen(pkgCode,pkgSeqNo,patientId){\n\t//alert(pkgCode+pkgSeqNo+patientId);\n\tvar dialogUrl       = \"../../eBL/jsp/BLBillSlmtPkgInfo.jsp?pkgCode=\"+pkgCode+\"&pkgSeqNo=\"+pkgSeqNo+\"&patientId=\"+patientId;  \n\tvar dialogFeatures  = \"dialogHeight:\" + \"20\" + \"; dialogWidth:\" + \"70\" +\" ; scroll=false; \";\n\tvar returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);\n}\n\n/*Karthik added the below Scripts to add link for Package Details - Ends*/\n\tfunction putdeci(object)\n\t{\n\t\tif(object.value!=\'\')\n\t\t{\n\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\tputDecimal(object,17,decimal);\n\t\t}\n\t}\n\n\tfunction funServiceDet()\n\t{\n\t\tvar amt_sett=document.forms[0].billslmtamtdet.value;\n\t\tvar sett_amt=this.document.forms[0].total_settled_amt.value;\t\t\t\n\t\tif(amt_sett!=\"\")\n\t\t{\n\t\tif(parseFloat(amt_sett)<parseFloat(sett_amt))\n\t\t{\n\t\t\talert(getMessage(\"BL9628\",\"BL\"));\n\t\t\t document.forms[0].billslmtamtdet.select();\n\t\t\t return false;\n\t\t }\t\t\n\t\tvar out_standing_amt=document.forms[0].billpayableamt.value;\n\t\tif(parseFloat(amt_sett)>parseFloat(out_standing_amt))\n\t\t{\t\t\t\n\t\t\talert(getMessage(\"BL9614\",\"BL\"));\n\t\t\t document.forms[0].billslmtamtdet.select();\n\t\t\t return false;\n\t\t}\n\t\t}//document.forms[0].submit();\n\t}\n\n\n\tfunction funCurStlmt()\n\t{\t\t\n\t\tvar total_records=document.forms[0].total_records.value;\t\t\n\t\tvar v_tot_curr_stlmt=document.forms[0].tot_curr_stlmt.value;\n\t\tvar pay_amt=this.document.forms[0].billpayableamt.value;\n\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar curr_set_t=eval(\"document.forms[0].curr_set\"+j);\n\t\t\tvar curr_set=curr_set_t.value;\n\n\t\t\tif(pay_amt < 0)\n\t\t\t{\n\t\t\tvar temp=curr_set.indexOf(\'-\');\n\t\t\tif(temp != -1 ) \n\t\t\t{\n\t\t\t\tif(temp != 0 ) \n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"INVALID_NUMBER_FORMAT\",\"common\"));\n\t\t\t\t\tcurr_set_t.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\t}\n\t\t\tvar unavailed_yn=eval(\"document.forms[0].unavailed_yn\"+j);\n\t\t\tif(pay_amt>0 && curr_set<0)\n\t\t\t//if(parseFloat(Math.abs(pay_amt))>0 && parseFloat(Math.abs(curr_set))<0)//added parseFloat(Math.abs) for package billing\n\t\t\t{\t\t\t\t\n\t\t\t\tif(unavailed_yn==\"N\")\n\t\t\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\t\t\t\tcurr_set_t.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(pay_amt<0 && curr_set>0)\n\t\t\t{\t\t\t\t\n\t\t\t\talert(getMessage(\"BL9863\",\"BL\"));\n\t\t\t\tcurr_set_t.focus();\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar pend_amt=eval(\"document.forms[0].pend_set\"+j);\n\t\t\tvar curr_set=eval(\"document.forms[0].curr_set\"+j);\n\n\t\t\tif(curr_set.value==\"\")\n\t\t\t{\n\t\t\t\tcurr_set.value=0.00;\n\t\t\t\tputdeci(curr_set);\t\t\t\t\n\t\t\t\tcurr_set.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif ( parseFloat(Math.abs(curr_set.value)) > parseFloat(Math.abs(pend_amt.value)))\n\t\t\t{\n\t\t\t alert(getMessage(\"BL9658\",\"BL\"));\t\t\t\n\t\t\tcurr_set.select();\n\t\t\treturn false;\n\t\t}\n\t\ttotCurrSlmt(\'Y\');\n\t\n\t}\n}\n\nfunction callServDist()\n{\n\tvar decimal=document.forms[0].noofdecimal.value;\n\tvar total_records=document.forms[0].total_records.value;\t\n\tvar rounding_amt = document.forms[0].strroundingamt.value;\n\t\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tif((j+1) == total_records)\n\t\t{\n//\t\t\tvar charge_amt=eval(\"document.forms[0].charge_amt\"+j);\t\n//\t\t\tcharge_amt.value = parseFloat(charge_amt.value)+parseFloat(rounding_amt);\n//\t\t\tvar pend_amt=eval(\"document.forms[0].pend_set\"+j);\t\n//\t\t\tpend_amt.value = charge_amt.value;\n//\t\t\tputdeci(charge_amt);\n//\t\t\tputdeci(pend_amt);\n\t\t}\n\t}\n\n\tfunCurrMultSlmt();\n\n}\n\nfunction funCurrMultSlmt()\n{\n\tvar s_amt=this.document.forms[0].billslmtamtdet.value;\n\tvar p_amt=this.document.forms[0].billpayableamt.value;\n\tvar decimal=document.forms[0].noofdecimal.value;\n\n\t\n\tif(s_amt!=\"\")\n\t{\n\t\tvar total_records=document.forms[0].total_records.value;\t\n\t\tif(total_records>0)\n\t\t{\n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar pend_amt=eval(\"document.forms[0].pend_set\"+j);\t\t\t  \n\t\t\t    var v_pend_amt=pend_amt.value;\n\t\t\t    \t\t\t\n\t\t\t    var curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\t\t  \n\t\t\t    if(p_amt>=0)\n\t\t\t\t{\n\t\t\t\t\tif(s_amt>=0)\n\t\t\t\t    {\n\t\t\t\t\t\tif(parseFloat(s_amt) > parseFloat(pend_amt.value))\n\t\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\t\tcurr_set.value=v_pend_amt;\t\t\t\t  \n\t\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\t\tif(parseFloat(s_amt)>0)\n\t\t\t\t\t\t\t{\t\t\t\t\t \n\t\t\t\t\t\t\t\tcurr_set.value=s_amt;\n\t\t\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tcurr_set.value=0;\n\t\t\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t\t}\t\t\t\t \t\t\t\t \n\t\t\t\t\t\t }\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tcurr_set.value=0;\n\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t    \n\t\t\t\tif(p_amt<0)\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tif(s_amt<0)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseFloat(pend_amt.value) > parseFloat(s_amt))\n\t\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\t\tcurr_set.value=pend_amt.value;\t\t\t\t \n\t\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\t\tif(parseFloat(s_amt)<0)\n\t\t\t\t\t\t\t{\t\t\n\t\t\t\t\t\t\t\tcurr_set.value=s_amt;\t\t\t\t  \t\t\t\t\t\t\n\t\t\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tcurr_set.value=0;\n\t\t\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t\t\t}\t\t\t\t \t\t\t\t \n\t\t\t\t\t\t }\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tcurr_set.value=0;\n\t\t\t\t\t\tputdeci(curr_set);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\t\t//s_amt=Math.ceil(s_amt);\n\t\t\t\ts_amt=parseFloat(s_amt)-parseFloat(v_pend_amt);\t\t\n\t\t\t\ts_amt=s_amt.toFixed(decimal);\n//\t\t\t\ttotCurrSlmt();\n\t\t\t}\n\t\t\ttotCurrSlmt();\n\t\t}\n\t}\n}\n\n \nfunction totCurrSlmt(on_blur_check)\n{\n\tvar tot_curr_set=0.0;\n\tvar tot_curr_set_no_roundoff=0.0;\n\tvar tot_charge_amt=0.0;\n\tvar v_curr_set=\"\";\n\tvar a1=new Array();\n\tvar a2=new Array();\n\tvar billpayableamt=this.document.forms[0].billpayableamt.value;\n\tvar s_amt=this.document.forms[0].billslmtamtdet.value;\n\tvar strroundingamt=document.forms[0].strroundingamt.value;\t\n\tvar total_records=document.forms[0].total_records.value;\n\tvar decimal=document.forms[0].noofdecimal.value;\n\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tv_curr_charge_amt=eval(\"document.forms[0].charge_amt\"+j);\n\t\ta2[j]=v_curr_charge_amt.value;\n\t\t\n\t\tif(a2[j]==\"\"){a2[j]=\"0.0\";}\n\n\t\ttot_charge_amt=parseFloat(tot_charge_amt) + parseFloat(a2[j]);\n\t}\n\ttot_charge_amt = tot_charge_amt.toFixed(decimal);\n\tdocument.forms[0].net_total.value=tot_charge_amt;\n\tputdeci(document.forms[0].net_total);\n\t//karthik added\t- SCF 272\t\t    \n\tvar v_curr_set_no_roundoff=\"\";\t\t\t  \n\tvar a1_no_roundoff=new Array();\n    \n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tv_curr_set=eval(\"document.forms[0].curr_set\"+j);\n\t\ta1[j]=v_curr_set.value;\n\t\tif(a1[j]==\"\"){a1[j]=\"0.0\";}\n\t\ttot_curr_set=parseFloat(tot_curr_set) + parseFloat(a1[j]);\n\t\t\n\t\t//karthik added logic here - starts SCF 272 \n\t\tv_curr_set_no_roundoff=eval(\"document.forms[0].pend_set_no_roundoff\"+j);\n\t\ta1_no_roundoff[j]=v_curr_set_no_roundoff.value;\n\t\tif(a1_no_roundoff[j]==\"\"){a1_no_roundoff[j]=\"0.0\";}\t\n\t\t\n\t\tif(parseFloat(a1_no_roundoff[j]).toFixed(decimal)==parseFloat(a1[j]).toFixed(decimal)){\n\t\ttot_curr_set_no_roundoff=parseFloat(tot_curr_set_no_roundoff) + parseFloat(a1_no_roundoff[j]);\n\t\t}else{\n\t\ttot_curr_set_no_roundoff=parseFloat(tot_curr_set_no_roundoff) + parseFloat(a1[j]);\t\n\t\t}\n\t\t//karthik added logic here - ends SCF 272 \n\t\t\n\t}\n\t//Changes for KDAH-318\n\tvar billLevelTax = this.document.forms[0].billLevelTax.value;\t\n\tvar addlChargeAmt = this.document.forms[0].addlChargeAmtForBill.value;\n\tif(addlChargeAmt == \'\'){\n\t\taddlChargeAmt = 0;\n\t}\n\n\tif(billLevelTax == \'Y\' && addlChargeAmt > 0 && firstTimeChange == \'Y\'){\t\n\t\t\n\t\ttot_curr_set = this.document.forms[0].billslmtamtdet.value;\t\t\n\t\tfirstTimeChange = \'N\';\n\t}\n\telse{\n\t\ttot_curr_set = tot_curr_set.toFixed(decimal);\n\t}\n\t//Changes for KDAH-318\n\t\n\t//tot_curr_set_no_roundoff=tot_curr_set_no_roundoff.toFixed(decimal); SCF 272\n\tdocument.forms[0].tot_curr_stlmt.value=tot_curr_set;\n\tdocument.forms[0].tot_curr_stlmt_no_roundoff.value=tot_curr_set_no_roundoff;\t//SCF 272\n\n\n\tvar total_curr_stlmt=eval(\"document.forms[0].tot_curr_stlmt\");\t\n\tputdeci(total_curr_stlmt);\n\tif(parseFloat(billpayableamt) < parseFloat(tot_curr_set))\n\t{\n\t\ttot_curr_set=parseFloat(tot_curr_set) + parseFloat(strroundingamt);\n\t\ttot_curr_set = tot_curr_set.toFixed(decimal);\n\t}\n\n\tif(on_blur_check == \'Y\')\n\t{\n\t\tthis.document.forms[0].billslmtamtdet.value=tot_curr_set;\n\t\tvar billslmtamtdet=eval(\"this.document.forms[0].billslmtamtdet\");\n\t\tputdeci(billslmtamtdet);\n\t}\n}\n\nfunction ChkNumberInput1(fld, e, deci,sn)\n{\n\tvar strCheck =\"\";\n\tif(this.document.forms[0].billpayableamt.value < 0)\n\t{\n\t\tif (parseInt(deci)>0)\n\t\t\tstrCheck = \'-.0123456789\';\n\t\telse\n\t\t\tstrCheck = \'-0123456789\';\t\n\t}\n\telse\n\t{\n\t\tif (parseInt(deci)>0)\n\t\t\tstrCheck = \'.0123456789\';\n\t\telse\n\t\t\tstrCheck = \'0123456789\';\t\n\t}\n\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\tif (whichCode == 13) return true;  // Enter\n\t\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\n\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif(key == \".\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'.\' char\n\tif(key == \"-\" && fld.value.indexOf(key) != -1) return false; // Not more than one \'-\' char\n}\n\nfunction slmt_amt_disabled_YN() // Called coz when the Cashcounter/user doesnt have access to modify the amount, its should be disabled\n{\n\tvar alw_co_wit_bl_slmt_yn=document.forms[0].alw_co_wit_bl_slmt_yn.value;\n\tvar called_frm=document.forms[0].called_frm.value;\n\tvar str_episode_type=document.forms[0].str_episode_type.value;\n\tvar slmt_amt_disabled_YN=document.forms[0].slmt_amt_disabled_YN.value;\n\tvar total_records=document.forms[0].total_records.value;\n\n\tif(alw_co_wit_bl_slmt_yn == \"Y\" && called_frm==\"CHECKOUT_VISIT\" && str_episode_type == \"E\")\n\t{\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar curr_set_t=eval(\"document.forms[0].curr_set\"+j);\n\t\t\tcurr_set_t.disabled=true;\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(slmt_amt_disabled_YN==\"Y\")\n\t\t{\n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar curr_set_t=eval(\"document.forms[0].curr_set\"+j);\n\t\t\t\tcurr_set_t.disabled=true;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar curr_set_t=eval(\"document.forms[0].curr_set\"+j);\n\t\t\t\tcurr_set_t.disabled=false;\n\t\t\t}\n\t\t}\n\t}\n}\n\n\t</script>\t  \n\n</HEAD>\n\t<BODY\t onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\"  onload=\'callServDist();slmt_amt_disabled_YN();\' >\n\n\t<FORM name=\'BillSlmtDetForm\' id=\'BillSlmtDetForm\' id=\'BillSlmtDetForm\' method=\'post\'  action=\'\'  scrolling=\'NO\' >\n\t<div>\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</table></div>\n<!-- \tSTYLE=\"overflow: auto; width: 1020px; height: 175px;   padding:3px; margin: 0px\" -->\n\t<div id=\"tbl-container\" >\n\t<table id=\"ServiceTable\" border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\n\t<thead><tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td width=\"5%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\t\t\n\t\t\t<td width=\"5%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\n\t\t\t<td width=\"*\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<!--<td class=\'COLUMNHEADER\' width=\'2%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>-->\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<td width=\"*\" class=\'COLUMNHEADER\'>Document Ref</td>\n\t</tr></thead>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<tbody>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n<!--<td class=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" width=\'2%\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'selected_row";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ></td>\t-->\n\t<td class=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" width=\"14%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="<INPUT TYPE=\"hidden\" name=\'service_date";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'service_date";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' SIZE=\"15\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  onBlur=\'\' readonly><input type=\'hidden\' name=\'trx_doc_ref";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'trx_doc_ref";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' > </td>\n\n<!--Added by muthu against Drug Penalty Issue on 04-06-12 Starts here -->\n\t<td class=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" width=\"14%\" >\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\n\t\t<input type=\'hidden\' name=\'billing_service";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'billing_service";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" readonly>\n\t\t<input type=\'hidden\' name=\'trx_doc_ref_line_num";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'trx_doc_ref_line_num";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" > \n\t\t<input type=\'hidden\' name=\'trx_date";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'trx_date";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" > \n\t\t<input type=\'hidden\' name=\'prt_grp_hdr_code";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'prt_grp_hdr_code";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" > \n\t\t<input type=\'hidden\' name=\'prt_grp_line_code";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'prt_grp_line_code";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" > \n\t\t<input type=\'hidden\' name=\'upd_net_charge_amt";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'upd_net_charge_amt";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" > \n\t\t<input type=\'hidden\' name=\'upd_gross_charge_amt";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'upd_gross_charge_amt";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" > \n\t</td>\t\n\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<td class=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" width=\"20%\" class=\"fields\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'<input type=\'hidden\' name=\'trx_doc_ref_seq_num";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'trx_doc_ref_seq_num";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" > </td>\n\t\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" width=\"20%\" class=\"fields\"><div name=\'description";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' size=\'40\' maxlength=\'100\'  value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' readonly>\n\t\n\t\t<input type=\'hidden\' name=\'trx_doc_ref_seq_num";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" > </td>\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t<!--Added by muthu against Drug Penalty Issue on 04-06-12 Ends Here-->\n\n\t<td class=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" width=\"5%\" class=\"fields\"><input type=\'text\' name=\'serv_qty";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'serv_qty";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' size=\'5\' maxlength=\'5\'  value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" style=\'text-align:right\' onFocus=\'\' readonly> </td>\n\n\t<td class=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" width=\"11%\" class=\"fields\"><input type=\'text\' name=\'charge_amt";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'charge_amt";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' size=\'11\' maxlength=\'11\'  value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" style=\'text-align:right\' onFocus=\'\' readonly> </td>\n\t\n\t<td class=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" width=\"11%\" class=\"fields\"><input type=\'text\' name=\'settled_amt";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'settled_amt";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" style=\'text-align:right\'  onFocus=\'\' readonly> </td>\n\t\n\t<td class=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" width=\"11%\" class=\"fields\"><input type=\'text\' name=\'pend_set";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'pend_set";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" style=\'text-align:right\' onFocus=\'\' readonly><input type=\"hidden\" name=\'pend_set_no_roundoff";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'pend_set_no_roundoff";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'  value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"> </td>\n\n\t<td class=";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" width=\"11%\" class=\"fields\"><input type=\'text\' name=\'curr_set";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'curr_set";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' size=\'11\' maxlength=\'11\'  value=\'\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,document.forms[0].noofdecimal.value))\' onBlur=\'putdeci(this);funCurStlmt()\'> </td>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t<td class=\"fields\" width=\"14%\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' > </td>\t\n\t\n\t<td class=\"fields\" width=\"14%\" >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t<a  name=\'pkgLink_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'pkgLink_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' href=\"#\" onClick =\'openLinkScreen(\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\",\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\");\' >Dtls </a>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t<input type=\'hidden\' name=\'billing_service";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" > \n\t</td>\n\t<td width=\"20%\" class=\"fields\">";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="<input type=\'hidden\' name=\'trx_doc_ref_seq_num";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" > </td>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\t\n\t<td class=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" width=\"13%\" class=\"fields\"><input type=\'password\' name=\'charge_amt";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' size=\'14\' maxlength=\'10\'  \tvalue=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' style=\'text-align:center\' onFocus=\'\' readonly autocomplete=\"off\"><!--V230508-41626 --></td>\t\n\t<td class=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" width=\"13%\" class=\"fields\"><input type=\'password\' name=\'settled_amt";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' size=\'14\' maxlength=\'10\'  value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' style=\'text-align:center\'  onFocus=\'\' readonly autocomplete=\"off\"><!--V230508-41626 --> </td>\t\n\t<td class=";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" width=\"13%\" class=\"fields\"><input type=\'password\' name=\'pend_set";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' style=\'text-align:center\' onFocus=\'\' readonly autocomplete=\"off\"><!--V230508-41626 --><input type=\"hidden\" name=\'pend_set_no_roundoff";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"></td>\n\t<td class=";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" width=\"13%\" class=\"fields\"><input type=\'password\' name=\'curr_set";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' size=\'14\' maxlength=\'10\'  value=\'\'  style=\'text-align:center\' readonly autocomplete=\"off\"><!--V230508-41626 -->\t</td>\n\t<input type=\'hidden\' name=\'unavailed_yn";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'unavailed_yn";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" > \n\t\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\t\n\t\n\t<td  width=\"13%\" class=\"fields\">";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="<input type=\'hidden\' name=\'charge_amt";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'  value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' style=\'text-align:right\' onFocus=\'\' readonly> </td>\n\t\n\t<td  width=\"13%\" class=\"fields\">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="<input type=\'hidden\' name=\'settled_amt";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'   value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' style=\'text-align:right\'  onFocus=\'\' readonly> </td>\n\t\n\t<td  width=\"13%\" class=\"fields\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="<input type=\'hidden\' name=\'pend_set";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' style=\'text-align:right\' onFocus=\'\' readonly> <input type=\"hidden\" name=\'pend_set_no_roundoff";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"> </td>\n\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t<input type=\'hidden\' name=\'curr_set";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'  value=\'\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput1(this,event,document.forms[0].noofdecimal.value))\' onBlur=\'putdeci(this);funCurStlmt()\'> \n<!-- \t</td> -->\n\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\t\n\t\t<td width=\"*\" class=\"fields\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\n\t\n\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\n</tr>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\t\n</tbody>\n</table>\n<input type=\"hidden\" name=\"billdoctypecode\" id=\"billdoctypecode\" value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n<input type=\"hidden\" name=\"billdocnum\" id=\"billdocnum\" value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n<input type=\"hidden\" name=\"all_service_criteria\" id=\"all_service_criteria\" value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n<input type=\"hidden\" name=\"all_services\" id=\"all_services\" value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n<input type=\"hidden\" name=\"slmt_amt_disabled_YN\" id=\"slmt_amt_disabled_YN\" value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n<input type=\"hidden\" name=\"billslmtamtdet\" id=\"billslmtamtdet\" value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n<input type=\"hidden\" name=\"total_settled_amt\" id=\"total_settled_amt\" value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n<input type=\"hidden\" name=\"billLevelTax\" id=\"billLevelTax\" value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n<input type=\"hidden\" name=\"addlChargeAmtForBill\" id=\"addlChargeAmtForBill\" value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n<input type=\"hidden\" name=\"billpayableamt\" id=\"billpayableamt\" value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'\n<input type=\"hidden\" name=\'optionParam\' id=\'optionParam\'  value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n<input type=\"hidden\" name=\'tot_curr_stlmt_no_roundoff\' id=\'tot_curr_stlmt_no_roundoff\'  value=\'\'>\n<INPUT TYPE=\"HIDDEN\" name=\"pagecloseind\" id=\"pagecloseind\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"0\">\t\n<INPUT TYPE=\"HIDDEN\" name=\"slmtdate\" id=\"slmtdate\"\t   SIZE=\"20\" MAXLENGTH=\"20\" \tVALUE=\"\"> \n<INPUT TYPE=\"HIDDEN\" name=\"slmtdocrefdesc\" id=\"slmtdocrefdesc\" SIZE=\"50\" MAXLENGTH=\"100\"\tVALUE=\"\">\t\n<INPUT TYPE=\"HIDDEN\" name=\"slmtdocref\" id=\"slmtdocref\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"\">\n<INPUT TYPE=\"HIDDEN\" name=\"str_ext_acc_facility_id\" id=\"str_ext_acc_facility_id\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"strfacilityid\" id=\"strfacilityid\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n<input type= \"hidden\" name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n<input type= \"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n<input type=\'hidden\' name=\"strroundingamt\" id=\"strroundingamt\" value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n<input type=\'hidden\' name=\"slmt_amt_disabled_YN\" id=\"slmt_amt_disabled_YN\" value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n<input type=\'hidden\' name=\"called_frm\" id=\"called_frm\"  value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n<input type=\'hidden\' name=\"alw_co_wit_bl_slmt_yn\" id=\"alw_co_wit_bl_slmt_yn\"  value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n<INPUT TYPE=\"HIDDEN\" name=\"str_episode_type\" id=\"str_episode_type\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n</FORM>\n\n<table width=\"100%\">\n<tr>\n<td width=\"94%\" >&nbsp;</td>\n<td width=\"*\" >\n<!-- <class=\'button\' button id=\"selectedServiceList\" name=\"Submit\">Submit</button> -->\n<!-- <input class=\'button\' type=\"button\" name=\'selectedServiceList\' id=\'selectedServiceList\' id=\'selectedServiceList\' value=\'Submit\'> -->\n<input type=\"hidden\" name=\'selectedIndex\' id=\'selectedIndex\' id=\'selectedIndex\' >\n\n</td>\n</tr>\n</table>\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );
	
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String params = request.getQueryString(); 
            _bw.write(_wl_block6Bytes, _wl_block6);

 	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";
	Connection con = null;
	PreparedStatement pstmt = null;PreparedStatement pstmt1 = null;
	ResultSet rs = null;  ResultSet rs1 = null;ResultSet rscurr=null;
	//ResultSet rs2 = null unused
	
	ResultSet rs2 = null; //muthu
	ResultSet rs3 = null; //muthu
	PreparedStatement pstmt2 = null; //muthu
	PreparedStatement pstmt3 = null; //muthu
	String str_ext_acc_facility_id = "", strfacilityid = "", strbilldoctypecode="", strbilldocnum="";
	String strmoduleid="",strfunctionid="",strroundingamt="",str_total_net_charge="",strbillpayableamt="";
	String struser=""; String  classval="",strItemServCode="";
	int noofdecimal=2, total_records=0,total_rec_for_check=0;
	double d_total_net_charge=0,d_billpayableamt=0;

	String slmt_amt_disabled_YN="";
	String called_frm="",alw_co_wit_bl_slmt_yn="N",str_episode_type="";
	String unavailed_yn="N";
	double tempSlmtNoRoundOff=0; // SCF 272
	String optionParam="";
	String billslmtamtdet="",total_settled_amt="",billLevelTax="",addlChargeAmtForBill="";

	billslmtamtdet=request.getParameter("billslmtamtdet");
	total_settled_amt=request.getParameter("total_settled_amt");
	billLevelTax=request.getParameter("billLevelTax");
	addlChargeAmtForBill=request.getParameter("billdoctypecode");
	optionParam=request.getParameter("all_services");
	String service_selected=request.getParameter("service_selected");
	

            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		CurrencyFormat cf1 = new CurrencyFormat();
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{	noofdecimal  =  rscurr.getInt(1);}	
			if(rscurr != null) rscurr.close();
			pstmt.close();
		}catch(Exception e) 
		{
			System.out.println("3="+e.toString());
		}


		System.out.println("Query String in Service :"+request.getQueryString());
		strbilldoctypecode = request.getParameter("billdoctypecode");	
		//strbilldoctypecode = request.getParameter("bill_doc_type_selected");	
		if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";		
		strbilldocnum = request.getParameter("billdocnum");	
		//strbilldocnum = request.getParameter("bill_doc_no_selected");	
		if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";
		strfacilityid = request.getParameter("facilityid");	
		if(strfacilityid==null || strfacilityid.equals("")) strfacilityid="";
		struser = request.getParameter("loggeduser");		
		if(struser==null || struser.equals("")) struser="";	
		strmoduleid = request.getParameter("strmoduleid");		
		if(strmoduleid==null || strmoduleid.equals("")) strmoduleid="";	
		strfunctionid = request.getParameter("strfunctionid");		
		if(strfunctionid==null || strfunctionid.equals("")) strfunctionid="";
		
		

		strbillpayableamt = request.getParameter("billpayableamt");	
		if(strbillpayableamt==null || strbillpayableamt.equals("")) strbillpayableamt="0";
		
		
		

		d_billpayableamt = Float.parseFloat(strbillpayableamt);

		strroundingamt = request.getParameter("strroundingamt");
		if ( strroundingamt == null || strroundingamt.equalsIgnoreCase("null")) 
		{
			strroundingamt ="0";
		}
		
		strroundingamt = cf1.formatCurrency(strroundingamt,noofdecimal);
//		System.out.println("strroundingamt service1" + strroundingamt);

		slmt_amt_disabled_YN = request.getParameter("slmt_amt_disabled_YN");
		if(slmt_amt_disabled_YN == null) slmt_amt_disabled_YN="";

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

		str_episode_type=request.getParameter("episodetype");
		if(str_episode_type == null) str_episode_type="";

            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(strmoduleid.equals("PH") || strmoduleid.equals("ST")) //&& (strfunctionid.equals("DIS")|| strfunctionid.equals("")))
		{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block1Bytes, _wl_block1);

			
		}
		else
		{

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block1Bytes, _wl_block1);
		
		}		

            _bw.write(_wl_block22Bytes, _wl_block22);

	/**************Added for Package Billing*****************stsrts****/
	//to get the UNAVAIL PKG BLNG SERV CODE from bl_parameters
		String unavail_service_code= request.getParameter("unavail_service_code");
		if(unavail_service_code == null) unavail_service_code="";
	/*******************Package Billing**********************ends******/
		//totalRecords=1;
		String strblngservdesc= "";
		int i=0;
		String sql="";
		String strServiceDate="",strTrxDate="";
		String strBlngservCode="";
		String strLongDesc="";
		String strUpdNetChargeAmt="", strNetChrgAmtAftRndAdj="", strUpdGrossChargeAmt="";
		String strPrtGrpHdrCode="",strPrtGrpLineCode="";
		String strTotalSettAmt="";
		String strTrxDocRef="";
		String strTrxDocRefLineNum="";
		String strTrxDocRefSeqNum="";
		String strOperatingFacId="";
		String strServQty="";
		/*Karthik added the below variables to add link for Package Details - Starts*/
		String strPkgInd="";
		String strPkgSeqNo="";
		String strPatientId="";
		/*Karthik added the below variables to add link for Package Details - ends*/
		//strbilldocnum="12002040";
		double dPendStlmt=0;
		
		String condition=""; 
		System.out.println("service_selected:"+service_selected);
	/*	if(service_selected!=null){
			condition= "and a.blng_serv_code='"+service_selected+"'";
		} */
		
		String beanId = "BillDetailsBean";
		String beanName = "eBL.BLBillDetailsBean";
		BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
		HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
		ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
		
		StringBuilder docNumList=new StringBuilder();
		StringBuilder docTypeCode=new StringBuilder();
		
		for(BLBillDetailsBean beanObj:billDetailList ){
			docNumList.append("'");
			docNumList.append(beanObj.getDocNum());
			docNumList.append("'");
			docNumList.append(",");
			
			docTypeCode.append("'");
			docTypeCode.append(beanObj.getDocTypeCode());
			docTypeCode.append("'");
			docTypeCode.append(",");		
		}
		docNumList.deleteCharAt(docNumList.length()-1);
		docTypeCode.deleteCharAt(docTypeCode.length()-1);
		
		try
		{
			if(strmoduleid.equals("PH") || strmoduleid.equals("ST"))//&& (strfunctionid.equals("DIS")|| strfunctionid.equals("")))
			{
				 sql="Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF,a.TRX_DOC_REF_LINE_NUM,a.TRX_DOC_REF_SEQ_NUM,to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code,a.serv_item_desc,a.UPD_NET_CHARGE_AMT tot_Charge_amt,a.serv_qty,(a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,a.serv_item_code,a.package_ind,a.folio_remarks,a.patient_id  from bl_patient_charges_folio a,bl_blng_serv_lang_vw b,bl_bill_hdr c where a.blng_serv_code  = b.blng_serv_code  AND bill_doc_type_code IN(?) AND bill_doc_num IN(?) and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM   and b.language_id=?";
					if(service_selected!=null){
                    sql += " and a.blng_serv_code=? ";
					}
					sql += " union "
					 +" Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF,a.TRX_DOC_REF_LINE_NUM,a.TRX_DOC_REF_SEQ_NUM,to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code,a.serv_item_desc,a.UPD_NET_CHARGE_AMT tot_Charge_amt,a.serv_qty,(a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,a.serv_item_code,a.package_ind,replace(a.FOLIO_REMARKS,'Package-',''),a.patient_id  from bl_patient_charges_folio a,BL_PACKAGE_LANG_VW b,bl_bill_hdr c where a.blng_serv_code  = b.package_code  AND bill_doc_type_code IN(?) AND bill_doc_num IN(?) and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM   and b.language_id=? and a.package_ind ='P' ";
					if(service_selected!=null){
						sql += " and a.blng_serv_code=? ";
					}
					
			}
			else
			{
				 sql="Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF, a.TRX_DOC_REF_LINE_NUM  ,a. TRX_DOC_REF_SEQ_NUM , to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code, b.long_desc, a.UPD_NET_CHARGE_AMT tot_Charge_amt, a.serv_qty, (a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,null,a.package_ind,a.folio_remarks,a.patient_id   from bl_patient_charges_folio a,bl_blng_serv_lang_vw b,bl_bill_hdr c where a.blng_serv_code  = b.blng_serv_code  AND a.bill_doc_type_code IN(?) AND  a.bill_doc_num IN(?) and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM and b.language_id=   ?";
						if(service_selected!=null){
						sql += " and a.blng_serv_code=? ";
						}
						sql += " union "
						 + "Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF, a.TRX_DOC_REF_LINE_NUM  ,a. TRX_DOC_REF_SEQ_NUM , to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code, b.long_desc, a.UPD_NET_CHARGE_AMT tot_Charge_amt, a.serv_qty, (a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,null,a.package_ind,replace(a.FOLIO_REMARKS,'Package-',''),a.patient_id   from bl_patient_charges_folio a,BL_PACKAGE_LANG_VW b,bl_bill_hdr c where a.blng_serv_code  = b.package_code  AND a.bill_doc_type_code IN(?) AND  a.bill_doc_num IN(?) and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM and b.language_id=   ? and a.package_ind ='P'";
						if(service_selected!=null){
							sql += " and a.blng_serv_code=? ";
						}
			}
			System.out.println(sql);

			pstmt = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			if(service_selected!=null){
                pstmt.setString(1,docTypeCode.toString());
                pstmt.setString(2,docNumList.toString());
                pstmt.setString(3,locale);
                pstmt.setString(4,service_selected);
                pstmt.setString(5,docTypeCode.toString());
                pstmt.setString(6,docNumList.toString());
                pstmt.setString(7,locale);
                pstmt.setString(8,service_selected);
            }else{
                pstmt.setString(1,docTypeCode.toString());
                pstmt.setString(2,docNumList.toString());
                pstmt.setString(3,locale);
                pstmt.setString(4,docTypeCode.toString());
                pstmt.setString(5,docNumList.toString());
                pstmt.setString(6,locale);
            }
			
			rs = pstmt.executeQuery();	

			if(rs != null)
			{
				rs.last();
				total_rec_for_check = rs.getRow();
				rs.beforeFirst();
			}

			while(rs.next())
			{
				strOperatingFacId =  rs.getString(1);
				strTrxDocRef =  rs.getString(2);
				strTrxDocRefLineNum =  rs.getString(3);	
				strTrxDocRefSeqNum  =  rs.getString(4);	
				strServiceDate =  rs.getString(5);	
				strBlngservCode =  rs.getString(6);	
				strLongDesc =  rs.getString(7);	
				strUpdNetChargeAmt =  rs.getString(8);	
				//strTotalSettAmt=  rs.getString(8);
				strServQty =  rs.getString(9);	
				strNetChrgAmtAftRndAdj = rs.getString(10);	
				strTrxDate = rs.getString(11);	
				strPrtGrpHdrCode = rs.getString(12);	
				strPrtGrpLineCode = rs.getString(13);	
				strUpdGrossChargeAmt =  rs.getString(14);	
				strItemServCode =  rs.getString(15);
				/*Karthik added the below variables to add link for Package Details - Starts*/
				strPkgInd =  rs.getString(16);	
				strPkgSeqNo =  rs.getString(17);
				strPatientId =  rs.getString(18);	
				/*Karthik added the below variables to add link for Package Details - Ends*/


				if (strTrxDocRef == null) strTrxDocRef = "";
				if (strTrxDocRefLineNum == null) strTrxDocRefLineNum = "";
				if (strTrxDocRefSeqNum == null) strTrxDocRefSeqNum = "";
				if (strServiceDate == null) strServiceDate = "";
				if (strBlngservCode == null) strBlngservCode = "";
				if (strLongDesc == null) strLongDesc = "";
				if (strUpdNetChargeAmt == null) strUpdNetChargeAmt = "";
				if (strServQty == null) strServQty = "";
				if (strTrxDate == null) strTrxDate = "";
				if (strPrtGrpHdrCode == null) strPrtGrpHdrCode = "";
				if (strPrtGrpLineCode == null) strPrtGrpLineCode = "";
				if (strUpdGrossChargeAmt == null) strUpdGrossChargeAmt = "";
				if (strPkgInd == null) strPkgInd = "";
				if (strPkgSeqNo == null) strPkgSeqNo = "";
				if (strPatientId == null) strPatientId = "";
				
				String sql1= "Select sum(nvl(TOT_SETTLED ,0)) tot_settled_so_far  from  bl_patient_charges_slmt_dtl_vw C  where C.OPERATING_FACILITY_ID = '"+strOperatingFacId+"'  and C.trx_doc_ref='"+strTrxDocRef+"'  and C.trx_doc_ref_line_num='"+strTrxDocRefLineNum+"'  and C.trx_doc_ref_seq_num='"+strTrxDocRefSeqNum+"' ";
				pstmt1 = con.prepareStatement(sql1);
				rs1 = pstmt1.executeQuery();	
				while(rs1.next())
				{
					strTotalSettAmt=  rs1.getString(1);
			
					if (strTotalSettAmt == null) strTotalSettAmt = "";

					if(total_rec_for_check == (total_records+1))
					{
						strUpdNetChargeAmt = strNetChrgAmtAftRndAdj; 
					}
					String strUpdNetChargeAmtNoRoundOff=strUpdNetChargeAmt;//Karthik SCF 272
					strUpdNetChargeAmt = cf1.formatCurrency(strUpdNetChargeAmt,noofdecimal);
					String strTotalSettAmtNoRoundOff=strTotalSettAmt;//Karthik SCF 272
					strTotalSettAmt = cf1.formatCurrency(strTotalSettAmt,noofdecimal);
					dPendStlmt=Double.parseDouble(strUpdNetChargeAmt)-Double.parseDouble(strTotalSettAmt);
					String strPendStlmt=cf1.formatCurrency(String.valueOf(dPendStlmt),noofdecimal);
					/*karthik added code here - SCF 272*/
					if(strUpdNetChargeAmtNoRoundOff==null || "".equals(strUpdNetChargeAmtNoRoundOff)){
						strUpdNetChargeAmtNoRoundOff="0";
					}
					if(strTotalSettAmtNoRoundOff==null || "".equals(strTotalSettAmtNoRoundOff)){
						strTotalSettAmtNoRoundOff="0";
					}
					String strPendStlmtNoRoundOff=""+ (Double.parseDouble(strUpdNetChargeAmtNoRoundOff)-Double.parseDouble(strTotalSettAmtNoRoundOff));//Karthik
					if(strPendStlmtNoRoundOff==null || "".equals(strPendStlmtNoRoundOff)){
						strPendStlmtNoRoundOff="0";
					}
					tempSlmtNoRoundOff+=Double.parseDouble(strPendStlmtNoRoundOff);
					/*karthik added code here - SCF 272 */
					d_total_net_charge=d_total_net_charge+ Double.parseDouble(strUpdNetChargeAmt);
					str_total_net_charge = cf1.formatCurrency(String.valueOf(d_total_net_charge),noofdecimal);

					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block24Bytes, _wl_block24);

	if(strmoduleid.equals("PH") || strmoduleid.equals("ST"))
	{

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(strServiceDate,"DMYHMS","en",locale)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(strServiceDate,"DMYHMS","en",locale)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strTrxDocRef));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block37Bytes, _wl_block37);

		if(strItemServCode == null){
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strBlngservCode));
            _bw.write(_wl_block39Bytes, _wl_block39);

		}
		else
		{
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strItemServCode));
            _bw.write(_wl_block40Bytes, _wl_block40);

		}
	
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strBlngservCode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strTrxDocRefLineNum));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strTrxDate));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strPrtGrpHdrCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strPrtGrpLineCode));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strUpdNetChargeAmt));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strUpdGrossChargeAmt));
            _bw.write(_wl_block56Bytes, _wl_block56);

		//Added by muthuN against 33583 on 9/25/2012 Starts Here
		if(strblngservdesc == ""){
		try
		{

			if(strItemServCode != ""){
			 pstmt2 = con.prepareStatement("SELECT long_desc FROM mm_item_lang_vw WHERE ITEM_CODE = '"+strItemServCode+"' and language_id = '"+locale+"'");
			}
			else{
				pstmt2 = con.prepareStatement("SELECT long_desc FROM  bl_blng_serv_lang_vw WHERE language_id = '"+locale+"' AND blng_serv_code = '"+strBlngservCode+"'");
			}
			//pstmt2 = con.prepareStatement("SELECT SERV_ITEM_DESC FROM bl_patient_charges_folio WHERE blng_serv_code = '"+strBlngservCode+"' and SERV_ITEM_CODE = '"+strItemServCode+"'  and trx_doc_ref= '"+strTrxDocRef+"'  and trx_doc_ref_line_num= '"+strTrxDocRefLineNum+"'  and trx_doc_ref_seq_num='"+strTrxDocRefSeqNum+"'");
			rs2 = pstmt2.executeQuery();
			if ( rs2.next() && rs2 != null ) 
			{
				strblngservdesc =  rs2.getString(1);
			}		
			rs2.close();
			pstmt2.close();
			if(strblngservdesc == "" && strItemServCode != ""){
				pstmt3 = con.prepareStatement("SELECT long_desc FROM  bl_blng_serv_lang_vw WHERE language_id = '"+locale+"' AND blng_serv_code = '"+strBlngservCode+"'");
			rs3 = pstmt3.executeQuery();
			if ( rs3.next() && rs3 != null ) 
			{
				strblngservdesc =  rs3.getString(1);
			}	
			}
			if(rs3!=null && pstmt3!=null) {
			rs3.close();
			pstmt3.close();			
			}
		//Added by muthuN against 33583 on 9/25/2012 Ends Here	
			}
			catch(Exception e)
			{   
				e.printStackTrace();
				System.out.println("Exception in Drug Penalty query: "+e);
			}		
	
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strblngservdesc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strTrxDocRefSeqNum));
            _bw.write(_wl_block61Bytes, _wl_block61);

		}
		else
		{
			//Added by MuthuN against 33583 on 27-9-12
			if(strLongDesc == ""){
			pstmt3 = con.prepareStatement("SELECT long_desc FROM  bl_blng_serv_lang_vw WHERE language_id = '"+locale+"' AND blng_serv_code = '"+strBlngservCode+"'");
			rs3 = pstmt3.executeQuery();
			if ( rs3.next() && rs3 != null ) 
			{
				strLongDesc =  rs3.getString(1);
			}	
			}
			if(rs3!=null && pstmt3!=null) {
			rs3.close();
			pstmt3.close();			
			}
			//Added by MuthuN against 33583 on 27-9-12
	
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strLongDesc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strTrxDocRefSeqNum));
            _bw.write(_wl_block65Bytes, _wl_block65);

		}
	
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strServQty));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(strUpdNetChargeAmt));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(strTotalSettAmt));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(strPendStlmt));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strPendStlmtNoRoundOff));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);

		}
		else
		{

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(strServiceDate,"DMYHMS","en",locale)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(strServiceDate,"DMYHMS","en",locale)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strTrxDocRef));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(strBlngservCode));
            _bw.write(_wl_block89Bytes, _wl_block89);
		
	/*Karthik added the below link to display Package Details */
	if(strPkgInd.equals("P")){ 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(strBlngservCode));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(strPkgSeqNo));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block94Bytes, _wl_block94);
} 
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strBlngservCode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strTrxDocRefLineNum));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strTrxDate));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strPrtGrpHdrCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strPrtGrpLineCode));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strUpdNetChargeAmt));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strUpdGrossChargeAmt));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strLongDesc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strTrxDocRefSeqNum));
            _bw.write(_wl_block98Bytes, _wl_block98);
 if(strBlngservCode.equals(unavail_service_code))
	{
				unavailed_yn="Y";

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strUpdNetChargeAmt));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(strTotalSettAmt));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(strPendStlmt));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strPendStlmtNoRoundOff));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(unavailed_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
	}else{


            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(strUpdNetChargeAmt));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(strUpdNetChargeAmt));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(strTotalSettAmt));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(strTotalSettAmt));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(strPendStlmt));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(strPendStlmt));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strPendStlmtNoRoundOff));
            _bw.write(_wl_block122Bytes, _wl_block122);
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
	
	}

					}


            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(strTrxDocRef));
            _bw.write(_wl_block126Bytes, _wl_block126);
            _bw.write(_wl_block127Bytes, _wl_block127);

					total_records++;
					i++;	
				}
				if(rs1 != null) rs1.close();
				pstmt1.close();
			}
			if(rs != null) rs.close();
			pstmt.close();
		}
		catch(Exception e) 
		{
			System.out.println("Error:"+e);
		}
		

	}catch(Exception e) 
	{ 
	}
	finally 
	{			
		ConnectionManager.returnConnection(con, request);	
	}

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(request.getParameter("all_service_criteria")));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(optionParam));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(slmt_amt_disabled_YN));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(billslmtamtdet));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(total_settled_amt));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(billLevelTax));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(addlChargeAmtForBill));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(optionParam));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(str_ext_acc_facility_id));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(strroundingamt));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(slmt_amt_disabled_YN));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block149Bytes, _wl_block149);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PENDING_SETTLEMENT.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AMT_SETTLED.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PENDING_SETTLEMENT.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
