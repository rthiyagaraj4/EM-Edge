package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eBL.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blgenrcptforvendorsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLGenRcptForVendorsResult.jsp", 1737916051585L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n29-JAN-2019      100           \tAravindh.H          Created\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/BLGenRcptForVendorsScript.js\'></script>\n\t<script type=\"text/javascript\">\n\t\t$(document).ready(function() {\n\t\t\tif($(\'#traverse\').val() == \'Y\'){\n\t\t\t\t$(\'#trProgress\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#trProgress\').hide();\n\t\t\t}\n\t\t\t\n\t\t\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t\t\t$(\'#nextSpan\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#nextSpan\').hide();\n\t\t\t}\n\t\t\t\t\n\t\t\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t\t\t$(\'#previousSpan\').show();\t\n\t\t\t}else{\n\t\t\t\t$(\'#previousSpan\').hide();\n\t\t\t}\n\t\t\t\t\n\t\t\t$(\'#nextSpan\').click(function(){\n\t\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\t\tvar rsltFormObj = document.genRcptForVendorsRsltFrm;\n\t\t\t\tvar xmlString = formXMLStringMain(rsltFormObj);\n\t\t\t\tvar updation = formValidation(xmlString, \"MODIFY\");\n\t\t\t\t\n\t\t\t\tdocument.location.href = \"../../eBL/jsp/BLGenRcptForVendorsResult.jsp?\"\n\t\t\t\t\t+ \"facilityId=\"+$(\'#facilityId\').val()+\"&locale=\"+$(\'#locale\').val()+\"&strLoggedUser=\"+$(\'#locale\').val()+\"&vendorType=\"+$(\'#vendorType\').val()\n\t\t\t\t\t+ \"&patientId=\"+$(\'#patientId\').val()+\"&patientName=\"+$(\'#patientName\').val()+\"&practoDateFrom=\"+$(\'#practoDateFrom\').val()+\"&practoDateTo=\"+$(\'#practoDateTo\').val()\n\t\t\t\t\t+ \"&receiptStatus=\"+$(\'#receiptStatus\').val()+\"&mode=MODIFY&pat_id_len=\"+$(\'#pat_id_len\').val()+\"&clientIpAddress=\"+$(\'#clientIpAddress\').val()\n\t\t\t\t\t+ \"&fromRcrd=\"+startFrom+\"&toRcrd=\"+endWith;\n\t\t\t});\n\t\t\t\n\t\t\t$(\'#previousSpan\').click(function(){\n\t\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\t\tvar endWith = \"\";\n\t\t\t\tif($(\'#toRcrd\').val() == $(\'#totalRecord\').val()) {\n\t\t\t\t\tendWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#totalRecord\').val()%$(\'#constCount\').val());\n\t\t\t\t} else {\n\t\t\t\t\tendWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tvar rsltFormObj = document.genRcptForVendorsRsltFrm;\n\t\t\t\tvar xmlString = formXMLStringMain(rsltFormObj);\n\t\t\t\tvar updation = formValidation(xmlString, \"MODIFY\");\n\t\t\t\t\n\t\t\t\tdocument.location.href = \"../../eBL/jsp/BLGenRcptForVendorsResult.jsp?\"\n\t\t\t\t\t+ \"facilityId=\"+$(\'#facilityId\').val()+\"&locale=\"+$(\'#locale\').val()+\"&strLoggedUser=\"+$(\'#locale\').val()+\"&vendorType=\"+$(\'#vendorType\').val()\n\t\t\t\t\t+ \"&patientId=\"+$(\'#patientId\').val()+\"&patientName=\"+$(\'#patientName\').val()+\"&practoDateFrom=\"+$(\'#practoDateFrom\').val()+\"&practoDateTo=\"+$(\'#practoDateTo\').val()\n\t\t\t\t\t+ \"&receiptStatus=\"+$(\'#receiptStatus\').val()+\"&mode=MODIFY&pat_id_len=\"+$(\'#pat_id_len\').val()+\"&clientIpAddress=\"+$(\'#clientIpAddress\').val()\n\t\t\t\t\t+ \"&fromRcrd=\"+startFrom+\"&toRcrd=\"+endWith;\n\t\t\t});\n\t\t});\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\">\n\t<form name=\"genRcptForVendorsRsltFrm\" id=\"genRcptForVendorsRsltFrm\" id=\"genRcptForVendorsRsltFrm\">\n\t\t<table width=\"100%\" align=\"center\" cellpadding=0 cellspacing=0  width=\"100%\" border=\"0\" >\n\t\t\t<thead>\n\t\t\t\t<tr height=25px; style=\"background-color: white; border: none;\" id=\'trProgress\'>\n\t\t\t\t\t<th width=10% nowrap>Patient Data</th>\n\t\t\t\t\t<th width=90% nowrap align=right>\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"color: blue; cursor: pointer;cursor:pointer; \">\n\t\t\t\t\t\t\t<span id=\'previousSpan\'>&lt;&lt;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span>\n\t\t\t\t\t\t</span>&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"color: blue; cursor: pointer;cursor:pointer; \">\n\t\t\t\t\t\t\t<span id=\'nextSpan\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&gt;&gt;</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</th>\n\t\t\t\t</tr>\n\t\t\t</thead>\n\t\t</table>\n\t\t<table width=\"100%\" align=\"center\" cellpadding=3 cellspacing=0  width=\"100%\" border=\"1\" >\n\t\t\t<thead>\n\t\t\t\t<tr>\n\t\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t<input type=\"hidden\" name=\'chkAll\' id=\'chkAll\' id=\'chkAll\' value=\'N\' />\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<input type=\"checkbox\" name=\'chkAll\' id=\'chkAll\' id=\'chkAll\' onclick=\'return checkAll()\' />\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</th>\n\t\t\t\t\t<th nowrap>Patient ID</th>\n\t\t\t\t\t<th nowrap>Patient Name</th>\n\t\t\t\t\t<th nowrap>Date of Birth</th>\n\t\t\t\t\t<th nowrap>Gender</th>\n\t\t\t\t\t<th nowrap>Practo<br>Transaction Id.</th>\n\t\t\t\t\t<th nowrap>Practo Rec.No.</th>\n\t\t\t\t\t<th nowrap>Practo Rec.<br>Amt in Rs.</th>\n\t\t\t\t\t<th nowrap>Practo Rec.<br>Date</th>\n\t\t\t\t\t<th nowrap>EM Receipt No.</th>\n\t\t\t\t\t<th nowrap>EM Receipt<br>Date</th>\n\t\t\t\t\t<th nowrap>Comments</th>\n\t\t\t\t</tr>\n\t\t\t</thead>\n\t\t\t<tbody>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td align=center>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\'chk_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'chk_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' disabled />\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onclick=\"chkEmptyPatientId(this, ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\" checked />\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =")\" />\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'patId_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'patId_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' />\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'patId_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' maxlength=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' size=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\t\t\t\t\t\t\t\tonBlur=\"if(this.value != \'\') {ChangeUpperCase(this);callPatValidation(this, \'result\', ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =");} else {patientIdLookup(this, \'result\', ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =");}\">&nbsp;\n\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'patIDSrch_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'patIDSrch_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'\n\t\t\t\t\t\t\t\tid=\'patIDSrch_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onClick=\"patientIdLookup(patId_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =", \'result\', ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")\" tabIndex=\'2\' />\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'patName_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'patName_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' />\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'patDob_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'patDob_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'patGender_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'patGender_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practoTransId_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'practoTransId_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practoRcptNo_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'practoRcptNo_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' />\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=right>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practoRcptAmt_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'practoRcptAmt_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practoRcptDate_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'practoRcptDate_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'emRcptNo_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'emRcptNo_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'emRcptDate_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'emRcptDate_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' />\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'emComments_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'emComments_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' />\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practoDocTypeCode_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'practoDocTypeCode_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' />\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practoDocNo_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'practoDocNo_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' />\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'slmtDocRefDesc_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'slmtDocRefDesc_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' />\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'slmtDocRefDate_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'slmtDocRefDate_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' />\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t</tbody>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" \t\t\t\t\tid=\"locale\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" />\n\t\t<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" \t\t\t\tid=\"facilityId\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" />\n\t\t<input type=\"hidden\" name=\"todaysDate\" id=\"todaysDate\"\t\t\t\tid=\"todaysDate\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" />\n\t\t<input type=\"hidden\" name=\"strLoggedUser\" id=\"strLoggedUser\" \t\t\tid=\"strLoggedUser\" \t\t\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" />\n\t\t<input type=\"hidden\" name=\"clientIpAddress\" id=\"clientIpAddress\" \t\tid=\"clientIpAddress\" \t\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" />\n\t\t<input type=\"hidden\" name=\"vendorType\" id=\"vendorType\" \t\t\t\tid=\"vendorType\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" />\n\t\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\"\t\t\t\tid=\"patientId\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" />\n\t\t<input type=\"hidden\" name=\"patientName\" id=\"patientName\" \t\t\tid=\"patientName\" \t\t\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" />\n\t\t<input type=\"hidden\" name=\"practoDateFrom\" id=\"practoDateFrom\" \t\t\tid=\"practoDateFrom\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" />\n\t\t<input type=\"hidden\" name=\"practoDateTo\" id=\"practoDateTo\"\t\t\tid=\"practoDateTo\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" />\n\t\t<input type=\"hidden\" name=\"receiptStatus\" id=\"receiptStatus\"\t\t\tid=\"receiptStatus\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" />\n\t\t<input type=\"hidden\" name=\"pat_id_len\" id=\"pat_id_len\"\t\t\t\tid=\"pat_id_len\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" />\n\t\t<input type=\"hidden\" name=\"practoCashCounterCode\" id=\"practoCashCounterCode\"\tid=\"practoCashCounterCode\"\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" />\n\t\t<input type=\"hidden\" name=\"practoUser\" id=\"practoUser\"\t\t\t\tid=\"practoUser\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" />\n\t\t<input type=\"hidden\" name=\"practoSlmtType\" id=\"practoSlmtType\"\t\t\tid=\"practoSlmtType\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" />\n\t\t\n\t\t<input type=\'hidden\' name=\'totalRecord\' id=\'totalRecord\'\t\tid=\'totalRecord\'\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\' \t\tid=\'fromRcrd\' \t\tvalue=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\' \t\t\tid=\'toRcrd\' \t\tvalue=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t<input type=\'hidden\' name=\'constCount\' id=\'constCount\' \t\tid=\'constCount\' \tvalue=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t\t<input type=\'hidden\' name=\'hdnNextSpan\' id=\'hdnNextSpan\' \tid=\'hdnNextSpan\' \tvalue=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t\t<input type=\'hidden\' name=\'prevSpan\' id=\'prevSpan\' \t\tid=\'prevSpan\' \t\tvalue=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t\t<input type=\'hidden\' name=\'traverse\' id=\'traverse\' \t\tid=\'traverse\' \t\tvalue=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n</html>\n\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );
	
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


private String nulltoStr(String inputString) {
	if (inputString == null) {
		return "";
	} else {
		return inputString;
	}
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1			 V211020												Mohanapriya K
 */ 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			
	String facilityId = nulltoStr(request.getParameter("facilityId"));
	String locale = nulltoStr(request.getParameter("locale"));
	String strLoggedUser = nulltoStr(request.getParameter("strLoggedUser"));
	String clientIpAddress = nulltoStr(request.getParameter("clientIpAddress"));
	String vendorType = nulltoStr(request.getParameter("vendorType"));
	String patientId = nulltoStr(request.getParameter("patientId"));
	String patientName = nulltoStr(request.getParameter("patientName"));
	String practoDateFrom = nulltoStr(request.getParameter("practoDateFrom"));
	String practoDateTo = nulltoStr(request.getParameter("practoDateTo"));
	String receiptStatus = nulltoStr(request.getParameter("receiptStatus"));
	String patIdLength = nulltoStr(request.getParameter("patIdLength"));
	String mode	= nulltoStr(request.getParameter("mode"));
	
	String practoCashCounterCode = "", practoUser = "", practoSlmtType = "";
	
	//For Traversal Starts
	String nextYn = "N", prevYn = "N", traversal = "N", fromRcrd = "", toRcrd = "";
	int startIndex = 0, startRcrd = 0, endRcrd = 0, totalRecord=0, constCount = 20;
	
	fromRcrd = nulltoStr(request.getParameter("fromRcrd"));
	toRcrd = nulltoStr(request.getParameter("toRcrd"));
	
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	} else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	} else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;
	//For Traversal Ends
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "", currDate = "", prevDate = "";
	int pat_id_len = 0;
	
	try {
		if (strLoggedUser == null) strLoggedUser = "";
		if("".equals(patIdLength)) {
			patIdLength = "15";
		}
		pat_id_len = Integer.parseInt(patIdLength);
		
		con = ConnectionManager.getConnection(request);
		sql = "SELECT def_practo_cash_ctr_code, def_practo_user, def_practo_slmt_type FROM bl_parameters WHERE operating_facility_id = '"+facilityId+"'";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			practoCashCounterCode = rs.getString("def_practo_cash_ctr_code");
			practoUser = rs.getString("def_practo_user");
			practoSlmtType = rs.getString("def_practo_slmt_type");
		}
	
		System.out.println("facilityId:" + facilityId + " strLoggedUser:" + strLoggedUser);
		
		String bean_id			= "bl_BLGenRcptForVendorsBean" ;
		String bean_name		= "eBL.BLGenRcptForVendorsBean";
		String modifyStatus     = "";
		BLGenRcptForVendorsBean bean			= (BLGenRcptForVendorsBean)getBeanObject( bean_id, bean_name, request ) ;
		
		if("search".equals(mode)) {
			bean.setDBValues(mode, facilityId, vendorType, patientId, patientName, practoDateFrom, practoDateTo, receiptStatus);
		}
		//con = ConnectionManager.getConnection(request); //V211020

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 if("G".equals(receiptStatus) || "A".equals(receiptStatus)) { 
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else { 
            _bw.write(_wl_block12Bytes, _wl_block12);
 } 
            _bw.write(_wl_block13Bytes, _wl_block13);
 
						//For Traversal Start
						totalRecord = bean.getList().size();
						
						if(startRcrd>1){
							prevYn = "Y";
							traversal = "Y";
						}
						
						if((startRcrd+constCount) <= totalRecord){
							nextYn = "Y";
							traversal = "Y";
						}
						
						if(endRcrd > totalRecord) {
							endRcrd = totalRecord;
						}
						//For Traversal Ends
						
						
						for(int i = startRcrd-1; i < endRcrd; i++) {
						BLGenRcptForVendorsBean rcptBean = bean.getList().get(i);
					
            _bw.write(_wl_block14Bytes, _wl_block14);
 if("G".equals(rcptBean.getStatus()) || "A".equals(receiptStatus)) { 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
 
								} else {
									if("Y".equals(rcptBean.getChkBoxStatus())) {
								
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
 } else { 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
 
									}
								}
								
            _bw.write(_wl_block21Bytes, _wl_block21);
 if((null != rcptBean.getPatientId() && !"null".equals(rcptBean.getPatientId()) && !"".equals(rcptBean.getPatientId())) || "G".equals(rcptBean.getStatus()) || "A".equals(receiptStatus)) { 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( null != rcptBean.getPatientId()?!"null".equals(rcptBean.getPatientId())?"".equals(rcptBean.getPatientId())?"&nbsp;":rcptBean.getPatientId():"&nbsp;":"&nbsp;" ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( rcptBean.getPatientId() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 } else { 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
 }  
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rcptBean.getPatientName() ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getPatientName() ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rcptBean.getDob() ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getDob() ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf("M".equals(rcptBean.getGender())?"Male":"F".equals(rcptBean.getGender())?"Female":"Unknown" ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getGender() ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rcptBean.getPractoTransactionId() ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getPractoTransactionId() ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rcptBean.getPractoReceiptNo() ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getPractoReceiptNo() ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rcptBean.getPractoReceiptAmount() ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getPractoReceiptAmount() ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rcptBean.getPractoReceiptDate() ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getPractoReceiptDate() ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf("".equals(rcptBean.getEmReceiptNo())?"&nbsp;":rcptBean.getEmReceiptNo() ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getEmReceiptNo() ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf("".equals(rcptBean.getEmReceiptDate())?"&nbsp;":rcptBean.getEmReceiptDate() ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getEmReceiptDate() ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf("".equals(rcptBean.getCommnets())?"&nbsp;":rcptBean.getCommnets() ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getCommnets() ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getPractoDocTypeCode() ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getPractoDocNo() ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getSlmtDocRefDesc() ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rcptBean.getSlmtDocRefDate() ));
            _bw.write(_wl_block70Bytes, _wl_block70);
 } 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(strLoggedUser));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(clientIpAddress));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(vendorType));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(practoDateFrom));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(practoDateTo));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(receiptStatus));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(practoCashCounterCode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(practoUser));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(practoSlmtType));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totalRecord ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block93Bytes, _wl_block93);

	} catch(Exception e) {
		System.err.println("Error in BLGenRcptForVendorsResult.jsp: "+e);
		e.printStackTrace();
	} finally {
		if(con != null) {
			ConnectionManager.returnConnection(con, request);
		} if(pstmt != null) {
			pstmt.close();
		} if(rs != null) {
			rs.close();
		}
	}

            _bw.write(_wl_block94Bytes, _wl_block94);
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
}
