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

public final class __vieweventinboundnextpreviouspage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewEventInboundNextPreviousPage.jsp", 1709122399084L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<HEAD> \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<input type=\"hidden\" name=\"pagechange\" id=\"pagechange\" id=\"pagechange\" value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<input type=\"hidden\" name=\"applicationID\" id=\"applicationID\" id=\"applicationID\" VALUE=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' />\n<input type=\"hidden\" name=\"applicationName\" id=\"applicationName\" value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' />\n<input type=\"hidden\" name=\"facilityID\" id=\"facilityID\" id=\"facilityID\" VALUE=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' />\n<input type=\"hidden\" name=\"facilityName\" id=\"facilityName\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' />\n<input type=\"hidden\" name=\"msgID\" id=\"msgID\" id=\"msgID\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n<input type=\"hidden\" name=\"even_type\" id=\"even_type\" id=\"even_type\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'/> \n<input type=\"hidden\" name=\"protocol_link_id\" id=\"protocol_link_id\" id=\"protocol_link_id\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'/>\n<input type=\"hidden\" name=\"srlNo\" id=\"srlNo\" id=\"srlNo\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'/>\n<input type=\"hidden\" name=\"position\" id=\"position\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' /> \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></link>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/ViewEventsFooter.js\" ></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\'formload()\'>\n<form name=\"application_setup_base_form\" id=\"application_setup_base_form\"  method=\"POST\"   action=\'\'>\n<table width=\"100%\">\n<tr><td colspan=6 align=\'right\'><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'|<\' name=\"firstrecord\" id=\"firstrecord\" id=\"firstrecord\" onClick=\"funAction(\'F\')\"><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'<<\'  onClick=\"funAction(\'P\')\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'>>\'  onClick=\"funAction(\'N\')\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\'button\' class=\'button\' value=\'>|\' name=\"lastrecord\" id=\"lastrecord\" onClick=\"funAction(\'L\')\"></td></tr>\t\n</table>\n<input type=\"hidden\" name=\"purge_status\" id=\"purge_status\" id=\"purge_status\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'/>\n<input type=\"hidden\" name=\"protocolMode\" id=\"protocolMode\" id=\"protocolMode\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'/>\n<input type=\"hidden\" name=\"action_type\" id=\"action_type\" id=\"action_type\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'/>\n<input type=\"hidden\" name=\"sub_module\" id=\"sub_module\" id=\"sub_module\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'/>\n<input type=\"hidden\" name=\"whereclause\" id=\"whereclause\" id=\"whereclause\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'/>\n<script>  \nfunction formload()\n{\n\tif(document.getElementById(\"pagechange\").value==\'N\')\n\t{\n\n\n\t} \n\telse\n\t{\n\t\tdocument.getElementById(\"pagechange\").value=\'N\';\t\n\t\tvar applicaionID=document.getElementById(\"applicationID\").value\n\t\tvar facilityId=this.document.getElementById(\"facilityID\").value;\n\t\tvar msgID=this.document.getElementById(\"msgID\").value;\n\t\tvar eventType=this.document.getElementById(\"even_type\").value;\n\t\tvar protocol_link_id=this.document.getElementById(\"protocol_link_id\").value;\n\t\tvar applicationName=escape(this.document.getElementById(\"applicationName\").value);\n\t\tvar facilityName=escape(this.document.getElementById(\"facilityName\").value);\n\t\tvar purge_status=this.document.getElementById(\"purge_status\").value;\n\t\tvar position=parseInt(this.document.getElementById(\"position\").value);\n\t\tvar protocolMode=this.document.getElementById(\"protocolMode\").value;\n\t\tvar sub_module=this.document.getElementById(\"sub_module\").value;\n\t\tvar srlNo=document.getElementById(\"srlNo\").value;\n\t\tvar posi=position;\n\t\tvar typ=this.document.getElementById(\"action_type\").value;\n\t\tif(typ==\'L\')\n\t\t{\n\t\t\tdocument.getElementById(\"lastrecord\").disabled=true;\n\t\t\tvar url=\"applicationID=\"+applicaionID+\n\t\t\t\t\t\"&facilityID=\"+facilityId+\n\t\t\t\t\t\"&msgID=\"+msgID+\n\t\t\t\t\t\"&facilityName=\"+facilityName+ \n\t\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\t\"&protocolMode=\"+protocolMode+\n\t\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t \t\"&srlNo=\"+srlNo+\"&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+posi+\"&protocolMode=\"+protocolMode+\"&action_type=L&pagechange=\"+document.getElementById(\"pagechange\").value+\"&wherecaluse=\"+document.getElementById(\"whereclause\").value; \n\t\t\t\t\tparent.parent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventsInboundReview.jsp?\'+url; \n\t\t}\n\t\telse if(typ==\'F\')\n\t\t{\n\t\t\tdocument.getElementById(\"firstrecord\").disabled=true;\n\t\t\tvar url=\"applicationID=\"+applicaionID+\n\t\t\t\t\t\"&facilityID=\"+facilityId+ \n\t\t\t\t\t\"&msgID=\"+msgID+\n\t\t\t\t\t\"&facilityName=\"+facilityName+\n\t\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\t\"&protocolMode=\"+protocolMode+\n\t\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t\t\"&srlNo=\"+srlNo+\"&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+posi+\"&protocolMode=\"+protocolMode+\"&action_type=F&pagechange=\"+document.getElementById(\"pagechange\").value+\"&wherecaluse=\"+document.getElementById(\"whereclause\").value; \n\t\t\tparent.parent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventsInboundReview.jsp?\'+url;\n\t\t}\n\t\telse \n\t\t{\n\n\t\t\tvar url=\"applicationID=\"+applicaionID+ \n\t\t\t\t\t\t\t\"&facilityID=\"+facilityId+\n\t\t\t\t\t\t\t\"&msgID=\"+msgID+\n\t\t\t\t\t\t\t\"&facilityName=\"+facilityName+\n\t\t\t\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\t\t\t\"&protocolMode=\"+protocolMode+\n\t\t\t\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t\t\"&srlNo=\"+srlNo+\"&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+posi+\"&action_type=Q&pagechange=\"+document.getElementById(\"pagechange\").value+\"&wherecaluse=\"+document.getElementById(\"whereclause\").value; \n\t\t\tparent.parent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventsInboundReview.jsp?\'+url;\n\t\t}\n\n\t}\n}\n//******************************************************************************************\nfunction funAction(typ)\n{\n\tif(typ==\'L\')\n    { \n\n\t\tdocument.getElementById(\"action_type\").value = \"L\";\n\t\tvar act = \'../../eXH/jsp/ViewEventInboundNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value+\"&whereClause=\"+document.getElementById(\"whereclause\").value;\n\t\tthis.document.forms[0].action = act;\n\t\tthis.document.forms[0].target=\"f_query_\";\n\t\tthis.document.forms[0].submit();\n\t} \n\telse if(typ==\'F\')\n\t{\n\t\tdocument.getElementById(\"action_type\").value = \"F\";\n\t\tvar act = \'../../eXH/jsp/ViewEventInboundNextPreviousPage.jsp?action_type=\'+document.getElementById(\"action_type\").value+\"&whereClause=\"+document.getElementById(\"whereclause\").value;\n\t\tthis.document.forms[0].action = act;\n\t\tthis.document.forms[0].target=\"f_query_\"; \n\t\tthis.document.forms[0].submit();\n\n\t}\n\telse \n\t{ \n\t\tdocument.getElementById(\"action_type\").value = \"A\";\n\t\tvar applicaionID=document.getElementById(\"applicationID\").value\n\t\tvar facilityId=this.document.getElementById(\"facilityID\").value;\n\t\tvar msgID=this.document.getElementById(\"msgID\").value;\n\t\tvar eventType=this.document.getElementById(\"even_type\").value;\n\t\tvar protocol_link_id=this.document.getElementById(\"protocol_link_id\").value;\n\t\tvar applicationName=escape(this.document.getElementById(\"applicationName\").value);\n\t\tvar facilityName=escape(this.document.getElementById(\"facilityName\").value);\n\t\tvar purge_status=this.document.getElementById(\"purge_status\").value;\n\t\tvar position=parseInt(this.document.getElementById(\"position\").value);\n\t\tvar protocolMode=this.document.getElementById(\"protocolMode\").value;\n\t\tvar sub_module=this.document.getElementById(\"sub_module\").value;\n\t\tvar srlNo=document.getElementById(\"srlNo\").value;\n\t\tvar posi=\"\";\n\t\tif(typ==\"N\")\n\t\t{\n\t\t\tvar position=parseInt(this.document.getElementById(\"position\").value);\n\t\t\tposition=position+1;\n\t\t\tposi=position;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar position=parseInt(this.document.getElementById(\"position\").value);\n\t\t\tposition=position-1;\n\t\t\tposi=position;\n\t\t}\n\t\tvar url=\"applicationID=\"+applicaionID+\n\t\t\t\t\t\"&facilityID=\"+facilityId+\n\t\t\t\t\t\"&msgID=\"+msgID+\n\t\t\t\t\t\"&facilityName=\"+facilityName+\n\t\t\t\t\t\"&applicationName=\"+applicationName+\n\t\t\t\t\t\"&protocolMode=\"+protocolMode+\n\t\t\t\t\t\"&sub_module=\"+sub_module+\t\t\t\"&srlNo=\"+srlNo+\"&protocol_link_id=\"+protocol_link_id+\"&purge_status=\"+purge_status+\"&even_type=\"+eventType+\"&posi=\"+posi+\"&action_type=A&pagechange=Y\"+\"&whereClause=\"+document.getElementById(\"whereclause\").value; \n\tparent.frames[0].document.location.href=\'../../eXH/jsp/ViewEventInboundNextPreviousPage.jsp?\'+url; \n}\n  \n} \n</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
  
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle	="IeStyle.css";
//String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
//String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
//String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
//String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));				 
//String eventType = request.getParameter("even_type");
//String applicationName = XHDBAdapter.checkNull(request.getParameter("applicationName"));
//String facilityName = XHDBAdapter.checkNull(request.getParameter("facilityName"));
//String srlNo=XHDBAdapter.checkNull(request.getParameter("srlNo")); 
String pagechange=XHDBAdapter.checkNull(request.getParameter("pagechange"));					  
String action_type=XHDBAdapter.checkNull(request.getParameter("action_type"));					  
String whereClause=XHDBAdapter.checkNull(request.getParameter("whereClause"));   
 


