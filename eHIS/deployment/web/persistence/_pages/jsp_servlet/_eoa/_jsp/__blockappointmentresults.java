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
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __blockappointmentresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BlockAppointmentResults.jsp", 1729083022261L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eOA/js/Blockapptslots.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<html>\n<head>\n<script>\nasync function toFill(obj2){\n\ttime_table_type=document.forms[0].time_table_type.value;\t\n\tmax_patients_per_slab=parseInt(document.forms[0].max_patients_per_slab.value);\t\t\n\t\t\t\n//document.forms[0].to_count.value=obj2;\nvar name=document.getElementById(\"results\").rows[u1].cells[u2+2].innerText;\nvar value7=document.getElementById(\"results\").rows[u1].cells[u2].innerText;\nvar visit_rule = document.forms[0].visit_limit_rule.value;\nvar slotsblocked; \nif(time_table_type == \"2\"){\t\n\tidentify_first=eval(document.getElementById(\"identify_first\"+obj2)).value;\n\tobj3=max_patients_per_slab - identify_first ;\n\tslotsblocked = (eval(u1)-eval(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'))+1+obj3;\n\tdocument.forms[0].to_count.value=eval(u1)+obj3;\n}else{\n\tslotsblocked = (eval(u1)-eval(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'))+1;\n\tdocument.forms[0].to_count.value=obj2;\n}\nvar call_visit=\"N\";\nif (\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' == \'M\'||\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' == \'E\'){\n\t if(parseInt(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\') >0 ||parseInt(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')>0){\n\t\tcall_visit = \"Y\";\n\t }\n\n}\n\nif(name.length == 1){\n\tparent.parent.frames[0].document.forms[0].b_to.value=value7;\n\t\nif(document.forms[0].time_table_type.value !=\"3\"){\n\n\tif(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'\t != \'\'|| call_visit==\"Y\" ){\n\t\tvar params = \"facility_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&location_code=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&time_table_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&slot_appt_ctrl=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&visit_limit_rule=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&block_date=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&practitioner_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&max_other_visits=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&max_first_visits=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&srl_no=&slots_blocked=\"+slotsblocked+\"&alcn_criteria=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&clinic_type=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&res_type=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"\n\t\t//var features\t= \"dialogHeight:20; dialogWidth:30; scroll=no; status:no\";\n\t\tvar features\t= \"dialogHeight:90vh; dialogWidth:40vw; scroll=no; status:no\";\n\n\t\n\t\tvar retVal = await window.showModalDialog(\"../../eOA/jsp/BlockApptAllocationDetailsFrames.jsp?\"+params,arguments,features);\n\t\n\t\tif(retVal==undefined)\n\t\t\t\tretVal=\"\";\t\t\n\t\t\n\t\tif(retVal !=\'\'){\n\t\t\n\t\tif(retVal != null && retVal != \'\' && retVal != \'F\')\n\t\t{\n\t\t\tvar  temp = new Array()\n\t\t\ttemp = retVal.split(\"$\");\n\t\t\tif(temp[0]!=\"\")\n\t\t\t{\n\t\t\t\tparent.parent.frames[0].document.forms[0].insert_detail.value = \'Y\';\n\t\t\t\tparent.parent.frames[0].document.forms[0].final_values.value = temp[0];\n\t\t\t\t\n\t\t\t}\n\t\t\tif (temp[1]!=null)\n\t\t\t{\n\t\t\t\tvar temp1 = new Array();\n\t\t\t\ttemp1 = temp[1].split(\"#\");\n\t\t\t\tparent.parent.frames[0].document.forms[0].first_visits_value.value = temp1[0];\n\t\t\t\tparent.parent.frames[0].document.forms[0].other_visits_value.value = temp1[1];\n\t\t\t\t\n\t\t\t\t\n\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.parent.frames[0].document.forms[0].insert_detail.value = \'N\';\n\t\t\tparent.parent.frames[0].document.forms[0].final_values.value = \"\";\n\t\t\tparent.parent.frames[0].document.forms[0].first_visits_value.value = \"\";\n\t\t\tparent.parent.frames[0].document.forms[0].other_visits_value.value = \"\";\n\t\t\tparent.parent.frames[0].document.forms[0].b_to.value = \"\";\n\n\t\t\tparent.parent.frames[0].document.forms[0].b_from.readOnly = true;\n\t\t\tparent.parent.frames[0].document.forms[0].b_to.readOnly = true;\n\n\t\t}\n\t\t}else{\n\t\t\tparent.parent.frames[0].document.forms[0].b_from.readOnly = false;\n\t\t\tparent.parent.frames[0].document.forms[0].b_to.readOnly = false;\n\t\t\tparent.parent.frames[0].document.forms[0].insert_detail.value = \'N\';\n\t\t\tparent.parent.frames[0].document.forms[0].final_values.value = \"\";\n\t\t\tparent.parent.frames[0].document.forms[0].first_visits_value.value = \"\";\n\t\t\tparent.parent.frames[0].document.forms[0].other_visits_value.value = \"\";\n\n\t\t\tparent.parent.frames[0].document.forms[0].b_to.value = \"\";\n\n\t\t\tparent.parent.frames[0].document.forms[0].b_from.readOnly = true;\n\t\t\tparent.parent.frames[0].document.forms[0].b_to.readOnly = true;\n\n\n\t\t}\n\t}\n}\n}else{\n\talert(getMessage(\'CAN_NOT_SELECT_TIME\',\"OA\"));\n}\n}\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\' >\n<form name=\'displayresults\' id=\'displayresults\'>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results\'>\n\t<th class=\'COLUMNHEADER\' width=\'5%\' style=\'color:white\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th>\n\t<th class=\'COLUMNHEADER\' width=\'5%\' style=\'color:white\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</th>\n\t<th class=\'COLUMNHEADER\' width=\'23%\' style=\'color:white\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</th>\n\t<th class=\'COLUMNHEADER\' width=\'2%\' style=\'color:white\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\t<th class=\'COLUMNHEADER\' width=\'30%\' style=\'color:white\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\t<th class=\'COLUMNHEADER\' width=\'11%\' style=\'color:white\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</th>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<tr onClick=\'row(this)\'>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<td width=5% class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\'col(this)\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" <input type=\'hidden\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'o_appt_ref_no";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' > </td>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<td width=5% class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' > </td>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t<td width=5% class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' > </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onClick=\'col(this)\'><a href= javascript:moveNext(";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =")>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</a> <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' ></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\n\t\t\t<td width=5% class=\'OAFORCED\' title=  \'Forced Appointment\' onClick=\'col(this)\'> <a href= javascript:moveNext(";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" </a><input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \' ></td>\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<td width=5% class=\'oared\' title =\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' ></td>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t<td width=5% class=\'oablock\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' >&nbsp; <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onClick=\'col(this)\'><a href=javascript:toFill(";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" </a></td>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" </td>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t<td width=5% class=\'OARED\'  title =\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t<td width=5% class=\'OAFORCED\' title= \'Forced Appointment\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\n\t<td width=5% class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<td width=5% class=\'OARED\'  title =\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t<td width=5% class=\'oablock\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<td width=23% class=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t<td width=23% class=\'oared\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t<td width=23% class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t<td width=23% class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&nbsp;";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =":<b>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\t\t\t\t \n\t\t\t\t<td width=23% class=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t<td width=5% class=\'oared\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t<td width=2% class=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t<td width=2% class=\'oared\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t<td width=30% class=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t<td width=30% class=\'oared\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t<td width=30% class=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t<td width=11% class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t<td width=11% class=\'oared\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t<td width=11% class=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t<td width=23% class=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="<td width=23% class=\'oared\'>&nbsp;</td>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="<td width=23% class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' >&nbsp;</td>\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t</tr> \n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'identify_first";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' id=\'identify_first";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' >\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n</table>\n<br>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n<input type=\'hidden\' name=\'r_appt_status\' id=\'r_appt_status\' value=\'null\' >\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" >\n<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" >\n<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" >\n<input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" >\n<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" >\n<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" >\n<input type=\'hidden\' name=\'P_O_TIME_TAB_TYPE\' id=\'P_O_TIME_TAB_TYPE\' value=";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" >\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'null\'>\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" >\n<input type=\'hidden\' name=\'sys_time\' id=\'sys_time\' value=";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" >\n\n\t<input type=\'hidden\' name=\'slot_appt_ctrl\' id=\'slot_appt_ctrl\'  value=";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" >\n\n<input type=\'hidden\' name=\'time_per_patient\' id=\'time_per_patient\'  value=";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" >\n<input type=\'hidden\' name=\'max_patients_per_slab\' id=\'max_patients_per_slab\'  value=";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" >\n\n<input type=\'hidden\' name=\'reason_for_revise\' id=\'reason_for_revise\'  value=";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" >\n<input type=\'hidden\' name=\'ref_no\' id=\'ref_no\' value= ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" >\n<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n<input type=\'hidden\' name=\'clinic_type\' id=\'clinic_type\' value= ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" >\n<input type=\'hidden\' name=\'res_type\' id=\'res_type\' value= ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" >\n<input type=\'hidden\' name=\'noslots\' id=\'noslots\' value= \'\' >\n<input type=\'hidden\' name=\'total_first_visits_blocked\' id=\'total_first_visits_blocked\' value= \'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n<input type=\'hidden\' name=\'total_other_visits_blocked\' id=\'total_other_visits_blocked\' value= \'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' >\n<input type=\'hidden\' name=\'max_patients_per_day\' id=\'max_patients_per_day\' value= \'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' >\n<input type=\'hidden\' name=\'time_table_type\' id=\'time_table_type\' value= \'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' >\n<input type=\'hidden\' name=\'counter\' id=\'counter\' value= \'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' >\n\n<input type=\'hidden\' name=\'to_count\' id=\'to_count\' value= \'\' >\n\n<!-- Added for ML-BRU-CRF-0628.1 -->\n<input type=\"hidden\" name=\"p_o_ext_slot_status\" id=\"p_o_ext_slot_status\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n<input type=\"hidden\" name=\"p_o_reserved_slot_dtls\" id=\"p_o_reserved_slot_dtls\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n<input type=\"hidden\" name=\"p_o_appt_slot_dtls\" id=\"p_o_appt_slot_dtls\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n<input type=\"hidden\" name=\"p_o_block_slot_dtls\" id=\"p_o_block_slot_dtls\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n<input type=\"hidden\" name=\"p_o_break_slot_dtls\" id=\"p_o_break_slot_dtls\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n<input type=\"hidden\" name=\"isSlotStartMidEndAppl\" id=\"isSlotStartMidEndAppl\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n<!-- End ML-BRU-CRF-0628.1 -->\n\n</form>\n\n<script>\n\t\n/* Added for ML-BRU-CRF-0628.1 */\nif (document.forms[0].isSlotStartMidEndAppl.value==\'true\'){\n\n\tvar ext_slt=document.forms[0].p_o_ext_slot_status.value;\n\tvar res_slt=document.forms[0].p_o_reserved_slot_dtls.value;\n\tvar appt_slt=document.forms[0].p_o_appt_slot_dtls.value;\n\tvar blk_slt=document.forms[0].p_o_block_slot_dtls.value;\n\tvar brk_slt=document.forms[0].p_o_break_slot_dtls.value;\n\n\n\tvar ext_slot_arr=ext_slt.split(\"|\");\n\tvar res_slot_arr=res_slt.split(\"|\");\n\tvar appt_slot_arr=appt_slt.split(\"|\");\n\tvar blk_slot_arr=blk_slt.split(\"|\");\n\tvar brk_slot_arr=brk_slt.split(\"|\");\n\n\n\tfor(var i=0;i<=ext_slot_arr.length;i++){\n\t\t\n\t\tif(ext_slot_arr[i]==\'Y\') {\n\n\t\t\tif(blk_slot_arr[i]==\'N\' && brk_slot_arr[i]==\'N\') {\n\t\t\t\tif(res_slot_arr[i] !=\'N\'){\n\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(0).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(1).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(0).style.Color = \"Black\";\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(1).style.Color = \"Black\";\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(2).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(2).innerText = \"BRU Health Reservation : \"+res_slot_arr[i];\n\n\t\t\t\t}else {\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(0).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results\").rows(i+1).cells(1).style.backgroundColor = \"Bisque\";\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t\n\t\t}\n\t\t\t\n\t}\n}\n/* End ML-BRU-CRF-0628.1 */\n</script>\n\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t<script>\n\t var err = getMessage(\'SCH_NO_SLOT\',\'OA\');\n\tparent.parent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+err; </script>\n\t\n<script>parent.parent.frames[1].location.href=\'../../eCommon/html/blank.html\' </script>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);



