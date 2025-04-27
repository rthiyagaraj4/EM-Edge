package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCA.*;
import java.net.URLEncoder;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __singlepageconsultation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SinglePageConsultation.jsp", 1743491406607L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<HEAD>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCA/js/SinglePageConsultation.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n\t<TITLE>Single Page Consultation</TITLE>\n\t<script>\n\t\tfunction resizeIframe(obj){\n\t\t\tif ( obj.readyState  == \'complete\' ) {\t\t\t\t\n\t\t\t\tdocument.forms[0].reloadWidgetCount.value=(parseInt(document.forms[0].reloadWidgetCount.value))+1;\n\t\t\t\tvar reloadWidgetCount = document.forms[0].reloadWidgetCount.value;\n\t\t\t\tvar totalWidgetCount = document.forms[0].totalWidgetCount.value;\n\t\t\t\t\n\t\t\t\tvar newheight;\n\t\t\t\t\n\t\t\t\tif(document.getElementById){\n\t\t\t\t\tnewheight=obj.contentWindow.document.body.scrollHeight;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tobj.style.height= (newheight) + \"px\";\n\t\t\t\tif(parseInt(reloadWidgetCount)==parseInt(totalWidgetCount)){\n\t\t\t\t\tresizeAllIFrames();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\treturn;\n\t\t\t}\n\t\t\twindow.setTimeout(\'resizeIframe();\', 100);\n\t\t\t\n\t\t}\n \t\tfunction resizeIframe1(obj){\n \t\t\t\n\t\t\tdocument.forms[0].reloadWidgetCount.value=(parseInt(document.forms[0].reloadWidgetCount.value))+1;\n\t\t\tvar reloadWidgetCount = document.forms[0].reloadWidgetCount.value;\n\t\t\tvar totalWidgetCount = document.forms[0].totalWidgetCount.value;\t\t\t\n\t\t\tvar newheight;\n\t\t\tif(document.getElementById){\n\t\t\t\tnewheight=obj.contentWindow.document.body.scrollHeight;\n\t\t\t}\n\t\t\tobj.style.height= (newheight) + \"px\";\n\t\t\tif(parseInt(reloadWidgetCount)==parseInt(totalWidgetCount)){\n\t\t\t\tresizeAllIFrames();\n\t\t\t}\n    \t}\n \t\tfunction resizeAllIFrames(){\n \t\t\tvar iframeCount = document.getElementsByTagName(\"iframe\").length;\n \t\t\tfor(var i=1;i<=iframeCount;i++){\n \t\t\t\tvar F = document.getElementById(\"iFrameID\"+i);\n \t\t\t\tvar TA = document.getElementById(\"TABLEID\"+i).rows;\n \t\t\t\t  if(F.contentDocument) {\n \t\t\t\t  \tTA[0].height = TA[0].height;\n \t\t\t\t\tTA[1].height =  (F.contentDocument.documentElement.scrollHeight+30)+\"px\";\n \t\t\t\t\tTA[2].height = TA[2].height; \n \t\t\t\t } else {\n \t\t\t\t\tTA[0].height = TA[0].height;\n \t\t\t\t\tTA[1].height =  (F.contentWindow.document.body.scrollHeight)+\"px\";\n \t\t\t\t\tTA[2].height = TA[2].height; \n \t\t\t\t } \t\t\t\t\n \t\t\t\t\n \t\t\t}\n \t\t\n \t\t} \t\t\n\t\tfunction showResults(queryString){\n\t\t\tvar dialogHeight\t= \"39\" ;\n\t\t\tvar dialogWidth\t\t= \"60\" ;\n\t\t\tvar status\t\t\t= \"no\";\n\t\t\tvar scroll\t\t\t= \"yes\";\n\t\t\tvar dialogTop\t\t= \"100\";\n\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\twindow.open(\'../../eCA/jsp/ViewResults.jsp?\'+queryString+\'&modal_YN=Y\',\"\",arguments,features);\n\t\t}\n\t\t\n\t\tasync function showFilteredData(retVal,widgetName){\n\t\t\tvar dialogHeight\t= \"39\" ;\n\t\t\tvar dialogWidth\t\t= \"60\" ;\n\t\t\tvar status\t\t\t= \"no\";\n\t\t\tvar scroll\t\t\t= \"yes\";\n\t\t\tvar dialogTop\t\t= \"100\";\n\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\tif(\"High Risk\"==widgetName || \"Active Problems\"==widgetName){\n\t\t\t\twindow.open(retVal,\"\",\"height=350,width=1000,scrollbars=yes\");\n\t\t\t}else{\n\t\t\t\tvar retData =await window.showModalDialog(retVal,arguments,features);\n\t\t\t}\n\t\t}\n\n\t\tasync function recordTransaction(fileName,queryString,widgetName,tableId,oldtableId){\n\t\t\tvar dialogHeight\t= \"39\" ;\n\t\t\tvar dialogWidth\t\t= \"60\" ;\n\t\t\tvar status\t\t\t= \"no\";\n\t\t\tvar scroll\t\t\t= \"yes\";\n\t\t\tvar dialogTop\t\t= \"100\";\n\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\n\t\t\tif(\"Clinical Note for Nurse\"==widgetName || \"Clinical Note for Physician\"==widgetName || \"Personal and Family History\"==widgetName || \"Medication Certificate\"==widgetName){\n\t\t\t\tvar action_url =\"../../eCA/jsp/RecClinicalNotesModal.jsp?\"+queryString;\n\t\t\t \n\t\t\t\tvar title1=\"\";\n\t\t\n\t\t\t\tvar dialogHeight= \"100\";\n\t\t\t\tvar dialogWidth\t= \"100\";\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar arguments\t= \"\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\t\t\n\t\t\t\tsecondwindow  = window.showModalDialog(action_url, title1, features);\t\n\t\t\t\t\n\t\t\t\t//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();\n\t\t\t\tif(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf(\"&reloadTableId=\"))!=-1){\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace(\"&reloadTableId=\"+oldtableId,\"&reloadTableId=\"+tableId));\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+\"&reloadTableId=\"+tableId;\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\t}else if(\"Allergies\"==widgetName){\n\t\t\t\tvar dialogHeight\t= \"100\" ;\n\t\t\t\tvar dialogWidth\t\t= \"60\" ;\n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar scroll\t\t\t= \"yes\";\n\t\t\t\tvar dialogTop\t\t= \"100\";\n\t\t\t\tvar arguments\t= \"\";\n\t\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\n\t\t\t\tvar retData = window.showModalDialog(fileName+queryString,arguments,features);\t\n\t\t\t\t//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();\n\t\t\t\tif(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf(\"&reloadTableId=\"))!=-1){\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace(\"&reloadTableId=\"+oldtableId,\"&reloadTableId=\"+tableId));\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+\"&reloadTableId=\"+tableId;\t\t\t\t\n\t\t\t\t}\n\t\t\t}else if(\"Initial Assessment \"==widgetName){\n\t\t\t\tvar dialogHeight\t= \"100\" ;\n\t\t\t\tvar dialogWidth\t\t= \"60\" ;\n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar scroll\t\t\t= \"yes\";\n\t\t\t\tvar dialogTop\t\t= \"100\";\n\t\t\t\tvar arguments\t= \"\";\n\t\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\n\t\t\t\tvar retData = window.showModalDialog(fileName+queryString,arguments,features);\t\n\t\t\t\t//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();\n\t\t\t\tif(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf(\"&reloadTableId=\"))!=-1){\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace(\"&reloadTableId=\"+oldtableId,\"&reloadTableId=\"+tableId));\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+\"&reloadTableId=\"+tableId;\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(\"Pending Schedules\"==widgetName){//IN049701 Starts\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"42\" ;\n\t\t\t\tvar dialogWidth = \"70\" ;\n\t\t\t\tvar dialogTop \t= \"85\";\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\t\t\n\t\t\t\tretVal =await  window.showModalDialog(fileName+queryString,arguments,features);\n\t\t\t\t\n\t\t\t\tif (retVal != null && retVal != \"\")\n\t\t\t\t{\n\t\t\t\t\tvar returnVal = retVal.split(\"^\");\n\t\t\t\t\tvar mode = returnVal[0];\n\t\t\t\t\th = returnVal[1];\n\t\t\t\t\tif (mode==\"1\")\n\t\t\t\t\t{\n\t\t\t\t\t\t h=h+ \"&title=\"+getLabel(\"Common.bookappointment.label\",\'Common\');\t\t\t\t\t\n\t\t\t\t\t\t retVal =await window.showModalDialog(\"../../eOA/jsp/SinglePractVwNew.jsp?\"+h,arguments,features);\t\t\n\t\t\t\t\t\t if (retVal==\"OP\")\n\t\t\t\t\t\t\t recordTransaction(false);\n\t\t\t\t\t}\n\t\t\t\t\telse if (mode==\"2\")\n\t\t\t\t\t{\n\t\t\t\t\t\t h=h+ \"&title=\"+getLabel(\"Common.bookappointment.label\",\'Common\');\n\t\t\t\t\t\t retVal =await window.showModalDialog(\"../../eOA/jsp/MultiPract2VwMain.jsp?\"+h,arguments,features);\n\t\t\t\t\t\t if (retVal==\"OP\")\n\t\t\t\t\t\t\trecordTransaction(false);\n\t\t\t\t\t}\n\t\t\t\t\telse if (mode==\"3\")\n\t\t\t\t\t{\n\t\t\t\t\t\th=h+ \"&title=\"+getLabel(\"Common.bookappointment.label\",\'Common\');\n\t\t\t\t\t\tretVal =await window.showModalDialog(\"../../eOA/jsp/MultiPract3VwMain.jsp?\"+h,arguments,features);\n\t\t\t\t\t\tif (retVal==\"OP\")\n\t\t\t\t\t\t\trecordTransaction(false);\n\t\t\t\t\t}\n\n\t\t\t\t\tif(retVal != null && retVal != \"\")\n\t\t\t\t\t{\t\t\n\t\t\t\t\t\tif(retVal !=\"\")\n\t\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\t\trecordTransaction(fileName,queryString,widgetName);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\ttop.content.workAreaFrame.location.reload();\n\t\t\t\n\t\t\t}//IN049701 Ends\n\t\t\telse{\n\t\t\t\tvar retData = window.showModalDialog(fileName+queryString,arguments,features);\n\t\t\t\t//top.content.workAreaFrame.singlepageconsultationworkflow.location.reload();\n\t\t\t\tif(((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).indexOf(\"&reloadTableId=\"))!=-1){\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = ((top.content.workAreaFrame.singlepageconsultationworkflow.location.href).replace(\"&reloadTableId=\"+oldtableId,\"&reloadTableId=\"+tableId));\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\ttop.content.workAreaFrame.singlepageconsultationworkflow.location.href = top.content.workAreaFrame.singlepageconsultationworkflow.location.href+\"&reloadTableId=\"+tableId;\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tfunction borderHighLite(obj){\n\t\t\tobj.className = \'borderhighlight\';\n\t\t}\n\t\t\n\t\tfunction borderEnlight(obj){\n\t\t\tobj.className = \'\';\n\t\t}\n\t\t\n\t\tfunction refreshParent()\n\t\t{\n\t\t\ttop.content.workAreaFrame.location.reload();\t\t\t\n\t\t}\n\n\t</script>\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<BODY class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' >\n\t<form name=\'singlepageconsultationform\' id=\'singlepageconsultationform\'>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t<div id=\'main\' style=\"position: absolute; width: 100%; height: 100%; left: 0px; padding-left: 10px;padding-right: 10px; background: #FFFFFF; overflow: auto; display: inline\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t\t\t\n\t\t\t\t\t<TABLE id=\"TABLEID";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" class=\"ROUNDCORNNERSTYLE";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" cellpadding=0 cellspacing=0 border=0 width=\'100%\'   >\n\t\t\t\t\t\t<TR>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<TD width=\"80%\" class=\'COLUMNHEADERCENTERSPC";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<TD class=\'COLUMNHEADERCENTERSPC";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\"18%\" align=\"right\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;</TD>\n\t\t\t\t\t\t\t\t<TD class=\'COLUMNHEADERCENTERSPC";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' width=\"5px;\"><input type=\"checkbox\" name=\'print_yn";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'print_yn";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onclick=\'printWidget(this)\' value=\"N\" /></TD>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR style=\"background: #FFFFFF;\" id=\"TRID";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t\t<TD align=\"center\" colspan=\"3\" valign=\"top\">\n\t\t\t\t\t\t\t\t<TABLE cellpadding=0 cellspacing=0 width=\'100%\' border=0>\n\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t<TD valign=\"top\" id=\"RecID";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" &nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<iframe id=\"FrameID";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" src=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'100%\' height=\"600px;\" frameborder=\'0\' scrolling=\'no\'></iframe>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</TR>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\n\t\t\t\t\t</TABLE>\n\t\t\t\t\t<br>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\n\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' name=\'totalVisits\'>\n\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' name=\'req_encounter_id\'> \n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type=\'hidden\' name=\'no_of_widgets\' id=\'no_of_widgets\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'reloadWidgetCount\' id=\'reloadWidgetCount\' value=\'0\'>\n\t\t<input type=\'hidden\' name=\'totalWidgetCount\' id=\'totalWidgetCount\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'/>\n\t\t<input type=\'hidden\' name=\'authorize_diagnosis\' id=\'authorize_diagnosis\' value=\'\'/>\n\t\t<input type=\'hidden\' name=\'option_id\' id=\'option_id\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=\'hidden\' name=\'chart_encounter_id\' id=\'chart_encounter_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\t\t</div>\n\t</form>\n</BODY>\n</HTML>\n<script>\n\t\tvar called_from = \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\tif(!\"PRINT\"==called_from)\n\t\t{\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.totalWidgetCount.value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.totalVisits.value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.req_encounter_id.value= \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.patient_id.value= \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.no_of_widgets.value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.called_from.value=\'\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.reloadWidgetCount.value=\'0\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.authorize_diagnosis.value=\'\';\n\t\t\tparent.singlepageconsultationActionButton.document.frmPrint.option_id.value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\t\n\t\t\tvar no_of_widgets= document.getElementById(\"no_of_widgets\").value;\n\t\t\tfor(var k=1;k<=no_of_widgets;k++)\n\t\t\t{\n\t\t\t\t parent.singlepageconsultationworkflow.document.getElementById(\"print_yn\"+k).value = \"Y\";\n\t\t\t\t parent.singlepageconsultationworkflow.document.getElementById(\"print_yn\"+k).checked = true;\n\t\t\t}\n\t\t}\t\n\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'!=\"\" ){\n\t\t\tvar container = document.getElementById(\'main\');\n\t\t\tvar rowToScrollTo = document.getElementById(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\n\t\t\tcontainer.scrollTop = rowToScrollTo.offsetTop;\n\t\t\trowToScrollTo.focus();\n\t\t}\n\t\t\n\t\t\t\n</script>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/05/2014    IN037701		Ramesh G				      					SKR-CRF-0036
18/06/2014	  IN049701		Nijitha S										SKR-CRF-0036	
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
	
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String pageStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);

			String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
			String patient_id = request.getParameter("patient_id");
			String encounter_id1 = request.getParameter("encounter_id") == null ? "" : (String) request.getParameter("encounter_id");
			String req_encounter_id = request.getParameter("encounter_id_spc") == null ? "": (String) request.getParameter("encounter_id_spc");
			
		
            _bw.write(_wl_block7Bytes, _wl_block7);

			Properties p = (Properties) session.getValue("jdbc");
			String locale = (String) p.getProperty("LOCALE");
			String encounter_id = null;
			String facility_id = (String) session.getValue("facility_id");
			String practitioner_id = null, speciality_name = null, patient_class = null,patient_class_spc="";
			practitioner_id = (String) session.getValue("ca_practitioner_id");
			if (practitioner_id == null)
				practitioner_id = "";
			speciality_name = request.getParameter("location_code") == null ? "": request.getParameter("location_code");
			String location_code_spc = request.getParameter("location_code_spc") == null ? "": request.getParameter("location_code_spc");
			patient_class = request.getParameter("patient_class") == null ? "EM": request.getParameter("patient_class");
			patient_class_spc = request.getParameter("patient_class_spc") == null ? "EM": request.getParameter("patient_class_spc");
			String reloadTableId = request.getParameter("reloadTableId") == null ? "": (String)request.getParameter("reloadTableId");
			String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
			String widgetHeaderShade = request.getParameter("widgetHeaderShade");
			
			String qs = request.getQueryString();
			qs = qs.replace("&encounter_id="+encounter_id1,"&encounter_id="+req_encounter_id);
			qs = qs.replace("&episode_id="+encounter_id1,"&episode_id="+req_encounter_id);
			qs = qs.replace("&patient_class="+patient_class,"&patient_class="+patient_class_spc);
			qs = qs+"&facility_id="+facility_id;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PreparedStatement pstmtencounter = null;
			ResultSet rsencounter = null;
			ArrayList positionsList = new ArrayList();
			HashMap<String, String> prefChartStyleMap = new HashMap<String, String>();
			List<String> displayIconDtl = new ArrayList<String>();
			String result_header_icon = "";
			String styleSheetName = "";
			String contentID = "";
			String fileName = "";
			String widgetName = "";
			//int totalRows = 0;
			String queryString = "";
			int encounterIndex = 0;
			int widgetIndex = 0;
			int totalWidgetCount = 0; //Ramesh
			//String strSql = "SELECT NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME, CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC,CSCN.CONTENT_ID,CSCN.ADDL_CRITERIA_PARAM FROM ca_spc_content_lang_vw CSCN, SM_MODULE M  WHERE CSCN.LANGUAGE_ID = ? AND M.MODULE_ID = CSCN.MODULE_ID ORDER BY CSCN.CONTENT_ID";
			
			StringBuilder strSql = new StringBuilder();
			strSql.append("SELECT NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, ");
			strSql.append("DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME,");
			strSql.append("CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC,");
			strSql.append("CSCN.CONTENT_ID,");
			strSql.append("CSCN.ADDL_CRITERIA_PARAM,");
			strSql.append("ca_get_spc_style_id (?,?,?,csd.summary_id,csd.content_id) pref_chart_style ");
			strSql.append(" FROM CA_SPC_DETAIL csd,CA_spc_HEADER csh,ca_spc_content_lang_vw cscn, sm_module m ");
			strSql.append(" WHERE csh.summary_id = CA_GET_SPC_ID(?,?,?) ");
			strSql.append("AND csh.summary_id = csd.summary_id ");
			strSql.append("AND csd.content_id = cscn.content_id ");
			strSql.append("AND cscn.language_id = ? ");
			strSql.append("AND m.module_id = cscn.module_id ");
			strSql.append("ORDER BY TO_NUMBER(cscn.content_id)");
			String displayIconSql = "SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_SPC_CRITERIA_DTL a,CA_SPC_CRITERIA_HDR b, CA_SPC_CONTENT c WHERE a.sum_criteria_id = b.sum_criteria_id and  b.content_id = c.content_id  AND c.content_id = ? order by to_number (a.sum_sl_no) desc";

			/**************** Ramesh **************/			
			StringBuilder widgetCountSql = new StringBuilder();
			widgetCountSql.append("SELECT COUNT(*) totalCount");
			widgetCountSql.append(" FROM CA_SPC_DETAIL csd,CA_spc_HEADER csh,ca_spc_content_lang_vw cscn, sm_module m ");
			widgetCountSql.append(" WHERE csh.summary_id = CA_GET_SPC_ID(?,?,?) ");
			widgetCountSql.append("AND csh.summary_id = csd.summary_id ");
			widgetCountSql.append("AND csd.content_id = cscn.content_id ");
			widgetCountSql.append("AND cscn.language_id = ? ");
			widgetCountSql.append("AND m.module_id = cscn.module_id ");
			widgetCountSql.append("ORDER BY cscn.content_id");
			/**************** Ramesh ***************/
			try {
				con = ConnectionManager.getConnection(request);
				/**************** Ramesh ****** Start *********/
				pstmt = con.prepareStatement(widgetCountSql.toString());
				pstmt.setString(1, location_code_spc);
				pstmt.setString(2, patient_class_spc);
				pstmt.setString(3, practitioner_id);
				pstmt.setString(4, locale);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					totalWidgetCount = Integer.parseInt((String)rs.getString("totalCount"));
				}
				
				if(pstmt!=null)pstmt.close();
				if(rs!=null) rs.close();
				
				/**************** Ramesh ******** End *******/
				pstmt = con.prepareStatement(strSql.toString());
				
				pstmt.setString(1, location_code_spc);
				pstmt.setString(2, patient_class_spc);
				pstmt.setString(3, practitioner_id);
				pstmt.setString(4, location_code_spc);
				pstmt.setString(5, patient_class_spc);
				pstmt.setString(6, practitioner_id);
				pstmt.setString(7, locale);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					//totalRows++;
					
					positionsList.add(rs.getString("TITLE_CONTENT")); //TITLE_CONTENT
					positionsList.add(rs.getString("CONTENT_EXEC_NAME")); //CONTENT_EXEC_NAME 	
					positionsList.add(rs.getString("SYSTEM_DESC")); //SYSTEM_DESC 	
					positionsList.add(rs.getString("CONTENT_ID"));//CONTENT_ID 
					positionsList.add(rs.getString("ADDL_CRITERIA_PARAM")==null?"":rs.getString("ADDL_CRITERIA_PARAM"));//ADDL_CRITERIA_PARAM 
					positionsList.add(rs.getString("pref_chart_style")==null?"":rs.getString("pref_chart_style"));//ADDL_CRITERIA_PARAM
					prefChartStyleMap.put(rs.getString("CONTENT_ID"), rs.getString("pref_chart_style"));
				}
				int count =1;
				for (int i = 0; i < positionsList.size(); i += 6) {
					widgetIndex++;
					if(("PRINT".equals(called_from) && "Y".equals(request.getParameter("print_yn"+widgetIndex))) || ("PRINTPREVIEW".equals(called_from) && "Y".equals(request.getParameter("print_yn"+widgetIndex))) || (!"PRINTPREVIEW".equals(called_from) && (!"PRINT".equals(called_from))))
					{
					fileName = (String) positionsList.get(i + 1);									
					if(fileName!=""){//&& prefChartStyleMap.containsKey(fileName)
						styleSheetName = prefChartStyleMap.get(positionsList.get(i+3));
						if(null!=styleSheetName && !"null".equals(styleSheetName) && styleSheetName!=""){
							out.println("<link rel='StyleSheet' href='../../eCommon/html/"+styleSheetName+"' type='text/css' />");
							contentID = (String)positionsList.get(i+3);
						}else{
							contentID="";
						 	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+pageStyle+"' type='text/css' />");
							styleSheetName=pageStyle;
						}
					}
					try {
						pstmt = con.prepareStatement(displayIconSql);
						pstmt.setString(1, (String) positionsList.get(i + 3));
	
						rs = pstmt.executeQuery();
						while (rs.next()) {
							displayIconDtl.add(rs.getString("content_id"));
							displayIconDtl.add(rs.getString("image_icon_file"));
							displayIconDtl.add(rs.getString("comp_exe_name"));
							displayIconDtl.add(rs.getString("comp_exe_tooltip"));
							displayIconDtl.add(rs.getString("NO_OF_MENU"));
							displayIconDtl.add(rs.getString("ADDL_CRITERIA_PARAM"));
							displayIconDtl.add(rs.getString("IMAGE_ICON_ALIGN"));
						}
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
									
					if( !"PRINTPREVIEW".equals(called_from) && encounter_id1.equals(req_encounter_id)){
						for (int cnt = 0; cnt < displayIconDtl.size(); cnt += 7) {
							if ("" != displayIconDtl.get(cnt + 1) &&  null != displayIconDtl.get(cnt + 1)&& "L".equals(displayIconDtl.get(cnt + 6))) {
								queryString = URLEncoder.encode(qs,"UTF-8")+ displayIconDtl.get(cnt + 5);

								if (!"".equals(encounter_id)) {
									widgetName = "<a style='color:ffffff' href='javascript:recordTransaction(\""+ displayIconDtl.get(cnt + 2)+ "?"+ "\",\""+ queryString+ "&title="+ displayIconDtl.get(cnt + 3)+ "&prefStyle="+ styleSheetName+ "&content_ID="+ displayIconDtl.get(cnt)+ "\",\""+ (String) positionsList.get(i + 2)+ "\",\"TABLEID"+count+"\",\""+reloadTableId+"\")' title='"+ displayIconDtl.get(cnt + 3)+ "'><img style='color:ffffff' src='../../eCA/images/"+ displayIconDtl.get(cnt + 1)+ "' align='left'/></a>"+widgetName;
								}
							}
						}
					}
					if( !"PRINTPREVIEW".equals(called_from) ){
						if (!displayIconDtl.isEmpty() && displayIconDtl.size() > 0) {
						for (int j = 0; j < displayIconDtl.size(); j += 7) {
							queryString =  URLEncoder.encode(qs,"UTF-8") + displayIconDtl.get(j + 5);
							if (null != displayIconDtl.get(j + 1) && "" != displayIconDtl.get(j + 2) && "R".equals(displayIconDtl.get(j + 6))) {
								result_header_icon = result_header_icon+ "<a style='color:ffffff' href='javascript:showFilteredData(\""+ displayIconDtl.get(j + 2)+ "?"+ queryString+ "&title="+ displayIconDtl.get(j + 3)+ "&prefStyle="+ styleSheetName+ "&content_ID="+ displayIconDtl.get(j)+ "\",\""+ (String) positionsList.get(i + 2)+ "\")' title='"+ displayIconDtl.get(j + 3)+ "'><img style='color:ffffff' src='../../eCA/images/"+ displayIconDtl.get(j + 1)+ "' align='right'/></a>";
							System.out.println("---------result_header_icon------>"+result_header_icon);
							}
							}
						}
					}	
					displayIconDtl.clear();
					fileName = fileName + "?" + qs+ "&title=" + positionsList.get(i)+ "&prefStyle=" + styleSheetName + "&content_ID="+ positionsList.get(i + 3)+positionsList.get(i+4)+"&chart_encounter_id="+encounter_id1;
					System.out.println("fileName:SinglePageConsultation.jsp"+fileName);
					
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(count));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(positionsList.get(i + 3) ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(positionsList.get(i + 3) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(widgetName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String) positionsList.get(i)));
            _bw.write(_wl_block13Bytes, _wl_block13);

							if(!"PRINT".equals(called_from) && !"PRINTPREVIEW".equals(called_from))
							{
							
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(positionsList.get(i + 3) ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(result_header_icon));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(positionsList.get(i + 3) ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(widgetIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(widgetIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);

							}
							
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(count!=12){
            _bw.write(_wl_block23Bytes, _wl_block23);
            {java.lang.String __page =fileName 
                ;
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fileName ));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);

					result_header_icon = "";
					widgetName="";
					count++;
					}
				}
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounterIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(req_encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(widgetIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalWidgetCount ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id1));
            _bw.write(_wl_block36Bytes, _wl_block36);

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					ConnectionManager.returnConnection(con, request);
			}
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalWidgetCount ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(encounterIndex));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(req_encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(widgetIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reloadTableId));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(reloadTableId));
            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
