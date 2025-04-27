package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;

public final class __getservice extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/GetService.jsp", 1709117763459L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar select\t=\tparent.f_query_add_mod.document.forms[0].dflt_file_type;\n\t\t\t\t\t\tvar length\t=\tMath.abs(select.length); \n\t\t\t\t\t\tfor (i=0;i<length;i++)\n\t\t\t\t\t\tselect.remove(0);\n\n\t\t\t\t\t\tvar option\t=\tparent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\toption.text\t=\t\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\t\t\toption.value=\t\"\";\t\n\t\t\t\t\t\tselect.add(option);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar option\t=\tparent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\toption.text\t=\t\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t\t\toption.value=\t\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t\t\tselect.add(option);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar select\t=\tparent.f_query_add_mod.document.forms[0].mr_location_code;\n\t\t\t\t\tvar length\t=\tMath.abs(select.length); \n\t\t\t\t\tfor (i=0;i<length;i++)\n\t\t\t\t\t\tselect.remove(0);\n\t\t\t\t\tvar option\t=\tparent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\toption.text\t=\t\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\t\toption.value=\t\"\";\t\n\t\t\t\t\tselect.add(option);\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t<script>\n\t\t\t\t\t\tvar option\t=\tparent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\toption.text\t=\t\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\toption.value=\t\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tselect.add(option);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar select\t=\tparent.f_query_add_mod.document.forms[0].mr_location_code;\n\t\t\t\t\t\tvar length\t=\tMath.abs(select.length); \n\t\t\t\t\t\tfor (i=0;i<length;i++)\n\t\t\t\t\t\t\tselect.remove(0);\n\t\t\t\t\t\tvar option\t=\tparent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\toption.text\t=\t\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\t\t\toption.value=\t\"\";\t\n\t\t\t\t\t\tselect.add(option);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar select\t=\tparent.f_query_add_mod.document.forms[0].mr_location_code;\n\t\t\t\t\tvar length\t=\tMath.abs(select.length); \n\t\t\t\t\tfor (i=0;i<length;i++)\n\t\t\t\t\t\tselect.remove(0);\n\t\t\t\t\tvar option\t=\tparent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\toption.text\t=\t\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\t\toption.value=\t\"\";\t\n\t\t\t\t\tselect.add(option);\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar n = parent.f_query_add_mod.document.NursingUnit_form.mr_section.length;\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\tparent.f_query_add_mod.document.NursingUnit_form.mr_section.remove(\"SHORT_NAME\");\t\n\t\t\t\t\tvar temp = \"\";\n\t\t\t\t\tvar temp1=\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\tparent.f_query_add_mod.document.NursingUnit_form.mr_section.add(opt);\t\n\t\t\t\t\tparent.f_query_add_mod.document.NursingUnit_form.mr_section.options[0].selected = true;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar element = parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\t\telement.selected=false;\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.NursingUnit_form.mr_section.add(element);\n\t\t\t\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar element = parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\t\tif (\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" == \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\")\n\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\tparent.f_query_add_mod.document.NursingUnit_form.service_code.add(element);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t<script>\n\t\t\t\t\t\tvar element = parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\n\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\tparent.f_query_add_mod.document.NursingUnit_form.section.add(element);\n\t\t\t\t\t\t\n\t\t\t\t\t</script> \n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t <script>\n\n\t\t\t\t\t\tvar element = parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\telement.selected=false;\n\n\t\t\t\t\t\tparent.f_query_add_mod.document.NursingUnit_form.mr_section.add(element);\n\n\t\t\t\t\t\t</script> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].mr_location_code.value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].mr_location_code != null)\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].mr_location_code.add(opt);\n\t\t\t\t\t\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t<script>\n\t\t\t\t\t\tvar opt= parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].dflt_file_type.add(opt);\n\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con 			= null;
	PreparedStatement pstmt	= null;
	PreparedStatement pstmt3= null;
	PreparedStatement pstmt4= null;
	ResultSet rs			= null;
	ResultSet rs2			= null; 
	ResultSet dfrset		= null; 
	Statement dfstmt		= null; 
	ResultSet rs4			= null; 
	Statement stmt			= null;
	ResultSet rset			= null; 
	ResultSet rs3			= null;
	
	String facilityId		= (String) session.getValue("facility_id");
	String centralValue		= checkForNull(request.getParameter("centralValue"));
	String fmInstallyn		= checkForNull(request.getParameter("fminstall"));
	String sectionType		= checkForNull(request.getParameter("sectionType"));
	String levelfcare		= checkForNull(request.getParameter("levelfcare"));
	String defaultlocn		= checkForNull(request.getParameter("defaultlocn"));
	String criteria			= checkForNull(request.getParameter("criteria"));
	String deptcode			= checkForNull(request.getParameter("dept_code"));
	String servicecode		= checkForNull(request.getParameter("service_code"));
	String MRSectionCode	= checkForNull(request.getParameter("mr_section_type"));
	String applicable_to	= checkForNull(request.getParameter("applicable_to"));
	String sectioncode		= checkForNull(request.getParameter("section_code"));
	String fm_setup_ip		= request.getParameter("fm_setup_ip");
		if(fm_setup_ip == null) fm_setup_ip	=	"N";
