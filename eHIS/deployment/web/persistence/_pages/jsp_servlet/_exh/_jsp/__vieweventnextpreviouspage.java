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

public final class __vieweventnextpreviouspage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewEventNextPreviousPage.jsp", 1709122399756L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HEAD> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<input type=\"hidden\" name=\"pagechange\" id=\"pagechange\" id=\"pagechange\" value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<input type=\"hidden\" name=\"applicationID\" id=\"applicationID\" id=\"applicationID\" VALUE=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' />\n<input type=\"hidden\" name=\"applicationName\" id=\"applicationName\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' />\n<input type=\"hidden\" name=\"facilityID\" id=\"facilityID\" id=\"facilityID\" VALUE=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' />\n<input type=\"hidden\" name=\"facilityName\" id=\"facilityName\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' />\n<input type=\"hidden\" name=\"msgID\" id=\"msgID\" id=\"msgID\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/> \n\n<input type=\"hidden\" name=\"even_type\" id=\"even_type\" id=\"even_type\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'/>\n<input type=\"hidden\" name=\"protocol_link_id\" id=\"protocol_link_id\" id=\"protocol_link_id\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'/>\n<input type=\"hidden\" name=\"position\" id=\"position\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' /> \n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\n\n\n\n\n\n\n \n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'></link>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/ViewEventsFooter.js\" ></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\'formload()\'>\n<form name=\"application_setup_base_form\" id=\"application_setup_base_form\"  method=\"POST\"   action=\'\'>\n<table width=\"100%\">\n\n<tr><td colspan=6 align=\'right\'><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'|<\' name=\"firstrecord\" id=\"firstrecord\" id=\"firstrecord\" onClick=\"funAction(\'F\')\"><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'<<\'  onClick=\"funAction(\'P\')\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'>>\'  onClick=\"funAction(\'N\')\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'>|\' name=\"lastrecord\" id=\"lastrecord\" onClick=\"funAction(\'L\')\"></td></tr>\t\n</table>\n\n<input type=\"hidden\" name=\"purge_status\" id=\"purge_status\" id=\"purge_status\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'/>\n<input type=\"hidden\" name=\"protocolMode\" id=\"protocolMode\" id=\"protocolMode\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'/>\n<input type=\"hidden\" name=\"action_type\" id=\"action_type\" id=\"action_type\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'/>\n<input type=\"hidden\" name=\"sub_module\" id=\"sub_module\" id=\"sub_module\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'/>\n\n<input type=\"hidden\" name=\"whereclause\" id=\"whereclause\" id=\"whereclause\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'/>\n\n\n\n   \n\n\n\n\n<script>  \n\nfunction formload()\n{\nif(document.getElementById(\"pagechange\").value==\'N\')\n{\n\n\n}\nelse\n{\n\t\n\n\tdocument.getElementById(\"pagechange\").value=\'N\';\t\nvar applicaionID=document.getElementById(\"applicationID\").value;\nvar facilityId=this.document.getElementById(\"facilityID\").value;\nvar msgID=this.document.getElementById(\"msgID\").value;\nvar eventType=this.document.getElementById(\"even_type\").value;\nvar protocol_link_id=this.document.getElementById(\"protocol_link_id\").value;\nvar applicationName=escape(this.document.getElementById(\"applicationName\").value);\nvar facilityName=escape(this.document.getElementById(\"facilityName\").value);\nvar purge_status=this.document.getElementById(\"purge_status\").value;\nvar position=parseInt(this.document.getElementById(\"position\").value);\nvar protocolMode=this.document.getElementById(\"protocolMode\").value;\nvar sub_module=this.document.getElementById(\"sub_module\").value;\nvar posi=position;\n\tvar typ=this.document.getElementById(\"action_type\").value;\n\tif(typ==\'L\')\n    {\n\tthis.document.getElementById(\"lastrecord\").disabled=true;\n\n\t\n\t\tvar url=\"applicationID=\"+applicaionID+\n\t\t\t\t\"&facilityID=\"+facilityId+\n\t\t\t\t\"&msgID=\"+msgID+\n\t\t\t\t\"&facilityName=\"+facilityName+\n\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\"&protocolMode=\"+protocolMode+\n\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t\t\"&srlNo=&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+(posi-1)+\"&protocolMode=\"+protocolMode+\"&action_type=L&pagechange=\"+document.getElementById(\"pagechange\").value+\"&wherecaluse=\"+document.getElementById(\"whereclause\").value;\n\t\t\t\t\n\t\t//parent.frames[1].document.location.href=\'../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?\'+url;\n\t\tparent.parent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?\'+url;\n//var url2=\"appl_name=\"+applicationID.value+\"&facility=\"+facilityID.value+\"&msg_id=\"+msgID+\"&event_type=\"+eventType+\"&purge_status=\"+purge_status+\"&commMode=\"+protocolMode+\"&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en\";\n\n//parent.frames[2].document.location.href=\"../../eXH/jsp/ViewMsgReviewAuditLog.jsp?\"+url2;\n\n\n\n\t}\n\telse if(typ==\'F\')\n\t{\n\t\t\n\t\tthis.document.getElementById(\"firstrecord\").disabled=true;\n\t\tvar url=\"applicationID=\"+applicaionID+\n\t\t\t\t\"&facilityID=\"+facilityId+\n\t\t\t\t\"&msgID=\"+msgID+\n\t\t\t\t\"&facilityName=\"+facilityName+\n\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\"&protocolMode=\"+protocolMode+ \n\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t \t\"&srlNo=&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+posi+\"&protocolMode=\"+protocolMode+\"&action_type=F&pagechange=\"+document.getElementById(\"pagechange\").value+\"&wherecaluse=\"+document.getElementById(\"whereclause\").value; \n\t\t\nparent.parent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?\'+url;\n\n/*parent.frames[1].document.location.href=\'../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?\'+url;\nvar url2=\"appl_name=\"+applicationID.value+\"&facility=\"+facilityID.value+\"&msg_id=\"+msgID+\"&event_type=\"+eventType+\"&purge_status=\"+purge_status+\"&commMode=\"+protocolMode+\"&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en\";\nparent.frames[2].document.location.href=\"../../eXH/jsp/ViewMsgReviewAuditLog.jsp?\"+url2;*/\n\t}\n\telse\n\t{  \n\t\t\n\t\t var url=\"applicationID=\"+applicaionID+\n\t\t\t\t\"&facilityID=\"+facilityId+\n\t\t\t\t\"&msgID=\"+msgID+ \n\t\t\t\t\"&facilityName=\"+facilityName+\n\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\"&protocolMode=\"+protocolMode+\n\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t \t\"&srlNo=&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+posi+\"&action_type=Q&pagechange=\"+document.getElementById(\"pagechange\").value+\"&wherecaluse=\"+document.getElementById(\"whereclause\").value; \n//parent.frames[1].document.location.href=\'../../eXH/jsp/ViewEventExceptionsHeaderMain.jsp?\'+url;\n\nparent.parent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventsInboundOutboundReviewMain.jsp?\'+url;\nvar url2=\"appl_name=\"+applicationID.value+\"&facility=\"+facilityID.value+\"&msg_id=\"+msgID+\"&event_type=\"+eventType+\"&purge_status=\"+purge_status+\"&commMode=\"+protocolMode+\"&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en\";\n\n\n//parent.frames[2].document.location.href=\"../../eXH/jsp/ViewMsgReviewAuditLog.jsp?\"+url2;\n\t}\n\n}\n}\n//******************************************************************************************\nfunction funAction(typ)\n{\n\tif(typ==\'L\')\n    {\n\n\t\tdocument.getElementById(\"action_type\").value = \"L\";\n       var act = \'../../eXH/jsp/ViewEventNextPreviousPage.jsp?action=\'+document.getElementById(\"action_type\").value+\"&whereClause=\"+document.getElementById(\"whereclause\").value;\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\"f_query_\";  \n\tthis.document.forms[0].submit();\n\n/*parent.frames[0].document.location.href=\'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value;*/\n\n\t} \n\telse if(typ==\'F\')\n\t{ \n\t\tdocument.getElementById(\"action_type\").value = \"F\";\n\t\t var act = \'../../eXH/jsp/ViewEventNextPreviousPage.jsp?action=\'+document.getElementById(\"action_type\").value+\"&whereClause=\"+document.getElementById(\"whereclause\").value;\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\"f_query_\"; \n\tthis.document.forms[0].submit();\n/*parent.frames[0].document.location.href=\'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value;*/\n\t}\n\telse\n\t{\n\tdocument.getElementById(\"action_type\").value = \"A\";\nvar applicaionID=document.getElementById(\"applicationID\").value; \nvar facilityId=this.document.getElementById(\"facilityID\").value;\nvar msgID=this.document.getElementById(\"msgID\").value;\nvar eventType=this.document.getElementById(\"even_type\").value;\nvar protocol_link_id=this.document.getElementById(\"protocol_link_id\").value;\nvar applicationName=escape(this.document.getElementById(\"applicationName\").value);\nvar facilityName=escape(this.document.getElementById(\"facilityName\").value);\nvar purge_status=this.document.getElementById(\"purge_status\").value;\nvar position=parseInt(this.document.getElementById(\"position\").value);\nvar protocolMode=this.document.getElementById(\"protocolMode\").value;\nvar sub_module=this.document.getElementById(\"sub_module\").value;\nvar posi=\"\";\nif(typ==\"N\")\n{\nvar position=parseInt(this.document.getElementById(\"position\").value);\nposition=position+1;\nposi=position;\n}\nelse\n{\nvar position=parseInt(this.document.getElementById(\"position\").value);\nposition=position-1;\nposi=position;\n\t} \n\n//alert(\"on click\"+posi);\nvar url=\"applicationID=\"+applicaionID+\n\t\t\t\t\"&facilityID=\"+facilityId+\n\t\t\t\t\"&msgID=\"+msgID+\n\t\t\t\t\"&facilityName=\"+facilityName+\n\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\"&protocolMode=\"+protocolMode+\n\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t\"&srlNo=&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+posi+\"&action_type=A&pagechange=Y\"+\"&whereClause=\"+document.getElementById(\"whereclause\").value; \nparent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventNextPreviousPage.jsp?\'+url;\n\t/*var act = \'../../eXH/jsp/ViewQueryNextPreviousPage.jsp?\'+url;\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'\';\n\tthis.document.forms[0].submit(); */\n\t}\n\n}\n\n\n function windowclose()\n{\n\n\n\n\n\n\n\n\n\n}\n</script>\n\n\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
  