request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");	
String locale=(String)session.getAttribute("LOCALE");

String date=(String)request.getParameter("Date"); 

String from_page=(String)request.getParameter("from_page");
if(from_page ==null) from_page="";
if(from_page.equals(""))
{
date=DateUtils.convertDate(date,"DMY",locale,"en");
}

String clinic_code=(String)request.getParameter("clinic_code");
String practitioner_id=(String)request.getParameter("practitioner_id");
if(practitioner_id == null) practitioner_id="";
String value12=(String)request.getParameter("value12");
if( value12 == null || value12.equals("null")) value12="";
String value13=(String)request.getParameter("value13");
if( value13 == null || value13.equals("null"))  value12="";
String facilityid=(String)session.getValue("facility_id");
String anchor=(String)request.getParameter("anchor");
if( anchor == null || anchor.equals("null"))  anchor="";
String to_anchor=(String)request.getParameter("to_anchor");
if( to_anchor == null || to_anchor.equals("null"))  to_anchor="";

String rowNum=(String)request.getParameter("rowNum");
if( rowNum == null || rowNum.equals("null")) rowNum="0";

String clinic_type=request.getParameter("clinic_type");
String res_type=request.getParameter("res_type");


int v=0;
if( rowNum != null || ! rowNum.equals(""))
{
v=Integer.parseInt(rowNum);
}

            _bw.write(_wl_block9Bytes, _wl_block9);


