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

public final class __staffprofilesetupexprresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffProfileSetupExprResult.jsp", 1709121661964L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommonFunction.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/StaffProfileSetup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<form name=\'formStaffProfileExprResult\' id=\'formStaffProfileExprResult\'>\n<table cellpadding=0 cellspacing=0 border=1 width=\"100%\" id=\'detailTab\'>\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t\t\t<tr>\n\t\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' width=\'10%\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' width=\'10%\'>&nbsp;</td> \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' width=\'16%\'><A  id=\'remarks\' HREF=\"javascript:expr_edit(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A></td> \n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\'11%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td> \n\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' width=\'13%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td> \n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td> \n\t\t\t\t<input type=\'hidden\' name=\'locn_type\' id=\'locn_type\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\t\n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td> \n\t\t\t\t<input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' width=\'7%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td> \n\t\t\t\t<input type=\'hidden\' name=\'grade_code\' id=\'grade_code\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' width=\'5%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td> \n\t\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' width=\'7%\'><A  id=\'remarks\' HREF=\"javascript:remarks_Expr(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">R</A></td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	System.err.println("ctrl cmoes to rsultpage");
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null; 

	String role_type	= request.getParameter("role_type");
	String staff_id		= request.getParameter("staff_id");
	String db_action	= request.getParameter("db_action");
	String funcValue	= request.getParameter("funcValue");


	String Sql					="";
	String slClassValue			="";
	ArrayList ExprDetails		= new ArrayList() ;
	String[] record				= null;
	String type_desc			="";

	if(role_type == null || role_type.equals("null")) role_type =" "; else role_type = role_type.trim();
	if(staff_id == null || staff_id.equals("null")) staff_id =" "; else staff_id = staff_id.trim();
	if(db_action == null || db_action.equals("null")) db_action =" "; else db_action = db_action.trim();
	if(funcValue == null || funcValue.equals("null")) funcValue =" "; else funcValue = funcValue.trim();

	try{
		//ConnectionManager.getConnection(request);
		Con = ConnectionManager.getConnection(request);
		//Sql	= "SELECT a.serial_no serial_no,TO_CHAR(a.from_date,'DD/MM/YYYY')frm_dt,TO_CHAR(a.TO_DATE,'DD/MM/YYYY')to_dt, b.position_desc position_desc,a.position_code position_code,a.facility_type facility_type,a.facility_id facilty_id,a.facility_name facility_name,a.locn_type locn_type,d.short_desc workplace_type,a.workplace_code workplace_code,a.workplace_name workplace_name,a.grade_code grade_code,c.grade_desc grade_desc,a.fte fte FROM rs_staff_experience a,am_position b,rs_grade c,am_care_locn_type d WHERE a.role_type = (?) AND a.staff_id = (?) AND b.position_code = a.position_code AND c.grade_code=a.grade_code and d.locn_type=a.locn_type ORDER BY b.position_desc";
		Sql	= "SELECT a.serial_no serial_no,TO_CHAR(a.from_date,'DD/MM/YYYY')frm_dt,TO_CHAR(a.TO_DATE,'DD/MM/YYYY')to_dt, b.position_desc position_desc,a.position_code position_code,a.facility_type facility_type,a.facility_id facilty_id,a.facility_name facility_name,a.locn_type locn_type,d.short_desc workplace_type,a.workplace_code workplace_code,a.workplace_name workplace_name,a.grade_code grade_code,c.grade_desc grade_desc,a.fte fte FROM rs_staff_experience a,am_position_lang_vw b,rs_grade_lang_vw c,am_care_locn_type_lang_vw d WHERE a.role_type = (?) AND a.staff_id = (?) AND b.position_code = a.position_code AND c.grade_code=a.grade_code and d.locn_type=a.locn_type AND b.language_id = ? and c.language_id = b.language_id and d.language_id = b.language_id ORDER BY b.position_desc";

		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);

		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()){
			record = new String[15];
			record[0] = rslRst.getString( "frm_dt");
			record[1] = rslRst.getString( "to_dt");
			record[2] = rslRst.getString( "position_desc");
			record[3] = rslRst.getString( "facility_type");
			record[4] = rslRst.getString( "facilty_id");
			record[5] = rslRst.getString( "facility_name");
			record[6] = rslRst.getString( "workplace_type");
			record[7] = rslRst.getString( "workplace_code");
			record[8] = rslRst.getString( "workplace_name");
			record[9] = rslRst.getString( "grade_code");
			record[10] = rslRst.getString( "grade_desc");
			record[11] = rslRst.getString( "fte");
			record[12] = rslRst.getString( "position_code");
			record[13] = rslRst.getString( "locn_type");
			record[14] = rslRst.getString( "serial_no");
			ExprDetails.add(record) ;
		}

		//System.err.println("ExprDetails---------->"+ExprDetails);
		//System.err.println("ExprDetails-----size----->"+ExprDetails.size());


            _bw.write(_wl_block4Bytes, _wl_block4);

     if(ExprDetails.size()!=0)  {      		
    for( int i=0 ; i< ExprDetails.size() ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			String[] record1 = (String[])ExprDetails.get(i);
			
			String frm_dt			=record1[0]==null?"":com.ehis.util.DateUtils.convertDate(record1[0],"DMY","en",locale);
			String to_dt			=record1[1]==null?"":com.ehis.util.DateUtils.convertDate(record1[1],"DMY","en",locale);
			String position_desc	=record1[2]==null?"":record1[2];
			String facility_type	=record1[3]==null?"":record1[3];
			String facilty_id		=record1[4]==null?"":record1[4];
			String facility_name	=record1[5]==null?"":record1[5];
			String workplace_type	=record1[6]==null?"":record1[6];
			String workplace_code	=record1[7]==null?"":record1[7];
			String workplace_name	=record1[8]==null?"":record1[8];
			String grade_code		=record1[9]==null?"":record1[9];
			String grade_desc		=record1[10]==null?"":record1[10];
			String fte				=record1[11]==null?"":record1[11];
			String position_code	=record1[12]==null?"":record1[12];
			String locn_type		=record1[13]==null?"":record1[13];
			String serial_no		=record1[14]==null?"":record1[14];

			if(facility_type.equalsIgnoreCase("E")){
				type_desc="Enterprise";
			}else if(facility_type.equalsIgnoreCase("X"))
				type_desc="External";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(frm_dt));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
				if(to_dt.equals("")||to_dt==null){

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
				}
				else{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(to_dt));
            _bw.write(_wl_block7Bytes, _wl_block7);

				}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(funcValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facilty_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(workplace_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(workplace_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(grade_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(grade_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fte));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(frm_dt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(to_dt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(serial_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(type_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facilty_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(workplace_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(workplace_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(grade_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(grade_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fte));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(serial_no));
            _bw.write(_wl_block29Bytes, _wl_block29);

		}// end for loop
}//end if
	}catch(Exception e){
			out.println("Exception in try of StaffProfileSetUpLicenseResult.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}

            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
