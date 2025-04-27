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
import java.sql.Clob;
import webbeans.eCommon.ConnectionManager;
import eOT.OperationDtlBean;
import eOT.Common.OTRepository;
import java.util.ArrayList;
import eOR.OrderEntryBillingQueryBean;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __operoverbookinghdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperOverBookingHdr.jsp", 1741325592000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n<!-- <TITLE>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</TITLE> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"/>\n\n<Script Language=\"JavaScript\"  src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n<script type=\"text/javascript\">\n\tfunction refreshTotalCount(){\n\t\tvar rowCount = document.forms[0].rowCountOverBooking.value;\n\t\tvar userOverBookYN = document.forms[0].userOverBookYN.value;\t\t\n\t\tvar overbookcount = document.forms[0].overbookcount.value;//Added by Muthu against 31719\n\t\t//alert(\'orderid\'+ document.forms[0].orderid.value);\n\t\tvar params = document.forms[0].params.value;\n\t\tparams = params + \"&row_count=\"+rowCount+\"&userOverBookYN=\"+userOverBookYN+\"&overbookcount=\"+overbookcount;\n\t\t//alert(\'params\' + params);//Sanjay\n\t\t//var param = \"row_count=\"+rowCount+\"&userOverBookYN=\"+userOverBookYN+\"&overbookcount=\"+overbookcount;\n\t\tparent.footer_frame.location.href = \'../../eOT/jsp/OperOverBookingFtr.jsp?\'+params;\t\t\t\n\t}\n\tfunction assignDuplicateValues(rowCount, procedureName, procedureDuration){\n\t\tvar timeDuration = procedureDuration.split(\",\");\n\t\tvar timeDurationSplit1 = timeDuration[0].split(\":\");\n\t\tvar timeDurationSplit2 = timeDuration[1].split(\":\");\n\t\tvar timeInMins1 = timeDurationSplit1[1];\n\t\tvar timeInMins2 = timeDurationSplit2[1];\t\t\n\t\tvar totalTimeInMins = parseInt(timeInMins1, 10) + parseInt(timeInMins2, 10);\n\t\tvar actualTimeInMins = totalTimeInMins%60;\n\t\tvar additionalTimeInHrs = parseInt(totalTimeInMins/60);\n\t\tvar timeInHrs1 = timeDurationSplit1[0];\n\t\tvar timeInHrs2 = timeDurationSplit2[0];\n\t\tvar totalTimeInHrs = parseInt(timeInHrs1, 10) + parseInt(timeInHrs2, 10) + additionalTimeInHrs;\n\t\tprocedureDuration = LPad(totalTimeInHrs,2,\"0\") + \":\" + LPad(actualTimeInMins,2,\"0\");\n\t\t//document.getElementById(\'procedureName\'+rowCount).style.color = \'white\'; //Commented by Muthu\n\t\t//document.getElementById(\'procedureDuration\'+rowCount).style.color = \'white\'; //Commented by Muthu\n\t\tdocument.getElementById(\'procedureName\'+rowCount).style.color = \'\';\n\t\tdocument.getElementById(\'procedureDuration\'+rowCount).style.color = \'\';\n\t\tdocument.getElementById(\'procedureName\'+rowCount).innerHTML = procedureName;\t\t\n\t\t//document.getElementById(\'procedureDuration\'+rowCount).innerHTML = procedureDuration;\n\t\tdocument.getElementById(\'procedureDuration\'+rowCount).innerHTML = procedureDuration + \" \" + getLabel(\"Common.Hrs.label\",\"Common\");\n\t\t\n\t}\n\tfunction LPad(ContentToSize,PadLength,PadChar)\n\t{\n\t\tvar PaddedString=ContentToSize.toString();\n\t\tvar PaddedStringLength = PaddedString.length;\t\t\n\t\tif (PaddedStringLength < PadLength)\n\t\t{\n\t\t\tfor(i=1;i<PadLength;i++)\n\t\t\t{\n\t\t\t\tPaddedString=PadChar+PaddedString;\t\t\t\n\t\t\t}\n\t\t}\n\t\t\n     return PaddedString;\n\t}\n</script>\n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<form name=\'OverBookedCases\' id=\'OverBookedCases\' method=\'POST\' action = \'../../eOT/jsp/OperOverBookingFtr.jsp\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table border=\'1\' cellpadding=0  cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<td class=\'columnheader\' colspan=\'6\' >\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \t\n\t</td>\n\t<td class=\'columnheader\' colspan=\'1\' >\n    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \t\n\t<td class=\'columnheader\' colspan=\'1\' >\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" - ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</td>\n\t<!-- </td> \t</td>\t-->\n</tr>\n\n<tr> </tr>\n\n<tr>\n\t<td class=\'columnheader\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t</td>\n\t<td class=\'columnheader\'>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</td>\n\t<td class=\'columnheader\'>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</td>\n\t<td class=\'columnheader\' width = \'25%\'>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="  \n\t</td>\n\t<td class=\'columnheader\'>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t <script> \n\t\t\t\t //alert(\"procedureDuration ->\" + \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\n\t\t\t\t var procedureDurationTemp = document.getElementById(\'procedureDuration\'+\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\').innerHTML + \",\" + \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\t\t\t //alert(\"procedureDurationTemp ->\" + procedureDurationTemp);\n\t\t\t\t assignDuplicateValues(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\', \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\', procedureDurationTemp); \n\t\t\t </script>\n\t\t\t ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</table>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'rowCountOverBooking\' id=\'rowCountOverBooking\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"strFacilityId\" id=\"strFacilityId\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"booking_date\" id=\"booking_date\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\"hidden\" name=\"roomCode\" id=\"roomCode\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\"hidden\" name=\"roomDesc\" id=\"roomDesc\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=\"hidden\" name=\"surgeonCode\" id=\"surgeonCode\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"surgeonName\" id=\"surgeonName\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"start_time\" id=\"start_time\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"hidden_time\" id=\"hidden_time\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"over_booking_case_yn\" id=\"over_booking_case_yn\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"procedure\" id=\"procedure\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"orderid\" id=\"orderid\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"> \n<input type=\'hidden\' name=\'userOverBookYN\' id=\'userOverBookYN\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\'hidden\' name=\'overbookcount\' id=\'overbookcount\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n</form>\n<script>\nrefreshTotalCount();\n</script>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 
	String or_bean_id 				    = "orderentrybean";
    String or_bean_name 			    = "eOR.OrderEntryBean";

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// fetching the Login User Id
Properties p = (Properties)session.getValue("jdbc");
String login_user = p.getProperty("login_user");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

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

            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block2Bytes, _wl_block2);

