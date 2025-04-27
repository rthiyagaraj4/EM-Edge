package jsp_servlet._elc._requestforcleaninglinen._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.cache.pojo.business.Cache;
import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import com.iba.ehis.lc.core.util.LcDateFormat;
import com.iba.framework.core.util.IBADateValidation;
import com.iba.ehis.core.vo.AppVO;
import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.ehis.lc.core.vo.SourceBean;
import com.iba.framework.core.util.Constants;

public final class __placecleaninglinenrequestcud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/RequestForCleaningLinen/jsp/PlaceCleaningLinenRequestCUD.jsp", 1745599950229L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/framework/html/Tag.text", 1669269889579L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n<script>\r\n\tvar loadMethod=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"\r\n\tvar applyMethod=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\r\n\tvar queryMethod=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"\r\n\tvar updateMethod=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\r\n\tvar deleteMethod=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"\r\n\tvar contextPath=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\r\n\tvar dwrMessage=\"\";\r\n\t\r\n</script>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<head>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' />\n\t\t<script src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/core/lookup/js/Lookup.js\"></script>\t\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/framework/js/hashtable.js\"></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/dwrcore/interface/MessageReader.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/dwrcore/engine.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/dwrcore/util.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/dwrcore/interface/IBADateValidator.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/dwrcore/interface/DynaLookup.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/dwrlc/engine.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/dwrlc/util.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/dwrlc/interface/RequestForCleaning.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/framework/js/Ajax_DWR.js\'></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/framework/js/validations.js\"></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/framework/js/common.js\"></script>\n\t<script type=\"text/javascript\" src=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js\'></script>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</head>\n<script>\n\nvar contentList =new Hashtable();\nvar  testpopup5=\"\";\nvar val=\"\";\nfunction setval()\n{\nval=document.getElementById(\"remarkArea\").value;\ndocument.getElementById(\"remark\").value=val;\n}\nfunction test5popupactivate(anchor) {\ntestpopup5 = new PopupWindow();\ngetServerMessage(\"com.iba.ehis.lc.remark\")\nvar title=dwrMessage;\nvar title1=title+\":\"\nvar title2=title+\"..\"\n\nval=document.getElementById(\"remark\").value;\ndocument.getElementById(\"remarkArea\").value=val;\ntestpopup5.windowProperties=\"toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no\";\ntestpopup5.height=200;\ntestpopup5.width=300;\ntestpopup5.offsetX=-10;\ntestpopup5.offsetY=10;\ntestpopup5.autoHide();\ngetServerMessage(\"com.iba.ehis.lc.ok\")\nvar buttonLabel=dwrMessage;\ntestpopup5.populate(\'<title>\'+title2+\'</title><link rel=\"stylesheet\" type=\"text/css\" href=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></link><FORM><table border=\"0\" celpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><td class=\"label\" align=\"left\"> \'+title1+\' </td></tr><tr><td  align=\"center\"><textarea rows=8 cols=40 name=\"remarkArea\" onkeyup=\"window.opener.document.getElementById(\"remarkArea\").value=this.value;window.opener.setval();window.opener.checkLength()\">\'+val+\'</textarea></td></tr><tr><td  align=\"center\"><input class=\"button\" type=\"button\" onclick=\"window.close();window.opener.setval()\" value=\"\'+buttonLabel+\'\"/></td></tr></table> </FORM>\');\n\n\ntestpopup5.showPopup(anchor);\nsetval();\n}\n\n\nfunction test5popupactivate1(anchor,index) {\nvar val=document.getElementById(\"vo.placeCleaningLinenRequestVO.cleanLinenRequest[\"+index+\"].remark\").value;\ntestpopup4 = new PopupWindow();\ngetServerMessage(\"com.iba.ehis.lc.remark\")\nvar title=dwrMessage;\nvar title1=title+\":\"\nvar title2=title+\"...\"\n\ntestpopup4.windowProperties=\"toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no\";\ntestpopup4.height=200;\ntestpopup4.width=300;\ntestpopup4.offsetX=-10;\ntestpopup4.offsetY=10;\ntestpopup4.autoHide();\ngetServerMessage(\"com.iba.ehis.lc.ok\")\nvar buttonLabel=dwrMessage;\ntestpopup4.populate(\'<title>\'+title2+\'</title><link rel=\"stylesheet\" type=\"text/css\" href=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="/core/css/";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></link><FORM><table border=\"0\" celpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><td class=\"label\" align=\"left\">\'+title1+\'</td></tr><tr><td  align=\"center\"><textarea rows=8 cols=40 readonly=true name=\"remarkArea\">\'+val+\'</textarea></td></tr><tr><td  align=\"center\"><input class=\"button\" type=\"button\" onclick=\"window.close();\" value=\"\'+buttonLabel+\'\"/></td></tr></table> </FORM>\');\ntestpopup4.showPopup(anchor);\nsetval();\n}\nfunction checkLength()\n{\nvar Tvalue=0;\nobj=document.getElementById(\"remarkArea\");\nTvalue=textAreaLimit(obj,100);\ndocument.getElementById(\"remark\").value=Tvalue;\n}\n\nfunction callLaundryUser(rec)\n{\n\tfor (prop in rec)\n\t{\n\t\t\n\t\tif (prop!=null)\n\t\t{\n\t\t\t\n\t\t\tvar userId =\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\tif(prop!=userId)\n\t\t\t{\n\t\t\t\n\t\t\tdocument.getElementById(\"category\").disabled=true;\n\t\t\t}\n\t\t}\n\t}\n}\nfunction getLoginUserPlaceLinen(){\n\t\tvar userId =\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\tRequestForCleaning.getLoggedInUser(\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",userId,callLoggedInUserPlaceLinen);\n\t}\nfunction callLoggedInUserPlaceLinen(data){\n\t\tfor(prop in data){\n\t\t\tif(prop!=null){\n\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.linenHandedOverBy\").value = prop;}\n\t\t}\n\t}\nfunction checkNumber1(obj) {\n\tvar val=obj.value;\n    if ( trimCheck(val) && isNaN(val) == false && val >0)\n        return true;\n   \telse \n\t\tif ( val == 0 ) {\n            \tgetServerMessage(\"APP-LC00018\");\n\t\t\t\tparent.parent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+dwrMessage;\n\t\t\t\twindow.event.keyCode = 27;\n\t\t\t\tobj.value=\"\";\n\t\t\t\treturn false;\n        }else\n        if ( val.length > 0 ) {\n            \tgetServerMessage(\"message.Numbers.Allowed\");\n\t\t\t\tparent.parent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+dwrMessage;\n\t\t\t\twindow.event.keyCode = 27;\n\t\t\t\tobj.value=\"\";\n\t\t\treturn false;\n        }\n}\nfunction checkAlpha(){\n\t  \t obj =  String.fromCharCode(window.event.keyCode);\n\t   \tvar alphaFilter =/^[a-z_A-Z]+$/;\n\t   \tif (!(alphaFilter.test(obj))) { \n\t   \tgetServerMessage(\"messages.Alphabet\");\n\t\tparent.parent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+dwrMessage;\n\t   \twindow.event.keyCode = 27;\n   \t\t}\n   \t}\n\nfunction showLookup() {\n\tvar sourceType=document.getElementById(\"vo.placeCleaningLinenRequestVO.sourceType\").value;\n\tvar facilityId=document.getElementById(\"vo.operatingFacilityId\").value;\n\tvar languageId=document.getElementById(\"languageId\").value;\n\t\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array(facilityId,languageId);\n\tvar datatypesArray = new Array();\n\tif(sourceType==\"W\")\n\t\t{\targArray[0] = \"ehis.lc.standardStock.nursingUnit\"\n\t\t\n\t\t}\n\t\telse if(sourceType==\"C\")\n\t\t{\targArray[0] = \"ehis.lc.standardStock.clinic\"\n\t\t}\n\t\telse if(sourceType==\"D\")\n\t\t{\t\n\t\t\targArray[0] = \"ehis.lc.standardStock.deptCode\"\n\t\t}\n\t\n\t\tnamesArray[0]=\"facilityId\";\n\t\tnamesArray[1]=\"languageId\";\n\t\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\t\t\t\t\t\n\t\t\t//Display Order\n\targArray[3] = DESC_CODE;\n\n\t\t\t// Link Description\n\targArray[4] = DESC_LINK;\n\targArray[5] =document.getElementById(\"sourceDesc\").value;\n\tretArr = Lookup(\"SourceCode\", argArray);\n\tvar txtUser = document.getElementById(\"vo.placeCleaningLinenRequestVO.sourceCode\");\n\tvar txtUser1 = document.getElementById(\"sourceDesc\");\n\t\n\tif(retArr!=null)\n\t\t\t{\n\t\t\t//Set the data in to the fields\n\t\t\ttxtUser.value = retArr[0];\n\t\t\ttxtUser1.value= retArr[1];\n\t\t\t}\n\t\n} \n\n\t\nfunction showLookup1() {\n\n\tvar sourceType=document.getElementById(\"vo.placeCleaningLinenRequestVO.sourceType\").value;\n\tvar sourceCode=document.getElementById(\"vo.placeCleaningLinenRequestVO.sourceCode\").value;\n   \tvar languageId=document.getElementById(\"languageId\").value;\n\n\tvar flag=true;\n \tvar error=\"\";\n \tvar fieldName = new Array(\n\t\t\"com.iba.ehis.lc.standardStock.sourceType\",\n\t\t\"com.iba.ehis.lc.standardStock.source\");\n\tvar fields = new Array(sourceType,sourceCode);\n\tvar key_value= new Array();\n\n \tfor(j=0;j<fieldName.length;j++)\n \t{\n \t\tif(fields[j]==\"\")\n\t\t{\t\n\t \t\tgetServerMessage(fieldName[j]);\n\t \t\tkey_value[j]=dwrMessage;\n\t\t\tgetServerMessage(\"message.cannot.blank\");\n\t\t\tmsg=dwrMessage;\n\t \t\tmsgArray=msg.split(\'#\');\n\t \t\terror=error +msgArray[0]+ key_value[j] + \" \" + msgArray[1] +\"<br>\";\n\t \t\tflag=false;\n \t\t}\n\t\t\tparent.parent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+error;\n \t}\n\n\tif(flag==true){\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\t\n\targArray[0] = \"ehis.lc.requestForLinen.getlinen\"\n\tnamesArray[0]=\"sourceType\";\n\tnamesArray[1]=\"sourceCode\";\n\tnamesArray[2]=\"languageId\";\n\n\tvaluesArray[0]=sourceType;\n\tvaluesArray[1]=sourceCode;\n\tvaluesArray[2]=languageId;\n\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\t\t\t\t\t\t\n\t\t\t//Display Order\n\targArray[3] = DESC_CODE;\n\n\t\t\t// Link Description\n\targArray[4] = DESC_LINK;\n\targArray[5] =document.getElementById(\"linenItem1\").value;\n\tgetServerMessage(\"com.iba.ehis.lc.linenitemcode\");\n\tretArr = Lookup(dwrMessage, argArray);\n\t\n\tif(retArr!=null)\n\t\t\t{\n\t\t\t//Set the data in to the fields\n\t\t\tvar linenTxt=document.getElementById(\"linenItem\");\n\t\t\tlinenTxt.value = retArr[0];\n\t\t\tdocument.getElementById(\"linenItem1\").value=retArr[1];\n\t\t\t}\n\t}\n\t\n}\t\t\n\n\nfunction checkStock()\n {\n\tvar sourceType=document.getElementById(\"vo.placeCleaningLinenRequestVO.sourceType\").value;\n\tvar sourceCode=document.getElementById(\"vo.placeCleaningLinenRequestVO.sourceCode\").value;\n\tvar facilityId=document.getElementById(\"vo.operatingFacilityId\").value;\n\tvar linenItem=document.getElementById(\"linenItem\").value;\n\tvar reqQty=document.getElementById(\"qty\").value;\n\tvar scheduleDate=document.getElementById(\"scheduleDeliveryDate\").value;\n\tvar flag=true;\n \tvar error=\"\";\n \tvar fieldName = new Array(\"com.iba.ehis.lc.linenItem\", \"com.iba.ehis.lc.requestForLinen.requestedQuantity\",\"com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate\");\n\tvar fields = new Array(linenItem,reqQty,scheduleDate);\n\tvar key_value=new Array();\n \tfor(j=0;j<fieldName.length;j++)\n \t{\t\t  \n\n \t\tif(fields[j]==\"\")\n\t\t{\t\n\t \t\tgetServerMessage(fieldName[j]);\n\t\t\tkey_value[j]=dwrMessage;\n\t\t\tgetServerMessage(\"message.cannot.blank\");\n\t\t\tmsg=dwrMessage;\n\t\t\tmsgArray=msg.split(\'#\');\n\t \t\terror=error +msgArray[0]+ key_value[j] + \" \" + msgArray[1] +\"<br>\";\n\t\t\tflag=false;\n \t\t}\n \t}\n\tparent.parent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+error;\n\tif(flag==true){\n\tRequestForCleaning.getSrcStock(sourceType,sourceCode,linenItem,facilityId,getInUseQty);\n\tfunction getInUseQty(data)\n\t{\t\n\t  var qty=parseInt(document.getElementById(\"qty\").value); \n\t\n\t\tfor(prop in data)\n\t\t var stock=prop\n\t\t\n\t\tif(parseInt(qty)>parseInt(stock))\n\t\t{\t\t\t//alert(\"if\")\n \t\t getServerMessage(\"com.iba.ehis.lc.requestForLinen.requestedQuantity\");\n\t\t var label1=dwrMessage;\n\t\t getServerMessage(\"com.iba.ehis.lc.stdStock\");\n\t\t var label2=dwrMessage;\n\t\t getServerMessage(\"messege.number.greatethan\");\n\t\t msg=dwrMessage;\n\t\t msgArray=msg.split(\'#\');\n\t\t var obj=document.getElementById(\"qty\")\n\t\t\tobj.value=\"\";\n\t\t\t\n\t\t var error=msgArray[0]+\" \"+ label1 + \" \" + msgArray[1] +\"\"+label2+\" \"+stock+\"<br>\";\n\t \tparent.parent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+error;\n\t\t}else{\n\t\t\t//alert(\"ELSE\")\n\t\t\t populateList();\n\t\t\t}\n\t\t\n\t\t}\n\t\t}\n }\n\n function setSourceType(){\n\t if(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' == \'Y\'){\n\t\tdocument.getElementById(\"sourceType\").value=document.getElementById(\"vo.placeCleaningLinenRequestVO.sourceType\").value;\n\t }\n\t\n }\n\nfunction CurrDate(arg){\n\tvar currDate = new Date();\n\tvar date = currDate.getDate();\n\tvar mon = currDate.getMonth();\n\tvar hrNow = currDate.getHours();\n\tvar mnNow = currDate.getMinutes();\n\tscNow = currDate.getSeconds();\n\tmon = mon+1;\n\tvar year = currDate.getYear();\n\tif(date <10)\n\t\tdate = \"0\"+date;\n\tif(mon <10)\n\t\tmon = \"0\"+mon;\n\tif(hrNow<10)\n\t\t\thrNow=\"0\"+hrNow;\n\tif(mnNow<10)\n\t\t\tmnNow=\"0\"+mnNow;\n\tvar convert1= date + \"/\" + mon + \"/\" + year;\n\t\tconvert1=convert1+\" \"+hrNow+ \":\" +mnNow;\n\t\n\tvar seven = 1000 * 60 * 60 * 24 * 7;\n\tvar reqFromCurrDate = new Date(currDate - seven);\n\tvar fromDate = reqFromCurrDate.getDate();\n\tvar fromMonth = reqFromCurrDate.getMonth();\n\tfromMonth = fromMonth+1;\n\tvar fromYear = reqFromCurrDate.getYear();\n\tif(fromDate <10)\n\t\tfromDate = \"0\"+fromDate;\n\tif(fromMonth <10)\n\t\tfromMonth = \"0\"+fromMonth;\n\tvar reqFromDate= fromDate + \"/\" + fromMonth + \"/\" + fromYear;\n\t\treqFromDate=reqFromDate+\" \"+hrNow+ \":\" +mnNow;\n\t\n\t\n\tif(arg==\'P\')\n\t{\n\t\tvar rdate=document.getElementById(\"vo.placeCleaningLinenRequestVO.requestDate\");\n\t\trdate.value=convert1;\n\n\t\tIBADateValidator.convertDateJS(convert1,\"en\",\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\",\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\",RDFromcallbackMethod);\n\t\t\tfunction  RDFromcallbackMethod(fdate){\n\t\t\t\tdocument.getElementById(\"requestDate\").value=fdate;\n\t\t\t}\n\t}\n}\nfunction convertSDate2En()\n{\n   var languageId= document.getElementById(\"languageId\").value;\n  var tdate=document.getElementById(\"scheduleDeliveryDate\");\n  IBADateValidator.convertDateJS(tdate.value,languageId,\"en\",\'dd/MM/yyyy HH:mm\',RDTocallbackMethod9);\n  function  RDTocallbackMethod9(ldate){\n\n\t  document.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=ldate;\n\t\n\t} \n  \n}\n\n</script>\n\n<body onload=\"CurrDate(\'P\');RequestForCleaning.getReqNo(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',getRequestNumber);getLoginUserPlaceLinen();setSourceType()\" OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n \n \t<table border=\'0 \' cellpadding=\'2\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</td>\n\t\t\t<td nowrap=\"nowrap\">\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t</td>\n\t\t\t<td nowrap=\"nowrap\">\n\t\t\t\t<input type=\"text\" name=\"requestDate\" id=\"requestDate\" readonly=\"true\" />\n\t\t\t\t<input type=hidden name=\"vo.placeCleaningLinenRequestVO.requestDate\" id=\"vo.placeCleaningLinenRequestVO.requestDate\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\n\t\t\t\t<input type=hidden name=\"vo.placeCleaningLinenRequestVO.requestDate.pattern\" id=\"vo.placeCleaningLinenRequestVO.requestDate.pattern\" value=\"dd/MM/yyyy HH:mm\" />\n\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\'right\' width=\"30%\" class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</td>\n\t\t\t<td width=\"30%\" nowrap=\"nowrap\">\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t\t\t\t<select name=\"vo.placeCleaningLinenRequestVO.sourceType\" id=\"vo.placeCleaningLinenRequestVO.sourceType\" onchange=\"setSource()\" onblur=\"setSource()\">\n\t\t\t\t\t<option value=\"W\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t<option value=\"C\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t<option value=\"D\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t</option>\n\t\t\t\t</select>\n\t\t\t\t<input type=hidden name=\"sourceType\" id=\"sourceType\"/> \n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="   \n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" \n\t\t\t\t\t <input type=text name=\"sourceType\" id=\"sourceType\" maxlength=\"10\" readonly=\"true\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"/> \n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \t\n\t\t\t ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t<td align=\'right\'width=\"20%\" class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t</td>\n\t\t\t<td width=\"40%\" nowrap=\"nowrap\" >\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" \n\t\t\t\t\t<input type=text name=\"sourceDesc\" id=\"sourceDesc\" maxlength=\"10\" readonly=\"true\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"/>\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" \n\t\t\t\t\t<input type=\"text\" name=\"sourceDesc\" id=\"sourceDesc\" maxlength=\"30\" />\n\t\t\t\t\t<input type=\'button\' class=\"BUTTON\"  value=\'?\' onclick=\'showLookup()\' />\n\t\t\t\t ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\' nowrap=\"nowrap\">\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\' >\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n<br><br>\n\t<table align=\"center\" border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\'label\' align=\'right\' nowrap=\"nowrap\" >\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t</td>\n\t\t\t<td nowrap class=\'button\'>\n\t\t\t\t<input type=\"hidden\" name=\"linenItem\" id=\"linenItem\"  />\n\t\t\t\t<input type=\"text\" name=\"linenItem1\" id=\"linenItem1\" maxlength=\"30\" onblur=\'linenItemLookup()\' />\n\t\t\t\t<input type=\'button\' class=\"BUTTON\"  value=\'?\' onclick=\'showLookup1()\' />\n\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\'right\' nowrap=\"nowrap\">\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"category\" id=\"category\" >\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="  \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\n\t\t\t\t\t<option value=\"D\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="  \n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="  \n\t\t\t\t\t<option value=\"S\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t<option value=\"I\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t<option value=\"V\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="  \n\t\t\t\t\t<option value=\"D\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t<option value=\"S\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\t\n\t\t\t\t\t</option>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' align=\'right\' nowrap=\"nowrap\">\n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"qty\" id=\"qty\" maxlength =\"10\" onkeyup=\"checkNumber1(this)\" />\n\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t</td>\n\t\t<td nowrap=\"nowrap\">\n\t\t    <input type=text name=\"scheduleDeliveryDate\" id=\"scheduleDeliveryDate\" onkeydown=\"assignDate(this,false);\" onkeypress=\"assignDate(this,false);\" onblur=\"isValidDate(this);checkDate1();\"><a onclick=\"return showCal(\'scheduleDeliveryDate\', \'%d/%m/%Y %H:%M\', 24, true,\'itemValueid\');\" name=\'.itemValueid\' id=\'itemValueid\'>\n\t\t\t<img id=\"c1\"   src=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="/framework/images/img.gif\" onmouseout=\"checkDate1();\"/></a>\n\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t<input type=\"hidden\" name=\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\" id=\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\" />\n\t\t\t<input type=\'hidden\' name=\'vo.placeCleaningLinenRequestVO.scheduleDeliveryDate.pattern\' id=\'vo.placeCleaningLinenRequestVO.scheduleDeliveryDate.pattern\' value=\'dd/MM/yyyy HH:mm\'>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' align=\'right\' nowrap=\"nowrap\">\n\t\t\t<a href=\"javascript:test5popupactivate(this.id)\" onclick=\"test5popupactivate(this.id);return false;\" name=\"prepAnchor\" id=\"prepAnchor\">\n\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a>\n\t\t\t<input type=\"hidden\" name=\"remarkArea\" id=\"remarkArea\" value=\"\" maxlength=\"100\" size=\"100\"/>\n\t\t\t<input type=\"hidden\" name=\"remark\" id=\"remark\" value=\"\" maxlength=\"100\" size=\"100\"/>\n\t\t</td>\n\t\t<td>\n\t\t&nbsp\n\t\t</td>\n\t\t<td  align=\'right\'>\n\t\t\t<input class=\"BUTTON\" type=\"button\" name=\"select\" id=\"select\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" onfocus=\"checkDate1();\" onClick=\"checkStock();\" onmouseover=\"checkDate1();convertSDate2En()\" />\n\t\t\t<input class=\"BUTTON\" type=\"button\" name=\"cancel\" id=\"cancel\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" onClick=\"cancelRecord()\"  />\n\t\t</td>\n\t\t<td>\n\t\t&nbsp\n\t\t</td>\n\t</tr>\n</table>\n<br><br>\n\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'95%\' id=\"tableid\" align=\'center\' >\n\t\t<tr>\n\t\t\t<td  colspan=5>\n\t\t\t\t<b>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<th align=\"center\" width=\"20%\">\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t</th>\n\t\t\t<th  align=\'center\' width=\"20%\">\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t</th>\n\t\t\t<th align=\"center\" width=\"20%\">\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t</th>\n\t\t\t<th align=\'center\' width=\"20%\">\n\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t</th>\n\t\t</tr>\n\t</table>\n\t\t<div id=\"listContentLayer\" align=\"center\">\n\t\t\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'95%\' id=\"contentTable\" ></table>\n\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\t\t\n\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" \n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t<!--  Modify by DhanasekarV for weblogic -->\n\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\n\t\t\t<input type=hidden name=\"cutoffTime\" id=\"cutoffTime\"  value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"/>\n\t\t\t<input type=hidden name=\"delParamDate\" id=\"delParamDate\"  value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"languageId\" id=\"languageId\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" />\n\t\t\t<input type=\"hidden\" name=\"sourcType\" id=\"sourcType\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" />\n\t\t\t<input type=\"hidden\" name=\"srctype1\" id=\"srctype1\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" />\n\t\t\t<input type=\"hidden\" name=\"sourcCode\" id=\"sourcCode\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" />\n\t\t\t<input type=\"hidden\" name=\"userFlag\" id=\"userFlag\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" />\n\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\t\t\t\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\n\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t<table align=\"center\"><tr><td><input type=\"button\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" name=\"Submit\" class=\"BUTTON\" onclick=\"RequestForCleaning.getReqNo(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\',getRequestNumber);settime();\" /></td></tr></table>\n\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n<script>\nvar rdate=\"\";\nvar rtime=\"\";\nvar sdate=\"\";\n\n\n \nfunction setScheduledeliverydate()\n{\nRequestForCleaning.getDeltime(\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\",getAllRDeliveryTimes);\nvar incr=1;\nvar mode=0;\nfunction getAllRDeliveryTimes(Data)\n\t{\n\tfor(prop in Data)\n\t{\n\n\t\tfor(prop1 in Data[prop]){\n\t\t\t\t\tvar  receiptDate=Data[prop][0]\t\n\t\t\t\t\tvar receiptDate2=Data[prop][1]\n\t\t\t\t\tvar receiptDate3=Data[prop][2]\n\t\t\t\t\tvar delDate=Data[prop][3]\n\t\t\t\t\tvar delDate2=Data[prop][4]\n\t\t\t\t\tvar delDate3=Data[prop][5]\n\t\t\t\t\tvar dayNo=Data[prop][6]\n\t\t\t\t\tvar dayNo2=Data[prop][7]\n\t\t\t\t\tvar dayNo3=Data[prop][8]\n\t\t\t\t\tvar noOfCutOfTiming=Data[prop][9]\n\t\t\t\t\t\n\t\t\t\t}}\n\t\t//alert(noOfCutOfTiming)\n\t\tif(noOfCutOfTiming==\'0\')\n\t\t{\n\t\t//document.getElementById(\"scheduleDeliveryDate\").style.visibility=\"hidden\";\n\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=\"\";\n\t\tdocument.getElementById(\"c1\").style.visibility=\"visible\";\n\t\t}else\n\t\t{\n\t\t\t\n\t\t\tdocument.getElementById(\"c1\").style.visibility=\"hidden\";\n\t\t\tdocument.getElementById(\"c1\").disabled=true;\n\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").readOnly=true;\n\t\t\tdocument.getElementById(\"scheduleDeliveryDate\").readOnly=true;\n\t\t\t\n\t\t\tvar t2=CurrDate1();\n\t\t\tvar rdate=t2+\" \"+receiptDate;\n\t\t\tvar rDate=document.getElementById(\"vo.placeCleaningLinenRequestVO.requestDate\").value;\n\t\t\t//alert(\"req\"+rdate+\"   cur\"+rDate)\n\t\t\tIBADateValidator.isDateTimeGreaterThanJS(rdate,rDate,\'en\',callBackFunction1);\n\t\t\tfunction callBackFunction1(data)\n\t\t\t\t{//alert(\"check--1-->\"+data)\n\t\t\t\tif(data==null){data=false;}\n\t\t\t\tif(data==true)\n\t\t\t\t\t{\n\n\t\t\t\t\tvar t2=CurrDate1();\n\t\t\t\t\tvar sdate=t2+\" \"+delDate;\n\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=sdate;\n\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t IBADateValidator.convertDateJS(sdate,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod);\n\t\t\t\t\t\tfunction  RDTocallbackMethod(ldate)\n\t\t\t\t\t\t  {\n\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t  } \n\t\t\t\t\t\n\t\t\t\t\t}else if(receiptDate2!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar t1=CurrDate1();\n\t\t\t\t\t\treceiptDate2=t1+\" \"+receiptDate2\n\t\t\t\t\t\tIBADateValidator.isDateTimeGreaterThanJS(receiptDate2,rDate,\'en\',callBackFunction2);\n\t\t\t\t\t\tfunction callBackFunction2(data)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t//alert(\"incr=\"+incr)\n\t\t\t\t\t\tif(incr==1){\n\t\t\t\t\t\t//alert(\"check--2-->\"+data)\n\t\t\t\t\t\tif(data==\"\"||data==undefined){data=false;}\n\t\t\t\t\t\tif(data==true)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(dayNo2!=\"\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tsdate=addDay(dayNo2,delDate2);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar c1=CurrDate1();\n\t\t\t\t\t\t\t\t\tsdate=c1+\" \"+delDate2;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t//alert(\"Condition(2)=====>Date::\"+sdate)\n\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=sdate;\n\t\t\t\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(sdate,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod1);\n\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod1(ldate)\n\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t  } \n\n\t\t\t\t\t\t\t\tmode++;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(receiptDate3!=null)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar t2=CurrDate1();\n\t\t\t\t\t\t\t\treceiptDate3=t2+\" \"+receiptDate3\n\t\t\t\t\t\t\t\tIBADateValidator.isDateTimeGreaterThanJS(receiptDate3,rDate,\'en\',callBackFunction3);\n\t\t\t\t\t\t\t\t\tfunction callBackFunction3(data)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t//alert(\"check--3-1->\"+data)\n\t\t\t\t\t\t\t\t\t\tif(data==null){data=false;}\n\t\t\t\t\t\t\t\t\t\tif(data==true)\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tif(dayNo3!=\"\")\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tsdate=addDay(dayNo3,delDate3);\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t\t\t{\tvar c1=CurrDate1();\n\t\t\t\t\t\t\t\t\t\t\t\t\tsdate=c1+\" \"+delDate3;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"Condition(3)==1===>Date::\"+sdate)\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=sdate;\n\t\t\t\t\t\t\t\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(sdate,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod2);\n\t\t\t\t\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod2(ldate)\n\t\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t  } \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t   dayNo=parseInt(dayNo)+1;\n\t\t\t\t\t\t\t\t\t\t\t\t\tsdate=addDay(dayNo,delDate);\n\t\t\t\t\t\t\t\t\t\t\t\t//\talert(\"Condition(3)==1=else:-\"+sdate);\n\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=sdate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(sdate,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod3);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod3(ldate)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  } \n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t//alert(\"check--else-1->\")\n\t\t\t\t\t\t\t\t\t\t//alert(incr)\n\t\t\t\t\t\t\t\t\t\t\tif(dayNo==0){\n\t\t\t\t\t\t\t\t\t\t\tvar facilityId=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\';\n\t\t\t\t\t\t\t\t\t\t\tRequestForCleaning.getScheduleDate(facilityId,getsDate);\n\t\t\t\t\t\t\t\t\t\t\t\tfunction getsDate(d1)\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tfor(prop in d1)\n\t\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar dd=d1[prop];\n\t\t\t\t\t\t\t\t\t\t\t\t\t dd=dd+\" \"+delDate;\n\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=dd;\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(dd,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod4);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod4(ldate)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  } \n\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse \n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tdayNo=parseInt(dayNo)+1;\n\t\t\t\t\t\t\t\t\t\t\t\t\tsdate=addDay(dayNo,delDate);\n\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=sdate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(sdate,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod5);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod5(ldate)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  } \n\t\t\t\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tincr=incr+1;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}else if(receiptDate3!=\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar t2=CurrDate1();\n\t\t\t\t\t\t\t\treceiptDate3=t2+\" \"+receiptDate3\n\t\t\t\t\t\t\t\tIBADateValidator.isDateTimeGreaterThanJS(receiptDate3,rDate,\'en\',callBackFunction4);\n\t\t\t\t\t\t\t\t\tfunction callBackFunction4(data)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t//\talert(\"check--3-2->\"+data)\n\t\t\t\t\t\t\t\t\t\tif(data==null){data=false;}\n\t\t\t\t\t\t\t\t\t\tif(data==true)\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tif(dayNo3!=\"\")\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tsdate=addDay(dayNo3,delDate3);\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\t\t\t{\tvar c1=CurrDate1();\n\t\t\t\t\t\t\t\t\t\t\t\t\tsdate=c1+\" \"+delDate3;\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t//\talert(\"Condition(3)==1===>Date::\"+sdate)\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=sdate;\n\t\t\t\t\t\t\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(sdate,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod6);\n\t\t\t\t\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod6(ldate)\n\t\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t  } \n\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t   dayNo=parseInt(dayNo)+1;\n\t\t\t\t\t\t\t\t\t\t\t\t\tsdate=addDay(dayNo,delDate);\n\t\t\t\t\t\t\t\t\t\t\t\t//\talert(sdate);\n\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=sdate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(sdate,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod7);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod7(ldate)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  } \n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t//alert(\"check--else-2->\")\n\t\t\t\t\t\t\t\t\t\tvar facilityId=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\';\n\t\t\t\t\t\t\t\t\t\tRequestForCleaning.getScheduleDate(facilityId,getsDate);\n\t\t\t\t\t\t\t\t\t\tfunction getsDate(d1)\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tfor(prop in d1)\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tvar dd=d1[prop];\n\t\t\t\t\t\t\t\t\t\t\t dd=dd+\" \"+delDate;\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"vo.placeCleaningLinenRequestVO.scheduleDeliveryDate\").value=dd;\n\t\t\t\t\t\t\t\t\t\t\t var languageId= document.getElementById(\"languageId\").value;\n\t\t\t\t\t\t\t\t\t\t\t IBADateValidator.convertDateJS(dd,\"en\",languageId,\'dd/MM/yyyy HH:mm\',RDTocallbackMethod8);\n\t\t\t\t\t\t\t\t\t\t\t\tfunction  RDTocallbackMethod8(ldate)\n\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t document.getElementById(\"scheduleDeliveryDate\").value=ldate;\n\t\t\t\t\t\t\t\t\t\t\t\t  } \n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\n\n\t\t\t\t\t\t}\n\t\t}\n}\n\n\t\t\n\t\n}\nsetScheduledeliverydate();\n\n\t</script>\n</body>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(Constants.LOAD));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Constants.CREATE));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Constants.QUERY));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Constants.UPDATE));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Constants.DELETE));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block1Bytes, _wl_block1);
             org.apache.struts.taglib.html.HtmlTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.struts.taglib.html.HtmlTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setLocale(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.html.HtmlTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block11Bytes, _wl_block11);

	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) request.getParameter("functionId");
	String moduleId = (String) request.getParameter("moduleId");
	String loggedInUser = (String) session.getAttribute("login_user");
	String dirtyFlag=(String) request.getParameter("dirtyFlag");
	String flag=(String) request.getParameter("flag");
	String cutoffTime=(String)request.getParameter("cutoffTime");
	String delParamDate=(String)request.getParameter("delParamDate");
	String userFlag=(String)request.getParameter("userFlag");
	String requestDate = (String) request.getParameter("requestDate");
	String locale = (String) session.getAttribute("LOCALE");
	
	
	//out.println("userFlag" +userFlag);
	//out.println("dirtyFlag" +dirtyFlag);

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
			//Object obj=null;

		UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
	//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
						
		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;
	
		IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(todate.toString(),locale,"en",pattern);

		
		SourceBean obj=new SourceBean();
	/*	try
			{
				obj=CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
						"sessid", "objKey");
			}catch(Exception e){out.println("Cache timed out..");} */

		try
		{
			obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,"sessid", "objKey");
									
		}catch(Exception e){} 
	
		String src=obj.getSource();
		String srcType=obj.getSourceType();
		request.setAttribute("srcType",srcType);
		request.setAttribute("src",src);
		request.setAttribute("userFlag",userFlag);
	
	
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode();



	
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block14Bytes, _wl_block14);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block16Bytes, _wl_block16);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block20Bytes, _wl_block20);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block21Bytes, _wl_block21);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block22Bytes, _wl_block22);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block23Bytes, _wl_block23);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block24Bytes, _wl_block24);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block25Bytes, _wl_block25);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block26Bytes, _wl_block26);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block27Bytes, _wl_block27);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block28Bytes, _wl_block28);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block29Bytes, _wl_block29);

                    if (_jsp__tag1(request, response, pageContext, _activeTag, __tag0))
                     return;
                    _bw.write(_wl_block30Bytes, _wl_block30);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block31Bytes, _wl_block31);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block32Bytes, _wl_block32);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block33Bytes, _wl_block33);
                    out.print( String.valueOf(session.getAttribute("login_user")));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.print( String.valueOf(session.getAttribute("login_user")));
                    _bw.write(_wl_block35Bytes, _wl_block35);
                    out.print( String.valueOf(locale));
                    _bw.write(_wl_block36Bytes, _wl_block36);
                    out.print( String.valueOf(userFlag));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.print( String.valueOf(locale));
                    _bw.write(_wl_block38Bytes, _wl_block38);
                    out.print( String.valueOf(pattern));
                    _bw.write(_wl_block39Bytes, _wl_block39);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block40Bytes, _wl_block40);
                     org.apache.struts.taglib.html.FormTag __tag2 = null ;
                    int __result__tag2 = 0 ;

                    if (__tag2 == null ){
                        __tag2 = new  org.apache.struts.taglib.html.FormTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
                    }
                    __tag2.setPageContext(pageContext);
                    __tag2.setParent(__tag0);
                    __tag2.setAction(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("/RequestForCleaningLinenAction.do", java.lang.String .class,"action"));
                    __tag2.setTarget(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("messageFrame", java.lang.String .class,"target"));
                    _activeTag=__tag2;
                    __result__tag2 = __tag2.doStartTag();

                    if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.html.FormTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block41Bytes, _wl_block41);

                            if (_jsp__tag3(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block42Bytes, _wl_block42);

                            if (_jsp__tag4(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block43Bytes, _wl_block43);

                            if (_jsp__tag5(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block44Bytes, _wl_block44);
                            out.print( String.valueOf(cdate));
                            _bw.write(_wl_block45Bytes, _wl_block45);

                            if (_jsp__tag6(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block46Bytes, _wl_block46);

                            if (_jsp__tag7(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block51Bytes, _wl_block51);
                             org.apache.struts.taglib.logic.EqualTag __tag11 = null ;
                            int __result__tag11 = 0 ;

                            if (__tag11 == null ){
                                __tag11 = new  org.apache.struts.taglib.logic.EqualTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
                            }
                            __tag11.setPageContext(pageContext);
                            __tag11.setParent(__tag2);
                            __tag11.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
                            __tag11.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
                            __tag11.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"name"));
                            _activeTag=__tag11;
                            __result__tag11 = __tag11.doStartTag();

                            if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                                }
                                do {
                                    _bw.write(_wl_block52Bytes, _wl_block52);
                                    out.print( String.valueOf(srcType));
                                    _bw.write(_wl_block53Bytes, _wl_block53);
                                } while (__tag11.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                            }
                            if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag11);
                                return;
                            }
                            _activeTag=__tag11.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
                            __tag11.release();
                            _bw.write(_wl_block54Bytes, _wl_block54);
                             org.apache.struts.taglib.html.HiddenTag __tag12 = null ;
                            int __result__tag12 = 0 ;

                            if (__tag12 == null ){
                                __tag12 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
                            }
                            __tag12.setPageContext(pageContext);
                            __tag12.setParent(__tag2);
                            __tag12.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.sourceType", java.lang.String .class,"property"));
                            __tag12.setValue(srctype
);
                            _activeTag=__tag12;
                            __result__tag12 = __tag12.doStartTag();

                            if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag12);
                                return;
                            }
                            _activeTag=__tag12.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
                            __tag12.release();
                            _bw.write(_wl_block55Bytes, _wl_block55);

                            if (_jsp__tag13(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block56Bytes, _wl_block56);
                             org.apache.struts.taglib.logic.EqualTag __tag14 = null ;
                            int __result__tag14 = 0 ;

                            if (__tag14 == null ){
                                __tag14 = new  org.apache.struts.taglib.logic.EqualTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
                            }
                            __tag14.setPageContext(pageContext);
                            __tag14.setParent(__tag2);
                            __tag14.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
                            __tag14.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
                            __tag14.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"name"));
                            _activeTag=__tag14;
                            __result__tag14 = __tag14.doStartTag();

                            if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                                }
                                do {
                                    _bw.write(_wl_block57Bytes, _wl_block57);
                                    out.print( String.valueOf(src));
                                    _bw.write(_wl_block58Bytes, _wl_block58);
                                } while (__tag14.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                            }
                            if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag14);
                                return;
                            }
                            _activeTag=__tag14.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
                            __tag14.release();
                            _bw.write(_wl_block59Bytes, _wl_block59);

                            if (_jsp__tag15(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block61Bytes, _wl_block61);
                             org.apache.struts.taglib.html.HiddenTag __tag16 = null ;
                            int __result__tag16 = 0 ;

                            if (__tag16 == null ){
                                __tag16 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
                            }
                            __tag16.setPageContext(pageContext);
                            __tag16.setParent(__tag2);
                            __tag16.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.sourceCode", java.lang.String .class,"property"));
                            __tag16.setValue(srcCode
);
                            _activeTag=__tag16;
                            __result__tag16 = __tag16.doStartTag();

                            if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag16);
                                return;
                            }
                            _activeTag=__tag16.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
                            __tag16.release();
                            _bw.write(_wl_block62Bytes, _wl_block62);

                            if (_jsp__tag17(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block63Bytes, _wl_block63);

                            if (_jsp__tag18(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block43Bytes, _wl_block43);

                            if (_jsp__tag19(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block63Bytes, _wl_block63);

                            if (_jsp__tag20(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block64Bytes, _wl_block64);

                            if (_jsp__tag21(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block65Bytes, _wl_block65);

                            if (_jsp__tag22(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block66Bytes, _wl_block66);

                            if (_jsp__tag23(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block67Bytes, _wl_block67);

                            if (_jsp__tag26(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block76Bytes, _wl_block76);

                            if (_jsp__tag31(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block80Bytes, _wl_block80);

                            if (_jsp__tag37(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block81Bytes, _wl_block81);

                            if (_jsp__tag38(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block82Bytes, _wl_block82);
                            out.print( String.valueOf(request.getContextPath()));
                            _bw.write(_wl_block83Bytes, _wl_block83);

                            if (_jsp__tag39(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block84Bytes, _wl_block84);

                            if (_jsp__tag40(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block85Bytes, _wl_block85);

                            if (_jsp__tag41(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block86Bytes, _wl_block86);

                            if (_jsp__tag42(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block87Bytes, _wl_block87);

                            if (_jsp__tag43(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block88Bytes, _wl_block88);

                            if (_jsp__tag44(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block89Bytes, _wl_block89);

                            if (_jsp__tag45(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block90Bytes, _wl_block90);

                            if (_jsp__tag46(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block89Bytes, _wl_block89);

                            if (_jsp__tag47(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block91Bytes, _wl_block91);

                            if (_jsp__tag48(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block92Bytes, _wl_block92);

                            if (_jsp__tag49(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block93Bytes, _wl_block93);

                            if (_jsp__tag51(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block95Bytes, _wl_block95);
                             org.apache.struts.taglib.html.HiddenTag __tag53 = null ;
                            int __result__tag53 = 0 ;

                            if (__tag53 == null ){
                                __tag53 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
                            }
                            __tag53.setPageContext(pageContext);
                            __tag53.setParent(__tag2);
                            __tag53.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.flag", java.lang.String .class,"property"));
                            __tag53.setValue(flag
);
                            _activeTag=__tag53;
                            __result__tag53 = __tag53.doStartTag();

                            if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag53);
                                return;
                            }
                            _activeTag=__tag53.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
                            __tag53.release();
                            _bw.write(_wl_block94Bytes, _wl_block94);
                             org.apache.struts.taglib.html.HiddenTag __tag54 = null ;
                            int __result__tag54 = 0 ;

                            if (__tag54 == null ){
                                __tag54 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
                            }
                            __tag54.setPageContext(pageContext);
                            __tag54.setParent(__tag2);
                            __tag54.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.CleaningRequestsListVO.countConfirmedBy", java.lang.String .class,"property"));
                            __tag54.setValue(loggedInUser
);
                            _activeTag=__tag54;
                            __result__tag54 = __tag54.doStartTag();

                            if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag54);
                                return;
                            }
                            _activeTag=__tag54.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
                            __tag54.release();
                            _bw.write(_wl_block94Bytes, _wl_block94);
                             org.apache.struts.taglib.html.HiddenTag __tag55 = null ;
                            int __result__tag55 = 0 ;

                            if (__tag55 == null ){
                                __tag55 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
                            }
                            __tag55.setPageContext(pageContext);
                            __tag55.setParent(__tag2);
                            __tag55.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.CleaningRequestsListVO.countConfirmedDate", java.lang.String .class,"property"));
                            __tag55.setValue(todate.toString()
);
                            _activeTag=__tag55;
                            __result__tag55 = __tag55.doStartTag();

                            if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag55);
                                return;
                            }
                            _activeTag=__tag55.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
                            __tag55.release();
                            _bw.write(_wl_block96Bytes, _wl_block96);

                            if (_jsp__tag56(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block97Bytes, _wl_block97);
                            out.print( String.valueOf(cutoffTime));
                            _bw.write(_wl_block98Bytes, _wl_block98);
                            out.print( String.valueOf(delParamDate));
                            _bw.write(_wl_block99Bytes, _wl_block99);
                            out.print( String.valueOf(locale));
                            _bw.write(_wl_block100Bytes, _wl_block100);
                            out.print( String.valueOf(srcType));
                            _bw.write(_wl_block101Bytes, _wl_block101);
                            out.print( String.valueOf(srctype));
                            _bw.write(_wl_block102Bytes, _wl_block102);
                            out.print( String.valueOf(srcCode));
                            _bw.write(_wl_block103Bytes, _wl_block103);
                            out.print( String.valueOf(userFlag));
                            _bw.write(_wl_block104Bytes, _wl_block104);
                             org.apache.struts.taglib.html.HiddenTag __tag57 = null ;
                            int __result__tag57 = 0 ;

                            if (__tag57 == null ){
                                __tag57 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
                            }
                            __tag57.setPageContext(pageContext);
                            __tag57.setParent(__tag2);
                            __tag57.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.operatingFacilityId", java.lang.String .class,"property"));
                            __tag57.setValue(facilityId
);
                            _activeTag=__tag57;
                            __result__tag57 = __tag57.doStartTag();

                            if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag57);
                                return;
                            }
                            _activeTag=__tag57.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
                            __tag57.release();
                            _bw.write(_wl_block92Bytes, _wl_block92);
                             org.apache.struts.taglib.html.HiddenTag __tag58 = null ;
                            int __result__tag58 = 0 ;

                            if (__tag58 == null ){
                                __tag58 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
                            }
                            __tag58.setPageContext(pageContext);
                            __tag58.setParent(__tag2);
                            __tag58.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.functionId", java.lang.String .class,"property"));
                            __tag58.setValue(functionId
);
                            _activeTag=__tag58;
                            __result__tag58 = __tag58.doStartTag();

                            if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag58);
                                return;
                            }
                            _activeTag=__tag58.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
                            __tag58.release();
                            _bw.write(_wl_block94Bytes, _wl_block94);
                             org.apache.struts.taglib.html.HiddenTag __tag59 = null ;
                            int __result__tag59 = 0 ;

                            if (__tag59 == null ){
                                __tag59 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
                            }
                            __tag59.setPageContext(pageContext);
                            __tag59.setParent(__tag2);
                            __tag59.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.moduleId", java.lang.String .class,"property"));
                            __tag59.setValue(moduleId
);
                            _activeTag=__tag59;
                            __result__tag59 = __tag59.doStartTag();

                            if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag59);
                                return;
                            }
                            _activeTag=__tag59.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
                            __tag59.release();
                            _bw.write(_wl_block105Bytes, _wl_block105);

                            if (_jsp__tag60(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block106Bytes, _wl_block106);

                            if (_jsp__tag61(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block107Bytes, _wl_block107);

                            if (_jsp__tag62(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block108Bytes, _wl_block108);
                            out.print( String.valueOf(facilityId));
                            _bw.write(_wl_block109Bytes, _wl_block109);
                        } while (__tag2.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                    }
                    if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                        _activeTag = null;
                        _releaseTags(pageContext, __tag2);
                        return;
                    }
                    _activeTag=__tag2.getParent();
                    weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
                    __tag2.release();
                    _bw.write(_wl_block110Bytes, _wl_block110);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block111Bytes, _wl_block111);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block112Bytes, _wl_block112);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block113Bytes, _wl_block113);
                } while (__tag0.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block114Bytes, _wl_block114);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.HtmlTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         com.iba.framework.core.pojo.web.taglib.CalandarConfigTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  com.iba.framework.core.pojo.web.taglib.CalandarConfigTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(parent);
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class com.iba.framework.core.pojo.web.taglib.CalandarConfigTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(parent);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForLinen.requestNum", java.lang.String .class,"key"));
        __tag3.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(parent);
        __tag4.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.requestNum", java.lang.String .class,"property"));
        __tag4.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
        __tag4.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("10", java.lang.String .class,"maxlength"));
        __tag4.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("10", java.lang.String .class,"size"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(parent);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForLinen.requestDate", java.lang.String .class,"key"));
        __tag5.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(parent);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.standardStock.sourceType", java.lang.String .class,"key"));
        __tag6.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(parent);
        __tag7.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
        __tag7.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag7.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"name"));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block47Bytes, _wl_block47);

                if (_jsp__tag8(request, response, pageContext, _activeTag, __tag7))
                 return true;
                _bw.write(_wl_block48Bytes, _wl_block48);

                if (_jsp__tag9(request, response, pageContext, _activeTag, __tag7))
                 return true;
                _bw.write(_wl_block49Bytes, _wl_block49);

                if (_jsp__tag10(request, response, pageContext, _activeTag, __tag7))
                 return true;
                _bw.write(_wl_block50Bytes, _wl_block50);
            } while (__tag7.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(parent);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.ward", java.lang.String .class,"key"));
        __tag8.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(parent);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.clinic", java.lang.String .class,"key"));
        __tag9.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(parent);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.department", java.lang.String .class,"key"));
        __tag10.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(parent);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.standardStock.source", java.lang.String .class,"key"));
        __tag13.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(parent);
        __tag15.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
        __tag15.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag15.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"name"));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block60Bytes, _wl_block60);
            } while (__tag15.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(parent);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy", java.lang.String .class,"key"));
        __tag17.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(parent);
        __tag18.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.linenHandedOverBy", java.lang.String .class,"property"));
        __tag18.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
        __tag18.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
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

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(parent);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy", java.lang.String .class,"key"));
        __tag19.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(parent);
        __tag20.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.linenCollectedBy", java.lang.String .class,"property"));
        __tag20.setOnkeypress(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("checkAlpha()", java.lang.String .class,"onkeypress"));
        __tag20.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(parent);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
        __tag21.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(parent);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.Category", java.lang.String .class,"key"));
        __tag22.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(parent);
        __tag23.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
        __tag23.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag23.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dirtyFlag", java.lang.String .class,"parameter"));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block67Bytes, _wl_block67);

                if (_jsp__tag24(request, response, pageContext, _activeTag, __tag23))
                 return true;
                _bw.write(_wl_block70Bytes, _wl_block70);
            } while (__tag23.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(parent);
        __tag24.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
        __tag24.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag24.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"parameter"));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block68Bytes, _wl_block68);

                if (_jsp__tag25(request, response, pageContext, _activeTag, __tag24))
                 return true;
                _bw.write(_wl_block69Bytes, _wl_block69);
            } while (__tag24.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(parent);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.dirty", java.lang.String .class,"key"));
        __tag25.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(parent);
        __tag26.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
        __tag26.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag26.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dirtyFlag", java.lang.String .class,"parameter"));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block67Bytes, _wl_block67);

                if (_jsp__tag27(request, response, pageContext, _activeTag, __tag26))
                 return true;
                _bw.write(_wl_block75Bytes, _wl_block75);
            } while (__tag26.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(parent);
        __tag27.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
        __tag27.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag27.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"parameter"));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block71Bytes, _wl_block71);

                if (_jsp__tag28(request, response, pageContext, _activeTag, __tag27))
                 return true;
                _bw.write(_wl_block72Bytes, _wl_block72);

                if (_jsp__tag29(request, response, pageContext, _activeTag, __tag27))
                 return true;
                _bw.write(_wl_block73Bytes, _wl_block73);

                if (_jsp__tag30(request, response, pageContext, _activeTag, __tag27))
                 return true;
                _bw.write(_wl_block74Bytes, _wl_block74);
            } while (__tag27.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(parent);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.soiled", java.lang.String .class,"key"));
        __tag28.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(parent);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.infected", java.lang.String .class,"key"));
        __tag29.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(parent);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.seriouslyInfected", java.lang.String .class,"key"));
        __tag30.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(parent);
        __tag31.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
        __tag31.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag31.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dirtyFlag", java.lang.String .class,"parameter"));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block67Bytes, _wl_block67);

                if (_jsp__tag32(request, response, pageContext, _activeTag, __tag31))
                 return true;
                _bw.write(_wl_block75Bytes, _wl_block75);
            } while (__tag31.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(parent);
        __tag32.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
        __tag32.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag32.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"parameter"));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block77Bytes, _wl_block77);

                if (_jsp__tag33(request, response, pageContext, _activeTag, __tag32))
                 return true;
                _bw.write(_wl_block78Bytes, _wl_block78);

                if (_jsp__tag34(request, response, pageContext, _activeTag, __tag32))
                 return true;
                _bw.write(_wl_block72Bytes, _wl_block72);

                if (_jsp__tag35(request, response, pageContext, _activeTag, __tag32))
                 return true;
                _bw.write(_wl_block73Bytes, _wl_block73);

                if (_jsp__tag36(request, response, pageContext, _activeTag, __tag32))
                 return true;
                _bw.write(_wl_block79Bytes, _wl_block79);
            } while (__tag32.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(parent);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.dirty", java.lang.String .class,"key"));
        __tag33.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(parent);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.soiled", java.lang.String .class,"key"));
        __tag34.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(parent);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.infected", java.lang.String .class,"key"));
        __tag35.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(parent);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.seriouslyInfected", java.lang.String .class,"key"));
        __tag36.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(parent);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForLinen.requestedQuantity", java.lang.String .class,"key"));
        __tag37.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(parent);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate", java.lang.String .class,"key"));
        __tag38.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(parent);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.remark", java.lang.String .class,"key"));
        __tag39.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(parent);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.selectforbutton", java.lang.String .class,"key"));
        __tag40.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(parent);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.cancel", java.lang.String .class,"key"));
        __tag41.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(parent);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
        __tag42.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(parent);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
        __tag43.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(parent);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.Category", java.lang.String .class,"key"));
        __tag44.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(parent);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForLinen.requestedQuantity", java.lang.String .class,"key"));
        __tag45.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(parent);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate", java.lang.String .class,"key"));
        __tag46.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(parent);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.remark", java.lang.String .class,"key"));
        __tag47.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(parent);
        __tag48.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.requestStatus", java.lang.String .class,"property"));
        __tag48.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("OS", java.lang.String .class,"value"));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(parent);
        __tag49.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
        __tag49.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag49.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"name"));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block93Bytes, _wl_block93);

                if (_jsp__tag50(request, response, pageContext, _activeTag, __tag49))
                 return true;
                _bw.write(_wl_block94Bytes, _wl_block94);
            } while (__tag49.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(parent);
        __tag50.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.countConfirmedYn", java.lang.String .class,"property"));
        __tag50.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.logic.EqualTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.struts.taglib.logic.EqualTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(parent);
        __tag51.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
        __tag51.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag51.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"name"));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block93Bytes, _wl_block93);

                if (_jsp__tag52(request, response, pageContext, _activeTag, __tag51))
                 return true;
                _bw.write(_wl_block94Bytes, _wl_block94);
            } while (__tag51.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.logic.EqualTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(parent);
        __tag52.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.placeCleaningLinenRequestVO.countConfirmedYn", java.lang.String .class,"property"));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(parent);
        __tag56.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.CleaningRequestsListVO.countConfirmedDate.pattern", java.lang.String .class,"property"));
        __tag56.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dd/MM/yyyy HH:mm", java.lang.String .class,"value"));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(parent);
        __tag60.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.mode", java.lang.String .class,"property"));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(parent);
        __tag61.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.viewCode", java.lang.String .class,"property"));
        __tag61.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("placeCleanLinenRequestFrame", java.lang.String .class,"value"));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(parent);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.submit", java.lang.String .class,"key"));
        __tag62.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }
}
