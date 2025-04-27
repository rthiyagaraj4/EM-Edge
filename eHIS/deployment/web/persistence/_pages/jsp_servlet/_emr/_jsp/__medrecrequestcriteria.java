package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __medrecrequestcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedRecRequestCriteria.jsp", 1732179890450L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n\tModule\t\t\t:\teMR\n\tModified On\t\t:\t12/05/2005\n\tModified By\t\t:   Vinod Babu for View Death Register\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n<link rel=\"stylesheet\" type=\"text/css\"\n\thref=\"../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"></link>\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\'javascript\'\n\tsrc=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\'javascript\'\n\tsrc=\"../../eMR/js/MedRecRequestCriteria.js\"></script>\n<script language=\'javascript\' src=\"../../eMR/js/MedRecRequestMain.js\"></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script>\nfunction CompareDates(from, to)\n{\n\tif(from.value !=\'\' && to.value !=\'\')// DateUtils.js\n\t{\n\t\tvar fromDt\t= convertDate(document.forms[0].from_date.value,\"DMY\",localeName,\"en\");\n\t\tvar toDt\t= convertDate(document.forms[0].to_date.value,\"DMY\",localeName,\"en\");\n\t\tif(!isBefore(fromDt,toDt,\'DMY\',localeName))// DateUtils.js\n\t\t{\n\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\tdocument.forms[0].to_date.value = \'\';\n\t\t\tdocument.forms[0].to_date.select();\n\t\t}\n\t}\n}\n\nfunction validate_date(obj) {\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar from = convertDate(obj.value,\"DMY\",locale,\"en\");\n\t   var to   = document.forms[0].SystemDate.value;\n       var fromarray;\n\t\tvar toarray;\n\t\tfromarray  = from.split(\"/\");\n\t\ttoarray    = to.split(\"/\");\n\t\tvar fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);\n\t\tvar todt = new Date(toarray[2],toarray[1]-1,toarray[0]);\n\t\tif (CheckDate(obj)){\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\t\t\tvar invaldt = getMessage(\"DATE1_GT_DATE2\",\'IP\') ;\n\t\t\t\t\tvar census_date_from=(getLabel(\"eMR.EncPeriod.label\",\"MR\"));\n\t\t\t\t\tvar sys_date=getLabel(\"Common.CurrentDate.label\",\"Common\");\n\t\t\t\t\tinvaldt=invaldt.replace(\'$\',census_date_from);\n\t\t\t\t\tinvaldt=invaldt.replace(\'#\',sys_date);\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\tobj.focus();\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\nfunction validateDate(obj){\n\nif(obj.value!=\"\")\n\t{\n\tif(!validDateObj(obj,\"DMYHM\",localeName))\n\t\t{\n\t\t\tobj.value=\"\";\n\t\t\t\n\t\t\treturn ;\n\t\t}\n\t}\n}\n\nfunction callcheck_val()\n{ \n\tif (document.forms[0].discharge_val.checked==true)\n\t\tdocument.forms[0].discharge_val.value=\"Y\";\n\telse\n\t\tdocument.forms[0].discharge_val.value=\"N\";\n}\n\n//Func will return an alert message if FROM DATE is null and TO Date is selected\nfunction checkFromDt(to,frmDt)\n{\n\tif ( (frmDt.value==\'\') && (to.value!=\'\') )\n\t{\n\t\terror  = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\', getLabel(\"Common.fromdate.label\",\"Common\"));\t\t\n\t\talert(error);\n\t\tto.value=\'\';\n\t\tfrmDt.focus();\n\t\treturn false;\n\t}\n}\n\nfunction doDcsdDateCheck(from,to) {\n    var fromarray; var toarray;\n    var fromdate = from.value ;\n    var todate = to.value ;\n\tif(fromdate.length > 0 && todate.length > 0 ) {\n            fromarray = fromdate.split(\"/\");\n            toarray = todate.split(\"/\");\n            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);\n            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);\n\t\t\t\n            if(Date.parse(todt) <= Date.parse(fromdt)) {\n                return false;\n            }\n            else if(Date.parse(todt) > Date.parse(fromdt)) return true;\n    }\n\treturn true;\n}\n\nfunction DscdPeriodChk(Dt)\n{\t\n\tif(Dt.value!=\"\")\t\n\t{\n\t\tvar SystemDate\t= document.forms[0].SystemDate.value;\n\t\tif(validDate(Dt.value,\"DMY\",\"en\"))\n\t\t{\n\t\t\tvar toDt\t= convertDate(Dt.value,\"DMY\",localeName,\"en\");\n\t\t\tif(!isAfter(SystemDate,toDt,\'DMY\',localeName))// DateUtils.js\n\t\t\t{\n\t\t\t\terror=getMessage(\"MRDATE1_GT_DATE2\",\"MR\");\n\t\t\t\terror = error.replace(\'$\', getLabel(\"eMR.DeceasedPeriod.label\",\"MR\"));\t\t\n\t\t\t\terror = error.replace(\'#\', getLabel(\"Common.CurrentDate.label\",\"Common\"));\t\n\t\t\t\talert(error);\n\t\t\t\tDt.value=\'\';\n\t\t\t\tDt.focus();\n\t\t\t}\n\t\t}\n\t}\n\treturn;\n}\n\nfunction doDischargeDateCheck(obj1,obj2)\n{\n\tvar a=obj1.split(\" \")\n\tsplitdate=a[0];\n\tsplittime=a[1]\n\n\tvar splitdate1 = a[0].split(\"/\")\n\n\t var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));\n\n\t a=obj2.split(\" \")\n\t splitdate=a[0];\n\t splittime=a[1]\n\n\t splitdate1 = a[0].split(\"/\")\n\t var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));\n\t if(Date.parse(to_date) < Date.parse(from_date))\n\t{\n\t\treturn false;\n\t}\n\telse\n\t\treturn true;\n}\n\nfunction disChargePeriodChk(Dt)\n{\n\tif(Dt.value!=\"\")\n\t{\t\n\t\tif(validDate(Dt.value,\"DMYHM\",\"en\"))\n\t\t{\n\t\t\tvar toDt\t= convertDate(Dt.value,\"DMYHM\",localeName,\"en\");\n\t\t\tif(!isBeforeNow(toDt,\"DMYHM\",\"en\"))// DateUtils.js\n\t\t\t{\n\t\t\t\terror=getMessage(\"MRDATE1_GT_DATE2\",\"MR\");\n\t\t\t\t//error = error.replace(\'$\', getLabel(\"eMR.DeceasedPeriod.label\",\"MR\"));\t\n\t\t\t\terror = error.replace(\'$\', getLabel(\"eMR.DischPeriod.label\",\"MR\"));\t\n\t\t\t\terror = error.replace(\'#\', getLabel(\"Common.CurrentDate.label\",\"Common\"));\t\n\t\t\t\talert(error);\n\t\t\t\tDt.value=\'\';\n\t\t\t\tDt.focus();\n\t\t\t}\n\t\t}\n\t}\n\treturn;\n}\n\n\n//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] \n//Func will return an alert message if TO DATE is Less than FROM DATE\nfunction ComparePeriodFromToTime(from,to)\n{\n\tvar frdt = from.value;\n\tvar tdt = to.value;\n\n\tif(frdt !=\'\' && tdt !=\'\' )// DateUtils.js\n\t{\n\t\tif(validDate(frdt,\"DMY\",\"en\") && validDate(tdt,\"DMY\",\"en\"))\n\t\t{\n\t\t\tvar fromDt\t= convertDate(frdt,\"DMY\",localeName,\"en\");\n\t\t\tvar toDt\t= convertDate(tdt,\"DMY\",localeName,\"en\");\n\n\t\t\tif(!isBefore(fromDt,toDt,\'DMY\',localeName))// DateUtils.js\n\t\t\t{\n\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\tto.value = \'\';\n\t\t\t\tto.focus();\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction CompareDisPeriodFromToTime(from,to)\n{\n\tvar frdt = from.value;\n\tvar tdt = to.value;\n\n\tif(frdt !=\'\' && tdt !=\'\' )// DateUtils.js\n\t{\n\t\tif(validDate(frdt,\"DMYHM\",\"en\") && validDate(tdt,\"DMYHM\",\"en\"))\n\t\t{\n\t\t\tvar fromDt\t= convertDate(frdt,\"DMYHM\",localeName,\"en\");\n\t\t\tvar toDt\t= convertDate(tdt,\"DMYHM\",localeName,\"en\");\n\n\t\t\tif(!isBefore(fromDt,toDt,\'DMYHM\',localeName))// DateUtils.js\n\t\t\t{\n\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\tto.focus();\n\t\t\t}\n\t\t}\n\t}\n}\n\n\nfunction CompareAltPeriodFromToTime(from,to)\n{\n\tvar frdt = from.value;\n\tvar tdt = to.value;\n\n\tif(frdt !=\'\')\n\t{\n\t\tt1 =false;\n\t\tt1 = CheckDate(from);\n\t\tif(!t1)\n\t\t{\n\t\t\t//alert(getMessage(\"INVALID_DATE_TIME\",\"SM\"));\n\t\t\tfrom.value=\"\";\n\t\t\tfrom.focus();\n\t\t\treturn;\n\t\t}\n\t\t\n\t}\n\tif(tdt !=\'\')\n\t{\n\t\tt1 =false;\n\n\t\tt1 = CheckDate(to);\t\n\t\t\n\t\tif(!t1)\n\t\t{\n\t\t\t//alert(getMessage(\"INVALID_DATE_TIME\",\"SM\"));\n\t\t\tto.value=\"\"; \n\t\t\tto.focus();\n\t\t\treturn;\n\t\t}\n\t}\n\n\tif (!PeriodcheckDateTime(frdt,tdt) )\n\t{\n\t\t  to.focus();\n\t\t  to.select();\n\t}\n\t\n}\n\n\n//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] \n//Func will return an alert message if TO DATE is Less than FROM DATE\n//This function only used for Comparison of Deceased Period only\nfunction CompareDeceasedPeriod(from,to)\n{\n\tvar frdt = from.value;\n\tvar tdt = to.value;\n\n\tif(frdt !=\'\')\n\t{\n\t\tvar t1 =false;\n\t\tt1 = CheckDate(from);\n\t\tif(!t1)\n\t\t{\n\t\t\tfrom.value=\"\";\n\t\t\tfrom.focus();\n\t\t\treturn;\n\t\t}\n\t\t\n\t}\n\tif(tdt !=\'\')\n\t{\n\t\tvar t1 =false;\n\t\tt1 = CheckDate(to);\t\n\t\t\n\t\tif(!t1)\n\t\t{\n\t\t\tto.value=\"\"; \n\t\t\tto.focus();\n\t\t\treturn;\n\t\t}\n\t}\n\n\tif (!PeriodcheckDateTime(frdt,tdt) )\n\t{\n\t\t  \n\t\t  to.focus();\n\t\t  to.select();\n\t}\n\t\n}\n\n\n\n\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body onLoad=\"FocusFirstElement()\" OnMouseDown=\"CodeArrest()\"\n\tonKeyDown=\'lockKey()\'>\n\t<form name=\'search_form\' action=\"../../eCommon/jsp/report_options.jsp\"\n\t\ttarget=\"messageFrame\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table cellpadding=\'2\' border=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<br></td>\n\t\t\t\t<td width=\"25%\" class=\"fields\"><input type=text\n\t\t\t\t\tname=\'PatientId\' id=\'PatientId\' size=\"\"\n\t\t\t\t\tmaxlength=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\t\t\t\t\tonBlur=\"makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);\"\n\t\t\t\t\tonKeypress=\'return CheckForSpecChars(event);\' align=\"center\"><input\n\t\t\t\t\ttype=\'button\' name=\'patient_id\' id=\'patient_id\' value=\'?\'\n\t\t\t\t\tclass=\'button\' onclick=\'callSearchScreen()\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'patID_img\' style=\"visibility: visible\"></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\n\t\t\t\t<!--PatValidations(document.forms[0].PatientId); added on 31-07-08 for SCR 4964-->\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<td width=\"25%\" class=\'label\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\"><select name=\"cause_ind\" id=\"cause_ind\">\n\t\t\t\t\t\t<option>\n\t\t\t\t\t\t\t---\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t---\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</select></td>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\"><select name=\'marked_status\'\n\t\t\t\t\tid=\'marked_status\'>\n\t\t\t\t\t\t<option value=\'\'>\n\t\t\t\t\t\t\t---\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t---\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'O\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<option value=\'M\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<!-- <td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td> -->\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" <select name=\"lstPatientClass\" id=\"lstPatientClass\"\n\t\t\t\t\tonchange=\"clearResultPage(this)\">\n\t\t\t\t\t\t<option value=\'IP\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<select name=\"lstPatientClass\" id=\"lstPatientClass\"\n\t\t\t\t\t\tonchange=\"clearResultPage(this)\">\n\t\t\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t\t---\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t---\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t<select name=\"lstPatientClass\" id=\"lstPatientClass\"\n\t\t\t\t\t\t\tonchange=\"clearPage()\">\n\t\t\t\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t\t\t---\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t---\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'\n\t\t\t\t\t\t\tid=\'encType_img\' style=\"visibility: hidden\"></img>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="<br></td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=\"text\"\n\t\t\t\t\tname=\"alt_id1_exp_date\" id=\"alt_id1_exp_date\" size=\"10\"\n\t\t\t\t\tmaxlength=\'10\' id=\'altidexpdt1\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\");validate_date(this);ComparePeriodFromToTime(this,alt_id2_exp_date);\'\n\t\t\t\t\tonkeypress=\"return Valid_DT(event)\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></input><img\n\t\t\t\t\tid=\'enc1\' src=\'../../eCommon/images/CommonCalendar.gif\'\n\t\t\t\t\tonClick=\"document.forms[0].alt_id1_exp_date.focus();return showCalendar(\'alt_id1_exp_date\');\">-<input\n\t\t\t\t\ttype=\"text\" name=\"alt_id2_exp_date\" id=\"alt_id2_exp_date\" size=\"10\"\n\t\t\t\t\tmaxlength=\'10\' id=\'altidexpdate2\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\");validate_date(this);ComparePeriodFromToTime(alt_id1_exp_date,this);\'\n\t\t\t\t\tonkeypress=\"return Valid_DT(event)\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></input><img\n\t\t\t\t\tid=\'enc2\' src=\'../../eCommon/images/CommonCalendar.gif\'\n\t\t\t\t\tonClick=\"document.forms[0].alt_id2_exp_date.focus();return showCalendar(\'alt_id2_exp_date\');\"><img\n\t\t\t\t\tsrc=\'../../eCommon/images/mandatory.gif\' align=\'center\'\n\t\t\t\t\tid=\'encDate_img\' style=\"visibility: hidden\"></img></td>\n\t\t\t\t\t<!-- <td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\t\t -->\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"patID_img\").style.visibility = \"hidden\";\n//\t\t\t\tdocument.forms[0].alt_id1_exp_date.value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n//\t\t\t\tdocument.forms[0].alt_id2_exp_date.value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t<td class=\"fields\"><input name=\'p_discharge_date_from\'\n\t\t\t\t\tid=\'p_discharge_date_from\' id=\'dischargedatefrom\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\");ComparePeriodFromToTime(this,p_discharge_date_to);DscdPeriodChk(this);\'\n\t\t\t\t\tvalue=\'\' size=\'10\' maxlength=\'10\'\n\t\t\t\t\tonkeypress=\"return Valid_DT(event)\"></input><img\n\t\t\t\t\tsrc=\"../../eCommon/images/CommonCalendar.gif\"\n\t\t\t\t\tonClick=\"document.forms[0].p_discharge_date_from.focus();return showCalendar(\'p_discharge_date_from\');\"></input>-<input\n\t\t\t\t\tname=\'p_discharge_date_to\' id=\'p_discharge_date_to\'\n\t\t\t\t\tid=\'dischargedateto\' value=\'\' size=\'10\' maxlength=\'10\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\");ComparePeriodFromToTime(p_discharge_date_from,this);DscdPeriodChk(this);\'\n\t\t\t\t\tonkeypress=\"return Valid_DT(event)\"></input><img\n\t\t\t\t\tsrc=\"../../eCommon/images/CommonCalendar.gif\"\n\t\t\t\t\tonClick=\"document.forms[0].p_discharge_date_to.focus();return showCalendar(\'p_discharge_date_to\');\"></input></td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t<td class=\"fields\"><input name=\'p_discharge_date_from\'\n\t\t\t\t\tid=\'p_discharge_date_from\' id=\'dischargedatefrom\' value=\'\'\n\t\t\t\t\tsize=\'12\' maxlength=\'16\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\");CompareDisPeriodFromToTime(this,p_discharge_date_to);disChargePeriodChk(this);/*validateDate(this)*/\'><img\n\t\t\t\t\tid=\'d1\' src=\"../../eCommon/images/CommonCalendar.gif\"\n\t\t\t\t\tonClick=\"return showCalendar(\'p_discharge_date_from\',null,\'hh:mm\' );\"></input>-<input\n\t\t\t\t\tname=\'p_discharge_date_to\' id=\'p_discharge_date_to\'\n\t\t\t\t\tid=\'dischargedateto\' value=\'\' size=\'12\' maxlength=\'16\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\");CompareDisPeriodFromToTime(p_discharge_date_from,this);disChargePeriodChk(this);\'\n\t\t\t\t\tonkeypress=\"return Valid_DT(event)\"><img id=\'d2\'\n\t\t\t\t\tsrc=\"../../eCommon/images/CommonCalendar.gif\"\n\t\t\t\t\tonClick=\"return showCalendar(\'p_discharge_date_to\',null,\'hh:mm\' );\"></input><img\n\t\t\t\t\tsrc=\'../../eCommon/images/mandatory.gif\' align=\'center\'\n\t\t\t\t\tid=\'discDate_img\' style=\"visibility: hidden\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t<tr>\n\n\n\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=text\n\t\t\t\t\tname=\'p_encounter_id\' id=\'p_encounter_id\' size=\"12\" maxlength=\"12\"\n\t\t\t\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\t\t\t\tonBlur=\"CheckNumVal(this)\" align=\"center\"></td>\n\t\t\t\t<td class=\"label\" width=\"25%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" Min Data Set Type ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="<select name=\"orderBy\" id=\"orderBy\"\n\t\t\t\t\tonchange=\'clearResultPage(this)\'><option>\n\t\t\t\t\t\t\t---\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t---\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\"ED\" selected>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\"ET\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t</select> ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t<!-- <td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td> -->\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<!-- <td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td> -->\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"23%\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t<td class=\'fields\'><select name=\'status_to_show\'\n\t\t\t\t\tid=\'status_to_show\'>\n\n\t\t\t\t\t\t<option value=\"1\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\"7\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\"2\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t<option value=\"4\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t<option value=\"5\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\"6\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\"0\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\"\" selected>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t</select></td>\n\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\'text\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\");CompareDates(this,to_date);\'\n\t\t\t\t\tid=\"req_date_from\" maxlength=\'10\' size=\'10\' name=\'from_date\'\n\t\t\t\t\tvalue=\"\" onkeypress=\"return Valid_DT(event)\"><img\n\t\t\t\t\tsrc=\'../../eCommon/images/CommonCalendar.gif\'\n\t\t\t\t\tonClick=\"document.forms[0].req_date_from.focus();return showCalendar(\'req_date_from\');\">\n\t\t\t\t\t- <input type=\'text\'\n\t\t\t\t\tonblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\");CompareDates(this,from_date);\'\n\t\t\t\t\tid=\"req_date_to\" value=\"\" maxlength=\'10\' size=\'10\' name=\'to_date\'\n\t\t\t\t\tonkeypress=\"return Valid_DT(event)\"><img\n\t\t\t\t\tsrc=\'../../eCommon/images/CommonCalendar.gif\'\n\t\t\t\t\tonClick=\"document.forms[0].req_date_to.focus();return showCalendar(\'req_date_to\');\"></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\n\t\t\t<tr >\n\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t\t\t<td class=\"fields\"><input type=\"checkbox\" name=\"discharge_val\"\n\t\t\t\t\tid=\"discharge_val\" onclick=\"callcheck_val();\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\"button\" style=\"text-align: right;\"><input type=\'button\' id=\'search\'\n\t\t\t\t\tname=\'search\' id=\'search\'\n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'\n\t\t\t\t\tclass=\'button\' onclick=\'submitPage()\'>\n\t\t\t\t<!--id added for ML-MMOH-SCF-1854--> <input type=\'button\' style=\"margin-right: 10px;\"\n\t\t\t\t\tname=\'clear\' id=\'clear\'\n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'\n\t\t\t\t\tclass=\'button\' onclick=\'clearAll()\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t<!-- <td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t<!-- <td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td> -->\n\t\t\t</tr>\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"> \n\t\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"> \n\t\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"> \n\t\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"> \n\t\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"> \n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"> \n\t\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"> \n\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"> \n\t\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"> \n\t\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t<input type=\'hidden\' name=\'SystemDate\' id=\'SystemDate\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"> \n\t\t<input type=\'hidden\' name=\'qerString\' id=\'qerString\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\'value=\'MRBIPFFPRC\'></input> \n\t\t<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'MR\'></input> \n\t\t<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'></input>\n\t\t<input type=\'hidden\' name=\'p_user_name\' id=\'p_user_name\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'></input> \n\t\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'\'></input> \n\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'></input>\n\t\t<input type=\'hidden\' name=\'oper_stn_id1\' id=\'oper_stn_id1\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'></input> \n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'></input> \n\t\t<input type=\'hidden\' name=\'SystemDischarge_display\' id=\'SystemDischarge_display\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'></input> \n\t\t<input type=\'hidden\' name=\'serialNo\' id=\'serialNo\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'></input>\n\t\t<input type=\'hidden\' name=\'cutOffVisit\' id=\'cutOffVisit\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'></input> \n\t\t<input type=\'hidden\' name=\'cutOffDischarge\' id=\'cutOffDischarge\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'></input> \n\t\t<input type=\'hidden\' name=\'SystemDate_op\' id=\'SystemDate_op\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'></input>\n\t\t<input type=\'hidden\' name=\'SystemDate_ip\' id=\'SystemDate_ip\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'></input> \n\t\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'></input> \n\t\t<input type=\'hidden\' name=\'op_visit\' id=\'op_visit\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'></input>\n\t\t<input type=\'hidden\' name=\'ip_disch\' id=\'ip_disch\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'></input>\n\t\t<input type=\'hidden\' name=\'grace_period\' id=\'grace_period\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'></input>\n\t\t<input type=\'hidden\' name=\'max_level_for_op_yn\' id=\'max_level_for_op_yn\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'></input> \n\t\t<input type=\'hidden\' name=\'max_level_for_ip_yn\' id=\'max_level_for_ip_yn\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'></input> \n\t\t<input type=\'hidden\' name=\'max_level_for_input\' id=\'max_level_for_input\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'> \n\t\t<input type=\'hidden\' name=\'max_level_for_em_yn\' id=\'max_level_for_em_yn\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'></input> \n\t\t<input type=\'hidden\' name=\'op_grace\' id=\'op_grace\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'></input>\n\t\t<input type=\'hidden\' name=\'ip_grace\' id=\'ip_grace\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'></input>\n\t\t<input type=\'hidden\' name=\'create_file_yn\' id=\'create_file_yn\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'></input> \n\t\t<input type=\'hidden\' name=\'reportname\' id=\'reportname\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'></input> \n\t\t<input type=\'hidden\' name=\'statusFlag\' id=\'statusFlag\' value=\'N\'></input>\n\t\t<!--Added for ML-MMOH-SCF-1854-->\n\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t<script>\n\t\t\t document.getElementById(\"encType_img\").style.visibility = \'visible\';\n\t\t\t //document.forms[0].all.encDate_img.style.visibility = \'visible\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t<script>\n\t\t\tdocument.getElementById(\"encType_img\").style.visibility = \'visible\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\n\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t</form>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );
public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null")))
				? ""
				: inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null")))
				? defaultValue
				: inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = checkForNull(
			(String) session.getAttribute("PREFERRED_STYLE"),
			"IeStyle.css");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String p_user_name = (String) session.getValue("login_user");
	String locale = (String) session.getAttribute("LOCALE");
	Connection con = ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific = eCommon.Common.CommonBean.isSiteSpecific(
			con, "MR", "MLC_TO_MEDICO_LEGAL_CASE");
	/*end ML-MMOH-CRF-0354 [IN057191] */
	boolean isPrePractinReprintAppl = eCommon.Common.CommonBean
			.isSiteSpecific(con, "MR", "ALLOW_PREP_PRACT_REPRINT"); //added by mujafar for ML-MMOH-SCF-1365

	ResultSet rs = null;
	ResultSet rs1 = null;
	Statement stmt = null;
	Statement stmt1 = null;
	String pat_id_length = "";
	try {
		String jsp_name = request.getParameter("jsp_name");
		if (jsp_name == null)
			jsp_name = "";
		String window_styl = request.getParameter("window_styl");
		if (window_styl == null)
			window_styl = "";
		String close_yn = request.getParameter("close_yn");
		if (close_yn == null)
			close_yn = "";
		String win_top = request.getParameter("win_top");
		if (win_top == null)
			win_top = "";
		String win_height = request.getParameter("win_height");
		if (win_height == null)
			win_height = "";
		String win_width = request.getParameter("win_width");
		if (win_width == null)
			win_width = "";

		String call_function = request.getParameter("call_function");
		if (call_function == null)
			call_function = "";

		String modal = request.getParameter("modal");
		if (modal == null)
			modal = "";
		String dialogTop = request.getParameter("dialogTop");
		if (dialogTop == null)
			dialogTop = "";

		String module = request.getParameter("module");
		if (module == null)
			module = "";

		String model_window = request.getParameter("model_window");
		if (model_window == null)
			model_window = "";

		String function_id = request.getParameter("function_id");
		if (function_id == null)
			function_id = "";

		String prog_id = request.getParameter("prog_id");
		if (prog_id == null)
			prog_id = "";

		String practitioner_id = request
				.getParameter("practitioner_id");
		if (practitioner_id == null)
			practitioner_id = "";

		String wherecondn = request.getParameter("wherecondn");
		if (wherecondn == null)
			wherecondn = "";

		String operstn = request.getParameter("wherecondn");
		if (wherecondn == null)
			wherecondn = "";

		String oper_stn_id = request.getParameter("oper_stn_id");
		if (oper_stn_id == null)
			oper_stn_id = "";

		String oper_stn_id1 = request.getParameter("oper_stn_id1");
		if (oper_stn_id1 == null)
			oper_stn_id1 = "";

		String reportname = request.getParameter("reportname");
		if (reportname == null)
			reportname = "";
		String encounterID_repDischargeAdvice = request
				.getParameter("encounter_id");
		if (encounterID_repDischargeAdvice == null)
			encounterID_repDischargeAdvice = "";
		String loginUser = (String) session.getValue("login_user");
		String p_facility_id = (String) session.getValue("facility_id");
		String SystemDate = "";
		String SystemDate_op = "";
		String SystemDate_ip = "";
		String recode_for_op_yn = "";
		String recode_for_ip_yn = "";
		String recode_for_em_yn = "";
		String recode_for_dc_yn = "";
		String SDate = "";
		String stage_no = "";
		String recode_OP_yn = "";
		String recode_IP_yn = "";
		int op_visit = 0;
		int ip_disch = 0;

		String max_level_for_op_yn = "";
		String max_level_for_ip_yn = "";
		String max_level_for_input = "";
		String max_level_for_dc_yn = "";
		String max_level_for_em_yn = "";
		int grace_period = 0;

		String op_grace = "";
		String ip_grace = "";
		String create_file_yn = "";
		try {
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select patient_id_length, to_char(sysdate+1 - "
							+ op_visit
							+ ",'dd/mm/yyyy')SystemDate_op, to_char(sysdate+1 - "
							+ ip_disch
							+ ",'dd/mm/yyyy')SystemDate_ip,to_char(sysdate,'dd/mm/yyyy')SystemDate,to_char(sysdate,'dd/mm/yyyy')SDate,to_char(sysdate+1 - "
							+ (op_visit + grace_period)
							+ ",'dd/mm/yyyy')op_grace,to_char(sysdate+1 - "
							+ (ip_disch + grace_period)
							+ ",'dd/mm/yyyy')ip_grace,create_file_yn  from mp_param");
			if (rs.next() && rs != null) {
				pat_id_length = rs.getString(1);
				SystemDate_op = rs.getString(2);
				SystemDate_ip = rs.getString(3);
				SystemDate = rs.getString(4);
				SDate = rs.getString(5);
				op_grace = rs.getString(6);
				ip_grace = rs.getString(7);
				create_file_yn = rs.getString(8);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
		}

		//out.println("<script>alert(\"op_visit :"+SystemDate_op+SystemDate_ip+"\");</script>");

		SystemDate_op = DateUtils.convertDate(SystemDate_op, "DMY",
				"en", localeName);
		SystemDate_ip = DateUtils.convertDate(SystemDate_ip, "DMY",
				"en", localeName);
		String SystemDate_display = DateUtils.convertDate(SystemDate,
				"DMY", "en", localeName);
		String SystemDischarge_display = DateUtils.convertDate(SDate,
				"DMY", "en", localeName);
		op_grace = DateUtils.convertDate(op_grace, "DMY", "en",
				localeName);
		ip_grace = DateUtils.convertDate(ip_grace, "DMY", "en",
				localeName);
		String serialNo = "";
		int cutOffVisit = 0;
		String cutOffDischarge = "";
		//String authorize_yn = "";
		//String grace_period = "";

            _bw.write(_wl_block7Bytes, _wl_block7);

			if (!call_function.equals("RECORD_DIAGNOSIS")
						&& !call_function.equals("PROCEDURE_RECORDING")
						&& !call_function.equals("VISITS_WITHOUT_MDS")) {
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponentCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("mr_transaction"), weblogic.utils.StringUtils.valueOf("Y")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block8Bytes, _wl_block8);

			}
				//out.println("<script>alert(\""+call_function+"\");</script>");
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block12Bytes, _wl_block12);

						if (!call_function.equals("QUERY_MARK_MLC_OSCC")
									&& !call_function.equals("QUERY_MATERNAL_REPORT")
									&& !call_function.equals("MR_VIEW_DTH_REG")
									&& !call_function.equals("DIAG_RECODE")) {
					
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
					
            _bw.write(_wl_block14Bytes, _wl_block14);
if(!call_function.equals("PROCEDURE_RECORDING")){ 
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
					
            _bw.write(_wl_block16Bytes, _wl_block16);

					if (!call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("QUERY_MATERNAL_REPORT")
								&& !call_function.equals("MR_VIEW_DTH_REG")
								&& !call_function.equals("DIAG_RECODE")
								&& !call_function.equals("MR_REC_PAT_VAL")
								&& !call_function.equals("MEDICAL_REPORT_REQUEST")
								&& !call_function.equals("TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("MARK_MLC_OSCC")
								&& !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
				
            _bw.write(_wl_block17Bytes, _wl_block17);

					}
				
            _bw.write(_wl_block18Bytes, _wl_block18);

					if (call_function.equals("QUERY_MATERNAL_REPORT")) {
				
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

							//rs = stmt.executeQuery("select DISCHARGE_TYPE_CODE, SHORT_DESC from ip_discharge_type where  MATERNAL_DEATH_YN = 'Y' and EFF_STATUS = 'E' order by 2 ")  ;
									rs = stmt
											.executeQuery("select DISCHARGE_TYPE_CODE, SHORT_DESC from IP_DISCHARGE_TYPE_LANG_VW  where  MATERNAL_DEATH_YN = 'Y' and EFF_STATUS = 'E' AND language_id='"
													+ locale + "' order by 2 ");
									if (rs != null) {
										while (rs.next()) {
						
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs.getString("DISCHARGE_TYPE_CODE")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("SHORT_DESC")));
            _bw.write(_wl_block24Bytes, _wl_block24);

							}
									}
						
            _bw.write(_wl_block25Bytes, _wl_block25);

					}

						if (!call_function.equals("QUERY_MATERNAL_REPORT")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("DIAG_RECODE")
								&& !call_function.equals("MR_REC_PAT_VAL")
								&& !call_function.equals("MEDICAL_REPORT_REQUEST")
								&& !call_function.equals("TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("MR_VIEW_DTH_REG")
								&& !call_function.equals("MARK_MLC_OSCC")
								&& !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
				
            _bw.write(_wl_block26Bytes, _wl_block26);

					}
				
            _bw.write(_wl_block16Bytes, _wl_block16);

					if (call_function.equals("QUERY_MARK_MLC_OSCC")) {
				
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							if (siteSpecific) {
						
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							} else {
						
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							}
						
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
						if (!call_function.equals("DIAG_RECODE")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("QUERY_MATERNAL_REPORT")) {
				
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
				
            _bw.write(_wl_block33Bytes, _wl_block33);

					if (!call_function.equals("QUERY_MATERNAL_REPORT")
								&& !reportname.equals("MR")) {
				
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

						if (rs != null)
									rs.close();
								if (call_function.equals("MR_REC_PAT_VAL")
										|| call_function.equals("REPRINT_PAT_VAL")
										|| call_function
												.equals("MR_INTERNAL_REPORTS_REPRINT")) {
									if (call_function.equals("MR_INTERNAL_REPORTS_REPRINT")
											&& reportname.equals("MRDGRCSM")) {
					
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							} else {

											//rs = stmt.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS where patient_class not in ('XT') order by 1");
						
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

								rs = stmt
														.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS_LANG_VW where patient_class not in ('XT') AND language_id='"
																+ locale + "' order by 1");

												if (rs != null) {
													while (rs.next()) {
							
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs.getString("PATIENT_CLASS")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block40Bytes, _wl_block40);

								}
												}
												if (rs != null)
													rs.close();
											}
										} else {
							
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

									//rs = stmt.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS order by 1");
												rs = stmt
														.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS_LANG_VW WHERE language_id='"
																+ locale + "' order by 1");

												if (rs != null) {
													while (rs.next()) {
								
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rs.getString("PATIENT_CLASS")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block44Bytes, _wl_block44);

									}
												}
												if (rs != null)
													rs.close();
											}
								
            _bw.write(_wl_block45Bytes, _wl_block45);

					} else {
				
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
						if (!call_function.equals("MR_REC_PAT_VAL")
								&& !call_function.equals("REPRINT_PAT_VAL")
								&& !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
							SystemDate_display = "";
						}
				
            _bw.write(_wl_block16Bytes, _wl_block16);

					if (!reportname.equals("MR")) {
				
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block51Bytes, _wl_block51);

					if (call_function.equals("RECORD_DIAGNOSIS")) {
					
            _bw.write(_wl_block52Bytes, _wl_block52);

					}
					
            _bw.write(_wl_block53Bytes, _wl_block53);

					}
				
            _bw.write(_wl_block54Bytes, _wl_block54);

					if (call_function.equals("MR_REC_PAT_VAL")
								|| call_function.equals("REPRINT_PAT_VAL")
								|| call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block57Bytes, _wl_block57);

					}
				
            _bw.write(_wl_block58Bytes, _wl_block58);

				if (call_function.equals("QUERY_MATERNAL_REPORT")
							|| call_function.equals("MR_VIEW_DTH_REG")) {
			
            _bw.write(_wl_block59Bytes, _wl_block59);

					if (call_function.equals("MR_VIEW_DTH_REG")) {
				
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);

					} else {
				
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block66Bytes, _wl_block66);

					}
				
            _bw.write(_wl_block67Bytes, _wl_block67);

				}
			
            _bw.write(_wl_block68Bytes, _wl_block68);

				if (!reportname.equals("MR")) {
			
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

						if (call_function.equals("VISITS_WITHOUT_MDS")) {
					
            _bw.write(_wl_block71Bytes, _wl_block71);

						} else {
					
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

 	}
 
            _bw.write(_wl_block73Bytes, _wl_block73);

						if (call_function.equals("VISITS_WITHOUT_MDS")) {
					
            _bw.write(_wl_block72Bytes, _wl_block72);

 	} else {
 
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

 	}
 
            _bw.write(_wl_block78Bytes, _wl_block78);

					if (call_function.equals("RECORD_DIAGNOSIS")) {
				
            _bw.write(_wl_block79Bytes, _wl_block79);

					}
				
            _bw.write(_wl_block80Bytes, _wl_block80);

				}
			
            _bw.write(_wl_block9Bytes, _wl_block9);

            _bw.write(_wl_block81Bytes, _wl_block81);

				if (call_function.equals("MR_INTERNAL_REPORTS_REPRINT")
							&& reportname.equals("MR")) {
			
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							if (isPrePractinReprintAppl) { //added by mujafar for ML-MMOH-SCF-1365
						
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

							}
						
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block95Bytes, _wl_block95);

				}
			
            _bw.write(_wl_block96Bytes, _wl_block96);

					if (call_function.equals("MR_REC_PAT_VAL")) {
				
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

					} else {
				
            _bw.write(_wl_block99Bytes, _wl_block99);

					}
				
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.search.label", "common_labels")));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.clear.label", "common_labels")));
            _bw.write(_wl_block102Bytes, _wl_block102);

					if (call_function.equals("RECORD_DIAGNOSIS")) {
					
            _bw.write(_wl_block103Bytes, _wl_block103);

					}
					
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(module));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(oper_stn_id1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(SystemDischarge_display));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(serialNo));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(cutOffVisit));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(cutOffDischarge));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(SystemDate_op));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(SystemDate_ip));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(op_visit));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(ip_disch));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(grace_period));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(max_level_for_op_yn));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(max_level_for_ip_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(max_level_for_input));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(max_level_for_em_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(op_grace));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(ip_grace));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(create_file_yn));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(reportname));
            _bw.write(_wl_block143Bytes, _wl_block143);
if (call_function.equals("MR_REC_PAT_VAL")
						|| call_function.equals("REPRINT_PAT_VAL")
						|| call_function.equals("MR_INTERNAL_REPORTS_REPRINT")
						&& !reportname.equals("MR")) {
            _bw.write(_wl_block144Bytes, _wl_block144);
} else if (call_function.equals("RECORD_DIAGNOSIS")
						|| call_function.equals("PROCEDURE_RECORDING")) {
            _bw.write(_wl_block145Bytes, _wl_block145);
}
            _bw.write(_wl_block146Bytes, _wl_block146);
} catch (Exception e) {
				e.printStackTrace();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				ConnectionManager.returnConnection(con, request);
			}
            _bw.write(_wl_block147Bytes, _wl_block147);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseIndicator.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MarkedStatus.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncPeriod.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeceasedPeriod.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DischPeriod.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MedicalReportStatus.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Requested.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.incomplete.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.StatusCompleted.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PreparedbyPractitioner.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReceivedbyMedicalRecord.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReportDelivered.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Overdue.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestDateFrom.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.discharged.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
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
}
