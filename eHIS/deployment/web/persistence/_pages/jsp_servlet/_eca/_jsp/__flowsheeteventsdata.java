package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.util.zip.*;
import java.text.*;
import webbeans.eCommon.*;
import java.math.*;
import java.sql.Types;
import java.io.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __flowsheeteventsdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetEventsData.jsp", 1743758753619L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n23/08/2011    IN:028353      Menaka      Incident No: 028353 - <System adds â??0â?? before result of Auto\n                                                               report orders in Clinical Event History ( Flow sheet view ).> \n05/04/2012\t  IN031989\t\tMenakaV\t \tWhen a patient is selected by using patient without encounter search function and when clinical\n\t\t\t\t\t\t\t\t\t\tevent history is accessed the note header is incomplete for all the existing notes for that patient.\t\n20/06/2012\t  IN033489\t\tMenaka V\tReport header blank in clinical event history.\t\t\t\t\t\t\t\t\t\t\n12/11/2012\t  EMG\t\t\tChowminya G\t\n12/03/2013    IN037900      Chowminya G  System is displaying wrong data for the decimal numeric component - max data\n28/05/2013\t  IN037793\t\tKarthi L\tTo be able to view the Specimen image attachment in \'Existing Orders\' function and \'Clinical Event History\' function in OR and CA.\t\n30/05/2013\t  IN040237\t\tKarthi L\tClicking on the icon, system is displaying error message.\n17/06/2013\t  IN040866\t\tKarthi L\tSystem is not displaying the Image in CA \n21/06/2013\t  IN036050\t\tDinesh-Vijayakumark System doesnâ??t group data which recorded from vital sign chart\t\n22/06/2013  IN040416\t\tNijitha S  CRF-OR-Bru-HIMS-CRF-052.1/02-System is not displaying \'View\' hyperlink for the Laboratory Panel Order.\n24/06/2013\tIN041014\t\tKarthi L\tResulted value is not displaying in Clinical event History \n18/12/2013\tIN042552\t\tRamesh G\tBru-HIMS-CRF-391 --- Notes Confidentiality\t\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n03/03/2014\tIN047204\t\tKarthi L\t\t07/03/2014\t\tRamesh \t\t\tOrder result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. \n12/03/2014\tIN047566\t\tAkbar\t\t\t\t\t\t\t\t\t\t\tLinked issue of Bru-HIMS-CRF-195.2-47204/01\t\t\t\t\t\t\n19/03/2014\tIN47847\t\t\tNijitha S\t\t\t\t\t\t\t\t\t\tOrder result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to\n28/03/2014\tBRUNEI LIVE ISSUE Karthi\t\t\t\t\t\t\t\t\t\tDisplay hist_data_type result string in single line without using hyperlink\n01/04/2014\tIN048253\t\t\tKarthi L\t\t01/04/2014\t\tAkbar\t\t\tGetting Script error when click on External Application link icon.\n15/05/2014\tIN047205\t\tKarthi L\t\t16/05/2014\t\tRamesh\t\t\tChanges to clinical event history and chart summary view - to provide link to the scanned document in clinical views\n09/06/2014\tIN049533\t\tKarthi L\t\t\t\t\t\t\t\t\t\tDMS Document Uploaded is not displayed in chart summary\n08/09/2014  IN050936\t\tChowminya\t\t\t\t\t\t\t\t\t\tNone of the order retrieving any image from RIS/PACS but already having order image in PACS\t\t\n09/09/2014 PER090914 \t\tNijitha \t\t\t\t\t\t\t\t\t\t\tPerformance changes suggested by sunil \t\t\n26/11/2014 IN052645\t\t\tVijayakumar K\t26/11/2014\t Ramesh Goli\t\tClinical History â?? When user select any flow sheet option, \n19/03/2015\tIN052800\t\tKarthi L\t\t\t\t\t\t\t\t\t\tIf link image for Histology orderable, from CA, user not able to view the image. No link appear under View.\n09/10/2015\tIN055910\t\tKarthi L\t\t\t\t\t\t\t\t\t\tFrom Clinician Access, modified result shall be identified by include â??!â?? in Blue color\n04/11/2015\tIN057138\t\tKarthi L\t\t\t\t\t\t\t\t\t\tChief Complaint ( Long Text ) which has been recorded  from the Manage Patient ...  \n05/01/2016\tIN058144\t\tRamesh G\t\t\t\t\t\t\t\t\t\tFlowsheet uses too much blank spaces, display of date needs to be optimized. \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tProposed is for the time to use a second line to reduce column width\n11/01/2016\tIN58138\t\t\tKarthi L\t\t\t\t\t\t\t\t\t\tNeed to provide an alternative view to enable the quicksheet view by event and not by group.\n03/03/2016\tIN58489\t\t\tKarthi L\t\t\t\t\t\t\t\t\t\tWhen we open a radiology report in the clinical event history it opens a report for another radiology examination\n12/10/2016\tIN047572\t\tKarthi L\t\t\t\t\t\t\t\t\t\t[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the â??View Clinical Notesâ?? and â??Clinical Event Historyâ??\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n03/11/2016\tIN054151\t\tRamya M\t\t22/11/2016\t Karthi L\t\t\t12.X-Alpha-CA- Clinical Event History - Event Grouping\t\t\t\t\n07/03/2017\tIN063542\t\tRaja S\t\t\t10/03/2017\t\tRamesh G\t\tGHL-CRF-0460\n07/07/2017\tIN064688\t\tRaja S\t\t\t08/07/2017\t\tRameshG\t\t\tML-MMOH-SCF-0753\n07/11/2017\tIN064132\t\tRaja S\t\t\t\t07/11/2017\t\tRamesh G\tML-MMOH-CRF-0831\n07/02/2018\tIN065970\t\tVijayakumar K\t07/02/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970]\n07/03/2018\tIN065970\t\tVijayakumar K\t07/03/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970] reopen\n19/03/2018\tIN067037\t\tRaja S\t\t\t19/03/2018\t\tRamesh G\t\tML-BRU-SCF-1787\n06/06/2018\tIN067806\t\tRaja S\t\t\t06/06/2018\t\tRamesh G\t\tMO-CRF-20144\n02/01/2019      IN066453\t\tKamalakannan G  02/01/2019\t\tRamesh G\tML-BRU-CRF-0491\n4/02/2019       IN066453                Ramya Maddena           6/02/2019       Ramesh G\t\tML-BRU-CRF-0491\t   \t   \n08/02/2019 \tIN068560\t\tPrakash C    \t08/02/2019\t\tRamesh G\t\tML-MMOH-SCF-1078\n04/03/2019\tIN069028\t\tRamesh G\t\t04/03/2019\t\tRamesh G\t\tML-MMOH-CRF-1293\n13/03/2019\tIN069290\t\tRaja S\t\t\t13/03/2019\t\tRamehs G\t\tML-MMOH-CRF-1317\n21/03/2019\tIN067721\t\tRaja S\t\t\t21/03/2019\t\tRamesh G\t\tML-BRU-CRF-0516\n30/07/2019\tIN070610\t\tDinesh T\t\t30/07/2019\t\tRamesh G\t\tTBMC-CRF-0011.1\n06/08/2019\tIN071106\t\tDinesh T\t\t06/08/2019\t\tRamesh G\t\tML-MMOH-SCF-1341\n06/09/2019\tIN071127\t\tSivabagyam M\t06/09/2019\t\tRamesh G\t\tAlpha-RL-Unable to attach images for Interval test...\n21/10/2019\tIN069242\t\tSivabagyam\t\t\t22/10/2019\tRamesh Goli\t\t\tGHL-CRF-0567\n03/02/2020\tIN071561\t\tSIVABAGYAM M\t\t03/02/2020\t\tRAMESH G\t\tGHL-CRF-0558.1\n27/11/2020\t9071\t\t\tSIVABAGYAM M\t\t27/11/2020\t\tRAMESH G\tClinical Event History- Flowsheet \n15/12/2020\t7902\t\tSivabagyam M\t\t15/12/2020\t\tRamesh G\tMMS-DM-CRF-0180.1\n05/01/2021\t6030\t\tSivabagyam M\t\t05/01/2021\t\tRamesh G\tML-MMOH-CRF-1491\n15/01/2021\t7632\t\tSivabagyam M\t\t15/01/2021\t\tRamesh G\tML-MMOH-CRF-1261.1\n20/04/2021\t6484\t\t\tRamesh Goli\t\t20/04/2021\t\tRAMESH G\t\tMO-CRF-20147.7\n04/05/2021\t17012\t\tRamesh Goli\t\t\t\t\t\t\t\t\t\tML-MMOH-SCF-1779\n06/07/2021\t20155\t\tRamesh Goli\t\t\t\t\t\t\tML-MMOH-SCF-1830\n02/09/2021\t14801\t\t\tRAMESH\t\t\t\t\t\t\t\t\t\t\tSKR-SCF-1578\n16/08/2022\t29803\t\t\tRamesh G \t\t\t\t\t\t\t\t\t\tML-BRU-CRF-0635\n03/02/2020\t39052\t\t\tRamesh\t\t\t\t\t\t\t\t\t\t\tML-BRU-CRF-0634\n20/07/2023\t  24094\t   Ranjith P R\t\t21/07/2023\t\tRAMESH G\t\tML-MMOH-CRF-1804\n07/09/2023\t  31792\t   Ranjith P R\t\t08/09/2023\t\tRAMESH G\t\tML-MMOH-CRF-1913\n-----------------------------------------------------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="<!--IN064688 Added  math.*-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n\t<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </TITLE>\n\t<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n\t<META NAME=\"Author\" CONTENT=\"\">\n\t<META NAME=\"Keywords\" CONTENT=\"\">\n\t<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCA/js/FlowSheet.js\'></script><!--Moved from below to top IN070556 -->\n\t<script src=\'../../eCA/js/CAOpenExternalApplication.js\' language=\'javascript\'></script> <!-- added for IN047024 -->\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script> <!-- added for IN047024 -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<style>\n\tA:link\n\t{\n\t\tCOLOR: #FFFFFF;\n\t\tFONT-SIZE: 7PT;\n\t\tfont-family: Verdana;\n\t\tfont-weight:Bold;\n\t\ttext-align:left;\n\t}\n\tA:visited\n\t{\n\t\tCOLOR: #FFFFFF;\n\t\tFONT-SIZE: 7PT;\n\t\tfont-family: Verdana;\n\t\tfont-weight:Bold;\n\t\ttext-align:left;\n\t} \n\n\tTD.CAGREEN\n\t{\n\t\tFONT-SIZE: 9PT ;\n\t\tBACKGROUND-COLOR: #99CC00;\n\t\tBORDER-STYLE: SOLID;\n\t\tBORDER-LEFT-COLOR: #B2B6D7;\n\t\tBORDER-RIGHT-COLOR: #B2B6D7;\n\t\tBORDER-TOP-COLOR: #E2E3F0;\n\t\tBORDER-BOTTOM-COLOR: #E2E3F0;\n\t}\n\n\tTD.TD_BROWN\n\t{\n\t\tBACKGROUND-COLOR: BROWN;  \n\t\tCOLOR = WHITE;\n\t\tFONT-SIZE: 9pt ;\n\t\tBORDER-STYLE: SOLID;\n\t\tborder-left-color: #B2B6D7;\n\t\tborder-right-color: #B2B6D7;\n\t\tborder-top-color: #E2E3F0;\n\t\tborder-bottom-color: #E2E3F0;\n\t\theight:18;\t\n\n\t}\n\t/*IN067721 starts*/\n\t.gridDataChart\n\t{\n\tbackground-color: #FFFFFF;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:1px;\n\tborder-left:1px;\n\tborder-right:1px;\n\tborder-style:solid;\n\tborder-color:#949494;\n\t} \n\t/*IN067721 ends*/\n</style>\n\n<script language=\"VBScript\">\n\tSub callAviDcm(extn)\n\t\tOn Error Resume Next\n\t\tdim x\n    \tSet objNet = CreateObject(\"WScript.Shell\")\n\t\tif lcase(extn) = \"avi\" then\n\t\t\tx = objNet.Run(\"Z:\\Avi\\invokeavi.bat\",0) \n\t\tELSEIF lcase(extn) = \"dcm\" then\n\t\t\tx = objNet.Run(\"Z:\\DCM\\ShowDCM.bat\",0) \n\t\tend if\n\tend sub\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollFrame()\' onResize=\'alignDivs()\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'dataForm\' id=\'dataForm\'>\n\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t<table  width=\'100%\' id=\'dataTitleTable\' class=\'grid\' align=\'center\' >\n\t\t\t<TR>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<TH nowrap id=\'rowId";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  align=\"center\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</TH>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"rowIdT1";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"rowIdT2";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar rowValue = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n\t\t\t\t\t\t\tvar thRowId = document.getElementById(\'rowId\'+rowValue);\n\t\t\t\t\t\t\tthRowId.colSpan += 1;\n\t\t\t\t\t\t\tdocument.getElementById(\'rowIdT1\'+rowValue).value =\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\t\t\t\t//thRowId.align = \"center\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</TR>\n\t\t\t<TR>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<TH nowrap id=\'visID";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ><a href=\"javascript:collapseColumn(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\" title=\'Click here to collapse the column\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</a><br></TH>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="<input type=\"hidden\" id=\"cellID";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</TR>\n\t\t</table>\n\t</div>\n\t<table width=\'100%\' id=\'dataTable\' class=\'grid\' align=\'center\' height=\'parent.offsetHeight\'>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n\t<TR>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<TH style=\'visibility:hidden\' id=\'visIDup";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;</TH>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</TR>\n\t</table>\n\t\t<input type=\'hidden\' name=\'txtFlagComments\' id=\'txtFlagComments\' value=\"N\">\n\t\t<input type=\'hidden\' name=\'txtFlagQuickText\' id=\'txtFlagQuickText\' value=\"N\">\n\t\t<input type=\'hidden\' name=\'totRows\' id=\'totRows\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\'hidden\' name=\'totCols\' id=\'totCols\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\'hidden\' name=\'finalTotCols\' id=\'finalTotCols\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenColumns\' id=\'hiddenColumns\' value=\"\">\n\t\t<input type=\'hidden\' name=\'lastDateTime\' id=\'lastDateTime\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'firstDateTime\' id=\'firstDateTime\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'queryStringForComments\' id=\'queryStringForComments\' value=\"\">\n\t\t<input type=\'hidden\' name=\'graphorder\' id=\'graphorder\' value=\"\">\n\t\t<input type=\'hidden\' name=\'flowsheetCompId\' id=\'flowsheetCompId\' value=\"\">\n\t\t<input type=\'hidden\' name=\'errorEvent\' id=\'errorEvent\' value=\"\">\n\t\t<input type=\'hidden\' name=\'graphValuesOnChk\' id=\'graphValuesOnChk\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'viewConfRes\' id=\'viewConfRes\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'allDatesForGraph\' id=\'allDatesForGraph\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=\'hidden\' name=\'noOfGroups\' id=\'noOfGroups\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t<input type=\'hidden\' name=\'enc_id\' id=\'enc_id\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=\'hidden\' name=\'flowsheet_Id\' id=\'flowsheet_Id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=\'hidden\' name=\'event_code\' id=\'event_code\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=\'hidden\' name=\'event_class\' id=\'event_class\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=\'hidden\' name=\'event_group\' id=\'event_group\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\'hidden\' name=\'event_date_time\' id=\'event_date_time\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=\'hidden\' name=\'hist_rec_type\' id=\'hist_rec_type\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t<input type=\'hidden\' name=\'abnormal\' id=\'abnormal\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t<input type=\'hidden\' name=\'view_conf_res\' id=\'view_conf_res\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t<input type=\'hidden\' name=\'error_event\' id=\'error_event\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=\'hidden\' name=\'graph_order\' id=\'graph_order\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t<input type=\'hidden\' name=\'narmalcy\' id=\'narmalcy\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"hidden\" name=\"fac_id\" id=\"fac_id\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><!--IN033489-->\n\t\t<input type=\"hidden\" name=\"enctr_id\" id=\"enctr_id\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'><!--IN033489-->\n\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'><!--31792-->\n\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'><!--31792-->\n\t\t<input type=\"hidden\" name=\"hist_rec_type\" id=\"hist_rec_type\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'><!--31792-->\n\t\t\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n</form>\n</body>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\'  style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'yellow\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' class=\'gridTooltipData\' id=\'t\' nowrap></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n\t<div id=\'moredetailMode\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n</html>\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\n<script>\n\tparent.unitFrame.document.forms[0].innerHTML = parent.unitFrame.document.forms[0].innerHTML + \"<div id=\'extraTD\' style=\'position:absolute; width:30%; visibility:hidden;\'></div>\";\n\tsetTimeout(\"alignUnitsAndData()\",200);\n\tsetTimeout(\"alignHeight()\",300);\n\tvar curidx  = eval(parent.controlsFrame.document.forms[0].cur_idx_value.value);\n\tvar totidx  = eval(parent.controlsFrame.document.forms[0].idx_value.value);\n\n\tif(curidx == 0)\n\t{\n\t\tparent.controlsFrame.document.forms[0].prev.disabled = true;\n\t\tparent.controlsFrame.document.forms[0].first.disabled = true;\n\t}\n\telse if(curidx > 0)\n\t{\n\t\tparent.controlsFrame.document.forms[0].prev.disabled = false;\n\t\tparent.controlsFrame.document.forms[0].first.disabled = false;\n\t}\n\n\tif((curidx+1) >= totidx)\n\t{\n\t\tparent.controlsFrame.document.forms[0].next.disabled = true;\n\t\tparent.controlsFrame.document.forms[0].last.disabled = true;\n\t}\n\telse \n\t{\n\t\tparent.controlsFrame.document.forms[0].next.disabled = false;\n\t\tparent.controlsFrame.document.forms[0].last.disabled = false;\n\t}\n</script>\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );
	
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


