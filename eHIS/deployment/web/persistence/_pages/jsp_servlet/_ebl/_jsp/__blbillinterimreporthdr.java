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
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillinterimreporthdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillInterimReportHdr.jsp", 1716369613908L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<HTML>\n\t\t<HEAD>\n\t\t\t<TITLE>\n\t\t\tInterim Bill Generation\n\t\t\t</TITLE>\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eBL/js/BLInterimBillReport.js\'></script>\n            <script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script>alert(getMessage(\"BL2205\",\"BL\"));</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\t\t\n\t<script>\n\n\t\t\tasync function nursinglkup(nursing_unit_desc,nursing_unit_code,empty_chk)\n\t\t    {\t\t\t\n\t\t\t\tif(empty_chk==\'Y\' && nursing_unit_desc.value==\'\')\n\t\t\t\t{\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tvar locale  = document.forms[0].locale.value;\t\t\n\t\t\t\tvar facility_id  = document.forms[0].facility_id.value;\t\t\n\t\t\t\t//var target\t\t\t= document.forms[0].from_nursing_unit;\n\t\t\t\tvar retVal\t\t\t=  new String();\n\t\t\t\tvar dialogTop\t= \"40\";\n\t\t\t\tvar dialogHeight\t\t= \"10\" ;\n\t\t\t\tvar dialogWidth\t= \"40\" ;\n\t\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\t\tvar title\t\t\t= getLabel(\"Common.nursingUnit.label\",\"COMMON\");\n\t\t\t\t\n//\t\t\t\tvar sql1=\"SELECT DISTINCT G.NURSING_UNIT_CODE code,G.SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW G, IP_EPISODE H, IP_OPEN_EPISODE I WHERE G.FACILITY_ID =\'\"+facility_id+\"\' AND G.FACILITY_ID = H.FACILITY_ID AND G.NURSING_UNIT_CODE = H.CUR_WARD_CODE AND H.FACILITY_ID = I.FACILITY_ID AND H.EPISODE_ID = I.OPEN_EPISODE_ID AND UPPER(G.LANGUAGE_ID) = UPPER(\'\"+locale+\"\') and upper(G.NURSING_UNIT_CODE) like upper(?) and upper(G.SHORT_DESC) like upper(?) order by 1\"; \n\n//PE Changes\n\t\t\t\tvar sql1=\"SELECT DISTINCT G.NURSING_UNIT_CODE code, G.SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW G, IP_OPEN_EPISODE I WHERE G.FACILITY_ID =\'\"+facility_id+\"\' AND G.NURSING_UNIT_CODE = i.CUR_WARD_CODE AND UPPER(G.LANGUAGE_ID) = UPPER(\'\"+locale+\"\') and upper(G.NURSING_UNIT_CODE) like upper(?) and upper(G.SHORT_DESC) like upper(?) order by 1\"; \n\n\t\t\t\tvar argArray = new Array();\n\t\t\t\tvar namesArray = new Array();\n\t\t\t\tvar valuesArray = new Array();\n\t\t\t\tvar datatypesArray = new Array();\n\t\t\t\targArray[0] = sql1;\n\t\t\t\targArray[1] = namesArray;\n\t\t\t\targArray[2] = valuesArray;\n\t\t\t\targArray[3] = datatypesArray;\n\t\t\t\targArray[4] = \"1,2\";\n\t\t\t\targArray[5] = nursing_unit_desc.value;\t\t\t\t\n\t\t\t\targArray[6] = DESC_LINK;\n\t\t\t\targArray[7] = DESC_CODE;\t\t\n\t\t\t\tretArray = await CommonLookup( title, argArray );\t\n                var ret1=unescape(retArray);\n\t\t\t\t\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n//\t\t\t\talert(\"retArray :\"+retArray);\n\t\t\t\t//retArray=unescape(retArray);\n\t\t\t\tif(retArray != null && retArray !=\"\")\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t//nursing_unit_code.value=decodeURIComponent(retArray[0]);\n\t\t\t\t\tnursing_unit_code.value=arr[0];\n\t\t\t\t\tnursing_unit_desc.value=arr[1];\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n                    nursing_unit_code.value = arr[0]; \n\t\t\t        nursing_unit_desc.value = arr[1];  \n\t\t\t\t\t//nursing_unit_code.value=\"\";\n\t\t\t\t\t//nursing_unit_desc.value=\"\";\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\n\n\t\t\tasync function payerlkup(clng_evnt)\n\t\t\t{\n\t\t\t\t\n\t\t\t\tvar target\t\t\t= document.forms[0].payer;\t\t\n\n\t\t\t\tif(clng_evnt == \'B\')\n\t\t\t\t{\n\t\t\t\t\tif( target.value == \'\')\n\t\t\t\t\t{\t\n\t\t\t\t\t\ttarget.value = \'\';\n\t\t\t\t\t\tdocument.forms[0].payer_code.value= \'\';\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\tvar retVal\t\t\t=  new String();\n\t\t\t\tvar dialogTop\t= \"40\";\n\t\t\t\tvar dialogHeight\t\t= \"10\" ;\n\t\t\t\tvar dialogWidth\t= \"40\" ;\n\t\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\t\tvar search_desc\t\t\t= \"\";\n\t\t\t\tvar title\t\t\t= encodeURIComponent(getLabel(\"Common.Payer.label\",\"common\"));\n\t\t\t\tvar locale  = document.forms[0].locale.value;\n\t\t\t\tvar payable_type=document.forms[0].payer_type.value;\n\n\t\t\t\t//if(payable_type==\"I\")\n\t\t\t\t//{\n\t\t\t\t\tvar sql1=\"select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = \'\"+locale+\"\'  and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1\"; \n\n\t\t\t\t\tvar argArray = new Array();\n\t\t\t\t\tvar namesArray = new Array();\n\t\t\t\t\tvar valuesArray = new Array();\n\t\t\t\t\tvar datatypesArray = new Array();\n\t\t\t\t\targArray[0] = sql1;\n\t\t\t\t\targArray[1] = namesArray;\n\t\t\t\t\targArray[2] = valuesArray;\n\t\t\t\t\targArray[3] = datatypesArray;\n\t\t\t\t\targArray[4] = \"1,2\";\n\t\t\t\t\targArray[5] = target.value;\n\t\t\t\t\targArray[6] = DESC_LINK;\n\t\t\t\t\targArray[7] = DESC_CODE;\t\t\n\t\t\t\t\tretArray = await CommonLookup( title, argArray );\t\n                     var ret1=unescape(retArray);\n\t\t\t\t\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t\t}\t\t\n\t\t\t\t\tif(retArray != null && retArray !=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].payer_code.value = arr[0];\n                        document.forms[0].payer.value = arr[1];\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n                          document.forms[0].payer_code.value = arr[0];\n                          document.forms[0].payer.value = arr[1];\n\t\t\t\t\t\t//document.forms[0].payer.value=\"\";\n\t\t\t\t\t\t//document.forms[0].payer_code.value=\"\";\n\t\t\t\t\t\t//document.forms[0].payer_type.value=\"\";\n\t\t\t\t\t\t//document.forms[0].payer_type.selectedIndex=2;\n\t\t\t\t\t}\n\t\t\t\t//}\n\t\t\t}\n\n\t\t\tfunction payerDisabled()\n\t\t\t{\n\t\t\t\tvar pay_type=document.forms[0].payer_type.value;\t\t\t\n\t\t\t\tif(pay_type==\'P\' || pay_type==\'B\' || pay_type==\"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].payer.value=\"\";\n\t\t\t\t\tdocument.forms[0].payer.disabled=true;\n\t\t\t\t\tdocument.forms[0].payerdbut.disabled=true;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tdocument.forms[0].payer.disabled=false;\n\t\t\t\t\tdocument.forms[0].payerdbut.disabled=false;\n//\t\t\t\t\tdocument.forms[0].payer.focus();\n\t\t\t\t\t}\n\n\t\t\t}\n\n\t\t\t\tfunction funRefresh()\n\t\t\t\t{\t\n\t\t\t\t\t//alert(\"246 BLBillInterimReportHdr.jsp\");//lakshmi\n\t\t\t\t\tparent.frames[1].document.forms[0].submit_but.disabled=false;\t\t\t\t\t\n\t\t\t\t\tparent.frames[1].document.forms[0].compute_bed_charge_flag.value=\'Y\';\n\t\t\t\t\tvar err=\"\";\n\t\t\t\t\tparent.parent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+err ;\n\t\t\t\t\tvar from_nursing_unit_code=document.forms[0].from_nursing_unit_code.value;\t\t\n\t\t\t\t\tvar to_nursing_unit_code=document.forms[0].to_nursing_unit_code.value;\t\n\n\t\t\t\t\tvar nursing_from_lbl=getLabel(\"Common.FromNursingUnit.label\",\"BL\");\n\t\t\t\t\tvar nursing_to_lbl=getLabel(\"Common.ToNursingUnit.label\",\"common\");\n\n\n\n\t\t\t\t\tif(from_nursing_unit_code!=\"\" && to_nursing_unit_code==\"\") \n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\t\t\t\t\t\t\n\t\t\t\t\t\tmsg = msg.replace(\"$\", nursing_to_lbl);\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tdocument.forms[0].to_nursing_unit_code.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].from_nursing_unit_code.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].to_nursing_unit.focus();\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t\telse if(from_nursing_unit_code==\"\" && to_nursing_unit_code!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\t\t\t\t\t\t\n\t\t\t\t\t\tmsg = msg.replace(\"$\", nursing_from_lbl);\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tdocument.forms[0].from_nursing_unit_code.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].to_nursing_unit_code.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].from_nursing_unit.focus();\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\n\t\t\t\t\tif(from_nursing_unit_code > to_nursing_unit_code)\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9927\",\"BL\"))\t\t\t\t\t\t\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tvar from_adm_no=document.forms[0].from_adm_no.value;\t\t\n\t\t\t\t\tvar to_adm_no=document.forms[0].to_adm_no.value;\n\t\t\t\t\tvar adm_from_lbl=getLabel(\"eBL.FROM_ADM_NO.label\",\"BL\");\n\t\t\t\t\tvar adm_to_lbl=getLabel(\"eBL.TO_ADM_NO.label\",\"BL\");\n\t\t\t\t\t\n\t\t\t\t\tif(from_adm_no!=\"\" && to_adm_no==\"\")\n\t\t\t\t\t\t\n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\t\t\t\t\t\t\n\t\t\t\t\t\tmsg = msg.replace(\"$\", adm_to_lbl);\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tdocument.forms[0].to_adm_no.focus();\n\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t\telse if (from_adm_no==\"\" && to_adm_no!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\t\t\t\t\t\t\n\t\t\t\t\t\tmsg = msg.replace(\"$\", adm_from_lbl);\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tdocument.forms[0].from_adm_no.focus();\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t\tif(from_adm_no > to_adm_no)\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"BL9926\",\"BL\"))\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tvar payer_code=document.forms[0].payer_code.value;\t\t\t\t\t\n\t\t\t\t\tvar patient_id=\"\"; //document.forms[0].patient_id.value;\n\t\t\t\t\tvar payer_type=document.forms[0].payer_type.value;\t\t\t\t\t\n\t\t\t\t\tvar pay_amt_exce=document.forms[0].pay_amt_exce.value;\t\t\n\t\t\t\t\tvar no_of_deci=document.forms[0].noofdecimal.value;\n\t\t\t\t\tvar int_bill_gen_freq=\'\';//document.forms[0].int_bill_gen_freq.value;\n\t\t\t\t\tparent.frames[3].location.href=\'../../eCommon/jsp/process.jsp\';\tparent.frames[2].location.href=\'../../eBL/jsp/BLBillInterimReportCurrInPat.jsp?from_nursing_unit_code=\'+from_nursing_unit_code+\"&to_nursing_unit_code=\"+to_nursing_unit_code+\"&from_adm_no=\"+from_adm_no+\"&to_adm_no=\"+to_adm_no+\"&payer_code=\"+payer_code+\"&patient_id=\"+patient_id+\"&payer_type=\"+payer_type+\"&pay_amt_exce=\"+pay_amt_exce+\"&no_of_deci=\"+no_of_deci+\"&int_bill_gen_freq=\"+int_bill_gen_freq;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tfunction AmtEcceed()\n\t\t\t\t{\t  \n\t\t\t\t\tvar v_amt=document.forms[0].pay_amt_exce.value;\n\t\t\t\t\tif(v_amt==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].pay_amt_exce.value=0;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tfunction trunc_deci()\n\t\t\t\t{\n\t\t\t\t\t var int_bill_gen_freq=document.forms[0].int_bill_gen_freq.value;\n\t\t\t\t\t var index=int_bill_gen_freq.indexOf(\".\");\n\t\t\t\t\t if(index>0)\n\t\t\t\t\t{\t\t\n\t\t\t\t\t\tint_bill_gen_freq=int_bill_gen_freq.substring(0,index);\n\t\t\t\t\t}\n\t\t\t\t\telse if(index==0)\n\t\t\t\t\t{\n\t\t\t\t\t\tint_bill_gen_freq=0;\n\t\t\t\t\t}\t\t\n\t\t\t\t\tdocument.forms[0].int_bill_gen_freq.value=int_bill_gen_freq;\n\t\t\t\t}\n\t\t\tasync function admnolkp(admissionno,clng_evnt)\n\t\t\t\t{\n\t\t\t\t\tif(clng_evnt == \'B\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif( admissionno.value == \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tvar from_nursing_unit=document.forms[0].from_nursing_unit_code.value;\n\t\t\t\t\tvar to_nursing_unit=document.forms[0].to_nursing_unit_code.value;\n\t\t\t\t\tvar locale=document.forms[0].locale.value;\n\t\t\t\t\tvar facility_id=document.forms[0].facility_id.value;\n\t\t\t\t\t/*var dialogTop\t\t\t= \"40\";\n\t\t\t\t\tvar dialogHeight\t\t= \"10\" ;\n\t\t\t\t\tvar dialogWidth\t\t\t= \"40\" ;*/\n                     \n                    var dialogTop\t\t\t= \"40px\"\n                    var dialogHeight = \"400px\" ;\n\t                var dialogWidth\t= \"900px\" ;\n\t\t\t\t\tvar features\t\t\t=\"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\t\tvar arguments\t\t\t= \"\" ;\t\t\t\t\t\n\t\t\t\t\tvar title = encodeURIComponent(getLabel(\"Common.AdmissionNo.label\",\"common\"));\n\t\t\t\t\tvar column_sizes = escape(\"35%,35%,30%\");               \t\t\t\n\t\t\t\t\tvar admno = encodeURIComponent(getLabel(\"Common.AdmissionNo.label\",\"common\"));\n\t\t\t\t\tvar pat_id = encodeURIComponent(getLabel(\"Common.patientId.label\",\"common\"));\n\t\t\t\t\tvar pat_name= encodeURIComponent(getLabel(\"Common.PatientName.label\",\"common\"));\n\t\t\t\t\tvar column_descriptions =admno+\",\"+pat_id+\",\"+pat_name;\n\t\t\t\t\t//var sql=\"SELECT episode_id, patient_id, short_name  FROM lov_view WHERE facility_id =\'\"+facility_id+\"\'   AND (episode_type = \'I\' OR episode_type = \'D\')  AND cur_ward_code BETWEEN NVL (\'\"+from_nursing_unit+\"\' , \'!!\') AND NVL (\'\"+to_nursing_unit+\"\', \'~~\') \"; \t\t\n//\t\t\t\t\tvar sql=\"SELECT to_char(B.EPISODE_ID) EPISODE_ID,B.PATIENT_ID PATIENT_ID, decode(UPPER(\'\"+lo";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="cale+\"\'),\'EN\', D.short_name, D.short_name_loc_lang) SHORT_NAME FROM IP_OPEN_EPISODE A,  BL_EPISODE_FIN_DTLS B,  IP_EPISODE C,  MP_PATIENT_MAST D WHERE A.PATIENT_ID = B.PATIENT_ID   AND A.PATIENT_ID = C.PATIENT_ID  AND A.PATIENT_ID = D.PATIENT_ID   AND A.OPEN_EPISODE_ID = B.EPISODE_ID    AND A.OPEN_EPISODE_ID = C.EPISODE_ID     AND A.FACILITY_ID = \'\"+facility_id+\"\' AND B.OPERATING_FACILITY_ID = A.FACILITY_ID  AND C.FACILITY_ID = A.FACILITY_ID    AND (B.EPISODE_TYPE = \'I\' or B.EPISODE_TYPE = \'D\')    AND C.CUR_WARD_CODE BETWEEN NVL(\'\"+from_nursing_unit+\"\',\'!!!!\') AND NVL(\'\"+to_nursing_unit+\"\',\'~~~~\')     AND NVL(B.DISCHARGE_BILL_GEN_IND,\'N\') = \'N\'\";\n// Corrected for PE Changes\n\t\t\t\t\tvar sql=\"SELECT to_char(B.EPISODE_ID) EPISODE_ID,B.PATIENT_ID PATIENT_ID, decode(UPPER(\'\"+locale+\"\'),\'EN\', D.patient_name, D.patient_name_loc_lang) SHORT_NAME FROM IP_OPEN_EPISODE A,  BL_EPISODE_FIN_DTLS B,  MP_PATIENT D WHERE A.PATIENT_ID = B.PATIENT_ID   AND A.PATIENT_ID = D.PATIENT_ID   AND A.OPEN_EPISODE_ID = B.EPISODE_ID   AND A.FACILITY_ID = \'\"+facility_id+\"\' AND B.OPERATING_FACILITY_ID = A.FACILITY_ID  AND (B.EPISODE_TYPE = \'I\' or B.EPISODE_TYPE = \'D\')    AND a.CUR_WARD_CODE BETWEEN NVL(\'\"+from_nursing_unit+\"\',\'!!!!\') AND NVL(\'\"+to_nursing_unit+\"\',\'~~~~\')     AND NVL(B.DISCHARGE_BILL_GEN_IND,\'N\') = \'N\'\";\n\n\t\t\t\t\tsql=escape(sql);\t\t\t\t\t\t\t\n\t\t\t\t\tvar message=\'\';\n\t\t\t\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(admissionno.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYY\";\n\t\t\t\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\t\t\t\t\tvar arr=new Array();\t\t\t\t\t\n\t\t\t\t\tif (retVal != null || retVal!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(retVal!=\'undefined\' && retVal!=undefined)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tretVal=unescape(retVal);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t//arr=retVal.split(\"::\");\n\t\t\t\t\t\t\t\tarr=retVal.split(\"^~^\");\n\t\t\t\t\t\t\t\tadmissionno.value=arr[0];\t\t\t\t\t\t\n  \t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\telse{\n\t\t\t\t\t\tadmissionno.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tadmissionno.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t/*\tfunction funComputeBedCharges()\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\talert(\"Job Submitted For Bed Charge Process\");\n\t\t\t\t\tparent.frames[2].document.forms[0].submit();\t\n\t\t\t\t\n\t\t\t\t}*/\n\n\t</script>\n\t</HEAD> \n\t\t\t<BODY onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n\t\t\t<FORM name=\'BillSlmtInterimReport\' id=\'BillSlmtInterimReport\' method=\'\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\t\t\t<TABLE border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t\t\t <TR>\n\t\t\t    <td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"from_nursing_unit\" id=\"from_nursing_unit\" SIZE=\"30\"  MAXLENGTH=\'30\' VALUE=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onBlur=\"nursinglkup(this,document.forms[0].from_nursing_unit_code,\'Y\')\"><input type=\'button\' class=\'button\' name=\"nursingbut\" id=\"nursingbut\" value=\'?\' onClick=\'nursinglkup(document.forms[0].from_nursing_unit,document.forms[0].from_nursing_unit_code)\' >\n\t\t\t\t<input type= \'hidden\' name=\"from_nursing_unit_code\" id=\"from_nursing_unit_code\"  value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></td>\t\t\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"to_nursing_unit\" id=\"to_nursing_unit\" SIZE=\"30\"  MAXLENGTH=\'30\'\tVALUE=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onBlur=\"nursinglkup(this,document.forms[0].to_nursing_unit_code,\'Y\')\"><input type=\'button\' class=\'button\' name=\"nursingbut\" id=\"nursingbut\" value=\'?\' onClick=\'nursinglkup(document.forms[0].to_nursing_unit,document.forms[0].to_nursing_unit_code)\' >\n\t\t\t\t<input type= \'hidden\' name=\"to_nursing_unit_code\" id=\"to_nursing_unit_code\"  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\t\t</td>\t\t\n\t\t\t</tr>\n\t\t\t<tr>\t\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"from_adm_no\" id=\"from_adm_no\" SIZE=\"8\" maxlength=\'8\' VALUE=\'\' onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\' onBlur=\"admnolkp(document.forms[0].from_adm_no,\'B\')\" ><input type=\'button\' class=\'button\' name=\"admbut\" id=\"admbut\" value=\'?\' onClick=\"admnolkp(document.forms[0].from_adm_no,\'C\')\" >\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"to_adm_no\" id=\"to_adm_no\" SIZE=\"8\" maxlength=\'8\' VALUE=\'\' onBlur=\"admnolkp(document.forms[0].to_adm_no,\'B\')\" onKeyPress=\'return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))\'><input type=\'button\' class=\'button\' name=\"admbut\" id=\"admbut\" value=\'?\' onClick=\"admnolkp(document.forms[0].to_adm_no,\'C\')\">\n\t\t\t\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\n\t\t\t\t<td  width=\'25%\' class=\'fields\'>\n\t\t\t\t<select name=\'payer_type\' id=\'payer_type\' onchange=\'payerDisabled()\'>\n\t\t\t\t<option value=\'B\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\t\t\n\t\t\t\t<option value=\'P\'  >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t<option value=\'I\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\t\t\t\t\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\n\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"payer\" id=\"payer\" SIZE=\"30\"  MAXLENGTH=\'40\'\t VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onBlur=\"payerlkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"payerdbut\" id=\"payerdbut\" value=\'?\' onClick=\"payerlkup(\'C\')\" tabindex=\'\' ><input type= \'hidden\' name=\"payer_code\" id=\"payer_code\"  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></td>\t\n\t\t\t<td class=\"fields\" width=\"25%\"></td>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\t\n\t\t\t<td class=\"fields\" width=\"25%\"><INPUT TYPE=\"TEXT\"  name=\"pay_amt_exce\" id=\"pay_amt_exce\" SIZE=\"15\" MAXLENGTH=\'10\' VALUE=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" style=\'text-align:right\' onKeyPress =\'return(ChkNumberInput(this,event,2))\' onBlur=\'AmtEcceed(this);put_decimal(this,document.forms[0].noofdecimal.value)\'></td>\t\t\n\t\t\t<!-- Modified By Rajesh V -->\n\t\t\t<td class=\"fields\" width=\"25%\"><input type=\'checkbox\' name=\'dischargeYN\' id=\'dischargeYN\' id=\'dischargeYN\' checked>\n\t\t\t&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t<!-- Modified By Rajesh V -->\n\t\t\t<td width=\"25%\"  class=\"label\" ><input type=\'button\' class=\'button\' onclick=\'funRefresh()\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  name=\'search_but\' ></td>\n\t\t\t<!--<td width=\"25%\"  class=\"label\" ><input type=\'button\' class=\'button\' onclick=\'funComputeBedCharges()\' value=\"Submit Bed Charge Process\" ></td>\t\t\t-->\n\n\t\t\t</TR>\n\t\t\n\t\t</TABLE>\n\t\t<input type= hidden name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type= hidden name=\"facility_id\" id=\"facility_id\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\t\t\n\t\t<input type= hidden name=\"patient_id1\" id=\"patient_id1\"  value=\'\'>\t\t\n\t\t<input type= hidden name=\"pat_check_flag\" id=\"pat_check_flag\"  value=\'\'>\t\n\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t<input type=\'hidden\' name=\'group_by\' id=\'group_by\' value=\"\" >\n\t<!--\t<input type= hidden name=\"payer_type_flag\" id=\"payer_type_flag\"  value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\t-->\n\t\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\"\">\n\t\t<input type=\'hidden\' name=\'log_rep_success_mes\' id=\'log_rep_success_mes\' value=\'\'>\n\t\t\n\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"    value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"    value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t   value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\"hidden\" name=\"L_AMOUNT\" id=\"L_AMOUNT\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_FR_EPISODE_ID\" id=\"L_FR_EPISODE_ID\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_FR_WARD_CODE\" id=\"L_FR_WARD_CODE\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_TO_EPISODE_ID\" id=\"L_TO_EPISODE_ID\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_TO_WARD_CODE\" id=\"L_TO_WARD_CODE\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_PAYER\" id=\"L_PAYER\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"L_PAY_TYPE\" id=\"L_PAY_TYPE\"\t   value=\"\">\t\t\n\t\t<input type=\"hidden\" name=\"P_FACILITY_ID\" id=\"P_FACILITY_ID\"\t   value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" name=\"L_SERV_CLASS_YN\" id=\"L_SERV_CLASS_YN\"\t   value=\"\">\n\t\t<!-- Hidden Fields Added by Rajesh V -->\n\t\t<input type=\"hidden\" name=\"p_session_id\" id=\"p_session_id\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"p_pgm_date\" id=\"p_pgm_date\"\t   value=\"\">\n\t\t<input type=\"hidden\" name=\"p_pgm_id\" id=\"p_pgm_id\"\t   value=\"\">\n\t\t<!-- Hidden Fields Added by Rajesh V -->\n\t\t<!--<input type=\"hidden\" name=\"P_LANG_ID_LOC\" id=\"P_LANG_ID_LOC\"\t   value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>-->\n\t\t\n\t\t\n\n\t\t\n\t\t\n\t\t\t\n\t</FORM>\n\t\t\n\t</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	ResultSet rs1=null; ResultSet rscurr=null;
	PreparedStatement pstmt = null ;
	String locale="";String p_facility_id=""; String pat_check_flag="";
	String nursing_unit="";String payer_type=""; String patient_id1="";
	String payer=""; String pay_amt_exce="0.00"; String  int_bill_gen_freq="";
	int noofdecimal=2; String strPatientId="";//String selected_P="",selected_I="",selected_B="",selected="";
	String nursing_unit_code=""; String payer_code="";
	String p_module_id		= "BL" ;
	String p_report_id		= "BLR00001" ;
	String p_user_name		= (String) session.getValue( "login_user" );
	try{	
		HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		con	=	ConnectionManager.getConnection(request);
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		pat_check_flag=request.getParameter("pat_check_flag");
		if(pat_check_flag==null || pat_check_flag.equals("")) pat_check_flag="";
//		System.out.println("pat_check_flag :"+pat_check_flag);
		if(pat_check_flag.equals("Y"))
		{
			nursing_unit=request.getParameter("nursing_unit");
			if(nursing_unit==null || nursing_unit.equals("")) nursing_unit="";
				nursing_unit_code=request.getParameter("nursing_unit_code");
			if(nursing_unit_code==null || nursing_unit_code.equals("")) nursing_unit_code="";
				payer_type=request.getParameter("payer_type");
			if(payer_type==null || payer_type.equals("")) payer_type="";
				payer=request.getParameter("payer");
			if(payer==null || payer.equals("")) payer="";
				payer_code=request.getParameter("payer_code");
			if(payer_code==null || payer_code.equals("")) payer_code="";
				pay_amt_exce=request.getParameter("pay_amt_exce");
			if(pay_amt_exce==null || pay_amt_exce.equals("")) pay_amt_exce="";
				int_bill_gen_freq=request.getParameter("int_bill_gen_freq");
			if(int_bill_gen_freq==null || int_bill_gen_freq.equals("")) int_bill_gen_freq="";
				patient_id1=request.getParameter("patient_id1");
			if(patient_id1==null || patient_id1.equals("")) patient_id1="";
//			System.out.println("patient_id1 :"+patient_id1);
//			System.out.println("nursing_unit :"+nursing_unit);
			/*if(payer_type.equals("P"))
				{selected_P="SELECTED";	}
				else if(payer_type.equals("I"))
				{selected_I="SELECTED";
				}
				else if(payer_type.equals("B"))
				{	selected_B="SELECTED";	}
		     else
			{selected="";}*/
		}
	  }catch(Exception eX){	
		out.println("Error= "+eX);}

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
		try{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
			pstmt.close();
			}catch(Exception e) {System.out.println("currency="+e.toString());}
			try{
				pstmt = con.prepareStatement( "SELECT PATIENT_ID FROM IP_OPEN_EPISODE WHERE FACILITY_ID = '"+p_facility_id+"' AND PATIENT_ID='"+patient_id1+"'");
				rs1 = pstmt.executeQuery();	
				while(rs1.next())
				{
					strPatientId  =  rs1.getString(1);		
				}
//				System.out.println("strPatientId :" +strPatientId);
				rs1.close();
				pstmt.close();
				if(!strPatientId.equals(patient_id1))
				  {
//					System.out.println("inside patient check");

            _bw.write(_wl_block8Bytes, _wl_block8);

				  }
				}catch(Exception e) {System.out.println("patid="+e.toString());}

			
				finally{				
					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
					}


            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(payer_code));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pay_amt_exce));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(payer_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block37Bytes, _wl_block37);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FromNursingUnit.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ToNursingUnit.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FROM_ADM_NO.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TO_ADM_NO.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_TYPE.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ANY.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT_EXCEED.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
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
}
