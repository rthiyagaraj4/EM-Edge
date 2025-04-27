package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.*;
import java.math.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import eCA.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chartsummaryresultsd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryResultsD.jsp", 1742381507541L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name       Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?          created\n23/08/2011    IN:028353      Menaka     Incident No: 028353 - <System adds \'0\' before result of Auto\n                                         report orders in Clinical Event History ( Flow sheet view ).> \n27/01/2012\t  INO30714\t\tMenaka V\tTHAI screen>View Clinical Event History>View>In the Recorded Clinical\n\t\t\t\t\t\t\t\t\t\tNote the name is not displayed in THAI \n20/06/2012\t  IN033489\t\tMenaka V\tReport header blank in clinical event history.\n21/11/2012\t  IN035950\t\tNijitha\t\tCHL Hospital suggested that the presentation of the Clinician desktop be changed and \n\t\t\t\t\t\t\t\t\t\tmore appealing. Keeping the display of information more clear and visible.\t\t\n21/02/2013\t  IN035924\t  \tKarthi L\t \tCA View chart summary \"RESULT WIDGET\" should come blank if patient visit hospital after 6 month or \t\t\t\t\t\t\t\t\t\ttime interval defined by customer(CHL-CRF-018)\n08/03/2013\t  IN038454\t\tKarthi L\tfix to avoid Null pointer exception\n16/03/2013\t  IN038508\t\tKarthi L \tData displayed is not as per setup in chart summary content.\n14/05/2013\t  IN037793\t\tKarthi L\tTo be able to view the Specimen image attachment in \'Existing Orders\' function and \'Clinical Event \t\t\t\t\t\t\t\t\t History\' function in OR and CA.\n30/05/2013\t  IN040237\t\tKarthi L\tClicking on the icon, system is displaying error message.\n17/06/2013\t  IN040866\t\tKarthi L\tSystem is not displaying the Image in CA \n22/06/2013    IN040416\t\tNijitha S   CRF-OR-Bru-HIMS-CRF-052.1/02-System is not displaying \'View\' hyperlink for the Laboratory Panel \t\t\t\t\t\t\t\t  Order \n24/06/2013\t  IN041014\t\tKarthi L\tResulted value is not displaying in Clinical event History \n21/11/2013    IN45102\t\tNijitha S   RL/OR-View Chart Summary \n18/12/2013\t  IN042552\t\tRamesh G\tBru-HIMS-CRF-391 --- Notes Confidentiality\n06/03/2014\t IN047501    Ramesh G\tIn Chartsummry Result widget: Wrong result numeric values are diaplyed foe some test which \t\t\n\t\t\t\t\t\t\t\t\t\t\tresulted for another different test.\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n06/03/2014\tIN047204\t\tKarthi L\t\t07/03/2014\t\tRamesh \t\t\tOrder result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. \t\t\t\t\t\t\t\t\t\t\t\n12/03/2014\tIN047566\t\tAkbar\t\t\t\t\t\t\t\t\t\t\tLinked issue of Bru-HIMS-CRF-195.2-47204/01\n19/03/2014\tIN47847\t\t\tNijitha S\t\t\t\t\t\t\t\t\t\tOrder result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to\n28/03/2014\tBRUNEI LIVE ISSUE Karthi\t\t\t\t\t\t\t\t\t\tDisplay hist_data_type result string in single line without using hyperlink\n01/04/2014\tIN048253\t\t\tKarthi L\t\t01/04/2014\t\tAkbar\t\t\tGetting Script error when click on External Application link icon.\n15/05/2014\tIN047205\t\tKarthi L\t\t16/05/2014\t\tRamesh\t\t\tChanges to clinical event history and chart summary view - to provide link to the scanned document in clinical views\n02/06/2014\tIN037701\t\tNijitha\t\t\t\t\t\t\t\t\t\t\t\tSKR-CRF-0036\n09/06/2014\tIN049533\t\tKarthi L\t\t\t\t\t\t\t\t\t\tDMS Document Uploaded is not displayed in chart summary\n11/06/2014\tIN049589[IN047205]\t\tKarthi L\t\t\t\t\t\t\t\tDocument Uploaded cannot be viewed in another facility\t\n04/09/2014  PER0409\t\t\tAkbar\t     \t\t\t\t\t\t\t\t\tPerformance changes suggested by sunil\n08/09/2014  IN050936\t\tChowminya\t\t\t\t\t\t\t\t\t\tNone of the order retrieving any image from RIS/PACS but already having order image in PACS\n17/10/2014\tIN050649\t\tKarthi L\t\t\t\t\t\t\t\t\t\tRecord chart same time, system separate data of chart in view chart summary.\n30/01/2015  IN053093\t\tNijitha S\t\t\t\t\t\t\t\t\t\tML-BRU-SCF-1515\n19/03/2015\tIN052800\t\tKarthi L\t\t\t\t\t\t\t\t\t\tIf link image for Histology orderable, from CA, user not able to view the image. No link appear under View.\n09/10/2015\tIN055910\t\tKarthi L\t\t\t\t\t\t\t\t\t\tFrom Clinician Access, modified result shall be identified by include \"!\" in Blue color\n25/01/2016\tIN058139\t\tRamesh G\t\t\t\t\t\t\t\t\t\tINT-CRF-BRU-CIS-005-US001\n07/07/2017\tIN064688\t\tRaja S\t\t\t08/07/2017\t\tRameshG\t\t\tML-MMOH-SCF-0753\n07/11/2017\tIN064132\t\tRaja S\t\t\t07/11/2017\t\tRamesh G\t\tML-MMOH-CRF-0831\n07/02/2018\tIN065970\t\tVijayakumar K\t07/02/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970]\n07/03/2018\tIN065970\t\tVijayakumar K\t07/03/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970] reopen\n19/03/2018\tIN067037\t\tRaja S\t\t\t19/03/2018\t\tRamesh G\t\tML-BRU-SCF-1787\n28/06/2018\tIN065341\t\tPrakash C\t\t29/06/2018\t\tRamesh G \t\tMMS-DM-CRF-0115\n12/11/2018\tIN068797\t\tPrakash C \t\t15/12/2018\t\tRamesh G\t\tMMS-DM-SCF-0568\n03/04/2019\tIN069978        \tPrakash C\t\t03/04/2019\tRamesh G\tMMS-ICN-00116\n30/07/2019\tIN070610\t\tDinesh T\t\t30/07/2019\t\tRamesh G\t\tTBMC-CRF-0011.1\n03/02/2020\tIN071561\t\tSIVABAGYAM M\t03/02/2020\t\tRAMESH G\t\tGHL-CRF-0558.1\n15/12/2020\t7902\t\t\tSivabagyam M\t15/12/2020\t\tRamesh G\t\tMMS-DM-CRF-0180.1\n20/04/2021\t6484\t\t\tRamesh Goli\t\t20/04/2021\t\tRAMESH G\t\tMO-CRF-20147.7\n02/09/2021\t14801\t\t\tRamesh \t\t\t\t\t\t\t\t\t\t\tSKR-SCF-1578\n07/03/2022\t27788\t\t\tRamesh Goli\t\t07/03/2022\t\tRAMESH G    \tMMS-ME-SCF-0067\t\n23/06/2022\t31688\t\t\tRamesh Goli\t\t07/03/2022\t\tRAMESH G    \tNMC-JD-SCF-0288\n16/08/2022\t29803\t\t\tRamesh G \t\t\t\t\t\t\t\t\t\tML-BRU-CRF-0635\n08/08/2023  48184           Krishna Pranay   11/08/2023    RAMESH G       RL-COMMON-View Chart Summary(View Image)\n------------------------------------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" <!--added eCA.* for IN035924 --> <!--IN064688 added math.* -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" <!--  IN052800 -->\n<html>\n<head> \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!--IN037701-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' type=\'text/css\' />\n\n<style>\nA \n{ \n\ttext-decoration : none ;\n}\n.gridData1\n{\n\tbackground-color: #FFFFFF;\n\theight:18px;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\n\tborder-bottom:0px;\n\tborder-top:0px;\n\tborder-left:0px;\n\tborder-right:0px;\n\tborder-style:solid;\n}\n.innerGrid\n{\n\tbackground-color: #FFFFFF;\n\theight:18px;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:0px;\n\tborder-left:0px;\n\tborder-right:0px;\n\tborder-style:solid;\n\tborder-color:#EEEEEE;\n}\n</style>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\"../../eCA/js/ResearchPatient.js\" language=\"javascript\"></script>\n<script src=\"../../eCA/js/CAOpenExternalApplication.js\" language=\"javascript\"></script>\n<script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script> <!-- added for IN047024 -->\n<script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- added for IN048253 -->\n<script>\n\n//function callResults(patient_id,title,reln_id)//INO30714 commented for IN038454\n//function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID,p_called_from)//INO30714//Parameters facility and content_ID addd for IN038454//added p_called_from for IN037701\n//function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID,p_called_from,RepDb,clob_data)//IN071561\nasync function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID,p_called_from,RepDb,clob_data,p_review_rad_yn)//IN071561\n{\n\tvar dialogHeight\t= \"60vh\" ;\n\tvar dialogWidth\t\t= \"60vw\" ;\n\tvar status\t\t\t= \"no\";\n\tvar scroll\t\t\t= \"yes\";\n\tvar dialogTop\t\t= \"140\";\n\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\n\t//retVal \t\t\t= window.showModalDialog(\'../../eCA/jsp/ChartSummaryResultsMain.jsp?patient_id=\'+patient_id+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id,arguments,features);//INO30714\n\t\n\t//retVal \t\t\t= window.showModalDialog(\'../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id=\'+patient_id+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id+\'&encounter_id=\'+enc_id,arguments,features);//INO30714// commented for IN038454\n\t//retVal \t\t\t= window.showModalDialog(\'../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id=\'+patient_id+\'&facility_id=\'+facility_id+\'&content_id=\'+content_ID+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id+\'&encounter_id=\'+enc_id+\'&p_called_from=\'+p_called_from,arguments,features);//IN038454//added p_called_from for IN037701\n\t//retVal \t\t\t= window.showModalDialog(\'../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id=\'+patient_id+\'&facility_id=\'+facility_id+\'&content_id=\'+content_ID+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id+\'&encounter_id=\'+enc_id+\'&p_called_from=\'+p_called_from+\'&RepDb=\'+RepDb+\'&clob_data=\'+clob_data,arguments,features);//IN065341//IN071561\n\tretVal \t\t\t= await top.window.showModalDialog(\'../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id=\'+patient_id+\'&facility_id=\'+facility_id+\'&content_id=\'+content_ID+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id+\'&encounter_id=\'+enc_id+\'&p_called_from=\'+p_called_from+\'&RepDb=\'+RepDb+\'&clob_data=\'+clob_data+\'&p_review_rad_yn=\'+p_review_rad_yn,arguments,features);//IN065341//IN071561\n\t\n}\nfunction changeColor(obj)\n{\n\tobj.cells[0].style.backgroundColor=\"#FFFFC0\";\n\tobj.cells[1].style.backgroundColor=\"#FFFFC0\";\n\tobj.cells[2].style.backgroundColor=\"#FFFFC0\";\n}\nfunction changeColor1(obj,index)\n{\n\tif(eval(document.getElementById(\"tab\"+index).rows[1].style.display == \'none\'))\n\t{\n\t\tobj.cells[0].style.backgroundColor=\"#FFFFFF\";\n\t\tobj.cells[1].style.backgroundColor=\"#FFFFFF\";\n\t\tobj.cells[2].style.backgroundColor=\"#FFFFFF\";\n\t}\n}\n//function showDetails(index)//IN037701\nfunction showDetailResult(index)//method name changed for IN037701\n{\n\tif(eval(document.getElementById(\"tab\"+index).rows[1].style.display == \'none\'))\n\t{\n\t\tif(eval(document.getElementById(\"tab\"+index).rows[1].cells[0].innerHTML != \'\'))\n\t\t{\n\t\t\teval(document.getElementById(\"tab\"+index).rows[1].style.display = \'inline\');\n\t\t\teval(document.getElementById(\"tab\"+index).rows[1].cells[0].style.backgroundColor=\'#FFFFC0\');\n\t\t}\n\t}\n\telse\n\t\teval(document.getElementById(\"tab\"+index).rows[1].style.display = \'none\');\n}\n//IN058139 Stat.\n//function openGrpah(index,patient_id,event_code,event_group,histRecType)\n//function openGrpah(index,patient_id,event_code,event_group,histRecType,event_dateTime)commented for IN065341\n//IN058139 End.\nasync function openGrpah(index,patient_id,event_code,event_group,histRecType,event_dateTime,RepDb,clob_data)//IN065341\n{\n\tvar dialogHeight\t= \"90vh\" ;\n\tvar dialogWidth\t\t= \"90vw\" ;\n\tvar status\t\t\t= \"no\";\n\tvar dialogTop\t\t= \"\";\n\tvar arguments\t\t= \"\" ;\n\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status;\n\t//IN058139 Stat.\n\t//var action_url\t\t=\t\'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id=\'+patient_id+\'&event_code=\'+event_code+\'&event_group=\'+event_group+\'&histRecType=\'+histRecType;\n\t//var action_url\t\t=\t\'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id=\'+patient_id+\'&event_code=\'+event_code+\'&event_group=\'+event_group+\'&histRecType=\'+histRecType+\'&event_dateTime=\'+event_dateTime;\n\t//IN058139 End.\n\tvar action_url\t\t=\t\'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id=\'+patient_id+\'&event_code=\'+event_code+\'&event_group=\'+event_group+\'&histRecType=\'+histRecType+\'&event_dateTime=\'+event_dateTime+\'&RepDb=\'+RepDb+\'&clob_data=\'+clob_data;\n\tvar retVal=await top.window.showModalDialog(action_url,arguments,features);\n}\n\nfunction submitPrevNext(from, to)\n{\n\tdocument.ChartSummResult_Form.from.value = from;\n\tdocument.ChartSummResult_Form.to.value = to; \n\tdocument.ChartSummResult_Form.submit();\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<!-- 27788 Start. -->\n<!-- <form name=\"ChartSummResult_Form\" id=\"ChartSummResult_Form\" action=\"ChartSummaryResultsD.jsp?<//%=request.getQueryString()%>\" method=\"post\"> -->\n<form name=\"ChartSummResult_Form\" id=\"ChartSummResult_Form\" action=\"ChartSummaryResultsD.jsp\" method=\"post\">\n\n<!-- 27788 End. -->\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t<td class=\'white\' width=\'75%\'></td> \n\t\t\t<td  align=\'right\' width=\'25%\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<A class=\"gridLink\" HREF=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\'  text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</A>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\'  text-decoration=\'none\'>&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<center>\n\t\t\t<table class=\'grid\' width=\'100%\' id=\'tb1\' cellspacing=\'0\' cellpadding=\'0\'><tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<!--\t <tr><td colspan=\'3\' class=\'gridData\'><a class=\'gridLink\' href=\"javascript:callResults(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></td></tr>INO30714 ,commented for IN038454 -->\n\t\t<!--IN065341 starts-->\n\t\t <!--<tr><td colspan=\'3\' class=\'gridData\'><a class=\'gridLink\' href=\"javascript:callResults(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a></td></tr> <!--added arguments facility_id and content_ID for IN038454, added p_called_from for IN037701 --> \n\t\t <tr><td colspan=\'3\' class=\'gridData\'><a class=\'gridLink\' href=\"javascript:callResults(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a></td></tr><!-- IN071561-->\n\t\t <!--IN065341 ends-->\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n</center>\n\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<!-- 27788 Start. -->\n\t\t<input type=\'hidden\' name=\'option_id\' id=\'option_id\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' />\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' />\n\t\t<input type=\'hidden\' name=\'limit_function_id\' id=\'limit_function_id\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' />\n\t\t<input type=\'hidden\' name=\'relationship_id\' id=\'relationship_id\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' />\n\t\t<input type=\'hidden\' name=\'title\' id=\'title\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' />\n\t\t<input type=\'hidden\' name=\'prefStyle\' id=\'prefStyle\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' />\n\t\t<input type=\'hidden\' name=\'content_ID\' id=\'content_ID\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' />\n\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' />\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' /> <!-- //31688-->\n\t\t<input type=\'hidden\' name=\'facility_id1\' id=\'facility_id1\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' />\n\t\t<input type=\'hidden\' name=\'enc_id1\' id=\'enc_id1\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' />\n\t\t<input type=\'hidden\' name=\'RepDb\' id=\'RepDb\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' />\n\t\t<input type=\'hidden\' name=\'clob_data\' id=\'clob_data\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' />\n\t\t<!-- 27788 End. -->\n\t\t<!--INO30714 Starts -->\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'> \n\t\t<input type=\"hidden\" name=\"enc_id\" id=\"enc_id\" value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'> \n\t\t<!-- INO30714 Ends-->\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|");
		return resultStr;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
