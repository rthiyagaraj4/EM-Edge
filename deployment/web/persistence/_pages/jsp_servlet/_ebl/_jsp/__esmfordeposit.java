package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.op.CurrencyFormat;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __esmfordeposit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/Esmfordeposit.jsp", 1738923442892L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="   \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    \n    \n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\n<head>\n\t\t\t\t\t\t\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Enter Billing Service Details</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\t\t\n\t\t<script language=\'javascript\' ></script>\t\n\t\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLDepositReceipt.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\n\t\t\t\n\t\t\t<script>\n\t\t\t\n\n\t\t\t $(document).ready(function(){    \n\t\t\t\t Datetime(1);   \n\t\t\t\t //$(\'#esttotal\').val(0);\n\t\t\t\t });\n\n\t\t\t function putdeci(object)\n\t\t\t\t{\n\t\t\t\t \t\tif(object.value!=\'\')\n\t\t\t\t\t{\n\t\t\t\t\n\t\t\t\t\tvar decimal=2;\n\t\t\t\t\tputDecimal(object,17,decimal);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t \n\t\t\t function fnClearCode(obj) {\n\t\t\t\t\tobj.value = \'\';\n\t\t\t\t}\n\t\t\t \n\t\t\tasync function ServcodeLookup(service_desc1,service_code1,index)\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif($(\'#service_code\'+index).val()==\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\t$(\'#qty\'+index).val()==\'\';\n\t\t\t\t\t$(\'#charges_\'+index).val()==\'\';\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\tvar formObj=document.Esmfordeposit;\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar title=getLabel(\"eBL.SelectBillingService.label\",\"BL\");\n\t\t\t\tvar locale=formObj.locale.value;\n\t\t\t\tvar query=\'\';\n\t\t\t\tvar facility_id = formObj.facility_id.value; \n\t\t\t\tquery =\"Select Code,Description from(SELECT ALL BL_BLNG_SERV_LANG_VW.BLNG_SERV_CODE Code, BL_BLNG_SERV_LANG_VW.SHORT_DESC Description FROM BL_BLNG_SERV_LANG_VW where LANGUAGE_ID = (\'\"+locale+\"\')) where upper(Code) like upper(?) and upper(Description) like upper(?) order by BL_BLNG_SERV_LANG_VW.SHORT_DESC \"; \t\t\n\t\t\t\targumentArray[0]\t= query;\n\t\t\t\targumentArray[1]   = dataNameArray ;\n\t\t\t\targumentArray[2]   = dataValueArray ;\n\t\t\t\targumentArray[3]   = dataTypeArray ;\n\t\t\t\targumentArray[4]   = \"1,2\";\n\t\t\t\targumentArray[5]   = service_desc1.value;\n\t\t\t\targumentArray[6]   = DESC_LINK ;\n\t\t\t\targumentArray[7]   = CODE_DESC ;\n\t\t\t\t//alert(\'argumentArray=> \'+argumentArray);\n\t\t\t\tretVal = await CommonLookup( title, argumentArray );\n\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t \tvar arr=ret1.split(\",\");\n\t\t\t \tif(arr[1]==undefined) \n\t\t \t\t{\n\t\t\t \t\tarr[0]=\"\";\t\n\t\t\t \t\tarr[1]=\"\";\t\n\t\t \t\t}\n\t\t\t\t//alert(\'serv code\'+argumentArray[5]);\n\t\t\tif(retVal != null && retVal != \"\")\n\t\t\t\t\t{ \t\t\n\t\t\t   \t\tdocument.getElementById(\'service_code\'+index).value = arr[0];\n\t\t\t   \t\tdocument.getElementById(\'service_desc\'+index).value = arr[1];\n\t\t\t   \t\t//document.getElementById(\'datetime\'+index).value = today;\n\t\t\t   \t\tdocument.getElementById(\'qty\'+index).value = \'1.00\';\n\t\t\t   \t\t\n\t\t\t   \t\testdeposit(index);\n\t\t\t\t\t}\n\t\t\telse\n\t\t\t\t\t{\t\n\t\t\t\tdocument.getElementById(\'service_code\'+index).value= \"\";\n\t\t\t\tdocument.getElementById(\'service_desc\'+index).value=\"\";\n\t\t\t\n\t\t\t\tdocument.getElementById(\'qty\'+index).value=\"\"; \n\t\t\t\tdocument.getElementById(\'charges_\'+index).value=\"\"; \n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t} \n\t function addrow(index)\n\t {\n\t\t \n\t\t \n\t\t \n\t\t\tvar index = $(\'#estimatedeposit tr:last\').attr(\'data-id\');\n\t\t\t//alert(index)\n\t\t\tif(isNaN(index)){\n\t\t\t\tindex = 0;\n\t\t\t}\n\t\t\tvar formObj=document.Esmfordeposit;\n\t\t\tindex= parseInt(index)+parseInt(1);\n\t\t\t//alert(index);\t\n\t\t\tdocument.getElementById(\"lastrow\").value=index;\n\t\t\t//alert(index);\n\t\t\t//alert(document.getElementById(\'datetime\'+index)=Datetime();\n\t\t\tvar totalRows =  $(\'#estimatedeposit tr\').length+parseInt(1);\n\t\t\t\n\t\t\t\t\n\t\t\t\n\t\t\tvar tableRow = \"<tr id=\'tr_\"+index+\"\' data-id=\'\"+index+\"\' indexval=\'\"+index+\"\'> \"+\t\t\t\t\t\t\t\t\t\n\t\t\t\"<td  width=\'2.5%\' class=\'fields\'>\"+\n\t\t\t\"<input type=\'text\' id=\'line\"+index+\"\' name=\'line\"+index+\"\' id=\'line\"+index+\"\' size=\'05\' maxlength=\'30\' value=\'\"+totalRows+\"\'  readonly></td>\"+\n\t \t\t\"<td  width=\'2.5%\' class=\'fields\'>\"+\n\t\t\t\"<input type=\'text\' id=\'service_indicator\"+index+\"\' name=\'service_indicator\"+index+\"\' id=\'service_indicator\"+index+\"\' size=\'05\' maxlength=\'30\' value=\'S\' onBlur=\'Datetime(\"+index+\");\' readonly></td>\"+\n\t\t\t\"<td width=\'3.5%\' class=\'fields\'>\"+\n\t\t\t\"<input type=\'text\' id=\'datetime\"+index+\"\' name=\'datetime\"+index+\"\' id=\'datetime\"+index+\"\' size=\'17\' maxlength=\'30\' value=\'\' readonly>\" +\"</td>\"+\n\t\t\t\"<td width=\'3.5%\' class=\'fields\'>\"+\n\t\t\t\"<input type=\'text\' id=\'service_code\"+index+\"\' name=\'service_code\"+index+\"\' id=\'service_code\"+index+\"\' size=\'03\' maxlength=\'30\' value=\'\' onBlur=\'ServcodeLookup(service_code\"+index+\",service_desc\"+index+\",\"+index+\");\'>\"+\"<input type=\'text\' id=\'service_desc\"+index+\"\' name=\'service_desc\"+index+\"\' id=\'service_desc\"+index+\"\' size=\'07\' maxlength=\'30\' value=\'\' onBlur=\'ServcodeLookup(service_desc\"+index+\",service_code\"+index+\",\"+index+\");\' >\"+\"<input type=\'button\' class=\'button\' name=\'serv_code\"+index+\"\' id=\'serv_code\"+index+\"\' id=\'serv_code\"+index+\"\' value=\'?\' tabindex=\'0\' onClick=\'ServcodeLookup(service_desc\"+index+\",service_code\"+index+\",\"+index+\");\'>\"+\"</td>\"+\n\t\t\t\"<td width=\'3.5%\' class=\'fields\'>\"+\n\t\t\t\"<input type=\'text\' id=\'Rc\"+index+\"\' name=\'Rc\"+index+\"\' id=\'Rc\"+index+\"\' size=\'07\' maxlength=\'30\' value=\'\' readonly>\"+\"</td>\"+\n\t\t\t\"<td width=\'3.5%\' class=\'fields\'>\"+\n\t\t\t\"<input type=\'text\' id=\'qty\"+index+\"\' name=\'qty\"+index+\"\' id=\'qty\"+index+\"\' size=\'07\' maxlength=\'30\' value=\'1.00\' onBlur=\'estdeposit(\"+index+\");putdeci(this);\' onKeyPress=\'return(ChkNumberInput(this,event,2))\' \"+\"</td>\"+\n\t\t\t\"<td width=\'3.5%\' class=\'fields\'> \"+\n\t\t\t\"<input type=\'text\' id=\'charges_\"+index+\"\' name=\'charges_\"+index+\"\' id=\'charges_\"+index+\"\' size=\'07\' maxlength=\'30\' value=\'\' onBlur=\'findTotal();\' >\"+\"</td>\"+\n\t\t\t\"<td width=\'3.5%\' class=\'fields\'> \"+\n\t\t\t\"<input type=\'checkbox\' name=\'selected_row\"+index+\"\' id=\'selected_row\"+index+\"\'  id=\'selected_row\"+index+\"\' value=\'\' onClick=\'\'>\"+\"</td>\"+\n\t\t\t\"</tr>\";\n\t\t\t//alert(tableRow);\t\t\t\n\n\t\t $(\'#estimatedeposit\').append(tableRow);\n\t\t Datetime(index);\n\t\t \n\t\t //if($(\'#esttotal\').val())\n\t\t\n\t \n\t }\n\t \t\t\n\t\t\t\tfunction delrow()\n\t \t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\tvar index = $(\'#estimatedeposit tr:last\').attr(\'data-id\');\n\t\t\t\t\t/*if ($(\'#selected_row1\').prop(\"checked\"))\n\t\t\t\t\t {\n\t\t\t\t\t\t//alert(\'in first row\');\n\t\t\t\t\t\tdocument.getElementById(\"charges_1\").value=\"\";\n\t\t\t\t\t\tdocument.getElementById(\"service_code1\").value=\"\";\n\t\t\t\t\t\tdocument.getElementById(\"service_desc1\").value=\"\";\n\t\t\t\t\t\tfindTotal();\n\t\t\t\t\t \t\n\t\t\t\t\t }\n\t\t\t\t\t else\n\t\t\t\t\t\t {*/\n\t\t\t\t\tfor(i=0;i<=index;i++)\n\t\t\t \t\t{\n\t\t\t \t\t\tif ($(\'#selected_row\'+i).prop(\"checked\"))\n\t\t\t \t\t\t{ \t\n\t\t\t \t\t\t$(\'#tr_\'+i).remove();\n\t\t\t \t\t\tfindTotal();\n\t\t\t \t\t\t}\n\t\t\t \t\t       \t\n\t\t\t \t\t}\n\t\t\t\t\tvar i=1;\n\t\t\t \t\t$(\'input[id^=line]\').each(function(){\n\t              \t$(this).val(i);\n\t              \ti++;\n\t          \t\t});\n\t\t\t\t\t\t// }\n\t \t\t\t}\n\t\t\t\n\t\t\tfunction save()\n\t\t\t{\n\t\t\t\tvar lrow = $(\'#estimatedeposit tr:last\').attr(\'data-id\');\n\t\t\t\t//var lastrow=document.getElementById(\"lastrow\").value;\n\t\t\t\t\n\t\t\tvar index = $(\'#estimatedeposit tr:last\').attr(\'data-id\');\n\t\t\n\n\t\t\tif($(\'#charges_\'+index).val()==\'\')\n\t\t\t\t{\n\t\t\t\talert(\'Charges Cannot be null\');\n\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\tif($(\'#qty\'+index).val()==\'\')\n\t\t\t\t{\n\t\t\t\talert(getMessage(\'BL00302\',\'BL\'));\n\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(lrow==undefined)\n\t\t\t\t\t{\n\t\t\t\t\tlrow=0;\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\tvar base_qty=document.getElementById(\"base_qty\").value;\n\t\t\t\t//alert(\"base_qty\"+base_qty);\n\t\t\t\tvar base_rate=document.getElementById(\"base_rate\").value;\n\t\t\t\t//alert(\"base_rate\"+base_rate);\n\t\t\t\tvar day_type_code=document.getElementById(\"day_type_code\").value;\n\t\t\t\t//alert(\"day_type_code\"+day_type_code);\n\t\t\t\tvar time_type_code=document.getElementById(\"time_type_code\").value;\n\t\t\t\t//alert(\"time_type_code\"+time_type_code);\t\t\t\t\n\t\t\t\tvar esttotal=document.getElementById(\"esttotal\").value;\n\t\t\t\t\n\t\t\t\tvar dynamicParams= \'\';\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tfor(var i=1;i<=lrow;i++)\n\t\t\t\t{\t \n\t\t\t\t\n\t\t\t\t\tdynamicParams += \'qty\'+i+\'=\'+$(\'#qty\'+i).val()+\'&\'+\n                    \'service_code\'+i+\'=\'+$(\'#service_code\'+i).val()+\'&\'+\n                    \'service_desc\'+i+\'=\'+$(\'#service_desc\'+i).val()+\'&\'+\n                    \'charges_\'+i+\'=\'+$(\'#charges_\'+i).val()+\'&\'+\n                    \'datetime\'+i+\'=\'+$(\'#datetime\'+i).val()+\'&\'+\n\t\t\t\t\t\'service_indicator\'+i+\'=\'+$(\'#service_indicator\'+i).val()+\'&\'+\t\t\t\n\t\t\t\t\t\'line\'+i+\'=\'+$(\'#line\'+i).val()+\'&\'+\t\t\t\t\t\t\t\t\n\t\t\t\t\t\'Rc\'+i+\'=\'+$(\'#Rc\'+i).val()+\'&\';\n\t\t\t\t\t//\'esttotal\'+i+\'=\'+$(\'#esttotal\'+i).val()+\'&\';\n\t\t\t\t\t//alert(\'esttotal\'+\'esttotal\'+i+\'=\'+$(\'#esttotal\'+i).val()+\'&\');\n\t\t\t\t\t\n\t\t\t\t } \n\t\t\t\t\n\t \t\t\t\t$.ajax({\t\n\t\t\t\t\ttype : \'POST\',\n\t\t\t\t\turl:\"../jsp/Estimatdepositajaxcall.jsp?lrow=\"+lrow+\"&base_qty=\"+base_qty+\"&base_rate=\"+base_rate+\"&day_type_code=\"+day_type_code+\"&time_type_code=\"+time_type_code+\"&esttotal=\"+esttotal,\n\t\t\t\t\tdata:dynamicParams,\n\t\t\t\t\tasync:false,\n                    success:function(data){\n                     //alert(\'success\');\n                    }\n                    }); \n\t \t\t\t\t//window.returnvalue();\n\t\t\t\tvar stlmttotal=document.getElementById(\'esttotal\').value;\n\t\t\t\tparent.window.returnValue=stlmttotal;\n\t\t\t\tparent.window.close();\n\t\t\t\t/*top.returnValue = stlmttotal\n\t\t\t\t\t\ttop.close();*/\n\t\t\t\t}\n\t\t\t\t\n\t \t\n\t \t\t\t\n\t\t\t\n\t\t\t\t function Datetime(index)\n\t\t\t\t {\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar today=getCurrentDate(\'DMYHMS\' ,\'\"+locale+\"\');\n\t\t\t\t\t\t\tdocument.getElementById(\'datetime\'+index).value = today;\n\t\t\t\t}\n\t\t\t\t function roundToTwo(num) \n\t\t\t\t {    \n\t\t\t\t\t \t\treturn +(Math.round(num + \"e+2\")  + \"e-2\");\n\t\t\t\t }\n\n\t\t\t\t\t \n\n\t\t\t\t function findTotal()\n\t\t\t\t {\n\t\t\t\t\t //alert(\'calling findtotal\')\n\t\t\t\t       \t  var total_amount = 0; \n\t\t\t\t\t\t\t var rowAmount = 0;\n\t\t\t\t          $(\'input[id^=charges_]\').each(function(){\n\t\t\t\t        \t if($(this).val() == \'\'){\n\t\t\t\t        \t\t rowAmount = 0;\n\t\t\t\t        \t }\n\t\t\t\t        \t else{\n\t\t\t\t        \t\t rowAmount = $(this).val();\n\t\t\t\t        \t }\n\t\t\t\t       \t  total_amount = parseFloat(total_amount) + parseFloat(rowAmount);\n\t\t\t\t\t      total_amount = roundToTwo(total_amount);\n\t\t\t\t          });    \n\t\t\t\t        \n\t\t\t\t          \n\t\t\t\t          $(\'#esttotal\').val(parseFloat(total_amount).toFixed(2)); \n\t\t\t\t  }\n\t\t\t\t \n\t\t\t function estdeposit(index)\n\t\t\t\t {\t\n\t\t\t\t \t\n\t\t\t\t \tif($(\'#qty\'+index).val()==\'\')\n\t\t\t\t \t\t{\n\t\t\t\t \t\talert(getMessage(\'BL00302\',\'BL\'));\n\t\t\t\t \t\treturn;\n\t\t\t\t \t\t}\n\t\t\t\t \tvar formObj=document.Esmfordeposit;\n\t\t\t\t \tvar facility_id=formObj.facility_id.value;\n\t\t\t\t \tvar locale=formObj.locale.value;\n\t\t\t\t \tvar patient_id=formObj.patient_id.value;\n\t\t\t\t \tvar episode_id=formObj.episode_id.value;\n\t\t\t\t \tvar episode_type=formObj.episode_type.value;\n\t\t\t\t \tvar encounter_id=formObj.encounter_id.value;\t\t\t\t \t\n\t\t\t\t";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 =" \tvar visit_id=formObj.visit_id.value;\t\t\t\t \t\n\t\t\t\t \tvar qty=document.getElementById(\'qty\'+index).value;\n\t\t\t\t \tvar service_code=document.getElementById(\'service_code\'+index).value;\n\t\t\t\t \tvar service_indicator=document.getElementById(\'service_indicator\'+index).value;\n\t\t\t\t \tvar datetime=document.getElementById(\'datetime\'+index).value;\n\t\t\t\t \t$.ajax({\t\n\t\t\t\t\t\ttype : \'POST\',\n\t\t\t\t\t\turl : \"../jsp/BlDepositremarks.jsp?func_mode=estdep&facility_id=\"+facility_id+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&qty=\"+qty+\"&service_code=\"+service_code+\"&service_indicator=\"+service_indicator+\"&datetime=\"+datetime,\n\t\t\t\t\t    async:false,\n\t\t\t\t\t    dataType:\"text\",\n\t\t\t\t\t    success: function(data){\n\t\t\t\t\t    \t\n\t\t\t\t\t    \tvar dataArr = $.trim(data).split(\"::\"); \t\n\t\t\t\t\n\t\t\t\t\t    \tvar error_id=dataArr[2];\n\t\t\t\t\n\t\t\t\t    \t\t\t\t\t\t\t\t    \t\n\t\t\t\t\t   \t\tif((error_id==\'\' || error_id==\'null\'))\n\t\t\t\t\t    \t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t   \t\t\t/*var charges=\n\t\t\t\t\t   \t\t\talert(charges);*/\n\t\t\t\t\t   \t\t\t\n\t\t\t\t\t    \t\tdocument.getElementById(\'Rc\'+index).value=dataArr[0];\n\t\t\t\t\t   \t\t\t\t\tif(document.getElementById(\'Rc\'+index).value==\'R\')\n\t\t\t\t\t    \t\t{\n\t\t\t\t\t    \t\t\t\t\t\t    \t\tdocument.getElementById(\'charges_\'+index).readOnly=true;\n\t\t\t\t\t    \t\t\t\t\t\t    \t\t\t\t\t\t\t    \t\t}\n\t\t\t\t\t   \t\t\t\t\telse if(document.getElementById(\'Rc\'+index).value==\'C\')\n\t\t\t\t\t\t\t    \t\t{\n\t\t\t\t\t\t\t    \t\t\t\t\t\t    \t\tdocument.getElementById(\'qty\'+index).readOnly=true;\n\t\t\t\t\t\t\t    \t\t}\n\t\t\t\t\t   \t\t\t\t\t\n\t\t\t\t\t   \t\t\tvar chrgs=dataArr[1];\t\t\t\t\t   \t\t\t\n\t\t\t\t\t   \t\t\tchrgs=parseFloat(chrgs).toFixed(2)\n\t\t\t\t\t   \t\t\t//alert(chrgs);\t\t\t\t\t   \t\t\t\n\t\t\t\t\t    \t\tdocument.getElementById(\'charges_\'+index).value=chrgs;                 \n\t\t\t\t\t\t    \tdocument.getElementById(\'base_qty\').value=dataArr[3];\n\t\t\t\t\t\t    \tdocument.getElementById(\'base_rate\').value=dataArr[5];\n\t\t\t\t\t\t    \tdocument.getElementById(\'day_type_code\').value=dataArr[4];\n\t\t\t\t\t\t    \tdocument.getElementById(\'time_type_code\').value=dataArr[6];\t    \t\t\n\t\t\t\t\t    \t\tfindTotal();\n\t\t\t\t\t    \t\t}\n\t\t\t\t\t    \telse\n\t\t\t\t\t    \t\t{\n\t\t\t\t\t    \t\t\n\t\t\t\t\t    \t\talert(getMessage(error_id,\"BL\"));\n\t\t\t\t\t    \t\t\n\t\t\t\t\t    \t\t}\n\t\t\t\t\t    \n\t\t\t\t\t    }\n\t\t\t\t\t\n\t\t\t\t\t});\n\t\t\t\t\t    \n\t\t\t\t } \n\t\t\t\t \n\t\t\t \n\n\t \n</script>\n\n</head>\n<body>\n\n<form name=\'Esmfordeposit\' id=\'Esmfordeposit\' method=\'post\' action=\'\' onLoad=\'\' scrolling=no >\n<div>\n\t<table  border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\n\t<tr><td class=\'COLUMNHEADER\' colspan=\'16\'>";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="</td></tr>\n\t</table></div>\n\t<br/><br/>\n\t<div overflow:scroll>  \n\t<!-- id=\"tblcontainer\" STYLE=\"overflow: auto; width: 1020px; height: 195px;   padding:3px; margin: 0px\">-->\n\t\n\t<table id=\'esmdeposit\' border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\'  width=\'100%\'>\t\n\t\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADER\' width=\'10.5%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t \t<td class=\'COLUMNHEADER\' width=\'12.5%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'14.5%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'12.5%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\n\t\t<td class=\'COLUMNHEADER\' width=\'12.5%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\n\t\t</tr>\n </table>\n \n \t\n  \t<table id=\'estimatedeposit\' border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' id=\'\' width=\'100%\'>\t\n\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr data-id=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'tr_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'> \n \t<td  width=\'10.5%\' class=\'FIELDS\'><input type=\'text\' id=\'line";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' name=\'line";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' size=\'05\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' readonly> </td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'service_indicator";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' name=\'service_indicator";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onBlur=\'\' readonly> </td> \n \t <td  width=\'14.5%\' class=\'FIELDS\'><input type=\'text\' id=\'datetime";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' name=\'datetime";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' size=\'17\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' readonly> </td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'service_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' name=\'service_code";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' size=\'03\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' > <input type=\'text\' id=\'service_desc";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' name=\'service_desc";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' size=\'07\' maxlength=\'22\'  value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  onBlur=\"\"  ><input type=\'button\' class=\'button\' name=\"servcode\" id=\"servcode\" id=\"servcode\" value=\'?\' tabindex=\'0\' onClick=\"ServcodeLookup(service_desc1,service_code1,1);\"></td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'Rc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' name=\'Rc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' size=\'07\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' readonly > </td> \n \t <td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'qty";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' name=\'qty";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onBlur=\"estdeposit(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'); putdeci(this);\" onKeyPress=\'return(ChkNumberInput(this,event,2))\' > </td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'charges_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' name=\'charges_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  size=\'07\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' readonly > </td> \n \t<td  width=\'12.5%\'  class=\'FIELDS\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'selected_row";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\'\' onClick=\"\"></td>\t\n \t</tr>\n\t\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<tr data-id=\'1\' id=\'tr_1\'> \n \t<td  width=\'10.5%\' class=\'FIELDS\'><input type=\'text\' id=\'line1\' name=\'line1\' id=\'line1\' size=\'05\' maxlength=\'30\' value=\'1\' readonly > </td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'service_indicator1\' name=\'service_indicator1\' id=\'service_indicator1\' size=\'05\' maxlength=\'30\' value=\'S\' onBlur=\'\' readonly> </td> \n \t <td  width=\'14.5%\' class=\'FIELDS\'><input type=\'text\' id=\'datetime1\' name=\'datetime1\' id=\'datetime1\' size=\'17\' maxlength=\'30\' value=\'\'  readonly > </td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'service_code1\' name=\'service_code1\' id=\'service_code1\' size=\'03\' maxlength=\'30\' value=\'\' onBlur=\"if(this.value!=\'\'){ ServcodeLookup(service_code1,service_desc1,1);}else{ fnClearCode(service_desc1); }\" > <input type=\'text\' id=\'service_desc1\' name=\'service_desc1\' id=\'service_desc1\' size=\'07\' maxlength=\'22\'  value=\'\'  onBlur=\"if(this.value!=\'\'){ ServcodeLookup(service_desc1,service_code1,1);} else{ fnClearCode(service_desc1); }\"  ><input type=\'button\' class=\'button\' name=\"servcode\" id=\"servcode\" id=\"servcode\" value=\'?\' tabindex=\'0\' onClick=\"ServcodeLookup(service_desc1,service_code1,1);\"></td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'Rc1\' name=\'Rc1\' id=\'Rc1\' size=\'07\' maxlength=\'30\' value=\'\' readonly > </td> \n \t <td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'qty1\' name=\'qty1\' id=\'qty1\' size=\'07\' maxlength=\'30\' value=\'1.00\' onBlur=\"estdeposit(1); putdeci(this);\" onKeyPress=\'return(ChkNumberInput(this,event,2))\'> </td> \n \t<td  width=\'12.5%\' class=\'FIELDS\'><input type=\'text\' id=\'charges_1\' name=\'charges_1\' id=\'charges_1\'  size=\'07\' maxlength=\'30\' value=\'\' onBlur=\'findTotal();\' > </td> \n \t<td  width=\'12.5%\'  class=\'FIELDS\'><input type=\"checkbox\" name=\'selected_row1\' id=\'selected_row1\' id=\'selected_row1\' value=\'\' onClick=\"\"></td>\t  \n\t\n\t</tr> \n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t</table>\t\n\t </div> \n\t\n<div>\n<table>\n<tr>\n<td width=\'25%\'>\n</td>\n<td width=\'25%\'>\n</td>\n<td width=\'25%\'>\n</td>\n\n<td width=\'25%\' >\n\t\t <label>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</label>\n\t\t <input type=\'text\' id=\'esttotal\' name=\'esttotal\' id=\'esttotal\' size=\'22\' maxlength=\'22\'  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'  onBlur=\"\" readonly >\t\t \t\n\t\t </td>\n</tr>\n<tr>\t<td width=\'26%\'>\n\t\t<INPUT TYPE=\'button\' name=\'add_button\' id=\'add_button\' id=\'add_button\' class=\"BUTTON\" VALUE=\"Add Row\" size=\'5\' onClick=\'addrow();\'>\n\t\t<INPUT TYPE=\'button\' name=\'del_button\' id=\'del_button\' id=\'del_button\' class=\"BUTTON\" VALUE=\"Delete Row\" size=\'5\' onClick=\'delrow();\'>\n\t\t<INPUT TYPE=\'button\' name=\'savebutton\' id=\'savebutton\' id=\'savebutton\' class=\"BUTTON\" VALUE=\"Save\" size=\'5\' onClick=\'save();\'></td>\n\t\t<td>\n\t\t<td width=\'30%\'></td>\n\t\t<td width=\'25%\'></td>\n</tr>\n</table>\n</div>\n\n\t <input type= \'hidden\' name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type= \'hidden\' name=\"facility_id\" id=\"facility_id\"  value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\t\n\t<input type= \'hidden\' name=\"patient_id\" id=\"patient_id\"  value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\t\n\t<input type= \'hidden\' name=\"episode_type\" id=\"episode_type\"  value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\t\n\t<input type= \'hidden\' name=\"episode_id\" id=\"episode_id\"  value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\t\n\t<input type= \'hidden\' name=\"visit_id\" id=\"visit_id\"  value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\t\n\t<input type= \'hidden\' name=\"encounter_id\" id=\"encounter_id\"  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\t\n\t<input type= \'hidden\' name=\"lastrow\" id=\"lastrow\"  id=\"lastrow\"  value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'> \n\t<input type=\'hidden\' name=\"base_qty\" id=\"base_qty\"  id=\"base_qty\"  value=\'\'> \n\t<input type=\'hidden\' name=\"base_rate\" id=\"base_rate\"  id=\"base_rate\"  value=\'\'>\n\t<input type=\'hidden\' name=\"day_type_code\" id=\"day_type_code\"  id=\"day_type_code\"  value=\'\'>\n\t<input type=\'hidden\' name=\"time_type_code\" id=\"time_type_code\"  id=\"time_type_code\"  value=\'\'> \n\t\n\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );
	
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

