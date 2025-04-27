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

public final class __rescomments extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ResComments.jsp", 1709116254324L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n\n08/11/2011\t  IN29177\t\t Dinesh T\t Changed for the thai language support\n28/02/2013\t  IN038075\t\t Nijitha S\t Alpha-CA-Chart Summary->System is displaying Internal Server error for the \t\t\t\t\t\t\t\t\t Recorded Vital Sign with special character \'%\'\n20/10/2015\t\tIN057138\t\t\tKarthi L\tChief Complaint ( Long Text ) which has been recorded  from the Manage Patient Queue vital battery\n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History\t\tName        \tRev.Date\t\tRev.Name\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n16/01/2019\t\tIN068560\t\t\tRaja S\t\t\t16/01/2019\t\tRamesh G\t\tML-MMOH-SCF-1078\n02/09/2021\t14801\t\t\t\tRamesh \t\t\t\t\t\t\t\t\t\t\tSKR-SCF-1578\t\n---------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html> \n<head> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />  \n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\tfunction doClose()\n\t{\n\t\twindow.close();\n\t}\t\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n</head>\n<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n<center>\n\t<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\' align=center>\n\t\t<tr><td>\n\t\t\t<table width=\'50%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\' align=center>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<!--<td class=\'fields\'><textarea name=\"comments\" rows=\"17\" cols=\"54\" readOnly>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</textarea></td>--><!--IN29177,[IN038075]-->\n\t\t\t\t\t<td class=\'fields\'><textarea name=\"comments\" rows=\"17\" cols=\"54\" readOnly>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</textarea></td><!--IN038075-->\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\'><input type=\'Button\' class=\'Button\' name=\'Ok\' id=\'Ok\' value=\'   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="   \' onclick=\'doClose()\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td></tr>\n\t</table>\n</center>\n</body>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</html>\n\n";
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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
		String resComments	= request.getParameter("resultStr") == null?"":request.getParameter("resultStr");
		//resComments = java.net.URLDecoder.decode(resComments); //ML-BRU-SCF-1642 - IN057138 //14801
		String modal_title	= request.getParameter("modal_title");
		if(resComments.indexOf("<BR>")!=-1)//IN068560
					resComments = resComments.replaceAll("<BR>","\r\n");//IN068560
		// commented below line for - ML-BRU-SCF-1642 - IN057138- Start
		/*if( resComments == null) 
			resComments="";
		else
		{
			if(resComments.indexOf("~")!=-1)
					resComments = resComments.replaceAll("~","\r\n");			
			if(resComments.indexOf("`")!=-1)
					resComments = resComments.replaceAll("`","'");			
			if(resComments.indexOf("|")!=-1)
					resComments = resComments.replaceAll("|","\"");			
			if(resComments.indexOf("&amp;")!=-1)	
				resComments = resComments.replaceAll("&amp;","&");	
			/*while(resComments.indexOf("~")!=-1)
			{	
				int a=resComments.indexOf("~");
				StringBuffer temp=new StringBuffer(resComments);
				temp.replace(a,a+1,"\r\n");
				resComments=temp.toString();
			}
			while(resComments.indexOf("`")!=-1)
			{	
				int a=resComments.indexOf("`");
				StringBuffer temp=new StringBuffer(resComments);
				temp.replace(a,a+1,"'");
				resComments=temp.toString();
			}
			while(resComments.indexOf("|")!=-1)
			{	
				int a=resComments.indexOf("|");
				StringBuffer temp=new StringBuffer(resComments);
				temp.replace(a,a+1,"\"");
				resComments=temp.toString();
			}	
		}*/
		// commented below line for - ML-BRU-SCF-1642 - End
		if( modal_title == null) 
			modal_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(modal_title));
            _bw.write(_wl_block9Bytes, _wl_block9);
//=java.net.URLDecoder.decode(resComments)
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resComments));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
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
