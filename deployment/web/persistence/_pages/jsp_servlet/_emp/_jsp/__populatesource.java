package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __populatesource extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PopulateSource.jsp", 1733483617205L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n/*<!--\n   \t\t Developed By  :- M.F.Mohamed Ali Suhail\n   \t\t Function      :-  Referral Search (To search a referral id)\n-->*/\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t\n    \n\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<BODY class=\'Message\' onKeyDown = \'lockKey();\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script>\t\n\t\t//var opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t//opt.text=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t//opt.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t   // if(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"==\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")\n\t\t//  opt.selected = true;\n\t\t if (\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"==\"L\"){\n\t\t //opt.selected = true;\n\t\t //parent.f_query_add_mod.document.forms[0].source.add(opt);\n\t\t//parent.f_query_add_mod.document.forms[0].health_care_setting_type.value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\nparent.f_query_add_mod.document.forms[0].source_display.value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\nparent.f_query_add_mod.document.forms[0].source_display.disabled=true;\nparent.f_query_add_mod.document.forms[0].source.value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\nparent.f_query_add_mod.document.forms[0].referral_source_lkp_but.disabled=true;\n\t\t }\n\n\n\t</script>\t\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t </script>\n\t  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t  <script>\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t        opt.text=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t        opt.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].referred_from_location_type.add(opt);\n\t          </script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<script>\t\t\t\n\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\topt.value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n    \tif(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\")\n\t\t\topt.selected = true;\n\t\t\tparent.f_query_add_mod.document.forms[0].referred_from_location.add(opt);\n\t\t\t</script>\t\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<script>\t\t\t\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\")\n\t\t\t\t\t  opt.selected = true;\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].referred_to_location.add(opt);\n\t\t\t\t</script>\t\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n- \t<script>\t\t\t\n/*\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\")\n\t\t  opt.selected = true;\n\t\tparent.f_query_add_mod.document.forms[0].fm_service_code.add(opt);*/\n\t</script>\t\n \t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<script>\t\t\t\n\t/*\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\")\n\t\t  opt.selected = true;\n\t\tparent.f_query_add_mod.document.forms[0].to_service_code.add(opt);*/\n\t</script>\t\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t/* var opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';  \n\t\t\t\t\topt.value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].to_service_code.add(opt);*/\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t \t<script>\n\t\t\t\t\t/* var opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].fm_service_code.add(opt);*/\n\t\t\t\t\t</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<script>\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].open_to_all_pract_yn1.value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\t\t</script>\n\t\t\t\t ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<script>\n\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\tparent.f_query_add_mod.document.forms[0].referred_to_location.add(opt);\n\t parent.f_query_add_mod.document.forms[0].open_to_all_pract_yn.value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\n\t</script>\t\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].referred_from_location_type.add(opt);\n\t             \n\t\t\t  </script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\treferral_id = \'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\n\t\t\t\t\t\t\tvar arguments = \"\";\n\t\t\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\t\t\tvar dialogHeight= \"41\";\n\t\t\t\t\t\t\tvar dialogWidth = \"65\";\n\t\t\t\t\t\t\tvar dialogTop\t= \"72\";\n\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ; dialogTop:\" + dialogTop + \" ; scroll=no; status:\" + status ;\n\t\t\t\t\t\t\tvar retVal = window.showModalDialog(\"../../eIP/jsp/Booking.jsp?home_required_yn=N&referral_id=\"+referral_id+\"&function_type=F&access=NYNNN&call_func=OP_Pending_Referral_Booking\",arguments,features);\t\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tvar resourceId  = \'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\t\t\t\t\t\t\tvar referral_id = \'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\t\t\t\t\t\t\tvar patient_id = \'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';\n\t\t\t\t\t\t\t\t\t\tvar careLocnTypeInd = \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\';\n\t\t\t\t\t\t\t\t\t\tvar speciality = \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\';\n\t\t\t\t\t\t\t\t\t\tvar callingMode = \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\';\n\t\t\t\t\t\t\t\t\t\tvar preferDate = \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\';\n\t\t\t\t\t\t\t\t\t\tvar clinicCode = \'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\';\n\t\t\t\t\t\t\t\t\t\tvar clinicDesc = \'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\';\n\t\t\t\t\t\t\t\t\t\tvar resourceDesc = \'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\';\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tvar qryStr = \"../../eOA/jsp/CAOAAppointment.jsp?referral_id=\"+referral_id+\"&i_practitioner_id=\"+resourceId+\"&patient_id=\"+patient_id+\"&i_clinic_code=\"+clinicCode+\"&recall_date=&locn_type=\"+careLocnTypeInd+\"&specialty_code=\"+speciality+\"&callingMode=\"+callingMode+\"&from_page=Pending_referral&waitListNo=&resource_class=&clinic_code=\"+clinicCode+\"&from_OR=N&from_AE=N&care_locn_ind=\"+careLocnTypeInd+\"&recall_date=\"+preferDate+\"&resourceDesc=\"+resourceDesc+\"&clinicDesc=\"+clinicDesc;\n\t\t\t\t\t\t\t\t\t\tparent.parent.location.href =qryStr;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<script>alert(parent.frames[1].getMessage(\'MISMATCH_PRIM_RES\',\'OA\'));</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="<script>\t\t\t\t\t\n\t\t\t\t//parent.window.returnValue=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\';\n\t\t\t\t//parent.window.close();\t\t\t\t\n\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\tdialogBody.contentWindow.returnValue = \'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\';   \n\t\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\t\tdialogTag.close(); \t\n\t\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);

    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
	
            _bw.write(_wl_block6Bytes, _wl_block6);

	  Connection con 				= null;
	try
	 {
		con 						=  ConnectionManager.getConnection(request);
		Statement stmt 				= con.createStatement();
		ResultSet rs 				= null;
		String user_id				= (String) session.getValue("login_user") ;
		String facilityid			= (String)session.getValue("facility_id");
		String source_type			= request.getParameter("source_type");
		source_type 				= (source_type == null)?"":source_type;
		String source				= request.getParameter("source");
		source 						= (source == null)?"":source;
	  
		String referred_from_location_type	= request.getParameter("referred_from_location_type");
		referred_from_location_type 		= (referred_from_location_type == null)?"":referred_from_location_type;
		String referred_to_location_type	= request.getParameter("referred_to_location_type");
		referred_to_location_type 		= (referred_to_location_type == null)?"":referred_to_location_type;

        String reffrom_locn_type="";
		String refto_locn_type="";
		  if(referred_from_location_type.equals("D"))
			    reffrom_locn_type="Y";
		    else
				reffrom_locn_type=referred_from_location_type;

        if(referred_to_location_type.equals("D"))
			    refto_locn_type="Y";
		    else
				refto_locn_type=referred_to_location_type;

		String list					= request.getParameter("List");
		list 						= (list == null)?"":list;
	
		String ref_from_location	= request.getParameter("referred_from_location");
		ref_from_location 			= (ref_from_location == null)?"":ref_from_location;
		String ref_to_location_type = request.getParameter("referred_to_location_type");
		ref_to_location_type 		= (ref_to_location_type == null)?"":ref_to_location_type;
		String ref_to_location		= request.getParameter("ref_to_location");
		ref_to_location 			= (ref_to_location == null)?"":ref_to_location;
		
		String fm_speciality_code	= request.getParameter("fm_speciality_code");
		String to_speciality_code	= request.getParameter("to_speciality_code");
		fm_speciality_code 			= (ref_to_location == null)?"":fm_speciality_code;      
		String tolocncode = request.getParameter("tolocncode");
		String preferDate = request.getParameter("preferDate");
		String callingMode = request.getParameter("callingMode");
		String speciality = request.getParameter("speciality");
		String careLocnTypeInd = request.getParameter("careLocnTypeInd");
		String patient_id = request.getParameter("patient_id");
		String resourceId = request.getParameter("resourceId")==null?"":request.getParameter("resourceId");		
		String to_locn_desc = request.getParameter("to_locn_desc")==null?"":request.getParameter("to_locn_desc");		
		String resourcedesc = request.getParameter("resourcedesc")==null?"":request.getParameter("resourcedesc");		
		

		String p_calling_function = request.getParameter("p_calling_function");
		String referralId = request.getParameter("referralId");
		String loc_type = request.getParameter("loc_type");
		referralId 			= (referralId == null)?"":referralId;
		tolocncode 			= (tolocncode == null)?"":tolocncode;
		loc_type 			= (loc_type == null)?"":loc_type;
	
		p_calling_function 			= (p_calling_function == null)?"":p_calling_function;
		String pCallingFunction		= request.getParameter("p_calling_function");
		pCallingFunction 			= (pCallingFunction == null)?"":pCallingFunction;		
		
        String lcare="";
		if(pCallingFunction.equals("OP_REG_VISIT"))
			lcare=" and level_of_care_ind='A' ";
		else if(pCallingFunction.equals("AE_REGISTER_ATTN"))
			lcare=" and level_of_care_ind='E' ";
		else if(pCallingFunction.equals("IP_BOOKING")||pCallingFunction.equals("IP_ADMIT")||pCallingFunction.equals("OA_BOOK_APPT"))
			lcare=" and level_of_care_ind in ('A','E') ";

        String svalue=request.getParameter("svalue");
		  svalue=(svalue==null)?"":svalue;
		
        String open_to_all_pract_yn = request.getParameter("open_to_all_pract_yn");
		open_to_all_pract_yn 		= (open_to_all_pract_yn == null)?"":open_to_all_pract_yn;

		String p_from_ref_code	    = request.getParameter("p_from_ref_code");
	    p_from_ref_code 		    = (p_from_ref_code == null)?"":p_from_ref_code;
		String p_from_locn_code	    = request.getParameter("p_from_locn_code");
	    p_from_locn_code 		    = (p_from_locn_code == null)?"":p_from_locn_code;
		String p_from_pract_id	    = request.getParameter("p_from_pract_id");
	    p_from_pract_id 		    = (p_from_pract_id == null)?"":p_from_pract_id;

		String p_to_locn_code	    = request.getParameter("p_to_locn_code");
	    p_to_locn_code 			    = (p_to_locn_code == null)?"":p_to_locn_code;
		String p_to_pract_id	    = request.getParameter("p_to_pract_id");
	    p_to_pract_id 			    = (p_to_pract_id == null)?"":p_to_pract_id;

		String care_ind = request.getParameter("care_ind");
		if(care_ind == null) care_ind="";	
		
	
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try{
	       String source_desc 		= "";
	       String referral_code		= "";
	       String health_care_type	= "";
	     
		   String short_desc		= "";
		   String location_code		= "";
		
		   String ser_code="";
		   String ser_desc="";
           String sql2="";
		   String locntype_desc="";
		   String locntype_code="";
		   StringBuffer sql = new StringBuffer();
       	  

	  if(list!=null && list.equalsIgnoreCase("SOURCE"))
		     {
	         if(source_type!=null && source_type.equalsIgnoreCase("X"))
		        {
				  sql.append(" select a.healthcare_setting_type, a.referral_code, b.short_desc health_care_type_desc,a.long_desc source_desc from AM_REFERRAL_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW  b ");
				  sql.append(" where a.healthcare_setting_type = b.hcare_setting_type_code and a.eff_status='E' and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.short_desc");
			    }	
			   else if (source_type.equalsIgnoreCase("E"))
			   {  
					sql.append(" select  a.facility_id,substr(a.facility_name,1,25) FACILITY_NAME, 'X', b.short_desc hcare_setting_type_desc from sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code = b.hcare_setting_type_code and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name");
			    }  
			   else if (source_type.equalsIgnoreCase("L"))
			   {  
			    	sql.append(" select substr(a.facility_name,1,25) FACILITY_NAME, a.facility_id, 'X', b.short_desc hcare_setting_type_desc from sm_facility_param_lang_vw a,  am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code = b.hcare_setting_type_code and a.facility_id = '"+facilityid+"' and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name" );
				

				} 
			 
			  rs = stmt.executeQuery(sql.toString());	
	
            _bw.write(_wl_block9Bytes, _wl_block9);
	while(rs!=null && rs.next()){		
		
			source_desc    = rs.getString(1);
			referral_code  = rs.getString(2);
			health_care_type    = rs.getString(3);		
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(source_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(referral_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_from_ref_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(referral_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(health_care_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(source_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(referral_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
	   } //End of while	

	if(rs != null) rs.close();

	sql.setLength(0);
	
            _bw.write(_wl_block19Bytes, _wl_block19);

	   // }
		  if(rs != null) rs.close();
		    
	       try{
           
		    String locnsql="";
           if(source_type.equals("L")){  
		
			locnsql="select short_desc,locn_type,care_locn_type_ind from am_care_locn_type_lang_vw  where care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc";
		
		 rs=stmt.executeQuery(locnsql);
		 if(rs != null)
			{
			   while(rs.next())
				{
				   locntype_desc=rs.getString(1);
				   locntype_code=rs.getString(2);
                   
				  
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locntype_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntype_code));
            _bw.write(_wl_block22Bytes, _wl_block22);


				}
			}
		
		if(rs != null) rs.close();
           }

		}catch(Exception e){e.printStackTrace();}
		 
	  }  // end of list source
		else if(list!=null && list.equalsIgnoreCase("FROM_LOCATION"))
		{
		        if(referred_from_location_type!=null && !(referred_from_location_type.equalsIgnoreCase("N")))
		        {
				   
				  if(to_speciality_code.equals("")){ 
				   sql.append(" select long_desc short_desc,clinic_code from op_clinic_lang_vw  where facility_id='"+source+"' and eff_status='E' "+lcare+" and clinic_type='"+reffrom_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }else{
				sql.append(" select long_desc short_desc,clinic_code from op_clinic_lang_vw where facility_id='"+source+"' and eff_status='E' "+lcare+" and Speciality_Code='"+to_speciality_code+"' and clinic_type='"+reffrom_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }
				
				}	
			   else if (referred_from_location_type.equalsIgnoreCase("N"))
			   {  
			       if(to_speciality_code.equals("")){ 
				   sql .append(" SELECT long_desc short_desc, NURSING_UNIT_CODE FROM ip_nursing_unit_lang_vw WHERE FACILITY_ID ='"+source+"' and language_id='"+locale+"' order by short_desc" );
				   }else{
					   sql.append("SELECT ip_get_desc.ip_nursing_unit('"+source+"', nursing_unit_code, '"+locale+"', 1) short_desc, NURSING_UNIT_CODE FROM ip_nurs_unit_for_specialty WHERE FACILITY_ID ='"+source+"' and SPECIALTY_CODE='"+to_speciality_code+"' order by short_desc"); 
				   }
			    }  
	      rs = stmt.executeQuery(sql.toString());		
	
            _bw.write(_wl_block9Bytes, _wl_block9);
	while(rs!=null && rs.next()){		
			short_desc    = rs.getString(1);
			location_code  = rs.getString(2);
	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_from_locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
	   } //End of while	
			if(rs != null) rs.close();

			sql.setLength(0);
	    }  // end of list location
		else if(list!=null && list.equalsIgnoreCase("TO_LOCATION"))
		     {
		        if(referred_to_location_type!=null && !(referred_to_location_type.equalsIgnoreCase("N")))
		        {
				   sql.append(" select long_desc short_desc,clinic_code from op_clinic_lang_vw where facility_id='"+source+"' and eff_status='E' "+lcare+"  and clinic_type='"+referred_to_location_type+"' and language_id='"+locale+"' order by short_desc" );
			    }	
			   else if (referred_to_location_type.equalsIgnoreCase("N"))
			   {  
			       sql.append(" select long_desc short_desc,nursing_unit_code from ip_nursing_unit_lang_vw  where facility_id='"+source+"' and eff_status='E' and language_id='"+locale+"' order by short_desc" );
			    }  
//		      out.println(sql);	   
		      rs = stmt.executeQuery(sql.toString());		
				
            _bw.write(_wl_block27Bytes, _wl_block27);
	while(rs!=null && rs.next()){		
						short_desc    = rs.getString(1);
						location_code  = rs.getString(2);
						//out.println("short_desc 273============"+short_desc);
						//out.println("location_code 274============"+location_code);
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_to_locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
	   } //End of while		
				if(rs != null) rs.close();

				sql.setLength(0);
				}  // end of list location
	else if(list!=null && list.equalsIgnoreCase("FM_SPECILITY_CODE"))
		{
			 sql.append(" Select service_Code service_code, Short_Desc  short_desc from  Am_Service_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by 2" );
 
		     rs = stmt.executeQuery(sql.toString());		
		     while(rs!=null && rs.next()){		
			 location_code   = rs.getString(1);
			 short_desc      = rs.getString(2);
	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_from_locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
	   
		} //End of while		
	if(rs != null) rs.close();
	
    sql.setLength(0);
	    }  // end of list location

	else if(list!=null && list.equalsIgnoreCase("TO_SPECILITY_CODE"))
		{
			 sql.append(" Select Service_Code service_code, Short_Desc  short_desc from Am_Service_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by 2" );

		     rs = stmt.executeQuery(sql.toString());		
		     while(rs!=null && rs.next()){		
			 location_code   = rs.getString(1);
			 short_desc      = rs.getString(2);
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_from_locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
	   } //End of while	
	if(rs != null) rs.close();

	sql.setLength(0);

	    }  // end of list location
	
		else if(list!=null && list.equalsIgnoreCase("PRACTITIONER"))
		     {
				
				 if(source_type.equals("L")||source_type.equals("E")||svalue.equals("toService"))
				 {
                   if(referred_from_location_type.equals("C"))
					 {
					 sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from op_clinic a where a.clinic_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"' and a.clinic_code = '"+ref_from_location+"' ) order by short_desc");
					 }
					else if(referred_from_location_type.equals("E"))
					 {
					   sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from op_clinic a where  a.clinic_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"'  and a.clinic_code = '"+ref_from_location+"' ) order by short_desc" );
				     }
					 else if(referred_from_location_type.equals("Y"))
					 {
						 sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from op_clinic a where  a.clinic_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"'  and a.clinic_code = '"+ref_from_location+"' ) order by short_desc");
					 }
					 else if(referred_from_location_type.equals("N"))
						 {

						 sql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+ref_from_location+"' and a.facility_id='"+facilityid+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"'and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+ref_from_location+"') order by short_desc");
					    }
					  else if(referred_from_location_type.equals("W"))
					 {
						  sql.append("SELECT distinct C.SERVICE_CODE service_code,D.SHORT_DESC short_desc FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE_lang_vw D WHERE   A.OPERATING_FACILITY_ID='"+facilityid+"' AND A.WING_CODE = NVL('"+ref_from_location+"',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND language_id='"+locale+"' and B.INT_OR_EXT = 'I'");
					 }
					 
					 if(ref_from_location.equals("")){
						 sql.setLength(0);
						 if(referred_from_location_type.equals("W"))
						{
						  sql.append("SELECT  WING_CODE,SHORT_DESC FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+facilityid+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL");
						}
						else
							{
						 sql.append("select a.service_code, b.short_desc from am_facility_service a, am_service_lang_vw b where a.operating_facility_id='"+facilityid+"' and a.service_code=b.service_code and b.language_id='"+locale+"' order by short_desc");
							}

					}
					 
				    if(!ref_from_location.equals("")){
					if(!referred_from_location_type.equals("N")){
					   sql2="select OPEN_TO_ALL_PRACT_YN  from op_clinic where clinic_code='"+ref_from_location+"' and facility_id='"+facilityid+"'";
						}
					}
				 
				 }
				 
				   rs = stmt.executeQuery(sql.toString());
				while(rs!=null && rs.next())
				 {
					ser_code=rs.getString(1);
					ser_desc=rs.getString(2);
					if(svalue.equals("toService"))
					 {
					
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ser_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ser_code));
            _bw.write(_wl_block38Bytes, _wl_block38);

					}else if(svalue.equals("")){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ser_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ser_code));
            _bw.write(_wl_block40Bytes, _wl_block40);

					}
				}

				if(rs != null) rs.close();

				sql.setLength(0);
				 if(!ref_from_location.equals("")){
					if(!referred_from_location_type.equals("N")){
				rs = stmt.executeQuery(sql2);
				if(rs.next())
				 {
					open_to_all_pract_yn=rs.getString(1);
					
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
					if(rs != null) rs.close();
					}}
	    }  // end of list practitioner

        
		 else if(list!=null && list.equalsIgnoreCase("REF_TO_LOCATION"))  // for referred to 
		     {
				 if(ref_to_location_type!=null && !(ref_to_location_type.equalsIgnoreCase("N")))
				 {
				    if(pCallingFunction.equals("INDEPENDENT"))
				    {
				      if(to_speciality_code.equals("")){ 
				       
					   sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw  where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and clinic_type='"+refto_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }else{
				       sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and Speciality_Code='"+to_speciality_code+"' and clinic_type='"+refto_locn_type+"' and language_id='"+locale+"' order by short_desc" );
				  }
			    
			       }
				    else
				    {
						 if(to_speciality_code.equals("")){  
						sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw  where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and language_id='"+locale+"' order by short_desc" );
                       }else{
										
							sql.append(" select long_desc short_desc,clinic_code,open_to_all_pract_yn from op_clinic_lang_vw  where facility_id='"+facilityid+"' and eff_status='E' "+lcare+" and Speciality_Code='"+to_speciality_code+"' and language_id='"+locale+"' order by short_desc" );
						
							}
					   }

	                   
					}
				else if(ref_to_location_type!=null && ref_to_location_type.equalsIgnoreCase("N"))
				 {
				    if(pCallingFunction.equals("INDEPENDENT"))
				    {
					// no operator station check
		              		 if(to_speciality_code.equals("")){ 
				   sql.append(" SELECT long_desc short_desc, NURSING_UNIT_CODE FROM ip_nursing_unit_lang_vw WHERE FACILITY_ID ='"+facilityid+"' and language_id='"+locale+"' order by short_desc" );
				   }else{
					   sql.append("SELECT ip_get_desc.ip_nursing_unit('"+facilityid+"', nursing_unit_code, '"+locale+"', 1) short_desc, NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SPECIALTY WHERE FACILITY_ID ='"+facilityid+"' and SPECIALTY_CODE='"+to_speciality_code+"' order by short_desc"); 
				    }
				    }
				    else
				    {
						if(to_speciality_code.equals("")){  
							sql.append("select long_desc short_desc, nursing_unit_code from ip_nursing_unit_lang_vw where facility_id='"+facilityid+"' and eff_status = 'E' and language_id='"+locale+"' order by short_desc" );							
							}else{
							sql.append("select ip_get_desc.ip_nursing_unit('"+facilityid+"', nursing_unit_code, '"+locale+"', 1) short_desc, nursing_unit_code from IP_NURS_UNIT_FOR_SPECIALTY where facility_id='"+facilityid+"' and SPECIALTY_CODE='"+to_speciality_code+"' order by short_desc");
						}
					     
					}
				
				 }

				 if(ref_to_location_type.equals("W"))
				 {
					 sql.setLength(0);
	
					 sql.append("SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+facilityid+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL");
				 }
			 
		      rs = stmt.executeQuery(sql.toString());		
	
            _bw.write(_wl_block9Bytes, _wl_block9);
	while(rs!=null && rs.next()){		
		 if(ref_to_location_type!=null && !(ref_to_location_type.equalsIgnoreCase("N")))
		  {
			short_desc			 = rs.getString(1);
			location_code		 = rs.getString(2);
			open_to_all_pract_yn = rs.getString(3);
          }
		  else if(ref_to_location_type!=null && ref_to_location_type.equalsIgnoreCase("N"))
		  {
  		    short_desc			 = rs.getString(1);
			location_code		 = rs.getString(2);
          }
	
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
	   } //End of while	
	if(rs != null) rs.close();

	sql.setLength(0);
	    }  // end of list ref_to_location
   else if(list!=null && list.equalsIgnoreCase("Location_Populate"))
		{
            
    	 String locnsql="";
       
		locnsql="select short_desc, locn_type from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') and  SYS_USER_DEF_IND='S' and and language_id='"+locale+"' order by short_desc";
		rs=stmt.executeQuery(locnsql);
		if(rs != null)
			{
			   while(rs.next())
				{
				   locntype_desc=rs.getString(1);
				   locntype_code=rs.getString(2);
                        
				  
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locntype_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntype_code));
            _bw.write(_wl_block46Bytes, _wl_block46);


				}
			}
		
		if(rs != null) rs.close();
		} else if(list!=null && list.equalsIgnoreCase("OPER_STN_ACCESS_CHECK")) {
			// This block is added by Suresh M for PE to check for Operator Station Access in Referal Search Result.
			//String sqlQuery = "";
			StringBuffer sqlQuery = new StringBuffer();
			String OsVal = "";
			String OsVal1 = "";
			String functionAccess = "";
			String primary_resource_class="";
			String locntype = "";

			boolean prim_res_check=true;
			
			if(p_calling_function.equals("OP_REG_VISIT"))
				functionAccess = "REGISTER_VISIT_YN";
			else if(p_calling_function.equals("REV_VISIT_DTLS"))
					functionAccess = "REVISE_VISIT_YN";
			else if(p_calling_function.equals("OA_BOOK_APPT") || p_calling_function.equals("OA_MODIFY_APPT"))
				functionAccess = "BOOK_APPT_YN";
			else if(p_calling_function.equals("OA_PENDING_REFERRAL_BOOKING"))
				functionAccess = "BOOK_APPT_YN";
			else if(p_calling_function.equals("IP_BOOKING"))
				functionAccess = "CREATE_BOOKING_YN";
			else if(p_calling_function.equals("IP_ADMIT"))
				functionAccess = "ADMIT_PAT_YN";
			else if(p_calling_function.equals("CHG_ADM_DTLS"))
				functionAccess = "REVISE_ADMISSION_YN";
			else if(p_calling_function.equals("IP_PENDING_REFERRAL_BOOKING"))
				functionAccess = "CREATE_BOOKING_YN";			
			else if(p_calling_function.equals("AE_REGISTER_ATTN"))
				functionAccess = "REGISTER_VISIT_YN";
			else if(p_calling_function.equals("CHG_REG_DTLS"))
				functionAccess = "REVISE_VISIT_YN";			

			 
			if(!functionAccess.equals("")){				
				if(functionAccess.equals("CREATE_BOOKING_YN") || functionAccess.equals("ADMIT_PAT_YN") || functionAccess.equals("REVISE_ADMISSION_YN") ) {
					locntype = "N";
				} else {
					locntype = "X";
				}

				sqlQuery.append("Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+user_id+"','"+locntype+"','"+tolocncode+"','"+functionAccess+"') OsVal,(select primary_resource_class from op_clinic WHERE facility_id='"+facilityid+"' and clinic_code='"+tolocncode+"') primary_resource_class");
				if(p_calling_function.equals("IP_BOOKING")){					sqlQuery.append(",AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+user_id+"','"+locntype+"','"+tolocncode+"','CREATE_BOOKING_WITH_CONF_YN') OsVal1");
				}				
				sqlQuery.append("  FROM DUAL");
			
				rs=stmt.executeQuery(sqlQuery.toString());
				if(rs != null && rs.next())
				{
					OsVal = rs.getString("OsVal");
					if(p_calling_function.equals("IP_BOOKING")){	
						OsVal1 = rs.getString("OsVal1");
						if((OsVal.equals("1")) || (OsVal.equals("2")) || (OsVal.equals("3")) || (OsVal.equals("4")) || (OsVal.equals("5"))){
							OsVal = OsVal1;
						}
					}					
					primary_resource_class=rs.getString("primary_resource_class")==null?"":rs.getString("primary_resource_class");					
				}				
			}		
		
			if(OsVal.equals("1"))
			 {
			 out.print(" <script>alert(parent.frames[1].getMessage('VISIT_REGN_NOT_ALL_OPERSTN','OP'));</script>");
			}else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(parent.frames[1].getMessage('NO_CLINICS_FOR_USER','Common'));</script>");
			}else  if(OsVal.equals("3"))
			{
			 out.print(" <script>alert(parent.frames[1].getMessage('OPER_STN_RESTRN','OP'));</script>");			
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(parent.frames[1].getMessage('INVALD_USER_FCY','OP'));</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(parent.frames[1].getMessage('INVALID_OPER_STN_ACCESS','Common'));</script>");
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {	
			  if(p_calling_function.equals("IP_PENDING_REFERRAL_BOOKING") || p_calling_function.equals("OA_PENDING_REFERRAL_BOOKING")) {
					if(loc_type.equals("N"))
						{ 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(referralId));
            _bw.write(_wl_block48Bytes, _wl_block48);

						} else if(!loc_type.equals("N")){
								//Added some additional parameters by S.Sathish for IN021901 on Friday, June 11, 2010 
								if(!primary_resource_class.equals("P") && !resourceId.equals("")){
									prim_res_check=false;
								}							
								if(prim_res_check){
								
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(resourceId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(referralId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(careLocnTypeInd));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(preferDate));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(tolocncode));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(to_locn_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(resourcedesc));
            _bw.write(_wl_block59Bytes, _wl_block59);
} else {
            _bw.write(_wl_block60Bytes, _wl_block60);
}
				}} else {
			
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(referralId));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(referralId));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
		} 	
		}
 	out.println("</form></body></html>");	
	   }   catch(Exception e)
	 	    { e.toString();e.printStackTrace();   }
	       finally {
	 	         try{
		               if(rs!=null)  rs.close(); 
					   if(stmt!=null) stmt.close(); 
		            }
		         catch(Exception e)
		           { e.toString(); e.printStackTrace();  } 
		       }
			out.println("</form></body></html>");	
			} catch(Exception e){e.printStackTrace();}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
			
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
