package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __procedureerror extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProcedureError.jsp", 1738837621364L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<head>\n\n<script language=\"JavaScript\">\nfunction onsuccess(modal_yn,error,errorRemarks,p_called_from_widget)  //CHL-CRF [IN035950]\n{  \n\tif(modal_yn == \"Y\"){\n\t\t//Added by Archana Dhal on 3/9/2011 related to incident no.IN026810 \n\t\t// parent.frames[1].document.location.href = parent.frames[1].document.location.href ;\n\t\tvar query_string = parent.document.getElementById(\"dialog-body\").contentWindow.document.getElementById(\"frame2\").contentWindow.document.getElementById(\"qryStr\").value;\n\t\tvar index = (query_string.lastIndexOf(\"&mode=update\"));\n\t\tif(index != -1)\n\t\t\tvar qry_Str = query_string.substring(0,index);\n\t\telse\n\t\t\tqry_Str = query_string;\n\t\t//console.log(parent.document.getElementById(\"dialog-body\").contentWindow.document.getElementById(\"frame2\"));\n\t\tparent.document.getElementById(\"dialog-body\").contentWindow.document.getElementById(\"frame1\").contentWindow.location.href=\"../../eCA/jsp/ProcQueryResult.jsp?\"+qry_Str;\n\t\tparent.document.getElementById(\"dialog-body\").contentWindow.document.getElementById(\"frame2\").contentWindow.location.href=\"../../eCA/jsp/AddModifyOPProc.jsp?\"+qry_Str;\n\t\t//alert(\"APP-CA001 Operation Completed Successfully...\");\n\t\t//var message = error.substring(0,(error.lastIndexOf(\".\")));\n\t\t//Commented by Jyothi to fix IN026248 on 03/02/2010\n\t\t/*var message = error;\n\t\talert(message);\n\t\tparent.window.close();*/\n\t}else{\n\t\tif(p_called_from_widget!=\"\"){\n\t\t\t//parent.frames[1].document.location.href = parent.frames[1].document.location.href ;\n\t\t\tvar query_string = parent.document.getElementById(\"dialog-body\").contentWindow.document.getElementById(\"frame2\").contentWindow.document.getElementById(\"qryStr\").value;\n\t\t\tvar index = (query_string.lastIndexOf(\"&mode=update\"));\n\t\t\tif(index != -1)\n\t\t\t\tvar qry_Str = query_string.substring(0,index);\n\t\t\telse\n\t\t\t\tqry_Str = query_string;\n\t\t\tparent.frame1.location.href=\"../../eCA/jsp/ProcQueryResult.jsp?\"+qry_Str;\n\t\t\tparent.frame2.location.href=\"../../eCA/jsp/AddModifyOPProc.jsp?\"+qry_Str;\n\t\t}else{\n\t\t\tvar objWork = top.content;\n\t\t\tif(null!= objWork ){\n\t\t\t\ttop.content.workAreaFrame.frame1.document.location.reload();\t \n\t\t\t\tvar query_string = top.content.workAreaFrame.frame2.document.forms[0].qryStr.value;\n\t\t\t\tvar index = (query_string.lastIndexOf(\"&mode=update\"));\n\t\t\t\tif(index != -1)\n\t\t\t\t\tvar qry_Str = query_string.substring(0,index);\n\t\t\t\telse\n\t\t\t\t\tqry_Str = query_string;\t\t\n\t\t\t\ttop.content.workAreaFrame.frame2.location.href=\"../../eCA/jsp/AddModifyOPProc.jsp?\"+qry_Str;\n\t\t\t}else{\n\t\t\t\tparent.frame1.document.location.reload();\t \n\t\t\t\tvar query_string = parent.frame2.document.forms[0].qryStr.value;\n\t\t\t\tvar index = (query_string.lastIndexOf(\"&mode=update\"));\n\t\t\t\tif(index != -1)\n\t\t\t\t\tvar qry_Str = query_string.substring(0,index);\n\t\t\t\telse\n\t\t\t\t\tqry_Str = query_string;\t\t\n\t\t\t\tparent.frame2.location.href=\"../../eCA/jsp/AddModifyOPProc.jsp?\"+qry_Str;\n\t\t\t\n\t\t\t}\n\t\t}\n\t}\n}\n\n</script>\n\n</head>\n<BODY CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<p align=\"left\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</p>\n</BODY>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created 
20/01/2012		CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

    String error=request.getParameter( "err_num" );
	//out.println("<script>alert('error"+error+"');</script>");
    if (error != null) {
        

        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
        String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String modal_yn = request.getParameter( "modal_yn" )==null ? "N" : request.getParameter( "modal_yn" ) ;
		String errorRemarks = request.getParameter( "errorRemarks" )==null ? "N" : request.getParameter( "errorRemarks" ) ;
		String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
       // if(modal_yn.equals("N"))
	   {
    	    out.println( "<script language='JavaScript'>  var messageParagraph = document.createElement('p'); messageParagraph.textContent = '" + error + "';  parent.parent.document.getElementById('dialog-body').contentWindow.document.getElementById('messageFrame').contentWindow.document.body.appendChild(messageParagraph); </script>" ) ;
			// out.println(error);
		    if ( error_value.equals( "1" ))
			     out.println( "<script language='JavaScript'>onsuccess('"+modal_yn+"','"+error+"','"+errorRemarks+"','"+p_called_from_widget+"')</script>" ) ;
		}        
    }


            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
