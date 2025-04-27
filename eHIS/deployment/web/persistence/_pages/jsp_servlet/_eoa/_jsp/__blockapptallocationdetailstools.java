package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __blockapptallocationdetailstools extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BlockApptAllocationDetailsTools.jsp", 1715860736793L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>  \n<head>  \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\'></link>\n\t\t   \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n \n\t<script language=\"JavaScript\">\n\t\t\t/*function returnSlotValues(from)\n\t\t\t{ \n\t\t\t\tvar ret = \'\';\n\t\t\t\tif(from == \'O\')\n\t\t\t\t{\n\t\t\t\t\tvar n = parent.BlockApptAllocationDetailsFrame.document.forms[0].total_count.value;\n\t\t\t\t\tvar slot_appt_ctrl = parent.BlockApptAllocationDetailsFrame.document.forms[0].slot_appt_ctrl.value;\n\t\t\t\t\tvar sumtext = 0;\n\t\t\t\t\tvar finalvals = \'\';\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar a = eval(\"parent.BlockApptAllocationDetailsFrame.document.getElementById(\'block_slot_text\')\"+i+\".value\");\n\t\t\t\t\t\tsumtext+=eval(a);\n\t\t\t\t\t\tif( eval(a) != 0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar b = eval(\"parent.BlockApptAllocationDetailsFrame.document.getElementById(\'block_slot\')\"+i+\".value\");\n\t\t\t\t\t\t\tb = b.replace(\'$\',a);\n\t\t\t\t\t\t\tfinalvals+=b+\"#\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\tvar totalslots = parent.BlockApptAllocationDetailsFrame.document.forms[0].slots_blocked.value;\n\t\t\t\t\t\n\t\t\t\t\tif (!(parent.BlockApptAllocationDetailsFrame.document.getElementById(\"block_slot_text1\")))\n\t\t\t\t\t\tsumtext = totalslots;\n\t\t\t\t\tif(totalslots != sumtext){\n\t\t\t\t\t\tif (slot_appt_ctrl==\"S\"){\n\t\t\t\t\t\t\tvar error = getOMessage(\'TOTAL_BLOCK_SLOTS_MISMATCH\',\'OA\');\n\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif (ret != \'F\' && totalslots < sumtext){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar error = getMessage(\'BLOCK_SLOTS_GR_TOTAL_SLOTS\',\'OA\');\n\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (ret != \'F\' && sumtext==0){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar error = getMessage(\'TOTAL_BLOCK_GREAT_ZERO\',\'OA\');\n\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\t\t\t\t\tif (ret != \'F\')\n\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tif (parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text||parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t   var first_visit_value = \"0\";\n\t\t\t\t\t\t   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text)\n\t\t\t\t\t\t   first_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text.value;\n                           var other_visit_value =\"0\"; \n\t\t\t\t\t\t   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)\n\t\t\t\t\t\t\t\tother_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text.value;\n\t\t\t\t\t\t   var criteria_flag = \"Y\";\n\t\t\t\t\t\t   if (finalvals==\"\")\n\t\t\t\t\t\t\t   criteria_flag=\"N\"\n\t\t\t\t\t\t   if (first_visit_value==\"\") first_visit_value=\"0\";\n\t\t\t\t\t\t   if (other_visit_value==\"\") other_visit_value=\"0\";\n\t\t\t\t\t\t   finalvals = finalvals +\"$\"+first_visit_value+\"#\"+other_visit_value;\n\t\t\t\t\t\t   var sumvalue = parseInt(first_visit_value)+parseInt(other_visit_value);\n\n\t\t\t\t\t\t   if(totalslots != sumvalue){\n\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"S\"){\n\t\t\t\t\t\t\t\t\t\tvar error = getMessage(\'TOTAL_BLOCK_SLOTS_MISMATCH\',\'OA\');\n\t\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif (parseInt(totalslots) < parseInt(sumvalue)){\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"P\"){\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tvar error = getMessage(\'BLOCK_SLOTS_GR_TOTAL_SLOTS\',\'OA\');\n\t\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif (parseInt(sumvalue) < parseInt(totalslots)){\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"P\"){\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tvar error = getMessage(\'BLOCK_SLOTS_LS_TOTAL_SLOTS\',\'OA\');\t\t\t\n\t\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\n\n\t\t\t\t\t\t\tif (ret != \'F\' && sumvalue==0){\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar error = getMessage(\'TOTAL_BLOCK_GREAT_ZERO\',\'OA\');\n\t\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif ( ret != \'F\' && criteria_flag==\"Y\" && sumtext != sumvalue){\n\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"P\"){\n\t\t\t\t\t\t\t\t\t\tvar error = getMessage(\'ALLC_NOT_EQUAL_VTYPE\',\'OA\');\n\t\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif (ret != \'F\')\n\t\t\t\t\t\t\tret = finalvals;\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\tret = \'\';\t\t\t\t\n\t\t\t\tparent.window.returnValue = ret ;\n\t\t\t\tif(ret != \'F\')\n\t\t\t\t\tparent.window.close();\n\t\t\t}*/\n\t\t\tfunction returnSlotValues(from){\t\t\t\t\n\t\t\t\tvar ret = \'\';\n\t\t\t\tif(from == \'O\'){\n\t\t\t\t\t\tvar n = parent.BlockApptAllocationDetailsFrame.document.forms[0].total_count.value;\n\t\t\t\t\t\t//alert(\"n\"+n);\n\t\t\t\t\t\tvar slot_appt_ctrl = parent.BlockApptAllocationDetailsFrame.document.forms[0].slot_appt_ctrl.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"slot_appt_ctrl\"+slot_appt_ctrl);\n\n\t\t\t\t\t\tvar sumtext = 0;\n\t\t\t\t\t\tvar finalvals = \'\';\n\t\t\t\t\t\tvar firstval=parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"firstval\"+firstval);\n\n\t\t\t\t\t\tvar otherval=parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"otherval\"+otherval);\n\n\t\t\t\t\t\tvar total_slots_booked= parent.BlockApptAllocationDetailsFrame.document.forms[0].total_slots_booked.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"total_slots_booked\"+total_slots_booked);\n\n\t\t\t\t\t\tvar sum = parseInt(firstval)+parseInt(otherval)+parseInt(total_slots_booked) ;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"sum\"+sum);\n\n\t\t\t\t\t\tvar max_patients_per_day= parent.BlockApptAllocationDetailsFrame.document.forms[0].max_patients_per_day.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"max_patients_per_day\"+max_patients_per_day);\n\n\t\t\t\t\t\tvar max_first_visits_all= parent.BlockApptAllocationDetailsFrame.document.forms[0].max_first_visits.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"max_first_visits_all\"+max_first_visits_all);\n\n\t\t\t\t\t\t\tvar max_oth_visits_all = parent.BlockApptAllocationDetailsFrame.document.forms[0].max_other_visits.value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"max_oth_visits_all\"+max_oth_visits_all);\n\n\t\t\t\t\t\tvar max_first_visits_blocked =parent.BlockApptAllocationDetailsFrame.document.forms[0].total_first_visits_blocked.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"max_first_visits_blocked\"+max_first_visits_blocked);\n\n\t\t\t\t\t\tvar max_other_visits_blocked =parent.BlockApptAllocationDetailsFrame.document.forms[0].total_other_visits_blocked.value;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"max_other_visits_blocked\"+max_other_visits_blocked);\n\n\t\t\t\t\t\tvar allow_first = max_first_visits_all-max_first_visits_blocked;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"allow_first\"+allow_first);\n\n\t\t\t\t\t\tvar allow_other = max_oth_visits_all-max_other_visits_blocked;\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"allow_other\"+allow_other);\n\n\n\t\t\t\t\t\t\t\tif(firstval>allow_first)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t//alert(\"@180\");\n\t\t\t\t\t\t\t\t\t//var error = getMessage(\'BLOCK_LESS_FIRST_BOOKED\');\n\t\t\t\t\t\t\t\t\t\tvar error = \"APP-OA01860 First visit block slots cannot be greater than the difference between  maximum first visit and booked first visits\";\n\n\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"@186\");\n\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tif(otherval>allow_other)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"@191\");\n\n\t\t\t\t\t\t\t\t\t//var error = getMessage(\'BLOCK_LESS_OTHER_BOOKED\');\n\t\t\t\t\t\t\t\t\tvar error = \"APP-OA01861 Other visit block slots cannot be greater than the difference between  maximum other visit and booked other visits\";\n\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"@192\");\n\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tif(sum>max_patients_per_day)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"@203\");\n\n\t\t\t\t\t\t\t\t\t//var error = getMessage(\'SUM_OTHER_FIRST_BLOCKED_ZERO\');\n\t\t\t\t\t\t\t\t\tvar error = \"APP-OA01859 Sum of  first visit , other visit and total slots blocked should not be greater than maximum patients per day\";\n\n\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"@204\");\n}\n\t\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar a = eval(\"parent.BlockApptAllocationDetailsFrame.document.getElementById(\'block_slot_text\')\"+i+\".value\");\n\t\t\t\t\t\t\t\t\tsumtext+=eval(a);\n\t\t\t\t\t\t\t\t\tif( eval(a) != 0)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar b = eval(\"parent.BlockApptAllocationDetailsFrame.document.getElementById(\'block_slot\')\"+i+\".value\");\n\t\t\t\t\t\t\t\t\t\tb = b.replace(\'$\',a);\n\t\t\t\t\t\t\t\t\t\tfinalvals+=b+\"#\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar totalslots = parent.BlockApptAllocationDetailsFrame.document.forms[0].slots_blocked.value;\n\t\t\t\t\t\t\t\tif (!(parent.BlockApptAllocationDetailsFrame.document.getElementById(\"block_slot_text1\")))\n\t\t\t\t\t\t\t\t\tsumtext = totalslots;\n\t\t\t\t\t\t\t\tif(totalslots != sumtext){\n\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"S\"){\n\t\t\t\t\t\t\t\t\t\t//var error = getMessage(\'TOTAL_BLOCK_SLOTS_MISMATCH\');\n\t\t\t\t\t\t\t\t\t\tvar error = \"APP-OA0093 Total number of Block Slots must match Slots to be Blocked\";\n\n\t\t\t\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif (ret != \'F\' && totalslots < sumtext){\n\t\t\t\t\t\t\t\t\t\t//var error = getMessage(\'BLOCK_SLOTS_GR_TOTAL_SLOTS\');\n\t\t\t\t\t\t\t\t\t\tvar error =  \"APP-OA0159 Sum of Block Slots should not be greater than Selected Blocks\";\n\t\t\t\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif (ret != \'F\' && sumtext==0){\n\t\t\t\t\t\t\t\t\t\t//var error = getMessage(\'TOTAL_BLOCK_GREAT_ZERO\');\n\t\t\t\t\t\t\t\t\t\tvar error =  \"APP-OA0163 Total number of Block Slots Should be Greater than Zero\";\n\t\t\t\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tif (ret != \'F\')\n\t\t\t\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\t\t\tif (parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text||parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t   var first_visit_value = \"0\";\n\t\t\t\t\t\t\t\t\t   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text)\n\t\t\t\t\t\t\t\t\t   first_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text.value;\n\t\t\t\t\t\t\t\t\t   var other_visit_value =\"0\"; \n\t\t\t\t\t\t\t\t\t   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)\n\t\t\t\t\t\t\t\t\t\t\tother_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text.value;\n\t\t\t\t\t\t\t\t\t   var criteria_flag = \"Y\";\n\t\t\t\t\t\t\t\t\t   if (finalvals==\"\")\n\t\t\t\t\t\t\t\t\t\t   criteria_flag=\"N\"\n\t\t\t\t\t\t\t\t\t   if (first_visit_value==\"\") first_visit_value=\"0\";\n\t\t\t\t\t\t\t\t\t   if (other_visit_value==\"\") other_visit_value=\"0\";\n\t\t\t\t\t\t\t\t\t   finalvals = finalvals +\"$\"+first_visit_value+\"#\"+other_visit_value;\n\t\t\t\t\t\t\t\t\t   var sumvalue = parseInt(first_visit_value)+parseInt(other_visit_value);\n\n\t\t\t\t\t\t\t\t\t   if(totalslots != sumvalue){\n\t\t\t\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"S\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\t//var error = getMessage(\'TOTAL_BLOCK_SLOTS_MISMATCH\');\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar error =  \"APP-OA0093 Total number of Block Slots must match Slots to be Blocked\";\n\t\t\t\t\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tif (parseInt(totalslots) < parseInt(sumvalue)){\n\t\t\t\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"P\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\t//var error = getMessage(\'BLOCK_SLOTS_GR_TOTAL_SLOTS\');\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar error =   \"APP-OA0159 Sum of Block Slots should not be greater than Selected Blocks\";\n\n\t\t\t\t\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tif (ret != \'F\' && sumvalue==0){\n\t\t\t\t\t\t\t\t\t\t\t//var error = getMessage(\'TOTAL_BLOCK_GREAT_ZERO\');\n\t\t\t\t\t\t\t\t\t\t\tvar error";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 =" =   \"APP-OA0163 Total number of Block Slots Should be Greater than Zero\";\n\n\t\t\t\t\t\t\t\t\t\t\talert(error)\n\t\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tif ( ret != \'F\' && criteria_flag==\"Y\" && sumtext != sumvalue){\n\t\t\t\t\t\t\t\t\t\t\t\tif (slot_appt_ctrl==\"P\"){\n\t\t\t\t\t\t\t\t\t\t\t\t\t//var error = getMessage(\'ALLC_NOT_EQUAL_VTYPE\');\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar error =   \"APP-OA0160 Sum of Allocations should be equals to Sum of Visit types\";\n\n\t\t\t\t\t\t\t\t\t\t\t\t\talert(error);\n\t\t\t\t\t\t\t\t\t\t\t\t\tret = \'F\';\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif (ret != \'F\')\n\t\t\t\t\t\t\t\t\t\tret = finalvals;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\tret = \'\';\t\t\n\t\t\t\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\t\t\t\tdialogBody.contentWindow.returnValue = ret;\n\t\t\t\t\t\t\t//parent.window.returnValue = ret ;\n\t\t\t\t\t\t\tif(ret != \'F\') {\n\t\t\t\t\t\t\t\t//parent.window.close();\n\t\t\t\t\t\t\t    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\t\t\t\t\t\tdialogTag.close();  } \n\t\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t<form onload = \'display_warning()\' >\n\t<hr>\n\t<table cellpadding=0 cellspacing=0 width=\"100%\" border=0>\n\t\t<tr>\n\t\t\t<td align=center class=BODYCOLORFILLED id = \'display_warn\'>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<b><font size=2>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=right class=BODYCOLORFILLED>\n\t\t\t\t<input type=\"button\" class=BUTTON value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onClick=\"returnSlotValues(\'O\')\">\n\t\t\t\t<input type=\"button\" class=BUTTON value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onClick=\"returnSlotValues(\'C\')\">\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
request.setCharacterEncoding("UTF-8");	

            _bw.write(_wl_block8Bytes, _wl_block8);

				String slot_appt_ctrl = request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
				if (slot_appt_ctrl.equals("S")){
				
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.blocksums.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
