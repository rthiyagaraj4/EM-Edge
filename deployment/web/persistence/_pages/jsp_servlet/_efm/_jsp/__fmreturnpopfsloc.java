package jsp_servlet._efm._jsp;

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
import webbeans.eCommon.*;
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmreturnpopfsloc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMReturnPopFSLoc.jsp", 1709116872516L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMReturnMRDFile.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\tvar opt=parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\tparent.frames[2].document.forms[0].p_out_fsloc.add(opt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\tvar opt=parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].p_out_fcy.add(opt);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[2].document.forms[0].p_out_fcy.value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.frames[1].document.forms[0].out_fs_locn.add(opt);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.frames[1].document.forms[0].outstndFSLocn.add(opt);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con					= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet rs						= null;
	
	String facilityid		= (String) session.getValue("facility_id");
	String str			=	"";
	
	String p_facility_id	= request.getParameter("p_facility_id");
	String p_curr_fs_loc = request.getParameter("p_curr_fs_loc");
	String param_num		= request.getParameter("param_num");
	String locn_code		= request.getParameter("locn_code");
	String p_fs_locn_id   = request.getParameter("p_fs_locn_id");
   String out_fcy   = request.getParameter("out_fcy");
	String p_code		 = "";
	String p_desc		 = "";
	if(out_fcy==null) out_fcy="";
	try
	{
		stmt = con.createStatement();

		if (param_num.equals("1"))
		{                                  
			str = "";
			//str = "select a.fs_locn_code,a.short_desc from fm_storage_locn a , fm_parameter b where a.facility_id = ? and a.fs_locn_code != ? and a.eff_status='E' and a.facility_id=b.facility_id and LOCN_IDENTITY = ? order by 2" ;
			str = "SELECT"
					  +"  a.fs_Locn_Code"
					  +"  , fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
					  +"FROM"
					  +"  fm_Storage_Locn a"
					  +"  , fm_Parameter b "
					  +"WHERE a.Facility_Id = b.Facility_Id "
					  +"  AND a.Facility_Id = ? "
					  +"  AND a.fs_Locn_Code != ? "
					  +"  AND a.eff_Status = 'E' "
					  +"  AND Locn_Identity = ? "
					 // +"  AND a.language_id = ? "
					  +"ORDER BY"
					  +"  2";
			
			pstmt = con.prepareStatement(str);
			pstmt.setString(1,p_facility_id);
			pstmt.setString(2,p_curr_fs_loc);
			pstmt.setString(3,locn_code);
		//	pstmt.setString(4,localeName);
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				p_code	= rs.getString("fs_locn_code");
				p_desc	= rs.getString("short_desc");
				
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			if(rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		else if(param_num.equals("2"))
		{
			str = "";
			//str = "select facility_id,facility_name from sm_facility_param order by 2" ;
		//	str = "select facility_id,facility_name from sm_facility_param_LANG_VW WHERE language_id = '"+localeName+"' order by 2" ;
	str = "SELECT   facility_id,sm_get_desc.sm_facility_param (facility_id,'"+localeName+"' ,1)  facility_name FROM sm_facility_param ORDER BY 2 " ;
			
			rs	= stmt.executeQuery(str);
		
			if(rs != null)
			{
				while(rs.next())
				{
					p_code	= rs.getString("facility_id");
					p_desc  = rs.getString("facility_name");

					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block15Bytes, _wl_block15);

		  }
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block1Bytes, _wl_block1);


	}
	else if(param_num.equals("3")) // This is for the Query File Not Received at MRD FS Locn Population
	{
		str = "";
		//str = "select a.fs_locn_code,a.short_desc from fm_storage_locn a  where a.facility_id = ? and a.fs_locn_code != ? and a.eff_status='E' order by 2";
		 str = "SELECT"
				  +"  a.fs_Locn_Code"
				  +"  ,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
				  +"FROM"
				  +"  fm_Storage_Locn a "
				  +"WHERE a.Facility_Id = ? "
				  +"  AND a.fs_Locn_Code != ? "
				//  +"  AND a.language_id = ? "
				  +"  AND a.eff_Status = 'E'";

		

		
		pstmt = con.prepareStatement(str);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_curr_fs_loc);
	//	pstmt.setString(3,localeName);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			p_code				= rs.getString("fs_locn_code");
			p_desc				= rs.getString("short_desc");
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	else if(param_num.equals("4")) //from QueryFMFileNotReturnedToMRDSearch.jsp
	{	
		
		str = "";
		//str = "SELECT a.fs_locn_code,a.short_desc FROM fm_storage_locn a,fm_parameter b WHERE a.facility_id = ? AND a.fs_locn_code != ? AND a.eff_status='E' AND a.facility_id=b.facility_id AND LOCN_IDENTITY = ? ORDER BY 2" ;
		str = "SELECT"
					  +"  a.fs_Locn_Code"
					  +"  , fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 )  Short_desc "
					  +"FROM"
					  +"  fm_Storage_Locn a"
					  +"  , fm_Parameter b "
					  +"WHERE a.Facility_Id = b.Facility_Id "
					  +"  AND a.Facility_Id = ? "
					  +"  AND a.fs_Locn_Code != ? "
					  +"  AND a.eff_Status = 'E' "
					  +"  AND Locn_Identity = ? "
					//  +"  AND a.language_id = ? "
					  +"ORDER BY"
					  +"  2";
		
		if(!out_fcy.equals(""))
		{
        p_facility_id=out_fcy;
		}
		pstmt = con.prepareStatement(str);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_curr_fs_loc);
		pstmt.setString(3,p_fs_locn_id);
		//pstmt.setString(4,localeName);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			p_code				= rs.getString("fs_locn_code");
			p_desc				= rs.getString("short_desc");
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	else if(param_num.equals("5"))  //from RepStatisticsFileNotReturnedFrame.jsp
	{ 
		str = "";
		//str = "SELECT a.fs_locn_code,a.short_desc FROM fm_storage_locn a,fm_parameter b WHERE a.facility_id = ? AND a.fs_locn_code != ? AND a.eff_status='E' AND a.facility_id=b.facility_id AND LOCN_IDENTITY = ? ORDER BY 2" ;
		str = "SELECT"
			  +"  a.fs_Locn_Code"
			  +"  , fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
			  +"FROM"
			  +"  fm_Storage_Locn a"
			  +"  , fm_Parameter b "
			  +"WHERE a.Facility_Id = b.Facility_Id "
			  +"  AND a.Facility_Id = ? "
			  +"  AND a.fs_Locn_Code != ? "
			  +"  AND a.eff_Status = 'E' "
			  +"  AND Locn_Identity = ? "
		//	  +"  AND a.language_id = ? "
			  +"ORDER BY"
			  +"  2";
		
		pstmt = con.prepareStatement(str);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_curr_fs_loc);
		pstmt.setString(3,p_fs_locn_id);
	//	pstmt.setString(4,localeName);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			p_code	= rs.getString("fs_locn_code");
			p_desc	= rs.getString("short_desc");
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e);
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
