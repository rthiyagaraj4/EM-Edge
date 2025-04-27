package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __aecallresultpatienthistory extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AECallResultPatientHistory.jsp", 1709706051421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!-- Added/Modified By Nanda 10/21/2002 -->\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<iframe name=\'mainFrame\' id=\'mainFrame\' src=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' frameborder=0 scrolling=\'no\' noresize  style=\'height:9vh;width:100vw\'></iframe><iframe name=\'AEPatientHistoryResultFrame\' id=\'AEPatientHistoryResultFrame\' src=\"../../eAE/jsp/AEResultPatientHistory.jsp?sql_query=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&patient_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" frameborder=0 scrolling=\'auto\' noresize style=\'height:91vh;width:100vw\'></iframe>\n \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\tparent.frames[1].document.AEQueryPatientHistoryForm.search.disabled=false;\n\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String patient_id			= request.getParameter("patient_id");
	
	String mrn					= request.getParameter("mrn");

	String encounter_id			= request.getParameter("encounter_id");

	String	facilityId 			= (String) session.getValue( "facility_id" ) ;

	
	String url1 = "../../eCommon/jsp/pline.jsp?" ;
	String sql_query	=request.getParameter("sql_query");	
	
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

    String valid_pat_id ="";
    String sql1="";
    
    String params1="";
    String source1="";
   
	int p_rec_cnt=0;

    boolean valid=true;
    String e_msg ="";
	String e_msg1 ="";
try
{
        con  =  ConnectionManager.getConnection(request); 
        if(!mrn.equals("")) 
        {
	   
	   sql1 =  "select patient_id from mr_pat_file_index where file_no='"+mrn.trim()+"' and facility_id=?";
       stmt = con.prepareStatement(sql1);
	   stmt.setString(1,facilityId);
	   rs = stmt.executeQuery();
	    if(rs != null) 
			{
                if(rs.next() && rs!=null)
                    patient_id=rs.getString("patient_id");
                else
                {
                	valid=false;
                	e_msg="AE_INVALID_MRN";
                 
				}

			}
        }
		if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

		 if (!encounter_id.equals("")) 
        {
            
            sql1 =  "select patient_id from op_patient_queue where facility_id=? and encounter_id=? and patient_class = 'EM'";
			stmt = con.prepareStatement(sql1);
			stmt.setString(1,facilityId);
			stmt.setString(2,encounter_id);
            rs = stmt.executeQuery();

            if(rs != null) 
                if(rs.next())
			{
                    patient_id=rs.getString("patient_id");
					
			}
                else
                {

                	valid=false;
					e_msg="AE_INVALID_ENCOUNTER_ID";
                }
                   
         }
	    if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

		 if( !patient_id.equals("") ) 
    {
         
          sql1 =  "select patient_id from mp_patient where patient_id=?";
		 stmt = con.prepareStatement(sql1);
		 stmt.setString(1,patient_id);
         rs = stmt.executeQuery();

         if(rs != null) 
         	if(rs.next())
		{
                    valid_pat_id=rs.getString("patient_id");
		
		}
        if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

         if(valid_pat_id==null || valid_pat_id.equals(""))
         {

		valid=false;
		e_msg1="INVALID_PATIENT";
    	 }
    }
	    if(valid)
    {
		params1="Patient_ID="+patient_id;
	    source1 = url1 + params1;
    
		sql1 = "select count(*) as total from op_patient_queue where facility_id=?"+sql_query+" and patient_class = 'EM'" ;
        stmt = con.prepareStatement(sql1);
	
		stmt.setString(1,facilityId);
		
		rs = stmt.executeQuery();
 

		if (rs.next())
		{
			p_rec_cnt = rs.getInt("total");
		}
	    if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

		if (p_rec_cnt==0)
		{
			valid=false;
		}
		else
		{
			valid=true;
		}

    }
    else
    {
	    if(e_msg!="")
		{
		out.print("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'; alert(getMessage('"+e_msg+"','AE'));	 parent.frames[1].document.forms[0].mrn.value = ''; parent.frames[1].document.forms[0].search.disabled = false;</script>");         
	    source1 = "../../eCommon/html/blank.html";
		}
		else
		{
		out.print("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'; alert(getMessage('"+e_msg1+"','MP'));	 parent.frames[1].document.forms[0].search.disabled = false;</script>");         
	    source1 = "../../eCommon/html/blank.html";
		
		}
    }
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
      
      if(con!=null) 
	  ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block4Bytes, _wl_block4);

	if (valid)
	{

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source1));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sql_query));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else
	{

            _bw.write(_wl_block9Bytes, _wl_block9);

	}

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