HashMap resultsQry=null; 
Connection conn=null;
ArrayList arrRow = null;
String tableNameSuffix=""; 
String strPrevious ="";
String strNext="";
ArrayList arrCol = null;  
  try
{     
 

conn = ConnectionManager.getConnection(request);
if(purge_status != null && !purge_status.equals(""))
{
tableNameSuffix = sub_module+"_"+purge_status+"_INBOUND_MESSAGE_vw X ";
}
else
{
tableNameSuffix = sub_module+"_INBOUND_MESSAGE_VW X ";
}
String posi=XHDBAdapter.checkNull(request.getParameter("posi"));



request.setAttribute("tableName",tableNameSuffix);   
request.setAttribute("qry_id","VIEW_INBOUND_EVENTS");    
request.setAttribute("whereClause",whereClause); 
request.setAttribute("maxRec","20"); 
request.setAttribute("maxRec","1");  
XHViewInboundControllerElementBean	xhBean =
XHViewInboundControllerElementBean.getBean(XHViewInboundControllerElementBean.strBeanName,request,session);
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
		System.out.println("(Exception:ViewEventInboundNextPreviousPage.jsp) "+e);
	}

	finally{
	
   ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(pagechange));
            _bw.write(_wl_block4Bytes, _wl_block4);


for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf((String)arrCol.get(1)));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((String)arrCol.get(2)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(((String)arrCol.get(24))));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((String)arrCol.get(35)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((String)arrCol.get(3)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String)arrCol.get(15)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)arrCol.get(23)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)arrCol.get(36)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(arrCol.get(37)));
            _bw.write(_wl_block14Bytes, _wl_block14);
}   

/*resultsNxtQry=xhBean.getNextPositionRecord();
ArrayList arrRowNext = (ArrayList)resultsQry.get("qry_result"); 
ArrayList arrColNext=new ArrayList();
boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
for (int j=0; j<arrRow.size();j++)
{
	 arrCol = (ArrayList)arrRow.get(j);
}*/

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(protocolMode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(whereClause)));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
