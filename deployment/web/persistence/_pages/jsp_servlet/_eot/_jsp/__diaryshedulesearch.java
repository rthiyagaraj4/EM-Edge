package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.Properties;
import eCommon.Common.CommonBean;
import eOT.Common.OTRepository;
import eOT.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __diaryshedulesearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/DiarySheduleSearch.jsp", 1743149102764L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script  language=\"javascript\" src=\"../../eOT/js/Booking.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\n<script language=\"JavaScript\" >\t\n\nfunction setAssignValue(dat){\n\treturn dat;\n}\nfunction clearSurgeon(){\n\tvar obj=document.forms[0];\n\tobj.SURGEON_CODE.value=\'\';\n\tobj.SURGEON.value=\'\';\n\tif(obj.SPECIALITY_DESC.value!=\'\'){\n\t\tobj.PROCEDURE.value=\'\';\n\t\tobj.probutton.disabled=true;\n\t} \n}\n\nasync function bookExternalFacility()\n{\n\tvar bookingURL = \"../../eOT/jsp/ExternalFacilityLinker.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tvar dialogHeight\t= \"10\" ;\n\tvar dialogWidth\t= \"25\" ;\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:no\" ;\n\tvar reportURL \t= await window.showModalDialog( bookingURL, arguments, features ) ;\n}\nfunction funResetAll(){\n\tvar obj=document.forms[0];\n\tobj.SURGEON.value=\'\';\n\tobj.SPECIALITY_DESC.value=\'\';\n\tobj.PREFERRED_MONTH.value=\'\';\n\tobj.PREFERRED_DATE.value=\'\';    \n\tobj.SURGEON_CODE.value=\'\';\n\tobj.PROCEDURE.value=\'\';\n\tobj.SPECIALITY_CODE.value=\'\';\n\tobj.SPECIALITY_CODE.value=\'\';\n\tobj.theatre.value=\'\';\n\tobj.room_code.value=\'\';\n\tobj.chkavilable.checked=false;\n    obj.chkavilable.value=\'N\'\n\tobj.surButton.disabled=false;\n\tobj.spcButton.disabled=false;\n\tobj.probutton.disabled=false;\n\tparent.parent.frames[1].frames[2].location.href = \"../../eCommon/html/blank.html?\";\n}\n\n  function disableAll(){\n\tvar obj=document.forms[0];\n\tobj.surButton.disabled=true;\n\tobj.spcButton.disabled=true;\n\tobj.probutton.disabled=true;\n\tobj.PREFERRED_MONTH.disabled=true;\n\tobj.PREFERRED_DATE.disabled=true;\n\tobj.imagedate.disabled=true;\n\tobj.imagemonth.disabled=true;\n\n\tobj.search.disabled=true;\n  } \n\n\nfunction checkForSpecCharsforID(event)\n{\n    var strCheck = \'0123456789/\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"addlSearchCriteriaForm\" id=\"addlSearchCriteriaForm\" >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n<table cellpadding=0 cellspacing=\"0\" border=\"0\" width=\"100%\" align=\"center\">\n   <tr>\n\t\t<td class=\"label\" width=\'25%\' nowrap >\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input name=\'SPECIALITY_DESC\' id=\'SPECIALITY_DESC\' maxlength=\'30\' size=\'15\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  onBlur=\"if(this.value!=\'\')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value=\'\' \"> \n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' \n\t\t\tname=\'spcButton\' id=\'spcButton\'  onClick=\"return searchSpeciality(SPECIALITY_DESC);clearSurgeon();\"  >\n\t\t</td>\n\t\t<td class=\"label\" align=\"left\" width=\'25%\' nowrap >\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input name=\'SURGEON\' id=\'SURGEON\' maxlength=\'30\' size=\'15\' value= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  onBlur=\"if(this.value!=\'\')return searchSurgeon(SURGEON); else SURGEON_CODE.value=\'\' \" >\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' \n\t\t\tname=\'surButton\' id=\'surButton\' onClick=\"return searchSurgeon(SURGEON);\" >\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'PROCEDURE\' id=\'PROCEDURE\' maxlength=\'30\' size=\'15\' value= \"\" onBlur=\"if(this.value!=\'\')return funOTCheckDetail1(\'Procedure\',\'\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'); else oper_code.value=\'\' \" >\n\t\t\t<input type=\'button\' name=\'probutton\' id=\'probutton\' class=\'button\' value=\'?\' onClick=\"return funOTCheckDetail1(\'Procedure\',\'\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\" >\n\t\t</td>\n\t\t<td   class=\'label\' width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'checkbox\' name=\'chkavilable\' id=\'chkavilable\' onClick=\"setFirstDate(this)\">\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td  class=\'label\' width=\'25%\' > \n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'PREFERRED_DATE\' id=\'PREFERRED_DATE\' size=\'11\'   value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'  maxlength=\'10\'  Onblur=\"javascript:isValidDate(this);\" onkeypress=\"return checkForSpecCharsforID(event);\">\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"\n\t\t\tname=\'imagemonth\' onClick=\"return showCalendar(\'PREFERRED_DATE\',\'dd/mm/y\');\">\n\t\t</td>\n\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'PREFERRED_MONTH\' id=\'PREFERRED_MONTH\' size=\'11\'   value=\'\'  maxlength=\'7\' Onblur=\"javascript:isValidMonth(this);\" onkeypress=\"return checkForSpecCharsforID(event);\">\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" \n\t\t\tonClick=\"return showCalendar(\'PREFERRED_MONTH\',\'mm/y\');\">\n\t\t</td>\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input name=\'theatre\' id=\'theatre\' maxlength=\'30\' size=\'15\' value= \'\' onBlur=\"if(this.value!=\'\')return searchOTTheatre(theatre); else clearValues1(); \">\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' \n\t\t\tname=\'btn_theatre\' id=\'btn_theatre\' onClick=\"return searchOTTheatre(theatre);\" >\n\t\t</td>\t\t\n\t\t<td colspan=\'2\' align=\'right\' width=\'25%\' >\n\t\t\t<input type=\"button\" class=\"button\" name=\"search\" id=\"search\" value=\"Search\" onClick=\"validateAll();\">\n\t\t\t<input type=\"button\" class=\"button\" name=\"clear\" id=\"clear\" value=\"Clear\" \tonClick=\"funResetAll()\">\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t\t\t<input type=\"button\" class=\"button\" name=\"External Facility\" id=\"External Facility\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' \n\t\t\t\tonClick=\"javascript:bookExternalFacility()\">\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\n\t\t</td>\n\t</tr>\n</table>\n\n   <!-- added by Rajesh for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<!-- end -->\n\n<input type=\'hidden\' name=\'SURGEON_CODE\' id=\'SURGEON_CODE\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'SPECIALITY_CODE\' id=\'SPECIALITY_CODE\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'room_code\' id=\'room_code\' value=\"\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'%>\n<input type=\'hidden\' name=\'date_compare\' id=\'date_compare\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'month_compare\' id=\'month_compare\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'orderid\' id=\'orderid\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'selOrderIds\' id=\'selOrderIds\' id=\'selOrderIds\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n<input type=\'hidden\' name=\'ammendFlag\' id=\'ammendFlag\' id=\'ammendFlag\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n<input type=\'hidden\' name=\'booking_no\' id=\'booking_no\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'startTime\' id=\'startTime\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'> <!-- 44528 - Chaitanya -->\n<input type=\'hidden\' name=\'endTime\' id=\'endTime\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\'patientId\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"> ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<!-- Added by Suma for incident 19261 to sort order by surgeon or theatre in booking function \n -->\n<input type=\'hidden\' name=\'diary_sched_for_surg_reqd_yn\' id=\'diary_sched_for_surg_reqd_yn\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\'hidden\' name=\'fpp_category\' id=\'fpp_category\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> <!--ML-MMOH-CRF-1939-US005-->\n\n<!-- ends here\n -->\n<script> funAutoSearch();</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Newly Included by Rajesh foe Amazon Changes

