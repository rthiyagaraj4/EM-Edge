package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __managelisspecimenimageintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/ManageLISSpecimenImageIntermediate.jsp", 1709115156025L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCA/js/ManageLISSpecimenImage.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n</head>\n<body class=\'message\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\n<form name=\'LISImageForm\' id=\'LISImageForm\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

String dept = request.getParameter("dept") == null ? "" : request.getParameter("dept");
String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
String recCnt = request.getParameter("recCount") == null ? "0" : request.getParameter("recCount");
String p_resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
String error = request.getParameter("error") == null ? "" : request.getParameter("error");
int recCount = Integer.parseInt(recCnt);

Connection con = null;
PreparedStatement pstmt = null;
ResultSet res = null;

String catCode = "";
String appServerURL = "";

if(facilityId.equals("")) 
facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

try
{
	if(p_resp_id.equals("RL_MANAGER"))
	{
		con = ConnectionManager.getConnection();
	}
	else
	{
		con = ConnectionManager.getConnection(request);
	}
	
	if(!calledFrom.equals("Servlet") && !calledFrom.equals("viewImage"))
	{		
		pstmt = con.prepareStatement("SELECT short_desc, category_code FROM RL_CATEGORY_CODE_LANG_VW WHERE operating_facility_id = ? AND section_code = ? AND LANGUAGE_ID = ? ORDER BY 1");

		pstmt.setString(1,facilityId);
		pstmt.setString(2,dept);
		pstmt.setString(3,locale);
		res = pstmt.executeQuery();

		out.println("<script>");
		out.println("var tempCnt = parseInt(parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.options.length,10)");
		out.println("for(var t=0;t<tempCnt;t++)");
		out.println("{");			out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.remove(\"parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.options[LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.option(t)]\"); ");
		out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.remove(\"parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.options[LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.option(t)]\"); ");
		out.println("}");

		out.println("var selObj = document.createElement(\"Option\");");
		out.println("selObj.value='' ");
		out.println("selObj.text='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"'");
		out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.add(selObj)");
		out.println("var selObj = document.createElement(\"Option\");");
		out.println("selObj.value='' ");			out.println("selObj.text='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"'");
		out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.add(selObj)");
		out.println("</script>");
		while(res.next())
		{
			catCode = res.getString("category_code") == null ? "" : res.getString("category_code");
			out.println("<script>var selObj = parent.LISSpecQueryFrame.document.createElement(\"Option\")</script>");
			out.println("<script>selObj.value = \""+catCode+"\"</script>");
			out.println("<script>selObj.text = \""+catCode+"\"</script>");	
			out.println("<script>parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.add(selObj)</script>");
			out.println("<script>var selObj = parent.LISSpecQueryFrame.document.createElement(\"Option\")</script>");
			out.println("<script>selObj.value = \""+catCode+"\"</script>");
			out.println("<script>selObj.text = \""+catCode+"\"</script>");				
			out.println("<script>parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.add(selObj)</script>");
		}
		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
	}			
	else if(calledFrom.equals("Servlet"))
	{
		if(!error.equals("Y"))
		{
			out.println("APP-SM0001 Operation Completed Successfully ...");					
			out.println("<script>parent.window.fileUploadLinksFrame.location.href = parent.window.fileUploadLinksFrame.location.href</script>");
			out.println("<script>parent.window.fileUploadFrame.location.href = '../../eCommon/html/blank.html'</script>");
		}
		else
		{
			out.println("<script>alert(getCAMessage('INVALID_IMAGE'));</script>");
		}
	}// added by Sanjay for Delete Image Functionality on 17-May-13
	else if(calledFrom.equals("ServletDelete"))
	{
		if(!error.equals("Y"))
		{
			//out.println("APP-SM0001 Operation Completed Successfully ...");
			//out.println("<script>alert('ServletDelete');</script>");
			out.println("APP-SM0001 Deleted ...");
			out.println("<script>parent.parent.window.fileUploadLinksFrame.location.href = parent.window.fileUploadLinksFrame.location.href</script>");
			//out.println("<script>parent.window.fileUploadFrame.location.href = '../../eCommon/html/blank.html'</script>");
		}
		else
		{
			out.println("<script>alert(getCAMessage('INVALID_IMAGE'));</script>");
		}
	}
	else if(calledFrom.equals("viewImage"))
	{
		String specNum = request.getParameter("specNum") == null ? "" : request.getParameter("specNum");
		String test = request.getParameter("test") == null ? "" : request.getParameter("test");
		String sampleId = request.getParameter("sampleId") == null ? "" : request.getParameter("sampleId");
		String anatomy = request.getParameter("anatomy") == null ? "" : request.getParameter("anatomy");
		String calledFromForms = request.getParameter("calledFromForms") == null ? "" : request.getParameter("calledFromForms");
		//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
		String secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");

		pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM RL_EXT_INTERFACE_PARAM where EXT_APPL_ID='LBIMG'  ");
		res = pstmt.executeQuery();

		while(res.next())
		{
			appServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
		}

		if(res != null) res.close();
		if(pstmt != null) pstmt.close();

		// added by Sanjay for Image Delete Logic on 07-May-13
		out.println("<script>");		
		//Sanjay for removing Delete Option when viewed from Review

		//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
		out.println("window.showModalDialog(\"../../eBT/jsp/ManageLISSpecimenImageLinksForImage.jsp?specNum="+specNum+"&p_resp_id="+p_resp_id+"&test="+test+"&sampleId="+sampleId+"&secCode="+secCode+"&calledFromForms="+calledFromForms+"&anatomy="+anatomy+"&recCount="+recCount+"&facility_id="+facilityId+"\",'Document','dialogHeight:15;dialogWidth:25;dialogTop:200;location:no;menubar:no;status:no;scrollbars:yes');");
		out.println("parent.frames[0].document.location.reload()");
		out.println("</script>");
		
	}
}//end of try
catch(Exception e)
{
	//System.out.println("Exception in try of ManageLISSpecimenImageIntermediate.jsp --"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
