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
import eXH.XHReturnArray;
import webbeans.eCommon.*;

public final class __reviewapplmessagemenutreetext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ReviewApplMessageMenuTreeText.jsp", 1743587132306L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n<script language=\'javascript\' src=\"../../eCommon/js/messages.js\"></script>\n<script language=\'javascript\' src=\"../../eXH/js/XHAjaxUtil.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<SCRIPT> alert(getMessage(\'XH1001\')); </SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<body onLoad=\"load()\">\n<form name=\"menu_treetext1\" id=\"menu_treetext1\">\n<input type=\"hidden\" name=\"viewflag\" id=\"viewflag\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\n<input type=\"hidden\" name=\"replayflag\" id=\"replayflag\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\n<input type=\"hidden\" name=\"auditFlag\" id=\"auditFlag\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n<input type=\"hidden\" name=\"mode_insert\" id=\"mode_insert\"/>\n<input type=\"hidden\" name=\"sub_module\" id=\"sub_module\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n<input type=\"hidden\" name=\"protocol_mode\" id=\"protocol_mode\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n<input type=\"hidden\" name=\"applicationName\" id=\"applicationName\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n<input type=\"hidden\" name=\"applicationId\" id=\"applicationId\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n<input type=\"hidden\" name=\"facilityName\" id=\"facilityName\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n<input type=\"hidden\" name=\"msgid\" id=\"msgid\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n<input type=\"hidden\" name=\"eventType\" id=\"eventType\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n<input type=\"hidden\" name=\"protocol_link_id\" id=\"protocol_link_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\n<input type=\"hidden\" name=\"queueType\" id=\"queueType\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\n\n<table cellspacing=0 cellpadding=3 width=\'100%\' border=0 align=center>\n<tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</tr>\n\n<tr></tr>\n<tr></tr>\n\n<tr><td class=\'fields\'><textarea name=\"Msg_desc\" id=\"Msg_desc\" rows=41 cols=112 readOnly>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</textarea></td></tr>\n\n<tr>\n\t<td>\n\t<input type=\"hidden\" name=\"Protocol_value\" id=\"Protocol_value\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'/>\n\t<input type=\"hidden\" name=\"rule_txt\" id=\"rule_txt\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' />\n\t<input class=\'button\' id=\"viewbtton\" type=\"button\" name=\'auditlog\' id=\'auditlog\' value=\'Audit Log\' onClick=\"goToAuditLog(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\"> \n<!--<input class=\'button\' id=\"replaybtton\" type=\"button\"  name=\'query\' id=\'query\' value=\'<fmt:message key=\"Common.query.label\" bundle=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\' disabled  onClick=\'\'>--->\n\t<input class=\'button\' id=\"viewbtton1\" type=\"button\" name=\'views\' id=\'views\' value=\'View\' onClick=\"goToView()\"> \n\t<input class=\'button\' id=\"replaybtton1\" type=\"button\"  name=\'replays\' id=\'replays\' value=\'Replay\'  onClick=\'replayMethod();\'>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n\tStatus &nbsp;&nbsp;<input type=\"text\"  name=\"comm_client\" id=\"comm_client\" id=\"comm_client\" size=45 value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\"hidden\" name=\"msgStatus\" id=\"msgStatus\" id=\"msgStatus\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t</td>\n\n</tr>\n</table>\n\n</form name=menu_treetext1>\n</body>\n</html>\n\n<script>\n//**********************************************************************************************/\nvar dialogHeight = \"250\";\nvar dialogWidth  = \"250\";\nvar dialogTop    = \"230\";\nvar dialogLeft   = \"230\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n//*********************************************************************************************/\n\n\n\nfunction load()\n{\n\tappID = document.forms[0].applicationId.value;\n\tfacilityID = document.forms[0].facilityId.value;\n\tmsgID = document.forms[0].msgid.value;\t\t\n\n\tif(this.document.forms[0].rule_txt.value == \'I\')\n\t{\n\t\tdocument.getElementById(\"replaybtton1\").style.display = \"none\";\n\t}\n\telse\n\t{\n\t\tvar msgStatus = this.document.forms[0].msgStatus.value;\n\t\t\n\t//\tdocument.getElementById(\"replaybtton1\").style.display=\"block\";\n\t\tif(this.document.forms[0].viewflag.value == \'Y\') \n\t\t{\n\t\t\tthis.document.forms[0].views.disabled = false;\n\t\t}\n\t\telse \n\t\t{\n\t\t\tthis.document.forms[0].views.disabled = true;\n\t\t}\n\t\tif(this.document.forms[0].replayflag.value == \'Y\' && (msgStatus != \'null\')) \n\t\t{\t\t\t\t\n\t\t\tthis.document.forms[0].replays.disabled = false;\n\t\t}\n\t\telse \n\t\t{\t\t\t\n\t\t\tthis.document.forms[0].replays.disabled = true;\n\t\t}\n\t\tif(this.document.forms[0].auditFlag.value == \'Y\') \n\t\t{\t\n\t\t\t// Checking whether audit history exists or not.\n\t\t\tvar auditExistsQry = \"SELECT 1 FROM xh_application_message_audit WHERE APPLICATION_ID=\'\"+appID+\"\'\"+\n\t\t\t\t\t\t\t\t\" AND MESSAGE_ID=\'\"+msgID+\"\' AND FACILITY_ID=\'\"+facilityID+\"\'\";\n\t\n\t\t\tvar val = getValue(auditExistsQry);\t\n\t\t\tval = val.replace(/^\\s\\s*/, \'\').replace(/\\s\\s*$/, \'\');\n\n\t\t\tif(val == \"Y\") // val = Y indicates that audit exists for this message\n\t\t\t{\t\t\t\t\n\t\t\t\tthis.document.forms[0].auditlog.disabled = false;\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\tthis.document.forms[0].auditlog.disabled = true;\n\t\t\t}\n\t\t}\n\t\telse \n\t\t{\n\t\t\tthis.document.forms[0].auditlog.disabled = true;\n\t\t}\n\t}\n}\n//**************************************************************************************************\nasync function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)\n{\t\n\tvar arguments  =new Array();\n\targuments[0]=\'L\';\n\targuments[1]=applicationId;\n\targuments[2]=applicationName;\n    arguments[3]=facilityId;\n\targuments[4]=facilityName;\n\targuments[5]=msgId;\n    arguments[6]=eventType;\n\targuments[7]=eventName;\t\n\n\turl = \"applicationId=\"+applicationId+\"&applicationName=\"+applicationName+\"&facilityId=\"+facilityId+\"&eventName=\"+eventName+\"&msgId=\"+msgId+\"&eventType=\"+eventType+\"&facilityName=\"+facilityName;\n    \n\tawait window.showModalDialog(\"../../eXH/jsp/ViewMessageAuditLogMain.jsp?\"+url,arguments,features);  \n}\n//**************************************************************************************************\nfunction replayMethod()\n{\n   this.document.menu_treetext1.mode_insert.value=\'R\';\n   this.document.menu_treetext1.action = \'../../eXH/jsp/ReviewApplMessageMenuTreeText.jsp\';\n   this.document.menu_treetext1.submit();\n}\n//********************************************************************************************************\n\nasync function goToView()\n{\n\t\t//var dialogHeight = \"50\";\n\t//var dialogWidth  = \"50\";\n\t//var dialogTop    = \"50\";\n\t//var dialogLeft   = \"50\";\n\t//var features1     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n    //var url=\"../../eXH/jsp/ViewSegments.jsp\";\n //window.open(url,null,\"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no\");\n/*var dialogHeight= \"50\" ;\n\tvar dialogWidth\t= \"70\" ;\n\tvar dialogTop = \"190\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;*/\n\t\n // window.showModalDialog(\"../../eXH/jsp/ViewSegmentsTree.jsp\",arguments,features);\n    var arguments  =new Array();\n    await window.showModalDialog(\'../../eXH/jsp/ViewSegmentsTree.jsp?srlNo=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&application_Id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&Facility_Id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&Msg_Id=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&Even_type=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&protocol_link_id=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&sub_module=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&protocol_mode=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',arguments,features);\n\n //window.showModalDialog(\"../../eXH/jsp/ViewSegmentsTree.jsp\",arguments,features);\n//window.showModalDialog(\"../../eXH/jsp/ViewSegmentsTree.jsp\",\"Reviewformate\",100,100);\n\n} \n//********************************************************************************************************\n</script>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);


