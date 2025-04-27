package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.GatewayServiceBO;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import com.ehis.util.*;

public final class __gatewayinterfaceheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/GatewayInterfaceHeader.jsp", 1733051341767L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\'\n\ttype=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/Gatewayinterface.css\'\n\ttype=\'text/css\'></link>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<script type=\"text/javascript\" language=\"JAVASCRIPT\"\n\tsrc=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eCommon/js/jquery-3.6.3.js\"></script>\n<script type=\"text/javascript\" language=\"JAVASCRIPT\"\n\tsrc=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eXH/js/GatewayInterfaceMonitor.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\n<script type=\"text/javascript\">\n\nfunction setComMode()\n{\n\tdocument.getElementById(\"selectedcommunimode\").value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tdocument.getElementById(\"communicmode\").value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\tdocument.getElementById(\"serverclientid\").value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\tdocument.getElementById(\"application\").value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\n\tvar formName = document.\n\t    getElementById(\"gatewayserverform\");\n\t\tformName.target = \'gatewaytableframe\';\n\t\tdocument.getElementById(\"frame\").value = \'body\';\n\t\tdocument.forms[0].action = \'../servlet/eXH.CentralizedServlet\';\n\t\tdocument.forms[0].submit();\n\t}\n\n\tfunction startBound() {\n\t\tdocument.getElementById(\"communicmode\").value=document.getElementById(\"selectedcommunimode\").value;\n\t\tparent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = \'start\';\n\t\tparent.gatewaytableframe.document.gatewayserverTableform.submit();\n\n\t}\n\n\tfunction stopBound() {\n\t\tdocument.getElementById(\"communicmode\").value=document.getElementById(\"selectedcommunimode\").value;\n\t\tparent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = \'stop\';\n\t\tparent.gatewaytableframe.document.gatewayserverTableform.submit();\n\t}\n\t\n\tfunction refresh() {\n\t\tdocument.getElementById(\"communicmode\").value=document.getElementById(\"selectedcommunimode\").value;\n\t\tdocument.gatewayserverform.gatewayoperation.value=\'refresh\';\n\t\tdocument.gatewayserverform.submit();\n\t}\n\n\tfunction hotStateImage(obj) {\n\t\tobj.className = \'linkClass2\';\n\t}\n\n\tfunction restorePrevState(obj) {\n\t\tobj.className = \'linkClass1\';\n\n\t}\n\t\n\t\n\tfunction validateCheckboxHeader(opern) {\n\t\talert(\'validatecheckbox\');\n\t\tvar validateString = \"\";\n\t\tif (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length != undefined) {\n\t\t\tfor ( var a = 0; a < parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length; a++) {\n\t\t\t\tif (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers[a].checked == true) {\n\t\t\t\t\tvalidateString = \"checked\";\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (validateString == \"checked\" && opern == \"start\") {\n\t\t\t\tdocument.getElementById(\"communicmode\").value = document\n\t\t\t\t\t\t.getElementById(\"selectedcommunimode\").value;\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = \'start\';\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform\n\t\t\t\t\t\t.submit();\n\t\t\t} else if (validateString == \"checked\" && opern == \"stop\") {\n\t\t\t\tdocument.getElementById(\"communicmode\").value = document\n\t\t\t\t\t\t.getElementById(\"selectedcommunimode\").value;\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = \'stop\';\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform\n\t\t\t\t\t\t.submit();\n\t\t\t} else {\n\t\t\t\talert(\"Please select any gateway server\");\n\t\t\t\treturn;\n\t\t\t}\n\t\t} else if (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length == undefined\n\t\t\t\t&& parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.checked == true) {\n\t\t\tif (opern == \"start\") {\n\t\t\t\tdocument.getElementById(\"communicmode\").value = document\n\t\t\t\t\t\t.getElementById(\"selectedcommunimode\").value;\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = \'start\';\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform\n\t\t\t\t\t\t.submit();\n\t\t\t} else if (opern == \"stop\") {\n\t\t\t\tdocument.getElementById(\"communicmode\").value = document\n\t\t\t\t\t\t.getElementById(\"selectedcommunimode\").value;\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = \'stop\';\n\t\t\t\tparent.gatewaytableframe.document.gatewayserverTableform\n\t\t\t\t\t\t.submit();\n\n\t\t\t}\n\t\t} else if (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length == undefined) {\n\t\t\talert(\"Please select any gateway server\");\n\t\t\treturn;\n\t\t}\n\t}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n<style>\n.COLUMNHEADER {\n\tBACKGROUND-COLOR: #404040;\n\tCOLOR: white;\n\tFONT-SIZE: 8pt;\n\tfont-weight: bolder;\n}\n\nTD.CAGROUP {\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8pt;\n\tBACKGROUND-COLOR: #83AAB4; /*----- Changed from #FFFFFFF -------*/\n\tCOLOR: BLACK;\n\tFONT-WEIGHT: BOLDER\n}\n\n.CAGROUP {\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8pt;\n\tBACKGROUND-COLOR: #D5E2E5;\n\tCOLOR: BLACK;\n\tFONT-WEIGHT: BOLDER\n}\n\n.linkClass1 {\n\tmargin-left: 0;\n\tmargin-right: 0;\n\tmargin-top: 0;\n\tmargin-bottom: 0;\n\tpadding-left: 3px;\n\tpadding-right: 3px;\n\tpadding-top: 2px;\n\tpadding-bottom: 1px;\n\tborder-top: 0px;\n}\n\nTD.BUTTON {\n\tFONT-SIZE: 8pt;\n\tFONT-FAMILY: verdana;\n\tTEXT-ALIGN: RIGHT;\n}\n\nINPUT.BUTTON {\n\theight: 20px;\n\tfont-family: verdana;\n\tCOLOR: #000000;\n\tFONT-SIZE: 8pt;\n}\n\nTD.LABEL {\n\tCOLOR: #444444;\n\t/*background-color:#FFFFFF;*/\n\tbackground-color: #FFFFFF;\n\tFONT-SIZE: 9pt;\n\tTEXT-ALIGN: LEFT;\n\t/*TEXT-ALIGN: RIGHT;*/\n\tPADDING-LEFT: 7px;\n\tPADDING-RIGHT: 7px\n}\n\n.label {\n\tCOLOR: #444444;\n\t/*background-color:#FFFFFF;*/\n\tbackground-color: #FFFFFF;\n\tFONT-SIZE: 9pt;\n\tTEXT-ALIGN: LEFT;\n\t/*TEXT-ALIGN: RIGHT;*/\n\tPADDING-LEFT: 7px;\n\tPADDING-RIGHT: 7px\n}\n\n.FIELDS { /*background-color:#FFFFFF;*/\n\tbackground-color: #FFFFFF;\n\tCOLOR: #000000;\n\tFONT-SIZE: 8pt;\n\tTEXT-ALIGN: LEFT\n}\n\n.linkClass2 {\n\tbackground-color: #FFFFFF;\n\tmargin-left: 0;\n\tmargin-right: 0;\n\tmargin-top: 0;\n\tmargin-bottom: 0;\n\tpadding-left: 2px;\n\tpadding-right: 2px;\n\tpadding-top: 2px;\n\tpadding-bottom: 1px;\n\tborder-left: 1px solid;\n\tborder-right: 1px solid;\n\tBORDER-COLOR: #75768B;\n}\n</style>\n</head>\n\n<BODY onload=\"setComMode();\" style=\"margin-top: 0px; padding-top: 0px;\">\n\t<form name=\"gatewayserverform\" id=\"gatewayserverform\" method=\"get\">\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<table cellspacing=0 cellpadding=1 border=0\n\t\t\tstyle=\"width: 100%; display: ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";\">\n\t\t\t<tr style=\"height: 10pt;\">\n\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" <select id=\"serverclientid\"\n\t\t\t\t\tclass=\'fields\' name=\"serverclientid\" id=\"serverclientid\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t<option style=\"font-size: 8pt;\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</select> ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" <select id=\"selectedcommunimode\" name=\"selectedcommunimode\" id=\"selectedcommunimode\" class=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" <select name=\"application\" id=\"application\"\n\t\t\t\t\tclass=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</select></td>\n\t\t\t</tr>\n\n\t\t\t<input type=\"hidden\" name=\"gatewayoperation\" id=\"gatewayoperation\">\n\t\t\t<input type=\"hidden\" value=\"header\" name=\"frame\" id=\"frame\">\n\n\t\t</table>\n\n\n\t\t<input type=\"hidden\" name=\"isQueryOnlyForTable\" id=\"isQueryOnlyForTable\"\n\t\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\n\t\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=1 width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<TD align=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" class=\"CAGROUP\"><input class=\"CAGROUP\"\n\t\t\t\t\tid=\"communicmode\" type=\"text\" name=\"communicmode\" id=\"communicmode\"\n\t\t\t\t\tstyle=\"color: black; text-align: center;\" readonly=\"readonly\">\n\t\t\t\t</TD>\n\t\t\t\t<td class=\'CAGROUP\' align=\"right\" style=\"display: ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =";\">\n\t\t\t\t\t<input class=\'BUTTON\' type=\"button\" TITLE=\"Refresh\" value=\'Refresh\'\n\t\t\t\t\tonClick=\"refresh();\"> <input class=\'BUTTON\' type=\"button\"\n\t\t\t\t\tTITLE=\"Start\" value=\'Start\'\n\t\t\t\t\tonClick=\"validateCheckboxHeader(\'start\');\"> <input\n\t\t\t\t\tclass=\'BUTTON\' type=\"button\" TITLE=\"Stop\" value=\'Stop\'\n\t\t\t\t\tonClick=\"validateCheckboxHeader(\'stop\');\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t</form>\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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

	request.setCharacterEncoding("UTF-8");
	String locale = ((String) session.getAttribute("LOCALE"));
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	System.out.println("sstyle g value....." + sStyle);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Map<String, String> clientMap = null;
	Map<String, String> applicationMap = null;
	Map<String, String> facililtyMap = null;
	Map<Integer, String> paramMap = null;
	String communicationArray[] = new String[2];
	String selectedCommunimode = null;

	String clientID = null;
	String applicationID = null;
	String facilityID = null;
	clientID = (String) request.getAttribute("serverclientid");
	applicationID = (String) request.getAttribute("application");
	facilityID = (String) request.getAttribute("facility");

	communicationArray[0] = "Outbound";
	communicationArray[1] = "Inbound";

	applicationMap = (Map<String, String>) request
			.getAttribute("applicationmap");
	clientMap = (Map<String, String>) request.getAttribute("clientmap");
	facililtyMap = (Map<String, String>) request
			.getAttribute("facilitymap");
	selectedCommunimode = (String) request.getAttribute("comType");
	
	
	if(selectedCommunimode==null || selectedCommunimode=="")
	{
		selectedCommunimode="All";
	}
	
	pageContext.setAttribute("clientID", clientID);
	pageContext.setAttribute("applicationID", applicationID);
	pageContext.setAttribute("facilityID", facilityID);
	pageContext.setAttribute("selectedCommunimode", selectedCommunimode);
	pageContext.setAttribute("clientMap", clientMap);
	pageContext.setAttribute("applicationMap", applicationMap);
	pageContext.setAttribute("communicationArray", communicationArray);

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selectedCommunimode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(selectedCommunimode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clientID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(applicationID));
            _bw.write(_wl_block13Bytes, _wl_block13);

	String chkDisp="block";
	String align="right";
	String isQueryOnly=(String)request.getAttribute("isQueryOnly");
	
	String queryDisplayParam="frame=header&isQueryOnly=true&clientID=CSCINDAE696239&processType=outbound";
    paramMap=(Map<Integer, String>)request.getAttribute("paramMap");
	request.getSession().setAttribute("paramMap", paramMap);
	
	if(isQueryOnly!=null && isQueryOnly=="true" )
	{
		chkDisp="none";
		align="center";
		
	}
	else
	{
		chkDisp="block";
		align="right";
	}
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(chkDisp));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isQueryOnly));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(align));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(chkDisp));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Gateway.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag1 = null ;
        int __result__tag1 = 0 ;
        boolean _skipPage__tag1= false;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("gatewayclient", java.lang.String .class,"var"));
        __tag1.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${clientMap}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag1;
            __result__tag1 = __tag1.doStartTag();

            if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${gatewayclient.key}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);

                    if (_jsp__tag2(request, response, pageContext, _activeTag, __tag1))
                     return true;
                    _bw.write(_wl_block19Bytes, _wl_block19);
                } while (__tag1.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag1 = true;
                return true;
            }
            _activeTag=__tag1.getParent();
            _skipPage__tag1 = false;
        } catch (java.lang.Throwable __t){
            __tag1.doCatch(__t);
        } finally {
            __tag1.doFinally();
            if (!_skipPage__tag1){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
                __tag1.release();
            }else{
                _releaseTags(pageContext, __tag1);
            }
        }
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.OutTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.OutTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(parent);
        __tag2.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${gatewayclient.value}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.CommMode.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag4 = null ;
        int __result__tag4 = 0 ;
        boolean _skipPage__tag4= false;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("communicationmode", java.lang.String .class,"var"));
        __tag4.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${communicationArray}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag4;
            __result__tag4 = __tag4.doStartTag();

            if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${communicationmode}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);

                    if (_jsp__tag5(request, response, pageContext, _activeTag, __tag4))
                     return true;
                    _bw.write(_wl_block19Bytes, _wl_block19);
                } while (__tag4.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag4 = true;
                return true;
            }
            _activeTag=__tag4.getParent();
            _skipPage__tag4 = false;
        } catch (java.lang.Throwable __t){
            __tag4.doCatch(__t);
        } finally {
            __tag4.doFinally();
            if (!_skipPage__tag4){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
                __tag4.release();
            }else{
                _releaseTags(pageContext, __tag4);
            }
        }
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.OutTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.core.OutTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(parent);
        __tag5.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${communicationmode}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag7 = null ;
        int __result__tag7 = 0 ;
        boolean _skipPage__tag7= false;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("appitems", java.lang.String .class,"var"));
        __tag7.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${applicationMap}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag7;
            __result__tag7 = __tag7.doStartTag();

            if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${appitems.key}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);

                    if (_jsp__tag8(request, response, pageContext, _activeTag, __tag7))
                     return true;
                    _bw.write(_wl_block19Bytes, _wl_block19);
                } while (__tag7.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag7 = true;
                return true;
            }
            _activeTag=__tag7.getParent();
            _skipPage__tag7 = false;
        } catch (java.lang.Throwable __t){
            __tag7.doCatch(__t);
        } finally {
            __tag7.doFinally();
            if (!_skipPage__tag7){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
                __tag7.release();
            }else{
                _releaseTags(pageContext, __tag7);
            }
        }
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.OutTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.core.OutTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(parent);
        __tag8.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${appitems.value}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
