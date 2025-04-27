package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __managespatqueuefr2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ManageSPatQueueFr2.jsp", 1744267978755L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tParimala\n\tCreated on \t\t:\t22/12/2000\n\tModule\t\t\t:\tOut Patient Management\n\tFunction\t\t:\tThis file is used for displaying of frame 1 & 2 as- below.\n-->\n    \n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <script src=\"../../eOP/js/ManageSPatQueue.js\"></script>\n <script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\t\t\n\t\t\talert(getMessage(\"CA_NOT_INSTALLED\",\"COMMON\"));\n            document.location.href =\'../../eCommon/jsp/dmenu.jsp\'\n\t\t</script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<!-- Below is defined another frameset :\n\t\t1.\tThe first frame is for the query criteria to be given.\n\t\t2.\tThe second frame is initially blank.\n\t\t3.\tThe third frame is a dummy frame for any intermediate validations.-->\n\t\t\n\t\t<!--Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297]  -->\n\t\t<iframe name=\'frame1\' id=\'frame1\' \tsrc=\'../../eOP/jsp/ManageSPatQueueQueryCriteria.jsp?function_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Vitalsign=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&ChkOut=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Que=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&refresh=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&oper_stn_access_rule=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&oper_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&pat_id_length=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&sdate=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&bl_package_enabled_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&action_on_pending_bill=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =";width:99vw\'></iframe>\n\t\t<iframe name=\'searchbutton\' id=\'searchbutton\' src=\'../../eOP/jsp/ManagePatQueSearchButton.jsp\' frameborder=0 noresize scrolling=\'auto\'  style=\'height:4vh;width:99vw\'></iframe> \n\t\t<iframe src=\'../../eCommon/html/blank.html\' frameborder=0 name=\'frame2\' id=\'frame2\' noresize  scrolling=\"auto\"  style=\'height:45vh;width:99vw\'></iframe>\n\t\t<iframe src=\'../../eCommon/html/blank.html\' frameborder=0 name=\'checkbox\' id=\'checkbox\'  FRAMEBORDER=NO   marginwidth=\'5\' scrolling=\'auto\' noresize style=\'height:4vh;width:99vw\'></iframe>\n\t\n\t<!-- end Bru-HIMS-CRF-179 [IN030297] -->\n\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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

    
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ; 
	String function_id=request.getParameter("function_id");
     if(function_id == null) function_id = "";
     
	String Vitalsign = request.getParameter("Vitalsign");
	String ChkOut = request.getParameter("ChkOut");
	String Que = request.getParameter("Que");
	String rfresh_param = request.getParameter("refresh");
	String oper_stn_access_rule=request.getParameter("oper_stn_access_rule");
	String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");

	String ca_install_yn = "";
	String pat_id_length = request.getParameter("pat_id_length")==null?"":request.getParameter("pat_id_length");
	String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"N":request.getParameter("bl_package_enabled_yn");
	String sdate = request.getParameter("sdate")==null?"":request.getParameter("sdate");
	
	String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]
	if((Vitalsign != null && Vitalsign.equals("Vitalsign")) && ChkOut == null)
	{
		ca_install_yn = request.getParameter("ca_install_yn")==null?"N":request.getParameter("ca_install_yn");
	}

	
	String frame1Height = "38vh";
	
	if (ChkOut != null && ChkOut.equalsIgnoreCase("ChkOut"))
		frame1Height = "34vh";
	/*
	
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//String ca_install_yn="";

	if((Vitalsign != null && Vitalsign.equals("Vitalsign")) && ChkOut == null)
	{
		ca_install_yn="N";
	}
	Connection con=null;

	try{
		con=ConnectionManager.getConnection(request);

		if((Vitalsign != null && Vitalsign.equals("Vitalsign")) && ChkOut == null)
		{
		
			pstmt = con.prepareStatement("select install_yn from sm_module where module_id ='CA'");
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
			  while (rs.next())
			  {
				  ca_install_yn = rs.getString("install_yn");
			  }
			}
			if (pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con != null) 
			ConnectionManager.returnConnection(con,request);

	}
*/
// The below if condition tells if the CA module is installed the function is proceeded further or else and alert is displayed.
	if(ca_install_yn.equals("N"))
	{
	
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Vitalsign));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ChkOut));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Que));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rfresh_param));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Que));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oper_stn_access_rule));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oper_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bl_package_enabled_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(action_on_pending_bill));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(frame1Height));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
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
