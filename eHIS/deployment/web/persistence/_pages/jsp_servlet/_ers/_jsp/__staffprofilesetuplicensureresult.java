package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __staffprofilesetuplicensureresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffProfileSetupLicensureResult.jsp", 1709121662730L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<!-- <script language=\"javascript\" src=\"../js/RSMessages.js\"></script> -->\n<script language=\"javascript\" src=\"../js/RSCommonFunction.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/StaffProfileSetup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<form name=\'formStaffProfileSetupTrainingResult\' id=\'formStaffProfileSetupTrainingResult\'>\n\t\t<table cellpadding=0 cellspacing=0 border=1 width=\"100%\" id=\'detailTab\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<tr>\n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' width=\'24%\'><A  id=\'title\' HREF=\"javascript:license_details(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',  \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\n\t\t\t\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A></td> \n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\'20%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td> \n\t\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' width=\'13%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' width=\'19%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' width=\'8%\'><A  id=\'remarks\' HREF=\"javascript:remarks_license(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\">R</A></td>\n\t\t\t\t<input type=\'hidden\' name=\'fac_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'fac_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'fac_type";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'fac_type";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t</tr>\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</form>\n</body>\n</html>\t\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null; 

	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String funcValue = request.getParameter("funcValue")==null?"":request.getParameter("funcValue");

	String Sql					="";
	String slClassValue			="";
	ArrayList LicenseDetails	= new ArrayList() ;
	String[] record				= null;
	try{
		Con=ConnectionManager.getConnection(request);
		//Sql="SELECT b.license_desc license_desc,a.license_id license_id,a.license_code license_code,TO_CHAR(a.issue_date,'DD/MM/YYYY') issue_dt,TO_CHAR(a.valid_until,'DD/MM/YYYY') valid_dt,a.FACILITY_TYPE facility_type,a.FACILITY_ID	facitility_id,a.FACILITY_NAME facility_name FROM rs_staff_licensure a,rs_licensure b WHERE a.role_type = (?) AND a.staff_id = (?) AND  b.license_code = a.license_code ORDER BY b.license_desc";
		Sql="SELECT b.license_desc license_desc,a.license_id license_id,a.license_code license_code,TO_CHAR(a.issue_date,'DD/MM/YYYY') issue_dt,TO_CHAR(a.valid_until,'DD/MM/YYYY') valid_dt,a.FACILITY_TYPE facility_type,a.FACILITY_ID facitility_id,a.FACILITY_NAME facility_name FROM rs_staff_licensure a,rs_licensure_lang_vw b WHERE a.role_type = (?) AND a.staff_id = (?) AND  b.license_code = a.license_code and b.language_id = ? ORDER BY b.license_desc";
		
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);

		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()){
			record = new String[8];
			record[0] = rslRst.getString( "license_desc");
			record[1] = rslRst.getString( "license_id");
			record[2] = rslRst.getString( "license_code");
			record[3] = rslRst.getString( "issue_dt");
			record[4] = rslRst.getString( "valid_dt");
			record[5] = rslRst.getString( "facility_type");
			record[6] = rslRst.getString( "facitility_id");
			record[7] = rslRst.getString( "facility_name");				
			
			LicenseDetails.add(record) ;

		}

		//System.err.println("LicenseDetails.size()"+LicenseDetails.size());
		//System.err.println("LicenseDetails-------------->"+LicenseDetails);


            _bw.write(_wl_block7Bytes, _wl_block7);


		 if(LicenseDetails.size()!=0)
		{
		for( int i=0 ; i< LicenseDetails.size() ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			record = (String[])LicenseDetails.get(i);
			
			String lic_desc			=record[0]==null?"":record[0];
			String lic_id			=record[1]==null?"":record[1];
			String lic_code			=record[2]==null?"":record[2];
			String issue_dt			=record[3]==null?"":com.ehis.util.DateUtils.convertDate(record[3],"DMY","en",locale);
			String valid_dt			=record[4]==null?"":com.ehis.util.DateUtils.convertDate(record[4],"DMY","en",locale);
			String fac_type			=record[5]==null?"":record[5];
			String fac_id			=record[6]==null?"":record[6];
			String orng				=record[7]==null?"":record[7];

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(funcValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(lic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(lic_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(lic_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(issue_dt));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(valid_dt));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fac_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orng));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(lic_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(lic_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(issue_dt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(valid_dt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(orng));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(lic_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fac_type));
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
		}
	}
	catch(Exception e)
	{
			out.println("Exception in try of StaffProfileSetUpLicenseResult.jsp : "+e);
			//System.err.println("LicenseDetails.size()"+LicenseDetails.size());
		//System.err.println("LicenseDetails-------------->"+LicenseDetails);

	}
	finally 
	{
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}

            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
