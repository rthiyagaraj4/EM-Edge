package jsp_servlet._emr._jsp;

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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;

public final class __repwehuadrequestresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repWEHUADRequestResult.jsp", 1709119084504L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<head>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\n\t<script src=\'../../eMR/js/MRReports.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\n<form name=\'MedRecRequestResult\' id=\'MedRecRequestResult\'  action=\"../../eMR/jsp/repWEHUADRequestResult.jsp\" method=\"post\"  >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n\t\t\n\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t\t<br><br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<th align=\'center\' nowrap>&nbsp;</th>\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t</table>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\n\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t<input type=\'hidden\' name=\'PatientId\' id=\'PatientId\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type=\'hidden\' name=\'temp1\' id=\'temp1\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\n\t<input type=\'hidden\' name=\'lstPatientClass\' id=\'lstPatientClass\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_exp_date\' id=\'alt_id1_exp_date\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_exp_date\' id=\'alt_id2_exp_date\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\n\n\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_no\' id=\'alt_id1_no\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_no\' id=\'alt_id2_no\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\'hidden\' name=\'alt_id3_no\' id=\'alt_id3_no\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t<input type=\'hidden\' name=\'alt_id4_no\' id=\'alt_id4_no\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_type\' id=\'other_alt_type\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_Id\' id=\'other_alt_Id\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t<input type=\'hidden\' name=\"hddEncID\" id=\"hddEncID\" value=\"\">\n\t<input type=\'hidden\' name=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\'hidden\' name=\"p_encounter_id\" id=\"p_encounter_id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\'hidden\' name=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\n\n\t<br><center>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</center>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String classValue	 = "";
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	String jsp_name =request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");	
	String temp1="";

	String finalSelect	= request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";

	String Enc_Type	= request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");

	String orderBy	= request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	if(orderBy == null || orderBy.equals("ET")) 
		orderBy = "encounter_type, a.visit_adm_date_time desc";
	else if(orderBy.equals("ED")) 
		orderBy = "a.visit_adm_date_time desc";

	String alt_id1_exp_date	= request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");
	if(alt_id1_exp_date == null) alt_id1_exp_date="";

	String alt_id2_exp_date	= request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");
	if(alt_id2_exp_date == null) alt_id2_exp_date="";
	
	String national_id_no	= request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");
	if(national_id_no == null) national_id_no="";

	String alt_id1_no	= request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
	if(alt_id1_no == null) alt_id1_no="";
	
	String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
	if(alt_id2_no == null) alt_id2_no="";
	
	String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");
	if(alt_id3_no == null) alt_id3_no="";
	
	String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no");
	if(alt_id4_no == null) alt_id4_no="";

	String other_alt_type	=request.getParameter("other_alt_type")==null?"":request.getParameter("other_alt_type");
	if(other_alt_type == null) other_alt_type="";
	String other_alt_Id		=request.getParameter("other_alt_Id")==null?"":request.getParameter("other_alt_Id");
	if(other_alt_Id == null) other_alt_Id="";

	temp1=request.getParameter("temp1")==null?"":request.getParameter("temp1");
	if(temp1 == null) temp1="";

	String flag	=	"";
	flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");

	String  req_start   =   "", req_end     =   "";

    req_start =	(request.getParameter("from")==null)   ?   "0" :   request.getParameter("from");
    req_end   =	(request.getParameter("to")==null)     ?   "0" :   request.getParameter("to");

	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";
	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";
	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";
	String modal=request.getParameter("modal");
	if(modal == null) modal="";
	String module=request.getParameter("module");
	if(module == null) module="";
	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";
	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";
	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";

	String sql = "";
	String PatientId		=	request.getParameter("PatientId") ;
	if(PatientId	== null || PatientId.equals("null"))		
		PatientId = "";		
	
	String EncounterId		=	request.getParameter("p_encounter_id") ;
	if(EncounterId	== null || EncounterId.equals("null"))		
		EncounterId = "";

	String whereClause = request.getParameter("whereclause");
	if(whereClause	== null || whereClause.equals("null"))	
	{
		whereClause= "";
	}
	else
	{
		sql = whereClause;
	}

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	int start = 0 ;
	int end = 0 ;
    int i=1;


	if ( from == null )
		start = 1 ;
	else
	{
		if(from.equals(""))start=1;
		else
		start = Integer.parseInt( from ) ;
	}

	if ( to == null )
		end = 10 ;
	else
	{
		if(to.equals(""))end=10;
		else
		end = Integer.parseInt( to ) ;
	}

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	Statement stmt=null;
	Connection conn = null;
