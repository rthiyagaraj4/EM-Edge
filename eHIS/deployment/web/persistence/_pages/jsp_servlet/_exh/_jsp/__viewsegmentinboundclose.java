package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __viewsegmentinboundclose extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewSegmentInboundClose.jsp", 1709122413084L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HEAD> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/ViewEventsOutbound.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' >\n<form name=\"application_setup_base_form\" id=\"application_setup_base_form\"  method=\"POST\" >\n<table width=\"100%\">\n<tr>\n<input type=\'hidden\' name=\'applicationName\' id=\'applicationName\' id=\'applicationName\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' >\n<input type=\'hidden\' name=\'facilityName\' id=\'facilityName\' id=\'facilityName\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n<input type=\'hidden\' name=\'applicationID\' id=\'applicationID\' id=\'applicationID\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n<input type=\'hidden\' name=\'facilityID\' id=\'facilityID\' id=\'facilityID\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=\'hidden\' name=\'msgID\' id=\'msgID\' id=\'msgID\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'srlNo\' id=\'srlNo\' id=\'srlNo\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'sub_module\' id=\'sub_module\' id=\'sub_module\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'protocolMode\' id=\'protocolMode\' id=\'protocolMode\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'protocol_link_id\' id=\'protocol_link_id\' id=\'protocol_link_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'purge_status\' id=\'purge_status\' id=\'purge_status\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'eventType\' id=\'eventType\' id=\'eventType\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'accessionNumber\' id=\'accessionNumber\' id=\'accessionNumber\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'hidden\' name=\'msgDate\' id=\'msgDate\' id=\'msgDate\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' id=\'pat_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'> \n<input type=\'hidden\' name=\'protocolMode\' id=\'protocolMode\' id=\'protocolMode\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\'  name=\'buttonInvoked\' id=\'buttonInvoked\' id=\'buttonInvoked\'>\n<input type=\"hidden\" name=\"position\" id=\"position\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' /> \n<input type=\'hidden\'  name=\'whereClause\' id=\'whereClause\' id=\'whereClause\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\n<td class=white align=\'right\'> \n<input  type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  onClick=\"processMSG(\'reload\')\"  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n<input  type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onClick=\'windowclose()\'></td></tr>  \t\n \n</table> \n<script> \nfunction unloadpage()\n{\n\tvar buttonInvoked=this.document.getElementById(\"buttonInvoked\").value;\n\t\tvar posi=parseInt(this.document.getElementById(\"position\").value);\n\n\t/*var url=\"../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?applicationID=\"+this.document.getElementById(\"applicationID\").value+\n\t\t\t\t\"&facilityID=\"+this.document.getElementById(\"facilityID\").value+\n\t\t\t\t\"&msgID=\"+this.document.getElementById(\"msgID\").value+\n\t\t\t\t\"&facilityName=\"+this.document.getElementById(\"facilityName\").value+\n\t\t\t\t\"&applicationName=\"+this.document.getElementById(\"applicationName\").value+\n\t\t\t\t\"&protocolMode=\"+this.document.getElementById(\"protocolMode\").value+\n\t\t\t\t\"&sub_module=\"+this.document.getElementById(\"sub_module\").value+\t\t\t\t\"&srlNo=&protocol_link_id=\"+this.document.getElementById(\"protocol_link_id\").value+\"&purge_status=\"+this.document.getElementById(\"purge_status\").value+\"&even_type=\"+this.document.getElementById(\"eventType\").value+\"&posi=\"+(posi)+\"&protocolMode=\"+this.document.getElementById(\"protocolMode\").value+\"&action_type=&wherecaluse=\"+document.getElementById(\"whereClause\").value; \n\t\t \n \n\nvar arguments  =new Array();\n\tvar dialogHeight = \"250\";\n\tvar dialogWidth  = \"250\";\n\tvar dialogTop    = \"230\";\n\tvar dialogLeft   = \"230\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no;help:no\" ;\n\t\n\twindow.showModalDialog(url,arguments,features); */\n\t\t//parent.frames[1].document.location.href=\'../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?\'+url;\n\t\t//parent.parent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?\'+url;\n}\n function windowclose()\n{\n\nif(this.document.getElementById(\"protocolMode\").value==\'O\')\n{\n\t//refreshResults(\'ViewEventsOutboundDtlTest1\');\n\t//parent.window.close();\n}\nelse if(this.document.getElementById(\"protocolMode\").value==\'I\')\n{\n//refreshResults(\'ViewEventsInboundDtlTest1\');\n}\n  \nparent.window.close(); \n}\n\nfunction processMSG(buttonInvoked)\n{\n\t\t\t\tvar url=\'&accessionNumber=\'+this.document.getElementById(\"accessionNumber\").value+\n\t\t\t\t\'&applicationId=\'+this.document.getElementById(\"applicationID\").value+\n\t\t\t\t\'&facilityId=\'+this.document.getElementById(\"facilityID\").value+\n\t\t\t\t\'&messageId=\'+this.document.getElementById(\"msgID\").value+\n\t\t\t\t\'&eventType=\'+this.document.getElementById(\"eventType\").value+\n\t\t\t\t\'&purge_status=\'+this.document.getElementById(\"purge_status\").value+\n\t\t\t\t\'&sub_module=\'+this.document.getElementById(\"sub_module\").value+\n\t\t\t\t\'&protocol_link_id=\'+this.document.getElementById(\"protocol_link_id\").value+\'&protocolMode=\'+this.document.getElementById(\"protocolMode\").value+\n\t\t\t\t\'&mode=Q\'+\n\t\t\t\t\'&msgDate=\'+this.document.getElementById(\"msgDate\").value+ \n\t\t\t\t\'&pat_id=\'+this.document.getElementById(\"pat_id\").value+\n\t\t\t\t\'&episode_id=\'+this.document.getElementById(\"episode_id\").value+\n\t\t\t\t\'&episode_type=\'+this.document.getElementById(\"episode_type\").value+\'&srlNo=\'+this.document.forms[0].srlNo.value+\t\'&visit_id=\'+this.document.getElementById(\"visit_id\").value+\'&buttonInvoked=\'+buttonInvoked+\'&functionType=Review\';\n        \n//this.document.getElementById(\"buttonInvoked\").value=buttonInvoked;\n/* var url=\'&accessionNumber=\'+this.document.getElementById(\"accessionNumber\").value+\n\t\t\t\t\'&applicationId=\'+this.document.getElementById(\"applicationID\").value+\n\t\t\t\t\'&facilityId=\'+this.document.getElementById(\"facilityID\").value+\n\t\t\t\t\'&messageId=\'+this.document.getElementById(\"msgID\").value+\n\t\t\t\t\'&eventType=\'+this.document.getElementById(\"eventType\").value+\n\t\t\t\t\'&purge_status=\'+this.document.getElementById(\"purge_status\").value+\n\t\t\t\t\'&sub_module=\'+this.document.getElementById(\"sub_module\").value+\n\t\t\t\t\'&protocol_link_id=\'+this.document.getElementById(\"protocol_link_id\").value+\'&protocolMode=\'+this.document.getElementById(\"protocolMode\").value+\n\t\t\t\t\'&mode=Q\'+\n\t\t\t\t\'&msgDate=\'+this.document.getElementById(\"msgDate\").value+ \n\t\t\t\t\'&pat_id=\'+this.document.getElementById(\"pat_id\").value+\n\t\t\t\t\'&episode_id=\'+this.document.getElementById(\"episode_id\").value+\n\t\t\t\t\'&episode_type=\'+this.document.getElementById(\"episode_type\").value+\n\t\t\t\t\'&visit_id=\'+this.document.getElementById(\"visit_id\").value+\'&buttonInvoked=\'+buttonInvoked+\'&commMode=Review\';*/\n \t\t\t\t//alert(parent.parent.frames[0].name); \n\t\t\t\t\n\tdocument.forms[0].action=\'../../servlet/eXH.XHViewEventsOutboundServlet?\'+url;\n\tdocument.forms[0].target=\'f_query_reviw_mod\';   \n\tdocument.forms[0].submit();  \n//parent.window.close();\n//unloadpage();\n} \nfunction process(buttonInvoked) \n{\n\n\tvar url=\'&accessionNumber=\'+this.document.getElementById(\"accessionNumber\").value+\n\t\t\t\t\'&applicationId=\'+this.document.getElementById(\"applicationID\").value+\n\t\t\t\t\'&facilityId=\'+this.document.getElementById(\"facilityID\").value+\n\t\t\t\t\'&messageId=\'+this.document.getElementById(\"msgID\").value+\n\t\t\t\t\'&eventType=\'+this.document.getElementById(\"eventType\").value+\n\t\t\t\t\'&purge_status=\'+this.document.getElementById(\"purge_status\").value+\n\t\t\t\t\'&sub_module=\'+this.document.getElementById(\"sub_module\").value+\n\t\t\t\t\'&protocol_link_id=\'+this.document.getElementById(\"protocol_link_id\").value+\'&protocolMode=\'+this.document.getElementById(\"protocolMode\").value+\n\t\t\t\t\'&mode=Q\'+\n\t\t\t\t\'&msgDate=\'+this.document.getElementById(\"msgDate\").value+ \n\t\t\t\t\'&pat_id=\'+this.document.getElementById(\"pat_id\").value+\n\t\t\t\t\'&episode_id=\'+this.document.getElementById(\"episode_id\").value+\n\t\t\t\t\'&episode_type=\'+this.document.getElementById(\"episode_type\").value+\'&srlNo=\'+this.document.forms[0].srlNo.value+\t\'&visit_id=\'+this.document.getElementById(\"visit_id\").value+\'&buttonInvoked=\'+buttonInvoked+\'&commMode=Review\';\n\tthis.document.forms[0].action=\'../../servlet/eXH.XHViewEventsOutboundServlet?\'+url;\n\tthis.document.forms[0].target=\'f_query_reviw_mod\';   \n\tthis.document.forms[0].submit();  \n\t\n\t\n\t/*var url=\'&accessionNumber=\'+this.document.forms[0].accessionNumber.value+\n\t\t\t\t\'&applicationId=\'+this.document.forms[0].applicationID.value+\n\t\t\t\t\'&facilityId=\'+this.document.forms[0].facilityID.value+\n\t\t\t\t\'&messageId=\'+this.document.forms[0].msgID.value+\n\t\t\t\t\'&eventType=\'+this.document.forms[0].eventType.value+\n\t\t\t\t\'&purge_status=\'+this.document.forms[0].purge_status.value+\n\t\t\t\t\'&sub_module=\'+this.document.forms[0].sub_module.value+\n\t\t\t\t\'&protocol_link_id=\'+this.document.forms[0].protocol_link_id.value+\n\t\t\t\t\'&mode=Q\'+\n\t\t\t\t\'&srlNo=\'+this.document.forms[0].srlNo.value+\n\t\t\t\t\'&buttonInvoked=\'+buttonInvoked+\'&commMode=Review\';*/\n\n/*\tthis.document.forms[0].action=\'../../servlet/eXH.XHViewEventsOutboundServlet?\'+url;\n\tthis.document.forms[0].target=\'f_query_reviw_mod\'; \n\tthis.document.forms[0].submit();  */\n}\n</script>\n</form> \n</body>\n</html>\n   \n\n\n\n\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle	="IeStyle.css";
     
				   																   

 String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo")); 
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode")); 
String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
String eventType = request.getParameter("even_type");
String accessionNumber= XHDBAdapter.checkNull(request.getParameter("accessionNumber")); 
String msgDate= XHDBAdapter.checkNull(request.getParameter("msgDate")); 
String pat_id= XHDBAdapter.checkNull(request.getParameter("pat_id"));
String episode_type= XHDBAdapter.checkNull(request.getParameter("episode_type"));
String episode_id= XHDBAdapter.checkNull(request.getParameter("episode_id"));
String visit_id= XHDBAdapter.checkNull(request.getParameter("visit_id"));
String facilityName=XHDBAdapter.checkNull(request.getParameter("facilityName"));
String applicationName=XHDBAdapter.checkNull(request.getParameter("applicationName"));
 String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause")); 
 String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
String reloadop=XHDBAdapter.checkNull(request.getParameter("ReloadOP"));


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(applicationName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(applicationID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(msgID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(srlNo ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sub_module ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(protocolMode ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(protocol_link_id ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(purge_status ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(eventType ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(accessionNumber));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(msgDate ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_id ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(episode_id ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(protocolMode ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(posi));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(whereClause));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(reloadop.equals("true")?"":"disabled"));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Reload.Label", java.lang.String .class,"key"));
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
