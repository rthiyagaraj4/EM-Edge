package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __getreferralvals extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/GetReferralVals.jsp", 1742386876163L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Same coding from GetCheckoutVals.jsp -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n    <head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n        <script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<script>\t\t\t\t\t\t\t\t\t\t\nif(parent.document.frames[1].document.getElementById(\'org_type\')) \nparent.document.frames[1].document.getElementById(\'org_type\').innerHTML=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"; \n\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n                <script>\n                        var temp = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n                        var temp1=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\tvar jsp_val = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n                        var hcare_setting_type_desc=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n                        var hcare_setting_type=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n                        var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                        opt.text=temp1;\n\t                    opt.value=temp;\n\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_code = parent.document.frames[1].document.forms[0].ref_code.value;\n\t\t\t\t\t\t\tif (ref_code == temp)\n\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t}\n                        ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n                            opt.selected=true;\n                        ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n                        \n                        parent.document.frames[1].document.forms[0].referred_to.add(opt);\n                        parent.document.frames[1].document.forms[0].hcare_setting_type.value=hcare_setting_type;\n                        parent.document.frames[1].document.forms[0].hcare_setting_type_desc.value=hcare_setting_type_desc;\n                </script>\n            ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n            <script>\n            </script>\n            ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n                    <script>\n\t\t\t\t\t\t\tvar ref_type = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n                            var temp = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n                            var temp1=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t\t\tvar jsp_val = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\n\t                            var hcare_setting_type_desc=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t                        var hcare_setting_type=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n                            var opt3=parent.document.frames[1].document.createElement(\"OPTION\");\n\n                            opt3.text=temp1;\n                            opt3.value=temp;\n\t\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar ref_code = parent.document.frames[1].document.forms[0].referral_type.value;\n\t\t\t\t\t\t\t\tif (ref_code == temp)\n\t\t\t\t\t\t\t\topt3.selected=true;\n\t\t\t\t\t\t\t}\n\n                            ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n                                opt3.selected=true;\n                            ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n                            \n                            parent.document.frames[1].document.forms[0].referred_to.add(opt3);\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].hcare_setting_type.value=hcare_setting_type;\n                            parent.document.frames[1].document.forms[0].hcare_setting_type_desc.value=hcare_setting_type_desc;\n\t\t\t\t\t\t\t//}\n                    </script>\n                ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar jsp_val = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t\tvar locn_type_value = parent.document.frames[1].document.forms[0].locn_type_val.value;\n\t\t\t\t\t\t\topt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Nursing Unit\";\n                            opt.value=\"N\";\n\t\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t\tif (locn_type_value == \"N\")\n\t                           opt.selected=true;\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt\n                            opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Clinic\";\n                            opt.value=\"C\";\n\t\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t\tif (locn_type_value==\"C\")\n\t                            opt.selected=true;\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt;\n                            opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Day Care\";\n                            opt.value=\"D\";\n\t\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t\tif (locn_type_value==\"D\")\n\t                            opt.selected=true;\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt;\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n                        <script>\n\n                            opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Nursing Unit\";\n                            opt.value=\"N\";\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt\n\n                            opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Clinic\";\n                            opt.value=\"C\";\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt\n                            opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Day Care\";\n                            opt.value=\"D\";\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt;\n                    </script>\n                    ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n                        <script>\n                            \n                            opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Nursing Unit\";\n                            opt.value=\"N\";\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt\n                        </script>\n                    ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n                        <script>\n\n                            opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=\"Clinic\";\n                            opt.value=\"C\";\n                            parent.document.frames[1].document.forms[0].location0.add(opt);\n                            parent.document.frames[1].location0_array[parent.document.frames[1].location0_array.length] = opt\n                        </script>\n                    ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n                        <script>\n                        </script>\n                    ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<script>\n\t\t\t\t var speciality_value = \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\t\t var HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'GetReferralVals.jsp?src1=4&jsp_val=discharge&speciality=\"+speciality_value+\"\'></form></BODY></HTML>\";\n\t\t    \t parent.frames[2].document.write(HTMLVal);\n\t\t\t\t parent.frames[2].document.forms[0].submit();\n\n\t\t\t\t \n\t\t\t\t </script>\n\t\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                            <script>\n                            var temp = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n                            var temp3=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n                            var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            parent.document.frames[1].document.forms[0].open_to_all_pract_yn.value=temp3;\n                            opt.text=temp1;\n\t\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\topt.value\t=\ttemp+\":::\"+temp1;\n\t\t\t\t\t\t\t\tvar locn_code_value = parent.frames[1].document.forms[0].locn_code_value.value;\n\t\t\t\t\t\t\t\tif (locn_code_value == temp)\n\t\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\topt.value=temp+\":::\"+temp1;\n\t\t\t\t\t\t\t}\n                            ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n                            parent.document.frames[1].document.forms[0].location1.add(opt);\n                            parent.document.frames[1].document.forms[0].location1_desc.value=temp1;\n                            </script>\n                        ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n                            <script>\n                \n                            var temp = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n                            var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n                            opt.text=temp1;\n                            opt.value=temp;\n                            ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n                            parent.document.frames[1].document.forms[0].practitioner.add(opt);\n                            parent.document.frames[1].document.forms[0].practitioner_name.value=temp1;\n                            </script>\n                            ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t    \t\t\t\t\t<script>\n\t    \t\t\t\t\t\tvar oOption = parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tvar code =  \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t    \t\t\t\t\t\toOption.text=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t    \t\t\t\t\t\toOption.value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t\t\t\t\t\t\t\tvar jsp_val = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\t\t\t\t\tif (jsp_val != \"\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar serv_code = parent.document.frames[1].document.forms[0].serv_code.value;\t\n\t\t\t\t\t\t\t\t\tif (serv_code == code)\n\t\t\t\t\t\t\t\t\t\toOption.selected = true;\n\t\t\t\t\t\t\t\t}\n\t                             parent.document.frames[1].document.forms[0].service.add(oOption);\n\t    \t\t\t\t\t</script>\n\t    \t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar loc_type_value\t= parent.frames[1].document.forms[0].location0.value;\n\t\t\t\t\t\t\tvar ref_to_value\t= parent.frames[1].document.forms[0].referred_to.value;\n\t\t\t\t\t\t\tvar specialty_value\t= parent.frames[1].document.forms[0].speciality.value;\n\t\t\t\t\t\t\tvar service_value\t= parent.frames[1].document.forms[0].serv_code.value;\n\t\t\t\t\t\t\tvar HTMLValue = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'GetReferralVals.jsp?src1=2&jsp_val=discharge&loc_type=\"+loc_type_value+\"&ref_to=\"+ref_to_value+\"&specialty=\"+specialty_value+\"&service=\"+service_value+\"\'></form></BODY></HTML>\";\n\t\t\t\t\t\t\tparent.frames[2].document.write(HTMLValue);\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t\t\t\t</script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n        </head>\n    <body class=message onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n        <form name=\'dummyform\' id=\'dummyform\'>\n        </form>\n    </body>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</html>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			request.setCharacterEncoding("UTF-8"); 
            Connection con=null;
	        Statement stmt=null;
			Statement stmt_pract=null;
			Statement stmt_loc=null;
			Statement stmt_loc1=null;
            ResultSet rs=null;
			ResultSet rs_pract=null;
			ResultSet rs_speciality=null;
			ResultSet rs_loc=null;
			ResultSet rs_loc1=null;

            try{
            con = ConnectionManager.getConnection(request);

            String facility_id= (String) session.getValue( "facility_id" ) ;
            String ref_type=request.getParameter("ref_type");
            if(ref_type==null) ref_type="";
            
			String pract_id=request.getParameter("pract_id");
            if(pract_id==null) pract_id="";
	        String loc_type=request.getParameter("loc_type");
            if(loc_type==null) loc_type="";
            String ref_to=request.getParameter("ref_to");
            if(ref_to==null) ref_to="";
            String location1=request.getParameter("location1");
            if(location1==null) location1="";

            String sql="";
            String sql_loc="";
			StringBuffer sql_loc1 = new StringBuffer();
            String sql_pract="";
			String org_type="";
			String org_type_desc="";
            
            String referred_to_id=request.getParameter("referred_to_id");
            if(referred_to_id==null) referred_to_id="";
            String referred_to_desc=request.getParameter("referred_to_desc");
            if(referred_to_desc==null) referred_to_desc="";
            String loc0=request.getParameter("loc0");
            if(loc0==null) loc0="";
            String src1=request.getParameter("src1");
			if(src1 == null) src1 = "";
			String speciality_val = request.getParameter("speciality_val"); 
			if (speciality_val == null ) speciality_val = "";
            String specialty=request.getParameter("specialty");
			if (specialty == null ) specialty = "";
            String service=request.getParameter("service");
			if (service == null ) service = "";
            String jsp_val=request.getParameter("jsp_val");
			if (jsp_val == null ) jsp_val = "";

            String referredtoid="";
            String referredtodesc="";
            String hcare_setting_type_desc="";
            String hcare_setting_type="";
            String clinicid="";
            String clinicdesc="";
            String open_to_all_pract_yn="";

            String practitioner_id="";
            String practitioner_name="";

            int ip=0;
            int op=0;
            
			//added on 15-11-2003 by dhanasekaran
			sql="SELECT Nvl(org_type, ' ') as org_type FROM am_referral WHERE referral_code='"+referred_to_id+"'";

            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            
            if(rs.next())
            {
               org_type=rs.getString("org_type").trim();
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(ref_type.equals("X") && src1.equals("6"))
			{
				if(org_type.equals("G") || org_type.length() == 0 || org_type==null) org_type_desc="<b>Government</b>";
				if(org_type.equals("P")) org_type_desc="<b>Private</b>";
			}
			
			if(ref_type.equals("E") || ref_type.equals("L"))
			{
				org_type_desc="<b>Government</b>";
			}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(org_type_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
  		//end addition
		if(src1.equals("1"))
        {
			 String hcare_type_code = request.getParameter("hcare_type");
			 if(hcare_type_code==null) ref_type="";
			
            if(ref_type.equals("X"))
            {
				if (!hcare_type_code.equals(""))
				{
                sql="Select a.SHORT_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral a, am_hcare_setting_type b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_disch_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type='"+hcare_type_code+"' order by a.short_desc ";        
				}
				else
				{
                sql="Select a.SHORT_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral a, am_hcare_setting_type b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' order by a.short_desc ";        
				}
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs!=null)
            {
                while(rs.next())
                {
                    referredtoid			=	rs.getString("referred_to_id");
                    referredtodesc			=	rs.getString("referred_to_id_desc");
                    hcare_setting_type_desc	=	rs.getString("hcare_setting_type_desc");
                    hcare_setting_type		=	rs.getString("hcare_setting_type");
                
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(jsp_val));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(referred_to_id.equals(referredtoid) ) {
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);

                }
            }
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
            
            _bw.write(_wl_block14Bytes, _wl_block14);

            }
            else if(ref_type.equals("E") || ref_type.equals("L"))
            {
				if(ref_type.equals("E"))
				{
					if (!hcare_type_code.equals(""))
					{
                sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id != '"+facility_id+"' and  a.hcare_setting_type_code='"+hcare_type_code+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	
					}
					else
					{
                sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id != '"+facility_id+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	
					}
				}
				else if(ref_type.equals("L"))
				{
                sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id = '"+facility_id+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	
				}

				stmt=con.createStatement();
                rs=stmt.executeQuery(sql);
                if(rs!=null)
                {
                    while(rs.next())
                    {
                        referredtoid=rs.getString("referred_to_id");
                        referredtodesc=rs.getString("referred_to_id_desc");
                        hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
                        hcare_setting_type=rs.getString("hcare_setting_type_code");
                    
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(jsp_val));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(referred_to_id.equals(referredtoid) || ref_type.equals("L") || ref_type.equals("E")) {
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);

                    }
                }
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();

				sql_loc="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct           decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";
                stmt_loc=con.createStatement();
                rs_loc=stmt_loc.executeQuery(sql_loc);
                if(rs_loc!=null)
                {
                    if (rs_loc.next())
                    {
                        ip=rs_loc.getInt(1);
                        op=rs_loc.getInt(2);
                    }
                }
                        if (ip> 0 )
                        {
							if (ref_type.equals("L") && op > 0)
							{

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(jsp_val));
            _bw.write(_wl_block25Bytes, _wl_block25);
							}
                            else if (op > 0)
                            {
						
            _bw.write(_wl_block26Bytes, _wl_block26);

                            }
                    else
                            {

            _bw.write(_wl_block27Bytes, _wl_block27);

                            }
                        }
                        else
                        {       
                            if(op>0)
                            {
                            
            _bw.write(_wl_block28Bytes, _wl_block28);

                        }
                        else
                            {
                        
            _bw.write(_wl_block29Bytes, _wl_block29);

                            }
                        }
				 }
				 if (!jsp_val.equals(""))
				{
				 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(speciality_val));
            _bw.write(_wl_block31Bytes, _wl_block31);

				}
			}
            else if(src1.equals("2"))
            {
                    if(loc_type.equals("C"))
                    {
						if(sql_loc1.length() > 0) sql_loc1.delete(0,sql_loc1.length());
						sql_loc1.append("Select short_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic where facility_id = '"+ref_to+"'  and allow_visit_regn_yn = 'Y' and level_of_care_ind = 'A' and eff_status = 'E'  and speciality_code = '"+specialty+"' and service_code = nvl('"+service+"',service_code)");
                    }
                    else if (loc_type.equals("N"))
                    {
					  if(sql_loc1.length() > 0) sql_loc1.delete(0,sql_loc1.length());
                       sql_loc1.append("Select a.short_desc dat, a.nursing_unit_code id from ip_nursing_unit a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+ref_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"'and a.service_code = nvl('"+service+"',a.service_code) and a.appl_patient_class = 'IP' ");
                    }
                    else if (loc_type.equals("D"))
                    {
			           if(sql_loc1.length() > 0) sql_loc1.delete(0,sql_loc1.length());
                       sql_loc1.append("Select a.short_desc dat, a.nursing_unit_code id from ip_nursing_unit a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+ref_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"'and a.service_code = nvl('"+service+"',a.service_code) and a.appl_patient_class = 'DC' ");
                    }
                    sql_loc1.append(" order by 1");
                    stmt_loc1=con.createStatement();
                    rs_loc1=stmt_loc1.executeQuery(sql_loc1.toString());
                    if(rs_loc1!=null)
                    {
                        while(rs_loc1.next())
                        {
                            clinicdesc=rs_loc1.getString(1);
                            clinicid=rs_loc1.getString(2);
                            if(loc_type.equals("C"))
                            open_to_all_pract_yn=rs_loc1.getString(3);
                            else 
                            open_to_all_pract_yn="";
                            
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinicid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinicdesc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(jsp_val));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(location1.equals(clinicid) ) {
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block35Bytes, _wl_block35);

                        }
                    }
            }
            else if( src1.equals("3"))
            {
                if(loc_type.equals("C"))
                {
                    if (open_to_all_pract_yn.equals("Y"))
                    {
                        sql_pract="Select practitioner_id, practitioner_name from am_practitioner where practitioner_id in (Select practitioner_id from am_pract_for_facility where facility_id = '"+ref_to+"' and eff_status = 'E' ) and eff_status = 'E' order by practitioner_name ";
                    }
                    else
                    {
                        sql_pract="Select practitioner_id, practitioner_name from am_practitioner where practitioner_id in (Select practitioner_id from op_pract_for_clinic where facility_id = '"+ref_to+"' and clinic_code = '"+location1+"' and eff_status = 'E' ) and eff_status = 'E' ";
                    }
                }          
            else if(loc_type.equals("N"))
                {
                    sql_pract="Select practitioner_id, practitioner_name from am_practitioner where practitioner_id in (Select practitioner_id from ip_nursing_unit_for_pract where facility_id =  '"+ref_to+"'  and nursing_unit_code =  '"+location1+"' and eff_status = 'E' ) ";
                }

                stmt_pract=con.createStatement();
                rs_pract=stmt_pract.executeQuery(sql_pract);

                if(rs_pract!=null)
                {
                    while(rs_pract.next())
                    {
                        practitioner_id=rs_pract.getString(1);
                        if(practitioner_id==null) practitioner_id="";
                        practitioner_name=rs_pract.getString(2);
                        if(practitioner_name==null) practitioner_name="";
                        
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(pract_id.equals(practitioner_id) ) {
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);

                    }
                }
            }
			if( src1.equals("4")) 
			{
	       		    String speciality_code = request.getParameter("speciality");
	    			StringBuffer sql_service = new StringBuffer();
	    			sql_service.append("Select Distinct A.Service_Code service_code, B.Short_Desc  short_desc from Op_Clinic A, Am_Service B where A.Speciality_Code = '"+speciality_code+"' and A.Facility_Id = '"+facility_id+"'and A.Service_Code = B.Service_Code ");
					String ip_install_yn="";
					String ip_install = "select install_yn from sm_module where module_id = 'IP'";
	                stmt_pract=con.createStatement();
					rs_speciality=stmt_pract.executeQuery(ip_install);
	    			while ( rs_speciality!=null&&rs_speciality.next() )			 ip_install_yn=rs_speciality.getString(1);
                    if (ip_install_yn.equals("Y"))
					{
                    sql_service.append(" union Select Distinct A.Service_Code service_code, B.Short_Desc  short_desc from ip_nursing_unit A, am_service B, ip_nurs_unit_for_specialty c  where a.nursing_unit_code = c.nursing_unit_code and c.specialty_code= '"+speciality_code+"' and A.Facility_Id = '"+facility_id+"'and A.Service_Code = B.Service_Code ");
					}
					sql_service.append(" order by 2 ");
	                rs_speciality=stmt_pract.executeQuery(sql_service.toString());

	    			while ( rs_speciality.next() )
	    			{	
	    				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs_speciality.getString("Service_code")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rs_speciality.getString("short_desc")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rs_speciality.getString("Service_code")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(jsp_val));
            _bw.write(_wl_block43Bytes, _wl_block43);

	    			}
					if (!(jsp_val.equals("")))
					{
				
            _bw.write(_wl_block44Bytes, _wl_block44);

					}			
				}


            _bw.write(_wl_block45Bytes, _wl_block45);

}catch(Exception e){out.println(e);}
            finally { 
    ConnectionManager.returnConnection(con,request);
	if(stmt!=null) stmt.close();
	if(stmt_pract!=null) stmt_pract.close();
	if(rs!=null) rs.close();
	if(rs_pract!=null) rs_pract.close();
	if(rs_speciality!=null) rs_speciality.close();
	if(stmt_loc!= null) stmt_loc.close();
	if(stmt_loc1!= null) stmt_loc1.close();
	if(rs_loc!=null) rs_loc.close();
	if(rs_loc1!=null) rs_loc1.close();
}

            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
