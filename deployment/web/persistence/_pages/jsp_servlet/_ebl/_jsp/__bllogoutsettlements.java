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
import webbeans.op.CurrencyFormat;
import java.util.*;
import com.ehis.util.*;

public final class __bllogoutsettlements extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLLogoutSettlements.jsp", 1737916157027L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<!-- \ncurrencyFormat() JS Method was replaced by putDecimal() on 8/19/2008 by manivel for ICN 5134\n-->\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<script language=\'javascript\' src=\'../js/BLAmount.js\'></script>\n\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<!--\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n\t-->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n<script> \nfunction funClosingBal(f_mode)\n{\n\tvar obj=\'\';\n\tvar act_value=0;\n\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\tvar slmt_flag_value=\"\";\n\tvar slmt_flag_arr = new Array();\n\tslmt_flag_value = document.forms[0].slmt_flag.value;\n\tslmt_flag_arr = slmt_flag_value.split(\"|\");\t\t\n\tvar slmt_array = funGetSettlmentArray();\t\n\tif(f_mode==\'ONB\')\n\t{\t\t\n\t\tfor (i=0;i<slmt_array.length-1;i++)\n\t\t{\n\t\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_act\');\t\t\t\n\t\t\tact_value = obj.value;\n\t\t\tif(act_value==\"\")act_value=0;\n\t\t\tif (slmt_flag_arr[i] == \"Y\"\t)\n\t\t\t{\t\t\n\t\t\t\tparent.report_frame.document.forms[0].tot_closing_bal.value = parseFloat(document.forms[0].tot_opening_bal.value) +parseFloat(act_value);\t\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t}else{\t\t\n\t\tparent.report_frame.document.forms[0].tot_closing_bal.value = eval(document.forms[0].tot_opening_bal.value) +eval(document.forms[0].tot_act.value);\n\t}\n//\tcurrencyFormat(parent.report_frame.document.forms[0].tot_closing_bal);\n\tputDecimal(parent.report_frame.document.forms[0].tot_closing_bal,17,noofdecimal);\n}\nfunction funSetAmt()\n{\n\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\n\tparent.report_frame.document.forms[0].tot_credit_bills_amt.value = document.forms[0].tot_credit_bills_amt.value;\n\tparent.report_frame.document.forms[0].tot_cash_bills_amt.value = document.forms[0].tot_cash_bills_amt.value;\n\tparent.report_frame.document.forms[0].tot_opening_bal.value = document.forms[0].tot_opening_bal.value;\n\tparent.report_frame.document.getElementById(\"cash_bill_cnt1\").innerText = parent.detail_frame.document.forms[0].cash_bill_cnt.value;\t\n\tparent.report_frame.document.getElementById(\"credit_bill_cnt1\").innerText = parent.detail_frame.document.forms[0].credit_bill_cnt.value;\t\n//\tcurrencyFormat(parent.report_frame.document.forms[0].tot_cash_bills_amt);\n//\tcurrencyFormat(parent.report_frame.document.forms[0].tot_credit_bills_amt);\n//\tcurrencyFormat(parent.report_frame.document.forms[0].tot_opening_bal);\n\tputDecimal(parent.report_frame.document.forms[0].tot_cash_bills_amt,17,noofdecimal);\n\tputDecimal(parent.report_frame.document.forms[0].tot_credit_bills_amt,17,noofdecimal);\n\tputDecimal(parent.report_frame.document.forms[0].tot_opening_bal,17,noofdecimal);\n//\tparent.report_frame.document.forms[0].cashcnt.value = document.forms[0].cash_bill_cnt.value;\n\t//parent.report_frame.document.forms[0].credit_bill_cnt.value = document.forms[0].credit_bill_cnt.value;\n\n\tfunClosingBal(\'ONL\');\n\t\n}\n\nfunction putDecimal_local(Obj,maxvalue,deci)\n{\nvar temp1=Obj;\nvar temp4=Obj.length;\nvar count=parseInt(maxvalue) -parseInt(deci);\nif (parseInt(deci) > 0)\n{\nif(temp1.indexOf(\'.\') <0)\n{\n\tif (temp4 <= parseInt(maxvalue))\n\t{\n\t\tif(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)\n\t\t{\n\t\t\tvar temp2=temp1.substring(0,count);\n\t\t\tvar temp3=temp2+\".\"+temp1.substring(count,temp1.length)\n\t\t\tif(temp3.length-1 < parseInt(maxvalue))\n\t\t\t{\n\t\t\t\tfor(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)\n\t\t\t\t{\n\t\t\t\ttemp3+=\"0\";\n\t\t\t\t}\n\t\t\t}\nreturn temp3;\n\t\t}\n         \n\t\telse if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)\n\t\t{\n\t\tvar temp3=temp1+\'.\';\n\t\tfor(var m=0;m<deci;m++)\n\t\ttemp3+=\"0\";\nreturn temp3;\n\t\t\n\t\t}\n      if (temp1.length == 0 )\n\t {\n\t \t\ttemp3=\"0.\";\n\t\t\tfor(var m=0;m<deci;m++)\n\t\t\ttemp3+=\"0\";\nreturn temp3;\n\t \n\t }\n   \n \n }\n\n}\nelse\n   {\n\t\n\tvar temp5=temp1.indexOf(\'.\');\n\tvar temp7=temp1.substring(0,temp5);\n\tvar temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));\n\tif(temp6.length >1)\n\t   {\n\treturn temp7+\".\"+temp6;\n\t   }else\n\t   {\n\treturn temp7+\".\"+temp6+\"0\";\n\t   }\n   }\n }\n}\n\nfunction funGetSettlmentArray()\n{\n\tvar slmt_array = new Array();\n\tvar slmt_array_value = document.forms[0].slmt_array.value;\n\tslmt_array = slmt_array_value.split(\"|\");\t\n\treturn(slmt_array);\n}\n\nfunction funActualAmountCheck(obj)\n{\n\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\tvar res = checkNumber(obj);\n\t\n\tvar arr = new Array();\n\tarr = obj.name.split(\'_\');\n\n\tvar objDis = eval(\'document.forms[0].\'+arr[0]+\'_dis\');\n\t\n\tvar objRcp = eval(\'document.forms[0].\'+arr[0]+\'_rcp\');\n\n\tvar objCan = eval(\'document.forms[0].\'+arr[0]+\'_can\');\n//added for crf-13\n\t//var orgrcp = eval(\'document.forms[0].\'+arr[0]+\'_orgrcp\');\n\tvar objhoa = eval(\'document.forms[0].\'+arr[0]+\'_hoa\');\n\tif(\tobjDis.value == 0 || objDis.value ==\"\"){\t\n\t\t//alert(\"Discr does not  exists\");\n//\t\tobj.value=0;\n\t\teval(\'document.forms[0].\'+arr[0]+\'_dis\').value= parseFloat(objRcp.value) - (parseFloat(objCan.value)+parseFloat(objhoa.value));\n\t}\n\t\n\tif (res == true)\n\t{\n\t\t//added for crf-13 commented line 225 and added line 233\n//\t\tvar diffAmt = parseFloat(objRcp.value) - (parseFloat(objCan.value);\n\t\tvar diffAmt = parseFloat(objRcp.value) - (parseFloat(objCan.value)+parseFloat(objhoa.value));\n\t\t\n\n\t//\tvar diffAmt = parseFloat(orgrcp.value) - parseFloat(objCan.value);\n\t\tdiffAmt = Math.round(diffAmt*100)/100;\n\t\tif(\tobjDis.value !=0){\t\t\t\n\t\tobjDis.value = \tdiffAmt - obj.value;//changed\n\t\t\t\t\n\t}\n//\t\tcurrencyFormat(obj);\n//\t\tcurrencyFormat(objDis);\n\t\tputDecimal(obj,17,noofdecimal);\n\t\tputDecimal(objDis,17,noofdecimal)\n\t}\n\n\tvar slmt_array = funGetSettlmentArray();\n\tvar tot_act = 0;\n\tvar tot_dis = 0;\n\tfor (i=0;i<slmt_array.length;i++)\n\t{\n\t\tif ( (slmt_array[i] == null) || (slmt_array[i] ==\'\')) break;\n\t\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_act\');\t\t\t\n\t\t\ttot_act = tot_act + eval(((obj.value==null)||(obj.value==\'\'))? 0 : obj.value);\n\t\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_dis\');\t\t\t\n\t\t\ttot_dis = tot_dis + eval(((obj.value==null)||(obj.value==\'\'))? 0 : obj.value);\n\t}\n\t\n\tdocument.forms[0].tot_act.value = tot_act;\n\tdocument.forms[0].tot_dis.value = tot_dis;\n//\tcurrencyFormat(document.forms[0].tot_act);\n//\tcurrencyFormat(document.forms[0].tot_dis);\n\tputDecimal(document.forms[0].tot_act,17,noofdecimal);\n\tputDecimal(document.forms[0].tot_dis,17,noofdecimal);\t\n\tfunClosingBal(\'ONB\');\n\t\n}\nfunction totDisActAmt()\n{\n\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\tvar slmt_array = funGetSettlmentArray();\n\tvar tot_act = 0;\n\tvar tot_dis = 0;\n\tvar tot_hao = 0;\n\tfor (i=0;i<slmt_array.length;i++)\n\t{\n\t\tif ( (slmt_array[i] == null) || (slmt_array[i] ==\'\')) break;\n\t\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_act\');\n\t\t\ttot_act = tot_act + eval(((obj.value==null)||(obj.value==\'\'))? 0 : obj.value);\n\t\t\t\n\n\t\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\');\n\t\t\ttot_hao = tot_hao + eval(((obj.value==null)||(obj.value==\'\'))? 0 : obj.value);\n\t\t\t\n\n\n\t\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_dis\');\t\t\t\n\t\t\ttot_dis = tot_dis + eval(((obj.value==null)||(obj.value==\'\'))? 0 : obj.value);\n\n\t\t\t\n\t}\n\t\n\tdocument.forms[0].tot_act.value = tot_act;\n\tdocument.forms[0].tot_dis.value = tot_dis;\n\tdocument.forms[0].tot_hoa.value = tot_hao;\n//\tcurrencyFormat(document.forms[0].tot_act);\n//\tcurrencyFormat(document.forms[0].tot_dis);\n\tputDecimal(document.forms[0].tot_act,17,noofdecimal);\n\tputDecimal(document.forms[0].tot_dis,17,noofdecimal);\t\n\tputDecimal(document.forms[0].tot_hoa,17,noofdecimal);\t\n\n}\nfunction cal_tot_hoAmt()\n{\n\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\tvar slmt_flag_value=\"\";\n\tvar slmt_flag_arr = new Array();\n\tslmt_flag_value = document.forms[0].slmt_flag.value;\n\tslmt_flag_arr = slmt_flag_value.split(\"|\");\t\t\n\tvar totCash = 0;\n\tvar totCheq = 0;\n\tvar totCash = parseFloat(document.forms[0].cashHandedOver.value);\n\t\n\tvar totCheq = parseFloat(document.forms[0].cheqHandedOver.value);\t\n\t\n\tvar hoamt=0;\n\tvar slmt_array = funGetSettlmentArray();\t\n\tfor (i=0;i<slmt_array.length;i++)\n\t{\t\t\t\n\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_rcp\');\t\t\n\t\tif(totCheq>0){\n\t\tif (slmt_flag_arr[i] == \"B\"\t)\n\t\t{\n\t\t\tif(obj.value >totCheq)\n\t\t\t{\t\n\t\t\t\thoamt = totCheq\n\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\').value=hoamt;\t\t\t\t\n\t\t\t\ttotCheq=0;\n\t\t\t\tputDecimal(eval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\'),17,noofdecimal);\n\t\t\t\t\n\n\t\t\t}else{\t\t\t\t\t\n\t\t\t\t\thoamt=obj.value;\t\t\t\t\t\n\t\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\').value=hoamt;\n\t\t\t\t\ttotCheq=totCheq-obj.value;\n\t\t\t\t\t//eval(\'document.forms[0].\'+slmt_array[i]+\'_orgrcp\').value=totCheq;\n\t\t\t\t\tputDecimal(eval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\'),17,noofdecimal);\n\t\t\t\t}\n\t\t}\n\t\t}\n\tif(totCash>0){\t\t\n\tif (slmt_flag_arr[i] == \"Y\"\t)\n\t\t{\t\n\t\t\tif(obj.value >totCash)\n\t\t\t{\n\t\t\t\thoamt = totCash\n\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\').value=hoamt;\n\t\t\t\ttotCash=0;\n\t\t\t\tputDecimal(eval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\'),17,noofdecimal);\n\t\t\t}else{\n\t\t\t\t\thoamt=obj.value;\n\t\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\').value=hoamt;\n\t\t\t\t\ttotCash=totCash-obj.value;\t\t\n\t\t\t\t\tputDecimal(eval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\'),17,noofdecimal);\n\t\t\t\t}\n\t\t}\t\n\t}\n\t\t\n\t\t\t\n\t\tif(totCheq==0 && totCash==0)break;\t\n\t}\n\t\t\tvar v_hao=0;\n\t\t\tvar v_rcp=0;\n\t\t\tvar v_hoa=0;\n\t\t\tvar v_can=0;\n\t\t\tfor (i=0;i<slmt_array.length;i++)\n\t\t\t{\t\n\t\t\t\t/*if(slmt_flag_arr[i]!=\"\"){\n\t\t\t\tif (slmt_flag_arr[i] != \"B\"\t|| slmt_flag_arr[i] != \"Y\")\n\t\t\t\t{\n\t\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_orgrcp\').value=eval(\'document.forms[0].\'+slmt_array[i]+\'_rcp\').value;\n\t\t\t\t}\n\t\t\t\t}*/\n\n\t\t\t\tif (slmt_flag_arr[i] == \"B\"\t|| slmt_flag_arr[i] == \"Y\"){\n\t\t\t\t\tv_hao = parseFloat(eval(\'document.forms[0].\'+slmt_array[i]+\'_hoa\').value);\n\t\t\t\t\tv_rcp = parseFloat(eval(\'document.forms[0].\'+slmt_array[i]+\'_rcp\').value);\n\t\t\t\t\tv_can = parseFloat(eval(\'document.forms[0].\'+slmt_array[i]+\'_can\').value);\t\t\t\t\t\n\t\t\t\t\tif(v_hao!=\"\"){\n\t\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_dis\').value = v_rcp-(v_can+v_hao);\n\t\t\t\t\t\tputDecimal(eval(\'document.forms[0].\'+slmt_array[i]+\'_dis\'),17,noofdecimal);\n\t\t\t\t\t\t//eval(\'document.forms[0].\'+slmt_array[i]+\'_orgrcp\').value=v_rcp-v_hao;\n\t\t\t\t\t}else{\n\t\t\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_dis\').value = eval(\'document.forms[0].\'+slmt_array[i]+\'_rcp\').value-v_can;\n\t\t\t\t\t\t//eval(\'document.forms[0].\'+slmt_array[i]+\'_orgrcp\').value=eval(\'document.forms[0].\'+slmt_array[i]+\'_rcp\').value;\n\t\t\t\t\t\tputDecimal(eval(\'document.forms[0].\'+slmt_array[i]+\'_dis\'),17,noofdecimal);\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t/*if(slmt_flag_arr[i]!=\"\")\n\t\t\t\t{\t\t\t\n\t\t\t\tif (slmt_flag_arr[i] != \"B\"\t|| slmt_flag_arr[i] != \"Y\")\n\t\t\t\t{\n\t\t\t\t\teval(\'document.forms[0].\'+slmt_array[i]+\'_orgrcp\').value=eval(\'document.forms[0].\'+slmt_array[i]+\'_rcp\').value;\n\t\t\t\t}\n\t\t\t\t}*/\n\n\t}\n}\n\nfunction funFormat()\n{\n\t\n\n\t\tvar noofdecimal = document.forms[0].noofdecimal.value;\n\t\tvar logoutSuccesful = getMessage(\'BL9322\',\'BL\');\t\n\t\tvar logoutSubmit = getMessage(\'BL9323\',\'BL\');\n\t\t//document.write(alert(logoutSuccesful));\n\t\tdocument.forms[0].logoutSuccesful.value=logoutSuccesful;\n\t\tdocument.forms[0].logoutSubmit.value=logoutSubmit;\n\t\t\n\n//\talert(document.form(0).str.value);\n\n\t\n\tvar slmt_array = funGetSettlmentArray();\n\tvar obj = new Object();\n\n\tfor (i=0;i<slmt_array.length;i++)\n\t{\n\t\tif ( (slmt_array[i] == null) || (slmt_array[i] ==\'\')) bre";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="ak;\n\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_can\');\n//\t\tcurrencyFormat(obj);\n\t\tputDecimal(obj,17,noofdecimal);\n\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_rcp\');\n//\t\tcurrencyFormat(obj);\n\t\tputDecimal(obj,17,noofdecimal);\t\n\n\t}\n\t\tvar tot_can = document.forms[0].tot_can;\n\t\tvar tot_rcp = document.forms[0].tot_rcp;\t\n//\t\tcurrencyFormat(tot_can);\n\t\tputDecimal(tot_can,17,noofdecimal);\n//\t\tcurrencyFormat(tot_rcp);\n\t\tputDecimal(tot_rcp,17,noofdecimal);\n\t\tfunSetAmt();\n\t\tcal_tot_hoAmt(); //added for CRF -13\n\t\ttotDisActAmt();\n\t\n\t\n}\n\nfunction funValidate()\n{\n\tvar cashcounter = parent.top_frame.document.forms[0].cashcounter.value;\n\tif ( (cashcounter == \'\') || (cashcounter == null) ||(cashcounter == \' \') )\t\n\t{\t\n\t\talert(getMessage(\'BL9538\',\'BL\'));\n\t\treturn(false);\n\t}\n\t\tvar slmt_array = funGetSettlmentArray();\n\t\n\t\tfor (i=0;i<slmt_array.length;i++)\n\t\t{\n\t\t\tif ( (slmt_array[i] == null) || (slmt_array[i] ==\'\')) break;\n\t\n\t\t\tobj = eval(\'document.forms[0].\'+slmt_array[i]+\'_dis\');\n\t\t\t\t\n\t\t\tif (!((obj.value == null) || (obj.value ==\'\') || (obj.value == 0) ))\n\t\t\t{\n\t\t\t\talert(getMessage(\'BL1288\',\'BL\'));\n\t\t\t\treturn(false);\n\t\t\t}\n/*\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn(true);\n\t\t\t}\n*/\n\t\t}\n\treturn(true);\n}\n\n\nfunction funActCanAmtCheck(obj)\n{\t\n\tvar arr = new Array();\n\tarr = obj.name.split(\'_\');\n\tvar objCan = eval(\'document.forms[0].\'+arr[0]+\'_can\');\n\tvar objRcp = eval(\'document.forms[0].\'+arr[0]+\'_rcp\');\n\tvar objAct = eval(\'document.forms[0].\'+arr[0]+\'_act\');\n\tvar objDis = eval(\'document.forms[0].\'+arr[0]+\'_dis\');\n\t//added for crf-13\n\t//var objorgrcp = eval(\'document.forms[0].\'+arr[0]+\'_orgrcp\');\n\tvar objhoa = eval(\'document.forms[0].\'+arr[0]+\'_hoa\');\n\t\t \n\tvar canAmt = objCan.value;\n\tvar rcpAmt = objRcp.value;\n\tvar actAmt = objAct.value\n\tvar disAmt = objDis.value;\n//added for crf-13\n\t//var orgrcp = objorgrcp.value;\n\tvar hoaAmt = objhoa.value;\n\n// Added by manivel on 8/19/2008 for ICN 5134\n//added for crf-13 commented line 474 and added line 475\n//\tvar diffAmt = parseFloat(rcpAmt) - parseFloat(canAmt);\n\tvar diffAmt = parseFloat(rcpAmt) - (parseFloat(canAmt)+parseFloat(hoaAmt));\n\n  //var diffAmt = parseFloat(orgrcp) - parseFloat(canAmt);\n\tdiffAmt = Math.round(diffAmt*100)/100;\n\n\tif(actAmt!=0 && (diffAmt)!=actAmt)\n\t{\n\t\t//alert(\'Discrepency exits, Cannot Close Cash Counter\');\n\t\t\n\t\talert(getMessage(\'BL1288\',\'BL\'));\n\t\tobjAct.focus();\n\t}\n\t\n}\n\t\n//sarathkumar added below script make as siteSpecific GDOH-CRF-0117 beginning...\n$(document).ready(function(){\n\tif($(\'#SiteSpecific\').val() == \'true\'){\n\t\tvar rowcount=$(\'#rowCounts\').val();\n\t\tvar i=1;\n\t\tfor(i=1;i<=rowcount;i++){\t\n\t\t\t$(\'#actamt_\'+i).val($(\'#disamt_\'+i).val());\n\t\t\t$(\'#actamt_\'+i).focus();\n\t\t\t$(\'#actamt_\'+i).blur();\t\t\t\n\t\t}\t\n\t}\n});\n////sarathkumar added rowCount make as siteSpecific GDOH-CRF-0117 ending.\n\n</script>\n</head>\n<body  onLoad=\'funFormat()\'>\n\t<form name=\'settlement_form\' id=\'settlement_form\' action=\'../../servlet/eBL.BLLogoutSettlementsServlet\' target=\'dummy_frame\' method=\'post\'>\n\t<center>\n\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t<!--<td width=\'5%\' class=\"COLUMNHEADER\" >";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t<td width=\'15%\' class=\"COLUMNHEADER\"></td>\n        <td width=\'15%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td width=\'15%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t\t<td width=\'15%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n\t\t<td width=\'15%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t-->\n\t\t<TR>\n\t\t<td width=\'28%\' class=\"COLUMNHEADER\" colspan=\"9\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t</TR>\n\t\t<TR>\t\t\n\t\t<td width=\'28%\' class=\"COLUMNHEADER\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n        <td width=\'7%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td width=\'7%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<td width=\'10%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\n\t\t<td width=\'10%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td>\n\t\t<td width=\'10%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\n\t\t<td width=\'11%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\t\t\n\t\t</TR>\n\t\t<tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>\n\t\n\t\n\t   var strErrorMessage = \'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n       alert(\"error :\"+strErrorMessage);\n//\t   return;\n\t </script>\n ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t  <script>\n    \t  alert(getMessage(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'BL\'));\n//\t\t  return;\n\t  </script>\n    ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t\t<td width=\'28%\'><div align=\'right\'><b> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b></div></td>\t \n\n\t\t\t\t<td width=\"7%\">&nbsp;</td>\n\t\t\t\t<td width=\'7%\'>&nbsp;</td>\t\n\t\t\t\t<td width=\'7%\'>&nbsp;</td>\t\n\n\t\t\t\t<td  width=\"10%\" class=\"fields\"><input type=\'text\' style=\'text-align:right; font-weight:bold\' readonly name=\'tot_can\' id=\'tot_can\' maxlength=\'25\' size=\'10\' tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'> </td>\n\n\t\t\t\t<td width=\"10%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\' readonly name=\'tot_rcp\' id=\'tot_rcp\' maxlength=\'25\' size=\'10\' tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'> </td>\n\n\t\t\t\t<td width=\"10%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\'  readonly name=\'tot_act\' id=\'tot_act\' maxlength=\'25\' size=\'10\' tabindex=\'0\' value=\'0\'> </td>\n\n\t\t\t\t<td width=\"11%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\'  readonly name=\'tot_hoa\' id=\'tot_hoa\' maxlength=\'25\' size=\'11\' tabindex=\'0\' value=\'0\'> </td>\n\n\t\t\t\t<td width=\"10%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\'  readonly name=\'tot_dis\' id=\'tot_dis\' maxlength=\'25\' size=\'10\' tabindex=\'0\' value=\'0\'> </td>\n\t\t\t</tr>\n\t\t</table>\n<!--\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'32%\'><div align=\'right\'><b> ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b></div></td>\t \n\n\t\t\t\t<td width=\"7%\">&nbsp;</td>\n\t\t\t\t<td width=\'7%\'>&nbsp;</td>\t\n\t\t\t\t<td width=\'7%\'>&nbsp;</td>\t\n\n\t\t\t\t<td  width=\"10%\" class=\"fields\"><input type=\'text\' style=\'text-align:right; font-weight:bold\' readonly name=\'tot_can\' id=\'tot_can\' maxlength=\'25\' size=\'12\' tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'> </td>\n\n\t\t\t\t<td width=\"10%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\' readonly name=\'tot_rcp\' id=\'tot_rcp\' maxlength=\'25\' size=\'12\' tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'> </td>\n\n\t\t\t\t<td width=\"10%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\'  readonly name=\'tot_act\' id=\'tot_act\' maxlength=\'25\' size=\'12\' tabindex=\'0\' value=\'0\'> </td>\n\n\t\t\t\t<td width=\"7%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\'  readonly name=\'tot_hoa\' id=\'tot_hoa\' maxlength=\'25\' size=\'12\' tabindex=\'0\' value=\'0\'> </td>\n\n\t\t\t\t<td width=\"10%\" class=\'fields\'><input type=\'text\' style=\'text-align:right; font-weight:bold\'  readonly name=\'tot_dis\' id=\'tot_dis\' maxlength=\'25\' size=\'12\' tabindex=\'0\' value=\'0\'> </td>\n\t\t\t</tr>\n\t\t</table>\n-->\n\t\t<input type=\'hidden\' name=\'tot_credit_bills_amt\' id=\'tot_credit_bills_amt\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t<input type=\'hidden\' name=\'tot_cash_bills_amt\' id=\'tot_cash_bills_amt\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type=\'hidden\' name=\'tot_opening_bal\' id=\'tot_opening_bal\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t<input type=\'hidden\' name=\'tot_closing_bal\' id=\'tot_closing_bal\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=\'hidden\' name=\'logout_time\' id=\'logout_time\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=\'hidden\' name=\'login_time\' id=\'login_time\'  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=\'hidden\' name=\'slmt_array\' id=\'slmt_array\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t<input type=\'hidden\' name=\'cash_counter\' id=\'cash_counter\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=\'hidden\' name=\'error_level\' id=\'error_level\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=\'hidden\' name=\'error_text\' id=\'error_text\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=\'hidden\' name=\'cash_bill_cnt\' id=\'cash_bill_cnt\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=\'hidden\' name=\'credit_bill_cnt\' id=\'credit_bill_cnt\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\'hidden\' name=\'stmtcode\' id=\'stmtcode\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=\'hidden\' name=\'logoutSuccesful\' id=\'logoutSuccesful\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'logoutSubmit\' id=\'logoutSubmit\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\t\n\t\t<input type=\'hidden\' name=\'cash_ctr_logout_rep_ind\' id=\'cash_ctr_logout_rep_ind\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\t\n\t\t<input type=\'hidden\' name=\'cash_ctr_logout_with_cb_yn\' id=\'cash_ctr_logout_with_cb_yn\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\t\n\t\t<input type=\'hidden\' name=\'called_frm\' id=\'called_frm\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\t\n\t\t<input type=\'hidden\' name=\'slmt_flag\' id=\'slmt_flag\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\t\n\t\t<!--<input type=\'hidden\' name=\'cashHandedOver\' id=\'cashHandedOver\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\t\n\t\t<input type=\'hidden\' name=\'cheqHandedOver\' id=\'cheqHandedOver\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\t-->\n\t\t<input type=\'hidden\' name=\'cashHandedOver\' id=\'cashHandedOver\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'hand_without_counter_chk_out\' id=\'hand_without_counter_chk_out\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\n\t\t<!-- sarathkumar added two fields make as siteSpecific GDOH-CRF-0117 -->\t\n\t\t<input type=\'hidden\' name=\'rowCounts\' id=\'rowCounts\' id=\'rowCounts\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t<input type=\'hidden\' name=\'SiteSpecific\' id=\'SiteSpecific\' id=\'SiteSpecific\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'\n\t\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	CurrencyFormat cf = new CurrencyFormat();
	String facility_id = "";
	String login_user = "";
	String cashcounter = "";
	String called_frm = "";
	String hand_without_counter_chk_out = "";

	//unused variable, commented on 09/06/05
	//int intMaxCount = 14;
	//int intCount = 0;

	double doubleCreditAmt = 0.0;
	double doubleCashBillAmt = 0.0;
	
	double doubleTotReceiptAmt = 0.0;
	double doubleTotCancelAmt = 0.0;
	double doubleOpeningBalance = 0.0;
	int integerCashBillCnt=0;
	int integerCreditBillCnt=0;
	int noofdecimal=2;
	double totcash=0;
	double totcheq=0;
	int rowCount=0; //sarathkumar defined field make as siteSpecific GDOH-CRF-0117
	
	String strErrorLevel="";
	String strSysMessageId="";
	String strErrorText="";
	String slmt_flag="";	

	String strSlmtArray = "";
	String strCreditAmt = "0";
	String strCashBillAmt  = "0";
	String strOpeningBalance="0";
	String login_time = "0";
	String logout_time = "0";
	String strCashBillCnt="0";
	String strCreditBillCnt="0";
	String strCashHandedOver="",strcheqHandedOver="";
	
	String stmtcode="";
	String cash_ctr_logout_with_cb_yn="",cash_ctr_logout_rep_ind="";
	Connection con = null;
	request.setCharacterEncoding("UTF-8");
	try
	{
		//Connection 
		con = ConnectionManager.getConnection(request);
		String locale	= (String)session.getAttribute("LOCALE");
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");
		cashcounter = (String)request.getParameter("cashcounter");
		login_time = (String)request.getParameter("login_time");		
		login_time=com.ehis.util.DateUtils.convertDate(login_time,"DMYHMS",locale,"en");

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";
		//System.out.println("login_time :"+login_time);
	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}
	try
	{
		PreparedStatement pstmt = null;
		ResultSet rscurr=null;
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
	 System.out.println("3="+e.toString());
	}


	
	String ss=session.getAttribute("ssv").toString(); //sarathkumar added code make as siteSpecific GDOH-CRF-0117...

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

	try
	{			
		
			try{
				String sql1 = "	SELECT nvl(CASH_REQUEST_AMT,0),nvl(CHQ_REQUEST_AMT,0) FROM bl_handed_reqt WHERE LOGIN_DATE_TIME=(SELECT LOGIN_DATE_TIME FROM   BL_CASH_COUNTER_SLMT_HDR WHERE  OPERATING_FACILITY_ID = '"+facility_id+"'	AND    CASH_COUNTER_USER_ID  = '"+login_user+"' AND    LOGOUT_DATE_TIME     IS NULL) AND STATUS='A' ";
//				System.out.println("sql1 gfdgdgdf :"+sql1);
				PreparedStatement pstmt = con.prepareStatement(sql1);														
				ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{											
						strCashHandedOver = rs.getString(1);						
						strcheqHandedOver = rs.getString(2);
						totcash =totcash + Double.parseDouble(strCashHandedOver);
						totcheq =totcheq + Double.parseDouble(strcheqHandedOver);
					}						
					rs.close();
					pstmt.close();
			}catch(Exception e)
					{
						//out.println("Error request chk GET ctr = "+e);
						//System.out.println("Error request chk GET ctr :"+e);
						e.printStackTrace();
					}	
		try
		{
			String sql1 = 	" SELECT   SUM(NVL(x.receipt_amt,0)) receipt_amt, "+
			"	SUM(NVL(x.cancel_amt,0))  cancel_amt, "+
			"	x.slmt_type_code, "+
			"	y.cash_slmt_flag, "+
			"	y.SHORT_DESC, "+
			" SUM(tot_cnt) TOTAL_CNT, SUM(can_cnt) CANCEL_CNT,  SUM(bou_cnt) BOUNCED_CNT "+
			" FROM	"+
			" (	 SELECT 		NVL(a.doc_amt,0) receipt_amt, "+
			"	0                cancel_amt, "+
			"	a.SLMT_TYPE_CODE slmt_type_code, 1 tot_cnt, 0 can_cnt, 0 bou_cnt  "+
			"	FROM bl_receipt_refund_hdrdtl_vw a  	 "+				 
			"	WHERE  a.cash_counter_facility_id = ?  "+    //1	facility_id
			"	AND   a.recpt_refund_ind IS NOT NULL  "+
			"	AND   a.cash_counter_code     = ?	"+	 //2 cashcounter
			"	AND   a.doc_date              BETWEEN to_date(?,'dd/mm/yyyy hh24:mi:ss') AND "+	 // 3 login_date_time
			"	SYSDATE				"+		
			"	AND a.cash_ctrl_doc_type_code IS NULL "+
			"	UNION ALL "+
			"	SELECT 		0  receipt_amt,  "+
			"	NVL(a.doc_amt,0) cancel_amt, "+
			"	a.SLMT_TYPE_CODE  slmt_type_code, 1 tot_cnt, " + 
			"   decode(b.cancelled_ind,'Y',1,0) can_cnt, decode(b.bounced_yn,'Y',1,0) bou_cnt " +
			"	FROM      bl_receipt_refund_hdrdtl_vw a , bl_cancelled_bounced_trx b "+
			"	WHERE     b.cash_counter_facility_id = ? "+	// 4 facility_if
			"	AND       b.recpt_refund_ind IS NOT NULL  "+
			"	AND       b.cash_counter_code     = ?	"+	//5 cashcounter
			"	AND   b.cancelled_date             BETWEEN  to_date(?,'dd/mm/yyyy hh24:mi:ss')   AND  "+ //6 login_time
			"	SYSDATE	"+				
			"	AND  a.doc_type_code = b.doc_type_code "+
			"	AND  a.doc_number = b.doc_number "+
			"	AND  a.DOC_SRNO = b.DOC_SRNO "+
			"	AND b.cash_ctrl_doc_type_code IS NULL "+
			" ) x, "+
			" bl_slmt_type y, sy_acc_entity z "+
			" WHERE x.slmt_type_code = y.slmt_type_code "+
			" AND   z.acc_entity_id = ?  "+
			" AND   y.acc_entity_code = z.acc_entity_code  "+
			" GROUP BY x.SLMT_TYPE_CODE,cash_slmt_flag,Y.short_Desc ";


			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, facility_id);
			pstmt.setString(2,cashcounter);
			pstmt.setString(3, login_time);
			pstmt.setString(4, facility_id);	
			pstmt.setString(5,cashcounter);
			pstmt.setString(6, login_time);
			pstmt.setString(7, facility_id);


			ResultSet rs = pstmt.executeQuery() ;

			//unused variable, commented on 09/06/05
			//String strColorClass = "QRYODD";
			boolean alternate = true;
			while(rs.next())
			{
				rowCount++; //sarathkumar added rowCount make as siteSpecific GDOH-CRF-0117
				
				if (alternate)
				{
					alternate = false;
					//strColorClass = "QRYODD";
				}
				else
				{
					alternate = true;
					//strColorClass = "QRYEVEN";
				}
				strSlmtArray = strSlmtArray+rs.getString(3)+"|";
				//System.out.println("strSlmtArray :"+strSlmtArray);

				slmt_flag = slmt_flag+rs.getString(4)+"|";
			 	//System.out.println("slmt_flag :"+slmt_flag);
				

			
				
				//out.println("<table border='0' width='100%' cellspacing='0' cellpadding='3'>");
				
				
				out.println("<tr>");
				
									
							
			 stmtcode=rs.getString(3);
			 

			//out.println("<td width='4%' class='label'>"+"<input type='text' readonly name='"+rs.getString(3)+"' id='"+rs.getString(3)+"' maxlength='3' size='3' tabindex='0' value='"+rs.getString(3)+"' > </td>");
			out.println("<input type='HIDDEN' readonly name='"+rs.getString(3)+"' id='"+rs.getString(3)+"' value='"+rs.getString(3)+"' > ");
			out.println("<td width='28%' class='label' size='36' > <b>"+rs.getString(5)+"</b></td>");
			out.println("<td width='7%'class='fields'>"+"<input type='text' style='text-align:right'  readonly name='' id='' maxlength='25' size='5' tabindex='0' value='"+rs.getString(6)+"'> </td>");
			out.println("<td width='7%'  class='fields'>"+"<input type='text' style='text-align:right'  readonly name='' id='' maxlength='25' size='5' tabindex='0' value='"+rs.getString(7)+"'> </td>");
			out.println("<td  width='7%' class='fields'>"+"<input type='text' style='text-align:right'  readonly name='' id='' maxlength='25' size='5' tabindex='0' value='"+rs.getString(8)+"'> </td>");
			out.println("<td width='10%'  class='fields'>"+"<input type='text' style='text-align:right' readonly name='"+rs.getString(3)+"_can' id='"+rs.getString(3)+"_can'  maxlength='15' size='12' tabindex='0' value='"+cf.formatCurrency(String.valueOf(Double.parseDouble(rs.getString(2))),noofdecimal)+"'  onBlur='funActCanAmtCheck(this)'> </td>");
			out.println("<td width='10%'  class='fields'>"+"<input type='text' style='text-align:right' readonly name='"+rs.getString(3)+"_rcp' id='"+rs.getString(3)+"_rcp' maxlength='15' size='12' tabindex='0' value='"+cf.formatCurrency(String.valueOf(Double.parseDouble(rs.getString(1))),noofdecimal)+"' onBlur='funActCanAmtCheck(this)'> </td>");
			//sarathkumar added id actamt_  disamt_ make as siteSpecific GDOH-CRF-0117
			out.println("<td  width='10%' class='fields'>"+"<input type='text' style='text-align:right' name='"+rs.getString(3)+"_act' id='"+rs.getString(3)+"_act'  id='actamt_"+rowCount+"'  maxlength='15' size='10' tabindex='0' value=''  onBlur='funActualAmountCheck(this);funActCanAmtCheck(this)'> </td>");	
			//out.println("<input type='HIDDEN' readonly name='"+rs.getString(3)+"_orgrcp' id='"+rs.getString(3)+"_orgrcp' value='' > ");
			out.println("<td  width='11%' class='fields'>"+"<input type='text' style='text-align:right' name='"+rs.getString(3)+"_hoa' id='"+rs.getString(3)+"_hoa' maxlength='15' size='11' tabindex='0' value='0.00' onBlur='' readonly> </td>");
			
			out.println("<td  width='10%' class='fields'>"+"<input type='text' style='text-align:right'  readonly name='"+rs.getString(3)+"_dis' id='"+rs.getString(3)+"_dis' id='disamt_"+rowCount+"' maxlength='15' size='10' tabindex='0' value='"+cf.formatCurrency(String.valueOf(Double.parseDouble(rs.getString(1))-Double.parseDouble(rs.getString(2))),noofdecimal)+"'  onBlur='funActCanAmtCheck(this)'> </td>");

				out.println("</tr>");
				 


				doubleTotReceiptAmt = doubleTotReceiptAmt + rs.getDouble(1);
				doubleTotCancelAmt  = doubleTotCancelAmt +  rs.getDouble(2);
				


			}

			
			rs.close();
			pstmt.close();
			if(!cashcounter.equals(""))
			{
			try
				{
					CallableStatement call = con.prepareCall("{ call bl_cash_counter_check.cash_credit_amt(?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?) }");						

					

					call.setString(1,facility_id);
					call.setString(2,login_user);
					call.setString(3,cashcounter);
					call.setString(4,login_time);
					call.registerOutParameter(5,java.sql.Types.DOUBLE); 
					call.registerOutParameter(6,java.sql.Types.DOUBLE); 
					call.registerOutParameter(7,java.sql.Types.DOUBLE); 
					call.registerOutParameter(8,java.sql.Types.VARCHAR);					
					call.registerOutParameter(9,java.sql.Types.INTEGER); 
					call.registerOutParameter(10,java.sql.Types.INTEGER);
					call.registerOutParameter(11,java.sql.Types.VARCHAR);
        			call.registerOutParameter(12,java.sql.Types.VARCHAR);
					call.registerOutParameter(13,java.sql.Types.VARCHAR);

					call.execute();
      
					doubleCashBillAmt = call.getDouble(5);          
					doubleCreditAmt = call.getDouble(6);   
					doubleOpeningBalance = call.getDouble(7);   
					logout_time = call.getString(8);
					if(logout_time==null) logout_time="";
					integerCashBillCnt = call.getInt(9);
					integerCreditBillCnt = call.getInt(10);
					strErrorLevel = call.getString(11);
					strSysMessageId = call.getString(12);
					strErrorText = call.getString(13);

					if(strErrorLevel==null) strErrorLevel="";
					if(strSysMessageId==null) strSysMessageId="";
					if(strErrorText==null) strErrorText="";

				//	System.out.println("strErrorLevel sett:"+strErrorLevel);
				//	System.out.println("strSysMessageId:"+strSysMessageId);
				//	System.out.println("strErrorText:"+strErrorText);		

					strCashBillAmt  =	String.valueOf(doubleCashBillAmt);
					if(strCashBillAmt==null) strCashBillAmt="";
					strCreditAmt= String.valueOf(doubleCreditAmt);
					if(strCreditAmt==null) strCreditAmt="";
					strOpeningBalance = String.valueOf(doubleOpeningBalance);
					if(strOpeningBalance==null) strOpeningBalance="";
					strCashBillCnt = String.valueOf(integerCashBillCnt);
					if(strCashBillCnt==null) strCashBillCnt="";
					strCreditBillCnt = String.valueOf(integerCreditBillCnt);
					if(strCreditBillCnt==null) strCreditBillCnt="";		

					call.close();
				}
				catch(Exception exp)
				{
					//out.println("error="+exp);
					exp.printStackTrace();
				}
		}
		}
		catch(Exception exp)
		{
		}
		// commented in Bangalore on 13/10/2005
		//ConnectionManager.returnConnection(con,request);

	//added by ram 28-10-2008 for checking logout report option
		try{
		PreparedStatement pstmt = null;
		ResultSet rsblparm=null;
		pstmt = con.prepareStatement( "SELECT  CASH_CNTR_LOGOUT_WITH_CB_YN,CASH_CTR_LOGOUT_REP_IND,HAND_WITHOUT_COUNTER_CHK_OUT FROM BL_PARAMETERS WHERE operating_facility_id='"+facility_id+"'");		
		rsblparm = pstmt.executeQuery();	
		
		while(rsblparm.next())
		{
			cash_ctr_logout_with_cb_yn  =  rsblparm.getString(1);		
			cash_ctr_logout_rep_ind  =  rsblparm.getString(2);		
			hand_without_counter_chk_out  =  rsblparm.getString(3);		
		}	
		rsblparm.close();
		pstmt.close();
		//System.out.println("cash_ctr_logout_with_cb_yn "+cash_ctr_logout_with_cb_yn);
		//System.out.println("cash_ctr_logout_rep_ind "+cash_ctr_logout_rep_ind);

		}catch(Exception e)
		{
			System.out.println("bl_param="+e.toString());
		}//end ram

			
	}
	catch(Exception sql)
	{
	}
	finally{ // Added in Bangalore on 13/10/2005
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
	}