String P_FACILITY_ID   =facilityid;
String P_CLINIC_DATE      =date;
String P_CLINIC_CODE      =clinic_code;
String P_PRACTITIONER_ID      =practitioner_id;
String p_o_srl_no			  ="";
String P_O_CLINIC             ="";
String P_O_PRACTITIONER       ="";
String P_O_MAX_PAT            ="";
String P_O_MAX_OVER_BOOK      ="";
String P_O_BOOKED             ="";
String P_O_OVER_BOOKED        ="";
String P_O_OVER_BOOKING       ="N";
String P_O_TIME_TAB_TYPE     ="";
String P_O_STATUS             ="";
String P_O_FROM_TIME          ="";
String P_O_TO_TIME            ="";
String P_O_APPT_REF_NO        ="";
String P_O_PATIENT_NAME       ="";
String P_O_AGE                ="";
String P_O_GENDER             ="";
String P_O_REASON_FOR_CON    ="";
String P_O_VISIT_TYPE         ="";
String P_O_CONTACT            ="";
String P_O_NO_OF_SLOTS= "";
String P_O_PATIENT_ID       ="";



String sys_date=request.getParameter("sys_date");
String sys_time=request.getParameter("sys_time");

String alcncriteria = "";
Connection con=null;
Statement stmt2=null;
ResultSet rs2=null;
Statement stmtsd=null;
PreparedStatement pstmt=null;
ResultSet rs= null;
CallableStatement statement=null;
CallableStatement cstmt = null;
CallableStatement statement_bru = null;
String time_per_patient="";
String time_per_slab="";
String visit_limit_rule=request.getParameter("visit_limit_rule");
String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
String primary_resource_yn="";

