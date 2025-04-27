package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chartrecordingintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingIntermediate.jsp", 1738290564566L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name =\"chartRecordingIntermediateForm\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!--\t<script>\n\t\t\t\tvar scope1=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.past_scope.value=scope1;\n\t\t\t\tif(scope1 == \"\")\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryText.value=\"1\";\n\t\t\t\telse\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryText.value=scope1;\n\t\t\t</script> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tasync function toLoadChartRecordingFrameSet(){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar dialogTop\t\t=\t\"80\" ;\t\n\t\t\t\t\t\t\tvar dialogHeight= \"80vh\" ;\n\t\t\t\t\t\t\tvar dialogWidth = \"46vw\" ;\n\t\t\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\t\t\tvar arguments\t\t=\t\"\" ;\n\t\t\t\t\t\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status;\n\t\t\t\t\t\t\tvar action_url\t\t=\t\'../../eCA/jsp/ChartRecordingFrameSet.jsp?chartId=\'+\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"+\'&encounterId=\'+\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\tvar ret = await window.showModalDialog(action_url,arguments,features);\n\t\n\t\t\t\t\t\t\tif(ret != undefined && ret != \'\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonAddItem.style.visibility=\'visible\'\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;\n\n\t\t\t                    var parameterDate = minusDate(systemdate,\"DMYHM\",\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\"d\");\t\t   \n\t\t\t\t\t\t\t    var qs=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t   if(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" !=\"\" || \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" !=\"null\" || \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" !=null)\n\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\tqs +=\"&fromDate=\"+parameterDate;\n\t\t\t\t\t\t\t  }\n\t\t\t\t\t\t\t  if(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"!=\"\" || \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" !=null)\n\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\tqs +=\"&toDate=\"+systemdate;\n\t\t\t\t\t\t\t  }\n\n\t\t\t\t\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"+\"&\"+qs+\"&DEFINE_MODIFIABLE_AT_TRN_YN=\"+\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"+\"&detailYN=\"+\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"+\"&summaryYN=\"+\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"+\"&defaultDate=\"+\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"+\"&summaryText=\"+\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"+\"&sysdate=\"+\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"+\"&function_from=\"+\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"+\"&sort_by=\"+\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"+\"&errorAuth=\"+\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"+\"&modifyYN=\"+\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"+\"&module_id=\"+\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\n\t\t\t\t\t\t\t\tparent.ChartRecordingToolBarFrame.location.href = \"../jsp/ChartRecordingToolBar.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"+\"&\"+qs+\"&errorAuth=\"+\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\t\t\tparent.ChartRecordingControlsFrame.location.href = \"../jsp/ChartRecordingControls.jsp?Chart_Id=\"+\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\t\t\tparent.ChartRecordingColorFrame.location.href = \"../jsp/ChartRecordingColorBar.jsp?module_id=\"+\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\t\t\t//var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById(\"tdIdForClassCriteria\");\n\t\t\t\t\t\t\t\t//tableId.className=\'CACHARTCRITERIA\'\t\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.getElementById(\"dayView\").style.display=\'inline\';\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.getElementById(\"imgDate\").style.display=\'inline\';\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.getElementById(\"label\").style.display=\'inline\';\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility=\'visible\'\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility=\'visible\'\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility=\'visible\'\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility=\'visible\'\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=\'\'\n\t\t\t\t\t\t\t\t//parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=\'\'\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttoLoadChartRecordingFrameSet();\n\t\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t/*var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById(\"tdIdForClassCriteria\");\n\t\t\t\t\t\t\ttableId.className=\'CACHARTCRITERIA\'\t\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"dayView\").style.display=\'inline\';\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"imgDate\").style.display=\'inline\';\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"label\").style.display=\'inline\';\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility=\'visible\'\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility=\'visible\'\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility=\'visible\'\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility=\'visible\'\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=\'\'\n\t\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=\'\'*/\n\n\t\t\t\t\t\t\tvar systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;\n\t\t\t\t\t\t\n\t\t\t                var parameterDate = minusDate(systemdate,\"DMYHM\",\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\"d\");\t\t   \n\t\t\t\t\t\t\tvar qs=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" !=null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tqs +=\"&fromDate=\"+parameterDate;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" !=null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tqs +=\"&toDate=\"+systemdate;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t   \tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\n\t\t\t\t\t\t\tparent.ChartRecordingToolBarFrame.location.href = \"../jsp/ChartRecordingToolBar.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\t\t\tparent.ChartRecordingControlsFrame.location.href = \"../jsp/ChartRecordingControls.jsp?Chart_Id=\"+\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\t\t\t\tparent.ChartRecordingColorFrame.location.href = \"../jsp/ChartRecordingColorBar.jsp?module_id=\"+\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\t/*var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById(\"tdIdForClassCriteria\");\n\t\t\t\t\t\ttableId.className=\'CACHARTCRITERIA\'\t\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"label\").style.display=\'inline\';\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"dayView\").style.display=\'inline\';\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"imgDate\").style.display=\'inline\';\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility=\'visible\'\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility=\'visible\'\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility=\'visible\'\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility=\'visible\'\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=\'\'\n\t\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=\'\'*/\n\t\t\t\t\t\tvar systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;\n\t\t\t            var parameterDate = minusDate(systemdate,\"DMYHM\",\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\"d\");\n\n\t\t\t\t\t\tvar qs=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" !=null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tqs +=\"&fromDate=\"+parameterDate; \n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" !=null)\n\t\t\t\t\t   {\n\t\t\t\t\t\tqs +=\"&toDate=\"+systemdate;\n\t\t\t\t\t   }\n\t\t\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\n\t\t\t\t\t\tparent.ChartRecordingToolBarFrame.location.href = \"../jsp/ChartRecordingToolBar.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\t\t\t\tparent.ChartRecordingControlsFrame.location.href = \"../jsp/ChartRecordingControls.jsp?Chart_Id=\"+\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\t\t\t\tparent.ChartRecordingColorFrame.location.href = \"../jsp/ChartRecordingColorBar.jsp?module_id=\"+\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<script>\t\t\n\t\t\t\t\t/*var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById(\"tdIdForClassCriteria\");\n\t\t\t\t\ttableId.className=\'CACHARTCRITERIA\'\t\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"label\").style.display=\'inline\';\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"dayView\").style.display=\'inline\';\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.getElementById(\"imgDate\").style.display=\'inline\';\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.style.visibility=\'visible\'\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.style.visibility=\'visible\'\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.style.visibility=\'visible\'\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.style.visibility=\'visible\'\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=\'\'\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=\'\'*/\n\n\t\t\t\t\tvar systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;\n\n\t\t\t        var parameterDate = minusDate(systemdate,\"DMYHM\",\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\',\"d\");\n\n\t\t\t\t    var qs=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tqs +=\"&fromDate=\"+parameterDate; \n\t\t\t\t\t}\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" !=null)\n\t\t\t\t\t {\n\t\t\t\t\t   qs +=\"&toDate=\"+systemdate;\n\t\t\t\t\t }\n\t\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\n\t\t\t\t\tparent.ChartRecordingToolBarFrame.location.href = \"../jsp/ChartRecordingToolBar.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t\tparent.ChartRecordingControlsFrame.location.href = \"../jsp/ChartRecordingControls.jsp?Chart_Id=\"+\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\tparent.ChartRecordingColorFrame.location.href = \"../jsp/ChartRecordingColorBar.jsp?module_id=\"+\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar dialogTop\t\t=\t\"80\" ;\t\n\t\t\t\t\t\t\tvar dialogHeight= \"30\" ;\n\t\t\t\t\t\t\tvar dialogWidth = \"40\" ;\n\t\t\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\t\t\tvar arguments\t\t=\t\"\" ;\n\t\t\t\t\t\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status;\n\t\t\t\t\t\t\tvar action_url\t\t=\t\'../../eCA/jsp/ChartRecordingFrameSet.jsp?chartId=\'+\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t\t\tvar ret = window.showModalDialog(action_url,arguments,features);\n\t\n\t\t\t\t\t\t\tif(ret != undefined && ret != \'\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar qs=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" !=\"\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tqs +=\"&fromDate=\"+\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"; \n\t\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"!=\"\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tqs +=\"&toDate=\"+\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar qs=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" !=\"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tqs +=\"&fromDate=\"+\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"; \n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"!=\"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tqs +=\"&toDate=\"+\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\tvar qs=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" !=\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tqs +=\"&fromDate=\"+\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"; \n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"!=\"\")\n\t\t\t\t\t\tqs +=\"&toDate=\"+\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\t\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t<script>\t\t\n\t\t\t\t\tvar qs=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" !=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\tqs +=\"&fromDate=\"+\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"; \n\t\t\t\t\t}\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"!=\"\")\n\t\t\t\t\tqs +=\"&toDate=\"+\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\t\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\"../jsp/ChartRecordingDetail.jsp?chartId=\"+\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n</form>\n</body>\n<script>\n\t\tif(parent.ChartRecordingCriteriaFrame != null)\n\t\t{\n\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.splChartType.value = \'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\';\t\t\t\n\t\t\t\n\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.DEFINE_MODIFIABLE_AT_TRN_YN.value  = \'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\';\n\n\t\t\tvar systemdate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.systime.value;\n\t\t\tvar parameterDate = minusDate(systemdate,\"DMYHM\",\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\',\"d\");\n        \n\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.fromDate.value  = parameterDate;\n\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.toDate.value  = systemdate;\n\t\n\n\t\t\tif(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' == \'Y\')\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' == \'GR\')\n\t\t\t\t{\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonShowRec.style.display  = \'inline\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonShowRec.style.display  = \'none\';\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String encounterId =  request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_id =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ChartRecordingAddGroupBean chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounterId,"eCA.ChartRecordingAddGroupBean",session);		
	chartingBean.clearBean();

            _bw.write(_wl_block5Bytes, _wl_block5);

	String splChartType = "";

	session.removeAttribute("tempDateArray"+encounterId);
	session.removeAttribute("arrayNext"+encounterId);
	String sysdate = "";
	String summaryText = request.getParameter("summaryText")==null?"":request.getParameter("summaryText");
	String chtId= request.getParameter("chartId")==null?"":request.getParameter("chartId");
