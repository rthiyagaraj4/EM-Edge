package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.io.*;
import ecis.utils.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;

public final class __report_buttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/report_buttons.jsp", 1742809917444L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/ecommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script language=\"JavaScript\">\nfunction onClose() { \n\n    let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue = null;\n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\"); \n    parent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length-1].close();\t   \n    // dialog.close();\n}\nfunction onSubmit() { \n\t\tvar errmessage = report_server_form.message.value ;\n\t\tvar languageID = report_server_form.languageID.value ;\n\t\tvar rep_server_key= report_server_form.rep_server_key.value ; //PMG2012-CRF-0027 IN:037658\n\t\tvar params\t\t= report_server_form.params.value;\n\t\tvar dest_locn_type= report_server_form.dest_locn_type.value;\n\t\t\n\t\tvar arg_params=params; \t\t \n\t\t/*Below line modified for this CRF PER-RH-0206*/\n\t\t//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349\n\t\tif((report_server_form.p_report_id.value==\"MRIPCSMB\" || report_server_form.p_report_id.value==\"MROPCSMB\" || \treport_server_form.p_report_id.value==\"MROPCSMS\") && report_server_form.self_submit.value!=\"\"){\t\t\t\n\t\t\tdocument.report_server_form.action=\"../../eMR/jsp/ValidateReports.jsp?\"+arg_params;\n\t\t\tdocument.report_server_form.submit();\n\t\t}\n\t\telse if(report_server_form.p_report_id.value==\"MRDCCSMB\" && report_server_form.self_submit.value!=\"\"){ \t\t\t\n\t\t\tdocument.report_server_form.action=\"../../eMR/jsp/RhValidateReports.jsp?\"+arg_params;\n\t\t\tdocument.report_server_form.submit();\n\t\t}\n\t\t/*Added By Dharma for Export Excel Start*/\n\t\telse if(report_server_form.isExportExlConfigAvialYN.value ==\"Y\" && parent.report_options.report_options_form.file_format.value ==\'spreadsheet\' ){\t\t\t\n\t\t\t\tvar isLangYN = (arg_params.search(\"p_language_id\") );\n\t\t\t\tif(isLangYN==-1){\n\t\t\t\t\targ_params\t= arg_params+\"&p_language_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\t\t\t\t\t\n\t\t\t\t}\n\t\t\t//Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START\n\t\t\t//MRNIAREPY Added By Dharma on 29th Jan 2021 against ML-MMOH-CRF-1593\n\t\t\tif( report_server_form.p_report_id.value==\"MRNIAREP\" || report_server_form.p_report_id.value==\"MRNIAREPY\" || report_server_form.p_report_id.value==\'AETOTVSR\' || report_server_form.p_report_id.value==\"STBRTVS1\" || report_server_form.p_report_id.value==\"STBRTVS2\" \n\t\t\t|| report_server_form.p_report_id.value==\"IPBMIPCH\" || report_server_form.p_report_id.value==\"IPBYIPCH\" || report_server_form.p_report_id.value==\"IPBMIPCS_HSA\" || report_server_form.p_report_id.value==\"IPBYIPCS\" || report_server_form.p_report_id.value==\"IPBMIPCN\"\n\t\t\t|| report_server_form.p_report_id.value==\"IPBYIPCN\")\n\t\t\t\t{\t\t\n\t\t\t\tdocument.report_server_form.action=\"../../eMR/jsp/ValidateReports.jsp?\"+arg_params+\"&closeWindow=true\";\n\t\t\t\tdocument.report_server_form.submit();\n\t\t\t\t}\n\t\t\t//Start. ML-MMOH-CRF-1342.1 added By Twinkle \n\t\t\telse if(report_server_form.p_report_id.value==\"MRDRBHTRW\")\n\t\t\t\t{\n\t\t\t\tdocument.report_server_form.action=\"../../servlet/eSM.ExportExcelServletByWard?\"+arg_params;\n\t\t\t\tdocument.report_server_form.submit();\n\t\t        setTimeout(\'window.close();\',3000);\t\n\t\t\t\t}\n\t\t\telse if(report_server_form.p_report_id.value==\"MRDRBHTRS\")\n\t\t\t{\n\t\t\tdocument.report_server_form.action=\"../../servlet/eSM.ExportExcelServletBySpeciality?\"+arg_params;\n\t\t\tdocument.report_server_form.submit();\n\t        setTimeout(\'window.close();\',3000);\t\n\t\t\t}\n\t\t\telse if(report_server_form.p_report_id.value==\"MRDRBHTRH\")\n\t\t\t{\n\t\t\tdocument.report_server_form.action=\"../../servlet/eSM.ExportExcelServletByHospital?\"+arg_params;\n\t\t\tdocument.report_server_form.submit();\n\t        setTimeout(\'window.close();\',3000);\t\n\t\t\t}\n\t\t\t//end. ML-MMOH-CRF-1342.1 added By Twinkle \n\t\t\t//Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END\n\t\t\telse{\t\t\t\t\n\t\t\t\tdocument.report_server_form.action=\"../../servlet/eSM.exportExcelServlet?\"+arg_params;\n\t\t\t\tdocument.report_server_form.submit();\n\t\t        setTimeout(\'window.close();\',3000);\t\n\n\t\t\t\t}\n\t\t} \n\t\t/*Added By Dharma for Export Excel End*/\t\t\n\t\telse {\t\t\t\n\t\tif (errmessage==\'\')\n\t\t{ \n\t\t\tvar self_submit \t= report_server_form.self_submit.value ;\n\t\t\tvar report_option\t= parent.report_options.report_options_form.destype.value ;\n\t\t\t//var params\t\t= report_server_form.params.value.toUpperCase() ;\n\n\t\t\tvar url \t\t= \"\" ;\n\t\t\tvar locale=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\";\n\t\t\tif(languageID!=\"\"){\n\t\t\t\tlocale=languageID;\n\t\t\t}\n\t\t\tif ( self_submit == \"\" ) {\n\t\t\t\tdocument.location.href\t=\t\"report_buttons.jsp?\" +\n\t\t\t\t\t\t\t\t\t\"self_submit=yes\" +\n\t\t\t\t\t\t\t\t\t\"&report_option=\" + report_option +\n\t\t\t\t\t\t\t\t\t\"&\" + params ;\n\t\t\t\treturn true ;\n\t\t\t}\n\n\t\t\tvar regExp = /&/g ;\n\t\t\tvar currenttime=report_server_form.currentDateTime.value;\n\t\t\tparams = params.replace( regExp, \"+\" ) ;\n\t\t\tif ( report_option  == \"V\" ) {\n\t\t\t\t//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022\n\t\t\t\tif(report_server_form.reportServerEnableFlag.value==\'Y\')\n\t\t\t\t\t{\n\t\t\t\t\tvar desformat = parent.report_options.report_options_form.file_format.value ;\n\t\t\t\t\tvar folder_dir=parent.report_options.report_options_form.report_dir_path.value ;\n\t\t\t\t\tvar extension = \"\" ;\n\t\t\t\t\tif ( desformat == \"pdf\" )\textension = \".pdf\" ;\n\t\t\t\t\tif ( desformat == \"htmlcss\" ) extension = \".html\" ;\n\t\t\t\t\tif ( desformat == \"rtf\" )\textension = \".rtf\" ;\n\t\t\t\t\tif ( desformat == \"xml\" )\textension = \".xml\" ;\n\t\t\t\t\tif ( desformat == \"spreadsheet\" )\textension = \".xls\" ;\n\t\t\t\t\treport_server_form.destype.value\t= \"file\" ;\n\t\t\t\t\treport_server_form.desformat.value\t= parent.report_options.report_options_form.file_format.value ;\t\n\t\t\t\t\t//\treport_server_form.desname.value\t= \tparent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;\t\t\t\t\t\n\t\t\t\t\tparams=params.toUpperCase();\n\t\t\t\t\tparams=params+\"+P_LANGUAGE_ID=\"+locale;\n\t\t\t\t\tvar file_name_dir=report_server_form.report.value+\'_\'+currenttime+extension ;\n\t\t\t\t\t\treport_server_form.desname.value=parent.report_options.report_options_form.report_dir.value+file_name_dir;\n\t\t\t\n\t\t\t\t\t\t//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Starts\n\t\t\t\t\tif (report_server_form.desformat.value==\"spreadsheet\" && (report_server_form.report.value == \"BLRRESFP\" || report_server_form.report.value == \"BLRRVAT\" )) {\n\t\t\t\t\t\turl = report_server_form.reportserver.value+\n\t\t\t\t\t\t\"?server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\t\"+report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\t\"+desformat=\"\t+ \"enhancedspreadsheet\"\t+\n\t\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\t\n\t\t\t\t\t\t\"+desname=\"\t\t+ report_server_form.desname.value\t\t+\t\n\t\t\t\t\t\t\"+filename=\"\t\t+ file_name_dir+\t\t\t\t\t\t\t\n\t\t\t\t\t//\t\"+desname=\"\t\t+ folder_dir+\'/\'+file_name_dir+\t\t\t\t\t\t//File Path has been mapped to save the file in directoy for MOHE-SCF-0147\t\t\t\t\t\t\n\t\t\t\t\t\t\"+recursive_load=no\";\n\t\t\t\t\t}else {\t\t\t\t\t\t\t\n\t\t\t\t\t\turl = report_server_form.reportserver.value+\n\t\t\t\t\t\t\"?server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\t\"+report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\t\"+desformat=\"\t+ report_server_form.desformat.value\t+\n\t\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\t\n\t\t\t\t\t\t\"+desname=\"\t\t+ report_server_form.desname.value\t\t+\t\n\t\t\t\t\t\t\"+filename=\"\t+ file_name_dir+\t\t\t\t\t\t\t\n\t\t\t\t\t//\t\"+desname=\"\t\t+ folder_dir+\'/\'+file_name_dir+\t\t\t\t\t\t//File Path has been mapped to save the file in directoy for MOHE-SCF-0147\t\t\t\t\t\t\n\t\t\t\t\t\t\"+recursive_load=no\";\n\t\t\t\t\t}\n\t\t\t\t\t//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Ends\n\t\t\t\t\tif(rep_server_key==\'\'){ //PMG2012-CRF-0027 IN:037658\n\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ report_server_form.userid.value\t\t+\"+\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t}\t\n\t\t\t\t\turl=url+params;\n\t\t\t\t\t//+\"&P_LANGUAGE_ID=\"+locale ;\n\t\t\t\t\t/*\n\t\t\t\t\turl = report_server_form.reportserver.value+\n\t\t\t\t\t\"?server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\"+report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\"+desformat=\"\t+ report_server_form.desformat.value\t+\n\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\t\t\n\t\t\t\t\t\"+desname=\"\t\t+ folder_dir+\'/\'+file_name_dir+\t\t\t\t\t\t//File Path has been mapped to save the file in directoy for MOHE-SCF-0147\n\t\t\t\t\t\"+recursive_load=no\";\n\t\t\t\t\tif(rep_server_key==\'\'){ //PMG2012-CRF-0027 IN:037658\n\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ report_server_form.userid.value\t\t+\"+\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t}\t\n\t\t\t\turl=url+params;\n\t\t\t\t//\turl=url+params+\"&p_file_format=\"+file_format+\"&p_file_type=\"+file_type;\n\t\t\t\t//\talert(\"url : \"+url);\n\t\t\t\t\t\t//+\"&P_LANGUAGE_ID=\"+locale ;\t\t\t\n*/\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\treport_server_form.destype.value\t= \"cache\" ;\n\t\t\t\t\treport_server_form.desformat.value\t= parent.report_options.report_options_form.file_format.value ;\n\t\t\t\t\tparams=params.toUpperCase();\n\t\t\t\t\tparams=params+\"+P_LANGUAGE_ID=\"+locale;\t\t\t\t\t\n\t\t\t\t\t\t//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Starts\n\t\t\t\t\tif (report_server_form.desformat.value==\"spreadsheet\" && (report_server_form.report.value == \"BLRRESFP\" || report_server_form.report.value == \"BLRRVAT\" )) {\n\t\t\t\t\t\turl = report_server_form.reportserver.value+\n\t\t\t\t\t\t\"?server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\t\"+report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\t\"+desformat=\"\t+ \"enhancedspreadsheet\"\t+\n\t\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\t\t\t\t\t\n\t\t\t\t\t\t\"+recursive_load=no\";\n\t\t\t\t\t}else {\t\t\t\t\t\t\t\n\t\t\t\t\t\turl = report_server_form.reportserver.value+\n\t\t\t\t\t\t\"?server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\t\"+report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\t\"+desformat=\"\t+ report_server_form.desformat.value\t+\n\t\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\t\t\t\t\t\n\t\t\t\t\t\t\"+recursive_load=no\";\n\t\t\t\t\t}\n\t\t\t\t\t//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Ends\n\t\t\t\t\t\n\t\t\t\t\tif(rep_server_key==\'\'){ //PMG2012-CRF-0027 IN:037658\n\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ report_server_form.userid.value\t\t+\"+\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t}\t\n\t\t\t\t\turl=url+params;\n\t\t\t\t\t//+\"&P_LANGUAGE_ID=\"+locale ;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tif ( report_option == \"P\" ) {\n\t// By sbchand start on 20th June, 2001\n\t\t\t\tvar myRegExp = /\\\\/g ;\n\t\t\t\tvar printerName = report_server_form.queue_name.value ;\n\t\t\t\tprinterName = printerName.replace( myRegExp, \"\\\\\\\\\" ) ;\n\t\t\t\treport_server_form.queue_name.value = printerName ;\n\t// By sbchand end on 20th June, 2001\n\n\t\t\t\treport_server_form.destype.value\t\t= \"printer\" ;\n\t\t\t\treport_server_form.desname.value \t\t= report_server_form.queue_name.value ;\n\t\t\t\t\tparams=params.toUpperCase();\n\t\t\t\t\tparams=params+\"+P_LANGUAGE_ID=\"+locale;\n\t\t\t\turl = report_server_form.reportserver.value \t\t\t\t+\n\t\t\t\t\t\"?report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\"+server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\n\t\t\t\t\t\"+desname=\"\t\t+ report_server_form.desname.value\t\t+\n\t\t\t\t\t\"+recursive_load=no\" \t\t+ \n\t\t\t\t\t\"+copies=\" \t\t+ report_server_form.copies.value\t\t+\n\t\t\t\t\t\"+background=yes\";//Copies included in the parameter\n\n\t\t\t\t\tif(rep_server_key==\'\'){ //PMG2012-CRF-0027 IN:037658\n\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ report_server_form.userid.value\t\t+\"+\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t}\t\n\n\t\t\t\t\turl=url+params;\n\t\t\t}\n\n\t\t\tif ( report_option == \"F\" ) {\n\t\t\t\t//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022\n\t\t\t\tif(report_server_form.reportServerEnableFlag.value==\'Y\')\n\t\t\t\t\t{\n\t\t\t\t\tvar desformat = parent.report_options.report_options_form.file_format.value ;\n\t\t\t\t\tvar folder_dir=parent.report_options.report_options_form.report_dir_path.value ;\n\t\t\t\t\tvar extension = \"\" ;\n\t\t\t\t\tif ( desformat == \"pdf\" )\textension = \".pdf\" ;\n\t\t\t\t\tif ( desformat == \"htmlcss\" ) extension = \".html\" ;\n\t\t\t\t\tif ( desformat == \"rtf\" )\textension = \".rtf\" ;\n\t\t\t\t\tif ( desformat == \"xml\" )\textension = \".xml\" ;\n\t\t\t\t\tif ( desformat == \"spreadsheet\" )\textension = \".xls\" ;\n\t\t\t\treport_server_form.destype.value\t= \t\"file\" ;\n\t\t\t\treport_server_form.desformat.value\t= \tparent.report_options.report_options_form.file_format.value ;\n\t\t\t//\treport_server_form.desname.value\t= \tparent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;\n\t\t\t\tvar file_name_dir=report_server_form.report.value+\'_\'+parent.report_options.report_options_form.file_name.value+extension ;\n\t\t\t\t\treport_server_form.desname.value=parent.report_options.report_options_form.report_dir.value+file_name_dir;\n\t\t\t\t\tparams=params.toUpperCase();\n\t\t\t\t\tparams=params+\"+P_LANGUAGE_ID=\"+locale;\n\t\t\t\turl = report_server_form.reportserver.value \t\t\t\t+\n\t\t\t\t\t\"?report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\"+server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\n\t\t\t\t\t\"+desformat=\"\t+ report_server_form.desformat.value\t+\n\t\t\t\t\t\"+filename=\"\t\t+ file_name_dir+\t\t\t    //File Path has been mapped to save the file in directoy for MOHE-SCF-0147\n\t\t\t\t\t\"+desname=\"\t\t+ report_server_form.desname.value\t\t+\t\t\n\t\t\t\t\t\"+background=yes\"\t+\n\t\t\t\t\t\"+recursive_load=no\" ;\n\n\t\t\t\t\tif(rep_server_key==\'\'){  //PMG2012-CRF-0027 IN:037658\n\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ report_server_form.userid.value\t\t+\"+\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t}\t\n\n\t\t\t\t\turl=url+params;\n\t\t\t\t\t\n\t\t\n\t\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\tvar desformat = parent.report_options.report_options_form.file_format.value ;\n\n\t\t\t\tvar extension = \"\" ;\n\n\t\t\t\tif ( desformat == \"pdf\" )\textension = \".pdf\" ;\n\t\t\t\tif ( desformat == \"htmlcss\" ) extension = \".html\" ;\n\t\t\t\tif ( desformat == \"rtf\" )\textension = \".rtf\" ;\n\t\t\t\tif ( desformat == \"xml\" )\textension = \".xml\" ;\n\t\t\t\tif ( desformat == \"spreadsheet\" )\textension = \".xls\" ;\n\n\t\t\t\treport_server_form.destype.value\t= \t\"file\" ;\n\t\t\t\treport_server_form.desformat.value\t= \tparent.report_options.report_options_form.file_format.value ;\n\t\t\t\treport_server_form.desname.value\t= \tparent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;\n\n\t\t\t\t\tparams=params.toUpperCase();\n\t\t\t\t\tparams=params+\"+P_LANGUAGE_ID=\"+locale;\n\t\t\t\turl = report_server_form.reportserver.value \t\t\t\t+\n\t\t\t\t\t\"?report=\" \t\t+ report_server_form.report.value \t\t+\n\t\t\t\t\t\"+server=\"\t\t+ report_server_form.server.value\t\t+\n\t\t\t\t\t\"+destype=\"\t\t+ report_server_form.destype.value\t\t+\n\t\t\t\t\t\"+desformat=\"\t+ report_server_form.desformat.value\t+\n\t\t\t\t\t\"+desname=\"\t\t+ report_server_form.desname.value\t\t+\t\t\n\t\t\t\t\t\"+background=yes\"\t+\n\t\t\t\t\t\"+recursive_load=no\" ;\n\n\t\t\t\t\tif(rep_server_key==\'\'){  //PMG2012-CRF-0027 IN:037658\n\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ report_server_form.userid.value\t\t+\"+\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t}\t\n\n\t\t\t\t\turl=url+params;\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t}\n\t\t\t\tif(report_server_form.reportServerEnableFlag.value!=\'Y\'){\n\t\t\t\tif ( report_option == \"F\" || report_option == \"P\" )\n\t\t\t\turl = url + \"&closeWindow=true\" ;\n\t\t\t\t}\t \n\t\t\t\t\n\t\t\t//parent.returnValue = url ;\n\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n            dialogBody.contentWindow.returnValue = url;\n            const dialogTag = parent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length-1]; \t   \n            dialogTag.close();\n            \n\t\t\t\t}\n\t\telse\n\t";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="\t{\n\t\t\t\n\t\t\talert(getMessage(\"PRINT_ROUTING_NOT_DEFINED\",\"Common\"));\n\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n            dialogBody.contentWindow.returnValue = url;\n            const dialogTag = parent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length-1]; \t   \n            dialogTag.close();\n\t\t}\n\t\t//parent.close() ;\n\t\t\n\t}\t\n\t\treturn true ;\n\t}\n\t\n\n\n\t\n\t\n</script>\n\n";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\n\n<form name=\"report_server_form\" id=\"report_server_form\" method=\"Post\">\n\t<input type=\"hidden\"\tname=\"reportserver\" id=\"reportserver\"\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\"hidden\" \tname=\"report\" id=\"report\"\t\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" \tname=\"userid\" id=\"userid\"\t\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\"\tname=\"server\" id=\"server\"\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\"\tname=\"desformat\" id=\"desformat\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"destype\" id=\"destype\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"desname\" id=\"desname\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"copies\" id=\"copies\"\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\"\tname=\"params\" id=\"params\"\t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\"\tname=\"queue_name\" id=\"queue_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\"\tname=\"message\" id=\"message\"\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\n\t<input type=\"hidden\"\tname=\"self_submit\" id=\"self_submit\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\"\tname=\"p_module_id\" id=\"p_module_id\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\"\tname=\"p_report_id\" id=\"p_report_id\"\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\"\tname=\"dest_locn_type\" id=\"dest_locn_type\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\"\tname=\"dest_locn_code\" id=\"dest_locn_code\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\"\tname=\"languageID\" id=\"languageID\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\"\tname=\"rep_server_key\" id=\"rep_server_key\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\"\tname=\"reportServerEnableFlag\" id=\"reportServerEnableFlag\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\"\tname=\"currentDateTime\" id=\"currentDateTime\"\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\"\tname=\"isExportExlConfigAvialYN\" id=\"isExportExlConfigAvialYN\"\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><!-- /*Added By Dharma for Export Excel -->\n</form>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n<center>\n<!--\n\t<img src=\"../images/BBrun.gif\" \t\talt=\"OK\" \t\tonClick=\"onSubmit();\">\n\t<img src=\"../images/BBcancel.gif\" \talt=\"Cancel\" \tonClick=\"parent.close();\">\n-->\n\n\t<input type=\'submit\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onClick=\'onSubmit();\'>\n\t<input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onClick=\'onClose();\'>\n</center>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    public String replaceNull(String input) {
        return (input == null) ? "" : input;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			 String locale=(String)session.getAttribute("LOCALE");
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

