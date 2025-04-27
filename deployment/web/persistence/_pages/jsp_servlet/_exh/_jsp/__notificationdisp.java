package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __notificationdisp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/NotificationDisp.jsp", 1733051592496L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<SCRIPT>\nvar contextPath = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</SCRIPT>\n\n<HTML>\n<HEAD>\n<TITLE>$(param.title)</TITLE>\n<link rel=\'StyleSheet\' href=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eCommon/html/Tabs.css\'></link>\n<link rel=\'stylesheet\' href=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eXH/html/menu.css\' type=\'text/css\'></link>\n<!-- these style setting are used for table scroll -->\n<style>\n\tdiv {float: left}\n\t.testSty\n\t{\n\t\twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n</style>\n\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eCommon/js/CommonCalendar.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eXH/js/InterfaceUtil.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eCommon/js/Common.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eXH/js/NotificationDisp.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eCommon/js/ValidateControl.js\"></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eCommon/js/jquery-3.6.3.js\'></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eXH/js/Validate.js\'></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<BODY LEFTMARGIN=\"0\" TOPMARGIN=\"0\" onMouseDown=\"CodeArrest()\" onKeyDown=\'submitFormOnEnter()\' onLoad=\"initNotificationDisp(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">\n<FORM ID=\"notificationDisp\" name=\"notificationDisp\" id=\"notificationDisp\" METHOD=\"post\" ACTION=\'./DisplayNotificationServlet\'>\n\n<TABLE ID=\"indicatorTable\" CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"0\" WIDTH=\"100%\">\n<TR>\n\t<TD ALIGN=\"left\" CLASS=\"CAGROUP\" COLSPAN=\"1\">\n\t\t<A CLASS=\'label\' STYLE=\'cursor:pointer\' accesskey=\"E\" onClick=\"editCriteria()\">Edit Criteria</A>\n\t</TD>\n\t<TD CLASS=\'CAGROUP\' ALIGH=\"right\" COLSPAN=\"9\"><FONT CLASS=\'label\'>Total Records - ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</FONT></TD>\n\t<TD ALIGN=\"right\" CLASS=\"CAGROUP\" COLSPAN=\"3\"> \n\t\t<A CLASS=\'label\' STYLE=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</A>\n\t\t<A CLASS=\'label\' onClick=\"funAction(\'N\')\" STYLE=\'cursor:pointer\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</A>\n\t</TD>\n</TR>\n</TABLE>\n<div id=\"left_child\" style=\"display:none;\">\n<table id=\"table1\" cellspacing=0 cellpadding=3 border=1>\n<TR>\n\t<TD CLASS=\'COLUMNHEADER\'>#</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Message ID</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Message Date</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Facility</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Contact</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Message Type</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Recipient ID</TD>\n</TR>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<TR>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><IMG SRC=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" HEIGHT=\"8\"></TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<A HREF=\"#\" onClick=\"viewMessage(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t</A>\n\t</TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;</TD>\n</TR>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</TABLE>\n</div>\n<div id=\"right_child\" class=\"testSty\" style=\"overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:none;\">\n<table id=\"table2\" cellspacing=0 cellpadding=3 border=1>\n<TR>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Recipient Type</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Recipient Dependency</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Contact Type</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Contact Mode</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Language</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Added By</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Added Date</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Added WSNO</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Added Facility</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Modified By</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Modified Date</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Modified WSNO</TD>\n\t<TD CLASS=\'COLUMNHEADER\' nowrap>Modified Facility</TD>\n</TR>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" nowrap>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</TABLE>\n</DIV>\n<SCRIPT>\n\tdocument.getElementById(\"left_child\").style.display = \"block\";\n\tdocument.getElementById(\"right_child\").style.display = \"block\"; \n</SCRIPT>\n<INPUT TYPE=\'hidden\' name=\'action_type\' id=\'action_type\' ID=\'action_type\' VALUE=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<INPUT TYPE=\'hidden\' name=\'requestType\' id=\'requestType\' ID=\'requestType\' VALUE=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<INPUT TYPE=\'hidden\' name=\'fromMsgID\' id=\'fromMsgID\' ID=\'fromMsgID\' VALUE=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<INPUT TYPE=\'hidden\' name=\'toMsgID\' id=\'toMsgID\' ID=\'toMsgID\' VALUE=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<INPUT TYPE=\'hidden\' name=\'recipientType\' id=\'recipientType\' ID=\'recipientType\' VALUE=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<INPUT TYPE=\'hidden\' name=\'fromMsgDate\' id=\'fromMsgDate\' ID=\'fromMsgDate\' VALUE=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<INPUT TYPE=\'hidden\' name=\'toMsgDate\' id=\'toMsgDate\' ID=\'toMsgDate\' VALUE=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<INPUT TYPE=\'hidden\' name=\'msgStatus\' id=\'msgStatus\' ID=\'fromMsgID\' VALUE=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<INPUT TYPE=\'hidden\' name=\'contactMode\' id=\'contactMode\' ID=\'contactMode\' VALUE=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<INPUT TYPE=\'hidden\' name=\'facilityID\' id=\'facilityID\' ID=\'facilityID\' VALUE=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<INPUT TYPE=\'hidden\' name=\'recipientID\' id=\'recipientID\' ID=\'recipientID\' VALUE=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<INPUT TYPE=\'hidden\' name=\'contactType\' id=\'contactType\' ID=\'contactType\' VALUE=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<INPUT TYPE=\'hidden\' name=\'languageID\' id=\'languageID\' ID=\'languageID\' VALUE=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<INPUT TYPE=\'hidden\' name=\'notificationType\' id=\'notificationType\' ID=\'notificationType\' VALUE=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<INPUT TYPE=\'hidden\' name=\'toCommID\' id=\'toCommID\' ID=\'toCommID\' VALUE=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<INPUT TYPE=\'hidden\' name=\'messageTypeDesc\' id=\'messageTypeDesc\' ID=\'messageTypeDesc\' VALUE=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<INPUT TYPE=\'hidden\' name=\'messageType\' id=\'messageType\' ID=\'messageType\' VALUE=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<INPUT TYPE=\'hidden\' name=\'eventTypeDesc\' id=\'eventTypeDesc\' ID=\'eventTypeDesc\' VALUE=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<INPUT TYPE=\'hidden\' name=\'eventType\' id=\'eventType\' ID=\'eventType\' VALUE=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
            eXH.NotificationCriteriaBean notificationCriteriaBean= null;{
                notificationCriteriaBean=(eXH.NotificationCriteriaBean)pageContext.getAttribute("notificationCriteriaBean");
                if(notificationCriteriaBean==null){
                    notificationCriteriaBean=new eXH.NotificationCriteriaBean();
                    pageContext.setAttribute("notificationCriteriaBean",notificationCriteriaBean);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${noRecords}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${DBQRY_TOT_ROWS}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${previousPage}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${nextPage}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${action_type}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.fromMsgID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.toMsgID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.recipientType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.fromMsgDate}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.toMsgDate}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.msgStatus}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.contactMode}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.facilityID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.recipientID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.contactType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.languageID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.notificationType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.toCommID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.messageTypeDesc}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.messageType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.eventTypeDesc}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean.eventType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block57Bytes, _wl_block57);
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
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag0 = null ;
        int __result__tag0 = 0 ;
        boolean _skipPage__tag0= false;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("notification", java.lang.String .class,"var"));
        __tag0.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationsList}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block24Bytes, _wl_block24);

                    if (_jsp__tag1(request, response, pageContext, _activeTag, __tag0))
                     return true;
                    _bw.write(_wl_block25Bytes, _wl_block25);

                    if (_jsp__tag2(request, response, pageContext, _activeTag, __tag0))
                     return true;
                    _bw.write(_wl_block25Bytes, _wl_block25);

                    if (_jsp__tag4(request, response, pageContext, _activeTag, __tag0))
                     return true;
                    _bw.write(_wl_block25Bytes, _wl_block25);

                    if (_jsp__tag6(request, response, pageContext, _activeTag, __tag0))
                     return true;
                    _bw.write(_wl_block27Bytes, _wl_block27);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block28Bytes, _wl_block28);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${IMG_SRC}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block29Bytes, _wl_block29);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block30Bytes, _wl_block30);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block31Bytes, _wl_block31);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block32Bytes, _wl_block32);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block33Bytes, _wl_block33);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_DATE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block33Bytes, _wl_block33);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'FACILITY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block33Bytes, _wl_block33);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'TO_COMMUNICATION_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block33Bytes, _wl_block33);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'EVENT_NAME\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block33Bytes, _wl_block33);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'RECIPIENT_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block35Bytes, _wl_block35);
                } while (__tag0.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag0 = true;
                return true;
            }
            _activeTag=__tag0.getParent();
            _skipPage__tag0 = false;
        } catch (java.lang.Throwable __t){
            __tag0.doCatch(__t);
        } finally {
            __tag0.doFinally();
            if (!_skipPage__tag0){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
                __tag0.release();
            }else{
                _releaseTags(pageContext, __tag0);
            }
        }
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(parent);
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("CLASS_NAME", java.lang.String .class,"var"));
        __tag1.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'TD_CLASS_NAME\']}",java.lang.Object.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(parent);
        __tag2.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_STATUS\'] == \'S\'}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block26Bytes, _wl_block26);

                if (_jsp__tag3(request, response, pageContext, _activeTag, __tag2))
                 return true;
                _bw.write(_wl_block25Bytes, _wl_block25);
            } while (__tag2.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.IfTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(parent);
        __tag3.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("IMG_SRC", java.lang.String .class,"var"));
        __tag3.setValue(( java.lang.Object ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("../eXH/images/green_square.jpg", java.lang.Object .class,"value"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(parent);
        __tag4.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_STATUS\'] == \'E\'}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block26Bytes, _wl_block26);

                if (_jsp__tag5(request, response, pageContext, _activeTag, __tag4))
                 return true;
                _bw.write(_wl_block25Bytes, _wl_block25);
            } while (__tag4.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.IfTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(parent);
        __tag5.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("IMG_SRC", java.lang.String .class,"var"));
        __tag5.setValue(( java.lang.Object ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("../eXH/images/red_square.jpg", java.lang.Object .class,"value"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(parent);
        __tag6.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_STATUS\'] == \'\'}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block26Bytes, _wl_block26);

                if (_jsp__tag7(request, response, pageContext, _activeTag, __tag6))
                 return true;
                _bw.write(_wl_block25Bytes, _wl_block25);
            } while (__tag6.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.IfTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(parent);
        __tag7.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("IMG_SRC", java.lang.String .class,"var"));
        __tag7.setValue(( java.lang.Object ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("../eXH/images/blue_square.jpg", java.lang.Object .class,"value"));
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
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag8 = null ;
        int __result__tag8 = 0 ;
        boolean _skipPage__tag8= false;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("notification", java.lang.String .class,"var"));
        __tag8.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationsList}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag8;
            __result__tag8 = __tag8.doStartTag();

            if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block24Bytes, _wl_block24);

                    if (_jsp__tag9(request, response, pageContext, _activeTag, __tag8))
                     return true;
                    _bw.write(_wl_block27Bytes, _wl_block27);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'RECEIPIENT_TYPE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'RECEIPIENT_DEPENDENCY\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'CONTACT_TYPE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'CONTACT_MODE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'LANG_DESC\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_BY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_DATE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_AT_WS_NO\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_FACILITY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MODIFIED_BY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MODIFIED_DATE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MODIFIED_AT_WS_NO\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block34Bytes, _wl_block34);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block37Bytes, _wl_block37);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MODIFIED_FACILITY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block35Bytes, _wl_block35);
                } while (__tag8.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag8 = true;
                return true;
            }
            _activeTag=__tag8.getParent();
            _skipPage__tag8 = false;
        } catch (java.lang.Throwable __t){
            __tag8.doCatch(__t);
        } finally {
            __tag8.doFinally();
            if (!_skipPage__tag8){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
                __tag8.release();
            }else{
                _releaseTags(pageContext, __tag8);
            }
        }
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(parent);
        __tag9.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("CLASS_NAME", java.lang.String .class,"var"));
        __tag9.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'TD_CLASS_NAME\']}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
}
