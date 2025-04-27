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

public final class __viewquerynextpreviouspage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewQueryNextPreviousPage.jsp", 1709122412037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML> \n \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<HEAD> \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<input type=\"hidden\" name=\"pagechange\" id=\"pagechange\" id=\"pagechange\" value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<input type=\"hidden\" name=\"Application_id\" id=\"Application_id\" id=\"Application_id\" VALUE=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' />\n<input type=\"hidden\" name=\"Facility_Id\" id=\"Facility_Id\" id=\"Facility_Id\" VALUE=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' />\n<input type=\"hidden\" name=\"msg_id\" id=\"msg_id\" id=\"msg_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\n<input type=\"hidden\" name=\"QUERYID\" id=\"QUERYID\" id=\"QUERYID\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n<input type=\"hidden\" name=\"event_type\" id=\"event_type\" id=\"event_type\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'/>\n<input type=\"hidden\" name=\"Protocollink_id\" id=\"Protocollink_id\" id=\"Protocollink_id\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'/>\n<input type=\"hidden\" name=\"STATUSTEXT\" id=\"STATUSTEXT\" id=\"STATUSTEXT\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'/>\n<input  type=\"hidden\" name=qapplname value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' />\n<input  type=\"hidden\" name=qfacility value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' />\n<input  type=\"hidden\" name=qmsg_dt1 value=\'\' />\n<input  type=\"hidden\" name=qmsg_dt2 value=\'\' />\n\n<input  type=\"hidden\" name=qostatus value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' />\n<input  type=\"hidden\" name=application_Msg id=application_Msg value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' />\n<input  type=\"hidden\" name=Error_msg id=Error_msg  value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' />\n<input type=\"hidden\" name=\"position\" id=\"position\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' /> \n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n \n\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'></link>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/ViewEventsFooter.js\" ></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\'formload()\'>\n<form name=\"application_setup_base_form\" id=\"application_setup_base_form\"  method=\"POST\"   action=\'\'>\n<table width=\"100%\">\n\n<tr><td colspan=6 align=\'right\'><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'|<\' name=\"firstrecord\" id=\"firstrecord\" id=\"firstrecord\" onClick=\"funAction(\'F\')\"><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'<<\'  onClick=\"funAction(\'P\')\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'>>\'  onClick=\"funAction(\'N\')\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'>|\' name=\"lastrecord\" id=\"lastrecord\" onClick=\"funAction(\'L\')\"></td></tr>\t\n\n</table>\n<script> \n\n\nfunction formload()\n{\nif(document.getElementById(\"pagechange\").value==\'N\')\n{\n\n\n}\nelse\n{\n\t\n\tdocument.getElementById(\"pagechange\").value=\'N\';\t\nvar appl=document.getElementById(\"Application_id\").value\nvar faci=this.document.getElementById(\"Facility_id\").value;\nvar msgid=this.document.getElementById(\"msg_id\").value;\nvar queryid=this.document.getElementById(\"QUERYID\").value;\nvar event_type=this.document.getElementById(\"event_type\").value;\nvar Protocollink_id=this.document.getElementById(\"Protocollink_id\").value;\nvar statustext=escape(this.document.getElementById(\"STATUSTEXT\").value);\nvar application_Msg=escape(this.document.getElementById(\"application_Msg\").value);\nvar Error_msg=escape(this.document.getElementById(\"Error_msg\").value);\nvar qapplname=escape(this.document.getElementById(\"qapplname\").value);\nvar qfacility=escape(this.document.getElementById(\"qfacility\").value);\nvar msg_status=this.document.getElementById(\"msg_status\").value;\nvar purge_status=this.document.getElementById(\"purge_status\").value;\nvar qostatus=this.document.getElementById(\"qostatus\").value;\nvar position=parseInt(this.document.getElementById(\"position\").value);\nvar posi=position;\n\tvar typ=this.document.getElementById(\"action_type\").value;\n\tif(typ==\'L\')\n    {\n\t\tdocument.getElementById(\"lastrecord\").disabled=true;\nvar url=\"application_Id=\"+appl+\"&Facility_Id=\"+faci+\"&Msg_Id=\"+msgid+\"&qryid=\"+queryid+\"&Even_type=\"+event_type+\"&protocol_link_id=\"+Protocollink_id+\"&STATUSTEXT=\"+statustext+\"&application_Msg=\"+application_Msg+\"&Error_msg=\"+Error_msg+\"&qapplname=\"+qapplname+\"&faciname=\"+qfacility+\"&qmsg_dt1=&qmsg_dt2=&msg_status=\"+msg_status+\"&purge_status=\"+purge_status+\"&Query_Option=\"+qostatus+\"&posi=\"+posi+\"&action_type=A&pagechange=\"+document.getElementById(\"pagechange\").value; \nparent.frames[1].document.location.href=\'../../eXH/jsp/ViewQryMsgFooterMain.jsp?\'+url;\n/*parent.frames[2].document.location.href=\'../../eXH/jsp/ViewMsgAuditLogDtl.jsp?appl_name=\'+qapplname+\'&facility=\'+qfacility+\'&event_type=\'+event_type+\'&msg_id=\'+msgid+\'&amsg_dt1=&amsg_dt2=&status=\'+msg_status;*/\nvar url2=\"appl_name=\"+appl.value+\"&facility=\"+faci.value+\"&msg_id=\"+msgid+\"&event_type=\"+event_type+\"&purge_status=\"+purge_status+\"&commMode=&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en\";\n\nparent.frames[2].document.location.href=\"../../eXH/jsp/ViewMsgReviewAuditLog.jsp?\"+url2;\n\t}\n\telse if(typ==\'F\')\n\t{\n\t\tdocument.getElementById(\"firstrecord\").disabled=true;\n\n\t\tvar url=\"application_Id=\"+appl+\"&Facility_Id=\"+faci+\"&Msg_Id=\"+msgid+\"&qryid=\"+queryid+\"&Even_type=\"+event_type+\"&protocol_link_id=\"+Protocollink_id+\"&STATUSTEXT=\"+statustext+\"&application_Msg=\"+application_Msg+\"&Error_msg=\"+Error_msg+\"&qapplname=\"+qapplname+\"&faciname=\"+qfacility+\"&qmsg_dt1=&qmsg_dt2=&msg_status=\"+msg_status+\"&purge_status=\"+purge_status+\"&Query_Option=\"+qostatus+\"&posi=\"+posi+\"&action_type=A&pagechange=\"+document.getElementById(\"pagechange\").value; \nparent.frames[1].document.location.href=\'../../eXH/jsp/ViewQryMsgFooterMain.jsp?\'+url;\n/*parent.frames[2].document.location.href=\'../../eXH/jsp/ViewMsgAuditLogDtl.jsp?appl_name=\'+qapplname+\'&facility=\'+qfacility+\'&event_type=\'+event_type+\'&msg_id=\'+msgid+\'&amsg_dt1=&amsg_dt2=&status=\'+msg_status;*/\nvar url2=\"appl_name=\"+appl.value+\"&facility=\"+faci.value+\"&msg_id=\"+msgid+\"&event_type=\"+event_type+\"&purge_status=\"+purge_status+\"&commMode=&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en\";\n\nparent.frames[2].document.location.href=\"../../eXH/jsp/ViewMsgReviewAuditLog.jsp?\"+url2;\n\t}\n\telse\n\t{\n \n//alert(\"differ queryid :\"+queryid);\n//alert(\"after click\"+posi);\n//alert(posi);\n\nvar url=\"application_Id=\"+appl+\"&Facility_Id=\"+faci+\"&Msg_Id=\"+msgid+\"&qryid=\"+queryid+\"&Even_type=\"+event_type+\"&protocol_link_id=\"+Protocollink_id+\"&STATUSTEXT=\"+statustext+\"&application_Msg=\"+application_Msg+\"&Error_msg=\"+Error_msg+\"&qapplname=\"+qapplname+\"&faciname=\"+qfacility+\"&qmsg_dt1=&qmsg_dt2=&msg_status=\"+msg_status+\"&purge_status=\"+purge_status+\"&Query_Option=\"+qostatus+\"&posi=\"+posi+\"&action_type=A&pagechange=\"+document.getElementById(\"pagechange\").value; \nparent.frames[1].document.location.href=\'../../eXH/jsp/ViewQryMsgFooterMain.jsp?\'+url;\n/*parent.frames[2].document.location.href=\'../../eXH/jsp/ViewMsgAuditLogDtl.jsp?appl_name=\'+qapplname+\'&facility=\'+qfacility+\'&event_type=\'+event_type+\'&msg_id=\'+msgid+\'&amsg_dt1=&amsg_dt2=&status=\'+msg_status;*/\nvar url2=\"appl_name=\"+appl.value+\"&facility=\"+faci.value+\"&msg_id=\"+msgid+\"&event_type=\"+event_type+\"&purge_status=\"+purge_status+\"&commMode=&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en\";\n\nparent.frames[2].document.location.href=\"../../eXH/jsp/ViewMsgReviewAuditLog.jsp?\"+url2;\n\n\t}\n\n}\n}\n//******************************************************************************************\nfunction funAction(typ)\n{\n\tif(typ==\'L\')\n    {\n\n\t\tdocument.getElementById(\"action_type\").value = \"L\";\n       var act = \'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value;\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\"f_query_\";\n\tthis.document.forms[0].submit();\n\n/*parent.frames[0].document.location.href=\'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value;*/\n\n\t}\n\telse if(typ==\'F\')\n\t{\n\t\tdocument.getElementById(\"action_type\").value = \"F\";\n\t\t var act = \'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value;\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\"f_query_\";\n\tthis.document.forms[0].submit();\n/*parent.frames[0].document.location.href=\'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value;*/\n\t}\n\telse\n\t{\n\tdocument.getElementById(\"action_type\").value = \"A\";\nvar appl=document.getElementById(\"Application_id\").value\nvar faci=this.document.getElementById(\"Facility_id\").value;\nvar msgid=this.document.getElementById(\"msg_id\").value;\nvar queryid=this.document.getElementById(\"QUERYID\").value;\nvar event_type=this.document.getElementById(\"event_type\").value;\nvar Protocollink_id=this.document.getElementById(\"Protocollink_id\").value;\nvar statustext=escape(this.document.getElementById(\"STATUSTEXT\").value);\nvar application_Msg=escape(this.document.getElementById(\"application_Msg\").value);\nvar Error_msg=escape(this.document.getElementById(\"Error_msg\").value);\nvar qapplname=escape(this.document.getElementById(\"qapplname\").value);\nvar qfacility=escape(this.document.getElementById(\"qfacility\").value);\n\nvar msg_status=this.document.getElementById(\"msg_status\").value;\nvar purge_status=this.document.getElementById(\"purge_status\").value;\nvar qostatus=this.document.getElementById(\"qostatus\").value;\nvar posi=\"\";\n//alert(\"on click queryid :\"+queryid);\nif(typ==\"N\")\n{\nvar position=parseInt(this.document.getElementById(\"position\").value);\nposition=position+1;\nposi=position;\n}\nelse\n{\nvar position=parseInt(this.document.getElementById(\"position\").value);\nposition=position-1;\nposi=position;\n\t}\n\n//alert(\"on click\"+posi);\nvar url=\"application_Id=\"+appl+\"&Facility_Id=\"+faci+\"&Msg_Id=\"+msgid+\"&qryid=\"+queryid+\"&Even_type=\"+event_type+\"&protocol_link_id=\"+Protocollink_id+\"&STATUSTEXT=\"+statustext+\"&application_Msg=\"+application_Msg+\"&Error_msg=\"+Error_msg+\"&qapplname=\"+qapplname+\"&faciname=\"+qfacility+\"&qmsg_dt1=&qmsg_dt2=&msg_status=\"+msg_status+\"&purge_status=\"+purge_status+\"&Query_Option=\"+qostatus+\"&posi=\"+posi+\"&action_type=A&pagechange=Y\"; \nparent.frames[0].document.location.href=\'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?\'+url;\n\t/*var act = \'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?\'+url;\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'\';\n\tthis.document.forms[0].submit(); */\n\t}\n\n}\n\n\n function windowclose()\n{\n/*application_Id=\"+this.document.forms[0].Application_id.value+\"&Facility_Id=\"+this.document.forms[0].Facility_id.value+\"&Msg_Id=\"+this.document.forms[0].msg_id.value+\"&qryid=\"+this.document.forms[0].QUERYID.value+\"&Even_type=\"+this.document.forms[0].event_type.value+\"&protocol_link_id=\"+this.document.forms[0].Protocollink_id.value+\"&STATUSTEXT=\"+escape(this.document.forms[0].STATUSTEXT.value)+\"&application_Msg=\"+escape(appl_msg)+\"&Error_msg=\"+escape(err_msg)+\"&qapplname=\"+this.document.forms[0].qapplname.value+\"&faciname=\"+this.document.forms[0].qfacility.value+\"&qmsg_dt1=\"+this.document.forms[0].qmsg_dt1.value+\"&qmsg_dt2=\"+this.document.forms[0].qmsg_dt2.value+\"&msg_status=\"+document.forms[0].msg_status.value+\"&purge_status=\"+this.document.forms[0].purge_status.value+\"&Query_Option=\"+this.document.forms[0].qostatus.value,arguments,features);*/\n\n/*parent.document.location.href=\"../../eXH/jsp/ViewQryMsgFooterMasterMain.jsp?application_Id=\"+this.document.forms[0].Application_id.value+\"&Facility_Id=\"+this.document.forms[0].Facility_id.value+\"&Msg_Id=\"+this.document.forms[0].msg_id.value+\"&qryid=\"+this.document.forms[0].QUERYID.value+\"&Even_type=\"+this.document.forms[0].event_type.value+\"&protocol_link_id=\"+this.document.forms[0].Protocollink_id.value+\"&STATUSTEXT=\"+escape(this.document.forms[0].STATUSTEXT.value)+\"&application_Msg=\"+escape(appl_msg)+\"&Error_msg=\"+escape(err_msg)+\"&qapplname=\"+this.document.forms[0].qapplname.value+\"&faciname=\"+this.document.forms[0].qfacility.value+\"&qmsg_dt1=\"+this.document.forms[0].qmsg_dt1.value+\"&qmsg_dt2=\"+this.document.forms[0].qmsg_dt2.value+\"&msg_status=\"+document.forms[0].msg_status.value+\"&purge_status=\"+this.document.forms[0].purge_status.value+\"&Query_Option=\"+this.document.forms[0].qostatus.value,arguments,features*/\n\n}\n</script>\n<input  type=\"hidden\" name=msg_status value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' /> \n<input type=\"hidden\" name=\"purge_status\" id=\"purge_status\" id=\"purge_status\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'/>\n<input type=\"hidden\" name=\"action_type\" id=\"action_type\" id=\"action_type\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'/>\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle	="IeStyle.css";
//String function_id = (String)request.getParameter("function_id");
String qry_id ="";
//Properties p = (Properties) session.getValue("jdbc");
//String loggedUser = p.getProperty("login_user");
//String commType = request.getParameter("commType");
   
