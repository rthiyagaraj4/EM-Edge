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
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __qpvpline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/QPVpline.jsp", 1723183871109L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n    <!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<iframe name=\'pline\' id=\'pline\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:50vh;width:100vw\'></iframe>\n    <iframe name=\'tabs\' id=\'tabs\'  src=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" frameborder=0 scrolling=\'no\' noresize style=\'height:50vh;width:100vw\'></iframe>\n\n\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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

	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

    String url1 = "../../eCommon/jsp/pline.jsp?" ;
    String url2 = "../../eOP/jsp/QPVimgtabs.jsp?" ;
    String blnk = request.getParameter("blnk") ;
    String facid = (String) session.getValue("facility_id");
    String patid=request.getParameter("patid");
    String mrnno=request.getParameter("mrnno");
    String enctid=request.getParameter("enctid");
    String dtfrm=request.getParameter("dtfrm");
    String dtto=request.getParameter("dtto");
    String serv=request.getParameter("serv");
    String loc=request.getParameter("loc");
    String pract=request.getParameter("pract");
	String episode_id=request.getParameter("episode_id");
    String valid_pat_id ="";
	PreparedStatement pstmt=null;
    ResultSet rset1=null;
    String sql1="";
    
    String openEpisode = request.getParameter("openEpisode");
    if(openEpisode == null) openEpisode="";
    
    String params1=""; 
    String source1="";
    String params2="";  
    String source2="";
    boolean valid=true;
    String e_msg ="";
    Connection conn1  = null;
	
try
{
	conn1  =  ConnectionManager.getConnection(request);

    if( patid.equals("") ) 
    {
        if(!mrnno.equals("")) 
        {
	   
	   sql1 =  "select patient_id from mr_pat_file_index where file_no=? and facility_id=? ";
	   
	   pstmt=conn1.prepareStatement(sql1);
		pstmt.setString(1,mrnno);
		pstmt.setString(2,facid);
		rset1=pstmt.executeQuery();

		   if(rset1 != null)
			{
                if(rset1.next())
				{
                    patid=rset1.getString("patient_id");
                }
				else
                {
                	valid=false;
                	e_msg="M";
                }
			 }

				if(pstmt != null) pstmt.close();
				if(rset1 != null) rset1.close();
		}
        else if (!enctid.equals("")) 
        {
            sql1 =  "select patient_id from pr_encounter where facility_id=? and encounter_id=? ";

			pstmt=conn1.prepareStatement(sql1);
			pstmt.setString(1,facid);
			pstmt.setString(2,enctid);
            rset1 = pstmt.executeQuery();

            if(rset1 != null) 
			{
                if(rset1.next())
				{
                    patid=rset1.getString("patient_id");
				}
                else
                {
                	valid=false;
                	e_msg="E";
                }
			}

				if(pstmt != null) pstmt.close();
				if(rset1 != null) rset1.close();
		 }
    }
    else
    {
         sql1 =  "select patient_id from mp_patient where patient_id=? ";

		 pstmt=conn1.prepareStatement(sql1);
		 pstmt.setString(1,patid);
         rset1 = pstmt.executeQuery();

		 if(rset1 != null) 
		{
         	if(rset1.next())
			{
              valid_pat_id=rset1.getString("patient_id");
			}
            if(valid_pat_id==null || valid_pat_id.equals(""))
			{
				valid=false;
				e_msg="P";
			}
		}
		 if(rset1 != null) rset1.close();
    }
    if(valid)
    {
		 params1="Patient_ID="+patid;
	     source1 = url1 + params1;
		 params2="blnk="+blnk+"&patid="+patid+"&mrnno="+mrnno+"&enctid="+enctid+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+loc+"&pract="+pract+"&openEpisode="+openEpisode+"&episode_id="+episode_id;  
	     source2 = url2 + params2;
    }
    else
    {
	    out.print("<script>parent.frames[1].location.href='../../eCommon/html/blank.html'; ");
		if (e_msg.equals("P"))
		out.println("alert(getMessage('INVALID_PATIENT','MP'));");
		else if (e_msg.equals("M"))
		out.println("alert(getMessage('INVALID_MRN','OP'));");		
		out.print("</script>");         
	    source1 = "../../eCommon/html/blank.html";
	    source2 = "../../eCommon/html/blank.html";  
    }
  if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	out.println("Exception:"+e);
}
finally
{
	 try{
      if(rset1 != null)	rset1.close();
      if(pstmt != null) pstmt.close();
	 }catch(Exception e){}
      if(conn1!=null) ConnectionManager.returnConnection(conn1,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source1));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source2));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
