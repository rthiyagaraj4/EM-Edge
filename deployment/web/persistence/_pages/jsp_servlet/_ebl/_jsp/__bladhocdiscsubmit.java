package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import eCommon.Common.*;
import eBL.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __bladhocdiscsubmit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDiscSubmit.jsp", 1731678085448L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nSr No     Version        Incident\t\t\tSCF/CRF\t\t\t\t\tDeveloper Name\n-----------------------------------------------------------------------------------\n1          V201008                      NMC-JD-CRF-0066\t\t\t\t\tRam Kumar S\n2          V210407                      AMS-CRF-0238,AMRI-CRF-0473\t\tRam Kumar S \n3          V210315                      AMS-SCF-0780.1\t\t\t\t\tShikha Seth\n4          V210413                      RBU-AMS-CRF-0001\t\t\t\tShikha Seth\n5          V210821\t\t23129\t\t\tMMS-QF-SCF-0625/KDAH-SCF-0721\tMuthukumar\n6\t       V220110\t\t25938\t\t    GHL-CRF-0646\t\t\t        Nandhini M\n7          V220511                      KDAH-SCF-0773/AMS-SCF-1014/MMS-ICN-00129     Mohanapriya\n8\t       V220517      30818           GHL-SCF-1652                    Mohanapriya K\n9          V220609      31837           GHL-SCF-1659                    MohanapriyaK\n10         V220711      32529           KDAH-SCF-0786-TF                Manivel N\n11\t         V221117\t\t\t\t\t\t\t\tTH-KW-CRF-0174  \t\tMohana Priya K\n12\t\t\t\tV221230\t\t\t\t\t\t\tNMC-JD-CRF-0191.1 \t\t\tMohanapriya\n-----------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\n<script>\n\n/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/\nfunction callAsyncOnlinePrint(){\n\tif(document.getElementById(\"ZatcaYN\").value==\"Y\"){\n\t\tif(document.getElementById(\"zatca_error_code\").value!=\'E\'){\n\t\t\tvar xmlStr=\"<root><report/></root>\";\n\t\t\tvar xmlDoc = \"\";\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp\",true);\n\t\t\txmlHttp.send(xmlDoc);\t\n\t\t}\n\t}else{\n\t\tvar xmlStr=\"<root><report/></root>\";\n\t\tvar xmlDoc = \"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp\",true);\n\t\txmlHttp.send(xmlDoc);\t\n\t}//V221230\n}\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\');\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\"BL\"));\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\n<html>\n<head>\n<Script Language=\"JavaScript\">\nfunction test() {\n\t\t//alert(\"1410,inside test==>\");\n\t\t//new code\n\t\tvar siteSpecGhl= document.getElementById(\"GHL_site_spec\").value;\n\t\tvar result= document.getElementById(\"result\").value;\n\t\tvar slmt_reqd_yn= document.forms[0].slmt_reqd_yn.value;\n\t\t//alert(\"1574,adhoc,slmt_reqd_yn==>\"+slmt_reqd_yn);\n\t\t//alert(\"1575,result==>\"+result);\n\t\tvar strbillpayableamt= document.forms[0].strbillpayableamount.value;\n\t\tvar settmnt_ind= document.forms[0].settmnt_ind.value;\n\t\t//alert(\"settmnt_ind==>\"+settmnt_ind);\n\t\tif(strbillpayableamt==\"\"||strbillpayableamt==\"null\"||strbillpayableamt==null)\n\t\t{\n\t\t\tstrbillpayableamt=0;\n\t\t}\n\t\t//alert(\"adhoc,strbillpayableamt\"+strbillpayableamt);\n\t\tif((siteSpecGhl==\'Y\') && (strbillpayableamt== 0 || settmnt_ind == \'R\')){\n\t\t\t//if(siteSpecGhl==\'Y\'){\n\t\tvar docTypeCode = document.getElementById(\"billdoctypecode\").value;\n\t\t//alert(\"docTypeCode==>\"+docTypeCode);\n\tvar docNum = document.getElementById(\"billdocnum\").value;\n\t//alert(\"docNum==>\"+docNum);\n\tvar view = document.getElementById(\"view\").value;\n\t//alert(\"view==>\"+view);\n\tvar facility_id = document.getElementById(\"facility_id\").value;\n\t//alert(\"facility_id==>\"+facility_id)\n\tvar locale = document.getElementById(\"locale\").value;\n\t//alert(\"locale11111111111==>\"+locale)\n\tvar episodeType = document.forms[0].episode_type.value;\n\t//alert(\"episodeType==>\"+episodeType);\n\tvar login_user = document.getElementById(\"strloggeduser\").value;\n\t//alert(\"login_user==>\"+login_user)\n\tvar p_report_id=document.getElementById(\"strBlrblprt\").value;\n\t//alert(\"1407,adhoc,p_report_id:\"+p_report_id);\n\tvar  p_module_id = \"BL\" ;\n\tvar detailed_yn =\'Y\';\n\n\t var xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\tvar param=\"func_mode=TotalBillsForPeriod&p_report_id=\"+p_report_id+\n\t\t\t\"&param1=\"+docTypeCode+\n\t\t\t\"&param2=\"+docTypeCode+\n\t\t\t\"&param3=\"+docNum+\n\t\t\t\"&param4=\"+docNum+\n\t\t\t\"&param5=\"+\n\n\t\t\t\"&param6=\"+detailed_yn+\n\t\t\t\"&param7=\"+\"R\"+\n\t\t\t\"&param8=\"+locale+\n\t\t\t\"&param9=\"+\n\t\t\t\"&param10=\"+\n\n\t\t\t\"&param11=\"+\n\t\t\t\"&param12=\"+\n\t\t\t\"&param13=\"+\n\t\t\t\"&param14=\"+episodeType+\"&param26=Y\";//V220609\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eBL/jsp/TotBillForPeriodCommon.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\tretVal = trimString(retVal).split(\":::\");\n\t\t\tvar session_id = \'\';\n\t\t\tvar pgm_date = \'\';\n\t\t\tif(retVal.length == 2){\n\t\t\t\tsession_id = retVal[0];\n\t\t\t\tpgm_date = retVal[1];\n\t\t\t\t}\n\t\t//**************************************************\n\n\t\t\t\t\tvar reportserver = document.getElementById(\"reportserver\").value;\n\t\t\t\t\t//var reportserver = \"http://CSCAPPCHE659:9002/reports/rwservlet\";\n\t\t\t\t\t//alert(\"adhoc,reportserver==>\"+reportserver);\n\t\t\t\t\tvar user_id = document.getElementById(\"user_id\").value;\n\t\t\t\t\tvar server = document.getElementById(\"server\").value;\n\t\t\t\t\t//alert(\"adhoc,server==>\"+server);\n\t\t\t\t\tvar report = document.getElementById(\"report\").value;\n\t\t\t\t\t//alert(\"adhoc,1475,report====>\"+report);\n\t\t\t\t\tvar rep_server_key = document.getElementById(\"rep_server_key\").value;\n\t\t\t\t\t//alert(\"adhoc,1475,rep_server_key====>\"+rep_server_key);\n\t\t\t\t\tvar fileName = document.getElementById(\"fileName\").value;\n\t\t\t\t\t//alert(\"1473,fileName===>\"+fileName);\n\t\t\t\t\tvar filePath = document.getElementById(\"filePath\").value;\n\t\t\t\t\t//alert(\"1475,filePath===>\"+filePath);\n\t\t\t\t\tvar extension = \".pdf\";\n\n\n\t\t\t\t\tfilePath = filePath.replace(/\\\\/g, \"\\\\\");\n\t\t\t\t\t/* filePath = \"\\\\Cscdbche648\\\\tf_backup\\\\BL\\\\Do_Not_Delete\\\\ghl_pdf\\\\\";\n\t\t\t\t\t//filePath=filePath.replace(\'\\\',\'\\\\\\\\\\\');\n\t\t\t\t\talert(\"filePath 555==>\"+filePath)\n\t\t\t\t\tfilePath=filePath.replace(\'\\\\\',\'\\\\\\\\\');\n\t\t\t\t\talert(\"filePath 333==>\"+filePath) */\n\t\t\t\t\t//var desname = \'\\\\\' + filePath + \'\\\\\\\\\\\\\' +fileName+ extension;\n\n\t\t\t\t\tvar desname = filePath + fileName + extension;\n\t\t\t\t\t//alert(\"adhoc,desname===>\"+desname);\n\t\t\t\t\t//desname = \"\\\\\\\\\\\\Cscdbche648\\\\\\\\\\tf_backup\\\\\\\\\\BL\\\\\\\\\\Do_Not_Delete\\\\\\\\\\ghl_pdf\\\\\\\\\\MM00000597GHOPCR13011226.pdf\";\n\t\t\t\t\t//params = \"strbilldoctypecode\"+\"strbilldocnum\";\n\t\t\t\t\t//desname = \"\\\\\\\\\\\\\\\\Cscdbche648\\\\\\\\\\dpdump\\\\\\\\\\BL\\\\\\\\\\Do_Not_Delete\\\\\\\\\\ghl_pdf\\\\\\\\\\MM00000597GHOPCR13011226.pdf\";\n\t\t\t\t\t//params=params+\"+LOCALE=EN+P_LANGUAGE_ID=\"+locale;\n\t\t\t\t\t//added for view part\n\t\t\t\t\tif((view==\'Y\')){\n\t\t\t\t\t\t//alert(\"1482===>\");\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar url = reportserver \t\t\t\t+\n\t\t\t\t\t\t\t\t\"?server=\"\t\t+ server\t\t+\n\t\t\t\t\t\t\t\t\"+report=\" \t\t+ report \t\t+\n\t\t\t\t\t\t\t\t\"+destype=cache\"\t\t+\n\t\t\t\t\t\t\t\t\"+desformat=pdf\"+\n\t\t\t\t\t\t\t\t\"+recursive_load=no\" ;\n\n\t\t\t\t\t\t\t\t\tif(rep_server_key==\'\'){  \t\t\n\t\t\t\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ user_id\t\t+\"+\";\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\turl= url + \"REPORT_OPTION=V+\"+\n\t\t\t\t\t\t\t\t\"LOCALE=\"+locale+\"+P_LANGUAGE_ID=\"+locale+\"+P_PGM_ID=\"+p_report_id+\"+P_PGM_DATE=\"+pgm_date+\"+P_SESSION_ID=\"+session_id+\"+P_FACILITY_ID=\"+facility_id;\n\t\t\t\t\t\t\t\t//alert(\"adhoc,url===>\"+url);\n\t\t\t\t\t\t\t\tif ( url != null ) {  \n\t\t\t\t\t\t\t\t\t//var url\t\t= \"../../eCommon/jsp/report_process.jsp?\" + url ;\n\t\t\t\t\t\t\t\t\tvar myBars \t\t= \'directories=no,location=no,menubar=no\' ;\n\t\t\t\t\t\t\t\t\tvar myOptions \t= \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=yes\' ;\n\t\t\t\t\t\t\t\t\tvar myFeatures \t= myBars + \', \' + myOptions ;\n\t\t\t\t\t\t\t\t\t//alert(\"1498,reportURL\"+url);\n\t\t\t\t\t\t\t\t\tvar reportWindow \t= open(url, \'_blank\', myFeatures);\n\n\t\t\t\t\t\t\t\t\t//reportWindow.title= \"Medicom Report Viewer\";\n\t\t\t\t\t\t\t\t\t//reportWindow.resizeTo(screen.availWidth, screen.availHeight);\n\t\t\t\t\t\t\t\t\t//alert(\"1511===>\");\n\t\t\t\t\t\t\t\t\t/*reportWindow.moveTo( 0,0 );\n\t\t\t\t\t\t\t\t\talert(\"1513===>\");\n\t\t\t\t\t\t\t\t\treportWindow.focus();\n\t\t\t\t\t\t\t\t\talert(\"1514===>\");*/\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//alert(\"result==>\"+result);\n\t\t\t\t\t\t\t//ends for view part\n\t\t\t\t\t\t\tif(result==\'Y\'){\n\t\t\t\t\t\t\t\t//alert(\"1515===>\");\n\t\t\t\t\t\t\t\t\tvar url = reportserver \t\t\t\t+\n\t\t\t\t\t\t\"?report=\" \t\t+ report \t\t+\n\t\t\t\t\t\t\"+server=\"\t\t+ server\t\t+\n\t\t\t\t\t\t\"+destype=file\"\t\t+\n\t\t\t\t\t\t\"+desformat=pdf\"+\n\t\t\t\t\t\t\"+desname=\"\t+ desname\t\t+\n\t\t\t\t\t\t\"+background=yes\"\t+\n\t\t\t\t\t\t\"+recursive_load=no\" ;\n\t\t\t\t\t//alert(\"1529===>\");\n\t\t\t\t\t\tif(rep_server_key==\'\'){\n\t\t\t\t\t\turl=url+\"+userid=\" \t\t+ user_id\t\t+\"+\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\turl=url+\"+cmdkey=\" \t\t+ rep_server_key\t\t+\"+\";\n\t\t\t\t\t}\n\t\t\t\t\t\t\turl= url + \"SELF_SUBMIT=YES+REPORT_OPTION=F+\"+\n\t\t\t\t\t\t\t\"LOCALE=\"+locale+\"+P_LANGUAGE_ID=\"+locale+\"+P_PGM_ID=\"+p_report_id+\"+P_PGM_DATE=\"+pgm_date+\"+P_SESSION_ID=\"+session_id+\"+P_FACILITY_ID=\"+facility_id;\n\t\t\t\t\t\t\t\t\t\t//alert(\"1472,url===>\"+url);\n\t\t\t\t\t\t\t\t\t\t//url = url + \"&closeWindow=true\" ;\n\t\t\t\t\t\t\t\t\t\t//alert(\"url===123==>\"+url);\n\n\t\t\t\t\t\t\tif ( url != null ) {\n\t\t\t\t\t\t\t//var reportURL\t\t= \"../../eCommon/jsp/report_process.jsp?\" + url ;\n\t\t\t\t\t\t\t//alert(\"1514,reportURL=====>>>\"+reportURL);\n\t\t\t\t\t\t\t var myBars \t\t= \'directories=no,location=no,menubar=no\' ;\n\t\t\t\t\t\t\tvar myOptions \t= \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=yes\' ;\n\t\t\t\t\t\t\tvar myFeatures \t= myBars + \', \' + myOptions ;\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar reportWindow \t= open(url, \'_blank\', myFeatures);\n\t\t\t\t\t\t\t//report has been submitted to the report server msg coming and opens the web page 659\n\t\t\t\t\t\t\n\t\t\t\t\t\t\treportWindow.close();\n\t\t\t\t\t\t\t//alert(\"1575===>\");//opening reportprocess.jsp with 4 \\ in desname\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t}\n\n\t\t\t\t//new code ends\n\t\tif (document.forms[0].called_butt.value == \"CLOSE_BUTTON\") {\n\t\t\tif (document.forms[0].called_frm.value == \"OTH_MOD\") {\n\t\t\t\t//alert(\"1549=====>\");\n\t\t\t\tvar error_flag = document.forms[0].error_flag.value;\n\t\t\t\tif(error_flag == \"N\")\n\t\t\t\t{\n\t\t\t\t\tvar retVal = \"\";\n\t\t\t\t\tvar ordering_facility_id = document.forms[0].ordering_facility_id.value;//Added against V210821 & V220511\n\t\t\t\t\t//V220510\n\t\t\t\t\tvar billdoctypecode=document.forms[0].billdoctypecode.value;\n\t\t\t\t\tvar billdocnum=document.forms[0].billdocnum.value;\n\t\t\t\t\tvar slmt_reqd_yn=document.forms[0].slmt_reqd_yn.value;\n\t\t\t\t\tvar storecode=document.forms[0].storecode.value;\n\t\t\t\t\tvar blnggrp=document.forms[0].blnggrp.value;\n\t\t\t\t\tvar module_id=document.forms[0].module_id.value;\n\t\t\t\t\tvar function_id=document.forms[0].function_id.value;\n\t\t\t\t\tvar episode_type=document.forms[0].episode_type.value;\n\t\t\t\t\tvar allow_chkout_with_bill_stmt_yn=document.forms[0].allow_chkout_with_bill_stmt_yn.value;\n\t\t\t\t\tvar final_message = document.forms[0].final_message.value;\n\t\t\t\t\t//V221117 Starts\n\t\t\t\t\t//var settmnt_ind=document.forms[0].settmnt_ind.value;\n\t\t\t\t\t//alert(\"settmnt_ind \"+settmnt_ind);\n\t\t\t\t\tvar insBillCount = document.forms[0].insBillCount.value;\n\t\t\t\t\tvar eSignatureFlag = document.forms[0].eSignatureFlag.value;\n\t\t\t\t\t//V221117 ends\n\t\t\t\t\tvar ZatcaYn=document.forms[0].ZatcaYN.value;//V221230\n\t\t\t\t\tif(billdoctypecode != \"\" && billdocnum != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tretVal = billdoctypecode+\"|\"+billdocnum+\"|\"+slmt_reqd_yn;\n\t\t\n\t\t\t\t\t\tif(final_message != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//V221117 Starts\n\t\t\t\t\t\t\tif(eSignatureFlag == \"Y\" && insBillCount > 0){\n\t\t\t\t\t\t\t\tvar esign=OpenEsign(); \n\t\t\t\t\t\t\t\tif(esign==\'1\' || esign==1){\n\t\t\t\t\t\t\t\t\talert(final_message);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}else if(ZatcaYn==\"Y\"){ //V221230\n\t\t\t\t\t\t\t    var Zatca_msg=document.forms[0].Zatca_msg.value;\n\t\t\t\t\t\t\t\tif(Zatca_msg!=\'\'){\n\t\t\t\t\t\t\t\t\tfinal_message=final_message+\"\\n\"+Zatca_msg;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\talert(final_message);\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\talert(final_message);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//V221117 Ends\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\t\n\t\t\t\t\t\tretVal=\" | |N\";\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(module_id == \"PH\" || module_id == \"ST\")\n\t\t\t\t{\n\t\t\t\t\tif (slmt_reqd_yn == \"Y\") {\n\t\t\t\t\t\t//Commented against V210821\n\t\t\t\t\t\t/*parent.parent.frames[0].location.href = \"../../eBL/jsp/BLStoreBillSlmtMain.jsp?billdoctypecode=\"\n\t\t\t\t\t\t\t\t+ billdoctypecode\n\t\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t\t+ \"billdocnum=\"\n\t\t\t\t\t\t\t\t+ billdocnum\n\t\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t\t+ \"storecode=\"\n\t\t\t\t\t\t\t\t+ storecode\n\t\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t\t+ \"blnggrp=\"\n\t\t\t\t\t\t\t\t+ blnggrp\n\t\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t\t+ \"module_id=\"\n\t\t\t\t\t\t\t\t+ module_id\n\t\t\t\t\t\t\t\t+ \"&function_id=\" + function_id;*/\n\t\t\t\t\t\t//Added against V210821 Starts\n\t\t\t\t\t\tparent.parent.frames[0].location.href = \"../../eBL/jsp/BLStoreBillSlmtMain.jsp?billdoctypecode=\"\n\t\t\t\t\t\t\t+ billdoctypecode\n\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t+ \"billdocnum=\"\n\t\t\t\t\t\t\t+ billdocnum\n\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t+ \"storecode=\"\n\t\t\t\t\t\t\t+ storecode\n\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t+ \"blnggrp=\"\n\t\t\t\t\t\t\t+ blnggrp\n\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t+ \"module_id=\"\n\t\t\t\t\t\t\t+ module_id\n\t\t\t\t\t\t\t+ \"&\"\n\t\t\t\t\t\t\t+ \"function_id=\" \n\t\t\t\t\t\t\t+ function_id\n\t\t\t\t\t\t\t+ \"&ordering_facility_id=\" + ordering_facility_id;\t\n\t\t\t\t\t\t//Added against V210821 & V220511 Ends\n\t\t\t\t\t} else {\n\t\t\t\t\t\t//changed By Vedesh A D\n\t\t\t\t\t\t/* window.returnValue=retVal;\n\t\t\t\t\t\twindow.close(); */\n\t\t\t\t\t\tparent.document.getElementById(\'dialog-body\').contentWindow.returnValue = retVal;\n\t\t\t\t\t\tparent.document.getElementById(\'dialog_tag\').close();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(module_id == \"OR\")\n\t\t\t\t{\n\t\t\t\t\tif(slmt_reqd_yn==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.frames[0].loca";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="tion.href=\"../../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode=\"+billdoctypecode+\"&\"+\"billdocnum=\"+billdocnum+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"module_id=\"+module_id+\"&function_id=\"+function_id;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{//changed By Vedesh A D\n\t\t\t\t\t\t/* window.returnValue=retVal;\n\t\t\t\t\t\twindow.close(); */\n\t\t\t\t\t\tparent.document.getElementById(\'dialog-body\').contentWindow.returnValue = retVal;\n\t\t\t\t\t\tparent.document.getElementById(\'dialog_tag\').close();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(module_id == \"MP\")\n\t\t\t\t{\n\t\t\t\t\t\tparent.parent.frames[0].location.href=\"../../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode=\"+billdoctypecode+\"&\"+\"billdocnum=\"+billdocnum+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"module_id=\"+module_id+\"&function_id=\"+function_id;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//changed By Vedesh A D\n\t\t\t\t\t/* window.returnValue=retVal;\n\t\t\t\t\twindow.close(); */\n\t\t\t\t\t/* parent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = retVal;\n\t\t\t\t\tparent.parent.document.getElementById(\'dialog_tag\').close(); */\n\t\t\t\t\tvar diagElement = parent.parent.document.getElementsByTagName(\"dialog\");\n\t\t\t\t\tvar i = 0; var j = 0;\n\t\t\t\t\tfor (i = 0; i < diagElement.length; i++) {\n\t\t\t\t\t\tfor (j = 0; j < diagElement[i].children.length; j++) {\n\t\t\t\t\t\t\tvar element = diagElement[i].children[j];\n\t\t\t\t\t\t\tlet dialogSrc = element.src;\n\t\t\t\t\t\t\tif (typeof dialogSrc !== \"undefined\")\n\t\t\t\t\t\t\t{ \n\t\t\t\t\t\t\t\tif (dialogSrc.includes(\"BLAdhocDiscFrame.jsp\")) \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\telement.contentWindow.returnValue = retVal;\n\t\t\t\t\t\t\t\t\tvar dialogTag = diagElement[i];    \n\t\t\t\t\t\t\t\t\tdialogTag.close(); \n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}    \t\t\n\t\t\t\t\t\t} \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar sys_mesage_id = document.forms[0].sys_mesage_id.value;\n\t\t\t\tif(sys_mesage_id == \"BL1024\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.getElementById(\"cash_counter_log_in_disp\").style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\tif(sys_mesage_id == \"BL1262\" || sys_mesage_id == \"BL1094\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.getElementById(\"cash_counter_log_out_disp\").style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t/*Added for KDAH-CRF-0347.1 by Rajesh V */\n\t\t\t\tvar str_error_text = document.forms[0].str_error_text.value;\n\t\t\t\tvar errorToBeValidated = \'PAN Card or Form 60 is mandatory in order to generate the bill. Please get the details from patient.\';\n\t\t\t\tif(str_error_text != \'\'){\n\t\t\t\t\tif(str_error_text.indexOf(errorToBeValidated) != -1){\n\t\t\t\t\t\twindow.returnValue=\'N\';\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(sys_mesage_id != \'\'){\t\n\t\t\t\t\tif(getMessage(sys_mesage_id,\'BL\').indexOf(errorToBeValidated) != -1){\n\t\t\t\t\t\twindow.returnValue=\'N\';\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t/*Added for KDAH-CRF-0347.1 by Rajesh V */\n\t\t\t}\n\t\t}\n\t}\n}\n\n//V221117\n\nfunction OpenEsign(){\n\tvar docTypeCode=document.forms[0].billdoctypecode.value;\n\tvar docNum=document.forms[0].billdocnum.value;\n\tvar patientId=document.forms[0].str_patient_id.value;\n\tvar episodeType=document.forms[0].episode_type.value;\n\tvar episodeId=document.forms[0].str_episode_id.value;\n\tvar visitId=document.forms[0].str_visit_id.value;\n\tvar mpi_id=document.forms[0].mpi_id1.value;\n\tvar returnVal=validate_eSignature();\n\t\t\n\tif(returnVal!=\'\' && returnVal!=\'undefined\' && returnVal!=undefined ){\n\t\tvar params=\"docTypeCode=\"+docTypeCode+\"&docNum=\"+docNum+\"&visitId=\"+visitId+\"&episodeType=\"+episodeType+\"&episodeId=\"+episodeId+\"&patientId=\"+patientId+\"&mpi_id=\"+mpi_id+\"&image=\"+encodeURIComponent(returnVal);\n\t\t\n\t\t $.ajax({\n\t\t\ttype:\"POST\",\n\t\t\turl:\"../../eBL/jsp/BLCommonAjax.jsp\",\n\t\t\tdata:\"functionMode=PatientSign&\"+params,\n\t\t\tdataType:\"text\",\n\t\t\tasync:false,\n\t\t\tsuccess: function(data){\n\t\t\t\t\n\t\t\t},\n\t\t\terror: function(data){\n\t\t\t//\talert(\"error in esign :\"+data);\n\t\t  }\n\t\t});\n\t}\n\treturn 1;\t\n}\n</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body onLoad=\"test()\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form>\n\t\t<input type=\"hidden\" name=\"called_frm\" id=\"called_frm\" value=\"";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type=\"hidden\" name=\"strloggeduser\" id=\"strloggeduser\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t<input type=\"hidden\" name=\"called_butt\" id=\"called_butt\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<input type=\"hidden\" name=\"billdoctypecode\" id=\"billdoctypecode\" id=\"billdoctypecode\"\n\t\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type=\"hidden\"\n\t\t\tname=\"billdocnum\" id=\"billdocnum\" id=\"billdocnum\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"> <input type=\"hidden\" name=\"slmt_reqd_yn\" id=\"slmt_reqd_yn\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\"hidden\" name=\"storecode\" id=\"storecode\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\"hidden\" name=\"blnggrp\" id=\"blnggrp\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\"hidden\" name=\"final_message\" id=\"final_message\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\"hidden\" name=\"error_flag\" id=\"error_flag\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\"GHL_site_spec\" id=\"GHL_site_spec\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"><!--added for GHL-CRF-0646 V220110-->\n\t\t<input type=\"hidden\" name=\"result\" id=\"result\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\"hidden\" name=\"settmnt_ind\" id=\"settmnt_ind\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\"hidden\" name=\"strbillpayableamt\" id=\"strbillpayableamt\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\"hidden\" name=\"strbillpayableamount\" id=\"strbillpayableamount\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\"hidden\" name=\"strCustCode\" id=\"strCustCode\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> <!--added for GHL-CRF-646 V220110-->\n\t\t <!--endsfor GHL-CRF-646 V220110-->\n\t\t<input type=\"hidden\" name=\"sys_mesage_id\" id=\"sys_mesage_id\"\n\t\t\tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\n\t<!--Added By Muthukumar on 30-1-12 for GAP -09 -->\n\t<input type=\"hidden\" name=\"dep_adjust_yn\" id=\"dep_adjust_yn\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"dep_alert\" id=\"dep_alert\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"dep_exist\" id=\"dep_exist\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<!--Added By Muthukumar on 30-1-12 for GAP -09 -->\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"  value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"allow_chkout_with_bill_stmt_yn\" id=\"allow_chkout_with_bill_stmt_yn\"  value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"str_error_text\" id=\"str_error_text\"  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t<!--added against GHL-CRF-0646 V220110-->\n\t\t\t<!--form name=\"report_server_form\" method=\"Post\"-->\n\t\t\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t<input type=\"hidden\" name=\"strBlrblprt\" id=\"strBlrblprt\" id=\"strBlrblprt\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"reportserver\" id=\"reportserver\"\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t<!--input type=\"hidden\"\tname=\"billdocnum\"\tvalue=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"-->\n\t\t\t<!--input type=\"hidden\"\tname=\"billdoctypecode\"\tvalue=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"-->\n\t\t\t<!--input type=\"hidden\"\tname=\"strloggeduser\"\tvalue=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"-->\n\t\t\t<input type=\"hidden\" \tname=\"report\" id=\"report\"\t\tvalue=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t<input type=\"hidden\" \tname=\"userid\" id=\"userid\"\t\tvalue=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"server\" id=\"server\"\t\tvalue=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<input type=\"hidden\" name=\"report_server\" id=\"report_server\" id=\"report_server\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"desformat\" id=\"desformat\"\tvalue=\"\">\n\t\t\t<input type=\"hidden\"\tname=\"destype\" id=\"destype\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\"\tname=\"desname\" id=\"desname\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\"\tname=\"copies\" id=\"copies\"\t\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"params\" id=\"params\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\"\tname=\"queue_name\" id=\"queue_name\"\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"message\" id=\"message\"\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\n\t\t\t<input type=\"hidden\"\tname=\"self_submit\" id=\"self_submit\"\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"p_module_id\" id=\"p_module_id\"\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"p_report_id\" id=\"p_report_id\"\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"dest_locn_type\" id=\"dest_locn_type\"\tvalue=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"dest_locn_code\" id=\"dest_locn_code\"\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"languageID\" id=\"languageID\"\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"locale\" id=\"locale\"\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t<input type=\'hidden\' name=\'ordering_facility_id\' id=\'ordering_facility_id\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t<!-- V210821 End -->\n\t\t\t<input type=\"hidden\"\tname=\"filePath\" id=\"filePath\"\tvalue=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"fileName\" id=\"fileName\"\tvalue=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"rep_server_key\" id=\"rep_server_key\"\tvalue=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"view\" id=\"view\"\tvalue=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t<input type=\"hidden\"\tname=\"str_patient_id\" id=\"str_patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><!-- V221117 -->\n\t\t\t<input type=\"hidden\"\tname=\"str_episode_id\" id=\"str_episode_id\"\tvalue=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><!-- V221117 --> \n\t\t\t<input type=\"hidden\"\tname=\"str_visit_id\" id=\"str_visit_id\"\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"><!-- V221117 -->\n\t\t\t<input type=\"hidden\"\tname=\"mpi_id1\" id=\"mpi_id1\"\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"><!-- V221117 -->\n\t\t\t<input type=\"hidden\"\tname=\"insBillCount\" id=\"insBillCount\"\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"><!-- V221117 -->\n\t\t\t<input type=\"hidden\"\tname=\"eSignatureFlag\" id=\"eSignatureFlag\"\tvalue=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"><!-- V221117 -->\n\t\t\t<input type=\"hidden\"\tname=\"Zatca_msg\" id=\"Zatca_msg\"\tid=\"Zatca_msg\"\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"><!-- V221230 -->\n\t\t\t<input type=\"hidden\"\tname=\"zatca_error_code\" id=\"zatca_error_code\"\tid=\"zatca_error_code\"\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"><!-- V221230 -->\n\t\t\t<input type=\"hidden\"\tname=\"ZatcaYN\" id=\"ZatcaYN\"\tid=\"ZatcaYN\"\tvalue=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"><!-- V221230 -->\n\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n</html>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

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

