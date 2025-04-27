package jsp_servlet._ebt._jsp;

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
import webbeans.eCommon.*;

public final class __bttransfusiondlg extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/BTTransfusionDlg.jsp", 1709115154696L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\n<head>\n\n\n\n<Title> Transfusion Dialog</title>\n \n\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script src=\"../../eBT/js/BTTransaction.js\" language=\"javascript\"></script>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMaster.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTTransaction.js\"></Script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMessage.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<!-- Modified by DhanasekarV against SRR20056-5795  on date 22/10/2010-->\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\n  <script language=\'javascript\'>\n\n   function closeWindow()\n        {\n\t\t   parent.window.close();\n\t\t}\n\n       function checkVolume()\n\t\t{\n\t\tvar obj=document.forms[0];\n\t\t// added by Sanjay on 17-Jan-14 against SRR20056-SCF-11264 STARTS\n\t\tvar CURRENT_VOLUME = parseInt(obj.CURRENT_VOLUME.value);\n\t\tvar PR_CURRENT_VOLUME = parseInt(obj.PR_CURRENT_VOLUME.value);\n\t\t// added by Sanjay on 17-Jan-14 against SRR20056-SCF-11264 ENDS\n\t\t\n\n\t\t// 47715 Sandeep K Gujje 19-MAR-2014\n\n\t\tif (BTCheckPositiveNumber(obj.CURRENT_VOLUME))\n\t{\n\t\tif(obj.PR_CURRENT_VOLUME.value==\'0\')\n\t\t{\n\t\t//alert(getBTMessage(\"VOLUME_NULL\"));\n\t\t//BT0136,VOLUME_NULL\n\t\talert(getBTMessage(\"BT0136\",\'BT\'));\n\t\treturn;\n\t\t}\n\n\t\t//BT0165,VOLUME_LT        \n\n\t\tif(obj.CURRENT_VOLUME==null||obj.CURRENT_VOLUME.value==\'0\'||obj.CURRENT_VOLUME.value==\'\')\n\t\t{\n\t\t//BT0136,VOLUME_NULL\n\n\t\talert(getBTMessage(\"BT0136\",\"BT\"));\n\t\treturn false;\n\t\t}\n\t\t\n\t\t// below line modified by Sanjay on 17-Jan-14 against SRR20056-SCF-11264\n\t\t//if (parseInt(CURRENT_VOLUME) < parseInt(PR_CURRENT_VOLUME))\t\t\n\t\tif (parseInt(CURRENT_VOLUME) > parseInt(PR_CURRENT_VOLUME))\t\t\n\t\t//if( obj.CURRENT_VOLUME.value > obj.PR_CURRENT_VOLUME.value)\n\t\t{\t\t\t\n\t\t //Modified by DhanasekarV against % message issue  on 14/06/2011\n\t\tvar cur_vol = getLabel(\"eBT.CurrentVolume.label\",\"BT\");\n\t\tvar pre_vol = getLabel(\"eBT.PreviousVolume.label\",\"BT\");\n\t\t//var msg1 = getBTMessage(\"BT0165\",\'BT\');\n\t\tvar msg1 = getBTMessage(\"BT0164\",\'BT\');\n\t    msg1= msg1.replace(\'%1\',cur_vol);\n\t\tmsg1=msg1.replace(\'%2\',pre_vol);\n\t\talert(msg1);\n\n\t\t// 47715 Sandeep K Gujje 19-MAR-2014\n\t\tobj.CURRENT_VOLUME.value = \'\';\n//\t\tobj.CURRENT_VOLUME.focus();\n\n\t\treturn false;\n\t\t}\n\t}\n\t\t}\n\nfunction checkSTDate(objSt,objIS,objRE,objSYS,objEn,objEX)\n\t{\n\t\t\n\tvar locale\t\t= document.forms[0].locale.value;\n\t\tif(objSt==null||objSt.value==\'\') \n\t\t{\t\t\t\n\t\t\treturn;\n\t\t}\n  var obj1=changeDate1(objSt.value);\n  var obj2=changeDate1(objIS.value);\n  var obj3=changeDate1(objRE.value);\n  var obj4=changeDate1(objSYS.value);\n  var obj6=changeDate1(objEX.value);\t\n\n\n\n  if(objEn != null||objEn.value !=\'\')\n\t\t{\n\t\t  var obj5=changeDate1(objEn.value);\n\t\t   if(obj1 > obj5)\n\t\t\t\t\t{\n\t\t\t\talert(getBTMessage(\"BT0527\",\"BT\"));\n\t\t\t\tobjSt.value=\'\';\n\t\t\t\t return;\n\t\t\t\t   }\n\t\t}\n\n\nif(!(isBeforeNow(objSt.value,\"DMYHM\",locale) ))\n\t{\n\t\talert(getBTMessage(\"BT0414\",\"BT\"));\n\t\tobjSt.value=\'\';\n\t\treturn;\n\t}\n\n/*  if(obj1 > obj4 ) {\t    \n\t\talert(getBTMessage(\"BT0414\",\"BT\"));\n\t\tobjSt.value=\'\';\n\t\treturn;\n\t\t}*/\n\n  if(obj1 < obj2 )\n\t  { \t\n//BT0114,DATE_ST_GT_ISSUE\n\n  alert(getBTMessage(\"BT0114\",\"BT\"));\n  objSt.value=\'\';\n  return;}\n//BT0115,DATE_ST_LT_RESER\n//alert(obj1+\"and\"+obj3);\n  if(obj1 > obj3)       { alert(getBTMessage(\"BT0115\",\"BT\"));\n    objSt.value=\'\';\n  return;}\n\t\nif(obj1 > obj6)       { alert(getBTMessage(\"BT0551\",\"BT\"));\n    objSt.value=\'\';\n  return;}\n\n\t\n\t}\n\n\nfunction checkEnDate(objEt,objTR,objRE,objSYS,objEX)\n\t{\n\t\t\n\nvar locale\t\t= document.forms[0].locale.value;\n\n  if(objEt==null||objEt.value==\'\')\n\t\t{\t  \n\t\treturn ;\n\t\t}\n\n  var obj1=changeDate1(objEt.value);\n  var obj2=changeDate1(objTR.value);\n  var obj3=changeDate1(objRE.value);\n  var obj4=changeDate1(objSYS.value);\n  var obj5=changeDate1(objEX.value);\n\n//BT0117,DATE_EN_LT_SYS\n\nif(!(isBeforeNow(objEt.value,\"DMYHM\",locale) ))\n\t{\n\t\talert(getBTMessage(\"BT0117\",\"BT\"));\n\t\tobjEt.value=\'\';\n\t\treturn;\n\t}\n\n/*  if(obj1 > obj4 ) {\t    \n\t\talert(getBTMessage(\"BT0117\",\"BT\"));\n\t\tobjEt.value=\'\';\n\t\treturn;}*/\n//BT0118,DATE_EN_GT_TRANS\n\n  if(obj1 < obj2)    { alert(getBTMessage(\"BT0118\",\"BT\"));\n  objEt.value=\'\';\n  return;}\n//BT0119,DATE_EN_LT_RESER\n//alert(\"obj1===\"+obj1+\"obj3==\"+obj3)\n  if(obj1 > obj3)     {  alert(getBTMessage(\"BT0119\",\"LT\"));\n  objEt.value=\'\';\n  return;}\t\nif(obj1 > obj5)       { alert(getBTMessage(\"BT0550\",\"BT\"));\n    objEt.value=\'\';\n  return;}\n\n\n\t}\n\n\nfunction changeDate1(objEt)\n{\n\tvar objStr=new Array();\n\tobjStr=objEt.split(\"/\");\n\tvar datVal=\'\';\n\t//alert(\"date\"+objStr);\n\tif(objStr != null && objStr.length>0)\n\t{\n\t datVal+=objStr[1]+\"/\";\n\t datVal+=objStr[0]+\"/\";\n\t datVal+=objStr[2];\n\t}\n\telse\t datVal=objEt;\n\n\tvar dat=new Date(datVal);\n\t return dat;\n }\n\n// 47715 Sandeep K Gujje 19-MAR-2014\nfunction BTCheckNumber(obj) {\n   var sequence = \"0123456789\";\n   var obj_value = obj.value;\n   var obj_length = obj_value.length;\n\n   for (i=0; i<obj_length; i++)   {\n        if(sequence.indexOf(obj_value.charAt(i))==-1){\n\t\t\t//alert(\"ONLY_POSITIVE_NUM\");\n\t\t\talert(getBTMessage(\'BT0314\',\'BT\'));\n\t\t\tobj.value = \'\';\n\t\t\t//obj.focus();\n\t\t\treturn false;\n\t\t}\n   }\n\n   return true ;\n}\n\n// 47715 Sandeep K Gujje 19-MAR-2014\nfunction BTCheckPositiveNumber(obj) {\n   var sequence = \"123456789\";\n   var obj_value = obj.value;\n   var obj_length = obj_value.length;\n\n\n\tif(obj.value == \"\"){\n\t\treturn true;\n\t}\n\n\tif(obj != null)\n\t{\n\t\tif(!BTCheckNumber(obj))\n\t\t\treturn false;\n\n\t\tif(parseInt(obj.value) <= 0){\n\t\t\talert(getBTMessage(\'BT0136\',\'BT\')); \n\t\t\tobj.value = \'\';\n\t\t\t//obj.focus();\n\t\t\treturn false;\n\t\t}\n\n\t\treturn true;\n\t\n\t}\n}\n\n\nfunction validateNull()\n{\nvar obj=document.forms[0];\n\n\nvar strUser=obj.LOGIN_USER.value;\nobj.LOGIN_USER.value=strUser.toUpperCase();\n\n/* Commented by Sanjay against SRR20056-SCF-12161 on 03-Jan-14\nstrUser=obj.TRANSFUSE_PRACT_ID.value;\nobj.Practioner_Name1.value=strUser.toUpperCase();\n\nstrUser=obj.TRANSFUSE_PRACT_ID_2.value;\nobj.Practioner_Name2.value=strUser.toUpperCase();\n*/\n\n//alert(obj.LOGIN_USER.value+\"name1\"+obj.Practioner_Name1.value+\"name2\"+obj.Practioner_Name2.value);\n\nif(obj.CHECK_PRACT_ID.value==null||obj.CHECK_PRACT_ID.value==\'\')\n\t{\n\t//Dhana BT0267 TXT_PRACT_NULL\n\talert(getBTMessage(\"BT0438\",\"BT\"));\n\treturn false;\n\t}\nif(obj.TRANSFUSE_PRACT_ID.value==null||obj.TRANSFUSE_PRACT_ID.value==\'\')\n\t{\n\t//Dhana BT0267 TXT_PRACT_NULL\n\talert(getBTMessage(\"BT0267\",\"BT\"));\n\treturn false;\n\t}\n\n if(obj.TRANSFUSE_PRACT_ID.value != obj.LOGIN_USER.value) \n\n    if (obj.TRANSFUSE_PRACT_ID_2.value != null)\n\t{\n     if(obj.TRANSFUSE_PRACT_ID_2.value != obj.LOGIN_USER.value)\n\t{\n\t\t //BT0266, PARCT_ID_CURRENT_USER\t\t \n\talert(getBTMessage(\"BT0266\",\"BT\"));\n\treturn false;\n\t}\n\t\n\t}\n\telse\n\t{\t\t\n\t\t// BT0266 ,PARCT_ID_CURRENT_USER\n\talert(getBTMessage(\"BT0266\",\"BT\"));\n\treturn false;\n\t}\t\n\n\t// 47715 Sandeep K Gujje 19-MAR-2014\n\t// Changed if condition to validate volume field properly\n\t// if(obj.CURRENT_VOLUME==\'0\'||obj.CURRENT_VOLUME==null)\n\t// alert(\"47715 - \"+obj.CURRENT_VOLUME+\", \"+obj.CURRENT_VOLUME.value+\", \"+obj.CURRENT_VOLUME.value.length); \n\tif(obj.CURRENT_VOLUME==null||obj.CURRENT_VOLUME.value==\'0\'||obj.CURRENT_VOLUME.value==\'\')\n\t{\n\t//BT0136,VOLUME_NULL\n\n\talert(getBTMessage(\"BT0136\",\"BT\"));\n\treturn false;\n\t}\n\nif(obj.REACTION_CODE.value==null||obj.REACTION_CODE.value==\'\')\n\t{\n\t//BT0131,REACTION_CODE_NULL\n\talert(getBTMessage(\"BT0131\",\"BT\"));\n\treturn false;\n\t}\n\nif(obj.TRANSFUSE_ST_DATE_TIME.value==null||obj.TRANSFUSE_ST_DATE_TIME.value==\'\')\n\t{\n\t//BT0113,DATE_ST_NULL\n\n\talert(getBTMessage(\"BT0113\",\"BT\"));\n\treturn false;\n\t}\n\tif(obj.TRANSFUSE_EN_DATE_TIME.value==null||obj.TRANSFUSE_EN_DATE_TIME.value==\'\')\n\t{\n\t\t//BT0116,DATE_EN_NULL\n\talert(getBTMessage(\"BT0116\",\"BT\"));\n\treturn false;\n\t}\n\n     if(obj.DISC_CHECK.value == \'Y\' && (obj.TRANS_CODE.value==null||obj.TRANS_CODE.value==\'\'))\n\t{\n\t\t //BT0167,PARTIAL_TRANS_CODE\n\t\t //Modified by DhanasekarV against % message issue on 14/06/2011\n\t\t var  trn_code = getLabel(\"eBT.PartialTransfusionReason.label\",\"BT\");\n\t\t var msg2 = getBTMessage(\"BT0167\",\"BT\");\n\t\t  msg2=msg2.replace(\'%1\',trn_code);\n\t\talert(msg2);\n\t\treturn false;\n\t}\n\n\t/* added by Sanjay against SRR20056-SCF-12161 on 03-Jan-14 STARTS here */\n\tstrUser=obj.TRANSFUSE_PRACT_ID.value;\n\tobj.Practioner_Name1.value=strUser.toUpperCase();\n\tstrUser=obj.TRANSFUSE_PRACT_ID_2.value;\n\tobj.Practioner_Name2.value=strUser.toUpperCase();\n\t/* added by Sanjay against SRR20056-SCF-12161 on 03-Jan-14 ENDS here */\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n/*else if(obj.Practioner_Name2.value!=null)\n\t{\nif(obj.Practioner_Name1.value!=obj.LOGIN_USER.value && \t\tobj.Practioner_Name2.value!=obj.LOGIN_USER.value )\n\t\t{\n\t\t\talert(getBTMessage(\"PARCT_ID_CURRENT_USER\"));\n\t\t\treturn false;\n\t\t}\n\t}\nelse \n\tif(obj.Practioner_Name1.value!=obj.LOGIN_USER.value)\n\t\t{\n\t\t alert(getBTMessage(\"PARCT_ID_CURRENT_USER\"));\n\t\t return false;\n\t\t}\n*/\n\n\treturn true;\n}\n\n\nfunction transfusionDlgSubmit()\n\t{\ntry\n\t\t{\n\tif(validateNull()==false) return;\n\tvar objFrm=document.forms[0];\n\t//alert(\"1\"+objFrm);//Sanjay\n\tvar data = funBTXMLFormApply(objFrm);\n\t//alert(data);//Sanjay\n\n  var xmlDoc=\"\";\n    var xmlHttp = new XMLHttpRequest();\n\n    xmlDoc.loadXML(data);\n\t\n\txmlHttp.open(\"POST\", \"../../servlet/eBT.BTTransfuseServlet\", false);\n    xmlHttp.send(xmlDoc);\n\n\tvar resTxt=xmlHttp.responseText;\n\t\n\tparent.window.returnValue=resTxt;\n\t\t\n\tparent.window.close();\n\t\t}\n\t\tcatch(e)\n\t\t{\n\t\t\talert(\'exception\'+e);\n\t\t}\n\t\t\n\t\t}\n\nfunction funCheck(objChe)\n{\nobjFrm=document.forms[0];\nif(objChe.checked == true)\n\t{\t\nobjFrm.TRANS_BS.disabled=false;\nobjFrm.DISC_CHECK.value=\'Y\';\n\t}\nelse\n\t{\n\tobjFrm.TRANS_BS.disabled=true;\n\tobjFrm.DISC_CHECK.value=\'N\';\n\tobjFrm.TRANS_CODE.value=\'\';\n\tobjFrm.TRANS_DESC.value=\'\';\n\t}\n\n}\n\n\t   </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t    \n\n\n\n    </head>\n\n\n <body onLoad=\"callStorageLocation()\">\n    <form name=\'BT_UNIT_REQUEST_DTL\' id=\'BT_UNIT_REQUEST_DTL\' method=\'post\'   action=\'\' target=\'messageFrame\'> \n\n   \t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\n\n\t\n<table width=\'100%\'  cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n\n<!--<tr>\n<td class=\'label\' align=\'left\'>&nbsp;</td>\n<td class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<td class=\'label\' align=\'left\'>&nbsp;</td>\n</tr> -->\n\n<tr>\n<td class=\'label\' align=\'left\'>&nbsp;</td>\n<td class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp&nbsp\n<input type=\'text\' name=\'UNIT_NO\' id=\'UNIT_NO\' maxlength=\'20\' size=\'20\' value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  RECORD_TYPE=\'S\' disabled> </td>\n<td class=\'label\' align=\'left\'>&nbsp;</td>\n</tr>\n\n<tr>\n<td colspan=\'3\' class=\'label\'>&nbsp;</td>\n</tr>\n\n\n<tr>\n<td class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n<td class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n</tr>\n\n\n<tr>\n<td class=\'label\' align=\'left\'>\n<input type=\'text\' name=\'Checked_Practioner\' id=\'Checked_Practioner\' maxlength=\'30\' size=\'30\' value= \"\" disabled>\n<input type=\'button\' class=\'Button\' value=\'?\' onClick=\"funBTCheckDetail1(\'3\')\"  name=\'bs\' id=\'bs\'>\n<img src=\'..\\..\\eCommon/images/mandatory.gif\'></img>\n</td>\n<td class=\'label\' align=\'left\'>\n<input type=\'text\' name=\'Practioner_Name1\' id=\'Practioner_Name1\' maxlength=\'30\' size=\'25\' value= \"\" disabled>\n<input type=\'button\' class=\'Button\' value=\'?\' onClick=\"funBTCheckDetail1(\'1\')\"  name=\'bs\' id=\'bs\'>\n<img src=\'..\\..\\eCommon/images/mandatory.gif\'></img>\n</td>\n\n<td class=\'label\' align=\'left\'>\n<input type=\'text\' name=\'Practioner_Name2\' id=\'Practioner_Name2\' maxlength=\'30\' size=\'25\' value= \"\" disabled>\n<input type=\'button\' class=\'Button\' value=\'?\' onClick=\"funBTCheckDetail1(\'2\')\"  name=\'bs\' id=\'bs\'>\n</td>\n</tr>\n<tr>\n<td colspan=\'3\' class=\'label\'>&nbsp;</td>\n</tr>\n\n\n<tr>\n<td class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n<td class=\'label\' align=\'left\'>&nbsp;</td>\n</tr>\n\n\n<tr>\n<td class=\'label\' align=\'left\'>\n<input type=\'text\' name=\'TRANSFUSE_ST_DATE_TIME\' id=\'TRANSFUSE_ST_DATE_TIME\' maxlength=\'19\' size=\'19\' value= \"\" RECORD_TYPE=\'S\' Onblur=\'checkSTDate(this,document.forms[0].ISSUED_DATE,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].TRANSFUSE_EN_DATE_TIME,document.forms[0].EXPIRY_DATE);\' >      \n<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'TRANSFUSE_ST_DATE_TIME\',\'dd/mm/y\',\'hh:mm:ss\');\"\n>&nbsp;\n<img src=\'..\\..\\eCommon/images/mandatory.gif\'></img>\n</td>\n\n<td class=\'label\' align=\'left\'>\n<input type=\'text\' name=\'TRANSFUSE_EN_DATE_TIME\' id=\'TRANSFUSE_EN_DATE_TIME\' maxlength=\'19\' size=\'19\' value= \"\" RECORD_TYPE=\'S\' Onblur=\'checkEnDate(this,document.forms[0].TRANSFUSE_ST_DATE_TIME,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].EXPIRY_DATE);\' >      \n\n<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'TRANSFUSE_EN_DATE_TIME\',\'dd/mm/y\',\'hh:mm:ss\');\">\n<img src=\'..\\..\\eCommon/images/mandatory.gif\'></img>\n</td>\n<td class=\'label\' align=\'left\'>&nbsp;</td>\n</tr>\n\n<tr>\n<td colspan=\'3\' class=\'label\'>&nbsp;</td>\n</tr>\n\n\n\n<tr>\n<td class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n<td class=\'label\' align=\'left\' colspan=\'2\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n</tr>\n\n\n<tr>\n<td class =\'label\' align=\'left\'>\n<input type=\'text\' name=\'CURRENT_VOLUME\' id=\'CURRENT_VOLUME\' maxlength=\'5\' size=\'5\' value= \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" RECORD_TYPE=\'S\' Onblur=\'checkVolume()\'>&nbsp;&nbsp;\n<input type=\'text\' name=\'xx1\' id=\'xx1\' maxlength=\'25\' size=\'15\' value= \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" disabled>      \n&nbsp;&nbsp;&nbsp;\n</td>\n<td class=\'label\' align=\'left\'>\n<input type=\'text\' name=\'LOCATION_CODE\' id=\'LOCATION_CODE\' maxlength=\'4\' size=\'4\' value= \"\" RECORD_TYPE=\'S\' Onblur=\'validateStorage();\'>      \n<input type=\'button\' class=\'button\' value=\'?\'   name=\'bs\' id=\'bs\'\nonClick=\"funBTStorageLocation()\">\n&nbsp;</td>\n\n<td  class=\'label\'>&nbsp;</td> \n</tr>\n\n\n<tr>\n<td colspan=\'3\' class=\'label\'>&nbsp;</td>\n</tr>\n\n<tr>\n<td class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n</tr>\n\n<tr>\n<td class =\'label\' align=\'left\'  >\n<input type=\'text\' name=\'REACTION_CODE\' id=\'REACTION_CODE\' maxlength=\'4\' size=\'4\' value= \"\" RECORD_TYPE=\'S\' disabled>&nbsp;\n</td>\n<td class =\'label\' align=\'left\'  >\n<input type=\'text\' name=\'REACTION_DESC\' id=\'REACTION_DESC\' maxlength=\'40\' size=\'30\' value= \"\" disabled>   \n<input type=\'button\' class=\'button\' value=\'?\'   name=\'bs\' id=\'bs\'\nonClick=\"funBTReactionDetail()\"\n><img src=\'..\\..\\eCommon/images/mandatory.gif\'></img></td>\n<td class=\'label\' align=\'left\'><input type=\'checkbox\' name=\'adverse\' id=\'adverse\' disabled></td>\n</tr>\n\n<tr>\n<td colspan=\'3\' class=\'label\'>&nbsp;</td>\n</tr>\n\n<tr>\n<td colspan=\'3\' class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n</tr>\n\n<tr>\n<td class=\'label\' colspan=\'3\' align=\'left\'>\n <TEXTAREA NAME=\"TRANSFUSION_REMARKS\" ROWS=\"2\" COLS=\"40\" RECORD_TYPE=\'S\'></TEXTAREA>\n</td>\n</tr>\n\n\n<tr>\n<td class=\'label\' align=\'left\'> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="?</td>\n<td class=\'label\' align=\'left\' colspan=\'2\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n<td class=\'label\' align=\'left\'></td>\n</tr>\n\n\n<tr>\n<td class =\'label\' align=\'left\' >\n<input type=\'checkbox\' name=\'DISCONTINUE\' id=\'DISCONTINUE\'  align=\'center\' onClick=\"funCheck(this)\"  >&nbsp;&nbsp;  \n</td>\n\n<td class =\'label\' align=\'left\' colspan=\'2\'>\n<input type=\'text\' name=\'TRANS_CODE\' id=\'TRANS_CODE\' maxlength=\'5\' size=\'5\' RECORD_TYPE=\'S\' readonly>     \n&nbsp;&nbsp;\n<input type=\'text\' name=\'TRANS_DESC\' id=\'TRANS_DESC\' maxlength=\'30\' size=\'30\' value= \"\" Onblur=\'\' readonly>\n<input type=\'button\' class=\'button\' value=\'?\'   name=\'TRANS_BS\' id=\'TRANS_BS\' onClick=\"funBTReasonDetail()\" disabled>\n</td>\n</tr>\n\n\n<tr>\n<td class =\'label\' ></td>\n<td class =\'label\' ></td>\n<td class =\'label\'  align=\'right\' >\n\n<!--<input type=\'Button\' class=\'button\'  name=\"save\" id=\"save\" value= \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'OnClick=\'transfusionDlgSubmit()\'> \n<input type=\'button\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' name=\'save\' class=\'BUTTON\' OnClick=\'transfusionDlgSubmit()>\n&nbsp;&nbsp;<input type=\'Button\' class=\'button\'  name=\"cancel1\" id=\"cancel1\" value= \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\'javascript:closeWindow()\'>  -->\n<input type=\'Button\' class=\'button\'  name=\"save\" id=\"save\" value= \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'\nOnClick=\'transfusionDlgSubmit()\'> \n&nbsp;&nbsp;<input type=\'Button\' class=\'button\'  name=\"cancel\" id=\"cancel\" value= \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onClick=\'javascript:closeWindow()\'>\n</td>\n</tr>\n</table>\n</table>  \n<input type=\'hidden\' name=\'SYDATE\' id=\'SYDATE\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'ISSUED_DATE\' id=\'ISSUED_DATE\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'RESERVED_DATE\' id=\'RESERVED_DATE\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'EXPIRY_DATE\' id=\'EXPIRY_DATE\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'LOGIN_USER\' id=\'LOGIN_USER\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\n<input type=\'hidden\' name=\'PR_CURRENT_VOLUME\' id=\'PR_CURRENT_VOLUME\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\n\n<input type=\'hidden\' name=\'PATIENT_ID\' id=\'PATIENT_ID\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' RECORD_TYPE=\'S\'>\n\n<input type=\'hidden\' name=\'SPECIMEN_NO\' id=\'SPECIMEN_NO\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' RECORD_TYPE=\'S\'>\n\n<input type=\'hidden\' name=\'PRODUCT_CODE\' id=\'PRODUCT_CODE\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' RECORD_TYPE=\'S\'>\n\n\n<input type=\'hidden\' name=\'PRACTIONER_CODE\' id=\'PRACTIONER_CODE\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' RECORD_TYPE=\'S\'>\n\n<input type=\'hidden\' name=\'RHESUS_CODE\' id=\'RHESUS_CODE\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\n<input type=\'hidden\' name=\'BLOOD_GROUP\' id=\'BLOOD_GROUP\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\n<input type=\'hidden\' name=\'FACILITY_ID\' id=\'FACILITY_ID\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' RECORD_TYPE=\'S\'>\n\n<input type=\'hidden\' name=\'FID\' id=\'FID\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n\n<input type=\'hidden\' name=\'TRANSFUSE_PRACT_ID\' id=\'TRANSFUSE_PRACT_ID\' value=\'\' RECORD_TYPE=\'S\'> \n<input type=\'hidden\' name=\'TRANSFUSE_PRACT_ID_2\' id=\'TRANSFUSE_PRACT_ID_2\' value=\'\' RECORD_TYPE=\'S\'> \n<input type=\'hidden\' name=\'CHECK_PRACT_ID\' id=\'CHECK_PRACT_ID\' value=\'\' RECORD_TYPE=\'S\'> \n\n<input type=\'hidden\' name=\'ROW_ID\' id=\'ROW_ID\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' RECORD_TYPE=\'S\'> \n\n<input type=\'hidden\' name=\'DISC_CHECK\' id=\'DISC_CHECK\' value=\'N\'  RECORD_TYPE=\'S\'>\n<input type=\'hidden\' name=\'SOURCE_TYPE\' id=\'SOURCE_TYPE\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'> \n<input type=\'hidden\' name=\'SOURCE_CODE\' id=\'SOURCE_CODE\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'> \n<input type=\'hidden\' name=\'BAR_CODE_SCAN_SITE_YN\' id=\'BAR_CODE_SCAN_SITE_YN\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0157 -->\n<input type=\'hidden\' name=\'ENTRY_TYPE\' id=\'ENTRY_TYPE\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0157 -->\n<input type=\'hidden\' name=\'REASON_CODE\' id=\'REASON_CODE\' value=\'\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0157 -->\n<input type=\'hidden\' name=\'REASON_DESC\' id=\'REASON_DESC\' value=\'\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0157 -->\n<input type=\'hidden\' name=\'MODULE_ID\' id=\'MODULE_ID\' value=\'BT\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0157 -->\n<input type=\'hidden\' name=\'MENU_ID\' id=\'MENU_ID\' value=\'BLOOD_CONSUMPTION\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0157 -->\n<input type=\'hidden\' name=\'BARCODE_SCAN_COUNT_YN\' id=\'BARCODE_SCAN_COUNT_YN\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0157 -->\n<input type=\'hidden\' name=\'PATIENT_CLASS\' id=\'PATIENT_CLASS\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0170.2 -->\n<input type=\'hidden\' name=\'ENCOUNTER_ID\' id=\'ENCOUNTER_ID\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0170.2 -->\n<input type=\'hidden\' name=\'SCAN_COUNT_REQUIRED_YN\' id=\'SCAN_COUNT_REQUIRED_YN\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0170.2 -->\n<input type=\'hidden\' name=\'ALERT_REQUIRED_YN\' id=\'ALERT_REQUIRED_YN\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0170.2 -->\n<input type=\'hidden\' name=\'REMARKS_REQUIRED_YN\' id=\'REMARKS_REQUIRED_YN\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' RECORD_TYPE=\'S\'> <!-- Added for MMS-DM-CRF-0170.2 -->\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block9Bytes, _wl_block9);




		String login_user;
		String strFid="";
		Properties p=null;
		HttpSession httpSession = request.getSession(false);
		p = (Properties)httpSession.getValue("jdbc"); 
		strFid=""+httpSession.getAttribute("facility_id");

		login_user =  p.getProperty("login_user");



		   String strUnitNo;
		   String strSpecimenNo;
		   String strProductCode;
		   String strFacilityId;
		   String strPatientId;
		   String strTransfusedVol;
		   String strTransfusedUnits;
		   String strRowId;
		   String strIssuedDate;
		   String strReservedDate;
		   String strSysDate;


		   String strRhesusCode;
		   String strBloodGroup;

		   String strSourceType="";
		   String strSourceCode="";
		   String strExpiryDate="";
		   String bar_code_scan_site_yn ="";//Added for MMS-DM-CRF-0157
		   String entry_type ="";//Added for MMS-DM-CRF-0157
		   String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="",patient_class="",encounter_id="";//Added for MMS-DM-CRF-0170.2





