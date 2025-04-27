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
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __addoperatorstationrstrn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addOperatorStationRstrn.jsp", 1710932648195L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n  <head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAM/js/OperatorStationRstrn.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\t<script>\n\nfunction fetchVals(Obj)\n{\n\tvar sStyle=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\';\n\tif(Obj.value != \"\")\t\n\t{\n\t\tdocument.forms[0].location_button.disabled=true;\n\t\tdocument.forms[0].location_desc.disabled=true;\n\t\tdocument.forms[0].user_desc.disabled=false;\n\t\tdocument.forms[0].user_button.disabled=false;\n\t\tdocument.forms[0].user_desc.value = \"\";\n\t\tdocument.forms[0].location_desc.value = \"\";\n\t\tdocument.forms[0].user.value = \"\";\n\n\t\tvar name=Obj.name;\n\t\tvar value=Obj.value;\n\t\tval = value.split(\"::\")\n\t\tvalue = val[0];\n\t\tval0 = val[1];\n\t\tval1 = val[2];\n\t\tvar oid=Obj.value;\n\t\tvar lt=document.forms[0].locationtype.value\n\t\tvar fid=document.forms[0].facility.value;\n\n\t\tif(name == \'oprstnid\')\n\t\t{\n\t\t\tvar userlen = document.getElementById(\'user\').length;\n\t\t\tfor(var k=0;k<userlen;k++)\n\t\t\t\tdocument.getElementById(\'user\').remove(1);\n\n\t\t\tvar loctypelen = document.forms[0].locationtype.length;\n\t\t\tfor(var h=0;h<loctypelen;h++)\n\t\t\t\tdocument.forms[0].locationtype.remove(1);\n\n\t\t\tvar locidlen = document.getElementById(\"locationid\").length;\n\t\t\tfor(var h=0;h<locidlen;h++)\n\t\t\t\tdocument.getElementById(\"locationid\").remove(1);\n\n\t\t\tparent.frames[1].location.href = \'../../eCommon/html/blank.html\'\n\t\t\tparent.frames[2].location.href = \'../../eCommon/html/blank.html\'\n\t\t}\n\t\telse if(name == \'locationtype\')\n\t\t{\n\t\t\tvar locidlen = document.getElementById(\"locationid\").length;\n\t\t\tfor(var h=0;h<locidlen;h++)\n\t\t\t\tdocument.getElementById(\"locationid\").remove(1);\n\t\t}\n   \n\t\tif(Obj.value !=\'\' )\n\t\t{\n\t\t\t\n\t\t\tvar HTMLVal = \"<HTML><HEAD>\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'>\";\n\t\t\tHTMLVal = HTMLVal +\"<form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eAM/jsp/FetchValForOperatorStnRstrn.jsp\'>\";\n\t\t\tHTMLVal = HTMLVal +\"<input name=\'name\' id=\'name\' type=\'hidden\' value= \'\"+name + \"\'><input name=\'value\' id=\'value\' type=\'hidden\' value=\'\"+value +\"\'>\";\n\t\t\tHTMLVal = HTMLVal +\"<input name=\'fid\' id=\'fid\' type=\'hidden\' value=\'\"+fid+\"\'>\";\n\t\t\tHTMLVal = HTMLVal +\"<input name=\'oprstn\' id=\'oprstn\'  type=\'hidden\' value=\'\"+oid+\"\'>\";\n\t\t\tHTMLVal = HTMLVal +\"<input name=\'oper_stn_type\' id=\'oper_stn_type\'  type=\'hidden\' value=\'\"+val0+\"\'>\";\n\t\t\tHTMLVal = HTMLVal +\"<input name=\'locationtype\' id=\'locationtype\'  type=\'hidden\' value=\'\"+lt+\"\'>\";\n\t\t\tHTMLVal = HTMLVal +\"</form></BODY></HTML>\";\n\t\t\tparent.parent.frames[1].frames[3].document.write(HTMLVal);\n\t\t\tparent.parent.frames[1].frames[3].document.form1.submit();\n\t\t}\n\t}\t\t\n\telse\n\t{\n\t\tvar obj1=document.forms[0].locationtype;\n\t\tvar length1=obj1.length;\n\n\t\tvar i;\n\t\tfor(i=0;i<length1;i++) \n\t\t\tobj1.remove(1);\n\n\t\tdocument.forms[0].user_desc.value = \"\";\n\t\tdocument.forms[0].user.value = \"\";\n\t\tdocument.forms[0].location_desc.value = \"\";\n\t\tdocument.forms[0].user_desc.disabled=true;\t\t\n\t\tdocument.forms[0].user_button.disabled=true;\n\t\tdocument.forms[0].location_desc.disabled=true;\n\t\tdocument.forms[0].location_button.disabled=true;\n        parent.frames[1].location.href = \'../../eCommon/html/blank.html\';\n\t\tparent.frames[2].location.href = \'../../eCommon/html/blank.html\';\n\t}\n}\n\n\tfunction removeitems(obj)\n\t{\n\t\tvar len=obj.length;\n\t\tvar i=1;\n\t\twhile(i<len)\n\t\t{\n\t\t\tlen=obj.length\n\t\t\tobj.remove(i)\n\t\t}\n\t}\n\t\n\t async function searchCode(obj,target,target_id)\n\t\t{\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\tvar retVal =    new String();\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar tit=getLabel(\'Common.Location.label\',\'Common\');\n\t\t\t\tvar facilityid =document.forms[0].facility.value;\n\n\t\t\t\tvar temp=new Array();\n\t\t\t\ttemp=document.forms[0].locationtype.value.split(\'#\');\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tsql = \"Select locn_code code,locn_short_desc description from AM_LOCN_FOR_OPER_STN_VW where facility_id = \'\"+facilityid+\"\' and CARE_LOCN_TYPE=\'\"+temp+\"\' and OPER_STN_ID = \'\"+document.forms[0].oprstnid.value+\"\'  and upper(locn_code) like upper(?) and upper(locn_short_desc) like upper(?) order by 2 \";\n\n\n\t\t\t\t\t\t\t\t\n\t\t\t\targumentArray[0] = sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\tif (retVal !=null && retVal !=\"\")\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\ttarget_id.value=arr[0];\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\ttarget_id.value=\"\";\n\t\t\t\t}\n\t\t\t\n\t\t\n\t\t\t\n\t\t} \n\t\t\n\t\tasync function searchCode1(obj,target,target_id)\n\t\t{\n\t\t\t\t\t\n\t\t\t\tvar retVal =    new String();\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar tit=getLabel(\'Common.Location.label\',\'Common\');\n\t\t\t\tvar facilityid =document.forms[0].facility.value;\n\n\t\t\t\tvar temp=new Array();\n\t\t\t\ttemp=document.forms[0].locationtype.value.split(\'#\');\n\t\t\t\t\n\t\t\t\tif(obj.value !=\"\")\n\t\t\t\t{\n\t\t\t\t\n\t\t\t\tsql = \"Select locn_code code,locn_short_desc description from AM_LOCN_FOR_OPER_STN_VW where facility_id = \'\"+facilityid+\"\' and CARE_LOCN_TYPE=\'\"+temp+\"\' and OPER_STN_ID = \'\"+document.forms[0].oprstnid.value+\"\'  and upper(locn_code) like upper(?) and upper(locn_short_desc) like upper(?) order by 2 \";\n\n\n\t\t\t\t\t\t\t\t\n\t\t\t\targumentArray[0] = sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\tif (retVal !=null && retVal !=\"\")\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\ttarget_id.value=arr[0];\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\ttarget_id.value=\"\";\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t{\n\t\t\t\t\tparent.frames[1].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tdocument.forms[0].location_desc.value=\'\';\n\t\t\t\t\tdocument.forms[0].locationid.value=\'\';\n\t\t\t}\n\t\t}\n\n\t\tasync function displayUser1(obj,target,target_id)\n\t\t\t\t{\n\n\n\t\t\t\tvar retVal =    new String();\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar tit=getLabel(\'Common.user.label\',\'Common\');\n\n\t\t\t\tif(obj.value !=\"\")\n\t\t\t\t\t{\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t//sql = \"select appl_user_id  code,appl_user_name description  from sm_facility_for_user_vw where facility_id = \'\"+document.forms[0].facility.value+\"\' and appl_user_id like upper(?) and upper(appl_user_name) like upper(?) order by 2\";\n\t\t\t\tsql = \"select a.appl_user_id  code,a.appl_user_name description  from sm_facility_for_user_vw a, AM_USER_FOR_OPER_STN b where a.facility_id = \'\"+document.forms[0].facility.value+\"\' and a.appl_user_id like upper(?) and upper(a.appl_user_name) like upper(?) and a.facility_id=b.facility_id and a.appl_user_id=b.appl_user_id and b.oper_stn_id=\'\"+document.forms[0].oprstnid.value+\"\' order by 2\";\n\n\n\t\t\t\t\t\t\t\t\n\t\t\t\targumentArray[0] = sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\tif (retVal !=null && retVal !=\"\")\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\ttarget_id.value=arr[0];\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\ttarget_id.value=\"\";\n\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tdocument.forms[0].user_desc.value=\'\';\n\t\t\t\t\tdocument.forms[0].user.value=\'\';\n\t\t\t\t\t}\n\t\t\t\t}\n\n\n\t\tasync function displayUser(obj,target,target_id)\n\t\t\t\t{\n\n\n\t\t\t\tvar retVal =    new String();\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar tit=getLabel(\'Common.user.label\',\'Common\');\n\n\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t//sql = \"select appl_user_id  code,appl_user_name description  from sm_facility_for_user_vw where facility_id = \'\"+document.forms[0].facility.value+\"\' and appl_user_id like upper(?) and upper(appl_user_name) like upper(?) order by 2\";\n\t\t\t\tsql = \"select a.appl_user_id  code,a.appl_user_name description  from sm_facility_for_user_vw a, AM_USER_FOR_OPER_STN b where a.facility_id = \'\"+document.forms[0].facility.value+\"\' and a.appl_user_id like upper(?) and upper(a.appl_user_name) like upper(?) and a.facility_id=b.facility_id and a.appl_user_id=b.appl_user_id and b.oper_stn_id=\'\"+document.forms[0].oprstnid.value+\"\' order by 2\";\n\t\t\t\t\n\n\n\t\t\t\t\t\t\t\t\n\t\t\t\targumentArray[0] = sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\tif (retVal !=null && retVal !=\"\")\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\ttarget_id.value=arr[0];\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\ttarget_id.value=\"\";\n\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\t\n\n\t\tfunction callResultFrame(Obj)\n\t\t{\n\t\t\tif(chkMandatory())\n\t\t\t{\n\t\t\t\tvar locationtype=new Array();\n\t\t\t\tlocationtype=document.forms[0].locationtype.value.split(\'#\');\n\t\t\t\tvar url=\'../../eAM/jsp/OperatorStationRstrntabs.jsp?mode=insert&locationtype=\'+document.forms[0].locationtype.value+\'&oper_stn_type=\'+Obj.value+\'&oper_stn_id=\'+document.forms[0].oprstnid.value+\'&user=\'+document.forms[0].user.value+\'&locationid=\'+document.forms[0].locationid.value+\'&locncode1=\'+document.forms[0].locationid.value+\'&facility_id=\'+document.forms[0].facility.value;\n\n\t\t\t\tparent.frames[1].location.href = \'../../eAM/jsp/OperatorStationRstrntabs.jsp?mode=insert&locationtype=\'+document.forms[0].locationtype.value+\'&oper_stn_type=\'+Obj.value+\'&oper_stn_id=\'+document.forms[0].oprstnid.value+\'&user=\'+document.forms[0].user.value+\'&locationid=\'+document.forms[0].locationid.value+\'&locncode1=\'+document.forms[0].locationid.value+\'&facility_id=\'+document.forms[0].facility.value;\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val=\'\n\t\t\t}\n\t\t\telse{\n                parent.frames[1].location.href =\'../../eCommon/html/blank.html\';\n                parent.frames[2].location.href =\'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t}\n\t\t\nfunction cle";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="arValues(Obj)\n{\n\n\tdocument.forms[0].location_desc.value=\'\';\n\tdocument.forms[0].locationid.value=\'\';\n\tif(Obj.value !=\'\'){\n\t\tdocument.forms[0].location_button.disabled=false;\n\t\tdocument.forms[0].location_desc.disabled=false;\n\t}\n\telse{\n\t\tdocument.forms[0].location_desc.disabled=true;\n\t\tdocument.forms[0].location_button.disabled=true;\n\t\t}\n\n\tparent.frames[1].document.location.href=\'../../eCommon/html/blank.html\';\n\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\n}\n\nfunction second1(Obj)\n{\n\tparent.frames[1].document.location.href=\'../../eCommon/html/blank.html\';\n\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\tvar str1=Obj.value;\n\tdocument.forms[0].str1.value=str1;\n\tvar obj1=document.forms[0].oprstnid;\n\tvar obj2=document.forms[0].locationtype;\n\tvar length1=obj1.length;\n\tvar length2=obj2.length;\n\tvar i;var j;\n\tfor(i=0;i<length1;i++) \n\t\tobj1.remove(1);\n\tfor(j=0;j<length2;j++) \n\t\tobj2.remove(1);\t\n\t\n\tdocument.forms[0].user_desc.disabled=true;\n\tdocument.forms[0].user_button.disabled=true;\n    document.forms[0].location_desc.disabled=true;\n\tdocument.forms[0].location_button.disabled=true;\n\tdocument.forms[0].user_desc.value=\'\';\n\tdocument.forms[0].location_desc.value=\'\';\n\t\t\n\t\n\tif(Obj.value !=\'\'){\t\n\t\tvar HTMLVal = \"<html><body onKeyDown = \'lockKey()\'><form name=\'practform12\' id=\'practform12\' method=\'post\' action=\'../../eAM/jsp/FetchValForOperatorStnRstrn.jsp\'> <input type=\'hidden\' name=\'facid\' id=\'facid\' value=\'\"+str1+\"\'>\t</form></body></html>\";\t\n\t\tparent.parent.frames[1].frames[2].document.write(HTMLVal);\n\t\tparent.parent.frames[1].frames[2].document.practform12.submit();  \n\t}\n\t\n\t\n}\n   </script>\n   </head>\n\n \t<body OnMouseDown=\"CodeArrest()\" onLoad=\"FocusFirstElement(); \"  onKeyDown = \'lockKey()\'>\n\n      ";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'opstnrstrn_form\' id=\'opstnrstrn_form\'  action=\'../../servlet/eAM.OperatorStationRstrnServlet\'  method=\'post\' target=\'messageFrame\'>\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' height=\'auto\' align=\'center\'>\n\t\t<tr>\n\t\t<td  nowrap class=\'label\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td colspan=3 class=\'fields\'>&nbsp;\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<input type=\'text\' name=\'facility_desc\' id=\'facility_desc\' size=\'70\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" maxlength=\'35\' readOnly><input type=\'hidden\' name=\'facility\' id=\'facility\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\t\t\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n\t\t&nbsp;<select name=\'facility\' id=\'facility\' nowrap onChange=\"second1(this)\" ><option >--------------";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="-------------</option>\n\t       ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n\t\t</select>&nbsp;<img align=center src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t<td  nowrap class=\'label\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n      \t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<td class=\'fields\' nowrap>&nbsp;\n\t\t\t<input type =\'textbox\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" readonly maxsize=\'30\' size =\'30\'>\n\t\t\t<input name=\'oprstnid\' id=\'oprstnid\' type =\'hidden\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" readonly maxsize=\'30\' size =\'30\'>\n\t\t</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="      <td nowrap class=\'fields\'>&nbsp;&nbsp;\n\t\t\t\t<select name=\"oprstnid\" id=\"oprstnid\" onChange=\"fetchVals(this)\">\n\t\t\t\t<option value=\"\">---------- ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="---------- </option>\n ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t</select>&nbsp<img align=center src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img> \n      \t\t</td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t\t<td nowrap  class=\'label\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td nowrap class=\'fields\'>&nbsp;<input type =\'textbox\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" readonly maxsize=\'30\' size =\'30\'><input name=\"user\" id=\"user\" type =\'hidden\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" readonly maxsize=\'30\' size =\'30\'></td>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n      \t\t<td nowrap  class=\'label\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n      \t\t<td nowrap class=\'fields\'>&nbsp;<input type=text  name=\'user_desc\' id=\'user_desc\' onblur=\'displayUser1(this, user_desc,user)\' size=\"30\" maxlength=\"30\" disabled><input type=\'button\' name=\'user_button\' id=\'user_button\' value=\'?\'  disabled class=\'button\' onclick=\'displayUser(this, user_desc,user)\'>\n\t\t   <input type=\'hidden\' name=\'user\' id=\'user\' value=\'\'><img align=center src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img> </td>\n      \t</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<tr>\n\t\t<td  nowrap  class=\'label\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t<td class=\'fields\'>&nbsp;\n\t\t<input type =\'textbox\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" readonly maxsize=\'30\' size =\'30\'>\n\t\t<input name=\'locationtype\' id=\'locationtype\' type =\'hidden\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' readonly maxsize=\'30\' size =\'30\'>\n\t\t</td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t<tr>\n\t\t<td nowrap  class=\'label\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</td>\n\t\t<td class=\'fields\' >&nbsp;&nbsp;\n\t\t\t<select name=\'locationtype\' id=\'locationtype\' onChange=\'clearValues(this)\'>\n\t\t\t<OPTION  value=\'\'>---------- ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="---------- </OPTION>\t\n\t\t</SELECT>&nbsp;<img align=center src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t</td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<td nowrap  class=\'label\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t<td nowrap class=\'fields\'>&nbsp;<input type =\'textbox\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" readonly maxsize=\'15\' size =\'15\'><input name=\'locationid\' id=\'locationid\' type =\'hidden\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="      \t\n\t\t<td nowrap  class=\'label\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td><td nowrap class=\'fields\'>&nbsp;<input type=text  name=\'location_desc\' id=\'location_desc\' onblur=\'searchCode1(this, location_desc,locationid)\' size=\"15\" maxlength=\"15\" disabled><input type=\'button\' disabled name=\'location_button\' id=\'location_button\' value=\'?\' class=\'button\' onclick=\'searchCode(this, location_desc,locationid)\'><input type=\'hidden\' name=\'locationid\' id=\'locationid\' value=\'\'>&nbsp;<img align=center src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n  \t</tr>\n ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<tr>\n\t<td colspan=\'4\' align=\'right\'><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onClick=\'callResultFrame(operation_stn_type)\' ></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<tr>\n      \t    <td nowrap>&nbsp;</td>\n      \t\t<td nowrap  class=\'label\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t</td>\n      \t\t<td nowrap class=\'fields\'>&nbsp;&nbsp;&nbsp;<input type=\"text\" name=\"ws_no\" id=\"ws_no\" size=10 maxlength=10>&nbsp;<img align=center src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n      \t\t<td>&nbsp;</td>\n      \t</tr>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name=\"operation_type\" id=\"operation_type\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\n\t\t<input type=\'hidden\' name=\'oprstn\' id=\'oprstn\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'oper_stn_desc\' id=\'oper_stn_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'oper_stn_type\' id=\'oper_stn_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'rule\' id=\'rule\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\'hidden\' name=\'operation_stn_type\' id=\'operation_stn_type\' value=\'\'>\n\t\t<input type=\"hidden\" name=\"str1\" id=\"str1\" value=\'\'>\n\t\t<input type=\'hidden\' name=\'operstntype\' id=\'operstntype\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	 String oper_stn_id=request.getParameter("oper_stn_id");
	 Connection conn = null;
	 String fid=(String)session.getValue("facility_id");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

		 String facName = request.getParameter("facName");
		 if(facName == null) facName="";

		 String facilityid=(String)session.getValue("facility_id");
		 String facility_id2 = request.getParameter("facility_id");

		String operstntype = request.getParameter("oper_stn_type")==null?"B":request.getParameter("oper_stn_type");

   	 	 String rule="";
		 String operationtype = "insert";
   	 	 
		 String operstnshortdesc ="";
		 String appluserid = "";
		 String applusername ="";
		 String locncode ="";
		 String locnshortdesc ="";
		 String locntype = "";
		 String locntypedesc = "";
		 
		 ResultSet rs= null;
		 ResultSet prs = null;

		 ResultSet rset=null;
		 Statement stmt = null;
		 PreparedStatement pstmt = null;