if ((strErrorLevel.equals("10") && (!strErrorText.equals(""))) ||!strSysMessageId.equals(""))
			{
  if (strErrorLevel.equals("10") && !strErrorText.equals(""))
  {

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strErrorText));
            _bw.write(_wl_block22Bytes, _wl_block22);

   }
	

   if(!strSysMessageId.equals(""))
    {
   
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strSysMessageId));
            _bw.write(_wl_block24Bytes, _wl_block24);

	 }
	}

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doubleTotCancelAmt ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(doubleTotReceiptAmt ));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(doubleTotCancelAmt ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(doubleTotReceiptAmt ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( strCreditAmt ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( strCashBillAmt ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( strOpeningBalance ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( strOpeningBalance ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( logout_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( login_time));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( strSlmtArray ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cashcounter));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strErrorLevel));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strErrorText));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strCashBillCnt));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strCreditBillCnt));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(stmtcode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cash_ctr_logout_rep_ind));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(cash_ctr_logout_with_cb_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(slmt_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strCashHandedOver));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strcheqHandedOver));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totcash));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totcheq));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(hand_without_counter_chk_out));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ss ));
            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TotalCount.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CANCELLED_COUNT.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BOUNCED_COUNT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CANCEL_AMT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT_AMT.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ACTUAL_AMT.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCREPANCY_AMT.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SETTLEMENT_WISE_COLLECTION.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TotalCount.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CANCELLED_COUNT.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BOUNCED_COUNT.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CANCEL_AMT.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT_AMT.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ACTUAL_AMT.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HO_AMOUNT.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCREPANCY_AMT.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TOTAL_SLMT.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TOTAL_SLMT.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }
}
