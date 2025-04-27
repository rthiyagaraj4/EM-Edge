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
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blinvoicereports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInvoiceReports.jsp", 1727255676067L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           TFS/Incident        SCF/CRF   \t\t\tDeveloper Name\n------------------------------------------------------------------------------------------------\n1          V201118/V201214     8071/74237        MOHE-CRF-0050.4      \tMohana Priya K\n2            V210106            12438          BL-MOHE-CRF-0050.4-US001 and US002/02-Invoice Reports     Mohana Priya K\n3\t\t\tV211020\t\t\t\t\t\t\t\t\t\t\t            Mohanapriya K\n -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\t\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/BLInvoiceReport.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n    \n<script>\n\nasync function callCommonLookupCode(obj,code,sqlSelect){\n\t\tvar locale  \t = document.getElementById(\'locale\').value;\n\t\tvar facilityId   = document.getElementById(\'facility_id\').value;\n\t\tvar episode_type = document.getElementById(\'EpisodeType\').value;\n\t\tvar from_mon\t = document.getElementById(\'from_mon\').value;\n\t\tvar from_yr\t\t = document.getElementById(\'from_yr\').value;\n\t\tvar to_mon\t\t = document.getElementById(\'to_mon\').value;\n\t\tvar to_yr\t\t = document.getElementById(\"to_yr\").value;\n\t\tvar fm_date\t\t = document.getElementById(\'fm_date\').value;\n\t\tvar to_date\t\t = document.getElementById(\'to_date\').value;\n\t\t\n\t\tvar argumentArray  = new Array();\n\t\tvar dataNameArray  = new Array();\n\t\tvar dataValueArray = new Array();\n\t\tvar dataTypeArray  = new Array();\n\t\tvar sql \t= \'\';\n\t\tvar title \t= \'\';\n\t\t\n\t\t\n\t\tswitch(sqlSelect){\n\t\t\tcase 1:\n\t\t\t{    sql=\"SELECT   long_Desc description, cust_group_code code from(( select  long_desc,CUST_GROUP_CODE from ar_cust_group AR where  status is null \"+\n\t\t\t\t\t\t \"and  EXISTS (SELECT  A.CUST_GROUP_CODE FROM  BL_INS_PAYER_APPR_DTL A \"+\n\t\t\t\t\t\t \"WHERE A.OPERATING_FACILITY_ID =\'\"+facilityId+\"\' AND A.CUST_GROUP_CODE = AR.CUST_GROUP_CODE \"+       \n\t\t\t\t\t   \t \"AND TRUNC(DOC_REF_DATE) BETWEEN  to_DATE(\'\"+fm_date+\"\',\'DD/MM/YYYY\')  AND  to_DATE(\'\"+to_date+\"\',\'DD/MM/YYYY\')  \"+\n\t\t\t\t\t\t \"AND ((\'\"+episode_type+\"\'= \'1\' and episode_type in (\'O\',\'E\',\'R\')) or (\'\"+episode_type+\"\' = \'2\' and episode_type in (\'I\',\'D\')) \"+\n\t\t\t\t\t\t \"or (\'\"+episode_type+\"\' = \'A\' and episode_type in (\'I\',\'D\',\'O\',\'E\',\'R\'))) \"+\n\t\t\t\t\t\t \"AND NVL(\'\"+from_yr+\"\',0) =0 AND NVL(\'\"+from_mon+\"\',0) =0 AND NVL(\'\"+to_yr+\"\',0) =0 \"+\n\t\t\t\t\t\t \" AND NVL(\'\"+to_mon+\"\',0) =0 ) )\"+\"  UNION SELECT   long_Desc, cust_group_code from \"+\n\t\t\t\t\t\t \"( select  long_desc,CUST_GROUP_CODE from ar_cust_group AR where  status is null \"+\n\t\t\t\t\t\t \"and  EXISTS(SELECT  \'Y\' FROM bl_bill_hdr b WHERE b.OPERATING_FACILITY_ID =\'\"+facilityId+\"\' \"+\n\t\t\t\t\t\t \"AND b.CUST_GROUP_CODE = AR.CUST_GROUP_CODE  AND LPAD (NVL (TO_CHAR (posted_year), \'0\'), 4, \'0\') \"+\n\t\t\t\t\t\t \" || LPAD (NVL (TO_CHAR (posted_month), \'0\'), 2, \'0\') \"+\n\t\t\t\t\t\t \" BETWEEN LPAD (NVL (TO_CHAR (\'\"+from_yr+\"\'), \'0\'), 4, \'0\') \"+\n\t\t\t\t\t\t \" || LPAD (NVL (TO_CHAR (\'\"+from_mon+\"\'), \'0\'), 2, \'0\') \"+\n\t\t\t\t\t\t \" AND LPAD (NVL (TO_CHAR (\'\"+to_yr+\"\'), \'0\'), 4, \'0\') \"+\n\t\t\t\t\t\t \"|| LPAD (NVL (TO_CHAR (\'\"+to_mon+\"\'), \'0\'), 2, \'0\') \"\n\t\t\t\t\t\t +\"  AND NVL(\'\"+from_yr+\"\',0) !=0 \"+\n\t\t\t\t\t\t \" AND NVL(\'\"+from_mon+\"\',0) !=0 \"+\n\t\t\t\t\t     \"AND NVL(\'\"+to_yr+\"\',0) !=0 \"+\n\t\t\t\t\t     \" AND NVL(\'\"+to_mon+\"\',0) !=0  )) UNION ALL \"+\n\t\t\t\t\t\t \"SELECT \'All Groups\',\'**\' from dual ) where upper(long_Desc) like upper(?) and upper(cust_group_code) like upper(?) order by 1\";    //V201231\n\t\t\t\t\n\t\t\t\ttitle = getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\t\t\t\tbreak;\t\n\t\t\t}\n\t\t\tcase 2:\n\t\t\t{\n\t\t\t\tvar cust_code=document.getElementById(\'custGrpCode\').value;\n\t\t\t\tsql=\"SELECT   CUST_CODE code, long_name description from(\"+\n\t\t\t\t\t\"( select  AR.CUST_CODE CUST_CODE, AR.long_name LONG_NAME from ar_customer AR \"+\n\t\t\t\t\t\"where  status is null \"+\n\t\t\t\t\t\"and  EXISTS (SELECT   DISTINCT A.CUST_CODE \"+\n\t\t\t\t\t\"FROM  BL_INS_PAYER_APPR_DTL A WHERE A.OPERATING_FACILITY_ID =\'\"+facilityId+\"\' AND A.CUST_GROUP_CODE=AR.CUST_GROUP_CODE \"+\n\t\t\t\t\t\"AND A.CUST_GROUP_CODE = \'\"+cust_code+\"\' AND TRUNC(DOC_REF_DATE) BETWEEN to_DATE(\'\"+fm_date+\"\',\'DD/MM/YYYY\')  AND  to_DATE(\'\"+to_date+\"\',\'DD/MM/YYYY\')\"+\n\t\t\t\t\t\"AND ((\'\"+episode_type+\"\'= \'1\' and episode_type in (\'O\',\'E\',\'R\')) or \"+\n\t\t\t\t\t\"(\'\"+episode_type+\"\' = \'2\' and episode_type in (\'I\',\'D\')) or \"+\n\t\t\t\t\t\"(\'\"+episode_type+\"\' = \'A\' and episode_type in (\'I\',\'D\',\'O\',\'E\',\'R\'))) \"+\n\t\t\t\t\t\"AND NVL(\'\"+from_yr+\"\',0) =0 AND NVL(\'\"+from_mon+\"\',0) =0 \"+\n\t\t\t\t\t\"AND NVL(\'\"+to_yr+\"\',0) =0 AND NVL(\'\"+to_mon+\"\',0) =0 ) ) \"+\n\t\t\t\t\t\"UNION SELECT   CUST_CODE, long_name from \"+\n\t\t\t\t\t\"( select  AR.CUST_CODE CUST_CODE, AR.long_name LONG_NAME from ar_customer AR where  status is null \"+\n\t\t\t\t\t\"and  EXISTS (SELECT       DISTINCT A.CUST_CODE FROM  BL_BILL_HDR A \"+\n\t\t\t\t\t\"WHERE A.OPERATING_FACILITY_ID =\'\"+facilityId+\"\' AND A.CUST_GROUP_CODE=AR.CUST_GROUP_CODE \"+\n\t\t\t\t\t\"AND A.CUST_GROUP_CODE = \'\"+cust_code+\"\' AND LPAD (NVL (TO_CHAR (posted_year), \'0\'), 4, \'0\') \"+\n\t\t\t\t\t\" || LPAD (NVL (TO_CHAR (posted_month), \'0\'), 2, \'0\') \"+\n\t\t\t\t\t\" BETWEEN LPAD (NVL (TO_CHAR (\'\"+from_yr+\"\'), \'0\'), 4, \'0\') \"+\n\t\t\t\t\t\" || LPAD (NVL (TO_CHAR (\'\"+from_mon+\"\'), \'0\'), 2, \'0\') \"+\n\t\t\t\t\t\"AND LPAD (NVL (TO_CHAR (\'\"+to_yr+\"\'), \'0\'), 4, \'0\') \"+\n\t\t\t\t\t\" || LPAD (NVL (TO_CHAR (\'\"+to_mon+\"\'), \'0\'), 2, \'0\') \"+\n\t\t\t\t\t\" AND NVL(\'\"+from_yr+\"\',0) !=0 AND NVL(\'\"+from_mon+\"\',0) !=0 \"+\n\t\t\t\t\t\"AND NVL(\'\"+to_yr+\"\',0) !=0  AND NVL(\'\"+to_mon+\"\',0) !=0) ) \"+\n\t\t\t\t\t\")where upper(long_name) like upper(?) and upper(CUST_CODE) like upper(?) order by 1\";  //V201231\n\t\t\t\t\n\t\t\t\ttitle = getLabel(\"eBL.PAYER.label\",\"bl\");\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\t\targumentArray[0] = sql;\n\t\targumentArray[1] = dataNameArray;\n\t\targumentArray[2] = dataValueArray;\n\t\targumentArray[3] = dataTypeArray;\n\t\targumentArray[4] = \"2,1\";\n\t\targumentArray[5] = obj.value;\n\t\targumentArray[6] = DESC_LINK;\n\t\targumentArray[7] = DESC_CODE;\t\t\t\t\n\t\t\t\n\t\treturnedValues = await CommonLookup(title, argumentArray );\n\t\tvar ret1=unescape(returnedValues);\n\t\t\t \tvar arr=ret1.split(\",\");\n\t\t\t \tif(arr[1]==undefined) \n\t\t \t\t{\n\t\t\t \t\tarr[0]=\"\";\t\n\t\t\t \t\tarr[1]=\"\";\t\n\t\t \t\t}\n\t\tif((returnedValues != null) && (returnedValues != \"\") )  {\n\t\t\n\t\t\tobj.value = arr[1];\n\t\t\tcode.value = arr[0];\n\t\t}\n\t\telse\n\t\t{\n\t\t\n\t\tobj.value = \'\';\n\t\tcode.value = \'\';\t\t\n\t\t}\n}\n\nfunction valid_Range(callfrom){\n\tvar from_mon=document.getElementById(\'from_mon\').value;\n\tvar from_yr=document.getElementById(\'from_yr\').value;\n\tvar to_mon=document.getElementById(\'to_mon\').value;\n\tvar to_yr=document.getElementById(\"to_yr\").value;\n\t//V210106 Starts\n\tvar date = new Date();\n\tvar year=date.getFullYear()\n\tvar mon=date.getMonth()+1;\n\t//V210106 ends\n\tif(callfrom==2){ \n\t\t//V210106 starts\n\t\tif(from_mon>mon && from_yr==year){\n\t\t\talert(getMessage(\'BL0733\', \'BLEXT\'));\n\t\t\tdocument.getElementById(\'from_mon\').value=\'0\';\n\t\t\tdocument.getElementById(\'from_yr\').value=\'0\';\n\t\t\tdocument.getElementById(\'fm_date\').disabled=false;\n\t\t\tdocument.getElementById(\'fmdate\').disabled=false;\n\t\t\tdocument.getElementById(\'to_date\').disabled=false;\n\t\t\tdocument.getElementById(\'todate\').disabled=false;\n\t\t\treturn false;\n\t\t}else if(to_yr==year && to_mon>mon){\n\t\t\t alert(getMessage(\'BL0733\', \'BLEXT\'));\n\t\t\t document.getElementById(\'to_mon\').value=\'0\';\n\t\t\t document.getElementById(\"to_yr\").value=\'0\';\n\t\t\t document.getElementById(\'fm_date\').disabled=false;\n\t\t\t document.getElementById(\'fmdate\').disabled=false;\n\t\t\t document.getElementById(\'to_date\').disabled=false;\n\t   \t\t document.getElementById(\'todate\').disabled=false;\n\t   \t\t return false;\n\t\t}\n\t\t//V210106 ends\n\t\t\n\t\tif(from_mon==\'0\' || from_yr==\'0\'){\n\t\t\t alert(getMessage(\'BL0734\', \'BLEXT\')); //V201214\n\t\t\t document.getElementById(\'to_mon\').value=\'0\';\n\t\t\t document.getElementById(\"to_yr\").value=\'0\';\n             return false;\n\t\t}else if(from_yr!=\'0\' && from_mon!=\'0\'){\n\t\t\tif(to_yr!=\'0\' && to_mon!=\'0\'){\n\t\t\t  if(from_yr==to_yr){\n\t\t\t\tif(from_mon>to_mon){\n\t\t\t\t\talert(getMessage(\'BL0735\', \'BLEXT\')); //V201214\n\t\t\t\t\t document.getElementById(\'to_mon\').value=\'0\';\n\t\t\t\t\t document.getElementById(\"to_yr\").value=\'0\';\n\t    \t         return false;\n\t\t\t\t}else{\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t}else if(from_yr>to_yr){\n\t\t\t\talert(getMessage(\'BL0735\', \'BLEXT\')); //V201214\n\t\t\t \tdocument.getElementById(\'to_mon\').value=\'0\';\n\t\t\t\t document.getElementById(\"to_yr\").value=\'0\';\n            \treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tif(callfrom==1){ //V210106 starts\n\t\tif(from_mon>mon && from_yr==year){\n\t\t\talert(getMessage(\'BL0733\', \'BLEXT\'));\n\t\t\tdocument.getElementById(\'from_mon\').value=\'0\';\n\t\t\tdocument.getElementById(\'from_yr\').value=\'0\';\n\t\t\tdocument.getElementById(\'fm_date\').disabled=false;\n\t\t\tdocument.getElementById(\'fmdate\').disabled=false;\n\t\t\tdocument.getElementById(\'to_date\').disabled=false;\n\t\t\tdocument.getElementById(\'todate\').disabled=false;\n\t\t\treturn false;\n\t\t}else if(to_yr==year && to_mon>mon){\n\t\t\talert(getMessage(\'BL0733\', \'BLEXT\'));\n\t\t\tdocument.getElementById(\'to_mon\').value=\'0\';\n\t\t\tdocument.getElementById(\"to_yr\").value=\'0\';\n\t\t\tdocument.getElementById(\'fm_date\').disabled=false;\n\t\t\tdocument.getElementById(\'fmdate\').disabled=false;\n\t\t\tdocument.getElementById(\'to_date\').disabled=false;\n\t\t\tdocument.getElementById(\'todate\').disabled=false;\t\n\t\t\treturn false;\n\t\t}//V210106 ends\n\t\t\n\t\tif(from_yr!=\'0\' || from_mon!=\'0\'){\n\t\t\tdocument.getElementById(\'fm_date\').value=\'\';\n\t\t\tdocument.getElementById(\'fm_date\').disabled=true;\n\t\t\tdocument.getElementById(\'fmdate\').disabled=true;\n\t\t\tdocument.getElementById(\'to_date\').value=\'\';\n\t\t\tdocument.getElementById(\'to_date\').disabled=true;\n\t\t\tdocument.getElementById(\'todate\').disabled=true;\n\t\t}\n\telse{\n\t\tdocument.getElementById(\'fm_date\').disabled=false;\n\t\tdocument.getElementById(\'fmdate\').disabled=false;\n\t\tdocument.getElementById(\'to_date\').disabled=false;\n\t\tdocument.getElementById(\'todate\').disabled=false;\n\t}\n\t}\n}\n\nfunction checkVal(obj){ \n\tif(obj==1){\n\t\tif(document.getElementById(\'unposted\').checked==true){\n\t\t\tdocument.getElementById(\'unposted\').checked=false;\t\n\t\t}\n\t\tdocument.getElementById(\'from_mon\').value=\"0\";\t\n\t\tdocument.getElementById(\'from_mon\').disabled=false;\t\n\t\tdocument.getElementById(\'from_yr\').value=\"0\";\t\n\t\tdocument.getElementById(\'from_yr\').disabled=false;\n\t\tdocument.getElementById(\'to_mon\').value=\"0\";\t\n\t\tdocument.getElementById(\'to_mon\').disabled=false;\n\t\tdocument.getElementById(\"to_yr\").value=\"0\";\t\n\t\tdocument.getElementById(\"to_yr\").disabled=false;\n\t}\n\tif(obj==2){ \n\t\tif(document.getElementById(\'posted\').checked==true){\n\t\t\tdocument.getElementById(\'posted\').checked=false;\t\n\t\t}\n\t\tdocument.getElementById(\'from_mon\').value=\"0\";\t\n\t\tdocument.getElementById(\'from_mon\').disabled=true;\t\n\t\tdocument.getElementById(\'from_yr\').value=\"0\";\t\n\t\tdocument.getElementById(\'from_yr\').disabled=true;\n\t\tdocument.getElementById(\'to_mon\').value=\"0\";\t\n\t\tdocument.getElementById(\'to_mon\').disabled=true;\n\t\tdocument.getElementById(\"to_yr\").value=\"0\";\t\n\t\tdocument.getElementById(\"to_yr\").disabled=true;\n\t\tdocument.getEl";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="ementById(\'fm_date\').disabled=false; //V201209\n\t\tdocument.getElementById(\'fmdate\').disabled=false; //V201209\n\t\tdocument.getElementById(\'To_date\').disabled=false; //V201209\n\t\tdocument.getElementById(\'todate\').disabled=false; //V201209\n\t}\n} \n\n</script>\n</head>\n<style>\n\t\tthead td, thead td.locked\t{ \n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative; \n\t\tz-index: 10;}\n\t\t</style>\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\n<BODY onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onload=\"ReportListchange(document.forms[0].Report_list)\" style=\"padding-left:10px;padding-right:10px;padding-top:5px;\">\n <form name=\"BLUnbilledForm\" id=\"BLUnbilledForm\" id=\"BLUnbilledForm\"  action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\" > \n\n<TABLE width=\"100%\" CELLSPACING=\'0\' cellpadding=\'3\' align=\'center\'>\n<tr>\n\t<th  class=\"columnheader\" style=\"text-align:left;\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </th>\n</tr>\t\n</TABLE> \n<br>\n<table cellpadding=\'10\' cellspacing=\'0\' width=\"100%\" align=\"center\" border=\'0\'>\t\n\t<tr>\n\t\t<td  class=\"label\">\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</td>\n\t\t<td colspan=\'2\'>\n\t\t\t<select name=\"Report_list\" id=\"Report_list\" id=\"Report_list\" onchange=\"ReportListchange(this)\" style=\"width: 230px;\">       \n\t\t\t\t<option value=\"INRSUMINV\" >Summary Of Invoice</option>\n\t\t\t\t<option value=\"INRSTDFT\" >Consolidated Summary of Invoice</option>\n\t\t\t</select>\t\t\n\t\t</td>\n\t</tr>\n\t<tr>\n\t    <td  class=\"label\" width=\"10%\">\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t\t<td>\n\t\t\t<select name=\"EpisodeType\" id=\"EpisodeType\" id=\"EpisodeType\" style=\"width: 210px;\">       \n\t\t\t\t<option value=\"A\" selected>All</option>\n\t\t\t\t<option value=\"1\" >Outpatient/Emergency/Referral</option>\n\t\t\t\t<option value=\"2\" >Inpatient/Daycare</option>\n\t\t\t</select>\t\t\n\t\t</td><td></td>\n\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t<input type=\"radio\" name=\"posted\" id=\"posted\" id=\"posted\" onclick=\"checkVal(1);ReportListchange(document.getElementById(\'Report_list\'));\" checked>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<input type=\"radio\" name=\"unposted\" id=\"unposted\" id=\"unposted\" onclick=\"checkVal(2);ReportListchange(document.getElementById(\'Report_list\'));\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="   \t\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t <td  class=\"label\" width=\"15%\">\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</td>\n\t\t<td width=\"10%\" class=\'fields\' colspan=\'1\'>\n\t\t\t<select name=\"from_mon\" id=\"from_mon\" id=\"from_mon\" onchange=\"valid_Range(1);\" style=\"width: 80px;\">       \n\t\t\t\t<option value=\"0\" selected>sel</option>\n\t\t\t\t<option value=\"1\" >JAN</option>\n\t\t\t\t<option value=\"2\" >FEB</option>\n\t\t\t\t<option value=\"3\" >MAR</option>\n\t\t\t\t<option value=\"4\" >APR</option>\n\t\t\t\t<option value=\"5\" >MAY</option>\n\t\t\t\t<option value=\"6\" >JUN</option>\n\t\t\t\t<option value=\"7\" >JUL</option>\n\t\t\t\t<option value=\"8\" >AUG</option>\n\t\t\t\t<option value=\"9\" >SEP</option>\n\t\t\t\t<option value=\"10\">OCT</option>\n\t\t\t\t<option value=\"11\">NOV</option>\n\t\t\t\t<option value=\"12\">DEC</option>\n\t\t\t\t\n\t\t    </select>\t\n\t\t\t<select name=\"from_yr\" id=\"from_yr\" id=\"from_yr\" onchange=\"valid_Range(1);\" style=\"width: 80px;\">   \n\t\t\t\t<option value=\"0\" selected>sel</option>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="    \n\t\t    </select>\t\n\t\t</td>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t<td></td>\n\t    <td  class=\"label\" width=\'15%\' colspan=\'1\' align=\'left\'>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\n\t\t<td colspan=\'2\'>\n\t\t\t<select name=\"to_mon\" id=\"to_mon\" id=\"to_mon\" onchange=\"valid_Range(2);\" style=\"width: 80px;\">       \n\t\t\t\t<option value=\"0\" selected>sel</option>\n\t\t\t\t<option value=\"1\" >JAN</option>\n\t\t\t\t<option value=\"2\" >FEB</option>\n\t\t\t\t<option value=\"3\" >MAR</option>\n\t\t\t\t<option value=\"4\" >APR</option>\n\t\t\t\t<option value=\"5\" >MAY</option>\n\t\t\t\t<option value=\"6\" >JUN</option>\n\t\t\t\t<option value=\"7\" >JUL</option>\n\t\t\t\t<option value=\"8\" >AUG</option>\n\t\t\t\t<option value=\"9\" >SEP</option>\n\t\t\t\t<option value=\"10\">OCT</option>\n\t\t\t\t<option value=\"11\">NOV</option>\n\t\t\t\t<option value=\"12\">DEC</option>\n\t\t    </select>\t\n\t\t\t<select name=\"to_yr\" id=\"to_yr\" id=\"to_yr\" onchange=\"valid_Range(2);\" style=\"width: 80px;\">       \n\t\t\t\t<option value=\"0\" selected>sel</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="    \n\t\t    \n\t\t    </select>\t\n\t\t</td><td></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"label\" width=\"10%\">\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</td>\n\t\t<td width=\"10%\" class=\'fields\' colspan=\'2\'>\n\t\t\t<input type=\"text\" name=\"fm_date\" id=\"fm_date\" id=\"fm_date\" size=\"10\" maxlength=\'10\' value=\'\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" onBlur=\'return checkDateBL(document.forms[0].fm_date,fm_date,to_date);return dateRegEx(this)\' >\n\t\t\t\t&nbsp; <input type=\"image\" max-width=\'5%\' max-height=\'5%\' src=\"../../eCommon/images/CommonCalendar.gif\" id=fmdate onClick=\"return showCalendar(\'fm_date\');\"><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t</td>\n        <td  class=\"label\" width=\"15%\">\n\t\t \t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</td>\n\t\t<td>\n\t\t\t<input type=\"text\"  name=\"to_date\" id=\"to_date\"  id=\"to_date\"   size=\"10\" maxlength=\'10\' value=\'\' onBlur=\'return toFromDateChk(document.forms[0].to_date,fm_date,to_date);return dateRegEx(this)\' >\n\t\t\t\t&nbsp; <input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" id=todate onClick=\"return showCalendar(\'to_date\');\" border=\"0\"><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"label\" width=\"10%\">\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</td>\n\t\t<td width=\"10%\" class=\'fields\' colspan=\'2\'>\n\t\t\t<input type=\"text\" name=\"vst_fm_date\" id=\"vst_fm_date\" id=\"vst_fm_date\" size=\"10\" maxlength=\'10\' value=\'\' onBlur=\'return checkDateBL(document.forms[0].vst_fm_date,vst_fm_date,vst_to_date);return dateRegEx(this)\' >\n\t\t\t\t&nbsp; <input type=\"image\"  src=\"../../eCommon/images/CommonCalendar.gif\" id=\"vstfm\" onClick=\"return showCalendar(\'vst_fm_date\');\">\n\t\t</td>\n        <td  class=\"label\" width=\"10%\">\n\t\t \t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</td>\n\t\t<td>\n\t\t\t<input type=\"text\"  name=\"vst_to_date\" id=\"vst_to_date\"  id=\"vst_to_date\"   size=\"10\" maxlength=\'10\' value=\'\' onBlur=\'return toFromDateChk(document.forms[0].vst_to_date,vst_fm_date,vst_to_date);return dateRegEx(this)\' >\n\t\t\t\t&nbsp; <input type=\"image\"  src=\"../../eCommon/images/CommonCalendar.gif\" id=\"vstto\" onClick=\"return showCalendar(\'vst_to_date\');\">\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"label\" width=\"15%\">\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n\t\t<td width=\"10%\" class=\'fields\' colspan=\'2\'>\n\t\t\t<input type=\"text\" name=\"disc_fm_date\" id=\"disc_fm_date\" id=\"disc_fm_date\" size=\"10\" maxlength=\'10\' value=\'\' onBlur=\'return checkDateBL(document.forms[0].disc_fm_date,disc_fm_date,disc_to_date);return dateRegEx(this)\' >\n\t\t\t\t&nbsp; <input type=\"image\"  src=\"../../eCommon/images/CommonCalendar.gif\" id=\"disfm\" onClick=\"return showCalendar(\'disc_fm_date\');\">\n\t\t</td>\n        <td  class=\"label\" width=\"10%\">\n\t\t \t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</td>\n\t\t<td>\n\t\t\t<input type=\"text\"  name=\"disc_to_date\" id=\"disc_to_date\"  id=\"disc_to_date\"   size=\"10\" maxlength=\'10\' value=\'\' onBlur=\'return toFromDateChk(document.forms[0].disc_to_date,disc_fm_date,disc_to_date);return dateRegEx(this)\' >\n\t\t\t\t&nbsp; <input type=\"image\"  src=\"../../eCommon/images/CommonCalendar.gif\" id=\"disto\" onClick=\"return showCalendar(\'disc_to_date\');\">\n\t\t</td>\n\t</tr>\n\t<tr>\n\t   <td width=\"10%\" nowrap class=\'label\'  style=\"text-align: left;\" > \n\t\t   ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</td>\n\t\t<td width=\"20%\" nowrap class=\'fields\' style=\"text-align: left;\">\n\t\t\t<input type=\"text\" name=\'custGrpCode\' id=\'custGrpCode\' id=\'custGrpCode\' size=\"10\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(custGrpDesc,custGrpCode,1); } else{ fnClearCode(custGrpDesc);  }\">&nbsp;\n\t\t\t<input type=\"text\" name=\'custGrpDesc\' id=\'custGrpDesc\' id=\'custGrpDesc\' size=\"30\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(custGrpDesc,custGrpCode,1); } else{ fnClearCode(custGrpCode);  }\">&nbsp;\n\t\t\t<input type=\"button\" class=\"button\" value=\'?\' name=\"custGrpBtn\" id=\"custGrpBtn\" id=\"custGrpBtn\" onClick=\"callCommonLookupCode(custGrpDesc,custGrpCode,1);\" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t   <td width=\"10%\" nowrap class=\'label\'  style=\"text-align: left;\" > \n\t\t   ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</td>\n\t\t<td width=\"20%\" nowrap class=\'fields\' style=\"text-align: left;\">\n\t\t\t<input type=\"text\" name=\'payercode\' id=\'payercode\' id=\'payerCode\' size=\"10\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(payerDesc,payercode,2); } else{ fnClearCode(payerDesc);  }\">&nbsp;\n\t\t\t<input type=\"text\" name=\'payerDesc\' id=\'payerDesc\' id=\'payerDesc\' size=\"30\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(payerDesc,payercode,2); } else{ fnClearCode(payercode);  }\">&nbsp;\n\t\t\t<input type=\"button\" class=\"button\" value=\'?\' name=\"payerBtn\" id=\"payerBtn\" id=\"payerBtn\" onClick=\"callCommonLookupCode(payerDesc,payercode,2);\" >\n\t\t</td>\n\t</tr>\n</table>\t\t\n\t\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' \t\tid=\'locale\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" \t>\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'\tid=\'facilityId\' \tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" id=\"p_module_id\" \tvalue=\"IN\"\t>\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" id=\"p_report_id\"\tvalue=\"\" >\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" \t\tid=\"pgm_id\"\t\t\tvalue=\"\"\t> \t\t\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" \tid=\"facility_id\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\t>\n\t<input type=\"hidden\" name=\"p_session_id\" id=\"p_session_id\" \tvalue=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\t\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\" \tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"p_pgm_date\" id=\"p_pgm_date\"\t   value=\"\">\n</form>\n</BODY>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
	
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

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String locale			=	"";
	String from_yr			=	"";
	String isUserCanAcess	=	"";
	String disabled="";
	String p_user_name		= (String) session.getValue( "login_user" );
	Connection con	= null;
	PreparedStatement pstmt = null;
	ResultSet rs		= null;
	String session_id="";
	String p_pgm_date="";
	String value1="N";
	String value2="N";
	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		String facilityId =   (String) session.getValue( "facility_id" ) ;
		con=ConnectionManager.getConnection(request);
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

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
try{
					// con=ConnectionManager.getConnection(request); //V211020
					from_yr = "select extract (year from sysdate) -2012 ,extract (year from sysdate) from dual";
					pstmt = con.prepareStatement(from_yr);
					rs = pstmt.executeQuery();	
					if(rs != null){
						while(rs.next()){
						String tot = rs.getString(1);
						String strYr = rs.getString(2);
						if(strYr!=null){
							int year=Integer.parseInt(strYr);
							int total=Integer.parseInt(tot);
							int[] yr=new int[total+1];
							for(int t=0;t<=total;t++){
								yr[t]=year--;
								String yrv=Integer.toString(yr[t]);
								
							
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(yrv));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(yr[t] ));
            _bw.write(_wl_block17Bytes, _wl_block17);

							}
					}                  	
				}//while 
			}//Result Set IF Condition 
			}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception is "+e);
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rs!=null)rs.close();
					// ConnectionManager.returnConnection(con); //V211020
				}catch(Exception e)
				{
					e.printStackTrace();
					out.println("Exception is "+e);
				}				
			}	 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
