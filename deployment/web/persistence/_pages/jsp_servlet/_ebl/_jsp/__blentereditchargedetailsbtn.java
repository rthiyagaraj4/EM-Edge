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
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __blentereditchargedetailsbtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLEnterEditChargeDetailsBtn.jsp", 1743663822719L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n\n<html>\n\t<head>\n\t\t<script>\n//\t\t\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\t\t\tvar service=\"\";\n\t\t\t\tvar blng_service_code=\"\";\n\t\t\t\tvar incl_excl=\"\";\n\t\t\t\tvar incl_excl_action=\"\";\n\t\t\t\tvar reason=\"\";\n\t\t\t\tvar action_reason_code=\"\";\n\t\t\t\tvar charge=\"\";\n\t\t\t\tvar original_qty=\"\";\n\t\t\t\tvar uom=\"\";\n\t\t\t\tvar uom_code=\"\";\n\t\t\t\tvar revise_qty=\"\";\n\t\t\t\tvar total_qty=\"\";\n\t\t\t\tvar rate=\"\";\n\t\t\t\tvar practioner_type=\"\";\n\t\t\t\tvar pract_id=\"\";\n\t\t\t\tvar practioner=\"\";\n\t\t\t\tvar pract_staff_id=\"\";\n\t\t\t\tvar total_pay=\"\";\n\t\t\t\tvar patient_pay=\"\";\n\t\t\t\tvar patient_paid=\"\";\n\t\t\t\tvar preappr=\"\";\n\t\t\t\tvar cbflag=\"\";\n\t        \tvar total_records=\"\";\n\t\t\t\tvar totalRecords=0;\n\t\t\t\tvar formObj=\"\";\n\t\t\t\tvar modify_qty_yn=\"\";\n\t\t\t\tvar ratecharge_desc=\"\";\n\t\t\t\tvar charged_yn=\"\";\n\t\t\t\tvar serv_amt_changed=\"\";\n\t\t\t\tvar excl_incl_ind_for_screen=\"\";\n\nfunction acceptvalidation()\n{\n\tvar formObj = parent.query2.document.edit_enter_main;\n\tvar totalRecords =eval(formObj.total_records.value);\n\tvar module_id=document.forms[0].h_module_id.value;\n\t\t\n\tif(module_id != \'OP\' && module_id != \'AE\')\n\t{\n\t\tif(totalRecords==0)\n\t\t{\n\t\t alert(getMessage(\"BL6196\",\"BL\"));\n\t\t return false;\n\t\t}\n\t}\n\t\n    var service_code_arr=new Array();\n\n\tfor(var i=0;i<totalRecords;i++)\n\t\t{\n\t\t\tvar blng_serv_code=eval(\"parent.frames[2].document.forms[0].blng_serv_code\"+i);\n\t\t\tvar serv_code=blng_serv_code.value;\t\n\t\t\tservice_code_arr[i]=serv_code;\t\t\t\n\t\t}\n\n\t\tfor (var i=0;i<service_code_arr.length;i++)\n\t\t{\n\t\t    var serv_code1 = service_code_arr[i];\n\t\t\tvar j = i;\n\n\t\t    while(!((j+1)>totalRecords))\n\t\t    {\n\t\t\t\tj++;\n\t\t\t\tvar serv_code2 = service_code_arr[j];\n\t\t\t\tif(serv_code1==serv_code2)\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\'BL9604\',\'BL\'));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t    }\n\t\t}\n\n\n\n\tvar a1=new Array();var a2=new Array();var a3=new Array();var a4=new Array();\n\tvar a5=new Array();var a6=new Array();var a7=new Array();var a8=new Array();\n\tvar a8=new Array();var a9=new Array();var a10=new Array();var a11=new Array();\n\tvar asercode=new Array();var aresncode=new Array();var apractid=new Array();\n\tvar auomcode=new Array();var revise_qty=new Array();\n\tvar str_override_yn=\"\";\n\t//var formObj = parent.query2.document.edit_enter_main;\n\t//var\ttotalRecords =eval(formObj.total_records.value);\t\n\tvar include_label=document.forms[0].include_label.value;\n\tvar exclude_label=document.forms[0].exclude_label.value;\t\n\tvar p_str =\"\";\n\tif(formObj.p_service_panel_ind.value == \"L\")\n\t{\n\t\tp_str =formObj.panel_code.value+\":\"+totalRecords+\"<NR>\";\n\t}\n\telse if(formObj.p_service_panel_ind.value == \"S\")\n\t{\n\t\tp_str =\"<NR>\";\n\t}\n\n\tvar i=0;\n\tfor(i=0;i<totalRecords;i++)\n\t{\n\tvar ser=eval(\"parent.frames[2].document.forms[0].service\"+i);\n\ta1[i]=ser.value;\n\tif(false){\n\t\tif(a1[i]==\"\")a1[i]=\" \";\n\t}\n\t\n\t\n\tvar charge=eval(\"parent.frames[2].document.forms[0].charge\"+i);\n\t\n\ta2[i]=charge.value;\t\n\tif(false){\n\t\tif(a2[i]==\"\")a2[i]=\" \";\n\t}\n\t\n\t\n\tvar incl_excl1=eval(\"parent.frames[2].document.forms[0].incl_excl\"+i);\n\tvar incl_excl=incl_excl1.value;\n\tif((incl_excl==include_label) || (incl_excl==\"Include\"))\n\t{\t\n\t\ta3[i]=\"I\";\n\t}\n\telse if((incl_excl==exclude_label) || (incl_excl==\"Exclude\"))\n\t{\n\t\ta3[i]=\"E\";\n\t}\n\telse\n\t{\n\t\ta3[i]=\"\";\n\t}\n\t\n\tif(false){\n\t\tif(a3[i]==\"\")a3[i]=\" \";\n\t}\n\t\n//\ta3[i]=incl_excl.value;\n//\tif(a3[i]==\"\")a3[i]=\" \";\n\t\n\tvar reason=eval(\"parent.frames[2].document.forms[0].reason\"+i);\n\ta4[i]=reason.value;\n\tif(false){\n\tif(a4[i]==\"\")a4[i]=\" \";\n\t}\n\t\n\tvar pract_id=eval(\"parent.frames[2].document.forms[0].pract_id\"+i);\n\ta5[i]=pract_id.value;\n\tif(false){\n\tif(a5[i]==\"\")a5[i]=\" \";\n\t}\n/*\tif(a5[i]==\"Practitioner\") a5[i]=\"P\";\n\telse a5[i]=\"O\";\n*/\t\n\tvar pract_staff_id=eval(\"parent.frames[2].document.forms[0].pract_staff_id\"+i);\n\ta6[i]=pract_staff_id.value;\n\tif(false){\n\tif(a6[i]==\"\")a6[i]=\" \";\n\t}\n\t\n\tvar uom=eval(\"parent.frames[2].document.forms[0].uom\"+i);\n\ta7[i]=uom.value;\n\tif(false){\n\tif(a7[i]==\"\")a7[i]=\" \";\n\t}\n\t\n\tvar rate_charge_ind=eval(\"parent.frames[2].document.forms[0].charge\"+i);\n\ta8[i]=rate_charge_ind.value;\n\tif(false){\n\tif(a8[i]==\"\")a8[i]=\" \";\n\t}\n\t\n\tvar serv_amt=eval(\"parent.frames[2].document.forms[0].rate\"+i);\n\ta9[i]=serv_amt.value;\n\tif(false){\n\tif(a9[i]==\"\")a9[i]=\" \";\n\t}\n\tvar rate_temp=a9[i];\n\n\t\n\tvar incl_excl_act=eval(\"parent.frames[2].document.forms[0].incl_excl_action\"+i);\n\tvar incl_excl_act1=incl_excl_act.value;\n\t\n\tif((incl_excl_act1==include_label) || (incl_excl_act1==\"Include\"))\n\t{\t\n\t\ta10[i]=\"I\";\n\t}\n\telse if((incl_excl_act1==exclude_label) || (incl_excl_act1==\"Exclude\"))\n\t{\n\t\ta10[i]=\"E\";\n\t}\n\telse\n\t{\n\t\ta10[i]=\"\";\n\t}\t\n\n\tif(false){\n\tif(a10[i]==\"\")a10[i]=\" \";\t\n\t}\n\tvar preappr_reqd=eval(\"parent.frames[2].document.forms[0].preappr_reqd\"+i);\n\t/*a11[i]=preappr_reqd.value;\n\tif(a11[i]==\"\")a11[i]=\" \";*/\n\tif(preappr_reqd.checked)\n\t\t{\n\t\ta11[i]=\"Y\";\n\t\t}\n\t\telse{\n\t\t\tif(false){\n\t\t\ta11[i]=\" \";\n\t\t\t}\n\t\t\telse{\n\t\t\t\ta11[i]=\"\";\n\t\t\t}\n\t\t\t}\n\tvar blng_serv_code=eval(\"parent.frames[2].document.forms[0].blng_serv_code\"+i);\n\tasercode[i]=blng_serv_code.value;\n\tif(false){\n\tif(asercode[i]==\"\")asercode[i]=\" \";\n\t}\n\tvar action_reason_code=eval(\"parent.frames[2].document.forms[0].action_reason_code\"+i);\n\taresncode[i]=action_reason_code.value;\n\tif(false){\n\tif(aresncode[i]==\"\")aresncode[i]=\" \";\n\t}\n\tvar pract_id=eval(\"parent.frames[2].document.forms[0].pract_id\"+i);\n\tapractid[i]=pract_id.value;\n\tif(false){\n\tif(apractid[i]==\"\")apractid[i]=\" \";\n\t}\n\tvar uom_code=eval(\"parent.frames[2].document.forms[0].uom_code\"+i);\n\tauomcode[i]=uom_code.value;\n\tif(false){\n\tif(auomcode[i]==\"\")auomcode[i]=\" \";\n\t}\n\tvar revise_qty1=eval(\"parent.frames[2].document.forms[0].revise_qty\"+i);\n\trevise_qty[i]=revise_qty1.value;\n\tif(false){\n\tif(revise_qty[i]==\"\")revise_qty[i]=\" \";\n\t}\n\t\n\n\tvar override_yn=eval(\"parent.frames[2].document.forms[0].override_allowed_yn\"+i);\n    var v_override_yn=override_yn.value;\n\t\n\t}\n\t//alert(\"str_override_yn :\"+str_override_yn);\n\n\tvar retArr=new Array();\n\tvar j=0;\t\n\tfor(var i=0;i<totalRecords;i++)\n\t{\t \tretArr[i]=asercode[i]+\"#\"+a2[i]+\"#\"+a10[i]+\"#\"+aresncode[i]+\"#\"+a5[i]+\"#\"+a6[i]+\"#\"+auomcode[i]+\"#\"+a3[i]+\"#\"+a11[i]+\"#\"+revise_qty[i]+\"#\"+a9[i];\n\tif(!(i==(totalRecords-1)))\n\t\t{\n\tretArr[i]=retArr[i]+\"<NR>\";\n\t\t}\n //alert(\"retArr[i] \" + retArr[i]);\n\t}\n\t\n\tvar total_payable=document.forms[0].total.value;\n\tvar patient_payable=document.forms[0].patient.value;\n\tvar service_panel_ind=document.forms[0].service_panel_ind.value;\n\tvar patient_paid=document.forms[0].patient_paid.value;\n\tvar rate=\"\";\n\tvar retStr=\"\";\n\tvar quantity=\"\";\n\tvar incl_excl_action=\"\";\n\tvar action_reason_code=\"\";\n\tvar mod_pract_ind=\"\";\n\tvar mod_physician_id=\"\";\n\tvar incl_excl_ind_for_serv = \"\";\n\tif(service_panel_ind==\"S\")\n\t{\n\t\tfor(var i=0;i<totalRecords;i++)\n\t\t{\n\t\t\tvar quantity1=eval(\"parent.frames[2].document.forms[0].revise_qty\"+i);\n\t\t\tquantity=quantity1.value;\n\n\t\t\tvar rate1=eval(\"parent.frames[2].document.forms[0].rate\"+i);\n\t\t\trate=rate1.value;\n\n\t\t\tvar incl_excl_action1=eval(\"parent.frames[2].document.forms[0].incl_excl_action\"+i);\n\t\t\tincl_excl_action=incl_excl_action1.value;\n\n\t\t\tvar action_reason_code1=eval(\"parent.frames[2].document.forms[0].action_reason_code\"+i);\n\t\t\taction_reason_code=action_reason_code1.value;\n\n\t\t\tvar incl_excl1=eval(\"parent.frames[2].document.forms[0].incl_excl\"+i);\n\t\t\tvar incl_excl=incl_excl1.value;\n\n\t\t\tif((incl_excl==include_label) || (incl_excl==\"Include\"))\n\t\t\t{\t\n\t\t\t\ta3[i]=\"I\";\n\t\t\t\texcl_incl_ind_for_screen = \"I\";\n\t\t\t}\n\t\t\telse if((incl_excl==exclude_label) || (incl_excl==\"Exclude\"))\n\t\t\t{\n\t\t\t\ta3[i]=\"E\";\n\t\t\t\texcl_incl_ind_for_screen = \"E\";\n\t\t\t}\n\t\t\t\n\t\t\t/*if(incl_excl_action==\"\")\n\t\t\t{\n\t\t\t\texcl_incl_ind_for_screen=a3[i];\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(incl_excl_action==include_label)\n\t\t\t{\t\n\t\t\t\texcl_incl_ind_for_screen=\"I\";\t\t\t\n\t\t\t}\n\t\t\telse if(incl_excl_action==exclude_label)\n\t\t\t{\n\t\t\t\texcl_incl_ind_for_screen=\"E\";\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\t}*/\n\t\t\t//excl_incl_ind_for_screen=eval(\"parent.frames[2].document.forms[0].excl_incl_ind_for_screen\"+i);\n\t\t\t//excl_incl_ind_for_screen=excl_incl_ind_for_screen.value;\t\t\t\n\t\n\t\t\tvar mod_pract_ind=eval(\"parent.frames[2].document.forms[0].pract_id\"+i);\n\t\t\tmod_pract_ind = mod_pract_ind.value;\n\t\t\tvar mod_physician_id=eval(\"parent.frames[2].document.forms[0].pract_staff_id\"+i);\n\t\t\tmod_physician_id = mod_physician_id.value;\n\t\t}\n\t\tif((include_label==incl_excl_action) || (\"Include\"==incl_excl_action))\n\t\t{\n\t\t\tincl_excl_action=\"I\";\n\t\t}\n\t\telse if((exclude_label==incl_excl_action) || (\"Exclude\"==incl_excl_action))\n\t\t{\n\t\t\tincl_excl_action=\"E\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tincl_excl_action=\"\";\n\t\t}\n\t\t\n\t\tdocument.forms[0].incl_excl_action_code_to_or.value=incl_excl_action;\n\t\t//alert(\"378::::::::::::\"+ document.forms[0].incl_excl_action_code_to_or.value);\n\t\tdocument.forms[0].action_reason_code_to_or.value=action_reason_code;\n\t\t//alert(\"380::::::::::::\"+ document.forms[0].action_reason_code_to_or.value);\n\t\tdocument.forms[0].rate_temp.value=rate_temp;\n\t\tdocument.forms[0].mod_pract_ind.value=mod_pract_ind;\n\t\tdocument.forms[0].mod_physician_id.value=mod_physician_id;\n\t}\n\tdocument.forms[0].override_yn.value=str_override_yn;\n\n\tfor(var l=0;l<retArr.length;l++)\n\t{\n\t\tretStr=retStr+retArr[l];\n\t}\t\n \n\tdocument.forms[0].p_str.value=p_str;\n\tdocument.forms[0].p_str1.value=retStr;\n\tdocument.forms[0].excl_incl_ind_for_screen.value=excl_incl_ind_for_screen;\n\t\n\n\tif(module_id == \'OR\' || module_id == \'OT\'){  // Only when called_from is \'OT\' this Function will be Returned - Karthik 06/Jan/2016 AMRI-SCF-0427 KDAH-SCF-0367 [IN:060929] \n\t\n//\tvar retString=\"status_flag=true\"+\"&\"+\"total_payable=\"+total_payable+\"&patient_payable=\"+patient_payable+\"&quantity=\"+quantity+\"&rate=\"+rate;\n\t\t\n\tvar retArray=new Array();\n\tretArray[0]=\"Y\";\n\tretArray[1]=total_payable;\n\tretArray[2]=patient_payable;\n\tretArray[3]=patient_paid;\n\tretArray[4]=quantity;\n\tretArray[5]=rate;\n\tretArray[6]=incl_excl_action;\n\tretArray[7]=action_reason_code;\n\tretArray[8]=excl_incl_ind_for_screen;\n\tretArray[9]=mod_pract_ind;\n\tretArray[10]=mod_physician_id;\n\n/*\talert(\"Include Exclude Action:\"+retArray[6]);\n\talert(\"Action Reason Code:\"+retArray[7]);\n\n\t\n\talert(\"retArray[0] :\" +retArray[0]);\n\talert(\"retArray[1] :\" +retArray[1]);\n\talert(\"retArray[2] :\" +retArray[2]);\n\talert(\"retArray[3] :\" +retArray[3]);*/\n\t//alert(\"retArray btn :\"+retArray)\n\t\n\t//parent.window.returnValue = retArray;\n\tlet dialogBody = parent.parent.document.querySelectorAll(\"#dialog-body\")[parent.parent.document.querySelectorAll(\"#dialog-body\").length-1];\n    dialogBody.contentWindow.returnValue = retArray;\n    \n    /* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();   */ \n    parent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length-1].close();\n    \n    \n\t//document.forms(0).action=\"../../servlet/eBL.BLEnterEditChrDetailsServlet\";\t\n\t//\tparent.window.close();\n/*\tfor(var k=0;k<totalRecords;k++)\n\t{\n\t\talert(\"a8[k]\" + a8[k]);\n\t\talert(\"a9[k]\" + a9[k]);\n\tif(a8[k]==\"C\" && a9[k] == 0 )\n\t";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="{\t\t\n\t\t alert(getMessage(\'BL0628\',\'BL\'));\n\t\t return;\n\t}\n  \talert(\"a5[k]\" + a5[k]);\n\tif(a5[k]== \"\")\n\t{\n\t \n\t // parent.frames[2].document.forms[0].practioner_type.focus();\t  \n  \t\t alert(getMessage(\'SY1470\',\'BL\'));\n\t\t  return;\n\t}\n\t\n  \t\n  \tif(a5[k]==\"\")\n\t{\n  \t\t//Focus -- nd_physician_id;\n\t\tparent.frames[2].document.forms[0].practioner.focus();\t  \n\t\t alert(getMessage(\'SY1470\',\'BL\'));\n\t\t  return;\n  \t\t\n  \t}\n  \t\talert(\"a10[k]\" + a10[k]);\n\t\talert(\"a3[k]\" + a3[k]);\n\t\talert(\"a4[k]\" + a4[k]);\n  \tif((a10[k] != a3[k]) && a4[k] ==\"\")\n\t{\n  \t\tparent.frames[2].document.forms[0].reason.focus();\n\t\talert(getMessage(\'SY1470\',\'BL\'));\n\t\t return;\n  \t}\n\t}*/\n  \t\n/*document.forms[0].action=\"../../eBL/jsp/BLEnterEditChrDtsSubmit.jsp\";\n\tdocument.forms[0].submit();\n\tparent.window.close();\n*/\ndocument.forms[0].action=\"../../eBL/jsp/BLEnterEditChrDtsSubmit.jsp\";\n\tdocument.forms[0].submit();\n\n\t}else {\n\t\t//parent.window.returnValue = p_str+retStr+\"<DELIM>\"+total_payable+\"<DELIM>\"+patient_payable+\"<DELIM>\"+patient_paid;\n\t\t//parent.window.close();\n\t\t//let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t    //dialogBody.contentWindow.returnValue = p_str+retStr+\"<DELIM>\"+total_payable+\"<DELIM>\"+patient_payable+\"<DELIM>\"+patient_paid;\n\t\tlet dialogBody = parent.parent.document.querySelectorAll(\"#dialog-body\")[parent.parent.document.querySelectorAll(\"#dialog-body\").length-1];\n\t\tdialogBody.contentWindow.returnValue = p_str+retStr+\"<DELIM>\"+total_payable+\"<DELIM>\"+patient_payable+\"<DELIM>\"+patient_paid;\n\t    \n\t    parent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length-1].close();\n    \n\t}\n}\t\t\t\t\n\nfunction addchargedet()\n{\n\tvar retVal = new String();\n\tvar episode_type=document.forms[0].h_episode_type.value;\n\tvar patient_id=document.forms[0].h_patient_id.value;\n\tvar visit_id=document.forms[0].h_visit_id.value;\n\tvar episode_id=document.forms[0].h_episode_id.value;\t\n\tvar module_id=document.forms[0].h_module_id.value;\n\tvar service_date=document.forms[0].service_date.value;\n\tvar include_label=document.forms[0].include_label.value;\n\tvar exclude_label=document.forms[0].exclude_label.value;\n\tvar service_panel_ind=document.forms[0].service_panel_ind.value;\n\tvar p_order_id=document.forms[0].p_order_id.value;\n\tvar p_order_line_no=document.forms[0].p_order_line_no.value;\n\tvar practioner_type1=\"\";\n\tvar pract_id1=\"\";\n\tvar practioner1=\"\";\n\tvar pract_staff_id1=\"\";\n\tvar dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;\n\tvar original_qty=document.forms[0].orig_qty.value;\n\tif(original_qty==null || original_qty== \"null\" || original_qty== \"\")original_qty=\"1.00\";\n\t/**Added by Ram ghl-1.2**/\n\t\tvar calledfrmencYN=document.forms[0].calledfrmencYN.value;\n\t\tvar bean_id_bl=document.forms[0].bean_id_bl.value;\n\t\t//alert(\"calledfrmencYN btn\"+calledfrmencYN);\n\t\t//alert(\"bean_id_bl btn\"+bean_id_bl);\n\t/**End **********************/\t\n\n\tvar str_epi_type_clinic_code=parent.frames[2].document.forms[0].str_epi_type_clinic_code.value;\n\tstr_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);\n\t\n\tvar formObj = parent.parent.query2.document.edit_enter_main;\n\tvar total_records=formObj.total_records.value;\n\n\tif(total_records !=0)\n\t{\n\t\tvar v_charged_yn=eval(\"parent.frames[2].document.forms[0].charged_yn\"+0);\t\n\t\tif(v_charged_yn.value==\"Y\")\n\t\t{\n\t\t\talert(getMessage(\'BL9780\',\'BL\'));\n\t\t\treturn false;\n\t\t}\n\t}\n\tvar practioner_type=\"\",pract_id=\"\",practioner=\"\",pract_staff_id=\"\";\n\n\tfor( var i=0;i<total_records;i++)\n\t{\n\t\tif((i+1) == total_records)\n\t\t{\t\n\t\t\tpractioner_type=eval(\"parent.frames[2].document.forms[0].practioner_type\"+i);\t\n\t\t\tpractioner_type1=practioner_type.value;\n\t\t\tpract_id=eval(\"parent.frames[2].document.forms[0].pract_id\"+i);\t\n\t\t\tpract_id1=pract_id.value;\n\t\t\tpractioner=eval(\"parent.frames[2].document.forms[0].practioner\"+i);\t\n\t\t\tpractioner1=practioner.value;\n\t\t\tpract_staff_id=eval(\"parent.frames[2].document.forms[0].pract_staff_id\"+i);\t\n\t\t\tpract_staff_id1=pract_staff_id.value;\n\n\t\t}\n\t}\n\t\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n//\tservice_date=convertDate(service_date,\'DMYHMS\',locale,\"en\"); \n/*\n\tvar dialogTop = \"100\";\n\tvar dialogHeight = \"20\" ;\n\tvar dialogWidth = \"40\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n*/\n\tvar dialogTop = window.dialogTop;\n\tvar dialogHeight = \"20\" ;\n\tvar dialogWidth = \"40\" ;\n\tvar dialogLeft=\"360\";\n\tvar features= \"dialogTop:\" + (eval((dialogTop.substr(0,(dialogTop.indexOf(\'px\')))))+115) + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";dialogLeft:\"+dialogLeft+\";status=no\" ;\n\n\tvar title=encodeURIComponent(getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\"));\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\n//var param = \"title=\"+title+\"&column_sizes=\"+column_sizes+\"&column_descriptions=\"+column_descriptions+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&action=add\"+\"&module_id=\"+module_id+\"&service_date=\"+service_date;\n\n/* Added by karthik on Oct-18-2012 to default select a practitioner */\n var totalRecordsInForm =eval(formObj.total_records.value);\n if(totalRecordsInForm==0){\n pract_id1=formObj.session_staff_ind.value;\n practioner1=formObj.session_practitioner.value;\n pract_staff_id1=formObj.session_staff_id.value;\n }\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"episode_type=\"+episode_type+\"&\"+\"patient_id=\"+patient_id+\"&\"+\"visit_id=\"+visit_id+\"&\"+\"episode_id=\"+episode_id+\"&action=add\"+\"&\"+\"module_id=\"+module_id+\"&\"+\"service_date=\"+service_date+\"&\"+\"modify_qty_yn=\"+modify_qty_yn+\"&include_label=\"+encodeURIComponent(include_label)+\"&exclude_label=\"+encodeURIComponent(exclude_label)+\"&service_panel_ind=\"+service_panel_ind+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&practioner_type=\"+practioner_type1+\"&practioner=\"+encodeURIComponent(practioner1)+\"&pract_id=\"+pract_id1+\"&pract_staff_id=\"+pract_staff_id1+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl+\"&dirIndirChrgsFlag=\"+dirIndirChrgsFlag+\"&original_qty=\"+original_qty;\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDetailsValidationFrame.jsp?\"+param,arguments,features);\n\n\tvar count=\"\";\n\tvar formObj=\"\";\n\tvar classval=\"\";\n\tif(retVal!=null)\n\t{\n\t\tvar formObj = parent.query2.document.edit_enter_main;\n\t\ttotalRecords =eval(formObj.total_records.value);\n\t\tcount =totalRecords + 1; \n\t\tvar classval=\"\";\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\t\n\t\t\t\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\t\t\t\n\t\t\t\tarr=retVal.split(\"::\");\t\n\t\t\t\tservice=decodeURIComponent(arr[0]);\n\t\t\t\tif(service==\" \")service=\"\";\n\t\t\t\tblng_service_code=arr[1];\n\t\t\t\tif(service==\" \")service=\"\";\n\t\t\t\tincl_excl=arr[2];\t\t\t\n\t\t\t\tif(incl_excl==\" \")incl_excl=\"\";\n\t\t\t\tincl_excl_action=arr[3];\t\n\t\t\t\tif(incl_excl_action==\" \")incl_excl_action=\"\";\n\t\t\t\treason=decodeURIComponent(arr[4]);\t\t\t\t\n\t\t\t\tif(reason==\" \")reason=\"\";\n\t\t\t\taction_reason_code=arr[5];\n\t\t\t\tif(action_reason_code==\" \")action_reason_code=\"\";\n\t\t\t\tcharge=arr[6];\t\t\t\t\n\t\t\t\tif(charge==\" \")charge=\"\";\n\t\t\t\t\n\t\t\t\toriginal_qty=arr[7];\n\t\t\t\tif(original_qty==\" \")original_qty=\"\";\n\t\t\t\tmodify_qty_yn=arr[8];\n\t\t\t\tif(modify_qty_yn==\" \")modify_qty_yn=\"\";\n\t\t\t\tuom=decodeURIComponent(arr[9]);\n\t\t\t\tif(uom==\" \")uom=\"\";\n\t\t\t\tuom_code=arr[10];\t\n\t\t\t\tif(uom_code==\" \")uom_code=\"\";\n\t\t\t\trevise_qty=arr[11];\t\t\t\n\t\t\t\tif(revise_qty==\" \")revise_qty=\"\";\n\t\t\t\ttotal_qty=arr[12];\t\t\t\n\t\t\t\tif(total_qty==\" \")total_qty=\"\";\n\t\t\t\trate=arr[13];\t\t\t\t\n\t\t\t\tif(rate==\" \")rate=\"\";\n\t\t\t\tpractioner_type=arr[14];\n\t\t\t\tif(practioner_type==\" \")practioner_type=\"\";\n//\t\t\t\tif(practioner_type==\"P\"){practioner_type=\"Practioner\";}\n//\t\t\t\tif(practioner_type==\"O\"){practioner_type=\"OtherStaff\";}\n\t\t\t\tpract_id=arr[15];\n\t\t\t\tif(pract_id==\" \")pract_id=\"\";\n\t\t\t\tpractioner=decodeURIComponent(arr[16]);\t\t\t\n\t\t\t\tif(practioner==\" \")practioner=\"\";\n\t\t\t\tpract_staff_id=arr[21];\n\t\t\t\tif(pract_staff_id==\" \")pract_staff_id=\"\";\n\t\t\t\ttotal_pay=arr[17];\t\t\t\n\t\t\t\tif(total_pay==\" \")total_pay=\"\";\n\t\t\t\tpatient_pay=arr[18];\n\t\t\t\tif(patient_pay==\" \")patient_pay=\"\";\n\t\t\t\tpatient_paid=arr[19];\n\t\t\t\tif(patient_paid==\" \")patient_paid=\"\";\n\t\t\t\tcbflag=arr[20];\t\t\n\t\t\t\tif(cbflag==\" \")cbflag=\"\";\n\t\t\t\tratecharge_desc=arr[22];\n\t\t\t\tif(ratecharge_desc==\" \")ratecharge_desc=\"\";\n\t\t\t\tcharged_yn=arr[23];\n\t\t\t\tif(charged_yn==\" \")charged_yn=\"\";\n\n\t\t\t\toverride_yn=arr[24];\n\t\t\t\tif(override_yn==\" \")override_yn=\"\";\n\n\t\t\t//\tnet_amount=arr[25];\n\t\t\t//\tif(net_amount==\" \")net_amount=\"\";\n\n\t\t\t\tserv_amt_changed=arr[25];\n\t\t\t\tif(serv_amt_changed==\" \")serv_amt_changed=\"\";\n\n\t\t\t\texcl_incl_ind_for_screen = arr[26];\n\t\t\t\tif(excl_incl_ind_for_screen == \" \") excl_incl_ind_for_screen=\"\";\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\tvar record_select=count;\n\n\t\tfor(var j=totalRecords;j<count;j++ )\n\t\t{\n\t\t\t\tif(j % 2 == 0 )\n\t\t\t\t{\n\t\t\t\t\tclassval\t=\t\"QRYEVEN\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tclassval\t=\t\"QRYODD\";\n\t\t\t\t}\t\t\n\t\t\t\n\t\t\tcurr_row\t=\tformObj.ins_data.insertRow();\n\t\t\tcurr_row.id= \"row\"+eval(totalRecords+1);\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[0].className\t= classval;\n\t\t\tcurr_row.cells[0].WIDTH\t= \"9%\";\n\t\t\tcurr_row.cells[0].insertAdjacentHTML(\"beforeend\", \"<input type=\'checkbox\'  name=\'selected_row\"+j+\"\' id=\'selected_row\"+j+\"\' style=\'text-align:right\'  value=\'\' onClick=\'selected(\"+j+\");\' >\");\n\t\t\t//curr_row.cells[0].insertAdjacentHTML(\"beforeend\", \"<a onClick=\'modify_remove_payer(\"+j+\");\'><u>\"+record_select+\"</u></a>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[1].className\t= classval;\n\t\t\tcurr_row.cells[1].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[1].insertAdjacentHTML(\"beforeend\", \"<input maxlength=\'30\' size=\'10\' type=text readonly name=\'service\"+j+\"\' id=\'service\"+j+\"\'  value=\\\"\"+service+\"\\\" onFocus=\'check(\"+j+\");\' ><input type=hidden name=\'blng_serv_code\"+j+\"\' id=\'blng_serv_code\"+j+\"\' value=\\\"\"+blng_service_code+\"\\\"  >\");\n\t\t\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[2].className\t=classval;\n\t\t\tcurr_row.cells[2].WIDTH\t= \"18%\";\n\t\t\tcurr_row.cells[2].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'incl_excl\"+j+\"\' id=\'incl_excl\"+j+\"\'   value=\\\"\"+incl_excl+\"\\\" onFocus=\'check(\"+j+\");\' >\");\n\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[3].className\t=classval;\n\t\t\tcurr_row.cells[3].WIDTH\t= \"18%\";\n\t\t\tcurr_row.cells[3].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'incl_excl_action\"+j+\"\' id=\'incl_excl_action\"+j+\"\'   value=\\\"\"+incl_excl_action+\"\\\" onFocus=\'check(\"+j+\");\' >\");\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[4].";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block6_2 ="className\t=classval;\n\t\t\tcurr_row.cells[4].WIDTH\t= \"15%\";\n\t\t\tcurr_row.cells[4].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'5\' size=\'10\' readonly name=\'reason\"+j+\"\' id=\'reason\"+j+\"\'  value=\'\"+reason+\"\' onFocus=\'check(\"+j+\");\' ><input type=hidden name=\'action_reason_code\"+j+\"\' id=\'action_reason_code\"+j+\"\' value=\\\"\"+action_reason_code+\"\\\" >\");\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[5].className\t=classval;\n\t\t\tcurr_row.cells[5].WIDTH\t= \"5%\";\n\t\t\tcurr_row.cells[5].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'10\' readonly name=\'ratecharge_desc\"+j+\"\' id=\'ratecharge_desc\"+j+\"\'  value=\'\"+ratecharge_desc+\"\' onFocus=\'check(\"+j+\");\' ><input type=\'hidden\'  name=\'charge\"+j+\"\' id=\'charge\"+j+\"\'  value=\\\"\"+charge+\"\\\" onFocus=\'check(\"+j+\");\' >\");\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[6].className\t=classval;\n\t\t\tcurr_row.cells[6].WIDTH\t= \"15%\";\n\t\t\tcurr_row.cells[6].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'7\' size=\'10\' readonly name=\'original_qty\"+j+\"\' id=\'original_qty\"+j+\"\' style=\'text-align:right\'  value=\'\"+original_qty+\"\' onFocus=\'check(\"+j+\")\' style=\'text-align:right\' ><input type=hidden name=\'modify_qty_yn\"+j+\"\' id=\'modify_qty_yn\"+j+\"\' value=\\\"\"+modify_qty_yn+\"\\\" >\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[7].className\t=classval;\n\t\t\tcurr_row.cells[7].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[7].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'4\' readonly name=\'uom\"+j+\"\' id=\'uom\"+j+\"\'   value=\'\"+uom+\"\' onFocus=\'check(\"+j+\")\' ><input type=hidden name=\'uom_code\"+j+\"\' id=\'uom_code\"+j+\"\' value=\\\"\"+uom_code+\"\\\" >\");\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[8].className\t=classval;\n\t\t\tcurr_row.cells[8].WIDTH\t= \"20%\";\n\t\t\tcurr_row.cells[8].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'7\' size=\'10\' readonly name=\'revise_qty\"+j+\"\' id=\'revise_qty\"+j+\"\' style=\'text-align:right\'  value=\\\"\"+revise_qty+\"\\\" onFocus=\'check(\"+j+\");changeColor(\"+j+\");\' style=\'text-align:right\' ><input type=\'hidden\'  name=\'serv_amt_changed\"+j+\"\' id=\'serv_amt_changed\"+j+\"\'  value=\\\"\"+serv_amt_changed+\"\\\" onFocus=\'check(\"+j+\");\' >\");\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[9].className\t=classval;\n\t\t\tcurr_row.cells[9].WIDTH\t= \"4%\";\n\t\t\tcurr_row.cells[9].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'7\' size=\'10\' readonly name=\'total_qty\"+j+\"\' id=\'total_qty\"+j+\"\' style=\'text-align:right\'  value=\\\"\"+total_qty+\"\\\" onFocus=\'check(\"+j+\");\' style=\'text-align:right\'>\");\n\t\n\t\t\n\t\t\tcurr_row\t=\tformObj.ins_data.insertRow();\n\t\t\tcurr_row.id= \"row\"+eval(totalRecords+1);\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[0].className\t= classval;\n\t\t\tcurr_row.cells[0].WIDTH\t= \"9%\";\n\t\t\tcurr_row.cells[0].insertAdjacentHTML(\"beforeend\", \"\");\t\t\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[1].className\t=classval;\n\t\t\tcurr_row.cells[1].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[1].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'14\' readonly name=\'rate\"+j+\"\' id=\'rate\"+j+\"\' style=\'text-align:right\'  value=\\\"\"+rate+\"\\\" onFocus=\'check(\"+j+\");\' >\");\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[2].className\t=classval;\n\t\t\tcurr_row.cells[2].WIDTH\t= \"18%\";\n\t\t\tcurr_row.cells[2].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'10\' readonly name=\'practioner_type\"+j+\"\' id=\'practioner_type\"+j+\"\'  value=\\\"\"+practioner_type+\"\\\" onFocus=\'check(\"+j+\");\' ><input type=hidden name=\'pract_id\"+j+\"\' id=\'pract_id\"+j+\"\' value=\'\"+pract_id+\"\' >\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[3].className\t=classval;\n\t\t\tcurr_row.cells[3].WIDTH\t= \"18%\";\n\t\t\tcurr_row.cells[3].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'10\' readonly \tname=\'practioner\"+j+\"\' id=\'practioner\"+j+\"\'  value=\\\"\"+practioner+\"\\\" onFocus=\'check(\"+j+\");\' ><input type=hidden name=\'pract_staff_id\"+j+\"\' id=\'pract_staff_id\"+j+\"\' value=\'\"+pract_staff_id+\"\' >\");\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[4].className\t=classval;\n\t\t\tcurr_row.cells[4].WIDTH\t= \"15%\";\n\t\t\tcurr_row.cells[4].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'14\' readonly name=\'total_pay\"+j+\"\' id=\'total_pay\"+j+\"\' style=\'text-align:right\'  value=\\\"\"+total_pay+\"\\\" onFocus=\'check(\"+j+\");\' style=\'text-align:right\'>\");\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[5].className\t=classval;\n\t\t\tcurr_row.cells[5].WIDTH\t= \"5%\";\n\t\t\tcurr_row.cells[5].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'14\' readonly name=\'patient_pay\"+j+\"\' id=\'patient_pay\"+j+\"\' style=\'text-align:right\'  value=\\\"\"+patient_pay+\"\\\" onFocus=\'check(\"+j+\");\' style=\'text-align:right\' ><input type=hidden name=\'override_allowed_yn\"+j+\"\' id=\'override_allowed_yn\"+j+\"\' value=\\\"\"+override_yn+\"\\\" >\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[6].className\t=classval;\n\t\t\tcurr_row.cells[6].WIDTH\t= \"15%\";\n\t\t\tcurr_row.cells[6].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'14\' readonly name=\'patient_paid\"+j+\"\' id=\'patient_paid\"+j+\"\' style=\'text-align:right\'  value=\'\"+patient_paid+\"\' onFocus=\'check(\"+j+\");\' style=\'text-align:right\' ><input type=hidden name=\'charged_yn\"+j+\"\' id=\'charged_yn\"+j+\"\' value=\\\"\"+charged_yn+\"\\\" ><input type=hidden name=\'excl_incl_ind_for_screen\"+j+\"\' id=\'excl_incl_ind_for_screen\"+j+\"\' value=\\\"\"+excl_incl_ind_for_screen+\"\\\" >\");\t\t\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[7].className\t=classval;\n\t\t\tcurr_row.cells[7].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[7].insertAdjacentHTML(\"beforeend\", \"<input type=\'checkbox\' maxlength=\'30\' size=\'10\'  \"+cbflag+\"\tname=\'preappr_reqd\"+j+\"\' id=\'preappr_reqd\"+j+\"\' value=\"+cbflag+\" onFocus=\'check(\"+j+\");\' onclick=\'check_box(\"+j+\")\'>\");\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[8].className\t=classval;\n\t\t\tcurr_row.cells[8].WIDTH=\"20%\";\n\t\t\tcurr_row.cells[8].insertAdjacentHTML(\"beforeend\", \"\");\n\n\t\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[9].className\t=classval;\n\t\t\tcurr_row.cells[9].WIDTH=\"4%\";\n\t\t\tcurr_row.cells[9].insertAdjacentHTML(\"beforeend\", \"\");\n\n\t\t\trecord_select++;\n\t\t}\n\t\tformObj.total_records.value=count;\n\n\t\ttotpayable();\n\t}\n\telse\n\t{\n//\t\talert(\"closed\");\n\t}\n\t\n}\n\t\t\n\t\t\n\nasync function modifychargedet()\n{\n\tvar checked_row=parent.frames[2].document.forms[0].checked_row.value;\n\tvar episode_type=document.forms[0].h_episode_type.value;\n\tvar patient_id=document.forms[0].h_patient_id.value;\n\tvar visit_id=document.forms[0].h_visit_id.value;\n\tvar episode_id=document.forms[0].h_episode_id.value;\n\tvar service_date=document.forms[0].service_date.value;\n\tvar module_id=document.forms[0].h_module_id.value;\n\tvar include_label=document.forms[0].include_label.value;\n\tvar exclude_label=document.forms[0].exclude_label.value;\n\tvar str_encounter_id=document.forms[0].encounter_id.value;\n\tvar str_acc_seq_no=document.forms[0].acc_seq_no.value;\n\tvar service_panel_ind=document.forms[0].service_panel_ind.value;\n\tvar panel_qty=parent.frames[2].document.forms[0].panel_qty.value;\n/**Added by Ram ghl-1.2**/\n\t\tvar calledfrmencYN=document.forms[0].calledfrmencYN.value;\n\t\tvar bean_id_bl=document.forms[0].bean_id_bl.value;\n\t//\talert(\"calledfrmencYN btn\"+calledfrmencYN);\n\t//\talert(\"bean_id_bl btn\"+bean_id_bl);\n/**End **********************/\t\n\tvar str_epi_type_clinic_code=parent.frames[2].document.forms[0].str_epi_type_clinic_code.value;\n\tstr_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);\n\tvar cbflag=\"\";\n    var dirIndirChrgsFlag=  document.forms[0].dirIndirChrgsFlag.value;       \n\n\tvar p_order_id=document.forms[0].p_order_id.value;\n\tvar p_order_line_no=document.forms[0].p_order_line_no.value;\n//\tservice_date=convertDate(service_date,\'DMYHMS\',locale,\"en\"); \n\tif(checked_row==\"\")\n\t{\t\t\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\t\n\t\tvar service1=parent.frames[2].document.getElementById(\'service\'+checked_row);\n\t\tservice=service1.value;\t\n\n\t\tvar blng_serv_code1=parent.frames[2].document.getElementById(\'blng_serv_code\'+checked_row);\n\t\tblng_serv_code=blng_serv_code1.value;\t\n\t\t\n\t\t\n\t\tvar incl_excl1=parent.frames[2].document.getElementById(\'incl_excl\'+checked_row);\n\t\tincl_excl=incl_excl1.value;\t\t\n\t\t\n\t\t\n\n\t\tvar incl_excl_action1=parent.frames[2].document.getElementById(\'incl_excl_action\'+checked_row);\n\t\tincl_excl_action=incl_excl_action1.value;\t\t\n\n\n\t\tvar reason1=parent.frames[2].document.getElementById(\'reason\'+checked_row);\n\t\treason=reason1.value;\n\n\t\tvar action_reason_code1=parent.frames[2].document.getElementById(\'action_reason_code\'+checked_row);\n\t\taction_reason_code=action_reason_code1.value;\t\t\n\n\t\tvar ratecharge_desc1=parent.frames[2].document.getElementById(\'ratecharge_desc\'+checked_row);\n\t\tratecharge_desc=ratecharge_desc1.value;\n\t\t\n\n\t\tvar charge1=parent.frames[2].document.getElementById(\'charge\'+checked_row);\n\t\tcharge=charge1.value;\n\n\t\tvar original_qty1=parent.frames[2].document.getElementById(\'original_qty\'+checked_row);\n\t\toriginal_qty=original_qty1.value;\n\n\t\tvar modify_qty_yn1=parent.frames[2].document.getElementById(\'modify_qty_yn\'+checked_row);\n\t\tmodify_qty_yn=modify_qty_yn1.value;\n\t\t\n\t\tvar uom1=parent.frames[2].document.getElementById(\'uom\'+checked_row);\n\t\tuom=uom1.value;\n\n\t\tvar uom_code1=parent.frames[2].document.getElementById(\'uom_code\'+checked_row);\n\t\tuom_code=uom_code1.value;\n\n\t\tvar revise_qty1=parent.frames[2].document.getElementById(\'revise_qty\'+checked_row);\n\t\trevise_qty=revise_qty1.value;\n\n\t\tvar total_qty1=parent.frames[2].document.getElementById(\'total_qty\'+checked_row);\n\t\ttotal_qty=total_qty1.value;\n\n\t\tvar rate1=parent.frames[2].document.getElementById(\'rate\'+checked_row);\n\t\trate=rate1.value;\n\n\t\tvar practioner_type1=parent.frames[2].document.getElementById(\'practioner_type\'+checked_row);\n\t\tpractioner_type=practioner_type1.value;\n\t\t\n\t\tvar pract_id1=parent.frames[2].document.getElementById(\'pract_id\'+checked_row);\n\t\tpract_id=pract_id1.value;\n\t\t\t\t\n\t\tvar practioner1=parent.frames[2].document.getElementById(\'practioner\'+checked_row);\n\t\tpractioner=practioner1.value;\t\n\n\t\tvar pract_staff_id1=parent.frames[2].document.getElementById(\'pract_staff_id\'+checked_row);\n\t\tpract_staff_id=pract_staff_id1.value;\t\t\t\t\n\n\t\tvar total_pay1=parent.frames[2].document.getElementById(\'total_pay\'+checked_row);\n\t\ttotal_pay=total_pay1.value;\n\n\t\tvar patient_pay1=parent.frames[2].document.getElementById(\'patient_pay\'+checked_row);\n\t\tpatient_pay=patient_pay1.value;\n\n\t\tvar patient_paid1=parent.frames[2].document.getElementById(\'patient_paid\'+checked_row);\n\t\tpatient_paid=patient_paid1.value;\n\n\t\t\n\t\tvar cbflag1=parent.frames[2].document.getElementById(\'preappr_reqd\'+checked_row);\n\t\tif(cbflag1.checked)\n\t\t{\n\t\t\t cbflag=\"checked\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcbflag=\"\";\n\t\t}\n\t\tvar charged_yn1=parent.frames[2].document.getElementById(\'charged_yn\'+checked_row);\n\t\tch";
    private final static byte[]  _wl_block6_2Bytes = _getBytes( _wl_block6_2 );

    private final static java.lang.String  _wl_block6_3 ="arged_yn=charged_yn1.value;\n\t\t\n\t\tvar override_allowed_yn1=parent.frames[2].document.getElementById(\'override_allowed_yn\'+checked_row);\n\t\toverride_allowed_yn=override_allowed_yn1.value;\n\n\t\tvar serv_amt_changed=parent.frames[2].document.getElementById(\'serv_amt_changed\'+checked_row);\n\t\tserv_amt_changed=serv_amt_changed.value;\n\t\t\n\t\t\n\n\n\t\tvar retVal\t\t\t= new String();\n\t\t//var dialogTop = window.dialogTop;\n\t\tvar dialogTop = \"2vh\";\n\t\tvar dialogHeight = \"62vh\" ;\n\t\tvar dialogWidth = \"73vw\" ;\n\t\tvar dialogLeft=\"6\";\n\t\tvar features= \"dialogTop:\" + dialogTop+ \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";dialogLeft:\"+dialogLeft+\";status=no\" ;\n\n\t\t//var features\t\t\t= \"dialogTop:\"+eval(window.dialogTop+100)+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\n\t\tvar title=getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\t\t\t\n\tvar arguments\t\t\t= \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\n\n\n\n\t\t//var getString=document.forms[0].queryString.value;\n\t\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"&action=modify&service=\"+encodeURIComponent(service)+\"&blng_serv_code=\"+blng_serv_code+\"&incl_excl=\"+encodeURIComponent(incl_excl)+\"&incl_excl_action=\"+encodeURIComponent(incl_excl_action)+\"&reason=\"+encodeURIComponent(reason)+\"&action_reason_code=\"+action_reason_code+\"&charge=\"+charge+\"&original_qty=\"+original_qty+\"&uom=\"+encodeURIComponent(uom)+\"&uom_code=\"+uom_code+\"&revise_qty=\"+revise_qty+\"&total_qty=\"+total_qty+\"&rate=\"+rate+\"&practioner_type=\"+practioner_type+\"&practioner=\"+encodeURIComponent(practioner)+\"&pract_id=\"+pract_id+\"&pract_staff_id=\"+pract_staff_id+\"&total_pay=\"+total_pay+\"&patient_pay=\"+patient_pay+\"&patient_paid=\"+patient_paid+\"&cbflag=\"+cbflag+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&service_date=\"+service_date+\"&modify_qty_yn=\"+modify_qty_yn+\"&module_id=\"+module_id+\"&include_label=\"+encodeURIComponent(include_label)+\"&exclude_label=\"+encodeURIComponent(exclude_label)+\"&encounter_id=\"+str_encounter_id+\"&acc_seq_no=\"+str_acc_seq_no+\"&ratecharge_desc=\"+ratecharge_desc+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&charged_yn=\"+charged_yn+\"&service_panel_ind=\"+service_panel_ind+\"&override_allowed_yn=\"+override_allowed_yn+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&panel_qty=\"+panel_qty+\"&serv_amt_changed=\"+serv_amt_changed+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl+\"&dirIndirChrgsFlag=\"+dirIndirChrgsFlag;\n\t\t//alert(\"param:\"+param);\n\t\t\n\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDetailsValidationFrame.jsp?\"+param,arguments,features);\n\t\tvar formObj = parent.query2.document.edit_enter_main;\n\t\ttotal_records=formObj.total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\n//\t\tformObj.selected_row.checked=false;\n\t\tif(retVal!=null)\n\t\t{\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t\t\t\t  \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tformObj =  parent.query2.document.edit_enter_main;\n\t\t\t\tarr=retVal.split(\"::\");\t\n\n\t\t\t\tvar service1=eval(\"parent.frames[2].document.forms[0].service\"+checked_row);\n\t\t\t\tservice1.value=decodeURIComponent(arr[0]);\n\n\t\t\t\tvar blng_serv_code1=eval(\"parent.frames[2].document.forms[0].blng_serv_code\"+checked_row);\n\t\t\t\tblng_serv_code1.value=arr[1];\n\n\t\t\t\tvar incl_excl1=eval(\"parent.frames[2].document.forms[0].incl_excl\"+checked_row);\n\t\t\t\tincl_excl1.value=arr[2];\n\t\t\t\tvar incl_excl_action1=eval(\"parent.frames[2].document.forms[0].incl_excl_action\"+checked_row);\n\t\t\t\tincl_excl_action1.value=arr[3];\n\t\t\t\tvar reason2=eval(\"parent.frames[2].document.forms[0].reason\"+checked_row);\n\t\t\t\treason2.value=decodeURIComponent(arr[4]);\n\t\t\t\tvar action_reason_code1=eval(\"parent.frames[2].document.forms[0].action_reason_code\"+checked_row);\n\t\t\t\taction_reason_code1.value=arr[5];\n\n\t\t\t\tvar ratecharge_desc1=eval(\"parent.frames[2].document.forms[0].ratecharge_desc\"+checked_row);\n\t\t\t\tratecharge_desc1.value=arr[22];\n\n\t\t\t\tvar charge1=eval(\"parent.frames[2].document.forms[0].charge\"+checked_row);\n\t\t\t\tcharge1.value=arr[6];\n\t\t\t\tvar original_qty1=eval(\"parent.frames[2].document.forms[0].original_qty\"+checked_row);\n\t\t\t\toriginal_qty1.value=arr[7];\t\n\t\t\t\t\n\t\t\t\tvar modify_qty_yn1=eval(\"parent.frames[2].document.forms[0].modify_qty_yn\"+checked_row);\n\t\t\t\tmodify_qty_yn1.value=arr[8];\t\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar uom1=eval(\"parent.frames[2].document.forms[0].uom\"+checked_row);\n\t\t\t\tuom1.value=decodeURIComponent(arr[9]);\t\n\t\t\t\t\n\t\t\t\tvar uom_code1=eval(\"parent.frames[2].document.forms[0].uom_code\"+checked_row);\n\t\t\t\tuom_code1.value=arr[10];\t\n\t\t\t\t\n\t\t\t\tvar revise_qty1=eval(\"parent.frames[2].document.forms[0].revise_qty\"+checked_row);\n\t\t\t\trevise_qty1.value=arr[11];\n\t\t\t\tvar total_qty1=eval(\"parent.frames[2].document.forms[0].total_qty\"+checked_row);\n\t\t\t\ttotal_qty1.value=arr[12];\n\t\t\t\tvar rate1=eval(\"parent.frames[2].document.forms[0].rate\"+checked_row);\n\t\t\t\trate1.value=arr[13];\n\t\t\t\tvar practioner_type1=eval(\"parent.frames[2].document.forms[0].practioner_type\"+checked_row);\n\t\t\t\tpractioner_type1.value=arr[14];\n\n\t\t\t\tvar pract_id1=eval(\"parent.frames[2].document.forms[0].pract_id\"+checked_row);\n\t\t\t\tpract_id1.value=arr[15];\n\n\t\t\t\tvar practioner1=eval(\"parent.frames[2].document.forms[0].practioner\"+checked_row);\n\t\t\t\tpractioner1.value=decodeURIComponent(arr[16]);\n\n\t\t\t\tvar pract_staff_id1=eval(\"parent.frames[2].document.forms[0].pract_staff_id\"+checked_row);\n\t\t\t\tpract_staff_id1.value=arr[21];\n\n\t\t\t\tvar total_pay1=eval(\"parent.frames[2].document.forms[0].total_pay\"+checked_row);\n\t\t\t\ttotal_pay1.value=arr[17];\n\t\t\t\tvar patient_pay1=eval(\"parent.frames[2].document.forms[0].patient_pay\"+checked_row);\n\t\t\t\tpatient_pay1.value=arr[18];\n\n\t\t\t\tvar patient_paid1=eval(\"parent.frames[2].document.forms[0].patient_paid\"+checked_row);\n\t\t\t\tpatient_paid1.value=arr[19];\n\n\t\t\t\tvar cbflag1=eval(\"parent.frames[2].document.forms[0].preappr_reqd\"+checked_row);\n\t\t\t\tcbflag1.checked=arr[20];\n\t\t\t\tvar ckcbflag=arr[20];\n\t\t\t\t//alert(\"ckcbflag :\"+ckcbflag);\n\t\t\t\tif(ckcbflag==\"checked\")\n\t\t\t\t{\t\n\t\t\t\t\tcbflag1.checked=true;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tcbflag1.checked=false;\n\t\t\t\t}\n\t\t\t\tvar charged_yn1=eval(\"parent.frames[2].document.forms[0].charged_yn\"+checked_row);\n\t\t\t\tcharged_yn1.value=arr[23];\n\n\t\t\t\t//alert(\"arr[24] \"+arr[24]);\n\n\t\t\t\tvar override_allowed_yn1=eval(\"parent.frames[2].document.forms[0].override_allowed_yn\"+checked_row);\n\t\t\t\toverride_allowed_yn1.value=arr[24];\n\n\t\t\t\tvar serv_amt_changed=eval(\"parent.frames[2].document.forms[0].serv_amt_changed\"+checked_row);\n\t\t\t\tserv_amt_changed.value=arr[25];\n\n\t\t\t\tvar excl_incl_ind_for_screen=eval(\"parent.frames[2].document.forms[0].excl_incl_ind_for_screen\"+checked_row);\n\t\t\t\texcl_incl_ind_for_screen.value=arr[26];\n\t\t\t\t\n\n\n\n\n\n\t\t}\n\t\t}\n\t\ttotpayable();\n\t\t}\n\t\telse\n\t\t{\n//\t\t\talert(\"closed\");\n\t\t}\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n}\n\nfunction removechargedet()\n{\n\tvar checked_row=parent.frames[2].document.forms[0].checked_row.value;\n\tvar queryString=document.forms[0].queryString.value;\n\tvar formObj = parent.parent.query2.document.edit_enter_main;\n\tvar total_records=formObj.total_records.value;\n\tvar confirm_check = false;\n\tvar single_rec_check = \"N\";\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\t\n\tif(checked_row==\"\")\n\t{\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tif(total_records==1)\n\t\t{\t\t\t\n\t\t\tif(!confirm(getMessage(\"BL6197\",\"BL\")))\n\t\t\t{\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t\t{\n\t\t\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\t\t\ttemp.checked=false;\n\t\t\t\t}\n\t\t\t\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tsingle_rec_check = \"Y\";\n\t\t\t\tconfirm_check = true;\n\t\t\t}\n\t\t}\n\n\t\tif(single_rec_check == \"N\")\n\t\t{\n\t\t\tconfirm_check = confirm(getMessage(\"DELETE_RECORD\",\"common\"));\n\t\t}\n\t\tif(confirm_check) //BL9760\n\t\t{\n\t\t\ttotalRecords =eval(formObj.total_records.value);\n\t\t\t//Added by karthik on Oct-18-2012 to default select a practitioner\n\t\t\tvar practioner=eval(\"parent.frames[2].document.forms[0].practioner0\");\t\n\t\t\tvar practioner_id=eval(\"parent.frames[2].document.forms[0].pract_id0\");\n\t\t\tvar pract_staff_id=eval(\"parent.frames[2].document.forms[0].pract_staff_id0\");\n\t\t\tvar URL=\"../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&\"+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+queryString;\n\t\t\tif(totalRecords==1)\n\t\t\t{\n\t\t\tURL=\"../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&\"+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+queryString+\"&set_session_practitioner=\"+practioner.value+\"&set_session_pract_staff_ind=\"+practioner_id.value+\"&set_session_pract_staff_id=\"+pract_staff_id.value;\n\t\t\t}\n\t\t\tparent.frames[2].document.forms[0].action=URL;\n\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t}\n\t\telse\n\t\t{\n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\t\ttemp.checked=false;\n\t\t\t}\n\t\t\treturn false;\t\t\t\n\t\t}\n\t}\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n\t\n}\n\n/*function removechargedet()\n{\n\tvar cbglag=\"\";\n\tvar checked_row=parent.frames[2].document.forms[0].checked_row.value;\n\tvar include_label=document.forms[0].include_label.value;\n\tvar exclude_label=document.forms[0].exclude_label.value;\n\tvar p_string=parent.frames[2].document.forms[0].p_string.value;\n\tvar queryString=document.forms[0].queryString.value;\n\tvar str_epi_type_clinic_code=parent.frames[2].document.forms[0].str_epi_type_clinic_code.value;\n\tstr_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);\n\tif(checked_row==\"\")\n\t{\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tvar service1=eval(\"parent.frames[2].document.forms[0].service\"+checked_row);\n\t\tservice=service1.value;\n\t\t\n\t\tvar blng_serv_code1=eval(\"parent.frames[2].document.forms[0].blng_serv_code\"+checked_row);\n\t\tblng_serv_code=blng_serv_code1.value;\n\n\t\tvar incl_excl1=eval(\"parent.frames[2].document.forms[0].incl_excl\"+checked_row);\n\t\tincl_excl=incl_excl1.value;\n\n\t\tvar incl_excl_action1=eval(\"parent.frames[2].document.forms[0].incl_excl_action\"+checked_row);\n\t\tincl_excl_action=incl_excl_action1.value;\n\n\t\tvar reason1=eval(\"parent.frames[2].document.forms[0].reason\"+checked_row);\n\t\treason=reason1.value;\n\n\t\tvar action_reason_code1=eval(\"parent.frames[2].document.forms[0].action_reason_code\"+checked_row);\n\t\taction_reason_code=action_reason_code1.value;\n\n\t\tvar ratecharge_desc1=eval(\"";
    private final static byte[]  _wl_block6_3Bytes = _getBytes( _wl_block6_3 );

    private final static java.lang.String  _wl_block6_4 ="parent.frames[2].document.forms[0].ratecharge_desc\"+checked_row);\n\t\tratecharge_desc=ratecharge_desc1.value;\n\t\t\n\n\t\tvar charge1=eval(\"parent.frames[2].document.forms[0].charge\"+checked_row);\n\t\tcharge=charge1.value;\n\n\t\tvar original_qty1=eval(\"parent.frames[2].document.forms[0].original_qty\"+checked_row);\n\t\toriginal_qty=original_qty1.value;\n\n\t\tvar modify_qty_yn1=eval(\"parent.frames[2].document.forms[0].modify_qty_yn\"+checked_row);\n\t\tmodify_qty_yn=modify_qty_yn1.value;\n\n\t\tvar uom1=eval(\"parent.frames[2].document.forms[0].uom\"+checked_row);\n\t\tuom=uom1.value;\n\n\t\tvar uom_code1=eval(\"parent.frames[2].document.forms[0].uom_code\"+checked_row);\n\t\tuom_code=uom_code1.value;\n\t\t\t\t\n\t\tvar revise_qty1=eval(\"parent.frames[2].document.forms[0].revise_qty\"+checked_row);\n\t\trevise_qty=revise_qty1.value;\n\n\t\tvar total_qty1=eval(\"parent.frames[2].document.forms[0].total_qty\"+checked_row);\n\t\ttotal_qty=total_qty1.value;\n\n\t\tvar rate1=eval(\"parent.frames[2].document.forms[0].rate\"+checked_row);\n\t\trate=rate1.value;\n\n\t\tvar practioner_type1=eval(\"parent.frames[2].document.forms[0].practioner_type\"+checked_row);\n\t\tpractioner_type=practioner_type1.value;\n\n\t\tvar pract_id1=eval(\"parent.frames[2].document.forms[0].pract_id\"+checked_row);\n\t\tpract_id=pract_id1.value;\n\n\t\tvar practioner1=eval(\"parent.frames[2].document.forms[0].practioner\"+checked_row);\n\t\tpractioner=practioner1.value;\t\t\n\n\t\tvar pract_staff_id1=eval(\"parent.frames[2].document.forms[0].pract_staff_id\"+checked_row);\n\t\tpract_staff_id=pract_staff_id1.value;\t\n\n\t\tvar total_pay1=eval(\"parent.frames[2].document.forms[0].total_pay\"+checked_row);\n\t\ttotal_pay=total_pay1.value;\n\n\t\tvar patient_pay1=eval(\"parent.frames[2].document.forms[0].patient_pay\"+checked_row);\n\t\tpatient_pay=patient_pay1.value;\n\n\t\tvar patient_paid1=eval(\"parent.frames[2].document.forms[0].patient_paid\"+checked_row);\n\t\tpatient_paid=patient_paid1.value;\n\n\t\tvar cbflag1=eval(\"parent.frames[2].document.forms[0].preappr_reqd\"+checked_row);\t\t\t\n\t\t\t\tif(cbflag1.checked)\n\t\t\t\t{\t\n\t\t\t\t\tcbflag=\"checked\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tcbflag=\"\";\n\t\t\t\t}\n\t\tvar charged_yn1=eval(\"parent.frames[2].document.forms[0].charged_yn\"+checked_row);\n\t\tcharged_yn=charged_yn1.value;\n\n\t\tvar override_allowed_yn1=eval(\"parent.frames[2].document.forms[0].override_allowed_yn\"+checked_row);\n\t\toverride_allowed_yn=override_allowed_yn1.value;\n\t\t//alert(\"override_allowed_yn btn:\"+override_allowed_yn);\n\n\t\n\t\tvar retVal\t= new String();\n/*\n\t\tvar dialogTop = \"100\";\n\t\tvar dialogHeight = \"20\" ;\n\t\tvar dialogWidth = \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n*/\n/*\t\tvar dialogTop = window.dialogTop;\n\t\tvar dialogHeight = \"20\" ;\n\t\tvar dialogWidth = \"40\" ;\n\t\tvar dialogLeft=\"360\";\n\t\tvar features= \"dialogTop:\" + (eval((dialogTop.substr(0,(dialogTop.indexOf(\'px\')))))+115) + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";dialogLeft:\"+dialogLeft+\";status=no\" ;\n\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar title=getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\t\t\t\n\t\t//var getString=document.forms[0].queryString.value;\n\t\tvar param = \"title=\"+title+\"&action=remove&service=\"+encodeURIComponent(service)+\"&blng_serv_code=\"+blng_serv_code+\"&incl_excl=\"+incl_excl+\"&incl_excl_action=\"+incl_excl_action+\"&reason=\"+encodeURIComponent(reason)+\"&action_reason_code=\"+action_reason_code+\"&charge=\"+charge+\"&original_qty=\"+original_qty+\"&uom=\"+encodeURIComponent(uom)+\"&uom_code=\"+uom_code+\"&revise_qty=\"+revise_qty+\"&total_qty=\"+total_qty+\"&rate=\"+rate+\"&practioner_type=\"+practioner_type+\"&pract_id=\"+pract_id+\"&practioner=\"+practioner+\"&pract_staff_id=\"+pract_staff_id+\"&total_pay=\"+total_pay+\"&patient_pay=\"+patient_pay+\"&patient_paid=\"+patient_paid+\"&cbflag=\"+cbflag+\"&modify_qty_yn=\"+modify_qty_yn+\"&include_label=\"+include_label+\"&exclude_label=\"+exclude_label+\"&p_string=\"+p_string+\"&ratecharge_desc=\"+ratecharge_desc+\"&charged_yn=\"+charged_yn+\"&override_allowed_yn=\"+override_allowed_yn+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code;\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDetailsValidationFrame.jsp?\"+param,arguments,features);\n\t\tvar formObj = parent.parent.query2.document.edit_enter_main;\n\t\ttotal_records=formObj.total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n//\t\tformObj.selected_row.checked=false;\n\t\tif(\tretVal!=null)\n\t\t{\n\t\t\tvar ret_val=retVal;\n//\t\t\talert(\"retVal from 4\" +retVal);\n\t\t\tif(ret_val==\"remove\")\n\t\t\t{\t\n\t\t\t\t\ttotalRecords =eval(formObj.total_records.value);\n\t\t\t\t\t//count =totalRecords - 1; \n\t\t\t\t\t//formObj.total_records.value=count;\t\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?remove_check=remove&\"+getString+\"&checked_row=\"+checked_row;\n\t\t\t\t\tparent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&\"+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+queryString;\n\t\t\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n//\t\t\talert(\"closed\");\n\t\t}\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n}*/\n\nfunction add_servicesYN()\n{\t\n//\tvar add_services_yn=parent.frames[0].document.forms[0].add_services_yn.value;\n\tvar add_services_yn=document.forms[0].add_services_yn.value;\n\tvar service_panel_ind=document.forms[0].service_panel_ind.value;\n//\talert(\"add_services_yn:\"+add_services_yn);\nif(add_services_yn==\"N\" || service_panel_ind==\"S\")\n\t{\t\n\tdocument.forms[0].add_serv_button.disabled=true;\t\n\tdocument.forms[0].remove_button.disabled=true;\t\n\t}\nelse{\t\t\n\tif(add_services_yn==\"Y\" || service_panel_ind==\"L\")\n\t{\t\t\n\tdocument.forms[0].add_serv_button.disabled=false;\t\n\tdocument.forms[0].remove_button.disabled=false;\n\t}\n}\n}\n//add_servicesYN();\n\nfunction totpayable()\n{\n\tvar totalpayable=0.0;\n\tvar patientpayable=0.0;\n\tvar patientpaid=0.00;\n\tvar totpayable=\"\";\n\tvar patpayable=\"\";\n\tvar patpaid=\"\";\n\tvar a1=new Array();var a2=new Array();var a3=new Array();\n\tvar formObj = parent.query2.document.edit_enter_main;\n\tvar\ttotalRecords =eval(formObj.total_records.value);\t\n\tvar decimal=document.forms[0].noofdecimal.value;\n\tfor(var i=0;i<totalRecords;i++)\n\t{\n\t  totpayable=eval(\"parent.frames[2].document.forms[0].total_pay\"+i);\n\t  patpayable=eval(\"parent.frames[2].document.forms[0].patient_pay\"+i);\n\t  patpaid=eval(\"parent.frames[2].document.forms[0].patient_paid\"+i);\n\t  a1[i]=totpayable.value;\n\t  if(a1[i]==\"\"){a1[i]=\"0.0\";}\n\t  totalpayable=parseFloat(totalpayable) + parseFloat(a1[i]);\n\t  a2[i]=patpayable.value;\t  \n\t  if(a2[i]==\"\"){a2[i]=\"0.0\";}\n\t  patientpayable=parseFloat(patientpayable) + parseFloat(a2[i]);\n\n\t  a3[i]=patpaid.value;\n\t  if(a3[i]==\"\") a3[i]=\"0.0\";\n\t  patientpaid=parseFloat(patientpaid) + parseFloat(a3[i]);\n\t}\t\n\t/*totalpayable=totalpayable.valueOf();\n\tpatientpayable=patientpayable.valueOf();\n\ttotalpayable=totalpayable+\"\";\n\tpatientpayable=patientpayable+\"\";\n\talert(\"patientpayable :\"+patientpayable);\n\tvar l1_length=totalpayable.indexOf(\'.\');\n\tvar l2_length=patientpayable.indexOf(\'.\');\n\tif(l1_length>=0)\n\t{\n\tvar t2=(totalpayable.substring(l1_length+1,totalpayable.length)).length;\n\tif(t2==1)\n\t\ttotalpayable=totalpayable+\"0\";\n\t}\n\tif(l2_length>=0)\n\t{\n\tvar t2=(patientpayable.substring(l1_length+1,patientpayable.length)).length;\n\tif(t2==1)\n\t\tpatientpayable=patientpayable+\"0\";\n\talert(\"patientpayable 1:\"+patientpayable);\n\t}*/\t\n\ttotalpayable = totalpayable.toFixed(decimal);\n\tpatientpayable = patientpayable.toFixed(decimal);\n\tpatientpaid = patientpaid.toFixed(decimal);\n\n\tdocument.forms[0].total.value=totalpayable;\n\tvar totp=eval(\"document.forms[0].total\")\n\tputdeci(totp);\n\tdocument.forms[0].patient.value=patientpayable;\n\tvar patp=eval(\"document.forms[0].patient\")\n\tputdeci(patp);\n\n\tdocument.forms[0].patient_paid.value=patientpaid;\t\n\tvar patpd=eval(\"document.forms[0].patient_paid\");\n\t\n\tputdeci(patpd);\n}\n\nfunction putdeci(object)\n{\n\tvar decimal=document.forms[0].noofdecimal.value;\n\tif(object.value!=\'\')\n\t{\n\t\tputDecimal(object,17,decimal);\n\t}\n\t\n}\n\n\nfunction cancel(obj)\n{\n\t//parent.window.close();\n\tparent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length-1].close();\n}\n</script>\n\t\t\t<title>\t\t\t\n\t\t\t</title>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\t";
    private final static byte[]  _wl_block6_4Bytes = _getBytes( _wl_block6_4 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t</head>\n\t\t<body onLoad=\"totpayable();\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form>\n\t\t<table cellpadding=3 cellspacing=0  width=\"100%\">\n\t\t\t<tr>\n\t\t\t<td width=\'15%\'  class=\'label\'></td>\n\t\t\t<td width=\'15%\'  class=\'label\'></td>\n\t\t\t<td width=\'15%\' class=\'label\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></td>\n\t\t\t<td width=\'10%\' class=\"fields\"><input type=\'text\' name=\'total\' id=\'total\' size=\'14\' maxlength=\'30\' \n\t\t\tvalue=\'\' readonly style=\'text-align:right\' ></td>\n\t\t\t <td class=\"fields\"><input type=\'text\' name=\'patient\' id=\'patient\' size=\'14\'  maxlength=\'30\' value=\'\' readonly style=\'text-align:right\'></td>\n\t\t\t <td class=\"fields\"><input type=\'text\' name=\'patient_paid\' id=\'patient_paid\' size=\'14\'  maxlength=\'30\' value=\'\' readonly style=\'text-align:right\'></td>\n\t\t\t <td width=\'15%\'  class=\'label\'></td>\n\t\t\t<td width=\'15%\' class=\'label\'></td>\n\t\t\t</tr>\n\t  </table>\n\t\t\t<table cellpadding=3 cellspacing=0  width=\"100%\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t <tr>\n\t\t <td width=\"25%\"  class=\'labels\'>\t</td>\n\t\t <td width=\"25%\"  class=\'labels\'>\t</td>\n\t\t <td width=\"25%\"  class=\'labels\'>\n\t\t\t<input type=\'button\' class=\'button\' onclick=\'addchargedet()\' name=\'add_serv_button\' id=\'add_serv_button\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n\t\t\t <input type=\'button\' class=\'button\' onclick=\'modifychargedet()\' name=\'modify_serv_button\' id=\'modify_serv_button\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >\n\t\t\t <input type=\'button\' class=\'button\' onclick=\'removechargedet()\' name=\"remove_button\" id=\"remove_button\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" ></td>\n\t\t <td width=\"25%\"  class=\'labels\'>\t\t \n\t\t\t <input type=\'button\' class=\'button\' onclick=\'acceptvalidation()\' name=\"accept_button\" id=\"accept_button\"  value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t\t <input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" class=\'button\' onClick=\'cancel(event)\'></td>\n\t\t</td>\n\t\t</tr>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<td width=\"25%\"  class=\'label\'>\t</td>\n\t\t\t\t<td width=\"25%\"  class=\"label\">\t</td>\n\t\t\t\t<td width=\"25%\"  class=\"label\">\t</td>\n\t\t\t\t<td width=\"25%\"  class=\"label\">\n\t\t\t\t<input type=\'button\' class=\'button\' onclick=\'modifychargedet()\' name=\'modify_serv_button\' id=\'modify_serv_button\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t\t\t<input type=\'button\' class=\'button\' onclick=\'acceptvalidation()\' name=\"accept_button\" id=\"accept_button\"  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t\t\t<input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\'button\' onClick=\'cancel(event)\'></td>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t</table>\n<input type= hidden name=\"queryString\" id=\"queryString\"  value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type= hidden name=\"h_episode_type\" id=\"h_episode_type\"  value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type= hidden name=\"h_patient_id\" id=\"h_patient_id\"  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type= hidden name=\"h_visit_id\" id=\"h_visit_id\"  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type= hidden name=\"h_episode_id\" id=\"h_episode_id\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type= hidden name=\"service_date\" id=\"service_date\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type= hidden name=\"count1\" id=\"count1\"  value=\'\'>\n<input type= hidden name=\"h_module_id\" id=\"h_module_id\"  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'orig_qty\' id=\'orig_qty\' id=\'orig_qty\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\n\n<input type= \'hidden\' name=\'cbflag\' id=\'cbflag\'  value=\'\'>\n<input type= \'hidden\' name=\'p_str\' id=\'p_str\'  value=\'\'>\n<input type= \'hidden\' name=\'p_str1\' id=\'p_str1\'  value=\'\'>\n<input type= hidden name=\"add_services_yn\" id=\"add_services_yn\"  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\t\n<input type= \'hidden\' name=\'accept_chk\' id=\'accept_chk\'  value=\'Y\'>\n<input type=\'hidden\' name=\'service_panel_ind\' id=\'service_panel_ind\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n<input type=\'hidden\' name=\'acc_seq_no\' id=\'acc_seq_no\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\n<input type=\'hidden\' name=\'dirIndirChrgsFlag\' id=\'dirIndirChrgsFlag\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n<input type=\'hidden\' name=\'include_label\' id=\'include_label\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n<input type=\'hidden\' name=\'exclude_label\' id=\'exclude_label\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n<input type=\'hidden\' name=\'rate_label\' id=\'rate_label\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n<input type=\'hidden\' name=\'charge_label\' id=\'charge_label\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\n<input type=\'hidden\' name=\'p_order_id\' id=\'p_order_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n<input type=\'hidden\' name=\'p_order_line_no\' id=\'p_order_line_no\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n<input type=\'hidden\' name=\'str_or_key_line_no\' id=\'str_or_key_line_no\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\n<input type=\'hidden\' name=\'str_or_key\' id=\'str_or_key\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n<input type=\'hidden\' name=\'str_or_bean_id\' id=\'str_or_bean_id\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\n<input type=\'hidden\' name=\'bean_id_bl\' id=\'bean_id_bl\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n<input type=\'hidden\' name=\'calledfrmencYN\' id=\'calledfrmencYN\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\n<input type=\'hidden\' name=\'incl_excl_action_code_to_or\' id=\'incl_excl_action_code_to_or\' value=\'\' >\n<input type=\'hidden\' name=\'action_reason_code_to_or\' id=\'action_reason_code_to_or\' value=\'\' >\n<input type=\'hidden\' name=\'excl_incl_ind_for_screen\' id=\'excl_incl_ind_for_screen\' value=\'\' >\n<input type=\'hidden\' name=\'override_yn\' id=\'override_yn\' value=\'\' >\n\n<input type=\'hidden\' name=\'rate_temp\' id=\'rate_temp\' value=\'\' >\n\n\n<input type=\'hidden\' name=\'mod_pract_ind\' id=\'mod_pract_ind\' value=\'\' >\n<input type=\'hidden\' name=\'mod_physician_id\' id=\'mod_physician_id\' value=\'\' >\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");		
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs23 = null; ResultSet rscurr=null;			
	String queryString="";
	String p_episode_type=""; String p_patient_id=""; String p_visit_id="";String p_episode_id="";
	String locale	= (String)session.getAttribute("LOCALE");
	String p_module_id="";String p_service_date=""; String p_service_panel_ind=""; String p_service_panel_code="";
	String include_label="";String exclude_label="";String stradd_services_during_entry_yn="";
	String facility_id="";	String str_encounter_id="";	String str_acct_seq_no="";String rate_label="";
	String charge_label="";String p_order_id=""; String p_order_line_no=""; 
	String str_or_bean_id=""; // Added for BL_OR Enhancement
	String str_or_key ="";String str_or_key_line_no="";
	String dirIndirChrgsFlag=""; 
	int noofdecimal=2;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");		
	con	=	ConnectionManager.getConnection(request);
	String orig_qty="";
	/****ghl-crf-1.2**************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	//String bean_name_bl="";
//	HashMap finDtls		= new HashMap();
	/******end*******************/ 

	try
	{
		
		
		 orig_qty=request.getParameter("original_qty");
		System.out.println("original_qty"+orig_qty);
		facility_id = (String)httpSession.getValue("facility_id");
		//login_user =  p.getProperty("login_user");
		queryString=(request.getQueryString());
//		System.out.println("queryString btn"+queryString);
		p_episode_type = request.getParameter("episode_type");
		if(p_episode_type==null || p_episode_type.equals("")) p_episode_type="";
		p_patient_id = request.getParameter("patient_id");
		if(p_patient_id==null || p_patient_id.equals("")) p_patient_id="";
		p_visit_id = request.getParameter("visit_id");
		if(p_visit_id==null || p_visit_id.equals("")) p_visit_id="0";
		p_episode_id = request.getParameter("episode_id");
		if(p_episode_id==null || p_episode_id.equals("")) p_episode_id="0";
		p_module_id = request.getParameter("module_id");
		if(p_module_id==null || p_module_id.equals("")) p_module_id="";
		p_service_date = request.getParameter("service_date");			
		if(p_service_date==null || p_service_date.equals("")) p_service_date="";
//		p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS","en",locale);
		p_service_panel_ind = request.getParameter("service_panel_ind");
		if(p_service_panel_ind==null || p_service_panel_ind.equals("")) p_service_panel_ind="";		
		p_service_panel_code = request.getParameter("service_panel_code");
		if(p_service_panel_code==null || p_service_panel_code.equals("")) p_service_panel_code="";		
		dirIndirChrgsFlag = request.getParameter("dirIndirChrgsFlag");
		if(dirIndirChrgsFlag==null || dirIndirChrgsFlag.equals("")) dirIndirChrgsFlag="";		
		/*include_label=request.getParameter("include_label");
		if(include_label==null || include_label.equals("")) include_label="";
		exclude_label=request.getParameter("exclude_label");
		if(exclude_label==null || exclude_label.equals("")) exclude_label="";
		rate_label=request.getParameter("rate_label");
		if(rate_label==null || rate_label.equals("")) rate_label="";		
		charge_label=request.getParameter("charge_label");
		if(charge_label==null || charge_label.equals("")) charge_label="";*/
		p_order_id = request.getParameter("order_id");
		if(p_order_id==null || p_order_id.equals("")) p_order_id="";	
		p_order_line_no= request.getParameter("order_line_no");
		if(p_order_line_no==null || p_order_line_no.equals("")) p_order_line_no="";	
		include_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels");
		exclude_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.Excluded.label","bl_labels");
		rate_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.RATE.label","bl_labels");
		charge_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Charge.label","common_labels");
	/****ghl-crf-1.2*************/	
		calledfrmencYN=request.getParameter("patregnchargeYN");
		if(calledfrmencYN==null) calledfrmencYN="";
	/******end*******************/
		if(calledfrmencYN.equals("Y"))
		{
			bean_id_bl=request.getParameter("bean_id");
			if(bean_id_bl==null) bean_id_bl="";
		}else{			
			str_or_bean_id=request.getParameter("bean_id");
			if(str_or_bean_id==null) str_or_bean_id="";
		}
			
		str_or_key=request.getParameter("key");
		if(str_or_key==null) str_or_key="";

		str_or_key_line_no=request.getParameter("key_line_no");
		if(str_or_key_line_no==null) str_or_key_line_no="";

		str_encounter_id=request.getParameter("encounter_id");
		if(str_encounter_id==null || str_encounter_id.equals("")) str_encounter_id="0";
		str_acct_seq_no=request.getParameter("acct_seq_no");
		if(str_acct_seq_no==null || str_acct_seq_no.equals("")) str_acct_seq_no="0";
		String sql_pan_desc= "";
		if(p_service_panel_ind.equals("L"))
		{
// Commented for PE Changes
//			sql_pan_desc= "SELECT nvl(add_services_during_entry,'N') FROM bl_panel_hdr_lang_vw WHERE OPERATING_FACILITY_ID  ='"+facility_id+"'AND  panel_code = '"+p_service_panel_code+"' AND language_id='"+locale+"'";

			sql_pan_desc= "SELECT nvl(add_services_during_entry,'N') FROM bl_panel_hdr WHERE OPERATING_FACILITY_ID  ='"+facility_id+"'AND  panel_code = '"+p_service_panel_code+"'";
			pstmt = con.prepareStatement(sql_pan_desc);
			rs23 = pstmt.executeQuery() ;
			if( rs23 != null ) 
			{
				while( rs23.next() )
				{  
					stradd_services_during_entry_yn =  rs23.getString(1);
					if(stradd_services_during_entry_yn==null) stradd_services_during_entry_yn="";
				}//while
			}//if 
				rs23.close();
				pstmt.close();
		 }
			else
			{
				stradd_services_during_entry_yn="N";
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
			}catch(Exception e) {System.out.println("3="+e.toString());}

	}catch(Exception eX)
	{	
		out.println("Error= "+eX);			
	}
	finally{
		if(con!=null) {
		ConnectionManager.returnConnection(con, request);
						}
		}

            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
            _bw.write(_wl_block6_2Bytes, _wl_block6_2);
            _bw.write(_wl_block6_3Bytes, _wl_block6_3);
            _bw.write(_wl_block6_4Bytes, _wl_block6_4);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
	
//		System.out.println("p_service_panel_ind:"+p_service_panel_ind);
//		System.out.println("stradd_services_during_entry_yn:"+stradd_services_during_entry_yn);
		if(p_service_panel_ind.equals("L") && stradd_services_during_entry_yn.equals("Y"))
		{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
			else if((p_service_panel_ind.equals("S") || p_service_panel_ind.equals("L"))  && stradd_services_during_entry_yn.equals("N"))
			{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);

			}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_episode_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_visit_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_episode_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_service_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(orig_qty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(stradd_services_during_entry_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_service_panel_ind));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str_acct_seq_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dirIndirChrgsFlag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(include_label));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(exclude_label));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rate_label));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(charge_label));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_order_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p_order_line_no));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_or_key_line_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(str_or_key));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(str_or_bean_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean_id_bl));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(calledfrmencYN));
            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
}
