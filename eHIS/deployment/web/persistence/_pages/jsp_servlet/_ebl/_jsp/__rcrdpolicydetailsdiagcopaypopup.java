package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import blPolicy.EncounterSpecificDefinitionBean;
import eBL.Common.BlRepository;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __rcrdpolicydetailsdiagcopaypopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/RcrdPolicyDetailsDiagCopayPopup.jsp", 1709114783645L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/EncounterSpecAddTable.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/EncounterSpecPolicyDefnSrch.js\"></script>\n<script language=\'javascript\'>\nfunction checkDateFrom(obj){\n\tvar stdt = document.forms[0].startDate.value;\n\tvar endt = document.forms[0].endDate.value;\n\tvar startdtarr =stdt.split(\"/\");\n\tvar enddtarr = endt.split(\"/\");\n\tvar objarr = obj.value.split(\"/\");\n\tvar startdt = new Date();\n\tvar enddt = new Date();\n\tvar objdt = new Date();\n\tstartdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);\n\tenddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);\n\tobjdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);\n\tif((objdt < startdt) || (objdt > enddt) ){\n\t\talert(\"Please enter date in range \"+stdt+\" and \"+endt);\n\t\tobj.value = \'\';\n\t}\n}\nfunction close(){\n\tvar frmObj = document.forms[0];\n\txmlString=formXMLStringMain(frmObj);\n\t//alert(xmlString);\n\tupdation=formValidation(xmlString,\"popup\");\n\twindow.close();\t\n}\n\t\nfunction showCalendarLocal(fromTo,obj){\n\tif(fromTo == 1){\n\t\treturn showCalendar(\'pop_effFrom_\'+obj)\n\t}\n\telse if(fromTo == 2){\n\t\treturn showCalendar(\'pop_effTo_\'+obj)\n\t}\n\t\n}\nfunction showCalendarLocal(fromTo,obj){\n\tif(fromTo == 1){\n\t\treturn showCalendar(\'pop_effFrom_\'+obj)\n\t}\n\telse if(fromTo == 2){\n\t\treturn showCalendar(\'pop_effTo_\'+obj)\n\t}\n\t\n}\n\nfunction movePrevthis(start,end)\n{\n\tvar params =  document.forms[0].queryString.value;\n\t\n\n//\tvar params =  document.forms[0].queryString.value;\n \t\n  \n var strt = start-10;\n var endd= end-10;\n\t\n \n\tdocument.location.href=\"../../eBL/jsp/RcrdApprovalPolicyDetailsPreApprovalPopup.jsp?from=\"+strt+\"&to=\"+endd+\"&\"+params;\n\t\n\t}\n\t\nfunction moveNextthis(start,end)\n{\n\tvar params =  document.forms[0].queryString.value;\n\n\n\n\t\n\tvar strt = start +10;\n\tvar endd= end+10;\n\n\n\tdocument.location.href=\"../../eBL/jsp/RcrdApprovalPolicyDetailsPreApprovalPopup.jsp?from=\"+strt+\"&to=\"+endd+\"&\"+params;\n\n\t\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n\n\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 160px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t\t\n\n\t\t</style>\n</head>\n<body  onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" >\n<br/>\n<br/>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<form  id=\"frmPolicyInclExclCoverage\">\t\n\t<table width=\'90%\' align=\"center\">\n\t<tr>\n\t\t<td width=\'70%\'>\n\t\t</td>\n\t\t<td width=\'14%\' align=\'right\'>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</td>\n\t\t<td width=\'2%\'></td>\n\t\t<td width=\'14%\' align=\'left\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</td>\n\t</tr>\n\t</table>\n\t\n\t\t\n      \t<table width=\'150%\' class=\'grid\' border=\'1\' cellpadding=\'3\'  cellspacing=0 align=\"center\" id=\"PolicyPreApprovalPopup\">  \n      \t\t<div id=\"tableContainer\">\n      \t<thead> \n      \t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t</tr>\n\t\t\t </thead>\n\t\t\t <TBODY>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t <tr>\n\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n      \t</table>\n      \t<input type=\'hidden\' name=\'pageInfo\' id=\'pageInfo\' value=\'DiagCopayPopup\'>\n      \t<input type=\'hidden\' name=\'inclRowCount\' id=\'inclRowCount\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n      \t<input type=\'hidden\' name=\'rowNumber\' id=\'rowNumber\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n      \t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n      \t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n      \t<input type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n      \t<input type=\'hidden\' name=\'startDate\' id=\'startDate\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n      \t<input type=\'hidden\' name=\'endDate\' id=\'endDate\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n      \t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=\'hidden\' name=\'blngCode\' id=\'blngCode\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n      \t<input type=\'hidden\' name=\'payerGroup\' id=\'payerGroup\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n      \t<input type=\'hidden\' name=\'payer\' id=\'payer\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n      \t<input type=\'hidden\' name=\'policy\' id=\'policy\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n      \t<input type=\'hidden\' name=\'patClass\' id=\'patClass\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n      \t<input type=\'hidden\' name=\'encEpsd\' id=\'encEpsd\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n      \t<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n      \t<input type=\'hidden\' name=\'ageGroup\' id=\'ageGroup\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n      \t<input type=\'hidden\' name=\'clinicNursInd\' id=\'clinicNursInd\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=\'hidden\' name=\'clinicNursCode\' id=\'clinicNursCode\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'spltyCode\' id=\'spltyCode\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n      \t<input type=\'hidden\' name=\'visitId\' id=\'visitId\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n      \t<input type=\'hidden\' name=\'acctSeq\' id=\'acctSeq\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n     </form>\n     </body>\n</TBODY>\t\n\t\n\t</div>\n         ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );
	
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


     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
    private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
     

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String title = request.getParameter("title");
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String rowNumber = request.getParameter("rowNumber");
	String criteria = request.getParameter("criteria");
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	LinkedHashMap<String,String> diagTypeMap = new LinkedHashMap<String,String>();
	String siteId = "";
	String strQueryString= checkForNull(request.getParameter("queryString"));
	if(strQueryString.length()==0)	strQueryString= request.getQueryString();

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String beanId = "bl_EncounterSpecificDefinitionBean";
String beanName = "blPolicy.EncounterSpecificDefinitionBean";
String readonly = "";
EncounterSpecificDefinitionBean policyBean = null;
String prevTab = rowNumber;
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = null;
List<EncounterSpecificDefinitionBean> policyList = null; 
String checked = "";
String disabled = "";
String exclDisabled = "";
//String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payerGroup"));
String payer = checkForNull(request.getParameter("payer"));
String policy = checkForNull(request.getParameter("policy"));
String patClass = checkForNull(request.getParameter("patClass"));
String blngCode = checkForNull(request.getParameter("blngCode"));
String patientId = checkForNull(request.getParameter("patientId"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));

