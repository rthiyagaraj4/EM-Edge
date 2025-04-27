package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __nursingunitpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursingUnitPopulate.jsp", 1709117807993L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<body class=message onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t\tvar opt=parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].nursing_unit.add(opt);\n\t\t\t\t\t\talert(parent.frames[1].document.forms[0].name);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String facilityId	= (String) session.getValue("facility_id");
	String dateVal = request.getParameter("dateVal");
		if(dateVal == null) dateVal= "";
	String booking = request.getParameter("booking");
		if(booking == null) booking ="";
	String expdate = request.getParameter("expdate");
		if(expdate == null) expdate ="";		 
	String med_code		= request.getParameter("med_code");
	String spy_code		= request.getParameter("spy_code");
	String prt_code		= request.getParameter("prt_code");
	String p_code		= "";
	String p_desc		= "";

	if (med_code==null) med_code="";
	if (spy_code==null) spy_code="";
	if (prt_code==null) prt_code="";
	
	Connection con= null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	PreparedStatement pstmt1 =null;
	ResultSet rs1 = null;
	Statement stmt = null;
	String str1="", str2="";

	try
	{	
		con = ConnectionManager.getConnection(request);	
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	
		/* This condition added by Nanda - 01/10/2002 */

		if(booking.equals("AssignBed"))
	    {
			int i=0; 
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				i++;
				if(i==1)
				{
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"element.selected='true';"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
				else
				{
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
			}		
		}
		if(booking.equals("booking"))
	    {
			int i=0; 
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				i++;
				if(i==1)
				{
				out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"element.selected='true';"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
				else
				{
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
			}		

			String str ="SELECT a.nursing_unit_code,a.Short_desc FROM IP_NURSING_UNIT a, IP_MED_SER_GRP_NURS_UT_TYPE b, IP_NURS_UNIT_FOR_SPECIALTY c,IP_NURSING_UNIT_FOR_PRACT D WHERE a.FACILITY_ID='"+facilityId+"' AND A.EFF_STATUS='E' AND B.MED_SER_GRP_CODE='"+med_code+"' AND A.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID=C.FACILITY_ID AND A.FACILITY_ID=D.FACILITY_ID AND A.NURSING_UNIT_CODE=C.NURSING_UNIT_CODE AND A.NURSING_UNIT_CODE=D.NURSING_UNIT_CODE AND A.NURSING_UNIT_TYPE_CODE=B.NURSING_UNIT_TYPE_CODE AND C.SPECIALTY_CODE='"+spy_code+"' AND D.PRACTITIONER_ID='"+prt_code+"' ";

			stmt = con.createStatement();
			rs = stmt.executeQuery(str);

			if(rs != null)
			{
				while (rs.next())
				{
					p_code				= rs.getString("nursing_unit_code");
					p_desc				= rs.getString("Short_desc");
					
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			}
		}
	    else if(booking.equals("admit"))
	    {
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.frames[2].document.createElement('OPTION');"+
				"element.text = '"+str2+"';"+ 
				"element.value= '"+str1+"';"+
				"parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.add(element);</script>");
			}
	     }
		 if(booking.equals("transfer"))
		 {
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
				"element.text = '"+str2+"';"+ 
				"element.value= '"+str1+"';"+
				"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
			}		     
		}
		pstmt.close() ;      		
		out.println("</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'></body></html>");
	    if(expdate.equals("expdate"))
		{				
			if(!dateVal.equals(""))
			{	
				pstmt1 	= con.prepareStatement( "select to_char(sysdate+'"+dateVal+"','dd/mm/rrrr hh24:mi') disdate from dual");
				rs1 = pstmt1.executeQuery();
				if(rs1.next())
				{
					String Expdate = rs1.getString("disdate");
					out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = '"+Expdate+"';parent.f_query_add_mod.document.frames[2].document.forms[0].circumstance_of_injury.focus();</script>");				
				}
			}
			else
			{
				out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = ''</script>");				
			}
		}
	}	
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
	 	ConnectionManager.returnConnection(con,request);	

		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
