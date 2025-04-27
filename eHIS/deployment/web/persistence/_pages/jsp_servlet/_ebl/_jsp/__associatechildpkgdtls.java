package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.PkgDefBean;
import eCommon.Common.*;
import java.text.SimpleDateFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __associatechildpkgdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AssociateChildPkgDtls.jsp", 1737913000257L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/PkgDef.js\"></script> \n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\t\t\n</head>\n\n<script>\n\t\n\t\t\t$(document).ready(function(){\n\n\t\t var totalrecords=parent.parent.PkgDefBaseDateMain.baseDateDtl.document.getElementById(\"totRec\").value;\n\t\t totalrecords=totalrecords-1;\n\t\t var fromDate= parent.parent.PkgDefBaseDateMain.baseDateDtl.document.getElementById(\'from_date\').value;\n\t\t \n\t\t \n\t\t var firstDate=$(parent.parent.PkgDefBaseDateMain.baseDateDtl.document).find(\'#fromDate_\'+totalrecords).val();\n\t\t if(fromDate==\"\"||fromDate==null||fromDate==\"undefined\"||fromDate==\"undefined\")\n\t\t\t {\n\t\t fromDate=firstDate;\n\t\t\t }\n\t\n\t$(\'#from_date\').val(fromDate);\n\t});\n\t</script>\t\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"  onSelect=\"codeArrestThruSelect();\">\t\n\t<form name=\'frmChildPackdtls\' id=\'frmChildPackdtls\'>\n\t<!-- <div id=\"tbl-container\" STYLE=\"overflow: auto; width: 1020px; height: 355px;   padding:3px; margin: 0px\"> -->\t\n\t\n\t<table  width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' id=\"ass_child_pack_tbl\">\t\n\n\t<tr>\n\t<td  class=\'COLUMNHEADER\' width =\'\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\t\n\t<td  class=\'COLUMNHEADER\' width =\'\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\t\t\n\t</tr>\n\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t<tr >\n\t<td  class=\'fields\' WIDTH=\'10%\' nowrap><input type=\'text\' name=\'childPackCode_";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' id=\'childPackCode_";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" size=\'3\' maxlength=\"2\" onBlur=\"child_pkgCodeLookup(childPackCode_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =",childPackDesc_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> <input type=\'text\' name=\'childPackDesc_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'childPackDesc_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" size=\'15\' maxlength=\"30\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onBlur=\"child_pkgCodeLookup(childPackCode_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');\" >\t<input type=\'button\' class=\'button\' name=\'childPack_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'childPack_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'?\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onClick=\"child_pkgCodeLookup(childPackCode_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\" tabindex=\'0\'  ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t<td  class=\'fields\' width=\"10%\"><input type=\'text\' name=\'fromDate_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'fromDate_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="  id=\'fromDate_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'size=\'15\' maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onBlur=\"childPackdetails(this,\'document.getElementById(\"fromDate_\")";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'fromDate\');\"  ><img id = \'fromDate_img_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' name=\"fromDate_img_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" \t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'fromDate_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'dd/mm/yyyy \');\" STYLE=\"display:inline;\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t<td  class=\'fields\' width=\"10%\"><input type=\'text\' name=\'toDate_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'toDate_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'  id=\'toDate_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="  size=\'15\' maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'document.getElementById(\"toDate_\")";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'toDate\');\"  ><img id = \'toDate_img_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' name=\"toDate_img_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'toDate_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'dd/mm/yyyy \');\" STYLE=\"display:inline;\">\n\t<input type=\'hidden\' name=\'flag_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'flag_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t</td>\t\t\t\n\n\t</tr>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t</table>\t\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" />\n\t<input type=\'hidden\' name=\'totRec\' id=\'totRec\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" />\n\t\n\t<input type=\'hidden\' name=\'index\' id=\'index\' value=\"0\" />\n\t<input type=\'hidden\' name=\'fromDate\' id=\'fromDate\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" />\n\t<input type=\'hidden\' name=\'strChargeLogic\' id=\'strChargeLogic\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" /><!-- Added V06042018-Aravindh/GHL-SCF-1107 -->\n\t\n<script>\t\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\nupdateCurrentForm(\"CHILD_PACK\",\"parent.frames[3].frames[0].document.frmChildPackdtls\",\"\",\"parent.parent.frames[0].document.forms[0]\",";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =");\n\t\n</script>\n\t<script>alignHeading_BasePrice();</script>\n</form>\n</body>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</html>\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	try
	{
		String dateFormat = "dd/MM/yyyy HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar c = Calendar.getInstance();
		System.out.println("PkgdefBasePrice 1-->"+sdf.format(c.getTime()));
		String locale			     = (String)session.getAttribute("LOCALE");
		String facilityId		     = (String) session.getValue( "facility_id" ) ;
		String fromDate              ="";
		String copyFrm_pkgCode		=	"" ;
		copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
		int  totRec				     = 1;
		HashMap childPackages		 = new HashMap();
		HashMap childPackdtl		 = new HashMap();
		ArrayList dtlsArray	      	 =	new ArrayList();
		ArrayList child_pkgcode	 	 =	new ArrayList();
		ArrayList child_pkgdesc	 	 =	new ArrayList();
		ArrayList child_effFromDate	 =	new ArrayList();
		ArrayList child_effToDate	 =	new ArrayList();
		ArrayList flag	 =	new ArrayList();

															   
		CurrencyFormat cf        = new CurrencyFormat();
		//String packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		 fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		String fromDateTemp = "";
		String fromDateVals			 = request.getParameter("fromDateVals")==null ? "" :request.getParameter("fromDateVals") ;
	    String	mode					 = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		System.out.println("authorized -After bl_rateBasedPkgDefBean-->"+authorized);
		String modifyStatus = "";
		String status = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";

		String bean_id		     = "bl_PkgDefBean" ;
		String bean_name	     = "eBL.PkgDefBean";
		String flagVal           = "insert";
		PkgDefBean bean		     = (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		
		String childPack_code="", childPack_desc="",childPack_effFrm="", childPack_effTo="";
		String packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		System.out.println("PkgdefBasePrice -After PACKAGE_PRICE-->"+sdf.format(c.getTime()));
		
		childPackages	=  (HashMap)bean.getChildPackages();
		//System.out.println("jsadja"+childPackdtl.containsKey(fromDate));
	if(childPackages.containsKey(packageCode))
		{
			childPackdtl	= (HashMap)childPackages.get(packageCode);
			System.out.println("jsadja"+childPackdtl.containsKey(fromDate));
		}
		
		if(mode.equals("modify") && !(childPackdtl.containsKey(fromDate))) {	
	
		bean.setDBValues("CHILD_PACK",packageCode,locale,facilityId,"","",fromDate);//set database values to bean.
		childPackages	=  (HashMap)bean.getChildPackages();
	}
	if(mode.equals("insert") && !copyFrm_pkgCode.equals("")){
			bean.setDBValues("CHILD_PACK",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);//set database values to bean.		
	}
	
	if(childPackages.containsKey(packageCode))
	{
		childPackdtl	= (HashMap)childPackages.get(packageCode);
	}
	
			
		if(childPackdtl.containsKey(fromDate)){
		dtlsArray =(ArrayList)childPackdtl.get(fromDate);
		
				if(childPackages.containsKey(packageCode)){
				if(dtlsArray.size()>0)
				{							   
						child_pkgcode=(ArrayList)dtlsArray.get(0);
						child_pkgdesc=(ArrayList)dtlsArray.get(1);
						child_effFromDate=(ArrayList)dtlsArray.get(2);
						child_effToDate=(ArrayList)dtlsArray.get(3);
						flag=(ArrayList)dtlsArray.get(4);

				}
				
				}
		}
		System.out.println("PkgdefBasePrice -After Assigning-->"+sdf.format(c.getTime()));
		
		//if(totRec ==1 ) flagVal = "insert"; 		
		System.out.println("date format 3-->"+sdf.format(c.getTime()));
		//Karthik added code here MMS-CRF-0023 Starts
		String strChargeLogic="N";
		Connection con= ConnectionManager.getConnection(request);
		PreparedStatement pstmtChrg = con.prepareStatement("select NVL(CHARGE_LOGIC_YN,'N')  from bl_parameters where OPERATING_FACILITY_ID =?");
		pstmtChrg.setString(1,facilityId);
		ResultSet rsChrg = pstmtChrg.executeQuery() ;
		if( rsChrg != null ) 
		{	
			while( rsChrg.next() )
			{  
				strChargeLogic = rsChrg.getString(1);
				if(strChargeLogic==null){
				strChargeLogic="N";
				}
			}
		}
		if (rsChrg != null) rsChrg.close();
		if (pstmtChrg!=null) pstmtChrg.close();
		//Karthik added code here MMS-CRF-0023 Ends
		System.out.println("date format 4-->"+sdf.format(c.getTime()));
		if(child_pkgcode.size() >0)
				totRec = child_pkgcode.size();	
			System.out.println("date format 4-->"+totRec);
			
			String table_name="frmChildPackdtls";
			String key="CHILD_PACK";
			System.out.println("flagVal1111111111"+flagVal);
			
				
		

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

		for(int i=0; i<totRec; i++)
	{	
	
	if((child_pkgcode !=null) && child_pkgcode.size()>0)
	{
		childPack_code = (String)(child_pkgcode.get(i)==null?"":child_pkgcode.get(i));
		childPack_desc = (String)(child_pkgdesc.get(i)==null?"":child_pkgdesc.get(i));
		childPack_effFrm = (String)(child_effFromDate.get(i)==null?"":child_effFromDate.get(i));
		childPack_effTo   = (String)(child_effToDate.get(i)==null?"":child_effToDate.get(i));
		flagVal	 = (String)(flag.get(i)==null ? "insert" : flag.get(i));
		System.out.println("PkgdefBasePrice -Before Values-->"+flagVal);
	}
	System.out.println("flagVal-->"+flagVal);
	System.out.println("PkgdefBasePrice -Before Values-->"+sdf.format(c.getTime()));
	if("modify".equals(flagVal)){
				
				status="disabled";
			}
			else{
				
			status="enabled";
			
			}
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(status));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(childPack_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(childPack_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(status));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(status));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(childPack_effFrm));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(status));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(childPack_effTo));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(flagVal));
            _bw.write(_wl_block52Bytes, _wl_block52);
} 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(totRec));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strChargeLogic));
            _bw.write(_wl_block57Bytes, _wl_block57);

//out.flush();
System.out.println("PkgdefBasePrice -Before updateCurrentForm-->");
System.out.println("PkgdefBasePrice -Before updateCurrentForm-->");

	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totRec));
            _bw.write(_wl_block59Bytes, _wl_block59);
putObjectInBean(bean_id,bean,request);
            _bw.write(_wl_block60Bytes, _wl_block60);

}
catch(Exception e)
{
	System.out.println("Exception from Package Base Price :"+e);
	e.printStackTrace();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
