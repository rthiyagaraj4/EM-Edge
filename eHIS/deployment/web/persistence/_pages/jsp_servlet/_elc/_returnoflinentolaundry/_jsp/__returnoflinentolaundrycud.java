package jsp_servlet._elc._returnoflinentolaundry._jsp;

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
import com.iba.ehis.lc.core.util.LcDateFormat;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.util.IBADateValidation;
import com.iba.ehis.lc.core.vo.SourceBean;
import com.iba.framework.core.util.Constants;

public final class __returnoflinentolaundrycud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/ReturnofLinentoLaundry/jsp/ReturnofLinentoLaundryCUD.jsp", 1709118358760L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block12 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' />\t<script src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script type=\"text/javascript\" src=\"";
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

    private final static java.lang.String  _wl_block23 ="/framework/js/Ajax_DWR.js\'></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/framework/js/validations.js\"></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/framework/js/common.js\"></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/dwrlc/interface/ReturnofLinentoLaundry.js\'></script>\n\t<Script language=\"JavaScript\" src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eLC/ReturnofLinentoLaundry/js/ReturnofLinentoLaundry.js\"></Script>\n\t<script src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</head>\n<script type=\"text/javascript\">\n\n\tvar contentList =new Hashtable();\n\tvar  testpopup5=\"\";\n\tvar  testpopup4=\"\";\n\tvar val=\"\";\n\tvar required_Duplicate_Check = 0;\n\t\n// **********************************************************************************************\n\t\n\tfunction checkLength()\n\t{\n\tvar Tvalue=0;\n\tobj=document.getElementById(\"remarkArea\");\n\tTvalue=textAreaLimit(obj,100);\n\tdocument.getElementById(\"remark\").value=Tvalue;\n\t}\n\t\n// **********************************************************************************************\n\t\n\tfunction setval()\n\t{\n\tval=document.getElementById(\"remarkArea\").value;\n\tdocument.getElementById(\"remark\").value=val;\n\t}\n\t\n// **********************************************************************************************\n\t\n\tfunction test5popupactivate(anchor) {\n\tif(testpopup5==\"\")\n\t{\n\t testpopup5 = new PopupWindow();\n\t}\n\tval=document.getElementById(\"remark\").value;\n\tdocument.getElementById(\"remarkArea\").value=val;\n\ttestpopup5.height=200;\n\ttestpopup5.width=300;\n\ttestpopup5.offsetX=-10;\n\ttestpopup5.offsetY=10;\n\ttestpopup5.autoHide();\n\n\tgetServerMessage(\"com.iba.ehis.lc.remark\")\n\tvar title=dwrMessage;\n\tvar title1=title+\":\"\n\tvar title2=title+\"..\"\n\n\tgetServerMessage(\"com.iba.ehis.lc.ok\")\n\tvar buttonLable=dwrMessage;\n\n\ttestpopup5.populate(\'<title>\'+title2+\'</title><link rel=\"stylesheet\" type=\"text/css\" href=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></link><FORM><CENTER><table border=\"0\" celpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><td class=\"label\" align=\"center\">\'+title1+\'</td></tr><tr><td  align=\"center\"><textarea rows=8 cols=40 maxlength=2000 name=\"remarkArea\" onkeyup=\"window.opener.document.getElementById(\"remarkArea\").value=this.value;window.opener.setval();window.opener.checkLength()\">\'+val+\'</textarea></td></tr><tr><td  align=\"center\"><input class=\"button\" type=\"button\" onclick=\"window.close();window.opener.setval()\" value=\"\'+buttonLable+\'\"/></td></tr></table> </FORM></CENTER>\');\n\ttestpopup5.showPopup(anchor);\n\tsetval();\n\t}\n\n// **********************************************************************************************\n\t\n\tfunction test5popupactivate1(anchor,index)\n\t\t {\n\t\t\tvar val=document.getElementById(\"vo.linenRequest[\"+index+\"].remark\").value;\n\t\t\ttestpopup4 = new PopupWindow();\n\t\t\ttestpopup4.windowProperties=\"toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no\";\n\t\t\ttestpopup4.height=200;\n\t\t\ttestpopup4.width=300;\n\t\t\ttestpopup4.offsetX=-10;\n\t\t\ttestpopup4.offsetY=10;\n\t\t\ttestpopup4.autoHide();\n\n\t\t\tgetServerMessage(\"com.iba.ehis.lc.remark\")\n\t\t\tvar title=dwrMessage;\n\t\t\tvar title1=title+\":\"\n\t\t\tvar title2=title+\"..\"\n\n\t\t\tgetServerMessage(\"com.iba.ehis.lc.ok\")\n\t\t\tvar buttonLable=dwrMessage;\n\n\t\t\ttestpopup4.populate(\'<title>\'+title2+\'</title><link rel=\"stylesheet\" type=\"text/css\" href=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></link><FORM><CENTER><table border=\"0\" celpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><td class=\"label\" align=\"center\"> \'+title1+\' </td></tr><tr><td  align=\"center\"><textarea rows=8 cols=40 readonly=true name=\"remarkArea\">\'+val+\'</textarea></td></tr><tr><td  align=\"center\"><input class=\"button\" type=\"button\" onclick=\"window.close();\" value=\"\'+buttonLable+\'\"/></td></tr></table> </FORM></CENTER>\');\n\t\t\ttestpopup4.showPopup(anchor);\n\t\t}\n\t\t\n// **********************************************************************************************\n\n\tfunction LinenViewVo(linenItem,linenItemDesc,qty,remark,flag) {\n\t\tthis.linenItem = linenItem;\n\t\tthis.linenItemDesc = linenItemDesc;\n\t\tthis.qty = qty;\n\t\tthis.remark = remark;\n\t\tif (flag == null) \n\t\t\tflag = \"createMethod\";\n\t\tthis.flag = flag;\n\t}\n\t\n// **********************************************************************************************\n\t\t\n\tfunction getAvailbleQty1(){\n\t\tvar facility_id = document.getElementById(\"vo.operatingFacilityId\").value;\n\t\tvar sourceType = document.getElementById(\"vo.sourceType\").value;\n\t\tvar sourceCode = document.getElementById(\"vo.sourceCode\").value;\n\t\tvar linenItemCode = document.getElementById(\"linenItem\").value;\n\t\tvar qty = document.ReturnofLinentoLaundryForm[\"qty\"].value;\n\t\t\t\n\t    ReturnofLinentoLaundry.getAvailQty(facility_id,sourceType,sourceCode,linenItemCode,callAvailQty1)\n\t}\n\t\n// *******************************************************************************************\n\t\n\tfunction callAvailQty1(data){\n\t\tvar availQty=0;\n\t\tfor(prop in data){\n\t\t\tavailQty = data[prop];\n\t\t\tif(availQty==null)availQty=0;\n\t\t\t\tcheckQty(availQty);\n\t\t\t\t}\n\t\t\t}\n\n\n// **************************************************************************\n\t\t\n\tfunction populateList() {\n\t\tvar flag = \"\";\n\t\tvar linenItem = document.ReturnofLinentoLaundryForm[\"linenItem\"].value;\n\t\tvar qty = document.ReturnofLinentoLaundryForm[\"qty\"].value;\n\t\tvar remark = document.ReturnofLinentoLaundryForm[\"remark\"].value;\n\t\tvar linenItemDesc = document.ReturnofLinentoLaundryForm[\"linenItemDesc\"].value;\n\t\t\t\t\n\t\tif(NullCheckLinenItem()== true){\n\t\tif(linenItem != \'\'){\n\t\t\t\n\t\t\tif(required_Duplicate_Check == 1){\n\t\t\t\t\n\t\t\t\tvar f1 = duplicateCheck(linenItem);\n\t\t\t\tif(f1 == false)return\n\t\t\t}\n\n\t\t\tviewObj = new LinenViewVo(linenItem,linenItemDesc,qty,remark)\n\t\t\tcontentList.put(viewObj.linenItem,viewObj);\n\t\t\tshowRecords();\n\t\t\t}\n\t\t\n\t\trequired_Duplicate_Check = 0;\n\t\t}\n\t}\n// **********************************************************************************************\n\tfunction duplicateCheck(linenItem){\n\t\t\n\t\t\tvar f1;\n\t\t\tvar error=\"\";\n\t\t\t\n\t\t\tfor (var i in contentList.values()) {\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tdataObj=contentList.values()[i];\n\t\t\t\tif(contentList.values()[i] != null){\n\t\t\t\t\tif(linenItem == dataObj.linenItem){\n\t\t\t\t\t\tgetServerMessage(\"MESSAGE.OPERATION_FAILURE\");\n\t\t\t\t\t\terror =dwrMessage;\n\t\t\t\t\t\tf1 = false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\t\n\t\t\tparent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+error;\n\t\t\tif(f1==false) return false; else return true;\n\t\t}\n\t\t\n\n// **********************************************************************************************\n\n\tfunction deleteRows() {\n\t\tvar tableObj = document.getElementById(\"contentTable\");\n\t\tvar len = tableObj.rows.length;\n\t\tfor (i = len - 1; i != -1; i--) {\n\t\t\ttableObj.deleteRow(i);\n\t\t}\n\t}\n\t\n// **********************************************************************************************\n\n\tfunction showRecords() {\n\t\n\t\tvar htmlContent = \"\";\n\t\tvar tableObj = document.getElementById(\"contentTable\");\n\t\tdeleteRows();\n\t\tindex = 0;\n\t\tvar i=0;\n\t\tindex = parseInt(index);\n\t\tfor (  i in contentList.values()) {\n\t\t\tdataObj = contentList.values()[i];\n\t\t\tif (dataObj != null) {\n\t\t\t\ttableObj = document.getElementById(\"contentTable\");\n\t\t\t\tif (dataObj.flag != \"deleteMethod\") {\n\t\t\t\t\tvar row = tableObj.insertRow(tableObj.rows.length);\n\t\t\t\t\tvar col1 = row.insertCell();\n\t\t\t\t\tcol1.className = \"QRYEVEN\";\n\t\t\t\t\tcol1.width=\"30%\";\n\t\t\t\t\tcol1.align=\"left\";\n\t\t\t\t\tvar str = \"\";\n\t\t\t\t\tstr = \"<a href=\\\"javascript:pickupContent(\'\" + dataObj.linenItem + \"\')\\\">\";\n\t\t\t\t\tstr += dataObj.linenItemDesc + \"</a><input type=\'hidden\' name=\'vo.linenRequest[\" + (index) + \"].linenItem\' id=\'vo.linenRequest[\" + (index) + \"].linenItem\' value=\'\" + dataObj.linenItem + \"\'>\" ;\n\t\t\t\t\tcol1.innerHTML = str;\n\t\t\t\t\tvar col3 = row.insertCell();\n\t\t\t\t\tcol3.className = \"QRYEVEN\";\n\t\t\t\t\tcol3.width=\"30%\";\n\t\t\t\t\tcol3.align=\"right\";\n\t\t\t\t\tcol3.innerHTML = dataObj.qty + \"<input type=\'hidden\' name=\'vo.linenRequest[\" + (index) + \"].returnedQty\' id=\'vo.linenRequest[\" + (index) + \"].returnedQty\' value=\'\" + dataObj.qty + \"\'>\";\n\t\t\t\t\tvar col4 = row.insertCell();\n\t\t\t\t\tcol4.className = \"QRYEVEN\";\n\t\t\t\t\tcol4.width=\"30%\";\n\t\t\t\t\tcol4.align=\"left\";\n\t\t\t\t\tvar str1=\'<a href=\"\" id=\"prepAnchor\'+index+\'\" name=\"prepAnchor\'+index+\'\" onclick=\"test5popupactivate1(this.id,\'+index+\');return false;\">\';\n\t\t\t\t\tstr1+=\"Remark</a><input type=\'hidden\' size=20 name=\'vo.linenRequest[\" + (index) + \"].remark\' id=\'vo.linenRequest[\" + (index) + \"].remark\' value=\'\" + dataObj.remark + \"\'>\" ;\n\t\t\t\t\tcol4.innerHTML =str1;\n\t\n\t\t\t\t} else {\n\t\t\t\t\tvar str = \"<input type=\'hidden\' name=\'vo.linenRequest[\" + index + \"].linenItem\' id=\'vo.linenRequest[\" + index + \"].linenItem\' value=\'\" + dataObj.linenItem + \"\'>\" + \"<input type=\'hidden\' name=\'vo.linenRequest[\" + (index) + \"].returnedQty\' id=\'vo.linenRequest[\" + (index) + \"].returnedQty\' value=\'\" + dataObj.qty + \"\'>\" + \"<input type=\'hidden\' name=\'vo.linenRequest[\" + (index) + \"].remark\' id=\'vo.linenRequest[\" + (index) + \"].remark\' value=\'\" + dataObj.remark + \"\'>\";\n\t\t\t\t\tdocument.getElementById(\"listContentLayer\").innerHTML += str;\n\t\t\t\t}\n\t\t\t\tindex++;\n\t\t\t}\n\t\t}\n\t}\n\t\n// **********************************************************************************************\n\n\tfunction pickupContent(linenItem) {\n\t\t\n\t\tvar dataObj = contentList.get(linenItem);\n\t\tdocument.getElementById(\"linenItem\").value =dataObj.linenItem;\n\t\tdocument.getElementById(\"qty\").value = dataObj.qty;\n\t\tdocument.getElementById(\"remark\").value = dataObj.remark;\n\t\tdocument.getElementById(\"linenItemDesc\").value = dataObj.linenItemDesc;\n\t\tdataObj.flag=\"createMethod\"\n\t\tshowRecords()\n\t\trequired_Duplicate_Check = 1;\n\t}\n\t\n// *******************************************************************************************************\nfunction cancelRecord(){\n\t\t\tvar linenItem=document.getElementById(\"linenItem\").value\n\t\t\n\t\t\tvar obj = contentList.get(linenItem)\n\t\t\tif(obj !=null){\n\t\t\t\tif(obj.flag != \"createMethod\"){\n\t\t\t\t\tobj.flag=\"deleteMethod\"\n\t\t\t\t\t contentList.put(linenItem,obj)\n\t\t\t\t}else{\n\t\t\t\t\tcontentList.remove(linenItem)\n\t\t\t\t\trequired_Duplicate_Check = 0;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\tshowRecords();\n\t\t}\t\n\n\n// ************************  CHECK AVAILABLE STOCK BEFORE SELECT *************************\n\t\t\t\n\tfunction checkQty(avail){\n\t\t\n\t\tvar qty = document.getElementById(\"qty\").value;\t\n\t\tif(avail == \'0\'){\n\t\t}if(qty > 0 && qty <= avail){\n\t\t\t\t\n\t\t\t\tpopulateList();\n\t\t\t}\t\t\n\t\t}\n\tfunction cleardata(obj)\n\t{\n\t\tif(obj.value==\"\")\n\t\t{\n\t\t\t document.getElementById(\"vo.sourceCode\").value=\"\";\t\n\t\t\t// alert(document.getElementById(\"vo.sourceCode\").value)\n\t\t}\n\t}\nfunction settime()\n{\n window.setTimeout(AlertMsg,1000);\t\n}\nfunction AlertMsg()\n{\n\tvar obj=document.getElementById(\"vo.referenceNum\");\n\tvar tableObj = document.getElementById(\"contentTable\");\n\tvar len = tableObj.rows.length;\n\tvar flag=checkNullLocal();\n\tif(flag==true)\n\t\t{\n\t\t\t\tif(parseInt(len)>0)\n\t\t\t\t{getServerMessage(\"com.iba.ehis.lc.pnyrequestNum\");\n\t\t\t\t alert(dwrMessage+\" \"+\":\"+obj.value);\t\n\t\t\t\t apply1();\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tgetServerMessage(\"com.iba.ehis.lc.atleastselectthelinenitem\");\n\t\t\t\t\talert(dwrMessage);}\n\t\t\t\t\n\t\t}\n}\nfunction convertSDate2En()\n{\n   var languageId= document.getElementById(\"languageId\").value;\n  var tdate=document.getElementById(\"requestDate\");\n  IBADateValidator.convertDateJS(tdate.value,languageId,\"en\",\'dd/MM/yyyy HH:mm\',RDTocallbackMethod9);\n  function  RDTocallbackMethod9(ldate){\n\n\t  document.getElementById(\"vo.requestDate\").value=ldate;\n\t\n\t} \n  \n}\n//============== check for numeric values  ==========\n function checkNumber1(val){\n\t\t  obj =  String.fromCharCode(window.event.keyCode);\n\t\tvar alphaFilter =/^[0-9]+$/;\n\t\tif (!(alphaFilter.test(obj))) {\n\t\tgetServerMessage(\"message.Numbers.Allowed\");\n\t\tparent.parent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+dwrMessage;\n\t\twindow.event.keyCode = 27;\n\t\tval.value=\"\";\n\t\t}\n\t\t\t \n\t}\t\n</script>\n<body OnLoad=\"CurrDate();getReferenceNumber();\" OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<table border=\'0 \' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" CLASS=\'label\'>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=text name=\"sourceType\" id=\"sourceType\" maxlength=\"10\" readonly=\"true\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"/>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input type=\'text\' name=\"returnSourceDesc\" id=\"returnSourceDesc\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" readonly />\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t<td></td>\n\t\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' >\n\t\t\t\t\t ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- <td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t\t</td> -->\n\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t\t<input type=text name=\"requestDate\" id=\"requestDate\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" size=\"18\" readonly=\"true\" onkeydown=\"assignDate(this,false);\" onkeypress=\"assignDate(this,false);\" /><a onclick=\"return showCal(\'requestDate\', \'%d/%m/%Y %H:%M\', true, true,\'cutOffTimeForLinenRecptid\');\" name=\'.cutOffTimeForLinenRecptid\' id=\'cutOffTimeForLinenRecptid\'><img src=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/framework/images/img.gif\"></a><input type=\'hidden\' name=\'vo.requestDate.pattern\' id=\'vo.requestDate.pattern\' value=\'dd/MM/yyyy HH:mm\'>\n\t\t\t\t\t\t<img src=\'framework/images/mandatory.gif\'></img>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr >\n\t\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t</td>\n\t\t\t</tr>\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n<br>\n\t <table align=\"center\" border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t</td>\n\t\t\t<td nowrap class=\'button\' >\n\t\t\t\t<input type=\"text\" name=\"linenItemDesc\" id=\"linenItemDesc\" onblur=\'showLookupLinenItem()\' />\t\t\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"linenItem\" id=\"linenItem\"  />\n\t\t\t\t<input type=\'button\' class=\"BUTTON\"  value=\'?\' onclick=\'linenItemLookup()\' />\n\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\'>\n\t\t\t\t<input type=\"text\" name=\"qty\" id=\"qty\" maxlength=\"8\" size=\"8\" onkeypress=\"checkNumber1(this);\"onblur=\"getAvailbleQty();\"/>\n\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t<a href=\"javascript:#\" onclick=\"test5popupactivate(this.id);return false;\" name=\"prepAnchor\" id=\"prepAnchor\">\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a>\n\t\t\t\t<input type=\"hidden\" name=\"remarkArea\" id=\"remarkArea\" value=\"\" maxlength=\"100\"/>\n\t\t\t\t<input type=\"hidden\" name=\"remark\" id=\"remark\" value=\"\" maxlength=\"100\"/>\n\t\t\t</td>\n\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t<td colspan=\"4\" align=\'right\'>\n\t\t\t\t<input class=\"BUTTON\" type=\"button\" name=\"select\" id=\"select\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onClick=\"checkNullLocal();getAvailbleQty1()\" onmouseover=\"convertSDate2En()\"/>\n\t\t\t\t<input class=\"BUTTON\" type=\"button\" name=\"cancel\" id=\"cancel\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" onClick=\"cancelRecord()\" />\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n<br>\n\t  <table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' id=\"tableid\" align=\'center\' >\n\t\t <tr>\n\t\t\t<td  colspan=3>\n\t\t\t\t<b>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</b>\n\t\t\t</td>\n\t\t </tr>\n\t\t <tr>\n\t\t\t<th align=\"center\" width=\"30%\">\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t</th>\n\t\t\t<th align=\"center\" width=\"30%\">\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</th>\n\t\t</tr>\n\t</table>\n\t\t<div id=\"listContentLayer\" align=\"center\">\n\t\t\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' id=\"contentTable\"/>\n\t\t</div>\n\t\t<input type=\"hidden\" name=\"vo.operatingFacilityId\" id=\"vo.operatingFacilityId\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" />\t\t\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<input type=\"hidden\" name=\"languageId\" id=\"languageId\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t\t<input type=\"hidden\" name=\"vo.locale\" id=\"vo.locale\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<table align=\"center\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" name=\"Submit\" class=\"BUTTON\" onclick=\"getReferenceNumber();settime()\" />\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n</body>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

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
		String functionId = (String) session.getAttribute("functionId");
		String moduleId = (String) session.getAttribute("moduleId");
		String addedById = (String) session.getAttribute("login_user");
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
		
		if (sStyle == null)
		sStyle = "IeStyle.css";
		String qryEven = "QRYEVEN";
		String qryOdd = "QRYODD";

		UserPreferences userPrefs =new UserPreferences();
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
			String datepattrn=userPrefs.getDateFormat();
			String sb=userPrefs.getDateFormat();
			String tf=userPrefs.getTimeFormat();
			String pattern=sb+" "+tf;
			//String locale=userPrefs.getLocale();
		
			IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
			IBADateValidation ibadateVal = new IBADateValidation();
			String conDate = (String)ibadateVal.convertDateJS(todate.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		//	out.println("conDate="+conDate);

		SourceBean obj=new SourceBean();
		try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */
									
		}catch(Exception e){} 
	
	//AMRI-SCF-0679
	String srcType = (String) session.getAttribute("sourceType");
	String srctype = (String) session.getAttribute("sourcetype");
	String src = (String) session.getAttribute("source");
	String srcCode = (String) session.getAttribute("sourceCode");
	//AMRI-SCF-0679
		/* String src=obj.getSource();
		String srcType=obj.getSourceType(); */
		request.setAttribute("srcType",srcType);
		request.setAttribute("src",src);
		//request.setAttribute("userFlag",userFlag);
		/* String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode(); */
	
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

                    if (_jsp__tag1(request, response, pageContext, _activeTag, __tag0))
                     return;
                    _bw.write(_wl_block29Bytes, _wl_block29);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block30Bytes, _wl_block30);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block31Bytes, _wl_block31);
                     org.apache.struts.taglib.html.FormTag __tag2 = null ;
                    int __result__tag2 = 0 ;

                    if (__tag2 == null ){
                        __tag2 = new  org.apache.struts.taglib.html.FormTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
                    }
                    __tag2.setPageContext(pageContext);
                    __tag2.setParent(__tag0);
                    __tag2.setAction(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("/ReturnofLinentoLaundryAction.do", java.lang.String .class,"action"));
                    __tag2.setTarget(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("messageFrame", java.lang.String .class,"target"));
                    _activeTag=__tag2;
                    __result__tag2 = __tag2.doStartTag();

                    if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.html.FormTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block32Bytes, _wl_block32);

                            if (_jsp__tag3(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block33Bytes, _wl_block33);
                            out.print( String.valueOf(srcType));
                            _bw.write(_wl_block34Bytes, _wl_block34);
                             org.apache.struts.taglib.html.HiddenTag __tag4 = null ;
                            int __result__tag4 = 0 ;

                            if (__tag4 == null ){
                                __tag4 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
                            }
                            __tag4.setPageContext(pageContext);
                            __tag4.setParent(__tag2);
                            __tag4.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.sourceType", java.lang.String .class,"property"));
                            __tag4.setValue(srctype
);
                            _activeTag=__tag4;
                            __result__tag4 = __tag4.doStartTag();

                            if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag4);
                                return;
                            }
                            _activeTag=__tag4.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
                            __tag4.release();
                            _bw.write(_wl_block35Bytes, _wl_block35);

                            if (_jsp__tag5(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block36Bytes, _wl_block36);
                            out.print( String.valueOf(src));
                            _bw.write(_wl_block37Bytes, _wl_block37);
                             org.apache.struts.taglib.html.HiddenTag __tag6 = null ;
                            int __result__tag6 = 0 ;

                            if (__tag6 == null ){
                                __tag6 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
                            }
                            __tag6.setPageContext(pageContext);
                            __tag6.setParent(__tag2);
                            __tag6.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.sourceCode", java.lang.String .class,"property"));
                            __tag6.setValue(srcCode
);
                            _activeTag=__tag6;
                            __result__tag6 = __tag6.doStartTag();

                            if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag6);
                                return;
                            }
                            _activeTag=__tag6.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
                            __tag6.release();
                            _bw.write(_wl_block38Bytes, _wl_block38);

                            if (_jsp__tag7(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block39Bytes, _wl_block39);

                            if (_jsp__tag8(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block40Bytes, _wl_block40);

                            if (_jsp__tag9(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block41Bytes, _wl_block41);

                            if (_jsp__tag10(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block42Bytes, _wl_block42);
                            out.print( String.valueOf(conDate));
                            _bw.write(_wl_block43Bytes, _wl_block43);
                            out.print( String.valueOf(request.getContextPath()));
                            _bw.write(_wl_block44Bytes, _wl_block44);
                             org.apache.struts.taglib.html.HiddenTag __tag11 = null ;
                            int __result__tag11 = 0 ;

                            if (__tag11 == null ){
                                __tag11 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
                            }
                            __tag11.setPageContext(pageContext);
                            __tag11.setParent(__tag2);
                            __tag11.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.requestDate", java.lang.String .class,"property"));
                            __tag11.setValue(todate.toString()
);
                            _activeTag=__tag11;
                            __result__tag11 = __tag11.doStartTag();

                            if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag11);
                                return;
                            }
                            _activeTag=__tag11.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
                            __tag11.release();
                            _bw.write(_wl_block45Bytes, _wl_block45);

                            if (_jsp__tag12(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block46Bytes, _wl_block46);
                             org.apache.struts.taglib.html.TextTag __tag13 = null ;
                            int __result__tag13 = 0 ;

                            if (__tag13 == null ){
                                __tag13 = new  org.apache.struts.taglib.html.TextTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
                            }
                            __tag13.setPageContext(pageContext);
                            __tag13.setParent(__tag2);
                            __tag13.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.returnedBy", java.lang.String .class,"property"));
                            __tag13.setValue(addedById
);
                            __tag13.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
                            __tag13.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
                            __tag13.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
                            _activeTag=__tag13;
                            __result__tag13 = __tag13.doStartTag();

                            if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag13);
                                return;
                            }
                            _activeTag=__tag13.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
                            __tag13.release();
                            _bw.write(_wl_block47Bytes, _wl_block47);

                            if (_jsp__tag14(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block48Bytes, _wl_block48);

                            if (_jsp__tag15(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block49Bytes, _wl_block49);

                            if (_jsp__tag16(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block50Bytes, _wl_block50);

                            if (_jsp__tag17(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block51Bytes, _wl_block51);

                            if (_jsp__tag18(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block52Bytes, _wl_block52);

                            if (_jsp__tag19(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block53Bytes, _wl_block53);

                            if (_jsp__tag20(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block54Bytes, _wl_block54);

                            if (_jsp__tag21(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block55Bytes, _wl_block55);

                            if (_jsp__tag22(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block56Bytes, _wl_block56);

                            if (_jsp__tag23(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block56Bytes, _wl_block56);

                            if (_jsp__tag24(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block57Bytes, _wl_block57);
                            out.print( String.valueOf(facilityId));
                            _bw.write(_wl_block58Bytes, _wl_block58);
                             org.apache.struts.taglib.html.HiddenTag __tag25 = null ;
                            int __result__tag25 = 0 ;

                            if (__tag25 == null ){
                                __tag25 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
                            }
                            __tag25.setPageContext(pageContext);
                            __tag25.setParent(__tag2);
                            __tag25.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.functionId", java.lang.String .class,"property"));
                            __tag25.setValue(functionId
);
                            _activeTag=__tag25;
                            __result__tag25 = __tag25.doStartTag();

                            if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag25);
                                return;
                            }
                            _activeTag=__tag25.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
                            __tag25.release();
                            _bw.write(_wl_block59Bytes, _wl_block59);
                             org.apache.struts.taglib.html.HiddenTag __tag26 = null ;
                            int __result__tag26 = 0 ;

                            if (__tag26 == null ){
                                __tag26 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
                            }
                            __tag26.setPageContext(pageContext);
                            __tag26.setParent(__tag2);
                            __tag26.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.moduleId", java.lang.String .class,"property"));
                            __tag26.setValue(moduleId
);
                            _activeTag=__tag26;
                            __result__tag26 = __tag26.doStartTag();

                            if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag26);
                                return;
                            }
                            _activeTag=__tag26.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
                            __tag26.release();
                            _bw.write(_wl_block60Bytes, _wl_block60);
                            out.print( String.valueOf(locale));
                            _bw.write(_wl_block61Bytes, _wl_block61);
                            out.print( String.valueOf(locale));
                            _bw.write(_wl_block62Bytes, _wl_block62);

                            if (_jsp__tag27(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block63Bytes, _wl_block63);

                            if (_jsp__tag28(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block64Bytes, _wl_block64);
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
                    _bw.write(_wl_block65Bytes, _wl_block65);
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
            _bw.write(_wl_block66Bytes, _wl_block66);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.standardStock.sourceType", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.source", java.lang.String .class,"key"));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(parent);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.ref.Num", java.lang.String .class,"key"));
        __tag7.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(parent);
        __tag8.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.referenceNum", java.lang.String .class,"property"));
        __tag8.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("10", java.lang.String .class,"maxlength"));
        __tag8.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("10", java.lang.String .class,"size"));
        __tag8.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.date", java.lang.String .class,"key"));
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

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         com.iba.framework.core.pojo.web.taglib.DateTimeInput __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  com.iba.framework.core.pojo.web.taglib.DateTimeInput ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(parent);
        __tag10.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.requestDate", java.lang.String .class,"property"));
        __tag10.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
        __tag10.setFormat(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("%d/%m/%Y %H:%M", java.lang.String .class,"format"));
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

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(parent);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.returnedby", java.lang.String .class,"key"));
        __tag12.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(parent);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.receivedby", java.lang.String .class,"key"));
        __tag14.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(parent);
        __tag15.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receivedBy", java.lang.String .class,"property"));
        __tag15.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
        __tag15.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
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

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(parent);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
        __tag16.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.returnedQuantity", java.lang.String .class,"key"));
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
         org.apache.struts.taglib.bean.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(parent);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.remark", java.lang.String .class,"key"));
        __tag18.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.selectforbutton", java.lang.String .class,"key"));
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
         org.apache.struts.taglib.bean.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(parent);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.cancel", java.lang.String .class,"key"));
        __tag20.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItemDetail", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
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
         org.apache.struts.taglib.bean.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(parent);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.returnedQty", java.lang.String .class,"key"));
        __tag23.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
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

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(parent);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.remark", java.lang.String .class,"key"));
        __tag24.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
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

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(parent);
        __tag27.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.mode", java.lang.String .class,"property"));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.submit", java.lang.String .class,"key"));
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
}