String total_first_visits_blocked="";
String total_other_visits_blocked="";
String time_table_type="";
String max_patients_per_slab="";

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
String schedule_extend_yn="N"; 

 //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
 Boolean isSlotStartMidEndAppl = false;
 String p_o_ext_slot_status = "";
 String p_o_reserved_slot_dtls = "";
 String p_o_appt_slot_dtls = "";
 String p_o_block_slot_dtls = "";
 String p_o_break_slot_dtls = "";

try{
	con=ConnectionManager.getConnection(request);
stmt2 = con.createStatement();

isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

String max_other_visits=""; 
String max_first_visits=""; 
String max_patients_per_day=""; 
String total_booked1=""; 
boolean block_allow_flag= true;

//String sql2="select time_per_patient,nvl(max_first_visits,0) max_first_visits,nvl(max_other_visits,0) max_other_visits, alcn_criteria,nvl(max_patients_per_day,0) max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, nvl(total_first_visits_blocked,0) total_first_visits_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked,primary_resource_yn ,time_table_type,TIME_PER_SLAB,MAX_PATIENTS_PER_SLAB, schedule_extend_yn from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"' ,'X') and nvl(schedule_status,'X') !=nvl('B','X')  and time_table_type !='3' and care_locn_type_ind='"+clinic_type+"' and  resource_class='"+res_type+"' ";
String sql2="select time_per_patient,nvl(max_first_visits,0) max_first_visits,nvl(max_other_visits,0) max_other_visits, alcn_criteria,nvl(max_patients_per_day,0) max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, nvl(total_first_visits_blocked,0) total_first_visits_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked,primary_resource_yn ,time_table_type,TIME_PER_SLAB,MAX_PATIENTS_PER_SLAB, schedule_extend_yn from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl(? ,'X') and nvl(schedule_status,'X') !=nvl('B','X')  and time_table_type !='3' and care_locn_type_ind=? and  resource_class=? ";

//rs2 = stmt2.executeQuery(sql2);
pstmt = con.prepareStatement(sql2);
pstmt.setString(1,facilityid);
pstmt.setString(2,clinic_code);
pstmt.setString(3,date);
pstmt.setString(4,practitioner_id);
pstmt.setString(5,clinic_type);
pstmt.setString(6,res_type);
rs2 = pstmt.executeQuery();
if(rs2.next())
{
	time_table_type= rs2.getString("time_table_type");
	if(time_table_type.equals("1"))
	{
	String time_per_patient2=rs2.getString("time_per_patient");
	time_per_patient=time_per_patient2.substring(10,16);
	}else
	{
		time_per_slab=rs2.getString("TIME_PER_SLAB");
	time_per_patient=time_per_slab.substring(10,16);
	max_patients_per_slab=rs2.getString("MAX_PATIENTS_PER_SLAB");
	}
	max_first_visits=rs2.getString("max_first_visits");
	max_other_visits=rs2.getString("max_other_visits");
	primary_resource_yn=rs2.getString("primary_resource_yn");
	alcncriteria = rs2.getString("alcn_criteria")==null?"":rs2.getString("alcn_criteria"); 

	schedule_extend_yn=rs2.getString("schedule_extend_yn");
	if(schedule_extend_yn==null) schedule_extend_yn="N";
	
	max_patients_per_day= rs2.getString("max_patients_per_day");
	P_O_MAX_OVER_BOOK   =rs2.getString("max_over_booking" );        
	if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
	P_O_BOOKED          =rs2.getString("total_slots_booked" );   
	if( P_O_BOOKED ==null) P_O_BOOKED="";
	P_O_OVER_BOOKED        =rs2.getString( "total_slots_overbooked" );    
					if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
	total_booked1		= rs2.getString("total_booked");
	total_first_visits_blocked= rs2.getString("total_first_visits_blocked");
	total_other_visits_blocked= rs2.getString("total_other_visits_blocked");
	
if (slot_appt_ctrl.equals("P") && max_patients_per_day.equals(total_booked1))
			block_allow_flag=false;


/* Added for ML-BRU-CRF-0628.1 */
if(isSlotStartMidEndAppl){
	cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
	cstmt.setString( 1, P_FACILITY_ID );
	cstmt.setString( 2, P_CLINIC_CODE );
	cstmt.setString( 3, P_PRACTITIONER_ID );
	cstmt.setString( 4, P_CLINIC_DATE );
	cstmt.registerOutParameter( 5, Types.VARCHAR );
	cstmt.registerOutParameter( 6, Types.VARCHAR );
	cstmt.registerOutParameter( 7, Types.VARCHAR );
	cstmt.registerOutParameter( 8, Types.VARCHAR );
	cstmt.registerOutParameter( 9, Types.VARCHAR );

	cstmt.execute() ;

	p_o_ext_slot_status = cstmt.getString( 5 ); 
	if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
	
	p_o_reserved_slot_dtls = cstmt.getString( 6 );
	if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

	p_o_appt_slot_dtls = cstmt.getString( 7 );
	if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

	p_o_block_slot_dtls = cstmt.getString( 8 );
	if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

	p_o_break_slot_dtls = cstmt.getString( 9 );
	if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
}

if(isSlotStartMidEndAppl && time_table_type.equals("2") && !max_patients_per_slab.equals("1")){

	System.err.println("Before execute oa_slabs_BRU---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

	statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	statement_bru.setString( 1, P_FACILITY_ID);
	statement_bru.setString( 2, P_CLINIC_CODE);
	statement_bru.setString( 3, P_PRACTITIONER_ID);
	statement_bru.setString( 4, P_CLINIC_DATE);
	statement_bru.registerOutParameter( 5, Types.CLOB );
	statement_bru.registerOutParameter( 6, Types.CLOB );
	statement_bru.registerOutParameter( 7, Types.CLOB );
	statement_bru.registerOutParameter( 8, Types.CLOB );
	statement_bru.registerOutParameter( 9, Types.CLOB );
	statement_bru.registerOutParameter(10, Types.CLOB );
	statement_bru.registerOutParameter(11, Types.CLOB );
	statement_bru.registerOutParameter(12, Types.CLOB );
	statement_bru.registerOutParameter(13, Types.CLOB );
	statement_bru.registerOutParameter(14, Types.CLOB );
	statement_bru.registerOutParameter(15, Types.CLOB );
	statement_bru.registerOutParameter(16, Types.CLOB );
	statement_bru.registerOutParameter(17, Types.CLOB );
	statement_bru.registerOutParameter(18, Types.CLOB );
	statement_bru.registerOutParameter(19, Types.CLOB );
	statement_bru.registerOutParameter(20, Types.CLOB );
	statement_bru.registerOutParameter(21, Types.CLOB );
	statement_bru.registerOutParameter(22, Types.CLOB );
	statement_bru.registerOutParameter(23, Types.CLOB );
	statement_bru.registerOutParameter(24, Types.CLOB );
	statement_bru.registerOutParameter(25, Types.CLOB );
	statement_bru.registerOutParameter(26, Types.CLOB );

	statement_bru.execute() ;

	
	P_O_CLINIC = P_CLINIC_CODE;

	P_O_PRACTITIONER = P_PRACTITIONER_ID;

	P_O_MAX_PAT = max_patients_per_day;

	P_O_TIME_TAB_TYPE = time_table_type;

	P_O_STATUS = statement_bru.getString(6); 
	if( P_O_STATUS == null) P_O_STATUS="";

	P_O_APPT_REF_NO = statement_bru.getString(7); 
	if( P_O_APPT_REF_NO == null) P_O_APPT_REF_NO="";

	P_O_PATIENT_NAME = statement_bru.getString(8); 
	if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";

	P_O_AGE = statement_bru.getString(9); 
	if( P_O_AGE == null) P_O_AGE="";

	P_O_GENDER = statement_bru.getString(10); 
	if( P_O_GENDER == null) P_O_GENDER="";

	P_O_REASON_FOR_CON = statement_bru.getString(12); 
	if( P_O_REASON_FOR_CON == null) P_O_REASON_FOR_CON="";

	P_O_VISIT_TYPE = statement_bru.getString(17); 
	if( P_O_VISIT_TYPE == null) P_O_VISIT_TYPE="";

	P_O_CONTACT = statement_bru.getString(13); 
	if( P_O_CONTACT == null) P_O_CONTACT="";

	P_O_PATIENT_ID = statement_bru.getString(15); 
	if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

	p_o_srl_no = statement_bru.getString(16); 
	if( p_o_srl_no == null) p_o_srl_no="";

	P_O_FROM_TIME = statement_bru.getString(24);     
	if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

	P_O_TO_TIME = statement_bru.getString(25);	
	if(P_O_TO_TIME == null) P_O_TO_TIME="";

	P_O_NO_OF_SLOTS = statement_bru.getString(26); 
	if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

}else{
/* End ML-BRU-CRF-0628.1 */

String proc_name="";

//if(primary_resource_yn.equals("Y")){
	//proc_name="{call GET_DAY_SCHEDULE_STATUS_NEW( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

	System.err.println("Before execute get_day_status---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

	proc_name="{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	statement=con.prepareCall(proc_name);

	statement.setString( 1, P_FACILITY_ID);
	statement.setString( 2, P_CLINIC_DATE);
	statement.setString( 3, P_CLINIC_CODE);
	statement.setString( 4, P_PRACTITIONER_ID);
	statement.setString( 5, clinic_type);
	statement.setString( 6, res_type);

	statement.registerOutParameter(7, Types.VARCHAR );
	statement.registerOutParameter(8, Types.VARCHAR );
	statement.registerOutParameter(9, Types.INTEGER);
	statement.registerOutParameter(10, Types.INTEGER);
	statement.registerOutParameter(11, Types.INTEGER);
	statement.registerOutParameter(12, Types.INTEGER);
	statement.registerOutParameter(13, Types.VARCHAR );
	statement.registerOutParameter(14, Types.VARCHAR );
	statement.registerOutParameter(15, Types.VARCHAR );
	statement.registerOutParameter(16, Types.VARCHAR );
	statement.registerOutParameter(17, Types.VARCHAR );
	statement.registerOutParameter(18, Types.VARCHAR );
	statement.registerOutParameter(19, Types.VARCHAR );
	statement.registerOutParameter(20, Types.VARCHAR );
	statement.registerOutParameter(21, Types.VARCHAR );
	statement.registerOutParameter(22, Types.VARCHAR );
	statement.registerOutParameter(23, Types.VARCHAR );
	statement.registerOutParameter(24 ,Types.VARCHAR );
	statement.registerOutParameter(25 ,Types.VARCHAR );
	statement.registerOutParameter(26 ,Types.VARCHAR );
	statement.registerOutParameter(27 ,Types.VARCHAR );
	statement.registerOutParameter(28 ,Types.VARCHAR );
	statement.registerOutParameter(29 ,Types.VARCHAR );
	statement.registerOutParameter(30 ,Types.VARCHAR );
	statement.registerOutParameter(31 ,Types.VARCHAR );
	statement.registerOutParameter(32 ,Types.VARCHAR );
	statement.registerOutParameter(33 ,Types.VARCHAR );
	//if(primary_resource_yn.equals("Y")){
	statement.setString( 34, locale);
	statement.registerOutParameter(35 ,Types.VARCHAR );
	statement.registerOutParameter(36 ,Types.VARCHAR );
	statement.registerOutParameter(37 ,Types.VARCHAR );
	statement.registerOutParameter(38 ,Types.VARCHAR );
	statement.registerOutParameter(39 ,Types.VARCHAR );
	statement.registerOutParameter(40 ,Types.VARCHAR );
	statement.registerOutParameter(41 ,Types.VARCHAR );
//	}


	statement.execute() ;

	System.err.println("After execute get_day_status---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

	P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
	P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
	P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
	P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
	P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
	P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
	P_O_OVER_BOOKING         =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) P_O_OVER_BOOKING="";
	P_O_TIME_TAB_TYPE          =statement.getString( 14 );	
	P_O_STATUS                    =statement.getString(15);
	P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
	P_O_TO_TIME                   =statement.getString( 17 );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
	P_O_APPT_REF_NO         =statement.getString(18 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
	P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";
	P_O_AGE                       =statement.getString( 20 );		if(P_O_AGE ==null) P_O_AGE="";
	P_O_GENDER                    =statement.getString( 21 );	if(P_O_GENDER ==null) P_O_GENDER="";
	P_O_REASON_FOR_CON    =statement.getString( 22 );        if(P_O_REASON_FOR_CON ==null) P_O_REASON_FOR_CON="";
	P_O_VISIT_TYPE                =statement.getString( 23 );		if(P_O_VISIT_TYPE ==null) P_O_VISIT_TYPE="";
	P_O_CONTACT       =statement.getString( 24 );		if(P_O_CONTACT == null) P_O_CONTACT="";
	P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";
	P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";
	p_o_srl_no=statement.getString(33); if( p_o_srl_no == null) p_o_srl_no="";

}

	System.err.println("P_O_CLINIC-------->"+P_O_CLINIC);
	System.err.println("P_O_PRACTITIONER-------->"+P_O_PRACTITIONER);
	System.err.println("P_O_MAX_PAT-------->"+P_O_MAX_PAT);
	System.err.println("P_O_MAX_OVER_BOOK-------->"+P_O_MAX_OVER_BOOK);
	System.err.println("P_O_BOOKED-------->"+P_O_BOOKED);
	System.err.println("P_O_OVER_BOOKED-------->"+P_O_OVER_BOOKED);
	System.err.println("P_O_OVER_BOOKING-------->"+P_O_OVER_BOOKING);
	System.err.println("P_O_TIME_TAB_TYPE-------->"+P_O_TIME_TAB_TYPE);
	System.err.println("P_O_STATUS-------->"+P_O_STATUS);
	System.err.println("P_O_FROM_TIME-------->"+P_O_FROM_TIME);
	System.err.println("P_O_TO_TIME-------->"+P_O_TO_TIME);
	System.err.println("P_O_APPT_REF_NO-------->"+P_O_APPT_REF_NO);
	System.err.println("P_O_PATIENT_NAME-------->"+P_O_PATIENT_NAME);
	System.err.println("P_O_AGE-------->"+P_O_AGE);
	System.err.println("P_O_GENDER-------->"+P_O_GENDER);
	System.err.println("P_O_REASON_FOR_CON-------->"+P_O_REASON_FOR_CON);
	System.err.println("P_O_VISIT_TYPE-------->"+P_O_VISIT_TYPE);
	System.err.println("P_O_CONTACT-------->"+P_O_CONTACT);
	System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
	System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
	System.err.println("p_o_srl_no-------->"+p_o_srl_no);

	StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
	int counter=token.countTokens();
	String from_time[]=new String[counter];
	int track=0;
	while (token.hasMoreTokens()){
		from_time[track]=token.nextToken();
		track++;
	}
	//StringTokenizer token1 = new StringTokenizer(P_O_TO_TIME, "|");
	token = new StringTokenizer(P_O_TO_TIME, "|");
	String to_time[]=new String[counter];
	int track1=0;
	String end_time ="";
	int tot_token= token.countTokens();

	while (token.hasMoreTokens())
	{
		end_time=token.nextToken();

		if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

			if (tot_token-track1 == 1) {					
				end_time="00:00";
			}
		}
		
		to_time[track1]=end_time;

		track1++;
	}
	
	//StringTokenizer token2 = new StringTokenizer(P_O_PATIENT_NAME, "|");
	token = new StringTokenizer(P_O_PATIENT_NAME, "|");
	//String new_pat[]=new String[counter];
	String patient_name[]=new String[counter];
	int track2=0;
	String s = null;
	while (token.hasMoreTokens()){
		s = token.nextToken();
		patient_name[track2]=s;
		track2++;
	}
	//StringTokenizer token21 = new StringTokenizer(P_O_PATIENT_ID, "|");
	token = new StringTokenizer(P_O_PATIENT_ID, "|");
	String patient_id[]=new String[counter];
	int track21=0;
	while (token.hasMoreTokens()){
		patient_id[track21]=token.nextToken();
		track21++;
	}
	//StringTokenizer token3 = new StringTokenizer(P_O_AGE, "|");
	token = new StringTokenizer(P_O_AGE, "|");
	String age[]=new String[counter];
	int track3=0;
	while (token.hasMoreTokens()){
		age[track3]=token.nextToken();
		track3++;
	}
	//StringTokenizer token4 = new StringTokenizer(P_O_GENDER, "|");
	token = new StringTokenizer(P_O_GENDER, "|");
	String gender[]=new String[counter];
	int track4=0;
	while (token.hasMoreTokens()){
		gender[track4]=token.nextToken();
		track4++;
	}
	//StringTokenizer token5 = new StringTokenizer(P_O_REASON_FOR_CON, "|") ;
	token = new StringTokenizer(P_O_REASON_FOR_CON, "|") ;
	String reason_for_contact[]=new String[counter];
	int track5=0;
	while (token.hasMoreTokens()){
		reason_for_contact[track5]=token.nextToken();
		track5++;
	}
	//StringTokenizer token6 = new StringTokenizer(P_O_VISIT_TYPE, "|");
	token = new StringTokenizer(P_O_VISIT_TYPE, "|");
	String visit_type[]=new String[counter];
	int track6=0;
	while (token.hasMoreTokens()){
		visit_type[track6]=token.nextToken();
		track6++;
	}
	//StringTokenizer token7 = new StringTokenizer(P_O_CONTACT, "|");
	token = new StringTokenizer(P_O_CONTACT, "|");
	String contact[]=new String[counter];
	int track7=0;
	while (token.hasMoreTokens()){
		contact[track7]=token.nextToken();
		track7++;
	}
	//StringTokenizer token8 = new StringTokenizer(P_O_APPT_REF_NO, "|");
	token = new StringTokenizer(P_O_APPT_REF_NO, "|");
	String o_appt_ref_no[]=new String[counter];
	int track8=0;
	while (token.hasMoreTokens()){
		o_appt_ref_no[track8]=token.nextToken();
		track8++;
	}
	//StringTokenizer token9 = new StringTokenizer(P_O_STATUS, "|");
	token = new StringTokenizer(P_O_STATUS, "|");

	String status[]=new String[counter];
	String status1[]=new String[counter];
	int track9=0;
	while (token.hasMoreTokens()){
		status[track9]=token.nextToken();
		status1[track9]=status[track9];
		track9++;
	}
	//StringTokenizer token11 = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
	token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
	String no_of_slots[]=new String[counter];
	int track11=0;
	while (token.hasMoreTokens()){
		no_of_slots[track11]=token.nextToken();
		track11++;
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(v));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(v));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(max_other_visits));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(max_first_visits));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(alcncriteria));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(P_O_TIME_TAB_TYPE));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max_other_visits));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(max_first_visits));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(alcncriteria));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

