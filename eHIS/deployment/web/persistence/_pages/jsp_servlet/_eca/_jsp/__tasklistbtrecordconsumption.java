package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __tasklistbtrecordconsumption extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TaskListBTRecordConsumption.jsp", 1709116382792L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nSame as previous version(Formatted)\n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n?             100         ?           created\n14/12/2011    IN29519     Dinesh T    SKR-SCF-0298, Validation done for the practitioner ids\n30/11/2012    IN035422    Chowminya G Ca user cant complete the Blood Unit Consumption details. Error ? Error in practitioner selection?.  \n11/02/2013    IN036376    Chowminya G To default the logged in practitioner ?s name in the ?Practitioner Name?\n28/02/2013    IN036376.1    Chowminya G To default the logged in practitioner ?s name in the ?Practitioner Name?\n-----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html> \n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\"../../eCommon/js/dchk.js\" language=\"javascript\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMessage.js\"></Script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\n<script language=\'javascript\'>\n\n\tfunction funBTReactionDetailBlur(obj)\n\t{\n\t\tif((obj.value) == \"null\" || (obj.value ==\"\"))\n\t\t{\n\t\t\tdocument.getElementById(\'adverse_reaction\').style.visibility=\'hidden\';\n\t\t\treturn false;\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tfunBTReactionDetail();\n\t\t}\n\t} \n\n\n\tfunction funBTReactionDetail()\n\t{\n\t\tvar target\t\t\t\t= document.forms[0].REACTION_DESC;\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\t/*\n\t\tAdded by kishore kumar N on 29/04/2010 for ICN-20903\n\t\t*/\n\t\tvar title\t\t\t\t= encodeURIComponent(getLabel(\"Common.Reaction.label\",\'COMMON\')); \n\t\tvar search_text\t\t\t= document.forms[0].REACTION_DESC.value;\n\t\tsearch_text\t\t\t\t= encodeURIComponent(search_text);\n\n\t\t/*\n\t\tends here.\n\t\t*/\n\t\tvar retArray = window.showModalDialog(\"../../eCA/jsp/TaskListBTReactionMain.jsp?search_text=\"+search_text+\"&title=\"+title,arguments,features);\n\n\t\tvar arr=new Array();\n\n\t\tif (retArray != null && retArray != \'\' && retArray !=\'undefined\' )\n\t\t{\n\t\t\tvar retArray = unescape(retArray);\n\t\t\tarr=retArray.split(\",\");\n\t\t\tdocument.forms[0].reaction_code.value = arr[0];\n\t\t\tdocument.forms[0].REACTION_DESC.value = arr[1];\n\n\t\t\tif(arr[2] == \'Y\')\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'adverse_reaction\').style.visibility=\"visible\";\n\t\t\t\t//alert(getMessage(\"TRANS_INVESTIGATE\",\"CA\")); //Added by Archana Dhal related to IN022960\n\t\t\t\talert(getBTMessage(\'BT0218\',\'BT\'));//Added by Archana Dhal related to IN023128\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'adverse_reaction\').style.visibility=\"hidden\";\n\t\t\t}\n\t\t}\n\t\telse\t\t\n\t\t{\n\t\t\tdocument.forms[0].reaction_code.value = \'\';\n\t\t\tdocument.forms[0].REACTION_DESC.value = \'\';\n\t\t}\n\t}\n\n\tfunction funBTCheckDetail1Blur(obj,flag)\n\t{\n\t\tif((obj.value) == \"null\" || (obj.value == \"\"))\n\t\t{\n\t\t\treturn false;\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tfunBTCheckDetail1(flag);\n\t\t}\n\t}\n \n\tfunction funBTCheckDetail1(flag)\n\t{\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\";\n\t\tvar dialogWidth\t\t\t= \"40\";\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\";\n\t\tvar target\t\t\t= \'\';\n\t\tvar title;\n\n\t\tif(flag == \'1\')\n\t\t{\n\t\t\ttitle = getLabel(\"eCA.TransfusebyPractitioner.label\",\'CA\');\n\t\t}\n\t\telse if(flag == \'2\')\n\t\t{\n\t\t\ttitle = getLabel(\"Common.practitioner.label\",\'COMMON\');\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttitle = getLabel(\"eCA.CheckbyPractitioner.label\",\'CA\');\n\t\t}\n\n\t\tif(flag==\'3\')\n\t\t{\n\t\t\ttarget = document.forms[0].Checked_Practioner;\n\t\t}\n\t\telse\n\t\tif(flag==\'1\')\n\t\t{\n\t\t\ttarget = document.forms[0].Practioner_Name1;\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttarget = document.forms[0].Practioner_Name2;\t\t \n\t\t}\n\n\t\tvar sql;\n\t\tvar locale      = document.forms[0].locale.value;\n\t\tvar facilityid      = document.forms[0].facility_id.value;\n\t\tsql=escape(\"select USER_ID code,USERNAME description from SY_USER_LANG_VW where upper(USER_ID) like upper(?) and upper(USERNAME) like upper(?) and FACILITY_ID=\'\"+facilityid+\"\' and language_id=\'\"+locale+\"\'\"); //--[IN035422]\n\n\t//\tsql=escape(\"SELECT A.PRACTITIONER_ID code, A.SHORT_NAME description FROM AM_PRACTITIONER A, AM_PRACT_FOR_FACILITY B WHERE upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?) and B.FACILITY_ID = \'\"+facilityid+\"\' AND A.PRACTITIONER_ID = B.PRACTITIONER_ID\") ;\n\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\n\t\targArray[0] = sql;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = CODE_DESC;\n\n\t\tretArray = CommonLookup( title, argArray );\n\n\t\tvar arr=new Array();\n\n\t\tif(retArray == null || retArray == undefined) \n\t\t\tretArray = \'\';\n\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\n\t\t\tvar retArray=unescape(retArray);\n\n\t\t\tif(retArray != null)\n\t\t\t{\t\t\t\n\t\t\t\tarr=retArray.split(\",\");\n\n\t\t\t\tif(flag==\'3\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].Checked_Practioner.value = arr[1];\n\t\t\t\t\tdocument.forms[0].check_pract_id.value = arr[0];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\tif(flag==\'1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].Practioner_Name1.value = arr[1];\n\t\t\t\t\tdocument.forms[0].transfuse_pract_id1.value = arr[0];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].Practioner_Name2.value = arr[1];\n\t\t\t\t\tdocument.forms[0].transfuse_pract_id2.value = arr[0];\n\t\t\t\t} \n\t\t\t}\n\t\t\telse\t\t\n\t\t\t{\n\t\t\t\tif(flag==\'3\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].Checked_Practioner.value =\'\';\n\t\t\t\t\tdocument.forms[0].check_pract_id.value = \'\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\tif(flag==\'1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].Practioner_Name1.value = \'\';\n\t\t\t\t\tdocument.forms[0].transfuse_pract_id1.value = \'\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].Practioner_Name2.value = \'\';\n\t\t\t\t\tdocument.forms[0].transfuse_pract_id2.value = \'\';\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t/*\n\t\tAdded by kishore kumar N on 29/04/2010 for ICN-20903\n\t\t*/\n\t\telse\n\t\t{\n\t\t\ttarget.value = \'\';\n\t\t}\n\t\t/*\n\t\tends here.\n\t\t*/\n\t}\n\n\tfunction closeWindow()\n    {\n\t\tparent.window.close();\n\t}\n\n\tfunction checkSTDate(objSt,objIS,objRE)\n\t{\n\t\tvar locale\t\t= document.forms[0].locale.value;\n\t\t\n\t\tif(objSt==null||objSt.value==\'\') \n\t\t{\t\t\t\n\t\t\treturn;\n\t\t}\n\t\tif(objSt.value !=\'\')\n\t\t{\n\t\t\tif(!doDateTimeChk(objSt))\n\t\t\t{\n\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n\t\t\t\tobjSt.focus();\n\t\t\t\treturn false\n\t\t\t}\n\n\t\t\tif(!(isBeforeNow(objSt.value,\"DMYHM\",locale) ))\n\t\t\t{\n\t\t\t\talert(getMessage(\"DATE_ST_LT_SYS\",\"CA\")); \n\t\t\t\tobjSt.select();\n\t\t\t\tobjSt.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tvar obj1=changeDate(objSt.value);\n\t\t\tvar obj2=changeDate(objIS.value);\n\t\t\tvar obj3=changeDate(objRE.value);\n\n\n\t\t\tif(obj1 < obj2 )\n\t\t\t{ \t\n\t\t\t\t//BT0114,DATE_ST_GT_ISSUE\n\t\t\t\talert(getMessage(\"DATE_ST_GT_ISSUE\",\"CA\"));\n\t\t\t\tobjSt.value=\'\';\n\t\t\t\treturn;\n\t\t\t}\n\n\t\t\t//BT0115,DATE_ST_LT_RESER\n\t\t\tif(obj1 > obj3)       \n\t\t\t{ \n\t\t\t\talert(getMessage(\"DATE_ST_LT_RESER\",\"CA\"));\n\t\t\t\tobjSt.value=\'\';\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction checkEnDate(objEt,objTR,objRE,objSYS)\n\t{\n\t\tvar locale\t\t= document.forms[0].locale.value;\n\n\t\tif(objEt==null||objEt.value==\'\')\n\t\t{\t  \n\t\t\treturn ;\n\t\t}\n\n\t\tif(objEt.value !=\'\')\n\t\t{\n\t\t\tif(!doDateTimeChk(objEt))\n\t\t\t{\n\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n\t\t\t\tobjEt.focus();\n\t\t\t\treturn false\n\t\t\t}\n\t\t\t//Date Validation message changed by Archana Dhal related to IN18784\n\t\t\tif(!isBeforeNow(objEt.value,\"DMYHM\",locale))\n\t\t\t{\n\t\t\t\talert(getMessage(\"DATE_EN_LT_SYS\",\"CA\"));\n\t\t\t\tobjEt.select();\n\t\t\t\tobjEt.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tvar obj1=changeDate(objEt.value);\n\t\t\tvar obj2=changeDate(objTR.value);\n\t\t\tvar obj3=changeDate(objRE.value);\n\t\t\tvar obj4=changeDate(objSYS.value);\n\n\t\t\t//BT0117,DATE_EN_LT_SYS\n\t\t\t//Commented by Archana Dhal related to IN18784\n\t\t\t/*if(obj1 > obj4 ) {\t    \n\t\t\talert(getMessage(\"DATE_EN_LT_SYS\",\"CA\"));\n\t\t\tobjEt.value=\'\';\n\t\t\treturn;}*/\n\t\t\t//BT0118,DATE_EN_GT_TRANS\n\n\t\t\tif(obj1 < obj2)    \n\t\t\t{ \n\t\t\t\talert(getMessage(\"DATE_EN_GT_TRANS\",\"CA\"));\n\t\t\t\tobjEt.value=\'\';\n\t\t\t\treturn;\n\t\t\t}\n\n\t\t\t//BT0119,DATE_EN_LT_RESER\n\t\t\tif(obj1 > obj3)     \n\t\t\t{  \n\t\t\t\talert(getMessage(\"DATE_EN_LT_RESER\",\"CA\"));\n\t\t\t\tobjEt.value=\'\';\n\t\t\t\treturn;\n\t\t\t}\t\n\t\t}\n\t}\n\n\n\tfunction changeDate(objEt)\n\t{\n\t\tvar objStr=new Array();\n\t\tobjStr=objEt.split(\"/\");\n\t\tvar datVal=\'\';\n\n\t\tif(objStr != null && objStr.length>0)\n\t\t{\n\t\t\tdatVal+=objStr[1]+\"/\";\n\t\t\tdatVal+=objStr[0]+\"/\";\n\t\t\tdatVal+=objStr[2];\n\t\t}\n\t\telse\t \n\t\t\tdatVal=objEt;\n\n\t\tvar dat=new Date(datVal);\n\t\treturn dat;\n\t}  \n\n\tfunction funCheck(objChe)\n\t{\n\t\tobjFrm=document.forms[0];\n\n\t\tif(objChe.checked == true)\n\t\t{\t\n\t\t\tobjFrm.TRANS_BS.disabled=false;\n\t\t\tobjFrm.TRANS_DESC.disabled=false;\n\t\t\tobjFrm.partial_check.value=\'Y\';//Added by Archana Dhal related to IN023128 on 8/9/2010.\n\t\t}\n\t\telse\n\t\t{\n\t\t\tobjFrm.TRANS_BS.disabled=true;\n\t\t\tobjFrm.TRANS_DESC.disabled=true;\n\t\t\tobjFrm.partial_check.value=\'N\';//Added by Archana Dhal related to IN023128 on 8/9/2010.\n\t\t\tobjFrm.partial_trans_code.value=\'\';\n\t\t\tobjFrm.TRANS_DESC.value=\'\';\n\t\t} \n\t}\n\n\tfunction funBTReasonDetailBlur(obj)\n\t{\n\t\t//var target\t\t\t= document.forms[0].TRANS_DESC;\n\t\tif((obj.value) == \"null\" || (obj.value ==\"\"))\n\t\t{\n\t\t\treturn false;\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tfunBTReasonDetail();\n\t\t}\n\t}\n\n\tfunction funBTReasonDetail()\n\t{\n\t\tvar target\t\t\t= document.forms[0].TRANS_DESC;\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar title = getLabel(\"Common.reason.label\",\'COMMON\');\n\t\tvar sql ;\t\n\t\tvar obj=document.forms[0];\n\t\t//sql=escape(\"SELECT REASON_CODE REASON_CODE1,SHORT_DESC SHORT_DESC1  FROM RL_REASON_CODE_LANG_VW WHERE REASON_TYPE=\'BT\' AND NVL (STATUS,\'X\') <> \'S\' AND LANGUAGE_ID=\'\"+obj.locale.value+\"\'\");\n\t\tsql=escape(\"Select REASON_CODE code, SHORT_DESC description from RL_REASON_CODE_LANG_VW where upper(REASON_CODE) like upper(?) and SHORT_DESC like upper(?) and REASON_TYPE=\'BT\' AND NVL (STATUS,\'X\') <> \'S\' and language_id = \'\"+obj.locale.value+\"\'\") ;\n\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = CODE_DESC;\n\n\t\tretArray = CommonLookup( title, argArray );\n\t\tvar arr=new Array();\n\n\t\tif(retArray == null) \n\t\t\tretArray=\'\';\n\n\t\tif (retArray != null || retArray!=\"\")\n\t\t{\n\t\t\tvar retArray=unescape(retArray);\n\n\t\t\tif(retArray != null && retArray.length>0)\n\t\t\t{\n\t\t\t\tarr=retArray.split(\",\");\n\t\t\t\tdocument.forms[0].partial_trans_code.value = arr[0];\n\t\t\t\tdocument.forms[0].TRANS_DESC.value = arr[1];\n\t\t\t}\n\t\t\telse\t\t\n\t\t\t{\n\t\t\t\tdocument.forms[0].partial_trans_code.value = \'\';\n\t\t\t\tdocument.forms[0].TRANS_DESC.value = \'\';\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction Apply()\n\t{\n\t\tvar fields = new Array (document.forms[0].start_date_time,\n\t\tdocument.forms[0].end_date_time,\n\t\tdocument.forms[0].Checked_Practioner,\n\t\tdocument.forms[0].Practioner_Name1,\n\t\tdocument.forms[0].REACTION_DESC //Added by Archana Dhal on 4/26/2010 related to IN020903. \n\t\t);\n\t\t//IN29519,starts\n\t\tobj = document.all;\n\t\t\n\t\tif(obj.transfuse_pract_id1.value != obj.LOGIN_USER.value) \n\t\t{\n\t\t\tif (obj.transfuse_pract_id2.value != null)\n\t\t\t{\t\t\n\t\t\t\tif(obj.transfuse_pract_id2.value != obj.LOGIN_USER.value)\n\t\t\t\t{\n\t\t\t\t\talert(getBTMessage(\'BT0266\',\'BT\'));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\talert(getBTMessage(\'BT0266\',\'BT\'));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t//IN29519,ends\n\n\t\tvar names = new Array ( getLabel(\"Common.startdatetime.label\",\"COMMON\"),\n\t\tgetLabel(\"Common.EndDateTime.label\",\"COMMON\"),\n\t\tgetLabel(\"eCA.CheckbyPractitioner.label\",\"CA\"),\n\t\tgetLabel(\"eCA.TransfusebyPractitioner.label\",\"";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="CA\"),\n\t\tgetLabel(\"Common.Reaction.label\",\'COMMON\') //Added by Archana Dhal on 4/26/2010 related to IN020903. \n\t\t);\n\n\t\tif(document.forms[0] != null)\n\t\t{\n\t\t\tif(checkFieldsofMst( fields, names, parent.messageFrame)) \n\t\t\t{\n\t\t\t\tdocument.forms[0].method =\'post\'\n\t\t\t\tdocument.forms[0].action =\'../../servlet/eCA.TaskListBTTransfuseServlet\'\n\t\t\t\tdocument.forms[0].target=\'messageFrame\'\n\t\t\t\tdocument.forms[0].submit();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tmessageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0\';\n\t\t\treturn false;\n\t\t}\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t    \n</head>\n";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block11 ="\t\n<body>\n<form name=\'CA_UNIT_REQUEST_DTL\' id=\'CA_UNIT_REQUEST_DTL\' method=\'post\'   action=\'\' target=\'messageFrame\'> \n<table width=\'102%\'>\n\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t\t<td class=\'fields\' width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\'label\' width=\'25%\'><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td class=\'fields\' width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" / ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t \t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></td><td  class=\'fields\' width=\'25%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\n\t\t\t<td class=\'label\' width=\'25%\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<td class=\'fields\' width=\'25%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></td>\n\t\t<td class=\"fields\" width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'25%\'>&nbsp;</td>\n\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\n\t\t\t<script>\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));window.close();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<table width=\'102%\' height=\'86%\' class=\"grid\">\n\t<tr>\n\t\t<td class=\'label\' colspan=\'4\'> <b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b></td> \n\t</tr>\n\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td><td  class=\'fields\' width=\'25%\'><input type=\'text\' name=\'start_date_time\' id=\'start_date_time\' maxlength=\'20\' size=\'20\' value= \"\" RECORD_TYPE=\'S\' Onblur=\'checkSTDate(this,document.forms[0].ISSUED_DATE,document.forms[0].RESERVED_DATE)\'> <img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'start_date_time\',\'dd/mm/y\',\'hh:mm:ss\');\" /><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t<td  class=\'fields\' width =\'25%\'><input type=\'text\' name=\'end_date_time\' id=\'end_date_time\' maxlength=\'20\' size=\'20\' value= \"\" RECORD_TYPE=\'S\' Onblur=\'checkEnDate(this,document.forms[0].start_date_time,document.forms[0].RESERVED_DATE,document.forms[0].SYSDATE);\' >\n\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'end_date_time\',\'dd/mm/y\',\'hh:mm:ss\');\" /><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t<td  class=\'fields\' width =\'25%\'><input type=\'text\' name=\'Checked_Practioner\' id=\'Checked_Practioner\' maxlength=\'20\' size=\'20\' value= \"\" OnBlur =\"funBTCheckDetail1Blur(this,\'3\')\"><input type=\'button\' class=\'Button\' value=\'?\' onClick=\"funBTCheckDetail1(\'3\')\"  name=\'bs\' id=\'bs\'><input type=\'hidden\' name=\'check_pract_id\' id=\'check_pract_id\' value=\'\' RECORD_TYPE=\'S\'><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t<td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<td  class=\'fields\' width =\'25%\'><input type=\'text\' name=\'Practioner_Name1\' id=\'Practioner_Name1\' maxlength=\'20\' size=\'20\' value= \"\" OnBlur =\"funBTCheckDetail1Blur(this,\'1\')\"><input type=\'button\' class=\'Button\' value=\'?\' onClick=\"funBTCheckDetail1(\'1\')\"  name=\'bs\' id=\'bs\'><input type=\'hidden\' name=\'transfuse_pract_id1\' id=\'transfuse_pract_id1\' value=\'\' RECORD_TYPE=\'S\'><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t<!--<td  class=\'fields\' width =\'25%\'><input type=\'text\' name=\'Practioner_Name2\' id=\'Practioner_Name2\' maxlength=\'20\' size=\'20\' value= \"\" OnBlur =\"funBTCheckDetail1Blur(this,\'2\')\"><input type=\'button\' class=\'Button\' value=\'?\' onClick=\"funBTCheckDetail1(\'2\')\"  name=\'bs\' id=\'bs\'><input type=\'hidden\' name=\'transfuse_pract_id2\' id=\'transfuse_pract_id2\' value=\'\' RECORD_TYPE=\'S\'></td>--> \n\t\t<td  class=\'fields\' width =\'25%\'><input type=\'text\' name=\'Practioner_Name2\' id=\'Practioner_Name2\' maxlength=\'20\' size=\'20\' value= \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" OnBlur =\"funBTCheckDetail1Blur(this,\'2\')\"><input type=\'button\' class=\'Button\' value=\'?\' onClick=\"funBTCheckDetail1(\'2\')\"  name=\'bs\' id=\'bs\'><input type=\'hidden\' name=\'transfuse_pract_id2\' id=\'transfuse_pract_id2\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' RECORD_TYPE=\'S\'></td> <!-- Modified IN036376 -->\n\t\t<td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t<td  class=\'fields\' width =\'10%\'><input type=\'text\' name=\'REACTION_DESC\' id=\'REACTION_DESC\' maxlength=\'40\' size=\'30\' value= \"\" OnBlur =\"funBTReactionDetailBlur(this)\"><input type=\'button\' class=\'button\' value=\'?\'   name=\'bs\' id=\'bs\' onClick=\"funBTReactionDetail()\"><img src=\'../../eCommon/images/mandatory.gif\'></img><input type=\'hidden\' name=\'reaction_code\' id=\'reaction_code\' value= \"\" ><div id=\'adverse_reaction\' style=\'visibility:hidden\'>(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =")</div></td></td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\'label\' width =\'25%\' >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t<td  class=\'fields\' colspan=\'3\'><TEXTAREA NAME=\"remarks\" ROWS=\"2\" COLS=\"40\" RECORD_TYPE=\'S\'></TEXTAREA></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<td  class=\'fields\' width =\'25%\'><input type=\'checkbox\' name=\'partial_check_box\' id=\'partial_check_box\'  align=\'center\' onClick=\"funCheck(this)\"></td><!-- checkbox name is changed from \'partial_check\' to \'partial_check_box\' related to incident IN023128 on 8/9/2010 by Archana Dhal-->\n\t\t<td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t<td  class=\'fields\' width =\'25%\'><input type=\'text\' name=\'TRANS_DESC\' id=\'TRANS_DESC\' maxlength=\'30\' size=\'30\' value= \"\" Onblur=\"funBTReasonDetailBlur(this)\" disabled><input type=\'button\' class=\'button\' value=\'?\' name=\'TRANS_BS\' id=\'TRANS_BS\' onClick=\"funBTReasonDetail()\" disabled><input type=\'hidden\' name=\'partial_trans_code\' id=\'partial_trans_code\' value=\"\" RECORD_TYPE=\'S\'></td>\n\t</tr>\n\n\t<tr>\n\t\t<td class =\'label\' ></td>\n\t\t<td class =\'label\' ></td>\n\t\t<td class =\'label\' ></td>\n\t\t<td align=\'right\'>\n\t\t<input type=\'Button\' class=\'button\'  name=\"save\" id=\"save\" value= \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' OnClick=\'Apply()\'> <input type=\'Button\' class=\'button\'  name=\"cancel\" id=\"cancel\" value= \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onClick=\'javascript:closeWindow()\'></td>\n\t</tr>\n</table>\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'partial_check\' id=\'partial_check\' value=\'N\' RECORD_TYPE=\'S\'>\n<input type=\'hidden\' name=\'LOGIN_USER\' id=\'LOGIN_USER\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\'hidden\' name=\'specimen_no\' id=\'specimen_no\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'unit_no\' id=\'unit_no\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=\'hidden\' name=\'product_code\' id=\'product_code\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'current_vol\' id=\'current_vol\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'blood_group\' id=\'blood_group\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<input type=\'hidden\' name=\'rhesus_code\' id=\'rhesus_code\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n<input type=\'hidden\' name=\'strVolumeUnits\' id=\'strVolumeUnits\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n<input type=\'hidden\' name=\'ISSUED_DATE\' id=\'ISSUED_DATE\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<input type=\'hidden\' name=\'RESERVED_DATE\' id=\'RESERVED_DATE\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=\'hidden\' name=\'SYSDATE\' id=\'SYSDATE\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
  
	String login_user;
	Properties p=null;
	HttpSession httpSession = request.getSession(false);
	p = (Properties)httpSession.getValue("jdbc"); 
	login_user =  p.getProperty("login_user");
	String locale = p.getProperty("LOCALE");
	String patient_id =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String specimen_no =  request.getParameter("specimen_no")==null?"":request.getParameter("specimen_no");
	String unit_no =  request.getParameter("unit_no")==null?"":request.getParameter("unit_no");
	String product_desc =  request.getParameter("product_desc")==null?"":request.getParameter("product_desc");
	String facility_id =  request.getParameter("order_facility_id")==null?"":request.getParameter("order_facility_id");
	String product_code =  request.getParameter("product_code")==null?"":request.getParameter("product_code");
	String blood_group =  request.getParameter("blood_group")==null?"":request.getParameter("blood_group");
	String rhesus_code =  request.getParameter("rhesus_code")==null?"":request.getParameter("rhesus_code");
	//String transfuse_pract_id1="";
	//String transfuse_pract_id2="";
	//String reaction_code="";      
	//String remarks="";
	//String check_pract_id="";
	String strVolumeUnits="";
	String current_vol="";
	//String start_date_time="";
	//String end_date_time="";
	String location_code="";
	//String partial_check="";
	//String partial_trans_code="";
	String Issued_date="";
	String Reserved_date="";
	String sys_date="";
	//String classValue	= "gridData";
	String sql = "";
	int    i	= 0;
	String practitioner_name ="";//IN036376

            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	locale = (locale == null || locale.equals(""))?"en":locale;
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

	try
	{
		con = ConnectionManager.getConnection(request);
		sql="SELECT   NVL (b.current_volume, 0) current_volume, NVL (d.short_desc, '') volume_units, a.storage_loc_code, TO_CHAR (a.ISSUED_DATE, 'dd/mm/yyyy HH24:MI') ISSUED_DATE, TO_CHAR (a.RESERVED_DATE, 'dd/mm/yyyy HH24:MI') RESERVED_DATE FROM bt_unit_request_dtl a, bt_blood_units_mast b, bt_uom_mast_lang_vw d WHERE a.patient_id = ? AND d.language_id = ? AND a.operating_facility_id = ? AND b.unit_no = a.unit_no AND b.product_code = a.product_code and a.PRODUCT_CODE = ?  and a.UNIT_NO = ? and a.SPECIMEN_NO = ? AND NVL (a.unit_status, 'UO') IN ('UI', 'UR') AND NVL (b.volume_units, 'X') = d.uom_code ORDER BY a.issued_date";

		/*
			Added by Kishore kumar N on 05-05-2010, for the Incident 20903
		*/	

		PreparedStatement pst = null;
		ResultSet rs1 = null;
		String descSQL = "SELECT SHORT_DESC PRODUCT_DESC FROM "+
			" BT_PRODUCT_MAST_LANG_VW WHERE PRODUCT_CODE = ? AND "+
		    " LANGUAGE_ID = ?";
		pst = con.prepareStatement(descSQL);
		pst.setString(1, product_code);
		pst.setString(2, locale);
		rs1 = pst.executeQuery();

		if(rs1.next())
		{
			product_desc = rs1.getString("PRODUCT_DESC")==null?"":rs1.getString("PRODUCT_DESC");
		}
		rs1.close();
		pst.close();
		rs1 = null;
		pst = null;
		descSQL = null;
		/*
			ends here.
		*/
		//IN036376 - Start
		//String sql1= "select USER_ID code,USERNAME description from SY_USER_LANG_VW where LANGUAGE_ID = ? and USER_ID = ? ";
		String sql1= "select Appl_user_id code,PRACTITIONER_NAME description from sm_appl_user_vw where LANGUAGE_ID =? and Appl_user_id = ? ";//reopen1[IN036376]
				
		PreparedStatement pst1 = null;
		ResultSet rs11 = null;
		
		pst1 = con.prepareStatement(sql1);
		pst1.setString(1, locale);
		pst1.setString(2, login_user);
		rs11 = pst1.executeQuery();

		if(rs11.next())
		{
			practitioner_name = rs11.getString("description")==null?"":rs11.getString("description");
		}

		rs11.close();
		pst1.close();
		//IN036376 - End
		

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(product_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		if(!(blood_group== null || blood_group.equals("")|| rhesus_code== null ||  rhesus_code.equals("")))
		{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rhesus_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
	
		}
		else
		{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block18Bytes, _wl_block18);

		}

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(unit_no));
            _bw.write(_wl_block21Bytes, _wl_block21);

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,locale);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,product_code);
		pstmt.setString(5,unit_no);
		pstmt.setString(6,specimen_no);

		/*out.println("<br> patient_id "+patient_id);
		out.println("<br> locale "+locale);
		out.println("<br> facility_id "+facility_id);
		out.println("<br> product_code "+product_code);
		out.println("<br> unit_no "+unit_no);
		out.println("<br> specimen_no "+specimen_no);*/

		rs = pstmt.executeQuery();
		while(rs!=null && rs.next())
		{
			current_vol			= rs.getString("current_volume")== null   ?  "" : rs.getString("current_volume");
			strVolumeUnits				= rs.getString("volume_units") == null ? "" : rs.getString("volume_units");
			location_code			= rs.getString("storage_loc_code") == null ? "" : rs.getString("storage_loc_code");
			Issued_date = com.ehis.util.DateUtils.convertDate(rs.getString("ISSUED_DATE"),"DMYHM","en",locale);
			Reserved_date = com.ehis.util.DateUtils.convertDate(rs.getString("RESERVED_DATE"),"DMYHM","en",locale);

			sys_date		= com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale);

			i++;

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
			if(!(current_vol== null || current_vol.equals("")|| strVolumeUnits== null ||  strVolumeUnits.equals("")))
			{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(current_vol));
            out.print( String.valueOf(strVolumeUnits));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
			else
			{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(current_vol));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
		if(i == 0)
		{ 

            _bw.write(_wl_block27Bytes, _wl_block27);
 
		}
	}
	catch(Exception e)
	{
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally 
	{
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(common_labels.getString("Common.apply.label")));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(specimen_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(unit_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(product_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(current_vol));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rhesus_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strVolumeUnits));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Issued_date));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Reserved_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RecordConsumption.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProductName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.UnitNo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StorageLocation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TransfusionDtls.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndDateTime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CheckbyPractitioner.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TransfusebyPractitioner.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionerid.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reaction.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdverseReaction.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TransfusionRemarks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PartialTransfusion.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
