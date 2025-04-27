package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __resultscrolling extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultScrolling.jsp", 1709119996000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<div align=\'right\'>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</div>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	/*
	----------------------------------------------------------------------------------------------------------------
	 Date       Edit History   	Name       	Rev.Date   	Rev.By    	Description
	----------------------------------------------------------------------------------------------------------------
	?          	100           	?          	?			? 			created
	28/05/2015	IN052230		Karthi L							Order Management-Missing specimens-Dispatch Slip	 
	10/01/2018  IN061893		Kamalakannan G  10/01/2018  Ramesh G 			ML-MMOH-CRF-0545
	-----------------------------------------------------------------------------------------------------------------
	 */

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String from				= request.getParameter("from");

	
	if(from==null) from		= "1";
	String to				= request.getParameter("to");
	if(to==null) to			= "7";
	String check_box_name	= request.getParameter("check_box_name");
	if(check_box_name==null) check_box_name = "";
	String form_name		= request.getParameter("form_name");
	 /*Added by kishore kumar N on 30-Oct-09  for CRF 15741*/
	String qryString		= request.getParameter("qryString")==null?"":request.getParameter("qryString");
	String option			= request.getParameter("option")==null?"":request.getParameter("option"); //IN052230
	if (qryString.indexOf("&from") != -1)
	{
		qryString = qryString.substring(0, qryString.indexOf("&from"));
	}
	/*ends here.*/
	if(form_name==null) form_name = "";
	String total_size		= "";
	
	//if(from==null || from.equals("1"))
		total_size			= request.getParameter("total_size");
	if(total_size==null) total_size = "0";
	int limitTo	= Integer.parseInt(request.getParameter("limitTo")==null||"".equals(request.getParameter("limitTo"))?"7":request.getParameter("limitTo"));//IN061893

	int start				= Integer.parseInt(from);
	int end					= Integer.parseInt(to);
	int total_records		= Integer.parseInt(total_size);
	
	//System.out.println("from"+from+"=="+"to"+to);
	//System.out.println("start"+start+"=="+"end"+end);

//out.println("from"+from);
//out.println("start"+start);
//out.println("end"+end);
//out.println("total_records"+total_records);

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
 // IN052230 - Start
				if(option.equalsIgnoreCase("S")){
					if ( !(start <= 1) )  
			  			out.println("<A class='gridLink' HREF=\"javascript:displayDispatchSlipRecords('"+(start-7)+"', '"+(end-7)+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");
	 				if( !( (start+7) > total_records)) 
	 					out.println("<A  class='gridLink' HREF=\"javascript:displayDispatchSlipRecords('"+(start+7)+"', '"+(end+7)+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				}
				else { //IN052230 - End
					if ( !(start <= 1) )  
			  			//out.println("<A class='gridLink' HREF=\"javascript:displayRecords('"+(start-7)+"', '"+(end-7)+"', '"+check_box_name+"', '"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");commented for IN061893
						out.println("<A class='gridLink' HREF=\"javascript:displayRecords('"+(start-limitTo)+"', '"+(end-limitTo)+"', '"+check_box_name+"', '"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");// added for IN061893
	 				if( !( (start+7) > total_records)) 
	 					//out.println("<A  class='gridLink' HREF=\"javascript:displayRecords('"+(start+7)+"', '"+(end+7)+"', '"+check_box_name+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");commented for IN061893
					out.println("<A  class='gridLink' HREF=\"javascript:displayRecords('"+(start+limitTo)+"', '"+(end+limitTo)+"', '"+check_box_name+"','"+form_name+"','"+qryString+"')\""+" text-decoration='none'>"+"   "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");// added for IN061893
				} //IN052230 
				out.println("&nbsp;&nbsp;");
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
