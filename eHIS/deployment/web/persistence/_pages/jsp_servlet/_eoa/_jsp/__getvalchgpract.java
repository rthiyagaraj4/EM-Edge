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

public final class __getvalchgpract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/GetValChgPract.jsp", 1709119237178L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n  <head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n     <script language=\'javascript\' src=\'../../eOA/js/ChangePractitionerforGenSch.js\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n   <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n\n   </head>\n  <body class=\'MESSAGE\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n  <form name=\'temporary\' id=\'temporary\'>\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>  \n\t\tparent.f_query_add_mod.f_search.document.ChangePract_form.pract_to.value=\"\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n        <script language=\'javascript\'>\n          clear_select();\n        </script>\n\n     ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n        <script language=\'javascript\'>\n          var opt;\n          opt = parent.f_query_add_mod.f_search.document.createElement(\"OPTION\");\n          opt.text = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n          opt.value= \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';       \n          parent.f_query_add_mod.f_search.document.ChangePract_form.day.add(opt);\n        </script>\n      ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n        <script>\n        </script>\n\n      ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n   </form>\n  </body>\n\n";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


    Connection conn = null;
    Statement stmt = null;
    ResultSet rs=null;
	PreparedStatement pstmt=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    Statement stmt2=null;
    ResultSet rs2=null;
	
            _bw.write(_wl_block7Bytes, _wl_block7);


     try {
		 request.setCharacterEncoding("UTF-8");
		 conn = ConnectionManager.getConnection(request);
          String locn= request.getParameter("locn");
          String facility_id = request.getParameter("facility_id");
          String L_clinic_code="";

   	  StringTokenizer st = new StringTokenizer(locn,"|");
   	  while (st.hasMoreTokens()) {
   	       L_clinic_code=st.nextToken();
   	     st.nextToken();
   	      st.nextToken();
   	  }
   	  stmt = conn.createStatement();
      String sql2="";
      String day_of_week="";
      String day_text="";
      	//sql2="select distinct a.day_no,INITCAP(b.day_of_week) day_of_week from oa_clinic_time_table a, sm_day_of_week b ";
      	//sql2=sql2 + "where a.day_no = b.day_no and a.clinic_code='" + L_clinic_code + "' and a.facility_id='" + facility_id+"' order by 1";
		sql2="select distinct a.day_no,INITCAP(b.day_of_week) day_of_week from oa_clinic_time_table a, sm_day_of_week b where a.day_no = b.day_no and a.clinic_code=? and a.facility_id=? order by 1";
       //	stmt1 = conn.createStatement();
       // rs1 = stmt1.executeQuery(sql2);
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1,L_clinic_code);
		pstmt.setString(2,facility_id);
		rs1 = pstmt.executeQuery();
     
            _bw.write(_wl_block8Bytes, _wl_block8);
	 if (rs1.next() ) {

	   do {
	         day_of_week = rs1.getString("day_of_week");
	         day_text = day_of_week.toUpperCase();

			if(day_of_week.equals("Monday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_of_week.equals("Tuesday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_of_week.equals("Wednesday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_of_week.equals("Thursday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_of_week.equals("Friday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_of_week.equals("Saturday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_of_week.equals("Sunday"))
								{
									day_of_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


      
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( day_of_week ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( day_text ));
            _bw.write(_wl_block11Bytes, _wl_block11);


	   } while(rs1.next());
	}
	else {
      
            _bw.write(_wl_block12Bytes, _wl_block12);

      	  return;
      	}

	  if (rs != null) rs.close();
   	  if (rs1 != null) rs1.close();
   	  if (rs2 != null) rs2.close();
	  if (stmt != null) stmt.close();
   	  if (stmt1 != null) stmt1.close();
   	  if (stmt2 != null) stmt2.close();

    } catch (Exception e) { 
//out.println( e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
   	finally {
	  ConnectionManager.returnConnection(conn,request);
   	}
    
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
