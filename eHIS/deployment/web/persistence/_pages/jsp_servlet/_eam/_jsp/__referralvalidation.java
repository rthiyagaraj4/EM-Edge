package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __referralvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ReferralValidation.jsp", 1709114038429L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<html>\n<body class=\'message\' onKeyDown = \'lockKey()\'>  \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</body>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</html> \n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
Connection con = null;
ResultSet rs=null;
PreparedStatement stmt2=null;
PreparedStatement stmt=null;
ResultSet rs2=null;
 String locale			= (String)session.getAttribute("LOCALE");

 String pr_id = checkForNull(request.getParameter("process_id"));


  int process = Integer.parseInt(pr_id);

  
 //Below Added for checkstyle
  try{
	  con = ConnectionManager.getConnection(request);
// FOR POPULATING THE town list WHEN area list HAS BEEN SELECTED...........
    if(process == 7)
    {
		String postal_code = request.getParameter("postal_code");
		if(postal_code == null) postal_code = "";  	

		String res_area_code = request.getParameter("res_area_code");
		if(res_area_code==null) res_area_code ="";
		
		String region_code = request.getParameter("region_code");
		if(region_code==null) region_code =""; 

		String prev_region = request.getParameter("prev_region");
		if(prev_region==null) prev_region ="";       
		
		String res_town_code = request.getParameter("res_town_code");
		if (res_town_code==null) res_town_code ="";

		
		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
        String sql = "";
		
		if(mode.equals("first_postal_code"))
		{
			fieldName = "contact2_res_town_code";
			fieldName1 = "contact2_res_area_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
			fieldName5 = "f_town";
		}
		else if(mode.equals("next_postal_code"))
		{
			fieldName = "contact1_res_town_code";
			fieldName1 = "contact1_res_area_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
			fieldName5 = "n_town";
		}
		else if(mode.equals("employ_postal_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "contact3_res_area_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
			fieldName5 = "e_town";
		}
		else if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
			fieldName5 = "r_town";
		}
		else if(mode.equals("m_postal_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_area_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
			fieldName5 = "m_town";
		}
		else if(mode.equals("contact1_res_town_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
		}
		else if(mode.equals("contact2_res_town_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
		}
		else if(mode.equals("contact3_res_town_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
		}
		else if(mode.equals("m_town_code")){
			
			fieldName = "m_area_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
		}
		else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
		}
		else if(mode.equals("contact1_res_area_code")){
			fieldName = "contact1_res_town_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_town";
		}
		else if(mode.equals("contact2_res_area_code")){
			fieldName = "contact2_res_town_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_res_area_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_area_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_town";
		}
		else if(mode.equals("contact1_region_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "contact1_res_town_code";
			fieldName2 = "next_postal_code";
			fieldName3 = "n_area";
			fieldName4 = "n_town";
		}
		else if(mode.equals("contact2_region_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "contact2_res_town_code";
			fieldName2 = "first_postal_code";
			fieldName3 = "f_area";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_region_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "contact3_res_town_code";
			fieldName2 = "employ_postal_code";
			fieldName3 = "e_area";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_region_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_town_code";
			fieldName2 = "m_postal_code";
			fieldName3 = "m_area";
			fieldName4 = "m_town";
		}

 

        if (!postal_code.equals(""))
		{
            
			String town_code="";
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code_lang_vw a, mp_res_town_lang_vw b where a.language_id='"+locale+"' and a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code and a.language_id=b.language_id";
             stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			if (rs.next())
			{

				town_code = rs.getString(2);
                if (town_code==null) town_code="";
				out.println("<script>if (parent.frames[1].document.all."+fieldName+" !=null) parent.frames[1].document.all."+fieldName+".value=\""+town_code+"\";");
				out.println("parent.frames[1].document.all."+fieldName5+".value=\""+(rs.getString("res_town_code")==null ? "" : rs.getString("res_town_code"))+"\";</script>");

				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code and a.language_id=b.language_id" ;
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();

				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next())
				{
					out.println("<script>if (parent.frames[1].document.all."+fieldName1+" != null) parent.frames[1].document.all."+fieldName1+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
					out.println("if (parent.frames[1].document.all."+fieldName2+" !=null) parent.frames[1].document.all."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 	out.println("parent.frames[1].document.all."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 	out.println("parent.frames[1].document.all."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(!res_town_code.equals(""))
		{
			
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code and a.language_id=b.language_id";
			
		
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{

				 out.println("<script> if(parent.frames[1].document.all."+fieldName+" != null) parent.frames[1].document.all."+fieldName+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
				 
				 out.println("if (parent.frames[1].document.all."+fieldName2+" !=null) parent.frames[1].document.all."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 out.println("parent.frames[1].document.all."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 out.println("parent.frames[1].document.all."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";");
			}	
			out.println("if (parent.frames[1].document.all."+fieldName1+" !=null) {parent.frames[1].document.all."+fieldName1+".value=''} </script>");

			//sql="select postal_code from mp_postal_code where res_town_code = '"+res_town_code+"'";
			sql="select postal_code,short_desc from mp_postal_code_lang_vw where res_town_code = '"+res_town_code+"' and language_id='"+locale+"'";

		

			stmt2 = con.prepareStatement(sql);
			rs2 = stmt2.executeQuery();
			if(rs2.next())
			{
				out.println("<script>if (parent.frames[1].document.all."+fieldName1+" !=null) {parent.frames[1].document.all."+fieldName1+".value = \""+(rs2.getString("postal_code")==null ? "" : rs2.getString("postal_code"))+"\"}");

				out.println("if (parent.frames[1].document.all."+fieldName1+"1 !=null) {parent.frames[1].document.all."+fieldName1+"1.value = \""+(rs2.getString("short_desc")==null ? "" : rs2.getString("short_desc"))+"\"}</script>");
				
			}
			/*	if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("<script>if(parent.frames[1].document.all."+fieldName1+"1)parent.frames[1].document.all."+fieldName1+"1.focus();</script>");
			}
			else
			{
			out.println("<script>if(parent.frames[1].document.all."+fieldName1+")parent.frames[1].document.all."+fieldName1+".focus();</script>");
			}*/
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
			if(rs2!=null) rs2.close();
			if(stmt2 != null) stmt2.close();
		}
		if(!res_area_code.equals(""))
		{
			sql = "select region_code,long_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			
	
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				out.println("<script>if (parent.frames[1].document.all."+fieldName1+" !=null) parent.frames[1].document.all."+fieldName1+".value='';");
				out.println("if (parent.frames[1].document.all."+fieldName2+" !=null) parent.frames[1].document.all."+fieldName2+".value=\""+(rs.getString("long_desc")==null ? "" : rs.getString("long_desc"))+"\";");
				out.println(" parent.frames[1].document.all."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
			}
			else
			{
				out.println("<script> if(parent.frames[1].document.all."+fieldName+") parent.frames[1].document.all."+fieldName+".value='';");
				out.println("if (parent.frames[1].document.all."+fieldName1+") parent.frames[1].document.all."+fieldName1+".value='';");
				out.println("if (parent.frames[1].document.all."+fieldName2+" ) parent.frames[1].document.all."+fieldName2+".value='';");
				out.println("parent.frames[1].document.all."+fieldName3+".value='';");
				out.println("parent.frames[1].document.all."+fieldName4+".value='';</script>");
			}
		/*	out.println("<script>if(parent.frames[1].document.all."+fieldName1+")</script>");
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("<script>if (parent.frames[1].document.all."+fieldName2+"1){parent.frames[1].document.all."+fieldName1+"1.focus();}</script>");
			}
			else
			{
			out.println("<script>parent.frames[1].document.all."+fieldName1+".focus();</script>");
			}*/

			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
		}

			
      	if(!region_code.equals("") && !prev_region.equals("") && !region_code.equals(prev_region))
		{			         
			 out.println("<script>if(parent.frames[1].document.all."+fieldName+" )");			
			 out.println("parent.frames[1].document.all."+fieldName+".value='';");
			 out.println("if(parent.frames[1].document.all."+fieldName2+") parent.frames[1].document.all."+fieldName2+".value='';");
			 out.println("if (parent.frames[1].document.all."+fieldName1+") parent.frames[1].document.all."+fieldName1+".value='';");
			 out.println("parent.frames[1].document.all."+fieldName3+".value='';");
			 out.println("parent.frames[1].document.all."+fieldName4+".value='';</script>");

				
			/*
			if(fieldName2.equals("next_postal_code") || fieldName2.equals("first_postal_code") || fieldName2.equals("employ_postal_code") || fieldName2.equals("m_postal_code") || fieldName2.equals("r_postal_code"))
			{
			out.println("<script>if (parent.frames[1].document.all."+fieldName2+"1) {parent.frames[1].document.all."+fieldName2+"1.focus();}  </script>");
			}
			else
			{
				out.println("<script>parent.frames[1].document.all."+fieldName2+".focus();</script>");
			}
			*/
		}
    }
	//Below Added for checkstyle
  }
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con, request); 
	}
	//Ended for checkstyle

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
