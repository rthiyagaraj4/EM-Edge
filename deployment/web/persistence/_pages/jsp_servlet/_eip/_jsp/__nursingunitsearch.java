package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __nursingunitsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursingUnitSearch.jsp", 1742446128237L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t\n\t<script src=\'../../eIP/js/NursUnitRoom.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n// Onchange of Dept .. clear Result Page...\nfunction clearResultPage()\n{\n\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n}\n\n\nfunction CheckForSpecChars_local(event)\n{\n\tvar strCheck = document.forms[0].strCheck.value;\n    //var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* \';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n\nfunction enable_txt(obj)\n{\n\tdocument.forms[0].search_txt.value = \"\";\n if(obj.value==\"\")\n {\n\tdocument.forms[0].search_txt.value = \"\";\n\tdocument.forms[0].search_txt.disabled = true;\n }\n else\n {\n\tdocument.forms[0].search_txt.disabled = false;\n\t\tif(obj.value==\"ID\")\n\t\t\tdocument.forms[0].strCheck.value = \"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*\";\n\t\telse\n\t\t\tif(obj.value==\"DESC\")\n\t\t\t\tdocument.forms[0].strCheck.value = \"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* \";\n }\n}\n\nfunction PopulateResult()\n{\n\ttemp=\'\';\n\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\tvar nursing_unit=document.forms[0].nursing_unit.value;\n\tvar dept_code = document.forms[0].dept_code.value;\n\tvar nursing_unit_type = document.forms[0].nursing_unit_type.value;\n\tvar age_group = document.forms[0].age_group.value;\n\tvar service = document.forms[0].service.value;\n\tvar statusval = document.forms[0].statusval.value;\n\t\n\t//alert(nursing_unit_type);\n\tif(document.forms[0].search_by!=null)\n\t{\n\t  var search_by = document.forms[0].search_by.value;\n\t  var search_txt = document.forms[0].search_txt.value;\n    }\n\tvar called_from=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\tif(nursing_unit!=\"\")\n\t{\n\t\t\n\t\tif(called_from==1)\n\t\t{\n\t\t\t\n\t\t\t//parent.frames[1].location.href=\'../../eIP/jsp/AddModifyNursUnitRoom.jsp?nursing_unit_code=\'+nursing_unit+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&fromSelect=fromSelect;\n\t\t\t//3-06-08\n\t\t\tparent.frames[1].location.href=\'../../eIP/jsp/AddModifyNursUnitRoom.jsp?function_id=\'+\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'+\'&nursing_unit_code=\'+nursing_unit+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&fromSelect=fromSelect&nursing_unit_type=\'+nursing_unit_type+\'&age_group=\'+age_group+\'&service=\'+service+\'&dept_code=\'+dept_code;\n\t\t\tparent.frames[2].location.href=\'../../eIP/jsp/NursUnitRoomDynamicValues.jsp\';\n\t\t}\n\t\telse if(called_from==3)\n\t\t{\n\t\tparent.frames[1].location.href=\'../../eIP/jsp/AddModifyNursUnitSpeciality.jsp?function_id=\'+\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'+\'&nursing_unit_code=\'+nursing_unit+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&fromSelect=fromSelect\';\n\t\tparent.frames[2].location.href=\'../../eIP/jsp/NursUnitSpecialityDynamicValues.jsp\';\n\t\t}\n\t\telse if(called_from==4)\n\t\t{\n\t\tdocument.forms[0].statusval.value=\'Y\';\n\t\tparent.frames[1].location.href=\'../../eIP/jsp/addModifyNursingUnitBkgLt.jsp?nursing_unit_code=\'+nursing_unit+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&fromSelect=fromSelect\';\n\t\tparent.frames[2].location.href=\'../../eIP/jsp/NursingUnitBkgLtDynamicValues.jsp\';\n\t\t}\n\t\telse if(called_from==5)\n\t\t{\n\t\tparent.frames[1].location.href=\'../../eIP/jsp/AddModifyNursUnitService.jsp?function_id=\'+\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'+\'&nursing_unit_code=\'+nursing_unit+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&dept_code=\'+dept_code+\'&fromSelect=fromSelect\';\n\t\tparent.frames[2].location.href=\'../../eIP/jsp/NursUnitServiceDynamicValues.jsp\';\n\t\t}\n\t\telse if(called_from==6)//call is made from day care unit for nursing unit\n\t\t{\n\t\tdocument.forms[0].statusval.value=\'Y\';\n\t\tparent.frames[1].location.href=\'../../eIP/jsp/addModifyDayCareUnitLink.jsp?nursing_unit_code=\'+nursing_unit+\'&search_by=\'+search_by+\'&search_txt=\'+search_txt+\'&dept_code=\'+dept_code+\'&fromSelect=fromSelect\';\n\t\tparent.frames[2].location.href=\'../../eIP/jsp/DayCareUnitPopulate.jsp\';\n\t\t}\n\t}\n\telse\n\t{\n\t\tvar err=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\terr= err.replace(\'$\',getLabel(\'Common.nursingUnit.label\',\'Common\'));\n\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+err\n\t\t\n\t}\n}\n\n// Added by Sridhar on 6 APR 2004\n// This is fired on onClick of the button.... \n// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..\nfunction checkTxtVal(target_id,target)\n{\n\tif(document.forms[0].nursing_unit_desc.value == \"\")\n\t\tLookup(target_id,target);\n}\n\n\n// Added by Sridhar on 5 APR 2004\n// Function will check for empty values before calling up the common lookup func..\nfunction beforeGetNursingUnit(target_id,target)\n{\n\tvar called_from=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\n\tif(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)\n\t{\n\t\tif(document.forms[0].nursing_unit_desc.value != \"\")\n\t\t\t Lookup(target_id,target);\n\t\telse\n\t\tif(document.forms[0].nursing_unit_desc.value == \"\")\n\t\t\t {\n\t\t\t    document.forms[0].nurs_desc_hid.value = \"\";\n\t\t\t\tdocument.forms[0].nursing_unit.value = \"\";\n\t\t\t\tparent.frames[0].location.href=\"../../eIP/jsp/NursingUnitSearch.jsp?called_from=\"+called_from;\n\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\"\n\t\t\t }\n\t}\n}\n\n/* Modified to CommonLookup on 06/02/04 by Sridhar */\nasync function Lookup(target_id,target)\n{\n\t\n\tvar facility_id = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\tvar title=\"\";\n\tvar called_from=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';//if called_from ==6 its from DayCare Unit for Nursing Unit\n\n\tvar argumentArray=new Array(8);\n\t\n\tif(target_id.name == \"nursing_unit\")\n\t{\n\t\t\n\t\ttitle=getLabel(\'Common.nursingUnit.label\',\'common\');\n\t\t\n\t\targumentArray[0]=\"select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT where EFF_STATUS =\'E\' and locn_type = \'N\' and facility_id =\'\"+facility_id+\"\' and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) \";\n\t\tif(called_from==6)//if called from Day Care unit for Nursing Unit\n\t\t{\n\t\t\targumentArray[0]=argumentArray[0]+\"AND APPL_PATIENT_CLASS LIKE \'DC\' \";\t\t\t\n\t\t}\n\t\tif(called_from==4)//if called from Day Care unit for Nursing Unit\n\t\t{\n\t\t\targumentArray[0]=argumentArray[0]+\"AND APPL_PATIENT_CLASS LIKE \'IP\' \";\t\t\t\n\t\t}\n\n\t\targumentArray[1]=new Array();\n\t\targumentArray[2]=new Array();\n\t\targumentArray[3]=new Array();\n\t\targumentArray[4]=\"1,2\";\n\t\targumentArray[5]=target.value;\n\t\targumentArray[6]=CODE_DESC_LINK;\n\t\targumentArray[7]=CODE_DESC;\n}\n\t\t\t\n\tvar retVal=await CommonLookup(title,argumentArray);\n\t\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].nursing_unit.value\t=\tarr[0];\t\t\n\t\tdocument.forms[0].nursing_unit_desc.value\t=\tarr[1];\n\t\tdocument.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value\n\t\tPopulateValues(target_id);\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].nursing_unit.value\t=\t\"\";\t\t\n\t\tdocument.forms[0].nursing_unit_desc.value\t=\t\"\";\n\t}\n\n\n}\n\nfunction PopulateValues(obj)\n{\n\tvar called_from=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\tif(obj.value!=\"\")\n\t{\n\t\tvar nursing_unit=obj.value;\n\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'nursingunit\' id=\'nursingunit\' method=\'post\' action=\'../../eIP/jsp/PopulateNursingUnitValues.jsp\'><input type=\'hidden\' name=\'nursing_unit\' id=\'nursing_unit\' value=\'\"+nursing_unit+\"\'><input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'\"+called_from+\"\'></form></body></html>\";\t\n\t\n\t\tparent.parent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.parent.frames[2].document.forms[0].submit();\n\t\t\n\t\tif(document.forms[0].search_txt!=null)\n\t\t{\n\t\t\tdocument.forms[0].search_txt.value = \"\";\n\t\t\tdocument.forms[0].search_by.value  = \"\";\n\t\t\tdocument.forms[0].search_txt.disabled = true;\n\t\t}\n\t}\n}\n\n</script>\n\n</head>\n\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<form name=\'Search_form\' id=\'Search_form\'>\n  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\'label\' width=\"20%\" >&nbsp;</td>\n\t\t<td class=\'label\' width=\"70%\" >&nbsp;</td>\n\t\t<td class=\'label\' width=\"2%\" >&nbsp;</td>\n\t\t<td class=\'label\' width=\"10%\" >&nbsp;</td>\n\t</tr>\n\t <tr>\n\t  \t<td  class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t <td align=\'left\' class=\'querydata\' id=td5>\n\t\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<!-- Modified to Common Lookup code on 06/02/04 by Sridhar -->\n\t\t\t\t<input type=text name=\'nursing_unit_desc\' id=\'nursing_unit_desc\' size=15 maxlength=15 onblur=\"beforeGetNursingUnit(document.forms[0].nursing_unit,this);\"><input type=button class=button name=\'search_nur_unit\' id=\'search_nur_unit\' value=\'?\' onclick=\"checkTxtVal(document.forms[0].nursing_unit,document.forms[0].nursing_unit_desc)\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\n\t\t\t\t<input type=hidden name = \"nurs_desc_hid\" id=\"nurs_desc_hid\" value=\"\">\n\t\t\t\t<input type=hidden name = \"nursing_unit\" id=\"nursing_unit\" value=\"\">\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t <select name=nursing_unit>\n\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" ---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t </select></td>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n<!-- <td align=center><input type=button class=button value=\'Search\' name=\'Search\' id=\'Search\' onclick=\'PopulateResult()\' ></td> -->\n\n   \t</tr>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\' id=tab style=\'visibility:hidden\'>\n\t\n\t<tr><td colspan=\'6\' class=\'DEFAULTBLANKROW2PT\'style=\'padding: 0; line-height: 0.5;\'>&nbsp;</td></tr>\n\t<tr>\n\t\t<td class=label width=\'25%\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td align=left class=\'querydata\' id=td1 width=\'30%\'></td>\n\t\t<td class=label  width=\'15%\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t<td align=left class=\'querydata\' id=td2 width=\'30%\'></td><td>&nbsp;</td><td>&nbsp;</td>\n\t</tr>\n\t<tr><td colspan=\'6\'  class=\'DEFAULTBLANKROW2PT\' style=\'padding: 0; line-height: 0.5;\'>&nbsp;</td></tr>\n\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<td align=left class=\'querydata\' id=td3>\n\t\t\t<select name=\"dept_code\" id=\"dept_code\" onchange=\"clearResultPage()\"><option value=\'\'>--- ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ---</option>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</select>\n\t\t</td>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td align=left class=\'querydata\' id=td3>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td class=label >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t<td align=left class=\'querydata\' id=td4></td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t</tr>\n\t<tr>\n \t\t<td class=\'label\' colspan=6>&nbsp;</td>\n\t</tr>\n\n<tr>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t<td align=left colspan=3 class=\'fields\' >\n\t\t<SELECT name=\"search_by\" id=\"search_by\" onchange=\"enable_txt(this)\">\n\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ---</option>\n\t\t<option value=\"ID\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t<option value=\"DESC\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t</SELECT>&nbsp;&nbsp;<INPUT TYPE=\"text\" name=\"search_txt\" id=\"search_txt\" disabled onKeyPress=\'return CheckForSpecChars_local(event)\' size=15 maxlength=15></td>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<td align=left colspan=4 class=\'fields\' >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n    \t<td class=\'fields\' ><input type=button class=button value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' name=\'Search\' onclick=\'PopulateResult()\' ></td><td align=left><input type=button class=button value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' name=\'Clear\' onclick=\"parent.frames[1].location.href=\'../../eCommon/html/blank.html\'\" ></td>\n\t\t</tr> \n\n\t\t<input type=hidden name=called_from value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=hidden name=facility_id value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=hidden name=strCheck value=\"\">\n\t\t<!--3-06-08-->\n\t\t<input type=hidden name=nursing_unit_type value=\'\'>\n\t\t<input type=hidden name=age_group value=\'\'>\n\t\t<input type=hidden name=department value=\'\'>\n\t\t<input type=hidden name=service value=\'\'>\n\t\t<!-- The New Hidden Vairables added on 5/6/2008  For passing Result Page-->\n\t\t<input type=hidden name=Criteria_nursing_unit value=\'\'>\n\t\t<input type=hidden name=Criteria_nursing_unit_type value=\'\'>\n\t\t<input type=hidden name=Criteria_age_group value=\'\'>\n\t\t<input type=hidden name=Criteria_department value=\'\'>\n\t\t<input type=hidden name=Criteria_service value=\'\'>\n\t\t<input type=\'hidden\' name=\'Criteria_from\' id=\'Criteria_from\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'Criteria_to\' id=\'Criteria_to\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'Criteria_start\' id=\'Criteria_start\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'Criteria_end\' id=\'Criteria_end\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'Criteria_searchby\' id=\'Criteria_searchby\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'Criteria_searchcrt\' id=\'Criteria_searchcrt\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'statusval\' id=\'statusval\' value=\'\'>\n\t\t<!--3-06-08-->\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<input type=hidden name=dept_code value=\'\'>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\n\t\t\n\t\t</form>\n  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	String ID = "";
	String Desc = "";
	String called_from	= request.getParameter("called_from");	
	String function_id	= request.getParameter("function_id");	
	if(called_from.equals("1"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	}
	else if(called_from.equals("3"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	}
	else if(called_from.equals("5"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");
	}
	else if(called_from.equals("6"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	}
	
	String facility_id	= (String)session.getValue("facility_id");
	try
	{
		con=ConnectionManager.getConnection(request);
		String operating_facility_id="";
		operating_facility_id=(String) session.getValue("facility_id");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(operating_facility_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			//if(count>15) commented this condition and made true always to get through search and left the else part as it is for future modification.
			if(true)
			{	 
		 
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
			else
			{
		 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

					try{
							String sqln="select NURSING_UNIT_CODE,SHORT_DESC from IP_NURSING_UNIT where  facility_id='"+facility_id+"' ";
							String id="";
							String dat="";
							stmt=con.createStatement();
							rs=stmt.executeQuery(sqln);
							if(rs!=null)
							{
								while(rs.next())
								{
									id=rs.getString(1);
									dat=rs.getString(2);
									out.println("<option value='"+id+"'>"+dat+"</option>");
								}
							}
							if(rs!=null)rs.close();
							if(stmt!=null)stmt.close();



						}
						catch(Exception e) {out.println(e);}
				
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
		 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
	if(called_from.equals("5")) //Department is open for [Services for Nursing Unit]...
	{	
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
	try
				{
					String deptSql = " SELECT DEPT_CODE, SHORT_DESC FROM AM_DEPT WHERE EFF_STATUS = 'E' ORDER BY 2 ";
					String id="";
					String dat="";
					stmt=con.createStatement();
					rs=stmt.executeQuery(deptSql);
					if(rs!=null)
					{
						while(rs.next())
						{
							id=rs.getString(1);
							dat=rs.getString(2);
							out.println("<option value='"+id+"'>"+dat+"</option>");
						}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();

				}catch(Exception e) 
				{
					out.println(e);
				}
			
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
	else
	{	
            _bw.write(_wl_block28Bytes, _wl_block28);
	}	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

	if(called_from.equals("1")||called_from.equals("3")||called_from.equals("5")||called_from.equals("6"))
	{
	
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else{
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
	if(!called_from.equals("5"))
	{	
            _bw.write(_wl_block42Bytes, _wl_block42);
	}	
            _bw.write(_wl_block43Bytes, _wl_block43);

  }
   catch ( Exception e ){out.println(e.toString());}
   finally{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
		ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NursingUnitType.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.agegroup.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.acctdept.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchby.label", java.lang.String .class,"key"));
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
}