try{
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();
	Properties p=(Properties)session.getValue("jdbc");
	String userId=p.getProperty( "login_user" ) ;
	
	operationtype = request.getParameter("operationtype");
	String facid="";
			 
	if(operationtype == null ) operationtype ="insert";
	if(oper_stn_id == null){
		oper_stn_id="";
		

		rs=stmt.executeQuery(" Select  OPER_STN_ACCESS_RULE from op_param where operating_facility_id = '"+fid+"'");
		if(rs.next())
			rule=rs.getString(1)==null?"":rs.getString(1);
		}else{
		operationtype = "modify";
		operstnshortdesc = request.getParameter("oper_stn_desc")==null?"":request.getParameter("oper_stn_desc");
		appluserid  = request.getParameter("user")==null?"":request.getParameter("user");
		applusername  = request.getParameter("applusername1")==null?"":request.getParameter("applusername1");
		locncode = request.getParameter("locncode1")==null?"":request.getParameter("locncode1");
		locnshortdesc = request.getParameter("locnshortdesc1")==null?"":request.getParameter("locnshortdesc1");
		locntype = request.getParameter("location_type")==null?"":request.getParameter("location_type");
		locntypedesc = request.getParameter("location_type_desc")==null?"":request.getParameter("location_type_desc");

		

		String facility_id1 = request.getParameter("facilityid");
			 if(facility_id1 == null )facility_id1 ="";	
			 
		
		
	}
	 

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(operationtype.equals("modify")) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id2));
            _bw.write(_wl_block12Bytes, _wl_block12);
 } else { 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			String ID1="",dat1="",en1="";
		    if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			stmt=conn.createStatement();
			rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+userId+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
			if(rset!=null)
			{
			   while(rset.next())
			   {
				dat1=rset.getString("Operating_facility_id");
				ID1=rset.getString("facility_id");
				if(ID1.equals(facilityid))
				   {
					
				   }
					else
					   en1="";
				out.println("<option value=\""+ID1+ "\" "+en1+">"+dat1+"</option>");
			   }
			   } 
			   
            _bw.write(_wl_block15Bytes, _wl_block15);
 } 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	if(operationtype.equals("modify"))
	{	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(operstnshortdesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
	}
	else
	{	
		facid= request.getParameter("str1");
		if(facid == null) facid="";

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

                if(rset!=null)rset.close();
                if(stmt!=null)stmt.close(); 
			
                pstmt = conn.prepareStatement("SELECT oper_stn_id,short_desc  from  am_oper_stn where  facility_id = '' and eff_status= 'E' order by short_desc ");
				prs = pstmt.executeQuery();

				if(prs != null)
				{	
					while(prs.next())
					{
						out.println("<option value='"+prs.getString(1)+"'>"+prs.getString(2)+"</option>");

					}
				} 

            _bw.write(_wl_block23Bytes, _wl_block23);

	}
	 
	 if(operationtype.equals("modify"))
	{

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(applusername));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appluserid));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
	}
	else
	{	

            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

	}
	if(operationtype.equals("modify"))
	{

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locntype));
            _bw.write(_wl_block33Bytes, _wl_block33);
	}
	else
	{	
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
	}
	
	if(operationtype.equals("modify"))
	{	
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locnshortdesc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
	else
	{	
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
	}	
            _bw.write(_wl_block1Bytes, _wl_block1);
  if(!operationtype.equals("modify")) { 
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
 } 
            _bw.write(_wl_block44Bytes, _wl_block44);
	if(rule.equals("W")) {

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

		 }			
		

            _bw.write(_wl_block47Bytes, _wl_block47);
		out.println("</table>	");

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(operationtype));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(operationtype));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rule));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(operstntype));
            _bw.write(_wl_block52Bytes, _wl_block52);


		
	}//E.O.try
       catch(Exception e){
//		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		try
		{
		if (rs != null)   rs.close();
		if (rset!= null)  rset.close();
		if (prs!= null)   prs.close();
		if (stmt != null) stmt.close();
		if (pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{}
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operatorstation.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.user.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.user.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WorkStation.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
