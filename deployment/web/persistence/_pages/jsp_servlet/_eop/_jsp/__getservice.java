package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __getservice extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/getservice.jsp", 1731310487512L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\t\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t//var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].service.add(opt);\n\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t//var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\t//parent.document.frames[1].document.forms[0].service_desc.add(opt);\n\t\t\t\tparent.f_query_add_mod.document.forms[0].service_desc.add(opt);\n\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */\n                var temp1=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"+\" \"+\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t/*CRF end SS-CRF-0010 [IN034516]*/\n\t\t\t\tvar temp2=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t//var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp2;\n\t\t\t\t/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */\n                //parent.document.frames[1].document.forms[0].room_desc.add(opt);\n\t\t\t\tparent.f_query_add_mod.document.forms[0].room_desc.add(opt);\n\t\t\t\t/*CRF end SS-CRF-0010 [IN034516]*/\n\t\t\t\t\t\t\n\t\t\t</script>\n\t\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t//var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp;\n\t\t\t\topt.value=temp1;\n\t\t\t\t//parent.document.frames[1].document.forms[0].visit_type_desc.add(opt);\n\t\t\t\tparent.f_query_add_mod.document.forms[0].visit_type_desc.add(opt);\n\t\t\t\t\t\t\n\t\t\t</script>\n\t\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<script>\n\t\t\tvar open_pract_yn = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\tparent.f_query_add_mod.document.forms[0].open_pract_yn.value=open_pract_yn;\n\t\t\t</script>\n\t\t\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].service_code.add(opt);\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t//var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp;\n\t\t\t\topt.value=temp1;\n\t\t\t\t//parent.document.frames[1].document.forms[0].sub_service_desc.add(opt);\n\t\t\t\tparent.f_query_add_mod.document.forms[0].sub_service_desc.add(opt);\n\t\t\t\t\t\t\n\t\t\t</script>\n\t\n\t\t";
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
   String facilityid = request.getParameter("operating_facility_id");
   String   locale = (String)session.getValue("LOCALE");
   String facility_id =  (String) session.getValue( "facility_id" ) ;
  String  locncode=request.getParameter("locn_code");
  String  flag =request.getParameter("flag");
  String service_code=request.getParameter("service_code");
  String subservicecode="";
  String subservicedesc="";
  String open_pract_yn="";
  /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
  String room_short_desc="";
  /*CRF end SS-CRF-0010 [IN034516]*/
   if(flag ==null  ) flag="";
    if(locncode==null)locncode="";
     Connection con = null;
	try
	{
		con=ConnectionManager.getConnection(request);

		PreparedStatement pstmt=null;
		ResultSet rs;
		//commented  by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003

		String servicecode="";
		String servicedesc="";	
        String roomcode="";
		String roomdesc="";
		String  visittypecode="";
		String   visittypedesc="";
		String sql="";
		
		if(flag.equals("visit_type"))
		{
		sql ="SELECT   service_code,  short_desc FROM   am_service_lang_vw WHERE  language_id=? and eff_status = 'E' AND service_code in (SELECT service_code FROM op_clinic WHERE clinic_code =? AND   facility_id=? UNION SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code =? AND b.facility_id=? and b.care_locn_type_ind = 'C') order by 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locncode);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,locncode);
		pstmt.setString(5,facility_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			servicecode=rs.getString("service_code");
			servicedesc=rs.getString("short_desc");
			
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
				}
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				
		}
		else if(flag.equals("visit_details"))
		{

   		sql ="SELECT   service_code,  short_desc FROM   am_service_lang_vw WHERE  language_id=? and eff_status = 'E' AND service_code in (SELECT service_code FROM op_clinic WHERE clinic_code =? AND   facility_id=? UNION SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code =? AND b.facility_id=? and b.care_locn_type_ind = 'C') order by 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locncode);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,locncode);
		pstmt.setString(5,facility_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			servicecode=rs.getString("service_code");
			servicedesc=rs.getString("short_desc");
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
	
	if(pstmt != null) pstmt.close();
	if (rs != null) rs.close();
	// query tuning.. modified by venkat S
	 /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */

	sql ="SELECT a.practitioner_id ROOM_NO, b.room_type room_type,am_get_desc.am_facility_room (a.facility_id,a.practitioner_id,?, 2) room_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id=? AND a.clinic_code=? AND  a.eff_status='E' AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID ";
	/*CRF end SS-CRF-0010 [IN034516]*/
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,locncode);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			roomcode       =rs.getString("ROOM_NO");
			roomdesc       =rs.getString("room_type");
			/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
            room_short_desc=rs.getString("room_desc");
			/*CRF end SS-CRF-0010 [IN034516]*/
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(roomdesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(roomcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(room_short_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(roomcode));
            _bw.write(_wl_block14Bytes, _wl_block14);

	
	}
		
		if(pstmt != null) pstmt.close();
	if (rs != null) rs.close();
	
	sql ="select visit_type_code, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, VISIT_TYPE_CODE,?,'2') short_desc from op_visit_type_for_clinic where facility_id = ? and clinic_code =? and eff_status='E' order by 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,locncode);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			visittypecode=rs.getString("visit_type_code");
			visittypedesc=rs.getString("short_desc");
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(visittypedesc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(visittypecode));
            _bw.write(_wl_block15Bytes, _wl_block15);

	
	}
		
			if(pstmt != null) pstmt.close();
	    if (rs != null) rs.close();
		sql ="select open_to_all_pract_yn from op_clinic where facility_id=? and clinic_code=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locncode);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
		open_pract_yn=rs.getString("open_to_all_pract_yn");
		
			}
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(open_pract_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
	}	
		else {
		
			sql="Select distinct service_code,service_short_desc from am_facility_service_vw where eff_status='E' and operating_facility_id= ? order by service_short_desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,facilityid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				servicecode=rs.getString("service_code");
				servicedesc=rs.getString("service_short_desc");
		
			
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
		 	 
		}
				

		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
if(flag.equals("sub service"))
		{
		
	
	sql ="SELECT  SUBSERVICE_CODE subservice_code, AM_GET_DESC.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,?,'2') short_desc FROM AM_FACILITY_SUBSRVC WHERE  OPERATING_FACILITY_ID=? AND  SERVICE_CODE=? ORDER BY 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,service_code);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			subservicecode=rs.getString("subservice_code");
			subservicedesc=rs.getString("short_desc");
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(subservicedesc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(subservicecode));
            _bw.write(_wl_block21Bytes, _wl_block21);

	
	}
		
		if(pstmt != null) pstmt.close();
	if (rs != null) rs.close();
		
		
		}




String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	
	
	}

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