String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
String sub_module = request.getParameter("sub_module");

Connection con = null;

// System.out.println("sub_module13"+sub_module);


            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

//String rule=request.getParameter("rules");
//String mode=request.getParameter("mode");
String protocol_mode = request.getParameter("protocol_mode");
String queueType = request.getParameter("queueType");
String applicationId = "";
String applicationName = "";
String facilityId = "";
String facilityName = "";						    
String msgId = "";
String eventType = ""; 
String eventName = "";
String msgtext = "";
String protocol_link_id = "";
String Proto_type = "";
// MessageManager mm = new MessageManager();

//Properties p = (Properties) session.getValue("jdbc");	
//String locale  = p.getProperty("LOCALE");

// XHReturnArray arr = new XHReturnArray();

eventName = request.getParameter("eventName");
applicationName = request.getParameter("applicationName");
String srlNo = request.getParameter("srlNo");

if(protocol_mode != null && protocol_mode.equalsIgnoreCase("I"))
{	 
	 applicationId = request.getParameter("applicationId");
	 facilityName = request.getParameter("facilityName");
	 msgId = request.getParameter("msgid");
	 facilityId = request.getParameter("facilityId");
	 eventType = request.getParameter("eventType");
	 protocol_link_id = request.getParameter("protocol_link_id");
}
else if(protocol_mode != null && protocol_mode.equalsIgnoreCase("O"))
{
    applicationId = request.getParameter("applicationId");
    facilityId = request.getParameter("facilityId");
    facilityName = request.getParameter("facilityName");
    msgId = request.getParameter("msgid");
    eventType = request.getParameter("eventType");
    protocol_link_id = request.getParameter("protocol_link_id");
}

