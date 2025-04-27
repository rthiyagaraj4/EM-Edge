package jsp_servlet._emo._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __moselectreferral extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOSelectReferral.jsp", 1709118434337L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n  <script>\n if(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"==\"regpat\")\nvar obj =parent.frames[3].document.forms[0].referral_source\nelse\n var obj =parent.frames[3].document.forms[0].referral_source\n\tvar length  = obj.length;\n\tfor(i=0;i<length;i++) {obj.remove(0);}\n\n    var opt= parent.frames[1].document.createElement(\'Option\');\n    opt.text=\'----------\' +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \'----------\';\n    opt.value=\"\";\n    obj.add(opt) ;     \n   \n   </script>\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n <script>\nif(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"==\"regpat\")\nvar opt= parent.frames[3].document.createElement(\'Option\');\nelse\nvar opt= parent.frames[1].document.createElement(\'Option\');\nopt.text=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"; \nopt.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\nobj.add(opt) ;\n\nif(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"==\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")\n\t\t{\nif(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"==\"regpat\")\n{\nparent.frames[3].document.MO_regn_form.referral_source.options[\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'].selected=true;\n}else\n{\n\nparent.frames[1].document.MO_regn_form.referral_source.options[\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'].selected=true;\n}\n\t\t}\n\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\tparent.frames[3].document.MO_regn_form.referral_source.options[1].selected=true;\n\t\tparent.frames[3].document.MO_regn_form.referral_source.disabled=true;\n\t\tparent.frames[3].document.MO_regn_form.hcare_type.value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\tparent.frames[3].document.MO_regn_form.hcare_type.disabled=true;\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\tparent.frames[3].document.MO_regn_form.referral_source.disabled=false;\n\t\tparent.frames[3].document.MO_regn_form.hcare_type.disabled=false;\n\t\t\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\tparent.frames[3].document.MO_regn_form.referral_source.disabled=false;\n\t\tparent.frames[3].document.MO_regn_form.hcare_type.disabled=false;\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t</script>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);


Connection con             = null;
ResultSet rs	           = null;
java.sql.Statement stmt	   = null;
String sql         = "";
//String postmortem_reqd_yn = "";
//String position_desc         ="";
request.setCharacterEncoding("UTF-8");
String ref_code           = request.getParameter("ref_code")==null?"":request.getParameter("ref_code");
String ref_type           = request.getParameter("ref_type")==null?"":request.getParameter("ref_type");
String regpat           = request.getParameter("regpat")==null?"":request.getParameter("regpat");


String locale=(String)session.getAttribute("LOCALE"); 
String facilityid=(String)session.getValue("facility_id");
String hcare_type_code=request.getParameter("hcare_type_code") == null?"":request.getParameter("hcare_type_code");
//String area_desc           = null;
try
{  /* if(ref_code.equals("L"))
	{
	sql="select FACILITY_ID,FACILITY_NAME from sm_facility_param where facility_id='"+facilityid+"'";
	}
	 else if(ref_code.equals("E"))
	{
	
	sql="select FACILITY_ID,FACILITY_NAME from sm_facility_param where facility_id!='"+facilityid+"' order by 2";
	
	}else if(ref_code.equals("X"))
	{
     sql="select REFERRAL_CODE,SHORT_DESC from AM_referral where eff_status='E' order by 2";
	}*/

	if(ref_code.equals("L"))
	{
		sql="SELECT  a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc FROM sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b  WHERE a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.hcare_setting_type_code = b.hcare_setting_type_code  AND a.facility_id = '"+facilityid+"' ORDER BY b.short_desc";
	}else if(ref_code.equals("E"))
	{
		sql="SELECT  a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc FROM sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b  WHERE a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.hcare_setting_type_code = b.hcare_setting_type_code and  a.hcare_setting_type_code ='"+hcare_type_code+"' AND a.facility_id != '"+facilityid+"' ORDER BY b.short_desc";
		
		
	}else if(ref_code.equals("X"))
	{
		sql="Select  a.REFERRAL_CODE referred_to_id,a.SHORT_DESC referred_to_id_desc, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral_lang_vw a, am_hcare_setting_type_lang_vw b where    a.LANGUAGE_ID='"+locale+"'  and a.LANGUAGE_ID=b.LANGUAGE_ID  and a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type='"+hcare_type_code+"' order by a.short_desc";

		
	}
	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(regpat));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);
int i=1;
	while(rs.next())
	{
		hcare_type_code=rs.getString(3);
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(regpat));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(regpat));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
if(regpat.equals("regpat"))
		{
		if(ref_code.equals("L"))
		{
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hcare_type_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);
}}else
		{if(ref_code.equals("L")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hcare_type_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}}
            _bw.write(_wl_block22Bytes, _wl_block22);

	i++;

}
 
 if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();

 }
 catch(Exception ee)
 {
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
	ee.printStackTrace();
 }
finally
{
   ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
