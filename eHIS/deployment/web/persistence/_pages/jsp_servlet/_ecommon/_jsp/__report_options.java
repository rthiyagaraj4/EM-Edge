package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.io.*;
import ecis.utils.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class __report_options extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/report_options.jsp", 1741058217331L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n<script language=\"javascript\">\n\t//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022\n\tvar reportURL=\'\';\n\t//function to get the specific value from the String\n\tfunction param_val(url,name) {\n\t\tif(url !== undefined && url !== null ) {\n\t\t\treturn (url.split(name + \'=\')[1] || \'\').split(\'+\')[0];\n\t\t}\n\t}\n\tasync function callReportOptionsFrameset( params,reportServerEnableFlag,report_option) {\n\t\t\n\t\tvar url\t\t= \"../../eCommon/jsp/report_options_frameset.jsp?\"+params ;\n\t\t/*\n\t\tvar dialogHeight\t= \"11\" ;\n\t\tvar dialogWidth\t= \"25\" ;\n\t\t*/\n\t\tvar dialogTop = \"10px\" ; ///added by vijayan\n\t\tvar dialogHeight\t=\"220px\";\n\t\tvar dialogWidth\t= \"340px\";\n\t\t\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:no\" ;\n\t\n\t\treportURL \t= await window.showModalDialog( url, arguments, features ) ;\n\t\tvar report_option_val=param_val(reportURL,\"REPORT_OPTION\");\n\t\tvar file_dir =param_val(reportURL,\"desname\");\n\t\tvar file_name =param_val(reportURL,\"filename\");\n\t\tif ( reportURL != null ) {  // try this as a an ajax submission ----\n\t\t//Check the Report Server Post Method is enabled in SM Function control\n\t\t\tif(reportServerEnableFlag==\'Y\')\n\t\t\t{\n\t\t\t\t//IF it is View mode ,Form is submitted in below format\n\t\t\t\tif(report_option_val  == \"V\")\n\t\t\t\t{\n\t\t\t\t\tvar form = document.createElement(\'FORM\');\n\t\t\t\t\tform.method=\'POST\';\n\t\t\t\t\tform.action = \'report_open.jsp\';\n\t\t\t\t\tform.target = \'_self\';\n\t\t\t\t\t//form.style = \'width: 100%\';\n\t\t\t\t\tvar input = document.createElement(\"INPUT\");\n\t\t\t\t\tinput.name = \"report_option\";\n\t\t\t\t\tinput.type = \"hidden\";\n\t\t\t\t\tinput.value = report_option_val;\n\t\t\t\t\tform.appendChild(input);\n\t\t\t\t\tvar input1 = document.createElement(\"INPUT\");\n\t\t\t\t\tinput1.name = \"report_url\";\n\t\t\t\t\tinput1.type = \"hidden\";\n\t\t\t\t\tinput1.value = reportURL;\n\t\t\t\t\tform.appendChild(input1);\n\t\t\t\t\tvar input2 = document.createElement(\"INPUT\");\n\t\t\t\t\tinput2.name = \"file_dir\";\n\t\t\t\t\tinput2.type = \"hidden\";\n\t\t\t\t\tinput2.value = file_dir;\n\t\t\t\t\tform.appendChild(input2);\n\t\t\t\t\tvar input3 = document.createElement(\"INPUT\");\n\t\t\t\t\tinput3.name = \"file_name\";\n\t\t\t\t\tinput3.type = \"hidden\";\n\t\t\t\t\tinput3.value = file_name;\n\t\t\t\t\tform.appendChild(input3);\n\t\t\t\t\tdocument.body.appendChild(form);\t\n\t\t\t\t\tform.submit();\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\t\t//IF it is File or Printer mode ,Form is submitted in below format\n\t\t\t\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey();\'><form name=\'report_server_form1\' id=\'report_server_form1\' method=\'post\' action=\'report_open.jsp\'><input name=\'report_option\' id=\'report_option\' type=\'hidden\' value=\'\"+report_option_val+\"\'><input name=\'report_url\' id=\'report_url\' type=\'hidden\' value=\'\"+reportURL+\"\'><input name=\'file_dir\' id=\'file_dir\' type=\'hidden\' value=\'\"+file_dir+\"\'></form></body></html>\";\t\n\t\t\t\t\tdocument.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\t\t\tdocument.report_server_form1.submit();\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treportURL\t\t= \"report_process.jsp?\" + reportURL ;\n\t\t\t\tvar myBars \t\t= \'directories=no,location=no,menubar=no\' ;\n\t\t\t\t//var myOptions \t= \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=yes\' ;\n\t\t\t\tvar myOptions \t= \'width=1500px !important, height=750px !important, resizable=yes\' ; //Maheshwaran K modified as on 19-11-2021 for MOHE-SCF-0147\n\t\t\t\tvar myFeatures \t= myBars + \', \' + myOptions ;\n\t\n\t\t\t\tvar reportWindow \t= open( reportURL, \'_blank\', myFeatures ) ;\n\t\n\t\t\t\treportWindow.title= \"Medicom Report Viewer\" ;\n\t\t\t\treportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;\n\t\t\t\treportWindow.moveTo( 0,0 ) ;\n\t\t\t\treportWindow.focus() ;\n\t\t\t}\n\t\t}\n\t}\n</script>\n<body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\' style=\"width:100 !important %;height:100% !important;\">\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n</body>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
	String params		= request.getQueryString() ;
	String report_option	= request.getParameter( "report_option" ) ;
	String destype	= request.getParameter( "destype" ) ;
	//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022
	Connection con=null;
	String reportServerEnableFlag="";		
	try 
		{
		con	= ConnectionManager.getConnection(request);
		HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(con,"SM","REPORT_SERVER_POST");
		reportServerEnableFlag = (String)hashdata.get("value1");
		}
	catch(Exception e)
		{
		e.printStackTrace();	
		}
	finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
	//End
	if ( params == null ) params = "" ;
	out.println( "<script language=\"JavaScript\"> callReportOptionsFrameset(\"" + java.net.URLDecoder.decode(params) + "\",\"" +reportServerEnableFlag+ "\",\"" +report_option+ "\" )</script>" ) ;
	//Ends MOHE-SCF-0147
