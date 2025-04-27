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

public final class __chartrecordinggraphframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingGraphFrame.jsp", 1738144629793L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------\n?             100            ?           created\n15/11/2011\t  IN29392\t\t Menaka V\t\tIncident No:IN29392 - <Clinical Event History>View Graph�\n\t\t\t\t\t\t\t\t\t\t\tSelect event result and then click View graph\n\t\t\t\t\t\t\t\t\t\t\t(Selected event result name contains a special character (?%?) )\n\t\t\t\t\t\t\t\t\t\t\tSystem Display error message in General graph box. >\n\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>\nfunction splitArray()\n{\n\tif(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' == \'1\')\n\t{\n\t\tdocument.getElementById(\"frmset\").rows=\'*%,0%\'\n\t\tcallGraphDisplay1(\'1\');\n\t}\n\telse if(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' == \'2\')\n\t{\n\t\tdocument.getElementById(\"frmset\").rows=\'50%,50%,0%\';\n\t\tcallGraphDisplay1(\'1\');\n\t\tcallGraphDisplay1(\'2\');\n\t}\n\telse if(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' == \'3\')\n\t{\n\t\tdocument.getElementById(\"frmset\").rows=\'33%,33%,33%,0%\';\n\t\tcallGraphDisplay1(\'1\');\n\t\tcallGraphDisplay1(\'2\');\n\t\tcallGraphDisplay1(\'3\');\n\t}\n\telse if(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' == \'4\')\n\t{\n\t\tdocument.getElementById(\"frmset\").rows=\'25%,25%,25%,25%,0%\';\n\t\tcallGraphDisplay1(\'1\');\n\t\tcallGraphDisplay1(\'2\');\n\t\tcallGraphDisplay1(\'3\');\n\t\tcallGraphDisplay1(\'4\');\n\t}\n}\n\nfunction callGraphDisplay1(val)\n{\n\tvar HTMLVal;\n\tif(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \'S\')\n\t{\n\t\tHTMLVal\t\t=\t\"<html><body onKeyDown=\'lockKey()\'><form name=\'argumentForm\' id=\'argumentForm\' \"+\n\t\t\t\t\t\t\" action=\'../../eCA/jsp/ChartRecordingSplChtLineGraph.jsp\' method=\'post\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'group\' id=\'group\' value=\'\"+val+\"\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'noOfGroups\' id=\'noOfGroups\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'numOfchkedBoxes\' id=\'numOfchkedBoxes\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'flowsheetGraph\' id=\'flowsheetGraph\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\"+\n\t\t\t\t\t\t\"</form></body></html>\";\n\t}\n\telse\n\t{\n\t\tHTMLVal\t\t=\t\"<html><body onKeyDown=\'lockKey()\'><form name=\'argumentForm\' id=\'argumentForm\' \"+\n\t\t\t\t\t\t\" action=\'../../eCA/jsp/ChartRecordingMultiAxisGraph.jsp\' method=\'post\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'group\' id=\'group\' value=\'\"+val+\"\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'noOfGroups\' id=\'noOfGroups\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\"+\n\t\t\t\t\t\t\"</form></body></html>\";\n\t}\n\n\teval(\"self.chart_frame\"+val+\".document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal)\");\n\teval(\"self.chart_frame\"+val+\".document.argumentForm.submit()\");\n}\n\n/********************ends here**********/\n</script>\n<FRAMESET id=\'frmset\' ROWS=\"*,*,*,*,*\" framespacing=0 frameborder=1 onLoad=\"splitArray();\" onUnload=\"callOnExit(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">\n\t<FRAME SRC=\"../../eCommon/html/blank.html\" NAME=\"chart_frame1\" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder=\'0\'>\n\t<FRAME SRC=\"../../eCommon/html/blank.html\" NAME=\"chart_frame2\" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder=\'0\'>\n\t<FRAME SRC=\"../../eCommon/html/blank.html\" NAME=\"chart_frame3\" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder=\'0\'>\n\t<FRAME SRC=\"../../eCommon/html/blank.html\" NAME=\"chart_frame4\" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder=\'0\'>\n\t<FRAME SRC=\"../../eCommon/html/blank.html\" NAME=\"dummy_frame\" scrolling=no  noresize marginheight=0 marginwidth=0 frameborder=\'0\'>\n</FRAMESET>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//eCA.ChartRecordingAddGroupBean chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups");	
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");	
	String encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");	
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String axis_range = request.getParameter("axis_range") == null ? "S" : request.getParameter("axis_range");
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	// IN29392 Starts
	String grpDetails = request.getParameter("grpDetails") == null ? "" : request.getParameter("grpDetails");
	grpDetails = java.net.URLDecoder.decode(grpDetails);
	String xAxisDesc = request.getParameter("xAxisDesc") == null ? "" : request.getParameter("xAxisDesc");
	xAxisDesc = java.net.URLDecoder.decode(xAxisDesc);
	String yAxisDesc = request.getParameter("yAxisDesc") == null ? "" : request.getParameter("yAxisDesc");
	yAxisDesc = java.net.URLDecoder.decode(yAxisDesc);
	// IN29392 Ends
	if(noOfGroups.equals("") || noOfGroups.equals("0"))
		noOfGroups = "1";
	else noOfGroups = noOfGroups;
	String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "1" : request.getParameter("numOfchkedBoxes");		

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(axis_range));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(numOfchkedBoxes));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(flowsheetGraph));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(numOfchkedBoxes));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(flowsheetGraph));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Graph.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
