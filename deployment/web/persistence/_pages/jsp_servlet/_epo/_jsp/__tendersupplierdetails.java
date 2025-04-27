package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.*;
import ePO.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __tendersupplierdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/TenderSupplierDetails.jsp", 1709121602778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/Tender.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\t\tfunction_id\t\t\t\t=\t\t \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\n\t\t</script>\n\t\n\t</head>\n<body> \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\"TndrSupplierDetailsForm\" id=\"TndrSupplierDetailsForm\">\n\t\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center scrolling=yes id=\'myTable\'>\n\t\t<tr>\n\t\t\t<th width=\'20%\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t<th width=\'20%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<input type=\"checkbox\" value=\"Y\" name=\"SelectAll\" id=\"SelectAll\"   onClick=\"return toggleCheck(TndrSupplierDetailsForm);\" checked></th>\n\t\t\t\t\t\t\n\t\t</tr>\n\t\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\n\t\t<tr>\t\t\t\n\t\t\t<td align=\"left\"><select name=\"supp_code_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"supp_code_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onchange=\"getContactDetails(this,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\" width=\"300\" style=\"width: 300px\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</select></td>\n\t\t\t<td  align=\"right\"><input type=\"text\" name=\"contact_person_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"contact_person_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  size=\"30\" maxlength=\"40\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onKeyPress=\" \" onBlur=\"\" readonly></td>\n\t\t\t<td  align=\"right\"><input type=\"text\" name=\"contact_number_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"contact_number_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  size=\"30\" maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onKeyPress=\" \" onBlur=\"\" readonly></td>\n\t\t\t<td  align=\"center\"><input type=\"text\"  name=\"email_id_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"email_id_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"  onKeyPress=\" \" onBlur=\"\" readonly></td>\n\t\t\t<td align=\"left\"> <input type=\"checkbox\" name=\"Select_supp_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"Select_supp_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\"Y\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  onclick = \"setstatus(this,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\"> </td>\n\t\t\t<td><input type=\"hidden\" name=\"mode_disabled_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"mode_disabled_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" value=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ></td>\t\t\t\n\t\t</tr>\n\t\t\t\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\t\n\t\t<tr>\n\t\t\t\n\t\t\t<td align=\"left\"><select name=\"supp_code_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\" width=\"300\" style=\"width: 300px\" disabled ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" \t</select></td>\n\t\t\t<td  align=\"right\"><input type=\"text\" name=\"contact_person_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ></td>\t\t\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\" width=\"300\" style=\"width: 300px\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</select></td>\t\t\t\n\t\t\t<td  align=\"right\"><input type=\"text\" name=\"contact_person_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  onKeyPress=\" \" onBlur=\"\" readonly></td>\n\t\t\t<td align=\"left\"><input type=\"checkbox\" name=\"Select_supp_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" value=\"\" ></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</select>\t</td>\n\t\t\t<td  align=\"right\"><input type=\"text\" name=\"contact_person_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onKeyPress=\" \" onBlur=\"\" readonly>\t</td>\n\t\t\t<td  align=\"right\"><input type=\"text\" name=\"contact_number_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"  onKeyPress=\" \" onBlur=\"\" readonly>\t</td>\n\t\t\t<td align=\"left\"> <input type=\"checkbox\" name=\"Select_supp_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\"\" ></td>\t\t\t\n\t\t</tr>\t\t\t\t\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t</table>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center scrolling=yes >\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t<td align=\"right\"><input type=\"button\" align=\"right\" class=\"button\" name=\"add\" id=\"add\" value=\"Add Row\"  onClick=\"addRow(\'myTable\');\"></td>\n\t\t\t<td align=\"right\"><input type=\"button\" align=\"right\" class=\"button\" name=\"Ok\" id=\"Ok\" value=\"  Ok  \"  onClick=\"AddSupplierDetails();\" ></td>\n\t\t</tr>\n\t</table>\n\t\t\n\t<input type=\"hidden\" \tname=\"finalize_yn\" id=\"finalize_yn\"\t\t\tvalue=\"No\">\n\t<input type=\"hidden\" \tname=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" \tname=\"function_id\" id=\"function_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" \tname=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" \tname=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" \tname=\"total_Records\" id=\"total_Records\"        \tvalue=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" \tname=\"req_facility_id\" id=\"req_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" \tname=\"language_id\" id=\"language_id\" \t\t\tvalue=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\n\t\n<script>\nsetstatusforSelectAll();\n</script>\n\t\n\t\n\t\n\t\n</form>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( request.getParameter("function_id") ));
            _bw.write(_wl_block10Bytes, _wl_block10);


	
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	
	String supp_code = "";
	String contact_person ="";
	String contact_number = "";
	String email_id = "";
	
	TenderBean bean					=				(TenderBean) getBeanObject( bean_id,bean_name,request);
	
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	
	String mode_modify = bean.checkForNull(request.getParameter("mode_modify"));
	String req_facility_id = bean.checkForNull(request.getParameter("facility_id"));
	
	int max_rows = 5;

	ArrayList hmExpRecords		= new ArrayList();
	int y=0;
	ArrayList alDelvRecords		= new ArrayList();

	String item_code = "";	
	
	if(bean.getSupplierDtlData(bean.getDoc_no()) != null && bean.getSupplierDtlData(bean.getDoc_no()).size()>0){
		hmExpRecords = (ArrayList)bean.getSupplierDtlData(bean.getDoc_no());
		max_rows  = hmExpRecords.size();		
	}
	
	if(bean.getSuppRecords() != null && bean.getSuppRecords().size() > 0 ){
		ArrayList bDArrayList	=	(ArrayList)bean.getSuppRecords().get(0);
		max_rows = bDArrayList.size() ; 
	}			
	//Added by Rabbani For Supplier Check box  validation on 21/06/2013
	String checked = "checked";
	String Select_dflt_Supp = "Y";
	//ends
	String Supplierdisable	= "";

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
			
	int cnt,z;
