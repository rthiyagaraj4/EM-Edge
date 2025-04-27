package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __backgroundprocessaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/BackGroundProcessAddModify.jsp", 1741082812775L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n\t<head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eSM/js/BackGroundProcesses.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction refreshmsg()\n\t\t{\n\t\t\tif(self.document.forms[0].mode.value==\"modify\")\n\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t}\n\t\tasync function Search()\n\t\t{\n\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\tvar retVal;\n\t\t\tvar dialogHeight= \"80vh\" ;\n\t\t\tvar dialogWidth\t= \"60vw\" ;\n\t\t\tvar dialogTop = \"200\" ;\n\t\t\tvar dialogLeft = \"144\" ;\n\t\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\tvar status=\"no\";\n\t\t\tvar title=getLabel(\"eSM.BackGroundProcesses.label\",\"SM\");\n\t\t\tvar features\t= \"dialogLeft: \"+ dialogLeft + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop+\";dialogTitle :\"+title;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar url = \"../../eSM/jsp/SearchProcMain.jsp?procid=\"+document.BackGroundProcess.proc_id.value;\n\n\t\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\t\t\tif(retVal!=null)\t\n\t\t\t{\n\t\t\t\tvar a = retVal.split(\"`\");\n\t\t\t\tdocument.forms[0].proc_id.value=a[0];\n\t\t\t\tgetproc_name(a[0]);\n\t\t\t}\n\n\t\t\treturn retVal;  \n\n\t\t}\n\t\tfunction aa()\n\t\t{\n\t\t\t\tgetproc_name(document.forms[0].proc_id.value);\n\t}\n\t\tfunction getproc_name(p)\n\t\t{\n\n\t\t\tvar HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'GetProcName.jsp?proc_id=\"+p+\"\'></form></BODY></HTML>\";\n\n\t\t\n\t\t\tparent.parent.messageFrame.document.write(HTMLVal);\n\t\t\tparent.parent.messageFrame.document.forms[0].submit();\n\n\t\t\t\t//document.forms[0].Submit.disabled=false;\n\t\t\t\tdocument.forms[0].mode.value=\"insert\";\n\t\t\t\tdocument.forms[0].next_execution_date.value=convertDate(document.forms[0].sys_Date.value,\"DMYHM\",\"en\",localeName);\n\t\t\t\tdocument.forms[0].interval.value=\"\";\n\n\t\t}\n\n\t\tfunction CheckInterval(obj)\n\t\t{\n\t\n\t\t\tif(obj.value!=\"\")\n\t\t\t{\n\t\t\tif(obj.value>0){\n\t\t\t\tCheckPositiveNumber(obj);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t\n\t\t\t\talert(getMessage(\'ONLY_POSITIVE_NUM\',\'SM\'));\n\t\t\t\tobj.select();\n\t\t\t\tobj.value=\"\";\n\t\t\t\tobj.focus();\n\t\t\t}\n\t\t\t}\n\t\t\t\t\n\t\t}\n\t\t\n\t\tfunction callproc()\n\t\t{\n\t\t\tif(document.forms[0].proc_id.value==\"\")\n\t\t\t{  \n\t\t\t\t\n\t\t\t\tvar msg=getMessage(\"PROC_ID_NOT_BLANK\",\'SM\');\n\t\t\t\talert(msg);\n\t\t\t\treturn false\n\t\t\t}\n\t\t    if(document.forms[0].next_execution_date.value==\"\")\n\t\t\t{\n\t\t\t\tvar msg=getMessage(\"NXT_EXE_TIME_NOT_BLANK\",\"SM\");\n\t\t\t\talert(msg);\n\t\t\t\treturn false\n\t\t\t\n\t\t\t\t\n\t\t\t}\n\t\t\tdocument.forms[0].job_type.value=\"S\";\n\t\t\tparent.frames[2].document.forms[0].action=\"../../servlet/eSM.BackGroundProcessServlet\";\n\t\t\tparent.frames[2].document.forms[0].target=\"messageFrame\";\n\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t}\n\t\tfunction callproc1()\n\t\t{\n\t\t\tdocument.forms[0].job_type.value=\"C\";\n\t\t\tparent.frames[2].document.forms[0].action=\"../../servlet/eSM.BackGroundProcessServlet\";\n\t\t\tparent.frames[2].document.forms[0].target=\"messageFrame\";\n\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t}\n\t\t\n\t\tfunction callproc2()\n\t\t{\n\t\n\t\t\tvar msg=getMessage(\"JOB_IS_RUNNING\",\'SM\');\n\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;\n\t\t\t//alert(msg)\n\t\t\tdocument.forms[0].job_type.value=\"E\";\n\t\t\tparent.frames[2].document.forms[0].action=\"../../servlet/eSM.BackGroundProcessServlet\";\n\t\t\tparent.frames[2].document.forms[0].target=\"messageFrame\";\n\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t\n\t\t\t//parent.frames[2].document.forms[0].Submit.disabled=false;\n\t\t\tparent.frames[2].document.forms[0].Change.disabled=true;\n\t\t\tparent.frames[2].document.forms[0].Remove.disabled=true;\n\t\t}\n\t\t\n\t\tfunction callproc3()\n\t\t{\n\t\t\tdocument.forms[0].job_type.value=\"R\";\n\t\t\tparent.frames[2].document.forms[0].action=\"../../servlet/eSM.BackGroundProcessServlet\";\n\t\t\tparent.frames[2].document.forms[0].target=\"messageFrame\";\n\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t\n\t\t}\n\n/** Added for Date Validation **/\n\n\t\tfunction ValidateDateTimesp(obj)\n\t\t{\n\t\t\tif(!(obj.value==\"\"))\n\t\t\t{\n\t\t\t\tif(validDateObj(obj,\"DMYHM\",localeName))\n\t\t\t\t{\n\t\t\t\t\tif(!(isAfterNow(obj.value,\"DMYHM\",localeName)))\n\t\t\t\t\t {\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\t\talert(getMessage(\'DT_NLT_CURR_DT\',\'SM\'));\n\t\t\t\t\t  }\n\t\t\t\t}\n\t\t\t }\n\t\t}\n\n\t/*\tfunction newfn(obj)\n\t\t{\n\t\t\tif(!(obj.value==\"\"))\n\t\t\t{\n\t\t\tif(callme(obj))\n\t\t\t\t{\t\n\t\t\t\tif(!ValidateDateTime(document.forms[0].sys_Date,obj))\n\t\t\t\t\talert(getMessage(\'DT_NLT_CURR_DT\',\'SM\'));\n\t\t\t\t}\n\t\t\t}\n\t\t}\nfunction ValidateDateTime(from,to)\n{\n\tfrom = from.value\n\tto\t\t= to.value\n\tvar a=  from.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\t\n\tvar splitdate1 =a[0].split(\"/\")\n\tvar splittime1= a[1].split(\":\")\n\tvar from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\t a=  to.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\t splitdate1 =a[0].split(\"/\")\n\t splittime1= a[1].split(\":\")\n\t\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\t if(Date.parse(to_date) < Date.parse(from_date))\n\t\t\treturn false\n\telse\n\t\t\treturn true;\t\n}\n\nfunction callme(obj)\n{\n\t        var comp=obj\n            obj=obj.value\n            var dttime = obj.split(\" \");\n            var dt\n            var time\n            var retval=true\n            if(dttime.length>1)\n            {\n                dt=dttime[0]\n                time=dttime[1]\n\t\t\t\t\n                if(!checkDt1(dt) )\n                {\n                    retval= false\n                    comp.focus()\n                }\n                else\n                {\n                 \n\t\t\t\t\tif(time==null || time==\"\")\n                    {\n                        alert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n                        comp.focus()\n                    }\n\n                    else\n                    {\t\n\n                        if(!chkTime(time))\n                        {\n                                retval= false\n                                alert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n                                comp.focus()\n                        }\n                    }\n                }\n            }\n            else\n            {\n                retval= false\n                alert(getMessage(\"INVALID_DATE_TIME\",\"SM\"))\n                comp.focus()\n            }\n\n            if(retval)\n            {\n                \n            }\n        return retval\n}\n\t\t function checkDt1(date1)\n        {\n            retval=true\n            var date1arr=new Array()\n\n            date1arr=date1.split(\"/\")\n\n            if(date1arr.length==3)\n            {\n                var date1d=date1arr[0]\n                var date1m=date1arr[1]\n                var date1y=date1arr[2]\n\n                date1d=parseInt(date1d)\n                date1m=parseInt(date1m)\n                date1yy=parseInt(date1y);\n\n\t\t\t\tif (date1m>12 || date1m<1)  return false;\n\n                if(date1m<=12)\n                {\n\n                    if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31 || date1d < 1))\n                    {\n                    retval= false}\n\n                    if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30 || date1d < 1))\n                    {\n                    retval= false}\n\n                    if ((date1y.length <4) || (date1y.length >4))\n                        {\n                        retval= false}\n\t\t\t\t\tif (date1m == 2) \n\t\t\t\t\t{\n\t\t\t\t\t\tif (date1d < 1) return false;\n\t\t\t\t\t\tif (LeapYear(date1y) == true) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif (date1d > 29) return false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif (date1d > 28) return false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n                 }\n                else\n                    {\n                    retval= false;}\n            }\n            else\n                {retval= false;}\n                return retval;\n            }\n\n        function chkTime(time1)\n        {\t\t\t\t\n\n            var retval=true;\n\n            if( (time1.charAt(time1.length-1) )!=\":\")\n            {\n                var time1arr=new Array()\n                time1arr=time1.split(\":\")\n\n                if( isNaN(parseInt(time1arr[0])))   return false ;\n                if( isNaN(parseInt(time1arr[1])))   return false ;\n\n                if(time1arr.length==2)\n                {\n\n                    var time1hr=time1arr[0]\n                    var time1min=time1arr[1]\n\n                    time1hr=parseInt(time1hr)\n                    time1min=parseInt(time1min)\n                    if(time1hr<=23)\n                    {\n                        if(time1min>=60)\n                        {\n                                retval=false;\n                              \n                        }\n                    }\n                    else\n                            retval=false;\n\n                }\n                else\n                    retval=false;\n\n            }\n            else\n                    retval=false;\n\n\n            return retval\n        }\n\n\n\nfunction LeapYear(strYear) {\n    if (strYear % 100 == 0) {\n        if (strYear % 400 == 0)  return true;\n    }\n    else {\n        if ((strYear % 4) == 0)  return true;\n    }\n    return false;\n}*/\n\n\nfunction ValidateDate(from,to,messageFrame) {\n\tvar fromarray; var toarray;\n\tvar fromdate = from.value ;\n\tvar todate = to.value ;\n\tif(fromdate.length > 0 && todate.length > 0 ) {\n\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\ttoarray = todate.split(\"/\");\n\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\t\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\t\tvar errormess = getMessage(\"NOSHOW_FM_DT_VALIDATION\",\'SM\');  \n\t\t\t\talert(errormess);\n\t\t\t\t//from.select();\n\t\t\t\tfrom.value=\"\";\n\t\t\t\t\t\t\t//from.focus();\n\t\t\t}\n\t}\t\n}\n\n\nfunction ValidateDate1(from,to,messageFrame) {\n\tvar fromarray; var toarray;\n\tvar fromdate = from.value ;\n\tvar todate = to.value ;\n\tif(fromdate.length > 0 && todate.length > 0 ) {\n\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\ttoarray = todate.split(\"/\");\n\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\t\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\talert(getMessage(\"OUTCOME_DT_GT_DIAG_DATE\",\'SM\'));\n\t\t\t\t//to.select();\n\t\t\t\t//to.focus();\n\t\t\t\tto.value=\"\";\n\t\t\t}\n\t}\t\n}\n\nfunction CheckPositiveNumber1(obj) {\n\tif ( obj.value!=null && trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0)\n\t\t{\t\t\n\t}\n\telse {\n  \t\tif ( obj.value.length > 0 ) {\n  \t\t\talert(getMessage(\'ONLY_POSITIVE_NUM\',\'SM\'));\n  \t\t\t//obj.select();\n  \t\t\t//obj.focus();\n  \t\t\tobj.value=\"\";\n  \t\t}\n  \t\telse if ( obj.value.length == 0 );\n  \t\n  \t}\n}\n\n\t\t</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n      <script>parent.parent.frames[1].location.reload();parent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+getMessage(\"JOB_DOESNOT_EXIST\",\"SM\")+\'&err_value=0\';  </script>\n\t\n\t  \n\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onload=\'refreshmsg()\' onKeyDown = \'lockKey()\' onmousedown=\'CodeArrest()\'>\n<form name=\'BackGroundProcess\' id=\'BackGroundProcess\'  action=\"../../servlet/eSM.BackGroundProcessServlet\" method=\'post\' target=\'messageFrame\'>\n<table border=0 cellspacing=0 cellpadding=0 width=\'100%\'>\n\t<th width=\'100%\' colspan=6 align=left>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t<tr>\n\t\t<td width=\'2%\'>&nbsp;</td>\n\t\t<td width=\'24%\'>&nbsp;</td>\n\t\t<td width=\'24%\'>&nbsp;</td>\n\t\t<td width=\'24%\'>&nbsp;</td>\n\t\t<td width=\'24%\'>&nbsp;</td>\n\t\t<td width=\'2%\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td>&nbsp;</td>\n\t\t<td class=label>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\"fields\"><input type=\'text\' name=\'proc_id\' id=\'proc_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' size=18 maxlength=30 onblur=\'if(this.value!=\"\") Search()\'><input type=\'button\' name=\'?\' id=\'?\' value=\'?\' class=\'button\' onclick=\'Search()\'> <img align=center src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t<td class=label >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\"fields\"><input type=\'text\' name=\'proc_name\' id=\'proc_name\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' size=30 maxlength=30 readonly> </td>\n\t\t<td>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=6>&nbsp;</td>\n\t</tr>\n\t<tr>\n\n\t\t<td>&nbsp;</td>\n\t\t<td class=label >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=\"fields\"><input type=\'text\' id=\'next_execution_date\' name=\'next_execution_date\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  onblur=\'ValidateDateTimesp(this)\' size=16 maxlength=16><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\" return showCalendar(\'next_execution_date\',null,\'hh:mm\')\"> \n      <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t<td class=label>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td class=\"fields\"><input type=\'text\' name=\'interval\' id=\'interval\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' size=9 maxlength=9 onblur=\'CheckInterval(this)\'></td>\n\t\t<td>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=6>&nbsp;</td>\n\t</tr>\n</table>\n<table align=right border=0 cellspacing=0 cellpadding=0>\n\t<tr>\n\t\t<td class=\"fields\"><input type= \'button\' class=\'button\' name= \'Submit\' id= \'Submit\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onclick=\'callproc()\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="></td>\n\t\t<td class=\"fields\"><input type= \'button\' class=\'button\' name= \'Change\' id= \'Change\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onclick=\'callproc1()\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="></td>\n\t\t<td class=\"fields\"><input type= \'button\' class=\'button\' name= \'Run\' id= \'Run\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onclick=\'callproc2()\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></td>\n\t\t<td class=\"fields\"><input type= \'button\' class=\'button\' name= \'Remove\' id= \'Remove\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onclick=\'callproc3()\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\t</td>\n\t</tr>\n</table>\n<input type=\'hidden\' name=\'job_type\' id=\'job_type\' value=\'\'> \n<input type=\'hidden\' name=\'job\' id=\'job\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'sys_Date\' id=\'sys_Date\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'proc_srt_cmd\' id=\'proc_srt_cmd\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\'  value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'procid\' id=\'procid\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'isConOGGApplicable\' id=\'isConOGGApplicable\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n</form>\n</body>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
String locale		= (String)session.getAttribute("LOCALE");
String proc_id      =  request.getParameter("proc_id");


