package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __viewmsgauditlogdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewMsgAuditLogDtl.jsp", 1709122407006L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"JavaScript\">\n//function callSort\nfunction callSort(obj)\n{ \n   var previousMode= this.document.forms[0].sortMode1.value ;\n   if(previousMode==\"A\") this.document.forms[0].sortMode.value=\"D\";\n   if(previousMode==\"D\") this.document.forms[0].sortMode.value=\"A\";\t\n   this.document.forms[0].orderbycolumns.value=obj;\n   parent.f_query_detail.location.href=\"../../eCommon/html/blank.html\";\n\n   this.document.forms[0].action=\'../../eXH/jsp/ViewMsgAuditLogDtl.jsp\';\n   this.document.forms[0].target=\'f_query_add_mod\';\n   this.document.forms[0].submit();\n}\n//function funShow\nfunction funShow(obj)\n{\n\tthis.document.forms[0].STATUS_TEXT.value = obj.getAttribute(\'STATUS_TEXT\');\n\tthis.document.forms[0].MESSAGE_TEXT.value = obj.getAttribute(\'MESSAGE_TEXT\');\t\n\t\t\n\tvar act = \'../../eXH/jsp/ViewMsgAuditLogMsgstatus.jsp\';\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'f_query_detail\';\n\tthis.document.forms[0].submit();\n}\n//function funSubmit\nfunction funSubmit()\n{\n\tvar act = \'../../eXH/jsp/ViewMsgAuditLogDtl.jsp?\';\n\tthis.document.forms[0].action = act;\n\tdocument.forms[0].sortMode.value=\"A\";\n\tthis.document.forms[0].target=\'f_query_add_mod\';\n\tthis.document.forms[0].submit();\t\n}\n//function funAction\nfunction funAction(typ)\n{\n\tdocument.forms[0].action_type.value = typ;\n\tparent.f_query_detail.location.href=\"../../eCommon/html/blank.html\";\n\tfunSubmit();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' method=\"post\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n<form name=\"viewmsg_audit_logdtl_form\" id=\"viewmsg_audit_logdtl_form\">\n\n<input  type=\"hidden\" name=appl_name value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' />\n<input  type=\"hidden\" name=facility value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' />\n<input  type=\"hidden\" name=event_type value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' />\n<input  type=\"hidden\" name=msg_type value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' />\n<input  type=\"hidden\" name=status value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' />\n<input  type=\"hidden\" name=msg_id value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' />\n<input  type=\"hidden\" name=amsg_dt1 value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' />\n<input  type=\"hidden\" name=amsg_dt2 value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' />\n<input type=\"hidden\" name=\"action_type\" id=\"action_type\" value=\'S\'/>\n\n<input type=\"hidden\" name=\"MESSAGEID\" id=\"MESSAGEID\" id=\" MESSAGEID\" value=\"\"/>\n<input type=\"hidden\" name=\"FACILITYID\" id=\"FACILITYID\" id=\"FACILITYID\" value=\"\"/>\n<input type=\"hidden\" name=\"FACILITYNAME\" id=\"FACILITYNAME\" id=\"FACILITYNAME\" value=\"\"/>\n<input type=\"hidden\" name=\"PROCESSDATETIME\" id=\"PROCESSDATETIME\" id=\"PROCESSDATETIME\" value=\"\"/>\n<input type=\"hidden\" name=\"EVENTTYPE\" id=\"EVENTTYPE\" id=\"EVENTTYPE\" value=\"\"/>\n<input type=\"hidden\" name=\"PROCESSID\" id=\"PROCESSID\" id=\"PROCESSID\" value=\"\"/>\n<input type=\"hidden\" name=\"PROCESSEDBY\" id=\"PROCESSEDBY\" id=\"PROCESSEDBY\" value=\"\"/>\n<input type=\"hidden\" name=\"ENDDATETIME\" id=\"ENDDATETIME\" id=\"ENDDATETIME\" value=\"\"/>\n<input type=\"hidden\" name=\"COMMRETRIES\" id=\"COMMRETRIES\" id=\"COMMRETRIES\" value=\"\"/>\n<input type=\"hidden\" name=\"MSGSTATUS\" id=\"MSGSTATUS\" id=\"MSGSTATUS\" value=\"\"/>\n<input type=\"hidden\" name=\"STATUS_TEXT\" id=\"STATUS_TEXT\" id=\"STATUS_TEXT\" value=\"\"/>\n<input type=\"hidden\" name=\"MESSAGE_TEXT\" id=\"MESSAGE_TEXT\" id=\"MESSAGE_TEXT\" value=\"\"/>\n<input type=\"hidden\" name=\"orderbycolumns\" id=\"orderbycolumns\" value=\'\'/>\n<input type=\"hidden\" name=\"sortMode\" id=\"sortMode\" id=\"sortMode2\"/>\n<input type=\"hidden\" name=\"sortMode1\" id=\"sortMode1\" id=\"sortMode1\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'/>\n<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'/>\n<input type=\"hidden\" name=\"purge_status\" id=\"purge_status\" id=\"purge_status\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'/>\n<input type=\"hidden\" name=\"commMode\" id=\"commMode\" id=\"commMode\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'/>\n\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n<script>\nalert(getMessage(\'XH1021\',\"XH\"));\nwindow.close();\n</script>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n<tr>\n\t<td colspan=\"6\" align=\"center\" class=\"CAGROUP\">\n\t<td colspan=\"6\" align=\"right\" class=\"CAGROUP\"> \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\"><u>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</u></A>\n\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'><u>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</u></A>\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'MESSAGE_ID\' id=\'MESSAGE_ID\' href=\"javascript:callSort(\'MESSAGE_ID\');\" ><font color=white>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font></td> \n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'FACILITY_ID\' id=\'FACILITY_ID\'  href=\"javascript:callSort(\'FACILITY_ID\');\" ><font color=white>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td>\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'STATUS\' id=\'STATUS\'  href=\"javascript:callSort(\'STATUS\');\" ><font color=white>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></td>\n   \t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'PROCESS_DATE_TIME\' id=\'PROCESS_DATE_TIME\' href=\"javascript:callSort(\'PROCESS_DATE_TIME\');\" ><font color=white>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></td>\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'PROCESSED_BY\' id=\'PROCESSED_BY\'  href=\"javascript:callSort(\'PROCESSED_BY\');\" ><font color=white>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></td>\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'EVENT_TYPE\' id=\'EVENT_TYPE\'  href=\"javascript:callSort(\'EVENT_TYPE\');\" ><font color=white>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font></td>\t\t\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'STATUS\' id=\'STATUS\'  href=\"javascript:callSort(\'STATUS\');\" ><font color=white>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'END_DATE_TIME\' id=\'END_DATE_TIME\'  href=\"javascript:callSort(\'END_DATE_TIME\');\" ><font color=white>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td>\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a name=\'COMM_RETRIES\' id=\'COMM_RETRIES\'  href=\"javascript:callSort(\'COMM_RETRIES\');\" ><font color=white>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<td class=\'COLUMNHEADER\' align=\"center\"><a id=\'PROCESS_ID\' id=\'PROCESS_ID\'  href=\"javascript:callSort(\'PROCESS_ID\');\" ><font color=white>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font></td>    \n\t\n</tr>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<tr>\n<td ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" align=\"center\">\n\t<font size=1>\n\t<a href=\'#\' onClick=\'funShow(this)\' \n\t\t\t\tMESSAGEID=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' FACILITYID=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  \n\t\t\t\tFACILITYNAME=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' PROCESSDATETIME=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' \n\t\t\t\tEVENTTYPE=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' PROCESSID=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  \n\t\t\t\tPROCESSEDBY=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' ENDDATETIME=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'\n\t\t\t\tCOMMRETRIES=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' MSGSTATUS =\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' \n\t\t\t\tMESSAGE_TEXT =\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'STATUS_TEXT =\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t</a>\n\t</font>\n</td>\n<td ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="><font size=1>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</font></td>\n<td ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" align=\"center\"><font size=1>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<td ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</font></td>\n\t<td ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<td ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</font></td>\n</tr>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n</table>\n\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