String purge_status=request.getParameter("purge_status"); 
String msg_status=request.getParameter("msg_status");
  String QueryOption=XHDBAdapter.checkNull(request.getParameter("Query_Option"));
String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
  String qapplname=request.getParameter("application_Id");
String pagechange=XHDBAdapter.checkNull(request.getParameter("pagechange"));
 String qfacility=request.getParameter("Facility_Id");

 //System.out.println("qapplname :"+qapplname+"qfacility :"+qfacility);
  ArrayList arrCol = null;
  String qryid=XHDBAdapter.checkNull(request.getParameter("qryid"));
  String action_type=XHDBAdapter.checkNull(request.getParameter("action_type"));
//System.out.println("qryid 29:"+qryid);
  HashMap resultsQry=null; 
  //HashMap resultsQry1=null;
  ArrayList arrRow = null;
  String tableNameSuffix="";
  String whereClause="";
String strPrevious ="";
String strNext="";
  Connection conn=null;
  try
	{
		conn = ConnectionManager.getConnection(request);
	

  if(QueryOption.equals("P"))
  {
		qry_id = "VIEWADMINQUERYPROCESS";
  }
  else if(QueryOption.equals("A"))
  {
		qry_id = "VIEWADMINQUERYINITIATE";
  }
  else
  {
       qry_id = "VIEWADMINQUERYPROCESS";  
  }



if(purge_status != null && !purge_status.equals(""))
	{
	 if(purge_status.equals("purge")) 
	 {
		tableNameSuffix = "XH_PURGE_APPL_QRY_MSG_VW A  WHERE    a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qfacility+"',A.FACILITY_ID)   AND";
	 }
	 else if(purge_status.equals("offline"))
	 {
		 	tableNameSuffix = "XH_OFFLINE_APPL_QRY_MSG_VW A  WHERE    a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qfacility+"',A.FACILITY_ID)   AND";
	 }
	}
	else 
	{
		tableNameSuffix = "XH_APPLICATION_QRY_MSG_VW A  WHERE    a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qapplname+"',A.FACILITY_ID) "; 
	} 


	if((qryid != null) && (!(qryid.equals(""))))			
	{
		whereClause =whereClause +"AND A.QUERY_ID = nvl('"+qryid+"',A.QUERY_ID) order by A.QUERY_ID"; 
	} 

  request.setAttribute("tableName",tableNameSuffix); 
  //System.out.println("QueryOption"+QueryOption);
  request.setAttribute("qry_id",qry_id);  
  request.setAttribute("whereClause",whereClause);
  request.setAttribute("maxRec","1"); 
  request.setAttribute("qryid",qryid); 
  XHViewQueryControllerElementBean	xhBean =
  XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
  resultsQry = xhBean.getPositionRecord(posi);
	arrRow = (ArrayList)resultsQry.get("qry_result"); 
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 

    

//System.out.println("boolNext "+boolNext+"boolPrevious "+boolPrevious); 
 // resultsQry1 = xhBean.getResultSet(); 
// arrRow = (ArrayList)resultsQry1.get("qry_result");
	  if (boolPrevious == true)
	  {
		strPrevious = " ";
	  }
	  else
	  {
		strPrevious = "disabled";
	  }
	  if (boolNext== true)
	  {
		strNext  = " ";
	  }
	  else
	  {
		strNext  = "disabled";
	  }
	}
	catch(Exception e)
	{
		System.out.println("ViewQueryNextPreviousPage.jsp:Exception "+e);
	}
	finally
	{
		if(conn != null) ConnectionManager.returnConnection(conn);
	}
//System.out.println("strNext :"+strNext);
//System.out.println("strPrevious :"+strPrevious);

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(pagechange));
            _bw.write(_wl_block5Bytes, _wl_block5);


for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j);
  	//System.out.println("129 :"+arrCol.get(29));


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(((String)arrCol.get(2))));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((String)arrCol.get(28)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String)arrCol.get(19)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)arrCol.get(22)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)arrCol.get(12))+""));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)arrCol.get(23)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)arrCol.get(24)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(QueryOption));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)arrCol.get(25)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)arrCol.get(26)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(arrCol.get(29)));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(msg_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