try
{
	conn = ConnectionManager.getConnection(request);	
	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("chk"+(i)) != null)
			 {
				 j++;
			 }
		 }	
		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	i = 1 ;

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		StringBuffer Where  = new StringBuffer();
		String locale = (String) session.getValue("LOCALE");
		Where.append("");
					
		Where.append("WHERE a.facility_id = '"+FacilityId+"' AND a.patient_id = b.patient_id AND b.patient_id LIKE '%%' AND TRUNC (a.visit_adm_date_time) >= TO_DATE  ('"+alt_id1_exp_date+"','dd/mm/yyyy') AND TRUNC (a.visit_adm_date_time) <= TO_DATE ('"+alt_id2_exp_date+"','dd/mm/yyyy') AND EXISTS (SELECT onset_facility_id, onset_encounter_id FROM mr_diag_recoding WHERE onset_facility_id = a.facility_id AND onset_encounter_id = a.encounter_id)");

		if ( !(PatientId == null || PatientId.equals("")) )
		{
			Where.append( " and a.PATIENT_ID = '"+PatientId+"'");
		}

		if ( !(Enc_Type == null || Enc_Type.equals("")) )
		{
			Where.append( " and a.PATIENT_CLASS = '"+Enc_Type+"'");
		}

		if ( !(EncounterId == null || EncounterId.equals("")) )
		{
			Where.append( " and a.encounter_id = '"+EncounterId+"'");
		}

		if ( !(national_id_no == null || national_id_no.equals("")) )
		{
			Where.append(" and b.NATIONAL_ID_NO = '"+national_id_no+"' ");
		}
		if ( !(alt_id1_no == null || alt_id1_no.equals("")) )
		{
			Where.append( " and b.alt_id1_no = '"+alt_id1_no+"' ");
		}
		if ( !(alt_id2_no == null || alt_id2_no.equals("")) )
		{
			Where.append(" and b.alt_id2_no = '"+alt_id2_no+"' ");
		}
		if ( !(alt_id3_no == null || alt_id3_no.equals("")) )
		{
			Where.append( " and b.alt_id3_no = '"+alt_id3_no+"'");
		}
		if ( !(alt_id4_no == null || alt_id4_no.equals("")) )
		{
			Where.append( " and b.alt_id4_no = '"+alt_id4_no+"'");
		}

		if ( !(other_alt_type == null || other_alt_type.equals("")) )
		{
			Where.append( " and b.oth_alt_id_type = '"+other_alt_type+"'");
		}
		
		if ( !(other_alt_Id == null || other_alt_Id.equals("")) )
		{
			Where.append( " and b.oth_alt_Id_no = '"+other_alt_Id+"'");
		}

		if ( !(orderBy == null || orderBy.equals("")) )
		{
			Where.append( " order by "+orderBy+" ");
		}

	int maxRecord = 0;
	if(rs != null)rs.close();
	if(pstmt  != null)pstmt.close();

		sql = "SELECT   a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))patient_name, DECODE (b.sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,TO_CHAR (b.date_of_birth, 'dd/mm/yy') birth_date, TO_CHAR (a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi')encounter_date, a.encounter_id,(CASE WHEN a.specialty_code IS NOT NULL  THEN (SELECT short_desc FROM am_speciality  WHERE speciality_code = a.specialty_code) END) speciality_desc,DECODE (a.assign_care_locn_type,'N', (SELECT short_desc FROM ip_nursing_unit  WHERE facility_id = '"+FacilityId+"' AND nursing_unit_code = a.assign_care_locn_code),(SELECT long_desc FROM op_clinic WHERE facility_id = '"+FacilityId+"' AND clinic_code = a.assign_care_locn_code)) locn_desc,(CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_name,a.assign_room_num room_no, a.assign_bed_num bed_no,DECODE (a.assign_care_locn_type,'C', 'Clinic','N', 'Nursing Unit','E', 'Procedure Unit','Y', 'Daycare Unit' ) locn_type, (CASE  WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class WHERE patient_class = a.patient_class) END) encounter_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,a.patient_class patient_class, get_age (b.date_of_birth) age FROM pr_encounter a, mp_patient b " + Where;

		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
		stmt	= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs =stmt.executeQuery(sql);
		if (stmt  != null) stmt.close();
		
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		
	if (maxRecord==0)
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}
	 else
	 {

	if(!flag.equals("true"))
	{
		
            _bw.write(_wl_block8Bytes, _wl_block8);
	if(!PatientId.equals(""))
		{	
            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block12Bytes, _wl_block12);
	}	
            _bw.write(_wl_block13Bytes, _wl_block13);

					if ( !(start <= 1) )
						out.println("<A HREF=\"javascript:submitPrevNextrepWEHUADReqRes("+(start-10)+","+(end-10)+")\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
					if ( !( (start+10) > maxRecord ) )
						out.println("<A HREF=\"javascript:submitPrevNextrepWEHUADReqRes("+(start+10)+","+(end+10)+")\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
	if(PatientId.equals(""))
		{ 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
	}	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);


		if ( rs != null )
		{
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

				while ( rs.next() && i<=end )
				{
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					String Patient_ID=rs.getString("patient_id");				
					String Patient_Name=rs.getString("patient_name");				
					String conGender=rs.getString("gender");				
					String Date_of_Birth=rs.getString("birth_date");				
					String Patient_Class=rs.getString("encounter_type");	
					String Encounter_Date=rs.getString("encounter_date");				
					String Encounter_ID=rs.getString("encounter_id");				
					String con_Speciality=rs.getString("speciality_desc");				
					String con_Location=rs.getString("locn_desc");				
					String con_Practitioner=rs.getString("practitioner_name");				
					String room_no=rs.getString("room_no");				
					String bed_no=rs.getString("bed_no");				
					String locn_type=rs.getString("locn_type");		
					String Encounter_Type = rs.getString("encounter_type");
					String Patient_Class_code= rs.getString("Patient_Class");
					String age= rs.getString("age");

					if(Patient_ID==null	      || Patient_ID.equals("null"))		    
						Patient_ID = "";
					if(Patient_Name==null	  || Patient_Name.equals("null"))				
						Patient_Name = "";
					if(conGender==null	      || conGender.equals("null"))		    
						conGender = "";
					if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
						Date_of_Birth = "";
					if(Patient_Class==null	  || Patient_Class.equals("null"))
						Patient_Class = "";
					if(Encounter_Date==null	  || Encounter_Date.equals("null"))
						Encounter_Date = "";
					if(Encounter_ID==null	  || Encounter_ID.equals("null"))
						Encounter_ID = "";
					if(con_Speciality==null	  || con_Speciality.equals("null"))
						con_Speciality = "&nbsp;";
					if(con_Location==null	  || con_Location.equals("null"))
						con_Location = "&nbsp;";
					if(con_Practitioner==null || con_Practitioner.equals("null"))
						con_Practitioner = "&nbsp;";
					if(room_no==null || room_no.equals("null"))
						room_no = "&nbsp;";
					if(bed_no==null || bed_no.equals("null"))
						bed_no = "&nbsp;";
					if(locn_type==null || locn_type.equals("null"))
						locn_type = "&nbsp;";
					if(Encounter_Type==null || Encounter_Type.equals("null"))
						Encounter_Type = "&nbsp;";

					out.println("<tr>");
					out.println("<td align='left' class='"+classValue+"'>");
					out.print("<a href=\"javascript:closeWinrepWEHUADReqRes('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"')\">");	
					out.print("+</a></td>");				
					out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"</td>");
					out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosisrepWEHUADReqRes('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");

				if(PatientId.equals(""))
				{					
					out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+", "+Patient_Name+", "+conGender+", "+age+"&nbsp;</td>");				
				}
					out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +room_no+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +bed_no+"</td>");
					out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
					out.println("</tr>");
				i++;
			}
		}	
            _bw.write(_wl_block20Bytes, _wl_block20);
	}
	
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(module));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(start));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(end));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(temp1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Enc_Type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(orderBy));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(other_alt_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(other_alt_Id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block52Bytes, _wl_block52);

}
if(!finalSelect.equals("SELECTALL"))
{
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	String objName ="";String enable_dis="";
	int temp=st.countTokens();
	for(int u2=0;u2<temp;u2++)
	{
		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		st1.nextToken();
		objName=st1.nextToken();
		enable_dis=st1.nextToken();

		if(enable_dis.equals("E"))
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
		else
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
	}
}
Where.setLength(0);
}catch ( Exception e )
{ 
	//out.println(e);
	e.printStackTrace();
}

finally
{

	try
	{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	}
	catch (Exception e)
	{
	}

	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block53Bytes, _wl_block53);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