/*
	String url			= "../../eCommon/jsp/report_options_frameset.jsp?" + params ;
	String dialogHeight	= "11" ;
	String dialogWidth	= "20" ;

	out.println( "<script language='JavaScript'>" ) ;
	out.println( "window.name = 'report_options'" )  ;
	out.println( "var url 		= '" + url + "'" ) ;
	out.println( "var arguments 	= ''" ) ;
	out.println( "var features	= 'dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"'" ) ;
	out.println( "window.showModelessDialog( url, arguments, features )" ) ;
//	out.println( "alert( 'Report URL = ' + reportURL + ');" ) ;
	out.println( "</script>" ) ;
*/

/*
	String queryString	= request.getQueryString() ;
	

	String level 		= request.getParameter( "level" ) ;
	String url			= "report_options_form.jsp?level=1" ;
	String dialogHeight	= "8" ;
	String dialogWidth	= "20" ;

	if ( queryString == null ) queryString = "" ;
	if ( level == null ) level = "1" ;
	if ( report_option == null ) report_option = "" ;

//	out.println( "<script language='JavaScript'>alert( '" + queryString + "' );</script>" ) ;

	if ( level.equals( "1" ) ) {
		if ( !queryString.equals( "" ) )
			url = url + "?" + queryString ;

		out.println( "<script language='JavaScript'>" ) ;
		out.println( "window.name = 'report_options'" )  ;
		out.println( "var url 		= '" + url + "'" ) ;
		out.println( "var arguments 	= ''" ) ;
		out.println( "var features	= 'dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"'" ) ;
		out.println( "window.showModelessDialog( url, arguments, features )" ) ;
		out.println( "</script>" ) ;
	}

 	if ( level.equals( "2" ) ) {
		if ( report_option.equals( "F" ) ) {
			url = "report_options_form.jsp?level=2&report_option=F" ;

			if ( !queryString.equals( "" ) )
				url = url + "?" + queryString ;

			dialogHeight = "12" ;
			dialogWidth = "30" ;

			out.println( "<script language='JavaScript'>" ) ;
			out.println( "window.name = 'report_options'" )  ;
			out.println( "var url 		= '" + url + "'" ) ;
			out.println( "var arguments 	= ''" ) ;
			out.println( "var features	= 'dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"'" ) ;
			out.println( "window.showModelessDialog( url, arguments, features )" ) ;
			out.println( "</script>" ) ;
		} else {
			out.println( "To be re-directed to Report Server ) " ) ;
			out.println( queryString ) ;
		}
	}
*/

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