private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
} 

private String qtydecimal(String input)
{
		CurrencyFormat cf1 = new CurrencyFormat();		
	input = cf1.formatCurrency(input,2);  
	return input;
}




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
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);



HttpSession httpSession = request.getSession(false);

Properties p = (Properties)httpSession.getValue("jdbc");

String locale	= (String)session.getAttribute("LOCALE");	
if(locale==null || locale.equals("")) locale="en";	


String facilityid = (String) session.getValue("facility_id");
System.out.println("facilityid::::::"+facilityid);
if (facilityid==null) facilityid = "";

String	strloggeduser	=  (String) session.getValue("login_user");	
if (strloggeduser==null) strloggeduser = "";

String strclientip = p.getProperty("client_ip_address");
if (strclientip==null) strclientip = "";

String patient_id = request.getParameter("patient_id");	
if(patient_id==null) patient_id="";	
System.out.println("patient_id="+patient_id);


String episode_type = request.getParameter("episode_type");	
if(episode_type==null) episode_type="";	
System.out.println("episode_type ="+episode_type );



String strepisode_id = replaceNull(request.getParameter("episode_id"));	
int episode_id=0;
if("".equals(strepisode_id)){
	episode_id=0;
}		
else
{
	try
	{
		episode_id=Integer.parseInt(strepisode_id);	
	}catch(Exception e)
	{
		episode_id=0;
	}
}
//if(episode_id==null) episode_id="";	
System.out.println("Episode id ="+episode_id);

