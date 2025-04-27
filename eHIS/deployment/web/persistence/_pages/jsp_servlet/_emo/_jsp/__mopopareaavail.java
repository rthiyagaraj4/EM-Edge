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

public final class __mopopareaavail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOPopAreaAvail.jsp", 1709118413321L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<HTML>\n<HEAD>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eMO/js/MOAreaAvailabilityQueryCriteria.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</HEAD>\n<BODY CLASS=\'MESSAGE\' onKeyDown=\"lockKey()\">\n  <form name=\'testform\' id=\'testform\'>\n   ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t  <script>\n\n   \t\t  var n = ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =".document.forms[0].area_code.length;\n\t\t\t for(var i=0;i<n;i++)\n\t\t\t {\n\t\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =".document.forms[0].area_code.remove(\"short_desc\");\t\n\t\t\t }\n\t\t\t var temp = \"\";\n\t\t\t var temp1=\"--------\"+getLabel(\'Common.defaultSelect.label\',\'MP\')+\"--------\";\n\t\t\t var opt=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =".document.createElement(\'OPTION\');\n\t\t\t opt.text=temp1;\n\t\t\t opt.value=temp;\n\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =".document.forms[0].area_code.add(opt);\t\n\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =".document.forms[0].area_code.options[0].selected = true;\n\t\t  </script>\n\n   ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t  <script>\n\t\t\t var element = ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =".document.createElement(\'OPTION\');\n\t\t\t element.text = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t element.value= \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t element.selected=false;\n             ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =".document.forms[0].area_code.add(element);\n\t\t\t\t\n\t\t  </script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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

	String areaval	= 	"";
	String dat4	    = 	"";
	String ID4	    = 	"";
	String selopt	= 	"";
	String status	= 	"";
	String framsel="";
	areaval         = request.getParameter("areaval");
	status          = request.getParameter("status");
	framsel          = request.getParameter("framsel");
	String mode     = request.getParameter("mode");
	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
    if(mode ==  null) mode="";
	if(framsel ==  null) framsel="";

		
	if(framsel.equals("fram1"))
	{
	framsel="parent.frames[0]";
	
	}else
	{
    framsel="parent.frames[1]";
	}
	
	if(areaval ==  null) areaval="";
	if(status ==  null)  status="";

	Connection con 	= null;
	Statement st    = null;
	ResultSet rs    = null; 
	try
	{
    con = ConnectionManager.getConnection(request);
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
	st=con.createStatement();
    if(areaval.equals(""))
	{
	
	
	
	if(status.equals("R"))
	{if(mode.equals("callfrommoreg")||mode.equals("")||mode.equals("callfrombdyprt"))
	{
	// selopt="select area_code,short_desc from mo_area union select '*' area_code,'Unassigned' short_desc from dual order by 2";
	 selopt 	 ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facilityId+"' AND language_id='"+localeName+"'  union select '*' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels")+"' short_desc from dual order by 2  ";
	
	}else{
	// selopt="select area_code,short_desc from mo_area union select '*' area_code,'Unassigned' short_desc from dual union select '$' area_code,'Unregistered' short_desc from dual order by short_desc";
	 selopt ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facilityId+"' AND language_id='"+localeName+"' union select '*' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels")+"' short_desc from dual union select '$' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Unregistered.label","mo_labels")+"' short_desc from dual order by short_desc";

	
	}
	}
	else
	{
	// selopt ="select area_code,short_desc from mo_area order by short_desc"	;
	 selopt ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facilityId+"' AND language_id='"+localeName+"' order by short_desc"	;
	}
	}
	else
	{
	 //selopt ="select area_code,short_desc from mo_area where area_type='"+areaval+"'order by short_desc"	;	
	 selopt ="select area_code,short_desc from mo_area_lang_vw where area_type='"+areaval+"' and facility_id = '"+facilityId+"' AND language_id='"+localeName+"' order by short_desc"	;	
	}

	rs=st.executeQuery(selopt);

	if(rs!=null)
	{
			while(rs.next())
			{
			
				dat4 = rs.getString("short_desc");
				ID4 = rs.getString("area_code");
    
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dat4));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ID4));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(framsel));
            _bw.write(_wl_block18Bytes, _wl_block18);
			
		    }
	}	
	if(st != null)	st.close();
	if(rs!= null)	rs.close();
	}
	catch(Exception e)
	{
	out.print(e);
	e.printStackTrace();
	}
	finally
	{
	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
