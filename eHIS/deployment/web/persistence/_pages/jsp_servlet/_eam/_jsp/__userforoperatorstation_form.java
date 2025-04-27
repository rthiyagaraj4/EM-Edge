package jsp_servlet._eam._jsp;

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

public final class __userforoperatorstation_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/UserForOperatorStation_Form.jsp", 1718005414572L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eAM/js/UserForOperatorStation.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\t\tvar sStyle=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n          function fetchVals(form,current,sel)\n\t\t\t\t{ \n\t\t\t\t\tfucn=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\tvar name=current.name;\n\t\t\t\t\tvar value=current.value;\n\n\t\t\t\t\tif(name==\"facility\")\n\t\t\t\t\t{\n\t\t\t\t\t\t//removeitems(form.userid);\n\t\t\t\t\t\tdocument.forms[0].userid.value=\'\';\n\t\t\t\t\t\tdocument.forms[0].user_desc.value=\'\';\n\t\t\t\t\t\tremoveitems(form.oprstn);\n\n\t\t\t\t\tvar HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'>\";\n\t\t\t\t\tHTMLVal = HTMLVal +\"<form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eAM/jsp/FetchValForUserForOperStn.jsp\'>\";\n\t\t\t\t\tHTMLVal = HTMLVal +\"<input name=\'name\' id=\'name\' type=\'hidden\' value= \'\"+name + \" \'><input name=\'value\' id=\'value\' type=\'hidden\' value=\'\"+value + \"\'>\";\n\t\t\t\t\tHTMLVal = HTMLVal +\"</form></BODY></HTML>\";\n\t\t\t\t\tparent.messageFrame.document.write(HTMLVal);\n\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\tfunction removeitems(obj)\n\t\t\t\t{\n\t\t\t\t\tvar len=obj.length;\n\t\t\t\t\tvar i=1;\n\t\t\t\t\twhile(i<len)\n\t\t\t\t\t{\n\t\t\t\t\t\tlen=obj.length\n\t\t\t\t\t\tobj.remove(i)\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\tfunction call(sel)\n\t\t\t\t{\n\t\t\t\t\tfetchVals(facility_form,facility_form.clinic,sel)\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tasync function displayUser(obj,target,target_id)\n\t\t\t\t{\n\n\n\t\t\t\tvar retVal =    new String();\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar tit=getLabel(\'Common.user.label\',\'Common\');\n\n              //Below code was modified by N Munisekhar on 24-Jan-2013 against SKR-SCF-0761 [IN:037419] \n\t\t\t\tsql = \"select a.appl_user_id code, b.appl_user_name description from SM_FACILITY_FOR_USER a, sm_appl_user_lang_vw  b where a.appl_user_id = b.appl_user_id and language_id = \'\"+localeName+\"\' and a.facility_id = \'\"+document.forms[0].facility.value+\"\' and upper(a.APPL_USER_ID) like upper(?) and upper(b.APPL_USER_NAME) like upper(?) and b.eff_status = \'E\' \";\n               // end of SKR-SCF-0761 [IN:037419] \n\n\t\t\t\t//select postal_code code, short_desc description from mp_postal_code where eff_status = \'E\' and upper(postal_code) like upper(?) and upper(short_desc) like upper(?) order by 2\";\n\t\t\t\t\t\n\t\t\t\targumentArray[0] = sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t\t//argumentArray[6] = DESC_CODE ;\n\t\t\t\t//argumentArray[7] = DESC_LINK ;\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\tif (retVal !=null && retVal !=\"\")\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\ttarget_id.value=arr[0];\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\ttarget_id.value=\"\";\n\t\t\t\t}\n\n\n\n\n\n\t\t\t\t\n\t\t\t}\n\n\t\t\tasync function displayUser1(obj,target,target_id)\n\t\t\t\t{\n\n\t\t\t\tvar retVal =    new String();\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\t//var tit=encodeURIComponent(getLabel(\'Common.user.label\',\'Common\'));\n\t\t\t\t//Commented the above code for SRR20056-SCF-6902 [IN:026514] by Suresh M on 11.02.2011\n\t\t\t\tvar tit=getLabel(\'Common.user.label\',\'Common\');\n\t\t\t\tif(obj.value !=\"\")\n\t\t\t\t\t{\n\n\t\t\t\tsql = \"select appl_user_id  code,appl_user_name description  from sm_facility_for_user_vw where facility_id = \'\"+document.forms[0].facility.value+\"\' and appl_user_id like upper(?) and upper(appl_user_name) like upper(?) order by 2\";\n\n\n\t\t\t\t//select postal_code code, short_desc description from mp_postal_code where eff_status = \'E\' and upper(postal_code) like upper(?) and upper(short_desc) like upper(?) order by 2\";\n\t\t\t\t\t\n\t\t\t\targumentArray[0] = sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\tif (retVal !=null && retVal !=\"\")\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\ttarget_id.value=arr[0];\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\ttarget_id.value=\"\";\n\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].userid.value=\'\';\n\t\t\t\t\t\tdocument.forms[0].user_desc.value=\'\';\n\t\t\t\t\t}\n\t\t}\n\t\t\t</script>\n\t</head>\n\n\t<body  onLoad=\"FocusFirstElement();\" OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\' >\n\t\t<form name=\'UserForOperationStation_Form\' id=\'UserForOperationStation_Form\' action=\'../../servlet/eAM.UserForOperatorStationServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t<div>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br><br>\n\t\t\t<input type=\"hidden\" name=\"sStyle\" id=\"sStyle\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'auto\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n                        </tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t     <td width=\'10%\'>&nbsp;</td>\n    \t\t\t\t     <td  class=\'label\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n    \t\t\t\t     <td  class=\'fields\' colspan=\'2\'><!--width=\'60%\'-->&nbsp;&nbsp;\n\n\t\t\t\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n    \t\t\t\t     <select name=\'facility\' id=\'facility\' onchange=\'fetchVals(this.form,this)\'>\n    \t\t\t\t     <option value=\'\'>----------";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="---------</option>\n    \t\t\t\t     ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n    \t\t\t\t    \n    \t\t\t\t      </select>&nbsp<img src=\'../../eMP/images/mandatory.gif\'></img>\n    \t\t\t\t    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n    \t\t\t\t   </td>\n    \t\t\t\t   <td width=\'10%\'>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n                                </tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t      <td width=\'10%\'>&nbsp;</td>\n    \t\t\t\t      <td   class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n    \t\t\t\t     <td  class=\'fields\' colspan=\'2\'>&nbsp;&nbsp;\n    \t\t\t\t     ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n    \t\t\t\t    <input type=\'text\'   name=\'user_desc\' id=\'user_desc\' size=\'30\' onblur=\'displayUser1(this,user_desc,userid)\' maxlength=\'60\'><input type=\'hidden\' name=\'userid\' id=\'userid\' value=\"\"><input type=\'button\' class=\'button\' name=\'userIdbutton\' id=\'userIdbutton\' value=\'?\' onClick=\'displayUser(this,user_desc,userid)\'>\n    \t\t\t\t    \t\t&nbsp<img src=\'../../eMP/images/mandatory.gif\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n    \t\t\t\t   </td>\n    \t\t\t\t   <td width=\'10%\'>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n                                </tr>\n\n\n\t\t\t \t<tr>\n\t\t\t \t     <td width=\'10%\'>&nbsp;</td>\n\t\t\t\t     <td  class=\'label\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n    \t\t\t\t     <td  class=\'fields\' colspan=\'4\'>&nbsp;&nbsp;\n    \t\t\t\t      ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n    \t\t\t\t   \t<select name=\'oprstn\' id=\'oprstn\'>\n    \t\t\t\t   \t<option value=\'\'>----- ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="-----</option>\n    \t\t\t\t   \t</select>\n    \t\t\t\t    \t <img src=\'../../eMP/images/mandatory.gif\'></tr>\n    \t\t\t\t    \t ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n    \t\t\t\t     </td>\n    \t\t\t\t    </tr>\n\n                <tr>  <td  class=\'label\' colspan=\'4\'>&nbsp;&nbsp;<td>&nbsp;</td> </tr>\t\t\t\t\n\n\t\t\t\t<tr>\n\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t<td   class=\'label\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<input type=\'text\' name=\'eff_date_from1\' id=\'eff_date_from1\' size=\'10\'  value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onblur=\"DateCompare_from(\'from\',this,sysdate);\" maxlength=\'10\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" ><input type=\'hidden\' name=\'eff_date_from1_disp\' id=\'eff_date_from1_disp\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'eff_date_from1\');\">&nbsp<img src=\'../../eMP/images/mandatory.gif\'><input type=\'hidden\' name=\'eff_date_from1_greg\' id=\'eff_date_from1_greg\' value=\'\'></td>\n\n\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;&nbsp\n\t\t\t\t<input type=\'text\'  name=\'eff_date_to1\' id=\'eff_date_to1\' size=\'10\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' maxlength=\'10\' onblur=\"DateCompare_from(\'To\',this,sysdate);DateCompare3(eff_date_from1,this);\"><input type=\'hidden\' name=\'eff_date_to1_disp\' id=\'eff_date_to1_disp\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'eff_date_to1\');\"><input type=\'hidden\' name=\'eff_date_to1_greg\' id=\'eff_date_to1_greg\' value=\'\'></td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n                </tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t<input type=\'hidden\' name=\'eff_date_from\' id=\'eff_date_from\'  >\n\t\t<input type=\'hidden\' name=\'eff_date_fromold\' id=\'eff_date_fromold\'  value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=\'hidden\' name=\'eff_date_to\' id=\'eff_date_to\' >\n\t\t<input type=\'hidden\' name=\'function1\' id=\'function1\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<INPUT TYPE=\'hidden\' name=\'current\' id=\'current\'>\n\t\t<input type=\'hidden\' name=\'fromcheck\' id=\'fromcheck\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Statement stmtsys=null;
	ResultSet rsetsys=null ;
	Statement stmt1=null;
	ResultSet rset1 = null;
	ResultSet rset=null;
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	
	String login_user=p.getProperty( "login_user" ) ;
	String facilityid=(String)session.getValue("facility_id") ;

	String locale=(String)session.getAttribute("LOCALE");

	String facilityId = request.getParameter("facilityId");
		if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 
	
	String uid="";
	String uname="";

	String fid="";
	String fname="";

	String oprstn="";
	String oprstnname="";

	String fnval="insert";

	String datefr="";
	String dateto="";
	//String sysdate="";
	String fromchk="check";

	SimpleDateFormat formatter=null;
	String s="";

	String datefr1="";
	
		String dateto_disp="";
		String datefr_disp="";
		String sqlDate_disp="";
	
	String sysdtsql="select to_char(sysdate,'dd/mm/yyyy') from dual ";
	
	
	uid=request.getParameter("uid");
	datefr=request.getParameter("date");

	try
	{
		con = ConnectionManager.getConnection(request);
		stmtsys=con.createStatement();
		rsetsys=stmtsys.executeQuery(sysdtsql);
		rsetsys.next();
		String sqlDate=rsetsys.getString(1);
		if(rsetsys!=null) rsetsys.close();
        if(stmtsys!=null) stmtsys.close();
		stmt=con.createStatement();
		/*rset=stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') from dual");
		rset.next();
		sysdate=rset.getString(1);
		if(rset!=null) rset.close();
		if(stmt!=null)stmt.close();*/
	if(uid!=null )
	{
		uid=uid.trim();
		fnval="modify";
		
		String sql="select a.*, to_char(a.eff_date_from,'dd/mm/rrrr'),decode(sign(trunc(a.eff_date_from) - trunc(sysdate)) ,'-1','Lower','Higher') ind from am_user_for_oper_stn_vw a where   to_char(eff_date_from,'dd/mm/yyyy')=? and appl_user_id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,datefr);
		pstmt.setString(2,uid);

		rset=pstmt.executeQuery();
		if(rset.next())
		{
		uid=rset.getString("appl_user_id");
		uname=rset.getString("appl_user_name");

		oprstn=rset.getString("oper_stn_id");
		oprstnname=rset.getString("SHORT_DESC");

		fid=rset.getString("Facility_id");
		fname=rset.getString("facility_name");

		String ind=rset.getString("ind");
		if(ind.equals("Lower"))
		{
			s="readonly";
			fromchk="nocheck";
		}
		else
			fromchk="check";

		if ( rset.getDate("eff_date_from") != null )
		   {
		        java.util.Date date = rset.getDate("eff_date_from");
		   		formatter = new SimpleDateFormat ("dd/MM/yyyy");
		    	datefr = formatter.format(date);
				datefr_disp=DateUtils.convertDate(datefr,"DMY","en",locale);
		    	date = null;
		    	formatter = null;

		    	date = rset.getDate("eff_date_from");
		    	formatter = new SimpleDateFormat ("dd/MM/yyyy");
		    	datefr1 = formatter.format(date);
		    }
	    	else
	    		datefr="";

	       if ( rset.getDate("eff_date_to") != null )
		{
		         java.util.Date date = rset.getDate("eff_date_to");
		      	 formatter = new SimpleDateFormat ("dd/MM/yyyy");
		    	 dateto = formatter.format(date);
				  dateto_disp=DateUtils.convertDate(dateto,"DMY","en",locale);
		    	 date = null;
		    	 formatter = null;
		 }
	  	else
			   dateto="";

		 if(dateto==null)
			dateto="";
	}
	else
		out.print("no resultset");
}

	 if(datefr==null)
			datefr="";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(fnval.equals("modify"))
    				     {  System.out.println("1");
    				     	out.println("<input type='text' name='t' id='t' value=\""+fname +"\" readonly size='70' maxlength='35'>&nbsp<img src='../../eMP/images/mandatory.gif'>");
    				    	out.println("<input type='hidden' name='facility' id='facility' value=\""+fid+"\">");
    				    }
    				     else{
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

				stmt1=con.createStatement();
				String sqlFac="Select Facility_id,Facility_name Operating_facility_name from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+login_user+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ";
				out.println(sqlFac);
				String dataid="",facName="",sel="";
				rset1=stmt1.executeQuery(sqlFac);
				if(rset1!=null)
				{
				   while(rset1.next())
				   {
					 dataid=rset1.getString(1);
					 facName=rset1.getString(2);
					 if(facilityId.equals(dataid)) sel="selected"; else sel="";
					out.println("<option "+sel+" value=\""+dataid+ "\" >"+facName+"</option>");
    				    }
    				    
    				 }
    				    
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' value=\""+ uname +"\" readonly size='30'maxlength='30'>&nbsp<img src='../../eMP/images/mandatory.gif'>");
    				    	out.println("<input type='hidden' name='userid' id='userid' value=\""+uid+"\">");
    				    }
    				     else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
if(fnval.equals("modify"))
				        {
		 		       	out.println("<input type='text' name='p' id='p' value=\""+oprstnname+"\" readonly size='30'maxlength='30'>&nbsp<img src='../../eMP/images/mandatory.gif'>");
				       	out.println("<input type='hidden' name='oprstn' id='oprstn' value=\""+oprstn+"\">");
				        }

				       else{
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(datefr.equals("")) {
					sqlDate_disp=DateUtils.convertDate(sqlDate,"DMY","en",locale);

					datefr_disp=sqlDate_disp; }
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(datefr_disp));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(s));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(datefr));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dateto_disp));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dateto));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(datefr1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fromchk));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sqlDate));
            _bw.write(_wl_block38Bytes, _wl_block38);

			if(fnval.equals("insert"))
			 out.println("<script>fetchVals(document.UserForOperationStation_Form,document.UserForOperationStation_Form.facility)</script>");
		
            _bw.write(_wl_block39Bytes, _wl_block39);
}  catch(Exception e){out.print(e);}
	  finally
	  {
		  try{
		 if(stmt!=null)	   stmt.close();
		 if(stmt1!=null)   stmt1.close();
		 if(pstmt!=null)   pstmt.close();
		 if(rset!=null)	   rset.close();
		 if(rset1!=null)   rset1.close();
		 if(rsetsys!=null) rsetsys.close();
		  }
		  catch(Exception e)
		  {
			ConnectionManager.returnConnection(con,request);
		  }
		  ConnectionManager.returnConnection(con,request);

	  }
            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.user.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operatorstation.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
}