String strVisit_id = replaceNull(request.getParameter("visit_id"));	
int visit_id=0;
if("".equals(strVisit_id)){
	visit_id=0;
}		
else
{
	try
	{
		visit_id=Integer.parseInt(strVisit_id);	
	}catch(Exception e)
	{
		visit_id=0;
	}
}
System.out.println("visit_id="+visit_id);
String strencounter_id = replaceNull(request.getParameter("encounter_id"));	
int encounter_id=0;
if("".equals(strencounter_id)){
	encounter_id=0;
}		
else
{
	try
	{
		encounter_id=Integer.parseInt(strencounter_id);	
	}catch(Exception e)
	{
		encounter_id=0;
	}
} 
System.out.println("encounter_id="+encounter_id);
String beanId = "EstimateDepositBean";
String beanName = "eBL.BLEstimateDepositBean";
BLEstimateDepositBean depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request); 
depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request);
List<BLEstimateDepositBean> depositlist2 = depositbean.getDepositList();
int lastRow = 0;

//int size=depositlist1.size();

/*/* 
System.out.println("Bean Add");
for (Iterator iterator = depositlist2.iterator(); iterator.hasNext();)
{
depositbean = (BLEstimateDepositBean) iterator.next();
System.out.println("service code="+depositbean.getService_code());
System.out.println("charges="+depositbean.getCharges());
System.out.println("qty="+depositbean.getQty());
System.out.println("Rc="+depositbean.getRate_charge());
System.out.println("datetime="+depositbean.getDatetime());
System.out.println("line="+depositbean.getLine());
System.out.println("service_indicator="+depositbean.getService_indicator());
System.out.println("service_desc="+depositbean.getService_desc());
} */





            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 
	if(depositlist2!=null && !depositlist2.isEmpty())
	{
		//lastRow = depositlist2.size();
		int rowIndx = 1;
	for (Iterator iterator = depositlist2.iterator(); iterator.hasNext();)
	{	
	depositbean = (BLEstimateDepositBean) iterator.next();
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(depositbean.getLine()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( depositbean.getService_indicator()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( depositbean.getDatetime()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(depositbean.getService_code()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(depositbean.getService_desc() ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(depositbean.getRate_charge() ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(depositbean.getQty() ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( qtydecimal(depositbean.getCharges())));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block42Bytes, _wl_block42);

	rowIndx++;
		
	}
	}
	else
	{
		//lastRow = 1;
	
            _bw.write(_wl_block43Bytes, _wl_block43);

	}
	
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(depositbean.getEsttotal()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facilityid ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(lastRow ));
            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EnterServiceItem.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Line.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceIndicator.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceDate/Time.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceCode.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.R_C.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charges.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TotalHeading.label", java.lang.String .class,"key"));
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
}
