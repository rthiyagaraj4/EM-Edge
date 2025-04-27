package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __surgeryhistoryqryresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SurgeryHistoryQryResults.jsp", 1734262390000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<Script src=\"../../eXH/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n<style>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\tTD.";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="{\n\t\t\tBACKGROUND-COLOR:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tBORDER-STYLE: solid;\n\t\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\t\tBORDER-TOP: #CC9966 1px solid;\n\t   }\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t TD.OTMENULAYER\n\t\t  {\n\t \t\tFONT-FAMILY: VERDANA ;\n\t \t\tFONT-SIZE: 10PT ;\n\t \t\tBACKGROUND-COLOR: #D8BFD8;\n\t \t\tCOLOR: WHITE;\n\t\t}\n\t\tTD.OTMENU\n\t\t  {\n\t\t\tBACKGROUND-COLOR: #C0C0C0 ;\n\t\t\tFONT-SIZE: 9PT ;\n\t\t\tBORDER-STYLE: DASHED;\n\t\t\tBORDER-LEFT-COLOR: #FFA500;\n\t\t\tBORDER-RIGHT-COLOR: #FFA500;\n\t\t\tBORDER-TOP-COLOR: #FFFACD;\n\t\t\tBORDER-BOTTOM-COLOR: #FFFACD;\n\t\t }\n\t\tTD.OTCLASS{\n\t\t\tFONT-SIZE: 9pt ;\n\t\t\tBORDER-STYLE: SOLID;\n\t\t\tborder-left-color: #B2B6D7;\n\t\t\tborder-right-color: #B2B6D7;\n\t\t\tborder-top-color: #E2E3F0;\n\t\t\tborder-bottom-color: #E2E3F0;\n\t\t\theight:18;\t\n\t   }\n\t\n\tdiv.tableContainer {\n\t\twidth: 65%;\t\t/* table width will be 99% of this*/\n\t\theight: 295px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 99%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: auto;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\n\n\n\n</style>\n\n\t<!-- <script language=\"Javascript\" src=\"../../eCommon/js/messages.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/OTMessages.js\"></script> -->\n\t<script language=\"JavaScript\" src=\"../../eOT/js/SurgeryHistory.js\"></script>\n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute; width:30%; \tvisibility:hidden;\' bgcolor=\'blue\'>\t\n</div>\n<form name=\"SurgeryHistoryQryResultsForm\" id=\"SurgeryHistoryQryResultsForm\">\n<div id=\"tableContainer\">\n<table class=\'grid\' cellpadding=\"3\" cellspacing=\"0\" border=\"1\" width=\"100%\" align=\'3\'>\n\n\t<THEAD>\n\t\t<TR>\n\t\t\t<th class =\'columnheader\'> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t<th class =\'columnheader\'> ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th class =\'columnheader\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t</TR>\n\t</THEAD>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<tr>\n\t<td width=\'\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\' onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" onMouseOver=\'hideToolTip();\'>\n<a class=\'gridDataBlue\' href=\"javascript:displayToolTip(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\\\">\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'imgArrow";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'></td>\n\t\n\t<td class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </td>\n\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </td>\n\t \n\t \n\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" style=\"background-color: ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =";\"  width=\'3%\'></td>\n\t \n\t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" width=\"8%\" align=\"center\">\n\t<!--<a class=\'gridlink\' href=\"javascript:callSurgeryDetails(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\"> ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</a></td>--> <!--Commented by lakshmi against IN29152-->\n\n\t<!--Modified by lakshmi against IN29152-->\n\t<a class=\'gridlink\' href=\"javascript:callSurgeryDetails(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td>\n\t<td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\n<a class =\'gridlink\' href=\"javascript:callSurgeryNotes(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\n\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </a></td>\n</tr>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n \n</table>\n</div>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n</form>\n</html>\n\n\n\n\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
 
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String bean_id		= "OTCommonBean";
	String bean_name	= "eOT.OTCommonBean";
	OTCommonBean bean= (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	ArrayList color_array = bean.getOTStatusColors();

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	for(int i =0;i<color_array.size();i+=3){
						

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((String)color_array.get(i)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String)color_array.get(i+2)));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String oper_code = checkForNull(request.getParameter("oper_code"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	//String from_date = checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("from_date"),"DMY","en",locale));
	//String to_date = checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("to_date"),"DMY","en",locale));
	String from_date = checkForNull(request.getParameter("from_date"));
    String to_date = checkForNull(request.getParameter("to_date"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String login_user = (String) session.getValue("login_user");
	String oper_date="";
	//String oper_num="";
	String oper_status="";
	
	String check_in_time =	"";
	String check_in_or_time="";
	String check_in_rec_time="";
	String check_out_rec_time="";
	String patient_class="";
	String episode_type="";
	String encounter_id="";
	String episode_id="";
	String speciality_code="";
	String booking_num="";
	String order_id="";
	String doc_level="";
	String SQL="";
	//Added by lakshmi against IN29152 starts here
	String check_out_or_time="";
	String recovery_room_desc="";
	//Added by lakshmi against IN29152 ends here

	// SQL="SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY',DECODE('"+locale+"','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,OPER_NUM,OPER_CODE,GET_DESC('"+locale+"'OPER_DESC) OPER_DESC ,SURGEON_CODE,SURGEON_NAME,OPER_STATUS,  TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),PATIENT_CLASS,EPISODE_TYPE,ENCOUNTER_ID, EPISODE_ID,SPECIALITY_CODE,BOOKING_NUM,ORDER_ID FROM OT_SURGERY_HISTORY WHERE LANGUAGE_ID='"+locale+"' and PATIENT_ID=?";
//Commented By Muthukumar against lN:029152 on 12-10-11
/*	 SQL="SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY',DECODE('"+locale+"','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,OPER_NUM,OPER_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',OPER_CODE) OPER_DESC,SURGEON_CODE,GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',SURGEON_CODE) SURGEON_NAME,OPER_STATUS, TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),PATIENT_CLASS,EPISODE_TYPE,ENCOUNTER_ID, EPISODE_ID,SPECIALITY_CODE,BOOKING_NUM,ORDER_ID,DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY WHERE LANGUAGE_ID='"+locale+"' and PATIENT_ID=?";*/


//Below Query is Modified By Muthukumar against lN:029152 on 12-10-11
		// SQL="SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY',DECODE('"+locale+"','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,OPER_NUM,OPER_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',OPER_CODE) OPER_DESC,SURGEON_CODE,GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',SURGEON_CODE) SURGEON_NAME,OPER_STATUS, TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI'),PATIENT_CLASS,EPISODE_TYPE,ENCOUNTER_ID, EPISODE_ID,SPECIALITY_CODE,BOOKING_NUM,ORDER_ID,DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY WHERE LANGUAGE_ID='"+locale+"' and PATIENT_ID=?";
//Below Query is Modified By Muthukumar against lN:029152 on 12-10-11
	/*(1)TO_CHAR(OPER_DATE,'DD/MM/YYYY'),(2)OPER_NUM,(3)PER_CODE,(4)OPER_DESC,(5)SURGEON_CODE,(6)SURGEON_NAME,(7)OPER_STATUS, (8) TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),(9)TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),(10)TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),(11)TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),(12)PATIENT_CLASS, (13)EPISODE_TYPE, (14) ENCOUNTER_ID, (15) EPISODE_ID FROM OT_SURGERY_HISTORY WHERE PATIENT_ID=?";*/

		
	/*if(sex.length()>0){
		SQL+= " AND SEX=?";
	}*/

	//Below Query is Modified By LAKSHMI against lN:029152 oN 16/08/2012 STARTS HERE
/*		 SQL="SELECT TO_CHAR(A.OPER_DATE,'DD/MM/YYYY',DECODE('en','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,A.OPER_NUM,A.OPER_CODE, GET_DESC('en','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPER_DESC,A.SURGEON_CODE,GET_DESC('en','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',A.SURGEON_CODE) SURGEON_NAME,A.OPER_STATUS, TO_CHAR(A.CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),B.RECOVERY_ROOM_DESC,TO_CHAR(A.CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI'),A.PATIENT_CLASS,A.EPISODE_TYPE,A.ENCOUNTER_ID, A.EPISODE_ID,A.SPECIALITY_CODE,A.BOOKING_NUM,A.ORDER_ID,A.DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY A, OT_RECOVERY_ROOM B WHERE A.LANGUAGE_ID='"+locale+"' and A.PATIENT_ID= ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.RECVERY_ROOM_CODE = B.RECOVERY_ROOM_CODE"; */
//Below Query is Modified By LAKSHMI against lN:029152 on 16/08/2012 ENDS HERE
// Modified by DhanasekarV against  SurgeryQuery result is not appearing when recovery room code is null   on 12/10/2012

		 SQL="SELECT TO_CHAR(A.OPER_DATE,'DD/MM/YYYY',DECODE('en','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,A.OPER_NUM,A.OPER_CODE, GET_DESC('en','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPER_DESC,A.SURGEON_CODE,GET_DESC('en','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',A.SURGEON_CODE) SURGEON_NAME,A.OPER_STATUS, TO_CHAR(A.CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),B.RECOVERY_ROOM_DESC,TO_CHAR(A.CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI'),A.PATIENT_CLASS,A.EPISODE_TYPE,A.ENCOUNTER_ID, A.EPISODE_ID,A.SPECIALITY_CODE,A.BOOKING_NUM,A.ORDER_ID,A.DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY A, OT_RECOVERY_ROOM B WHERE A.LANGUAGE_ID='"+locale+"' and A.PATIENT_ID= ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+) AND A.RECVERY_ROOM_CODE = B.RECOVERY_ROOM_CODE(+)";//MMS-QH-CRF-0199

//END 


	if(facility_id.length()>0){
		//SQL+= " AND OPERATING_FACILITY_ID=?";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.OPERATING_FACILITY_ID=?";

	}
	
	if(surgeon_code.length()>0){
		//SQL+= " AND SURGEON_CODE=?";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.SURGEON_CODE=?";
	}
	if(from_date.length()>0 && to_date.length()>0){
			//SQL+= " AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";
			//Modified By LAKSHMI against lN:029152
			SQL+= " AND A.OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";
	}else if(from_date.length()>0){
		//SQL+= " AND OPER_DATE > = TO_DATE(?,'DD/MM/YYYY')";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.OPER_DATE > = TO_DATE(?,'DD/MM/YYYY')";
	}else if(to_date.length()>0){
//		SQL+=" AND OPER_DATE<=TO_DATE(?,'DD/MM/YYYY')";
//Modified By LAKSHMI against lN:029152
SQL+=" AND A.OPER_DATE<=TO_DATE(?,'DD/MM/YYYY')";
	}

	if(oper_code.length()>0){
		//SQL+= " AND OPER_CODE=?";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.OPER_CODE=?";
	}
	
	String	qryVal="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	int sno=0;
	String result="";
	try{
		con = ConnectionManager.getConnection(request);
		/*if(called_from.equals("OPER_REG")){
			pstmt = con.prepareStatement(OPER_REG_SQL);
			pstmt.setString(1,patient_id);
			pstmt.setString(1,oper_num);
		}else{*/

			pstmt = con.prepareStatement(SQL);
			pstmt.setString(++sno,patient_id);
			if(facility_id.length()>0){
				pstmt.setString(++sno,facility_id);
			}
			//SURGEON FILTER
			if(surgeon_code.length()>0)
				pstmt.setString(++sno,surgeon_code);
			//BOTH FROM_DATE AND TO_DATE FILTER
			if(from_date.length()>0 && to_date.length()>0){
				pstmt.setString(++sno,from_date);
				pstmt.setString(++sno,to_date);
			}else if(from_date.length()>0){
				pstmt.setString(++sno,from_date);
			} else if(to_date.length()>0){
				pstmt.setString(++sno,to_date);
			}
			//OPER_CODE FILTER
			if(oper_code.length()>0)
				pstmt.setString(++sno,oper_code);
		//}

		rst = pstmt.executeQuery();
		int index=0;
		while(rst.next()){
		   qryVal=(index%2==0)?"gridData":"gridData";
		   ++index;
		   oper_date = checkForNull(rst.getString(1));
		   //oper_date=com.ehis.util.DateUtils.convertDate(oper_date,"DMY","en",locale);
		   oper_num = checkForNull(rst.getString(2));
		   oper_code = checkForNull(rst.getString(3));
		   surgeon_code = checkForNull(rst.getString(5));
		   oper_status = checkForNull(rst.getString(7));
		   check_in_time = checkForNull(rst.getString(8));
		  // System.out.println("check_in_time in SurgeryHistoryQryResults "+check_in_time);
		   //check_in_or_time = checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString(9),"DMYHM","en",locale));
		   check_in_or_time = checkForNull(rst.getString(9));
		   check_out_or_time = checkForNull(rst.getString(10));//Added by lakshmi against IN29152
		   recovery_room_desc = checkForNull(rst.getString(11));//Added by lakshmi against IN29152
		   
		  /* check_in_rec_time = checkForNull(rst.getString(10));
		   check_out_rec_time = checkForNull(rst.getString(11));
		   patient_class=checkForNull(rst.getString(12));
		   episode_type=checkForNull(rst.getString(13));
		   encounter_id=checkForNull(rst.getString(14));
		   episode_id=checkForNull(rst.getString(15));
		   speciality_code=checkForNull(rst.getString(16));
		   booking_num=checkForNull(rst.getString(17));
		   order_id = checkForNull(rst.getString(18));
		   doc_level = checkForNull(rst.getString(19));*/ //Commented by lakshmi against IN29152
			
		   //Modified by lakshmi agisnt IN29152
		   check_in_rec_time = checkForNull(rst.getString(12));
		   check_out_rec_time = checkForNull(rst.getString(13));
		   patient_class=checkForNull(rst.getString(14));
		   episode_type=checkForNull(rst.getString(15));
		   encounter_id=checkForNull(rst.getString(16));
		   episode_id=checkForNull(rst.getString(17));
		   speciality_code=checkForNull(rst.getString(18));
		   booking_num=checkForNull(rst.getString(19));
		   order_id = checkForNull(rst.getString(20));
		   doc_level = checkForNull(rst.getString(21));
		   //result = facility_id+"::"+patient_id+"::"+oper_date+"::"+oper_num+"::"+oper_code+"::"+surgeon_code
			 
	   	 

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(index));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oper_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(index));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(checkForNull(rst.getString(4))));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(checkForNull(rst.getString(6))));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rst.getString(7)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((String)color_array.get(color_array.indexOf(rst.getString(7))+2)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_in_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_in_or_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_in_rec_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_out_rec_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_in_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_in_or_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_out_or_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(recovery_room_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_in_rec_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(check_out_rec_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(doc_level));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
	}
    if(index==0){
		out.println("<script>callNoRecords();</script>");
	}
	}catch(Exception e){
		 System.err.println("Err Msg in SurgeryHistoryQryResults.jsp"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationDate.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