String visitId = checkForNull(request.getParameter("visitId"));
String acctSeq = checkForNull(request.getParameter("acctSeq"));
String priority = checkForNull(request.getParameter("priority"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));

String encEpsd = checkForNull(request.getParameter("encEpsd"));
String gender = checkForNull(request.getParameter("gender"));
String ageGroup = checkForNull(request.getParameter("ageGroup"));
String clinicNursInd = checkForNull(request.getParameter("clinicNursInd"));
String clinicNursCode = checkForNull(request.getParameter("clinicNursCode"));
String spltyCode = checkForNull(request.getParameter("spltyCode"));
String diagTypeDesc = "";
String diagTypeCode = "";
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
//Delete Definitions
EncounterSpecificDefinitionBean deletedPolicyBean = null;
HashMap<String,List<EncounterSpecificDefinitionBean>> deletedPolicyMap = null;
List<EncounterSpecificDefinitionBean> deletedPolicyList = null; 
//Delete Definitions
//Traverse
int start = 0 ;
int end = 0 ;

String from = checkForNull(request.getParameter("from"));
String to = checkForNull(request.getParameter("to"));

if ( from.length()== 0 )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to.length()==0)
  	end = 10 ;
else
	end = Integer.parseInt( to ) ;
//Traverse
try{
	con = ConnectionManager.getConnection(request);
	siteId = BLReportIdMapper.getCustomerId();
	policyBean = (EncounterSpecificDefinitionBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getDiagPopupMap();
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(rowNumber);
	}
	
	//Delete Definitions
	deletedPolicyBean = (EncounterSpecificDefinitionBean) getBeanObject("DeletedEncounterBean", beanName, request);
	deletedPolicyMap = deletedPolicyBean.getDiagPopupMap();
	if(!(deletedPolicyMap == null || deletedPolicyMap.isEmpty())){
		deletedPolicyList = deletedPolicyMap.get(rowNumber);
	}
	//Delete Definitions
		HashMap<String,List<EncounterSpecificDefinitionBean>> fmtDetailsMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
		EncounterSpecificDefinitionBean fmtDtlsBean = null;
		//Delete Definitions
		if(policyList == null || policyList.isEmpty())
		{
				if(deletedPolicyList == null || deletedPolicyList.isEmpty()){
					if(patientId == null || "".equals(patientId)){
						//String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP");
						String sqlForDiagCopay =  "SELECT DIAGNOSIS_TYPE, COPAY, to_char(DIAG_EFFECTIVE_FROM,'dd/mm/yyyy') DIAG_EFFECTIVE_FROM, to_char(DIAG_EFFECTIVE_TO,'dd/mm/yyyy') DIAG_EFFECTIVE_TO FROM bl_insu_policy_diagnosis "+
								   " WHERE OPERATING_FACILITY_ID = '"+ facility_id +"'"+
								   " AND CUST_GROUP_CODE = '"+ payerGroup +"'"+
								   " AND CUST_CODE = '"+ payer +"'"+
								   " AND POLICY_TYPE_CODE = '"+ policy +"'"+
								   " AND SERV_EXCL_INCL_CRIT = '"+ criteria +"'"+
								   " AND PATIENT_CLASS = '"+ patClass +"'"+
								   " AND SEX = '"+ gender +"'"+
								   " AND AGE_GROUP_CODE = '"+ ageGroup +"'"+
								   " AND BLNG_SERV_CODE = '"+ blngCode +"'"+
								   " AND EPISODE_OR_ENCOUNTER_FLAG = '"+ encEpsd +"'"+
								   " AND CLINIC_NURSING_IND = '" + clinicNursInd +"'"+
								   " AND CLINIC_NURSING_CODE = '" + clinicNursCode +"'"+
								   " AND SPLTY_CODE = '" + spltyCode +"'"+
								   " AND TO_CHAR (EFFECTIVE_FROM, 'dd/mm/yyyy') = '" + startDate +"'"+
								   " ORDER BY DIAG_EFFECTIVE_FROM";
			
						pstmt = con.prepareStatement(sqlForDiagCopay);
						rst = pstmt.executeQuery();
					}
					else{
						String partSql = "";
						
						if(("I".equals(episodeType)) || ("D".equals(episodeType))){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
						}
						else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
						}
						else if("R".equals(episodeType)){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
						}
						
						String sqlCoverage =  BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL_POPUP")+partSql;
			
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1,locale);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,payerGroup);
						pstmt.setString(4,payer);
						pstmt.setString(5,policy);
						pstmt.setString(6,criteria);
						pstmt.setString(7,blngCode);
						pstmt.setString(8,patClass);
						pstmt.setString(9,patientId);
						
						pstmt.setString(10,encEpsd);
						pstmt.setString(11,gender);
						pstmt.setString(12,ageGroup);
						pstmt.setString(13,clinicNursInd);
						pstmt.setString(14,clinicNursCode);
						pstmt.setString(15,spltyCode);
						pstmt.setString(16,startDate);
						
						if(("I".equals(episodeType)) || ("D".equals(episodeType))){
							pstmt.setString(17,episodeType);
							pstmt.setString(18,episodeId);
							pstmt.setString(19,acctSeq);
							pstmt.setString(20,priority);
			
						}
						else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
							pstmt.setString(17,episodeType);
							pstmt.setString(18,episodeId);
							pstmt.setString(19,visitId);
							pstmt.setString(20,acctSeq);
							pstmt.setString(21,priority);
							
						}
						else if("R".equals(episodeType)){
							
							pstmt.setString(17,episodeType);
							pstmt.setString(18,acctSeq);
							pstmt.setString(19,priority);
							
						}
						
						rst = pstmt.executeQuery();
					}
					
					
					if(rst!=null){
						policyList = new ArrayList<EncounterSpecificDefinitionBean>();
						int rsCnt = 0;
						while (rst.next()) {
							fmtDtlsBean = new EncounterSpecificDefinitionBean();
		
							fmtDtlsBean.setDiagType(rst.getString("DIAGNOSIS_TYPE"));
							fmtDtlsBean.setDiagPatCopay(rst.getString("COPAY"));
							fmtDtlsBean.setDiagStartDate(rst.getString("DIAG_EFFECTIVE_FROM"));
							fmtDtlsBean.setDiagEndDate(rst.getString("DIAG_EFFECTIVE_TO"));
							
							fmtDtlsBean.setStatus("U");
							policyList.add(fmtDtlsBean);
							rsCnt++;
						}
						
						if(rsCnt<1){
							policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
							EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
							titleBean.setStartDate(startDate);
							titleBean.setEndDate(endDate);
							policyList = new ArrayList<EncounterSpecificDefinitionBean>();
							policyList.add(titleBean);
							policyMap.put(prevTab, policyList);
						}
					}
					else{
						policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
						EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
						titleBean.setStartDate(startDate);
						titleBean.setEndDate(endDate);
						policyList = new ArrayList<EncounterSpecificDefinitionBean>();
						policyList.add(titleBean);
						policyMap.put(prevTab, policyList);
				}		
				
			}
			//Delete Definition
			else{
				policyList.add(new EncounterSpecificDefinitionBean());
			}
			//Delete Definition
		}
		
		pstmt = null;
		rst = null;
		String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		pstmt = con.prepareStatement(inclExclSql);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();

		if(rst!=null){
			while(rst.next()){
				criteriaMap.put(rst.getString("code"),rst.getString("description"));
			}	
		}
		
		String servDiagTypeSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_POP_CRITERIA");
		System.err.println(servDiagTypeSql);
		pstmt = con.prepareStatement(servDiagTypeSql);
		pstmt.setString(1,"L_SERV_DIAG_TYPE");
		pstmt.setString(2,locale);
		rst = pstmt.executeQuery();

		if(rst!=null){
			while(rst.next()){
				diagTypeMap.put(rst.getString("code"),rst.getString("description"));
				diagTypeDesc = diagTypeDesc+":::"+rst.getString("description");
				diagTypeCode = diagTypeCode+":::"+rst.getString("code");			
			}	
		}

		diagTypeDesc = diagTypeDesc.substring(3);
		diagTypeCode = diagTypeCode.substring(3);		

		
}
catch(Exception e){
	System.err.println("Exception "+e);
}
finally{
	ConnectionManager.returnConnection(con);
	pstmt = null;
	rst = null;
}

            _bw.write(_wl_block8Bytes, _wl_block8);

		if ( !(start <= 1) )
			out.println("<A HREF='javascript:movePrevthis("+start+","+end+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
			
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(policyList.size() > end)
			out.println("<A id='nextvalue' HREF='javascript:moveNextthis("+start+","+end+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				int tableIndex = 1;
			 	int tindex =0;
					for (EncounterSpecificDefinitionBean policyBean1 : policyList) {
						tindex++;	
						if(tindex < start)
						{					
							continue;
						}
						if(tindex > end)
							break;
						
						if("I".equals(policyBean1.getStatus())){
							readonly = "";
							disabled = "";
						}
						else if("U".equals(policyBean1.getStatus())){
							readonly = "readonly";
							disabled = "disabled";
						}

						if("E".equals(policyBean1.getInclExclInd())){
							exclDisabled = "disabled";
						}
						else{
							exclDisabled = "";
						}
			
            _bw.write(_wl_block14Bytes, _wl_block14);

						for (Iterator iterator = diagTypeMap.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
							if(type.equals(policyBean1.getDiagType())){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diagTypeMap.get(type) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
						}
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(policyBean1.getDiagPatCopay())));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(policyBean1.getDiagStartDate())));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkForNull(policyBean1.getDiagEndDate())));
            _bw.write(_wl_block20Bytes, _wl_block20);

			tableIndex++;	
			}	
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex -1 ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowNumber));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility_id ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(criteria ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(startDate ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(endDate ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(blngCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(payerGroup ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(payer ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(policy ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patClass ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encEpsd ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ageGroup));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(clinicNursInd));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(clinicNursCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(spltyCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(acctSeq));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strQueryString));
            _bw.write(_wl_block47Bytes, _wl_block47);
            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PatCopay.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffFromDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffToDate.label", java.lang.String .class,"key"));
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
}
