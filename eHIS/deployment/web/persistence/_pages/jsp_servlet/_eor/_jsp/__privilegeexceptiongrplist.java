package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __privilegeexceptiongrplist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PrivilegeExceptionGrpList.jsp", 1709119932000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/PrivilegeExceptionGrp.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"formPrivilegeExpGrpList\" id=\"formPrivilegeExpGrpList\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\n\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' <= 0)\n\t\t\t\t{\n\t\t\t\t\tif(!";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\");\t\n\t\t\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\");\t\n\t\t\t\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\n\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n\t<tr align=\'right\' width=\'10%\'>\n\t<td class=\'WHITE\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<A class=\'gridlink\' HREF=\'javascript:onClick=checkVal(\"Previous\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</A>\n\t\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<A class=\'gridlink\' HREF=\'javascript:onClick=checkVal(\"Next\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</A>\n\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</td>\n\t</tr>\n\t</table> \n\t<table cellspacing=\'0\' cellpadding=\'3\' width=\'100%\' border=\'1\' align=\"center\">\n\t<td class=\'columnheader\' width=\"75%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td><td class=\'columnheader\' width=\'25%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'><input type=\'checkbox\' name=\'select_yn";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'select_yn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'Y\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="></td>\n\t\t\t<!--input type=hidden name=\'strHidden";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\"\">-->\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\n\t\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ><b>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</b></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ></td>\n\t\t\t\t\t<!--<input type=hidden name=\'strHidden";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'strHidden";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" >-->\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<script>\n\t\tvar msg = getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\t\n\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t</table>\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">\n\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" > \n\t<input type=\"hidden\" name=\"tabVal\" id=\"tabVal\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"exception_type\" id=\"exception_type\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" name=\"select_All\" id=\"select_All\" value=\"*All\">\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
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