//IN071106, starts
private String extractSpecimenNumber(String str, String firstSplitter, String secondSplitter)
{
	if(str!=null && str.length()>0)
		return str.substring(str.indexOf(firstSplitter)+1, str.indexOf(secondSplitter));
	return "";
}
//IN071106, ends


	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~ ");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		/*if(resultStr.indexOf("'")!=-1) //ML-BRU-SCF-1642 - IN057138 - Start
			resultStr = resultStr.replaceAll("'","`"); 
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|"); */
		if(resultStr.indexOf("\\")!=-1) 
			resultStr = resultStr.replaceAll("\\\\","&#92");
		if(resultStr.indexOf("|")!=-1) 
			resultStr = resultStr.replaceAll("\\|","&#124");
		if(resultStr.indexOf("`")!=-1) 
			resultStr = resultStr.replaceAll("`","&#96");			
		if(resultStr.indexOf("'")!=-1) 
			resultStr = resultStr.replaceAll("'","&#39");
		if(resultStr.indexOf("~")!=-1) 
			resultStr = resultStr.replaceAll("~","&#126");
		if(resultStr.indexOf("\"")!=-1) 
			resultStr = resultStr.replaceAll("\"","\\\"");		
		if(resultStr.indexOf("+")!=-1) 
			resultStr = resultStr.replaceAll("\\+","&#43");	//ML-BRU-SCF-1642 - IN057138 - End
		return resultStr;
	}

	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String strMoreDlt)//IN033489
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt)//IN033489 //commented for Bru-HIMS-CRF-052.1 [IN037793]
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt) //modified for Bru-HIMS-CRF-052.1 [IN037793] - commented for IN047204
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,boolean isSiteSpecificForLabPrint,String html_image_upld_id) //IN047204  //Add html_image_upld_id for IN069028//IN070610
	//IN069242 Start.
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, int image_count, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,boolean isSiteSpecificForLabPrint,String html_image_upld_id, Boolean uploadFuncTrOrders, String uploaded_doc_cnt) //IN047204  //Add html_image_upld_id for IN069028//IN070610//IN071127
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, int image_count, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,String restricting_print,String html_image_upld_id, Boolean uploadFuncTrOrders, String uploaded_doc_cnt) //7902
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, int image_count, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,String restricting_print,String html_image_upld_id, Boolean uploadFuncTrOrders, String uploaded_doc_cnt,String ext_img_disable,String study_id,String ext_img_display,String param_def_str,String resultStatus, String modified_date_YN, String tempDisplaymodified_date_YN) //7902  //resultStatus added for 29803 //24094
	HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, int image_count, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,String restricting_print,String html_image_upld_id, Boolean uploadFuncTrOrders, String uploaded_doc_cnt,String ext_img_disable,String study_id,String ext_img_display,String param_def_str,String resultStatus, String modified_date_YN, String tempDisplaymodified_date_YN, String lv_neonate_spec_yn, String tempDisplaylv_neonate_spec_yn,Boolean isSiteSpecificNeonatalMotherSpecimen ) //7902  //resultStatus added for 29803 //24094//31792
	
	//IN069242 End.
	{
		int i = prevK;
		int j = columnNumber;

		String tempToolTip = toolTip.replace('\'',' ');

		String tempString = "";
		String classValue = "";
		String classValueGrn = "";
		String tempStrValue = "";
		String tempOnMouseOver = "";
		String displayStyle = "gridDataChart";
		
		HashMap returnMap = new HashMap();
		//Bru-HIMS-CRF-195.3 - IN047205 - Start
		eCA.CAExternalLinkDataDTO externalDataDTO = null; 
		eCA.CAEncounterList oEncounterList = new eCA.CAEncounterList();  
		
		String ext_image_appli_id = "";
		String ext_image_obj_id = "";
		String ext_image_source = "";
		String ext_srce_doc_ref_no = "";
		String ext_srce_doc_ref_line_no = "";
		ArrayList externalList = null;
		//Bru-HIMS-CRF-195.3 - IN047205 - End
		String labResultModifiedNotifier = ""; //HSA-CRF-0257.1
		classValue = "CACHARTQRYEVEN";
		
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
		else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`") && extApplID.equals("CPACS"))
		{
			ext_img_disable="disabled";
			ext_img_display="Study ID not available, we cannot Proceed";
		}
		else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
		{
			ext_img_disable="";
			ext_img_display="";
		}

		if(keyList.contains(enctr_id+"`"+histRecType+"`"+sysID+"`"+accessionNum+"`"+sysEventCode))
			displayStyle = "gridDataSelect";
		else
			displayStyle = "gridDataChart";

		if(histDataType.equals("NUM"))
		{
			//tempValue =tempValue+"<input type='hidden' name='resultNum' id='resultNum' value='"+tempValue+"'>"; //HSA-CRF-0257.1
			tempValue =tempValue+"<input type='hidden' name='resultNum' id='resultNum' value='"+resultNum+"'>"; //HSA-CRF-0257.1
			if(!tempAdditional.equals("")) //if there is any STR
			{
				tempAdditional=replaceSpecialChar(tempAdditional.trim());
				//IN058144 Start.
				/*if(tempAdditional.length() > 10)
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional.substring(0,9)+"...</i></a>";
				else
					tempValue =tempValue+"&nbsp;<i>" +tempAdditional+"</i>";
				*/
				if(tempAdditional.length() > 11)//IN069290(4->11)
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional.substring(0,10)+"..</i></a>";//IN069290(3->10)
				else
					tempValue =tempValue+"&nbsp;<i>" +tempAdditional+"</i>";
				//IN058144 End.
			}
			if(!textCount.equals("0"))//if there is any TXT
			{
				//tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' style='display:inline' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";//IN031989
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' style='display:inline' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
				//IN031989//IN033489
			}
		}
		else if(histDataType.equals("TXT") || histDataType.equals("HTM"))
		{
			// added for IN041014 - Start 
			if(!tempAdditional.equals("")) //if there is any STR
			{	
				tempAdditional=replaceSpecialChar(tempAdditional.trim());
				/*if(tempAdditional.length() > 10)
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional.substring(0,9)+"...</i></a>";
				else
					tempValue =resultNum+"&nbsp;<i>" +tempAdditional+"</i>";
				*/ 	// commentd for BRUNEI LIVE ISSUE
			}
			// added for IN041014  - End
			if(!textCount.equals("0"))
			{
				//tempValue = "<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";//IN031989
				//tempValue = "<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
				//IN031989//IN033489 // commented for IN041014
				 tempValue = tempValue+ "&nbsp;" +"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">"; // modified for IN041014 //24094
				//24094 starts
				 if(modified_date_YN.equals("Y")){
				 tempValue = tempValue+ "<img src='../../eCA/images/modifiedresult.png'/>";
			   
				}else{
					 tempValue = tempValue+ "";
					  
				}
				 //24094 ends
			}
		}
		else if(histDataType.equals("STR"))
		{
			//IN058144 Start.
			/*if(tempValue.length() > 15)
			{
				tempStrValue = tempValue.substring(0,14);
			*/
			if(tempValue.length() > 4)
			{
				//IN069290 starts 
				if(tempValue.length() > 11)
					tempStrValue = tempValue.substring(0,10);
				else
					tempStrValue = tempValue;
				//tempStrValue = tempValue.substring(0,3);
				//IN069290 ends
			//IN058144 Start.
				tempValue = replaceSpecialChar(tempValue);
				//tempValue=java.net.URLEncoder.encode(tempValue);//ML-BRU-SCF-1642 - IN057138  //14801 commented
				tempValue = "<a  href=\"javaScript:ShowComments('"+tempValue+"')\"><font size='1' color='black'>"+tempStrValue+"..</a><br>";
			}
			if(!normalcy_str.equals(""))
			{
				tempValue = tempValue + " <font color=blue>( Normal Value : " + normalcy_str + " )</font>";
			}
			if(!textCount.equals("0"))//in case of STR if any TXT is there
			{
				//tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";//IN031989
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
				//IN031989//IN033489
			}
		}
		//HSA-CRF-0257.1 IN055910 - Start
		if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(strStatus)) {
			labResultModifiedNotifier = "<img id='modified_icon' style='display:inline' src='../../eCA/images/modifiedresult.png' alt='Result Modified'>" + "&nbsp;";	
			tempValue = labResultModifiedNotifier + tempValue;
		}
		//HSA-CRF-0257.1 IN055910 -End
		
		if(!tempValue.equals(""))
		{
			if(!called_from.equals("OR"))
			{
				if(quickTextCount.equals("0"))
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' style='display:none' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
				else
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
			}
			if(!called_from.equals("OR"))
			{
				if(strStatus.equals("E"))
				{
					 //IN066453 start
					//IN069242 Start.
					//if(isSiteSpecificForLabPrint && "LBIN".equals(histRecType)){
					if("Y".equals(restricting_print)){
					//IN069242 End.
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"'" ;
					}else{
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"')\"" ;
					}
					//IN066453 end
				}
				else if(strNormalcyInd.equals("I") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					 //IN066453 start
					 //IN069242 Start.
					//if(isSiteSpecificForLabPrint && "LBIN".equals(histRecType)){
					if("Y".equals(restricting_print)){
					//IN069242 End.
						tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center' ";
					}else{
	             		//tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"')\"";
						tempString = tempString + "<TD  class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"')\"";
						
					}
					 //IN066453 end
				}
				else if(strNormalcyInd.equals("C") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					//IN066453 start
					//IN069242 End.
					//if(isSiteSpecificForLabPrint && "LBIN".equals(histRecType)){
					if("Y".equals(restricting_print)){
					//IN069242 End.
						tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center' ";
					}else{
						tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"')\"";
					}
					 //IN066453 end
				}
				else
				{
					//IN066453 start
					//IN069242 Start.
					//if(isSiteSpecificForLabPrint && "LBIN".equals(histRecType)){
					if("Y".equals(restricting_print)){
					//IN069242 End.
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"'";
					}else{
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"')\"";
					}
					 //IN066453 end
				}
			}
			else
			{
				if(strStatus.equals("E"))
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
				else if(legend_type.equals("S"))
				{
					 //IN066453 start
					//IN069242 Start.
					//if(isSiteSpecificForLabPrint && "LBIN".equals(histRecType)){
					if("Y".equals(restricting_print)){
					//IN069242 End.
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"'";
					}else{
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"')\"";
					}
					 //IN066453 end
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
				}
				else if(legend_type.equals("C"))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					//IN066453 start
					//IN069242 End.
					//if(isSiteSpecificForLabPrint && "LBIN".equals(histRecType)){
					if("Y".equals(restricting_print)){
					//IN069242 End.
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"'";
					}else{
						tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"')\"";
					}
					 //IN066453 end
				}
				else
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
			}
		}
		else
		{
			if(strStatus.equals("E"))
			{
				tempString = tempString + "<TD align='center' class='TD_BROWN' id='visibility"+i+"ID"+j+"' ";
			}
			else
			{
				tempString = tempString + "<TD align='center' class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' ";				
			}
		}

		if(!tempToolTip.equals("") || !toolTip_ind.equals(""))
		{
			tempOnMouseOver="onMouseOver=\"displayToolTip('"+tempToolTip+"','"+toolTip_ind+"','"+i+"','"+j+"')\" onMouseOut =hideToolTip('"+i+"','"+j+"')";
			 tempString = tempString + tempOnMouseOver;
		}
		
		if(tempValue.equals("")) 
		{
			tempValue = "&nbsp;";
		}

		
		if(!extApplID.equals(""))
		{
			if(!("DMS").equals(extApplID)) { // IN049533
				if(!("DOCUL").equals(extApplID) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))  // modified for IN040237 - START
				//if(!("DOCUL").equals(extApplID)) //Condition added for EMG // modified for IN040237
				{
					//IN050936 included patient_id
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif' "+ext_img_disable+"  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+extImgID+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\" alt='"+ext_img_display+"' > ";//7902
				}
				else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
				{
					//IN050936 included patient_id
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif' "+ext_img_disable+"   onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\" alt='"+ext_img_display+"' > ";//7902
				}
				else if (!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
					//if(!recCountInt.equals(null) && !recCountInt.equals("")) {  IN071127
						//int recordcount = Integer.parseInt(recCountInt);//IN071127
						if(image_count > 0) //IN071127
						{	
							tempValue =tempValue+"&nbsp;"+"<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
						}
					//}		
				}
			} // IN049533
		}
		// added for IN047204 - Start
		//IN069028 Start.
		if(!html_image_upld_id.equals(""))
		{
			tempValue = tempValue + "&nbsp;"+ "<img src='../../eCA/images/IniAss.png' onClick=\"return getFile_SH('"+java.net.URLEncoder.encode(accessionNum)+"')\">";
		}
		//IN069028 End.
		if("Y".equals(dmsExternalLinkYN)){// && "RD".equals(event_code_type)) {
			//Bru-HIMS-CRF-195.3 - IN047205 - Start
			try {
				externalList = oEncounterList.getExternalLinkdata(histRecType, sysID, accessionNum, sysEventCode); 
				Iterator iter = externalList.iterator();
				while(iter.hasNext()){
					externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
					ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
					ext_image_obj_id = externalDataDTO.getExt_image_obj_id();
					ext_image_source = externalDataDTO.getExt_image_source();
					ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
					ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();
					//tempValue =tempValue+"&nbsp;"+"<img src='../../eCommon/images/ExternalDocument.PNG'  title='External Link' onClick=\"return getExtLink('"+strPatientId+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+patient_class+"','"+loc_desc+"')\">";//IN47847 Added title to img tag -- commented for //Bru-HIMS-CRF-195.3 - IN047205 
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCommon/images/ExternalDocument.PNG'  title='External Link' onClick=\"return getExtLink('"+strPatientId+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+patient_class+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"; //Bru-HIMS-CRF-195.3 - IN047205
				}	
			} catch(Exception ex ){
				System.out.println(" 1517,FlowSheetEventsData.jsp => " + ex.getMessage());
			}
		}
		// added for IN047204 - End
		/* commented for IN040237
		// added for Bru-HIMS-CRF-052.1 [IN037793]
		if(!recCountInt.equals(null) && !recCountInt.equals("")) {
			int recordcount = Integer.parseInt(recCountInt);
			if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recordcount > 0) {
				tempValue =tempValue+"&nbsp;"+"<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
			}
		}
		*/	
		//IN070610, starts
		String l_upload_view = "N";
		Integer l_rec_cnt = 0;
		
		if(uploadFuncTrOrders)
			l_rec_cnt = Integer.parseInt(uploaded_doc_cnt);
		
		
		if(l_rec_cnt > 0 && "TRET".equals(histRecType) && uploadFuncTrOrders)
		{
			l_upload_view = "Y";
		}				
		
		if("Y".equals(l_upload_view))								
			tempValue = tempValue + "<a style='cursor:pointer;color:blue' onClick=\"uploadedDocuments('"+accessionNum+"','"+eventCode+"')\"><img src='../../eOR/images/DOCUL.gif' width='16' height='16' border=0 alt='Uploaded Documents'/></a>";
		//IN070610, ends
		if(strStatus.equals("P") || resultStatus.equals("4"))
			tempValue = tempValue+" <font color='red'>(Preliminary)</font>";

		if(!deltaFailInd.equals(""))
		{
			tempValue = tempValue+"<font color='red'>["+deltaFailInd+"]</font>";
		}
		if((strNormalcyInd.equals("I") || strNormalcyInd.equals("B") )&& !strNormalcyInd.equals("") && !colorCellInd.equals("NONE"))
		{
			//tempValue = tempValue+ "<font color='black'><b>["+descCellInd+"]</b></font>";
		}
		//31792 starts
		if(isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){
		tempString = tempString + ">"+tempValue+"&nbsp;<img style='cursor:pointer;' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails('"+order_id+"','"+strPatientId+"','"+accessionNum+"','"+histRecType+"')\"><br>"+strMoreDlt+"</TD>";
		}
		else
		{
			tempString = tempString + ">"+tempValue+"&nbsp;<br>"+strMoreDlt+"</TD>";
				
		}
		//31792 ends
		try
		{
			returnMap.put("tempString"+i+"Map"+j,tempString);
			returnMap.put("histRecType"+i,histRecType);
			returnMap.put("eventClass"+i,eventClass);
			returnMap.put("eventGroup"+i,eventGroup);
			returnMap.put("eventCode"+i,eventCode);
			returnMap.put("eventDateTime"+i+"Map"+j,eventDateTime);
			returnMap.put("resultNum"+i+"Map"+j,resultNum);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return returnMap;
	}// end of drawTD


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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String query_string = request.getQueryString();
	String strEncId ="";  
	String strPatientId = "";
	String strEncounterId ="";
	String beanKeyEncId = "";
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");	//IN058144
	SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");	//IN058144
	SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");	//IN058144
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");	
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");	// IN047204
	String ext_facility_id= (String) session.getValue("facility_id"); // IN047204
	strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String login_user = (String)session.getValue("login_user"); // added for Bru-HIMS-CRF-052.1 [IN037793]
	beanKeyEncId = strEncId;
	strPatientId = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+strPatientId+beanKeyEncId,"eCA.PatientBannerGroupLine",session);
	
	//IN070610, starts
	ArrayList<String> funcIds = new ArrayList<String>();
	funcIds.add("UPLOAD_TR_CATEGORY_ORDERS");
	manageEmailBean.adapter.setSiteSpecific(funcIds,"OR");
	Boolean uploadFuncTrOrders = manageEmailBean.adapter.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
	//IN070610, ends

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String strFromDate  = "";
		String strToDate = "";

		String strHistRecType = "";
		String strEventClass ="";
		String strEventGroup = "";
		String strEventCode  = "";
		String strFacilityId ="";

		String strEpisodeType ="";
		String strNormalcyInd ="";
		String strAbnormal ="";
		String strFlowSheetId ="";
		String strViewConfRes ="";
		String strGraphOrder ="";
		String called_from ="";
		String strErrorEvent ="";
		String prevHistRecType = "";
		String prevEventClass = "";
		String prevEventGroup = "";
		String prevEventCode = "";
		String legend_type = "";
		String normalcy_str = "";
		String fac_id = "";//IN033489  
		String dmsExternalLinkYN = ""; //IN047204
		String ext_img_disable="",study_id="",ext_img_display="",param_def_str="";//7902
		ArrayList keyList = manageEmailBean.returnList2();
		PreparedStatement pstmtImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
		ResultSet resImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
		PreparedStatement pstmtImgView1 = null; //7902
		ResultSet resImgView1 = null;//7902
		
		PreparedStatement pstmtImgCount = null; // [IN037793]
		ResultSet rsetImgCount = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
		CallableStatement cs=null;//IN071127
		PreparedStatement pstmtPerFacId = null; // IN040866
		ResultSet rsetPerFacId = null;  // IN040866
		
		PreparedStatement pstmtOrderId = null; // IN047204
		ResultSet rsetOrderId = null;  // IN047204
		//IN064132 changes starts
		String resulted_practitioner = "";
		boolean isPracSiteSpecific = false;
		boolean isViewLabRes=false;//IN069290
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER"); //Added for IN064132
		isViewLabRes=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","ORDERBY_BASEDON_LAB_SEQ");//IN069290
		//IN064132 changes ends
		//IN069290 starts
		boolean isVerifiedSiteSpec = false;
		isVerifiedSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VERIFIEDBY_PRACTITIONER"); 
		//IN069290 ends
		//IN067806 changes starts
		boolean isDisToolTipStr = false;
		isDisToolTipStr = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","DIS_STR_TOOLTIP"); 
		boolean restrict_rd	=false;	//IN071561
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		boolean isSiteSpecificNeonatalMotherSpecimen=false;//31792
		isSiteSpecificNeonatalMotherSpecimen = eCommon.Common.CommonBean.isSiteSpecific(con,"OR","NEONATAL_MOTHER_SPECIMEN");//31792
		//IN067806 changes ends
		int prevK = 0;	
		int nIndex =1;
		String orderByEventCode = request.getParameter("p_order_by_evtcode")==null?"N":request.getParameter("p_order_by_evtcode");  // INT-CRF-BRU-CIS-004 - IN058138
		dmsExternalLinkYN = manageEmailBean.getExternalDmsLinkYN(ext_facility_id); //IN047204 
		String clinician_id			= (String) session.getValue("ca_practitioner_id");//IN042552
		String resp_id = (String)session.getValue("responsibility_id"); //IN042552
		strNormalcyInd = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");				
	  
		strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
		strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
		strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
		strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");
		strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
		strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
		strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
		strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
		strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
		strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
		strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
		strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
		strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
		called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
		String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//CHL_CRF_0044
	    String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//CHL_CRF_0044
	    String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
		String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]		
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
		StringBuffer strBuffDates = new StringBuffer();
		StringBuffer sqlData	  = new StringBuffer();
		StringBuffer sbQryCriteria = new StringBuffer();
  
		ArrayList dateList = new ArrayList();
		StringBuffer allDatesForGraph = new StringBuffer();
		String lastDateTime = "";
		String firstDateTime = "";

		HashMap tempSessionMap = null;
		HashMap tempTDMap = null;
		HashMap tempTRMap = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sbQryCriteria.append(" a.patient_id = ? ##ORDERTYPERESULT## ");

		if(!strHistRecType.equals(""))
			sbQryCriteria.append(" and a.hist_rec_type = ? ");

		if(!strEventClass.equals(""))
			sbQryCriteria.append(" and a.event_class = ? ");

		if(!strEventGroup.equals(""))
		{
			sbQryCriteria.append(" and (a.event_group is null or a.event_group = ? ) ");
		}

		if(!strEventCode.equals(""))
			sbQryCriteria.append(" and a.event_code = ? ");

		if(!strFromDate.equals(""))
			sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

		if(!strToDate.equals(""))
			sbQryCriteria.append("and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287"); //adding 59 seconds more to the todate

		if(!strFacilityId.equals(""))
			sbQryCriteria.append(" and a.facility_id = ? ");

		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class=? ");
		}
		//IN035950 End
		if(!strEncounterId.equals(""))
			sbQryCriteria.append(" and a.encounter_id = ? ");

		if (!strEpisodeType.equals("") )
			sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

		if(strAbnormal.equals("Y"))
	    {
			sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}

		if(strViewConfRes.equals("X"))
			//sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z'  ");//VICHAYUT DEMO Issue
			sbQryCriteria.append("and nvl(a.PROTECTION_IND,'N')!='Z'  ");//VICHAYUT DEMO Issue
		//sbQryCriteria.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); //IN042552 //common-icn-0180
		sbQryCriteria.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); //IN042552//common-icn-0180
		
		if(strErrorEvent.equals("Y"))//dont'include error events
			sbQryCriteria.append(" and nvl(a.STATUS,'`') != 'S'  ");
		else 
		   sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')"); 
		//IN071561 starts
		if(restrict_rd){
			//sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");//common-icn-0180
		sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,?)='N' ");//common-icn-0180
		}
		//IN071561 ends
		try
		{
			strBuffDates.append("Select to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a ");
			strBuffDates.append("where  "+sbQryCriteria.toString());

			if(!strFlowSheetId.equals("")){
				//strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;//Commented for IN063542
				strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE AND (f.event_code = a.event_code or f.event_code = a.EVENT_GROUP)) ") ; //Added for IN063542
			}
			strBuffDates.append(" Order by to_date(event_date,'dd/mm/yyyy hh24:mi')  "+strGraphOrder);
		
			tempSessionMap = new HashMap();
			tempTDMap = new HashMap();
			//39052 Start.
			String  strBuffQuery = strBuffDates.toString();
			if("CA01".equals(order_type_3T)){
				strBuffQuery=strBuffQuery.replaceAll("##ORDERTYPERESULT##"," AND 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4) ");				
			}else{
				strBuffQuery=strBuffQuery.replaceAll("##ORDERTYPERESULT##","");
			}
			//39052 End.
			pstmt = con.prepareStatement(strBuffQuery);

			pstmt.setString(nIndex++,strPatientId);

			if(!strHistRecType.equals(""))
			{
				pstmt.setString(nIndex++,strHistRecType);
			}

			if(!strEventClass.equals(""))
			{
				pstmt.setString(nIndex++,strEventClass);
			}

			if(!strEventGroup.equals(""))
			{
				pstmt.setString(nIndex++,strEventGroup);
			}

			if(!strEventCode.equals(""))
			{
				pstmt.setString(nIndex++,strEventCode);
			}

			if(!strFromDate.equals(""))
			{
				pstmt.setString(nIndex++,strFromDate);
			}

			if(!strToDate.equals(""))
			{
				pstmt.setString(nIndex++,strToDate);
			}
		
			if(!strFacilityId.equals(""))
			{
				pstmt.setString(nIndex++,strFacilityId);
			}
			//IN035950 Start
					if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
					{
						pstmt.setString(nIndex++,eventClasswidget);
					}
			//IN035950 Ends
			if(!strEncounterId.equals(""))
			{
				pstmt.setString(nIndex++,strEncounterId);
			}
	
			if(!strEpisodeType.equals("") )
			{
				if(strEpisodeType.equals("I"))
					pstmt.setString(nIndex++,"IP");
				else if(strEpisodeType.equals("O"))
					pstmt.setString(nIndex++,"OP");
				else if(strEpisodeType.equals("D"))
					pstmt.setString(nIndex++,"DC");
				else if(strEpisodeType.equals("E"))
					pstmt.setString(nIndex++,"EM");
				else if(strEpisodeType.equals("X"))
					pstmt.setString(nIndex++,"XT");
			}
			pstmt.setString(nIndex++,clinician_id);//common-icn-0180
			pstmt.setString(nIndex++,resp_id);//common-icn-0180
			//common-icn-0180 starts
			if(restrict_rd){
			pstmt.setString(nIndex++,login_user);
			}
			//common-icn-0180 ends
			if(!strFlowSheetId.equals(""))
			{
				pstmt.setString(nIndex++,strFlowSheetId);

			}
		
			rs = pstmt.executeQuery();

			String strTempDt = "";

			while(rs.next())
			{
				if(dateList.size() == 0)
				{
					firstDateTime = rs.getString(1);
				}
				if(dateList.size() < 10)
				{
					if(!dateList.contains(rs.getString(1)))
					{
					   strTempDt = rs.getString(1);
					   dateList.add(strTempDt);
					   allDatesForGraph.append(com.ehis.util.DateUtils.convertDate(strTempDt,"DMYHM","en",locale)+"$$");
					}
				}
				else
				{
					lastDateTime = rs.getString(1);
				}
			}

			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();

			if(called_from.equals("OR"))
			{
				pstmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM");
				rs = pstmt.executeQuery();
				if(rs.next())
					legend_type = rs.getString("LEGEND_TYPE") == null ? "S" : rs.getString("LEGEND_TYPE");
				if(rs!= null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
		}//end of try-1
		catch(Exception e)
		{
			//out.println("Exception in try-1 of FlowSheetEventsData.jsp -"+e.toString());
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{}

            _bw.write(_wl_block10Bytes, _wl_block10);

				//IN058144 Start.
				String currentDate ="";
				String strHeadConvDt = "";
				int index=0;
				int actualIndex = 0;
				int ii = 0;
				int headDateListSize = dateList.size();
				for(int r=0;r<headDateListSize;r++)
				{
					strHeadConvDt = com.ehis.util.DateUtils.convertDate((String)dateList.get(r),"DMYHM","en",locale);
					strHeadConvDt = format.format(format.parse(strHeadConvDt));
					if(!currentDate.equals(strHeadConvDt)){
						ii=1;
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strHeadConvDt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ii ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strHeadConvDt));
            _bw.write(_wl_block16Bytes, _wl_block16);

						currentDate = strHeadConvDt;
						actualIndex = index;
						index++;
					}else{
						ii++;
						
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(actualIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ii));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
					}
				}
			
            _bw.write(_wl_block20Bytes, _wl_block20);

				//IN058144 End.
				String strConvDt = "";
				int dateListSize = dateList.size();
				//IN058144 Start.
				String oldDateCol = "";
				String currentDateCol = "";
				int refValue = 0;
				int temprefValue=0;
				//IN058144 End.
				for(int i=0;i<dateListSize;i++)
				{
					strConvDt = com.ehis.util.DateUtils.convertDate((String)dateList.get(i),"DMYHM","en",locale);
					//IN058144 Start.
					currentDateCol = format.format(format.parse(strConvDt));
					strConvDt=format2.format(format1.parse(strConvDt));
					
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strConvDt));
            _bw.write(_wl_block24Bytes, _wl_block24);

					if(!oldDateCol.equals(currentDateCol)){						
						oldDateCol =currentDateCol;						
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(refValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);

						temprefValue = refValue;
						refValue++;
					}else{
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(temprefValue ));
            _bw.write(_wl_block26Bytes, _wl_block26);

					}

					
 
					//IN058144 End.
				}

            _bw.write(_wl_block27Bytes, _wl_block27);

	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id,  CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,'"+locale+"')  GetTooltip, a.STATUS stat,replace(d.short_desc,'''','') sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') performed_by,a.encounter_ID, a.normalcy_str From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e ");//IN033489
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id,  CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,'"+locale+"')  GetTooltip, a.STATUS stat,replace(d.short_desc,'''','') sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e ");//IN033489//IN037900  //Bru-HIMS-CRF-052.1 [IN037793]
		//PER0409 - removed '"+locale+"' from below query (3 places)
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,replace(d.short_desc,'''','') sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e"); // modified for Bru-HIMS-CRF-052.1 [IN037793] -a.EVENT_CODE_TYPE added for IN047204
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,(select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a "); //PER090914 -commented for // KAUH-SCF-0252 IN058489
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g "); // modified for KAUH-SCF-0252 IN058489 // added PR_ENCOUNTER g for MMS-QH-CRF-0177 [IN047572]
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind, normal_low ,normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g "); // modified for KAUH-SCF-0252 IN058489 // added PR_ENCOUNTER g for MMS-QH-CRF-0177 [IN047572] //Commented for IN064132
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind, normal_low ,normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g "); // modified for IN064132 //Commented for IN067037
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g "); // modified for IN067037//comitted for IN066453
	//IN069028 Start.
	//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453
	//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453
	//IN069028 End.
	//IN070610, starts
	//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453
	if(uploadFuncTrOrders){
		//IN069242 Start.
		//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt  From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453
		if(!isViewLabRes){
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print  From cr_encounter_detail a, PR_ENCOUNTER g ");//6030
			//6484 Start.
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type   From cr_encounter_detail a, PR_ENCOUNTER g ");//6030
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus   From cr_encounter_detail a, PR_ENCOUNTER g ");
			//6484 end.
			sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus, to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date, NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn    From cr_encounter_detail a, PR_ENCOUNTER g ");//24094//31792
			
		}else{
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no   From cr_encounter_detail a, PR_ENCOUNTER g ");//6030
			//6484 Start.
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type   From cr_encounter_detail a, PR_ENCOUNTER g ");//6030
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus   From cr_encounter_detail a, PR_ENCOUNTER g ");
			//6484 end.
			sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus, to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date, NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn ,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn    From cr_encounter_detail a, PR_ENCOUNTER g ");//24094//31792
			
		}
		//IN069242 End.
	}else{
		//IN069242 Start.
		//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID  From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453
		
		if(!isViewLabRes){
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print  From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453//6030
			//6484 Start.
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type  From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453//6030
	        //sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus  From cr_encounter_detail a, PR_ENCOUNTER g ");
	        //6484 End.
	        sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus, to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date, NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn   From cr_encounter_detail a, PR_ENCOUNTER g "); //24094//31792
	        
		}else{ 
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453//6030
			//6484 Start.
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type  From cr_encounter_detail a, PR_ENCOUNTER g "); // added for IN066453//6030
			//sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus  From cr_encounter_detail a, PR_ENCOUNTER g");
			//6484 End.
			sqlData.append("Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER,a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or NVL(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type, a.HTML_IMAGE_UPLD_ID HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus, to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date, NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn   From cr_encounter_detail a, PR_ENCOUNTER g"); //24094//31792
			
		}		
				
		//IN069242 End.
	}//IN070610, ends
	if (!strFlowSheetId.equals(""))
		sqlData.append(" ,ca_flow_sheet_item f ");

		//sqlData.append(" where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class= a.event_class and   d.hist_rec_type=a.hist_rec_type and  d.event_code=a.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE ");//PER090914
		sqlData.append(" WHERE");//PER090914

    if(!strFlowSheetId.equals("")){ 
		//sqlData.append("  f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  ") ;//IN052645
		//sqlData.append("  f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND ") ;//IN052645 //Commented for IN063542
		sqlData.append("  f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND (f.event_code = a.event_code OR f.event_code = a.EVENT_GROUP) AND ") ;//Added for IN063542
		}
	 //sqlData.append( " AND " + sbQryCriteria.toString());//PER090914
   	sqlData.append(sbQryCriteria.toString());//PER090914
    sqlData.append("AND g.FACILITY_ID(+) = a.FACILITY_ID AND g.ENCOUNTER_ID(+) = a.ENCOUNTER_ID "); // MMS-QH-CRF-0177 [IN047572] - Start
   	if(attend_pract_code.equals("")){ 
		if(!speciality_code.equals("")){
			sqlData.append(" and g.SPECIALTY_CODE = ? ");
		}
	} else {
		sqlData.append(" and g.ATTEND_PRACTITIONER_ID = ? ");
	} // MMS-QH-CRF-0177 [IN047572] - End
	
	if (!strFlowSheetId.equals("")) {
		//sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,c.long_desc,nvl(a.event_group,'*ALL'),e.long_desc  ,nvl(a.request_num_seq,'0'),d.long_desc,a.event_code, dummydate "+strGraphOrder+" " );//PER090914
		//sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc,nvl(a.event_group,'*ALL'),event_group_desc  ,nvl(a.request_num_seq,'0'),sp_event_desc,a.event_code, dummydate "+strGraphOrder+" " );//PER090914
		if(orderByEventCode.equals("Y")) { // INT-CRF-BRU-CIS-004 - IN058138 - Start
			if(!isViewLabRes)
				sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc,event_desc, nvl(a.event_group,'*ALL'),event_group_desc  , NVL(a.request_num_seq, 0),sp_event_desc,a.event_code, dummydate "+strGraphOrder+" " );//6030
				else
					sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc,event_desc, nvl(a.event_group,'*ALL'),event_group_desc  , NVL (sequence_no,0),sp_event_desc,a.event_code, dummydate "+strGraphOrder+" " );//6030
		} else { // INT-CRF-BRU-CIS-004 - IN058138 - End
			if(!isViewLabRes)
			sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc,nvl(a.event_group,'*ALL'),event_group_desc  ,nvl(a.request_num_seq,'0'),sp_event_desc,a.event_code, dummydate "+strGraphOrder+" " );//PER090914//IN069290
			else
			//sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc,nvl(a.request_num_seq,'0'),nvl(a.event_group,'*ALL'),sp_event_desc,a.event_code, dummydate "+strGraphOrder+" " );//IN069290//6030
			sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc, NVL (sequence_no,0),nvl(a.event_group,'*ALL'),sp_event_desc,a.event_code, dummydate "+strGraphOrder+" " );//IN069290//6030
		}
	}else {
		//IN036050 starts
		//23-12-2013 - changes reverted for MOD Oman
		//sqlData.append( " ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc, a.event_class, nvl(a.request_num_seq,'0'), event_group_desc, nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "+strGraphOrder+" " );//PER090914
		 if(orderByEventCode.equals("Y")) { // INT-CRF-BRU-CIS-004 - IN058138 - Start
				if(!isViewLabRes)
					sqlData.append( " ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, event_desc, a.event_class, nvl(a.request_num_seq,'0'), event_group_desc, nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate "+strGraphOrder+" " );//6030
					else 
						sqlData.append( " ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, event_desc, a.event_class,  NVL (sequence_no,0), event_group_desc, nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate "+strGraphOrder+" " );//6030
		 } else { // INT-CRF-BRU-CIS-004 - IN058138 - End
			//IN054151 Start
			//sqlData.append( " ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, a.event_class, nvl(a.request_num_seq,'0'), event_group_desc, nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate "+strGraphOrder+" " );//PER090914
			if(!isViewLabRes)
			sqlData.append( " ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, a.event_class, event_group_desc, nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate "+strGraphOrder+" " );//IN069290
			else
			//sqlData.append( " ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, a.event_class, nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate "+strGraphOrder+" " );//IN069290//6030
			sqlData.append( " ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, a.event_class,  NVL (sequence_no,0), nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate "+strGraphOrder+" " );//IN069290//6030
			//IN054151 End
		 } // INT-CRF-BRU-CIS-004 - IN058138 
	}	 
		//sqlData.append( " ORDER BY event_group_desc, b.short_desc, a.hist_rec_type, c.long_desc, a.event_class, nvl(a.request_num_seq,'0'),  nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "+strGraphOrder+" " );
		//IN036050 ends
		//PER090914 Ends
	int i = 0;
	int tempCnt = 0;

	String classValue = "CACHARTQRYEVEN";
	String histRecType = "";
	String restricting_print = "N";  //IN069242
	boolean isSiteSpecificForLabPrint = false;//IN066453
	String histRecTypeDesc = "";
	String eventClass = "";
	String eventClassDesc = "";
	String eventGroup = "";
	String eventGroupDesc = "";
	String eventCode = "";
	String eventDesc = "";
	String histDataType = "";
	String resultNumUOM = "";
	String dummyDate = "";
	String eventDateTime = "";
	String sortEventDateTime = "";
	String accessionNum = "";
	String sysID = "";
	String sysEventCode = "";
	String resultNum = "";
	String resultStr = "";
	String normIndicator = "";
	String normalLow = "";
	String normalHigh = "";	
	String criticalLow = "";
	String criticalHigh = "";
	String extImgID = "";
	String extApplID = "";
	String toolTip = "";
	String toolTip_ind = "";
	String splEventDesc = "";
	String quickTextCount = "0";
	String deltaFailInd = "";
	String colorCellInd = "";
	String descCellInd = "";
	String tempValue = "";
	
	String tempAdditional = "";
	String textCount = "";
	String performed_by = "";
	String Specimen_num = "";  //IN066453
	String categoryNum = "";//IN066453
	String Specimen_num1 =""; //IN066453
	String Specimen_num2 ="";//IN066453
	String strStatus = "";
	String resultStatus = "";//29803
	String normal_Yn = "N";
	StringBuffer tempNormCritStr = new StringBuffer();
	String enctr_id = "";
	
	String tempEventDate1 = "";
	String tempEventDate2 = "";
	String histRecType1 = "";
	String tempEventClass1 = "";
	String tempEventGroup1 = "";
	String tempEventCode1 = "";
	String normalrange = "";
	String criticalrange = "";
	String deciresult="";//IN037900
	String decival ="";//IN037900
	
	String ext_image_upld_id = ""; //Bru-HIMS-CRF-052.1  [IN037793]
	String ext_img_file_locn = ""; //Bru-HIMS-CRF-052.1  [IN037793]
	String html_image_upld_id = ""; //IN069028
	int recCount = 0; // added for Bru-HIMS-CRF-052.1 [IN037793]
	String recCountInt = ""; // added for Bru-HIMS-CRF-052.1 [IN037793]
	//IN047204 - Start
	int image_count	=0;	//IN071127
	String out_event_code="";//IN071127
	String event_code_type = "";
	String order_id = ""; 
	String access_no_rd 	= ""; 
	String order_typ_code	= ""; 
	String locn_code	= "";		
	String locn_type	= "";
	String loc_desc		= "";
	String visit_id		= "";
	String physician_id	= "";
	String admit_date	= "";
	String patient_class = "";
	HashMap extLinkHashMap = null;
	//IN047204 - End
	String specimen_type="";//7632
	
	
	String uploaded_doc_cnt = ""; //IN070610
	String modified_date_YN = "";//24094
	String modified_date_YN1 = "";//24094
	String lv_neonate_spec_yn  = "";//31792
	String lv_neonate_spec_yn1 = "";//31792
	
	String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
	String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
	isSiteSpecificForLabPrint = CommonBean.isSiteSpecific(con, "CA","CEH_LAB_PRINT_REST");//IN066453
	try
	{
		nIndex =1;
		//39052 Start.
		String  sqlQuery = sqlData.toString();
		if("CA01".equals(order_type_3T)){
			sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##"," AND 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4) ");
		
		}else{
			sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##","");
		}
		//39052 End.
		pstmt = con.prepareStatement(sqlQuery);

		//PER0409 - start
		pstmt.setString(nIndex++,locale);
		pstmt.setString(nIndex++,locale);
		pstmt.setString(nIndex++,locale);
		//PER0409 - end
		pstmt.setString(nIndex++,locale); // IN058489
		pstmt.setString(nIndex++,locale); //IN064132
		if (!strFlowSheetId.equals(""))
			pstmt.setString(nIndex++,strFlowSheetId);

		pstmt.setString(nIndex++,strPatientId);

		if(!strHistRecType.equals(""))
			pstmt.setString(nIndex++,strHistRecType);

		if(!strEventClass.equals(""))
			pstmt.setString(nIndex++,strEventClass);

		if(!strEventGroup.equals(""))
			pstmt.setString(nIndex++,strEventGroup);

		if(!strEventCode.equals(""))
			pstmt.setString(nIndex++,strEventCode);

		if(!strFromDate.equals(""))
			pstmt.setString(nIndex++,strFromDate);

		if(!strToDate.equals(""))
			pstmt.setString(nIndex++,strToDate);

		if(!strFacilityId.equals(""))
			pstmt.setString(nIndex++,strFacilityId);
		//IN035950 Start
					if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
					{
						pstmt.setString(nIndex++,eventClasswidget);
					}
			//IN035950 Ends
		if(!strEncounterId.equals(""))
			pstmt.setString(nIndex++,strEncounterId);

		if(!strEpisodeType.equals("") )
		{
			if(strEpisodeType.equals("I"))
				pstmt.setString(nIndex++,"IP");
			else if(strEpisodeType.equals("O"))
				pstmt.setString(nIndex++,"OP");
			else if(strEpisodeType.equals("D"))
				pstmt.setString(nIndex++,"DC");
			else if(strEpisodeType.equals("E"))
				pstmt.setString(nIndex++,"EM");
			else if(strEpisodeType.equals("X"))
				pstmt.setString(nIndex++,"XT");
		}
		pstmt.setString(nIndex++,clinician_id);//common-icn-0180
		pstmt.setString(nIndex++,resp_id);//common-icn-0180
		//common-icn-0180 starts
		if(restrict_rd){
		pstmt.setString(nIndex++,login_user);
		}
		//common-icn-0180 ends
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				pstmt.setString(nIndex++, speciality_code);
			}
		} else {
			pstmt.setString(nIndex++, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			tempNormCritStr.setLength(0);
			dummyDate = rs.getString("dummydate") == null ? "" : rs.getString("dummydate");
			eventDateTime = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
			sortEventDateTime = rs.getString("sort_event_date_time") == null ? "" : rs.getString("sort_event_date_time");
			histRecType = rs.getString("hist_rec_type") == null ? "" : rs.getString("hist_rec_type");
			restricting_print = rs.getString("restricting_print") == null ? "" : rs.getString("restricting_print"); //IN069242
			histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
			eventClass = rs.getString("eve_class") == null ? "" : rs.getString("eve_class");
			eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
			eventGroup = rs.getString("event_group") == null ? "" : rs.getString("event_group");
			eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
			eventCode = rs.getString("eve_code") == null ? "" : rs.getString("eve_code");
			eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
			accessionNum = rs.getString("acc_num") == null ? "" : rs.getString("acc_num");
			sysID = rs.getString("sys_id") == null ? "" : rs.getString("sys_id");
			sysEventCode = rs.getString("sys_eve_code") == null ? "" : rs.getString("sys_eve_code");
			histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");
			specimen_type=rs.getString("specimen_type") == null ? "" : rs.getString("specimen_type");//7632
			modified_date_YN = rs.getString("modifiedyn") == null ? "" : rs.getString("modifiedyn");//24094
			//IN064688 Changes Starts
			/*resultNum = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");//Menaka for IN:028353
			resultNum = resultNum.trim();*/
				//9071 starts
			String results=rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
			if(!results.equals("")){
				//BigDecimal rn =BigDecimal.valueOf(Double.valueOf(rs.getString("RESULT_NUM").trim()));
				BigDecimal rn =rs.getBigDecimal("RESULT_NUM");
				if(rn!=null)
					resultNum=rn.toString();
				else
					resultNum=""; 
			}
				else
					resultNum=""; 
					//9071ends
			//IN064688 Changes Ends
			resultNumUOM = rs.getString("uom") == null ? "" : rs.getString("uom");
			resultStr = rs.getString("res_str") == null ? "" : rs.getString("res_str");
			normIndicator = rs.getString("norm_ind") == null ? "" : rs.getString("norm_ind");
			//IN064688 Changes Starts
			/*normalLow = rs.getString("normal_low") == null ? "" : rs.getString("normal_low");
			normalLow = normalLow.trim();
			normalHigh = rs.getString("normal_high") == null ? "" : rs.getString("normal_high");
			normalHigh = normalHigh.trim();*/
			BigDecimal nl =rs.getBigDecimal("normal_low");
				if(nl!=null)
					normalLow=nl.toString();
				else
					normalLow="";
			BigDecimal nh =rs.getBigDecimal("normal_high");
				if(nh!=null)
					normalHigh=nh.toString();
				else
					normalHigh="";
			//IN064688 Changes Ends
			criticalLow = rs.getString("critical_low") == null ?  "" : rs.getString("critical_low");
			criticalLow = criticalLow.trim();
			criticalHigh = rs.getString("critical_high") == null ? "" : rs.getString("critical_high");
			criticalHigh = criticalHigh.trim();
			extImgID = rs.getString("ext_img_id") == null ? "" : rs.getString("ext_img_id");
			extApplID = rs.getString("ext_appl_id") == null ? "" : rs.getString("ext_appl_id");
			toolTip = rs.getString("GetTooltip") == null ? "" : rs.getString("GetTooltip");
			performed_by = rs.getString("performed_by") == null ? "" : rs.getString("performed_by");
			Specimen_num = rs.getString("Specimen_num") == null ? "" : rs.getString("Specimen_num");//IN066453
			categoryNum = rs.getString("CATEGORY_NUMBER") == null ? "" : rs.getString("CATEGORY_NUMBER");//IN066453
			resulted_practitioner = rs.getString("resulted_practitioner") == null ? "" : rs.getString("resulted_practitioner"); //Added for IN064132
			enctr_id = rs.getString("encounter_ID") == null ? "0" : rs.getString("encounter_ID");
			normalcy_str = rs.getString("normalcy_str") == null ? "" : rs.getString("normalcy_str");
			fac_id = rs.getString("FACILITY_ID") == null ? "0" : rs.getString("FACILITY_ID");
			deciresult =rs.getString("RESULT_NUM1") == null ? "0" : rs.getString("RESULT_NUM1");//IN037900
			decival = rs.getString("RESULT_NUM_DEC") == null ? "0" : rs.getString("RESULT_NUM_DEC");//IN037900
			event_code_type  = rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE"); // IN047204
			lv_neonate_spec_yn = rs.getString("lv_neonate_spec_yn") == null ? "" : rs.getString("lv_neonate_spec_yn");//31792
	
			//IN071106, starts, commented
			//IN066453 -Start
			/*StringTokenizer st = new StringTokenizer(Specimen_num,"#");
			while(st.hasMoreTokens())
			{
				Specimen_num1 = java.net.URLEncoder.encode((String)st.nextToken());
				Specimen_num2 = java.net.URLEncoder.encode((String)st.nextToken());
				if(st.hasMoreTokens())
				Specimen_num2 = java.net.URLEncoder.encode((String)st.nextToken());
			}*/
		//	IN066453 -end
			//IN071106, ends, commented
			//IN047204  - Start
			//7902 STARTS
				if(!extApplID.equals("")&&extApplID.equals("CPACS"))
				{
					ext_img_disable="disabled";	
					
					pstmtImgView1 = con.prepareStatement("SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW WHERE  EXT_IMAGE_APPL_ID=?"); 
					pstmtImgView1.setString(1,extApplID);
					resImgView1 = pstmtImgView1.executeQuery();
					
					while(resImgView1.next())
					{
						param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
					}
					if(pstmtImgView1!=null) pstmtImgView1.close();
					if(resImgView1!=null) resImgView1.close();
					
					if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){
						pstmtImgView = con.prepareStatement("SELECT A.study_id  FROM or_order_line a, cr_encounter_detail b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?"); 
						pstmtImgView.setString(1,extApplID);
						pstmtImgView.setString(2,extImgID);
						resImgView = pstmtImgView.executeQuery();
						
						while(resImgView.next())
						{
							study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
						}
						
						if(pstmtImgView!=null) pstmtImgView.close();
						if(resImgView!=null) resImgView.close();
					}
				}
				//7902 ENDS
			
			if("RD".equals(event_code_type)) {
				extLinkHashMap = manageEmailBean.getExternalLinkParameters(fac_id, strPatientId, enctr_id, locale); 
					
				admit_date	= (String) extLinkHashMap.get("P_ENCNTR_DATE");
				locn_code	= (String) extLinkHashMap.get("P_LOCN_CODE");
				locn_type	= (String) extLinkHashMap.get("P_LOCN_TYPE");
				visit_id	= (String) extLinkHashMap.get("P_VISIT_ID");
				loc_desc	= (String) extLinkHashMap.get("P_LOC_DESC");
				physician_id	= (String) extLinkHashMap.get("P_PHYSICIAN_ID");
				patient_class	= (String) extLinkHashMap.get("P_EPISODE_TYPE");	
				
				//Fix for IN047566/Start
				//access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
				if ((extImgID.equals(null) || extImgID.equals(""))) 
					access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
				else
					access_no_rd 	= extImgID;
				//Fix for IN047566/End					
				pstmtOrderId = con.prepareStatement("select  order_id , order_type_code from or_order_line where accession_num = ?"); 
				pstmtOrderId.setString(1,access_no_rd);
				rsetOrderId = pstmtOrderId.executeQuery();
				if(rsetOrderId.next()){
					order_id = rsetOrderId.getString("order_id") == null ? "":  rsetOrderId.getString("order_id");
					order_typ_code	= rsetOrderId.getString("order_type_code") == null ? "":  rsetOrderId.getString("order_type_code");	
				}
				if(rsetOrderId  != null) rsetOrderId.close();
				if(pstmtOrderId  != null) pstmtOrderId.close();
			}	
			//IN047204  - End
			// added for Bru-HIMS-CRF-052.1 [IN037793] - Start
			ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");
			html_image_upld_id = rs.getString("HTML_IMAGE_UPLD_ID") == null ? "" : rs.getString("HTML_IMAGE_UPLD_ID"); //IN069028
			
			//IN070610, starts
			if(uploadFuncTrOrders)
				uploaded_doc_cnt = rs.getString("uploaded_doc_cnt") == null ? "" : rs.getString("uploaded_doc_cnt"); //IN069028
			//IN070610, ends
			if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
				pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
				pstmtImgView.setString(1,ext_image_upld_id);
				resImgView = pstmtImgView.executeQuery();
				while(resImgView.next())
				{
					ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
				}
				
				/*   //17012
				//IN040866 - Start
				String perfFacilityId = "";
				pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
				pstmtPerFacId.setString(1,extImgID);
				rsetPerFacId = pstmtPerFacId.executeQuery();
				if(rsetPerFacId.next()){
					perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
				}
				//IN040866 - End
				// IN052800 - Start
				if(perfFacilityId.equals("") || perfFacilityId == null){
					perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(extImgID);
				}
				*/  //17012
				//IN052800 - End
				//sysEventCode = eventGroup;//IN040416
				//IN065970 starts
				//IN071127 starts
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?");
				//pstmtImgCount.setString(1,fac_id); //commented for IN040866
				//pstmtImgCount.setString(1,perfFacilityId);// modified for IN040866
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
					//	connection.prepareCall("{ "+SQL_OR_ORDER_ENTRY_SPECIMEN_GEN+" }");
				 cs = con.prepareCall( "{ call rl_image_count(?,?,?,?,?,?)}" );
				cs.setString(1,sysEventCode);
				cs.setString(2,accessionNum);
				cs.setString(3,eventCode);
				cs.setString(4,strPatientId);
				cs.registerOutParameter( 5,  java.sql.Types.VARCHAR ) ;
				cs.registerOutParameter( 6,  java.sql.Types.INTEGER ) ;
				cs.execute() ;
				 out_event_code	= cs.getString( 5 ) ;
				 image_count	= cs.getInt( 6 ) ;
				
				//pstmtImgCount.setString(1,extImgID); 
				//pstmtImgCount.setString(2,sysEventCode);//IN040416//Uncommented for IN068560
				//pstmtImgCount.setString(2,eventCode);//IN071127
				//pstmtImgCount.setString(2,eventGroup);//IN040416//commented for IN068560
				//IN065970 ends
				
			/*	rsetImgCount = pstmtImgCount.executeQuery();
				if(rsetImgCount.next()) 
				{
					recCount = rsetImgCount.getInt(1);
				}
				recCountInt = String.valueOf(recCount);*/
				 //IN071127 ends
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",sysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale);  //commented for IN040866
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",sysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040866, IN040416
				//IN065970 reopen starts
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",eventGroup).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040416
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",eventGroup).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); // IN065970 reopen ends//commented for IN068560
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",sysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); // IN068560//IN071127
				ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",out_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); // IN071127
				if(resImgView  != null) resImgView.close();
				if(pstmtImgView != null) pstmtImgView.close();

				if(rsetImgCount  != null)  rsetImgCount.close();
				if(pstmtImgCount  != null) pstmtImgCount.close();

				if(rsetPerFacId  != null) rsetPerFacId.close();
				if(pstmtPerFacId  != null) pstmtPerFacId.close();
 				 
			}	
			// End
			//Added by Jyothi.G on 09/12/2010 to fix IN025310
			if(!normalLow.equals("") && !normalHigh.equals(""))
				normalrange = Normal_Range + " : " + normalLow + " - " + normalHigh + " " + resultNumUOM;
			else if(!normalLow.equals("") && normalHigh.equals(""))
				normalrange = Normal_Range + " : (>=" + normalLow + " " + resultNumUOM + ")";
			else if(normalLow.equals("") && !normalHigh.equals(""))
				normalrange = Normal_Range + " : (<=" + normalHigh + " " + resultNumUOM + ")";
			else
				normalrange = "";
		
			if(!criticalLow.equals("") && !criticalHigh.equals(""))
			{
				criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
			}
			else if(!criticalLow.equals("") && criticalHigh.equals(""))
			{
				criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+")" ;
			}
			else if(criticalLow.equals("") && !criticalHigh.equals(""))
			{
				criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
			}
			else
				criticalrange = "";
						
			if(!normalrange.equals("") && !criticalrange.equals(""))
				tempNormCritStr.append(normalrange+"<br> "+criticalrange);
			else if(!normalrange.equals(""))
				tempNormCritStr.append(normalrange);
			else if(!criticalrange.equals(""))
				tempNormCritStr.append(criticalrange);
			else
				tempNormCritStr.append("");//END
			//IN064132 changes starts
			/*
			if(!performed_by.equals(""))
			{
				if(!(tempNormCritStr.toString()).equals(""))
					tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + performed_by );
			}
			*/
			if(isPracSiteSpecific && "LBIN".equals(histRecType))
			{
				if(!resulted_practitioner.equals(""))
				{
					if(!(tempNormCritStr.toString()).equals("")){
						//if(isVerifiedSiteSpec)//IN069290 added Verified By//commented for ML-MMOH-CRF-1261.1
							tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + resulted_practitioner );
						//else
							//tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + resulted_practitioner );						
					}
				}
			}else
			{
				if(!performed_by.equals(""))
				{
					if(!(tempNormCritStr.toString()).equals(""))
						//if(isVerifiedSiteSpec)//IN069290 added  Verified By //commented for ML-MMOH-CRF-1261.1
							tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + performed_by );
					//else //commented for ML-MMOH-CRF-1261.1
						//tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + resulted_practitioner );	
				}
			}
			
			//IN064132 changes ends
			//IN069290 changes starts
			if(toolTip.indexOf("Performed By")!=-1 ){//removed isVerifiedSiteSpec
						toolTip=toolTip.replaceAll("Performed By","Verified By");
					}
			//IN069290 changes starts
			toolTip_ind = "";//IN066453
			//IN067806 changes ends
			String tempVal = "";
			if(resultStr.length()>200){
				tempVal=resultStr.substring(0,200);
				tempVal=replaceSpecialChar(tempVal);
			}
			else{
				tempVal=replaceSpecialChar(resultStr);
			}
			if(histDataType.equals("STR") && isDisToolTipStr){
				toolTip_ind=java.net.URLEncoder.encode(tempVal);
			//	toolTip_ind = tempVal;
			}
			else if(histDataType.equals("NUM"))
				toolTip_ind = tempNormCritStr.toString();

			//toolTip_ind = tempNormCritStr.toString();//Commented for IN067806
			//IN067806 changes ends

			splEventDesc = rs.getString("sp_event_desc") == null ? "" : rs.getString("sp_event_desc");
			quickTextCount = rs.getString("QUICK_TEXT_COUNT") == null ? "" : rs.getString("QUICK_TEXT_COUNT");
			deltaFailInd = rs.getString("delta_fail_ind") == null ? "" : rs.getString("delta_fail_ind");
			colorCellInd = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
			descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
			strStatus = rs.getString("stat") == null ? "" : rs.getString("stat");
			resultStatus = rs.getString("resultStatus") == null ? "" : rs.getString("resultStatus");//29803
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				colorCellInd = rs.getString("SYMBOL_LEGEND_IND") == null ? "" : rs.getString("SYMBOL_LEGEND_IND");
			textCount = rs.getString("text_count") == null ? "" : rs.getString("text_count");

			if(histDataType.equals("NUM"))
			{
				//IN037900 Start
				if(decival.length()>0 && deciresult.length()> 9)	
					resultNum = deciresult;				
				//IN037900 end	
				if(!resultNum.equals(""))
				{
					if(colorCellInd.equals("NONE"))
					{
						if(normIndicator.equals("."))
							normal_Yn = "Y";
						else if(!normalLow.equals("") && !normalHigh.equals(""))
						{
							if(Float.parseFloat(resultNum) > 0)
							{
								if ((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)) )
								{
									normal_Yn = "Y";
								}
								else
									normal_Yn = "N";
							}
							else
								normal_Yn = "N";
						}
						else if(!normalLow.equals("") && normalHigh.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
						{
							if(Float.parseFloat(resultNum) > 0)
							{
								if (Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
								{
									normal_Yn = "Y";
								}
								else
									normal_Yn = "N";
							}
							else
								normal_Yn = "N";
						}
						else if(normalLow.equals("") && !normalHigh.equals(""))
						{
							if(Float.parseFloat(resultNum) > 0)
							{
								if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
								{
									normal_Yn = "Y";
								}
								else
									normal_Yn = "N";
							}
							else
								normal_Yn = "N";
						}//END
						else
							normal_Yn = "N";
					}
					else
						normal_Yn = "N";
				}
			}
			else if(normIndicator.equals("."))
				normal_Yn = "Y";
			else
				normal_Yn = "N";

			if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
				resultNum = rs.getString("RESULT_NUM_PREFIX") + resultNum;
			// IN066453 -Start
		    if("LBIN".equals(histRecType) && sysID.equals("LB"))
			{
		    	Specimen_num2 = extractSpecimenNumber(accessionNum,"#","@");//IN071106
				//toolTip_ind = toolTip_ind +"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>";
				toolTip_ind = toolTip_ind +"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenType.label","or_labels")+" : " + specimen_type+"<BR>";//7632
				
		    }
			// IN066453 -end
		
			if(dateList.contains(eventDateTime))
			{
				tempSessionMap.put("eventDateTime"+tempCnt,eventDateTime);
				tempSessionMap.put("sortEventDateTime"+tempCnt,sortEventDateTime);
				tempSessionMap.put("dummyDate"+tempCnt,dummyDate);
				tempSessionMap.put("histRecType"+tempCnt,histRecType);
				tempSessionMap.put("restricting_print"+tempCnt,restricting_print);	//IN069242			
				tempSessionMap.put("histRecTypeDesc"+tempCnt,histRecTypeDesc);
			    tempSessionMap.put("eventClass"+tempCnt,eventClass);
				tempSessionMap.put("eventClassDesc"+tempCnt,eventClassDesc);
				tempSessionMap.put("eventGroup"+tempCnt,eventGroup);
				tempSessionMap.put("eventGroupDesc"+tempCnt,eventGroupDesc);
				tempSessionMap.put("eventCode"+tempCnt,eventCode);
				tempSessionMap.put("eventDesc"+tempCnt,eventDesc);
				tempSessionMap.put("accessionNum"+tempCnt,accessionNum);
				tempSessionMap.put("sysID"+tempCnt,sysID);
				tempSessionMap.put("sysEventCode"+tempCnt,sysEventCode);
				tempSessionMap.put("histDataType"+tempCnt,histDataType);
				tempSessionMap.put("resultNum"+tempCnt,resultNum);
				tempSessionMap.put("resultNumUOM"+tempCnt,resultNumUOM);
				tempSessionMap.put("resultStr"+tempCnt,resultStr);
				tempSessionMap.put("normIndicator"+tempCnt,normIndicator);
				tempSessionMap.put("normalLow"+tempCnt,normalLow);
				tempSessionMap.put("normalHigh"+tempCnt,normalHigh);
				tempSessionMap.put("criticalLow"+tempCnt,criticalLow);
				tempSessionMap.put("criticalHigh"+tempCnt,criticalHigh);
				tempSessionMap.put("extImgID"+tempCnt,extImgID);
				tempSessionMap.put("extApplID"+tempCnt,extApplID);
				tempSessionMap.put("toolTip"+tempCnt,toolTip);
				tempSessionMap.put("toolTip_ind"+tempCnt,toolTip_ind);
				tempSessionMap.put("splEventDesc"+tempCnt,splEventDesc);
				tempSessionMap.put("quickTextCount"+tempCnt,quickTextCount);
				tempSessionMap.put("deltaFailInd"+tempCnt,deltaFailInd);
				tempSessionMap.put("colorCellInd"+tempCnt,colorCellInd);
				tempSessionMap.put("descCellInd"+tempCnt,descCellInd);
				tempSessionMap.put("strStatus"+tempCnt,strStatus);	
				tempSessionMap.put("resultStatus"+tempCnt,resultStatus);	//29803
				tempSessionMap.put("textCount"+tempCnt,textCount);	
				tempSessionMap.put("normal_Yn"+tempCnt,normal_Yn);	
				tempSessionMap.put("enctr_id"+tempCnt,enctr_id);	
				tempSessionMap.put("normalcy_str"+tempCnt,normalcy_str);
				tempSessionMap.put("fac_id"+tempCnt,fac_id);	//IN033489		
				tempSessionMap.put("ext_image_upld_id"+tempCnt,ext_image_upld_id); //added for Bru-HIMS-CRF-052.1 [IN037793]
				tempSessionMap.put("ext_img_file_locn"+tempCnt,ext_img_file_locn); //added for Bru-HIMS-CRF-052.1 [IN037793]
				tempSessionMap.put("recCountInt"+tempCnt,recCountInt); //added for Bru-HIMS-CRF-052.1 [IN037793]				
				tempSessionMap.put("patient_id"+tempCnt,strPatientId); //IN047204 	
				tempSessionMap.put("dmsExternalLinkYN"+tempCnt,dmsExternalLinkYN); //IN047204 
				tempSessionMap.put("event_code_type"+tempCnt,event_code_type); //IN047204 
				tempSessionMap.put("order_id"+tempCnt,order_id); //IN047204
				tempSessionMap.put("order_typ_code"+tempCnt,order_typ_code); //IN047204
				tempSessionMap.put("admit_date"+tempCnt,admit_date); //IN047204
				tempSessionMap.put("locn_code"+tempCnt,locn_code); //IN047204
				tempSessionMap.put("locn_type"+tempCnt,locn_type); //IN047204
				tempSessionMap.put("visit_id"+tempCnt,visit_id); //IN047204
				tempSessionMap.put("loc_desc"+tempCnt,loc_desc); //IN047204
				tempSessionMap.put("physician_id"+tempCnt,physician_id); //IN047204
				tempSessionMap.put("patient_class"+tempCnt,patient_class); //IN047204
				tempSessionMap.put("locale"+tempCnt,locale); //IN047204
				tempSessionMap.put("login_user"+tempCnt,login_user); //IN047204
				tempSessionMap.put("resp_id"+tempCnt,resp_id); //IN047204
				tempSessionMap.put("login_at_ws_no"+tempCnt,login_at_ws_no); //IN047204
				tempSessionMap.put("html_image_upld_id"+tempCnt,html_image_upld_id); //IN069028
				tempSessionMap.put("uploaded_doc_cnt"+tempCnt,uploaded_doc_cnt); //IN070610
				tempSessionMap.put("image_count"+tempCnt,image_count); //IN071127
				tempSessionMap.put("study_id"+tempCnt,study_id); //7902
				tempSessionMap.put("param_def_str"+tempCnt,param_def_str); //7902
				tempSessionMap.put("modifiedyn"+tempCnt,modified_date_YN);//24094
				tempSessionMap.put("lv_neonate_spec_yn "+tempCnt,lv_neonate_spec_yn );//31792
				tempCnt++;
			}
		}

		int k=0;
		int numOfCols = 0;
		int tempK = 0;
		
		String tempEventDate = "";
		String tempReturnString = "";
		String tempHistRecType = "";
		String tempEventClass = "";
		String tempEventGroup = "";
		String tempEventCode = "";
		String tempDisplayEventCode = "";
		String tempDisplayEventClass = "";
		String tempDisplayEventGroup = "";
		String tempDisplayHistRecType = "";
		String tempResultNum = "";
		String tempEventDateTimeForGraf = "";
		String tempmodified_date_YN = "";//24094
		String tempDisplaymodified_date_YN = "";//24094
		String templv_neonate_spec_yn  = "";//31792
		String tempDisplaylv_neonate_spec_yn = "";//31792
		
		StringBuffer dataBuffer = new StringBuffer();
		StringBuffer moreDlt = new StringBuffer();
		
		int counter = 0;
		for(k=0;k<tempCnt;k++)
		{
			tempValue=""; //20155
			tempEventDate = (String) tempSessionMap.get("eventDateTime"+k);
			histRecTypeDesc = (String)tempSessionMap.get("histRecTypeDesc"+k);
			eventClassDesc = (String)tempSessionMap.get("eventClassDesc"+k);
			eventGroupDesc = (String)tempSessionMap.get("eventGroupDesc"+k);
			eventCode = (String)tempSessionMap.get("eventCode"+k);
			eventDesc = (String)tempSessionMap.get("eventDesc"+k);
			histRecType = (String)tempSessionMap.get("histRecType"+k);
			restricting_print = (String)tempSessionMap.get("restricting_print"+k);//IN069242
			eventClass = (String)tempSessionMap.get("eventClass"+k);
			eventGroup = (String)tempSessionMap.get("eventGroup"+k);
			histDataType = (String)tempSessionMap.get("histDataType"+k);
			resultNumUOM = (String)tempSessionMap.get("resultNumUOM"+k);
			dummyDate = (String)tempSessionMap.get("dummyDate"+k);
			eventDateTime = (String)tempSessionMap.get("eventDateTime"+k);		
			sortEventDateTime = (String)tempSessionMap.get("sortEventDateTime"+k);
			accessionNum = (String)tempSessionMap.get("accessionNum"+k);
			sysID = (String)tempSessionMap.get("sysID"+k);
			sysEventCode = (String)tempSessionMap.get("sysEventCode"+k);
			resultNum = (String)tempSessionMap.get("resultNum"+k);
			resultStr = (String)tempSessionMap.get("resultStr"+k);
			normIndicator = (String)tempSessionMap.get("normIndicator"+k);
			extImgID = (String)tempSessionMap.get("extImgID"+k);
			extApplID = (String)tempSessionMap.get("extApplID"+k);
			html_image_upld_id = (String)tempSessionMap.get("html_image_upld_id"+k); //IN069028
			toolTip = (String)tempSessionMap.get("toolTip"+k);
			toolTip_ind = (String)tempSessionMap.get("toolTip_ind"+k);
			quickTextCount = (String)tempSessionMap.get("quickTextCount"+k);
			deltaFailInd = (String)tempSessionMap.get("deltaFailInd"+k);
			colorCellInd = (String)tempSessionMap.get("colorCellInd"+k);
			descCellInd = (String)tempSessionMap.get("descCellInd"+k);
			textCount = (String)tempSessionMap.get("textCount"+k);
			normal_Yn = (String)tempSessionMap.get("normal_Yn"+k);
			enctr_id = (String)tempSessionMap.get("enctr_id"+k);
			strStatus = (String)tempSessionMap.get("strStatus"+k);
			resultStatus = (String)tempSessionMap.get("resultStatus"+k);//29803
			normalcy_str = (String)tempSessionMap.get("normalcy_str"+k);
			fac_id = (String)tempSessionMap.get("fac_id"+k);//IN033489
			ext_image_upld_id = (String)tempSessionMap.get("ext_image_upld_id"+k); //added for Bru-HIMS-CRF-052.1 [IN037793]
			ext_img_file_locn = (String)tempSessionMap.get("ext_img_file_locn"+k); //added for Bru-HIMS-CRF-052.1 [IN037793]
			recCountInt = (String)tempSessionMap.get("recCountInt"+k); //added for Bru-HIMS-CRF-052.1 [IN037793]
			strPatientId = (String)tempSessionMap.get("patient_id"+k); //IN047204 	
			dmsExternalLinkYN = (String)tempSessionMap.get("dmsExternalLinkYN"+k); //IN047204 
			event_code_type = (String)tempSessionMap.get("event_code_type"+k); //IN047204
			order_id = (String)tempSessionMap.get("order_id"+k); //IN047204 
			order_typ_code 	= (String)tempSessionMap.get("order_typ_code"+k); //IN047204 
			admit_date		= (String)tempSessionMap.get("admit_date"+k); //IN047204 
			locn_code		= (String)tempSessionMap.get("locn_code"+k); //IN047204 
			locn_type		= (String)tempSessionMap.get("locn_type"+k); //IN047204 
			visit_id		= (String)tempSessionMap.get("visit_id"+k); //IN047204 
			loc_desc		= (String)tempSessionMap.get("loc_desc"+k); //IN047204 
			physician_id	= (String)tempSessionMap.get("physician_id"+k); //IN047204 
			patient_class	= (String)tempSessionMap.get("patient_class"+k); //IN047204 
			image_count		=(Integer)tempSessionMap.get("image_count"+k);////IN071127
			study_id=(String)tempSessionMap.get("study_id"+k); //7902
			param_def_str=(String)tempSessionMap.get("param_def_str"+k); //7902
			modified_date_YN = (String)tempSessionMap.get("modifiedyn"+k);//24094
			lv_neonate_spec_yn  = (String)tempSessionMap.get("lv_neonate_spec_yn "+k);//31792
			int tempNumOfCols = 0;	
			String tempDispString = "";
			
			uploaded_doc_cnt = (String)tempSessionMap.get("uploaded_doc_cnt"+k); //IN070610
			if(tempEventDate.equals((String)dateList.get(numOfCols)))
			{
				tempNumOfCols = numOfCols;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+1)))
			{
				tempNumOfCols = numOfCols+1;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+2)))
			{
				tempNumOfCols = numOfCols+2;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+3)))
			{
				tempNumOfCols = numOfCols+3;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+4)))
			{
				tempNumOfCols = numOfCols+4;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+5)))
			{
				tempNumOfCols = numOfCols+5;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+6)))
			{
				tempNumOfCols = numOfCols+6;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+7)))
			{
				tempNumOfCols = numOfCols+7;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+8)))
			{
				tempNumOfCols = numOfCols+8;
			}
			else if(tempEventDate.equals((String)dateList.get(numOfCols+9)))
			{
				tempNumOfCols = numOfCols+9;
			}

			tempAdditional = resultStr;

			if(histDataType.equals("NUM")) 
				tempValue = resultNum;
			else if(histDataType.equals("STR")) 
				tempValue = resultStr;
			else if(histDataType.equals("TXT") || histDataType.equals("IMG") || histDataType.equals("HTM")) 
				tempValue = "";

			if(k == 0)
			{
				prevK = k;
			}
			else
			{
				if(orderByEventCode.equals("Y")){ // INT-CRF-BRU-CIS-004 - IN058138 - Start
					
					if(tempDisplayEventCode.equals(eventCode) && tempDisplayEventClass.equals(eventClass) && tempDisplayHistRecType.equals(histRecType)){
						prevK = prevK;
					}
					else
					{
						prevK = prevK +1;
					}	
					
				}else{ // INT-CRF-BRU-CIS-004 - IN058138 - End
					if(tempDisplayEventCode.equals(eventCode) && tempDisplayEventGroup.equals(eventGroup) && tempDisplayEventClass.equals(eventClass) && tempDisplayHistRecType.equals(histRecType)){
						prevK = prevK;
					}
					else
					{
						prevK = prevK +1;
					}	
				}	// INT-CRF-BRU-CIS-004 - IN058138 		
			}  
			if(orderByEventCode.equals("Y")){ // INT-CRF-BRU-CIS-004 - IN058138 - Start
				//if(!(tempEventDate1.equals(tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k)) && histRecType1.equals(tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k))  && tempEventClass1.equals(tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k)) && tempEventCode1.equals(tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k)) && modified_date_YN1.equals(tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k))))//24094 
			    if(!(tempEventDate1.equals(tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k)) && histRecType1.equals(tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k))  && tempEventClass1.equals(tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k)) && tempEventCode1.equals(tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k)) && modified_date_YN1.equals(tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k)) && lv_neonate_spec_yn1.equals(tempSessionMap.get("lv_neonate_spec_yn "+k)==null?"":(String)tempSessionMap.get("lv_neonate_spec_yn "+k))))//24094 //31792
						
				{
					tempEventDate1 =  tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k);
					histRecType1 = tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k);
					tempEventClass1 = tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k);
					tempEventGroup1 =  tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k);
					tempEventCode1 = tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k);
					modified_date_YN1 = tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k);//24094
					lv_neonate_spec_yn1  = tempSessionMap.get("lv_neonate_spec_yn "+k)==null?"":(String)tempSessionMap.get("lv_neonate_spec_yn "+k);//31792
					counter = 0;
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint, html_image_upld_id);//IN047204 //Add html_image_upld_id for IN069028
					//IN069242 Start.
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint, html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt);//IN047204 //Add html_image_upld_id for IN069028//IN071127
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print, html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt);//7902
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType,  prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print, html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN);//7902 //resultStatus added for 29803 //24094
					tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType,  prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print, html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN, lv_neonate_spec_yn,tempDisplaylv_neonate_spec_yn,isSiteSpecificNeonatalMotherSpecimen );//7902 //resultStatus added for 29803 //24094 //31792
							//IN069242 End.
				}
				else
				{
					tempEventDate1 =  tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k);
					tempEventDate2 = com.ehis.util.DateUtils.convertDate(tempEventDate1,"DMYHM","en",locale);
					histRecType1 = tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k);
					tempEventClass1 = tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k);
					tempEventGroup1 =  tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k);
					tempEventCode1 = tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k);
					modified_date_YN1 = tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k);//24094
					lv_neonate_spec_yn1  = tempSessionMap.get("lv_neonate_spec_yn "+k)==null?"":(String)tempSessionMap.get("lv_neonate_spec_yn "+k);//31792

					if(counter == 0 )
					{
						moreDlt.append("<a class='gridLink' href='javascript:callResults(\""+tempEventDate1+"\",\""+tempEventDate2+"\",\""+eventDesc+"\",\""+histRecType1+"\",\""+tempEventClass1+"\",\""+tempEventGroup1+"\",\""+tempEventCode1+"\",\""+modified_date_YN1+"\",\""+lv_neonate_spec_yn1+"\")' title='Click to view other recording of this event for the same time'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MoreValues.label","ca_labels")  +"</a>");//31792
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id); //IN047204 //Add html_image_upld_id for IN069028//IN070610
						//IN069242 Start.
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt); //IN047204 //Add html_image_upld_id for IN069028//IN070610//IN071127
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt);//7902
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN);//7902 //resultStatus added for 29803 //24094
						tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN, lv_neonate_spec_yn,tempDisplaylv_neonate_spec_yn,isSiteSpecificNeonatalMotherSpecimen);//7902 //resultStatus added for 29803 //24094//31792
								//IN069242 End.
					}
					counter++; 
					moreDlt.delete(0, moreDlt.length());
				}
			} else {
					//if(!(tempEventDate1.equals(tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k)) && histRecType1.equals(tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k)) && tempEventClass1.equals(tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k)) && tempEventGroup1.equals(tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k)) && tempEventCode1.equals(tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k)) && modified_date_YN1.equals(tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k))))//24094
					if(!(tempEventDate1.equals(tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k)) && histRecType1.equals(tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k)) && tempEventClass1.equals(tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k)) && tempEventGroup1.equals(tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k)) && tempEventCode1.equals(tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k)) && modified_date_YN1.equals(tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k)) && lv_neonate_spec_yn1.equals(tempSessionMap.get("lv_neonate_spec_yn"+k)==null?"":(String)tempSessionMap.get("lv_neonate_spec_yn"+k))))//24094//31792
							
					{
						tempEventDate1 =  tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k);
						histRecType1 = tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k);

						
						tempEventClass1 = tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k);
						tempEventGroup1 =  tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k);
						tempEventCode1 = tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k);
						modified_date_YN1 = tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k);//24094
						lv_neonate_spec_yn1 = tempSessionMap.get("lv_neonate_spec_yn"+k)==null?"":(String)tempSessionMap.get("lv_neonate_spec_yn"+k);//31792
						counter = 0;
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id );//IN047204  //Add html_image_upld_id for IN069028//IN070610
						//IN069242 Start.
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt );//IN047204  //Add html_image_upld_id for IN069028//IN070610//IN071127
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt );//7902
						//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN );//7902 //resultStatus added for 29803//24094
						tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN, lv_neonate_spec_yn,tempDisplaylv_neonate_spec_yn,isSiteSpecificNeonatalMotherSpecimen);//7902 //resultStatus added for 29803//24094//31792
						
								//IN069242 End.
					}
					else
					{
						tempEventDate1 =  tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k);
						tempEventDate2 = com.ehis.util.DateUtils.convertDate(tempEventDate1,"DMYHM","en",locale);
						histRecType1 = tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k);

						tempEventClass1 = tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k);
						tempEventGroup1 =  tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k);
						tempEventCode1 = tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k);
						modified_date_YN1 = tempSessionMap.get("modifiedyn"+k)==null?"":(String)tempSessionMap.get("modifiedyn"+k);//24094
						lv_neonate_spec_yn1 = tempSessionMap.get("lv_neonate_spec_yn"+k)==null?"":(String)tempSessionMap.get("lv_neonate_spec_yn"+k);//31792
						

						if(counter == 0 )
						{
							moreDlt.append("<a class='gridLink' href='javascript:callResults(\""+tempEventDate1+"\",\""+tempEventDate2+"\",\""+eventDesc+"\",\""+histRecType1+"\",\""+tempEventClass1+"\",\""+tempEventGroup1+"\",\""+tempEventCode1+"\",\""+modified_date_YN1+"\",\""+lv_neonate_spec_yn1+"\")' title='Click to view other recording of this event for the same time'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MoreValues.label","ca_labels")  +"</a>");//31792
							//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id); //IN047204  //Add html_image_upld_id for IN069028//IN070610
							//IN069242 Start.
							//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt); //IN047204  //Add html_image_upld_id for IN069028//IN070610//IN071127
							//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt);//7902
							//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN); //7902 //resultStatus added for 29803 //24094
							tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,image_count, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id,uploadFuncTrOrders,uploaded_doc_cnt,ext_img_disable,study_id,ext_img_display,param_def_str,resultStatus, modified_date_YN, tempDisplaymodified_date_YN,lv_neonate_spec_yn,tempDisplaylv_neonate_spec_yn,isSiteSpecificNeonatalMotherSpecimen); //7902 //resultStatus added for 29803 //24094//31792
							
									//IN069242 End.
						}
						counter++; 
						moreDlt.delete(0, moreDlt.length());
					}
			}
			// commented below for INT-CRF-BRU-CIS-004 - IN058138 - Start
			/*
			if(!(tempEventDate1.equals(tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k)) && histRecType1.equals(tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k)) && tempEventClass1.equals(tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k)) && tempEventGroup1.equals(tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k)) && tempEventCode1.equals(tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k))))
			{

				tempEventDate1 =  tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k);
				histRecType1 = tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k);
				tempEventClass1 = tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k);
				tempEventGroup1 =  tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k);
				tempEventCode1 = tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k);
				counter = 0;

				//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str, "");//IN033489
				//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "");//IN033489 //commented for Bru-HIMS-CRF-052.1 [IN037793]
				//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt);//modified for Bru-HIMS-CRF-052.1 [IN037793] - commented for IN047204
				//IN069242 Start.
				//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id );//IN047204 //Add html_image_upld_id for IN069028
				tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id );
				//IN069242 End.
			}
			else
			{
				tempEventDate1 =  tempSessionMap.get("eventDateTime"+k)==null?"":(String)tempSessionMap.get("eventDateTime"+k);
				tempEventDate2 = com.ehis.util.DateUtils.convertDate(tempEventDate1,"DMYHM","en",locale);
				histRecType1 = tempSessionMap.get("histRecType"+k)==null?"":(String)tempSessionMap.get("histRecType"+k);
				tempEventClass1 = tempSessionMap.get("eventClass"+k)==null?"":(String)tempSessionMap.get("eventClass"+k);
				tempEventGroup1 =  tempSessionMap.get("eventGroup"+k)==null?"":(String)tempSessionMap.get("eventGroup"+k);
				tempEventCode1 = tempSessionMap.get("eventCode"+k)==null?"":(String)tempSessionMap.get("eventCode"+k);

				if(counter == 0 )
				{
					moreDlt.append("<a class='gridLink' href='javascript:callResults(\""+tempEventDate1+"\",\""+tempEventDate2+"\",\""+eventDesc+"\",\""+histRecType1+"\",\""+tempEventClass1+"\",\""+tempEventGroup1+"\",\""+tempEventCode1+"\")' title='Click to view other recording of this event for the same time'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MoreValues.label","ca_labels")  +"</a>");
				
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str, moreDlt.toString());//IN033489
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString());//IN033489 //commented for Bru-HIMS-CRF-052.1 [IN037793]
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,recCountInt);//IN033489 //modified for Bru-HIMS-CRF-052.1 [IN037793] - commented for IN047204
					//IN069242 Start.
					//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,isSiteSpecificForLabPrint,html_image_upld_id); //IN047204  //Add html_image_upld_id for IN069028
					tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id, moreDlt.toString(),ext_image_upld_id, ext_img_file_locn ,recCountInt, strPatientId, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,restricting_print,html_image_upld_id); 
					//IN069242 End.
				}
				counter++; 
				moreDlt.delete(0, moreDlt.length());
			}
			*/
			// Commented above line for INT-CRF-BRU-CIS-004 - IN058138 - End
			tempDisplayEventCode = eventCode;
			tempDisplayEventClass = eventClass;
			tempDisplayEventGroup = eventGroup;
			tempDisplayHistRecType = histRecType;
			tempDisplaymodified_date_YN = modified_date_YN;//24094
			tempDisplaylv_neonate_spec_yn = lv_neonate_spec_yn;//31792

			tempK = prevK;

			tempReturnString = (String) tempTRMap.get("tempString"+tempK+"Map"+tempNumOfCols);
			tempHistRecType = (String) tempTRMap.get("histRecType"+tempK);
			
			tempEventClass = (String) tempTRMap.get("eventClass"+tempK);
			tempEventGroup = (String) tempTRMap.get("eventGroup"+tempK);
			tempEventCode = (String) tempTRMap.get("eventCode"+tempK);
			tempmodified_date_YN = (String) tempTRMap.get("modifiedyn"+tempK);//24094
			templv_neonate_spec_yn = (String) tempTRMap.get("lv_neonate_spec_yn"+tempK);//31792
			tempResultNum = (String) tempTRMap.get("resultNum"+tempK+"Map"+tempNumOfCols);
			tempEventDateTimeForGraf = (String) tempTRMap.get("eventDateTime"+tempK+"Map"+tempNumOfCols);
			tempEventDateTimeForGraf = com.ehis.util.DateUtils.convertDate(tempEventDateTimeForGraf,"DMYHM","en",locale);
			tempDispString = "map"+tempK+"Key"+tempNumOfCols;

			tempTDMap.put(tempDispString,tempReturnString);
			tempTDMap.put("histRecType"+tempK,tempHistRecType);
			tempTDMap.put("eventClass"+tempK,tempEventClass);
			tempTDMap.put("eventGroup"+tempK,tempEventGroup);
			tempTDMap.put("eventCode"+tempK,tempEventCode);
			tempTDMap.put("tempResultNum"+tempDispString,tempResultNum);
			tempTDMap.put("tempEventDateTimeForGraf"+tempDispString,tempEventDateTimeForGraf);
			tempTDMap.put("modifiedyn"+tempK,tempmodified_date_YN);//24094
			tempTDMap.put("lv_neonate_spec_yn"+tempK,templv_neonate_spec_yn);//31792
		}

		int m=0;
		int n=0;
		String tempRetString = "";
		String tempResNumberForGraf = "";
		String tempDateTimeForGraf = "";
	
		String displayStr = "";
		dataBuffer = new StringBuffer();
		StringBuffer tempRowString = new StringBuffer();

		for(m=0;m<=prevK;m++)
		{
			if(m % 2 ==0)
				classValue = "CACHARTQRYEVEN";
			else
				classValue = "CACHARTQRYEVEN";

			tempRowString.setLength(0);

			tempHistRecType = (String) tempTDMap.get("histRecType"+m) == null ? "&nbsp;" : (String) tempTDMap.get("histRecType"+m);
			
			
			tempEventClass = (String) tempTDMap.get("eventClass"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventClass"+m);
			tempEventGroup = (String) tempTDMap.get("eventGroup"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventGroup"+m);
			tempEventCode = (String) tempTDMap.get("eventCode"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventCode"+m);
			tempmodified_date_YN = (String) tempTDMap.get("modifiedyn"+m) == null ? "&nbsp;" : (String) tempTDMap.get("modifiedyn"+m);//24094
			templv_neonate_spec_yn = (String) tempTDMap.get("lv_neonate_spec_yn"+m) == null ? "&nbsp;" : (String) tempTDMap.get("lv_neonate_spec_yn"+m);//31792

			if(!prevHistRecType.equals(tempHistRecType))
			{	
				tempRowString.append("<TR>");
				tempRowString.append("<TD colspan='"+dateList.size()+"'  id='sepID"+m+"' class='CAFLOWSHEETLEVEL1'>&nbsp;</TD>");
				tempRowString.append("</TR>");
				tempRowString.append("<TR>");
				tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL2'>&nbsp;</TD>");
				tempRowString.append("</TR>");
				if(orderByEventCode.equals("N")) { // INT-CRF-BRU-CIS-004 - IN058138 
					if(!tempEventGroup.equals("*ALL"))
					{
						tempRowString.append("<TR>");
						tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
						tempRowString.append("</TR>");
					} 
				}  // INT-CRF-BRU-CIS-004 - IN058138 
				prevHistRecType = tempHistRecType;
				prevEventClass = tempEventClass;
				prevEventGroup = tempEventGroup;
				prevEventCode = tempEventCode;
				dataBuffer.append(tempRowString.toString());
			}
			if(!prevEventClass.equals(tempEventClass))
			{
				tempRowString.append("<TR>");
				tempRowString.append("<TD id='sepID"+m+"' colspan='"+dateList.size()+"' class='CAFLOWSHEETLEVEL2'>&nbsp;</TD>");
				tempRowString.append("</TR>");
				if(orderByEventCode.equals("N")) { // INT-CRF-BRU-CIS-004 - IN058138 
					if(!tempEventGroup.equals("*ALL"))//event group is empty
						{
							tempRowString.append("<TR>");
							tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
							tempRowString.append("</TR>");
						} 
				}  // INT-CRF-BRU-CIS-004 - IN058138 
				prevEventClass = tempEventClass;
				prevEventGroup = tempEventGroup;
				prevEventCode = tempEventCode;
				dataBuffer.append(tempRowString.toString());
			}

			if(!prevEventGroup.equals(tempEventGroup))
			{
				if(orderByEventCode.equals("N")) { // INT-CRF-BRU-CIS-004 - IN058138 
					if(!tempEventGroup.equals("*ALL"))
					{
						tempRowString.append("<TR>");
						tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
						tempRowString.append("</TR>");
					}
				}  // INT-CRF-BRU-CIS-004 - IN058138 
				prevEventGroup = tempEventGroup;
				prevEventCode = tempEventCode;
				dataBuffer.append(tempRowString.toString());
			}
			dataBuffer.append("<tr id='trIDGraph"+m+"'>");

			for(n=0;n<dateList.size();n++)
			{
				displayStr = "map"+m+"Key"+n;
				tempRetString = (String) tempTDMap.get(displayStr);
				tempResNumberForGraf = (String) tempTDMap.get("tempResultNum"+displayStr);
				tempDateTimeForGraf = (String) tempTDMap.get("tempEventDateTimeForGraf"+displayStr);


				if(tempResNumberForGraf == null && tempDateTimeForGraf == null)
				{
					tempResNumberForGraf = " ";
					tempDateTimeForGraf = " ";
				}

				if(tempRetString == null)
				{
					dataBuffer.append("<td id='visibility"+m+"ID"+n+"' class = 'gridDataChart'>&nbsp;<br></td>");
					dataBuffer.append("<td id='duplicate"+m+"ID"+n+"'   style='display:none' class = 'gridDataChart'>&nbsp;<br></td>");
				}
				else
				{
					dataBuffer.append(tempRetString);
				}
				if(!tempDateTimeForGraf.equals(" ") && !tempResNumberForGraf.equals(" "))
					dataBuffer.append("<td id='duplicate"+m+"ID"+n+"' style='display:none' class = 'gridDataChart'>&nbsp;<br></td><input type='hidden' name='hidden"+m+"Values"+n+"' value='"+tempDateTimeForGraf+"^%"+tempResNumberForGraf+"'/>");
			}
			dataBuffer.append("</tr>");
		}//end of for-display
		out.println(dataBuffer.toString());
	}//end of try - 2
	catch(Exception ee)
	{
		//out.println("Exception in try - 2 of FlowSheetEventsData.jsp -"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}

            _bw.write(_wl_block28Bytes, _wl_block28);

	for(i=0;i<dateListSize;i++)
	{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dateList.get(i)));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(prevK+1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dateList.size()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dateList.size()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(allDatesForGraph.toString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strEncId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(eventDateTime));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(enctr_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(histRecType));
            _bw.write(_wl_block61Bytes, _wl_block61);
	
	}
	catch(Exception ee1)
	{
		ee1.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewDocument.label", java.lang.String .class,"key"));
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
}
