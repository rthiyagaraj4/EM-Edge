package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eCA.ChartRecording.*;
import javax.rmi.*;
import webbeans.eCommon.MessageManager;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __notescontent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/NotesContent.jsp", 1709118028662L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>jQuery Mobile Application</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n  \n<link rel=\"stylesheet\" href=\"../css/iPadCreateNotes.css\" />\n\n<script>\nfunction Loading()\n{\n\t//window.parent.hideLoading();\n\tvar scrollheight = document.getElementById(\"txtnotes\").scrollHeight;\n\tvar orgHeight = $(\"#txtnotes\").height();\n\tvar modHeight = scrollheight + orgHeight + \"px\";\n\t//alert(orgHeight);\n\t//alert(modHeight);\n\t//alert(document.getElementById(\"txtnotes\").scrollHeight );\n\t//alert($(\"#txtnotes\").height() );\n\t\n\t  $(\"#txtnotes\").css(\'height\', scrollheight);\n\t  \n\t  document.getElementById(\"dv\").contentEditable=\'true\';\n\t // alert(document.getElementById(\"dv\").textContent);\n\t // document.getElementById(\"txtnotes\").value = document.getElementById(\"dv\").textContent;\n} \nfunction changeOrientation(orient,height)\n{\n\t\t//alert(height);\n\tif(orient == \"landscape\")\n\t   {\n\t     document.getElementById(\"dvmain\").style.height = \"auto\";\n\t     document.getElementById(\"txtnotes\").style.height = height;\n\t    // $(\"#txtnotes\").css(\'min-height\', height);\n\t   }\n     else\n\t   {\n\t   document.getElementById(\"dvmain\").style.height = \"auto\";\n\t   document.getElementById(\"txtnotes\").style.height = height;\n\t //  $(\"#txtnotes\").css(\'min-height\', height);\n\t   }\n \n}\nfunction showText()\n{\n\t //alert(document.getElementById(\"dv\").innerHTML);\n}\nfunction getNotescontent()\n{\n\tvar notesContent =  document.getElementById(\"txtnotes\").value;\n\tvar dvNotescontent = document.getElementById(\"dv\").innerHTML;\n\t//var accessnum = document.getElementById(\"accession_num\").value;\n\tvar operationMode = document.getElementById(\"operation_mode\").value;\n\t/*\n\tif(accessnum != null && accessnum != \"\")\n\t{\n\t\t operationMode = \"UpdateRecord\";\t\n\t}\n\telse\n\t{\n\t\t operationMode = \"Record\";\t\n\t}\n\t*/\n\t//alert(dvNotescontent);\n\t//alert(notesContent);\n\t//alert(\"notescontent\");\n\twindow.parent.setNotesContent(notesContent,dvNotescontent, operationMode);\n}\n</script>\n<style>\n  .ADDRESS\t{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n  .white\n  {\n    \n  }\n  ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}\n</style>\n</head>\n\n<body onload = \"Loading()\" >\n<section data-role = \"page\" style = \"padding:0px;\">\n <form>\n <div data-role = \"none\"  id = \'dvmain\'  style=\"padding:0px;height:auto;background-color:#ffffff\" >\n   \n  <div data-role = \"none\" class = \"dvViewNotes\">\n     <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n       <tr style=\"width:100%;height:100%\">\n         <td style = \"width : 80%\" align = \"left\" valign = \"center\">\n            <span class = \"spanCreateNotesView\">";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</span>\n            \n         </td> \n         <td style=\"width:20%\">\n         &nbsp;\n         </td>\n       </tr>\n     </table>\n   </div> \n  \n\t  <div id = \"dv\" style=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =";height:auto\">\n      ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t  </div>\n\t  <div style=\"height:auto;overflow:auto\">\n\t\t  <textarea  class = \"txtNotes\" data-role = \"none\" id = \"txtnotes\" style=\"height:";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =";display:block\" onclick = \"showText()\" >\n\t          \n\t\n\t      </textarea>\n      </div>\n  \n  \n\n</div>\n<input type = \"hidden\" name = \"accession_num\" id = \"accession_num\" value = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" />\n<input type = \"hidden\" name = \"operation_mode\" id = \"operation_mode\" value = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/>\n</form> \n</section>  \n</body>\n\n</html>\n\n";
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

 String notesHeading = "";
 if(request.getParameter("notesHeading") != null)
 {
	 notesHeading = request.getParameter("notesHeading");
 }
String strHeight = "341px";
if(request.getParameter("height") != null)
{
	strHeight = request.getParameter("height");
}
request.setCharacterEncoding("UTF-8");
String display= "display:none";
String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String accession_num = "";
String operationMode = "";
String hdgCode = "";
String subHdgCode = "";
if(request.getParameter("accessnum") != null)
{
	accession_num=request.getParameter("accessnum");
}
if(request.getParameter("secCode") != null)
{
	hdgCode = request.getParameter("secCode");
}
if(request.getParameter("secChildCode") != null)
{
	subHdgCode = request.getParameter("secChildCode");
}
	

String	notes_content		=	"";

java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;






//sqlStr.append("SELECT B.TERM_SET_DESC AS ProblemSet,A.TERM_CODE as DiagProb,A.TERM_CODE_SHORT_DESC as Description FROM PR_DIAGNOSIS A JOIN MR_TERM_SET B ON A.TERM_SET_ID = B.TERM_SET_ID WHERE A.PATIENT_ID = 'MC00000149'");

sqlStr.append("select notes_section_content from ca_encntr_note_section where sec_hdg_code = '" +hdgCode +"' and subsec_hdg_code = '" + subHdgCode+ "' and accession_num = '" +accession_num + "'");

Statement stmt				= null;
ResultSet rs				= null;

Statement stmt1				= null;
ResultSet rs1				= null;
ResultSet rs2				= null;
Connection conn=null;
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
String strRowCount = "";
try {
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
stmt1	 = conn.createStatement();
if (rs!=null) rs.close();   
rs = stmt.executeQuery(sqlStr.toString());

if(rs != null && rs.next())
{
	clob_notes_content	=	(java.sql.Clob) rs.getObject("notes_section_content");

	if(clob_notes_content != null)
	{
		try
		{
			content_reader	= clob_notes_content.getCharacterStream();
			bf_content_reader = new java.io.BufferedReader(content_reader);
			char[] arr_notes_content = new char[(int)clob_notes_content.length()];
			bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
			notes_content = new String(arr_notes_content);
			bf_content_reader.close();
		}
		catch(Exception e)
		{
			out.println("Exception@2-readCLOB : "+e);
		}

		if(!notes_content.equals(""))
		{
			int nIndex	= notes_content.indexOf("<BODY>");
			int nIndex1 = notes_content.lastIndexOf("</BODY>");

			if(nIndex != -1 && nIndex1 != -1)
				notes_content = notes_content.substring(nIndex+6,nIndex1);
		}
	}//c
	operationMode = "UpdateRecord";
	display= "display:block";
}
else
{
	operationMode = "Record";
}

}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(conn,request);
}



            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(notesHeading ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(display ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(notes_content));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(strHeight));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(operationMode));
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
