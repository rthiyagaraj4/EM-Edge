package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __ippopspecpract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPPopSpecPract.jsp", 1742445317247L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\t\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	String locale			= (String)session.getAttribute("LOCALE");
	String code = request.getParameter("code");
	if(code == null) code= "";
	String funct = request.getParameter("funct");
	if(funct == null) funct= "";
	String nur_code = request.getParameter("nur_code");
	if(nur_code == null) nur_code= "";

	String spec_code = request.getParameter("spec_code");
	if(spec_code == null) spec_code= "";

	String spec_code_fr=request.getParameter("spl_fr");
	if(spec_code_fr == null) spec_code_fr= "";

	String team_code_fr=request.getParameter("team_fr");
	if(team_code_fr == null) team_code_fr= "";

	String funct_name = request.getParameter("funct_name");
	if(funct_name == null) funct_name= "";
	String frame_struct="";

	if(funct_name.equals("ipadmit"))
	{
		frame_struct="parent.frames[1].frames[2].document";	
	}
	else
	{		
		frame_struct="parent.frames[1].document";
	}


	int tot=0;

	String facilityId	= (String) session.getValue("facility_id");
	String str1 = "";
	String str2 = "";
	

	Connection con= null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	try
	{	
		if(!(code.equals("")))
		{
			con = ConnectionManager.getConnection(request);	
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			

			if(funct.equals("spec"))
			{
				String selectsql = " select specialty_code, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc from IP_NURS_UNIT_FOR_SPECIALTY where facility_id='"+facilityId+"' AND nursing_unit_code='"+code+"' order by 2 ";
				
				pstmt 	= con.prepareStatement(selectsql) ;
				rs			= pstmt.executeQuery() ;

				out.println("<script>");
				if( rs != null ) 
				{
					
					while( rs.next() ) 
					{
						str1 = rs.getString("SPECIALTY_CODE") ;
						str2 = rs.getString("SPECIALTY_SHORT_DESC");
					
						if(str1.equals(spec_code_fr))
						{
							out.println(frame_struct+".forms[0].Splcode.value = \""+str1+"\";");
							out.println("if("+frame_struct+".forms[0].SplDesc)"); 
							out.println(frame_struct+".forms[0].SplDesc.value = \""+str2+"\";");
						}

					}		
				if(rs!=null)	 rs.close();
				if(pstmt!=null)	 pstmt.close();
				}	
			}
			else if(funct.equals("pract"))
			{
				
				String selectsql = " select count(*) as tot from IP_NURSING_UNIT_FOR_PRACT a, AM_PRACT_SPECIALITIES b where a.practitioner_id='"+code+"' and a.nursing_unit_code='"+nur_code+"' and  a.facility_id ='"+facilityId+"' and a.practitioner_id = b.practitioner_id and a.facility_id = b.facility_id and b.speciality_code='"+spec_code+"'";
				pstmt 	= con.prepareStatement(selectsql) ;
				rs = pstmt.executeQuery() ;

				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						tot = rs.getInt("tot");
					}
					if(tot == 0)
					{
						out.println("<script>alert(getMessage('INVALID_SPLTY_PRACT','IP'));</script>");
						out.println("<script>"+frame_struct+".forms[0].practid.focus();</script>");
						out.println("<script>"+frame_struct+".forms[0].practid.select();</script>");
					}
				if(rs!=null)	 rs.close();
				if(pstmt!=null)	 pstmt.close();
				}
							
			}
			      		
			out.println("</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'></body></html>");
		}
	}
	catch(Exception e)
	{
		out.println("<script>alert('"+e+"');</script>");
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
	
            _bw.write(_wl_block1Bytes, _wl_block1);
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
