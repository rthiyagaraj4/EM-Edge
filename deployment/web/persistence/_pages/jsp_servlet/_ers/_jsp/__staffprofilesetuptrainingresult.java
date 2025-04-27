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

public final class __staffprofilesetuptrainingresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffProfileSetupTrainingResult.jsp", 1709121664277L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script -->\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<!-- <script language=\"javascript\" src=\"../js/RSMessages.js\"></script> -->\n<script language=\"javascript\" src=\"../js/RSCommonFunction.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/StaffProfileSetup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<form name=\'formStaffProfileSetupTrainingResult\' id=\'formStaffProfileSetupTrainingResult\'>\n\t\t<table cellpadding=0 cellspacing=0 border=1 width=\"100%\" id=\'detailTab\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t <tr>\n\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' width=\'7%\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td> \n\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\t\t\n\t\t\t <td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' width=\'15%\'><A  id=\'trng";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' HREF=\"javascript:trng_edit(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n\t\t <input type=\"hidden\" name=\"trng_code";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"trng_code";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ></td> \n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t <td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' width=\'9%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' width=\'9%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' width=\'15%\'>&nbsp;</td>\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' width=\'15%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' width=\'5%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td  Align=\'CENTER\' class =\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'5%\'><A  id=\'remarks";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' HREF=\"javascript:remarks(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">R</A></td>  \n\t\t</tr> \n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</table>\t\t\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</form>\n</body>\n</html>\t\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null; 

	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String funcValue = request.getParameter("funcValue")==null?"":request.getParameter("funcValue");

	String Sql					="";
	String slClassValue			="";
	ArrayList TrainingDetails	= new ArrayList() ;
	String[] record				= null;

	try{
		Con=ConnectionManager.getConnection(request);
	 
		//Sql="SELECT TO_CHAR(a.start_date,'DD/MM/YYYY') Frm_date, TO_CHAR(a.end_date,'DD/MM/YYYY') Todate, b.training_desc trng_desc,a.training_code trng_code, a.facility_type Training_type, a.facility_id facility_id,a.facility_name Organisation,a.certified_yn Certified FROM rs_staff_training a, rs_training b WHERE a.role_type = (?) AND a.staff_id = (?) AND   b.training_code = a.training_code ORDER BY b.training_desc";
		Sql="SELECT TO_CHAR(a.start_date,'DD/MM/YYYY') Frm_date, TO_CHAR(a.end_date,'DD/MM/YYYY') Todate, b.training_desc trng_desc,a.training_code trng_code, a.facility_type Training_type, a.facility_id facility_id,a.facility_name Organisation,a.certified_yn Certified FROM rs_staff_training a, rs_training_lang_vw b WHERE a.role_type = (?) AND a.staff_id = (?) AND   b.training_code = a.training_code and b.language_id = ? ORDER BY b.training_desc";
		
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);

		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()){
			record = new String[8];			
			record[0] = rslRst.getString( "Frm_date");
			record[1] = rslRst.getString( "Todate");
			record[2] = rslRst.getString( "trng_desc");
			record[3] = rslRst.getString( "Training_type");
			record[4] = rslRst.getString( "facility_id");
			record[5] = rslRst.getString( "Organisation");
			record[6] = rslRst.getString( "Certified");
			record[7] = rslRst.getString( "trng_code");				
			TrainingDetails.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();

            _bw.write(_wl_block4Bytes, _wl_block4);

		for( int i=0 ; i< TrainingDetails.size() ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			String[] record1 = (String[])TrainingDetails.get(i);
			
			String Frm_date			=record1[0]==null?"":com.ehis.util.DateUtils.convertDate(record1[0],"DMY","en",locale);
			String Todate			=record1[1]==null?"":com.ehis.util.DateUtils.convertDate(record1[1],"DMY","en",locale);
			String trng_desc		=record1[2]==null?"":record1[2];
			String Training_type	=record1[3]==null?"":record1[3];
			String facility_id		=record1[4]==null?"":record1[4];
			String Organisation		=record1[5]==null?"":record1[5];
			String Certified		=record1[6]==null?"":record1[6];
			String trng_code		=record1[7]==null?"":record1[7];
		
			String trng_type="";
			String cert		="";

			if(Training_type.equalsIgnoreCase("I")){
				trng_type="Inhouse";
			}else if(Training_type.equalsIgnoreCase("L")){
				trng_type="Local";
			}else if(Training_type.equalsIgnoreCase("O")){
				trng_type="Overseas";
			}

			if(Certified.equalsIgnoreCase("Y")){
				cert="Yes";
			}else if(Certified.equalsIgnoreCase("N")){
				cert="No";
			}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Frm_date));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Todate));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(funcValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Frm_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Todate));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trng_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trng_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Training_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Organisation));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Certified));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(trng_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trng_code));
            _bw.write(_wl_block16Bytes, _wl_block16);

			if(trng_type.equals("")){

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else { 

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(trng_type));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			if(Organisation.equals("")){

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
			else {

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Organisation));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(cert));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trng_code));
            _bw.write(_wl_block29Bytes, _wl_block29);

		}

            _bw.write(_wl_block30Bytes, _wl_block30);

	}catch(Exception e){
			out.println("Exception in try of StaffProfileSetUpTrainingResult.jsp : "+e);
	}finally {
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}

            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
