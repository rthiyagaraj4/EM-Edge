package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __subserviceinfacilitypopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/SubserviceinfacilityPopulate.jsp", 1711007961287L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<html>\n\t\t\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\n\t\t\t<script>\n\t\t\t\tvar n=parent.f_query_add_mod.document.getElementById(\'service_code\').options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'service_code\').remove(\"service_code\");\t\t\t\t\n\t\t\t\t}\t\t\t\n\t\t\t\tvar tp =\" ---Select--- \";\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=tp;\n\t\t\t\topt.value=\"\";\n\t\t\t\tparent.f_query_add_mod.document.getElementById(\'service_code\').add(opt);\t\t\t\t\t\n\t\t\t</script>\t        \n\t\t\t\t        \n\t\t\t\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\n\t\t<html>\n\t\t\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar n=parent.f_query_add_mod.document.getElementById(\'dept_code\').options.length;\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'dept_code\').remove(\"dept_code\");\t\t\t\t\n\t\t\t\t\t}\t\t\t\n\t\t\t\t\tvar tp =\" ---Select--- \";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'dept_code\').add(opt);\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\tvar n=parent.f_query_add_mod.document.getElementById(\'subservice_code\').options.length;\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'subservice_code\').remove(\"subservice_code\");\t\t\t\t\n\t\t\t\t\t}\t\t\t\n\t\t\t\t\tvar tp =\" ---Select--- \";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'subservice_code\').add(opt);\t\t\t\t\t\n\t\t\t\t</script>\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</script>\n\t\t\t  </head>\n\t\t\t  <body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'></body>\n\t\t\t  </html>\n\t\t\t  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></link>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\t<script>\n\t\t\t\t\tvar n=parent.f_query_add_mod.document.getElementById(\'section_code\').options.length;\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'section_code\').remove(\"section_code\");\t\t\t\t\n\t\t\t\t\t}\t\t\t\n\t\t\t\t\tvar tp =\" ---Select--- \";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'section_code\').add(opt);\t\t\t\t\t\n\t\t\t\t</script>\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</script>\n\t\t\t</head>\n\t\t\t<body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'></body>\n\t\t\t</html>\t\n\t";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8");	
	String getservice = request.getParameter("getservice")==null ? "" : request.getParameter("getservice");
	String opfacilityid = request.getParameter("facility_id");

	Connection con= null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;

try
{	
	con = ConnectionManager.getConnection(request);	
		
	if(getservice.equals("one"))
	{
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		pstmt 	= con.prepareStatement( "Select distinct service_code,service_short_desc from am_facility_service_vw where operating_facility_id ='"+opfacilityid+"' and eff_status='E' order by service_short_desc" ) ;
		rs = pstmt.executeQuery() ;
		String str1 = "";
		String str2 = "";
		if( rs != null ) 
		{

            _bw.write(_wl_block5Bytes, _wl_block5);
 			while( rs.next() ) 
			{
				str1 = rs.getString( "service_code" ) ;
				str2 = rs.getString( "service_short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str2+"\";"+ "element.value= \""+str1+"\";"+"parent.f_query_add_mod.document.subserviceinfacility_form.service_code.add(element);</script>");
			}
		}
		if(rs!=null)rs.close();
		pstmt.close() ;      		
		out.println("</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>");		
	}
	else if(getservice.equals("two"))
	{
	//Sub service

		String servicecode  = request.getParameter("service_code");
		String opfacilityid1 = request.getParameter("facility_id");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		pstmt 	= con.prepareStatement( "Select subservice_code,short_desc from am_subservice where service_code ='"+servicecode+"' and eff_status = 'E' order by upper(short_desc)" ) ;
		
		rs = pstmt.executeQuery() ;
		String str3 = "";
		String str4 = "";
		if( rs != null ) 
		{

            _bw.write(_wl_block8Bytes, _wl_block8);

	
			while( rs.next() ) 
			{
				str3 = rs.getString( "subservice_code" ) ;
				str4 = rs.getString( "short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str4+"\";"+ "element.value= \""+str3+"\";"+"parent.f_query_add_mod.document.subserviceinfacility_form.subservice_code.add(element);</script>");
			}
		}
		if(rs!=null)rs.close();
		pstmt.close() ;   
	
		pstmt 	= con.prepareStatement("Select dept_short_desc,dept_code from am_facility_service_vw where operating_facility_id ='"+opfacilityid1+"' and service_code ='"+servicecode+"'" ) ;
		rs = pstmt.executeQuery() ;
		String str7 = "";
		String str8 = "";
		if( rs != null ) 
		{
		        
			while( rs.next() ) 
			{
				str7 = rs.getString( "dept_code" ) ;
				str8 = rs.getString( "dept_short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str8+"\";"+ "element.value= \""+str7+"\";"+"parent.f_query_add_mod.document.subserviceinfacility_form.dept_code.add(element);</script>");
			}
		}
		
		  
            _bw.write(_wl_block9Bytes, _wl_block9);

	  if(rs!=null)rs.close();
	  if(pstmt!=null)pstmt.close();
	}
  
	else {
	
		
		String deptcode = request.getParameter("dept_code");
		String opfacilityid2 = request.getParameter("facility_id");

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
	
		pstmt 	= con.prepareStatement( "Select section_code,section_short_desc from am_facility_section_vw where operating_facility_id ='"+opfacilityid2+"' and dept_code ='"+deptcode+"' order by upper(section_short_desc)" ) ;
		
		rs = pstmt.executeQuery() ;
		
		String str5 = "";
		String str6 = "";
		if( rs != null ) 
		
		{

            _bw.write(_wl_block12Bytes, _wl_block12);
				
			while( rs.next() ) 
			{
		
				str5 = rs.getString( "section_short_desc" ) ;
				str6 = rs.getString( "section_code" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+"element.text = \""+str5+"\";"+ "element.value= \""+str6+"\";"+"parent.f_query_add_mod.document.getElementById('section_code').add(element);</script>");
			}
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
}
catch(Exception e)
{}
finally
	{
	try
	{
	 if (rs != null)	  rs.close();
	 if (pstmt != null)   pstmt.close();
	}
	catch(Exception e)
	{}
	 ConnectionManager.returnConnection(con,request);
}
  

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