HttpSession httpSession = request.getSession(false);
//fetching the required parameters from the previous page Calenderslot.jsp
String strFacilityId = ""+httpSession.getValue("facility_id");
String booking_date = checkForNull(request.getParameter("booking_date"));
String roomCode = checkForNull(request.getParameter("roomCode"));
String roomDesc = checkForNull(request.getParameter("roomDesc"));
String surgeonCode1 = checkForNull(request.getParameter("surgeonCode"));
String surgeonName1 = checkForNull(request.getParameter("surgeonName"));
String speciality_code = checkForNull(request.getParameter("speciality_code"));
String speciality_desc = checkForNull(request.getParameter("speciality_desc"));
String start_time = checkForNull(request.getParameter("start_time"));
String hidden_time = checkForNull(request.getParameter("hidden_time"));
String over_booking_case_yn = checkForNull(request.getParameter("over_booking_case_yn"));
String called_from = checkForNull(request.getParameter("called_from"));
String procedure = checkForNull(request.getParameter("procedure"));
String orderid = checkForNull(request.getParameter("orderid"));
// all parameters are fetched from previous page Calenderslot.jsp

// declaring parameters to store from the query
String patientId = "";
String patIdTemp = "";
String patientShortName = "";
String surgeryType = "";
String procedureName = "";
String procedureDuration = "";
String sourceType = "";
String surgeonName = "";
String sourceCode = "";
String location = "";
String scheduleStartTime = "";
String scheduleEndTime = "";
String userOverBookYN = "";
String bookingTime = "";
//Added by muthu against 31719
String overbookcount = "";
String overbookedYN="";
//Added by muthu against 31719

