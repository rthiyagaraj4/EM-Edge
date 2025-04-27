package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eBL.*;
import webbeans.op.CurrencyFormat;
import com.ehis.util.*;
import eOR.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blchargepatientpaneleditbody extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientPanelEditBody.jsp", 1709114465837L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script>\n\tvar cbflag=\"\";\n\tvar cbflag1=\"\";\n\tfunction check(i)\n\t{\n\t\tdocument.edit_enter_main.focussed_row.value=i;\n\t}\n\tfunction modify_remove_payer(i)\n\t{\t\n\t\tvar service=\"\";\n\t\tvar blng_serv_code=\"\";\n\t\tvar incl_excl=\"\";\n\t\tvar incl_excl_action=\"\";\n\t\tvar reason=\"\";\n\t\tvar reason_code=\"\";\n\t\tvar charge=\"\";\n\t\tvar original_qty=\"\";\n\t\tvar uom=\"\";\n\t\tvar uom_code=\"\";\n\t\tvar revise_qty=\"\";\n\t\tvar total_qty=\"\";\n\t\tvar rate=\"\";\n\t\tvar practioner_type=\"\";\n\t\tvar pract_id=\"\";\n\t\tvar practioner=\"\";\n\t\tvar total_pay=\"\";\n\t\tvar patient_pay=\"\";\n\t\tvar preappr=\"\";\n\t\tvar service1=\"\";\n\t\tvar blng_serv_code1=\"\";\n\t\tvar incl_excl1=\"\";\n\t\tvar incl_excl_action1=\"\";\n\t\tvar reason1=\"\";\n\t\tvar reason_code1=\"\";\n\t\tvar charge1=\"\";\n\t\tvar original_qty1=\"\";\n\t\tvar uom1=\"\";\n\t\tvar uom_code1=\"\";\n\t\tvar revise_qty1=\"\";\n\t\tvar total_qty1=\"\";\n\t\tvar rate1=\"\";\n\t\tvar practioner_type1=\"\";\n\t\tvar pract_id1=\"\";\n\t\tvar practioner1=\"\";\n\t\tvar total_pay1=\"\";\n\t\tvar patient_pay1=\"\";\n\t\tvar preappr_reqd=\"\";\n\t\tvar cbflag1=\"\"\n\t\tvar modify_qty_yn=\"\";\n\t\tvar modify_qty_yn1=\"\";\n\n\t\tvar totalRecords=document.forms[0].total_records.value;\n\t\tvar selected_row=i;\n\t\n\t\tfor(var j=0;j<totalRecords;j++)\n\t\t{\n\t\t\tservice1=eval(\"document.forms[0].service\"+j);\n\t\t\tif(service1.value==\"\") service=service+\"|\"+\" \";\n\t\t\telse service=service+\"|\"+service1.value;\n\n\t\t\tblng_serv_code1\t\t=eval(\"document.forms[0].blng_serv_code\"+j);\n\t\t\tif(blng_serv_code1.value==\"\") blng_serv_code=blng_serv_code+\"|\"+\" \";\n\t\t\telse blng_serv_code=blng_serv_code+\"|\"+blng_serv_code1.value;\n\n\t\t\tincl_excl1=eval(\"document.forms[0].incl_excl\"+j);\n\t\t\tif(incl_excl1.value==\"\") incl_excl=incl_excl+\"|\"+\" \";\n\t\t\telse incl_excl=incl_excl+\"|\"+incl_excl1.value;\t\t\n\t\t\n\t\t\tincl_excl_action1=eval(\"document.forms[0].incl_excl_action\"+j);\n\t\t\tif(incl_excl_action1.value==\"\") incl_excl_action=incl_excl_action+\"|\"+\" \";\n\t\t\telse incl_excl_action=incl_excl_action+\"|\"+incl_excl_action1.value;\n\t\t\n\t\t\treason1=eval(\"document.forms[0].reason\"+j);\n\t\t\tif(reason1.value==\"\") reason=reason+\"|\"+\" \";\n\t\t\telse reason=reason+\"|\"+reason1.value;\t\t\n\n\t\t\treason_code1=eval(\"document.forms[0].action_reason_code\"+j);\n\t\t\tif(reason_code1.value==\"\") reason_code=reason_code+\"|\"+\" \";\n\t\t\telse reason_code=reason_code1+\"|\"+reason_code1.value;\t\t\n\n\t\t\tcharge1=eval(\"document.forms[0].charge\"+j);\n\t\t\tif(charge1.value==\"\") charge=charge+\"|\"+\" \";\n\t\t\telse charge=charge+\"|\"+charge1.value;\t\t\n\t\t\n\t\t\toriginal_qty1=eval(\"document.forms[0].original_qty\"+j);\n\t\t\tif(original_qty1.value==\"\") original_qty=original_qty+\"|\"+\" \";\n\t\t\telse original_qty=original_qty+\"|\"+original_qty1.value;\t\t\n\n\t\t\tuom1=eval(\"document.forms[0].uom\"+j);\n\t\t\tif(uom1.value==\"\") uom=uom+\"|\"+\" \";\n\t\t\telse uom=uom+\"|\"+uom1.value;\t\t\n\n\t\t\tuom_code1=eval(\"document.forms[0].uom_code\"+j);\n\t\t\tif(uom_code1.value==\"\") uom_code=uom_code+\"|\"+\" \";\n\t\t\telse uom_code=uom_code+\"|\"+uom_code1.value;\t\n\n\t\t\trevise_qty1=eval(\"document.forms[0].revise_qty\"+j);\n\t\t\tif(revise_qty1.value==\"\") revise_qty=revise_qty+\"|\"+\" \";\n\t\t\telse revise_qty=revise_qty+\"|\"+revise_qty1.value;\n\t\t\n\t\t\ttotal_qty1=eval(\"document.forms[0].total_qty\"+j);\n\t\t\tif(total_qty1.value==\"\") total_qty=total_qty+\"|\"+\" \";\n\t\t\telse total_qty=total_qty+\"|\"+total_qty1.value;\n\t\t\n\t\t\trate1=eval(\"document.forms[0].rate\"+j);\n\t\t\tif(rate1.value==\"\") rate=rate+\"|\"+\" \";\n\t\t\telse rate=rate+\"|\"+rate1.value;\n\t\t\n\t\t\tpractioner_type1=eval(\"document.forms[0].practioner_type\"+j);\n\t\t\tif(practioner_type1.value==\"\") practioner_type=practioner_type+\"|\"+\" \";\n\t\t\telse practioner_type=practioner_type+\"|\"+practioner_type1.value;\n\n\t\t\tpract_id1=eval(\"document.forms[0].pract_id\"+j);\n\t\t\tif(pract_id1.value==\"\") pract_id=pract_id+\"|\"+\" \";\n\t\t\telse pract_id=pract_id+\"|\"+pract_id1.value;\n\t\t\n\t\t\tpractioner1=eval(\"document.forms[0].practioner\"+j);\n\t\t\tif(practioner1.value==\"\") practioner=practioner+\"|\"+\" \";\n\t\t\telse practioner=practioner+\"|\"+practioner1.value;\n\t\t\t\t\t\t\n\t\t\ttotal_pay1=eval(\"document.forms[0].total_pay\"+j);\n\t\t\tif(total_pay1.value==\"\") total_pay=total_pay+\"|\"+\" \";\n\t\t\telse total_pay=total_pay+\"|\"+total_pay1.value;\n\t\t\n\t\t\tpatient_pay1=eval(\"document.forms[0].patient_pay\"+j);\n\t\t\tif(patient_pay1.value==\"\") patient_pay=patient_pay+\"|\"+\" \";\n\t\t\telse patient_pay=patient_pay+\"|\"+patient_pay1.value;\t\n\n\t\t\tcbflag1=eval(\"document.forms[0].preappr_reqd\"+j);\n\t\t\t//if(cbflag1==\"\") cbflag=cbflag+\"|\"+\" \";\n\t\t\t//else cbflag=cbflag+\"|\"+cbflag1.checked;\t\n\n\t\t\tif(cbflag1.checked)\n\t\t\t{\n\t\t\t\tcbflag=cbflag+\"|\"+\"true\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tcbflag=cbflag+\"|\"+\"false\";\n\t\t\t}\n\t\t}\t\t\n\n\t\tuom=uom+\"|\";\t\n\n\t\tvar retVal\t\t\t= new String();\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"25\" ;\n\t\tvar dialogWidth = \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar title=encodeURIComponent(getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\"));\n\t\t//var getString=document.forms[0].queryString.value;\n    \tvar param = \"title=\"+title+\"&action=modify&service=\"+service+\"&incl_excl=\"+incl_excl+\"&incl_excl_action=\"+incl_excl_action+\"&reason=\"+reason+\"&charge=\"+charge+\"&original_qty=\"+original_qty+\"&revise_qty=\"+revise_qty+\"&total_qty=\"+total_qty+\"&rate=\"+rate+\"&practioner_type=\"+practioner_type+\"&practioner=\"+practioner+\"&total_pay=\"+total_pay+\"&patient_pay=\"+patient_pay+\"&selected_row=\"+selected_row+\"&total_records=\"+totalRecords+\"&uom=\"+uom+\"&cbflag=\"+cbflag;\n\t\talert(\'param->\'+param);\n\t\t//retVal=window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDetials2.jsp?\"+param,arguments,features);\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDetialsValidationFrame.jsp?\"+param,arguments,features);\n\t\tif(retVal!=null)\n\t\t{\t\n\t\t\tvar arr=new Array();\n\t\t\tvar delete_flag=\"\";\n\t\t\tif(retVal == null) retVal=\'\';\n\t\t\tif (retVal != null || retVal!=\"\")\n\t\t\t{\n\t\t\t\tvar retVal=unescape(retVal);\t\t\t\t\t  \n\t\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t\t{\n\t\t\t\t\tarr=retVal.split(\"::\");\t\n\t\t\t\t\tdelete_flag=arr[0];\n\t\t\t\t\tif(delete_flag==\"remove\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar totalRecords =document.forms[0].total_records.value;\n\t\t\t\t\t\tvar count =totalRecords - 1; \n\t\t\t\t\t\tdocument.forms[0].total_records.value=count;\n\t\t\t\t\t\t parent.frames[2].location.href=\'../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&\'+getString;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//alert(\"closed\");\n\t\t}\n\t}\n\n\tfunction selected(i)\n\t{\n\t\tvar total_records=document.forms[0].total_records.value;\n\t\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\n\t\tvar selected_row1=eval(\"document.forms[0].preappr_reqd\"+i);\t\t\n\t\tvar l_charge_yn=eval(\"document.forms[0].charged_yn\"+i);\t\t\n\t\t\n\t\t\n\t\tif(selected_row.checked==false)\n\t\t{\n\t\t\tselected_row.checked=false;\n\t\t\tdocument.edit_enter_main.checked_row.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tif(l_charge_yn.value!=\"Y\")\n\t\t\t{\t\t\t\n\t\t\t\n\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t\t{\n\t\t\t\t\tvar temp=eval(\"document.forms[0].selected_row\"+j);\n\t\t\t\t\ttemp.checked=false;\n\t\t\t\t\t//temp.value=\"false\";\n\t\t\t\t}\n\t\t\t\tselected_row.checked=true;\n\t\t\t\t//selected_row.value=\"true\";\n\t\t\t\tdocument.edit_enter_main.checked_row.value=i;\n\t\t\t}\n\t\t\telse{\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t\t{\n\t\t\t\t\tvar temp=eval(\"document.forms[0].selected_row\"+j);\n\t\t\t\t\ttemp.checked=false;\n\t\t\t\t\t//temp.value=\"false\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\talert(getMessage(\'BL9779\',\'BL\'));\n\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t}\n\t\t\n\t}\n\n\tfunction putdeci(object)\n\t{\n\t\tif(object.value!=\'\')\n\t\t{\n\t\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\t\tputDecimal(object,17,decimal);\n\t\t}\n\t}\n\n\tfunction totpayable()\n\t{\n\t\t\n\t\tvar totalpayable=0.00;\n\t\tvar patientpayable=0.00;\n\t\tvar patientpaid=0.00;\n\t\tvar totpayable=\"\";\n\t\tvar patpayable=\"\";\n\t\tvar patpaid=\"\";\n\t\tvar a1=new Array();var a2=new Array();var a3=new Array();\n\t\tvar formObj = parent.query2.document.edit_enter_main;\n\t\tvar\ttotalRecords =eval(formObj.total_records.value);\t\n\t\tfor(var i=0;i<totalRecords;i++)\n\t\t{\n\t\t  totpayable=eval(\"document.forms[0].total_pay\"+i);\n\t\t  patpayable=eval(\"document.forms[0].patient_pay\"+i);\n\t\t  patpaid=eval(\"document.forms[0].patient_paid\"+i);\n\t  \n\t\t  a1[i]=totpayable.value;\n\t\t  if(a1[i]==\"\") a1[i]=\"0.0\";\n\t\t  totalpayable=parseFloat(totalpayable) + parseFloat(a1[i]);\n\t\n\t\t  a2[i]=patpayable.value;\n\t\t  if(a2[i]==\"\") a2[i]=\"0.0\";\n\t\t  patientpayable=parseFloat(patientpayable) + parseFloat(a2[i]);\n\n\t\t  a3[i]=patpaid.value;\n\t\t  if(a3[i]==\"\") a3[i]=\"0.0\";\n\t\t  patientpaid=parseFloat(patientpaid) + parseFloat(a3[i]);\n\t  \n\t\t}\n\t\tparent.frames[3].document.forms[0].total.value=totalpayable;\t\n\t\tvar totp=eval(\"parent.frames[3].document.forms[0].total\")\n\t\tputdeci(totp);\n\t\t//alert(\"totp\"+totp.value)\n\t\tparent.frames[3].document.forms[0].patient.value=patientpayable;\t\n\t\tvar patp=eval(\"parent.frames[3].document.forms[0].patient\")\n\t\tputdeci(patp);\t\t\n\t\t//document.forms[0].total_pay_panel.value=totalpayable;\n\t\t//document.forms[0].patient_pay_panel.value=patientpayable;\n\n\t\tparent.frames[3].document.forms[0].patient_paid.value=patientpaid;\t\n\t\tvar patpd=eval(\"parent.frames[3].document.forms[0].patient_paid\");\n\t\tputdeci(patpd);\n\n\t\tsetTimeout(\'totpayable()\',1000);\n\t}\n\tfunction check_box(i)\n\t{\n\t\tvar preappr_reqd=eval(\"document.forms[0].preappr_reqd\"+i);\n\n\t\tif(preappr_reqd.value==\"checked\")\n\t\t{\n\t\t\tpreappr_reqd.checked=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tpreappr_reqd.checked=false;\n\t\t}\n\t}\n\n</script>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t</head>\n\n<body onLoad=\'\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'edit_enter_main\' id=\'edit_enter_main\' method=\'post\' >\n\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\' id=\'ins_data\' border=\'1\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<tr id=row";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">\n\t<td class=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" width=\'9%\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' id=\'selected_row";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onClick=\"selected(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\"></td>\n\t<!--<td class=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" width=\'5%\'><a onClick=\"modify_remove_payer(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =");\"><u>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</u></a></td>-->\n\t<td class=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" width=\'10%\' ><input type=\'text\' name=\'service";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'service";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' size=\'10\' readonly maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ><input type=hidden name=\'blng_serv_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'blng_serv_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></td>\n  \t<td class=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" width=\'18%\' ><input type=\'text\' name=\'incl_excl";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'incl_excl";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' size=\'10\' readonly maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ></td>\n\t<td class=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" width=\'18%\' ><input type=\'text\' name=\'incl_excl_action";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'incl_excl_action";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" width=\'15%\' ><input type=\'text\' name=\'reason";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'reason";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ><input type=hidden name=\'action_reason_code";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'action_reason_code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ></td>\n\t<td class=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\'5%\' ><input type=\'text\' name=\'ratecharge_desc";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'ratecharge_desc";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' size=\'10\' readonly maxlength=\'5\'  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'charge";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'charge";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" ></td>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\n  \t<td class=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" width=\'15%\' ><input type=\'text\' name=\'original_qty";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'original_qty";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' size=\'10\' readonly maxlength=\'7\'  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" style=\'text-align:right\'><input type=hidden name=\'modify_qty_yn";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'modify_qty_yn";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" width=\'10%\' ><input type=\'text\' name=\'uom";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'uom";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' size=\'4\' readonly maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" ><input type=hidden name=\'uom_code";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'uom_code";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" width=\'20%\' ><input type=\'text\' name=\'revise_qty";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'revise_qty";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\'text-align:right\'></td>\n\t<td class=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" width=\'4%\' ><input type=\'text\' name=\'total_qty";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'total_qty";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" style=\'text-align:right\'></td>\n</tr>\n<tr>\n\t<td class=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" width=\'9%\' ></td>\n\t<td class=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" width=\'10%\' ><input type=\'text\' name=\'rate";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'rate";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' size=\'14\' readonly maxlength=\'10\'  value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" width=\'18%\' ><input type=\'text\' name=\'practioner_type";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'practioner_type";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' size=\'10\' readonly maxlength=\'30\'  value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' ><input type=hidden name=\'pract_id";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'pract_id";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" width=\'18%\' ><input type=\'text\' name=\'practioner";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'practioner";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" ><input type=hidden name=\'pract_staff_id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'pract_staff_id";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"></td>\n\t<td class=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" width=\'15%\' ><input type=\'text\' name=\'total_pay";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'total_pay";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' size=\'14\' readonly maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" width=\'5%\'><input type=\'text\' name=\'patient_pay";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'patient_pay";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" width=\'15%\'><input type=\'text\' name=\'patient_paid";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'patient_paid";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" width=\'10%\'><input type=\'checkbox\' name=\'preappr_reqd";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'preappr_reqd";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' size=\'10\'  maxlength=\'30\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" onclick=\'check_box(";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =")\'></td>\n\t<input type=\'hidden\' name=\'charged_yn";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'charged_yn";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t<input type=\'hidden\' name=\'override_allowed_yn";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' id=\'override_allowed_yn";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t<input type=\'hidden\' name=\'serv_amt_changed";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' id=\'serv_amt_changed";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t<input type=\'hidden\' name=\'excl_incl_ind_for_screen";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'excl_incl_ind_for_screen";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t<td colspan=2 class=";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">&nbsp;</td>\n</tr>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar strErrorMessage = \'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\t\talert(strErrorMessage);\n\t\t\t\t\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t\t\t\t   <script>\n\t\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\',\'BL\'));\n\t\t\t\t\t\t\t\t\t\t\t\t   </script>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar strErrorMessage = \'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\';\n\t\t\t\t\t\t\t\talert(strErrorMessage);\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t   <script>\n\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\',\'BL\'));\n\t\t\t\t\t\t\t   </script>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =")\"></td>\t\n\t<!--<td class=";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' size=\'10\' readonly maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' size=\'10\' readonly maxlength=\'15\'  value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" ><input type=\'hidden\' name=\'charge";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" ></td>\n\n\n\t<td class=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' size=\'10\' readonly maxlength=\'7\'  value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' style=\'text-align:right\'><input type=hidden name=\'modify_qty_yn";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' ></td>\n\n\t<td class=";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' size=\'4\' readonly maxlength=\'30\'  value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' ><input type=hidden name=\'uom_code";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' size=\'10\' readonly maxlength=\'10\'  value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" style=\'text-align:right\' onfocus=\'putdeci(this);\'></td>\n\t<td class=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" ><input type=hidden name=\'pract_id";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' ></td>\n  \t<td class=";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" style=\'text-align:right\'  onfocus=\'putdeci(this);\'></td>\n\t<td class=";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' size=\'10\'  maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'  ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" readonly\tonclick=\'check_box(";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\n<!--\t<td class=";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" width=\'20%\'><input type=\'text\' name=\'net_amt";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' id=\'net_amt";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" style=\'text-align:right\'  onfocus=\'putdeci(this);\'></td></td>-->\n\n\t<input type=\'hidden\' name=\'serv_amt_changed";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' value=\"\">\n\n\n\n\n\t<td class=";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" width=\'20%\'></td>\n\t<td class=";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =" width=\'4%\'></td>\n</tr>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\talert(getMessage(\"BL9758\",\"BL\"));\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"BL9758\",\"BL\"));\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n</table>\n<!-- Added by karthik on Oct-18-2012 to default select a practitioner -->\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n<input type=\'hidden\' name=\'session_practitioner\' id=\'session_practitioner\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n<input type=\'hidden\' name=\'session_staff_ind\' id=\'session_staff_ind\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n<input type=\'hidden\' name=\'session_staff_id\' id=\'session_staff_id\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n<input type=\'hidden\' name=\'focussed_row\' id=\'focussed_row\' value=\'\' >\n<input type=\'hidden\' name=\'i\' id=\'i\' value=\'\' >\n<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'\' >\n<input type=\'hidden\' name=\'action_reason_code\' id=\'action_reason_code\' value=\'\' >\n<input type=\'hidden\' name=\'pract_staff_type_ind\' id=\'pract_staff_type_ind\' value=\'\' >\n<input type=\'hidden\' name=\'pract_staff_type_code\' id=\'pract_staff_type_code\' value=\'\' >\n<input type=\'hidden\' name=\'blng_serv_code\' id=\'blng_serv_code\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" >\n<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'\' >\n<input type=\'hidden\' name=\'p_service_panel_ind\' id=\'p_service_panel_ind\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" >\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n<input type=\'hidden\' name=\'panel_code\' id=\'panel_code\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' >\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\n<input type=\'hidden\' name=\'cflag\' id=\'cflag\' value=\'\' >\n<input type=\'hidden\' name=\'str\' id=\'str\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" >\n<input type=\'hidden\' name=\'p_string\' id=\'p_string\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" >\n<input type=\'hidden\' name=\'added_serv_yn\' id=\'added_serv_yn\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" >\n<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" >\n<input type=\'hidden\' name=\'total_pay_panel\' id=\'total_pay_panel\' value=\'\' >\n<input type=\'hidden\' name=\'patient_pay_panel\' id=\'patient_pay_panel\' value=\'\'>\n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" >\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" >\n<input type=\'hidden\' name=\'acc_seq_no\' id=\'acc_seq_no\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" >\n<input type=\'hidden\' name=\'rate_label\' id=\'rate_label\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" >\n<input type=\'hidden\' name=\'charge_label\' id=\'charge_label\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" >\n<input type=\'hidden\' name=\'include_label\' id=\'include_label\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" >\n<input type=\'hidden\' name=\'exclude_label\' id=\'exclude_label\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" >\n<input type=\'hidden\' name=\'panel_qty\' id=\'panel_qty\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" >\n\n<input type=\'hidden\' name=\'str_epi_type_clinic_code\' id=\'str_epi_type_clinic_code\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" >\n\n\n</form>\n</body>\n<script>\n//\tvar query_string=document.forms[0].query_string.value;\n\t//var include_label=document.forms[0].include_label.value;\t\n\t//var exclude_label=document.forms[0].exclude_label.value;\n\t//var rate_label=document.forms[0].rate_label.value;\n\t//var charge_label=document.forms[0].charge_label.value;\t\n\n\t\n\tparent.frames[3].location.href=\"../../eBL/jsp/BLEnterEditChargeDetailsBtn.jsp?";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\";\t\t\t//parent.frames[3].location.href=\"../../eBL/jsp/BLEnterEditChargeDetials4.jsp?include_label=\"+include_label+\"&exclude_label=\"+exclude_label+\"&rate_label=\"+rate_label+\"&charge_label=\"+charge_label+\"&\"+query_string;\t\n\t\n</script>\n\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	/*Added by karthik on Oct-18-2012 to default select a practitioner*/
    String session_pract=request.getParameter("set_session_practitioner");
	if(session_pract==null) session_pract="";
    String session_pract_staff_ind=request.getParameter("set_session_pract_staff_ind");
	if(session_pract_staff_ind==null) session_pract_staff_ind="";
    String session_pract_staff_id=request.getParameter("set_session_pract_staff_id");
	if(session_pract_staff_id==null) session_pract_staff_id="";
	session.setAttribute("sessionPractitioner",session_pract);
	session.setAttribute("sessionStaffInd",session_pract_staff_ind);
	session.setAttribute("sessionStaffId",session_pract_staff_id);

	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rscurr=null;
	ResultSet rsserv_desc=null;	ResultSet rsreson_desc=null; ResultSet rsuomdesc=null;
	ResultSet rspractname=null;	ResultSet rsserv_qty=null;
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
		
	//String sql1=""; String sql2=""; String sql3=""; String sql_chr_det=""; 	
	String locale	= (String)session.getAttribute("LOCALE");
	ArrayList a1=new ArrayList();ArrayList a2=new ArrayList();ArrayList a3=new ArrayList();ArrayList a4=new ArrayList();ArrayList a5=new ArrayList();ArrayList a6=new ArrayList();ArrayList a7=new ArrayList();
	ArrayList a8=new ArrayList();ArrayList a9=new ArrayList();ArrayList a10=new ArrayList();ArrayList a11=new ArrayList();ArrayList a12=new ArrayList();ArrayList a13=new ArrayList();ArrayList a14=new ArrayList();
	ArrayList a15=new ArrayList();	//ArrayList temp=new ArrayList();
	ArrayList a16=new ArrayList();
	ArrayList a17=new ArrayList();ArrayList a18=new ArrayList();ArrayList a19=new ArrayList();ArrayList a20=new ArrayList();ArrayList a21=new ArrayList();ArrayList a22=new ArrayList(); ArrayList a23=new ArrayList();ArrayList a24=new ArrayList();ArrayList a25=new ArrayList();ArrayList a26=new ArrayList();ArrayList a27=new ArrayList();
	int totalRecords=0;int noofdecimal = 2;//long p_episode_id=0; int p_visit_id=0;
	//long p_encounter_id=0;
	String str_encounter_id="";
	String remove_check="";	String  str_acct_seq_no=""; 
	String p_facility_id="";String p_login_user="";	String p_episode_type="";
	String p_patient_id=""; String strp_episode_id=""; 	String strp_visit_id="";
	String p_service_date="";  String p_service_panel_ind=""; 	String p_service_panel_code="";
	//String readonly="";
	String str="";String p_string="";String added_serv_yn ="";	
	String p_module_id="";String include_label="";String exclude_label=""; String query_string="";
	String rate_label="";String charge_label="";String p_order_id=""; String p_order_line_no="";
	String p_string1 ="",p_override_yn="";
	String blng_grp_id="",cust_group_code="",cust_code="",policy_type_code="",policy_priority="",policy_no="",policy_start_date="",policy_exp_date="";
	String credit_auth_ref="",credit_auth_date="",policy_eff_from_date="",policy_eff_to_date="",approved_amt="",approved_days="";
	String non_ins_blng_grp_id="",non_ins_cust_group_code="",non_ins_cust_code="",user_id="",ws_num="";	
	String clinic_code="";String str_epi_type_clinic_code="";
	String panel_qty ="",panel_qty_for_hidden="";
	double serv_qty=0.0;
							double db_panel_qty =0.0;

	String p_order_item="";
	String str_or_bean_id=""; // Added for BL_OR Enhancement
	String str_or_key ="",str_or_key_line_no="";
	HashMap bill_dtls_frm_or_bean = null;
	String p_ordering_facility_id ="";//--[IN034785]

	CurrencyFormat cf = new CurrencyFormat();
	HashMap hm_string=null;
	
	/****ghl-crf-1.2*************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	String bean_name_bl="";
	HashMap finDtls		= new HashMap();
	/******end*******************/
	
	String str_null="";

	try
	{
		try
		{
			con	=	ConnectionManager.getConnection(request);
			query_string=request.getQueryString();


			panel_qty = request.getParameter("panel_qty");
			if(panel_qty==null || panel_qty.equals("")) panel_qty="1";
			panel_qty_for_hidden=panel_qty;
			

			p_facility_id = (String)httpSession.getValue("facility_id");
			if(p_facility_id==null) p_facility_id="";
		
			p_login_user =  p.getProperty("login_user");
			if(p_login_user==null) p_login_user="";
		 

			p_episode_type = request.getParameter("episode_type");
			if(p_episode_type==null) p_episode_type="";

			p_patient_id = request.getParameter("patient_id");
			if(p_patient_id==null) p_patient_id="";
	
			strp_visit_id = request.getParameter("visit_id");
			if(strp_visit_id==null || strp_visit_id.equals("")) strp_visit_id="0";
//			p_visit_id=Integer.parseInt(strp_visit_id);	
	
			strp_episode_id = request.getParameter("episode_id");
			if(strp_episode_id==null || strp_episode_id.equals("")) strp_episode_id="0";
//			p_episode_id=Long.parseLong(strp_episode_id);	

			p_service_date = request.getParameter("service_date");		
			if(p_service_date==null) p_service_date="";
			//p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS","en",locale);		

			p_service_panel_ind = request.getParameter("service_panel_ind");
			if(p_service_panel_ind==null) p_service_panel_ind="";

			p_service_panel_code = request.getParameter("service_panel_code");
			if(p_service_panel_code==null) p_service_panel_code="";

			p_module_id=request.getParameter("module_id");	
			if(p_module_id==null) p_module_id="";

			str_encounter_id=request.getParameter("encounter_id");
			if(str_encounter_id==null || str_encounter_id.equals("") || str_encounter_id.equals("null")) str_encounter_id="";
//			p_encounter_id=Long.parseLong(str_encounter_id);	

			str_acct_seq_no=request.getParameter("acct_seq_no");
			if(str_acct_seq_no==null || str_acct_seq_no.equals("")) str_acct_seq_no="";

			p_order_id = request.getParameter("order_id");
			if(p_order_id==null || p_order_id.equals("")) p_order_id="";	

			p_order_line_no= request.getParameter("order_line_no");
			if(p_order_line_no==null || p_order_line_no.equals("")) p_order_line_no="";

			p_order_item=request.getParameter("order_catalog_code");
			if(p_order_item==null) p_order_item="";

			clinic_code=request.getParameter("clinic_code");
			if(clinic_code==null) clinic_code="";
			//--[IN034785] - Start
			p_ordering_facility_id=request.getParameter("ord_facility");
			if((p_ordering_facility_id==null || p_ordering_facility_id.equals("")))
			{			
				p_facility_id = (String)httpSession.getValue("facility_id");
			}	
			else
			{
				p_facility_id= p_ordering_facility_id;
			}
			//--[IN034785] - End

			str_epi_type_clinic_code=p_episode_type+"#"+clinic_code;
			if(str_epi_type_clinic_code==null) str_epi_type_clinic_code="";

			include_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Include.label","common_labels");
			if(include_label==null || include_label.equals("")) include_label="";		

			exclude_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Exclude.label","common_labels");
			if(exclude_label==null || exclude_label.equals("")) exclude_label="";		

			rate_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.RATE.label","bl_labels");
			if(rate_label==null || rate_label.equals("")) rate_label="";		

			charge_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Charge.label","common_labels");
			if(charge_label==null || charge_label.equals("")) charge_label="";		

			//p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS",locale,"en");

			/*********************ADDED BR RAM FOR GHL-CRF-1.2**********************************/
			calledfrmencYN=request.getParameter("patregnchargeYN");
			if(calledfrmencYN==null) calledfrmencYN="N";
			
			/******************************END**************************************************/
		}
		catch(Exception eX1)
		{	
			out.println("Error= "+eX1);
		}
		/***************Added by ram ghl-crf-1.2***************/
		if(calledfrmencYN.equals("Y") && p_module_id.equals("MP"))
		{
			clinic_code="";
			bean_id_bl=request.getParameter("bean_id");
			if(bean_id_bl==null) bean_id_bl="";
			bean_name_bl=request.getParameter("bean_name");
			if(bean_name_bl==null) bean_name_bl="";
			BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id_bl, bean_name_bl, request ) ;
			if(bean!=null)
			{
				String panel_str_frm_bl = (String) bean.getPanelString(); 
				p_string1=panel_str_frm_bl;
			}
			

		}
		/*****************End**********************************/
		
		else if(p_module_id.equals("OP") || p_module_id.equals("AE") || (p_module_id.equals("MP") && calledfrmencYN.equals("N")))
		{
			hm_string=(HashMap)session.getAttribute("BlChargeRecord");
		
			if(hm_string!=null)
			{
				p_string1 =(String)hm_string.get("panel_str");
				if(p_string1==null || p_string1.equals(""))
				{
					p_string1="";	
				}
				else
				{
					//p_string1=p_string1.trim();
				}
			}
		}
		else if(p_module_id.equals("BL"))
		{
/*

			str_or_bean_id=request.getParameter("bean_id");
			if(str_or_bean_id==null) str_or_bean_id="";
			System.out.println("str_or_bean_id in Body:"+str_or_bean_id);

			str_or_key=request.getParameter("key");
			if(str_or_key==null) str_or_key="";

			str_or_key_line_no=request.getParameter("key_line_no");
			if(str_or_key_line_no==null) str_or_key_line_no="";
			
			if(!(str_or_key.equals("") && str_or_key_line_no.equals("")))
			{
				str_or_key=str_or_key+str_or_key_line_no;
			}
			
			BLEnterServiceRequestBean ServPanlBean			= (BLEnterServiceRequestBean)getBeanObject( str_or_bean_id, "eBL.BLEnterServiceRequestBean", request ) ;

			bill_dtls_frm_or_bean=(HashMap)ServPanlBean.getSelectedServPanlDtls(str_or_key);

			if(bill_dtls_frm_or_bean!=null)
			{
				String panel_str_frm_or = (String) bill_dtls_frm_or_bean.get("bl_panel_str"); 
				p_string1=panel_str_frm_or;
			}
*/
		} 
		
		else
		{
			//The bean concept has to be incorporated for modules like OR/OT/PH
			str_or_bean_id=request.getParameter("bean_id");
			if(str_or_bean_id==null) str_or_bean_id="";

			str_or_key=request.getParameter("key");
			if(str_or_key==null) str_or_key="";

			str_or_key_line_no=request.getParameter("key_line_no");
			if(str_or_key_line_no==null) str_or_key_line_no="";
			
			if(!(str_or_key.equals("") && str_or_key_line_no.equals("")))
			{
				str_or_key=str_or_key+str_or_key_line_no;
			}
			
			OrderEntryBillingQueryBean orderEntryBillBean =null;

			if(!str_or_bean_id.equals(""))
			{
				// Added the new If...Else Loop for the Future Order Purpose as on 30th August'07 by Manivel
				if(str_or_bean_id.equals("Or_FutureOrder"))
				{
					FutureOrder beanObj  = (FutureOrder )getBeanObject(str_or_bean_id,"eOR.FutureOrder",request);
                    orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) beanObj.getOrderEntryBillBean();
				}
				else
				{
					OrderEntryBean beanObj  = (OrderEntryBean)getBeanObject(str_or_bean_id,"eOR.OrderEntryBean",request);
                    orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) beanObj.getOrderEntryBillBean();
				}
			}
			else
			{
				orderEntryBillBean = (OrderEntryBillingQueryBean)getBeanObject( "Or_billingQueryBean", "eOR.OrderEntryBillingQueryBean", request ) ;
			}

			bill_dtls_frm_or_bean=(HashMap)orderEntryBillBean.getOrderBillDtls(str_or_key);

			if(bill_dtls_frm_or_bean!=null)
			{
				String panel_str_frm_or = (String) bill_dtls_frm_or_bean.get("bl_panel_str"); 
				p_string1=panel_str_frm_or;
//				System.out.println("Panel String from OR Bean:"+p_string1);
			}
		} 
		/***************Added by ram ghl-crf-1.2  if else***************/
		if(calledfrmencYN.equals("Y") && p_module_id.equals("MP"))
		{
			BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id_bl, bean_name_bl, request ) ;
			finDtls = (HashMap)bean.getFinDtls();

			blng_grp_id=(String)finDtls.get("blng_grp_id");
			if(blng_grp_id==null)	blng_grp_id=""; 	

			cust_group_code=(String)finDtls.get("str_cust_group_code");
			if(cust_group_code==null)	cust_group_code=""; 

			cust_code=(String)finDtls.get("str_cust_code");
			if(cust_code==null)	cust_code=""; 
		
			policy_type_code=(String)finDtls.get("str_policy_type_code");
			if(policy_type_code==null) policy_type_code=""; 
		
			policy_priority=(String)finDtls.get("str_priority");
			if(policy_priority==null) policy_priority=""; 
		
			policy_no=(String)finDtls.get("str_policy_number");
			if(policy_no==null)	policy_no=""; 	

			policy_start_date=(String)finDtls.get("str_policy_start_date");
			if(policy_start_date==null)	policy_start_date=""; 

			policy_exp_date=(String)finDtls.get("str_policy_expiry_date");
			if(policy_exp_date==null)policy_exp_date=""; 	

			credit_auth_ref=(String)finDtls.get("str_credit_auth_ref");
			if(credit_auth_ref==null) credit_auth_ref=""; 	

			credit_auth_date=(String)finDtls.get("str_credit_auth_date");
			if(credit_auth_date==null) credit_auth_date=""; 	
	
			policy_eff_from_date=(String)finDtls.get("str_effective_from");
			if(policy_eff_from_date==null)	policy_eff_from_date=""; 	

			policy_eff_to_date=(String)finDtls.get("str_effective_to");
			if(policy_eff_to_date==null) policy_eff_to_date=""; 

			approved_amt=(String)finDtls.get("str_approved_amt");
			if(approved_amt==null) approved_amt=""; 	
	
			approved_days=(String)finDtls.get("str_approved_days");
			if(approved_days==null)	approved_days=""; 	

			non_ins_blng_grp_id=(String)finDtls.get("non_ins_blng_grp_id");
			if(non_ins_blng_grp_id==null) non_ins_blng_grp_id=""; 	

			non_ins_cust_group_code=(String)finDtls.get("non_ins_cust_group_code");
			if(non_ins_cust_group_code==null)	non_ins_cust_group_code=""; 	

			non_ins_cust_code=(String)finDtls.get("non_ins_cust_code");
			if(non_ins_cust_code==null)	non_ins_cust_code=""; 

		}else{
				HashMap fin_dtls_bef_reg=(HashMap)session.getAttribute("fin_dtls_to_chrg_dtls");
				if(!(fin_dtls_bef_reg==null))
				{	
					blng_grp_id=(String)fin_dtls_bef_reg.get("billing_group");
					if(blng_grp_id==null)	blng_grp_id=""; 	

					cust_group_code=(String)fin_dtls_bef_reg.get("cust_group_code");
					if(cust_group_code==null)	cust_group_code=""; 

					cust_code=(String)fin_dtls_bef_reg.get("cust_code");
					if(cust_code==null)	cust_code=""; 
				
					policy_type_code=(String)fin_dtls_bef_reg.get("policy_type_code");
					if(policy_type_code==null) policy_type_code=""; 
				
					policy_priority=(String)fin_dtls_bef_reg.get("policy_priority");
					if(policy_priority==null) policy_priority=""; 
				
					policy_no=(String)fin_dtls_bef_reg.get("policy_no");
					if(policy_no==null)	policy_no=""; 	

					policy_start_date=(String)fin_dtls_bef_reg.get("policy_start_date");
					if(policy_start_date==null)	policy_start_date=""; 

					policy_exp_date=(String)fin_dtls_bef_reg.get("policy_exp_date");
					if(policy_exp_date==null)policy_exp_date=""; 	

					credit_auth_ref=(String)fin_dtls_bef_reg.get("credit_auth_ref");
					if(credit_auth_ref==null) credit_auth_ref=""; 	

					credit_auth_date=(String)fin_dtls_bef_reg.get("credit_auth_date");
					if(credit_auth_date==null) credit_auth_date=""; 	
			
					policy_eff_from_date=(String)fin_dtls_bef_reg.get("policy_eff_from_date");
					if(policy_eff_from_date==null)	policy_eff_from_date=""; 	

					policy_eff_to_date=(String)fin_dtls_bef_reg.get("policy_eff_to_date");
					if(policy_eff_to_date==null) policy_eff_to_date=""; 

					approved_amt=(String)fin_dtls_bef_reg.get("approved_amt");
					if(approved_amt==null) approved_amt=""; 	
			
					approved_days=(String)fin_dtls_bef_reg.get("approved_days");
					if(approved_days==null)	approved_days=""; 	

					non_ins_blng_grp_id=(String)fin_dtls_bef_reg.get("non_ins_blng_grp_id");
					if(non_ins_blng_grp_id==null) non_ins_blng_grp_id=""; 	

					non_ins_cust_group_code=(String)fin_dtls_bef_reg.get("non_ins_cust_group_code");
					if(non_ins_cust_group_code==null)	non_ins_cust_group_code=""; 	

					non_ins_cust_code=(String)fin_dtls_bef_reg.get("non_ins_cust_code");
					if(non_ins_cust_code==null)	non_ins_cust_code=""; 	
			
					user_id=(String)fin_dtls_bef_reg.get("user_id");
					if(user_id==null) user_id=""; 
				}
		}
		try
		{
			remove_check=request.getParameter("remove_check");

			if(remove_check==null) remove_check="";
			String checked_row="";
			String record_count="";
			int total_records=0;
			int selected_index=0;		
			//String fwd_payer_desc="";
			
			if(checked_row==null) checked_row="";
			if(remove_check.equals("remove"))
			{
				record_count=request.getParameter("total_records");
				if(record_count==null) record_count="";
				total_records=Integer.parseInt(record_count);							
				checked_row=request.getParameter("checked_row");
				if(checked_row==null) checked_row="";
				selected_index=Integer.parseInt(checked_row);
				
				for(int i=0;i<total_records;i++)
				{
					
					if(!(i==selected_index))
					{	try{

					String temp1=request.getParameter("service"+i);
					a1.add(temp1);						
					temp1=request.getParameter("blng_serv_code"+i);
					a2.add(temp1);					
					temp1=request.getParameter("incl_excl"+i);
					a3.add(temp1);								
					temp1=request.getParameter("incl_excl_action"+i);
					a4.add(temp1);					
					temp1=request.getParameter("reason"+i);
					a5.add(temp1);					
					temp1=request.getParameter("action_reason_code"+i);
					a6.add(temp1);				
					temp1=request.getParameter("charge"+i);
					a7.add(temp1);					
					temp1=request.getParameter("original_qty"+i);
					a8.add(temp1);
					temp1=request.getParameter("modify_qty_yn"+i);
					a9.add(temp1);
					temp1=request.getParameter("uom"+i);
					a10.add(temp1);
					temp1=request.getParameter("uom_code"+i);
					a11.add(temp1);
					temp1=request.getParameter("revise_qty"+i);
					a12.add(temp1);
					temp1=request.getParameter("total_qty"+i);
					a13.add(temp1);
					temp1=request.getParameter("rate"+i);
					a14.add(temp1);					
					temp1=request.getParameter("practioner_type"+i);
					a15.add(temp1);
					temp1=request.getParameter("pract_id"+i);
					a16.add(temp1);
					temp1=request.getParameter("practioner"+i);
					a17.add(temp1);					
					temp1=request.getParameter("total_pay"+i);
					a18.add(temp1);
					temp1=request.getParameter("patient_pay"+i);
					a19.add(temp1);
					temp1=request.getParameter("patient_paid"+i);
					a20.add(temp1);
					temp1=request.getParameter("preappr_reqd"+i);
					a21.add(temp1);
					/*temp1=request.getParameter("kkk");
					a20.add(i,temp1);				
					System.out.println(" cbflag11 rem "+ a20);
					*/
					temp1=request.getParameter("pract_staff_id"+i);
					a22.add(temp1);	
					temp1=request.getParameter("ratecharge_desc"+i);
					a23.add(temp1);
					temp1=request.getParameter("charged_yn"+i);
					a24.add(temp1);

					temp1=request.getParameter("override_allowed_yn"+i);					
					a25.add(temp1);					

					temp1=request.getParameter("serv_amt_changed"+i);					
					a26.add(temp1);					

					temp1=request.getParameter("excl_incl_ind_for_screen"+i);					
					a27.add(temp1);					

					}catch(Exception e){System.out.println("Exception in :"+e);}
				}
				}		
				
			}		
		}
		catch(Exception eX)
		{	
			out.println("Error1= "+eX);
		}

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//l_rec_val="",l_qty="0.0"d_pat_gross_charge_amt=0,
		String l_servicecode="",l_ratecharge="", l_exclincl="",l_reason="", l_practstaff="", l_practstaff_desc="",l_practstaffid=""; String l_uom="",l_incl_excl="",l_serv_qty="",l_preapp_yn="",l_chargeamt="",l_chargeamt_screen="";
		String str_day_type_code="",str_day_type_disc="",str_time_type_code="",str_time_type_desc="",str_credit_auth_ref="";
		String str_excl_incl_ind="",str_preapp_yn="",d_split_ind="",modify_qty_yn="",classval="";	
		String d_net_charge_amt_temp="",d_cust_net_charge_amt_temp="",d_pat_payable_temp="",d_pat_paid_amt_temp="0.00";
		String ratecharge_desc="",str_charged_yn="", str_pat_billed_yn="";
		String str_err_code="",str_sys_message_id="",str_error_text="";
		String str_override_allowed_yn="";String test_var="",str_base_qty="",str_base_rate="";

		double d_addl_factor=0,d_base_chargeamt=0; //d_base_qty=0, d_base_rate=0
		double d_gross_charge_amt=0,d_disc_amt=0, d_net_charge_amt=0,d_disc_perc=0;
		double d_pat_disc_amt=0,d_pat_net_charge_amt=0;
		double d_cust_gross_charge_amt=0, d_cust_disc_amt=0,d_cust_net_charge_amt=0;
		double d_curr_availed=0, d_pat_paid_amt=0.00,d_pat_payable=0,record_select=0,num1=0,num2=0; 
		
	


		try
		{
			if(remove_check.equals("remove"))
			{
				p_string=request.getParameter("p_string");

				if(p_string==null) p_string="";
				totalRecords=a1.size();
				record_select=1;
				for(int i=0;i<totalRecords;i++)
				{	
					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(record_select));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(a1.get(i)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a2.get(i)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(a3.get(i)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(a4.get(i)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(a5.get(i)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(a6.get(i)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(a23.get(i)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(a7.get(i)));
            _bw.write(_wl_block41Bytes, _wl_block41);

		System.out.println("modify_qty_yn in Body.jsp::::: "+modify_qty_yn);
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(a8.get(i)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(a9.get(i)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(a10.get(i)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a11.get(i)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(a12.get(i)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(a13.get(i)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(a14.get(i)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(a15.get(i)));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a16.get(i)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(a17.get(i)));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a22.get(i)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(a18.get(i)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(a19.get(i)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(a20.get(i)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(a21.get(i)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(a21.get(i)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a24.get(i)));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a25.get(i)));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a26.get(i)));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a27.get(i)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block94Bytes, _wl_block94);

		System.err.println("a25.get(i):"+a25.get(i));
					record_select++;
				}//for loop		 
			}//if remove check
			else
			{
			  String delimit="<NR>";
			  p_string1 = request.getParameter("p_str");
			  String serv_str=p_string1.replaceAll(delimit,"|");
			  if(serv_str==null) serv_str="";
			  int t1=serv_str.indexOf("|");
			  if(t1!=-1)
			  {
				if(!serv_str.equals("")) 
				{
					try
					{		
						pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
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
						System.out.println("3="+e.toString());
					}
					String serv_description="";
					String reason_description="";
					String uom_description="";
					String pract_name="";
					int i=0;	
					totalRecords=0;
					record_select=0;
					String p_serv_panel_temp="";
					int t=serv_str.indexOf("|");
					if(t!=-1)
					{
						p_string = serv_str.substring(0,t);
						p_serv_panel_temp=serv_str.substring(t);
					}
					else
					{
						p_serv_panel_temp=serv_str;
					}
				
					StringTokenizer st = new StringTokenizer(p_serv_panel_temp,"|");
					int count = 0;	
					
					while(st.hasMoreTokens())
					{
						count++;			
						String string1 = st.nextToken();		
						StringTokenizer st1 = new StringTokenizer(string1,"#");				
						while(st1.hasMoreTokens())
						{
							l_servicecode = st1.nextToken();
							System.err.println("l_servicecode :"+l_servicecode);
							if(l_servicecode.equals(" ")) l_servicecode="";
							try
							{
								pstmt = con.prepareStatement( " select LONG_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+l_servicecode +"'and LANGUAGE_ID ='"+locale+"' ");
				
								rsserv_desc = pstmt.executeQuery();	
		
								while(rsserv_desc.next())
								{
								   serv_description  =  rsserv_desc.getString(1);							
								}	
								rsserv_desc.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							try
							{	
								pstmt = con.prepareStatement( " select NVL(MODIFY_QTY_DURING_ENTRY,'N') from bl_panel_dtl where 	operating_facility_id ='"+p_facility_id+"'  and panel_code = '"+p_service_panel_code+"' and blng_serv_code = '"+l_servicecode+"' ");			
								modify_qty_yn="";
								rsserv_qty = pstmt.executeQuery();	
								while(rsserv_qty.next())
								{
									modify_qty_yn  =  rsserv_qty.getString(1);	
								}
								rsserv_qty.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							l_ratecharge = st1.nextToken();
							if(l_ratecharge.equals(" ")) l_ratecharge="";
		
							if(l_ratecharge.equals("R"))
							{
								ratecharge_desc=rate_label;
							}
							else
							{
								ratecharge_desc=charge_label;
							}
							l_exclincl = st1.nextToken();							
							if(l_exclincl.equals(" ")) l_exclincl="";


							p_override_yn=l_exclincl;		//p_override_incl_excl_ind


							if(l_exclincl.equals("I")) l_exclincl=include_label;
							else if(l_exclincl.equals("E")) l_exclincl=exclude_label;	
							l_reason = st1.nextToken();
							if(l_reason.equals(" ")) l_reason="";
							try
							{
								pstmt = con.prepareStatement( " select ACTION_REASON_DESC     from   bl_action_reason_lang_vw where ACTION_REASON_CODE ='"+l_reason+"' and LANGUAGE_ID = '"+locale+"' ");

								rsreson_desc = pstmt.executeQuery();	
								reason_description="";
								while(rsreson_desc.next())
								{
									reason_description  =  rsreson_desc.getString(1);		
								}	
								rsreson_desc.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("2="+e.toString());
							}
							l_practstaff = st1.nextToken();
							if(l_practstaff.equals(" ")) l_practstaff="";

							if(l_practstaff.equals("P")){l_practstaff_desc="Practitioner";}
							if(l_practstaff.equals("O")){l_practstaff_desc="OtherStaff";}
							l_practstaffid = st1.nextToken();
							if(l_practstaffid.equals(" ")) l_practstaffid="";
							try
							{
								pstmt = con.prepareStatement("SELECT NAME FROM BL_AM_PRACT_STAFF_VW WHERE PRACT_STAFF_IND='"+l_practstaff+"' AND PRACTITIONER_ID    = '"+l_practstaffid+"' AND LANGUAGE_ID = '"+locale+"' and facility_id='"+p_facility_id+"'");	
							
								pract_name="";
								rspractname = pstmt.executeQuery();	
								while(rspractname.next())
								{
									pract_name  =  rspractname.getString(1);		
								}	
								rspractname.close();
								pstmt.close();
							}
							catch(Exception e) 
							{
								System.out.println("3="+e.toString());
							}
							l_uom = st1.nextToken();
							if(l_uom.equals(" ")) l_uom="";
							try
							{
								String uom_sql=" select LONG_DESC from am_uom_lang_vw where UOM_CODE = '"+l_uom+"' and LANGUAGE_ID = '"+locale+"' ";	

								pstmt = con.prepareStatement(uom_sql );
								rsuomdesc = pstmt.executeQuery();	
								if(rsuomdesc!=null && rsuomdesc.next())
								{
									uom_description  =  rsuomdesc.getString(1);		
								}				
								rsuomdesc.close();
								pstmt.close();
							}
							catch(Exception e) 
							{
								System.out.println("3="+e.toString());
							}
							l_incl_excl=st1.nextToken();
							if(l_incl_excl.equals(" ")) l_incl_excl="";
							if(l_incl_excl.equals("E"))
							{
								l_incl_excl=exclude_label;
							}
							else if(l_incl_excl.equals("I"))
							{
								l_incl_excl=include_label;
							}
							//else if(l_exclincl.equals("")) l_exclincl=exclude_label;
							l_preapp_yn = st1.nextToken();
							if(l_preapp_yn.equals(" ")) l_preapp_yn="";
							if(l_preapp_yn.equals("Y"))
							{
								str="checked";
							}
							l_serv_qty = st1.nextToken();
							if(l_serv_qty.equals(" ")) l_serv_qty="";
								System.err.println("8.3:"+l_serv_qty);
							l_chargeamt = st1.nextToken();
							if(l_chargeamt.equals(" ")) l_chargeamt="";
							//l_qty = cf.formatCurrency(l_qty, noofdecimal);
							//l_chargeamt = cf.formatCurrency(l_chargeamt, noofdecimal);
							l_chargeamt_screen = l_chargeamt;

							l_serv_qty = cf.formatCurrency(l_serv_qty, noofdecimal);
							panel_qty = cf.formatCurrency(panel_qty_for_hidden, noofdecimal);
							serv_qty=Double.parseDouble(l_serv_qty);
							db_panel_qty =Double.parseDouble(panel_qty); 
							double temp = 0.0;
					
							if(l_ratecharge.equals("R"))
							{
								temp = serv_qty*db_panel_qty;
							}
							else
							{
								temp = serv_qty;
							}
							panel_qty=cf.formatCurrency(String.valueOf(temp), noofdecimal);
	//		double charge_amt=Double.parseDouble(l_chargeamt);	//enabled for testing by muthu

// charge amt is nullified for Rate Based services
		//		System.out.println(" Rate charege details "+l_ratecharge); 
				//commented By DhanasekarV start  IN036427
		/*							if(l_ratecharge.equals("R"))
							{
								l_chargeamt="";
							}
							*/
							if(!l_servicecode.equals(""))
							{
								try
								{
									String serv_panel_str="";					
									if(p_service_panel_ind.equals("L"))
									{
										serv_panel_str=l_servicecode;
									}
									else
									{
										serv_panel_str=p_service_panel_code;
									}
									if(((strp_episode_id.equals("0") && strp_visit_id.equals("0")) && !p_episode_type.equals("R")) || ((strp_episode_id.equals("0") && strp_visit_id.equals("0")) && p_episode_type.equals("R")))
									{
										String p_service_panel_ind_temp="S";

										if(p_episode_type.equals("R") && p_module_id.equals("OR"))
										{
											
											String sqloverride="{ call blcommon.bl_check_excl_incl_override('"+p_facility_id+"','R','"+str_null+"','"+str_null+"','"+p_patient_id+"','"+serv_panel_str+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI'),?,?)}";
											CallableStatement call = con.prepareCall(sqloverride);

											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.execute();
											str_override_allowed_yn=call.getString(1);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											//Changed for IN50765 
											if("Y".equals(str_override_allowed_yn)) str_override_allowed_yn="B";
											String sqlbefreg="{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_BILL_DETAILS('"+p_facility_id+"','"+p_module_id+"','R','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),?,?,?,?,'"+str_null+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+serv_qty+"','"+l_chargeamt_screen+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+p_override_yn+"',?,?,'"+locale+"',?,?,?)}";
											//if(serv_panel_str.equals("LZZ_FREE"))


											call = con.prepareCall(sqlbefreg);	
											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.registerOutParameter(3,java.sql.Types.DOUBLE);
											call.registerOutParameter(4,java.sql.Types.DOUBLE);
											call.registerOutParameter(5,java.sql.Types.DOUBLE);
											call.registerOutParameter(6,java.sql.Types.DOUBLE);
											call.registerOutParameter(7,java.sql.Types.DOUBLE);
											call.registerOutParameter(8,java.sql.Types.DOUBLE);
											call.registerOutParameter(9,java.sql.Types.DOUBLE);
											call.registerOutParameter(10,java.sql.Types.DOUBLE);
											call.registerOutParameter(11,java.sql.Types.DOUBLE);
											call.registerOutParameter(12,java.sql.Types.DOUBLE);
											call.registerOutParameter(13,java.sql.Types.DOUBLE);
											call.registerOutParameter(14,java.sql.Types.DOUBLE);	
											call.registerOutParameter(15,java.sql.Types.VARCHAR);	
											call.registerOutParameter(16,java.sql.Types.DOUBLE);
											call.registerOutParameter(17,java.sql.Types.VARCHAR);
											call.registerOutParameter(18,java.sql.Types.VARCHAR);
											call.registerOutParameter(19,java.sql.Types.VARCHAR);	
											call.registerOutParameter(20,java.sql.Types.VARCHAR);
											call.registerOutParameter(21,java.sql.Types.VARCHAR);
											call.registerOutParameter(22,java.sql.Types.VARCHAR);
											call.registerOutParameter(23,java.sql.Types.VARCHAR);
											call.registerOutParameter(24,java.sql.Types.VARCHAR);
											call.registerOutParameter(25,java.sql.Types.VARCHAR);
											call.registerOutParameter(26,java.sql.Types.VARCHAR);
											call.registerOutParameter(27,java.sql.Types.VARCHAR);
										
											call.execute();	

											str_base_qty = call.getString(5);
											 if(str_base_qty==null) str_base_qty="";
											str_base_rate = call.getString(6);
											 if(str_base_rate==null) str_base_rate="";

											// if (str_base_rate!=0) 
											str_base_rate = cf.formatCurrency(str_base_rate,noofdecimal);
									
											d_net_charge_amt=call.getDouble(11);
											d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);
											
											
											if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
											if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,noofdecimal);
			
											d_cust_net_charge_amt=call.getDouble(18);
											d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

											if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
											if (d_cust_net_charge_amt!=0) d_cust_net_charge_amt_temp = 	cf.formatCurrency(d_cust_net_charge_amt_temp,noofdecimal);
//											test_var=call.getString(18);
										
											str_err_code=call.getString(25);
											if(str_err_code==null) str_err_code="";
										
											str_sys_message_id=call.getString(26);   
											if(str_sys_message_id==null) str_sys_message_id="";
											
											str_error_text=call.getString(27);
											if(str_error_text==null) str_error_text="";		
											d_pat_payable = Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
									
											d_pat_payable_temp=String.valueOf(d_pat_payable);
									

											if(d_pat_payable==0) d_pat_payable_temp="0.00";
											if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,noofdecimal);	

											call.close();
										}
										else
										{
											CallableStatement call = null;
											/*String sqloverride_bef_reg="{ call blcommon.bl_chk_ex_in_ovrride_bef_reg('"+p_facility_id+"','"+p_episode_type+"','"+p_patient_id+"','"+policy_type_code+"','"+cust_group_code+"','"+cust_code+"','"+policy_priority+"','"+l_servicecode+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI'),'"+policy_eff_from_date+"','"+policy_eff_to_date+"',?)}";
											CallableStatement call = con.prepareCall(sqloverride_bef_reg);

											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.execute();
											str_override_allowed_yn=call.getString(1);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											*/
											try
											{
											String sqloverride_bef_reg="{ call BL_PROC_ITEM_VALIDATIONS_MP.GET_BLNG_SERV_VALS('"+p_facility_id+"','"+p_module_id+"','"+str_epi_type_clinic_code+"','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"',?,?,?,?,?,?,?)}";
											call = con.prepareCall(sqloverride_bef_reg);

											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.registerOutParameter(3,java.sql.Types.VARCHAR);
											call.registerOutParameter(4,java.sql.Types.VARCHAR);
											call.registerOutParameter(5,java.sql.Types.VARCHAR);
											call.registerOutParameter(6,java.sql.Types.VARCHAR);
											call.registerOutParameter(7,java.sql.Types.VARCHAR);
											call.execute();
											str_override_allowed_yn=call.getString(3);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											//Changed for IN50765 
											if("Y".equals(str_override_allowed_yn)) str_override_allowed_yn="B";
											
											str_err_code=call.getString(5);
											if(str_err_code==null) str_err_code="";
										
											str_sys_message_id=call.getString(6);   
											if(str_sys_message_id==null) str_sys_message_id="";
											
											str_error_text=call.getString(7);
											if(str_error_text==null) str_error_text="";	

											call.close();
											}
											catch(Exception e)
											{
												System.err.println("Error when calling BL_PROC_ITEM_VALIDATIONS_MP.GET_BLNG_SERV_VALS:"+e);
											}

											if((str_err_code.equals("10") && !str_err_code.equals("")) || !str_sys_message_id.equals(""))
											{
												if (str_err_code.equals("10") && !str_err_code.equals(""))
												{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block96Bytes, _wl_block96);

												}
												if(!str_sys_message_id.equals(""))
												{
													System.err.println("In Body Page2.1");

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(str_sys_message_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
	
												}	
											}
											else
											{
												String sqlbefreg="{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_BILL_DETAILS_BEF_REG('"+p_facility_id+"','"+p_module_id+"','"+str_epi_type_clinic_code+"','"+p_patient_id+"','"+str_encounter_id+"','"+strp_episode_id+"','"+strp_visit_id+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+serv_qty+"','"+l_chargeamt+"','"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"','"+user_id+"','"+ws_num+"','"+str_acct_seq_no+"','"+p_override_yn+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
												//if(serv_panel_str.equals("LZZ_FREE"))


												call = con.prepareCall(sqlbefreg);	
												call.registerOutParameter(1,java.sql.Types.VARCHAR);
												call.registerOutParameter(2,java.sql.Types.VARCHAR);
												call.registerOutParameter(3,java.sql.Types.DOUBLE);
												call.registerOutParameter(4,java.sql.Types.DOUBLE);
												call.registerOutParameter(5,java.sql.Types.DOUBLE);
												call.registerOutParameter(6,java.sql.Types.DOUBLE);
												call.registerOutParameter(7,java.sql.Types.DOUBLE);
												call.registerOutParameter(8,java.sql.Types.DOUBLE);
												call.registerOutParameter(9,java.sql.Types.DOUBLE);
												call.registerOutParameter(10,java.sql.Types.DOUBLE);
												call.registerOutParameter(11,java.sql.Types.DOUBLE);
												call.registerOutParameter(12,java.sql.Types.DOUBLE);
												call.registerOutParameter(13,java.sql.Types.DOUBLE);
												call.registerOutParameter(14,java.sql.Types.DOUBLE);	
												call.registerOutParameter(15,java.sql.Types.VARCHAR);	
												call.registerOutParameter(16,java.sql.Types.DOUBLE);
												call.registerOutParameter(17,java.sql.Types.VARCHAR);
												call.registerOutParameter(18,java.sql.Types.VARCHAR);
												call.registerOutParameter(19,java.sql.Types.VARCHAR);	
												call.registerOutParameter(20,java.sql.Types.VARCHAR);
												call.registerOutParameter(21,java.sql.Types.VARCHAR);
//												call.registerOutParameter(22,java.sql.Types.VARCHAR);
											
												call.execute();	
												str_base_qty = call.getString(1);
												 if(str_base_qty==null) str_base_qty="";
												str_base_rate = call.getString(2);
												 if(str_base_rate==null) str_base_rate="";

												// if (str_base_rate!=0) 
												str_base_rate = cf.formatCurrency(str_base_rate,noofdecimal);
										
												d_net_charge_amt=call.getDouble(7);
												d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);
												
												
												if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
												if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,noofdecimal);
				
												d_cust_net_charge_amt=call.getDouble(14);
												d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

												if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
												if (d_cust_net_charge_amt!=0) d_cust_net_charge_amt_temp = 	cf.formatCurrency(d_cust_net_charge_amt_temp,noofdecimal);
												test_var=call.getString(18);
/*
												str_override_allowed_yn=call.getString(19);
												if(str_override_allowed_yn == null) str_override_allowed_yn = "N";
*/											
												str_err_code=call.getString(19);
												if(str_err_code==null) str_err_code="";
											
												str_sys_message_id=call.getString(20);   
												if(str_sys_message_id==null) str_sys_message_id="";
												
												str_error_text=call.getString(21);
												if(str_error_text==null) str_error_text="";		
												d_pat_payable = Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
										
												d_pat_payable_temp=String.valueOf(d_pat_payable);
										

												if(d_pat_payable==0) d_pat_payable_temp="0.00";
												if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,noofdecimal);	
										
												call.close();
											}
										}
									}
									else
									{

										String p_service_panel_ind_temp="S";

//										String sqloverride="{ call blcommon.bl_check_excl_incl_override('"+p_facility_id+"','"+p_episode_type+"','"+strp_episode_id+"','"+strp_visit_id+"','"+p_patient_id+"','"+l_servicecode+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI'),?)}";
										String sqloverride="{ call BL_PROC_ITEM_VALIDATIONS_MP1.bl_check_excl_incl_override('"+p_facility_id+"','"+p_patient_id+"','"+p_episode_type+"','"+str_encounter_id+"','"+strp_episode_id+"','"+strp_visit_id+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI')"+",'"+l_servicecode+"','"+p_order_item+"','"+p_module_id+"',?,?,?,?)}";
										CallableStatement call = con.prepareCall(sqloverride);
										
										try
										{
											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.registerOutParameter(3,java.sql.Types.VARCHAR);
											call.registerOutParameter(4,java.sql.Types.VARCHAR);
											call.execute();

											str_override_allowed_yn=call.getString(1);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											//Changed for IN50765 
											if("Y".equals(str_override_allowed_yn)) str_override_allowed_yn="B";
							   System.out.println("str_override_allowed_yn  "+str_override_allowed_yn);													
											
											str_err_code=call.getString(2);
										    if(str_err_code==null) str_err_code="";
		
											str_sys_message_id=call.getString(3);   
										    if(str_sys_message_id==null) str_sys_message_id="";
	
											str_error_text=call.getString(4);
											if(str_error_text==null) str_error_text="";

										}
										catch(Exception e)
										{
											System.err.println("Error while calling BL_PROC_ITEM_VALIDATIONS_MP.bl_check_excl_incl_override:"+e);
										}
										/*	String sqltest="{ call BL_PROC_ITEM_VALIDATIONS_MP.GET_BILL_DETAILS('"+p_facility_id+"','"+p_module_id+"','"+p_episode_type+"','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+p_encounter_id+"','"+p_acct_seq_no+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),?,?,?,?,'"+p_order_item+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+serv_qty+"','"+charge_amt+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+p_override_yn+"',?,?,'"+locale+"',?,?,?)}";
	
										CallableStatement call = con.prepareCall(sqltest);
										call.registerOutParameter(1,java.sql.Types.VARCHAR);
										call.registerOutParameter(2,java.sql.Types.VARCHAR);
										call.registerOutParameter(3,java.sql.Types.VARCHAR);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.DOUBLE);
										call.registerOutParameter(6,java.sql.Types.DOUBLE);
										call.registerOutParameter(7,java.sql.Types.DOUBLE);
										call.registerOutParameter(8,java.sql.Types.DOUBLE);
										call.registerOutParameter(9,java.sql.Types.DOUBLE);
										call.registerOutParameter(10,java.sql.Types.DOUBLE);
										call.registerOutParameter(11,java.sql.Types.DOUBLE);
										call.registerOutParameter(12,java.sql.Types.DOUBLE);
										call.registerOutParameter(13,java.sql.Types.DOUBLE);
										call.registerOutParameter(14,java.sql.Types.DOUBLE);
										call.registerOutParameter(15,java.sql.Types.DOUBLE);
										call.registerOutParameter(16,java.sql.Types.DOUBLE);
										call.registerOutParameter(17,java.sql.Types.DOUBLE);
										call.registerOutParameter(18,java.sql.Types.DOUBLE);
										call.registerOutParameter(19,java.sql.Types.VARCHAR);	
										call.registerOutParameter(20,java.sql.Types.DOUBLE);
										call.registerOutParameter(21,java.sql.Types.VARCHAR);
										call.registerOutParameter(22,java.sql.Types.VARCHAR);
										call.registerOutParameter(23,java.sql.Types.VARCHAR);	
										call.registerOutParameter(24,java.sql.Types.DOUBLE);
										call.registerOutParameter(25,java.sql.Types.VARCHAR);
										call.registerOutParameter(26,java.sql.Types.VARCHAR);
										call.registerOutParameter(27,java.sql.Types.VARCHAR);
								
										call.execute();		
								
										str_day_type_code=call.getString(1);	   
										if(str_day_type_code==null) str_day_type_code="";
										
										str_day_type_disc=call.getString(2);	 
										if(str_day_type_disc==null) str_day_type_disc="";
	
									    str_time_type_code=call.getString(3);
										if(str_time_type_code==null) str_time_type_code="";
									 
										str_time_type_desc=call.getString(4);	
									    if(str_time_type_desc==null) str_time_type_desc="";
									
										d_base_qty=call.getDouble(5);
										d_base_rate=call.getDouble(6);
										d_addl_factor=call.getDouble(7);
										d_base_chargeamt=call.getDouble(8); 
										d_gross_charge_amt=call.getDouble(9);
									    d_disc_amt=call.getDouble(10); 
									
										d_net_charge_amt=call.getDouble(11); 
										d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);

										if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
										if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,2);
									     
										d_disc_perc=call.getDouble(12);
									    d_pat_gross_charge_amt=call.getDouble(13);
									    d_pat_disc_amt=call.getDouble(14);
									    d_pat_net_charge_amt=call.getDouble(15);
										d_cust_gross_charge_amt=call.getDouble(16);
										d_cust_disc_amt=call.getDouble(17);
									    d_cust_net_charge_amt=call.getDouble(18);	
										d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

										if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
										if (d_cust_net_charge_amt!=0)
										{
											d_cust_net_charge_amt_temp = cf.formatCurrency(d_cust_net_charge_amt_temp,2);
										}
									    d_split_ind=call.getString(19);
										if(d_split_ind==null) d_split_ind="";
									    d_curr_availed=call.getDouble(20);  
										str_credit_auth_ref=call.getString(21);
										if(str_credit_auth_ref==null) str_credit_auth_ref="";
									    str_excl_incl_ind=call.getString(22);    
									    str_preapp_yn=call.getString(23);
									    if(str_day_type_disc==null) str_day_type_disc="";
									    d_pat_paid_amt=call.getDouble(24);  
										d_pat_paid_amt_temp=String.valueOf(d_pat_paid_amt);

										if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
										if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf.formatCurrency(d_pat_paid_amt_temp,2);
		
										str_err_code=call.getString(25);
									    if(str_err_code==null) str_err_code="";
	
										str_sys_message_id=call.getString(26);   
									    if(str_sys_message_id==null) str_sys_message_id="";
	
										str_error_text=call.getString(27);
										if(str_error_text==null) str_error_text="";	
			
										d_pat_payable = 	Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
										d_pat_payable_temp=String.valueOf(d_pat_payable);

										if(d_pat_payable==0) d_pat_payable_temp="0.00";
										if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,2);
			
										call.close();*/
										
										String sqltest="{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DETAILS('"+p_facility_id+"','"+p_module_id+"','"+p_order_id+"','"+p_order_line_no+"','"+p_episode_type+"','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),?,?,?,?,'"+p_order_item+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+panel_qty+"','"+l_chargeamt+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+p_override_yn+"',?,?,'"+locale+"',?,?,?)}";

										
										 call = con.prepareCall(sqltest);
/*
										CallableStatement call = con.prepareCall("{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DETAILS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); 

										call.setString(1,p_facility_id);//facility_id
										call.setString(2,p_module_id);	//module_id	
										call.setString(3,p_order_id); //p_order_id
										call.setString(4,p_order_line_no); //p_order_line_no
										call.setString(5,p_episode_type);//episode_type
										call.setString(6,p_patient_id);
										call.setString(7,strp_episode_id);
										call.setString(8,strp_visit_id);//visit_id
										call.setString(9,str_encounter_id);
										call.setString(10,str_acct_seq_no);					
										call.setString(11,p_service_date);
										call.setString(16,p_order_item);//item_code
										call.setString(17,p_service_panel_ind_temp);//service_panel_ind
										call.setString(18,serv_panel_str);//service_panel_code
										call.setDouble(19,serv_qty);//se
										call.setString(20,String.valueOf(charge_amt));
*/
										call.setDouble(24,num1);
										call.setDouble(25,num2);
/*
										call.setString(43,p_override_yn);
										call.setString(46,locale);
*/
										call.registerOutParameter(1,java.sql.Types.VARCHAR);
										call.registerOutParameter(2,java.sql.Types.VARCHAR);
										call.registerOutParameter(3,java.sql.Types.VARCHAR);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.registerOutParameter(7,java.sql.Types.DOUBLE);
										call.registerOutParameter(8,java.sql.Types.DOUBLE);
										call.registerOutParameter(9,java.sql.Types.DOUBLE);
										call.registerOutParameter(10,java.sql.Types.DOUBLE);
										call.registerOutParameter(11,java.sql.Types.DOUBLE);
										call.registerOutParameter(12,java.sql.Types.DOUBLE);
										call.registerOutParameter(13,java.sql.Types.DOUBLE);
										call.registerOutParameter(14,java.sql.Types.DOUBLE);
										call.registerOutParameter(15,java.sql.Types.DOUBLE);
										call.registerOutParameter(16,java.sql.Types.DOUBLE);
										call.registerOutParameter(17,java.sql.Types.DOUBLE);
										call.registerOutParameter(18,java.sql.Types.DOUBLE);
										call.registerOutParameter(19,java.sql.Types.VARCHAR);	
										call.registerOutParameter(20,java.sql.Types.DOUBLE);
										call.registerOutParameter(21,java.sql.Types.VARCHAR);
										call.registerOutParameter(22,java.sql.Types.VARCHAR);
										call.registerOutParameter(23,java.sql.Types.VARCHAR);	
										call.registerOutParameter(24,java.sql.Types.DOUBLE);
										call.registerOutParameter(25,java.sql.Types.DOUBLE);
										call.registerOutParameter(26,java.sql.Types.VARCHAR);
										call.registerOutParameter(27,java.sql.Types.VARCHAR);
										call.registerOutParameter(28,java.sql.Types.DOUBLE);
										call.registerOutParameter(29,java.sql.Types.VARCHAR);
										call.registerOutParameter(30,java.sql.Types.VARCHAR);
										call.registerOutParameter(31,java.sql.Types.VARCHAR);
									
										call.execute();	
	
										str_day_type_code=call.getString(1);	 
										if(str_day_type_code==null) str_day_type_code="";
	
										str_day_type_disc=call.getString(2);	 
										if(str_day_type_disc==null) str_day_type_disc="";
		
										str_time_type_code=call.getString(3);
									    if(str_time_type_code==null) str_time_type_code="";
		
										str_time_type_desc=call.getString(4);	
									    if(str_time_type_desc==null) str_time_type_desc="";									
										//d_base_qty=call.getDouble(5);
									    //d_base_rate=call.getDouble(6);
										str_base_qty = call.getString(5);
										 if(str_base_qty==null) str_base_qty="";
										str_base_rate = call.getString(6);
										 if(str_base_rate==null) str_base_rate="";
										 str_base_rate = cf.formatCurrency(str_base_rate,noofdecimal);
										//if (str_base_rate!=0) str_base_rate =  
										//cf.formatCurrency(str_base_rate,noofdecimal);										

									    d_addl_factor=call.getDouble(7);



									    d_base_chargeamt=call.getDouble(8); 
										d_gross_charge_amt=call.getDouble(9);
									    d_disc_amt=call.getDouble(10); 
										d_net_charge_amt=call.getDouble(11); 

										if(d_net_charge_amt<0) d_net_charge_amt=0;
										d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);
										if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
										if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,noofdecimal);
										d_disc_perc=call.getDouble(12);
										// d_pat_gross_charge_amt=call.getDouble(29);
									    d_pat_disc_amt=call.getDouble(14);
									    d_pat_net_charge_amt=call.getDouble(15);
									    d_cust_gross_charge_amt=call.getDouble(16);
									    d_cust_disc_amt=call.getDouble(17);
									    d_cust_net_charge_amt=call.getDouble(18);	
										d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

										if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
										
										if (d_cust_net_charge_amt!=0) d_cust_net_charge_amt_temp = 	cf.formatCurrency(d_cust_net_charge_amt_temp,noofdecimal);
										d_split_ind=call.getString(19);
									    if(d_split_ind==null) d_split_ind="";
										d_curr_availed=call.getDouble(20);  
										str_credit_auth_ref=call.getString(21);
									    if(str_credit_auth_ref==null) str_credit_auth_ref="";
										str_charged_yn=call.getString(22);
									    if(str_charged_yn==null) str_charged_yn="";
										str_pat_billed_yn=call.getString(23);
									    if(str_pat_billed_yn==null) str_pat_billed_yn="";
										num1=call.getDouble(24);
										num2=call.getDouble(25);
									    str_excl_incl_ind=call.getString(26);    
									    str_preapp_yn=call.getString(27);    
									    d_pat_paid_amt=call.getDouble(28);  
										
										d_pat_paid_amt_temp=String.valueOf(d_pat_paid_amt);

										if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
										if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf.formatCurrency(d_pat_paid_amt_temp,noofdecimal);	
									
										str_err_code=call.getString(29);
									    if(str_err_code==null) str_err_code="";
									    
										str_sys_message_id=call.getString(30);   
									    if(str_sys_message_id==null) str_sys_message_id="";
									    
										str_error_text=call.getString(31);
									    if(str_error_text==null) str_error_text="";	
								
										d_pat_payable = 	Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
										d_pat_payable_temp=String.valueOf(d_pat_payable);

										if(d_pat_payable==0) d_pat_payable_temp="0.00";
										if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,noofdecimal);
										
										
									
										call.close();
									
									}
								}//try
								catch(Exception exp1)
								{			
									System.out.println("error pay amt"+exp1);
								}
							}//if end for procdeure		
									
						 }//inner while st	
	
						if((str_err_code.equals("10") && !str_err_code.equals("")) || !str_sys_message_id.equals(""))
						{
							if (str_err_code.equals("10") && !str_err_code.equals(""))
							{

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block100Bytes, _wl_block100);

							}
							if(!str_sys_message_id.equals(""))
							{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(str_sys_message_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
	
							}	
						}
						else
						{
 							if(i % 2 == 0 )
							{
								classval	=	"QRYEVEN";
							}
							else
							{
								classval	=	"QRYODD";
							}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(record_select));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(serv_description));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(l_servicecode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(l_incl_excl));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(l_exclincl));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(reason_description));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(l_reason));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ratecharge_desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(l_ratecharge));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(l_serv_qty));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(modify_qty_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(uom_description));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(l_uom));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(l_serv_qty));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(panel_qty));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(str_base_rate));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(l_practstaff_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(l_practstaff));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(l_practstaffid));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(d_net_charge_amt_temp));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(d_pat_payable_temp));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(d_pat_paid_amt_temp));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(str));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(str));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_charged_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_override_allowed_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(d_net_charge_amt_temp));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_base_rate));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block127Bytes, _wl_block127);

							i++;
							record_select++;
							totalRecords=i;		
						}//while
					}//else	
					}//p_string if
					else
					{
						
            _bw.write(_wl_block128Bytes, _wl_block128);

						//no record found alert messages to be popup
					}
				}
				else
				{
				
            _bw.write(_wl_block129Bytes, _wl_block129);

					//no record found alert messages to be popup
				}
			}//else  for multirecord
		}
		catch(Exception e)
		{
			System.out.println("Exception in Design Layout Else Part"+e);
		}

            _bw.write(_wl_block130Bytes, _wl_block130);

	String session_practitioner=(String)session.getAttribute("sessionPractitioner");
	String session_staff_ind=(String)session.getAttribute("sessionStaffInd");
	String session_staff_id=(String)session.getAttribute("sessionStaffId");

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(session_practitioner));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(session_staff_ind));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(session_staff_id));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(l_servicecode));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(p_service_panel_ind));
            _bw.write(_wl_block137Bytes, _wl_block137);

	if(p_service_panel_ind.equals("L"))
	{

            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(p_service_panel_code));
            _bw.write(_wl_block139Bytes, _wl_block139);

	}

            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(str));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(p_string));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(added_serv_yn));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(str_encounter_id));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(str_acct_seq_no));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(rate_label));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(charge_label));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(include_label));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(exclude_label));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(panel_qty_for_hidden));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(str_epi_type_clinic_code));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block154Bytes, _wl_block154);

	}
	catch(Exception e)
	{
		System.out.println("Main Exception Try"+e);
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block155Bytes, _wl_block155);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