String classValue="";
String to_anchor2="";
String same_appt = "N";
String pat_name = "";
int identify_first=1;
//int group_count=1;
//boolean breakFlag=false;
int slots = 0;
boolean m=true;
for(int init=0;init<counter;init++)
{
same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];
}
if( v  == 0) to_anchor2="no";
else
if( init == v-1 ) to_anchor2="yes";
if ( init % 2 == 0 )
		classValue = "OAQRYEVEN" ;
			else
		classValue = "OAQRYODD" ;

            _bw.write(_wl_block36Bytes, _wl_block36);


String u=from_time[init];
String z=status[init];
String z1=status1[init];
String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
    z=reason1;
if(anchor.equals("reset"))
{
	
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(u));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block42Bytes, _wl_block42);

	String chk_blank_row_patient1=patient_name[init];	
		if(chk_blank_row_patient1.equals("~"))
		{ 
		  if(slots > 0)
		  {
			slots--;
			same_appt = "Y";
		   }
		}
		else
		{
		pat_name = patient_name[init];
		slots--;
		}
}

else
{

	if( ! u .equals("~"))
	{
		String chk_blank_row_patient=patient_name[init];		
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
		{
		if(chk_blank_row_patient.equals("~"))
		{ 
		  if(slots > 0)
		  {
			  
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( u));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block44Bytes, _wl_block44);

			slots--;
			same_appt = "Y";
			}
			else
			{
				if (z.equals("FL")&&(!block_allow_flag)) { 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(u));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block47Bytes, _wl_block47);
 }
				else { 								
					
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(init));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(u));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block51Bytes, _wl_block51);
						
					
					}
			}
		}


		else
		{
		if(z1.equals("OL*F"))
		{	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(init));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(u));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block54Bytes, _wl_block54);
}

		else
		{ 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(init));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(u));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block42Bytes, _wl_block42);
	
		pat_name = patient_name[init];
		slots--;
		}

	}
}
		else
		{
		if(z.equals("BN"))
		{ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(u));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block58Bytes, _wl_block58);
 }

		else { 
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(u));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block60Bytes, _wl_block60);
 }

		
		}
	
	
}
	else { 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block58Bytes, _wl_block58);
 }
}
 
