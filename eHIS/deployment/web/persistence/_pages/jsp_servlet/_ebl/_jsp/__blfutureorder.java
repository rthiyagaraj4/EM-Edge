package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Calendar;

public final class __blfutureorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFutureOrder.jsp", 1709114103037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\t\n\t\t\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

				try{
					request.setCharacterEncoding("UTF-8");
					 String patient_id = request.getParameter("patient_id");
					 String episode_type = request.getParameter("episode_type");

					 String episode_id = request.getParameter("episode_id");
					 String visit_id =request.getParameter("visit_id");
					 String facility_id = request.getParameter("facility_id");
					String retVal = "";
					System.out.println(patient_id);
					System.out.println(episode_type);
					System.out.println(episode_id);
					System.out.println("visit_id"+visit_id);
					System.out.println("facility_id"+facility_id);
					if(visit_id==null) visit_id= " ";
					if(episode_id ==null )episode_id =" ";

					
					System.out.println("visit_id111111111"+visit_id);
						Connection con = null;
						con	=	ConnectionManager.getConnection(request);	
						ResultSet rs=null;
						int count=0;
						
						String count_id_sql		="select count(*) from   bl_patient_charges_interface where patient_id='"+patient_id+"'"+
		    									   "and operating_facility_id='"+facility_id+"'"+
													"and (('"+episode_type+"'not in ('R','A','Q')) and episode_id=nvl("+episode_id+",episode_id) or('"+episode_type+"' in('R','A','Q')))"+											       		     
											       " and    (('"+episode_type+"' not in ('A','Q') and episode_type='"+episode_type+"') or  '"+episode_type+"' in ('A','Q')) "+
											       " and    (('"+episode_type+"' in ('O','E') and visit_id=nvl('"+visit_id+"',visit_id)) or '"+episode_type+"' not in ('O','E') )"+
											       " and    FUTURE_ORDER_YN ='Y' and    nvl(FUTURE_ORDER_CHARGE_LATER_YN,'N')='Y' and    trx_doc_ref is null" ; 
						
						
			
						Statement stmt = con.createStatement();
						 rs = stmt.executeQuery(count_id_sql);	

				if(rs.next())
				{
					
				   count  =  rs.getInt(1);
				   
				}
				
				if (count!= 0) {
					
					retVal = "Y";
				}else{
					retVal="N";
				}
				out.println(retVal);
				
			if(rs!=null)   rs.close();
			if(stmt!=null) stmt.close();
		con.close();
		}
		catch(Exception eX)
		{	
			//out.println("Error= "+eX);			
		}
	
					
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