if(!"CA_SPC".equals(p_called_from)){
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block2Bytes, _wl_block2);

String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");

//String facility_id= (String) session.getValue("facility_id");//IN035924 commented for IN065341
	
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}

//[IN035950] Ends
	String title= request.getParameter("title")==null?"":request.getParameter("title");

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sessionStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);

	Properties p			= (Properties)session.getValue("jdbc");
	String locale			= (String) p.getProperty("LOCALE");
	Connection con			= null;
	PreparedStatement stmt	= null;
	ResultSet rs			= null;
	String viewconf_appl	= "X";
	StringBuffer sql		= new StringBuffer() ;	
	PreparedStatement pstmtImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	ResultSet resImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	int recCount = 0; // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtImgCount = null; // [IN037793]
	PreparedStatement pstmtPerFacId = null; // IN040866
	ResultSet rsetPerFacId = null;  // IN040866
	ResultSet rsetImgCount = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");	// IN047204
	String login_user = (String)session.getValue("login_user"); // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtOrderId = null; // IN047204
	ResultSet rsetOrderId = null;  // IN047204
	
	String accessionNum	= "", histRecType = "", contrSysEventCode = "", contrSysId = "", eventTime = "";
	String histRecTypeDesc = "", eventClassDesc = "", eventGroupDesc = "", eventDesc = "";
	String textExist = "", histDataType = "", resultStr = "";
	//String resultNum = "", resultNumUom = "", normalLow = "",	normalHigh = "";	commented for IN047501
	String resultNumUom = "", normalLow = "",	normalHigh = "";			//included for IN047501	
	String histRecTypeDescPrev = "", eventGroupDescPrev = "", eventDatePrev = "", tempStrValue = "";
	String normalcyInd = "";
	String ext_image_appl_id = "", ext_image_obj_id = "";
	String color_cell_indicator = "";
	String descCellInd = "";
	String event_date = "";
	String eventTimePrev = "";
	String legend_type = "";
	String patient_class = "";
	String reported_by = "";
	String details1 = "";
	String event_code = "", event_group = "";
	String pend_review_yn = "";
	String result_num_prefix = "";
	String result_status = "";
	String resultStatus ="";//29803
	String normalcy_str = "";
	StringBuffer details = new StringBuffer();
	String resp_id		= (String)session.getValue("responsibility_id");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String patient_id	= request.getParameter("patient_id");