String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

String u22=patient_name[init];
if(to_anchor2.equals("yes"))
{	
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
	{
		if( u22.equals("~") && m == true)
		{ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(init));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block63Bytes, _wl_block63);
 }
		else
		{ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block64Bytes, _wl_block64);
 }
	}
		else
	{
		if(z.equals("BN"))
		{ 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block66Bytes, _wl_block66);

		}
		else
		{
			
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block67Bytes, _wl_block67);

		}
		m=false;
	}

}
else
{
	if( ! u1 .equals("~"))
	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
		{

		
		if(z1.equals("OL*F"))
		{			
			
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block69Bytes, _wl_block69);

		}
		else
		{
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
		
		}
		else
		if(z.equals("BN"))
		{
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( u1));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
		else
		{
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
	}
	else { 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
 }
}

String u2=patient_name[init];
String pat_id=patient_id[init];
if(pat_id.equals("~"))
	pat_id="";
else
	pat_id=pat_id+" , ";


	if( ! u2 .equals("~"))		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
			if( (v-1) < init) v=0;
			
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(u2));
            _bw.write(_wl_block78Bytes, _wl_block78);


		}else
			
            _bw.write(_wl_block79Bytes, _wl_block79);

	}else if(same_appt.equals("Y")){ 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block81Bytes, _wl_block81);
 }else{
		if(z.equals("BN")){
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block85Bytes, _wl_block85);
}else{
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
	}