String sStyle =   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
sStyle="IeStyle.css";
//String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
//String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
///String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
//String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module")); 
String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode")); 
//String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
//String eventType = request.getParameter("even_type");															  
//String applicationName = XHDBAdapter.checkNull(request.getParameter("applicationName"));
//String facilityName = XHDBAdapter.checkNull(request.getParameter("facilityName"));
String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause")); 
//System.out.println("whereClause ViewEventNextPreviousPage.jsp :"+whereClause);
																													  
String pagechange=XHDBAdapter.checkNull(request.getParameter("pagechange"));
String action_type=XHDBAdapter.checkNull(request.getParameter("action_type"));

HashMap resultsQry=null;  
  //HashMap resultsQry1=null;
  ArrayList arrRow = null;
  String tableNameSuffix=""; 
  Connection conn=null;
String strPrevious ="";
String strNext="";
 ArrayList arrCol = null; 
  try
{ 
 


	conn = ConnectionManager.getConnection(request);
				if(purge_status != null && !purge_status.equals(""))
		{
			tableNameSuffix = sub_module+"_"+purge_status+"_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		}
		else
		{
			tableNameSuffix = sub_module+"_EVENT_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		} 
		String posi=XHDBAdapter.checkNull(request.getParameter("posi"));
		
 request.setAttribute("tableName",tableNameSuffix); 
 
  request.setAttribute("qry_id","VIEW_GENERAL_EVENTS");   
 request.setAttribute("whereClause",whereClause);														   
 request.setAttribute("maxRec","1"); 
  XHViewQueryControllerElementBean	xhBean =
  XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
	
 resultsQry  = xhBean.getPositionRecord(posi); 
  arrRow = (ArrayList)resultsQry.get("qry_result"); 

	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
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
		System.out.println("Exception "+e);
	}
	finally
	{
		if(conn != null) ConnectionManager.returnConnection(conn);
	}


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(pagechange));
            _bw.write(_wl_block7Bytes, _wl_block7);


for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j);
 


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((String)arrCol.get(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(((String)arrCol.get(8))));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)arrCol.get(7)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)arrCol.get(2)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)arrCol.get(4)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)arrCol.get(25)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrCol.get(29)));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(protocolMode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(whereClause)));
            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