boolean boolToggle =  true;	
String strTDClass = "";
String moduleID = request.getParameter("moduleID");
String tableName = "APPL_MSG_AUDIT_VW";
String purge_status = request.getParameter("purge_status");

String qry_id = "VIEWAUDITLOG";

if(purge_status != null && purge_status.equalsIgnoreCase("OFFLINE"))
{
	qry_id = "VIEWAUDITLOGOFFLINE";
	tableName = "OFFLINE_" + tableName;
}
else if(purge_status != null && purge_status.equalsIgnoreCase("PURGE"))
{
	qry_id = "VIEWAUDITLOGPURGE";
	tableName = "PURGE_" + tableName;
}

tableName = moduleID + "_" + tableName;

Connection conn = null;
try
{
	request.setAttribute(XHQueryRender.strQueryId,qry_id);
	request.setAttribute(XHQueryRender.col,"12");
	request.setAttribute(XHQueryRender.maxRec,"18");
	request.setAttribute("tableName", tableName);
	conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
	   strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
	   strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
	   strNext  = " ";
	}
	String appl_name = request.getParameter("appl_name"); 
	String facility = request.getParameter("facility");
	String event_type = request.getParameter("event_type");
	String msg_type = request.getParameter("msg_type");
	String status = request.getParameter("status"); 
	String msg_id = request.getParameter("msg_id");
	String amsg_dt1 = request.getParameter("amsg_dt1");
	String amsg_dt2 = request.getParameter("amsg_dt2");
	String mode = request.getParameter("sortMode");	
	String commMode = request.getParameter("commMode");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(appl_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(event_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(msg_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(msg_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(amsg_dt1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(amsg_dt2));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(commMode));
            _bw.write(_wl_block20Bytes, _wl_block20);

if(arrRow.size()==0)
{

            _bw.write(_wl_block21Bytes, _wl_block21);
 } else { 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
if(commMode != null && commMode.equals("O")){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

for (int j=0; j<arrRow.size();j++)
{
	arrCol = (ArrayList)arrRow.get(j);
if (boolToggle == true)
{
	strTDClass = "class='QRYEVEN'";
	boolToggle =  false;
}
else
{
	strTDClass = "class='QRYODD'";
	boolToggle =  true;
}

String msgid = ((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);

String status_msg="";
String int_status="";
status_msg=(String)arrCol.get(9);
if(status_msg.equalsIgnoreCase("S")) 
{
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Sucessfull.Label","xh_labels");
//	int_status = "Successful";
}
else if(status_msg.equalsIgnoreCase("F"))
{
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Failed.label","common_labels");
//	int_status = "Failed";
}
else if(status_msg.equalsIgnoreCase("R")) 
{
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
//	int_status = "Rejected";
}
else if(status_msg.equalsIgnoreCase("A")) 
{
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accepted.label","common_labels");
//	int_status = "Accepted";
}
else if(status_msg.equalsIgnoreCase("") || status_msg.equalsIgnoreCase("null")) 
{
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
//	int_status = "Pending";
}
else if(status_msg.equalsIgnoreCase("E")) 
{
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels");
//	int_status = "Error";
}
else if(status_msg.equalsIgnoreCase("L")) 
{
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Loaded.Label","xh_labels");
//	int_status = "Loaded";
}

String processDate="";
String strProcessDate="";
processDate=((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);

if(!processDate.equals("")) 
{
	strProcessDate = com.ehis.util.DateUtils.convertDate(processDate,"DMYHMS","en",locale);
//	strProcessDate = processDate;
}

String endDate="";
String strendDate="";
endDate=((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);
if(!endDate.equals("")) 
{
	strendDate = com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);
//	strendDate = endDate;
}


            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrCol.get(2)+""));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(arrCol.get(3)+""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(arrCol.get(4)+""));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrCol.get(5)+""));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(arrCol.get(7)+""));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(arrCol.get(8)+""));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(arrCol.get(9)+""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(11)+""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(arrCol.get(10)+""));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(msgid));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(((String)arrCol.get(2)).equals("null")?"&nbsp;":arrCol.get(2)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(""+arrCol.get(10)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(""+strProcessDate));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(((String)arrCol.get(6)).equals("null")?"&nbsp;":arrCol.get(6)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(((String)arrCol.get(4)).equals("null")?"&nbsp;":arrCol.get(4)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(""+int_status));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(commMode != null && commMode.equals("O")){
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(""+strendDate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(((String)arrCol.get(8)).equals("null")?"&nbsp;":arrCol.get(8)));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(((String)arrCol.get(5)).equals("null")?"&nbsp;":arrCol.get(5)));
            _bw.write(_wl_block57Bytes, _wl_block57);

}
}
if(resultsQry!=null)  resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null)  arrRow.clear();
}
catch(Exception e1)
{
	e1.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(conn);
}

            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.MessageID.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ActionDateTime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ActionBy.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.OldMessageStatus.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.OldCommDateTime.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Retries.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcessID.label", java.lang.String .class,"key"));
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
}
