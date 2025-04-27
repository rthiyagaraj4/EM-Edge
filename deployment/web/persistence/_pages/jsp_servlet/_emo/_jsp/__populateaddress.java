package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __populateaddress extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/PopulateAddress.jsp", 1709118435321L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<HTML>\n<HEAD>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eMO/js/MOAreaAvailabilityQueryCriteria.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</HEAD>\n<BODY CLASS=\'MESSAGE\' onKeyDown=\"lockKey()\">\n  <form name=\'testform\' id=\'testform\'>\n   ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t  \n\n   ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\t<script>\n\tif(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =".document.forms[0].area!=null)\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =".document.forms[0].area.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\tif(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =".document.forms[0].area1!=null)\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =".document.forms[0].area1.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =".document.forms[0].region!=null)\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =".document.forms[0].region.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"\n\t\tif(";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =".document.forms[0].region1!=null)\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =".document.forms[0].region1.value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\n\t</script>\n\t \n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>\n\tif(";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\t\n\t\tif(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\n\t</script>\n\t\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t  \n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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

     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String areaCode	    = 	"";
	String townCode	    = 	"";
    String area_code    ="";
	String selopt="";
	String res_area_desc="";
    String region_code="";
    String region_desc="";
	String framsel="";
	areaCode             =request.getParameter("areaCode")==null?"":request.getParameter("areaCode");
	townCode            = request.getParameter("townCode")==null?"":request.getParameter("townCode");
	
	framsel                = request.getParameter("framsel")==null?"":request.getParameter("framsel");
	
	
	if(framsel.equals("fram1"))
	{
	framsel="parent.frames[0]";
	
	}else
	{
    framsel="parent.frames[3]";
	}
	
	
	Connection con 	= null;
	Statement st    = null;
	ResultSet rs    = null; 
	try
	{
    con = ConnectionManager.getConnection(request);
	
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	
    if(!townCode.equals(""))
	{
	//selopt="select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area a, mp_region b where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+townCode+"') and a.region_code = b.region_code";

	selopt="select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from MP_RES_AREA_LANG_VW a, MP_REGION_LANG_VW b where a.LANGUAGE_ID='"+localeName+"' and b.LANGUAGE_ID='"+localeName+"' and res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+townCode+"') and a.region_code = b.region_code";

	st=con.createStatement();
	rs=st.executeQuery(selopt);
	while(rs.next())
	{
	area_code=rs.getString("res_area_code");
	res_area_desc=rs.getString("res_area_desc");
	region_code=rs.getString("region_code");
	region_desc=rs.getString("region_desc");
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
	}
	else
	{
	 //selopt="select region_code,long_desc from mp_region where  region_code = (select region_code from mp_res_area  where res_area_code = '"+areaCode +"')";
	 selopt="select region_code,long_desc from MP_REGION_LANG_VW where  LANGUAGE_ID='"+localeName+"' and region_code = (select region_code from mp_res_area  where res_area_code = '"+areaCode +"')";
	 st=con.createStatement();
	rs=st.executeQuery(selopt);
	while(rs.next())
	{
	region_code=rs.getString("region_code");
	region_desc=rs.getString("long_desc");
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
	}
            _bw.write(_wl_block24Bytes, _wl_block24);
	if(st != null)	st.close();
	if(rs!= null)	rs.close();
	}
	catch(Exception e)
	{
	out.print(e);
	}
	finally
	{
	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
