package jsp_servlet._erd._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eOR.*;
import eOR.Common.*;
import eAE.resources.*;
import eCA.resources.*;
import eCA.*;
import eRD.*;
import eRD.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __requestclinicalcomment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eRD/jsp/RequestClinicalComment.jsp", 1658294514854L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1658294068441L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1658294067208L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Request Clinical Comments</title>\r\n<script language=\"javascript\" src=\"../js/RadiologyExam.js\"></script>\r\n<script>\r\n\r\n</script>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<body>\r\n<form>\r\n\t<table>\r\n \t\t<tr>\r\n\t\t\t<td>\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t\t<textarea name=\"clinComm1\" id=\"clinComm1\" rows=20 cols=75 onkeyup=\"\" onkeypress=\"\" readOnly>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</textarea>\r\n\t\t\t</td>\r\n  \t\t</tr>\r\n\t\t<tr>\r\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\t<td>\r\n\t\t\t\t<textarea name=\"clinComm2\" id=\"clinComm2\" rows=20 cols=75 onkeyup=\"\" readOnly>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</textarea>\r\n\t\t\t</td>\r\n  \t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<input type=\"button\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' class=\"button\" onClick=\"window.close();\" />\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<input type=\"hidden\" name=\"clinic1\" id=\"clinic1\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" />\r\n\t<input type=\"hidden\" name=\"clinic2\" id=\"clinic2\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" />\r\n</form>\r\n</body>\r\n</head>\r\n</html>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}


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

/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735       PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String cliniccmt="";
	String addInfo="";
		
	System.err.println("Request Clinical Comments");
	String index = checkForNull(request.getParameter("index"));
	String P_FACILITY_ID = checkForNull(request.getParameter("P_FACILITY_ID"));
	System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
	String orderid = checkForNull(request.getParameter("orderid"));
	String order_line_num = checkForNull(request.getParameter("order_line_num"));
	String P_LOGIN_USER = checkForNull(request.getParameter("P_LOGIN_USER"));
	String P_LANGUAGE_ID = checkForNull(request.getParameter("P_LANGUAGE_ID"));
	String P_RESP_ID = checkForNull(request.getParameter("P_RESP_ID"));
	String P_REQUEST_NUM = checkForNull(request.getParameter("P_REQUEST_NUM"));
	String P_REQUEST_LINE_NUM = checkForNull(request.getParameter("P_REQUEST_LINE_NUM"));
	String P_EXT_APPL_ACCESSION_NUM = checkForNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
	

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

	Connection con = ConnectionManager.getConnection();	
	try
	{
		PreparedStatement pstmt = null;
		//Statement stmt				= null;
		ResultSet rs = null;
		String Commenttype="C";
		
			System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
			System.err.println("orderid--"+orderid);
			System.err.println(order_line_num);
			System.err.println("P_REQUEST_NUM--"+P_REQUEST_NUM);
			System.err.println("P_REQUEST_LINE_NUM--"+P_REQUEST_LINE_NUM);
			System.err.println("P_LANGUAGE_ID--"+P_LANGUAGE_ID);
			
				pstmt=con.prepareStatement("select RD_RESULT.GET_COMMENTS(?,?,?,?,?,?,?) from dual");			
				
				pstmt.setString(1,P_FACILITY_ID);
				pstmt.setString(2,orderid);
				pstmt.setString(3,order_line_num);
				pstmt.setString(4,P_REQUEST_NUM);
				pstmt.setString(5,P_REQUEST_LINE_NUM);
				pstmt.setString(6,P_LANGUAGE_ID);
				pstmt.setString(7,Commenttype);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					cliniccmt =checkForNull(rs.getString(1));
					System.err.println("cliniccmt--"+cliniccmt);
				}
				

	}catch(Exception e)
		{
			System.out.println("Exception while executing cliniccmt :"+e);
		}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(cliniccmt));
            _bw.write(_wl_block6Bytes, _wl_block6);

		try
	{
		PreparedStatement pstmt1 = null;
		//Statement stmt				= null;
		ResultSet rs1 = null;
		String Commenttype1="O";
		
			System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
			System.err.println("orderid--"+orderid);
			System.err.println(order_line_num);
			System.err.println("P_REQUEST_NUM--"+P_REQUEST_NUM);
			System.err.println("P_REQUEST_LINE_NUM--"+P_REQUEST_LINE_NUM);
			System.err.println("P_LANGUAGE_ID--"+P_LANGUAGE_ID);
			
				pstmt1=con.prepareStatement("select RD_RESULT.GET_COMMENTS(?,?,?,?,?,?,?) from dual");			
				
				pstmt1.setString(1,P_FACILITY_ID);
				pstmt1.setString(2,orderid);
				pstmt1.setString(3,order_line_num);
				pstmt1.setString(4,P_REQUEST_NUM);
				pstmt1.setString(5,P_REQUEST_LINE_NUM);
				pstmt1.setString(6,P_LANGUAGE_ID);
				pstmt1.setString(7,Commenttype1);
				
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					addInfo =rs1.getString(1);
					System.err.println("addInfo--"+addInfo);
				}
				

	}catch(Exception e)
		{
			System.out.println("Exception while executing Order line Additional Info :"+e);
		}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(addInfo));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(cliniccmt));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(addInfo));
            _bw.write(_wl_block11Bytes, _wl_block11);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