Properties p=(Properties)session.getValue("jdbc");
String locale = (String)session.getAttribute("LOCALE");
String client_ip_address = p.getProperty("client_ip_address");
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
String param = request.getQueryString();	
System.out.println("Params in DiaryScheduleSearch.jsp :"+param);
String fpp_category = request.getParameter("fpp_category");	//ML-MMOH-CRF-1939-US005

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(param));
            _bw.write(_wl_block10Bytes, _wl_block10);
	
	//setting character encoding b4 retrieving any request paramter
	request.setCharacterEncoding("UTF-8");
	
	//retrieving Session Attributes
	String facilityid=(String)session.getValue("facility_id");
    String login_user= p.getProperty("login_user");

	//Retrieving Request parameter
	String called_from = checkForNull(request.getParameter("booking_called_from"));
	String strPrefDate=checkForNull(request.getParameter("prefDate"));
	if("OR".equals(called_from)){
		strPrefDate=com.ehis.util.DateUtils.convertDate(strPrefDate,"DMY",locale,"en");
	}
	String strOrderId=checkForNull(request.getParameter("orderid")).trim();
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")).trim(); // ChAiTu - 186
	String ammendFlag = checkForNull(request.getParameter("ammendFlag")).trim(); //MMS-QH-CRF-186
	String strSurgeonCode=checkForNull(request.getParameter("surgeonCode")).trim();
	String strSpecialityCode=checkForNull(request.getParameter("speciality_code")).trim();
	String strBookingNo=checkForNull(request.getParameter("booking_no"));
	String startTime = checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	String endTime = checkForNull(request.getParameter("endTime"));
	String patientId = checkForNull(request.getParameter("patientId")); //PMG2014-CRF-0024
	System.out.println("=========strBookingNo===DiarySheduleSearch======"+strBookingNo);
	System.out.println("=========startTime===DiarySheduleSearch======"+startTime);
	System.out.println("=========endTime===DiarySheduleSearch======"+endTime);
	System.out.println("=========patientId===DiarySheduleSearch======"+patientId);
	System.out.println("=========selOrderIds===DiarySheduleSearch======"+selOrderIds);
	String function_id=checkForNull(request.getParameter("function_id"));
	String alternateBooking=checkForNull(request.getParameter("alternateBooking"));
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;


	//cannonical Representation of Empty String
	String empty = "".intern();
	//Variables Declarations & Initialization.......
	String preferedDate=empty;
	String preferedMonth=empty;
	String prefDate=empty;
	String diary_sched_for_surg_reqd_yn=empty;
	String strSurgeonName=empty;
	String strSpecialityDesc=empty;
	String strBookingYN=empty;
	String restrictTheatreBookingYN=empty;
	String transfer_schedule_yn="";
	StringBuilder sbr = new StringBuilder(300);
	String multiFacility = "";
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	
	
	//SQL QRY Strings used.....
	String speciality_sql="SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW WHERE   SPECIALITY_CODE=? AND LANGUAGE_ID=?";
	String surgeon_sql="SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=? AND LANGUAGE_ID=?";
	String sql_access_rights="SELECT BOOK_SCHEDULE_YN BOOK_SCHEDULE_YN1, (SELECT NVL(RESTRICT_THEATRE_BOOKING_YN,'N') FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=A.OPERATING_FACILITY_ID) RESTRICT_THEATRE_BOOKING_YN,NVL(TRANSFER_SCHEDULE_YN,'N') TRANSFER_SCHEDULE_YN  FROM OT_BOOKING_ACCESS_RIGHTS A WHERE A.OPERATING_FACILITY_ID =?  AND APPL_USER_ID=?";
		/*Commented by Suma as part of query tuning on April 21 2010  the same is added in below query sql_param_chk*/
	//String sql_pref_date="SELECT TO_CHAR(SYSDATE,'mm/dd/yyyy') dat1,TO_CHAR(SYSDATE,'mm/yyyy') month1,TO_CHAR(SYSDATE,'dd/mm/yyyy') dat2  FROM dual";

