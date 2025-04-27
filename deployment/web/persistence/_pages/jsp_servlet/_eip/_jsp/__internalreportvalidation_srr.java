package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __internalreportvalidation_srr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/internalReportValidation_SRR.jsp", 1742387209286L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\t\t \n\t\t/*var opt1=parent.frames[1].document.createElement(\'OPTION\');\n\t\tvar opt2=parent.frames[1].document.createElement(\'OPTION\');\n\t\t\n\t\topt1.value=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\n\t\topt2.value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\topt1.text=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\topt2.text=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\n\t\tparent.frames[1].document.forms[0].P_FM_REF_CODE.add(opt1);\n\t\tparent.frames[1].document.forms[0].P_TO_REF_CODE.add(opt2);*/\n\n     \n\n\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

Connection con = null;
ResultSet rs=null;



try
{
	Properties p;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	con = ConnectionManager.getConnection(request);
	Statement stmt = con.createStatement();

    String locale = (String)session.getAttribute("LOCALE");
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;

    
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;

   

    String p_ref_type		=(String) hash.get("p_ref_type");
	if(p_ref_type ==null) p_ref_type="";

	

	String steps		=(String) hash.get("steps");
	if(steps ==null) steps="";
   

	if(steps.equals("1"))
	{
		
		
	String list_sql="";
	String list_code="";
	String list_desc="";
	
	if(p_ref_type.equals("L")){
   
		//list_sql="Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='en' and STATUS = 'E' and facility_id='HS' order by 1";
		list_sql="Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='"+locale+"' and STATUS = 'E' and facility_id='"+p_facility_id+"' order by 1";


	
	}else if(p_ref_type.equals("E")){
		list_sql="Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='"+locale+"' and STATUS = 'E' order by 1";
	}else if(p_ref_type.equals("X")){
		list_sql="Select short_desc, referral_Code from am_referral_lang_vw where language_id='"+locale+"' and eff_status = 'E' order by 1";
	}
	
 if (rs!=null) rs.close();
 
	 	

	rs = stmt.executeQuery(list_sql);
	 while(rs!=null && rs.next()){
		 list_desc=rs.getString(1);
		 list_code=rs.getString(2);
		 

		 
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(list_code));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(list_code));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(list_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(list_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
}
 

 
}

if (rs !=null) rs.close();
if (stmt !=null) stmt.close();

hash.clear();


	}
	
	
catch(Exception e)
{
	out.println(e.toString());
	e.printStackTrace();
}
finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
