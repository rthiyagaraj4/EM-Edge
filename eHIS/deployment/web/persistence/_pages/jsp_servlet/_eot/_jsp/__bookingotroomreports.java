package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __bookingotroomreports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/BookingOTRoomReports.jsp", 1722948776000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- Added New file against AAKH-CRF-0071 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n<title></title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OtReports.js\" ></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTReportsLkupSQL.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/Booking.js\"></script>\n<script language=\"JavaScript\">\n\tvar locale = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\n\tfunction enableCtrl(enableField1, enableField2, valField, thisObj)\n\t{\t\n\t\tvalField.value = \"\";\n\t\tdocument.getElementById(\"locationCode\").value=\"\";//58598\n\t\tif(thisObj.value != \"\")\n\t\t{\n\t\t\tdocument.getElementById(enableField1).disabled = false;\n\t\t\tdocument.getElementById(enableField2).disabled = false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(enableField1).disabled = true; \n\t\t\tdocument.getElementById(enableField2).disabled = true; \n\t\t}\n\t}\n\tasync function populateLocations(target,code)\n\t{\n\t\t//formobj=parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr;\n\t\tlocation_type=document.forms[0].location_type.value;\n\t\tvar argumentArray  = new Array() ;\n\t\tvar dataNameArray  = new Array() ;\n\t\tvar dataValueArray = new Array() ;\n\t\tvar dataTypeArray  = new Array() ;\n\t\tif(location_type!=\'\')\n\t\t{\n\t\t\tlocaleName=document.forms[0].locale.value;\n\t\t\tvar sql=\"\";\n\t\t\tpractitioner_id=document.forms[0].p_user_id.value;\t\n\t\t\tfacility_id=document.forms[0].facility_id.value;\t\n\t\tif(location_type!=\"C\")\n\t\t\t{\t\t\t\n\t\t\t//if(location_type!=null && location_type==\"C\")\n\t\t\t  // location_type\t= \"OP\";\n\t\t\tif(location_type!=null && location_type==\"D\")\n\t\t\t\t   location_type\t= \"DC\";\n\t\t\t\telse if(location_type!=null && location_type==\"E\")\n\t\t\t\t   location_type\t= \"EM\";\n\t\t\t\telse if(location_type!=null && location_type==\"N\")\n\t\t\t\t   location_type\t= \"IP\";\n\t\t\t\tdataNameArray[0] = \"PATIENT_CLASS\";\n\t\t\t\tdataValueArray[0] = location_type;\n\t\t\t\tdataTypeArray[0] = STRING;\n\t\t\t\tdataNameArray[1] = \"FACILITY_ID\";\n\t\t\t\tdataValueArray[1] = facility_id;\n\t\t\t\tdataTypeArray[1] = STRING;\n\t\t\t\tdataNameArray[2] = \"FACILITY_ID\";\n\t\t\t\tdataValueArray[2] = facility_id;\n\t\t\t\tdataTypeArray[2] = STRING;  \n\t\t\t}\n\t\tif(location_type==\"C\")\n\t\t\t{\n\t\t\t\tsql=sql=document.forms[0].procedure_sql.value;\n\t\t\t\tsql=sql.replace(\'?\',\"\'\"+localeName+\"\'\");\n\t\t\t}else\n\t\t\t{\n\t\t\t\tsql = document.forms[0].location_sql.value;\n\t\t\t\tfor(x=0;x<5;x++)\n\t\t\t\t{\n\t\t\t\t\tsql=sql.replace(\'?\',\"\'\"+localeName+\"\'\");\n\t\t\t\t}\n\t\t\t\t//sql=sql.replace(\'?\',\"\'\"+practitioner_id+\"\'\");\n\t\t\t}\n\t\t\t\n\t\t\tif(location_type!=null && location_type==\"D\")\n\t\t\t{\n\t\t\t\tsql = sql.replace(\"##FILTER##\",\" and CLINIC_TYPE=\'Y\' \");\n\t\t\t}\n\t\t\telse if(location_type!=null && location_type==\"E\")\n\t\t\t{\n\t\t\t\tsql = sql.replace(\"##FILTER##\",\" and CLINIC_TYPE=\'C\' AND LEVEL_OF_CARE_IND=\'E\' \");\n\t\t\t}\n\t\t\telse if(location_type!=null && location_type==\"C\")\n\t\t\t{\n\t\t\t\tsql = sql.replace(\"##FILTER##\",\" and CLINIC_TYPE=\'C\' AND LEVEL_OF_CARE_IND=\'A\' \");\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tsql = sql.replace(\"##FILTER##\",\" \");\n\t\t\t}\n\t\t\t\n\t\t\targumentArray[0]   = sql;\n\t\t\targumentArray[1]   = dataNameArray ;\n\t\t\targumentArray[2]   = dataValueArray ;\n\t\t\targumentArray[3]   = dataTypeArray ;\n\t\t\tif(location_type==\"C\")\n\t\t\t{\n\t\t\t\targumentArray[4]   = \"1,2\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\targumentArray[4]   = \"4,5\";\n\t\t\t}\n\t\t\targumentArray[5]   = target.value;\n\t\t\targumentArray[6]   = CODE_LINK ;\n\t\t\targumentArray[7]   = CODE_DESC ;\n\t\t\tretVal = await CommonLookup(getLabel(\"Common.Location.label\",\"Common\") , argumentArray );\n\t\t\tif(retVal !=null && retVal != \"\")\n\t\t\t{var ret1=unescape(retVal);\n\t\t \tarr=ret1.split(\",\");\n\t\t\t\tcode.value=arr[0];\n\t\t\t\ttarget.value=arr[1];\n\t\t\t\tdocument.forms[0].locationCode.value = arr[0];\n\t\t\t}else{\n\t\t\t\tnationality_code.value = arr[0]; \n\t\t\tnationality_desc.value = arr[1]; \n\t\t\tdesc.value=arr[1];\n\t\t\tcode.value=arr[0];\n\t\t\t\ttarget.value = \"\";\n\t\t\t\tcode.value = \"\" ;\n\t\t\t}\n\t\t}\n}\n\nfunction validDateObj(date, format, locale){\n\tif(date.value != \'\'){\n\t\tvar dateValue=date.value;\n\t\tvar dateArray=\"\";\n\t\tvar dateArray1;\n\t\tvar checkFlag=true;\n\t\tif(format==\"DMY\"){\n\t\t\tdateArray=dateValue.split(\"/\");\n\t\t\tif(dateArray[2]==0){\n\t\t\t\tcheckFlag=false;\n\t\t\t}else{\n\t\t\t\tif(locale==\'th\'){\n\t\t\t\t\tif(dateArray[2]<=543){\n\t\t\t\t\t\tcheckFlag=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}else if(format==\"DMYHM\"){\n\t\t\tdateArray1=dateValue.split(\" \");\n\t\t\tdateArray=(dateArray1[0]).split(\"/\");\n\t\t\tif(dateArray[2]==0){\n\t\t\t\tcheckFlag=false;\n\t\t\t}else{\n\t\t\t\tif(locale==\'th\'){\n\t\t\t\t\tif(dateArray[2]<=543){\n\t\t\t\t\t\tcheckFlag=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(dateArray1.length >1){\n\t\t\t\tvar time1arr=dateArray1[1].split(\":\")\n\t\t\t\tif(time1arr.length==2)\n\t\t\t\t{\n\t\t\t\t\tvar time1hr=time1arr[0]\n\t\t\t\t\tvar time1min=time1arr[1]\n\t\t\t\t\tif (time1hr.length != 2 || time1min.length != 2)\n\t\t\t\t\t{\n\t\t\t\t\t\t checkFlag=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}else if(format==\"DMYHMS\"){\t\t\t\n\t\t\tdateArray1=dateValue.split(\" \");\n\t\t\tdateArray=(dateArray1[0]).split(\"/\");\n\t\t\tif(dateArray[2]==0){\n\t\t\t\tcheckFlag=false;\n\t\t\t}else{\n\t\t\t\tif(locale==\'th\'){\n\t\t\t\t\tif(dateArray[2]<=543){\n\t\t\t\t\t\tcheckFlag=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tvar time1arr=dateArray1[1].split(\":\")\n\t\t\tif(time1arr.length==3)\n            {\n\t\t\t\tvar time1hr=time1arr[0]\n\t\t\t\tvar time1min=time1arr[1]\n\t\t\t\tvar time1sec=time1arr[2]\n\t\t\t\tif (time1hr.length != 2 || time1min.length != 2 || time1sec.length != 2)\n\t\t\t\t{\n\t\t\t\t\t checkFlag=false;\n\t\t\t\t}\n\t\t\t}\n\t\t}else if(format==\"YY\"){\n\t\t\tif(date==0){\n\t\t\t\tcheckFlag=false;\n\t\t\t}else{\n\t\t\t\tif(locale==\'th\'){\n\t\t\t\t\tif(dateArray[2]<=543){\n\t\t\t\t\t\tcheckFlag=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}else if(format==\"MY\"){\n\t\t\tdateArray=dateValue.split(\"/\");\n\t\t\tif(dateArray[1]==0){\n\t\t\t\tcheckFlag=false;\n\t\t\t}else{\n\t\t\t\tif(locale==\'th\'){\n\t\t\t\t\tif(dateArray[2]<=543){\n\t\t\t\t\t\tcheckFlag=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\n\t\tif(checkFlag){\n\t\t\tif(!validDate(date.value,format,locale)){\n\t\t\t\tif(top.header != null){\n\t\t\t\t//alert(\'318\');\n\t\t\t\t\talert(top.header.getMessage(\"INVALID_DATE_FMT\", \"SM\"));\n\t\t\t\t}else{\n\t\t\t\t//alert(\'320\');\n\t\t\t\t\talert(getMessage(\"INVALID_DATE_FMT\", \"SM\"));\n\t\t\t\t}\n\t\t\t\tdate.select();\n\t\t\t\tdate.focus();\n\t\t\t\treturn false;\n\t\t\t}else{\n\t\t\t\treturn true;\n\t\t\t}\n\t\t}else{\n\t\t\tvar msg=getMessage(\"INVALID_VALUE\", \"COMMON\");\n\t\t\t//alert(\'330\');\n\t\t\talert(getMessage(\"INVALID_DATE_FMT\", \"SM\"));\n\t\t\t//alert(msg.replace(\'#\',getLabel(\"Common.date.label\",\"Common\")));\n\t\t\tdate.select();\n\t\t\tdate.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<!-- <form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">  Commented against IN057879-->\n<form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eOT/jsp/OTReportsIntermediate.jsp\"  target=\"messageFrame\">\n  <table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\'>\n  <tr>\n    <td class=\'label\' width=\"21%\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n    <td class=\'fields\' colspan=\"3\"><input type=\'text\' name=\'param1_disp\' id=\'param1_disp\' size=\'8\' maxlength=\'10\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onKeyPress=\"return checkForSpecCharsforID(event);\" onBlur=\"isValidDate(this);\">\n      <img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'param1_disp\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img> \n      <!-- Added against IN057879 -->\n      \n      <input type=\'hidden\' name=\'param1\' id=\'param1\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'></td>\n  </tr>\n  <tr>\n    <td class=\'label\' width=\"21%\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n    <td class=\'label\' width=\"23%\" nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n    <td class=\'label\' width=\"18%\" nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n    <td class=\'label\' width=\"38%\" nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n  </tr>\n  <tr>\n    <td class=\'label\' width=\"21%\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n    <td class=\'fields\' width=\"23%\" ><input type=\'text\' name=\'section1_from\' id=\'section1_from\' size=\'6\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  readonly></td>\n    <td class=\'fields\' width=\"18%\"><input type=\'text\' name=\'section2_from\' id=\'section2_from\' size=\'6\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" readonly></td>\n    <td class=\'fields\' width=\"38%\"><input type=\'text\' name=\'section3_from\' id=\'section3_from\' size=\'6\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" readonly></td>\n  </tr>\n  <tr>\n    <td class=\'label\' width=\"21%\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n    <td class=\'fields\' width=\"23%\" ><input type=\'text\' name=\'section1_to\' id=\'section1_to\' size=\'6\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" readonly></td>\n    <td class=\'fields\' width=\"18%\" ><input type=\'text\' name=\'section2_to\' id=\'section2_to\' size=\'6\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" readonly></td>\n    <td class=\'fields\' width=\"38%\" ><input type=\'text\' name=\'section3_to\' id=\'section3_to\' size=\'6\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" readonly></td>\n  </tr>\n  <tr>\n    <td class=\'label\' width=\"21%\" nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n    <td class=\'fields\' width=\"23%\" ><input type=\'hidden\' name=\'param8\' id=\'param8\'>\n      <input type=\'hidden\' name=\'param9\' id=\'param9\'>\n      <input type=\'text\' name=\'from_oper_room_desc\' id=\'from_oper_room_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' param1 = \'param8\'  param2 = \'param9\' key =\'OPER_ROOM\' onBlur=\"if(this.value!=\'\')callCommonLookupORList(this,document.OtReportOptionsForm.P_OPER_ROOM_CODE); else from_oper_room_desc.value=\'\',P_OPER_ROOM_CODE.value=\'\' \"  >\n      <input type=\'button\' class=\'button\' value=\'?\' name=\'OperRoomLookUp\' id=\'OperRoomLookUp\'  onClick=\"callCommonLookupORList(from_oper_room_desc,document.OtReportOptionsForm.P_OPER_ROOM_CODE);\" >\n      <input type=\"hidden\" name=\"P_OPER_ROOM_CODE\" id=\"P_OPER_ROOM_CODE\" value=\"\"></td>\n    <td class=\'label\' width=\"18%\" nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n    <td  class=\'fields\' width=\"38%\" ><input type=\'hidden\' name=\'param14\' id=\'param14\'>\n      <input type=\'hidden\' name=\'param15\' id=\'param15\'>\n      <input type=\'text\' name=\'from_speciality_desc\' id=\'from_speciality_desc\' size=\'20\'  title=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' param1 = \'param14\'  param2 = \'param15\' key =\'SPECIALITY\' onBlur=\"if(this.value!=\'\')callCommonLookupORList(this,document.OtReportOptionsForm.P_SPECIALITY_CODE); else from_speciality_desc.value=\'\',P_SPECIALITY_CODE.value=\'\'\" >\n      <input type=\'button\' class=\'button\' value=\'?\' name=\'SpecialityLookUp\' id=\'SpecialityLookUp\'     onClick=\"callCommonLookupORList(from_speciality_desc,document.OtReportOptionsForm.P_SPECIALITY_CODE);\"  >\n      <input type=\"hidden\" name=\"P_SPECIALITY_CODE\" id=\"P_SPECIALITY_CODE\" value=\"\"></td>\n  </tr>\n  <tr>\n    <td class=\'label\' width=\"21%\" nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n    <td class=\'fields\' width=\"23%\" ><input type=\'hidden\' name=\'param17\' id=\'param17\'>\n      <input type=\'hidden\' name=\'param16\' id=\'param16\'>\n      <input type=\'text\' name=\'param16_desc\' id=\'param16_desc\' size=\'20\'title=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' param1 = \'param16\'  param2 = \'param17\' key =\'SURGEON\' onBlur=\"if(this.value!=\'\')callCommonLookupORList(this,document.OtReportOptionsForm.surgeon); else param16.value=\'\',surgeon.value=\'\' \" >\n      <input type=\'button\' class=\'button\' value=\'?\' name=\'SurgeonLookUp\' id=\'SurgeonLookUp\' onClick=\"callCommonLookupORList(param16_desc,document.OtReportOptionsForm.surgeon);\" >\n      <input type=\"hidden\" name=\"surgeon\" id=\"surgeon\" value=\"\"></td>\n    <td align=\"left\" class=\"label\" width=\"18%\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n    <td class=fields width=\"38%\"><SELECT name=\"location_type\" id=\"location_type\" onChange=\"enableCtrl(\'location\',\'btnLocation\',location,this);\">\n        <option value=\"\">-----\n        ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n        -----</option>\n        <option value=\"C\">\n        ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n        </option>\n        <option value=\'D\'>\n        ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n        </option>\n        <option value=\'E\'>\n        ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n        </option>\n        <option value=\'N\'>\n        ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n        </option>\n        <!--<option value=\'P\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>-->\n      </SELECT>\n      \n      <!-- ML-MMOH-CRF-0752.3-US001 -->\n      \n      <input type=\"text\" name=\"location\" id=\"location\" onBlur=\"if(this.value!=\'\')populateLocations(location,location);else location.value=\'\',locationCode.value=\'\'\" value=\"\" size=\'40\' disabled=true>\n      <input type=\"hidden\" name=\"locationCode\" id=\"locationCode\" value=\"\">\n      <input type=\"button\" class=button value=\'?\' name=\"btnLocation\" id=\"btnLocation\" onClick=\"populateLocations(location,location)\" disabled=true></td>\n  </tr>\n  <!-- Added extra against Location type and location -->\n  <tr>\n    <td class=\'label\' width=\"21%\" nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n    <td class=\'fields\' width=\"23%\" ><select name=\"param12\" id=\"param12\" id=\"param12\" >\n        <option value= \"*ALL\" >\n        ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n        </option>\n        ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n        <option value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" </option>\n        ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n      </select></td>\n  </tr>\n  <!-- Added extra against Location type and location -->\n  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n  <input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n  <input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n  <input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n  <input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n  <input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n  <input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n  <input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"OTORLIST\">\n  <input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTORLIST\">\n  <input type=\"hidden\" name=\"sql_text_5\" id=\"sql_text_5\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" disabled>\n  <input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"1\" disabled>\n  <input type=\"hidden\" name=\"mandatory_fm_1\" id=\"mandatory_fm_1\" value=\"param1##";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" disabled>\n  <!--<input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"3\" disabled>-->\n  <input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"2\" disabled>\n  <input type=\"hidden\" name=\"compare_fm_1\" id=\"compare_fm_1\" value=\"param8##Operation Room\" disabled>\n  <!--<input type=\"hidden\" name=\"compare_to_1\" id=\"compare_to_1\" value=\"param9\" disabled>-->\n  <input type=\"hidden\" name=\"compare_to_1\" id=\"compare_to_1\" value=\"P_OPER_ROOM_CODE\" disabled>\n  <input type=\"hidden\" name=\"compare_fm_2\" id=\"compare_fm_2\" value=\"param14##Speciality\" disabled>\n  <!--<input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"param15\" disabled>-->\n  <input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"P_SPECIALITY_CODE\" disabled>\n  <input type=\"hidden\" name=\"compare_fm_3\" id=\"compare_fm_3\" value=\"param10##Ward\" disabled>\n  <input type=\"hidden\" name=\"compare_to_3\" id=\"compare_to_3\" value=\"param11\" disabled>\n  <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n  <input type=\'hidden\' name=\"p_language_id\" id=\"p_language_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n  <input type=\"hidden\" name=\"location_sql\" id=\"location_sql\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n  <input type=\"hidden\" name=\"procedure_sql\" id=\"procedure_sql\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n </table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String asst_surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AsstSurgeon.Label","ot_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	String noticedate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BookingDaterep.Label","ot_labels");	
	
	String bean_id		= "OR_ListBean";
	String bean_name	= "eOT.OR_ListBean";
	OR_ListBean   bean  = (OR_ListBean)mh.getBeanObject(bean_id, request, bean_name);

	HashMap PatientType=new HashMap();
	HashMap OT_Notification=new HashMap();
	HashMap Surgery_Type=new HashMap();

	PatientType=(HashMap)bean.getPatientType();
	OT_Notification=(HashMap)bean.getOTNotification(facility_id);
	Surgery_Type=(HashMap)bean.getSurgeryType();
	
	Iterator PatientTypeIterator= PatientType.entrySet().iterator();
	Iterator SurgeryTypeIterator= Surgery_Type.entrySet().iterator();

	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";

	try{
			String	sql="SELECT TO_CHAR((SYSDATE+1), 'DD/MM/YYYY') TDATE, TO_CHAR(OT_SEC1_NOTICE_FM_TIME,'hh24:mi') SEC1_FM_TIME1,TO_CHAR(OT_SEC1_NOTICE_TO_TIME,'hh24:mi') SEC1_TO_TIME1,      TO_CHAR(OT_SEC2_NOTICE_FM_TIME,'hh24:mi') SEC2_FM_TIME1,  TO_CHAR(OT_SEC2_NOTICE_TO_TIME,'hh24:mi') SEC2_TO_TIME1,       TO_CHAR(OT_SEC3_NOTICE_FM_TIME,'hh24:mi') SEC3_FM_TIME1,  TO_CHAR(OT_SEC3_NOTICE_TO_TIME,'hh24:mi')SEC3_TO_TIME1  FROM OT_PARAM_FOR_FACILITY    WHERE OPERATING_FACILITY_ID = ?";

			String sql_patient_type = "SELECT patient_class,  short_desc  FROM am_patient_class_lang_vw WHERE patient_class IN ('IP', 'OP', 'EM', 'XT', 'DC')	and language_id =?";

			String fdate="";
			String strSecFr1="";
			String strSecFr2="";
			String strSecFr3="";
			String strSecTo1="";
			String strSecTo2="";
			String strSecTo3="";		
			fdate=com.ehis.util.DateUtils.convertDate(checkForNull(OT_Notification.get("tdate").toString()),"DMY","en",locale);	
			strSecFr1=checkForNull(OT_Notification.get("sec1_fm_time1").toString());
			strSecFr2=checkForNull(OT_Notification.get("sec2_fm_time1").toString());
			strSecFr3=checkForNull(OT_Notification.get("sec3_fm_time1").toString());
			strSecTo1=checkForNull(OT_Notification.get("sec1_to_time1").toString());
			strSecTo2=checkForNull(OT_Notification.get("sec2_to_time1").toString());
			strSecTo3=checkForNull(OT_Notification.get("sec3_to_time1").toString());		

            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( locale ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(fdate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DateUtils.convertDate(fdate,"DMY",locale,"en")));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strSecFr1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strSecFr2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strSecFr3));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strSecTo1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strSecTo2));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strSecTo3));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(operationRoom_title));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(speciality_title));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(surgeon_title));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
 
			while(SurgeryTypeIterator.hasNext())
			{
				Map.Entry mapEntry = (Map.Entry) SurgeryTypeIterator.next();
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mapEntry.getKey()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mapEntry.getValue()));
            _bw.write(_wl_block43Bytes, _wl_block43);
   }//end of while-loop
            _bw.write(_wl_block44Bytes, _wl_block44);
 
	 }catch(Exception e){
			System.err.println("Err Msg NotifListByOTRoomReport.jsp "+e);
			System.err.println("Err Msg NotifListByOTRoomReport.jsp "+e.getMessage());
		}finally{
			System.err.println("Finally Block");
	}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(sql_surgery_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(noticedate));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( OTRepository.getOTKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(OTRepository.getOTKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT_PROCEDURE_LOOKUP")));
            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BookingDaterep.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Section1.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Section2.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Section3.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcedureUnit.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
}