locale = (locale == null || locale.equals(""))?"en":locale;

java.util.Locale loc = new java.util.Locale(locale);
java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
//System.err.println("params@@@@===="+ request.getQueryString());

			strUnitNo=request.getParameter("UNIT_NO");
			strSpecimenNo=request.getParameter("SPECIMEN_NO");
		    strProductCode=request.getParameter("PRODUCT_CODE");
		    strFacilityId=request.getParameter("OPERATING_FACILITY_ID");
		    strPatientId=request.getParameter("PATIENT_ID");
			strTransfusedVol=request.getParameter("CURRENT_VOLUME");
			strRowId=request.getParameter("ROW_ID");
			strTransfusedUnits=request.getParameter("VOLUME_UNITS");

			//strIssuedDate=request.getParameter("ISSUED_DATE");
			//strReservedDate=request.getParameter("RESERVED_DATE");
			
			strIssuedDate=com.ehis.util.DateUtils.convertDate(request.getParameter("ISSUED_DATE"),"DMYHM","en",locale);
			strReservedDate=com.ehis.util.DateUtils.convertDate(request.getParameter("RESERVED_DATE"),"DMYHM","en",locale);

			strExpiryDate= com.ehis.util.DateUtils.convertDate(request.getParameter("EXPIRY_DATE"),"DMYHM","en",locale);
		//strSysDate=request.getParameter("SYDATE");
			strSysDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale);	
		//strSysDate=com.ehis.util.DateUtils.convertDate(request.getParameter("SYDATE"),"DMYHMS","en",locale);
		//strSysDate=com.ehis.util.DateUtils.convertDate("03/01/2007 8:16","DMY","en",locale);
		//strSysDate=com.ehis.util.DateUtils.convertDate("03/01/2007 08:13","DMYHM","en",locale);
		//strSysDate=request.getParameter("SYDATE");


			strRhesusCode=request.getParameter("RHESUS_CODE");
			strBloodGroup=request.getParameter("BLOOD_GROUP");
			bar_code_scan_site_yn=request.getParameter("BAR_CODE_SCAN_SITE_YN");//Added for MMS-DM-CRF-0157
			patient_class=request.getParameter("PATIENT_CLASS");//Added for MMS-DM-CRF-0170.2
			encounter_id=request.getParameter("ENCOUNTER_ID");//Added for MMS-DM-CRF-0170.2
			scan_count_required_yn=request.getParameter("SCAN_COUNT_REQUIRED_YN");//Added for MMS-DM-CRF-0170.2
			alert_required_yn=request.getParameter("ALERT_REQUIRED_YN");//Added for MMS-DM-CRF-0170.2
			remarks_required_yn=request.getParameter("REMARKS_REQUIRED_YN");//Added for MMS-DM-CRF-0170.2		
			entry_type=request.getParameter("ENTRY_TYPE");//Added for MMS-DM-CRF-0157
			System.err.println("bar_code_scan_site_yn11111@@@===="+bar_code_scan_site_yn+"entry_type==="+entry_type+"scan_count_required_yn==="+scan_count_required_yn+"alert_required_yn=="+alert_required_yn+"encounter_id===="+encounter_id+"patient_class==="+patient_class);


		//eBT.LogFile.log("QADebugger","Rhesus"+strRhesusCode,this);
		//eBT.LogFile.log("QADebugger","strBloodGroup"+strBloodGroup,this);

		Connection conn=null;


		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		String sql=" SELECT NVL(SHORT_DESC,'')  from BT_UOM_MAST_LANG_VW where  language_id = ? and  UOM_CODE =  ?";
		
		try
		{
			conn = ConnectionManager.getConnection(request);
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,strTransfusedUnits);
			rs1 = pstmt1.executeQuery();
			if(rs1.next())
			{
			strTransfusedUnits=rs1.getString(1);
			}

		}catch(Exception ee){}
		finally
		{
		rs1.close();
		pstmt1.close();		
		}


		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="select SOURCE_TYPE,SOURCE_CODE from BT_UNIT_REQUEST_HDR where SPECIMEN_NO=? and operating_facility_id=?";
		
		try
		{

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,strSpecimenNo);
			pstmt.setString(2,strFacilityId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
			strSourceType=rs.getString(1);
			strSourceCode=rs.getString(2);
			}

		}catch(Exception ee){}
		finally
		{
		rs.close();
		pstmt.close();
		ConnectionManager.returnConnection(conn,request);
		}
		ConnectionManager.returnConnection(conn,request);


            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strUnitNo));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StorageLocation.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strTransfusedVol));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strTransfusedUnits));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(common_labels.getString("Common.apply.label")));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(common_labels.getString("Common.apply.label")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(common_labels.getString("Common.cancel.label")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strSysDate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strIssuedDate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strReservedDate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strExpiryDate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strTransfusedVol));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strSpecimenNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strProductCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strProductCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strRhesusCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strBloodGroup));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strFid));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strRowId));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strSourceType));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strSourceCode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bar_code_scan_site_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(entry_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bar_code_scan_site_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(scan_count_required_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alert_required_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(remarks_required_yn));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.UnitNo.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.UnitNo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.CheckedPractioner.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.TransfuseByPractitioner.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionerid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.startdatetime.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndDateTime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionCode.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdverseReaction.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.TransfusionRemarks.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discontinue.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.PartialTransfusionDesc.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apply.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