String msgstatus = "";
String int_msgstatus = "";
String viewflag = "";
String replayflag = "";
String auditFlag = "";
String mode_insert = request.getParameter("mode_insert");

con = ConnectionManager.getConnection(request);

try
{
	if(mode_insert!=null)
	{
		CallableStatement ostmt = null; 
		String message_text2 = "";		

		ostmt = con.prepareCall("{ call XHMSG.REPLAY(?,?,?,?,?,?) }" ); 
		ostmt.setString(1,facilityId);
		ostmt.setString(2,applicationId);
		ostmt.setString(3,msgId);
		ostmt.setString(4,queueType);
		ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		ostmt.execute();
		message_text2 = ostmt.getString(5);	
		if(message_text2.equals("0"))
		{
			con.commit();
			
            _bw.write(_wl_block6Bytes, _wl_block6);

		}
		else
		{
			con.rollback();
		}
		ostmt.close();
	}

	String sql = "";

	if(protocol_mode != null && protocol_mode.equalsIgnoreCase("I"))
	{
		sql = "SELECT INBOUND_MESSAGE_TEXT,message_status FROM "+sub_module+"_INBOUND_MESSAGE" +
				" WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "+
				" AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"+
				" AND facility_id=NVL('"+facilityId+"',facility_id)"+
				" AND SRL_NO=NVL('"+srlNo+"',SRL_NO)";
	}
	else if(protocol_mode!=null && protocol_mode.equalsIgnoreCase("O"))
	{														  

		/*	sql="SELECT MESSAGE_TEXT,message_status FROM XH_APPLICATION_MESSAGE"
					+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
					+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
					+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
					+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )"; 
		*/

		if((applicationId.equalsIgnoreCase("EPABXO"))||(applicationId.equalsIgnoreCase("EPABXI")))
		{	
			sql="SELECT MESSAGE_TEXT,message_status FROM XP_EVENT"
					+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
					+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
					+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
					+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
		}
		else
		{
			sql="SELECT MESSAGE_TEXT,message_status FROM "+sub_module+"_APPLICATION_MESSAGE"
					+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
					+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
					+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
					+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
		}
	}

	//System.out.println("(ReviewApplMessageMenuTreeText:msg)Query: "+sql);

	String curr_user_id = (String)session.getValue("login_user");
	String usrsql = "Select VIEW_YN,REPLAY_YN,AUDIT_YN from xh_authorized_user where LOGIN_NAME='"+curr_user_id+"'";
	//System.out.println("usrsql :"+usrsql);

	ResultSet rs = null;
	Statement stmt = null;
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);

	while(rs.next())
	{ 
		msgtext = rs.getString(1);
		msgstatus = rs.getString(2);
		//System.out.println("msgtext excute time"+msgtext);
	}

	if(rs != null) rs.close();
	rs = stmt.executeQuery(usrsql);

	while(rs.next())
	{ 
		viewflag = rs.getString(1);
		replayflag = rs.getString(2);
		auditFlag = rs.getString(3);
	}
	if(viewflag == null) viewflag = "";
	if(replayflag == null) replayflag = "";
	if(auditFlag == null) auditFlag = "";
	if(rs != null) rs.close();
	if(stmt!= null) stmt.close();
}	
catch (Exception e) 
{
	out.println("error in tree"+e.toString()) ;
	e.printStackTrace(System.err) ;
}
finally 
{

}




