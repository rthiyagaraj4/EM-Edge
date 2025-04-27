package jsp_servlet._eca._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __multitransrequestresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MultiTransRequestResult.jsp", 1737095096125L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n\t\t<link\trel=\'StyleSheet\'\t  href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"> </script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' >\t\t </script>\n\t\t<script Language=\"JavaScript\" src=\'../../eCA/js/MultiTransRequest.js\'>\t </script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\">\t\t </script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<body onScroll=\'scrollTitle()\' OnMouseDown=\'CodeArrest()\' onload=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'MultiTransRequestResultForm\' id=\'MultiTransRequestResultForm\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.MultiTransRequestServlet\'>\n\t\t<!--<div id=\'divDataTitle\' style=\'postion:relative\'> -->\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table  class=\'grid\' WIDTH=\'100%\' align=\'center\'  >\n\t\t\t<tr>\n\t\t\t\t<td CLASS=\'gridData\' >&nbsp;</td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<td class=\'gridData\'  width=\'8%\'><a class=\'gridLink\' href=\"javascript:submitPrevNext(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" style=\"text-decoration:none;  font-weight:bold\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td class=\'gridData\' align=\'center\' width=\'8%\'><a class=\'gridLink\' href=\"javascript:submitPrevNext(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\" style=\"text-decoration:none; font-weight:bold\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</tr></table>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<table class=\'grid\'  width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"dataTitleTable\">\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<input type=\'checkbox\' id= \'selAll\' onclick=\'selectPatInPage(this)\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t</tr>\n\t<!--\t</table>\n\t\t</div>\n\t\t<table class=\'grid\'  width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"dataTable\" > -->\n\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'4\' class=\'CAFOURTHLEVELCOLOR\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;-&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</td>\n\t\t\t<tr>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'gridData\'><input type=\'checkbox\' name=\'selRow";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'selRow";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onClick=\"remFromList(this,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\" ><input type=\'hidden\' name=\'patient_id";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'patient_id";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'encounter_id";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'encounter_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =", ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t<td class=\'gridData\'><input type=\'hidden\' name=\'transcriber";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'transcriber";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t<input type=\'text\' name=\'transcriber_desc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'transcriber_desc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' size=30 maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onBlur =\"getTranscriber(this,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\" ><input type=\'button\' class=\'button\' value=\'?\' id=\'src_butn\'  name=\'search_pract\' id=\'search_pract\' onClick=\"getTranscriber1(this,\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');\" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t<!--\t\n\t\t\t\t\t<select name=\'transcriber";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t</select> -->\n\t\t\t\t</td>\n\t\t\t\t<td class=\'gridData\'>\n\t\t\t\t\t<select name=\'notes";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'notes";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\n\t\t\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\t\t\n\t\t\t</tr>\n\t\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<tr style=\'visibility:hidden\' >\n\t\t\t\t<td class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t<td class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t<!--</table> -->\n\t<input type=\'hidden\' name=\'bean_key\' id=\'bean_key\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\'hidden\' name=\'practitionerId\' id=\'practitionerId\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<!--<input type=\'hidden\' name=\'selcount\' id=\'selcount\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"> -->\n\t<input type=\'hidden\' name=\'startIndex\' id=\'startIndex\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\'hidden\' name=\'endIndex\' id=\'endIndex\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t</form>\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t<!--<script>alignWidth();</script>-->\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t<script>document.forms[0].selAll.checked=true;</script>\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t<script>global_count=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'</script>\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		String facility_id		=	(String) session.getValue("facility_id");
		//String ca_practitioner_id		=	(String) session.getValue("ca_practitioner_id");
		String resp_id = (String)session.getValue("responsibility_id");
		eCA.PatientBannerGroupLine multiTransBean = null;
		//String queryString = request.getQueryString();


	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
		Connection con = null;
		PreparedStatement stmt=null;
		//PreparedStatement pstmt=null;
		ResultSet rs=null;
		//ResultSet prs=null;
	
		//ArrayList selectedList =new ArrayList(); 

		StringBuffer query_string	 =	new StringBuffer();
		StringBuffer transReqQry	 =	new StringBuffer();
		//StringTokenizer Tokens		 =	null ;
		String patientId			 =	"";
		String practitionerId		 =	"";
		String speciality_code		 =	"";
		String location_code		 =	"";
		String service_code			 =	"";
		//String cons_date			 =	"";
		//String cons_time			 =	"";
		String create_type			 =	"";
		String bean_key				 =	"";
		String res_mode				 =	"";
		//String strVal				 =	"";
		//String checked				 =	"";
		//String arrVal				 =	"";
		String pline				 =	"";
		String rsAdmission_date_time =	"";
		//String rsSpecialty_code		 =	"";
		//String rsSpecialty_desc		 =	"";
		//String rsLocation_code		 =	"";
		String patient_id			 =	"";
		String encounter_id			 =	"";
		//String preRsLocation_code	 =	"";
		String attend_practitioner_id =	"";
		//String preattend_practitioner_id ="";
		//String specialty_desc		 =	"";
		//String nursing_unit_desc	 =	"";
		//String practitioner_name	 =	"";
		String display_admission_date=	"";
		//String control				 =	"";
		//String max_cons_per_pract	 =	"";
		//String max_cons_per_splty	 =	"";
		//String cons_back_date		 =	"";
		//String amd_cons_list		 =	"";
		//String min_cons_duration	 =	"";
		//String control_value		 =	"";
		//String disabled				 =	"";
		//String className1			 =	"";
		//String splty_code			 =	"";
		String referral_id			 =	"";
		String lower_limit			 =	"";	
		String upper_limit			 =	"";
		String hash_key				 =	"";
		String chkBxStat			 =	"";
		String default_transcriber	 =	"";
		String default_transcriber_desc	 =	"";
		String def_trans_chk		 =	"";
		String default_note			 =	"";
		String def_note_chk			 =	"";
		String locn_code			 =	"";
		String locn_type			 =	"";
		String locn_name			 =	"";
		String pre_locn_code		 =	"";
		String locn_type_desc		 =	"";
		String CurrentDate			 =	"";
		String CurrentTime			 =	"";
		String locn_type_crit		 =	"";
		String viewlist				 =	"";
		String tr = "";
		String tr_vals[]			 =  new String[2];
		int		rowCnt					=	0,		maxRecordsDisp		=	10;
		int		startIndex				=	0,		endIndex			=	0;
		int		totalRecordCount		=	0;
		int		i						=	0;
		boolean flag = true;
		
		String count = "0";
		int chCount= 0;
		ArrayList transcriber_arr = new ArrayList();
		ArrayList notes_arr = new ArrayList();

		patientId			=	(request.getParameter("patientId")==null)	?	""	:	request.getParameter("patientId");
		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
		speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
		location_code			=	(request.getParameter("location_code")==null)	?	""	:	request.getParameter("location_code");
		service_code			=	(request.getParameter("service_code")==null)	?	""	:	request.getParameter("service_code");
		create_type			=	(request.getParameter("create_type")==null)	?	""	:	request.getParameter("create_type");
		res_mode			=	(request.getParameter("res_mode")==null)	?	""	:	request.getParameter("res_mode");
		locn_type_crit			=	(request.getParameter("locn_type")==null)	?	""	:	request.getParameter("locn_type");
		viewlist			=	(request.getParameter("viewlist")==null)	?	""	:	request.getParameter("viewlist");
		
		//count			=	(request.getParameter("selcount")==null)	?	"0"	:	request.getParameter("selcount");


		lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
		upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");

		startIndex		=	Integer.parseInt(lower_limit);
		endIndex		=	Integer.parseInt(upper_limit);

		CurrentDate	= (request.getParameter("CurrentDate")==null)	?	""	:	request.getParameter("CurrentDate");

		CurrentTime	= (request.getParameter("CurrentTime")==null)	?	""	:	request.getParameter("CurrentTime");
	
		if(res_mode.equals("Next")||res_mode.equals("Prev"))
		{
			bean_key			=	(request.getParameter("bean_key")==null)	?	""	:	request.getParameter("bean_key");

		}
		else
		{
			bean_key = practitionerId+CurrentDate+CurrentTime;
		}



		query_string.append("practitionerId=");		query_string.append(practitionerId);
		query_string.append("&speciality_code=");	query_string.append(speciality_code);
		query_string.append("&location_code=");	query_string.append(location_code);
		query_string.append("&service_code=");	query_string.append(service_code);
		query_string.append("&patientId=");	query_string.append(patientId);
		query_string.append("&create_type=");	query_string.append(create_type);
		query_string.append("&locn_type=");	query_string.append(locn_type_crit);
		query_string.append("&viewlist=");	query_string.append(viewlist);

		String transcriber_qry = "select PRACTITIONER_ID, PRACTITIONER_NAME from AM_PRACTITIONER_LANG_VW where LANGUAGE_ID = ? order by 2";

		String noteType_qry="select a.note_type_desc description, a.note_type code from  ca_note_type a,ca_note_group c where a.NOTE_GROUP_ID=c.NOTE_GROUP and c.TRANSCRIPTION_YN='Y' and (a.note_type in (select b.note_type_id from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code = ? AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp c WHERE a.note_type = c.note_type   AND c.resp_id = ?  AND c.privilege_type != '5' )) or a.NOTE_TYPE in  (select d.NOTE_TYPE from CA_NOTE_TYPE_FOR_RESP d where d.NOTE_TYPE = a.NOTE_TYPE and d.RESP_ID = ? and d.PRIVILEGE_TYPE!=5)) order by 1";

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
	
	
            _bw.write(_wl_block8Bytes, _wl_block8);

		transReqQry.append("select b.PATIENT_ID,b.ENCOUNTER_ID,get_patient.get_line_detail(b.PATIENT_ID,?) Pline,REFERRAL_ID, to_char(b.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME , AM_GET_DESC.AM_PRACTITIONER(nvl(b.ATTEND_PRACTITIONER_ID,b.ADMIT_PRACTITIONER_ID),?,'1') ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,b.SPECIALTY_CODE,b.PATIENT_CLASS) DEFAULT_TRANSCRIBER,AM_GET_DESC.AM_PRACTITIONER(CA_GET_DEFAULT_TRANSCRIBER(?,b.SPECIALTY_CODE,b.PATIENT_CLASS),?,'1') DEFAULT_TRANSCRIBER_DESC,CA_GET_DEFAULT_NOTES(?,?,b.SPECIALTY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE, PAT_CURR_LOCN_TYPE LOCN_TYPE ,IP_GET_DESC.IP_NURSING_UNIT(?,b.PAT_CURR_LOCN_CODE,?,'1') locn_name  from IP_OPEN_ENCOUNTER b where  b.facility_id= ?  ");
		//viewlist and b.ATTEND_PRACTITIONER_ID= ?
		if(viewlist.equals("P"))
			transReqQry.append(" and b.ATTEND_PRACTITIONER_ID= ? ");
		else if(viewlist.equals("R"))
			transReqQry.append(" and patient_id in (select patient_id from CA_ENCNTR_PRACT_RELN f where f.PRACTITIONER_ID = ? and f.STATUS ='01' and FACILITY_ID= ? AND NVL(b.ENCOUNTER_ID,0) = NVL(f.ENCOUNTER_ID,0) AND SYSDATE BETWEEN BEGIN_DATE_TIME and nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY'))  )");

		if(!speciality_code.equals(""))
			transReqQry.append("and b.SPECIALTY_CODE=? ");
		if(!patientId.equals(""))
			transReqQry.append("and b.PATIENT_ID =? ");
		
		if(!locn_type_crit.equals(""))
			transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");
				

		if(!location_code.equals(""))
			transReqQry.append("and b.NURSING_UNIT_CODE =? ");
		if(!service_code.equals(""))
			transReqQry.append("and b.SERVICE_CODE=? "); //

		   transReqQry.append(" UNION ALL SELECT a.PATIENT_ID,a.ENCOUNTER_ID,get_patient.get_line_detail(a.PATIENT_ID,?) Pline,'' REFERRAL_ID, to_char(a.ARRIVE_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME, AM_GET_DESC.AM_PRACTITIONER( PRACTITIONER_ID,?,'1') ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,a.SPECIALITY_CODE,a.PATIENT_CLASS) DEFAULT_TRANSCRIBER,AM_GET_DESC.AM_PRACTITIONER(CA_GET_DEFAULT_TRANSCRIBER(?,a.SPECIALITY_CODE,a.PATIENT_CLASS),?,'1') DEFAULT_TRANSCRIBER_DESC,CA_GET_DEFAULT_NOTES(?,?,a.SPECIALITY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE, PAT_CURR_LOCN_TYPE LOCN_TYPE,OP_GET_DESC.OP_CLINIC(?,a.PAT_CURR_LOCN_CODE,?,'1') locn_name from op_patient_queue a where a.QUEUE_DATE between trunc(sysdate)  and trunc(sysdate) + 1 and   a.FACILITY_ID=? "); //and a.PRACTITIONER_ID=?
		
		if(viewlist.equals("P"))
			transReqQry.append(" and a.PRACTITIONER_ID=? ");
		else if(viewlist.equals("R"))
			transReqQry.append(" and patient_id in (select patient_id from CA_ENCNTR_PRACT_RELN f where f.PRACTITIONER_ID = ? and f.STATUS ='01' and FACILITY_ID= ? AND NVL(a.ENCOUNTER_ID,0) = NVL(f.ENCOUNTER_ID,0) AND SYSDATE BETWEEN BEGIN_DATE_TIME and nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) )");


		if(!speciality_code.equals(""))
			transReqQry.append("and a.SPECIALITY_CODE=? "); //SPECIALITY_CODE
		if(!patientId.equals(""))
			transReqQry.append("and a.PATIENT_ID =? ");
		if(!locn_type_crit.equals(""))
			transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");

		if(!location_code.equals(""))
			transReqQry.append("and a.PAT_CURR_LOCN_CODE =? ");
		if(!service_code.equals(""))
			transReqQry.append("and a.SERVICE_CODE=? "); //

			transReqQry.append(" Order By LOCN_CODE ");
	

		try
		{
			
			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(transcriber_qry);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();

			while(rs.next())
			{
			 	transcriber_arr.add(rs.getString("PRACTITIONER_ID")+"~"+rs.getString("PRACTITIONER_NAME"));
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement(noteType_qry);
			stmt.setString(1,practitionerId);
			stmt.setString(2,resp_id);
			stmt.setString(3,resp_id);
			rs = stmt.executeQuery();

			while(rs.next())
			{
			
				notes_arr.add(rs.getString("CODE")+"~"+rs.getString("DESCRIPTION"));
				
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement(transReqQry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int count1=0;

			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,locale);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,facility_id);
			if(viewlist.equals("P"))
			{
			stmt.setString(++count1,practitionerId);
			}
			else if(viewlist.equals("R"))
			{
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,facility_id);

			}
			
			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);

			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,locale);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,facility_id);
			if(viewlist.equals("P"))
			{
			stmt.setString(++count1,practitionerId);
			}
			else if(viewlist.equals("R"))
			{
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,facility_id);

			}


			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);
		
			rs = stmt.executeQuery();
			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();

			if( totalRecordCount>maxRecordsDisp)
			{

	
            _bw.write(_wl_block9Bytes, _wl_block9);

			if(startIndex>maxRecordsDisp)
			{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((startIndex-maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex-maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			if(totalRecordCount>endIndex)
			{
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((startIndex+maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex+maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
	
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);


		if(startIndex>1)
			rs.absolute((startIndex-1));

		while(rs.next())
		{
			
			flag = false ;
			rowCnt++;
			patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
			encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
			pline = rs.getString("Pline")==null?"":rs.getString("Pline");
			pline =pline.replaceAll("\\|",",");
			referral_id = rs.getString("REFERRAL_ID")==null?"":rs.getString("REFERRAL_ID");
			rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
			attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
			default_transcriber = rs.getString("DEFAULT_TRANSCRIBER")==null?"":rs.getString("DEFAULT_TRANSCRIBER");
			default_transcriber_desc = rs.getString("DEFAULT_TRANSCRIBER_DESC")==null?"":rs.getString("DEFAULT_TRANSCRIBER_DESC");
			default_note = rs.getString("DEFAULT_NOTE")==null?"":rs.getString("DEFAULT_NOTE");
			locn_code = rs.getString("LOCN_CODE")==null?"":rs.getString("LOCN_CODE");
			locn_type = rs.getString("LOCN_TYPE")==null?"":rs.getString("LOCN_TYPE");
			locn_name = rs.getString("locn_name")==null?"":rs.getString("locn_name");


			if(locn_type.equals("C"))
			{
				locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(locn_type.equals("N"))
			{
				locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}
			else
			{
				locn_type_desc="";
			}
			display_admission_date=com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",localeName);

			hash_key = patient_id+"~"+encounter_id;
		
			if(multiTransBean.ContainsKey(hash_key))
			{
				chkBxStat = "checked";
				chCount++;

			}
			else
			{
				chkBxStat = "";
				//chCount--;
			}
			
			if(multiTransBean.ContainsKey(hash_key))
			{
				multiTransBean.removeFromHashMap(hash_key);
			}
				
			
			
			/*
			if(!(multiTransBean.returnList1().contains(hash_key)))
			{
				chkBxStat = "checked";

			}
			else
			{
				chkBxStat = "";
			} */

			if(!pre_locn_code.equals(locn_code))
			{
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locn_name));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(chkBxStat));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pline));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(display_admission_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(default_transcriber));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(default_transcriber_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block44Bytes, _wl_block44);
				for(int l=0;l<transcriber_arr.size();++l)
					{
						tr =	(String)transcriber_arr.get(l);				
						tr_vals = tr.split("~");
					if(default_transcriber.equals(tr_vals[0]))
						{
							def_trans_chk="selected";
						}
					else
						{
							def_trans_chk="";
						}
					
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tr_vals[0]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(def_trans_chk));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tr_vals[1]));
            _bw.write(_wl_block48Bytes, _wl_block48);

					}
	
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block51Bytes, _wl_block51);
 
					for(int m=0;m<notes_arr.size();++m)
					{
						tr =	(String)notes_arr.get(m);				
						tr_vals = tr.split("~");
				
						if(default_note.equals(tr_vals[0]))
						{
							def_note_chk="selected";
						}
						else
						{
							def_note_chk="";
						}
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tr_vals[0]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(def_note_chk));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tr_vals[1]));
            _bw.write(_wl_block52Bytes, _wl_block52);

					}
	
            _bw.write(_wl_block53Bytes, _wl_block53);
	
			pre_locn_code = locn_code ;
			i++;

			if(rowCnt>=maxRecordsDisp) break;
	
	}
	
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		else
		{
			out.println("<script>parent.MultiTransRequestToolbarFrame.MultiTransRequestToolbarForm.apply.disabled=false; </script>");
		}
	
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(bean_key));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(startIndex));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(endIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
if(!flag)
	{
	
            _bw.write(_wl_block66Bytes, _wl_block66);

		if(chCount==i)
		{
		
            _bw.write(_wl_block67Bytes, _wl_block67);

		}
		if(chCount>0){
		
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(chCount));
            _bw.write(_wl_block69Bytes, _wl_block69);

		}
	}
	
            _bw.write(_wl_block70Bytes, _wl_block70);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Transcriber.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Transcriber.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }
}
