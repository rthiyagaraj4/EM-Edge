package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __clinicaleventhistoryresultdates extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventHistoryResultDates.jsp", 1742381624310L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HEAD>\n\t<TITLE> New Document </TITLE>\n\t<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n\t<META NAME=\"Author\" CONTENT=\"\">\n\t<META NAME=\"Keywords\" CONTENT=\"\">\n\t<META NAME=\"Description\" CONTENT=\"\">\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventHistoryNew.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction populateEvents(){\n\t\tvar queryStr   =document.forms[0].queryString.value;\n\t\t//Adding start for IN072762\n\t\tvar pract_id        = document.forms[0].clinician_id.value;\n\t\tvar patient_class   = document.forms[0].patient_class.value;\n\t\tvar patient_id      = document.forms[0].patient_id.value;\n\t\tvar from_date       = document.forms[0].fromDate.value;\n\t\tvar to_date         = document.forms[0].toDate.value;\n\t\tvar generic_id      = document.forms[0].generic_id.value;\n\t\tvar drug_id         = document.forms[0].drug_code.value;\n\t\tvar status          = document.forms[0].med_status.value;\n\t\tvar encounter_id    = document.forms[0].encounterId.value;\n\t\tvar facility_id     = document.forms[0].fac_id.value;\n\t\tvar selTab          = document.forms[0].selTab.value;\n\t\tvar order_type      = document.forms[0].order_type.value;\n\t\tvar date_order      = document.forms[0].date_Ordr.value;\n\t\tvar item_type       = document.forms[0].item_type.value;\n\t\tvar selHistType     = document.forms[0].selHistType.value;\n\t\t\n\t\tif(\"MEDN\"==document.forms[0].selHistType.value){\n\t\t\t\t//parent.document.getElementById(\"eventDetails\").cols=\"12%,0%,*,0%\";\n\t\t\t\tparent.document.getElementById(\"eventNamesFrame\").style.width=\"0vw\";\n\t\t\t\tparent.document.getElementById(\"eventDataFrame\").style.width=\"85vw\";\n\t\t\t\tparent.eventDataFrame.location.href=\"../../eCA/jsp/MedicationOrdersFrams.jsp?pract_id=\"+pract_id+\"&patient_class=\"+patient_class+\"&patient_id=\"+patient_id+\"&from_date=\"+from_date+\"&to_date=\"+to_date+\"&generic_id=\"+generic_id+\"&drug_id=\"+drug_id+\"&status=\"+status+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&selTab=\"+selTab+\"&order_type=\"+order_type+\"&date_order=\"+date_order+\"&item_type=\"+item_type+\"&selHistType=\"+selHistType;\n\t\t}else{//Adding end for IN072762\n\t\t\tif(\"CLNT\"==document.forms[0].selHistType.value){\n\t\t\t\t//parent.document.getElementById(\"eventDetails\").cols=\"12%,0%,*,0%\";\n\t\t\t\t\n\t\t\t\tparent.document.getElementById(\"eventNamesFrame\").style.width=\"0vw\";\n\t\t\t\tparent.document.getElementById(\"eventDataFrame\").style.width=\"85vw\";\n\n\t\t\t\tparent.eventNamesFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.eventDataFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryClinicalNoteData.jsp?\"+queryStr; //IN071596\t\t\t\n\t\t\t}else if(\"RDIN\"==document.forms[0].selHistType.value){ //IN072759\n\t\t\t\t//parent.document.getElementById(\"eventDetails\").cols=\"12%,0%,*,0%\";\n\t\t\t\tparent.document.getElementById(\"eventNamesFrame\").style.width=\"0vw\";\n\t\t\t\tparent.document.getElementById(\"eventDataFrame\").style.width=\"85vw\";\n\t\t\t\tparent.eventNamesFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.eventDataFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryRadiologyData.jsp?\"+queryStr; //IN071596\n\t\t\t}\n\t\t\telse if(\"SUNT\"==document.forms[0].selHistType.value){ //IN072760 starts\n\t\t\t\t//parent.document.getElementById(\"eventDetails\").cols=\"12%,0%,*,0%\";\n\t\t\t\tparent.document.getElementById(\"eventNamesFrame\").style.width=\"0vw\";\n\t\t\t\tparent.document.getElementById(\"eventDataFrame\").style.width=\"85vw\";\n\t\t\t\tparent.eventNamesFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.eventDataFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryOTSurgeryData.jsp?\"+queryStr;\n\t\t\t}//IN072760 ends\n\t\t\telse if(\"MERP\"==document.forms[0].selHistType.value){ //6450 starts\n\t\t\t\t//parent.document.getElementById(\"eventDetails\").cols=\"12%,0%,*,0%\";\n\t\t\t\tparent.document.getElementById(\"eventNamesFrame\").style.width=\"0vw\";\n\t\t\t\tparent.document.getElementById(\"eventDataFrame\").style.width=\"85vw\";\n\t\t\t\tparent.eventNamesFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.eventDataFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryMedicalReports.jsp?\"+queryStr;\n\t\t\t}//6450 ends\n\t\t\telse{\n\t\t\t\t//parent.document.getElementById(\"eventDetails\").cols=\"12%,25%,*,0%\";\n\t\t\t\tparent.document.getElementById(\"eventNamesFrame\").style.width=\"25vw\";\n\t\t\t\tparent.document.getElementById(\"eventDataFrame\").style.width=\"62vw\";\n\t\t\t\tparent.eventNamesFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryResultEvents.jsp?\"+queryStr;\n\t\t\t\tparent.eventDataFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryResultData.jsp?\"+queryStr;\n\t\t\t}\n\t\t\t\n\t\t}    \n\t\tparent.controlsFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryControls.jsp?\"+queryStr;\n\t\tparent.ClinicalEventButtonFrame.location.href=\"../../eCA/jsp/ClinicalEventHistoryButtons.jsp?\"+queryStr;\t\t\n\t}\n\t</script>\n</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n     <BODY   class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onScroll=\'datesScrollFrame()\' onKeyDown=\"lockKey()\"><!-- Moved body and form below to here for IN073751  -->\n\t\t\t\t<form name=\'flowSheetEventsForm\' id=\'flowSheetEventsForm\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<!-- moved up for IN073751<BODY   class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onScroll=\'datesScrollFrame()\' onKeyDown=\"lockKey()\">\n\t\t\t\t<form name=\'flowSheetEventsForm\' id=\'flowSheetEventsForm\'> -->\n\t\t\t\t\t<div id=\'divDateTitle\' style=\'postion:relative\'>\n\t\t\t\t\t\t<TABLE  width=\'100%\' id=\'dateTitleTable\' class=\'grid\' border=\"1\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\' >\n\t\t\t\t\t\t\t<TR><td class=\'gridHeader\' nowrap align=\"center\">Recorded Date/Time</td></TR>\t\t\t\t\n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t</div>\n\t\t\t\t\t<TABLE width=\'100%\' id=\'dateTable\' class=\'grid\' border=\"1\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<TR id=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t\t<TD class=\'QRYODDNOBORDER\' width=\'100%\' onClick=\"moveScroll(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\"><A href=\"#\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\t\t\t\t\t\t\t<!-- 24094  starts-->\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t&nbsp;<img src=\'../../eCA/images/modifiedresult.png\' />\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TD>\n\t\t\t\t\t\t\t\t<!-- item_type ,envdates added for //IN072762 --<!-- 24094 ends-->\t\t\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t     <input type=\'hidden\' name=\'event_date\' id=\'event_date\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'/><!-- 24094 -->\t\n\t\t\t\t\t     <input type=\'hidden\' name=\'modifiedyn\' id=\'modifiedyn\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'/><!-- 24094 -->\t\n\t\t\t\t    \t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD class=\'QRYEVENNOBORDER\' colspan=\"3\">&nbsp;</TD>\n\t\t\t\t\t\t</TR>\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"currentScrollPositon\" id=\"currentScrollPositon\" value=\"0\"/>\t\t\t\n\t\t\t\t\t</Table>\t\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\'queryString\' name=\'queryString\' />\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\'ql_ref\' name=\'ql_ref\' /><!--IN069654-->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\'ql_nlcyInd\' name=\'ql_nlcyInd\' /><!--IN069654-->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\'selHistType\' name=\"selHistType\"/>\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\'clinician_id\' name=\"clinician_id\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\'patient_class\' name=\"patient_class\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\'patient_id\' name=\"patient_id\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\'fac_id\' name=\"fac_id\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\'date_Ordr\' name=\"date_Ordr\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\'encounterId\' name=\"encounterId\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\'fromDate\' name=\"fromDate\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\'toDate\' name=\"toDate\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\'med_status\' name=\"med_status\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\'drug_code\' name=\"drug_code\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\'generic_id\' name=\"generic_id\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\'order_type\' name=\"order_type\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\'item_type\' name=\"item_type\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\'selTab\' name=\"selTab\"/><!-- MO-CRF-20101.11 -->\n\t\t\t\t\t<script>\n\t\t\t\t\t\tpopulateEvents();\n\t\t\t\t\t\tif(top.content!=null)\n\t\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\t\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\t\n\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t<!-- moved body and for below for IN073751</form>\n\t\t\t</BODY> -->\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t            <input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\'ql_ref\' name=\'ql_ref\' /><!--IN073751-->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\'ql_nlcyInd\' name=\'ql_nlcyInd\' /><!--IN073751-->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\'clinician_id\' name=\"clinician_id\"/><!-- IN073751 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\'patient_class\' name=\"patient_class\"/><!-- IN073751 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\'patient_id\' name=\"patient_id\"/><!-- IN073751 -->\n\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\'selTab\' name=\"selTab\"/><!-- MO-CRF-20101.11 -->\n\t\t\t<script>\n\t\t\t\tvar  selHistType = document.forms[0].selHistType.value;//ADding start for IN073751\n\t\t\t\tif(selHistType ==\"MEDN\"){\n\t\t\t\t\tpopulateEvents();\n\t\t\t\t}else{//Adding end for IN073751\n\t\t\t\t\tparent.eventNamesFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.eventDataFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.controlsFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.ClinicalEventButtonFrame.location.href=\"../../eCommon/html/blank.html\";<!--IN069243-->\n\t\t\t\t\tif(top.content!=null)\t\t\t\n\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</form>\n</BODY>\n</html>\n\n";
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