if(proc_id==null) proc_id="";

String proc_name="";
String next_execution_date="";
String interval="";
String job="";
String proc_srt_cmd="";

String sql="";
String mode="insert";
String dis_submit="disabled";
String dis_submit1="disabled";

String sys_Date="";

Connection con=null;
Statement stmt=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
CallableStatement  cs = null;

try{
	con = ConnectionManager.getConnection(request);

	boolean isConOGGApplicable	= CommonBean.isSiteSpecific(con, "SM","GGS_OWNER_BKG_JOB");


	stmt = con.createStatement();	
	String syssql = "select to_char(sysdate,'dd/mm/yyyy hh24:mi')  from dual";
	ResultSet rssql=stmt.executeQuery(syssql) ;
	if(rssql!=null)
	{
	 while(rssql.next())
	 {
		sys_Date = rssql.getString(1);
		next_execution_date=sys_Date;
	 }
	}
	if(rssql!=null)rssql.close();
	if(stmt!=null)stmt.close();
	sql=" Select proc_name, to_char(next_execution_date,'dd/mm/yyyy hh24:mi') next_execution_date1, rtrim(rtrim(rtrim(rtrim(ltrim(ltrim(ltrim(ltrim(lower(interval)),'sysdate')),'+')),'1440')),'/') interval1, job, proc_srt_cmd from sm_jobs_vw where proc_id='"+proc_id+"' ";

	
	stmt = con.createStatement();	
	rs=stmt.executeQuery(sql);
	if(rs!=null)
	{
		while(rs.next())
		{
			proc_name=rs.getString("proc_name");
			if(proc_name==null) proc_name="";

			next_execution_date=rs.getString("next_execution_date1");
			if(next_execution_date==null) next_execution_date="";

			interval=rs.getString("interval1");
			if(interval==null) interval="";
			else if(interval.equals("null")) interval="";

			job=rs.getString("job");
			if(job==null) job="";

			proc_srt_cmd=rs.getString("proc_srt_cmd");
			if(proc_srt_cmd==null) proc_srt_cmd="";

			mode="modify";
		}

	}
	else
	{
		mode="insert";
	
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	
	if(mode.equals("insert"))
	{   
		
		cs = con.prepareCall( "{ call CHK_JOB_QUEUE(?, ?)}");
			
			cs.setString ( 1,proc_srt_cmd   ) ;
			cs.registerOutParameter( 2,  Types.INTEGER ) ;
			cs.execute();
			int status=cs.getInt(2);
			if(status>0) 
			{
				dis_submit="disabled";
				out.println("<script>alert(getMessage('JOB_ALREADY_IN_QUEUE','SM'));</script>");
				
			}
	}


	if(mode.equals("modify") ) 
	{
		dis_submit="disabled";
		dis_submit1="";
	}
	else if(mode.equals("insert"))
	{
		dis_submit="disabled";
		dis_submit1="disabled";
	}


if(mode.equals("insert"))
	{


		String strsql2="select long_desc from sm_proc_id where controllable_yn='Y'  and proc_id='"+proc_id+"'";
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);
		if(rs!=null)
		{
			while(rs.next())
			{
				proc_name=rs.getString(1);
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	
	   if(!proc_id.equals(""))
		{pstmt=con.prepareStatement("select count(*) cnt  from sm_jobs_vw where   proc_id='"+proc_id+"'");
        
		rs=pstmt.executeQuery();
		rs.next();
		
		proc_id	="";
		proc_name="";
		next_execution_date="";
		interval="";
		if(rs.getInt("cnt")==0)
		{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
		}
	
	
	}
if(pstmt!=null)pstmt.close();
if(rs!=null)rs.close();
next_execution_date=DateUtils.convertDate(next_execution_date,"DMYHM","en",locale);

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(proc_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(proc_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(next_execution_date));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(interval));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Submit.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dis_submit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.change.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dis_submit1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.run.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dis_submit1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dis_submit1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(job));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sys_Date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(proc_srt_cmd));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(proc_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(isConOGGApplicable));
            _bw.write(_wl_block32Bytes, _wl_block32);

		if(stmt!=null) stmt.close();
		if(cs!=null) cs.close();
		
	}catch(Exception e){out.println(e);}
finally {
		ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcessDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcessID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcessName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.NextExecutionDateTime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Interval(min).label", java.lang.String .class,"key"));
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
}
