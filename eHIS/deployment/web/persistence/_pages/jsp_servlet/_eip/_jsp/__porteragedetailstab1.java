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
import java.util.*;
import java.sql.*;
import java.text.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public final class __porteragedetailstab1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PorterageDetailsTab1.jsp", 1740121250270L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\"../js/TransferPatient.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\n<script>\n// By Annadurai 3/5/2004 starts.,\nfunction assignValue()\n{\n\tif (document.forms[1].port_received_yn.checked == true)\n\t{\n\t\tdocument.forms[1].port_received_yn.value\t= \"Y\";\n\t\tparent.frames[2].document.forms[1].received.disabled\t= false;\n\t\tparent.frames[2].document.forms[1].port_remarks.disabled\t= false;\n\t\tparent.frames[2].document.getElementById(\"received_img\").style.visibility\t\t\t= \'visible\';\n\t}\n\telse \n\t{\n\t\tdocument.forms[1].port_received_yn.value\t= \"N\";\n\t\tparent.frames[2].document.forms[1].received.value=\'\';\n\t\tparent.frames[2].document.forms[1].port_remarks.value=\'\';\n\t\tparent.frames[2].document.forms[1].received.disabled\t= true;\n\t\tparent.frames[2].document.forms[1].port_remarks.disabled\t= true;\n\t\tparent.frames[2].document.getElementById(\"received_img\").style.visibility\t\t\t= \'hidden\';\n\t}\n}\n// By Annadurai 3/5/2004 ends.,\nfunction selfClose()\n{\n\tself.close();\n\treturn 1;\n}\n/*function close_me()\n{\n\tvar port_vals = \"\";\n\tport_vals = \n\t\t\t\t\n\t(document.forms[1].Mode_of_Tran_desc.value.length == 0 ? \" \" : document.forms[1].Mode_of_Tran_desc.value) + \"^^\" + \n\t(document.forms[1].acc_per1_desc.value.length == 0? \" \" : document.forms[1].acc_per1_desc.value )+ \"^^\" +\n\t(document.forms[1].acc_per2_desc.value.length == 0? \" \" :\t\t\t\n\tdocument.forms[1].acc_per2_desc.value) + \"^^\" +\n\t(document.forms[1].acc_per3_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].acc_per3_desc.value) + \"^^\" +\n\t(document.forms[1].acc_per4_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].acc_per4_desc.value) + \"^^\" +\n\t(document.forms[1].acc_per5_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].acc_per5_desc.value) + \"^^\" +\n\t(document.forms[1].acc_per6_desc.value.length == 0 ? \" \" :\t\n\tdocument.forms[1].acc_per6_desc.value) + \"^^\" +\n\t(document.forms[1].acc_per7_desc.value.length == 0 ? \" \" :\t\t\t\n\tdocument.forms[1].acc_per7_desc.value) + \"^^\" +\n\n\t(document.forms[1].equip1_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].equip1_desc.value) + \"^^\" +\n\t(document.forms[1].equip2_desc.value.length == 0 ? \" \" :\t\t\t\n\tdocument.forms[1].equip2_desc.value) + \"^^\" +\n\t(document.forms[1].equip3_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].equip3_desc.value) + \"^^\" +\n\t(document.forms[1].equip4_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].equip4_desc.value) + \"^^\" +\n\t(document.forms[1].equip5_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].equip5_desc.value) + \"^^\" +\n\t(document.forms[1].equip6_desc.value.length == 0 ? \" \" :\t\t\t\n\tdocument.forms[1].equip6_desc.value) + \"^^\" +\n\t(document.forms[1].equip7_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].equip7_desc.value) + \"^^\" +\n\t\t\t\t\n\t(document.forms[1].bld_med1_desc.value.length == 0 ? \" \" : \n\tdocument.forms[1].bld_med1_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med2_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[1].bld_med2_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med3_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].bld_med3_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med4_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].bld_med4_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med5_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[1].bld_med5_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med6_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].bld_med6_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med7_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[1].bld_med7_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med8_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[1].bld_med8_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med9_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].bld_med9_desc.value) + \"^^\" +\n\t(document.forms[1].bld_med10_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[1].bld_med10_desc.value) + \"^^\" +\n\t\t\t\t\n\t(document.forms[1].rec_doc1_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].rec_doc1_desc.value) + \"^^\" +\n\t(document.forms[1].rec_doc2_desc.value.length == 0 ? \" \" : \n\tdocument.forms[1].rec_doc2_desc.value) + \"^^\" +\n\t(document.forms[1].rec_doc3_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].rec_doc3_desc.value) + \"^^\" +\n\t(document.forms[1].rec_doc4_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].rec_doc4_desc.value) + \"^^\" +\n\t(document.forms[1].rec_doc5_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].rec_doc5_desc.value) + \"^^\" +\n\t\t\t\t\n\t(document.forms[1].pat_bel1_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].pat_bel1_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel2_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].pat_bel2_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel3_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].pat_bel3_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel4_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].pat_bel4_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel5_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].pat_bel5_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel6_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].pat_bel6_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel7_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[1].pat_bel7_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel8_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].pat_bel8_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel9_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].pat_bel9_desc.value) + \"^^\" +\n\t(document.forms[1].pat_bel10_desc.value.length == 0 ? \" \" :\n\tdocument.forms[1].pat_bel10_desc.value)+ \"^^\" ;\n\t\t\t\t// By Annadurai 3/5/2004 starts.,\n\t\t\t\tif (document.forms[1].jsp_name_val.value == \"TransferPatientIn\")\n\t\t\t\t{\t\n\t\t\t\t\tport_vals = port_vals +\n\t\t\t\t\t(document.forms[1].port_received_yn.value.length == 0 ? \" \" :document.forms[1].port_received_yn.value)+ \"^^\" +\n\t\t\t\t\t(document.forms[1].received.value.length == 0 ? \" \" :\n\t\t\t\t\tdocument.forms[1].received.value)+ \"^^\" +\n\t\t\t\t\t(document.forms[1].port_remarks.value.length == 0 ? \" \" :\n\t\t\t\t\tdocument.forms[1].port_remarks.value);\n\t\t\t\t}\n\t\t\t\t// By Annadurai 3/5/2004 ends.,\n\t\tdocument.forms[0].porterage_hid.value=port_vals;\n}*/\nfunction populateDetails()\n{\n\tvar port_vals=document.forms[0].porterage_hid.value;\n\n\tif(port_vals == null || port_vals ==\'null\')\n\t{\n\t\tport_vals=\'\';\n\t}\n\n\tvar arr_port_vals=port_vals.split(\"^^\");\n\n\tif(arr_port_vals[0]){\n\t\tdocument.forms[1].Mode_of_Tran_desc.value\t\t= arr_port_vals[0];\n\t\t/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/\n\t\tif(document.forms[1].Mode_of_Tran_desc.value==\"\"){\n\t\t\tdocument.forms[1].Mode_of_Tran_desc.value\t= \"\";//To display \"select\" in the dropdown\n\t\t}/*End*/\n\t}\n\t\n\t/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/\n\tvar isCnrmReqPatOutChngAppl = document.forms[0].isCnrmReqPatOutChngAppl.value;\n\tvar accompPersonVal = document.forms[0].accomp_person.value;\n\n\tif(accompPersonVal == null || accompPersonVal ==\'null\')\n\t\taccompPersonVal = \'\';\n\n\tvar arr_accomp_persn = accompPersonVal.split(\"^^\");\n\n\tif(isCnrmReqPatOutChngAppl == \"true\")\n\t{\n\t\tif(arr_accomp_persn[0])\n\t\t\tdocument.forms[1].acc_per1_desc_disp.value\t\t= arr_accomp_persn[0];\n\t\tif(arr_accomp_persn[1])\n\t\t\tdocument.forms[1].acc_per2_desc_disp.value\t\t= arr_accomp_persn[1];\n\t\tif(arr_accomp_persn[2])\n\t\t\tdocument.forms[1].acc_per3_desc_disp.value\t\t= arr_accomp_persn[2];\n\t\tif(arr_accomp_persn[3])\n\t\t\tdocument.forms[1].acc_per4_desc_disp.value\t\t= arr_accomp_persn[3];\n\t\tif(arr_accomp_persn[4])\n\t\t\tdocument.forms[1].acc_per5_desc_disp.value\t\t= arr_accomp_persn[4];\n\t\tif(arr_accomp_persn[5])\n\t\t\tdocument.forms[1].acc_per6_desc_disp.value\t\t= arr_accomp_persn[5];\n\t}\n\telse\n\t{\n\t\tif(arr_port_vals[1])\n\t\t\tdocument.forms[1].acc_per1_desc.value\t\t= arr_port_vals[1];\n\t\tif(arr_port_vals[2])\n\t\t\tdocument.forms[1].acc_per2_desc.value\t\t= arr_port_vals[2];\n\t\tif(arr_port_vals[3])\n\t\t\tdocument.forms[1].acc_per3_desc.value\t\t= arr_port_vals[3];\n\t\tif(arr_port_vals[4])\n\t\t\tdocument.forms[1].acc_per4_desc.value\t\t= arr_port_vals[4];\n\t\tif(arr_port_vals[5])\n\t\t\tdocument.forms[1].acc_per5_desc.value\t\t= arr_port_vals[5];\n\t\tif(arr_port_vals[6])\n\t\t\tdocument.forms[1].acc_per6_desc.value\t\t= arr_port_vals[6];\n\t}/*End*/\n\t\n\tif(arr_port_vals[7])\n\t\tdocument.forms[1].acc_per7_desc.value\t\t= arr_port_vals[7];\n\t\n\tif(arr_port_vals[8])\n\t\tdocument.forms[1].equip1_desc.value\t\t= arr_port_vals[8];\n\tif(arr_port_vals[9])\n\t\tdocument.forms[1].equip2_desc.value\t\t= arr_port_vals[9];\n\tif(arr_port_vals[10])\n\t\tdocument.forms[1].equip3_desc.value\t\t= arr_port_vals[10];\n\tif(arr_port_vals[11])\n\t\tdocument.forms[1].equip4_desc.value\t\t= arr_port_vals[11];\n\tif(arr_port_vals[12])\n\t\tdocument.forms[1].equip5_desc.value\t\t= arr_port_vals[12];\n\tif(arr_port_vals[13])\n\t\tdocument.forms[1].equip6_desc.value\t\t= arr_port_vals[13];\n\tif(arr_port_vals[14])\n\t\tdocument.forms[1].equip7_desc.value\t\t= arr_port_vals[14];\n\n\tif(arr_port_vals[15])\n\t\tdocument.forms[1].bld_med1_desc.value\t\t= arr_port_vals[15];\n\tif(arr_port_vals[16])\n\t\tdocument.forms[1].bld_med2_desc.value\t\t= arr_port_vals[16];\n\tif(arr_port_vals[17])\n\t\tdocument.forms[1].bld_med3_desc.value\t\t= arr_port_vals[17];\n\tif(arr_port_vals[18])\n\t\tdocument.forms[1].bld_med4_desc.value\t\t= arr_port_vals[18];\n\tif(arr_port_vals[19])\n\t\tdocument.forms[1].bld_med5_desc.value\t\t= arr_port_vals[19];\n\tif(arr_port_vals[20])\n\t\tdocument.forms[1].bld_med6_desc.value\t\t= arr_port_vals[20];\n\tif(arr_port_vals[21])\n\t\tdocument.forms[1].bld_med7_desc.value\t\t= arr_port_vals[21];\n\tif(arr_port_vals[22])\n\t\tdocument.forms[1].bld_med8_desc.value\t\t= arr_port_vals[22];\n\tif(arr_port_vals[23])\n\t\tdocument.forms[1].bld_med9_desc.value\t\t= arr_port_vals[23];\n\tif(arr_port_vals[24])\n\t\tdocument.forms[1].bld_med10_desc.value\t\t= arr_port_vals[24];\n\n\n\tif(arr_port_vals[25])\n\t\tdocument.forms[1].rec_doc1_desc.value\t\t= arr_port_vals[25];\n\tif(arr_port_vals[26])\n\t\tdocument.forms[1].rec_doc2_desc.value\t\t= arr_port_vals[26];\n\tif(arr_port_vals[27])\n\t\tdocument.forms[1].rec_doc3_desc.value\t\t= arr_port_vals[27];\n\tif(arr_port_vals[28])\n\t\tdocument.forms[1].rec_doc4_desc.value\t\t= arr_port_vals[28];\n\tif(arr_port_vals[29])\n\t\tdocument.forms[1].rec_doc5_desc.value\t\t= arr_port_vals[29];\n\n\tif(arr_port_vals[30])\n\t\tdocument.forms[1].pat_bel1_desc.value\t\t= arr_port_vals[30];\n\tif(arr_port_vals[31])\n\t\tdocument.forms[1].pat_bel2_desc.value\t\t= arr_port_vals[31];\n\tif(arr_port_vals[32])\n\t\tdocument.forms[1].pat_bel3_desc.value\t\t= arr_port_vals[32];\n\tif(arr_port_vals[33])\n\t\tdocument.forms[1].pat_bel4_desc.value\t\t= arr_port_vals[33];\n\tif(arr_port_vals[34])\n\t\tdocument.forms[1].pat_bel5_desc.value\t\t= arr_port_vals[34];\n\tif(arr_port_vals[35])\n\t\tdocument.forms[1].pat_bel6_desc.value\t\t= arr_port_vals[35];\n\tif(arr_port_vals[36])\n\t\tdocument.forms[1].pat_bel7_desc.value\t\t= arr_port_vals[36];\n\tif(arr_port_vals[37])\n\t\tdocument.forms[1].pat_bel8_desc.value\t\t= arr_port_vals[37];\n\tif(arr_port_vals[38])\n\t\tdocument.forms[1].pat_bel9_desc.value\t\t= arr_port_vals[38];\n\tif(arr_port_vals[39])\n\t\tdocument.forms[1].pat_bel10_de";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="sc.value\t\t= arr_port_vals[39];\n\t// By Annadurai 3/5/2004 start.,\n\n\tif (document.forms[1].jsp_name_val.value == \"TransferPatientIn\")\n\t{\n\t\tif(arr_port_vals[40]) \n\t\t{\n\t\t\tdocument.forms[1].port_received_yn.value\t= arr_port_vals[40];\n\t\t\tif (arr_port_vals[40] == \"Y\")\n\t\t\t\tdocument.forms[1].port_received_yn.checked = true;\n\t\t\telse\n\t\t\t\tdocument.forms[1].port_received_yn.checked = false;\n\t\t}\n\t\tif(arr_port_vals[41]) \n\t\t\tdocument.forms[1].received.value\t\t\t= arr_port_vals[41];\n\t\tif(arr_port_vals[42]) \n\t\t\tdocument.forms[1].port_remarks.value\t\t= arr_port_vals[42];\n\t\t}\n\t// By Annadurai 3/5/2004 end.,\n}\n// By Vinay 6/29/2004\n/*\nfunction tab_clic(objName)\n{\n\tif (objName == \'Patient_Details\' || objName == \'Patient_Details1\')\n    {\n\t\tdocument.getElementById(\"patientdetailtab\").scrollIntoView();\n\t\tdocument.forms[1].Mode_of_Tran_desc.focus();\n\n    }\n\telse if (objName == \'Medical_details\' || objName == \'Medical_details1\')\n    {\n\t\tdocument.getElementById(\"medicaldetailtab\").scrollIntoView();\n\t\tdocument.forms[1].equip1_desc.focus();\n    }\n}\nvar isShift = false;\nfunction setShift(){\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 16) isShift=true;\n\t\t\n\t}\n*/\n\n\n</script>\n\n<body onLoad=\"populateDetails();\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey();\'>\n<form name=\"Porteragedetailstab1\" id=\"Porteragedetailstab1\" method=\"post\"action=\'\' target=\'messageFrame\'> \n\n<!--  By Vinay patientdetail tab event 6/29/2004 -->\n\t<!-- <a name=\"patientdetailtab\" tabindex=\'0\'></a>  -->\n\t<div id =\"Patient\" style = \'display:none\'>\n\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\' >\n\t<tr>\n\t<td width=\'100%\' class=\'BODYCOLORFILLED\'>\n\t\t<!-- <a align =\'left\' href=\"javascript:tab_click(\'Occupancy_Details\')\" ><img  src=\"../../eIP/images/Occupancy Details_click.gif\" border=0></a>\n\t\t<a align=\'left\' href=\"javascript:tab_click(\'other_details\')\" tabindex=\'-1\'><img  src=\"../../eIP/images/Other Details_click.gif\" border=0></a>\n\t\t<a align=\'left\' href=\"javascript:tab_click(\'porterage_details\')\" tabindex=\'-1\'><img  src=\"../../eIP/images/Porterage Details.gif\" border=0></a> -->\n\n\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t<li class=\"tablistitem\" title=\"Occupancy Details\">\n\t\t\t\t<a onclick=\"expandCollapse(\'Occupancy_Details\')\"  class=\"tabA\" id=\"Occupancy_Details\" ><span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t\t\t<a onclick=\"expandCollapse(\'other_details\')\" class=\"tabA\" id=\"other_details\" ><span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Porterage Details\">\n\t\t\t\t<a onclick=\"expandCollapse(\'porterage_details\')\" class=\" tabClicked\" id=\"porterage_details\" ><span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t</ul>\n\t</td>\n\t<td width=\'20%\' class=\'BODYCOLORFILLED\'></td></tr></table> \n\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\' >\n\t<tr>\n\t<td width=\'100%\' class=\'BODYCOLORFILLED\'>\n\t\n\t<!-- <a align =\'left\' href=\"javascript:tab_clic(\'Patient_Details\')\" ><img  src=\"../../eIP/images/Patient Details.gif\" border=0></a>\n\t<a align=\'left\' href=\"javascript:tab_clic(\'Medical_details\')\" tabindex=\'-1\'><img  src=\"../../eIP/images/Medical Details_click.gif\" border=0></a> -->\n\t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Patient Details\">\n\t\t\t<a onclick=\"expandCollapse(\'Patient_Details\')\"  class=\"tabClicked \" id=\"\" ><span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Medical details\">\n\t\t\t<a onclick=\"expandCollapse(\'Medical_details\')\" class=\"tabA\" id=\"\" ><span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\t\n\t</td><td width=\'20%\' class=\'BODYCOLORFILLED\'></td></tr></table> \n<!--  End of patientdetail tab event 6/29/2004 -->\n\t<table border=0 width=\"100%\" cellpadding=\'2\' cellspacing=0>\n\t<tr><td colspan=6 class=\'columnheader\' width=\"100%\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td></tr>\n\t\n\t<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<tr>\n\t\t\t<td colspan=3 class=\'fields\'>\n\t\t\t\t<select name=\'Mode_of_Tran_desc\' id=\'Mode_of_Tran_desc\'  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="disabled ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t\t\t<option value=\'\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td></td>\n\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<tr>\n\t\t\t<td colspan=3 class=\'fields\'>\n\t\t\t<input type=\'text\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="readOnly ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" name=\'Mode_of_Tran_desc\'  maxlength=40 size=25   ></td>\n\t\t\t<td></td>\n\t\t</tr>\t\t\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <!--End-->\n\t\n\t<tr>\n\t\t<td colspan=6 width=\"100%\" class=\'columnheader\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t</tr>\n\t\t<tr ><td colspan=\"4\" class=\"label\" ></td></tr>\n\t\n\t<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr>\t\t\t\n\t\t\t<td colspan=6 class=\'fields\'>\n\t\t\t\t<input type=\'hidden\' name=\'acc_per1_desc\' id=\'acc_per1_desc\' value=\"\">\n\t\t\t\t<input type=text name=\'acc_per1_desc_disp\' id=\'acc_per1_desc_disp\'  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onblur=\'GetLookupBlur(acc_per1_desc_disp,acc_per1_desc)\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" maxlength=60 size=25 width=\"15\" value=\"\">\n\t\t\t\t<input type=\'button\' class=\'button\' name=\'user_lookup\' id=\'user_lookup\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" value=\'?\' onClick=\'GetLookup(acc_per1_desc_disp,acc_per1_desc)\'>\n\n\t\t\t\t<input type=\'hidden\' name=\'acc_per2_desc\' id=\'acc_per2_desc\' value=\"\">\n\t\t\t\t<input type=text name=\'acc_per2_desc_disp\' id=\'acc_per2_desc_disp\'  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onblur=\'GetLookupBlur(acc_per2_desc_disp,acc_per2_desc)\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" maxlength=60 size=25 width=\"15\" value=\"\" >  \n\t\t\t\t<input type=\'button\' class=\'button\' name=\'user_lookup\' id=\'user_lookup\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" value=\'?\' onClick=\'GetLookup(acc_per2_desc_disp,acc_per2_desc)\'> \n\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'acc_per3_desc\' id=\'acc_per3_desc\' value=\"\">\n\t\t\t\t<input type=text name=\'acc_per3_desc_disp\' id=\'acc_per3_desc_disp\'  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onblur=\'GetLookupBlur(acc_per3_desc_disp,acc_per3_desc)\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" value=\'?\' onClick=\'GetLookup(acc_per3_desc_disp,acc_per3_desc)\'> \n\t\t\t</td>\n\t\t\t<td></td>\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td colspan=6 class=\'fields\'>\n\t\t\t\t<input type=\'hidden\' name=\'acc_per4_desc\' id=\'acc_per4_desc\' value=\"\">\n\t\t\t\t<input type=text name=\'acc_per4_desc_disp\' id=\'acc_per4_desc_disp\'  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" onblur=\'GetLookupBlur(acc_per4_desc_disp,acc_per4_desc)\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" value=\'?\' onClick=\'GetLookup(acc_per4_desc_disp,acc_per4_desc)\'>\n\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'acc_per5_desc\' id=\'acc_per5_desc\' value=\"\">\n\t\t\t\t<input type=text name=\'acc_per5_desc_disp\' id=\'acc_per5_desc_disp\'  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" onblur=\'GetLookupBlur(acc_per5_desc_disp,acc_per5_desc)\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" value=\'?\' onClick=\'GetLookup(acc_per5_desc_disp,acc_per5_desc)\'> \n\n\t\t\t\t<input type=\'hidden\' name=\'acc_per6_desc\' id=\'acc_per6_desc\' value=\"\">\n\t\t\t\t<input type=text name=\'acc_per6_desc_disp\' id=\'acc_per6_desc_disp\'  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" onblur=\'GetLookupBlur(acc_per6_desc_disp,acc_per6_desc)\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" value=\'?\' onClick=\'GetLookup(acc_per6_desc_disp,acc_per6_desc)\'> \n\t\t\t</td>\n\t\t\t<td></td>\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td colspan=3 class=\'fields\'><input type=text name=\'acc_per7_desc\' id=\'acc_per7_desc\'  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" maxlength=60 size=25 width=\"15\" value=\"\"></td>\n\t\t\t<td></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<tr>\t\t\t\n\t\t<td colspan=3 class=\'fields\'>\n\t\t\t<input type=text name=\'acc_per1_desc\' id=\'acc_per1_desc\'  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp; <input type=text name=\'acc_per2_desc\' id=\'acc_per2_desc\'  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" maxlength=40 size=25 width=\"15\" value=\"\" >&nbsp; <input type=text name=\'acc_per3_desc\' id=\'acc_per3_desc\'  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" maxlength=40 size=25 width=\"15\" value=\"\">\n\t\t</td>\n\t\t<td></td>\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td colspan=3 class=\'fields\'>\n\t\t\t\t<input type=text name=\'acc_per4_desc\' id=\'acc_per4_desc\'  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp; <input type=text name=\'acc_per5_desc\' id=\'acc_per5_desc\'  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp; <input type=text name=\'acc_per6_desc\' id=\'acc_per6_desc\'  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" maxlength=40 size=25 width=\"15\" value=\"\">\n\t\t\t</td>\n\t\t\t<td></td>\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td colspan=3 class=\'fields\'><input type=text name=\'acc_per7_desc\' id=\'acc_per7_desc\'  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" maxlength=40 size=25 width=\"15\" value=\"\"></td>\n\t\t\t<td></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<!--End-->\n\t\n\t<tr>\n\t\t<td colspan=6 class=\'columnheader\' width=\"100%\" >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=3 class=\'fields\'><input type=text name=\'pat_bel1_desc\' id=\'pat_bel1_desc\'  ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" maxlength=40 size=25 width=\"15\" value=\"\" >&nbsp;<input type=text name=\'pat_bel2_desc\' id=\'pat_bel2_desc\'  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel3_desc\' id=\'pat_bel3_desc\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="  maxlength=40 size=25 width=\"15\" value=\"\"></td>\n\t\t\t<td></td>\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td colspan=3 class=\'fields\'><input type=text name=\'pat_bel4_desc\' id=\'pat_bel4_desc\'  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel5_desc\' id=\'pat_bel5_desc\' ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel6_desc\' id=\'pat_bel6_desc\'  ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" maxlength=40 size=25 width=\"15\" value=\"\"></td>\t<td></td>\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t<td colspan=3 class=\'fields\'><input type=text name=\'pat_bel7_desc\' id=\'pat_bel7_desc\'  ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel8_desc\' id=\'pat_bel8_desc\'  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" maxlength=40 size=25 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel9_desc\' id=\'pat_bel9_desc\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="  maxlength=40 size=25 width=\"15\" value=\"\"></td>\t<td></td>\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td colspan=3 class=\'fields\'><input type=text name=\'pat_bel10_desc\' id=\'pat_bel10_desc\'  ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" maxlength=40 size=25 width=\"15\" value=\"\" ></td>\t\n\t\t\t<td></td>\n\t\t</tr>\n\t\t<tr ><td colspan=\"4\" class=\"label\" ></td></tr>\n\t<!--<tr>\n\t\n\t<td colspan=3></td>\t\n\t<td align=\'right\'><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"  onclick=\"submit_Form();\"><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" \n\tonclick=\"cancel();\" onblur=\"tab_click(\'porterage_details\')\"></td>\n\t</tr> -->\n    </table>\n\t</div>\n\t\n\t<!--  By Vinay medicaldetail tab event 6/29/2004 -->\n\t<!-- <a name=\"medicaldetailtab\" tabindex=\'0\'></a>  -->\n\t<div id =\"Medical\" style = \'display:none\'>\n\t\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\' width=\'100%\'>\n\t<tr>\n\t<td width=\'100%\' class=\'BODYCOLORFILLED\' >\n    <!-- \t\n\t<a align =\'left\' href=\"javascript:tab_click(\'Occupancy_Details\')\"><img  src=\"../../eIP/images/Occupancy Details_click.gif\" border=0></a>\n\t<a align=\'left\' href=\"javascript:tab_click(\'other_details\')\" tabindex=\'-1\'><img  src=\"../../eIP/images/Other Details_click.gif\" border=0></a>\n\t<a align=\'left\' href=\"javascript:tab_click(\'porterage_details\')\" tabindex=\'-1\'><img  src=\"../../eIP/images/Porterage Details.gif\" border=0></a> -->\n\t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Occupancy Details\">\n\t\t\t<a onclick=\"expandCollapse(\'Occupancy_Details\')\"  class=\"tabA\" id=\"Occupancy_Details\" ><span class=\"tabAspan\" id=\"Occu_tabspan\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t\t<a onclick=\"expandCollapse(\'other_details\')\" class=\"tabA\" id=\"other_details\" ><span class=\"tabAspan\" id=\"othe_tabspan\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Porterage Details\">\n\t\t\t<a onclick=\"expandCollapse(\'porterage_details\')\" class=\"tabClicked\" id=\"porterage_details\" ><span class=\"tabSpanclicked\" id=\"port_tabspan\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\n\t</td><td width=\'20%\' class=\'BODYCOLORFILLED\' ></td></tr></table> \n\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\' width=\'100%\'>\n\t<tr>\n\t<td width=\'100%\' class=\'BODYCOLORFILLED\'>\n\t\n<!-- \t<a align =\'left\' href=\"javascript:tab_clic(\'Patient_Details\')\"><img  src=\"../../eIP/images/Patient Details_click.gif\" border=0></a>\n\t<a align=\'left\' href=\"javascript:tab_clic(\'Medical_details\')\" tabindex=\'-1\'><img  src=\"../../eIP/images/Medical Details.gif\" border=0></a> -->\n\t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Patient Details\">\n\t\t\t<a onclick=\"expandCollapse(\'Patient_Details\')\"  class=\"tabA\" id=\"Patient_Details1\" ><span class=\"tabAspan\" id=\"Pat_tabspan\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Medical details\">\n\t\t\t<a onclick=\"expandCollapse(\'Medical_details\')\" class=\"tabClicked\" id=\"Medical_details1\" ><span class=\"tabSpanclicked\" id=\"Med_tabspan\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\t\n\t\n\t</td><td width=\'20%\' class=\'BODYCOLORFILLED\' ></td></tr></table>\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\n<!--  End of medicaldetail event 6/29/2004 -->\n<input type=\"hidden\" name=\"jsp_name_val\" id=\"jsp_name_val\" value =\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"isCnrmReqPatOutChngAppl\" id=\"isCnrmReqPatOutChngAppl\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"><!--Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617-->\n\n</div>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
	Connection con = null;
	try
	{
		con		=	ConnectionManager.getConnection(request);
		boolean isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");

		JSONArray transportModeJsonArr	= new JSONArray();

		transportModeJsonArr = eIP.IPCommonBean.getTransportMode(con);
	/*End*/


   //   By Annadurai 3/5/2004 starts
   String jsp_name =  request.getParameter("function_name");
   jsp_name = (jsp_name==null) ? "" : jsp_name;
  
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 if(isCnrmReqPatOutChngAppl){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

						for(int i = 0; i < transportModeJsonArr.size(); i++)
						{
							JSONObject json = (JSONObject)transportModeJsonArr.get(i);
							String transportMode	= (String) json.get("transportMode");
							String transportDesc	= (String) json.get("transportDesc");
							
							out.println("<option value='"+transportMode+"'>"+transportDesc+"</option>");
						}
						
					
            _bw.write(_wl_block20Bytes, _wl_block20);
 }else{ 
            _bw.write(_wl_block21Bytes, _wl_block21);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(isCnrmReqPatOutChngAppl){ 
            _bw.write(_wl_block26Bytes, _wl_block26);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
 }else{ 
            _bw.write(_wl_block42Bytes, _wl_block42);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
if(jsp_name.equals("TransferPatientIn")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
 } 
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
if(jsp_name.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            {java.lang.String __page ="PorterageDetailsTab2.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_name"), weblogic.utils.StringUtils.valueOf(jsp_name
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(isCnrmReqPatOutChngAppl));
            _bw.write(_wl_block72Bytes, _wl_block72);

}catch(Exception e)
{
	e.printStackTrace();
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.OccupancyDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalDetails.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeOfTransport.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AccompanyingPersons.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PatientBelongings.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.OccupancyDetails.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageDetails.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalDetails.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