//IN065341 starts
	String bean_id1 = "ca_CentralizedBean" ;
	String bean_name1 = "eCA.CentralizedBean";
	CentralizedBean bean1 = (CentralizedBean)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	bean1.clear() ;
	bean1.setFunctionId(bean1.checkForNull(request.getParameter("function_id")));
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	PreparedStatement pstmtImgView1 = null; //7902
	ResultSet resImgView1 = null;//7902
	String study_id="",ext_img_disable="",param_def_str="",ext_img_display="";//7902
	String enc_id="";
	 String facility_id="";
	 String scope_disp="D";
	 int no_of_days=3;
	if(called_from.equals("CDR")){
		 enc_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		 facility_id=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	}else{
//IN065341 ends
		 enc_id = request.getParameter("encounter_id");
		 facility_id= (String) session.getValue("facility_id");
	}//IN065341
	//String enc_id = request.getParameter("encounter_id");//INO30714 commented for IN065341
	String ext_image_upld_id = ""; //Bru-HIMS-CRF-052.1  [IN037793]
	String ext_img_file_locn = ""; //Bru-HIMS-CRF-052.1  [IN037793]
	//IN064132 changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	//IN064132 changes ends				
	//IN047204  - Start
	String dmsExternalLinkYN = ""; 
	String event_code_type = "";
	String order_typ_code = ""; 
	String access_no_rd 	= "";
	String order_id 	= ""; 
	String locn_code	= "";		
	String locn_type	= "";
	String loc_desc		= "";
	String visit_id		= "";
	String physician_id	= "";
	String admit_date	= "";
	String encntr_type	= "";
	HashMap extLinkHashMap = null;
	String event_dateTime = ""; //IN058139
	//IN047204 - End
	//Bru-HIMS-CRF-195.3 - IN047205 - Start
	eCA.CAExternalLinkDataDTO externalDataDTO = null;
	String ext_image_appli_id = "";
	String ext_image_obj_id_dms = "";
	String ext_image_source = "";
	String ext_srce_doc_ref_no = "";
	String ext_srce_doc_ref_line_no = "";
	ArrayList externalList = null;
	//Bru-HIMS-CRF-195.3 - IN047205 - End
	/*if(facility_id == null) { // added for IN038454 - START
		facility_id =  request.getParameter("facility_id") == null? "":request.getParameter("facility_id") ;
	}commented for IN064531*/
	if(content_ID == null){
		content_ID = request.getParameter("content_id") == null? "":request.getParameter("content_id");
	} // added for IN038454 - END
	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052800
	
	String option_id= request.getParameter("option_id") == null? "":(String)request.getParameter("option_id") ; //27788
	String limit_function_id = request.getParameter("limit_function_id") == null? "":(String)request.getParameter("limit_function_id") ;  //27788
		
	//IN066119 starts
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;
	String hideSpecimenType = "N";
	HashMap orParamFac = new HashMap();
	//IN066119 ends
	String enctr_id = "";//IN031989
	String fac_id="";//IN033489
	String modal_yn		= request.getParameter("modal_yn");
	if (modal_yn == null) modal_yn = "N";
	//IN037701 Starts
	if("CA_SPC".equals(p_called_from))
		modal_yn = "Y";
	//IN037701 Ends
	int i = 0, j = 0;
	if(resp_id == null)resp_id = "";

	int maxCount = 0;
	int start = 0 ;
    int end = 0 ;

	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 10 ;
    else
        end = Integer.parseInt( to ) ;

            _bw.write(_wl_block13Bytes, _wl_block13);

	try
	{
		manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+enc_id,"eCA.PatientBannerGroupLine",session); //IN052800
		//IN070610, starts 
		ArrayList<String> funcIds = new ArrayList<String>();
		funcIds.add("UPLOAD_TR_CATEGORY_ORDERS");
		manageEmailBean.adapter.setSiteSpecific(funcIds,"OR");
		Boolean uploadFuncTrOrders = manageEmailBean.adapter.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
		//IN070610, ends
		boolean restrict_rd	=false;	//IN071561
		
		// added below line for BRU-CRF-018 - IN035924 START
		StringBuffer encListBuf = new StringBuffer();
		ArrayList encounterList = null;
		CAEncounterList oEncounterList = new CAEncounterList();
		if(!called_from.equals("CDR")){//IN065341
			HashMap encounterMap = oEncounterList.getPatEncounterList(patient_id, facility_id, content_ID);
			 scope_disp = (String)encounterMap.get("SCOPE_DISP");
			Integer no_of_days_before = (Integer)encounterMap.get("NO_OF_DAYS");
			 no_of_days = no_of_days_before.intValue();
			encounterList = (ArrayList)encounterMap.get("ENC_LIST");
			dmsExternalLinkYN = oEncounterList.getExternalDmsLinkYN(facility_id); //IN047204 	
				
			if( no_of_days >= 1  &&  !"null".equals(scope_disp) &&  scope_disp.equalsIgnoreCase("P"))
			{
				Iterator iterator = encounterList.iterator();
				int index = 0;
				
				while(iterator.hasNext())
				{	
					index++;
					encListBuf.append("'");
					encListBuf.append(iterator.next());
					if(encounterList.size() >= index )
					{
						encListBuf.append("'");
					}
					
					if(encounterList.size() != index )
					{
						encListBuf.append(",");
					}
				}
			}
			else if(scope_disp.equalsIgnoreCase("P"))
			{
				encListBuf.append("'");
				encListBuf.append(enc_id);
				encListBuf.append("'");
			}
			
			// END - IN035924
			
			if(scope_disp.equalsIgnoreCase("D")) { //IN038508 - START
				no_of_days = 3;
			}
			else if(scope_disp.equalsIgnoreCase("P")) {
				no_of_days =no_of_days + 2;
			}  //IN038508 - END
		}//IN065341
		con	 = ConnectionManager.getConnection(request);
		//IN066119 STARTS
		orParamFac=bean.orParamFacility(con, facility_id);
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");
		//IN066119 ENDS
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER"); //Added for IN064132
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		//IN065341 starts
			if(called_from.equals("CDR")){
				bean1.executeCDR(con,patient_id,enc_id,RepDb,"CR_ENCOUNTER_DETAIL_TXT");
			}
			//stmt = con.prepareStatement(" select GET_TASK_APPLICABILITY(?,NULL,?,?) from dual ");
			String  sql1="select GET_TASK_APPLICABILITY ##REPDB##(?,NULL,?,?) from dual ##REPDB##";
			sql1=sql1.replaceAll("##REPDB##",RepDb);
			stmt = con.prepareStatement(sql1);
		//IN065341 ends
		stmt.setString(1,"VIEW_CONF_RESULT");
		stmt.setString(2,resp_id);
		stmt.setString(3,reln_id);
		rs = stmt.executeQuery();
		if (rs.next())
			viewconf_appl = rs.getString(1);
		if (viewconf_appl == null) viewconf_appl = "X";
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		
	//IN065341 starts	
		//stmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
		String  sql2="select LEGEND_TYPE from CR_CLIN_EVENT_PARAM##REPDB##";
		sql2=sql2.replaceAll("##REPDB##",RepDb);
		stmt = con.prepareStatement(sql2);
	//IN065341 ends
		rs = stmt.executeQuery();
		if (rs.next())
		{
			legend_type = rs.getString(1) == null ? "S" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time,B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc)  event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') reported_by, d.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR  FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO < 3	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )" );//IN033489
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time,B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc)  event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') reported_by, d.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO < "+no_of_days+"	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )" );//IN033489 //IN038508
		
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time,B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc)  event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') reported_by, d.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );//IN033489 //IN038508 //Bru-HIMS-CRF-052.1 [IN037793]
		//PER0409 - removed locale from below query and included desc as sub query
		//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') reported_by, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );  //Bru-HIMS-CRF-052.1 [IN037793] - a.EVENT_CODE_TYPE added for IN047204//Commented for IN064132
		//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );  //Modified for IN064132 //commented for IN067037
		//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );  //modified for IN067037
	//IN069978 starts	
		if(!called_from.equals("CDR")){	
			//IN070610, starts
//			sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
			if(uploadFuncTrOrders){
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				//6484 End.
			}else{
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				//6484 End.
			}//IN070610, ends			
		}else{
			//IN070610, starts
//			sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
			if(uploadFuncTrOrders){
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and ( dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				//6484 End.
			}else{
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and ( dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				//6484 End.
			}
			//IN070610, ends
		}	
	//IN069978 ends	
	//IN065341 starts	
		if(called_from.equals("CDR")){
			sql.append("	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )");
		}else{//IN065341 ends
			if(scope_disp.equalsIgnoreCase("C")){
				sql.append(" )AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )");
			}
			else {
				sql.append("where RANK_NO < "+no_of_days+"	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )");
			}
		}//IN065341
	//IN069978 starts
	//31688 Starts.
	/* 
		if (modal_yn.equals("N")){
			//sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail where patient_id=? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10 OR drank<2) ");
			if(!called_from.equals("CDR")){	
				sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail##REPDB## where patient_id=? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE  from  or_order_category ##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10 OR drank<2) ");//IN065341
			}else{
				sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail##REPDB## where patient_id=? and encounter_id = ? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE  from  or_order_category ##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10 OR drank<2) ");//IN065341
			}
		}else{
	*/ //31688 End.
			if(called_from.equals("CDR")){
				sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail##REPDB## where patient_id=? and encounter_id = ? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE  from  or_order_category ##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10000 OR drank<10000) ");//IN065341
			}
	//	} //31688 
	//IN069978 ends	
		if (viewconf_appl.equals("X"))
			sql.append(" and (nvl(A.PROTECTION_IND,'N')!='Z' )  ");
	
		//sql.append(" and nvl(a.STATUS,'`') not in('S','E')  order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");//CHL_CRF_EMR_0018
	
	/*	if(scope_disp.equalsIgnoreCase("D")){ // condition added for CHL-CRF-018 IN035924
			sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id=? order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");//CHL_CRF_EMR_0018
		}	*/ // commented for IN038508
		
		//IN042552 Start.
		String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN042552
		//sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')='Y' "); //IN042552    //PER0409
		//sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')='Y' "); //IN042552    //PER0409
		//sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')!='N' "); //Performance Issue in GHL [Ramesh]
		sql.append(" and nvl(ca_view_confidnt_event##REPDB## (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')!='N' "); 
		//IN042552 End.
		//IN071561 STARTS
		 if(restrict_rd)
			   sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
		//IN071561 ENDS
		if(scope_disp.equalsIgnoreCase("P") || scope_disp.equalsIgnoreCase("D"))  // condition added for CHL-CRF-018 IN035924
		{	
			//sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id in("+encListBuf+") order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");
			//sql.append(" and nvl(a.STATUS,'`') not in('S','E') order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");//IN038508 - Commented for IN050649
			sql.append(" and nvl(a.STATUS,'`') not in('S','E') order by a.event_date desc,hist_rec_type, event_group_desc, a.event_group, request_num_seq, event_desc,a.event_code ");// modified for IN050649
		}	
		else if(scope_disp.equalsIgnoreCase("C")) // condition added for CHL-CRF-018 IN035924
		{
			//sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id=?  and EVENT_DATE between (sysdate - ?) and sysdate order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code "); - Commented for IN050649
			sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id=?  and EVENT_DATE between (sysdate - ?) and sysdate order by a.event_date desc,hist_rec_type, event_group_desc, a.event_group, request_num_seq	,event_desc,a.event_code "); // modified for IN050649			
		}	
		
		//CHL_CRF_EMR_0018 Starts
		int indx=1;
		/*stmt=con.prepareStatement(sql.toString());
		stmt.setString(1,practitioner_id);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		stmt.setString(5,locale);
		stmt.setString(6,patient_id);
		stmt.setString(7,patient_id);
		if (modal_yn.equals("N"))
			stmt.setString(8,patient_id);*/
		// modified for CHL-CRF-018 IN035924	
	//IN065341 starts
		//stmt=con.prepareStatement(sql.toString());
		String result=sql.toString();
		result=result.replaceAll("##REPDB##",RepDb);
		result=result.replaceAll("##CLOB##",clob_data);
		stmt=con.prepareStatement(result);
	//IN065341 ends
		//PER0409 - start
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);//added for IN064132
		//PER0409 - end
		stmt.setString(indx++,practitioner_id);
		//PER0409 - start
		//stmt.setString(indx++,locale);
		//stmt.setString(indx++,locale);
		//stmt.setString(indx++,locale);
		//stmt.setString(indx++,locale);
		//PER0409 - end
		stmt.setString(indx++,patient_id);
		stmt.setString(indx++,patient_id);
		if(called_from.equals("CDR")){//IN069978 starts
			stmt.setString(indx++,enc_id);
		}//IN069978 ends
		//31688 Starts.
		/*
		if (modal_yn.equals("N"))
			stmt.setString(indx++,patient_id);
		if (modal_yn.equals("Y") && called_from.equals("CDR"))//IN069978 starts
			stmt.setString(indx++,patient_id);
		*/	
		//31688 End.
		if(called_from.equals("CDR")){
			stmt.setString(indx++,patient_id); //31688
			stmt.setString(indx++,enc_id);
		}//IN069978 ends
		//PER0409 - start
		stmt.setString(indx++,clinician_id);			
		stmt.setString(indx++,resp_id);			
		//PER0409 - end
		//if(scope_disp.equalsIgnoreCase("D") || scope_disp.equalsIgnoreCase("C")){ //condition added for CHL-CRF-018 IN035924
		if( scope_disp.equalsIgnoreCase("C")){
			stmt.setString(indx++,enc_id);			
		}
		if(scope_disp.equalsIgnoreCase("C")){ // added for CHL-CRF-018 IN035924
			stmt.setInt(indx++,no_of_days);			
		}		
		//CHL_CRF_EMR_0018 Ends
		rs = stmt.executeQuery();

		while(rs.next())
		{
			maxCount = maxCount+1;
		}
		if(rs!=null) rs.close();

		if(maxCount > 0)
		{

            _bw.write(_wl_block14Bytes, _wl_block14);

			//IN037701 Starts
			if(!"CA_SPC".equals(p_called_from))
			{//IN037701 Ends
			if ( !(start <= 1) )
			{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			if ( !( (start+10) > maxCount ) )
			{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			
			}
			}//IN037701

            _bw.write(_wl_block20Bytes, _wl_block20);

		rs = stmt.executeQuery();
		
		if(start > 0)
			for(int k=0;(k<start-1 && rs.next());k++);
		//IN037701 Starts	
		if("CA_SPC".equals(p_called_from))
		{
			start = 0;
			end = 0;
		}
		//IN037701 Ends
		while(rs.next() && (start <= end))
		{
			String resultNum = "";		//added for IN047501
			accessionNum = rs.getString("accession_num") == null ? "" : rs.getString("accession_num");
			histRecType = rs.getString("hist_rec_type") == null ? "" : rs.getString("hist_rec_type");
			contrSysEventCode = rs.getString("contr_sys_event_code") == null ? "" : rs.getString("contr_sys_event_code");
			contrSysId = rs.getString("contr_sys_id") == null ? "" : rs.getString("contr_sys_id");
			event_date = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
			event_dateTime =  rs.getString("event_date") == null ? "" : rs.getString("event_date"); //IN058139
			eventTime = rs.getString("event_time") == null ? "" : rs.getString("event_time");
			histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
			eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
			eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
			eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
			textExist = rs.getString("text_exisits") == null ? "" : rs.getString("text_exisits");	
			histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");	
			ext_image_appl_id = rs.getString("ext_image_appl_id") == null ? "" : rs.getString("ext_image_appl_id");	
			ext_image_obj_id	= rs.getString("ext_image_obj_id") == null ? "" : rs.getString("ext_image_obj_id");
			if(legend_type.equals("C"))
				color_cell_indicator = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
			else if(legend_type.equals("S"))
				color_cell_indicator = rs.getString("normal_range_symbol") == null ? "" : rs.getString("normal_range_symbol");
			descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
			resultStr = rs.getString("result_str") == null ? "" : rs.getString("result_str");
			patient_class = rs.getString("PATIENT_CLASS") == null ? "" : rs.getString("PATIENT_CLASS");
			reported_by = rs.getString("reported_by") == null ? "" : rs.getString("reported_by");
			resulted_practitioner = rs.getString("resulted_practitioner") == null ? "" : rs.getString("resulted_practitioner"); //Added for IN064132
			event_code = rs.getString("event_code") == null ? "" : rs.getString("event_code");
			event_group = rs.getString("event_group") == null ? "" : rs.getString("event_group");
			pend_review_yn = rs.getString("pend_review_yn") == null ? "" : rs.getString("pend_review_yn");
			normalcyInd = rs.getString("normalcy_ind") == null ? "" : rs.getString("normalcy_ind");
			result_status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
			resultStatus = rs.getString("resultStatus") == null ? "" : rs.getString("resultStatus"); //29803
			normalcy_str = rs.getString("NORMALCY_STR") == null ? "" : rs.getString("NORMALCY_STR");
			enctr_id = rs.getString("encounter_ID") == null ? "" : rs.getString("encounter_ID");//IN033489
			fac_id = rs.getString("FACILITY_ID") == null ? "" : rs.getString("FACILITY_ID");//IN033489
			event_code_type  = rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE"); // IN047204
			// added for Bru-HIMS-CRF-052.1 [IN037793] - Start
			
			ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");
			//IN066119 starts
			if("Y".equals(hideSpecimenType) && "LBIN".equals(histRecType))
				resultStr ="";
			//IN066119 ends
				//7902 STARTS
				if(!ext_image_appl_id.equals("") && ext_image_appl_id.equals("CPACS"))
				{
				
					ext_img_disable="disabled";
					
					String paramQuery = "SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW##REPDB## WHERE  EXT_IMAGE_APPL_ID=?";
					paramQuery = paramQuery.replaceAll("##REPDB##",RepDb);
					pstmtImgView1 = con.prepareStatement(paramQuery); 
					pstmtImgView1.setString(1,ext_image_appl_id);
					resImgView1 = pstmtImgView1.executeQuery();
					
					while(resImgView1.next())
					{
						param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
					}
					if(pstmtImgView1!=null) pstmtImgView1.close();
					if(resImgView1!=null) resImgView1.close();
					
					if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){	
						String studayQuery ="SELECT A.study_id  FROM or_order_line##REPDB## a, cr_encounter_detail##REPDB## b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?";
						studayQuery = studayQuery.replaceAll("##REPDB##",RepDb);
						pstmtImgView = con.prepareStatement(studayQuery); 
						pstmtImgView.setString(1,ext_image_appl_id);
						pstmtImgView.setString(2,ext_image_obj_id);
						resImgView = pstmtImgView.executeQuery();
						
						while(resImgView.next())
						{
							study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
						}
						
						if(pstmtImgView!=null) pstmtImgView.close();
						if(resImgView!=null) resImgView.close();
					}
					
				}
				if(study_id.equals("null"))
					study_id="";
				if(!study_id.equals("") && param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(!study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`")&& ext_image_appl_id.equals("CPACS"))
				{
					ext_img_disable="disabled";
					ext_img_display="Study ID not available, we cannot Proceed";
				}
				else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				}	//7902 ENDS
			if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
			//IN065341 starts	
				//pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
				String sql3="select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD ##REPDB## where EXT_IMAGE_UPLD_ID = ?";
				sql3=sql3.replaceAll("##REPDB##",RepDb);
				pstmtImgView = con.prepareStatement(sql3);
			//IN065341 ends
				pstmtImgView.setString(1,ext_image_upld_id);
				resImgView = pstmtImgView.executeQuery();
				//contrSysEventCode = event_group;//IN040416
				String recCountInt = "";
				String perfFacilityId = ""; //IN040866 
				while(resImgView.next())
				{
					ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
				}
				//IN040866 - Start
			//IN065341 starts	
				//pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
				String sql4="select  distinct b.performing_facility_id from or_order_line ##REPDB## a,or_order ##REPDB## b where a.order_id = b.order_id and a.accession_num = ?";
				sql4=sql4.replaceAll("##REPDB##",RepDb);
				pstmtPerFacId = con.prepareStatement(sql4);
			//IN065341 ends			
				pstmtPerFacId.setString(1,ext_image_obj_id);
				rsetPerFacId = pstmtPerFacId.executeQuery();
				if(rsetPerFacId.next()){
					perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
				}
				
				//IN040866 - End
				// IN052800 - Start
				if(perfFacilityId.equals("") || perfFacilityId == null){
					perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(ext_image_obj_id);
				}
				//IN052800 - End
				//IN065970 starts
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?"); 
			//IN065341 starts	
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
				String sql5="select count(*) from rl_specimen_image_dtls ##REPDB## where SPECIMEN_NO = ? and TEST_CODE = ?";
				sql5=sql5.replaceAll("##REPDB##",RepDb);
				pstmtImgCount = con.prepareStatement(sql5);
			//IN065341 ends
				//pstmtImgCount.setString(1,fac_id); commented for IN040866
				//pstmtImgCount.setString(1,perfFacilityId);// modified for IN040866
				//pstmtImgCount.setString(2,ext_image_obj_id);
				pstmtImgCount.setString(1,ext_image_obj_id);
				//pstmtImgCount.setString(3,contrSysEventCode); //IN040416
				//pstmtImgCount.setString(3,event_group);//IN040416
				//pstmtImgCount.setString(2,event_group);
				  pstmtImgCount.setString(2,event_code);//48184 As per discuss with lab.I have done changes

				//IN065970 ends
				rsetImgCount = pstmtImgCount.executeQuery();
				if(rsetImgCount.next()) 
				{
					recCount = rsetImgCount.getInt(1);
				}
				recCountInt = String.valueOf(recCount);
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contrSysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale);  //commented for IN040866
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contrSysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040866 //IN040416
				//IN065970 reopen starts
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); //IN040416	
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale);
				  ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale);//48184 As per discuss with lab.I have done changes
                 //IN065970 reopen ends
				
				if(resImgView  != null) resImgView.close();
				if(pstmtImgView != null) pstmtImgView.close();

				if(rsetImgCount  != null)  rsetImgCount.close();
				if(pstmtImgCount  != null) pstmtImgCount.close();

				if(rsetPerFacId  != null) rsetPerFacId.close();
				if(pstmtPerFacId  != null) pstmtPerFacId.close();
			}	
			// End	
			if(patient_class.equals("OP"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			else if(patient_class.equals("IP"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			else if(patient_class.equals("EM"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			else if(patient_class.equals("DC"))
				patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

			details.setLength(0);
			details1 = "";
			//IN064132 changes starts
			/*
			if(!reported_by.equals(""))
				details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportedBy.label","common_labels") + " : " + reported_by);
			*/
			if(isPracSiteSpecific && "LBIN".equals(histRecType))
			{
				if(!resulted_practitioner.equals(""))
					details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportedBy.label","common_labels") + " : " + resulted_practitioner);
			}
			else{
				if(!reported_by.equals(""))
					details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportedBy.label","common_labels") + " : " + reported_by);
			}
			//IN064132 changes ends
			if(!patient_class.equals(""))
			{
				if(!(details.toString()).equals(""))
					details.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels") + " : " + patient_class);
				else
					details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels") + " : " + patient_class);
			}

			if(pend_review_yn.equals("Y"))
			{
				eventDesc = "<b>" + eventDesc + "</b>";
				eventTime = "<b>" + eventTime + "</b>";
			}
			
			if(!event_date.equals("") && !locale.equals("en"))
				event_date = com.ehis.util.DateUtils.convertDate(event_date,"DMY","en",locale);
			
			if(!histRecTypeDesc.equals(histRecTypeDescPrev))
			{
				i++;
				if(sStyle.equals(prefStyleSheet) )
				{
				out.println("<tr><td VALIGN=top  class='gridData' style='background-color:#C0C0C0' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}else
				{
				out.println("<tr><td VALIGN=top  class='gridData' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}
			//	out.println("<td VALIGN=top class='gridData' colspan=3>"+event_date+"</td></tr>");
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='50%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
				histRecTypeDescPrev = histRecTypeDesc;
				eventDatePrev = event_date;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
			}
			else if(!event_date.equals(eventDatePrev))
			{
				if(sStyle.equals(prefStyleSheet))
				{
				out.println("<tr><td VALIGN=top  class='gridData' style='background-color:#C0C0C0' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}else
				{
				out.println("<tr><td VALIGN=top  class='gridData' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}
				//out.println("<tr><td VALIGN=top class='gridData' colspan=3>"+event_date+"</td></tr>");
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='50%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
				eventDatePrev = event_date;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
			}
			else if(!eventGroupDesc.equals(eventGroupDescPrev) || !eventTime.equals(eventTimePrev))
			{
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='50%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
			}
			else if(eventGroupDesc.equals(eventGroupDescPrev) && eventTime.equals(eventTimePrev))
			{
				if(!eventGroupDesc.equals(""))
				{	
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
			}
			else
			{
				out.println("<tr>");
				out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
				out.println("<td VALIGN=top  class='gridData1' width='50%'>"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				j++;
			}
			//HSA-CRF-0257.1 - IN055910- Start
			if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(result_status)) {
				out.println("<img src='../../eCA/images/modifiedresult.png' name='mod_result' alt='Result Modified'/>&nbsp;");
			}
			//HSA-CRF-0257.1 - IN055910- End
			if(histDataType.equals("NUM"))
			{
				result_num_prefix = rs.getString("result_num_prefix")==null?"":rs.getString("result_num_prefix");
				//IN064688 Changes Starts
				//resultNum = rs.getString("result_num")==null?"":rs.getString("result_num");//Menaka for IN:028353
				BigDecimal rm =rs.getBigDecimal("result_num");
				if(rm!=null)
				resultNum=rm.toString();
				else
				resultNum="";
				//IN064688 Changes Ends
				resultNumUom = rs.getString("result_num_uom")==null?"":rs.getString("result_num_uom");
				//IN064688 Changes starts
				//normalLow = rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");
				BigDecimal nl =rs.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
				normalLow=nl.toString();
				else
				normalLow="";
				//normalHigh = rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH");
				BigDecimal nh=rs.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
				normalHigh=nh.toString();
				else
				normalHigh="";
				//IN064688 Changes Ends
				//Added by Jyothi.G on 09/12/2010 to fix IN025310
				if(!normalLow.equals("") && !normalHigh.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : " + normalLow + " " + resultNumUom +" to "+ normalHigh + " " + resultNumUom ;
				else if(!normalLow.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (>=" + normalLow + " " + resultNumUom + ")" ;
				else if(!normalHigh.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (<=" + normalHigh + " " + resultNumUom + ")" ;
				else
					details1 = "";

				if(!details1.equals(""))
					details1 = details1 + "<br>" + details.toString();
				else
					details1 = details.toString(); //END

				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				else
				{
					if(normalcyInd.equals("."))
					{
						if(legend_type.equals("S"))
							out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
						else
							out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					}
					else if(!normalLow.equals("") && !normalHigh.equals("") && !resultNum.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= 	Float.parseFloat(normalHigh)))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(!normalLow.equals("") && normalHigh.equals("") && !resultNum.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(normalLow.equals("") && !normalHigh.equals("") && !resultNum.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) <= 	Float.parseFloat(normalHigh))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}//END
				}
				//IN067037 start 
				/*
				//IN053093 Starts	
				//CHANGED FOR NUMBERFORMATE EXCEPTION START
				if(!resultNum.equals(""))
				{
				if(Float.parseFloat(resultNum) < 1)
				{
					out.println("<b>"+result_num_prefix+Double.parseDouble(resultNum)+"</b>&nbsp;"+resultNumUom);
				}
				else
				{
					out.println("<b>"+result_num_prefix+resultNum+"</b>&nbsp;"+resultNumUom);
				}
				}
				//CHANGED FOR NUMBERFORMATE EXCEPTION end
				//IN053093 Ends
				*/
				if(!resultNum.equals(""))
					out.println("<b>"+result_num_prefix+resultNum+"</b>&nbsp;"+resultNumUom);

				//IN067037 ends
				if(!resultStr.equals(""))
				{
					if(resultStr.length() > 25){
						tempStrValue = resultStr.substring(0,24);
						resultStr = replaceSpecialChar(resultStr);
						out.println("<a class='' href=\"javaScript:ShowComments('"+resultStr+"')\" title='"+resultStr+"'>"+tempStrValue+"...</a>"); //14801  Added ShowComments 
					}else{
						out.println(resultStr);
					}
				}
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\" />");	//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");	//IN033489
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");	//IN065341
				}
				//IN058139 Stat.
				//out.println("<img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patient_id+"','"+event_code+"','"+event_group+"','"+histRecType+"')\" />");
				//out.println("<img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patient_id+"','"+event_code+"','"+event_group+"','"+histRecType+"','"+event_dateTime+"')\" />");//IN058139
				out.println("<img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patient_id+"','"+event_code+"','"+event_group+"','"+histRecType+"','"+event_dateTime+"','"+RepDb+"','"+clob_data+"')\" />");//IN065341
			}
			else if(histDataType.equals("STR"))
			{	details1 = details.toString();
				if(!color_cell_indicator.equals(""))
				{	
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				if(resultStr.length() > 25)
				{
					tempStrValue = resultStr.substring(0,24);
					resultStr = replaceSpecialChar(resultStr);
					out.println("<a class='' href=\"javaScript:ShowComments('"+resultStr+"')\" title='"+resultStr+"'>"+tempStrValue+"...</a>"); //14801  Added ShowComments 
				}
				else
					out.println(resultStr);

				if(!normalcy_str.equals(""))
				{
					out.println(" <font color=blue>( Normal Value : "+normalcy_str+" )</font>");
				}
				
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\" />");//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");//IN033489					
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");//IN065341
					
				}
			}
			else if(histDataType.equals("TXT")||histDataType.equals("HTM"))
			{
				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				details1 = details.toString();
				if(!histRecType.equals("CLNT")&& histDataType.equals("TXT"))
				{
					//out.println("Result Text:");
				}
				//added for IN041014 - Start

				out.println("<b>"+resultNum+"</b>&nbsp;");//Commented for IN45102   // uncommented for IN047501
				
				if(!resultStr.equals(""))
				{
					//out.println("<b>"+resultNum+"</b>&nbsp;");//Added for IN45102    // commented for IN047501
					/*if(resultStr.length() > 25){
						tempStrValue = resultStr.substring(0,24);
						resultStr = replaceSpecialChar(resultStr);
						out.println("<a class='' href=\"javaScript:ShowComments('"+resultStr+"')\" title='"+resultStr+"'>"+tempStrValue+"...</a>"); //14801  Added ShowComments 
					}else{ 
						out.println(resultStr);
					}  
					*///commentd for BRUNEI LIVE ISSUE
				}
				
				//IN041014 - End
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\" />");//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");//IN033489					
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");//IN065341
				}
			}

			/*if(!ext_image_appl_id.equals(""))
			{
				out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"')\">");	
			}*/
			//Added condition for EMG
			if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals(""))))  
			{
				if(!("DMS").equals(ext_image_appl_id)) { // IN049533
					if(!("DOCUL").equals(ext_image_appl_id) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))  // modified for IN040237 - START
				//	if(!("DOCUL").equals(ext_image_appl_id)) // modified for IN040237
					{	
					//IN068797 starts	
						//IN050936 included patient_id
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">");//7902
						out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\"  alt='"+ext_img_display+"' >");//7902
					//IN068797 ends	
						//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"')\">");	

						//out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_image_obj_id+"','"+contrSysEventCode+"','','','"+recCount+"','"+facility_id+"')\"> View Image </a>");
					}
					else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
					{ 	
						//IN050936 included patient_id
					//IN068797 starts	
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">");//7902
						out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\"  alt='"+ext_img_display+"' >");//7902
					//IN068797 ends
					}
					else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
					//out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_image_obj_id+"','"+contrSysEventCode+"','','','"+recCount+"','"+facility_id+"')\"> View Image </a>");
					out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"><br></br> View Image </a>");
					}
				}	// IN049533
			} //END
			/* commented for IN040237
			// added for Bru-HIMS-CRF-052.1 [IN037793]
			if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
				//out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_image_obj_id+"','"+contrSysEventCode+"','','','"+recCount+"','"+facility_id+"')\"> View Image </a>");
				out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>");
			}
			*/
			// added for IN047204 - Start
			if("Y".equals(dmsExternalLinkYN)) {// && "RD".equals(event_code_type)) { // commented for  Bru-HIMS-CRF-195.3 - IN047205 
				extLinkHashMap = oEncounterList.getExternalLinkParameters(facility_id, patient_id, enctr_id, locale); 
				admit_date	= (String) extLinkHashMap.get("P_ENCNTR_DATE");
				locn_code	= (String) extLinkHashMap.get("P_LOCN_CODE");
				locn_type	= (String) extLinkHashMap.get("P_LOCN_TYPE");
				visit_id	= (String) extLinkHashMap.get("P_VISIT_ID");
				loc_desc	= (String) extLinkHashMap.get("P_LOC_DESC");
				physician_id	= (String) extLinkHashMap.get("P_PHYSICIAN_ID");
				encntr_type	= (String) extLinkHashMap.get("P_EPISODE_TYPE");
				externalList = oEncounterList.getExternalLinkdata(histRecType, contrSysId, accessionNum, contrSysEventCode); //Bru-HIMS-CRF-195.3 - IN047205 - Start
				Iterator iter = externalList.iterator(); 
				while(iter.hasNext()){
					externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
					ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
					ext_image_obj_id_dms = externalDataDTO.getExt_image_obj_id();
					ext_image_source = externalDataDTO.getExt_image_source();
					ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
					ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();	
				
					if("RD".equals(event_code_type)) { 		//Bru-HIMS-CRF-195.3 - IN047205 - End
						//Fix for IN047566/Start
						//access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
						if ((ext_image_obj_id.equals(null) || ext_image_obj_id.equals(""))) 
							access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
						else
							access_no_rd 	= ext_image_obj_id;
						//Fix for IN047566/End
					//IN065341 starts	
						//pstmtOrderId = con.prepareStatement("select  order_id, order_type_code from or_order_line where accession_num = ?"); 
						String sql6 = "select  order_id, order_type_code from or_order_line ##REPDB## where accession_num = ?"; 
						sql6=sql6.replaceAll("##REPDB##",RepDb);
						pstmtOrderId = con.prepareStatement(sql6);
					//IN065341 ends					
					pstmtOrderId.setString(1,access_no_rd);
						rsetOrderId = pstmtOrderId.executeQuery();
						if(rsetOrderId.next()){
							order_id = rsetOrderId.getString("order_id") == null ? "":  rsetOrderId.getString("order_id");
							order_typ_code	= rsetOrderId.getString("order_type_code") == null ? "":  rsetOrderId.getString("order_type_code");	
						}
						
						if(rsetOrderId  != null) rsetOrderId.close();
						if(pstmtOrderId  != null) pstmtOrderId.close();
						
							//out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+facility_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"')\">");//IN47847 added title
						out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"); // IN049589 Passing peforming facility_id[fac_id] instead of login facility_id[facility_id]
					}	//Bru-HIMS-CRF-195.3 - IN047205 - Start
					else {
						out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"); // IN049589 Passing peforming facility_id[fac_id] instead of login facility_id[facility_id]
					}	//Bru-HIMS-CRF-195.3 - IN047205 - End
				}	
			}
			// added for IN047204 - End
			
			//IN070610, starts
			String l_upload_view = "N";
			Integer l_rec_cnt = 0;
			
			if(uploadFuncTrOrders)
				l_rec_cnt = Integer.parseInt(rs.getString("uploaded_doc_cnt"));
			
			if(l_rec_cnt > 0 && "TRET".equals(histRecType) && uploadFuncTrOrders)
			{
				l_upload_view = "Y";
			}							
			
			if("Y".equals(l_upload_view))								
				out.println("<a style='cursor:pointer;color:blue' onClick=\"uploadedDocuments('"+accessionNum+"','"+contrSysEventCode+"')\"><img src='../../eOR/images/DOCUL.gif' width='16' height='16' border=0 alt='Uploaded Documents'/></a>");					
			//IN070610, ends
			
			if(result_status.equals("P")||resultStatus.equals("4"))
				out.println("<font color='red'>(Preliminary)</font>");

			out.println("</td></tr>");
			out.println("<tr style='display:none'><td class='gridData1' colspan='3'>"+details1+"</td></tr>");
			out.println("</table></td></tr>");
			if(!"CA_SPC".equals(p_called_from))//IN037701
				start++;
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
		 
		if (i==0)
		{
			out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoResultdata.label","ca_labels")+"</td></tr>");		
		}
		else if (modal_yn.equals("N"))
		{

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(title));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reln_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(title));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reln_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(title));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reln_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(RepDb));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(clob_data));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_review_rad_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
	}	
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();
	}
	finally
	{	
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(start));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(end));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(start));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(end));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(reln_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(title));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prefStyleSheet));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(RepDb));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(clob_data));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MoreDtlRef.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MoreDtlRef.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MoreDtlRef.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