/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 starts  */
if(request.getParameter("sel_frm_default_reason")!=null && request.getParameter("sel_frm_default_reason").equals("on")){
	if(request.getParameter("disc_reason_desc")!=null){
	session.setAttribute("str_default_reason_code",request.getParameter("disc_reason_code"));
	session.setAttribute("str_default_reason_desc",request.getParameter("disc_reason_desc"));
	}
}
/* Fix added by Karthik on 19-Nov-2012  for AMS-SCF-0170 ends */
	Connection con = null;
	Statement stmt = null;
	ResultSet rs   = null;
	PreparedStatement pstmt = null;
	CallableStatement call = null;
	CallableStatement cs = null;
	ResultSet rstMt = null;
	PreparedStatement pstmtRpt = null;
	request.setCharacterEncoding("UTF-8");
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ; //added for GHL-CRF-0646 V220110
	String str_error_level = "", str_error_text = "", str_sysmesage_id = "", str_error_code;
	String strbilldoctypecode = "", strbilldocnum = "", called_frm = "", called_module_id = "";
	String str_bill_gen_yn = "", str_bill_doc_type = "", str_bill_doc_number = "", str_slmt_reqd_yn = "",
			strFinalMessage = "";
	//added against GHL-CRF-0646 V220110
	String  result="", fileName = "", path = "",view="";
	String reportServer	= (String) session.getValue( "report_server" );
	System.err.println("56,adhoc,reportServer"+reportServer);
	String userid		= (String) session.getValue( "report_connect_string" );
	String self_submit	= request.getParameter( "self_submit" );
	PreparedStatement pstmt1 = null ;
	ResultSet rs1 =null;
		String jdbc_username="";
		String jdbc_password="";
		String report_server="";
		String reoprt_connect_string="";
		String user_id="";

		String report		= "";
		String server		= "";
		String copies		= "";
		String queue_name	= "";
		String message		= "";

		String module_id		= request.getParameter( "module_id" );
		System.err.println("1310,--->"+module_id);
		String report_id		= request.getParameter( "p_report_id" );
		System.err.println("1311,--->"+report_id);
		String dest_locn_type	= request.getParameter( "dest_locn_type" );
		System.err.println("1312,--->"+dest_locn_type);
		String dest_locn_code	= request.getParameter( "dest_locn_code" );
		System.err.println("1313,--->"+dest_locn_code);
		//V220510
		String str_ordering_facility_id = request.getParameter("ordering_facility_id");
		if (str_ordering_facility_id == null) str_ordering_facility_id = (String) session.getValue("facility_id");
		System.err.println("BLAdhocdiscsubmit,str_ordering_facility_id==>"+str_ordering_facility_id);
		//V220510
		String facility_id	= (String) session.getValue( "facility_id" );
		System.err.println("1314,--->"+facility_id);
		String ws_no		= (String) p.getProperty( "client_ip_address" );
		System.err.println("1315,--->"+ws_no);
		String report_option = request.getParameter( "report_option" );
		System.err.println("1316,--->"+report_option);
		String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );
		System.err.println("1317,--->"+languageID);

		String app_server_ip	= "", rep_server_key	= "";

	String str_deposit_alert_yn ="",str_deposit_exists_YN=""; //muthu 
	String bill_print_reqd="";	
	String p_doc_no="",p_store_code="",p_user="",p_ws_no="",p_machine="";
	String error_flag="N";
	String str_bill_prt_format_YN = "N";
	String str_bill_prt_format_vals = "";
	String str_bill_print_format_flag = "N";
	String pgm_id ="";
	String session_id ="";
	String pgm_date ="";
	String mpi_id = "";
	String allow_chkout_with_bill_stmt_yn="N";
	String strBlrblprt="";
	CallableStatement cstmt = null;//KDAH-CRF-0546
	//Added V200326-MuthuN/NMC-JD-CRF-050
	boolean preConfigDiscAmt_YN=false;
	String preConfigDiscAmt="";
	//Added V200326-MuthuN/NMC-JD-CRF-050
	
	HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> (); //Code added by Karthik to move the Online Print module to asyncronous mode
	int  blprintVal =0; //increment variable to maintain uniqueness while storing in session
	String bl_items_sl_no ="";
	//KDAH-CRF-0318
	String baseCurrency = "";
	Boolean Slysite = false;
	String Slysite_spec = "";
	//V210413
	String strbillpayableamt = "";
	String str_prt_payer_bill_zero_yn = "N";
	String str_prt_zero_gross_bill_frm_gen_yn = "N";
	String strCustCode="";
	String orZeroBill="N";
	boolean siteORZeroBillPrint = false; 
	//V210413
	try {
		HttpSession httpSession = request.getSession(false);
		String locale = (String) session.getAttribute("LOCALE");
		//Properties p = (Properties) httpSession.getValue("jdbc"); //commented against GHL-CRF-0646 V220110
		java.util.Locale loc = new java.util.Locale(locale);

		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
//		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

   		con	=	ConnectionManager.getConnection(request);

		//Added V200323-MuthuN/NMC-JD-CRF-050
		preConfigDiscAmt_YN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ADDITIONAL_ADHOC");
		if(preConfigDiscAmt_YN){
			preConfigDiscAmt="Y";
		}
		else{
			preConfigDiscAmt="N";
		}
		//Added V200323-MuthuN/NMC-JD-CRF-050
		String str_facility_id	=  (String) session.getValue("facility_id");
	
		con.setAutoCommit(false);		
		//added against GHL-CRF-0646 V220110
		float strbillpayableamount=0;
		//String strCustCode="";
		String settmnt_ind="";
		String GHL_site_spec ="";
		boolean GHLsite=false;
		String ZatcaYN ="";//V221230
		boolean Zatca=false;//V221230
		String zatca_error_code="";//V221230
		String Zatca_msg="";//V221230
		
		try
		{
		GHLsite = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_SAVED");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(GHLsite){
		GHL_site_spec="Y";
		}
		else{
			GHL_site_spec="N";
		}
		
		//ends GHL-CRF-0646 V220110
		
		//V221230
		try
		{
			Zatca = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ZATCA");
			if(Zatca){
				ZatcaYN="Y";
			}else{
				ZatcaYN="N";
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//V221230
		String bill_gen_yn_leg = "";//bl_labels.getString("eBL.VISIT_BILL_GEN_AFTER_DISC.label");

		called_frm = request.getParameter("called_frm");	
		if(called_frm==null) called_frm="";	

		String called_butt = request.getParameter("called_butt");
		if(called_butt==null) called_butt="";	

		called_module_id = request.getParameter("module_id");	
		if(called_module_id==null) called_module_id="";	

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String str_patient_id = request.getParameter("patient_id");	
		if(str_patient_id==null) str_patient_id="";	
		
		String str_episode_type = request.getParameter("episode_type");	
		if(str_episode_type==null) str_episode_type="";	

		String str_episode_id = request.getParameter("episode_id");	
		if(str_episode_id==null) str_episode_id="";	

		String str_visit_id = request.getParameter("visit_id");	
		if(str_visit_id==null) str_visit_id="";		

		String p_function_id     =  request.getParameter("function_id");	
		if(p_function_id == null) p_function_id="";

		String p_module_id     =  request.getParameter("module_id");	
		if(p_module_id == null) p_module_id="";

		String p_clinic_code     =  request.getParameter("clinic_code");	
		if(p_clinic_code == null) p_clinic_code="";

		String p_visit_type_code     =  request.getParameter("visit_type_code");	
		if(p_visit_type_code == null) p_visit_type_code="";

		String p_encounter_id     =  request.getParameter("encounter_id");	
		if(p_encounter_id == null) p_encounter_id="";

		String p_blng_grp_id     =  request.getParameter("blnggrp");	
		if(p_blng_grp_id == null||p_blng_grp_id.trim().equalsIgnoreCase("[object]"))			
			p_blng_grp_id="";//p_blng_grp_id="2C";
			
		String p_act_gross_amt =  request.getParameter("act_gross_amt");	
		if(p_act_gross_amt == null) p_act_gross_amt="";

		String p_trx_ind =  request.getParameter("trx_ind");	
		if(p_trx_ind == null) p_trx_ind="1";

		String p_slmt_reqd_yn = request.getParameter("slmt_reqd_yn");	
		if(p_slmt_reqd_yn==null) p_slmt_reqd_yn="";		
		/***********Added for ghl-crf-1.2******************************/
		String called_for_reg_chg = request.getParameter("called_for_reg_chg");
		if(called_for_reg_chg == null) called_for_reg_chg="";

		//Added By Muthukumar on 30-1-12 for GAP -09
		String dep_adjust_yn  = request.getParameter("dep_adjust_yn");
//		if(dep_adjust_yn == null) dep_adjust_yn="";
		if(dep_adjust_yn == null || dep_adjust_yn.equals("null"))		dep_adjust_yn="N";
		//String str_deposit_exists_YN = "N";
		//Added By Muthukumar on 30-1-12 for GAP -09

		if(called_for_reg_chg.equals("pat_reg_chr") || p_module_id.equals("MP"))
		{			
			bill_gen_yn_leg = bl_labels.getString("eBL.REG_BILL_GEN_AFTER_DISC.label");
		}else{
			bill_gen_yn_leg =  bl_labels.getString("eBL.VISIT_BILL_GEN_AFTER_DISC.label");
		}

		if(called_for_reg_chg.equals("pat_reg_chr"))
		{
			p_module_id = "MP";
		}
		/***************end*********************************************/

		/**************Added for package biling*************starts********************/
		String package_enabled_yn = request.getParameter("package_enabled_yn");	
		if(package_enabled_yn==null) package_enabled_yn="";	
		String strpackageseqno = request.getParameter("strpackageseqno");	
		if(strpackageseqno==null) strpackageseqno="";
		String pkg_codes_for_disc = request.getParameter("pkg_codes_for_disc");	
		if(pkg_codes_for_disc==null) pkg_codes_for_disc="";
	/**************Added for package biling*************ends********************/
		String total_records = request.getParameter("total_records");
		if (total_records==null) total_records = "0";
//		int totalRecords = Integer.parseInt(total_records);	
		String checked_services = request.getParameter("checked_services");
		if (checked_services==null) checked_services = "";
		allow_chkout_with_bill_stmt_yn = request.getParameter("allow_chkout_with_bill_stmt_yn");
		if (allow_chkout_with_bill_stmt_yn==null) allow_chkout_with_bill_stmt_yn = "N";

		// Modified By DhanasekarV  on  05/3/2013  againt  PH ST   specific  BLRBLPRT			
		session.setAttribute("called_module_id",called_module_id);
		
		//Added below code for GST-GHL-CRF-0477
		String custId = BLReportIdMapper.getCustomerId();
		String gstApplicableYN = "N";
		String printOrientation = "P";
		try
		{
			pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
			rstMt = pstmtRpt.executeQuery();
			if(rstMt != null && rstMt.next()){
				gstApplicableYN = rstMt.getString("gst_applicable");
			}
			System.err.println("gstApplicableYN in AdhocSubmit:"+gstApplicableYN);
			if("Y".equals(gstApplicableYN)){
				/*	String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
												"FROM bl_parameters "+
												"WHERE operating_facility_id = ?";
					
				pstmtRpt = con.prepareStatement(printOrientationSql);
				pstmtRpt.setString(1, str_facility_id);
				rstMt = pstmtRpt.executeQuery();
					
				if(rstMt != null && rstMt.next()){
					printOrientation = rstMt.getString("default_bill_print_orientation");
				}
				*/
				//ADDED FOR KDAH-CRF-0546
				try
				{ 				
					cstmt = con.prepareCall("{ call BLCOMMON.get_report_id_for_3t (?,?,?,?) }");
					cstmt.setString(1,str_facility_id);
					cstmt.setString(2,str_episode_type);				
					cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					cstmt.execute();
					printOrientation = cstmt.getString(3);
					strBlrblprt = cstmt.getString(4);	
					System.err.println("printOrientation from get_report_id_for_3t:"+printOrientation);						
					System.err.println("strBlrblprt from get_report_id_for_3t:"+strBlrblprt);
				}
				catch(Exception e){
					printOrientation = "P";
					System.err.println("Exception in getting BLAdhocDiscSubmit.jsp, 1"+e);
					e.printStackTrace();
				}
				finally
				{
					try
					{
						if (cstmt !=null) cstmt.close();
					}
					catch(Exception ee1) 
					{
						System.err.println("Exception in getting BLAdhocDiscSubmit.jsp, 2"+ee1);
						ee1.printStackTrace();
					}
				}
			}
		}
		catch(Exception e){
			printOrientation = "P";
			System.err.println("Exception in getting printOrientation, 1"+e);
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rstMt != null)  rstMt.close();	
				if (pstmtRpt !=null) pstmtRpt.close();
			}
			catch(Exception ee1) 
			{
				System.err.println("Exception in getting printOrientation, 2"+ee1);
				ee1.printStackTrace();
			}
		}
		//Added below code for GST-GHL-CRF-0477
		/* Added V200116-MuthuN/GHL-CRF-0611/Starts */
		String printFormatSql = "SELECT NVL(PRINT_A5_FORMAT,'N') PRINT_A5_FORMAT FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+str_facility_id+"'";
		pstmtRpt = con.prepareStatement(printFormatSql);
		rstMt = pstmtRpt.executeQuery();
		String printFormat = "N";
		while(rstMt.next()) {
			printFormat = rstMt.getString("PRINT_A5_FORMAT");
		}
		pstmtRpt.close();
		rstMt.close();
		/* Added V200116-MuthuN/GHL-CRF-0611/Ends */
	
		/* V220711 Only if the client is MC, the below code should be executed. Otherwise the else part will override the strBlrblprt assigned from above logics. Hence moved the if else loop inside MC client condition */
		System.err.println("In AdhocSubmit.jsp strBlrblprt:"+strBlrblprt);
		if("MC".equalsIgnoreCase(custId)){//Added V200116-MuthuN/GHL-CRF-0611
			if("Y".equals(printFormat) && "P".equals(printOrientation) ) {
				strBlrblprt = "BLRBLPRT_GHL";
			} else {
				strBlrblprt  ="BLRBLPRT";
			}
		}
		System.err.println("In AdhocSubmit.jsp strBlrblprt1:"+strBlrblprt);
		
		if(called_module_id.equals("PH") || called_module_id.equals("ST"))
		{
		try
			{							
				String qryStmt="select report_id  from  bl_bill_reports where OPERATING_FACILITY_ID = '"+str_facility_id+"'  and bill_type='PH-BILL'";
					
					 pstmtRpt = con.prepareStatement(qryStmt);							
					  rstMt = pstmtRpt.executeQuery();
					 while (rstMt!=null && rstMt.next())
					{	
					strBlrblprt  =  rstMt.getString(1);
					}					
			}catch(Exception ee)
				{
					if("Y".equals(printFormat)) {//Added V200116-MuthuN/GHL-CRF-0611
						strBlrblprt = "BLRBLPRT_GHL";
					} else {
						strBlrblprt  ="BLRBLPRT";
					}
				}
			finally
			{
			try
			{
				  if(rstMt != null)  rstMt.close();	
				  if (pstmtRpt !=null) pstmtRpt.close();
			}catch(Exception ee1) {}							 

			}									 
			}
		//end
		// Added By Rajesh V - RUT-CRF0095
		//String custId = BLReportIdMapper.getCustomerId();
		//custId = "RUTNIN";
		if("RTN".equalsIgnoreCase(custId)){
			String billTypeId = BLReportIdMapper.getBillType ( str_episode_type, called_frm,called_module_id);
			strBlrblprt = BLReportIdMapper.getBlrBlPrtReportId(str_facility_id, billTypeId);
			if(strBlrblprt == null || "".equals(strBlrblprt)){
				if("Y".equals(printFormat)) {//Added V200116-MuthuN/GHL-CRF-0611
					strBlrblprt = "BLRBLPRT_GHL";
				} else {
					strBlrblprt  ="BLRBLPRT";
				}
			}			
		}
		// Added By Rajesh V - RUT-CRF0095
		
		//Added By Vijay For MMS-QF-CRF-208
		
		try{
			strBlrblprt=BLReportIdMapper.getReportId(con, locale,strBlrblprt,str_facility_id); //Added str_facility_id by subha for MMS-DM-CRF-131.1
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in BLAdhocDiscSubmit for reportID "+e);
		}		
		
		/*//Added below code for GST-GHL-CRF-0477
		String gstApplicableYN = "N";
		String printOrientation = "P";
		try{
			pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
			rstMt = pstmtRpt.executeQuery();
			if(rstMt != null && rstMt.next()){
				gstApplicableYN = rstMt.getString("gst_applicable");
			}
			
			if("Y".equals(gstApplicableYN)){
				String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
											"FROM bl_parameters "+
											"WHERE operating_facility_id = ?";
				
				pstmtRpt = con.prepareStatement(printOrientationSql);
				pstmtRpt.setString(1, str_facility_id);
				rstMt = pstmtRpt.executeQuery();
				
				if(rstMt != null && rstMt.next()){
					printOrientation = rstMt.getString("default_bill_print_orientation");
					System.err.println("322, BLAdhocDiscSubmit printOrientation==>"+printOrientation);
				}				
			}
		}
		catch(Exception e){
			printOrientation = "P";
			System.err.println("Exception in getting printOrientation"+e);
			e.printStackTrace();
		}
		finally{
			try
			{
				if(rstMt != null)  rstMt.close();	
				if (pstmtRpt !=null) pstmtRpt.close();
			}
			catch(Exception ee1) 
			{
				System.err.println("Exception in getting printOrientation"+ee1);
				ee1.printStackTrace();
			}
		}*/
		if(("L".equals(printOrientation)) && ("BLRBLPRT".equals(strBlrblprt) || "BLRBLPRT_PH".equals(strBlrblprt))){
			strBlrblprt = "BLRBLPRL";
		}
		//Added below code for GST-GHL-CRF-0477
		if(called_butt.equals("SUBMIT_BUTTON"))
		{
			String trx_doc_ref = request.getParameter("trx_doc_ref");
			if(trx_doc_ref.equals(" ") || trx_doc_ref==null) trx_doc_ref="";

			String trx_doc_ref_line_no = request.getParameter("trx_doc_ref_line_no");
			if(trx_doc_ref_line_no.equals(" ") || trx_doc_ref_line_no==null) trx_doc_ref_line_no="";

			String trx_doc_ref_seq_no = request.getParameter("trx_doc_ref_seq_no");
			if (trx_doc_ref_seq_no == null || trx_doc_ref_seq_no.equals("") || trx_doc_ref_seq_no.equals(" "))
				trx_doc_ref_seq_no = "0";
			int int_trx_doc_ref_seq_no = Integer.parseInt(trx_doc_ref_seq_no);
			
			//Added V200328-MuthuN/NMC-JD-CRF-050
			String adhoc_disc_amt="";
			//V201008  Starts
			/* Subtraction of Updated discount Amount with Original discount Amount and Add Adhoc Discount Amount
			if(preConfigDiscAmt.equals("Y")){
				String org_disc_amount=request.getParameter("org_disc_amt");
				if(org_disc_amount.equals(" ") || org_disc_amount==null || org_disc_amount.equals("")) org_disc_amount="0.00";
				float int_org_disc_amount = Float.parseFloat(org_disc_amount);

				String disc_amt = request.getParameter("disc_amt");				
				if(disc_amt.equals(" ") || disc_amt==null || disc_amt.equals("")) disc_amt="0.00";
				float int_disc_amt = Float.parseFloat(disc_amt);
				String added_adhoc_disc_amt = request.getParameter("adhoc_disc_amt");
				if(added_adhoc_disc_amt.equals(" ") || added_adhoc_disc_amt==null || added_adhoc_disc_amt.equals("")) added_adhoc_disc_amt="0.00";
				float int_added_adhoc_disc_amt = Float.parseFloat(added_adhoc_disc_amt);

				float adh_flt_amt = int_org_disc_amount+int_added_adhoc_disc_amt;
				float adh_flt_amt = ((int_disc_amt-int_org_disc_amount)+int_added_adhoc_disc_amt);
				float adh_flt_amt = int_added_adhoc_disc_amt;
				adhoc_disc_amt=request.getParameter("adhoc_disc_amt");
				if(adhoc_disc_amt.equals(" ") || adhoc_disc_amt==null) adhoc_disc_amt="";
			}else{
				adhoc_disc_amt = request.getParameter("adhoc_disc_amt");
				if(adhoc_disc_amt.equals(" ") || adhoc_disc_amt==null) adhoc_disc_amt="";
			}*/
			adhoc_disc_amt = request.getParameter("adhoc_disc_amt");
			if(adhoc_disc_amt.equals(" ") || adhoc_disc_amt==null) adhoc_disc_amt="";
			System.err.println("adhoc_disc_amt  "+adhoc_disc_amt);
			//V201008  Ends
			//Added V200328-MuthuN/NMC-JD-CRF-050

			String disc_reason_code = request.getParameter("disc_reason_code");
			if(disc_reason_code.equals(" ") || trx_doc_ref==null) disc_reason_code="";

			String adhoc_user_id = request.getParameter("adhoc_user_id");
			if(adhoc_user_id == null) adhoc_user_id="";

			String str_called_frm_frame = request.getParameter("called_frm_frame");
			if(str_called_frm_frame == null) str_called_frm_frame="";

			try
			{			
				if(str_called_frm_frame.equals("S"))
				{
					String sqladhocdisc="{ call   BLADDLCHG.Distribute_Discount_Trx_Grp('"+str_facility_id+"','"+p_trx_ind+"','"+trx_doc_ref+"',"+trx_doc_ref_line_no+",'"+str_episode_type+"','"+str_patient_id+"','"+str_episode_id+"','"+str_visit_id+"','"+adhoc_disc_amt+"','"+p_act_gross_amt+"','"+disc_reason_code+"','"+strloggeduser+"','"+adhoc_user_id+"','"+strclientip+"',?,?,?)}";

					call = con.prepareCall(sqladhocdisc);

					call.registerOutParameter(1,java.sql.Types.VARCHAR);
					call.registerOutParameter(2,java.sql.Types.VARCHAR);
					call.registerOutParameter(3,java.sql.Types.VARCHAR);

					call.execute();
					str_error_level=call.getString(1);
					str_sysmesage_id=call.getString(2);
					str_error_text=call.getString(3);

					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";

					if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
					{
						if((str_error_level.equals("10") && (!str_error_text.equals(""))))
						{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block7Bytes, _wl_block7);

							con.rollback();
							call.close();
						}
						if(!str_sysmesage_id.equals(""))
						{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(str_sysmesage_id));
            _bw.write(_wl_block9Bytes, _wl_block9);

							con.rollback();
							call.close();
						}
					}
				}
				else if(str_called_frm_frame.equals("P"))
				{
					String sqladhocdisc="{ call   BLADDLCHG.Finalize_Adhoc_disc_AMT('"+str_facility_id+"','"+trx_doc_ref+"','"+trx_doc_ref_line_no+"',"+int_trx_doc_ref_seq_no+",'"+str_patient_id+"','"+str_episode_type+"','"+str_episode_id+"','"+str_visit_id+"','"+adhoc_disc_amt+"','"+disc_reason_code+"','"+adhoc_user_id+"','"+strloggeduser+"','"+strclientip+"',?,?,?)}";

					call = con.prepareCall(sqladhocdisc);

					call.registerOutParameter(1,java.sql.Types.VARCHAR);
					call.registerOutParameter(2,java.sql.Types.VARCHAR);
					call.registerOutParameter(3,java.sql.Types.VARCHAR);

					call.execute();
					str_error_level=call.getString(1);
					str_sysmesage_id=call.getString(2);
					str_error_text=call.getString(3);

					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";

					if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
					{
						if((str_error_level.equals("10") && (!str_error_text.equals(""))))
						{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block7Bytes, _wl_block7);

							con.rollback();
							call.close();
						}
						if(!str_sysmesage_id.equals(""))
						{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(str_sysmesage_id));
            _bw.write(_wl_block9Bytes, _wl_block9);

							con.rollback();
							call.close();
						}
					}
				}
				out.println("<script>var retArray= '"+adhoc_user_id+"';retArray = retArray+'|"+disc_reason_code+"';parent.window.returnValue=retArray;parent.parent.document.getElementById('dialog_tag').close();</script>");
			}
			catch(Exception e)
			{
				System.err.println("Exception in qry :" +e);
				e.printStackTrace();
				con.rollback();
			}
		}
		else if(called_butt.equals("CLOSE_BUTTON"))
		{
			if(called_frm.equals("OTH_MOD"))
			{
				try
				{
					if(p_blng_grp_id.equals(""))
					{
						String sql1= " select blng_grp_id from bl_encounter_payer_priority where patient_id='"+str_patient_id+"' and ((episode_id='"+str_episode_id+"' and visit_id='"+str_visit_id+"' and '"+str_episode_type+"' != 'R') or '"+str_episode_type+"' = 'R') and episode_type='"+str_episode_type+"' and priority is null";
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql1);	
		
						while(rs.next())
						{
						   p_blng_grp_id  =  rs.getString(1);	
						}	
						rs.close();
						stmt.close();
					   if(p_blng_grp_id == null) p_blng_grp_id="";
					}
					if(called_module_id.equals("PH") || called_module_id.equals("ST"))
					{
						p_doc_no = request.getParameter("doc_no");
						if(p_doc_no == null) p_doc_no="";

						p_store_code = request.getParameter("store_code");
						if(p_store_code == null) p_store_code="";

						p_user = request.getParameter("user_id");
						if(p_user == null) p_user="";

						p_ws_no = request.getParameter("ws_no");
						if(p_ws_no == null) p_ws_no="";

						p_machine = request.getParameter("machine_id");
						if(p_machine == null) p_machine="";
						bl_items_sl_no = request.getParameter("bl_items_sl_no");
						if(bl_items_sl_no==null) bl_items_sl_no="";		
						
					//	call = con.prepareCall("{ call BL_STORE_BILL_GEN1.PROC_SEC_KEY_LINE('"+bl_items_sl_no.substring(0,bl_items_sl_no.length()-2)+"')}");
						call = con.prepareCall("{ call BL_STORE_BILL_GEN.PROC_SEC_KEY_LINE('"+bl_items_sl_no+"')}");
						call.execute();	
			//System.out.println("Calling PROC_STORE_BILL_GENERATION **** ");
			//call = con.prepareCall("{ call BL_STORE_BILL_GEN.PROC_STORE_BILL_GENERATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						call = con.prepareCall("{ call BL_STORE_BILL_GEN.PROC_STORE_BILL_GENERATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
//						System.err.println("str_facility_id:"+str_facility_id);
//						System.err.println("p_doc_no:"+p_doc_no);
//						System.err.println("called_module_id:"+called_module_id);
//						System.err.println("p_store_code:"+p_store_code);
//						System.err.println("p_user:"+p_user);
//						System.err.println("p_ws_no:"+p_ws_no);
//						System.err.println("p_machine:"+p_machine);

						call.setString(1,str_facility_id);
						call.setString(2,p_doc_no);
						call.setString(3,called_module_id);
						call.setString(4,p_store_code);
						call.setString(5,"N");
						call.setString(6,p_user);
						call.setString(7,p_ws_no);
						call.setString(8,p_machine);

						call.registerOutParameter(9,java.sql.Types.VARCHAR);	
						call.registerOutParameter(10,java.sql.Types.VARCHAR);	
						call.registerOutParameter(11,java.sql.Types.VARCHAR);	
						call.registerOutParameter(12,java.sql.Types.VARCHAR);	
						call.registerOutParameter(13,java.sql.Types.VARCHAR);	
						call.registerOutParameter(14,java.sql.Types.VARCHAR);	
						call.registerOutParameter(15,java.sql.Types.VARCHAR);	
						call.registerOutParameter(16,java.sql.Types.VARCHAR);	
						call.setString(17,dep_adjust_yn); //Added by muthu against 33216 on 07-06-12

						call.execute();		

						str_bill_doc_type = call.getString(9);		
						str_bill_doc_number = call.getString(10);	
						str_slmt_reqd_yn = call.getString(11);		
						
						if(str_slmt_reqd_yn == null || str_slmt_reqd_yn.equals("")) str_slmt_reqd_yn="N";
						if(str_bill_doc_type == null) str_bill_doc_type="";
						if(str_bill_doc_number == null) str_bill_doc_number="";
						
						str_sysmesage_id	= call.getString(14);		
						str_error_level	= call.getString(15);		
						str_error_text	= call.getString(16);		

						if(str_error_level == null) str_error_level="";
						if(str_error_text == null) str_error_text="";
						if(str_sysmesage_id == null) str_sysmesage_id="";

						call.close();	
					}
					else if(called_module_id.equals("OR"))
					{
						call = con.prepareCall("{ call OR_GET_BILL_DOC_TYPE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//V210413
						//call = con.prepareCall("{ call OR_GET_BILL_DOC_TYPE(?,?,?,?,?,?,?,?,?,?,?,?)}"); //V210413
						//call = con.prepareCall("{ call OR_GET_BILL_DOC_TYPE(?,?,?,?,?,?,?,?,?,?,?)}");
						call.setString(1,str_facility_id);
						call.setString(2,str_episode_type);
						call.setString(3,str_episode_id);
						call.setString(4,str_visit_id);
						call.setString(5,strloggeduser);
						call.setString(6,strclientip);
						call.setString(7,str_patient_id);
						call.registerOutParameter(8,java.sql.Types.VARCHAR);	
						call.registerOutParameter(9,java.sql.Types.VARCHAR);	
						call.registerOutParameter(10,java.sql.Types.VARCHAR);							
						call.registerOutParameter(11,java.sql.Types.VARCHAR);	
						call.setString(12,dep_adjust_yn);	//Added for  51249 issue on 1/10/2014
						call.registerOutParameter(13, java.sql.Types.VARCHAR); //V210315					
						call.registerOutParameter(14, java.sql.Types.VARCHAR); //V210315						
						call.execute();	
						
						str_bill_doc_type = call.getString(8);		
						str_bill_doc_number = call.getString(9);
						p_blng_grp_id = call.getString(10);
						str_slmt_reqd_yn = p_slmt_reqd_yn;
						str_sysmesage_id = call.getString(11);
						str_error_level = call.getString(13);//V210315
						str_error_text = call.getString(14);//V210315

						if (str_bill_doc_type == null)
							str_bill_doc_type = "";
						if (str_bill_doc_number == null)
							str_bill_doc_number = "";
						if (str_sysmesage_id == null)
							str_sysmesage_id = "";
						if (str_error_level == null)
							str_error_level = ""; //V210315		
						if (str_error_text == null)
							str_error_text = ""; //V210315

						call.close();
							//V210413 Start
						try {
							siteORZeroBillPrint = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "3T_OR_ZERO_ONLINE_BILL_PRINT");
						} catch (Exception e) {
							e.printStackTrace();
						}						
						System.err.println("called_module_id 727="+str_bill_doc_type+"/"+str_bill_doc_number+"/"+siteORZeroBillPrint);
						if (!str_bill_doc_type.equals("") && !str_bill_doc_number.equals("") ) {
							try{
								pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0),cust_code from bl_bill_hdr where operating_facility_id = '" + str_facility_id + "' and doc_type_code= '" + str_bill_doc_type + "' and doc_num = '" + str_bill_doc_number + "'");
								rs = pstmt.executeQuery();	
								if ( rs.next() && rs != null ) 
								{	
								strbillpayableamt =  rs.getString(1);
								strCustCode =  rs.getString(2);
								}
							}catch(Exception e) {   
								e.printStackTrace();							
								out.println(e.toString());	
							} finally {
								if (rs != null)   rs.close();
								if (pstmt != null) pstmt.close();		 	
							}
							double billpayableamt = 0;	
							if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";							
							billpayableamt = Double.parseDouble(strbillpayableamt);
							if(strCustCode == null || strCustCode.equals("")) strCustCode ="";
							System.err.println("billpayableamt="+billpayableamt+"/"+siteORZeroBillPrint);
							if ( (billpayableamt==0 ||  billpayableamt>0) && siteORZeroBillPrint) //Added by Nandhini M
							{
								System.err.println("billpayableamt 1="+billpayableamt+"/"+siteORZeroBillPrint);
								try {
									con.commit();
									System.err.println("str_facility_id="+str_facility_id+"/"+str_bill_doc_type+"/"+str_bill_doc_number+"/"+locale);
									call = con.prepareCall("{ call blopin.CALL_BILL_PRINT_FRM_SLMT_NEW(?,?,?,?,?,?)}");
									call.setString(1, str_facility_id);
									call.setString(2, str_bill_doc_type);
									call.setString(3, str_bill_doc_number);
									call.setString(4, locale);
									call.registerOutParameter(5, java.sql.Types.VARCHAR);
									call.registerOutParameter(6, java.sql.Types.VARCHAR);
									call.execute();									
									str_bill_prt_format_vals = call.getString(5);
									if (str_bill_prt_format_vals == null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals = "";
									str_error_text = call.getString(6);
									if (str_error_text == null) str_error_text = "";
								} catch (Exception e) {
									e.printStackTrace();
									System.err.println("Error in BLAdhocDiscSubmit.jsp while executing CALL_BILL_PRINT_FRM_SLMT_NEW:" + e);
								}finally{
								
								}
								
								try{				
									pstmt = con.prepareStatement( " SELECT NVL(BILL_PRINT_FORMAT_ENABLED_YN,'N'), NVL(PRT_PAYER_BILL_ZERO_YN,'N'),NVL(PRT_ZERO_GROSS_BILL_FRM_GEN,'N')  FROM BL_PARAMETERS WHERE operating_facility_id =  '"+str_facility_id+"'");									
									rs = pstmt.executeQuery();	
									if ( rs.next() && rs != null ) 
									{	
										str_bill_prt_format_YN =  rs.getString(1);
										str_prt_payer_bill_zero_yn =  rs.getString(2);
										str_prt_zero_gross_bill_frm_gen_yn =  rs.getString(3);
									}
								}catch(Exception e) {   
									e.printStackTrace();									
									out.println(e.toString());	
								}finally {
									if (rs != null)   rs.close();
									if (pstmt != null) pstmt.close();		 	
								}
								if ("Y".equals(str_bill_prt_format_YN) && !"".equals(str_bill_prt_format_vals)) {
									if (!"".equals(strCustCode) && "Y".equals(str_prt_payer_bill_zero_yn)){										
										str_bill_print_format_flag = "Y";
										orZeroBill="Y";
									} else if ("".equals(strCustCode) && "Y".equals(str_prt_zero_gross_bill_frm_gen_yn)) {
										str_bill_print_format_flag = "Y";
										orZeroBill="Y";
									} else {
												str_bill_print_format_flag = "N";
									}
								} else {
									str_bill_print_format_flag = "N";
								}								
							}				
						}
					//}					
					//V210413 End
					}else {
						call = con.prepareCall(
								"{ call BLVISITCHARGE.PROC_GENERATE_BILL_SEPERATELY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

						call.setString(1, p_function_id);
						call.setString(2, str_facility_id);
						call.setString(3, p_module_id);
						call.setString(4, p_clinic_code);
						call.setString(5, p_visit_type_code);
						call.setString(6, str_patient_id);
						call.setString(7, str_episode_type);
						call.setString(8, p_encounter_id);
						call.setString(9, str_episode_id);
						call.setString(10, str_visit_id);
						call.setString(11, p_blng_grp_id);
						call.setString(12, strloggeduser);
						call.setString(13, strclientip);
						call.setString(14, locale);
						call.registerOutParameter(15, java.sql.Types.VARCHAR);
						call.registerOutParameter(16, java.sql.Types.VARCHAR);
						call.registerOutParameter(17, java.sql.Types.VARCHAR);
						call.registerOutParameter(18, java.sql.Types.VARCHAR);
						call.registerOutParameter(19, java.sql.Types.VARCHAR);
						call.registerOutParameter(20, java.sql.Types.VARCHAR);
						call.registerOutParameter(21, java.sql.Types.VARCHAR);
						call.registerOutParameter(22, java.sql.Types.VARCHAR);

						/*Added By Muthukumar on 30-1-12 for GAP -09*/
						call.setString(23, dep_adjust_yn);
						/*Added By Muthukumar on 30-1-12 for GAP -09*/
						call.execute();
						str_bill_gen_yn = call.getString(15);
						str_bill_doc_type = call.getString(16);
						str_bill_doc_number = call.getString(17);
						System.err.println("str_bill_gen_yn:"+str_bill_gen_yn);
						System.err.println("str_bill_doc_type:"+str_bill_doc_type);
						System.err.println("str_bill_doc_number:"+str_bill_doc_number);
						if (str_bill_gen_yn == null)
							str_bill_gen_yn = "";
						if (str_bill_doc_type == null)
							str_bill_doc_type = "";
						if (str_bill_doc_number == null)
							str_bill_doc_number = "";

						str_bill_prt_format_YN = call.getString(18);
						str_bill_prt_format_vals = call.getString(19);
						str_error_level = call.getString(20);
						str_sysmesage_id = call.getString(21);
						str_error_text = call.getString(22);

						if (str_error_level == null)
							str_error_level = "";
						if (str_error_text == null)
							str_error_text = "";
						if (str_sysmesage_id == null)
							str_sysmesage_id = "";
						call.close();
					}

					if ((!str_error_level.equals("") && !str_error_text.equals(""))
							|| !str_sysmesage_id.equals("")) {
						if (!str_error_level.equals("") && !str_error_text.equals("")) {
							con.rollback();
							out.println("<script>alert('" + str_error_text + "');</script>");
							error_flag = "Y";
						}

						if (!str_sysmesage_id.equals("")) {
							con.rollback();
							out.println("<script>alert(getMessage('" + str_sysmesage_id + "','BL'));</script>");
							error_flag = "Y";
						}
					} else {
						error_flag = "N";
						strbilldoctypecode = str_bill_doc_type;
						strbilldocnum = str_bill_doc_number;
						//KDAH-CRF-0318
						String billLevelTax = "N";
						String addlChargeAmt = "";
						PreparedStatement psBill = null;
						ResultSet rsBill = null;
						psBill = con.prepareStatement(
								"Select NVL(Bill_level_tax_yn,'N') Bill_level_tax_yn from bl_parameters ");
						rsBill = psBill.executeQuery();
						if (rsBill != null && rsBill.next()) {
							billLevelTax = rsBill.getString("Bill_level_tax_yn");
						}
						//GHL-CRF-0646
						
						try{
								pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0),a.cust_code,b.SETTLEMENT_IND  from bl_bill_hdr a , bl_blng_grp b where a.operating_facility_id = '" + str_facility_id + "' and doc_type_code= '" + str_bill_doc_type + "' and doc_num = '" + str_bill_doc_number + "' and a.blng_grp_id =b.blng_grp_id ");
								
								
								rs = pstmt.executeQuery();	
								if ( rs.next() && rs != null ) 
								{	
								strbillpayableamount =  rs.getFloat(1);
								strCustCode =  rs.getString(2);
								settmnt_ind = rs.getString(3);	
								//System.err.println("836,adhoc,settmnt_ind==>"+settmnt_ind);
								}
							}catch(Exception e) {   
								e.printStackTrace();							
								out.println(e.toString());	
							} finally {
								if (rs != null)   rs.close();
								if (pstmt != null) pstmt.close();		 	
							}
							//ends
						
						if("Y".equals(billLevelTax)){
							psBill = con.prepareStatement("Select base_currency from sm_acc_entity_param");
							rsBill = psBill.executeQuery();
							if (rsBill != null) {
								while (rsBill.next()) {
									baseCurrency = rsBill.getString("base_currency");
								}
							}
							psBill = con.prepareStatement(
									"Select addl_charge_amt from bl_bill_hdr where doc_type_code = ? and doc_num = ? ");
							psBill.setString(1, strbilldoctypecode);
							psBill.setString(2, strbilldocnum);
							rsBill = psBill.executeQuery();
							if (rsBill != null && rsBill.next()) {
								addlChargeAmt = rsBill.getString("addl_charge_amt");
							}
							if (addlChargeAmt == null || "null".equals(addlChargeAmt)) {
								addlChargeAmt = "";
							}
						}

						if (rsBill != null) {
							rsBill.close();
						}
						if (psBill != null) {
							psBill.close();
						}

						if ("".equals(addlChargeAmt)) {
							strFinalMessage = bill_gen_yn_leg + strbilldoctypecode + "/" + strbilldocnum;
						} else {
							strFinalMessage = bill_gen_yn_leg + strbilldoctypecode + "/" + strbilldocnum
									+ " - Bill Level Tax : " + baseCurrency + " " + addlChargeAmt;
						}
						//KDAH-CRF-0318
						System.out.println("Bill Doc Number 793  "+strbilldocnum);
						System.out.println("Bill Doc Type Code  794 "+strbilldoctypecode);
						
		//V210407 Starts
						String QRCodeFlag="";
                if ((boolean)CommonBean.isSiteSpecific(con, "BL", "BL_QRCODE_IN_BILL")) {
                	QRCodeFlag = "Y";
                }
                else {
                	QRCodeFlag = "N";
                }
                //Function Flag
                String All_Bills="";
                String GST_Bills="";
                String OPYN="";
                String IPYN="";
                String EMYN="";
                String DCYN="";
                String EXYN="";
                String funcFlag="";
        			String funcFlagQuery=" SELECT QRCODEALLBILLS, QRCODEGSTBILLS, NVL(QRCODEOPYN,'N') QRCODEOPYN, NVL(QRCODEIPYN,'N') QRCODEIPYN, NVL(QRCODEEMYN,'N') QRCODEEMYN, NVL(QRCODEDCYN,'N') QRCODEDCYN, NVL(QRCODEEXYN,'N') QRCODEEXYN FROM bl_parameters where OPERATING_FACILITY_ID='"+str_facility_id+"'";
					System.err.println("funcFlagQuery  "+funcFlagQuery);
        			stmt = con.createStatement();
        			rs = stmt.executeQuery(funcFlagQuery) ;
        			if( rs != null ) 
        			{
        			while( rs.next() )
        			{  
        				All_Bills  =  rs.getString("QRCODEALLBILLS");
        				GST_Bills  =  rs.getString("QRCODEGSTBILLS");
        				OPYN  =  rs.getString("QRCODEOPYN");
        				IPYN  =  rs.getString("QRCODEIPYN");
        				EMYN  =  rs.getString("QRCODEEMYN");
        				DCYN  =  rs.getString("QRCODEDCYN");
        				EXYN  =  rs.getString("QRCODEEXYN");
        				System.err.println("All_Bills  "+All_Bills);
        				System.err.println("GST_Bills  "+GST_Bills);
        				System.err.println("OPYN  "+OPYN);
        				System.err.println("IPYN  "+IPYN);
        				System.err.println("EMYN  "+EMYN);
        				System.err.println("DCYN  "+DCYN);
        				System.err.println("EXYN  "+EXYN);
        			}
        			}
        		stmt.close();
        		if(rs!=null) rs.close();
        		if(str_episode_type.equals("O") && OPYN.equals("Y")){
        			funcFlag="Y";
        		}else if(str_episode_type.equals("E") && EMYN.equals("Y")){
        			funcFlag="Y";
        		}else if(str_episode_type.equals("R") && EXYN.equals("Y")){
        			funcFlag="Y";
        		}else if(str_episode_type.equals("I") && IPYN.equals("Y")){
        			funcFlag="Y";
        		}else if(str_episode_type.equals("D") && DCYN.equals("Y")){
        			funcFlag="Y";
        		}
        		
                if ("Y".equals(QRCodeFlag) && funcFlag.equals("Y")) {
                    try {
                        if (p_encounter_id != null) {
                        	System.err.println("Calling QRCodeGeneration "+str_patient_id+" "+strloggeduser+" "+str_episode_type+" "+str_facility_id+" "+str_episode_id+" "+str_visit_id+" "+request.getParameter("machine_id"));
                			String QR_Code_Val="";
                			String errCode="";
                			String MPIID="";
                			if(!strbilldoctypecode.equals("") && !strbilldocnum.equals(""))
        					{
        						String MpiIdQuery="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+str_facility_id+"' and DOC_TYPE_CODE='"+strbilldoctypecode+"' and DOC_NUM='"+strbilldocnum+"'";
								System.err.println("MpiIdQuery  "+MpiIdQuery);
        						stmt = con.createStatement();
        						rs = stmt.executeQuery(MpiIdQuery) ;
        						if( rs != null ) 
        						{
        							while( rs.next() )
        							{  
        								MPIID  =  rs.getString(1);	
        								System.err.println("MPIID  "+MPIID);
        							}
        						}
        						stmt.close();
        						if(rs!=null) rs.close();
        						String docNumCodeQuery="";
        						if(str_episode_type.equals("R")){
        							str_episode_id="0";
        							str_visit_id="0";
        							docNumCodeQuery="SELECT doc_type_code, doc_num "+
			                     			"FROM bl_bill_hdr "+
			                   				"WHERE  operating_facility_id ='"+str_facility_id+"' "+
			                          		"AND mpi_id ='"+MPIID+"' "+
			                          		"AND patient_id = '"+str_patient_id+"' " +
			                          		"AND EPISODE_TYPE  = '"+str_episode_type+"' "+ 
			                                "and (('"+GST_Bills+"' = 'Y' AND  ADDL_CHARGE_AMT <> 0) "+ 
			                                "OR '"+GST_Bills+"' = 'N')";
        						}
        						else if(str_episode_type.equals("O") || str_episode_type.equals("E")){
        							docNumCodeQuery="SELECT doc_type_code, doc_num "+
        			                     			"FROM bl_bill_hdr "+
        			                   				"WHERE  operating_facility_id ='"+str_facility_id+"' "+
        			                          		"AND mpi_id ='"+MPIID+"' "+
        			                          		"AND patient_id = '"+str_patient_id+"' "+
        			                         		"AND episode_id = '"+str_episode_id+"' "+
        			                          		"AND visit_id = '"+str_visit_id+"' " +
        					                        "AND EPISODE_TYPE  = '"+str_episode_type+"' "+ 
        					                        "and (('"+GST_Bills+"' = 'Y' AND  ADDL_CHARGE_AMT <> 0) "+ 
        					                        "OR '"+GST_Bills+"' = 'N')";
        						}else if(str_episode_type.equals("I") || str_episode_type.equals("D")){
        							docNumCodeQuery="SELECT doc_type_code, doc_num "+
			                     			"FROM bl_bill_hdr "+
			                   				"WHERE  operating_facility_id ='"+str_facility_id+"' "+
			                          		"AND mpi_id ='"+MPIID+"' "+
			                          		"AND patient_id = '"+str_patient_id+"' "+
			                         		"AND episode_id = '"+str_episode_id+"' "+
					                        "AND EPISODE_TYPE  = '"+str_episode_type+"' "+ 
					                        "and (('"+GST_Bills+"' = 'Y' AND  ADDL_CHARGE_AMT <> 0) "+ 
					                        "OR '"+GST_Bills+"' = 'N')";
        						}
        						System.err.println("docNumCodeQuery  "+docNumCodeQuery);
        						stmt = con.createStatement();
        						rs = stmt.executeQuery(docNumCodeQuery) ;
        						if( rs != null ) 
        						{
        							while( rs.next() )
        							{  
                						System.err.println("doc_type_code  "+rs.getString("doc_type_code"));
                						System.err.println("doc_num  "+rs.getString("doc_num"));
        	                			call = con.prepareCall("{ call IBAEHIS.bl_qr_code_generation(?,?,?,?,?,?,?,?,?)}");	
        	    						call.setString(1,str_facility_id);
        	    						call.setString(2,str_patient_id);
        	    						call.setInt(3,Integer.parseInt(str_episode_id));
        	    						call.setString(4,str_episode_type);
        	    						call.setInt(5,Integer.parseInt(str_visit_id));
        	    						call.setString(6,rs.getString("doc_type_code"));
        	    						call.setInt(7,Integer.parseInt(rs.getString("doc_num")));
        	    						call.registerOutParameter(8,java.sql.Types.VARCHAR);	
        	    						call.registerOutParameter(9,java.sql.Types.VARCHAR);
        	    						call.execute();	
        	    						QR_Code_Val	= call.getString(8);
        	    						errCode	= call.getString(9);		

        	    						if(QR_Code_Val == null) QR_Code_Val="";
        	    						if(errCode == null) errCode="";
        	    						System.err.println("QR_Code_Val  "+QR_Code_Val);
        	    						System.err.println("errCode  "+errCode);
        	    						call.close();	
        	    						if(errCode.equals("") && !QR_Code_Val.equals("")){
        	    							HashMap<String,String> valuesToGen = new HashMap<String,String>();
        	                    			valuesToGen.put("patId", str_patient_id);
        	                    			valuesToGen.put("logInId", strloggeduser);
        	                    			valuesToGen.put("episodeType", str_episode_type);
        	                    			valuesToGen.put("facility_id", str_facility_id);
        	                    			valuesToGen.put("episode_id", str_episode_id);
        	                    			valuesToGen.put("visitId", str_visit_id);
        	                    			valuesToGen.put("WsNo", request.getParameter("machine_id"));
        	                    			valuesToGen.put("docNum", rs.getString("doc_num"));
        	                    			valuesToGen.put("docTypeCode", rs.getString("doc_type_code"));
        	                				valuesToGen.put("qrCode", QR_Code_Val);
        	                				QRCodeGenerator.generateQRCodeImage(350, 350,valuesToGen);
        	    						}else if(!errCode.equals("")){
        	    							//con.rollback();
        									out.println("<script>alert('"+errCode+"');</script>");
        	    						}
        							}
        						}
        						stmt.close();
        						if(rs!=null) rs.close();
        						
        					}
                        }
                    }
                    catch (Exception ex4) {
                        ex4.printStackTrace();
                    }
                }
				
				//V221230 Zatca
				System.err.println("strbilldoctypecode 1173 adhocsubmit.jsp "+strbilldoctypecode);
				System.err.println("strbilldocnum "+strbilldocnum);
				System.err.println("str_facility_id "+str_facility_id);
				System.err.println("ZatcaYN "+ZatcaYN);
				if(ZatcaYN.equals("Y")){
					String mpiId="";
					if(!strbilldoctypecode.equals("") && !strbilldocnum.equals(""))
					{
						String qry_mpi_id="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+str_facility_id+"' and DOC_TYPE_CODE='"+strbilldoctypecode+"' and DOC_NUM='"+strbilldocnum+"'";
						stmt = con.createStatement();
						rs = stmt.executeQuery(qry_mpi_id) ;
						if( rs != null ) 
						{
							while( rs.next() )
							{  
								mpiId  =  rs.getString(1);	
							
							}
						}
						stmt.close();
						if(rs!=null) rs.close();
						
						try{
							cstmt= con.prepareCall("{ call bl_zatca_qr_request_check(?,?,?)}");
							cstmt.setString( 1,	mpiId );
							System.err.println("adhoc,bl_zatca_qr_request_check mpiId===>"+mpiId);
							cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
							cstmt.execute();
							zatca_error_code=cstmt.getString(2);
							Zatca_msg=cstmt.getString(3);
							if(zatca_error_code==null) zatca_error_code="";
							if(Zatca_msg==null) Zatca_msg="";
							System.err.println("adhoc,bl_zatca_qr_request_check zatca_error_code===>"+zatca_error_code);
							System.err.println("bl_zatca_qr_request_check process_msg===>"+Zatca_msg);
							 
							
							cstmt = con.prepareCall("call BL_ZATCA_UPDATE_ORG_BILL_NUM(?,?)");//V220517
							cstmt.setString( 1,	mpiId );
							cstmt.setString( 2,	strbilldoctypecode+"/"+strbilldocnum );
							cstmt.execute();
							
							
						}catch(Exception ex){
							ex.printStackTrace();
						}finally{
							if(cstmt!=null) cstmt.close();
						}
					}
				}
				//bl_zatca_qr_request_check
				//V221230
				
						//V210407 Ends
						//if(str_bill_prt_format_YN.equals("Y") && !str_bill_prt_format_vals.equals(""))
						if("Y".equals(str_bill_prt_format_YN) && !"".equals(str_bill_prt_format_vals))
						{
							str_bill_print_format_flag = "Y";							
						}
						else
						{
							str_bill_print_format_flag = "N";
						}
					}

/********************************Added for package billing*************************************starts*****/

	if(!(called_module_id.equals("PH") || called_module_id.equals("ST") || called_module_id.equals("OR")))
			{		
				if(package_enabled_yn.equals("Y"))
				{
					StringTokenizer st; 
					String str_pack_seq_token="";
					//String mpi_id="";
					StringTokenizer st1_disc; 
					String str_pack_code_token1="";

					StringTokenizer st_disc; 
					String str_pack_seq_token_disc="";
					String mpi_id1="";
					if(!strbilldoctypecode.equals("") && !strbilldocnum.equals(""))
					{
						String qry_mpi_id="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+str_facility_id+"' and DOC_TYPE_CODE='"+strbilldoctypecode+"' and DOC_NUM='"+strbilldocnum+"'";
						stmt = con.createStatement();
						rs = stmt.executeQuery(qry_mpi_id) ;
						if( rs != null ) 
						{
							while( rs.next() )
							{  
								mpi_id1  =  rs.getString(1);	
							}
						}
						stmt.close();
						if(rs!=null) rs.close();
					}
				try{
					if(!pkg_codes_for_disc.equals(""))
					{	
						CallableStatement  cstmt_d = con.prepareCall("{ call    blpackage.calc_package_bill_discount(?,?,?,?,?,?,?,?,?,?)}");
						CallableStatement  cstmt_d1 = con.prepareCall("{ call    blpackage.proc_updt_bill_for_disc(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						st1_disc=new StringTokenizer(pkg_codes_for_disc,"|");
						while(st1_disc.hasMoreTokens())
						{
							str_pack_code_token1 = st1_disc.nextToken();	
							st_disc=new StringTokenizer(strpackageseqno,"|");
							while(st_disc.hasMoreTokens())
							{
								str_pack_seq_token_disc = st_disc.nextToken();
								cstmt_d.setString(1,str_facility_id);
								cstmt_d.setString(2,str_pack_code_token1);
								cstmt_d.setString(3,str_pack_seq_token_disc);
								cstmt_d.setString(4,str_patient_id);
								cstmt_d.setString(5,"O");
								cstmt_d.setString(6,str_episode_id);
								cstmt_d.setString(7,str_visit_id);	
								cstmt_d.setString(8,p_blng_grp_id);
								cstmt_d.setString(9,strloggeduser);		
								cstmt_d.setString(10,strclientip);		
								cstmt_d.execute();	
								
								/* Added by Aravindh/26-04-2018/Starts */
								String chargeLogicSql = "select NVL(charge_logic_yn,'N') charge_logic_yn from bl_parameters where OPERATING_FACILITY_ID = '"+str_facility_id+"' ";
								String chargeLogicVal = "";
								
								stmt = con.createStatement();
								rs = stmt.executeQuery(chargeLogicSql) ;
								if( rs != null ) 
								{
									while( rs.next() )
									{  
										chargeLogicVal  =  rs.getString(1);	
									}
								}
								stmt.close();
								if(rs!=null) rs.close();
								/* Added by Aravindh/26-04-2018/Ends */
								
								/* Added by Aravindh/26-04-2018/if condition */
								if(null != chargeLogicVal && !"Y".equalsIgnoreCase(chargeLogicVal.trim())) {
									cstmt_d1.setString(1,mpi_id1);
									cstmt_d1.setString(2,strbilldoctypecode); //from bill doctype
									cstmt_d1.setString(3,null);		//to bill doctype	
									cstmt_d1.setString(4,strbilldocnum); //from bill billnum
									cstmt_d1.setString(5,null);		//to bill billnum
									cstmt_d1.setString(6,str_pack_seq_token_disc);////Added V180123-Aravindh/AMRI-SCF-0482 str_pack_seq_token has no value assignments so the variable replaced to str_pack_seq_token_disc
									cstmt_d1.setString(7,str_facility_id);
									cstmt_d1.setString(8,str_patient_id);
									cstmt_d1.setString(9,str_episode_id);
									cstmt_d1.setString(10,"O");
									cstmt_d1.setString(11,str_visit_id);		
									cstmt_d1.setString(12,strloggeduser);		
									cstmt_d1.setString(13,strclientip);
									cstmt_d1.execute();	
								}								
							}
						}
						if (cstmt_d!=null)   cstmt_d.close();
						if (cstmt_d1!=null)   cstmt_d1.close();						
					}						
					}catch(Exception e1)
					{
						System.out.println("Exception proc_updt_bill_for_disc :"+e1);
						e1.printStackTrace();
					}	
					if(!strpackageseqno.equals(""))
					{
						try{
							st=new StringTokenizer(strpackageseqno,"|");
							while(st.hasMoreTokens())
							{
								str_pack_seq_token = st.nextToken();								
								String upd_stmt="update bl_package_sub_hdr set BILL_DOC_TYPE_CODE='"+strbilldoctypecode+"'  ,BILL_DOC_NUM="+Double.parseDouble(strbilldocnum)+",MPI_ID='"+mpi_id1+"' where  OPERATING_FACILITY_ID='"+str_facility_id+"' and  PACKAGE_SEQ_NO='"+str_pack_seq_token+"'";

							 pstmt1 = con.prepareStatement(upd_stmt);//V220517
							int res_upd = pstmt1.executeUpdate();
							if (res_upd != 0) {
								error_flag = "N";								
							}
							else{
								error_flag = "Y";								
								break;
							}
							pstmt1.close();//V220517
							String upd_stmt1="update BL_BILL_HDR set PACKAGE_CMP_YN='Y' where MPI_ID='"+mpi_id1+"' AND OPERATING_FACILITY_ID='"+str_facility_id+"' ";				
							PreparedStatement pstmt2 = con.prepareStatement(upd_stmt1);
							int res_upd1 = pstmt2.executeUpdate();

							if (res_upd1 != 0) {
								error_flag = "N";								
							}
							else{
								error_flag = "Y";								
							break;
						}
						pstmt2.close();//V220517
					}
					}catch(Exception e1)
					{
						System.out.println("Exception updation :"+e1);
						e1.printStackTrace();
					}
					}							
					if(strbilldoctypecode.equals("") && strbilldocnum.equals(""))
					{
						StringTokenizer st1; 
						String str_pack_seq_token1="";
						if(!strpackageseqno.equals(""))
						{
							st1=new StringTokenizer(strpackageseqno,"|");
							call = con.prepareCall("{ call   blpackage.cancel_ordcatalog_variance (?,?,?,?,?,?,?,?,?,?,?)}");	
							while(st1.hasMoreTokens())
							{
							  try{
								str_pack_seq_token1 = st1.nextToken();
								call.setString(1,str_facility_id);
								call.setString(2,str_patient_id);
								call.setString(3,str_episode_id);
								call.setString(4,str_episode_type);
								call.setString(5,str_visit_id);
								call.setString(6,str_pack_seq_token1);
								call.setString(7,strclientip);
								call.setString(8,strloggeduser);
								call.registerOutParameter(9,java.sql.Types.VARCHAR);
								call.registerOutParameter(10,java.sql.Types.VARCHAR);
								call.registerOutParameter(11,java.sql.Types.VARCHAR);	
								call.execute();
								str_error_level	= call.getString(9);		
								str_sysmesage_id	= call.getString(10);		
								str_error_text	= call.getString(11);
							
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";									
								if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sysmesage_id.equals(""))
								{
									if(!str_error_level.equals("") && !str_error_text.equals(""))
									{
										con.rollback();
										out.println("<script>alert('"+str_error_text+"');</script>");
										error_flag = "Y";
										break;
									}

									if(!str_sysmesage_id.equals(""))
									{
										con.rollback();
										out.println("<script>alert(getMessage('"+str_sysmesage_id+"','BL'));</script>");
										error_flag = "Y";
										break;
									}
								}
								}catch(Exception ee)
								{
									System.err.println("error in cancel_ordcatalog_variance str_pack_seq_token:" +str_pack_seq_token1);
									System.err.println("error in cancel_ordcatalog_variance:" +ee);								
									ee.printStackTrace();
									con.rollback();
									error_flag = "Y";
									break;
								}
							}//while							
							call.close();
						} //if seq no
					} //if bill doc type
				}
			}
/*************************package billing********************************ends*******/
				}catch(Exception e)
				{
					error_flag = "N";
					con.rollback();
					System.err.println("Exception while calling BLVISITCHARGE.PROC_GENERATE_BILL_SEPERATELY:"+e);
				}
				//646
				if ("Y".equals(GHL_site_spec)){
					locale=(String)session.getAttribute("LOCALE");
								//System.err.println("1292,locale-->"+locale);

								if ( reportServer		== null ) reportServer	= "";
								if ( userid			== null ) userid		= "";
								//if ( params 		== null ) params 		= "";
								if ( self_submit		== null ) self_submit	= "";

								if ( module_id		== null ) module_id 	= "";
								if ( report_id		== null ) report_id 	= "";
								if ( dest_locn_type 	== null ) dest_locn_type= "";
								if ( dest_locn_code	== null ) dest_locn_code= "";
								if ( facility_id		== null ) facility_id	= "";
								if ( ws_no			== null ) ws_no		= "";
								if ( report_option	== null ) report_option = "F";

								Connection conn=null;
								try{
									//System.err.println("inside try---->>");
									 conn = ConnectionManager.getConnection(request);
									 cs = conn.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" );
									 //System.err.println("111111111");
									cs.setString( 1,	"BL" );
									cs.setString( 2,	strBlrblprt );
									cs.setString( 3,	dest_locn_type );
									cs.setString( 4,	dest_locn_code );
									cs.setString( 5,	facility_id );
									cs.setString( 6,	ws_no );
									cs.setString( 7,	report_option );
									System.err.println("adhoc,report_option===>"+report_option);
									cs.registerOutParameter( 8,  Types.VARCHAR );
									cs.registerOutParameter( 9,  Types.VARCHAR );
									cs.registerOutParameter( 10, Types.VARCHAR );
									cs.registerOutParameter( 11, Types.VARCHAR );
									cs.registerOutParameter( 12, Types.VARCHAR );
									cs.registerOutParameter( 13, Types.VARCHAR );
									cs.registerOutParameter( 14, Types.VARCHAR );
									cs.registerOutParameter( 15, Types.VARCHAR );
									cs.registerOutParameter( 16, Types.VARCHAR );
									cs.registerOutParameter( 17, Types.VARCHAR );
									cs.execute() ;
									report	= cs.getString( 8 );
									server	= cs.getString( 9 );
									copies	= cs.getString( 10 );
									if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
									queue_name	= cs.getString( 12 );
									message	= cs.getString( 15 );
									if (message==null) message="";
									app_server_ip = cs.getString( 16 );
									rep_server_key= cs.getString( 17 );
									if (rep_server_key==null) rep_server_key="";

									reportServer = "http://" + app_server_ip + reportServer;
									System.err.println("adhoc,256,report==>"+report);
									System.err.println("adhoc,257,server==>"+server);
									if(cs !=null)cs.close();

								String sql1="select USER_ID,app_password.decrypt(password),REPORT_SERVER,REPORT_CONNECT_STRING  from sm_db_info";

								pstmt1=con.prepareStatement(sql1);
								rs1=pstmt1.executeQuery();
								while(rs1.next())
								{
									jdbc_username	=rs1.getString(1);
									jdbc_password	=rs1.getString(2);
									report_server =rs1.getString(3);
									reoprt_connect_string =rs1.getString(4);
								}
								user_id = jdbc_username+"/"+jdbc_password+"@"+reoprt_connect_string;

								}

								catch(Exception e){
									out.println(e);
									e.printStackTrace();
									}

								finally {
								//ConnectionManager.returnConnection(conn,request);
								}

								//out.println( "<script language=\"JavaScript\">test()</script>" ) ;
								
						call = con.prepareCall("{ call proc_billprintsaved (?,?,?,?,?,?,?)}");
							call.setString(1, str_facility_id); //V210211
							call.setString(2,strbilldoctypecode);
							System.err.println("1233,strbilldoctypecode-->"+strbilldoctypecode);
							call.setString(3,strbilldocnum);
							System.err.println("1235,strbilldocnum-->"+strbilldocnum);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.execute();
							result	 = call.getString(4);
							System.err.println("adhoc,1244,result---->"+result);
							fileName  	     = call.getString(5);
							System.err.println("adhoc,1246,fileName---->"+fileName);
							path=call.getString(6);
							System.err.println("adhoc,1248,path---->"+path);
							view=call.getString(7);
							System.err.println("adhoc,1296,view---->"+view);
				}
				if(str_bill_print_format_flag.equals("Y"))
				{
					try
					{
						con.commit();						
						/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call - Starts*/
						int docNum = 0;
						if("Y".equals(Slysite_spec)){
							try{
							pstmt = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
							docNum = Integer.parseInt(str_bill_doc_number);
							pstmt.setString(1,str_facility_id);							
							pstmt.setString (2,str_bill_doc_type);
							pstmt.setInt(3,docNum);
							  rs = pstmt.executeQuery();
							 if(rs != null && rs.next()){
								 bill_print_reqd = rs.getString(1);
							   }
							 if("Y".equals(bill_print_reqd)) {
								asyncPrinterAttrib = new HashMap<String,String>();
								asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
								System.err.println("1008, asyncPrinterAttrib 1st Place==>"+asyncPrinterAttrib);
								session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
								out.println("<script>callAsyncOnlinePrint();</script>");
							}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						//added against GHL-CRF-0646 V220110

						else if ("Y".equals(GHL_site_spec)){
							// GHL-CRF-0646 changes, if view is enabled then direct printing has to be disabled
							if("N".equals(view)){
							/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
							asyncPrinterAttrib = new HashMap<String, String>();
							asyncPrinterAttrib.put(str_bill_prt_format_vals + "/" + (blprintVal++),
									strBlrblprt);
							//{PAT_REG/14343726/210415205233887562//0=BLRBLPRT}
							System.err.println("1021, asyncPrinterAttrib Submit.jsp==>" + asyncPrinterAttrib);
							session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
							out.println("<script>callAsyncOnlinePrint();</script>");
							
						}
						}
							/*call = con.prepareCall("{ call proc_billprintsaved (?,?,?,?,?,?,?)}");
							call.setString(1, str_facility_id); //V210211
							System.err.println("1201,str_facility_id-->"+str_facility_id);
							call.setString(2,strbilldoctypecode);
							System.err.println("1233,strbilldoctypecode-->"+strbilldoctypecode);
							call.setString(3,strbilldocnum);
							System.err.println("1235,strbilldocnum-->"+strbilldocnum);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.execute();
							result	 = call.getString(4);
							System.err.println("1244,result---->"+result);
							fileName  	     = call.getString(5);
							System.err.println("1246,fileName---->"+fileName);
							path=call.getString(6);
							System.err.println("1248,path---->"+path);
							view=call.getString(7);
							System.err.println("adhoc,1296,view---->"+view);
							//new code
							if("Y".equals(result) && "Y".equals(view))
							{
								 locale=(String)session.getAttribute("LOCALE");

								if ( reportServer		== null ) reportServer	= "";
								if ( userid			== null ) userid		= "";
								//if ( params 		== null ) params 		= "";
								if ( self_submit		== null ) self_submit	= "";

								if ( module_id		== null ) module_id 	= "";
								if ( report_id		== null ) report_id 	= "";
								if ( dest_locn_type 	== null ) dest_locn_type= "";
								if ( dest_locn_code	== null ) dest_locn_code= "";
								if ( facility_id		== null ) facility_id	= "";
								if ( ws_no			== null ) ws_no		= "";
								if ( report_option	== null ) report_option = "F";

								Connection conn=null;
								try{
									 conn = ConnectionManager.getConnection(request);
									 cs = conn.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" );
									cs.setString( 1,	"BL" );
									cs.setString( 2,	strBlrblprt );
									cs.setString( 3,	dest_locn_type );
									System.err.println("adhoc,dest_locn_type==>"+dest_locn_type);
									cs.setString( 4,	dest_locn_code );
									System.err.println("adhoc,dest_locn_code==>"+dest_locn_code);
									cs.setString( 5,	facility_id );
									System.err.println("adhoc,facility_id==>"+facility_id);
									cs.setString( 6,	ws_no );
									cs.setString( 7,	report_option );
									System.err.println("adhoc,report_option===>"+report_option);
									cs.registerOutParameter( 8,  Types.VARCHAR );
									cs.registerOutParameter( 9,  Types.VARCHAR );
									cs.registerOutParameter( 10, Types.VARCHAR );
									cs.registerOutParameter( 11, Types.VARCHAR );
									cs.registerOutParameter( 12, Types.VARCHAR );
									cs.registerOutParameter( 13, Types.VARCHAR );
									cs.registerOutParameter( 14, Types.VARCHAR );
									cs.registerOutParameter( 15, Types.VARCHAR );
									cs.registerOutParameter( 16, Types.VARCHAR );
									cs.registerOutParameter( 17, Types.VARCHAR );
									cs.execute() ;
									report	= cs.getString( 8 );
									server	= cs.getString( 9 );
									copies	= cs.getString( 10 );
									if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
									queue_name	= cs.getString( 12 );
									message	= cs.getString( 15 );
									if (message==null) message="";
									app_server_ip = cs.getString( 16 );
									rep_server_key= cs.getString( 17 );
									if (rep_server_key==null) rep_server_key="";

									reportServer = "http://" + app_server_ip + reportServer;
									if(cs !=null)cs.close();

								String sql1="select USER_ID,app_password.decrypt(password),REPORT_SERVER,REPORT_CONNECT_STRING  from sm_db_info";

								pstmt1=con.prepareStatement(sql1);
								rs1=pstmt1.executeQuery();
								while(rs1.next())
								{
									jdbc_username	=rs1.getString(1);
									jdbc_password	=rs1.getString(2);
									report_server =rs1.getString(3);
									reoprt_connect_string =rs1.getString(4);
								}
								user_id = jdbc_username+"/"+jdbc_password+"@"+reoprt_connect_string;
								}

								catch(Exception e){
									out.println(e);
									e.printStackTrace();
									}

								finally {
								ConnectionManager.returnConnection(conn,request);
								}

								//out.println( "<script language=\"JavaScript\">test()</script>" ) ;
							}

							}*/
									//ends GHL-CRF-0646 V220110
						else{
						/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
						asyncPrinterAttrib = new HashMap<String,String>();
						asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
						System.err.println("1021, asyncPrinterAttrib Submit.jsp==>"+asyncPrinterAttrib);
						session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);	
						out.println("<script>callAsyncOnlinePrint();</script>");
						}
						/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call - Ends*/				
					
					}
					catch (Exception e)
					{
						System.err.println("Error while submitting Print Job to Report Server:"+e);
					}
				}
			}
		}
		
		// Changes for E-Signature CRF V221117
		
		String eSignatureFlag = BLReportIdMapper.eSignatureFlag(str_facility_id);
		if(eSignatureFlag == null) eSignatureFlag = "N";
		
		int insBillCount = 0;
		if(!strbilldoctypecode.equals("") && !strbilldocnum.equals(""))
		{			
			String qrympiid="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+str_facility_id+"' and DOC_TYPE_CODE='"+strbilldoctypecode+"' and DOC_NUM='"+strbilldocnum+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(qrympiid) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					mpi_id = rs.getString(1);
				}
			}
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();			
			
			String qry = "select count(*) from bl_bill_hdr a , bl_blng_grp b where a.operating_facility_id = '"+str_facility_id+"' and mpi_id = '"+mpi_id+"' and a.bill_amt >0  and a.blng_grp_id =b.blng_grp_id and a.cust_code is not null and b.SETTLEMENT_IND = 'X'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					insBillCount = rs.getInt(1);
				}
			} else {
				insBillCount = 0;
			}
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
		}
		// Changes for E-Signature CRF

            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(called_butt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str_slmt_reqd_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_store_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_blng_grp_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_module_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_function_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strFinalMessage));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(error_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(GHL_site_spec));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(result));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(settmnt_ind));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strbillpayableamount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strCustCode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(str_sysmesage_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dep_adjust_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_deposit_alert_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str_deposit_exists_YN));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(str_error_text));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strBlrblprt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(reportServer));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(report));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(server));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(report_server));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(copies));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(queue_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(message));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(self_submit));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dest_locn_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dest_locn_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(languageID));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(str_facility_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(str_ordering_facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(path));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(fileName));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(view));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(str_episode_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str_visit_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(mpi_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(insBillCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(eSignatureFlag));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(Zatca_msg));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(zatca_error_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ZatcaYN));
            _bw.write(_wl_block70Bytes, _wl_block70);

	} catch (Exception e) {
		con.rollback();
		System.err.println("Exception in submit temp :" + e);
		e.printStackTrace();
	} finally {
		if (stmt != null)
			stmt.close();		
		//V210315 start
		if ((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sysmesage_id.equals("")) {
			con.rollback();
		} else {
			con.commit();
		}
		//V210315 end
		//con.commit(); //V210315 commented 
		call.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block71Bytes, _wl_block71);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
