package jsp_servlet._elc._issuelinenaftermending._jsp;

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
import com.iba.ehis.core.vo.AppVO;
import java.util.Date;
import com.iba.framework.core.util.Constants;

public final class __issueoflinenaftermendingcud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/IssueLinenAfterMending/jsp/IssueOfLinenAfterMendingCUD.jsp", 1709118351573L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block14 ="\' />\n\t<script src=\"";
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

    private final static java.lang.String  _wl_block23 ="/dwrlc/interface/RequestForCleaning.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/dwrlc/interface/LinenIssue.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/framework/js/Ajax_DWR.js\'></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/framework/js/validations.js\"></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/framework/js/common.js\"></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/dwrlc/interface/MendingReceipt.js\'></script>\n\t<script type=\"text/javascript\" src=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/eLC/IssueLinenAfterMending/js/IssueLinenAfterMending.js\'></script>\n\t<script language=\"JavaScript\" src=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="/framework/js/PopupWindow.js\"></script>\n\n<script type=\"text/javascript\">\nvar contentList =new Hashtable();\n\n//============================================================\nvar issuedQty=0;\nvar requestedQty=0;\nfunction sumQty()\n{\nvar facilityId=document.getElementById(\"vo.issueOfLinenVO.operatingFacilityId\").value;\nvar requestNo=document.getElementById(\"vo.issueOfLinenVO.requestNum\").value;\nvar linenItem=document.getElementById(\"vo.issueOfLinenVO.linenItem\").value;\n\nfacilityId=trimString(facilityId);\nrequestNo=trimString(requestNo);\nlinenItem=trimString(linenItem);\n\nMendingReceipt.getSumIssuedQty(\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\",requestNo,setIssueQty);\n}\nfunction setIssueQty(data)\n{\n for(prop in data)\n {\n\t\t\n\tif(prop!=null)\n\t{\n\t\tissuedQty=data[prop]\n\t}\n }\nvar facilityId=document.getElementById(\"vo.issueOfLinenVO.operatingFacilityId\").value;\nvar requestNo=document.getElementById(\"vo.issueOfLinenVO.requestNum\").value;\nfacilityId=trimString(facilityId);\nrequestNo=trimString(requestNo);\nMendingReceipt.getSumReceivedQty(\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\",requestNo,setRequestQty);\n\n}\nfunction setRequestQty(data)\n{\n for(prop in data)\n {\n\tif(prop!=null)\n\t{\n\t requestedQty=data[prop]\n\t}\n }\n var facilityId=document.getElementById(\"vo.issueOfLinenVO.operatingFacilityId\").value;\nvar requestNo=document.getElementById(\"vo.issueOfLinenVO.requestNum\").value;\nvar linenItem=document.getElementById(\"vo.issueOfLinenVO.linenItem\").value;\n\nfacilityId=trimString(facilityId);\n\nrequestNo=trimString(requestNo);\n\nlinenItem=trimString(linenItem);\n\nMendingReceipt.getReceivedQty(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",requestNo,linenItem,setReceivedQty);\n\n}\nfunction setReceivedQty(data1)\n{\nfor(prop in data1)\n {\n\n\tdocument.getElementById(\"iqty\").value=data1[prop];\n\t}\n \n}\nfunction setStatus()\n{\n\nrequestedQty=parseInt(requestedQty)+parseInt(document.getElementById(\"ciqty\").value)\n\t\nif(parseInt(requestedQty)==parseInt(issuedQty))\n\t{document.getElementById(\"vo.issueOfLinenVO.requestStatus\").value=\"RE\";}\nelse if(parseInt(requestedQty)<parseInt(issuedQty))\n\t{document.getElementById(\"vo.issueOfLinenVO.requestStatus\").value=\"PR\";}\nelse{document.getElementById(\"vo.issueOfLinenVO.requestStatus\").value=\"OS\";}\n//alert(document.getElementById(\"vo.issueOfLinenVO.requestStatus\").value)\n}\n\n//============================================================\nvar  testpopup5=\"\";\nvar testpopup4=\"\";\nvar val=\"\";\n\nfunction setval()\n{\nval=document.getElementById(\"remarkArea\").value;\ndocument.getElementById(\"remark\").value=val;\n}\nfunction test5popupactivate(anchor) {\nif(testpopup5==\"\")\n{\n testpopup5 = new PopupWindow();\n}\nval=document.getElementById(\"remark\").value;\ndocument.getElementById(\"remarkArea\").value=val;\ntestpopup5.height=200;\ntestpopup5.width=300;\ntestpopup5.offsetX=-10;\ntestpopup5.offsetY=10;\ntestpopup5.autoHide();\ngetServerMessage(\"com.iba.ehis.lc.writeOffLinen.remarks\");\nvar label = dwrMessage;\ngetServerMessage(\"com.iba.ehis.lc.ok\");\nvar buttonlabel = dwrMessage;\ntestpopup5.populate(\'<title>Remarks..</title><link rel=\"stylesheet\" type=\"text/css\" href=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></link><FORM><table border=\"0\" celpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><td class=\"label\" align=\"left\"> Remark: </td></tr><tr><td  align=\"center\"><textarea rows=10 cols=40 maxlength=2000 name=\"remarkArea\" onkeyup=\"window.opener.document.getElementById(\"remarkArea\").value=this.value;window.opener.setval()\">\'+val+\'</textarea></td></tr><tr><td  align=\"center\"><input class=\"button\" type=\"button\" onclick=\"window.close();window.opener.setval()\" value=\"\'+buttonlabel+\'\"/></td></tr></table> </FORM>\');\ntestpopup5.showPopup(anchor);\nsetval();\n}\n\nfunction test5popupactivate1(anchor,index) {\nvar val=document.getElementById(\"vo.issueOfLinenVO.linenIssueList[\"+index+\"].remark\").value;\ntestpopup4 = new PopupWindow();\ntestpopup4.windowProperties=\"toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no\";\ntestpopup4.height=200;\ntestpopup4.width=300;\ntestpopup4.offsetX=-10;\ntestpopup4.offsetY=10;\ntestpopup4.autoHide();\ngetServerMessage(\"com.iba.ehis.lc.ok\");\nvar buttonlabel = dwrMessage;\ntestpopup4.populate(\'<title>Remark..</title><link rel=\"stylesheet\" type=\"text/css\" href=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"></link><FORM><table border=\"0\" celpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><td class=\"label\" align=\"left\"> Remark: </td></tr><tr><td  align=\"center\"><textarea rows=10 cols=40 readonly=true name=\"remarkArea\">\'+val+\'</textarea></td></tr><tr><td  align=\"center\"><input class=\"button\" type=\"button\" onclick=\"window.close();\" value=\"\'+buttonlabel+\'\"/></td></tr></table> </FORM>\');\ntestpopup4.showPopup(anchor);\n}\n //========= set issuedQty==========\n function issueNo()\n{\nvar facilityId=document.getElementById(\"vo.issueOfLinenVO.operatingFacilityId\").value;\nvar requestNo=document.getElementById(\"vo.issueOfLinenVO.requestNum\").value;\nMendingReceipt.getIssueNo(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',requestNo,setIssueNo);\n}\nfunction setIssueNo(data)\n{\nvar max=0;\n for(prop in data)\n {\n\tif(prop!=null)\n\t{\n\tif(parseInt(prop)>parseInt(max))\n\t\t\tmax=parseInt(prop);\n\t}\n }\nmax=parseInt(max)+1;\ndocument.getElementById(\"vo.issueOfLinenVO.receiptNum\").value=max;\n}\n\n//========= apply===============\nfunction apply() {\n\tvar flag=checkNull();\n\tif(flag==true)\n\t{\n\t \tsettime();\n\t}\n}\n\n//================checkNull===========\nfunction checkNull() {\n\tvar flag;\n \tvar error=\"\";\n \tvar fieldName = new Array(\"com.iba.ehis.lc.requestForLinen.requestNum\", \"com.iba.ehis.lc.requestForLinen.requestDate\", \"com.iba.ehis.lc.requestForLinen.raisedBy\",\"com.iba.ehis.lc.returnoflinentolaundry.receivedby\",\"com.iba.ehis.lc.issueDate\");\n\tvar fields = new Array(document.getElementById(\"vo.issueOfLinenVO.requestNum\").value, document.getElementById(\"vo.issueOfLinenVO.requestDate\").value, document.getElementById(\"vo.issueOfLinenVO.sentBy\").value,document.getElementById(\"vo.issueOfLinenVO.issueBy\").value,document.getElementById(\"vo.issueOfLinenVO.issueDate\").value);\n\tvar key_value=new Array();\n\n \tfor(j=0;j<fieldName.length;j++)\n \t{\n \t\tif(fields[j]==\"\")\n\t\t{\t\n\t \t\tgetServerMessage(fieldName[j]);\n\t \t\tkey_value[j]=dwrMessage;\n\t\t\tgetServerMessage(\"APP-LC0004\");\n\t\t\tmsg=dwrMessage;\n\t \t\tmsgArray=msg.split(\'#\');\n\t \t\terror=error +msgArray[0]+ key_value[j] + \" \" + msgArray[1] +\"<br>\";\n\t \t\tflag=false;\n \t\t}\n\n \t}\n\tparent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+error;\n\tif(flag==false) return false; else return true;\n}\nfunction settime()\n{\n window.setTimeout(AlertMsg,1000);\t\n}\nfunction AlertMsg()\n{\n\tvar obj=document.getElementById(\"vo.issueOfLinenVO.receiptNum\");\n\tgetServerMessage(\"com.iba.ehis.lc.pnyrequestNum\");\n\talert(dwrMessage+\" \"+\" : \"+obj.value);\n\tdocument.forms[0].submit();\n}\n//=====================================================\n\n//=============================================\nfunction checkQty()\n{\nvar qty=document.getElementById(\"qty\").value;\nvar iqty=document.getElementById(\"iqty\").value;\nif(iqty==\"\")iqty=0;\nvar ciqty=document.getElementById(\"ciqty\").value;\nif(ciqty==\"\")ciqty=0;\nvar error=\"\";\nvar flag=\"\";\nvar val=parseInt(iqty)+parseInt(ciqty);\n\tif(parseInt(val)>parseInt(qty))\n\t{\n\t\t\tgetServerMessage(\"com.iba.ehis.lc.requestForLinen.requestedQuantity\");\n\t \t\tkey_value=dwrMessage;\n\t\t\tgetServerMessage(\"messege.number.greatethan\");\n\t\t\tmsg=dwrMessage;\n\t \t\tmsgArray=msg.split(\'#\');\n\t \t\tgetServerMessage(\"com.iba.ehis.lc.requestForLinen.issuedQuantity\");\n\t \t\tfield1=dwrMessage;\n\t \t\tgetServerMessage(\"com.iba.ehis.lc.issueOfLinen.currentIssueQuantity\");\n\t \t\tfield2=dwrMessage;\n\t \t\terror=error +msgArray[0]+ key_value + \" \" + msgArray[1] +\" (\"+field1+\"  \"+field2+\")\";\n\t \t\tflag=false;\n\t\t\tdocument.getElementById(\"ciqty\").value=0;val=iqty;\n\t\t\tdocument.getElementById(\"ciqty\").selected=true;\n \t\t}\n\t\telse\n\t{\n\tflag=true;\n\tsetStatus();\n\t}\n \t\n\tparent.messageFrame.location.href =contextPath+\'/core/jsp/MessageFrame.jsp?error=\'+error;\n\tif(flag==false) return false; else return true;\n}\n\n//==========================================\nfunction addListRec()\n{\nvar rno=document.getElementById(\"vo.issueOfLinenVO.requestNum\").value;\nvar litem=document.getElementById(\"vo.issueOfLinenVO.linenItem\").value;\nvar facilityId=document.getElementById(\"vo.issueOfLinenVO.operatingFacilityId\").value;\nMendingReceipt.getIssueDetail(litem,rno,facilityId,setIssueData);\n}\n\nfunction LinenViewVo(linenItem,linenDesc,qty,iqty,ciqty,remark, flag) {\n\tthis.linenItem = linenItem;\n\tthis.linenDesc = linenDesc;\n\tthis.qty = qty;\n\tthis.iqty = iqty;\n\tthis.ciqty = ciqty;\n\tthis.remark = remark;\n\tif (flag == null) {\n\t\tflag = \"createMethod\";\n\t}\n\tthis.flag = flag;\n}\n\nfunction populateList() {\n\t\tvar flag=checkQty();\n\t\tif(flag==true)\n\t\t{\n\t\tvar linenItem=document.getElementById(\"linenItem\").value;\n\t\tif(linenItem!=\"\"){\n\t\tif(contentList.get(linenItem) ==null){\n\t\t\tvar IssuedQty=document.getElementById(\"iqty\").value;\n\t\t\tif(IssuedQty==\"\")IssuedQty=0;\n\t\t\tvar CurrentIssuedQty=document.getElementById(\"ciqty\").value;\n\t\t\tif(CurrentIssuedQty==\"\")CurrentIssuedQty=0;\n\t\t\tviewObj = new LinenViewVo(linenItem,document.getElementById(\"vo.issueOfLinenVO.linenDesc\").value,document.getElementById(\"qty\").value,IssuedQty,CurrentIssuedQty,document.getElementById(\"remark\").value)\n\t\t\tcontentList.put(linenItem,viewObj)\n\t\t\n\t\t\t}else{\n\t\t\t\t\tvar obj = contentList.get(linenItem)\n\t\t\t\t\tif(obj.flag != \"createMethod\"){\n\t\t\t\t\tobj.linenDesc = document.getElementById(\"vo.issueOfLinenVO.linenDesc\").value\n\t\t\t\t\tobj.qty = document.getElementById(\"qty\").value\n\t\t\t\t\tobj.iqty = document.getElementById(\"iqty\").value\n\t\t\t\t\tobj.ciqty = document.getElementById(\"ciqty\").value\n\t\t\t\t\tobj.remark = document.getElementById(\"remark\").value\n\t\t\t\t\tobj.flag= updateMethod;\n\t\t\t\t\tcontentList.put(linenItem,obj);\n\t\t\t\t}\n\t\t\t}\n\t\t\tshowRecords();\n\t\t\tdocument.getElementById(\"linenItem\").value=\"\";\n\t\t\tdocument.getElementById(\"vo.issueOfLinenVO.linenDesc\").value=\"\";\n\t\t\tdocument.getElementById(\"qty\").value=\"\";\n\t\t\tdocument.getElementById(\"iqty\").value=\"\";\n\t\t\tdocument.getElementById(\"ciqty\").value=\"\";\n\t\t\tdocument.getElementById(\"remark\").value=\"\";\n\t\t}\t\n\t}\n}\nfunction deleteRows() {\n\tvar tableObj = document.getElementById(\"contentTable\");\n\tvar len = tableObj.rows.length;\n\tfor (i = len - 1; i != -1; i--) {\n\t\ttableObj.deleteRow(i);\n\t}\n}\nfunction showRecords() {\n\tvar htmlContent = \"\";\n\tvar tableObj = document.getElementById(\"contentTable\");\n\tdeleteRows();\n\tindex = 0;\n\tvar i=0;\n\tindex = parseInt(index);\n\tfor (  i in contentList.values()) {\n\t\tdataObj = contentList.values()[i];\n\t\tif (dataObj != null) {\n\t\t\ttableObj = document.getElementById(\"contentTable\");\n\t\t\tif (dataObj.flag != \"deleteMethod\") {\n\t\t\t\tvar row = tableObj.insertRow(tableObj.rows.length);\n\t\t\t\tvar col1 = row.insertCell();\n\t\t\t\tcol1.className = \"QRYEVEN\";\n\t\t\t\tcol1.width=\"20%\";\n\t\t\t\tcol1.align=\"left\";\n\t\t\t\tvar str = \"\";\n\t\t\t\tstr = \"<a href=\\\"javascript:pickupContent(\'\" + dataObj.linenItem + \"\')\\\">\";\n\t\t\t\tstr += dataObj.linenDesc + \"</a><input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].linenItem\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].linenItem\' value=\'\" + dataObj.linenItem + \"\'>\";\n\t\t\t\tcol1.innerHTML = str;\n\t\t\t\tvar col2 = row.insertCell();\n\t\t\t\tcol2.className = \"QRYEVEN\";\n\t\t\t\tcol2.width=\"20%\";\n\t\t\t\tcol2.align=\"right\";\n\t\t\t\tcol2.innerHTML = dataObj.qty + \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].requestedQty\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].requestedQty\' value=\'\" + dataObj.qty + \"\'>\";\n\t\t\t\tvar col3 = row.insertCell();\n\t\t\t\tcol3.className = \"QRYEVEN\";\n\t\t\t\tcol3.width=\"20%\";\n\t\t\t\tcol3.align=\"right\";\n\t\t\t\tcol3.innerHTML = dataObj.iqty + \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].issueQty\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].issueQty\' value=\'\" + dataObj.iqty + \"\'>\";\n\t\t\t\tvar col4 = row.insertCell();\n\t\t\t\tcol4.className = \"QRYEVEN\";\n\t\t\t\tcol4.width=\"20%\";\n\t\t\t\tcol4.align=\"right\";\n\t\t\t\tcol4.innerHTML = dataObj.ciqty + \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].currentIssueQty\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].currentIssueQty\' value=\'\" + dataObj.ciqty + \"\'>\";\n\t\t\t\tvar col5 = row.insertCell();\n\t\t\t\tcol5.className = \"QRYEVEN\";\n\t\t\t\tcol5.width=\"20%\";\n\t\t\t\tcol5.align=\"left\";\n\t\t\t\t\n\t\t\t\tvar str1=\'<a href=\"\" id=\"prepAnchor\'+index+\'\" name=\"prepAnchor\'+index+\'\" onclick=\"test5popupactivate1(this.id,\'+index+\');return false;\">\';\n\t\t\t\tstr1+=\"Remark</a><input type=\'hidden\' size=20 name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].remark\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].remark\' value=\'\" + dataObj.remark + \"\'>\" ;\n\t\t\t\tcol5.innerHTML =str1;\n\t\t\t\t\n\t\t\t} else {\n\t\t\t\tvar str = \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + index + \"].linenItem\' id=\'vo.issueOfLinenVO.linenIssueList[\" + index + \"].linenItem\' value=\'\" + dataObj.linenItem + \"\'>\" + \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].requestedQty\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].requestedQty\' value=\'\" + dataObj.qty + \"\'>\" + \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].issueQty\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].issueQty\' value=\'\" + dataObj.iqty + \"\'>\"+ \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].currentissueQty\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].currentissueQty\' value=\'\" + dataObj.ciqty + \"\'>\"+ \"<input type=\'hidden\' name=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].remark\' id=\'vo.issueOfLinenVO.linenIssueList[\" + (index) + \"].remark\' value=\'\" + dataObj.remark + \"\'>\";\n\t\t\t\tdocument.getElementById(\"listContentLayer\").innerHTML += str;\n\t\t\t}\n\t\t\tindex++;\n\t\t}\n\t}\n}\nfunction pickupContent(linenItem) {\n\tvar dataObj = contentList.get(linenItem);\n\tdocument.getElementById(\"linenItem\").value = linenItem;\n\tdocument.getElementById(\"vo.issueOfLinenVO.linenDesc\").value = dataObj.linenDesc;\n\tdocument.getElementById(\"qty\").value = dataObj.qty;\n\tdocument.getElementById(\"iqty\").value = dataObj.iqty;\n\tdocument.getElementById(\"ciqty\").value = dataObj.ciqty;\t\n\tdocument.getElementById(\"remark\").value = dataObj.remark;\n\t\n \t\t\tcontentList.remove(linenItem)\n \t\t\tshowRecords()\n}\nfunction cancelRecord(){\n\t\t\tvar linenItem=document.getElementById(\"linenItem\").value\n\t\t\n\t\t\tvar obj = contentList.get(linenItem)\n\t\t\tif(obj !=null){\n\t\t\t\tif(obj.flag != \"createMethod\"){\n\t\t\t\t\tobj.flag=deleteMethod\n\t\t\t\t\t contentList.put(linenItem,obj)\n\t\t\t\t}else{\n\t\t\t\t\tcontentList.remove(linenItem)\n\t\t\t\t}\n\t\t\t}\n\t\t\t\tshowRecords();\n}\n//=====================================================\nfunction getLoginUserPlaceLinen(){\n\t\tvar userId =\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\t\tRequestForCleaning.getLoggedInUser(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\",userId,callLoggedInUserPlaceLinen);\n\t}\nfunction callLoggedInUserPlaceLinen(data){\n\t\tvar user=\"\";\n\t\tfor(prop in data){user=prop;}\n\t\t\n\t\tdocument.getElementById(\"vo.issueOfLinenVO.sentBy\").value = trimString(user);\n\t\tdocument.getElementById(\"vo.issueOfLinenVO.issueBy\").value = trimString(user);\n\t}\n\n\t\n</script>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</head>\n\n<body onload=\"issueNo();\" OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<table border=\'0 \' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"hidden\" name=\"vo.issueOfLinenVO.receiptNum\" id=\"vo.issueOfLinenVO.receiptNum\" />\n\t\t\t\t <input type=\"text\" name=\"vo.issueOfLinenVO.requestNum\" id=\"vo.issueOfLinenVO.requestNum\" readonly=\"true\" />\n\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"vo.issueOfLinenVO.requestDate\" id=\"vo.issueOfLinenVO.requestDate\" readonly=\"true\" />\n\t\t\t\t<input type=\"hidden\" name=\"vo.issueOfLinenVO.requestDate.pattern\" id=\"vo.issueOfLinenVO.requestDate.pattern\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" />\n\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr >\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t</td>\n\t\t<td class=\'label\' colspan=3>\n\t\t<input type=\"text\" name=\"vo.issueOfLinenVO.sentBy\" id=\"vo.issueOfLinenVO.sentBy\" readonly=\"true\" />\n\t\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\' >\n\t\t\t\t <input type=\"text\" name=\"vo.issueOfLinenVO.issueBy\" id=\"vo.issueOfLinenVO.issueBy\" />\n\t\t\t\t\n\t\t\t <img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  nowrap=\"nowrap\" align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t  <input type=\"text\"   readonly=\"true\" name=\"vo.issueOfLinenVO.issueDate\" id=\"vo.issueOfLinenVO.issueDate\"  value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"/>\n\t\t\t\t <input type=\'hidden\' name=\'vo.issueOfLinenVO.issueDate.pattern\' id=\'vo.issueOfLinenVO.issueDate.pattern\' value=\'dd/MM/yyyy HH:mm\'>\n\t\t\t\t<img src=\'framework/images/mandatory.gif\'></img>\t\t\n\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t<br><br>\n\t<table align=\"center\" border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap>\n\t\t\t\t\t <input type=\'hidden\' name=\"vo.issueOfLinenVO.linenItem\" id=\"vo.issueOfLinenVO.linenItem\"  />\n\t\t\t\t\t <input type=\"text\" name=\"vo.issueOfLinenVO.linenDesc\" id=\"vo.issueOfLinenVO.linenDesc\"  />\n\t\t\t\t\t<input type=\"hidden\" name=\"linenItem\" id=\"linenItem\"  readonly=\"true\" />\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\'right\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"hidden\" name=\"vo.issueOfLinenVO.requestedQty\" id=\"vo.issueOfLinenVO.requestedQty\"  />\n\t\t\t\t\t<input type=\"text\" readonly=\"true\" name=\"qty\" id=\"qty\" onkeypress=\"checkNumber()\"/>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' align=\'right\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" readonly=\"true\" name=\"iqty\" id=\"iqty\" onkeypress=\"checkNumber()\"/>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' align=\'right\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"ciqty\" id=\"ciqty\" onkeypress=\"checkNumber()\"/>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'  align=\'right\'>\n\t\t\t\t<a href=\"javascript:#\" onclick=\"test5popupactivate(this.id);return false;\" name=\"prepAnchor\" id=\"prepAnchor\">\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a>\n\t\t\t\t<input type=\"hidden\" name=\"remarkArea\" id=\"remarkArea\" value=\"\" maxlength=\"2000\"/>\n\t\t\t\t<input type=\"hidden\" name=\"remark\" id=\"remark\" value=\"\" maxlength=\"2000\"/>\n\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp\n\t\t\t\t</td>\n\t\t\t\t\t<td align=\'right\' class=\'button\'>\n\t\t\t\t\t\t<input class=\'BUTTON\'  type=\"button\" name=\"select\" id=\"select\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onClick=\"populateList()\" />\n\t\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t&nbsp\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n<br><br>\n<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' id=\"tableid\" align=\'center\' >\n\t\t <tr>\n\t\t\t<th align=\"left\" colspan=5>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t</th>\n\t\t </tr>\n\t\t\n\t\t<tr>\n\t\t<th align=\"center\" width=\"20%\">\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t</th>\n\t\t\t<th align=\"center\" width=\"20%\">\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t</th>\n\t\t\t<th align=\"center\" width=\"20%\">\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</th>\n\n\t\t</tr>\n\t\t\n\t\t</table>\n\t\t\n\t\t\n\t\t<div id=\"listContentLayer\" align=\"center\">\n\t\t\n\t\t\t\t\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\'\n\t\t\t\t\t\t id=\"contentTable\" >\n\t\t\t\t \n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t<br><br>\n\t\t<table align=\'center\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'4\'class=\'button\' align=\'right\'>\n\t\t\t\t\t\t<input type=\"button\" class=\"BUTTON\"  name=\"Submit\" id=\"Submit\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" onclick=\"issueNo();apply()\" />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t</table>\n\n\t\t<input type=\"hidden\" name=\"vo.issueOfLinenVO.operatingFacilityId\" id=\"vo.issueOfLinenVO.operatingFacilityId\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" />\t\t\t\t\t\n\t\t<input type=\"hidden\" name=\"languageId\" id=\"languageId\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" />\n\t\t<input type=\"hidden\" name=\"vo.issueOfLinenVO.requestStatus\" id=\"vo.issueOfLinenVO.requestStatus\" />\t\t\t\t\t\n\t\t<input type=\"hidden\" name=\"vo.functionId\" id=\"vo.functionId\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" />\n\t\t<input type=\"hidden\" name=\"vo.moduleId\" id=\"vo.moduleId\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" />\n\t<!--\t<input type=\"hidden\" name=\"vo.issueOfLinenVO.locale\" id=\"vo.issueOfLinenVO.locale\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"-->\n\t\t<input type=\"hidden\" name=\"vo.mode\" id=\"vo.mode\" />\n\t\t<input type=\"hidden\" name=\"vo.viewCode\" id=\"vo.viewCode\" value=\"linenIssue\" />\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\n</body>\n<script>\ndocument.getElementById(\"vo.issueOfLinenVO.linenItem\").value=dialogArguments[6];\ndocument.getElementById(\"vo.issueOfLinenVO.linenDesc\").value=dialogArguments[9];\ndocument.getElementById(\"vo.issueOfLinenVO.requestedQty\").value=dialogArguments[7];\n\ndocument.getElementById(\"vo.issueOfLinenVO.requestNum\").value=dialogArguments[1];\ndocument.getElementById(\"vo.issueOfLinenVO.requestDate\").value=dialogArguments[2];\ndocument.getElementById(\"vo.issueOfLinenVO.sentBy\").value=dialogArguments[3];\ndocument.getElementById(\"vo.issueOfLinenVO.sentBy\").value=dialogArguments[3];\n//document.getElementById(\"vo.issueOfLinenVO.issueBy\").value=dialogArguments[1];\n\ndocument.getElementById(\"linenItem\").value=document.getElementById(\"vo.issueOfLinenVO.linenItem\").value;\ndocument.getElementById(\"qty\").value=document.getElementById(\"vo.issueOfLinenVO.requestedQty\").value;\n\nsumQty();\n\n</script>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

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
	String loggedInUser = (String) session.getAttribute("login_user");
	String locale = (String) session.getAttribute("LOCALE");
//	String sourceDesc= (String) request.getParameter("sourceDesc");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
		if (sStyle == null)
			sStyle = "IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
			UserPreferences userPrefs =new UserPreferences();
			//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
			String datepattrn=userPrefs.getDateFormat();
			String sb=userPrefs.getDateFormat();
			String tf=userPrefs.getTimeFormat();
			String pattern=sb+" "+tf;
			String locale1=userPrefs.getLocale();
		
			IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
			IBADateValidation ibadateVal = new IBADateValidation();
			String conDate = (String)ibadateVal.convertDateJS(todate.toString(),"en",locale,"dd/MM/yyyy HH:mm");

			IBADateTime frmDate=LcDateFormat.getSevendaysBackDate(request);
				
			IBADateTime date = new IBADateTime(request.getSession().getId());
											
			IBADateValidation ibaDateValidation = new IBADateValidation();
			String cdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,pattern);
			String fdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,pattern);
		//	out.println("conDate="+conDate);

	
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
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block30Bytes, _wl_block30);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block31Bytes, _wl_block31);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block32Bytes, _wl_block32);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block33Bytes, _wl_block33);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block35Bytes, _wl_block35);
                    out.print( String.valueOf(facilityId));
                    _bw.write(_wl_block36Bytes, _wl_block36);
                    out.print( String.valueOf(session.getAttribute("login_user")));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.print( String.valueOf(locale));
                    _bw.write(_wl_block38Bytes, _wl_block38);

                    if (_jsp__tag1(request, response, pageContext, _activeTag, __tag0))
                     return;
                    _bw.write(_wl_block39Bytes, _wl_block39);
                     org.apache.struts.taglib.html.FormTag __tag2 = null ;
                    int __result__tag2 = 0 ;

                    if (__tag2 == null ){
                        __tag2 = new  org.apache.struts.taglib.html.FormTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
                    }
                    __tag2.setPageContext(pageContext);
                    __tag2.setParent(__tag0);
                    __tag2.setAction(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("/IssueLinenAfterMendingAction.do", java.lang.String .class,"action"));
                    __tag2.setTarget(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("messageFrame", java.lang.String .class,"target"));
                    _activeTag=__tag2;
                    __result__tag2 = __tag2.doStartTag();

                    if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.html.FormTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block40Bytes, _wl_block40);

                            if (_jsp__tag3(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block41Bytes, _wl_block41);

                            if (_jsp__tag4(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block42Bytes, _wl_block42);
                            out.print( String.valueOf(pattern));
                            _bw.write(_wl_block43Bytes, _wl_block43);

                            if (_jsp__tag5(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block44Bytes, _wl_block44);

                            if (_jsp__tag6(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block45Bytes, _wl_block45);

                            if (_jsp__tag7(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block46Bytes, _wl_block46);
                            out.print( String.valueOf(cdate));
                            _bw.write(_wl_block47Bytes, _wl_block47);

                            if (_jsp__tag8(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block48Bytes, _wl_block48);

                            if (_jsp__tag9(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block49Bytes, _wl_block49);

                            if (_jsp__tag10(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block50Bytes, _wl_block50);

                            if (_jsp__tag11(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block51Bytes, _wl_block51);

                            if (_jsp__tag12(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block52Bytes, _wl_block52);

                            if (_jsp__tag13(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block53Bytes, _wl_block53);

                            if (_jsp__tag14(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block54Bytes, _wl_block54);

                            if (_jsp__tag15(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block55Bytes, _wl_block55);

                            if (_jsp__tag16(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block55Bytes, _wl_block55);

                            if (_jsp__tag17(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block56Bytes, _wl_block56);

                            if (_jsp__tag18(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block55Bytes, _wl_block55);

                            if (_jsp__tag19(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block57Bytes, _wl_block57);

                            if (_jsp__tag20(request, response, pageContext, _activeTag, __tag2))
                             return;
                            _bw.write(_wl_block58Bytes, _wl_block58);
                            out.print( String.valueOf(facilityId));
                            _bw.write(_wl_block59Bytes, _wl_block59);
                            out.print( String.valueOf(locale));
                            _bw.write(_wl_block60Bytes, _wl_block60);
                            out.print( String.valueOf(functionId));
                            _bw.write(_wl_block61Bytes, _wl_block61);
                            out.print( String.valueOf(moduleId));
                            _bw.write(_wl_block62Bytes, _wl_block62);
                            out.print( String.valueOf(locale));
                            _bw.write(_wl_block63Bytes, _wl_block63);
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
                    _bw.write(_wl_block64Bytes, _wl_block64);
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
            _bw.write(_wl_block65Bytes, _wl_block65);
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
         org.apache.struts.taglib.bean.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(parent);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForLinen.requestDate", java.lang.String .class,"key"));
        __tag4.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForLinen.raisedBy", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.returnoflinentolaundry.receivedby", java.lang.String .class,"key"));
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
         org.apache.struts.taglib.bean.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(parent);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveLinenAtLaundry.receivedDate", java.lang.String .class,"key"));
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
         org.apache.struts.taglib.bean.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(parent);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.sentQty", java.lang.String .class,"key"));
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
         org.apache.struts.taglib.bean.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(parent);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.loanLinen.receivedQty", java.lang.String .class,"key"));
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(parent);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.curReceivedQty", java.lang.String .class,"key"));
        __tag11.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.remark", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.selectforbutton", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
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
         org.apache.struts.taglib.bean.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(parent);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.linenItem", java.lang.String .class,"key"));
        __tag15.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.sentQty", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.loanLinen.receivedQty", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.curReceivedQty", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.remark", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.submit", java.lang.String .class,"key"));
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
}
