package jsp_servlet._eip._jsp;

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

public final class __servervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ServerValidation.jsp", 1742461310343L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</head>\n<body class=MESSAGE onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\tvar n=\"\";\n\t\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'==\'MODIFY_SERVICE_FOR_INPATIENT\')\n\t\t\tn = parent.frames[1].document.getElementById(\'sub_service\').options.length;\n\t\telse\n\t\t\tn = parent.frames[1].document.getElementById(\'floor\').options.length;\n\n\t\n\tfor(var i=0;i<n;i++)\n\t{ \n\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'==\'MODIFY_SERVICE_FOR_INPATIENT\')\n\t\t\tparent.frames[1].document.getElementById(\'sub_service\').remove(0);\n\t\telse\n\t\t\tparent.frames[1].document.getElementById(\'floor\').remove(0);\t\t\n\t}\n\tvar tp =\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\topt.text=tp;\n\topt.value=\"\";\n\tif(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'==\'MODIFY_SERVICE_FOR_INPATIENT\')\n\t\tparent.frames[1].document.getElementById(\'sub_service\').add(opt);\n\telse\n\t\tparent.frames[1].document.getElementById(\'floor\').add(opt);\n</script>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar oOption = f.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\toOption.text=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t\toOption.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\tf.document.getElementById(\'sub_service\').add(oOption);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\t\tf.document.getElementById(\'floor\').add(oOption);\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" == \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\")\n\t\t\t\t\t\t\t\t\toOption.selected = true;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String facilityId = (String) session.getValue("facility_id");

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		out.println("<script>var f = parent.frames[1];</script>");
		
		String bldngcode = request.getParameter("building_code")==null?"":request.getParameter("building_code");
		String floorcode = request.getParameter("floor_code")==null?"":request.getParameter("floor_code");
		String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String service_code = request.getParameter("serviceCode")==null?"":request.getParameter("serviceCode");
		String code = "";
		String desc = "";
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(function_id!=null && function_id.equals("MODIFY_SERVICE_FOR_INPATIENT"))
		{
			String	sql = "Select SUBSERVICE_CODE,am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+localeName+"',2 ) SUBSERVICE_SHORT_DESC from am_facility_subsrvc where OPERATING_FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND SERVICE_CODE = '"+service_code+"' order by 2 ";

			rs = stmt.executeQuery(sql);

			if( rs!=null )
			{
				while(rs.next())
				{
					code = rs.getString("SUBSERVICE_CODE");
					desc = rs.getString("SUBSERVICE_SHORT_DESC");
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
			}
		}
		else
		{
			String	sql = " select FLOOR_CODE,SHORT_DESC from am_bldng_floor where OPERATING_FACILITY_ID = '"+facilityId+"' and BLDNG_CODE = '"+bldngcode+"' and EFF_STATUS = 'E' order by SHORT_DESC  ";
			rs = stmt.executeQuery(sql);
			if( rs!=null )
			{
				while(rs.next())
				{
					code = rs.getString("FLOOR_CODE");
					desc = rs.getString("SHORT_DESC");
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(floorcode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(code));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			}
		}	
   
	}catch (Exception e){
		out.println(e);
	}
	finally{
		if(stmt != null) stmt.close();
		if(rs!=null) rs.close();
		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