request.setCharacterEncoding("UTF-8");	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String userid		= (String) session.getValue( "report_connect_string" ) ;
	String params 		= request.getQueryString() ;
	String self_submit	= request.getParameter( "self_submit" ) ;


//	Output Parameters for Stored Procedure

	String report		= "" ;
	String server		= "" ;
	String copies		= "" ;
	//String report_mode	= "" ;
	String queue_name		= "" ;
	//String report_tool	= "" ;
	//String status		= "" ;
	String message		= "" ;
	String reportServerEnableFlag="";	

//	Input Parameters for Stored Procedure

	String module_id		= request.getParameter( "p_module_id" ) ;
	String report_id		= request.getParameter( "p_report_id" ) ;
	String dest_locn_type	= request.getParameter( "dest_locn_type" ) ;
	String dest_locn_code	= request.getParameter( "dest_locn_code" ) ;

//	String facility_id	= (String) session.getValue( "facility_id" ) ;
     String facility_id = replaceNull(request.getParameter("facility_id"));
    if(facility_id == null || facility_id.equals("") || facility_id.equals("undefined")) {
        facility_id = (String) session.getAttribute("facility_id");
    }  
	String report_ssl_yn	= (String) session.getValue( "report_ssl_yn" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String report_option	= request.getParameter( "report_option" ) ;
	String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );
	java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyyMMddHHmmss" ) ;
	String currentDateTime = dateTimeFormat.format( new java.util.Date() ) ; //Maheshwaran added to get currenttime
