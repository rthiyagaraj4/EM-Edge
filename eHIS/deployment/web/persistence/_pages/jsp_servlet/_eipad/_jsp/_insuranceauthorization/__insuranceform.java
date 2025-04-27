package jsp_servlet._eipad._jsp._insuranceauthorization;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __insuranceform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/InsuranceAuthorization/InsuranceForm.jsp", 1738426421382L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<meta charset=\"utf-8\">\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/kendo.common.min.css\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/kendo.default.min.css\" />\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/kendo.web.min.js\"></script>\n\t \n\t<style type=\"text/css\">\n\t\tbody {\n\t\t\tmargin: 10px;\n\t\t}\n\n\t\t#somediv {\n\t\t\tposition: fixed;\n\t\t\tdisplay: none;\n\t\t\twidth: 100%;\n\t\t\theight: 100%;\n\t\t\ttop: 0;\n\t\t\tleft: 0;\n\t\t\tright: 0;\n\t\t\tbottom: 0;\n\t\t\tbackground-color: rgba(0,0,0,0.5);\n\t\t\tz-index: 2;\n\t\t\tcursor: pointer;\n\t\t}\n\t\t\n\t\t.CNButtonContainer {\nmargin-right: 10px;\ndisplay: table;\nwidth: 42px;\ncursor:pointer;\n}\n\t</style>\n\t<script type=\"text/javascript\">\n\t\t$(document).ready(function() {\n\t\t\tinit();\n\t\t\tviewImage(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\n\t\t\t$(\"#pdfIframe\").attr(\'src\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/js/pdfjs/web/viewer.html?file=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/jsp/InsuranceAuthorization/IAGetPdf.jsp\');\n\t\t});\n\t\tfunction signClick() {\n\t\t\tdocument.getElementById(\"somediv\").style.display = \"block\";\n\t\t\tvar canvas = document.getElementById(\'can\');\n\t\t\tvar ctx = canvas.getContext(\'2d\');\n\t\t\tctx.fillStyle = \'white\';\n\t\t\tctx.fillRect(0, 0, canvas.width, canvas.height);\n\t\t}\n\t\tfunction off() {\n\t\t\tdocument.getElementById(\"somediv\").style.display = \"none\";\n\t\t}\n\t</script>\n\t\n\t<script language=\"JavaScript\" src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/js/IALoginUI.js\"></script>\n</head>\n<body>\n\t<form>\n\t\t<div id=\'somediv\' style=\"display:none;\">\n\t\t\t<div>\n\t\t\t\t<canvas id=\"can\" width=\"800\" height=\"200\" class=\"center\" style=\"border: 2px solid; background-color:#ffffff;\"></canvas>\n\t\t\t\t<canvas id=\"blank\" style=\'display:none\'></canvas>\n\t\t\t</div>\n\t\t\t<div>\n\t\t\t\t<input type=\"button\" class=\"k-button\" value=\"Save\" id=\"btn\" size=\"30\" onclick=\"off();saveData(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\', \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\">\n\t\t\t\t<input type=\"button\" class=\"k-button\" value=\"Clear\" id=\"btn\" size=\"30\" onclick=\"clearSign()\">\n\t\t\t\t<input type=\"button\" class=\"k-button\" value=\"Close\" id=\"btn\" size=\"30\" onclick=\"off()\">\t\n\t\t\t</div>\n\t\t</div>\n\t\t<div style=\"display:table;width:100%;height:80%;\">\n\t\t\t<div style=\"display:table-row;width:100%;height:auto;\"  align=\"right\">\n\t\t\t  \t<div style=\"width:7%;height:auto;\" class=\"CNButtonContainer CNButtonItemTheme\">\n            \t\t<img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/sign25x25.png\" onclick=\"signClick();\"/>\n\t\t\t  \t</div>\n\t\t\t</div>\n\t\t\t<div style=\"display:table-row;width:100%;height:auto;\">\n\t\t\t\t<div style=\"display: table-cell;width:100%;height:100%;\">\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n        \t\t\t<iframe id=\"pdfIframe\" src=\"\" style=\"height:100%;width:100%\"></iframe>\n        \t\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n        \t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<input type=\"hidden\" id=\"path_value\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<script type=\"text/javascript\">\n\t\t\tvar canvas, ctx, flag = false, prevX = 0, currX = 0, prevY = 0, currY = 0, dot_flag = false;\n\t\t\tvar x = 0, y = 2;\n\t\t\tfunction init() {\n\t\t\t\tcanvas = document.getElementById(\'can\');\n\t\t\t\tctx = canvas.getContext(\"2d\");\n\t\t\t\tw = canvas.width;\n\t\t\t\th = canvas.height;\n\t\t\t\tcanvas.addEventListener(\"mousemove\", function(e) {\n\t\t\t\t\tfindxy(\'move\', e)\n\t\t\t\t}, false);\n\t\t\t\tcanvas.addEventListener(\"mousedown\", function(e) {\n\t\t\t\t\tfindxy(\'down\', e)\n\t\t\t\t}, false);\n\t\t\t\tcanvas.addEventListener(\"mouseup\", function(e) {\n\t\t\t\t\tfindxy(\'up\', e)\n\t\t\t\t}, false);\n\t\t\t\t// Set up touch events for mobile, etc\n\t\t\t\tcanvas.addEventListener(\"touchstart\", function (e) {\n\t\t\t\t\tmousePos = getTouchPos(canvas, e);\n\t\t\t\t\tvar touch = e.touches[0];\n\t\t\t\t\tvar mouseEvent = new MouseEvent(\"mousedown\", {\n\t\t\t\t\t\tclientX: touch.clientX,\n\t\t\t\t\t\tclientY: touch.clientY\n\t\t\t\t\t});\n\t\t\t\t\tcanvas.dispatchEvent(mouseEvent);\n\t\t\t\t}, false);\n\t\t\t\tcanvas.addEventListener(\"touchend\", function (e) {\n\t\t\t\t\tvar mouseEvent = new MouseEvent(\"mouseup\", {});\n\t\t\t\t\tcanvas.dispatchEvent(mouseEvent);\n\t\t\t\t}, false);\n\t\t\t\tcanvas.addEventListener(\"touchmove\", function (e) {\n\t\t\t\t\tvar touch = e.touches[0];\n\t\t\t\t\tvar mouseEvent = new MouseEvent(\"mousemove\", {\n\t\t\t\t\t\tclientX: touch.clientX,\n\t\t\t\t\t\tclientY: touch.clientY\n\t\t\t\t\t});\n\t\t\t\t\tcanvas.dispatchEvent(mouseEvent);\n\t\t\t\t}, false);\n\t\t\t}\n\n\t\t\tfunction draw() {\n\t\t\t\tctx.beginPath();\n\t\t\t\tctx.moveTo(prevX, prevY);\n\t\t\t\tctx.lineTo(currX, currY);\n\t\t\t\tctx.strokeStyle = x;\n\t\t\t\tctx.lineWidth = y;\n\t\t\t\tctx.stroke();\n\t\t\t\tctx.closePath();\n\t\t\t}\n\t\n\t\t\tfunction clearSign() {\n\t\t\t\tctx.clearRect(0, 0, w, h);\n\t\t\t\tvar canvas = document.getElementById(\'can\');\n\t\t\t\tctx.fillStyle = \'white\';\n\t\t\t\tctx.fillRect(0, 0, canvas.width, canvas.height);\n\t\t\t}\n\t\t\t\n\t\t\tfunction findxy(res, e) {\n\t\t\t\tif (res == \'down\') {\n\t\t\t\t\tprevX = currX;\n\t\t\t\t\tprevY = currY;\n\t\t\t\t\tcurrX = e.clientX - canvas.offsetLeft;\n\t\t\t\t\tcurrY = e.clientY - canvas.offsetTop;\n\t\t\t\t\tflag = true;\n\t\t\t\t\tdot_flag = true;\n\t\t\t\t\tif (dot_flag) {\n\t\t\t\t\t\tctx.beginPath();\n\t\t\t\t\t\tctx.fillStyle = x;\n\t\t\t\t\t\tctx.fillRect(currX, currY, 2, 2);\n\t\t\t\t\t\tctx.closePath();\n\t\t\t\t\t\tdot_flag = false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif (res == \'up\') {\n\t\t\t\t\tflag = false;\n\t\t\t\t}\n\t\t\t\tif (res == \'move\') {\n\t\t\t\t\tif (flag) {\n\t\t\t\t\t\tprevX = currX;\n\t\t\t\t\t\tprevY = currY;\n\t\t\t\t\t\tcurrX = e.clientX - canvas.offsetLeft;\n\t\t\t\t\t\tcurrY = e.clientY - canvas.offsetTop;\n\t\t\t\t\t\tdraw();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\n\t\t\t// Get the position of a touch relative to the canvas\n\t\t\tfunction getTouchPos(canvasDom, touchEvent) {\n\t\t\t\tvar rect = canvasDom.getBoundingClientRect();\n\t\t\t\treturn {\n\t\t\t\t\tx: touchEvent.touches[0].clientX - rect.left,\n\t\t\t\t\ty: touchEvent.touches[0].clientY - rect.top\n\t\t\t\t};\n\t\t\t}\n\t\t\t\n\t\t\tfunction viewImage(patient_id,encounter_id,p_report_id) {\n\t\t\t\txmlStr = \"<root><SEARCH \";\n\t\t\t\txmlStr += \" patient_id=\\\"\" +patient_id+ \"\\\"\";\n\t\t\t\txmlStr += \" encounter_id=\\\"\" +encounter_id+ \"\\\"\";\n\t\t\t\txmlStr += \" p_report_id=\\\"\" +p_report_id+ \"\\\"\";\n\t\t\t\txmlStr += \" /></root>\";\n\t\t\t\tvar xmlDoc;\n\t\t\t\tvar xmlHttp;\n\t\t\t\txmlHttp = new XMLHttpRequest();\n\t\t\t\tvar oParser = new DOMParser();\n\t\t\t\txmlDoc = oParser.parseFromString(xmlStr,\"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\", contextPath+\"/eIPAD/jsp/InsuranceAuthorization/IAIntermediateValidate.jsp\", false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tresponseText = xmlHttp.responseText ;\n\t\t\t\teval(responseText);\n\t\t\t}\n\t\t\t\n\t\t\tfunction testView(data){\n\t\t\t\tvar imageURL = \"data:image/jpeg;base64,\"+data;\n\t\t\t\t//document.getElementById(\"canvasimg\").src = imageURL;\n\t\t\t\t//document.getElementById(\"canvasimg\").style.display = \"inline\"; \n\t\t\t\t//document.getElementById(\"canvasimg\").src = imageURL;\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

response.setHeader("Access-Control-Allow-Origin", "*"); 
	String path = request.getContextPath();
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String locale = p.getProperty("LOCALE");
	String added_by_id			= p.getProperty("login_user");//login_by_id			
	String added_at_ws_no		= p.getProperty("client_ip_address");//login_at_ws_no
	String params = request.getQueryString();
	String[] url = params.split("url=");
	String patient_id = request.getParameter("patientid");
	String encounterid = request.getParameter("encounterid");
	String facility_id = request.getParameter("facilityid");
	String p_report_id = request.getParameter("p_report_id");
	String approval_num = request.getParameter("approval_num");
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	eCA.CAInsurenceAuthorizationFormsBean bean = (eCA.CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	ArrayList<String> formData = bean.getFormData(patient_id,encounterid,facility_id);
	System.out.println("formData: " + formData);
	String disable_flag = "disabled";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(path));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(path));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(path));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_report_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(path));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(path ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_report_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(added_by_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(added_at_ws_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(approval_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(path));
            _bw.write(_wl_block17Bytes, _wl_block17);

					String encURL = url[1].replace("+", "%2B");
				
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(path ));
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