//	String result= request.getParameter("result")==null?"":request.getParameter("result");
	String errorAuth= request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
	String dateDefault = request.getParameter("dateDefault")==null?"":request.getParameter("dateDefault");
	int recordCount=0;
	String summaryYN = request.getParameter("summaryYN")==null?"N":request.getParameter("summaryYN");
	String detailYN = request.getParameter("detailYN")==null?"Y":request.getParameter("detailYN");
	String queryString =  request.getParameter("qs")==null?"":request.getParameter("qs");
	String sort_by =  request.getParameter("sort_by")==null?"":request.getParameter("sort_by");
	String function_from=  request.getParameter("function_from")==null?"":request.getParameter("function_from");
	String facilityId = (String) session.getValue( "facility_id" )==null ? "" :(String) session.getValue( "facility_id" );			
	String modifyYN = request.getParameter("modifyYN")==null?"Y":request.getParameter("modifyYN");
	String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
//	String fromDateForExt = request.getParameter("fromDateForExt")==null?"":request.getParameter("fromDateForExt");
	//String toDateForExt = request.getParameter("toDateForExt")==null?"":request.getParameter("toDateForExt");
	String locale = request.getParameter("locale")==null?"":request.getParameter("locale");
	
	String fromDate =  "";
	String toDate = "";	
	String DEFINE_MODIFIABLE_AT_TRN_YN="";
	String scope = "";
	StringBuffer sql = new StringBuffer();

	if(function_from.equals("SECONDARY_TRIAGE"))
	{
		fromDate = dateDefault;
		toDate = dateDefault;
	}
	else
	{
		fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
	}	
	Connection con = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt =null;
		ResultSet rs= null;
				
		
		try
		{
			sql.append("select past_rec_scope_days, SPL_CHART_TYPE spl_chart_type, CONFIG_TYPE DEFINE_MODIFIABLE_AT_TRN_YN, to_char(sysdate,'HH24:MI') from ca_chart where chart_id = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,chtId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				scope = rs.getString("past_rec_scope_days") == null ? "" : rs.getString("past_rec_scope_days");
				splChartType = rs.getString("spl_chart_type") == null ? "" : rs.getString("spl_chart_type");
				DEFINE_MODIFIABLE_AT_TRN_YN = rs.getString("DEFINE_MODIFIABLE_AT_TRN_YN");
				sysdate = rs.getString(4);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}
		//if(!function_from.equals("SECONDARY_TRIAGE"))	
		//{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block7Bytes, _wl_block7);

			/*if(scope == "")
				summaryText = "1";
			else
				summaryText = scope;
		}*/

		/*sqlSplChart = "select SPL_CHART_TYPE spl_chart_type from CA_Chart where chart_id = ?";
		psSplChart = con.prepareStatement(sqlSplChart);
		psSplChart.setString(1,chtId);
		resSplChart = psSplChart.executeQuery();

		while(resSplChart != null && resSplChart.next())
		{
			splChartType = resSplChart.getString("spl_chart_type") == null ? "" : resSplChart.getString("spl_chart_type");
		}

		if(resSplChart != null) resSplChart.close();
		if(psSplChart != null) psSplChart.close();
				
		StringBuffer sql = new StringBuffer("select CONFIG_TYPE DEFINE_MODIFIABLE_AT_TRN_YN ,to_char(sysdate,'HH24:MI') from ca_chart where chart_id = ? ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,chtId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			DEFINE_MODIFIABLE_AT_TRN_YN = rs.getString("DEFINE_MODIFIABLE_AT_TRN_YN");
			sysdate = rs.getString(2);
		}
		if (pstmt!=null) pstmt.close();
		if( rs!=null) rs.close();*/


/************************************************************************/
		if(!function_from.equals("SECONDARY_TRIAGE"))
		{
			//out.println("<script>alert('scope in side function_from"+scope+"')</script>");
			if(modifyYN.equals("Y"))
			{
				//out.println("<script>alert('scope in side modifyYN"+scope+"')</script>");

				if(DEFINE_MODIFIABLE_AT_TRN_YN.equals("Y"))
				{
					//out.println("<script>alert('scope in side DEFINE_MODIFIABLE_AT_TRN_YN"+scope+"')</script>");
					
					sql = new StringBuffer("select count(*)  from CA_ENCNTR_CHART_DRAFT where encounter_id = ?  and chart_id = ? and FACILITY_ID=? ");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,encounterId);
					pstmt.setString(2,chtId);
					pstmt.setString(3,facilityId);
					rs = pstmt.executeQuery();	
					while(rs.next())
					{
						recordCount = rs.getInt(1);
					}
					if (pstmt!=null) pstmt.close();
					if( rs!=null) rs.close();	
					if(recordCount == 0)	
					{
						//out.println("<script>alert('scope if record count is zero"+scope+"')</script>");
					

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
	
					}
					else
					{
						//out.println("<script>alert('scope in record count is not zero eld"+scope+"')</script>");
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonAddItem.style.visibility='visible' </script>");

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block43Bytes, _wl_block43);

					}
				}
				else
				{
					//out.println("<script>alert('scope out side DEFINE_MODIFIABLE_AT_TRN_YN"+scope+"')</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonAddItem.style.visibility='hidden' </script>");

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
				}
			}
			else
			{
				//out.println("<script>alert('scope out side modifyYN"+scope+"')</script>");

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
			
					}
				
		}
		else if(function_from.equals("SECONDARY_TRIAGE"))
		{
			//out.println("<script>alert('scope out side SECONDARY_TRIAGE function_from"+scope+"')</script>");
			
			if(modifyYN.equals("Y"))
			{
				if(DEFINE_MODIFIABLE_AT_TRN_YN.equals("Y"))
				{					
					sql = new StringBuffer("select count(*)  from CA_ENCNTR_CHART_DRAFT where encounter_id = ?  and chart_id = ? and FACILITY_ID=? ");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,encounterId);
					pstmt.setString(2,chtId);
					pstmt.setString(3,facilityId);
					rs = pstmt.executeQuery();	
					while(rs.next())
					{
						recordCount = rs.getInt(1);
					}
					if (pstmt!=null) pstmt.close();
					if( rs!=null) rs.close();	
					if(recordCount == 0)	
					{				

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
	
					}
					else
					{

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block43Bytes, _wl_block43);

					}
				}
				else
				{

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
				}
			}
			else
			{

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(chtId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryText));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
			}
			
		}//end of main else
			
	}
	catch(Exception ee)
	{
	//	out.println("Exception From Chart Recording Intermediate JSP :"+ee.toString());//COMMON-ICN-0181
                   ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)
					ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(DEFINE_MODIFIABLE_AT_TRN_YN));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scope));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block93Bytes, _wl_block93);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
