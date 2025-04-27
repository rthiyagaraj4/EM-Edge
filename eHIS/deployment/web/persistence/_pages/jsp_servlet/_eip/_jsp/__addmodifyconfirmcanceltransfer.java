package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;

public final class __addmodifyconfirmcanceltransfer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyConfirmCancelTransfer.jsp", 1718793162642L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tChitra \n\tCreated on \t:\t27/08/2001\n\tModule\t\t:\tip\n-->\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\n\t<script src=\'../js/ConfirmCancelTransfer.js\' language=\"javascript\"></script>\n    \n\t<script language=\"JavaScript\">\n\t<!--\n\n\n// By Annadurai 2/17/2004 starts.,. for Enhancement...  \n\noverride_yn = new Array();\n\nfunction objChk(obj)\n{\n\tif (obj.checked)\n\t\tdocument.forms(0).overrides.value = \'Y\';\n\telse\n\t\tdocument.forms(0).overrides.value = \'N\';\n}\n\nfunction setOverride(object)\n{\n\tvar i = object.selectedIndex;\n\tif (i > 0)\n\t{\n\t\t\tif(override_yn[i-1]==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.all.overrides.checked = true;\n\t\t\t\tdocument.all.override.value = \'Y\';\t\t\t\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.all.overrides.checked = false;\n\t\t\t\tdocument.all.override.value = \'N\';\n\t\t\t}\n\t}\n\telse\n\t{\n\t\tdocument.all.overrides.checked = false;\n\t\tdocument.all.override.value = \'N\';\n\t}\n}\n\nfunction OffsetDate(sysdatetime,strPri1,strDftUnts1)\n{\n\t\n\tvar result = \"\";\n\tvar days= strPri1;\n\tif(days!=\'\'){\n\tvar sysdate = sysdatetime.substring(0,10);\n\tvar systime = sysdatetime.substring(11,16);\n\t\n\t/***building current date object from sysdate to avoid local machine date setting errors **/\n\tvar dateArray = sysdate.split(\"/\");\n\tsysdate1=dateArray[1]+\"/\"+dateArray[0]+\"/\"+dateArray[2]\n\tvar tempdate = Date.parse(sysdate1);\n\tvar currentDate=new Date(tempdate);\n\n\tvar timeArray = systime.split(\":\");\n\tsystime1=dateArray[1]+\"/\"+dateArray[0]+\"/\"+dateArray[2]+\" \"+timeArray[0]+\":\"+timeArray[1]\n\tvar tempdatetime = Date.parse(systime1);\n\tvar currentDateTime=new Date(tempdatetime);\n\t\n\tvar dwm= strDftUnts1;\n\tvar currentMonth=currentDate.getMonth();\n\tvar presentDate=currentDate.getDate();\n\tvar presentTime=currentDateTime.getHours();\n\t\t\t\n\tvar finaldate;\n\n\t\tif(dwm==\'D\'){\n\t\t\tfinaldate=presentDate+eval(days);\n\t\t\tcurrentDate.setDate(finaldate);\n\t\t\tresult = currentDate.getDate()+\"/\"+eval(currentDate.getMonth()+1)+\"/\"+currentDate.getFullYear();\n\t\t}\n\t\telse if(dwm==\'W\'){\n\t\t\tfinaldate=presentDate+eval(days*7);\n\t\t\tcurrentDate.setDate(finaldate);\n\t\t\tresult = currentDate.getDate()+\"/\"+eval(currentDate.getMonth()+1)+\"/\"+currentDate.getFullYear();\n\t\t}\n\t\telse if(dwm==\'H\') {\n\t\t\tfinaldate=presentTime+eval(days);\n\t\t\tcurrentDateTime.setHours(finaldate);\n\t\t\tresult = currentDateTime.getDate()+\"/\"+eval(currentDateTime.getMonth()+1)+\"/\"+currentDateTime.getFullYear()+\" \"+currentDateTime.getHours()+\":\"+currentDateTime.getMinutes();\n\t\t}\n\t\telse{\n\t\t\tcurrentDate.setMonth(eval(currentMonth+eval(days)));\n\t\t\tresult = currentDate.getDate()+\"/\"+eval(currentDate.getMonth()+1)+\"/\"+currentDate.getFullYear();\n\t\t}\n\tdocument.ConfirmCancelTransfer_form.pri_target.value = result;\n\t}\n\telse\n\t{\n\t\tdocument.ConfirmCancelTransfer_form.pri_target.value = \"\";\n\t}\n\t\n\treturn result;\n}\n\nfunction getRoomNo(obj)\n{\n\tif(specialChar(obj,\'Char\')==true)\n\t{\n\t\tif(obj.value!=\'\')\n\t\t{\n\t\tself.document.ConfirmCancelTransfer_form.to_room_no.value = \'\';\t\n\t\tvar nursingunit = self.document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;\n\t\tvar to_bed_no = self.document.ConfirmCancelTransfer_form.to_bed_no.value;\n\t\tvar bedno = obj.value;\n\t\tvar url = parent.frames(2).location.href;\n\t\tvar action_url=\"\";\n\t\t\tif(url.indexOf(\"/servlet\")!=-1){\n\t\t\t\tvar HTMLVal = \" <html><body onKeyDown=\'lockKey()\'><form name=\'dum_form\' method=\'post\' action=\'../eIP/jsp/GetValidation.jsp\'>\"+\n\t\t\t\t\" <input type=\'hidden\' name=\'field1\' value=\'\'><input type=\'hidden\' name=\'field2\' value=\'\'> \"+\n\t\t\t\t\" <input type=\'hidden\' name=\'field3\' value=\'\"+nursingunit+\"\'><input type=\'hidden\' name=\'field4\' value=\'Emergency_form\'><input type=\'hidden\' name=\'field5\' value=\'\"+bedno+\"\'><input type=\'hidden\' name=\'to_bed_no\' value=\'\"+to_bed_no+\"\'></form></body></html>\";\n\t\t\t}\n\t\t\telse{\n\t\t\t\tvar HTMLVal = \" <html><body onKeyDown=\'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eIP/jsp/GetValidation.jsp\'>\"+\n\t\t\t\t\" <input type=\'hidden\' name=\'field1\' id=\'field1\' value=\'\'><input type=\'hidden\' name=\'field2\' id=\'field2\' value=\'\'> \"+\n\t\t\t\t\" <input type=\'hidden\' name=\'field3\' id=\'field3\' value=\'\"+nursingunit+\"\'><input type=\'hidden\' name=\'field4\' id=\'field4\' value=\'Emergency_form\'><input type=\'hidden\' name=\'field5\' id=\'field5\' value=\'\"+bedno+\"\'><input type=\'hidden\' name=\'to_bed_no\' id=\'to_bed_no\' value=\'\"+to_bed_no+\"\'></form></body></html>\";\n\t\t\t}\n\n\t\t\n\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.frames[2].document.dum_form.submit();\n\t\t}\n\t}\n}\n\nfunction checkForBedNo()\n{\n\tif (document.ConfirmCancelTransfer_form.to_bed_no.value==\"\")\n\t\tdocument.ConfirmCancelTransfer_form.to_room_no.value=\"\";\n} // End of checkForBedNo.\n\nasync function callBedAvailChart()\n{\n\n\tvar nursingunit = parent.frames[1].document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;\n\tvar practitionerid = parent.frames[1].document.ConfirmCancelTransfer_form.to_practitioner_id.value;\n\tvar specialitycode = parent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value;\n\tvar bedclasscode = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.value;\n\tvar gender = parent.frames[1].document.ConfirmCancelTransfer_form.patient_gender.value;\n\tvar agevalue = parent.frames[1].document.ConfirmCancelTransfer_form.age.value;\n\tvar age = \"\";\n\tvar yr = eval(agevalue.indexOf(\"Y\"));\n\tvar mon = eval(agevalue.indexOf(\"M\"));\n\n\tif(mon>=0 && yr>=0)\n\t{\n\t\tage = agevalue.substring(0,yr);\n\t\tagevalue = \"Y\";\n\t}\n\telse if(mon >= 0)\n\t{\n\t\tage = agevalue.substring(0,mon);\n\t\tagevalue = \"M\";\n\t}\n\telse\n\t{\n\t\tage = agevalue.substring(0,yr);\n\t\tagevalue = \"Y\";\n\t}\n\n\tvar retVal = \tnew String();\n\tvar dialogHeight= \"700px\";\n\tvar dialogWidth = \"1200px\";\n\tvar dialogTop\t= \"72\";\n\n\tvar status = \"no\";\n\tvar arguments\t= \"\" ;\n\tvar wherecondn  = \"EMERGENCY_TFR_YN\"; \n\tvar features\t= \"dialogHeight:\" + dialogHeight + \";dialogTop:\" + dialogTop + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\tretVal = await window.showModalDialog(\"../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code=\"+escape(nursingunit)+\"&speciality_code=\"+escape(specialitycode)+\"&practitioner_id=\"+escape(practitionerid)+\"&bed_class_code=\"+escape(bedclasscode)+\"&age_value=\"+escape(agevalue)+\"&age=\"+escape(age)+\"&gender=\"+escape(gender)+\"&wherecondn=\"+escape(wherecondn),arguments,features);\n\n\tif(retVal!=null)\n\t{\n\t\tvar arr = retVal.split(\"^\");\n\t\tif(arr.length > 2)\n\t\t{\n\t\t\tvar arr1 = arr[1].split(\"/\");\n\t\t\tparent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no.value = arr1[0];\n\n\t\t\tvar arrsplty = arr[11].split(\"*All SPLTY*\");\n\t\t\tif (arrsplty.length==1)\n\t\t\t{\n\t\t\t\tparent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value=arr[10];\n\t\t\t}\n\n\t\t\tp = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.options;\n\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\tif(p.options[i].value ==arr[3])\n\t\t\t\t\tp.options[i].selected = true;\n\t\t\t}\n\n\t\t\t\n\t\t\tif(arr[4] ==null )  \tarr[4] =\'\';\n\t\t\t\n\t\t\tparent.frames[1].document.ConfirmCancelTransfer_form.to_room_no.value=arr[4];\n\t\t\tgetRoomNo(parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no);\n\t\t}\n\t}\n\n}\nfunction specialChar(obj,val)\n{\n\tif(obj.value!=\'\')\n\t{\n\t\tvar fields1 = new Array(obj);\n\t\tvar names1 = new Array(obj.name.toUpperCase());\n\t\tvar messageFrame = \"\"; var error_page = \"\";\n\t\tif(SpecialCharCheck(fields1,names1,messageFrame,\"A\",error_page) )\n\t\t{\n\t\t\tif(val==\"Num\")\n\t\t\t{\n\t\t\t\tif(CheckNum(obj))\n\t\t\t\t\t{\n\t\t\t\t\t\t return true;\n\t\t\t\t\t}\n\t\t\t\t\telse \n\t\t\t\t\t{\n\t\t\t\t\t\t obj.focus();\n\t\t\t\t\t\t obj.value=\'\';\n\t\t\t\t\t\t return false;\n\t\t\t\t\t}\n\t\t\t}\n\t\t\telse if(val==\"Char\")\n\t\t\t{\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\n\t\t   obj.focus()\n\t\t   obj.value=\'\';\n\t\t   return false;\n\t\t}\n\t}\n\n}\n// By Annadurai 2/17/2004 ends.,\n\nfunction ComputeBlDtl()\n{\n\tvar fm_nur_code\t=\tdocument.forms[0].fr_nursing_unit_code;\n\tvar to_nur_code\t=\tdocument.forms[0].to_nursing_unit_code;\n\tvar fm_bed_no\t=\tdocument.forms[0].fr_bed_no;\n\tvar to_bed_no\t=\tdocument.forms[0].to_bed_no;\n\tvar fm_bed_class=\tdocument.forms[0].fr_bed_class;\n\tvar to_bed_class=\tdocument.forms[0].to_bed_class;\n\tvar trans_code\t=\tdocument.forms[0].transfer_type;\n\tvar encount_id\t=\tdocument.forms[0].encounter_id;\n\n\tif(trans_code.value==\"\")\n\t{\n\n\t\tvar\terror = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\',getLabel(\"eIP.TransferType.label\",\"IP\"));\n\t\talert(error);\t\t\t\t\t\n\t\ttrans_code.focus();\n\t\treturn false;\n\t}\n\n\tif(to_nur_code.value==\"\")\n\t{\n\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\terror = error.replace(\'$\',getLabel(\"Common.TransfertoNursingUnit.label\",\"Common\"));\n\talert(error);\t\t\t\t\t\n\t\tto_nur_code.focus();\n\t\treturn false;\n\t}\n\n\tif(to_bed_class.value==\"\")\n\t{\n\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\terror = error.replace(\'$\',getLabel(\"Common.TransfertoBed.label\",\"Common\"));\n\talert(error);\t\t\t\t\t\n\tto_bed_class.focus();\n\treturn false;\n\t}\n\n\tif(to_bed_no.value==\"\")\n\t{\n\t\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\terror = error.replace(\'$\',getLabel(\"Common.TransfertoRoomCubicleNo.label\",\"Common\"));\n\t\talert(error);\t\t\t\t\t\n\t\tto_bed_no.focus();\n\t\treturn false;\n\t}\n\n\tvar HTMLVal = \" <html><body onKeyDown=\'lockKey()\'><form name=\'BLBedTrans\' id=\'BLBedTrans\' method=\'post\' action=\'../../eBL/jsp/BLBedTrans.jsp\' >\"+\n\t\"<input type=\'hidden\' name=\'fm_nur_code\' id=\'fm_nur_code\' value=\'\"+fm_nur_code.value+\"\'>\"+\n\t\"<input type=\'hidden\' name=\'to_nur_code\' id=\'to_nur_code\' value=\'\"+to_nur_code.value+\"\'> \"+\n\t\"<input type=\'hidden\' name=\'fm_bed_no\' id=\'fm_bed_no\' value=\'\"+fm_bed_no.value+\"\'> \"+\n\t\"<input type=\'hidden\' name=\'to_bed_no\' id=\'to_bed_no\' value=\'\"+to_bed_no.value+\"\'> \"+\n\t\"<input type=\'hidden\' name=\'fm_bed_class\' id=\'fm_bed_class\' value=\'\"+fm_bed_class.value+\"\'> \"+\n\t\"<input type=\'hidden\' name=\'to_bed_class\' id=\'to_bed_class\' value=\'\"+to_bed_class.value+\"\'> \"+\n\t\"<input type=\'hidden\' name=\'trans_code\' id=\'trans_code\' value=\'\"+trans_code.value+\"\'> \"+\n\t\"<input type=\'hidden\' name=\'encount_id\' id=\'encount_id\' value=\'\"+encount_id.value+\"\'> \"+\n\t\"</form></body></html>\";\n\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[2].document.BLBedTrans.submit();\n}\n\t</script>\n</head>\n\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<form name=\"ConfirmCancelTransfer_form\" id=\"ConfirmCancelTransfer_form\"  method=\"post\" action=\"../../servlet/eIP.ConfirmCancelTransferServlet\" target=_top>\n\t<!--<br>-->\n\t<table border=0 width=\"100%\" cellpadding=6 cellspacing=0>\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;</td>\n\t\t\t <td width=\"35%\" class=\'querydata\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td align=\"right\" class=\"label\" width=\"15%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\t\t<td width=\"25%\" class=\'querydata\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td> \n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;</td>\n\t\t\t<td class=\'querydata\' width=\"35%\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<input type=\"hidden\" name=\"to_practitioner_id\" id=\"to_practitioner_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t</td>\n\t\t\t<td align=\"right\" class=\"label\" width=\"15%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</td>\n\t\t\t<td class=\'querydata\' width=\"25%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<input type=\"hidden\" name=\"to_speciality_code\" id=\"to_speciality_code\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;</td>\n\t\t\t<td class=\'querydata\' width=\"35%\" colspan=\'3\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\n\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\" width=\"25%\" nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</td>\n\t\t\t<td class=\'querydata\' width=\"35%\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\"  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></td>\n\t\t\t<td align=\"right\" class=\"label\" width=\"15%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<input type=\"hidden\" name=\"transfer_type\" id=\"transfer_type\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n\t<!--<br>-->\n\n\t<table border=0 width=\"100%\" cellpadding=6 cellspacing=0>\n\t\t<tr>\n\t\t\t\t<th colspan=2 width=\"50%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\n\t\t\t\t<th colspan=2 width=\"50%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;</td>\n\t\t\t<td width=\"25%\" class=\'querydata\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_nursing_unit_code\" id=\"fr_nursing_unit_code\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t</td>\n\t\t\t<td align=\"right\" class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<input type=\"hidden\" name=\"to_nursing_unit_code\" id=\"to_nursing_unit_code\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</td>\n\t\t\t<td class=\'querydata\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_bed_class\" id=\"fr_bed_class\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t\t\t</td>\n\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;</td>\n<!-- \t\tBy Annadurai 2/17/2004.,\t\n\t\t\t<td class=\'querydata\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<input type=\"hidden\" name=\"to_bed_class\" id=\"to_bed_class\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t\t\t</td> -->\n    <TD class=\'querydata\' >\n\t<select name=\'Bedcode\' id=\'Bedcode\'><option value=\'\' selected >---&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ---\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t \t <OPTION VALUE=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</select>           \n\t<input type=\"hidden\" name=\"to_bed_class\" id=\"to_bed_class\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n    <!-- ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" -->\n     <img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;</td>\n\t\t\t<td class=\'querydata\'><input type=\"hidden\" name=\"fr_bed_no\" id=\"fr_bed_no\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" > ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</td>\n<!-- By Annadurai 2/17/2004., \n\t\t<td class=\'querydata\'><input type=\"hidden\" name=\"to_bed_no\" id=\"to_bed_no\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" </td> -->\n\t\t<TD class=\'querydata\' >\n\t\t\t\t<input type=\"text\" name=\"to_bed_no\" id=\"to_bed_no\" size=8 maxlength=8 onBlur=\"ChangeUpperCase(this),getRoomNo(this),checkForBedNo();\" onKeyPress=\'return CheckForSpecChars(event)\'><input type=\"button\" class=\"button\" value=\"?\" onclick=\"callBedAvailChart();\">&nbsp;<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\n\t\t\t</td>\n\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td>\n\t\t\t<td class=\'querydata\'><input type=\"hidden\" name=\"fr_room_no\" id=\"fr_room_no\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" </td>\n\t\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;</td>\n<!-- \t\t\t<td class=\'querydata\'><input type=\"hidden\" name=\"to_room_no\" id=\"to_room_no\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" </td> -->\n\t\t\t\t<TD class=\'querydata\' ><input type=\"text\" name=\"to_room_no\" id=\"to_room_no\" size=10 maxlength=10 readonly onBlur=\"specialChar(this,\'Char\')\"></TD>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&nbsp;</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="-->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<select name=\'blocktype\' id=\'blocktype\' onChange=\"setOverride(this)\"><option value=\'\' selected>&nbsp; --- ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="--- &nbsp;</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t <OPTION VALUE=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t</select>\t\t\t\t\t\t\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>  \n\t\t\t\t\t</td>\n\t\t\t\t\t<script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t  override_yn[";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="]=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t</script>\n\t\t\t\t\t<td class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp;</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\'checkbox\'  name=\'overrides\' id=\'overrides\' value=\"N\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" onClick=\"\tobjChk(this)\" >\n\t\t\t\t\t\t <input type=\"hidden\" name=override value=\"Y\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\n<!-- commented by kumar on 14/2/02 required only when bl is interfaced which will be done later-->\n<!--\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\">Daily Rate&nbsp;&nbsp;</td>\n\t\t\t<td class=\'querydata\'><input type=\"hidden\" name=\"fr_daily_rate\" id=\"fr_daily_rate\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t<td align=\"right\" class=\"label\">Daily Rate&nbsp;&nbsp;</td>\n\t\t\t<td class=\'querydata\'><input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t</tr>\n-->\n\t\t<tr>\n\t\t\t<td colspan=4>&nbsp;</td>\n\t\t</tr>\n\t</table>\t\n\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"hidden\" name=\"confirm_or_cancel\" id=\"confirm_or_cancel\" value=\"\">\n\t<input type=\"hidden\" name=\"booking_ref_no\" id=\"booking_ref_no\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\"hidden\" name=\"patient_gender\" id=\"patient_gender\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\n\t<!-- By Annadurai 2/17/2004 starts., -->\n\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" > \n\t<input type=\"hidden\" name=\"pri_target\" id=\"pri_target\">\n\t<input type=\"hidden\" name=\"priority_value\" id=\"priority_value\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n\t<!-- By Annadurai 2/17/2004 ends., -->\n\n\t<input type=\"hidden\" name=\"to_nursing_unit_type\" id=\"to_nursing_unit_type\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\"hidden\" name=\"to_bed_type\" id=\"to_bed_type\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\n\t<input type=\"hidden\" name=\"bl_interfaced_yn\" id=\"bl_interfaced_yn\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" name=\"allow_transfer_yn\" id=\"allow_transfer_yn\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t <input type=\"hidden\" name=\"fr_daily_rate\" id=\"fr_daily_rate\" value=\"0\">\n\t <input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"0\">\n\t <input type=\"hidden\" name=\"bill_type_code\" id=\"bill_type_code\" value=\"\">\n\t<input type=\"hidden\" name=\"blng_class_code\" id=\"blng_class_code\" value=\"\">\n\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n\n\t <!-- added by senthil (28/8/2k3)  -->\n\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\"\">\n\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n<input type=\'hidden\' name=\'bl_operational\' id=\'bl_operational\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\t\n\t<!-- added by senthil (28/8/2k3) ends  -->\n\n\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<!-- START MODIFICATION BY ARUN -->\n\t\t\t<!-- MOD#02 Introduced the following hidden item corresponding to the commented billing -->\n\t\t\t\t<input type=\"hidden\" name=\"transfer_chargeable_yn\" id=\"transfer_chargeable_yn\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"transfer_serv_charge\" id=\"transfer_serv_charge\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"surgery_reqd_yn\" id=\"surgery_reqd_yn\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"addnl_dep_amt\" id=\"addnl_dep_amt\" value=\"\">\n\t\t\t<!-- Commented out billing completely \n\t\t\t<!-- MOD#01  Commented\n\t\t\t\t<table border=0 width=\"100%\" cellpadding=1 cellspacing=0>\n\t\t\t\t<th colspan=\'4\' align=\'center\'>Billing Details</th>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\"label\" width=\"25%\" nowrap>Transfer Chargeable&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\'querydata\' ><input type=\'checkbox\' name=\'transfer_chargeable_yn\' id=\'transfer_chargeable_yn\' value=\'Y\' disabled ></td>\n\t\t\t\t\t<td align=\"right\" class=\"label\"  nowrap>Transfer Charge&nbsp;</td>\n\t\t\t\t\t<td class=\'querydata\' ><input type=\'text\' style=\'text-align:right\' name=\'transfer_serv_charge\' id=\'transfer_serv_charge\' value=\'\' size=\'10\' maxlength=\'10\' readonly></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap>Additional Deposit Required&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\'querydata\'><input type=\'checkbox\' name=\'surgery_reqd_yn\' id=\'surgery_reqd_yn\' value=\'Y\' disabled></td>\n\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap>Additional Deposit Amount&nbsp;</td>\n\t\t\t\t\t<td class=\'querydata\' ><input type=\'text\' style=\'text-align:right\' name=\'addnl_dep_amt\' id=\'addnl_dep_amt\' value=\'\' size=\'10\' maxlength=\'10\' readonly></td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\tEnd of MOD#01\n\t\t\t-->\t\n\t\t<!-- END MODIFICATION BY ARUN -->\n\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\t\n\t<br>\n\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t<table border=0 width=\"30%\" cellpadding=0 cellspacing=0 align=\"right\">\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="<td>\n\t\t<!-- START MODIFICATION BY ARUN -->\n\t\t\t<!-- MOD#03 Commented out the button Compute TO HIDDEN-->\n\t\t\t<!-- <input type=\"button\" class=\"button\" value=\"Compute\" onclick=\"ComputeBlDtl();\"></td>  -->\n\t\t\t<!-- <input type=\"hidden\" class=\"button\" value=\"Compute\" onclick=\"ComputeBlDtl();\"> --></td> ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t<!-- END MODIFICATION BY ARUN -->\n\t\t\n\t\t<td><input type=\"button\" class=\"button\" name = \"confirm\" value=\"Confirm Booking Transfer\" onclick=\"OffsetDate(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\', \'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\');submitForm(\'CONFIRM\');\"></td>\n\t\t<td><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" onclick=\"OffsetDate(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'); submitForm(\'CANCEL\');\"></td>\n\t\t<td><input type=\"button\" class=\"button\" value=\"Close\" onclick=\"parent.window.close();\"></td>\n\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n</form>\t \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;
	ResultSet rset_practid		= null;
	Statement stmt1		= null;
	ResultSet rset1		= null;
	String facilityId	= (String)session.getAttribute("facility_id");

	
	try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();

	/*Following Code is to Check the Module with Billing Interface */
	String bl_interfaced_yn="";
	Statement stmt_bl =con.createStatement();
	ResultSet rs_bl=null;
	String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id='"+facilityId+"'";
	try
	{
		rs_bl=stmt_bl.executeQuery(query_bl_interface);
		if(rs_bl.next())
		{
			bl_interfaced_yn=rs_bl.getString("bl_interfaced_yn");
		}
		if(rs_bl!=null) rs_bl.close();
		if(stmt_bl!=null) stmt_bl.close();
	}
	catch(Exception e)
	{
		out.println("Exception @try1"+e);
	}


            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String patientid		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String eid					= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	long    encounterid	= Long.parseLong(eid);
	String bookingrefno = request.getParameter("booking_ref_no") == null ? "" : request.getParameter("booking_ref_no");
	String fromfunction = request.getParameter("fromFunction")==null?"":request.getParameter("fromFunction");

	StringBuffer sql	= new StringBuffer();
		String admissiondate			= "";
	String admissiontype			= "";
	String trntypecode			= "";
	String trntypedesc			= "";
	String frpractitionerid			= "";
	String frpractdesc			= "";
	String frspecialitycode			= "";
	String frspecialitydesc			= "";
	String frbedclass			= "";
	String frbedclassdesc			= "";
	String frnursingunitcode		= "";
	String frnursingunitdesc		= "";
	String frbedno				= "";
	String frroomno				= "";
	String frbedtype			= "";
	int	    frdailycharge		= 0;
	String tobedclass			= "";
	String tobedclassdesc			= "";
	String tonursingunitcode		= "";
	String tonursingunitdesc		= "";
	String tonursingunittype		= "";
	String tobedno				= "";
	String toroomno				= "";
	String tobedtype			= "";
	int	    todailycharge		= 0;
	String bookingdatetime			= "";
	String gender				= "";
	String medteamdesc 			= "";
	String allow_transfer_yn 			= "Y";
	String billing_group_id = "";
	String billing_group_desc = "";

	// By Annadurai 2/17/2004 starts.,
	String age				 = "";
	String priority			 = "";
	String default_priority	 = "";
	String max_priority		 = "";
	String sysDate		 = "";
	String disable		 = "";
	String check		 = "";

	String bl_operational =	(String)session.getAttribute("bl_operational");
	try
	{		
			
			// By Annadurai 2/17/2004., age is added in the select list(after gender).
			sql.append(" select to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date,admission_type,");
			sql.append(" admission_short_desc,fr_nursing_unit_code,fr_nursing_unit_short_desc, ");
			sql.append(" specialty_code, specialty_short_desc,practitioner_id,");
			sql.append(" practitioner_name,fr_room_no,fr_bed_no,");
			sql.append(" fr_bed_class_code,fr_bed_class_short_desc, ");
			sql.append(" '' fr_daily_charge, fr_bed_type_code,gender, ");
			sql.append(" to_bed_class_code,to_bed_class_short_desc,to_nursing_unit_to_code,");
			sql.append(" to_nursing_unit_short_desc,");
			sql.append(" to_room_no,to_bed_no,to_bed_type_code,'' to_daily_charge,to_nursing_unit_locn_type, ");
			sql.append(" transfer_type,transfer_type_short_desc,to_char(booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time, priority ");
			sql.append(" FROM  ip_bed_booking_tfr_vw ");
			sql.append(" WHERE facility_id = '"+facilityId+"' and encounter_id = "+encounterid );
			rset		= stmt.executeQuery(sql.toString());
			if(rset.next())
			{
				admissiondate			= rset.getString("admission_date") ==null ? "": rset.getString("admission_date");  
				admissiontype			= rset.getString("admission_short_desc") ==null ? "": rset.getString("admission_short_desc");
				frpractitionerid		= rset.getString("practitioner_id") ==null ? "": rset.getString("practitioner_id");                         
				frpractdesc			= rset.getString("practitioner_name") ==null ? "": rset.getString("practitioner_name");    
				frspecialitycode		= rset.getString("specialty_code") ==null ? "": rset.getString("specialty_code");                         
				frspecialitydesc		= rset.getString("specialty_short_desc") ==null ? "": rset.getString("specialty_short_desc");            
				frbedclass			= rset.getString("fr_bed_class_code") ==null ? "": rset.getString("fr_bed_class_code");                        
				frbedclassdesc			= rset.getString("fr_bed_class_short_desc") ==null ? "": rset.getString("fr_bed_class_short_desc");          
				frnursingunitcode		= rset.getString("fr_nursing_unit_code") ==null ? "": rset.getString("fr_nursing_unit_code");                  
				frnursingunitdesc		= rset.getString("fr_nursing_unit_short_desc") ==null ? "": rset.getString("fr_nursing_unit_short_desc");     
				frbedno				= rset.getString("fr_bed_no") ==null ? "": rset.getString("fr_bed_no");                                           
				frroomno			= rset.getString("fr_room_no") ==null ? "": rset.getString("fr_room_no");                                       
				frbedtype			= rset.getString("fr_bed_type_code") ==null ? "": rset.getString("fr_bed_type_code");                           
				gender				= rset.getString("gender");
				priority = rset.getString("priority")==null?"":rset.getString("priority");
				tobedclass			= rset.getString("to_bed_class_code") ==null ? "": rset.getString("to_bed_class_code");                        
				tobedclassdesc			= rset.getString("to_bed_class_short_desc") ==null ? "": rset.getString("to_bed_class_short_desc");          
				tonursingunitcode		= rset.getString("to_nursing_unit_to_code") ==null ? "": rset.getString("to_nursing_unit_to_code");                  
				tonursingunitdesc		= rset.getString("to_nursing_unit_short_desc") ==null ? "": rset.getString("to_nursing_unit_short_desc");     
				tonursingunittype		= rset.getString("to_nursing_unit_locn_type") ==null ? "": rset.getString("to_nursing_unit_locn_type");     
				tobedno				= rset.getString("to_bed_no") ==null ? "": rset.getString("to_bed_no");                                           
				toroomno			= rset.getString("to_room_no") ==null ? "": rset.getString("to_room_no");                                       
				tobedtype			= rset.getString("to_bed_type_code") ==null ? "": rset.getString("to_bed_type_code");                           
				trntypecode			= rset.getString("transfer_type") ==null ? "": rset.getString("transfer_type");                                       
				trntypedesc			= rset.getString("transfer_type_short_desc") ==null ? "": rset.getString("transfer_type_short_desc");  
				bookingdatetime     		= rset.getString("booking_date_time")==null?"":rset.getString("booking_date_time");
		}
			if(rset!=null) rset.close();
		
			if (priority.equals("P1"))
			{
				String sqlQuery = "select  TO_CHAR(SYSDATE,'dd/mm/rrrr hh24:mi') system_date , DFLT_UNIT_PRIORITY_1, MAX_PERIOD_PRIORITY_1 from ip_param, dual  where facility_id = '"+facilityId+"' ";
	
				rset_practid		= stmt.executeQuery(sqlQuery);
				if(rset_practid != null)
				{
					while(rset_practid.next())
					{
						sysDate			 = rset_practid.getString("system_date");
						default_priority = rset_practid.getString("DFLT_UNIT_PRIORITY_1");
						max_priority     = rset_practid.getString("MAX_PERIOD_PRIORITY_1");
					}
			if(rset_practid!=null) rset_practid.close();
				}
				disable = "disabled";
				check = "checked";

			}

			if(sql.length() > 0)
				sql.delete(0, sql.length());

			sql.append(" SELECT a.req_practitioner_id, b.practitioner_name, a.REQ_SPECIALTY_CODE specialty_code, c.SHORT_DESC specialty_short_desc FROM ip_bed_booking a, am_practitioner  b, am_speciality c WHERE a.facility_id = '"+facilityId+"'  and a.req_practitioner_id = b.practitioner_id AND  a.REQ_SPECIALTY_CODE = c.speciality_code AND a. encounter_id= "+encounterid+" AND a.booking_status = '0' ");

			rset_practid		= stmt.executeQuery(sql.toString());
			if(rset_practid != null)
			{
				while(rset_practid.next())
				{
					frpractitionerid = rset_practid.getString("REQ_PRACTITIONER_ID");
					if(frpractitionerid == null)
					{
						frpractitionerid = "";
					}
					frpractdesc			= rset_practid.getString("practitioner_name") ==null ? "": rset_practid.getString("practitioner_name"); 

					frspecialitycode		= rset_practid.getString("specialty_code") ==null ? "": rset_practid.getString("specialty_code");                         
					frspecialitydesc		= rset_practid.getString("specialty_short_desc") ==null ? "": rset_practid.getString("specialty_short_desc");            
				
				}
			if(rset_practid!=null) rset_practid.close();
			if(stmt!=null) stmt.close();
			}

		String medsql = " Select team_short_desc from am_pract_for_team_vw  where facility_id = '"+facilityId+"' and Team_Id = (select to_pract_team_id from ip_adt_trn where to_practitioner_id='"+frpractitionerid+"' and trn_type='A' and encounter_id='"+encounterid+"' and facility_id = '"+facilityId+"' ) ";
			stmt1 = con.createStatement();
			rset1 = stmt1.executeQuery(medsql);
			if(rset1 != null)
			{	
				if(rset1.next())
				{
					medteamdesc = rset1.getString(1);
					if(medteamdesc == null) medteamdesc ="";
				}			
				if(rset1!=null) rset1.close();
			}	
			
			// added by senthil (28/8/2k3)
		
		if(bl_operational.equals("Y"))
		{
			String bl_elig = "select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+encounterid+"'";
			rset1 = stmt1.executeQuery(bl_elig);
			while(rset1.next())
			{
				billing_group_id = rset1.getString("BLNG_GRP_ID");
				billing_group_desc = rset1.getString("SHORT_DESC");
			}
				if(rset1!=null) rset1.close();
		}
						String sql16 = " select install_yn from sm_module where module_id = 'FM' ";
						String fm_install_yn = "";
						String transfter_file_yn ="";
						String auto_file_transfer_yn ="";
						String fm_fs_locn_code="";
						String file_no="";
						rset1 = stmt1.executeQuery(sql16);
						if (rset1!=null && rset1.next())
							fm_install_yn = rset1.getString(1);
							if(rset1!=null) rset1.close();
						if (fm_install_yn.equals("Y")){
							sql16 = "Select auto_rec_ward_yn, transfer_file_yn from fm_parameter  where facility_id ='"+facilityId+"'";
						    rset1 = stmt1.executeQuery(sql16);
							if (rset1!=null && rset1.next())
							{
								transfter_file_yn = rset1.getString(2);
							}
							if(rset1!=null) rset1.close();
						if (transfter_file_yn.equals("Y")){
							sql16 = "select file_no from mr_pat_file_index where facility_id ='"+facilityId+"' and patient_id ='"+patientid+"'";
						    rset1 = stmt1.executeQuery(sql16);
							if (rset1!=null && rset1.next())
								file_no  = rset1.getString(1);
							if(rset1!=null) rset1.close();
							if (file_no==null) file_no="";
							sql16 = "Select a.auto_file_transfer_yn,a.fs_locn_code,b.locn_identity from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id ='"+facilityId+"' and a.nursing_unit_code='"+frnursingunitcode+"'";
						    rset1 = stmt1.executeQuery(sql16);
							if (rset1!=null && rset1.next())
							{
								auto_file_transfer_yn = rset1.getString(1);
								fm_fs_locn_code		  = rset1.getString(2);
								if (fm_fs_locn_code==null) fm_fs_locn_code="";
								if(rset1!=null) rset1.close();
							}
							if (fm_install_yn.equals("Y")&&transfter_file_yn.equals("Y")
								&&auto_file_transfer_yn.equals("Y")&&fm_fs_locn_code!=""&&file_no!=""){
									sql16 = "Select count(1) from fm_transit_file where  facility_id ='"+facilityId+"' and file_no='"+file_no+"'";
						    rset1 = stmt1.executeQuery(sql16);
							int cnt=0;
							if (rset1!=null && rset1.next())
								cnt =rset1.getInt(1);
								if(rset1!=null) rset1.close();
							if(cnt==0)
								allow_transfer_yn="Y";
							else								
								allow_transfer_yn="N";
							}
						}
				}



	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(frpractdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(frpractitionerid));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(frspecialitydesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(frspecialitycode));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(medteamdesc));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bookingdatetime));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bookingdatetime));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(trntypedesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(trntypecode));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(frnursingunitdesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(frnursingunitcode));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tonursingunitdesc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tonursingunitcode));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(frbedclassdesc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(frbedclass));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tobedclassdesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(tobedclass));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

	try{
		stmt = con.createStatement();
	    String sql2="Select bed_class_code,short_desc from ip_bed_class where eff_status='E' order by short_desc ";
	    rset = stmt.executeQuery(sql2);
            
            if( rset != null )
            {
	      while( rset.next() )
	      {
		 String bedcode   = rset.getString(1) ;
		 String beddesc   = rset.getString(2) ;


            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bedcode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(beddesc));
            _bw.write(_wl_block1Bytes, _wl_block1);
            }
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
	    }
	}catch(Exception e) {out.println(e.toString());}
	

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tobedclass));
            _bw.write(_wl_block43Bytes, _wl_block43);
            {java.lang.String __page ="BedClassComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(frbedno));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(frbedno));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(tobedno));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tobedno));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(frroomno));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(frroomno));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(toroomno));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(toroomno));
            _bw.write(_wl_block53Bytes, _wl_block53);

		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    String sqlBlkType ="Select blocking_type_code,short_desc,override_yn from ip_blocking_type where eff_status ='E' order by 2";
	    rset  = stmt .executeQuery(sqlBlkType );
		int indexForBlkType = 0;
	
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            {java.lang.String __page ="BlockTypeComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

						while( rset.next() ){
								String code   = rset.getString(1) ;
								String desc   = rset.getString(2) ;								

						
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
 }
							if(rset!=null) rset.close();
						
            _bw.write(_wl_block60Bytes, _wl_block60);
	
						rset.beforeFirst();
						while(rset.next()){
							String str = rset.getString(3);
							
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(indexForBlkType));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(str));
            _bw.write(_wl_block63Bytes, _wl_block63);

							indexForBlkType++;
						}

						rset  = stmt.executeQuery("Select BED_BLOCK_PERIOD_MAX from ip_param where facility_id='"+facilityId+"'");
						if(rset.next())
						{
						}
							if(rset!=null) rset.close();
							if(stmt!=null) stmt.close();
					
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(check));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(frdailycharge));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(frdailycharge));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(todailycharge));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(todailycharge));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bookingrefno));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(age));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tonursingunittype));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(tobedtype));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(allow_transfer_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block83Bytes, _wl_block83);

	if(bl_interfaced_yn.equals("Y"))
	{
	
            _bw.write(_wl_block84Bytes, _wl_block84);

	}
	
            _bw.write(_wl_block85Bytes, _wl_block85);
if(!fromfunction.equals("Q")){
            _bw.write(_wl_block86Bytes, _wl_block86);
 if(bl_interfaced_yn.equals("Y")) {
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(sysDate));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(max_priority));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(default_priority));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelTransfer.label","common_labels")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(sysDate));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(max_priority));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(default_priority));
            _bw.write(_wl_block92Bytes, _wl_block92);

	}
		if(rset		!= null)   rset.close();
		if(rs_bl	!= null)   rs_bl.close();
												   
		if(stmt1   != null)   stmt1.close();
		if(rset1   != null)   rset1.close();
		if(stmt   != null)   stmt.close();
		if(stmt_bl   != null)   stmt_bl.close();

	}catch(Exception e){
		out.print("Exception :"+e);
	}

}catch(Exception e){}
finally
{
	ConnectionManager.returnConnection(con,request);
	
}
	 
            _bw.write(_wl_block93Bytes, _wl_block93);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferBookingDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferType.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CurrentOccupancy.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferTo.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforCancellation.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
