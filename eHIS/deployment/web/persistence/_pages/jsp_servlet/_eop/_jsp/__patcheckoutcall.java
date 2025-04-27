package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patcheckoutcall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/PatCheckoutCall.jsp", 1735559326681L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<HEAD>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t\t \n\t\t\t\t<!-- <FRAMESET ROWS=\'9%,88%,0%,0%\' framespacing=0> -->  \n\t\t\t\t\n\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t\t<!-- <FRAMESET ROWS=\'9%,88%,0%\' framespacing=0> -->  \n\t\t\t\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\n\t\t\t\t<iframe NAME=\'PLINE\' SRC=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Facility_Id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' noresize  frameborder=no scrolling=\'no\' style=\'height:";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'detail\' src=\'../../eOP/jsp/PatCheckoutModel.jsp?function_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&encounterid=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&practitionerid=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&locationcode=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&patientid=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&locationtype=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&episode_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&visit_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&oper_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&package_bl_install_YN=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&isPatientEncMovement=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&Sydate=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&five_level_triage_appl_yn=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\' style=\'height:";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =";width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'Dummy_frame\' src=\'../../eCommon/html/blank.html\' framesetborder=0 frameborder=0 noresize scrolling=\'no\' style=\'height:";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =";width:99vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame\' src=\'../../eCommon/html/blank.html\' framesetborder=0 frameborder=0 noresize scrolling=\'no\' style=\'height:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =";width:99vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t <iframe name=\'billingfr\' src=\'../../eBL/jsp/BLSessionValuesReset.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<!-- </FRAMESET> -->\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n    </HEAD>\n</html>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		
		String tit=request.getParameter("title");
        if(tit==null)
            tit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
          
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(tit));
            _bw.write(_wl_block7Bytes, _wl_block7);
  
		
		String encounterid=request.getParameter("p3");
		String practitionerid = request.getParameter("p6");
        String locationcode = request.getParameter("p5");
        String patientid = request.getParameter("p2");
        String locationtype = request.getParameter("p4");
        String facility= (String) session.getValue( "facility_id" ) ;
		String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
       	String module_id = request.getParameter("module_id");
		String oper_id = request.getParameter("oper_id")==null?"":request.getParameter("oper_id");

		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String episode_id=request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");	
		String package_bl_install_YN = request.getParameter("package_bl_install_YN")==null?"N":request.getParameter("package_bl_install_YN");
		String five_level_triage_appl_yn = request.getParameter("five_level_triage_appl_yn")==null?"N":request.getParameter("five_level_triage_appl_yn");
        /*Below line added for this CRF Bru-HIMS-CRF-133*/         	
		 String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		 String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");		 
		 
		 //End Bru-HIMS-CRF-133

		if(module_id==null) module_id="";
		 String height1="";
		 String height2="";
		 String height3="";
		 String height4="";
	try{
		
		 if(bl_install_yn.equals("Y")){
			    height1="11vh";
			    height2="86vh";
			    height3="0vh";
			    height4="0vh";
			 
            _bw.write(_wl_block8Bytes, _wl_block8);
} else {
				height1="11vh";
			    height2="86vh";
			    height3="0vh";
			    height4="0vh";
			 
			 
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locationcode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locationtype));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oper_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(package_bl_install_YN));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(bl_install_yn.equals("Y")) { 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block32Bytes, _wl_block32);

		
	}catch(Exception e){out.println("Errorr"+e);
			e.printStackTrace();					
	} 
	    
	
            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