String u3=age[init];
	if( ! u3 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(u3));
            _bw.write(_wl_block67Bytes, _wl_block67);

		}
		else
			
            _bw.write(_wl_block88Bytes, _wl_block88);

		}
		else {
			
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
 }

String u4=gender[init];
	if( ! u4 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(u4));
            _bw.write(_wl_block66Bytes, _wl_block66);

		}
		else
			
            _bw.write(_wl_block91Bytes, _wl_block91);

		}
		else {
		
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
}


String u5=reason_for_contact[init];
	if( ! u5 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ 
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(u5));
            _bw.write(_wl_block66Bytes, _wl_block66);

		}
		else
		
            _bw.write(_wl_block93Bytes, _wl_block93);

		}
		else {
			
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
}

String u6=visit_type[init];
	if( ! u6 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ 
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(u6));
            _bw.write(_wl_block81Bytes, _wl_block81);

		}
		else
			
            _bw.write(_wl_block96Bytes, _wl_block96);

		}
		else {
			
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
 }

String u7=contact[init];
	if( ! u7 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ 
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(u7));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
		else
	
            _bw.write(_wl_block99Bytes, _wl_block99);

		}
		else {
		
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
}
		
            _bw.write(_wl_block102Bytes, _wl_block102);
											
				if(time_table_type.equals("2")){
				if(z.equals("RN")){
					identify_first=1;
					/*if(!breakFlag){
						group_count++;
						breakFlag=true;
					}*/
				}else{
					if(identify_first > Integer.parseInt(max_patients_per_slab)){						
							identify_first=1;
							//group_count++;							
					}
					//breakFlag=false;
				}
			
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(init));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(identify_first));
            _bw.write(_wl_block105Bytes, _wl_block105);
   if(!z.equals("RN")){
				identify_first++;
		}else{
			//group_count++;
		}
		}
	}

            _bw.write(_wl_block106Bytes, _wl_block106);




            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf( clinic_code ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(P_O_CLINIC ));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(practitioner_id ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(date ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(P_O_OVER_BOOKING ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(P_O_TIME_TAB_TYPE));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( sys_time ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf( slot_appt_ctrl ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf( time_per_patient ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(max_patients_per_slab ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf( value12));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( value13));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf( clinic_type));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf( res_type));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(total_first_visits_blocked));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(total_other_visits_blocked));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(max_patients_per_day));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(p_o_ext_slot_status));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(p_o_reserved_slot_dtls));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(p_o_appt_slot_dtls));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(p_o_block_slot_dtls));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(p_o_break_slot_dtls));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(isSlotStartMidEndAppl));
            _bw.write(_wl_block135Bytes, _wl_block135);


}
else
{
            _bw.write(_wl_block136Bytes, _wl_block136);


}
	if (rs != null) rs.close();
	if (rs2 != null) rs2.close();
	if (stmt2 != null) stmt2.close();
	if (stmtsd != null) stmtsd.close();
	if (statement != null) statement.close();
	if (cstmt != null) cstmt.close();
	if (statement_bru != null) statement_bru.close();

}catch(Exception e) { 
	out.println("hre :" +e.toString());
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block137Bytes, _wl_block137);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contact.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.blocked.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
}