// By sbchand start on 25th July, 2001
	String app_server_ip	= "" ;
	String rep_server_key	= "" ;
// By sbchand end on 25th July, 2001

	if ( reportServer		== null ) reportServer	= "" ;
	if ( userid			== null ) userid		= "" ;
	if ( params 		== null ) params 		= "" ;
	if ( self_submit		== null ) self_submit	= "" ;

	if ( module_id		== null ) module_id 	= "" ;
	if ( report_id		== null ) report_id 	= "" ;
	if ( dest_locn_type 	== null ) dest_locn_type= "" ;
	if ( dest_locn_code	== null ) dest_locn_code= "" ;
	if ( facility_id		== null ) facility_id	= "" ;
	if ( ws_no			== null ) ws_no		= "" ;
	if ( report_option	== null ) report_option = "V" ;

	//params = params.toUpperCase();

//	params = params.replace( '&', '+' ) ;

		Connection con=null;
		int count	= 0;
		String isExportExlConfigAvialYN = "N";
		
		/*Added By Dharma for Export Excel End*/
//		Connection con = (Connection) session.getValue( "connection" ) ;
	
		
		try{
		con = ConnectionManager.getConnection(request);
		/*Added By Dharma for Export Excel Start*/
		String sqlRep = "select count(*) tot from SM_REP_EXL_EXPORT where REPORT_ID = '"+report_id+"' "; 
		PreparedStatement pstmt = con.prepareCall( sqlRep  ) ;
		ResultSet rs = pstmt.executeQuery() ;
	
		if ( rs != null && rs.next() ) {
			count	= rs.getInt("tot");
		}
		
		if(count > 0){
			isExportExlConfigAvialYN	= "Y";
		}
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
		/*Added By Dharma for Export Excel End*/
		//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022 
		con = ConnectionManager.getConnection(request);
		HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(con,"SM","REPORT_SERVER_POST");
		reportServerEnableFlag = (String)hashdata.get("value1");
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
		//PMG2012-CRF-0027 IN:037658  additional parameter added
		cs.setString( 1,	module_id ) ;
		cs.setString( 2,	report_id ) ;
		cs.setString( 3,	dest_locn_type ) ;
		cs.setString( 4,	dest_locn_code ) ;
		cs.setString( 5,	facility_id ) ;
		cs.setString( 6,	ws_no ) ;
		cs.setString( 7,	report_option ) ;
		cs.registerOutParameter( 8,  Types.VARCHAR ) ;
		cs.registerOutParameter( 9,  Types.VARCHAR ) ;
		cs.registerOutParameter( 10, Types.VARCHAR ) ;
		cs.registerOutParameter( 11, Types.VARCHAR ) ;
		cs.registerOutParameter( 12, Types.VARCHAR ) ;
		cs.registerOutParameter( 13, Types.VARCHAR ) ;
		cs.registerOutParameter( 14, Types.VARCHAR ) ;
		cs.registerOutParameter( 15, Types.VARCHAR ) ;
// By sbchand start on 25th July, 2001
		cs.registerOutParameter( 16, Types.VARCHAR ) ;
		cs.registerOutParameter( 17, Types.VARCHAR ) ;
// By sbchand end on 25th July, 2001
		cs.execute() ;

		report	= cs.getString( 8 ) ;
		server	= cs.getString( 9 ) ;
		copies	= cs.getString( 10 ) ;	
		if(report_id.equals("STBMFGLB") || report_id.equals("STBREPLB")  || report_id.equals("STBITLB2")){				
		copies=	request.getParameter( "p_no_labels" )==null?"1": request.getParameter( "p_no_labels" );
		}		
		if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
		//report_mode	= cs.getString( 11 ) ;
		queue_name	= cs.getString( 12 ) ;
		//report_tool	= cs.getString( 13 ) ;
		//status	= cs.getString( 14 ) ;
		message	= cs.getString( 15 ) ;
		if (message==null) message="";
// By sbchand start on 25th July, 2001
		app_server_ip = cs.getString( 16 ) ;
		rep_server_key= cs.getString( 17 ) ;//PMG2012-CRF-0027 IN:037658
		if (rep_server_key==null) rep_server_key="";
		if (report_ssl_yn==null) report_ssl_yn="";
		if(report_ssl_yn.equals("Y")){
			reportServer = "https://" + app_server_ip + reportServer ;
		}else{
			reportServer = "http://" + app_server_ip + reportServer ;
		}
// By sbchand end on 25th July, 2001

		if(cs !=null)cs.close() ;

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reportServer));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(report));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(server));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(copies));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(queue_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(message));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(self_submit));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dest_locn_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dest_locn_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(languageID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(reportServerEnableFlag));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(currentDateTime));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(isExportExlConfigAvialYN));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
	if ( self_submit.equals( "yes" ) )
		out.println( "<script language='JavaScript'>onSubmit();</script>" ) ;

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

}catch(Exception e){
		System.err.println("Exception in report_buttons.jsp : "+e);
	out.println(e);
	e.printStackTrace();
	}
			finally { 
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
