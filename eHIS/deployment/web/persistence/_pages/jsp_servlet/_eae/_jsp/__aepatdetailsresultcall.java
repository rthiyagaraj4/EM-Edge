package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __aepatdetailsresultcall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEPatDetailsResultCall.jsp", 1709709657339L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n    <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>var src = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"; parent.frames[2].location.href=src</script>\n<!-- <iframe name=\'AEPatDetailsResultFrame\' id=\'AEPatDetailsResultFrame\' src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" frameborder=0 scrolling=\'auto\' noresize style=\'height:100vh;width:100vw\'></iframe>\n  -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t            parent.f_patientByCriteria.document.AEPatientByCriteriaForm.search.disabled = false;\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String patient_id			= request.getParameter("patient_id");
		String facilityId 			= (String) session.getValue( "facility_id" ) ;
		String sql_query			= request.getParameter("sql_query");
		String contact_no			= request.getParameter("contact_no"); 
		int p_rec_cnt				= 0;
		boolean valid=true;

		if( ! (patient_id.equals("") || patient_id ==null) )
		{
			Connection con = null;
			java.sql.Statement stmt=null;
			ResultSet rs=null;

			String valid_pat_id ="";
			StringBuffer sql1 = new StringBuffer();
	    	
		    String e_msg ="";
			try
			{
			 con  =  ConnectionManager.getConnection(request);
		     stmt = con.createStatement();
			 sql1.append("select patient_id from mp_patient where patient_id='"+patient_id+"'");
	         rs = stmt.executeQuery(sql1.toString());

		     if(rs != null) 
			 if(rs.next())
                    valid_pat_id=rs.getString("patient_id");

			 if (rs != null) rs.close();
		     if (stmt != null) stmt.close();
			 sql1.delete(0,sql1.length());
         
		         if(valid_pat_id==null || valid_pat_id.equals(""))
				 {
				valid=false;
				e_msg="INVALID_PATIENT";
				 }
              


				if(!valid)
				{
			    
				out.print("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'; alert(getMessage('"+e_msg+"','MP'));parent.frames[1].document.forms[0].search.disabled=false</script>");         
			    
				}
				else
				{
					stmt = con.createStatement();
					sql1.append("select count(*) as total from op_patient_queue a,mp_patient b,ae_pat_related_contacts c where a.facility_id='"+facilityId+"'"+sql_query+" ");
					if (!contact_no.equals(""))
						sql1.append(" and c.res1_tel_no= nvl('"+contact_no+"',res1_tel_no) ");
					rs = stmt.executeQuery(sql1.toString());

					while (rs.next())
					{
						p_rec_cnt = rs.getInt("total");
					}
		            if (stmt != null) stmt.close();
					if (p_rec_cnt == 0 )
					{
						valid=false;
					}
					else
					{
						valid=true;
					}
				}
                 sql1.delete(0,sql1.length());
				 if(rs != null)	rs.close();
		         if(stmt != null) stmt.close();
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally
			{ 
		      if(con!=null) ConnectionManager.returnConnection(con,request);
			}

		}

		String url = "../../eAE/jsp/AEPatByCriteriaResult.jsp?contact_no="+java.net.URLEncoder.encode(contact_no)+"&sql_query="+sql_query;

		if (valid)
		{

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(url));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(url));
            _bw.write(_wl_block6Bytes, _wl_block6);

		}
		else
		{
		
            _bw.write(_wl_block7Bytes, _wl_block7);

		}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