for (cnt=0; cnt<max_rows; cnt++ ) {
			if(bean.getSuppRecords() != null && bean.getSuppRecords().size() > 0 ){
			 if(cnt>0) break;
				ArrayList bDArrayList	=	(ArrayList)bean.getSuppRecords().get(0);
				if(bDArrayList.size()>0){
					for(int j=0;j<bDArrayList.size();j++){
						HashMap hm = (HashMap)bDArrayList.get(j);
						checked = "checked";
						//if(bean.checkForNull((String)hm.get("SUPP_CODE")) != null && bean.checkForNull((String)hm.get("SUPP_CODE")) != ""){
							supp_code = bean.checkForNull((String)hm.get("SUPP_CODE"));
							contact_person = bean.checkForNull((String)hm.get("CONTACT_PERSON"));
							contact_number  = bean.checkForNull((String)hm.get("CONTACT_NUMBER"));
							email_id  = bean.checkForNull((String)hm.get("EMAIL_ID"));
							Supplierdisable = bean.checkForNull((String)hm.get("MODE_DISABLED"));							

							Select_dflt_Supp  = bean.checkForNull((String)hm.get("SELECT_DATA"));
							if(Select_dflt_Supp.equals("N"))
								checked = "";							
							
							cnt=j;	 

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(j));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(j));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Supplierdisable));
            _bw.write(_wl_block20Bytes, _wl_block20);

if(!Supplierdisable.equals("")){

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.getSupp_code_ListForAll(supp_code)));
            _bw.write(_wl_block22Bytes, _wl_block22);

}else{

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.getSupp_code_List(supp_code)));
            _bw.write(_wl_block1Bytes, _wl_block1);

}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.checkForNull(contact_person)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(contact_number)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(email_id)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Supplierdisable));
            _bw.write(_wl_block38Bytes, _wl_block38);
					
						//}
				}
					
			}	
				
		}			
		else if(bean.getSupplierDtlData(bean.getDoc_no()) != null && bean.getSupplierDtlData(bean.getDoc_no()).size() > 0) {
			
			for(int j=0;j<bean.getSupplierDtlData(bean.getDoc_no()).size();j++){
						
						HashMap hm = (HashMap)hmExpRecords.get(j);
						supp_code = bean.checkForNull((String)hm.get("SUPP_CODE"));
						contact_person = bean.checkForNull((String)hm.get("CONTACT_NAME"));
						contact_number = bean.checkForNull((String)hm.get("TEL_NUM"));
						email_id = bean.checkForNull((String)hm.get("EMAIL_ID"));
						Select_dflt_Supp  = bean.checkForNull((String)hm.get("SELECT_DATA"));
						Supplierdisable = bean.checkForNull((String)hm.get("MODE_DISABLED"));						
						
 						checked = "checked";
						if(Select_dflt_Supp.equals("N"))
							checked = "";
						
						cnt=j;
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Supplierdisable));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getSupp_code_ListForAll(supp_code)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.checkForNull(contact_person)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(contact_number)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(email_id)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Supplierdisable));
            _bw.write(_wl_block43Bytes, _wl_block43);
	
			}
		}
		else{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean.getSupp_code_List(supp_code)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.checkForNull(contact_person)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(contact_number)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(email_id)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block47Bytes, _wl_block47);
	
			}
	}
			y =  cnt;
	
	for (z=y ; z<5; z++ ) {
		if(z!=0){
					supp_code = "";
					contact_person ="";
					contact_number = "";
					email_id = "";			

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(z));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(z));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(z));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean.getSupp_code_List(supp_code)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(z));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(z));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.checkForNull(contact_person)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(z));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(z));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(contact_number)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(z));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(z));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(email_id)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(z));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(z));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(z));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(z));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(z));
            _bw.write(_wl_block51Bytes, _wl_block51);

		}		
	}
		max_rows = z;
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean_name ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(max_rows));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(req_facility_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block59Bytes, _wl_block59);

	putObjectInBean(bean_id,bean,request);
		

            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.SupplierListForTender.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Supplier.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ContactPerson.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ContactNumber.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.EmailId.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
