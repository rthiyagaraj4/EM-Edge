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

public final class __clinicaleventhistoryresultevents extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventHistoryResultEvents.jsp", 1709115746980L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n<TITLE> New Document </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<style>\n</style>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventHistoryNew.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction onLinePrinting(event_grp,fdate){\n\tvar queryStr    = document.forms[0].queryString.value\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n   \txmlHttp.open(\"POST\", \"../../eCA/jsp/NewCEHIntermediate.jsp?\"+queryStr+\"&group=\"+event_grp+\"&fdate=\"+fdate+\"&Mode=printResult\", true);\n   \txmlHttp.send(xmlDoc);\n\talert(getMessage(\'RPT_SUBMIT_TO_PRINTER\',\'OR\'));\n}\nfunction onLinePrintingEvent(event_class){\n\tvar queryStr    = document.forms[0].queryString.value\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n   \txmlHttp.open(\"POST\", \"../../eCA/jsp/NewCEHIntermediate.jsp?\"+queryStr+\"&event_cls=\"+event_class+\"&Mode=printEvent\", true);\n   \txmlHttp.send(xmlDoc);\n\talert(getMessage(\'RPT_SUBMIT_TO_PRINTER\',\'OR\'));\n}\n\n\n</script>\n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<BODY   class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\'eventForm\' id=\'eventForm\'>\n\n\t\t<div id=\'divUnitTitle\' style=\'postion:relative\'>\n\t\t\t<table  width=\'100%\' id=\'unitTitleTable\' class=\'grid\' border=\"1\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\' >\n\t\t\t\t<TR><td class=\'gridHeader\' colspan=\'3\'>Event</td></TR>\t\t\t\t\n\t\t\t</TABLE>\n\t\t</div>\n\t\t<table width=\'100%\' id=\'unitTable\' class=\'grid\' border=\"1\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<TR id=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t<TD colspan=\'2\' class=\'CAFLOWSHEETLEVEL1\' width=\'100%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;<img  src=\'../../eCA/images/Print.png\' onclick=\"onLinePrintingEvent(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" alt=\'Print Event\'></img></TD>\n\t\t\t</TR>\n\t\t\t<TR id=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t<!-- <TD colspan=\'2\' class=\'CAFLOWSHEETLEVEL3\' width=\'100%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;&nbsp;<img  src=\'../../eCA/images/Print.png\' onclick=\"onLinePrinting(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\" alt=\'Print Result\'></img></TD> -->\n\t\t\t\t<TD colspan=\'2\' class=\'CAFLOWSHEETLEVEL3\' width=\'100%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\" alt=\'Print Result\'></img></TD><!-- IN070032 -->\n\t\t\t</TR>\n\t\t\t<TR id=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<TD class=\'gridDataChart\' width=\'100%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TD>\n\t\t\t\t<TD  class=\'gridDataChart\' width=\'100%\' align=center><input type=\'checkbox\'  id=\'chkGraphID";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' name=\'chkGraph\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onClick=\'constructValsForGraph(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =");\'></input><input type=\'hidden\' name=\'UOM";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'UOM";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><input type=\'hidden\' name=\'desc";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'desc";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'></TD>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<TD colspan=\'2\' class=\'gridDataChart\' width=\'100%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</TD>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<TR id=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<TD class=\'gridDataChart\' width=\'100%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</TD>\n\t\t\t\t\t\t<TD  class=\'gridDataChart\' width=\'100%\' align=center><input type=\'checkbox\'  id=\'chkGraphID";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'></TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<TD colspan=\'2\' class=\'gridDataChart\' width=\'100%\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t<!-- <TD colspan=\'2\' class=\'CAFLOWSHEETLEVEL3\' width=\'100%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\" alt=\'Print Result\'></img></TD> -->\n\t\t\t\t\t\t<TD colspan=\'2\' class=\'CAFLOWSHEETLEVEL3\' width=\'100%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\" alt=\'Print Result\'></img></TD><!-- IN070032 -->\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR id=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t\t\t<TD colspan=\'2\' class=\'CAFLOWSHEETLEVEL1\' width=\'100%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\" alt=\'Print Event\'></img></TD>\n\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;&nbsp;<img align=\'right\' src=\'../../eCA/images/Print.png\' onclick=\"onLinePrinting(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\n\t\t\t<!-- Don\'t delete below TR.-->\n\t\t\t<TR id=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t<TD class=\'QRYEVENNOBORDER\' colspan=\"2\">&nbsp;</TD>\n\t\t\t</TR>\t\t\t\n\t\t</Table>\t\n<input type=hidden name=\"noOfChkdBoxes\" id=\"noOfChkdBoxes\" value=\'0\'>\n<input type=hidden name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=hidden name=\"encounter_id\" id=\"encounter_id\" value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=hidden name=\'rowsForGraph\' id=\'rowsForGraph\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=hidden name=\'totRows\' id=\'totRows\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=hidden name=\'fromDate\' id=\'fromDate\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<input type=hidden name=\'toDate\' id=\'toDate\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" name=\"queryString\" />\n</form>\t\t\n\t</BODY>\n\t<div id=\'extraTD\' style=\'position:absolute; height:5%; width:30%; visibility:hidden;\'></div>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
---------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	ArrayList eventsTreeArr = new ArrayList() ;
	String bean_id					= "NewClinicalEventHistBean" ;
	String bean_name				= "eCA.NewClinicalEventHistBean";
	String patient_id				= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String orderCatalogNature				=  request.getParameter("orderCatalogNature")==null?"":request.getParameter("orderCatalogNature");
	String selTab				=  request.getParameter("selTab")==null?"":request.getParameter("selTab");
	//IN069243 starts
	String strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String abnormal				=  request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
	String eventCls				=  request.getParameter("eventCls")==null?"":request.getParameter("eventCls");
	String eventGrp				=  request.getParameter("eventGrp")==null?"":request.getParameter("eventGrp");
	String eventItem				=  request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String patient_class = request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	String facilityid = (String)session.getValue("facility_id");
	//IN069243 ends

	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String fromDate="",toDate="";
	String fac_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	fromDate = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	toDate = request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	
	if (toDate.equals(""))
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	
	String grphistory_type			= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");//IN069654
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 

	eCA.ChartRecordingAddGroupBean chartingBean = null; 
	chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+strEncId,"eCA.ChartRecordingAddGroupBean",session);
	chartingBean.clearBean();
	try{
		con = ConnectionManager.getConnection(request);	

		eventsTreeArr = bean.getEventTree(con,locale,grphistory_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,orderCatalogNature,selTab,fac_id,abnormal,eventCls,eventGrp,eventItem,reln_id,patient_class,facilityid); //IN069654


            _bw.write(_wl_block9Bytes, _wl_block9);
	String tempEventGroup = "";
			String tempEventClass  = "";
			String tempEventCode  = "";
			String fdate="";    //IN070032
			int count=0;
			for(int i=0;i<eventsTreeArr.size();i++){
			String[] event_list  = (String[])eventsTreeArr.get(i);
			if(tempEventClass.equals("") && tempEventGroup.equals("") && tempEventCode.equals("")){
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(event_list[4]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(event_list[5]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(event_list[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(event_list[0]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(event_list[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(event_list[0]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fdate ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(event_list[6].equals("NUM"))
			{
			
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_list[2]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[7]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

			}else{

				if(event_list[5].equals(tempEventClass)){
					if(event_list[0].equals(tempEventGroup)){
						if(!event_list[2].equals(tempEventCode)){
		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(event_list[6].equals("NUM"))
					{
					
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_list[2]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[7]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
				}
					}else{
		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(event_list[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(event_list[0]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(event_list[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(event_list[0]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fdate ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(event_list[6].equals("NUM"))
					{
					
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_list[2]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[7]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);

					}

				
				}else{

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(event_list[4]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(event_list[5]));
            _bw.write(_wl_block45Bytes, _wl_block45);
					if(event_list[0].equals(tempEventGroup)){
						if(!event_list[2].equals(tempEventCode)){
		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(event_list[6].equals("NUM"))
					{
					
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_list[2]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[7]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
				}	
					}else{
		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(event_list[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(event_list[0]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(event_list[1]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(event_list[0]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fdate ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(event_list[6].equals("NUM"))
					{
					
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_list[2]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[7]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(event_list[3]));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);

					}

				}

			}
			tempEventGroup=event_list[0];
			tempEventClass=event_list[5];
			tempEventCode=event_list[2];
			
			}
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(count));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block55Bytes, _wl_block55);
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block56Bytes, _wl_block56);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