int rowCount = 0;
int rowCountOverBooking = 0;
Connection con = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
PreparedStatement pstmt3 = null;
PreparedStatement pstmt4 = null;
ResultSet rs = null;
ResultSet rs1 = null;
ResultSet rs2 = null;
ResultSet rs3 = null;
ResultSet rs4 = null;
String sql = "";
String sqlW = "";
String sqlC = "";
String sqlE = "";
String sqlD = "";
String sqlU = "";
String sqlAvail = "";
String class_val = "";
//String class_val = "EMERGENT"; //Commented by Muthu


try{

  con = ConnectionManager.getConnection(request);  
  // Framing the Query to get the required parameters for displaying purpose
  //sql = "select c.patient_id, c.short_name, d.short_desc, e.short_Desc, to_char(b.OPER_DURN,'HH24:MI'), a.source_type, F.SHORT_NAME, a.source_code from OT_BOOKING_HDR a, ot_booking_dtls b, mp_patient_mast c, OT_NATURE_OF_SURGERY d, ot_oper_mast_lang_vw e, Am_practitioner_lang_vw f where a.over_booked_yn = ? and b.booking_num = a.booking_num and c.patient_id = a.patient_id and e.oper_code =  b.oper_code and e.language_id = ? and a.oper_room_code = ? and d.nature_code = a.nature_code and f.language_id(+) = ? and a.TEAM_DOCTOR_CODE = f.practitioner_id(+) and to_char(a.booking_date,'dd/mm/yyyy') = ?";
  sql = "select c.patient_id, c.short_name, d.short_desc, e.short_Desc, to_char(b.OPER_DURN,'HH24:MI'), a.source_type, F.SHORT_NAME, a.source_code, NVL(a.over_booked_yn,'N'), to_char(a.BOOKING_START_TIME,'hh24:mi'), a.booking_num from OT_BOOKING_HDR a, ot_booking_dtls b, mp_patient_mast c, OT_NATURE_OF_SURGERY d, ot_oper_mast_lang_vw e, Am_practitioner_lang_vw f where b.booking_num = a.booking_num and c.patient_id = a.patient_id and e.oper_code =  b.oper_code and e.language_id = ? and a.oper_room_code = ? and d.nature_code = a.nature_code and f.language_id(+) = ? and a.TEAM_DOCTOR_CODE = f.practitioner_id(+) and to_char(a.booking_date,'dd/mm/yyyy') = ? and BOOKING_STATUS <> '9' order by 11";

  sqlW = "SELECT LONG_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID = ? AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' and NURSING_UNIT_CODE = ?";

  sqlC = "SELECT LONG_DESC FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = ? AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' and CLINIC_CODE = ?" ;

  sqlE = "SELECT LONG_DESC FROM AM_REFERRAL_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(EFF_STATUS,'D') = 'E' and REFERRAL_CODE = ?" ;

  sqlD = "select to_char(WD_START_TIME,'hh24:MI'), to_char(WD_END_TIME,'hh24:MI') from OT_OPER_ROOM_LANG_VW where oper_room_code = ? and language_id = ?  and operating_facility_id = ?";

  sqlU = "select NVL(OVER_BOOK_YN, 'N') from OT_BOOKING_ACCESS_RIGHTS where APPL_USER_ID = ? and OPERATING_FACILITY_ID = ?";
  

  sqlAvail ="select NVL(OVER_BOOK_COUNT,0) from OT_OPER_ROOM where oper_room_code = ? and OPERATING_FACILITY_ID = ?";

  pstmt3 = con.prepareStatement(sqlU);
  pstmt3.setString(1,login_user);  
  pstmt3.setString(2,strFacilityId);
  rs3 = pstmt3.executeQuery();	 
	 while(rs3.next() && rs3!=null){
		 userOverBookYN = rs3.getString(1);
	 }

  pstmt2 = con.prepareStatement(sqlD);
  pstmt2.setString(1,roomCode);
  pstmt2.setString(2,locale);
  pstmt2.setString(3,strFacilityId);
  rs2 = pstmt2.executeQuery();	 
	 while(rs2.next() && rs2!=null){
		 scheduleStartTime = rs2.getString(1);
		 scheduleEndTime = rs2.getString(2);
	 }

//Added on 7-11-12 by Muthu against 31719
  pstmt4 = con.prepareStatement(sqlAvail);
  pstmt4.setString(1,roomCode);
  pstmt4.setString(2,strFacilityId);
  rs4 = pstmt4.executeQuery();	 
	 while(rs4.next() && rs4!=null){
		 overbookcount = rs4.getString(1);
	 }
	 //if (Integer.parseInt(overbookcount) > 0 ) {//Sanjay
//Added on 7-11-12 by Muthu against 31719

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( scheduleStartTime ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( scheduleEndTime ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
	
	 //}//Sanjay
  pstmt = con.prepareStatement(sql);
/*  pstmt.setString(1,over_booking_case_yn);
  pstmt.setString(2,locale);
  pstmt.setString(3,roomCode);
  pstmt.setString(4,locale);
  pstmt.setString(5,booking_date);
  */

  pstmt.setString(1,locale);
  pstmt.setString(2,roomCode);
  pstmt.setString(3,locale);
  pstmt.setString(4,booking_date);
  rs = pstmt.executeQuery();	 
  patientId = "";
  patIdTemp = "";
	 while(rs.next() && rs!=null)
	{	
		 		 
		 /*
		 patientId = checkForNull(rs.getString(1));
		 patientShortName = checkForNull(rs.getString(2));		 
		 surgeryType = checkForNull(rs.getString(3));
		 procedureName = checkForNull(rs.getString(4));
		 procedureDuration = checkForNull(rs.getString(5));
		 sourceType = checkForNull(rs.getString(6));
		 System.out.println("OperOverBookingHdr.jsp sourceType:" + sourceType + ":");
		 surgeonName = checkForNull(rs.getString(7));
		 sourceCode = checkForNull(rs.getString(8));
		 System.out.println("OperOverBookingHdr.jsp sourceCode:" + sourceCode + ":");
		 */		 
		 
		 
		 patIdTemp = checkForNull(rs.getString(1));
		 
		 if (patientId.equalsIgnoreCase(patIdTemp)) {			 
			 patientId = patIdTemp;			 
			 procedureName = procedureName + ", " + checkForNull(rs.getString(4));
			 //System.out.println("OperOverBookingHdr.jsp procedureName:" + procedureName);
			 //procedureDuration = procedureDuration + "," + checkForNull(rs.getString(5));
			 procedureDuration = checkForNull(rs.getString(5));
			 //System.out.println("OperOverBookingHdr.jsp procedureDuration:" + procedureDuration + ":rowCount:" + rowCount);
			 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( procedureDuration ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( rowCount ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( procedureDuration ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( procedureName ));
            _bw.write(_wl_block25Bytes, _wl_block25);
			 
		 }
		 else {			 
			 //rowCount ++;
			 //System.out.println("OperOverBookingHdr.jsp else");
			 patientId = rs.getString(1);		 
			 patientShortName = rs.getString(2);		 
			 surgeryType = rs.getString(3);
			 procedureName = rs.getString(4);
			 procedureDuration = rs.getString(5);
			 sourceType = rs.getString(6);
			 surgeonName = checkForNull(rs.getString(7));
			 sourceCode = checkForNull(rs.getString(8));
			 //Added on 7-11-12 by Muthu against 31719
			 overbookedYN = checkForNull(rs.getString(9));
			 bookingTime = checkForNull(rs.getString(10));			 
			 //out.println("bookingTime:" + bookingTime + ":overbookedYN:" + overbookedYN);//sanjay
				if(overbookedYN.equalsIgnoreCase("N")){					
					class_val =   "QRYEVEN";					
					}
				else{					
					class_val =   "EMERGENT";
					rowCountOverBooking++;
					//rowCount++;//commented by Sanjay 26-Dec-12
					}
				rowCount++;
			//Added on 7-11-12 by Muthu against 31719

			 if (patientShortName.length() > 25) {
				 patientShortName = patientShortName.substring(0,24)+"..";
				 //System.out.println("OperOverBookingHdr:" + patientShortName.length() + ":patientShortName:" + patientShortName);
			 }
			 if (surgeonName.length() == 0) {
				 surgeonName = "*ALL";
			 }
			 if (sourceType.equalsIgnoreCase("W") || sourceType.equalsIgnoreCase("N") ) {
				 pstmt1 = con.prepareStatement(sqlW);
				 pstmt1.setString(1,locale);
				 pstmt1.setString(2,strFacilityId);
				 pstmt1.setString(3,sourceCode);
		     }
			 else if (sourceType.equalsIgnoreCase("C")) { 
				 pstmt1 = con.prepareStatement(sqlC);
				 pstmt1.setString(1,locale);
			     pstmt1.setString(2,strFacilityId);
			     pstmt1.setString(3,sourceCode);			 
			 }
			 else if (sourceType.equalsIgnoreCase("E")) {
				 pstmt1 = con.prepareStatement(sqlE);
				 pstmt1.setString(1,locale);			 
				 pstmt1.setString(2,sourceCode);			 
			 }
			 rs1 = pstmt1.executeQuery();
			 while(rs1.next() && rs1!=null) {
				 location = checkForNull(rs1.getString(1));
			 } 
			 //if (Integer.parseInt(overbookcount) > 0 ) {//Sanjay
				 out.println("<tr>" );
				 out.println("<td id='"+"booking_date"+rowCount+"' class='"+class_val+"'value='"+booking_date+"'><font color=''>"+booking_date+"</td>");			 
				 //out.println("<td id='"+"procedureDuration"+rowCount+"'class='"+class_val+"'>"+procedureDuration+"</td>");
				 out.println("<td id='"+"procedureDuration"+rowCount+"'class='"+class_val+"'>"+procedureDuration+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hrs.label","common_labels")+"</td>");
				 out.println("<td id='"+"patientId"+rowCount+"'class='"+class_val+"'><font color=''>"+patientId+"</td>");
				 out.println("<td id='"+"patientShortName"+rowCount+"'class='"+class_val+"'><font color=''>"+patientShortName+"</td>");
				 out.println("<td id='"+"procedureName"+rowCount+"'class='"+class_val+"'><font color=''>"+procedureName+"</td>");
				 out.println("<td id='"+"surgeonName"+rowCount+"'class='"+class_val+"'><font color=''>"+surgeonName+"</td>");
				 out.println("<td id='"+"surgeryType"+rowCount+"'class='"+class_val+"'><font color=''>"+surgeryType+"</td>");
				 out.println("<td id='"+"location"+rowCount+"'class='"+class_val+"'><font color=''>"+location+"</td>");
				 out.println("</tr>");			
			 //}//Sanjay
		 }

/* <fmt:message key="Common.Hrs.label" bundle="${common_labels}"
 "<fmt:message key=\"Common.Hrs.label\" bundle=\"${common_labels}\" "
out.println("<tr>" );
out.println("<td class='"+class_val+"'>"+booking_date+"</td>");
out.println("<td class='"+class_val+"'>"+procedureDuration+"</td>");
out.println("<td class='"+class_val+"'>"+patientId+"</td>");
out.println("<td class='"+class_val+"'>"+patientShortName+"</td>");
out.println("<td class='"+class_val+"'>"+procedureName+"</td>");
out.println("<td class='"+class_val+"'>"+surgeonName+"</td>");
out.println("<td class='"+class_val+"'>"+surgeryType+"</td>");
out.println("<td class='"+class_val+"'>"+location+"</td>");
out.println("</tr>");
*/
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if(rs1 != null) rs1.close();
	if(pstmt1 != null) pstmt1.close();
	if(rs2 != null) rs2.close();
	if(pstmt2 != null) pstmt2.close();
	if(rs3 != null) rs3.close();
    if(pstmt3 != null) pstmt3.close();
	}
   catch(Exception ee){  
	   ee.printStackTrace();
	   System.err.println("Exception in OperationProcedureHdr.jsp "+ee);
	 }finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(rs1 != null) rs1.close();
		if(pstmt1 != null) pstmt1.close();
		if(rs2 != null) rs2.close();
	    if(pstmt2 != null) pstmt2.close();
		if(rs3 != null) rs3.close();
	    if(pstmt3 != null) pstmt3.close();
		   ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
 
		//if(strOrderId.length()>0){
			//out.println("<script language='javascript'>disableButton();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		//}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( rowCount ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( rowCountOverBooking ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( strFacilityId ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( booking_date ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( roomCode ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( roomDesc ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( surgeonCode1 ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( surgeonName1 ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( speciality_code ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( speciality_desc ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( start_time ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( hidden_time ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( over_booking_case_yn ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( called_from ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( procedure ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( orderid ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(userOverBookYN));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(overbookcount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OverBookedCasesInTheRoom.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ScheduleTime.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BookedDate.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TotalProcTime.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
