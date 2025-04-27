package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import oracle.sql.ARRAY;
import eXH.XHIdentify;

public final class __viewinteractivetree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewInteractiveTree.jsp", 1709122405084L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!--head-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/dtree.css\" type=\"text/css\" />\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/lris_style.css\" type=\"text/css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/dtree1.js\"></script>\n\t<script language=\"javascript\" src=\"../../eXH/js/Viewtreeimage2.js\" ></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<script>\n\t\n\t</script>\n</head>\n<BODY   >\n<form name=\"view_segment_form\" id=\"view_segment_form\">\n<input type=hidden name=\'Req_symbols\' id=\'Req_symbols\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' >\n<input type=hidden name=\'Req_type\' id=\'Req_type\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n<input type=hidden name=\'Req_txt\' id=\'Req_txt\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n<input type=hidden name=\'ReQ_Syn\' id=\'ReQ_Syn\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n<input type=hidden name=\'Res_txt\' id=\'Res_txt\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n<input type=hidden name=\'Res_syn\' id=\'Res_syn\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' >\n\n\n<script>  \n\n\n\n\n\tsubmitForm();\n\n\t\n</script>\n</form>\n\n</BODY>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
/*
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
*/

            _bw.write(_wl_block2Bytes, _wl_block2);

Connection connection = null;
CallableStatement ostmt = null;

String msgId="";

String ProfileID="";
String res_txt="";
String ReqText="";

String Req_syntax="";
String REs_Syn="";

String Standard_type="";
String Standard_symbols="";

String ReqText1="",Req_syntax1="",res_txt1="",REs_Syn1="";
ProfileID=request.getParameter("Profile_id");
Statement s=null;
  ResultSet r = null;
msgId=(String)session.getAttribute("Msg_Id");
//System.out.println("'Msg_Id38"+msgId+"ProfileID"+ProfileID);
try
	{
	if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try
{
	s= connection.createStatement();
//System.out.println("select REQUEST_TEXT, REQUEST_SYNTAX, RESPONSE_TEXT, REPONSE_SYNTAX from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+msgId+"'");

 r = s.executeQuery("select REQUEST_TEXT, REQUEST_SYNTAX, RESPONSE_TEXT, REPONSE_SYNTAX from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+msgId+"'");
 while(r.next())
	{


ReqText=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(1)));

ReqText1=ReqText;

Req_syntax=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(2)));
Req_syntax1=Req_syntax;
res_txt=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(3)));
res_txt1=res_txt;
REs_Syn=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(4)));
REs_Syn1=REs_Syn;
	}   
//System.out.println("ReqText70"+ReqText1+"Req_syntax70"+Req_syntax1+"res_txt"+res_txt1+"REs_Syn"+REs_Syn1);
r.close() ;
 s.close();


ostmt = connection.prepareCall("{ call XHSTANDARD.Fetch_standard_Control_Char(?,?,?) }" ); 
ostmt.setString(1,ProfileID);
ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
ostmt.execute();
Standard_type=ostmt.getString(2);
Standard_symbols=ostmt.getString(3);


//System.out.println("Standard_symbols70"+Standard_symbols);

if(ostmt!=null) 
ostmt.close();




	
		}
catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
		   ex.printStackTrace(System.err); }
	    

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Standard_symbols));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Standard_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ReqText));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Req_syntax));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(res_txt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(REs_Syn));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
