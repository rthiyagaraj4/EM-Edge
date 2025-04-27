package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __caconfigemailformatdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAConfigEmailFormatDtl.jsp", 1709115503278L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCA/js/CAConfigEmailFormat.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\t\tfunction loadmsg(obj)\n\t\t{\t\t\n\t\t\t\n\t\t\tif(obj.checked ==true) \n\t\t    obj.value=\'Y\';\n\t       else \n\t\t    obj.value = \'N\';         \n\t\t\t\n\t\t}\t\t\n\t\tfunction checkChildEvents(obj){\n\t\t\n\t\t\tvar objName = obj.name;\t\t\n\t\t\tobjName = objName.substring(objName.indexOf(\"~\")+1);\t\t\t\t\n\t\t\tvar cInp = document.getElementsByTagName(\'input\');\n\t\t\tfor (var i=0;i<cInp.length ;i++ )\n\t\t\t{\n\t\t\t\tif (cInp[i].type == \"checkbox\")\n\t\t\t\t{\n\t\t\t\t\tvar chdEvent =  cInp[i].name;\n\t\t\t\t\tchdEvent = chdEvent.substring(chdEvent.indexOf(\"~\")+1);\t\t\t\t\t\n\t\t\t\t\tif (objName == chdEvent )\n\t\t\t\t\t{\n\t\t\t\t\t\tif (obj.checked)\n\t\t\t\t\t\t{\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tcInp[i].checked = true;\n\t\t\t\t\t\t\tcInp[i].value = \"Y\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tcInp[i].checked = false;\n\t\t\t\t\t\t\tcInp[i].value = \"N\";\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t}\n</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</html>\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<form name=\"configEmailFrmtDtlForm\" id=\"configEmailFrmtDtlForm\" action=\"../../servlet/eCA.CAConfigEmailFrmtServlet\" method=\"post\" target=\"messageFrame\">\n\t<table  class=\'grid\' align=\'center\' cellpadding=3 cellspacing=0 border=1 width=\'80%\'>\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n        <td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</table>\n<input type=\'hidden\' name=\'configureEmailReport\' id=\'configureEmailReport\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n</form> \n</body>\n</html>\n\n";
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
  
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String classValue = "gridData";
	String eventName = "";
	String eventDesc = "";
	String eventStatus = "";
	String eventHdr = "";
	String strChecked = "";
	//String chkstr="disabled";
	String chkstr="";
	int rowCount=0;
	String reportTypeId = request.getParameter("reportTypeId") == null ? "" : request.getParameter("reportTypeId");
	
	
	Connection conn				= null;
	PreparedStatement pstmt	    = null;
	ResultSet rs				= null;


	try
 {
		String sqlSel = "select EVENT_NAME,EVENT_DESC,EVENT_STATUS,EVENT_HDR from CA_CONFIG_EMAIL_FORMAT where EFF_STATUS ='E' AND REPORT_ID=? order by SRL_NO";
	    
	    conn	= ConnectionManager.getConnection();
		pstmt	= conn.prepareStatement(sqlSel);
		pstmt.setString(1,reportTypeId);
		rs		= pstmt.executeQuery();	

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		String eventHdrTemp = "";
	    while(rs.next())
	    {		
		strChecked="";
		rowCount++;

		eventName = rs.getString("EVENT_NAME") == null ? "" : rs.getString("EVENT_NAME");
		eventDesc = rs.getString("EVENT_DESC") == null ? "" : rs.getString("EVENT_DESC");
		eventStatus = rs.getString("EVENT_STATUS") == null ? "N" : rs.getString("EVENT_STATUS");		
		eventHdr = rs.getString("EVENT_HDR") == null ? "" : rs.getString("EVENT_HDR");
		if (eventStatus.equals("Y"))
			strChecked="checked";

		if (reportTypeId.equals("EMPATINS"))
		{
		  if((eventName.equals("ORD_CAT_DTL")) || (eventName.equals("PAT_INSTRUCTIONS")) )
			{	  
			  chkstr="disabled";
			  strChecked="checked";	
		   }
		   
		}
		
			if(!eventHdrTemp.equals(eventHdr))
			{
				 out.println("<tr>");
				 out.println("<td class='"+classValue+"'   name='eventDesc"+rowCount+"'><B>"+eventDesc);	
				 out.println("</B></td><td align='center' class='"+classValue+"' ><input type='checkbox' name='eventStatus"+rowCount+"~"+eventHdr+"' id='eventStatus"+rowCount+"~"+eventHdr+"' value='"+eventStatus+"' onclick='checkChildEvents(this)' "+strChecked+" "+chkstr+">");	
				 out.println("<input type=hidden name='eventName"+rowCount+"' id='eventName"+rowCount+"' value='"+eventName+"'>");
				 out.println("<input type=hidden name='eventHdr"+rowCount+"' id='eventHdr"+rowCount+"' value='"+eventHdr+"'>");
				 out.println("</tr>"); 		
				
			}else{
				 out.println("<tr>"); 				 
				 out.println("<td class='"+classValue+"'  name='eventDesc"+rowCount+"'>"+eventDesc);
				 out.println("</td><td align='center' class='"+classValue+"' ><input type='checkbox' name='eventStatus"+rowCount+"~"+eventHdr+"' id='eventStatus"+rowCount+"~"+eventHdr+"' value='"+eventStatus+"'  onclick='loadmsg(this)' "+strChecked+" "+chkstr+">");
				out.println("<input type=hidden name='eventName"+rowCount+"' id='eventName"+rowCount+"' value='"+eventName+"'>");
				out.println("<input type=hidden name='eventHdr"+rowCount+"' id='eventHdr"+rowCount+"' value='"+eventHdr+"'>");
				 out.println("</tr>"); 			
			} 

				eventHdrTemp = eventHdr;
		}	
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{		
	e.printStackTrace();
   }
   finally{
	if(conn != null) ConnectionManager.returnConnection(conn,request);
   }
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(reportTypeId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DisplayEvents.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