int row_count=0;

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	request.setCharacterEncoding("UTF-8");
	String bean_id = "privilegeExceptiongrpbean" ;
	String bean_name = "eOR.PrivilegeExceptionGrpBean";
	//String status="E",key="",readOnly = "",status_db = "";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="",  index="";
	String long_desc="", dispMode="", tabVal="";
	String display_label="",from= "", to ="";
	String exception_type ="", order_category	="", order_type_code="";		
	String  code="";
	String mode="", update_val = "", grp_exception_id="", grp_exception_name="";

	Vector recList = new Vector();

	HashMap select_All = new HashMap();
	boolean isAllPresent = false;

	int classValueCount = 0; // to display classValue alternatively in update mode for 2 for loops...
	//HashMap htRecord = null;

	mode= request.getParameter("mode");
	if(mode==null)mode="1";

	int row_disp=8;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;
	//int dbRecordCount = 0;
	
	HashMap htListRecord= new HashMap();
	boolean stats = false, checkRecords = false;
	//boolean alteredRecord = false; alteredDBRecord = false;
	//eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	//eOR.Common.MultiRecordBean MultiRecordBeanNew		= new eOR.Common.MultiRecordBean();




	exception_type		= request.getParameter("exception_type");
	order_category		= request.getParameter("order_category");
	order_type_code		= request.getParameter("order_type_code");
	tabVal				= request.getParameter("tabVal");
	dispMode			= request.getParameter("dispMode") ;
	from				= request.getParameter("from") ;
	to					= request.getParameter("to") ;
	index				= request.getParameter("index");
	grp_exception_id	= request.getParameter("grp_exception_id");
	grp_exception_name	= request.getParameter("grp_exception_name");
		
	/*System.err.println("Index after getParameter   "  + index);	
	if( index == null)
		index = "OTH";
	System.err.println("Index after getParameter   "  + index);	*/

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;
	
	if(index == null || index.equals("null"))index="";	
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="S";
	if(exception_type == null || exception_type.equals("null"))exception_type="";
	if(order_category == null || order_category.equals("null"))order_category="";
	if(order_type_code == null || order_type_code.equals("null"))order_type_code="";
	if(grp_exception_id == null || 	grp_exception_id.equals("null"))grp_exception_id="";
	if(grp_exception_name == null || grp_exception_name.equals("null"))	grp_exception_name="";


	if(exception_type.equals("OC")){
		display_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		index = "A";
	}
	else if(exception_type.equals("OT")){
		display_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels");
	}
	else if(exception_type.equals("OR")){
		display_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orderable.label","common_labels");
	}
	

	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	PrivilegeExceptionGrpBean bean = (PrivilegeExceptionGrpBean)getBeanObject( bean_id,  bean_name, request ) ; /* Initialize Function specific end */
 


 	eOR.Common.MultiRecordBean MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();




	//bean.clear();
 	//MultiRecordSet.clearDBRec();	
	/*
	out.println("<script>alert(' index  :"+index+"');</script>");
	out.println("<script>alert(' order_type_code  :"+order_type_code+"');</script>");
	out.println("<script>alert(' order_category  :"+order_category+"');</script>");
	out.println("<script>alert(' tabVal  :"+tabVal+"');</script>");
	out.println("<script>alert(' dispMode  :"+dispMode+"');</script>");
	out.println("<script>alert(' grp_exception_id  :"+grp_exception_id+"');</script>");
	out.println("<script>alert(' grp_exception_name  :"+grp_exception_name+"');</script>");
	out.println("<script>alert(' exception_type  :"+exception_type+"');</script>");
	out.println("<script>alert(' mode  :"+mode+"');</script>");
	*/
		
	try{

		//out.println("<script>alert(' mode  :"+mode+"');</script>");
		if(mode.equals("1")){
			//checkRecords = bean.checkRecords(exception_type, grp_exception_id);
			checkRecords = bean.checkRecords(grp_exception_id);
		}
		
	if( !checkRecords){
		if(dispMode.equals("")){
			if(!exception_type.equals("OC")){
				//dbRecordCount		=
				bean.fetchDBRecords(exception_type.trim(),grp_exception_id.trim());
				//System.err.println("Rec Count if   " + dbRecordCount);
			}else{
				if(mode.equals("2")){
				//dbRecordCount		= 
					bean.fetchDBRecords(exception_type.trim(), grp_exception_id.trim());
					//System.err.println("Rec Count  else  " + dbRecordCount);
				}
			}
	//Added by Subhash on 15th April////
	//Start
	
	
//	MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();	 
	
	if (mode.equals("1"))
	{
			//System.err.println("Before adding All");
			//System.err.println("Mode @@@@@@@@@ " + mode);				
			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			int size = MultiRecordSet.getSize("DB");
			if( size == 0 )
			{
				//System.err.println("Size ================= 0 ");
				select_All.put("status","N");
				select_All.put("long_desc","All");
				select_All.put("valid","N");
				select_All.put("code","*All");
				select_All.put("associate_yn","N");
				//boolean ret = 
				MultiRecordSet.putObject(select_All);
				//System.err.println("Rec Inserted into MultiRecBean   " + ret );

				select_All = null;
			}
			else
			{
				for(int i=0;i<MultiRecordSet.getSize("DB");i++)
				{
					htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					code	=	(String)	htListRecord.get("code");
					if(!code.equalsIgnoreCase("*All"))
					{
						isAllPresent = false;
						//System.err.println("@@@@@@@@@@@@  != All ");
					}
					else
					{
						isAllPresent = true;
						//System.err.println("@@@@@@@@@@@@  == All ");
						break;
					}
				}
				if( isAllPresent == false)
				{
					//System.err.println("@@@@@@@@@@@@@@@ Anyway Adding All to Bean @@@@@@@@@@@@@");
					select_All.put("status","N");
					select_All.put("long_desc","All");
					select_All.put("valid","N");
					select_All.put("code","*All");
					select_All.put("associate_yn","N");
					//boolean ret = 
					MultiRecordSet.putObject(select_All);
					//System.err.println("Rec Inserted into MultiRecBean   " + ret );
	
					select_All = null;
				}
			}

			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			//System.err.println("After adding All");		
			
			//System.err.println("After displaying All");		
		
		}	
	//End  	
	
			//out.println("<script>alert('dbRecordCount :"+dbRecordCount+"');</script>");

			//if(dbRecordCount == 0){

	if(tabVal.equals("S")){
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,exception_type,order_type_code,order_category);	
		row_count			=	MultiRecordSet.getSize("SELECT");
	}else if(tabVal.equals("A")){
		//MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,exception_type,order_type_code,order_category);	
		//row_count			=	MultiRecordSet.getSize("SELECT");
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
			
	if (mode.equals("2") && !exception_type.equals("OC"))
	{
			//System.err.println("Before adding All");
			//System.err.println("Mode @@@@@@@@@ " + mode);				
			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			//MultiRecordSet.clearDBRec();
			int size = MultiRecordSet.getSize("DB");
			if( size == 0 )
			{
				//System.err.println("Size ================= 0 ");
				select_All.put("status","N");
				select_All.put("long_desc","All");
				select_All.put("valid","N");
				select_All.put("code","*All");
				select_All.put("associate_yn","N");
				//boolean ret =
				MultiRecordSet.putObject(select_All);
				//System.err.println("Rec Inserted into MultiRecBean   " + ret );

				select_All = null;
			}
			else
			{
				for(int i=0;i<MultiRecordSet.getSize("DB");i++)
				{
					htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					code	=	(String)	htListRecord.get("code");
					if(!code.equalsIgnoreCase("*All"))
					{
						isAllPresent = false;
						//System.err.println("@@@@@@@@@@@@  != All ");
					}
					else
					{
						isAllPresent = true;
						//System.err.println("@@@@@@@@@@@@  == All ");
						break;
					}
				}
				if( isAllPresent == false)
				{
					for(int i=0;i<MultiRecordSet.getSize("DB");i++)
					{
						htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
						if(htListRecord != null)
						{
							recList.add(i,htListRecord);
						}
						//MultiRecordSet.removeObject(i);
					}
					//boolean x =
					MultiRecordSet.clearDBRec();
					//System.err.println("clear success    " + x);
					
					//System.err.println("@@@@@@@@@@@@@@@ Anyway Adding All to Bean @@@@@@@@@@@@@");
					select_All.put("status","N");
					select_All.put("long_desc","All");
					select_All.put("valid","N");
					select_All.put("code","*All");
					select_All.put("associate_yn","N");
					//boolean ret =
					MultiRecordSet.putObject(select_All);
					//System.err.println("Rec Inserted into MultiRecBean   " + ret );
					select_All = null;
					//boolean ret1 = false;
					for(int i=0;i<recList.size();i++)
					{
						//ret1 = 
							MultiRecordSet.putObject((HashMap )recList.get(i));
					}
				}
			}
			//System.err.println("Multi Record Bean size    " + 	MultiRecordSet.getSize("DB"));	
			//System.err.println("After adding All");		
			
			//System.err.println("After displaying All");		
		  }	
			row_count			=  MultiRecordSet.getSize("DB");
		}
			
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		
		//row_count			=  MultiRecordSet.getSize("DB");
		//System.err.println("Row Count @@@@@@@&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@ " + row_count);
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tabVal.equals("A")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( mode.equals("2") ));
            _bw.write(_wl_block13Bytes, _wl_block13);

		/*}else{
			%->
			<script>
			var msg = getMessage("CODE_ALREADY_EXISTS");	
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			</script>
			<-%
		}*/
		}else{
			
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));
		
		if((dispMode.trim()).equalsIgnoreCase("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
		}else if((dispMode.trim()).equalsIgnoreCase("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
	
		if(to_val > (row_count-1))
			to_val=(row_count-1);
		
		MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
		
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				//alteredRecord =
				MultiRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				//alteredDBRecord =
				MultiRecordSet.setDBBeanValue(j,update_val);
			}
		}
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);

		
	}
	
            _bw.write(_wl_block14Bytes, _wl_block14);

	if ( (!(start <= 1)) && (start < row_count)){
	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
	
	}

	if ( !( (start+row_disp) > row_count ) ){
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	}
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(display_label));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

		//String all = "N";
		if(tabVal.equals("S")){
			
			for(int i=fm_disp; i<=to_disp; i++){
			classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
			htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
									
			code				=	(String)	htListRecord.get("code");
			long_desc			=	(String)	htListRecord.get("long_desc");
			valid				=	(String)	htListRecord.get("valid");
			associate_yn		=	(String)	htListRecord.get("associate_yn");

			if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
			//status			=	(String)    htListRecord.get("status");
			stats  				=	MultiRecordSet.containsObject(code);

			if(stats){
				valid = MultiRecordSet.getValidKey(code);
			}
			/********************/
			if(valid.equals("Y")){
				checkValue="checked";
				disabled="disabled";
			}else{
				if(associate_yn.equals("Y")){
					checkValue="checked";
					disabled="";
				}else{
					if((stats)&&(associate_yn.equals("N"))){
						checkValue="checked";
						disabled="";
					}else{
						checkValue="";
						disabled="";
					}
				}
			}
			/**********************/
				
			//out.println("valid :"+valid);
			//out.println("associate_yn :"+associate_yn);
			//out.println("stats :"+stats);
				
			tblrow_id	=	"tblrow_id"+i;
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(((long_desc.equals(""))?"&nbsp;":long_desc)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);

			}
			}else if(tabVal.equals("A")){
				
			Vector codeVector = new Vector();
			String strHidden = "";				
			
		//to_disp = MultiRecordSet.getSize("DB");
		//System.err.println("Before Printing #@#@#@#@#@@@     " + to_disp);

		for(int i=fm_disp; i<=to_disp; i++)
				{
					strHidden = "";
					classValue			=	( (i%2)==0 )? "QRYEVEN" : "QRYODD";
					htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
					//System.err.println(" List Record @@@@@@@@@@@  " + htListRecord );
					if(htListRecord == null)
					{
						//htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
						break;
					}
					code				=	(String)	htListRecord.get("code");
					//strHidden = strHidden + code + "$";
					codeVector.add( code );
					long_desc			=	(String)	htListRecord.get("long_desc");
					valid				=	(String)	htListRecord.get("valid");
					associate_yn		=	(String)	htListRecord.get("associate_yn");
				//	status_db			=	(String)	htListRecord.get("status");

		
					tblrow_id	=	"tblrow_id"+i;
					if(valid.equals("N")){
						if(associate_yn.equals("Y"))
							checkValue="checked";
						else 
							checkValue="";
					}
					else{
						if(associate_yn.equals("D"))
							checkValue="";
						else 
							checkValue="checked";
					}
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(valid.equals("Y")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(((long_desc.equals(""))?"&nbsp;":long_desc)));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(((long_desc.equals(""))?"&nbsp;":long_desc)));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( strHidden ));
            _bw.write(_wl_block43Bytes, _wl_block43);

						classValueCount++;
			  }

			

							
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	
		
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	

		 }
		}else{
		
            _bw.write(_wl_block44Bytes, _wl_block44);

		}
	}
	catch(Exception e){
		//e.printStackTrace();
		System.out.println("Exception@ : " + e);
	}
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(from));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(to));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( bean_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tabVal));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(exception_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block58Bytes, _wl_block58);

		putObjectInBean(bean_id,bean,request);
 

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
}
