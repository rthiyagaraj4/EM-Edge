package jsp_servlet._elc._core._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.Constants;

public final class __lclaundrytoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/core/jsp/LcLaundryToolbar.jsp", 1709118039755L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block11 ="\n<html> \n\t<head>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'></link>\n<script src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/dwrcore/interface/MessageReader.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/dwrcore/engine.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/dwrcore/util.js\'></script>\n\t\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/framework/js/Ajax_DWR.js\'></script>\n\t\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/framework/js/hashtable.js\"></script>\n\t\t<script type=\"text/javascript\"\tsrc=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eLC/IssueOfLinen/js/IssueOfLinen.js\'/>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eLC/DeliverCleanedLinen/js/DeliverCleanedLinen.js\">\n\t</script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eLC/EnterCleanedLinen/js/EnterCleanedLinen.js\">\n\t</script>\n\t<Script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eLC/WriteOffLinen/js/WriteOffLinen.js\"></Script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/dwrlc/interface/RequestForCleaning.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/dwrlc/interface/extCleaning.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<Script>\nvar userFlag=\"\";\nvar issueLabel=\"\";\n\t   function activate( newimg ) {\n\t\t\treturn true;\n\t\t}\n\t\t\n\t\tfunction onDelete(){\n\t\t  parent.deleterec();\n\t\t}\n\n\t\tfunction onApply() {\n\t\t\tparent.apply() ;\n\t\t\t}\n\t\t\n\t\tfunction writeOff()\n\t\t{\n\t\tvar flag=\"Laundry\";\n\t\tvar functionId=\"LC_WRITEOFF_LNDRY\";\n\t\tparent.content.location.href=contextPath+\"/eLC/WriteOffLinen/jsp/WriteOffLinenFrames.jsp?functionId=\"+functionId+\"&flag=\"+flag;\n\t\t}\n\t\tfunction delivery1()\n\t\t{\n\t\tvar functionId=\"LC_DEL_CLEANED_LINEN\";\n\t\tparent.content.location.href = contextPath + \"/eLC/DeliverCleanedLinen/jsp/DeliverCleanedLinenFrames.jsp?method=\"+loadMethod+\"&functionId=\"+functionId;\n\t\t}\n\t\tfunction closeWindow()\n\t\t{\n\t\tparent.parent.window.close();\n\t\t}\n\t\tfunction switchFunction()\n\t\t{\n\t\t\t parent.parent.frames[1].expand(this);\n\t\t\t parent.parent.frames[2].location.href = contextPath +\"/eCommon/jsp/maindisplay.jsp\";\n\t\t}\n\t\tfunction home()\n\t\t{\n\t\tparent.parent.frames[2].location.href = contextPath + \"/eLC/IssueOfLinen/jsp/IssueOfLinenMain.jsp\";\n\t\t}\n\t\tfunction EnterLinen()\n\t\t{\n\t\tvar moduleId=\"LC\";\n\t\tvar functionId=\"LC_ENTER_CLEAN_LINEN\";\n\t\t\tparent.content.location.href=contextPath+\"/eLC/EnterCleanedLinen/jsp/EnterCleanedLinenFrames.jsp?&vo.functionId=\"+functionId+\"&vo.moduleId=\"+moduleId;\n\t\t}\n\t\tfunction IssueLinen()\n\t\t{\n\t\tvar moduleId=\"LC\";\n\t\tvar functionId=\"LC_ISSUE\";\n\t\t\tparent.content.location.href = contextPath + \"/eLC/IssueOfLinen/jsp/IssueOfLinenFrames.jsp?vo.viewCode=requestsListFrame&method=\"+loadMethod+\"&vo.functionId=\"+functionId;\n\t\t}\n\t\tfunction xCleaning()\n\t\t{\n\t\tvar moduleId=\"LC\";\n\t\tvar functionId=\"LC_EXTERN_CLEANING\";\n\t\tparent.content.location.href = contextPath + \"/eLC/ExternalCleaning/jsp/RequestForExternalCleaningMainFrames.jsp?&vo.functionId=\"+functionId+\"&vo.moduleId=\"+moduleId;\n\t\t}\n\t\tfunction sendMending()\n\t\t{\n\t\tvar moduleId=\"LC\";\n\t\tvar functionId=\"LC_SEND_FOR_MEND_LINEN\";\n\t\tparent.content.location.href = contextPath + \"/eLC/SendLinenForMending/jsp/RequestForMendingMainFrames.jsp?&vo.functionId=\"+functionId+\"&vo.moduleId=\"+moduleId;\n\t\t}\n\t\tfunction receiveMending()\n\t\t{\n\t\t\n\t\t\tvar moduleId=\"LC\";\n\t\t\tvar functionId=\"LC_RECEIVE_MEND_LINEN\";\n\t\t\tparent.content.location.href = contextPath + \"/eLC/IssueLinenAfterMending/jsp/IssueOfLinenAfterMendingFrames.jsp?vo.viewCode=requestsListFrame&method=\"+loadMethod+\"&vo.functionId=\"+functionId+\"&vo.moduleId=\"+moduleId;\n\n\t\t}\n\tfunction complaint()\n\t{\n\t\t//alert()\n\t\tvar moduleId=\"LC\";\n\t\tvar functionId=\"LC_LODGE_COMPLAINT\";\n\t\tvar flag=\"Laundry\";\tparent.content.location.href=contextPath+\"/LodgeComplaintAction.do?method=\"+loadMethod+\"&vo.functionId=\"+functionId+\"&flag=\"+flag;\n\t}\nvar exFlag=\"\";\nfunction checkExternalParam()\n{\n\tfacilityId=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\textCleaning.getPararmForFacility(facilityId,getExternalParam)\n\tfunction getExternalParam(dat)\n\t{\n\t\tfor(prop in dat)\n\t\t{if(dat[prop]!=\"\"||dat[prop]!=null)\n\t\t\t{\n\t\t\texFlag=prop;\n\t\t\tif(prop==\'N\'){\n\t\t\t\tdocument.getElementById(\"externalCleaning\").style.visibility=\'hidden\';\n\t\t\t\tdocument.getElementById(\"exLabel\").style.visibility=\'hidden\';\n\t\t\t}else\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"externalCleaning\").style.visibility=\'visible\';\n\t\t\t\tdocument.getElementById(\"exLabel\").style.visibility=\'visible\';\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n\t}\n}\n\n\tfunction cleaning() \n\t{\n\t\tloggedInUser=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\tfacilityId=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t//alert(loggedInUser+\"==\"+facilityId)\n\t\tRequestForCleaning.getDirtyLinenParam(facilityId,getDirty);\n\t\tcheckUser();\n\t}\n\tfunction getDirty(rec)\n\t{\n\t\tfacilityId=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t//alert(\"getDirty===\" +facilityId)\n\t\tvar dt=new Date();\n\n\t\tfor(prop in rec)\n\t\t{\n\t\t\tif(prop!=null)\n\t\t\t\t{\t\n\t\t\t\t  dirtyFlag=prop;\n\t\t\t\t  dt=rec[prop]\n\t\t\t\t}\n\t\t}\n\t\tcutoffTime=dt;\n\t\t//alert(cutoffTime)\n\t\t\t//\talert(\"getDirty===\" +facilityId)\n\t\t\tRequestForCleaning.getOverRideWardConf(facilityId,getconf); \n\t\t\t\n}\n\nfunction checkUser()\n{\n\tloggedInUser=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\tfacilityId=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\tRequestForCleaning.getLcUser(facilityId,loggedInUser,getUser);\n}\n\nfunction getUser(data)\n{\n   for(prop in data)\n\t   {\n\t\tif(prop!=null)\n\t\t\t{\n\t\t\t    document.getElementById(\"LaundryConf\").value=data[prop];\n\t\t\t\tif(prop==loggedInUser.toUpperCase()){\n\t\t\t\tuserFlag=\"Y\";\n\t\t\t\tdocument.getElementById(\"cleaningLabel\").style.visibility=\"visible\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\n\t\t\t    userFlag=\"N\";\n\t\t\t\tdocument.getElementById(\"Cleaning\").style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\"cleaningLabel\").style.visibility=\"hidden\";\n\t\t\t   }\n\t\t\t}\n\n\t\t}\n\t\tif(userFlag==null||userFlag==\"\")\n\t\t{\t \n\t\t\tuserFlag=\"N\"; \n\t\t\tdocument.getElementById(\"Cleaning\").style.visibility=\"hidden\";\n\t\t\tdocument.getElementById(\"cleaningLabel\").style.visibility=\"hidden\";\n\t\t\n\t\t}\n\t\t//checkExternalParam();\n }\n\n\n\n   function getconf(data1)\n   {\n\t   var conf=\"\";\n\t   var currDate = new Date();\n\t\tvar date = currDate.getDate();\n\t\tvar mon = currDate.getMonth();\n\t\tvar hrNow = currDate.getHours();\n\t\tvar mnNow = currDate.getMinutes();\n\t\tscNow = currDate.getSeconds();\n\t\tmon = mon+1;\n\t\tvar year = currDate.getYear();\n\t\tif(date <10)\n\t\t\tdate = \"0\"+date;\n\t\tif(mon <10)\n\t\t\tmon = \"0\"+mon;\n\t\tif(hrNow<10)\n\t\t\t\thrNow=\"0\"+hrNow;\n\t\tif(mnNow<10)\n\t\t\t\tmnNow=\"0\"+mnNow;\n\t\tvar convert1= date + \"/\" + mon + \"/\" + year;\n\t\t\tconvert1=convert1+\" \"+hrNow+ \":\" +mnNow;\n\t   for(prop1 in data1)\n\t   {\n\t\t  if(prop1!=null)\n\t\t\t  {\n\t\t\t\tdelDate=data1[prop1];\n\t\t\t  }\n\t   }\n\t \n\t   conf=document.getElementById(\"LaundryConf\").value;\n\t\tif(conf!=\"\")\n\t\t\t{\t\n\t\t\tif(conf==\'Y\') \n\t\t\t\tparent.content.location.href = contextPath + \"/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=Y&dirtyFlag=\"+dirtyFlag+\"&cutoffTime=\"+cutoffTime+\"&delParamDate=\"+delDate+\"&userFlag=\"+userFlag;\t\n\t\t\t\telse\n\t\t\t\tparent.content.location.href = contextPath + \"/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=N&dirtyFlag=\"+dirtyFlag+\"&cutoffTime=\"+cutoffTime+\"&delParamDate=\"+delDate+\"&userFlag=\"+userFlag;\n\t\t\t} \n\t\telse\n\t\t\t{\n\t\t\t\tgetServerMessage(\"APP-LC00022\");\n\t\t\t\tvar msg=dwrMessage;\n\t\t\t\talert(msg);\n\t\t\t}\n\n  }\n\nfunction changeImg(obj)\n{\n\tif(obj.id==\"create\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-Issue2.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\t//document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t}\n\t\n\telse if(obj.id==\"Delivery\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-Delivery2.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\t//document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t}\n\telse if(obj.id==\"writeoff\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-Writeoff2.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\t//document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t}\n\telse if(obj.id==\"Entry\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-Entry2.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\t///document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t}\n\telse if(obj.id==\"mendingS\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-MendingSend2.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\t//document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t}\n\telse if(obj.id==\"mendingR\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-MendingRecive2.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\t//document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t}\n\telse if(obj.id==\"Lcomplaint\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-Complaint2.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\t//document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t\t\n\t}\n\telse if(obj.id==\"Cleaning\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/W-Cleaning2.gif\";\n\t\t//document.getElementById(\"externalCleaning\").src=\"../../../eLC/core/images/L-externalCleaning1.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\n\t}\n/*\telse if(obj.id==\"externalCleaning\")\n\t{\n\t\tobj.src=\"../../../eLC/core/images/L-externalCleaning2.gif\";\n\t\tdocument.getElementById(\"Cleaning\").src=\"../../../eLC/core/images/W-Cleaning1.gif\";\n\t\tdocument.getElementById(\"create\").src=\"../../../eLC/core/images/L-Issue1.gif\";\n\t\tdocument.getElementById(\"Delivery\").src=\"../../../eLC/core/images/L-Delivery1.gif\";\n\t\tdocument.getElementById(\"writeoff\").src=\"../../../eLC/core/images/L-Writeoff1.gif\";\n\t\tdocument.getElementById(\"Entry\").src=\"../../../eLC/core/images/L-Entry1.gif\";\n\t\tdocument.getElementById(\"mendingS\").src=\"../../../eLC/core/images/L-MendingSend1.gif\";\n\t\tdocument.getElementById(\"mendingR\").src=\"../../../eLC/core/images/L-MendingRecive1.gif\";\n\t\tdocument.getElementById(\"Lcomplaint\").src=\"../../../eLC/core/images/L-Complaint1.gif\";\n\n\t}*/\n}\nfunction displayLabel(arg)\n{\nflag=arg;\n\nif(flag==\'I\')\nissueLabel=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\nif(flag==\'D\')\nissueLabel=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\nif(flag==\'E\')\nissueLabel=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\nif(flag==\'W\')\nissueLabel=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\nif(flag==\'M\')\nissueLabel=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\nif(flag==\'R\')\nissueLabel=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\nif(flag==\'Cl\')\nissueLabel=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\t\nif(flag==\'C\')\nissueLabel=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\nif(flag==\'x\')\nissueLabel=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\ndocument.getElementById(\"desc\").innerText=issueLabel;\n}\n\t</Script>\n\t\t\n\t</head>\n\t<body class=\"body\" LEFTMARGIN=\'0\' RIGHTMARGIN=\'0\' topmargin=\'0\' width=\'100%\' bgcolor=\'#ffffff\' onLoad=\"checkUser();\" >\n\n\n<form name=\"LcToolbar_form\" id=\"LcToolbar_form\" >\n\n\t<table  width=\"100%\" cellspacing=\'0\' cellpading=\'0\' >\n\t\t<tr>\n\t\t<td class=\'PATIENTLINECOLOR\'  align=\"top\" colspan=\'12\'>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t</td>\n\t\t<td class=\'PATIENTLINECOLOR\' align=\'right\'>\n\t\t<img src=\"../../../eLC/core/images/mc_homepage.gif\" height=18\n\t\t\t\t\t\t\t\tonclick=\"this.src=\'../../../eLC/core/images/mc_homepage.gif\' ;home();\" />\n\t\t<img src=\"../../../eLC/core/images/mc_switch.gif\" height=18\n\t\t\t\t\t\t\t\tonclick=\"this.src=\'../../../eLC/core/images/mc_homepage.gif\' ;switchFunction();\" />\n\t\t<img src=\"../../../eLC/core/images/mc_close.gif\" height=18\n\t\t\t\t\t\t\t\tonclick=\"this.src=\'../../../eLC/core/images/mc_close.gif\' ;closeWindow();\" />\n\t\t</td >\n\t\t</tr>\n\t\t</table>\n\t\t<table  width=\"100%\" cellspacing=\'0\' cellpading=\'0\'>\n\t\t<tr>\n\t\t\t<td  align=\"left\" width=\"100%\" >\n\t\t\t\t<table cellspacing=\'0\' cellpading=\'0\'  >\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'3\'></td>\n\t\t\t\t\t<td class=\'label\'><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</b></td>\n\t\t\t\t\t<td colspan=\'\'></td>\n\t\t\t\t\t<td class=\'label\' colspan=\'5\' ><b><center>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</b></center></td>\n\t\t\t\t\t<td colspan=\'2\'></td>\n\t\t\t\t</tr>\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td nowrap=\"false\">\n\t\t\t\t\t\t\t<img id=\"create\"  src=\"../../../eLC/core/images/L-Issue1.gif\"\n\t\t\t\t\t\t\t\tonclick=\"displayLabel(\'I\');IssueLinen();changeImg(this);parent.messageFrame.location.href=\'MessageFrame.jsp\'\"\n\t\t\t\t\t\t\t\tvalue=\'Create\' name=\'create\' ></img>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t<td width=10%>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td nowrap=\"false\" align=\"right\">\n\t\t\t\t\t\t\t<img id=\"Cleaning\" src=\"../../../eLC/core/images/W-Cleaning1.gif\" onclick=\"cleaning();displayLabel(\'Cl\');changeImg(this);parent.messageFrame.location.href=\'MessageFrame.jsp\'\"\n\t\t\t\t\t\t\tname=\'load\' />\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td nowrap=\"false\" align=\"center\">\n\t\t\t\t\t\t\t<img id=\"Entry\" src=\"../../../eLC/core/images/L-Entry1.gif\" onclick=\"this.src=\'../../../eLC/core/images/L-Entry2.gif\' ;displayLabel(\'E\');EnterLinen();changeImg(this);parent.messageFrame.location.href=\'MessageFrame.jsp\'\"\n\t\t\t\t\t\t\t\tvalue=\'Entry\'/>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td nowrap=\"false\" align=\"left\">\n\t\t\t\t\t\t\t<img id=\"Delivery\" src=\"../../../eLC/core/images/L-Delivery1.gif\"  onclick=\"displayLabel(\'D\');delivery1();changeImg(this);parent.messageFrame.location.href=\'MessageFrame.jsp\'\" name=\'Delivery\'/>\n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t<td width=10%>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td nowrap=\"false\" align=\"right\">\n\t\t\t\t\t\t\t<img id=\"mendingS\" src=\"../../../eLC/core/images/L-MendingSend1.gif\"  \n\t\t\t\t\t\t\t\tonclick=\"displayLabel(\'M\');changeImg(this);sendMending();parent.messageFrame.location.href=\'MessageFrame.jsp\'\"\n\t\t\t\t\t\t\t\tname=\'mendingS\' ></img>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td  nowrap=\"false\">\n\t\t\t\t\t\t\t<img id=\"mendingR\" src=\"../../../eLC/core/images/L-MendingRecive1.gif\"  \n\t\t\t\t\t\t\t\tonclick=\"displayLabel(\'R\');changeImg(this);receiveMending();parent.messageFrame.location.href=\'MessageFrame.jsp\'\"\n\t\t\t\t\t\t\t\t name=\'mendingR\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=10%>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td nowrap=\"false\" align=\"right\">\n\t\t\t\t\t\t\t<img id=\'Lcomplaint\'  src=\"../../../eLC/core/images/L-Complaint1.gif\"  \n\t\t\t\t\t\t\t\tonclick=\"complaint();displayLabel(\'C\');changeImg(this)\n\t\t\t\t\t\t\t;parent.messageFrame.location.href=\'MessageFrame.jsp\'\"\n\t\t\t\t\t\t\tname=\'Lcomplaint\' ></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td nowrap=\"false\">\n\t\t\t\t\t\t\t<img id=\"writeoff\" src=\"../../../eLC/core/images/L-Writeoff1.gif\"  onclick=\"writeOff(); ;displayLabel(\'W\');changeImg(this);parent.messageFrame.location.href=\'MessageFrame.jsp\'\"\n\t\t\t\t\t\t\t\t name=\'writeoff\' ></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td  class=\'label\' nowrap=\"false\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=10% nowrap=\"false\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td id=\"cleaningLabel\" class=\'label\' nowrap=\"false\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' nowrap=\"false\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' nowrap=\"false\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=10%>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' nowrap=\"false\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=10%>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td  class=\'label\' nowrap=\"false\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr class=\"PATIENTLINECOLOR\">\n\t\t<td id=\"desc\" align=\"left\" class=\"PATIENTLINECOLOR\" colspan=\'9\'>\n\t\t</td>\n\t\t</tr></table>\n\t\t<input type=\"hidden\" name=\"LaundryConf\" id=\"LaundryConf\" />\n</form>\n</body>\n</html> \n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

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
            _bw.write(_wl_block11Bytes, _wl_block11);

		String textLabel=(String)session.getAttribute("textLabel");
		String functionLabel=(String)session.getAttribute("functionLabel");
		if(textLabel==null)textLabel="";
		if(functionLabel==null)functionLabel="";
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";

		String loggedInUser = (String) session.getAttribute("login_user"); 
		String facilityId=(String)session.getAttribute("facility_id");

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
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(loggedInUser));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(loggedInUser));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
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
         org.apache.struts.taglib.bean.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.issueOfLinen", java.lang.String .class,"key"));
        __tag0.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
         org.apache.struts.taglib.bean.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.deliverCleanedLinen", java.lang.String .class,"key"));
        __tag1.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
         org.apache.struts.taglib.bean.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.enterCleanedLinen", java.lang.String .class,"key"));
        __tag2.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
         org.apache.struts.taglib.bean.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.writeofflinen", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.sendLinenForMending", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receivelinenaftermending", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.requestForCleaningLinen", java.lang.String .class,"key"));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.lodgeComplaint", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.externalCleaning.externalCleaningReq", java.lang.String .class,"key"));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.laundry", java.lang.String .class,"key"));
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

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.cleaning", java.lang.String .class,"key"));
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.mending", java.lang.String .class,"key"));
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

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.issue", java.lang.String .class,"key"));
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

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.request", java.lang.String .class,"key"));
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

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.entry", java.lang.String .class,"key"));
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

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.delivery", java.lang.String .class,"key"));
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

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.send", java.lang.String .class,"key"));
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

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receive", java.lang.String .class,"key"));
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

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.complaint", java.lang.String .class,"key"));
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

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
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
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.write-off", java.lang.String .class,"key"));
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
}