try{
					//con=ConnectionManager.getConnection(request); //V211020
					from_yr = "select extract (year from sysdate) -2012 ,extract (year from sysdate) from dual";
					pstmt = con.prepareStatement(from_yr);
					rs = pstmt.executeQuery();	
					if(rs != null){
						while(rs.next()){
						String tot = rs.getString(1);
						String strYr = rs.getString(2);
						if(strYr!=null){
							int year=Integer.parseInt(strYr);
							int total=Integer.parseInt(tot);
							int[] yr=new int[total+1];
							for(int t=0;t<total+1;t++){
								yr[t]=year--;
								String yrv=Integer.toString(yr[t]);
								
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(yrv));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(yr[t] ));
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
					}                  	
				}//while 
			}//Result Set IF Condition 
			}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception is "+e);
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rs!=null)rs.close();
					//ConnectionManager.returnConnection(con); //V211020
				}catch(Exception e)
				{
					e.printStackTrace();
					out.println("Exception is "+e);
				}				
			}	 
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block34Bytes, _wl_block34);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BLUnbilledReport.jsp::"+e);
	}finally{
		try{
			ConnectionManager.returnConnection(con); //V211020
		}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception is "+e);
			}				
		}	

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ReportCriteria.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.report_list.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EpisodeType.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.posted.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.unposted.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.posted_mth/Yr_frm.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.posted_mth/Yr_To.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.stat_date_frm.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.stat_date_To.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Visit_period_frm.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Visit_period_To.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.disc_period_frm.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.disc_period_To.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