if(protocol_mode.equals("I"))
{
	if(msgstatus==null)
	{
		//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
		int_msgstatus="Pending";
	}
	if(msgstatus!=null)
	{ 
		if(msgstatus.equalsIgnoreCase("S"))
		{
		//	final java.util.Hashtable mesg = mm.getMessage("XH0062") ;
		//	final java.util.Hashtable mesg = mm.getMessage(con,"XH0062") ;
			int_msgstatus = "Received";
		}
		if(msgstatus.equalsIgnoreCase("L"))
		{
		//	final java.util.Hashtable mesg = mm.getMessage("XH0061") ;
			int_msgstatus = "Message Loaded";
		}
		if(msgstatus.equalsIgnoreCase("E"))
		{
		//	final java.util.Hashtable mesg = mm.getMessage("XH0063") ;
			int_msgstatus = "Loading Error";
		}
	}
}
else if(protocol_mode.equals("O"))
{
	if(msgstatus==null)
	{	
//		int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
		int_msgstatus="Pending";
	}
	if(msgstatus!=null)
	{ 
		if(msgstatus.equalsIgnoreCase("S"))
		{	
		//	final java.util.Hashtable mesg = mm.getMessage("XH0065") ;
			int_msgstatus = "Successfully sent";
		}
		if(msgstatus.equalsIgnoreCase("R"))
		{	
		//	int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Rejected.Label","xh_labels");
			int_msgstatus="Rejected";
		}
		if(msgstatus.equalsIgnoreCase("F")) 
		{
		//	int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Failure.Label","xh_labels");
			int_msgstatus="Failed";
		}
		if(msgstatus.equalsIgnoreCase("E")) 
		{	
		//	final java.util.Hashtable mesg = mm.getMessage("XH0064") ;
			int_msgstatus = "Error in Sending";
		}
		if(msgstatus.equalsIgnoreCase("A")) 
		{	
		//	final java.util.Hashtable mesg = mm.getMessage("XH0060") ;
			int_msgstatus = "Acknowledgement Received";
		}
    }
 }
/*
	String segment[][]=null;
	String segment1[][]=null;
	String temp[][]=null;
	HashMap hasmap=null;
	System.out.println("jsp :"+msgtext);
	if(msgtext!=null) hasmap=arr.returnsSegmentArray(msgtext);
	if(hasmap!=null){ segment=(String[][])hasmap.get("segment");System.out.println("segment"+segment);
	if(segment!=null){
	temp=new String[segment.length][2];
	for(int i=1;i<segment.length;i++)
	{
	if(segment[i][0].equals(segment[i-1][0]))
	{
	temp[i-1][0]=segment[i-1][0]+""+i+"";
	temp[i-1][1]=segment[i-1][1];

	}

	else
	{
	temp[i-1][0]=segment[i-1][0];
	temp[i-1][1]=segment[i-1][1];

	}

	}
	if(segment.length!=0){
	temp[segment.length-1][0]=segment[segment.length-1][0];
	temp[segment.length-1][1]=segment[segment.length-1][1];
	session.putValue("SegmentValues",temp);  
	}
	}
	}
	if(temp!=null){
	}

	if(segment!=null){
	for(int i=0;i<temp.length;i++)
	{
	segment1=(String[][])hasmap.get("comp"+i);

	if(segment1!=null)
	{
	session.putValue(temp[i][0],segment1);
	}


	//session.putValue(temp[i][0],segment1);  
	}
	}
	if(hasmap!=null) hasmap.clear();
*/

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(viewflag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(replayflag));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(auditFlag));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( sub_module ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( protocol_mode ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( applicationName ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( applicationId ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( facilityName ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( msgId ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( facilityId ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( eventType ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( protocol_link_id ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( queueType ));
            _bw.write(_wl_block20Bytes, _wl_block20);


// conn = ConnectionManager.getConnection(request);
ResultSet rs1 = null;
Statement stmt1 = null;
try
{
	stmt1 = con.createStatement();
	String Query = "SELECT protocol_type FROM xh_protocol X,xh_protocol_link Y WHERE X.protocol_id=Y.protocol_id AND Y.protocol_link_id='"+protocol_link_id+"'";
	//System.out.println("Query"+Query);

	rs1=stmt1.executeQuery(Query);
	while(rs1.next())
	{ 
		Proto_type = rs1.getString(1);		
	}
}
catch(Exception e)
{
	e.printStackTrace(System.err) ;
}
finally
{
	if(rs1!=null) rs1.close();
    if(stmt1!=null) stmt1.close();
	ConnectionManager.returnConnection(con) ;
}
/*	session.setAttribute("application_Id",applicationId); 
	session.setAttribute("Facility_Id",facilityId);
	session.setAttribute("Msg_Id",msgId);
	session.setAttribute("Even_type",eventType);
	session.setAttribute("Message_Text",msgtext);
	session.setAttribute("protocol_link_id",protocol_link_id);
*/



            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(msgtext));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Proto_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(protocol_mode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(applicationId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(applicationName));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facilityName ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(msgId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(eventType ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(eventName ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(int_msgstatus));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( msgstatus ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(srlNo));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(applicationId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(msgId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(eventType));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(protocol_link_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(protocol_mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