/* Added  for subservice & Section by Sridhar on 31/01/04 */

	String ID3				= "";
	String dat3				= "";
	String ID				= "";
	String dat				= "";
	String sql_1			= "";
	String default_code		= "";
	String default_desc		= "";
	String ID4				= "";
	String dat4				= "";

	try
	{
		con = ConnectionManager.getConnection(request);
		
	try
	{
		if(criteria.equals("populateFSFileType"))
		{

			String sqlString		=	"";
			String file_type_code	=	"";
			String file_type_desc	=	"";
			String mr_location_code		=	checkForNull(request.getParameter("mr_location_code"));

			if ((fm_setup_ip.equals("Y")) && (!mr_location_code.equals("")) && (applicable_to.equals("IP")))
			{
				sqlString	=	" SELECT distinct a.file_type_code file_type_code, c.short_desc file_type_desc FROM fm_file_type_for_fsl a, mr_file_type c WHERE c.facility_id = ? AND a.facility_id = c.facility_id AND a.fs_locn_code = ? AND a.file_type_code = c.file_type_code AND appl_to_ip = 'Y' ORDER BY file_type_desc ";
			}
			else if ((fm_setup_ip.equals("Y")) && (!mr_location_code.equals("")) && (applicable_to.equals("DC")))
			{
				sqlString	=	" SELECT distinct a.file_type_code file_type_code, c.short_desc file_type_desc FROM fm_file_type_for_fsl a, mr_file_type c WHERE c.facility_id = ? AND a.facility_id = c.facility_id AND a.fs_locn_code = ? AND a.file_type_code = c.file_type_code AND appl_to_dc = 'Y' ORDER BY file_type_desc ";
			}
			else if ((fm_setup_ip.equals("N")) && (applicable_to.equals("DC")))
			{
				sqlString	=	" SELECT  distinct file_type_code, short_desc file_type_desc FROM mr_file_type WHERE facility_id = ? AND appl_to_dc = 'Y' AND eff_status = 'E' ORDER BY short_desc ";
			}
			else if ((fm_setup_ip.equals("N")) && (applicable_to.equals("IP")))
			{
				sqlString	=	" SELECT  distinct file_type_code, short_desc file_type_desc FROM mr_file_type WHERE facility_id = ? AND appl_to_ip = 'Y' AND eff_status = 'E' ORDER BY short_desc ";
			}
			if (!sqlString.equals(""))
			{
				if(rs != null)		rs.close();
				if(pstmt != null)		pstmt.close();

				pstmt	=	con.prepareStatement(sqlString);
				pstmt.setString(1, facilityId);
				if (fm_setup_ip.equals("Y"))
				pstmt.setString(2, mr_location_code);
				rs	=	pstmt.executeQuery();
				if (rs != null)
				{
					
            _bw.write(_wl_block3Bytes, _wl_block3);

					while(rs.next())
					{
						file_type_code	=	checkForNull(rs.getString("file_type_code"));
						file_type_desc	=	checkForNull(rs.getString("file_type_desc"));
						
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block6Bytes, _wl_block6);

					}
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService populateFSFileType: "+e);
	}
	
	try
	{
		if (criteria.equals("populateFSLocation"))
		{

			String sqlString		=	"";
			String file_sto_code	=	"";
			String file_sto_desc	=	"";

			sqlString = " select fs_locn_code, short_desc from fm_storage_locn where facility_id = ? and eff_status = 'E' and permanent_file_area_yn = 'N' and locn_identity = '"+centralValue+"' ";
			if(rs != null)	rs.close();
			if(pstmt != null)pstmt.close();
			pstmt	=	con.prepareStatement(sqlString);
			pstmt.setString(1, facilityId);
			rs	=	pstmt.executeQuery();
			if (rs != null)
			{	
				
            _bw.write(_wl_block7Bytes, _wl_block7);
	
				while(rs.next())
				{
					file_sto_code	=	checkForNull(rs.getString("fs_locn_code"));
					file_sto_desc	=	checkForNull(rs.getString("short_desc"));
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(file_sto_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(file_sto_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService populateFSLocation : "+e);
	}

	try
	{
		if (criteria.equals("repopulateFSLocn"))
		{

			String sqlString		=	"";
			String file_sto_code	=	"";
			String file_sto_desc	=	"";

			if(fm_setup_ip.equals("Y"))
			{
				sqlString	= "select FS_LOCN_CODE, short_desc from fm_storage_locn where locn_identity='"+centralValue+"' and eff_status = 'E' and facility_id=? order by short_desc";

				if(rs != null)		rs.close();
				if(pstmt != null)		pstmt.close();
				pstmt	=	con.prepareStatement(sqlString);
				pstmt.setString(1, facilityId);
				rs	=	pstmt.executeQuery();
				
				if (rs != null)
				{	
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
			
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				while(rs.next())
				{
					file_sto_code	=	checkForNull(rs.getString("fs_locn_code"));
					file_sto_desc	=	checkForNull(rs.getString("short_desc"));
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(file_sto_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(file_sto_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}
			else
			{	
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService repopulateFSLocn : "+e);
	}

	try
	{
		pstmt	=	null;
		rs		=	null;
		if(servicecode == null) servicecode="";

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='testform' id='testform'>");


		/* MR SECTION - Added by Sridhar R on 18 JUNE 2004 */
		if (!(MRSectionCode == null || MRSectionCode.equals("")))
		{
			if(!MRSectionCode.equals("popfslocn"))
			{	

				
				
            _bw.write(_wl_block13Bytes, _wl_block13);

				if(rs4 != null)		rs4.close();
				if(pstmt4 != null)		pstmt4.close();
				pstmt4=con.prepareStatement("select SHORT_NAME,MR_SECTION_CODE from MR_SECTION where eff_status='E' and MR_SECTION_TYPE like ? and FACILITY_ID like ? order by SHORT_NAME");
				pstmt4.setString(1,MRSectionCode);
				pstmt4.setString(2,facilityId);
				rs4=pstmt4.executeQuery();
				
				if(rs4!=null)
				{
					while(rs4.next())
					{
						dat4 = checkForNull(rs4.getString("SHORT_NAME"));
						ID4 = checkForNull(rs4.getString("MR_SECTION_CODE"));	 
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dat4));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ID4));
            _bw.write(_wl_block16Bytes, _wl_block16);
		} //end of while
				}
				if(rs4!=null)rs4.close();
				if(pstmt4!=null)pstmt4.close();
			}//end of main if..
			
			//Population of fs location 
			String sqlString  = "";
			String file_sto_code = "";
			String file_sto_desc = "";

			if(fm_setup_ip.equals("Y"))
			{

				if(MRSectionCode.equals("D"))
				{
					sqlString	= "select fs_locn_code, short_desc from fm_storage_locn where facility_id = ? and mr_locn_yn ='Y' and permanent_file_area_yn = 'Y' and locn_identity = '"+centralValue+"' ";
				}
				else if(MRSectionCode.equals("C"))
				{
					sqlString	= "select FS_LOCN_CODE, short_desc from fm_storage_locn where locn_identity='"+centralValue+"' and eff_status = 'E' and permanent_file_area_yn = 'N' and facility_id=? order by short_desc";
				}
			}
			if(rs != null)		rs.close();
			if(pstmt != null)		pstmt.close();
	
			pstmt	=	con.prepareStatement(sqlString);
			pstmt.setString(1, facilityId);
			rs	=	pstmt.executeQuery();
			if (rs != null)
			{
				
            _bw.write(_wl_block12Bytes, _wl_block12);

				while(rs.next())
				{
					file_sto_code	=	checkForNull(rs.getString("fs_locn_code"));
					file_sto_desc	=	checkForNull(rs.getString("short_desc"));
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(file_sto_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(file_sto_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}

		if (!(deptcode == null || deptcode.equals("")))
		{
			if(rs != null)		rs.close();
			if(pstmt != null)		pstmt.close();

			pstmt=con.prepareStatement("select service_short_desc, service_code from am_facility_service_vw where operating_facility_id = ? and dept_code = ? and eff_status = 'E' order by service_short_desc");
			pstmt.setString(1,facilityId);
			pstmt.setString(2,deptcode);
			rs=pstmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{  
					dat=checkForNull(rs.getString("service_short_desc"));
					ID  = checkForNull(rs.getString("service_code"));
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}

		/* SECTION - Added by Sridhar on 01/02/04 */

		if (!(deptcode == null || deptcode.equals("")))
		{
			if(rs3 != null)		rs3.close();
			if(pstmt3 != null)		pstmt3.close();
			pstmt3=con.prepareStatement("select section_short_desc, section_code from am_dept_section_vw where dept_code = ? and eff_status = 'E' order by section_short_desc");
			pstmt3.setString(1,deptcode);
			rs3=pstmt3.executeQuery();

			if(rs3!=null)
			{
				while(rs3.next())
				{
					dat3 = checkForNull(rs3.getString("section_short_desc"));
					ID3  = checkForNull(rs3.getString("section_code"));
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dat3));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ID3));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sectioncode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ID3));
            _bw.write(_wl_block23Bytes, _wl_block23);
		}
			}	
		}

	}catch(Exception e)
	{
		out.print("Exception in GetService service Pop : "+e);
	}

	try
	{
		if(criteria.equals("populatefs"))
		{
		if(sectionType.equals("D") || sectionType.equals("C"))
			{
		
            _bw.write(_wl_block13Bytes, _wl_block13);

				if(rs4 != null)		rs4.close();
				if(pstmt4 != null)		pstmt4.close();
				pstmt4=con.prepareStatement("select SHORT_NAME,MR_SECTION_CODE from MR_SECTION where eff_status='E' and MR_SECTION_TYPE like ? and FACILITY_ID like ? order by SHORT_NAME");
				pstmt4.setString(1,sectionType);
				pstmt4.setString(2,facilityId);
				rs4=pstmt4.executeQuery();

				if(rs4!=null)
				{
					while(rs4.next())
					{
						dat4 = checkForNull(rs4.getString("SHORT_NAME"));
						ID4 = checkForNull(rs4.getString("MR_SECTION_CODE"));	 

						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dat4));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ID4));
            _bw.write(_wl_block25Bytes, _wl_block25);

					} //end of while
				}
				if(rs4!=null)rs4.close();
				if(pstmt4!=null)pstmt4.close();

			}
		
		if(sectionType.equals("C"))
		{
			sql_1 =" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and  permanent_file_area_yn='N' and locn_identity = '"+centralValue+"' and eff_status = 'E' order by short_desc ";
		}
		else if(sectionType.equals("D"))
		{
			sql_1 ="Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and eff_status = 'E' and MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity ='"+centralValue+"' order by short_desc ";
		}
		else if(sectionType.equals(""))
		{
			sql_1="Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and locn_identity ='"+centralValue+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ";
		}

		stmt= con.createStatement();
		rset = stmt.executeQuery(sql_1);  

		if(rset != null) 
		{	
			while( rset.next() ) 
			{
				String mr_location_code=checkForNull(rset.getString("fs_locn_code"));
				String short_desc=checkForNull(rset.getString("short_desc"));     	
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(mr_location_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
		}           
			if(rset != null ) rset.close();
		}
	}catch(Exception e)
	{
		out.print("Exception in GetService populatefs : "+e);
	}

	try
	{
		if(criteria.equals("populateDF"))
		{
			StringBuffer dfsql = new StringBuffer();
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");

			if(fmInstallyn.equals("Y"))
			{

				if(dfsql.length() > 0) dfsql.delete(0,dfsql.length());
				dfsql.append(" select a.file_type_code file_type_code, b.short_desc file_type_desc from FM_FILE_TYPE_FOR_FSL a, MR_FILE_TYPE b where b.facility_id ='"+facilityId+"'  and a.facility_id = b.facility_id and a.fs_locn_code ='"+defaultlocn+"' and a.file_type_code = b.file_type_code and a.eff_status = 'E' "); 

				if(levelfcare.equals("A"))
					dfsql.append(" and b.appl_to_ip='Y' ");
				else if(levelfcare.equals("E"))
					dfsql.append(" and b.appl_to_em='Y' ");

			}
			else if(fmInstallyn.equals("N"))
			{
				if(dfsql.length() > 0) dfsql.delete(0,dfsql.length());
				dfsql.append(" select file_type_code, short_desc file_type_desc from MR_FILE_TYPE where facility_id ='"+facilityId+"' and EFF_STATUS = 'E' ");

				if(levelfcare.equals("A"))
					dfsql.append(" and appl_to_ip='Y' ");
				else if(levelfcare.equals("E"))
					dfsql.append(" and appl_to_em='Y' ");
			} 
			dfsql.append(" order by file_type_desc ");


//out.println("<script>alert(\""+dfsql.toString()+"\")</script>");

			if(dfrset != null) dfrset.close();
			if(dfstmt != null) dfstmt.close();
			dfstmt=con.createStatement();
			dfrset=dfstmt.executeQuery(dfsql.toString());

			if(dfsql.length() > 0) dfsql.delete(0,dfsql.length());



			if(dfrset!=null)
			{
				while(dfrset.next())
				{
					default_code = checkForNull(dfrset.getString("file_type_code"));
					default_desc = checkForNull(dfrset.getString("file_type_desc"));
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(default_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(default_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
		}
			}
			if(dfrset != null )dfrset.close();
			if(dfstmt != null )dfstmt.close();
		}

	}catch(Exception e)
	{
		out.print("Exception in GetService populateDF : "+e);
	}
	
	
	}catch(Exception e)
	{
		out.print("Exception in GetService : "+e);
	}
	finally
	{
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();
		if(rs2 != null)		rs2.close();
		if(rs3 != null)		rs3.close();
		if(pstmt3 != null)	pstmt3.close();

		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block33Bytes, _wl_block33);
            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
