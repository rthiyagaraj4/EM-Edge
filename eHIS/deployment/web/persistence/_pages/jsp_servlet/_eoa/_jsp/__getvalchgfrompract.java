package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __getvalchgfrompract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/GetValChgFromPract.jsp", 1709119237037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n  <head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n  </head>\n  <body class=\'MESSAGE\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n  <form name=\'temporary1\' id=\'temporary1\'>\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n        \n        <script language=\'javascript\'>\n             var opt1;\n\t     opt1 = parent.f_query_add_mod.f_search.document.createElement(\"OPTION\");\n\t     opt1.text = \' ---------";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="--------- \';\n\t     opt1.value=\'\';\n             parent.f_query_add_mod.f_search.document.ChangePract_form.pract_to.add(opt1);\n        </script> \n        \n     ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n        <script language=\'javascript\'>\n          var opt;\n          opt = parent.f_query_add_mod.f_search.document.createElement(\"OPTION\");\n          opt.text = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n          opt.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n          parent.f_query_add_mod.f_search.document.ChangePract_form.pract_to.add(opt); \n        </script>  \n      ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n   </form>\n  </body> \n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs=null; 
    PreparedStatement pstmt=null;
request.setCharacterEncoding("UTF-8");  
     try {
     	  conn =ConnectionManager.getConnection(request);
          String pract_id= request.getParameter("pract_id");
          String facility_id = request.getParameter("facility_id");
          String loc= request.getParameter("loc");
	     String locale=(String)session.getAttribute("LOCALE");

	  String L_clinic_code="";
	  String L_open_to_all_pract_yn="";
	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");	          
	  StringTokenizer st = new StringTokenizer(loc,"|");
	  while (st.hasMoreTokens()) {
	        L_clinic_code=st.nextToken();
	       st.nextToken();
	        L_open_to_all_pract_yn=st.nextToken(); 
   	  } 

   	  String sql="";
   	  String practitioner_name="";
   	  String practitioner_id="";
           	  
   	  stmt = conn.createStatement(); 
   	  if (L_open_to_all_pract_yn == "Y") {
   	   //  sql="select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name,practitioner_id, from am_pract_for_facility_vw ";
   	     sql="select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1') practitioner_name,practitioner_id, from am_pract_for_facility_vw ";
   	     //sql=sql+"where eff_status='E' and facility_id='"+facility_id+"' and practitioner_id != '"+pract_id+"' order by 1";
   	     sql=sql+"where eff_status='E' and facility_id=? and practitioner_id != ? order by 1";
   	  }   
   	  else {
   	     
      	   //sql="Select a.practitioner_id, b.short_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and language_id = '"+locale+"' and a.eff_status = 'E' and a.facility_id = '"+facility_id+"'and c.facility_id = a.facility_id and c.clinic_code = '"+L_clinic_code+"'  and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and practitioner_id = b.practitioner_id )) and nvl(c.pract_type, b.pract_type) = b.pract_type and a.practitioner_id != '"+pract_id+"' order by 2";
      	   sql="Select a.practitioner_id, b.short_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and language_id = ? and a.eff_status = 'E' and a.facility_id = ? and c.facility_id = a.facility_id and c.clinic_code = ?  and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = ? and practitioner_id = b.practitioner_id )) and nvl(c.pract_type, b.pract_type) = b.pract_type and a.practitioner_id != ? order by 2";
  	     
   	  }
   	 // rs = stmt.executeQuery(sql);
	   pstmt = conn.prepareStatement(sql);
		 if (L_open_to_all_pract_yn == "Y") {
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,pract_id);
		}   
   	  else {
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,L_clinic_code);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,pract_id);
	}
		rs = pstmt.executeQuery();
     
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(default_select));
            _bw.write(_wl_block8Bytes, _wl_block8);
	 if (rs.next() ) {

	   do { 
	         practitioner_name = rs.getString("practitioner_name");
	         practitioner_id = rs.getString("practitioner_id");
      
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( practitioner_name ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( practitioner_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);

	  	  
	   } while(rs.next());
	}
		if (stmt != null) stmt.close(); 
   	  if (rs != null) rs.close();
	} catch (Exception e) {
//out.println( e.toString() );
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
   	finally {
   	  
	  ConnectionManager.returnConnection(conn,request);
   	}
    
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