/*Added by Suma for incident 19261 to sort order by surgeon or theatre in booking function */
	String sql_param_chk="Select DIARY_SCHED_FOR_SURG_REQD_YN,TO_CHAR(SYSDATE,'mm/dd/yyyy') dat1,TO_CHAR(SYSDATE,'mm/yyyy') month1,TO_CHAR(SYSDATE,'dd/mm/yyyy') dat2 from ot_param_for_facility where OPERATING_FACILITY_ID= ?";
	/*ends here*/
	
	//if it is  From OR don't decode otherwise decode surgeon_desc and speciality_desc
	if("OR".equals(called_from)){
		//need to convert english to thai date(since comming from OR comming as English Date)
		strPrefDate=com.ehis.util.DateUtils.convertDate(strPrefDate,"DMY","en",locale);
	}
		try{
			//retreiving surgeonDesc if it is called from OR
			conn = ConnectionManager.getConnection(request);			
			
/*Added by Suma for incident 19261 to sort order by surgeon or theatre in booking function */
				pstmt1 = conn.prepareStatement(sql_param_chk);
				pstmt1.setString(1,facilityid);
				rs1=pstmt1.executeQuery();
				if(rs1!=null && rs1.next()){
					diary_sched_for_surg_reqd_yn=checkForNull(rs1.getString(1));
					preferedDate=rs1.getString("dat1");
				prefDate=com.ehis.util.DateUtils.convertDate(rs1.getString("dat2"),"DMY","en",locale);
				preferedMonth=rs1.getString("month1");

			}
			
	/*ends here*/


			pstmt = conn.prepareStatement(surgeon_sql);
			pstmt.setString(1,strSurgeonCode);
			pstmt.setString(2,locale);
		    rs=pstmt.executeQuery();
			if(rs.next()){
				strSurgeonName=checkForNull(rs.getString(1));
			}
			if(rs!=null)		rs.close();
			if(pstmt !=null)  pstmt.close();

				if(strSurgeonName.equals("") && !function_id.equals("OT_BOOKING")){
				strSurgeonName=all_surgeons;
			}
			//retreiving speciality desc if it is called from OR
			pstmt = conn.prepareStatement(speciality_sql);
			pstmt.setString(1,strSpecialityCode);
			pstmt.setString(2,locale);
			rs=pstmt.executeQuery();
			if(rs.next()){
				strSpecialityDesc=checkForNull(rs.getString(1));
			}
			if(rs!=null)		rs.close();
			if(pstmt !=null)  pstmt.close();
		}catch(Exception ee){
			ee.printStackTrace();
			//System.err.println("Error in DiaryScheduleSearch.jsp surgeon_sql: "+ee);
		
	}

	
	try{
		if(conn==null) conn = ConnectionManager.getConnection(request);
		
		//Added for MO-CRF-20106
		String customer_id="";
		String sql_cust="Select customer_id from SM_SITE_PARAM where rownum = 1";
		pstmt1=conn.prepareStatement(sql_cust);
		rs1=pstmt1.executeQuery();
		
		if(rs1 !=null && rs1.next())
			customer_id=checkForNull(rs1.getString("customer_id"));		
		if(rs1!=null)
			rs1.close();
		if(pstmt1!=null)
			pstmt1.close();
		//Added for MO-CRF-20106

		pstmt = conn.prepareStatement(sql_access_rights);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,login_user);
		rs=pstmt.executeQuery();
		if(rs.next()){
			strBookingYN=checkForNull(rs.getString("BOOK_SCHEDULE_YN1"));
			restrictTheatreBookingYN=checkForNull(rs.getString("RESTRICT_THEATRE_BOOKING_YN"));
			transfer_schedule_yn=checkForNull(rs.getString("TRANSFER_SCHEDULE_YN"));
		}
		if(rs!=null)	 rs.close();
		if(pstmt!=null)  pstmt.close();
         
		 if(("").equals(strBookingYN))
		{
		strBookingYN="N";
		}
		 if(("").equals(restrictTheatreBookingYN))
		{
		restrictTheatreBookingYN="Y";
		}
		if(("").equals(transfer_schedule_yn))
		{
		transfer_schedule_yn="Y";
		}

		//checking booking Rights here
		// NOTE: ("OT_SLATE").equals(called_from) is for OT Slate Reschdule from slate tab 
		if("Y".equals(restrictTheatreBookingYN)){
			if((transfer_schedule_yn.equals("N") ) && (("OT_SLATE").equals(called_from) || ("OT_TO_BE_RESCHD_CASES").equals(function_id)||("OT_SLATE_JAVA").equals(function_id)||("OT_BOOKING_CANCEL_TRANSFER").equals(function_id) || ("BookingVerification").equals(function_id))){
				sbr.append("<script>");
				sbr.append("var msg=getMessage('APP-OT0090T','OT');");
				sbr.append("alert(msg);");
				if("Y".equals(alternateBooking) || ("OT_SLATE").equals(called_from))
                {
                	sbr.append("window.close();");
                }
                else
                sbr.append("parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				sbr.append("</script>");
				out.println(sbr.toString());
				sbr.setLength(0);
			}
	        else
			if((strBookingYN.equals("N") || strBookingYN.length()==0) && !("OT_SLATE").equals(called_from) && !("OT_TO_BE_RESCHD_CASES").equals(function_id) && !("OT_SLATE_JAVA").equals(function_id)&& !("OT_BOOKING_CANCEL_TRANSFER").equals(function_id) && !("BookingVerification").equals(function_id)){
				sbr.append("<script>");
				sbr.append("var msg=getMessage('APP-OT0092','OT');");
				sbr.append("alert(msg);");
				if("Y".equals(alternateBooking) || "OR".equals(called_from))
				{
					sbr.append("window.close();");
				}else{
				sbr.append("window.parent.parent.parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				}
				//sbr.append("parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				sbr.append("</script>");
				out.println(sbr.toString());
				sbr.setLength(0);
			}
		}

		if (strPrefDate.length()==0)	
			strPrefDate = prefDate;		
 		
		//CRF 298 
		
		//Fetch Site Param and Facility Set up Param
		
		if("Y".equals(alternateBooking) && strOrderId.length() > 0)
		{
			
			boolean orderExists = false;
			String checkIfOrderIdExists = "SELECT 1 FROM OT_PENDING_ORDERS_VW WHERE ORDER_ID = ? AND LANGUAGE_ID = 'en'";//186
			
			pstmt = conn.prepareCall(checkIfOrderIdExists);
			pstmt.setString(1, strOrderId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				orderExists = true;
				
			}
			if(rs!=null)	 
				rs.close();
			if(pstmt!=null)  
				pstmt.close();
			if(!orderExists)
			{
				sbr.append("<script>");
				sbr.append("var msg=getMessage('APP-OT0211','OT');");
				sbr.append("alert(msg);");
				
				sbr.append("window.close();");
				//sbr.append("parent.location.href='../../eCommon/jsp/dmenu.jsp'");
				sbr.append("</script>");
				out.println(sbr.toString());
				sbr.setLength(0);
			}
		}
		//show only from Menu / Pending Verification / from OR
		if(alternateBooking == null || !alternateBooking.equals("Y") 
		&& (called_from.equals("") || called_from.equals("BOOKING") || called_from.equals("OR"))
		&& (function_id != null && !function_id.equals("OT_BOOKING_CANCEL_TRANSFER")
				&& !function_id.equals("OT_TO_BE_RESCHD_CASES")))
		{
			String siteFacilitySetUpSQL="";//MO-CRF-20106
			
			if(customer_id.equalsIgnoreCase("MOHBR")){			
			siteFacilitySetUpSQL = "SELECT NVL(MULTI_FACILITY,'N') MULTI_FACILITY FROM OT_PARAM_FOR_FACILITY " + 
											"WHERE EXISTS(" + OTRepository.getOTKeyValue("ALT_FAC_SITE_SETTING") + ") AND OPERATING_FACILITY_ID = ?";
			}else if(customer_id.equalsIgnoreCase("MOD")){		
			siteFacilitySetUpSQL = "SELECT NVL(MULTI_FACILITY,'N') MULTI_FACILITY FROM OT_PARAM_FOR_FACILITY " + 
											"WHERE EXISTS(" + OTRepository.getOTKeyValue("ALT_FAC_SITE_SETTING_MOD") + ") AND OPERATING_FACILITY_ID = ?";
			}
			
			pstmt = conn.prepareCall(siteFacilitySetUpSQL);
			pstmt.setString(1, facilityid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				multiFacility = rs.getString("MULTI_FACILITY");
			}
			
		
			if(rs!=null)	 
				rs.close();
			if(pstmt!=null)  
				pstmt.close();
		}

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg From DiarySheduleSearch.jsp"+e.getMessage());
	}finally{
		try{
			if(rs!=null)		rs.close();
			if(pstmt !=null)  pstmt.close();
			ConnectionManager.returnConnection(conn,request);
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strPrefDate));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

	if("Y".equals(multiFacility))
	{

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

	}

            _bw.write(_wl_block26Bytes, _wl_block26);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(preferedDate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(prefDate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(preferedMonth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(selOrderIds));
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ammendFlag));
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strBookingNo));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(endTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strBookingNo));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(diary_sched_for_surg_reqd_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fpp_category));
            _bw.write(_wl_block50Bytes, _wl_block50);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FirstAvailableDate.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredMonth.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ExternalFacility.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
