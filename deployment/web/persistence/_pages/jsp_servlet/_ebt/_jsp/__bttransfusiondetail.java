package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __bttransfusiondetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/BTTransfusionDetail.jsp", 1741171480478L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTTransaction.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMessage.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMaster.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n\n<script Language=\"JavaScript\">\n\n\n \nfunction verifyUnitCheck(obj)\n{\n\n var strValue=\"PATIENT_ID=\\\"\"+obj.PATIENT_ID+\"\\\" \";\n strValue+=\"OPERATING_FACILITY_ID=\\\"\"+obj.OPERATING_FACILITY_ID+\"\\\" \";\n strValue+=\"SPECIMEN_NO=\\\"\"+obj.SPECIMEN_NO+\"\\\" \";\n strValue+=\"PRODUCT_CODE=\\\"\"+obj.PRODUCT_CODE+\"\\\" \";\n strValue+=\"UNIT_NO=\\\"\"+obj.UNIT_NO+\"\\\" \";\n strValue+=\"EXTERNAL_TRANSFER=\\\"\"+obj.EXTERNAL_TRANSFER+\"\\\"\";//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589\n\n var xmlForm=\"<root> <dummyXml \";\n xmlForm+=strValue;\n xmlForm+=\"/></root>\";\n\n\tvar isUnitNoProdCodeScanAppl = document.forms[0].isUnitNoProdCodeScanAppl.value;//Added on 19th Mar 2018 against MMS-DM-CRF-0137\n\t//alert(xmlForm);\n\n    var xmlDoc=\"\";\n    var xmlHttp = new XMLHttpRequest();\n\n    xmlDoc.loadXML(xmlForm);\t\n\n\txmlHttp.open(\"POST\", \"../../servlet/eBT.BTUnitCheckServlet\", false);\n\n    xmlHttp.send(xmlDoc);\n\n\tvar resTxt=xmlHttp.responseText;\n\n//\talert(\"Response Text\"+resTxt);\n\n\n\n\nif(resTxt==null||resTxt.charAt(0)==\'Y\'|| resTxt.charAt(0)==\'y\'||resTxt.charAt(0)==\'0\' )\t\n\t{\n\tif(resTxt!=null)\n\t\t{\n\tvar err=new Array();err=resTxt.split(\"||\");\n\t\n\talert(getBTMessage(err[1],\'BT\'));\n\n\t/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/\n\tif(isUnitNoProdCodeScanAppl == \"true\"){\n\t\tdocument.forms[0].ProductCode.value = \"\";\n\t\tdocument.forms[0].ProductCode.disabled = true;\n\t\tdocument.forms[0].ProductImg.style.visibility = \'hidden\';\n\t\tdocument.forms[0].UnitNo.value = \"\";\n\t\tdocument.forms[0].UnitNo.focus();\n\t}\n\t/*End*/\n\n\t\t}\n\treturn false;\n\t}\n\telse\t\n\t\tif(resTxt.charAt(0)==\'X\'||resTxt.charAt(0)==\'x\')\n\t{\n\tvar err=new Array();err=resTxt.split(\"||\");\n\t\n\n\tvar dt=window.confirm(getBTMessage(err[1],\'BT\'));\n\n\treturn dt;\t\t\n\t}\n\telse\n\treturn true;\n}\n\n\nfunction fun(obj)\n {\n//verify procedure calling IF state == \'E\' show error text else show WindowDialog\n\n\t/*var dialogHeight \t\t= \"20\" ;\n\tvar dialogWidth  \t\t= \"42\" ;\n\tvar dialogTop   \t\t= \"200\";\n\tvar dialogLeft   \t\t= \"50\";\n\t*/\n\n\tvar isUnitNoProdCodeScanAppl = document.forms[0].isUnitNoProdCodeScanAppl.value;//Added on 19th Mar 2018 against MMS-DM-CRF-0137\n\tvar bar_code_scan_site_YN    = document.forms[0].bar_code_scan_site_YN.value;\n\tvar entry_type               =document.forms[0].entry_type.value;\n\tvar encounter_id             =document.forms[0].encounter_id.value;// Added for MMS-DM-CRF-0170.2\n\tvar patient_class            =document.forms[0].patient_class.value;// Added for MMS-DM-CRF-0170.2\n\tvar scan_count_required_yn   = document.forms[0].scan_count_required_yn.value;// Added for MMS-DM-CRF-0170.2\n    var alert_required_yn        =document.forms[0].alert_required_yn.value;// Added for MMS-DM-CRF-0170.2\n    var remarks_required_yn      =document.forms[0].remarks_required_yn.value;// Added for MMS-DM-CRF-0170.2\n\n\t\n\tvar dialogHeight \t\t= \"23\" ;\n\tvar dialogWidth  \t\t= \"50\" ;\n\tvar dialogTop   \t\t= \"280\";\n\tvar dialogLeft   \t\t= \"150\";\n\n/*\tvar dialogHeight \t\t= \"22\" ;\n\tvar dialogWidth  \t\t= \"42\" ;\n\tvar dialogTop   \t\t= \"320\";\n\tvar dialogLeft   \t\t= \"150\";*/\n\t\n\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\n\tvar arguments\t\t\t= \"\" ;\n\n\t//alert(\"here only\");\n\n\tif(verifyUnitCheck(obj)==false) \n\t {\n\t\tobj.checked=false;\n\n\t\t/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/\n\t\tif(isUnitNoProdCodeScanAppl == \"true\"){\n\t\t\tdocument.forms[0].ProductCode.value = \"\";\n\t\t\tdocument.forms[0].ProductCode.disabled = true;\n\t\t\tdocument.forms[0].ProductImg.style.visibility = \'hidden\';\n\t\t\tdocument.forms[0].UnitNo.value = \"\";\n\t\t\tdocument.forms[0].UnitNo.focus();\n\t\t}\n\t\t/*End*/\n\n\t\treturn false;\t \n\t }\n\t\n\tvar strValue=\"PATIENT_ID=\"+obj.PATIENT_ID+\"&\";\n\t strValue+=\"OPERATING_FACILITY_ID=\"+obj.OPERATING_FACILITY_ID+\"&\";\n\t strValue+=\"SPECIMEN_NO=\"+obj.SPECIMEN_NO+\"&\";\n \t strValue+=\"PRODUCT_CODE=\"+obj.PRODUCT_CODE+\"&\";\n  \t strValue+=\"ROW_ID=\"+obj.ROW_ID+\"&\";\n  \t strValue+=\"CURRENT_VOLUME=\"+obj.CURRENT_VOLUME+\"&\";\n\t strValue+=\"VOLUME_UNITS=\"+obj.VOLUME_UNITS+\"&\";\n\t strValue+=\"ISSUED_DATE=\"+obj.ISSUED_DATE+\"&\";\n\t strValue+=\"RESERVED_DATE=\"+obj.RESERVED_DATE+\"&\";\n\t strValue+=\"SYDATE=\"+obj.SYDATE+\"&\";\t\n\t strValue+=\"UNIT_NO=\"+obj.UNIT_NO+\"&\";\n\tstrValue+=\"RHESUS_CODE=\"+obj.RHESUS_CODE+\"&\";\n\tstrValue+=\"BLOOD_GROUP=\"+obj.BLOOD_GROUP+\"&\";\n\tstrValue+=\"BAR_CODE_SCAN_SITE_YN=\"+bar_code_scan_site_YN+\"&\";// Added for MMS-DM-CRF-0157\n\tstrValue+=\"ENTRY_TYPE=\"+entry_type+\"&\";//Added for MMS-DM-CRF-0157\n\tstrValue+=\"ENCOUNTER_ID=\"+encounter_id+\"&\";// Added for MMS-DM-CRF-0170.2\n\tstrValue+=\"PATIENT_CLASS=\"+patient_class+\"&\";// Added for MMS-DM-CRF-0170.2\n\tstrValue+=\"SCAN_COUNT_REQUIRED_YN=\"+scan_count_required_yn+\"&\";// Added for MMS-DM-CRF-0170.2\n\tstrValue+=\"ALERT_REQUIRED_YN=\"+alert_required_yn+\"&\";// Added for MMS-DM-CRF-0170.2\n\tstrValue+=\"REMARKS_REQUIRED_YN=\"+remarks_required_yn;// Added for MMS-DM-CRF-0170.2\n//alert(\"strValue==\"+strValue);\n\n\n         \n\t\n\tretVal=window.showModalDialog(\"../../eBT/jsp/BTTransfusionDlg.jsp?\"+strValue,arguments,features);\n\n\t//\tparent.frames[3].location.href =\"../../eBT/jsp/BTTransfusionDlg.jsp?\"+strValue;\n\n\n\t//alert(\"Successfully Completed\"+retVal);\n\n\n\tif(retVal!=null && retVal.charAt(0)==\'1\')\t\n\t {\n\t\tobj.disabled=true;\t\t    \n\t\tvar objSel=\"document.forms[0].\"+obj.ROW_ID;\n\t\t//alert(objSel);\t\t\n\t\tvar objSell=eval(objSel);\n\t\t//alert(objSell.name);\n\t\tobjSell.value=\'UT\';\n\n\t\t/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/\n\t\tif(isUnitNoProdCodeScanAppl == \"true\"){\n\t\t\tdocument.forms[0].ProductCode.value = \"\";\n\t\t\tdocument.forms[0].ProductCode.disabled = true;\n\t\t\tdocument.forms[0].ProductImg.style.visibility = \'hidden\';\n\t\t\tdocument.forms[0].UnitNo.value = \"\";\n\t\t\tdocument.forms[0].UnitNo.focus();\n\t\t}\n\t\t/*End*/\n\t\t\n\t\t/*Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589*/\n\t\talert(getMessage(\"UNIT_TRANSFUSED\",\'BT\'));\n\t\tfunBTTransfusionHistory(parent.frames[1].document.forms[0]);\n\t\t/*End ML-MMOH-CRF-0589*/\n\t }\n\t else \n\t {   \n\t\t  obj.checked= false;\n\n\t\t/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/\n\t\tif(isUnitNoProdCodeScanAppl == \"true\"){\n\t\t\tdocument.forms[0].ProductCode.value = \"\";\n\t\t\tdocument.forms[0].ProductCode.disabled = true;\n\t\t\tdocument.forms[0].ProductImg.style.visibility = \'hidden\';\n\t\t\tdocument.forms[0].UnitNo.value = \"\";\n\t\t\tdocument.forms[0].UnitNo.focus();\n\t\t}\n\t\t/*End*/\n  \t\t \n\t\t  if(retVal!=null)\n\t\t {\n\t\t alert(getBTMessage(retVal,\'BT\'));\n\t\t\n\t\t funBTTransfusionHistory(parent.frames[1].document.forms[0]);\n\t\t }\n\t }\n\n }\n\nfunction submitFormN()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from + maxval;\n\t\tdocument.forms[0].to.value = to + maxval;\n\t\tdocument.forms[0].submit();\n\t}\nfunction submitFormP()\n{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from - maxval;\n\t\tdocument.forms[0].to.value = to - maxval;\n\t\tdocument.forms[0].submit();\n}\n\n\n\n </script>\n\n\n<style>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\tTD.";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="{\n\t\tBACKGROUND-COLOR:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</style>\n</head>\n<!--Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137-->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<!--Onload Added on 19th Mar 2018 against MMS-DM-CRF-0137-->\n<body onload=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="document.forms[0].UnitNo.focus();";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<form name=\'form_query\' id=\'form_query\' RECORD_ID_NAME=\'ROWID\' DETAIL_BLOCK_NAME=\'BTTable\' method=\'post\' action=\'BTTransfusionDetail.jsp\'>\n\n<!--Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137-->\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<table border=\'0\' width=\'40%\' cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<td class=\'fields\'><input type=\'text\' name=\'UnitNo\' id=\'UnitNo\' value=\'\' onChange=\"compareUnitNo(this.value);\" onKeydown=\"unitNoBarCodeChk(event, this.value); return CheckForSpecCharsInUnitProdCode(event);\" onblur=\"unitNoBarCodeChk(event, this.value);disableProductCode();\" maxlength=\"20\" size=\"25\"/></td><!-- unitNoBarCodeChk changed from onkeypres to onkeydown for mms-kh-crf-0091-->\n\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\'fields\'><input type=\'text\' name=\'ProductCode\' id=\'ProductCode\' value=\'\' onChange=\"compareProductCode(this.value);\" onKeyPress=\"prodCodeBarCodeChk(event, this.value); return CheckForSpecCharsInUnitProdCode(event);\" maxlength=\"10\" size=\"20\" disabled/><img name=\"ProductImg\" style=\"visibility:hidden\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<!--End MMS-DM-CRF-0137-->\n\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n\t\t<table align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t<td align=\'right\' colspan=\'5\'>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\t\t\n\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\'hidden\' name=\'column_sizes\' id=\'column_sizes\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\'hidden\' name=\'column_descriptions\' id=\'column_descriptions\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\'hidden\' name=\'specimen_no\' id=\'specimen_no\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\t    \n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\t    \n\t\t<input type=\'hidden\' name=\'order_facility_id\' id=\'order_facility_id\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\t \n\t\t<!--Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137-->\n\t\t<input type=\'hidden\' name=\'UnitNoFld\' id=\'UnitNoFld\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\'hidden\' name=\'ProductCodeFld\' id=\'ProductCodeFld\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\'hidden\' name=\'isUnitNoProdCodeScanAppl\' id=\'isUnitNoProdCodeScanAppl\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<!--End MMS-DM-CRF-0137-->\n\t\t<input type=\'hidden\' name=\'entry_type\' id=\'entry_type\' value=\"\"><!-- Added for MMS-DM-CRF-0157 -->\n\t\t<input type=\'hidden\' name=\'bar_code_scan_site_YN\' id=\'bar_code_scan_site_YN\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><!-- Added for MMS-DM-CRF-0157 -->\n\t\t<input type=\'hidden\' name=\'scan_count_required_yn\' id=\'scan_count_required_yn\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><!-- Added for MMS-DM-CRF-0170.2 -->\n\t\t<input type=\'hidden\' name=\'alert_required_yn\' id=\'alert_required_yn\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"><!-- Added for MMS-DM-CRF-0170.2 -->\n\t\t<input type=\'hidden\' name=\'remarks_required_yn\' id=\'remarks_required_yn\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"><!-- Added for MMS-DM-CRF-0170.2 -->\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"><!-- Added for MMS-DM-CRF-0170.2 -->\n\n\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"><!-- Added for MMS-DM-CRF-0170.2 -->\n\n\t\n\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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
request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
 String locale = ((String)session.getAttribute("LOCALE"));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
		Connection conn=null;
		PreparedStatement pstmt=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt1=null;//Added for MMS-DM-CRF-0170.2
		ResultSet rsSet=null;//ADded for MMS-DM-CRF-170.2
	    String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="",encounter_id="",patient_class="";//ADded for MMS-DM-CRF-170.2
		


		String strColorInd="";
		String strStageCode="";
		String strResultString="";
		
		//Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137
		String UnitNoFld = "";
		String ProductCodeFld = "";

		String strSpecimenNo="";

		String strColumnDelimiter = ",";
		String desc_data="";
		int max_records = 10;		
		
		StringTokenizer strToken=null;
		StringTokenizer strSubToken=null;

		int i = 0;

		ArrayList vectorColumnSizes = new ArrayList();
		ArrayList vectorColumnDescriptions = new ArrayList();
		ArrayList vectorHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		try
		{
		
			conn = ConnectionManager.getConnection(request);
		
			cstmt=conn.prepareCall("{ call BT_CONSUMBTION_COLOR(?,?,?,?,?,?,?,?)}");

			cstmt.setString(1,"0");
			cstmt.setString(2,"0");
			cstmt.setString(3,"0");
			cstmt.setString(4,"0");
			cstmt.setString(5,"2");
			cstmt.setString(6,"0");
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);		

			cstmt.execute();

			strResultString = cstmt.getString(7);
		

		
		strToken=new StringTokenizer(strResultString,"#");

		while(strToken.hasMoreElements())
			{			
			strSubToken=new StringTokenizer(strToken.nextToken(),"@");
			while(strSubToken.hasMoreElements())
			{		
			strColorInd=strSubToken.nextToken();
			strStageCode=strSubToken.nextToken();
			}		
			
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strStageCode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strColorInd));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
            _bw.write(_wl_block11Bytes, _wl_block11);

	Boolean isUnitNoProdCodeScanAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "BT","UNIT_NO_PRODUCT_CODE");
	//Adding start for MMS-DM-CRF-157
		Boolean bar_code_scan_site = eCommon.Common.CommonBean.isSiteSpecific(conn,"AM", "BARCODE_SCANNING_APPLICABLE");
		String bar_code_scan_site_YN = "";
		 encounter_id = request.getParameter("encounter_id");
		 patient_class = request.getParameter("patient_class");
				
				if(bar_code_scan_site)
				{
					bar_code_scan_site_YN = "Y";
				}
				else
				{
					bar_code_scan_site_YN = "N";
				}
        //Ading end for MMS-DM-CRF-157
		//Adding start for MMS-DM-CRF-0170.2
		try {
			if(bar_code_scan_site_YN.equals("Y")){
		
		ArrayList scanCountSetup    = new ArrayList();
		pstmt1 =conn.prepareStatement("SELECT SCAN_REQUIRED_YN,ALERT_REQUIRED_YN,REMARKS_REQUIRED_YN FROM PR_BARCODE_SCAN_SETUP WHERE FUNCTION_ID = ? AND PATIENT_CLASS =?");

		    pstmt1.setString(1, "BLOOD_CONSUMPTION");
			pstmt1.setString(2, patient_class.trim());
			rsSet = pstmt1.executeQuery() ;

			if(rsSet.next())
			{ 
				scan_count_required_yn= rsSet.getString("SCAN_REQUIRED_YN")==null?"N":rsSet.getString("SCAN_REQUIRED_YN");
				alert_required_yn =rsSet.getString("ALERT_REQUIRED_YN")==null?"N":rsSet.getString("ALERT_REQUIRED_YN");
				remarks_required_yn = rsSet.getString("REMARKS_REQUIRED_YN")==null?"N":rsSet.getString("REMARKS_REQUIRED_YN");
			 }
		}
		  }catch(Exception expSQL)
			{
					//eBT.LogFile.log("QADebugger","Exception "+expSQL,this);
                	expSQL.printStackTrace();			
			}
			finally
			{
				try
				{
					rsSet.close();
					pstmt1.close();
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			}

//Addign end for MMS-DM-CRF-0170.2


            _bw.write(_wl_block12Bytes, _wl_block12);
if(isUnitNoProdCodeScanAppl){
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(isUnitNoProdCodeScanAppl){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

			max_records = (request.getParameter("max_records")== null) ? 10:Integer.parseInt(request.getParameter("max_records"));
		

		   String strPatient_Id = request.getParameter("patient_id");

			strPatient_Id = (strPatient_Id == null) ? "":strPatient_Id;

			String strOrderFacilityId = request.getParameter("order_facility_id");

			strOrderFacilityId = (strOrderFacilityId == null) ? "":strOrderFacilityId;

			String sql = " SELECT 'DAT'||ROWNUM ROW_ID1,A.patient_id PATIENT_ID1, A.specimen_no SPECIMEN_NO1,F.short_Desc PRODUCT_DESC1,NVL(B.CURRENT_VOLUME,0) CURRENT_VOLUME1,NVL(B.VOLUME_UNITS,'') VOLUME_UNITS1,A.OPERATING_FACILITY_ID OPERATING_FACILITY_ID1, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') SYDATE1,to_char(A.reserved_date,'dd/mm/yyyy hh24:mi') RESERVED_DATE1,to_char(A.issued_date,'dd/mm/yyyy hh24:mi') ISSUED_DATE1,A.unit_no UNIT_NO1, A.product_code PRODUCT_CODE1,NVL(TO_CHAR(E.TRANSFUSE_EXPECT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') TRANS_EXP_DATE, B.blood_group BLOOD_GROUP1, B.rhesus_code RHESUS_CODE1,A.UNIT_STATUS UNIT_STATUS1, A.request_for_issue_by REQUEST_FOR_ISSUE_BY1,NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy hh24:mi'),'') EXPIRYDATE, A.STORAGE_LOC_CODE FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_OUTSTAND_SPECIMENS_VW C,BT_UOM_MAST_LANG_VW D,BT_UNIT_REQUEST_CATEGORY E,BT_PRODUCT_MAST_LANG_VW F WHERE  A.PATIENT_ID='"+strPatient_Id+"' and D.LANGUAGE_ID='"+locale+"' and C.ORDERED_FACILITY_ID='"+strOrderFacilityId+"' AND A.unit_no = B.unit_no and E.specimen_no= A.specimen_no and e.specimen_no = a.specimen_no and e.product_code =a.product_code and e.patient_id = a.patient_id and E.operating_Facility_id = C.operating_facility_id and A.product_code = B.product_code AND F.product_code = A.product_code and F.language_id =d.language_id and NVL(A.unit_status, 'UO') IN ('UI') AND A.operating_facility_id = C.operating_facility_id AND C.specimen_no = A.specimen_no AND B.operating_facility_id = C.operating_facility_id AND C.patient_id = A.patient_id AND NVL(B.VOLUME_UNITS,'X')= D.UOM_CODE(+) ORDER BY A.issued_date";

			//Above query modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589

//			String sql= request.getParameter("sql");
//			sql = (sql == null) ? "":sql;

			String from = request.getParameter( "from" ) ;

			String to = request.getParameter( "to" ) ;
	

			from = (from == null) ? "0":from;

			to = (to == null) ? max_records+"":to;

			String column_descriptions = request.getParameter("column_descriptions");

			column_descriptions = (column_descriptions == null) ? "":column_descriptions;

			//eBT.LogFile.log("QADebugger","Column Desc"+column_descriptions,this);

			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null) ? "":column_sizes;

			//eBT.LogFile.log("QADebugger","ColumnSize "+column_sizes,this);


			StringTokenizer strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;

			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnSizes.add(i, strTokenizer.nextToken());
				++i;
			}
			

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnDescriptions.add( i,strTokenizer.nextToken());
				++i;
			}



			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";




			try
			{

				String strPatientId = "";
				String strFacilityId ="";
				strSpecimenNo="";
				String strUnitNo="";
				String strProductDesc="";
				String strProductCode= "";
				String strBloodGroup="";
				String  strRhesusCode="";
				String strChk="";

				String tagHtml="";
				String rec_id;
				String strUnitStatus="";
				String strTransfusedVol="";
				String strTransfusedUnit="";
				String strRowId="";
				String strIssuedDate="";
				String strReservedDate="";	
				String strSysDate="";
				String strDonateType="";
				String strTransExpectDate="";
				String strEmergency=""; 
				
				//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
				String transOutClick = " onClick='transToExternal(this)';";
				String strLocationCode = "";

				String row = "<tr style='background-color:;'>";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strHtmlData = "";


			

			//Dhana


				String strClickEvent = " onClick='fun(this)';";


				int intTempStart = start;

				

				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				//eBT.LogFile.log("QADebugger","sqlValue"+sql,this);			
			
			vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");

			//eBT.LogFile.log("QADebugger","Finish 2",this);

			for(i=0;i<vectorColumnSizes.size();i++)
				{
				try
					{
				desc_data=""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+vectorColumnDescriptions.get(i),"bt_labels");
					}catch(Exception e1) 
						{
						desc_data ="";		
					  }
				vectorHtmlData.add("<td class='columnheader' width='"+vectorColumnSizes.get(i)+"%'>"+desc_data+"</td>");
				}

			
				
				while(rs.next())
				{
	

					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;

					vectorHtmlData.add(row);					


				 strPatientId = rs.getString("PATIENT_ID1");
				 strPatientId =strPatientId==null?"":strPatientId;

				 strFacilityId=rs.getString("OPERATING_FACILITY_ID1");
				strFacilityId=strFacilityId==null?"":strFacilityId;

				 strSpecimenNo=rs.getString("SPECIMEN_NO1"); 		
				 strSpecimenNo=strSpecimenNo==null?"":strSpecimenNo;


				strUnitNo = rs.getString("UNIT_NO1");
				strUnitNo =strUnitNo ==null?"":strUnitNo ;

				strProductCode =rs.getString("PRODUCT_CODE1");
				strProductCode =strProductCode ==null?"":strProductCode;	


				strProductDesc =rs.getString("PRODUCT_DESC1");
				strProductDesc =strProductDesc ==null?"":strProductDesc;	

				strBloodGroup=rs.getString("BLOOD_GROUP1");
				strBloodGroup=strBloodGroup==null?"":strBloodGroup;

				strRhesusCode=rs.getString("RHESUS_CODE1");      		
				strRhesusCode=strRhesusCode==null?"":strRhesusCode;

				strUnitStatus=rs.getString("UNIT_STATUS1");
				strUnitStatus=strUnitStatus==null?"":strUnitStatus;

			strTransfusedVol=rs.getString("CURRENT_VOLUME1");
			strTransfusedVol=strTransfusedVol==null?"":strTransfusedVol;

			strRowId=rs.getString("ROW_ID1");
			strRowId=strRowId==null?"":strRowId;
			
			strIssuedDate=rs.getString("ISSUED_DATE1");
			strIssuedDate=strIssuedDate==null?"":strIssuedDate;

			strTransfusedUnit=rs.getString("VOLUME_UNITS1");
			strTransfusedUnit=strTransfusedUnit==null?"":strTransfusedUnit;
			//System.out.println("EBT  value "+strTransfusedUnit);

		   // strTransExpectDate=rs.getString("TRANS_EXP_DATE");
		  //  strTransExpectDate=strTransExpectDate==null?"":strTransExpectDate;

			strTransExpectDate=com.ehis.util.DateUtils.convertDate(rs.getString("TRANS_EXP_DATE"),"DMYHMS","en",locale);


			strReservedDate=rs.getString("RESERVED_DATE1");
			strReservedDate=strReservedDate==null?"":strReservedDate;

			strSysDate=rs.getString("SYDATE1");
			strSysDate=strSysDate==null?"":strSysDate;

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			strLocationCode = rs.getString("STORAGE_LOC_CODE");
			strLocationCode = strLocationCode==null?"":strLocationCode;

			strIssuedDate=strIssuedDate==null?"":strIssuedDate;
	
			strReservedDate=strReservedDate==null?"":strReservedDate;

			rec_id="1";
			strChk="";
			cstmt.setString(1,strUnitNo);
			cstmt.setString(2,strSpecimenNo);
			cstmt.setString(3,strProductCode);
			cstmt.setString(4,strUnitStatus);
			cstmt.setString(5,"0");
			cstmt.setString(6,strFacilityId);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);

			/*System.out.println("EBT Unit No="+strUnitNo+" specimen No ="+strSpecimenNo+" product Code ="+strProductCode+" UnitStatus ="+strUnitStatus);
			*/
			cstmt.execute();
			strDonateType = cstmt.getString(7);
			strEmergency  = cstmt.getString(8);

		 // System.out.println("EBT === Donate Type "+strDonateType);

 		//  System.out.println("EBT === Emergency "+strEmergency);
	

				if (intFetchedRecords%2 == 0)
					{
						strHtmlData =  evn;
					}
					else
					{
						strHtmlData = odd;
					}

						tagHtml=strHtmlData+" align='left' >";


				  if(strDonateType.equals("0")==true)
					{
					tagHtml=tagHtml+"<b class='label'>&nbsp;"+strSpecimenNo+"</b></td>";							
					}
					else
					{
					tagHtml="<td class="+strDonateType+"><b class='WHITE'>"+strSpecimenNo+"&nbsp;</b></td>";	
					}


				  if(strEmergency.equals("N")==true)
					{
					tagHtml=tagHtml+strHtmlData+" align='left' ><b class='label'>"+strUnitNo+"&nbsp;</b><input type='hidden'name='UNIT_NO' value="+strUnitNo+"></td>";
					}
					else
					{
					tagHtml=tagHtml+"<td class="+strEmergency+" align='left' ><b class='label'>"+strUnitNo+"&nbsp;</b><input type='hidden'name='UNIT_NO' value="+strUnitNo+"></td>";
					}
						
						/*Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137*/
						if(isUnitNoProdCodeScanAppl){
							tagHtml=tagHtml+strHtmlData+" align='left' ><b class='label'>"+strProductCode+"/"+strProductDesc+"&nbsp;</b><input type='hidden'name='PRODUCT_CODE' value="+strProductCode+"></td>";
						}else
						{
							tagHtml=tagHtml+strHtmlData+" align='left' ><b class='label'>"+strProductDesc+"&nbsp;</b><input type='hidden'name='PRODUCT_CODE' value="+strProductCode+"></td>";
						}

						tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strBloodGroup+"&nbsp;</b></td>";
						tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strRhesusCode+"&nbsp;</b></td>";
						tagHtml=tagHtml+strHtmlData+"><select name='"+strRowId+"' id='"+strRowId+"' value='"+strUnitStatus+"' disabled> <option value='UI'>Issued  <option value='UT'>Transfused <option value='TF'>Transferred </select></td>";

						tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strTransExpectDate+"&nbsp;</b></td>";
					

						tagHtml=tagHtml+strHtmlData+"align='center'><input type='checkbox' name='"+strRowId+rec_id+"' id='"+strRowId+rec_id+"' PATIENT_ID='"+strPatientId+"'  OPERATING_FACILITY_ID='"+strFacilityId+"' SPECIMEN_NO='"+strSpecimenNo+"'				PRODUCT_CODE ='"+strProductCode+"' UNIT_NO='"+strUnitNo+"'	ROW_ID='"+strRowId+"'	VOLUME_UNITS='"+strTransfusedUnit+"' 		RHESUS_CODE='"+strRhesusCode+"' 	BLOOD_GROUP='"+strBloodGroup+"' 			ISSUED_DATE='"+strIssuedDate+"'				SYDATE='"+strSysDate+"'						RESERVED_DATE='"+strReservedDate+"'		CURRENT_VOLUME='"+strTransfusedVol+"' EXTERNAL_TRANSFER='' align='center' "+strClickEvent+"  "+strChk+" ></td>"; //Modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589

						/*Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589*/
						tagHtml=tagHtml+strHtmlData+"align='center'>&nbsp;<input type='image' src='../../eCommon/images/Transfer.PNG' style='width:21px;height:13px;' name='"+strRowId+rec_id+"' id='"+strRowId+rec_id+"' PATIENT_ID='"+strPatientId+"'  OPERATING_FACILITY_ID='"+strFacilityId+"' SPECIMEN_NO='"+strSpecimenNo+"' PRODUCT_CODE ='"+strProductCode+"' UNIT_NO='"+strUnitNo+"'	ROW_ID='"+strRowId+"' VOLUME_UNITS='"+strTransfusedUnit+"' ISSUED_DATE='"+strIssuedDate+"' SYDATE='"+strSysDate+"' RESERVED_DATE='"+strReservedDate+"' CURRENT_VOLUME='"+strTransfusedVol+"' STORAGE_LOC_CODE='"+strLocationCode+"' EXTERNAL_TRANSFER='ExternalTransfer' align='center' "+transOutClick+"></td>";
						/*End ML-MMOH-CRF-0589*/

					vectorHtmlData.add(tagHtml);
					vectorHtmlData.add("</tr>");

					/*Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137*/
					UnitNoFld = UnitNoFld+","+strUnitNo+"^"+strRowId+rec_id; 
					ProductCodeFld = ProductCodeFld+","+strProductCode+"^"+strRowId+rec_id+"^"+strUnitNo;
					/*End MMS-DM-CRF-0137*/

					if (intFetchedRecords >= max_records)
					{
						break;
					}
					
				}
				vectorHtmlData.add("</table>");
				//ConnectionManager.returnConnection(conn, request);
	
			}
			catch(Exception expSQL)
			{
					//eBT.LogFile.log("QADebugger","Exception "+expSQL,this);
					System.out.println("EBT exception 1"+expSQL);
				
			}
			finally
			{
				try
				{
					rs.close();
					pstmt.close();
					cstmt.close();
					ConnectionManager.returnConnection(conn, request);
				}
				catch(Exception ee)
				{
					System.out.println("EBT exception2 "+ee);
				}
			}


			//eBT.LogFile.log("QADebugger","size"+vectorHtmlData.size(),this);			

			//debug("Final sql  = "+sql);
		
            _bw.write(_wl_block20Bytes, _wl_block20);

		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}

		//debug("intFetchedRecords="+intFetchedRecords);
		//debug("max_records="+max_records);

		if (intFetchedRecords>=max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}


			//debug("vectorHtmlData.size()="+vectorHtmlData.size() );
			
		
            _bw.write(_wl_block21Bytes, _wl_block21);


			for (int l=0;l<vectorHtmlData.size();++l)
			{		
				out.println((String)vectorHtmlData.get(l));
			}

			if(vectorHtmlData.size()==10)
			{
			out.println("<script language='javascript'>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			}

		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(start));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(end));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(column_sizes));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(column_descriptions));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strSpecimenNo));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPatient_Id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strOrderFacilityId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(UnitNoFld));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ProductCodeFld));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(isUnitNoProdCodeScanAppl));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bar_code_scan_site_YN));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(scan_count_required_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alert_required_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(remarks_required_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block41Bytes, _wl_block41);

		}
		catch(Exception exp)
		{
			//System.out.println("EBT exception 3"+exp);
		}
            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.Product.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.Code.label", java.lang.String .class,"key"));
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
}
