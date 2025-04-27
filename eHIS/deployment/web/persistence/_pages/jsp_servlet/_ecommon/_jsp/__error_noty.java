package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __error_noty extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/error_noty.jsp", 1742809522478L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<head>\n    <Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n    <Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<!-- Added by Sethu for Practitioner Alert Messages -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/noty/css/jquery.noty.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/noty/css/noty_theme_default.css\"/>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<style type=\"text/css\">  \n\ta:link { color:\"red\" }\n\t#myoutercontainer { position:relative }\n\t#myinnercontainer { position:absolute; top:15%;}\n</style> \n\n<script language=\"JavaScript\">\n\nvar t;\nvar timer_is_on=false;\nvar practArryMessage = new Array();\nvar msgCount = 0;\nvar appl_user_id = \"\";\n\nfunction timedCount()\n{\n\tt=setTimeout(\"timedCount()\",5000);\n\tnotifyPract();\t\n}\n\nfunction doTimer()\n{\n\tdocument.getElementById(\"msgNumber\").innerHTML=\"\";\n\t/*\n\tif (!timer_is_on)\n\t{\n\t\ttimer_is_on=1;\n\t\ttimedCount();\n\t}\n\t*/\n\t\n}\n\nfunction notyMessageSound(){\t\n\tvar soundfile = \"../../eCommon/images/notify.wav\";\n\tdocument.getElementById(\"dummy\").innerHTML= \"<embed src=\\\"\"+soundfile+\"\\\" hidden=\\\"true\\\" autostart=\\\"true\\\" loop=\\\"false\\\" />\";\n}\n\nfunction notyCloseMessage(message_id){\t\n\t\n\tvar functionID = \"EVENT_MSG_SHOWN_YN\";\t\n\t\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\t\n\txmlStr\t=\"<root><SEARCH \" ;\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\",\"../../eCA/jsp/PractitionerAlertQuery.jsp?function_id=\"+functionID+\"&messageId=\"+message_id, false);\n\txmlHttp.send(xmlDoc);\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n\teval(responseText);\t\t\t\n\t\n}\nfunction showUserAlertDetails(applUserId){\n\tvar retVal\t\t\t=\t\"\";\n\tvar dialogTop\t\t=\t\"160\" ;\n\tvar dialogHeight\t=\t\"20\" ;\n\tvar dialogWidth\t\t=\t\"40\" ;\n\tvar status\t\t\t=\t\"no\";\n\tvar arguments\t\t=\t\"\" ;\n\tvar sql\t\t\t\t=\t\"\";\n\tvar search_code\t\t=\t\"\";\n\tvar search_desc\t\t=\t\"\";\n\tvar title\t\t\t=\t\"\";\n\tvar param\t\t\t=\t\"\";\n\tvar action_url\t\t=   \"\";\n\tvar features\t\t=\t\"\";\n\n\taction_url\t\t=\t\'../../eCA/jsp/PractitionerAlertDetails.jsp\';\n\tfeatures\t\t=\t\"dialogHeight:\" + dialogHeight +\"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status;\n\taction_url\t\t+=\t\"?userId=\"+applUserId;\n\t\n\tretVal\t\t\t\t=\twindow.showModalDialog(action_url,arguments,features);\t\n}\nfunction notifyPract(){\n\t\n\tvar alertflag = \"\";\n\tvar event_indicator = \"\";\n\tvar event_title = \"\";\t\n\tvar event_desc = \"\";\n\tvar patient_id = \"\";\n\tvar notyType = \"\";\n\tvar noty_id = \"\";\n\tvar message_id = \"\";\n\tvar layout = \"\";\n\n\tvar functionID = \"query\";\n\n\tpractArryMessage = new Array();\n\n\tmsgCount = 0;\n\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\n\tdocument.getElementById(\"msgNumber\").innerHTML=\"\";\n\t\n\txmlStr\t=\"<root><SEARCH \" ;\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\",\"../../eCA/jsp/PractitionerAlertQuery.jsp?function_id=\"+functionID+\"&messageId=\"+message_id, false);\n\txmlHttp.send(xmlDoc);\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n\teval(responseText);\t\t\n\n\tif (msgCount == \"0\")\n\t{\t\t\n\t\tdocument.getElementById(\'imgTable\').style.visibility=\"hidden\";\n\t}\n\telse\n\t{\t\t\n\t\t//document.getElementById(\'imgTable\').style.visibility=\"visible\";\n\t\tdocument.getElementById(\'imgTable\').style.visibility=\"visible\";\n\t\t//document.getElementById(\"msgNumber\").innerHTML=msgCount;\t\n\t\t//document.getElementById(\'msgNumber\').innerHTML=msgCount;\t\n\t\tdocument.getElementById(\'msgNumber\').innerHTML=\"<a href=\'javascript:showUserAlertDetails(\\\"\"+escape(appl_user_id)+\"\\\");\'>\"+msgCount+\"</a>\";\n\t}\n\t\n\t\n\t\n\n\tif((practArryMessage.length) == 0)\n\t{\n\t\tevent_indicator = \"\";\n\t\tevent_title = \"\";\t\n\t\tevent_desc = \"\";\n\t\tpatient_id = \"\";\n\t\tnotyType = \"\";\n\t}\n\telse\n\t{\t\n\t\t\n\t\tfor(var j=0;j<practArryMessage.length;j++)\n\t\t{\n\t\t\tvar pract_dtls = practArryMessage[j].split(\"~\");\n\t\t\tevent_indicator = pract_dtls[0];\n\t\t\tevent_title = pract_dtls[1];\n\t\t\tevent_desc = pract_dtls[2];\n\t\t\tpatient_id = pract_dtls[3];\t\n\t\t\tmessage_id =  pract_dtls[4];\n\n\t\t\tif (event_indicator==\"W\")\n\t\t\t\tnotyType= \"alert\";\n\t\t\tif (event_indicator==\"E\")\n\t\t\t\tnotyType= \"error\";\n\t\t\tif (event_indicator==\"I\")\n\t\t\t\tnotyType= \"success\";\n\n\t\t\tif (event_title == \"\"){\n\t\t\t\tevent_title = \"EMPTY TITLE\";\n\t\t\t}\n\n\t\t\tif (event_indicator==\"W\")\n\t\t\t\tlayout = \"topCenter\";\n\t\t\tif (event_indicator==\"E\")\n\t\t\t\tlayout = \"topCenter\";\n\t\t\tif (event_indicator==\"I\")\n\t\t\t\tlayout = \"topCenter\";\n\n\t\t\t\t\n\t\t\tnoty_id = noty({\"text\":event_title, \"layout\":layout,\"type\":notyType,\"animateOpen\":{\"height\":\"toggle\"},\"animateClose\":{\"height\":\"toggle\"},\"speed\":500,\"timeout\":5000,\"closeButton\":false,\"closeOnSelfClick\":true,\"closeOnSelfOver\":false,\"modal\":false,\"onShow\":notyMessageSound(), \"onClose\":notyCloseMessage(message_id)});\t\t\t\n\t\t}\n\t\t\n\t}\n\t\n\t\n\t\n}\n</script>\n\n</head>\n\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'  onload=\"doTimer()\">\n<p align=\"left\">\n<span id=\"dummy\" style=\"display:inline\"></span>\n<div id=\"myoutercontainer\">\n\t<div id=\"myinnercontainer\">\n\t\t<table id=\"imgTable\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"24\" height=\"24\" background=\"../../eCommon/images/Info.png\"  align=\"right\">\n\t\t\t<tr align=\"center\">\n\t\t\t\t<td> <font size=\"+1\" color=\"red\" align=\"center\"><span id=\"msgNumber\" style=\"display:inline\"></span></font></td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n</div>\n<!--\n<img name=\"image1\" id=\"image1\" src=\"../../eCommon/images/becreate.gif\" width=\"30\" height=\"16\" onClick=\"notifyPract()\" title=\"Notification\" align=\"right\">\n-->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script language=\'JavaScript\'>\n\tif(parent.commontoolbarFrame!=null){\n\t\tvar qry_stg=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tvar error=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\tvar qry_string1= qry_stg.lastIndexOf(\"&expand\");\n\t\tvar finalString;\n\t\tvar expand;\n\t\tvar url;\n\t\tvar final_name=getLabel(\"Common.menu.label\",\"Common\");\n\t\tif(parent.commontoolbarFrame.document.forms[0])\n\t\t{\n\t\t\tif(parent.commontoolbarFrame.document.forms[0].home)\n\t\t\t{\n\t\t\t\tif(parent.commontoolbarFrame.document.forms[0].home.value !=null )\n\t\t\t\t{\n\t\t\t\t\tif(parent.commontoolbarFrame.document.forms[0].home.value ==final_name )\n\t\t\t\t\t{\n\t\t\t\t\t\texpand=\"0\";\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\texpand=\"1\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\texpand=\"0\";\n\t\t}\n\t\tif(qry_string1 !=-1)\n\t\t{\n\t\t\tfinalString=qry_stg.substring(0,qry_string1);\n\t\t\turl=\"commonToolbar.jsp?qry_stg=\"+finalString+\"&expand=\"+expand;\n\t\t}\n\t\telse\n\t\t{\n\t\t\turl=\"commonToolbar.jsp?qry_stg=\"+qry_stg+\"&expand=\"+expand;\n\t\t}\n\t\tif(error==\"R\")\n\t\t{\t\n\t\t\tparent.commontoolbarFrame.location.href=url;\n\t\t\tparent.reset();\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.commontoolbarFrame.location.href=url;\n\t\t}\t\n\t}\n\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</p>\n\n</BODY>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    String button_events = "onselectstart=\"ButtonOnSelectStart()\" ondragstart=\"ButtonOnDragStart()\" onmousedown=\"ButtonOnMouseDown(this)\"  onmouseup=\"ButtonOnMouseUp(this)\" onmouseout=\"ButtonOnMouseOut(this)\" onmouseover=\"ButtonOnMouseOver(this)\" onclick=\"ButtonOnClick(this)\" ondblclick=\"ButtonOnDblClick(this)\" ";

            _bw.write(_wl_block8Bytes, _wl_block8);
                

    String error=request.getParameter( "err_num" );
    //String home_required_yn=request.getParameter("home_required_yn");
	
    if ( error != null ) {
        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
		
        if ( error == null ) error = "" ;



            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(error));
            _bw.write(_wl_block11Bytes, _wl_block11);

			
////changes ends.
		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		
        if ( error_value.equals( "1" ) )
		{
            out.println( "<script language='JavaScript'>parent.onSuccess();"+
            "document.writeln(\""+error+"\")" +
            "</script>" ) ;
		}else if(error.equals("R"))
		{
		}else
		{
                out.println( error ) ;
		}
            
/*
            if(error.indexOf("APP-SM0001") !=-1 || error.indexOf("APP-SM0002") !=-1 ||  error.indexOf("APP-SM0003") !=-1) 
                out.println("<script>alert('"+error.substring(0,error.length()-4)+"')</script>");
*/

            
    }


            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
