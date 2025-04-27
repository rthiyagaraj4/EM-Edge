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
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patcheckoutgetval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/PatCheckoutGetVal.jsp", 1709119462288L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<script language=\'javascript\' src=\'../../eOP/js/PatCheckout.js\'></script>\n   <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown=\'lockKey();\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\telement.text = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\t\t\t\t\t\t\t\telement.value= \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].destinationlocation.add(element);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\t\telement.text = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n\t\t\t\t\t\t\t\t\telement.value= \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].service.add(element);\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].destinationlocation.add(element);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].service.add(element);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n\t\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].service.add(element);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<script>\t\n\t\t\t\t\tparent.frames[1].document.getElementById(\"pract_type\").value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\tparent.frames[1].document.getElementById(\"pract_speciality\").value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\tparent.frames[1].document.getElementById(\"disptypename\").innerText=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs		 	= null;
	String sql		=" ";
	String locale=(String)session.getAttribute("LOCALE");
	String practtype="";
	String typedesc = "";
	String practspeciality="";
	String  fac_id  	= (String) session.getValue( "facility_id" ) ;
	String  pracid	= request.getParameter("practitionerid");
	if(pracid == null) pracid="";

	String  desttype	= request.getParameter("dest_type");	
	if(desttype == null) desttype="";

	try
	{
		conn=ConnectionManager.getConnection(request);
		if(desttype.length() != 0)
		{			
			try
			{
				if(desttype.equals("XF"))
				{							
					sql = "Select LONG_DESC, referral_code from AM_REFERRAL_lang_vw where eff_status = 'E' and dest_use_at_concl_yn = 'Y' and  language_id='"+locale+"' and facility_id = '"+fac_id+"' order by short_desc";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();							
					if( rs != null )
					{
						while( rs.next() )
						{
								 String refid = rs.getString( "referral_code" ) ;
								 String refname = rs.getString( "LONG_DESC" ) ;
						
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(refname));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(refid));
            _bw.write(_wl_block8Bytes, _wl_block8);

						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close(); 
			
					sql = "Select short_desc, service_code from AM_SERVICE_lang_vw where eff_status = 'E' and  language_id='"+locale+"' order by short_desc";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if( rs != null )
					{
							while( rs.next() )
							{
								String serid = rs.getString( "service_code" ) ;
								String serdesc = rs.getString( "short_desc" ) ;
								
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(serdesc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(serid));
            _bw.write(_wl_block11Bytes, _wl_block11);

							}
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

				}
				else if(desttype.equals("ZF"))
				{
							
					sql = "Select facility_name, facility_id from SM_FACILITY_PARAM_lang_vw where facility_id != '"+fac_id+"' and language_id='"+locale+"'order by facility_name";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
							
					if( rs != null )
					{
						while( rs.next() )
						{
							 String facid = rs.getString( "facility_id" ) ;
							 String facname = rs.getString( "facility_name" ) ;
							
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(facname));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facid));
            _bw.write(_wl_block12Bytes, _wl_block12);

						}
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
							
					sql = "Select short_desc, service_code from AM_SERVICE_lang_vw where language_id='"+locale+"' and eff_status = 'E' order by short_desc";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if( rs != null )
					{
						while( rs.next() )
						{
							 String serid = rs.getString( "service_code" ) ;
							 String serdesc = rs.getString( "short_desc" ) ;
							
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(serdesc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(serid));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else if(desttype.equals("OP"))
				{						
					sql = "Select long_desc, clinic_code from op_clinic_lang_vw where facility_id = '"+fac_id+"' and eff_status='E' and language_id='"+locale+"' Order By 1";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();						
					if( rs != null )
					{
						while( rs.next() )
						{
							 String facid = rs.getString( "clinic_code" ) ;
							 String facname = rs.getString( "long_desc" ) ;
							
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(facname));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facid));
            _bw.write(_wl_block12Bytes, _wl_block12);

						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					sql = "SELECT   Am_Get_desc.Am_service(Service_COde,'"+locale+"',2) service_short_desc, service_code FROM     AM_FACILITY_SERVICE WHERE    eff_status = 'E'   AND operating_facility_id = '"+fac_id+"'		ORDER BY 1";		
					
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if( rs != null )
					{
						while( rs.next() )
						{
							 String serid = rs.getString( "service_code" ) ;
							 String serdesc = rs.getString( "service_short_desc" ) ;
							
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(serdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(serid));
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
			}
			catch ( Exception e ){ }
		}
		else if(pracid.length() != 0)
		{
			try
			{	sql  ="SELECT   pract_type,am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) Pract_type_desc,  PRIMARY_SPECIALITY_CODE FROM   AM_PRACT_FOR_FACILITY a,am_practitioner b WHERE   facility_id = '"+fac_id+"' AND  a.practitioner_id ='"+pracid+"' AND a.practitioner_id=b.practitioner_id";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					practtype=rs.getString("pract_type");
					typedesc = rs.getString( "Pract_type_desc" ) ;
					practspeciality=rs.getString("PRIMARY_SPECIALITY_CODE");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practtype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practspeciality));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(typedesc));
            _bw.write(_wl_block20Bytes, _wl_block20);
					
			}
			catch ( Exception e ){ }
		}
		
	}catch(Exception ec){}
	finally
	{
		//Added by raj on 10/17/2003 while handling unclosed statements, resultsets and connections
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}catch(Exception e){}
		if(conn!=null)
			ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
