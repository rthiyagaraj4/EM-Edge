package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import com.ehis.util.*;

public final class __servervalidation1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ServerValidation1.jsp", 1718005751304L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n <head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n      \t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eAM/js/Practitioner.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t\n\t\t\n\t\n\n\n     ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar maxAge = parent.f_query_add_mod.OtherStaff_sub.document.OtherStaff1_form.max_pa_age.value;\n\t\tvar actAge =parent.f_query_add_mod.OtherStaff_sub.document.getElementById(\'b_age\').value;\n\t\tvar actMonth =parent.f_query_add_mod.OtherStaff_sub.document.getElementById(\'b_months\').value;\n\t\tvar actDay =parent.f_query_add_mod.OtherStaff_sub.document.getElementById(\'b_days\').value; \n\t\tif (maxAge != \'\')\n\t\t{\n\t\t\tif (parseInt(actAge) > parseInt(maxAge))\n\t\t\t{\n\t\t\t\tvar msg= getMessage(\"MAX_PATIENT_AGE\",\'MP\')+\" \"+maxAge+\" \"+ getLabel(\"Common.Years.label\",\"common\");\n\t\t\t\talert(msg);\n\t\t\t\tparent.f_query_add_mod.OtherStaff_sub.document.getElementById(\'b_age\').focus();\n\t\t\t}\n\t\t}\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\n</script>\n\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		 request.setCharacterEncoding("UTF-8");	
      		Connection conn = null; 
			Statement stmt =  null; 
			PreparedStatement pstmtf=null;
	        ResultSet rs =  null; 
	        ResultSet rsf =  null; 
      		//String reference="parent.frames[1].document.frames[1].document.forms[1]";
      		String reference=request.getParameter("reference");
			String locale = (String)session.getAttribute("LOCALE");
 		if(reference == null) reference="";
      		try
		{
		conn = ConnectionManager.getConnection(request);	
      	String date_of_birth="";
		String process_id =request.getParameter("process_id");
		String max_patient_age ="";
		if(process_id == null) process_id="0";
		int process=Integer.parseInt(process_id);

		stmt = conn.createStatement();        
        String  DAYS,MONTHS,AGE;
		try{

			String sql_maxage="select max_patient_age from  mp_param_lang_vw mp_param  WHERE  module_id = 'MP' AND language_id = '"+locale+"'";
			pstmtf=conn.prepareStatement(sql_maxage);
			rsf=pstmtf.executeQuery();
			if(rsf.next())
			{
		  		max_patient_age=rsf.getString("max_patient_age");
			}
			if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();

		    }catch(Exception e) {
		     out.println("errors="+e);
		     }

if(process == 1)
{
        String DOB=request.getParameter("date_of_birth");
		if(DOB == null) DOB = date_of_birth;

        String sql = "select calculate_age('"+DOB+"',1) from dual";
        rs = stmt.executeQuery(sql);
       rs.next();
       int AGE1 = rs.getInt(1);
	   if(rs!=null)rs.close();
	   if(stmt!=null) 	stmt.close();
       sql = "select calculate_age('"+DOB+"',2) from dual";
		stmt = conn.createStatement();  
        rs = stmt.executeQuery(sql);
        rs.next();
     int  MONTHS1 = rs.getInt(1);

        if(rs!=null)rs.close();
		sql = "select calculate_age('"+DOB+"',3) from dual";
        rs = stmt.executeQuery(sql);
        rs.next();
      int  DAYS1= rs.getInt(1);
	  
        String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>"+reference+".b_age.value='"+AGE1+"';"+reference+".b_months.value='"+MONTHS1 +"';"+reference+".b_days.value='"+DAYS1+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>"; 
		out.println(htmlVal);


		
            _bw.write(_wl_block4Bytes, _wl_block4);

	   if(rs!=null)rs.close();
		if(stmt!=null) 	stmt.close();
}
else
if(process == 2)
{
      
        DAYS = request.getParameter("b_days");
        MONTHS = request.getParameter("b_months");
        AGE = request.getParameter("b_age");

        if ( DAYS.equals("") )
            DAYS = "null";
        if ( MONTHS.equals("") )
            MONTHS = "null";
        if ( AGE.equals("") )
            AGE = "null";

        String htmlVal="";
        String DOB="";
		String date_of_birth_display="";
        String sql = "select calculate_date_of_birth ("+AGE+","+MONTHS+","+DAYS+") from dual";
		stmt = conn.createStatement();  
        rs = stmt.executeQuery(sql);
		if(rs !=null && rs.next())
	{
        DOB = rs.getString(1);
		date_of_birth_display=DateUtils.convertDate(DOB,"DMY","en",locale);
	}

        if ( DOB == "" || DOB == null )
            DOB = "";
      if ( AGE.equals("null") && MONTHS.equals("null")  && DAYS.equals("null"))
	   {
		htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>eval("+reference+").date_of_birth.value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value=''</body></html>";  
		} else
		{
		htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>eval("+reference+").date_of_birth.value='"+date_of_birth_display+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value='"+DOB+"'</body></html>";  
		}

	    out.println(htmlVal);
        date_of_birth = DOB ;
        
      
  }	       	
  	       	
  	       	}catch(Exception e){}
  	       	
		finally{
			if (rs != null)   rs.close();
			if (stmt != null) stmt.close();
			ConnectionManager.returnConnection(conn,request);
		}
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
