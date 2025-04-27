package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import eXH.XHReturnArray;
import java.util.*;
import com.ehis.util.*;

public final class __reviewapplmessageinboundmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ReviewApplMessageInboundMenu.jsp", 1709122387913L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<BODY OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"menu_tree\" id=\"menu_tree\">\n<input type=\'hidden\' name=\'appl_name\' id=\'appl_name\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=\'hidden\' name=\'appdes\' id=\'appdes\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\'hidden\' name=\'client_id\' id=\'client_id\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=\'hidden\' name=\'msg_id\' id=\'msg_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'msg_date\' id=\'msg_date\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'msg_status\' id=\'msg_status\'value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<div class=\'dtree\'>\n<script type=\'text/javascript\' src=\'../../eXH/js/dtree.js\'></script></head>\n<script type=\'text/javascript\'>\n\td = new dTree(\'d\');\n\td.config.useStatusText=true;\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body class=\'TREEBODY\' >\n\n<script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\ndocument.write(d);\nd.openAll();\nparent.expand();\n</script>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<script>\nalert(getMessage(\'XH1021\',\'XH\'));\n</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<form>\n</body>\n</div>\n</HTML>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String appl_name = request.getParameter("appl_name");
	String appdes = request.getParameter("appdes");
	String client_id = request.getParameter("client_id");
	String msgg_id = request.getParameter("msg_id");
	String msg_date = request.getParameter("msg_date");
	String mode = request.getParameter("mode");
   	 if(mode.equalsIgnoreCase("F")){
	if(locale.equalsIgnoreCase("th")) msg_date=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","th","en");
   }
	String msg_status = request.getParameter("msg_status");
 String sRespName="Message Tree";
String msg[][]=null;
String msgid[][]=null;
String client_ida[][]=null;
Connection con = ConnectionManager.getConnection(request);
try{
  	XHReturnArray arr=new XHReturnArray();
	if(client_id.equals(""))
	{ 
		client_ida=arr.getClient_id(con,appl_name,client_id,msg_date,msgg_id,msg_status,locale);
		if(client_ida.length!=0) client_id=client_ida[0][0];
		else client_id="Not defined";
    }
	if(mode.equalsIgnoreCase("S"))
    {
	msg=arr.returnInbound(con,appl_name,client_id,msg_date,"",msg_status,locale);}
	else {
	
		msg=arr.returnInbound(con,appl_name,client_id,msg_date,msgg_id,msg_status,locale);

	}
	msgid=arr.returnInboundmsgid(con,appl_name,client_id,msg_date,msgg_id,msg_status,locale);

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(appl_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appdes));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(client_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(msgg_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(msg_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(msg_status));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block15Bytes, _wl_block15);

if(msg.length!=0){

//***********************************************************************************************************
//***********************************************************************************************************
if(mode.equalsIgnoreCase("F"))
{
msg=arr.returnInbound(con,appl_name,client_id,"","","",locale); 

out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+client_id+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+appdes+"','','Dir Menu','');"); 

if(!msg_date.equals(""))
{     String tempdate=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","en",locale);
 	  out.println("d.add(3,2,'"+tempdate+"','','Dir Menu','');"); 
      if(!msgg_id.equals(""))
      {
         out.println("d.add(4,3,'"+msgg_id+"',\"javascript:callmsgTextmsg('"+msgg_id+"','"+msgg_id+"')\" );");
	  }	 
      else
      {
         if(msgid!=null){
		 for(int i=0;i<msgid.length;i++)
         { 
        out.println("d.add("+(4+i)+","+(3)+",'"+msgid[i][0]+"',\"javascript:callmsgTextmsg('"+msgid[i][1]+"','"+msgid[i][0]+"')\" );");
         }
		 }

      }

}
else
{
    	
  for(int i=0;i<msg.length;i++)
  { 
     String tempdate=com.ehis.util.DateUtils.convertDate(msg[i][0],"DMY","en",locale);
   out.println("d.add("+(3+i)+","+(2)+",'"+tempdate+"',\"javascript:callmsgIdIN('"+msg[i][1]+"','"+msg[i][0]+"')\" );");
  }
}
}

if(mode.equalsIgnoreCase("S"))
{
msg=arr.returnInbound(con,appl_name,client_id,"","","",locale); 
msgid=arr.returnInboundmsgid(con,appl_name,client_id,msg_date,"","",locale); 
out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+client_id+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+appdes+"','','Dir Menu','');"); 
int temp=0;
for(int i=0;i<msg.length;i++)
{ 
  
   if(msg[i][1].equalsIgnoreCase(msg_date))
   { 
         String tempdate=com.ehis.util.DateUtils.convertDate(msg[i][0],"DMY","en",locale);
	  out.println("d.add("+(3+i)+","+(2)+",'"+tempdate+"','','Dir Menu','');"); 
      for(int j=0;j<msgid.length;j++)
      { 
        	 
		out.println("d.add("+(4+i+j)+","+(3+i)+",'"+msgid[j][0]+"',\"javascript:callmsgTextmsg('"+msgid[j][0]+"','"+msgid[j][0]+"')\" );");
		temp=4+j;
      }
  
   }
   else
	{  int tval=0;
	   if (temp==0) tval=3+i;
       else tval=temp+i+1;
         String tempdate=com.ehis.util.DateUtils.convertDate(msg[i][0],"DMY","en",locale);
      out.println("d.add("+(tval)+","+(2)+",'"+tempdate+"',\"javascript:callmsgIdIN('"+msg[i][1]+"','"+msg[i][0]+"')\" );");

	
	}
}
}

}
//***************************************************************************

            _bw.write(_wl_block2Bytes, _wl_block2);
}	catch (Exception e) {
		out.println(e) ;
		e.printStackTrace(System.err) ;
	}
		finally {
			
			ConnectionManager.returnConnection(con) ;
		}
//***************************************************************************

            _bw.write(_wl_block16Bytes, _wl_block16);
 if(msg.length==0){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
 }
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
