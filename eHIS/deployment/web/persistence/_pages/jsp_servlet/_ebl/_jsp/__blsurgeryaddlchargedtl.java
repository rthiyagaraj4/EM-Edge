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
import java.io.*;
import webbeans.op.CurrencyFormat;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blsurgeryaddlchargedtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLSurgeryAddlChargeDtl.jsp", 1744006501194L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t</head>\n\n<script>\n\tfunction selected(ord,i)\n\t{\n\t\n\t\tvar v_patient_id = document.forms[0].patient_id.value;\n\t\tvar v_episode_type = document.forms[0].episode_type.value;\n\t\tvar v_episode_id = document.forms[0].episode_id.value;\n\t\tvar v_visit_id = document.forms[0].visit_id.value;\n\t\ti=i;\n\t\tvar sys_message_id=eval(\"document.forms[0].sysmessageid_\"+ord+\"_\"+i);\n\t\tvar error_level=eval(\"document.forms[0].errorlevel_\"+ord+\"_\"+i);\n\t\tvar error_text=eval(\"document.forms[0].errortext_\"+ord+\"_\"+i);\n\t\tvar selected_row=eval(\"document.forms[0].selected_row_\"+ord+\"_\"+i);\n\t\tvar dep_serv_disc =document.getElementById(\"dep_serv_id\"+ord+\"_\"+i);\n\t\n\t\tif(sys_message_id.value!=\"\" || (error_level.value==\"10\" || error_text.value!=\"\"))\n\t\t{\n\t\t\tif(sys_message_id!=\"\")\n\t\t\t{\n\t\t\t\talert(getMessage(sys_message_id.value,\'BL\'));\t\t\t\n\t\t\t\tselected_row.checked=false;\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tif(error_text!=\"\")\n\t\t\t{\n\t\t\t\tdep_serv_disc.innerText = error_text.value;\n\t\t\t\tselected_row.checked=false;\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tselected_row.checked=false;\n\t\t\treturn;\n\t\t}\n\n\t\t\n\t\tif(selected_row.checked==false)\n\t\t{\t\t\t\n\t\t\t/*var pract_name = eval(\"document.forms[0].pract_name_\"+ord+\"_\"+i);\n\t\t\tpract_name.disabled=true;*/\n\t\t\tselected_row.value=\"N\";\n\t\t\t\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t/*var pract_name = eval(\"document.forms[0].pract_name_\"+ord+\"_\"+i);\n\t\t\tpract_name.disabled=false;*/\n\t\t\t\n\t\t\tselected_row.value=\"Y\";\n\t\t}\n\t\t\n\t\tvar a_serv_code = new Array();\n\t\tvar  ord_catlog_count=document.forms[0].ord_tot_rec.value;\n\t\tvar blng_serv_code=eval(\"document.forms[0].blng_serv_code_\"+ord+\"_\"+i);\n\t\tvar order_cat_code=eval(\"document.forms[0].order_cat_code\"+ord+\"_\"+i);\n\t\tp_blng_serv_code = blng_serv_code.value;\n\t\tp_order_cat_code = order_cat_code.value;\n\t\tvar checked_val=selected_row.value;\n\t\tvar v_ord=ord;\n\t\tvar string=\"../../eBL/jsp/BLAddlSurgeryValidation.jsp?blng_serv_code=\"+p_blng_serv_code+\"&order_cat_code=\"+p_order_cat_code+\"&ord_catlog_count=\"+ord_catlog_count+\"&ord_i=\"+ord+\"&checked_val=\"+checked_val+\"&p_patient_id=\"+v_patient_id+\"&episode_type=\"+v_episode_type+\"&episode_id=\"+v_episode_id+\"&visit_id=\"+v_visit_id;\n\t\t\n\t\tparent.frames[3].location.href=string;\n\t}\n\t\n\tfunction phylkp(ord,i,clng_evnt)\n\t{\t\t\n\t\tvar target= eval(\"document.forms[0].pract_name_\"+ord+\"_\"+i);\n\t\tvar pract_id= eval(\"document.forms[0].pract_id_\"+ord+\"_\"+i);\n\t\tvar order_id = eval(\"document.forms[0].order_id_\"+ord+\"_\"+i);\n\t\tvar ass_ot_role_type = eval(\"document.forms[0].ass_ot_role_type_\"+ord+\"_\"+i);\t\t\n\t\tvar v_ass_ot_role_type =ass_ot_role_type.value;\n\t\tif(clng_evnt == \'B\')\n\t\t{\n\t\t\tif( target.value == \"\")\n\t\t\t{\n\t\t\t\ttarget.value = \"\";\n\t\t\t\tpract_id.value = \"\";\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t\t\t\t\n\t\tvar retVal\t\t\t= new String();\t\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql3\t\t\t\t= \"\";\t\t\n\t\tvar locale = document.forms[0].locale.value;\t\t\n\n\t\tvar title=encodeURIComponent(getLabel(\"Common.practitioner.label\",\"common\"));\n\t\tvar column_sizes = escape(\"15%,10%\");\n\t\tvar pract_name=encodeURIComponent(getLabel(\"Common.practitioner.label\",\"common\"));\n\t\tvar pract_id=encodeURIComponent(getLabel(\"Common.practitionerid.label\",\"common\"));\n\t\t\t\t\t\t\t\t\n\t\tvar column_descriptions =pract_name+\",\"+pract_id; \n\t\tvar message = \'\';\n\t\tvar v_order_id=order_id.value;\n\t\n\t\tsql=\"SELECT B.SHORT_NAME pract_name, A.PRACTITIONER_ID pract_id FROM OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B WHERE A.PRACTITIONER_ID = B.PRACTITIONER_ID AND A.ROLE_TYPE = NVL(Decode(\'\"+v_ass_ot_role_type+\"\',\'--\',\'\'),A.ROLE_TYPE) AND A.OPER_NUM IN (SELECT OPER_NUM FROM OT_POST_OPER_HDR \t  WHERE ORDER_ID = \'\"+v_order_id+\"\') AND B.LANGUAGE_ID = \'\"+locale+\"\'\";\n\n\t\tsql = escape(sql);\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\t\t \n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t \n\t\tvar arr=new Array();\n\t\t\n\t\tif(retVal == null || retVal==\'undefined\' || retVal==undefined) retVal=\'\';\n\t\tif (retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\tvar v_pract_id= eval(\"document.forms[0].pract_id_\"+ord+\"_\"+i);\t\t\t\n\t\t\tpract_name=arr[0];\t\t\t\t\n\t\t\tv_pract_id.value=arr[1];\t\t\t  \n\t\t\ttarget.value=pract_name;\t\n\t\t\tpract_id.value=pract_id;\n\t\t}\t\n\t\telse\n\t\t{\n\t\t\tvar v_pract_id= eval(\"document.forms[0].pract_id_\"+ord+\"_\"+i);\n\t\t\tvar v_pract_name= eval(\"document.forms[0].pract_name_\"+ord+\"_\"+i);\n\t\t\tv_pract_id.value=\"\";\n\t\t\tv_pract_name.value=\"\";\n\t\t} \n\t}\n\n\tfunction displayToolTip(ass_ot_role_type_desc)\n\t{\n\t\tdocument.getElementById(\"t\").innerHTML = ass_ot_role_type_desc;\n\t\tresizeWindow();\n\t}\n\t\n\tfunction disableselect()\n\t{\n\t\tvar fun_id=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\t\n\t\tif(fun_id==\"VIEW\")\n\t\t\t{\n\t\t\n\t\t\t\tdocument.getElementById(\"sel\").style.display=\"none\";\n\t\t\t}\n\t\t\telse{\n\t\t\t\tdocument.getElementById(\"sel\").style.display=\"inline\";\n\t\t\t\t}\n\t\t}\n</script>\n\n<body onLoad=\'disableselect()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'edit_enter_main\' id=\'edit_enter_main\' method=\'post\' method=\'post\' target=\'dummy_frame\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\'  width=\'100%\'>\t\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'  ><div id=\"sel\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div></td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'16%\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'  >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" %</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'16%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'14%\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t<!--\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\t\t\n-->\n\t\t<tr id=row";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<!--\t<td class=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" width=\'6%\' ><input type=\"checkbox\" name=\'selected_row_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'selected_row_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' DISABLED style=\'display:none\'></td>-->\n\t\t\t<td class=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" width=\'6%\' ><input type=\"hidden\" name=\'selected_row_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ><input type=\"checkbox\" name=\'selected_row1_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'selected_row1_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onClick=\"selected(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =",";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =")\"  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" DISABLED style=\'display:none\'></td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td class=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" width=\'6%\' ><div id= \'sel1\' style=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="><input type=\"hidden\" name=\'selected_row_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ></div></td>\t \n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" width=\"16%\" >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\t\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<input type=\"hidden\" name=\"blng_serv_code_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"blng_serv_code_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"> \n\t\t\t<input type=\"hidden\" name=\"order_cat_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"order_cat_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> \n\n\t\t\t<td class=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" width=\"8%\" style=\'text-align:right\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t<input type=\"hidden\" name=\"charge_perc";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"charge_perc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"> \t\n\t\t\t\n\t\t\t<td class=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" width=\"16%\" ><div id=\"dep_serv_id";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</div></td>\n\t\t\t<input type=\"hidden\" name=\"dep_blng_serv_code_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"dep_blng_serv_code_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"> \t\t\n\t\t\t\n\t\t\t<td class=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" width=\"8%\" nowrap  style=\'text-align:right\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\n\t\t\t<input type=\"hidden\" name=\"gross_amt_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"gross_amt_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\n\t\t\t<td class=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" width=\"8%\"  nowrap style=\'text-align:right\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t<input type=\"hidden\" name=\"multi_surg_disc_eff_perc_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"multi_surg_disc_eff_perc_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t<input type=\"hidden\" name=\"disc_amt_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"disc_amt_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\n\t\t\t<td class=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t<input type=\"hidden\" name=\"net_amt_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"net_amt_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" width=\"8%\" nowrap style=\'text-align:right\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t<input type=\"hidden\" name=\"pat_pay_amt_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"pat_pay_amt_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" width=\"14%\">\n\t\t\t\t<select name=\'pract_name_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'pract_name_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' onchange=\'\' ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" >\n\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="----</option>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t</select>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" width=\"10%\"><input type=\"text\" name=\"pract_name_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"pract_name_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" size=\"10\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" readonly ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="></td>\n\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t</td>\n\t\t\t<input type=\"hidden\" name=\"order_id_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"order_id_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"> \n\t\t\t<input type=\"hidden\" name=\"sysmessageid_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"sysmessageid_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"> \n\t\t\t<input type=\"hidden\" name=\"errorlevel_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"errorlevel_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"> \n\t\t\t<input type=\"hidden\" name=\"errortext_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"errortext_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"> \n\t\t\t<input type=\"hidden\" name=\"sec_key_module_id_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"sec_key_module_id_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"> \n\t\t\t<input type=\"hidden\" name=\"sec_key_main_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"sec_key_main_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"> \n\t\t\t<input type=\"hidden\" name=\"sec_key_line_no_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"sec_key_line_no_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"> \n\t\t\t<input type=\"hidden\" name=\"disc_seq_num_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"disc_seq_num_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"> \n\t\t\t<input type=\"hidden\" name=\"ass_ot_role_type_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"ass_ot_role_type_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\"hidden\" name=\"ref_module_id_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"ref_module_id_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" value=\"OT\"> \n\t\t\t<input type=\"hidden\" name=\"ref_oper_num_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"ref_oper_num_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"> \n\t\t</tr>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t<input type=\"hidden\" name=\"order_serv_cnt_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"order_serv_cnt_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t<!--input type=\"hidden\" name=\"order_serv_cnt_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"--> \n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t<input type=\"hidden\" name=\'ord_tot_rec\' id=\'ord_tot_rec\' value=";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" >\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"BL9758\",\"BL\"));\n\t\t\t\tparent.window.returnValue=\"success\";\n\t\t\t\tparent.window.close();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t<tr>\n\t\t<!--<table cellpadding=3 cellspacing=0  width=\"100%\">-->\n\t<!--\t<td width=\'6%\'  class=\'label\'>&nbsp;</td>\n\t\t<td width=\'16%\'  class=\'label\'>&nbsp;</td>\n\t\t<td width=\'8%\'  class=\'label\'>&nbsp;</td>-->\n\t\t<td width=\'36%\'  class=\'label\' colspan=\"4\" ><div align=\'right\'><b>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</b></div></td>\n\t\t<td width=\'8%\' class=\'fields\'><input type=\'text\' name=\'gross_amt\' id=\'gross_amt\' size=\'10\' maxlength=\'30\' \n\t\t\tvalue=\'\' readonly style=\'text-align:right\' ></td>\n\t    <td width=\'8%\'  class=\'label\'>&nbsp;</td>\n\t\t<td width=\'8%\' class=\"fields\"><input type=\'text\' name=\'disc_amt\' id=\'disc_amt\' size=\'10\' maxlength=\'30\' \n\t\t\tvalue=\'\' readonly style=\'text-align:right\' ></td>\n\t\t\t\t\n\t\t<td width=\'8%\' class=\"fields\">\t<input type=\'text\' name=\'net_amt\' id=\'net_amt\' size=\'10\'  maxlength=\'30\' value=\'\' readonly \t\t\tstyle=\'text-align:right\'></td>\n\n\t\t<td width=\'8%\' class=\"fields\"><input type=\'text\' name=\'patient_payable\' id=\'patient_payable\' size=\'10\'  maxlength=\'30\' value=\'\' readonly style=\'text-align:right\'></td>\n       <td width=\'14%\'  class=\'label\'>&nbsp;</td>\n\t</tr>\n\t</table>\n\t<input type=\"hidden\" name=\'locale\' id=\'locale\' value=";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" >\n\t<input type=\"hidden\" name=\'totalRecords\' id=\'totalRecords\' value=";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" >\n\t<input type=\"hidden\" name=\'order_catlog_array\' id=\'order_catlog_array\' value=";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" >\n\t<input type=\"hidden\" name=\'episode_type\' id=\'episode_type\' value=";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" >\n\t<input type=\"hidden\" name=\'patient_id\' id=\'patient_id\' value=";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" >\n\t<input type=\"hidden\" name=\'episode_id\' id=\'episode_id\' value=";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" >\t\n\t<input type=\"hidden\" name=\'visit_id\' id=\'visit_id\' value=";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" >\n\t<input type=\"hidden\" name=\'addl_services_yn\' id=\'addl_services_yn\' value=";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" >\n</form>\n</body>\n<script>\n\n\t\t\tparent.frames[2].location.href=\"../../eBL/jsp/BLSurgeryAddlChargeBtn.jsp?";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\";\n</script>\n</html>\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt = null ;
	ResultSet rs=null,rsserv_desc=null,rsrole=null,rs1=null,rs2=null,rscurr=null,rsc=null,rst2=null,rso=null;
	CallableStatement call = null;
	
	String p_facility_id="",p_patient_id="",trx_date_time="",	module_id="",order_item="",serv_panel_ind="",serv_qty="",charge_amt="";
	String service_code="",charge_ind="", charge_perc="",  dep_blng_serv_code="",  gross_amount="",  ass_ot_role_type="",serv_desc="",ass_ot_role_type_desc="",item_desc="",dep_serv_desc="",charge_base_amt="",order_id="",currdate="";
	int noofdecimal = 2;	int i=0;double tot_amt=0;
	String query_string="", function_id="";
	
	String sec_key_module_id="",sec_key_main="",sec_key_line_no="";
	String mult_surg_disc_perc="",disc_amt="",net_amt="",pat_pay_amt="",cat_blng_serv_desc="",checked_val="",mult_surg_disp_disc_perc="";
	//double base_rate=0.00,gross_charge_amt=0.00,net_charge_amt=0.00,get_bill_disc_amt=0.00;
	String sysmessageid="",errortext="",errorlevel="",disc_seq_num="",disabled_view_mode="",pract_id="",pract_short_name="";

	String sec_key="", p_sec_key_main="", override_yn="", acc_seq_no="",str_serv_panel_ind="",str_serv_panel_code="";
	String style_ref="";
	
	try
	{
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");	
		String locale	= (String)session.getAttribute("LOCALE");
		con	=	ConnectionManager.getConnection(request);	
		CurrencyFormat cf = new CurrencyFormat();
		p_facility_id = (String) session.getValue("facility_id");
		if (p_facility_id==null) p_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
		
		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
		query_string=request.getQueryString();
		
		p_patient_id = request.getParameter("patient_id");	
		if(p_patient_id==null) p_patient_id="";	
	
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";	
		
		String p_str_order_catalog_code = request.getParameter("str_order_catalog_code");	
		if(p_str_order_catalog_code==null) p_str_order_catalog_code="";	

		
			

				
		String p_sec_key_main_oper_num = request.getParameter("sec_key_main_oper_num");	
		if(p_sec_key_main_oper_num==null) p_sec_key_main_oper_num="";	

		
		String p_sec_key_main_order_id = request.getParameter("sec_key_main_order_id");	
		if(p_sec_key_main_order_id==null) p_sec_key_main_order_id="";	

				
		String sql="SELECT 'X' FROM BL_PATIENT_CHARGES_INTERFACE WHERE SEC_KEY_MAIN='"+p_sec_key_main_oper_num+"' ";
		
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs.next())
		{
			sec_key=rs.getString(1);
		}
		if(sec_key.equals("X"))
		{
			p_sec_key_main=p_sec_key_main_oper_num;
		}
		else
		{
			p_sec_key_main=p_sec_key_main_order_id;
		}
		if(stmt.equals(null))stmt.close();
		if(rs.equals(null))rs.close();
		
		checked_val="checked";
		String str_disabled="";
		String classval="";
		String chk_box_val="";
		chk_box_val="Y";
		module_id="BL";			
		order_item="";
		serv_panel_ind="S";
		serv_qty="1";
		charge_amt="";
		String addl_services_yn="N";

		HashMap hmServiceString = new HashMap();
		ArrayList order_catalog_array=new ArrayList();
		ArrayList arr_role_type = new ArrayList();
		ArrayList arr_sur_id = new ArrayList();

		String bean_id 		 		= request.getParameter("bean_id");	
		if(bean_id == null) bean_id="";

		String bean_name 			= request.getParameter("bean_name");
		if(bean_name == null) bean_name="";

		BLSurgeryAddlChargeBean bean = (BLSurgeryAddlChargeBean)getBeanObject( bean_id, bean_name, request );		
		bean.clearBean();	
		bean.setPatientId(p_patient_id); // set the Patient Id		
		bean.setVisitId(visit_id); // set the visit_id
		bean.setEpisodeId(episode_id); // set the episode_id 
		bean.setEpisodeType(episode_type); // set the episode_type 
		bean.setEncounterId(encounter_id); // set the encounter_id

		function_id = request.getParameter("function_id");
			if(function_id == null) function_id="EDIT";

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block8Bytes, _wl_block8);

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
			System.out.println("rscurr="+e.toString());
		}

		try
		{		
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			pstmt=con.prepareStatement(query_date);
			rst2 = pstmt.executeQuery();
			if (rst2!=null)
			{
				if (rst2.next())
				{
					currdate = rst2.getString(1);
				}
			}
			if (rst2 != null)   rst2.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("error in date:"+e);
		}
	
		try
		{
			i=0;
			
			//function_id = request.getParameter("function_id");
			//if(function_id == null) function_id="EDIT";

			if(function_id.equals("VIEW"))
			{
				disabled_view_mode="DISABLED";		
				style_ref = "display:none";
			}
			else
			{
				disabled_view_mode="";
				style_ref = "display:inline";
			}

			String str_role_pract_ids = request.getParameter("role_pract_id");
			if(str_role_pract_ids == null) str_role_pract_ids="";

			StringTokenizer st_role_pract_ids = new StringTokenizer(str_role_pract_ids,"@@");

			while(st_role_pract_ids.hasMoreTokens())
			{
				String temp = (String) st_role_pract_ids.nextToken();
				StringTokenizer st_ind_val = new StringTokenizer(temp,"||");
				while(st_ind_val.hasMoreTokens())
				{
					arr_role_type.add(st_ind_val.nextToken());
					arr_sur_id.add(st_ind_val.nextToken());		
				}
			}
			
			try
			{
				StringTokenizer arr_st_ord_cat = new StringTokenizer(p_str_order_catalog_code,"|");			
				while(arr_st_ord_cat.hasMoreTokens())
				{
					order_catalog_array.add(arr_st_ord_cat.nextToken());					
				}
			}
			catch(Exception e)
			{
				System.out.println("order_catalog_array Exception:"+e);
			}

			hmServiceString.clear();			
			
			
			for(i=0;i<order_catalog_array.size();i++)
			{

//				System.out.println("order_catalog_array.get(i) " +order_catalog_array.get(i));
//				System.out.println("p_patient_id " +p_patient_id);
//				System.out.println("p_sec_key_main " +p_sec_key_main);

				pstmt = con.prepareStatement( " SELECT To_Char(CHARGE_DATE_TIME,'dd-mm-yyyy hh24:mi:ss'),PRIMARY_KEY_MAIN,SEC_KEY_MODULE_ID,SEC_KEY_MAIN,SEC_KEY_LINE_NO,SERVICE_PANEL_IND  FROM bl_patient_charges_interface WHERE SERV_ITEM_CODE='"+order_catalog_array.get(i)+"' and patient_id='"+p_patient_id+"'and SEC_KEY_MAIN='"+p_sec_key_main+"'");

				rsc = pstmt.executeQuery();	
				while(rsc.next())
				{
					trx_date_time  =  rsc.getString(1);		
					order_id = rsc.getString(2);		
					sec_key_module_id = rsc.getString(3);		
					sec_key_main = rsc.getString(4);		
					sec_key_line_no = rsc.getString(5);
					serv_panel_ind = rsc.getString(6);
				}
				
				rsc.close();
				pstmt.close();				
//				System.out.println("sec_key_line_no " +sec_key_line_no);
//				System.out.println("serv_panel_ind " +serv_panel_ind);
				String sqlcharge="";
				
				if(function_id.equals("EDIT"))
				{
				sqlcharge="{ call BL_PROC_SUBSERVICES.BL_GET_BILL_SUBSERV_CHARGES('"+p_facility_id+"','"+order_catalog_array.get(i)+"','"+p_patient_id+"','"+episode_type+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+acc_seq_no+"',to_date('"+currdate+"','dd/mm/yyyy HH24:MI:SS'),?,'"+module_id+"','"+order_item+"','"+serv_panel_ind+"','"+serv_qty+"','"+charge_amt+"','"+override_yn+"','"+locale+"','"+sec_key_module_id+"','"+p_sec_key_main+"','"+sec_key_line_no+"')}";
				}
				else if(function_id.equals("VIEW"))
				{
					//sqlcharge="{ call BL_PROC_SUBSERVICES.BL_GET_BILL_SUBSERV_VIEW('"+p_facility_id+"','"+module_id+"',?,'"+sec_key_module_id+"','"+p_sec_key_main+"','"+sec_key_line_no+"')}";
					sqlcharge="{ call BL_PROC_SUBSERVICES.BL_GET_BILL_SUBSERV_VIEW('"+p_facility_id+"','"+module_id+"',?,'"+sec_key_module_id+"','"+p_sec_key_main+"','"+sec_key_line_no+"')}";

				}

				call = con.prepareCall(sqlcharge);
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.execute();
				String service_string=call.getString(1);
				if(addl_services_yn=="N"){
					addl_services_yn=Integer.parseInt(service_string.split("<NR>")[0].split(":")[1])>1?"Y":"N";

					
				}
				hmServiceString.put(order_catalog_array.get(i),service_string);
				bean.setServiceString(hmServiceString); 
				
				call.close();
			}
			/*if(addl_services_yn.equals("N"))
					{
				System.err.println("addl_services_yn inside");				
					out.println("<script>alert(getMessage('BL9758' ,'BL'));parent.window.returnValue=\"NA\";parent.window.close();</script>");
					}*/
		}
		catch(Exception e)
		{
			System.out.println("Exception in for :"+e);
		}
		

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		int ord=0;
		try
		{	
			if(order_catalog_array.size()!=0)
			{
				String disc_rule_line ="",cat_blng_serv_code="";
				ArrayList disc_rule=new ArrayList();
				HashMap hm_StringDtls =(HashMap) bean.getServiceString("service_string"); 
				String serv_str_temp="";
				String ord_key_code = (String)order_catalog_array.get(ord);
				disc_rule=bean.getDiscountLine(ord_key_code);
				i=0;
				
				for(ord=0;ord<order_catalog_array.size();ord++)
				{
					i++;	
					String ord_key =  (String)hm_StringDtls.get(order_catalog_array.get(ord));
					pstmt = con.prepareStatement( " select SERV_ITEM_DESC,CHARGE_BASED_AMT,BLNG_SERV_CODE,SEC_KEY_MODULE_ID,SEC_KEY_MAIN,SEC_KEY_LINE_NO,SERVICE_PANEL_IND,PANEL_CODE  from bl_patient_charges_interface where SERV_ITEM_CODE='"+order_catalog_array.get(ord)+"' and patient_id='"+p_patient_id+"' and SEC_KEY_MAIN='"+p_sec_key_main+"'");
					rs1 = pstmt.executeQuery();	
					//String temp1="select SERV_ITEM_DESC,CHARGE_BASED_AMT,BLNG_SERV_CODE,SEC_KEY_MODULE_ID,SEC_KEY_MAIN,SEC_KEY_LINE_NO  from bl_patient_charges_interface where SERV_ITEM_CODE='"+order_catalog_array.get(ord)+"' and patient_id='"+p_patient_id+"' and SEC_KEY_MAIN='"+p_sec_key_main+"'";
					while(rs1.next())
					{
						item_desc =  rs1.getString(1);							
						charge_base_amt =  rs1.getString(2);			
						charge_base_amt = cf.formatCurrency(charge_base_amt, noofdecimal);
						cat_blng_serv_code = rs1.getString(3);	
						sec_key_module_id = rs1.getString(4);		
						sec_key_main = rs1.getString(5);		
						sec_key_line_no = rs1.getString(6);
						str_serv_panel_ind = rs1.getString(7);
						str_serv_panel_code = rs1.getString(8);
						if(str_serv_panel_code==null) str_serv_panel_code="";
					}
					
					rs1.close();
					pstmt.close();				

					if(str_serv_panel_ind.equals("L") && !str_serv_panel_code.equals(""))
					{
						pstmt = con.prepareStatement( " select SHORT_DESC from BL_PANEL_HDR_LANG_VW where PANEL_CODE='"+str_serv_panel_code +"'and LANGUAGE_ID ='"+locale+"' ");
					}else{					
						pstmt = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+cat_blng_serv_code +"'and LANGUAGE_ID ='"+locale+"' ");
					}					
						rso = pstmt.executeQuery();	
						while(rso.next())
						{
						   cat_blng_serv_desc =  rso.getString(1);
						}					
						rso.close();
						pstmt.close();	
//						System.out.println("****cat_blng_serv_desc:"+cat_blng_serv_desc);

					if(ord!=0)
					{
						disc_rule_line=(String)disc_rule.get(ord-1);
					}
					dep_blng_serv_code="";
					tot_amt=0;
					String delimit="<NR>";	
					String serv_str=ord_key.replaceAll(delimit,"|");
					
					int t=serv_str.indexOf("|");
					//char nr=serv_str.charAt(t-1);		
								

				/*	if(nr == '1')
					{
						out.println("<script>parent.window.returnValue=\"NA\";parent.window.close();</script>");
					}*/

					if(t!=-1)
					{
						serv_str_temp=serv_str.substring(t);
						
					}
					else
					{
						serv_str_temp=serv_str;
					}

					
					
					StringTokenizer st = new StringTokenizer(serv_str_temp,"|");
					int surg_count=0;
					int k=0;
					while(st.hasMoreTokens())
					{
						String string1 = st.nextToken();
						StringTokenizer st1 = new StringTokenizer(string1,"#");			
						
						while(st1.hasMoreTokens())
						{
							i++;
							service_code = st1.nextToken();

							if(service_code.equals(" ")) service_code="";
							try
							{
								pstmt = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+service_code +"'and LANGUAGE_ID ='"+locale+"' ");
							
								rsserv_desc = pstmt.executeQuery();	
					
								while(rsserv_desc.next())
								{
								   serv_desc  =  rsserv_desc.getString(1);
								}	
								rsserv_desc.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							charge_ind = st1.nextToken();
							
							if(charge_ind.equals(" ")) charge_ind="";

							charge_perc = st1.nextToken();
							
							if(charge_perc.equals(" "))
							{
								charge_perc="";							
							}
							else
							{
								charge_perc = cf.formatCurrency(charge_perc, noofdecimal);
							}

							dep_blng_serv_code = st1.nextToken();
							if(dep_blng_serv_code.equals(" ")) dep_blng_serv_code="";
							dep_serv_desc="";

							try
							{
								pstmt = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+dep_blng_serv_code +"'and LANGUAGE_ID ='"+locale+"' ");
							
								rs2 = pstmt.executeQuery();	
					
								while(rs2.next())
								{
								   dep_serv_desc  =  rs2.getString(1);							
								}	
								rs2.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							gross_amount = st1.nextToken();
							if(gross_amount.equals(" ")) gross_amount="";
							gross_amount = cf.formatCurrency(gross_amount, noofdecimal);									

							tot_amt = tot_amt+Double.parseDouble(gross_amount);									

							disc_seq_num = st1.nextToken();
							if(disc_seq_num.equals(" ")) disc_seq_num="";

							mult_surg_disc_perc = st1.nextToken();
							if(mult_surg_disc_perc.equals(" ")) mult_surg_disc_perc="";
							mult_surg_disc_perc = cf.formatCurrency(mult_surg_disc_perc, noofdecimal);

							mult_surg_disp_disc_perc  = st1.nextToken();
							if(mult_surg_disp_disc_perc.equals(" ")) mult_surg_disp_disc_perc="";
							mult_surg_disp_disc_perc = cf.formatCurrency(mult_surg_disp_disc_perc, noofdecimal);

							disc_amt = st1.nextToken();
							if(disc_amt.equals(" ")) disc_amt="";
								
							disc_amt = cf.formatCurrency(disc_amt, noofdecimal);
							if(disc_amt.equals(" ")) disc_amt="";
								
							net_amt = st1.nextToken();
							if(net_amt.equals(" ")) net_amt="";
							net_amt = cf.formatCurrency(net_amt, noofdecimal);
							
							pat_pay_amt = st1.nextToken();	
							if(pat_pay_amt.equals(" ")) pat_pay_amt="";
							pat_pay_amt = cf.formatCurrency(pat_pay_amt, noofdecimal);

							ass_ot_role_type = st1.nextToken();
							if(ass_ot_role_type.equals(" ")) ass_ot_role_type="";
	
							try
							{
								pstmt = con.prepareStatement( "SELECT ROLE_TYPE_DESC FROM OT_ROLE_TYPE 	WHERE UPPER(ROLE_TYPE)=UPPER('"+ass_ot_role_type+"')");
				
								rsrole = pstmt.executeQuery();	

								while(rsrole.next())
								{
								   ass_ot_role_type_desc  =  rsrole.getString(1);		
								}	
								rsrole.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}

							sysmessageid =st1.nextToken();
							if(sysmessageid.equals(" ")) sysmessageid="";
							
							errorlevel=st1.nextToken();	
							if(errorlevel.equals(" ")||errorlevel.equals("0")) errorlevel="";
							
							errortext=st1.nextToken();
							if(errortext.equals(" ")) errortext="";

//							System.out.println("sysmessageid:"+sysmessageid);
//							System.out.println("errortext:"+errortext);

					

							if(!sysmessageid.equals("") || (!errorlevel.equals("") || !errortext.equals("")))
							{
								checked_val="";
							}
							else
							{
								checked_val="checked";
							}
							
							if(k==0)
							{
								classval="PATIENTLINECOLOR";
								str_disabled="";
								//checked_val="";
								chk_box_val="Y";
							}
							else
							{
								if(i % 2 == 0 )
								{
									if(!sysmessageid.equals("") || (!errorlevel.equals("") || !errortext.equals("")))
									{
										classval="RED";
										str_disabled="DISABLED";
										chk_box_val="";
									}
									else
									{
										classval	=	"NORMPATLINE";		
										str_disabled="";
										chk_box_val="Y";
									}
								}
								else
								{
									if(!sysmessageid.equals("") || (!errorlevel.equals("") || !errortext.equals("")))
									{
										classval="RED";
										str_disabled="DISABLED";
										chk_box_val="";
									}
									else
									{					
										classval	=	"NORMPATLINE";
										str_disabled="";
										chk_box_val="Y";
									}
								}
							}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);

							if(k==0)
							{
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chk_box_val));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chk_box_val));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled_view_mode));
            _bw.write(_wl_block30Bytes, _wl_block30);
								
							}
							else
							{
				
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(style_ref));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chk_box_val));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(checked_val));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(chk_box_val));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled_view_mode));
            _bw.write(_wl_block36Bytes, _wl_block36);

							}
				
            _bw.write(_wl_block2Bytes, _wl_block2);

							if(k==0)
							{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((cat_blng_serv_desc==null || cat_blng_serv_desc.equals(""))?"&nbsp;":cat_blng_serv_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
							}
							else
							{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((serv_desc==null || serv_desc.equals(""))?"&nbsp;":serv_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);

							}

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_catalog_array.get(ord)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((charge_perc==null || charge_perc.equals(""))?"&nbsp;":charge_perc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(charge_perc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((dep_serv_desc==null || dep_serv_desc.equals(""))?"&nbsp;":dep_serv_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dep_blng_serv_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf((gross_amount==null || gross_amount.equals(""))?"&nbsp;":gross_amount));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(gross_amount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(mult_surg_disp_disc_perc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mult_surg_disc_perc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disc_amt));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disc_amt));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(net_amt));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(net_amt));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(pat_pay_amt));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pat_pay_amt));
            _bw.write(_wl_block70Bytes, _wl_block70);
 if(function_id.equals("EDIT"))
{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(str_disabled));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(disabled_view_mode));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

							//ArrayList arr_pract_id= new ArrayList();
						
							if(k==0)
							{
								for(int n=0;n<arr_role_type.size();n++)
								{
									if(arr_role_type.get(n).equals("OS"))
									{										
										pract_id=(String)arr_sur_id.get(n);
										//out.println("<input type='hidden' name='pract_id_' id='pract_id_'"+ord+"_"+k+"' value='"+pract_id+"'>");
										String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id+"' AND LANGUAGE_ID ='"+locale+"'";

										stmt = con.createStatement();
										
										ResultSet rssn = stmt.executeQuery(s1);
											
										while(rssn.next())
										{
											pract_short_name = rssn.getString(1) ;
											out.println("<option  value=\""+pract_id+"\">"+pract_short_name+"</option>");
										}	
										rssn.close();
										stmt.close();
									}
								}
							}
							if(!ass_ot_role_type.equals(""))
							{
								for(int n=0;n<arr_role_type.size();n++)
								{
									if(arr_role_type.get(n).equals(ass_ot_role_type))
									{
										pract_id=(String)arr_sur_id.get(n);
										String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id+"' AND LANGUAGE_ID ='"+locale+"'";

										stmt = con.createStatement();
										ResultSet rssn = stmt.executeQuery(s1);
												
										while(rssn.next())
										{
											pract_short_name = rssn.getString(1) ;												   
											out.println("<option  value=\""+pract_id+"\">"+pract_short_name+"</option>");
										}	
										rssn.close();
										stmt.close();
									}
								}
							}
							else
							{
								
								for(int m=0;m<arr_sur_id.size();m++)
								{									
									pract_id=(String)arr_sur_id.get(m);
									String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id+"' AND LANGUAGE_ID ='"+locale+"'";

									stmt = con.createStatement();
											
									ResultSet rssn = stmt.executeQuery(s1);
												
									while(rssn.next())
									{
										pract_short_name = rssn.getString(1) ;												   
										out.println("<option value=\""+arr_sur_id.get(m)+"\">"+pract_short_name+"</option>");
									}	
									rssn.close();
									stmt.close();
								}
							}

            _bw.write(_wl_block77Bytes, _wl_block77);

	}
	else{
			String pract_id_view = st1.nextToken();
			if(pract_id_view.equals(" ")) pract_id_view="";
			String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id_view+"' AND LANGUAGE_ID ='"+locale+"'";

			stmt = con.createStatement();
					
			ResultSet rssn = stmt.executeQuery(s1);
						
			while(rssn.next())
			{
				pract_short_name = rssn.getString(1) ;	
				
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(pract_short_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(disabled_view_mode));
            _bw.write(_wl_block83Bytes, _wl_block83);

				
			}	
			rssn.close();
			stmt.close();
			

		}


            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sysmessageid));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(errorlevel));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(errortext));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sec_key_module_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sec_key_main));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sec_key_line_no));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disc_seq_num));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ass_ot_role_type));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(p_sec_key_main_oper_num));
            _bw.write(_wl_block106Bytes, _wl_block106);
			
						}
						k++;
						surg_count++;					
					}	

            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k-1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k-1));
            _bw.write(_wl_block110Bytes, _wl_block110);
		
					tot_amt=tot_amt+Double.parseDouble(charge_base_amt);
				}

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block112Bytes, _wl_block112);

//			System.err.println("****** Testing");
			}
			else
			{

            _bw.write(_wl_block113Bytes, _wl_block113);

			}
		}
		catch(Exception ee)
		{
			System.out.println("Exception in string token :"+ee);
		}	

            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(ord));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(order_catalog_array));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(addl_services_yn));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block124Bytes, _wl_block124);

	}
	catch(Exception e)
	{
		System.out.println("Exception main :"+ e);
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingService.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DEPENDENT_SERVICE.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCOUNT_PERC.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_AMT.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NetAmount.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
}