/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7		
21/07/2020  	IN072759	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.8
22/08/2020      IN073751    Chandrashekar                                   MO-CRF-20101.11
21/09/2020  	IN072760	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.9
26/11/2020	6450		SIVABAGYAM M	26/11/2020		RAMESH G	MO-CRF-20101.10
20/07/2023	  24094	   Ranjith P R		21/07/2023		RAMESH G		ML-MMOH-CRF-1804
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Properties p;
	session 		= request.getSession(false);
	p 				= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale 	= (String) p.getProperty("LOCALE");
	Connection con 	= null;
	
	String bean_id				= "NewClinicalEventHistBean" ;
	String bean_name			= "eCA.NewClinicalEventHistBean";
	String bean_id_1			= "MedicationOrdersBean" ;//Added for MO-CRF-20101.11
	String bean_name_1			= "eCA.MedicationOrdersBean";//Added for MO-CRF-20101.11
	String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String facilityid 			= (String)session.getValue("facility_id");
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id				= (String)session.getValue("responsibility_id");
	String orderCatalogNature	= request.getParameter("orderCatalogNature")==null?"":request.getParameter("orderCatalogNature");
	String ql_ref				= request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");//IN069654
	String ql_nlcyInd			= request.getParameter("ql_nlcyInd")==null?"":request.getParameter("ql_nlcyInd");//IN069654
	String selTab				= request.getParameter("selTab")==null?"":request.getParameter("selTab");
	//IN069654 starts
	String abnormal				= request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
	String eventCls				= request.getParameter("eventCls")==null?"":request.getParameter("eventCls");
	String eventGrp				= request.getParameter("eventGrp")==null?"":request.getParameter("eventGrp");
	String eventItem			= request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String date_Ordr			= request.getParameter("date_Ordr")==null?"":request.getParameter("date_Ordr");
	String reln_id				= request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String patient_class		= request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	//IN069654 ends
	if(date_Ordr.equals(""))
		date_Ordr="D";

	String encounterId 			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
	String fac_id 				= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String fromDate 			= request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	String toDate 				= request.getParameter("to_date")==null	?"":request.getParameter("to_date");	
	String grphistory_type		= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");
	String selHistType			= request.getParameter("selHistType")==null	?"LBIN":request.getParameter("selHistType");
	String med_status			= request.getParameter("status")==null	?"":request.getParameter("status");//IN072762
	String drug_code			= request.getParameter("drug_id")==null	?"":request.getParameter("drug_id");//IN072762
	String generic_id			= request.getParameter("generic_id")==null	?"":request.getParameter("generic_id");//IN072762
	String order_type        	= request.getParameter("order_type")==null	?"":request.getParameter("order_type");//IN072762
	String item_type            = request.getParameter("item_type")==null?"D":request.getParameter("item_type");//IN072762
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
	MedicationOrdersBean bean_1		= (MedicationOrdersBean)getBeanObject( bean_id_1, bean_name_1 , request) ;//IN072762
	ArrayList eventDates = new ArrayList() ;
	try{
		con = ConnectionManager.getConnection(request);	
		//eventDates = bean.getEventDates(con,locale,grphistory_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,orderCatalogNature,selTab,fac_id,abnormal,eventCls,eventGrp,eventItem,reln_id,date_Ordr,patient_class,facilityid); //IN069654
		if(selHistType.equals("MEDN")){//Added if else Condition for MO-CRF-20101.11
		       if(item_type.equals(""))
				   item_type ="D";
			eventDates = bean_1.getMedicationEventDates(con,locale,patient_id,encounterId,clinician_id,fromDate,toDate,selTab,patient_class,fac_id,med_status,drug_code,generic_id,item_type,order_type,date_Ordr); 
		}else if(selHistType.equals("MERP")){//6450 starts
			bean.clear();
			ArrayList searchData = new ArrayList();		
			searchData = bean.getMedicalReports(patient_id,fac_id,clinician_id,fromDate,toDate,selTab,encounterId,date_Ordr,patient_class);
			eventDates=	bean.getEvent_date();
		}//6450 ends
		else{
		
		eventDates = bean.getEventDates(con,locale,selHistType,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,orderCatalogNature,selTab,fac_id,abnormal,eventCls,eventGrp,eventItem,reln_id,date_Ordr,patient_class,facilityid); //IN069654
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

		if(eventDates!=null && !(eventDates.isEmpty())){

            _bw.write(_wl_block9Bytes, _wl_block9);

						//24094 starts
						for(int i=0;i<eventDates.size();i++){
						HashMap<String,String>  resultMap= new HashMap<String,String>();
						resultMap = (HashMap<String,String>)eventDates.get(i);
						// 24094 ends
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(selHistType));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(item_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)resultMap.get("Event_Date")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)resultMap.get("Event_Date")));
            _bw.write(_wl_block14Bytes, _wl_block14);
 String Modifiedyn =(String)resultMap.get("Modified_Date_YN");
							if(Modifiedyn.equals("Y")){
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)resultMap.get("Event_Date")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)resultMap.get("Modified_Date_YN")));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ql_ref));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ql_nlcyInd));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(selHistType));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date_Ordr));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(med_status));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(item_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(selTab));
            _bw.write(_wl_block38Bytes, _wl_block38);
	
		}else{		
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ql_ref));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ql_nlcyInd));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(selHistType));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date_Ordr));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(med_status));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(item_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(selTab));
            _bw.write(_wl_block45Bytes, _wl_block45);

		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
